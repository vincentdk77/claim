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
  fm.buttonSaveType.value = saveType;
  
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'Prop_Data')) 
  {
    return false;
  }

  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}
