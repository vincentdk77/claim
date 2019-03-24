<%@page import="java.text.DecimalFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="java.util.*" %>
<script type="text/javascript">
	
	/**
	*	农户信息页面必录项及保存控制
	*/
	function checkMainInfo(){
		
		var paymentType = $("input[name='paymentType']").val();
    	if(typeof(paymentType) == "undefined"||paymentType==""){
    		alert("赔款类型不能为空");
    		return false;
    	}
    	var sumPayAmount = $("input[name='sumPayAmount']").val();
    	if(typeof(sumPayAmount) == "undefined"||sumPayAmount==""){
    		alert("本次支付金额不能为空");
    		return false;
    	}
    	if($("input[type=checkbox][name='flag'][checked]").length<1){
    		alert(" 必须在“农户信息”的“勾选”列至少勾选一条农户信息。");
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
    	if(parseFloat(sumPayAmount)==0){
    		alert("本次支付金额需大于0");
    		return false;
    	}//第三方支付赔款支付信息调整
    	$("input[name='paidPay']").each(function(){
    		checkMaxVal(this);
    	});
    	getPayTotalAmount();
    	return true;
	}

	//删除行
	function removeRow11(obj){
		$(obj).parent().parent().remove();
		getIndex11();
		getPayTotalAmount();
	}
	/**
     * 重新获得序号
     */
    function getIndex11(){
    	$("input[name='prpLclaimBillManagerRowNum']").each(function(i,obj){
    		if($(obj).val()!=(i+1)){
    			$(obj).val(i+1);
    		}
    	});
    }
	function addRow11(){
		var urlStr ="";
		var nodeType=fm.nodeType.value;
		urlStr="nodeType="+nodeType;
		var payType=$("input[name='payType']").val();
		//var paymentType=$("select[name='paymentType'] option[selected]").val();
		urlStr +="&payType="+payType;//+"&paymentType="+paymentType;
		var url = "/claim/paymainfiscalAddBefor.do?"+urlStr;
		var returnValue = window.showModalDialog(url,window,"dialogWidth=760px;dialogHeight=450px");
		if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
			var loopSize  = (returnValue.length-1)/8 ;//看返回了几个对象（即选中了几个号码）
			
			for(var ls = 0;ls<loopSize ;ls++){
				var k=1;
				var addFlag=true;//添加标志
				var certiNo = returnValue[ls*8+3];
				var registNo = returnValue[ls*8+2];
				var insuredCode =  returnValue[ls*8+4] ;
				//判断是否已经在列表中存在
				$("input[name='compensateNo']").each(function(){
					var fiscalRegistNoHav  = $(this).parent().parent().find("input[name='fiscalRegistNo']").val();
					var insuredCodeHav  = $(this).parent().parent().find("input[name='insuredCode']").val();
					if($(this).val()==certiNo&&fiscalRegistNoHav==registNo&&insuredCodeHav==insuredCode){
						alert("该支付已在合并支付列表中！不能重复增加！");
						addFlag=false;
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
					$("#addBtnTR").before("<tr> "+
					"<td class='input'  align='center'> "+
					"	<input type='text'  class='readonly' style='text-align:center;width:100%' name='prpLclaimBillManagerRowNum' value='"+(k-1)+"'/>"+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='hidden' style='width: 99%;text-align: center;' readOnly class='readOnly' name='fiscalRegistNo' value='"+returnValue[ls*8+2]+"' /> "+
					"	<input type='text'  class='readonly' style='text-align:center;width:100%' name='compensateNo' value='"+returnValue[ls*8+3]+"'/>" +
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='insuredCode' value='"+returnValue[ls*8+4]+"' /> " +
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='payName' value='"+returnValue[ls*8+5]+"' /> "+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align: center;' readOnly class='readOnly' name='identifyNumber' value='"+returnValue[ls*8+6]+"' />"+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%' readOnly class='readOnly' name='bankAccount' value='"+returnValue[ls*8+7]+"' />"+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"	<input type='text' style='width: 99%;text-align: right;' readOnly class='readOnly' name='fiscalpayAmount' value='"+returnValue[ls*8+8]+"' />"+
					"</td> "+
					"<td  class='input'  align='center'> "+
					"  <input type='checkbox' style='border: none;' name='flag' value='' onclick='mergeFee(this);' checked />"+
				    "</td> "+
					"<td  class='input'  align='center'  > "+
					"	<input type='button' value='-' class='smallbutton' width='95%' onclick='removeRow11(this);'/>"+
					"</td> "+
					"</tr> ");
				}
				
			}
			getPayTotalAmount();
		}
		
		//$("#addBtnTR").before("<tr><td colspan='10'>赔付信息</td></tr>");
	}
	
	
	//全选
	function mergeFeeAll(obj){
		
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
			if($(obj).is(":checked")){
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
					var paidStr = $(this).parent().parent().find("input[name='fiscalpayAmount']").val();
					var paid=parseFloat(paidStr);
					payAmount+=paid;
				}else{
					$(obj).removeAttr("checked");
				}
				k++;
				$(this).attr("checked","true");
			}else{
				payAmount = 0.00;
				$(this).attr("checked","");
			}
		});
		$("input[name='payTotalAmount']").val(payTotalAmount.toFixed(2));
		$("input[name='hasPay']").val(hasPay.toFixed(2));
		$("input[name='sumPayAmount']").val(payAmount.toFixed(2));
		
	}
</script>
<%
	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
	//double sumPayAmount = 0.00;
	int num = 1;
%>
<div id="content_basic" style="width: 98%" name="fiscalInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,fiscalInfo)">&nbsp;农户信息
	</span>
	<table class="common" id="fiscalInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<td class="title"  style="width:5%" align="center">序号</td>
			<td class="title"  style="width:16%" align="center">计算书号</td>
			<td class="title"  style="width:13%" align="center">农户代码</td>
			<td class="title"  style="width:11%" align="center">农户姓名</td>
			<td class="title"  style="width:14%" align="center">身份证号</td>
			<td class="title"  style="width:13%" align="center">银行账号</td>
			<td class="title"  style="width:10%" align="center">赔付金额</td>
			<td class="title"  style="width:9%" align="center">勾选</td>
			<td class="title"  style="width:9%" align="center">操作</td>
		</tr>
		<c:if test="${not empty fiscalFarmerslist }">
		<c:forEach items="${fiscalFarmerslist }" var="prpLclaimBillManagerDto" varStatus="status">
		<%PrpLclaimBillManagerDto  prpLclaimBillManagerDtoTemp = (PrpLclaimBillManagerDto)pageContext.getAttribute("prpLclaimBillManagerDto");
		//sumPayAmount += prpLclaimBillManagerDtoTemp.getPayAmount();
		%>
		<c:if test="${(editType eq 'ADD' and  prpLclaimBillManagerDto.exist ne '1') or editType eq 'SHOW' or editType eq 'EDIT'}">
		<tr>
			<td class="input"  align="center">
				<input type="text"  class="readonly" style="text-align:center;width:100%" name="prpLclaimBillManagerRowNum" value="<%=num++ %>"/>
			</td>
			<td class="input"  align="center">
				<input type="hidden"  class="readonly" style="text-align:center;width:100%" name="fiscalRegistNo" value="${prpLclaimBillManagerDto.registNo }"/>
				<input type="text"  class="readonly" style="text-align:center;width:100%" name="compensateNo" value="${prpLclaimBillManagerDto.compensateNo }"/>
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align: center;" readOnly class="readOnly" name="insuredCode" value="${prpLclaimBillManagerDto.insuredCode }" />
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align: center;" readOnly class="readOnly" name="payName" value="${prpLclaimBillManagerDto.payName }" />
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align: center;" readOnly class="readOnly" name="identifyNumber" value="${prpLclaimBillManagerDto.identifyNumber }" />
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%" readOnly class="readOnly" name="bankAccount" value="${prpLclaimBillManagerDto.bankAccount}" />
			</td>
			<td  class="input"  align="center">
				<input type="text" style="width: 99%;text-align: right;" readOnly class="readOnly" name="fiscalpayAmount" value="${prpLclaimBillManagerDto.payAmount }" />
			</td>
			<td  class="input"  align="center">
				<input type="checkbox" style="border: none;" name="flag" value="${status.index }" onclick="mergeFee(this);" <c:if test="${prpLclaimBillManagerDto.exist eq '1' }">checked</c:if> />
			</td>
			<td  class="input"  align="center">
				<input type="button" value="-" class="smallbutton" <c:if test="${(editType eq 'SHOW')  }">disabled </c:if>width="95%" onclick="removeRow11(this);"/>
			</td>
		</tr>
		</c:if>
		</c:forEach>
		</c:if>
		<tr id="addBtnTR">		
			<td  class="input"  align="left" colspan="4">
				<input type="hidden" name="paymentType" value="${paymentType }">
				<tnput type="hidden" name="payType" value="${payType }"/>
			</td>
			<td class="input"  align="center" colspan="2">
				本次总支付金额
			</td>
			<td class="input">
				<input type="text" style="width: 99%;text-align: right;" readOnly class="readonly" name="sumPayAmount" value="" />
			</td>
			<td class="input" align="center">
				全选<input type="checkbox" style="border: none;" name="allflag" value="${status.index }" onclick="mergeFeeAll(this);"/>
			</td>
			<td  class="input"  align="center">
				<input type="button" value="+" class="smallbutton" <c:if test="${(editType eq 'SHOW')  }">disabled </c:if>width="95%" onclick="addRow11();"/>
			</td>
		<tr>

	</table>
	
</div>


		