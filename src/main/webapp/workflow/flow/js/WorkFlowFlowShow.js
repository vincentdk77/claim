/*****************************************************************************
 * DESC       ��ͼ�λ���������ʾ
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-09-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
//---------------------------------------------------------------
//����ȫ�ֱ���
//---------------------------------------------------------------
/**
 *@description ���ڵ�
 *@param       �ڵ�����
 *@param       �ڵ�Xֵ
 *@param       �ڵ�Yֵ
 *@return      ͨ������true,���򷵻�false
 */
 function drawNode(nodeTitle,posX,posY,nodeStatus)
 {
 	//var strElement="<v:rect title='"+nodeTitle+"' style='top:"+posX+";left:"+posY+"width:100;height:100'></v:rect>";
 	//var posXA = parseInt(posX)+300;
    var strElement = "<v:rect style='position:relative;top:" + posY + ";left:" + posX + ";width:200;height:100;z-index:8;' fillcolor='yellow' strokeColor='blue'>" +
	                 "<v:TextBox style='MARGIN-TOP: 7.406pt; FONT-SIZE: 10.2pt; LEFT: " + posX+ "; MARGIN-LEFT: 4.562pt; WIDTH: 83.875pt; TOP: " + posY + "; HEIGHT: 25.687pt' inset = '2pt,5pt,2pt,5pt'>" + nodeTitle + "</v:TextBox>" + 
	                 "</v:rect>";
	
	var newPoint = document.createElement(strElement);
	workflowGroup.insertBefore(newPoint);
	return true;
  }
  
  
/**
 *@description ��·��
 *@param       ·�����
 *@param       ·���յ�
 *@return      ͨ������true,���򷵻�false
 */
 function drawPath(nodeTitle,posX,posY)
 {
	//var strElement="<v:rect title='"+nodeTitle+"' style='top:"+posX+";left:"+posY+"width:100;height:100'></v:rect>";
	//var newPoint = document.createElement(strElemnt);
	//workflowGroup.insertBefore(newPoint);
	return true;
}
/**
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 
function openWinSave(){   
   var businessNo = fm.prpLregistRegistNo.value;
   var policyNo = fm.prpLregistPolicyNo.value;
   var riskCode = fm.prpLregistRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=wflow&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}  

/**
 *@description �����鿴���ԶԻ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 
function openWinQuery(){ 
  var win;
  var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLregistRegistNo.value;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}