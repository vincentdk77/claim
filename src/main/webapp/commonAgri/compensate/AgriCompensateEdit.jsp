<%--
****************************************************************************
* DESC       ：实赔录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*                chenrd      20070718        农险团单并整理代码
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
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
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/compensate/js/PropCompensateEdit.js"></script>
  <script src="/claim/commonAgri/compensate/js/PropPersonLossEdit.js"></script>
  
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<%

  //modify by ww add begin 2005-11-15
  //reason: 防止重复提交
  session.setAttribute("oldCompensateLastAccessedTime","");
  //modify by ww add end 2005-11-15
 //start获得代码版本号
  String  versionType = "";
  String  versionNo = "";
	BLPrpCmain blPrpCmain= new BLPrpCmain();
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
	blPrpCmain.getData(request.getParameter("policyNo"));
	if(blPrpCmain.getSize() == 1){
		prpCmainSchema = blPrpCmain.getArr(0);
		 if(!(prpCmainSchema.getVersionNo()==null ||prpCmainSchema.getVersionNo()==""))
		  {
			  versionType = prpCmainSchema.getVersionNo().substring(0,1);
			  versionNo = prpCmainSchema.getVersionNo();
		  }
	}
  //end获得代码版本号
   String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  //取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  UserDto   user     = (UserDto)session.getAttribute("user");
  String riskCode = "";
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  boolean hasHeadInsureList = false;//判断种植险是否含有投保清单，有清单的走新冲减保费方法，无清单走老冲减保费方法。
  String planting31FarmerListFlag = "";//判断非中央政策性种植险的参数，多险别，多标的种植险。
  if(user==null||user.equals("")){
      riskCode = request.getParameter("riskCode");
  }else{
      riskCode = user.getRiskCode();
  }
  HashMap map = new HashMap();
  
  boolean isNewKindCompensate = false;//3137险种理算页面控制
  if("31".equals(riskCode.substring(0,2))||("3228").equals(riskCode)||("3224").equals(riskCode)||
	 "3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1){
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
  compInputDate = prpLcompensateDto.getStatisticsYM();
  }
  if(null==policyNo||"".equals(policyNo)){
	  policyNo= request.getParameter("policyNo");
  }
  //先对应当有清单的种险做判断。
  if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)){
     String conditionsOfFatchInsureMainList = " policyNo = '"+policyNo+"' and validity = '2' ";
     BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
       Collection blInsureMainListCollection = blInsureMainListFacade.findByConditions(conditionsOfFatchInsureMainList);
       System.err.println(conditionsOfFatchInsureMainList);
       if(null!=blInsureMainListCollection && blInsureMainListCollection.size()>0){
         hasHeadInsureList = true;
       }
  }
	try {
		planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
	} catch (RuntimeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  BLPrpLloss loss1 = new BLPrpLloss();
  PrpLlossSchema schema1 = new PrpLlossSchema();
  BLPrpLclaimLoss loss = new BLPrpLclaimLoss();
  PrpLclaimLossSchema schema = new PrpLclaimLossSchema();
 
  if("3137".indexOf(riskCode)>-1){
	  Calendar bugFixCal = Calendar.getInstance();
	  Date bugFixDate = new Date();
	  bugFixCal.set(2013,11,6);//3137险种理算bug修复日期3013-11-06，之前的理算单子，走老的显示页面，此日期之后走新的页面显示。
	  bugFixDate = bugFixCal.getTime();
	  if(!editType.equals("SHOW") || compInputDate.before(bugFixDate))
	  	isNewKindCompensate = true;
  }
  if((strClaimNo == null) ||("".equals(strClaimNo))){
	  loss1.query(" compensateno = '"+strCompensateCompensateNo+"'");
  }else{
	  loss.query(" ClaimNo = '"+strClaimNo+"'");
  }
%>
 <script>
	var map = new Array();
	Array.prototype.get = function(key){
		for(var i = 0;i< this.length;i++){
			 var temp = this[i];
			 if(temp.kindCode == key){
				return temp.lossValue;
			}
		}
	}
  <%
  if((strClaimNo == null) ||("".equals(strClaimNo))){
    for(int i=0; i <loss1.getSize();i++ ){
	  String key   = "";
	  String value = "";
	  schema1 =loss1.getArr(i);
      key  = schema1.getKindCode();
      value = schema1.getSumLoss();
  %>    
  	var obj = Object();
	obj.kindCode  ="<%=key%>";
	obj.lossValue ="<%=value%>";
	map.push(obj);
  <%
    }
  }else{
	    for(int i=0; i <loss.getSize();i++ ){
	  	  String key   = "";
	  	  String value = "";
	  	  schema =loss.getArr(i);
	      key  = schema.getKindCode();
	      value = schema.getSumClaim();
	    %>    
	    var obj = Object();
	  	obj.kindCode  ="<%=key%>";
	  	obj.lossValue ="<%=value%>";
	  	map.push(obj);
	    <%
	      }  
  }
  }
%>
</script>
<%
//编辑和查询状态下调用新危险单位赋值
if (editType.equals("SHOW")){
	if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)&&hasHeadInsureList){
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadCompensateLoss();onLoadZeroLossCaseType();loadDangerUnit();">
<%}else if(null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1){
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadCompensateLoss();onLoadZeroLossCaseType();">
<%}else if(isNewKindCompensate){
//3137险种理算bug修复日期，之前的理算单子，走老的显示页面，此日期之后走新的页面显示。
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');LoadUnitAmount();onLoadZeroLossCaseType();">
<%}else { %>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');onLoadZeroLossCaseType();">
<%}
}else if(editType.equals("EDIT")&&("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)&&hasHeadInsureList){
%>
<body class="interface" onload="loadCompensateLoss();onLoadZeroLossCaseType();loadDangerUnit();">
<%
}
if(editType.equals("EDIT")&&( null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1 )){
%>
<body class="interface" onload="loadCompensateLoss();onLoadZeroLossCaseType();">
<%
}else if(isNewKindCompensate){
//3137险种理算bug修复日期，之前的理算单子，走老的显示页面，此日期之后走新的页面显示。
%>

<body class="interface" onload="initPage();initSet();calFund();LoadUnitAmount();onLoadZeroLossCaseType();">
<%
}else {
%>

<body class="interface" onload="initPage();initSet();calFund();onLoadZeroLossCaseType();">
<%
}
%>
 
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
      <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
    <input type="hidden" name="riskType" value="<%= request.getAttribute("riskType") %>">
    <!-- 耳标号所有保单号 -->
   	<input type="hidden" name="earPolicyNo" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
   	<input type="hidden" name="familySplittingFlag" value="<%=request.getAttribute("familySplittingFlag") %>">
   	<input type="hidden" name="planting31FarmerListFlag" value="<%=planting31FarmerListFlag %>">
    <input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">
   	<input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">
    <%-- 1.理算主信息 --%>
        <%@include file="/commonAgri/compensate/AgriCompensateMainHeadEdit.jsp" %>
    <%-- 2.特别约定 --%>
         <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 3.赔付标的信息 --%>
        <%if((("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3234,3240,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode) > -1)&&hasHeadInsureList)||( null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1 )){%>
        <%@include file="/commonAgri/compensate/AgriNewCompensateLlossEdit.jsp"%>
        <%}else{%>
        <%@include file="/commonAgri/compensate/AgriCompensateLlossEdit.jsp"%>
        <%}%>
    <%--  耳标号信息 --%>
       <%
        String  familySplittingFlag = "";
        familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
        if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
        <%@include file="/commonAgri/compensate/AgriCompensateEarNoEdit.jsp"%>
        <%}%>
    <%-- 4.赔款费用 --%>
        <%@include file="/commonAgri/compensate/AgriCompensateChargeEdit.jsp"%>
    <%-- 5.理算尾信息 --%>
        <%@include file="/commonAgri/compensate/AgriCompensateMainTailEdit.jsp" %>
    <%-- 6.理算报告 --%>
        <%@include file="/commonAgri/compensate/AgriEndCaseCompensateTextEdit.jsp"%>
    <%-- 7.赔款计算过程 --%>
        <%@include file="/commonAgri/compensate/AgriCompensateTextEdit.jsp"%>
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
    <%-- 9.指定危险单位信息 --%>
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
    <%-- 10.保存通用按钮 --%>
        <%@include file="/commonAgri/compensate/AgriCompensateSave.jsp"%>
        <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>

     </form>
     
<% //大棚蔬菜走自己的理算公式
  if("3102".equals(riskCode)){
%>
	<script src="/claim/commonAgri/compensate/js/PropCompensate3102Edit.js"></script>
<%  				  
  }
%>

		
</body>
</html:html>