<%--
****************************************************************************
* DESC       ���������Թ������ͻ���
* AUTHOR     ��
* CREATEDATE ��2004-06-29
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>  
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �������Թ������ͻ���
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head> 
 

<body class="interface" >
<html:form action="/wfModelUseSave"
         onsubmit="return validateRegistrationForm(this);">
</html:form>
</body>

</html:html>
  