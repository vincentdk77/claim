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
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="java.util.*"%>

 
<script> 
<%                           
  String modeCode = "";
  double dblDeductibleRate = 0;
  double dblDutyDeductibleRate = 0;
  double dblMainKindDeductibleRate = 0;
  //���Ӽ�ʻԱ������
  double dblDriverDeductibleRate = 0;
  String mainKind = "";
  ArrayList prpCitemKindDtoList = new ArrayList();
  PolicyDto policyDto = new PolicyDto();
  
  String strType           = request.getParameter("Type");  
  String strClauseTypeCode = request.getParameter("prpLcompensateClauseTypeCode");
  String strKindCode       = request.getParameter("KindCode");  
  String strIndemnityDuty  = request.getParameter("prpLcompensateIndemnityDuty");
  String strIndemnityDutyRate = request.getParameter("prpLcompensateIndemnityDutyRate");
  String strDeductibleTerm = request.getParameter("prpLcompensateDeductCond");
  String strEscapeFlag     = request.getParameter("prpLcompensateEscapeFlag");
  String strRiskCode       = request.getParameter("prpLcompensateRiskCode"); 
  String index       = request.getParameter("Index"); 
  String strPolicyNo       = request.getParameter("prpLcompensatePolicyNo");
  String amount            = "";
  try
  {
    UIPolicyAction   uiPolicyAction = new UIPolicyAction();
    
    policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
    prpCitemKindDtoList = policyDto.getPrpCitemKindDtoList();
    Iterator ititemkind = prpCitemKindDtoList.iterator();
     while(ititemkind.hasNext())
     {
          PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)ititemkind.next();
          if(prpCitemKindDto.getKindCode().equals(strKindCode)) 
          {
              
                modeCode = prpCitemKindDto.getModeCode();
                amount   = String.valueOf(prpCitemKindDto.getAmount());
                break; 
          }     
     }
   
    //SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
    //dblDutyDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfAccident(strClauseTypeCode,strKindCode,strIndemnityDuty,strDeductibleTerm,strEscapeFlag,strRiskCode,modeCode);
    dblDutyDeductibleRate = UIDeductCondAction.getInstance().getDeductibleRateOfAccident(strRiskCode,strKindCode,strIndemnityDuty,modeCode,policyDto.getPrpCmainDto().getOperateDate().toString());
    
    //dblDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfAbsolute(strClauseTypeCode,strKindCode,strDeductibleTerm,strRiskCode);
    
    //dblDeductibleRate = UIDeductCondAction.getInstance().getDeductibleRateOfAbsolute(strClauseTypeCode,strKindCode,strRiskCode,)
    
     //���㸽�����������յľ���������
    if(strKindCode.equals("D2")||strKindCode.equals("D3")||strKindCode.equals("D4")||
       strKindCode.equals("Y")||strKindCode.equals("G0")||strKindCode.equals("L")||
       strKindCode.equals("Z")||strKindCode.equals("X")||strKindCode.equals("H"))
    {
        if(strKindCode.equals("D2")||strKindCode.equals("D3")||strKindCode.equals("D4")||strKindCode.equals("Y")||strKindCode.equals("H"))
        {
            mainKind = "B";
        }
        if(strKindCode.equals("G0")||strKindCode.equals("L")||strKindCode.equals("Z")||strKindCode.equals("X"))
        {
            mainKind = "A";
        }
        dblMainKindDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfAbsolute(strClauseTypeCode,mainKind,strDeductibleTerm,strRiskCode);
        System.out.println("�������յľ���������"+dblMainKindDeductibleRate);
    }   
    //�õ���ʻԱ������
    
    dblDriverDeductibleRate = sunnyCompensateViewHelper.getDeductibleRateOfDriver(strClauseTypeCode,strKindCode,strDeductibleTerm,strRiskCode);
    
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
    tempFrame.fm.all("prpLpersonLossIndemnityDutyRate")[<%= index %>].value  = "<%=strIndemnityDutyRate%>";
    tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>].value  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDutyDeductibleRate")[<%= index %>].value  = "<%=dblDutyDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDriverDeductibleRate")[<%= index %>].value  = "<%=dblDriverDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossMainKindDeductibleRate")[<%= index %>].value  = "<%=dblMainKindDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>].oldValue  = "<%=dblDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDutyDeductibleRate")[<%= index %>].oldvalue  = "<%=dblDutyDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossDriverDeductibleRate")[<%= index %>].oldvalue  = "<%=dblDriverDeductibleRate%>";
    tempFrame.fm.all("prpLpersonLossAmountTmp")[<%= index %>].value  = "<%=amount%>";
    tempFrame.calRealpay2ForSunny(tempFrame.fm.all("prpLpersonLossDeductibleRate")[<%= index %>]);
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
