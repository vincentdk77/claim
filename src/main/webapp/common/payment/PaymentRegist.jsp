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
<script  type="text/javascript">
	function mergePay(){
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
		var isURL = false;
		var licenseNo = document.getElementsByName('licenseNo');
		var paymentNo = document.getElementsByName('paymentNo');
		var vpaymentNo = "";
		for(var i=0;i<registNo.length;i++){
			var vRegistNo = registNo[i];
			if(vRegistNo.checked == true){
				if(licenseNo[i].value=='TH'){
					vpaymentNo = paymentNo[i].value;
					isURL = true;
				}
			}
		}
		//if(isURL){
			//fm.action="/claim/paymainEdit.do?paymentNo="+vpaymentNo+"&nodeType=apay&editType=EDIT";
			//fm.submit();
		//}else{
			//fm.action="/claim/paymainEdit.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
			//fm.submit();
		//}
		//fm.action="/claim/paymainMergeBeforEdit.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
		
	}
	function goPaymainAndRigistEdit(registNo,payTypeMain){
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		fm.target="_parent";
		fm.action="/claim/paymainEdit.do?registNo="+registNo+"&nodeType=apay&editType=ADD&isBtn=&payType="+payTypeMain;
		//fm.action="/claim/paymainAndRigistEdit.do?registNo="+registNo+"&payType="+payTypeMain+"&dataType=linkOne&editType=ADD&nodeType=apay";
		//window.open("/claim/paymainEdit.do?registNo="+registNo+"&nodeType=apay&editType=ADD&isBtn=&payType="+payTypeMain);
		fm.submit();
	}
	function submitForm1() {
		var registNo = document.getElementsByName('registNo');
		var checkRadio = false ; 
		for(var i = 0 ; i < registNo.length ; i++){
			if(registNo[i].checked){
				checkRadio = true ; 
			}
		}
		if(!checkRadio){
			alert("至少选择一个案件!");
			fm.btn.disabled="";
			return false ; 
		}
		var type = $("input[name='type']").val();
		if("5"==type){
			fm.action="/claim/prplpaynewadd.do";
			fm.submit() ; 
		}else{
			fm.submit() ; 
		}
		//fm.submit() ; 
	}
</script>
</head>
  
  <body>
  <form action="/claim/prplpaynew.do" name="fm" method="post">
  		<input type="hidden" name="payType" value="${payTypeMain }"/>
  		<input type="hidden" name="paymentType" value="${paymentType }"/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
  		<input type="hidden" name="pageConditions" id="pageConditions"  value="${turnPageDto.condition}">
  		<input type="hidden" name="back" value="${back }">
  		<input type="hidden" name="type" value="${type }">
   		<table class="easyui-datagrid" cellpadding="5" cellspacing="1"  height="35%" width="95%">
   			<thead>
	   			<tr>
	   				<th field="code0" align="center" class="centertitle" width="30" >选择</th>
	   				<th field="code1" align="center" class="centertitle" width="130" >报案号码</th>
	   				<th field="code2" align="center" class="centertitle" width="130" >保单号码</th>
	   				<th field="code3" align="center" class="centertitle" width="130" >出险时间</th>
	   				<th field="code4" align="center" class="centertitle" width="130" >起保日期</th>
	   				<th field="code5" align="center" class="centertitle" width="130" >终保日期</th>
	   				<th field="code6" align="center" class="centertitle" width="120" >被保险人</th>
	   				<th field="code7" align="center" class="centertitle" width="120" >承保机构</th>
	   			</tr>
   			</thead>
   			<tbody>
	   			<c:if test="${not empty turnPageDto.resultList }">
	   			<c:forEach items="${turnPageDto.resultList}" var="prplpayShowDto" varStatus="status">
	    		<tr class="listodd">
	    			<td align="left">
						<input type="radio" id="registNo" name="registNo" value="${prplpayShowDto.registNo }" />
					</td>
					<td align="left">
						${prplpayShowDto.registNo }
					</td>
					<td>
						${prplpayShowDto.policyNo }
					</td>
			   		<td>
						${prplpayShowDto.damageDate }
					</td>
					<td>
						${prplpayShowDto.startDate }
					</td>
					<td>
						${prplpayShowDto.endDate }
					</td>
					<td>
						${prplpayShowDto.insuredName }
					</td>
					<td>
						${prplpayShowDto.comCodeName }
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
   		 <%@include file="/common/pub/TurnOverPage1.jsp" %>
	   	<div id="outcontainer" name="submitDiv">
	    	<div >
		        <table align="center" id="buttonTable">
		           <tr style="valign:middle">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn" class="button" value="确定" onclick="buttonTableAddDisabled();submitForm1();"/> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
	     </div>
   		</form>
</body>
</html>
