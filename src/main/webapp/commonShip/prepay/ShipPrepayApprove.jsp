<%--
****************************************************************************
* DESC       ：预赔登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>


<html:html locale="true">
<head>
    <!--对title处理-->
    <title>预赔登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/classC/prepay/js/CPrepayEdit.js"></script>
</head>

<body class=interface onload="initPage();InitDocument();initShow();" >
    <form name=fm action="/claim/prepayApprove.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.预赔主信息 --%>
      <%@include file="/classC/prepay/CPrepayMainShow.jsp"%>
      <%-- 4.预赔备注信息 --%>
      <%@include file="/classC/prepay/CPrepayTextShow.jsp"%>

      <%-- 保存通用按钮 --%>
        <table cellpadding="0" cellspacing="0" width="80%" style="display:">
          <tr>
            <td align="center"><input type="button" name="buttonApprove" value="复  核" class="button" onClick="approveSubmit();"></td>
          </tr>
        </table>
     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script src="/claim/common/js/Edit.js"> </script>

</html:html>
