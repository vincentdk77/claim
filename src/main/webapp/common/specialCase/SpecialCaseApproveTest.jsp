<%--
****************************************************************************
* DESC       �������ⰸͨ������
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
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/prepayApprove.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">Ԥ�����ͨ��</td></tr>
      <tr>
        <td class='title' >Ԥ��/ͨ��:</td>
        <td class='input' ><input type=text name="prpLcompensateCompensateNo" class="query" > <input type=button class='button' value="����ͨ��" onClick="onSub1();"></td>
      </tr>
      <tr>
        <td class='title' >Ԥ��:</td>
        <td class='input' ><input type=text name="prpLprepayPreCompensateNo" class="query" > <input type=button class='button' value="����ͨ��" onClick="onSub2();"></td>
      </tr>
    </table>
    <input type="hidden" name="prpLcompensateUnderWriteFlag" value="1">
          <input type="hidden" name="prpLprepayUnderWriteFlag"  value="1">
    <input type="hidden" name="editType" value="Approve">
  </form>
</body>
</html:html>



