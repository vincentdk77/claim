/*****************************************************************************
 * DESC       ：结案登记的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-06-28
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 检查结案登记
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{
  return true;
}
/**
 *@description 检查总赔付金额是否为负
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checksumPaid()
{
  if(fm.SumPaid.value>=0){
    return true;
  }else{
    alert("赔款总金额不能为负值！");
    return false;
  }
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
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet() 
{  
  return true;
}
/**
 *@description 根据按钮状态保存结案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveForm(field,saveType)
{   
   if(fm.RiskCode.value=="0507"||fm.RiskCode.value=="0506"){
   if(checksumPaid()==false)
  {
    return false;
  }
  }
	
   if(!confirm("结案后不能再修改。\n确定结案吗？"))
    return false;
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;  
  //fm.action = "/claim/endcaseSave.do?step=step1";
  //textarea文本框设置值
 /* var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "结案报告不允许为空\n";
  } */     
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  /*if(!validateForm(fm))
  {
    return false;
  }*/
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
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
  var businessNo = fm.prpLclaimRegistNo.value;
  var policyNo = fm.prpLclaimPolicyNo.value;
  var claimNo = fm.prpLendcaseClaimNo1.value;
  var registNo = fm.prpLclaimRegistNo.value;
  msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=endca&policyNo=" +policyNo+ "&claimNo=" +claimNo+ "&registNo=" +registNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
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
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
//modify by wangli remark end 20050409
//modify by wangli update start 20050409
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function relate2(){
  var policyNo = fm.prpLclaimPolicyNo.value;
  var registNo = fm.prpLclaimRegistNo.value;
  var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //newWindow.focus = true;  
}
//modify by lym 20060307 start-----------------------------------------------------------------------
//结案中计算书、附页打印需先展示列表
function relate3(printType){//打印赔款计算书、附页时弹出页面
  var claimNo = fm.prpLendcaseClaimNo1.value;
  var newWindow = window.open("/claim/compensateQuery.do?ClaimNo=" +claimNo+"&editType=PRINT&PrintType="+printType,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
/*
function relate3(printType){//打印赔款计算书、附页时弹出页面
  var compensateNo = fm.prpLendcasecompensateNo.value;
  var newWindow = window.open("/claim/DAA/endcase/DAARelatePrint.jsp?compensateNo=" +compensateNo+"&printType="+printType,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}*/
//modify by lym 20060307 end--------------------------------------------------------------------------------
//modify by wangli update end 20050409


//modify by zhaozhuo add 20050406 start
//reason: 弹出不同打印页面
function printForm(filed,type){
  var registNo = fm.prpLclaimRegistNo.value;
  var claimNo =fm.prpLclaimClaimNo.value;
  var policyNo=fm.prpLclaimPolicyNo.value;
  var preCompensateNo=fm.prpLendcasepreCompensateNo.value;
  var compensateNo=fm.prpLendcasecompensateNo.value;

  if(type=="Regist"){ //1.机动车辆保险报案记录（代抄单）
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&RegistNo="+registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  //if(type=="Pilfer"){//2.出险（盗抢）证明
  //var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //return newWindow;
  //}
  if(type=="Cancelnotice"){//3.拒赔通知书 
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="HistoryFile"){//4.原始保单及出险时批单
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&PolicyNo="+policyNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="FileOnRisk"){//5.出险时保单
  var endDate = "";
  var endDateHour = "";
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&PolicyNo="+policyNo+"&EndDate=" + endDate +"&EndDateHour=" + endDateHour,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Canceltrans"){//6.拒赔案件报告书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="LossSimple"){//7.损失情况简易确认书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Loss"){//8.损失情况确认书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="ComponentList"){//9.零部件更换项目清单
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="RepairList"){//10.修理项目清单
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="RepairAdd"){//11.修理项目清单附表
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="PropList"){//12.财产损失确认书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  //if(type=="Compensate")//13.赔款计算书
  //{ var strCompensateNo;alert(compensateNo);
  //	for(var i=0;i<compensateNo.length/25;i++){
  //		strCompensateNo = compensateNo.substring((0+i*25),(25+i*25));
  //		alert(strCompensateNo);
  //	  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+strCompensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //	}
  //  return newWindow;
//}
  //if(type=="CompensateAdd")//14.赔款计算书附页
  //{var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+compensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //return newWindow;
//}
  if(type=="Drawnotice")//15.领取赔款通知书
  {//modify by kangzhen
  	compensateNo=fm.prpLcompensateCompensateNo.value
  	compensateNo = compensateNo.substring(0,25);
  	var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+compensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return newWindow;
  }
  if(type=="Prepay"){//16.预付赔款审批表
    if (preCompensateNo==""){
    alert("该案件无此表");
    return null;
    }
    else {
    var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&PreCompensateNo="+preCompensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return newWindow;
    }
}
  if(type=="Pressnotice"){//17.注销通知书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="PressnoticeEnd"){//17.结案催告通知书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Endcase"){//18.结案报告书
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="EndcaseAdd"){//19.结案报告书附页
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
}
function printForm1(filed,s,type){
  if(type=="Compensate"){
   var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+s,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
   return newWindow;
   }
  if(type=="CompensateAdd"){
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+s,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Drawnotice"){
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+s,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
}
//modify by zhaozhuo add 20050406 end