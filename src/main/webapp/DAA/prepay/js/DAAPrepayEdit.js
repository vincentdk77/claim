/*****************************************************************************
 * DESC       ��Ԥ��ǼǵĽű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-05-13
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ��鱨���Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
  ////���Ǽ���������
   //if(checkRegistMain()==false)
   //{
   //  return false;
   //}
    ////������߳�������
   //if(checkThirdParty()==false)
   //{
   //  return false;
   //}
   ////����ʻԱ����
   //if(checkDriver()==false)
   //{
    //  return false;
   //}
    ////����ı�����
   //if(checkRegistText()==false)
   //{
    //  return false;
   //}
   
    return true;
}

/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
  return true;
}
/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initShow() 
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
    window.location.href = window.location.href;
    //window.location.href="http://www.yahoo.com";
    //location.href = location.reload();
	  //document.location.reload();
    return true;  
  }
  else
  {
    return false;
  }
}


/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;  
  //textarea�ı�������ֵ
  var context = fm.prpLptextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "Ԥ�ⱨ�治����Ϊ��\n";
  }
  
 var   caseType= fm.prpLprepayCaseType.value;
 var   sumPrePaid =fm.prpLprepaySumPrePaid.value;
 var   limitFeeHaveDuty =fm.limitfeeHaveDuty.value;	
 var   limitFeeNoneDuty =fm.limitfeeNoneDuty.value;	
 
 if ( caseType =='7'){
   if ( parseFloat(sumPrePaid) >parseFloat(limitFeeHaveDuty)){
   	      errorMessage = errorMessage + "֧�����ȷ��ý��ܳ���ǿ�Ʊ�������ҽ���޶�("+limitFeeHaveDuty+"Ԫ) \n";
 	        //alert(" ֧�����ȷ��ý��ܳ���ǿ�Ʊ�������ҽ���޶�("+limitFeeHaveDuty+"Ԫ)");
 	      field.focus();
 	      
   }
  
 }
    if ( caseType =='8' ){
    if ( parseFloat(sumPrePaid) > parseFloat(limitFeeHaveDuty)){
    	      errorMessage = errorMessage + "�渶���ȷ��ý��ܳ���ǿ�Ʊ�������ҽ���޶�("+limitFeeHaveDuty+"Ԫ) \n";
 	        //alert(" �渶���ȷ��ý��ܳ���ǿ�Ʊ�������ҽ���޶�("+limitFeeNoneDuty+"Ԫ)");
 	      field.focus();
   }  	
 }
  
  
  var sumClaim = fm.sumClaim.value;
  var percent = fm.percent.value;
  if ( caseType =='5'){
	  if(parseFloat(parseFloat(sumClaim)*parseFloat(percent)/100)<parseFloat(fm.prpLprepaySumPrePaid.value)){
	  	 errorMessage = errorMessage + "Ԥ����Ӧ��С�ڵ��ڹ������"+percent+"%\n";
	    //alert("Ԥ����Ӧ��С�ڵ��ڹ������"+percent+"%");
	    //return false;
	  }
  }
  var prePayFlag = fm.prePayFlag.value;
  //if(prePayFlag==0){
    //errorMessage = errorMessage + "����δʵ�����������ύ/�ݴ棡\n";
  //}    
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616

  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm))
  {
  	return false;
  }
  //Ԥ����<=�������50%
  /**var sumClaim = fm.sumClaim.value;
  var percent = fm.percent.value;
  if(parseFloat(parseFloat(sumClaim)*parseFloat(percent)/100)<parseFloat(fm.prpLprepaySumPrePaid.value)){
    alert("Ԥ����Ӧ��С�ڵ��ڹ������"+percent+"%");
    return false;
  }*/
  var underWriteFlag = fm.prpLprepayUnderWriteFlag.value;
  if(saveType==4){
   // if(underWriteFlag!=1){
  //   alert("���⸴�˲�ͨ��ʱ�����ύ"); 
  //   return false;
   // }
  }
  
  //������ύ���ж��Ƿ���nextNodeNo������ԱΪ�գ�������
  
  if (saveType=="4")
  {
  	/*
  	if (trim(fm.nextNodeNo.value).length<1)
  	{
  		alert("��ѡ��Ҫ�ύ����һ���ڵ㣡")
  		return false;
  	}
  	
  	if (trim(fm.nextHandlerCode.value).length<1)
  	{
  		alert("��ѡ��Ҫ�ύ����һ���ˣ�")
  		return false;
  	}
 	*/
  }
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();
  
  return true;   	
}

//modify by wangli remark start 20050409
/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinSave(){
   
   
   var policyNo = fm.prpLprepayPolicyNo.value;
   var riskCode = fm.prpLprepayRiskCode.value;
   var businessNo = fm.prpLprepayClaimNo.value;
   var claimNo = fm.prpLprepayClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=prepa&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
  
}
*/
/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLprepayClaimNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
//Modify By sunhao add begin 2004-09-06

/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 /*
function relate(){
		var policyNo = fm.prpLprepayPolicyNo.value;
		var claimNo = fm.prpLprepayClaimNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&claimNo=" +claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
//Modify By sunhao add end 2004-09-06
*/
//modify by wangli remark end 20050409

//Modify By liubvo add end 2004-09-07
/**
 *@description ʵ�����񸴺�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function approveSubmit()
{
  fm.buttonApprove.disabled = true;
  fm.submit();
  return true;
}


//modify by wangli remark start 20050409
/*
//Modify By liubvo add end 2004-09-07
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
  
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 
*/
//modify by wangli remark end 20050409

//add by zhangyingrui start at 20060808
/**
*@description �������������嵥 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}   
/**
 *@description ������֤ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function openCertify(registNo){  
  window.open("/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType="+nodeType,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500"); 
}
//add by zhangyingrui end at 20060808

//add by zhangyingrui start at 20060809
/**
*@description �����ⰸ�����У��渶��֧�����ȷ������Ʋ��ܳ���ǿ������ҽ���޶� 
*@param        
*/
function checkBeyondLimitFee(field){
	
 var   caseType= fm.prpLprepayCaseType.value;
 var   sumPrePaid =fm.prpLprepaySumPrePaid.value;
 var   limitFeeHaveDuty =fm.limitfeeHaveDuty.value;	
 var   limitFeeNoneDuty =fm.limitfeeNoneDuty.value;	
 
 if ( caseType =='7'){
   if ( parseFloat(sumPrePaid) >parseFloat(limitFeeHaveDuty)){
 	        alert(" ֧�����ȷ��ý��ܳ���ǿ�Ʊ�������ҽ���޶�("+limitFeeHaveDuty+"Ԫ)");
 	      field.focus();
   }
  
 }
 else if ( caseType =='8' ){
    if ( parseFloat(sumPrePaid) > parseFloat(limitFeeHaveDuty)){
 	        alert(" �渶���ȷ��ý��ܳ���ǿ�Ʊ�������ҽ���޶�("+limitFeeHaveDuty+"Ԫ)");
 	      field.focus();
   }  	
 }
	
}
//add by zhangyingrui end at 20060809
