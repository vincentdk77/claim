<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="java.util.*" %>
<script type="text/javascript">
	/**
	*  支付合并函数
	*/
	function mergeFee(obj){
		
		var paymentType = $("select[name='paymentType'] option[selected]").val();
		var paymentNo = $("input[name='paymentNo']").val();
		if(paymentType=="undifined"||paymentType==""){
			alert("请先选择赔款类型");
		}
		var payTotalAmount=0;
		var hasPay=0;
		var payAmount=0;
		var k=0;
		$("input[name='flag']").each(function(){
			if($(this).is(":checked")){
				var mergeFlag = true;
				//当size>1时，将理算书号+赔款类型Ajax传递到后台，进行校验
				if(k>0){
					mergeFlag = false;
					var certiNo = $(this).parent().parent().find("input[name='certiNoPay']").val();
					mergeFlag = payMergeCheck(paymentType,certiNo,paymentNo);
				}
				//alert(mergeFlag);
				if(mergeFlag){
					var sumPaidStr = $(this).parent().parent().find("input[name='sumPaidPay']").val();
					var sumPaid=parseFloat(sumPaidStr);
					payTotalAmount+=sumPaid;
					var havPaidStr = $(this).parent().parent().find("input[name='havPaidPay']").val();
					var havPaid=parseFloat(havPaidStr);
					hasPay+=havPaid;
					var paidStr = $(this).parent().parent().find("input[name='paidPay']").val();
					var paid=parseFloat(paidStr);
					payAmount+=paid;
				}else{
					$(obj).removeAttr("checked");
				}
				k++;
			}
		});
		$("input[name='payTotalAmount']").val(payTotalAmount.toFixed(2));
		$("input[name='hasPay']").val(hasPay.toFixed(2));
		$("input[name='payAmount']").val(payAmount.toFixed(2));
		
	}
	/**
	*  将理算书号+赔款类型Ajax传递到后台，进行校验是否存在支付信息
	*/
	function payMergeCheck(paymentType,certiNo,paymentNo){
		var mergeFlag=false;
		$.ajax({
			url:'/claim/payMergeCheck.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,async:false
			,data:{'paymentNo':paymentNo,'paymentType':paymentType,'certiNo':certiNo}
			,success:function(data){
				if(data=="true"){
					//alert('验证通过！');
					mergeFlag=true;
				}else{
					alert('已存在支付信息，无法合并');
					mergeFlag=false;
				}
			}
			,error:function(){alert('发生错误');}
		});
		return mergeFlag;
	}
	
	//合并支付后将数据写入总支付金额及本次支付金额
	function getPayTotalAmount(){
		var payTotalAmount=0;
		var hasPay=0;
		var payAmount=0;
		var k=0;
		$("input[name='flag']").each(function(){
			if($(this).is(":checked")){
				var sumPaidStr = $(this).parent().parent().find("input[name='sumPaidPay']").val();
				var sumPaid=parseFloat(sumPaidStr);
				payTotalAmount+=sumPaid;
				var havPaidStr = $(this).parent().parent().find("input[name='havPaidPay']").val();
				var havPaid=parseFloat(havPaidStr);
				hasPay+=havPaid;
				var paidStr = $(this).parent().parent().find("input[name='paidPay']").val();
				var paid=parseFloat(paidStr);
				payAmount+=paid;
			}
			k++;
		});
		$("input[name='payTotalAmount']").val(payTotalAmount.toFixed(2));
		$("input[name='hasPay']").val(hasPay.toFixed(2));
		$("input[name='payAmount']").val(payAmount.toFixed(2));
	}
	//只能输入数字和小数点的文本框(包含负数)
	function clearNoNumF(obj)
	{
	 //先把非数字的都替换掉，除了数字和.-
	 obj.value = obj.value.replace(/[^\d.-]/g,"");
	 //必须保证第一个为数字或者-而不是.
	 obj.value = obj.value.replace(/^\./g,"");
	 //保证只有出现一个.而没有多个.
	 obj.value = obj.value.replace(/\.{2,}/g,".");
	//保证只有出现一个-而没有多个.
	 obj.value = obj.value.replace(/\-{2,}/g,"-");
	 //保证.只出现一次，而不能出现两次以上
	 obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	//保证-只出现一次，而不能出现两次以上
	 obj.value = obj.value.replace("-","$#$").replace(/\-/g,"").replace("$#$","-");
	 fireChangeComm(obj);
	}
	/**
	*验证输入的值不可高于设定的最大值
	*/
	function checkMaxVal(obj){
		//var thisVal = $(obj).val();
		var thisVal = obj.value;
		var maxVal = $(obj).parent().find("input[name='paidMaxValue']").val();
		if(null!=maxVal&&""!=maxVal){
			if(parseFloat(thisVal)>parseFloat(maxVal)){
				alert("最大值不可高于标准值："+maxVal);
				obj.value=maxVal;
			}
		}
		
	}
	/**
	*	赔付信息页面必录项及保存控制
	*/
	function checkMainInfo(){
		
		var paymentType = $("input[name='paymentType']").val();
    	if(typeof(paymentType) == "undefined"||paymentType==""){
    		alert("赔款类型不能为空");
    		return false;
    	}
    	var payAmount = $("input[name='payAmount']").val();
    	if(typeof(payAmount) == "undefined"||payAmount==""){
    		alert("本次支付金额不能为空");
    		return false;
    	}
    	if($("input[type=checkbox][name='flag'][checked]").length<1){
    		alert(" 必须在“赔付信息”的“操作”列至少勾选一条需支付的信息。");
    		return false;
    	}
    	var classCode = document.getElementsByName('classCode');
		var flag = document.getElementsByName('flag');
		var isTrue = false;
		for(var i=0;i<classCode.length;i++){
			var iClassCode=classCode[i];
	    	var iValue=iClassCode.value;
	    	if(flag[i].checked==true){
	    		for(var j=0;j<classCode.length;j++){
		    		var jClassCode=classCode[j];
		    		var jValue=jClassCode.value;
		    		if(flag[j].checked==true){
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
    	if(parseFloat(payAmount)==0){
    		var paidPayList = document.getElementsByName("paidPay");
    		var flag = document.getElementsByName("flag");
    		for(var i=0;i<flag.length;i++){
    		if(flag[i].checked){
	    		if(parseFloat(paidPayList[i].value)==0){
	    				alert("总支付金额为0时，必须为正负合并！");
	    				return false;
	    		}
    		}
    			
    		}
    		//alert("本次支付金额需大于0");
    		//return false;
    	}//第三方支付赔款支付信息调整
    	var paidPays = document.getElementsByName("paidPay");
    	var flags = document.getElementsByName("flag");
    	for(var i=0;i<flags.length;i++){
    		if(flags[i].checked){
	    		if(parseFloat(paidPays[i].value)<0&&parseFloat(payAmount)>0){
	    				alert("总支付金额大于0时，不允许合并项含有负数信息！");
	    				return false;
	    		}
    		}
    	}
    	$("input[name='paidPay']").each(function(){
    		checkMaxVal(this);
    	});
    	getPayTotalAmount();
    	return true;
	}
	//合并下发标志更改
	function mergeFlagClinck(obj){
		if($(obj).is(":checked")){
			//alert("选中");
			$("input[name='mergerFlag']").val("1");
		}else{
			//alert("取消");
			$("input[name='mergerFlag']").val("0");
		}
	}
	//删除行
	function removeRow(obj){
		$(obj).parent().parent().remove();
		//getIndex();
		getPayTotalAmount();
	}
	/**
     * 重新获得序号
     */
    function getIndex(){
    	$("span[name='serialno']").each(function(i,obj){
    		if($(obj).html()!=(i+1)){
    			$(obj).html(i+1);
    		}
    	});
    }
	function addRow(){
		var urlStr ="";
		var nodeType=fm.nodeType.value;
		var paymentNo = fm.paymentNo.value;
		urlStr="nodeType="+nodeType;
		var payType=$("input[name='payType']").val();
		//var paymentType=$("select[name='paymentType'] option[selected]").val();
		
		urlStr +="&payType="+payType;//+"&paymentType="+paymentType;
		var url = "/claim/paymainMergeAddBefor.do?"+urlStr;
		var returnValue = window.showModalDialog(url,window,"dialogWidth=860px;dialogHeight=450px");
		if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
			var loopSize  = (returnValue.length-1)/15 ;//看返回了几个对象（即选中了几个号码）
			
			for(var ls = 0;ls<loopSize ;ls++){
				var flagLength = document.getElementsByName("flag").length+1;
				var k=1;
				var addFlag=true;//添加标志
				var certiNo = returnValue[ls*15+1];
				var payrefReason = returnValue[ls*15+13];
				var coinsCode = returnValue[ls*15+15];
				var payrefReasonName = getPayrefReasonName(payrefReason);
				//判断是否已经在列表中存在
				$("input[name='certiNoPay']").each(function(){
					var payRefReasonHav  = $(this).parent().parent().find("input[name='payrefreason']").val();
					var coinsCodeHav  = $(this).parent().parent().find("input[name='coinsCode']").val();
					if($(this).val()==certiNo&&payRefReasonHav==payrefReason){
						 if("GS60"!=payrefReason){
							alert("该支付已在合并支付列表中！不能重复增加！");
							addFlag=false;
						}else{
							if("GS60"==payrefReason && coinsCodeHav==coinsCode){
							alert("该支付已在合并支付列表中！不能重复增加！");
							addFlag=false;
							}
						}
						
					}
					k++;
				});
				//判断选中的计算书是否已经存在未支付完成的支付信息
				//var mergeFlag = payMergeCheck(payrefReason,certiNo,paymentNo);
				//if(!mergeFlag){
				//	alert("该计算书已经存在未支付完成的支付信息");
				//	addFlag=false;
				//}
				if(addFlag){
					if(flagLength<6){

					$("#addBtnTR").before("<tr > "+
					"<td class='input' align='center'>"+flagLength+"</td>"	+	
					"<td class='input'  align='center'> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='policyTypePay' value='"+returnValue[ls*15+12]+"' /> "+
					"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='policyNoPay' value='"+returnValue[ls*15+3]+"' /> "+
					"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='claimNoPay' value='"+returnValue[ls*15+4]+"' /> "+
					"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='payrefreason' value='"+returnValue[ls*15+13]+"' /> "+
					"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='serilNoPay' value="+k+" /> "+
					"   <input type='hidden' style='width: 99%' readOnly class='readOnly' name='payrefreasonChinesName' value='"+payrefReasonName+"' />"+
					//"</td> "+
					//"<td  class='input'  align='center'> "+
					"   <a href='#' onclick=\"logstore('"+returnValue[ls*15+2]+"','apay')\">"+returnValue[ls*15+2]+"</a> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='registNoPay' value='"+returnValue[ls*15+2]+"' /> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='classCode' value='"+returnValue[ls*15+14]+"' /> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='coinsCode' value='"+returnValue[ls*15+15]+"' /> "+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='insuredNamePay' value='"+returnValue[ls*15+5]+"' /> "+
					"		"+returnValue[ls*15+5]+
					"</td> "+
					//"<td  class='input'  align='center'> "+
					//"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='licenseNoPay' value='"+returnValue[ls*13+6]+"' /> "+
					//"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='certiNoPay' value='"+returnValue[ls*15+1]+"' /> "+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='comCodePay' value='"+returnValue[ls*15+9]+"' /> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='comCodeNamePay' value='"+returnValue[ls*15+10]+"' /> "+
					"	"+payrefReasonName+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align:right;' readOnly class='readOnly' name='sumPaidPay' value='"+returnValue[ls*15+7]+"' /> "+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align:right;' readOnly class='readOnly' name='havPaidPay' value='"+returnValue[ls*15+8]+"' /> "+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='hidden' name='paidMaxValue'  value='"+(returnValue[ls*15+7]-returnValue[ls*15+8]).toFixed(2)+"'/> "+
					"	<input type='text' style='width: 99%;text-align:right;'  class='input' name='paidPay'  value='"+(returnValue[ls*15+7]-returnValue[ls*15+8]).toFixed(2)+"' onblur='clearNoNumF(this);checkMaxVal(this);mergeFee(this);'/> "+
					"</td> "+
					//<td  class='input'  align='center'> "+
					//"  <input type='button' name='viewBtn' id='viewBtn'  class='bobu' value='查看' onclick=\"showPayAndPolicy('"+returnValue[ls*13+2]+"')\" /> "+
				    //"</td> "+
					"<td  class='input'  align='center'  > "+
					"	<input type='checkbox'  style='border: none;'  name='flag' value="+(k-1)+" checked  onclick='mergeFee(this);'/> "+
					"</td> "+
					"</tr> ");
					}else{
						$("#addBtnTR").before("<tr id='flagName' style='display:none'> "+
								"<td class='input' align='center'>"+flagLength+"</td>"	+
								"<td class='input'  align='center'> "+
								"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='policyTypePay' value='"+returnValue[ls*15+12]+"' /> "+
								"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='policyNoPay' value='"+returnValue[ls*15+3]+"' /> "+
								"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='claimNoPay' value='"+returnValue[ls*15+4]+"' /> "+
								"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='payrefreason' value='"+returnValue[ls*15+13]+"' /> "+
								"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='serilNoPay' value="+k+" /> "+
								"   <input type='hidden' style='width: 99%' readOnly class='readOnly' name='payrefreasonChinesName' value='"+payrefReasonName+"' />"+
								//"</td> "+
								//"<td  class='input'  align='center'> "+
								"   <a href='#' onclick=\"logstore('"+returnValue[ls*15+2]+"','apay')\">"+returnValue[ls*15+2]+"</a> "+
								"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='registNoPay' value='"+returnValue[ls*15+2]+"' /> "+
								"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='classCode' value='"+returnValue[ls*15+14]+"' /> "+
								"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='coinsCode' value='"+returnValue[ls*15+15]+"' /> "+
								"</td> "+
								"<td  class='input'  align='center'> "+
								"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='insuredNamePay' value='"+returnValue[ls*15+5]+"' /> "+
								"		"+returnValue[ls*15+5]+
								"</td> "+
								//"<td  class='input'  align='center'> "+
								//"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='licenseNoPay' value='"+returnValue[ls*13+6]+"' /> "+
								//"</td> "+
								"<td  class='input'  align='center'> "+
								"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='certiNoPay' value='"+returnValue[ls*15+1]+"' /> "+
								"</td> "+
								"<td  class='input'  align='center'> "+
								"	<input type='hidden' style='width: 99%' readOnly class='readOnly' name='comCodePay' value='"+returnValue[ls*15+9]+"' /> "+
								"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='comCodeNamePay' value='"+returnValue[ls*15+10]+"' /> "+
								"	"+payrefReasonName+
								"</td> "+
								"<td  class='input'  align='center'> "+
								"	<input type='text' style='width: 99%;text-align:right;' readOnly class='readOnly' name='sumPaidPay' value='"+returnValue[ls*15+7]+"' /> "+
								"</td> "+
								"<td  class='input'  align='center'> "+
								"	<input type='text' style='width: 99%;text-align:right;' readOnly class='readOnly' name='havPaidPay' value='"+returnValue[ls*15+8]+"' /> "+
								"</td> "+
								"<td  class='input'  align='center'> "+
								"	<input type='hidden' name='paidMaxValue'  value='"+(returnValue[ls*15+7]-returnValue[ls*15+8]).toFixed(2)+"'/> "+
								"	<input type='text' style='width: 99%;text-align:right;'  class='input' name='paidPay'  value='"+(returnValue[ls*15+7]-returnValue[ls*15+8]).toFixed(2)+"' onblur='clearNoNumF(this);checkMaxVal(this);mergeFee(this);'/> "+
								"</td> "+
								//<td  class='input'  align='center'> "+
								//"  <input type='button' name='viewBtn' id='viewBtn'  class='bobu' value='查看' onclick=\"showPayAndPolicy('"+returnValue[ls*13+2]+"')\" /> "+
							    //"</td> "+
								"<td  class='input'  align='center'  > "+
								"	<input type='checkbox'  style='border: none;'  name='flag' value="+(k-1)+" checked  onclick='mergeFee(this);'/> "+
								"</td> "+
								"</tr> ");
					}
				}
				
			}
			getPayTotalAmount();
		}
		
		//$("#addBtnTR").before("<tr><td colspan='10'>赔付信息</td></tr>");
	}
	function getPayrefReasonName(reasonCode){
		var jsArr = [];
		<% Map<String,String> paymentTypeMap = (HashMap<String,String> )request.getAttribute("paymentTypeMap");
			Set<String> set = paymentTypeMap.keySet();
			for(String paymentTypeCode : set){
		%>
			var code="<%=paymentTypeCode%>";
			var name="<%=paymentTypeMap.get(paymentTypeCode)%>";
			if(reasonCode.trim()==code.trim()){
				return name;
			}
		<%		
			}
		%>
		
	}
	function showPayAndPolicy(registNo){
		var url = "/claim/paymainAndRigistEdit.do?registNo="+registNo+"&dataType=linkOne&editType=SHOW&nodeType=apay&isBtn=true";
		window.open(url);
	}
	
	function showMany(obj){
		//document.getElementById("flagName").style.display="";
		var trs = $("tr[id='flagName']");
			for(var i=0;i<trs.length;i++){
				if(obj=='show'){
					trs[i].style.display="";
				}else{
					trs[i].style.display="none";
				}
			}
	}
	
	function showDiv(obj){
		if(obj=='hide'){
			document.getElementById("hideDivMany").style.display="";
			document.getElementById("showDivMany").style.display="none";
		}else{
			document.getElementById("hideDivMany").style.display="none";
			document.getElementById("showDivMany").style.display="";
		}
	}
</script>
<div id="content_basic" style="width: 98%" name="mainInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,mainInfo)">&nbsp;赔付信息
	</span>
	<table class="common" id="mainInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<!-- <td class="title"  style="width:8%" align="center">保单类型</td> -->
			<td class="title"  style="width:4%" align="center">序号</td>
			<td class="title"  style="width:11%" align="center">报案号码</td>
			<td class="title"  style="width:23%" align="center">被保险人/共保人</td>
			<td class="title"  style="width:11%" align="center">理算书号</td>
			<td class="title"  style="width:14%" align="center">赔款类型</td>
			<td class="title"  style="width:8%" align="center">结案金额</td>
			<td class="title"  style="width:8%" align="center">已支付金额</td>
			<td class="title"  style="width:12%" align="center">本次支付金额</td>
			<td class="title"  style="width:9%" align="center">操作</td>
		</tr>
		<c:if test="${not empty prpLpayShowDtoList }">
		<c:forEach items="${prpLpayShowDtoList }" var="prpLpayShowDto" varStatus="status">
		<tr>
			<td class="input" align="center">${status.count }</td>
			<td class="input"  align="center">
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="policyTypePay" value="${prpLpayShowDto.policyType }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="policyNoPay" value="${prpLpayShowDto.policyNo }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="claimNoPay" value="${prpLpayShowDto.claimNo }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="payrefreason" value="${prpLpayShowDto.payrefreason }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="serilNoPay" value="${status.count }" />
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="payrefreasonChinesName" value="${paymentTypeMap[prpLpayShowDto.payrefreason] }" />
			<!-- </td>
			<td  class="input"  align="center"> -->
				<a href="#" onclick="logstore('${prpLpayShowDto.registNo }','apay')">${prpLpayShowDto.registNo }</a>
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="registNoPay" value="${prpLpayShowDto.registNo }" />
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="classCode" value="${prpLpayShowDto.classCode }" />
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="coinsCode" value="${prpLpayShowDto.coinsCode }" />
			</td>
			<td  class="input"  align="center">
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="insuredNamePay" value="${prpLpayShowDto.insuredName }" />
				${prpLpayShowDto.insuredName }
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align: center;" readOnly class="readOnly" name="certiNoPay" value="${prpLpayShowDto.certiNo }" />
			</td>
			<td  class="input"  align="center">
				<input type="hidden" style="width: 99%" readOnly class="readOnly" name="comCodePay" value="${prpLpayShowDto.comCode}" />
				<input type="hidden" style="width: 99%;text-align: center;" readOnly class="readOnly" name="comCodeNamePay" value="${prpLpayShowDto.comCodeName }" />
				${paymentTypeMap[prpLpayShowDto.payrefreason] }
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align:right;" readOnly class="readOnly" name="sumPaidPay" value="<fmt:formatNumber type='number' value='${prpLpayShowDto.sumPaid }' pattern='#0.00' maxFractionDigits='2'/>" />
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align:right;" readOnly class="readOnly" name="havPaidPay" value="<fmt:formatNumber type='number' value='${prpLpayShowDto.havPaid }' pattern='#0.00' maxFractionDigits='2'/>" />
			</td>
			<td  class="input"  align="center">
				<input type="hidden" name="paidMaxValue"  value="<fmt:formatNumber type='number' value='${prpLpayShowDto.sumPaid-prpLpayShowDto.havPaid }' pattern='#.00' maxFractionDigits='2'/>" />
				<c:if test="${prpLpayShowDto.exist eq '1' }">
				<input type="hidden" style="width: 99%;text-align:right;"  class="input" name="paidPayHis"  value="${prpLpayShowDto.nowPaid }" onblur="clearNoNumF(this);checkMaxVal(this);mergeFee(this);"/>
				<input type="text" style="width: 99%;text-align:right;"  class="input" name="paidPay"  value="<fmt:formatNumber type='number' value='${prpLpayShowDto.nowPaid }' pattern='#0.00' maxFractionDigits='2'/>" onblur="clearNoNumF(this);checkMaxVal(this);mergeFee(this);"/>
				</c:if>
				<c:if test="${prpLpayShowDto.exist ne '1' }">
					<input type="text" style="width: 99%;text-align:right;"  class="input" name="paidPay"  value="<fmt:formatNumber type='number' value='${prpLpayShowDto.sumPaid-prpLpayShowDto.havPaid }' pattern='#0.00' maxFractionDigits='2'/>" onblur="clearNoNumF(this);checkMaxVal(this);mergeFee(this);"/>
				</c:if>
			</td>
			<td  class="input"  align="center">
				<input type="checkbox" style="border: none;" name="flag" value="${status.index }" onclick="mergeFee(this);" <c:if test="${prpLpayShowDto.exist eq '1' }">checked</c:if> />
			</td>
		</tr>
		</c:forEach>
		</c:if>
		<tr id="addBtnTR">		
			<td  class="input"  align="left" colspan="4">
				<input type="hidden" name="paymentType" value="${prpLpayGatherDto.paymentType }">
			</td>
			<td class="input"  align="center" colspan="2">
				本次总支付金额
			</td>
			<td class="input">
				<input type="text" style="width: 99%;text-align: right;" readOnly class="readonly" name="payAmount" <c:if test="${editType eq 'ADD' }">value=""</c:if><c:if test="${editType ne 'ADD' }">value="${sumPaid-havPaid}"</c:if> />
			</td>
			<td class="input" align="center">
				<div id="showDivMany">
					&nbsp;<input type="button" value="显示更多" class="button" width="95%" onclick="showMany('show');showDiv('hide');"/>
				</div>
				<div id="hideDivMany" style="display:none">
					&nbsp;<input type="button" value="收起" class="button" width="95%" onclick="showMany('hide');showDiv('show');"/>
				</div>
			</td>
			<td  class="input"  align="center">
				<input type="button" value="+" class="smallbutton" <c:if test="${(editType eq 'SHOW')  }">disabled </c:if>width="95%" onclick="addRow();"/>
			</td>
		<tr>

	</table>
	
</div>


		