<%--
**************************************************************************** 
* DESC       ：调度处理页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-07-21
* MODIFYLIST ：   Name       Date            Reason/Contents
                
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>    
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>    
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.sysframework.common.util.*" %>
<%@ page import="java.util.*" %>
<%@page import="com.sinosoft.claim.util.*"%>
<head>

<html:html locale="true">

<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">


  <!--对title处理-->  
  <title>调度处理</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/schedule/js/DAAScheduleEdit.js"></script>
  
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

 

 <script>
	<!-- 
    /**
     *@description 初始化出险摘要
     *@param       无
     *@return      通过返回true,否则返回false
     */
  	function initRegistText(){
<%
  	  PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)request.getAttribute("prpLscheduleMainWFDto");
  	  PrpLregistDto prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto"); 
      
      DateTime d1 = prpLregistDto.getDamageStartDate();
      DateTime d2= prpLregistDto.getReportDate(); 
      int hour1=Integer.parseInt(DataUtils.nullToZero(prpLregistDto.getDamageStartHour().substring(0,2 )));
      int hour2=Integer.parseInt(DataUtils.nullToZero(prpLregistDto.getReportHour().substring(0,2 )));
        
      DateCompute dateCompute = new DateCompute();
      int afterHour=dateCompute.getDaysHour(d1,hour1,d2,hour2);
      afterHour=48 -afterHour;
      if (afterHour<0) {
%>  	  
      fm.prplRegistFlag.value="出险时间超过了报案限制 <%=-afterHour %> 小时";
      var span1 = eval("showMessage1");
      span1.style.display="";  
      
<%      
    }  
%>  
    
  	} 

	//--> 
  </script>


</head> 

<%  
   //modify by ww add begin 2005-11-15
   //reason: 防止重复提交
   session.setAttribute("oldScheduleLastAccessedTime","");
   //modify by ww add end 2005-11-15
   
  String editType=request.getParameter("editType");
  String saveType1=""; //判断是不是调度类型的
  String nodeType=request.getParameter("nodeType"); //判断是哪个节点上的
  String flowId=request.getParameter("swfLogFlowID"); //工作流号码
  String getbackLogNo=request.getParameter("swfLogLogNo"); //改派的节点号码
  String endflag=request.getParameter("endflag");
  UserDto user = (UserDto) session.getAttribute("user");
  boolean hasSchedFlag = false;         //是否有项目做过调度了 add by liyanjie 2005-12-14
  
  if (editType.equals("SHOW")||editType.equals("DELETE")) {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');"> 
<%
  } else {
%>
<body class=interface onload="initPage();initSet();">
<%
  }
%>  

 
 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
   <% saveType1="GETBACKEDIT";%>
 </logic:equal>

    <form name=fm action="/claim/scheduleSave.do" method="post" onsubmit="return validateForm(this);">

   <input type="hidden" name=nowURL vlaue="<%=request.getRequestURI()%>">
   
  <script language="javascript"> 
<!-- 
javascript:window.history.forward(1); 
//--> 
</script>
</htm>

    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
     <%-- 1.调度主信息头信息 --%>
      <%@include file="/DAA/schedule/DAAScheduleMainEdit.jsp" %>
      <%  
          //判断是否无查勘
          String noCheck="1";
      %>
      
    <%
        //正常调度处理
       if (!"GETBACKEDIT".equals(saveType1))  {    
    %>  <%-- 2.查勘调度标的内容,如果设置了no查勘，则给出标记 --%>
     
      <logic:equal name="prpLscheduleMainWFDto"  property="scheduleType" value="ALLS">
         <%@include file="/DAA/schedule/DAAScheduleCheckItemEdit.jsp" %>
         <%
             noCheck="0";
         %>
      </logic:equal>
    
            
      <%-- 3.定损调度标的内容 --%>
      <%@include file="/DAA/schedule/DAAScheduleItemEdit.jsp" %>
      <%-- 4.报案信息补充说明 --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%> 
 
     <%
       } else { //改派的操作
       if ("check".equals(nodeType)) { //查勘改派%>
    
        <%@include file="/DAA/schedule/DAAScheduleCheckItemEdit.jsp" %>
        <%noCheck="0";%>
     <% 
       } else {  //定损改派
     %>
          <%-- 3.定损调度标的内容 --%>
          <%@include file="/DAA/schedule/DAAScheduleItemEdit.jsp" %>
     <%  
       }
     %>
    
      
<%
  }
%>  
     <%-- 5.调度保存按钮 --%>
     <%@include file="/DAA/schedule/DAAScheduleSave.jsp" %>  
<%     
if (!editType.equals("SHOW")){
%> 		
     <input type="hidden" name="prpLregistLicenseNo" value="<bean:write name='prpLregistDto' property='licenseNo' filter='true' />">
     <input type="hidden" name="newHandlerCode" value="">  <%//用来表示是不是换新人的操作%> 
     <input type="hidden" name="nocheck" value="<%=noCheck%>">
     <input type="hidden" name=saveType value="<%=saveType1%>" >
     <input type="hidden" name=flowId value="<%=flowId%>" >
     <input type="hidden" name=endflag value="<%=endflag%>" >
     <input type="hidden" name=getbackLogNo value="<%=getbackLogNo%>" >
     <input type="hidden" name=getbackNodeType value="<%=nodeType%>" >
     <input type="hidden" name=comcode value="<%=user.getComCode()%>">    <%//调度中心的代码user.getScheduleComCode()%>
     <input type="hidden" name=newcomcode value="<%=user.getComCode()%>"> <%//选择调度处理单位的代码，默认是调度中心的代码%>
     <input type="hidden" name=handlecomcode value="<%=user.getComCode()%>" > <%//当前调度员部门里的人员，估计查勘，定损人应该和调度员是一个部门的%>
<%} %>     
</form>
</body>
</html:html>
