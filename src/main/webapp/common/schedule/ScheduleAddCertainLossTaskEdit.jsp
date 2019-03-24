<%--
****************************************************************************
* DESC       ：第三者车辆信息页面
* AUTHOR     ：wangli
* CREATEDATE ：2005-04-12
* MODIFYLIST ：   Name       Date            Reason/Contents  
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>


<html:html locale="true">
<head>
  <!--对title处理-->  
  <title>涉案车辆</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
 <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>
 <script src="/claim/DAA/schedule/js/DAAScheduleThirdParty.js"></script>
</head>        
<body class="interface" onload="initPage();readonlyAllTableInput('readonlyThirdPartyTable');readonlyAllTableInput('readonlyThirdPropTable');readonlyAllTableInput('readonlyPersonTraceTable');check_person();"> 
<%-- //<body class="interface" > --%>

       <%-- 1.界面信息 --%>
      <%@include file="/common/schedule/ScheduleAddCertainLossTaskMainEdit.jsp" %>
      
    <form name=fm action="/claim/scheduleAddCertainLossSave.do" method="post" onsubmit="return validateForm(this,'ThirdParty_Data');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden"  name="businessNo" value="<%= request.getAttribute("businessNo") %>">
    <input type="hidden"  name="prpLcheckRiskCode" value="DAA"><!--隐藏险种代码-->
    <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
    <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
   <input type="hidden" name="policyNo" value="<%= request.getParameter("policyNo") %>">
    <input type="hidden" name="editType" value="EDIT">
    <!-- commiFlag add by liyanjie  2005-12-17 此新增定损调度任务的双代标志:1:出险地方调度任务; 2:承保方调度任务; 其他:正常任务 -->
	  <input type="hidden" name="commiFlag" value="<%= request.getAttribute("commiFlag") %>">

    
      <%-- 涉案车辆 --%>
      <%@include file="/DAA/schedule/DAAScheduleThirdPartyEdit.jsp"%>  
      <%@include file="/DAA/schedule/DAAScheduleThirdPropEdit.jsp"%> 
      <%@include file="/DAA/schedule/DAASchedulePersonTraceEdit.jsp"%> 
       
        <table id=save align="center">
        <tr>
           <td class=button style="width:100%" align="center">
            <!--保存按钮-->
           <input type="submit" name=buttonSave class='button' value="保 存" onclick ="return saveThirdParty(this);" >
         </td>       
         </tr>
         </table>

 </form>   
 
</body>


<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
