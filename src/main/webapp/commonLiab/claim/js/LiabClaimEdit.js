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
{ //判断是否是共保、临分、股东业务信息
    var coinsFlag = fm.coinsFlag.value;	
    var shareHolderFlag = fm.shareHolderFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var message = "";
     //add by qinyongli 增加保单注销,报案时间，倒签单，股东业务，出险次数，临分共保等提示； 2005-7-28
    var coinsFlag = fm.coinsFlag.value;
    var tempReinsFlag = fm.tempReinsFlag.value;
    var shareHolderFlag = fm.shareHolderFlag.value;
    var message = "";
    
    var othFlag = fm.prpLclaimOthFlag.value;
    if(othFlag.substring(3,4)=="1"){
     message = message + "此保单已注销！\n";
    }
    if(shareHolderFlag!=0){
       message = message + "此保单为股东业务！\n";
    }
    var payFee = parseInt(fm.payFee.value);
  if(payFee==-1){
    alert("此保单保费未缴！\n");
  } 
  else if(payFee==0){
    alert("此保单保费未缴全！\n");
  }else if(payFee==-2){
     message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
  }
    if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
    	message = message + "本保单为联/共保单！\n";
    }
    if (message.length>0) {
       alert(message);
       return false;
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

function sumLossAmountInformLiab() {
         var returnString ="";
         var collectTemp = new Array();
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
         }
             if(sumLossAmount>500000) {
                 returnString = "提示：估损金额汇总值大于 "+currencyName+" 五十万元。";
             }
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
 // 校验估损金额
  if(!checkExes()) {
    return false;
  } 
  var errorMessage = "";	
  fm.buttonSaveType.value = saveType;
  //增加追溯期和出案时间判断
  var liabStartDate = fm.liabStartDate.value;
  var startDate = fm.prpLclaimStartDate.value;
  var endDate   = fm.prpLclaimEndDate.value;
  var damageStartDate = fm.prpLclaimDamageEndDate.value;
   if((damageStartDate < liabStartDate)&&liabStartDate!=0&&liabStartDate<startDate|| (damageStartDate > endDate)){
  	errorMessage = errorMessage +"提示：出险时间在保险期间以外，不允许立案!\n";
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
  //add by qingyongli 2005/07/22 
  var claim_days = fm.claim_days.value;
  var standardDays = fm.standardDays.value;
  if(claim_days==0){
  	if(!confirm("立案天数大于系统规定时间"+standardDays+"天，是否提交？")){
  		return false;
  	}
   }
  //modify by weishixin add begin 20040616

  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(!validateForm(fm,"ClaimLoss_Data"))
  {
    return false;
  }
  
  //计算估损金额
  if(!collectClaimLoss())
  {
    return false;
  }
  
  //新危险单位校验
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
  if(fm.prpLclaimRiskCode.value=="1528"){
    var claimLossLen = fm.prpLclaimLossKindCode.length;
     for(var i = 1; i < claimLossLen; i++) {
       if(fm.prpLclaimLossBrandCode[i].value==""||fm.prpLclaimLossCarNumber[i].value==""){
         alert("此险种的事故车辆信息不能为空！");
         return false;
       }
    }
  }
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
      
  // 保存时增加50万提示框,点击确认后方可保存,否则停留在页面
  if(confirm(sumLossAmountInformLiab() + "\n确认继续提交吗？")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }   	
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


/**
 @description 校验索赔金额
 @param       无
 @return      boolean
 */
function checkFee()
{
  if(getRowsCount("LiabClaimFee")==0)
  {
		errorMessage("估损金额金额信息至少要有一条记录!");				
	
		return false;  
  }
	//alert (fm.prpLclaimFeeCurrency.length);
	
  for( var j=1;j<fm.prpLclaimLossCurrency.length;j++)
 	{
		if (isEmptyField(fm.prpLclaimLossCurrency[j]))
		{
			errorMessage("第"+ j+"条估损金额中币别不能为空!");			
			fm.prpLclaimLossCurrency[j].focus();
			return false;
		}

  	for( var n=j+1;n<fm.prpLclaimLossCurrency.length;n++)
 		{
			if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossKindCode[n].value==fm.prpLclaimLossKindCode[j].value)&&(fm.prpLclaimLossLossFeeType[n].value==fm.prpLclaimLossLossFeeType[j].value))
			{
				errorMessage("第"+ n+"条估损金额中币别和第"+ j+"条估损金额中币别一致，请合并这2条记录");			
			
				fm.prpLclaimLossCurrency[n].focus();
				return false;
			}
		}
				
		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		{ 
			errorMessage("第"+j+"条事故估损金额中金额不能为空!");			
			fm.prpLclaimFeeSumClaim[j].focus();
			return false;
		}
 	}	
	return true; 	
}

//得到一页的多行纪录的记录数
//页名称
function getRowsCount(PageCode)
{
  var oTBODY   = document.all(PageCode).tBodies.item(0);
  var intCount = oTBODY.rows.length;
  return intCount;
}

/**
 @description 汇总估损金额
 @param       无
 @return      无
 */
function collectClaimFee()
{
	var compAmout =0;
	var nowAmout =0;
	
	if (!checkFee()) return false ; 
	//循环计算 估金额
	
	for( var n=1;n<fm.prpLclaimFeeSumClaim.length;n++)
 		{
 			nowAmout =parseFloat(fm.prpLclaimFeeSumClaim[n].value)
			compAmout = compAmout + nowAmout;
    }			
	
	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
        fm.prpLdangerRiskSumClaim.value=pointTwo(compAmout);
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
			fm.prpLclaimLossCurrency[j].focus();
			return false;
		}
		
		if(isEmptyField(fm.prpLclaimLossKindCode[j]))
		{ 
			errorMessage("第"+j+"条事故估损金额中险别代码不能为空!");			
			//fm.prpLclaimLossKindCode[j].focus();
			return false;
		}
		
//险别和币别相同的，必须合并
  	for( var n=j+1;n<fm.prpLclaimLossCurrency.length;n++)
 		{
 			if(fm.prpLclaimRiskCode.value!="1537")
 			{
				if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossKindCode[n].value==fm.prpLclaimLossKindCode[j].value)&&(fm.prpLclaimLossLossFeeType[n].value==fm.prpLclaimLossLossFeeType[j].value))
				{
					errorMessage("第"+ n+"条估损金额中项目及币别及费用类别和第"+ j+"条估损金额中项目及币别及费用类别一致，请合并这2条记录");			
					fm.prpLclaimLossKindCode[n].focus();
					return false;
				}
			}
		}
				
		if(isEmptyField(fm.prpLclaimLossSumClaim[j]))
		{ 
			errorMessage("第"+j+"条事故估损金额中金额不能为空!");			
			fm.prpLclaimLossSumClaim[j].focus();
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
             if(sumLossAmount>500000) {
                 alert("提示：估损金额汇总值大于 "+currencyName+" 五十万元。");
             }
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
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
/**
*立案估损增加费用信息必输控制
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
       //strMsg += "请输入立案估损费用信息！";
     }
   if(strMsg != "") {
     alert(strMsg);
     return false;
   }
   return true;
}