<%--
****************************************************************************
* DESC       ：预赔查询条件输入页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-11
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

  <title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr> <td colspan=4 class="formtitle">查询预赔信息</td></tr>
     <tr>
        <td class="centertitle" >预赔号</td>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.operatorCode"/></td>
        <td class="centertitle" ><bean:message key="db.prpLregist.inputDate"/></td>

     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLprepayDto"  property="claimList">
     <logic:iterate id="prpLprepay1"  name="prpLprepayDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
        <td > <a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<bean:write name='prpLprepay1' property='preCompensateNo'/>&editType=<bean:write name='prpLprepayDto' property='editType'/>"> <bean:write name="prpLprepay1" property="preCompensateNo"/></a></td>
        <td ><bean:write name="prpLprepay1" property="policyNo"/></td>
        <td ><bean:write name="prpLprepay1" property="operatorCode"/></td>
        <td ><bean:write name="prpLprepay1" property="inputDate"/></td>
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