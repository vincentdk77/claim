/*****************************************************************************
 * DESC       ��������ģ��Ľű�����ҳ��
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
/**
 *@description ���˲���
 *@param       ��ť����
 *@return      ͨ������true,���򷵻�false
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
	 
	 //�����ַ����Ϊ��
	if(flowID==""){
		alert("û�еõ�flowID�������²�����");
		return false;
	}
	if(logNo==""){
		alert("û�еõ�logNo�ţ������²�����");
		return false;
	}
	if(bussinessNo==""){
		alert("û�еõ�bussinessNo�������²�����");
		return false;
	}
	
	 //��ʾ�Ƿ���ˣ�
	 strMsg ="ȷ��Ҫ����ҵ�����Ϊ'"+bussinessNo+"'��������?";
	 //ִ��back�Ĳ���
	 if(confirm(strMsg))
  {
     fm.bussinessNo.value= bussinessNo;
     fm.swfLogFlowID.value= flowID;
     fm.swfLogLogNo.value=logNo;   
    // target="fraInterface";
    //��ֹ�ظ��ύ
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
    errorMessage("�����Ų���Ϊ��");
    return false;
  }
}