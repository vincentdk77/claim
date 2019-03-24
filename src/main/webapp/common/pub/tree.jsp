<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html>
<head>
    <link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<body bgcolor="EFF1FE" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td > <table width="180" height="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
     
          <td width="180" height="100%" class="menu">
          <IFRAME width=180 height=100% src="/claim/processUtiMenu.do?actionType=showMenuClaim&taskCode=showMenu&menuStyle=<%=request.getParameter("menuStyle")%>"></IFRAME></td>
          <td></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>