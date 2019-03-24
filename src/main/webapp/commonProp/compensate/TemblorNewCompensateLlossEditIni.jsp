<%--
****************************************************************************
* DESC       ： 新标的信息刷新页面
* AUTHOR     ： 国元项目组
* CREATEDATE ： 2011-11-31
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html;charset=gb2312"%>    
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@page import="com.sinosoft.claim.dto.custom.*" %>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.gyic.claim.dto.domain.TemblorsettlelistDto"%>
<%  
  PrpLlossDto prpLlossDto = (PrpLlossDto)request.getAttribute("prpLlossDto");
  String  coinsFlag = (String)request.getAttribute("coinsFlag");
  int count = prpLlossDto.getPrpLlossList().size();
  PrpLlossDto prpLlossDto1=null;
%>
<script language="javascript">
function loadCompensateLoss(){
<%
  int i=1;
  if (prpLlossDto.getPrpLlossList() != null) {
    Iterator iterator1 = prpLlossDto.getPrpLlossList().iterator();
    while (iterator1.hasNext()) {
      prpLlossDto1 = (PrpLlossDto) iterator1.next();
      String riskcode = prpLlossDto1.getRiskCode();
    
%>

          insertRow('LossDetail','LossDetail_Data');
          fm.prpLlossDtoItemKindNo[<%=i %>].value           = '<%=prpLlossDto1.getItemKindNo()%>';
          fm.prpLlossDtoItemCode[<%=i %>].value             = '<%=prpLlossDto1.getItemCode()%>';
          fm.prpLlossDtoKindCode[<%=i %>].value             = '<%=prpLlossDto1.getKindCode()%>';
          fm.prpLlossDtoKindName[<%=i %>].value             = '<%=prpLlossDto1.getKindName()%>';
          fm.prpLlossDtoLossName[<%=i %>].value             = '<%=prpLlossDto1.getLossName()%>';
          fm.prpLlossDtoAmount[<%=i %>].value               = '<%=new DecimalFormat("##0.00").format(prpLlossDto1.getAmount())%>';
          fm.prpLlossDtoSumLoss[<%=i %>].value              = '<%=new DecimalFormat("##0.00").format(prpLlossDto1.getSumLoss()  )%>';
          fm.prpLlossDtoClaimRate[<%=i %>].value            = '<%=prpLlossDto1.getClaimRate()%>';
          
          <%if(prpLlossDto1.getIndemnityDutyRate()>=80 && !"3224".equals(riskcode)){%>
          fm.prpLlossDtoDeductibleRate[<%=i %>].value       = '<%=0.0%>';
          <%}else{%>
          fm.prpLlossDtoDeductibleRate[<%=i %>].value       = '<%=prpLlossDto1.getDeductibleRate()%>';
          <%}%>
          fm.indemnityDutyRate[<%=i %>].value               = '<%=prpLlossDto1.getIndemnityDutyRate()%>';
          fm.prpLlossDtoSettleArea[<%=i %>].value           = '<%=new DecimalFormat("##0.00").format(prpLlossDto1.getSettleArea())%>';
          fm.prpLlossDtoSumRealPay[<%=i %>].value           = '<%=new DecimalFormat("##0.00").format(prpLlossDto1.getSumRealPay())%>';
          <%if((coinsFlag.equals("1")||coinsFlag.equals("2"))&&(new DecimalFormat("##0.00").format(prpLlossDto1.getCoinsSumRealPaid())!=null)){%>
          fm.prpLlossDtoCoinsSumRealPay[<%=i %>].value           = '<%=new DecimalFormat("##0.00").format(prpLlossDto1.getCoinsSumRealPaid())%>';
          <%}%>
<%
          i++;
    }
  }
%>
}
</script>