<%--
****************************************************************************
* DESC       �����ύ������ѯ�������
* AUTHOR     �� zhangpeng
* CREATEDATE �� 2004-04-21
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <title>���Ȼ�����ѯ</title>
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();">
<form name="fm" action="/claim/scheduleObjectQuery.do"  method="post" onsubmit="return validateForm(this);">
	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
	  <tr> 
	    <td width="184" height="26" valign="bottom"> 
	      <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td width="161" class="formtitle">���Ȼ�����ѯ����</td>
	          <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr> 
	      </table>
	    </td>
	    <td valign="bottom"><font color="#666666">&nbsp;</td>
	  </tr>
	</table>
    <table width="90%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="common">
      <tr>
             
         <td class='title' style="width:15%">���Ȼ�������:</td>
        <td class='input' style="width:25%">
        <select class=query name="ComCodeSign" style="width:40px">
            <option value="=">=</option>
            <option value="*">*</option>
          </select><input type=text name="ComCode" class="input" style="width:140px">
        </td>
        <td class='title' style="width:15%">���Ȼ�������:</td>
        <td class='input' style="width:25%">
        <select class=query name="ComCNameSign" style="width:40px">
            <option value="=">=</option>
            <option value="*">*</option>
          
          </select><input type=text name="ComCName" class="input" style="width:140px">
        </td>
        
        
        <td class='button' style="width:20%" rowspan=2>
          <input type=submit class='button' value="<bean:message key='button.query.value' />">
        </td>
      </tr>
      <tr>
        <td class="title">Ч��״̬:</td>
        <td class="input" >
          <input type=checkbox name="validStatus1" value="1">��</radio>
          <input type=checkbox name="validStatus2" value="0">�� </radio>
       	
        </td>        
      
      <td class="title" style="width:15%" style="valign:bottom" >���Ȼ�������:</td> 
      <td class="input" style="width:20%">
        <input type=checkbox name="comType1" value="1000001">����</radio>
        <input type=checkbox name="comType2" value="1000002">������</radio>
   	   </td>
     </tr>
      
      
    </table>
    <input type="hidden" name="editType" value="QUERY">
  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>