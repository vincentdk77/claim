/****************************************************************************
 * DESC       ：应用级JavaScript定义--Application Project控制(兼容IE5/NN6)
 * AUTHOR     ：zhouxianli
 * CREATEDATE ：2003-05-04
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 *
 ************************************************************************************/
setVerbose(false);
/** 全局变量bCancel; */  //Validate.js需要
var bCancel = false;

//Validate.js需要的常数开始
var DB_INT_LENGTH = 64 //数据库位数,即整数长度
var MAX_INTEGER  = Math.pow(2,DB_INT_LENGTH-1) - 1;
var MIN_INTEGER  = -Math.pow(2,DB_INT_LENGTH-1);
var MAX_SMALLINT = Math.pow(2,DB_INT_LENGTH/4-1) - 1;
var MIN_SMALLINT = -Math.pow(2,DB_INT_LENGTH/4-1);
//Validate.js需要的常数结束



/**
 * 隐藏输入框
 * @param field 元素
 * @param tableName tableName
 * @return 无
 */
function hideSubPage(field,tableName)
{
  var order = parseInt(getElementOrder(field));
  var obj = document.getElementsByName(tableName)[order-1];
  obj.style.display ='none';
}

/**
 * 显示输入框
 * @param field 元素
 * @param tableName tableName
 * @param leftMove 坐标左移偏移量，默认值0
 * @return 无
 */
function showSubPage(field,tableName,evt,leftMove)
{
    var order = parseInt(getElementOrder(field));
    var obj = document.getElementsByName(tableName)[order-1];
    var ex = evt.clientX+document.body.scrollLeft;
    var ey = evt.clientY+document.body.scrollTop;
    var intLeftMove = (leftMove==null?0:leftMove);

    strTemp = field.name;
    var strCompare = "Context"; //比较字符串，条款的最后几个字符是Context
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
 * 显示/隐藏页
 * @param fieldId
 * @param tableId tableId
 * @return 无
 */
function showTablePage(fieldId,tableId)
{
  var field = document.getElementById(fieldId);
  var table = document.getElementById(tableId);
  if(table.style.display=="")
  {
    //关闭
    table.style.display="none";
    field.value="(+)";
  }
  else
  {
    //打开
    table.style.display="";
    field.value="(-)";
  }
}




//显示错误信息
function errorMessage(strErrMsg)
{
  var strMsg = "系统信息:\n\n" + strErrMsg;
  alert(strMsg);
}

/**
* 默认的校验Form的方法
* @return 通过true/不通过false
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
//reason:强三

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
	 window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
	
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
