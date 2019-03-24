
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%><%--
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
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
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
					��ѯ����
				</td>
			</tr>
			<tbody>
				<tr>
					<td class='title textr' style="width: 15%">
						��������
					</td>
					<td class='input' style="width: 30%">
						<input type=hidden class="codecode" name="handledept"
							style="width: 20%" title="���嵥λ" value="<%=comCode%>"
							ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onkeyup="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');">
						<input type=text class="codecode" id="deptname" name="deptname" title="���嵥λ"
							style="width: 90%" maxLength="50" description="�������λ" value="<%=comName%>"
							ondblclick="open_CodeSelect(this,'jobComCode','<%=comCode%>','�������λ');"
							onkeyup="open_CodeSelect(this,'jobComCode','<%=comCode%>','�������λ');"
							onkeypress="window.event.keyCode = 0;">
						<font color="red">*</font>
					</td>
					<td class='title textr' style="width: 15%">
						����·ݣ�
					</td>
					<td>
						<input type="text" style="width:60%" name="month" readonly class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM'});" >
						<font color="red">*</font>
					</td>
					
				</tr>
				<tr>
					<td class='title' style="width: 15%">
						���ࣺ
					</td>
					<td class="input" width="30%">
						<select name="classCode" style="width:90%">
							<option value="xx" checked="checked">��ѡ������</option>
							<option value="31">��ֲ������</option>
							<option value="32">��ֳ������</option>
							<option value="99">��ũ������</option>
						</select>
						<font color="red">*</font>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="left" class='title'>
						<font color="red">�조*��Ϊ��¼�</font>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class="button" value="����"
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
				alert("����������Ϊ�ա�");
				deptname.focus();
    			deptname.select();
				return false;
			}
			if(trim(month.value) == ""){
				alert("��ѡ�����·ݡ�");
				month.focus();
				return false;
			}
			if(trim(classCode.value) == "xx"){
				alert("��ѡ�����ࡣ");
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