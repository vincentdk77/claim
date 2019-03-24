<%--
****************************************************************************
* DESC       ：回访查询 列表页面
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-12-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page language="java" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplcomplaintDto"%>
<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"%>
<%--
<!-- 页签控制 -->
<link href="/newclaim/css/tabstyle.css" rel="stylesheet" type="text/css">
<%-- 页面样式  --%>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/claim/css/tableType.css" rel="stylesheet" type="text/css">
<html:html locale="true">
<head>
	<app:css />

	<title>回访查询结果页</title>
	<script src="/claim/common/js/showpage.js"></script>
	<html:base />
</head>

<body>
	<form name="fm" action="" method="post">
		<% 
		PrplcomplaintDto prplcomplaintDto = (PrplcomplaintDto)request.getAttribute("prplcomplaintDto"); 
		  int curPage = prplcomplaintDto.getTurnPageDto().getPageNo(); 
		  UICodeAction uiCodeAction = new UICodeAction();
		%>  
		<table style="width: 99%" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" class="common">
			<tr ondblclick="showPage(RegistExtImg9,top9)">
				<td colspan="8" class="tabletitle">
					<div style="padding-left: 3px">
						<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif"
							name="RegistExtImg" id="RegistExtImg9"
							onclick="showPage(this,top9)">
						<span>查询结果</span>
					</div>
				</td>
			</tr>
			<tbody id="top9" style="">
				<tr class="listdragtitle">
					<td class="w5" align="center">
						序号
					</td>
					<td class=" w10" align="center">
						投诉编号
					</td>
					<td class="title" align="center">
						投诉人
					</td>
					<td class=" w10" align="center">
						被投诉机构
					</td>
					<td class=" w10" align="center">
						投诉时间
					</td>
				</tr>
				<c:forEach items="${prplcomplaintDtoList}" var="prplcomplaint" varStatus="count">
					<tr>
						<td>
							${count.index+1}
						</td>
						<td>
							<a href="/claim/complaintEdit.do?editType=${editType}&nodeTypes=${nodeType}&complaintno=${prplcomplaint.complaintno}" target="_parent">${prplcomplaint.complaintno}</a>
						</td>
						<td>
							${prplcomplaint.complaintname}
						</td>
						<td>
							${prplcomplaint.bycomplaintcomcodeName}
						</td>
						<td>
							${prplcomplaint.handlerdate}
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
		
		<table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prplcomplaintDto" property="turnPageDto"/>  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>
              </tr> 
          </table>
		
		<!--- add by zhaolu 20060803 start --->
		<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
	</form>
	<!--- add by zhaolu 20060803 end  --->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>