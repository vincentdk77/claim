<%--
****************************************************************************
* DESC       ���鿱��ѯ�������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-07
* MODIFYLIST ��   Name Sunhao      Date  2004-08-24          Reason/Contents
           1. ���ӳ��ƺţ�����״̬������ʱ���ѯ����
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
 //�õ�������һ�����յ�����
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
    <tr><td colspan=4 class="formtitle">�ڵ�״̬ʱ��β�ѯ</td></tr>
      <tr>
        <td class='title' >��ʼʱ�䣺</td>
        <td class='input' >
          <input type=text name="statStartDate" class="Wdate" onfocus="WdatePicker()"  value=<%=strMonday %>> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
        </td>
        <td class='title' >����ʱ�䣺</td>
        <td class='input' >
          <input type=text name="statEndDate" class="Wdate"   onfocus="WdatePicker()" value=<%=strSunday %>> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
        </td>
        <td class='button'  rowspan="3">
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
      <%--
       <tr>
        <td class='title' rowspan=2>�ڵ�״̬:</td>
        <td class='input' colspan=3 >
        <input type=checkbox name="checkFlag0" >δ����
        <input type=checkbox name="checkFlag1" >δ����
        <input type=checkbox name="checkFlag2" >������
        <input type=checkbox name="checkFlag3" >�Ѵ���

        </td>

      </tr>
      <tr>
       <td class='input' colspan=3 >
        <input type=checkbox name="checkFlag4" >���ύ
        <input type=checkbox name="checkFlag5" >�ѻ���
        <input type=checkbox name="checkFlag6" >�ѳ���
        <input type=checkbox name="checkFlag7" >���˴���

        </td>

      </tr>
      --%>
    </table>
    <input type="hidden" name="editType" value="EDIT">

  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>