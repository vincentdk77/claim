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
  var message = "";
  //判断是否还有申请未处理 2005-08-04
  /*delete by liuyanmei reason:报案提交立案，不判断[调查]是否提交（需求）
  if (saveType == '4' && fm.AcciClaimFlag.value == 'N') {
      alert("还有调查申请没有处理，不能提交!");
      return false;
  } 
  */     
  //add by caopeng start at 20051222 reason:联系人：必录项
  var linkerName = fm.prpLregistLinkerName.value;
  if(linkerName.length<1){
    errorMessage = errorMessage + "联系人不允许为空\n";
  }
  var PhoneNumber = fm.prpLregistPhoneNumber.value;
  if(PhoneNumber.length<1){
    errorMessage = errorMessage + "联系电话不允许为空\n";
  }
  var prpLregistDamageStartHour = fm.prpLregistDamageStartHour;
  var prpLregistDamageStartMinute = fm.prpLregistDamageStartMinute;
  if(isEmptyField(prpLregistDamageStartHour) || isEmptyField(prpLregistDamageStartMinute)){
  	errorMessage = errorMessage + "事故时间不允许为空\n";
  }
  var prpLregistDamageAddress = fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "事故地点不允许为空\n";
  }
  //add by caopeng end at 20051222
  //modify by liujianbo modify 20051110 start
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "出险摘要不允许为空\n";
  }
  
  var prpLregistDamageCode = fm.prpLregistDamageCode.value;
  if(prpLregistDamageCode<1){
    errorMessage = errorMessage + "事故原因代码不允许为空\n";
  }
  
  var prpLregistDamageName = fm.prpLregistDamageName.value;
  if(prpLregistDamageName<1){
    errorMessage = errorMessage + "事故原因名称不允许为空\n";
  }
  
 //add 20051207 start reason:事故类型：必录项 不带入默认项（需求）
  var damageTypeCode = fm.prpLregistDamageTypeCode.value;
  if(damageTypeCode.length<1){
    errorMessage = errorMessage + "事故类型代码不允许为空\n";
  }
  var damageTypeName = fm.prpLregistDamageTypeName.value;
  if(damageTypeName.length<1){
    errorMessage = errorMessage + "事故类型名称不允许为空\n";
  }
  //add 20051207  end reason:事故类型：必录项 不带入默认项（需求）
  //modify by liujianbo modify 20051110 end 
  if(fm.acceptFlag[0].checked==false && fm.acceptFlag[1].checked==false){
    errorMessage = errorMessage + "受理标志不允许为空\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "是否向别的保险公司投保不允许为空\n";
  }
  
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  var prpLregistEndDate = fm.prpLregistEndDate.value;
  var prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;
  if(prpLregistDamageStartDate<prpLregistStartDate||prpLregistDamageStartDate>prpLregistEndDate){
      errorMessage = errorMessage + "出险时间不在保险期间，系统不允许报案\n";
  } 
  //delete by zhaolu 20060829 start
  /**if(fm.prpLregistReceiverCode.value=="")
  {
      alert("接案人代码不能为空！")
      return false;
  } */
  //delete by zhaolu 20060829 end
  
  if(fm.prpLregistReceiverName.value=="")
  {
      alert("接案人姓名不能为空！")
      return false;
  }  
  if(fm.prpLacciPersonAcciCode.value=="")
  {
      alert("请输入事故者信息")
      return false;
  }
  for(i=1;i<fm.prpLacciPersonAcciCode.length;i++){
   /*
   if(fm.prpLacciPersonAcciCode[i].value==""){
      alert("请输入事故者代码")
      return false;
   }*/
	 if(fm.prpLacciPersonAcciName[i].value==""){
	      alert("请输入事故者名称")
	      return false;
	   }
	   
	 if(fm.prpLacciPersonFamilyNo[i].value==""){
	 	  alert("请双击选择事故者名称")
	      return false;
	 }
  }
  fm.buttonSaveType.value = saveType;
  

     
  //add by qinyongli 2005/07/20 start
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
  //add end qinyongli 2005/07/20 end
  //add by qinyongli  start  2005-9-2
  //reason:增加输单日期和出险日期的判断，输单日期必须在出险日期之后
    var inputDate  = fm.prpLregistInputDate.value;
    
    var reporthour = parseInt(fm.prpLregistReportHour.value);
    var reportminute = parseInt(fm.prpLregistReportMinute.value);
    var damagehour = parseInt(fm.prpLregistDamageStartHour.value);
    var damageminute = parseInt(fm.prpLregistDamageStartMinute.value);
    
    if(isNaN(reporthour)) reporthour = 0;
    if(isNaN(reportminute)) reportminute = 0;
    if(isNaN(damagehour)) damagehour = 0;
    if(isNaN(damageminute)) damageminute = 0;    
    if(compareFullDate(inputDate,damageDay) == -1){
        errorMessage = errorMessage + "事故时间不能大于输单日期\n";
    }   
    if(compareFullDate(registDay,damageDay) == -1){
        errorMessage = errorMessage + "事故时间不能大于报案日期\n";
    }
    else if(compareFullDate(registDay,damageDay) == 0){
      if(reporthour<damagehour){
        errorMessage = errorMessage + "事故时间不能大于报案时间\n";
      }
      else if(reporthour==damagehour && reportminute<damageminute){
        errorMessage = errorMessage + "事故时间不能大于报案时间\n";
      }      
    }
    var currDate = new Date();
    if(regist > currDate){
    	errorMessage = errorMessage + "报案时间不能大于当前时间\n";
    }
    /*if(compareFullDate(inputDate, currDate.getYear() + "-" + (currDate.getMonth() + 1) + "-" + currDate.getDate()) == 1 ){
    	errorMessage = errorMessage + "输单时间不能大于当前时间\n";
    }*/
  //add by qinyongli end 
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
  var payFee = parseInt(fm.prpLregistPayFee.value);
  
  var underWriteEndDate=fm.underWriteEndDate.value;
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  //add by qinyongli 增加保单注销，倒签单，股东业务等提示； 2005-7-28
  var message = "";
  var shareHolderFlag = fm.shareHolderFlag.value;
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
  
   if(payFee==-1){
         message=message+"此保单保费未缴,请慎重处理！！！ \n";
     }
      else if(payFee==-2){
           message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
      }
  
  if (message.length>0) {
      alert(message);
  } 
  // add by qingyongli  end  2005-7-28

  if(fm.prpLregistRegistNo.length<10){
    fm.messageSave.disabled=true;
    fm.messageView.disabled=true; 
  }
  
  
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
  	alert("保单号码为'"+policyNo+"'已经出险"+sameCount +"次，请查看出险次数信息！");
    }else
  	{
  		fm.button_Peril_Open_Context.disabled = true;
  	}
    
  }
  
  
  
  return true;
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

//意健险在报案时可以选择是否呈报，是：1 否：0
function changePrplregistReportFlag() {
    if (fm.prplregistReportFlag[0].checked) {
        ReportFlag.style.display = "";
    } else {
        ReportFlag.style.display = "none";
    }
}
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLregistPolicyNo.value;
     var RiskCode  =fm.prpLregistRiskCode.value;
     var damageDate=fm.prpLregistDamageStartDate.value;
     //add by kangzhen 061118
     var ClassCode = RiskCode.substring(0,2);
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL =  CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&ClassCode='+ClassCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
//modify add by huangyunzhong 20051025 调整为点击被保险人代码后弹出新网页，原页面保留
function showPersonInsured(prpDcustomerIdvCustomerCode){	       
    var prpCmainPolicyNo=fm.prpCmainPolicyNo.value
    var messagedo = "/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpCmainPolicyNo="+prpCmainPolicyNo+"&prpDcustomerIdvCustomerCode="+prpDcustomerIdvCustomerCode+"& target='_blank'";	  
    win = window.open(messagedo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
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
