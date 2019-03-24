<%--
****************************************************************************
* DESC       ：录入立案前输入报案号页面
* AUTHOR     ： lixiang
* CREATEDATE ： 2004-04-12
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
  <title>查询立案信息</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/claimBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=2 class="formtitle">查询立案信息</td></tr>
      <tr>
        <td class='title2' ><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class='input2'>
          <input type=text name="RegistNo" class="common">
        </td>
        </tr>
        <tr>
        <td class='button' colspan=2>
          <input type=submit class='button' value="下一步">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="ADD">
  </form>
</body>
</html:html>



