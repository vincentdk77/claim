/*****************************************************************************
 * DESC       ��ʵ��Ľű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-05-19
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
/**
 *@description ���ڴ�����������ѡ��������
 *@param       ��
 *@return      ��ѡ��������ҳ��
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
 *@description ��鱨���Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
	////���Ǽ���������
 	//if(checkRegistMain()==false)
 	//{
 	//	return false;
 	//}
    ////������߳�������
 	//if(checkThirdParty()==false)
 	//{
 	//	return false;
 	//}
 	////����ʻԱ����
 	//if(checkDriver()==false)
 	//{
  	//  return false;
 	//}
    ////����ı�����
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
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{
  
  //��ʼ�����ⰸ����onchange�¼�
  fm.claimType.onchange();
  //Ĭ��չ���ر�Լ��
  var span = eval("spanEngage");
  span.style.display="";
  span.src="/claim/images/butExpandBlue.gif";

  calCompelSumPropAndPerson();
  
 //modify by luqin 2005-04-08 start
  //�жϱ����Ƿ񽻸������򵯳���ʾ��Ϣ
  var payFee = parseInt(fm.prpLcompensatePayFee.value);
  var errorMessage = "";
  if(payFee==-1){
    errorMessage=errorMessage+"�˱�������δ��,�����ش������� \n";
  } else if(payFee==-2){
    errorMessage=errorMessage+"�˱����ѽ�δ��ȫ,�����ش������� \n";
  }

  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by luqin 2005-04-08 endt
  return true;
}
/**
 *@description �ύ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function submitDelete()
{
  fm.buttonDelete.disabled = true;
  fm.submit();
  return true;
}
/**
 *@description �ύ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function submitForm()
{
  fm.buttonApprove.disabled = true;
  fm.submit();
  return true;
}

/**
 *@description ����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function resetForm()
{
  if(window.confirm("ȷ��Ҫ������"))
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
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{
    var ChargeAmount=document.getElementsByName('prpLchargeChargeAmount');
    var ChargeCode=document.getElementsByName('prpLchargeChargeCode');
    var CheckDeptCode=document.getElementsByName('prpLchargeCheckDeptCode');
    for(var i=1;i<ChargeCode.length;i++){
        if(ChargeCode[i]!=null&&ChargeCode[i].value=='14'&&ChargeAmount[i]!=null&&ChargeAmount[i].value!=0){
           if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value==''){
              alert("��¼��ϵͳ�ڴ��鿱��ʱ,����¼����鿱��������");
              return false;
           }else{
            if(CheckDeptCode[i]!=null&&CheckDeptCode[i].value.length>=10){
              var CheckCode= CheckDeptCode[i].value.substring(6,10);
              if(CheckCode=='0000'){
                 alert("���鿱������Ҫ¼�뵽���ţ���");
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
         alert("�Ƿ��漰������������Ϊ�գ�");
         fm.prpLpersonWoundGrade.focus();
         return;
       }
     }
   }
   for(var j=1;j<fm.prpLbillSerialNo.length;j++)
   {  
    if(fm.billType[j].value=="")
      {
         alert ("��"+j+"������Ʊ���� ����Ϊ��");
         return false ;
      }
        if(fm.billNo[j].value=="")
      {
         alert ("��"+j+"������Ʊ���� ����Ϊ��");
         return false ;
      }
   } 
    for(var j=1;j<fm.prpLchargeSerialNo.length;j++)
    {  
    	if(fm.prpLchargeKindCode[j].value=="")
      	{
	         alert ("��"+j+"�������ձ���벻��Ϊ��");
	         return false ;
      	}
        if(fm.prpLchargeKindName[j].value=="")
      	{
	         alert ("��"+j+"�������ձ����Ʋ���Ϊ��");
	         return false ;
      	}
     }
     
     var propLength = getElementCount("propSerialNo");
     for(var j = 1;j<propLength;j++){
        if(fm.propFeeTypeName[j].value == ""){
             alert("ǿ�Ʊ��ղƲ���Ϣ����"+j+"����ʧ��ϸ����Ϊ��");
             return false;
        }
        if(fm.propSumDefPay[j].value == ""){
             alert("ǿ�Ʊ��ղƲ���Ϣ����"+j+"���˶��⳥����Ϊ��");
             return false;
        }
        
     }
     var PersonLength = getElementCount("personMedicalSerialNo");
     for(var j = 1;j<PersonLength;j++){
        if(fm.prpLpersonMedicalDetailName[j].value == ""){
             alert("ǿ�Ʊ���������Ϣ����"+j+"�����ô�������Ʋ���Ϊ��");
             return false;
        }
     }
     var nodutyLength = getElementCount("nodutyInsuredCompanyCode");
     for(var j = 1;j<nodutyLength;j++){
        if(fm.noneDutyLicenseNo[j].value == ""){
              alert("ǿ�Ʊ������������Ϣ����"+j+"�����ƺ��벻��Ϊ��");
              return false;
        }
        if(fm.nodutyInsuredCompanyName[j].value == ""){
              alert("ǿ�Ʊ������������Ϣ����"+j+"�����𷽽�ǿ�ձ��չ�˾����Ϊ��");
              return false;
        }
        if(fm.dutyPercent[j].value == ""){
              alert("ǿ�Ʊ������������Ϣ����"+j+"�����α�������Ϊ��");
              return false;
        }
        
     }
     var NoneInsItemLength = getElementCount("NoneInsItemCode");
     for(var j = 1;j<NoneInsItemLength;j++){
         if(fm.NoneInsItemName[j].value == ""){
              alert("ǿ�Ʊ����ޱ��մ�����Ϣ����"+j+"����ʧ��Ŀ����Ϊ��");
              return false;
         }
     }
     
     if(propLength == 1 && PersonLength == 1 &&
        nodutyLength == 1 &&  NoneInsItemLength ==1){
              alert("����¼��һ���⳥��¼");
              return false;
     }
     
     
   if(checkBeyondQuota()==false){
     return false;	
   }
     //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
   
   
  var errorMessage = "";
  //if(fm.prpLcompensateSumThisPaid.value < 0){
  //		errorMessage = errorMessage + "����������С��Ԥ����\n";
  //}
  
  fm.buttonSaveType.value = saveType;
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "���㱨�治����Ϊ��\n";
  }
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    errorMessage = errorMessage + "���ϼƲ�����Σ�յ�λ��Ϣ���ʵ����";
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
     //�ǰ��ռ��������ʵ�����Ƿ���ڹ�������ж�add by qinyongli 2005-09-20
  	if(fm.prpLcompensateFinallyFlag[1].checked){
  	    var sumClaim = parseFloat(fm.prpLcompensateSumClaim.value);
  	    var sumPaidAll = parseFloat(fm.sumPaidAll.value);
  	    var sumThisPaid = parseFloat(fm.prpLcompensateSumThisPaid.value);
  	    sumPaidAll = sumPaidAll + sumThisPaid;
  	    if(sumPaidAll>sumClaim){
  	    	alert("ʵ������ڹ�����������ύ���⣬�������ݴ����");
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
  		alert("�����߳��ƺŲ���Ϊ��!");
  		thridLicenseNos[i].focus();
  		return false;
  	}
  	if(trim(thridCompanys[i].value) == ""){
  		alert("�����߳б���˾����Ϊ��!");
  		thridCompanys[i].focus();
  		return false;
  	}
  }  */
  
  if(fm.claimType.value == "K"){
  	  var insureCarFlags = document.getElementsByName("insureCarFlag");
  		if(insureCarFlags.length < 3){
  			alert("�ⰸ����ǻ�������ʱ������¼�����߳���Ϣ��");
  			return false;
  		}
  	  for(var i = 2;i < insureCarFlags.length;i++){
	  	if(trim(fm.prpLthirdPartyLicenseNo[i].value) == ""){
	  		alert("���߳����ƺ��벻��Ϊ��!");
	  		fm.prpLthirdPartyLicenseNo[i].focus();
	  		return false;
	  	}
	  	if((trim(fm.prpLthirdPartyInsureComName[i].value) == "" 
	  	|| trim(fm.prpLthirdPartyInsureComCode[i].value) == "")){
	  		alert("���߳��б���˾����Ϊ��!");
	  		fm.prpLthirdPartyLicenseNo[i].focus();
	  		return false;
	  	}
	  	if(trim(fm.prpLthirdPartyCarPolicyNo[i].value) == "" ){
	  		alert("���߳������Ų���Ϊ��!");
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
 @description ����һ���⸶��Ա������Ϣ����
 @param       ��
 @return      ��
 @see         UIMulLine#insertRow
 @see         UIMulLine#setRowRecordState
*/
function insertRowKind()
{
/*
  if(fm.PersonName.disabled==true)
  {
    errorMessage("�������һ����Ա��Ϣ!");
    return;
  }

	if(isEmpty(fm.PersonLossKindCodeU))
	{
		errorMessage("���������⸶��Ա�ձ�!");
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
  //�����йؼ��֣���ţ�
  setRowRecordState("PersonLoss","Kind");

  var findex;
  findex = fm.all("PersonLossClaimRate").length;
  fm.all("PersonLossClaimRate")[findex-1].value = "100.0000";
*/
}


 //modify by wangli remark start 20050409
 /**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
 *@description ʵ�����񸴺�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
 @description �������㱨��
 @param       ��
 @return      ��
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
 @author      ��ɸ�
 @description �����⳥�������ı�ʵ�ʼ�ֵʱ������
              ���⳥����Ϊ�գ����⳥����=����/�³����ü� Ҳ����  (����/�޶�)/ʵ�ʼ�ֵ
 @param       field:������
 @return      booleanֵ���Ϸ�����true,���Ϸ�����false
 @see         UICommon.js#point��round
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
//    errorMessage("ʵ�ʼ�ֵ����С�ڱ��ս�");
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
 @author      ����Ⱥ
 @description �����⸶����е��⳥���ı�ʵ�ʼ�ֵ���˶���ʧ����ֵ�����α���ʱ������
              ���������
              �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
              # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay(field)
{
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⳥���
  var temp;

  //ȡ�õ�ǰ������
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

  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
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
    //reason:ʵ�⴦�����ϻ��������ա��޹�ʧ�����ճ���ʱϵͳ���⸶���㲻��
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
    //reason:�ձ��ǳ�������ߣ�������ʧ��ϸΪ27�����⣬���⳥���=-��ֵ
    if((fm.all("prpLlossDtoKindCode")[findex].value=="A"||fm.all("prpLlossDtoKindCode")[findex].value=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27")
    {
      Realpay = SumRest*(-1);
    }
    //modify by dengxh end 20040904
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  
  //�����ձ���⳥���ܳ�������
  
  
  
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();

  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

}


/**
 @author      ��ɸ�
 @description ���ձ�У���Ƿ񳬹������е��޶�
 @param       KindCode:�ձ�
 @param       PersonNo:��Ա���
 @return      ��
 */
function CheckLimitAmountByKindCode(KindCode,PersonNo)
{
  if(checkCodeInQuery())
  {
    return;
  }

  if (KindCode=="")
    return;

  //�������,�����޷�������һҳ
  fm.Sex.disabled = false;
  fm.PersonLossLicenseNo.disabled = false;

  //��������
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

  //�������
  clearRecord("Loss");
  clearRecord("PersonLoss");
  clearRowRecord("Kind");

  //load data
  loadRowRecord("PersonLoss","Kind","Kind_Data");

}

/**
 @author      ����Ⱥ
 @description �����������ϼơ����ϼơ��������á�ʵ����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calFund()
{
  //�������
  var dblSumDutyPaid = 0;  //�������ϼƣ�=�������ø�����Ϣ�У����������+���⸶��ĸ�����Ϣ�У��⳥���+���⸶��Ա������Ϣ�У��⸶�ϼƣ�
  var dblSumPaid     = 0;  //���ϼƣ�=�������ϼ�+�������ã�
  var dblSumPrePaid  = 0;  //Ԥ����
  var dblSumNoDutyFee= 0;  //�������ã��������ø�����Ϣ�У����ý�� - ��������
  var dblSumThisPaid = 0;  //ʵ���=�������ϼƣ���Ԥ����

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossRealPay    = 0;
  var personLossRealPay = 0;

  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  var elements = getTableElements("Charge");
  //alert(fm.all("prpLchargeSumRealPay").length);
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[i].value); //�������
    chargeAmount  = parseFloat(fm.all("prpLchargeChargeAmount")[i].value);  //����

    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;

    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay;
    dblSumNoDutyFee = dblSumNoDutyFee + (chargeAmount - chargeRealPay);
    //alert(dblSumDutyPaid+"|"+dblSumNoDutyFee);
  }

  //2.�⸶��ĵ��⳥���
  //��������
  //?????????????????????
  //setCurrentRecord("Loss");
/*
  var lossData= getTableElements("lLoss");

  var intLossCount = lossData.length;
*/  
  var intLossCount = 0;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  var dblRealPayA = 0;    //�����գ�A���������
  var dblRealPayATotal = 0; //�����գ�A��������������Ϊ��


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
    //add by qinyongli 2006-01-12 begin  ���ӶԳ�����ʧ�ս���ͳ�ƣ����ڼ������
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
  //�ó���������ȥ�����

  dblRealPayATotal = dblRealPayA - deductibleAall;
  //��������ʾ�������������
  if(dblRealPayATotal>0){
      dblSumDutyPaid = dblSumDutyPaid - deductibleAall;//�����ȥ������������0������������м�ȥ����
//      fm.lastRealPay.value = dblRealPayATotal ;
  }else{
      dblSumDutyPaid = dblSumDutyPaid - dblRealPayA;//�����ȥ���������С��0,����������м�ȥ�������Ϊ0��
//      fm.lastRealPay.value = 0 ;
  }
  //add by qinyongli 2006-01-12 end

  //3.�⸶��Ա���⸶�ϼ�
  //��������
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
  //�õ�Ԥ����
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);
  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //�������ϼ�
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;

  //����ʵ����
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
 @author      ��ɸ�
 @description ���������޸�ʱ����(ֻ�Գ���ͣʻ��)
 @param       ��
 @return      booleanֵ
*/
function changeLossQuantity(field)
{
  var fieldname=field.name; //����
  var i = 0;
  var findex=0;       //��λ���

  //��λ
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
    errorMessage("�����������ܴ��ڳб�������("+Quantity+"��)!");
    fm.LossQuantity.focus();
    fm.LossQuantity.select();
    return false;
  }
  if(UnitPrice > UnitAmount)
  {
    errorMessage("��λ�⳥���ܴ��ڳб��ĵ�λ�޶�("+UnitAmount+")!");
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
 @author      ����Ⱥ
 @description �����⸶��ĺ���Ա������֮��
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calLoss()
{
  //�������
  var dblSumLoss = 0;
  var LossSumLoss    = 0;
  var PersonLossSumLoss = 0;
  var i = 0;

  //�⸶��ĵĺ�����
  //��������
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

  //�⸶��Ա�ĺ�����
  //��������
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
  var fieldname=field.name; //����
  var i = 0;
  var findex=0;       //��λ���

  //��λ
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
 	    alert("B�ձ�����¼���ֵ��");
      setReadonlyOfElementOfLoss(fm.all("prpLlossDtoSumRest")[findex]);
 	    //fm.all("prpLlossDtoSumRest")[findex].readOnly=true;
 	    fm.all("prpLlossDtoSumRest")[findex].value="0.00";
 	}
}


/**
 @author      ��ɸ�
 @description ʹһ������������Ϊֻ��
 @param       iElement: ��
 @return      ��
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
 @author      ��ɸ�
 @description ʹһ������������Ϊ������
 @param       iElement: ��
 @return      ��
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







//�뿪��ʱ������У��
function checkInteger(field,MinValue,MaxValue)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
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
    errorMessage("������Ϸ���" + desc +"\n����Ϊ����(integer),��СֵΪ" + MinValue + ",���ֵΪ" +MaxValue);
    field.focus();
    field.select();
    return false;
  }
  return true;
}

/**
 @author      renyiqun
 @description У����������ܳ������ý��
 @param       Field: ������
 @return      boolean: �Ϸ�Ϊtrue,����Ϊfalse
 @see         UICommon.js#isEmpty
 */
function checkChargeAmount(Field)
{
  var fieldname=Field.name; //����
  var i = 0;
  var findex=0;             //��λ���
  var ChargeAmount = 0;			//���ý��
  var ChargeRealPay = 0;		//���������

  //��λ
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
 		var chargeCode = fm.prpLchargeChargeCode[findex].value; //�������
 		var chargeAmount = fm.prpLchargeChargeAmount[findex].value; //�������
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
  	//reason:�������м���������Զ�������Ϊֻ��
  	var chargeCode = fm.prpLchargeChargeCode[findex].value; //�������
  	//modify by lirj update begin 040508
  	//reason:�������м���������Զ�������Ϊֻ��
  	////ChargeCode="03"ʱ��ʾʩ�ȷ�
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
    	errorMessage("���������ܳ������ý�");
    	Field.focus();
  		Field.select();
    	return false;
    }
    else if( fieldname=="prpLchargeSumRealPay" )
    {
    	errorMessage("���������ܳ������ý�");
    	fm.all("prpLchargeChargeAmount")[findex].focus();
  		fm.all("prpLchargeChargeAmount")[findex].select();
    	return false;
    }
  }

  //��������ʧ����߷���Ϊ5000
  if( fm.all("prpLchargeKindCode")[findex].value == "L" && parseFloat(fm.all("prpLchargeChargeAmount")[findex].value) > 5000)
    {
    	errorMessage("��������ʧ�����������Ϊ5000Ԫ��");
    	fm.all("prpLchargeChargeAmount")[findex].focus();
  		fm.all("prpLchargeChargeAmount")[findex].select();
    	return false;
    }
    
  return true;
}

/**
 @author      ����Ⱥ
 @description ͬ�ձ�������ʣ����α���Ҫ���
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function checkKindCode(Field){

  var fieldname=Field.name; //����
  var i = 0;
  var findex=0;             //��λ���
  var ChargeAmount = 0;			//���ý��
  var ChargeRealPay = 0;		//���������
  
  var findFlag=0;
  
  //��λ
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }
  
  //ȡ�õ�ǰ�ձ���� 
    var strValue = fm.prpLpersonLossKindCode[findex].value;
    if(strValue=="")
      return;
  //�ж�ѡ����ձ��Ƿ�Ϊ�������ڵ�ʱ��Ч���ձ�
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
         alert("��ѡ����ձ��ǳ�������ʱ���ձ�,�����½���ѡ��");
         fm.prpLpersonLossKindCode[findex].value = "";
         return false;
     }
  
  //��Ҫ����������,���α���

  //У��¼���ձ�
  if(Field.name.indexOf("prpLpersonLossKind")>-1)
  {
    if(fm.all("prpLpersonLossKindCode")[findex].value!="" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="B" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="B1" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="D3" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="D4" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="Y")
    {
      alert("��Ա�⸶ֻ����¼����������Ρ���ʻԱ���Ρ��˿����Ρ���ͨ�¹ʾ����𺦣�");
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
      //ֻ�޸ı��˵�������
      if(fm.all("prpLpersonLossSerialNo")[i].value==fm.all("prpLpersonLossSerialNo")[findex].value){
        fm.all("prpLpersonLossIndemnityDutyRate")[i].value=fm.all("prpLpersonLossIndemnityDutyRate")[findex].value;
        fm.all("prpLpersonLossDeductibleRate")[i].value=fm.all("prpLpersonLossDeductibleRate")[findex].value;
      }
    }
  }
}




/**
 @author      ����Ⱥ
 @description �����⸶��Ա�������(�ı����α���ʱ��ɵ������ĸı�)
              �漰���е�ǰ�еķ�����Ϣ
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay2(field)
{
  alert("calRealpay2");
  var i = 0;
  var findex=0;       //��λ���
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⸶���
  var temp;

  var fieldname=field.name; //����

  //��λ
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
  //��������ֵ
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

    /*���������
     * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
     * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
     */
    temp = (SumLoss - SumRest) * ClaimRate * DutyRate;  //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α���
    Deductibletemp = temp * DeductibleRate;  //����= temp * ������

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

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(field);

  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;
*/
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);

}

/**
 @author      ����Ⱥ
 @description �����⸶��Ա�е��⸶�ϼ�(�ı䵥�ۡ���Ŀ���⳥������
              ���α���ʱ��ɵ������ĸı�)
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calSumRealpay(field)
{

  var findex=0;       //��λ���
  var i = 0;
  var Realpay;          //�����
  var SumRealpay;       //�⸶�ϼ�

  var fieldname=field.name; //����

  //��λ
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }

  //��������ֵ
  Realpay    = 0;
  SumRealpay = 0;

  //�����⸶�ϼ�
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
  //��������ʾ���⸶�ϼ����õ�������
  fm.all("prpLpersonLossSumRealPay1")[findex1].value =  point(round(SumRealpay,2),2);
}


/**
 @author      ����Ⱥ
 @description �����⸶��Ա�ĺ�����(�ı䵥�ۺ���Ŀʱ��ɵĺ�����ĸı�)
 @param       Field: ������
 @return      ��
 @see         UICommon.js#point��round
*/
function calSumLoss(Field)
{

  var fieldname=Field.name; //����
  var i = 0;
  var findex=0;             //��λ���
  var SumLoss;              //������
  var UnitPrice;            //����
  var Quantity;             //����

  //��λ
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }

  //��������ֵ
  UnitPrice = parseFloat(fm.all("prpLpersonLossUnitAmount")[findex].value);
  Quantity  = parseFloat(fm.all("prpLpersonLossLossQuantity")[findex].value);
  SumLoss   = 0;

  //���������
  if(isNaN(UnitPrice))
    UnitPrice = 0;
  if(isNaN(Quantity))
    Quantity = 0;

  SumLoss = UnitPrice * Quantity;
  fm.all("prpLpersonLossSumLoss")[findex].value = point(round(SumLoss,2),2);

  //�����⸶��Ա�������
  calRealpay1(Field);

  //�����⸶��ĺ���Ա������֮��
  calLoss();
}

/**
 @author      ����Ⱥ
 @description �����⸶��Ա�������(�ı䵥�ۡ���Ŀ���⳥����ʱ��ɵ������ĸı�)
              ֻ�漰����������Ӧ�ĵ�ǰ�еķ�����Ϣ
 @param       Field: ������
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay1(Field)
{
  var fieldname=Field.name; //����
  var i = 0;
  var findex=0;       //��λ���
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⸶���
  var temp;

  //��λ
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }


  //��������ֵ
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

  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
   */
  temp = (SumLoss - SumRest) * ClaimRate * DutyRate; //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α���
  Deductibletemp = temp * DeductibleRate; //����= temp * ������

//  if(Deductible > Deductibletemp)
//  {
//    Realpay = temp - Deductible;
//  }
//  else
//  {
    Realpay =  temp * (1 - DeductibleRate);
//  }
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(Field);

  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;

  //���ձ�У���Ƿ񳬹������е��޶�
  CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);
*/
}


/**
 @author      ��ɸ�
 @description �⸶����޸�ʱ����
 @param       Field:������
 @return      booleanֵ
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
    errorMessage("�⸶���ܴ��ں�����!");
    Field.focus();
    Field.select();
    return false;
  }

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(Field);

  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();

  return true;
}

/**
 @author      ��ɸ�
 @description �ı���������ʱУ��
 @param       Field:������
 @return      boolean�ͣ��Ϸ�����true,���Ϸ�����false
 */
function changeLFlag(Field)
{
  if(Field.value=='D')
  {
    errorMessage("�ǹ��ڻ��������������������Ͳ���ΪD!");
    Field.focus();
    return false;
  }
  return true;
}



/**
 @author      liubvo //ҳ���ʼ����ʱ����
 @description �����⸶��Ա�е��⸶�ϼ�(�ı䵥�ۡ���Ŀ���⳥������
              ���α���ʱ��ɵ������ĸı�)
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calSumRealpayInit()
{
  var i = 0;
  var Realpay=0;          //�����
  var SumRealpay =0;       //�⸶�ϼ�
  //��λ
  for(i=0;i<fm.all("prpLpersonLossSumRealPay1").length;i++)
  {
    //��������ֵ
    Realpay    = 0;
    SumRealpay = 0;

    //�����⸶�ϼ�
    for(j=0;j<fm.all("prpLpersonLossSumRealPay").length;j++)
    {
      if(fm.all("personLossSerialNo")[j].value==fm.all("prpLpersonLossSerialNo")[i].value){
        Realpay = parseFloat(fm.all("prpLpersonLossSumRealPay")[j].value);
        if(isNaN(Realpay))
          Realpay = 0;

        SumRealpay = SumRealpay + Realpay;
      }
    }

    //��������ʾ���⸶�ϼ����õ�������
    fm.all("prpLpersonLossSumRealPay1")[i].value =  point(round(SumRealpay,2),2);
    //alert(i+"|"+fm.all("prpLpersonLossSumRealPay1")[i].value);
  }
  return true;
}

/**
 @author      ��ɸ�
 @description ���ձ�У���Ƿ񳬹������е��޶�
 @param       KindCode:�ձ�
 @param       PersonNo:��Ա���
 @return      ��
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

  if(Type=="lLoss")   //�⸶���
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
 @author      ��ɸ�
 @description �ձ��ǳ�������ߣ�������ʧ��ϸΪ27������ʱ������¼���ֵ����Ϊ�⳥���=-��ֵ
 @param       KindCode:�ձ�
 @param       PersonNo:��Ա���
 @return      ��
 */
function changeLossSumRestShowStyle(Field) //�⸶�����Ϣ�����ձ�Ϊ�������ա����ò�ֵΪ�գ���ֻ��
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
function changeLossClaimRate(Field) //�⸶�����Ϣ�����ձ�Ϊ�������ա������⸶����Ϊ��A�ձ�ı�������³����üۣ������⸶����ֻ��
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
//�޸��Ը���Ĵ���
//modify by lirj update begin 040520
//reason:�����Ը���
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
              errorMessage("�⸶�����ÿ���ձ��µĿ�����ֻ��¼��һ��!");
              //showPageOnly("LossImg",spanLoss);
              return false;
            }
         }
         else if(fm.all("prpLlossDtoKindCode")[i].value=="B")
         {
            countB++;
            if (countB>=2)
            {
              errorMessage("�⸶�����ÿ���ձ��µĿ�����ֻ��¼��һ��!");
              //showPageOnly("LossImg",spanLoss);
              return false;
            }
         }
       }
     }
     if (countA<2 && countB<2)
     {
       //setReadonlyOfElementOfLoss(fm.LossSumRest); //�ſ���ֵ�����ֹ����롣
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
      alert("������ֻ���ϵ��������µ���");
      Field.value = Field.oldValue;
      calRealpay(Field);
      Field.focus();
      return false;
    }
  return true;
}
/**
 @author      ����Ⱥ
 @description ����
 @param       ��
 @return      ��
 */
function showLossCollect()
{
  //���浱ǰ��¼
  //setCurrentRecord("Loss");
  var newWindow = window.open("/claim/DAA/compensate/DAALossCollect.jsp","new","width=500,height=220,top=200,left=200,scrollbars=yes");
  //newWindow.focus();
  //return newWindow;
}

/**
 @author      ����Ⱥ
 @description ���ձ����ƣ���Ŀ���ƻ�����Ϣ
 @param       ��
 @return      ����һ�������ձ����ƣ���Ŀ���ƣ�������⳥��������
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
    //���ձ����ƣ���Ŀ���ƻ�����Ϣ
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
      arrayLossCollect[j] = arrayLoss;  //һ��������
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
 @author      ��ɸ�
 @description ˢ���⸶����в��������ձ�Ĳ�������ֵ
 @param       ��
 @return      ��
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
  strIsSafeLoad = strIsSafeLoad.substring(2,3); //ȡΥ����ȫװ��������������

  //�����Ƿ�¼���˲���������
  for(i=0;i<fm.all("prpLlossDtoSerialNo").length;i++)
  {
    if(fm.prpLlossDtoKindCode[i].value=='M')
    {
      bFind = true;
      break;
    }
  }


  //û��¼�벻��������������ˢ��
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
 @author      ����Ⱥ
 @description �����⸶����е��⳥���ı�ʵ�ʼ�ֵ���˶���ʧ����ֵ�����α���ʱ������
              ���������
              �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
              # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpayForSunny(field)
{
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DutyDeductibleRate; //�¹�����������
  var DeductibleRate; //������
  var DriverDeductibleRate;//��ʻԱ������
  var mainKindCode;   //���մ���
  var DeductibleRateOfMainKind;//���յľ���������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⳥���
  var temp;
  var unitPrice;
  //ȡ�õ�ǰ������
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


  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
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
        //���𸽼���Ҫ������յľ���������
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
        //Ӧ Ҫ��,���ε����յ�����������
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
            //ͣʻ������������
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
    //reason:ʵ�⴦�����ϻ��������ա��޹�ʧ�����ճ���ʱϵͳ���⸶���㲻��
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
    //reason:�ձ��ǳ�������ߣ�������ʧ��ϸΪ27�����⣬���⳥���=-��ֵ
    if((fm.all("prpLlossDtoKindCode")[findex].value=="A"||fm.all("prpLlossDtoKindCode")[findex].value=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27")
    {
      Realpay = SumRest*(-1);
    }
    //modify by dengxh end 20040904
    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
    //if(checkAmount(fm.all("prpLlossDtoKindCode")[findex].value,fm.all("prpLlossDtoAmount")[findex].value)==false)
    //{
    //    fm.all("prpLlossDtoSumLoss")[findex].focus();
    //   alert("�⳥�������ձ�ı���/�޶�");
    //    return false;
    //}
  
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();

  //���ձ�У���Ƿ񳬹������е��޶�
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
 @description �����⸶��Ա�������(�ı����α���ʱ��ɵ������ĸı�)
              �漰���е�ǰ�еķ�����Ϣ
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay2ForSunny(field)
{
  var i = 0;
  var findex=0;       //��λ���
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����

  var DutyDeductibleRate; //�¹�����������
  
  
  
  var DriverDeductibleRate; //��ʻԱ������
  var DeductibleRate; //����������
  var MainKindDeductibleRate; //�������յľ���������


  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var ArrangeRate; 	  //Э��������
  var Realpay;        //�⸶���
  var temp;

  var fieldname=field.name; //����

  //��λ
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  //�������������Ϣ�������򷵻�
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


  //��������ֵ
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

    /*���������
     * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
     * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
     */
    temp = (SumLoss - SumRest) * ClaimRate * DutyRate * ArrangeRate;  //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α��� * Э���⳥����
    Deductibletemp = temp * DeductibleRate;  //����= temp * ������

//    if(Deductible > Deductibletemp)
//    {
//      Realpay = temp  - Deductible;
//    }
//    else
//    {

       //Ӧ ����,���ξ���������
      MainKindDeductibleRate = 0;
       //�����ձ���Ҫ�����������յľ���������
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

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(field);

  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;
*/
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.PersonLossKindCodeU.value,currentIndex);

}




 /**
 @author      ����Ⱥ
 @description �����⸶��Ա�������(�ı䵥�ۡ���Ŀ���⳥����ʱ��ɵ������ĸı�)
              ֻ�漰����������Ӧ�ĵ�ǰ�еķ�����Ϣ
 @param       Field: ������
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay1ForSunny(Field)
{
  var fieldname=Field.name; //����
  var i = 0;
  var findex=0;       //��λ���
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����

  var DutyDeductibleRate; //�¹�����������
  var DriverDeductibleRate; //��ʻԱ������
  var DeductibleRate; //����������
  var MainKindDeductibleRate; //�������յľ���������

  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⸶���
  var temp;

  //��λ
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }


  //��������ֵ
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

  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
   */

  temp = (SumLoss - SumRest) * ClaimRate * DutyRate; //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α���
  Deductibletemp = temp * DeductibleRate; //����= temp * ������

//  if(Deductible > Deductibletemp)
//  {
//    Realpay = temp - Deductible;
//  }
//  else
//  {

     //�����ձ���Ҫ�����������յľ���������
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

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(Field);

  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
/*
  var personLossData = getPageData("PersonLoss");
  var currentIndex = personLossData.currentIndex;
  currentIndex = currentIndex + 1;

  //���ձ�У���Ƿ񳬹������е��޶�
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

//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcompensatePolicyNo.value;
     var RiskCode  =fm.prpLcompensateRiskCode.value;
     var damageDate=fm.damageDate.value;
      var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
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
 @author      ���Ԫ
 @description �����⸶����е��⳥���ı�ʵ�ʼ�ֵ���˶���ʧ����ֵ�����α���ʱ������
              ���������
              �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
              # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpayForDuBang(field)
{
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DutyDeductibleRate; //�¹�����������
  var DeductibleRate; //������
  var DriverDeductibleRate;//��ʻԱ������
  var mainKindCode;   //���մ���
  var DeductibleRateOfMainKind;//���յľ���������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var ArrangeRate;		//Э���⳥����
  var Realpay;        //�⳥���
  var temp;
  var unitPrice;
  var Amount;

  var fieldname=field.name;
  var findex=0;
  //modify by caopeng start at 2005-12-23 ����try,catch�飬����һЩ����������������js����
  try{
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  
//==��ʼ��ֵ
  SumLoss       		= parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       		= parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     		= parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DutyRate      		= parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
  //Э���⳥����
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

  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * Э�������� * ���α��� * ��1 - �����ʣ�
   */
   
  try{
	  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
	  if(kindCode=="C"
	  	||kindCode=="L"
	  	||kindCode=="G"
	  	){      
	  	//��Щ���ֲ���Ҫ�����α�������
	  	temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate;
	  }else{
	  	//����������Ҫ�����α�������
	  	temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate * DutyRate  ;	
	  }
	  Deductibletemp = temp * DeductibleRate;

//============���𸽼���Ҫ������յľ���������
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
        //Ӧ Ҫ��,���ε����յ�����������
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
            //ͣʻ������������
            Realpay =  (temp * (1-DutyDeductibleRate)-unitPrice);
            
        }
        else
        {
           Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate);
        }

//================================================    

    //reason:ʵ�⴦�����ϻ��������ա��޹�ʧ�����ճ���ʱϵͳ���⸶���㲻��
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
    //reason:�ձ��ǳ�������ߣ�������ʧ��ϸΪ27�����⣬���⳥���=-��ֵ
    if((fm.all("prpLlossDtoKindCode")[findex].value=="A"||fm.all("prpLlossDtoKindCode")[findex].value=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27")
    {
      Realpay = SumRest*(-1);
    }
    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
    }catch(E)
    {
    }
    //modify by caopeng end at 2005-12-23 ����try,catch�飬����һЩ����������������js����
    calFund();
    
}

/**
 @author      ���Ԫ
 @description �����⸶����е��⳥���ı�ʵ�ʼ�ֵ���˶���ʧ����ֵ�����α���ʱ������
              ���������
              �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
              # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpayForDuBangAll()
{
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DutyDeductibleRate; //�¹�����������
  var DeductibleRate; //������
  var DriverDeductibleRate;//��ʻԱ������
  var mainKindCode;   //���մ���
  var DeductibleRateOfMainKind;//���յľ���������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var ArrangeRate;		//Э���⳥����
  var Realpay;        //�⳥���
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
	//Э���⳥����
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

	/*���������
	 * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
	*/
	var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
	if(kindCode=="C"||kindCode=="L"||kindCode=="G"){      
		temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate;
	}else{
	 	temp = (SumLoss - SumRest) * ClaimRate * ArrangeRate * DutyRate  ;	
	}  
	//============���𸽼���Ҫ������յľ���������
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
	//Ӧ Ҫ��,���ε����յ�����������
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
	    //ͣʻ������������
	    Realpay =  (temp * (1-DutyDeductibleRate)-unitPrice);	    
	}else{
	   Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate);
	}
    //reason:ʵ�⴦�����ϻ��������ա��޹�ʧ�����ճ���ʱϵͳ���⸶���㲻��
    if((kindCode=="B" ||kindCode=="D2" ||kindCode=="W")&& temp > Amount){
	    if (Amount>0){
			Realpay = Amount * (1-DutyDeductibleRate)*(1-DeductibleRate);
		}
    }
    if(Realpay > Amount &&  Amount > 0){
      Realpay = Amount;
    }
    //reason:�ձ��ǳ�������ߣ�������ʧ��ϸΪ27�����⣬���⳥���=-��ֵ
    if((kindCode=="A"||kindCode=="B")&&fm.all("prpLlossDtoFeeTypeCode")[findex].value=="27"){
      Realpay = SumRest*(-1);
    }
    //modify by dengxh end 20040904
    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  }	
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
}

function calRealpay1ForDuBang(Field){
  var fieldname=Field.name; //����
  var i = 0;
  var findex=0;       //��λ���
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����

  var DutyDeductibleRate; //�¹�����������
  var DriverDeductibleRate; //��ʻԱ������
  var DeductibleRate; //����������
  var MainKindDeductibleRate; //�������յľ���������

  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var ArrangeRate;	  //Э���⳥����
  var Realpay;        //�⸶���
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

  //============��������ֵ
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
  //================��ʼ��===================
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


  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   */
  temp = (SumLoss - SumRest) * ClaimRate * DutyRate * ArrangeRate; //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α���
  Deductibletemp = temp * DeductibleRate; //����= temp * ������


  //================����������==============================
  //�����ձ���Ҫ�����������յľ���������
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

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(Field);
  //�����������ϼơ����ϼơ��������á�ʵ����
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
		//ChargeCode="03"ʱ��ʾʩ�ȷ�
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

  //��λ
  for(i=0;i<fm.all("prpLpersonCommerceSerialNo").length;i++)
  {
	alert(fm.all("prpLpersonCommerceSerialNo")[i].value);
  	}
}


function calCompelSumPropAndPerson()
{

  var i = 0;
  var findex=0;             //��λ���
  var qindex=0;
  var SumLoss;              //������
  var UnitPrice;            //����
  var Quantity;             //����
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

  var duty= fm.indemnityDuty.value; //����
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
       else  {  //����
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

  
  var wealthTitle=    ["�Ʋ���ʧ","0","1000","2000","2000","26000","0"];
  var medicalTitle=   ["ҽ�Ʒ���","0","20000","2000","10000","26000","0"];
  var deformityTitle= ["�����˲�","0","40000","2000","40000","26000","0"];
  
  var nodutyTitle=    ["�������","0","1000","2000","2000","26000","0"];
  var noinspTitle= ["�Ʋ��ޱ��մ���","0","40000","2000","40000","26000","0"];
  var noinsmTitle=   ["ҽ���ޱ��մ���","0","20000","2000","10000","26000","0"];  
  var noinsdTitle= ["�����˲��ޱ��մ���","0","40000","2000","40000","26000","0"];



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
	
   var sumPay = parseFloat(fm.totalPay.value);  //ǿ��������ܺ�
   if(isNaN(sumPay)){
   	sumPay =0.00;
   }

   var sumFeePay =0.00;  //�������ķ���֮��
   var sumFee =0.00;     //����֮�ͣ���������������
   var sumPaid =0.00 ;  //���ϼ�
   var sumdutyPaid =0.00;
   var sumPrePaid = 0.00;  //��Ԥ�����
   var sumThisPaid = 0.00; //�����⸶���
   
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
 
  fm.prpLcompensateSumDutyPaid.value   = point(round(sumPay,2),2);	//���ϼ�
  fm.prpLcompensateSumNoDutyFee.value  = point(round(sumFee,2),2); //���úϼ�
  fm.prpLcompensateSumPaid.value       = point(round(sumPaid,2 ),2) ;    //����ܼ�
  fm.prpLcompensateSumThisPaid.value   = point(round(sumThisPaid,2 ),2) ;   //�����⸶���
  fm.prpLcompensateSumSelfValue.value  = 0;  //�������Ը���
  fm.prpLdangerRiskSumPaid.value       = point(round(sumPaid,2 ),2) ; 
	
}
  function checkNodutyQuota(field)
  {
  	
  	var index = getElementOrder(field);


  	if(parseFloat(fm.all("dutyPercent")[index-1].value) == 0 && parseFloat(fm.all("noneDutyLoss")[index-1].value)> 100)
  	{
  		alert("��������޶�ܳ���100Ԫ");
  		fm.all("noneDutyLoss")[index-1].value = 100;
  	}
  	
  	if(parseFloat(fm.all("dutyPercent")[index-1].value) > 0 && parseFloat(fm.all("noneDutyLoss")[index-1].value) != 0)
  	{
  		alert("�ó��������������Ϊ0��");
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
  			alert("�Ѿ�¼������Ŀ��");
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
  			if (fm.all("limitType")[i].value=='90'&& field.value == "�����ޱ��մ���") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='91'&& field.value == "ҽ���ޱ��մ���") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='92'&& field.value == "�Ʋ��ޱ��մ���") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}  
  		}
  	}else{
  		for ( i=0;i<fm.all("limitType").length;i++ ){
  			if (fm.all("limitType")[i].value=='93'&& field.value == "�����ޱ��մ���") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='94'&& field.value == "ҽ���ޱ��մ���") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}else if (fm.all("limitType")[i].value=='95'&& field.value == "�Ʋ��ޱ��մ���") {  
	    		 	fm.all("NoInsLimitPaid")[index1-1].value =fm.all("limitFee")[i].value;
	    		}  
  		}
  	
  	}	
	setRealPaid(field);
}
function checkBeyondQuota(){


	
  var i=0;

  var duty= fm.indemnityDuty.value; //����
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
       else  {  //����
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
  


   //�Ʋ�+ʩ�ȷ�
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
   	alert (" �Ʋ��˶��⳥�����˲Ʋ��޶"+quotaBZ_P+"Ԫ�� ");
      	return false;
      	
   }
   
   
   //����ҽ��
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
   	alert ("��Աҽ�ƺ˶��⳥�����˲Ʋ��޶"+quotaBZ_M+"Ԫ�� ");
   	
   	return false;
     }
     
     if ( deathFee > quotaBZ_D){
   	alert (" ��Ա�����˲к˶��⳥�����˲Ʋ��޶"+quotaBZ_D+"Ԫ�� ");
   	
   	return false;
     }
     return true;
 
}

function checkBeyondQuotaForGuoYuan(field){


    
  var i=0;

  var duty= fm.indemnityDuty.value; //����
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
       else  {  //����
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
  


   //�Ʋ�+ʩ�ȷ�
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
	    alert (" �Ʋ��˶��⳥�����˲Ʋ��޶"+quotaBZ_P+"Ԫ�� ");
	        return false;
	        
	   }
  
   }
   
   
   //����ҽ��
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
	    alert ("��Աҽ�ƺ˶��⳥�����˲Ʋ��޶"+quotaBZ_M+"Ԫ�� ");
	    
	    return false;
	     }
	     
	     if ( deathFee > quotaBZ_D){
	        alert (" ��Ա�����˲к˶��⳥�����˲Ʋ��޶"+quotaBZ_D+"Ԫ�� ");
	    
	        return false;
	     }
	   
   }
     return true;
 
}


function makeDisabledFalse(field){
     var serialNo=0; //��λ
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
 *��������˶��⳥����
 */
function calPropSumDefPay(field,flag){
    var SumDefPay ;         //�˶��⳥
    var SumLoss ;           //������
    var SumRest ;           //�޳����
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
 *@description ����ǲ��ǿ��԰��ύ��ť
 *@return      ͨ������true,���򷵻�false
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