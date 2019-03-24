<%--
****************************************************************************
* DESC       ：实赔查询条件输入页面
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
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/compensateApproveQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>   <td colspan=4 class="formtitle">查询实赔信息(复核)</td></tr>
      <tr>
        <td class='title' >赔款计算书号：</td>
        <td class='input' >
          <select class=tag name="CompensateNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="CompensateNo" class="query" >
        </td>
        <td class='title' >立案号：</td>
        <td class='input' >
          <select class=tag name="ClaimNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query" >
        </td>
      </tr>
      <tr>
        <td class='title' >保单号：</td>
        <td class='input'>
          <select class=tag name="PolicyNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
        <td class=title  colspan="2"></td>
      </tr>


    </table>
    <table width=100%>
    <tr>
        <td class='button'>
          <input type="submit" class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
      </table>
    <input type="hidden" name="editType" value="EDIT">
  </form>
</body>
</html:html>