/*****************************************************************************
 * DESC       ���᰸�ǼǵĽű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-06-28
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ���᰸�Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
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
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
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
 *@description ���ݰ�ť״̬����᰸����
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{     
   if(!confirm("�᰸�������޸ġ�\nȷ���᰸��"))
    return false;
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //fm.action = "/claim/endcaseSave.do?step=step1";
  //textarea�ı�������ֵ
  /*var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "�᰸���治����Ϊ��\n";
  } */     
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  //�����ֶ��᰸���ڽ᰸���ڸ�ʽ��У��
  //if(!validateForm(fm))
  //{ 
    //return false;
  //}
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  
  var planFeeFlag = fm.planFeeFlag.value;
  if(planFeeFlag  == '-1'){
  		if(!confirm("����δʵ����ȷ���᰸��"))
  			return;
  }
  else if(planFeeFlag == '-2'){
  		if(!confirm("����δ��ȫ��ȷ���᰸��"))
  			return;
  }
  field.disabled = true;
  
  fm.submit();
  
  return true;     
}

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave1(){
  var businessNo = fm.prpLclaimRegistNo.value;
  var policyNo = fm.prpLclaimPolicyNo.value;
  var claimNo = fm.prpLendcaseClaimNo1.value;
  var registNo = fm.prpLclaimRegistNo.value;
  msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=endca&policyNo=" +policyNo+ "&claimNo=" +claimNo+ "&registNo=" +registNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function openWinSave1Query(){
  var businessNo = fm.prpLclaimRegistNo.value;
  var policyNo = fm.prpLclaimPolicyNo.value;
  var claimNo = fm.prpLendcaseClaimNo1.value;
  var registNo = fm.prpLclaimRegistNo.value;
  msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=endca&policyNo=" +policyNo+ "&claimNo=" +claimNo+ "&registNo=" +registNo+"&registNo="+ fm.prpLclaimRegistNo.value,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=800,Height=700");
}
/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 

function openWinQuery(){
  var win;
  var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLclaimRegistNo.value;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}

/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){
  var policyNo = fm.prpLclaimPolicyNo.value;
  var registNo = fm.prpLclaimRegistNo.value;
  var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //newWindow.focus = true; 
}