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

/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
  //add by qinyongli �ɶ�ҵ����ʾ start 2005-7-31 
  var message = "";
  var shareHolderFlag = fm.shareHolderFlag.value;
  //add by hanliang end  2005-12-22
  //var payFee = parseInt(fm.prpLregistPayFee.value);
  var coinsFlag=parseInt(fm.coinsFlag.value);
  //if(payFee==-1){
    //alert("�˱�������δ�ɣ�");
  //} 
  //else if(payFee==0){
   // alert("�˱�������δ��ȫ��");
  //}

  
  if(shareHolderFlag!=0){
     message = message + "��ǰ�������������ΪΪ�ɶ�ҵ��\n";
  }
  var payFee = parseInt(fm.payFee.value);
  if(payFee==-1){
    alert("�˱�������δ�ɣ�\n");
  } 
  else if(payFee==0){
    alert("�˱�������δ��ȫ��\n");
  }else if(payFee==-2){
     message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
  }
    if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
    	message = message + "������Ϊ��/��������\n";
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
  fm.buttonSaveType.value = saveType; 
  //textarea�ı�������ֵ
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "��������̲�����Ϊ��\n";
  }     
    if(parseFloat(fm.prpLcompensateSumDutyPaid.value)>parseFloat(fm.prpLcompensateSumAmount.value)){
    errorMessage = errorMessage + "���⳥���ܴ����ܱ��ս��";
  }
  
      //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }
  if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
    alert("���ϼƲ�����Σ�յ�λ��Ϣ���ʵ���");
    return false;
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //����ʵ��ͬԤ���ϵ�ж� begin
  if(fm.times.value == 1){//�״�������ʵ��ͬԤ���У�飬�ؿ�����У��
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("�������ϼƽ���С����Ԥ������");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("���ý���С����Ԥ�����ý�");
    return false;
  }
  }
  //����ʵ��ͬԤ���ϵ�ж� end
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  //Engage_Data,lLoss_Data,PersonFeeLoss_Data,Person_Data,Charge_Data
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
        */
        //add end 2005-09-20
    /*
    if(underWriteFlag!=1){
     alert("���⸴�˲�ͨ��ʱ�����ύ"); 
     return false;
    }*/
    //�⸶�����Ϣ���⸶��Ա��Ϣ������һ������д���������ύʵ��
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
     var prpLchargeSerialNo = fm.prpLpersonLossSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    { 
     alert("���������е��⸶��ģ��⸶��Ա��Ϣ������һ����¼!"); 
      return false; 
    }
  }

  
    if(fm.prpLcompensateRiskCode.value=="1528"){
    var claimLossLen = fm.prpLlossDtoKindCode.length;
     for(var i = 1; i < claimLossLen; i++) {
       if(fm.prpLlossDtoBrandCode[i].value==""||fm.prpLlossDtoCarNumber[i].value==""){
         alert("�����ֲƲ���ʧ�⸶��Ϣҳ���³�����Ϣ����Ϊ�գ�");
         return false;
       }
    }
  }
  
    //����������÷�̯
    var coinsFlag = fm.coinsFlag.value;	
	if(coinsFlag == "2"||coinsFlag == "1"){
	    var ChargeFeeFlag = fm.CommonCoinsChargeFeeFlag.value;	
	    if(ChargeFeeFlag == 1){
        	var prpLchargeChargeName = document.getElementsByName('prpLchargeChargeName');
        	var ChargeCoinsName = document.getElementsByName('ChargeCoinsName');
        	var size = document.getElementsByName('CoinsCode').length-1;
        	if(prpLchargeChargeName.length-1 != ChargeCoinsName.length/size){
        		alert("����������Ϣҳ���µĹ������÷�̯��ť��");
        		return false;
        	}
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

//����ǰ����⸶������ʾ�᰸���档
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
  //����������sumlossΪ��׼  
  //if(Deductible==0)
  //{
  //    Deductible = SumLoss*DeductibleRate;
  //}
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
  
  //Realpay = (SumLoss - SumRest) * ClaimRate - Deductible;
  //fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //�����������ϼơ����ϼơ��������á�ʵ����
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
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
		var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
		var coinsSelfRate = parseFloat(fm.coinsSelfRate.value ); 
		if(coinsPaidLossType == "2" ){ //¼�롰�˶���ʧ��ʱ�����㹲���������Ϣ
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay,2),2);
		}
		if(coinsPaidLossType == "1" ){ //¼�롰�˶���ʧ��ʱ�����㹲���������Ϣ
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(Realpay/coinsSelfRate*100,2),2);
		}
	}
  
     //modify by qinyongli 2005-10-28 �������п��ܱ���Ϊ0����ʱ���ؿ���
 if(Realpay>Amount)
 {
     alert("�⳥���ܴ��ڱ��ս��");
     fm.all("prpLlossDtoSumLoss")[findex].select();
     return false;
  }
  calFund();

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
  var sumRestAll        = 0;
  var chargeCurrency ; //�⳥�ұ�
  var exchRate; 
  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  var elements = getTableElements("Charge");
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
    //ȡ�һ��ʣ��������
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
  //2.�⸶��ĵ��⳥���
  //��������
  var lossData= getTableElements("lLoss");
  var intLossCount = lossData.length;
  var dblRealPayAB = 0;   //modify by dengxh update at 20040914
  for( i = 1; i < fm.all("prpLlossDtoSumRealPay").length; i++ )
  {
    lossRealPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[i].value);
    sumRestAll       = sumRestAll + parseFloat(fm.all("prpLlossDtoSumRest")[i].value);  //��ֵ
    if(isNaN(lossRealPay))
      lossRealPay = 0;

     //�һ��ұ�
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
   //3.�⸶��Ա���⸶�ϼ�
  //��������
  //setCurrentRecord("PersonFeeLoss");

   var personLossData= getTableElements("PersonFeeLoss");

   var intPersonLossCount = personLossData.length;

   for( i = 1; i < fm.all("prpLpersonLossSumRealPay").length; i++ )
   {
     personLossRealPay = parseFloat(fm.all("prpLpersonLossSumRealPay")[i].value);
     if(isNaN(personLossRealPay))
       personLossRealPay = 0;
      //�һ��ұ�
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
  fm.prpLcompensateSumRest.value      = point(round(sumRestAll,2),2);
  calCoinsFund();
}

function calCoinsFund() {
	var coinsFlag = fm.coinsFlag.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	var SumNoDutyFee = fm.prpLcompensateSumNoDutyFee.value;
	var SumDutyPaid = fm.prpLcompensateSumDutyPaid.value;
	  // ȡ�õ�ǰ������
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
		if(coinsPaidLossType == "1"){//100%�ݶ��⸶
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = point(round(realPay/coinsSelfRate*100 ,2),2); 
			fm.prpLcompensateCoinsOtherSumPaid.value =point(round(parseFloat(fm.prpLcompensateCoinsSumPaid.value) -  parseFloat(fm.prpLcompensateCoinsSelfSumPaid.value) ,2),2);
		}
		if(coinsPaidLossType == "2"){//�ҷ��ݶ��⸶
			fm.prpLcompensateCoinsSelfSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsSumPaid.value = fm.prpLcompensateSumPaid.value ; 
			fm.prpLcompensateCoinsOtherSumPaid.value = 0 ;
		}
		var dbCoinsSumPaid =  parseFloat(fm.prpLcompensateCoinsSumPaid.value) ; 
		if(coinsPaidLossType == "1"){//100%�ݶ��⸶
			for(i=0;i<fm.all("CoinsSerialNo").length;i++){
				//alert(fm.all("CoinsRate")[i].value);
				fm.all("CoinsSumpaid")[i].value = point(round((dbCoinsSumPaid-SumNoDutyFee/coinsSelfRate*100) * parseFloat(fm.all("CoinsRate")[i].value) / 100  ,2),2);
				//fm.all("CoinsSumpaid")[i].value = point(round((SumDutyPaid /(1-(parseFloat(fm.all("CoinsRate")[i].value) / 100))) * parseFloat(fm.all("CoinsRate")[i].value) / 100,2),2);
			}
		}
		if(coinsPaidLossType == "2"){//�ҷ��ݶ��⸶
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
			alert("����ҵ����ѡ���ⰸ�⸶���ͣ�");
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
	  // ȡ�õ�ǰ������
	var fieldname=field.name;
	var findex=0;
	for(i=1;i<fm.all(fieldname).length;i++){
	  if( fm.all(fieldname)[i] == field ){
	    findex=i;
	    break;
	  }
	}
	  //����ҵ���⸶�����ж�
	var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
	var thisCoinsRealPay = parseFloat(fm.all("prpLlossDtoCoinsSumRealPay")[findex].value) ; 
	var amount = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
	var coinsSumAmount = point(round(amount/coinsSelfRate*100,2),2); 
	if(checkCoinsPaidLossType() == false ){
		fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		return false ; 
	}
	//alert("thisCoinsRealPay==="+thisCoinsRealPay+"===coinsSumAmount==="+coinsSumAmount);
	
		if(coinsPaidLossType == "2"){ // ���ҷ������ݶ��⸶
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(realPay,2),2);
		}
		//alert(coinsPaidLossType == "1");alert(coinsPaidLossType == 1);
		if(coinsPaidLossType == "1"){// ���ⰸ100%�⸶
			thisCoinsRealPay = realPay/coinsSelfRate*100 ; 
			fm.all("prpLlossDtoCoinsSumRealPay")[findex].value = point(round(thisCoinsRealPay,2),2);
			if(thisCoinsRealPay > coinsSumAmount){
				 alert("����ҵ���⳥�ܽ��ܴ����ձ𹲱��ܱ��ս��");
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
	  // ȡ�õ�ǰ������
	var findex=0;
	for(i=1;i<fm.all("prpLlossDtoSumRealPay").length;i++){
	    findex=i;
	    var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value ); 
		
			if(coinsPaidLossType == "2"){ // ���ҷ������ݶ��⸶
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



  fm.prpLcompensateSumLoss.value  = point(round(dblSumLoss,2),2);
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
  var Amount;

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
  /*���������
   * �������ߣ����˶���ʧ - ��ֵ��* �⳥���� * ���α��� * ��1 - �����ʣ�
   * # ����ȡ��----����������˶���ʧ - ��ֵ��* �⳥���� * ���α���  - �����
   */
  if(DeductibleRate>1){
  	alert("�����ʲ��ܴ���100");
  	fm.all("prpLpersonLossDeductibleRate")[findex].value="0";
  	return false;
  }

     //�����������������ֻ����������һ��
  if(DeductibleRate>0&&Deductible>0){
     alert("�������������ֻ������һ��");
     if(fieldname=="prpLpersonLossDeductible"){
           fm.all("prpLpersonLossDeductible")[findex].value="0";
     }else{
           fm.all("prpLpersonLossDeductibleRate")[findex].value="0";
     }
     return false;
  }   
  if (Deductible == 0) {    //û�������������㹫ʽΪ ���*�⳥����*(1-������)
      //Realpay = (SumLoss - SumRest) * ClaimRate - Amount*DeductibleRate;  
      Realpay = SumLoss * ClaimRate*(1-DeductibleRate);  
  } else {                 //������������㹫ʽΪ ���*�⳥����-�����
      Realpay = SumLoss * ClaimRate - Deductible;
  }
   
   
   
   
  //temp = SumLoss * ClaimRate; //temp=���˶���ʧ * �⳥���� 
  //Realpay = temp - Deductible;
  fm.all("prpLpersonLossSumRealPay")[findex].value = point(round(Realpay,2),2);
  
  
  //modify by qinyongli 2005-10-28 �������п��ܱ���Ϊ0����ʱ���ؿ���
  if(Realpay>Amount)
  {
       alert("�⳥���ܴ��ڱ��ս��");
       fm.all("prpLpersonLossSumLoss")[findex].select();
       return false;
  }
  
  //�����⸶��Ա�е��⸶�ϼ�
  calSumRealpay(Field);
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();

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
         if(fm.all("prpLlossDtoKindCode")[i].value==kindCode && fm.all("prpLlossDtoItemCode")[i].value==itemCode
           && fm.all("prpLlossDtoSerialNo")[i].value!=fm.all("prpLlossDtoSerialNo")[findex].value
           &&fm.prpLcompensateRiskCode.value!="1516"&&fm.prpLcompensateRiskCode.value!="1542"&&fm.prpLcompensateRiskCode.value!="1528")
         {
             alert("��¼����ձ�ͱ���Ѿ�����");
             fm.all("prpLlossDtoItemCode")[findex].value="";
             fm.all("prpLlossDtoLossName")[findex].value=""; 
             fm.all("prpLlossDtoAmount")[findex].value="";
             fm.all("prpLlossDtoAmountDisplay")[findex].value="";
             //fm.all("prpLlossDtoItemCode")[findex].focus();
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

