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
 *@description ������⸶����Ƿ�Ϊ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checksumPaid()
{
  if(fm.SumPaid.value>=0){
    return true;
  }else{
    alert("����ܽ���Ϊ��ֵ��");
    return false;
  }
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
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet() 
{  
  return true;
}
/**
 *@description ���ݰ�ť״̬����᰸����
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{   
   if(fm.RiskCode.value=="0507"||fm.RiskCode.value=="0506"){
   if(checksumPaid()==false)
  {
    return false;
  }
  }
	
   if(!confirm("�᰸�������޸ġ�\nȷ���᰸��"))
    return false;
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;  
  //fm.action = "/claim/endcaseSave.do?step=step1";
  //textarea�ı�������ֵ
 /* var context = fm.prpLltextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "�᰸���治����Ϊ��\n";
  } */     
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  }
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  /*if(!validateForm(fm))
  {
    return false;
  }*/
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  fm.submit();
  
  return true;     
}
//modify by wangli remark start 20050409
/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinSave(){
  var businessNo = fm.prpLclaimRegistNo.value;
  var policyNo = fm.prpLclaimPolicyNo.value;
  var claimNo = fm.prpLendcaseClaimNo1.value;
  var registNo = fm.prpLclaimRegistNo.value;
  msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=endca&policyNo=" +policyNo+ "&claimNo=" +claimNo+ "&registNo=" +registNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
} 
*/
/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinQuery(){
  var win;
  var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLclaimRegistNo.value;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
//modify by wangli remark end 20050409
//modify by wangli update start 20050409
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function relate2(){
  var policyNo = fm.prpLclaimPolicyNo.value;
  var registNo = fm.prpLclaimRegistNo.value;
  var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //newWindow.focus = true;  
}
//modify by lym 20060307 start-----------------------------------------------------------------------
//�᰸�м����顢��ҳ��ӡ����չʾ�б�
function relate3(printType){//��ӡ�������顢��ҳʱ����ҳ��
  var claimNo = fm.prpLendcaseClaimNo1.value;
  var newWindow = window.open("/claim/compensateQuery.do?ClaimNo=" +claimNo+"&editType=PRINT&PrintType="+printType,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
/*
function relate3(printType){//��ӡ�������顢��ҳʱ����ҳ��
  var compensateNo = fm.prpLendcasecompensateNo.value;
  var newWindow = window.open("/claim/DAA/endcase/DAARelatePrint.jsp?compensateNo=" +compensateNo+"&printType="+printType,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}*/
//modify by lym 20060307 end--------------------------------------------------------------------------------
//modify by wangli update end 20050409


//modify by zhaozhuo add 20050406 start
//reason: ������ͬ��ӡҳ��
function printForm(filed,type){
  var registNo = fm.prpLclaimRegistNo.value;
  var claimNo =fm.prpLclaimClaimNo.value;
  var policyNo=fm.prpLclaimPolicyNo.value;
  var preCompensateNo=fm.prpLendcasepreCompensateNo.value;
  var compensateNo=fm.prpLendcasecompensateNo.value;

  if(type=="Regist"){ //1.�����������ձ�����¼����������
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&RegistNo="+registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  //if(type=="Pilfer"){//2.���գ�������֤��
  //var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //return newWindow;
  //}
  if(type=="Cancelnotice"){//3.����֪ͨ�� 
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="HistoryFile"){//4.ԭʼ����������ʱ����
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&PolicyNo="+policyNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="FileOnRisk"){//5.����ʱ����
  var endDate = "";
  var endDateHour = "";
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&PolicyNo="+policyNo+"&EndDate=" + endDate +"&EndDateHour=" + endDateHour,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Canceltrans"){//6.���ⰸ��������
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="LossSimple"){//7.��ʧ�������ȷ����
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Loss"){//8.��ʧ���ȷ����
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="ComponentList"){//9.�㲿��������Ŀ�嵥
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="RepairList"){//10.������Ŀ�嵥
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="RepairAdd"){//11.������Ŀ�嵥����
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="PropList"){//12.�Ʋ���ʧȷ����
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  //if(type=="Compensate")//13.��������
  //{ var strCompensateNo;alert(compensateNo);
  //	for(var i=0;i<compensateNo.length/25;i++){
  //		strCompensateNo = compensateNo.substring((0+i*25),(25+i*25));
  //		alert(strCompensateNo);
  //	  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+strCompensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //	}
  //  return newWindow;
//}
  //if(type=="CompensateAdd")//14.�������鸽ҳ
  //{var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+compensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  //return newWindow;
//}
  if(type=="Drawnotice")//15.��ȡ���֪ͨ��
  {//modify by kangzhen
  	compensateNo=fm.prpLcompensateCompensateNo.value
  	compensateNo = compensateNo.substring(0,25);
  	var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+compensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return newWindow;
  }
  if(type=="Prepay"){//16.Ԥ�����������
    if (preCompensateNo==""){
    alert("�ð����޴˱�");
    return null;
    }
    else {
    var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&PreCompensateNo="+preCompensateNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return newWindow;
    }
}
  if(type=="Pressnotice"){//17.ע��֪ͨ��
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="PressnoticeEnd"){//17.�᰸�߸�֪ͨ��
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Endcase"){//18.�᰸������
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="EndcaseAdd"){//19.�᰸�����鸽ҳ
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&ClaimNo="+claimNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
}
function printForm1(filed,s,type){
  if(type=="Compensate"){
   var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+s,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
   return newWindow;
   }
  if(type=="CompensateAdd"){
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+s,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
  if(type=="Drawnotice"){
  var newWindow = window.open("/claim/ClaimPrint.do?printType="+type+"&CompensateNo="+s,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
  return newWindow;
  }
}
//modify by zhaozhuo add 20050406 end