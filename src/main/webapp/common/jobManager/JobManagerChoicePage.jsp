<%--
****************************************************************************
* DESC       �����Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��chengyupeng
* CREATEDATE ��2011-11-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<head>
	<!--��title����-->
	<title><bean:message key="title.registBeforeEdit.editRegist" /></title>
	<%-- ҳ����ʽ  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/js/showpage.js"> </script>
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
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
					��ʾ
				</td>
			</tr>
			<tr>
				<td class="title">
					�Ƿ������°��
				</td>
				
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="backButton" class="button" value="��" onclick="saveForm(this,'yes',true);">
					<input type="button" id="backButton" class="button" value="��" onclick="saveForm(this,'no',true);">
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
		alert("�����°����Ϣ��");
	</logic:equal>
</script>