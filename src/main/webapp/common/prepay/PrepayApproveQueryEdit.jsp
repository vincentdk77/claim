<%--
****************************************************************************
* DESC       ��Ԥ���ѯ�����������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-07
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
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body onload="initPage();">
<form name="fm" action="/claim/prepayApproveQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">��ѯԤ����Ϣ(����)</td></tr>
      <tr>
        <td class='title' >Ԥ��ǼǺţ�</td>
        <td class='input' >
          <select class=tag name="PrepayNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PrepayNo" class="query" >
        </td>
        <td class='title' >�����ţ�</td>
        <td class='input' >
          <select class=tag name="ClaimNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query"  >
        </td>
      </tr>
      <tr>
        <td class='title' >�����ţ�</td>
        <td class='input'  colspan="3">
          <select class=tag name="PolicyNoSign"  >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query"  >
        </td>
      </tr>
      <tr>
        <td class='button' colspan="4">
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="Approve">
  </form>
</body>
</html:html>



