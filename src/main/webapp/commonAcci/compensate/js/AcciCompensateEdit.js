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
   var riskCode = fm.prpLcompensateRiskCode.value;
  //Composition.document.body.innerHTML = fm.prpLctextContextInnerHTML.value;
  //add by qinyongli �ɶ�ҵ����ʾ start 2005-7-31 
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
    alert("�˱�������δ�ɣ�\n");
  } 
  else if(payFee==0){
    alert("�˱�������δ��ȫ��\n");
  }else if(payFee==-2){
     message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
  }

  
  if(shareHolderFlag!=0){
     message = message + "��ǰ������������ΪΪ�ɶ�ҵ��\n";
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
  
  /*add by wuzheng ������ͳ������ҽ������ֻ�н������ܿ����������ʱ������*/
  var classCode = fm.prpLcompensateClassCode.value;
  if(classCode == 26){
      trMedicalType.style.display = "";
      /*wuzheng_leave:��������һ�����ɣ�26����medicalType���棬�Ҳ���Ϊ�գ�27���档������select�ĵ�һ��option��ֵΪ����
       *��26�����ʱ�򣬰ѿյ�optionȥ��
       */
      fm.medicalType.options[0] = null;      
  } 
  
  return true;
}
//modify by huangyunzhong 20051026 ������ʾ������ϸ��������һ��
function CheckDetail()
{
  var erroMessage = "";
  if(document.getElementsByName('personLossSerialNo').length<2){
     erroMessage = erroMessage + "����Ҫ��'���������⸶��Ϣ'����������һ��'������Ϣ'��\n";
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
  var riskCode = fm.prpLcompensateRiskCode.value;
  var sumamount = fm.prpLcompensateSumAmount.value;
  var ChargeAmount=document.getElementsByName('prpLchargeChargeAmount');
  var ChargeCode=document.getElementsByName('prpLchargeChargeCode');
  var CheckDeptCode=document.getElementsByName('prpLchargeCheckDeptCode');
  var SHcomCode= fm.SHcomCode.value;
  if(SHcomCode == '31'){
	  if (saveType == '4' && fm.prpLcompensateBank.value == '') {
	      alert("�����뱻�����˿��������˺�!");
	      return false;
	  }  
	  if (saveType == '4' && fm.prpLcompensateAccount.value == '') {
	      alert("�����뿪���ʺ��˺�!");
	      return false;
	  }
	  if (saveType == '4' && fm.prpLcompensateAccount.value == '') {
	      alert("�������տ���ȫ��!");
	      return false;
	  } 
	  if (saveType == '4' && fm.prpLcompensateAccountOK.value == '') {
	      alert("���ٴ�ȷ�Ͽ����ʺ�!");
	      return false;
	  } 
	  if (saveType == '4' && fm.prpLcompensateHospitalName.value == '') {
	      alert("��ѡ�����ҽԺ!");
	      return false;
	  }
	  if (saveType == '4' && fm.prpLcompensateDiseaseName.value == '') {
	      alert("��ѡ�񼲲�!");
	      return false;
	  }
  }
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
  if(!checkProposer())
  {
    return false;
  }
  
//  if(!checkPersonInfo()){
//    return false;  
//  }
  //��Σ�յ�λУ��
  if(fm.DangerUnitCheckSaveFlag.value=='2'){ 
	  if ( DangerUnitCheck()==false){
	     return false;
	  }
  }

  fm.buttonSaveType.value = saveType;
  if(riskCode =='2801' && sumamount==0)
  {
     
  }else {if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)>round(parseFloat(fm.prpLcompensateSumAmount.value),2)){
    alert("���⳥���ܴ����ܱ��ս�");
    return false;
  }}
 if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
   alert("���ϼƲ�����Σ�յ�λ��Ϣ���ʵ���");
   return false;
 }
  //�ж��Ƿ�������δ���� 2005-08-07
  if (saveType == '4' && fm.AcciClaimFlag.value == 'N') {
      alert("���е�������û�д��������ύ!");
      return false;
  }  
    if (saveType == '4' && fm.checkFlag.value == 'N') {
      alert("���е�������û�д��������ύ!"); 
      return false;  
  }
  //����ʵ��ͬԤ���ϵ�ж� begin
  if(fm.times.value == 1){//�״�������ʵ��ͬԤ���У�飬�ؿ�����У��
  if(round(parseFloat(fm.prpLcompensateSumDutyPaid.value),2)<round(parseFloat(fm.prpLcompensateSumPrePaid.value),2)){
    alert("�������ϼƽ���С����Ԥ������");
    return false;
  }
  if(round(parseFloat(fm.prpLcompensateSumNoDutyFee.value),2)<round(parseFloat(fm.prpLcompensatePreSumChargePaid.value),2)){
    alert("���úϼƽ���С����Ԥ�����ý�");
    return false;
  }
  }
  //����ʵ��ͬԤ���ϵ�ж� end   
  //textarea�ı�������ֵ
 // fm.prpLctextContextInnerHTML.value=Composition.document.body.innerHTML;
//  var context = Composition.document.body.innerText;

 // fm.prpLctextContextInnerHTML.value=document.body.innerHTML;
  //var context = document.body.innerText;
  //if(context.length<1){
  //  errorMessage = errorMessage + "������Ĳ�����Ϊ��\n";
  //}
  
/*��Ԫ��Ŀ��  ����������ĵ�У��
  var context = fm.prpLctextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "������Ĳ�����Ϊ��\n";
  }
*/
  
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //modify by weishixin add begin 20040616
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm,'Engage_Data,PersonFeeLoss_Data,Charge_Data'))
  {
    return false;
  }
  //var underWriteFlag = fm.prpLcompensateUnderWriteFlag.value;
  /*
  if(saveType==4){
  	//�ǰ��ռ��������ʵ�����Ƿ���ڹ�������ж�add by qinyongli 2005-09-20

  	    var sumClaim = parseFloat(fm.prpLcompensateSumClaim.value);
  	    var sumPaidAll = parseFloat(fm.sumPaidAll.value);
  	    var sumThisPaid = parseFloat(fm.prpLcompensateSumThisPaid.value);
  	    sumPaidAll = sumPaidAll + sumThisPaid;

  	    if(sumPaidAll>sumClaim){
  	    	alert("ʵ������ڹ�����������ύ���⣬�������ݴ����");
  	    	return false;
            }
           
        //add end 2005-09-20
    
    //if(underWriteFlag!=1){
    //alert("���⸴�˲�ͨ��ʱ�����ύ");
    // return false;
    //}

  }
  */  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  
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

  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();

  return true;
}

//�����⸶��Ա��Ϣ
function checkPersonInfo()
{
  
  if(isNaN(fm.prpLpersonLossLiabDetailCode.length)){
    errorMessage("������Ϣ����Ҫ��һ����¼!");
    return false;
  }
  
  for(var j=1;j<fm.prpLpersonLossKindCode.length;j++){
    if(isEmptyField(fm.prpLpersonLossKindCode[j]))
    {
	   errorMessage("��"+ j+"�б��ձ���벻��Ϊ��!");
	   return false;
	}
 }
  

/*  
    for(var j=1;j<fm.prpLpersonLossLiabDetailCode.length;j++){
    if(isEmptyField(fm.prpLpersonLossLiabDetailCode[j]))
    {
	   errorMessage("��"+ j+"��������ϸ����Ϊ��!");
	   return false;
	}
  }
*/
  for(var j=1;j<fm.prpLpersonLossSumRealPay.length;j++){
    if(isEmptyField(fm.prpLpersonLossSumRealPay[j]))
    {
      errorMessage("��"+ j+"����������Ϊ��!");
	   return false;
	}
  }
  return true;
}

//����������----------------------------------------
function checkProposer()
{
  if(getRowsCount("Proposer")==0)
  {
		errorMessage("������������Ϣ����Ҫ��һ����¼!");

		return false;
  }
	
  for( var j=1;j<fm.proposerName.length;j++)
 	{
		if (isEmptyField(fm.proposerName[j]))
		{
			errorMessage("��"+ j+"��������������������Ϊ��!");
			fm.proposerName[j].focus();
			return false;
		}
//	   if(isEmptyField(fm.proposerIdentifyNumber[j]))
//		{
//			errorMessage("��"+j+"���������������֤���벻��Ϊ��!");
//			fm.proposerIdentifyNumber[j].focus();
//			return false;
//		}
		// if (fm.proposerIdentifyNumber[j]).value.length !=18)
		//{
		 // errorMessage("��"+j+"���������������֤�������Ϊ18λ��22λ");
		  //fm.proposerIdentifyNumber[j].focus();
		  //return false;
	//	}
//	   if(isEmptyField(fm.relationCode[j]))
//		{
//			errorMessage("��"+j+"���������������֤���벻��Ϊ��!");
//			fm.relationCode[j].focus();
//			return false;
//		}
 	}
	//��ѡ�����������������ԭ��
 	if(fm.result.value=="0"&&isEmptyField(fm.prpLcompensateRemark)){
 		errorMessage("������ܸ�ԭ��");
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

//�����������������̣�ֱ����ǰ̨js�༭����
function generateCompensateText(){
    if(!checkProposer())
    {
      return false;
    }
//    if(!checkPersonInfo()){
//      return false;  
//    }
 	
 	//�õ����г����߷ֻ����
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
           compensateTextTemp =familyNoTemp+"���������ˣ�"+fm.prpLpersonLossPersonName.value+"\n";
           for(var j=0;j<kindCodeCount;j++){
             if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo.value){
               feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"����⣺"+ fm.prpLpersonLossSumRealPay[j].value+"Ԫ"+"\n";
           }
         }
       }else{
          familyNoTemp = fm.prplAcciPersonNo[i].value;
          compensateTextTemp =familyNoTemp+"���������ˣ�"+fm.prpLpersonLossPersonName[i].value+"\n";
          
         for(var j=0;j<kindCodeCount;j++){
           if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo[i].value){
             feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"����⣺"+ fm.prpLpersonLossSumRealPay[j].value+"Ԫ"+"\n";
           }
         }
       }
       compensateText += compensateTextTemp+feeTextTemp;
    }
    fm.prpLctextContextInnerHTML1.value=compensateText;
    return true;
}


//���������������ģ�ֱ����ǰ̨js�༭����
function generateCompensateText1(){
    if(!checkProposer())
    {
      return false;
    }
  
//    if(!checkPersonInfo()){
//      return false;  
//    }
 	//�õ����г����߷ֻ����
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
    compensateText = strSpace+"����"+fm.prpLcompensateClaimNo.value+"���ⰸ�������˶�"+fm.prpLcompensatePolicyNo.value+"�ű��յ�"+"\n";
    compensateText+="��"+year+"��"+month+"��"+day+"���������⳥�����Գ�������Ա��յ���Ч���ս���������ģ�\n"
    for(var i=0;i<count;i++)
    {
       compensateTextTemp="";
       feeTextTemp = "";
       if(count==1){
           familyNoTemp = fm.prplAcciPersonNo.value;
           compensateTextTemp =familyNoTemp+"���������ˣ�"+fm.prpLpersonLossPersonName.value+"\n";
           for(var j=0;j<kindCodeCount;j++){
             if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo.value){
               
               endoramount = parseFloat(fm.prpLpersonLossAmount[j].value)-parseFloat(fm.prpLpersonLossSumRealPay[j].value);
               endoramount = point(round(endoramount,2),2);
               feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"����⣺"+ fm.prpLpersonLossSumRealPay[j].value+"Ԫ��"+"���ս����"+fm.prpLpersonLossAmount[j].value+"Ԫ���Ϊ"+endoramount+"Ԫ��\n";
           }
         }
       }else{
          familyNoTemp = fm.prplAcciPersonNo[i].value;
          compensateTextTemp =familyNoTemp+"���������ˣ�"+fm.prpLpersonLossPersonName[i].value+"\n";
          
         for(var j=0;j<kindCodeCount;j++){
           if(fm.personLossSerialNo[j].value==fm.prplAcciPersonNo[i].value){
             endoramount = parseFloat(fm.prpLpersonLossAmount[j].value)-parseFloat(fm.prpLpersonLossSumRealPay[j].value);
             endoramount = point(round(endoramount,2),2);
             feeTextTemp += strSpace+fm.prpLpersonLossLiabDetailName[j].value+"����⣺"+ fm.prpLpersonLossSumRealPay[j].value+"Ԫ��"+"���ս����"+fm.prpLpersonLossAmount[j].value+"Ԫ���Ϊ"+endoramount+"Ԫ��\n";
           }
         }
       }
       compensateText += compensateTextTemp+feeTextTemp;
    }
    compensateText =compensateText+"\n"+strSpace+"ԭ���յ������������䣬�ش���ע��";
    fm.prpLctextContextInnerHTML.value=compensateText;
    return true;
}


//Modify By liubvo add end 2004-09-07
/**
 @author      liubvo
 @description �����������
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
  var riskCode = fm.prpLcompensateRiskCode.value;
  //var realpayvalueforone = 0;
  //var realpayforall = 0;
  
  var dblSumDutyPaid = 0;  //�������ϼƣ�=�������ø�����Ϣ�У����������+���⸶��ĸ�����Ϣ�У��⳥���+���⸶��Ա������Ϣ�У��⸶�ϼƣ�
  var dblSumPaid     = 0;  //���ϼƣ�=�������ϼ�+�������ã�
  var dblSumPrePaid  = 0;  //Ԥ����
  var dblSumNoDutyFee= 0;  //�������ã��������ø�����Ϣ�У����ý�� - ��������
  var dblSumThisPaid = 0;  //ʵ���=�������ϼƣ���Ԥ����

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossSumRealPay    = 0;
  var personLossSumRealPay = 0;
  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  //var intChargeCount = getRowsCount("Charge");
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
   
  
    chargeRealPay = parseFloat(fm.prpLchargeSumRealPay[i].value); //�������
    chargeAmount  = parseFloat(fm.prpLchargeChargeAmount[i].value);  //����
    //var exchaRate4AndCNY  = parseFloat(fm.ExchaRate4AndCNY[i].value);  //�һ���
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

  //3.�⸶��Ա���⸶�ϼ�
  //��������
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
  //fm.prpLctextContextInnerHTML1.value="";
  //fm.prpLctextContextInnerHTML.value="";
  calCoinsFund();
}
function calFund2()
{
  //�������
  var riskCode = fm.prpLcompensateRiskCode.value;
  if(riskCode == '2801')
  {
  
  //var realpayvalueforone = 0;
  //var realpayforall = 0;
  
  var dblSumDutyPaid = 0;  //�������ϼƣ�=�������ø�����Ϣ�У����������+���⸶��ĸ�����Ϣ�У��⳥���+���⸶��Ա������Ϣ�У��⸶�ϼƣ�
  var dblSumPaid     = 0;  //���ϼƣ�=�������ϼ�+�������ã�
  var dblSumPrePaid  = 0;  //Ԥ����
  var dblSumNoDutyFee= 0;  //�������ã��������ø�����Ϣ�У����ý�� - ��������
  var dblSumThisPaid = 0;  //ʵ���=�������ϼƣ���Ԥ����

  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossSumRealPay    = 0;
  var personLossSumRealPay = 0;
  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  //var intChargeCount = getRowsCount("Charge");
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
   
  
    chargeRealPay = parseFloat(fm.prpLchargeSumRealPay[i].value); //�������
    chargeAmount  = parseFloat(fm.prpLchargeChargeAmount[i].value);  //����
    //var exchaRate4AndCNY  = parseFloat(fm.ExchaRate4AndCNY[i].value);  //�һ���
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

  //3.�⸶��Ա���⸶�ϼ�
  //��������
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


  //�õ�Ԥ����
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //�������ϼ�
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
  //�������
  var dblSumDutyPaid = 0;  //�������ϼƣ�=�������ø�����Ϣ�У����������+���⸶��ĸ�����Ϣ�У��⳥���+���⸶��Ա������Ϣ�У��⸶�ϼƣ�
  var dblSumPaid     = 0;  //���ϼƣ�=�������ϼ�+�������ã�
  var dblSumPrePaid  = 0;  //Ԥ����
  var dblSumNoDutyFee= 0;  //�������ã��������ø�����Ϣ�У����ý�� - ��������
  var dblSumThisPaid = 0;  //ʵ���=�������ϼƣ���Ԥ����
  var sumCheckFee = 0;
  sumCheckFee = parseFloat(fm.sumCheckFee.value);
  var chargeRealPay  = 0;
  var chargeAmount   = 0;
  var lossSumRealPay    = 0;
  var personLossSumRealPay = 0;
  //�����������ϼ�
  var i = 0;

  //1.�����õļ��������Լ���������
  //var intChargeCount = getRowsCount("Charge");
  var elements = getTableElements("Charge");
  for( i = 1; i < fm.all("prpLchargeSumRealPay").length; i++ )
  {
    chargeRealPay = parseFloat(fm.prpLchargeSumRealPay[i].value); //�������
    chargeAmount  = parseFloat(fm.prpLchargeChargeAmount[i].value);  //����
    //var exchaRate4AndCNY  = parseFloat(fm.ExchaRate4AndCNY[i].value);  //�һ���
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

  //3.�⸶��Ա���⸶�ϼ�
  //��������
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


  //�õ�Ԥ����
  dblSumPrePaid   = parseFloat(fm.prpLcompensateSumPrePaid.value);   //��Ԥ�����

  if(isNaN(dblSumPrePaid))
    dblSumPrePaid = 0;

  //�������ϼ�
  dblSumPaid      = dblSumDutyPaid + dblSumNoDutyFee + sumCheckFee;

  //����ʵ����
  dblSumThisPaid  = dblSumDutyPaid - dblSumPrePaid;
  fm.prpLcompensateSumDutyPaid.value  = point(round(dblSumDutyPaid,2),2);     //�������ϼ�
  fm.prpLcompensateSumNoDutyFee.value = point(round(dblSumNoDutyFee,2),2);    //��������
  fm.prpLcompensateSumPaid.value      = point(round(dblSumPaid,2),2);         //���ϼ�
  fm.prpLcompensateSumThisPaid.value  = point(round(dblSumPaid,2),2);         //���θ������
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
	//var coinsSelfRate = fm.coinsSelfRate.value ; 
	if(coinsFlag == "2"||coinsFlag == "1"){
	var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value ; 
	//alert("coinsFlag=="+coinsFlag+"==coinsSelfRate=="+coinsSelfRate+"===coinsPaidLossType==="+coinsPaidLossType);
	
		if(coinsPaidLossType == null || coinsPaidLossType == ""){
			alert("����ҵ����ѡ���ⰸ�⸶���ͣ�");
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

/*
function changePrpLcompensateFinallyFlag(){
    if(fm.prpLcompensateFinallyFlag[0].checked){
        Lltext.style.display="";
    }else{
        Lltext.style.display="none";
    }
}
*/
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcompensatePolicyNo.value;
     var RiskCode  =fm.prpLcompensateRiskCode.value;
     var damageDate=fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL =  CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
/**
 *@description added by zhangli 2007-04-20��֤�������˵��ʺ��Ƿ�һ��
 *@param       ��
 *@return      
*/
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

