
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%><%--
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
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<script src="/claim/common/jobManager/js/yeardate.js" ></script>
	<script src="/claim/common/js/CodeSelect.js" ></script>
	<script src="/claim/common/js/showpage.js" ></script>
  	<script src="/claim/js/WdatePicker.js"></script>
	<%
	UserDto user = (UserDto) request.getSession().getAttribute("user");
	String comCode = user.getComCode();
	String comName = user.getComName();
	%>
</head>

<body>
	<form name="fm" action="/claim/jobManagerEdit.do" method="post"
		onsubmit="">
		<input type="hidden" id="editType" name="editType" value="choicePage" />
		<input type="hidden" id="systemCode" name="systemCode" value="claim" />
		<table cellpadding="0" cellspacing="0" class="common">
			<tr>
				<td colspan=4 class="formtitle">
					查询条件
				</td>
			</tr>
			<tbody>
				<tr>
					<td class='title textr' style="width: 15%">
						班表机构：
					</td>
					<td class='input' style="width: 30%">
						<input type=hidden class="codecode" name="handledept"
							style="width: 20%" title="具体单位" value="<%=comCode%>"
							ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onkeyup="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');">
						<input type=text class="codecode" id="deptname" name="deptname" title="具体单位"
							style="width: 90%" maxLength="50" description="新增班表单位" value="<%=comName%>"
							ondblclick="open_CodeSelect(this,'jobComCode','<%=comCode%>','新增班表单位');"
							onkeyup="open_CodeSelect(this,'jobComCode','<%=comCode%>','新增班表单位');"
							onkeypress="window.event.keyCode = 0;">
						<font color="red">*</font>
					</td>
					<td class='title textr' style="width: 15%">
						班表月份：
					</td>
					<td>
						<input type="text" style="width:60%" name="month" readonly class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM'});" >
						<font color="red">*</font>
					</td>
					
				</tr>
				<tr>
					<td class='title' style="width: 15%">
						险类：
					</td>
					<td class="input" width="30%">
						<select name="classCode" style="width:90%">
							<option value="xx" checked="checked">请选择险类</option>
							<option value="31">种植保险类</option>
							<option value="32">养殖保险类</option>
							<option value="99">非农保险类</option>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="left" class='title'>
						<font color="red">红“*”为必录项。</font>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class="button" value="新增"
							onclick="saveForm(this,'4',true);">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
<script>
	function saveForm(obj,buttonId,shifter){
		if(buttonId == '4'){
			var deptname = fm.deptname;
			var month = fm.month;
			var classCode = fm.classCode;
			if(trim(deptname.value) == ""){
				alert("班表机构不能为空。");
				deptname.focus();
    			deptname.select();
				return false;
			}
			if(trim(month.value) == ""){
				alert("请选择班表月份。");
				month.focus();
				return false;
			}
			if(trim(classCode.value) == "xx"){
				alert("请选择险类。");
				return false;
			}
			fm.submit();
			return true;
		}else{
			fm.submit();
			return true;
		}
	}
	<logic:equal value="no" name="status">
		alert('${notice}');
	</logic:equal>
</script>