<%--
****************************************************************************
* DESC       ：预赔查询条件输入界面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-07
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
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body onload="initPage();">
<form name="fm" action="/claim/prepayApprove.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=2 class="formtitle">预赔核赔通过</td></tr>
      <tr>
        <td class='title2' >预赔登记号：</td>
        <td class='input2' ><input type=text name="prpLprepayPreCompensateNo" class="input" ><input type=submit class='button' value="核赔通过"></td>
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="1">
      </tr>
    </table>
    <input type="hidden" name="editType" value="Approve">
  </form>
</body>
</html:html>



