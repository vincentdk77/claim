<%--
****************************************************************************
* DESC       �� ���������
* AUTHOR     ��liubvo
* CREATEDATE �� 2005-03-02
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>                                   

<%-- ����bean�ಿ�� --%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
 
<script> 
<%                           
System.out.println("---1-----DAAGetDeductibleRateSubmit.jsp---");                                   
  String strType           = request.getParameter("Type");  
  String strClauseTypeCode = request.getParameter("prpLcompensateClauseTypeCode");
  String strKindCode       = request.getParameter("KindCode");  
  String strIndemnityDuty  = request.getParameter("prpLcompensateIndemnityDuty");
  String strDeductibleTerm = request.getParameter("prpLcompensateDeductCond");
  String strEscapeFlag     = request.getParameter("prpLcompensateEscapeFlag");
  String strRiskCode       = request.getParameter("prpLcompensateRiskCode"); 
  String index       = request.getParameter("Index"); 
  double dblDeductibleRate = 0;
  try
  {
    DAACompensateViewHelper dAACcompensateViewHelper = new DAACompensateViewHelper();
    System.out.println(strClauseTypeCode+"|"+strKindCode+"|"+strIndemnityDuty+"|"+strDeductibleTerm+"|"+strEscapeFlag+"|"+strRiskCode+"|value:"+dblDeductibleRate); 
    dblDeductibleRate = dAACcompensateViewHelper.getRate(strClauseTypeCode,strKindCode,strIndemnityDuty,strDeductibleTerm,strEscapeFlag,strRiskCode);
    //dblDeductibleRate = Double.parseDouble(chgData.chgStrZero(String.valueOf(blPrpDdeductCond.getRate(strClauseTypeCode,strKindCode,strIndemnityDuty,strDeductibleTerm,strEscapeFlag,strRiskCode))));
  } 
  catch(Exception e)
  {
    e.printStackTrace();
    out.println("window.status='û�в�ѯ����Ӧ��������';");
  }

%>
  var tempFrame = parent.document.frames("fraInterface");
  tempFrame.fm.target="interface";
<%  
  if(strType.equals("lLoss")) //�⸶���
  { 
%>
    tempFrame.fm.all("prpLlossDtoDeductibleRate")[<%= index %>].value  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLlossDtoDeductibleRate")[<%= index %>].oldValue  = "<%=dblDeductibleRate%>";
    tempFrame.calRealpay(tempFrame.fm.all("prpLlossDtoDeductibleRate")[<%= index %>]);  
<%                                                                      
  }
  else
  {
%>    
    tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>].value  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>].oldValue  = "<%=dblDeductibleRate%>";
    tempFrame.calRealpay2(tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>]);
<%      
  }
%>    
  //����һ��ִ��˳��
  //1.�ı��ձ������ִ��LossKindCode��onchange�¼�������ѯ�����ʵĹ��̺��������Ի�δ�����ȷ�������ʣ���ִ������һ����
  //2.ִ��LossKindCode��onblur�¼�,����UICodeGet.jsp��ִ����arrCodeCodeIndex = Str.split("0,"+coderelation,",")����������ִ����LossKindCode��onchange�¼���
  //  ͬ����ѯ�����ʵĹ��̺��������Ի�δ�����ȷ�������ʣ���ִ������һ����
  //3.ִ����UICodeGet.jsp�е�codetype.equals("KindCode3")���֣�����������������Ϊ0.0��
  //4.�����ձ�ı䶯������ʵ�ʼ�ֵ�ı䶯��ִ����ʵ�ʼ�ֵ��onchange�¼�����ִ����calRealpay()��������������Ϊ0.0���м��㣩��
  //5.���ڣ��������Ѿ��ɷ����ѯ�����ˣ������ڱ�ҳִ��tempFrame.calRealpay()����������ȷ�������ʽ��м��㣩��
</script> 
