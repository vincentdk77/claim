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
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>

<html:html locale="true">
<head>
  <!--对title处理-->
  <title>立案处理</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAcci/claim/js/AcciClaimEdit.js"></script>
</head>

<%
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//再保危险单位用到
  if (editType.equals("SHOW")){
	  //编辑和查询状态下调用新危险单位赋值
%>
<!--modify by zhulei 20050903 查看页面，按钮要灰掉-->
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');
    disabledAllButton('ClaimLoss');loadDangerUnit();">
<%
}else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();">
<%
}else{
%>
<body class="interface" onload="initPage();initSet();">
<%
}
%>

   <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
	 <%session.setAttribute("oldClaimLastAccessedTime","");%>
   
       <%-- 1.立案主头信息 --%>
       <%@include file="/commonAcci/claim/AcciClaimMainHeadEdit.jsp" %>
      
       <%-- 2.立案尾信息 --%>
       <%@include file="/commonAcci/claim/AcciClaimMainTailEdit.jsp" %>
      
       <%-- 3.事故者信息模块 --%>
       <%@include file="/commonAcci/regist/AcciRegistAcciPerson.jsp"%>
            
       <%-- 4.索赔申请人信息 --%>
       <%@include file="/commonAcci/claim/AcciClaimProposer.jsp"%>
       
       <%-- 5.立案报告 --%>
       <%@include file="/DAA/claim/DAAClaimTextEdit.jsp"%>
       
       <%-- 6.巨灾代码--%>
       <%@include file="/common/claim/ClaimKelpInfo.jsp"%>
      
       <%-- 7.险别估损金额信息 --%>
       <%@include file="/commonAcci/claim/AcciClaimLossEdit.jsp"%>

       <%-- 8.指定危险单位信息 --%>
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
       
       <%-- 9.保存通用按钮 --%>
       <%@include file="/commonAcci/claim/AcciClaimSave.jsp"%>
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

