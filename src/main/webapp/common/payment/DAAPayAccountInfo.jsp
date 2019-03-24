<%@page import="com.sinosoft.claim.ui.control.action.UICodeAction"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
/* 选择城市样式 */
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
	function selectAccount(){
		var nodeType=fm.nodeType.value;
		var urlStr="";
		var registNo=fm.registNo.value;
		if(nodeType!=null&nodeType=="apay"){
			var registNos = document.getElementsByName("registNoPay");
			for(var a=0;a<registNos.length;a++){
				urlStr+="&registNo="+registNos[a].value;
			}
		}
		var url = "/claim/selectAccount.do?nodeType="+nodeType+"&registNo="+registNo+urlStr;
		var returnValue = window.showModalDialog(url,window,"dialogWidth=720px;dialogHeight=300px");
		if(returnValue!=undefined && typeof(returnValue)!='string'  &&  returnValue[0] == "true"){
			$("select[name='urgentType']").val(returnValue[1]);
			$("select[name='receiverTypeOther']").val(returnValue[2]);
			$("input[name='receiverTypeOtherName']").val(returnValue[3]);
			$("input[name='receiverFullName']").val(returnValue[4]);
			$("input[name='receiverFullCode']").val(returnValue[5]);
			$("select[name='certifType']").val(returnValue[6]);
			$("input[name='certifNo']").val(returnValue[7]);
			$("input[name='bankType']").val(returnValue[8]);
			$("input[name='bank']").val(returnValue[9]);
			$("input[name='bankAccount']").val(returnValue[10]);
			$("input[name='familyPhone']").val(returnValue[11]);
			$("input[name='officePhone']").val(returnValue[13]);
			$("input[name='mobilePhone']").val(returnValue[13]);
			$("input[name='address']").val(returnValue[14]);
			$("input[name='qqNumber']").val(returnValue[15]);
			$("input[name='email']").val(returnValue[16]);
			$("input[name='postCode']").val(returnValue[17]);
			$("input[name='unitLink']").val(returnValue[18]);
			
		}
	}
	/**
	* 验证页面要素的必录项
	*
	*/
	function checkAccountInput(){
	var payAmount = $("input[name='payAmount']").val();
       if(parseFloat(payAmount)<=0){
       
       }else{
       	   var pro = $("#pro").val();
       	   if(typeof(pro)=="undefined"||pro==""){
       	   		alert("省份名称不能为空");
       	   		return false;
       	   }
       	   var btn_hukou = $("#btn_hukou").val();
       	   if(typeof(btn_hukou)=="undefined"||btn_hukou==""){
       	   		alert("城市名称不能为空");
       	   		return false;
       	   }
       	   var accountType = $("input[name=accountType]:checked").val();
       	   if(typeof(accountType)=="undefined"||accountType==""){
       	   		alert("账户属性不能为空");
       	   		return false;
       	   }
       
	       var bankType = $("#citySelect").val();
			if(typeof(bankType) == "undefined"||bankType==""||bankType.trim()==""){
	    		alert("银行大类不能为空");
	    		return false;
	    	}
			/*var bankTypeName = $("#bankTypeName").val();
			if(typeof(bankTypeName) == "undefined"||bankTypeName==""){
	    		alert("银行大类不能为空");
	    		return false;
	    	}*/
			var bank = $("#bank").val();
			if(typeof(bank) == "undefined"||bank==""||bank.trim()==""){
	    		alert("开户银行不能为空");
	    		return false;
	    	}
	    	var bankNumber = $("#bankCNameCodeId").val();
	    	if(typeof(bankNumber) == "undefined"||bankNumber==""||bankNumber.trim()==""){
	    		alert("联行号不能为空");
	    		return false;
	    	}
			var bankAccount = $("#bankAccount").val();
			if(typeof(bankAccount) == "undefined"||bankAccount==""||bankAccount.trim()==""){
	    		alert("银行账号不能为空");
	    		return false;
	    	}
			var bankAccount2 = $("#bankAccount2").val();
			if(typeof(bankAccount2) == "undefined"||bankAccount2==""||bankAccount2.trim()==""){
	    		alert("账号确认不能为空");
	    		return false;
	    	}
			if(bankAccount!=bankAccount2){
				alert("两次账号输入不一致");
				return false;
			}
			
			var accountFlag = $("input[name=accountFlag]:checked").val();
	       	   if(typeof(accountFlag)=="undefined"||accountFlag==""){
	       	   		alert("账号类型不能为空");
	       	   		return false;
	       	   }
       }
		
		return true;
	}
	//验证确认账号是否与账号一致
	function checkBankAccount(){
		var bankAccount = $("#bankAccount").val();
		var bankAccount2 = $("#bankAccount2").val();
		if(typeof(bankAccount2) == "undefined"||bankAccount2==""||bankAccount2.trim()==""){
    		alert("账号确认不能为空");
    		return false;
    	}
		if(bankAccount!=bankAccount2){
			alert("两次账号输入不一致");
			return false;
		}
		return true;
	}
	//工作转交机构弹出窗口函数
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
	//只能输入数字的文本框
	function clearNoNumZ(obj)
	{
	 //先把非数字的都替换掉，除了数字
	 obj.value = obj.value.replace(/[^\d\-]/g,"");
	 fireChangeComm(obj);
	}
	
	//校验个人和单位的账号类型
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
function openpage(){
window.open("/claim/DAA/payment/paypage.jsp?","客户信息",'width=1300,height=1000,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
//by goudexuan 2017/12/7 给 银行大类,银行账号,账号确认,账号属性,账号类型 赋值  bagin
function data8(a){
if(trim(a)=="借记卡"){
 $('input:radio[name="accountType"][value="1"]').attr("checked","checked");
 setAccountFlag('1');
}
 if($('input:radio[name="accountType"][value="1"]').attr("checked","checked")){
$('input:radio[name="accountFlag"][value="00"]').attr("checked","checked");
} 
}
function data9(b){
document.getElementById("bankAccount").value=document.getElementById("bankAccount2").value=trim(b);
clearNoNumZ(document.getElementById("bankAccount"));clearNoNumZ(document.getElementById("bankAccount2"));
checkBankAccount();
}
function data10(c){
document.getElementById("bank").value=document.getElementById("citySelect").value=trim(c); 
}
function getBank_number(){
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
		,error:function(){alert('系统异常！');}
	});
}
function checkNumber(){
	var reg = /^\d+$/;
	if(fm.routeNum.value.length>0){
		if(fm.routeNum.value.length!=12){
		alert("联行号长度必须为12位！");
		$('#bankCNameCodeId').val("");
		return;
		}
		if(reg.test(fm.routeNum.value)==false){
		alert("联行号只允许录入数字！");
		$('#bankCNameCodeId').val("");
		}
	}
}

function queryAccount(){
	window.open('/claim/DAA/payment/BankInfosearchmain.jsp','_blank','width=800,height=600,toolbar=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0')
}
</script>
<div id="content_basic" style="width: 98%" name="accountInfoDiv">
	<span style="text-align: left; width: 99%;font-size:12px ">
		<img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
			name="RegistExtImg" onclick="showPage(this,accountInfo)">&nbsp;账户信息
			<img style="cursor:hand;" src="/claim/images/OCR.jpg" alt="OCR" onclick="openpage()">
	</span>
	<table class="common" id="accountInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<td class="title" width="13%">省份名称<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
			<input style="width: 99%" id='pro' type="text" value="${prpLpayGatherDto.provinceCode }" name="provinceCode" class="readOnly" readonly="readonly"/>
			<!--  
			<input type="hidden" name="OpenProvinceCode" value="">
			
				<select id="provinceCode"   onchange="selectCity();">
                    <option value="${prpLpayGatherDto.provinceCode }" selected="selected"></option>                      
                 </select>
             -->
			</td>
			<td class="title" width="13%">城市名称<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
			<c:if test="${editType ne 'SHOW' }">
			<input id="btn_hukou" name="cityCode" style="width: 99%" type="text"  onclick="hukouSelect()" value="${prpLpayGatherDto.cityCode }"/>
			</c:if>
			<c:if test="${editType eq 'SHOW' }">
			<input id="btn_hukou" name="cityCode" style="width: 99%" type="text"   readOnly value="${prpLpayGatherDto.cityCode }"/>
			</c:if>
			<!-- 
				<input type="hidden"  value="${prpLpayGatherDto.cityCode }">
			 <select id="cityCode" name="cityCode" >
                   <option value="${prpLpayGatherDto.cityCode }" selected="selected"></option>                      
             </select>
            -->
            
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
			<td class="title" width="13%">账号属性<span style="color: red;">*</span>
			</td>
			<td class="input" width="" colspan="3">
				<input type="radio" style="border: 0px;" id="accountType" name="accountType" <c:if test="${prpLpayGatherDto.accountType eq '1' }">checked='checked'</c:if> value="1" onclick="setAccountFlag('1');">个人账号
				<input type="radio" style="border: 0px;" id="accountType" name="accountType" <c:if test="${prpLpayGatherDto.accountType eq '2' }">checked='checked'</c:if> value="2" onclick="setAccountFlag('2');">单位账号
			</td>
		</tr>
		<tr>
			<td class="title" width="13%">银行大类<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<!--  
            	<input type="hidden" class = "cityinput" id="citySelect" name="bankType" value="" />
            	-->
            <c:if test="${editType ne 'SHOW' }">
			<div class="inputbox">
				<input name="bankType" type="text" value="${prpLpayGatherDto.bankType}" id="citySelect" onclick="suggestF.display(this,'',event);" onkeydown="item_suggest.item_display(this,'',event);" onblur="item_suggest.item_onblur(this);" class="stext" />
			</div>
            </c:if>	
            <c:if test="${editType eq 'SHOW' }">
            	<input type="text" style="width: 99%" class="cityinput" id="citySelect" name="bankType" value="${prpLpayGatherDto.bankType}" readonly="readonly">
            </c:if>	
            	
			</td>
			<td class="title" width="13%">
			开户银行<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%" >
			<!-- <div class="inputbox1"> -->
			<div>
				<input name="bank" style="width: 99%" maxlength="150"  style="width: 588px;" type="text"  value="${prpLpayGatherDto.bank}"   id="bank"   onkeyup="item_suggest1.item_display1(this,'',event);" class="stext" />
			</div>
			<%-- <input  class="common"  type="hidden" name="routeNum" id ="bankCNameCodeId" value="${prpLpayGatherDto.routeNum}"/> --%>
			</td>
			<td class="title" width="13%">联行号<span style="color: red;">*</span>
			</td>
			<td class="input" width="14%" colspan="2">
				<input  class="common" style="width: 98%" type="text"   name="routeNum" id ="bankCNameCodeId" value="${prpLpayGatherDto.routeNum}" onclick="getBank_number();" onblur="checkNumber();"/>
				<input name="Insertflag" type="hidden" value="0" id="Insertflag" />
				<input name="routeNumold" type="hidden" value="" id="bankCNameCodeIdold" />
			</td>
			<td class="input" width="4%" align="center">
				<input type="button" class="button" onclick ="queryAccount();" value="支行查询"/>
			</td>
			
		</tr>
		<tr>
			<td class="title" width="13%">银行账号<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<div id="main">
				<input type="text" style="width: 99%" maxlength="30"  class="input" id="bankAccount" name="bankAccount" value="${prpLpayGatherDto.bankAccount}"  onblur="clearNoNumZ(this);return checkMaxlength(this);"/>
				<div class="text-magnifier fn-hide" id="textMag"  >
				<div id="mag-text" class="mag-text"></div>
				<div class="mag-explain">银行卡号码最多是30位数字</div>
			</td>
			<td class="title" width="13%">账号确认<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
			<div id="main">
				<input type="text" style="width: 99%" maxlength="30" class="input" id="bankAccount2" name="bankAccount2" value="${prpLpayGatherDto.bankAccount}" onblur="checkBankAccount();" onblur="return checkMaxlength(this);"/>
				<div class="text-magnifier fn-hide" id="textMag"  >
				<div id="mag-text" class="mag-text"></div>
				<div class="mag-explain">银行卡号码最多是30位数字</div>
			</td>
			<td class="title" width="13%">账号类型<span style="color: red;">*</span></td>
			<td class="input" width="14%" colspan="2">
				<div id="accountFlag0" <c:if test="${prpLpayGatherDto.accountType eq '2' }">style="display:none"</c:if>>
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <c:if test="${prpLpayGatherDto.accountFlag eq '00' }">checked='checked'</c:if> value="00">银行卡
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <c:if test="${prpLpayGatherDto.accountFlag eq '01' }">checked='checked'</c:if> value="01">存折
					<!-- <input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <c:if test="${prpLpayGatherDto.accountFlag eq '02' }">checked='checked'</c:if> value="02">信用卡 -->
				</div>
				<div id="accountFlag1" <c:if test="${prpLpayGatherDto.accountType eq '1' }">style="display:none"</c:if>>
					<input type="radio" style="border: 0px;" id="accountFlag" name="accountFlag" <c:if test="${prpLpayGatherDto.accountFlag eq '03' }">checked='checked'</c:if> value="03"/>对公账户
				</div>
			</td>
			<td class="input" width="4%" align="center">
					<input type="button" class="button" onclick ="SynchAccount();" value="同步账号"/>
			</td>
		</tr>
		<tr>
			<td class="input" colspan="8">
			<span style="color: red;">
			联行号录入提示：
			<br>1、开户银行录入时系统会根据录入的开户银行名称自动匹配，匹配成功后自动带入联行号且不可修改；
			2、若系统无法自动匹配则可以手工录入联行号；
			<br>3、【银行信息查询】菜单提供根据省市大类等信息查询联行号功能；
			4、外网联行号查询地址：https://www.hebbank.com/corporbank/otherBankQueryWeb.do
			<br>5、联行号录入是否正确将直接影响支付结果，且联行号为数字12位；
			6、若开户银行不存在对应联行号可录入总行对应联行号
			</span>
			</td>
		</tr>
<%--  		<tr>
		  <td class="title" width="13%">开户银行<span style="color: red;">*</span>
			</td>
			<td class="input" width="43%" colspan="3">
			 <div class="inputbox1">
				<input name="bank" maxlength="300"  style="width: 588px;" type="text"  value="${prpLpayGatherDto.bank}"   id="bank" onkeyup="item_suggest1.item_display1(this,'',event);" class="stext" />
			</div>
			</td>
			<td class="title" width="13%">支付行号</td>
			<td class="input" width="20%" colspan="3">
			<input  class="common"  type="text" name="routeNum" id ="bankCNameCodeId" value="${prpLpayGatherDto.routeNum}"/>
			</td>
		</tr>  --%>
	</table>
</div>