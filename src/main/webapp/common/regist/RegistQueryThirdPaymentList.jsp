<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplpayDto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>

	<title>查询结果页</title>
	 <jsp:include page="/common/pub/StaticJavascript.jsp" />
	 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
	<script src="/claim/common/js/showpage.js"></script>
	<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
	<script src="/claim/common/js/UILoad.js"></script>
	<script type="text/javascript">	
	function openFlagDesc(paymentNo,editType,billFlag){
    	var vURL = "/claim/prplthirdpayquery.do?forward=detail&paymentNo="+paymentNo;
    	window.open(vURL,"showPayMessage","width=840,height=500,status=yes,menubar=no,location=no,resizable=yes,scrollbars=yes");
    }
	</script>
</head>
  
  <body>
  <form action="/claim/prplthirdpayquery.do?forward=query" name="fm" method="post">
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1">
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >序号</th>
	   				<th field="code1" align="center" class="centertitle" width="150" >支付单号</th>
	   				<th field="code3" align="center" class="centertitle" width="80" >支付类型</th>
	   				<th field="code4" align="center" class="centertitle" width="100" >支付金额</th>
	   				<th field="code5" align="center" class="centertitle" width="200" >开户行名称</th>
	   				<th field="code7" align="center" class="centertitle" width="200" >领款人名称</th>
	   				<th field="code8" align="center" class="centertitle" width="80" >支付时间</th>
	   				<th field="code9" align="center" class="centertitle" width="60" >支付状态</th>
	   				<th field="code10" align="center" class="centertitle" width="60" >详细</th>

	   			</tr>
   			</thead>
   			<tbody id="paymain" >
   	
	   			<c:if test="${not empty paymainList }">
	   			<c:forEach items="${paymainList}" var="prplpaymain" varStatus="count">
	    		<tr class="listodd">
	    			<td align="left">
	    				${count.index+1}
						<input type="hidden" id="num" name="num" value="${count.index+1}"/>
					</td>
	    			<td align="left">
	    				${prplpaymain.paymentNo }
	    				<input type="hidden" name="paymentNo" value="${prplpaymain.paymentNo }"/>
	    				<input type="hidden" name="billFlag" value="${prplpaymain.billFlag }">
			    	</td>
			    	<td align="left">
						<c:forEach items="${payTypeMap }" var="payTypeMapM">
			    			<c:if test="${payTypeMapM.key eq  prplpaymain.payType}">${payTypeMapM.value }</c:if>
			    		</c:forEach>
						
			   			<input type="hidden" name="payFlag" value="${prplpaymain.payFlag }"/>
			   		</td>
			   		<td align="left">
			   			${prplpaymain.payAmount }
			   			<input type="hidden" name="payAmount" value="${prplpaymain.payAmount }"/>
			   		</td>
			   		<td align="left">
			    		${prplpaymain.bank }

			    	</td>
			    	<td align="left">
			    		${prplpaymain.receiverFullName }
			    		<input type="hidden" name="receiverFullName" value="${prplpaymain.receiverFullName }"/>
			    	</td>
			    	<td align="left">
			    		${prplpaymain.payDate }
			    		<input type="hidden" name="payDate" value="${prplpaymain.payDate }"/>
			    	</td>
<%--			    	<td align="left">--%>
<%--			    		<c:forEach items="${paymentTypeMap }" var="paymentType">--%>
<%--			    			<c:if test="${paymentType.key eq  prplpaymain.paymentType}">${paymentType.value }</c:if>--%>
<%--			    		</c:forEach>--%>
<%--			    		<input type="hidden" name="bankAccount" value="${prplpaymain.paymentType }"/>--%>
<%--			    	</td>--%>
			    	<td align="left">
			   			<!--<c:if test="${prplpaymain.payFlag eq '1' and prplpaymain.vflag ne '9'}">已支付</c:if>
			   			<c:if test="${prplpaymain.payFlag ne '1' or  prplpaymain.vflag eq '9'}">
			   			<c:forEach items="${VFlagMap}" var="VFlag">
			   				<c:if test="${VFlag.key eq prplpaymain.vflag }">${VFlag.value}</c:if>
						</c:forEach>
						</c:if>-->
						<c:forEach items="${thirdPayFlagMap }" var="thirdPayFlagM">
			    			<c:if test="${thirdPayFlagM.key eq  prplpaymain.thirdPayFlag}">${thirdPayFlagM.value }</c:if>
			    		</c:forEach>
						<input type="hidden" name="payFlag" value="${prplpaymain.payFlag }"/>
			   		</td>
			   		<td>
			   			<input type="button" value="..." class="bobu" onclick="openFlagDesc('${prplpaymain.paymentNo }');"/>
			   		</td>
			   	</tr>
	   		    </c:forEach>
	   		    </c:if>
	   		</tbody>
	   		<tr><td colspan="9"><br></td></tr>
   		</table>
   		<%
   		PrplpayDto payDto=(PrplpayDto)request.getAttribute("payDto");
   		int curPage =payDto.getTurnPageDto().getPageNo(); 
   		%>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
   		</form>
</body>
</html>