/*****************************************************************************
 * DESC       �����ȵǼǵĽű�����ҳ��
 * AUTHOR     ��lixiang	 
 * CREATEDATE �� 2004-07-26
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


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
  
  fm.buttonSaveFinish.disabled = true;
  fm.buttonSaveFinishSubmit.disabled = true;
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
  return true;
}

/**
 *@description ���ݰ�ť״̬�����������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field)
{
  //copy the selectSend��־
  
  if(!validateForm(fm))
  {
  	return false;
  }
  
  //����������
  
  if (!checkscheduleForm(fm))
  {
  	return false;
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  //modify by weishixin add end 20040616
  fm.submit();
  
  return true;   	
}
/**
 *@description ����������
 *@param       this
 *@param       ���״̬
 *@return      ͨ������true,���򷵻�false
 */
function checkscheduleForm(field)
{
  var saveType=fm.saveType.value; //��ȡ�ػ���ֱ�ӵ���

  	//�жϵ��ȶ���͵������Ƶ�
  	
  	if (((fm.prpLscheduleMainWFScheduleObjectID.value).toString().length)<1)
    {
    	
      errorMessage("�鿱����λ���벻��Ϊ��!");
      fm.prpLscheduleMainWFScheduleObjectID.focus();
      return false;
    }
    
    if (((fm.prpLscheduleMainWFScheduleObjectName.value).toString().length)<1)
    {
    	
      errorMessage("�鿱����λ���Ʋ���Ϊ��!");
      fm.prpLscheduleMainWFScheduleObjectName.focus();
      return false;
    }
    
    //�жϲ鿱��ַ
    /*
    if (((fm.prpLscheduleMainWFCheckSite.value).toString().length)<1)
    {
    	
      errorMessage("�鿱��ַ����Ϊ��!");
      fm.prpLscheduleMainWFCheckSite.focus();
      return false;
    }
    */
    //�жϵ�����Ϣ
/*    
    if (((fm.prpLscheduleMainWFCheckInfo.value).toString().length)<1)
    {
      errorMessage("������Ϣ����Ϊ��!");
      fm.prpLscheduleMainWFCheckInfo.focus();
      return false;
    } 
*/    
    
    //�������ȡ�صķ�ʽ������Ҫ�ж��ǲ���ѡ������һ���ڵ��ϵ���Ϣ
    if (saveType=="schedule")
    {
    if (((fm.nextNodeNo.value).toString().length)<1)
  	{
  		errorMessage("�ύ����һ���ڵ���Ϣ����Ϊ��!");
  		return false;
  	}
  	
  	if (((fm.nextHandlerCode.value).toString().length)<1)
  	{
  		errorMessage("�ύ����һ������Ϣ����Ϊ��!");
  		return false;
  	}
  }
   	return  true;
 }
/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave(){
   
   var businessNo = fm.prpLscheduleMainWFRegistNo.value;
   var policyNo = fm.prpLscheduleMainWFPolicyNo.value;
   var riskCode = fm.prpLscheduleMainWFRiskCode.value;
  
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=sched&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLscheduleMainWFRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}

