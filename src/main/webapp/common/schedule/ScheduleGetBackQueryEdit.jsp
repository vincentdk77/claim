<%--
****************************************************************************
* DESC       ������ȡ�ز�ѯ�������
* AUTHOR     �� lixiang	
* CREATEDATE �� 2004-08-05
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
  String type=request.getParameter("type");
  String strSunday =DateTime.current().toString();
  String strMonday = new DateTime(DateTime.current().addDay(-7),DateTime.YEAR_TO_DAY ).toString() ; 
%>

<script  type="text/javascript">
    	function submitForm(){
              fm.queryButton.disabled=true;
	          fm.submit();//�ύ
	          setTimeout('fm.queryButton.disabled=false',5000);
    		  //return true ;
    		
    	}
    </script>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>


<body onLoad="initPage();">

<form name="fm" action="/claim/scheduleGetBackQuery.do"  method="post" onSubmit="return validateForm(this);">

      <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
	  <tr> 
           
            <td class="formtitle" colspan="4"><bean:message key="title.scheduleBeforeEdit.titleName" /></td></tr>
      <tr>
        <td class='title' style="width:10%">������:</td>
        <td class='input' style="width:25%">
        <select class=query name="registNoSign" style="width:40px">
            <option value="=">=</option>
            
          </select>&nbsp;<input type=text name="registNo" class="input"  style="width:75%">
        </td>
        <td class='title' style="width:10%">���ƺ���:</td>
        <td class='input' style="width:25%">
         <select class=query name="licenseNoSign" style="width:40px">
            <option value="=">=</option>
            <%--<option value="*">*</option>--%>
          </select>
          &nbsp;<input type=text name="licenseNo" class="input" style="width:140px">
        </td>

        <td class='button' style="width:20%" rowspan=4>&nbsp;</td> 
      </tr>
      
      <tr>
      <td class='title' >����Ա:</td>
       <td class='input' >   
       <input type=text name="handlerCode" class="codecode"  style="width:100px" title="����Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
            <input type=text name="handlerName" class="codecode" readonly style="width:30%" title="����Ա" value="">
        
        </td>
      <td class='title' >�鿱/������: </td>
       <td class='input' >
           <input type=text name="NhandlerCode" class="codecode"  style="width:100px" title="�鿱/������Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
            <input type=text name="NhandlerName" class="codecode" readonly style="width:30%" title="�鿱/������Ա" value="">
      </td>
      </tr>
      
     
      <tr>
      <td class='title' >��ʼʱ��:</td>
       <td class='input' >
        <input name="startDate" class="Wdate" style="width:120px" value=<%=strMonday%> onfocus="WdatePicker()">
        <!-- <img src="/claim/images/bgcalendar.gif" align="middle" style='cursor: hand' onClick="TogglePopupCalendarWindow('document.fm.startDate', '2007', '2017')">  -->  </td>
      <td class='title' >����ʱ��: </td>
       <td class='input' >
        <input  name="endDate" class="Wdate" style="width:120px" value = <%=strSunday%> onfocus="WdatePicker()">
        <!-- <img src="/claim/images/bgcalendar.gif" align="middle" style='cursor: hand' onClick="TogglePopupCalendarWindow('document.fm.endDate', '2007', '2017')"> -->   </td>
      </tr>
      
      <tr>
      <td class='title' >����ȥ������:</td>
       <td class='input' colspan=3>
        <select name ="nodeType" style="width:150px">
        <option value="check" selected> �鿱</option>
        <option value="certa"> ��������</option>
        <option value="wound"> ����</option>
        <option value="propc"> �Ʋ���ʧ</option>
        
        </select>
        </td>
      
      </tr>
       
   </table>
    <div align="center">
      <input type="hidden" name="editType" value="GETBACKQUERY">
      <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
     
        <!--  <span class="button" style="width:20%">-->
        <input type="button" value="��ѯ" name="queryButton" class='button' onclick="submitForm()" >
      <!--  </span>-->
      
    </div>
</form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>