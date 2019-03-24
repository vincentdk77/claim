<%--
****************************************************************************
* DESC       ： 获得自负额
* AUTHOR     ：中国大地项目组
* CREATEDATE ： 2004-05-20
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>                                  

<%-- 引入bean类部分 --%>
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
    out.println("window.status='没有查询到自负额';");
  }
%> 
    var tempFrame = parent.document.frames("fraInterface");
    tempFrame.fm.target="interface"; 
    tempFrame.fm.prpLlossDtoSumRest[<%= index %>].value  = "<%=dblValue%>";      
    tempFrame.fm.prpLlossDtoSumRealPay[<%= index %>].value  = "<%=dblValue*(-1)%>";
    tempFrame.calFund();
</script>
