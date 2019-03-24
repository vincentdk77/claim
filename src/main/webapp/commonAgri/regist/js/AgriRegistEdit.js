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

function checkForm()
{
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

function checkEarNoBeforeSave(){
	 var count = getElementCount("prplCompensateEarEarNo");
	 var earnos = document.getElementsByName("prplCompensateEarEarNo");
	 var fCode = document.getElementsByName("prplCompensateEarFCode");
	 var inprocess = document.getElementsByName("prplCompensateEarInprocess");
	 var listFlag = document.getElementsByName("listFlag")[0].value;
	 	for(var index =0 ;index < count ; index++)
	 	{
	 	 if (index ==0) continue;
	 	if(listFlag == "true"){
	 		if(trim(fCode[index].value).length == 0)
		 	 {
		 	 	alert("该保单已关联清单，请双击耳标号录入域，查询并选择对应耳标信息");
		 	 	return false;
		 	 }
	 		if(trim(inprocess[index].value) == "Y")
		 	 {
		 	 	alert("包含正在进行处理的耳标号，不能提交！");
		 	 	return false;
		 	 }
	 	 }
	 	 else if(listFlag == "error"){
	 		if(trim(fCode[index].value).length == 0)
		 	 {
		 	 	alert("该保单清单主表异常,请与信息技术部联系！！！");
		 	 	return false;
		 	 }
	 	 }
	 	 if(trim(earnos[index].value).length == 0)
	 	 {
	 	 	alert("耳标号不可为空!");
	 	 	return false;
	 	 }
	 	 var i =index;
	 	 i++;
	 	 while(i < count)
	 	 {
	 	  if(earnos[index].value == earnos[i].value)
	 	  {
	 	  alert("耳标号不可重复");
	 	  	return false;
	 	 	}
	 	 	 i++;
	 	 }
	 	 
	 	}
	 	return true;
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
		var bool = checkEarNoBeforeSave();
		if ( bool != true) return false;
	}
  var errorMessage = "";
  
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "联系人电话不能为空\n";
  }
  //添加If判断用以在页面增加必录项”报案人“
  if(fm.prpLregistReportorName.value==null||fm.prpLregistReportorName.value==""){
    errorMessage = errorMessage + "报案人不能为空\n";
  }  
  if(checkForm()==false)
  {
    return false;
  }
  
  if(!validateForm(fm))
  {
    return false;
  }
  //modify by liujianbo modify 20051110 start
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "出险摘要不允许为空\n";
  }
     //modify by liujianbo modify 20051110 end 
  if(fm.acceptFlag[0].checked==false && fm.acceptFlag[1].checked==false){
    errorMessage = errorMessage + "受理标志不允许为空\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "是否向别的保险公司投保不允许为空\n";
  }
     
  fm.buttonSaveType.value = saveType;
     
  //add by qinyongli 2005/07/20 start
  //获取报案出险延期天数
  var delayDays=fm.configValue.value;
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var registDay = fm.prpLregistReportDate.value;
  var regist = new Date(registDay.substring(0,4),registDay.substring(5,7)-1,registDay.substring(8,10));
  var message = "";
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
  	message = message + "提示：报案出险延期天数大于"+delayDays+"天，\n";
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
  	 var message1 = "出险时间在保险期间以外,不给予报案!！";
  	 alert(message1);
  	 return false;
  }
  if (message.length>0&&!confirm(message)) {
     return false;
  }
  //add end qinyongli 2005/07/20 end
  //add by qinyongli  start  2005-9-2
  //reason:增加输单日期和出险日期的判断，输单日期必须在出险日期之后
  var inputDate  = fm.prpLregistInputDate.value; 
  if(new Date(inputDate)< new Date(damageDay)){
      errorMessage = errorMessage + "出险日期不能大于输单日期\n";
  }

 // if(regist < damage){
  //    errorMessage = errorMessage + "出险日期不能大于报案日期\n";
 // }
  //add by qinyongli end 
  var currDate = new Date();
  if(regist > currDate){
  		errorMessage = errorMessage + "报案日期不能大于当前日期\n";
  }
  if(new Date(inputDate) > currDate){
  		errorMessage = errorMessage + "输单日期不能大于当前日期\n";
  }
  
  
  //modify by liuyanmei 20051024 start 
  var  prpLregistAddressCode= fm.prpLregistAddressCode.value;
  /*if(prpLregistAddressCode.length<1){
    errorMessage = errorMessage + "出险地邮政编码不允许为空\n";
  }else if(prpLregistAddressCode.length!=6){
    errorMessage = errorMessage + "出险地邮政编码应为6位\n";
  }*/

   var  prpLregistDamageAddress= fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "出险地不允许为空\n";
  }
  //modify by liuyanmei 20051024 end 
  
  for(var j=1;j<fm.prpLacciPersonFamilyNo.length;j++){
    if(isEmptyField(fm.prpLacciPersonFamilyNo[j]))
    {
	   alert("第"+ j+"被保险人名称不能为空!");
	   return false;
	}
  }
 
  //币别信息
  var prpLregistEstiCurrency = fm.prpLregistEstiCurrency.value;
  if(prpLregistEstiCurrency == ""){
        errorMessage += "币别不能为空！";
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }

    field.disabled = true;
  	fm.submit(); 
    return true;
}

/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveFormNew(field,saveType,scheduleRef)
{
   if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
  {
    var bool = checkEarNoBeforeSave();
    if ( bool != true) return false;
  }
  var errorMessage = "";
  
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "联系人电话不能为空\n";
  }
  
  if(checkForm()==false)
  {
    return false;
  }
  
  if(!validateForm(fm))
  {
    return false;
  }
  //modify by liujianbo modify 20051110 start
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "出险摘要不允许为空\n";
  }
     //modify by liujianbo modify 20051110 end 
  if(fm.acceptFlag[0].checked==false && fm.acceptFlag[1].checked==false){
    errorMessage = errorMessage + "受理标志不允许为空\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "是否向别的保险公司投保不允许为空\n";
  }
     
  fm.buttonSaveType.value = saveType;
  fm.scheduleRef.value = scheduleRef;   
  //add by qinyongli 2005/07/20 start
  //获取报案出险延期天数
  var delayDays=fm.configValue.value;
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var registDay = fm.prpLregistReportDate.value;
  var regist = new Date(registDay.substring(0,4),registDay.substring(5,7)-1,registDay.substring(8,10));
  var message = "";
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
    message = message + "提示：报案出险延期天数大于"+delayDays+"天，\n";
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
     var message1 = "出险时间在保险期间以外,不给予报案!！";
     alert(message1);
     return false;
  }
  if (message.length>0&&!confirm(message)) {
     return false;
  }
  //add end qinyongli 2005/07/20 end
  //add by qinyongli  start  2005-9-2
  //reason:增加输单日期和出险日期的判断，输单日期必须在出险日期之后
  var inputDate  = fm.prpLregistInputDate.value; 
  if(new Date(inputDate)< new Date(damageDay)){
      errorMessage = errorMessage + "出险日期不能大于输单日期\n";
  }

 // if(regist < damage){
  //    errorMessage = errorMessage + "出险日期不能大于报案日期\n";
 // }
  //add by qinyongli end 
  var currDate = new Date();
  if(regist > currDate){
      errorMessage = errorMessage + "报案日期不能大于当前日期\n";
  }
  if(new Date(inputDate) > currDate){
      errorMessage = errorMessage + "输单日期不能大于当前日期\n";
  }
  
  
  //modify by liuyanmei 20051024 start 
  var  prpLregistAddressCode= fm.prpLregistAddressCode.value;
  /*if(prpLregistAddressCode.length<1){
    errorMessage = errorMessage + "出险地邮政编码不允许为空\n";
  }else if(prpLregistAddressCode.length!=6){
    errorMessage = errorMessage + "出险地邮政编码应为6位\n";
  }*/

   var  prpLregistDamageAddress= fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "出险地不允许为空\n";
  }
  //modify by liuyanmei 20051024 end 
  
  for(var j=1;j<fm.prpLacciPersonFamilyNo.length;j++){
    if(isEmptyField(fm.prpLacciPersonFamilyNo[j]))
    {
     alert("第"+ j+"被保险人名称不能为空!");
     return false;
  }
  }
 
  //币别信息
  var prpLregistEstiCurrency = fm.prpLregistEstiCurrency.value;
  if(prpLregistEstiCurrency == ""){
        errorMessage += "币别不能为空！";
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }

    field.disabled = true;
    fm.submit(); 
    return true;
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
  var sameCount = parseInt(fm.PerilCount.value);
  var RecentCount = parseInt(fm.RecentCount.value);
  var RegistViewLimitDay = parseInt(fm.RegistViewLimitDay.value);
  var payFee = parseInt(fm.prpLregistPayFee.value);
  var delinquentfeeCase = fm.delinquentfeeCase.value;
  
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  var prpLregistEndDate = fm.prpLregistEndDate.value;
  var prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;
  var damageDate = fm.damageDate.value;
  var DamageStartTen = "";

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

  if(fm.prpLregistRegistNo.length<10){
    fm.messageSave.disabled=true;
    fm.messageView.disabled=true; 
  }
  
  
   //判断是否是相同保单号码有1个以上的报案,只在登记的时候提示.
  
  var registNo = fm.prpLregistRegistNo.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var policyNo = fm.prpLregistPolicyNo.value;
  //add by qinyongli 增加保单注销,报案时间，倒签单，股东业务，出险次数，临分共保等提示； 2005-7-28
  var coinsFlag = fm.coinsFlag.value;
  var tempReinsFlag = fm.tempReinsFlag.value;
  var shareHolderFlag = fm.shareHolderFlag.value;
  var message = "";
  
  var othFlag = fm.prpLregistOthFlag.value;
  if(othFlag.substring(3,4)=="1"){
    message = message + "此保单已注销！\n";
 
    fm.buttonSave.disabled = true;
    fm.registPrint.disabled = true;
    fm.buttonCancel.disabled = true;
    fm.buttonSaveFinishSubmit.disabled = true; 
  }
  var underWriteEndDate=fm.underWriteEndDate.value;
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  if(underWriteEndDate>prpLregistStartDate){
     message = message + "此保单的起保日期早于核保日期！\n";
  }
  if(shareHolderFlag!=0){
     message = message + "此保单为股东业务！\n";
  }
  if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
     message = message + "此保单为联/共保单！\n";
  }
  if(tempReinsFlag!=0){
     message = message + "此保单有临分业务！\n";
  }
  //modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 提示是否在保险期限内，是否距离保单起期或止期很近（10天）
  
   if(checkFlag!=0){//checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
       errorMessage =  errorMessage + "此保单还处在批改状态 ！\n";
  }
  if(prpLregistDamageStartDate<prpLregistStartDate){
      message = message + "出险时间不在保险期间内！\n";
  }
  if(prpLregistDamageStartDate>prpLregistEndDate){
      message = message + "出险时间不在保险期间内！\n";
  }
  if(StartTen<10){
      message = message + "保单生效"+StartTen+"天后出险！\n";
  }
  if(EndTen<10){
      message = message + "出险时间离止保日期只有"+EndTen+"天！\n";
  }
  if(payFee==-1){
         message=message+"此保单保费未缴,请慎重处理！！！ \n";
     }
      else if(payFee==-2){
           message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
           message = message + delinquentfeeCase + "\n";
      }
  //modify by liuyanmei add 20051109 end 
  //alert (sameCount);
  if (registNo.length<1)
  {
  	//说明是登记
  	if (sameCount>0) 
  	{
           message = message + "保单号码为'"+policyNo+"'已经出险"+sameCount +"次，请查看出险次数信息！\n";
        if(RecentCount>0&&RegistViewLimitDay>0){
  	   message = message+"其中最近"+RegistViewLimitDay+"天已经出险"+RecentCount +"次！ \n";
  	 }
  	}else
  	   {
  	      fm.button_Peril_Open_Context.disabled = true;
  	   }
      if (message.length>0) {
          alert(message);
      } 
    
  }else{
      if (message.length>0) {
          alert(message);
      } 
  }
  // add by qingyongli  end  2005-7-28
}
/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinSave(){
   
   var businessNo = fm.prpLregistRegistNo.value;
   var policyNo = fm.prpLregistPolicyNo.value;
   var riskCode = fm.prpLregistRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=regis&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description 弹出查看留言对话框
 *@param       无
 *@return      通过返回true,否则返回false
 */
 
function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}


function noChange()
{   
  fm.insureCarFlag[1].value=1;
  alert("涉案车辆的第一辆车必须为保单车辆");
  return true;
}	   

//Modify By sunhao add begin 2004-09-06

/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
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
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLregistPolicyNo.value;
     var RiskCode  =fm.prpLregistRiskCode.value;
     var damageDate=fm.prpLregistDamageStartDate.value;
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
    var BizNo     =fm.prpLregistPolicyNo.value;
    var RiskCode  =fm.prpLregistRiskCode.value;
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL =  CoreWebUrl +'/' + RiskCode + '/cb/UIPolicy' + RiskCode + 'FHNoneFormatPrint.jsp?EDITTYPE=POLICY&FlagForPrint=46&BizNo='+ BizNo;
    window.open(vURL,'分户清单信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

//modify 更改出险时界面信息  by qinyongli 2005-10-5
function flashPage(){
    var damageDate = fm.prpLregistDamageStartDate.value;
    var damageHour = fm.prpLregistDamageStartHour.value;
    var policyNo   = fm.policyno.value;
    var vURL='/claim/registBeforeEdit.do?prpCmainPolicyNo='+policyNo+'&editType=ADD&damageDate='+damageDate+'&damageHour='+damageHour+'&modifyDamageDate=true';
    var oldAction = "/claim/registSave.do";
    var oldReportName = fm.prpLregistReportorName.value;
    var oldTarget = fm.target;

    fm.action=vURL;
    fm.target=oldTarget;
    fm.submit();

    fm.action=oldAction;
    fm.target=oldTarget;
   
    return true;  
}
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

//增加耳标号列表
function addEarList()
{  
    
    var strPrpLregistPolicyNo = fm.prpLregistPolicyNo.value;
    var strPrpLregistRegistNo = fm.prpLregistRegistNo.value;
    var strEditType = fm.editType.value;
    var strURL = '/claim/commonAgri/regist/AgriRegistEarList.jsp?strEditType='+strEditType+'&strPrpLregistPolicyNo='+strPrpLregistPolicyNo+'&CurrentEar=addAppEarCallBack'+'&strPrpLregistRegistNo='+strPrpLregistRegistNo;//+'strPrpInsuredName='+strPrpInsuredName+'&strPrpEarNo='+strPrpEarNo;
    
    window.open(strURL,'AddPrpMainEarList','width=680,height=350,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=0,resizable=1,status=0');
}
//检查耳标号真实性
function earCheck(){
    //隐藏掉所有的耳标号验证失败的标志。
	hideRealEarCheckFailureSign();
	
	
	var policyNo   = fm.prpLregistPolicyNo.value;
	//var strPrpLregistRegistNo = fm.prpLregistRegistNo.value;
	var earList = "";
	var checkResult="true";
	
	//检查耳标号的输入。
	var checkEarImputFormatResult = checkEarInputFormat();
	if(!checkEarImputFormatResult)
		return false;
	
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
		
			if(i==1) 
				earList = fm.prpLearNo[i].value;
			else 
				earList = earList + "," + fm.prpLearNo[i].value
		}
		var parameterList = "policyNo=" + policyNo;
		parameterList = parameterList + "&" + "earList=" + earList;
		//传入耳标号列表，去查询电子档案系统中承保清单。
		//返回结果为： 用"|"来区分开各个耳标号返回结果。
		//           每一个耳标号返回结果如下边所示：
		//           耳标号：农户姓名          清单中存在的耳标号。
		//           耳标号：cannotfind     耳标号不存在，需要重新输入。
		//           耳标号：noIsuranceList 承保清单不存在，耳标号随意输入。
		var strEarCheckResult = findEarInfo(trim(parameterList));
		
		//alert("strEarCheckResult is "+strEarCheckResult);
		if("" == strEarCheckResult || null == strEarCheckResult){
			alert("耳标号验证失败！");
		}else {
			var earCheckResultList = strEarCheckResult.split("|");
			var unRealEar = "";
			//alert("earCheckResultList.length is "+earCheckResultList.length);
			if(earCheckResultList.length>0){
				for(var j=0; j < earCheckResultList.length; j++){
					//alert("earCheckResultList["+j+"]  is "+earCheckResultList[j]);
					if(null != earCheckResultList[j]){
						var singleEarInfo = earCheckResultList[j].split(":");
						//alert("singleEarInfo  is "+singleEarInfo);
						//alert("vPrpLearNoLength  is "+vPrpLearNoLength);
						for(var i = 1;i < vPrpLearNoLength;i++){
							var prpLearNo = trim(fm.prpLearNo[i].value);
							//alert("singleEarInfo  is "+singleEarInfo[0]);
							//alert("prpLearNo  is "+prpLearNo);
							if(singleEarInfo[0] == prpLearNo){
								if("cannotfind"==singleEarInfo[1]){
									fm.valueofEarCheck.value="false";
									fm.prpLearNo[i].style.backgroundColor = "red";
									fm.fname[i].value = "";
									//把耳标号保存起来，在弹出框中显示。
									if(""==unRealEar)
										unRealEar = singleEarInfo[0];
									else unRealEar = unRealEar + "," + singleEarInfo[0];
								}
								else if("noIsuranceList"!=singleEarInfo[1]){
									fm.fname[i].value = singleEarInfo[1];
								}
							}
						}
					}
				}
			}
			if(""!=unRealEar)
				alert("耳标号："+unRealEar+" 不存在，请重新填写！");
			else{
				fm.valueofEarCheck.value="true";
				alert("耳标号验证通过，请继续输入！");
			}
		}
	}
}
//查找耳标号，返回耳标号的信息
//strQueryString参数格式是：参数1=值1&参数2=值2
function findEarInfo(strQueryString)
{
  var earURL = "/claim/combineAgri/regist/AgriRegistEarList.jsp";
  var strURL = earURL + "?" + strQueryString;
  var vXmlText = getResponseXmlText(strURL);
  //截掉头尾字符[]
  if(vXmlText.length>=2)
    return vXmlText.substring(1,vXmlText.length-1);
  else
    return "";
}
//隐藏所有的耳标号验证失败的标记，耳标号红色背景色
function hideRealEarCheckFailureSign(){
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			fm.prpLearNo[i].style.backgroundColor = "white";
		}
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

//农险查勘页面"..."按钮单击事件，用于相同保单号码多报案的显示 add by xuecheng
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