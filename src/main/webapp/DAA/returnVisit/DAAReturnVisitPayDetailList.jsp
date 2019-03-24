<%--
****************************************************************************
* DESC       ：回访查询 列表页面
* AUTHOR     ：fengchuang
* CREATEDATE ：2012-09-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
<!-- 页签控制 -->
<link href="/newclaim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- 页面样式  --%>
<link rel="stylesheet" type="text/css"
	href="/claim/css/StandardCar.css">
<%@ page contentType="text/html; charset=GBK"%>
<link href="/claim/css/tableType.css" rel="stylesheet"
	type="text/css">
<html>
	<head>

		<title>支付明细页</title>
		<script src="/claim/common/js/showpage.js"></script>
	</head>

	<body>
		<form name="fm" action="" method="post">
			<input type="hidden" id="nodeType" name="nodeType" value="">
			<table style="width: 99%" cellpadding="0" cellspacing="0" border="1"
				bordercolor="#3A81C8" class="common">
				<tr>
					<td colspan="18" class="tabletitle">
						<div style="padding-left: 3px">
							<span>支付明细</span>
						</div>
					</td>
				</tr>
				<tbody id="top9" style="">
					<tr class="listdragtitle">
					    <td class=" w20" align="left">
							计算书号
						</td>
						<td class="w20" align="left">
							支付时间
						</td>
						<td class=" w20" align="left">
							支付金额
						</td>
					</tr>
					<c:forEach items="${prpJplanFeeDtoList}" var="prpJplanFeeDto"
						varStatus="count">
					<tr class="listdragtitle">
							<td>
								<a target="showlist"
									href="/claim/returnPayDetailEdit.do?busino=${prpJplanFeeDto.certiNo}&registno=${registNo }&node=${prpJplanFeeDto.certiType}&paymenttype=${prpJplanFeeDto.payRefReason}&editType=SHOW">
					 			${prpJplanFeeDto.certiNo }</a>
							</td>
							<td>
								${prpJplanFeeDto.payRefDate }
							</td>
							<td>
								${prpJplanFeeDto.payRefFee==0.0?"": prpJplanFeeDto.payRefFee}
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<iframe id="showlist" name="showlist" src="" height="100%"
			frameborder="0" marginheight="0" marginwidth="0" scrolling="no"
			width="99%"></iframe>
		<c:if test="${flag eq 'TOOL'}">
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
		</c:if>
</form>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</body>
</html>