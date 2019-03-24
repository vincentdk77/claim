<%--
****************************************************************************
* DESC       ：录入回访前查询查勘，定损前的条件果面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-12-06
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
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
  <title>查询查勘／定损信息</title>
  <%-- 公用函数 --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>

  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <%--案件状态标志处理--%>
  <!--
    function submitForm()
    {
      fm.submit();//提交
    }
  //-->
  </script>

  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>
<body  onload="initPage();">
<form name="fm" action="/claim/backVisitBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>
    <td colspan=4 class="formtitle">查询可以回访的任务信息</td>
    </tr>

      <tr>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />：</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>

        <td class='title' >报案号码：</td>
        <td class='input' >
        <select class=tag name="registNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="registNo" class="query" >
        </td>
      </tr>


       <tr>
        <td class='title' >任务类型：</td>
        <td class='input' >
        <select class=common name="nodeType" >
            <option value="check">查勘</option>
            <option value="certa">定损</option>

        </td>

        <td class='title' >任务标的：</td>
        <td class='input' >
            <input type=text name="lossItemName" class="common" >
        </td>
      </tr>

       <tr>
      <td class='title' >开始时间：</td>
       <td class='input' >
        <input name="startDate" class="Wdate"  value=<%=strMonday%> onfocus="WdatePicker()">
        <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.startDate', '2007', '2017')"> -->

        </td>
      <td class='title' >结束时间： </td>
       <td class='input' >
        <input  name="endDate" class="Wdate"  value = <%=strSunday%> onfocus="WdatePicker()">
        <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.endDate','2007', '2017')"> -->
      </td>
      </tr>

      <tr>
        <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="BEFOREQERY">
  </form>
</body>
</html:html>
