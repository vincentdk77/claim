<%@page import="com.sinosoft.claim.dto.domain.PrplfiscalpaymainDto"%>
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
	
	function hrevPaymentEdit(fiscalno,editType){
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		fm.target="_parent";
		x_load.show("正在执行中...");
		fm.action="/claim/paymainfiscalEdit.do?fiscalNo="+fiscalno+"&Datatype=mergeMany&nodeType=apay&editType="+editType+"&prevPageUrl="+prevPageUrl;
		fm.submit();
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
	   				<th field="code1" align="center" class="centertitle" width="150" >支付清单号</th>
	   				<th field="code2" align="center" class="centertitle" width="150" >报案号</th>
	   				<th field="code3" align="center" class="centertitle" width="100" >清单金额</th>
	   				<th field="code4" align="center" class="centertitle" width="80" >流入时长</th>
	   				<th field="code5" align="center" class="centertitle" width="150" >操作机构</th>
	   				<c:if test="${type eq '4' }">
	   				<th field="code6" align="center" class="centertitle" width="60" >操作</th>
	   				</c:if>
	   			</tr>
   			</thead>
   			<tbody id="paymain" >
	   			<c:if test="${not empty fiscalpaymainList }">
	   			<c:forEach items="${fiscalpaymainList}" var="prplfiscalpaymain" varStatus="count">
	    		<tr class="listodd">
	    			<td align="left">
	    				${count.index+1}
						<input type="hidden" id="num" name="num" value="${count.index+1}"/>
					</td>
	    			<td align="left">
	    				<c:if test="${type eq '4' }">
	    					<a href="javascript:;" onclick="hrevPaymentEdit('${prplfiscalpaymain.fiscalno }','SHOW');" >${prplfiscalpaymain.fiscalno }</a>
	    				</c:if>
	    				<c:if test="${type ne '4' }">
	    					<a href="javascript:;" onclick="hrevPaymentEdit('${prplfiscalpaymain.fiscalno }','EDIT');" >${prplfiscalpaymain.fiscalno }</a>
	    				</c:if>
	    				<input type="hidden" name="fiscalNo" value="${prplfiscalpaymain.fiscalno }"/>
			    	</td>
			    	<td align="left">
			    		${prplfiscalpaymain.registno }
			    		<input type="hidden" name="registNo" value="${prplfiscalpaymain.registno }"/>
			    	</td>
			    	<td align="left">
			   			${prplfiscalpaymain.sumamount }
			   			<input type="hidden" name="sumamount" value="${prplfiscalpaymain.sumamount }"/>
			   		</td>
			   		<td align="left">
			   			${prplfiscalpaymain.totalInputDate }
			   		</td>
			   		<td align="left">
			   			${prplfiscalpaymain.comName }
			   			<input type="hidden" name="comName" value="${prplfiscalpaymain.comName }"/>
			   			<input type="hidden" name="operatorcomcode" value="${prplfiscalpaymain.operatorcomcode }"/>
			   		</td>
			   		<c:if test="${type eq '4' }">
			   		<td align="center">
			   			<c:if test="${( prplfiscalpaymain.vflag eq '4')or( prplfiscalpaymain.vflag eq '6' )  }">
						<input type="button" class="bobu"  name="backBtn" value="撤回" onclick="revoke('${prplfiscalpaymain.fiscalno }');"  /> 
						</c:if>
					</td>
			   		</c:if>
			   	</tr>
	   		    </c:forEach>
	   		    </c:if>
	   		</tbody>
	   		<tr><td colspan="6"><br></td></tr>
   		</table>
   		<%
   		PrplfiscalpaymainDto fiscalpayDto=(PrplfiscalpaymainDto)request.getAttribute("fiscalpayDto");
   		int curPage =fiscalpayDto.getTurnPageDto().getPageNo(); 
   		%>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
   		</form>
</body>
</html>
