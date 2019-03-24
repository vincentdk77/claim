<%--
****************************************************************************
* DESC       ：立案查询条件输入页面
* AUTHOR     ：lijiyuan
* CREATEDATE ：2004-03-01
* MODIFYLIST ：   id       Date            Reason/Contents
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

  <table class=common id="QueryInput" border="0" align="center" cellpadding="5" cellspacing="1" >
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
	 <td class=button   colspan="2">

	     <html:submit styleClass="button" class="button" value="查询"/>
	     </td>
	     <td class=button colspan="2"><html:reset styleClass="button" value="重置"/>

	 </td>
  </tr>
  </table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script src="/claim/common/js/showpage.js"> </script>
</html:form>
</body>
</html:html>
