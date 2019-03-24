/*****************************************************************************
 * DESC       ：工作流模板的脚本函数页面
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-08-10
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
/**
 *@description 回退操作
 *@param       按钮对象
 *@return      通过返回true,否则返回false
 */
 
function backStepWorkFlow(fieldObject)
{
	var flowID ="";
	var logNo ="";
	var bussinessNo="";
	var  intIndex = parseInt(fieldObject.num);
	var recordCount = fm.recordCount.value;
    if(recordCount<=1){
    flowID= fm.flowID.value;
    logNo= fm.logNo.value;
    bussinessNo= fm.keyIN.value;
  } else{	  
    flowID=fm.flowID[intIndex].value; 
    logNo=fm.logNo[intIndex].value; 
    bussinessNo = fm.keyIN[intIndex].value; 	 
  }
	 
	 //输入地址不能为空
	if(flowID==""){
		alert("没有得到flowID，请重新操作。");
		return false;
	}
	if(logNo==""){
		alert("没有得到logNo号，请重新操作。");
		return false;
	}
	if(bussinessNo==""){
		alert("没有得到bussinessNo，请重新操作。");
		return false;
	}
	
	 //提示是否回退？
	 strMsg ="确定要回退业务号码为'"+bussinessNo+"'的流程吗?";
	 //执行back的操作
	 if(confirm(strMsg))
  {
     fm.bussinessNo.value= bussinessNo;
     fm.swfLogFlowID.value= flowID;
     fm.swfLogLogNo.value=logNo;   
    // target="fraInterface";
    //防止重复提交
     fm.userLastAction.value="back?"+flowID+"&"+logNo;
     
     fm.action="/claim/wfLogBackStep.do";
     fieldObject.disabled = true;
     fm.submit();
    return true;
  }
  
  return false;
}

function buildRiskCodeSelect(riskCategoryField, riskCodeField)
 {
    var categoryValue = riskCategoryField.value;
    riskCodeField.length = 0;
    riskCodeField.options[0] = new Option("", "");
    for(var i=0; i<riskCodeCount; i++)
    {
        if(riskCodes[i][0] == categoryValue)
        {
            riskCodeField.options[riskCodeField.length] = new Option(riskCodes[i][2], riskCodes[i][1]);
        }
    }
    riskCodeField.remove(0);
 }

function ShowAlertMessage()
{
	var msg= fm.alertMessage.value;
	if (msg!="")
	{
		alert(msg)
		fm.alertMessage.value="";
	}
} 

function checkPolicyNo(){
  if(fm.PolicyNo.value==""){
    errorMessage("保单号不能为空");
    return false;
  }
}