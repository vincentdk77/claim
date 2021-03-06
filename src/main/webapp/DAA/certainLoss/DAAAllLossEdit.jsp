<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%--
****************************************************************************
* DESC       ：定损登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-13
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>定损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossAllLossEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    String editType=request.getParameter("editType");
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else {
%>
    <body  onload="initPage();initSet();">
<%
    }
%>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <table class="common">
    <tr>

      <td class=button ><input type="button" name="message"  class=bigbutton value="撰写留言" onclick="openWinSave()"></td>
      <td class=button><input type="button" class=bigbutton name="messageView" value="查看留言" onclick="openWinQuery()"></td>
      <td class=button><input type="button" class=bigbutton name="eCertify" value="电子单证" onClick="openCertify()"></td>

    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1">
  <tr> <td class="formtitle">定损登记</td></tr>
  </table>

      <%-- 定损主表的画面 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp"%>

      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossSave.jsp"%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>




