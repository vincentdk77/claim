<%--
****************************************************************************
* DESC       ：已完成实赔查询输入条件界面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
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
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/compensateFinishQueryEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
        <td class='title' >赔款计算书号：</td>
        <td class='input' >
          <input type=text name="CompensateNo" class="input">
        </td>
        <td class='title' >立案号：</td>
        <td class='input'>
          <input type=text name="ClaimNo" class="input">
        </td>
      </tr>
            <tr>
        <td class='title' >保单号：</td>
        <td class='input' >
          <input type=text name="PolicyNo" class="input">
        </td>
        <td class='title' >核赔标志：</td>
        <td class='input'>
          <input type="checkbox" name="UnderWriteFlag" value="0">初始值
          <input type="checkbox" name="UnderWriteFlag" value="1">通过
          <input type="checkbox" name="UnderWriteFlag" value="2">不通过<br>
          <input type="checkbox" name="UnderWriteFlag" value="3">无需核赔
          <input type="checkbox" name="UnderWriteFlag" value="9">待核赔
        </td>
      </tr>

      <tr>

        <td class='button' colspan="4">
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="EDIT">
  </form>
</body>
</html:html>