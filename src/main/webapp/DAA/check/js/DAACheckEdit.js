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
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
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
	if (prpLcheckCheckDate < prpLcheckDamageStartDate ){
	   alert("�鿱���ڲ����ڳ�������֮ǰ����");
	   return false;
	}
	//add by liuyanmei 20051115 end
	
	// add by yehuiquan 20070717 start �жϲƲ���ʧ���ձ��Ƿ�Ϊ��
	var prpLthirdPropKindCode = fm.all('prpLthirdPropKindCode')[0];
	if(prpLthirdPropKindCode != null){	
    	var propKindCode = prpLthirdPropKindCode.value;
	    if(propKindCode == null || propKindCode == "") {
	        alert("�Ʋ���ʧ���ձ������Ϣ����Ϊ�գ�");
	        return false;
     	}
	}
	// add by yehuiquan 20070717 end
//	
    if (saveType=="4")
    {
  var isInputLossInfo = false;      //�Ƿ�����¼����һ�����ˡ��Ʋ�����ĵ���ʧ��Ϣ
  //1.���һ�����˸����Ƿ��м�¼��
  var count=getElementCount("prpLpersonTracePersonNo");
  if (count>1){      
        isInputLossInfo = true;
  } 
    //2.���һ�²Ʋ������Ƿ��м�¼
  count=getElementCount("prpLthirdPropItemNo");
  if (count>1){   
    isInputLossInfo = true;
  } 
   //����Ƿ�¼���˱����ʧ��Ϣ
   count=getElementCount("prpLthirdCarLossSerialNo");
  if (count>1){    
    if(fm.riskcode != null && (fm.riskcode.value == "0506"
    ||fm.riskcode.value == "0576"||fm.riskcode.value == "0586")){
        isInputLossInfo = true;
    }

  } 
  //����Ƿ�¼�������߳�
   count=getElementCount("prpLthirdPartySerialNo");
   var claimType = fm.claimType.value;
  if (count>2){    
    isInputLossInfo = true;
  }else{
   
    if(claimType == "K"){
        alert("��������İ�������¼�����߳���Ϣ!");
        return false;
    }
  } 
  if(claimType == "K" && count > 2){
  	for(var i = 2;i < count;i++){
  		if(isEmptyField(fm.prpLthirdPartyLicenseNo[i])){
  			alert("���߳���Ϣ�У����ƺŲ���Ϊ�գ�");
  			fm.prpLthirdPartyLicenseNo[i].foces;
  			return false;
  		}
  		if(isEmptyField(fm.prpLthirdPartyInsureComCode[i])){
  			alert("���߳���Ϣ�У��б���˾����Ϊ�գ�");
  			return false;
  		}
  		if(isEmptyField(fm.prpLthirdPartyCarPolicyNo[i])){
  			alert("���߳���Ϣ�У������Ų���Ϊ�գ�");
  			return false;
  		}
  	}
  }
  //���û������һ����ʧ���Ʋ�����ġ����ˣ���Ϣ,������ʾ
  if(!isInputLossInfo){
        if(fm.riskcode != null && (fm.riskcode.value == "0507"
        ||fm.riskcode.value == "0577"||fm.riskcode.value == "0587")){
            alert("����¼�����߳����Ʋ������˵�����һ����ʧ��Ϣ�������ύ");
            return false;
        }else {
            alert("����¼�����߳����Ʋ������˼���ĵ�����һ����ʧ��Ϣ�������ύ");
            return false;
        }       
  }
  }




// add by sinosoft.com.ljy begin
/*
	var lPercent = 0;
        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
          lPercent= lPercent + parseFloat(fm.prpLthirdPartyDutyPercent[i].value);
        }
         if (lPercent!=100)
         {
            strmsg="�����永���������α���֮�ͱ���Ϊ100!";
            alert(strmsg);
            //field.select();
            //field.focus();
            return false;
         }
*/		 
	/*
  //�ؿ���js�ж�
  if(fm.prpLcarLossBackCheckFlagCheck.checked==true){
     fm.prpLcarLossBackCheckFlag.value="1"; 
  }else {
     fm.prpLcarLossBackCheckFlag.value="0";
  }   
  */
  var errorMessage = "";
  var flag =false;
  fm.buttonSaveType.value = saveType;
  /*
  //��ֵ��ѡ���ֵ	
	var ref="";
	for(i=0;i<fm.prpLcheckReferKind.length;i++){
		if(fm.prpLcheckReferKind[i].checked==true){
			ref = ref + ","+fm.prpLcheckReferKind[i].value;
		}
	}
	fm.referKind.value = ref;	  
  */
 
 
 var lossFlaglength = fm.all("prpLthirdPartyLossFlag").length;
  for (var k=1;k<lossFlaglength;k++){
	var  lossFlag = fm.prpLthirdPartyLossFlag[k].value;
	var  licenseNo =fm.prpLthirdPartyLicenseNo[k].value;
	
	
  if(lossFlag.length<1){
  	 
  	 if (licenseNo==null) licenseNo=""; 
    errorMessage = errorMessage + "���ƺ�Ϊ��"+licenseNo+"�ĳ��Ƿ���������Ϊ��\n";
    fm.prpLthirdPartyLossFlag[k].focus();
    
  }  
}
// if(isInputLossInfo){
//  var lossFlaglength = fm.all("prpLthirdPartyDriveName").length;
//   for(var ii=1; ii <lossFlaglength ;ii++){
//      if(fm.prpLthirdPartyDriveName[ii].value == "")
//       errorMessage=errorMessage+"���߳���ʻԱ����������Ϊ��\n";
//      if(fm.prpLthirdPartyDriveLicensNo[ii].value == "")
//       errorMessage=errorMessage+"���߳���ʻԱ���֤ ������Ϊ��\n";
//      if(fm.prpLthirdPartyLicenseNo[ii+1].value == "")
//       errorMessage=errorMessage+"���ƺ��벻����Ϊ��\n";
//      if(fm.prpLthirdPartyFrameNo[ii+1].value == "")
//       errorMessage=errorMessage+"���ܺ� ������Ϊ��\n";
//   }
// }
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "�鿱���治����Ϊ��\n";
    
  }    
 //add by qinyongli 2005-9-6 �鿱���ж�
  var Checker1 = fm.prpLcheckChecker1.value;
  var Checker2 = fm.prpLcheckChecker2.value;
  if(Checker1==Checker2){
    errorMessage = errorMessage + "�鿱�� 1�Ͳ鿱�� 2����Ϊͬһ��;\n";
   
  } 
  
  //У���ʻԱ֤�����͡�֤���������¼��
  var prpldriverlength = fm.all("prpLdriverIdentifyNumber").length;
  for(var i = 1; i < prpldriverlength; i++){
        if(fm.all("prpLdriverDriverName")[i].value == ""){
            errorMessage =errorMessage + "��ʻԱ��������Ϊ��\n";
        }
        if(fm.all("prpLdriverIdentifyNumber")[i].value == ""){
            errorMessage =errorMessage + "��ʻԱ֤�����벻��Ϊ��\n";
        }
  }
/*
  for(i=0;i<2;i++)
  {
    if(fm.repeatInsureFlag(i).checked==true)
    {
      flag = true;
      break; 
    }
  }

  
  if(flag==false){
    errorMessage = errorMessage + "�Ƿ�����������Ͷ��������Ϊ��\n";
  }
*/  
  //��������������Ӧ��Ԫ�ؽ��п��Ʋ�����Ϊ��
  var firstSiteFlag0 = fm.firstSiteFlag[0].checked;
  var firstSiteFlag1 = fm.firstSiteFlag[1].checked;
  if(firstSiteFlag0 == "" && firstSiteFlag1 == ""){
    errorMessage = errorMessage + "�Ƿ��һ�ֳ�������Ϊ��\n";
  }
  var prpLcheckDamageCode = fm.prpLcheckDamageCode.value;
  var prpLcheckDamageName = fm.prpLcheckDamageName.value;
  if(prpLcheckDamageCode == "��ѡ��" || prpLcheckDamageName == "��ѡ��" ||
     prpLcheckDamageCode == null ||  prpLcheckDamageName == ""){
  	errorMessage = errorMessage + "����ԭ������Ϊ��\n";
  }
  var prpLcheckDamageAreaCode = fm.prpLcheckDamageAreaCode.value;
  var prpLcheckDamageAreaName = fm.prpLcheckDamageAreaName.value;
  if(prpLcheckDamageAreaCode == "��ѡ��" || prpLcheckDamageAreaName == "��ѡ��" ||
     prpLcheckDamageAreaCode == null ||  prpLcheckDamageAreaName == ""){
    errorMessage = errorMessage + "������������Ϊ��\n";
  }
  var prpLcheckDamageTypeCode = fm.prpLcheckDamageTypeCode.value;
  var prpLcheckDamageTypeName = fm.prpLcheckDamageTypeName.value;
  if(prpLcheckDamageTypeCode == "��ѡ��" || prpLcheckDamageTypeName == "��ѡ��" ||
     prpLcheckDamageTypeCode == null ||  prpLcheckDamageTypeName == ""){
    errorMessage = errorMessage + "�¹�ԭ������Ϊ��\n";
  }
  var indemnityDuty = fm.indemnityDuty.value;
  if(indemnityDuty.length < 1){
    errorMessage = errorMessage + "�¹����β�����Ϊ��\n";
  }
  var claimType = fm.claimType.value;
  if(claimType.length < 1){
    errorMessage = errorMessage + "�ⰸ�������Ϊ��\n";
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
 
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  // if(!validateForm(fm,'ThirdParty_Data,Driver_Data'))
 // {
 //   return false;
 // }
    
  //������ύ���ж��Ƿ���nextNodeNo������ԱΪ�գ�������
  //Modify by chenrenda 20050223 begin 
  //ȥ���Խڵ㡢��Ա�ж�
  /*
  if (saveType=="4")
  {
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
  	
  }
  
  */
  //Modify by chenrenda 20050223 end 
  
  
   if (saveType=="4")
  {
  	if (fm.scheduleCheck.checked==true) fm.messageToScheduleCheck.value="1";
  	
  }
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true; 
    
	//ֻ�������ɿɶ���
  ableAllInput();      
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
  fm.submit();
  //return true;   	
}

//Modify By wangli remark begin 20050325
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinSave(){
   
   var businessNo = fm.prpLcheckRegistNo.value;
   var policyNo = fm.prpLcheckPolicyNo.value;
   var riskCode = fm.prpLcheckRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=check&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
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
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLcheckRegistNo.value;
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
		var policyNo = fm.prpLcheckPolicyNo.value;
		var registNo = fm.prpLcheckRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");


}
//Modify By sunhao add end 2004-09-06
*/
//Modify By wangli remark end 20050325

/**
 *@description ���û���ĳ�ʼֵ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
	function initSet(){
  	//loadCheckLoss();
  	loadCheckExt();
    fm.buttonThirdPartyDelete[1].disabled = true;
  
  	
    //modify by suncg add 20060109 start
    //reason: �޸�bug1080

    fm.prpLthirdPartyLicenseNo[1].disabled = true;

    fm.prpLthirdPartyBrandName[1].disabled = true;
    fm.carKindCode[1].disabled = true;
    fm.licenseColorCode[1].disabled = true;
    //ҳ��������鿱�ͱ�����������ҳ���ļ����ڴ˵�����
    //spanDamageInfo.style.display = '';
    //spanDamageInfo.style.position = '';
    RegistText.style.width = '100%';
    fm.RegistTextImg.src='/claim/images/butExpandBlue.gif';
    fm.RegistTextImg.onclick = new Function("showPage(this,RegistText)");
    fm.RegistTextImg.onclick();
    table_cars.style.display = '';
	}
/**
 *@description ���û���ĳ�ʼֵ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */	
	function initSetForCertainLoss(){ 
  	//loadCheckLoss();
  	loadCheckExt();
  	fm.buttonThirdPartyDelete[1].disabled = true;
    fm.prpLthirdPartyLicenseNo[1].readOnly = true; 
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



/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function fileSave(field,saveType)
{   
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'Certify_Data'))
  {
    return false;
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function fileSavePop(field,saveType)
{   
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'Certify_Data'))
  {
    return false;
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  fm.target="_self";
  fm.submit(); 
  //return true;   	
}
   
  /**
   *@description �鿴�ƶ����ļ�
   *@param       fileName��businessNo��uploadFileName
   */
  function viewFile(fileName,businessNo){
    //document.fm.action="/claim/DAA/certify/download.jsp?fileName="+fileName+"&businessNo="+businessNo+"&uploadFileName="+uploadFileName;
    //document.fm.submit();
    window.open("/claim/DAA/certify/CertifyViewFile.jsp?fileName="+fileName+"&businessNo="+businessNo,businessNo,"resizable=0,scrollbars=1,width=800,height=600");
  }
  
  //Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��


 //Modify By wangli remark end 20050328
/**
 * ���������
 * @param field Ԫ��
 * @param tableName tableName
 * @return ��
 */
function backSubPage(spanID)
{
   var span = eval(spanID );
  if (span.style.display =='none')  
  {
  	span.style.display ='';
  }else
	{
		span.style.display ='none';
	}
}

/**
 @description �ı��⳥����ʱ��������Ӧ�ı����α���
 @param       ��
 @return      ��
 */
function changeIndemnityDuty()
{  
  var indemnityDuty =""; //���õ�ֵ	  
  var i= 0;              //ѭ��ʹ��
                   
           
  switch (fm.indemnityDuty.value)
  {
    case "0":   //ȫ��
      indemnityDuty = "100";
      break;
    case "1":   //����
      indemnityDuty = "70";
      break;
    case "2":   //ͬ��
      indemnityDuty = "50";
      break;
    case "3":   //����
      indemnityDuty = "30";
      break;
    case "4":   //����
      indemnityDuty = "0.0";
      break;
    case "9":   //����
      indemnityDuty = "0.0";
      break;
  }
  
   
   for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
 	{
		if (fm.insureCarFlag[i].value=="1" )
    {
      fm.prpLthirdPartyDutyPercent[i].value = indemnityDuty;
      
      return isRightDutyPercent(fm.prpLthirdPartyDutyPercent[i]);
    }		
	}  
}

/**
 *@description ���涨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function saveCertainLossForm(field)
{
  //У��  
  //��Ա�������Ʋ���ʧ�����߱�¼һ����ܽ���
  var carLossRepairFeeLossItemCode = fm.carLossRepairFeeLossItemCode.length;
  var carLossComponentLossItemCode = fm.carLossComponentLossItemCode.length;
  var personSerialNo = fm.personSerialNo.length;
  var prpLpropSerialNo = fm.prpLpropSerialNo.length;
  if(carLossRepairFeeLossItemCode == undefined &&carLossComponentLossItemCode == undefined&&personSerialNo == undefined&&prpLpropSerialNo == undefined)
  { 
    alert("��������/����������Ա�������Ʋ���ʧ����������¼��һ��");
    return false;
  }
  
	if(checkPropKindCode()==false)
  return false;     

  
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'RepairFee_Data,Component_Data,PersonFeeLoss_Data,Person_Data,Prop_Data'))
  {
    return false;
  }
    //������ύ���ж��Ƿ���nextNodeNo������ԱΪ�գ�������
  
  if (saveType=="4")
  {
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
 	
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}

 
/**
*@description �������������嵥 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}   
 //modify by wangli remark start 20050408
/**
 *@description ������֤ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 /*
function openCertify(registNo){  
  window.open("/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType=check","NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500"); 
}


//��ť�����¼��������������ʾ
function buttonOnClick1(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//����	
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage2(spanID,leftMove) 
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
   
//modify by wangli remark end 20050408

    
/**
*@description ��ӡ������֪�嵥  2005-08-09
*@param       businessNo   
*/
function certifyDirectList(businessNo,nodeType){    

  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirectPrint&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcheckPolicyNo.value;
     var RiskCode  =fm.prpLcheckRiskCode.value;
     var damageDate=fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

function addOption(){
	//�Ƿ��һ�ֳ�����
	fm.firstSiteFlag[1].checked = "";
	//����ԭ��Ĭ��Ϊ����ѡ��
	fm.prpLcheckDamageName.value = "��ѡ��";
	fm.prpLcheckDamageCode.value = "��ѡ��";
	//�¹�ԭ��Ĭ��Ϊ����ѡ��
	fm.prpLcheckDamageTypeCode.value="��ѡ��";
	fm.prpLcheckDamageTypeName.value="��ѡ��";
	//��������Ĭ��Ϊ����ѡ��
	fm.prpLcheckDamageAreaCode.value = "��ѡ��";
	fm.prpLcheckDamageAreaName.value="��ѡ��";
	//�¹��������ӡ���ѡ��ѡ���Ĭ��Ϊ��
	fm.indemnityDuty.add(new Option("��ѡ��",""));
	fm.indemnityDuty.value = "";
	//�ⰸ���Ĭ��Ϊ����ѡ��
	fm.claimType.add(new Option("��ѡ��",""));
	fm.claimType.value="";
	//�鿱����Ĭ��Ϊ��
	fm.prpLregistTextContextInnerHTML.value="";
}

function clearInput(field){
	if(field.value == "��ѡ��"){
		field.value = "";
	}
}