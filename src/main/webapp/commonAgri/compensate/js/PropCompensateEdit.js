/*****************************************************************************
 * DESC       ：实赔的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-05-19
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 检查报案登记
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{
//检查政策性险种不允许录入费用信息
 	if(checkBusinessType1()==false)
 	{
 	   return false;
 	}
 	
   return true;    
}

 var sumSettleCount = -1;//理赔清单总户数
 var sumSettleArea  = -1;//理赔清单总亩数
/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{
	//if(null!=fm.editTypeAgri&&null!=fm.editTypeAgri.value&&fm.editTypeAgri.value=="EDIT"){
  //  	  var riskCode = fm.riskcode.value;
  //		  var configRisk = '3101-3107-3108-3114-3122-3126'; 
	//    	if(configRisk.indexOf(riskCode)>-1){
	//		  	if(null!=fm.claimRelationNo&&null!=fm.claimRelationNo.value&&fm.claimRelationNo.value!=""){
	//				changeRelateListSum(fm.claimRelationNo,fm.riskcode);//理赔清单总户数、总亩数赋值
	//		  	}
	//     	 }
 //   }
   //判断是否是共保单
    var coinsFlag = fm.coinsFlag.value;	
    var shareHolderFlag = fm.shareHolderFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var message = "";
  //add by hanliang end  2005-12-22
  var payFee = parseInt(fm.payFee.value);
  var delinquentfeeCase = fm.delinquentfeeCase.value;  
  if(payFee==-1){
    alert("此保单保费未缴！\n");
  } 
  else if(payFee==0){
    alert("此保单保费未缴全！\n");
  }else if(payFee==-2){
     message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
     message = message + delinquentfeeCase + "\n";
  }
    if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
    	message = message + "本保单为联/共保单！\n";
    }
    if(shareHolderFlag!=0){
  	message = message + "此保单为股东业务！";
    }
    if(tempReinsFlag!=0){
  	message = message + "此保单有临分业务！";
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
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
 */
function submitForm()
{
  fm.buttonApprove.disabled = true;
  fm.submit();
  return true;
}

/**
 *@description 重置
 *@param       无
 *@return      通过返回true,否则返回false
 */
function resetForm()
{
  if(window.confirm("确定要重置吗？"))
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
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveForm(field,saveType)
{
  var ChargeAmount=document.getElementsByName('prpLchargeChargeAmount');
  var ChargeCode=document.getElementsByName('prpLchargeChargeCode');
  var CheckDeptCode=document.getElementsByName('prpLchargeCheckDeptCode');
  for(var i=1;i<ChargeCode.length;i++){
     if(ChargeCode[i]!=null&&ChargeCode[i].value=='14'&&ChargeAmount[i]!=null&&ChargeAmount[i].value!=0){
         if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value==''){
            alert("当录入系统内代查勘费时,必须录入代查勘机构！！");
            return false;
         }else{
            if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value.length>=10){
              var CheckCode= CheckDeptCode[i].value.substring(6,10);
              if(CheckCode=='0000'){
                 alert("代查勘机构需要录入到部门！！");
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
  //增加专门的保存校验的方法
  if(checkForm()==false)
  {
    return false;
  }
  var riskType = fm.riskType.value;    //险种
  if(riskType == "I" && fm.prpLcompensateLossesNumber != null && fm.prpLcompensateLossesNumber.value >=0){
  		
	    if(fm.prpLcompensateLossesNumber != null && fm.prpLcompensateLossesNumber.value <= 0){
	        alert("赔付数量不能小于或等于0");
	        fm.prpLcompensateLossesNumber.focus();
	        fm.prpLcompensateLossesNumber.select();
	        return false;
	    }
	    if(fm.prpLcompensateDamageInsured != null && fm.prpLcompensateDamageInsured.value <= 0){
	        alert("受益户次不能小于或等于0");
	        fm.prpLcompensateDamageInsured.focus();
	        fm.prpLcompensateDamageInsured.select();
	        return false;
	    }
	    // 生猪价格保险不需要此项校验
        if(  (fm.prpLcompensateKillQuantity != null && fm.prpLcompensateKillQuantity.value == 0)
          && (fm.prpLcompensateDeathQuantity != null && fm.prpLcompensateDeathQuantity.value == 0)
          && fm.riskcode.value != "3229"){
            alert("扑杀数量和死亡数量不能同时为0");
            fm.prpLcompensateKillQuantity.focus();
            fm.prpLcompensateKillQuantity.select();
            return false;
        }
        if(fm.prpLcompensateKillQuantity != null && fm.prpLcompensateKillQuantity.value < 0){
            alert("扑杀数量不能小于0");
            fm.prpLcompensateKillQuantity.focus();
            fm.prpLcompensateKillQuantity.select();
            return false;
        }
        if(fm.prpLcompensateDeathQuantity != null && fm.prpLcompensateDeathQuantity.value < 0){
            alert("死亡数量不能小于0");
            fm.prpLcompensateDeathQuantity.focus();
            fm.prpLcompensateDeathQuantity.select();
            return false;
        }
        
  }else if(riskType == "H"){
        var SumDutyPaid         = parseFloat(fm.prpLcompensateSumDutyPaid.value);       //赔款金额
        var LossesNumber        = parseFloat(fm.prpLcompensateLossesNumber.value);      //赔付面积
        var DamageInsured       = parseFloat(fm.prpLcompensateDamageInsured.value);     //受益户次
        var DisasterArea        = parseFloat(fm.prpLcompensateDisasterArea.value);      //受灾面积
        var AffectedArea        = parseFloat(fm.prpLcompensateAffectedArea.value);      //成灾面积
        var NoProductionArea    = parseFloat(fm.prpLcompensateNoProductionArea.value);  //绝产面积
        var SumInsured          = parseFloat(fm.prpLcompensateSumInsured.value);        //承保户次
        var recaseFlag          = fm.recaseFlag.value;                                   //重开赔案标志
        var sumDamageInsured    = parseFloat(fm.sumDamageInsured.value)	;				//总收益户次
        var dbSumPaid           = parseFloat(fm.dbSumPaid.value);							//总赔付金额
        var dbLossNumber        = parseFloat(fm.dbLossNumber.value);					//总赔付面积
        var prpLcompensateSumPaid = parseFloat(fm.prpLcompensateSumPaid.value);			//赔付金额
        var dbSumDutyPaid 		= parseFloat(fm.dbSumDutyPaid.value);					//总赔款金额
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
        //非第一张理算时，总收益户次，总赔付金额，承保户次之间的控制
        if(recaseFlag == "1"){
        	dbSumDutyPaid += SumDutyPaid;
        	sumDamageInsured += DamageInsured;
        	dbLossNumber += LossesNumber;
        	if(sumDamageInsured > SumInsured || sumDamageInsured < 0){
        		alert("总受益户次不能小于0且不能大于承保户次！");
        		return false;
        	}
        	if(dbSumDutyPaid < 0 ){
	        	alert("总赔款金额不能小于零！");
	        	return false;
	        }else if(dbSumDutyPaid > 0){
	        	if(sumDamageInsured == 0){
	        		alert("总赔款金额大于零时，总的收益户次不能等于零");
	        		return false;
	        	}
	        	if(dbLossNumber == 0){
	        		alert("总赔款金额大于零时，总“赔付数量/面积”不能等于零！");
	        		return false;
	        	}
	        }else{
	        	if(sumDamageInsured != 0){
	        		alert("总赔款金额等于零时，总受益户次必须等于零！");
	        		return false;
	        	}
	        	if(dbLossNumber != 0){
	        		alert("总赔款金额等于零时，总赔付数量/面积必须等于零！");
	        		return false;
	        	}
	        }
	       
	   }else{//第一张理算时，总收益户次，总赔付金额，承保户次之间的控制
	        if(DamageInsured < 0 || DamageInsured > SumInsured){
	            alert("受益户次必须大于等于0且小于等于承保户次");
	            fm.prpLcompensateDamageInsured.focus();
	            fm.prpLcompensateDamageInsured.select();
	            return false;
	        }
	        if(prpLcompensateSumPaid < 0 ){
	        	alert("总赔款金额不能小于零！");
	        	return false;
	        }
	        //零赔案的情况
	        if(SumDutyPaid == 0){
	            if(LossesNumber > 0){
	                alert("零赔案时赔付数量不能大于0");
	                fm.prpLcompensateLossesNumber.focus();
	                fm.prpLcompensateLossesNumber.select();
	                return false;
	            }
	            if(DamageInsured > 0){
	                alert("零赔案时受益户次不能大于0");
	                fm.prpLcompensateDamageInsured.focus();
	                fm.prpLcompensateDamageInsured.select();
	                return false;
	            }  
	        //非零赔案的情况          
	        }else if(SumDutyPaid > 0){
	            if(LossesNumber <= 0 ){
	                alert("赔付面积不能小于等于0");
	                fm.prpLcompensateLossesNumber.focus();
	                fm.prpLcompensateLossesNumber.select();
	                return false;
	
	            }
	            if(DamageInsured <= 0){
	                alert("受益户次不能小于等于0");
	                fm.prpLcompensateDamageInsured.focus();
	                fm.prpLcompensateDamageInsured.select();
	                return false;
	            
	            }
	            if(AffectedArea <= 0){
	                alert("成灾面积不能小于等于0");
	                fm.prpLcompensateAffectedArea.focus();
	                fm.prpLcompensateAffectedArea.select();
	                return false;
	
	            }
	            
	        }
			        
	   }
        if(LossesNumber >=0){
	        /*if(LossesNumber < 0){
	            alert("赔付面积不能小于0");
	            fm.prpLcompensateLossesNumber.focus();
	            fm.prpLcompensateLossesNumber.select();
	            return false;
	        }
	        if(DamageInsured < 0){
	            alert("受益户次不能小于0");
	            fm.prpLcompensateDamageInsured.focus();
	            fm.prpLcompensateDamageInsured.select();
	            return false;
	        }
	        if(AffectedArea < 0){
	            alert("成灾面积不能小于0");
	            fm.prpLcompensateAffectedArea.focus();
	            fm.prpLcompensateAffectedArea.select();
	            return false;
	        }
	        if(NoProductionArea < 0){
	            alert("绝产面积不能小于0");
	            fm.prpLcompensateNoProductionArea.focus();
	            fm.prpLcompensateNoProductionArea.select();
	            return false;
	        }
	        if(DisasterArea <= 0){
	            alert("受灾面积不能小于或等于0");
	            fm.prpLcompensateDisasterArea.focus();
	            fm.prpLcompensateDisasterArea.select();
	            return false;
	        }*/
	        if(AffectedArea < LossesNumber){
	            alert("成灾面积不能小于赔付面积");
	            fm.prpLcompensateAffectedArea.focus();
	            fm.prpLcompensateAffectedArea.select();
	            return false;
	        }
	        if(NoProductionArea > AffectedArea){
	            alert("绝产面积不能大于成灾面积");
	            fm.prpLcompensateNoProductionArea.focus();
	            fm.prpLcompensateNoProductionArea.select();
	            return false;
	        }
	        if(AffectedArea > DisasterArea){
	            alert("成灾面积不能大于受灾面积");
	            fm.prpLcompensateAffectedArea.focus();
	            fm.prpLcompensateAffectedArea.select();
	            return false;
	            
	        }
	              
        }
          //种植险特殊需求：核定损失和损失率不能为零
   var count = getElementCount("prpLlossDtoSumLoss");
   for(var  i =1; i < count; i++){
     var prpLlossDtoSumLoss = fm.prpLlossDtoSumLoss[i].value;
     var indemnityDutyRate = fm.indemnityDutyRate[i].value;
     if(prpLlossDtoSumLoss==null || prpLlossDtoSumLoss=='' || prpLlossDtoSumLoss==0){
      alert("核定损失不能为空或为零");
      return false;
     }
     if(indemnityDutyRate==null || indemnityDutyRate=='' || indemnityDutyRate==0){
      alert("损失率不能为空或为零");
      return false;
     }
    }
  }
  fm.buttonSaveType.value = saveType; 
  //对定损登记页面中的相关字段进行大于0的控制

  
//赔付标的信息序号
  if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else if(null != fm.planting31FarmerListFlag.value && fm.planting31FarmerListFlag.value.indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else{
  if(fm.prpLlossDtoKindCode.length!=undefined){
    for(i=1;i<fm.prpLlossDtoKindCode.length;i++){
      if(fm.prpLlossDtoKindCode[i].value=="" || fm.prpLlossDtoKindName[i].value == ""){
		  errorMessage = errorMessage + "请填写第"+i+"条赔付标的险别信息\n";
	  }
	  if(fm.prpLlossDtoItemCode[i].value=="" || fm.prpLlossDtoLossName[i].value == ""){
		  errorMessage = errorMessage + "请填写第"+i+"条赔付标的的标的信息\n";
	  }
	}
  }
  }
  //textarea文本框设置值
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "赔款计算过程不允许为空\n";
  }  
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)>round(parseFloat(fm.prpLcompensateSumAmount.value),2)){
    errorMessage = errorMessage + "总赔偿金额不能大于总保险金额\n";
  }
  if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else if(null != fm.planting31FarmerListFlag.value && fm.planting31FarmerListFlag.value.indexOf(fm.prpLcompensateRiskCode.value) > -1){
  }else{
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    errorMessage = errorMessage + "赔款合计不等于危险单位信息里的实赔金额";
  }
  }
  //增加实赔同预赔关系判断 begin
  if(fm.times.value == 1){//首次理算走实赔同预赔的校验，重开不走校验
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("赔款金额不能小于已预付赔款金额！");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("其它费用不能小于已预付费用金额！");
    return false;
  }
  }
  //增加实赔同预赔关系判断 end
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){  
  //add by lixiang start at 2006-8-1	
  //判断理算报告是不能为空的。	
  var 	context2=fm.prpLltextContextInnerHTML.value;
  var   lltext2title=fm.tdLltextTitle.value;
  
  if(context2.length<1){
    errorMessage = errorMessage +lltext2title+ "不允许为空\n";
     alert(errorMessage)
     return false;
  }
  //add by lixiang end at 2006-8-1	
  
    //赔付标的信息或赔付人员信息二者其一必须填写，否则不能提交实赔
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;
    if("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3158,3179,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(fm.prpLcompensateRiskCode.value) > -1){
    }else if(null != fm.planting31FarmerListFlag.value && fm.planting31FarmerListFlag.value.indexOf(fm.prpLcompensateRiskCode.value) > -1){
  	}else if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    { 
      alert("赔款计算书中的赔付标的，赔款费用至少有一条记录!"); 
      return false; 
    }
	//共保理赔费用分摊
    var coinsFlag = fm.coinsFlag.value;	
	if(coinsFlag == "2"||coinsFlag == "1"){
	    var ChargeFeeFlag = fm.CommonCoinsChargeFeeFlag.value;	
	    if(ChargeFeeFlag == 1){
        	var prpLchargeChargeName = document.getElementsByName('prpLchargeChargeName');
        	var ChargeCoinsName = document.getElementsByName('ChargeCoinsName');
        	var size = document.getElementsByName('CoinsCode').length-1;
        	if(prpLchargeChargeName.length-1 != ChargeCoinsName.length/size){
        		alert("请点击共保信息页面下的共保费用分摊按钮！");
        		return false;
        	}
    	}
    }
  }
  //中央政策性 种植险 关联理赔清单控制 start
 // var riskCode = fm.riskcode.value;
 // var configRisk = '3101-3107-3108-3114-3122-3126'; 
//  var reSumDutyPaid = fm.prpLcompensateSumDutyPaid.value;
  
 // if(configRisk.indexOf(riskCode)>-1){
//      if(reSumDutyPaid==0){//赔款为0
      	
 //     }else{//赔款不为0
 //     	if(fm.claimRelationNo.value==null || trim(fm.claimRelationNo.value)==""){
	//	  	alert("理赔清单号不能为空");
	//	  	fm.claimRelationNo.focus();
//		  	return false;
	//  	}
//	  	if(null!=fm.claimRelationNo&&null!=fm.claimRelationNo.value&&fm.claimRelationNo.value!=""){
	//  		if(sumSettleCount<0||sumSettleArea<0){
	//  			changeRelateListSum(fm.claimRelationNo,fm.riskcode);//理赔清单总户数、总亩数赋值
	//  		}
	//  		if(checkClaimRelationNo()==false){
 // 				return false;
 // 			}
	//  	}
   //   }
 // }
  //中央政策性 种植险 关联理赔清单控制 end
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;

  //modify by weishixin add end 20040616
  fm.submit();
  
  return true;   	
}
 

/**
 @author      任轶群
 @description 增加一条赔付人员费用信息方法
 @param       无
 @return      无            
 @see         UIMulLine#insertRow
 @see         UIMulLine#setRowRecordState 
*/ 
function insertRowKind()
{
/*	
  if(fm.PersonName.disabled==true)
  { 
    errorMessage("请先添加一条人员信息!");
    return;  
  }  

	if(isEmpty(fm.PersonLossKindCodeU))
	{ 
		errorMessage("请先输入赔付人员险别!");			
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
  //设置行关键字（序号）
  setRowRecordState("PersonLoss","Kind");
  
  var findex;
  findex = fm.all("PersonLossClaimRate").length;
  fm.all("PersonLossClaimRate")[findex-1].value = "100.0000";
*/
}
 
 /**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinSave(){
   
   var policyNo = fm.prpLcompensatePolicyNo.value;
   var riskCode = fm.prpLcompensateRiskCode.value;
   var businessNo = fm.prpLcompensateClaimNo.value;
   var claimNo = fm.prpLcompensateClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=compe&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLcompensateClaimNo.value;

win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
 
//Modify By sunhao add begin 2004-09-06
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relate(){

		var policyNo = fm.prpLcompensatePolicyNo.value;
		var claimNo = fm.prpLcompensateClaimNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&claimNo=" +claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}
//Modify By sunhao add end 2004-09-06


//Modify By liubvo add end 2004-09-07
/**
 *@description 实赔任务复核
 *@param       无
 *@return      通过返回true,否则返回false
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
 @description 生成理算报告
 @param       无
 @return      无
 */
function generateCtext()
{

 	if(checkForm()==false)
 	{
 		return false;
 	}

  //解除锁定,否则无法传入下一页
  //fm.Sex.disabled = false;
  
  //保存数据
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

  //清除数据
  //clearRecord("Loss");
  //clearRecord("PersonLoss");  
  //clearRowRecord("Kind");  
  
  //load data
  //loadRowRecord("PersonLoss","Kind","Kind_Data");  
  return true;
}   	


//按钮单击事件，用于条款的显示
function buttonOnClick(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//多行	
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}

/*
//按钮单击事件，用于条款的显示
function buttonOnClick1(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//多行
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}




//按钮单击事件，用于相同保单号码多报案的显示
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

//显示输入框
//leftMove 默认值0，坐标左移leftMove
function showSubPage2(spanID,leftMove) 
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;
  
  var ex=window.event.clientX+document.body.scrollLeft;  //得到事件的坐标x
  var ey=window.event.clientY+document.body.scrollTop;   //得到事件的坐标y
  
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
//按钮单击事件，用于相同保单号码多报案的显示
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

//显示输入框
//leftMove 默认值0，坐标左移leftMove
function showSubPage1(spanID,leftMove) 
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;
  
  var ex=window.event.clientX+document.body.scrollLeft;  //得到事件的坐标x
  var ey=window.event.clientY+document.body.scrollTop;   //得到事件的坐标y
  
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

//如果是案终赔付，则显示结案报告。
/*function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}*/



/**
 @author      liuyang
 @description 计算赔付标的中的赔偿金额（改变实际价值、核定损失、残值、责任比例时触发）
              计算赔款金额
              如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
              # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay(field)
{
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DeductibleRate; //免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔偿金额
  var lossRate        //损失率
  var currency2;      //损失币别
  var currency3;      //赔偿币别
  var exchRate;       //兑换率
  var riskType        //
  var temp;
  var riskCode = fm.prpLcompensateRiskCode.value;//险种
  var prpLlossDtoItemValue; //对于险种3221，prpLlossDtoItemValue代表尸重
  //取得当前的数据
  //共保业务赔付类型判断
  if(checkCoinsPaidLossType() == false ){
	  return false ; 
  }
  //取得当前的数据
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
  //取损失率
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //获取损失币别和赔偿币别
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3与currency4相等 见UIPrpLLoss.4gl After Field Currency3.
  
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
  
  //获取损失币别和赔偿币别
   
  
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
    
   //免赔额、免赔率如果输入只能输入其中一项
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //种植险走不同的计算公式
  if(riskType == "H"){
      //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
      //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      if(calaType == '1' && type == '2'){
        alert("全损赔付只能按照保险金额计算赔付金额");
        return false;
      }
      
      //如果全损
      if(calaType == '1'){
            //全赔    
            if(  fm.riskcode.value == "3137"){
            	//赔款金额=单位保额*赔付比例*损失面积 
            	var unitAmount = parseFloat(fm.all("prpCItemKindUnitAmount")[findex].value);
            	var settleArea = parseFloat(fm.all("prpLlossDtoSettleArea")[findex].value);
                Realpay = unitAmount * ClaimRate * settleArea;   
            }
            else  if(fm.riskcode.value == "3173" ){
            //赔款金额=（保额-残值）*赔付比例*损失程度*（1-绝对免赔率）-绝对免赔额
	           	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;
	        //yx
	        }else  if(fm.riskcode.value == "3132"||fm.riskcode.value == "3105" ){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度
	           	Realpay = Amount * ClaimRate * lossRate; 
	           	//alert(SumRest+'~~~~~'+Amount+'cac'+ClaimRate+'gg'+lossRate);   
            }else
              Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible;       
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      }else{
       //按照保险金额计算
      if(type=='1'){
        //if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       // else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
       // }
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率       
           if(fm.riskcode.value == "3137"){
           //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
           	var unitAmount = parseFloat(fm.all("prpCItemKindUnitAmount")[findex].value);
           	var settleArea = parseFloat(fm.all("prpLlossDtoSettleArea")[findex].value);
            Realpay = unitAmount * ClaimRate * settleArea * lossRate * (1 - DeductibleRate); 
           }else if( fm.prpLcompensateRiskCode.value == "3127")
    	    Realpay = (Amount) * ClaimRate * lossRate * (1 - DeductibleRate);          
    	  	else if(fm.riskcode.value == "3173" ){
            //赔款金额 = 保险金额*赔付比例*损失程度*（1-绝对免赔率）- 绝对免赔额
	           	Realpay = (Amount) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;     
            }else  if(fm.riskcode.value == "3159"||fm.riskcode.value == "3139"||fm.riskcode.value == "3167"){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度
	           	Realpay = Amount * ClaimRate * lossRate; 
            //yx
	        }else  if(fm.riskcode.value == "3132"||fm.riskcode.value == "3105"  ){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
	           	Realpay = Amount * ClaimRate * lossRate * (1 - DeductibleRate); 
	           	//alert(DeductibleRate+'~~~~~'+Amount+'cac'+ClaimRate+'gg'+lossRate); 
            }else
          	Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        //按照核定损失计算
        }else{
          //  if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
        //else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
        //    Realpay = SumLoss * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率         
        	if(fm.riskcode.value == "3137"){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
	           	var unitAmount = fm.all("prpCItemKindUnitAmount")[findex].value;
	           	var settleArea = fm.all("prpLlossDtoSettleArea")[findex].value;
            	if(null == unitAmount || "" == unitAmount || null == settleArea || "" == settleArea){
            		alert("本险种不适用核定损失计算方式，请录入赔付面积");
            		return;
            	}
            	alert("本险种不适用核定损失计算方式，将使用单位保额和赔付面积进行计算！");
                Realpay = parseFloat(unitAmount) * ClaimRate * parseFloat(settleArea) * lossRate * (1 - DeductibleRate);    
            }else if( fm.prpLcompensateRiskCode.value == "3127") 
        	    Realpay = (SumLoss) * ClaimRate * lossRate * (1 - DeductibleRate);
        	else if( fm.prpLcompensateRiskCode.value == "3173") {
        	    Realpay = (SumLoss-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;
        	 //yx
	        }else  if(fm.riskcode.value == "3132" ){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
	           	Realpay = SumLoss; 
	           	//alert(DeductibleRate+'~~~~~'+Amount+'cac'+ClaimRate+'gg'+lossRate+'sss'+SumLoss);   
        	}else  if(fm.riskcode.value == "3105" ){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
            		alert("本险种不适用核定损失计算方式，按照保险金额计算");
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
        
  }//险种桑蚕养殖保险（3219）理算时有损失率，不能走养殖险公共函数
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
            //赔款金额=（保额-残值）*赔付比例*损失程度*（1-绝对免赔率）
	           	//Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate); 
	           	//alert(lossRate);  
  //}
  else{
         if(deductibleRateFlag==0 && deductibleFlag == 0)
        {
           //都没输入
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //输入免赔率后计算公式为 (标的-残值)*赔偿比例*(1-免赔率)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //输入免赔额后计算公式为 (标的-残值)*赔偿比例*-免赔额
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         
         }
  }
  
  //免赔额和免赔率是互相独立的,不产生联系  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:只有主险才进行控制
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
  	//modify by kangzhen  reason 这个几个险种的保费就是保额，实际赔付可能超过保额
  	var RiskCode  =fm.prpLcompensateRiskCode.value;
  	if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
  	{
       alert("赔偿金额不能大于保险金额");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
		var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
		var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
		if(coinsPaidLossType == "2" ){ //录入“核定损失”时，计算共保总赔款信息
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay,2),2);
		}
		if(coinsPaidLossType == "1" ){ //录入“核定损失”时，计算共保总赔款信息
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay/coinsSelfRate*100,2),2);
		}
	}


  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

}
/**
 *输入赔偿金额，反推出 赔付比例（种植险）
 *
*/
 function calClaimRate(field){
  var riskType        //险别
  riskType      = trim(fm.prpLcompensateRiskType.value);
  if(riskType != "H"){
       calRealpay(field);
       return false;
  }
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DeductibleRate; //免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔偿金额
  var lossRate        //损失率
  var currency2;      //损失币别
  var currency3;      //赔偿币别
  var exchRate;       //兑换率
  var SumRealPay      //赔偿金额
  var temp;
 
  //取得当前的数据
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
  
  //取损失率
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //获取损失币别和赔偿币别
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3与currency4相等 见UIPrpLLoss.4gl After Field Currency3.
  
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
  
  //获取损失币别和赔偿币别
   
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
    
   //免赔额、免赔率如果输入只能输入其中一项
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //种植险由赔偿金额反推赔付比例
  if(riskType == "H"){
      //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
       //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      
      if(calaType == '1'){
       //yx
	  if(fm.riskcode.value == "3132"||fm.riskcode.value == "3105" ){
	     Realpay = Amount * ClaimRate * lossRate;
	      ClaimRate = Realpay/(Amount * lossRate);  
	  }else{
          //全赔
         ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (1 - DeductibleRate));    
         }        
         //ClaimRate = SumRealPay/Amount ;    
         //fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
      }else{
      //保险金额计算
      if(type=='1'){
        //if(lossRate < 0.3){        
            //理赔起点为30%   
         //   if(lossRate != 0){
         //       ClaimRate = SumRealPay/Amount ; 
        //        fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //    }
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       /// else if(lossRate >= 0.8 ){
            //损失率大于80%时，全赔           
        //    ClaimRate = SumRealPay/Amount ;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
        //    fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率    
            if(((Amount-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              alert("损失率不能等于免赔率或者保险金额不能等于残值");
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
          //核定损失计算
        }else{
           //  if(lossRate < 0.3){        
            //理赔起点为30%   
           // if(lossRate != 0){
           //     ClaimRate = SumRealPay/SumLoss; 
           //     fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
           // }
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8 ){
            //损失率大于80%时，全赔           
         //   ClaimRate = SumRealPay/SumLoss;    
         //   fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         //   fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率 
            if(((SumLoss-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              return false;
              alert("损失率不能等于免赔率或者核定金额不能等于残值");
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
  
  //免赔额和免赔率是互相独立的,不产生联系  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  
  //add by qinyongli 2005-9-15
  //reason:只有主险才进行控制
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
    //modify by kangzhen  reason 这个几个险种的保费就是保额，实际赔付可能超过保额
    var RiskCode  =fm.prpLcompensateRiskCode.value;
    if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
    {
       alert("赔偿金额不能大于保险金额");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
  
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);
  calCoinsSumPaid(fm.all("prpLlossDtoSumRealPay")[findex]);
 }
/**
 @author      任轶群
 @description 计算赔付标的和人员核损金额之和
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calLoss()
{
  //定义变量
  var dblSumLoss = 0;
  var LossSumLoss    = 0;
  var PersonLossSumLoss = 0;
  var i = 0;

  //赔付标的的核损金额
  //保存数据
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
 @author      任轶群
 @description 计算责任赔款合计、赔款合计、其它费用、实赔金额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calFund()
{
  //定义变量
  var dblSumDutyPaid = 0;  //责任赔款合计（=（赔款费用附加信息中）计入赔款金额+（赔付标的附加信息中）赔偿金额+（赔付人员附加信息中）赔付合计）
  var dblSumPaid     = 0;  //赔款合计（=责任赔款合计+其它费用）
  var dblSumPrePaid  = 0;  //预赔金额
  var dblSumNoDutyFee= 0;  //其它费用（（赔款费用附加信息中）费用金额 - 计入赔款金额）
  var dblSumThisPaid = 0;  //实赔金额（=责任赔款合计－已预付赔款）

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossRealPay    = 0;
  var personLossRealPay = 0;
  

  var currency4 ;      //赔偿币别
  var exchRate;        //兑换率
  var chargeCurrency4; //费用币别
  //计算责任赔款合计
  var i = 0;

  //1.赔款费用的计入赔款金额，以及其它费用
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[i].value); //记入赔款
    chargeAmount  = parseFloat(fm.all("prpLchargeChargeAmount")[i].value);  //费用

    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay;
    //取兑换率，折人民币
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
  //2.赔付标的的赔偿金额
  //保存数据
  var lossData= getTableElements("lLoss");
  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  var dblSumRest   = 0;
  for( i = 1; i < fm.all("prpLlossDtoSumRealPay").length; i++ )
  {
    lossRealPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);
    //兑换币别
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
    //累计残值
    dblSumRest = dblSumRest + parseFloat(fm.all("prpLlossDtoSumRest")[i].value);
  }

  //得到预赔金额
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //计算赔款合计
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;
  //计算实赔金额
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumPaid,2),2);//危险单位赋值
  fm.prpLcompensateSumRest.value = point(round(dblSumRest,2),2);
  calCoinsFund();
}

function calCoinsFund() {
	var coinsFlag = fm.coinsFlag.value ; 
	
	  // 取得当前的数据
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
		if(coinsPaidLossType == "1"){//100%份额赔付
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = point(round(realPay/coinsSelfRate*100 ,2),2); 
			fm.prpLcompensateCoinsOtherSumPaid.value =point(round(parseFloat(fm.prpLcompensateCoinsSumPaid.value) -  parseFloat(fm.prpLcompensateCoinsSelfSumPaid.value) ,2),2);
		}
		if(coinsPaidLossType == "2"){//我方份额赔付
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsOtherSumPaid.value = 0 ;
		}
		var dbCoinsSumPaid =  parseFloat(fm.prpLcompensateCoinsSumPaid.value) ;
		var dbSelfSumPaid =  parseFloat(fm.prpLcompensateCoinsSelfSumPaid.value) ;
		var sumCoinsSumPaid=0.0; 
		if(coinsPaidLossType == "1"){//100%份额赔付
			for(i=1;i<fm.all("CoinsSerialNo").length;i++){
				//alert(fm.all("CoinsRate")[i].value);
				fm.all("CoinsSumpaid")[i].value = point(round((dbCoinsSumPaid-SumNoDutyFee/coinsSelfRate*100) * parseFloat(fm.all("CoinsRate")[i].value) / 100  ,2),2);
				//fm.all("CoinsSumpaid")[i].value = point(round((SumDutyPaid /(1-(parseFloat(fm.all("CoinsRate")[i].value) / 100))) * parseFloat(fm.all("CoinsRate")[i].value) / 100,2),2);
			}
		}
		if(coinsPaidLossType == "2"){//我方份额赔付
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
	  // 取得当前的数据
	var fieldname=field.name;
	var findex=0;
	for(i=1;i<fm.all(fieldname).length;i++){
	  if( fm.all(fieldname)[i] == field ){
	    findex=i;
	    break;
	  }
	}
	  //共保业务赔付类型判断
	var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
	var thisCoinsRealPay = parseFloat(fm.all("prpLlossDtoCoinsSumRealPay")[findex].value) ; 
	var amount = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
	var coinsSumAmount = point(round(amount/coinsSelfRate*100,2),2); 
	if(checkCoinsPaidLossType() == false ){
		fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		return false ; 
	}
	//alert("thisCoinsRealPay==="+thisCoinsRealPay+"===coinsSumAmount==="+coinsSumAmount);
	
		if(coinsPaidLossType == "2"){ // 按我方共保份额赔付
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		}
		//alert(coinsPaidLossType == "1");alert(coinsPaidLossType == 1);
		if(coinsPaidLossType == "1"){// 按赔案100%赔付
			thisCoinsRealPay = realPay/coinsSelfRate*100 ; 
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(thisCoinsRealPay,2),2);
			if(thisCoinsRealPay > coinsSumAmount){
				 alert("共保业务赔偿总金额不能大于险别共保总保险金额");
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
	  // 取得当前的数据
	var findex=0;
	for(i=1;i<fm.all("prpLlossDtoSumRealPay").length;i++){
	    findex=i;
	    var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
		
			if(coinsPaidLossType == "2"){ // 按我方共保份额赔付
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
			alert("共保业务，请选择赔案赔付类型！");
			return false ; 
		}
	}
	return true ; 
	
}
function checkRepeatItemCode(field)
{
     //取得当前的数据
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
     //得到已经录入的险别和标的
     for( i = 1; i < fm.all("prpLlossDtoKindCode").length - 1; i++ )
     {//modify by kangzhen
         if(fm.all("prpLlossDtoKindCode")[i].value==kindCode && fm.all("prpLlossDtoItemCode")[i].value==itemCode
           && fm.all("prpLlossItemKindNo")[i].value==intValueitemNo
           && fm.all("prpLlossDtoSerialNo")[i].value!=fm.all("prpLlossDtoSerialNo")[findex].value)
         {
             alert("您录入的险别和标的已经存在");
             fm.all("prpLlossDtoItemCode")[findex].value="";
             fm.all("prpLlossDtoLossName")[findex].value="";
             fm.all("prpLlossDtoAmount")[findex].value="";
             fm.all("prpLlossDtoAmountDisplay")[findex].value="";

             fm.all("prpLlossDtoItemCode")[findex].focus();
         }
     }
     
}
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
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
      window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

// added by zhangli 验证被保险人的支付帐户两次输入是否一致
function validateAcc(){
     var pwd1=fm.prpLcompensateAccount.value;      
     var pwd2=fm.prpLcompensateAccountOK.value;    
     if(pwd2!=pwd1){
              alert("两次输入的支付帐号不一致，请重新输入!");
			  fm.prpLcompensateAccount.value="";
			  fm.prpLcompensateAccountOK.value="";
			  fm.prpLcompensateAccount.focus();
     }
}


// added by fenglei 国元项目组需求,政策性业务不允许录入费用信息
function checkBusinessType1(){
    var prpLcompensateBusinessType1 = fm.prpLcompensateBusinessType1.value;  //政策性业务商业性业务标志
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;  //费用信息序号
    var riskType = fm.riskType.value;    
    if (prpLcompensateBusinessType1=="01"||prpLcompensateBusinessType1=="02"){       
        if(prpLchargeSerialNo>1 && riskType != "I"){
           //alert("政策性业务不允许录入费用信息!");
           //return false;
        }

        if(prpLchargeSerialNo>1 && riskType == "I"){
           var count = getElementCount("prpLchargeChargeCode");
           for(var i = 1;i < count;i++){
                if(fm.all("prpLchargeChargeCode")[i] != null 
                && fm.all("prpLchargeChargeCode")[i].value != "07"
                && fm.all("prpLchargeChargeName")[i] != null
                && fm.all("prpLchargeChargeName")[i].value != "检验鉴定费"){
                        //alert("政策性养殖险只能录入“检验鉴定费”类别的费用!");
                        //return false;
                }
           }
           
        }
    }
    return true;
}
/**
	检查赔付数量是否大于承保数量 
*/
function checkStatQuantity(field){
	if(isNaN(field.value)){
		alert("赔付数量为数字!");
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
		alert("赔付数量不能大于承保数量! 承保数: "+statQuantity);
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
  //取损失率
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //获取损失币别和赔偿币别
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3与currency4相等 见UIPrpLLoss.4gl After Field Currency3.
  
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
  
  //获取损失币别和赔偿币别
   
  
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
    
   //免赔额、免赔率如果输入只能输入其中一项
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //种植险走不同的计算公式
  if(riskType == "H"){
     // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      
       //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
      //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      
      if(calaType == '1'){
                Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible;       

           // Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)- Deductible;
           // Realpay = Amount * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
      }
      else{
      
       //按照保险金额计算
              //按照保险金额计算
      if(type=='1'){
        //if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       // else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
       // }
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率         
            Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        //按照核定损失计算
        }else{
          //  if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
        //else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
        //    Realpay = SumLoss * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率         
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
  }//肉牛赔偿金额计算公式不同于公共，单独计算
  else if(fm.prpLcompensateRiskCode.value=="3221"){
  		if(prpLlossDtoItemValue > 500){
  			prpLlossDtoItemValue = 500;
  		}
  		Realpay = Amount * prpLlossDtoItemValue/500 - SumRest;
  }
  //else if(riskCode == "3228" ){
            //赔款金额=（保额-残值）*赔付比例*损失程度*（1-绝对免赔率）
	           //	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate);   
	           	//alert(lossRate);
  //}
  else if(riskCode == "3224" ){
            //赔款金额=（保额-残值）*赔付比例*损失程度*（1-绝对免赔率）
	           	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate);   
	           	//alert(lossRate);
  }
  else{
         if(deductibleRateFlag==0 && deductibleFlag == 0)
        {
           //都没输入
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //输入免赔率后计算公式为 (标的-残值)*赔偿比例*(1-免赔率)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //输入免赔额后计算公式为 (标的-残值)*赔偿比例*-免赔额
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         
         }
  }
  
  //免赔额和免赔率是互相独立的,不产生联系  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:只有主险才进行控制
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
  	//modify by kangzhen  reason 这个几个险种的保费就是保额，实际赔付可能超过保额
  	var RiskCode  =fm.prpLcompensateRiskCode.value;
  	if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
  	{
       alert("赔偿金额不能大于保险金额");
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

//关联理赔清单关联号
function relateListNo(strRelationListNo,strRiskCode)
{
  if(strRelationListNo == null)
  {
    alert("没有提供有效的理赔清单号！");
    return;
  }
  var strURL = "/claim/commonAgri/compensate/AgriCompensateRelateList.jsp?RelationListNo="+strRelationListNo+"&vStrRiskCode="+strRiskCode;
  var newWindow = window.open(strURL,"Relate",'width=960,height=450,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
  newWindow.focus();
}

//理赔清单信息：给理赔清单总户数和总亩数赋值
var xmlHttp;
function changeRelateListSum(field,strCode){
	  var vStrRelationListNo=field.value;
	  var vStrCode = strCode.value;
	  if(vStrRelationListNo == "")
	  {
	  	return false;
	  }
	  createXMLHttpRequest();
	  xmlHttp.onreadystatechange = changeRelateListSum1;//设置回调函数
	  xmlHttp.open("get","/claim/claimRelateListNo.do?RelationListNo="+vStrRelationListNo+"&vStrRiskCode="+vStrCode,true);
	  xmlHttp.send(null);
}

	//回调函数
function changeRelateListSum1()
{
  if(xmlHttp.readyState == 4){
    if(xmlHttp.status == 200){
      var responseText = xmlHttp.responseText;
      if(trim(responseText)=="||"){   //没有查询到数据
        errorMessage("您输入的理赔清单号不存在！");
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
//理赔清单信息：理赔清单总户数和总亩数与页面赔付数量、受益户次比较
//function checkClaimRelationNo(){
	
	//中央政策性 种植险 关联理赔清单控制 start
 // var reRiskCode = fm.riskcode.value;
 // var configRisk = '3101-3107-3108-3114-3122-3126'; 
  //var recaseFlag = fm.recaseFlag.value;

 // if(configRisk.indexOf(reRiskCode)>-1){
  //	if(fm.claimRelationNo!=""){
  	//	if((sumSettleCount==null || sumSettleCount=="")||(sumSettleArea==null || sumSettleArea=="")){
		//  	alert("请核对理赔清单是否为该险种的有效清单");
		//  	fm.claimRelationNo.focus();
	//	  	return false;
	//  	}
	//	if(recaseFlag == "1"){
		//	//非第一张计算书时不做控制
	//	}else{
		//	if(sumSettleCount!=Math.abs(fm.prpLcompensateDamageInsured.value)){
	//		  	alert("受益户次与理赔清单中总户数不相等!");
	//			fm.prpLcompensateDamageInsured.focus();
	//			return false;
	//		}
//		}

//		var reStatQuantity = Math.abs(parseFloat(fm.prpLcompensateLossesNumber.value));
	//	if(Math.abs(reStatQuantity-Math.abs(sumSettleArea))>1){
		//  		alert("赔付数量与理赔清单中总亩数相差不能超过1!");
	//		  	fm.prpLcompensateLossesNumber.focus();
	//		  	return false;
	//	}else if(Math.abs(reStatQuantity-Math.abs(sumSettleArea))<=1){
	//	  	if(confirm("赔付数量与理赔清单总亩数相符,确认提交?"))
	//		{
	//			return true;
	//		}
	//		else{
	//			return false;
	//		}
	//	  }
  	//}else{
   //		errorMessage("请确认理赔清单号是否为空");
	  //	fm.claimRelationNo.focus();
	 // 	return false;
 //  	}
  // }else{
  //    return true;
  // }
//}
  //中央政策性 种植险 关联理赔清单控制 end
  function generateCtext(PolicyNo)
{
   fm.buttonGenerateCtextFlag.value="1";
   if(fm.calBackMainAgriFlag.value=="0"){
       alert("请先汇总标的信息！");
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
       alert("请先汇总标的信息！");
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
    //农险选择险别时，需要将险别的单位保额自动带出。
    //目前只有3137使用
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
	    alert("找不到页面："+ strURL);
	    return "";
	  }
	  else
	  {
	    alert("访问"+ strURL +"出错，错误号："+objXmlHttp.status);
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