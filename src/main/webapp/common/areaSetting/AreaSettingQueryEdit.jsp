
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%><%--
****************************************************************************
* DESC       ：区域设置/查询页面
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-11-23
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*" %>
<%
	UserDto user = (UserDto) request.getSession().getAttribute("user");
	String comCode = user.getComCode();
	String comCName = user.getComName();
%>
<head>
	<!--对title处理-->
	<title><bean:message key="title.registBeforeEdit.editRegist" /></title>
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<script src="/common/js/CodeSelect.js"></script>
	<script src="/common/js/showpage.js"> </script>
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body>
	<form name="fm" action="" method="post" target="showlist">
		<input type="hidden" id="editType" name="editType" value="" />
		<table cellpadding="0" cellspacing="0" class="common">
			<tr>
				<td colspan=4 class="formtitle">
					查询条件
				</td>
			</tr>
			<tbody>
				<tr>
					<td class='title' style="width: 10%">
						班表机构：
					</td>
					<td class='input' style="width: 35%">
						<input type=hidden class="codecode" name="handledept" id="handledept"
							style="width: 20%" title="具体单位" value="<%=comCode%>"
							ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onkeyup="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');">
						<input type=text class="codecode" name="deptname" id="deptname" title="具体单位"
							style="width: 100%" maxLength="50" description="新增班表单位" value="<%=comCName%>"
							ondblclick="open_CodeSelect(this,'jobComCode','<%=comCode%>','新增班表单位');"
							onkeyup="open_CodeSelect(this,'jobComCode','<%=comCode%>','新增班表单位');"
							onkeypress="window.event.keyCode = 0;" onchange="toChange(this,'2');">
					</td>
					<td class='title' style="width: 10%">
						被维护人：
					</td>
					<td class='input' style="width: 35%">
						<input type=hidden name="handlercode" id="handlercode" class="codecode"
							style="width: 100px" maxlength="10" title="操作员"
							value=""
							ondblclick="code_CodeSelect(this, 'CertaJobCode');"
							onkeyup="code_CodeSelect(this, 'CertaJobCode');"
							onblur="code_CodeChange(this, 'CertaJobCode','1','code','post','clear');">
						<input type=text name="handlername" id="handlername" class="codecode"
							style="width: 100%" title="操作员" maxlength="30"
							value=""
							ondblclick="code_CodeSelect(this, 'CertaJobCode','-1','name','none','post');"
							onkeyup="code_CodeSelect(this, 'CertaJobCode','-1','name','none','post');"
							onkeypress="window.event.keyCode = 0;" onchange="toChange(this,'1');">
					</td>
				</tr>
				<tr style="display:none">
					<td class='title' style="width: 10%">险类</td>
					<td class='input' style="width: 35%">
						<input type="text" name="classCode" value="99" >
					</td>
				</tr>
				<tr>
					<td align="center" class='title' colspan="4">
						<input type="button" id="backButtonQuery" class="button" value="查询" onclick="saveForm(this,'3',true);">
						<input type="button" id="backButton" class="button" value="新增" onclick="saveForm(this,'4',true);">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br />
	<iframe name="showlist" src="" height="100%" frameborder="0"
		marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
</body>
<script>
	function saveForm(obj,buttonId,shifter){
		//新增
		var editType = document.getElementById('editType');
		if(buttonId == '4'){
			var deptname = document.getElementById('deptname');
			if(deptname.value == "" || deptname.value == undefined){
				alert("请选择班表机构");
				deptname.focus();
				return false;
			}
			fm.action = "/claim/areaSettingEdit.do";
			editType.value="ADD";
			fm.target="_self";
			
			fm.submit();
			return true;
		}
		//查询
		if(buttonId == '3'){
			fm.action = "/claim/areaSettingQuery.do";
			editType.value="SHOW";
			fm.backButtonQuery.disabled=true;
			fm.submit();
			setTimeout('fm.backButtonQuery.disabled=false',5000);
			return true;
		}
	}
	function toChange(obj,id){
		if(id=='1'){
			if(obj.value == ""){
				document.getElementById('handlercode').value="";
			}
		}
		if(id=='2'){
			document.getElementById('handlercode').value="";
			document.getElementById('handlername').value="";
		}
	}
</script>