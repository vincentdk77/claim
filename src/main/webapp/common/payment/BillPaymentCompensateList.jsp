<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="com.sinosoft.utility.PrpallUtility" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String upLoadFlag = (String)request.getAttribute("upLoadFlag");
System.err.println("upLoadFlag="+upLoadFlag);
%>
<style type="text/css">
/*--查询/编辑/显示页面中输入域/显示域对应标题的样式--*/
TD.title
{
	FONT-SIZE: 9pt;
	COLOR: #000000;
	height:20px;
	background-color:#D8E3F3;
	TEXT-ALIGN: center;
} 
#content_basic {
    border-width: 1px;
    border-style: solid;
    border-color: #3A81C8;
    background-color: #DFEBF7;
    padding: 8px;
    margin-top: 5px;
}
</style>
<html>
<head>
<title>清单列表</title>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
   	 <jsp:include page="/common/pub/StaticJavascript.jsp" />
	 <link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="/claim/js/easyui/themes/icon.css">
	<script src="/claim/common/js/UILoad.js"></script>
	<script type="text/javascript">
		var BGCOLORD="#778899";       //删除(颜色)
		var BGCOLORD_1="#6699CC";       //账户信息(颜色)
		var BGCOLORD_2="#99FF99";       //账户信息确定(颜色)
		function requestprevUrl(){
     		var prevPageUrl = document.getElementById('prevPageUrl').value;
     		if(prevPageUrl.length == 0){
 	    		var prevUrl = document.URL;
 	    		document.getElementById('prevPageUrl').value=prevUrl;
     		}
     	}
     	
     	function allSelected(){
			var SelectTasks = document.getElementsByName('CheckTask');		
			if(fm.isAllSelected.checked==true){
				for(var i = 0;i< SelectTasks.length;i++){
					SelectTasks[i].checked="true";
				}
			}else{
				for(var i = 0;i< SelectTasks.length;i++){
					SelectTasks[i].checked="";
				}
			}
		}
		function bankAccountMessage(obj){
			var index = getElementOrder(obj)-1;
	 		var count = getElementCount(obj.name);
	 		var editType = fm.editType.value;
	 		var payName = "";
			var identifyNumber = "";
	 		var provinceName = "";
	 		var cityName = "";
	 		var accountType = "";
	 		var bankName = "";
	 		var bankAccount = "";
	 		var accountFlag = "";
	 		var openBank = "";
	 		var routeNum = "";
	 		var mobilePhone = "";
	 		var address = "";
	 		var payWay = "";
	    	var payReason = "";
	    	var payPurpose = "";
			if(count==1){
				payName = fm.payName.value;
				identifyNumber =fm.identifyNumber.value;
	 			provinceName = fm.provinceName.value;
	 			cityName = fm.cityName.value;
	 			accountType = fm.accountType.value;
	 			bankName = fm.bankName.value;
	 			bankAccount = fm.bankAccount.value;
	 			accountFlag = fm.accountFlag.value;
	 			openBank = fm.openBank.value;
	 			routeNum = fm.routeNum.value;
	 			mobilePhone = fm.mobilePhone.value;
	 			address = fm.address.value;
	 			payWay = fm.payWay.value;
	    		payReason = fm.payReason.value;
	    		payPurpose = fm.payPurpose.value;
		 	}else{
	 			payName = fm.payName[index].value;
				identifyNumber =fm.identifyNumber[index].value;
	 			provinceName = fm.provinceName[index].value;
	 			cityName = fm.cityName[index].value;
	 			accountType = fm.accountType[index].value;
	 			bankName = fm.bankName[index].value;
	 			bankAccount = fm.bankAccount[index].value;
	 			accountFlag = fm.accountFlag[index].value;
	 			openBank = fm.openBank[index].value;
	 			routeNum = fm.routeNum[index].value;
	 			mobilePhone = fm.mobilePhone[index].value;
	 			address = fm.address[index].value;
	 			payWay = fm.payWay[index].value;
	    		payReason = fm.payReason[index].value;
	    		payPurpose = fm.payPurpose[index].value;
		 	}
			var strPameter = "payName="+payName+"&identifyNumber="+identifyNumber+"&provinceName="+provinceName+"&cityName="+cityName+"&accountType="+accountType+"&accountFlag="+accountFlag+"&bankAccount="+bankAccount+"&bankName="+bankName+"&openBank="+
					openBank+"&routeNum="+routeNum+"&mobilePhone="+mobilePhone+"&address="+address+"&payWay="+payWay+"&payReason="+payReason+"&payPurpose="+payPurpose+"&editType="+editType;
			var str = "/claim/common/payment/BankAccountMessage.jsp?"+strPameter;
	 		var returnValue = window.showModalDialog(str,window,"dialogWidth=1100px;dialogHeight=400px");
	 		if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
	 			if(count==1){
		 			fm.provinceName.value=returnValue[1];
		 			fm.cityName.value=returnValue[2];
		 			if(returnValue[3]==undefined){
		 				fm.accountType.value = "";
		 			}else{
		 				fm.accountType.value=returnValue[3];
		 			}
		 			fm.bankName.value=returnValue[4];
					if(returnValue[6]==undefined){
						fm.accountFlag.value="";
					}else{
						fm.accountFlag.value=returnValue[6];
					}
		 			fm.openBank.value=returnValue[7];
		 			fm.routeNum.value=returnValue[8];
		 			fm.address.value=returnValue[9];
		 			fm.mobilePhone.value=returnValue[10];
		 			fm.payWay.value=returnValue[11];
	    			fm.payReason.value=returnValue[12];
	    			fm.payPurpose.value=returnValue[13];
	    			if($(fm.registNo).css('background-color')=="#778899"){
		  				BGCOLORD_2 = "#778899";
		  			}
	    			fm.registNo.style.backgroundColor = BGCOLORD_2;
		  			fm.serialNo.style.backgroundColor = BGCOLORD_2;
		  			fm.policyNo.style.backgroundColor = BGCOLORD_2;
		  			fm.payName.style.backgroundColor = BGCOLORD_2;
		  			fm.identifyNumber.style.backgroundColor = BGCOLORD_2;
		  			fm.sumPaid.style.backgroundColor = BGCOLORD_2;
		  			fm.payAmount.style.backgroundColor = BGCOLORD_2;      
		 			BGCOLORD_2="#99FF99";    
		 		}else{
		 			fm.provinceName[index].value=returnValue[1];
		 			fm.cityName[index].value=returnValue[2];
		 			if(returnValue[3]==undefined){
		 				fm.accountType[index].value = "";
		 			}else{
		 				fm.accountType[index].value=returnValue[3];
		 			}
		 			fm.bankName[index].value=returnValue[4];
		 			fm.bankAccount[index].value=returnValue[5];
		 			if(returnValue[6]==undefined){
		 				fm.accountFlag[index].value = "";
		 			}else{
		 				fm.accountFlag[index].value=returnValue[6];
		 			}
		 			fm.openBank[index].value=returnValue[7];
		 			fm.routeNum[index].value=returnValue[8];
		 			fm.address[index].value=returnValue[9];
		 			fm.mobilePhone[index].value=returnValue[10];
		 			fm.payWay[index].value=returnValue[11];
	    			fm.payReason[index].value=returnValue[12];
	    			fm.payPurpose[index].value=returnValue[13];
		 			if($(fm.registNo[index]).css('background-color')=="#778899"){
		  				BGCOLORD_2 = "#778899";
		  			}
		  			fm.registNo[index].style.backgroundColor = BGCOLORD_2;
		  			fm.serialNo[index].style.backgroundColor = BGCOLORD_2;
		  			fm.policyNo[index].style.backgroundColor = BGCOLORD_2;
		  			fm.payName[index].style.backgroundColor = BGCOLORD_2;
		  			fm.identifyNumber[index].style.backgroundColor = BGCOLORD_2;
		  			fm.sumPaid[index].style.backgroundColor = BGCOLORD_2;
		  			fm.payAmount[index].style.backgroundColor = BGCOLORD_2;
		  			BGCOLORD_2="#99FF99";       
		 			
		 		}
	 		}
		}
		function checkElement(){
			$.ajax({
			url:'/claim/prplBilElementCheck.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,success:function(data){
				var arr  = data.split("##");
				var flag = arr[0];
				var message = arr[1];
				if(flag=="true"){
					if(message != ""){
						alert(message);
						return false;
					}else{
						
					}
				}else{
					alert('数据校验失败！');
					return false;
				}
			}
			,error:function(){alert('发生错误');}
		});
		}
		function saveForm(flag){
			var btn_save = document.getElementsByName("btn_save");
			var btn_submit = document.getElementsByName("btn_submit");
			if(checkPayment()){
				 buttonTableRemoveDisabled();
				 return false;
			}
			if(flag=='4'||flag=='2'){
				buttonTableAddDisabled();
			}
			fm.submitType.value=flag;
			
			prplregistOption();
			var strPameter="";
			if(flag=="9"){
				if(confirm("请确定是否删除全部数据？")){
					fm.action="/claim/prplBilDelete.do";
					fm.submit();
				}
			}
			if(flag=="5"){
				fm.action="/claim/common/payment/BillPaymentExcel.jsp";
				fm.submit();
			}
			if(flag=="7"){
				fm.action="/claim/common/payment/BillPaymentNoBillExcel.jsp";
				fm.submit();
			}
			if(flag=="6"){
				var inputs=$("input[id='element']");
				for(var i=0;i<inputs.length;i++){
					if(i==0){
						strPameter+=inputs[i].name+"="+inputs[i].value;
					}else{
						strPameter+="&"+inputs[i].name+"="+inputs[i].value;
					}
				}
				var strURL = "/claim/common/payment/UpLoadBillPayment.jsp?";
				window.showModalDialog(strURL,"NewWindow","scroll=1;status=0;dialogWidth=500px;dialogHeight=150px;dialogTop=300px;dialogLeft=500px");
			}
			if(flag=='4'||flag=='2'){
				$.ajax({
				url:'/claim/prplBilElementCheck.do'
				,type:'POST'
				,dataType:"text"
				,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
				,data:$(document.fm).serialize()
				,success:function(data){
					var arr  = data.split("##");
					var flag = arr[0];
					var message = arr[1];
					if(flag=="true"){
						if(message != ""){
							alert(message);
							buttonTableRemoveDisabled();
							return false;
						}else{
							x_load.show("数据提交中...");
							fm.submit();
						}
					}else{
						alert('数据校验失败！');
						return false;
					}
				}
				,error:function(){alert('发生错误');}
			});
		}
		}
		function deleteElementRow(field,intPageDataKeyCount,intRowsCount)
		{
		  var index = getElementOrder(field)-intPageDataKeyCount;
		  var count = getElementCount(field.name);
		  if(count==1){
		  	var sumTotalPaid = fm.sumTotalPaid.value;
	  		fm.sumTotalPaid.value = (parseFloat(sumTotalPaid) - parseFloat(fm.payAmount.value)).toFixed(2);
		    fm.deleteFlag.value="1";
		    fm.button_add.style.display="";
		    fm.button_delete.style.display="none";
		  	fm.registNo.style.backgroundColor = BGCOLORD;
		  	fm.serialNo.style.backgroundColor = BGCOLORD;
		  	fm.policyNo.style.backgroundColor = BGCOLORD;
		  	fm.payName.style.backgroundColor = BGCOLORD;
		  	fm.identifyNumber.style.backgroundColor = BGCOLORD;
		  	fm.sumPaid.style.backgroundColor = BGCOLORD;
		  	fm.payAmount.style.backgroundColor = BGCOLORD;
		  }else if(count>1){
		  	var sumTotalPaid = fm.sumTotalPaid.value;
	  		fm.sumTotalPaid.value = (parseFloat(sumTotalPaid) - parseFloat(fm.payAmount[index].value)).toFixed(2);
		    fm.deleteFlag[index].value="1";
		    fm.button_add[index].style.display="";
		    fm.button_delete[index].style.display="none";
		  	fm.registNo[index].style.backgroundColor = BGCOLORD;
		  	fm.serialNo[index].style.backgroundColor = BGCOLORD;
		  	fm.policyNo[index].style.backgroundColor = BGCOLORD;
		  	fm.payName[index].style.backgroundColor = BGCOLORD;
		  	fm.identifyNumber[index].style.backgroundColor = BGCOLORD;
		  	fm.sumPaid[index].style.backgroundColor = BGCOLORD;
		  	fm.payAmount[index].style.backgroundColor = BGCOLORD;
		  }
		}
		function FElementRow(field,intPageDataKeyCount,intRowsCount)
		{
		  
		  var index = getElementOrder(field)-intPageDataKeyCount;
		  var count = getElementCount(field.name);
		  if(count==1){
		  	if($(fm.registNo).css('background-color')=="#99ff99"){
		  	BGCOLORD_1 = "#99FF99";
		  	}else if($(fm.registNo).css('background-color')=="#778899"){
		  	BGCOLORD_1 = "#778899";
		  	}
		  	fm.registNo.style.backgroundColor = BGCOLORD_1;
		  	fm.serialNo.style.backgroundColor = BGCOLORD_1;
		  	fm.policyNo.style.backgroundColor = BGCOLORD_1;
		  	fm.payName.style.backgroundColor = BGCOLORD_1;
		  	fm.identifyNumber.style.backgroundColor = BGCOLORD_1;
		  	fm.sumPaid.style.backgroundColor = BGCOLORD_1;
		  	fm.payAmount.style.backgroundColor = BGCOLORD_1;
		  	     
		 	BGCOLORD_1="#6699CC";       
		 	
		  }else if(count>1){
		  	
		    for(var i=0;i<count;i++){
		    if($(fm.registNo[i]).css('background-color')=="#6699cc"){
		    	  fm.registNo[i].style.backgroundColor = "";
		  		  fm.serialNo[i].style.backgroundColor = "";
		  	      fm.policyNo[i].style.backgroundColor = "";
		  	      fm.payName[i].style.backgroundColor = "";
		  	      fm.identifyNumber[i].style.backgroundColor = "";
		  	      fm.sumPaid[i].style.backgroundColor = "";
		  	      fm.payAmount[i].style.backgroundColor = ""; 
		    	}
		    }
		    if($(fm.registNo[index]).css('background-color')=="#99ff99"){
		  	BGCOLORD_1 = "#99FF99";
		  	}else if($(fm.registNo[index]).css('background-color')=="#778899"){
		  	BGCOLORD_1 = "#778899";
		  	}
		  	fm.registNo[index].style.backgroundColor = BGCOLORD_1;
		  	fm.serialNo[index].style.backgroundColor = BGCOLORD_1;
		  	fm.policyNo[index].style.backgroundColor = BGCOLORD_1;
		  	fm.payName[index].style.backgroundColor = BGCOLORD_1;
		  	fm.identifyNumber[index].style.backgroundColor = BGCOLORD_1;
		  	fm.sumPaid[index].style.backgroundColor = BGCOLORD_1;
		  	fm.payAmount[index].style.backgroundColor = BGCOLORD_1; 
		 	BGCOLORD_1="#6699CC";       
		  }
		}
function addElementRow(field,intPageDataKeyCount,intRowsCount){
	 var index = getElementOrder(field)-intPageDataKeyCount;
	 var count = getElementCount(field.name);
	  if(count==1){
	  		var sumTotalPaid = fm.sumTotalPaid.value;
	  		fm.sumTotalPaid.value = (parseFloat(sumTotalPaid) + parseFloat(fm.payAmount.value)).toFixed(2);
	  		fm.deleteFlag.value="0";
			fm.button_add.style.display="none";
			fm.button_delete.style.display="";
		  	fm.registNo.style.backgroundColor = "";
		  	fm.serialNo.style.backgroundColor = "";
		  	fm.policyNo.style.backgroundColor = "";
		  	fm.payName.style.backgroundColor = "";
		  	fm.identifyNumber.style.backgroundColor = "";
		  	fm.sumPaid.style.backgroundColor = "";
		  	fm.payAmount.style.backgroundColor = "";
		  }else if(count>1){
		  	var sumTotalPaid = fm.sumTotalPaid.value;
	  		fm.sumTotalPaid.value = (parseFloat(sumTotalPaid) + parseFloat(fm.payAmount[index].value)).toFixed(2);
		    fm.deleteFlag[index].value="0";
			fm.button_add[index].style.display="none";
			fm.button_delete[index].style.display="";
		  	fm.registNo[index].style.backgroundColor = "";
		  	fm.serialNo[index].style.backgroundColor = "";
		  	fm.policyNo[index].style.backgroundColor = "";
		  	fm.payName[index].style.backgroundColor = "";
		  	fm.identifyNumber[index].style.backgroundColor = "";
		  	fm.sumPaid[index].style.backgroundColor = "";
		  	fm.payAmount[index].style.backgroundColor = "";
		  }
}
function impExcel(){
	var fileName1 = fm1.FILE1.value;
	if(fileName1=="")
	{
		errorMessage("请选择要上传的Excel文件!");
		return false;		
	}
	if((fileName1!=""&&fileName1.substring(fileName1.length-4,fileName1.length).toUpperCase()!=".XLS"))
	{
		errorMessage("请上传XLS文件!");
		return false;		
	}
	x_load.show('页面加载中...');
	fm1.action="/claim/prplBIllExcel.do";
	fm1.submit();
}
function showExcelHidden(){
	excelHidden.style.display = "";
	excelShow.style.display = "none";
}
function message(){
	if(fm.message.value!=null&&fm.message.value!=""){
		alert(fm.message.value);
	}
}

//用于将一个汉字转换成2个字节长度
	String.prototype.realLength = function(){
		return this.replace(/[^\x00-\xff]/g,"**").length;
	}
		/**
	* 校验输入的值不可大于最大长度
	*/
	function checkMaxlength(oInObj){
		var iMaxLen = parseInt(oInObj.getAttribute('maxlength')); 
		var iCurLen = oInObj.value.realLength(); 
		if ( oInObj.getAttribute && iCurLen > iMaxLen ){ 
			alert("录入的内容超出最大值，请重新录入！");
			oInObj.focus();
			return false;
		} 
	}
function checkPayment(){
		//校验支付编号在支付平台是否为退回状态 begin
		var ifThird = false;
		$.ajax({
			url:'/claim/checkPaymentNo.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,async:false
			,success:function(data){
				var arr  = data.split("##");
				var flag = arr[0];
				var ifThirdPay = (arr[1]==null||arr[1]=="")?"":arr[1].split("&&");
				if(flag=="true"){
					if(ifThirdPay[0]=='YES'){
						alert("该笔支付编号在支付平台不是退回状态，请核实！");
						ifThird = true;
					}else{
						ifThird = false;
					}
				}else{
					alert('校验失败！');
					ifThird = true;
				}
				//buttonTableRemoveDisabled();
			}
			,error:function(){alert('发生错误');}
		});
		return ifThird;
}	
	</script>
</head>
<% 
PrpallUtility prpallUtility = new PrpallUtility();
prpallUtility.getPhisicaMemory("数据初始化加载-----begin"); %>
  <body class="interface" onload="requestprevUrl();x_load.hide();message();">
  <script type="text/javascript">x_load.show("页面加载中...");</script>
  <form action="/claim/prplBIllExcelSave.do" name="fm"  method="post" >
  		<input type="hidden" name="payType" value="P3"/>
  		<input type="hidden" name="paymentType" value="P60"/>
  		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
  		<input type="hidden" name="pageConditions" id="pageConditions"  value="${turnPageDto.condition}">
  		<input type="hidden" name="submitType" value="">
  		<input type="hidden" name="editType" value="${editType }">
		<input type="hidden" name="Datatype" value="mergeMany">
		<input type="hidden" name="nodeType" value="apay">
		<input type="hidden" name="billFlag" value="1">
		<input type="hidden" name="noBillFlag" value="${noBillFlag }">
		<input type="hidden" name="mergerFlag" value="" >
		<input type="hidden" name="billNo" value="${billNo }">
		<input type="hidden" name="reQRegistNo" value="${reQRegistNo }">
		<input type="hidden" name="reQClaimNo" value="${reQClaimNo }">
		<input type="hidden" name="reQPolicyNo" value="${reQPolicyNo }">
		<input type="hidden" name="reQVflag" value="${reQVflag }">
		<input type="hidden" name="userCode" value="${userCode }">
		<input type="hidden" name="message" value="${message }">
  		<span style="text-align: left; width: 98%;font-size:12px">
			<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
				name="RegistExtImg" onclick="showPage(this,baseInfo)">&nbsp;清单列表
		</span>
		<c:if test="${not empty prpLclaimBillManagerList}">
   		<table  class="common" cellpadding="0" cellspacing="0" bordercolor="#3A81C8" id="baseInfo" border="1" style="width: 98%">
   			<tbody>
   					<tr>
	   					<td class="title" style="width: 5%">序号</td>
	   					<td class="title" style="width: 15%">报案号码</td>
		   				<td class="title" style="width: 15%">保单号码</td>
		   				<td class="title" style="width: 10%">姓名</td>
		   				<td class="title" style="width: 15%">身份证号</td>
		   				<td class="title" style="width: 10%">支付渠道</td>
		   				<td class="title" style="width: 10%">赔付金额</td>
		   				<td class="title" style="width: 10%">待支付剩余金额</td>
		   				<c:if test="${isAccBack}">
		   					<td class="title" style="width: 10%">退回原因</td>
		   				</c:if>
		   				<td class="title" style="width: 10%">账户信息</td>
		   				<td class="title" style="width: 5%">操作</td>
		   			</tr>
	   			
	   			<c:forEach items="${prpLclaimBillManagerList}" var="billManager" varStatus="status">
	    		<tr>
	    			<td class="input"  style="width: 5%">
	    				<input type="text" class="readonly" readonly  name="serialNo" value="${status.index+1 }">
	    				<input type="hidden"  name="paymentNo" value="${billManager.paymentNo }">
	    				<input type="hidden"  name="vflag" value="${billManager.vflag }" > 
	    			</td>
					<td class="input"  style="width: 15%">
						<input type="text" class="readonly"  readonly  name="registNo" value="${billManager.registNo }">
						<input type="hidden"  name="claimNo" value="${billManager.claimNo }">
						<input type="hidden"  name="compensateNo" value="${billManager.compensateNo }">
						<input type="hidden"  name="fkSerialNo" value="${billManager.fkSerialNo }">
						<input type="hidden"  name="payAmounts" value="${billManager.payAmounts }">
					</td>
					<td class="input"  style="width: 15%">
						<input type="text"  class="readonly" readonly name="policyNo" value="${billManager.policyNo }">
					</td>
					<td class="input"  style="width: 10%">
	    				<input type="text"   class="readonly" readonly name="payName" value="${billManager.payName }">
	    				<input type="hidden"  name="provinceName" value="${billManager.provinceName }">
	    				<input type="hidden"  name="cityName" value="${billManager.cityName }">
	    				<input type="hidden"  name="accountType" value="${billManager.accountType }">
	    				<input type="hidden"  name="accountFlag" value="${billManager.accountFlag }">
	    				<input type="hidden"  name="bankAccount" value="${billManager.bankAccount }">
	    				<input type="hidden"  name="bankName" value="${billManager.bankName }">
	    				<input type="hidden"  name="openBank" value="${billManager.openBank }">
	    				<input type="hidden"  name="routeNum" value="${billManager.routeNum }">
	    				<input type="hidden"  name="mobilePhone" value="${billManager.mobilePhone }">
	    				<input type="hidden"  name="address" value="${billManager.address }">
	    				<input type="hidden"  name="payWay" value="${billManager.payWay }">
	    				<input type="hidden"  name="payReason" value="${billManager.payReason }">
	    				<input type="hidden"  name="payPurpose" value="${billManager.payPurpose }">
	    				<input type="hidden"  name="certifType" value="01">
	    				<input type="hidden"  name="receiverTypeOther" value="t01">
	    				<input type="hidden"  name="receiverTypeOtherName" value="被保险人">
	    				<input type="hidden"  name="receiverFullCode" value="">
			    	</td>
			    	<td class="input"   style="width: 15%">
			    		<input type="text"  class="readonly" readonly name="identifyNumber" value="${billManager.identifyNumber }">
			    	</td>
			    	<td class="input"   style="width: 10%">
			   			<c:forEach items="${realPayWayMap }" var="realPayWayM">
			    			<c:if test="${realPayWayM.key eq  billManager.realPayWay}">${realPayWayM.value }</c:if>
			    		</c:forEach>
			   			<input type="hidden" name="realPayWay" value="${billManager.realPayWay }"/>
			   		</td>
			    	<td class="input"   style="width: 10%">
			    		<input type="text"  class="readonly" readonly name="sumPaid" value="<fmt:formatNumber type='number' value='${billManager.sumPaid }' pattern='#0.00' maxFractionDigits='2'/>">
			    	</td>
			    	<td class="input"   style="width: 10%">
			    		<input type="text"  class="readonly" readonly name="payAmount" value="<fmt:formatNumber type='number' value='${billManager.payAmount-billManager.havPaid}' pattern='#0.00' maxFractionDigits='2'/>">
			    	</td>
			    	<c:if test="${isAccBack}">
	   					<td class="input" style="width: 10%">
							<input type="text"  class="readonly" readonly name="backReason" value="${billManager.payReMark}">
						</td>
	   				</c:if>
			    	<td class="input" style="width: 10%" align="center">
			    		<input type="button" class="button" name="AccountMessage" value="账户信息" onclick="FElementRow(this,1,1);bankAccountMessage(this);">
			    	</td>
			    	<td class="input" style="width: 5%" align="center">
			    		<input type="hidden" name="deleteFlag" value="0">
			    		<input type="button" class="button" name="button_delete" value="删除" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if> onclick="deleteElementRow(this,1,1);">
			    		<input type="button" class="button" name="button_add" value="恢复" style="display: none" onclick="addElementRow(this,1,1);">
			    	</td>
			   	</tr>
	   		    </c:forEach>
	   		    <tr>
	   		    	<td class="input"  align="center" colspan="6">
						本次总支付金额
					</td>
	   		    	<td class="input" >
	   		    		<input type="text" name="sumTotalPaid" readOnly class="readonly" value="${sumTotalPaid}" />
	   		    	</td>
	   		    </tr>
	   		   <tbody>
   		</table>
   		</c:if>
   		 <c:if test="${not empty prpLbillPayDtoList}">
	     <table  class="common" cellpadding="0" cellspacing="0" bordercolor="#3A81C8" id="baseInfo" border="1" style="width: 98%">
	     		<tbody>
	     		<tr>
   					<td class="title" style="width: 5%">序号</td>
   					<td class="title" style="width: 15%">报案号码</td>
	   				<td class="title" style="width: 15%">保单号码</td>
	   				<td class="title" style="width: 10%">姓名</td>
	   				<td class="title" style="width: 15%">身份证号</td>
	   				<td class="title" style="width: 10%">赔付金额</td>
	   				<td class="title" style="width: 10%">待支付剩余金额</td>
	   				<c:if test="${isAccBack}">
	   					<td class="title" style="width: 10%">退回原因</td>
	   				</c:if>
	   				<td class="title" style="width: 10%">账户信息</td>
	   				<td class="title" style="width: 5%">操作</td>
	   			</tr>
	   			<c:forEach items="${prpLbillPayDtoList}" var="billPay" varStatus="status">
	    		<tr>
	    			<td class="input"  style="width: 5%">
	    				<input type="text"  class="readonly" readonly name="serialNo" value="${billPay.serialNo }">
	    				<input type="hidden"  name="paymentNo" value="${billPay.paymentNo }">
	    				<input type="hidden"  name="vflag" value="${billPay.vflag }" > 
	    			</td>
					<td class="input"  style="width: 15%">
						<input type="text"  class="readonly" readonly  name="registNo" value="${billPay.registNo }">
						<input type="hidden"  name="claimNo" value="${billPay.claimNo }">
						<input type="hidden"  name="compensateNo" value="${billPay.compensateNo }">
						<input type="hidden"  name="fkSerialNo" value="${billPay.fkSerialNo }">
						<input type="hidden"  name="payAmounts" value="${billPay.payAmounts }">
					</td>
					<td class="input"  style="width: 15%">
						<input type="text"  class="readonly" readonly name="policyNo" value="${billPay.policyNo }">
					</td>
					<td class="input"  style="width: 10%">
	    				<input type="text"   class="readonly" readonly name="payName" value="${billPay.receiverfullName }">
	    				<input type="hidden"  name="provinceName" value="${billPay.provinceName }">
	    				<input type="hidden"  name="cityName" value="${billPay.cityName }">
	    				<input type="hidden"  name="accountType" value="${billPay.accountType }">
	    				<input type="hidden"  name="accountFlag" value="${billPay.accountFlag }">
	    				<input type="hidden"  name="bankAccount" value="${billPay.bankAccount }">
	    				<input type="hidden"  name="bankName" value="${billPay.bankType }">
	    				<input type="hidden"  name="openBank" value="${billPay.bank }">
	    				<input type="hidden"  name="routeNum" value="${billPay.routeNum }">
	    				<input type="hidden"  name="mobilePhone" value="${billPay.mobilePhone }">
	    				<input type="hidden"  name="address" value="${billPay.address }">
	    				<input type="hidden"  name="payWay" value="${billPay.payWay }">
	    				<input type="hidden"  name="payReason" value="${billPay.payReason }">
	    				<input type="hidden"  name="payPurpose" value="${billPay.payPurpose }">
	    				<input type="hidden"  name="certifType" value="01">
	    				<input type="hidden"  name="receiverTypeOther" value="t01">
	    				<input type="hidden"  name="receiverTypeOtherName" value="被保险人">
	    				<input type="hidden"  name="receiverFullCode" value="">
			    	</td>
			    	<td class="input"   style="width: 15%">
			    		<input type="text"  class="readonly" readonly name="identifyNumber" value="${billPay.certifNo }">
			    	</td>
			    	<td class="input"   style="width: 10%">
			    		<input type="text"  class="readonly" readonly name="sumPaid" value="<fmt:formatNumber type='number' value='${billPay.payAmount }' pattern='#0.00' maxFractionDigits='2'/>">
			    	</td>
			    	<td class="input"   style="width: 10%">
			    		<input type="text"  class="readonly" readonly name="payAmount" value="<fmt:formatNumber type='number' value='${billPay.payAmount }' pattern='#0.00' maxFractionDigits='2'/>">
			    	</td>
			    	<c:if test="${isAccBack}">
	   					<td class="input" style="width: 10%">
							<input type="text"  class="readonly" readonly name="backReason" value="${billPay.payReMark}">
						</td>
	   				</c:if>
			    	<td class="input" style="width: 10%" align="center">
			    		<input type="button" class="button" name="AccountMessage" value="账户信息" onclick="bankAccountMessage(this);">
			    	</td>
			    	<td class="input" style="width: 5%" align="center">
			    		<input type="hidden" name="deleteFlag" value="0">
			    		<input type="button" class="button" name="button_delete" value="删除" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if> onclick="deleteElementRow(this,1,1);"/>
			    		<input type="button" class="button" name="button_add" value="恢复" style="display: none" onclick="addElementRow(this,1,1);">
			    	</td>
			   	</tr>
	   		    </c:forEach>
	   		    <tr>
	   		    	<td class="input"  align="center" colspan="6">
						本次总支付金额
					</td>
	   		    	<td class="input" >
	   		    		<input type="text" name="sumTotalPaid" readOnly class="readonly" value="<fmt:formatNumber type='number' value='${sumTotalPaid}' pattern='#0.00' maxFractionDigits='2'/>" />
	   		    	</td>
	   		    </tr>
	   		    <tbody>
	     </table>
	     </c:if>
	     <c:if test="${type ne '6'}">
	       	<%@include file="/common/payment/DAAPayRegistExt.jsp" %>
	     </c:if>
	     </form>
	<form action="/claim/prplBIllExcelSave.do" name="fm1"  method="post" ENCTYPE="multipart/form-data">
  		<input type="hidden" name="editType" value="${editType }">
		<input type="hidden" name="billNo" value="${billNo }">
		<input type="hidden" name="noBillFlag" value="${noBillFlag }">
		<input type="hidden" name="reQRegistNo" value="${reQRegistNo }">
		<input type="hidden" name="reQClaimNo" value="${reQClaimNo }">
		<input type="hidden" name="reQPolicyNo" value="${reQPolicyNo }">
		<input type="hidden" name="reQVflag" value="${reQVflag }">
		<input type="hidden" name="isAccBack" value="${isAccBack }">
		<c:if test="${not empty prpLclaimBillManagerList}">
   		<table  class="common" cellpadding="0" cellspacing="0" bordercolor="#3A81C8"  border="1" style="width: 98%">
	   			<c:forEach items="${prpLclaimBillManagerList}" var="billManager" varStatus="status">
	    				<input type="hidden"  name="paymentNo" value="${billManager.paymentNo }">
						<input type="hidden"  name="compensateNo" value="${billManager.compensateNo }">
						<input type="hidden"  name="fkSerialNo" value="${billManager.fkSerialNo }">
						<input type="hidden"  name="payAmounts" value="${billManager.payAmounts }">
	    				<input type="hidden"  name="payName" value="${billManager.payName }">
			    		<input type="hidden"  name="identifyNumber" value="${billManager.identifyNumber }">
			    		<input type="hidden"  name="payAmount" value="${billManager.payAmount-billManager.havPaid }">
			    		<input type="hidden"  name="backReason" value="${billManager.payReMark}">
	   		    </c:forEach>
	   		    <c:if test="${editType ne 'SHOW' }">
	   		     <tr id="excelHidden" style="display: none">
					 <td class="title"  align="center">文件名:</td>
			    	 <td class=title ><input TYPE="file"  name="FILE1" OnKeyDown="return false" SIZE="60">
			    	 </td>
		    		<td id="originButton1"  align="center">
	        	 		<input class="button"   type=button value="数据导入" onclick="impExcel();window.close() " <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if>> 
	        	 	</td>
					<c:if test="${noBillFlag eq '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="支付清单模板" onclick="saveForm('7');" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if> >
	        	 	</td>
					</c:if>
					<c:if test="${noBillFlag ne '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="导出账户信息" onclick="saveForm('5');" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if> >
	        	 	</td>
					</c:if>
	        	 </tr>
        	 	 <tr id="excelShow">
	        	 	<td class="title"  width="77%" colspan="2"></td>
	        	 	<td id="originButton1"  align="center">
	        	 		<input class="button"   type=button value="导入账户信息" onclick="showExcelHidden();" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if>> 
	        	 	</td>
					<c:if test="${noBillFlag eq '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="支付清单模板" onclick="saveForm('7');"  >
	        	 	</td>
					</c:if>
					<c:if test="${noBillFlag ne '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="导出账户信息" onclick="saveForm('5');"  >
	        	 	</td>
					</c:if>
        	 	<tr>
	        	 </c:if>
	        	 <c:if test="${editType eq 'SHOW' }">
	        	 	<tr>
					<c:if test="${noBillFlag eq '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="支付清单模板" onclick="saveForm('7');"  >
	        	 	</td>
					</c:if>
					<c:if test="${noBillFlag ne '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="导出账户信息" onclick="saveForm('5');"  >
	        	 	</td>
					</c:if>
	        	 </tr>
	        	 </c:if>
   		</table>
   		 </c:if>
   		 <c:if test="${not empty prpLbillPayDtoList}">
	     <table  class="common" cellpadding="0" cellspacing="0" bordercolor="#3A81C8" border="1" style="width: 98%">
	   			<c:forEach items="${prpLbillPayDtoList}" var="billPay" varStatus="status">
	    				<input type="hidden"  name="paymentNo" value="${billPay.paymentNo }">
						<input type="hidden"  name="compensateNo" value="${billPay.compensateNo }">
						<input type="hidden"  name="fkSerialNo" value="${billPay.fkSerialNo }">
						<input type="hidden"  name="payAmounts" value="${billPay.payAmounts }">
	    				<input type="hidden"  name="payName" value="${billPay.receiverfullName }">
			    		<input type="hidden"  name="identifyNumber" value="${billPay.certifNo }">
			    		<input type="hidden"  name="payAmount" value="${billPay.payAmount }">
			    		<input type="hidden"  name="backReason" value="${billPay.payReMark}">
	   		    </c:forEach>
	   		    <c:if test="${editType ne 'SHOW' }">
	   		     <tr>
					 <td class="title"  align="center">文件名:</td>
			    	 <td class=title ><input TYPE="file"  name="FILE1" OnKeyDown="return false" SIZE="60">
			    	 </td>
		    		<td id="originButton1"  align="center">
	        	 		<input class="button"   type=button value="数据导入" onclick="impExcel();window.close() " <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if>> 
	        	 	</td>
					<c:if test="${noBillFlag eq '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="支付清单模板" onclick="saveForm('7');"  >
	        	 	</td>
					</c:if>
					<c:if test="${noBillFlag ne '1' }">
	        	 	<td align="center" >
	        	 		<input type="button" name="btn"  class="button" value="导出账户信息" onclick="saveForm('5');"  >
	        	 	</td>
					</c:if>
	        	 </tr>
	        	 </c:if>
	     </table>
	     </c:if>
	     <c:forEach items="${prpLpayExtDtoList }" var="prpLpayExtDto" varStatus="status">
			<c:if test="${(prpLpayExtDto.flag ne 'N') or (editType eq 'SHOW')}">
					<input type="hidden" name="prpLpayExtFlag1" value="${prpLpayExtDto.flag }"  />
					<input type="hidden" name="prpLpayExtSerialNo1" value="${prpLpayExtDto.serialNo }"  />
					<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtRowNum" value="${status.count }" />
					<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtNodeType1" value="${prpLpayExtDto.nodeType }" class="readonly" readonly />
					<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtNodeName1" value="${prpLpayExtDto.nodeName}" class="readonly" readonly />
		      		<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtInputDate1" value="${prpLpayExtDto.inputDate }" class="readonly" readonly />
		     		<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtCostTime1" value="${prpLpayExtDto.costTime}" class="readonly" readonly />
	     			<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtOperatorCode1" value="${prpLpayExtDto.operatorCode }" class="readonly" readonly />
	     			<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtOperatorCodeName1" value="${prpLpayExtDto.operatorCodeName }" class="readonly" readonly />
					<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtComCName1" value="${prpLpayExtDto.comCName}" />
					<input type="hidden" style="text-align:center;width:100%" name="prpLpayExtComCode1" value="${prpLpayExtDto.comCode }" />
	     			<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionCode1" value="${prpLpayExtDto.notionCode }" />
	     			<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionName1" value="${prpLpayExtDto.notionName }" />
		      		<input type="hidden" class="readonly" readonly style="text-align:center;width:100%" name="prpLpayExtContext1" value="${prpLpayExtDto.context }" />
			</c:if>
		</c:forEach>
		<c:if test="${(editType ne 'SHOW')}">
				<input type="hidden" name="prpLpayExtFlag2" value="${prpLpayExtDtoNew.flag }"  />
				<input type="hidden" name="prpLpayExtSerialNo2" value="${prpLpayExtDtoNew.serialNo }"  />
				<c:if test="${not empty prpLpayExtDtoList }">
					<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtRowNum2" value="${fn:length(prpLpayExtDtoList)+1}" />
				</c:if>
				<c:if test="${empty prpLpayExtDtoList }">
					<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtRowNum2" value="1" />
				</c:if>
				<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtNodeName2" value="${prpLpayExtDtoNew.nodeName }" class="readonly" readonly />
				<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtNodeType2" value="${prpLpayExtDtoNew.nodeType }" class="readonly" readonly />
	      		<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtInputDate2" value="${prpLpayExtDtoNew.inputDate }" class="readonly" readonly />
	     		<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtCostTime2" value="${prpLpayExtDtoNew.costTime} " class="readonly" readonly />
     			<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtOperatorCode2" value="${prpLpayExtDtoNew.operatorCode }" class="readonly" readonly />
     			<input type="hidden"  style="text-align:center;width:99%" name="prpLpayExtOperatorCodeName2" value="${prpLpayExtDtoNew.operatorCodeName }" class="readonly" readonly />
				<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtComCName2" value="${prpLpayExtDtoNew.comCName}" />
				<input type="hidden" style="text-align:center;width:100%" name="prpLpayExtComCode2" value="${prpLpayExtDtoNew.comCode }" />
     			<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionCode2" value="${prpLpayExtDtoNew.notionCode }" />
     			<input type="hidden" class="readonly" style="text-align:center;width:100%" name="prpLpayExtNotionName2" value="${prpLpayExtDtoNew.notionName }" />
	      		<input type="hidden" class="readonly" style="text-align:left;width:100%" name="prpLpayExtContext2" value="${prpLpayExtDtoNew.context }" />
		 </c:if>
	     </form>
	   <c:if test="${editType ne 'SHOW' }">
	   	<div id="outcontainer" name="submitDiv" style="width: 98%">
	    	<div >
		        <table align="center" id="buttonTable">
		           <tr style="valign:middle">
		        	 <td id="originButton1">
		        	 	<input type="button" name="btn_save" class="button" value="暂存" onclick="saveForm('2');" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if>/> 
		        	 	<input type="button" name="btn_submit" class="button" value="提交" onclick="saveForm('4');" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if>/>
		        	 	<c:if test="${editType ne 'ADD' }">
		        	 	<input type="button" name="btn_save" class="button" value="删除" onclick="saveForm('9');" <c:if test="${editType eq 'SHOW'}">disabled="disabled"</c:if>/>
		        	 	</c:if> 
		        	 </td>
		        	</tr>
		        </table>
	        </div>
	     </div>
	     </c:if>
</body>
</html>
<%prpallUtility.getPhisicaMemory("数据初始喊加载-----end"); %>