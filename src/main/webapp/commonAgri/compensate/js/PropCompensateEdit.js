/*****************************************************************************
 * DESC       ��ʵ��Ľű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-05-19
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
//������������ֲ�����¼�������Ϣ
 	if(checkBusinessType1()==false)
 	{
 	   return false;
 	}
 	
   return true;    
}

 var sumSettleCount = -1;//�����嵥�ܻ���
 var sumSettleArea  = -1;//�����嵥��Ķ��
/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{
	//if(null!=fm.editTypeAgri&&null!=fm.editTypeAgri.value&&fm.editTypeAgri.value=="EDIT"){
  //  	  var riskCode = fm.riskcode.value;
  //		  var configRisk = '3101-3107-3108-3114-3122-3126'; 
	//    	if(configRisk.indexOf(riskCode)>-1){
	//		  	if(null!=fm.claimRelationNo&&null!=fm.claimRelationNo.value&&fm.claimRelationNo.value!=""){
	//				changeRelateListSum(fm.claimRelationNo,fm.riskcode);//�����嵥�ܻ�������Ķ����ֵ
	//		  	}
	//     	 }
 //   }
   //�ж��Ƿ��ǹ�����
    var coinsFlag = fm.coinsFlag.value;	
    var shareHolderFlag = fm.shareHolderFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var message = "";
  //add by hanliang end  2005-12-22
  var payFee = parseInt(fm.payFee.value);
  var delinquentfeeCase = fm.delinquentfeeCase.value;  
  if(payFee==-1){
    alert("�˱�������δ�ɣ�\n");
  } 
  else if(payFee==0){
    alert("�˱�������δ��ȫ��\n");
  }else if(payFee==-2){
     message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
     message = message + delinquentfeeCase + "\n";
  }
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
    
    return true;
}
function GenerateCtextFlag(flag)   
{
  fm.GenerateCompensateFlag.value=flag; 
  /*
  var span1 = eval("spanPerson");    
  var span2 = eval("spanCharge");  
  var span3 = eval("spanlLoss");       
  span1.style.display="none"; 
  span2.style.display="none";  
  span3.style.display="none";    
  span1.src="/claim/images/butCollapseBlue.gif";
  span2.src="/claim/images/butCollapseBlue.gif";
  span3.src="/claim/images/butCollapseBlue.gif";  
  */
}  
/**
 *@description �ύ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function submitForm()
{
  fm.buttonApprove.disabled = true;
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
 
function feeCoinsCalculate(){
	 $.ajax({
			url:'/claim/compensateChargeFeeBeforeEdit.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,success:function(result){
		 		$("#chargeInfo").html(result).show();
			}       
		});
}

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{
  var ChargeAmount=document.getElementsByName('prpLchargeChargeAmount');
  var ChargeCode=document.getElementsByName('prpLchargeChargeCode');
  var CheckDeptCode=document.getElementsByName('prpLchargeCheckDeptCode');
  for(var i=1;i<ChargeCode.length;i++){
     if(ChargeCode[i]!=null&&ChargeCode[i].value=='14'&&ChargeAmount[i]!=null&&ChargeAmount[i].value!=0){
         if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value==''){
            alert("��¼��ϵͳ�ڴ��鿱��ʱ,����¼����鿱��������");
            return false;
         }else{
            if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value.length>=10){
              var CheckCode= CheckDeptCode[i].value.substring(6,10);
              if(CheckCode=='0000'){
                 alert("���鿱������Ҫ¼�뵽���ţ���");
                 return false;
              }
            }
         }
     }
  }
  if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	{
		var bool = checkEarBeforeSave();
		if ( bool != true) return false;
	}
  var errorMessage = ""; 
  //����ר�ŵı���У��ķ���
  if(checkForm()==false)
  {
    return false;
  }
  var riskType = fm.riskType.value;    //����
  if(riskType == "I" && fm.prpLcompensateLossesNumber != null && fm.prpLcompensateLossesNumber.value >=0){
  		
	    if(fm.prpLcompensateLossesNumber != null && fm.prpLcompensateLossesNumber.value <= 0){
	        alert("�⸶��������С�ڻ����0");
	        fm.prpLcompensateLossesNumber.focus();
	        fm.prpLcompensateLossesNumber.select();
	        return false;
	    }
	    if(fm.prpLcompensateDamageInsured != null && fm.prpLcompensateDamageInsured.value <= 0){
	        alert("���滧�β���С�ڻ����0");
	        fm.prpLcompensateDamageInsured.focus();
	        fm.prpLcompensateDamageInsured.select();
	        return false;
	    }
	    // ����۸��ղ���Ҫ����У��
        if(  (fm.prpLcompensateKillQuantity != null && fm.prpLcompensateKillQuantity.value == 0)
          && (fm.prpLcompensateDeathQuantity != null && fm.prpLcompensateDeathQuantity.value == 0)
          && fm.riskcode.value != "3229"){
            alert("��ɱ������������������ͬʱΪ0");
            fm.prpLcompensateKillQuantity.focus();
            fm.prpLcompensateKillQuantity.select();
            return false;
        }
        if(fm.prpLcompensateKillQuantity != null && fm.prpLcompensateKillQuantity.value < 0){
            alert("��ɱ��������С��0");
            fm.prpLcompensateKillQuantity.focus();
            fm.prpLcompensateKillQuantity.select();
            return false;
        }
        if(fm.prpLcompensateDeathQuantity != null && fm.prpLcompensateDeathQuantity.value < 0){
            alert("������������С��0");
            fm.prpLcompensateDeathQuantity.focus();
            fm.prpLcompensateDeathQuantity.select();
            return false;
        }
        
  }else if(riskType == "H"){
        var SumDutyPaid         = parseFloat(fm.prpLcompensateSumDutyPaid.value);       //�����
        var LossesNumber        = parseFloat(fm.prpLcompensateLossesNumber.value);      //�⸶���
        var DamageInsured       = parseFloat(fm.prpLcompensateDamageInsured.value);     //���滧��
        var DisasterArea        = parseFloat(fm.prpLcompensateDisasterArea.value);      //�������
        var AffectedArea        = parseFloat(fm.prpLcompensateAffectedArea.value);      //�������
        var NoProductionArea    = parseFloat(fm.prpLcompensateNoProductionArea.value);  //�������
        var SumInsured          = parseFloat(fm.prpLcompensateSumInsured.value);        //�б�����
        var recaseFlag          = fm.recaseFlag.value;                                   //�ؿ��ⰸ��־
        var sumDamageInsured    = parseFloat(fm.sumDamageInsured.value)	;				//�����滧��
        var dbSumPaid           = parseFloat(fm.dbSumPaid.value);							//���⸶���
        var dbLossNumber        = parseFloat(fm.dbLossNumber.value);					//���⸶���
        var prpLcompensateSumPaid = parseFloat(fm.prpLcompensateSumPaid.value);			//�⸶���
        var dbSumDutyPaid 		= parseFloat(fm.dbSumDutyPaid.value);					//�������
        if(isNaN(SumDutyPaid))
            SumDutyPaid = 0;
        if(isNaN(LossesNumber))
            LossesNumber = 0;
        if(isNaN(DamageInsured))
            DamageInsured = 0;
        if(isNaN(DisasterArea))
            DisasterArea = 0;
        if(isNaN(AffectedArea))
            AffectedArea = 0;
        if(isNaN(NoProductionArea))
            NoProductionArea = 0;
        //�ǵ�һ������ʱ�������滧�Σ����⸶���б�����֮��Ŀ���
        if(recaseFlag == "1"){
        	dbSumDutyPaid += SumDutyPaid;
        	sumDamageInsured += DamageInsured;
        	dbLossNumber += LossesNumber;
        	if(sumDamageInsured > SumInsured || sumDamageInsured < 0){
        		alert("�����滧�β���С��0�Ҳ��ܴ��ڳб����Σ�");
        		return false;
        	}
        	if(dbSumDutyPaid < 0 ){
	        	alert("��������С���㣡");
	        	return false;
	        }else if(dbSumDutyPaid > 0){
	        	if(sumDamageInsured == 0){
	        		alert("������������ʱ���ܵ����滧�β��ܵ�����");
	        		return false;
	        	}
	        	if(dbLossNumber == 0){
	        		alert("������������ʱ���ܡ��⸶����/��������ܵ����㣡");
	        		return false;
	        	}
	        }else{
	        	if(sumDamageInsured != 0){
	        		alert("������������ʱ�������滧�α�������㣡");
	        		return false;
	        	}
	        	if(dbLossNumber != 0){
	        		alert("������������ʱ�����⸶����/�����������㣡");
	        		return false;
	        	}
	        }
	       
	   }else{//��һ������ʱ�������滧�Σ����⸶���б�����֮��Ŀ���
	        if(DamageInsured < 0 || DamageInsured > SumInsured){
	            alert("���滧�α�����ڵ���0��С�ڵ��ڳб�����");
	            fm.prpLcompensateDamageInsured.focus();
	            fm.prpLcompensateDamageInsured.select();
	            return false;
	        }
	        if(prpLcompensateSumPaid < 0 ){
	        	alert("��������С���㣡");
	        	return false;
	        }
	        //���ⰸ�����
	        if(SumDutyPaid == 0){
	            if(LossesNumber > 0){
	                alert("���ⰸʱ�⸶�������ܴ���0");
	                fm.prpLcompensateLossesNumber.focus();
	                fm.prpLcompensateLossesNumber.select();
	                return false;
	            }
	            if(DamageInsured > 0){
	                alert("���ⰸʱ���滧�β��ܴ���0");
	                fm.prpLcompensateDamageInsured.focus();
	                fm.prpLcompensateDamageInsured.select();
	                return false;
	            }  
	        //�����ⰸ�����          
	        }else if(SumDutyPaid > 0){
	            if(LossesNumber <= 0 ){
	                alert("�⸶�������С�ڵ���0");
	                fm.prpLcompensateLossesNumber.focus();
	                fm.prpLcompensateLossesNumber.select();
	                return false;
	
	            }
	            if(DamageInsured <= 0){
	                alert("���滧�β���С�ڵ���0");
	                fm.prpLcompensateDamageInsured.focus();
	                fm.prpLcompensateDamageInsured.select();
	                return false;
	            
	            }
	            if(AffectedArea <= 0){
	                alert("�����������С�ڵ���0");
	                fm.prpLcompensateAffectedArea.focus();
	                fm.prpLcompensateAffectedArea.select();
	                return false;
	
	            }
	            
	        }
			        
	   }
        if(LossesNumber >=0){
	        /*if(LossesNumber < 0){
	            alert("�⸶�������С��0");
	            fm.prpLcompensateLossesNumber.focus();
	            fm.prpLcompensateLossesNumber.select();
	            return false;
	        }
	        if(DamageInsured < 0){
	            alert("���滧�β���С��0");
	            fm.prpLcompensateDamageInsured.focus();
	            fm.prpLcompensateDamageInsured.select();
	            return false;
	        }
	        if(AffectedArea < 0){
	            alert("�����������С��0");
	            fm.prpLcompensateAffectedArea.focus();
	            fm.prpLcompensateAffectedArea.select();
	            return false;
	        }
	        if(NoProductionArea < 0){
	            alert("�����������С��0");
	            fm.prpLcompensateNoProductionArea.focus();
	            fm.prpLcompensateNoProductionArea.select();
	            return false;
	        }
	        if(DisasterArea <= 0){
	            alert("�����������С�ڻ����0");
	            fm.prpLcompensateDisasterArea.focus();
	            fm.prpLcompensateDisasterArea.select();
	            return false;
	        }*/
	        if(AffectedArea < LossesNumber){
	            alert("�����������С���⸶���");
	            fm.prpLcompensateAffectedArea.focus();
	            fm.prpLcompensateAffectedArea.select();
	            return false;
	        }
	        if(NoProductionArea > AffectedArea){
	            alert("����������ܴ��ڳ������");
	            fm.prpLcompensateNoProductionArea.focus();
	            fm.prpLcompensateNoProductionArea.select();
	            return false;
	        }
	        if(AffectedArea > DisasterArea){
	            alert("����������ܴ����������");
	            fm.prpLcompensateAffectedArea.focus();
	            fm.prpLcompensateAffectedArea.select();
	            return false;
	            
	        }
	              
        }
          //��ֲ���������󣺺˶���ʧ����ʧ�ʲ���Ϊ��
   var count = getElementCount("prpLlossDtoSumLoss");
   for(var  i =1; i < count; i++){
     var prpLlossDtoSumLoss = fm.prpLlossDtoSumLoss[i].value;
     var indemnityDutyRate = fm.indemnityDutyRate[i].value;
     if(prpLlossDtoSumLoss==null || prpLlossDtoSumLoss=='' || prpLlossDtoSumLoss==0){
      alert("�˶���ʧ����Ϊ�ջ�Ϊ��");
      return false;
     }
     if(indemnityDutyRate==null || indemnityDutyRate=='' || indemnityDutyRate==0){
      alert("��ʧ�ʲ���Ϊ�ջ�Ϊ��");
      return false;
     }
    }
  }
  fm.buttonSaveType.value = saveType; 
  //�Զ���Ǽ�ҳ���е�����ֶν��д���0�Ŀ���

  
//�⸶�����Ϣ���
  if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else if(null != fm.planting31FarmerListFlag.value && fm.planting31FarmerListFlag.value.indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else{
  if(fm.prpLlossDtoKindCode.length!=undefined){
    for(i=1;i<fm.prpLlossDtoKindCode.length;i++){
      if(fm.prpLlossDtoKindCode[i].value=="" || fm.prpLlossDtoKindName[i].value == ""){
		  errorMessage = errorMessage + "����д��"+i+"���⸶����ձ���Ϣ\n";
	  }
	  if(fm.prpLlossDtoItemCode[i].value=="" || fm.prpLlossDtoLossName[i].value == ""){
		  errorMessage = errorMessage + "����д��"+i+"���⸶��ĵı����Ϣ\n";
	  }
	}
  }
  }
  //textarea�ı�������ֵ
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "��������̲�����Ϊ��\n";
  }  
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)>round(parseFloat(fm.prpLcompensateSumAmount.value),2)){
    errorMessage = errorMessage + "���⳥���ܴ����ܱ��ս��\n";
  }
  if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else if(null != fm.planting31FarmerListFlag.value && fm.planting31FarmerListFlag.value.indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else{
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    errorMessage = errorMessage + "���ϼƲ�����Σ�յ�λ��Ϣ���ʵ����";
  }
  }
  //����ʵ��ͬԤ���ϵ�ж� begin
  if(fm.times.value == 1){//�״�������ʵ��ͬԤ���У�飬�ؿ�����У��
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("������С����Ԥ������");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("�������ò���С����Ԥ�����ý�");
    return false;
  }
  }
  //����ʵ��ͬԤ���ϵ�ж� end
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){  
  //add by lixiang start at 2006-8-1	
  //�ж����㱨���ǲ���Ϊ�յġ�	
  var 	context2=fm.prpLltextContextInnerHTML.value;
  var   lltext2title=fm.tdLltextTitle.value;
  
  if(context2.length<1){
    errorMessage = errorMessage +lltext2title+ "������Ϊ��\n";
     alert(errorMessage)
     return false;
  }
  //add by lixiang end at 2006-8-1	
  
    //�⸶�����Ϣ���⸶��Ա��Ϣ������һ������д���������ύʵ��
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;
    if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(fm.prpLcompensateRiskCode.value) > -1){
    }else if(null != fm.planting31FarmerListFlag.value && fm.planting31FarmerListFlag.value.indexOf(fm.prpLcompensateRiskCode.value) > -1){
  	}else if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    { 
      alert("���������е��⸶��ģ�������������һ����¼!"); 
      return false; 
    }
	//����������÷�̯
    var coinsFlag = fm.coinsFlag.value;	
	if(coinsFlag == "2"||coinsFlag == "1"){
	    var ChargeFeeFlag = fm.CommonCoinsChargeFeeFlag.value;	
	    if(ChargeFeeFlag == 1){
        	var prpLchargeChargeName = document.getElementsByName('prpLchargeChargeName');
        	var ChargeCoinsName = document.getElementsByName('ChargeCoinsName');
        	var size = document.getElementsByName('CoinsCode').length-1;
        	if(prpLchargeChargeName.length-1 != ChargeCoinsName.length/size){
        		alert("����������Ϣҳ���µĹ������÷�̯��ť��");
        		return false;
        	}
    	}
    }
  }
  //���������� ��ֲ�� ���������嵥���� start
 // var riskCode = fm.riskcode.value;
 // var configRisk = '3101-3107-3108-3114-3122-3126'; 
//  var reSumDutyPaid = fm.prpLcompensateSumDutyPaid.value;
  
 // if(configRisk.indexOf(riskCode)>-1){
//      if(reSumDutyPaid==0){//���Ϊ0
      	
 //     }else{//��Ϊ0
 //     	if(fm.claimRelationNo.value==null || trim(fm.claimRelationNo.value)==""){
	//	  	alert("�����嵥�Ų���Ϊ��");
	//	  	fm.claimRelationNo.focus();
//		  	return false;
	//  	}
//	  	if(null!=fm.claimRelationNo&&null!=fm.claimRelationNo.value&&fm.claimRelationNo.value!=""){
	//  		if(sumSettleCount<0||sumSettleArea<0){
	//  			changeRelateListSum(fm.claimRelationNo,fm.riskcode);//�����嵥�ܻ�������Ķ����ֵ
	//  		}
	//  		if(checkClaimRelationNo()==false){
 // 				return false;
 // 			}
	//  	}
   //   }
 // }
  //���������� ��ֲ�� ���������嵥���� end
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;

  //modify by weishixin add end 20040616
  fm.submit();
  
  return true;   	
}
 

/**
 @author      ����Ⱥ
 @description ����һ���⸶��Ա������Ϣ����
 @param       ��
 @return      ��            
 @see         UIMulLine#insertRow
 @see         UIMulLine#setRowRecordState 
*/ 
function insertRowKind()
{
/*	
  if(fm.PersonName.disabled==true)
  { 
    errorMessage("�������һ����Ա��Ϣ!");
    return;  
  }  

	if(isEmpty(fm.PersonLossKindCodeU))
	{ 
		errorMessage("���������⸶��Ա�ձ�!");			
		fm.PersonLossKindCodeU.focus();
		return;
	} 

  if (!isEmpty(fm.PersonLossOverAmount))
  {
    errorMessage(fm.PersonLossOverAmount.value);
    return;
  }
  */
  	
  insertRow('Kind','Kind_Data')
  /*
  //�����йؼ��֣���ţ�
  setRowRecordState("PersonLoss","Kind");
  
  var findex;
  findex = fm.all("PersonLossClaimRate").length;
  fm.all("PersonLossClaimRate")[findex-1].value = "100.0000";
*/
}
 
 /**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave(){
   
   var policyNo = fm.prpLcompensatePolicyNo.value;
   var riskCode = fm.prpLcompensateRiskCode.value;
   var businessNo = fm.prpLcompensateClaimNo.value;
   var claimNo = fm.prpLcompensateClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=compe&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLcompensateClaimNo.value;

win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
 
//Modify By sunhao add begin 2004-09-06
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){

		var policyNo = fm.prpLcompensatePolicyNo.value;
		var claimNo = fm.prpLcompensateClaimNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&claimNo=" +claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}
//Modify By sunhao add end 2004-09-06


//Modify By liubvo add end 2004-09-07
/**
 *@description ʵ�����񸴺�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function approveSubmit()
{
  if(checkForm()==false)
  {
    return false;
  }

  fm.buttonApprove.disabled = true;
  fm.submit();
  return true;
}

//Modify By liubvo add end 2004-09-07

/**
 @author      liubvo
 @description �������㱨��
 @param       ��
 @return      ��
 */
function generateCtext()
{

 	if(checkForm()==false)
 	{
 		return false;
 	}

  //�������,�����޷�������һҳ
  //fm.Sex.disabled = false;
  
  //��������
  //saveRecord("Loss");
  //saveRowRecordToSingleTable("PersonLoss","Kind");

  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.action="/claim/compensateGenerate.do";
  fm.target="fraCalculate";  
  //fm.target="_blank";  
  
  fm.submit();
  
  fm.action=oldAction;
  fm.target=oldTarget;   

  //�������
  //clearRecord("Loss");
  //clearRecord("PersonLoss");  
  //clearRowRecord("Kind");  
  
  //load data
  //loadRowRecord("PersonLoss","Kind","Kind_Data");  
  return true;
}   	


//��ť�����¼��������������ʾ
function buttonOnClick(fieldObject)
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

/*
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




//��ť�����¼���������ͬ��������౨������ʾ
function buttonOnClick2(strSubPageCode)
{
   var sameCount = parseInt(fm.PerilCount.value);
  
  if (sameCount <1) 
  {
  	fm.button_Peril_Open_Context.disabled = true;
  	return;
  }
  showSubPage2(strSubPageCode);
 
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

//����ǰ����⸶������ʾ�᰸���档
/*function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}*/



/**
 @author      liuyang
 @description �����⸶����е��⳥���ı�ʵ�ʼ�ֵ���˶���ʧ����ֵ�����α���ʱ������
              ���������
              �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
              # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay(field)
{
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⳥���
  var lossRate        //��ʧ��
  var currency2;      //��ʧ�ұ�
  var currency3;      //�⳥�ұ�
  var exchRate;       //�һ���
  var riskType        //
  var temp;
  var riskCode = fm.prpLcompensateRiskCode.value;//����
  var prpLlossDtoItemValue; //��������3221��prpLlossDtoItemValue����ʬ��
  //ȡ�õ�ǰ������
  //����ҵ���⸶�����ж�
  if(checkCoinsPaidLossType() == false ){
	  return false ; 
  }
  //ȡ�õ�ǰ������
  var fieldname=field.name;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
  riskType      = trim(fm.prpLcompensateRiskType.value);
  if(riskCode == "3221"){
  	prpLlossDtoItemValue = parseFloat(fm.all("prpLlossDtoItemValue")[findex].value);
  }
  //ȡ��ʧ��
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //��ȡ��ʧ�ұ���⳥�ұ�
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3��currency4��� ��UIPrpLLoss.4gl After Field Currency3.
  
  if(currency2!=currency3)
  {
      for (var j=1;j<fm.baseCurrency.length;j++)
      {
          if(fm.baseCurrency[j].value==currency2 && fm.exchCurrency[j].value==currency3)
          {
             exchRate = fm.exchRate[j].value;
             
          }
      }
  }
  else
  {
      exchRate = 1;
  }
  
  //��ȡ��ʧ�ұ���⳥�ұ�
   
  
  if(isNaN(Amount))
    Amount = 0;
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;
  if(riskCode == "3221"){
	  if(isNaN(prpLlossDtoItemValue))
	  prpLlossDtoItemValue = 0;
  }
  
  var deductibleFlag=0;
  var deductibleRateFlag=0;
    
   //�����������������ֻ����������һ��
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //��ֲ���߲�ͬ�ļ��㹫ʽ
  if(riskType == "H"){
      //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
      //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      if(calaType == '1' && type == '2'){
        alert("ȫ���⸶ֻ�ܰ��ձ��ս������⸶���");
        return false;
      }
      
      //���ȫ��
      if(calaType == '1'){
            //ȫ��    
            if(  fm.riskcode.value == "3137"){
            	//�����=��λ����*�⸶����*��ʧ��� 
            	var unitAmount = parseFloat(fm.all("prpCItemKindUnitAmount")[findex].value);
            	var settleArea = parseFloat(fm.all("prpLlossDtoSettleArea")[findex].value);
                Realpay = unitAmount * ClaimRate * settleArea;   
            }
            else  if(fm.riskcode.value == "3173" ){
            //�����=������-��ֵ��*�⸶����*��ʧ�̶�*��1-���������ʣ�-���������
	           	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;
	        //yx
	        }else  if(fm.riskcode.value == "3132"||fm.riskcode.value == "3105" ){
            //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�
	           	Realpay = Amount * ClaimRate * lossRate; 
	           	//alert(SumRest+'~~~~~'+Amount+'cac'+ClaimRate+'gg'+lossRate);   
            }else
              Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible;       
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      }else{
       //���ձ��ս�����
      if(type=='1'){
        //if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       // else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
       // }
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������       
           if(fm.riskcode.value == "3137"){
           //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�*��1-���������ʣ�
           	var unitAmount = parseFloat(fm.all("prpCItemKindUnitAmount")[findex].value);
           	var settleArea = parseFloat(fm.all("prpLlossDtoSettleArea")[findex].value);
            Realpay = unitAmount * ClaimRate * settleArea * lossRate * (1 - DeductibleRate); 
           }else if( fm.prpLcompensateRiskCode.value == "3127")
    	    Realpay = (Amount) * ClaimRate * lossRate * (1 - DeductibleRate);          
    	  	else if(fm.riskcode.value == "3173" ){
            //����� = ���ս��*�⸶����*��ʧ�̶�*��1-���������ʣ�- ���������
	           	Realpay = (Amount) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;     
            }else  if(fm.riskcode.value == "3159"||fm.riskcode.value == "3139"||fm.riskcode.value == "3167"){
            //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�
	           	Realpay = Amount * ClaimRate * lossRate; 
            //yx
	        }else  if(fm.riskcode.value == "3132"||fm.riskcode.value == "3105"  ){
            //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�*��1-���������ʣ�
	           	Realpay = Amount * ClaimRate * lossRate * (1 - DeductibleRate); 
	           	//alert(DeductibleRate+'~~~~~'+Amount+'cac'+ClaimRate+'gg'+lossRate); 
            }else
          	Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        //���պ˶���ʧ����
        }else{
          //  if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
        //else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
        //    Realpay = SumLoss * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������         
        	if(fm.riskcode.value == "3137"){
            //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�*��1-���������ʣ�
	           	var unitAmount = fm.all("prpCItemKindUnitAmount")[findex].value;
	           	var settleArea = fm.all("prpLlossDtoSettleArea")[findex].value;
            	if(null == unitAmount || "" == unitAmount || null == settleArea || "" == settleArea){
            		alert("�����ֲ����ú˶���ʧ���㷽ʽ����¼���⸶���");
            		return;
            	}
            	alert("�����ֲ����ú˶���ʧ���㷽ʽ����ʹ�õ�λ������⸶������м��㣡");
                Realpay = parseFloat(unitAmount) * ClaimRate * parseFloat(settleArea) * lossRate * (1 - DeductibleRate);    
            }else if( fm.prpLcompensateRiskCode.value == "3127") 
        	    Realpay = (SumLoss) * ClaimRate * lossRate * (1 - DeductibleRate);
        	else if( fm.prpLcompensateRiskCode.value == "3173") {
        	    Realpay = (SumLoss-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;
        	 //yx
	        }else  if(fm.riskcode.value == "3132" ){
            //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�*��1-���������ʣ�
	           	Realpay = SumLoss; 
	           	//alert(DeductibleRate+'~~~~~'+Amount+'cac'+ClaimRate+'gg'+lossRate+'sss'+SumLoss);   
        	}else  if(fm.riskcode.value == "3105" ){
            //�����=��λ����*�⸶����*��ʧ���*��ʧ�̶�*��1-���������ʣ�
            		alert("�����ֲ����ú˶���ʧ���㷽ʽ�����ձ��ս�����");
            		fm.all("cala")[findex].options[0].selected= true;
            		//fm.cala[findex].options[0].selected= true;
            		return;
        	}
        	else
            	Realpay = (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        }
        }
        
  }//����ɣ����ֳ���գ�3219������ʱ����ʧ�ʣ���������ֳ�չ�������
  else if(fm.prpLcompensateRiskCode.value=="3219"){
  		 if(fm.calaType[findex].value == "2" && lossRate >= 0.8){
  		 	fm.indemnityDutyRate[findex].value = 0.0;
  		 	lossRate = 0.0;
  		 }
  		 if(fm.calaType[findex].value == "1" && lossRate < 0.8){
  		 	fm.indemnityDutyRate[findex].value = 80;
  		 }
         if(lossRate >= 0){
         	  if(lossRate >= 0.8 || fm.calaType[findex].value == "1"){
         	  	lossRate = 1;
         	  }
         	  Realpay = (Amount - SumRest) * exchRate * ClaimRate * lossRate  - Deductible;
         }
  }else if(riskCode == "3221"){
  	if(prpLlossDtoItemValue > 500){
  		prpLlossDtoItemValue = 500;
  	}
  	Realpay = Amount * prpLlossDtoItemValue/500 - SumRest;
  }
  //else if(riskCode == "3228" ){
            //�����=������-��ֵ��*�⸶����*��ʧ�̶�*��1-���������ʣ�
	           	//Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate); 
	           	//alert(lossRate);  
  //}
  else{
         if(deductibleRateFlag==0 && deductibleFlag == 0)
        {
           //��û����
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //���������ʺ���㹫ʽΪ (���-��ֵ)*�⳥����*(1-������)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //������������㹫ʽΪ (���-��ֵ)*�⳥����*-�����
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         
         }
  }
  
  //�������������ǻ��������,��������ϵ  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:ֻ�����ղŽ��п���
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
  if(isMain==1&&Realpay>Amount)
  {  
  	//modify by kangzhen  reason ����������ֵı��Ѿ��Ǳ��ʵ���⸶���ܳ�������
  	var RiskCode  =fm.prpLcompensateRiskCode.value;
  	if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
  	{
       alert("�⳥���ܴ��ڱ��ս��");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
		var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
		var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
		if(coinsPaidLossType == "2" ){ //¼�롰�˶���ʧ��ʱ�����㹲���������Ϣ
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay,2),2);
		}
		if(coinsPaidLossType == "1" ){ //¼�롰�˶���ʧ��ʱ�����㹲���������Ϣ
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay/coinsSelfRate*100,2),2);
		}
	}


  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

}
/**
 *�����⳥�����Ƴ� �⸶��������ֲ�գ�
 *
*/
 function calClaimRate(field){
  var riskType        //�ձ�
  riskType      = trim(fm.prpLcompensateRiskType.value);
  if(riskType != "H"){
       calRealpay(field);
       return false;
  }
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⳥���
  var lossRate        //��ʧ��
  var currency2;      //��ʧ�ұ�
  var currency3;      //�⳥�ұ�
  var exchRate;       //�һ���
  var SumRealPay      //�⳥���
  var temp;
 
  //ȡ�õ�ǰ������
  var fieldname=field.name;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
  SumRealPay    = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value);
  
  //ȡ��ʧ��
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //��ȡ��ʧ�ұ���⳥�ұ�
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3��currency4��� ��UIPrpLLoss.4gl After Field Currency3.
  
  if(currency2!=currency3)
  {
      for (var j=1;j<fm.baseCurrency.length;j++)
      {
          if(fm.baseCurrency[j].value==currency2 && fm.exchCurrency[j].value==currency3)
          {
             exchRate = fm.exchRate[j].value;
             
          }
      }
  }
  else
  {
      exchRate = 1;
  }
  
  //��ȡ��ʧ�ұ���⳥�ұ�
   
  if(isNaN(SumRealPay))
    SumRealPay = 0;
  if(isNaN(Amount))
    Amount = 0;
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;
  
  var deductibleFlag=0;
  var deductibleRateFlag=0;
    
   //�����������������ֻ����������һ��
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //��ֲ�����⳥�����⸶����
  if(riskType == "H"){
      //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
       //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      
      if(calaType == '1'){
       //yx
	  if(fm.riskcode.value == "3132"||fm.riskcode.value == "3105" ){
	     Realpay = Amount * ClaimRate * lossRate;
	      ClaimRate = Realpay/(Amount * lossRate);  
	  }else{
          //ȫ��
         ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (1 - DeductibleRate));    
         }        
         //ClaimRate = SumRealPay/Amount ;    
         //fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
      }else{
      //���ս�����
      if(type=='1'){
        //if(lossRate < 0.3){        
            //�������Ϊ30%   
         //   if(lossRate != 0){
         //       ClaimRate = SumRealPay/Amount ; 
        //        fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //    }
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       /// else if(lossRate >= 0.8 ){
            //��ʧ�ʴ���80%ʱ��ȫ��           
        //    ClaimRate = SumRealPay/Amount ;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
        //    fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������    
            if(((Amount-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              alert("��ʧ�ʲ��ܵ��������ʻ��߱��ս��ܵ��ڲ�ֵ");
              return false;
            }                   
            if( fm.prpLcompensateRiskCode.value != "3127")
            	ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (lossRate - DeductibleRate));
            //yx
            if( fm.prpLcompensateRiskCode.value == "3132"||fm.prpLcompensateRiskCode.value == "3105")
            	ClaimRate = SumRealPay/(Amount * lossRate*(1- DeductibleRate));	
            else
            	ClaimRate = SumRealPay/Amount/lossRate/(1 - DeductibleRate);
            //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
            fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
         //}
          //�˶���ʧ����
        }else{
           //  if(lossRate < 0.3){        
            //�������Ϊ30%   
           // if(lossRate != 0){
           //     ClaimRate = SumRealPay/SumLoss; 
           //     fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
           // }
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8 ){
            //��ʧ�ʴ���80%ʱ��ȫ��           
         //   ClaimRate = SumRealPay/SumLoss;    
         //   fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         //   fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ��������� 
            if(((SumLoss-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              return false;
              alert("��ʧ�ʲ��ܵ��������ʻ��ߺ˶����ܵ��ڲ�ֵ");
            }
            if( fm.prpLcompensateRiskCode.value != "3127")
            	ClaimRate = (SumRealPay+Deductible)/((SumLoss-SumRest) * (lossRate - DeductibleRate));
            else
            	ClaimRate = SumRealPay/SumLoss/lossRate/(1 - DeductibleRate);
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
            fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
         //}
        }
        }
  }
  
  //�������������ǻ��������,��������ϵ  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  
  //add by qinyongli 2005-9-15
  //reason:ֻ�����ղŽ��п���
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
  if(isMain==1&&Realpay>Amount)
  {  
    //modify by kangzhen  reason ����������ֵı��Ѿ��Ǳ��ʵ���⸶���ܳ�������
    var RiskCode  =fm.prpLcompensateRiskCode.value;
    if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
    {
       alert("�⳥���ܴ��ڱ��ս��");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
  
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);
  calCoinsSumPaid(fm.all("prpLlossDtoSumRealPay")[findex]);
 }
/**
 @author      ����Ⱥ
 @description �����⸶��ĺ���Ա������֮��
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calLoss()
{
  //�������
  var dblSumLoss = 0;
  var LossSumLoss    = 0;
  var PersonLossSumLoss = 0;
  var i = 0;

  //�⸶��ĵĺ�����
  //��������
  //setCurrentRecord("Loss");

  //var lossData= getPageData("Loss");

  for( i = 1; i < fm.all("prpLlossDtoSumLoss").length; i++ )
  {
    LossSumLoss = parseFloat(fm.all("prpLlossDtoSumLoss")[i].value);

    if(isNaN(LossSumLoss))
      LossSumLoss = 0;

    dblSumLoss = dblSumLoss + LossSumLoss;
  }



  fm.prpLcompensateSumLoss.value  = point(round(dblSumLoss,2),2);
}


/**
 @author      ����Ⱥ
 @description �����������ϼơ����ϼơ��������á�ʵ����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calFund()
{
  //�������
  var dblSumDutyPaid = 0;  //�������ϼƣ�=�������ø�����Ϣ�У����������+���⸶��ĸ�����Ϣ�У��⳥���+���⸶��Ա������Ϣ�У��⸶�ϼƣ�
  var dblSumPaid     = 0;  //���ϼƣ�=�������ϼ�+�������ã�
  var dblSumPrePaid  = 0;  //Ԥ����
  var dblSumNoDutyFee= 0;  //�������ã��������ø�����Ϣ�У����ý�� - ��������
  var dblSumThisPaid = 0;  //ʵ���=�������ϼƣ���Ԥ����

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossRealPay    = 0;
  var personLossRealPay = 0;
  

  var currency4 ;      //�⳥�ұ�
  var exchRate;        //�һ���
  var chargeCurrency4; //���ñұ�
  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[i].value); //�������
    chargeAmount  = parseFloat(fm.all("prpLchargeChargeAmount")[i].value);  //����

    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay;
    //ȡ�һ��ʣ��������
    chargeCurrency = fm.all("prpLchargeCurrency")[i].value;
    if(chargeCurrency!="CNY")
    {
         for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==chargeCurrency && fm.exchCurrency[j].value=="CNY")
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
    }
    else
    {
        exchRate =1;
    }
    dblSumDutyPaid = dblSumDutyPaid * exchRate;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay);
    dblSumNoDutyFee = dblSumNoDutyFee * exchRate;
  }
  //2.�⸶��ĵ��⳥���
  //��������
  var lossData= getTableElements("lLoss");
  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  var dblSumRest   = 0;
  for( i = 1; i < fm.all("prpLlossDtoSumRealPay").length; i++ )
  {
    lossRealPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);
    //�һ��ұ�
    currency4   = fm.all("prpLlossDtoCurrency3")[i].value;
    if(currency4!="CNY")
    {
         for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==currency4 && fm.exchCurrency[j].value=="CNY")
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
    }
    else
    {
       exchRate = 1;
    }
    lossRealPay = lossRealPay * exchRate;
    if(isNaN(lossRealPay))
      lossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + lossRealPay;
    //�ۼƲ�ֵ
    dblSumRest = dblSumRest + parseFloat(fm.all("prpLlossDtoSumRest")[i].value);
  }

  //�õ�Ԥ����
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //�������ϼ�
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;
  //����ʵ����
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumPaid,2),2);//Σ�յ�λ��ֵ
  fm.prpLcompensateSumRest.value = point(round(dblSumRest,2),2);
  calCoinsFund();
}

function calCoinsFund() {
	var coinsFlag = fm.coinsFlag.value ; 
	
	  // ȡ�õ�ǰ������
	var realPay = parseFloat(fm.prpLcompensateSumPaid.value) ; 
	var SumNoDutyFee = fm.prpLcompensateSumNoDutyFee.value;
	var SumDutyPaid = fm.prpLcompensateSumDutyPaid.value;
	var findex=0;
	if(coinsFlag == "2"||coinsFlag == "1"){
		/*
		for(i=1;i<fm.all("prpLlossDtoCoinsSumRealPay").length;i++){
		    findex=i;
		    realPay = parseFloat(realPay) +  parseFloat(fm.all("prpLlossDtoCoinsSumRealPay")[findex].value ); 
		}
		*/
		var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
		var coinsSelfRate = parseFloat(fm.coinsSelfRate.value) ; 
		if(coinsPaidLossType == "1"){//100%�ݶ��⸶
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = point(round(realPay/coinsSelfRate*100 ,2),2); 
			fm.prpLcompensateCoinsOtherSumPaid.value =point(round(parseFloat(fm.prpLcompensateCoinsSumPaid.value) -  parseFloat(fm.prpLcompensateCoinsSelfSumPaid.value) ,2),2);
		}
		if(coinsPaidLossType == "2"){//�ҷ��ݶ��⸶
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsOtherSumPaid.value = 0 ;
		}
		var dbCoinsSumPaid =  parseFloat(fm.prpLcompensateCoinsSumPaid.value) ;
		var dbSelfSumPaid =  parseFloat(fm.prpLcompensateCoinsSelfSumPaid.value) ;
		var sumCoinsSumPaid=0.0; 
		if(coinsPaidLossType == "1"){//100%�ݶ��⸶
			for(i=1;i<fm.all("CoinsSerialNo").length;i++){
				//alert(fm.all("CoinsRate")[i].value);
				fm.all("CoinsSumpaid")[i].value = point(round((dbCoinsSumPaid-SumNoDutyFee/coinsSelfRate*100) * parseFloat(fm.all("CoinsRate")[i].value) / 100  ,2),2);
				//fm.all("CoinsSumpaid")[i].value = point(round((SumDutyPaid /(1-(parseFloat(fm.all("CoinsRate")[i].value) / 100))) * parseFloat(fm.all("CoinsRate")[i].value) / 100,2),2);
			}
		}
		if(coinsPaidLossType == "2"){//�ҷ��ݶ��⸶
			for(i=1;i<fm.all("CoinsSerialNo").length;i++){
				//alert(fm.all("CoinsRate")[i].value);
				fm.all("CoinsSumpaid")[i].value = 0.00 ; 
			}
		}
		
	}
 }
function calCoinsSumPaid(field) {
	var coinsFlag = fm.coinsFlag.value ; 
	
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	  // ȡ�õ�ǰ������
	var fieldname=field.name;
	var findex=0;
	for(i=1;i<fm.all(fieldname).length;i++){
	  if( fm.all(fieldname)[i] == field ){
	    findex=i;
	    break;
	  }
	}
	  //����ҵ���⸶�����ж�
	var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
	var thisCoinsRealPay = parseFloat(fm.all("prpLlossDtoCoinsSumRealPay")[findex].value) ; 
	var amount = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
	var coinsSumAmount = point(round(amount/coinsSelfRate*100,2),2); 
	if(checkCoinsPaidLossType() == false ){
		fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		return false ; 
	}
	//alert("thisCoinsRealPay==="+thisCoinsRealPay+"===coinsSumAmount==="+coinsSumAmount);
	
		if(coinsPaidLossType == "2"){ // ���ҷ������ݶ��⸶
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		}
		//alert(coinsPaidLossType == "1");alert(coinsPaidLossType == 1);
		if(coinsPaidLossType == "1"){// ���ⰸ100%�⸶
			thisCoinsRealPay = realPay/coinsSelfRate*100 ; 
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(thisCoinsRealPay,2),2);
			if(thisCoinsRealPay > coinsSumAmount){
				 alert("����ҵ���⳥�ܽ��ܴ����ձ𹲱��ܱ��ս��");
			     return false;
			}
		}
		
	}
	calCoinsFund();
	
}
function changeCoinsSumPaid() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	  // ȡ�õ�ǰ������
	var findex=0;
	for(i=1;i<fm.all("prpLlossDtoSumRealPay").length;i++){
	    findex=i;
	    var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
		
			if(coinsPaidLossType == "2"){ // ���ҷ������ݶ��⸶
				if(fm.prpLlossDtoCoinsSumRealPay != null){
					fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
				}
			}
			if(coinsPaidLossType == "1"){
				if(fm.prpLlossDtoCoinsSumRealPay != null){
					fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay/coinsSelfRate*100,2),2);
				}
			}
		}
	
	calCoinsFund();
	if(coinsPaidLossType == "1"){
		document.getElementById("CommonCoinsChargeFee").style.display="";
		fm.CommonCoinsChargeFeeFlag.value = '1';
	}else{
		document.getElementById("CommonCoinsChargeFee").style.display="none";
		fm.CommonCoinsChargeFeeFlag.value = '0';
	}
	}
}
function checkCoinsPaidLossType() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	//var coinsSelfRate = fm.coinsSelfRate.value ; 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	
		if(coinsPaidLossType == null || coinsPaidLossType == ""){
			alert("����ҵ����ѡ���ⰸ�⸶���ͣ�");
			return false ; 
		}
	}
	return true ; 
	
}
function checkRepeatItemCode(field)
{
     //ȡ�õ�ǰ������
     var fieldname=field.name;
     var findex=0;
     for(i=1;i<fm.all(fieldname).length;i++)
     {
        if( fm.all(fieldname)[i] == field )
        {
           findex=i;
           break;
        }
     }
     var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
     var itemCode = fm.all("prpLlossDtoItemCode")[findex].value;
     //add by kangzhen
     var intValueitemNo = fm.all("prpLlossItemKindNo")[findex].value;
     //�õ��Ѿ�¼����ձ�ͱ��
     for( i = 1; i < fm.all("prpLlossDtoKindCode").length - 1; i++ )
     {//modify by kangzhen
         if(fm.all("prpLlossDtoKindCode")[i].value==kindCode && fm.all("prpLlossDtoItemCode")[i].value==itemCode
           && fm.all("prpLlossItemKindNo")[i].value==intValueitemNo
           && fm.all("prpLlossDtoSerialNo")[i].value!=fm.all("prpLlossDtoSerialNo")[findex].value)
         {
             alert("��¼����ձ�ͱ���Ѿ�����");
             fm.all("prpLlossDtoItemCode")[findex].value="";
             fm.all("prpLlossDtoLossName")[findex].value="";
             fm.all("prpLlossDtoAmount")[findex].value="";
             fm.all("prpLlossDtoAmountDisplay")[findex].value="";

             fm.all("prpLlossDtoItemCode")[findex].focus();
         }
     }
     
}
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcompensatePolicyNo.value;
     var RiskCode  =fm.prpLcompensateRiskCode.value;
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

// added by zhangli ��֤�������˵�֧���ʻ����������Ƿ�һ��
function validateAcc(){
     var pwd1=fm.prpLcompensateAccount.value;      
     var pwd2=fm.prpLcompensateAccountOK.value;    
     if(pwd2!=pwd1){
              alert("���������֧���ʺŲ�һ�£�����������!");
			  fm.prpLcompensateAccount.value="";
			  fm.prpLcompensateAccountOK.value="";
			  fm.prpLcompensateAccount.focus();
     }
}


// added by fenglei ��Ԫ��Ŀ������,������ҵ������¼�������Ϣ
function checkBusinessType1(){
    var prpLcompensateBusinessType1 = fm.prpLcompensateBusinessType1.value;  //������ҵ����ҵ��ҵ���־
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;  //������Ϣ���
    var riskType = fm.riskType.value;    
    if (prpLcompensateBusinessType1=="01"||prpLcompensateBusinessType1=="02"){       
        if(prpLchargeSerialNo>1 && riskType != "I"){
           //alert("������ҵ������¼�������Ϣ!");
           //return false;
        }

        if(prpLchargeSerialNo>1 && riskType == "I"){
           var count = getElementCount("prpLchargeChargeCode");
           for(var i = 1;i < count;i++){
                if(fm.all("prpLchargeChargeCode")[i] != null 
                && fm.all("prpLchargeChargeCode")[i].value != "07"
                && fm.all("prpLchargeChargeName")[i] != null
                && fm.all("prpLchargeChargeName")[i].value != "���������"){
                        //alert("��������ֳ��ֻ��¼�롰��������ѡ����ķ���!");
                        //return false;
                }
           }
           
        }
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
	var riskType= trim(fm.prpLcompensateRiskType.value);
	//if(riskType=="H" || fm.prpLcompensateRiskCode.value == "3219" || fm.prpLcompensateRiskCode.value == "3221"|| fm.prpLcompensateRiskCode.value == "3228"|| fm.prpLcompensateRiskCode.value == "3224"){
	if(riskType=="H" || fm.prpLcompensateRiskCode.value == "3219" || fm.prpLcompensateRiskCode.value == "3221"|| fm.prpLcompensateRiskCode.value == "3224"){
	  var length = fm.prpLlossDtoClaimRate.length;
	  if(length > 1){
	  for(var findex=1; findex<length; findex++){
	  var      SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
      var      SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
      var      ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
      var      DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
      var      Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
      var prpLlossDtoItemValue = 0.0;
      if(fm.prpLcompensateRiskCode.value == "3221"){
     	 prpLlossDtoItemValue = parseFloat(fm.all("prpLlossDtoItemValue")[findex].value);
      }
      var test = fm.all("prpLlossDtoAmountDisplay")[findex].value;
      var n = test.split("-");
      var Amount        = parseFloat(n[0]*field.value);
      fm.all("prpLlossDtoAmount")[findex].value  =  Amount;
      var      riskType      = trim(fm.prpLcompensateRiskType.value);
      var       DutyRate ="";
  //ȡ��ʧ��
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //��ȡ��ʧ�ұ���⳥�ұ�
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3��currency4��� ��UIPrpLLoss.4gl After Field Currency3.
  
  if(currency2!=currency3)
  {
      for (var j=1;j<fm.baseCurrency.length;j++)
      {
          if(fm.baseCurrency[j].value==currency2 && fm.exchCurrency[j].value==currency3)
          {
             exchRate = fm.exchRate[j].value;
             
          }
      }
  }
  else
  {
      exchRate = 1;
  }
  
  //��ȡ��ʧ�ұ���⳥�ұ�
   
  
  if(isNaN(Amount))
    Amount = 0;
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;
  if(isNaN(prpLlossDtoItemValue))
    prpLlossDtoItemValue = 0;
  
  var deductibleFlag=0;
  var deductibleRateFlag=0;
    
   //�����������������ֻ����������һ��
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //��ֲ���߲�ͬ�ļ��㹫ʽ
  if(riskType == "H"){
     // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      
       //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
      //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      
      if(calaType == '1'){
                Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible;       

           // Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)- Deductible;
           // Realpay = Amount * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
      }
      else{
      
       //���ձ��ս�����
              //���ձ��ս�����
      if(type=='1'){
        //if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       // else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
       // }
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������         
            Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        //���պ˶���ʧ����
        }else{
          //  if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
        //else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
        //    Realpay = SumLoss * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������         
            Realpay = (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        }
        }
       
        
  }else if(fm.prpLcompensateRiskCode.value=="3219"){
         if(lossRate >= 0 ){
         	  if(lossRate >= 0.8 ||  fm.calaType[findex].value == "1"){
         	  	lossRate = 1;
         	  }
         	  Realpay = (Amount - SumRest) * exchRate * ClaimRate * lossRate  - Deductible;
         }
  }//��ţ�⳥�����㹫ʽ��ͬ�ڹ�������������
  else if(fm.prpLcompensateRiskCode.value=="3221"){
  		if(prpLlossDtoItemValue > 500){
  			prpLlossDtoItemValue = 500;
  		}
  		Realpay = Amount * prpLlossDtoItemValue/500 - SumRest;
  }
  //else if(riskCode == "3228" ){
            //�����=������-��ֵ��*�⸶����*��ʧ�̶�*��1-���������ʣ�
	           //	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate);   
	           	//alert(lossRate);
  //}
  else if(riskCode == "3224" ){
            //�����=������-��ֵ��*�⸶����*��ʧ�̶�*��1-���������ʣ�
	           	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate);   
	           	//alert(lossRate);
  }
  else{
         if(deductibleRateFlag==0 && deductibleFlag == 0)
        {
           //��û����
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //���������ʺ���㹫ʽΪ (���-��ֵ)*�⳥����*(1-������)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //������������㹫ʽΪ (���-��ֵ)*�⳥����*-�����
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         
         }
  }
  
  //�������������ǻ��������,��������ϵ  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:ֻ�����ղŽ��п���
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
  if(isMain==1&&Realpay>Amount)
  {  
  	//modify by kangzhen  reason ����������ֵı��Ѿ��Ǳ��ʵ���⸶���ܳ�������
  	var RiskCode  =fm.prpLcompensateRiskCode.value;
  	if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
  	{
       alert("�⳥���ܴ��ڱ��ս��");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
  calFund();
	   }
	  }
	}
	return;
}

//���������嵥������
function relateListNo(strRelationListNo,strRiskCode)
{
  if(strRelationListNo == null)
  {
    alert("û���ṩ��Ч�������嵥�ţ�");
    return;
  }
  var strURL = "/claim/commonAgri/compensate/AgriCompensateRelateList.jsp?RelationListNo="+strRelationListNo+"&vStrRiskCode="+strRiskCode;
  var newWindow = window.open(strURL,"Relate",'width=960,height=450,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
}

//�����嵥��Ϣ���������嵥�ܻ�������Ķ����ֵ
var xmlHttp;
function changeRelateListSum(field,strCode){
	  var vStrRelationListNo=field.value;
	  var vStrCode = strCode.value;
	  if(vStrRelationListNo == "")
	  {
	  	return false;
	  }
	  createXMLHttpRequest();
	  xmlHttp.onreadystatechange = changeRelateListSum1;//���ûص�����
	  xmlHttp.open("get","/claim/claimRelateListNo.do?RelationListNo="+vStrRelationListNo+"&vStrRiskCode="+vStrCode,true);
	  xmlHttp.send(null);
}

	//�ص�����
function changeRelateListSum1()
{
  if(xmlHttp.readyState == 4){
    if(xmlHttp.status == 200){
      var responseText = xmlHttp.responseText;
      if(trim(responseText)=="||"){   //û�в�ѯ������
        errorMessage("������������嵥�Ų����ڣ�");
	    sumSettleCount    = "";
	    sumSettleArea     = "";
      	return false;
      }
      var arrDate = responseText.split("|");
	  sumSettleCount     = arrDate[0];
	  sumSettleArea      = parseFloat(arrDate[1]);	 
	}
  }
}
function createXMLHttpRequest(){
  xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
}
//�����嵥��Ϣ�������嵥�ܻ�������Ķ����ҳ���⸶���������滧�αȽ�
//function checkClaimRelationNo(){
	
	//���������� ��ֲ�� ���������嵥���� start
 // var reRiskCode = fm.riskcode.value;
 // var configRisk = '3101-3107-3108-3114-3122-3126'; 
  //var recaseFlag = fm.recaseFlag.value;

 // if(configRisk.indexOf(reRiskCode)>-1){
  //	if(fm.claimRelationNo!=""){
  	//	if((sumSettleCount==null || sumSettleCount=="")||(sumSettleArea==null || sumSettleArea=="")){
		//  	alert("��˶������嵥�Ƿ�Ϊ�����ֵ���Ч�嵥");
		//  	fm.claimRelationNo.focus();
	//	  	return false;
	//  	}
	//	if(recaseFlag == "1"){
		//	//�ǵ�һ�ż�����ʱ��������
	//	}else{
		//	if(sumSettleCount!=Math.abs(fm.prpLcompensateDamageInsured.value)){
	//		  	alert("���滧���������嵥���ܻ��������!");
	//			fm.prpLcompensateDamageInsured.focus();
	//			return false;
	//		}
//		}

//		var reStatQuantity = Math.abs(parseFloat(fm.prpLcompensateLossesNumber.value));
	//	if(Math.abs(reStatQuantity-Math.abs(sumSettleArea))>1){
		//  		alert("�⸶�����������嵥����Ķ�����ܳ���1!");
	//		  	fm.prpLcompensateLossesNumber.focus();
	//		  	return false;
	//	}else if(Math.abs(reStatQuantity-Math.abs(sumSettleArea))<=1){
	//	  	if(confirm("�⸶�����������嵥��Ķ�����,ȷ���ύ?"))
	//		{
	//			return true;
	//		}
	//		else{
	//			return false;
	//		}
	//	  }
  	//}else{
   //		errorMessage("��ȷ�������嵥���Ƿ�Ϊ��");
	  //	fm.claimRelationNo.focus();
	 // 	return false;
 //  	}
  // }else{
  //    return true;
  // }
//}
  //���������� ��ֲ�� ���������嵥���� end
  function generateCtext(PolicyNo)
{
   fm.buttonGenerateCtextFlag.value="1";
   if(fm.calBackMainAgriFlag.value=="0"){
       alert("���Ȼ��ܱ����Ϣ��");
       fm.buttonGenerateCtextFlag.value="0";
       return false;
   }
   var policyNo=PolicyNo.value;
    if(checkForm()==false)
    {
        return false;
    }

  var oldAction = fm.action;
  var oldTarget = fm.target;
  
  var itemCode = fm.prpLlossDtoItemCode[1].value;
  fm.action="/claim/compensateAgriGenerate.do?PolicyNo="+policyNo + "&ItemCode=" + itemCode;
  fm.target="fraCalculate";

  fm.submit();

  fm.action=oldAction;
  fm.target=oldTarget;
  return true;
}
  function generateAgriPlanting31Ctext(PolicyNo)
{
   fm.buttonGenerateCtextFlag.value="1";
   if(fm.calBackMainAgriFlag.value=="0"){
       alert("���Ȼ��ܱ����Ϣ��");
       fm.buttonGenerateCtextFlag.value="0";
       return false;
   }
   var policyNo=PolicyNo.value;
   var damageDate = fm.DamageStartDate.value;
    if(checkForm()==false)
    {
        return false;
    }
  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.action="/claim/compensateAgriPlanting31Generate.do?PolicyNo="+policyNo+"&damageDate="+damageDate;
  fm.target="fraCalculate";

  fm.submit();

  fm.action=oldAction;
  fm.target=oldTarget;
  return true;
}
    //ũ��ѡ���ձ�ʱ����Ҫ���ձ�ĵ�λ�����Զ�������
    //Ŀǰֻ��3137ʹ��
    function updateUnitAmount(field){
    	var riskCode = fm.riskcode.value;
    	if( riskCode == "3137" ){
    		var fieldname=field.name;
		    var i = 0;
		    var findex=0;
		    for(i=1;i<fm.all(fieldname).length;i++)
		    {
		       if( fm.all(fieldname)[i] == field )
		       {
		          findex=i;
		          break;
		       }
		    }
	      	var kindCode = fm.prpLlossDtoKindCode[findex].value;
	      	if(null!=kindCode && ""!=kindCode){
	      		var policyNo = fm.policyno.value;
	      		var strPage = "/claim/commonAgri/compensate/GetUnitAmount.jsp?policyNo="
					+ policyNo + "&kindCode=" + kindCode ;
	  			var xmlDoc = getResponseXmlText(strPage).split("/");
	  			//var eleRoot = xmlDoc.getElementsByTagName("prpCitemKind");
	  			//if(null != eleRoot && eleRoot.length > 0){
		  		//	var eleAmount = eleRoot[0].getElementsByTagName("Amount");
		  		//	var eleUnitAmount = eleRoot[0].getElementsByTagName("UnitAmount");
		  		//	if(null != eleAmount && null != eleUnitAmount){
		  		fm.prpCItemKindUnitAmount[findex].value = xmlDoc[0].trim();
		  		fm.prpLlossDtoAmount[findex].value = xmlDoc[1].trim();
		  		//	}
	  			//}
	      	}
    	}
    }

  	function getResponseXmlText(strURL){
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
	function LoadUnitAmount(){
	   	var riskCode = fm.riskcode.value;
	   	if( riskCode == "3137" ){
	   		var count = fm.all("prpLlossDtoKindCode").length;
	   		for(var i = 1;i< count;i++){
	   			updateUnitAmount(fm.all("prpLlossDtoKindCode")[i]);
	   		}
	   	}
    }
function relateCoinsTreatyNo(){

	var coinsTreatyNo = fm.CoinsTreatyNo.value;
    var reinsWebUrl= fm.reinsWebUrl.value;
    var newWindow = window.open(reinsWebUrl+"/fhcoinstreatyFacade.do?actionType=view&treatyNo="+coinsTreatyNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}