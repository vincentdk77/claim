<%--
****************************************************************************
* DESC       ：录入单证前输入报案号页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-05
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
  <title>录入单证</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
  function submitForm()
  {
    fm.buttonNext.disabled = true;
    fm.submit(); //提交
  }
</script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/certifyBeforeEdit.do"  method="post"  onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr>  <td colspan=2 class="formtitle">输入报案号（单证登记）</td></tr>
      <tr>
        <td class='title2'  align="center">报案号：</td>
        <td class='input2' >
          <input type=text name="RegistNo" class="common" value="RDAA200431000000000035">
        </td>
        </tr>
        <tr>
        <td class='button' align="center" colspan="2">
          <input type="button" class='button' value="下一步" name="buttonNext" onclick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="ADD">
  </form>
</body>
</html:html>




