/*****************************************************************************
 * DESC       ��������ģ��Ľű�����ҳ��
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-10
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
  
   
    return validateForm(window.fm,"WorkFlowNode_Data,WorkFlowPath_Data");
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
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
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
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{
  fm.buttonThirdPartyDelete[1].disabled = true;
  fm.prpLthirdPartyLicenseNo[1].disabled = true; 
  return true;
}