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
function changeCompensateFlag(flag)
{
  fm.GenerateCompensateFlag.value=flag;
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
  //默认展开特别约定
  var span = eval("spanEngage");
  span.style.display="";
  span.src="/claim/images/butExpandBlue.gif";

  calSumRealpayInit();
  calFund();
  calLoss();
  

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
    var personCount = parseInt(fm.personCount.value);
    var seatCount   = parseInt(fm.prpLcompensateSeatCount.value);
    var D3D4Count = 0;

/*  if((fm.prpLpersonLossSerialNo.length-1)>personCount)
    {
        alert("您录入的人员数量超过了立案的数量");
        return false;
  }
 */
  //add for :费用信息险别不能为空--start---------------

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
      /*
      if(parseFloat(fm.prpLchargeChargeAmount[j].value) != parseFloat(fm.prpLchargeChargeReport[j].value)){
      		if(parseFloat(fm.prpLchargeChargeAmount[j].value) != 0){
      			alert("计入赔款金额必须和损失金额相等或者为0，否则请分两条信息录入!");
      			return false;
      		}
      
      }
      */
   }    
   //是否进行了不计免赔的计算
   var sumDutyDeductibleFlag = fm.sumDutyDeductibleFlag;
   if(sumDutyDeductibleFlag != null && sumDutyDeductibleFlag.value != '1'){
        alert("请点击不计免赔计算按钮进行不计免赔特约险的赔款计算");
        return false;
   }
  //add for :费用信息险别不能为空--end---------------
 
  
  //控制驾驶员责任险只能赔付1人,车上人员<=核定座位数
  for(var j=1;j<fm.prpLpersonLossSerialNo.length;j++)
  {
      if(fm.prpLpersonLossKindCode[j].value=="D3")
      {
          D3Count = D3Count + 1;
      }
      if(fm.prpLpersonLossKindCode[j].value=="D4")
      {
          D4Count = D4Count + 1;
      }
  }
  D3D4Count = D3Count + D4Count;
  if(D3Count>1)
  {
      alert("驾驶员责任险只能赔偿1人");
      return false;
  }    
  if(D3D4Count>seatCount)
  {
      alert("车上人员责任险赔偿人数不能大于车辆核定载客数");
      return false;
  } 
 if( checkQuotaByKindCode()==false){
   fm.prpLctextContextInnerHTML.value="";
   return false;
    
 }
/*
  if(fm.GenerateCompensateFlag.value=="1"){
    alert("请生成理算报告");
    return false;
  }
*/ 
  //新危险单位校验
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }


 
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //textarea文本框设置值
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "理算报告不允许为空\n";
  }
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    errorMessage = errorMessage + "赔款合计不等于危险单位信息里的实赔金额";
  }
  
  //车险支付对象相关数据不能为空
  if(fm.prpLcompensateClassCode.value == '05'){
     var prpLcompensateOjectName  = fm.prpLcompensateOjectName.value;
     var prpLcompensateOjectCode  = fm.prpLcompensateOjectCode.value;
     if(prpLcompensateOjectName == ''){
       errorMessage = errorMessage + "支付对象值不能为空！";
     }else if(prpLcompensateOjectCode == ''){
       errorMessage = errorMessage + "支付对象证件号码值不能为空！";
     }
  }
  
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(!validateForm(fm,'Engage_Data,lLoss_Data,PersonFeeLoss_Data,CompensateLoss_Data,Person_Data,Charge_Data'))
  {
    return false;
  }

  fm.target="";
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){
    /*由于国寿的要求，需要进行去掉这样的判断。
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
        //add end 2005-09-20
        
    */
    /*
    if(underWriteFlag!=1){
     alert("核赔复核不通过时不能提交");
     return false;
    }
    */
    
    //理赔计算书提交前校验是否以前节点都处于提交状态
    if(checkSubmitButton() == false){
       return false;
    }
    //赔付标的信息或赔付人员信息二者其一必须填写，否则不能提交实赔
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLpersonLossSerialNo = fm.prpLpersonLossSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLpersonLossSerialNo == undefined)
    {
      alert("赔付标的信息或赔付人员信息二者其一必须填写，否则不能提交实赔");
      return false;
    }
    //是否打印的功能
    //if(window.confirm("需要打印计算书吗？")) {
    //  fm.prpLcompensatePrintFlag.value="1";
    //  //fm.target="_blank";
   // }
  }

    //如果是提交，判断是否不是nextNodeNo或者人员为空！！！！
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
  field.disabled = true;
  //modify by weishixin add end 20040616
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

  //解除锁定,否则无法传入下一页
  //fm.Sex.disabled = false;

  //保存数据
  //saveRecord("Loss");
  //saveRowRecordToSingleTable("PersonLoss","Kind");

  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.action="/claim/compensateGenerate.do";
  fm.target="fraCalculate";

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

//modify by wangli remark start 20050409
/*
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
 //modify by wangli remark end 20050409

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
  var realPays = document.getElementsByName("prpLchargeSumRealPay");
  var amounts  = document.getElementsByName("prpLchargeChargeAmount");
  for( i = 1; i < realPays.length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(realPays[i].value); //记入赔款
    chargeAmount  = parseFloat(amounts[i].value);  //费用
     
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

  var lossData= getTableElements("lLoss");

  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  var dblRealPayA = 0;    //车损险（A）总赔款金额
  var dblRealPayATotal = 0; //车损险（A）最终赔款金额，可能为空


  
  if(fm.prpLlossDtoSumRealPay!=undefined)
  {
  	var lossPays = document.getElementsByName("prpLlossDtoSumRealPay");
  	var kindCodes = document.getElementsByName("prpLlossDtoKindCode");
  	var typeCodes = document.getElementsByName("prpLlossDtoFeeTypeCode");
    for( i = 1; i < lossPays.length; i++ )
    {
      lossRealPay = parseFloat(lossPays[i].value);
    
      if(isNaN(lossRealPay))
        lossRealPay = 0;
    
      dblSumDutyPaid = dblSumDutyPaid + lossRealPay;
      //alert(fm.all("prpLlossDtoKindCode")[i].value+"|"+fm.all("prpLlossDtoFeeTypeCode")[i].value);
      //modify by dengxh update begin 20040914
      if((kindCodes[i].value=="A" || kindCodes[i].value=="B")&& typeCodes[i].value=='27')
      {
        dblRealPayAB = dblRealPayAB + lossRealPay;
      }
      //modify by dengxh update end 20040914
      //add by qinyongli 2006-01-12 begin  增加对车辆损失险金额的统计，用于减免赔额
      if(kindCodes[i].value=="A" ){
          dblRealPayA = dblRealPayA + lossRealPay;
      }
    }
  }

  var deductibleAall = parseFloat(fm.prpLDeductible.value);
  if(isNaN(deductibleAall))
      deductibleAall = 0;
  //用车损险赔款减去免赔额

  dblRealPayATotal = dblRealPayA - deductibleAall;

  dblSumDutyPaid = dblSumDutyPaid - deductibleAall;//如果减去免赔后的赔款大于0，则在总赔款中减去免赔额；
  fm.lastRealPay.value = dblRealPayATotal
 
  //add by qinyongli 2006-01-12 end

  //3.赔付人员的赔付合计
  //保存数据
  //setCurrentRecord("PersonFeeLoss");

  var personLossData= getTableElements("PersonFeeLoss");
  
  var intPersonLossCount = personLossData.length;
  var personPays = document.getElementsByName("prpLpersonLossSumRealPay");
  for( i = 1; i < personPays.length; i++ )
  {
    personLossRealPay = parseFloat(personPays[i].value);

    if(isNaN(personLossRealPay))
      personLossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + personLossRealPay;
  }

  //得到预赔金额
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value,10);
  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //计算赔款合计
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;

  //计算实赔金额
  //Modify by zhaolu 20060911 start
  //dblSumThisPaid  = dblSumPaid - dblSumPrePaid;
    dblSumThisPaid = dblSumDutyPaid - dblSumPrePaid;
  //Modify by zhaolu 20060911 end

  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumPaid,2),2);
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

  if(fm.prpLlossDtoSumLoss!=undefined)
  {
    for( i = 1; i < fm.all("prpLlossDtoSumLoss").length; i++ )
    {
      LossSumLoss = parseFloat(fm.all("prpLlossDtoSumLoss")[i].value);
    
      if(isNaN(LossSumLoss))
        LossSumLoss = 0;
    
      dblSumLoss = dblSumLoss + LossSumLoss;
    }
  } 

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
  var ChargeAmount = 0;         //费用金额
  var ChargeRealPay = 0;        //计入赔款金额

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
    var vPrpLchargeKindCode = fm.prpLchargeKindCode[findex].value; //险别代码
    if(chargeCode=='03' && vPrpLchargeKindCode != 'B'){
        fm.all("prpLchargeSumRealPay")[findex].value =parseFloat(chargeAmount);
    }else if(chargeCode=='03' && vPrpLchargeKindCode == 'B')
    {
    	//如果为第三者责任保险的施救费，则计入赔款金额不由实际费用连带出来，而是让用户输入
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
    var vPrpLchargeKindCode = fm.prpLchargeKindCode[findex].value; //险别代码
    //modify by lirj update begin 040508
    //reason:赔款费用中计入赔款金额自动带出且为只读
    ////ChargeCode="03"时表示施救费
    if(chargeCode=='03' && vPrpLchargeKindCode != 'B'){
        fm.all("prpLchargeSumRealPay")[findex].value = Field.value;
    }else if(chargeCode=='03' && vPrpLchargeKindCode == 'B'){
        //如果为第三者责任保险的施救费，则计入赔款金额不由实际费用连带出来，而是让用户输入
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

  if(round(parseFloat(fm.all("prpLchargeChargeReport")[findex].value),2) < round(parseFloat(fm.all("prpLchargeChargeAmount")[findex].value),2))
  {
  		errorMessage("实际费用不能超过费用金额！");
        Field.focus();
        Field.select();
        return false;
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
  var ChargeAmount = 0;         //费用金额
  var ChargeRealPay = 0;        //计入赔款金额
  
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
       fm.all("prpLpersonLossKindCode")[findex].value!="R" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="001" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="003" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="H" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="004"  )
    {
      alert("人员赔付信息中只允许录入第三者责任、驾驶员责任、乘客责任等赔付人员伤亡的险别！");
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
  var Realpay=0;          //赔款金额
  var SumRealpay=0;       //赔付合计
  var SumDefpay=0;       //核定赔偿合计
  var Defpay=0;

  var fieldname=field.name; //域名

  //定位
  var fieldNames = document.getElementsByName(fieldname);
  for(i=1;i<fieldNames.length;i++)
  {
    if( fieldNames[i] == field )
    {
      findex=i;
      break;
    }
  }

  //给变量赋值
  Realpay    = 0;
  SumRealpay = 0;

  //计算赔付合计
  var realPays 		= document.getElementsByName("prpLpersonLossSumRealPay");
  var serialNos 	= document.getElementsByName("personLossSerialNo");
  var prpSerialNos	= document.getElementsByName("prpLpersonLossSerialNo");
  var defPays 		= document.getElementsByName("prpLpersonLossSumDefPay");
  for(i=1;i<realPays.length;i++)
  {
    if(serialNos[i].value==serialNos[findex].value){
      Realpay = parseFloat(realPays[i].value);
      Defpay =  parseFloat(defPays[i].value);
      if(isNaN(Realpay))        Realpay = 0;
      if(isNaN(Defpay))        Defpay = 0;
      SumRealpay = SumRealpay + Realpay;
       SumDefpay = SumDefpay +Defpay;
    }
  }
  var findex1 = 0;
  var dutyRates = document.getElementsByName("prpLpersonLossIndemnityDutyRate");
  for(i=1;i<dutyRates.length;i++) {
    if(getElementCount("personLossSerialNo")>1)
    {
       if(prpSerialNos[i].value==serialNos[findex].value){
          findex1=i;
          break;
       }
    }
  }
  //将用来显示的赔付合计设置到界面上
  document.getElementsByName("prpLpersonLossSumRealPay1")[findex1].value =  point(round(SumRealpay,2),2);
  document.getElementsByName("prpLpersonLossSumDefPay1")[findex1].value =  point(round(SumDefpay,2),2);
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
  SumDefPay        = parseFloat(fm.all("prpLpersonLossSumDefPay")[findex].value);
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
  if(isNaN(SumDefPay))
   SumDefPay = 0;
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
  temp = (SumDefPay) * ClaimRate * DutyRate; //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例  //LYM
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
  var Defpay =0;       //赔付合计
   var SumDefpay =0;       //赔付合计
  //定位
  for(i=0;i<fm.all("prpLpersonLossSumRealPay1").length;i++)
  {
    //给变量赋值
    Realpay    = 0;
    SumRealpay = 0;
    Defpay =0;   
    SumDefpay =0;    

    //计算赔付合计
    for(j=0;j<fm.all("prpLpersonLossSumRealPay").length;j++)
    {
      if(fm.all("personLossSerialNo")[j].value==fm.all("prpLpersonLossSerialNo")[i].value){
        Realpay = parseFloat(fm.all("prpLpersonLossSumRealPay")[j].value);
       Defpay =  parseFloat(fm.all("prpLpersonLossSumDefPay")[j].value);
        if(isNaN(Realpay))          Realpay = 0;
          if(isNaN(Defpay))          Defpay = 0;
        SumDefpay = SumDefpay +Defpay
        SumRealpay = SumRealpay + Realpay;
      }
    }

    //将用来显示的赔付合计设置到界面上
    fm.all("prpLpersonLossSumRealPay1")[i].value =  point(round(SumRealpay,2),2);
     fm.all("prpLpersonLossSumDefPay1")[i].value =  point(round(SumDefpay,2),2);
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
       /*
       //setReadonlyOfElementOfLoss(fm.LossSumRest); //放开残值，可手工输入。
       setReadonlyOfElementOfLoss(fm.prpLlossDtoItemValue[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoSumLoss[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoIndemnityDutyRate[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoLossQuantity[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoClaimRate[index1]);
       setReadonlyOfElementOfLoss(fm.prpLlossDtoDeductibleRate[index1]);
       undoSetReadonlyOfElementOfLoss(fm.prpLlossDtoSumRest[index1]);
       */
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
     /*
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
    }
    */
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

  var SumDefPay       //核定赔偿
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var ArrangeRate;    //协商赔款比例
  var Realpay;        //赔付金额
  var temp;

  var fieldname=field.name; //域名

  //定位
  var fieldNames = document.getElementsByName(fieldname);
  for(i=1;i<fieldNames.length;i++)
  {
    if( fieldNames[i] == field )
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
  var personDutyRates		= document.getElementsByName("prpLpersonLossIndemnityDutyRate");
  var prpLseriaNos  		= document.getElementsByName("prpLpersonLossSerialNo");
  var seriaNos	    		= document.getElementsByName("personLossSerialNo");
  var arrangRates 			= document.getElementsByName("prpLpersonLossArrangeRate");
  var dutyDeductibleRates 	= document.getElementsByName("prpLpersonLossDutyDeductibleRate");
  var driverRates 			= document.getElementsByName("prpLpersonLossDriverDeductibleRate");
  var deductRates 			= document.getElementsByName("prpLpersonLossDeductibleRate");
  var kindRates 			= document.getElementsByName("prpLpersonLossMainKindDeductibleRate");
  var amounts 				= document.getElementsByName("prpLpersonLossAmount");
  for(i=1;i<personDutyRates.length;i++) {
    if(getElementCount("personLossSerialNo")>1)
    {
       if(prpLseriaNos[i].value==seriaNos[findex].value){
          findex1=i;
          break;
       }
    }
  }
  DutyRate = parseFloat(personDutyRates[findex1].value);
  ArrangeRate = parseFloat(arrangRates[findex1].value);
  DutyDeductibleRate = parseFloat(dutyDeductibleRates[findex1].value);
  DriverDeductibleRate = parseFloat(driverRates[findex1].value);
  DeductibleRate = parseFloat(deductRates[findex1].value);
  MainKindDeductibleRate=parseFloat(kindRates[findex1].value);
  Amount         = parseFloat(amounts[findex1].value);
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
  SumDefPay      = 0;
  
  var realPays   = document.getElementsByName("prpLpersonLossSumRealPay");
  var sumLosses  = document.getElementsByName("prpLpersonLossSumLoss");
  var sumDefPays = document.getElementsByName("prpLpersonLossSumDefPay");
  var claimRates = document.getElementsByName("prpLpersonLossClaimRate");
  var kindCodes  = document.getElementsByName("prpLpersonLossKindCode");
  for(i=1;i<realPays.length;i++)
  {
	    if(seriaNos[i].value==prpLseriaNos[findex].value){
	
	    SumLoss   = parseFloat(sumLosses[i].value);
	    SumDefPay = parseFloat(sumDefPays[i].value);
	    ClaimRate = parseFloat(claimRates[i].value);
	
	    if(isNaN(SumDefPay))
	      SumDefPay = 0;
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
	     //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例 * 协商赔偿比例   R 和 H不需要计算责任比例 
	    if(kindCodes[findex].value=="R" || kindCodes[findex].value=="H"){
	    	temp = (SumDefPay ) * ClaimRate * ArrangeRate; 
	    }
	    else{
	    	temp = (SumDefPay ) * ClaimRate * DutyRate * ArrangeRate; 
	    }
	    Deductibletemp = temp * DeductibleRate;  //免赔= temp * 免赔率
	
	    //应 需求,屏蔽绝对免赔率
	    MainKindDeductibleRate = 0;
	    //部分险别需要承上所在主险的绝对免赔率
	    if(kindCodes[findex].value=="D4"){
	        Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-DriverDeductibleRate);
	    }
	    else if(kindCodes[findex].value=="R" || kindCodes[findex].value=="H"){
	    	Realpay =  temp *(1 - DeductibleRate);
	    }
	    else{
	        Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate);
	    }
	    
	    realPays[i].value = point(round(Realpay,2),2);
    }
  }

  //计算赔付人员中的赔付合计
  calSumRealpay(field);

  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();

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
     var vURL = CoreWebUrl +'/'+ RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
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
  var ArrangeRate;      //协商赔偿比例
  var Realpay;        //赔偿金额
  var  KindAmount = 0;    //赔偿限额
  var CISumRealPay      //交强险赔款金额
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
  
      //实际损失
      SumLoss               = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
      //残值
      SumRest               = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
       //核定赔偿
      SumDefPay             = parseFloat(fm.all("prpLlossDtoSumDefPay")[findex].value);
      //承保比例
      ClaimRate             = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
      //事故责任比例
      DutyRate              = parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
      //协商赔偿比例
      ArrangeRate           = parseFloat(fm.all("prpLlossDtoArrangeRate")[findex].value);
      //事故责任免赔率
      DutyDeductibleRate    = parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[findex].value);
      //绝对免赔率
      DeductibleRate        = parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
      //交强险赔款金额
      CISumRealPay          = parseFloat(fm.all("prpLlossDtoCISumRealPay")[findex].value);
      
      unitPrice             = parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].value);
      Amount                = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
      //免赔额
      if(fm.prpLDeductible != null){
            Deductible = fm.prpLDeductible.value;
      }
        
  }catch(E)
  {
    
  }
  if(isNaN(Amount))
    Amount = 0;
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(SumDefPay))
    SumDefPay = 0;
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
   if(isNaN(CISumRealPay))
    CISumRealPay = 0;

   /*计算赔款金额
   * 如果免赔高：（核定损失 - 残值）* 赔偿比例 * 协商免赔率 * 责任比例 * （1 - 免赔率）
   */
  try{
      var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;      
	/*
	 *取赔偿限额
	*/
	    for(var i=0;i< fm.all("kindCode").length;i++){
	        if(kindCode == fm.all("kindCode")[i].value){
	           KindAmount = parseFloat( fm.all("kindAmount")[i].value);
	              if(isNaN(KindAmount))
	                KindAmount = 0;
	              break;
	        }	        
	    }    
	  
      if( kindCode == "A"
        ||kindCode == "B"
        ||kindCode == "D3"
        ||kindCode == "D4"
        ||kindCode == "D2"
        ||kindCode == "X"
        ||kindCode == "K6"
        ){      
        //这些险种需要按责任比例计算
        temp = (SumDefPay) * ClaimRate * ArrangeRate* DutyRate;  //LYM 20060620
      }else{
        //其它险种不需要按责任比例计算
        temp = (SumDefPay) * ClaimRate * ArrangeRate ;   //LYM 20060620
      }
 
        /*
          赔款＝核定赔偿×赔偿比例×协商比例(1-责任免赔率)（1-绝对免赔率）.
          或者,赔款＝核定赔偿×赔偿比例×协商比例*责任比例×(1-责任免赔率)（1-绝对免赔率）.
          若有的险别不适合该公式，则在接下来的程序进行调整
        */
        
        Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate); 
        /**
         *险别没有责任免赔率，但有绝对免赔率的。
         *包含：全车盗抢险、车轮单独损坏险、车身划痕损失险、自燃损失险、附加油污污染责任险、附加高尔夫球具盗窃险、交通事故精神损害赔偿险
         */
        if(  kindCode == "K16"
           ||kindCode == "L"
           ||kindCode == "Z"
           ||kindCode == "H"
           ||kindCode == "V1"
           ||kindCode == "G0"
           ||kindCode == "R"
           ){                                       
            Realpay =  temp * (1 - DeductibleRate);
        }
        /*
         全车盗抢险，需判断是否发生了“全车被盗、抢，……两个月内未查明下落”的免赔条件，如发生，则需要计算绝对免赔率，反之，则全赔。
        */
        if(kindCode == "G"){
                var conditionsFlag = 0; //全车盗抢险是否有“全车被盗、抢，自立案起两个月未查明下落”这个免赔条件的标识，0－没有，1－有
                for(i = 0;i < fm.all("deductCondition").length;i++){       
                    if( fm.all("deductCondition")[i].value == "290" && fm.all("Times")[i].value == "1"){
                            conditionsFlag = 1;
                            break;
                    }                
                }
                if(conditionsFlag == 1){
                    Realpay = temp * (1 - DeductibleRate);
                }else{
                    Realpay = temp ;
                }            
        }        
        /*
         险别既没有责任免赔率，也没有绝对免赔率的。
         包括：玻璃单独破碎险、涉水行驶损失险、涉水行驶损失险、玻璃单独破碎险、保险事故附随费用损失险、换件特约险 
			 代步车费用险、车辆停驶损失险、车辆重置特约险A、车辆重置特约险B、随车行李物品损失险
         
        */
        if(kindCode == "F" || kindCode == "X3" || kindCode =="K6" || kindCode == "K10" || kindCode =="U" || 
           kindCode == "C" || kindCode == "T"  || kindCode =="NX" || kindCode == "NY"  || kindCode =="X4"
           ){
            
            Realpay =  temp ;
           
        }
        /*需要减去免赔额
          包括:车辆损失险。由于车损险可以录入多条,所以这里来判断了只有第一条的时候减去免陪额.
        */
        /* 计算合计的时候减过车损险免陪额，这儿不用减了.
        if(kindCode == "A"){
       		for (var k = 1;k<fm.all("prpLlossDtoKindCode").length;k++){
        	 	if(fm.all("prpLlossDtoKindCode")[k].value =="A"){
        	 		if(fm.all("prpLlossDtoKindCode")[findex] != fm.all("prpLlossDtoKindCode")[k]){
        	 			 Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate);
        	 		}
        	 		else{
        	 			Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate) - Deductible;
        	 		}
        	 		break;
        	 	}
        	 }	
        }
        */
        //不计免赔率特约条险
        if(kindCode == "M"){
            Realpay = SumDefPay;
        }
        /*
        * 赔偿金额超出赔偿限额时
        */
        if(kindCode == "Z" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("自燃损失险的赔款金额大于该险别的保险金额（" +KindAmount+ "）,所以赔偿金额为：" +KindAmount);
        }else if(kindCode == "X3" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("涉水行驶损失险的赔款金额大于该险别的保险金额（" +KindAmount+ "）,所以赔偿金额为：" +KindAmount);
        }else if(kindCode == "L" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("车身划痕损失险的赔款金额大于该险别的保险金额（" +KindAmount+ "）,所以赔偿金额为：" +KindAmount);
        }else if(kindCode =="D2" && (Realpay >KindAmount)){
            Realpay = KindAmount;
            alert( "车上货物责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);               
        }else if(kindCode == "X" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "新增加设备损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "K6" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "随车行李物品损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "K10" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "保险事故附随费用损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "H" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "车载货物掉落责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "R" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "交通事故精神损害赔偿险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "C" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "代步车费用险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "V1" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "附加油污污染责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "X4" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "系安全带补偿险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }
        
	    SumDefPay = SumLoss - SumRest - CISumRealPay;  
	    fm.all("prpLlossDtoSumDefPay")[findex].value = point(round(SumDefPay,2),2);
	
	    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
    }catch(E)
    {
    }
    //modify by caopeng end at 2005-12-23 增加try,catch块，屏蔽一些非正常操作带来的js错误
    calFund();
    checkQuotaByKindCode();
    
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
  var ArrangeRate;      //协商赔偿比例
  var Realpay;        //赔偿金额
  var SumDefPay;      //核定赔偿
  var  KindAmount = 0;    //赔偿限额
  var temp;
  var unitPrice;
  var Amount;

  var findex=0;
  var sumLossess  		= document.getElementsByName("prpLlossDtoSumLoss");
  var sumRests 			= document.getElementsByName("prpLlossDtoSumRest");
  var sumDefPays 		= document.getElementsByName("prpLlossDtoSumDefPay");
  var claimRates 		= document.getElementsByName("prpLlossDtoClaimRate");
  var dutyRates 		= document.getElementsByName("prpLlossDtoIndemnityDutyRate");
  var arrangeRates		= document.getElementsByName("prpLlossDtoArrangeRate");
  var dutyDeductRates 	= document.getElementsByName("prpLlossDtoDutyDeductibleRate");
  var deductRates 		= document.getElementsByName("prpLlossDtoDeductibleRate");
  var unitPrices 		= document.getElementsByName("prpLlossDtoUnitPrice");
  var mounts 			= document.getElementsByName("prpLlossDtoAmount");
  var kindCodes 		= document.getElementsByName("prpLlossDtoKindCode");
  var kinds 			= document.getElementsByName("kindCode");
  var kindMounts 		= document.getElementsByName("kindAmount");
  var realPays 			= document.getElementsByName("prpLlossDtoSumRealPay");
  var conditions 		= document.getElementsByName("deductCondition");
  var deductNames 		= document.getElementsByName("deductName");
  var times 			= document.getElementsByName("Times");
  for(var i=1;i<sumLossess.length;i++){
    findex=i;
    SumLoss             = parseFloat(sumLossess[findex].value);
    SumRest             = parseFloat(sumRests[findex].value);
    SumDefPay           = parseFloat(sumDefPays[findex].value);
    ClaimRate           = parseFloat(claimRates[findex].value);
    DutyRate            = parseFloat(dutyRates[findex].value);
    //协商赔偿比例
    ArrangeRate         = parseFloat(arrangeRates[findex].value);
    DutyDeductibleRate  = parseFloat(dutyDeductRates[findex].value);
    DeductibleRate      = parseFloat(deductRates[findex].value);
    unitPrice           = parseFloat(unitPrices[findex].value);
    Amount              = parseFloat(mounts[findex].value);
    //免赔额
      if(fm.prpLDeductible != null){
            Deductible = fm.prpLDeductible.value;
      }
      
    if(isNaN(Amount))   Amount = 0;
    if(isNaN(SumLoss))  SumLoss = 0;
    if(isNaN(SumRest))  SumRest = 0;
    if(isNaN(SumDefPay))  SumDefPay = 0;
    if(isNaN(Deductible))   Deductible = 0;
    if(isNaN(unitPrice))    unitPrice = 0;
    if(isNaN(SumDefPay)) SumDefPay = 0;
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
    var kindCode = kindCodes[findex].value;      
	/*
	 *取赔偿限额
	*/
	    for(var j=0;j< kinds.length;j++){
	        if(kindCode == kinds[j].value){
	           KindAmount = parseFloat(kindMounts[j].value);
	              if(isNaN(KindAmount))
	                KindAmount = 0;
	              break;
	        }	        
	    }    
	  
      if( kindCode == "A"
        ||kindCode == "B"
        ||kindCode == "D3"
        ||kindCode == "D4"
        ||kindCode == "D2"
        ||kindCode == "X"
        ||kindCode == "K6"
        ){      
        //这些险种需要按责任比例计算
        temp = (SumDefPay) * ClaimRate * ArrangeRate* DutyRate;  //LYM 20060620
      }else{
        //其它险种不需要按责任比例计算
        temp = (SumDefPay) * ClaimRate * ArrangeRate ;   //LYM 20060620
      }
 
        /*
          赔款＝核定赔偿×赔偿比例×协商比例(1-责任免赔率)（1-绝对免赔率）.
          或者,赔款＝核定赔偿×赔偿比例×协商比例*责任比例×(1-责任免赔率)（1-绝对免赔率）.
          若有的险别不适合该公式，则在接下来的程序进行调整
        */
        
        Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate); 
        /**
         *险别没有责任免赔率，但有绝对免赔率的。
         *包含：全车盗抢险、车轮单独损坏险、车身划痕损失险、自燃损失险、附加油污污染责任险、附加高尔夫球具盗窃险、交通事故精神损害赔偿险
         */
        if(  kindCode == "K16"
           ||kindCode == "L"
           ||kindCode == "Z"
           ||kindCode == "H"
           ||kindCode == "V1"
           ||kindCode == "G0"
           ||kindCode == "R"
           ){                                       
            Realpay =  temp * (1 - DeductibleRate);
        }
        /*
         全车盗抢险，需判断是否发生了“全车被盗、抢，……两个月内未查明下落”的免赔条件，如发生，则需要计算绝对免赔率，反之，则全赔。
        */
        if(kindCode == "G"){
                var conditionsFlag = 0; //全车盗抢险是否有“全车被盗、抢，自立案起两个月未查明下落”这个免赔条件的标识，0－没有，1－有
                for(var j = 0;j < conditions.length;j++){       
                    if(conditions[j].value == "290" && times.value == "1"){
                            conditionsFlag = 1;
                            break;
                    }                
                }
                if(conditionsFlag == 1){
                    Realpay = temp * (1 - DeductibleRate);
                }else{
                    Realpay = temp ;
                }            
        }        
        /*
         险别既没有责任免赔率，也没有绝对免赔率的。
         包括：玻璃单独破碎险、涉水行驶损失险、涉水行驶损失险、玻璃单独破碎险、保险事故附随费用损失险、换件特约险 
			 代步车费用险、车辆停驶损失险、车辆重置特约险A、车辆重置特约险B
         
        */
        if(kindCode == "F" || kindCode == "X3" || kindCode =="K6" || kindCode == "K10" || kindCode =="U" || 
           kindCode == "C" || kindCode == "T"  || kindCode =="NX" || kindCode == "NY"  || kindCode =="X4"
           ){
            
            Realpay =  temp ;
           
        }
        /*需要减去免赔额
          包括:车辆损失险、
        */
        /*计算合计的时候减过车损险免陪额，这儿不用减了.
        if(kindCode == "A"){
       		for (var k = 1;k<fm.all("prpLlossDtoKindCode").length;k++){
        	 	if(fm.all("prpLlossDtoKindCode")[k].value =="A"){
        	 		if(fm.all("prpLlossDtoKindCode")[findex] != fm.all("prpLlossDtoKindCode")[k]){
        	 			 Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate);
        	 		}
        	 		else{
        	 			Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate) - Deductible;
        	 		}
        	 		break;
        	 	}
       	 	}
        }
        */
        //不计免赔率特约条险
        if(kindCode == "M"){
            Realpay = SumDefPay;
        }
        /*
        * 赔偿金额超出赔偿限额时
        */
        if(kindCode == "Z" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("自燃损失险的赔款金额大于该险别的保险金额（" +KindAmount+ "）,所以赔偿金额为：" +KindAmount);
        }else if(kindCode == "X3" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("涉水行驶损失险的赔款金额大于该险别的保险金额（" +KindAmount+ "）,所以赔偿金额为：" +KindAmount);
        }else if(kindCode == "L" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("车身划痕损失险的赔款金额大于该险别的保险金额（" +KindAmount+ "）,所以赔偿金额为：" +KindAmount);
        }else if(kindCode =="D2" && (Realpay >KindAmount)){
            Realpay = KindAmount;
            alert( "车上货物责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);               
        }else if(kindCode == "X" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "新增加设备损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "K6" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "随车行李物品损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "K10" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "保险事故附随费用损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "H" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "车载货物掉落责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "R" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "交通事故精神损害赔偿险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "C" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "代步车费用险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "V1" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "附加油污污染责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }else if(kindCode == "X4" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "系安全带补偿险赔偿金额超过了赔偿限额("+KindAmount +" 元),所以赔偿金额为：" + KindAmount);
        }
     
    realPays[findex].value = point(round(Realpay,2),2);
  } 
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
  checkQuotaByKindCode();
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
  var ArrangeRate;    //协商赔偿比例
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
  SumLoss           = parseFloat(fm.all("prpLpersonLossSumLoss")[findex].value);
  SumDefPay         = parseFloat(fm.all("prpLpersonLossSumDefPay")[findex].value);
  ClaimRate         = parseFloat(fm.all("prpLpersonLossClaimRate")[findex].value);
  SumRest           = 0;   
  DeductibleRate    = 0;
  Deductible        = 0;   
  Deductibletemp    = 0;
  DutyRate          = 0;
  ArrangeRate       = 0;
  Realpay           = 0;
  temp                  = 0;
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
  //Amount                =parseFloat(fm.all("prpLpersonLossAmount")[findex1].value); 
 // alert( "Amount=="+Amount);
  if(isNaN(SumLoss)) SumLoss = 0;  //
  if(isNaN(SumDefPay)) SumDefPay = 0;  //LYM 20060620
  
  
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
  if(fm.all("prpLpersonLossKindCode")[findex1].value == "R" || fm.all("prpLpersonLossKindCode")[findex1].value =="H"){
 	 temp = (SumDefPay) * ClaimRate * ArrangeRate; //temp=（核定损失 - 残值）* 赔偿比例 * 责任比例  //LYM 20060620
  }
  else{
  	 temp = (SumDefPay) * ClaimRate * DutyRate * ArrangeRate; 
  }
  Deductibletemp = temp * DeductibleRate; //免赔= temp * 免赔率
   

  //================绝对免赔率==============================
  //部分险别需要承上所在主险的绝对免赔率
  if(fm.all("prpLpersonLossKindCode")[findex1].value=="D2" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D3" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D4" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="G0" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="L" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="Z" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="X" 
      ){
     Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate)*(1-MainKindDeductibleRate);
  }
  else if(fm.all("prpLpersonLossKindCode")[findex1].value=="H" ||
  		  fm.all("prpLpersonLossKindCode")[findex1].value=="R" ){
  	 Realpay =  temp *(1 - DeductibleRate);
  }
  else{
    Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate);
    
  }
/*=====================国元====================*/
  if(fm.all("prpLpersonLossKindCode")[findex1].value=="B"  ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D3" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D4"){
     Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate);
  }
//  if(temp>Amount){
  //    Realpay = Amount*(1-DutyDeductibleRate)*(1 - DeductibleRate);
     
 //}
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);


  //计算赔付人员中的赔付合计
  calSumRealpay(Field);
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
}

function setRealPay(){
    for(i=1;i<fm.all("prpLchargeSerialNo").length;i++){
        //ChargeCode="03"时表示施救费
        if (fm.all("prpLchargeChargeCode")[i].value=="03"){
        	if(fm.all("prpLchargeKindCode")[i].value != "B")
        	{
	            fm.all("prpLchargeSumRealPay")[i].value = fm.all("prpLchargeChargeAmount")[i].value;
        	}
        }else{
            fm.all("prpLchargeSumRealPay")[i].value = 0;
        }
    }
    calFund();
}



function calSumPropAndPerson()
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

  var allCompelPropLimit=0;
  var allCompelMedicalLimit=0;
  var allCompelDeformityLimit=0;

  var allSuperCompelPropPrice=0;
  var allSuperCompelMedicalPrice=0;
  var allSuperCompelDeformityPrice=0;  

  
  var wealthTitle=["财产损失","0","1000","2000","50","26000","10000","10","10","8100","8100"];
  var medicalTitle=["医疗费用","0","20000","2000","50","26000","10000","10","10","8100","8100"];
  var deformityTitle=["死亡残疾","0","40000","2000","50","26000","10000","10","10","8100","8100"];
  var kindcodetype="B";

/*
  allCompelPropLimit        = fm.allCompelPropLimit.value
  allCompelMedicalLimit         = fm.allCompelMedicalLimit.value
  allCompelDeformityLimit       = fm.allCompelDeformityLimit.value
//===============================================================
  allSuperCompelPropPrice       = fm.allSuperCompelPropPrice.value
  allSuperCompelMedicalPrice    = fm.allSuperCompelMedicalPrice.value
  allSuperCompelDeformityPrice  = fm.allSuperCompelDeformityPrice.value
*/


    

  for(i=1;i<fm.all("propLicenseNo").length;i++)
  {
   allPropPrice = allPropPrice+ (parseFloat(fm.all("propSumLoss")[i].value)-parseFloat(fm.all("propEliminate")[i].value));
   
  }

  if(isNaN(allPropPrice))
    allPropPrice= 0;

  for(i=1;i<fm.all("personMedicalSerialNo").length;i++)
  {
   allMedicalPrice =allMedicalPrice+ (parseFloat(fm.all("prpLpersonMedicalSumLoss")[i].value)-parseFloat(fm.all("prpLpersonMedicalRejectSum")[i].value));
  }
  if(isNaN(allMedicalPrice))
    allMedicalPrice= 0;

  for(i=1;i<fm.all("personDeformitySerialNo").length;i++)
  {
   allDeformityPrice  =  allDeformityPrice+(parseFloat(fm.all("prpLpersonDeformitySumLoss")[i].value)-parseFloat(fm.all("prpLpersonDeformityRejectSum")[i].value));
  }
  if(isNaN(allDeformityPrice))
    allDeformityPrice= 0;




                            qindex++;
  wealthTitle[qindex]=allPropPrice;
  medicalTitle[qindex]=allMedicalPrice;
  deformityTitle[qindex]=allDeformityPrice;
                            qindex++;
  wealthTitle[qindex]=allCompelPropLimit;
  medicalTitle[qindex]=allCompelMedicalLimit;
  deformityTitle[qindex]=allCompelDeformityLimit;
                            qindex++;
  wealthTitle[qindex]=allSuperCompelPropPrice;
  medicalTitle[qindex]=allSuperCompelMedicalPrice;
  deformityTitle[qindex]=allSuperCompelDeformityPrice;



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
}
/**
*
*检测该险别是否可以录入残值
*/
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
  if(fm.all("prpLlossDtoKindCode")[findex].value=="B" && fm.all("prpLlossDtoFeeTypeCode")[findex].value!="27"){
    alert("B险别不允许录入残值！");
    setReadonlyOfElementOfLoss(fm.all("prpLlossDtoSumRest")[findex]);
    fm.all("prpLlossDtoSumRest")[findex].value="0.00";
  }
}

/**
*
*修改该案的事故责任比例时将各项损失的事故责任比例改为该案的事故责任比例 
*/
function setAllIndemnityDutyRate()
 {  
  var i = 0;
  var indemnityDutyRate=0;
  
  indemnityDutyRate= parseFloat(fm.prpLcompensateIndemnityDutyRate.value);
  if(isNaN(indemnityDutyRate)||indemnityDutyRate.length<1){
      indemnityDutyRate = 0;
  }
  var  dutyRates = document.getElementsByName("prpLlossDtoIndemnityDutyRate");
  if( dutyRates.length !='undefined'  &&  dutyRates.length >0){
    for(i=1;i<dutyRates.length;i++)
    {
    	dutyRates[i].value=indemnityDutyRate;
    } 
   }
  dutyRates =document.getElementsByName("prpLpersonLossIndemnityDutyRate");
  if( dutyRates.length !='undefined'  &&  dutyRates.length >1){
    for(i=1;i<dutyRates.length;i++)
    {
    	dutyRates[i].value=indemnityDutyRate;
    	calRealpay2ForSunny(dutyRates[i]);
    } 
  }

  calRealpayForDuBangAll();
 //if( fm.all("prpLpersonLossIndemnityDutyRate").length !='undefined'  &&  fm.all("prpLpersonLossIndemnityDutyRate").length >1){

 // if(fm.all("prpLpersonLossIndemnityDutyRate").length>0){
 //     for(i=1;i<fm.all("prpLpersonLossIndemnityDutyRate").length;i++){
 //          calRealpay2ForSunny(fm.all("prpLpersonLossIndemnityDutyRate")[i]); 
 //      }
 // }
 //}
  return true;  
}


//商业险是否超过限额判断
function  checkQuotaByKindCode(){
  //暂时只考虑kindCode='B'
  var indemnityDutyRate; //责任比例
  

  //
  indemnityDutyRate = fm.prpLcompensateIndemnityDutyRate.value;
  if ( isNaN(indemnityDutyRate)) 
        indemnityDutyRate=0;
  else
        indemnityDutyRate = indemnityDutyRate/100;
   
  var kindCodes 		= document.getElementsByName("kindCode");
  var lossCodes 		= document.getElementsByName("prpLlossDtoKindCode");
  var kindAmounts 		= document.getElementsByName("kindAmount");
  var defPays 			= document.getElementsByName("prpLlossDtoSumDefPay");
  var arrangRates 		= document.getElementsByName("prpLlossDtoArrangeRate");
  var deductRates 		= document.getElementsByName("prpLlossDtoDeductibleRate");
  var dutyRates 		= document.getElementsByName("prpLlossDtoDutyDeductibleRate");
  var personKindCodes 	= document.getElementsByName("prpLpersonLossKindCode");
  var personDefPay1s 	= document.getElementsByName("prpLpersonLossSumDefPay1");
  var personDutyRates 	= document.getElementsByName("prpLpersonLossIndemnityDutyRate");
  var personArrangRates = document.getElementsByName("prpLpersonLossArrangeRate");
  for(var i=0;i< kindCodes.length;i++){
    var sumRealPayTemp  =0;
    var sumRealPay  =0;
    var sumRealPayNoDutyRate = 0;
    var kindCodeCount = 0; //险别的赔款记录数
    var ArrangeRate;       //协商赔偿比例
    var DeductRate         //绝对免赔率
    var DutyDeductRate     //责任免赔率
    var  kindCode = kindCodes[i].value ;
    var  KindAmount = parseFloat(kindAmounts[i].value);
   
    if(lossCodes != null && lossCodes.length != null) {      
      for (var k=1;k < lossCodes.length;k++){
        if ( lossCodes[k].value== kindCode ){
          sumRealPayTemp +=parseFloat(defPays[k].value);  
          kindCodeCount++;
          ArrangeRate = parseFloat(arrangRates[k].value);  //同一险别的协商比例都是一样的。
          DeductRate  = parseFloat(deductRates[k].value);
          DutyDeductRate  = parseFloat(dutyRates[k].value);
          if(isNaN(sumRealPayTemp)) {
            sumRealPayTemp=0;
          }
          
        }
      }
    }
    //B、D3、D4存在人伤赔款
    if(kindCode == "B" || kindCode == "D3" ||kindCode == "D4" ){
	    if(personKindCodes != null && personKindCodes.length != null) {
	      for (var j=1;j < personKindCodes.length;j++){
	        if (personKindCodes[j].value== kindCode ){
	          sumRealPayTemp +=parseFloat(personDefPay1s[j].value); 
	          kindCodeCount++; 
	          if ( isNaN(sumRealPayTemp)) {
	            sumRealPayTemp=0;
	          }
	          //车上人员责任险，是每个人员伤亡赔款（保险人按事故责任比例应负的赔偿金额）与每座赔偿限额想比较
	          if(kindCode == "D3" || kindCode == "D4"){
	               var DutyRate          = parseFloat(personDutyRates[j].value); 
	               var PersonArrangeRate = parseFloat(personArrangRates[j].value); 
	               sumRealPayTemp        = parseFloat(personDefPay1s[j].value);
	               if ( isNaN(sumRealPayTemp)) 
                        sumRealPayTemp=0;              
	               if ( isNaN(DutyRate)) 
                        DutyRate=0;
                   else
                        DutyRate = DutyRate/100;
                   if ( isNaN(PersonArrangeRate)) 
                        PersonArrangeRate=0;
                   else
                        PersonArrangeRate = PersonArrangeRate/100;
                   
                   if ((sumRealPay >KindAmount)) {  
                           alert( " 车上人员责任险赔偿金额超过了每座赔偿限额("+KindAmount +" 元),请调整核定赔款，再重新生成理算报告");                            
                      }
	          }
	        }
	      }
	    }         
    }
    //车损险A存在施救费
    if(kindCode == "A"){
        //暂不对车损险做判断
    }
   if ( isNaN(ArrangeRate)) 
        ArrangeRate=0;
    else
        ArrangeRate = ArrangeRate/100;
    if(isNaN(DeductRate))
        DeductRate=0;
    else 
        DeductRate = DeductRate/100;
    if(isNaN(DutyDeductRate))
        DutyDeductRate=0;
    else 
        DutyDeductRate = DutyDeductRate/100;
    sumRealPayNoDutyRate = sumRealPayTemp * ArrangeRate ;
    sumRealPay = sumRealPayTemp * indemnityDutyRate * ArrangeRate ;
    if (   kindCode =='B' 
        && (sumRealPay >KindAmount)
        && kindCodeCount > 0) {  
         alert( " 第三者责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),请调整核定赔款，再重新生成理算报告");
         return false; 
    }
    /* 前面判断过超过陪尝限额按保险额赔偿
    else if(  kindCode =='Z' 
            && (sumRealPayNoDutyRate * (1-DeductRate) >KindAmount) 
            && kindCodeCount > 1){
         alert( " 自燃损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),请调整核定赔款，再重新生成理算报告");
         return false; 
    }else if(  kindCode =='X3' 
            && (sumRealPayNoDutyRate >KindAmount) 
            && kindCodeCount > 1){
         alert( " 涉水行驶损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),请调整核定赔款，再重新生成理算报告");
         return false; 
    }else if(   kindCode =='L' 
            && (sumRealPayNoDutyRate * (1-DeductRate) >KindAmount) 
            && kindCodeCount > 1){
         alert( " 车身划痕损失险赔偿金额超过了赔偿限额("+KindAmount +" 元),请调整核定赔款，再重新生成理算报告");
         return false;   
    }else if(   kindCode =='D2' 
            && (sumRealPayNoDutyRate * (1-DeductRate)*(1-DutyDeductRate) >KindAmount) 
            && kindCodeCount > 1){
         alert( " 车上货物责任险赔偿金额超过了赔偿限额("+KindAmount +" 元),请调整核定赔款，再重新生成理算报告");
         return false;   
    }else {
     
    } 
    */
  } 
  return true;
}

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

  fm.prpLcompensateIndemnityDutyRate.value =indemnityDuty;

  
}


   //设置事故责任免赔率
   function changeAccidentDeductRate()
   {
     var indemnityDuty =fm.indemnityDuty.value;   //责任
     var deductRate="";//责任免赔率
     var kindDuty="";  //险别责任拼串  
     var kindCode ="";
     var strKindDuty ="";
    
     var i = 0;              //循环使用
     var j = 0;
	 var dutyNames = document.getElementsByName("kindCodedutyName");
	 var deductRates = document.getElementsByName("deductRate");
	 var kindCodes = document.getElementsByName("prpLlossDtoKindCode");
	 var dutyDeductRates = document.getElementsByName("prpLlossDtoDutyDeductibleRate");
	 var personKindCodes = document.getElementsByName("prpLpersonLossKindCode");
	 var personDutyRates = document.getElementsByName("prpLpersonLossDutyDeductibleRate");
	 var codeShows = document.getElementsByName("prpLlossDtoKindCodeShow");
     for (j=0;j<dutyNames.length;j++ ){  //1
       kindDuty= dutyNames[j].value; 
       deductRate= deductRates[j].value; 
      
       //改变已经存在的

       for (i=0;i<kindCodes.length;i++){    //-----标的
           kindCode = kindCodes[i].value;
           strKindDuty =kindCode+indemnityDuty ;
          if ( kindDuty ==strKindDuty){
              dutyDeductRates[i].value = deductRate ;
          }
        } 
       for (i=0;i<personKindCodes.length;i++){  //----人伤 
           kindCode = personKindCodes[i].value;
           strKindDuty =kindCode+indemnityDuty ;
          if ( kindDuty ==strKindDuty){
              personDutyRates[i].value = deductRate ;
          }
       }
       //不存在的当增加时代出最新的免赔率
       var deductibleCount =codeShows.length;
       for (var i=0;i< deductibleCount ;i++){
         kindCode = codeShows[i].value;
             strKindDuty =kindCode+indemnityDuty ;
           if ( kindDuty ==strKindDuty){
             fm.DutyDeductibleRate[i].value=deductRate;
           }
       }
   }
  }
  
   //人伤信息，选择了险别后把事故责任免赔率和绝对免赔率带出来
   function getPersonDeductRate()
   {
     var indemnityDuty =fm.indemnityDuty.value;   //责任
     
     var deductRate="";//责任免赔率
     var kindDuty="";  //险别责任拼串  
     var kindCode ="";
     var strKindDuty ="";
    
     var i = 0;              //循环使用
     var j = 0;
     var m = 0;
     var n = 0;
   
     for (j=0;j<fm.all("kindCodedutyName").length;j++ ){  //1
       kindDuty= fm.all("kindCodedutyName")[j].value; 
       deductRate= fm.all("deductRate")[j].value; 
       
       for (i=0;i<fm.all("prpLpersonLossKindCode").length;i++){  //----人伤 
           kindCode = fm.all("prpLpersonLossKindCode")[i].value;
           strKindDuty =kindCode+indemnityDuty ;
          if ( kindDuty ==strKindDuty){
              fm.all("prpLpersonLossDutyDeductibleRate")[i].value = deductRate ;
          }

       }
       
   }
   
   for (m=0;m<fm.all("kindCode2").length;m++ ){  //绝对免赔率
    
       kindCode2= fm.all("kindCode2")[m].value; 
       absolutDeductRate= fm.all("absolutDeductRate")[m].value; 
      
       for (n=0;n<fm.all("prpLpersonLossKindCode").length;n++){  //----人伤 
           kindCode = fm.all("prpLpersonLossKindCode")[n].value;
          if ( kindCode ==kindCode2){
              fm.all("prpLpersonLossDeductibleRate")[n].value = absolutDeductRate ;
          }
       }
       
   }
    

   
}

//不计免赔计算
function SumDutyDeductible(){
     var SumDefPay ;         //核定赔偿
     var DutyDeductibleRate; //事故责任免赔率  
     var DutyRate;           //责任比例
     var DeductibleRate;      //绝对免赔率
     var kindCode;            //险别

      var SumRest;           //残值
      var ClaimRate;         //赔偿比例
      var Deductible;        //免赔额
      var ArrangeRate;       //协商赔偿比例
      var lossFlag ;          //承保了不计免赔特约险的标志
      var Amount;             //保额
      
  
     var indemnityDuty =fm.indemnityDuty.value;   //责任
     var SumRealPay ;        //赔偿金额   
     SumRealPay = 0;
     var temp;
     var i = 0;              //循环时使用
     var j = 0;              //循环时使用    
     /*
        标的不计免赔计算
     */
     
     var conditionsFlag = 0; //全车盗抢险是否有“全车被盗、抢，自立案起两个月未查明下落”这个免赔条件的标识，0－没有，1－有
     for(i = 0;i < fm.all("deductCondition").length;i++){       
        if(  fm.all("deductCondition")[i].value == "290" 
          && fm.all("deductName")[i].value == "全车被盗、抢，自立案起两个月未查明下落" 
          && fm.all("Times")[i].value == "1"){
                conditionsFlag = 1;
                break;
          }
     }
     for( i = 1;i < fm.all("prpLlossDtoSumDefPay").length;i++){
        SumDefPay          = parseFloat(fm.all("prpLlossDtoSumDefPay")[i].value);
        DutyDeductibleRate = parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[i].value);
        DeductibleRate     = parseFloat(fm.all("prpLlossDtoDeductibleRate")[i].value);
        DutyRate           = parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[i].value);
        ClaimRate          = parseFloat(fm.all("prpLlossDtoClaimRate")[i].value);
        ArrangeRate        = parseFloat(fm.all("prpLlossDtoArrangeRate")[i].value);
        lossFlag           = fm.all("prpLlossFlag")[i].value;
        Amount             = parseFloat(fm.all("prpLlossDtoAmount")[i].value);
        kindCode = fm.all("prpLlossDtoKindCode")[i].value;
        if(lossFlag.length > 4 && lossFlag.substring(4,5) != "1"){
                                continue;
        }        
        if( kindCode != "M" && kindCode != "X3" && kindCode != "F" || kindCode != "K10"
            && kindCode != "U" && kindCode != "K6" && kindCode != "P" && kindCode != "C"
            && kindCode != "T" && kindCode != "NX" && kindCode != "NY" && kindCode != "X4"){
	         if(isNaN(SumDefPay))
	             SumDefPay = 0;
	         if(isNaN(Amount))
	             Amount = 0;
	         if(isNaN(DutyDeductibleRate))
	             DutyDeductibleRate = 0;
	         else
	             DutyDeductibleRate = DutyDeductibleRate/100;
	         if(isNaN(DeductibleRate))
	             DeductibleRate = 0;
	         else
	             DeductibleRate = DeductibleRate/100;
	         if(isNaN(DutyRate))
	             DutyRate = 0;
	         else
	             DutyRate = DutyRate/100;
	         if(isNaN(ClaimRate))
	             ClaimRate = 0;
	         else
	             ClaimRate = ClaimRate/100;
	         if(isNaN(ArrangeRate))
	             ArrangeRate = 0;
	         else
	             ArrangeRate = ArrangeRate/100;
	         
	         
	         
	         if(   kindCode == "A"  || kindCode == "B"  || kindCode == "D2"
	            || kindCode == "D3" || kindCode == "D4" || kindCode == "X" 
	            || kindCode == "K6" 
	            ){      
	            //这些险种需要按责任比例计算
	            temp = (SumDefPay) * ClaimRate * ArrangeRate * DutyRate   ;  
	          }else{
	            //其它险种不需要按责任比例计算
	            temp = (SumDefPay) * ClaimRate * ArrangeRate;  
	          }
                 

            
            if(kindCode == "K16" || kindCode == "Z"   || kindCode == "L" || kindCode == "H"  ||
               kindCode == "V1"  || kindCode == "G0"  || kindCode == "R" ){   //只有绝对免赔率的
               
                SumRealPay = SumRealPay + (temp * DeductibleRate);
            
            }else if(kindCode == "G"){                                    //全车盗抢险不计免赔计算
                if(conditionsFlag == 1){
                    SumRealPay = SumRealPay + (temp * 0.2);
                }   
           
            }else if(kindCode == "D2" || kindCode =="X"){		//绝对免赔率核责任免赔率都计算的
            
                SumRealPay = SumRealPay + temp*(DutyDeductibleRate + DeductibleRate - DeductibleRate * DutyDeductibleRate);
            
            }else if(kindCode == "A" || kindCode == "B" || kindCode == "D3" || kindCode == "D4"){ // 基本险的
             
               // SumRealPay = SumRealPay + temp * DutyDeductibleRate*(1-DeductibleRate);            
            	  SumRealPay = SumRealPay + temp *(DutyDeductibleRate*(1 -DeductibleRate));
            }
  
        }


     }
     /*
        人伤不计免赔计算
     */
     if(fm.all("prpLpersonLossSumDefPay") != null){
         for(i = 1;i < fm.all("prpLpersonLossSumDefPay").length;i++){
         
              SumDefPay  = parseFloat(fm.all("prpLpersonLossSumDefPay")[i].value);  //取核定赔偿
              ClaimRate          = parseFloat(fm.all("prpLpersonLossClaimRate")[i].value);
                for(j=1;j<fm.all("prpLpersonLossIndemnityDutyRate").length;j++) {
                    if(fm.all("prpLpersonLossSerialNo")[j].value==fm.all("personLossSerialNo")[i].value){
                          
                          DutyDeductibleRate = parseFloat(fm.all("prpLpersonLossDutyDeductibleRate")[j].value);  //取责任免赔率
                          DutyRate           = parseFloat(fm.all("prpLpersonLossIndemnityDutyRate")[j].value);
                          DeductibleRate	 = parseFloat(fm.all("prpLpersonLossDeductibleRate")[j].value);
                          ArrangeRate        = parseFloat(fm.all("prpLpersonLossArrangeRate")[j].value);
                          kindCode           = fm.all("prpLpersonLossKindCode")[j].value;
                                                                   
                          for(var k = 0;k < fm.all("prpLlossDtoKindCodeShow").length;k++){
                                if(kindCode == fm.all("prpLlossDtoKindCodeShow")[k].value){
                                    lossFlag = fm.all("noDutyFlagForPersonLoss")[k].value;
                                }
                          }     
                          if(lossFlag.length > 4 && lossFlag.substring(4,5) != "1"){
                                continue;
                          }
                          if(isNaN(DutyDeductibleRate))
                               DutyDeductibleRate = 0;
                          else
                               DutyDeductibleRate = DutyDeductibleRate/100;
                          if(isNaN(DutyRate))
                               DutyRate = 0;
                          else
                               DutyRate = DutyRate/100;
                          if(isNaN(SumDefPay))
                               SumDefPay = 0;
                          if(isNaN(ClaimRate))
                               ClaimRate = 0;
                          else
                               ClaimRate = ClaimRate/100;
                          if(isNaN(ArrangeRate))
                               ArrangeRate = 0;
                          else
                               ArrangeRate = ArrangeRate/100;
                          if(isNaN(DeductibleRate))
				              DeductibleRate = 0;
				          else
				              DeductibleRate = DeductibleRate/100; 
                          if(kindCode == "H"){
                          	   SumRealPay = SumRealPay + SumDefPay * DutyRate * ClaimRate*ArrangeRate*DeductibleRate;
                          }
                          else{
                          	 //SumRealPay = SumRealPay + SumDefPay * DutyRate * ClaimRate*ArrangeRate* DutyDeductibleRate*(1-DeductibleRate);
                          	   SumRealPay = SumRealPay + SumDefPay * DutyRate * ClaimRate*ArrangeRate* (DutyDeductibleRate *(1 -DeductibleRate) + DeductibleRate);
                          }                      
                          break;
                    }
              }                  
         }     
     }
     
     /*
        施救费不计免赔计算
     */
      if(fm.all("prpLchargeChargeName") != null){
      		
            for(i = 1 ;i < fm.all("prpLchargeChargeName").length;i++){
                if(fm.all("prpLchargeKindCode")[i].value == "A" && fm.all("prpLchargeChargeCode")[i].value == "03"){
                     SumDefPay = parseFloat(fm.all("prpLchargeChargeReport")[i].value);  //取费用金额
                     //取责任免赔率
                     /*
                     for (j=0;j<fm.all("kindCodedutyName").length;j++ ){  
                         kindDuty= fm.all("kindCodedutyName")[j].value; 
                         deductRate= fm.all("deductRate")[j].value; 
                         if(kindDuty == ("A" + indemnityDuty)){
                              DutyDeductibleRate = deductRate;
                         }
                       
                     }
                     */
                     var lossFlag ;
                     //取责任比例               
                     for(j = 1 ; j < fm.all("prpLlossDtoKindCodeShow").length;j++){
                            if(fm.all("prpLlossDtoKindCodeShow")[j].value == "A"){
                                DutyRate = fm.all("prpLlossDtoIndemnityDutyRate")[j].value;
                                lossFlag = fm.all("prpLlossFlag")[j].value;
                                DutyDeductibleRate = parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[j].value);
        						DeductibleRate     = parseFloat(fm.all("prpLlossDtoDeductibleRate")[j].value);
                                break;
                            }
                     }
                     if(lossFlag.length > 4 && lossFlag.substring(4,5) != "1"){
                        continue;
                     }
                     if(isNaN(DutyRate))
                        DutyRate = 0;
                     else
                        DutyRate = fm.prpLcompensateIndemnityDutyRate.value;
                     if(isNaN(DutyRate))
                        DutyRate = 0;
                     else
                        DutyRate = DutyRate/100;
                     if(isNaN(SumDefPay))
                        SumDefPay = 0;
                     if(isNaN(DutyDeductibleRate))
                        DutyDeductibleRate = 0;
                     else
                        DutyDeductibleRate = DutyDeductibleRate/100;  
                     if(isNaN(DeductibleRate))
			             DeductibleRate = 0;
			         else
			             DeductibleRate = DeductibleRate/100;   
                     SumRealPay = SumRealPay + SumDefPay*DutyRate*(DutyDeductibleRate* (1 -DeductibleRate) + DeductibleRate);
                }                           
            }
      }
     /*
       将计算结果写入不计免赔特约险的相关字段中
     */
     for( j = 0;j < fm.all("prpLlossDtoSumDefPay").length;j++){      
     
        if(fm.all("prpLlossDtoKindCode")[j].value == "M"){
            fm.all("prpLlossDtoSumLoss")[j].value = point(round(SumRealPay,2),2);
            changeChargeAmount();
            calRealpayForDuBang(fm.all("prpLlossDtoSumLoss")[j]);
            
            calRealpayForDuBang(fm.all("prpLlossDtoSumDefPay")[j]);                     
            calLoss();           
        }
     }
}

function setSumDutyDeductibleFlag(val){
    var SumDutyDeductibleFlag = fm.sumDutyDeductibleFlag
    if(SumDutyDeductibleFlag != null){
        fm.sumDutyDeductibleFlag.value = val;
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



