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
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
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
	//add by liuyanmei 20051115 start 
	var  prpLcheckDamageStartDate = fm.prpLcheckDamageStartDate.value;
	prpLcheckDamageStartDate=prpLcheckDamageStartDate.substring(0,10);
	var  prpLcheckCheckDate  = fm.prpLcheckCheckDate.value;
	if (prpLcheckCheckDate < prpLcheckDamageStartDate ){
	   alert("查勘日期不能在出险日期之前！！");
	   return false;
	}
	//add by liuyanmei 20051115 end
	
	// add by yehuiquan 20070717 start 判断财产损失的险别是否为空
	var prpLthirdPropKindCode = fm.all('prpLthirdPropKindCode')[0];
	if(prpLthirdPropKindCode != null){	
    	var propKindCode = prpLthirdPropKindCode.value;
	    if(propKindCode == null || propKindCode == "") {
	        alert("财产损失的险别代码信息不能为空！");
	        return false;
     	}
	}
	// add by yehuiquan 20070717 end
//	
    if (saveType=="4")
    {
  var isInputLossInfo = false;      //是否至少录入了一条人伤、财产、标的的损失信息
  //1.检查一下人伤跟踪是否有记录，
  var count=getElementCount("prpLpersonTracePersonNo");
  if (count>1){      
        isInputLossInfo = true;
  } 
    //2.检查一下财产定损是否有记录
  count=getElementCount("prpLthirdPropItemNo");
  if (count>1){   
    isInputLossInfo = true;
  } 
   //检查是否录入了标的损失信息
   count=getElementCount("prpLthirdCarLossSerialNo");
  if (count>1){    
    if(fm.riskcode != null && (fm.riskcode.value == "0506"
    ||fm.riskcode.value == "0576"||fm.riskcode.value == "0586")){
        isInputLossInfo = true;
    }

  } 
  //检查是否录入了三者车
   count=getElementCount("prpLthirdPartySerialNo");
   var claimType = fm.claimType.value;
  if (count>2){    
    isInputLossInfo = true;
  }else{
   
    if(claimType == "K"){
        alert("互碰自赔的案件必须录入三者车信息!");
        return false;
    }
  } 
  if(claimType == "K" && count > 2){
  	for(var i = 2;i < count;i++){
  		if(isEmptyField(fm.prpLthirdPartyLicenseNo[i])){
  			alert("三者车信息中，号牌号不能为空！");
  			fm.prpLthirdPartyLicenseNo[i].foces;
  			return false;
  		}
  		if(isEmptyField(fm.prpLthirdPartyInsureComCode[i])){
  			alert("三者车信息中，承保公司不能为空！");
  			return false;
  		}
  		if(isEmptyField(fm.prpLthirdPartyCarPolicyNo[i])){
  			alert("三者车信息中，保单号不能为空！");
  			return false;
  		}
  	}
  }
  //如果没有输入一条损失（财产、标的、人伤）信息,弹出提示
  if(!isInputLossInfo){
        if(fm.riskcode != null && (fm.riskcode.value == "0507"
        ||fm.riskcode.value == "0577"||fm.riskcode.value == "0587")){
            alert("必须录入三者车、财产、人伤的至少一条损失信息，才能提交");
            return false;
        }else {
            alert("必须录入三者车、财产、人伤及标的的至少一条损失信息，才能提交");
            return false;
        }       
  }
  }




// add by sinosoft.com.ljy begin
/*
	var lPercent = 0;
        for (i=1;i<fm.prpLthirdPartySerialNo.length;i++)
        {
          lPercent= lPercent + parseFloat(fm.prpLthirdPartyDutyPercent[i].value);
        }
         if (lPercent!=100)
         {
            strmsg="所有涉案车辆的责任比例之和必须为100!";
            alert(strmsg);
            //field.select();
            //field.focus();
            return false;
         }
*/		 
	/*
  //回勘的js判断
  if(fm.prpLcarLossBackCheckFlagCheck.checked==true){
     fm.prpLcarLossBackCheckFlag.value="1"; 
  }else {
     fm.prpLcarLossBackCheckFlag.value="0";
  }   
  */
  var errorMessage = "";
  var flag =false;
  fm.buttonSaveType.value = saveType;
  /*
  //设值复选框的值	
	var ref="";
	for(i=0;i<fm.prpLcheckReferKind.length;i++){
		if(fm.prpLcheckReferKind[i].checked==true){
			ref = ref + ","+fm.prpLcheckReferKind[i].value;
		}
	}
	fm.referKind.value = ref;	  
  */
 
 
 var lossFlaglength = fm.all("prpLthirdPartyLossFlag").length;
  for (var k=1;k<lossFlaglength;k++){
	var  lossFlag = fm.prpLthirdPartyLossFlag[k].value;
	var  licenseNo =fm.prpLthirdPartyLicenseNo[k].value;
	
	
  if(lossFlag.length<1){
  	 
  	 if (licenseNo==null) licenseNo=""; 
    errorMessage = errorMessage + "车牌号为："+licenseNo+"的车是否受损不允许为空\n";
    fm.prpLthirdPartyLossFlag[k].focus();
    
  }  
}
// if(isInputLossInfo){
//  var lossFlaglength = fm.all("prpLthirdPartyDriveName").length;
//   for(var ii=1; ii <lossFlaglength ;ii++){
//      if(fm.prpLthirdPartyDriveName[ii].value == "")
//       errorMessage=errorMessage+"三者车驾驶员姓名不允许为空\n";
//      if(fm.prpLthirdPartyDriveLicensNo[ii].value == "")
//       errorMessage=errorMessage+"三者车驾驶员身份证 不允许为空\n";
//      if(fm.prpLthirdPartyLicenseNo[ii+1].value == "")
//       errorMessage=errorMessage+"号牌号码不允许为空\n";
//      if(fm.prpLthirdPartyFrameNo[ii+1].value == "")
//       errorMessage=errorMessage+"车架号 不允许为空\n";
//   }
// }
  var context = fm.prpLregistTextContextInnerHTML.value;
  if(context.length<1){
    errorMessage = errorMessage + "查勘报告不允许为空\n";
    
  }    
 //add by qinyongli 2005-9-6 查勘人判断
  var Checker1 = fm.prpLcheckChecker1.value;
  var Checker2 = fm.prpLcheckChecker2.value;
  if(Checker1==Checker2){
    errorMessage = errorMessage + "查勘人 1和查勘人 2不能为同一人;\n";
   
  } 
  
  //校验驾驶员证件类型、证件号码必须录入
  var prpldriverlength = fm.all("prpLdriverIdentifyNumber").length;
  for(var i = 1; i < prpldriverlength; i++){
        if(fm.all("prpLdriverDriverName")[i].value == ""){
            errorMessage =errorMessage + "驾驶员姓名不能为空\n";
        }
        if(fm.all("prpLdriverIdentifyNumber")[i].value == ""){
            errorMessage =errorMessage + "驾驶员证件号码不能为空\n";
        }
  }
/*
  for(i=0;i<2;i++)
  {
    if(fm.repeatInsureFlag(i).checked==true)
    {
      flag = true;
      break; 
    }
  }

  
  if(flag==false){
    errorMessage = errorMessage + "是否向其它保险投保不允许为空\n";
  }
*/  
  //车险需求改造对相应的元素进行控制不允许为空
  var firstSiteFlag0 = fm.firstSiteFlag[0].checked;
  var firstSiteFlag1 = fm.firstSiteFlag[1].checked;
  if(firstSiteFlag0 == "" && firstSiteFlag1 == ""){
    errorMessage = errorMessage + "是否第一现场不允许为空\n";
  }
  var prpLcheckDamageCode = fm.prpLcheckDamageCode.value;
  var prpLcheckDamageName = fm.prpLcheckDamageName.value;
  if(prpLcheckDamageCode == "请选择" || prpLcheckDamageName == "请选择" ||
     prpLcheckDamageCode == null ||  prpLcheckDamageName == ""){
  	errorMessage = errorMessage + "出险原因不允许为空\n";
  }
  var prpLcheckDamageAreaCode = fm.prpLcheckDamageAreaCode.value;
  var prpLcheckDamageAreaName = fm.prpLcheckDamageAreaName.value;
  if(prpLcheckDamageAreaCode == "请选择" || prpLcheckDamageAreaName == "请选择" ||
     prpLcheckDamageAreaCode == null ||  prpLcheckDamageAreaName == ""){
    errorMessage = errorMessage + "出险区域不允许为空\n";
  }
  var prpLcheckDamageTypeCode = fm.prpLcheckDamageTypeCode.value;
  var prpLcheckDamageTypeName = fm.prpLcheckDamageTypeName.value;
  if(prpLcheckDamageTypeCode == "请选择" || prpLcheckDamageTypeName == "请选择" ||
     prpLcheckDamageTypeCode == null ||  prpLcheckDamageTypeName == ""){
    errorMessage = errorMessage + "事故原因不允许为空\n";
  }
  var indemnityDuty = fm.indemnityDuty.value;
  if(indemnityDuty.length < 1){
    errorMessage = errorMessage + "事故责任不允许为空\n";
  }
  var claimType = fm.claimType.value;
  if(claimType.length < 1){
    errorMessage = errorMessage + "赔案类别不允许为空\n";
  }
  if (errorMessage.length>0) {
    alert(errorMessage);
    return false;
  } 
 
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  // if(!validateForm(fm,'ThirdParty_Data,Driver_Data'))
 // {
 //   return false;
 // }
    
  //如果是提交，判断是否不是nextNodeNo或者人员为空！！！！
  //Modify by chenrenda 20050223 begin 
  //去掉对节点、人员判断
  /*
  if (saveType=="4")
  {
  	if (trim(fm.nextNodeNo.value).length<1)
  	{
  		alert("请选择要提交的下一个节点！")
  		return false;
  	}
  	
  	if (trim(fm.nextHandlerCode.value).length<1)
  	{
  		alert("请选择要提交的下一个人！")
  		return false;
  	}
  	
  }
  
  */
  //Modify by chenrenda 20050223 end 
  
  
   if (saveType=="4")
  {
  	if (fm.scheduleCheck.checked==true) fm.messageToScheduleCheck.value="1";
  	
  }
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true; 
    
	//只读的域变成可读的
  ableAllInput();      
  fm.prpLthirdPartyLicenseNo[1].disabled = false;
  fm.prpLthirdPartyBrandName[1].disabled = false;
  fm.carKindCode[1].disabled = false;
  fm.licenseColorCode[1].disabled = false;
  fm.submit();
  //return true;   	
}

//Modify By wangli remark begin 20050325
//reason: 统一使用ClaimPub.js 里的方法，便于维护

/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinSave(){
   
   var businessNo = fm.prpLcheckRegistNo.value;
   var policyNo = fm.prpLcheckPolicyNo.value;
   var riskCode = fm.prpLcheckRiskCode.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=check&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}
*/
/**
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.prpLcheckRegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
 */
//Modify By sunhao add begin 2004-09-06
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function relate(){	
		var policyNo = fm.prpLcheckPolicyNo.value;
		var registNo = fm.prpLcheckRegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");


}
//Modify By sunhao add end 2004-09-06
*/
//Modify By wangli remark end 20050325

/**
 *@description 设置画面的初始值
 *@param       无
 *@return      通过返回true,否则返回false
 */
	function initSet(){
  	//loadCheckLoss();
  	loadCheckExt();
    fm.buttonThirdPartyDelete[1].disabled = true;
  
  	
    //modify by suncg add 20060109 start
    //reason: 修改bug1080

    fm.prpLthirdPartyLicenseNo[1].disabled = true;

    fm.prpLthirdPartyBrandName[1].disabled = true;
    fm.carKindCode[1].disabled = true;
    fm.licenseColorCode[1].disabled = true;
    //页面调整（查勘和报案用用样的页面文件，在此调整）
    //spanDamageInfo.style.display = '';
    //spanDamageInfo.style.position = '';
    RegistText.style.width = '100%';
    fm.RegistTextImg.src='/claim/images/butExpandBlue.gif';
    fm.RegistTextImg.onclick = new Function("showPage(this,RegistText)");
    fm.RegistTextImg.onclick();
    table_cars.style.display = '';
	}
/**
 *@description 设置画面的初始值
 *@param       无
 *@return      通过返回true,否则返回false
 */	
	function initSetForCertainLoss(){ 
  	//loadCheckLoss();
  	loadCheckExt();
  	fm.buttonThirdPartyDelete[1].disabled = true;
    fm.prpLthirdPartyLicenseNo[1].readOnly = true; 
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



/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */	  
function fileSave(field,saveType)
{   
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
 
 if(!validateForm(fm,'Certify_Data'))
  {
    return false;
  }
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}

/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */	  
function fileSavePop(field,saveType)
{   
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
 
 if(!validateForm(fm,'Certify_Data'))
  {
    return false;
  }
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  fm.target="_self";
  fm.submit(); 
  //return true;   	
}
   
  /**
   *@description 查看制定的文件
   *@param       fileName，businessNo，uploadFileName
   */
  function viewFile(fileName,businessNo){
    //document.fm.action="/claim/DAA/certify/download.jsp?fileName="+fileName+"&businessNo="+businessNo+"&uploadFileName="+uploadFileName;
    //document.fm.submit();
    window.open("/claim/DAA/certify/CertifyViewFile.jsp?fileName="+fileName+"&businessNo="+businessNo,businessNo,"resizable=0,scrollbars=1,width=800,height=600");
  }
  
  //Modify By wangli remark begin 20050328
//reason: 统一使用ClaimPub.js 里的方法，便于维护


 //Modify By wangli remark end 20050328
/**
 * 隐藏输入框
 * @param field 元素
 * @param tableName tableName
 * @return 无
 */
function backSubPage(spanID)
{
   var span = eval(spanID );
  if (span.style.display =='none')  
  {
  	span.style.display ='';
  }else
	{
		span.style.display ='none';
	}
}

/**
 @description 改变赔偿责任时触发，相应改变责任比例
 @param       无
 @return      无
 */
function changeIndemnityDuty()
{  
  var indemnityDuty =""; //设置的值	  
  var i= 0;              //循环使用
                   
           
  switch (fm.indemnityDuty.value)
  {
    case "0":   //全责
      indemnityDuty = "100";
      break;
    case "1":   //主责
      indemnityDuty = "70";
      break;
    case "2":   //同责
      indemnityDuty = "50";
      break;
    case "3":   //次责
      indemnityDuty = "30";
      break;
    case "4":   //无责
      indemnityDuty = "0.0";
      break;
    case "9":   //其它
      indemnityDuty = "0.0";
      break;
  }
  
   
   for( var i=1;i<fm.prpLthirdPartySerialNo.length;i++)
 	{
		if (fm.insureCarFlag[i].value=="1" )
    {
      fm.prpLthirdPartyDutyPercent[i].value = indemnityDuty;
      
      return isRightDutyPercent(fm.prpLthirdPartyDutyPercent[i]);
    }		
	}  
}

/**
 *@description 保存定损数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */	  
function saveCertainLossForm(field)
{
  //校验  
  //人员伤亡，财产损失，三者必录一项才能进行
  var carLossRepairFeeLossItemCode = fm.carLossRepairFeeLossItemCode.length;
  var carLossComponentLossItemCode = fm.carLossComponentLossItemCode.length;
  var personSerialNo = fm.personSerialNo.length;
  var prpLpropSerialNo = fm.prpLpropSerialNo.length;
  if(carLossRepairFeeLossItemCode == undefined &&carLossComponentLossItemCode == undefined&&personSerialNo == undefined&&prpLpropSerialNo == undefined)
  { 
    alert("车损（修理/换件），人员伤亡，财产损失，三者至少录入一项");
    return false;
  }
  
	if(checkPropKindCode()==false)
  return false;     

  
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
 
 if(!validateForm(fm,'RepairFee_Data,Component_Data,PersonFeeLoss_Data,Person_Data,Prop_Data'))
  {
    return false;
  }
    //如果是提交，判断是否不是nextNodeNo或者人员为空！！！！
  
  if (saveType=="4")
  {
  	if (trim(fm.nextNodeNo.value).length<1)
  	{
  		alert("请选择要提交的下一个节点！")
  		return false;
  	}  	
  	if (trim(fm.nextHandlerCode.value).length<1)
  	{
  		alert("请选择要提交的下一个人！")
  		return false;
  	}
 	
  }
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}

 
/**
*@description 处理索赔资料清单 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}   
 //modify by wangli remark start 20050408
/**
 *@description 弹出单证页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
 /*
function openCertify(registNo){  
  window.open("/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType=check","NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500"); 
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
 
  */
   
//modify by wangli remark end 20050408

    
/**
*@description 打印索赔须知清单  2005-08-09
*@param       businessNo   
*/
function certifyDirectList(businessNo,nodeType){    

  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirectPrint&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   
//add by qinyongli 查看出险时保单信息,在业务系统中进行保单还原
function backWardPolicy(){
     var SHOWTYPE  ="SHOW";
     var BizNo     =fm.prpLcheckPolicyNo.value;
     var RiskCode  =fm.prpLcheckRiskCode.value;
     var damageDate=fm.damageDate.value;
     var CoreWebUrl=fm.txtCoreWebUrl.value;
     var vURL = CoreWebUrl +'/' + RiskCode + '/tbcbpg/UIPrPoEn' + RiskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ BizNo+'&RiskCode='+ RiskCode+'&damageDate='+ damageDate;
     window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
}

function addOption(){
	//是否第一现场报案
	fm.firstSiteFlag[1].checked = "";
	//出险原因默认为”请选择“
	fm.prpLcheckDamageName.value = "请选择";
	fm.prpLcheckDamageCode.value = "请选择";
	//事故原因默认为“请选择”
	fm.prpLcheckDamageTypeCode.value="请选择";
	fm.prpLcheckDamageTypeName.value="请选择";
	//出险区域默认为”请选择“
	fm.prpLcheckDamageAreaCode.value = "请选择";
	fm.prpLcheckDamageAreaName.value="请选择";
	//事故责任增加”请选择选“项，默认为空
	fm.indemnityDuty.add(new Option("请选择",""));
	fm.indemnityDuty.value = "";
	//赔案类别默认为“请选择”
	fm.claimType.add(new Option("请选择",""));
	fm.claimType.value="";
	//查勘报告默认为空
	fm.prpLregistTextContextInnerHTML.value="";
}

function clearInput(field){
	if(field.value == "请选择"){
		field.value = "";
	}
}