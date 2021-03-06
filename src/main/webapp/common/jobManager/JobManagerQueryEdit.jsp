
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
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
	<title><bean:message key="title.registBeforeEdit.editRegist" />
	</title>
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/showpage.js"> </script>
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/jobManager/js/yeardate.js"></script>
	<script src="/claim/js/WdatePicker.js"></script>
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
	<%
	UserDto user = (UserDto) request.getSession().getAttribute("user");
	String comCode = user.getComCode();
	%>
</head>

<body>
	<form name="fm" action="/claim/jobManagerQuery.do" method="post" onsubmit="" target="showlist">
		<input type="hidden" id="editType" name="editType" value="EDIT" />
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
					<td class='input' style="width: 25%">
						<input type=hidden class="codecode" name="handledept"
							style="width: 20%" title="具体单位" value=""
							ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onkeyup="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');">
						<input type=text class="codecode" name="deptname" title="具体单位"
							style="width: 100%" maxLength="50" description="新增班表单位" value=""
							ondblclick="open_CodeSelect(this,'jobComCode','<%=comCode%>','新增班表单位');"
							onkeyup="open_CodeSelect(this,'jobComCode','<%=comCode%>','新增班表单位');"
							onkeypress="window.event.keyCode = 0;">
					</td>
				
					<td class='title textr' style="width: 15%">
						班表月份：
					</td>
					<td>
						<input type="text" style="width:60%" name="month" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM'});" >
						<!-- 
						<input type="text" style="width:60%" name="month" class="Wdate"  onfocus="WdatePicker()">
						 -->
					</td>
				</tr>
				<tr>
					<td class='title' style="width: 15%">
						险类：
					</td>
					<td class="input" width="30%">
						<select name="classCode" style="width:100%">
							<option value="" checked="checked">请选择险类</option>
							<option value="31">种植保险类</option>
							<option value="32">养殖保险类</option>
							<option value="99">非农保险类</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class="button" value="查询" onclick="saveForm(this,'3',true);">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<br/>
	<iframe name="showlist" src="" height="100%" frameborder="0"  marginheight="0" marginwidth="0" scrolling="no" width="100%"></iframe>
</body>
<script>
	function saveForm(obj,buttonId,shifter){
		if(buttonId == '4'){
			var deptname = document.getElementById('deptname');
			var month = document.getElementById('month');
			if(deptname.value.trim() == ""){
				alert("班表机构不能为空。");
				deptname.focus();
    			deptname.select();
				return false;
			}
			if(month.value == "00"){
				alert("请选择班表月份。");
				month.focus();
				return false;
			}
			fm.backButton.disabled=true;
			fm.submit();
			setTimeout('fm.backButton.disabled=false',5000);
			return true;
		}else{
			fm.backButton.disabled=true;
			fm.submit();
			setTimeout('fm.backButton.disabled=false',5000);
			return true;
		}
	}
</script>