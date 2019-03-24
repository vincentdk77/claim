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
	//start��ô���汾��
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
	//end��ô���汾��
%>
<html:html locale="true">
<head>
<app:css />
<title>����������Ϣ</title>
<script src="/claim/common/js/showpage.js"> </script>
<html:base />
<script language="javascript">
		//��ʾ����
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
		
		//��ʾ������Ϣ
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
		
		//��ʾ������Ϣ
		function showRegistInfo(strRegistNo,strRiskCode){
		    var vURL = '<%=request.getContextPath()%>/registFinishQueryList.do?prpLregistRegistNo=' + strRegistNo + '&riskCode=' + strRiskCode + '&editType=SHOW&ifclose=true';
		    document.location.href = vURL;
		}
		
		//��ʾ����ͼ��Ϣ
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
	//ȡ����ϵͳ�ĵ�ַ
	String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
%>
<logic:equal name="prpCmainDto" property="startHour" value="0">
	<bean:define id="startHour" value="��ʱ�� ��" />
</logic:equal>
<logic:equal name="prpCmainDto" property="startHour" value="12">
	<bean:define id="startHour" value="ʮ��ʱ�� ��" />
</logic:equal>
<logic:equal name="prpCmainDto" property="startHour" value="24">
	<bean:define id="startHour" value="��ʮ��ʱ�� ��" />
</logic:equal>
<logic:equal name="prpCmainDto" property="endHour" value="0">
	<bean:define id="endHour" value="��ʱֹ" />
</logic:equal>
<logic:equal name="prpCmainDto" property="endHour" value="12">
	<bean:define id="endHour" value="ʮ��ʱֹ" />
</logic:equal>
<logic:equal name="prpCmainDto" property="endHour" value="24">
	<bean:define id="endHour" value="��ʮ��ʱֹ" />
</logic:equal>

<body>
<form name="fm" action="/claim/registBeforeQuery.do" method="post">
<input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
<input type="hidden" name="versionType" value="<%= versionType %>">
<input type="hidden" name="versionNo" value="<%= versionNo %>">
<table class="common" cellpadding="4" cellspacing="1">
	<tr>
		<td colspan="2" class="formtitle">������Ϣ</td>
	</tr>
	<tr>
		<td class="title" align="center" width="10%">������</td>
		<td class="input" align="center" width="90%"><a
			href="javascript:showPolicy('<bean:write name="prpCmainDto" property="policyNo"/>','<bean:write name="prpCmainDto" property="riskCode"/>')">
		<bean:write name="prpCmainDto" property="policyNo" /> </a></td>
	<tr>
		<td class="title" align="center">��������</td>
		<td class="input" align="center"><bean:write name="prpCmainDto"
			property="startDate" /> <bean:write name="startHour" /> <bean:write
			name="prpCmainDto" property="endDate" /> <bean:write name="endHour" />
		</td>
	</tr>
	<tr>
		<td class="title" align="center">������</td>
		<td class="input" align="center"><bean:write name="prpCmainDto"
			property="insuredName" /></td>
	</tr>
</table>
<table class="common" cellpadding="3" cellspacing="1">
	<tr>
		<td colspan="5" class="formtitle">������Ϣ</td>
	</tr>
	<tr>
		<td class="centertitle">���</td>
		<td class="centertitle">��������</td>
		<td class="centertitle">�����������</td>
	</tr>
	<logic:empty name="headList">
		<tr class=listeven>
			<td align="center" colspan="3">������</td>
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
		<td colspan="5" class="formtitle">������Ϣ</td>
	</tr>
	<tr>
		<td class="centertitle">���</td>
		<td class="centertitle">������</td>
		<td class="centertitle">����ʱ��</td>
		<td class="centertitle">�⸶���</td>
		<td class="centertitle">����ͼ</td>
	</tr>
	<logic:empty name="registList">
		<tr class=listeven>
			<td align="center" colspan="5">��������Ϣ</td>
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
				�鿴 </a></td>
			<tr>
		</logic:iterate>
	</logic:notEmpty>
</table>
</form>
</body>
</html:html>
