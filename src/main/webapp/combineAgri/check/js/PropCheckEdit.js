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

function save(field){
   fm.buttonSaveType.value ="4";
   field.disabled = true;
   fm.submit();
}
/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */	  
function saveForm(field,saveType)
{
  //add by liuyanmei 20051115 start 
	var  prpLcheckDamageStartDate = fm.prpLcheckDamageStartDate.value;
	prpLcheckDamageStartDate=prpLcheckDamageStartDate.substring(0,10);
	var  prpLcheckCheckDate  = fm.prpLcheckCheckDate.value;
	if ( prpLcheckCheckDate >= prpLcheckDamageStartDate ){
	  } 
        else {
	   alert("查勘日期不能在出险日期之前！！");
	   return false;
	}
	//add by liuyanmei 20051115 end
  
  var errorMessage = "";
  fm.buttonSaveType.value = saveType;
  //设值复选框的值	
	 
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "查勘报告不允许为空;\n";
  }     
 //add by qinyongli 2005-9-6 查勘人判断
  var Checker1 = fm.prpLcheckChecker1.value;
  var Checker2 = fm.prpLcheckChecker2.value;
  if(Checker1==Checker2){
    errorMessage = errorMessage + "查勘人 1和查勘人 2不能为同一人;\n";
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
function initSet()
{
	var countShow = getElementCount("registNoShow");
	for(var i=0;i<countShow;i++){
		//判断是否是共保单
	    var coinsFlag = fm.all("coinsFlag_"+i).value;	
	    var shareHolderFlag = fm.all("shareHolderFlag_"+i).value;
	    var tempReinsFlag = fm.all("tempReinsFlag_"+i).value;
	    var message = "";
	    if(coinsFlag!=0 && coinsFlag!=5 && coinsFlag!=6){
	    	message = message + "本保单为联/共保单！\n";
	    }
	    if(shareHolderFlag!=0){
	  	message = message + "此保单为股东业务！";
	    }
	    if(tempReinsFlag!=0){
	  	message = message + "此保单有临分业务！";
	    }
	    if (message.length>0) {
	    alert(message);
	    } 
	    break;
	}
	
	for(var index = 0;index<countShow;index++){
	  var sumloss    = "prpLpropSumLoss_"+index;
	  var sumreject  = "prpLpropSumReject_"+index;
	  var sumdefloss = "prpLpropSumDefLoss_"+index;
	  var sumvalue = 0;
	  var sumallvalue = 0;    
	 
	  for(i=1;i<fm.all(sumloss).length;i++)
	  {
	    sumvalue = fm.all(sumloss)[i].value; 

	    if(isNaN(sumvalue)||sumvalue.length<1){
	      sumvalue = 0;
	    }
	    if(isNaN(sumallvalue)||sumallvalue.length<1)
	    sumallvalue = 0;
	    sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
	  } 
	  fm.all("prpLpropSumSumLoss_"+index).value=point(round(sumallvalue,2),2); 

	  sumallvalue=0;
	  for(i=1;i<fm.all(sumreject).length;i++)
	  {
	    sumvalue = fm.all(sumreject)[i].value;  

	    if(isNaN(sumvalue)||sumvalue.length<1)
	    sumvalue = 0;
	    if(isNaN(sumallvalue)||sumallvalue.length<1)
	    sumallvalue = 0;
	    
	    sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
	  } 
	  fm.all("prpLpropSumSumReject_"+index).value=point(round(sumallvalue,2),2); 
	  
	  sumallvalue=0;
	  for(i=1;i<fm.all(sumdefloss).length;i++)
	  {
	    sumvalue = fm.all(sumdefloss)[i].value;  
	    if(isNaN(sumvalue)||sumvalue.length<1) {
	      sumvalue = 0; 
	    }
	    if(isNaN(sumallvalue)||sumallvalue.length<1){
	      sumallvalue = 0; 
	    }
	    sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
	  }  
	  fm.all("prpLpropSumSumDefLoss_"+index).value=point(round(sumallvalue,2),2); 
	  //sumRepairFee();
	  //sumComponentFee();
	  //zzzzzzzzzzzsumPersonLossFee(index);
	  //zzzzzzzzzsumPreDefLoss(index);
	}
    return true;
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
*@add by qinyongli 2005-8
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
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(index){
     var SHOWTYPE  ="SHOW";
     var BizNo     = fm.all("prpLcheckPolicyNo_"+index).value;
     var RiskCode  = fm.all("prpLcheckRiskCode_"+index).value;
     var damageDate= fm.all("damageDate_"+index).value;
     var CoreWebUrl= fm.txtCoreWebUrl.value;
     var versionType = fm.versionType.value;
     var versionNo = fm.versionNo.value;
     var vURL="";
     	if("A01" == versionNo || versionNo == "" )
	 	{
	 	 vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	 	 }
	  else
		{
		vURL = CoreWebUrl +'/' + RiskCode + "-" + versionType + "-" + versionNo + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
	}
    
         window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}
/**
	检查赔付数量是否大于承保数量 
*/
function checkStatQuantity(field){
	if(isNaN(field.value)){
		alert("赔付数量为数字!");
		field.focus();
		field.select();
		return;
	}
	if(isNaN(fm.statQuantity.value)){
		fm.statQuantity.value = 0;
	}
	var statQuantity = Number(fm.statQuantity.value);
	var lossQuantity = Number(field.value);
	if(lossQuantity > statQuantity){
		alert("赔付数量不能大于承保数量! 承保数: "+statQuantity);
		field.focus();
		field.select();
	}
	return;
}

function spanShow()
{
	var countShow = getElementCount("registNoShow");
	var showFlag = document.getElementsByName("registNoShow");
	for(var index = 0 ;index < countShow ; index++)
	{
		var spanMain = document.getElementById("spanMain_"+index);
			spanMain.style.display = "none";
		var spanVerifyLoss = document.getElementById("spanVerifyLoss_"+index);
			spanVerifyLoss.style.display = "none";
		var spanPropEdit = document.getElementById("spanPropEdit_"+index);
			spanPropEdit.style.display = "none";
		var spanEarEdit = document.getElementById("spanEarEdit_"+index);
			spanEarEdit.style.display = "none";
		var spanTextEdit = document.getElementById("spanTextEdit_"+index);
		spanTextEdit.style.display = "none";
		if(showFlag[index].checked)
		 {
			spanMain.style.display = "";
			spanVerifyLoss.style.display = "";
			spanPropEdit.style.display = "";
			spanEarEdit.style.display = "";
			spanTextEdit.style.display = "";
		 }
	} 
	return true;
}
function initSpan()
{
	var countShow = getElementCount("registNoShow");
	var showFlag = document.getElementsByName("registNoShow");
	if(countShow > 0){
		showFlag[0].checked = true;
		for(var index = 0 ;index < countShow ; index++)
		{
			var spanMain = document.getElementById("spanMain_"+index);
				spanMain.style.display = "none";
			var spanVerifyLoss = document.getElementById("spanVerifyLoss_"+index);
				spanVerifyLoss.style.display = "none";
			var spanPropEdit = document.getElementById("spanPropEdit_"+index);
				spanPropEdit.style.display = "none";
			var spanEarEdit = document.getElementById("spanEarEdit_"+index);
				spanEarEdit.style.display = "none";
			var spanTextEdit = document.getElementById("spanTextEdit_"+index);
			spanTextEdit.style.display = "none";
			if(showFlag[index].checked)
			 {
				spanMain.style.display = "";
				spanVerifyLoss.style.display = "";
				spanPropEdit.style.display = "";
				spanEarEdit.style.display = "";
				spanTextEdit.style.display = "";
			 }
		} 
	}
	return true;
}