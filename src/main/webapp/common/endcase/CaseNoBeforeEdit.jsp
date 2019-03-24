<%--
****************************************************************************
* DESC       ：录入结案前输入报案号页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-28
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
  <title>录入结案</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/endcaseSave.do?step=step2"  method="post" onsubmit="return validateForm(this);">

  <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
  <tr><td colspan=2 class="formtitle">输入立案号（生成归档号）</td></tr>
    <tr>
      <td class="title2"  align="center">立案号：</td>
      <td class="input2">
        <input type=text name="prpLendcaseClaimNo1" class="common">
      </td>
      </tr>
      <tr>
      <td class="button"   colspan=2 align="center">
        <input type=submit class="button" class="button" value="下一步">
      </td>
    </tr>
  </table>
  <input type="hidden" name="editType" value="ADD">
</form>
</body>
</html:html>



