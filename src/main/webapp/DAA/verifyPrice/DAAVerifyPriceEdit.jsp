<%--
****************************************************************************
* DESC       ：核价登记录入/修改页面
* AUTHOR     ：sunchenggang
* CREATEDATE ：2006-03-07
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
    <title>核价登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyPrice/js/DAAVerifyPriceEdit.js"></script>  
  <script src="/claim/DAA/verifyPrice/js/DAAVerifPriceRepairComponentEdit.js"></script>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>

<%
  String editType=request.getParameter("editType");
  System.out.println(editType);
  PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)request.getAttribute("prpLverifyLossDto");
  String riskcodefortemp = prpLverifyLossDto.getRiskCode();
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet1();readonlyAllInput();setreadonlyforhouse();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet1();setreadonlyforhouse();readonlyAllInput();">

<%
}

%>
    <%!
      int indexVerifyLoss = 0;
    %>
  <form name="fm" action="/claim/verifyPriceSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.核价主信息 
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp" %>--%>
      
        <%-- 核损主表的画面 --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
            <%-- 1.财产损失清单页面 --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossPropEdit.jsp"%>
       <%if(riskcodefortemp != null && ("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp))){ %>
          
           <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
          
          <%} %>
      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/verifyPrice/DAAVerifyPriceSave.jsp"%>
  </form>
</body>

</html:html>
