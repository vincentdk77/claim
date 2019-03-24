<%--
****************************************************************************
* DESC       ：测试select
* AUTHOR     ：weishixin
* CREATEDATE ：2004-08-04
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
    <title>
      测试选择
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/test/SelectCode.js"> </script>
 </head>
<body class="interface" >
    <form name=fm action="" method="post" >
        <select class='common' style="width:110" name="nodeType" onchange="return selectCode(this);">
            <option value="TASKCODE_LPBA">报案</option>
            <option value="TASKCODE_LPLA">立案</option>
            <option value="TASKCODE_LPCK">查勘</option>
            <option value="TASKCODE_LPPA">理算</option>
            <option value="TASKCODE_LPDD">调度</option>
        </select>

        <select class='common' style="width:200" name="personList" >
            <option value="1">京A0001</option>
            <option value="2">京A0002</option>
            <option value="3">京A0003</option>
            <option value="4">京A0004</option>
        </select>
    </form>
</body>
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>