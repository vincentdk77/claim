
<%--
****************************************************************************
* DESC       ：定损登记录入/修改页面
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
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>     
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>定损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%

    //start 防止重复提交---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
	if(userDto == null){
	    isShowButton = false;
	}
   //end---------------------------------------------
   
    String editType=request.getParameter("editType");
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else {
%>
    <body  onload="initPage();initSet();">
<%
    }
%>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="riskcode" value="<bean:write name='prpLregistDto' property='riskCode'/>">
  <input type="hidden" name="policyno" value="<bean:write name='prpLregistDto' property='policyNo'/>">

  <table width="100%" class=common cellpadding="5" cellspacing="1">
          <tr>

            <td class="formtitle">定损登记</td>

          </tr>
        </table>
    <table cellpadding="5" cellspacing="1" class=common>
    <tr>
    <%if(isShowButton){ %>
       <td class=button >
	      <input type="button" name="message" class=bigbutton  value="理赔沟通" onclick="return openWinSaveQuery('<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.policyno.value,fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value,'registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />');">
	   </td>
	<%} %>
	   <td class=button >
             <input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','certa');">
       </td>
       </tr>
  </table>

    <%!
      int indexCertainLoss = 0;
      String flag = null;
    %>
    <%
      flag = request.getParameter("flag");
    %>

    <%-- 定损主表的画面 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp"%>
    <%-- 1.财产损失清单页面 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossPropEdit.jsp"%>     
	 <%-- 4. 定核损信息补充说明 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossSave.jsp"%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>




