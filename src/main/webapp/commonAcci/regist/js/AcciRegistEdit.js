/*****************************************************************************
 * DESC       �������ǼǵĽű�����ҳ��
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-03-10
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


/**
 *@description �ύ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
  var errorMessage = "";
  var message = "";
  //�ж��Ƿ�������δ���� 2005-08-04
  /*delete by liuyanmei reason:�����ύ���������ж�[����]�Ƿ��ύ������
  if (saveType == '4' && fm.AcciClaimFlag.value == 'N') {
      alert("���е�������û�д��������ύ!");
      return false;
  } 
  */     
  //add by caopeng start at 20051222 reason:��ϵ�ˣ���¼��
  var linkerName = fm.prpLregistLinkerName.value;
  if(linkerName.length<1){
    errorMessage = errorMessage + "��ϵ�˲�����Ϊ��\n";
  }
  var PhoneNumber = fm.prpLregistPhoneNumber.value;
  if(PhoneNumber.length<1){
    errorMessage = errorMessage + "��ϵ�绰������Ϊ��\n";
  }
  var prpLregistDamageStartHour = fm.prpLregistDamageStartHour;
  var prpLregistDamageStartMinute = fm.prpLregistDamageStartMinute;
  if(isEmptyField(prpLregistDamageStartHour) || isEmptyField(prpLregistDamageStartMinute)){
  	errorMessage = errorMessage + "�¹�ʱ�䲻����Ϊ��\n";
  }
  var prpLregistDamageAddress = fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "�¹ʵص㲻����Ϊ��\n";
  }
  //add by caopeng end at 20051222
  //modify by liujianbo modify 20051110 start
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
  }
  
  var prpLregistDamageCode = fm.prpLregistDamageCode.value;
  if(prpLregistDamageCode<1){
    errorMessage = errorMessage + "�¹�ԭ����벻����Ϊ��\n";
  }
  
  var prpLregistDamageName = fm.prpLregistDamageName.value;
  if(prpLregistDamageName<1){
    errorMessage = errorMessage + "�¹�ԭ�����Ʋ�����Ϊ��\n";
  }
  
 //add 20051207 start reason:�¹����ͣ���¼�� ������Ĭ�������
  var damageTypeCode = fm.prpLregistDamageTypeCode.value;
  if(damageTypeCode.length<1){
    errorMessage = errorMessage + "�¹����ʹ��벻����Ϊ��\n";
  }
  var damageTypeName = fm.prpLregistDamageTypeName.value;
  if(damageTypeName.length<1){
    errorMessage = errorMessage + "�¹��������Ʋ�����Ϊ��\n";
  }
  //add 20051207  end reason:�¹����ͣ���¼�� ������Ĭ�������
  //modify by liujianbo modify 20051110 end 
  if(fm.acceptFlag[0].checked==false && fm.acceptFlag[1].checked==false){
    errorMessage = errorMessage + "�����־������Ϊ��\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "�Ƿ����ı��չ�˾Ͷ��������Ϊ��\n";
  }
  
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  var prpLregistEndDate = fm.prpLregistEndDate.value;
  var prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;
  if(prpLregistDamageStartDate<prpLregistStartDate||prpLregistDamageStartDate>prpLregistEndDate){
      errorMessage = errorMessage + "����ʱ�䲻�ڱ����ڼ䣬ϵͳ��������\n";
  } 
  //delete by zhaolu 20060829 start
  /**if(fm.prpLregistReceiverCode.value=="")
  {
      alert("�Ӱ��˴��벻��Ϊ�գ�")
      return false;
  } */
  //delete by zhaolu 20060829 end
  
  if(fm.prpLregistReceiverName.value=="")
  {
      alert("�Ӱ�����������Ϊ�գ�")
      return false;
  }  
  if(fm.prpLacciPersonAcciCode.value=="")
  {
      alert("�������¹�����Ϣ")
      return false;
  }
  for(i=1;i<fm.prpLacciPersonAcciCode.length;i++){
   /*
   if(fm.prpLacciPersonAcciCode[i].value==""){
      alert("�������¹��ߴ���")
      return false;
   }*/
	 if(fm.prpLacciPersonAcciName[i].value==""){
	      alert("�������¹�������")
	      return false;
	   }
	   
	 if(fm.prpLacciPersonFamilyNo[i].value==""){
	 	  alert("��˫��ѡ���¹�������")
	      return false;
	 }
  }
  fm.buttonSaveType.value = saveType;
  

     
  //add by qinyongli 2005/07/20 start
  //��ȡ����������������
  var delayDays=fm.configValue.value;
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var registDay = fm.prpLregistReportDate.value;
  var regist = new Date(registDay.substring(0,4),registDay.substring(5,7)-1,registDay.substring(8,10));
  
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
  	message = message + "��������������������"+delayDays+"�죬�Ƿ�ͨ����\n";
  }
  //add end qinyongli 2005/07/20 end
  //add by qinyongli  start  2005-9-2
  //reason:�����䵥���ںͳ������ڵ��жϣ��䵥���ڱ����ڳ�������֮��
    var inputDate  = fm.prpLregistInputDate.value;
    
    var reporthour = parseInt(fm.prpLregistReportHour.value);
    var reportminute = parseInt(fm.prpLregistReportMinute.value);
    var damagehour = parseInt(fm.prpLregistDamageStartHour.value);
    var damageminute = parseInt(fm.prpLregistDamageStartMinute.value);
    
    if(isNaN(reporthour)) reporthour = 0;
    if(isNaN(reportminute)) reportminute = 0;
    if(isNaN(damagehour)) damagehour = 0;
    if(isNaN(damageminute)) damageminute = 0;    
    if(compareFullDate(inputDate,damageDay) == -1){
        errorMessage = errorMessage + "�¹�ʱ�䲻�ܴ����䵥����\n";
    }   
    if(compareFullDate(registDay,damageDay) == -1){
        errorMessage = errorMessage + "�¹�ʱ�䲻�ܴ��ڱ�������\n";
    }
    else if(compareFullDate(registDay,damageDay) == 0){
      if(reporthour<damagehour){
        errorMessage = errorMessage + "�¹�ʱ�䲻�ܴ��ڱ���ʱ��\n";
      }
      else if(reporthour==damagehour && reportminute<damageminute){
        errorMessage = errorMessage + "�¹�ʱ�䲻�ܴ��ڱ���ʱ��\n";
      }      
    }
    var currDate = new Date();
    if(regist > currDate){
    	errorMessage = errorMessage + "����ʱ�䲻�ܴ��ڵ�ǰʱ��\n";
    }
    /*if(compareFullDate(inputDate, currDate.getYear() + "-" + (currDate.getMonth() + 1) + "-" + currDate.getDate()) == 1 ){
    	errorMessage = errorMessage + "�䵥ʱ�䲻�ܴ��ڵ�ǰʱ��\n";
    }*/
  //add by qinyongli end 
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 

  field.disabled = true;
  fm.submit(); 
  return true;
}

/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
  var payFee = parseInt(fm.prpLregistPayFee.value);
  
  var underWriteEndDate=fm.underWriteEndDate.value;
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  //add by qinyongli ���ӱ���ע������ǩ�����ɶ�ҵ�����ʾ�� 2005-7-28
  var message = "";
  var shareHolderFlag = fm.shareHolderFlag.value;
  var othFlag = fm.prpLregistOthFlag.value;
  if(othFlag.substring(3,4)=="1"){
      message = message + "�˱�����ע����\n";
    fm.buttonSave.disabled = true;
    fm.registPrint.disabled = true;
    fm.buttonCancel.disabled = true;
    fm.buttonSaveFinishSubmit.disabled = true; 
  }
  var underWriteEndDate=fm.underWriteEndDate.value;
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  if(underWriteEndDate>prpLregistStartDate){
      message = message + "�˱��������������ں˱����ڣ�\n";
  }
  if(shareHolderFlag!=0){
      message = message + "�˱���Ϊ�ɶ�ҵ��\n";
  }
  
   if(payFee==-1){
         message=message+"�˱�������δ��,�����ش������� \n";
     }
      else if(payFee==-2){
           message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
      }
  
  if (message.length>0) {
      alert(message);
  } 
  // add by qingyongli  end  2005-7-28

  if(fm.prpLregistRegistNo.length<10){
    fm.messageSave.disabled=true;
    fm.messageView.disabled=true; 
  }
  
  
   //�ж��Ƿ�����ͬ����������1�����ϵı���,ֻ�ڵǼǵ�ʱ����ʾ.
  
  var registNo = fm.prpLregistRegistNo.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var policyNo = fm.prpLregistPolicyNo.value;
  
  //alert (sameCount);
  if (registNo.length<1)
  {
  	//˵���ǵǼ�
  	if (sameCount>0) 
  	{
  	alert("��������Ϊ'"+policyNo+"'�Ѿ�����"+sameCount +"�Σ���鿴���մ�����Ϣ��");
    }else
  	{
  		fm.button_Peril_Open_Context.disabled = true;
  	}
    
  }
  
  
  
  return true;
}

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave(){
   
   var businessNo = fm.prpLregistRegistNo.value;
   var policyNo = fm.prpLregistPolicyNo.value;
   var riskCode = fm.prpLregistRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=regis&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �����鿴���ԶԻ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 
function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}


function noChange()
{   
  fm.insureCarFlag[1].value=1;
  alert("�永�����ĵ�һ��������Ϊ��������");
  return true;
}	   

//Modify By sunhao add begin 2004-09-06

/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){
	
		var policyNo = fm.prpLregistPolicyNo.value;
		var registNo = fm.prpLregistRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    //newWindow.focus = true; 

}
//Modify By sunhao add end 2004-09-06


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
  
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 

//�⽡���ڱ���ʱ����ѡ���Ƿ�ʱ����ǣ�1 ��0
function changePrplregistReportFlag() {
    if (fm.prplregistReportFlag[0].checked) {
        ReportFlag.style.display = "";
    } else {
        ReportFlag.style.display = "none";
    }
}
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLregistPolicyNo.value;
     var RiskCode  =fm.prpLregistRiskCode.value;
     var damageDate=fm.prpLregistDamageStartDate.value;
     //add by kangzhen 061118
     var ClassCode = RiskCode.substring(0,2);
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL =  CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&ClassCode='+ClassCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
//modify add by huangyunzhong 20051025 ����Ϊ����������˴���󵯳�����ҳ��ԭҳ�汣��
function showPersonInsured(prpDcustomerIdvCustomerCode){	       
    var prpCmainPolicyNo=fm.prpCmainPolicyNo.value
    var messagedo = "/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpCmainPolicyNo="+prpCmainPolicyNo+"&prpDcustomerIdvCustomerCode="+prpDcustomerIdvCustomerCode+"& target='_blank'";	  
    win = window.open(messagedo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}

//modify ���ĳ���ʱ������Ϣ  by qinyongli 2005-10-5
function flashPage(){
    var damageDate = fm.prpLregistDamageStartDate.value;
    var damageHour = fm.prpLregistDamageStartHour.value;
    var policyNo   = fm.policyno.value;
    var vURL='/claim/registBeforeEdit.do?prpCmainPolicyNo='+policyNo+'&editType=ADD&damageDate='+damageDate+'&damageHour='+damageHour+'&modifyDamageDate=true';
    var oldAction = "/claim/registSave.do";
    var oldReportName = fm.prpLregistReportorName.value;
    var oldTarget = fm.target;

    fm.action=vURL;
    fm.target=oldTarget;
    fm.submit();

    fm.action=oldAction;
    fm.target=oldTarget;
   
    return true;  
}

//�Ƚ����������ַ���
// date1=date2�򷵻�0 , date1>date2�򷵻�1 , date1<date2�򷵻�-1
function compareFullDate(date1,date2)
{
  var strValue1=date1.split(DATE_DELIMITER);
  var date1Temp=new Date(strValue1[0],parseInt(strValue1[1],10)-1,parseInt(strValue1[2],10));

  var strValue2=date2.split(DATE_DELIMITER);
  var date2Temp=new Date(strValue2[0],parseInt(strValue2[1],10)-1,parseInt(strValue2[2],10));

  if(date1Temp.getTime()==date2Temp.getTime())
    return 0;
  else if(date1Temp.getTime()>date2Temp.getTime())
    return 1;
  else
    return -1;
}
