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
<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

<head>
	<title>֧����Ϣ��ϸ</title>
</head>
<body class="interface" <%if("SHOW".equals(editType)){ %>onload="readonlyAllInput();"<%} %> >
	<form name="fm" method="post" onsubmit="return validateForm(this);">
		<div>
	       	<%-- �˻���Ϣ --%>
	       	<%@include file="/common/payment/BillPayAccountInfo.jsp" %>
		 </div>
<%if(!"SHOW".equals(editType)){ %>
		 <div >
		        <table align="center" id="buttonTable">
		           <tr style="valign:middle">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="button" value="ȷ��" onclick="setAccountMessage();" /> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
<%} %>
	</form>
</body>