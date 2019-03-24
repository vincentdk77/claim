<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">

  <head>
    <html:base />
    
    <title>PlantingSettleInfo.jsp</title>

  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
<script language="javascript">
function returnToSettleList(){
	document.fm.submit();
}
function closeCurrentWindow(){
	window.close();
}
function initPage(){
	var settleListCode = document.getElementById('settleListCode').value;
	var saveSuccess = document.getElementById('saveSuccess').value;
	if(null!=settleListCode && ""!=settleListCode && "success"==saveSuccess){
		window.opener.document.getElementById('settleListCode').value = settleListCode;
	}
}
</script>
<%
	String policyNo = (String)request.getAttribute("policyNo");
	String registNo = (String)request.getAttribute("registNo");
	String nodeType = (String)request.getAttribute("nodeType");
	String editType = (String)request.getAttribute("editType");
	String settleListCode = (String)request.getAttribute("settleListCode");
	String claimNo = (String)request.getAttribute("claimNo");
	String compensateNo = (String)request.getAttribute("compensateNo");
	String timeStamp = (String)request.getAttribute("timeStamp");
%>
  <body onLoad="initPage()" >
     <form name="fm" action="/claim/planting31SettleList.do" method="post">
     <input type="hidden" name="policyNo" value="<%=policyNo %>"/>
     <input type="hidden" name="registNo" value="<%=registNo %>"/>
     <input type="hidden" name="nodeType" value="<%=nodeType %>"/>
     <input type="hidden" name="editType" value="<%=editType %>"/>
     <input type="hidden" name="claimNo" value="<%=claimNo %>"/>
     <input type="hidden" name="compensateNo" value="<%=compensateNo %>"/>
     <input type="hidden" name="isFirst" value="isFirst"/>
     <input type="hidden" name="loadXLS" value=""/>
     <output type="hidden" name="settleListCode" id="settleListCode" value="<%=settleListCode %>"/>
     <output type="hidden" name="saveSuccess" id="saveSuccess" value="<%=request.getAttribute("saveSuccessMessage")==null?"":"success"%>"/>
     <input type="hidden" name="timeStamp" value="<%=timeStamp==null?"":timeStamp%>"/>
<table class="common">
<%
	if(null!=request.getAttribute("errorMessage")){
%>
<tr>
 	<td colspan="9" align="center" class="formtitle">清单校验出现如下错误：</td>
</tr>
<tr>
	<td colspan="9" align="center" ><%=((StringBuffer)request.getAttribute("errorMessage")).toString()%></td>
</tr>
<!-- tr><span><input type="button" class="bigbutton" value="返回" name="returnToSettleList" onclick="returnToSettleList()"/></span></tr> -->
<%} %>
<%
	if(null!=request.getAttribute("viewErrorMessage")){
%>
<tr>
 	<td colspan="9" align="center" class="formtitle">获取清单出现如下错误：</td>
</tr>
<tr>
	<td colspan="9" align="center" ><%=(String)request.getAttribute("viewErrorMessage")%></td>
</tr>
<%} %>
<%
	if(null!=request.getAttribute("editErrorMessage")){
%>
<tr>
 	<td colspan="9" align="center" class="formtitle">获取清单出现如下错误：</td>
</tr>
<tr>
	<td colspan="9" align="center" ><%=(String)request.getAttribute("editErrorMessage")%></td>
</tr>
<%} %>
<%
	if(null!=request.getAttribute("deleteErrorMessage")){
%>
<tr>
 	<td colspan="9" align="center" class="formtitle">删除清单出现如下错误：</td>
</tr>
<tr>
	<td colspan="9" align="center" ><%=(String)request.getAttribute("deleteErrorMessage")%></td>
</tr>
<%} %>
<%
	if(null!=request.getAttribute("saveErrorMessage")){
%>
<tr>
 	<td colspan="9" align="center" class="formtitle">保存清单出现如下错误：</td>
</tr>
<tr>
	<td colspan="9" align="center" ><%=(String)request.getAttribute("saveErrorMessage")%></td>
</tr>
<%} %>
<%
	if(null!=request.getAttribute("saveSuccessMessage")){
%>
<tr>
 	<td colspan="9" align="center" class="formtitle">保存清单：</td>
</tr>
<tr>
	<td colspan="9" align="center" ><%=(String)request.getAttribute("saveSuccessMessage")%></td>
</tr>
<!-- <tr><span><input type="Button" class="bigbutton" value="返回" name="returnToSettleList" onclick="returnToSettleList()"/></span></tr> -->
<%} %>
</table>
<table class="common">
	<tr align="center">
<%
	if(null!=request.getAttribute("errorMessage") || null!=request.getAttribute("deleteErrorMessage") ||null!=request.getAttribute("saveErrorMessage")||null!=request.getAttribute("saveSuccessMessage")){
%>
		<td align="center">
			<input type="button" class="bigbutton" value="返回" name="ToSettleList" onclick="returnToSettleList()"/>
		</td>
<%
	}
	if(null!=request.getAttribute("saveSuccessMessage")){
%>
		<td align="center">
			<input type="button" class="bigbutton" value="关闭窗口" name="CloseWindow" onclick="closeCurrentWindow()"/>
		</td>
<%
	}
%>
	</tr>
</table>
</form>
<br>
  </body>
</html:html>
