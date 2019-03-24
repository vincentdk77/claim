/*****************************************************************************
 * DESC       ：通用的处理 关联 按钮的函数
 * AUTHOR     ：wangli
 * CREATEDATE ：2005-03-25
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

 /**
 *@description 弹出关联页面
 *@param       prpLPolicyNo 保单号码
 *@return      通过返回true,否则返回false
 */

 function relate(prpLPolicyNo,registNo){
    var policyNo = prpLPolicyNo;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo + "&registNo=" + registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    return false;
}


/**
 *@description 弹出留言保存页面
 *@param        businessNo 报案号
 *@param        policyNo   保单号
 *@param        riskCode   险种代码
 *@param        nodeType   节点类型
 *@param        claimNo    立案号
 *@return      返回false
 */


function openWinSave(businessNo,policyNo,riskCode,nodeType,claimNo){
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType="+nodeType+"&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");

  return false;
}

/**
 *@description 弹出留言保存及查勘页面
 *@param        businessNo 报案号
 *@param        policyNo   保单号
 *@param        riskCode   险种代码
 *@param        nodeType   节点类型
 *@param        claimNo    立案号
 *@param        receiveParam  接受的参数名称（例如：RegistNo、ClaimNo）
 *@return       返回false
 */

function openWinSaveQuery(businessNo,policyNo,riskCode,nodeType,claimNo,receiveParam,nodeName){
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType="+nodeType+"&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo+"&"+receiveParam+"="+nodeName+"&type="+receiveParam,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=800,Height=700");
   
  return false;
}


/**
 *@description 弹出留言保存页面
 *@param       receiveParam  接受的参数名称（例如：RegistNo、ClaimNo）
 *@param       nodeName      报案号
 *@return      返回false
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
 *@description 弹出单证页面
 *@param       actionName 处理该窗口的action名称
 *@param       paraName  参数名
 *@param       registNo  立案号
 *@param       registNo  节点代码
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


//按钮单击事件，用于相同保单号码多报案的显示
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

//按钮单击事件,用于根据被事故者带出受益人信息
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
  	alert("请选择事故者代码");
  	return;
  }
  var messagedo="/claim/beneInfoShow.do?serialNo="+serialNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
} 

//按钮单击事件,用于根据事故者带出保益信息
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
  	alert("请选择事故者代码");
  	return;
  }
  var policyno = fm.policyno.value;
  var messagedo="/claim/beneInfoShow.do?serialNo="+familyNo+"&bizType="+bizType+"&policyno="+policyno;
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,top=100,left=100,width=700,Height=500");
} 

//显示输入框
//leftMove 默认值0，坐标左移leftMove
function showSubPage1(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //得到事件的坐标x
  var ey=window.event.clientY+document.body.scrollTop;   //得到事件的坐标y

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

//按钮单击事件，用于条款的显示
function buttonOnClick1(fieldObject)
{
	var intIndex = parseInt(fieldObject.num);
	var spanId='span_Engage_Context';
	if(isNaN(fm.button_Engage_Open_Context.length))
    {
    }
  else{//多行
     spanId='span_Engage_Context'+"["+intIndex +"]";
  }
  showSubPage2(spanId);
}

//显示输入框
//leftMove 默认值0，坐标左移leftMove
function showSubPage2(spanID,leftMove)
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;

  var ex=window.event.clientX+document.body.scrollLeft;  //得到事件的坐标x
  var ey=window.event.clientY+document.body.scrollTop;   //得到事件的坐标y

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
 *@description 申请调查
 *@param       actionName 处理该窗口的action名称
 *@param       paraName  参数名
 *@param       registNo  立案号
 *@param       registNo  节点代码
 */
function applySchedule(registNo,nodeType,swfLogFlowID,swfLogLogNo,nodeStatus,certiType,certiNo){
	var win;
	
	//添加判断：certiNo如果为空则取报案号
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
 *@description 查看历次申请调查
 *@param       paraName  参数名
 *@param       registNo  立案号
 *@param       registNo  节点代码
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
 *@description 弹出立案分摊试算结果页面
 *@param       
 *@param       
 *@return      
 */
function startTrailClaim(){
    var win;
    var claimNo = fm.prpLdangerClaimNo.value;
    var editType= fm.editType.value;
    var riskCode = fm.prpLclaimRiskCode.value;
    //判断估损金额是否已经发生更改
    if(fm.prpLdangerRiskSumClaim.value!=fm.prpLdangerRiskSumClaimOld.value){
          alert("预赔金额发生变更，请暂存后再进行分摊试算。");
          return false;
    }
    var theUrl="/claim/reinsTrialResult.do?claimNo="+claimNo+"&editType="+editType+"&riskCode="+riskCode;
    win=window.open(theUrl,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
/**
 *@description 弹出理算分摊试算结果页面
 *@param       
 *@param       
 *@return      
 */
function startTrailCompensate(){
    var win;
    //判断实赔金额是否已经发生更改
    if(fm.prpLcompensateNodeStatus != null && fm.prpLcompensateNodeStatus.value=="3"){
       alert("核赔退回理算，请暂存后再进行分摊试算。");
       return false;
    }
    if(fm.prpLdangerRiskSumPaid.value!=fm.prpLdangerRiskSumPaidOld.value){
          alert("实赔金额发生变更，请暂存后再进行分摊试算。");
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
*暂存任务放弃
*/
function giveupTemporarySave(nodeType){

	if(!confirm("确认要放弃暂存任务？")){
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
*未处理任务的放弃函数
*/
function taskGiveup(){
	if(!confirm("确认要放弃任务？")){
     return false;
   	}
  fm.action="/claim/giveupTask.do?editType=GIVUP";
  fm.submit();
     
	}
	
/**
*查勘未处理任务的放弃函数
*/
function taskCheckGiveup(){
	if(!confirm("确认要放弃任务？")){
     return false;
   	}
  fm.action="/claim/checkBeforeEdit.do?editType=GIVUP";
  fm.submit();
     
	}
/**
*立案未处理任务的放弃函数
*/
function taskClaimGiveup(){
	if(!confirm("确认要放弃任务？")){
     return false;
   	}
  fm.action="/claim/claimBeforeEdit.do?editType=GIVUP";
  fm.submit();
     
	}
/**
*单证未处理任务的放弃函数
*/
function taskCertifyGiveup(){
	if(!confirm("确认要放弃任务？")){
     return false;
   	}
  fm.action="/claim/certifyBeforeEdit.do?editType=GIVUP";
  fm.submit();
  
}   	
/**
*单证未处理任务的放弃函数
*/
function taskCertifyGiveupCombine(){
	if(!confirm("确认要放弃任务？")){
     return false;
   	}
  fm.action="/claim/certifyCombineBeforeEdit.do?editType=GIVUP";
  fm.submit();
  
}  
//按钮单击事件，用于相同保单号码多报案的显示
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
