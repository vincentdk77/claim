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
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.gyic.claim.dto.domain.Planting31SettleListDto"%>
<%@page import="com.gyic.claim.utils.Planting31SettleExport"%>


<jsp:include page="/common/pub/StaticJavascript.jsp" />
<%	
	List prpCompensateLossList = (List)request.getAttribute("prpCompensateLossList");
  String DeductibleRate=(String)request.getAttribute("DeductibleRate");
  String damageInsured=(String)request.getAttribute("DamageInsured");
  String Flag=(String)request.getAttribute("Flag");
  Map itemCodeIndexMap = (Map)request.getAttribute("itemCodeIndexMap");
  String noProductionArea=(String)request.getAttribute("NoProductionArea");
  PrpLcompensateDto prpLcompensateDto=(PrpLcompensateDto)request.getAttribute("prpLcompensateDto");
  String settleAreaAll=(String)request.getAttribute("SettleAreaAll");
  Map totalLossRatePointMap = (Map)request.getAttribute("totalLossRatePointMap");
  Map deductibleRateMap = (Map)request.getAttribute("deductibleRateMap");
	int count = prpCompensateLossList.size();
	Planting31SettleListDto planting31SettleListDto=null;
%>
	<script>
	//删除多行
     var oTBODY   =  parent.fraInterface.document.all('LossDetail').tBodies.item(0);
	   var intCount =  parent.fraInterface.getRowsCount('LossDetail');
	  for(var i=0;i<intCount;i++)
	  {
	  	oTBODY.deleteRow(0);
	  }
	</script>

<%
	//插入行并赋值
	for(int i=1;i<=count;i++){
		planting31SettleListDto=(Planting31SettleListDto)prpCompensateLossList.get(i-1);
		String strTotalLossRate = String.valueOf(totalLossRatePointMap.get(""+planting31SettleListDto.getKindCode()+"_"+planting31SettleListDto.getItemCode()));
		double totalLossRate = 100;
		if(null!=strTotalLossRate && !"".equals(strTotalLossRate))
			totalLossRate = Double.parseDouble(strTotalLossRate)*100;
%>
<script>
          parent.fraInterface.insertRow('LossDetail','LossDetail_Data');
			    parent.fraInterface.fm.prpLlossDtoItemKindNo[<%=i %>].value           = '<%=itemCodeIndexMap.get(""+planting31SettleListDto.getKindCode()+"_"+planting31SettleListDto.getItemCode())%>';
			    parent.fraInterface.fm.prpLlossDtoKindName[<%=i %>].value             = '<%=Planting31SettleExport.getKindCodeName(planting31SettleListDto.getRiskCode(),planting31SettleListDto.getKindCode())%>';
			    parent.fraInterface.fm.prpLlossDtoItemCode[<%=i %>].value             = '<%=planting31SettleListDto.getItemCode()%>';
			    parent.fraInterface.fm.prpLlossDtoLossName[<%=i %>].value             = '<%=Planting31SettleExport.getItemCodeName(planting31SettleListDto.getRiskCode(),planting31SettleListDto.getItemCode())%>';
			    parent.fraInterface.fm.prpLlossDtoKindCode[<%=i %>].value             = '<%=planting31SettleListDto.getKindCode()%>';
			    parent.fraInterface.fm.prpLlossDtoAmount[<%=i %>].value               = '<%=new DecimalFormat("##0.00").format(planting31SettleListDto.getSumInsured())%>';
			    parent.fraInterface.fm.prpLlossDtoSumLoss[<%=i %>].value              = '<%=new DecimalFormat("##0.00").format(planting31SettleListDto.getSettleSum()  )%>';
			    parent.fraInterface.fm.prpLlossDtoClaimRate[<%=i %>].value            = '<%=planting31SettleListDto.getClaimRate()%>';
			    <%if(planting31SettleListDto.getLossRate()>=totalLossRate){%>
          parent.fraInterface.fm.prpLlossDtoDeductibleRate[<%=i %>].value       = '<%=0.0%>';
          <%}else{%>
          parent.fraInterface.fm.prpLlossDtoDeductibleRate[<%=i %>].value       = '<%=deductibleRateMap.get(""+planting31SettleListDto.getKindCode()+"_"+planting31SettleListDto.getItemCode())%>';
          <%}%>
			    parent.fraInterface.fm.indemnityDutyRate[<%=i %>].value               = '<%=planting31SettleListDto.getLossRate()%>';
			    parent.fraInterface.fm.prpLlossDtoSettleArea[<%=i %>].value           = '<%=new DecimalFormat("##0.00").format(planting31SettleListDto.getSettleArea())%>';
			    parent.fraInterface.fm.prpLlossDtoSumRealPay[<%=i %>].value           = '<%=new DecimalFormat("##0.00").format(planting31SettleListDto.getSettleSum())%>';
</script>
<%
		}
%>
<script>
         <%if(Flag.equals("1")){%>
	         parent.fraInterface.fm.DamageInsured.value                             = '<%=Double.parseDouble(damageInsured)%>'; 
	         parent.fraInterface.fm.NoProductionArea.value                          = '<%=Double.parseDouble(noProductionArea)%>'; 
	         parent.fraInterface.fm.SettleAreaAll.value                             = '<%=Double.parseDouble(settleAreaAll)%>'; 
         <%}else{%>
	         parent.fraInterface.fm.DamageInsured.value                             = '<%=Double.parseDouble(damageInsured)%>';
	         parent.fraInterface.fm.NoProductionArea.value                          = '<%=Double.parseDouble(noProductionArea)%>'; 
	         parent.fraInterface.fm.SettleAreaAll.value                             = '<%=Double.parseDouble(settleAreaAll)%>'; 
         <%}%>
</script>
