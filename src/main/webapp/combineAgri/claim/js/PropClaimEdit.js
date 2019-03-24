/*****************************************************************************
 * DESC       ：报案登记的脚本函数页面
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-03-10
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{
	var allRegist = document.getElementsByName("registNo");
	var lengthOfRegist = allRegist.length;
    var message = "";
	if(null!=lengthOfRegist && lengthOfRegist > 0){
	   //判断是否是共保、临分、股东业务信息
	    var coinsFlag = fm.coinsFlag_0.value;
	    var shareHolderFlag = fm.shareHolderFlag_0.value;
	    var tempReinsFlag = fm.tempReinsFlag_0.value;
	     //add by qinyongli 增加保单注销,，股东业务，等提示； 2005-7-28
	    
	    var othFlag = fm.prpLclaimOthFlag_0.value;
	    if(othFlag.substring(3,4)=="1"){
	     message = message + "此保单已注销！\n";
	    }
	    var underWriteEndDate=fm.underWriteEndDate_0.value;
	    var prpLclaimStartDate = fm.prpLclaimStartDate_0.value;
	    if(shareHolderFlag!=0){
	       message = message + "此保单为股东业务！\n";
	    }
	    var payFee = parseInt(fm.payFee_0.value);
	  	var delinquentfeeCase = fm.delinquentfeeCase_0.value;
	    if(payFee==-1){
	         message=message+"此保单保费未缴,请慎重处理！！！ \n";
	     }
	      else if(payFee==-2){
	           message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
	           message = message + delinquentfeeCase + "\n";
	     }
    }
    if (message.length>0) {
    	alert(message);
    } 
    return true;
}

/**
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
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
//	    //循环分币别统计
//	    for(var ii=1;ii<elePrpLclaimLossCurrency.length;ii++){
//	        if(currency==elePrpLclaimLossCurrency[ii].value){
//	             sumLossAmount = sumLossAmount + parseFloat(elePrpLclaimLossSumClaim[ii].value);
//	        }
//	    }
//	    //先判断当前数组中是否已有此币别,如果没有再进行保存
//	    for(var j=0;j<collectTemp.length;j++){             
//	        if(collectTemp[j]==currency){hasElement=true;}
//	    }
//	    //如果当前数组中有此元素，不再进行统计
//	
//	    if(hasElement){continue;}
//	    //存入数组中
//	    collectTemp[i-1]= currency;
//	 }
 //            if(sumLossAmount>500000) {
 //                returnString = "提示：估损金额汇总值大于 "+currencyName+" 五十万元。";
  //           }
             return returnString;
}


/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
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

// 校验估损金额
  if(!checkBeyondSumAmount()) {
  	enableAllButton('buttonArea');
    return false;
  }
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  
  var countRegist = getElementCount("registNoShow");
  if(null!=countRegist && countRegist>0){
  	for(var indexOfRegist=0;indexOfRegist<countRegist;indexOfRegist++){
		//报案时间是否在保险期间
		  var startDate = document.getElementsByName("prpLclaimStartDate_"+indexOfRegist)[0].value;
		  var endDate   = document.getElementsByName("prpLclaimEndDate_"+indexOfRegist)[0].value;
		  var damageStartDate = document.getElementsByName("prpLclaimDamageStartDate_"+indexOfRegist)[0].value;
		
		  if((damageStartDate < startDate) || (damageStartDate > endDate)){
		       errorMessage = errorMessage + "提示：出险时间已经超过保险期间，不能立案!";
		  }
		//textarea文本框设置值
		  var context = document.getElementsByName("prpLltextContextInnerHTML_"+indexOfRegist)[0].value;
		  if(context.length<1){ 
		    errorMessage = errorMessage + "出险摘要不允许为空\n";
		  }     
		  if (errorMessage.length>0) {
		    alert(errorMessage);
		    enableAllButton('buttonArea');
		    return false;
		  }
		  var claim_days = document.getElementsByName("claim_days_"+indexOfRegist)[0].value;
		  var standardDays = document.getElementsByName("standardDays_"+indexOfRegist)[0].value;
		  if(claim_days==0){
		  	if(!confirm("第"+indexOfRegist+"个案件,立案天数大于系统规定时间"+standardDays+"天，是否提交？")){
		  		enableAllButton('buttonArea');
		  		return false;
		  	}
		   }
		
			if(document.getElementsByName("prpLclaimClassCode_"+indexOfRegist)[0].value == "31"){
				if(parseFloat(document.getElementsByName("prpLclaimDamageInsured_"+indexOfRegist)[0].value) < 1 || parseFloat(document.getElementsByName("prpLclaimDamageInsured_"+indexOfRegist)[0].value) > parseFloat(document.getElementsByName("prpLclaimSumInsured_"+indexOfRegist)[0].value)){
					alert("出险户次必须大于0且小于等于承保户次！");
					enableAllButton('buttonArea');
					return false;
				}
			}

		  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
		  initCombineMulLineFields('ClaimLoss_'+indexOfRegist+'_Data')

		  
		  //计算估损金额
		  if(!collectClaimLoss(indexOfRegist)){
			  enableAllButton('buttonArea');
		    return false;
		  }
		  
  	}

  	if(!(validateCombineRequired(fm) && validateCombineType(fm))){
  	  enableAllButton('buttonArea');
  	  return false;
    }
  	//reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
      
  // 保存时增加50万提示框,点击确认后方可保存,否则停留在页面
  if(confirm(sumLossAmountInformComAgri() + "\n确认继续提交吗？")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }
  }
  return true;   	
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

//养殖险立案中进行保单还原
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
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}




//按钮单击事件，用于相同保单号码多报案的显示
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
 * 初始化整个页面的方法
 * 设置域的maxLenght属性.
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
                log("字段" + fieldNameWithoutNumber + "没有在ValidateData.js中定义");
                continue;
            }

            //设置maxLength
            if (element.type == 'text' ||
                element.type == 'textarea' ||
                element.type == 'password') {

                maxLength=getDataTypeMaxLength(schemaColumn.dataType);
                if(maxLength>0){
                    element.maxLength=maxLength;
                }
            }
            //添加onkeypress处理事件
            method = null;
            if(element.onkeypress!=null){
              method = element.onkeypress;
            }
            element.onkeypress=keypressHandler;
            if (method!=null){
                eval("element.onkeypress.prototype." + fieldNameWithoutNumber + "=" + method);
            } 
            //添加onblur处理事件
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
 //按钮单击事件,用于根据事故者带出保益信息
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
  	alert("请选择事故者代码");
  	return;
  }
  var elePolicyNo = document.getElementsByName("policyno_"+indexOfRegist);
  var policyno = elePolicyNo[0].value;
  var messagedo="/claim/beneInfoShow.do?serialNo="+familyNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}
//Modify By dongcl remark end 20050623
//汇总险别估损信息 ,根据币别汇总
//add by qinyongli 2005-8-31 
function collectCurrency(indexOfRegist){
	 var collectCurr ="";
	 var collectTemp = new Array();
	 collectCurr = "分币别汇总结果:\n";
	 var elePrpLclaimLossCurrency = document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist);
	 var elePrpLclaimLossCurrencyName = document.getElementsByName("prpLclaimLossCurrencyName_"+indexOfRegist);
	 var elePrpLclaimLossSumClaim = document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist);
	 for(var i=1;i<elePrpLclaimLossCurrency.length;i++){
	    var hasElement = false;
	    var currency = elePrpLclaimLossCurrency[i].value;
	    var currencyName = elePrpLclaimLossCurrencyName[i].value;
	    var sumLossAmount = 0;
	    //循环分币别统计
	    for(var ii=1;ii<elePrpLclaimLossCurrency.length;ii++){
	        if(currency==elePrpLclaimLossCurrency[ii].value){
	             sumLossAmount = sumLossAmount + parseFloat(elePrpLclaimLossSumClaim[ii].value);
	        }
	    }
	    //先判断当前数组中是否已有此币别,如果没有再进行保存
	    for(var j=0;j<collectTemp.length;j++){             
	        if(collectTemp[j]==currency){hasElement=true;}
	    }
	    //如果当前数组中有此元素，不再进行统计
	
	    if(hasElement){continue;}
	    //存入数组中
	    collectTemp[i-1]= currency;
	    collectCurr =collectCurr +  currency+"  "+ currencyName+"  "+ sumLossAmount+".00元\n";
	 }
	 if(collectCurr.length>0){
	     alert(collectCurr);
	     return false;
	 }
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
/**
*立案未处理任务的放弃函数
*/
function taskClaimGiveup(){
	if(!confirm("确认要放弃任务？")){
     return false;
   	}
  fm.action="/claim/claimBeforeEditCombine.do?editType=GIVUP";
  fm.submit();
     
}

 /**
 *@description 弹出关联页面
 *@param       prpLPolicyNo 保单号码
 *@return      通过返回true,否则返回false
 */

 function relate(prpLPolicyNo,registNo){
    var policyNo = prpLPolicyNo;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo + "&registNo=" + registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return false;
}
/**
*立案估损增加估损不允许大于保额控制
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
	        var itemKindAmount = parseFloat(document.getElementsByName("prpLclaimLossItemAmount_"+indexOfRegist)[i].value); // 险别保额
	     } 
	     var itemClaimLoss = parseFloat(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[i].value);  // 险别估损金额
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
	       strMsg += "险别'" + kindName + "'的估损金额超过该险别的保额！" + "\r\n";
	     }
	     
	   }
	   //校验险别估损赔款与清单定损金额是否相等 add by pao
	    if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	    {
	     var number = getElementCount("prplCompensateEarEstimateLoss_"+indexOfRegist);
	     
	     for(var k=1;k<number;k++){
	        sumLoss = sumLoss + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss_"+indexOfRegist)[k].value);
	     }
	     if(prpLclaimLossSumClaimP!=sumLoss){
	     alert("报案号为"+fm.registNo[indexOfRegist]+"的险别估损金额的赔款总和不等于耳标号清单定损金额总和！！请检查");
	     return false;
	     }
	   }
	   
	   //政策性农险不能录入费用信息
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
	                //strMsg += "政策性农险不能输入立案估损费用信息！";
	            }
	        }else {
		       if(prpLclaimLossSumClaim == 0 && riskType!= "I") {
		           //strMsg += "请输入立案估损费用信息！";
		       }    
	        }
	}
	   var sumAmount = parseFloat(document.getElementsByName("prpLclaimSumAmount_"+indexOfRegist)[0].value);  // 总保额
	   var feeSumClaim = parseFloat(document.getElementsByName("prpLclaimSumClaim_"+indexOfRegist)[0].value); // 总估损金额
	   if( feeSumClaim > sumAmount ){
	     strMsg += "总估损金额不能大于总保额！";
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
 @description 汇总估损金额
 @param       无
 @return      无
 */
function collectClaimLoss(indexOfRegist)
{
	var compAmout =0;
	var nowAmout =0;
	var exchCurrency = document.getElementsByName("prpLclaimCurrency_"+indexOfRegist)[0].value;  //得到当前币别类型
	var exchRate = 1; //兑换率
	
	if (!checkLoss(indexOfRegist)) return false ; 
	//循环计算 估金额
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
 @description 校验索赔金额
 @param       无
 @return      boolean
 */
function checkLoss(indexOfRegist)
{
	//1.检查必须要有一条记录
  if(getRowsCount("ClaimLoss_"+indexOfRegist)==0)
  {
		errorMessage("估损金额金额信息至少要有一条记录!");				
	
		return false;  
  }
	//2币别不能为空的
 
  for( var j=1;j<document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist).length;j++)
 	{
		if (isEmptyField(document.getElementsByName("prpLclaimLossCurrency_"+indexOfRegist)[j]))
		{
			errorMessage("第"+ j+"条估损金额中币别不能为空!");			
			return false;
		}
		
		if(isEmptyField(document.getElementsByName("prpLclaimLossKindCode_"+indexOfRegist)[j]))
		{ 
			errorMessage("第"+j+"条事故估损金额中险别代码不能为空!");			
			return false;
		}
		
		//alert(fm.prpLclaimLossKindCode[j].value)
 
//险别和币别相同的，必须合并
/*
  	for( var n=j+1;n<fm.prpLclaimLossCurrency.length;n++)
 		{
			if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossItemCode[n].value==fm.prpLclaimLossItemCode[j].value)&&(fm.prpLclaimLossLossFeeType[n].value==fm.prpLclaimLossLossFeeType[j].value))
			{
				errorMessage("第"+ n+"条估损金额中项目及币别及费用类别和第"+ j+"条估损金额中项目及币别及费用类别一致，请合并这2条记录");			
			
				fm.prpLclaimLossKindCode[n].focus();
				return false;
			}
		}
*/
 
		if(isEmptyField(document.getElementsByName("prpLclaimLossSumClaim_"+indexOfRegist)[j]))
		{ 
			errorMessage("第"+j+"条事故估损金额中金额不能为空!");			
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