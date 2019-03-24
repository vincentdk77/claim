
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
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
	<title><bean:message key="title.registBeforeEdit.editRegist" />
	</title>
	<%-- ҳ����ʽ  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/showpage.js"> </script>
	<script src="/claim/common/js/CodeSelect.js"></script>
	<script src="/claim/common/jobManager/js/yeardate.js"></script>
	<script src="/claim/js/WdatePicker.js"></script>
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
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
					��ѯ����
				</td>
			</tr>
			<tbody>
				<tr>
					<td class='title textr' style="width: 15%">
						���������
					</td>
					<td class='input' style="width: 25%">
						<input type=hidden class="codecode" name="handledept"
							style="width: 20%" title="���嵥λ" value=""
							ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onkeyup="code_CodeSelect(this, 'ComCodeByProvinceCode');"
							onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');">
						<input type=text class="codecode" name="deptname" title="���嵥λ"
							style="width: 100%" maxLength="50" description="���������λ" value=""
							ondblclick="open_CodeSelect(this,'jobComCode','<%=comCode%>','���������λ');"
							onkeyup="open_CodeSelect(this,'jobComCode','<%=comCode%>','���������λ');"
							onkeypress="window.event.keyCode = 0;">
					</td>
				
					<td class='title textr' style="width: 15%">
						����·ݣ�
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
						���ࣺ
					</td>
					<td class="input" width="30%">
						<select name="classCode" style="width:100%">
							<option value="" checked="checked">��ѡ������</option>
							<option value="31">��ֲ������</option>
							<option value="32">��ֳ������</option>
							<option value="99">��ũ������</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center" class='title'>
						<input type="button" id="backButton" class="button" value="��ѯ" onclick="saveForm(this,'3',true);">
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
				alert("�����������Ϊ�ա�");
				deptname.focus();
    			deptname.select();
				return false;
			}
			if(month.value == "00"){
				alert("��ѡ�����·ݡ�");
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