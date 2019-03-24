/*****************************************************************************
 * DESC       ：人员列表增加JS
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-08-01
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
 
 
 	  
function saveForm(field,saveType)
{ 
	if( null != fm.prpLverifyLossRiskCode && "ZH03" == fm.prpLverifyLossRiskCode.value){
	  var count;
	  count = getElementCount("prpLpropKindCode");
	  if (count == 1)
	  {
		  alert("无险别信息录入！");
		  return false;
	  }
	  var i = 0;
	  var findex=0;
	  for(i=1;i<fm.all("prpLpropKindCode").length;i++)
	  {
		   if("" == fm.prpLpropKindCode[i].value)
		   {
			   alert("请选择险别！");
			   return false;
		   }
			   
		   else if( fm.prpLpropKindCode[i].value.indexOf("2742") == 0)
		     {
			   if("" == fm.prpLpropFamilyName[i].value)
			   {
				   alert("请选择事故者名称！");
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
			    	alert("家庭财产险：险别信息+保险项目不能重复！");
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
		    	alert("人身意外伤害险：险别信息+事故者名称不能重复！");
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
   
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(fm.prpLverifyLossLossesNumber != null && fm.prpLverifyLossLossesNumber.value <= 0){
        alert("赔付数量不能小于或等于0");
        fm.prpLverifyLossLossesNumber.focus();
        fm.prpLverifyLossLossesNumber.select();
        return false;
  }
  if( null != fm.prpLverifyLossRiskCode && "3226" != fm.prpLverifyLossRiskCode.value){
	  if(fm.prpLverifyLossDamageInsured != null && fm.prpLverifyLossDamageInsured.value <= 0){
	        alert("出险户次不能小于或等于0");
	        fm.prpLverifyLossDamageInsured.focus();
	        fm.prpLverifyLossDamageInsured.select();
	        return false;
	  }
  }
  if(fm.prpLverifyLossDisasterArea != null && fm.prpLverifyLossDisasterArea.value <= 0){
        alert("受灾面积不能小于或等于0");
        fm.prpLverifyLossDisasterArea.focus();
        fm.prpLverifyLossDisasterArea.select();
        return false;
  }
  if(fm.prpLverifyLossAffectedArea != null && fm.prpLverifyLossAffectedArea.value <= 0){
        alert("成灾面积不能小于或等于0");
        fm.prpLverifyLossAffectedArea.focus();
        fm.prpLverifyLossAffectedArea.select();
        return false;
  }
  
 if(!validateForm(fm,'Prop_Data'))
  { 
    return false; 
  }
  
var addNewRepairCompentRow=-1;//默认没有增加一条记录数据
//var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //理算退回的标记
// for(i=1;i<fm.prpLpropSerialNo.length;i++)
//     {
//      if (fm.prpLpropCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
       
//  }
  
  //如果是理算回退的，并且没有增加新行的话，那么可以直接提交到理算 
//  if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";
  
   var riskcode = fm.prpLverifyLossRiskCode.value;
  
    if(riskcode == "0310"||riskcode == "0312")
  {
     var count = getElementCount("prplCompensateHouseIDcard");
     var ids = document.getElementsByName("prplCompensateHouseIDcard");
     var inprocess = document.getElementsByName("prplCompensateHouseInprocess");
     if(count ==1)
     {
        alert("请查询输入农户身份证信息!");
        return false;
     
     }
     for(var index =0 ;index < count ; index++)
	 	{
	 	 if (index ==0) continue;

	 		//if(trim(inprocess[index].value) == "Y")
		 	 //{
		 	 	//alert("包含正在进行处理的耳标号，不能提交！");
		 	 	//return false;
		 	 //}



	 	 var i =index;
	 	 i++;
	 	 while(i < count)
	 	 {
	 	  if(ids[index].value == ids[i].value)
	 	  {
	 	  alert("身份证号不可重复");
	 	  	return false;
	 	 	}
	 	 	 i++;
	 	 }
	 	 
	 	}
     
     // 0310必须录入财产损失清单才能提交
     if(fm.prpLpropKindCode[1].value == '' || fm.prpLpropKindCode[1].value == null) {
	   	  alert("0310/0312 农村住房保险，必须录入【财产损失清单信息】才能提交。");
	   	  //fm.prpLpropKindCode[1].focus();
	      return false;
       }
     
     
  }
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
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
		  alert("定核损意见内容不能为空!");
		  fm.prpLverifyLossExtContext[length-1].focus();
		  return false;
	  }
	  if(saveType=="5"){
		  if(fm.verifyOpinion.value == "01"){
			  alert('核损退回的核损意见不能为"同意定损"!');
			  return false;
		  }
	  }
	  if(saveType=="4"){
		  if(fm.verifyOpinion.value != "01"){
			  alert('核损提交的核损意见不正确!');
			  return false;
		  }
	  }
  }
  if( null != fm.prpLverifyLossRiskCode && "ZH03" == fm.prpLverifyLossRiskCode.value){
  var count;
  count = getElementCount("prpLpropKindCode");
  if (count == 1)
  {
	  alert("无险别信息录入！");
	  return false;
  }
  var i = 0;
  var findex=0;
  for(i=1;i<fm.all("prpLpropKindCode").length;i++)
  {
	   if("" == fm.prpLpropKindCode[i].value)
	   {
		   alert("请选择险别！");
		   return false;
	   }
		   
	   else if( fm.prpLpropKindCode[i].value.indexOf("2742") == 0)
	     {
		   if("" == fm.prpLpropFamilyName[i].value)
		   {
			   alert("请选择事故者名称！");
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
		    	alert("家庭财产险：险别信息+保险项目不能重复！");
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
	    	alert("人身意外伤害险：险别信息+事故者名称不能重复！");
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

//reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
if(fm.prpLverifyLossLossesNumber != null && fm.prpLverifyLossLossesNumber.value <= 0){
    alert("赔付数量不能小于或等于0");
    fm.prpLverifyLossLossesNumber.focus();
    fm.prpLverifyLossLossesNumber.select();
    return false;
}
if( null != fm.prpLverifyLossRiskCode && "3226" != fm.prpLverifyLossRiskCode.value){
  if(fm.prpLverifyLossDamageInsured != null && fm.prpLverifyLossDamageInsured.value <= 0){
        alert("出险户次不能小于或等于0");
        fm.prpLverifyLossDamageInsured.focus();
        fm.prpLverifyLossDamageInsured.select();
        return false;
  }
}
if(fm.prpLverifyLossDisasterArea != null && fm.prpLverifyLossDisasterArea.value <= 0){
    alert("受灾面积不能小于或等于0");
    fm.prpLverifyLossDisasterArea.focus();
    fm.prpLverifyLossDisasterArea.select();
    return false;
}
if(fm.prpLverifyLossAffectedArea != null && fm.prpLverifyLossAffectedArea.value <= 0){
    alert("成灾面积不能小于或等于0");
    fm.prpLverifyLossAffectedArea.focus();
    fm.prpLverifyLossAffectedArea.select();
    return false;
}

if(!validateForm(fm,'Prop_Data'))
{ 
return false; 
}

var addNewRepairCompentRow=-1;//默认没有增加一条记录数据
//var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //理算退回的标记
//for(i=1;i<fm.prpLpropSerialNo.length;i++)
// {
//  if (fm.prpLpropCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
   
//}

//如果是理算回退的，并且没有增加新行的话，那么可以直接提交到理算 
//if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";

var riskcode = fm.prpLverifyLossRiskCode.value;

if(riskcode == "0310"||riskcode == "0312")
{
 var count = getElementCount("prplCompensateHouseIDcard");
 var ids = document.getElementsByName("prplCompensateHouseIDcard");
 var inprocess = document.getElementsByName("prplCompensateHouseInprocess");
 if(count ==1)
 {
    alert("请查询输入农户身份证信息!");
    return false;
 
 }
 for(var index =0 ;index < count ; index++)
 	{
 	 if (index ==0) continue;

 		//if(trim(inprocess[index].value) == "Y")
	 	 //{
	 	 	//alert("包含正在进行处理的耳标号，不能提交！");
	 	 	//return false;
	 	 //}



 	 var i =index;
 	 i++;
 	 while(i < count)
 	 {
 	  if(ids[index].value == ids[i].value)
 	  {
 	  alert("身份证号不可重复");
 	  	return false;
 	 	}
 	 	 i++;
 	 }
 	 
 	}
 
 // 0310必须录入财产损失清单才能提交
 if(fm.prpLpropKindCode[1].value == '' || fm.prpLpropKindCode[1].value == null) {
   	  alert("0310/0312 农村住房保险，必须录入【财产损失清单信息】才能提交。");
   	  //fm.prpLpropKindCode[1].focus();
      return false;
   }
 
 
}
//reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
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