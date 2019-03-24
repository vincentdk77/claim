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
  fm.buttonSaveType.value = saveType;
   
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
 
 if(!validateForm(fm,'Prop_Data'))
  { 
    return false; 
  }
  
var addNewRepairCompentRow=-1;//默认没有增加一条记录数据
var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //理算退回的标记
 for(i=1;i<fm.prpLpropSerialNo.length;i++)
     {
      if (fm.prpLpropCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
       
  }
  
  //如果是理算回退的，并且没有增加新行的话，那么可以直接提交到理算 
  if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";
  
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