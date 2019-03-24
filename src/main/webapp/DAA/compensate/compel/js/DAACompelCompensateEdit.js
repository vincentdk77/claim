/*****************************************************************************
 * DESC       ：实赔的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-05-19
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
/**
 *@description 正在处理理算任务选择免赔率
 *@param       无
 *@return      打开选择免赔率页面
*/
function  choseDeductibleRate(){
   pageUrl="/claim/compensateBeforeEditList.do?"
         +"ClaimNo="+fm.prpLcompensateClaimNo.value
         +"&swfLogFlowID=" +fm.swfLogFlowID.value
         +"&swfLogLogNo="+fm.swfLogLogNo.value
         +"&riskCode="+fm.prpLcompensateRiskCode.value
         +"&editType=RECHOSE&nodeType=compe&status=0"
         +"&businessNo="+fm.prpLcompensateClaimNo.value
         +"&policyNo="+fm.prpLcompensatePolicyNo.value
         +"&CompensateNo="+fm.prpLcompensateCompensateNo.value
         +"&modelNo=1&rechoseFlag=1&nodeNo=12&compeCount=0" ;
 
    window.open(pageUrl,"","resizable=0,scrollbars,width=550,height=320"); 
	}
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
function changeCompensateFlag(flag)
{
 // fm.GenerateCompensateFlag.value=flag;
}
function GenerateCtextFlag(flag)
{
  fm.GenerateCompensateFlag.value=flag;
  /*
  var span1 = eval("spanPerson");
  var span2 = eval("spanCharge");
  var span3 = eval("spanlLoss");
  span1.style.display="none";
  span2.style.display="none";
  span3.style.display="none";
  span1.src="/claim/images/butCollapseBlue.gif";
  span2.src="/claim/images/butCollapseBlue.gif";
  span3.src="/claim/images/butCollapseBlue.gif";
  */
}
/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{
  
  //初始话下赔案类别的onchange事件
  fm.claimType.onchange();
  //默认展开特别约定
  var span = eval("spanEngage");
  span.style.display="";
  span.src="/claim/images/butExpandBlue.gif";

  calCompelSumPropAndPerson();
  
 //modify by luqin 2005-04-08 start
  //判断保费是否交付，否则弹出提示信息
  var payFee = parseInt(fm.prpLcompensatePayFee.value);
  var errorMessage = "";
  if(payFee==-1){
    errorMessage=errorMessage+"此保单保费未缴,请慎重处理！！！ \n";
  } else if(payFee==-2){
    errorMessage=errorMessage+"此保单已缴未缴全,请慎重处理！！！ \n";
  }

  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by luqin 2005-04-08 endt
  return true;
}
/**
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
 */
function submitDelete()
{
  fm.buttonDelete.disabled = true;
  fm.submit();
  return true;
}
/**
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
 */
function submitForm()
{
  fm.buttonApprove.disabled = true;
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
    var ChargeAmount=document.getElementsByName('prpLchargeChargeAmount');
    var ChargeCode=document.getElementsByName('prpLchargeChargeCode');
    var CheckDeptCode=document.getElementsByName('prpLchargeCheckDeptCode');
    for(var i=1;i<ChargeCode.length;i++){
        if(ChargeCode[i]!=null&&ChargeCode[i].value=='14'&&ChargeAmount[i]!=null&&ChargeAmount[i].value!=0){
           if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value==''){
              alert("当录入系统内代查勘费时,必须录入代查勘机构！！");
              return false;
           }else{
            if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value.length>=10){
              var CheckCode= CheckDeptCode[i].value.substring(6,10);
              if(CheckCode=='0000'){
                 alert("代查勘机构需要录入到部门！！");
                 return false;
              }
            }
           }
        }
    }
	var D3Count = 0;
	var D4Count = 0;
	var seatCount   = parseInt(fm.prpLcompensateSeatCount.value);
	var D3D4Count = 0;

    for(var i=0;i<fm.prpLpersonWoundGrade.options.length;i++){
     if(fm.prpLpersonWoundGrade.options[i].selected){
       if(fm.prpLpersonWoundGrade.options[i].value == ""){
         alert("是否涉及三者死亡不能为空！");
         fm.prpLpersonWoundGrade.focus();
         return;
       }
     }
   }
   for(var j=1;j<fm.prpLbillSerialNo.length;j++)
   {  
    if(fm.billType[j].value=="")
      {
         alert ("第"+j+"条修理发票类型 不能为空");
         return false ;
      }
        if(fm.billNo[j].value=="")
      {
         alert ("第"+j+"条修理发票号码 不能为空");
         return false ;
      }
   } 
    for(var j=1;j<fm.prpLchargeSerialNo.length;j++)
    {  
    	if(fm.prpLchargeKindCode[j].value=="")
      	{
	         alert ("第"+j+"条费用险别代码不能为空");
	         return false ;
      	}
        if(fm.prpLchargeKindName[j].value=="")
      	{
	         alert ("第"+j+"条费用险别名称不能为空");
	         return false ;
      	}
     }
     
     var propLength = getElementCount("propSerialNo");
     for(var j = 1;j<propLength;j++){
        if(fm.propFeeTypeName[j].value == ""){
             alert("强制保险财产信息，第"+j+"条损失明细不能为空");
             return false;
        }
        if(fm.propSumDefPay[j].value == ""){
             alert("强制保险财产信息，第"+j+"条核定赔偿不能为空");
             return false;
        }
        
     }
     var PersonLength = getElementCount("personMedicalSerialNo");
     for(var j = 1;j<PersonLength;j++){
        if(fm.prpLpersonMedicalDetailName[j].value == ""){
             alert("强制保险人伤信息，第"+j+"条费用代码和名称不能为空");
             return false;
        }
     }
     var nodutyLength = getElementCount("nodutyInsuredCompanyCode");
     for(var j = 1;j<nodutyLength;j++){
        if(fm.noneDutyLicenseNo[j].value == ""){
              alert("强制保险无责代赔信息，第"+j+"条车牌号码不能为空");
              return false;
        }
        if(fm.nodutyInsuredCompanyName[j].value == ""){
              alert("强制保险无责代赔信息，第"+j+"条无责方交强险保险公司不能为空");
              return false;
        }
        if(fm.dutyPercent[j].value == ""){
              alert("强制保险无责代赔信息，第"+j+"条责任比例不能为空");
              return false;
        }
        
     }
     var NoneInsItemLength = getElementCount("NoneInsItemCode");
     for(var j = 1;j<NoneInsItemLength;j++){
         if(fm.NoneInsItemName[j].value == ""){
              alert("强制保险无保险代赔信息，第"+j+"条损失项目不能为空");
              return false;
         }
     }
     
     if(propLength == 1 && PersonLength == 1 &&
        nodutyLength == 1 &&  NoneInsItemLength ==1){
              alert("至少录入一条赔偿记录");
              return false;
     }
     
     
   if(checkBeyondQuota()==false){
     return false;	
   }
     //新危险单位校验
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
   
   
  var errorMessage = "";
  //if(fm.prpLcompensateSumThisPaid.value < 0){
  //		errorMessage = errorMessage + "本次赔款金额不能小于预赔金额\n";
  //}
  
  fm.buttonSaveType.value = saveType;
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "理算报告不允许为空\n";
  }
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    errorMessage = errorMessage + "赔款合计不等于危险单位信息里的实赔金额";
  }

  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }


  if(!validateForm(fm,'Engage_Data,Charge_Data'))
  {
    return false;
  }


  fm.target="";
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){
  /*
     //非案终计算书进行实赔金额是否大于估损金额的判断add by qinyongli 2005-09-20
  	if(fm.prpLcompensateFinallyFlag[1].checked){
  	    var sumClaim = parseFloat(fm.prpLcompensateSumClaim.value);
  	    var sumPaidAll = parseFloat(fm.sumPaidAll.value);
  	    var sumThisPaid = parseFloat(fm.prpLcompensateSumThisPaid.value);
  	    sumPaidAll = sumPaidAll + sumThisPaid;
  	    if(sumPaidAll>sumClaim){
  	    	alert("实赔金额大于估损金额，不允许提交核赔，您可以暂存后处理！");
  	    	return false;
  	    }
        }
        */ 
  }
  /*
  var thridLicenseNos = document.getElementsByName("thridLicenseNo");
  var thridCompanys   = document.getElementsByName("thridCompany");
  for(var i = 1;i < thridLicenseNos.length;i++){
  	if(trim(thridLicenseNos[i].value) == ""){
  		alert("第三者车牌号不能为空!");
  		thridLicenseNos[i].focus();
  		return false;
  	}
  	if(trim(thridCompanys[i].value) == ""){
  		alert("第三者承保公司不能为空!");
  		thridCompanys[i].focus();
  		return false;
  	}
  }  */
  
  if(fm.claimType.value == "K"){
  	  var insureCarFlags = document.getElementsByName("insureCarFlag");
  		if(insureCarFlags.length < 3){
  			alert("赔案类别是互碰自赔时，必须录入三者车信息！");
  			return false;
  		}
  	  for(var i = 2;i < insureCarFlags.length;i++){
	  	if(trim(fm.prpLthirdPartyLicenseNo[i].value) == ""){
	  		alert("三者车号牌号码不能为空!");
	  		fm.prpLthirdPartyLicenseNo[i].focus();
	  		return false;
	  	}
	  	if((trim(fm.prpLthirdPartyInsureComName[i].value) == "" 
	  	|| trim(fm.prpLthirdPartyInsureComCode[i].value) == "")){
	  		alert("三者车承保公司不能为空!");
	  		fm.prpLthirdPartyLicenseNo[i].focus();
	  		return false;
	  	}
	  	if(trim(fm.prpLthirdPartyCarPolicyNo[i].value) == "" ){
	  		alert("三者车保单号不能为空!");
	  		fm.prpLthirdPartyCarPolicyNo[i].focus();
	  		return false;
	  	}
  	}  
  }
  
  if(checkSubmitButton()==false){
    return false;
  }
  
  if(checkChange() == false){
  	return false;
  }
  
  field.disabled = true;
  fm.submit();
  return true;
}


/**
 @author
 @description 增加一条赔付人员费用信息方法
 @param       无
 @return      无
 @see         UIMulLine#insertRow
 @see         UIMulLine#setRowRecordState
*/
function insertRowKind()
{
/*
  if(fm.PersonName.disabled==true)
  {
    errorMessage("请先添加一条人员信息!");
    return;
  }

	if(isEmpty(fm.PersonLossKindCodeU))
	{
		errorMessage("请先输入赔付人员险别!");
		fm.PersonLossKindCodeU.focus();
		return;
	}

  if (!isEmpty(fm.PersonLossOverAmount))
  {
    errorMessage(fm.PersonLossOverAmount.value);
    return;
  }
  */

  insertRow('Kind','Kind_Data')
  /*
  //设置行关键字（序号）
  setRowRecordState("PersonLoss","Kind");

  var findex;
  findex = fm.all("PersonLossClaimRate").length;
  fm.all("PersonLossClaimRate")[findex-1].value = "100.0000";
*/
}


 //modify by wangli remark start 20050409
 /**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinSave(){

   var policyNo = fm.prpLcompensatePolicyNo.value;
   var riskCode = fm.prpLcompensateRiskCode.value;
   var businessNo = fm.prpLcompensateClaimNo.value;
   var claimNo = fm.prpLcompensateClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=compe&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
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
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLcompensateClaimNo.value;

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

		var policyNo = fm.prpLcompensatePolicyNo.value;
		var claimNo = fm.prpLcompensateClaimNo.value;
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
  if(checkForm()==false)
  {
    return false;
  }

  fm.buttonApprove.disabled = true;
  fm.submit();
  return true;
}

//Modify By liubvo add end 2004-09-07

/**
 @author      liubvo
 @description 生成理算报告
 @param       无
 @return      无
 */
function generateCtext()
{

	if(checkForm()==false)
	{
		return false;
	}
  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.action="/claim/compensateGenerate.do";
  fm.target="fraCalculate";

  fm.submit();

  fm.action=oldAction;
  fm.target=oldTarget;

  return true;
}


/**
 @author      孙成刚
 @description 计算赔偿比例（改变实际价值时触发）
              若赔偿比例为空，则赔偿比例=保额/新车购置价 也就是  (保额/限额)/实际价值
 @param       field:触发域
 @return      boolean值，合法返回true,不合法返回false
 @see         UICommon.js#point、round
*/
function calLossClaimRate(field)
{

  var fieldname=field.name;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  var prpLlossDtoAmount = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);

  //alert("Amount:="+prpLlossDtoAmount);
	var ClaimRate = 0;

  if(isNaN(prpLlossDtoAmount))
    prpLlossDtoAmount = 0;

  if(isEmptyField(field))
  {
    field.value = prpLlossDtoAmount;
  }

//  if(prpLlossDtoAmount > parseFloat(field.value))
//  {
//    errorMessage("实际价值不能小于保险金额！");
//    field.focus();
//    field.select();
//    return false;
//  }

	ClaimRate = point(round(prpLlossDtoAmount/parseFloat(field.value)*100,2),2);
	if(ClaimRate>100)
		ClaimRate = 100;
  fm.all("prpLlossDtoClaimRate")[findex].value = ClaimRate;

  calRealpay(field);

  return true;
}


/**
 @author      任轶群
 @description 计算赔付标的中的赔偿金额（改变实际价值、核定损失、残值、责任比例时触发）
              计算赔款金额
              如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
              # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay(field)
{
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DeductibleRate; //免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔偿金额
  var temp;

  //取得当前的数据
  var fieldname=field.name;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DutyRate      = parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  /* add by liuning begin 20040220 */
  if(fm.prpLcompensateRiskCode.value=="DAS"&&fm.all("prpLlossDtoKindCode")[findex].value=="F")
  {
     DeductibleRate=10.0;
     fm.LossDeductibleRate.value = point(round(DeductibleRate,2),1)
  }
  /* add by liuning end 20040220 */
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  //modify begin zhanqiang 20031126
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
  if(isNaN(Amount))
    Amount = 0;
  //modify end zhanqiang 20031126
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;

  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
   * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
   */
  temp = (SumLoss - SumRest) * ClaimRate * DutyRate;
  Deductibletemp = temp * DeductibleRate;
//  if(Deductible > Deductibletemp)
//  {
//    Realpay = temp - Deductible;
//  }
//  else
//  {
   /* add by liuning begin 20040220 */

    if(fm.prpLcompensateRiskCode.value=="DAS"&&fm.all("prpLlossDtoKindCode")[findex].value=="F"&&Deductibletemp<100.0&&temp>0.0)
    {
       //if(Deductibletemp<100.0)
       //{
          Deductibletemp = 100.0;

          Realpay = temp - Deductibletemp;
          if(temp>0)
          {
           DeductibleRate = (Deductibletemp*100.0)/temp;
            fm.all("prpLlossDtoDeductibleRate")[findex].value = point(round(DeductibleRate,2),2)
          }
       //}
    }
    else
    {
    /* add by liuning end 20040220 */
    Realpay =  temp * (1 - DeductibleRate);
     /* add by liuning begin 20040220 */
    }
    /* add by liuning end 20040220 */
//  }
    //modify by lirj update begin 040323
    //reason:实赔处理，车上货物责任险、无过失责任险超限时系统的赔付计算不对
    //if(fm.LossKindCode.value=="B" && temp > Amount)
    if((fm.all("prpLlossDtoKindCode")[findex].value=="B" ||fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||fm.all("prpLlossDtoKindCode")[findex].value=="W")
        && temp > Amount)
    //modify by lirj update end 040323
    {
      Realpay = Amount * (1-DeductibleRate);
    }
    //modify begin zhanqiang 20031126
    if(Realpay > Amount &&  Amount > 0)
    {
      Realpay = Amount;
    }
    //modify end zhanqiang 20031126
    //modify by dengxh begin 20040904
    //reason:险别是车损或三者，并且损失明细为27扣免赔，则赔偿金额=-残值
    if((fm.all("prpLlossDtoKindCode")[findex].value=="A"||fm.all("prpLlossDtoKindCode")[findex].value=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27")
    {
      Realpay = SumRest*(-1);
    }
    //modify by dengxh end 20040904
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  
  //控制险别的赔偿金额不能超过保额
  
  
  
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();

  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

}


/**
 @author      孙成刚
 @description 分险别校验是否超过保单中的限额
 @param       KindCode:险别
 @param       PersonNo:人员序号
 @return      无
 */
function CheckLimitAmountByKindCode(KindCode,PersonNo)
{
  if(checkCodeInQuery())
  {
    return;
  }

  if (KindCode=="")
    return;

  //解除锁定,否则无法传入下一页
  fm.Sex.disabled = false;
  fm.PersonLossLicenseNo.disabled = false;

  //保存数据
  saveRecord("Loss");
  saveRowRecordToSingleTable("PersonLoss","Kind");

  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.target="fraSubmit"
  fm.action="/ddccallweb/DAA/lp/compensate/UILDAACheckLimitAmountSubmit.jsp?KindCode="+KindCode
                                                            +"&PersonNo="+PersonNo;

  fm.submit();

  fm.action=oldAction;
  fm.target=oldTarget;

  //清除数据
  clearRecord("Loss");
  clearRecord("PersonLoss");
  clearRowRecord("Kind");

  //load data
  loadRowRecord("PersonLoss","Kind","Kind_Data");

}

/**
 @author      任轶群
 @description 计算责任赔款合计、赔款合计、其它费用、实赔金额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calFund()
{
  //定义变量
  var dblSumDutyPaid = 0;  //责任赔款合计（=（赔款费用附加信息中）计入赔款金额+（赔付标的附加信息中）赔偿金额+（赔付人员附加信息中）赔付合计）
  var dblSumPaid     = 0;  //赔款合计（=责任赔款合计+其它费用）
  var dblSumPrePaid  = 0;  //预赔金额
  var dblSumNoDutyFee= 0;  //其它费用（（赔款费用附加信息中）费用金额 - 计入赔款金额）
  var dblSumThisPaid = 0;  //实赔金额（=责任赔款合计－已预付赔款）

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossRealPay    = 0;
  var personLossRealPay = 0;

  //计算责任赔款合计
  var i = 0;

  //1.赔款费用的计入赔款金额，以及其它费用
  var elements = getTableElements("Charge");
  //alert(fm.all("prpLchargeSumRealPay").length);
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[i].value); //记入赔款
    chargeAmount  = parseFloat(fm.all("prpLchargeChargeAmount")[i].value);  //费用

    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay);
    //alert(dblSumDutyPaid+"|"+dblSumNoDutyFee);
  }

  //2.赔付标的的赔偿金额
  //保存数据
  //?????????????????????
  //setCurrentRecord("Loss");
/*
  var lossData= getTableElements("lLoss");

  var intLossCount = lossData.length;
*/  
  var intLossCount = 0;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  var dblRealPayA = 0;    //车损险（A）总赔款金额
  var dblRealPayATotal = 0; //车损险（A）最终赔款金额，可能为空


try{  
  for( i = 1; i < fm.all("prpLlossDtoSumRealPay").length; i++ )
  {
    lossRealPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);

    if(isNaN(lossRealPay))
      lossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + lossRealPay;
    //alert(fm.all("prpLlossDtoKindCode")[i].value+"|"+fm.all("prpLlossDtoFeeTypeCode")[i].value);
    //modify by dengxh update begin 20040914
    if((fm.all("prpLlossDtoKindCode")[i].value=="A" || fm.all("prpLlossDtoKindCode")[i].value=="B")&& fm.all("prpLlossDtoFeeTypeCode")[i].value=='27')
    {
      dblRealPayAB = dblRealPayAB + lossRealPay;
    }
    //modify by dengxh update end 20040914
    //add by qinyongli 2006-01-12 begin  增加对车辆损失险金额的统计，用于减免赔额
    if(fm.all("prpLlossDtoKindCode")[i].value=="A" ){
        dblRealPayA = dblRealPayA + lossRealPay;
    }
    
  }
}catch(E)
  { }
//  var deductibleAall = parseFloat(fm.prpLDeductible.value);
  var deductibleAall = 0;
  if(isNaN(deductibleAall))
      deductibleAall = 0;
  //用车损险赔款减去免赔额

  dblRealPayATotal = dblRealPayA - deductibleAall;
  //加入域显示车损险最终赔款
  if(dblRealPayATotal>0){
      dblSumDutyPaid = dblSumDutyPaid - deductibleAall;//如果减去免赔后的赔款大于0，则在总赔款中减去免赔额；
//      fm.lastRealPay.value = dblRealPayATotal ;
  }else{
      dblSumDutyPaid = dblSumDutyPaid - dblRealPayA;//如果减去免赔后的赔款小于0,则在总赔款中减去赔款，即赔款为0；
//      fm.lastRealPay.value = 0 ;
  }
  //add by qinyongli 2006-01-12 end

  //3.赔付人员的赔付合计
  //保存数据
  //setCurrentRecord("PersonFeeLoss");
/*
  var personLossData= getTableElements("PersonFeeLoss");

  var intPersonLossCount = personLossData.length;

  for( i = 1; i < fm.all("prpLpersonLossSumRealPay").length; i++ )
  {
    personLossRealPay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);

    if(isNaN(personLossRealPay))
      personLossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + personLossRealPay;
  }
*/
  //得到预赔金额
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);
  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //计算赔款合计
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;

  //计算实赔金额
  dblSumThisPaid  = dblSumPaid - dblSumPrePaid;

  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
//  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumThisPaid,2),2);
  //alert(fm.prpLcompensateSumThisPaid.value);
  //modify by dengxh update begin 20040914
  fm.prpLcompensateSumSelfValue.value  = point(round(dblRealPayAB,2),2);
  //alert("--1-"+fm.prpLcompensateSumDutyPaid.value);
  //modify by dengxh update end 20040914
}


/**
 @author      孙成刚
 @description 修理天数修改时触发(只对车辆停驶险)
 @param       无
 @return      boolean值
*/
function changeLossQuantity(field)
{
  var fieldname=field.name; //域名
  var i = 0;
  var findex=0;       //定位序号

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  var LossQuantity = parseFloat(fm.all("prpLlossDtoLossQuantity")[findex].value);
  var UnitPrice    = parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].value);

  if(isNaN(LossQuantity))
    LossQuatity = 0;
  if(isNaN(UnitPrice))
    UnitPrice = 0;

  var Quantity   = parseInt(fm.all("prpLlossDtoLossQuantity")[findex].oldValue);
  var UnitAmount = parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].oldValue);

  if(LossQuantity > Quantity)
  {
    errorMessage("修理天数不能大于承保的天数("+Quantity+"天)!");
    fm.LossQuantity.focus();
    fm.LossQuantity.select();
    return false;
  }
  if(UnitPrice > UnitAmount)
  {
    errorMessage("单位赔偿金额不能大于承保的单位限额("+UnitAmount+")!");
    fm.UnitPrice.focus();
    fm.UnitPrice.select();
    return false;
  }

  fm.all("prpLlossDtoSumLoss")[findex].value = point(round(LossQuantity * UnitPrice,2),2);
  fm.all("prpLlossDtoSumLoss")[findex].onchange();

  return true;
}

//

/**
 @author      任轶群
 @description 计算赔付标的和人员核损金额之和
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calLoss()
{
  //定义变量
  var dblSumLoss = 0;
  var LossSumLoss    = 0;
  var PersonLossSumLoss = 0;
  var i = 0;

  //赔付标的的核损金额
  //保存数据
  //setCurrentRecord("Loss");

  //var lossData= getPageData("Loss");

try{
  for( i = 1; i < fm.all("prpLlossDtoSumLoss").length; i++ )
  {
    LossSumLoss = parseFloat(fm.all("prpLlossDtoSumLoss")[i].value);

    if(isNaN(LossSumLoss))
      LossSumLoss = 0;

    dblSumLoss = dblSumLoss + LossSumLoss;
  }
  	}catch(E){}

  //赔付人员的核损金额
  //保存数据
  //setCurrentRowRecord("Kind");

  //var kindData = getRowData('Kind');
  //prpLpersonLossSumLoss
  for( i = 1; i < fm.all("prpLpersonLossSumLoss").length; i++ )
  {
    PersonLossSumLoss = parseFloat(fm.all("prpLpersonLossSumLoss")[i].value);

    if(isNaN(PersonLossSumLoss))
      PersonLossSumLoss = 0

    dblSumLoss = dblSumLoss + PersonLossSumLoss;
  }

  fm.prpLcompensateSumLoss.value  = point(round(dblSumLoss,2),2);
}

function checkInputPower(field)
{
  var fieldname=field.name; //域名
  var i = 0;
  var findex=0;       //定位序号

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  //
 	if(fm.all("prpLlossDtoKindCode")[findex].value=="B" && fm.all("prpLlossDtoFeeTypeCode")[findex].value!="27")
 	{
 	    alert("B险别不允许录入残值！");
      setReadonlyOfElementOfLoss(fm.all("prpLlossDtoSumRest")[findex]);
 	    //fm.all("prpLlossDtoSumRest")[findex].readOnly=true;
 	    fm.all("prpLlossDtoSumRest")[findex].value="0.00";
 	}
}


/**
 @author      孙成刚
 @description 使一个输入域设置为只读
 @param       iElement: 域
 @return      无
 */
function setReadonlyOfElementOfLoss(iElement)
{
  if(iElement.type=="select-one")
  {
    iElement.disabled = true;
  }
  else if (iElement.type=="text")
  {
   //modify by dengxh begin 20040904
   /*if(iElement.onchange!=null)
    {
      iElement.oldOnchange = getFunctionName(iElement.onchange.toString());
    }
    iElement.onchange = null;
   */
   //modify by dengxh end 20040904
   /*
    if(iElement.onblur!=null)
    {
      iElement.oldOnblur = getFunctionName(iElement.onblur.toString());
    }
    iElement.onblur = null;

    if(iElement.ondblclick!=null)
    {
      iElement.oldOndblclick = getFunctionName(iElement.ondblclick.toString());
    }
    iElement.ondblclick = null;

    if(iElement.onkeyup!=null)
    {
      iElement.oldOnkeyup = getFunctionName(iElement.onkeyup.toString());
    }
    iElement.onkeyup = null;

    if(iElement.onfocus!=null)
    {
      iElement.oldOnfocus = getFunctionName(iElement.onfocus.toString());
    }
    */
    iElement.onfocus = null;
    iElement.readOnly = true;
    iElement.className = "readonly";
  }
}


/**
 @author      孙成刚
 @description 使一个输入域设置为可输入
 @param       iElement: 域
 @return      无
 */
function undoSetReadonlyOfElementOfLoss(iElement)
{
  if(iElement.type=="select-one")
  {
    iElement.disabled = false;
  }
  else
  {
    iElement.readOnly = false;
    iElement.className = 'common';

    //modify by dengxh begin 20040904
/*
    if(iElement.oldOnchange!=null)
      iElement.onchange = mainOnchangeOfLoss;
*/
    //modify by dengxh end 20040904
/*
    if(iElement.oldOndblclick!=null)
      iElement.ondblclick = mainOndblclickOfLoss;

    if(iElement.oldOnkeyup!=null)
      iElement.onkeyup = mainOnkeyupOfLoss;
    if(iElement.oldOnblur!=null)
      iElement.onblur = mainOnblurOfLoss;
  */
  }
}







//离开域时的数字校验
function checkInteger(field,MinValue,MaxValue)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  var desc   = field.description;
  //如果description属性不存在，则用name属性
  if(desc==null)
    desc = field.name;

  MinValue = parseInt(MinValue,10);
  if(isNaN(MinValue))
    MinValue = MIN_INTEGER;

  MaxValue = parseInt(MaxValue,10);
  if(isNaN(MaxValue))
    MaxValue = MAX_INTEGER;
  var value = parseInt(strValue,10);
  if(isNaN(value) || value>MaxValue || value<MinValue)
  {
    errorMessage("请输入合法的" + desc +"\n类型为数字(integer),最小值为" + MinValue + ",最大值为" +MaxValue);
    field.focus();
    field.select();
    return false;
  }
  return true;
}

/**
 @author      renyiqun
 @description 校验计入赔款金额不能超过费用金额
 @param       Field: 触发域
 @return      boolean: 合法为true,否则为false
 @see         UICommon.js#isEmpty
 */
function checkChargeAmount(Field)
{
  var fieldname=Field.name; //域名
  var i = 0;
  var findex=0;             //定位序号
  var ChargeAmount = 0;			//费用金额
  var ChargeRealPay = 0;		//计入赔款金额

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }
 if( fieldname=="prpLchargeChargeReport")
 {
 		var chargeCode = fm.prpLchargeChargeCode[findex].value; //费用类别
 		var chargeAmount = fm.prpLchargeChargeAmount[findex].value; //费用类别
 	  if(chargeCode=='03'){
  	  	fm.all("prpLchargeSumRealPay")[findex].value =parseFloat(chargeAmount);
  	}else{
  	  	fm.all("prpLchargeSumRealPay")[findex].value = 0;
  	}
    calFund();
    //modify by lirj update end 040508
  	if( !(isEmptyField(Field)) && !(isEmptyField(fm.all("prpLchargeSumRealPay")[findex])) )
  	{
  		ChargeAmount  = parseFloat(chargeAmount);
  		ChargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[findex].value);
  	}
 	
 }
 else  if( fieldname=="prpLchargeChargeAmount")
  {
  	//modify by lirj update begin 040508
  	//reason:赔款费用中计入赔款金额自动带出且为只读
  	var chargeCode = fm.prpLchargeChargeCode[findex].value; //费用类别
  	//modify by lirj update begin 040508
  	//reason:赔款费用中计入赔款金额自动带出且为只读
  	////ChargeCode="03"时表示施救费
  	if(chargeCode=='03'){
  	  	fm.all("prpLchargeSumRealPay")[findex].value = Field.value;
  	}else{
  	  	fm.all("prpLchargeSumRealPay")[findex].value = 0;
  	}
    calFund();
    //modify by lirj update end 040508
  	if( !(isEmptyField(Field)) && !(isEmptyField(fm.all("prpLchargeSumRealPay")[findex])) )
  	{
  		ChargeAmount  = parseFloat(Field.value);
  		ChargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[findex].value);
  	}
  }
  else if( fieldname=="prpLchargeSumRealPay")
  {
  	if( !(isEmptyField(fm.all("prpLchargeChargeAmount")[findex])) && !(isEmptyField(Field)) )
  	{
  		ChargeAmount  = parseFloat(fm.all("prpLchargeChargeAmount")[findex].value);
  		ChargeRealPay = parseFloat(Field.value);
  	}
  }

  if( ChargeAmount < ChargeRealPay )
  {
  	if( fieldname=="prpLchargeChargeAmount")
  	{
    	errorMessage("计入赔款金额不能超过费用金额！");
    	Field.focus();
  		Field.select();
    	return false;
    }
    else if( fieldname=="prpLchargeSumRealPay" )
    {
    	errorMessage("计入赔款金额不能超过费用金额！");
    	fm.all("prpLchargeChargeAmount")[findex].focus();
  		fm.all("prpLchargeChargeAmount")[findex].select();
    	return false;
    }
  }

  //车身划痕损失险最高费用为5000
  if( fm.all("prpLchargeKindCode")[findex].value == "L" && parseFloat(fm.all("prpLchargeChargeAmount")[findex].value) > 5000)
    {
    	errorMessage("车身划痕损失险最高赔款费用为5000元！");
    	fm.all("prpLchargeChargeAmount")[findex].focus();
  		fm.all("prpLchargeChargeAmount")[findex].select();
    	return false;
    }
    
  return true;
}

/**
 @author      任轶群
 @description 同险别的免赔率，责任比例要相等
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function checkKindCode(Field){

  var fieldname=Field.name; //域名
  var i = 0;
  var findex=0;             //定位序号
  var ChargeAmount = 0;			//费用金额
  var ChargeRealPay = 0;		//计入赔款金额
  
  var findFlag=0;
  
  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }
  
  //取得当前险别代码 
    var strValue = fm.prpLpersonLossKindCode[findex].value;
    if(strValue=="")
      return;
  //判断选择的险别是否为出险日期当时生效的险别
     for (var j=0;j<damageKind.length;j++)
     {
        if(damageKind[j]==strValue)
        {
            findFlag = 1;
            break;
        }
     }
     if(findFlag==0)
     {
         alert("您选择的险别不是出险日期时的险别,请重新进行选择");
         fm.prpLpersonLossKindCode[findex].value = "";
         return false;
     }
  
  //先要计算免赔率,责任比率

  //校验录入险别
  if(Field.name.indexOf("prpLpersonLossKind")>-1)
  {
    if(fm.all("prpLpersonLossKindCode")[findex].value!="" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="B" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="B1" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="D3" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="D4" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="Y")
    {
      alert("人员赔付只允许录入第三者责任、驾驶员责任、乘客责任、交通事故精神损害！");
      fm.all("prpLpersonLossKindCode")[findex].value = "";
      fm.all("prpLpersonLossKindName")[findex].value = "";
      Field.focus();
    }
  }

  var kindCode = "";
  for( i = 0; i < fm.all("prpLpersonLossKindCode").length; i++ )
  {
    kindCode = fm.all("prpLpersonLossKindCode")[i].value;
    if(kindCode == fm.all("prpLpersonLossKindCode")[findex].value){
      //只修改本人的免赔率
      if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("prpLpersonLossSerialNo")[findex].value){
        fm.all("prpLpersonLossIndemnityDutyRate")[i].value=fm.all("prpLpersonLossIndemnityDutyRate")[findex].value;
        fm.all("prpLpersonLossDeductibleRate")[i].value=fm.all("prpLpersonLossDeductibleRate")[findex].value;
      }
    }
  }
}




/**
 @author      任轶群
 @description 计算赔付人员的赔款金额(改变责任比例时造成的赔款金额的改变)
              涉及所有当前行的费用信息
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay2(field)
{
  alert("calRealpay2");
  var i = 0;
  var findex=0;       //定位序号
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DeductibleRate; //免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔付金额
  var temp;

  var fieldname=field.name; //域名

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

 	//if(fm.all("prpLlossDtoKindCode")[findex].value=="B" && fm.all("prpLlossDtoFeeTypeCode")[findex].value!="27")
 	var findex1 = 0;
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++) {
     	alert("44444444444");
    if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
        findex1=i;
        break;
      }
  }
  DutyRate = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[findex1].value);
  DeductibleRate = parseFloat(fm.all("prpLpersonLossDeductibleRate")[findex1].value);
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  //给变量赋值
  SumLoss        = 0;
  SumRest        = 0;     //
  ClaimRate      = 0;
  Deductible     = 0;     //
  Deductibletemp = 0;
  Realpay        = 0;
  temp           = 0;

  for(i=1;i<fm.all("prpLpersonLossSumRealPay").length;i++)
  {
    if(fm.all("personLossSerialNo")[i].value==fm.all("prpLpersonLossSerialNo")[findex].value){

    SumLoss   = parseFloat(fm.all("prpLpersonLossSumLoss")[i].value);
    ClaimRate = parseFloat(fm.all("prpLpersonLossClaimRate")[i].value);

    if(isNaN(SumLoss))
      SumLoss = 0;
    if(isNaN(ClaimRate))
      ClaimRate = 0;
    else
      ClaimRate = ClaimRate/100;

    /*计算赔款金额
     * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
     * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
     */
    temp = (SumLoss - SumRest) * ClaimRate * DutyRate;  //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例
    Deductibletemp = temp * DeductibleRate;  //免赔= temp * 免赔率

//    if(Deductible > Deductibletemp)
//    {
//      Realpay = temp  - Deductible;
//    }
//    else
//    {
      Realpay =  temp * (1 - DeductibleRate);
//    }

      fm.all("prpLpersonLossSumRealPay")[i].value = point(round(Realpay,2),2);
      }
  }

  //计算赔付人员中的赔付合计
  calSumRealpay(field);

  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;
*/
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);

}

/**
 @author      任轶群
 @description 计算赔付人员中的赔付合计(改变单价、数目、赔偿比例、
              责任比例时造成的赔款金额的改变)
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calSumRealpay(field)
{

  var findex=0;       //定位序号
  var i = 0;
  var Realpay;          //赔款金额
  var SumRealpay;       //赔付合计

  var fieldname=field.name; //域名

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  //给变量赋值
  Realpay    = 0;
  SumRealpay = 0;

  //计算赔付合计
  for(i=1;i<fm.all("prpLpersonLossSumRealPay").length;i++)
  {
    if(fm.all("personLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
      Realpay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);
      if(isNaN(Realpay))
        Realpay = 0;

      SumRealpay = SumRealpay + Realpay;
    }
  }
 	var findex1 = 0;
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++) {
    if(getElementCount("personLossSerialNo")>1)
    {
       if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
          findex1=i;
          break;
       }
    }
  }
  //将用来显示的赔付合计设置到界面上
  fm.all("prpLpersonLossSumRealPay1")[findex1].value =  point(round(SumRealpay,2),2);
}


/**
 @author      任轶群
 @description 计算赔付人员的核损金额(改变单价和数目时造成的核损金额的改变)
 @param       Field: 触发域
 @return      无
 @see         UICommon.js#point、round
*/
function calSumLoss(Field)
{

  var fieldname=Field.name; //域名
  var i = 0;
  var findex=0;             //定位序号
  var SumLoss;              //核损金额
  var UnitPrice;            //单价
  var Quantity;             //数量

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }

  //给变量赋值
  UnitPrice = parseFloat(fm.all("prpLpersonLossUnitAmount")[findex].value);
  Quantity  = parseFloat(fm.all("prpLpersonLossLossQuantity")[findex].value);
  SumLoss   = 0;

  //计算核损金额
  if(isNaN(UnitPrice))
    UnitPrice = 0;
  if(isNaN(Quantity))
    Quantity = 0;

  SumLoss = UnitPrice * Quantity;
  fm.all("prpLpersonLossSumLoss")[findex].value = point(round(SumLoss,2),2);

  //计算赔付人员的赔款金额
  calRealpay1(Field);

  //计算赔付标的和人员核损金额之和
  calLoss();
}

/**
 @author      任轶群
 @description 计算赔付人员的赔款金额(改变单价、数目和赔偿比例时造成的赔款金额的改变)
              只涉及触发域所对应的当前行的费用信息
 @param       Field: 触发域
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay1(Field)
{
  var fieldname=Field.name; //域名
  var i = 0;
  var findex=0;       //定位序号
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DeductibleRate; //免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔付金额
  var temp;

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }


  //给变量赋值
  SumLoss        = parseFloat(fm.all("prpLpersonLossSumLoss")[findex].value);
  SumRest        = 0;    //
  ClaimRate      = parseFloat(fm.all("prpLpersonLossClaimRate")[findex].value);
  DeductibleRate = 0;
  Deductible     = 0;   //
  Deductibletemp = 0;
  DutyRate       = 0;
  Realpay        = 0;
  temp           = 0;
  var findex1 = 0;
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++) {
  //alert("--prpLpersonLossSerialNo-personLossSerialNo-"+fm.all("prpLpersonLossSerialNo")[i].value+"|"+fm.all("personLossSerialNo")[findex].value+"|"+fm.all("prpLpersonLossIndemnityDutyRate").length);
    if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
        findex1=i;
        break;
      }
  }
  DutyRate       = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[findex1].value);
  DeductibleRate = parseFloat(fm.all("prpLpersonLossDeductibleRate")[findex1].value);
//alert("--DutyRate-DeductibleRate-"+DutyRate+"|"+DeductibleRate);
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;

  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
   * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
   */
  temp = (SumLoss - SumRest) * ClaimRate * DutyRate; //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例
  Deductibletemp = temp * DeductibleRate; //免赔= temp * 免赔率

//  if(Deductible > Deductibletemp)
//  {
//    Realpay = temp - Deductible;
//  }
//  else
//  {
    Realpay =  temp * (1 - DeductibleRate);
//  }
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);

  //计算赔付人员中的赔付合计
  calSumRealpay(Field);

  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;

  //分险别校验是否超过保单中的限额
  CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);
*/
}


/**
 @author      孙成刚
 @description 赔付金额修改时触发
 @param       Field:触发域
 @return      boolean值
*/
function changePersonLossRealpay(Field)
{
 	var fieldname=Field.name;
  var i = 0;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }

  var PersonLossSumLoss = fm.all("prpLpersonLossSumLoss")[findex].value;
  var PersonLossRealpay = parseFloat(Field.value);

  if(isNaN(PersonLossSumLoss))
    PersonLossSumLoss = 0;
  if(isNaN(PersonLossRealpay))
    PersonLossRealpay = 0;

  if(PersonLossRealpay > PersonLossSumLoss)
  {
    errorMessage("赔付金额不能大于核损金额!");
    Field.focus();
    Field.select();
    return false;
  }

  //计算赔付人员中的赔付合计
  calSumRealpay(Field);

  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();

  return true;
}

/**
 @author      孙成刚
 @description 改变理赔类型时校验
 @param       Field:触发域
 @return      boolean型，合法返回true,不合法返回false
 */
function changeLFlag(Field)
{
  if(Field.value=='D')
  {
    errorMessage("非国内货运险赔款计算书理赔类型不能为D!");
    Field.focus();
    return false;
  }
  return true;
}



/**
 @author      liubvo //页面初始话的时候用
 @description 计算赔付人员中的赔付合计(改变单价、数目、赔偿比例、
              责任比例时造成的赔款金额的改变)
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calSumRealpayInit()
{
  var i = 0;
  var Realpay=0;          //赔款金额
  var SumRealpay =0;       //赔付合计
  //定位
  for(i=0;i<fm.all("prpLpersonLossSumRealPay1").length;i++)
  {
    //给变量赋值
    Realpay    = 0;
    SumRealpay = 0;

    //计算赔付合计
    for(j=0;j<fm.all("prpLpersonLossSumRealPay").length;j++)
    {
      if(fm.all("personLossSerialNo")[j].value==fm.all("prpLpersonLossSerialNo")[i].value){
        Realpay = parseFloat(fm.all("prpLpersonLossSumRealPay")[j].value);
        if(isNaN(Realpay))
          Realpay = 0;

        SumRealpay = SumRealpay + Realpay;
      }
    }

    //将用来显示的赔付合计设置到界面上
    fm.all("prpLpersonLossSumRealPay1")[i].value =  point(round(SumRealpay,2),2);
    //alert(i+"|"+fm.all("prpLpersonLossSumRealPay1")[i].value);
  }
  return true;
}

/**
 @author      孙成刚
 @description 分险别校验是否超过保单中的限额
 @param       KindCode:险别
 @param       PersonNo:人员序号
 @return      无
 */
function getDeductibleRate(Field,Type)
{
  var index = 0;
  /*
  if(checkCodeInQuery())
  {
    return;
  }
  */
  var KindCode = "";

  if(Type=="lLoss")   //赔付标的
  {
    index = getElementOrder(Field)-1;
    KindCode = fm.all("prpLlossDtoKindCode")[index].value;
  } else if(Type=="Charge") {
    index = getElementOrder(Field)-1;
    KindCode = fm.prpLchargeKindCode[index].value;
  } else {
    index = getElementOrder(Field)-1;
    KindCode = fm.prpLpersonLossKindCode[index].value;
  }

  if (KindCode=="")
    return;

  var oldTarget = fm.target;
  var oldAction = fm.action;

  fm.target="fraSubmit";
  fm.action="/claim/DAA/compensate/sunny/DAAGetDeductibleRateSubmit.jsp?KindCode="+KindCode+"&Type="+Type + "&Index=" + index;
  fm.submit();
  fm.target=oldTarget;
  fm.action=oldAction;

}


/**
 @author      孙成刚
 @description 险别是车损或三者，并且损失明细为27扣免赔时，允许录入残值，因为赔偿金额=-残值
 @param       KindCode:险别
 @param       PersonNo:人员序号
 @return      无
 */
function changeLossSumRestShowStyle(Field) //赔付标的信息中若险别为“三者险”则置残值为空，且只读
{
  var index1 = 0;
  index1 = getElementOrder(Field)-1;
  //if(fm.LossKindCode.value=="B")
  if(fm.prpLlossDtoKindCode[index1].value!="M")
  {
    fm.button_Loss_Refresh.disabled = true;
  }
  else if (fm.prpLlossDtoKindCode[index1].value=="M")
  {
    fm.button_Loss_Refresh.disabled = false;
  }
  if(fm.prpLlossDtoKindCode[index1].value=="B" && fm.prpLlossDtoFeeTypeCode[index1].value!="27")
  {
      setReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);
      fm.prpLlossDtoSumRest[index1].value="";
  }
  else
  {
   undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);
  }
}

/* add by liuning begin 20040222 */
function changeLossClaimRate(Field) //赔付标的信息中若险别为“车损险”则置赔付比例为（A险别的保额除以新车购置价），且赔付比例只读
{
  var index1 = 0;
  index1 = getElementOrder(Field)-1;
  if(fm.prpLlossDtoKindCode[index1].value=="A")
  {
    var escapeFlag = fm.prpLcompensateEscapeFlag.value;
    if(!(escapeFlag.length>1 && escapeFlag.substring(1,2)=="Y"))
    {
     var purchasePrice = parseFloat(fm.prpLcompensatePurchasePrice.value);
     var AKindCodeAmount = parseFloat(fm.prpLlossDtoAmount[index1].value);
     if(purchasePrice>0&&purchasePrice!=AKindCodeAmount)
     {
       var lossClaimRate = AKindCodeAmount*100.00/purchasePrice;
       fm.prpLlossDtoClaimRate[index1].value = point(round(lossClaimRate,2),2);
         setReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
     }
    }
  }
  else
  {
  	//modify by dengxh update begin 20040914
  	if(fm.prpLlossDtoFeeTypeCode[index1].value!="27" && fm.prpLlossDtoKindCode[index1].value !="M")
      undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
    //modify by dengxh update end 20040914
  }
}
/* add by liuning end 20040222 */


//modify by dengxh begin 20040902
//修改自负额的处理
//modify by lirj update begin 040520
//reason:增加自负额
function getValue(Field)
{
  var index1 = 0;
  index1 = getElementOrder(Field)-1;
  //if(fm.LossKindCode.value=="A"&&fm.LossFeeTypeCode.value=="27")
  if((fm.prpLlossDtoKindCode[index1].value=="A"||fm.prpLlossDtoKindCode[index1].value=="B")&&fm.prpLlossDtoFeeTypeCode[index1].value=="27")
  {
     //setCurrentRecord("Loss");
     //var lossData = getPageData("Loss")
     //var intLossCount = lossData.length;
     var countA = 0;
     var countB = 0;
     for(var i = 0; i < fm.all("prpLlossDtoKindCode").length; i++ )
     {
       if(fm.all("prpLlossDtoFeeTypeCode")[i].value=='27')
       {
       	 if(fm.all("prpLlossDtoKindCode")[i].value=="A")
         {
          	countA++;
          	if (countA>=2)
            {
              errorMessage("赔付标的中每个险别下的扣免赔只能录入一次!");
              //showPageOnly("LossImg",spanLoss);
              return false;
            }
         }
         else if(fm.all("prpLlossDtoKindCode")[i].value=="B")
         {
            countB++;
            if (countB>=2)
            {
              errorMessage("赔付标的中每个险别下的扣免赔只能录入一次!");
              //showPageOnly("LossImg",spanLoss);
              return false;
            }
         }
       }
     }
     if (countA<2 && countB<2)
     {
       //setReadonlyOfElementOfLoss(fm.LossSumRest); //放开残值，可手工输入。
       setReadonlyOfElementOfLoss(fm.prpLlossDtoItemValue[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoSumLoss[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoIndemnityDutyRate[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoLossQuantity[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoDeductibleRate[index1]);
       undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);

       var KindCode = "";
       KindCode = fm.prpLlossDtoKindCode[index1].value;

       var oldTarget = fm.target;
       var oldAction = fm.action;

      fm.target="fraSubmit"
      fm.action="/claim/DAA/compensate/DAAGetValueSubmit.jsp?KindCode="+KindCode+"&PolicyNo="+fm.prpLcompensatePolicyNo.value+ "&Index=" + index1;
      fm.submit();

       fm.target=oldTarget;
       fm.action=oldAction;
     }
  }
  else
  {
  	 undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);
     undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoItemValue[index1]);
     undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoSumLoss[index1]);
     //undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoIndemnityDutyRate[index1]);
     //modify by dengxh begin 20040902
     //undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoLossQuantity[index1]);
     //undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
     //undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoDeductibleRate[index1]);
     if(fm.prpLlossDtoKindCode[index1].value=='T')
     {
       undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoLossQuantity[index1]);
       undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoUnitPrice[index1]);
     }
     else
     {
       setReadonlyOfElementOfLoss(fm.prpLlossDtoLossQuantity[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoUnitPrice[index1]);
     }

     if(fm.prpLlossDtoKindCode[index1].value=="B" && fm.prpLlossDtoFeeTypeCode[index1].value!="27")
     {
       setReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);
     }
     if(fm.prpLlossDtoKindCode[index1].value=="A"&&fm.prpLcompensatePurchasePrice.value!=fm.prpLlossDtoAmount[index1].value)
     {
       setReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
     }

    //modify by dengxh update begin  20040914
    if(fm.prpLlossDtoKindCode[index1].value!="M")
    {
      fm.button_Loss_Refresh.disabled = true;
    }
    if(fm.prpLlossDtoKindCode[index1].value=="M")
    {
        fm.button_Loss_Refresh.disabled = false;
        setReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoItemValue[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoSumLoss[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoIndemnityDutyRate[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoLossQuantity[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoDeductibleRate[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoFeeTypeCode[index1]);
        setReadonlyOfElementOfLoss(fm.prpLlossDtoFeeTypeName[index1]);
    }
    //modify by dengxh update end  20040914
     //modify by dengxh end 20040902
  }
}


function checkLossDeductibleRate(Field)
{
    if(parseFloat(Field.value)<parseFloat(Field.oldValue))
    {
      alert("免赔率只能上调不允许下调！");
      Field.value = Field.oldValue;
      calRealpay(Field);
      Field.focus();
      return false;
    }
  return true;
}
/**
 @author      任轶群
 @description 汇总
 @param       无
 @return      无
 */
function showLossCollect()
{
  //保存当前记录
  //setCurrentRecord("Loss");
  var newWindow = window.open("/claim/DAA/compensate/DAALossCollect.jsp","new","width=500,height=220,top=200,left=200,scrollbars=yes");
  //newWindow.focus();
  //return newWindow;
}

/**
 @author      任轶群
 @description 按险别名称，项目名称汇总信息
 @param       无
 @return      返回一个包含险别名称，项目名称，核损金额，赔偿金额的数组
 */
function getLoss()
{
  var arrayLoss;
  var arrayLossCollect = new Array();
  var i = 0
  var j = 0;
  var existFlag   = false;
  for( i = 1; i < fm.all("lossDtoSerialNo").length; i++ )
  {
    arrayLoss = new Array();

    arrayLoss["LossKindName"] = fm.prpLlossDtoKindName[i].value;
    arrayLoss["LossName"]     = fm.prpLlossDtoLossName[i].value;
    arrayLoss["LossSumLoss"]  = parseFloat(fm.prpLlossDtoSumLoss[i].value);
    arrayLoss["LossRealPay"]  = parseFloat(fm.prpLlossDtoSumRealPay[i].value);

    if(isNaN(arrayLoss["LossSumLoss"]))
     arrayLoss["LossSumLoss"] = 0;
    if(isNaN(arrayLoss["LossRealPay"]))
     arrayLoss["LossRealPay"] = 0;
    //按险别名称，项目名称汇总信息
    for(j=0;j<arrayLossCollect.length;j++)
    {
      if(arrayLossCollect[j]["LossKindName"]==arrayLoss["LossKindName"]
         && arrayLossCollect[j]["LossName"]==arrayLoss["LossName"])
      {
        existFlag = true;
        break;
      }
      else
      {
         existFlag = false;
      }
    }

    if(!existFlag)
    {
      arrayLossCollect[j] = arrayLoss;  //一个汇总项
    }
    else
    {
      arrayLossCollect[j]["LossSumLoss"]  = arrayLossCollect[j]["LossSumLoss"] + arrayLoss["LossSumLoss"];
      arrayLossCollect[j]["LossRealPay"]  = arrayLossCollect[j]["LossRealPay"] + arrayLoss["LossRealPay"];
    }
  }
  return arrayLossCollect;
}

/**
 @author      孙成刚
 @description 刷新赔付标的中不计免赔险别的不计免赔值
 @param       无
 @return      无
 */
function refreshLoss(Field)
{
  var index = 0;
  index = getElementOrder(Field)-1;

  var i = 0;
  var j = 0;
  var Deductible = 0;
  var LossDeductibleRate = 0;
  var PersonLossDeductibleRate = 0;
  var sumLossRealPay = 0;
  var strFlag = "";
  var bFind = false;

  var strRiskCode = fm.prpLcompensateRiskCode.value;
  var LossDeductibleRate1 = 0;
  var PersonLossDeductibleRate1 = 0;
  var strIsSafeLoad = fm.prpLcompensateDeductCond.value;
  strIsSafeLoad = strIsSafeLoad.substring(2,3); //取违反安全装载特殊免赔条件

  //查找是否录入了不计免赔险
  for(i=0;i<fm.all("prpLlossDtoSerialNo").length;i++)
  {
    if(fm.prpLlossDtoKindCode[i].value=='M')
    {
      bFind = true;
      break;
    }
  }


  //没有录入不计免赔险则无需刷新
  if (bFind==false)
    return;

  var oldAction = fm.action;
  var oldTarget = fm.target;
  fm.action="/claim/DAA/compensate/DAAGetDeductibleSubmit.jsp?PolicyNo="
            +fm.prpLcompensatePolicyNo.value+"&DamageStartDate="+fm.DamageStartDate.value + "&Index=" + index;
  fm.target="fraCalculate";

  fm.submit();

  fm.action=oldAction;
  fm.target=oldTarget;
}



/**
 @author      任轶群
 @description 计算赔付标的中的赔偿金额（改变实际价值、核定损失、残值、责任比例时触发）
              计算赔款金额
              如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
              # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpayForSunny(field)
{
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DutyDeductibleRate; //事故责任免赔率
  var DeductibleRate; //免赔率
  var DriverDeductibleRate;//驾驶员免赔率
  var mainKindCode;   //主险代码
  var DeductibleRateOfMainKind;//主险的绝对免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔偿金额
  var temp;
  var unitPrice;
  //取得当前的数据
  var fieldname=field.name;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DutyRate      = parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
  DutyDeductibleRate= parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[findex].value);
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  DriverDeductibleRate= parseFloat(fm.all("prpLlossDtoDriverDeductibleRate")[findex].value);
  unitPrice      =parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].value);
  /* add by liuning begin 20040220 */
  if(fm.prpLcompensateRiskCode.value=="DAS"&&fm.all("prpLlossDtoKindCode")[findex].value=="F")
  {
     DeductibleRate=10.0;
     fm.LossDeductibleRate.value = point(round(DeductibleRate,2),1)
  }
  /* add by liuning end 20040220 */
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  //modify begin zhanqiang 20031126
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
  if(isNaN(Amount))
    Amount = 0;
  //modify end zhanqiang 20031126
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DutyDeductibleRate))
    DutyDeductibleRate = 0;
  else
    DutyDeductibleRate = DutyDeductibleRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;

  if(isNaN(DriverDeductibleRate))
    DriverDeductibleRate = 0;
  else
    DriverDeductibleRate = DriverDeductibleRate/100;

  if(isNaN(Deductible))
    Deductible = 0;

   if(isNaN(unitPrice))
    unitPrice = 0;


  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
   * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
   */
  temp = (SumLoss - SumRest) * ClaimRate * DutyRate;
  if(fm.all("prpLlossDtoKindCode")[findex].value=="C"||fm.all("prpLlossDtoKindCode")[findex].value=="L")
  {
      temp = (SumLoss - SumRest) * ClaimRate;
  }
   
  Deductibletemp = temp * DeductibleRate;
//  if(Deductible > Deductibletemp)
//  {
//    Realpay = temp - Deductible;
//  }
//  else
//  {
   /* add by liuning begin 20040220 */
    if(fm.prpLcompensateRiskCode.value=="DAS"&&fm.all("prpLlossDtoKindCode")[findex].value=="F"&&Deductibletemp<100.0&&temp>0.0)
    {
       //if(Deductibletemp<100.0)
       //{
          Deductibletemp = 100.0;

          Realpay = temp - Deductibletemp;
          if(temp>0)
          {
           DeductibleRate = (Deductibletemp*100.0)/temp;
            fm.all("prpLlossDtoDeductibleRate")[findex].value = point(round(DeductibleRate,2),2)
          }
       //}
    }
    else
    {
        //个别附加险要获得主险的绝对免赔率
        if(fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D3" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D4" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Y"  ||
           fm.all("prpLlossDtoKindCode")[findex].value=="H")
        {
            mainKindCode = "B";
        }
        if(fm.all("prpLlossDtoKindCode")[findex].value=="G0" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="L" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Z" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Y" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="X")
        {
            mainKindCode = "A";
        }
        for(var j=0;j<fm.all("prpLlossDtoKindCode").length;j++)
        {
            if(fm.all("prpLlossDtoKindCode")[j].value==mainKindCode)
            {
                DeductibleRateOfMainKind = fm.all("prpLlossDtoDeductibleRate")[j].value;
                break;
            }
        }
        //应 要求,屏蔽掉主险的责任免赔率
        DeductibleRateOfMainKind = 0;
        if(fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D3" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D4" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Y" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="G0" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="L" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Z" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="X" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="H")
        {
           fm.all("PrpLlossDtoMainKindDuctibleRate")[findex].value =DeductibleRateOfMainKind;
           Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate)*(1-DeductibleRateOfMainKind/100);
        }
        else if(fm.all("prpLlossDtoKindCode")[findex].value=="T"||
                fm.all("prpLlossDtoKindCode")[findex].value=="C")
        {
            //Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate)-unitPrice;
            //停驶、代步车调整
            Realpay =  (temp * (1-DutyDeductibleRate)-unitPrice)*(1 - DriverDeductibleRate);
            
        }
        else
        {
           Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate);
        }
    }

    /* add by liuning end 20040220 */
//  }
//alert("amount"+Amount);
    //modify by lirj update begin 040323
    //reason:实赔处理，车上货物责任险、无过失责任险超限时系统的赔付计算不对
    //if(fm.LossKindCode.value=="B" && temp > Amount)
    if((fm.all("prpLlossDtoKindCode")[findex].value=="B" ||fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||fm.all("prpLlossDtoKindCode")[findex].value=="W")
        && temp > Amount)
    //modify by lirj update end 040323
    {
      Realpay = Amount * (1-DutyDeductibleRate)*(1-DeductibleRate)*(1-DriverDeductibleRate);
    }
    //modify begin zhanqiang 20031126
    if(Realpay > Amount &&  Amount > 0)
    {
      Realpay = Amount;
    }
    //modify end zhanqiang 20031126
    //modify by dengxh begin 20040904
    //reason:险别是车损或三者，并且损失明细为27扣免赔，则赔偿金额=-残值
    if((fm.all("prpLlossDtoKindCode")[findex].value=="A"||fm.all("prpLlossDtoKindCode")[findex].value=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27")
    {
      Realpay = SumRest*(-1);
    }
    //modify by dengxh end 20040904
    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
    //if(checkAmount(fm.all("prpLlossDtoKindCode")[findex].value,fm.all("prpLlossDtoAmount")[findex].value)==false)
    //{
    //    fm.all("prpLlossDtoSumLoss")[findex].focus();
    //   alert("赔偿金额超过了险别的保额/限额");
    //    return false;
    //}
  
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();

  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

}
function checkAmount(kindCode,amount)
{
  var sumAmountOfKind = 0;
  for( i = 1; i < fm.all("prpLlossDtoKindCode").length; i++ )
  {
      if(fm.all("prpLlossDtoKindCode")[i].value==kindCode)
      {
           sumAmountOfKind = sumAmountOfKind+parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);
      }
  }  
  alert("sumAmountOfKind"+sumAmountOfKind);
   alert("amount"+amount);
  if(sumAmountOfKind > parseFloat(amount))
  {
      return false;
  }
  else
  {
      return true;
  }
}


 /**
 @author      liuyang
 @description 计算赔付人员的赔款金额(改变责任比例时造成的赔款金额的改变)
              涉及所有当前行的费用信息
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay2ForSunny(field)
{
  var i = 0;
  var findex=0;       //定位序号
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例

  var DutyDeductibleRate; //事故责任免赔率
  
  
  
  var DriverDeductibleRate; //驾驶员免赔率
  var DeductibleRate; //绝对免赔率
  var MainKindDeductibleRate; //所在主险的绝对免赔率


  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var ArrangeRate; 	  //协商赔款比例
  var Realpay;        //赔付金额
  var temp;

  var fieldname=field.name; //域名

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  //如果本条费用信息不存在则返回
  if(getElementCount("personLossSerialNo")<=findex){
  	return;
  }

 	//if(fm.all("prpLlossDtoKindCode")[findex].value=="B" && fm.all("prpLlossDtoFeeTypeCode")[findex].value!="27")
 	var findex1 = 0;
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++) {
    if(getElementCount("personLossSerialNo")>1)
    {
       if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
          findex1=i;
          break;
       }
    }
  }
  DutyRate = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[findex1].value);
  ArrangeRate = parseFloat(fm.all("prpLpersonLossArrangeRate")[findex1].value);
  DutyDeductibleRate = parseFloat(fm.all("prpLpersonLossDutyDeductibleRate")[findex1].value);
  DriverDeductibleRate = parseFloat(fm.all("prpLpersonLossDriverDeductibleRate")[findex1].value);
  DeductibleRate = parseFloat(fm.all("prpLpersonLossDeductibleRate")[findex1].value);
  MainKindDeductibleRate=parseFloat(fm.all("prpLpersonLossMainKindDeductibleRate")[findex1].value);
  Amount         = parseFloat(fm.all("prpLpersonLossAmount")[findex1].value);
  if(isNaN(ArrangeRate))
    ArrangeRate = 0;
  else
    ArrangeRate = ArrangeRate/100;
    
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;    
    
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;

  if(isNaN(DutyDeductibleRate))
    DutyDeductibleRate = 0;
  else
    DutyDeductibleRate = DutyDeductibleRate/100;

  if(isNaN(DriverDeductibleRate))
    DriverDeductibleRate = 0;
  else
    DriverDeductibleRate = DriverDeductibleRate/100;

  if(isNaN(MainKindDeductibleRate))
    MainKindDeductibleRate = 0;
  else
    MainKindDeductibleRate = MainKindDeductibleRate/100;


  //给变量赋值
  SumLoss        = 0;
  SumRest        = 0;     //
  ClaimRate      = 0;
  Deductible     = 0;     //
  Deductibletemp = 0;
  Realpay        = 0;
  temp           = 0;
  for(i=1;i<fm.all("prpLpersonLossSumRealPay").length;i++)
  {
    if(fm.all("personLossSerialNo")[i].value==fm.all("prpLpersonLossSerialNo")[findex].value){

    SumLoss   = parseFloat(fm.all("prpLpersonLossSumLoss")[i].value);
    ClaimRate = parseFloat(fm.all("prpLpersonLossClaimRate")[i].value);

    if(isNaN(SumLoss))
      SumLoss = 0;
    if(isNaN(ClaimRate))
      ClaimRate = 0;
    else
      ClaimRate = ClaimRate/100;

    /*计算赔款金额
     * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
     * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
     */
    temp = (SumLoss - SumRest) * ClaimRate * DutyRate * ArrangeRate;  //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例 * 协商赔偿比例
    Deductibletemp = temp * DeductibleRate;  //免赔= temp * 免赔率

//    if(Deductible > Deductibletemp)
//    {
//      Realpay = temp  - Deductible;
//    }
//    else
//    {

       //应 需求,屏蔽绝对免赔率
      MainKindDeductibleRate = 0;
       //部分险别需要承上所在主险的绝对免赔率
      if(fm.all("prpLpersonLossKindCode")[findex].value=="D2" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="D3" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="D4" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="Y" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="G0" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="L" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="Z" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="X" ||
         fm.all("prpLpersonLossKindCode")[findex].value=="H")
      {
          Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-DriverDeductibleRate)*(1-MainKindDeductibleRate);
      }
      else
      {
          Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-DriverDeductibleRate);
      }
//    }

      fm.all("prpLpersonLossSumRealPay")[i].value = point(round(Realpay,2),2);
      }
  }

  //计算赔付人员中的赔付合计
  calSumRealpay(field);

  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;
*/
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);

}




 /**
 @author      任轶群
 @description 计算赔付人员的赔款金额(改变单价、数目和赔偿比例时造成的赔款金额的改变)
              只涉及触发域所对应的当前行的费用信息
 @param       Field: 触发域
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay1ForSunny(Field)
{
  var fieldname=Field.name; //域名
  var i = 0;
  var findex=0;       //定位序号
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例

  var DutyDeductibleRate; //事故责任免赔率
  var DriverDeductibleRate; //驾驶员免赔率
  var DeductibleRate; //绝对免赔率
  var MainKindDeductibleRate; //所在主险的绝对免赔率

  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔付金额
  var temp;

  //定位
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }


  //给变量赋值
  SumLoss        = parseFloat(fm.all("prpLpersonLossSumLoss")[findex].value);
  SumRest        = 0;    //
  ClaimRate      = parseFloat(fm.all("prpLpersonLossClaimRate")[findex].value);
  DeductibleRate = 0;
  Deductible     = 0;   //
  Deductibletemp = 0;
  DutyRate       = 0;
  Realpay        = 0;
  temp           = 0;
  var findex1 = 0;
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++) {
  //alert("--prpLpersonLossSerialNo-personLossSerialNo-"+fm.all("prpLpersonLossSerialNo")[i].value+"|"+fm.all("personLossSerialNo")[findex].value+"|"+fm.all("prpLpersonLossIndemnityDutyRate").length);
    if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
        findex1=i;
        break;
      }
  }
  DutyRate       = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[findex1].value);
  DeductibleRate = parseFloat(fm.all("prpLpersonLossDeductibleRate")[findex1].value);
  DutyDeductibleRate = parseFloat(fm.all("prpLpersonLossDutyDeductibleRate")[findex1].value);
  DriverDeductibleRate = parseFloat(fm.all("prpLpersonLossDriverDeductibleRate")[findex1].value);
  MainKindDeductibleRate=parseFloat(fm.all("prpLpersonLossMainKindDeductibleRate")[findex1].value);
  Amount                =parseFloat(fm.all("prpLpersonLossAmount")[findex1].value); 
//alert("Amount"+Amount);
//alert("--DutyRate-DeductibleRate-"+DutyRate+"|"+DeductibleRate);
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;

  if(isNaN(DutyDeductibleRate))
    DutyDeductibleRate = 0;
  else
    DutyDeductibleRate = DutyDeductibleRate/100;

  if(isNaN(DriverDeductibleRate))
    DriverDeductibleRate = 0;
  else
    DriverDeductibleRate = DriverDeductibleRate/100;

  if(isNaN(MainKindDeductibleRate))
    MainKindDeductibleRate = 0;
  else
    MainKindDeductibleRate = MainKindDeductibleRate/100;


  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;

  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
   * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
   */

  temp = (SumLoss - SumRest) * ClaimRate * DutyRate; //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例
  Deductibletemp = temp * DeductibleRate; //免赔= temp * 免赔率

//  if(Deductible > Deductibletemp)
//  {
//    Realpay = temp - Deductible;
//  }
//  else
//  {

     //部分险别需要承上所在主险的绝对免赔率
     if(fm.all("prpLpersonLossKindCode")[findex1].value=="D2" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="D3" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="D4" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="Y" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="G0" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="L" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="Z" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="X" ||
        fm.all("prpLpersonLossKindCode")[findex1].value=="H"  )
     {
         Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate)*(1-MainKindDeductibleRate);
     }
     else
     {
         Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate);
     }
//  }
  if(temp>Amount)
  {
      Realpay = Amount*(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate);
  }
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);

  //计算赔付人员中的赔付合计
  calSumRealpay(Field);

  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;

  //分险别校验是否超过保单中的限额
  CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);
*/
}

function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}

//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcompensatePolicyNo.value;
     var RiskCode  =fm.prpLcompensateRiskCode.value;
     var damageDate=fm.damageDate.value;
      var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}


function getArrangeRate(field)
 {  
  var fieldname=field.name; 
  var i = 0;
  var ArrangeRate_A;
  var prpLlossDtoKindCode_A;


  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
   prpLlossDtoKindCode_A= fm.all("prpLlossDtoKindCode")[findex].value;  	
   ArrangeRate_A= parseFloat(fm.all("prpLlossDtoArrangeRate")[findex].value);

   if(isNaN(ArrangeRate_A)||ArrangeRate_A.length<1){
      ArrangeRate_A = 0;
   }

  for(i=1;i<fm.all("prpLlossDtoArrangeRate").length;i++)
  {
	if (fm.all("prpLlossDtoKindCode")[i].value==prpLlossDtoKindCode_A){
 		fm.all("prpLlossDtoArrangeRate")[i].value=point(round(ArrangeRate_A ,2),2);
	} 
  }   
  return true;  
       
}

function getIndemnityDutyRate(field)
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var propSumLoss;
  var propSumReject;
  var propSumDefLoss;
  var IndemnityDutyRate_A;
  var prpLlossDtoKindCode_A;


  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
  
   prpLlossDtoKindCode_A= fm.all("prpLlossDtoKindCode")[findex].value;  	
   IndemnityDutyRate_A= parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);

   if(isNaN(IndemnityDutyRate_A)||IndemnityDutyRate_A.length<1){
      IndemnityDutyRate_A = 0;
   }
  for(i=1;i<fm.all("prpLlossDtoIndemnityDutyRate").length;i++)
  {
	if (fm.all("prpLlossDtoKindCode")[i].value==prpLlossDtoKindCode_A){
 		fm.all("prpLlossDtoIndemnityDutyRate")[i].value=point(round(IndemnityDutyRate_A ,2),2);
	} 
  } 
  return true;  
}

/**
 @author      李纪元
 @description 计算赔付标的中的赔偿金额（改变实际价值、核定损失、残值、责任比例时触发）
              计算赔款金额
              如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
              # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpayForDuBang(field)
{
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DutyDeductibleRate; //事故责任免赔率
  var DeductibleRate; //免赔率
  var DriverDeductibleRate;//驾驶员免赔率
  var mainKindCode;   //主险代码
  var DeductibleRateOfMainKind;//主险的绝对免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var ArrangeRate;		//协商赔偿比例
  var Realpay;        //赔偿金额
  var temp;
  var unitPrice;
  var Amount;

  var fieldname=field.name;
  var findex=0;
  //modify by caopeng start at 2005-12-23 增加try,catch块，屏蔽一些非正常操作带来的js错误
  try{
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  
//==开始赋值
  SumLoss       		= parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       		= parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     		= parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DutyRate      		= parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
  //协商赔偿比例
  ArrangeRate			= parseFloat(fm.all("prpLlossDtoArrangeRate")[findex].value);
  
  DutyDeductibleRate	= parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[findex].value);
  DeductibleRate		= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  unitPrice      			= parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].value);
  Amount        		= parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
//=================arm in hand  
  }catch(E)
  {
    
  }


 
  if(isNaN(Amount))
    Amount = 0;
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;    
  if(isNaN(ArrangeRate))
    ArrangeRate = 0;
  else
    ArrangeRate = ArrangeRate/100;  
  if(isNaN(DutyDeductibleRate))
    DutyDeductibleRate = 0;
  else
    DutyDeductibleRate = DutyDeductibleRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;

   if(isNaN(unitPrice))
    unitPrice = 0;

  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 协商免赔率 * 责任比例 * （1 - 免赔率）
   */
   
  try{
	  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
	  if(kindCode=="C"
	  	||kindCode=="L"
	  	||kindCode=="G"
	  	){      
	  	//这些险种不需要按责任比例计算
	  	temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate;
	  }else{
	  	//其它险种需要按责任比例计算
	  	temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate * DutyRate  ;	
	  }
	  Deductibletemp = temp * DeductibleRate;

//============个别附加险要获得主险的绝对免赔率
        if(fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D3" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D4" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Y"  ||
           fm.all("prpLlossDtoKindCode")[findex].value=="H")
        {
            mainKindCode = "B";
        }
        if(fm.all("prpLlossDtoKindCode")[findex].value=="G0" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="L" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Z" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Y" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="X")
        {
            mainKindCode = "A";
        }
        for(var j=0;j<fm.all("prpLlossDtoKindCode").length;j++)
        {
            if(fm.all("prpLlossDtoKindCode")[j].value==mainKindCode)
            {
                DeductibleRateOfMainKind = fm.all("prpLlossDtoDeductibleRate")[j].value;
                break;
            }
        }
        //应 要求,屏蔽掉主险的责任免赔率
        DeductibleRateOfMainKind = 0;
        if(fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D3" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="D4" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Y" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="G0" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="L" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="Z" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="X" ||
           fm.all("prpLlossDtoKindCode")[findex].value=="H")
        {
           fm.all("PrpLlossDtoMainKindDuctibleRate")[findex].value =DeductibleRateOfMainKind;
           Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-DeductibleRateOfMainKind/100);
        }
        else if(fm.all("prpLlossDtoKindCode")[findex].value=="T"||
                fm.all("prpLlossDtoKindCode")[findex].value=="C")
        {
            //停驶、代步车调整
            Realpay =  (temp * (1-DutyDeductibleRate)-unitPrice);
            
        }
        else
        {
           Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate);
        }

//================================================    

    //reason:实赔处理，车上货物责任险、无过失责任险超限时系统的赔付计算不对
    if((fm.all("prpLlossDtoKindCode")[findex].value=="B" ||fm.all("prpLlossDtoKindCode")[findex].value=="D2" ||fm.all("prpLlossDtoKindCode")[findex].value=="W")
        && temp > Amount)
    {
      if (Amount>0){
	      Realpay = Amount * (1-DutyDeductibleRate)*(1-DeductibleRate);
      	}
    }
    if(Realpay > Amount &&  Amount > 0)
    {
      Realpay = Amount;
    }
    //reason:险别是车损或三者，并且损失明细为27扣免赔，则赔偿金额=-残值
    if((fm.all("prpLlossDtoKindCode")[findex].value=="A"||fm.all("prpLlossDtoKindCode")[findex].value=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27")
    {
      Realpay = SumRest*(-1);
    }
    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
    }catch(E)
    {
    }
    //modify by caopeng end at 2005-12-23 增加try,catch块，屏蔽一些非正常操作带来的js错误
    calFund();
    
}

/**
 @author      李纪元
 @description 计算赔付标的中的赔偿金额（改变实际价值、核定损失、残值、责任比例时触发）
              计算赔款金额
              如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
              # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpayForDuBangAll()
{
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DutyDeductibleRate; //事故责任免赔率
  var DeductibleRate; //免赔率
  var DriverDeductibleRate;//驾驶员免赔率
  var mainKindCode;   //主险代码
  var DeductibleRateOfMainKind;//主险的绝对免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var ArrangeRate;		//协商赔偿比例
  var Realpay;        //赔偿金额
  var temp;
  var unitPrice;
  var Amount;

  var findex=0;
  for(i=1;i<fm.all("prpLlossDtoSumLoss").length;i++){
	findex=i;
	SumLoss       		= parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
	SumRest       		= parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
	ClaimRate     		= parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
	DutyRate      		= parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
	//协商赔偿比例
	ArrangeRate			= parseFloat(fm.all("prpLlossDtoArrangeRate")[findex].value);
	DutyDeductibleRate	= parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[findex].value);
	DeductibleRate		= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
	unitPrice      			= parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].value);
	Amount        		= parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
	if(isNaN(Amount))	Amount = 0;
	if(isNaN(SumLoss))  SumLoss = 0;
	if(isNaN(SumRest))  SumRest = 0;
	if(isNaN(Deductible))	Deductible = 0;
	if(isNaN(unitPrice))	unitPrice = 0;
	
	if(isNaN(ClaimRate)) 
		ClaimRate = 0;
	else
    	ClaimRate = ClaimRate/100;

	if(isNaN(DutyRate))
		DutyRate = 0;
	else
		DutyRate = DutyRate/100;
    
	if(isNaN(ArrangeRate))
    	ArrangeRate = 0;
	else
    	ArrangeRate = ArrangeRate/100;  
    
	if(isNaN(DutyDeductibleRate))
    	DutyDeductibleRate = 0;
	else
    	DutyDeductibleRate = DutyDeductibleRate/100;
    	
	if(isNaN(DeductibleRate))
    	DeductibleRate = 0;
	else
    	DeductibleRate = DeductibleRate/100;

	/*计算赔款金额
	 * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
	*/
	var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
	if(kindCode=="C"||kindCode=="L"||kindCode=="G"){      
		temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate;
	}else{
	 	temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate * DutyRate  ;	
	}  
	//============个别附加险要获得主险的绝对免赔率
	if(kindCode=="D2" ||
       kindCode=="D3" ||
       kindCode=="D4" ||
       kindCode=="Y"  ||
       kindCode=="H"){
       mainKindCode = "B";
	}
    if(kindCode=="G0" ||
       kindCode=="L" ||
       kindCode=="Z" ||
       kindCode=="Y" ||
       kindCode=="X"){
       mainKindCode = "A";
    }
	
	for(var j=0;j<fm.all("prpLlossDtoKindCode").length;j++){
		if(fm.all("prpLlossDtoKindCode")[j].value==mainKindCode){
	        DeductibleRateOfMainKind = fm.all("prpLlossDtoDeductibleRate")[j].value;
            break;
        }
    }
	//应 要求,屏蔽掉主险的责任免赔率
	DeductibleRateOfMainKind = 0;
	if(kindCode=="D2" ||
	   kindCode=="D3" ||
	   kindCode=="D4" ||
	   kindCode=="Y" ||
	   kindCode=="G0" ||
	   kindCode=="L" ||
	   kindCode=="Z" ||
	   kindCode=="X" ||
	   kindCode=="H"){
	   fm.all("PrpLlossDtoMainKindDuctibleRate")[findex].value =DeductibleRateOfMainKind;
	   Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-DeductibleRateOfMainKind/100);
	}else if(kindCode=="T"||kindCode=="C"){
	    //Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate)*(1 - DriverDeductibleRate)-unitPrice;
	    //停驶、代步车调整
	    Realpay =  (temp * (1-DutyDeductibleRate)-unitPrice);	    
	}else{
	   Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate);
	}
    //reason:实赔处理，车上货物责任险、无过失责任险超限时系统的赔付计算不对
    if((kindCode=="B" ||kindCode=="D2" ||kindCode=="W")&& temp > Amount){
	    if (Amount>0){
			Realpay = Amount * (1-DutyDeductibleRate)*(1-DeductibleRate);
		}
    }
    if(Realpay > Amount &&  Amount > 0){
      Realpay = Amount;
    }
    //reason:险别是车损或三者，并且损失明细为27扣免赔，则赔偿金额=-残值
    if((kindCode=="A"||kindCode=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27"){
      Realpay = SumRest*(-1);
    }
    //modify by dengxh end 20040904
    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  }	
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
}

function calRealpay1ForDuBang(Field){
  var fieldname=Field.name; //域名
  var i = 0;
  var findex=0;       //定位序号
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例

  var DutyDeductibleRate; //事故责任免赔率
  var DriverDeductibleRate; //驾驶员免赔率
  var DeductibleRate; //绝对免赔率
  var MainKindDeductibleRate; //所在主险的绝对免赔率

  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var ArrangeRate;	  //协商赔偿比例
  var Realpay;        //赔付金额
  var temp;
  var Amount;

  //========================
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }
  //========================

  //============给变量赋值
  SumLoss        	= parseFloat(fm.all("prpLpersonLossSumLoss")[findex].value);
  ClaimRate      	= parseFloat(fm.all("prpLpersonLossClaimRate")[findex].value);
  SumRest        	= 0;   
  DeductibleRate 	= 0;
  Deductible     	= 0;   
  Deductibletemp 	= 0;
  DutyRate       	= 0;
  ArrangeRate		= 0;
  Realpay        	= 0;
  temp           		= 0;
  var findex1 = 0;
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++) {
    if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
        findex1=i;
        break;
    }
  }
  DutyRate       = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[findex1].value);
  ArrangeRate    = parseFloat(fm.all("prpLpersonLossArrangeRate")[findex1].value);
  DeductibleRate = parseFloat(fm.all("prpLpersonLossDeductibleRate")[findex1].value);
  DutyDeductibleRate = parseFloat(fm.all("prpLpersonLossDutyDeductibleRate")[findex1].value);
  MainKindDeductibleRate=parseFloat(fm.all("prpLpersonLossMainKindDeductibleRate")[findex1].value);
  Amount                =parseFloat(fm.all("prpLpersonLossAmount")[findex1].value); 
  //================初始化===================
  if(isNaN(SumLoss)) SumLoss = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;

  if(isNaN(DutyDeductibleRate))
    DutyDeductibleRate = 0;
  else
    DutyDeductibleRate = DutyDeductibleRate/100;

  if(isNaN(MainKindDeductibleRate))
    MainKindDeductibleRate = 0;
  else
    MainKindDeductibleRate = MainKindDeductibleRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
    
  if(isNaN(ArrangeRate))
    ArrangeRate = 0;
  else
    ArrangeRate = ArrangeRate/100;


  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
   */
  temp = (SumLoss - SumRest) * ClaimRate * DutyRate * ArrangeRate; //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例
  Deductibletemp = temp * DeductibleRate; //免赔= temp * 免赔率


  //================绝对免赔率==============================
  //部分险别需要承上所在主险的绝对免赔率
  if(fm.all("prpLpersonLossKindCode")[findex1].value=="D2" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D3" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D4" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="Y" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="G0" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="L" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="Z" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="X" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="H"  ){
     Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-MainKindDeductibleRate);
  }else{
    Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate);
  }
  if(temp>Amount){
      Realpay = Amount*(1-DutyDeductibleRate)*(1 - DeductibleRate);
  }
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);

  //计算赔付人员中的赔付合计
  calSumRealpay(Field);
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
}

function setAllIndemnityDutyRate()
 {  
  var i = 0;
  var findex=0;       
  var propSumLoss;
  var propSumReject;
  var propSumDefLoss;
  var IndemnityDutyRate_A;
  var prpLlossDtoKindCode_A;


   IndemnityDutyRate_A= parseFloat(fm.prpLcompensateIndemnityDutyRate.value);
//alert(IndemnityDutyRate_A);   
 if(isNaN(IndemnityDutyRate_A)||IndemnityDutyRate_A.length<1){
      IndemnityDutyRate_A = 0;
    }

  for(i=1;i<fm.all("prpLlossDtoIndemnityDutyRate").length;i++)
  {
 	fm.all("prpLlossDtoIndemnityDutyRate")[i].value=point(round(IndemnityDutyRate_A ,2),2);
   } 
  for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++)
  {
     fm.all("prpLpersonLossIndemnityDutyRate")[i].value=point(round(IndemnityDutyRate_A ,2),2);
  } 
  
  calRealpayForDuBangAll();

  if(fm.all("prpLpersonLossIndemnityDutyRate").length>0){

      for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++){
  	calRealpay2ForSunny(fm.all("prpLpersonLossIndemnityDutyRate")[i]); 
      	}
  }
  
  
  return true;  
       
}

function setRealPay(){
	for(i=1;i<fm.all("prpLchargeSerialNo").length;i++){
		//ChargeCode="03"时表示施救费
		if (fm.all("prpLchargeChargeCode")[i].value=="03"){
			fm.all("prpLchargeSumRealPay")[i].value = fm.all("prpLchargeChargeAmount")[i].value;
		}else{
			fm.all("prpLchargeSumRealPay")[i].value = 0;
		}
	}
	calFund();
}

function calFundCommerce(){

}

function testljy(){

alert(fm.all("prpLpersonCommerceSerialNo").length);	

  //定位
  for(i=0;i<fm.all("prpLpersonCommerceSerialNo").length;i++)
  {
	alert(fm.all("prpLpersonCommerceSerialNo")[i].value);
  	}
}


function calCompelSumPropAndPerson()
{

  var i = 0;
  var findex=0;             //定位序号
  var qindex=0;
  var SumLoss;              //核损金额
  var UnitPrice;            //单价
  var Quantity;             //数量
  var AmountPrice =0;
  var allPropPrice=0;
  var allMedicalPrice=0;
  var allDeformityPrice=0;

  var allPropPriceSumLoss=0;
  var allMedicalPriceSumLoss=0;
  var allDeformityPriceSumLoss=0;
  var allPropPriceRest=0;
  var allMedicalPriceRest=0;
  var allDeformityPriceRest=0;  

  var duty= fm.indemnityDuty.value; //责任
  var configCode =fm.configCode.value;
  var quotaBZ_D =0;
  var quotaBZ_M =0;
  var quotaBZ_P =0;
  
  var quotaBZ_NoDuty =0;
  var quotaBZ_NoInsP =0;
  var quotaBZ_NoInsM =0;
  var quotaBZ_NoInsD =0;
  
  var allNoDutyPropPrice=0;
  var allNoInsPPrice=0;
  var allNoInsMPrice=0;
  var allNoInsDPrice=0;
     
 if ('RISKCODE_DAZ'==configCode||'RISKCODE_DAY'==configCode||'RISKCODE_DAU'==configCode){ 
    for (var i=0;i<fm.all("limitType").length;i++ ){
       if ( duty!='4'){
          if (fm.all("limitType")[i].value=='90' ) {  
           quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='91' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='92' ){   
            quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
       else  {  //无责
          if (fm.all("limitType")[i].value=='93' ) {  
            quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='94' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='95' )   {
             quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
   
    }
    
   
   }
  
 
  


  var allSuperCompelPropPrice=0;
  var allSuperCompelMedicalPrice=0;
  var allSuperCompelDeformityPrice=0;  

  
  var wealthTitle=    ["财产损失","0","1000","2000","2000","26000","0"];
  var medicalTitle=   ["医疗费用","0","20000","2000","10000","26000","0"];
  var deformityTitle= ["死亡伤残","0","40000","2000","40000","26000","0"];
  
  var nodutyTitle=    ["无责代赔","0","1000","2000","2000","26000","0"];
  var noinspTitle= ["财产无保险代赔","0","40000","2000","40000","26000","0"];
  var noinsmTitle=   ["医疗无保险代赔","0","20000","2000","10000","26000","0"];  
  var noinsdTitle= ["死亡伤残无保险代赔","0","40000","2000","40000","26000","0"];



  for(i=1;i<fm.all("propLicenseNo").length;i++)
  {
   allPropPriceSumLoss=allPropPriceSumLoss+(parseFloat(fm.all("propSumLoss")[i].value));
   allPropPriceRest =allPropPriceRest+parseFloat(fm.all("propEliminate")[i].value);
   allPropPrice =allPropPrice+ parseFloat(fm.all("propSumDefPay")[i].value);
  }
  
  for(i=1;i<fm.all("noneDutyLicenseNo").length;i++)
  {
  	allNoDutyPropPrice =allNoDutyPropPrice+ parseFloat(fm.all("noneDutyLoss")[i].value);
  	if(fm.all("dutyPercent")[i].value==0){
  		quotaBZ_NoDuty+=100;
  	}
  }
  for(i=1;i<fm.all("NoneInsItemCode").length;i++)
  {
  	if(fm.all("NoneInsItemCode")[i].value=="noInsP"){
  		allNoInsPPrice =parseFloat(fm.all("NoInsVerifyPaid")[i].value);
  		quotaBZ_NoInsP = parseFloat(fm.all("NoInsLimitPaid")[i].value);
	}else if(fm.all("NoneInsItemCode")[i].value=="noInsM"){
  		allNoInsMPrice =parseFloat(fm.all("NoInsVerifyPaid")[i].value);
  		quotaBZ_NoInsM = parseFloat(fm.all("NoInsLimitPaid")[i].value);
	}else if(fm.all("NoneInsItemCode")[i].value=="noInsD"){
  		allNoInsDPrice =parseFloat(fm.all("NoInsVerifyPaid")[i].value);
  		quotaBZ_NoInsD = parseFloat(fm.all("NoInsLimitPaid")[i].value);
	}
  }
  
  var chargeFee=0;
  for (i=1;i<fm.all("prpLchargeChargeCode").length;i++){
   	chargeFee= parseFloat(fm.all("prpLchargeSumRealPay")[i].value);
   	if (isNaN(chargeFee)){
   	 chargeFee =0;	
   	}
   	allPropPrice+=chargeFee ;
  }

  if(isNaN(allPropPrice))
    allPropPrice= 0;
  if(isNaN(allPropPriceSumLoss))
    allPropPriceSumLoss= 0;
  if(isNaN(allPropPriceRest))
    allPropPriceRest= 0;  



  for(i=1;i<fm.all("personMedicalSerialNo").length;i++)
  {
    if (fm.all("medicDeathFlag")[i].value=='M'){
       allMedicalPriceSumLoss=allMedicalPriceSumLoss+ (parseFloat(fm.all("prpLpersonMedicalSumLoss")[i].value));
       allMedicalPriceRest=allMedicalPriceRest+ parseFloat(fm.all("prpLpersonMedicalRejectSum")[i].value);
       allMedicalPrice =allMedicalPrice+ parseFloat(fm.all("prpLpersonMedicalSumDefPay")[i].value);
     }
  }
  if(isNaN(allMedicalPrice))
    allMedicalPrice= 0;
  if(isNaN(allMedicalPriceSumLoss))
    allMedicalPriceSumLoss= 0;
  if(isNaN(allMedicalPriceRest))
    allMedicalPriceRest= 0;

  for(i=1;i<fm.all("personMedicalSerialNo").length;i++)
  {
    if (fm.all("medicDeathFlag")[i].value=='D'){
      allDeformityPriceSumLoss=  allDeformityPriceSumLoss+(parseFloat(fm.all("prpLpersonMedicalSumLoss")[i].value));
      allDeformityPriceRest=  allDeformityPriceRest+parseFloat(fm.all("prpLpersonMedicalRejectSum")[i].value);   
      allDeformityPrice =allDeformityPrice+ parseFloat(fm.all("prpLpersonMedicalSumDefPay")[i].value);
    }
 }
  if(isNaN(allDeformityPriceSumLoss))
    allDeformityPriceSumLoss= 0;
  if(isNaN(allDeformityPriceRest))
    allDeformityPriceRest= 0;
  if(isNaN(allDeformityPrice))
    allDeformityPrice= 0;
  if(isNaN(allNoDutyPropPrice))
    allNoDutyPropPrice= 0;
  if(isNaN(allNoInsPPrice))
    allNoInsPPrice= 0;
  if(isNaN(allNoInsMPrice))
    allNoInsMPrice= 0;
  if(isNaN(allNoInsDPrice))
    allNoInsDPrice= 0;
    
  if(isNaN(quotaBZ_NoDuty))
    quotaBZ_NoDuty= 0;
  if(isNaN(quotaBZ_NoInsP))
    quotaBZ_NoInsP= 0;
  if(isNaN(quotaBZ_NoInsM))
    quotaBZ_NoInsM= 0;
  if(isNaN(quotaBZ_NoInsD))
    quotaBZ_NoInsD= 0;



  qindex++;
  wealthTitle[qindex]=allPropPriceSumLoss;
  medicalTitle[qindex]=allMedicalPriceSumLoss;
  deformityTitle[qindex]=allDeformityPriceSumLoss;
  nodutyTitle[qindex]="-";
  noinspTitle[qindex]="-";
  noinsmTitle[qindex]="-";
  noinsdTitle[qindex]="-";
  
  qindex++;
  wealthTitle[qindex]=allPropPriceRest;
  medicalTitle[qindex]=allMedicalPriceRest;
  deformityTitle[qindex]=allDeformityPriceRest;
  nodutyTitle[qindex]="-";
  noinspTitle[qindex]="-";
  noinsmTitle[qindex]="-";
  noinsdTitle[qindex]="-";
  
  qindex++;
  wealthTitle[qindex]=allPropPrice;
  medicalTitle[qindex]=allMedicalPrice;
  deformityTitle[qindex]=allDeformityPrice;
  nodutyTitle[qindex]=allNoDutyPropPrice;
  noinspTitle[qindex]=allNoInsPPrice;
  noinsmTitle[qindex]=allNoInsMPrice;
  noinsdTitle[qindex]=allNoInsDPrice;
  
  qindex++;  
  wealthTitle[qindex]=quotaBZ_P;
  medicalTitle[qindex]=quotaBZ_M;
  deformityTitle[qindex]=quotaBZ_D;
  nodutyTitle[qindex]=quotaBZ_NoDuty;
  noinspTitle[qindex]=quotaBZ_NoInsP;
  noinsmTitle[qindex]=quotaBZ_NoInsM;
  noinsdTitle[qindex]=quotaBZ_NoInsD;							
  
  qindex++;  
  if (allPropPrice>quotaBZ_P)
  wealthTitle[qindex]=quotaBZ_P;
  else
  wealthTitle[qindex]=allPropPrice;

  if (allMedicalPrice>quotaBZ_M)  
  medicalTitle[qindex]=quotaBZ_M;
  else
  medicalTitle[qindex]=allMedicalPrice;  	


  if (allDeformityPrice>quotaBZ_D)  
  deformityTitle[qindex]=quotaBZ_D;
  else
  deformityTitle[qindex]=allDeformityPrice;

  if (allNoDutyPropPrice>quotaBZ_NoDuty)  
  	nodutyTitle[qindex]=quotaBZ_NoDuty;
  else
  	nodutyTitle[qindex]=allNoDutyPropPrice;
  
  if (allNoInsPPrice>quotaBZ_NoInsP)  
  	noinspTitle[qindex]=quotaBZ_NoInsP;
  else
  	noinspTitle[qindex]=allNoInsPPrice;
  
  if (allNoInsMPrice>quotaBZ_NoInsM) 
  	noinsmTitle[qindex]=quotaBZ_NoInsM;
  else
  	noinsmTitle[qindex]=allNoInsMPrice;
    
  if (allNoInsDPrice>quotaBZ_NoInsD)  
  	noinsdTitle[qindex]=quotaBZ_NoInsD;
  else
  	noinsdTitle[qindex]=allNoInsDPrice;

  for(x=0;x<fm.all("wealth").length;x++)
  	{
	  fm.wealth[x].value=wealthTitle[x];
  	}
  for(x=0;x<fm.all("medical").length;x++)
  	{
	  fm.medical[x].value=medicalTitle[x];
  	}
  for(x=0;x<fm.all("diedeformity").length;x++)
  	{
	  fm.diedeformity[x].value=deformityTitle[x];
  	}  

    for(x=0;x<fm.all("noduty").length;x++)
  	{
	  fm.noduty[x].value=nodutyTitle[x];
  	}
  	
  for(x=0;x<fm.all("noinsp").length;x++)
  	{
	  fm.noinsp[x].value=noinspTitle[x];
  	} 
  for(x=0;x<fm.all("noinsm").length;x++)
  	{
	  fm.noinsm[x].value=noinsmTitle[x];
  	} 	
  for(x=0;x<fm.all("noinsd").length;x++)
  	{
	  fm.noinsd[x].value=noinsdTitle[x];
  	} 

  fm.totalPay.value = parseFloat(wealthTitle[5])+parseFloat(medicalTitle[5])+ parseFloat(deformityTitle[5]) 
  					+parseFloat(nodutyTitle[5])+parseFloat(noinspTitle[5])+parseFloat(noinsmTitle[5])+parseFloat(noinsdTitle[5]);
  fm.prpLdangerRiskSumPaid.value = point(round(wealthTitle[5]+medicalTitle[5]+ deformityTitle[5] +nodutyTitle[5]+noinspTitle[5]+noinsmTitle[5]+noinsdTitle[5],2),2);
}


function setRealPaid(field)
{  
	var index1 = getElementOrder(field);
	if(parseFloat(fm.all("NoInsVerifyPaid")[index1-1].value)>parseFloat(fm.all("NoInsLimitPaid")[index1-1].value))
	{                            
	 	fm.all("NoInsRealPaid")[index1-1].value = fm.all("NoInsLimitPaid")[index1-1].value;
	}else{
		fm.all("NoInsRealPaid")[index1-1].value = fm.all("NoInsVerifyPaid")[index1-1].value;
	}
	
	calCompelSumPropAndPerson();
	calSumDutyPaid();
}

function  calSumDutyPaid(){
	
   var sumPay = parseFloat(fm.totalPay.value);  //强三的赔款总和
   if(isNaN(sumPay)){
   	sumPay =0.00;
   }

   var sumFeePay =0.00;  //记入赔款的费用之和
   var sumFee =0.00;     //费用之和，不包含记入赔款的
   var sumPaid =0.00 ;  //赔款合计
   var sumdutyPaid =0.00;
   var sumPrePaid = 0.00;  //已预付赔款
   var sumThisPaid = 0.00; //本次赔付金额
   
  for (var i=1;i<fm.all("prpLchargeKindCode").length;i++){
  	var sumRealPay =parseFloat( fm.all("prpLchargeSumRealPay")[i].value) ;
  	var ChargeAmount =parseFloat(fm.all("prpLchargeChargeAmount")[i].value) ;
        var chargeCode =fm.all("prpLchargeChargeCode")[i].value	;
  	
  	if (isNaN(sumRealPay)){
  	   sumRealPay=0.00;
  	}
  	if (isNaN(ChargeAmount)){
  	  ChargeAmount =0.00;
  	}
  	if ( chargeCode !='03') {
   	  sumFee   = sumFee + ChargeAmount;
        }
   }
   
  sumPrePaid = parseFloat(fm.prpLcompensateSumPrePaid.value);
  sumPaid= sumPay + sumFee;
  sumThisPaid = sumPay - sumPrePaid;
 
  fm.prpLcompensateSumDutyPaid.value   = point(round(sumPay,2),2);	//赔款合计
  fm.prpLcompensateSumNoDutyFee.value  = point(round(sumFee,2),2); //费用合计
  fm.prpLcompensateSumPaid.value       = point(round(sumPaid,2 ),2) ;    //赔款总计
  fm.prpLcompensateSumThisPaid.value   = point(round(sumThisPaid,2 ),2) ;   //本次赔付金额
  fm.prpLcompensateSumSelfValue.value  = 0;  //本案总自负额
  fm.prpLdangerRiskSumPaid.value       = point(round(sumPaid,2 ),2) ; 
	
}
  function checkNodutyQuota(field)
  {
  	
  	var index = getElementOrder(field);


  	if(parseFloat(fm.all("dutyPercent")[index-1].value) == 0 && parseFloat(fm.all("noneDutyLoss")[index-1].value)> 100)
  	{
  		alert("无责代赔限额不能超过100元");
  		fm.all("noneDutyLoss")[index-1].value = 100;
  	}
  	
  	if(parseFloat(fm.all("dutyPercent")[index-1].value) > 0 && parseFloat(fm.all("noneDutyLoss")[index-1].value) != 0)
  	{
  		alert("该车有责，无责代赔金额为0！");
  		fm.all("noneDutyLoss")[index-1].value = 0;
  	}
  	calCompelSumPropAndPerson();
	calSumDutyPaid();
}
function checkSameItem(field)
  {
  	var index1 = getElementOrder(field);
  	var i=0;
  	for ( i=2;i<index1;i++ ){
  		if(fm.all("NoneInsItemName")[index1-1].value ==fm.all("NoneInsItemName")[i-1].value ){  		
  			alert("已经录过该项目！");
  			fm.all("NoneInsItemName")[index1-1].value="";
  		}
  	}
  }

  function getQuota(field)
  {
  	checkSameItem(field);
  	var index1 = getElementOrder(field);
  	var duty= fm.indemnityDuty.value; 
  	var i=0;
  	if(duty!='4'){
  		for ( i=0;i<fm.all("limitType").length;i++ ){
  			if (fm.all("limitType")[i].value=='90'&& field.value == "死伤无保险代赔") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='91'&& field.value == "医疗无保险代赔") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='92'&& field.value == "财产无保险代赔") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}  
  		}
  	}else{
  		for ( i=0;i<fm.all("limitType").length;i++ ){
  			if (fm.all("limitType")[i].value=='93'&& field.value == "死伤无保险代赔") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='94'&& field.value == "医疗无保险代赔") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='95'&& field.value == "财产无保险代赔") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}  
  		}
  	
  	}	
	setRealPaid(field);
}
function checkBeyondQuota(){


	
  var i=0;

  var duty= fm.indemnityDuty.value; //责任
   var configCode =fm.configCode.value;
   var quotaBZ_D =0;
   var quotaBZ_M =0;
   var quotaBZ_P =0;
     
 if ('RISKCODE_DAZ'==configCode||'RISKCODE_DAY'==configCode||'RISKCODE_DAU'==configCode){ 
    for ( i=0;i<fm.all("limitType").length;i++ ){
       if ( duty!='4'){
          if (fm.all("limitType")[i].value=='90' ) {  
           quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='91' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='92' ){   
            quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
       else  {  //无责
          if (fm.all("limitType")[i].value=='93' ) {  
            quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='94' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='95' )   {
             quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
   
    }
    
   
   }
  


   //财产+施救费
   var  propSumDefPay =0;
   var  propfee =0;
   var rescuFee=0;
   for (  i=1; i<fm.all("propFeeTypeName").length;i++){
   	propSumDefPay = parseFloat(fm.propSumDefPay[i].value) ;
   	if (isNaN(propSumDefPay))  propSumDefPay=0;
   	propfee += propSumDefPay;	
   	
   }
   for (i=1;i<fm.all("prpLchargeKindCode").length;i++  ){
   	rescuFee = parseFloat(fm.prpLchargeSumRealPay[i].value) ;
   	if (isNaN(rescuFee))  rescuFee=0;
   	propfee += rescuFee;
   	
   }
   if ( propfee > quotaBZ_P){
   	alert (" 财产核定赔偿超过了财产限额（"+quotaBZ_P+"元） ");
      	return false;
      	
   }
   
   
   //人伤医疗
   var  medicSumDefPay =0;
   var  medicFee =0;
   var  deathSumDefPay =0;
   var  deathFee =0;
   var feecategory ='';
   for (  i=1; i<fm.all("prpLpersonMedicalDetailCode").length;i++){   
   	feecategory =fm.medicDeathFlag[i].value;
   	if (feecategory=='M' ) {
   	   medicSumDefPay = parseFloat(fm.prpLpersonMedicalSumDefPay[i].value) ;
   	   if (isNaN(medicSumDefPay)) { medicSumDefPay=0; }
   	   medicFee += medicSumDefPay;	
        } 
        if (feecategory=='D' ) {
   	   deathSumDefPay = parseFloat(fm.prpLpersonMedicalSumDefPay[i].value) ;
   	   if (isNaN(deathSumDefPay)) { deathSumDefPay=0; }
   	   deathFee += deathSumDefPay;	
        } 
   
  }
  
    if ( medicFee > quotaBZ_M){
   	alert ("人员医疗核定赔偿超过了财产限额（"+quotaBZ_M+"元） ");
   	
   	return false;
     }
     
     if ( deathFee > quotaBZ_D){
   	alert (" 人员死亡伤残核定赔偿超过了财产限额（"+quotaBZ_D+"元） ");
   	
   	return false;
     }
     return true;
 
}

function checkBeyondQuotaForGuoYuan(field){


    
  var i=0;

  var duty= fm.indemnityDuty.value; //责任
   var configCode =fm.configCode.value;
   var quotaBZ_D =0;
   var quotaBZ_M =0;
   var quotaBZ_P =0;
     
 if ('RISKCODE_DAZ'==configCode||'RISKCODE_DAY'==configCode||'RISKCODE_DAU'==configCode){ 
    for ( i=0;i<fm.all("limitType").length;i++ ){
       if ( duty!='4'){
          if (fm.all("limitType")[i].value=='90' ) {  
           quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='91' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='92' ){   
            quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
       else  {  //无责
          if (fm.all("limitType")[i].value=='93' ) {  
            quotaBZ_D = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='94' ){   
            quotaBZ_M = parseFloat(fm.all("limitFee")[i].value) ;
          }
          if (fm.all("limitType")[i].value=='95' )   {
             quotaBZ_P = parseFloat(fm.all("limitFee")[i].value) ;
          }
   
       }
   
    }
    
   
   }
  


   //财产+施救费
   if(field.name == "propSumLoss"){
	   var  propSumDefPay =0;
	   var  propfee =0;
	   var rescuFee=0;
	   for (  i=1; i<fm.all("propFeeTypeName").length;i++){
	    propSumDefPay = parseFloat(fm.propSumDefPay[i].value) ;
	    if (isNaN(propSumDefPay))  propSumDefPay=0;
	    propfee += propSumDefPay;   
	    
	   }
	   for (i=1;i<fm.all("prpLchargeKindCode").length;i++  ){
	    rescuFee = parseFloat(fm.prpLchargeSumRealPay[i].value) ;
	    if (isNaN(rescuFee))  rescuFee=0;
	    propfee += rescuFee;
	    
	   }
	   if ( propfee > quotaBZ_P){
	    alert (" 财产核定赔偿超过了财产限额（"+quotaBZ_P+"元） ");
	        return false;
	        
	   }
  
   }
   
   
   //人伤医疗
   if(field.name == "prpLpersonMedicalSumLoss"){
	   var  medicSumDefPay =0;
	   var  medicFee =0;
	   var  deathSumDefPay =0;
	   var  deathFee =0;
	   var feecategory ='';
	   for (  i=1; i<fm.all("prpLpersonMedicalDetailCode").length;i++){   
	    feecategory =fm.medicDeathFlag[i].value;
	    if (feecategory=='M' ) {
	       medicSumDefPay = parseFloat(fm.prpLpersonMedicalSumDefPay[i].value) ;
	       if (isNaN(medicSumDefPay)) { medicSumDefPay=0; }
	       medicFee += medicSumDefPay;  
	        } 
	        if (feecategory=='D' ) {
	       deathSumDefPay = parseFloat(fm.prpLpersonMedicalSumDefPay[i].value) ;
	       if (isNaN(deathSumDefPay)) { deathSumDefPay=0; }
	       deathFee += deathSumDefPay;  
	        } 
	   
	  }
	  
	    if ( medicFee > quotaBZ_M){
	    alert ("人员医疗核定赔偿超过了财产限额（"+quotaBZ_M+"元） ");
	    
	    return false;
	     }
	     
	     if ( deathFee > quotaBZ_D){
	        alert (" 人员死亡伤残核定赔偿超过了财产限额（"+quotaBZ_D+"元） ");
	    
	        return false;
	     }
	   
   }
     return true;
 
}


function makeDisabledFalse(field){
     var serialNo=0; //定位
     var fieldName = field.name;
     for ( var j=0; j<fm.all(fieldName).length;j++ ){
       if (field==fm.all(fieldName)[j]){
         serialNo=j;
         break;
       }
     }
     
      for ( var k=1; k<fm.all("propSumDefPay").length;k++){
   	   if ( serialNo == k){
   	       continue;
   	   }  else{
   	     fm.all("propSumDefPay")[k].disabled = false;;
   	   
   	   }
   	 
   	 }
   	 


  }
  
/*
 *核损金额与核定赔偿联动
 */
function calPropSumDefPay(field,flag){
    var SumDefPay ;         //核定赔偿
    var SumLoss ;           //核损金额
    var SumRest ;           //剔除金额
    if('1' == flag)
    {
	    for(var i = 0 ;i < fm.all("propEliminate").length;i++){
	        if(fm.all("propEliminate")[i] == field){
	            SumDefPay      = parseFloat(fm.all("propSumDefPay")[i].value);
	            SumLoss      = parseFloat(fm.all("propSumLoss")[i].value);
	            SumRest      = parseFloat(fm.all("propEliminate")[i].value);
	            
	            if(isNaN(SumDefPay))SumDefPay = 0;
	            if(isNaN(SumLoss))SumLoss = 0;
	            if(isNaN(SumRest))SumRest = 0;
	            
	            fm.all("propEliminate")[i].value = SumRest ;
	            fm.all("propSumDefPay")[i].value = SumLoss - SumRest;
	            
	            break;
	        }
	        
	    }
    }else
    {
	    for(var i = 0 ;i < fm.all("propSumLoss").length;i++){
	        if(fm.all("propSumLoss")[i] == field){
	            SumDefPay      = parseFloat(fm.all("propSumDefPay")[i].value);
	            SumLoss      = parseFloat(fm.all("propSumLoss")[i].value);
	            SumRest      = parseFloat(fm.all("propEliminate")[i].value);
	            
	            if(isNaN(SumDefPay))SumDefPay = 0;
	            if(isNaN(SumLoss))SumLoss = 0;
	            if(isNaN(SumRest))SumRest = 0;
	            
	            fm.all("propEliminate")[i].value = SumRest ;
	            fm.all("propSumDefPay")[i].value = SumLoss - SumRest;
	            
	            break;
	        }
	        
	    }
    }
}
/*
 *@description 检查是不是可以按提交按钮
 *@return      通过返回true,否则返回false
 */
 function checkSubmitButton()
 {
    var msg = fm.prpLCollectNoSubmitMsg.value;
    if (msg=="") {
      return true;
    }
    alert(msg);
    return false;
 }