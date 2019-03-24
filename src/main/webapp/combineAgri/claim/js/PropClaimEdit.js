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
	var allRegist = document.getElementsByName("registNo");
	var lengthOfRegist = allRegist.length;
    var message = "";
	if(null!=lengthOfRegist && lengthOfRegist > 0){
	   //�ж��Ƿ��ǹ������ٷ֡��ɶ�ҵ����Ϣ
	    var coinsFlag = fm.coinsFlag_0.value;
	    var shareHolderFlag = fm.shareHolderFlag_0.value;
	    var tempReinsFlag = fm.tempReinsFlag_0.value;
	     //add by qinyongli ���ӱ���ע��,���ɶ�ҵ�񣬵���ʾ�� 2005-7-28
	    
	    var othFlag = fm.prpLclaimOthFlag_0.value;
	    if(othFlag.substring(3,4)=="1"){
	     message = message + "�˱�����ע����\n";
	    }
	    var underWriteEndDate=fm.underWriteEndDate_0.value;
	    var prpLclaimStartDate = fm.prpLclaimStartDate_0.value;
	    if(shareHolderFlag!=0){
	       message = message + "�˱���Ϊ�ɶ�ҵ��\n";
	    }
	    var payFee = parseInt(fm.payFee_0.value);
	  	var delinquentfeeCase = fm.delinquentfeeCase_0.value;
	    if(payFee==-1){
	         message=message+"�˱�������δ��,�����ش������� \n";
	     }
	      else if(payFee==-2){
	           message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
	           message = message + delinquentfeeCase + "\n";
	     }
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

function sumLossAmountInformComAgri() {
         var returnString ="";
//	 var collectTemp = new Array();
//	 var elePrpLclaimLossCurrency = document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist);
//	 var elePrpLclaimLossCurrencyName = document.getElementsByName("prpLclaimLossCurrencyName_"+indexOfRegist);
//	 var elePrpLclaimLossSumClaim = document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist);
//	 for(var i=1;i<elePrpLclaimLossCurrency.length;i++){
//	    var hasElement = false;
//	    var currency = elePrpLclaimLossCurrency[i].value;
//	    var currencyName = elePrpLclaimLossCurrencyName[i].value;
//	    var sumLossAmount = 0;
//	    //ѭ���ֱұ�ͳ��
//	    for(var ii=1;ii<elePrpLclaimLossCurrency.length;ii++){
//	        if(currency==elePrpLclaimLossCurrency[ii].value){
//	             sumLossAmount = sumLossAmount + parseFloat(elePrpLclaimLossSumClaim[ii].value);
//	        }
//	    }
//	    //���жϵ�ǰ�������Ƿ����д˱ұ�,���û���ٽ��б���
//	    for(var j=0;j<collectTemp.length;j++){             
//	        if(collectTemp[j]==currency){hasElement=true;}
//	    }
//	    //�����ǰ�������д�Ԫ�أ����ٽ���ͳ��
//	
//	    if(hasElement){continue;}
//	    //����������
//	    collectTemp[i-1]= currency;
//	 }
 //            if(sumLossAmount>500000) {
 //                returnString = "��ʾ�����������ֵ���� "+currencyName+" ��ʮ��Ԫ��";
  //           }
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
	disabledAllButton('buttonArea');
  if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	{
		var bool = checkEarBeforeSave();
		
		if ( bool != true) {
			enableAllButton('buttonArea');
			return false;
		}
	}

// У�������
  if(!checkBeyondSumAmount()) {
  	enableAllButton('buttonArea');
    return false;
  }
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  
  var countRegist = getElementCount("registNoShow");
  if(null!=countRegist && countRegist>0){
  	for(var indexOfRegist=0;indexOfRegist<countRegist;indexOfRegist++){
		//����ʱ���Ƿ��ڱ����ڼ�
		  var startDate = document.getElementsByName("prpLclaimStartDate_"+indexOfRegist)[0].value;
		  var endDate   = document.getElementsByName("prpLclaimEndDate_"+indexOfRegist)[0].value;
		  var damageStartDate = document.getElementsByName("prpLclaimDamageStartDate_"+indexOfRegist)[0].value;
		
		  if((damageStartDate < startDate) || (damageStartDate > endDate)){
		       errorMessage = errorMessage + "��ʾ������ʱ���Ѿ����������ڼ䣬��������!";
		  }
		//textarea�ı�������ֵ
		  var context = document.getElementsByName("prpLltextContextInnerHTML_"+indexOfRegist)[0].value;
		  if(context.length<1){ 
		    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
		  }     
		  if (errorMessage.length>0) {
		    alert(errorMessage);
		    enableAllButton('buttonArea');
		    return false;
		  }
		  var claim_days = document.getElementsByName("claim_days_"+indexOfRegist)[0].value;
		  var standardDays = document.getElementsByName("standardDays_"+indexOfRegist)[0].value;
		  if(claim_days==0){
		  	if(!confirm("��"+indexOfRegist+"������,������������ϵͳ�涨ʱ��"+standardDays+"�죬�Ƿ��ύ��")){
		  		enableAllButton('buttonArea');
		  		return false;
		  	}
		   }
		
			if(document.getElementsByName("prpLclaimClassCode_"+indexOfRegist)[0].value == "31"){
				if(parseFloat(document.getElementsByName("prpLclaimDamageInsured_"+indexOfRegist)[0].value) < 1 || parseFloat(document.getElementsByName("prpLclaimDamageInsured_"+indexOfRegist)[0].value) > parseFloat(document.getElementsByName("prpLclaimSumInsured_"+indexOfRegist)[0].value)){
					alert("���ջ��α������0��С�ڵ��ڳб����Σ�");
					enableAllButton('buttonArea');
					return false;
				}
			}

		  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
		  initCombineMulLineFields('ClaimLoss_'+indexOfRegist+'_Data')

		  
		  //���������
		  if(!collectClaimLoss(indexOfRegist)){
			  enableAllButton('buttonArea');
		    return false;
		  }
		  
  	}

  	if(!(validateCombineRequired(fm) && validateCombineType(fm))){
  	  enableAllButton('buttonArea');
  	  return false;
    }
  	//reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
      
  // ����ʱ����50����ʾ��,���ȷ�Ϻ󷽿ɱ���,����ͣ����ҳ��
  if(confirm(sumLossAmountInformComAgri() + "\nȷ�ϼ����ύ��")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }
  }
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

//��ֳ�������н��б�����ԭ
function backWardPolicy(index){
     var SHOWTYPE  ="SHOW";
     var eleBizNo = document.getElementsByName("prpLclaimPolicyNo_"+index);
     var BizNo     = eleBizNo[0].value;//fm.prpLclaimPolicyNo.value;
     var eleRiskCode = document.getElementsByName("prpLclaimRiskCode_"+index);
     var RiskCode  =eleRiskCode[0].value;
     var eleDamageDate = document.getElementsByName("damageDate_"+index);
     var damageDate=eleDamageDate[0].value;//fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
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




//��ť�����¼���������ͬ��������౨������ʾ
function buttonOnClick(actionName,policyNo,curRegistNo,index)
{
  var allPerilCount = document.getElementsByName("PerilCount_"+index);
  var sameCount = parseInt(allPerilCount[0].value);
  if (sameCount <1)
  {
  	var buttonPerilOpenContext = document.getElementsByName("button_Peril_Open_Context_"+index);
  	buttonPerilOpenContext[0].disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}

/**
 * ��ʼ������ҳ��ķ���
 * �������maxLenght����.
 */
function initPage()
{
    var i=0;
    var j=0;
    var maxLength=0;
    var element;
    var schemaColumn;
    var method;
    var formCount = document.forms.length;
    for(i=0;i<formCount;i++){
    	var len = document.forms[i].elements.length;
    	var elements = document.forms[i].elements;
        for(j=0;j<len;j++){
            element = elements[j];

            if(element.name=="" || element.type == 'hidden'||element.type=='button'||element.type == 'select-one'||element.type=='submit')
            {
                continue;
            }
            var fieldName = element.name;	
			var fieldNameWithoutNumber = "";
			if(fieldName.indexOf("_")>-1)
				fieldNameWithoutNumber = fieldName.substring(0,fieldName.indexOf("_"));
			else fieldNameWithoutNumber = fieldName;
            schemaColumn = getCombineSchemaColumn1(fieldNameWithoutNumber);
            if(schemaColumn==null){
                log("�ֶ�" + fieldNameWithoutNumber + "û����ValidateData.js�ж���");
                continue;
            }

            //����maxLength
            if (element.type == 'text' ||
                element.type == 'textarea' ||
                element.type == 'password') {

                maxLength=getDataTypeMaxLength(schemaColumn.dataType);
                if(maxLength>0){
                    element.maxLength=maxLength;
                }
            }
            //���onkeypress�����¼�
            method = null;
            if(element.onkeypress!=null){
              method = element.onkeypress;
            }
            element.onkeypress=keypressHandler;
            if (method!=null){
                eval("element.onkeypress.prototype." + fieldNameWithoutNumber + "=" + method);
            } 
            //���onblur�����¼�
            //method = null;
            //if(element.onblur!=null){
            //  method = element.onblur;
            //}
            //element.onblur=blurHandler;
            //if (method!=null){
            //    eval("element.onblur.prototype." + element.name + "=" + method);
            //}

        }
    }      
}
 //��ť�����¼�,���ڸ����¹��ߴ���������Ϣ
function buttonOnClickOfBeneRisk(field,actionName,indexOfRegist)
{
  var orderCurrent = 0  ;   
  orderCurrent = parseInt(getElementOrder(field));
  var bizType = actionName;
  var elePersonFamilyNo = document.getElementsByName("prpLacciPersonFamilyNo_"+indexOfRegist)
  var familyNo = parseInt(elePersonFamilyNo[orderCurrent-1].value);
  if(isNaN(familyNo)){
    familyNo=0
  }
  if (familyNo <1)
  {
  	alert("��ѡ���¹��ߴ���");
  	return;
  }
  var elePolicyNo = document.getElementsByName("policyno_"+indexOfRegist);
  var policyno = elePolicyNo[0].value;
  var messagedo="/claim/beneInfoShow.do?serialNo="+familyNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}
//Modify By dongcl remark end 20050623
//�����ձ������Ϣ ,���ݱұ����
//add by qinyongli 2005-8-31 
function collectCurrency(indexOfRegist){
	 var collectCurr ="";
	 var collectTemp = new Array();
	 collectCurr = "�ֱұ���ܽ��:\n";
	 var elePrpLclaimLossCurrency = document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist);
	 var elePrpLclaimLossCurrencyName = document.getElementsByName("prpLclaimLossCurrencyName_"+indexOfRegist);
	 var elePrpLclaimLossSumClaim = document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist);
	 for(var i=1;i<elePrpLclaimLossCurrency.length;i++){
	    var hasElement = false;
	    var currency = elePrpLclaimLossCurrency[i].value;
	    var currencyName = elePrpLclaimLossCurrencyName[i].value;
	    var sumLossAmount = 0;
	    //ѭ���ֱұ�ͳ��
	    for(var ii=1;ii<elePrpLclaimLossCurrency.length;ii++){
	        if(currency==elePrpLclaimLossCurrency[ii].value){
	             sumLossAmount = sumLossAmount + parseFloat(elePrpLclaimLossSumClaim[ii].value);
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
*����δ��������ķ�������
*/
function taskClaimGiveup(){
	if(!confirm("ȷ��Ҫ��������")){
     return false;
   	}
  fm.action="/claim/claimBeforeEditCombine.do?editType=GIVUP";
  fm.submit();
     
}

 /**
 *@description ��������ҳ��
 *@param       prpLPolicyNo ��������
 *@return      ͨ������true,���򷵻�false
 */

 function relate(prpLPolicyNo,registNo){
    var policyNo = prpLPolicyNo;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo + "&registNo=" + registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return false;
}
/**
*�����������ӹ���������ڱ������
*/
function checkBeyondSumAmount(){
  
  var countRegist = getElementCount("registNoShow");
  if(countRegist > 0){
  	for(var indexOfRegist=0;indexOfRegist<countRegist;indexOfRegist++){
 
 	   var sumLoss = 0.00;
	   var claimLossLen = document.getElementsByName("prpLclaimLossKindCode_"+indexOfRegist).length;
	   var strMsg = "";
	   var prpLclaimLossSumClaim = 0;
	   var prpLclaimLossSumClaimP = 0;
	   var count = 0;
	   var classcode =document.getElementsByName("prpLclaimClassCode_"+indexOfRegist)[0].value;
	   for(var i = 1; i < claimLossLen; i++) {
	     if(classcode == '31'){
	        var arr = document.getElementByName("prpLclaimLossItemAmount_"+indexOfRegist)[i].value.split("-");
	        var itemKindAmount =arr[1];
	     }else{
	        var itemKindAmount = parseFloat(document.getElementsByName("prpLclaimLossItemAmount_"+indexOfRegist)[i].value); // �ձ𱣶�
	     } 
	     var itemClaimLoss = parseFloat(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[i].value);  // �ձ������
	     var kindName = document.getElementsByName("prpLclaimLossKindName_"+indexOfRegist)[i].value;
	     var prpLclaimLossLossFeeType = document.getElementsByName("prpLclaimLossLossFeeType_"+indexOfRegist)[i].value;
	     if(prpLclaimLossLossFeeType=="Z"){
	         prpLclaimLossSumClaim += parseFloat(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[i].value);
	         count++;
	     }
	     if(prpLclaimLossLossFeeType=="P"){
	         prpLclaimLossSumClaimP += parseFloat(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[i].value);
	     }
	     if(itemClaimLoss > itemKindAmount) {
	       strMsg += "�ձ�'" + kindName + "'�Ĺ���������ձ�ı��" + "\r\n";
	     }
	     
	   }
	   //У���ձ����������嵥�������Ƿ���� add by pao
	    if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	    {
	     var number = getElementCount("prplCompensateEarEstimateLoss_"+indexOfRegist);
	     
	     for(var k=1;k<number;k++){
	        sumLoss = sumLoss + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss_"+indexOfRegist)[k].value);
	     }
	     if(prpLclaimLossSumClaimP!=sumLoss){
	     alert("������Ϊ"+fm.registNo[indexOfRegist]+"���ձ�����������ܺͲ����ڶ�����嵥�������ܺͣ�������");
	     return false;
	     }
	   }
	   
	   //������ũ�ղ���¼�������Ϣ
	   var policyBizType = false;
	   if(document.getElementsByName("riskType_"+indexOfRegist)[0] != null){
	        var riskType = document.getElementsByName("riskType_"+indexOfRegist)[0].value;
	        if(riskType == "H"){
	            if(document.getElementsByName("prpLcompensateBusinessType1_"+indexOfRegist)[0] != null && (document.getElementsByName("prpLcompensateBusinessType1_"+indexOfRegist)[0].value == "01" || document.getElementsByName("prpLcompensateBusinessType1_"+indexOfRegist)[0].value == "02")){
	                policyBizType = true;
	            }
	        }
	   
	        if(policyBizType){
	            if(prpLclaimLossSumClaim > 0 || count > 0) {
	                //strMsg += "������ũ�ղ��������������������Ϣ��";
	            }
	        }else {
		       if(prpLclaimLossSumClaim == 0 && riskType!= "I") {
		           //strMsg += "�������������������Ϣ��";
		       }    
	        }
	}
	   var sumAmount = parseFloat(document.getElementsByName("prpLclaimSumAmount_"+indexOfRegist)[0].value);  // �ܱ���
	   var feeSumClaim = parseFloat(document.getElementsByName("prpLclaimSumClaim_"+indexOfRegist)[0].value); // �ܹ�����
	   if( feeSumClaim > sumAmount ){
	     strMsg += "�ܹ�����ܴ����ܱ��";
	   }
	   if(strMsg != "") {
	     alert(strMsg);
	     return false;
	   }
   	}
   }
   
   return true;
}

//Modify By dongcl remark begin 20050623
/**
 @description ���ܹ�����
 @param       ��
 @return      ��
 */
function collectClaimLoss(indexOfRegist)
{
	var compAmout =0;
	var nowAmout =0;
	var exchCurrency = document.getElementsByName("prpLclaimCurrency_"+indexOfRegist)[0].value;  //�õ���ǰ�ұ�����
	var exchRate = 1; //�һ���
	
	if (!checkLoss(indexOfRegist)) return false ; 
	//ѭ������ �����
	for( var n=1;n<document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist).length;n++)
 	{
 		nowAmout =parseFloat(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[n].value)
 		
 		 for ( j=1;j<document.getElementsByName("baseCurrency_"+indexOfRegist).length;j++)
         {
              if(document.getElementsByName("baseCurrency_"+indexOfRegist)[j].value==document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist)[n].value && document.getElementsByName("exchCurrency_"+indexOfRegist)[j].value==exchCurrency)
              {
                 exchRate = document.getElementsByName("exchRate_"+indexOfRegist)[j].value;
              }
         }
	    compAmout = compAmout + nowAmout*exchRate;
    }
 
	document.getElementsByName("prpLclaimSumClaim_"+indexOfRegist)[0].value=pointTwo(compAmout);
    document.getElementsByName("prpLdangerRiskSumClaim_"+indexOfRegist)[0].value=pointTwo(compAmout);
  return true;
}
/**
 @description У��������
 @param       ��
 @return      boolean
 */
function checkLoss(indexOfRegist)
{
	//1.������Ҫ��һ����¼
  if(getRowsCount("ClaimLoss_"+indexOfRegist)==0)
  {
		errorMessage("����������Ϣ����Ҫ��һ����¼!");				
	
		return false;  
  }
	//2�ұ���Ϊ�յ�
 
  for( var j=1;j<document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist).length;j++)
 	{
		if (isEmptyField(document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist)[j]))
		{
			errorMessage("��"+ j+"���������бұ���Ϊ��!");			
			return false;
		}
		
		if(isEmptyField(document.getElementsByName("prpLclaimLossKindCode_"+indexOfRegist)[j]))
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
 
		if(isEmptyField(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[j]))
		{ 
			errorMessage("��"+j+"���¹ʹ������н���Ϊ��!");			
			//fm.prpLclaimLossSumClaim[j].focus();
			return false;
		}
 
 	}	
 
	return true; 	
}
function initSpan()
{
	var showFlag = document.getElementsByName("registNoShow");
		showFlag[0].checked = true;
	var spanOneClaim = document.getElementById("spanOneClaim_"+0);
	
	spanOneClaim.style.display = "";

}