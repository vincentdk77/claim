<%--
****************************************************************************
* DESC       ��1.1.	�ӱ������幤�����ͳ��
* AUTHOR     ��lijiyuan
* CREATEDATE ��2005-03-24
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import = "java.util.Calendar"%>
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="java.util.*"%>
<%@page import="java.lang.*"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>

<%
 //�õ�������һ�����յ�����
   String  strDateColumn="submittime";
   String  strTitle="";
   String  strQReportType= request.getParameter("ReportType");
   if (strQReportType.equals("report_regist")){
         strTitle="�������幤�������ѯ��Ϣ";
         }
   if (strQReportType.equals("report_registf")){
         strDateColumn="ReportDate";
         strTitle="��һ�ֳ�������ͳ��";
         }
   if (strQReportType.equals("report_check")){
         strTitle="�鿱���������������ͳ��";
         }
   if (strQReportType.equals("report_bcheck")){
         strDateColumn="BackVisitTime";
         strTitle="�鿱�ط�ͳ��";
         }
   if (strQReportType.equals("report_cerloss_c")){
         strTitle="�����������������";
         }
   if (strQReportType.equals("report_certi")){
         strTitle="��֤�ռ���Ա��������ͳ��";
         }
   if (strQReportType.equals("report_certip")){
         strTitle="��֤�ռ���Ա������ϸͳ��";
         }
   if (strQReportType.equals("report_compp")){
         strTitle="������Ա��������ͳ��";
         }
   if (strQReportType.equals("report_comppp")){
         strTitle="������Ա������ϸͳ��";
         }
   if (strQReportType.equals("report_veric")){
         strTitle="������Ա��������ͳ��";
         }
   if (strQReportType.equals("report_vericp")){
         strTitle="������Ա������ϸͳ��";
         }
   if (strQReportType.equals("report_bvisit")){
         strTitle="�鿱�������������ط�ͳ��";
         strDateColumn="BackVisitTime";
         }
   if (strQReportType.equals("report_bvisitp")){
         strDateColumn="BackVisitTime";
         strTitle="�鿱��Ա�������������ط�ͳ��";
         }
   if (strQReportType.equals("report_bvisitlist")){
         strDateColumn="BackVisitTime";
         strTitle="�鿱�������������ط���ϸ";
         }
System.out.println("***********="+strQReportType);


  //Date date = new Date();
  //String strMonday = ""; //date.getMondayOFWeek();
  //String strSunday = ""; //date.getSundayOFWeek();

  String strSunday =DateTime.current().toString();
  String strMonday = new DateTime(DateTime.current().addMonth(-1),DateTime.YEAR_TO_DAY ).toString() ;
 %>



<html:html locale="true">
<head>
  <title>�ӱ������幤�����ͳ��</title>
  <%-- ���ú��� --%>
  <script src="/claim/common/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <script src="/claim/workflow/flow/js/WorkFlowFlowBeforeQuery.js"></script>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body onload="initPage();">
<form name="fm" action="/claim/ManageReport.do?SelectStyle=S"  method="post" onsubmit="return validateForm(this);">

    <table class=common cellpadding="5" cellspacing="1">
      <tr class=listtitle><td colspan=4 class="formtitle"><%=strTitle%></td></td>
      <tr>
        <td class='title' style="width:15%"><bean:message key="db.prpLclaim.comCode" />:</td>
        <td class='input' style="width:25%">
          <select name="ComCodeSign" class=query style="width:20%">
            <option value="=">=</option>
          </select><input type=text name="ComCode" class="input" style="width:80%">
        </td>

<%   if (strQReportType.equals("report_certi")||
		strQReportType.equals("report_compp")||
		strQReportType.equals("report_veric")
		){   %>
        <td class='title' style="width:10%">����ʱ��:</td>
        <td class='input' style="width:25%">
        <select name="DealTimeNoSign" class=query style="width:20%">
            <option value="=">=</option>
          </select><input type=text name="DealTime" class="input" style="width:80%">
        </td>
<%}else if(strQReportType.equals("report_certip")||strQReportType.equals("report_comppp")||strQReportType.equals("report_vericp") ){%>
        <td class='title' style="width:10%">��λ��Ա:</td>
        <td class='input' style="width:25%">
        <select name="HandlerCodeNoSign" class=query style="width:20%">
            <option value="=">=</option>
          </select><input type=text name="HandlerCode" class="input" style="width:80%">
        </td>
<%}else{%>
        <td class='title' style="width:10%"></td>
        <td class='input' style="width:25%">
        </td>
<%}%>

        <td class='button' style="width:20%" rowspan="2">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
      <tr>
        <td class='title' style="width:10%">��ʼʱ��:</td>
        <td class='input' style="width:25%">
          <input type=text name="DateStart" class="Wdate" onfocus="WdatePicker()" style="width:80%"  value=<%=strMonday %>><!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
        </td>
        <td class='title' style="width:10%">����ʱ��:</td>
        <td class='input' style="width:25%">
          <input type=text name="DateEnd" class="Wdate" onfocus="WdatePicker()" style="width:80%" value=<%=strSunday %>><!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
        </td>
      </tr>

    </table>
    <input type="hidden" name="ReportType" value="<%=strQReportType%>">
    <input type="hidden" name="DateType" value="<%=strDateColumn%>">
    <input type="hidden" name="ExcelFlag" value="0">
    <input type="hidden" name="PageFlag" vlaue="1">
    <input type="hidden" name="QueryStyle" value="6" >
  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
<%@include file="/daa/manage/ReportConfig.jsp"%>
<%@include file="/daa/manage/ManageStatQueryList.jsp"%>
</html:html>

