<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<%
	//start获得代码版本号
	String versionType = "";
	String versionNo = "";
	BLPrpCmain blPrpCmain = new BLPrpCmain();
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
	blPrpCmain.getData(request.getParameter("policyNo"));
	if (blPrpCmain.getSize() == 1) {
		prpCmainSchema = blPrpCmain.getArr(0);
		if (!(prpCmainSchema.getVersionNo() == null || prpCmainSchema
		.getVersionNo() == "")) {
			versionType = prpCmainSchema.getVersionNo().substring(0, 1);
			versionNo = prpCmainSchema.getVersionNo();
		}
	}
	//end获得代码版本号
%>
<html:html locale="true">
<head>
<app:css />
<title>保单关联信息</title>
<script src="/claim/common/js/showpage.js"> </script>
<html:base />
<script language="javascript">
		//显示保单
		function showPolicy(strPolicyNo,strRiskCode){
			  var CoreWebUrl=fm.txtCoreWebUrl.value;
				var versionType = fm.versionType.value;
				var versionNo = fm.versionNo.value;
				var vURL = "";
			  if("A01" == versionNo || versionNo == "" )
	 			{
		    		vURL = CoreWebUrl +'/' + strRiskCode + '/tbcbpg/UIPrPoEn' + strRiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ strPolicyNo+'&RiskCode='+ strRiskCode;
		    	}
			    else
			    {
			      vURL = CoreWebUrl +'/' + strRiskCode + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' + strRiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ strPolicyNo+'&RiskCode='+ strRiskCode;
			   
			    }
		    document.location.href = vURL;
		}
		
		//显示批单信息
		function showPrpHeadInfo(strBizNo,strRiskCode){
			  var CoreWebUrl=fm.txtCoreWebUrl.value;
				var versionType = fm.versionType.value;
				var versionNo = fm.versionNo.value;
				var vURL = "";
			  	if("A01" == versionNo || versionNo == "" )
	 			{
		    		vURL = CoreWebUrl +'/' + strRiskCode + '/tbcbpg/UIPrPoEn' + strRiskCode + 'Show.jsp?BIZTYPE=ENDORSE&BizNo='+strBizNo+'&SHOWTYPE=SHOW&RiskCode='+strRiskCode;//modify by kangzhen 061129
			     }
			    else
			    {
			     vURL = CoreWebUrl +'/' + strRiskCode + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' + strRiskCode + 'Show.jsp?BIZTYPE=ENDORSE&BizNo='+strBizNo+'&SHOWTYPE=SHOW&RiskCode='+strRiskCode;//modify by kangzhen 061129
		   		}
		    document.location.href = vURL;
		}
		
		//显示报案信息
		function showRegistInfo(strRegistNo,strRiskCode){
		    var vURL = '<%=request.getContextPath()%>/registFinishQueryList.do?prpLregistRegistNo=' + strRegistNo + '&riskCode=' + strRiskCode + '&editType=SHOW&ifclose=true';
		    document.location.href = vURL;
		}
		
		//显示流程图信息
		function showWorkFlower(strWorkFlowId){
		    var vURL = "/claim/swfFlowBeforeQuery.do?swfLogFlowID="+strWorkFlowId+"&ifclose=true";
		    if(hasSVG()){
		    	vURL += "&svgFlag=1";
			}else{
				vURL += "&svgFlag=0";
			}
		    document.location.href = vURL;
		}
		function hasSVG(){
	  		SVG_NS = 'http://www.w3.org/2000/svg';
			return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
	  	}
	</script>
</head>
<%
	//取核心系统的地址
	String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
%>
<logic:equal name="prpCmainDto" property="startHour" value="0">
	<bean:define id="startHour" value="零时起 至" />
</logic:equal>
<logic:equal name="prpCmainDto" property="startHour" value="12">
	<bean:define id="startHour" value="十二时起 至" />
</logic:equal>
<logic:equal name="prpCmainDto" property="startHour" value="24">
	<bean:define id="startHour" value="二十四时起 至" />
</logic:equal>
<logic:equal name="prpCmainDto" property="endHour" value="0">
	<bean:define id="endHour" value="零时止" />
</logic:equal>
<logic:equal name="prpCmainDto" property="endHour" value="12">
	<bean:define id="endHour" value="十二时止" />
</logic:equal>
<logic:equal name="prpCmainDto" property="endHour" value="24">
	<bean:define id="endHour" value="二十四时止" />
</logic:equal>

<body>
<form name="fm" action="/claim/registBeforeQuery.do" method="post">
<input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
<input type="hidden" name="versionType" value="<%= versionType %>">
<input type="hidden" name="versionNo" value="<%= versionNo %>">
<table class="common" cellpadding="4" cellspacing="1">
	<tr>
		<td colspan="2" class="formtitle">保单信息</td>
	</tr>
	<tr>
		<td class="title" align="center" width="10%">保单号</td>
		<td class="input" align="center" width="90%"><a
			href="javascript:showPolicy('<bean:write name="prpCmainDto" property="policyNo"/>','<bean:write name="prpCmainDto" property="riskCode"/>')">
		<bean:write name="prpCmainDto" property="policyNo" /> </a></td>
	<tr>
		<td class="title" align="center">保险期限</td>
		<td class="input" align="center"><bean:write name="prpCmainDto"
			property="startDate" /> <bean:write name="startHour" /> <bean:write
			name="prpCmainDto" property="endDate" /> <bean:write name="endHour" />
		</td>
	</tr>
	<tr>
		<td class="title" align="center">被保人</td>
		<td class="input" align="center"><bean:write name="prpCmainDto"
			property="insuredName" /></td>
	</tr>
</table>
<table class="common" cellpadding="3" cellspacing="1">
	<tr>
		<td colspan="5" class="formtitle">批单信息</td>
	</tr>
	<tr>
		<td class="centertitle">序号</td>
		<td class="centertitle">批单号码</td>
		<td class="centertitle">核批完成日期</td>
	</tr>
	<logic:empty name="headList">
		<tr class=listeven>
			<td align="center" colspan="3">无批单</td>
		</tr>
	</logic:empty>
	<logic:notEmpty name="headList">
		<logic:iterate id="head" name="headList" indexId="index">
			<tr class=listeven>
				<td align="center"><%=index.intValue() + 1%></td>
				<td align="center"><a
					href="javascript:showPrpHeadInfo('<bean:write name="head" property="endorseNo"/>','<bean:write name="head" property="riskCode"/>')">
				<bean:write name="head" property="endorseNo" /> </a></td>
				<td align="center"><bean:write name="head"
					property="underWriteEndDate" /></td>
			<tr>
		</logic:iterate>
	</logic:notEmpty>
</table>
<table class="common" cellpadding="4" cellspacing="1">
	<tr>
		<td colspan="5" class="formtitle">理赔信息</td>
	</tr>
	<tr>
		<td class="centertitle">序号</td>
		<td class="centertitle">报案号</td>
		<td class="centertitle">出险时间</td>
		<td class="centertitle">赔付金额</td>
		<td class="centertitle">流程图</td>
	</tr>
	<logic:empty name="registList">
		<tr class=listeven>
			<td align="center" colspan="5">无理赔信息</td>
		</tr>
	</logic:empty>
	<logic:notEmpty name="registList">
		<logic:iterate id="regist" name="registList" indexId="index">
			<tr class=listeven>
				<td align="center"><%=index.intValue() + 1%></td>
				<td align="center"><a
					href="javascript:showRegistInfo('<bean:write name="regist" property="registNo"/>','<bean:write name="regist" property="riskCode"/>')">
				<bean:write name="regist" property="registNo" /> </a></td>
				<td align="center"><bean:write name="regist"
					property="damageStartDate" /></td>
				<td align="center"><bean:write name="regist"
					property="compensateFeeDto.sumPaid" /></td>
				<td align="center"><a
					href="javascript:showWorkFlower('<bean:write name="regist" property="workFlowId"/>')">
				查看 </a></td>
			<tr>
		</logic:iterate>
	</logic:notEmpty>
</table>
</form>
</body>
</html:html>
