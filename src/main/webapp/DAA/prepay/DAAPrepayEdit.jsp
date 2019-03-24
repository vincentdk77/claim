<%--
****************************************************************************
* DESC       ：预赔登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-10
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
	
<SCRIPT LANGUAGE="JavaScript">
		function initAlert(){
			var prePayFlag = fm.prePayFlagTemp.value;
	  		if(prePayFlag == '0'){
	  				alert("保费未实收，系统不允许预赔！");
	  				fm.buttonSave.disabled = "disabled";
	  				fm.buttonSaveFinishSubmit.disabled = "disabled";
	  		}
	  }
</SCRIPT>
    <!--对title处理-->
    <title>预赔登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/prepay/js/DAAPrepayEdit.js"></script>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>
<%
  String editType=request.getParameter("editType");
  String prePayFlag=(String)request.getAttribute("prePayFlag");
  System.out.println();System.out.println(prePayFlag);System.out.println();
  System.out.println(editType);
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class=interface onload="initPage();initSet();initAlert();" >
<%
}
%>
    <form name=fm action="/claim/prepaySave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      
      <input type="hidden" name="prePayFlagTemp" value="<%=prePayFlag%>">
      
      <%-- 1.预赔主信息 --%>
      <%@include file="/DAA/prepay/DAAPrepayMainEdit.jsp" %>
      <%-- 4.预赔备注信息 --%>
      <%@include file="/DAA/prepay/DAAPrepayTextEdit.jsp"%>
      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/prepay/DAAPrepaySave.jsp"%>
     </form>
</body>

</html:html>
