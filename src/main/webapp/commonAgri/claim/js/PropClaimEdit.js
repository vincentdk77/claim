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
   //判断是否是共保、临分、股东业务信息
    var coinsFlag = fm.coinsFlag.value;	
    var shareHolderFlag = fm.shareHolderFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var message = "";
     //add by qinyongli 增加保单注销,，股东业务，等提示； 2005-7-28
    var coinsFlag = fm.coinsFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var shareHolderFlag = fm.shareHolderFlag.value;
    var message = "";
    
    var othFlag = fm.prpLclaimOthFlag.value;
    if(othFlag.substring(3,4)=="1"){
     message = message + "此保单已注销！\n";
    }
    var underWriteEndDate=fm.underWriteEndDate.value;
    var prpLclaimStartDate = fm.prpLclaimStartDate.value;
    if(shareHolderFlag!=0){
       message = message + "此保单为股东业务！\n";
    }
    var payFee = parseInt(fm.payFee.value);
  	var delinquentfeeCase = fm.delinquentfeeCase.value;
    if(payFee==-1){
         message=message+"此保单保费未缴,请慎重处理！！！ \n";
     }
      else if(payFee==-2){
           message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
           message = message + delinquentfeeCase + "\n";
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

function sumLossAmountInformAgri() {
         var returnString ="";
//         var collectTemp = new Array();
//         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
//           var hasElement = false;
//            var currency = fm.prpLclaimLossCurrency[i].value;
//           var currencyName = fm.prpLclaimLossCurrencyName[i].value;
//            var sumLossAmount = 0;
//           //循环分币别统计
//            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
//                if(currency==fm.prpLclaimLossCurrency[ii].value){
//                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
//                }
//            }
//            //先判断当前数组中是否已有此币别,如果没有再进行保存
//            for(var j=0;j<collectTemp.length;j++){             
//                if(collectTemp[j]==currency){hasElement=true;}
//            }
//            //如果当前数组中有此元素，不再进行统计
//
//            if(hasElement){continue;}
//            //存入数组中
//            collectTemp[i-1]= currency;
//         }
//             if(sumLossAmount>500000) {
//                 returnString = "提示：估损金额汇总值大于 "+currencyName+" 五十万元。";
//             }
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
  if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	{
		var bool = checkEarBeforeSave();
		if ( bool != true) return false;
	}
  // 校验估损金额
  if(!checkBeyondSumAmount()) {
    return false;
  }  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //报案时间是否在保险期间
  var startDate = fm.prpLclaimStartDate.value;
  var endDate   = fm.prpLclaimEndDate.value;
  var damageStartDate = fm.prpLclaimDamageStartDate.value;
  
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
       errorMessage = errorMessage + "提示：出险时间已经超过保险期间，不能立案!";
  }
  //textarea文本框设置值
  var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){ 
    errorMessage = errorMessage + "出险摘要不允许为空\n";
  }     
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  var claim_days = fm.claim_days.value;
  var standardDays = fm.standardDays.value;
  if(claim_days==0){
  	if(!confirm("立案天数大于系统规定时间"+standardDays+"天，是否提交？")){
  		return false;
  	}
   }

	if(fm.prpLclaimClassCode.value == "31"){
		if(parseFloat(fm.prpLclaimDamageInsured.value) < 1 || parseFloat(fm.prpLclaimDamageInsured.value) > parseFloat(fm.prpLclaimSumInsured.value) ){
			alert("出险户次必须大于0且小于等于承保户次！");
			return false;
		}
	
	}
	//估损数量的校验
	if(fm.prpLclaimClassCode.value == "31"){
	   if("" == fm.prpLclaimLossQuantity.value || 0>=parseInt(fm.prpLclaimLossQuantity.value)){
	     alert("估损数量不能小于或等于0！");
	     return false;
	   }
	}

  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(!validateForm(fm,"ClaimLoss_Data")){
   return false;
  }
  
  //计算估损金额
  if(!collectClaimLoss()){
    return false;
  }
  
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
      
  // 保存时增加50万提示框,点击确认后方可保存,否则停留在页面
  if(confirm(sumLossAmountInformAgri() + "\n确认继续提交吗？")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }  	
}

//并案处理全部提交
function saveCombine(field){
    var sumLoss = 0.00;
    var sumAmount = parseFloat(fm.prpLclaimSumAmount.value);
    var prpLestimateLoss = fm.all("prpLestimateLoss");
    
    var nodeStatus = fm.all("prpLnodeStatus"); 
    for(var index=0;index<nodeStatus.length;index++){
      if(nodeStatus[index].value=="0"){
        alert("报案号"+fm.prpLregistNo[index].value+"为未处理立案，请处理后再提交！");
        return false;
      }
    }
    for(var i =0;i<prpLestimateLoss.length;i++){
       sumLoss = parseFloat(sumLoss) + parseFloat(prpLestimateLoss[i].value);
    }
    if(sumLoss>sumAmount){
      alert("预计给付金额超过该保单的保险金额!!");
      return false;
    }
    fm.buttonSaveType.value = "4";
    field.disabled = true;
    fm.submit();
  
  return true; 
}

//装载数据
function loadForm()
{
	//alert("set cadsfsdfl");
	//fm.carKindCode.disabled = true;
	//fm.carKindCode.readOnly = true;
	//alert("set carKindCode");
}

/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinSave(){
   
   var businessNo = fm.prpLclaimRegistNo.value;
   var policyNo = fm.prpLclaimPolicyNo.value;
   var riskCode = fm.prpLclaimRiskCode.value;
   var claimNo = fm.prpLclaimClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=claim&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLclaimRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=no,scrollbars=yes,width=600,Height=300");
}

//Modify By sunhao add begin 2004-09-06
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relate(){	
		var policyNo = fm.prpLclaimPolicyNo.value;
		var registNo = fm.prpLclaimRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}


//得到一页的多行纪录的记录数
//页名称
function getRowsCount(PageCode)
{
  var oTBODY   = document.all(PageCode).tBodies.item(0);
  var intCount = oTBODY.rows.length;
  return intCount;
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
  
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 

//Modify By dongcl remark begin 20050623
/**
 @description 汇总估损金额
 @param       无
 @return      无
 */
function collectClaimLoss()
{
	var compAmout =0;
	var nowAmout =0;
	var exchCurrency = fm.prpLclaimCurrency.value;  //得到当前币别类型
	var exchRate = 1; //兑换率
	
	if (!checkLoss()) return false ; 
	//循环计算 估金额
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
 @description 校验索赔金额
 @param       无
 @return      boolean
 */
function checkLoss()
{
	//1.检查必须要有一条记录
  if(getRowsCount("ClaimLoss")==0)
  {
		errorMessage("估损金额金额信息至少要有一条记录!");				
	
		return false;  
  }
	//2币别不能为空的
 
  for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
 	{
		if (isEmptyField(fm.prpLclaimLossCurrency[j]))
		{
			errorMessage("第"+ j+"条估损金额中币别不能为空!");			
			return false;
		}
		
		if(isEmptyField(fm.prpLclaimLossKindCode[j]))
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
 
		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		{ 
			errorMessage("第"+j+"条事故估损金额中金额不能为空!");			
			//fm.prpLclaimLossSumClaim[j].focus();
			return false;
		}
 
 	}	
 
	return true; 	
}
//Modify By dongcl remark end 20050623
//汇总险别估损信息 ,根据币别汇总
//add by qinyongli 2005-8-31 
function collectCurrency(){
         var collectCurr ="";
         var collectTemp = new Array();
         collectCurr = "分币别汇总结果:\n";
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //循环分币别统计
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
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
// add by qinyongli end 2005-8-31
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
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
		window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}



function printFH()
{
    var BizNo     =fm.prpLclaimPolicyNo.value;
    var RiskCode  =fm.prpLclaimRiskCode.value;
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL =  CoreWebUrl +'/' + RiskCode + '/cb/UIPolicy' + RiskCode + 'FHNoneFormatPrint.jsp?EDITTYPE=POLICY&FlagForPrint=46&BizNo='+ BizNo;
    window.open(vURL,'分户清单信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
//yx
function checkclaimNumber(){
var claimNumber = fm.prpLclaimLossclaimNumber.value;
if(!claimNumber==null || claimNumber==""){
     alert("赔付数量不能为空");
     return false;
     }
}

/**
*立案估损增加估损不允许大于保额控制
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
        var itemKindAmount = parseFloat(fm.prpLclaimLossItemAmount[i].value); // 险别保额
     } 
     var itemClaimLoss = parseFloat(fm.prpLclaimLossSumClaim[i].value);  // 险别估损金额
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
       strMsg += "险别'" + kindName + "'的估损金额超过该险别的保额！" + "\r\n";
     }
     
   }
   //校验险别估损赔款与清单定损金额是否相等 add by pao
   if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
   {
     var number = getElementCount("prplCompensateEarEstimateLoss");
     
     for(var k=1;k<number;k++){
        sumLoss = sumLoss + parseFloat(fm.prplCompensateEarEstimateLoss[k].value); 
     }
     sumLoss = sumLoss.toFixed(2);//用于消除计算的精度差，完成立案提交校验
     if(prpLclaimLossSumClaimP!=sumLoss){
     alert("险别估损金额的赔款总和不等于耳标号清单定损金额总和！！请检查");
     return false;
     }
   }
   
   //政策性农险不能录入费用信息
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
                //strMsg += "政策性农险不能输入立案估损费用信息！";
            }
        }else {
	       if(prpLclaimLossSumClaim == 0 && riskType!= "I") {
	          // strMsg += "请输入立案估损费用信息！";
	       }    
        }
}
   var sumAmount = parseFloat(fm.prpLclaimSumAmount.value);  // 总保额
   var feeSumClaim = parseFloat(fm.prpLclaimSumClaim.value); // 总估损金额
   if( feeSumClaim > sumAmount ){
     strMsg += "总估损金额不能大于总保额！";
   }
   if(strMsg != "") {
     alert(strMsg);
     return false;
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
	return;
}

/** 
	检查输入耳标号的正确性及带出相应的信息。
*/
 function earnoCheck(){
 	  var policyNo   = fm.prpLclaimPolicyNo.value;
 	  if(null==policyNo || trim(policyNo).length == 0) {
 	 	  alert("无保单号");
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
	 else alert("耳标号不可为空");

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
		alert("耳标号："+unRealEarNo+" 不存在，请重新填写！");
	else{
		fm.valueofEarCheck.value="true";
		alert("耳标号验证通过，请继续输入！");
	}
}
	

//检查耳标号的输入是否有空值和有无重复。
function checkEarInputFormat(){
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength == 1){
		alert("耳标号信息不能为空");
		return false;
	}
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			if(isEmptyField(fm.prpLearNo[i])){
				alert("第"+i+"行耳标号列表信息的耳标号不能为空！");
	 			return false;
			}
		}
	}
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			for(var j = i + 1;j < vPrpLearNoLength;j++){
	  			if(fm.prpLearNo[i].value == fm.prpLearNo[j].value){
					alert("耳标号信息列表中，第"+i+"行和第"+j+"行重复!");
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

//使用xmlhttp访问页面，并获取数据(财产卢续攀20030407)
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
    alert("找不到页面："+ strURL);
    return "";
  }
  else
  {
    alert("访问"+ strURL +"出错，错误号："+objXmlHttp.status);
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
 * 预缮制清单页面弹出
 */
 function openCompensateSettleListPage(editType,nodeType){
    var policyNo = fm.policyno.value;
	var registNo = fm.registno.value;
 	var newWindow = window.open("/claim/settleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
 }
 
 /**
 * 预缮制清单页面弹出
 */
 function openCompensate31SettleListPage(editType,nodeType){
    var policyNo = fm.policyno.value;
	var registNo = fm.registno.value;
 	var newWindow = window.open("/claim/planting31SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
 }
 
 /**
 * 预缮制清单页面弹出
 */
 function openCompensate3224SettleListPage(editType,nodeType){
    var policyNo = fm.policyno.value;
	var registNo = fm.registno.value;
 	var newWindow = window.open("/claim/planting3224SettleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
 }
 
 //已出险次数页面"..."按钮单击事件，用于相同保单号码多报案的显示 add by xuecheng
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