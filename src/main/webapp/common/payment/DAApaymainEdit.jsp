<%@page contentType="text/html; charset=GBK"	language="java"	%>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLpayHisDto" %> 
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<%
	PrpLpayHisDto prpLpayHisDto1 = (PrpLpayHisDto)request.getAttribute("prpLpayHisDto");

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
<script type="text/javascript">
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
	
	function queryThird(){
		//校验是否为第三方支付上线之前数据 begin
		var ifThird = false;
		$.ajax({
			url:'/claim/thirdPayQuery.do'
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
						ifThird = true;
					}else{
						alert('该笔支付对象关联的'+ifThirdPay[1]+'计算中，在第三方支付上线前已核赔通过，请在机构收付系统处理，无需录入支付信息！');
						ifThird = false;
					}
				}else{
					alert('校验失败！');
				}
				//buttonTableRemoveDisabled();
			}
			,error:function(){alert('发生错误');}
		});
		return ifThird;
		//校验是否为第三方支付上线之前数据 end
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
	
	//校验清单领款人和身份证件号不可更改
	function checkNameAndCertino(){
		var checkFlag=true;
		var billFlag = $("input[name='billFlag']").val();
		if(billFlag!=null && billFlag=="1"){
			var receiverFullName = $("#receiverFullName").val();
			var receiverFullNameCheck = $("#receiverFullNameCheck").val();
			var certifNo = $("#certifNo").val();
			var certifNoCheck = $("#certifNoCheck").val();
			//alert("receiverFullName="+receiverFullName+"receiverFullNameCheck="+receiverFullNameCheck);
			if(receiverFullName==receiverFullNameCheck && certifNo==certifNoCheck){
				checkFlag=true;
			}else{
				checkFlag=false;
			}
		}
		return checkFlag;
	}
	
	function saveForm(submitType){
		//验证赔付信息页面必录项
		buttonTableAddDisabled();
		//验证省市信息是否符合要求
		var pro = $("#pro").val();
		var btn_hukou = $("#btn_hukou").val();
		var errMsg = "";
	    $.ajax({
			url:"/claim/checkCityAndPro.do"
			,type:"POST"
			,dataType:"text"
			,async:false
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:{"pro":pro,"city":btn_hukou}
			,success:function(data){
				var retMsg = data.split(",");
				var isCity = retMsg[0];
				var isPro = retMsg[1];
				if(isCity!="true"){
					errMsg +="城市名称不符合录入要求！"; 
				}
				if(isPro!="true"){
					errMsg +="省份名称不符合录入要求！";
				}
			}
			,error:function(){alert('系统异常！');}
		});
		if(errMsg.length>0){
			alert(errMsg);
			buttonTableRemoveDisabled();
			return false;
		}
		if(!checkMainInfo()){
		 buttonTableRemoveDisabled();
		 return false;
		 }
		if(!queryThird()){
			 buttonTableRemoveDisabled();
			 return false;
		}
		if(checkPayment()){
			 buttonTableRemoveDisabled();
			 return false;
		}
		if(!checkPaymentIfRepeat()){
			buttonTableRemoveDisabled();
			 return false;
		}
		 var ipayAmount = $("input[name='payAmount']").val();
		 var ipayWay = $("input:radio[name='payWay']:checked").val();
		 if(parseFloat(ipayAmount)<=0&&ipayWay=='1'){
		 	alert("本次支付金额为0或负数时，支付方式请选择“传统方式支付”。");
		 	//$("input:radio[name='payWay' ][value='2']").attr('checked','checked');
		 	buttonTableRemoveDisabled();
			return false;
		 }
		 //if($("input[type=checkbox][name='flag'][checked]").length>1&&ipayWay=='2'){
	     //		alert("支付方式为“传统方式支付”时，赔付信息只能勾选一条需支付的信息。");
	     //		 buttonTableRemoveDisabled();
	     //		return false;
	     //	}
		if(submitType=='4'){
			//验证基础信息页面的必录项
			if(!checkBaseInput()){ 
				buttonTableRemoveDisabled();
				return false;
			}
			//验证账户信息页面的必录项
			if(!checkAccountInput()){
			 buttonTableRemoveDisabled();
			 return false;
			 }
			//验证领款人信息页面的必录项
			if(!checkReceiverInput()){
			 buttonTableRemoveDisabled();
			 return false;
			}
			//验证录入说明必录
			var direction = $("textarea[name='prpLpayExtNewContext']").val();
			if(direction==null||direction==""){
				alert("请录入录入说明");
				buttonTableRemoveDisabled();
				return false;
			}
			if(!checkReceiverAndPaymentType()){
			 buttonTableRemoveDisabled();
			 return false;
			 }
		}
		
		if(submitType!=null&&submitType=='2'){
			fm.submitType.value='2';
		}else if(submitType!=null&&submitType=='4'){
			fm.submitType.value='4';
		}else{
			fm.submitType.value='0';
		}
		if(submitType=='2' || submitType=='4'){
			if(!checkNameAndCertino()){
				alert("通过清单客户信息录入的领款人名称和证件号码不允许更改");
				buttonTableRemoveDisabled();
				return false;
			}
		}
		prplregistOption();
		$.ajax({
			url:'/claim/payMainSave.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,success:function(data){
				var arr  = data.split("##");
				var flag = arr[0];
				var paymentNo = (arr[1]==null||arr[1]=="")?"":arr[1];
				if(flag=="true"){
					window.onbeforeunload=onClose;
					if(fm.submitType.value=='4'){
						alert('提交成功！');
						$("input[type='button']").attr('disabled',"true");
						//window.close();
						goBack();
					}else{
						alert('保存成功！');
						//window.location="paymainEdit.do?paymentNo="+paymentNo+"&nodeType=apay&editType=EDIT";
						var Datatype = fm.Datatype.value
						//fm.nodeType.value="apay";
						//fm.paymentNo.value=paymentNo;
						//fm.action='paymainEdit.do';
						goBack();
						//fm.action="paymainEdit.do?paymentNo="+paymentNo+"&nodeType=apay&editType=EDIT&Datatype="+Datatype;
						//fm.submit();
					}
				}else{
					alert('保存失败！');
				}
				//buttonTableRemoveDisabled();
				$("input[type=button][value='关闭']").removeAttr("disabled","");//两核系统访问时处理意见可录入
			}
			,error:function(){alert('发生错误');}
		});
	}
	
	
	function checkPaymentIfRepeat(){
	//保存或提交前判断当前录入支付信息的关联计算书金额是否在计算书金额范围内begin
	var ifOver = false;
	$.ajax({
		url:'/claim/checkCompensateNoMoney.do'
		,type:'POST'
		,dataType:"text"
		,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
		,data:$(document.fm).serialize()
		,async:false
		,success:function(data){
			var arr  = data.split("##");
			var flag = arr[0];
			var ifOverPay = (arr[1]==null||arr[1]=="")?"":arr[1].split("&&");
			if(flag=="true"){
				if(ifOverPay[0]=='NO'){
					ifOver = true;
				}else{
					alert('该笔支付对象关联的'+ifOverPay[1]+'计算书中，录入的支付金额汇总系统该计算书已录入的金额超出计算书理算金额，请核实！');
					ifOver = false;
				}
			}else{
				alert('校验失败！');
			}
			//buttonTableRemoveDisabled();
		}
		,error:function(){alert('发生错误');}
	});
	return ifOver;
	//保存或提交前判断当前录入支付信息的关联计算书金额是否在计算书金额范围内 end
}
	
	function onClose(){
		if(window.opener!=null){
			window.opener.ReceiveValue();//打开普通窗口的方式，通过此方法调用父页面刷新页面方法
		}
	}
	/**
	*	更改某些值后刷新页面
	*/
	function changeValueReload(){
		var url="";
		var registNo= document.getElementById("registNo").value;
		var nodeType= document.getElementById("nodeType").value;
		var editType= document.getElementById("editType").value;
		var paymentNo = document.getElementById("paymentNo").value;
		var isBtn= document.getElementById("isBtn").value;
		//var compensateNo= document.getElementById("compensateNo").value;
		url ="registNo="+registNo+"&nodeType="+nodeType+"&editType="+editType+"&isBtn="+isBtn;//&compensateNo="+compensateNo;
		var compensateNos = document.getElementsByName("compensateNo");
		for(var a=0;a<compensateNos.length;a++){
			url+="&compensateNo="+compensateNos[a].value;
		}
		var payType=$("input[name='payType']").val();
		var paymentType=$("input[name='paymentType']").val();
		url +="&payType="+payType+"&paymentType="+paymentType+"&paymentNo="+paymentNo;
		window.location="/claim/paymainEdit.do?"+url;
	}
		
	//付款通知书打印
	function print(){
		//var noticeNo = fm.noticeNo.value;
		var paymentNo = $("input[name='paymentNo']").val();
		var url = "/claim/paymainPrint.do?paymentNo="+paymentNo;
		window.showModalDialog(url,"打印","dialogWidth=756px;dialogHeight=1086px;dialogLeft=5px;center=yes;scroll=yes;");
		//window.open(url);
		//fm.action="/claim/paymainPrint.do";
		//fm.submit();
	}
	/**
	* checkbox置为不可用
	*/
	function readonlyAllCheckbox(){
		var elements = document.all;
		var len = elements.length;
		for(i=0; i < len; i++){
			if(elements[i].tagName=="INPUT"){
				tempElements = elements[i];
				if(tempElements.type=="checkbox"){
			    	tempElements.disabled=true;
			    }
				   
			  }
		}
		$("#prpLpayExtNewContext").removeAttr("readOnly");//两核系统访问时处理意见可录入
	}
	/**
	* 删除记录
	*/
	function remove(){
		if(checkPayment()){
			 buttonTableRemoveDisabled();
			 return false;
		}
		var paymentNo = $("input[name='paymentNo']").val();
		var billFlag = $("input[name='billFlag']").val();
		//var registNo= $("input[name='registNo']").val();
		if(typeof(paymentNo) == "undefined"||paymentNo==""){
			//window.close();
			goBack();
		}else{
			if(confirm("确认删除？")){
				$.ajax({
					url:'/claim/paymainRemove.do'
					,type:'POST'
					,dataType:"text"
					,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
					,data:{'paymentNo':paymentNo,'billFlag':billFlag}
					,success:function(data){
						if(data=="true"){
							alert('删除成功！');
							window.onbeforeunload=onClose;
							//window.close();
							goBack();
						}else{
							alert('删除失败！');
						}
					}
					,error:function(){alert('发生错误');}
				});	
			}
		}
	}
	//返回上页面函数
	function goBack(){
		var nowUrl = document.URL;
		var nowUrlStr = nowUrl.substring(0,nowUrl.indexOf("?"));
		var preUrl = document.referrer;
		var preu = fm.prevPageUrl.value;
		var Datatype = fm.Datatype.value;
		var back = fm.back.value;
		//alert("@nowUrl="+nowUrl+"   /n@preUrl="+preUrl+"   /n@preu="+preu +"  /n@Datatype="+Datatype);
		if(preUrl==null||preUrl==""){
			window.close();
		}else{
			var preUrlStr=preUrl.substring(0,preUrl.indexOf("?"));
			if(nowUrlStr==preUrlStr){
				//window.history.go(-2);
				if(Datatype!=null&&Datatype=="mergeMany"){
					//var preu = fm.prevPageUrl.value;
					//alert("@preu="+preu);
					window.location=preu;
				}
				window.close();
			}else{
				//Datatype!=null&&Datatype=="mergeMany"&&
				if(preu!=null&&preu!=""){
					var toUrl = "";
					if(preu!=null&&preu.indexOf("?")>-1){
						toUrl = preu+"&doQuery=query&back="+back;
					}else{
						toUrl = preu+"?doQuery=query";
					}
					//alert("###");
					fm.action=toUrl;
					fm.submit();
					//window.location=toUrl;
				}else{
					window.history.go(-1);
				}
				//preUrl = preUrl+"?doQuery=query";
				//window.location=preUrl;
			}
		}
	}
	//流程图链接 dataFrom :数据来源此处为支付环节
	function logstore(registNo,dataFrom){
		var url = "/claim/swfFlowBeforeQuery.do?registNo="+registNo+"&dataFrom="+dataFrom+"";
		if(hasSVG()){
			url += "&svgFlag=1";
		}else{
			url += "&svgFlag=0";
		}
		window.open(url);
	}
	function hasSVG(){
  		SVG_NS = 'http://www.w3.org/2000/svg';
		return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
  	}
	var BGCOLORU="#FFFF00";        //修改(颜色)
	function setElementColor(DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var elementSelect;
  var color = "";

  //--以下是flag=="U"的情况
  color = BGCOLORU;

  //得到Input域的名字
  
  var count = getElementCount('registNoPay');
  var registNo = '';
  if(count==1){
  	registNo = fm.registNoPay.value;
  }else if(count>1){
  	registNo = fm.registNoPay[0].value;
  }
  
  elements = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("input");
  for(i=0;i<elements.length;i++)
  {
    if(elements[i].type=="button") continue;
    if(elements[i].type=="text"&&fm.all(elements[i].name).value!=fm.all(elements[i].name).title){
      var name = elements[i].name;
      var value = fm.all(elements[i].name).value;
       var parent= $(fm.all(elements[i].name)).parent();
       parent.children().remove();
       parent.html("<input type='hidden' name='"+name+"' value='"+value+"'><a style='color:red' href='###' onclick='queryHistory(\""+name+"\",\""+registNo+"\")'>"+value+"</a>");
    }else if(elements[i].type=="radio"){
    	if(fm.all(elements[i].name)[0].checked==true){
  			if(fm.all(elements[i].name)[0].value!=fm.all(elements[i].name)[0].title){
      			var name = elements[i].name;
      			var value = fm.all(elements[i].name)[0].value;
      			var textvalue = '个人账号';
       			var parent= $(fm.all(elements[i].name)[0]).parent();
       			parent.children().remove();
       			parent.html("<input type='hidden' name='"+name+"' value='"+value+"'><a style='color:red' href='###' onclick='queryHistory(\""+name+"\",\""+registNo+"\")'>"+textvalue+"</a>");
      		}
	  	}else if(fm.all(elements[i].name)[1].checked==true){
	  		if(fm.all(elements[i].name)[1].value!=fm.all(elements[i].name)[1].title){
	      		var name = elements[i].name;
      			var value = fm.all(elements[i].name)[0].value;
      			var textvalue = '单位账号';
       			var parent= $(fm.all(elements[i].name)[0]).parent();
       			parent.children().remove();
       			parent.html("<input type='hidden' name='"+name+"' value='"+value+"'><a style='color:red' href='###' onclick='queryHistory(\""+name+"\",\""+registNo+"\")'>"+textvalue+"</a>");
	      	}
	  	}
	}
  }
  
  //得到Select域的名字
  elementSelect = document.all(DataPageCode).tBodies.item(0).getElementsByTagName("select");
  for(j=0;j<elementSelect.length;j++)
  {  
  	if(elementSelect[j].type=="button");
	 if(elementSelect.length>0){
	 	if(fm.all(elementSelect.name).value != fm.all(elementSelect.name).title){
		 	 var nameSelect = elementSelect[0].name;
	         var valueSelect = fm.all(elementSelect[0].name).value;
	         var textSelect = elementSelect[0].options[elementSelect[0].selectedIndex].text;
		     var parent= $(fm.all(elementSelect[0].name)).parent();
	         parent.children().remove();
	         parent.html("<input type='hidden' name='"+nameSelect+"' value='"+valueSelect+"'><a style='color:red' href='###' onclick='queryHistory(\""+nameSelect+"\",\""+registNo+"\")'>"+textSelect+"</a>");
		 }
	 }
	 j--;
  }
  
}

function queryHistory(name,registNo){
	var linkURL = "/claim/common/payment/queryHistoryShow.jsp?name="+name+"&registNo="+registNo;
	window.showModalDialog(linkURL,window,"dialogWidth=600px;dialogHeight=300px");
}
/**
* 主动撤回
*/
function revoke(){
	if(confirm("确认撤回任务？")){
		var registNo= document.getElementById("registNo").value;
		if(registNo==null||registNo==""){
			registNo= $("input[name='registNoPay']").val();
		}
		var paymentNo = $("input[name='paymentNo']").val();
		$.ajax({
			url:'/claim/paymainRevoke.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:{'paymentNo':paymentNo,'registNo':registNo}
			,success:function(data){
				if(data=="true"){
					alert('撤回成功！');
					//$(obj).parent().parent().remove();
					//getIndex();
					//window.location.reload(); 
					goBack();
				}else{
					alert('撤回失败！');
				}
			}
			,error:function(){alert('发生错误');}
		});	
	}
	
}
/**
 * “领款人类型”和“赔款类型”的规则校验
 * 
 */
function checkReceiverAndPaymentType(){
	var receiverType = $("select[name='receiverTypeOther'] option[selected]").val();//领款人类型
	var receiverTypeName = $("select[name='receiverTypeOther'] option[selected]").text();//领款人名称
	//alert("领款人类型:"+receiverType+"   领款人名称:"+receiverTypeName);
	var checkFlag = false;
	var flags = document.getElementsByName("flag");
	//alert("个数=="+flags.length);
	$("input[name='flag']").each(function(){
		//alert("是否选中："+this.checked);
		if(this.checked){
			var payrefreason = $(this).parent().parent().find("input[name='payrefreason']").val();//支付类型
			var payrefreasonName = $(this).parent().parent().find("input[name='payrefreasonChinesName']").val();//支付类型名称
			if("P60"==payrefreason||"P50"==payrefreason){//赔款
				if(receiverType=="t04"||receiverType=="t11"||receiverType=="t06"||receiverType=="t08"||receiverType=="t10"
						||receiverType=="t09"||receiverType=="t18"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}else if ("P61"==payrefreason||"Y61"==payrefreason){//检验费/预付检验费
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t07"||receiverType=="t04"||receiverType=="t18"
						||receiverType=="t11"||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"||receiverType=="t09"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}else if ("P62"==payrefreason||"Y62"==payrefreason){//机构查勘费/预付机构查勘费
				if(receiverType=="t01"||receiverType=="t02"||receiverType=="t03"||receiverType=="t05"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t12"||receiverType=="t13"||receiverType=="t14"||receiverType=="t15"||receiverType=="t16"
						||receiverType=="t17"||receiverType=="t18"||receiverType=="t19"||receiverType=="t20"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}else if ("P611"==payrefreason||"Y611"==payrefreason){//仲裁费/预付仲裁费
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t05"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}else if ("P612"==payrefreason||"Y612"==payrefreason){//执行费/预付执行费
				if(receiverType=="t01"||receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t14"||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"||receiverType=="t18"||receiverType=="t19"||receiverType=="t20"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}else if ("P64"==payrefreason||"Y64"==payrefreason){//诉讼费/预付诉讼费
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t06"||receiverType=="t07"
						||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"||receiverType=="t11"||receiverType=="t15"
						||receiverType=="t16"||receiverType=="t17"||receiverType=="t18"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}
			/**
			else if ("P65"==payrefreason||"Y65"==payrefreason){//内部代查勘费/预付内部代查勘费
				if(receiverType=="t04"||receiverType=="t11"||receiverType=="t06"||receiverType=="t08"||receiverType=="t10"||receiverType=="t09"){
					alert("领款人为"+receiverTypeName+"时,不允许合并"+payrefreasonName);
					checkFlag=true;
				}
			}*/
			else if ("P67"==payrefreason||"Y67"==payrefreason){//外部代查勘费/预付外部代查勘费
				if(receiverType=="t01"||receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t05"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t10"||receiverType=="t11"
						||receiverType=="t12"||receiverType=="t13"||receiverType=="t14"||receiverType=="t15"||receiverType=="t16"
						||receiverType=="t17"||receiverType=="t18"||receiverType=="t19"||receiverType=="t20"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}else if ("P68"==payrefreason||"Y68"==payrefreason){//律师费/预付律师费
				if(receiverType=="t02"||receiverType=="t03"||receiverType=="t04"||receiverType=="t06"
						||receiverType=="t07"||receiverType=="t08"||receiverType=="t09"||receiverType=="t10"
						||receiverType=="t15"||receiverType=="t16"||receiverType=="t17"||receiverType=="t18"){
					alert("领款人为“"+receiverTypeName+"”时,不允许支付“"+payrefreasonName+"”");
					checkFlag=true;
				}
			}
			if(checkFlag){
				return false;
			}
		}
	});
	//alert(checkFlag);
	if(checkFlag){
		return false;
	}else{
		return true;
	}
}

function SynchAccount(){
    var registNoPays = getElementCount("registNoPay");
    var string = '';
    if(registNoPays == 1){
    	string = '&registNo='+fm.registNoPay.value;
    }else if(registNoPays >1){
    	for(var i = 0;i<registNoPays;i++){
    		if(i==0){
    			string ='&registNo='+fm.registNoPay[i].value;
    		}else{
    			string +=','+fm.registNoPay[i].value;
    		}
    	}
    	
    }
	    var strURL ="/claim/syncyAccount.do?"+string;
	var returnValue = window.showModalDialog(strURL,window,"dialogWidth=720px;dialogHeight=300px");
	if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
		$("input[name='bankAccount']").val(returnValue[1]);
		$("input[name='bankAccount2']").val(returnValue[1]);
		$("input[name='bank']").val(returnValue[2]);
		$("input[name='bank1']").val(returnValue[2]);
		
	}
}
</script>
<head>
	<title>支付信息详细</title>
</head>
<body class="interface"  onload="getPayTotalAmount();<c:if test="${editType eq 'SHOW'}">readonlyAllInput();readonlyAllCheckbox();</c:if>" >
	<form name="fm" action="/claim/payGetherSave.do" method="post" onsubmit="return validateForm(this);">
		<input type="hidden" name="editType" id="editType" value="${editType }" />
		<input type="hidden" name="nodeType" id="nodeType" value="${nodeType }" />
		<input type="hidden" name="registNo" id="registNo" value="${registNo }" />
		<!-- 通知单号 add by zhongfen -->
		<input type="hidden" name="noticeNo" id="noticeNo" value="${noticeNo }" />
		<input type="hidden" name="submitType" id="submitType" value="0" />
		<input type="hidden" name="Datatype" id="Datatype" value="${Datatype }" />
		<input type="hidden" name="prevPageUrl" id="prevPageUrl"  value="${prevPageUrl}">
		<input type="hidden" name="pageConditions" id="pageConditions"  value="${pageConditions}">
		<%--//判断标志，当从预赔理算环节进入支付信息页面，无需判断费用是否核赔通过 --%>
		<input type="hidden" name="isBtn" id="isBtn" value="${isBtn }" />
		<c:if test="${not empty compensateNos }">
		<c:forEach items="${compensateNos }" var="compensateNo">
			<input type="hidden" name="compensateNo" id="compensateNo" value="${compensateNo }" />
		</c:forEach>
		</c:if>
		<!-- add by xia begin 问题记录增加处理人 -->
		<input type="hidden" name="handleComCode"  value="${user.comCode }">
		<input type="hidden" name="handlerCode" value="${user.userCode}">
		<input type="hidden" name="handlerName" value="${user.userName}">
		<!-- add by xia end 问题记录增加处理人 -->
		<!--基本信息中已经有收付编号了<input type="hidden" name="paymentNo" id="paymentNo" value="${prpLpaymainDto.paymentNo }" />-->
		<input type="hidden" name="vflag" id="vflag" value="${prpLpaymainDto.vflag }" /> 
		<input type="hidden" name="insuredCode" id="insuredCode" value="${insuredCode }" />
		<input type="hidden" name="insuredName" id="insuredName" value="${insuredName }" />
		<input type="hidden" name="bbxrInsuredType" id="bbxrInsuredType" value="${bbxrInsuredType }" />
		<input type="hidden" name="billFlag" value="1">
		<input type="hidden" name="type" value="${type }">
		<input type="hidden" name="back" value="${back }">
		<c:set var="prpLpayGatherDto" value="${prpLpaymainDto }"></c:set>
		<div class="outcontainer" id="payGetherMain">
			<%-- 基本信息 --%>
	       	<%@include file="/common/payment/DAAPayBaseInfo.jsp" %>
	       	<%-- 账户信息 --%>
	       	<%@include file="/common/payment/DAAPayAccountInfo.jsp" %>
	       	<!-- 领款人信息 -->	
		    <%@include file="/common/payment/DAAPayReceiverInfo.jsp"%>
		    <%-- 赔付信息 --%>
	       	<%@include file="/common/payment/DAAPayMainInfo.jsp" %>
		    <%-- 处理意见 --%>
	       	<%@include file="/common/payment/DAAPayRegistExt.jsp" %>
		 </div>
		 <c:if test="${from ne 'undwrt' }">
		 <c:if test="${editType ne 'SHOW' }">
		 <c:if test="${isBtn eq 'true' }">
    	 <div id=content_basic style="width: 98%">
	        <table align="center" id="buttonTable">
	        	<tr>
	        		<td> 
						<input type="button" id="saveButton" name="saveButton" class="bobu"  value="保存" onclick="saveForm();">
	        		</td>
	        		<td> 
						<input type="button" id="closeButton" name="closeButton" class="bobu"  value="关闭" onclick="javascript:window.close();">
	        		</td>
	        	</tr>
	        </table>
         </div>
         </c:if>
         <c:if test="${isBtn ne 'true' }">
         <div id=content_basic style="width: 98%">
	         <table align="center" id="buttonTable">
		        	<tr>
		        		
		        		<td> 
							<input type="button" id="saveButton" name="saveButton" class="button"  value="保存" onclick="saveForm('2');">
		        		</td>
		        		<td> 
							<input type="button" id="submitButton" name="submitButton" class="button"  value="提交" onclick="saveForm('4');">
		        		</td>
		        		<td> 
							<input type="button" id="closeButton" name="closeButton" class="button"  value="关闭" onclick="goBack();">
		        		</td>
		        		<td> 
							<input type="button" id="removeButton" name="removeButton" class="button"  value="删除" onclick="remove();">
		        		</td>
		        		<td> 
		        		<c:if test="${prpLpaymainDto.payFlag eq '1' }">
							<input type="button" id="printButton" name="printButton" class="button"  value="付款通知书" onclick="print();">
		        		</c:if>
		        		</td>
		        	</tr>
		        </table>
	        </div>
         </c:if>
         </c:if>
         <c:if test="${editType eq 'SHOW' }">
         <div id=content_basic style="width: 98%">
	        <table align="center" id="buttonTable">
	        	<tr>
	        		<td> 
						<input type="button" id="closeButton" name="backButton" class="button"  value="返回" onclick="goBack();">
	        		</td>
		        	<c:if test="${prpLpaymainDto.payFlag eq '1' }">
	        			<td> 
							<input type="button" id="printButton" name="printButton" class="button"  value="付款通知书" onclick="print();">
		        		</td>
		        	</c:if>
		        	<c:if test="${(prpLpaymainDto.payFlag ne '1' )and( prpLpaymainDto.vflag eq '6')  }">
			        	<td> 
							<input type="hidden" id="revokeButton" name="saveButton" class="button"  value="撤回" onclick="revoke();">
		        		</td>
		        	</c:if>
	        	</tr>
	        </table>
         </div>
         </c:if>
         </c:if>
	</form>
</body>
<c:if test="${from eq 'undwrt' }">

<script type="text/javascript">

</script>
</c:if>