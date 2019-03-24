/*****************************************************************************
 * DESC       ：报案登记的脚本函数页面
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-03-10
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
	////检查登记主表输入
 	//if(checkRegistMain()==false)
 	//{
 	//	return false;
 	//}
    ////检查三者车辆输入
 	//if(checkThirdParty()==false)
 	//{
 	//	return false;
 	//}
 	////检查驾驶员输入
 	//if(checkDriver()==false)
 	//{
  	//  return false;
 	//}
    ////检查文本输入
 	//if(checkRegistText()==false)
 	//{
  	//  return false;
 	//}

    return true;
}

/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{

	//必须先验证是不是有第一辆车的情况下，才能进行设置的。
  if (fm.prpLthirdPartySerialNo.length>1){
      fm.buttonThirdPartyDelete[1].disabled = true;
      //modify by zhaozhuo add 20050321 start
      //reason: 涉案车辆信息中本保单车辆号牌底色、车辆种类、厂牌型号不允许修改
      fm.prpLthirdPartyBrandName[1].disabled = true;
      fm.carKindCode[1].disabled = true;
      fm.licenseColorCode[1].disabled = true;
      fm.prpLthirdPartyLicenseNo[1].disabled = true;
      //modify by zhaozhuo add 20050321 end
      fm.prpLthirdPartyLicenseNo[1].readOnly = true;
      //collectClaimLoss();
  }
    
  changeSumClaim(); //初始化估损金额
  table_cars.style.display = "";
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

function sumLossAmountInformDaa() {
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
//reason :itest bug 634 车险责任比例之和为100%
/*
 var lPercent = 0;
        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
          lPercent= lPercent + parseFloat(fm.prpLthirdPartyDutyPercent[i].value);
        }
         if (lPercent!=100)
         {
            strmsg="所有涉案车辆的责任比例之和必须为100!";
            alert(strmsg);
            //field.select();
            //field.focus();
            return false;
         }
*/         
  //modify by liuyanmei add 20051114 end
  /*
   *控制不能录入重复的险别估损信息
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
                alert("您录入了重复的险别估损信息。\n" +
                      "请将这些信息合并后再保存或提交" );
                
                return false;
            }
        }
   }
   
  /*
   *控制立案必须录入至少一条费用，且费用必须大于0
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
            //alert("险别估损金额信息中必须录入至少一条费用信息");
            //return false;
        }else if(allFeeLoss == 0 || allFeeLoss < 0){
            //alert("险别估损金额信息中费用估损金额必须大于0");
            //return false;
        }
        
   }
  //控制互碰自赔的案件必须录入三者车
  var count = getElementCount("prpLthirdPartySerialNo");
  if (count <= 2){
    var claimType = fm.claimType.value;
    if(claimType == "K"){
        alert("互碰自赔的案件必须录入三者车信息!");
        return false;
    }
  }  
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //textarea文本框设置值
  var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "出险摘要不允许为空\n";
  }
  //出险区域
  var prpLclaimDamageAreaCode = fm.prpLclaimDamageAreaCode.value;
  var prpLclaimDamageAreaName = fm.prpLclaimDamageAreaName.value;
  if(prpLclaimDamageAreaName.length < 1 || prpLclaimDamageAreaCode.length < 1){
        errorMessage = errorMessage + "出险区域不允许为空\n";
  }
  //四险别互斥
  var found = false;
  var foundKindCode = "";
  for(var i=1;i<fm.prpLclaimLossKindCode.length;i++){
    var kindCode = fm.prpLclaimLossKindCode[i].value;
    if(kindCode=="A" || kindCode=="G" || kindCode=="F" || kindCode=="Z"){
        if(found==true && foundKindCode!=kindCode){
            errorMessage = errorMessage + "车辆损失险、全车盗抢险、玻璃单独破碎险、自燃损失险不能同时存在\n";
            break;
        }else{
          found = true;
          foundKindCode = kindCode;
        }
    }
  }
  
  //校验驾驶员证件类型、证件号码必须录入
   var prpldriverlength = fm.all("prpLdriverIdentifyNumber").length;
  for(var i = 1; i < prpldriverlength; i++){
        var prpLdriverDriverName = fm.all("prpLdriverDriverName")[i].value;
        var prpLdriverIdentifyNumber = fm.all("prpLdriverIdentifyNumber")[i].value;
        var arrDriverName = prpLdriverDriverName.split(" ");
        var arrIdentfyNumber = prpLdriverIdentifyNumber.split(" ");
        if( arrDriverName.length - 1 == prpLdriverDriverName.length){
            errorMessage =errorMessage + "驾驶员姓名不能为空\n";
        }
        if( arrIdentfyNumber.length - 1 == prpLdriverIdentifyNumber.length){
            errorMessage =errorMessage + "驾驶员证件号码不能为空\n";
        }
  }
  
   //车损险不能录入医疗和死亡伤残
  for(var i=1;i<fm.prpLclaimLossKindCode.length;i++){
    var kindCode = fm.prpLclaimLossKindCode[i].value;
      //范围：M 医疗    D 死亡伤残
    var FeeCategory = fm.prpLclaimLossFeeCategory[i].value;
    if(kindCode=="A" && (FeeCategory=="M" || FeeCategory=="D")){
       errorMessage = errorMessage + "车损险不能录入医疗和死亡伤残，请重新选择\n";
       break;
    }
  }
  
  //控制出险原因不为空 
  var strDamageTypeCode = fm.prpLclaimDamageTypeCode.value;
  var strDamageTypeName = fm.prpLclaimDamageTypeName.value;
  if (strDamageTypeCode=="" || strDamageTypeName==""){
    errorMessage = errorMessage + "事故类型不为空，请重新选择\n";
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
   
  /*
  if (!collectClaimLoss())
  {
    return false;
  }
  */
  //modify by weishixin add begin 20040616

  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  //if(!validateForm(fm,'ClaimLoss_Data,ThirdParty_Data,Driver_Data'))
  //{
  //  return false;
  //}
  
   if ( checkBeyondQuota()==false){
     return false;
  }

  //modify by wangli add start 20050426
  //reason:暂存时也要校验
  /*
  if(saveType=="2"){

  	for(var i=0;i<prpLclaimLossKindCode.length();i++)
  	{
  	var prpLclaimLossKindCode = fm.prpLclaimLossKindCode[i].value;
  	var prpLclaimLossKindName = fm.prpLclaimLossKindName[i].value;
  	alert(prpLclaimLossKindCode);
  	if(prpLclaimLossKindCode=="")
  	{
  	 alert("险别代码不能为空");
         fm.prpLclaimLossKindCode[i].focus();
          return false;
  	}

  	if(prpLclaimLossKindName=="")
  	{
         alert("险别名称不能为空");
  	fm.prpLclaimLossKindName[i].focus();
  	 return false;
        }

  	}
  	 return false;
  	}
 */
 //modify by wangli add end 20050426
 
     //modify by lixiang add start 20060216
     //reason:因为sumclaim值和分项不一致
     collectClaimLoss();
     dutySum();
     //modify by wangli add end 
     
     if(!checkLoss()){
    return false;  
    }
 
      if (saveType=="4"){
    //估损金额为零应该不容许提交
    
   	  var SumClaim = parseFloat(fm.prpLclaimSumClaim.value);
   	  if(SumClaim<=0){
   	    //alert("请输入保险损失金额");
    	  //fm.prpLclaimSumClaim.focus();
    	  //fm.prpLclaimSumClaim.select();
   	    //return false;
   	  }
 	  }
 	  //检验商业险不能选择互碰自赔案件
 	  if(changeClaimType(fm.claimType)==false){
 	  	return false;
 	  }
  
  /*

   if (saveType=="4")
  {
  	if (trim(fm.nextNodeNo.value).length<1)
  	{
  		alert("请选择要提交的下一个节点！")
  		return false;
  	}

  	if (trim(fm.nextHandlerCode.value).length<1)
  	{
  		alert("请选择要提交的下一个人！")
  		return false;
  	}

  }

  */
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
 
  //新危险单位校验
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
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
      
  // 保存时增加50万提示框,点击确认后方可保存,否则停留在页面
  if(confirm(sumLossAmountInformDaa() + "\n确认继续提交吗？")) {
      fm.submit();
      return true;   
  } else {
      field.disabled = false;
      return false;
  }    	
}

//注销函数
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


//装载数据
function loadForm()
{
	//alert("set cadsfsdfl");
	//fm.carKindCode.disabled = true;
	//fm.carKindCode.readOnly = true;
	//alert("set carKindCode");
}


//Modify By wangli remark begin 20050328
//reason: 统一使用ClaimPub.js 里的方法，便于维护

/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
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
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
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
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function relate(){
		var policyNo = fm.prpLclaimPolicyNo.value;
		var registNo = fm.prpLclaimRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
//Modify By sunhao add end 2004-09-06
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
*/

//Modify By wangli remark end 20050328
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
			//if ((fm.prpLclaimLossCurrency[n].value==fm.prpLclaimLossCurrency[j].value)&&(fm.prpLclaimLossKindCode[n].value==fm.prpLclaimLossKindCode[j].value))
			//{
			//	errorMessage("第"+ n+"条估损金额中险别及币别和第"+ j+"条估损金额中险别及币别一致，请合并这2条记录");

			//	fm.prpLclaimLossKindCode[n].focus();
			//	return false;
			//}
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
/**
 @description 汇总估损金额
 @param       无
 @return      无
 */
function collectClaimLoss()
{
	var SumKindLoss =0; //总的kindLoss之和
	var kindLoss =0;
	var SumSumClaim =0; //总的Sumclaim之和
	var sumClaim =0;

	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 		{
 			//kindLoss =parseFloat(fm.prpLclaimLossKindLoss[n].value)
			//SumKindLoss = SumKindLoss + kindLoss;
			sumClaim =parseFloat(fm.prpLclaimLossSumClaim[n].value)
			SumSumClaim = SumSumClaim + sumClaim;
    }
    //保险损失金额=sum(kindLoss)
  	fm.prpLclaimSumClaim.value=pointTwo(SumSumClaim);
  	//危险单位估损=sum(sumClaim)
    fm.prpLdangerRiskSumClaim.value=pointTwo(SumSumClaim);

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
 @description 改变赔偿责任时触发，相应改变责任比例
 @param       无
 @return      无
 */
function changeIndemnityDuty()
{
  var indemnityDuty =""; //设置的值
  var i= 0;              //循环使用


  switch (fm.indemnityDuty.value)
  {
    case "0":   //全责
      indemnityDuty = "100";
      break;
    case "1":   //主责
      indemnityDuty = "70";
      break;
    case "2":   //同责
      indemnityDuty = "50";
      break;
    case "3":   //次责
      indemnityDuty = "30";
      break;
    case "4":   //无责
      indemnityDuty = "0.0";
      break;
    case "9":   //其它
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
  var i= 0;              //循环使用
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
//显示输入框
//leftMove 默认值0，坐标左移leftMove
function showSubPage2(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID);
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
 

//Modify By wangli remark end 20050328


//意键险:生成不予立案文本  2005-08-09
function generateNoClaimText() {
    var prpLlText = "";
    var strSpace = "    ";
    var prpLclaimInsuredName = fm.prpLclaimInsuredName.value;
    var message1 = strSpace + "您的理赔申请本公司已经获悉，根据保险条款及相关法律，并经审慎核定您所提供的有关资料与证明，本公司认为，您的申请事由不能成立，并做如下处理： \n";
    var message2 = strSpace + "不予立案并退件/不予给付保险金/退还解约金CNY0.00元 ,解除本保险合同。\n";
    var message3 = strSpace + "本公司做出上述决定的理由是：\n\n";
    var message4 = strSpace + "若您对本公司的处理有异议，可于接到本通知之日起十日内向本公司理赔部门寻求解释。若您觉得仍无法获得满意的答复，您还享有以下权利：\n";
    var message5 = strSpace + "向仲裁机关申请仲裁/向人民法院提起诉讼 \n";
    var message6 = strSpace + "请申请并审慎运用您的上述权利。\n";
    prpLlText = "尊敬的" + prpLclaimInsuredName + "女士/先生：\n" + message1;
    prpLlText = prpLlText + message2 + message3 + message4 + message5 +message6;
    fm.prpLclaimContext.value = prpLlText;
    return true;
}
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
                     var claimLossSum = parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                     if(isNaN(claimLossSum))claimLossSum = 0;
                     sumLossAmount = sumLossAmount + parseFloat(claimLossSum);
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
     var vURL =  CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

