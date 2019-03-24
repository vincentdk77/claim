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

<html:html locale="true">
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

	<form name=fm action="/claim/jobManagerSave.do" method="post"
		onsubmit="return validateForm(this,'Driver','');">
		<!--  ��ҳǩ-->
		<div class="tab">
			<!--ҳǩͷ-->
			<div class="formtitle">�����Ϣ</div>

			<div class="tab_box">
				<div id="schedulMain">
					<table id="tab" name="tab" style="table-layout: fixed; margin-bottom: 0px;border-collapse:collapse;background-color: #F7F7F7;" class="common" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
						<tr class="textc">
							<td class="title" style="width: 10%">
								����
							</td>
							<td class='title' style="width: 10%">
								�������
							</td>
							<td class='title' style="width: 10%">
								��ҵ����
							</td>
							<td class='title' style="width: 10%">
								�鿱��Ա
							</td>
							<td class='title' style="width: 10%">
								��ϵ�绰
							</td>
							<td class='title' style="width: 10%">
								������ɫ
							</td>
							<td class='title' style="width: 10%">
								���ɹ�����
							</td>
							<td class='title' style="width: 10%">
								�ɹ�
							</td>
						</tr>
						<logic:iterate id="prpljobmanagerDto" name="prpljobmanagerDtoList" indexId="status">
							<tr>
								<logic:equal value="0" name="status">
									<td rowspan="${countList}">
										${time}
									</td>
								</logic:equal>
								<td>
									<logic:equal value="AM" name="prpljobmanagerDto" property="datetype">�װ�</logic:equal>
									<logic:equal value="PM" name="prpljobmanagerDto" property="datetype">ҹ��</logic:equal>
								</td>
								<td>
									${prpljobmanagerDto.areaName}
								</td>
								<td>
									${prpljobmanagerDto.handlername}
								</td>
								<td>
									${prpljobmanagerDto.tel}
								</td>
								<td>
									<logic:equal value="12" name="prpljobmanagerDto" property="jobrole">����鿱<p>���˲鿱</p></logic:equal>
									<logic:equal value="1" name="prpljobmanagerDto" property="jobrole">����鿱</logic:equal>
									<logic:equal value="2" name="prpljobmanagerDto" property="jobrole">���˲鿱</logic:equal>
									<logic:equal value="3" name="prpljobmanagerDto" property="jobrole">�ǳ��鿱</logic:equal>
								</td>
								<td>
									${prpljobmanagerDto.checkCount}
								</td>
								<td>
									<input type="checkbox" id="checkObj" name="checkObj" onclick="parentHtml(this)">
									<input type="hidden" id="handlername" name="handlername" value="${prpljobmanagerDto.handlername}">
									<input type="hidden" id="handlercode" name="handlercode" value="${prpljobmanagerDto.handlercode}">
									<!-- <input type="hidden" id="scheduleType" name="scheduleType" value="${scheduleType}"> -->
								</td>
							</tr>
						</logic:iterate>
						<tr>
							<td colspan="8" class="textc">�װ�8��00��18��00��ҹ��18��00��8��00�������ʱ�䣬�����յ�ʱ�䣩��</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="outcontainer" name="submitDiv">
			<div id=content_basic>
				<table align="center" id="buttonTable">
					<tr>
						<td>
							<input type="button" id="backButton" class="button" value="����" onclick="window.close();">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
<script>
	function parentHtml(obj){
		var inputObj = $(obj).parent().find("input");
		var handlername = "";
		var handlercode = "";
		//var scheduleType = ""
		for(var i=0;i<inputObj.length;i++){
			if(inputObj[i].name=='handlername'){
				handlername = inputObj[i].value;
			}
			if(inputObj[i].name=='handlercode'){
				handlercode = inputObj[i].value;
			}
		}
		var w=window.dialogArguments;
		w.document.getElementsByName('nextHandlerCode1')[0].value=handlercode;
		w.document.getElementsByName('nextHandlerName1')[0].value=handlername;
		window.close();
	}
</script>
</html:html>