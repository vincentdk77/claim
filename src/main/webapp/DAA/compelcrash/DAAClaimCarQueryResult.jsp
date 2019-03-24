<%--
****************************************************************************
* DESC       ：
* AUTHOR     ：xubiao
* CREATEDATE ： 2007-01-24
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> </title>

   		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body>
 
<jsp:include  page="/claim/DAA/claim/DAAClaimCarCarAccidentQuery.jsp" />
<table class="common" width="100%" align="center">
<tr><td colspan="7" align="center" class="formtitle">车车互碰查询结果</td></tr>
<tr>
<td class="centertitle">序号 </td>
<td class="centertitle"> 事故号</td>
<td class="centertitle">甲方报案号 </td>
<td class="centertitle">乙方报案号</td>
<td class="centertitle">甲方车牌号</td>
<td class="centertitle">乙方车牌号</td>
<td class="centertitle">过错方</td>
</tr>
</table>
  </body>
</html>
