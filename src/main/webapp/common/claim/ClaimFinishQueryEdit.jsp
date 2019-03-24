<%--
****************************************************************************
* DESC       �������������ѯ�������
* AUTHOR     ��lixiang
* CREATEDATE ��2004-04-15
* MODIFYLIST ��   Name       Date            Reason/Contents
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
<form name="fm" action="/claim/claimFinishQueryEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=4 class="formtitle"><bean:message key="title.claimBeforeEdit.titleName" /></td></tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLclaim.claimNo" />��</td>
        <td class='input' >
          <input type=text name="prpLclaimClaimNo" class="input">
        </td>
        <td class='title' ><bean:message key="db.prpLclaim.policyNo" />��</td>
        <td class='input' >
          <input type=text name="prpLclaimPolicyNo" class="input">
        </td>
        </tr>
        <tr>
        <td class='button' colspan=4>
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="EDIT">
  </form>
</body>
</html>