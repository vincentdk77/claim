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
{ 
   //�ж��Ƿ��ǹ������ٷ֡��ɶ�ҵ����Ϣ
    var coinsFlag = fm.coinsFlag.value;	
    var shareHolderFlag = fm.shareHolderFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var message = "";
     //add by qinyongli ���ӱ���ע��,���ɶ�ҵ�񣬵���ʾ�� 2005-7-28
    var coinsFlag = fm.coinsFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var shareHolderFlag = fm.shareHolderFlag.value;
    var message = "";
    
    var othFlag = fm.prpLclaimOthFlag.value;
    if(othFlag.substring(3,4)=="1"){
     message = message + "�˱�����ע����\n";
    }
    var underWriteEndDate=fm.underWriteEndDate.value;
    var prpLclaimStartDate = fm.prpLclaimStartDate.value;
    if(shareHolderFlag!=0){
       message = message + "�˱���Ϊ�ɶ�ҵ��\n";
    }
    var payFee = parseInt(fm.payFee.value);
  	var delinquentfeeCase = fm.delinquentfeeCase.value;
    if(payFee==-1){
         message=message+"�˱�������δ��,�����ش������� \n";
     }
      else if(payFee==-2){
           message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
           message = message + delinquentfeeCase + "\n";
     }
    if (message.length>0) {
    alert(message);
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

function sumLossAmountInformAgri() {
         var returnString ="";
//         var collectTemp = new Array();
//         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
//           var hasElement = false;
//            var currency = fm.prpLclaimLossCurrency[i].value;
//           var currencyName = fm.prpLclaimLossCurrencyName[i].value;
//            var sumLossAmount = 0;
//           //ѭ���ֱұ�ͳ��
//            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
//                if(currency==fm.prpLclaimLossCurrency[ii].value){
//                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
//                }
//            }
//            //���жϵ�ǰ�������Ƿ����д˱ұ�,���û���ٽ��б���
//            for(var j=0;j<collectTemp.length;j++){             
//                if(collectTemp[j]==currency){hasElement=true;}
//            }
//            //�����ǰ�������д�Ԫ�أ����ٽ���ͳ��
//
//            if(hasElement){continue;}
//            //����������
//            collectTemp[i-1]= currency;
//         }
//             if(sumLossAmount>500000) {
//                 returnString = "��ʾ�����������ֵ���� "+currencyName+" ��ʮ��Ԫ��";
//             }
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
  if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	{
		var bool = checkEarBeforeSave();
		if ( bool != true) return false;
	}
  // У�������
  if(!checkBeyondSumAmount()) {
    return false;
  }  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //����ʱ���Ƿ��ڱ����ڼ�
  var startDate = fm.prpLclaimStartDate.value;
  var endDate   = fm.prpLclaimEndDate.value;
  var damageStartDate = fm.prpLclaimDamageStartDate.value;
  
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
       errorMessage = errorMessage + "��ʾ������ʱ���Ѿ����������ڼ䣬��������!";
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
  var claim_days = fm.claim_days.value;
  var standardDays = fm.standardDays.value;
  if(claim_days==0){
  	if(!confirm("������������ϵͳ�涨ʱ��"+standardDays+"�죬�Ƿ��ύ��")){
  		return false;
  	}
   }

	if(fm.prpLclaimClassCode.value == "31"){
		if(parseFloat(fm.prpLclaimDamageInsured.value) < 1 || parseFloat(fm.prpLclaimDamageInsured.value) > parseFloat(fm.prpLclaimSumInsured.value) ){
			alert("���ջ��α������0��С�ڵ��ڳб����Σ�");
			return false;
		}
	
	}
	//����������У��
	if(fm.prpLclaimClassCode.value == "31"){
	   if("" == fm.prpLclaimLossQuantity.value || 0>=parseInt(fm.prpLclaimLossQuantity.value)){
	     alert("������������С�ڻ����0��");
	     return false;
	   }
	}

  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm,"ClaimLoss_Data")){
   return false;
  }
  
  //���������
  if(!collectClaimLoss()){
    return false;
  }
  
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
      
  // ����ʱ����50����ʾ��,���ȷ�Ϻ󷽿ɱ���,����ͣ����ҳ��
  if(confirm(sumLossAmountInformAgri() + "\nȷ�ϼ����ύ��")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }  	
}

//��������ȫ���ύ
function saveCombine(field){
    var sumLoss = 0.00;
    var sumAmount = parseFloat(fm.prpLclaimSumAmount.value);
    var prpLestimateLoss = fm.all("prpLestimateLoss");
    
    var nodeStatus = fm.all("prpLnodeStatus"); 
    for(var index=0;index<nodeStatus.length;index++){
      if(nodeStatus[index].value=="0"){
        alert("������"+fm.prpLregistNo[index].value+"Ϊδ�����������봦������ύ��");
        return false;
      }
    }
    for(var i =0;i<prpLestimateLoss.length;i++){
       sumLoss = parseFloat(sumLoss) + parseFloat(prpLestimateLoss[i].value);
    }
    if(sumLoss>sumAmount){
      alert("Ԥ�Ƹ��������ñ����ı��ս��!!");
      return false;
    }
    fm.buttonSaveType.value = "4";
    field.disabled = true;
    fm.submit();
  
  return true; 
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


//�õ�һҳ�Ķ��м�¼�ļ�¼��
//ҳ����
function getRowsCount(PageCode)
{
  var oTBODY   = document.all(PageCode).tBodies.item(0);
  var intCount = oTBODY.rows.length;
  return intCount;
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
			return false;
		}
		
		if(isEmptyField(fm.prpLclaimLossKindCode[j]))
		{ 
			errorMessage("��"+j+"���¹ʹ��������ձ���벻��Ϊ��!");			
			return false;
		}
		
		//alert(fm.prpLclaimLossKindCode[j].value)
 
//�ձ�ͱұ���ͬ�ģ�����ϲ�
/*
  	for( var n=j+1;n<fm.prpLclaimLossCurrency.length;n++)
 		{
			if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossItemCode[n].value==fm.prpLclaimLossItemCode[j].value)&&(fm.prpLclaimLossLossFeeType[n].value==fm.prpLclaimLossLossFeeType[j].value))
			{
				errorMessage("��"+ n+"������������Ŀ���ұ𼰷������͵�"+ j+"������������Ŀ���ұ𼰷������һ�£���ϲ���2����¼");			
			
				fm.prpLclaimLossKindCode[n].focus();
				return false;
			}
		}
*/
 
		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		{ 
			errorMessage("��"+j+"���¹ʹ������н���Ϊ��!");			
			//fm.prpLclaimLossSumClaim[j].focus();
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
     var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
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



function printFH()
{
    var BizNo     =fm.prpLclaimPolicyNo.value;
    var RiskCode  =fm.prpLclaimRiskCode.value;
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL =  CoreWebUrl +'/' + RiskCode + '/cb/UIPolicy' + RiskCode + 'FHNoneFormatPrint.jsp?EDITTYPE=POLICY&FlagForPrint=46&BizNo='+ BizNo;
    window.open(vURL,'�ֻ��嵥��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
//yx
function checkclaimNumber(){
var claimNumber = fm.prpLclaimLossclaimNumber.value;
if(!claimNumber==null || claimNumber==""){
     alert("�⸶��������Ϊ��");
     return false;
     }
}

/**
*�����������ӹ���������ڱ������
*/
function checkBeyondSumAmount(){
  var sumLoss = 0.00;
 
   var claimLossLen = fm.prpLclaimLossKindCode.length;
   var strMsg = "";
   var prpLclaimLossSumClaim = 0;
   var prpLclaimLossSumClaimP = 0;
   var count = 0;
   var classcode =fm.prpLclaimClassCode.value;
   for(var i = 1; i < claimLossLen; i++) {
     if(classcode == '31'||classcode == '32'){
        var arr = fm.prpLclaimLossItemAmount[i].value.split("-");
        var itemKindAmount =arr[1];
     }else{
        var itemKindAmount = parseFloat(fm.prpLclaimLossItemAmount[i].value); // �ձ𱣶�
     } 
     var itemClaimLoss = parseFloat(fm.prpLclaimLossSumClaim[i].value);  // �ձ������
     var kindName = fm.prpLclaimLossKindName[i].value;
     var prpLclaimLossLossFeeType = fm.prpLclaimLossLossFeeType[i].value;
     if(prpLclaimLossLossFeeType=="Z"){
         prpLclaimLossSumClaim += parseFloat(fm.prpLclaimLossSumClaim[i].value);
         count++;
     }
      if(prpLclaimLossLossFeeType=="P"){
         prpLclaimLossSumClaimP += parseFloat(fm.prpLclaimLossSumClaim[i].value);
     }
     if(itemClaimLoss > itemKindAmount) {
       strMsg += "�ձ�'" + kindName + "'�Ĺ���������ձ�ı��" + "\r\n";
     }
     
   }
   //У���ձ����������嵥�������Ƿ���� add by pao
   if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
   {
     var number = getElementCount("prplCompensateEarEstimateLoss");
     
     for(var k=1;k<number;k++){
        sumLoss = sumLoss + parseFloat(fm.prplCompensateEarEstimateLoss[k].value); 
     }
     sumLoss = sumLoss.toFixed(2);//������������ľ��Ȳ��������ύУ��
     if(prpLclaimLossSumClaimP!=sumLoss){
     alert("�ձ�����������ܺͲ����ڶ�����嵥�������ܺͣ�������");
     return false;
     }
   }
   
   //������ũ�ղ���¼�������Ϣ
   var policyBizType = false;
   if(fm.riskType != null){
        var riskType = fm.riskType.value;
        if(riskType == "H"){
            if(fm.prpLcompensateBusinessType1 != null && (fm.prpLcompensateBusinessType1.value == "01" || fm.prpLcompensateBusinessType1.value == "02")){
                policyBizType = true;
            }
        }
   
        if(policyBizType){
            if(prpLclaimLossSumClaim > 0 || count > 0) {
                //strMsg += "������ũ�ղ��������������������Ϣ��";
            }
        }else {
	       if(prpLclaimLossSumClaim == 0 && riskType!= "I") {
	          // strMsg += "�������������������Ϣ��";
	       }    
        }
}
   var sumAmount = parseFloat(fm.prpLclaimSumAmount.value);  // �ܱ���
   var feeSumClaim = parseFloat(fm.prpLclaimSumClaim.value); // �ܹ�����
   if( feeSumClaim > sumAmount ){
     strMsg += "�ܹ�����ܴ����ܱ��";
   }
   if(strMsg != "") {
     alert(strMsg);
     return false;
   }
   
   return true;
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

/** 
	����������ŵ���ȷ�Լ�������Ӧ����Ϣ��
*/
 function earnoCheck(){
 	  var policyNo   = fm.prpLclaimPolicyNo.value;
 	  if(null==policyNo || trim(policyNo).length == 0) {
 	 	  alert("�ޱ�����");
  		return;
 	  }
	 var checkEarInputFormatResult = checkEarInputFormat();
	 if(!checkEarInputFormatResult)
	 	return false;
	 var nodeType   = fm.getEarNoFrom.value;
	 var vPrpLearNoLength = getElementCount("prpLearNo");
	 var earNo = "";
	 if(vPrpLearNoLength>1){
	 	for(var index = 0; index < vPrpLearNoLength; index++){
	 		var earNoTemp = fm.prpLearNo[index].value;
	 		if(null!=earNoTemp && ""!= trim(earNoTemp)){
	 			if(""==earNo)
	 				earNo = earNoTemp;
	 			else earNo = earNo + "," +earNoTemp;
	 		}
	 	}
	 }
	 if(earNo != "")
	 	getEarResult(policyNo,earNo,nodeType);
	 else alert("����Ų���Ϊ��");

}
      
function getEarResult(policyno,earno,nodeType){
    var url =  "/claim/combineAgri/claim/getAgriClaimEarList.jsp?policyNo="+policyno+"&earList="+earno+"&nodeType="+nodeType;
    var xmlDoc = getResponseXmlText(url);
	var earNoList = xmlDoc.getElementsByTagName("prpLEarNoList");
	var singleEarNoInfoList = earNoList[0].childNodes;
	var checkResult = "true";
	var unRealEarNo = "";
	if(null!= singleEarNoInfoList && singleEarNoInfoList.length>0){
		for(var i=0; i<singleEarNoInfoList.length; i++){
			var singleEarNoInfo = singleEarNoInfoList[i];
			var info = singleEarNoInfo.childNodes;
			var getEarNoFrom = xmlDoc.getElementsByTagName("GetEarNoFrom")[i];
			if(null!=getEarNoFrom){
				var strGetEarNoFrom = getEarNoFrom.text;
				if("prplcompensateear"==strGetEarNoFrom || "herdpolicylist"==strGetEarNoFrom){
					var vPrpLearNoLength = getElementCount("prpLearNo");
					var earNo = xmlDoc.getElementsByTagName("prpLearNo")[i].text;
					for(var index=1;index<vPrpLearNoLength;index++){
						var earNoHTML = fm.prpLearNo[index].value;
						var earNoIsNewInput = fm.earNoIsNewInput[index].value;
						if(earNo == earNoHTML && earNoIsNewInput){
							fm.fname[index].value = info[1].text;
							fm.idCard[index].value = info[2].text;
							fm.bank[index].value = info[3].text;
							fm.account[index].value = info[4].text;
							if(null == info[5].text || "" == info[5].text)
								fm.estimateLoss[index].value = 1000;
							else 
								fm.estimateLoss[index].value = info[5].text;
						}
					}
				}else if("None"==strGetEarNoFrom){
					var vPrpLearNoLength = getElementCount("prpLearNo");
					var earNo = xmlDoc.getElementsByTagName("prpLearNo")[i].text;
					for(var index=1;index<vPrpLearNoLength;index++){
						var earNoHTML = fm.prpLearNo[index].value;
						var earNoIsNewInput = fm.earNoIsNewInput[index].value;
						if(earNo == earNoHTML && earNoIsNewInput){
							fm.fname[index].value = "";
							fm.idCard[index].value = "";
							fm.bank[index].value = "";
							fm.account[index].value = "";
							fm.estimateLoss[index].value = "";
						}
					}
					if(""==unRealEarNo)
						unRealEarNo = info[0].text;
					else 
						unRealEarNo = unRealEarNo+","+info[0].text;
					updateValueofEarCheck();
				}
			}else updateValueofEarCheck();
			
		}
	}
	if(""!=unRealEarNo)
		alert("����ţ�"+unRealEarNo+" �����ڣ���������д��");
	else{
		fm.valueofEarCheck.value="true";
		alert("�������֤ͨ������������룡");
	}
}
	

//������ŵ������Ƿ��п�ֵ�������ظ���
function checkEarInputFormat(){
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength == 1){
		alert("�������Ϣ����Ϊ��");
		return false;
	}
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			if(isEmptyField(fm.prpLearNo[i])){
				alert("��"+i+"�ж�����б���Ϣ�Ķ���Ų���Ϊ�գ�");
	 			return false;
			}
		}
	}
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			for(var j = i + 1;j < vPrpLearNoLength;j++){
	  			if(fm.prpLearNo[i].value == fm.prpLearNo[j].value){
					alert("�������Ϣ�б��У���"+i+"�к͵�"+j+"���ظ�!");
			 		return false;
	  			}
	 		}
	  	}
	}
	return true;
}
function updateValueofEarCheck(){
	fm.valueofEarCheck.value="false";
}

//ʹ��xmlhttp����ҳ�棬����ȡ����(�Ʋ�¬����20030407)
function getResponseXmlText(strURL)
{
  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  objXmlHttp.Open("POST",strURL,false);
  objXmlHttp.setRequestHeader("Content-type","text/xml");
  objXmlHttp.Send("");
  if(objXmlHttp.status==200)
  {
    return objXmlHttp.responseXML;
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

function updateValueNewInput(field){
	var earNoInput = field.value;
	var vPrpLearNoLength = getElementCount("prpLearNo");
	for(var i=0;i<vPrpLearNoLength;i++){
		var earNo = fm.prpLearNo[i].value;
		if(null!=earNo && earNo == earNoInput)
			fm.earNoIsNewInput.value = "true"; 
	}
}
/**
 * Ԥ�����嵥ҳ�浯��
 */
 function openCompensateSettleListPage(editType,nodeType){
    var policyNo = fm.policyno.value;
	var registNo = fm.registno.value;
 	var newWindow = window.open("/claim/settleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
 }
 
 /**
 * Ԥ�����嵥ҳ�浯��
 */
 function openCompensate31SettleListPage(editType,nodeType){
    var policyNo = fm.policyno.value;
	var registNo = fm.registno.value;
 	var newWindow = window.open("/claim/planting31SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
 }
 
 /**
 * Ԥ�����嵥ҳ�浯��
 */
 function openCompensate3224SettleListPage(editType,nodeType){
    var policyNo = fm.policyno.value;
	var registNo = fm.registno.value;
 	var newWindow = window.open("/claim/planting3224SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
 }
 
 //�ѳ��մ���ҳ��"..."��ť�����¼���������ͬ��������౨������ʾ add by xuecheng
function buttonOnClickAgriCheck(actionName,policyNo,curRegistNo)
{
  var allPerilCount = document.getElementsByName("PerilCount");
  var sameCount = parseInt(allPerilCount[0].value);
  if (sameCount <1)
  {
  	var buttonPerilOpenContext = document.getElementsByName("button_Peril_Open_Context");
  	buttonPerilOpenContext[0].disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}