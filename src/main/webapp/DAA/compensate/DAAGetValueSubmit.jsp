<%--
****************************************************************************
* DESC       �� ����Ը���
* AUTHOR     ���й������Ŀ��
* CREATEDATE �� 2004-05-20
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>                                  

<%-- ����bean�ಿ�� --%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
 
<script>
<%                                                              
  String strKindCode       = request.getParameter("KindCode");  
  String strRiskCode       = request.getParameter("RiskCode");
  String strPolicyNo       = request.getParameter("PolicyNo");
  String index       = request.getParameter("Index"); 
  String strCond           = "";
  double dblValue          = 0;

  try
  {
      UIPolicyAction uiPolicyAction = new UIPolicyAction();
      PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(strPolicyNo);
      List list = (ArrayList)policyDto.getPrpCitemKindDtoList();
      if(list.size() > 0){
        for(int i=0;i<list.size();i++){
            PrpCitemKindDto prpCitemKindDtoTemp = (PrpCitemKindDto)list.get(i); 
            if(prpCitemKindDtoTemp.getKindCode().equals(strKindCode)){
              dblValue = prpCitemKindDtoTemp.getValue();
             
            }
        }
      }
         

  }
  catch(Exception e)
  {
    e.printStackTrace();
    out.println("window.status='û�в�ѯ���Ը���';");
  }
%> 
    var tempFrame = parent.document.frames("fraInterface");
    tempFrame.fm.target="interface"; 
    tempFrame.fm.prpLlossDtoSumRest[<%= index %>].value  = "<%=dblValue%>";      
    tempFrame.fm.prpLlossDtoSumRealPay[<%= index %>].value  = "<%=dblValue*(-1)%>";
    tempFrame.calFund();
</script>
