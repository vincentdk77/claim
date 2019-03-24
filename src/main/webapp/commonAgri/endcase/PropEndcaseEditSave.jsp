<%--
****************************************************************************
* DESC       ：结案登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>结案登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<script language="javascript">
  function submitForm()
  {
    fm.submit();
  }
</script>
</head>

<body class=interface onload="initPage();" class="interface">
  <form name="fm" method="post" action="/claim/endcaseSave.do?step=step2">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <h3>结案登记保存成功！</h3><br>
    <h3>要生成归档号,请点击下一步按钮！</h3>
    <hr>
    <input type=hidden name="prpLendcaseClaimNo1" value="<%= request.getAttribute("claimNo") %>">
    <input type="button" name="buttonNext" value="继续下一步" class="bigbutton" onclick="submitForm()">
    <input  type="hidden" name=buttonSaveType value="1">
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
