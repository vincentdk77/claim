<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	/**
	* ��֤ҳ��Ҫ�صı�¼��
	*
	*/
	function checkReceiverInput(){
	var payAmount = $("input[name='payAmount']").val();
       if(parseFloat(payAmount)<=0){
       
       }else{
       
       }
       if($("input:radio[name='payWay']:checked").val()==null){
				alert("ѡ��֧����ʽ") ;
				return false;
		}
		if($("input:radio[name='payWay']:checked").val()=='2'&&$("#payReason").val()==""){
			alert("֧����ʽΪ����ͳ��ʽ֧����ʱ��֧��ԭ����Ϊ�գ�");
			return false;
		}
		//if($("input[name='payPurpose']").val()==""){
		//		alert("��¼����;˵��") ;
		//		return false;
		//}
		
		return true;
	}
     
    //����֧����ʽ��֧��ԭ����;˵�����js begin
    
	
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
	//�˻���д�������
    function refuseBefore()
    {
    	var strpayWay = $("input:radio[name='payWay']:checked").val();
    	if(strpayWay=='1'){
    	$("#payReason").val("");
    	}else{
			showRefuseText();    	
    	}
    }
    //�˻�ȷ��
    function refuse()
    {
    	if($("textarea[name='refuseRemark']").val()==""){
    		alert("����д���������");
    		return;
    	}
			$("#payReason").val($("textarea[name='refuseRemark']").val());
			hiddenRefuseText();
    }
    
     //���������򲻵ó������ݿ������õ��ֽ��� add by zhongfen
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
			alert("¼������ݳ������ֵ��������¼�룡");
			oInObj.focus();
			return false;
		} 
	}
    //����֧����ʽ��֧��ԭ����;˵�����js end    
</script>
<div id="content_basic" style="width: 98%" name="receiverInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,receiverInfo)">&nbsp;�������Ϣ
	</span>
	<table class="common" id="receiverInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<td class="title" width="13%">�ֻ�����
			</td>
			<td class="input" width="20%" >
				<input type="text" style="width: 99%" class="input" id="mobilePhone" name="mobilePhone" value="${prpLpayGatherDto.mobilePhone}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">��ͥ�绰
			</td>
			<td class="input" width="20%">
				<input type="text" style="width: 99%" class="input" name="familyPhone" value="${prpLpayGatherDto.familyPhone}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">�칫�绰
			</td>
			<td class="input" width="20%">
				<input type="text" style="width: 99%" class="input" name="officePhone" value="${prpLpayGatherDto.officePhone}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="title">��ϸ��ַ
			</td>
			<td class="input" colspan="3">
				<input type="text" style="width: 99%" class="input" id="address" name="address" value="${prpLpayGatherDto.address}"  maxlength="100" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" >QQ����
			</td>
			<td class="input" >
				<input type="text" style="width: 99%" class="input" name="qqNumber" value="${prpLpayGatherDto.qqNumber}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="title" >�����ʼ�
			</td>
			<td class="input">
				<input type="text" style="width: 99%" class="input" name="email" value="${prpLpayGatherDto.email}"  maxlength="100" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" > ��λ��ϵ��Ա
			</td>
			<td class="input">
				<input type="text" style="width: 99%" class="input" name="unitLink" value="${prpLpayGatherDto.unitLink}"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title">��������
			</td>
			<td class="input" colspan="2">
				<input type="text" style="width: 99%" class="input" name="postCode" value="${prpLpayGatherDto.postCode}" maxlength="6" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<!-- ����֧����ʽ��֧��ԭ����;˵�� begin -->
		<tr>
			<td class="title" >֧����ʽ<span style="color: red;">*</span>
			</td>
			<td class="input">
				<input type="radio" style="border: 0px;" id="payWay" name="payWay" checked <c:if test="${prpLpayGatherDto.payWay eq '1' }">checked='checked'</c:if> value="1" onclick="refuseBefore()">������֧��
				<input type="radio" style="border: 0px;" id="payWay" name="payWay" <c:if test="${prpLpayGatherDto.payWay eq '2' }">checked='checked'</c:if> value="2" onclick="refuseBefore()">��ͳ��ʽ֧��
			</td>
			<td class="title" >֧��ԭ��
			</td>
			<td class="input">
				<input type="text" id="payReason" name="payReason" value="${prpLpayGatherDto.payReason }" class="readonly" readonly/>
			</td>
			<td class="title">��;˵��
			</td>
			<td class="input" colspan="2">
				<input class="input"  style="width: 99%"  type="text" id="payPurpose" name="payPurpose" value="${prpLpayGatherDto.payPurpose }" maxLength="100" onblur="checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="input" colspan="7">
			<span style="color: red;">
			֧����ʽ��ʾ����������֧������ָ����֧������ͨ��������֧����˾ͳһ֧��������ͳ��ʽ֧������ָ����֧������ͨ���˹���ʽ������֧��
			<br>��;˵����ʾ����¼�������Ϣ�����¼��50������
			</span>
			</td>
		</tr>
		
		<!-- ����֧����ʽ��֧��ԭ����;˵�� ends -->
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
					���������
				</td>
				<td align="left" width="60%">
					<textarea rows="1" cols="5" name="refuseRemark" style="width: 80%;height: 60pt;"  maxlength="255" onblur="return checkMaxlength(this);"></textarea>
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input class="button" type="button" name="submitButton" value="ȷ ��" onclick="refuse();">
				</td>
				<td align="center">
					<input class="button" type="button" name="submitButton1" value="ȡ ��" onclick="hiddenRefuseText();">
				</td>
			</tr>
		</table>
		<div id="refuseTextMain" style="display: none;">
		</div>
	</div>
</div>
<jsp:include page="/DAA/payment/DAAPayMainTitle.jsp"/>