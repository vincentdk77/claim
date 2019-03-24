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
  disabledAllButton('buttonArea');
  fm.buttonSaveType.value = saveType;
  
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  
  var count=getElementCount("registNoShow");
  for(var i=0;i<count;i++){
	  initCombineMulLineFields('Prop_'+i+'_Data');
	  initCombineMulLineFields('Ear_'+i+'_Data');
  } 
  if(!(validateCombineRequired(fm) && validateCombineType(fm))){
	  enableAllButton('buttonArea');
	  return false;
  }
  var bool = checkEarBeforeSave();
	if ( bool != true) 
	{
		enableAllButton('buttonArea');
		return false;	
	}
  fm.submit(); 
  return true;   	
}


function getSumPropDefLoss(field)
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var propSumLoss=0;
  var propSumReject=0;
  var propSumDefLoss=0;

  var charSplit = "_";
  var strValue = fieldname.split(charSplit);
  var index  = strValue[1];
  
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
 
    propSumLoss= parseFloat(fm.all("prpLpropSumLoss_"+index)[findex].value);
    propSumReject  = parseFloat(fm.all("prpLpropSumReject_"+index)[findex].value)      

	
    if(isNaN(propSumLoss)||propSumLoss.length<1){
      propSumLoss = 0;
    }
    if(isNaN(propSumReject)||propSumReject.length<1) {
      propSumReject = 0;
    }
    propSumDefLoss = propSumLoss-propSumReject;
    fm.all("prpLpropSumDefLoss_"+index)[findex].value = point(round(propSumDefLoss ,2),2);
    return true;  
       
}