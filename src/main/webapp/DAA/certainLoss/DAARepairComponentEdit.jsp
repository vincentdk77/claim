<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%--
****************************************************************************
* DESC       ：定损登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-13
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
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@page import="com.sinosoft.sysframework.common.datatype.*" %>
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
  <script src="/claim/DAA/certainLoss/js/DAACertainLossRepairComponentEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
	<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<%
//start 防止重复提交---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
    //Reason:取出该员工理赔业务权限
    PrpLclaimGradeDto prpLclaimGradeDto = (PrpLclaimGradeDto)request.getAttribute("prpLclaimGradeDto");
    UserDto   user      = (UserDto)session.getAttribute("user");  
    boolean isShowButton = true;
    //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
    if(user == null){
        isShowButton = false;
    }
    String strPrpLclaimGradeFlag = "";
    double prpLclaimGradeValueLower = 0;
    double prpLclaimGradeValueUpper = 0;
    if(prpLclaimGradeDto==null)
    {
      strPrpLclaimGradeFlag = "1";
    }
    else 
    {
      prpLclaimGradeValueLower = prpLclaimGradeDto.getValueLower();
      prpLclaimGradeValueUpper = prpLclaimGradeDto.getValueUpper();
    }

    //Modify by chenrenda add end 20050418
    String editType=request.getParameter("editType");
%>
<%
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();readonlyAllInput();">
<%
  //Modify by chenrenda update begin 20050317
  //Reason:修理项目费用增加时默认有3项
  } else if(editType.equals("ADD")){
	
%>
    <body  onload="initPage();initSet();">
<%
    
    }
  //Modify by chenrenda update end 20050317
    else
    {
%>
    <body  onload="initPage();initSet();">
<%
    }
%>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">

      <%--Modify by chenrenda add begin 20050418--%>
      <input type="hidden" name="prpLclaimGradeValueLower" value="<%=prpLclaimGradeValueLower%>">
      <input type="hidden" name="prpLclaimGradeValueUpper" value="<%=prpLclaimGradeValueUpper%>">
      <input type="hidden" name="prpLclaimGradeFlag" value="<%=strPrpLclaimGradeFlag%>">
      <%--Modify by chenrenda add end 20050418--%>
      <%
     String certainLossFirst = (String)request.getAttribute("prplCertianLossFirst");
%>
    <input type="hidden" name="certainLossFirst" value="<%=certainLossFirst%>">

  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="riskcode" value="<bean:write name='prpLregistDto' property='riskCode'/>">
  <input type="hidden" name="policyno" value="<bean:write name='prpLregistDto' property='policyNo'/>">
  <table  class="common">
    <tr>
    <%if(isShowButton){ %>
      <td><input type="button" class=bigbutton name="message" value="理赔沟通" onclick="openWinSaveQuery(fm.RegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'certa',fm.prpLverifyLossClaimNo.value,'registNo',fm.RegistNo.value);"></td>
    <%} %>  
      <td><input type="button" class=bigbutton name="eCertify" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','certa');"></td>
      <td><input type="button" class="bigbutton" name="buttonCertifyDirect" value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLregistDto' property='registNo'/>','certa')"></td>
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1">
  <tr> <td class="formtitle">定损登记</td></tr>
  </table>
    <%!
      int indexCertainLoss = 0;
      int repairFeeNo = 0;
      int componentNo = 0;
      String flag = null; // 判断是否核损退回业务：退回Flag  = 1
    %>
    <%
      flag = request.getParameter("flag");
    %>

      <%-- 定损主表的画面 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp"%>
      <%-- 1.定损环节过程的修理/换件清单页面 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossRepairComponentEdit.jsp"%>
      <%-- 3. 核价、核损意见、备注 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
      <%-- 4. 定核损信息补充说明 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <%-- 5.报案信息补充说明 --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
      <%-- 保存通用按钮 --%>
      <%if (editType.equals("SHOW")){%>
  		<table cellpadding="0" cellspacing="0" width="80%" class="common">
	 		<tr><%-- 只显示返回按钮--%>
				<td>
	        <input  type="hidden" name=buttonSaveType value="1"> 
		    </td>
			</tr>  
  		<tr>  
     	 	<td class=button style="width:33%" align="center">
			  <!--取消按钮-->
			    <input type=button name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-1);" >
			  </td> 
			</tr>
		</table>  
	<%
	  }else{
	%> 
      <%@include file="/DAA/certainLoss/DAACertainLossSave.jsp"%>
  <%
  	}
  %>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
      <%-- 打印定损清单、损失确认书 及检验定损报告 --%>
      <%//@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"%>
  </form>
</body>
</html:html>




