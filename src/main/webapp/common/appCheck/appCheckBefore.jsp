<%--
****************************************************************************
* DESC       ��¼�뱨����ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-28
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>


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
  <title>¼���������</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/specailCaseQuery.do"  method="post" onsubmit="return validateForm(this);">

  <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
  <tr><td colspan=2 class="formtitle">���뱨����</td></tr>
    <tr>
      <td class="title2"  align="center">�����ţ�</td>
      <td class="input2">
        <input type=text name="appRegistNo" class="common">
      </td>
      </tr>
      <tr>
      <td class="button"   colspan=2 align="center">
        <!--  <input type=submit class="button" class="button" value="��һ��">-->
        <input type="button" value="��һ��" name="queryButton" class='button' onclick="submitForm();" >
      </td>
    </tr>
  </table>
  <input type="hidden" name="editType" value="ApplySchedule">
</form>
</body>
</html:html>



