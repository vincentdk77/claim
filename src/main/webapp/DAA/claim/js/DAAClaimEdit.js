/*****************************************************************************
 * DESC       �������ǼǵĽű�����ҳ��
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-03-10
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
 	//	return false;
 	//}
    ////������߳�������
 	//if(checkThirdParty()==false)
 	//{
 	//	return false;
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

	//��������֤�ǲ����е�һ����������£����ܽ������õġ�
  if (fm.prpLthirdPartySerialNo.length>1){
      fm.buttonThirdPartyDelete[1].disabled = true;
      //modify by zhaozhuo add 20050321 start
      //reason: �永������Ϣ�б������������Ƶ�ɫ���������ࡢ�����ͺŲ������޸�
      fm.prpLthirdPartyBrandName[1].disabled = true;
      fm.carKindCode[1].disabled = true;
      fm.licenseColorCode[1].disabled = true;
      fm.prpLthirdPartyLicenseNo[1].disabled = true;
      //modify by zhaozhuo add 20050321 end
      fm.prpLthirdPartyLicenseNo[1].readOnly = true;
      //collectClaimLoss();
  }
    
  changeSumClaim(); //��ʼ��������
  table_cars.style.display = "";
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
  if ( checkBeyondQuota()==false){
     return false;
  }
  fm.buttonSaveFinish.disabled = true;
  fm.buttonSaveFinishSubmit.disabled = true;
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

function sumLossAmountInformDaa() {
         var returnString ="";
         var collectTemp = new Array();
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //ѭ���ֱұ�ͳ��
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                }
            }
            //���жϵ�ǰ�������Ƿ����д˱ұ�,���û���ٽ��б���
            for(var j=0;j<collectTemp.length;j++){             
                if(collectTemp[j]==currency){hasElement=true;}
            }
            //�����ǰ�������д�Ԫ�أ����ٽ���ͳ��

            if(hasElement){continue;}
            //����������
            collectTemp[i-1]= currency;
         }
             if(sumLossAmount>500000) {
                 returnString = "��ʾ�����������ֵ���� "+currencyName+" ��ʮ��Ԫ��";
             }
             return returnString;
}

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{
//reason :itest bug 634 �������α���֮��Ϊ100%
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
  //modify by liuyanmei add 20051114 end
  /*
   *���Ʋ���¼���ظ����ձ������Ϣ
   */
   if(fm.all("prpLclaimLossLossFeeType") != null && fm.all("prpLclaimLossKindCode") != null && fm.all("prpLclaimLossFeeCategory") != null){
        for(var i = 1 ;i < fm.all("prpLclaimLossKindCode").length;i++){       
            var lossInfo = fm.all("prpLclaimLossLossFeeType")[i].value + fm.all("prpLclaimLossKindCode")[i].value + fm.all("prpLclaimLossFeeCategory")[i].value;
            var nextLossInfo = "";
            var count = 0;
            for(var j = i;j < fm.all("prpLclaimLossLossFeeType").length;j++){
                if(j < fm.all("prpLclaimLossLossFeeType").length -1){
                    nextLossInfo = fm.all("prpLclaimLossLossFeeType")[j + 1].value + fm.all("prpLclaimLossKindCode")[j + 1].value + fm.all("prpLclaimLossFeeCategory")[j + 1].value;
                    if(lossInfo == nextLossInfo){
                        count++;
                    }
                }
            }
            if(count > 0 && fm.prpLclaimEditType.value!="EDIT"){
                alert("��¼�����ظ����ձ������Ϣ��\n" +
                      "�뽫��Щ��Ϣ�ϲ����ٱ�����ύ" );
                
                return false;
            }
        }
   }
   
  /*
   *������������¼������һ�����ã��ҷ��ñ������0
   */
   if(fm.all("prpLclaimLossLossFeeType") != null){
        var allFeeLoss = 0;
        var FeeLoss = 0;
        var isInputFee = false;
        for(var i = 0;i < fm.all("prpLclaimLossLossFeeType").length;i++){
            if(fm.all("prpLclaimLossLossFeeType")[i].value == "Z" && fm.all("prpLclaimLossSumClaim")[i] != null){
                isInputFee = true;
                FeeLoss = parseFloat(fm.all("prpLclaimLossSumClaim")[i].value);
                if(isNaN(FeeLoss))
                    FeeLoss = 0;
                allFeeLoss = allFeeLoss + FeeLoss;
            }
        }
        if(!isInputFee){
            //alert("�ձ��������Ϣ�б���¼������һ��������Ϣ");
            //return false;
        }else if(allFeeLoss == 0 || allFeeLoss < 0){
            //alert("�ձ��������Ϣ�з��ù�����������0");
            //return false;
        }
        
   }
  //���ƻ�������İ�������¼�����߳�
  var count = getElementCount("prpLthirdPartySerialNo");
  if (count <= 2){
    var claimType = fm.claimType.value;
    if(claimType == "K"){
        alert("��������İ�������¼�����߳���Ϣ!");
        return false;
    }
  }  
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //textarea�ı�������ֵ
  var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
  }
  //��������
  var prpLclaimDamageAreaCode = fm.prpLclaimDamageAreaCode.value;
  var prpLclaimDamageAreaName = fm.prpLclaimDamageAreaName.value;
  if(prpLclaimDamageAreaName.length < 1 || prpLclaimDamageAreaCode.length < 1){
        errorMessage = errorMessage + "������������Ϊ��\n";
  }
  //���ձ𻥳�
  var found = false;
  var foundKindCode = "";
  for(var i=1;i<fm.prpLclaimLossKindCode.length;i++){
    var kindCode = fm.prpLclaimLossKindCode[i].value;
    if(kindCode=="A" || kindCode=="G" || kindCode=="F" || kindCode=="Z"){
        if(found==true && foundKindCode!=kindCode){
            errorMessage = errorMessage + "������ʧ�ա�ȫ�������ա��������������ա���ȼ��ʧ�ղ���ͬʱ����\n";
            break;
        }else{
          found = true;
          foundKindCode = kindCode;
        }
    }
  }
  
  //У���ʻԱ֤�����͡�֤���������¼��
   var prpldriverlength = fm.all("prpLdriverIdentifyNumber").length;
  for(var i = 1; i < prpldriverlength; i++){
        var prpLdriverDriverName = fm.all("prpLdriverDriverName")[i].value;
        var prpLdriverIdentifyNumber = fm.all("prpLdriverIdentifyNumber")[i].value;
        var arrDriverName = prpLdriverDriverName.split(" ");
        var arrIdentfyNumber = prpLdriverIdentifyNumber.split(" ");
        if( arrDriverName.length - 1 == prpLdriverDriverName.length){
            errorMessage =errorMessage + "��ʻԱ��������Ϊ��\n";
        }
        if( arrIdentfyNumber.length - 1 == prpLdriverIdentifyNumber.length){
            errorMessage =errorMessage + "��ʻԱ֤�����벻��Ϊ��\n";
        }
  }
  
   //�����ղ���¼��ҽ�ƺ������˲�
  for(var i=1;i<fm.prpLclaimLossKindCode.length;i++){
    var kindCode = fm.prpLclaimLossKindCode[i].value;
      //��Χ��M ҽ��    D �����˲�
    var FeeCategory = fm.prpLclaimLossFeeCategory[i].value;
    if(kindCode=="A" && (FeeCategory=="M" || FeeCategory=="D")){
       errorMessage = errorMessage + "�����ղ���¼��ҽ�ƺ������˲У�������ѡ��\n";
       break;
    }
  }
  
  //���Ƴ���ԭ��Ϊ�� 
  var strDamageTypeCode = fm.prpLclaimDamageTypeCode.value;
  var strDamageTypeName = fm.prpLclaimDamageTypeName.value;
  if (strDamageTypeCode=="" || strDamageTypeName==""){
    errorMessage = errorMessage + "�¹����Ͳ�Ϊ�գ�������ѡ��\n";
  }
  
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }

  //add by qingyongli 2005/07/22 
  var claim_days = fm.claim_days.value;
  var standardDays = fm.standardDays.value;
  if(claim_days==0){
  	if(!confirm("������������ϵͳ�涨ʱ��"+standardDays+"�죬�Ƿ��ύ��")){
  		return false;
  	}
   }
   
  /*
  if (!collectClaimLoss())
  {
    return false;
  }
  */
  //modify by weishixin add begin 20040616

  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  //if(!validateForm(fm,'ClaimLoss_Data,ThirdParty_Data,Driver_Data'))
  //{
  //  return false;
  //}
  
   if ( checkBeyondQuota()==false){
     return false;
  }

  //modify by wangli add start 20050426
  //reason:�ݴ�ʱҲҪУ��
  /*
  if(saveType=="2"){

  	for(var i=0;i<prpLclaimLossKindCode.length();i++)
  	{
  	var prpLclaimLossKindCode = fm.prpLclaimLossKindCode[i].value;
  	var prpLclaimLossKindName = fm.prpLclaimLossKindName[i].value;
  	alert(prpLclaimLossKindCode);
  	if(prpLclaimLossKindCode=="")
  	{
  	 alert("�ձ���벻��Ϊ��");
         fm.prpLclaimLossKindCode[i].focus();
          return false;
  	}

  	if(prpLclaimLossKindName=="")
  	{
         alert("�ձ����Ʋ���Ϊ��");
  	fm.prpLclaimLossKindName[i].focus();
  	 return false;
        }

  	}
  	 return false;
  	}
 */
 //modify by wangli add end 20050426
 
     //modify by lixiang add start 20060216
     //reason:��Ϊsumclaimֵ�ͷ��һ��
     collectClaimLoss();
     dutySum();
     //modify by wangli add end 
     
     if(!checkLoss()){
    return false;  
    }
 
      if (saveType=="4"){
    //������Ϊ��Ӧ�ò������ύ
    
   	  var SumClaim = parseFloat(fm.prpLclaimSumClaim.value);
   	  if(SumClaim<=0){
   	    //alert("�����뱣����ʧ���");
    	  //fm.prpLclaimSumClaim.focus();
    	  //fm.prpLclaimSumClaim.select();
   	    //return false;
   	  }
 	  }
 	  //������ҵ�ղ���ѡ�������ⰸ��
 	  if(changeClaimType(fm.claimType)==false){
 	  	return false;
 	  }
  
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
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
 
  //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	 if ( DangerUnitCheck()==false){
	    return false;
	 }
  }
  
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  //modify by weishixin add end 20040616
  //alert("-----submit--------");
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
      
  // ����ʱ����50����ʾ��,���ȷ�Ϻ󷽿ɱ���,����ͣ����ҳ��
  if(confirm(sumLossAmountInformDaa() + "\nȷ�ϼ����ύ��")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }    	
}

//ע������
function offForm(field){
  var claimNo  = fm.prpLclaimClaimNo.value;
  var registNo = fm.prpLclaimRegistNo.value;
  if(claimNo==""){
    fm.action="/claim/RegistQuery.do?RegistNo="+registNo+"&editType=DELETE";
  }else{
    fm.action="/claim/wfLogQuery.do?status=-1&nodeType=claim&FuncName=cancelApply";
  }
    fm.submit();
}


//װ������
function loadForm()
{
	//alert("set cadsfsdfl");
	//fm.carKindCode.disabled = true;
	//fm.carKindCode.readOnly = true;
	//alert("set carKindCode");
}


//Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinSave(){

   var businessNo = fm.prpLclaimRegistNo.value;
   var policyNo = fm.prpLclaimPolicyNo.value;
   var riskCode = fm.prpLclaimRiskCode.value;
   var claimNo = fm.prpLclaimClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=claim&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
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
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLclaimRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=no,scrollbars=yes,width=600,Height=300");
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
		var policyNo = fm.prpLclaimPolicyNo.value;
		var registNo = fm.prpLclaimRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
//Modify By sunhao add end 2004-09-06
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

//Modify By wangli remark end 20050328
/**
 @description У��������
 @param       ��
 @return      boolean
 */
function checkLoss()
{
	//1.������Ҫ��һ����¼
  if(getRowsCount("ClaimLoss")==0)
  {
		errorMessage("����������Ϣ����Ҫ��һ����¼!");

		return false;
  }
	//2�ұ���Ϊ�յ�

  for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
 	{
		if (isEmptyField(fm.prpLclaimLossCurrency[j]))
		{
			errorMessage("��"+ j+"���������бұ���Ϊ��!");
			fm.prpLclaimLossCurrency[j].focus();
			return false;
		}

		if(isEmptyField(fm.prpLclaimLossKindCode[j]))
		{
			errorMessage("��"+j+"���¹ʹ��������ձ���벻��Ϊ��!");
			//fm.prpLclaimLossKindCode[j].focus();
			return false;
		}

//�ձ�ͱұ���ͬ�ģ�����ϲ�
  	for( var n=j+1;n<fm.prpLclaimLossCurrency.length;n++)
 		{
			//if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossKindCode[n].value==fm.prpLclaimLossKindCode[j].value))
			//{
			//	errorMessage("��"+ n+"�����������ձ𼰱ұ�͵�"+ j+"�����������ձ𼰱ұ�һ�£���ϲ���2����¼");

			//	fm.prpLclaimLossKindCode[n].focus();
			//	return false;
			//}
		}

		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		{
			errorMessage("��"+j+"���¹ʹ������н���Ϊ��!");
			fm.prpLclaimLossSumClaim[j].focus();
			return false;
		}
 	}
	return true;
}
/**
 @description ���ܹ�����
 @param       ��
 @return      ��
 */
function collectClaimLoss()
{
	var SumKindLoss =0; //�ܵ�kindLoss֮��
	var kindLoss =0;
	var SumSumClaim =0; //�ܵ�Sumclaim֮��
	var sumClaim =0;

	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 		{
 			//kindLoss =parseFloat(fm.prpLclaimLossKindLoss[n].value)
			//SumKindLoss = SumKindLoss + kindLoss;
			sumClaim =parseFloat(fm.prpLclaimLossSumClaim[n].value)
			SumSumClaim = SumSumClaim + sumClaim;
    }
    //������ʧ���=sum(kindLoss)
  	fm.prpLclaimSumClaim.value=pointTwo(SumSumClaim);
  	//Σ�յ�λ����=sum(sumClaim)
    fm.prpLdangerRiskSumClaim.value=pointTwo(SumSumClaim);

  return true;
}

//�õ�һҳ�Ķ��м�¼�ļ�¼��
//ҳ����
function getRowsCount(PageCode)
{
  var oTBODY   = document.all(PageCode).tBodies.item(0);
  var intCount = oTBODY.rows.length;
  return intCount;
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

  fm.prpLclaimIndemnityDutyRate.value =indemnityDuty;

   for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
 	{
		if (fm.insureCarFlag[i].value=="1" )
    {
      fm.prpLthirdPartyDutyPercent[i].value = indemnityDuty;
      return isRightDutyPercent(fm.prpLthirdPartyDutyPercent[i]);
    }

	}

}
function changeIndemnityDuty1()
{
  var i= 0;              //ѭ��ʹ��
  for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
 	{
		if (fm.insureCarFlag[i].value=="1" )
    {
      fm.prpLthirdPartyDutyPercent[i].value = fm.prpLclaimIndemnityDutyRate.value;
      return isRightDutyPercent(fm.prpLthirdPartyDutyPercent[i]);
    }
	} 
}


//Modify By wangli remark start 20050328
//
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
  var span = eval(spanID);
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
 

//Modify By wangli remark end 20050328


//�����:���ɲ��������ı�  2005-08-09
function generateNoClaimText() {
    var prpLlText = "";
    var strSpace = "    ";
    var prpLclaimInsuredName = fm.prpLclaimInsuredName.value;
    var message1 = strSpace + "�����������뱾��˾�Ѿ���Ϥ�����ݱ��������ط��ɣ����������˶������ṩ���й�������֤��������˾��Ϊ�������������ɲ��ܳ������������´��� \n";
    var message2 = strSpace + "�����������˼�/����������ս�/�˻���Լ��CNY0.00Ԫ ,��������պ�ͬ��\n";
    var message3 = strSpace + "����˾�������������������ǣ�\n\n";
    var message4 = strSpace + "�����Ա���˾�Ĵ��������飬���ڽӵ���֪֮ͨ����ʮ�����򱾹�˾���ⲿ��Ѱ����͡������������޷��������Ĵ𸴣�������������Ȩ����\n";
    var message5 = strSpace + "���ٲû��������ٲ�/������Ժ�������� \n";
    var message6 = strSpace + "�����벢����������������Ȩ����\n";
    prpLlText = "�𾴵�" + prpLclaimInsuredName + "Ůʿ/������\n" + message1;
    prpLlText = prpLlText + message2 + message3 + message4 + message5 +message6;
    fm.prpLclaimContext.value = prpLlText;
    return true;
}
//�����ձ������Ϣ ,���ݱұ����
//add by qinyongli 2005-8-31 
function collectCurrency(){
         var collectCurr ="";
         var collectTemp = new Array();
         collectCurr = "�ֱұ���ܽ��:\n";
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //ѭ���ֱұ�ͳ��
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     var claimLossSum = parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                     if(isNaN(claimLossSum))claimLossSum = 0;
                     sumLossAmount = sumLossAmount + parseFloat(claimLossSum);
                }
            }
            //���жϵ�ǰ�������Ƿ����д˱ұ�,���û���ٽ��б���
            for(var j=0;j<collectTemp.length;j++){             
                if(collectTemp[j]==currency){hasElement=true;}
            }
            //�����ǰ�������д�Ԫ�أ����ٽ���ͳ��

            if(hasElement){continue;}
            //����������
            collectTemp[i-1]= currency;
            collectCurr =collectCurr +  currency+"  "+ currencyName+"  "+ sumLossAmount+".00Ԫ\n";
         }
         if(collectCurr.length>0){
             alert(collectCurr);
             if(sumLossAmount>500000) {
                 alert("��ʾ�����������ֵ���� "+currencyName+" ��ʮ��Ԫ��");
             }
             return false;
         }
}
// add by qinyongli end 2005-8-31
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLclaimPolicyNo.value;
     var RiskCode  =fm.prpLclaimRiskCode.value;
     var damageDate=fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL =  CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

