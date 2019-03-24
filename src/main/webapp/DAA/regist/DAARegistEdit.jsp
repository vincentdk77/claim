<%--
****************************************************************************
* DESC       ：报案登记录入/修改页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-02-29
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>


<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" /> 
</head>
 <%
  String editType=request.getParameter("editType");
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();initSet_qs();readonlyAllInput();eidtRegistExt('RegistExt');eidtRegistExt('RegistExt_Data');changeProperties();" onclick="hiddenSpan_message();">
<%
}else if(editType.equals("EDIT")){
%>
<body  onload="initPage();initSet();initSet_qs();changeProperties();" onclick="hiddenSpan_message();" >	
<%
}else
{
%>
<body  onload="initPage();initSet();initSet_qs();changeProperties();addOption();" onclick="hiddenSpan_message();" >	
<%
}
%>
    
    <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <%-- 1.报案主信息 --%>
            <%@include file="/DAA/regist/DAARegistMainEdit.jsp" %>         
        <%-- 1.1.保单保别信息 --%>
            <%//reason:保单承保险别位置上移动，保单号后，只显示承保险别%>
            <%//@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp"%> 
	  	<%-- 2.驾驶员信息 
            <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>--%>
        <%-- 3.涉案车辆 --%>
            <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>      
        <%-- 4.1 财产损失部位信息 --%>
            <%--@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"--%>
        <%-- 4.2 人伤跟踪信息 --%>
            <%--@include file="/DAA/claim/DAAClaimPersonTraceEdit.jsp"--%>
            <%
               if (request.getParameter("paramPrpallRegist") != null && request.getParameter("paramPrpallRegist").equals("DAA")) {
           %>
             <p align="center"><input type="button" name=buttonSave class='button' value="关 闭" onclick="window.close();">
            <%
                } else {
            %>
        <%-- 5.出险备注信息 --%>
            <%@include file="/DAA/regist/DAARegistTextEdit.jsp"%>
        <%-- 6.巨灾信息（国元取消）--%>
            <%--@include file="/DAA/regist/RegistKelpInfo.jsp"--%>         
        <%-- 7.报案信息补充说明 --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
        <%-- 8.保存通用按钮 --%>
            <%@include file="/DAA/regist/DAARegistSave.jsp"%>
            <%
                }
            %>
            <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>
     </form>
</body>
</html:html>