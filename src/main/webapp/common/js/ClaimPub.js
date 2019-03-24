/*****************************************************************************
 * DESC       ��ͨ�õĴ��� ���� ��ť�ĺ���
 * AUTHOR     ��wangli
 * CREATEDATE ��2005-03-25
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

 /**
 *@description ��������ҳ��
 *@param       prpLPolicyNo ��������
 *@return      ͨ������true,���򷵻�false
 */

 function relate(prpLPolicyNo,registNo){
    var policyNo = prpLPolicyNo;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo + "&registNo=" + registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return false;
}


/**
 *@description �������Ա���ҳ��
 *@param        businessNo ������
 *@param        policyNo   ������
 *@param        riskCode   ���ִ���
 *@param        nodeType   �ڵ�����
 *@param        claimNo    ������
 *@return      ����false
 */


function openWinSave(businessNo,policyNo,riskCode,nodeType,claimNo){
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType="+nodeType+"&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");

  return false;
}

/**
 *@description �������Ա��漰�鿱ҳ��
 *@param        businessNo ������
 *@param        policyNo   ������
 *@param        riskCode   ���ִ���
 *@param        nodeType   �ڵ�����
 *@param        claimNo    ������
 *@param        receiveParam  ���ܵĲ������ƣ����磺RegistNo��ClaimNo��
 *@return       ����false
 */

function openWinSaveQuery(businessNo,policyNo,riskCode,nodeType,claimNo,receiveParam,nodeName){
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType="+nodeType+"&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo+"&"+receiveParam+"="+nodeName+"&type="+receiveParam,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=800,Height=700");
   
  return false;
}


/**
 *@description �������Ա���ҳ��
 *@param       receiveParam  ���ܵĲ������ƣ����磺RegistNo��ClaimNo��
 *@param       nodeName      ������
 *@return      ����false
 */


function openWinQuery(receiveParam,nodeName){

var win;
var messagedo="/claim/messageQueryList.do?"+receiveParam+"="+nodeName;
//alert("receiveParam = "+receiveParam);
//alert("nodeName = "+nodeName);
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");

 return false;
}



/**
 *@description ������֤ҳ��
 *@param       actionName ����ô��ڵ�action����
 *@param       paraName  ������
 *@param       registNo  ������
 *@param       registNo  �ڵ����
 */
function openCertify(actionName,paraName,registNo,nodeType,swfLogLogNo){
  var win;
	//alert(paraName);
	//alert(registNo);
	//alert(nodeType);
 var messagedo="/claim/"+actionName+".do?"+paraName+"="+registNo+"&editType=EDIT&nodeType="+nodeType+"&swfLogLogNo="+swfLogLogNo;

 win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
// win =  window.open("/claim/"+actionName+".do?"+paraName+"="+registNo+"&editType=EDIT&nodeType="+nodeType+",NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
}


function openClaimCancle(claimNo,registNo,riskCode){
  var win;
	//alert(paraName);
	//alert(registNo);
	//alert(nodeType);
 var messagedo="/claim/claimBeforeCancel.do?prpLclaimCancelClaimNo="+claimNo+"&ClaimNo="+claimNo+"&RegistNo="+registNo+"&nodeType=cance&editType=CANCELEDIT&type=claim&riskCode="+riskCode;

 win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
// win =  window.open("/claim/"+actionName+".do?"+paraName+"="+registNo+"&editType=EDIT&nodeType="+nodeType+",NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
}


//��ť�����¼���������ͬ��������౨������ʾ
function buttonOnClick(actionName,policyNo,curRegistNo)
{
  var sameCount = parseInt(fm.PerilCount.value);
 
  if (sameCount <1)
  {
  	fm.button_Peril_Open_Context.disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}

//��ť�����¼�,���ڸ��ݱ��¹��ߴ�����������Ϣ
function buttonOnClickOfBene(field,actionName)
{
  var orderCurrent = 0  ;   
  orderCurrent = parseInt(getElementOrder(field));
  var serialNo = parseInt(fm.prpLacciPersonFamilyNo[orderCurrent-2].value);
  var policyno = fm.policyno.value;
  var bizType = actionName;
  if(isNaN(serialNo)){
    serialNo=0
  }
  if (serialNo <1)
  {
  	alert("��ѡ���¹��ߴ���");
  	return;
  }
  var messagedo="/claim/beneInfoShow.do?serialNo="+serialNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
} 

//��ť�����¼�,���ڸ����¹��ߴ���������Ϣ
function buttonOnClickOfBeneRisk(field,actionName)
{
  var orderCurrent = 0  ;   
  orderCurrent = parseInt(getElementOrder(field));
  var bizType = actionName;
  var familyNo = parseInt(fm.prpLacciPersonFamilyNo[orderCurrent-1].value);
  if(isNaN(familyNo)){
    familyNo=0
  }
  if (familyNo <1)
  {
  	alert("��ѡ���¹��ߴ���");
  	return;
  }
  var policyno = fm.policyno.value;
  var messagedo="/claim/beneInfoShow.do?serialNo="+familyNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
} 

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage1(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y

  ex = ex - 520;

  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;

  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
}

//��ť�����¼��������������ʾ
function buttonOnClick1(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//����
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}

//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage2(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y

  ex = ex - 520;

  if (ex<0)
  {
    ex = 0;
  }
  ex = ex - intLeftMove;

  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
}



/**
 *@description �������
 *@param       actionName ����ô��ڵ�action����
 *@param       paraName  ������
 *@param       registNo  ������
 *@param       registNo  �ڵ����
 */
function applySchedule(registNo,nodeType,swfLogFlowID,swfLogLogNo,nodeStatus,certiType,certiNo){
	var win;
	
	//����жϣ�certiNo���Ϊ����ȡ������
	if (certiNo == '') {
	    certiNo = registNo;
	}
	
	///claim/DAA/compensate/DAAGetDeductibleRateSubmit.jsp
	var messagedo="/claim/specailCaseQuery.do?registNo="+registNo+"&editType=ApplySchedule&nodeType="+nodeType+"&swfLogFlowID="+swfLogFlowID
	    +"&swfLogLogNo="+swfLogLogNo+"&nodeStatus="+nodeStatus
	    +"&certiType="+certiType+"&certiNo="+certiNo;
	//alert(messagedo);
	win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=600,Height=400");
	// win =  window.open("/claim/"+actionName+".do?"+paraName+"="+registNo+"&editType=EDIT&nodeType="+nodeType+",NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
	win.focus();
}

/**
 *@description �鿴�����������
 *@param       paraName  ������
 *@param       registNo  ������
 *@param       registNo  �ڵ����
 */
function showScheduleHistory(registNo){
	var win;
	///claim/DAA/compensate/DAAGetDeductibleRateSubmit.jsp
	var messagedo="/claim/lacciCheckBeforeQuery.do?RegistNo="+registNo+"&editType=LacciCheckBeforeQuery&pageNo=1";
	//alert(messagedo);
	win=window.open(messagedo,"processPrpLacciCheck","status=no,resizable=yes,scrollbars=yes,width=800,Height=400");
	win.focus();
	// win =  window.open("/claim/"+actionName+".do?"+paraName+"="+registNo+"&editType=EDIT&nodeType="+nodeType+",NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
}
/**
 *@description ����������̯������ҳ��
 *@param       
 *@param       
 *@return      
 */
function startTrailClaim(){
    var win;
    var claimNo = fm.prpLdangerClaimNo.value;
    var editType= fm.editType.value;
    var riskCode = fm.prpLclaimRiskCode.value;
    //�жϹ������Ƿ��Ѿ���������
    if(fm.prpLdangerRiskSumClaim.value!=fm.prpLdangerRiskSumClaimOld.value){
          alert("Ԥ�������������ݴ���ٽ��з�̯���㡣");
          return false;
    }
    var theUrl="/claim/reinsTrialResult.do?claimNo="+claimNo+"&editType="+editType+"&riskCode="+riskCode;
    win=window.open(theUrl,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
/**
 *@description ���������̯������ҳ��
 *@param       
 *@param       
 *@return      
 */
function startTrailCompensate(){
    var win;
    //�ж�ʵ�����Ƿ��Ѿ���������
    if(fm.prpLcompensateNodeStatus != null && fm.prpLcompensateNodeStatus.value=="3"){
       alert("�����˻����㣬���ݴ���ٽ��з�̯���㡣");
       return false;
    }
    if(fm.prpLdangerRiskSumPaid.value!=fm.prpLdangerRiskSumPaidOld.value){
          alert("ʵ�������������ݴ���ٽ��з�̯���㡣");
          return false;
    }
    var claimNo = fm.prpLcompensateClaimNo.value;
    var editType= fm.editType.value;
    var riskCode = fm.prpLclaimRiskCode.value;
    var compensateNo = fm.prpLcompensateCompensateNo.value;
    var theUrl="/claim/reinsTrialResult.do?claimNo="+claimNo+"&riskCode="+riskCode+"&compensateNo="+compensateNo;
    win=window.open(theUrl,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
/**
*�ݴ��������
*/
function giveupTemporarySave(nodeType){

	if(!confirm("ȷ��Ҫ�����ݴ�����")){
     return false;
   	}
  if(nodeType=="check"){
     fm.action="/claim/checkBeforeEdit.do?editType=giveupTemporarySave";
  }
  if(nodeType=="certa"){
     fm.action="/claim/certainLossBeforeEdit.do?editType=giveupTemporarySave";
  }
  fm.submit();
     
	}



/**
*δ��������ķ�������
*/
function taskGiveup(){
	if(!confirm("ȷ��Ҫ��������")){
     return false;
   	}
  fm.action="/claim/giveupTask.do?editType=GIVUP";
  fm.submit();
     
	}
	
/**
*�鿱δ��������ķ�������
*/
function taskCheckGiveup(){
	if(!confirm("ȷ��Ҫ��������")){
     return false;
   	}
  fm.action="/claim/checkBeforeEdit.do?editType=GIVUP";
  fm.submit();
     
	}
/**
*����δ��������ķ�������
*/
function taskClaimGiveup(){
	if(!confirm("ȷ��Ҫ��������")){
     return false;
   	}
  fm.action="/claim/claimBeforeEdit.do?editType=GIVUP";
  fm.submit();
     
	}
/**
*��֤δ��������ķ�������
*/
function taskCertifyGiveup(){
	if(!confirm("ȷ��Ҫ��������")){
     return false;
   	}
  fm.action="/claim/certifyBeforeEdit.do?editType=GIVUP";
  fm.submit();
  
}   	
/**
*��֤δ��������ķ�������
*/
function taskCertifyGiveupCombine(){
	if(!confirm("ȷ��Ҫ��������")){
     return false;
   	}
  fm.action="/claim/certifyCombineBeforeEdit.do?editType=GIVUP";
  fm.submit();
  
}  
//��ť�����¼���������ͬ��������౨������ʾ
function buttonOnClick(actionName,policyNo,curRegistNo,index)
{
  var allPerilCount = document.getElementsByName("PerilCount_"+index);
  var sameCount = parseInt(allPerilCount[0].value);
  if (sameCount <1)
  {
  	var buttonPerilOpenContext = document.getElementsByName("button_Peril_Open_Context_"+index);
  	buttonPerilOpenContext[0].disabled = true;
  	return;
  }

  var messagedo="/claim/"+actionName+".do?policyNo="+policyNo+"&curRegistNo="+curRegistNo;

  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
}
