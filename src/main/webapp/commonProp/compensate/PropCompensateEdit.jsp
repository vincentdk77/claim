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
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLclaimLoss"%>
<%@page import="com.sinosoft.prpall.schema.PrpLclaimLossSchema"%>
<%@page import="com.sinosoft.prpall.blsvr.lp.BLPrpLloss"%>
<%@page import="com.sinosoft.prpall.schema.PrpLlossSchema"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>
<%@page import="com.gyic.claim.bl.facade.BLInsuremainlistFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade"%>
<%@page import="com.sinosoft.utility.SysConfig"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/compensate/js/PropCompensateEdit.js"></script>
  <script src="/claim/commonProp/compensate/js/PropPersonLossEdit.js"></script>
  
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<%

  //modify by ww add begin 2005-11-15
  //reason: 防止重复提交
  session.setAttribute("oldCompensateLastAccessedTime","");
  //modify by ww add end 2005-11-15
   
  UserDto   user     = (UserDto)session.getAttribute("user");
  String riskCode = "";
  if(user==null||user.equals("")){
      riskCode = request.getParameter("riskCode");
  }else{
      riskCode = user.getRiskCode();
  }
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  String riskType=(String)request.getAttribute("riskType");
  boolean hasHeadInsureList = false;
  String restrRiskCode ="";
  
  if(("0311").equals(riskCode)){
  //立案号
  String  strClaimNo = request.getParameter("ClaimNo");
  String policyNo="";
  String strCompensateCompensateNo = request.getParameter("prpLcompensateCompensateNo");
  
  Date compInputDate = new Date();
  
  if(null!=strCompensateCompensateNo&&!"".equals(strCompensateCompensateNo)){
  BLPrpLcompensateFacade prpLcompensateFacade=new BLPrpLcompensateFacade();
  PrpLcompensateDto prpLcompensateDto=new PrpLcompensateDto();
  prpLcompensateDto=(PrpLcompensateDto)prpLcompensateFacade.findByPrimaryKey(strCompensateCompensateNo);
  policyNo=prpLcompensateDto.getPolicyNo();
  restrRiskCode = prpLcompensateDto.getRiskCode();
  compInputDate = prpLcompensateDto.getStatisticsYM();
  }
  if(null==policyNo||"".equals(policyNo)){
	  policyNo= request.getParameter("policyNo");
  }
  //先对应当有清单的种险做判断。
  if(("0311".indexOf(riskCode) > -1)){
     String conditionsOfFatchInsureMainList = " policyNo = '"+policyNo+"' and validity = '2' ";
     BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
       Collection blInsureMainListCollection = blInsureMainListFacade.findByConditions(conditionsOfFatchInsureMainList);
       System.err.println(conditionsOfFatchInsureMainList);
       if(null!=blInsureMainListCollection && blInsureMainListCollection.size()>0){
         hasHeadInsureList = true;
       }
  }
  }
  
  //编辑和查询状态下调用新危险单位赋值
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();setreadonlyforhouse();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();hideButton();onLoadZeroLossCaseType();initForAdd();">
<%
  }else{
%>
<body class="interface" onload="initPage();initSet();calLoss();calFund();hideButton();onLoadZeroLossCaseType();initForAdd();">
<%
  }
%>
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
   <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
   <input type="hidden" name="businessFlag" value="<%=(String)request.getAttribute("businessFlag") %>">
   <input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">

    <%-- 1.报案主信息 --%>
        <%@include file="/commonProp/compensate/PropCompensateMainHeadEdit.jsp" %>
    <%-- 2.特别约定 --%>
         <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    
        <%
        if("J".equals(riskType)){
        %>
            <%-- 3.赔付标的信息 --%>
            <%@include file="/commonProp/compensate/PropJCompensateLlossEdit.jsp"%>
        <%
        }else if("ZH03".equals(riskCode)){
        %>
          <%-- 3.赔付标的信息 --%>
          <%@include file="/ZH03/compensate/PropZH03CompensateLlossEdit.jsp"%>
        <%}else if("2207".equals(riskCode) || "2208".equals(riskCode)){
        %>	
        	
          <%@include file="/commonProp/compensate/PropCompensateLlossEdit2207.jsp"%>
        
        <%}else   if((("0311".indexOf(riskCode) > -1)&&hasHeadInsureList)){%>
        
         <%-- <%}   if((("0311".indexOf(riskCode) > -1)&&hasHeadInsureList)){%>--%>
        <%@include file="/commonProp/compensate/TemblorNewCompensateLlossEdit.jsp"%>
        <%}else{%>

          <%-- 3.赔付标的信息 --%>
          <%@include file="/commonProp/compensate/PropCompensateLlossEdit.jsp"%>
        <%
        }
        %>
        
        <%if("0310".equals(riskCode)||"0312".equals(riskCode)){ %>
        <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
        
        <%} %>
        
    <%-- 4.赔款费用 --%>
        <%@include file="/commonProp/compensate/PropCompensateChargeEdit.jsp"%>
    <%-- 5.尾信息 --%>
        <%@include file="/commonProp/compensate/PropCompensateMainTailEdit.jsp" %>
    <%-- 6.计算过程--%>
        <%@include file="/commonProp/compensate/PropEndCaseCompensateTextEdit.jsp"%>
    <%-- 7.理算报告 --%>
        <%@include file="/commonProp/compensate/PropCompensateTextEdit.jsp"%>

      <logic:notEmpty name="coinsFlag"  >
		<logic:equal name='coinsFlag' value="2">
			<%@include file="/common/compensate/CompensateCommonCoins.jsp"%>
		</logic:equal>
		<logic:equal name='coinsFlag' value="1">
			<%@include file="/common/compensate/CompensateCommonCoins.jsp"%>
		</logic:equal>
      </logic:notEmpty>
    <%-- 8.付款说明 --%>
        <%@include file="/common/compensate/CompensatePayTextEdit.jsp" %>
    <%-- 9.危险单位信息 --%>
     <%
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    //用旧的危险单位信息页面
	    if(time<0){
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
    <%-- 10.保存通用按钮 --%>
      <%@include file="/commonProp/compensate/PropCompensateSave.jsp"%>
      <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>

     </form>
</body>
</html:html>