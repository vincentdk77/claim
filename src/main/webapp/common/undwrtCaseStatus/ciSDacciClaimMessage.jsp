<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<title>山东意外险风险预警平台补传返回信息</title>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<link href="/claim/css/tableType.css" rel="stylesheet" type="text/css">
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>
<body>
    <div class="tab">
		<div class="tab_title">
			山东意外险风险预警平台补传返回信息
		</div>
		<div class="tab_box">
			<table class="common" cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" style="padding-top:5px;margin-top:12px">
				<tr>
	    			<td colspan="10" align="center" class="tabletitle">
	    			    ${message }
	    			</td>
	    		</tr>
			</table>
		
		</div>
	</div>
<script type="text/javascript">
window.parent.document.all("showlist").style.height=document.body.scrollHeight+20;
</script>
</body>
</html>