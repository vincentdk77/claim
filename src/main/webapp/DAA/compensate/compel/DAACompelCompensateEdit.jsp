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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>

<%@page import="com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/compensate/compel/js/DAACompelCompensateEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAPersonLossEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAlLossEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAACommerceBGather.js"></script>
  


  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <SCRIPT LANGUAGE="JavaScript">
  </SCRIPT>
</head>

<%
   session.setAttribute("oldCompensateLastAccessedTime","");
   PrpLregistExtDto prpLregistExtDto =(PrpLregistExtDto)request.getAttribute("prpLregistExtDto");
   String  riskcode = prpLregistExtDto.getRiskCode();
   BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new  BLPrpLRegistRPolicyFacade();
   String sql  =  "registno='"+prpLregistExtDto.getRegistNo()+"'";
   //是否是关联理赔
   int countOfConClaim =  blPrpLRegistRPolicyFacade.getCount(sql);
   int isConClaim = 0;
   //关联理赔 
   if(countOfConClaim>1)
   {
	   isConClaim = 1;
   }
   String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  //编辑和查询状态下调用新危险单位赋值
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet() ;calSumDutyPaid();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();">
<%
  }else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();">
<%
  }else{
%>
<body class="interface" onload="loadCarCharge('<%=riskcode %>','<%=isConClaim %>');initPage();initSet();calSumDutyPaid();">
<%
  }
  if (editType.equals("DELETE")){
%>
    <form name=fm action="/claim/compensateDelete.do" method="post" onsubmit="return validateForm(this);">
<%
  }else{
%>
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
<%
  }
%>   
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="prpLCollectNoSubmitMsg" value="<%= request.getAttribute("msg") %>">

        <%@include file="/DAA/compensate/DAACompensateMainHeadEdit.jsp" %>
		 <%-- 三者车信息--%>
        <%@include file="/DAA/compensate/DAACompensateThridCarEdit.jsp"%>
        <%-- 2.特别约定 --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
        <%-- 3.修理发票信息 --%>
        <%@include file="/DAA/compensate/compel/DAACompensateBillEdit.jsp" %>
	    <%@include file="/DAA/compensate/compel/DAACompelCompensatePropEdit.jsp"%>
	    <%@include file="/DAA/compensate/compel/DAACompelCompensatePersonLossEdit.jsp"%>	    
	    
	    <%@include file="/DAA/compensate/compel/DAACompelCompensateNoneDutyEdit.jsp"%>
		<%@include file="/DAA/compensate/compel/DAACompelCompensateNoneInsEdit.jsp"%>
	     
        <%@include file="/DAA/compensate/compel/DAACompensatePropPersonSum.jsp"%>  
        <%@include file="/DAA/compensate/compel/DAACompelCompensateChargeEdit.jsp"%>

        <%-- 6.报案主信息 --%> 
        <%@include file="/DAA/compensate/DAACompensateMainTailEdit.jsp" %>
        <%-- 7.理算报告 --%>
        <%@include file="/DAA/compensate/DAACompensateTextEdit.jsp"%> 
 
        <%--如果是案终赔付，增加结案报告 2005-07-20--%>
        <%@include file="/DAA/compensate/DAAEndCaseCompensateTextEdit.jsp"%>
        
        <%-- 2.单证主信息 --%>
        <%--理算任务处理，屏蔽“工作质量审核信息 ”栏，－刘国安确认--%>
        <%@include file="/DAA/compensate/DAAPrpLqualityCheckEdit.jsp"%>

        <%-- 4.报案信息补充说明 --%>
        <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
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
        <%-- 8.保存通用按钮 --%>
        <%@include file="/DAA/compensate/DAACompensateSave.jsp"%>
        <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>

     </form>
</body>

</html:html>
