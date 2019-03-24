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
//检查政策性险种不允许录入费用信息
  if(checkBusinessType1()==false)
  {
     return false;
  }
  
   return true;    
}

/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{
   var riskCode = fm.prpLcompensateRiskCode.value;
  //Composition.document.body.innerHTML = fm.prpLctextContextInnerHTML.value;
  //add by qinyongli 股东业务提示 start 2005-7-31 
  var message = "";
  var shareHolderFlag = fm.shareHolderFlag.value;
  //add by hanliang end  2005-12-22
   var payFee = parseInt(fm.payFee.value);
  if(riskCode == '2801')
  {
  	tbprpLacciPersonName.style.display="none"; 
  	tbprpLacciPersonAge.style.display="none"; 
  	tbprpLacciPersonSex.style.display="none"; 
  	tbprpLacciPersonID.style.display="none"; 
  	tbprpLacciPersonName1.style.display="none"; 
  	tbprpLacciPersonAge1.style.display="none"; 
  	tbprpLacciPersonSex1.style.display="none"; 
  	tbprpLacciPersonID1.style.display="none"; 
  	fm.PersonImg.style.display="none";
  }
  if(payFee==-1){
    alert("此保单保费未缴！\n");
  } 
  else if(payFee==0){
    alert("此保单保费未缴全！\n");
  }else if(payFee==-2){
     message=message+"此保单已缴未缴全,请慎重处理！！！ \n";
  }

  
  if(shareHolderFlag!=0){
     message = message + "当前处理的审核任务为为股东业务！\n";
  }
  if (message.length>0) {
     alert(message);
  } 
 //add by qinyongli  end 2005-7-31 
  //document.body.innerHTML = fm.prpLctextContextInnerHTML.value;
  
  
  //disabledAllButton('Proposer');
  //disabledAllButton('AcciPerson');
 
  //fm.buttonAcciPersonInsert.disabled=true;
  //fm.buttonProposerInsert.disabled=true;
  
  /*add by wuzheng 健康险统计增加医疗类型只有健康险能看见，意见险时候隐藏*/
  var classCode = fm.prpLcompensateClassCode.value;
  if(classCode == 26){
      trMedicalType.style.display = "";
      /*wuzheng_leave:这里用了一个技巧，26险类medicalType保存，且不能为空，27不存。所以在select的第一个option赋值为“”
       *在26险类的时候，把空的option去掉
       */
      fm.medicalType.options[0] = null;      
  } 
  
  return true;
}
//modify by huangyunzhong 20051026 增加提示责任明细必须输入一项
function CheckDetail()
{
  var erroMessage = "";
  if(document.getElementsByName('personLossSerialNo').length<2){
     erroMessage = erroMessage + "您需要在'被保险人赔付信息'栏增加至少一条'费用信息'！\n";
    }
  if(erroMessage.length>0){alert(erroMessage);return false;}
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
  var riskCode = fm.prpLcompensateRiskCode.value;
  var sumamount = fm.prpLcompensateSumAmount.value;
  var ChargeAmount=document.getElementsByName('prpLchargeChargeAmount');
  var ChargeCode=document.getElementsByName('prpLchargeChargeCode');
  var CheckDeptCode=document.getElementsByName('prpLchargeCheckDeptCode');
  var SHcomCode= fm.SHcomCode.value;
  if(SHcomCode == '31'){
	  if (saveType == '4' && fm.prpLcompensateBank.value == '') {
	      alert("请输入被保险人开户银行账号!");
	      return false;
	  }  
	  if (saveType == '4' && fm.prpLcompensateAccount.value == '') {
	      alert("请输入开户帐号账号!");
	      return false;
	  }
	  if (saveType == '4' && fm.prpLcompensateAccount.value == '') {
	      alert("请输入收款人全称!");
	      return false;
	  } 
	  if (saveType == '4' && fm.prpLcompensateAccountOK.value == '') {
	      alert("请再次确认开户帐号!");
	      return false;
	  } 
	  if (saveType == '4' && fm.prpLcompensateHospitalName.value == '') {
	      alert("请选择就诊医院!");
	      return false;
	  }
	  if (saveType == '4' && fm.prpLcompensateDiseaseName.value == '') {
	      alert("请选择疾病!");
	      return false;
	  }
  }
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
//增加专门的保存校验的方法
  if(checkForm()==false)
  {
    return false;
  }
  if(!checkProposer())
  {
    return false;
  }
  
//  if(!checkPersonInfo()){
//    return false;  
//  }
  //新危险单位校验
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }

  fm.buttonSaveType.value = saveType;
  if(riskCode =='2801' && sumamount==0)
  {
     
  }else {if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)>round(parseFloat(fm.prpLcompensateSumAmount.value),2)){
    alert("总赔偿金额不能大于总保险金额！");
    return false;
  }}
 if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
   alert("赔款合计不等于危险单位信息里的实赔金额！");
   return false;
 }
  //判断是否还有申请未处理 2005-08-07
  if (saveType == '4' && fm.AcciClaimFlag.value == 'N') {
      alert("还有调查申请没有处理，不能提交!");
      return false;
  }  
    if (saveType == '4' && fm.checkFlag.value == 'N') {
      alert("还有调查申请没有处理，不能提交!"); 
      return false;  
  }
  //增加实赔同预赔关系判断 begin
  if(fm.times.value == 1){//首次理算走实赔同预赔的校验，重开不走校验
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("责任赔款合计金额不能小于已预付赔款金额！");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("费用合计金额不能小于已预付费用金额！");
    return false;
  }
  }
  //增加实赔同预赔关系判断 end   
  //textarea文本框设置值
 // fm.prpLctextContextInnerHTML.value=Composition.document.body.innerHTML;
//  var context = Composition.document.body.innerText;

 // fm.prpLctextContextInnerHTML.value=document.body.innerHTML;
  //var context = document.body.innerText;
  //if(context.length<1){
  //  errorMessage = errorMessage + "审核批文不允许为空\n";
  //}
  
/*国元项目组  屏蔽审核批文的校验
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "审核批文不允许为空\n";
  }
*/
  
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(!validateForm(fm,'Engage_Data,PersonFeeLoss_Data,Charge_Data'))
  {
    return false;
  }
  //var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  /*
  if(saveType==4){
  	//非案终计算书进行实赔金额是否大于估损金额的判断add by qinyongli 2005-09-20

  	    var sumClaim = parseFloat(fm.prpLcompensateSumClaim.value);
  	    var sumPaidAll = parseFloat(fm.sumPaidAll.value);
  	    var sumThisPaid = parseFloat(fm.prpLcompensateSumThisPaid.value);
  	    sumPaidAll = sumPaidAll + sumThisPaid;

  	    if(sumPaidAll>sumClaim){
  	    	alert("实赔金额大于估损金额，不允许提交核赔，您可以暂存后处理！");
  	    	return false;
            }
           
        //add end 2005-09-20
    
    //if(underWriteFlag!=1){
    //alert("核赔复核不通过时不能提交");
    // return false;
    //}

  }
  */  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  
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

  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();

  return true;
}

//检验赔付人员信息
function checkPersonInfo()
{
  
  if(isNaN(fm.prpLpersonLossLiabDetailCode.length)){
    errorMessage("费用信息至少要有一条记录!");
    return false;
  }
  
  for(var j=1;j<fm.prpLpersonLossKindCode.length;j++){
    if(isEmptyField(fm.prpLpersonLossKindCode[j]))
    {
	   errorMessage("第"+ j+"承保险别代码不能为空!");
	   return false;
	}
 }
  

/*  
    for(var j=1;j<fm.prpLpersonLossLiabDetailCode.length;j++){
    if(isEmptyField(fm.prpLpersonLossLiabDetailCode[j]))
    {
	   errorMessage("第"+ j+"条责任明细不能为空!");
	   return false;
	}
  }
*/
  for(var j=1;j<fm.prpLpersonLossSumRealPay.length;j++){
    if(isEmptyField(fm.prpLpersonLossSumRealPay[j]))
    {
      errorMessage("第"+ j+"条给付金额不能为空!");
	   return false;
	}
  }
  return true;
}

//索赔申请人----------------------------------------
function checkProposer()
{
  if(getRowsCount("Proposer")==0)
  {
		errorMessage("索赔申请人信息至少要有一条记录!");

		return false;
  }
	
  for( var j=1;j<fm.proposerName.length;j++)
 	{
		if (isEmptyField(fm.proposerName[j]))
		{
			errorMessage("第"+ j+"条索赔申请人姓名不能为空!");
			fm.proposerName[j].focus();
			return false;
		}
//	   if(isEmptyField(fm.proposerIdentifyNumber[j]))
//		{
//			errorMessage("第"+j+"条索赔申请人身份证号码不能为空!");
//			fm.proposerIdentifyNumber[j].focus();
//			return false;
//		}
		// if (fm.proposerIdentifyNumber[j]).value.length !=18)
		//{
		 // errorMessage("第"+j+"条索赔申请人身份证号码必须为18位或22位");
		  //fm.proposerIdentifyNumber[j].focus();
		  //return false;
	//	}
//	   if(isEmptyField(fm.relationCode[j]))
//		{
//			errorMessage("第"+j+"条索赔申请人身份证号码不能为空!");
//			fm.relationCode[j].focus();
//			return false;
//		}
 	}
	//若选择拒赔则必须输入拒赔原因
 	if(fm.result.value=="0"&&isEmptyField(fm.prpLcompensateRemark)){
 		errorMessage("请输入拒付原因");
 		fm.prpLcompensateRemark.focus();
 		return false;
 	}
	return true;
}

//-------------------------------------------------

function getRowsCount(PageCode)
{
  var oTBODY   = document.all(PageCode).tBodies.item(0);
  var intCount = oTBODY.rows.length;
  return intCount;
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

//意键险生成赔款计算过程，直接在前台js编辑生成
function generateCompensateText(){
    if(!checkProposer())
    {
      return false;
    }
//    if(!checkPersonInfo()){
//      return false;  
//    }
 	
 	//得到所有出险者分户序号
    var count=getElementCount("prpLpersonLossFamilyNo");
    var kindCodeCount=getElementCount("prpLpersonLossKindCode");
    var familyNo ="";
    var familyNoTemp = "";
    var compensateText = "";
    var compensateTextTemp = "";
    var feeTextTemp = "";
    var strSpace = "    ";
    compensateText = "";
    for(var i=0;i<count;i++)
    {
       compensateTextTemp="";
       feeTextTemp = "";
       if(count==1){
           familyNoTemp = fm.prplAcciPersonNo.value;
           compensateTextTemp =familyNoTemp+"、被保险人："+fm.prpLpersonLossPersonName.value+"\n";
           for(var j=0;j<kindCodeCount;j++){
             if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo.value){
               feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"项核赔："+ fm.prpLpersonLossSumRealPay[j].value+"元"+"\n";
           }
         }
       }else{
          familyNoTemp = fm.prplAcciPersonNo[i].value;
          compensateTextTemp =familyNoTemp+"、被保险人："+fm.prpLpersonLossPersonName[i].value+"\n";
          
         for(var j=0;j<kindCodeCount;j++){
           if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo[i].value){
             feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"项核赔："+ fm.prpLpersonLossSumRealPay[j].value+"元"+"\n";
           }
         }
       }
       compensateText += compensateTextTemp+feeTextTemp;
    }
    fm.prpLctextContextInnerHTML1.value=compensateText;
    return true;
}


//意键险生成审核批文，直接在前台js编辑生成
function generateCompensateText1(){
    if(!checkProposer())
    {
      return false;
    }
  
//    if(!checkPersonInfo()){
//      return false;  
//    }
 	//得到所有出险者分户序号
    var count=getElementCount("prpLpersonLossFamilyNo");
    var kindCodeCount=getElementCount("prpLpersonLossKindCode");
    var familyNo ="";
    var familyNoTemp = "";
    var compensateText = "";
    var compensateTextTemp = "";
    var feeTextTemp = "";
    var strSpace = "    ";
    var date = new Date();
    var year = date.getFullYear();
    var month=date.getMonth()+1;
    var day=date.getDate();
    var endoramount=0;
    compensateText = strSpace+"兹照"+fm.prpLcompensateClaimNo.value+"号赔案，保险人对"+fm.prpLcompensatePolicyNo.value+"号保险单"+"\n";
    compensateText+="于"+year+"年"+month+"月"+day+"日作如下赔偿，并自出险日起对保险单有效保险金额予以批改：\n"
    for(var i=0;i<count;i++)
    {
       compensateTextTemp="";
       feeTextTemp = "";
       if(count==1){
           familyNoTemp = fm.prplAcciPersonNo.value;
           compensateTextTemp =familyNoTemp+"、被保险人："+fm.prpLpersonLossPersonName.value+"\n";
           for(var j=0;j<kindCodeCount;j++){
             if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo.value){
               
               endoramount = parseFloat(fm.prpLpersonLossAmount[j].value)-parseFloat(fm.prpLpersonLossSumRealPay[j].value);
               endoramount = point(round(endoramount,2),2);
               feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"项核赔："+ fm.prpLpersonLossSumRealPay[j].value+"元，"+"保险金额由"+fm.prpLpersonLossAmount[j].value+"元冲减为"+endoramount+"元。\n";
           }
         }
       }else{
          familyNoTemp = fm.prplAcciPersonNo[i].value;
          compensateTextTemp =familyNoTemp+"、被保险人："+fm.prpLpersonLossPersonName[i].value+"\n";
          
         for(var j=0;j<kindCodeCount;j++){
           if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo[i].value){
             endoramount = parseFloat(fm.prpLpersonLossAmount[j].value)-parseFloat(fm.prpLpersonLossSumRealPay[j].value);
             endoramount = point(round(endoramount,2),2);
             feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"项核赔："+ fm.prpLpersonLossSumRealPay[j].value+"元，"+"保险金额由"+fm.prpLpersonLossAmount[j].value+"元冲减为"+endoramount+"元。\n";
           }
         }
       }
       compensateText += compensateTextTemp+feeTextTemp;
    }
    compensateText =compensateText+"\n"+strSpace+"原保险单其他条件不变，特此批注。";
    fm.prpLctextContextInnerHTML.value=compensateText;
    return true;
}


//Modify By liubvo add end 2004-09-07
/**
 @author      liubvo
 @description 生成审核批文
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

/**
 @author      liubvo
 @description 计算责任赔款合计、赔款合计、其它费用、实赔金额
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calFund()
{
  //定义变量
  var riskCode = fm.prpLcompensateRiskCode.value;
  //var realpayvalueforone = 0;
  //var realpayforall = 0;
  
  var dblSumDutyPaid = 0;  //责任赔款合计（=（赔款费用附加信息中）计入赔款金额+（赔付标的附加信息中）赔偿金额+（赔付人员附加信息中）赔付合计）
  var dblSumPaid     = 0;  //赔款合计（=责任赔款合计+其它费用）
  var dblSumPrePaid  = 0;  //预赔金额
  var dblSumNoDutyFee= 0;  //其它费用（（赔款费用附加信息中）费用金额 - 计入赔款金额）
  var dblSumThisPaid = 0;  //实赔金额（=责任赔款合计－已预付赔款）

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossSumRealPay    = 0;
  var personLossSumRealPay = 0;
  //计算责任赔款合计
  var i = 0;

  //1.赔款费用的计入赔款金额，以及其它费用
  //var intChargeCount = getRowsCount("Charge");
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
   
  
    chargeRealPay = parseFloat(fm.prpLchargeSumRealPay[i].value); //记入赔款
    chargeAmount  = parseFloat(fm.prpLchargeChargeAmount[i].value);  //费用
    //var exchaRate4AndCNY  = parseFloat(fm.ExchaRate4AndCNY[i].value);  //兑换率
    var exchaRate4AndCNY=1;
    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;
    if(isNaN(exchaRate4AndCNY))
     exchaRate4AndCNY = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay*exchaRate4AndCNY;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay)*exchaRate4AndCNY;
    
  }

  //3.赔付人员的赔付合计
  //保存数据
  var personLossData= getTableElements("PersonFeeLoss");

  var intPersonLossCount = personLossData.length;

  for( i = 1; i < fm.all("prpLpersonLossSumRealPay").length; i++ )
  {
    //realpayvalueforone = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);
    personLossRealPay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);

    if(isNaN(personLossRealPay))
      personLossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + personLossRealPay;
    //realpayforall = realpayforall + realpayvalueforone;
  }
  var prpLcompensateTimes = 0;
  prpLcompensateTimes = fm.prpLcompensateTimes.value;
  if(prpLcompensateTimes =='1' && dblSumNoDutyFee < 0){
    dblSumNoDutyFee = 0;
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
  //fm.prpLctextContextInnerHTML1.value="";
  //fm.prpLctextContextInnerHTML.value="";
  calCoinsFund();
}
function calFund2()
{
  //定义变量
  var riskCode = fm.prpLcompensateRiskCode.value;
  if(riskCode == '2801')
  {
  
  //var realpayvalueforone = 0;
  //var realpayforall = 0;
  
  var dblSumDutyPaid = 0;  //责任赔款合计（=（赔款费用附加信息中）计入赔款金额+（赔付标的附加信息中）赔偿金额+（赔付人员附加信息中）赔付合计）
  var dblSumPaid     = 0;  //赔款合计（=责任赔款合计+其它费用）
  var dblSumPrePaid  = 0;  //预赔金额
  var dblSumNoDutyFee= 0;  //其它费用（（赔款费用附加信息中）费用金额 - 计入赔款金额）
  var dblSumThisPaid = 0;  //实赔金额（=责任赔款合计－已预付赔款）

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossSumRealPay    = 0;
  var personLossSumRealPay = 0;
  //计算责任赔款合计
  var i = 0;

  //1.赔款费用的计入赔款金额，以及其它费用
  //var intChargeCount = getRowsCount("Charge");
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
   
  
    chargeRealPay = parseFloat(fm.prpLchargeSumRealPay[i].value); //记入赔款
    chargeAmount  = parseFloat(fm.prpLchargeChargeAmount[i].value);  //费用
    //var exchaRate4AndCNY  = parseFloat(fm.ExchaRate4AndCNY[i].value);  //兑换率
    var exchaRate4AndCNY=1;
    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;
    if(isNaN(exchaRate4AndCNY))
     exchaRate4AndCNY = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay*exchaRate4AndCNY;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay)*exchaRate4AndCNY;
    
  }

  //3.赔付人员的赔付合计
  //保存数据
  var personLossData= getTableElements("PersonFeeLoss");

  var intPersonLossCount = personLossData.length;

  for( i = 1; i < fm.all("prpLpersonLossSumRealPay").length; i++ )
  {
    //realpayvalueforone = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);
    personLossRealPay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);

    if(isNaN(personLossRealPay))
      personLossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + personLossRealPay;
    //realpayforall = realpayforall + realpayvalueforone;
  }

  if(dblSumNoDutyFee < 0)
    dblSumNoDutyFee = 0;


  //得到预赔金额
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //计算赔款合计
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumPaid,2),2);
  //fm.prpLctextContextInnerHTML1.value="";
  //fm.prpLctextContextInnerHTML.value="";
  }
}
//----------------------------
function calFund1()
{
  //定义变量
  var dblSumDutyPaid = 0;  //责任赔款合计（=（赔款费用附加信息中）计入赔款金额+（赔付标的附加信息中）赔偿金额+（赔付人员附加信息中）赔付合计）
  var dblSumPaid     = 0;  //赔款合计（=责任赔款合计+其它费用）
  var dblSumPrePaid  = 0;  //预赔金额
  var dblSumNoDutyFee= 0;  //其它费用（（赔款费用附加信息中）费用金额 - 计入赔款金额）
  var dblSumThisPaid = 0;  //实赔金额（=责任赔款合计－已预付赔款）
  var sumCheckFee = 0;
  sumCheckFee = parseFloat(fm.sumCheckFee.value);
  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossSumRealPay    = 0;
  var personLossSumRealPay = 0;
  //计算责任赔款合计
  var i = 0;

  //1.赔款费用的计入赔款金额，以及其它费用
  //var intChargeCount = getRowsCount("Charge");
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    chargeRealPay = parseFloat(fm.prpLchargeSumRealPay[i].value); //记入赔款
    chargeAmount  = parseFloat(fm.prpLchargeChargeAmount[i].value);  //费用
    //var exchaRate4AndCNY  = parseFloat(fm.ExchaRate4AndCNY[i].value);  //兑换率
    var exchaRate4AndCNY=1;
    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;
    if(isNaN(exchaRate4AndCNY))
     exchaRate4AndCNY = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay*exchaRate4AndCNY;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay)*exchaRate4AndCNY;
  }

  //3.赔付人员的赔付合计
  //保存数据
  var personLossData= getTableElements("PersonFeeLoss");

  var intPersonLossCount = personLossData.length;

  for( i = 1; i < fm.all("prpLpersonLossSumRealPay").length; i++ )
  {
    personLossRealPay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);

    if(isNaN(personLossRealPay))
      personLossRealPay = 0;

    dblSumDutyPaid = dblSumDutyPaid + personLossRealPay;
  }

  if(dblSumNoDutyFee < 0)
    dblSumNoDutyFee = 0;


  //得到预赔金额
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);   //已预付赔款

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //计算赔款合计
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee + sumCheckFee;

  //计算实赔金额
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);     //责任赔款合计
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);    //其它费用
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);         //赔款合计
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumPaid,2),2);         //本次给付金额
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumThisPaid,2),2);

}



function calCoinsFund() {
//	  if(checkCoinsPaidLossType() == false ){
//		  return false ; 
//	  }
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
	//var coinsSelfRate = fm.coinsSelfRate.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	
		if(coinsPaidLossType == null || coinsPaidLossType == ""){
			alert("共保业务，请选择赔案赔付类型！");
			return false ; 
		}
	}
	return true ; 
	
}

function changeCoinsSumPaid() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	calCoinsFund();
	if(coinsPaidLossType == "1"){
		document.getElementById("CommonCoinsChargeFee").style.display="";
		fm.CommonCoinsChargeFeeFlag.value = '1';
	}else{
		document.getElementById("CommonCoinsChargeFee").style.display="none";
		fm.CommonCoinsChargeFeeFlag.value = '0';
	}
	}
}

//-----------------------------


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

/*
function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}
*/
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcompensatePolicyNo.value;
     var RiskCode  =fm.prpLcompensateRiskCode.value;
     var damageDate=fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL =  CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
/**
 *@description added by zhangli 2007-04-20验证被保险人的帐号是否一致
 *@param       无
 *@return      
*/
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
	
// added by fenglei 国元项目组需求,政策性业务不允许录入费用信息
function checkBusinessType1(){
    var prpLcompensateBusinessType1 = fm.prpLcompensateBusinessType1.value;  //政策性业务商业性业务标志
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;  //费用信息序号
    if (prpLcompensateBusinessType1=="01"||prpLcompensateBusinessType1=="02"){
        if(prpLchargeSerialNo>1){
           alert("政策性业务不允许录入费用信息!");
           return false;
           }
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

