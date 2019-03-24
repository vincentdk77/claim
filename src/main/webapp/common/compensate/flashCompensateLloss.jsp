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
<%@page import="com.gyic.claim.dto.domain.PlantingsettlelistDto"%>
<%	
	List prpCompensateLossList = (List)request.getAttribute("prpCompensateLossList");
  String DeductibleRate=(String)request.getAttribute("DeductibleRate");
  String totalLossRate=(String)request.getAttribute("TotalLossRate");
  double douTotalLossRate = 80;
  if(null!= totalLossRate && !"".equals(totalLossRate)){
  	douTotalLossRate = Double.parseDouble(totalLossRate);
  	if(0==douTotalLossRate)
  		douTotalLossRate = 100;
  }
  String DamageInsured=(String)request.getAttribute("DamageInsured");
  String Flag=(String)request.getAttribute("Flag");
  String ItemCode=(String)request.getAttribute("ItemCode");
  int itemKindNo=(Integer)request.getAttribute("itemKindNo");
  String NoProductionArea=(String)request.getAttribute("NoProductionArea");
  PrpLcompensateDto prpLcompensateDto=(PrpLcompensateDto)request.getAttribute("prpLcompensateDto");
  String SettleAreaAll=(String)request.getAttribute("SettleAreaAll");
  String KindName=(String)request.getAttribute("KindName");
  String LossName=(String)request.getAttribute("LossName");
	int count = prpCompensateLossList.size();
	PlantingsettlelistDto plantingsettlelistDto=null;
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
		plantingsettlelistDto=(PlantingsettlelistDto)prpCompensateLossList.get(i-1);
		
%>
<script>
          parent.fraInterface.insertRow('LossDetail','LossDetail_Data');
			    parent.fraInterface.fm.prpLlossDtoItemKindNo[<%=i %>].value           = '<%=itemKindNo%>';
			    parent.fraInterface.fm.prpLlossDtoKindName[<%=i %>].value             = '<%=KindName%>';
			    parent.fraInterface.fm.prpLlossDtoItemCode[<%=i %>].value             = '<%=ItemCode%>';
			    parent.fraInterface.fm.prpLlossDtoLossName[<%=i %>].value             = '<%=LossName%>';
			    parent.fraInterface.fm.prpLlossDtoKindCode[<%=i %>].value             = '<%=plantingsettlelistDto.getKindcode()%>';
			    parent.fraInterface.fm.prpLlossDtoAmount[<%=i %>].value               = '<%=plantingsettlelistDto.getSuminsured()%>';
			    parent.fraInterface.fm.prpLlossDtoSumLoss[<%=i %>].value              = '<%=plantingsettlelistDto.getSettlesum()%>';
			    parent.fraInterface.fm.prpLlossDtoClaimRate[<%=i %>].value            = '<%=plantingsettlelistDto.getClaimrate()%>';
			    <%if(plantingsettlelistDto.getLossrate()>=douTotalLossRate && !plantingsettlelistDto.getRiskcode().equals("3185")){%>
          parent.fraInterface.fm.prpLlossDtoDeductibleRate[<%=i %>].value       = '<%=0.0%>';
          <%}else{%>
          parent.fraInterface.fm.prpLlossDtoDeductibleRate[<%=i %>].value       = '<%=DeductibleRate%>';
          <%}%>
			    parent.fraInterface.fm.indemnityDutyRate[<%=i %>].value               = '<%=plantingsettlelistDto.getLossrate()%>';
			    parent.fraInterface.fm.prpLlossDtoSettleArea[<%=i %>].value           = '<%=new DecimalFormat("##0.00").format(plantingsettlelistDto.getSettlearea())%>';
			    parent.fraInterface.fm.prpLlossDtoSumRealPay[<%=i %>].value           = '<%=plantingsettlelistDto.getSettlesum()%>';
			    //parent.fraInterface.fm.prpLlossDtoSumRealPay[<%=i %>].onchange();
</script>
<%
		}
%>
<script>
         <%if(Flag.equals("1")){%>
         parent.fraInterface.fm.DamageInsured.value                             = '<%=Double.parseDouble(DamageInsured)%>'; 
         parent.fraInterface.fm.NoProductionArea.value                          = '<%=Double.parseDouble(NoProductionArea)%>'; 
         parent.fraInterface.fm.SettleAreaAll.value                             = '<%=Double.parseDouble(SettleAreaAll)%>'; 
         <%}else{%>       
         parent.fraInterface.fm.DamageInsured.value                             = '<%=Double.parseDouble(DamageInsured)%>';
         <%}%>
</script>
