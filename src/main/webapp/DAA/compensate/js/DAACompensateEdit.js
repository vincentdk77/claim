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
    //  return false;
    //}
    ////������߳�������
    //if(checkThirdParty()==false)
    //{
    //  return false;
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
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{
  //Ĭ��չ���ر�Լ��
  var span = eval("spanEngage");
  span.style.display="";
  span.src="/claim/images/butExpandBlue.gif";

  calSumRealpayInit();
  calFund();
  calLoss();
  

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
    var personCount = parseInt(fm.personCount.value);
    var seatCount   = parseInt(fm.prpLcompensateSeatCount.value);
    var D3D4Count = 0;

/*  if((fm.prpLpersonLossSerialNo.length-1)>personCount)
    {
        alert("��¼�����Ա��������������������");
        return false;
  }
 */
  //add for :������Ϣ�ձ���Ϊ��--start---------------

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
      /*
      if(parseFloat(fm.prpLchargeChargeAmount[j].value) != parseFloat(fm.prpLchargeChargeReport[j].value)){
      		if(parseFloat(fm.prpLchargeChargeAmount[j].value) != 0){
      			alert("���������������ʧ�����Ȼ���Ϊ0���������������Ϣ¼��!");
      			return false;
      		}
      
      }
      */
   }    
   //�Ƿ�����˲�������ļ���
   var sumDutyDeductibleFlag = fm.sumDutyDeductibleFlag;
   if(sumDutyDeductibleFlag != null && sumDutyDeductibleFlag.value != '1'){
        alert("��������������㰴ť���в���������Լ�յ�������");
        return false;
   }
  //add for :������Ϣ�ձ���Ϊ��--end---------------
 
  
  //���Ƽ�ʻԱ������ֻ���⸶1��,������Ա<=�˶���λ��
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
      alert("��ʻԱ������ֻ���⳥1��");
      return false;
  }    
  if(D3D4Count>seatCount)
  {
      alert("������Ա�������⳥�������ܴ��ڳ����˶��ؿ���");
      return false;
  } 
 if( checkQuotaByKindCode()==false){
   fm.prpLctextContextInnerHTML.value="";
   return false;
    
 }
/*
  if(fm.GenerateCompensateFlag.value=="1"){
    alert("���������㱨��");
    return false;
  }
*/ 
  //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }


 
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //textarea�ı�������ֵ
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "���㱨�治����Ϊ��\n";
  }
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    errorMessage = errorMessage + "���ϼƲ�����Σ�յ�λ��Ϣ���ʵ����";
  }
  
  //����֧������������ݲ���Ϊ��
  if(fm.prpLcompensateClassCode.value == '05'){
     var prpLcompensateOjectName  = fm.prpLcompensateOjectName.value;
     var prpLcompensateOjectCode  = fm.prpLcompensateOjectCode.value;
     if(prpLcompensateOjectName == ''){
       errorMessage = errorMessage + "֧������ֵ����Ϊ�գ�";
     }else if(prpLcompensateOjectCode == ''){
       errorMessage = errorMessage + "֧������֤������ֵ����Ϊ�գ�";
     }
  }
  
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm,'Engage_Data,lLoss_Data,PersonFeeLoss_Data,CompensateLoss_Data,Person_Data,Charge_Data'))
  {
    return false;
  }

  fm.target="";
  var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  if(saveType==4){
    /*���ڹ��ٵ�Ҫ����Ҫ����ȥ���������жϡ�
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
        //add end 2005-09-20
        
    */
    /*
    if(underWriteFlag!=1){
     alert("���⸴�˲�ͨ��ʱ�����ύ");
     return false;
    }
    */
    
    //����������ύǰУ���Ƿ���ǰ�ڵ㶼�����ύ״̬
    if(checkSubmitButton() == false){
       return false;
    }
    //�⸶�����Ϣ���⸶��Ա��Ϣ������һ������д���������ύʵ��
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLpersonLossSerialNo = fm.prpLpersonLossSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLpersonLossSerialNo == undefined)
    {
      alert("�⸶�����Ϣ���⸶��Ա��Ϣ������һ������д���������ύʵ��");
      return false;
    }
    //�Ƿ��ӡ�Ĺ���
    //if(window.confirm("��Ҫ��ӡ��������")) {
    //  fm.prpLcompensatePrintFlag.value="1";
    //  //fm.target="_blank";
   // }
  }

    //������ύ���ж��Ƿ���nextNodeNo������ԱΪ�գ�������
  /*
  if (saveType=="4")
  {
    if (trim(fm.nextNodeNo.value).length<1)
    {
        alert("��ѡ��Ҫ�ύ����һ���ڵ㣡")
        return false;
    }
    if (trim(fm.nextHandlerCode.value).length<1)
    {
        alert("��ѡ��Ҫ�ύ����һ���ˣ�")
        return false;
    }
  }
  */
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  //modify by weishixin add end 20040616
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

  //�������,�����޷�������һҳ
  //fm.Sex.disabled = false;

  //��������
  //saveRecord("Loss");
  //saveRowRecordToSingleTable("PersonLoss","Kind");

  var oldAction = fm.action;
  var oldTarget = fm.target;

  fm.action="/claim/compensateGenerate.do";
  fm.target="fraCalculate";

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

//modify by wangli remark start 20050409
/*
//��ť�����¼��������������ʾ
function buttonOnClick1(fieldObject)
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

//��ť�����¼���������ͬ��������౨������ʾ
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
 */
 //modify by wangli remark end 20050409

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
  var realPays = document.getElementsByName("prpLchargeSumRealPay");
  var amounts  = document.getElementsByName("prpLchargeChargeAmount");
  for( i = 1; i < realPays.length; i++ )
  {
    //alert("i:="+i+"---value----"+fm.all("prpLchargeSumRealPay")[i].value);
    chargeRealPay = parseFloat(realPays[i].value); //�������
    chargeAmount  = parseFloat(amounts[i].value);  //����
     
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

  var lossData= getTableElements("lLoss");

  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  var dblRealPayA = 0;    //�����գ�A���������
  var dblRealPayATotal = 0; //�����գ�A��������������Ϊ��


  
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
      //add by qinyongli 2006-01-12 begin  ���ӶԳ�����ʧ�ս���ͳ�ƣ����ڼ������
      if(kindCodes[i].value=="A" ){
          dblRealPayA = dblRealPayA + lossRealPay;
      }
    }
  }

  var deductibleAall = parseFloat(fm.prpLDeductible.value);
  if(isNaN(deductibleAall))
      deductibleAall = 0;
  //�ó���������ȥ�����

  dblRealPayATotal = dblRealPayA - deductibleAall;

  dblSumDutyPaid = dblSumDutyPaid - deductibleAall;//�����ȥ������������0������������м�ȥ����
  fm.lastRealPay.value = dblRealPayATotal
 
  //add by qinyongli 2006-01-12 end

  //3.�⸶��Ա���⸶�ϼ�
  //��������
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

  //�õ�Ԥ����
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value,10);
  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //�������ϼ�
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee;

  //����ʵ����
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
  var ChargeAmount = 0;         //���ý��
  var ChargeRealPay = 0;        //���������

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
    var vPrpLchargeKindCode = fm.prpLchargeKindCode[findex].value; //�ձ����
    if(chargeCode=='03' && vPrpLchargeKindCode != 'B'){
        fm.all("prpLchargeSumRealPay")[findex].value =parseFloat(chargeAmount);
    }else if(chargeCode=='03' && vPrpLchargeKindCode == 'B')
    {
    	//���Ϊ���������α��յ�ʩ�ȷѣ������������ʵ�ʷ��������������������û�����
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
    var vPrpLchargeKindCode = fm.prpLchargeKindCode[findex].value; //�ձ����
    //modify by lirj update begin 040508
    //reason:�������м���������Զ�������Ϊֻ��
    ////ChargeCode="03"ʱ��ʾʩ�ȷ�
    if(chargeCode=='03' && vPrpLchargeKindCode != 'B'){
        fm.all("prpLchargeSumRealPay")[findex].value = Field.value;
    }else if(chargeCode=='03' && vPrpLchargeKindCode == 'B'){
        //���Ϊ���������α��յ�ʩ�ȷѣ������������ʵ�ʷ��������������������û�����
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
  		errorMessage("ʵ�ʷ��ò��ܳ������ý�");
        Field.focus();
        Field.select();
        return false;
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
  var ChargeAmount = 0;         //���ý��
  var ChargeRealPay = 0;        //���������
  
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
       fm.all("prpLpersonLossKindCode")[findex].value!="R" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="001" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="003" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="H" &&
       fm.all("prpLpersonLossKindCode")[findex].value!="004"  )
    {
      alert("��Ա�⸶��Ϣ��ֻ����¼����������Ρ���ʻԱ���Ρ��˿����ε��⸶��Ա�������ձ�");
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
  var Realpay=0;          //�����
  var SumRealpay=0;       //�⸶�ϼ�
  var SumDefpay=0;       //�˶��⳥�ϼ�
  var Defpay=0;

  var fieldname=field.name; //����

  //��λ
  var fieldNames = document.getElementsByName(fieldname);
  for(i=1;i<fieldNames.length;i++)
  {
    if( fieldNames[i] == field )
    {
      findex=i;
      break;
    }
  }

  //��������ֵ
  Realpay    = 0;
  SumRealpay = 0;

  //�����⸶�ϼ�
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
  //��������ʾ���⸶�ϼ����õ�������
  document.getElementsByName("prpLpersonLossSumRealPay1")[findex1].value =  point(round(SumRealpay,2),2);
  document.getElementsByName("prpLpersonLossSumDefPay1")[findex1].value =  point(round(SumDefpay,2),2);
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

  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
   */
  temp = (SumDefPay) * ClaimRate * DutyRate; //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α���  //LYM
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
  var Defpay =0;       //�⸶�ϼ�
   var SumDefpay =0;       //�⸶�ϼ�
  //��λ
  for(i=0;i<fm.all("prpLpersonLossSumRealPay1").length;i++)
  {
    //��������ֵ
    Realpay    = 0;
    SumRealpay = 0;
    Defpay =0;   
    SumDefpay =0;    

    //�����⸶�ϼ�
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

    //��������ʾ���⸶�ϼ����õ�������
    fm.all("prpLpersonLossSumRealPay1")[i].value =  point(round(SumRealpay,2),2);
     fm.all("prpLpersonLossSumDefPay1")[i].value =  point(round(SumDefpay,2),2);
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
       /*
       //setReadonlyOfElementOfLoss(fm.LossSumRest); //�ſ���ֵ�����ֹ����롣
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

  var SumDefPay       //�˶��⳥
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var ArrangeRate;    //Э��������
  var Realpay;        //�⸶���
  var temp;

  var fieldname=field.name; //����

  //��λ
  var fieldNames = document.getElementsByName(fieldname);
  for(i=1;i<fieldNames.length;i++)
  {
    if( fieldNames[i] == field )
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


  //��������ֵ
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
	
	    /*���������
	     * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
	     * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
	     */
	     //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α��� * Э���⳥����   R �� H����Ҫ�������α��� 
	    if(kindCodes[findex].value=="R" || kindCodes[findex].value=="H"){
	    	temp = (SumDefPay ) * ClaimRate * ArrangeRate; 
	    }
	    else{
	    	temp = (SumDefPay ) * ClaimRate * DutyRate * ArrangeRate; 
	    }
	    Deductibletemp = temp * DeductibleRate;  //����= temp * ������
	
	    //Ӧ ����,���ξ���������
	    MainKindDeductibleRate = 0;
	    //�����ձ���Ҫ�����������յľ���������
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

  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(field);

  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();

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
     var vURL = CoreWebUrl +'/'+ RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
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
  var ArrangeRate;      //Э���⳥����
  var Realpay;        //�⳥���
  var  KindAmount = 0;    //�⳥�޶�
  var CISumRealPay      //��ǿ�������
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
  
      //ʵ����ʧ
      SumLoss               = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
      //��ֵ
      SumRest               = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
       //�˶��⳥
      SumDefPay             = parseFloat(fm.all("prpLlossDtoSumDefPay")[findex].value);
      //�б�����
      ClaimRate             = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
      //�¹����α���
      DutyRate              = parseFloat(fm.all("prpLlossDtoIndemnityDutyRate")[findex].value);
      //Э���⳥����
      ArrangeRate           = parseFloat(fm.all("prpLlossDtoArrangeRate")[findex].value);
      //�¹�����������
      DutyDeductibleRate    = parseFloat(fm.all("prpLlossDtoDutyDeductibleRate")[findex].value);
      //����������
      DeductibleRate        = parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
      //��ǿ�������
      CISumRealPay          = parseFloat(fm.all("prpLlossDtoCISumRealPay")[findex].value);
      
      unitPrice             = parseFloat(fm.all("prpLlossDtoUnitPrice")[findex].value);
      Amount                = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
      //�����
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

   /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * Э�������� * ���α��� * ��1 - �����ʣ�
   */
  try{
      var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;      
	/*
	 *ȡ�⳥�޶�
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
        //��Щ������Ҫ�����α�������
        temp = (SumDefPay) * ClaimRate * ArrangeRate* DutyRate;  //LYM 20060620
      }else{
        //�������ֲ���Ҫ�����α�������
        temp = (SumDefPay) * ClaimRate * ArrangeRate ;   //LYM 20060620
      }
 
        /*
          ���˶��⳥���⳥������Э�̱���(1-����������)��1-���������ʣ�.
          ����,���˶��⳥���⳥������Э�̱���*���α�����(1-����������)��1-���������ʣ�.
          ���е��ձ��ʺϸù�ʽ�����ڽ������ĳ�����е���
        */
        
        Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate); 
        /**
         *�ձ�û�����������ʣ����о��������ʵġ�
         *������ȫ�������ա����ֵ������ա���������ʧ�ա���ȼ��ʧ�ա�����������Ⱦ�����ա����Ӹ߶�����ߵ����ա���ͨ�¹ʾ������⳥��
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
         ȫ�������գ����ж��Ƿ����ˡ�ȫ������������������������δ�������䡱�������������緢��������Ҫ������������ʣ���֮����ȫ�⡣
        */
        if(kindCode == "G"){
                var conditionsFlag = 0; //ȫ���������Ƿ��С�ȫ��������������������������δ�������䡱������������ı�ʶ��0��û�У�1����
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
         �ձ��û�����������ʣ�Ҳû�о��������ʵġ�
         �������������������ա���ˮ��ʻ��ʧ�ա���ˮ��ʻ��ʧ�ա��������������ա������¹ʸ��������ʧ�ա�������Լ�� 
			 �����������ա�����ͣʻ��ʧ�ա�����������Լ��A������������Լ��B���泵������Ʒ��ʧ��
         
        */
        if(kindCode == "F" || kindCode == "X3" || kindCode =="K6" || kindCode == "K10" || kindCode =="U" || 
           kindCode == "C" || kindCode == "T"  || kindCode =="NX" || kindCode == "NY"  || kindCode =="X4"
           ){
            
            Realpay =  temp ;
           
        }
        /*��Ҫ��ȥ�����
          ����:������ʧ�ա����ڳ����տ���¼�����,�����������ж���ֻ�е�һ����ʱ���ȥ�����.
        */
        /* ����ϼƵ�ʱ���������������������ü���.
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
        //������������Լ����
        if(kindCode == "M"){
            Realpay = SumDefPay;
        }
        /*
        * �⳥�����⳥�޶�ʱ
        */
        if(kindCode == "Z" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("��ȼ��ʧ�յ��������ڸ��ձ�ı��ս�" +KindAmount+ "��,�����⳥���Ϊ��" +KindAmount);
        }else if(kindCode == "X3" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("��ˮ��ʻ��ʧ�յ��������ڸ��ձ�ı��ս�" +KindAmount+ "��,�����⳥���Ϊ��" +KindAmount);
        }else if(kindCode == "L" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("��������ʧ�յ��������ڸ��ձ�ı��ս�" +KindAmount+ "��,�����⳥���Ϊ��" +KindAmount);
        }else if(kindCode =="D2" && (Realpay >KindAmount)){
            Realpay = KindAmount;
            alert( "���ϻ����������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);               
        }else if(kindCode == "X" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�������豸��ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "K6" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�泵������Ʒ��ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "K10" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�����¹ʸ��������ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "H" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "���ػ�������������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "R" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "��ͨ�¹ʾ������⳥���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "C" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�������������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "V1" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "����������Ⱦ�������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "X4" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "ϵ��ȫ���������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }
        
	    SumDefPay = SumLoss - SumRest - CISumRealPay;  
	    fm.all("prpLlossDtoSumDefPay")[findex].value = point(round(SumDefPay,2),2);
	
	    fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
    }catch(E)
    {
    }
    //modify by caopeng end at 2005-12-23 ����try,catch�飬����һЩ����������������js����
    calFund();
    checkQuotaByKindCode();
    
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
  var ArrangeRate;      //Э���⳥����
  var Realpay;        //�⳥���
  var SumDefPay;      //�˶��⳥
  var  KindAmount = 0;    //�⳥�޶�
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
    //Э���⳥����
    ArrangeRate         = parseFloat(arrangeRates[findex].value);
    DutyDeductibleRate  = parseFloat(dutyDeductRates[findex].value);
    DeductibleRate      = parseFloat(deductRates[findex].value);
    unitPrice           = parseFloat(unitPrices[findex].value);
    Amount              = parseFloat(mounts[findex].value);
    //�����
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

    /*���������
     * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
    */
    var kindCode = kindCodes[findex].value;      
	/*
	 *ȡ�⳥�޶�
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
        //��Щ������Ҫ�����α�������
        temp = (SumDefPay) * ClaimRate * ArrangeRate* DutyRate;  //LYM 20060620
      }else{
        //�������ֲ���Ҫ�����α�������
        temp = (SumDefPay) * ClaimRate * ArrangeRate ;   //LYM 20060620
      }
 
        /*
          ���˶��⳥���⳥������Э�̱���(1-����������)��1-���������ʣ�.
          ����,���˶��⳥���⳥������Э�̱���*���α�����(1-����������)��1-���������ʣ�.
          ���е��ձ��ʺϸù�ʽ�����ڽ������ĳ�����е���
        */
        
        Realpay =  temp * (1-DutyDeductibleRate)*(1 - DeductibleRate); 
        /**
         *�ձ�û�����������ʣ����о��������ʵġ�
         *������ȫ�������ա����ֵ������ա���������ʧ�ա���ȼ��ʧ�ա�����������Ⱦ�����ա����Ӹ߶�����ߵ����ա���ͨ�¹ʾ������⳥��
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
         ȫ�������գ����ж��Ƿ����ˡ�ȫ������������������������δ�������䡱�������������緢��������Ҫ������������ʣ���֮����ȫ�⡣
        */
        if(kindCode == "G"){
                var conditionsFlag = 0; //ȫ���������Ƿ��С�ȫ��������������������������δ�������䡱������������ı�ʶ��0��û�У�1����
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
         �ձ��û�����������ʣ�Ҳû�о��������ʵġ�
         �������������������ա���ˮ��ʻ��ʧ�ա���ˮ��ʻ��ʧ�ա��������������ա������¹ʸ��������ʧ�ա�������Լ�� 
			 �����������ա�����ͣʻ��ʧ�ա�����������Լ��A������������Լ��B
         
        */
        if(kindCode == "F" || kindCode == "X3" || kindCode =="K6" || kindCode == "K10" || kindCode =="U" || 
           kindCode == "C" || kindCode == "T"  || kindCode =="NX" || kindCode == "NY"  || kindCode =="X4"
           ){
            
            Realpay =  temp ;
           
        }
        /*��Ҫ��ȥ�����
          ����:������ʧ�ա�
        */
        /*����ϼƵ�ʱ���������������������ü���.
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
        //������������Լ����
        if(kindCode == "M"){
            Realpay = SumDefPay;
        }
        /*
        * �⳥�����⳥�޶�ʱ
        */
        if(kindCode == "Z" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("��ȼ��ʧ�յ��������ڸ��ձ�ı��ս�" +KindAmount+ "��,�����⳥���Ϊ��" +KindAmount);
        }else if(kindCode == "X3" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("��ˮ��ʻ��ʧ�յ��������ڸ��ձ�ı��ս�" +KindAmount+ "��,�����⳥���Ϊ��" +KindAmount);
        }else if(kindCode == "L" && Realpay > KindAmount){
            Realpay = KindAmount;
            alert("��������ʧ�յ��������ڸ��ձ�ı��ս�" +KindAmount+ "��,�����⳥���Ϊ��" +KindAmount);
        }else if(kindCode =="D2" && (Realpay >KindAmount)){
            Realpay = KindAmount;
            alert( "���ϻ����������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);               
        }else if(kindCode == "X" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�������豸��ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "K6" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�泵������Ʒ��ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "K10" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�����¹ʸ��������ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "H" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "���ػ�������������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "R" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "��ͨ�¹ʾ������⳥���⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "C" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "�������������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "V1" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "����������Ⱦ�������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }else if(kindCode == "X4" && (Realpay >KindAmount)){
        	Realpay = KindAmount;
            alert( "ϵ��ȫ���������⳥�������⳥�޶�("+KindAmount +" Ԫ),�����⳥���Ϊ��" + KindAmount);
        }
     
    realPays[findex].value = point(round(Realpay,2),2);
  } 
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
  checkQuotaByKindCode();
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
  var ArrangeRate;    //Э���⳥����
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


  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   */
  if(fm.all("prpLpersonLossKindCode")[findex1].value == "R" || fm.all("prpLpersonLossKindCode")[findex1].value =="H"){
 	 temp = (SumDefPay) * ClaimRate * ArrangeRate; //temp=���˶���ʧ - ��ֵ��* �⳥���� * ���α���  //LYM 20060620
  }
  else{
  	 temp = (SumDefPay) * ClaimRate * DutyRate * ArrangeRate; 
  }
  Deductibletemp = temp * DeductibleRate; //����= temp * ������
   

  //================����������==============================
  //�����ձ���Ҫ�����������յľ���������
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
/*=====================��Ԫ====================*/
  if(fm.all("prpLpersonLossKindCode")[findex1].value=="B"  ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D3" ||
     fm.all("prpLpersonLossKindCode")[findex1].value=="D4"){
     Realpay =  temp *(1-DutyDeductibleRate)*(1 - DeductibleRate);
  }
//  if(temp>Amount){
  //    Realpay = Amount*(1-DutyDeductibleRate)*(1 - DeductibleRate);
     
 //}
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);


  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(Field);
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
}

function setRealPay(){
    for(i=1;i<fm.all("prpLchargeSerialNo").length;i++){
        //ChargeCode="03"ʱ��ʾʩ�ȷ�
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
  var findex=0;             //��λ���
  var qindex=0;
  var SumLoss;              //������
  var UnitPrice;            //����
  var Quantity;             //����
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

  
  var wealthTitle=["�Ʋ���ʧ","0","1000","2000","50","26000","10000","10","10","8100","8100"];
  var medicalTitle=["ҽ�Ʒ���","0","20000","2000","50","26000","10000","10","10","8100","8100"];
  var deformityTitle=["�����м�","0","40000","2000","50","26000","10000","10","10","8100","8100"];
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
*�����ձ��Ƿ����¼���ֵ
*/
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
  if(fm.all("prpLlossDtoKindCode")[findex].value=="B" && fm.all("prpLlossDtoFeeTypeCode")[findex].value!="27"){
    alert("B�ձ�����¼���ֵ��");
    setReadonlyOfElementOfLoss(fm.all("prpLlossDtoSumRest")[findex]);
    fm.all("prpLlossDtoSumRest")[findex].value="0.00";
  }
}

/**
*
*�޸ĸð����¹����α���ʱ��������ʧ���¹����α�����Ϊ�ð����¹����α��� 
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


//��ҵ���Ƿ񳬹��޶��ж�
function  checkQuotaByKindCode(){
  //��ʱֻ����kindCode='B'
  var indemnityDutyRate; //���α���
  

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
    var kindCodeCount = 0; //�ձ������¼��
    var ArrangeRate;       //Э���⳥����
    var DeductRate         //����������
    var DutyDeductRate     //����������
    var  kindCode = kindCodes[i].value ;
    var  KindAmount = parseFloat(kindAmounts[i].value);
   
    if(lossCodes != null && lossCodes.length != null) {      
      for (var k=1;k < lossCodes.length;k++){
        if ( lossCodes[k].value== kindCode ){
          sumRealPayTemp +=parseFloat(defPays[k].value);  
          kindCodeCount++;
          ArrangeRate = parseFloat(arrangRates[k].value);  //ͬһ�ձ��Э�̱�������һ���ġ�
          DeductRate  = parseFloat(deductRates[k].value);
          DutyDeductRate  = parseFloat(dutyRates[k].value);
          if(isNaN(sumRealPayTemp)) {
            sumRealPayTemp=0;
          }
          
        }
      }
    }
    //B��D3��D4�����������
    if(kindCode == "B" || kindCode == "D3" ||kindCode == "D4" ){
	    if(personKindCodes != null && personKindCodes.length != null) {
	      for (var j=1;j < personKindCodes.length;j++){
	        if (personKindCodes[j].value== kindCode ){
	          sumRealPayTemp +=parseFloat(personDefPay1s[j].value); 
	          kindCodeCount++; 
	          if ( isNaN(sumRealPayTemp)) {
	            sumRealPayTemp=0;
	          }
	          //������Ա�����գ���ÿ����Ա�����������˰��¹����α���Ӧ�����⳥����ÿ���⳥�޶���Ƚ�
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
                           alert( " ������Ա�������⳥������ÿ���⳥�޶�("+KindAmount +" Ԫ),������˶����������������㱨��");                            
                      }
	          }
	        }
	      }
	    }         
    }
    //������A����ʩ�ȷ�
    if(kindCode == "A"){
        //�ݲ��Գ��������ж�
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
         alert( " �������������⳥�������⳥�޶�("+KindAmount +" Ԫ),������˶����������������㱨��");
         return false; 
    }
    /* ǰ���жϹ������㳢�޶���ն��⳥
    else if(  kindCode =='Z' 
            && (sumRealPayNoDutyRate * (1-DeductRate) >KindAmount) 
            && kindCodeCount > 1){
         alert( " ��ȼ��ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),������˶����������������㱨��");
         return false; 
    }else if(  kindCode =='X3' 
            && (sumRealPayNoDutyRate >KindAmount) 
            && kindCodeCount > 1){
         alert( " ��ˮ��ʻ��ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),������˶����������������㱨��");
         return false; 
    }else if(   kindCode =='L' 
            && (sumRealPayNoDutyRate * (1-DeductRate) >KindAmount) 
            && kindCodeCount > 1){
         alert( " ��������ʧ���⳥�������⳥�޶�("+KindAmount +" Ԫ),������˶����������������㱨��");
         return false;   
    }else if(   kindCode =='D2' 
            && (sumRealPayNoDutyRate * (1-DeductRate)*(1-DutyDeductRate) >KindAmount) 
            && kindCodeCount > 1){
         alert( " ���ϻ����������⳥�������⳥�޶�("+KindAmount +" Ԫ),������˶����������������㱨��");
         return false;   
    }else {
     
    } 
    */
  } 
  return true;
}

function changeIndemnityDuty()
{
  var indemnityDuty =""; //���õ�ֵ
  var i= 0;              //ѭ��ʹ��


  switch (fm.indemnityDuty.value)
  {
    case "0":   //ȫ��
      indemnityDuty = "100";
      break;
    case "1":   //����
      indemnityDuty = "70";
      break;
    case "2":   //ͬ��
      indemnityDuty = "50";
      break;
    case "3":   //����
      indemnityDuty = "30";
      break;
    case "4":   //����
      indemnityDuty = "0.0";
      break;
    case "9":   //����
      indemnityDuty = "0.0";
      break;
  }

  fm.prpLcompensateIndemnityDutyRate.value =indemnityDuty;

  
}


   //�����¹�����������
   function changeAccidentDeductRate()
   {
     var indemnityDuty =fm.indemnityDuty.value;   //����
     var deductRate="";//����������
     var kindDuty="";  //�ձ�����ƴ��  
     var kindCode ="";
     var strKindDuty ="";
    
     var i = 0;              //ѭ��ʹ��
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
      
       //�ı��Ѿ����ڵ�

       for (i=0;i<kindCodes.length;i++){    //-----���
           kindCode = kindCodes[i].value;
           strKindDuty =kindCode+indemnityDuty ;
          if ( kindDuty ==strKindDuty){
              dutyDeductRates[i].value = deductRate ;
          }
        } 
       for (i=0;i<personKindCodes.length;i++){  //----���� 
           kindCode = personKindCodes[i].value;
           strKindDuty =kindCode+indemnityDuty ;
          if ( kindDuty ==strKindDuty){
              personDutyRates[i].value = deductRate ;
          }
       }
       //�����ڵĵ�����ʱ�������µ�������
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
  
   //������Ϣ��ѡ�����ձ����¹����������ʺ;��������ʴ�����
   function getPersonDeductRate()
   {
     var indemnityDuty =fm.indemnityDuty.value;   //����
     
     var deductRate="";//����������
     var kindDuty="";  //�ձ�����ƴ��  
     var kindCode ="";
     var strKindDuty ="";
    
     var i = 0;              //ѭ��ʹ��
     var j = 0;
     var m = 0;
     var n = 0;
   
     for (j=0;j<fm.all("kindCodedutyName").length;j++ ){  //1
       kindDuty= fm.all("kindCodedutyName")[j].value; 
       deductRate= fm.all("deductRate")[j].value; 
       
       for (i=0;i<fm.all("prpLpersonLossKindCode").length;i++){  //----���� 
           kindCode = fm.all("prpLpersonLossKindCode")[i].value;
           strKindDuty =kindCode+indemnityDuty ;
          if ( kindDuty ==strKindDuty){
              fm.all("prpLpersonLossDutyDeductibleRate")[i].value = deductRate ;
          }

       }
       
   }
   
   for (m=0;m<fm.all("kindCode2").length;m++ ){  //����������
    
       kindCode2= fm.all("kindCode2")[m].value; 
       absolutDeductRate= fm.all("absolutDeductRate")[m].value; 
      
       for (n=0;n<fm.all("prpLpersonLossKindCode").length;n++){  //----���� 
           kindCode = fm.all("prpLpersonLossKindCode")[n].value;
          if ( kindCode ==kindCode2){
              fm.all("prpLpersonLossDeductibleRate")[n].value = absolutDeductRate ;
          }
       }
       
   }
    

   
}

//�����������
function SumDutyDeductible(){
     var SumDefPay ;         //�˶��⳥
     var DutyDeductibleRate; //�¹�����������  
     var DutyRate;           //���α���
     var DeductibleRate;      //����������
     var kindCode;            //�ձ�

      var SumRest;           //��ֵ
      var ClaimRate;         //�⳥����
      var Deductible;        //�����
      var ArrangeRate;       //Э���⳥����
      var lossFlag ;          //�б��˲���������Լ�յı�־
      var Amount;             //����
      
  
     var indemnityDuty =fm.indemnityDuty.value;   //����
     var SumRealPay ;        //�⳥���   
     SumRealPay = 0;
     var temp;
     var i = 0;              //ѭ��ʱʹ��
     var j = 0;              //ѭ��ʱʹ��    
     /*
        ��Ĳ����������
     */
     
     var conditionsFlag = 0; //ȫ���������Ƿ��С�ȫ��������������������������δ�������䡱������������ı�ʶ��0��û�У�1����
     for(i = 0;i < fm.all("deductCondition").length;i++){       
        if(  fm.all("deductCondition")[i].value == "290" 
          && fm.all("deductName")[i].value == "ȫ��������������������������δ��������" 
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
	            //��Щ������Ҫ�����α�������
	            temp = (SumDefPay) * ClaimRate * ArrangeRate * DutyRate   ;  
	          }else{
	            //�������ֲ���Ҫ�����α�������
	            temp = (SumDefPay) * ClaimRate * ArrangeRate;  
	          }
                 

            
            if(kindCode == "K16" || kindCode == "Z"   || kindCode == "L" || kindCode == "H"  ||
               kindCode == "V1"  || kindCode == "G0"  || kindCode == "R" ){   //ֻ�о��������ʵ�
               
                SumRealPay = SumRealPay + (temp * DeductibleRate);
            
            }else if(kindCode == "G"){                                    //ȫ�������ղ����������
                if(conditionsFlag == 1){
                    SumRealPay = SumRealPay + (temp * 0.2);
                }   
           
            }else if(kindCode == "D2" || kindCode =="X"){		//���������ʺ����������ʶ������
            
                SumRealPay = SumRealPay + temp*(DutyDeductibleRate + DeductibleRate - DeductibleRate * DutyDeductibleRate);
            
            }else if(kindCode == "A" || kindCode == "B" || kindCode == "D3" || kindCode == "D4"){ // �����յ�
             
               // SumRealPay = SumRealPay + temp * DutyDeductibleRate*(1-DeductibleRate);            
            	  SumRealPay = SumRealPay + temp *(DutyDeductibleRate*(1 -DeductibleRate));
            }
  
        }


     }
     /*
        ���˲����������
     */
     if(fm.all("prpLpersonLossSumDefPay") != null){
         for(i = 1;i < fm.all("prpLpersonLossSumDefPay").length;i++){
         
              SumDefPay  = parseFloat(fm.all("prpLpersonLossSumDefPay")[i].value);  //ȡ�˶��⳥
              ClaimRate          = parseFloat(fm.all("prpLpersonLossClaimRate")[i].value);
                for(j=1;j<fm.all("prpLpersonLossIndemnityDutyRate").length;j++) {
                    if(fm.all("prpLpersonLossSerialNo")[j].value==fm.all("personLossSerialNo")[i].value){
                          
                          DutyDeductibleRate = parseFloat(fm.all("prpLpersonLossDutyDeductibleRate")[j].value);  //ȡ����������
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
        ʩ�ȷѲ����������
     */
      if(fm.all("prpLchargeChargeName") != null){
      		
            for(i = 1 ;i < fm.all("prpLchargeChargeName").length;i++){
                if(fm.all("prpLchargeKindCode")[i].value == "A" && fm.all("prpLchargeChargeCode")[i].value == "03"){
                     SumDefPay = parseFloat(fm.all("prpLchargeChargeReport")[i].value);  //ȡ���ý��
                     //ȡ����������
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
                     //ȡ���α���               
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
       ��������д�벻��������Լ�յ�����ֶ���
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



