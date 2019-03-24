<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	/**
	* 领款人类型更改联动方法
	*
	*/
	function changeReceiver(obj){
		var receiverVal = $(obj).find("option[selected]").val();
		if(receiverVal!=""){
			if(receiverVal=="t01"){//被保险人自动带出
				var bbxrType = $("#bbxrInsuredType").val();
				if(bbxrType!=null&&bbxrType=="1"){//个人
					$("input[name='accountType'][value='1']").removeAttr("disabled");
					$("input[name='accountType'][value='1']").attr("checked","checked");
					$("input[name='accountType'][value='2']").attr("disabled","disabled");
					$("#accountFlag0").css("display","");
					$("#accountFlag1").css("display","none");
					$("input:radio[name=accountFlag][value='03']").attr('checked','');
				}else if (bbxrType=="2"){//单位
					$("input[name='accountType'][value='2']").removeAttr("disabled");
					$("input[name='accountType'][value='2']").attr("checked","checked");
					$("input[name='accountType'][value='1']").attr("disabled","disabled");
					$("#accountFlag0").css("display","none");
					$("#accountFlag1").css("display","");
					$("input:radio[name=accountFlag][value='00']").attr('checked','');
					$("input:radio[name=accountFlag][value='01']").attr('checked','');
					$("input:radio[name=accountFlag][value='02']").attr('checked','');
				}
				var insuredName = $("#insuredName").val();
				var insuredCode = $("#insuredCode").val();
				$("#receiverFullName").val(insuredName);
				$("#receiverFullCode").val(insuredCode);
				$("#receiverTypeOthers").attr("readOnly","readOnly");
				$("#receiverTypeOthers").css("display","none");
				$("#receiverTypeOthersBtn").css("display","");
				$("#receiverTypeOthers").val("");
				$("#receiverTypeOtherName").val("被保险人");
				$("#receiverFullName").attr("readOnly","readOnly");
			}else if(receiverVal=="t12" || receiverVal=="t13" ){
				$("#receiverFullCode").val("");
				$("#receiverTypeOthers").removeAttr("readOnly");
				$("#receiverFullName").removeAttr("readOnly");
				$("#receiverTypeOthers").css("display","");
				$("#receiverTypeOthersBtn").css("display","none");
				$("#receiverTypeOtherName").val("");
				$("#receiverFullName").val("");
				if(receiverVal=="t12"){
					$("input[name='accountType'][value='1']").removeAttr("disabled");
					$("input[name='accountType'][value='1']").attr("checked","checked");
					$("input[name='accountType'][value='2']").attr("disabled","disabled");
					$("#accountFlag0").css("display","");
					$("#accountFlag1").css("display","none");
					$("input:radio[name=accountFlag][value='03']").attr('checked','');
				}else{
					$("input[name='accountType'][value='2']").removeAttr("disabled");
					$("input[name='accountType'][value='2']").attr("checked","checked");
					$("input[name='accountType'][value='1']").attr("disabled","disabled");
					$("#accountFlag0").css("display","none");
					$("#accountFlag1").css("display","");
					$("input:radio[name=accountFlag][value='00']").attr('checked','');
					$("input:radio[name=accountFlag][value='01']").attr('checked','');
					$("input:radio[name=accountFlag][value='02']").attr('checked','');
				}
			}else{
				$("#receiverFullCode").val("");
				$("#receiverTypeOthers").attr("readOnly","readOnly");
				$("#receiverFullName").removeAttr("readOnly");
				$("#receiverTypeOthers").css("display","none");
				$("#receiverTypeOthersBtn").css("display","");
				$("#receiverTypeOthers").val("");
				$("#receiverFullName").val("");
				if(receiverVal!="t14"&&receiverVal!="t19"&&receiverVal!="t20"){
					$("input[name='accountType'][value='2']").removeAttr("disabled");
					$("input[name='accountType'][value='2']").attr("checked","checked");
					$("input[name='accountType'][value='1']").attr("disabled","disabled");
					$("#accountFlag0").css("display","none");
					$("#accountFlag1").css("display","");
					$("input:radio[name=accountFlag][value='00']").attr('checked','');
					$("input:radio[name=accountFlag][value='01']").attr('checked','');
					$("input:radio[name=accountFlag][value='02']").attr('checked','');
				}else{
					$("input[name='accountType'][value='1']").removeAttr("disabled");
					$("input[name='accountType'][value='2']").removeAttr("disabled");
					$("input[name='accountType'][value='1']").removeAttr("checked");
					$("input[name='accountType'][value='2']").removeAttr("checked");
				}
				if(receiverVal=="t02"){
					$("#receiverTypeOtherName").val("查勘直赔中心");
				}else if(receiverVal=="t03"){
					$("#receiverTypeOtherName").val("玻璃更换单位");
				}else if(receiverVal=="t04"){
					$("#receiverTypeOtherName").val("查勘人员");
					$("input[name='accountType'][value='1']").removeAttr("disabled");
					$("input[name='accountType'][value='1']").attr("checked","checked");
					$("input[name='accountType'][value='2']").attr("disabled","disabled");
					$("#accountFlag0").css("display","");
					$("#accountFlag1").css("display","none");
					$("input:radio[name=accountFlag][value='03']").attr('checked','');
				}else if(receiverVal=="t05"){
					$("#receiverTypeOtherName").val("人民法院");
				}else if(receiverVal=="t06"){
					$("#receiverTypeOtherName").val("公估机构");
				}else if(receiverVal=="t07"){
					$("#receiverTypeOtherName").val("配件维修单位");
				}else if(receiverVal=="t08"){
					$("#receiverTypeOtherName").val("调查机构");
				}else if(receiverVal=="t09"){
					$("#receiverTypeOtherName").val("救援机构");
				}else if(receiverVal=="t10"){
					$("#receiverTypeOtherName").val("鉴定机构");
				}else if(receiverVal=="t11"){
					$("#receiverTypeOtherName").val("律师部门");
				}else if(receiverVal=="t14"){
					$("#receiverTypeOtherName").val("受害人员");
				}else if(receiverVal=="t15"){
					$("#receiverTypeOtherName").val("救治医院");
				}else if(receiverVal=="t16"){
					$("#receiverTypeOtherName").val("民政部门");
				}else if(receiverVal=="t17"){
					$("#receiverTypeOtherName").val("交警部门");
				}else if(receiverVal=="t18"){
					$("#receiverTypeOtherName").val("仲裁机构");
				}else if(receiverVal=="t19"){
					$("#receiverTypeOtherName").val("监护人");
				}else if(receiverVal=="t20"){
					$("#receiverTypeOtherName").val("委托代理人");
				}
			}
			$("#receiverTypeOthers").attr("class","input");
			
		}else{
			$("input[name='accountType'][value='1']").removeAttr("disabled");
			$("input[name='accountType'][value='2']").removeAttr("disabled");
			$("input[name='accountType'][value='1']").removeAttr("checked");
			$("input[name='accountType'][value='2']").removeAttr("checked");
		}
	}
	/**
	* 验证页面要素的必录项
	*
	*/
    function checkBaseInput(){
       //第三方支付调整赔款支付信息，支付金额为负数或零时，只需录入支付对象即可
       var payAmount = $("input[name='payAmount']").val();
       if(parseFloat(payAmount)<=0){
       		var receiverFullName = $("#receiverFullName").val();
	    	if(typeof(receiverFullName) == "undefined"||receiverFullName==""||receiverFullName.trim()==""){
	    		alert("领款人名称不能为空");
	    		return false;
	    	}
       }else{
	       var payType = $("input[name='payType']").val();
	    	if(typeof(payType) == "undefined"||payType==""){
	    		alert("支付类型不能为空");
	    		return false;
	    	}
	    	var receiverTypeOther = $("select[name='receiverTypeOther'] option[selected]").val();
	    	if(typeof(receiverTypeOther) == "undefined"||receiverTypeOther==""){
	    		alert("领款人类型不能为空");
	    		return false;
	    	}
	    	var receiverFullName = $("#receiverFullName").val();
	    	if(typeof(receiverFullName) == "undefined"||receiverFullName==""||receiverFullName.trim()==""){
	    		alert("领款人名称不能为空");
	    		return false;
	    	}
	    	var receiverVal = $("select[name='receiverTypeOther'] option[selected]").val();
	    	if(receiverVal!='t05' && receiverVal!='t15'&& receiverVal!='t16'&& receiverVal!='t17'){
		    	var certifType = $("select[name='certifType'] option[selected]").val();
		    	if(typeof(certifType) == "undefined"||certifType==""||certifType=="00"){
		    		alert("领款人证件类型不能为空");
		    		return false;
		    	}
		    	var certifNo =  $("#certifNo").val();
		    	if(typeof(certifNo) == "undefined"||certifNo==""||certifNo.trim()==""){
		    		alert("领款人证件号码不能为空");
		    		return false;
		    	}
	    	}
	    	if(receiverVal=='t12' || receiverVal=='t13'){
		    	var receiverTypeOtherName = $("#receiverTypeOtherName").val();
		    	if(typeof(receiverTypeOtherName) == "undefined"||receiverTypeOtherName==""||receiverTypeOtherName.trim()==""){
		    		alert("当领款人类型为‘其他’时，领款人类型录入框不能为空");
		    		return false;
		    	}
	    	}
       		//相同被保险人代码的，可以选择被保险人
	    	//if(receiverVal=='t01'){
	    	//	var insuredName = $("#receiverFullName").val();
	    	//	var sameInsuredFlag = true;
	    	//	$("input[type=checkbox][name='flag'][checked]").each(function(){
	    	//		if($(this).attr("checked")){
	    	//			var insuredNamePay = $(this).parent().parent().find("input[name='insuredNamePay']").val();
	    	//			if(insuredNamePay.trim()!=insuredName.trim()){
	    	//				sameInsuredFlag = false;
	    	//				return false;
	    	//			}
	    	//		}
	    	//	});
	    	//	if(!sameInsuredFlag){
	    	//		alert("只有合并的案件为同一被保险人的，才允许选择“被保险人”");
	    	//		return false;
	    	//	}
	    	//}
       }
       
       
    	
    	return true;
    }
	/**
	* 设置领款人类型为其他时的领款人类型名
	*/
	function setValue(obj){
		var receiverTypeOthers = $(obj).val();
		$("#receiverTypeOtherName").val(receiverTypeOthers);
	}
	function setFun(feild){
		var receiverTypeOthers = document.getElementsByName("receiverTypeOthers");
		if(feild.value == "t02"||feild.value == "t03"||feild.value == "t07"||feild.value =="t05"||feild.value =="t06"||feild.value =="t08"||feild.value =="t09"||feild.value =="t10"||feild.value =="t11"){
			$("#receiverTypeOthersBtn").unbind("click");
			//$("#receiverTypeOthersBtn").attr("class","codecode");
			$("#receiverTypeOthersBtn").removeAttr("disabled");
			$("#receiverTypeOthersBtn").bind("click",function(){accountData(feild.value);},0);
			//选择“公估机构、律师机构、调查机构、修理厂方、鉴定机构、救援机构”等合作机构，账号信息带入，且不可修改。
			//$("input[name='bankType']").attr("readOnly","readOnly");
			//$("input[name='bank']").attr("readOnly","readOnly");
			//$("input[name='bankAccount']").attr("readOnly","readOnly");
			//$("input[name='bankType']").attr("readOnly","readOnly");
			$("input[name='bankType']").removeAttr("readOnly");
			$("input[name='bank']").removeAttr("readOnly");
			$("input[name='bankAccount']").removeAttr("readOnly");
			$("input[name='receiverFullName']").removeAttr("readOnly");
			$("input[name='certifNo']").removeAttr("readOnly");//证件号码
			$("select[name='certifType']").unbind("blur");
			
		}else if(feild.value == "t01"){//被保险人
			$("#receiverTypeOthersBtn").attr("disabled","disabled");
			$("#receiverTypeOthersBtn").unbind("click");
		}else{
			$("#receiverTypeOthersBtn").attr("disabled","disabled");
			$("#receiverTypeOthersBtn").unbind("click");
			$("input[name='bankType']").removeAttr("readOnly");
			$("input[name='bank']").removeAttr("readOnly");
			$("input[name='bankAccount']").removeAttr("readOnly");
			$("input[name='receiverFullName']").removeAttr("readOnly");
			$("input[name='certifNo']").removeAttr("readOnly");//证件号码
			$("select[name='certifType']").unbind("blur");
			
		}
	}
 function accountData(receiverTypeOther){
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
 	    var strURL ="/claim/receveAccount.do?receiverTypeOther="+receiverTypeOther+string;
		var returnValue = window.showModalDialog(strURL,window,"dialogWidth=720px;dialogHeight=300px");
		if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
			$("input[name='receiverFullName']").val(returnValue[1]);
			$("select[name='certifType']").val("73");
			$("input[name='certifNo']").val(returnValue[2]);
			$("input[name='provinceCode']").val(returnValue[3]);
			$("input[name='cityCode']").val(returnValue[4]);
			if(returnValue[5]=="1"){
				$("input[name='accountType'][value='1']").attr("checked","checked");
				$("#accountFlag0").css("display","");
				$("#accountFlag1").css("display","none");
				$("input:radio[name=accountFlag][value='03']").attr('checked','');
			}else if(returnValue[5]=="2"){
				$("input[name='accountType'][value='2']").attr("checked","checked");
				$("#accountFlag0").css("display","none");
				$("#accountFlag1").css("display","");
				$("input:radio[name=accountFlag][value='00']").attr('checked','');
				$("input:radio[name=accountFlag][value='01']").attr('checked','');
				$("input:radio[name=accountFlag][value='02']").attr('checked','');
			}
			$("input[name='bankType']").val(returnValue[6]);
			$("input[name='bank']").val(returnValue[7]);
			$("input[name='bankAccount']").val(returnValue[8]);
			$("input[name='bankAccount2']").val(returnValue[8]);
			$("input[name='mobilePhone']").val(returnValue[9]);
			$("input[name='address']").val(returnValue[10]);
			$("input[name='receiverFullCode']").val(returnValue[11]);
			$("input[name='bankType']").attr("readOnly","readOnly");
			$("input[name='bank']").attr("readOnly","readOnly");
			$("input[name='bankAccount']").attr("readOnly","readOnly");
			$("input[name='receiverFullName']").attr("readOnly","readOnly");
			
			$("input[name='certifNo']").attr("readOnly","readOnly");//证件号码
			$("select[name='certifType']").bind("blur",function(){$("select[name='certifType']").val("73");},0);//证件类型
			
		}
	}
	
	//校验恐怖分子
	function checkTerrorist(){

		var AppliInsuredInsuredName=fm.receiverFullName.value;

		var AppliInsuredIdentifyNumber = fm.certifNo.value;
	  	  var vURL = "/claim/uiCheckTerrorist.do?AppliInsuredInsuredName="+AppliInsuredInsuredName+"&AppliInsuredIdentifyNumber="+AppliInsuredIdentifyNumber;
	  	  var xmlText = getResponseText(vURL);
         if(xmlText!=null && "1"==xmlText) {
        	alert("该客户可能为恐怖分子，请确认！");
        	return false;
        	}
        	return true;
	}
	//使用xmlhttp访问页面，并获取数据
function getResponseText(strURL)
{
  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  objXmlHttp.Open("POST",strURL,false);
  objXmlHttp.setRequestHeader("Content-type","text/xml");
  objXmlHttp.Send("");
  if(objXmlHttp.status==200)
  {
    return objXmlHttp.responseText;
  }
  else if(objXmlHttp.status==404)
  {
    alert("找不到页面："+ strURL);
    return "";
  }
  else
  {
    alert("访问"+ strURL +"出错，错误号："+objXmlHttp.status);
    return "";
  }
}
	function getPayeeInfo(){
	//debugger;
	    var curTime = new Date().getTime();
	    var receiverFullName = fm.receiverFullName.value;
	    var newAgriFlag = fm.newAgriFlag.value;
	    var strURL ="/claim/getPayeeInfo.do?receiverFullName="+receiverFullName+"&newAgriFlag="+newAgriFlag+"&"+curTime;
	    var returnValue = window.showModalDialog(strURL,window,"dialogWidth=1080px;dialogHeight=600px");
		if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
			$("input[name='receiverFullName']").val(returnValue[1]);
			$("select[name='receiverTypeOther']").val(returnValue[2]);
			$("input[name='certifNo']").val(returnValue[4]);
			$("select[name='certifType']").val(returnValue[5]);
			$("input[name='bank1']").val(returnValue[6]);
			$("input[name='bankAccount']").val(returnValue[7]);
			$("input[name='bankAccount2']").val(returnValue[7]);
			$("input[name='bankType']").val(returnValue[8]);
			if(returnValue[10]=="1"){//账号属性 1个人 2单位
				$("input[name='accountType'][value='1']").attr("checked","checked");
				$("#accountFlag0").css("display","");
				$("#accountFlag1").css("display","none");
				$("input:radio[name=accountFlag][value='03']").attr('checked','');
				if(returnValue[9]=="00"){//账号类型 00银行卡 01存折 02信用卡 03对公账户
					$("input:radio[name=accountFlag][value='00']").attr("checked","checked");
				}
				if(returnValue[9]=="01"){
					$("input:radio[name=accountFlag][value='01']").attr("checked","checked");
				}
				if(returnValue[9]=="02"){
					$("input:radio[name=accountFlag][value='02']").attr("checked","checked");
				}
			}else if(returnValue[10]=="2"){
				$("input[name='accountType'][value='2']").attr("checked","checked");
				$("#accountFlag0").css("display","none");
				$("#accountFlag1").css("display","");
				$("input:radio[name=accountFlag][value='00']").attr('checked','');
				$("input:radio[name=accountFlag][value='01']").attr('checked','');
				$("input:radio[name=accountFlag][value='02']").attr('checked','');
				if(returnValue[9]=="03"){
					$("input:radio[name=accountFlag][value='03']").attr("checked","checked");
				}
			}
			$("input[name='routeNum']").val(returnValue[11]);
			$("input[name='cityCode']").val(returnValue[12]);
			$("input[name='provinceCode']").val(returnValue[13]);
			$("input[name='mobilePhone']").val(returnValue[14]);
			
		}
	}
	
	
</script>
<div id="content_basic" style="width: 98%" name="baseInfoDiv" align="center">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,baseInfo)">&nbsp;基本信息
	</span>
	<table class="common" id="baseInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<td class="title" width="13%">
				收付编号
			</td>
			<td class="input" width="20%">
				<input type="text" style="width: 99%" readOnly class="readOnly" name="paymentNo" value="${prpLpayGatherDto.paymentNo }" />
				<input type="hidden" name="payType" value="${prpLpayGatherDto.payType}">
			</td>
<!--  
			<td class="title" width="13%">支付类型<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<select class="query" name="payType"<c:if test="${nodeType ne 'check' and nodeType ne 'certa' and nodeType ne 'CertifDirect' }">  onchange="changeValueReload();"</c:if> >
					<option <c:if test="${prpLpayGatherDto.payType eq 'P1' }">selected</c:if> value="P1">预付赔款</option>
				    <option <c:if test="${prpLpayGatherDto.payType eq 'P2' }">selected</c:if> value="P2">支付赔款</option>
    				<option <c:if test="${(prpLpayGatherDto.payType eq 'P3') or (prpLpayGatherDto.payType eq '') }">selected</c:if> value="P3" >结案赔付</option>
				    <option <c:if test="${prpLpayGatherDto.payType eq 'P4' }">selected</c:if> value="P4">垫付赔款</option>
				</select>
			</td>-->
			<td class="title" width="13%">
				领款人类型<span style="color:red;">*</span>
			</td>
			<td class="input" width="10%">
				<input type="hidden" id="receiverTypeOtherName" name="receiverTypeOtherName" value="${prpLpayGatherDto.receiverTypeOtherName}"  maxlength="100" onblur="return checkMaxlength(this);" />
				<select class="query" name="receiverTypeOther" onchange="changeReceiver(this);setFun(this)" >
					<option value="">请选择</option>
					<!-- add by wangxinyang 新农险区分领款人类型 2018-8-8 19:56:20 -->
<%
		String newAgriFlag = (String)request.getAttribute("newAgriFlag");
		if(newAgriFlag!=null && "newAgri".equals(newAgriFlag)){
 %>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't01' }">selected</c:if> value="t01">投保人</option>
					<c:if test="${(Datatype ne 'mergeMany') or (hasbbxrSelect eq 'true') }">
						<option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't02' }">selected</c:if> value="t02">被保险人</option>
					</c:if>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't03' }">selected</c:if> value="t03">受益人</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't04' }">selected</c:if> value="t04">其他个人</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't05' }">selected</c:if> value="t05">其他单位</option>
<%
		}else{
 %>
					<c:if test="${(Datatype ne 'mergeMany') or (hasbbxrSelect eq 'true') }">
						<option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't01' }">selected</c:if> value="t01">被保险人</option>
					</c:if>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't14' }">selected</c:if> value="t14">受害人员</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't02' }">selected</c:if> value="t02">查勘直赔中心</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't03' }">selected</c:if> value="t03">玻璃更换单位</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't07' }">selected</c:if> value="t07">配件维修单位</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't04' }">selected</c:if> value="t04">查勘人员</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't05' }">selected</c:if> value="t05">人民法院</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't18' }">selected</c:if> value="t18">仲裁机构</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't11' }">selected</c:if> value="t11">律师部门</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't06' }">selected</c:if> value="t06">公估机构</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't08' }">selected</c:if> value="t08">调查机构</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't09' }">selected</c:if> value="t09">救援机构</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't10' }">selected</c:if> value="t10">鉴定机构</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't15' }">selected</c:if> value="t15">救治医院</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't16' }">selected</c:if> value="t16">民政部门</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't17' }">selected</c:if> value="t17">交警部门</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't19' }">selected</c:if> value="t19">监护人</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't20' }">selected</c:if> value="t20">委托代理人</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't12' }">selected</c:if> value="t12">其他个人</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't13' }">selected</c:if> value="t13">其他单位</option>
<%
		}
 %>
				</select>
			</td>
			<td class="input" width="10%" colspan="1">
				<c:if test="${prpLpayGatherDto.receiverTypeOther eq 't12' or prpLpayGatherDto.receiverTypeOther eq 't13'}">
					<input type="text" style="width: 99%;"  class="input" id="receiverTypeOthers" name="receiverTypeOthers" onblur="checkMaxlength(this);setValue(this);" value="${prpLpayGatherDto.receiverTypeOtherName }"   maxlength="100"/>
					<input type="button" class="button" style="display: none;"  id="receiverTypeOthersBtn" value="机构列表" onclick="";/>
				</c:if>
				<c:if test="${prpLpayGatherDto.receiverTypeOther ne 't12' and prpLpayGatherDto.receiverTypeOther ne 't13'}">
					<input type="text" style="width: 99%;display: none;"  class="input" id="receiverTypeOthers" name="receiverTypeOthers" onblur="checkMaxlength(this);setValue(this);" readOnly value=""    maxlength="100"/>
					<input type="button"  class="button" style="" id="receiverTypeOthersBtn" value="机构列表" />
				</c:if>
			</td>
			<td class="title">
				领款人名称<span style="color:red;">*</span>
			</td>
			<td class="input">
				<input type="text" class="input" style="width: 55%" id="receiverFullName" name="receiverFullName" value="${prpLpayGatherDto.receiverFullName}" maxlength="100" onblur="return checkMaxlength(this);"/>
				<c:if test="${editType eq 'SHOW' }">
					<input type="button"  class="button"  id="payeeInfo" name="payeeInfo" value="领款人信息" onclick="";/>
				</c:if>
				<c:if test="${editType ne 'SHOW' }">
					<input type="button"  class="button"  id="payeeInfo" name="payeeInfo" value="领款人信息" onclick="getPayeeInfo()";/>
				</c:if>
				<input type="hidden" name="newAgriFlag" value="<%=newAgriFlag %>">
				<input type="hidden" id="receiverFullCode" name="receiverFullCode" value="${prpLpayGatherDto.receiverFullCode}"/>
			</td>
		</tr>
		<tr>
			
			<td class="title" width="13%">领款人证件类型<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<select class="query" name="certifType" style="width: 99%">
					<option <c:if test="${prpLpayGatherDto.certifType eq '00' }">selected</c:if> value="00">请选择</option>
					<option <c:if test="${prpLpayGatherDto.certifType eq '01' }">selected</c:if> value="01">居民身份证</option>
				    <option <c:if test="${prpLpayGatherDto.certifType eq '02' }">selected</c:if> value="02">居民户口薄</option>
				    <option <c:if test="${prpLpayGatherDto.certifType eq '04' }">selected</c:if> value="04">军官证</option>
				    <option <c:if test="${prpLpayGatherDto.certifType eq '05' }">selected</c:if> value="05">士兵证</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '07' }">selected</c:if> value="07">中国护照</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '51' }">selected</c:if> value="51">外国护照</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '71' }">selected</c:if> value="71">组织机构代码证</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '72' }">selected</c:if> value="72">税务登记证</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '73' }">selected</c:if> value="73">营业执照</option>
				</select>
			</td>
			<td class="title" width="13%">证件号码<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%" colspan="2">
				<input type="text" class="input" style="width: 99%" id="certifNo" name="certifNo" value="${prpLpayGatherDto.certifNo}" maxlength="20" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">紧急程度
			</td>
			<td class="input" width="20%">
				<select class="query" name="urgentType" style="width: 99%">
					<option value="">请选择</option>
					<option <c:if test="${prpLpayGatherDto.urgentType eq '0.5' }">selected</c:if> value="0.5">30分钟</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '1' }">selected</c:if> value="1">1小时</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '2' }">selected</c:if> value="2">2小时</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '3' }">selected</c:if> value="3">3小时</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '4' }">selected</c:if> value="4">4小时</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '8' }">selected</c:if> value="8">8小时</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '24' }">selected</c:if> value="24">24小时</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '48' }">selected</c:if> value="48">48小时</option>
				</select>
			</td>
		</tr>
	</table>
</div>
		