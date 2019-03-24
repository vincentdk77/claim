<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLpayHisDto" %> 
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<%
	String editType = request.getParameter("editType");
%>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

<head>
	<title>支付信息详细</title>
</head>
<body class="interface" <%if("SHOW".equals(editType)){ %>onload="readonlyAllInput();"<%} %> >
	<form name="fm" method="post" onsubmit="return validateForm(this);">
		<div>
	       	<%-- 账户信息 --%>
	       	<%@include file="/common/payment/BillPayAccountInfo.jsp" %>
		 </div>
<%if(!"SHOW".equals(editType)){ %>
		 <div >
		        <table align="center" id="buttonTable">
		           <tr style="valign:middle">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="button" value="确定" onclick="setAccountMessage();" /> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
<%} %>
	</form>
</body>