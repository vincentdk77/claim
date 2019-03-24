<%--
****************************************************************************
* DESC       ：节点超时查询输入界面
* AUTHOR     ：
* CREATEDATE ： 2004-09-24
* MODIFYLIST ：   Name      Date           Reason/Contents

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

  //只查询工作流没有结束的，并且状态只为未分配的，待处理的，正处理，已完成，回退需处理的

  String strSunday =DateTime.current().toString();
  String strMonday = new DateTime(DateTime.current().addMonth(-1),DateTime.YEAR_TO_DAY ).toString() ;
 %>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>s
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/WorkFlowNodeTimeOutStat.do?Stat=NodeStatusNum"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle">节点超时查询</td></tr>
      <tr>
        <td class='title' >开始时间：</td>
        <td class='input' >
          <input type=text name="statStartDate" class="Wdate" onfocus="WdatePicker()"  value=<%=strMonday %>> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
        </td>
        <td class='title' >结束时间：</td>
        <td class='input' >
          <input type=text name="statEndDate" class="Wdate" onfocus="WdatePicker()" value=<%=strSunday %>> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
        </td>

      </tr>

       <tr>

         <td class='title' >操作员代码：</td>
         <td class='input' >
          <select class=tag  name="OperatorCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="OperatorCode" class="query"  >
         </td>


         <td class='title' >险种：</td>
         <td class='input' >
          <select class=tag  name="RiskCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="RiskCode" class="query"  maxlength="3">
         </td>

       </tr>

       <tr>
        <td class='title' >节点状态：</td>
        <td class='input' colspan=3 >
        <input type=checkbox name="checkFlag0" checked>未分配
        <input type=checkbox name="checkFlag1" checked >未处理
        <input type=checkbox name="checkFlag2" checked>正处理
        <input type=checkbox name="checkFlag3" checked>已处理
        <input type=checkbox name="checkFlag7" checked>回退处理
        </td>

      </tr>
      <tr>
       <td class='title' >节点过滤：</td>
       <td class='input'>
         <select name="nodeType" class="common">
            <option value="regis">报案</option>
			      <option value="sched">调度</option>
			      <option value="check">查勘</option>
			      <option value="certa">定损</option>
			      <option value="verif">核损</option>
			      <option value="claim">立案</option>
			      <option value="certi">单证</option>
			      <option value="prepa">预赔</option>
			      <option value="compe">实赔</option>
			      <option value="endca">结案</option>
			      <option value="allty" selected>全部</option>
			      </select>
         <input type=checkbox name="checkFlagPrepay"  checked>不包含预赔节点
         <input type=checkbox name="checkFlagCompany" checked>不包含实赔节点
       </td>
      <td class=title  colspan=2 ></td>
      </tr>
      <tr>
       <td class='button'  rowspan="4">
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
        </tr>
    </table>
    <input type="hidden" name="editType" value="EDIT">

  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>