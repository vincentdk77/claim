<%--
****************************************************************************
* DESC       : ������ת���������б���ʾҳ��
* AUTHOR     : Sunhao
* CREATEDATE : 2004-07-28
* MODIFYLIST :   Name       Date            Reason/Contents
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
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<app:css/>

<title>�����б�</title>

<script src="/claim/common/js/showpage.js"></script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<html:base/>
</head>

<body  >

<table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr class=listtitle>
    <td width="5%" align="center" nowrap >���</td>
    <td width="10%" align="center" nowrap ><div align="center">ʱ��</div></td>
    <td width="10%" align="center" nowrap >�ڵ�����</td>
    <td width="10%" align="center" nowrap >������</td>
    <td width="65%" ><div align="center">��¼��Ϣ</div></td>
  </tr>
  <%int index=1;%>
  <logic:notEmpty  name="prpLmessageDto"  property="messageList">
  <logic:iterate id="prpLmessage1"  name="prpLmessageDto"  property="messageList">
<%
          if(index %2== 0)
          {
               out.print("<tr class=listodd>");
          }
          else
          {
               out.print("<tr class=listeven>");
               }
%>
     <tr class=common> <td><%=index%></td>
      <td><bean:write name="prpLmessage1" property="inputDate"/></td>
      <td><bean:write name="prpLmessage1" property="nodeType"/></td>
      <td><bean:write name="prpLmessage1" property="operatorName"/></td>
      <td><textarea readonly="true" cols="70" rows="3"><bean:write name="prpLmessage1" property="context"/></textarea></td>
  </tr>
<%index++;%>
  </logic:iterate>
  </logic:notEmpty>
</table>
</body>
</html:html>