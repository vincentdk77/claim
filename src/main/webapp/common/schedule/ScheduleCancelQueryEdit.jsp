<%--
****************************************************************************
* DESC       ����������ע����ѯ�������
* AUTHOR     �� lixiang	
* CREATEDATE �� 2005-10-19
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
  String strMonday = new DateTime(DateTime.current().addDay(-2),DateTime.YEAR_TO_DAY ).toString() ; 
%>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
</head>



<body  onLoad="initPage();">
<form name="fm" action="/claim/scheduleGetBackQuery.do"  method="post" onSubmit="return validateForm(this);">
  
     <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
	  <tr> 
           
            <td class="formtitle" colspan="6">��������ע��</td></tr>
      <tr>
        <td class='title' style="width:10%">������:</td>
        <td class='input' style="width:25%">
          </select><input type=text name="prpLcertainLossRegistNo" class="input"  style="width:95%"> 
        </td>
       
      <td class='title' >��������:</td>
       <td class='input' colspan=3>
        <select name ="nodeType" style="width:150px">
        <option value="all" selected> </option>
        <option value="certa"> ��������</option>
        <option value="wound"> ����</option>
        <option value="propc"> �Ʋ���ʧ</option>
        
        </select>
        </td>
       <td class='button' style="width:20%" rowspan=4>&nbsp;</td> 
      </tr>
       
   </table>
    <div align="center">
      <input type="hidden" name="editType" value="CANCELBEFOREQUERY">
      <span class="button" style="width:20%">
      <input name="submit" type=submit class='button' value="��һ��">
      </span>
    </div>
</form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>