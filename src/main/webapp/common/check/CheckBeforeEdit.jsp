<%--
****************************************************************************
* DESC       ��¼��鿱ǰ���뱨����ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-05-19
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
  <title>¼��鿱</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/checkBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=2 class="formtitle">���뱨����</td></tr>
      <tr>
        <td class='title2' >�����ţ�</td>
        <td class='input2'>
          <input type=text name="RegistNo" class="common">
        </td>

      </tr>
      <tr> <td class='common' colspan=2 >
          <input type=submit class='button' value="��һ��">
        </td></tr>
    </table>
    <input type="hidden" name="editType" value="ADD">



    <!--�ӹ���������ʾ������б�-->

  </form>
</body>
</html:html>


