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

	if(!validateForm(fm,'ThirdProp_Data'))
  {
    return false;
  }
  var errorMessage = "";
  //出险日期必须大于等于起运日期
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "联系人电话不能为空\n";
  }

  
  var startDate = fm.prpLregistStartDate.value;
  var damageDate   = fm.prpLregistDamageStartDate.value;
  if(damageDate < startDate){
  	StrMessage = "提示：出险时间小于起运日期，不给予报案!";
  	alert(StrMessage);
  		return false;
  	
  }
  //add by caopeng start at 20051221
  var damageAddress = fm.prpLregistDamageAddress.value;
  if(damageAddress.length<1){
    errorMessage = errorMessage + "出险地点不允许为空\n";
  }
  var linkerName = fm.prpLregistLinkerName.value;
  if(linkerName.length<1){
    errorMessage = errorMessage + "联系人不允许为空\n";
  }
  //add by caopeng end at 20051221 
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
  //add by qinyongli  start  2005-9-2
  //reason:增加输单日期和出险日期的判断，输单日期必须在出险日期之后
    var inputDate  = fm.prpLregistInputDate.value;
    if(new Date(inputDate) < new Date(damageDate)){
        errorMessage = errorMessage + "出险日期不能大于输单日期\n";
    }
        if(new Date(registDay) < new Date(damageDay)){
        errorMessage = errorMessage + "出险日期不能大于报案日期\n";
    }
  //add by qinyongli end 
  fm.buttonSaveType.value = saveType;
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
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
  	 message = message + "出险时间在保险期间以外,是否通过？\n";
  }
  if (message.length>0&&!confirm(message)) {
     return false;
  }
  //add end qinyongli 2005/07/20 end

 if(checkForm()==false)
  {
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

  if(!validateForm(fm,'ThirdProp_Data'))
  {
    return false;
  }
  var errorMessage = "";
  //出险日期必须大于等于起运日期
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "联系人电话不能为空\n";
  }

  
  var startDate = fm.prpLregistStartDate.value;
  var damageDate   = fm.prpLregistDamageStartDate.value;
  if(damageDate < startDate){
    StrMessage = "提示：出险时间小于起运日期，不给予报案!";
    alert(StrMessage);
      return false;
    
  }
  //add by caopeng start at 20051221
  var damageAddress = fm.prpLregistDamageAddress.value;
  if(damageAddress.length<1){
    errorMessage = errorMessage + "出险地点不允许为空\n";
  }
  var linkerName = fm.prpLregistLinkerName.value;
  if(linkerName.length<1){
    errorMessage = errorMessage + "联系人不允许为空\n";
  }
  //add by caopeng end at 20051221 
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
  //add by qinyongli  start  2005-9-2
  //reason:增加输单日期和出险日期的判断，输单日期必须在出险日期之后
    var inputDate  = fm.prpLregistInputDate.value;
    if(new Date(inputDate) < new Date(damageDate)){
        errorMessage = errorMessage + "出险日期不能大于输单日期\n";
    }
        if(new Date(registDay) < new Date(damageDay)){
        errorMessage = errorMessage + "出险日期不能大于报案日期\n";
    }
  //add by qinyongli end 
  fm.buttonSaveType.value = saveType;
  fm.scheduleRef.value = scheduleRef;
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
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
     message = message + "出险时间在保险期间以外,是否通过？\n";
  }
  if (message.length>0&&!confirm(message)) {
     return false;
  }
  //add end qinyongli 2005/07/20 end

 if(checkForm()==false)
  {
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
  var shareHolderFlag = fm.shareHolderFlag.value;
  var message = "";
  //add by qinyongli 增加保单注销,报案时间，倒签单，股东业务，出险次数，临分共保等提示； 2005-7-28
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
   //modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 提示是否在保险期限内，是否距离保单起期或止期很近（10天）
  
   if(checkFlag!=0){//checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
       message =  message + "此保单还处在批改状态 ！\n";
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
  //modify by liuyanmei add 20051109 end 
  
   //判断是否是相同保单号码有1个以上的报案,只在登记的时候提示.
  
  var registNo = fm.prpLregistRegistNo.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var policyNo = fm.prpLregistPolicyNo.value;
  
  //alert (sameCount);
  if (registNo.length<1)
  {
  	//说明是登记
  	if (sameCount>0) 
  	{
  	message = message + "保单号码为'"+policyNo+"'已经出险"+sameCount +"次，请查看出险次数信息！";
      if(RecentCount>0&&RegistViewLimitDay>0){
  	   message = message+"其中最近"+RegistViewLimitDay+"天已经出险"+RecentCount +"次！ \n";
  	 }
     }else
  	{
  		fm.button_Peril_Open_Context.disabled = true;
  	}
    
  }
  
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
//Modify By wangli remark begin 20050325

/**
 *@description 弹出查看留言对话框
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinQuery(){
var win;
alert("test"+fm.prpLregistRegistNo.value);
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}

*/
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
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
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