<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<link rel="stylesheet" type="text/css" href="/claim/css/StandardCar.css">
<link rel="stylesheet" type="text/css" href="/claim/css/number.css" />
<link rel="stylesheet" type="text/css" href="/claim/css/bank.css" />
<link rel="stylesheet" type="text/css" href="/claim/css/alpha.css" />
<link rel="stylesheet" type="text/css" href="/claim/css/css.css" />
<script type="text/javascript" src="/claim/DAA/js/number.js"></script>
<script type="text/javascript" src="/claim/DAA/js/jquery.min.js">
<script type="text/javascript" src="/claim/DAA/js/jquery.js"></script>
<script type="text/javascript" src="/claim/DAA/js/drag.js"></script>
<script type="text/javascript" src="/claim/DAA/js/city_arr.js"></script>
<script type="text/javascript" src="/claim/DAA/js/nationality_arr.js"></script>
<script type="text/javascript" src="/claim/DAA/js/funtype_arr.js"></script>
<script type="text/javascript" src="/claim/DAA/js/industry_arr.js"></script>
<script type="text/javascript" src="/claim/DAA/js/major_arr.js"></script>
<script type="text/javascript" src="/claim/DAA/js/city_func.js"></script>
</script>
<script type="text/javascript" src="/claim/DAA/js/city.js"></script>
<link href="/claim/css/bankNew.css" rel="stylesheet" media="screen" type="text/css" />
<script type="text/javascript" src="/claim/DAA/js/cityNew.js"></script>
<style type="text/css">
*{margin:0;padding:0;list-style-type:none;}

table{empty-cells:show;border-collapse:collapse;border-spacing:0;}

.demo{width:670px;margin:20px auto;}
.inputbox{border:1px solid #7f9db9;height:10px;line-height:10px;width: 99%;}
.inputbox .stext{border:0px;height:18px;line-height:18px;width: 100%;margin:0;padding:0;float:left;color:#000;}
.inputbox .keyicon{margin:3px;padding:0;float:right}
.inputbox .keyicon img{cursor:pointer;}
/* ѡ�������ʽ */
.search_li02{width:150px;}
.list_main{width:150px;}
.choose_frame{clear:both;float:left;text-align:left;width:372px;}
.choose_frame .list_head{border-bottom:1px dashed #D7D7D7;height:27px;padding-left:5px;width:367px;}
.choose_frame .list_head .fleft li {cursor:pointer;float:left;height:27px;line-height:27px;margin-right:2px;text-align:center;width:26px;}

.choose_frame .list_head .fcenter{float:left;line-height:27px;padding-left:10px;}
.choose_frame .list_head .fright{float:right;padding-right:10px;padding-top:7px;}
.city_sugg{clear:both;float:left;line-height:22px;width:372px;}
.city_sugg li{float:left;padding-left:11px;width:50px;}
.more_city{float:right;padding-bottom:5px;padding-right:12px;}
.search_li02{background:url("/claim/images/bj_02.gif") no-repeat scroll 0 2px transparent;font-weight:bold;}

.city_list2{border-bottom:1px dashed #D7D7D7;height:27px;line-height:27px;width:372px;}
.city_list2 li{float:left;padding-left:7px;}
.city_list2 a:hover{color:#FF6000;font-size:16px;font-weight:bold;}
.unshow{display:none;}
.link01 a:link, .link01 a{color:#2860AE;text-decoration:none;}
.link01 a:visited{color:#2860AE;text-decoration:none;}
.link01 a:hover{color:#FF6000;text-decoration:none;}
.link01 a:active{color:#2860AE;text-decoration:none;}
.list_main{float:left;width:372px;}
.suggest-container{background:none repeat scroll 0 0 white;float:left;width:175px;z-index:99999;}
.suggest-container .ds_input_tips{color:#666666;line-height:22px;text-align:left;}
.suggest-container .ds_input_tips_no{background-color:#FF8040;margin:0;padding-left:10px;width:165px;}
.suggest-container .ds_input_tips_one{border-bottom:1px dashed #AAAAAA;margin:0 5px;padding-left:5px;width:160px;}
.suggest-container .ds_input_tips_full{border-bottom:1px dashed #AAAAAA;margin:0 5px;padding-left:5px;width:160px;}
.suggest-container ol{float:left;padding:2px 5px;width:165px;}
.suggest-container li{border-bottom:1px solid #FFFFFF;border-top:1px solid #FFFFFF;color:#0055AA;float:left;font-size:12px;line-height:20px;padding:1px 0 2px;width:100%;}
.suggest-container dl{float:left;font-size:12px;line-height:20px;padding:0 2px;width:95%;}
.suggest-container dt, .suggest-container dd{color:#414141;float:left;font-size:12px;line-height:20px;list-style:none outside none;width:99%;}
.suggest-container .top_mover{background:none repeat scroll 0 0 #E7F1FD;border-bottom:1px solid #7F9DB9;border-top:1px solid #7F9DB9;color:#0055AA;cursor:pointer;}
.suggest-container .top_mout{background:none repeat scroll 0 0 #FFFFFF;border-bottom:1px solid #FFFFFF;border-top:1px solid #FFFFFF;color:#0055AA;}
.suggest-container .ds_selected{background:none repeat scroll 0 0 #C8E3FC;color:#0055AA;cursor:pointer;}
.suggest-container .ds_selected span{color:#0055AA;cursor:pointer;}
.suggest-container .suggest-result{color:#0055AA;cursor:pointer;float:right;padding-right:5px;text-align:right;white-space:nowrap;}
.suggest-container .suggest-key{float:left;padding-left:5px;text-align:left;}
.suggest-container li, .suggest-bottom{clear:both;overflow:hidden;}
.suggest-shim{z-index:99998;}
.suggest-bottom{padding:0 5px 5px;}
.suggest-close-btn{float:right;}
.on{color:#FF6000;font-size:16px;font-weight:bold;}
.off{color:#195CB5;}
.city_sugg a:link{color:#333;}
.city_sugg a:hover{color:#FF6600;}

</style>

<script type="text/javascript">
	//���ڽ�һ������ת����2���ֽڳ���
	String.prototype.realLength = function(){
		return this.replace(/[^\x00-\xff]/g,"**").length;
	}
	/**
	* У�������ֵ���ɴ�����󳤶�
	*/
	function checkMaxlength(oInObj){ 
		var iMaxLen = parseInt(oInObj.getAttribute('maxlength')); 
		var iCurLen = oInObj.value.realLength(); 
		if ( oInObj.getAttribute && iCurLen > iMaxLen ){ 
			alert("¼������ݳ������ֵ��������¼�룡");
			oInObj.focus();
			return false;
		} 
	}
	/**
	* ��֤ҳ��Ҫ�صı�¼��
	*
	*/
	function checkAccountInput(){
	var payAmount = $("input[name='payAmount']").val();
       if(parseFloat(payAmount)<=0){
       
       }else{
       	   var pro = $("#pro").val();
       	   if(typeof(pro)=="undefined"||pro==""){
       	   		alert("ʡ�����Ʋ���Ϊ��");
       	   		return false;
       	   }
       	   var btn_hukou = $("#btn_hukou").val();
       	   if(typeof(btn_hukou)=="undefined"||btn_hukou==""){
       	   		alert("�������Ʋ���Ϊ��");
       	   		return false;
       	   }
       	   var accountType = $("input[name=accountType]:checked").val();
       	   if(typeof(accountType)=="undefined"||accountType==""){
       	   		alert("�˻����Բ���Ϊ��");
       	   		return false;
       	   }
       
	       var bankType = $("#citySelect").val();
			if(typeof(bankType) == "undefined"||bankType==""||bankType.trim()==""){
	    		alert("���д��಻��Ϊ��");
	    		return false;
	    	}
			var bank = $("#bank").val();
			if(typeof(bank) == "undefined"||bank==""||bank.trim()==""){
	    		alert("�������в���Ϊ��");
	    		return false;
	    	}
			var bankAccount = $("#bankAccount").val();
			if(typeof(bankAccount) == "undefined"||bankAccount==""||bankAccount.trim()==""){
	    		alert("�����˺Ų���Ϊ��");
	    		return false;
	    	}
			var bankAccount2 = $("#bankAccount2").val();
			if(typeof(bankAccount2) == "undefined"||bankAccount2==""||bankAccount2.trim()==""){
	    		alert("�˺�ȷ�ϲ���Ϊ��");
	    		return false;
	    	}
			if(bankAccount!=bankAccount2){
				alert("�����˺����벻һ��");
				return false;
			}
			
			var accountFlag = $("input[name=accountFlag]:checked").val();
       	   if(typeof(accountFlag)=="undefined"||accountFlag==""){
       	   		alert("�˺����Ͳ���Ϊ��");
       	   		return false;
       	   }
	    	if($("input:radio[name='payWay']:checked").val()==null){
				alert("ѡ��֧����ʽ") ;
				return false;
			}
			if($("input:radio[name='payWay']:checked").val()=='2'){
				alert("�嵥��֧��ʱ,֧����ʽ����Ϊ����ͳ��ʽ֧����!");
				return false;
			}
			if($("input:radio[name='payWay']:checked").val()=='2'&&$("#payReason").val()==""){
				alert("֧����ʽΪ����ͳ��ʽ֧����ʱ��֧��ԭ����Ϊ�գ�");
				return false;
			}
       }
		
		return true;
	}
	//��֤ȷ���˺��Ƿ����˺�һ��
	function checkBankAccount(){
		var bankAccount = $("#bankAccount").val();
		var bankAccount2 = $("#bankAccount2").val();
		if(typeof(bankAccount2) == "undefined"||bankAccount2==""||bankAccount2.trim()==""){
    		alert("�˺�ȷ�ϲ���Ϊ��");
    		return false;
    	}
    	//У�������˻�����С����λ
	    	var bankAccountLength=bankAccount.length;
	    	if(bankAccountLength<5){
	    		alert("�����˺Ų���С��5λ");
	    		return false;
	    	}
		if(bankAccount!=bankAccount2){
			alert("�����˺����벻һ��");
			return false;
		}
		return true;
	}
	//����ת�������������ں���
	function open_CodeSelectBankType(field,codeType,treeTitle){
		var elements = fm.elements;	
		var index = 0;
		for(var i = 0;i < elements.length;i++){
			if(elements[i] == field){
				index = i; 
				break;
			}
		}
		var provinceCode = "";
		var strUrl = "/claim/common/pub/CodeTree.jsp?";
		strUrl += "treeTitle=" + treeTitle;
		strUrl += "&codeType=" + codeType;
		var result = window.showModalDialog(strUrl,window,'DialogWidth=300px;DialogHeight=350px;help=no;status=no');
		if(typeof(result) != 'undefined' && result != null && result != ""){
			var temp = result.split("#");
			fm.elements[i - 1].value = temp[0];
			//fm.elements[i + 1].value = temp[1];
			field.value = temp[1];
		}
	}
	//ֻ���������ֵ��ı���
	function clearNoNumZ(obj)
	{
	 //�Ȱѷ����ֵĶ��滻������������
	 obj.value = obj.value.replace(/[^\d\-]/g,"");
	 fireChangeComm(obj);
	}
	
	//У����˺͵�λ���˺�����
	function setAccountFlag(obj){
		if(obj=='1'){
			$("#accountFlag0").css("display","");
			$("#accountFlag1").css("display","none");
			$("input:radio[name=accountFlag][value='03']").attr('checked','');
		}else{
			$("#accountFlag0").css("display","none");
			$("#accountFlag1").css("display","");
			$("input:radio[name=accountFlag][value='00']").attr('checked','');
			$("input:radio[name=accountFlag][value='01']").attr('checked','');
			$("input:radio[name=accountFlag][value='02']").attr('checked','');
		}
	}
	function refuseBefore()
    {
    	var strpayWay = $("input:radio[name='payWay']:checked").val();
    	if(strpayWay=='1'){
    	$("#payReason").val("");
    	}else{
			showRefuseText();    	
    	}
    }
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
    
	function setAccountMessage(){
		if(!checkAccountInput()){
			return false;
		}
		if(!checkBankAccount()){
			return false;
		}
		var ret = new Array();
		ret[0] = "true";
		ret[1] = fm.provinceCode.value;
		ret[2] = fm.cityCode.value;
		ret[3] = $("input[name=accountType]:checked").val();
		ret[4] = fm.bankType.value;
		ret[5] = fm.bankAccount.value;
		ret[6] = $("input[name=accountFlag]:checked").val();
		ret[7] = fm.bank.value;
		ret[8] = fm.routeNum.value;
		ret[9] = fm.address.value;
		ret[10] = fm.mobilePhone.value;
		ret[11] = $("input:radio[name='payWay']:checked").val();
		ret[12] = fm.payReason.value;
		ret[13] = fm.payPurpose.value;
		window.returnValue = ret;
		window.close();
	}
	
	//У�������˺���Ϣ��С����λ
	function checkMinlength(oInObj){ 
		var iCurLen = oInObj.value.realLength(); 
		if ( oInObj.getAttribute && iCurLen < 5 ){ 
			alert("�����˺Ų���������λ��������¼�룡");
			//oInObj.focus();
			return false;
		} 
		//У�������˺���Ϣ��󳤶�
		return checkMaxlength(oInObj);
	}
/* function getBank_number(){
	var bank1 = document.getElementById("bank").value;
   	$.ajax({
		url:"/claim/SearchBankNumber.do"
		,type:"POST"
		,dataType:"text"
		,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
		,data:{"bank1":bank1}
		,success:function(data){
			var retMsg = data.split(",");
			var bankNumber = retMsg[0];
			var flag = retMsg[1];
			document.getElementById("Insertflag").value = flag;
			if(bankNumber!=null&&bankNumber!=""){
				document.getElementById("bankCNameCodeId").value = bankNumber;
				document.getElementById("bankCNameCodeIdold").value = bankNumber;
				if(flag=="1"){
					$("#bankCNameCodeId").attr("readonly",false);
				}else{
					$("#bankCNameCodeId").attr("readonly","true");
					fm.routeNum.blur();
				}
			}else{
				document.getElementById("bankCNameCodeId").value = "";
				document.getElementById("bankCNameCodeIdold").value = "";
				$("#bankCNameCodeId").attr("readonly",false);
			}
		}
		,error:function(){alert('ϵͳ�쳣��');}
	});
} */
function checkNumber(){
	var reg = /^\d+$/;
	if(fm.routeNum.value.length>0){
		if(fm.routeNum.value.length!=12){
		alert("���кų��ȱ���Ϊ12λ��");
		$('#bankCNameCodeId').val("");
		return;
		}
		if(reg.test(fm.routeNum.value)==false){
		alert("���к�ֻ����¼�����֣�");
		$('#bankCNameCodeId').val("");
		}
	}
}	
</script>
<%
	String payName = request.getParameter("payName");
	String identifyNumber = request.getParameter("identifyNumber");
	String provinceName = request.getParameter("provinceName");
	String cityName = request.getParameter("cityName");
	String accountType = request.getParameter("accountType");
	String bankName = request.getParameter("bankName");
	String bankAccount = request.getParameter("bankAccount");
	String accountFlag = request.getParameter("accountFlag");
	String openBank = request.getParameter("openBank");
	String routeNum = request.getParameter("routeNum");
	String address = request.getParameter("address");
	String mobilePhone = request.getParameter("mobilePhone");
	String payWay = request.getParameter("payWay");
	String payReason = request.getParameter("payReason");
	String payPurpose = request.getParameter("payPurpose");
%>
<div id="content_basic" style="width: 98%" name="accountInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px ">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,accountInfo)">&nbsp;�˻���Ϣ
	</span>
	<table class="common" id="accountInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8" >
		<tr>
			<td class="title" width="13%">ʡ������<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
			<input style="width: 99%" id='pro' type="text" value="<%=provinceName%>" name="provinceCode" class="readOnly" readonly="readonly"/>
			</td>
			<td class="title" width="13%">��������<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
			<%if(!editType.equals("SHOW")){ %>
			<input id="btn_hukou" name="cityCode" style="width: 99%" type="text"  onclick="hukouSelect()" value="<%=cityName%>"/>
			<%} %>
			<%if(editType.equals("SHOW")){ %>
			<input id="btn_hukou" name="cityCode" style="width: 99%" type="text"   readOnly value="<%=cityName%>"/>
			<%} %>
            <!-- alpha div -->
            <div id="maskLayer" style="display:none">
			<iframe id="maskLayer_iframe" frameBorder=0 scrolling=no style="filter:alpha(opacity=50)"></iframe>
			<div id="alphadiv" style="filter:alpha(opacity=50);-moz-opacity:0.5;opacity:0.5"></div>
				<div id="drag">
					<h3 id="drag_h"></h3>
				<div id="drag_con"></div><!-- drag_con end -->
			</div>
			</div><!-- maskLayer end -->
			<!-- alpha div end -->
			<div id="sublist" style="display:none"></div>
            
			</td>
			<td class="title" width="13%">�˺�����<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<input type="radio" style="border: 0px;" id="accountType" name="accountType" <%if(accountType.equals("1") ){%>checked='checked'<%} %> value="1" onclick="setAccountFlag('1');">�����˺�
				<input type="radio" style="border: 0px;" id="accountType" name="accountType" <%if(accountType.equals("2")){%>checked='checked'<%} %> value="2" onclick="setAccountFlag('2');">��λ�˺�
			</td>
		</tr>
		<tr>
			<td class="title" width="13%">���д���<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<!--  
            	<input type="hidden" class = "cityinput" id="citySelect" name="bankType" value="" />
            	-->
            <%if(!editType.equals("SHOW")){%>
			<div class="inputbox">
				<input name="bankType" type="text" value="<%=bankName%>" id="citySelect" onclick="suggestF.display(this,'',event);" onkeydown="item_suggest.item_display(this,'',event);" onblur="item_suggest.item_onblur(this);" class="stext" readonly="readonly"/>
			</div>
            <%} %>
            <%if(editType.equals("SHOW")){%>
            	<input type="text" style="width: 99%" class="cityinput" id="citySelect" name="bankType" value="<%=bankName%>" readonly="readonly">
            <%} %>
			</td>
			<td class="title" width="13%">
			��������<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%" colspan="1">
			<div class="inputbox1">
				<input name="bank" maxlength="150"  style="width: 588px;" type="text"  value="<%=openBank%>"   id="bank"   onkeyup="item_suggest1.item_display1(this,'',event);" class="stext" />
			</div>
			<%-- <input  class="common"  type="hidden" name="routeNum" id ="bankCNameCodeId" value="<%=routeNum%>"/> --%>
			</td>
			<td class="title" width="13%">���к�<span style="color: red;">*</span>
			</td>
			<td>
				<input  class="common"  type="text"   name="routeNum" id ="bankCNameCodeId" value="<%=routeNum%>"  onblur="checkNumber();"/>
				<input name="Insertflag" type="hidden" value="0" id="Insertflag" />
				<input name="routeNumold" type="hidden" value="" id="bankCNameCodeIdold" />
			</td>
			
			
		</tr>
		<tr>
			<td class="title" width="13%">�����˺�<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<div id="main">
				<input type="text" style="width: 99%" maxlength="30"  class="input" id="bankAccount" name="bankAccount" value="<%=bankAccount%>"  onblur="clearNoNumZ(this);return checkMinlength(this);"/>
				<div class="text-magnifier fn-hide" id="textMag"  >
				<div id="mag-text" class="mag-text"></div>
				<div class="mag-explain">���п����������30λ����</div>
			</td>
			<td class="title" width="13%">�˺�ȷ��<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
			<div id="main">
				<input type="text" style="width: 99%" maxlength="30" class="input" id="bankAccount2" name="bankAccount2" value="<%=bankAccount%>" onblur="checkBankAccount();return checkMaxlength(this);"/>
				<div class="text-magnifier fn-hide" id="textMag"  >
				<div id="mag-text" class="mag-text"></div>
				<div class="mag-explain">���п����������30λ����</div>
			</td>
			<td class="title" width="13%">�˺�����<span style="color: red;">*</span></td>
			<td class="input" width="20%" colspan="2">
				<div id="accountFlag0" <%if(accountType.equals("2")){ %>style="display:none"<%} %>>
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <%if(accountFlag.equals("00")){%>checked='checked'<%} %> value="00">���п�
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <%if(accountFlag.equals("01")){%>checked='checked'<%} %> value="01">����
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <%if(accountFlag.equals("02")){%>checked='checked'<%} %> value="02">���ÿ�
				</div>
				<div id="accountFlag1" <%if(accountType.equals("1")){ %>style="display:none"<%} %>>
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <%if(accountFlag.equals("03")){%>checked='checked'<%} %> value="03"/>�Թ��˻�
				</div>
			</td>
			
		</tr>
		<tr>
			<td class="title">��ϸ��ַ
			</td>
			<td class="input" width="43%" colspan="3">
				<input type="text" style="width: 99%" class="input" id="address" name="address" value="<%=address %>"  maxlength="100" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">�ֻ�����
			</td>
			<td class="input" width="20%" >
				<input type="text" style="width: 99%" class="input" id="mobilePhone" name="mobilePhone" value="<%=mobilePhone %>"  maxlength="30" onblur="return checkMaxlength(this);"/>
			</td>
		</tr>
		<tr>
			<td class="title" >֧����ʽ<span style="color: red;">*</span>
			</td>
			<td class="input">
				<input type="radio" style="border: 0px;" id="payWay" name="payWay" checked <%if("1".equals(payWay)){ %>checked='checked'<%} %> value="1" onclick="refuseBefore()">������֧��
			</td>
			<td class="title" >֧��ԭ��
			</td>
			<td class="input">
				<input type="text" id="payReason" name="payReason" value="<%=payReason %>" class="readonly" readonly/>
			</td>
			<td class="title">��;˵��
			</td>
			<td class="input" colspan="2">
				<input class="input"  style="width: 99%"  type="text" id="payPurpose" name="payPurpose" value="<%=payPurpose %>" maxLength="100" onblur="checkMaxlength(this);"/>
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
</div>