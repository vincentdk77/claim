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

 function setreadonlyforhouse()
 {
     var riskcode = fm.prpLregistRiskCode.value;
     if(riskcode == "0310"||riskcode == "0312")
     {
          fm.buttonhouse.disabled = true;
          fm.buttonEarDelete.disabled = true;
          fm.prplEarEarNoSearch.readOnly = true;
          fm.prplEarNameSearch.readOnly = true;
          
          var count = getElementCount("buttonEarDelete");
          for(var index =0 ;index < count ; index++)
          {
             if (index ==0) continue;
              fm.buttonEarDelete[index].style.display = "none";
          }
     }
 
 }
 
   function initForAdd()
 {
    var riskcode = fm.prpLregistRiskCode.value;
    if(riskcode == "0310"||riskcode == "0312")
    {
       var number = getElementCount("prplCompensateHouseIDcard");
       if(number > 1)
       {
           fm.buttonhouse.disabled = true;
       }
    }
 }
 
function setIdEstimateLoss3()
{
     var riskcode = fm.prpLregistRiskCode.value;
     if(riskcode == "0310"||riskcode == "0312")
     {
         var sumLoss = 0;
         var number = getElementCount("prplCompensateHouseEstimateLoss");
     
          for(var k=1;k<number;k++){
          sumLoss = sumLoss + parseFloat(fm.prplCompensateHouseEstimateLoss[k].value);
           }
         fm.prpLregistEstimateLoss.value = sumLoss;
     }
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
    errorMessage("����ʱ�䲻�����ڳ���ʱ��")
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

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{

  var errorMessage = "";
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "��ϵ�˵绰����Ϊ��\n";
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
    errorMessage = errorMessage + "������־������Ϊ��\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "�Ƿ����ı��չ�˾Ͷ��������Ϊ��\n";
  }
  if(null != fm.prpLregistRiskCode && "ZH03" == fm.prpLregistRiskCode.value){
		if(null == fm.prpLregistRemark || "" == trim(fm.prpLregistRemark.value)|| "null" == fm.prpLregistRemark.value){
			errorMessage = errorMessage + "����Ų�����Ϊ��\n";
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
  var message = "";
  var regist_damage = (regist.getTime()- damage.getTime())/(24*60*60*1000);
  if(regist_damage>=delayDays){
  	message = message + "��ʾ����������������������"+delayDays+"�죬\n";
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  if((damageStartDate < startDate) || (damageStartDate > endDate)){
  	 var message1 = "����ʱ���ڱ����ڼ�����,�����豨��!";
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
    if(new Date(inputDate) < new Date(damageDay)){
        errorMessage = errorMessage + "�������ڲ��ܴ����䵥����\n";
    }
    if(new Date(registDay) < new Date(damageDay)){
        errorMessage = errorMessage + "�������ڲ��ܴ��ڱ�������\n";
    }
  //add by qinyongli end 
  
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
  //�жϻ��������Ƿ�Ϊ31ZH���Ϻ��ĵ��ӱ����ϴ��¹�����Ϣ;
  var comComeClassCode = fm.comCodeClassCode.value;
  if(comComeClassCode == '31ZH'){
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
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
  
  if(checkForm()==false)
  {
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
  var errorMessage = "";
  if(fm.prpLregistPhoneNumber.value==null||fm.prpLregistPhoneNumber.value==""){
    errorMessage = errorMessage + "��ϵ�˵绰����Ϊ��\n";
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
    errorMessage = errorMessage + "������־������Ϊ��\n";
  }
  if(fm.repeatInsureFlag[0].checked==false && fm.repeatInsureFlag[1].checked==false){
    errorMessage = errorMessage + "�Ƿ����ı��չ�˾Ͷ��������Ϊ��\n";
  }
  if(null != fm.prpLregistRiskCode && "ZH03" == fm.prpLregistRiskCode.value){
    if(null == fm.prpLregistRemark || "" == trim(fm.prpLregistRemark.value)|| "null" == fm.prpLregistRemark.value){
      errorMessage = errorMessage + "����Ų�����Ϊ��\n";
    }
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
     var message1 = "����ʱ���ڱ����ڼ�����,�����豨��!";
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
    if(new Date(inputDate) < new Date(damageDay)){
        errorMessage = errorMessage + "�������ڲ��ܴ����䵥����\n";
    }
    if(new Date(registDay) < new Date(damageDay)){
        errorMessage = errorMessage + "�������ڲ��ܴ��ڱ�������\n";
    }
  //add by qinyongli end 
  
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
  
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
  
  if(checkForm()==false)
  {
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
  
  //�����־
  var businessFlag  = fm.businessFlag.value;
 
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
  //�Ƿ����������ʾ
  if(payFee==-1&&businessFlag!="1"){
         message=message+"�˱�������δ��,�����ش��������� \n";
     }
      else if(payFee==-2&&businessFlag!="1"){
           message=message+"�˱����ѽ�δ��ȫ,�����ش��������� \n";
           message = message + delinquentfeeCase + "\n";
      }
   if(businessFlag=="1"){
        message=message+"�˱���Ϊ����ҵ�� \n";
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
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
//modify ���ĳ���ʱ������Ϣ  by qinyongli 2005-10-5
function flashPage(){
    var damageDate = fm.prpLregistDamageStartDate.value;
    var damageHour = fm.prpLregistDamageStartHour.value;
    var policyNo   = fm.policyno.value;
    var faimlyNo   = fm.prpLregistRemark.value;
    var vURL='/claim/registBeforeEdit.do?prpCmainPolicyNo='+policyNo+'&editType=ADD&damageDate='+damageDate+'&damageHour='+damageHour+'&modifyDamageDate=true';
    if(null != fm.prpLregistRemark && "ZH03" == fm.prpLregistRiskCode.value)
    {
    	var vURL = vURL +'&faimlyNo='+faimlyNo;
    }
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