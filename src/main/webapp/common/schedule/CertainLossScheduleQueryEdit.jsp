<%--
****************************************************************************
* DESC       ：定损调度查询输入界面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13
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
  String strMonday = new DateTime(DateTime.current().addMonth(-1),DateTime.YEAR_TO_DAY ).toString() ; 
%>



<html:html locale="true">
<head>
  <title>查询定损信息</title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>



<body onLoad="initPage();">

<form name="fm" action="/claim/scheduleCheckQuery.do"  method="post" onSubmit="return validateForm(this);" >

 <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
	  <tr> 
           
            <td class="formtitle" colspan="4">查询定损信息</td></tr>
      <tr>
        <td width="12%" class='title' style="width:10%">报案号:</td>
        <td width="27%" class='input' style="width:25%">
          <input type=text name="registNo" class="input">        </td>
        <td width="12%" class='title' style="width:10%">调度员:</td>
        <td width="41%" class='input' style="width:25%">
          <input type=text name="handlerCode" class="codecode"  style="width:100px" title="调度员" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
            <input type=text name="handlerName" class="codecode" readonly style="width:30%" title="调度员" value="">        </td>

        <td width="8%" rowspan=4 class='button' style="width:20%">&nbsp;</td> 
      </tr>
      
      
      <tr>
         <td class='title' style="width:10%">定损人:</td>
        <td class='input' style="width:25%" >
          <input type=text name="NhandlerCode" class="codecode"  style="width:100px" title="查勘人" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
            <input type=text name="NhandlerName" class="codecode" readonly style="width:30%" title="查勘人" value="">        </td>
         <td class='title' style="width:10%">车牌号码:</td>
        <td class='input' style="width:25%">
          <input type=text name="licenseNo" class="input">        </td>
      </tr>
      
      <tr>
      <td class='title' >开始时间:</td>
       <td class='input' >
        <input name="startDate" class="input" value=<%=strMonday%> >        </td>
      <td class='title' >结束时间: </td>
       <td class='input' >
        <input  name="endDate" class="input" value = <%=strSunday%>>        </td>
      </tr>
	  <tr>
        <td class='title' >定损处理状态:</td>
        <td colspan=3 class='input' ><input type=checkbox name="checkFlag0" >
          未处理
          <input type=checkbox name="checkFlag2" >
          正处理
  <input type=checkbox name="checkFlag4" >
          已提交 </td>
      </tr>
    </table>
    <div align="center">
      <input type="hidden" name="editType" value="QUERYCERTAINLOSS">
      <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
      <span class="button" style="width:20%">
      <input name="submit" type=submit class='button' value="<bean:message key='button.query.value' />">
      </span>
    </div>
</form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>