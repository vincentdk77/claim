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

function checkForm()
{
   //�жϱ���ʱ�䲻�����ڳ���ʱ��
  var i = compareFullDate(fm.prpLregistDamageStartDate.value,fm.prpLregistReportDate.value);
  if (i>0)
  {
    errorMessage("����ʱ�䲻�����ڳ���ʱ��");
    fm.prpLregistReportDate.focus();
    fm.prpLregistReportDate.select();
    return false;
  }else if (i==0 && (parseFloat(fm.prpLregistDamageStartHour.value)>parseFloat(fm.prpLregistReportHour.value)))
  {
    errorMessage("����ʱ�䲻�����ڳ���ʱ��");
    fm.prpLregistReportHour.focus();
    fm.prpLregistReportHour.select();
    return false;
  }else if (i==0 && (parseFloat(fm.prpLregistDamageStartHour.value)==parseFloat(fm.prpLregistReportHour.value)))
  {
  	if(parseFloat(fm.prpLregistDamageStartMinute.value)>parseFloat(fm.prpLregistReportMinute.value))
  	{
	    errorMessage("����ʱ�䲻�����ڳ���ʱ��");
	    fm.prpLregistReportMinute.focus();
	    fm.prpLregistReportMinute.select();
	    return false;
	  }
  }
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

function checkEarNoBeforeSave(){
	 var count = getElementCount("prplCompensateEarEarNo");
	 var earnos = document.getElementsByName("prplCompensateEarEarNo");
	 var fCode = document.getElementsByName("prplCompensateEarFCode");
	 var inprocess = document.getElementsByName("prplCompensateEarInprocess");
	 var listFlag = document.getElementsByName("listFlag")[0].value;
	 	for(var index =0 ;index < count ; index++)
	 	{
	 	 if (index ==0) continue;
	 	if(listFlag == "true"){
	 		if(trim(fCode[index].value).length == 0)
		 	 {
		 	 	alert("�ñ����ѹ����嵥����˫�������¼���򣬲�ѯ��ѡ���Ӧ������Ϣ");
		 	 	return false;
		 	 }
	 		if(trim(inprocess[index].value) == "Y")
		 	 {
		 	 	alert("�������ڽ��д���Ķ���ţ������ύ��");
		 	 	return false;
		 	 }
	 	 }
	 	 else if(listFlag == "error"){
	 		if(trim(fCode[index].value).length == 0)
		 	 {
		 	 	alert("�ñ����嵥�����쳣,������Ϣ��������ϵ������");
		 	 	return false;
		 	 }
	 	 }
	 	 if(trim(earnos[index].value).length == 0)
	 	 {
	 	 	alert("����Ų���Ϊ��!");
	 	 	return false;
	 	 }
	 	 var i =index;
	 	 i++;
	 	 while(i < count)
	 	 {
	 	  if(earnos[index].value == earnos[i].value)
	 	  {
	 	  alert("����Ų����ظ�");
	 	  	return false;
	 	 	}
	 	 	 i++;
	 	 }
	 	 
	 	}
	 	return true;
}
/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{
   if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	{
		var bool = checkEarNoBeforeSave();
		if ( bool != true) return false;
	}
  var errorMessage = "";
  
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "��ϵ�˵绰����Ϊ��\n";
  }
  //���If�ж�������ҳ�����ӱ�¼������ˡ�
  if(fm.prpLregistReportorName.value==null||fm.prpLregistReportorName.value==""){
    errorMessage = errorMessage + "�����˲���Ϊ��\n";
  }  
  if(checkForm()==false)
  {
    return false;
  }
  
  if(!validateForm(fm))
  {
    return false;
  }
  //modify by liujianbo modify 20051110 start
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
  }
     //modify by liujianbo modify 20051110 end 
  if(fm.acceptFlag[0].checked==false && fm.acceptFlag[1].checked==false){
    errorMessage = errorMessage + "�����־������Ϊ��\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "�Ƿ����ı��չ�˾Ͷ��������Ϊ��\n";
  }
     
  fm.buttonSaveType.value = saveType;
     
  //add by qinyongli 2005/07/20 start
  //��ȡ����������������
  var delayDays=fm.configValue.value;
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var registDay = fm.prpLregistReportDate.value;
  var regist = new Date(registDay.substring(0,4),registDay.substring(5,7)-1,registDay.substring(8,10));
  var message = "";
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
  	message = message + "��ʾ����������������������"+delayDays+"�죬\n";
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
  	 var message1 = "����ʱ���ڱ����ڼ�����,�����豨��!��";
  	 alert(message1);
  	 return false;
  }
  if (message.length>0&&!confirm(message)) {
     return false;
  }
  //add end qinyongli 2005/07/20 end
  //add by qinyongli  start  2005-9-2
  //reason:�����䵥���ںͳ������ڵ��жϣ��䵥���ڱ����ڳ�������֮��
  var inputDate  = fm.prpLregistInputDate.value; 
  if(new Date(inputDate)< new Date(damageDay)){
      errorMessage = errorMessage + "�������ڲ��ܴ����䵥����\n";
  }

 // if(regist < damage){
  //    errorMessage = errorMessage + "�������ڲ��ܴ��ڱ�������\n";
 // }
  //add by qinyongli end 
  var currDate = new Date();
  if(regist > currDate){
  		errorMessage = errorMessage + "�������ڲ��ܴ��ڵ�ǰ����\n";
  }
  if(new Date(inputDate) > currDate){
  		errorMessage = errorMessage + "�䵥���ڲ��ܴ��ڵ�ǰ����\n";
  }
  
  
  //modify by liuyanmei 20051024 start 
  var  prpLregistAddressCode= fm.prpLregistAddressCode.value;
  /*if(prpLregistAddressCode.length<1){
    errorMessage = errorMessage + "���յ��������벻����Ϊ��\n";
  }else if(prpLregistAddressCode.length!=6){
    errorMessage = errorMessage + "���յ���������ӦΪ6λ\n";
  }*/

   var  prpLregistDamageAddress= fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "���յز�����Ϊ��\n";
  }
  //modify by liuyanmei 20051024 end 
  
  for(var j=1;j<fm.prpLacciPersonFamilyNo.length;j++){
    if(isEmptyField(fm.prpLacciPersonFamilyNo[j]))
    {
	   alert("��"+ j+"�����������Ʋ���Ϊ��!");
	   return false;
	}
  }
 
  //�ұ���Ϣ
  var prpLregistEstiCurrency = fm.prpLregistEstiCurrency.value;
  if(prpLregistEstiCurrency == ""){
        errorMessage += "�ұ���Ϊ�գ�";
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }

    field.disabled = true;
  	fm.submit(); 
    return true;
}

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveFormNew(field,saveType,scheduleRef)
{
   if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
  {
    var bool = checkEarNoBeforeSave();
    if ( bool != true) return false;
  }
  var errorMessage = "";
  
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "��ϵ�˵绰����Ϊ��\n";
  }
  
  if(checkForm()==false)
  {
    return false;
  }
  
  if(!validateForm(fm))
  {
    return false;
  }
  //modify by liujianbo modify 20051110 start
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
  }
     //modify by liujianbo modify 20051110 end 
  if(fm.acceptFlag[0].checked==false && fm.acceptFlag[1].checked==false){
    errorMessage = errorMessage + "�����־������Ϊ��\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "�Ƿ����ı��չ�˾Ͷ��������Ϊ��\n";
  }
     
  fm.buttonSaveType.value = saveType;
  fm.scheduleRef.value = scheduleRef;   
  //add by qinyongli 2005/07/20 start
  //��ȡ����������������
  var delayDays=fm.configValue.value;
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var registDay = fm.prpLregistReportDate.value;
  var regist = new Date(registDay.substring(0,4),registDay.substring(5,7)-1,registDay.substring(8,10));
  var message = "";
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
    message = message + "��ʾ����������������������"+delayDays+"�죬\n";
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
     var message1 = "����ʱ���ڱ����ڼ�����,�����豨��!��";
     alert(message1);
     return false;
  }
  if (message.length>0&&!confirm(message)) {
     return false;
  }
  //add end qinyongli 2005/07/20 end
  //add by qinyongli  start  2005-9-2
  //reason:�����䵥���ںͳ������ڵ��жϣ��䵥���ڱ����ڳ�������֮��
  var inputDate  = fm.prpLregistInputDate.value; 
  if(new Date(inputDate)< new Date(damageDay)){
      errorMessage = errorMessage + "�������ڲ��ܴ����䵥����\n";
  }

 // if(regist < damage){
  //    errorMessage = errorMessage + "�������ڲ��ܴ��ڱ�������\n";
 // }
  //add by qinyongli end 
  var currDate = new Date();
  if(regist > currDate){
      errorMessage = errorMessage + "�������ڲ��ܴ��ڵ�ǰ����\n";
  }
  if(new Date(inputDate) > currDate){
      errorMessage = errorMessage + "�䵥���ڲ��ܴ��ڵ�ǰ����\n";
  }
  
  
  //modify by liuyanmei 20051024 start 
  var  prpLregistAddressCode= fm.prpLregistAddressCode.value;
  /*if(prpLregistAddressCode.length<1){
    errorMessage = errorMessage + "���յ��������벻����Ϊ��\n";
  }else if(prpLregistAddressCode.length!=6){
    errorMessage = errorMessage + "���յ���������ӦΪ6λ\n";
  }*/

   var  prpLregistDamageAddress= fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "���յز�����Ϊ��\n";
  }
  //modify by liuyanmei 20051024 end 
  
  for(var j=1;j<fm.prpLacciPersonFamilyNo.length;j++){
    if(isEmptyField(fm.prpLacciPersonFamilyNo[j]))
    {
     alert("��"+ j+"�����������Ʋ���Ϊ��!");
     return false;
  }
  }
 
  //�ұ���Ϣ
  var prpLregistEstiCurrency = fm.prpLregistEstiCurrency.value;
  if(prpLregistEstiCurrency == ""){
        errorMessage += "�ұ���Ϊ�գ�";
  }
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
	//modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 ��ʾ�Ƿ��ڱ��������ڣ��Ƿ���뱣�����ڻ�ֹ�ںܽ���10�죩
   var checkFlag = fm.checkFlag.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var RecentCount = parseInt(fm.RecentCount.value);
  var RegistViewLimitDay = parseInt(fm.RegistViewLimitDay.value);
  var payFee = parseInt(fm.prpLregistPayFee.value);
  var delinquentfeeCase = fm.delinquentfeeCase.value;
  
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  var prpLregistEndDate = fm.prpLregistEndDate.value;
  var prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;
  var damageDate = fm.damageDate.value;
  var DamageStartTen = "";

  var startTenDay = new Date(prpLregistStartDate.substring(0,4),prpLregistStartDate.substring(5,7)-1,prpLregistStartDate.substring(8,10)-1);
  var endTenDay = new Date(prpLregistEndDate.substring(0,4),prpLregistEndDate.substring(5,7)-1,prpLregistEndDate.substring(8,10));
  if(prpLregistDamageStartDate == "" || prpLregistDamageStartDate == null){
  	DamageStartTen = new Date(damageDate.substring(0,4),damageDate.substring(5,7)-1,damageDate.substring(8,10));
  }else{
  	DamageStartTen = new Date(prpLregistDamageStartDate.substring(0,4),prpLregistDamageStartDate.substring(5,7)-1,prpLregistDamageStartDate.substring(8,10));
  }  
  var  StartTen = (DamageStartTen.getTime()- startTenDay.getTime())/(24*60*60*1000);
  var  EndTen = (endTenDay.getTime()-DamageStartTen.getTime())/(24*60*60*1000);
 
  //modify by liuyanmei add 20051109 end

  if(fm.prpLregistRegistNo.length<10){
    fm.messageSave.disabled=true;
    fm.messageView.disabled=true; 
  }
  
  
   //�ж��Ƿ�����ͬ����������1�����ϵı���,ֻ�ڵǼǵ�ʱ����ʾ.
  
  var registNo = fm.prpLregistRegistNo.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var policyNo = fm.prpLregistPolicyNo.value;
  //add by qinyongli ���ӱ���ע��,����ʱ�䣬��ǩ�����ɶ�ҵ�񣬳��մ������ٷֹ�������ʾ�� 2005-7-28
  var coinsFlag = fm.coinsFlag.value;
  var tempReinsFlag = fm.tempReinsFlag.value;
  var shareHolderFlag = fm.shareHolderFlag.value;
  var message = "";
  
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
  if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
     message = message + "�˱���Ϊ��/��������\n";
  }
  if(tempReinsFlag!=0){
     message = message + "�˱������ٷ�ҵ��\n";
  }
  //modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 ��ʾ�Ƿ��ڱ��������ڣ��Ƿ���뱣�����ڻ�ֹ�ںܽ���10�죩
  
   if(checkFlag!=0){//checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
       errorMessage =  errorMessage + "�˱�������������״̬ ��\n";
  }
  if(prpLregistDamageStartDate<prpLregistStartDate){
      message = message + "����ʱ�䲻�ڱ����ڼ��ڣ�\n";
  }
  if(prpLregistDamageStartDate>prpLregistEndDate){
      message = message + "����ʱ�䲻�ڱ����ڼ��ڣ�\n";
  }
  if(StartTen<10){
      message = message + "������Ч"+StartTen+"�����գ�\n";
  }
  if(EndTen<10){
      message = message + "����ʱ����ֹ������ֻ��"+EndTen+"�죡\n";
  }
  if(payFee==-1){
         message=message+"�˱�������δ��,�����ش������� \n";
     }
      else if(payFee==-2){
           message=message+"�˱����ѽ�δ��ȫ,�����ش������� \n";
           message = message + delinquentfeeCase + "\n";
      }
  //modify by liuyanmei add 20051109 end 
  //alert (sameCount);
  if (registNo.length<1)
  {
  	//˵���ǵǼ�
  	if (sameCount>0) 
  	{
           message = message + "��������Ϊ'"+policyNo+"'�Ѿ�����"+sameCount +"�Σ���鿴���մ�����Ϣ��\n";
        if(RecentCount>0&&RegistViewLimitDay>0){
  	   message = message+"�������"+RegistViewLimitDay+"���Ѿ�����"+RecentCount +"�Σ� \n";
  	 }
  	}else
  	   {
  	      fm.button_Peril_Open_Context.disabled = true;
  	   }
      if (message.length>0) {
          alert(message);
      } 
    
  }else{
      if (message.length>0) {
          alert(message);
      } 
  }
  // add by qingyongli  end  2005-7-28
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
//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLregistPolicyNo.value;
     var RiskCode  =fm.prpLregistRiskCode.value;
     var damageDate=fm.prpLregistDamageStartDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
 	if("A01" == versionNo || versionNo == "" )
	 	{
	 	 vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 	}
	  else
		{
		 vURL = CoreWebUrl +'/' + RiskCode + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
		}
       window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

function printFH()
{
    var BizNo     =fm.prpLregistPolicyNo.value;
    var RiskCode  =fm.prpLregistRiskCode.value;
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL =  CoreWebUrl +'/' + RiskCode + '/cb/UIPolicy' + RiskCode + 'FHNoneFormatPrint.jsp?EDITTYPE=POLICY&FlagForPrint=46&BizNo='+ BizNo;
    window.open(vURL,'�ֻ��嵥��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
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
function checkStatQuantity(field){
	if(isNaN(field.value)){
		alert("�⸶����Ϊ����!");
		field.focus();
		field.select();
		return;
	}
	if(isNaN(fm.statQuantity.value)){
		fm.statQuantity.value = 0;
	}
	var statQuantity = Number(fm.statQuantity.value);
	var lossQuantity = Number(field.value);
	if(lossQuantity > statQuantity){
		alert("�⸶�������ܴ��ڳб�����! �б���: "+statQuantity);
		field.focus();
		field.select();
	}
	return;
}

//���Ӷ�����б�
function addEarList()
{  
    
    var strPrpLregistPolicyNo = fm.prpLregistPolicyNo.value;
    var strPrpLregistRegistNo = fm.prpLregistRegistNo.value;
    var strEditType = fm.editType.value;
    var strURL = '/claim/commonAgri/regist/AgriRegistEarList.jsp?strEditType='+strEditType+'&strPrpLregistPolicyNo='+strPrpLregistPolicyNo+'&CurrentEar=addAppEarCallBack'+'&strPrpLregistRegistNo='+strPrpLregistRegistNo;//+'strPrpInsuredName='+strPrpInsuredName+'&strPrpEarNo='+strPrpEarNo;
    
    window.open(strURL,'AddPrpMainEarList','width=680,height=350,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=0,resizable=1,status=0');
}
//���������ʵ��
function earCheck(){
    //���ص����еĶ������֤ʧ�ܵı�־��
	hideRealEarCheckFailureSign();
	
	
	var policyNo   = fm.prpLregistPolicyNo.value;
	//var strPrpLregistRegistNo = fm.prpLregistRegistNo.value;
	var earList = "";
	var checkResult="true";
	
	//������ŵ����롣
	var checkEarImputFormatResult = checkEarInputFormat();
	if(!checkEarImputFormatResult)
		return false;
	
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
		
			if(i==1) 
				earList = fm.prpLearNo[i].value;
			else 
				earList = earList + "," + fm.prpLearNo[i].value
		}
		var parameterList = "policyNo=" + policyNo;
		parameterList = parameterList + "&" + "earList=" + earList;
		//���������б�ȥ��ѯ���ӵ���ϵͳ�гб��嵥��
		//���ؽ��Ϊ�� ��"|"�����ֿ���������ŷ��ؽ����
		//           ÿһ������ŷ��ؽ�����±���ʾ��
		//           ����ţ�ũ������          �嵥�д��ڵĶ���š�
		//           ����ţ�cannotfind     ����Ų����ڣ���Ҫ�������롣
		//           ����ţ�noIsuranceList �б��嵥�����ڣ�������������롣
		var strEarCheckResult = findEarInfo(trim(parameterList));
		
		//alert("strEarCheckResult is "+strEarCheckResult);
		if("" == strEarCheckResult || null == strEarCheckResult){
			alert("�������֤ʧ�ܣ�");
		}else {
			var earCheckResultList = strEarCheckResult.split("|");
			var unRealEar = "";
			//alert("earCheckResultList.length is "+earCheckResultList.length);
			if(earCheckResultList.length>0){
				for(var j=0; j < earCheckResultList.length; j++){
					//alert("earCheckResultList["+j+"]  is "+earCheckResultList[j]);
					if(null != earCheckResultList[j]){
						var singleEarInfo = earCheckResultList[j].split(":");
						//alert("singleEarInfo  is "+singleEarInfo);
						//alert("vPrpLearNoLength  is "+vPrpLearNoLength);
						for(var i = 1;i < vPrpLearNoLength;i++){
							var prpLearNo = trim(fm.prpLearNo[i].value);
							//alert("singleEarInfo  is "+singleEarInfo[0]);
							//alert("prpLearNo  is "+prpLearNo);
							if(singleEarInfo[0] == prpLearNo){
								if("cannotfind"==singleEarInfo[1]){
									fm.valueofEarCheck.value="false";
									fm.prpLearNo[i].style.backgroundColor = "red";
									fm.fname[i].value = "";
									//�Ѷ���ű����������ڵ���������ʾ��
									if(""==unRealEar)
										unRealEar = singleEarInfo[0];
									else unRealEar = unRealEar + "," + singleEarInfo[0];
								}
								else if("noIsuranceList"!=singleEarInfo[1]){
									fm.fname[i].value = singleEarInfo[1];
								}
							}
						}
					}
				}
			}
			if(""!=unRealEar)
				alert("����ţ�"+unRealEar+" �����ڣ���������д��");
			else{
				fm.valueofEarCheck.value="true";
				alert("�������֤ͨ������������룡");
			}
		}
	}
}
//���Ҷ���ţ����ض���ŵ���Ϣ
//strQueryString������ʽ�ǣ�����1=ֵ1&����2=ֵ2
function findEarInfo(strQueryString)
{
  var earURL = "/claim/combineAgri/regist/AgriRegistEarList.jsp";
  var strURL = earURL + "?" + strQueryString;
  var vXmlText = getResponseXmlText(strURL);
  //�ص�ͷβ�ַ�[]
  if(vXmlText.length>=2)
    return vXmlText.substring(1,vXmlText.length-1);
  else
    return "";
}
//�������еĶ������֤ʧ�ܵı�ǣ�����ź�ɫ����ɫ
function hideRealEarCheckFailureSign(){
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			fm.prpLearNo[i].style.backgroundColor = "white";
		}
	}
}
//������ŵ������Ƿ��п�ֵ�������ظ���
function checkEarInputFormat(){
	var vPrpLearNoLength = getElementCount("prpLearNo");
	if(vPrpLearNoLength == 1){
		alert("�������Ϣ����Ϊ��");
		return false;
	}
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			if(isEmptyField(fm.prpLearNo[i])){
				alert("��"+i+"�ж�����б���Ϣ�Ķ���Ų���Ϊ�գ�");
	 			return false;
			}
		}
	}
	if(vPrpLearNoLength > 1){
		for(var i = 1;i < vPrpLearNoLength;i++){
			for(var j = i + 1;j < vPrpLearNoLength;j++){
	  			if(fm.prpLearNo[i].value == fm.prpLearNo[j].value){
					alert("�������Ϣ�б��У���"+i+"�к͵�"+j+"���ظ�!");
			 		return false;
	  			}
	 		}
	  	}
	}
	return true;
}
function updateValueofEarCheck(){
	fm.valueofEarCheck.value="false";
}

//ũ�ղ鿱ҳ��"..."��ť�����¼���������ͬ��������౨������ʾ add by xuecheng
function buttonOnClickAgriCheck(actionName,policyNo,curRegistNo)
{
  var allPerilCount = document.getElementsByName("PerilCount");
  var sameCount = parseInt(allPerilCount[0].value);
  if (sameCount <1)
  {
  	var buttonPerilOpenContext = document.getElementsByName("button_Peril_Open_Context");
  	buttonPerilOpenContext[0].disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}