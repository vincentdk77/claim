<%--
****************************************************************************
* DESC       ：核损登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-13
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
    <title>核损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAAVerifyLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  String nodeType=request.getParameter("nodeType");
	//取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();">

<%
}

%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <input type="hidden" name="nodeType"              value="<%=nodeType%>">    
        <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">         
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>

      <td class=button ><input type="button" class=bigbutton name="message" value="撰写留言" onclick="openWinSave('<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.policyno.value,fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value)"></td>
      <td class=button ><input type="button" class=bigbutton name="messageView" value="查看留言" onclick="openWinQuery('registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />')"></td>

    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
    %>
    <%-- 1.核损主表的画面 --%>
        <%@include file="/commonAgri/verifyLoss/AgriVerifyLossMainEdit.jsp"%>
    <%-- 2.财产损失清单页面 --%>
        <logic:equal name="prpLverifyLossDto" property="riskCode" value="3202">
            <%@include file="/commonAgri/verifyLoss/Agri3202VerifyLossPropEdit.jsp"%>
        </logic:equal>
        <logic:notEqual name="prpLverifyLossDto" property="riskCode" value="3202">
            <%@include file="/commonAgri/verifyLoss/AgriVerifyLossPropEdit.jsp"%>
        </logic:notEqual>
    

      <%-- 保存通用按钮 --%>
      <%@include file="/commonAgri/verifyLoss/AgriVerifyLossSave.jsp"%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
