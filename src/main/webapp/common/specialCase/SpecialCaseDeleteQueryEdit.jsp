<%--
****************************************************************************
* DESC       ：删除案件查询输入界面
* AUTHOR     ： lixiang
* CREATEDATE ： 2004-06-15
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
  <%-- 公用函数 --%>
  <script src="/claim/common/js/Common.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/RegistQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle"><bean:message key="title.registBeforeEdit.titleName" /></td></tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.registNo" />：</td>
        <td class='input' >
          <input type=text name="RegistNo" class="input">
        </td>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />：</td>
        <td class='input' >
          <input type=text name="PolicyNo" class="input">
        </td>
        </tr>
        <tr>
        <td class='button' >
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="DELETE">
</form>
</body>
</html:html>