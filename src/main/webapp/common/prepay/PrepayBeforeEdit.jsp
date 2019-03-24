<%--
****************************************************************************
* DESC       ：录入预赔前输入立案号页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-05-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <title><bean:message key="title.registBeforeEdit.titleName" /></title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body onload="initPage();">
<form name="fm" action="/claim/prepayBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=2 class="formtitle">输入立案号</td></tr>
      <tr>
        <td class='title2' >立案号:</td>
        <td class='input2'>
          <input type=text name="ClaimNo" class="common">
        </td>
        </tr>
        <tr>
        <td class='common'  colspan=2 >
          <input type=submit class='button' value="下一步">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="ADD">
  </form>
</body>
</html:html>



