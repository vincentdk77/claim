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
    <app:css />

	<title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
	        <script src="/claim/common/js/showpage.js"> </script>
	<html:base/>
</head>

<body  >

	<table  class="common" cellpadding="5" cellspacing="1" >
	<tr><td colspan=4 class="formtitle"><bean:message key="title.registBeforeEdit.titleName" /></td></tr>
	   <tr>
	      <td class="centertitle" ><bean:message key="db.prpLregist.registNo"/></td>
	      <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
	      <td class="centertitle" ><bean:message key="db.prpLregist.operatorCode"/></td>
	      <td class="centertitle" ><bean:message key="db.prpLregist.inputDate"/></td>

	   </tr>
	   <%int index=0;%>
	   <logic:notEmpty  name="prpLregistDto"  property="registList">
	   <logic:iterate id="prpLregist1"  name="prpLregistDto"  property="registList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
	    <tr class=common>  <td > <a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<bean:write name='prpLregist1' property='registNo'/>&editType=<bean:write name='prpLregistDto' property='editType'/>"> <bean:write name="prpLregist1" property="registNo"/></a></td>
	      <td ><bean:write name="prpLregist1" property="policyNo"/></td>
	      <td ><bean:write name="prpLregist1" property="operatorCode"/></td>
	      <td ><bean:write name="prpLregist1" property="inputDate"/></td>
	    </tr>
<%        index++;%>
	    </logic:iterate>
	    </logic:notEmpty>
	  </table>
	  </tr>
	</table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>