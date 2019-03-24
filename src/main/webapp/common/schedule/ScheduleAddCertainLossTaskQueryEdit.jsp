<%--
****************************************************************************
* DESC       ：新增定损调度通用查询输入界面
* AUTHOR     ： wangli	
* CREATEDATE ： 2005-04-12
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
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>

<%
  //得到本周周一与周日的日期
  //Date date = new Date();
  //String strMonday = ""; //date.getMondayOFWeek();
  //String strSunday = ""; //date.getSundayOFWeek();
  
  String strSunday =DateTime.current().toString();
  String strMonday = new DateTime(DateTime.current().addDay(-4),DateTime.YEAR_TO_DAY ).toString() ; 
%>



<html:html locale="true">
<head>
  <title>新增定损调度通用查询输入界面</title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>


<body  onLoad="initPage();">

<form name="fm" action="/claim/scheduleCheckQuery.do"  method="post" onSubmit="return validateForm(this);">

 <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
	  <tr> 
           
            <td class="formtitle" colspan="4">新增定损调度查询</td></tr>
      <tr>
        <td class='title' style="width:15%">报案号:</td>
        <td class='input' style="width:25%">
        <select class=query name="registNoSign" style="width:40px">
            <option value="=">=</option>
            <option value="*">*</option>
          </select> 
        <input type=text name="registNo" class="input" style="width:140px">
        </td>
        
        <td class='title' style="width:15%">车牌号码:</td>
        <td class='input'>
        <select class=query name="prpLscheduleItemLicenseNoSign" style="width:40px">
            <option value="=">=</option>
            <%--<option value="*">*</option>--%>
          </select> 
        <input name="prpLscheduleItemLicenseNo" class="input" style="width:140px">
        </td>

        <td class='button' style="width:20%" rowspan=6>&nbsp;</td> 
      </tr>
      <tr>
      <td class='title' style="width:15%">开始时间:</td>
       <td class='input'>
        <input name="startDate" class="Wdate" onfocus="WdatePicker()" style="width:120px" value=<%=strMonday%>>
        <!-- <img src="/claim/images/bgcalendar.gif" align="middle" style='cursor: hand' onClick="TogglePopupCalendarWindow('document.fm.startDate','2007', '2017')"> -->      </td>
      <td class='title'  style="width:15%">结束时间: </td>
      <td class='input'>
        <input  name="endDate" class="Wdate" onfocus="WdatePicker()" style="width:120px" value = <%=strSunday%>>
        <!-- <img src="/claim/images/bgcalendar.gif" align="middle" style='cursor: hand' onClick="TogglePopupCalendarWindow('document.fm.endDate','2007', '2017')">     -->  </td>
    </tr>
	 <tr>
        <td class='title' style="width:15%">被保险人：</td>
        <td class='input' style="width:25%"colspan=3>
          <select class=query name="InsuredNameSign" style="width:40px" >
            <option value="=">=</option>
            <option value="*">*</option>  
          </select> 
          <input type=text name="InsuredName" class="input" style="width:140px" value="">
        </td>
      </tr>
    </table>
    <div align="center">
      <input type="hidden" name="editType" value="ADDQUERY">
      <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
      <span class="button" style="width:20%">
      <input name="submit" type=submit class='button' value="<bean:message key='button.query.value' />">
      </span>
    </div>
</form>
</body>
</html:html>