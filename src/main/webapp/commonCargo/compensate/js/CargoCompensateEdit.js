/*****************************************************************************
 * DESC       ��ʵ��Ľű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-05-19
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ��鱨���Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
//������������ֲ�����¼�������Ϣ
  if(checkBusinessType1()==false)
  {
     return false;
  }
  
   return true;    
}

/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
  //add by qingyongli start 2005-7-31 �ɶ�ҵ����ʾ
  var message = "";
  var shareHolderFlag = fm.shareHolderFlag.value;
  //add by hanliang end  2005-12-22
  //var payFee = parseInt(fm.prpLregistPayFee.value);
  //if(payFee==-1){
    //alert("�˱�������δ�ɣ�");
  //} 
  //else if(payFee==0){
    //alert("�˱�������δ��ȫ��");
  //}
  if(shareHolderFlag!=0){
     message = message + "��ǰ�������������ΪΪ�ɶ�ҵ��\n";
  }
  var payFee = parseInt(fm.payFee.value);
  var delinquentfeeCase = fm.delinquentfeeCase.value;
  if(payFee==-1){
    alert("�˱�������δ�ɣ�\n");
  } 
  else if(payFee==0){
    alert("�˱�������δ��ȫ��\n");
  }else if(payFee==-2){
     message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
     message = message + delinquentfeeCase + "\n";        
  }
  if (message.length>0) {
     alert(message);
  } 
  //add by qinyongli end  2005-7-31
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
  var errorMessage = "";

//����ר�ŵı���У��ķ���
  if(checkForm()==false)
  {
    return false;
  }
  fm.buttonSaveType.value = saveType;
  //textarea�ı�������ֵ
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "��������̲�����Ϊ��\n";
  }
   if(parseFloat(fm.prpLcompensateSumDutyPaid.value)>parseFloat(fm.prpLcompensateSumAmount.value)){
    errorMessage = errorMessage + "���⳥���ܴ����ܱ��ս��";
  }
  //����ʵ��ͬԤ���ϵ�ж� begin
   if(fm.times.value == 1){//�״�������ʵ��ͬԤ���У�飬�ؿ�����У��
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("������κϼƽ���С����Ԥ������");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("�������ò���С����Ԥ�����ý�");
    return false;
  }
  }
  //����ʵ��ͬԤ���ϵ�ж� end
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm,'Engage_Data,lLoss_Data,Limit_Data,Charge_Data'))
  {
    return false;
  }
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){
  	       	//add by lixiang start at 2006-8-1	
       //�ж����㱨���ǲ���Ϊ�յġ�	
       var 	context2=fm.prpLltextContextInnerHTML.value;
       var   lltext2title=fm.tdLltextTitle.value;
       
       if(context2.length<1){
         errorMessage = errorMessage +lltext2title+ "������Ϊ��\n";
          alert(errorMessage)
          return false;
       }
//       alert(context2.length)
//       return false;
      //add by lixiang end at 2006-8-1
  	//�ǰ��ռ��������ʵ�����Ƿ���ڹ�������ж�add by qinyongli 2005-09-20
  	/*���ڹ��ٵ�Ҫ����Ҫ����ȥ���������жϡ�
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
        //add end 2005-09-20
        */
    /*
    if(underWriteFlag!=1){
     alert("���⸴�˲�ͨ��ʱ�����ύ");
     return false;
    }*/
    //�⸶�����Ϣ���⸶��Ա��Ϣ������һ������д���������ύʵ��
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    {
      alert("���������е��⸶��ģ�������������һ����¼!");
      return false;
    }
  }
  
    //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();

  return true;
}


/**
 @author      ����Ⱥ
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

 /**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave(){

   var policyNo = fm.prpLcompensatePolicyNo.value;
   var riskCode = fm.prpLcompensateRiskCode.value;
   var businessNo = fm.prpLcompensateClaimNo.value;
   var claimNo = fm.prpLcompensateClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=compe&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?claimNo="+ fm.prpLcompensateClaimNo.value;

win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}

//Modify By sunhao add begin 2004-09-06
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){

		var policyNo = fm.prpLcompensatePolicyNo.value;
		var claimNo = fm.prpLcompensateClaimNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&claimNo=" +claimNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}
//Modify By sunhao add end 2004-09-06


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

  //�������,�����޷�������һҳ
  //fm.Sex.disabled = false;

  //��������
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

  //�������
  //clearRecord("Loss");
  //clearRecord("PersonLoss");
  //clearRowRecord("Kind");

  //load data
  //loadRowRecord("PersonLoss","Kind","Kind_Data");
  return true;
}


//��ť�����¼��������������ʾ
function buttonOnClick(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//����
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}

/**
 @author      liubvo
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
    
  var dblRest = 0;      //�����ֵ  
  var dblSumRest = 0;   //��ֵ�ϼ�

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossRealPay    = 0;
  var personLossRealPay = 0;
  
  var currency4;
  var exchRate;
  var chargeCurrency4; //���ñұ�

  
  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(fm.all("prpLchargeSumRealPay")[i].value);    //�������
    chargeAmount  = parseFloat(fm.all("prpLchargeChargeAmount")[i].value);  //����

    if(isNaN(chargeRealPay))
     chargeRealPay = 0;
    if(isNaN(chargeAmount))
     chargeAmount = 0;
    
    
   
    dblSumDutyPaid = dblSumDutyPaid + chargeRealPay;
    
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
  
  //�����ֵ�ϼ�
  for( i = 1; i < fm.all("prpLlossDtoSumRest").length; i++ ){
    dblRest = point(round(fm.prpLlossDtoSumRest[i].value,2),2);
    dblSumRest = parseFloat(dblSumRest) + parseFloat(dblRest);
  }
  fm.prpLcompensateSumRest.value = point(round(dblSumRest,2),2);
  
  //2.�⸶��ĵ��⳥���
  //��������
  var lossData= getTableElements("lLoss");
  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  for( i = 1; i < fm.all("prpLlossDtoSumRealPay").length; i++ )
  {
    lossRealPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);

    if(isNaN(lossRealPay))
      lossRealPay = 0;


    
     //�һ��ұ�
    currency4   = fm.all("prpLlossDtoCurrency4")[i].value;
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

  //�õ�Ԥ����
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //�������ϼ�
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;
  //����ʵ����
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumThisPaid,2),2);
  fm.prpLdangerRiskSumPaid.value  = point(round(dblSumPaid,2),2);
}

//��ť�����¼���������ͬ��������౨������ʾ
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

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage2(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y

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
//��ť�����¼���������ͬ��������౨������ʾ
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

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage1(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y

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

function calcuateSumRealPay(field){
    var index = getElementOrder(field)-1;
    var realPay = (parseFloat(fm.prpLlossDtoSumLoss[index].value,10) -
                    parseFloat(fm.prpLlossDtoSumRest[index].value,10)) *
                  parseFloat(fm.prpLlossDtoClaimRate[index].value,10)/100 *
                  (1 - parseFloat(fm.prpLlossDtoDeductibleRate[index].value,10)/100);
    var deductible = parseFloat(fm.prpLlossDtoSumLoss[index].value,10)*
                     parseFloat(fm.prpLlossDtoDeductibleRate[index].value,10)/100;
    
    var realPay = (parseFloat(fm.prpLlossDtoSumLoss[index].value,10) -
                    parseFloat(fm.prpLlossDtoSumRest[index].value,10)) *
                  parseFloat(fm.prpLlossDtoClaimRate[index].value,10)/100 
                  - deductible;
                   
    if(isNaN(realPay)){
        realPay = 0;
    }
    fm.prpLlossDtoDeductible[index].value = deductible; 
    fm.prpLlossDtoSumRealPay[index].value = realPay;
     //�����������ϼơ����ϼơ��������á�ʵ����
     calFund();
}

//����ǰ����㸶������ʾ�᰸���档
function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}

/**
 @author      liuyang
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
  var ItemValue;      //���ս��

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
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
  
  fm.all("prpLlossDtoCurrency3")[findex].value = fm.all("prpLlossDtoCurrency4")[findex].value;
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


  if(DeductibleRate>1){
  	alert("�����ʲ��ܴ���100");
  	fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
  	return false;
  }

     //�����������������ֻ����������һ��
  if(DeductibleRate>0&&Deductible>0){
     alert("�������������ֻ������һ��");
     if(fieldname=="prpLlossDtoDeductible"){
           fm.all("prpLlossDtoDeductible")[findex].value="0";
     }else{
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
     }
     return false;
  }   
  if (Deductible == 0) {    //û�������������㹫ʽΪ (���-��ֵ)*�⳥����*-�����������
      //Realpay = (SumLoss - SumRest) * ClaimRate - Amount*DeductibleRate;  
      Realpay = (SumLoss - SumRest) * ClaimRate*(1-DeductibleRate);  
  } else {                 //������������㹫ʽΪ (���-��ֵ)*�⳥����*-�����
      Realpay = (SumLoss - SumRest) * ClaimRate - Deductible;
  }
 
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:ֻ�����ղŽ��п���
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
  if(isMain==1&&Realpay>Amount)
  {
       alert("�⳥���ܴ��ڱ��ս��");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
  }
  calFund();
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

}

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

  for( i = 1; i < fm.all("prpLlossDtoSumLoss").length; i++ )
  {
    LossSumLoss = parseFloat(fm.all("prpLlossDtoSumLoss")[i].value);

    if(isNaN(LossSumLoss))
      LossSumLoss = 0;

    dblSumLoss = dblSumLoss + LossSumLoss;
  }
}
function checkRepeatItemCode(field)
{
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
     var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;
     var itemCode = fm.all("prpLlossDtoItemCode")[findex].value;
     //�õ��Ѿ�¼����ձ�ͱ��
     for( i = 1; i < fm.all("prpLlossDtoKindCode").length - 1; i++ )
     {
     	 if(i==findex){continue;}
         if(itemCode!=""&&fm.all("prpLlossDtoKindCode")[i].value==kindCode && fm.all("prpLlossDtoItemCode")[i].value==itemCode)
         {
             alert("��¼����ձ�ͱ���Ѿ�����");
             fm.all("prpLlossDtoItemCode")[findex].value="";
             fm.all("prpLlossDtoLossName")[findex].value="";
             fm.all("prpLlossDtoAmount")[findex].value="";
             fm.all("prpLlossDtoAmountDisplay")[findex].value="";
             fm.all("prpLlossDtoItemCode")[findex].focus();
         }
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

function validateAccount(){
	     
	     var pwd1=fm.prpLcompensateAccount.value;      
	     var pwd2=fm.prpLcompensateAccountOK.value;  	  
	     if(pwd2!=pwd1){
	              alert("���������֧���ʺŲ�һ�£�����������!");
				  fm.prpLcompensateAccount.value="";
				  fm.prpLcompensateAccountOK.value="";
				  fm.prpLcompensateAccount.focus();
	     }
	}
	
// added by fenglei ��Ԫ��Ŀ������,������ҵ������¼�������Ϣ
function checkBusinessType1(){
    var prpLcompensateBusinessType1 = fm.prpLcompensateBusinessType1.value;  //������ҵ����ҵ��ҵ���־
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;  //������Ϣ���
    if (prpLcompensateBusinessType1=="01"||prpLcompensateBusinessType1=="02"){
        if(prpLchargeSerialNo>1){
           alert("������ҵ������¼�������Ϣ!");
           return false;
           }
        }
     }