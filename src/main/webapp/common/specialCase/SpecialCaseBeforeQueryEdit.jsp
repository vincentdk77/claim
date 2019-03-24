<%--
****************************************************************************
* DESC       ��¼�������ⰸǰ��ѯ������������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-12-06
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>


<html:html locale="true">
<head>
  <title>��ѯ������Ϣ</title>
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script language="javascript">
  <%--����״̬��־����--%>
  <!--
    function submitForm()
    {
      fm.submit();//�ύ
    }
  //-->
  </script>

  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/ClaimQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle">��ѯ������Ϣ</td></tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />��</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query">
        </td>

        <td class='title' >�������룺</td>
        <td class='input' >
        <select class=tag name="ClaimNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query">
        </td>
      </tr>

      <tr>
        <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="SpecialCase">
  </form>
</body>
</html:html>
