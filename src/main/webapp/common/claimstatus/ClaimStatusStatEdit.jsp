<%--
****************************************************************************
* DESC       ：查勘查询输入界面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-07
* MODIFYLIST ：   Name Sunhao      Date  2004-08-24          Reason/Contents
           1. 增加车牌号，案件状态，操作时间查询条件
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<%
 //add by liuyanmei 20051110 
  String riskType= request.getParameter("type");
  System.out.println("----------------------riskType-----"+ riskType );
  
  String statStartDate = "";
  String statEndDate ="";       		
  DateTime dateTime1 = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
  statStartDate = dateTime1.addDay(-7).toString();
  statEndDate = dateTime1.toString();
%>
<script  type="text/javascript">
    	function submitForm(){
              fm.queryButton.disabled=true;
	          fm.submit();//提交
	          setTimeout('fm.queryButton.disabled=false',5000);
    		  //return true ;
    		
    	}
    </script>

<html>
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/claimStatusStat.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan="4" class="formtitle">节点状态时间段查询</td></tr>
      <tr>
        <td class='title' >开始时间：</td>
        <td class='input' >
          <input type=text name="statStartDate" value="<%=statStartDate %>" class="Wdate" onfocus="WdatePicker()" style="width:240" > <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate','2007', '2017')"> -->
        </td>
        <td class='title' >结束时间：</td>
        <td class='input' >
          <input type=text name="statEndDate" value="<%=statEndDate %>"  class="Wdate" onfocus="WdatePicker()" style="width:240"  > <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
        </td>
        </tr>
        <tr>
        <td class='title' align=center colspan="4">
          <!--  <input type=submit class='button' value="<bean:message key='button.query.value' />">-->
          <input type=button class='button' name="queryButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="EDIT">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
     <input type="hidden" name="riskType" value="<%= riskType%>">

    <%
        //modify by wangwei add start 2005-06-12
        //原因：向下一个文件增加一个意健险信息
    %>
         <input type="hidden" name="type" value="<%= request.getParameter("type")%>"/>
    <%
        //modify by wangwei add end 2005-06-12
    %>
  </form>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html>