/****************************************************************************
 * DESC       ��Ӧ�ü�JavaScript����--Application Project����(����IE5/NN6)
 * AUTHOR     ��zhouxianli
 * CREATEDATE ��2003-05-04
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 *
 ************************************************************************************/
setVerbose(false);
/** ȫ�ֱ���bCancel; */  //Validate.js��Ҫ
var bCancel = false;

//Validate.js��Ҫ�ĳ�����ʼ
var DB_INT_LENGTH = 64 //���ݿ�λ��,����������
var MAX_INTEGER  = Math.pow(2,DB_INT_LENGTH-1) - 1;
var MIN_INTEGER  = -Math.pow(2,DB_INT_LENGTH-1);
var MAX_SMALLINT = Math.pow(2,DB_INT_LENGTH/4-1) - 1;
var MIN_SMALLINT = -Math.pow(2,DB_INT_LENGTH/4-1);
//Validate.js��Ҫ�ĳ�������



/**
 * ���������
 * @param field Ԫ��
 * @param tableName tableName
 * @return ��
 */
function hideSubPage(field,tableName)
{
  var order = parseInt(getElementOrder(field));
  var obj = document.getElementsByName(tableName)[order-1];
  obj.style.display ='none';
}

/**
 * ��ʾ�����
 * @param field Ԫ��
 * @param tableName tableName
 * @param leftMove ��������ƫ������Ĭ��ֵ0
 * @return ��
 */
function showSubPage(field,tableName,evt,leftMove)
{
    var order = parseInt(getElementOrder(field));
    var obj = document.getElementsByName(tableName)[order-1];
    var ex = evt.clientX+document.body.scrollLeft;
    var ey = evt.clientY+document.body.scrollTop;
    var intLeftMove = (leftMove==null?0:leftMove);

    strTemp = field.name;
    var strCompare = "Context"; //�Ƚ��ַ������������󼸸��ַ���Context
    if(strTemp.indexOf(strCompare)>-1)
    {
        strTemp = strTemp.substring(strTemp.length - strCompare.length);
    }
    else
    {
        strTemp = "";
    }

    if(strTemp==strCompare)
    {
        ex = ex - 520;
    }

    if(strTemp==strCompare)
    {
        ex = ex - 520;
    }
    ex = ex - intLeftMove;

    obj.style.display ='';
    obj.style.left=ex;
    obj.style.top=ey;
}

/**
 * ��ʾ/����ҳ
 * @param fieldId
 * @param tableId tableId
 * @return ��
 */
function showTablePage(fieldId,tableId)
{
  var field = document.getElementById(fieldId);
  var table = document.getElementById(tableId);
  if(table.style.display=="")
  {
    //�ر�
    table.style.display="none";
    field.value="(+)";
  }
  else
  {
    //��
    table.style.display="";
    field.value="(-)";
  }
}




//��ʾ������Ϣ
function errorMessage(strErrMsg)
{
  var strMsg = "ϵͳ��Ϣ:\n\n" + strErrMsg;
  alert(strMsg);
}

/**
* Ĭ�ϵ�У��Form�ķ���
* @return ͨ��true/��ͨ��false
*/
function validateQueryForm(form)
{
   if(bCancel==true) {
     return true;
   }
   return validateType(form) && validateDate(form);
}

function customBlurHandler(field){
	//alert("method customBlurHandler: field name is " + field.name);
	return true;
}

//add by zhaolu start at 2006-6-9
//reason:ǿ��

function relateBeforePolicyNo(policyNo,riskCode,damagedate)
{
	 var SHOWTYPE  ="SHOW";
	 
	 var BizNo = policyNo;
	 
	 var RiskCode = riskCode;
	 
	 var damageDate = damagedate;
	 
	 var coreWebUrl=fm.coreWebUrl.value;
	 //MODIFYL by zhaolu 20060824 start
	 vURL = coreWebUrl+'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 //modify by zhaolu 20060824 end
	//var vURL = '/prpall/PathForward?BizNo='+BizNo+'&RiskCode='+RiskCode+'&damageDate='+ damageDate;  
     //var vURL = '/prpall/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
	
}
//add by zhaolu end at 2006-6-9

//add by zhaolu end at 2006-6-9

//add by zhaolu 20060821 start
function processMenuClick(theHREF)
{

    top.fraTitle.setCommand(theHREF.title);

}
//add by zhaolu 20060821 end
//////////////////////////////////////////////////////////
////////////////////    Run   ////////////////////////////
//////////////////////////////////////////////////////////
