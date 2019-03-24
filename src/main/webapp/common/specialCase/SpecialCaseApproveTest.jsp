<%--
****************************************************************************
* DESC       ：特殊赔案通过功能
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
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script>
    function onSub1(){
      fm.action="/claim/compensateApprove.do";
      fm.submit();
    }

    function onSub2(){
      fm.action="/claim/prepayApprove.do";
      fm.submit();
    }
  </script>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/prepayApprove.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">预赔核赔通过</td></tr>
      <tr>
        <td class='title' >预付/通融:</td>
        <td class='input' ><input type=text name="prpLcompensateCompensateNo" class="query" > <input type=button class='button' value="核赔通过" onClick="onSub1();"></td>
      </tr>
      <tr>
        <td class='title' >预赔:</td>
        <td class='input' ><input type=text name="prpLprepayPreCompensateNo" class="query" > <input type=button class='button' value="核赔通过" onClick="onSub2();"></td>
      </tr>
    </table>
    <input type="hidden" name="prpLcompensateUnderWriteFlag" value="1">
          <input type="hidden" name="prpLprepayUnderWriteFlag"  value="1">
    <input type="hidden" name="editType" value="Approve">
  </form>
</body>
</html:html>



