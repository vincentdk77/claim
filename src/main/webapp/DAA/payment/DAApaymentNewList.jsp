<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
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
	function mergeBillPay(){
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
	    var selectRegistNo = "";
		for(var i=0;i<registNo.length;i++){
			if(registNo[i].checked == true){
				selectRegistNo = registNo[i].value;
			}
		}
		if(selectRegistNo == ""){
			alert("请勾选一条数据！");
			return false;
		}
		var prevPageUrl = $("input[name='prevPageUrl']").val();
		//fm.paymentType.value=paymentType;
		fm.target="_parent";
		var claimrelationno = document.getElementsByName('claimrelationno');
		var isBill = false;
		var isBillNull = true;
		var isContinueBill = false ; 
		for(var i=0;i<claimrelationno.length;i++){
			if(registNo[i].checked==true){
				if(claimrelationno[i].value!=""){
					isBill = true;
				}else{
					isBillNull = false;
				}
			}
		}
		var type = $("input[name='type']").val();
		if(!isBill && type == '5'){
			if(confirm("勾选的案件无清单，是否继续进行“清单支付”？")){
				//fm.action="/claim/compensateNoBillList.do?editType=ADD&Datatype=mergeMany&nodeType=apay&selectBillFlag=1&noBillFlag=0";
				fm.action="/claim/compensateList.do?editType=ADD&Datatype=mergeMany&nodeType=apay&selectBillFlag=1&noBillFlag=1";
				fm.submit();
				return false ; 
			}else{
				return false;
			}
			
		}
		if(isBill&&!isBillNull){
			alert("勾选数据中存在无清单的数据，请勾选全部有清单的数据！");
			return false;
		}
		//fm.action="/claim/paymainMergeBeforEdit.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
		fm.btn.disabled = true;
		x_load.show("正在执行中...");
		if(isBill&&isBillNull){
			fm.action="/claim/compensateList.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
			fm.submit();
		}else{
			fm.action="/claim/paymainEdit.do?editType=ADD&Datatype=mergeMany&nodeType=apay";
			fm.submit();
		}
	}
	
	function mergePay(){
		var registNo = document.getElementsByName('registNo');
		var selectRegistNo = "";
		for(var i=0;i<registNo.length;i++){
			if(registNo[i].checked == true){
				selectRegistNo = registNo[i].value;
			}
		}
		if(selectRegistNo == ""){
			alert("请勾选一条数据！");
			return false;
		}else{
			goPaymainAndRigistEdit(selectRegistNo,fm.payTypeMain.value);
		}
		
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
	
	function selectChecked(field){
		var count = getElementCount("isChecked");
		if(count>1){
			var index = parseInt(getElementOrder(field))-1; 
			if(field.checked == true){
				fm.isChecked[index].value="1";
			}else{
				fm.isChecked[index].value="0";
			}
		}else if(count==1){
			if(field.checked == true){
				fm.isChecked.value="1";
			}else{
				fm.isChecked.value="0";
			}
		}
	}
</script>
</head>
  
  <body>
  <form action="/claim/prplpaynew.do" name="fm" method="post">
  		<input type="hidden" name="payType" value="${payTypeMain }"/>
  		<input type="hidden" name="paymentType" value="${paymentType }"/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
  		<input type="hidden" name="pageConditions" id="pageConditions"  value="${turnPageDto.condition}">
  		<input type="hidden" name="back" value="${back}">
  		<input type="hidden" name="type" value="${type }">
  		<input type="hidden" name="payTypeMain" value="${payTypeMain }">
   		<table class="easyui-datagrid"  height="35%" width="95%" cellpadding="5" cellspacing="1">
   			<thead>
	   			<tr>
	   				<th field="code" align="center" class="centertitle" width="30" >选择</th>
	   				<th field="code1" align="center" class="centertitle" width="130" >报案号码</th>
	   				<th field="code3" align="center" class="centertitle" width="120" >被保险人/共保人</th>
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
						<input type="checkBox" id="registNo" name="registNo" value="${prplpayShowDto.registNo }" onclick="selectChecked(this)"/>
						<input type="hidden" name="isChecked" value="0">
						<input type="hidden" name="registNoPay" value="${prplpayShowDto.registNo }">
						<input type="hidden" name="classCode" value="${prplpayShowDto.classCode }">
						<input type="hidden" name="claimrelationno" value="${prplpayShowDto.claimRelationNo }">
						<input type="hidden" name="compensateNo" value="${prplpayShowDto.certiNo }">
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
			    	</td>
			    	<td align="left">
			    		${prplpayShowDto.underWriteEndDate }天
			    		<input type="hidden" name="underWriteEndDate" value="${prplpayShowDto.underWriteEndDate }"/>
			    	</td>
			    	<td align="left">
			   			<fmt:formatNumber pattern='#.00' value="${prplpayShowDto.sumPaid}"/>
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
		        	 	<input type="button" name="btn" class="button" value="整单支付" onclick="mergePay();">
		        	 	<input type="button" name="btn" class="button" value="清单支付" onclick="mergeBillPay();"/> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
	     </div>
   		</form>
</body>
</html>
