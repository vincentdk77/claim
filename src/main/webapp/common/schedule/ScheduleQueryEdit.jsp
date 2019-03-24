<%--
****************************************************************************
* DESC       ：调度通用查询输入界面
* AUTHOR     ： lixiang	
* CREATEDATE ： 2004-08-05
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import = "java.util.Calendar"%>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>


<%
UserDto user   = (UserDto)request.getSession().getAttribute("user");
String startDate = "";
String endDate ="";       		
DateTime dateTime1 = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
startDate = dateTime1.addDay(-7).toString();
endDate = dateTime1.toString();
%>
<script  type="text/javascript">
    	function submitForm(){
              fm.queryButton.disabled=true;
	          fm.submit();//提交
	          setTimeout('fm.queryButton.disabled=false',5000);
    		  //return true ;
    		
    	}
    </script>		           
		           
		           

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>

<body  onLoad="initPage();">

<form name="fm" action="/claim/scheduleCheckQuery.do"  method="post" onSubmit="return validateForm(this);">
  
    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
	  <tr> 
           
            <td class="formtitle" colspan="4">查询调度信息</td></tr>
      <tr>
        <td width="8%" class='title' style="width:15%">报案号:</td>
        <td width="25%" class='input' style="width:20%">
        <select class=query name="registNoSign" style="width:40px">
         <option value="=">=</option>
           
          </select> 
        <input type=text name="registNo" class="input" style="width:140px">
        </td>
        <td width="9%" class='title' style="width:15%">调度员:</td>
       <td width="28%" class='input'  style="width:20%">
          <input type=text name="handlerCode" class="codecode"  style="width:100px" title="调度员" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');"
             onblur= "code_CodeChange(this, 'HanderCode');">
            <input type=text name="handlerName" readonly class="codecode"  style="width:30%" title="调度员" value="">
        </td>
        <td width="1%" rowspan=5 class='button' style="width:10%">&nbsp;</td> 
      </tr>
      
      <tr>
     
      <td class='title' >调度对象: </td>
       <td class='input' >
       <input type=text class="codecode" name="scheduleObjectID" 
                    style="width:35%" title="具体单位" value=""
                    ondblclick="code_CodeSelect(this, 'ScheduleObject');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject');"
                    onblur= "code_CodeChange(this, 'ScheduleObject');" >
       <input type=text class="codecode"  name="scheduleObjectName"  readonly  title="具体单位" style="width:60%" value="">
        </td>
      
        <td class='title'>车牌号码:</td>
        <td class='input'>
        <select class=query name="prpLscheduleItemLicenseNoSign" style="width:40px">
            <option value="=">=</option>
            <%--<option value="*">*</option>--%>
            
          </select> 
        <input name="prpLscheduleItemLicenseNo" class="input" style="width:140px">
       </td>
      </tr>
       <tr>
	     <td class='title' >调度类型:</td>
       <td class='input'>
        <select name ="scheduleType" style="width:150px">
        <option value="sched" selected> 查勘</option>
        <option value="schel"> 定损</option>
        </select>
      </td>
        
       
        <td width="8%" class='title' style="width:15%">被保险人名称:</td>
        <td width="21%" class='input' style="width:25%">
        <select class=query name="InsuredNameSign" style="width:40px">
         <option value="=">=</option>
           
          </select> 
        <input type=text name="InsuredName" class="input" style="width:140px">
        </td>
      
      </tr>


      <tr>
      <td class='title'>开始时间:</td>
       <td class='input'>
        <input name="startDate" class="Wdate" style="width:150px" value=<%=startDate%> onfocus="WdatePicker()">
        <!-- <img src="/claim/images/bgcalendar.gif" align="middle" style='cursor: hand' onClick="TogglePopupCalendarWindow('document.fm.startDate', '2007', '2017')"> -->      </td>
      <td class='title' >结束时间: </td>
      <td class='input' >
        <input  name="endDate" class="Wdate" style="width:150px" value = <%=endDate%> onfocus="WdatePicker()">
        <!-- <img src="/claim/images/bgcalendar.gif" align="middle" style='cursor: hand' onClick="TogglePopupCalendarWindow('document.fm.endDate', '2007', '2017')"> -->     </td>
    </tr>
    
    <tr>
     <td class='title' >调度状态:</td>
        <td class='input' colspan="3">
        <input type=checkbox name="checkFlag0" >新调度
        <%//<input type=checkbox name="checkFlag2" >正处理%>
        <input type=checkbox name="checkFlag4" >已提交          
      
        </td>
        
         
    </tr>
    </table>
    <div align="center">
      <input type="hidden" name="editType" value="QUERY">
      <input type="hidden" name=comcode value="<%=user.getComCode()%>">
      <span class="button" style="width:10%">
      <!--  <input name="submit" type=submit class='button' value="<bean:message key='button.query.value' />">-->
      <input type="button" value="查询" name="queryButton" class='button' onclick="submitForm()" >
      </span>
    </div>
</form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>

