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
	<script type="text/javascript">
	/**
	* 主动撤回
	*/
	function revoke(paymentNo){
		if(confirm("确认撤回任务？")){
 			//var registNo= document.getElementById("registNo").value;
			//var paymentNo = $(obj).parent().parent().find("input[name='paymentNo']").val();
			$.ajax({
				url:'/claim/paymainRevoke.do'
				,type:'POST'
				,dataType:"text"
				,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
				,data:{'paymentNo':paymentNo}
				,success:function(data){
					if(data=="true"){
						alert('撤回成功！');
						//$(obj).parent().parent().remove();
						//getIndex();
						window.location.reload(); 
					}else{
						alert('撤回失败！');
					}
				}
				,error:function(){alert('发生错误');}
			});	
		}
		
	}
	
	function openFlagDesc(){
    	var vURL = "/claim/DAA/payment/UIThirdPayFlagDetail.jsp";
    	window.open(vURL,"showPayMessage","width=840,height=500,status=yes,menubar=no,location=no,resizable=yes,scrollbars=yes");
    }
	</script>
</head>
  
  <body>
  <form action="/claim/prplpaysearch.do" name="fm" method="post">
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1">
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >序号</th>
	   				<th field="code1" align="center" class="centertitle" width="150" >收付编号</th>
	   				<th field="code2" align="center" class="centertitle" width="150" >领款人名称</th>
<%--	   				<th field="code3" align="center" class="centertitle" width="80" >赔款类型</th>--%>
	   				<th field="code4" align="center" class="centertitle" width="100" >支付金额</th>
	   				<th field="code3" align="center" class="centertitle" width="80" >流入时长</th>
	   				<th field="code7" align="center" class="centertitle" width="150" >承保机构</th>
	   				<th field="code8" align="center" class="centertitle" width="80" >任务状态</th>
	   				<th field="code9" align="center" class="centertitle" width="60" >状态说明</th>
	   				<c:if test="${type eq '4' }">
	   				<th field="code10" align="center" class="centertitle" width="60" >操作</th>
	   				</c:if>
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
	    				<c:if test="${type eq '4' }">
	    					<a href="/claim/paymainEdit.do?paymentNo=${prplpaymain.paymentNo }&nodeType=apay&editType=SHOW&prevPageUrl=${prevPageUrl}"  target="_parent">${prplpaymain.paymentNo }</a>
	    				</c:if>
	    				<c:if test="${type ne '4' }">
	    					<a href="/claim/paymainEdit.do?paymentNo=${prplpaymain.paymentNo }&nodeType=apay&editType=EDIT&prevPageUrl=${prevPageUrl}"  target="_parent">${prplpaymain.paymentNo }</a>
	    				</c:if>
	    				<input type="hidden" name="paymentNo" value="${prplpaymain.paymentNo }"/>
			    	</td>
			    	<td align="left">
			    		${prplpaymain.receiverFullName }
			    		<input type="hidden" name="receiverFullName" value="${prplpaymain.receiverFullName }"/>
			    	</td>
<%--			    	<td align="left">--%>
<%--			    		<c:forEach items="${paymentTypeMap }" var="paymentType">--%>
<%--			    			<c:if test="${paymentType.key eq  prplpaymain.paymentType}">${paymentType.value }</c:if>--%>
<%--			    		</c:forEach>--%>
<%--			    		<input type="hidden" name="bankAccount" value="${prplpaymain.paymentType }"/>--%>
<%--			    	</td>--%>
			    	<td align="left">
			   			${prplpaymain.payAmount }
			   			<input type="hidden" name="payAmount" value="${prplpaymain.payAmount }"/>
			   		</td>
			   		<td align="left">
			   			${prplpaymain.totalInputDate }
			   		</td>
			   		<td align="left">
			   			${prplpaymain.comName }
			   			<input type="hidden" name="comName" value="${prplpaymain.comName }"/>
			   			<input type="hidden" name="comCode" value="${prplpaymain.comCode }"/>
			   		</td>
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
			   			<input type="button" value="说明" class="bobu" onclick="openFlagDesc();"/>
			   		</td>
			   		<c:if test="${type eq '4' }">
			   		<td align="center">
			   			<c:if test="${(prplpaymain.payFlag ne '1' )and(( prplpaymain.vflag eq '4')or( prplpaymain.vflag eq '6') )  }">
						<input type="button" class="bobu"  name="backBtn" value="撤回" onclick="revoke('${prplpaymain.paymentNo }');"  /> 
						</c:if>
<!--						<c:if test="${(prplpaymain.payFlag eq '1' )or(( prplpaymain.vflag ne '4')and( prplpaymain.vflag ne '6') )  }">-->
<!--						<input type="button" class="bobu"  name="backBtn" value="撤回" disabled  /> -->
<!--						</c:if>-->
					</td>
			   		</c:if>
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
