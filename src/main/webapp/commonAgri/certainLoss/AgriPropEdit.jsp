
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
<%@page import="com.gyic.claim.dto.domain.PrplcompensateearDto"%>   
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>定损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/certainLoss/js/PropCertainLossEdit.js"></script>
  <!-- <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script> -->
  
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%

   //start 防止重复提交---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
   //end---------------------------------------------
//start获得代码版本号
  String  versionType = "";
  String riskCode1=request.getParameter("riskCode");
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
  <!-- 耳标号所有保单号 -->
  <input type="hidden" name="earPolicyNo" value="<bean:write name='prpLregistDto' property='policyNo'/>">
  <input type="hidden" name="versionType" value="<%= versionType %>">
	<input type="hidden" name="versionNo" value="<%= versionNo %>">
        <table width="100%" class=common cellpadding="5" cellspacing="1">
          <tr>
  
            <%
       // 从session里取扶贫/大户标志
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td class="formtitle">规模经营主体系统定损登记</td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td class="formtitle">扶贫系统定损登记</td><% 
			} else {
				%> <td class="formtitle">定损登记</td><% 
			}
		} else {
			%> <td class="formtitle">定损登记</td><% 
		}
      %>

          </tr>
        </table>
    <table cellpadding="5" cellspacing="1" class=common>
    <tr>
 
         <td class=button >
	      <input type="button" name="message" class=bigbutton  value="理赔沟通" onclick="return openWinSaveQuery('<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.policyno.value,fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value,'registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />');">
	   </td>
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

    <%-- 1定损主表的画面 --%>
     <%if("3224".equals(riskCode1)){ %>
      <%@include file="/commonAgri/certainLoss/AgriCertainLossMainEdit3224.jsp"%>
      <%} else
           if("3228".equals(riskCode1)){ %>
      <%@include file="/commonAgri/certainLoss/AgriCertainLossMainEdit.jsp"%>
      <%} else{ %>
       <%@include file="/commonAgri/certainLoss/AgriCertainLossMainEdit.jsp"%>
       <%} %>
    <%-- 2.财产损失清单页面 --%>
    <%-- 
        <logic:equal name="prpLverifyLossDto" property="riskCode" value="3202">
            <%@include file="/commonAgri/certainLoss/Agri3202CertainLossPropEdit.jsp"%>
        </logic:equal>
    --%>
        <logic:notEqual name="prpLverifyLossDto" property="riskCode" value="9999">
            <%@include file="/commonAgri/certainLoss/AgriCertainLossPropEdit.jsp"%>
    <%-- start耳标号清单表 --%>
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">
    <%
    String  familySplittingFlag = "";
    familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
    if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
     <%@include file="/combineAgri/certainLoss/AgricombineCertainLossPropEdit.jsp"%>
     <%}%>
     <%-- end耳标号清单表 --%>
        </logic:notEqual>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
     <%
    String  combineNo = "";
    combineNo = request.getParameter("combineNo");
    if(combineNo != null && combineNo.length()>0){
    %>
     <input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo")%>">
    <%-- 3.保存通用按钮(非绑定案件) --%>
      <%@include file="/combineAgri/certainLoss/AgricombineCertainLossSaveDetail.jsp"%>
     <% } else{%>
     <%-- 3.保存通用按钮(绑定案件) --%>
     <%@include file="/commonAgri/certainLoss/AgriCertainLossSave.jsp"%>
       <% }%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>




