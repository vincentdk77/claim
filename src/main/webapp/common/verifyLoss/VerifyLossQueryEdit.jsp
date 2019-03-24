<%--
****************************************************************************
* DESC       �������ѯ�������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-13
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/js/WdatePicker.js"></script>
  <script language="javascript">
  <%--����״̬��־����--%>
  <!--
  function submitForm()
  {
    var ref="";
    for(i=0;i<fm.status.length;i++){
      if(fm.status[i].checked==true){
        ref = ref+fm.status[i].value+",";
      }
    }
    fm.caseFlag.value = ref;
    fm.queryButton.disabled=true;
	fm.submit();//�ύ
    setTimeout('fm.queryButton.disabled=false',5000);
  }
//-->
</script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/verifyLossQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table width="90%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">��ѯ������Ϣ</td></tr>
      <tr>
        <td class='title' >�����ţ�</td>
        <td class='input' >
        <select class=tag name="RegistNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query" >
        </td>
        <td class='title' >�����ţ�</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>


      </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />:</td>
        <td class='input' >
        <select class=tag name="LicenseNoSign" >
            <option value="=">=</option>
            <option value="*">*</option>
          </select> <input type=text name="LicenseNo" class="query" >
        </td>
        
                 <%
                  String OperateDate = "";
                  String endDate ="";       		
                  DateTime dateTime1 = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
                  OperateDate = dateTime1.addDay(-7).toString();
                  endDate = dateTime1.toString();
                %>
        <td class='title' >����ʱ��:</td>
        <td class='input'>
          <select class=tag name="OperateDateSign" >
              <option value=">=">&gt;=</option>
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value="<=">&lt;=</option>
          </select> <input type=text name="OperateDate" value="<%=OperateDate %>" class="Wdate" style="width:60%" onfocus="WdatePicker();">
          <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')"> -->
        </td>
      </tr>
      <tr>
        <td class='title' >����״̬��</td>
        <td class='input'>
        <input type="hidden" name="caseFlag" value="">
        <!--delete by caopeng start at 2005-12-20
        <input type="checkbox" name="status" value="1">δ����
        delete by caopeng start at 2005-12-20-->
        <input type="checkbox" name="status" value="2">������
        <input type="checkbox" name="status" value="4">���ύ
        </td>
          <%--������ѯ���ӱ������˲�ѯ����--%>
       <td class='title' >������������:</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>
      </tr>
      <tr>
       <td class='button'  colspan="4">
          <input type=button class='button' name="queryButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="SHOW">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
  </form>
</body>
</html:html>