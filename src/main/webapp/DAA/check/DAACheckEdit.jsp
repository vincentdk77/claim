<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%--
****************************************************************************
* DESC       ：查勘登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-03
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

 <script language="JavaScript">
    <!--
javascript:window.history.forward(1);
    //-->
    </script>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      查勘登记
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script>
	<!--
    /**
     *@description 设置画面的初始值
     *@param       无
     *@return      通过返回true,否则返回false
     */
  	function loadCheckLoss(){
  		var referKind = "<bean:write name='prpLcheckDto' property='referKind'/>";
      var arrayReferKind = new Array();
      arrayReferKind = referKind.split(",");
      var i = 0;
      var j = 0;
      for(i=0;i<arrayReferKind.length;i++)
      {
      	for(j=0;j<fm.prpLcheckReferKind.length;j++)
      	{
      		if(fm.prpLcheckReferKind[j].value == arrayReferKind[i])
      		{
      			fm.prpLcheckReferKind[j].checked=true;
      			break;
      		}
      	}
      }
  	}
	//-->
  </script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/check/js/DAACheckEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>


<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />


	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();initSet();initSetForCheck();readonlyAllInput();">
<%}else if(editType.equals("EDIT")){
%>
	<body class="interface" onload="initPage();initSet();">
<%	
}else{
%>
   <body class="interface" onload="initPage();initSet();addOption();">
<%}%>
    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="riskcode" value="<bean:write name='prpLcheckDto' property='riskCode' filter='true' />">
    <!-- 车新查询时使用fm.prpLregistRiskCode.value -->
    <input type="hidden" name="prpLregistRiskCode" value="<bean:write name='prpLcheckDto' property='riskCode' filter='true' />">
          <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDto' property='policyNo' filter='true' />">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
       <% //查勘部分%>

        <%-- 1.查勘/代查勘主信息 --%>
          <%@include file="/DAA/check/DAACheckMainEdit.jsp" %>

          <%--modify by wangli add start 20050407--%>
           <%-- 特别约定 --%>
            <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
           <%--modify by wangli add end 20050407--%>

        <%-- 2.查勘/代查勘扩展 --%>
          <%@include file="/DAA/check/DAACheckExtEdit.jsp"%>
        <%-- 3.涉案车辆 --%>
          <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>
        <%--  财产损失部位信息 --%>
         <%@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"%>

        <%-- 4.1 人伤跟踪信息 --%>
            <%@ include file="/DAA/claim/DAAClaimPersonTraceEdit.jsp" %>
        <%-- 5.驾驶员信息 --%>
          <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>

        <%-- 6.查勘备注信息 --%>
         <%@include file="/DAA/regist/DAARegistTextEdit.jsp"%>

        <%-- 6.定损信息 --%>
         <%-- //@include file="/DAA/check/DAACertainLossEdit.jsp" --%>
        <%-- 4.报案信息补充说明 --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
          <%--5.估损金额信息 --%>
         <%--@include file="/DAA/claim/DAAClaimFeeEdit.jsp"--%>

        <%-- 保存通用按钮 --%>
         <%@include file="/DAA/check/DAACheckSave.jsp"%>


      </form>
</body>
</html:html>
