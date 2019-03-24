<%--
****************************************************************************
* DESC       ：班表登记录入/修改页面
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-11-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<head>
	<!--对title处理-->
	<title><bean:message key="title.registBeforeEdit.editRegist" /></title>
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/js/showpage.js"> </script>
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>

<body>
	<form name="fm" action="/claim/jobManagerEdit.do" method="post" onsubmit="">
		<input type="hidden" id="editType" name="editType" value="ADD"/>
		<input type="hidden" id="inputButton" name="inputButton" value=""/>
		<input type="hidden" id="month" name="month" value="${month}"/>
		<input type="hidden" id="handledept" name="handledept" value="${handledept}"/>
		<input type="hidden" id="deptname" name="deptname" value="${deptname}"/>
		<input type="hidden" id="classCode" name="classCode" value="${classCode}"/>
		<input type="hidden" id="systemCode" name="systemCode" value="${systemCode}"/>
		<table cellpadding="0" cellspacing="0" class="common">
			<tr>
				<td class="formtitle">
					提示
				</td>
			</tr>
			<tr>
				<td class="title">
					是否复制上月班表？
				</td>
				
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="backButton" class="button" value="是" onclick="saveForm(this,'yes',true);">
					<input type="button" id="backButton" class="button" value="否" onclick="saveForm(this,'no',true);">
				</td>
			</tr>
		</table>
	</form>
</body>
<script>
	function saveForm(obj,buttonId,shifter){
		document.getElementById('inputButton').value = buttonId;
		fm.submit();
		return true;
	}
	<logic:equal value="no" name="status">
		alert("无上月班表信息！");
	</logic:equal>
</script>