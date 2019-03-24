/*****************************************************************************
 * DESC       ：预赔登记的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-05-13
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
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{ 
  return true;
}
/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initShow() 
{ 
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
    window.location.href = window.location.href;
    //window.location.href="http://www.yahoo.com";
    //location.href = location.reload();
	  //document.location.reload();
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
  fm.buttonSaveType.value = saveType;  
  //textarea文本框设置值
  var context = fm.prpLptextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "预赔报告不允许为空\n";
  }
  
 var   caseType= fm.prpLprepayCaseType.value;
 var   sumPrePaid =fm.prpLprepaySumPrePaid.value;
 var   limitFeeHaveDuty =fm.limitfeeHaveDuty.value;	
 var   limitFeeNoneDuty =fm.limitfeeNoneDuty.value;	
 
 if ( caseType =='7'){
   if ( parseFloat(sumPrePaid) >parseFloat(limitFeeHaveDuty)){
   	      errorMessage = errorMessage + "支付抢救费用金额不能超过强制保险有责医疗限额("+limitFeeHaveDuty+"元) \n";
 	        //alert(" 支付抢救费用金额不能超过强制保险有责医疗限额("+limitFeeHaveDuty+"元)");
 	      field.focus();
 	      
   }
  
 }
    if ( caseType =='8' ){
    if ( parseFloat(sumPrePaid) > parseFloat(limitFeeHaveDuty)){
    	      errorMessage = errorMessage + "垫付抢救费用金额不能超过强制保险有责医疗限额("+limitFeeHaveDuty+"元) \n";
 	        //alert(" 垫付抢救费用金额不能超过强制保险无责医疗限额("+limitFeeNoneDuty+"元)");
 	      field.focus();
   }  	
 }
  
  
  var sumClaim = fm.sumClaim.value;
  var percent = fm.percent.value;
  if ( caseType =='5'){
	  if(parseFloat(parseFloat(sumClaim)*parseFloat(percent)/100)<parseFloat(fm.prpLprepaySumPrePaid.value)){
	  	 errorMessage = errorMessage + "预赔金额应该小于等于估损金额的"+percent+"%\n";
	    //alert("预赔金额应该小于等于估损金额的"+percent+"%");
	    //return false;
	  }
  }
  var prePayFlag = fm.prePayFlag.value;
  //if(prePayFlag==0){
    //errorMessage = errorMessage + "保费未实付，不允许提交/暂存！\n";
  //}    
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616

  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(!validateForm(fm))
  {
  	return false;
  }
  //预赔金额<=估损金额的50%
  /**var sumClaim = fm.sumClaim.value;
  var percent = fm.percent.value;
  if(parseFloat(parseFloat(sumClaim)*parseFloat(percent)/100)<parseFloat(fm.prpLprepaySumPrePaid.value)){
    alert("预赔金额应该小于等于估损金额的"+percent+"%");
    return false;
  }*/
  var underWriteFlag = fm.prpLprepayUnderWriteFlag.value;
  if(saveType==4){
   // if(underWriteFlag!=1){
  //   alert("核赔复核不通过时不能提交"); 
  //   return false;
   // }
  }
  
  //如果是提交，判断是否不是nextNodeNo或者人员为空！！！！
  
  if (saveType=="4")
  {
  	/*
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
 	*/
  }
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();
  
  return true;   	
}

//modify by wangli remark start 20050409
/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinSave(){
   
   
   var policyNo = fm.prpLprepayPolicyNo.value;
   var riskCode = fm.prpLprepayRiskCode.value;
   var businessNo = fm.prpLprepayClaimNo.value;
   var claimNo = fm.prpLprepayClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=prepa&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
  
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
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLprepayClaimNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
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
		var policyNo = fm.prpLprepayPolicyNo.value;
		var claimNo = fm.prpLprepayClaimNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&claimNo=" +claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
//Modify By sunhao add end 2004-09-06
*/
//modify by wangli remark end 20050409

//Modify By liubvo add end 2004-09-07
/**
 *@description 实赔任务复核
 *@param       无
 *@return      通过返回true,否则返回false
 */
function approveSubmit()
{
  fm.buttonApprove.disabled = true;
  fm.submit();
  return true;
}


//modify by wangli remark start 20050409
/*
//Modify By liubvo add end 2004-09-07
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
//modify by wangli remark end 20050409

//add by zhangyingrui start at 20060808
/**
*@description 处理索赔资料清单 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}   
/**
 *@description 弹出单证页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function openCertify(registNo){  
  window.open("/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType="+nodeType,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500"); 
}
//add by zhangyingrui end at 20060808

//add by zhangyingrui start at 20060809
/**
*@description 特殊赔案处理中，垫付、支付抢救费用限制不能超过强制无责医疗限额 
*@param        
*/
function checkBeyondLimitFee(field){
	
 var   caseType= fm.prpLprepayCaseType.value;
 var   sumPrePaid =fm.prpLprepaySumPrePaid.value;
 var   limitFeeHaveDuty =fm.limitfeeHaveDuty.value;	
 var   limitFeeNoneDuty =fm.limitfeeNoneDuty.value;	
 
 if ( caseType =='7'){
   if ( parseFloat(sumPrePaid) >parseFloat(limitFeeHaveDuty)){
 	        alert(" 支付抢救费用金额不能超过强制保险有责医疗限额("+limitFeeHaveDuty+"元)");
 	      field.focus();
   }
  
 }
 else if ( caseType =='8' ){
    if ( parseFloat(sumPrePaid) > parseFloat(limitFeeHaveDuty)){
 	        alert(" 垫付抢救费用金额不能超过强制保险有责医疗限额("+limitFeeHaveDuty+"元)");
 	      field.focus();
   }  	
 }
	
}
//add by zhangyingrui end at 20060809
