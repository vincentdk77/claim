<%--
****************************************************************************
* DESC       ��������ѯ��������ҳ��
* AUTHOR     ��lijiyuan
* CREATEDATE ��2004-03-01
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>


<html:html locale="true">
<head>
       <title><bean:message key="prompt.regist.RegistQuery.QueryTitleName"/></title>
	   <app:css />

	    <script src="/claim/common/js/showpage.js"> </script>
  </head>
<body >
<html:form action="/RegistQuery" focus="prpLregistRegistNo" method="post" >

  <table class=common id="QueryInput" width="80%" border="0" align="center" cellpadding="4" cellspacing="1">
  <tr>
	  <td class=title><bean:message key="prompt.regist.registForm.RegistNo" /></td>
    <td class=input>
            <select class="codecode" name="RegistNoSign">

          <%@include file="/common/pub/UIStringOption.html"%>
            </select>
    <html:text name="registForm" property="prpLregistRegistNo" styleClass="common" maxlength="22"/></td>
    <td class=title><bean:message key="prompt.regist.registForm.PolicyNo" /></td>
    <td class=input><select  name="PolicyNoSign"><%@include file="/common/pub/UIStringOption.html"%></select>
    <html:text name="registForm" property="prpLregistPolicyNo" styleClass="common" maxlength="22"/></td>
  </tr>

  <tr>
	 <td class=title  height=22 colspan="4">
	   <div align="center">
	     <html:submit styleClass="button1" value="��ѯ"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:reset styleClass="button1" value="����"/>
	   </div>
	 </td>
  </tr>
  </table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script src="/claim/common/js/showpage.js"> </script>
</html:form>
</body>
</html:html>
