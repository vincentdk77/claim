/*****************************************************************************
 * DESC       ：查勘登记的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-06-03
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 检查查勘登记
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{
    return true;
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
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  if(!validateForm(fm))
  {
    return false;
  }
  
  //设值复选框的值	
 var damageTypeCode = fm.prpLacciCheckDamageTypeCode.value;
  if(damageTypeCode.length<1){
    errorMessage = errorMessage + "事故类型代码不允许为空\n";
  }   
 var damageTypeName = fm.prpLacciCheckDamageTypeName.value;
  if(damageTypeName.length<1){
    errorMessage = errorMessage + "事故类型名称不允许为空\n";
  }    
 	 
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "调查描述不允许为空\n";
  }     
       
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
   if(!validateForm(fm))
  {
    return false;
  }
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}

/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinSave(){
   
   var businessNo = fm.prpLcheckRegistNo.value;
   var policyNo = fm.prpLcheckPolicyNo.value;
   var riskCode = fm.prpLcheckRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=check&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}

/**
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLcheckRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}


//Modify By sunhao add begin 2004-09-06
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relate(){	
		var policyNo = fm.prpLcheckPolicyNo.value;
		var registNo = fm.prpLcheckRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}
//Modify By sunhao add end 2004-09-06


/**
 *@description 设置画面的初始值
 *@param       无
 *@return      通过返回true,否则返回false
 */
	function initSet(){
	}

/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet1() 
{ 
  return true;
}

//按钮单击事件，用于相同保单号码多报案的显示
function buttonOnClick(strSubPageCode)
{
   var sameCount = parseInt(fm.PerilCount.value);
  
  if (sameCount <1) 
  {
  	fm.button_Peril_Open_Context.disabled = true;
  	return;
  }
  showSubPage1(strSubPageCode);
 
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
  ey = ey+10;
  span.style.left=ex;
  span.style.top=ey;
  span.style.display ='';
} 
/**
*@description 处理索赔资料清单 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
} 
/**
 *@description 弹出单证页面
 *@param       registNo
 *@add by qinyongli 2005-8
 */
function openCertify(registNo){  
  window.open("/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType=check","NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500"); 
} 

function calFund()
{
  //定义变量
  var sumCheckFee = 0;
  for( i = 1; i < fm.all("prpLAcciCheckChargeAmount").length; i++ )
  {
    chargeAmount  = parseFloat(fm.prpLAcciCheckChargeAmount[i].value);  //费用
    sumCheckFee = sumCheckFee + chargeAmount;
  }
  fm.prpLacciCheckCheckFee.value = point(round(sumCheckFee,2),2);
}

