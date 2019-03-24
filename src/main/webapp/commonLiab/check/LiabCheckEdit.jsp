
<%--
****************************************************************************
* DESC       ：查勘登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-03
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
<%@page import="com.sinosoft.sysframework.reference.*"%>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      查勘登记
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonLiab/check/js/LiabCheckEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  System.out.println(editType);
  //取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage(); ">
<%
}

%>

    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">    
        <%-- 1.查勘/代查勘头信息 --%>
          <%@include file="/commonLiab/check/LiabCheckMainHeadEdit.jsp" %>

         <%-- 2.查勘中信息 --%>
          <%--@include file="/commonLiab/check/LiabCheckMainMiddleEdit.jsp" --%>
         <%-- 3.查勘尾信息 --%>
           <%@include file="/commonLiab/check/LiabCheckMainTailEdit.jsp" %>

         <%-- 4.查勘备注信息 --%>
          <%@include file="/commonLiab/regist/LiabRegistTextEdit.jsp"%>
          <%--5.估损金额信息 --%>
         <%--@include file="/commonLiab/claim/LiabClaimFeeEdit.jsp"--%>
          <%--5.保存通用按钮 --%>
          <%@include file="/commonLiab/check/LiabCheckSave.jsp" %>

     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
