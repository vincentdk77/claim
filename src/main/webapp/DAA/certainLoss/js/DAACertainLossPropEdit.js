/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
 
 
 	  
function saveForm(field,saveType)
{ 
	if( null != fm.prpLverifyLossRiskCode && "ZH03" == fm.prpLverifyLossRiskCode.value){
	  var count;
	  count = getElementCount("prpLpropKindCode");
	  if (count == 1)
	  {
		  alert("���ձ���Ϣ¼�룡");
		  return false;
	  }
	  var i = 0;
	  var findex=0;
	  for(i=1;i<fm.all("prpLpropKindCode").length;i++)
	  {
		   if("" == fm.prpLpropKindCode[i].value)
		   {
			   alert("��ѡ���ձ�");
			   return false;
		   }
			   
		   else if( fm.prpLpropKindCode[i].value.indexOf("2742") == 0)
		     {
			   if("" == fm.prpLpropFamilyName[i].value)
			   {
				   alert("��ѡ���¹������ƣ�");
				   return false;
			   }
		        
		     }
	  }
      var KindCodes = document.getElementsByName("prpLpropKindCode");
      var FamilyNames = document.getElementsByName("prpLpropFamilyName");
      var ItemCodes = document.getElementsByName("prpLpropItemCode");
      for(var index =0 ;index < count ; index++)
      {
	      if (index ==0) continue;
	      var i =index;
	      i++;
	      if(KindCodes[index].value.indexOf("2742") == 0) continue;
	      while(i < count)
	      {
		      if(KindCodes[index].value == KindCodes[i].value && ItemCodes[index].value == ItemCodes[i].value)
		      {
			    	alert("��ͥ�Ʋ��գ��ձ���Ϣ+������Ŀ�����ظ���");
			      	return false;
	      		}
	      	 i++;
	      }
      }
      for(var index =0 ;index < count ; index++)
      {
	      if (index ==0) continue;
	      var i =index;
	      i++;
	      if(KindCodes[index].value.indexOf("2742") != 0) continue;
	      while(i < count)
	      {
		      if(KindCodes[index].value == KindCodes[i].value && FamilyNames[index].value == FamilyNames[i].value)
		      {
		    	alert("���������˺��գ��ձ���Ϣ+�¹������Ʋ����ظ���");
		      	return false;
	      	}
	      	 i++;
	      }
      }
  }
  if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
	{
		var bool = checkEarBeforeSave();
		if ( bool != true) return false;
	}
  fm.buttonSaveType.value = saveType;
   
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(fm.prpLverifyLossLossesNumber != null && fm.prpLverifyLossLossesNumber.value <= 0){
        alert("�⸶��������С�ڻ����0");
        fm.prpLverifyLossLossesNumber.focus();
        fm.prpLverifyLossLossesNumber.select();
        return false;
  }
  if( null != fm.prpLverifyLossRiskCode && "3226" != fm.prpLverifyLossRiskCode.value){
	  if(fm.prpLverifyLossDamageInsured != null && fm.prpLverifyLossDamageInsured.value <= 0){
	        alert("���ջ��β���С�ڻ����0");
	        fm.prpLverifyLossDamageInsured.focus();
	        fm.prpLverifyLossDamageInsured.select();
	        return false;
	  }
  }
  if(fm.prpLverifyLossDisasterArea != null && fm.prpLverifyLossDisasterArea.value <= 0){
        alert("�����������С�ڻ����0");
        fm.prpLverifyLossDisasterArea.focus();
        fm.prpLverifyLossDisasterArea.select();
        return false;
  }
  if(fm.prpLverifyLossAffectedArea != null && fm.prpLverifyLossAffectedArea.value <= 0){
        alert("�����������С�ڻ����0");
        fm.prpLverifyLossAffectedArea.focus();
        fm.prpLverifyLossAffectedArea.select();
        return false;
  }
  
 if(!validateForm(fm,'Prop_Data'))
  { 
    return false; 
  }
  
var addNewRepairCompentRow=-1;//Ĭ��û������һ����¼����
//var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //�����˻صı��
// for(i=1;i<fm.prpLpropSerialNo.length;i++)
//     {
//      if (fm.prpLpropCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
       
//  }
  
  //�����������˵ģ�����û���������еĻ�����ô����ֱ���ύ������ 
//  if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";
  
   var riskcode = fm.prpLverifyLossRiskCode.value;
  
    if(riskcode == "0310"||riskcode == "0312")
  {
     var count = getElementCount("prplCompensateHouseIDcard");
     var ids = document.getElementsByName("prplCompensateHouseIDcard");
     var inprocess = document.getElementsByName("prplCompensateHouseInprocess");
     if(count ==1)
     {
        alert("���ѯ����ũ�����֤��Ϣ!");
        return false;
     
     }
     for(var index =0 ;index < count ; index++)
	 	{
	 	 if (index ==0) continue;

	 		//if(trim(inprocess[index].value) == "Y")
		 	 //{
		 	 	//alert("�������ڽ��д���Ķ���ţ������ύ��");
		 	 	//return false;
		 	 //}



	 	 var i =index;
	 	 i++;
	 	 while(i < count)
	 	 {
	 	  if(ids[index].value == ids[i].value)
	 	  {
	 	  alert("���֤�Ų����ظ�");
	 	  	return false;
	 	 	}
	 	 	 i++;
	 	 }
	 	 
	 	}
     
     // 0310����¼��Ʋ���ʧ�嵥�����ύ
     if(fm.prpLpropKindCode[1].value == '' || fm.prpLpropKindCode[1].value == null) {
	   	  alert("0310/0312 ũ��ס�����գ�����¼�롾�Ʋ���ʧ�嵥��Ϣ�������ύ��");
	   	  //fm.prpLpropKindCode[1].focus();
	      return false;
       }
     
     
  }
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  fm.submit(); 
  //return true;   	
}

function saveFormNew(field,saveType)
{
  var riskcodeStr = fm.riskcodeStr.value;
  var riskcode = fm.riskcode.value;
  if(riskcodeStr.indexOf(riskcode) >0 && (saveType=="4" || saveType=="5") ){
	  var prpLverifyLossExtContext = fm.prpLverifyLossExtContext;
	  var length = prpLverifyLossExtContext.length;
	  if(prpLverifyLossExtContext[length-1].value==""){
		  alert("������������ݲ���Ϊ��!");
		  fm.prpLverifyLossExtContext[length-1].focus();
		  return false;
	  }
	  if(saveType=="5"){
		  if(fm.verifyOpinion.value == "01"){
			  alert('�����˻صĺ����������Ϊ"ͬ�ⶨ��"!');
			  return false;
		  }
	  }
	  if(saveType=="4"){
		  if(fm.verifyOpinion.value != "01"){
			  alert('�����ύ�ĺ����������ȷ!');
			  return false;
		  }
	  }
  }
  if( null != fm.prpLverifyLossRiskCode && "ZH03" == fm.prpLverifyLossRiskCode.value){
  var count;
  count = getElementCount("prpLpropKindCode");
  if (count == 1)
  {
	  alert("���ձ���Ϣ¼�룡");
	  return false;
  }
  var i = 0;
  var findex=0;
  for(i=1;i<fm.all("prpLpropKindCode").length;i++)
  {
	   if("" == fm.prpLpropKindCode[i].value)
	   {
		   alert("��ѡ���ձ�");
		   return false;
	   }
		   
	   else if( fm.prpLpropKindCode[i].value.indexOf("2742") == 0)
	     {
		   if("" == fm.prpLpropFamilyName[i].value)
		   {
			   alert("��ѡ���¹������ƣ�");
			   return false;
		   }
	        
	     }
  }
  var KindCodes = document.getElementsByName("prpLpropKindCode");
  var FamilyNames = document.getElementsByName("prpLpropFamilyName");
  var ItemCodes = document.getElementsByName("prpLpropItemCode");
  for(var index =0 ;index < count ; index++)
  {
      if (index ==0) continue;
      var i =index;
      i++;
      if(KindCodes[index].value.indexOf("2742") == 0) continue;
      while(i < count)
      {
	      if(KindCodes[index].value == KindCodes[i].value && ItemCodes[index].value == ItemCodes[i].value)
	      {
		    	alert("��ͥ�Ʋ��գ��ձ���Ϣ+������Ŀ�����ظ���");
		      	return false;
      		}
      	 i++;
      }
  }
  for(var index =0 ;index < count ; index++)
  {
      if (index ==0) continue;
      var i =index;
      i++;
      if(KindCodes[index].value.indexOf("2742") != 0) continue;
      while(i < count)
      {
	      if(KindCodes[index].value == KindCodes[i].value && FamilyNames[index].value == FamilyNames[i].value)
	      {
	    	alert("���������˺��գ��ձ���Ϣ+�¹������Ʋ����ظ���");
	      	return false;
      	}
      	 i++;
      }
  }
}
if(null != fm.familySplittingFlag && fm.familySplittingFlag.value == "true")
{
	var bool = checkEarBeforeSave();
	if ( bool != true) return false;
}
fm.buttonSaveType.value = saveType;

//reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
if(fm.prpLverifyLossLossesNumber != null && fm.prpLverifyLossLossesNumber.value <= 0){
    alert("�⸶��������С�ڻ����0");
    fm.prpLverifyLossLossesNumber.focus();
    fm.prpLverifyLossLossesNumber.select();
    return false;
}
if( null != fm.prpLverifyLossRiskCode && "3226" != fm.prpLverifyLossRiskCode.value){
  if(fm.prpLverifyLossDamageInsured != null && fm.prpLverifyLossDamageInsured.value <= 0){
        alert("���ջ��β���С�ڻ����0");
        fm.prpLverifyLossDamageInsured.focus();
        fm.prpLverifyLossDamageInsured.select();
        return false;
  }
}
if(fm.prpLverifyLossDisasterArea != null && fm.prpLverifyLossDisasterArea.value <= 0){
    alert("�����������С�ڻ����0");
    fm.prpLverifyLossDisasterArea.focus();
    fm.prpLverifyLossDisasterArea.select();
    return false;
}
if(fm.prpLverifyLossAffectedArea != null && fm.prpLverifyLossAffectedArea.value <= 0){
    alert("�����������С�ڻ����0");
    fm.prpLverifyLossAffectedArea.focus();
    fm.prpLverifyLossAffectedArea.select();
    return false;
}

if(!validateForm(fm,'Prop_Data'))
{ 
return false; 
}

var addNewRepairCompentRow=-1;//Ĭ��û������һ����¼����
//var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //�����˻صı��
//for(i=1;i<fm.prpLpropSerialNo.length;i++)
// {
//  if (fm.prpLpropCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
   
//}

//�����������˵ģ�����û���������еĻ�����ô����ֱ���ύ������ 
//if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";

var riskcode = fm.prpLverifyLossRiskCode.value;

if(riskcode == "0310"||riskcode == "0312")
{
 var count = getElementCount("prplCompensateHouseIDcard");
 var ids = document.getElementsByName("prplCompensateHouseIDcard");
 var inprocess = document.getElementsByName("prplCompensateHouseInprocess");
 if(count ==1)
 {
    alert("���ѯ����ũ�����֤��Ϣ!");
    return false;
 
 }
 for(var index =0 ;index < count ; index++)
 	{
 	 if (index ==0) continue;

 		//if(trim(inprocess[index].value) == "Y")
	 	 //{
	 	 	//alert("�������ڽ��д���Ķ���ţ������ύ��");
	 	 	//return false;
	 	 //}



 	 var i =index;
 	 i++;
 	 while(i < count)
 	 {
 	  if(ids[index].value == ids[i].value)
 	  {
 	  alert("���֤�Ų����ظ�");
 	  	return false;
 	 	}
 	 	 i++;
 	 }
 	 
 	}
 
 // 0310����¼��Ʋ���ʧ�嵥�����ύ
 if(fm.prpLpropKindCode[1].value == '' || fm.prpLpropKindCode[1].value == null) {
   	  alert("0310/0312 ũ��ס�����գ�����¼�롾�Ʋ���ʧ�嵥��Ϣ�������ύ��");
   	  //fm.prpLpropKindCode[1].focus();
      return false;
   }
 
 
}
//reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
field.disabled = true;
fm.submit(); 
//return true;   	
}
function getSumPropDefLoss(field)
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var propSumLoss;
  var propSumReject;
  var propSumDefLoss;


  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
 
    propSumLoss= parseFloat(fm.all("prpLpropSumLoss")[findex].value);
    propSumReject  = parseFloat(fm.all("prpLpropSumReject")[findex].value)      

	
    if(isNaN(propSumLoss)||propSumLoss.length<1){
      propSumLoss = 0;
    }
    if(isNaN(propSumReject)||propSumReject.length<1) {
      propSumReject = 0;
    }
    propSumDefLoss = propSumLoss-propSumReject;
    fm.all("prpLpropSumDefLoss")[findex].value = point(round(propSumDefLoss ,2),2);
    return true;  
       
}