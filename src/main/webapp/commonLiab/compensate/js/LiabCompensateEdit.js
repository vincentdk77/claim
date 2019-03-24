/*****************************************************************************
 * DESC       ：实赔的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-05-19
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
  //add by qinyongli 股东业务提示 start 2005-7-31 
  var message = "";
  var shareHolderFlag = fm.shareHolderFlag.value;
  //add by hanliang end  2005-12-22
  //var payFee = parseInt(fm.prpLregistPayFee.value);
  var coinsFlag=parseInt(fm.coinsFlag.value);
  //if(payFee==-1){
    //alert("此保单保费未缴！");
  //} 
  //else if(payFee==0){
   // alert("此保单保费未缴全！");
  //}

  
  if(shareHolderFlag!=0){
     message = message + "当前处理的理算任务为为股东业务！\n";
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
  } 
  //add by qinyongli  end 2005-7-31 
  return true;
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
  var errorMessage = ""; 
  fm.buttonSaveType.value = saveType; 
  //textarea文本框设置值
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "赔款计算过程不允许为空\n";
  }     
    if(parseFloat(fm.prpLcompensateSumDutyPaid.value)>parseFloat(fm.prpLcompensateSumAmount.value)){
    errorMessage = errorMessage + "总赔偿金额不能大于总保险金额";
  }
  
      //新危险单位校验
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    alert("赔款合计不等于危险单位信息里的实赔金额！");
    return false;
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //增加实赔同预赔关系判断 begin
  if(fm.times.value == 1){//首次理算走实赔同预赔的校验，重开不走校验
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("责任赔款合计金额不能小于已预付赔款金额！");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("费用金额不能小于已预付费用金额！");
    return false;
  }
  }
  //增加实赔同预赔关系判断 end
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  //Engage_Data,lLoss_Data,PersonFeeLoss_Data,Person_Data,Charge_Data
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){ 
       	//add by lixiang start at 2006-8-1	
       //判断理算报告是不能为空的。	
       var 	context2=fm.prpLltextContextInnerHTML.value;
       var   lltext2title=fm.tdLltextTitle.value;
       
       if(context2.length<1){
         errorMessage = errorMessage +lltext2title+ "不允许为空\n";
          alert(errorMessage)
          return false;
       }
//       alert(context2.length)
//       return false;
      //add by lixiang end at 2006-8-1	   
  	//非案终计算书进行实赔金额是否大于估损金额的判断add by qinyongli 2005-09-20
  	/*由于国寿的要求，需要进行去掉这样的判断。
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
        //add end 2005-09-20
    /*
    if(underWriteFlag!=1){
     alert("核赔复核不通过时不能提交"); 
     return false;
    }*/
    //赔付标的信息或赔付人员信息二者其一必须填写，否则不能提交实赔
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
     var prpLchargeSerialNo = fm.prpLpersonLossSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    { 
     alert("赔款计算书中的赔付标的，赔付人员信息至少有一条记录!"); 
      return false; 
    }
  }

  
    if(fm.prpLcompensateRiskCode.value=="1528"){
    var claimLossLen = fm.prpLlossDtoKindCode.length;
     for(var i = 1; i < claimLossLen; i++) {
       if(fm.prpLlossDtoBrandCode[i].value==""||fm.prpLlossDtoCarNumber[i].value==""){
         alert("此险种财产损失赔付信息页面下车辆信息不能为空！");
         return false;
       }
    }
  }
  
    //共保理赔费用分摊
    var coinsFlag = fm.coinsFlag.value;	
	if(coinsFlag == "2"||coinsFlag == "1"){
	    var ChargeFeeFlag = fm.CommonCoinsChargeFeeFlag.value;	
	    if(ChargeFeeFlag == 1){
        	var prpLchargeChargeName = document.getElementsByName('prpLchargeChargeName');
        	var ChargeCoinsName = document.getElementsByName('ChargeCoinsName');
        	var size = document.getElementsByName('CoinsCode').length-1;
        	if(prpLchargeChargeName.length-1 != ChargeCoinsName.length/size){
        		alert("请点击共保信息页面下的共保费用分摊按钮！");
        		return false;
        	}
    	}
    }
  
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();
  
  return true;   	
}
 

/**
 @author      任轶群
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
 
 /**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinSave(){
   
   var policyNo = fm.prpLcompensatePolicyNo.value;
   var riskCode = fm.prpLcompensateRiskCode.value;
   var businessNo = fm.prpLcompensateClaimNo.value;
   var claimNo = fm.prpLcompensateClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=compe&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLcompensateClaimNo.value;

win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
 
//Modify By sunhao add begin 2004-09-06
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relate(){

		var policyNo = fm.prpLcompensatePolicyNo.value;
		var claimNo = fm.prpLcompensateClaimNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&claimNo=" +claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}
//Modify By sunhao add end 2004-09-06


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

  //解除锁定,否则无法传入下一页
  //fm.Sex.disabled = false;
  
  //保存数据
  //saveRecord("Loss");
  //saveRowRecordToSingleTable("PersonLoss","Kind");

  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.action="/claim/compensateGenerate.do";
  fm.target="fraCalculate";  
  //fm.target="_blank";  
  
  fm.submit();
  
  fm.action=oldAction;
  fm.target=oldTarget;   

  //清除数据
  //clearRecord("Loss");
  //clearRecord("PersonLoss");  
  //clearRowRecord("Kind");  
  
  //load data
  //loadRowRecord("PersonLoss","Kind","Kind_Data");  
  return true;
}   	


//按钮单击事件，用于条款的显示
function buttonOnClick(fieldObject)
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
function buttonOnClick2(strSubPageCode)
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
  ey = ey+10;
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 

//如果是案终赔付，则显示结案报告。
function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}



/**
 @author      liuyang
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
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
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
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;
  //免赔额计算以sumloss为标准  
  //if(Deductible==0)
  //{
  //    Deductible = SumLoss*DeductibleRate;
  //}
    if(DeductibleRate>1){
  	alert("免赔率不能大于100");
  	fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
  	return false;
  }

     //免赔额、免赔率如果输入只能输入其中一项
  if(DeductibleRate>0&&Deductible>0){
     alert("免赔率与免赔额只能输入一项");
     if(fieldname=="prpLlossDtoDeductible"){
           fm.all("prpLlossDtoDeductible")[findex].value="0";
     }else{
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
     }
     return false;
  }   
  if (Deductible == 0) {    //没有输入免赔额计算公式为 (标的-残值)*赔偿比例*-保额×免赔率
      //Realpay = (SumLoss - SumRest) * ClaimRate - Amount*DeductibleRate;  
      Realpay = (SumLoss - SumRest) * ClaimRate*(1-DeductibleRate);  
  } else {                 //输入免赔额后计算公式为 (标的-残值)*赔偿比例*-免赔额
      Realpay = (SumLoss - SumRest) * ClaimRate - Deductible;
  }
  
  //Realpay = (SumLoss - SumRest) * ClaimRate - Deductible;
  //fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  //add by qinyongli 2005-9-15
  //reason:只有主险才进行控制
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
		var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
		var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
		if(coinsPaidLossType == "2" ){ //录入“核定损失”时，计算共保总赔款信息
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay,2),2);
		}
		if(coinsPaidLossType == "1" ){ //录入“核定损失”时，计算共保总赔款信息
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay/coinsSelfRate*100,2),2);
		}
	}
  
     //modify by qinyongli 2005-10-28 责任险有可能保额为0，暂时隐藏控制
 if(Realpay>Amount)
 {
     alert("赔偿金额不能大于保险金额");
     fm.all("prpLlossDtoSumLoss")[findex].select();
     return false;
  }
  calFund();

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
  var sumRestAll        = 0;
  var chargeCurrency ; //赔偿币别
  var exchRate; 
  //计算责任赔款合计
  var i = 0;

  //1.赔款费用的计入赔款金额，以及其它费用
  var elements = getTableElements("Charge");
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
    //取兑换率，折人民币
    chargeCurrency = fm.all("prpLchargeCurrency")[i].value;
    if(chargeCurrency!="CNY")
    {
         for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==chargeCurrency && fm.exchCurrency[j].value=="CNY")
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
    }
    else
    {
        exchRate =1;
    }
    dblSumDutyPaid = dblSumDutyPaid * exchRate;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay);
    dblSumNoDutyFee = dblSumNoDutyFee * exchRate;
  }
  //2.赔付标的的赔偿金额
  //保存数据
  var lossData= getTableElements("lLoss");
  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  for( i = 1; i < fm.all("prpLlossDtoSumRealPay").length; i++ )
  {
    lossRealPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);
    sumRestAll       = sumRestAll + parseFloat(fm.all("prpLlossDtoSumRest")[i].value);  //残值
    if(isNaN(lossRealPay))
      lossRealPay = 0;

     //兑换币别
    currency4   = fm.all("prpLlossDtoCurrency3")[i].value;
    if(currency4!="CNY")
    {
         for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==currency4 && fm.exchCurrency[j].value=="CNY")
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
    }
    else
    {
       exchRate = 1;
    }
    lossRealPay = lossRealPay * exchRate;
    dblSumDutyPaid = dblSumDutyPaid + lossRealPay;
    
  }
   //3.赔付人员的赔付合计
  //保存数据
  //setCurrentRecord("PersonFeeLoss");

   var personLossData= getTableElements("PersonFeeLoss");

   var intPersonLossCount = personLossData.length;

   for( i = 1; i < fm.all("prpLpersonLossSumRealPay").length; i++ )
   {
     personLossRealPay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);
     if(isNaN(personLossRealPay))
       personLossRealPay = 0;
      //兑换币别
      currency4   = fm.all("prpLpersonLossCurrency")[i].value;
      if(currency4!="CNY")
      {
          for ( j=1;j<fm.baseCurrency.length;j++)
          {
              if(fm.baseCurrency[j].value==currency4 && fm.exchCurrency[j].value=="CNY")
              {
                 exchRate = fm.exchRate[j].value;
              }
          }
      }
      else
      {
          exchRate = 1;
      }
      personLossRealPay = personLossRealPay * exchRate;

     dblSumDutyPaid = dblSumDutyPaid + personLossRealPay;
   }
  //得到预赔金额
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //计算赔款合计
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;
  //计算实赔金额
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumRest.value      = point(round(sumRestAll,2),2);
  calCoinsFund();
}

function calCoinsFund() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	var SumNoDutyFee = fm.prpLcompensateSumNoDutyFee.value;
	var SumDutyPaid = fm.prpLcompensateSumDutyPaid.value;
	  // 取得当前的数据
	var realPay = parseFloat(fm.prpLcompensateSumPaid.value) ; 
	var findex=0;
	if(coinsFlag == "2"||coinsFlag == "1"){
		/*
		for(i=1;i<fm.all("prpLlossDtoCoinsSumRealPay").length;i++){
		    findex=i;
		    realPay = parseFloat(realPay) +  parseFloat(fm.all("prpLlossDtoCoinsSumRealPay")[findex].value ); 
		}
		*/
		
		var coinsSelfRate = parseFloat(fm.coinsSelfRate.value) ; 
		if(coinsPaidLossType == "1"){//100%份额赔付
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = point(round(realPay/coinsSelfRate*100 ,2),2); 
			fm.prpLcompensateCoinsOtherSumPaid.value =point(round(parseFloat(fm.prpLcompensateCoinsSumPaid.value) -  parseFloat(fm.prpLcompensateCoinsSelfSumPaid.value) ,2),2);
		}
		if(coinsPaidLossType == "2"){//我方份额赔付
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsOtherSumPaid.value = 0 ;
		}
		var dbCoinsSumPaid =  parseFloat(fm.prpLcompensateCoinsSumPaid.value) ; 
		if(coinsPaidLossType == "1"){//100%份额赔付
			for(i=0;i<fm.all("CoinsSerialNo").length;i++){
				//alert(fm.all("CoinsRate")[i].value);
				fm.all("CoinsSumpaid")[i].value = point(round((dbCoinsSumPaid-SumNoDutyFee/coinsSelfRate*100) * parseFloat(fm.all("CoinsRate")[i].value) / 100  ,2),2);
				//fm.all("CoinsSumpaid")[i].value = point(round((SumDutyPaid /(1-(parseFloat(fm.all("CoinsRate")[i].value) / 100))) * parseFloat(fm.all("CoinsRate")[i].value) / 100,2),2);
			}
		}
		if(coinsPaidLossType == "2"){//我方份额赔付
			for(i=0;i<fm.all("CoinsSerialNo").length;i++){
				//alert(fm.all("CoinsRate")[i].value);
				fm.all("CoinsSumpaid")[i].value = 0.00 ; 
			}
		}
		
	}
	
	}
 }
function checkCoinsPaidLossType() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	//var coinsSelfRate = fm.coinsSelfRate.value ; 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	
		if(coinsPaidLossType == null || coinsPaidLossType == ""){
			alert("共保业务，请选择赔案赔付类型！");
			return false ; 
		}
	}
	return true ; 
	
}
function calCoinsSumPaid(field) {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	  // 取得当前的数据
	var fieldname=field.name;
	var findex=0;
	for(i=1;i<fm.all(fieldname).length;i++){
	  if( fm.all(fieldname)[i] == field ){
	    findex=i;
	    break;
	  }
	}
	  //共保业务赔付类型判断
	var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
	var thisCoinsRealPay = parseFloat(fm.all("prpLlossDtoCoinsSumRealPay")[findex].value) ; 
	var amount = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
	var coinsSumAmount = point(round(amount/coinsSelfRate*100,2),2); 
	if(checkCoinsPaidLossType() == false ){
		fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		return false ; 
	}
	//alert("thisCoinsRealPay==="+thisCoinsRealPay+"===coinsSumAmount==="+coinsSumAmount);
	
		if(coinsPaidLossType == "2"){ // 按我方共保份额赔付
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		}
		//alert(coinsPaidLossType == "1");alert(coinsPaidLossType == 1);
		if(coinsPaidLossType == "1"){// 按赔案100%赔付
			thisCoinsRealPay = realPay/coinsSelfRate*100 ; 
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(thisCoinsRealPay,2),2);
			if(thisCoinsRealPay > coinsSumAmount){
				 alert("共保业务赔偿总金额不能大于险别共保总保险金额");
			     return false;
			}
		}
		
	}
	calCoinsFund();
	
 }
function changeCoinsSumPaid() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	  // 取得当前的数据
	var findex=0;
	for(i=1;i<fm.all("prpLlossDtoSumRealPay").length;i++){
	    findex=i;
	    var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
		
			if(coinsPaidLossType == "2"){ // 按我方共保份额赔付
				if(fm.prpLlossDtoCoinsSumRealPay != null){
					fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
				}
			}
			if(coinsPaidLossType == "1"){
				if(fm.prpLlossDtoCoinsSumRealPay != null){
					fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay/coinsSelfRate*100,2),2);
				}
			}
		}
	if(coinsPaidLossType == "1"){
		document.getElementById("CommonCoinsChargeFee").style.display="";
		fm.CommonCoinsChargeFeeFlag.value = '1';
	}else{
		document.getElementById("CommonCoinsChargeFee").style.display="none";
		fm.CommonCoinsChargeFeeFlag.value = '0';
	}
	}
	calCoinsFund();
}

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

  for( i = 1; i < fm.all("prpLlossDtoSumLoss").length; i++ )
  {
    LossSumLoss = parseFloat(fm.all("prpLlossDtoSumLoss")[i].value);

    if(isNaN(LossSumLoss))
      LossSumLoss = 0;

    dblSumLoss = dblSumLoss + LossSumLoss;
  }



  fm.prpLcompensateSumLoss.value  = point(round(dblSumLoss,2),2);
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
  var Amount;

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
  for(i=1;i<fm.all("prpLpersonLossSerialNo").length;i++) {
    if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("personLossSerialNo")[findex].value){
        findex1=i;
        break;
      }
  }
  DutyRate       = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[findex].value);
  DeductibleRate = parseFloat(fm.all("prpLpersonLossDeductibleRate")[findex].value);
  Deductible     = parseFloat(fm.all("prpLpersonLossDeductible")[findex].value); 
  Amount         = parseFloat(fm.all("prpLpersonLossAmount")[findex].value); 
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
  if(isNaN(Deductible))
    Deductible  = 0;
  /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 责任比例 * （1 - 免赔率）
   * # 此条取消----如果免赔额：（核定损失 - 残值）* 赔偿比例 * 责任比例  - 免赔额
   */
  if(DeductibleRate>1){
  	alert("免赔率不能大于100");
  	fm.all("prpLpersonLossDeductibleRate")[findex].value="0";
  	return false;
  }

     //免赔额、免赔率如果输入只能输入其中一项
  if(DeductibleRate>0&&Deductible>0){
     alert("免赔率与免赔额只能输入一项");
     if(fieldname=="prpLpersonLossDeductible"){
           fm.all("prpLpersonLossDeductible")[findex].value="0";
     }else{
           fm.all("prpLpersonLossDeductibleRate")[findex].value="0";
     }
     return false;
  }   
  if (Deductible == 0) {    //没有输入免赔额计算公式为 标的*赔偿比例*(1-免赔率)
      //Realpay = (SumLoss - SumRest) * ClaimRate - Amount*DeductibleRate;  
      Realpay = SumLoss * ClaimRate*(1-DeductibleRate);  
  } else {                 //输入免赔额后计算公式为 标的*赔偿比例-免赔额
      Realpay = SumLoss * ClaimRate - Deductible;
  }
   
   
   
   
  //temp = SumLoss * ClaimRate; //temp=（核定损失 * 赔偿比例 
  //Realpay = temp - Deductible;
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);
  
  
  //modify by qinyongli 2005-10-28 责任险有可能保额为0，暂时隐藏控制
  if(Realpay>Amount)
  {
       alert("赔偿金额不能大于保险金额");
       fm.all("prpLpersonLossSumLoss")[findex].select();
       return false;
  }
  
  //计算赔付人员中的赔付合计
  calSumRealpay(Field);
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();

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

function checkRepeatItemCode(field)
{
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
     
     var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
     var itemCode = fm.all("prpLlossDtoItemCode")[findex].value;
        
     //得到已经录入的险别和标的
     for( i = 1; i < fm.all("prpLlossDtoKindCode").length - 1; i++ )
     {       
         if(fm.all("prpLlossDtoKindCode")[i].value==kindCode && fm.all("prpLlossDtoItemCode")[i].value==itemCode
           && fm.all("prpLlossDtoSerialNo")[i].value!=fm.all("prpLlossDtoSerialNo")[findex].value
           &&fm.prpLcompensateRiskCode.value!="1516"&&fm.prpLcompensateRiskCode.value!="1542"&&fm.prpLcompensateRiskCode.value!="1528")
         {
             alert("您录入的险别和标的已经存在");
             fm.all("prpLlossDtoItemCode")[findex].value="";
             fm.all("prpLlossDtoLossName")[findex].value=""; 
             fm.all("prpLlossDtoAmount")[findex].value="";
             fm.all("prpLlossDtoAmountDisplay")[findex].value="";
             //fm.all("prpLlossDtoItemCode")[findex].focus();
         }
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
function validateAccount(){
	     
	     var pwd1=fm.prpLcompensateAccount.value;      
	     var pwd2=fm.prpLcompensateAccountOK.value;  	  
	     if(pwd2!=pwd1){
	              alert("两次输入的支付帐号不一致，请重新输入!");
				  fm.prpLcompensateAccount.value="";
				  fm.prpLcompensateAccountOK.value="";
				  fm.prpLcompensateAccount.focus();
	     }
	}
function relateCoinsTreatyNo(){

	var coinsTreatyNo = fm.CoinsTreatyNo.value;
    var reinsWebUrl= fm.reinsWebUrl.value;
    var newWindow = window.open(reinsWebUrl+"/fhcoinstreatyFacade.do?actionType=view&treatyNo="+coinsTreatyNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}

function feeCoinsCalculate(){
	 $.ajax({
			url:'/claim/compensateChargeFeeBeforeEdit.do'
			,type:'POST'
			,dataType:"text"
			,contentType: "application/x-www-form-urlencoded; charset=utf-8" 
			,data:$(document.fm).serialize()
			,success:function(result){
		 		$("#chargeInfo").html(result).show();
			}       
		});
}

