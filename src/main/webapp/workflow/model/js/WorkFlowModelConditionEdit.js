/*****************************************************************************
 * DESC       ：工作流模板的脚本函数页面
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-08-22
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 检查界面输入
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{
  
   
    return validateForm(window.fm,"WorkFlowCondition_Data");
}


/**
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
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
 *@description 重置
 *@param       无
 *@return      通过返回true,否则返回false
 */
function resetForm()
{
  if(window.confirm("确定要重置吗？"))
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
 * 插入一条新的swfCondition之后的处理（可选方法）
 */
 function afterInsertWorkFlowCondition()
 {

   setSwfConditionConditionNo();
 }

 /*
   删除本条wfCondition之后的处理（可选方法）
 */
 function afterDeleteWorkFlowCondition(field)
 {

   setSwfConditionConditionNo();
 }

   /**
    * 设置setWfConditionConditionNo
    */
   function setSwfConditionConditionNo(){
       var count=getElementCount("swfConditionConditionNo");
       for(var i=0;i<count;i++)
       {
           if(count!=1){
               fm.swfConditionConditionNo[i].value=i;
           }
       }
   }
   
