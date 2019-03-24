<%--
****************************************************************************
* DESC       ���鿱���Ȳ�ѯ�������
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

  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>



<body  onload="initPage();">
<form name="fm" action="/claim/scheduleCheckQuery.do"  method="post" onSubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=4 class="formtitle"><bean:message key="title.checkBeforeEdit.titleName" /></td></tr>
      <tr>
        <td class='title' >������:</td>
        <td class='input' >
          <input type=text name="registNo" class="input">        </td>
        <td class='title' style="">����Ա:</td>
        <td class='input'>
          <input type=text name="handlerCode" class="codecode"   title="����Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');" style="width:50px">
            <input type=text name="handlerName" class="codecode" readonly  title="����Ա" value="" style="width:120px">        </td>
      </tr>

      <tr>
      <td class='title' >��ʼʱ��:</td>
       <td class='input' >
        <input name="startDate" class="input" value=<%=strMonday%> >        </td>
      <td class='title' >����ʱ��: </td>
       <td class='input' >
        <input  name="endDate" class="input" value = <%=strSunday%>>        </td>
      </tr>
      <tr>
        <td class='title' >�鿱��:</td>
        <td class='input'  colspan=3><input type=text name="NhandlerCode" class="codecode"   title="�鿱��" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');" style="width:80px">
            <input type=text name="NhandlerName" class="codecode" readonly  title="�鿱��" value="" style="width:200px">
        </td>
      </tr>
      <tr>
        <td class='title' >����״̬:</td>
        <td class='input' colspan=3 ><input type=checkbox name="checkFlag0" >
          δ�鿱
          <input type=checkbox name="checkFlag2" >
          ���ڲ鿱
          <input type=checkbox name="checkFlag4" >
          �Ѳ鿱 </td>
      </tr>
      
      <tr> <td class='button'  colspan=4>
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td> </tr>
    </table>
    <input type="hidden" name="editType" value="QUERYCHECK">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
</form>
</body>
</html:html>