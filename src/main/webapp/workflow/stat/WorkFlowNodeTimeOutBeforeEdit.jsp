<%--
****************************************************************************
* DESC       ���ڵ㳬ʱ��ѯ�������
* AUTHOR     ��
* CREATEDATE �� 2004-09-24
* MODIFYLIST ��   Name      Date           Reason/Contents

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

  //ֻ��ѯ������û�н����ģ�����״ֻ̬Ϊδ����ģ�������ģ�����������ɣ������账���

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
    <tr> <td colspan=4 class="formtitle">�ڵ㳬ʱ��ѯ</td></tr>
      <tr>
        <td class='title' >��ʼʱ�䣺</td>
        <td class='input' >
          <input type=text name="statStartDate" class="Wdate" onfocus="WdatePicker()"  value=<%=strMonday %>> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statStartDate', '2007', '2017')"> -->
        </td>
        <td class='title' >����ʱ�䣺</td>
        <td class='input' >
          <input type=text name="statEndDate" class="Wdate" onfocus="WdatePicker()" value=<%=strSunday %>> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.statEndDate', '2007', '2017')"> -->
        </td>

      </tr>

       <tr>

         <td class='title' >����Ա���룺</td>
         <td class='input' >
          <select class=tag  name="OperatorCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="OperatorCode" class="query"  >
         </td>


         <td class='title' >���֣�</td>
         <td class='input' >
          <select class=tag  name="RiskCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="RiskCode" class="query"  maxlength="3">
         </td>

       </tr>

       <tr>
        <td class='title' >�ڵ�״̬��</td>
        <td class='input' colspan=3 >
        <input type=checkbox name="checkFlag0" checked>δ����
        <input type=checkbox name="checkFlag1" checked >δ����
        <input type=checkbox name="checkFlag2" checked>������
        <input type=checkbox name="checkFlag3" checked>�Ѵ���
        <input type=checkbox name="checkFlag7" checked>���˴���
        </td>

      </tr>
      <tr>
       <td class='title' >�ڵ���ˣ�</td>
       <td class='input'>
         <select name="nodeType" class="common">
            <option value="regis">����</option>
			      <option value="sched">����</option>
			      <option value="check">�鿱</option>
			      <option value="certa">����</option>
			      <option value="verif">����</option>
			      <option value="claim">����</option>
			      <option value="certi">��֤</option>
			      <option value="prepa">Ԥ��</option>
			      <option value="compe">ʵ��</option>
			      <option value="endca">�᰸</option>
			      <option value="allty" selected>ȫ��</option>
			      </select>
         <input type=checkbox name="checkFlagPrepay"  checked>������Ԥ��ڵ�
         <input type=checkbox name="checkFlagCompany" checked>������ʵ��ڵ�
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