<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	/**
	* ��������͸�����������
	*
	*/
	function changeReceiver(obj){
		var receiverVal = $(obj).find("option[selected]").val();
		if(receiverVal!=""){
			if(receiverVal=="t01"){//���������Զ�����
				var bbxrType = $("#bbxrInsuredType").val();
				if(bbxrType!=null&&bbxrType=="1"){//����
					$("input[name='accountType'][value='1']").removeAttr("disabled");
					$("input[name='accountType'][value='1']").attr("checked","checked");
					$("input[name='accountType'][value='2']").attr("disabled","disabled");
					$("#accountFlag0").css("display","");
					$("#accountFlag1").css("display","none");
					$("input:radio[name=accountFlag][value='03']").attr('checked','');
				}else if (bbxrType=="2"){//��λ
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
				$("#receiverTypeOtherName").val("��������");
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
					$("#receiverTypeOtherName").val("�鿱ֱ������");
				}else if(receiverVal=="t03"){
					$("#receiverTypeOtherName").val("����������λ");
				}else if(receiverVal=="t04"){
					$("#receiverTypeOtherName").val("�鿱��Ա");
					$("input[name='accountType'][value='1']").removeAttr("disabled");
					$("input[name='accountType'][value='1']").attr("checked","checked");
					$("input[name='accountType'][value='2']").attr("disabled","disabled");
					$("#accountFlag0").css("display","");
					$("#accountFlag1").css("display","none");
					$("input:radio[name=accountFlag][value='03']").attr('checked','');
				}else if(receiverVal=="t05"){
					$("#receiverTypeOtherName").val("����Ժ");
				}else if(receiverVal=="t06"){
					$("#receiverTypeOtherName").val("��������");
				}else if(receiverVal=="t07"){
					$("#receiverTypeOtherName").val("���ά�޵�λ");
				}else if(receiverVal=="t08"){
					$("#receiverTypeOtherName").val("�������");
				}else if(receiverVal=="t09"){
					$("#receiverTypeOtherName").val("��Ԯ����");
				}else if(receiverVal=="t10"){
					$("#receiverTypeOtherName").val("��������");
				}else if(receiverVal=="t11"){
					$("#receiverTypeOtherName").val("��ʦ����");
				}else if(receiverVal=="t14"){
					$("#receiverTypeOtherName").val("�ܺ���Ա");
				}else if(receiverVal=="t15"){
					$("#receiverTypeOtherName").val("����ҽԺ");
				}else if(receiverVal=="t16"){
					$("#receiverTypeOtherName").val("��������");
				}else if(receiverVal=="t17"){
					$("#receiverTypeOtherName").val("��������");
				}else if(receiverVal=="t18"){
					$("#receiverTypeOtherName").val("�ٲû���");
				}else if(receiverVal=="t19"){
					$("#receiverTypeOtherName").val("�໤��");
				}else if(receiverVal=="t20"){
					$("#receiverTypeOtherName").val("ί�д�����");
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
	* ��֤ҳ��Ҫ�صı�¼��
	*
	*/
    function checkBaseInput(){
       //������֧���������֧����Ϣ��֧�����Ϊ��������ʱ��ֻ��¼��֧�����󼴿�
       var payAmount = $("input[name='payAmount']").val();
       if(parseFloat(payAmount)<=0){
       		var receiverFullName = $("#receiverFullName").val();
	    	if(typeof(receiverFullName) == "undefined"||receiverFullName==""||receiverFullName.trim()==""){
	    		alert("��������Ʋ���Ϊ��");
	    		return false;
	    	}
       }else{
	       var payType = $("input[name='payType']").val();
	    	if(typeof(payType) == "undefined"||payType==""){
	    		alert("֧�����Ͳ���Ϊ��");
	    		return false;
	    	}
	    	var receiverTypeOther = $("select[name='receiverTypeOther'] option[selected]").val();
	    	if(typeof(receiverTypeOther) == "undefined"||receiverTypeOther==""){
	    		alert("��������Ͳ���Ϊ��");
	    		return false;
	    	}
	    	var receiverFullName = $("#receiverFullName").val();
	    	if(typeof(receiverFullName) == "undefined"||receiverFullName==""||receiverFullName.trim()==""){
	    		alert("��������Ʋ���Ϊ��");
	    		return false;
	    	}
	    	var receiverVal = $("select[name='receiverTypeOther'] option[selected]").val();
	    	if(receiverVal!='t05' && receiverVal!='t15'&& receiverVal!='t16'&& receiverVal!='t17'){
		    	var certifType = $("select[name='certifType'] option[selected]").val();
		    	if(typeof(certifType) == "undefined"||certifType==""||certifType=="00"){
		    		alert("�����֤�����Ͳ���Ϊ��");
		    		return false;
		    	}
		    	var certifNo =  $("#certifNo").val();
		    	if(typeof(certifNo) == "undefined"||certifNo==""||certifNo.trim()==""){
		    		alert("�����֤�����벻��Ϊ��");
		    		return false;
		    	}
	    	}
	    	if(receiverVal=='t12' || receiverVal=='t13'){
		    	var receiverTypeOtherName = $("#receiverTypeOtherName").val();
		    	if(typeof(receiverTypeOtherName) == "undefined"||receiverTypeOtherName==""||receiverTypeOtherName.trim()==""){
		    		alert("�����������Ϊ��������ʱ�����������¼�����Ϊ��");
		    		return false;
		    	}
	    	}
       		//��ͬ�������˴���ģ�����ѡ�񱻱�����
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
	    	//		alert("ֻ�кϲ��İ���Ϊͬһ�������˵ģ�������ѡ�񡰱������ˡ�");
	    	//		return false;
	    	//	}
	    	//}
       }
       
       
    	
    	return true;
    }
	/**
	* �������������Ϊ����ʱ�������������
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
			//ѡ�񡰹�����������ʦ�����������������������������������Ԯ�������Ⱥ����������˺���Ϣ���룬�Ҳ����޸ġ�
			//$("input[name='bankType']").attr("readOnly","readOnly");
			//$("input[name='bank']").attr("readOnly","readOnly");
			//$("input[name='bankAccount']").attr("readOnly","readOnly");
			//$("input[name='bankType']").attr("readOnly","readOnly");
			$("input[name='bankType']").removeAttr("readOnly");
			$("input[name='bank']").removeAttr("readOnly");
			$("input[name='bankAccount']").removeAttr("readOnly");
			$("input[name='receiverFullName']").removeAttr("readOnly");
			$("input[name='certifNo']").removeAttr("readOnly");//֤������
			$("select[name='certifType']").unbind("blur");
			
		}else if(feild.value == "t01"){//��������
			$("#receiverTypeOthersBtn").attr("disabled","disabled");
			$("#receiverTypeOthersBtn").unbind("click");
		}else{
			$("#receiverTypeOthersBtn").attr("disabled","disabled");
			$("#receiverTypeOthersBtn").unbind("click");
			$("input[name='bankType']").removeAttr("readOnly");
			$("input[name='bank']").removeAttr("readOnly");
			$("input[name='bankAccount']").removeAttr("readOnly");
			$("input[name='receiverFullName']").removeAttr("readOnly");
			$("input[name='certifNo']").removeAttr("readOnly");//֤������
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
			
			$("input[name='certifNo']").attr("readOnly","readOnly");//֤������
			$("select[name='certifType']").bind("blur",function(){$("select[name='certifType']").val("73");},0);//֤������
			
		}
	}
	
	//У��ֲ�����
	function checkTerrorist(){

		var AppliInsuredInsuredName=fm.receiverFullName.value;

		var AppliInsuredIdentifyNumber = fm.certifNo.value;
	  	  var vURL = "/claim/uiCheckTerrorist.do?AppliInsuredInsuredName="+AppliInsuredInsuredName+"&AppliInsuredIdentifyNumber="+AppliInsuredIdentifyNumber;
	  	  var xmlText = getResponseText(vURL);
         if(xmlText!=null && "1"==xmlText) {
        	alert("�ÿͻ�����Ϊ�ֲ����ӣ���ȷ�ϣ�");
        	return false;
        	}
        	return true;
	}
	//ʹ��xmlhttp����ҳ�棬����ȡ����
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
    alert("�Ҳ���ҳ�棺"+ strURL);
    return "";
  }
  else
  {
    alert("����"+ strURL +"��������ţ�"+objXmlHttp.status);
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
			if(returnValue[10]=="1"){//�˺����� 1���� 2��λ
				$("input[name='accountType'][value='1']").attr("checked","checked");
				$("#accountFlag0").css("display","");
				$("#accountFlag1").css("display","none");
				$("input:radio[name=accountFlag][value='03']").attr('checked','');
				if(returnValue[9]=="00"){//�˺����� 00���п� 01���� 02���ÿ� 03�Թ��˻�
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
			name="RegistExtImg" onclick="showPage(this,baseInfo)">&nbsp;������Ϣ
	</span>
	<table class="common" id="baseInfo" cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
		<tr>
			<td class="title" width="13%">
				�ո����
			</td>
			<td class="input" width="20%">
				<input type="text" style="width: 99%" readOnly class="readOnly" name="paymentNo" value="${prpLpayGatherDto.paymentNo }" />
				<input type="hidden" name="payType" value="${prpLpayGatherDto.payType}">
			</td>
<!--  
			<td class="title" width="13%">֧������<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<select class="query" name="payType"<c:if test="${nodeType ne 'check' and nodeType ne 'certa' and nodeType ne 'CertifDirect' }">  onchange="changeValueReload();"</c:if> >
					<option <c:if test="${prpLpayGatherDto.payType eq 'P1' }">selected</c:if> value="P1">Ԥ�����</option>
				    <option <c:if test="${prpLpayGatherDto.payType eq 'P2' }">selected</c:if> value="P2">֧�����</option>
    				<option <c:if test="${(prpLpayGatherDto.payType eq 'P3') or (prpLpayGatherDto.payType eq '') }">selected</c:if> value="P3" >�᰸�⸶</option>
				    <option <c:if test="${prpLpayGatherDto.payType eq 'P4' }">selected</c:if> value="P4">�渶���</option>
				</select>
			</td>-->
			<td class="title" width="13%">
				���������<span style="color:red;">*</span>
			</td>
			<td class="input" width="10%">
				<input type="hidden" id="receiverTypeOtherName" name="receiverTypeOtherName" value="${prpLpayGatherDto.receiverTypeOtherName}"  maxlength="100" onblur="return checkMaxlength(this);" />
				<select class="query" name="receiverTypeOther" onchange="changeReceiver(this);setFun(this)" >
					<option value="">��ѡ��</option>
					<!-- add by wangxinyang ��ũ��������������� 2018-8-8 19:56:20 -->
<%
		String newAgriFlag = (String)request.getAttribute("newAgriFlag");
		if(newAgriFlag!=null && "newAgri".equals(newAgriFlag)){
 %>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't01' }">selected</c:if> value="t01">Ͷ����</option>
					<c:if test="${(Datatype ne 'mergeMany') or (hasbbxrSelect eq 'true') }">
						<option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't02' }">selected</c:if> value="t02">��������</option>
					</c:if>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't03' }">selected</c:if> value="t03">������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't04' }">selected</c:if> value="t04">��������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't05' }">selected</c:if> value="t05">������λ</option>
<%
		}else{
 %>
					<c:if test="${(Datatype ne 'mergeMany') or (hasbbxrSelect eq 'true') }">
						<option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't01' }">selected</c:if> value="t01">��������</option>
					</c:if>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't14' }">selected</c:if> value="t14">�ܺ���Ա</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't02' }">selected</c:if> value="t02">�鿱ֱ������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't03' }">selected</c:if> value="t03">����������λ</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't07' }">selected</c:if> value="t07">���ά�޵�λ</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't04' }">selected</c:if> value="t04">�鿱��Ա</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't05' }">selected</c:if> value="t05">����Ժ</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't18' }">selected</c:if> value="t18">�ٲû���</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't11' }">selected</c:if> value="t11">��ʦ����</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't06' }">selected</c:if> value="t06">��������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't08' }">selected</c:if> value="t08">�������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't09' }">selected</c:if> value="t09">��Ԯ����</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't10' }">selected</c:if> value="t10">��������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't15' }">selected</c:if> value="t15">����ҽԺ</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't16' }">selected</c:if> value="t16">��������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't17' }">selected</c:if> value="t17">��������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't19' }">selected</c:if> value="t19">�໤��</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't20' }">selected</c:if> value="t20">ί�д�����</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't12' }">selected</c:if> value="t12">��������</option>
				    <option <c:if test="${prpLpayGatherDto.receiverTypeOther eq 't13' }">selected</c:if> value="t13">������λ</option>
<%
		}
 %>
				</select>
			</td>
			<td class="input" width="10%" colspan="1">
				<c:if test="${prpLpayGatherDto.receiverTypeOther eq 't12' or prpLpayGatherDto.receiverTypeOther eq 't13'}">
					<input type="text" style="width: 99%;"  class="input" id="receiverTypeOthers" name="receiverTypeOthers" onblur="checkMaxlength(this);setValue(this);" value="${prpLpayGatherDto.receiverTypeOtherName }"   maxlength="100"/>
					<input type="button" class="button" style="display: none;"  id="receiverTypeOthersBtn" value="�����б�" onclick="";/>
				</c:if>
				<c:if test="${prpLpayGatherDto.receiverTypeOther ne 't12' and prpLpayGatherDto.receiverTypeOther ne 't13'}">
					<input type="text" style="width: 99%;display: none;"  class="input" id="receiverTypeOthers" name="receiverTypeOthers" onblur="checkMaxlength(this);setValue(this);" readOnly value=""    maxlength="100"/>
					<input type="button"  class="button" style="" id="receiverTypeOthersBtn" value="�����б�" />
				</c:if>
			</td>
			<td class="title">
				���������<span style="color:red;">*</span>
			</td>
			<td class="input">
				<input type="text" class="input" style="width: 55%" id="receiverFullName" name="receiverFullName" value="${prpLpayGatherDto.receiverFullName}" maxlength="100" onblur="return checkMaxlength(this);"/>
				<c:if test="${editType eq 'SHOW' }">
					<input type="button"  class="button"  id="payeeInfo" name="payeeInfo" value="�������Ϣ" onclick="";/>
				</c:if>
				<c:if test="${editType ne 'SHOW' }">
					<input type="button"  class="button"  id="payeeInfo" name="payeeInfo" value="�������Ϣ" onclick="getPayeeInfo()";/>
				</c:if>
				<input type="hidden" name="newAgriFlag" value="<%=newAgriFlag %>">
				<input type="hidden" id="receiverFullCode" name="receiverFullCode" value="${prpLpayGatherDto.receiverFullCode}"/>
			</td>
		</tr>
		<tr>
			
			<td class="title" width="13%">�����֤������<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%">
				<select class="query" name="certifType" style="width: 99%">
					<option <c:if test="${prpLpayGatherDto.certifType eq '00' }">selected</c:if> value="00">��ѡ��</option>
					<option <c:if test="${prpLpayGatherDto.certifType eq '01' }">selected</c:if> value="01">�������֤</option>
				    <option <c:if test="${prpLpayGatherDto.certifType eq '02' }">selected</c:if> value="02">���񻧿ڱ�</option>
				    <option <c:if test="${prpLpayGatherDto.certifType eq '04' }">selected</c:if> value="04">����֤</option>
				    <option <c:if test="${prpLpayGatherDto.certifType eq '05' }">selected</c:if> value="05">ʿ��֤</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '07' }">selected</c:if> value="07">�й�����</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '51' }">selected</c:if> value="51">�������</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '71' }">selected</c:if> value="71">��֯��������֤</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '72' }">selected</c:if> value="72">˰��Ǽ�֤</option>
    				<option <c:if test="${prpLpayGatherDto.certifType eq '73' }">selected</c:if> value="73">Ӫҵִ��</option>
				</select>
			</td>
			<td class="title" width="13%">֤������<span style="color: red;">*</span>
			</td>
			<td class="input" width="20%" colspan="2">
				<input type="text" class="input" style="width: 99%" id="certifNo" name="certifNo" value="${prpLpayGatherDto.certifNo}" maxlength="20" onblur="return checkMaxlength(this);"/>
			</td>
			<td class="title" width="13%">�����̶�
			</td>
			<td class="input" width="20%">
				<select class="query" name="urgentType" style="width: 99%">
					<option value="">��ѡ��</option>
					<option <c:if test="${prpLpayGatherDto.urgentType eq '0.5' }">selected</c:if> value="0.5">30����</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '1' }">selected</c:if> value="1">1Сʱ</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '2' }">selected</c:if> value="2">2Сʱ</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '3' }">selected</c:if> value="3">3Сʱ</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '4' }">selected</c:if> value="4">4Сʱ</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '8' }">selected</c:if> value="8">8Сʱ</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '24' }">selected</c:if> value="24">24Сʱ</option>
				    <option <c:if test="${prpLpayGatherDto.urgentType eq '48' }">selected</c:if> value="48">48Сʱ</option>
				</select>
			</td>
		</tr>
	</table>
</div>
		