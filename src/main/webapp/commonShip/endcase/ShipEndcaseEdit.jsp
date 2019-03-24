<%--
****************************************************************************
* DESC       ：结案登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>结案登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/endcase/js/ShipEndcaseEdit.js"></script>
</head>

<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
  {
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();initSet();">
<%
}
%>
    <form name=fm action="/claim/endcaseSave.do?step=step1" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

      <%-- 1.结案主信息 --%>
      <%@include file="/commonShip/endcase/ShipEndcaseMainEdit.jsp" %>
      <%-- 4.结案文本信息 --%>
      <%@include file="/DAA/endcase/DAAEndcaseTextEdit.jsp"%>
      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/endcase/DAAEndcaseSave.jsp"%>
      <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>
     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
