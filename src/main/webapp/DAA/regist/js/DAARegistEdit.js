/*****************************************************************************
 * DESC       ：报案登记的脚本函数页面(车险类的)
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-03-10
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


//比较两个日期字符串
// date1=date2则返回0 , date1>date2则返回1 , date1<date2则返回-1
function compareFullDate(date1,date2)
{
  var strValue1=date1.split(DATE_DELIMITER);
  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,parseInt(strValue1[2],10));

  var strValue2=date2.split(DATE_DELIMITER);
  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,parseInt(strValue2[2],10));

  if(date1Temp.getTime()==date2Temp.getTime())
    return 0;
  else if(date1Temp.getTime()>date2Temp.getTime())
    return 1;
  else
    return -1;
}


/**
 *@description 检查报案登记
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{
  //录单日期在报案日起之后
  if(fm.prpLregistCurrentDate != null && compareFullDate(fm.prpLregistReportDate.value,fm.prpLregistCurrentDate.value)>0)
  {
  	errorMessage("报案时间不能晚于当前日期");
  	fm.prpLregistReportDate.focus();
    fm.prpLregistReportDate.select();
  	return false;
  }
  //判断报案时间不能早于出险时间
  var i = compareFullDate(fm.prpLregistDamageStartDate.value,fm.prpLregistReportDate.value);
  if (i>0)
  {
    errorMessage("报案时间不能早于出险时间");
    fm.prpLregistReportDate.focus();
    fm.prpLregistReportDate.select();
    return false;
  }else if (i==0 && (parseFloat(fm.prpLregistDamageStartHour.value)>parseFloat(fm.prpLregistReportHour.value)))
  {
    errorMessage("报案时间不能早于出险时间");
    fm.prpLregistReportHour.focus();
    fm.prpLregistReportHour.select();
    return false;
  }else if (i==0 && (parseFloat(fm.prpLregistDamageStartHour.value)==parseFloat(fm.prpLregistReportHour.value)))
  {
  	if(parseFloat(fm.prpLregistDamageStartMinute.value)>parseFloat(fm.prpLregistReportMinute.value))
  	{
	    errorMessage("报案时间不能早于出险时间");
	    fm.prpLregistReportMinute.focus();
	    fm.prpLregistReportMinute.select();
	    return false;
	  }
  }


  ////检查登记主表输入
   //if(checkRegistMain()==false)
   //{
   //  return false;
   //}
    ////检查三者车辆输入
   //if(checkThirdParty()==false)
   //{
   //  return false;
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

/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveForm(field,saveType)
{
  var errorMessage = "";
  var riskCode=fm.prpLregistRiskCode.value;
  //reason:增加输单日期和出险日期的判断，输单日期必须在出险日期之后
  var damageDay    = fm.prpLregistDamageStartDate.value;
  var inputDate    = fm.prpLregistInputDate.value;
  if(inputDate<damageDay){
    errorMessage = errorMessage + "出险日期不能大于输单日期\n";
  }
  var othFlag = fm.prpLregistOthFlag.value;
  if(othFlag.substring(2,3)=="1"){
    alert("保单已退保，不允许报案！");
    return false;
  }
  if(othFlag.substring(3,4)=="1"){
    alert("保单已注销，不允许报案！");
    return false;
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  //即时生效的保单特殊判断（即时生效的单子以在java中的判断为准）
  var immediateValidPeriod = fm.immediateValidPeriod.value;
  if(immediateValidPeriod != ""){
    if(immediateValidPeriod == "N"){
        alert("提示：出险时间在保险期间以外，不给予报案!");
        return false;
    }
  }else{
    if((damageStartDate < startDate) || (damageStartDate > endDate)){    
        alert("提示：出险时间在保险期间以外，不给予报案!");
        return false;
    }
  }
  var message = "";

  //获取报案出险延期天数
  var delayDays=fm.configValue.value;
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var registDay = fm.prpLregistReportDate.value;
  var regist = new Date(registDay.substring(0,4),registDay.substring(5,7)-1,registDay.substring(8,10));
  
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
  	message = message + "报案出险延期天数大于"+delayDays+"天，是否通过？\n";
  }
  if(message != ""){
  	if(window.confirm(message) == false){
  		return false;
    }
  }
  fm.buttonSaveType.value = saveType;
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "出险摘要不允许为空\n";
  }
 
  //modify by liuyanmei 20051024 start 
  var  prpLregistDamageAddress= fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "出险地点不允许为空\n";
  }
  var prpLregistDamageCode = fm.prpLregistDamageCode.value;
  var prpLregistDamageName = fm.prpLregistDamageName.value;
  if(prpLregistDamageCode.length<1 || prpLregistDamageName.length < 1){
    errorMessage = errorMessage + "出险原因不允许为空\n";
  }
  
  var  prpLregistReportorName= fm.prpLregistReportorName.value;
  if(prpLregistReportorName.length<1){
    errorMessage = errorMessage + "报案人不允许为空\n";
  }
	
  var  prpLregistLinkerName= fm.prpLregistLinkerName.value;
  if(prpLregistLinkerName.length<1){
    errorMessage = errorMessage + "联系人不允许为空\n";
  }
   var  prpLregistPhoneNumber= fm.prpLregistPhoneNumber.value;
  if(prpLregistPhoneNumber.length<1){
    errorMessage = errorMessage + "联系电话不允许为空\n";
  }
  if(fm.prpLregistSS[0].checked==false&&fm.prpLregistSS[1].checked==false
           &&fm.prpLregistSS[2].checked==false&&fm.prpLregistSS[3].checked==false
           &&fm.prpLregistSS[4].checked==false)
  {
    errorMessage = errorMessage + "必须选择损失类型\n";
  }
  var  prpLdriverDriverName= fm.prpLdriverDriverName.value;
  if(prpLdriverDriverName.length<1){
    errorMessage = errorMessage + "驾驶员不允许为空\n";
  }
  var  prpLdriverDriverPhone= fm.prpLdriverDriverPhone.value;
  if(prpLdriverDriverPhone.length<1){
    errorMessage = errorMessage + "驾驶员联系电话不允许为空\n";
  }
  var prpLregistDamageStartHour = fm.prpLregistDamageStartHour;
  var prpLregistDamageStartMinute = fm.prpLregistDamageStartMinute;
  if(isEmptyField(prpLregistDamageStartHour) || isEmptyField(prpLregistDamageStartMinute)){
  	errorMessage = errorMessage + "出险时间不允许为空\n";
  }
  //车险需求对页面相应元素进行控制
  var prpLregistDamageAreaCode = fm.prpLregistDamageAreaCode.value;
  var prpLregistDamageAreaName = fm.prpLregistDamageAreaName.value;
  if(prpLregistDamageAreaCode.length < 1 || prpLregistDamageAreaName.length < 1){
  	errorMessage = errorMessage + "出险区域不允许为空\n";
  }
  var damageAddressType = fm.damageAddressType.value;
  if(damageAddressType.length < 1){
    errorMessage = errorMessage + "出险地点分类不允许为空\n";
  }
  var indemnityDuty = fm.indemnityDuty.value;
  if(indemnityDuty.length < 1){
    errorMessage = errorMessage + "事故责任不允许为空\n";
  }
  var prpLregistHandleUnit = fm.prpLregistHandleUnit.value;
  var prpLregistHandleUnitName = fm.prpLregistHandleUnitName.value;
  if(prpLregistHandleUnit.length < 1 || prpLregistHandleUnitName.length < 1){
    errorMessage = errorMessage + "事故处理部门不允许为空\n";
  }
  var firstSiteFlag0 = fm.firstSiteFlag[0].checked;
  var firstSiteFlag1 = fm.firstSiteFlag[1].checked;
  if(firstSiteFlag0 == "" && firstSiteFlag1 == ""){
    errorMessage = errorMessage + "是否第一现场不允许为空\n";
  }

  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }

  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
 // if(!validateForm(fm,'ThirdParty_Data,Driver_Data,ThirdCarLoss_Data,PersonTrace_Data'))
 // {
 //   return false;
 //}

  if(checkForm()==false)
  {
    return false;
  }
  
  //add for : 报案提交时提示报案时间超出险时间48小时，是否继续
  if(confirmOverTime()==false)
  {
  	if (!window.confirm("报案时间已超过出险时间48小时，是否继续" )){
  	
          return false;
        }
  }

  fm.nextScheduleTypeCheck.value="1";
  if (saveType=="4"){	  
	  //1.检查一下人伤跟踪是否有记录，如果有记录，可以调度人伤
	  var count=getElementCount("prpLpersonTracePersonNo");
	  if (count>1){
	        fm.prpLpersonTraceSelectSend.value="1";	        
	  } 
	    //2.检查一下财产定损是否有记录，如果有记录，可以调度财产定损
	  count=getElementCount("prpLthirdPropItemNo");
	  if (count>1){
	    fm.prpLthirdPropSelectSend.value="1";	    
	  } 	  
	  //还是需要检查是不是选择了一个调度，就是如果是车险的，需要检查至少选择一个车做为调度
	  if (!submittime()) return false;
	  ableAllInput();
  }
  var underWriteEndDate = fm.prpLregistUnderWriteEndDate.value;
  if(underWriteEndDate!=""){
    if((damageStartDate < underWriteEndDate) && (startDate < underWriteEndDate)){
    	if(confirm("出险时间在起保日期到签单日期之间！是否通过")==false){
    	  return false;
    	}
    }
  }
  if(fm.flashPageFlag.value!="1"){
		alert("由于出险时间变更，正在更新保单信息，请稍后再提交！");
		return false;
  }
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
  fm.submit();
  return true;
}




//add by lym 20060604  for 强三 -----------start 

function initSet_qs()
{
  var  qsFlag = fm.qsFlag.value;
  var  isStoppingCI = fm.isStoppingCI.value;//交强险是否在停驶期间出险的标志
  var isStoppingBusiness = fm.isStoppingBusiness.value;//商业险是否在停驶期间出险的标志
  var isValidRelatedFlag = fm.isValidRelatedFlag.value;//商业险、交强险有限关联的标志
  var errorMessage = message.innerHTML;
  if ( qsFlag != null && qsFlag !='' && qsFlag=='Y') { //关联则初始化，不关联则不初始化
      var qs_prpLregistStartDate = fm.qs_prpLregistStartDate.value;
      var qs_prpLregistEndDate = fm.qs_prpLregistEndDate.value;
      var qs_prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;
      var damageDate = fm.damageDate.value;
      var DamageStartTen = "";
  
      var startTenDay = new Date(qs_prpLregistStartDate.substring(0,4),qs_prpLregistStartDate.substring(5,7)-1,qs_prpLregistStartDate.substring(8,10)-1);
      if(qs_prpLregistDamageStartDate == "" || qs_prpLregistDamageStartDate == null){
  		DamageStartTen = new Date(damageDate.substring(0,4),damageDate.substring(5,7)-1,damageDate.substring(8,10));
  	  }else{
  		DamageStartTen = new Date(qs_prpLregistDamageStartDate.substring(0,4),qs_prpLregistDamageStartDate.substring(5,7)-1,qs_prpLregistDamageStartDate.substring(8,10));
	  }
      var StartTen = (DamageStartTen.getTime()- startTenDay.getTime())/(24*60*60*1000);
      var endTenDay = new Date(qs_prpLregistEndDate.substring(0,4),qs_prpLregistEndDate.substring(5,7)-1,qs_prpLregistEndDate.substring(8,10));
      var EndTen = (endTenDay.getTime()-DamageStartTen.getTime())/(24*60*60*1000);
     
      //判断是否是相同保单号码有1个以上的报案,只在登记的时候提示.
      var registNo = fm.prpLregistRegistNo.value;
      var sameCount = parseInt(fm.qs_PerilCount.value);
     
      var RecentCount = parseInt(fm.qs_RecentCount.value);
      var RegistViewLimitDay = parseInt(fm.RegistViewLimitDay.value);
     
      var policyNo = "";
      var payFee = parseInt(fm.prpLregistPayFee.value);
      if(fm.prpLregistRiskCode.value == "0507" ||fm.prpLregistRiskCode.value =="0577"||fm.prpLregistRiskCode.value =="0587"){
      	policyNo = fm.prpLregistPolicyNo.value;
      }else{
      	policyNo = fm.mainPolicyNo.value;;
      }
      
      var qs_prpLregistUnderWriteDate=fm.qs_prpLregistUnderWriteDate.value;
      var qs_prpLregistStartDate = fm.qs_prpLregistStartDate.value;
      if(qs_prpLregistUnderWriteDate>qs_prpLregistStartDate){
        errorMessage = errorMessage + "此强三保单的起保日期早于核保日期！<br>";
      }  
      
    
      /* if(qs_checkFlag!=0){//qs_checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
           errorMessage =  errorMessage + "此保单还处在批改状态 ！\n";
      }*/
     
      if(qs_prpLregistDamageStartDate<qs_prpLregistStartDate){
           errorMessage =  errorMessage + "强三出险时间不在保险期间内！<br>";
      }
      if(qs_prpLregistDamageStartDate>qs_prpLregistEndDate){
           errorMessage =  errorMessage + "强三出险时间不在保险期间内！<br>";
      }
      if(StartTen<10){
           errorMessage =  errorMessage + "保单生效"+StartTen+"天后出险！<br>";
      }
      if(EndTen<10){
           errorMessage =  errorMessage + "强三出险时间离止保日期只有"+EndTen+"天！<br>";
      }
      
     
       if (registNo.length<1) 
      {
      	//说明是登记
      	if (sameCount>0)
      	{
      	  errorMessage = errorMessage+"保单号码为'"+policyNo+"'的强三保单已经出险"+sameCount +"次！<br>";
      	  if(RecentCount>0&&RegistViewLimitDay>0){
      	    errorMessage = errorMessage+"其中最近"+RegistViewLimitDay+"天已经出险"+RecentCount +"次！<br>";
      	  }
        }else
      	{
      		fm.button_Peril_Open_Context.disabled = true;
      	}
      }
     
      if(payFee==-1){
        errorMessage=errorMessage+"此强三保单保费未缴,请慎重处理！！ <br>";
       
      } else if(payFee==-2){
        errorMessage=errorMessage+"此强三保单已缴未缴全,请慎重处理！！！ <br>";
       
      }
     
     
   }
   
   var errorMessage1 = "";
   var ralateRiskName = "保单";
   if(fm.riskcode != null && (fm.riskcode.value == "0506"||fm.riskcode.value == "0576"||fm.riskcode.value == "0586")){
        ralateRiskName = "交强险保单";
   }
   if(fm.riskcode != null && (fm.riskcode.value == "0507"||fm.riskcode.value == "0577"||fm.riskcode.value == "0587")){
        ralateRiskName = "商业险保单";
   }
   if(qsFlag == "OutInsureDate"){
   	   errorMessage1 = errorMessage1+"与该保单关联的" + ralateRiskName + "不在保险期间内，不予报案！<br>";
   }
   if(qsFlag == "NotCheckin"){
   	   errorMessage1=errorMessage1+"与该保单关联的" + ralateRiskName + "为无效保单，不予报案！<br>";
   }
   if(isValidRelatedFlag == "Y"){
        if(qsFlag == "inStopping" && isStoppingCI == "Y"){
        	errorMessage1=errorMessage1+"关联的交强险保单出险日期在停驶期间内，交强险保单不允许报案！<br>";
        }
        if(qsFlag == "inStopping" && isStoppingBusiness == "Y"){
        	errorMessage1=errorMessage1+"关联的商业险保单出险日期在停驶期间内，商业险保单不允许报案！<br>";
        }  
        if(qsFlag == "inStopping" && isStoppingBusiness == "Y" && isStoppingCI == "Y"){
            fm.buttonSaveFinishSubmit.disabled='disabled';
            fm.buttonSave.disabled='disabled';
        }                      
   }else{
	   if(qsFlag != "Y" && isStoppingCI == "Y"){
	   		errorMessage1=errorMessage1+"该保单出险日期在停驶期间内，不允许报案！<br>";
	        fm.buttonSaveFinishSubmit.disabled='disabled';
	        fm.buttonSave.disabled='disabled';
	   }
	   if(qsFlag != "Y" && isStoppingBusiness == "Y"){
	   		errorMessage1=errorMessage1+"该保单出险日期在停驶期间内，不允许报案！<br>";
	        fm.buttonSaveFinishSubmit.disabled='disabled';
	        fm.buttonSave.disabled='disabled';
	   }   
   }
   errorMessage = errorMessage + errorMessage1;
   if (errorMessage.length>0) {
      	document.getElementById("span_message").style.display = "";
      	message.innerHTML=errorMessage;
      }else{
      	message.innerHTML=errorMessage;
  		document.getElementById("span_message").style.display = "none";
  	  }
  	
	var node = fm.prpLregistDamageStartDate;
	var top = node.offsetTop;
	var left = node.offsetLeft;
	
	for (node=node.offsetParent; node != null; node=node.offsetParent) {
		top = node.offsetTop + top;
		left = node.offsetLeft + left;
	}
	
	span_message.style.top = top + 22;
	span_message.style.left = left;
  	
  	
  return true;
}
//add by lym 20060604 for 强三 ------end  

function hiddenSpan_message(){
	document.getElementById("span_message").style.display = "none";
}

function showSpan_message(){
	var errorMessage = message.innerHTML;
	if(errorMessage!=null && errorMessage != ""){
		document.getElementById("span_message").style.display = "";
	}
}

function flashPageByTime(){
  var damageStartDate = fm.prpLregistDamageStartDate;
  var prpLregistDamageStartHour = fm.prpLregistDamageStartHour;
  var prpLregistDamageStartMinute = fm.prpLregistDamageStartMinute;
  if(!isEmptyField(prpLregistDamageStartHour) && !isEmptyField(prpLregistDamageStartMinute) && !isEmptyField(damageStartDate)){
  	fm.flashPageFlag.value="0";
  	flashPage();
  }
}


function addOption(){
	//出险原因默认为”请选择“
	fm.prpLregistDamageName.value = "请选择";
	fm.prpLregistDamageCode.value = "";
	//出险区域默认为”请选择“
	fm.prpLregistDamageAreaName.value = "请选择";
	fm.prpLregistDamageAreaCode.value = "";
	//出险地点分类增加”请选择“选项，默认为空
	fm.damageAddressType.add(new Option("请选择",""));
	fm.damageAddressType.value = "";
	//事故责任增加”请选择选“项，默认为空
	fm.indemnityDuty.add(new Option("请选择",""));
	fm.indemnityDuty.value = "";
	//事故处理部门默认为”请选择“
	fm.prpLregistHandleUnitName.value = "请选择";
	fm.prpLregistHandleUnit.value = "";
	//是否第一现场报案
	fm.firstSiteFlag[1].checked = "";
}

function clearInput(field){
	if(field.value == "请选择"){
		field.value = "";
	}
}












/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{
  	//modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 提示是否在保险期限内，是否距离保单起期或止期很近（10天）
  var checkFlag = fm.checkFlag.value;
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  var prpLregistEndDate = fm.prpLregistEndDate.value;
  var damageDate = fm.damageDate.value;
  var DamageStartTen = "";
  var prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;  
  var startTenDay = new Date(prpLregistStartDate.substring(0,4),prpLregistStartDate.substring(5,7)-1,prpLregistStartDate.substring(8,10)-1);
  var endTenDay = new Date(prpLregistEndDate.substring(0,4),prpLregistEndDate.substring(5,7)-1,prpLregistEndDate.substring(8,10));
  if(prpLregistDamageStartDate == "" || prpLregistDamageStartDate == null){
  	DamageStartTen = new Date(damageDate.substring(0,4),damageDate.substring(5,7)-1,damageDate.substring(8,10));
  }else{
    DamageStartTen = new Date(prpLregistDamageStartDate.substring(0,4),prpLregistDamageStartDate.substring(5,7)-1,prpLregistDamageStartDate.substring(8,10));
  }
  var  StartTen = (DamageStartTen.getTime()- startTenDay.getTime())/(24*60*60*1000);
  var  EndTen = (endTenDay.getTime()-DamageStartTen.getTime())/(24*60*60*1000);
 
  //modify by liuyanmei add 20051109 end
  
  //modify by lixiang remark 20050315 start
  //去掉初始化保单险别，原来的函数去掉
  //loadCheckLoss();
  //modify by lixiang remark 20050315 end

  //modify by liujianbo remark 20050321 start
  //去掉初始化保单险别，原来的函数去掉
  //展开特别约定
  //var span = eval("spanEngage");
  //var engageImg = eval(fm.EngageImg);
  //span.style.display="";
  //engageImg.src="/claim/images/butExpandBlue.gif";
  //modify by liujianbo remark 20050321 end
  //var tab = eval("tabThridProp");
  //tab.style.display="none";
  //tab = eval("tabPersonTrace");
  //tab.style.display="none";
  //fm.ThirdPartyImg.onclick();

  //fm.buttonThirdPartyDelete[1].disabled = true;
  //fm.prpLthirdPartyLicenseNo[1].disabled = true;
   //modify by zhaozhuo add 20050321 start
  //reason: 涉案车辆信息中本保单车辆号牌底色、车辆种类、厂牌型号不允许修改
  fm.prpLthirdPartyBrandName[1].disabled = true;
  fm.carKindCode[1].disabled = true;
  fm.licenseColorCode[1].disabled = true;
  //modify by zhaozhuo add 20050321 end
  if(fm.prpLregistRegistNo.length<10){
    fm.messageSave.disabled=true;
    fm.messageView.disabled=true;
  }  

  //判断是否是相同保单号码有1个以上的报案,只在登记的时候提示.

  var registNo = fm.prpLregistRegistNo.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var RecentCount = parseInt(fm.RecentCount.value);
  var RegistViewLimitDay = parseInt(fm.RegistViewLimitDay.value);
  var payFee = parseInt(fm.prpLregistPayFee.value);
  var policyNo = "";
  if(fm.prpLregistRiskCode.value =="0506" ||fm.prpLregistRiskCode.value =="0576"||fm.prpLregistRiskCode.value =="0586"){
  	policyNo = fm.prpLregistPolicyNo.value;
  }else{
  	policyNo = fm.mainPolicyNo.value;
  }
  

  var errorMessage = "";
  //Modify by liujianbo modify start 20051104
  //reason:itest:545 原车险保单为倒签单业务，但进行报案时均无相应的提示，但是其它非车险理赔是有这个提示的，请确认该需求在车险处是否使用。 
  var underWriteEndDate=fm.prpLregistUnderWriteEndDate.value; 
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  if(underWriteEndDate>prpLregistStartDate){
    errorMessage = errorMessage + "此保单的起保日期早于核保日期！<br>";
  }  
   //modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 提示是否在保险期限内，是否距离保单起期或止期很近（10天）
  
   if(checkFlag!=0){//checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
       errorMessage =  errorMessage + "此保单还处在批改状态 ！<br>";
  }
  //即时生效
  if(fm.immediateValidPeriod.value != ""){
    if(fm.immediateValidPeriod.value == "N"){
        errorMessage =  errorMessage + "出险时间不在保险期间内！<br>";
    }
  }else{
    if(prpLregistDamageStartDate<prpLregistStartDate){
       errorMessage =  errorMessage + "出险时间不在保险期间内！<br>";
    }
    if(prpLregistDamageStartDate>prpLregistEndDate){
       errorMessage =  errorMessage + "出险时间不在保险期间内！<br>";
    }
  }
  if(StartTen<10){
       errorMessage =  errorMessage + "保单生效"+StartTen+"天后出险！<br>";
  }
  if(EndTen<10){
       errorMessage =  errorMessage + "出险时间离止保日期只有"+EndTen+"天！<br>";
  }
  //modify by liuyanmei add 20051109 end 
  
  //Modify by liujianbo modify end 20051104
  //alert (sameCount); 
  if (registNo.length<1) 
  {
  	//说明是登记
  	if (sameCount>0)
  	{
  	  errorMessage = errorMessage+"保单号码为'"+policyNo+"'已经出险"+sameCount +"次，请查看出险次数信息！ <br>";
  	  if(RecentCount>0&&RegistViewLimitDay>0){
  	    errorMessage = errorMessage+"其中最近"+RegistViewLimitDay+"天已经出险"+RecentCount +"次！ <br>";
  	  }
    }else
  	{
  		fm.button_Peril_Open_Context.disabled = true;
  	}
  }
  
  if(payFee==-1){
    errorMessage=errorMessage+"此保单保费未缴,请慎重处理！！ <br>";
   
  } else if(payFee==-2){
    errorMessage=errorMessage+"此保单已缴未缴全,请慎重处理！！！ <br>";
   
  }

  if (errorMessage.length>0) {
  	document.getElementById("span_message").style.display = "";
  	message.innerHTML=errorMessage;
  }else{
  	message.innerHTML=errorMessage;
  	document.getElementById("span_message").style.display = "none";
  }
  
  
  //add end
  return true;
}

//Modify By wangli remark begin 20050325
//reason: 统一使用ClaimPub.js 里的 openWinSave()方法，便于维护
/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinSave(){
   var businessNo = fm.prpLregistRegistNo.value;
   var policyNo = fm.prpLregistPolicyNo.value;
   var riskCode = fm.prpLregistRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=regis&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}
*/
/**
 *@description 弹出查看留言对话框
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function openWinQuery(){
  var win;
  var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
//Modify By wangli remark end 20050325

function noChange()
{
  fm.insureCarFlag[1].value=1;
  alert("涉案车辆的第一辆车必须为保单车辆");
  return true;
}


//Modify By wangli remark begin 20050325
//reason: 统一使用ClaimPub.js 里的 relate()方法，便于维护
//Modify By sunhao add begin 2004-09-06

/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function relate(){
		var policyNo = fm.prpLregistPolicyNo.value;
		var registNo = fm.prpLregistRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    //newWindow.focus = true;

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
function buttonOnClick(strSubPageCode)
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

*/
//Modify By wangli remark begin 20050325
/**
 * 功能：将报案扩展信息变成可编辑
 * return true/false
 */
function eidtRegistExt(tableId)
{
  var testStr = "" ;
   var elements = getTableElements(tableId);
   for(var i=0;i<elements.length;i++)
   {
    //alert(elements[i].tagName);
    if(elements[i].name=="prpLregistExtOperatorCode"||elements[i].name=="prpLregistExtContext")
    {
        tempElements = elements[i];
        //将输入域变为只读
        if(tempElements.type=="text"||tempElements.type=="hidden")
        {
  	    	tempElements.style.fontSize="9pt";
  	    	tempElements.style.borderTop = "#4196BF 1px solid";
  	    	tempElements.style.borderBottom = "#4196BF 1px solid";
  	    	tempElements.style.borderRight= "#4196BF 1px solid";
  	    	tempElements.style.borderLeft = "#4196BF 1px solid" ;
  	    	tempElements.style.width="100%";
  	    	//tempElements.style.width="80%";
  	    	//tempElements.style.color = "#000000";
  	    	tempElements.style.backgroundColor = "#ffffff";
          tempElements.readOnly=false;
        }
        //将输入域变为只读
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=false;
        }
    }
  }
}

//Add by chenrenda  begin 20050404
//Reason:出险原因、事故原因按其使用频率来排序
//出险原因变化后触发该事件，出险原因名称也跟着改变
function getDamageName(field)
{
  var list=field;
  fm.prpLregistDamageName.value = list.options[list.selectedIndex].text;
}

//事故原因变化后触发该事件，事故原因名称也跟着改变
function getDamageTypeName(field)
{
  var list=field;
  fm.prpLregistDamageTypeName.value = list.options[list.selectedIndex].text;
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
  for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
  {
    fm.prpLthirdPartyDutyPercent[i].value = indemnityDuty;
  }
}

//报案时在涉案车辆信息中不显示对涉案车辆责任比例
function changeProperties()
{
  //getIndemnityDuty();
}


//责任比例变化时，改变事故责任预估
function getIndemnityDuty()
{
  //先去掉得到事故责任预估
  /*
  var indemnityDuty = 0;
  indemnityDuty = parseFloat(fm.prpLthirdPartyDutyPercent[1].value);

  if(isNaN(indemnityDuty)){
    indemnityDuty = 0;
  }
  if(indemnityDuty<=30&&indemnityDuty>0)
  {
    fm.indemnityDuty.value="3";
  }else if(indemnityDuty>30&&indemnityDuty<=50)
  {
    fm.indemnityDuty.value="2";
  }
  else if(indemnityDuty>50&&indemnityDuty<=70)
  {
    fm.indemnityDuty.value="1";
  }
  else if(indemnityDuty>70)
  {
    fm.indemnityDuty.value="0";
  }
  else
  {
     fm.indemnityDuty.value="4";
  }
  */
}

//触发该事件时，自动生成出险摘要
function generateRegistText()
{
  //得到驾驶员信息
  var prplDriver = "";
  var prplRegistText = "";
  for( var i=1;i<fm.prpLdriverSerialNo.length;i++)
  {
    if(i==1)
    {
       prplDriver =  trim(fm.prpLdriverDriverName[i].value);
       break;
    }
  }
  //得到标的车牌信息
  var prplLicenseNo = "";
  for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
  {
    if(i==1)
    {
       prplLicenseNo =  trim(fm.prpLthirdPartyLicenseNo[i].value);
       break;
    }
  }
  //得到时间、地点、事故原因、出险原因
  var prpLregistDamageStartDate = trim(fm.prpLregistDamageStartDate.value);
  var prpLregistDamageStartHour = trim(fm.prpLregistDamageStartHour.value);
  var prpLregistDamageStartMinute = trim(fm.prpLregistDamageStartMinute.value);
  var prpLregistDamageAddress = trim(fm.prpLregistDamageAddress.value);
  var prpLregistDamageTypeName = trim(fm.prpLregistDamageTypeName.value);
  var prpLregistDamageName = trim(fm.prpLregistDamageName.value);

  var prplRegistText1 =    prpLregistDamageStartDate+"日"+prpLregistDamageStartHour+"小时"+prpLregistDamageStartMinute+"分"
                         +prpLregistDamageAddress+"由于"+prpLregistDamageTypeName+"发生"+prpLregistDamageName+"事故,";

  //得到标的车与三者车损失信息
  var count=getElementCount("prpLthirdPartySerialNo");   //受损车数量
  var serialNoCount=getElementCount("RelateSerialNo");   //受损部位数量，没有受损部位为1
  var lossMessage1 = "";     //标的车信息
  var lossMessage2 = "";     //三者车信息
  var lossMessage3 = "";     //总的出险摘要
  var lossMessageTemp = "";  //三者受损部位信息

  for(var j=1;j<count;j++)  
  {
     if( serialNoCount==1 ){  //没有受损部位
    	    if( j<(count-1)  ) {  //除去标的车
    	       lossMessage2= lossMessage2 + fm.prpLthirdPartyLicenseNo[j+1].value +"受损;"
          } 
     }
     else { //有受损部位
     	  lossMessageTemp ="" ;
   	 	  for (  var k =0 ;k< serialNoCount ;k++){ 
   	 	       if ( fm.RelateSerialNo[k].value =="1"  && j ==1 ){  //标的车有受损部位
    	 	             lossMessage1 = lossMessage1 + fm.partName[k].value+ fm.compName[k].value+"、";
    	       } 
    	       else {  //三者车
    	 	  	    if( fm.RelateSerialNo[k].value ==j   ){
    	 	  	        lossMessageTemp = lossMessageTemp + fm.partName[k].value+ fm.compName[k].value+"、"; 
    	 	  	    }
    	 	  	  }
    	 	  }//endfor
    	  if ( j > 1) {   //三者车 
    	  	  var position2 = lossMessageTemp.lastIndexOf("、");
            lossMessageTemp =lossMessageTemp.substring(0,position2);
    	  	  lossMessage2 =  lossMessage2 + trim(fm.prpLthirdPartyLicenseNo[j].value) + lossMessageTemp +  "受损;"; 
   	  	}
   	} //endelse
  } //endfor 

  var position1 = lossMessage1.lastIndexOf("、");
  lossMessage1 =lossMessage1.substring(0,position1);
  lossMessage3 = "导致标的车"+prplLicenseNo+lossMessage1+"受损;"+lossMessage2;

  //得到处理部门信息
  var HandleUnitName = "";
  HandleUnitName = trim(fm.prpLregistHandleUnitName.value);

  //得到人伤信息(需求不明确,生成规则可能以后还需改动)
  var personCount=getElementCount("prpLpersonTracePersonNo");
  var personMessage = "";
  var personMessageTemp = "";
  var kindName = "";
  for(var j=1;j<personCount;j++)
  {
    
    if(fm.prpLpersonTraceReferKind[j].value == "B"){
        kindName = "第三者责任保险,";
    }else if(fm.prpLpersonTraceReferKind[j].value == "D3"){
        kindName = "车上人员责任险－司机座位,";
    }else if(fm.prpLpersonTraceReferKind[j].value == "D4"){
        kindName = "车上人员责任险－乘客座位,";
    }else{
        kindName = fm.prpLpersonTraceReferKind[j].value;
    }
    
    personMessageTemp = fm.prpLpersonTracePersonName[j].value+"涉及险种为:"+kindName+"受伤部位:"+fm.prpLpersonTracePartDesc[j].value+";";
    personMessage = personMessage + personMessageTemp;
  }


  //得到其它损失信息(需求不明确,生成规则可能以后还需改动)
  var propCount=getElementCount("prpLthirdPropItemNo");
  var propMessage = "";
  var propMessageTemp = "";
  for(var j=1;j<propCount;j++)
  {
    propMessageTemp = fm.prpLthirdLossItemName[j].value+"受损("+fm.prpLthirdPropLossDesc[j].value+");";
    propMessage = propMessage + propMessageTemp;
  }


  //拼串得到出险摘要
  prplRegistText = "     "+prplDriver+"驾驶标的车"+prplLicenseNo+"于"+prplRegistText1+lossMessage3+personMessage+propMessage
                          +HandleUnitName+"处理。";
  fm.prpLregistTextContextInnerHTML.value = prplRegistText;
  return true;
}

//Add by chenrenda  end 20050404

//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLregistPolicyNo.value;
     var RiskCode  =fm.prpLregistRiskCode.value;
     var damageDate=fm.prpLregistDamageStartDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
	 var vURL = "";
     vURL = CoreWebUrl +'/'+RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

function  submittime(){
  return true;
/*  
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var nowtoday= new Date();
  var interval_damage = (nowtoday.getTime()- damage.getTime())/(24*60*60*1000);
  alert(interval_damage);
  if(interval_damage>=0){
  	alert("报案从开始时间到提交时间的时间间隔超时，只能够暂存，不能提交!");
	return false;
  }
*/  
}

//modify 更改出险时界面信息  by qinyongli 2005-10-5
function flashPage(){	
    var damageDate = fm.prpLregistDamageStartDate.value;
    var damageHour = fm.prpLregistDamageStartHour.value;
    var damageMiunte = fm.prpLregistDamageStartMinute.value;
    var policyNo   = fm.quaryPolicyNo.value;
    var vURL='/claim/registBeforeEdit.do?FlashPage=Y&prpCmainPolicyNo='+policyNo+'&editType=ADD&damageDate='
            +damageDate+'&damageHour='+damageHour+'&modifyDamageDate=true&damageMinute=' + damageMiunte;
    var oldAction = "/claim/registSave.do";
    var oldReportName = fm.prpLregistReportorName.value;
    var oldTarget = fm.target;
    //为了viewtodto不出错误
    fm.prpLthirdPartyLicenseNo[1].disabled = false;
    fm.prpLthirdPartyBrandName[1].disabled = false;
    fm.carKindCode[1].disabled = false;
    fm.licenseColorCode[1].disabled = false;
    fm.action=vURL;

    fm.target="fraSubmit"
    fm.submit();

    fm.action=oldAction;
    fm.target=oldTarget;  
    return true;  
}






 function confirmOverTime() {
        var date1 = fm.prpLregistDamageStartDate.value;
        var date2 = fm.prpLregistReportDate.value;
        
        var hour1 = parseInt(fm.prpLregistReportHour.value,10);
        var hour2 = parseInt(fm.prpLregistDamageStartHour.value,10);
        
        
        var strValue1 = date1.split(DATE_DELIMITER);
        var strValue2 = date2.split(DATE_DELIMITER);
        var msg = "";
        var sum = (parseInt(strValue2[2],10) - parseInt(strValue1[2],10))*24 + (hour1-hour2);
        if ((parseInt(strValue2[0],10) - parseInt(strValue1[0],10)) >= 1) {         
           return false;
        } else if ((parseInt(strValue2[1],10) - parseInt(strValue1[1],10)) >= 1) {
         
           return false;
        } else if (sum >= 48) {
          
            return false;
        }
        else {
          
           return true;
        }
 }
function showMaterialInfo(proposalNo){
  var UNDWRT_URL=fm.UNDWRT_URL.value;//双核系统的URL地址
  var UNDWRT_HOST=fm.UNDWRT_HOST.value;//双核系统的Host端口 
  var submitStr="http://"+UNDWRT_URL+":"+UNDWRT_HOST+"/undwrt/materialInfo.do?BusinessNo=" + proposalNo;
  window.open(submitStr,'资料信息','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
} 
  