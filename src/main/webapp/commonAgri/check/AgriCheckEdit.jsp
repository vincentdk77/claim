
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
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      查勘登记
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/check/js/PropCheckEdit.js"></script>
  <script src="/claim/commAgri/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
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
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();initSet();">
<%
}

%>

    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
    <!-- 耳标号所有保单号 -->
    <input type="hidden" name="earPolicyNo" value="<bean:write name='prpLcheckDto' property='policyNo'/>"> 
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">  
    <input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">
      
       
        <%-- 1.查勘/代查勘头信息 --%>
          <%@include file="/commonAgri/check/AgriCheckMainHeadEdit.jsp" %>
       
         <%-- 2.查勘中信息 --%>
          <%--@include file="/commonAgri/check/AgriCheckMainMiddleEdit.jsp" --%>
         <%-- 3.查勘尾信息 --%>
           <%@include file="/commonAgri/check/AgriCheckMainTailEdit.jsp" %>
   <%if("3224".equals(riskCode1)) {%>        
         <%-- 国元项目组定损信息 --%>
          <%@include file="/commonAgri/check/AgriCheckVerifyLossEdit3224.jsp" %>
                <%} else
   if("3228".equals(riskCode1)){ %>
      <%@include file="/commonAgri/check/AgriCheckVerifyLossEdit.jsp"%>
   <%}else{ %>    
         <%@include file="/commonAgri/check/AgriCheckVerifyLossEdit.jsp" %>
   
    <%} %>
             <%-- 3.财产损失清单页面 --%>
        <%@include file="/commonAgri/check/AgriCheckCertainLossPropEdit.jsp"%>
        <%
        String  familySplittingFlag = "";
        familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
        if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
        <%@include file="/combineAgri/certainLoss/AgricombineCertainLossPropEdit.jsp"%>
        <%}%>
         <%-- 4.查勘备注信息 --%>
          <%@include file="/commonAgri/regist/AgriRegistTextEdit.jsp"%>
          <%--5.估损金额信息 --%>
         <%--@include file="/commonAgri/claim/AgriClaimFeeEdit.jsp"--%>
          <%--5.保存通用按钮 --%>
          <%@include file="/commonAgri/check/AgriCheckSave.jsp" %>

     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
