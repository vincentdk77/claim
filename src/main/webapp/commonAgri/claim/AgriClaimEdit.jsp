<%--
****************************************************************************
* DESC       ：立案登记录入/修改页面(非车险)
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>

<html:html locale="true">
  <!--对title处理-->
  <title>立案处理</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/claim/js/PropClaimEdit.js"></script>
  <script src="/claim/common/js/Validate.js"></script>
</head>

<%
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String riskCode1=request.getParameter("riskCode");
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
  //取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  String type = "";
  String getEarNoFrom = "claim";
  if (editType.equals("ADD")){
  	getEarNoFrom = "certa";
  }
  if (editType.equals("SHOW")){
  	type = "none";
	  //编辑和查询状态下调用新危险单位赋值
%>
<!--modify by zhulei 20050903 查看页面，按钮要灰掉-->
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');
    disabledAllButton('ClaimLoss_button');disabledAllButton('ClaimLoss');loadDangerUnit();">
<%
}else{
%>
<body class="interface" onload="initPage();initSet();">
<%
}
%>

   <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
	   <%session.setAttribute("oldClaimLastAccessedTime","");%>
	   <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
	   <!-- 耳标号所有保单号 -->
       <input type="hidden" name="earPolicyNo" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
       <input type="hidden" name="familySplittingFlag" value="<%=request.getAttribute("familySplittingFlag") %>">
       <input type="hidden" name="versionType" value="<%= versionType %>">
		<input type="hidden" name="versionNo" value="<%= versionNo %>">
		<input type="hidden" name="riskCode1" value="<%= riskCode1 %>">
       <%-- 1.立案主头信息 --%>
       <%@include file="/commonAgri/claim/AgriClaimMainHeadEdit.jsp" %>

       <%-- 2.立案中间信息 --%>
       <%if("3224".equals(riskCode1)) {%> 
       <%@include file="/commonAgri/claim/AgriClaimMainMiddleEdit3224.jsp" %>
       <%} else
       if("3228".equals(riskCode1)){ %>
      <%@include file="/commonAgri/claim/AgriClaimMainMiddleEdit.jsp"%>
       <%}else{ %>
       <%@include file="/commonAgri/claim/AgriClaimMainMiddleEdit.jsp" %>
       <%} %>
       
       <%-- 3.立案尾信息 --%>
       <%@include file="/commonAgri/claim/AgriClaimMainTailEdit.jsp" %>
       <%--  耳标号信息 --%>
       <%
        String  familySplittingFlag = "";
        familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
        if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
        <%@include file="/commonAgri/claim/AgriClaimEarNoEdit.jsp"%>
        <%}%>
       <%-- 4.事故者信息 --%>
       <%-- 现在国元的 奶牛保险走公共的农险程序
       <logic:equal name='prpLclaimDto' property="riskCode" value="3202">
           <%@include file="/commonAgri/regist/AgriRegistAgri3202Person.jsp"%>
       </logic:equal>
        --%>
       <logic:notEqual name="prpLclaimDto" property="riskCode" value="9999">
           <table class=common>
           <%@include file="/commonAgri/regist/AgriRegistAgriPerson.jsp"%>
           </table>
       </logic:notEqual>
        
       
       <%-- 5.立案报告 --%>
       <%@include file="/commonAgri/claim/AgriClaimTextEdit.jsp"%>

	   <%-- 6.险别估损金额信息 --%>
	    <%-- 现在国元的 奶牛保险走公共的农险程序
	   <logic:equal name='prpLclaimDto' property="riskCode" value="3202">
           <%@include file="/commonAgri/claim/Agri3202ClaimLossEdit.jsp"%>
       </logic:equal>
       --%>
       <logic:notEqual name="prpLclaimDto" property="riskCode" value="9999">
           <%@include file="/commonAgri/claim/AgriClaimLossEdit.jsp"%>
       </logic:notEqual>
        <%-- 7.指定危险单位信息 --%>
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
        <%@include file="/common/claim/ClaimNewRiskUnit.jsp"%>
     <%} %>
       <%-- 8.保存通用按钮 --%>
       <%@include file="/commonAgri/claim/AgriClaimSave.jsp"%>
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
