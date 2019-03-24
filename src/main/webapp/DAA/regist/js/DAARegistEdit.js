/*****************************************************************************
 * DESC       �������ǼǵĽű�����ҳ��(�������)
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-03-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


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


/**
 *@description ��鱨���Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
  //¼�������ڱ�������֮��
  if(fm.prpLregistCurrentDate != null && compareFullDate(fm.prpLregistReportDate.value,fm.prpLregistCurrentDate.value)>0)
  {
  	errorMessage("����ʱ�䲻�����ڵ�ǰ����");
  	fm.prpLregistReportDate.focus();
    fm.prpLregistReportDate.select();
  	return false;
  }
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

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{
  var errorMessage = "";
  var riskCode=fm.prpLregistRiskCode.value;
  //reason:�����䵥���ںͳ������ڵ��жϣ��䵥���ڱ����ڳ�������֮��
  var damageDay    = fm.prpLregistDamageStartDate.value;
  var inputDate    = fm.prpLregistInputDate.value;
  if(inputDate<damageDay){
    errorMessage = errorMessage + "�������ڲ��ܴ����䵥����\n";
  }
  var othFlag = fm.prpLregistOthFlag.value;
  if(othFlag.substring(2,3)=="1"){
    alert("�������˱�������������");
    return false;
  }
  if(othFlag.substring(3,4)=="1"){
    alert("������ע��������������");
    return false;
  }
  var startDate = fm.prpLregistStartDate.value;
  var endDate   = fm.prpLregistEndDate.value;
  var damageStartDate = fm.prpLregistDamageStartDate.value;
  //��ʱ��Ч�ı��������жϣ���ʱ��Ч�ĵ�������java�е��ж�Ϊ׼��
  var immediateValidPeriod = fm.immediateValidPeriod.value;
  if(immediateValidPeriod != ""){
    if(immediateValidPeriod == "N"){
        alert("��ʾ������ʱ���ڱ����ڼ����⣬�����豨��!");
        return false;
    }
  }else{
    if((damageStartDate < startDate) || (damageStartDate > endDate)){    
        alert("��ʾ������ʱ���ڱ����ڼ����⣬�����豨��!");
        return false;
    }
  }
  var message = "";

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
  if(message != ""){
  	if(window.confirm(message) == false){
  		return false;
    }
  }
  fm.buttonSaveType.value = saveType;
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "����ժҪ������Ϊ��\n";
  }
 
  //modify by liuyanmei 20051024 start 
  var  prpLregistDamageAddress= fm.prpLregistDamageAddress.value;
  if(prpLregistDamageAddress.length<1){
    errorMessage = errorMessage + "���յص㲻����Ϊ��\n";
  }
  var prpLregistDamageCode = fm.prpLregistDamageCode.value;
  var prpLregistDamageName = fm.prpLregistDamageName.value;
  if(prpLregistDamageCode.length<1 || prpLregistDamageName.length < 1){
    errorMessage = errorMessage + "����ԭ������Ϊ��\n";
  }
  
  var  prpLregistReportorName= fm.prpLregistReportorName.value;
  if(prpLregistReportorName.length<1){
    errorMessage = errorMessage + "�����˲�����Ϊ��\n";
  }
	
  var  prpLregistLinkerName= fm.prpLregistLinkerName.value;
  if(prpLregistLinkerName.length<1){
    errorMessage = errorMessage + "��ϵ�˲�����Ϊ��\n";
  }
   var  prpLregistPhoneNumber= fm.prpLregistPhoneNumber.value;
  if(prpLregistPhoneNumber.length<1){
    errorMessage = errorMessage + "��ϵ�绰������Ϊ��\n";
  }
  if(fm.prpLregistSS[0].checked==false&&fm.prpLregistSS[1].checked==false
           &&fm.prpLregistSS[2].checked==false&&fm.prpLregistSS[3].checked==false
           &&fm.prpLregistSS[4].checked==false)
  {
    errorMessage = errorMessage + "����ѡ����ʧ����\n";
  }
  var  prpLdriverDriverName= fm.prpLdriverDriverName.value;
  if(prpLdriverDriverName.length<1){
    errorMessage = errorMessage + "��ʻԱ������Ϊ��\n";
  }
  var  prpLdriverDriverPhone= fm.prpLdriverDriverPhone.value;
  if(prpLdriverDriverPhone.length<1){
    errorMessage = errorMessage + "��ʻԱ��ϵ�绰������Ϊ��\n";
  }
  var prpLregistDamageStartHour = fm.prpLregistDamageStartHour;
  var prpLregistDamageStartMinute = fm.prpLregistDamageStartMinute;
  if(isEmptyField(prpLregistDamageStartHour) || isEmptyField(prpLregistDamageStartMinute)){
  	errorMessage = errorMessage + "����ʱ�䲻����Ϊ��\n";
  }
  //���������ҳ����ӦԪ�ؽ��п���
  var prpLregistDamageAreaCode = fm.prpLregistDamageAreaCode.value;
  var prpLregistDamageAreaName = fm.prpLregistDamageAreaName.value;
  if(prpLregistDamageAreaCode.length < 1 || prpLregistDamageAreaName.length < 1){
  	errorMessage = errorMessage + "������������Ϊ��\n";
  }
  var damageAddressType = fm.damageAddressType.value;
  if(damageAddressType.length < 1){
    errorMessage = errorMessage + "���յص���಻����Ϊ��\n";
  }
  var indemnityDuty = fm.indemnityDuty.value;
  if(indemnityDuty.length < 1){
    errorMessage = errorMessage + "�¹����β�����Ϊ��\n";
  }
  var prpLregistHandleUnit = fm.prpLregistHandleUnit.value;
  var prpLregistHandleUnitName = fm.prpLregistHandleUnitName.value;
  if(prpLregistHandleUnit.length < 1 || prpLregistHandleUnitName.length < 1){
    errorMessage = errorMessage + "�¹ʴ����Ų�����Ϊ��\n";
  }
  var firstSiteFlag0 = fm.firstSiteFlag[0].checked;
  var firstSiteFlag1 = fm.firstSiteFlag[1].checked;
  if(firstSiteFlag0 == "" && firstSiteFlag1 == ""){
    errorMessage = errorMessage + "�Ƿ��һ�ֳ�������Ϊ��\n";
  }

  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }

  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 // if(!validateForm(fm,'ThirdParty_Data,Driver_Data,ThirdCarLoss_Data,PersonTrace_Data'))
 // {
 //   return false;
 //}

  if(checkForm()==false)
  {
    return false;
  }
  
  //add for : �����ύʱ��ʾ����ʱ�䳬����ʱ��48Сʱ���Ƿ����
  if(confirmOverTime()==false)
  {
  	if (!window.confirm("����ʱ���ѳ�������ʱ��48Сʱ���Ƿ����" )){
  	
          return false;
        }
  }

  fm.nextScheduleTypeCheck.value="1";
  if (saveType=="4"){	  
	  //1.���һ�����˸����Ƿ��м�¼������м�¼�����Ե�������
	  var count=getElementCount("prpLpersonTracePersonNo");
	  if (count>1){
	        fm.prpLpersonTraceSelectSend.value="1";	        
	  } 
	    //2.���һ�²Ʋ������Ƿ��м�¼������м�¼�����Ե��ȲƲ�����
	  count=getElementCount("prpLthirdPropItemNo");
	  if (count>1){
	    fm.prpLthirdPropSelectSend.value="1";	    
	  } 	  
	  //������Ҫ����ǲ���ѡ����һ�����ȣ���������ǳ��յģ���Ҫ�������ѡ��һ������Ϊ����
	  if (!submittime()) return false;
	  ableAllInput();
  }
  var underWriteEndDate = fm.prpLregistUnderWriteEndDate.value;
  if(underWriteEndDate!=""){
    if((damageStartDate < underWriteEndDate) && (startDate < underWriteEndDate)){
    	if(confirm("����ʱ���������ڵ�ǩ������֮�䣡�Ƿ�ͨ��")==false){
    	  return false;
    	}
    }
  }
  if(fm.flashPageFlag.value!="1"){
		alert("���ڳ���ʱ���������ڸ��±�����Ϣ�����Ժ����ύ��");
		return false;
  }
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
  fm.submit();
  return true;
}




//add by lym 20060604  for ǿ�� -----------start 

function initSet_qs()
{
  var  qsFlag = fm.qsFlag.value;
  var  isStoppingCI = fm.isStoppingCI.value;//��ǿ���Ƿ���ͣʻ�ڼ���յı�־
  var isStoppingBusiness = fm.isStoppingBusiness.value;//��ҵ���Ƿ���ͣʻ�ڼ���յı�־
  var isValidRelatedFlag = fm.isValidRelatedFlag.value;//��ҵ�ա���ǿ�����޹����ı�־
  var errorMessage = message.innerHTML;
  if ( qsFlag != null && qsFlag !='' && qsFlag=='Y') { //�������ʼ�����������򲻳�ʼ��
      var qs_prpLregistStartDate = fm.qs_prpLregistStartDate.value;
      var qs_prpLregistEndDate = fm.qs_prpLregistEndDate.value;
      var qs_prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;
      var damageDate = fm.damageDate.value;
      var DamageStartTen = "";
  
      var startTenDay = new Date(qs_prpLregistStartDate.substring(0,4),qs_prpLregistStartDate.substring(5,7)-1,qs_prpLregistStartDate.substring(8,10)-1);
      if(qs_prpLregistDamageStartDate == "" || qs_prpLregistDamageStartDate == null){
  		DamageStartTen = new Date(damageDate.substring(0,4),damageDate.substring(5,7)-1,damageDate.substring(8,10));
  	  }else{
  		DamageStartTen = new Date(qs_prpLregistDamageStartDate.substring(0,4),qs_prpLregistDamageStartDate.substring(5,7)-1,qs_prpLregistDamageStartDate.substring(8,10));
	  }
      var StartTen = (DamageStartTen.getTime()- startTenDay.getTime())/(24*60*60*1000);
      var endTenDay = new Date(qs_prpLregistEndDate.substring(0,4),qs_prpLregistEndDate.substring(5,7)-1,qs_prpLregistEndDate.substring(8,10));
      var EndTen = (endTenDay.getTime()-DamageStartTen.getTime())/(24*60*60*1000);
     
      //�ж��Ƿ�����ͬ����������1�����ϵı���,ֻ�ڵǼǵ�ʱ����ʾ.
      var registNo = fm.prpLregistRegistNo.value;
      var sameCount = parseInt(fm.qs_PerilCount.value);
     
      var RecentCount = parseInt(fm.qs_RecentCount.value);
      var RegistViewLimitDay = parseInt(fm.RegistViewLimitDay.value);
     
      var policyNo = "";
      var payFee = parseInt(fm.prpLregistPayFee.value);
      if(fm.prpLregistRiskCode.value == "0507" ||fm.prpLregistRiskCode.value =="0577"||fm.prpLregistRiskCode.value =="0587"){
      	policyNo = fm.prpLregistPolicyNo.value;
      }else{
      	policyNo = fm.mainPolicyNo.value;;
      }
      
      var qs_prpLregistUnderWriteDate=fm.qs_prpLregistUnderWriteDate.value;
      var qs_prpLregistStartDate = fm.qs_prpLregistStartDate.value;
      if(qs_prpLregistUnderWriteDate>qs_prpLregistStartDate){
        errorMessage = errorMessage + "��ǿ�����������������ں˱����ڣ�<br>";
      }  
      
    
      /* if(qs_checkFlag!=0){//qs_checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
           errorMessage =  errorMessage + "�˱�������������״̬ ��\n";
      }*/
     
      if(qs_prpLregistDamageStartDate<qs_prpLregistStartDate){
           errorMessage =  errorMessage + "ǿ������ʱ�䲻�ڱ����ڼ��ڣ�<br>";
      }
      if(qs_prpLregistDamageStartDate>qs_prpLregistEndDate){
           errorMessage =  errorMessage + "ǿ������ʱ�䲻�ڱ����ڼ��ڣ�<br>";
      }
      if(StartTen<10){
           errorMessage =  errorMessage + "������Ч"+StartTen+"�����գ�<br>";
      }
      if(EndTen<10){
           errorMessage =  errorMessage + "ǿ������ʱ����ֹ������ֻ��"+EndTen+"�죡<br>";
      }
      
     
       if (registNo.length<1) 
      {
      	//˵���ǵǼ�
      	if (sameCount>0)
      	{
      	  errorMessage = errorMessage+"��������Ϊ'"+policyNo+"'��ǿ�������Ѿ�����"+sameCount +"�Σ�<br>";
      	  if(RecentCount>0&&RegistViewLimitDay>0){
      	    errorMessage = errorMessage+"�������"+RegistViewLimitDay+"���Ѿ�����"+RecentCount +"�Σ�<br>";
      	  }
        }else
      	{
      		fm.button_Peril_Open_Context.disabled = true;
      	}
      }
     
      if(payFee==-1){
        errorMessage=errorMessage+"��ǿ����������δ��,�����ش����� <br>";
       
      } else if(payFee==-2){
        errorMessage=errorMessage+"��ǿ�������ѽ�δ��ȫ,�����ش������� <br>";
       
      }
     
     
   }
   
   var errorMessage1 = "";
   var ralateRiskName = "����";
   if(fm.riskcode != null && (fm.riskcode.value == "0506"||fm.riskcode.value == "0576"||fm.riskcode.value == "0586")){
        ralateRiskName = "��ǿ�ձ���";
   }
   if(fm.riskcode != null && (fm.riskcode.value == "0507"||fm.riskcode.value == "0577"||fm.riskcode.value == "0587")){
        ralateRiskName = "��ҵ�ձ���";
   }
   if(qsFlag == "OutInsureDate"){
   	   errorMessage1 = errorMessage1+"��ñ���������" + ralateRiskName + "���ڱ����ڼ��ڣ����豨����<br>";
   }
   if(qsFlag == "NotCheckin"){
   	   errorMessage1=errorMessage1+"��ñ���������" + ralateRiskName + "Ϊ��Ч���������豨����<br>";
   }
   if(isValidRelatedFlag == "Y"){
        if(qsFlag == "inStopping" && isStoppingCI == "Y"){
        	errorMessage1=errorMessage1+"�����Ľ�ǿ�ձ�������������ͣʻ�ڼ��ڣ���ǿ�ձ�������������<br>";
        }
        if(qsFlag == "inStopping" && isStoppingBusiness == "Y"){
        	errorMessage1=errorMessage1+"��������ҵ�ձ�������������ͣʻ�ڼ��ڣ���ҵ�ձ�������������<br>";
        }  
        if(qsFlag == "inStopping" && isStoppingBusiness == "Y" && isStoppingCI == "Y"){
            fm.buttonSaveFinishSubmit.disabled='disabled';
            fm.buttonSave.disabled='disabled';
        }                      
   }else{
	   if(qsFlag != "Y" && isStoppingCI == "Y"){
	   		errorMessage1=errorMessage1+"�ñ�������������ͣʻ�ڼ��ڣ�����������<br>";
	        fm.buttonSaveFinishSubmit.disabled='disabled';
	        fm.buttonSave.disabled='disabled';
	   }
	   if(qsFlag != "Y" && isStoppingBusiness == "Y"){
	   		errorMessage1=errorMessage1+"�ñ�������������ͣʻ�ڼ��ڣ�����������<br>";
	        fm.buttonSaveFinishSubmit.disabled='disabled';
	        fm.buttonSave.disabled='disabled';
	   }   
   }
   errorMessage = errorMessage + errorMessage1;
   if (errorMessage.length>0) {
      	document.getElementById("span_message").style.display = "";
      	message.innerHTML=errorMessage;
      }else{
      	message.innerHTML=errorMessage;
  		document.getElementById("span_message").style.display = "none";
  	  }
  	
	var node = fm.prpLregistDamageStartDate;
	var top = node.offsetTop;
	var left = node.offsetLeft;
	
	for (node=node.offsetParent; node != null; node=node.offsetParent) {
		top = node.offsetTop + top;
		left = node.offsetLeft + left;
	}
	
	span_message.style.top = top + 22;
	span_message.style.left = left;
  	
  	
  return true;
}
//add by lym 20060604 for ǿ�� ------end  

function hiddenSpan_message(){
	document.getElementById("span_message").style.display = "none";
}

function showSpan_message(){
	var errorMessage = message.innerHTML;
	if(errorMessage!=null && errorMessage != ""){
		document.getElementById("span_message").style.display = "";
	}
}

function flashPageByTime(){
  var damageStartDate = fm.prpLregistDamageStartDate;
  var prpLregistDamageStartHour = fm.prpLregistDamageStartHour;
  var prpLregistDamageStartMinute = fm.prpLregistDamageStartMinute;
  if(!isEmptyField(prpLregistDamageStartHour) && !isEmptyField(prpLregistDamageStartMinute) && !isEmptyField(damageStartDate)){
  	fm.flashPageFlag.value="0";
  	flashPage();
  }
}


function addOption(){
	//����ԭ��Ĭ��Ϊ����ѡ��
	fm.prpLregistDamageName.value = "��ѡ��";
	fm.prpLregistDamageCode.value = "";
	//��������Ĭ��Ϊ����ѡ��
	fm.prpLregistDamageAreaName.value = "��ѡ��";
	fm.prpLregistDamageAreaCode.value = "";
	//���յص�������ӡ���ѡ��ѡ�Ĭ��Ϊ��
	fm.damageAddressType.add(new Option("��ѡ��",""));
	fm.damageAddressType.value = "";
	//�¹��������ӡ���ѡ��ѡ���Ĭ��Ϊ��
	fm.indemnityDuty.add(new Option("��ѡ��",""));
	fm.indemnityDuty.value = "";
	//�¹ʴ�����Ĭ��Ϊ����ѡ��
	fm.prpLregistHandleUnitName.value = "��ѡ��";
	fm.prpLregistHandleUnit.value = "";
	//�Ƿ��һ�ֳ�����
	fm.firstSiteFlag[1].checked = "";
}

function clearInput(field){
	if(field.value == "��ѡ��"){
		field.value = "";
	}
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
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  var prpLregistEndDate = fm.prpLregistEndDate.value;
  var damageDate = fm.damageDate.value;
  var DamageStartTen = "";
  var prpLregistDamageStartDate = fm.prpLregistDamageStartDate.value;  
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
  
  //modify by lixiang remark 20050315 start
  //ȥ����ʼ�������ձ�ԭ���ĺ���ȥ��
  //loadCheckLoss();
  //modify by lixiang remark 20050315 end

  //modify by liujianbo remark 20050321 start
  //ȥ����ʼ�������ձ�ԭ���ĺ���ȥ��
  //չ���ر�Լ��
  //var span = eval("spanEngage");
  //var engageImg = eval(fm.EngageImg);
  //span.style.display="";
  //engageImg.src="/claim/images/butExpandBlue.gif";
  //modify by liujianbo remark 20050321 end
  //var tab = eval("tabThridProp");
  //tab.style.display="none";
  //tab = eval("tabPersonTrace");
  //tab.style.display="none";
  //fm.ThirdPartyImg.onclick();

  //fm.buttonThirdPartyDelete[1].disabled = true;
  //fm.prpLthirdPartyLicenseNo[1].disabled = true;
   //modify by zhaozhuo add 20050321 start
  //reason: �永������Ϣ�б������������Ƶ�ɫ���������ࡢ�����ͺŲ������޸�
  fm.prpLthirdPartyBrandName[1].disabled = true;
  fm.carKindCode[1].disabled = true;
  fm.licenseColorCode[1].disabled = true;
  //modify by zhaozhuo add 20050321 end
  if(fm.prpLregistRegistNo.length<10){
    fm.messageSave.disabled=true;
    fm.messageView.disabled=true;
  }  

  //�ж��Ƿ�����ͬ����������1�����ϵı���,ֻ�ڵǼǵ�ʱ����ʾ.

  var registNo = fm.prpLregistRegistNo.value;
  var sameCount = parseInt(fm.PerilCount.value);
  var RecentCount = parseInt(fm.RecentCount.value);
  var RegistViewLimitDay = parseInt(fm.RegistViewLimitDay.value);
  var payFee = parseInt(fm.prpLregistPayFee.value);
  var policyNo = "";
  if(fm.prpLregistRiskCode.value =="0506" ||fm.prpLregistRiskCode.value =="0576"||fm.prpLregistRiskCode.value =="0586"){
  	policyNo = fm.prpLregistPolicyNo.value;
  }else{
  	policyNo = fm.mainPolicyNo.value;
  }
  

  var errorMessage = "";
  //Modify by liujianbo modify start 20051104
  //reason:itest:545 ԭ���ձ���Ϊ��ǩ��ҵ�񣬵����б���ʱ������Ӧ����ʾ�����������ǳ����������������ʾ�ģ���ȷ�ϸ������ڳ��մ��Ƿ�ʹ�á� 
  var underWriteEndDate=fm.prpLregistUnderWriteEndDate.value; 
  var prpLregistStartDate = fm.prpLregistStartDate.value;
  if(underWriteEndDate>prpLregistStartDate){
    errorMessage = errorMessage + "�˱��������������ں˱����ڣ�<br>";
  }  
   //modify by liuyanmei add 20051109 satrt
  //reason:200509-lpba-023 ��ʾ�Ƿ��ڱ��������ڣ��Ƿ���뱣�����ڻ�ֹ�ںܽ���10�죩
  
   if(checkFlag!=0){//checkFlag = select count(*) from prpPmain where policyNo=**  and underwriteFlag <>1 
       errorMessage =  errorMessage + "�˱�������������״̬ ��<br>";
  }
  //��ʱ��Ч
  if(fm.immediateValidPeriod.value != ""){
    if(fm.immediateValidPeriod.value == "N"){
        errorMessage =  errorMessage + "����ʱ�䲻�ڱ����ڼ��ڣ�<br>";
    }
  }else{
    if(prpLregistDamageStartDate<prpLregistStartDate){
       errorMessage =  errorMessage + "����ʱ�䲻�ڱ����ڼ��ڣ�<br>";
    }
    if(prpLregistDamageStartDate>prpLregistEndDate){
       errorMessage =  errorMessage + "����ʱ�䲻�ڱ����ڼ��ڣ�<br>";
    }
  }
  if(StartTen<10){
       errorMessage =  errorMessage + "������Ч"+StartTen+"�����գ�<br>";
  }
  if(EndTen<10){
       errorMessage =  errorMessage + "����ʱ����ֹ������ֻ��"+EndTen+"�죡<br>";
  }
  //modify by liuyanmei add 20051109 end 
  
  //Modify by liujianbo modify end 20051104
  //alert (sameCount); 
  if (registNo.length<1) 
  {
  	//˵���ǵǼ�
  	if (sameCount>0)
  	{
  	  errorMessage = errorMessage+"��������Ϊ'"+policyNo+"'�Ѿ�����"+sameCount +"�Σ���鿴���մ�����Ϣ�� <br>";
  	  if(RecentCount>0&&RegistViewLimitDay>0){
  	    errorMessage = errorMessage+"�������"+RegistViewLimitDay+"���Ѿ�����"+RecentCount +"�Σ� <br>";
  	  }
    }else
  	{
  		fm.button_Peril_Open_Context.disabled = true;
  	}
  }
  
  if(payFee==-1){
    errorMessage=errorMessage+"�˱�������δ��,�����ش����� <br>";
   
  } else if(payFee==-2){
    errorMessage=errorMessage+"�˱����ѽ�δ��ȫ,�����ش������� <br>";
   
  }

  if (errorMessage.length>0) {
  	document.getElementById("span_message").style.display = "";
  	message.innerHTML=errorMessage;
  }else{
  	message.innerHTML=errorMessage;
  	document.getElementById("span_message").style.display = "none";
  }
  
  
  //add end
  return true;
}

//Modify By wangli remark begin 20050325
//reason: ͳһʹ��ClaimPub.js ��� openWinSave()����������ά��
/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinSave(){
   var businessNo = fm.prpLregistRegistNo.value;
   var policyNo = fm.prpLregistPolicyNo.value;
   var riskCode = fm.prpLregistRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=regis&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}
*/
/**
 *@description �����鿴���ԶԻ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 /*
function openWinQuery(){
  var win;
  var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
//Modify By wangli remark end 20050325

function noChange()
{
  fm.insureCarFlag[1].value=1;
  alert("�永�����ĵ�һ��������Ϊ��������");
  return true;
}


//Modify By wangli remark begin 20050325
//reason: ͳһʹ��ClaimPub.js ��� relate()����������ά��
//Modify By sunhao add begin 2004-09-06

/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 /*
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
//Modify By wangli remark begin 20050325
/**
 * ���ܣ���������չ��Ϣ��ɿɱ༭
 * return true/false
 */
function eidtRegistExt(tableId)
{
  var testStr = "" ;
   var elements = getTableElements(tableId);
   for(var i=0;i<elements.length;i++)
   {
    //alert(elements[i].tagName);
    if(elements[i].name=="prpLregistExtOperatorCode"||elements[i].name=="prpLregistExtContext")
    {
        tempElements = elements[i];
        //���������Ϊֻ��
        if(tempElements.type=="text"||tempElements.type=="hidden")
        {
  	    	tempElements.style.fontSize="9pt";
  	    	tempElements.style.borderTop = "#4196BF 1px solid";
  	    	tempElements.style.borderBottom = "#4196BF 1px solid";
  	    	tempElements.style.borderRight= "#4196BF 1px solid";
  	    	tempElements.style.borderLeft = "#4196BF 1px solid" ;
  	    	tempElements.style.width="100%";
  	    	//tempElements.style.width="80%";
  	    	//tempElements.style.color = "#000000";
  	    	tempElements.style.backgroundColor = "#ffffff";
          tempElements.readOnly=false;
        }
        //���������Ϊֻ��
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=false;
        }
    }
  }
}

//Add by chenrenda  begin 20050404
//Reason:����ԭ���¹�ԭ����ʹ��Ƶ��������
//����ԭ��仯�󴥷����¼�������ԭ������Ҳ���Ÿı�
function getDamageName(field)
{
  var list=field;
  fm.prpLregistDamageName.value = list.options[list.selectedIndex].text;
}

//�¹�ԭ��仯�󴥷����¼����¹�ԭ������Ҳ���Ÿı�
function getDamageTypeName(field)
{
  var list=field;
  fm.prpLregistDamageTypeName.value = list.options[list.selectedIndex].text;
}



/**
 @description �ı��⳥����ʱ��������Ӧ�ı����α���
 @param       ��
 @return      ��
 */
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
  for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
  {
    fm.prpLthirdPartyDutyPercent[i].value = indemnityDuty;
  }
}

//����ʱ���永������Ϣ�в���ʾ���永�������α���
function changeProperties()
{
  //getIndemnityDuty();
}


//���α����仯ʱ���ı��¹�����Ԥ��
function getIndemnityDuty()
{
  //��ȥ���õ��¹�����Ԥ��
  /*
  var indemnityDuty = 0;
  indemnityDuty = parseFloat(fm.prpLthirdPartyDutyPercent[1].value);

  if(isNaN(indemnityDuty)){
    indemnityDuty = 0;
  }
  if(indemnityDuty<=30&&indemnityDuty>0)
  {
    fm.indemnityDuty.value="3";
  }else if(indemnityDuty>30&&indemnityDuty<=50)
  {
    fm.indemnityDuty.value="2";
  }
  else if(indemnityDuty>50&&indemnityDuty<=70)
  {
    fm.indemnityDuty.value="1";
  }
  else if(indemnityDuty>70)
  {
    fm.indemnityDuty.value="0";
  }
  else
  {
     fm.indemnityDuty.value="4";
  }
  */
}

//�������¼�ʱ���Զ����ɳ���ժҪ
function generateRegistText()
{
  //�õ���ʻԱ��Ϣ
  var prplDriver = "";
  var prplRegistText = "";
  for( var i=1;i<fm.prpLdriverSerialNo.length;i++)
  {
    if(i==1)
    {
       prplDriver =  trim(fm.prpLdriverDriverName[i].value);
       break;
    }
  }
  //�õ���ĳ�����Ϣ
  var prplLicenseNo = "";
  for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
  {
    if(i==1)
    {
       prplLicenseNo =  trim(fm.prpLthirdPartyLicenseNo[i].value);
       break;
    }
  }
  //�õ�ʱ�䡢�ص㡢�¹�ԭ�򡢳���ԭ��
  var prpLregistDamageStartDate = trim(fm.prpLregistDamageStartDate.value);
  var prpLregistDamageStartHour = trim(fm.prpLregistDamageStartHour.value);
  var prpLregistDamageStartMinute = trim(fm.prpLregistDamageStartMinute.value);
  var prpLregistDamageAddress = trim(fm.prpLregistDamageAddress.value);
  var prpLregistDamageTypeName = trim(fm.prpLregistDamageTypeName.value);
  var prpLregistDamageName = trim(fm.prpLregistDamageName.value);

  var prplRegistText1 =    prpLregistDamageStartDate+"��"+prpLregistDamageStartHour+"Сʱ"+prpLregistDamageStartMinute+"��"
                         +prpLregistDamageAddress+"����"+prpLregistDamageTypeName+"����"+prpLregistDamageName+"�¹�,";

  //�õ���ĳ������߳���ʧ��Ϣ
  var count=getElementCount("prpLthirdPartySerialNo");   //��������
  var serialNoCount=getElementCount("RelateSerialNo");   //����λ������û������λΪ1
  var lossMessage1 = "";     //��ĳ���Ϣ
  var lossMessage2 = "";     //���߳���Ϣ
  var lossMessage3 = "";     //�ܵĳ���ժҪ
  var lossMessageTemp = "";  //��������λ��Ϣ

  for(var j=1;j<count;j++)  
  {
     if( serialNoCount==1 ){  //û������λ
    	    if( j<(count-1)  ) {  //��ȥ��ĳ�
    	       lossMessage2= lossMessage2 + fm.prpLthirdPartyLicenseNo[j+1].value +"����;"
          } 
     }
     else { //������λ
     	  lossMessageTemp ="" ;
   	 	  for (  var k =0 ;k< serialNoCount ;k++){ 
   	 	       if ( fm.RelateSerialNo[k].value =="1"  && j ==1 ){  //��ĳ�������λ
    	 	             lossMessage1 = lossMessage1 + fm.partName[k].value+ fm.compName[k].value+"��";
    	       } 
    	       else {  //���߳�
    	 	  	    if( fm.RelateSerialNo[k].value ==j   ){
    	 	  	        lossMessageTemp = lossMessageTemp + fm.partName[k].value+ fm.compName[k].value+"��"; 
    	 	  	    }
    	 	  	  }
    	 	  }//endfor
    	  if ( j > 1) {   //���߳� 
    	  	  var position2 = lossMessageTemp.lastIndexOf("��");
            lossMessageTemp =lossMessageTemp.substring(0,position2);
    	  	  lossMessage2 =  lossMessage2 + trim(fm.prpLthirdPartyLicenseNo[j].value) + lossMessageTemp +  "����;"; 
   	  	}
   	} //endelse
  } //endfor 

  var position1 = lossMessage1.lastIndexOf("��");
  lossMessage1 =lossMessage1.substring(0,position1);
  lossMessage3 = "���±�ĳ�"+prplLicenseNo+lossMessage1+"����;"+lossMessage2;

  //�õ���������Ϣ
  var HandleUnitName = "";
  HandleUnitName = trim(fm.prpLregistHandleUnitName.value);

  //�õ�������Ϣ(������ȷ,���ɹ�������Ժ���Ķ�)
  var personCount=getElementCount("prpLpersonTracePersonNo");
  var personMessage = "";
  var personMessageTemp = "";
  var kindName = "";
  for(var j=1;j<personCount;j++)
  {
    
    if(fm.prpLpersonTraceReferKind[j].value == "B"){
        kindName = "���������α���,";
    }else if(fm.prpLpersonTraceReferKind[j].value == "D3"){
        kindName = "������Ա�����գ�˾����λ,";
    }else if(fm.prpLpersonTraceReferKind[j].value == "D4"){
        kindName = "������Ա�����գ��˿���λ,";
    }else{
        kindName = fm.prpLpersonTraceReferKind[j].value;
    }
    
    personMessageTemp = fm.prpLpersonTracePersonName[j].value+"�漰����Ϊ:"+kindName+"���˲�λ:"+fm.prpLpersonTracePartDesc[j].value+";";
    personMessage = personMessage + personMessageTemp;
  }


  //�õ�������ʧ��Ϣ(������ȷ,���ɹ�������Ժ���Ķ�)
  var propCount=getElementCount("prpLthirdPropItemNo");
  var propMessage = "";
  var propMessageTemp = "";
  for(var j=1;j<propCount;j++)
  {
    propMessageTemp = fm.prpLthirdLossItemName[j].value+"����("+fm.prpLthirdPropLossDesc[j].value+");";
    propMessage = propMessage + propMessageTemp;
  }


  //ƴ���õ�����ժҪ
  prplRegistText = "     "+prplDriver+"��ʻ��ĳ�"+prplLicenseNo+"��"+prplRegistText1+lossMessage3+personMessage+propMessage
                          +HandleUnitName+"����";
  fm.prpLregistTextContextInnerHTML.value = prplRegistText;
  return true;
}

//Add by chenrenda  end 20050404

//add by qinyongli �鿴����ʱ������Ϣ,��ҵ��ϵͳ�н��б�����ԭ
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLregistPolicyNo.value;
     var RiskCode  =fm.prpLregistRiskCode.value;
     var damageDate=fm.prpLregistDamageStartDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
	 var vURL = "";
     vURL = CoreWebUrl +'/'+RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

function  submittime(){
  return true;
/*  
  var damageDay = fm.prpLregistDamageStartDate.value;
  var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
  var nowtoday= new Date();
  var interval_damage = (nowtoday.getTime()- damage.getTime())/(24*60*60*1000);
  alert(interval_damage);
  if(interval_damage>=0){
  	alert("�����ӿ�ʼʱ�䵽�ύʱ���ʱ������ʱ��ֻ�ܹ��ݴ棬�����ύ!");
	return false;
  }
*/  
}

//modify ���ĳ���ʱ������Ϣ  by qinyongli 2005-10-5
function flashPage(){	
    var damageDate = fm.prpLregistDamageStartDate.value;
    var damageHour = fm.prpLregistDamageStartHour.value;
    var damageMiunte = fm.prpLregistDamageStartMinute.value;
    var policyNo   = fm.quaryPolicyNo.value;
    var vURL='/claim/registBeforeEdit.do?FlashPage=Y&prpCmainPolicyNo='+policyNo+'&editType=ADD&damageDate='
            +damageDate+'&damageHour='+damageHour+'&modifyDamageDate=true&damageMinute=' + damageMiunte;
    var oldAction = "/claim/registSave.do";
    var oldReportName = fm.prpLregistReportorName.value;
    var oldTarget = fm.target;
    //Ϊ��viewtodto��������
    fm.prpLthirdPartyLicenseNo[1].disabled = false;
    fm.prpLthirdPartyBrandName[1].disabled = false;
    fm.carKindCode[1].disabled = false;
    fm.licenseColorCode[1].disabled = false;
    fm.action=vURL;

    fm.target="fraSubmit"
    fm.submit();

    fm.action=oldAction;
    fm.target=oldTarget;  
    return true;  
}






 function confirmOverTime() {
        var date1 = fm.prpLregistDamageStartDate.value;
        var date2 = fm.prpLregistReportDate.value;
        
        var hour1 = parseInt(fm.prpLregistReportHour.value,10);
        var hour2 = parseInt(fm.prpLregistDamageStartHour.value,10);
        
        
        var strValue1 = date1.split(DATE_DELIMITER);
        var strValue2 = date2.split(DATE_DELIMITER);
        var msg = "";
        var sum = (parseInt(strValue2[2],10) - parseInt(strValue1[2],10))*24 + (hour1-hour2);
        if ((parseInt(strValue2[0],10) - parseInt(strValue1[0],10)) >= 1) {         
           return false;
        } else if ((parseInt(strValue2[1],10) - parseInt(strValue1[1],10)) >= 1) {
         
           return false;
        } else if (sum >= 48) {
          
            return false;
        }
        else {
          
           return true;
        }
 }
function showMaterialInfo(proposalNo){
  var UNDWRT_URL=fm.UNDWRT_URL.value;//˫��ϵͳ��URL��ַ
  var UNDWRT_HOST=fm.UNDWRT_HOST.value;//˫��ϵͳ��Host�˿� 
  var submitStr="http://"+UNDWRT_URL+":"+UNDWRT_HOST+"/undwrt/materialInfo.do?BusinessNo=" + proposalNo;
  window.open(submitStr,'������Ϣ','width=640,height=300,top=50,left=80,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
} 
  