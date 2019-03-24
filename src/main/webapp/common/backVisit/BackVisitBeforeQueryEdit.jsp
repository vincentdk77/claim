<%--
****************************************************************************
* DESC       ��¼��ط�ǰ��ѯ�鿱������ǰ����������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-12-06
* MODIFYLIST ��   Name       Date            Reason/Contents
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
  //�õ�������һ�����յ�����
  //Date date = new Date();
  //String strMonday = ""; //date.getMondayOFWeek();
  //String strSunday = ""; //date.getSundayOFWeek();
 
  String strSunday =DateTime.current().toString();
  String strMonday = new DateTime(DateTime.current().addMonth(-1),DateTime.YEAR_TO_DAY ).toString() ;
%>


<html:html locale="true">
<head>
  <title>��ѯ�鿱��������Ϣ</title>
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>

  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <%--����״̬��־����--%>
  <!--
    function submitForm()
    {
      fm.submit();//�ύ
    }
  //-->
  </script>

  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>
<body  onload="initPage();">
<form name="fm" action="/claim/backVisitBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>
    <td colspan=4 class="formtitle">��ѯ���Իطõ�������Ϣ</td>
    </tr>

      <tr>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />��</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>

        <td class='title' >�������룺</td>
        <td class='input' >
        <select class=tag name="registNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="registNo" class="query" >
        </td>
      </tr>


       <tr>
        <td class='title' >�������ͣ�</td>
        <td class='input' >
        <select class=common name="nodeType" >
            <option value="check">�鿱</option>
            <option value="certa">����</option>

        </td>

        <td class='title' >�����ģ�</td>
        <td class='input' >
            <input type=text name="lossItemName" class="common" >
        </td>
      </tr>

       <tr>
      <td class='title' >��ʼʱ�䣺</td>
       <td class='input' >
        <input name="startDate" class="Wdate"  value=<%=strMonday%> onfocus="WdatePicker()">
        <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.startDate', '2007', '2017')"> -->

        </td>
      <td class='title' >����ʱ�䣺 </td>
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
