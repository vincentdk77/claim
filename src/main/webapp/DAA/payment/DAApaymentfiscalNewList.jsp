<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<html>
<head>
<title>查询结果页</title>
<link href="/claim/css/tabstyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<link href="/claim/css/tableType.css" rel="stylesheet" type="text/css">
   	 <jsp:include page="/common/pub/StaticJavascript.jsp" />
	 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script type="text/javascript" src="/claim/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="/claim/js/easyui/jquery.datagrid.js"></script>
	<script src="/claim/common/js/UILoad.js"></script>
<script  type="text/javascript">
	function fiscalmergePay(){
		//var paymentType= $(window.parent.document).find("select[name='paymentType'] option[selected]").val();
		//var paymentType = $("input[name='paymentType']").val();
		//if(paymentType==null||paymentType==""){
			//alert("多个案件赔款类型必录");
			//return;
		//}
		var classCode = document.getElementsByName('classCode');
		var registNo = document.getElementsByName('registNo');
		var isTrue = false;
		for(var i=0;i<classCode.length;i++){
			var iClassCode=classCode[i];
	    	var iValue=iClassCode.value;
	    	if(registNo[i].checked==true){
	    		for(var j=0;j<classCode.length;j++){
		    		var jClassCode=classCode[j];
		    		var jValue=jClassCode.value;
		    		if(registNo[j].checked==true){
		    			if(iValue!=jValue){
		    				isTrue = true;
		    			}
		    		}
		    	}
	    	}
	    }
	    if(isTrue){
	    	alert("不同险类不能合并案件！");
	    	return;
	    }
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		//fm.paymentType.value=paymentType;
		fm.target="_parent";
		//fm.action="/claim/paymainMergeBeforEdit.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
		fm.btn.disabled = true;
		x_load.show("正在执行中...");
		fm.action="/claim/paymainfiscalEdit.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
		fm.submit();
	}
	function goPaymainAndRigistEdit(registNo,payTypeMain){
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		fm.target="_parent";
		x_load.show("正在执行中...");
		fm.action="/claim/paymainEdit.do?registNo="+registNo+"&nodeType=apay&editType=ADD&isBtn=&payType="+payTypeMain;
		//fm.action="/claim/paymainAndRigistEdit.do?registNo="+registNo+"&payType="+payTypeMain+"&dataType=linkOne&editType=ADD&nodeType=apay";
		//window.open("/claim/paymainEdit.do?registNo="+registNo+"&nodeType=apay&editType=ADD&isBtn=&payType="+payTypeMain);
		fm.submit();
	}
</script>
</head>
  
  <body>
  <form action="/claim/prplpaynew.do" name="fm" method="post">
  		<input type="hidden" name="payType" value="${payTypeMain }"/>
  		<input type="hidden" name="paymentType" value="${paymentType }"/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
  		<input type="hidden" name="pageConditions" id="pageConditions"  value="${turnPageDto.condition}">
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1">
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >选择</th>
	   				<th field="code1" align="center" class="centertitle" width="130" >报案号码</th>
	   				<th field="code3" align="center" class="centertitle" width="120" >被保险人</th>
	   				<th field="code2" align="center" class="centertitle" width="160" >理算书号</th>
	   				<th field="code5" align="center" class="centertitle" width="60" >流入时长</th>
	   				<th field="code6" align="center" class="centertitle" width="60" >结案金额</th>
	   				<th field="code7" align="center" class="centertitle" width="60" >赔款类型</th>
	   				<th field="code8" align="center" class="centertitle" width="120" >承保机构</th>
	   			</tr>
   			</thead>
   			<tbody>
	   			<c:if test="${not empty turnPageDto.resultList }">
	   			<c:forEach items="${turnPageDto.resultList}" var="prplpayShowDto" varStatus="status">
	    		<tr class="listodd">
	    			<td align="left">
						<input type="checkBox" id="registNo" name="registNo" value="${prplpayShowDto.registNo }" />
						<input type="hidden" name="classCode" value="${prplpayShowDto.classCode }">
					</td>
	    			<td align="left">
<%--	    				<a href="/claim/paymainAndRigistEdit.do?registNo=${prplpayShowDto.registNo }&payType=${payTypeMain}&dataType=linkOne&editType=ADD&nodeType=apay&prevPageUrl=${prevPageUrl}" target="_parent">${prplpayShowDto.registNo }</a>--%>
	    				${prplpayShowDto.registNo }
	    				<!--input type="hidden" name="registNo" value="${prplpayShowDto.registNo }"/-->
			    	</td>
			    	<td align="left">
			    		${prplpayShowDto.insuredName }
			    		<input type="hidden" name="insuredName" value="${prplpayShowDto.insuredName }"/>
			    	</td>
			    	<td align="left">
			    		<a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=${prplpayShowDto.certiNo }&editType=SHOW&riskCode=${prplpayShowDto.riskCode }&registNo=${prplpayShowDto.registNo }" target="_parent">${prplpayShowDto.certiNo }</a>
			    		<input type="hidden" id="compensateNo" name="compensateNo" value="${prplpayShowDto.certiNo }"/>
			    	</td>
			    	<td align="left">
			    		${prplpayShowDto.underWriteEndDate }天
			    		<input type="hidden" name="underWriteEndDate" value="${prplpayShowDto.underWriteEndDate }"/>
			    	</td>
			    	<td align="left">
			   			${prplpayShowDto.sumPaid }
			    		<input type="hidden" name="sumPaid" value="${prplpayShowDto.sumPaid}"/>
			   		</td>
			   		<td align="left">
			   			${prplpayShowDto.payType }
			    		<input type="hidden" name="payType" value="${prplpayShowDto.payType }"/>
			   		</td>
			   		<td align="left">
			   			${prplpayShowDto.comCodeName }
			   			<input type="hidden" name="comCodeName" value="${prplpayShowDto.comCodeName }"/>
			   			<input type="hidden" name="comCode" value="${prplpayShowDto.comCode }"/>
			   		</td>
			   		
			   	</tr>
	   		    </c:forEach>
	   		    </c:if>
	   		</tbody>
   		</table>
   		<% 
		TurnPageDto turnPageDto = (TurnPageDto)request.getAttribute("turnPageDto"); 
		  int curPage = turnPageDto.getPageNo(); 
		%>
		<c:set var="pageview" value="${turnPageDto}"></c:set>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
	   	<div id="outcontainer" name="submitDiv">
	    	<div >
		        <table align="center" id="buttonTable">
		           <tr style="valign:middle">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="button" value="合并录入" onclick="fiscalmergePay();"/> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
	     </div>
   		</form>
</body>
</html>
