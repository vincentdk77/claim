<%--
****************************************************************************
* DESC       ：立案查询结果显示页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-04-15
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
    <app:css />

	<title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
	        <script src="/claim/common/js/showpage.js"> </script>
	<html:base/>
</head>

<body  >

	<table class="common" cellpadding="5" cellspacing="1" >
	<tr>  <td colspan=4 class="formtitle"><bean:message key="title.claimBeforeEdit.titleName" /></td></tr>
	   <tr>
	      <td class="centertitle" ><bean:message key="db.prpLclaim.claimNo"/></td>
	      <td class="centertitle" ><bean:message key="db.prpLclaim.policyNo"/></td>
	      <td class="centertitle" ><bean:message key="db.prpLclaim.operatorCode"/></td>
	      <td class="centertitle" ><bean:message key="db.prpLclaim.inputDate"/></td>

	   </tr>
	   <%int index=0;%>
	   <logic:notEmpty  name="prpLclaimDto"  property="claimList">
	   <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
	     <tr class=common> <td > <a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='prpLclaim1' property='claimNo'/>&editType=<bean:write name='prpLclaimDto' property='editType'/>"> <bean:write name="prpLclaim1" property="claimNo"/></a></td>
	      <td ><bean:write name="prpLclaim1" property="policyNo"/></td>
	      <td ><bean:write name="prpLclaim1" property="operatorCode"/></td>
	      <td ><bean:write name="prpLclaim1" property="inputDate"/></td>
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