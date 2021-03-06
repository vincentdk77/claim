<%--
****************************************************************************
* DESC       ：实赔录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonCargo/compensate/js/CargoCompensateEdit.js"></script>
  <script src="/claim/commonCargo/compensate/js/CargoPersonLossEdit.js"></script>
</head>

<%

//modify by ww add begin 2005-11-15
   //reason: 防止重复提交
   session.setAttribute("oldCompensateLastAccessedTime","");
   //modify by ww add end 2005-11-15
    //取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  UserDto   user     = (UserDto)session.getAttribute("user");
  String riskCode = "";
  if(user==null){
      riskCode = request.getParameter("riskCode");
  }else{
      riskCode = user.getRiskCode();
  }
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  //编辑和查询状态下调用新危险单位赋值
  if (editType.equals("SHOW")){
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else if(editType.equals("EDIT")){
%>
<body  onload="loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else{
%>
<body  onload="initPage();initSet();calFund();onLoadZeroLossCaseType();">
<%
  }
%>
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
   <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
    <input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">   
    <%-- 1.报案主信息 --%>
        <%@include file="/commonCargo/compensate/CargoCompensateMainHeadEdit.jsp" %>
    <%-- 2.特别约定 --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 2.赔偿限额/免赔额 --%>
        <%@include file="/commonCargo/compensate/CargoCompensatePrpDlimit.jsp"%>
    <%-- 3.赔付标的信息 --%>
        <%@include file="/commonCargo/compensate/CargoCompensateLlossEdit.jsp"%>
<%
  if(riskCode!=null&&riskCode.trim().equals("ZAA")){
%>
    <%-- 3.赔付人员信息 --%>
        <%@include file="/commonCargo/compensate/CargoCompensatePersonLossEdit.jsp"%>
<%
  }
%>
    <%-- 3.赔款费用 --%>
        <%@include file="/commonCargo/compensate/CargoCompensateChargeEdit.jsp"%>
    <%-- 1.报案主信息 --%>
        <%@include file="/commonCargo/compensate/CargoCompensateMainTailEdit.jsp" %>
 <% //增加定损说明 %>

        <%//@include file="/commonCargo/compensate/CargoCertaReportCompensateTextEdit.jsp"%>
          <%--添加结案报告 2005-07-26--%>
        <%@include file="/commonCargo/compensate/CargoEndCaseCompensateTextEdit.jsp"%>
        
   <%-- 4.理算报告 --%>
        <%@include file="/commonCargo/compensate/CargoCompensateTextEdit.jsp"%>

 

    <%-- 4.付款说明 --%>
        <%@include file="/common/compensate/CompensatePayTextEdit.jsp" %>
    <%-- 5.指定危险单位信息 --%>
       <%
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	   	//用旧的危险单位信息页面	
	   %>
	      <%@include file="/common/claim/ClaimRiskUnit.jsp"%>
	   <%
	   }else{
		 //用新的危险单位信息页面	   
	    %> 
	      <%@include file="/common/compensate/CompensateNewRiskUnit.jsp"%>
	    <%
	   }	    
	    %>
  <%-- 保存通用按钮 --%>
        <%@include file="/DAA/compensate/DAACompensateSave.jsp"%>
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
