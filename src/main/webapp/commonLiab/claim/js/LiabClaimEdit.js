/*****************************************************************************
 * DESC       �������ǼǵĽű�����ҳ��
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-03-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ //�ж��Ƿ��ǹ������ٷ֡��ɶ�ҵ����Ϣ
    var coinsFlag = fm.coinsFlag.value;	
    var shareHolderFlag = fm.shareHolderFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var message = "";
     //add by qinyongli ���ӱ���ע��,����ʱ�䣬��ǩ�����ɶ�ҵ�񣬳��մ������ٷֹ�������ʾ�� 2005-7-28
    var coinsFlag = fm.coinsFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var shareHolderFlag = fm.shareHolderFlag.value;
    var message = "";
    
    var othFlag = fm.prpLclaimOthFlag.value;
    if(othFlag.substring(3,4)=="1"){
     message = message + "�˱�����ע����\n";
    }
    if(shareHolderFlag!=0){
       message = message + "�˱���Ϊ�ɶ�ҵ��\n";
    }
    var payFee = parseInt(fm.payFee.value);
  if(payFee==-1){
    alert("�˱�������δ�ɣ�\n");
  } 
  else if(payFee==0){
    alert("�˱�������δ��ȫ��\n");
  }else if(payFee==-2){
     message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
  }
    if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
    	message = message + "������Ϊ��/��������\n";
    }
    if (message.length>0) {
       alert(message);
       return false;
    } 
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

function sumLossAmountInformLiab() {
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
 // У�������
  if(!checkExes()) {
    return false;
  } 
  var errorMessage = "";	
  fm.buttonSaveType.value = saveType;
  //����׷���ںͳ���ʱ���ж�
  var liabStartDate = fm.liabStartDate.value;
  var startDate = fm.prpLclaimStartDate.value;
  var endDate   = fm.prpLclaimEndDate.value;
  var damageStartDate = fm.prpLclaimDamageEndDate.value;
   if((damageStartDate < liabStartDate)&&liabStartDate!=0&&liabStartDate<startDate|| (damageStartDate > endDate)){
  	errorMessage = errorMessage +"��ʾ������ʱ���ڱ����ڼ����⣬����������!\n";
  }
  //textarea�ı�������ֵ
  var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){ 
    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
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
  //modify by weishixin add begin 20040616

  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm,"ClaimLoss_Data"))
  {
    return false;
  }
  
  //���������
  if(!collectClaimLoss())
  {
    return false;
  }
  
  //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
  if(fm.prpLclaimRiskCode.value=="1528"){
    var claimLossLen = fm.prpLclaimLossKindCode.length;
     for(var i = 1; i < claimLossLen; i++) {
       if(fm.prpLclaimLossBrandCode[i].value==""||fm.prpLclaimLossCarNumber[i].value==""){
         alert("�����ֵ��¹ʳ�����Ϣ����Ϊ�գ�");
         return false;
       }
    }
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
      
  // ����ʱ����50����ʾ��,���ȷ�Ϻ󷽿ɱ���,����ͣ����ҳ��
  if(confirm(sumLossAmountInformLiab() + "\nȷ�ϼ����ύ��")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }   	
}

//װ������
function loadForm()
{
	//alert("set cadsfsdfl");
	//fm.carKindCode.disabled = true;
	//fm.carKindCode.readOnly = true;
	//alert("set carKindCode");
}

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave(){
   
   var businessNo = fm.prpLclaimRegistNo.value;
   var policyNo = fm.prpLclaimPolicyNo.value;
   var riskCode = fm.prpLclaimRiskCode.value;
   var claimNo = fm.prpLclaimClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=claim&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLclaimRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=no,scrollbars=yes,width=600,Height=300");
}

//Modify By sunhao add begin 2004-09-06
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){	
		var policyNo = fm.prpLclaimPolicyNo.value;
		var registNo = fm.prpLclaimRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}


/**
 @description У��������
 @param       ��
 @return      boolean
 */
function checkFee()
{
  if(getRowsCount("LiabClaimFee")==0)
  {
		errorMessage("����������Ϣ����Ҫ��һ����¼!");				
	
		return false;  
  }
	//alert (fm.prpLclaimFeeCurrency.length);
	
  for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
 	{
		if (isEmptyField(fm.prpLclaimLossCurrency[j]))
		{
			errorMessage("��"+ j+"���������бұ���Ϊ��!");			
			fm.prpLclaimLossCurrency[j].focus();
			return false;
		}

  	for( var n=j+1;n<fm.prpLclaimLossCurrency.length;n++)
 		{
			if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossKindCode[n].value==fm.prpLclaimLossKindCode[j].value)&&(fm.prpLclaimLossLossFeeType[n].value==fm.prpLclaimLossLossFeeType[j].value))
			{
				errorMessage("��"+ n+"���������бұ�͵�"+ j+"���������бұ�һ�£���ϲ���2����¼");			
			
				fm.prpLclaimLossCurrency[n].focus();
				return false;
			}
		}
				
		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		{ 
			errorMessage("��"+j+"���¹ʹ������н���Ϊ��!");			
			fm.prpLclaimFeeSumClaim[j].focus();
			return false;
		}
 	}	
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
 @description ���ܹ�����
 @param       ��
 @return      ��
 */
function collectClaimFee()
{
	var compAmout =0;
	var nowAmout =0;
	
	if (!checkFee()) return false ; 
	//ѭ������ �����
	
	for( var n=1;n<fm.prpLclaimFeeSumClaim.length;n++)
 		{
 			nowAmout =parseFloat(fm.prpLclaimFeeSumClaim[n].value)
			compAmout = compAmout + nowAmout;
    }			
	
	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
        fm.prpLdangerRiskSumClaim.value=pointTwo(compAmout);
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
  
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 
//Modify By dongcl remark begin 20050623
/**
 @description ���ܹ�����
 @param       ��
 @return      ��
 */
function collectClaimLoss()
{
	var compAmout =0;
	var nowAmout =0;
	var exchCurrency = fm.prpLclaimCurrency.value;  //�õ���ǰ�ұ�����
	var exchRate = 1; //�һ���
	
	if (!checkLoss()) return false ; 
	//ѭ������ �����
	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 	{
 		nowAmout =parseFloat(fm.prpLclaimLossSumClaim[n].value)
 		
 		 for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==fm.prpLclaimLossCurrency[n].value && fm.exchCurrency[j].value==exchCurrency)
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
	    compAmout = compAmout + nowAmout*exchRate;
    }
    
	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
    fm.prpLdangerRiskSumClaim.value=pointTwo(compAmout);
  return true;
}


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
 			if(fm.prpLclaimRiskCode.value!="1537")
 			{
				if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossKindCode[n].value==fm.prpLclaimLossKindCode[j].value)&&(fm.prpLclaimLossLossFeeType[n].value==fm.prpLclaimLossLossFeeType[j].value))
				{
					errorMessage("��"+ n+"������������Ŀ���ұ𼰷������͵�"+ j+"������������Ŀ���ұ𼰷������һ�£���ϲ���2����¼");			
					fm.prpLclaimLossKindCode[n].focus();
					return false;
				}
			}
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
//Modify By dongcl remark end 20050623
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
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
/**
*�����������ӷ�����Ϣ�������
*/
function checkExes(){
   var claimLossLen = fm.prpLclaimLossKindCode.length;
   var strMsg = "";
   var prpLclaimLossSumClaim = 0;
   for(var i = 1; i < claimLossLen; i++) {
     var prpLclaimLossLossFeeType = fm.prpLclaimLossLossFeeType[i].value;
     if(prpLclaimLossLossFeeType=="Z"){
         prpLclaimLossSumClaim += parseFloat(fm.prpLclaimLossSumClaim[i].value);
     }
   }

   if(prpLclaimLossSumClaim == 0) {
       //strMsg += "�������������������Ϣ��";
     }
   if(strMsg != "") {
     alert(strMsg);
     return false;
   }
   return true;
}