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
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/WorkFlowNodeStat.do?Stat=NodeStatusNum"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">节点状态时间段查询</td></tr>
      <tr>
        <td class='title' >开始时间：</td>
        <td class='input' >
          <input type=text name="statStartDate" class="Wdate" onfocus="WdatePicker()"  value=<%=strMonday %>> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
        </td>
        <td class='title' >结束时间：</td>
        <td class='input' >
          <input type=text name="statEndDate" class="Wdate"   onfocus="WdatePicker()" value=<%=strSunday %>> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
        </td>
        <td class='button'  rowspan="3">
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
      <%--
       <tr>
        <td class='title' rowspan=2>节点状态:</td>
        <td class='input' colspan=3 >
        <input type=checkbox name="checkFlag0" >未分配
        <input type=checkbox name="checkFlag1" >未处理
        <input type=checkbox name="checkFlag2" >正处理
        <input type=checkbox name="checkFlag3" >已处理

        </td>

      </tr>
      <tr>
       <td class='input' colspan=3 >
        <input type=checkbox name="checkFlag4" >已提交
        <input type=checkbox name="checkFlag5" >已回退
        <input type=checkbox name="checkFlag6" >已撤消
        <input type=checkbox name="checkFlag7" >回退处理

        </td>

      </tr>
      --%>
    </table>
    <input type="hidden" name="editType" value="EDIT">

  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>