<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	/**
	* 验证页面要素的必录项
	*
	*/
	function checkReceiverInput(){
	var payAmount = $("input[name='payAmount']").val();
       if(parseFloat(payAmount)<=0){
       
       }else{
       
       }
       if($("input:radio[name='payWay']:checked").val()==null){
				alert("选择支付方式") ;
				return false;
		}
		if($("input:radio[name='payWay']:checked").val()=='2'&&$("#payReason").val()==""){
			alert("支付方式为“传统方式支付”时，支付原因不能为空！");
			return false;
		}
		//if($("input[name='payPurpose']").val()==""){
		//		alert("请录入用途说明") ;
		//		return false;
		//}
		
		return true;
	}
     
    //新增支付方式、支付原因、用途说明添加js begin
    
	
	function showRefuseText(){
		refuseBack.style.display = "";
		refuseText.style.display = "";
		showRefuseTextOpacity();
    }
    function hiddenRefuseText(){
            refuseBack.style.display = "none";
            refuseText.style.display = "none";
    }
    var opacityi = 0;
    var opacityj = 0;
    var timeName;
	function showRefuseTextOpacity(){
		if(parseFloat(opacityi)<30){
			refuseBack.filters.alpha.opacity = opacityi;
			refuseText.filters.alpha.opacity = opacityj;
            timeName = setTimeout("showRefuseTextOpacity()", 10);
            opacityi = parseFloat(opacityi) + 0.8;
            opacityj = parseFloat(opacityj) + 8;
	    }else{
			clearTimeout(timeName);
			opacityi = 0;
			opacityj = 0;
	    }
    }
	//退回填写处理意见
    function refuseBefore()
    {
    	var strpayWay = $("input:radio[name='payWay']:checked").val();
    	if(strpayWay=='1'){
    	$("#payReason").val("");
    	}else{
			showRefuseText();    	
    	}
    }
    //退回确定
    function refuse()
    {
    	if($("textarea[name='refuseRemark']").val()==""){
    		alert("请填写处理意见！");
    		return;
    	}
			$("#payReason").val($("textarea[name='refuseRemark']").val());
			hiddenRefuseText();
    }
    
     //控制输入域不得超出数据库所配置的字节数 add by zhongfen
  	String.prototype.realLength = function()
	 {
	   return this.replace(/[^\x00-\xff]/g,"**").length;
	 }
	function checkMaxlength(oInObj) 
	{
		var iMaxLen = parseInt(oInObj.getAttribute('maxlength')); 
		var iCurLen = oInObj.value.realLength(); 
		
		if ( oInObj.getAttribute && iCurLen > iMaxLen ) 
		{ 
			alert("录入的内容超出最大值，请重新录入！");
			oInObj.focus();
			return false;
		} 
	}
    //新增支付方式、支付原因、用途说明添加js end    
</script>
<div id="content_basic" style="width: 98%" name="receiverInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,receiverInfo)">&nbsp;领款人信息
	</span>
	<table class="common" id="receiverInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<td class="title" width="13%">手机号码
			</td>
			<td class="input" width="20%" >
				<input type="text" style="width: 99%" class="input" id="mobilePhone" name="mobilePhone" value="${prpLpayGatherDto.mobilePhone}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">家庭电话
			</td>
			<td class="input" width="20%">
				<input type="text" style="width: 99%" class="input" name="familyPhone" value="${prpLpayGatherDto.familyPhone}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">办公电话
			</td>
			<td class="input" width="20%">
				<input type="text" style="width: 99%" class="input" name="officePhone" value="${prpLpayGatherDto.officePhone}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="title">详细地址
			</td>
			<td class="input" colspan="3">
				<input type="text" style="width: 99%" class="input" id="address" name="address" value="${prpLpayGatherDto.address}"  maxlength="100" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" >QQ号码
			</td>
			<td class="input" >
				<input type="text" style="width: 99%" class="input" name="qqNumber" value="${prpLpayGatherDto.qqNumber}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="title" >电子邮件
			</td>
			<td class="input">
				<input type="text" style="width: 99%" class="input" name="email" value="${prpLpayGatherDto.email}"  maxlength="100" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" > 单位联系人员
			</td>
			<td class="input">
				<input type="text" style="width: 99%" class="input" name="unitLink" value="${prpLpayGatherDto.unitLink}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title">邮政编码
			</td>
			<td class="input" colspan="2">
				<input type="text" style="width: 99%" class="input" name="postCode" value="${prpLpayGatherDto.postCode}" maxlength="6" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<!-- 新增支付方式、支付原因、用途说明 begin -->
		<tr>
			<td class="title" >支付方式<span style="color: red;">*</span>
			</td>
			<td class="input">
				<input type="radio" style="border: 0px;" id="payWay" name="payWay" checked <c:if test="${prpLpayGatherDto.payWay eq '1' }">checked='checked'</c:if> value="1" onclick="refuseBefore()">第三方支付
				<input type="radio" style="border: 0px;" id="payWay" name="payWay" <c:if test="${prpLpayGatherDto.payWay eq '2' }">checked='checked'</c:if> value="2" onclick="refuseBefore()">传统方式支付
			</td>
			<td class="title" >支付原因
			</td>
			<td class="input">
				<input type="text" id="payReason" name="payReason" value="${prpLpayGatherDto.payReason }" class="readonly" readonly/>
			</td>
			<td class="title">用途说明
			</td>
			<td class="input" colspan="2">
				<input class="input"  style="width: 99%"  type="text" id="payPurpose" name="payPurpose" value="${prpLpayGatherDto.payPurpose }" maxLength="100" onblur="checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="input" colspan="7">
			<span style="color: red;">
			支付方式提示：“第三方支付”是指财务支付中心通过第三方支付公司统一支付；“传统方式支付”是指财务支付中心通过人工方式走网银支付
			<br>用途说明提示：可录入相关信息，最多录入50个汉字
			</span>
			</td>
		</tr>
		
		<!-- 新增支付方式、支付原因、用途说明 ends -->
	</table>
	
	
	<div id="refuseBack" align="center" style="display: none;background: #CCCCCC;top: 0px;left: 0px;width: 105%;height: 100%;position: absolute;filter:alpha(opacity=30);">
	</div>
	<div id="refuseText" align="center" style="display: none;background-color: #FFFFFF;color:#000000 ;top: 120px;left: 20px;width: 90%;height: 50%;position: absolute;font-weight: bold;filter:alpha(opacity=300);border: #D4D4D4 solid 4px;">
		<table id="tabRefuseMsg" align="center" width="60%">
			<tr>
				<td align="center" colspan="2" height="30px;">
				</td>
			</tr>
			<tr>
				<td align="left" width="15%" >
					处理意见：
				</td>
				<td align="left" width="60%">
					<textarea rows="1" cols="5" name="refuseRemark" style="width: 80%;height: 60pt;"  maxlength="255" onblur="return checkMaxlength(this);"></textarea>
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input class="button" type="button" name="submitButton" value="确 定" onclick="refuse();">
				</td>
				<td align="center">
					<input class="button" type="button" name="submitButton1" value="取 消" onclick="hiddenRefuseText();">
				</td>
			</tr>
		</table>
		<div id="refuseTextMain" style="display: none;">
		</div>
	</div>
</div>
<jsp:include page="/DAA/payment/DAAPayMainTitle.jsp"/>