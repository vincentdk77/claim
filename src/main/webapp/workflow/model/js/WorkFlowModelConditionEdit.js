/*****************************************************************************
 * DESC       ��������ģ��Ľű�����ҳ��
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-22
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ����������
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
  
   
    return validateForm(window.fm,"WorkFlowCondition_Data");
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
 * ����һ���µ�swfCondition֮��Ĵ�����ѡ������
 */
 function afterInsertWorkFlowCondition()
 {

   setSwfConditionConditionNo();
 }

 /*
   ɾ������wfCondition֮��Ĵ�����ѡ������
 */
 function afterDeleteWorkFlowCondition(field)
 {

   setSwfConditionConditionNo();
 }

   /**
    * ����setWfConditionConditionNo
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
   
