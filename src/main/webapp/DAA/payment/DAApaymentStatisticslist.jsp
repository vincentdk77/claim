<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplpayDto"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
 	String path = request.getContextPath();
 	String basePath = request.getScheme() + "://"
 			+ request.getServerName() + ":" + request.getServerPort()
 			+ path + "/";
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
	<script type="text/javascript">
	function openFlagDesc(){
    	var vURL = "/claim/DAA/payment/UIThirdPayFlagDetail.jsp";
    	window.open(vURL,"showPayMessage","width=840,height=500,status=yes,menubar=no,location=no,resizable=yes,scrollbars=yes");
    }
	</script>
</head>
  <% BLPrpLpaymainFacade blPrpLpaymainFacade  = new BLPrpLpaymainFacade();
  	String conditions = (String)request.getAttribute("conditions");
  		int countNum = blPrpLpaymainFacade.getPayStatisticsCount(conditions);%>
  <body onload="window.parent  .progressStop();" onunload="window.parent  .progressStart()">
  <form action="/claim/prplpaystatistics.do" name="fm2" method="post">
  <input type="hidden" name="conditions" value="${conditions}"/>
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1">
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >序号</th>
	   				<th field="code8" align="center" class="centertitle" width="120" >机构</th>
	   				<th field="code5" align="center" class="centertitle" width="100" >支付录入时间</th>
	   				<th field="code4" align="center" class="centertitle" width="100" >支付时间</th>
	   				<th field="code1" align="center" class="centertitle" width="150" >报案号码</th>
	   				<th field="code2" align="center" class="centertitle" width="130" >计算书号</th>
	   				<th field="code3" align="center" class="centertitle" width="120" >被保险人</th>
	   				<th field="code10" align="center" class="centertitle" width="100" >核赔日期</th>
	   				<th field="code11" align="center" class="centertitle" width="100" >结案日期</th>
	   				<th field="code12" align="center" class="centertitle" width="100" >理算操作人员代码</th>
	   				<th field="code6" align="center" class="centertitle" width="60" >总赔款</th>
	   				<th field="code13" align="center" class="centertitle" width="60" >赔款不含费用</th>
	   				<th field="code14" align="center" class="centertitle" width="60" >实付赔款(不含费用)</th>
	   				<th field="code15" align="center" class="centertitle" width="100" >领款人</th>
	   				<th field="code16" align="center" class="centertitle" width="150" >证件号</th>
	   				<th field="code7" align="center" class="centertitle" width="60" >支付状态</th>
	   				<th field="code9" align="center" class="centertitle" width="60" >状态说明</th>
	   			</tr>
   			</thead>
   			<tbody>
	   			<c:if test="${not empty paymainList }">
	   			<c:forEach items="${paymainList}" var="payStatisticsDto" varStatus="count">
	    		<tr class="listodd">
	    			<td align="left">
	    				${count.index+1}
						<input type="hidden" id="num" name="num" value="${count.index+1}"/>
					</td>
			   		<td align="left">
			   			${payStatisticsDto.comName }
			   			<input type="hidden" name="comCode" value="${payStatisticsDto.comCode }"/>
			   		</td>
			    	<td align="left">
			   			${payStatisticsDto.inputDate }
			   			<input type="hidden" name="totalInputDate" value="${payStatisticsDto.inputDate }"/>
			   		</td>
			   		<td align="left">
			    		${payStatisticsDto.payDate}
			    		<input type="hidden" name="licenseNo" value="${payStatisticsDto.payDate }"/>
			    	</td>
	    			<td align="left">
	    			<c:if test="${not empty payStatisticsDto.paymentNo or '' ne payStatisticsDto.paymentNo}">
						<a
							href="/claim/paymainEdit.do?paymentNo=${payStatisticsDto.paymentNo }&nodeType=apay&editType=SHOW&prevPageUrl=${prevPageUrl}"
							target="_parent">${payStatisticsDto.registNo }</a>
						<input type="hidden" name="paymentNo"
							value="${payStatisticsDto.paymentNo }" />
					</c:if> 
					<c:if
						test="${empty payStatisticsDto.paymentNo or '' eq payStatisticsDto.paymentNo}">
						${payStatisticsDto.registNo }
						</c:if>
			    	</td>
			    	
			    	<td align="left">
			    		${payStatisticsDto.compensateNo}
			    		<input type="hidden" name="policyNo" value="${payStatisticsDto.compensateNo }"/>
			    	</td>
			    	<td align="left">
			    		${payStatisticsDto.insuredName}
			    		<input type="hidden" name="insuredName" value="${payStatisticsDto.insuredName }"/>
			    	</td>
			    	
			    	<td align="left">
			   			${payStatisticsDto.underWriteEnddate }
			   			<input type="hidden" name="totalInputDate" value="${payStatisticsDto.underWriteEnddate }"/>
			   		</td>
			    	<td align="left">
			   			${payStatisticsDto.endCaseDate }
			   			<input type="hidden" name="totalInputDate" value="${payStatisticsDto.endCaseDate }"/>
			   		</td>
			    	<td align="left">
			   			${payStatisticsDto.userName }
			   			<input type="hidden" name="totalInputDate" value="${payStatisticsDto.userName }"/>
			   		</td>
			   		<td align="left">
			   			${payStatisticsDto.sumPaid }
			   			<input type="hidden" name="sumPaid" value="${payStatisticsDto.sumPaid }"/>
			   		</td>
			   		<td align="left">
			   			${payStatisticsDto.sumDutyPaid }
			   			<input type="hidden" name="sumDutyPaid" value="${payStatisticsDto.sumDutyPaid }"/>
			   		</td>
			   		<td align="left">
			   			${payStatisticsDto.payPaid }
			   			<input type="hidden" name="payPaid" value="${payStatisticsDto.payPaid }"/>
			   		</td>
			   		<td align="left">
			   			${payStatisticsDto.receiverfullname }
			   			<input type="hidden" name="receiverfullname" value="${payStatisticsDto.receiverfullname }"/>
			   		</td>
			   		<td align="left">
			   			${payStatisticsDto.certifno }
			   			<input type="hidden" name="certifno" value="${payStatisticsDto.certifno }"/>
			   		</td>
			    	<td align="left">
			    		${payStatisticsDto.payStatusName }
			    		<input type="hidden" name="payStatus" value="${prplpaymain.payStatus }"/>
			    	</td>
			   		<td>
			   			<input type="button" value="说明" class="bobu" onclick="openFlagDesc();"/>
			   		</td>
			   	</tr>
	   		    </c:forEach>
	   		    </c:if>
	   		</tbody>
	   		<tr><td colspan="9"><br></td></tr>
   		</table>
<table class="common" align="center">
	<tr>
		<td class="button" type="button">
		<input id="buttonExp"name="buttonExp"
			class="button" type="button" value="导出Excel" onclick="exp();">
		</td>
	</tr>
</table>
<script>
		function exp(){
			fm2.buttonExp.disabled = true;
			var countNum = <%=countNum%>
			if(countNum>2000){
				alert("当前结果超过2000条，请精确查询后导出");
				return;
			}else{
	   			fm2.action ='/claim/prplpaystatistics.do?type=2';
	   			fm2.submit();
	   			setTimeout('enableExpBut()',10000);
   			}
	    }
	    function enableExpBut(){
	    	fm2.buttonExp.disabled = false;
	    }
</script>
<%
	PrplpayDto payDto = (PrplpayDto) request.getAttribute("payDto");
	int curPage = payDto.getTurnPageDto().getPageNo();
%>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
   		</form>
   		
</body>
</html>
