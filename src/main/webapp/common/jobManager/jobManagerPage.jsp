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

<html:html locale="true">
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

	<form name=fm action="/claim/jobManagerSave.do" method="post"
		onsubmit="return validateForm(this,'Driver','');">
		<!--  加页签-->
		<div class="tab">
			<!--页签头-->
			<div class="formtitle">班表信息</div>

			<div class="tab_box">
				<div id="schedulMain">
					<table id="tab" name="tab" style="table-layout: fixed; margin-bottom: 0px;border-collapse:collapse;background-color: #F7F7F7;" class="common" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
						<tr class="textc">
							<td class="title" style="width: 10%">
								日期
							</td>
							<td class='title' style="width: 10%">
								班次名称
							</td>
							<td class='title' style="width: 10%">
								作业区域
							</td>
							<td class='title' style="width: 10%">
								查勘人员
							</td>
							<td class='title' style="width: 10%">
								联系电话
							</td>
							<td class='title' style="width: 10%">
								工作角色
							</td>
							<td class='title' style="width: 10%">
								已派工数量
							</td>
							<td class='title' style="width: 10%">
								派工
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
									<logic:equal value="AM" name="prpljobmanagerDto" property="datetype">白班</logic:equal>
									<logic:equal value="PM" name="prpljobmanagerDto" property="datetype">夜班</logic:equal>
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
									<logic:equal value="12" name="prpljobmanagerDto" property="jobrole">车物查勘<p>人伤查勘</p></logic:equal>
									<logic:equal value="1" name="prpljobmanagerDto" property="jobrole">车物查勘</logic:equal>
									<logic:equal value="2" name="prpljobmanagerDto" property="jobrole">人伤查勘</logic:equal>
									<logic:equal value="3" name="prpljobmanagerDto" property="jobrole">非车查勘</logic:equal>
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
							<td colspan="8" class="textc">白班8：00～18：00，夜班18：00～8：00（含起点时间，不含终点时间）。</td>
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
							<input type="button" id="backButton" class="button" value="返回" onclick="window.close();">
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