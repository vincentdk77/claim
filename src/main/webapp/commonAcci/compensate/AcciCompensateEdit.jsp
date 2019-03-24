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
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>
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
  <script src="/claim/commonAcci/compensate/js/AcciCompensateEdit.js"></script>
  <script src="/claim/commonAcci/compensate/js/AcciPersonLossEdit.js"></script>
</head>

<%
  //modify by liuyanmei add start 20051027
  //-只允许有核赔权限的人看到申请调查按钮---------
  String cancheck = "0"; 
  String userCode="";
  cancheck="1";
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  
   //--只允许上次提调结束后才能再次申请提调-------- 
   String registNo = request.getParameter("RegistNo"); 
   String fowid    = request.getParameter("swfLogFlowID");
   String logNo    = request.getParameter("swfLogLogNo");
   String checkNotOver="0";
   String  conditions2 = "  flowid='"+fowid+"' and nodetype='check'";
   SwfLogDto  swfLogDto = null;
  
   UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
   
   Collection  swfLogDtoList = uiWorkFlowAction.findNodesByConditions(conditions2);
   
    if(swfLogDtoList.isEmpty()){
      checkNotOver="0";
       
     }
    else if(swfLogDtoList.size()!=0) { 
      
     int i=0;
     if(swfLogDtoList.iterator().hasNext()){
        swfLogDto=(SwfLogDto)swfLogDtoList.iterator().next();
        String nodeStatus=swfLogDto.getNodeStatus();
        if (!nodeStatus.equals("4")){
          checkNotOver="1";
          
        }
        
     }
  } 
  
   //modify by ww add begin 2005-11-15
   //reason: 防止重复提交
   try {
      session.setAttribute("oldCompensateLastAccessedTime","");
      //modify by ww add end 2005-11-15
      //modify by liuyanmei end start 20051027
 
         UserDto   user     = (UserDto)session.getAttribute("user");
         String riskCode = "";
         if(user==null||user.equals("")){
           riskCode = request.getParameter("riskCode");
         }else{
           riskCode = user.getRiskCode();
         }
  }
   catch(Exception usee)
    { }
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  //编辑和查询状态下调用新危险单位赋值
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else {
%>
<body class="interface" onload="initPage();initSet();calFund();onLoadZeroLossCaseType();">
<%
  }
%>
  <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <!--modify by liuyanmei add start 20051029--->
    <input type="hidden" name ="cancheck"  value="<%=cancheck%>">
    <input type="hidden" name ="checkNotOver"  value="<%=checkNotOver%>">
    <input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">
    <!--modify by liuyanmei add end 20051029--->
    
    <%-- 1.理算主信息 --%>
        <%@include file="/commonAcci/compensate/AcciCompensateMainHeadEdit.jsp" %>
    <%-- 2.特别约定 --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 3.事故者信息模块 --%>
       <%@include file="/commonAcci/regist/AcciRegistAcciPerson.jsp"%>
    <%-- 3.5事故者详细信息模块 --%>

<%@include file="/commonAcci/compensate/AcciCompensateInjuryPersonInfo.jsp"%>
    <%-- 4.索赔申请人信息 --%>
       <%@include file="/commonAcci/claim/AcciClaimProposer.jsp"%>
    <%-- 5.赔付人员信息 --%>
       <%@include file="/commonAcci/compensate/AcciCompensatePersonLossEdit.jsp"%>
    <%-- 6.赔款费用 --%>
        <%@include file="/commonAcci/compensate/AcciCompensateChargeEdit.jsp"%>
    <%-- 7.理算尾信息 --%>
        <%@include file="/commonAcci/compensate/AcciCompensateMainTailEdit.jsp" %>
     <%--8.赔款计算过程 --%>
        <%@include file="/commonAcci/compensate/AcciCompensateTextEdit.jsp"%>
      <logic:notEmpty name="coinsFlag"  >
		<logic:equal name='coinsFlag' value="2">
			<%@include file="/common/compensate/CompensateCommonCoins.jsp"%>
		</logic:equal>
		<logic:equal name='coinsFlag' value="1">
			<%@include file="/common/compensate/CompensateCommonCoins.jsp"%>
		</logic:equal>
      </logic:notEmpty>
    <%-- 9.审核批文  国元项目组 屏蔽审核批文--%>
        <%@include file="/commonAcci/compensate/AcciCompensateTextEdit2.jsp"%>
    <%-- 10.指定危险单位信息 --%>
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
        <%@include file="/commonAcci/compensate/AcciCompensateSave.jsp"%>
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
