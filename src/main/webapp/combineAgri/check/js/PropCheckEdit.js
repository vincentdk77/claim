/*****************************************************************************
 * DESC       ���鿱�ǼǵĽű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-06-03
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ���鿱�Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 
function checkForm()
{
    return true;
}
/**
 *@description �ύ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function submitForm()
{
  if(checkForm()==false)
  {
    return false;
  }

  fm.buttonSave.disabled = true;
  fm.submit();
  return true;
}

/**
 *@description ����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function resetForm()
{
  if(window.confirm("ȷ��Ҫ������"))
  {
    location.href = location.href;
    return true;
  }
  else
  {
    return false;
  }
}

function save(field){
   fm.buttonSaveType.value ="4";
   field.disabled = true;
   fm.submit();
}
/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function saveForm(field,saveType)
{
  //add by liuyanmei 20051115 start 
	var  prpLcheckDamageStartDate = fm.prpLcheckDamageStartDate.value;
	prpLcheckDamageStartDate=prpLcheckDamageStartDate.substring(0,10);
	var  prpLcheckCheckDate  = fm.prpLcheckCheckDate.value;
	if ( prpLcheckCheckDate >= prpLcheckDamageStartDate ){
	  } 
        else {
	   alert("�鿱���ڲ����ڳ�������֮ǰ����");
	   return false;
	}
	//add by liuyanmei 20051115 end
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //��ֵ��ѡ���ֵ	
	 
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "�鿱���治����Ϊ��;\n";
  }     
 //add by qinyongli 2005-9-6 �鿱���ж�
  var Checker1 = fm.prpLcheckChecker1.value;
  var Checker2 = fm.prpLcheckChecker2.value;
  if(Checker1==Checker2){
    errorMessage = errorMessage + "�鿱�� 1�Ͳ鿱�� 2����Ϊͬһ��;\n";
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
   if(!validateForm(fm))
  {
    return false;
  }
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave(){
   
   var businessNo = fm.prpLcheckRegistNo.value;
   var policyNo = fm.prpLcheckPolicyNo.value;
   var riskCode = fm.prpLcheckRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=check&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLcheckRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}


//Modify By sunhao add begin 2004-09-06
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){	
		var policyNo = fm.prpLcheckPolicyNo.value;
		var registNo = fm.prpLcheckRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}
//Modify By sunhao add end 2004-09-06


/**
 *@description ���û���ĳ�ʼֵ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{
	var countShow = getElementCount("registNoShow");
	for(var i=0;i<countShow;i++){
		//�ж��Ƿ��ǹ�����
	    var coinsFlag = fm.all("coinsFlag_"+i).value;	
	    var shareHolderFlag = fm.all("shareHolderFlag_"+i).value;
	    var tempReinsFlag = fm.all("tempReinsFlag_"+i).value;
	    var message = "";
	    if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
	    	message = message + "������Ϊ��/��������\n";
	    }
	    if(shareHolderFlag!=0){
	  	message = message + "�˱���Ϊ�ɶ�ҵ��";
	    }
	    if(tempReinsFlag!=0){
	  	message = message + "�˱������ٷ�ҵ��";
	    }
	    if (message.length>0) {
	    alert(message);
	    } 
	    break;
	}
	
	for(var index = 0;index<countShow;index++){
	  var sumloss    = "prpLpropSumLoss_"+index;
	  var sumreject  = "prpLpropSumReject_"+index;
	  var sumdefloss = "prpLpropSumDefLoss_"+index;
	  var sumvalue = 0;
	  var sumallvalue = 0;    
	 
	  for(i=1;i<fm.all(sumloss).length;i++)
	  {
	    sumvalue = fm.all(sumloss)[i].value; 

	    if(isNaN(sumvalue)||sumvalue.length<1){
	      sumvalue = 0;
	    }
	    if(isNaN(sumallvalue)||sumallvalue.length<1)
	    sumallvalue = 0;
	    sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
	  } 
	  fm.all("prpLpropSumSumLoss_"+index).value=point(round(sumallvalue,2),2); 

	  sumallvalue=0;
	  for(i=1;i<fm.all(sumreject).length;i++)
	  {
	    sumvalue = fm.all(sumreject)[i].value;  

	    if(isNaN(sumvalue)||sumvalue.length<1)
	    sumvalue = 0;
	    if(isNaN(sumallvalue)||sumallvalue.length<1)
	    sumallvalue = 0;
	    
	    sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
	  } 
	  fm.all("prpLpropSumSumReject_"+index).value=point(round(sumallvalue,2),2); 
	  
	  sumallvalue=0;
	  for(i=1;i<fm.all(sumdefloss).length;i++)
	  {
	    sumvalue = fm.all(sumdefloss)[i].value;  
	    if(isNaN(sumvalue)||sumvalue.length<1) {
	      sumvalue = 0; 
	    }
	    if(isNaN(sumallvalue)||sumallvalue.length<1){
	      sumallvalue = 0; 
	    }
	    sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
	  }  
	  fm.all("prpLpropSumSumDefLoss_"+index).value=point(round(sumallvalue,2),2); 
	  //sumRepairFee();
	  //sumComponentFee();
	  //zzzzzzzzzzzsumPersonLossFee(index);
	  //zzzzzzzzzsumPreDefLoss(index);
	}
    return true;
}

/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet1() 
{ 
  return true;
}

//��ť�����¼���������ͬ��������౨������ʾ
function buttonOnClick(strSubPageCode)
{
   var sameCount = parseInt(fm.PerilCount.value);
  
  if (sameCount <1) 
  {
  	fm.button_Peril_Open_Context.disabled = true;
  	return;
  }
  showSubPage1(strSubPageCode);
 
}

	
//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage1(spanID,leftMove) 
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;
  
  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y
  
  ex = ex - 520;
 
  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;
  ey = ey+10;
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 

/**
*@description �������������嵥 
*@param       businessNo 
*@add by qinyongli 2005-8
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
} 
/**
 *@description ������֤ҳ��
 *@param       registNo
 *@add by qinyongli 2005-8
 */
function openCertify(registNo){  
  window.open("/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType=check","NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500"); 
} 
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(index){
     var SHOWTYPE  ="SHOW";
     var BizNo     = fm.all("prpLcheckPolicyNo_"+index).value;
     var RiskCode  = fm.all("prpLcheckRiskCode_"+index).value;
     var damageDate= fm.all("damageDate_"+index).value;
     var CoreWebUrl= fm.txtCoreWebUrl.value;
     var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
     var vURL="";
     	if("A01" == versionNo || versionNo == "" )
	 	{
	 	 vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 	 }
	  else
		{
		vURL = CoreWebUrl +'/' + RiskCode + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	}
    
         window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
/**
	����⸶�����Ƿ���ڳб����� 
*/
function checkStatQuantity(field){
	if(isNaN(field.value)){
		alert("�⸶����Ϊ����!");
		field.focus();
		field.select();
		return;
	}
	if(isNaN(fm.statQuantity.value)){
		fm.statQuantity.value = 0;
	}
	var statQuantity = Number(fm.statQuantity.value);
	var lossQuantity = Number(field.value);
	if(lossQuantity > statQuantity){
		alert("�⸶�������ܴ��ڳб�����! �б���: "+statQuantity);
		field.focus();
		field.select();
	}
	return;
}

function spanShow()
{
	var countShow = getElementCount("registNoShow");
	var showFlag = document.getElementsByName("registNoShow");
	for(var index = 0 ;index < countShow ; index++)
	{
		var spanMain = document.getElementById("spanMain_"+index);
			spanMain.style.display = "none";
		var spanVerifyLoss = document.getElementById("spanVerifyLoss_"+index);
			spanVerifyLoss.style.display = "none";
		var spanPropEdit = document.getElementById("spanPropEdit_"+index);
			spanPropEdit.style.display = "none";
		var spanEarEdit = document.getElementById("spanEarEdit_"+index);
			spanEarEdit.style.display = "none";
		var spanTextEdit = document.getElementById("spanTextEdit_"+index);
		spanTextEdit.style.display = "none";
		if(showFlag[index].checked)
		 {
			spanMain.style.display = "";
			spanVerifyLoss.style.display = "";
			spanPropEdit.style.display = "";
			spanEarEdit.style.display = "";
			spanTextEdit.style.display = "";
		 }
	} 
	return true;
}
function initSpan()
{
	var countShow = getElementCount("registNoShow");
	var showFlag = document.getElementsByName("registNoShow");
	if(countShow > 0){
		showFlag[0].checked = true;
		for(var index = 0 ;index < countShow ; index++)
		{
			var spanMain = document.getElementById("spanMain_"+index);
				spanMain.style.display = "none";
			var spanVerifyLoss = document.getElementById("spanVerifyLoss_"+index);
				spanVerifyLoss.style.display = "none";
			var spanPropEdit = document.getElementById("spanPropEdit_"+index);
				spanPropEdit.style.display = "none";
			var spanEarEdit = document.getElementById("spanEarEdit_"+index);
				spanEarEdit.style.display = "none";
			var spanTextEdit = document.getElementById("spanTextEdit_"+index);
			spanTextEdit.style.display = "none";
			if(showFlag[index].checked)
			 {
				spanMain.style.display = "";
				spanVerifyLoss.style.display = "";
				spanPropEdit.style.display = "";
				spanEarEdit.style.display = "";
				spanTextEdit.style.display = "";
			 }
		} 
	}
	return true;
}