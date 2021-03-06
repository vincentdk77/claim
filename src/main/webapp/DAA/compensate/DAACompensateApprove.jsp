<%--
****************************************************************************
* DESC       ：实赔录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/compensate/js/DAACompensateEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAPersonLossEdit.js"></script>
</head>

<body class=interface onload="initPage();initSet();readonlyAllInput();">
    <form name=fm action="/claim/compensateApprove.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

        <%-- 1.报案主信息 ??为什么和别的命名规则不一致？lixiang --%>
      <%@include file="/DAA/compensate/DAACompensateMainHeadEdit.jsp" %>

        <%-- 2.特别约定 --%>
            <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
        <%-- 3.赔付标的信息 --%>
            <%@include file="/DAA/compensate/DAACompensateLlossEdit.jsp"%>
        <%-- 3.赔付人员信息 --%>
            <%@include file="/DAA/compensate/DAACompensatePersonLossEdit.jsp"%>
        <%-- 3.赔款费用 --%>
            <%@include file="/DAA/compensate/DAACompensateChargeEdit.jsp"%>
       <%-- 1.报案主信息 --%>
      <%@include file="/DAA/compensate/DAACompensateMainTailEdit.jsp" %>
        <%-- 4.理算报告 --%>
            <%@include file="/DAA/compensate/DAACompensateTextEdit.jsp"%>

    <%-- 保存通用按钮 --%>
        <table cellpadding="0" cellspacing="0" width="100%" style="display:">
          <tr>
            <td align="center"><input type="button" class=button name="buttonApprove" value="复 核" onClick="approveSubmit();"></td>
          </tr>
        </table>
     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
