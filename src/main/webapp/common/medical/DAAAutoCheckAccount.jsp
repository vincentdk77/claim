<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoCheckAccountViewHelper"%>

<html:html locale="true">
<head>
  <title>大病医疗自动对账</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<%
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	String returnStr = "";
	
	try{
		UIMedicalAutoCheckAccountViewHelper uiMedicalAutoCheckAccountViewHelper = new UIMedicalAutoCheckAccountViewHelper();
		uiMedicalAutoCheckAccountViewHelper.autoCheckAccount(startDate,endDate);
		returnStr = "自动对账成功";
	}catch(Exception e){
		e.printStackTrace();
		returnStr = "自动对账失败";
	}


%>

<body  >
<form name="fm" action=""  method="post"  target ="sub">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=2 class="formtitle">大病医疗自动对账</td></tr>
        <tr>
        <td class='button' colspan=2>
          	<%=returnStr %>
        </td>
      </tr>
    </table>
  </form>
</body>
</html:html>


