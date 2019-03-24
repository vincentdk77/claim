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
<form name="fm" action="/claim/prepayApprove.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=2 class="formtitle">Ԥ�����ͨ��</td></tr>
      <tr>
        <td class='title2' >Ԥ��ǼǺţ�</td>
        <td class='input2' ><input type=text name="prpLprepayPreCompensateNo" class="input" ><input type=submit class='button' value="����ͨ��"></td>
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="1">
      </tr>
    </table>
    <input type="hidden" name="editType" value="Approve">
  </form>
</body>
</html:html>



