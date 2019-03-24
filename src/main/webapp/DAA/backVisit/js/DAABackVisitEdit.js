/**
 *@description 检查页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{
  return validateForm(window.fm);
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
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveForm(field,saveType)
{
  
  if(checkForm()==false)
  {
    return false;
  }

  var errorMessage = "";

  fm.buttonSaveType.value = saveType;
  
  var context = fm.prpLbackVisitTextContent.value;
  if(context==null||context.length<1){
    errorMessage = errorMessage + "请输入客户意见";
  }     
        
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
  
  if (saveType=="4")  
  {
    ableAllInput();
  }
  
  field.disabled = true;
  
  fm.submit(); 
  return true;
}
//modify by wangli remark start 20050409
/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinSave(){   
   var businessNo = fm.prpLregistRegistNo.value;
   var policyNo = fm.prpLregistPolicyNo.value;
   var riskCode = fm.prpLregistRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=regis&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}  
*/
/**
 *@description 弹出查看留言对话框
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function openWinQuery(){ 
  var win;
  var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/

/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function relate(){	
	var policyNo = fm.prpLbackVisitPolicyNo.value;
    var registNo = fm.prpLbackVisitRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
*/

//modify by wangli remark start 20050409