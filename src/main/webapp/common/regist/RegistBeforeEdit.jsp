<%--
****************************************************************************
* DESC       ��¼�뱨��ǰ���뱣����ҳ��
* AUTHOR     �� weishixin
* CREATEDATE �� 2004-02-25
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
  <title><bean:message key="title.registBeforeEdit.titleName" /></title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/registBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
        <tr>
          <td colspan="2" class="formtitle"><bean:message key="title.registBeforeEdit.titleName" /></td>
	      </tr>
        <tr>
          <td class='title2'><bean:message key="db.prpLregist.policyNo" />��</td>
          <td class='input2'> <input type=text name="prpCmainPolicyNo" class="common"></td>
        </tr>
        </table>
<table width=100%>
<tr>
        <td class='title' >
          <input type=submit class='button' value="��һ��">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="ADD">
  </form>
</body>
</html:html>



