<%--
****************************************************************************
* DESC       ：回访查询 明细
* AUTHOR     ：fengchuang
* CREATEDATE ：2012-09-17
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<!-- 页签控制 -->
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- 页面样式  --%>
<link href="/claim/css/tableType.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<link href="/claim/css/Toolbar.css" rel="stylesheet" type="text/css" />

<jsp:include page="/common/pub/StaticJavascript.jsp" />
<html>
	<head>
		<c:if test="${nodeType eq 'endca'}">
			<title>结案回访明细</title>
		</c:if>
		<c:if test="${nodeType eq 'sched'}">
			<title>派工回访明细</title>
		</c:if>
	</head>

	<body>
		<form name="fm" action="" method="post">
			<input type="hidden" id="nodeType" name="nodeType"
				value="${nodeType}">
			<div class="tab">
				<div class="tab_menu">
					<ul>
						<li class="selected">
							案件流程明细
						</li>
						<c:if test="${nodeType eq 'endca'}">
							<li>
								支付明细
							</li>
						</c:if>
						<li>
							已回访记录明细
						</li>
					</ul>
				</div>
				<div class="tab_box">
					<div align="left">
						<!-- 案件流程明细 -->
						<%@include file="/DAA/returnVisit/WorkFlowFlowQueryList.jsp"%>
					</div>
					<c:if test="${nodeType eq 'endca'}">
						<div class="hide">
							<%--支付明细 --%>
								<%@include
								file="/DAA/returnVisit/DAAReturnVisitPayDetailList.jsp" %>
						</div>
					
					</c:if>
					<div class="hide">
						<%--已回访记录明细 --%>
						<%@include
							file="/DAA/returnVisit/DAAReturnVisitMessage.jsp"%>
					</div>

				</div>
			</div>
			<div style="margin-bottom: 5px">
				<div id="outcontainer">
					<div id=content_basic>
						<table align="center" id="buttonTable">
							<tr>
								<td>
									<input type="button" class="bobu" value="关闭"
										onclick="window.close()">
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
