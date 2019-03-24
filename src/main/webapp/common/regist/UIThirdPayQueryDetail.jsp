<%@ page language="java" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@page import="com.sinosoft.utiall.blsvr.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
      <link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
 
   

    <title>详细支付信息</title>
  </head>
 <body class="interface" >
	 <jsp:include page="/common/pub/StaticJavascript.jsp" />
	 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
	<script src="/claim/common/js/showpage.js"></script>
	<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
	<script src="/claim/common/js/UILoad.js"></script>


  <form name="fm" action=""  method="post"  target ="showlist">
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl }">
   		<table  cellpadding="0"  cellspacing="0" border="1" bordercolor="#3A81C8" class="mycommon common">
   			<tr>
			<td colspan=4 class="tabletitle" ondblclick="showPage(RegistExtImg,paymain)" style="text-align:center">
				详细支付信息
			</td>
			</tr>
	   			<c:if test="${not empty payList }">
	   			<c:forEach items="${payList}" var="prplpay" varStatus="count">
			<tbody >
				<tr>	   				
	   				<td class="title" style="width:15%;text-align:center">保单号</td>
	   				<td class="input" style="width:35%">${prplpay.policyno}</td>
	   				<td class="title" style="width:15%;text-align:center">险种</td>
	   				<td class="input" style="width:35%">
						<c:forEach items="${riskCodeMap }" var="riskcode">
			    			<c:if test="${riskcode.key eq  prplpay.riskcode}">${riskcode.value }</c:if>
			    		</c:forEach>   				</td>
	   			</tr>
	   		    <tr>	   				
	   				<td class="title" style="width:15%;text-align:center">立案号</td>
	   				<td class="input" style="width:35%">
						${prplpay.claimno}	</td>
	   				<td class="title" style="width:15%;text-align:center">报案号</td>
		   			<td class="input" style="width:35%">
		   			${prplpay.registno}	
		   			</td>
	   			</tr>
	   			<tr>

		   			<td class="title" style="width:15%;text-align:center">开户行</td>
	   				<td class="input" style="width:35%">
	   					${prplpay.bank}	
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">计算书号</td>
		   			<td class="input" style="width:35%">
		   			${prplpay.compensateno}	
		   			</td>
	   			<tr>
	   			<tr>	
	   				<td class="title" style="width:15%;text-align:center">领款人全称</td>
	   				<td class="input" style="width:35%">
	   				${prplpay.receiverfullname}							   				
					</td>
	   				<td class="title" style="width:15%;text-align:center">归属机构</td>
	   				<td class="input" style="width:35%">
	   					${prplpay.comCode}	
	   					<c:forEach items="${comCodeMap }" var="comCodeMapM">
			    			<c:if test="${comCodeMapM.key eq  prplpay.comCode}">${comCodeMapM.value }</c:if>
			    		</c:forEach>
	   				</td>
	   			</tr>

	   			<tr>	
	   				
	   				<td class="title" style="width:15%;text-align:center">操作员代码</td>
	   				<td>
	   				${prplpay.operatorcode}	   				
	   				</td>
	   				<td class="title" style="width:15%;text-align:center">操作日期</td>
		   			<td class="input" style="width:35%">
		   			${prplpay.inputdate}	  
		   			</td>
	   			</tr>

<%--	   				<td class="title" style="width:15%;text-align:center">案件类型</td>--%>
<%--	   				<td class="input" style="width:35%">--%>
<%--	   					<input type="checkbox" id="" name="mechanism" value="mechanism"/>本机构--%>
<%--	   					<input type="checkbox" id="" name="agnet" value="agnet"/>代查勘--%>
<%--	   				</td>--%>

	   			<tr >
		   			<td class="title" style="width:15%;text-align:center">支付员代码</td>
		   			<td class="input" style="width:35%">
		   				${prplpay.paycode}
		   			</td>
		   			<td class="title" style="width:15%;text-align:center">支付日期</td>
	   				<td class="input" style="width:35%">
	   					${prplpay.paydate}
	   				</td>
	   			</tr>

	   			<tr >
		   			<td class="title" style="width:15%;text-align:center">赔款类型</td>
	   				<td class="input" style="width:35%">
			    		<c:forEach items="${paymentTypeMap }" var="paymentTypeM">
			    			<c:if test="${paymentTypeM.key eq  prplpay.paymenttype}">${paymentTypeM.value }</c:if>
			    		</c:forEach>
		   			</td>
		   			<td class="title" style="width:15%;text-align:center"></td>
	   				<td class="input" style="width:35%">
   				</td>
	   			<tr>

		   		</tr>


	   			
   			</tbody>

   			<tr>
   				<td colspan="4" class="title" style="text-align:center">   					
   					支付说明
   				</td>
   			</tr>
   			<tr>
   				<td colspan="4" style="text-align:center">   
   				    ${prplpay.payremark}					
   				</td>
   			</tr>
   			   <tr>
   				<td colspan="4" style="text-align:center">   
   				    &nbsp					
   				</td>
   			</tr>

   	 </c:forEach>
	 </c:if>
   		</table>
   	</form>
   	
  </body>
</html>
