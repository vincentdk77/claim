/*****************************************************************************
 * DESC       ：核损登记的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-07-13
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
 function setreadonlyforhouse()
 {
     var riskcode = fm.prpLverifyLossRiskCode.value;
     if(riskcode == "0310"||riskcode == "0312")
     {
          fm.buttonhouse.disabled = true;
          fm.buttonEarDelete.disabled = true;
          fm.prplEarEarNoSearch.readOnly = true;
          fm.prplEarNameSearch.readOnly = true;
          
          var count = getElementCount("buttonEarDelete");
          for(var index =0 ;index < count ; index++)
          {
             if (index ==0) continue;
             fm.buttonEarDelete[index].style.display = "none";
          }
     }
 
 }
 function initForAdd()
 {
    var riskcode = fm.prpLverifyLossRiskCode.value;
    if(riskcode == "0310"||riskcode == "0312")
    {
       var number = getElementCount("prplCompensateHouseIDcard");
       if(number > 1)
       {
           fm.buttonhouse.disabled = true;
       }
    }
 }
 
 function setIdEstimateLoss3()
{
    //alert('5555');
     var riskcode = fm.prpLverifyLossRiskCode.value;
     if(riskcode == "0310"||riskcode == "0312")
     {
         var sumLoss = 0;
         var number = getElementCount("prplCompensateHouseEstimateLoss");
     
          for(var k=1;k<number;k++){
          sumLoss = sumLoss + parseFloat(fm.prplCompensateHouseEstimateLoss[k].value);
           }
           
       var temp = document.getElementsByName('prpLpropVeriSumLoss');
       temp[1].value = sumLoss;
       temp[1].onblur(); 
     }

}

function insertRowCertainLossExt(RowCode){
  insertRow(RowCode);

  var element1 = document.getElementsByName('prpLverifyLossExtTitle');
  var i = element1.length - 1;
    
  if(fm.nodeType.value=="verip" || fm.nodeType.value=="verpo" ){
    if(fm.verpOpinion.value=="01")
      fm.prpLverifyLossExtTitle[i].value = "同意定损";
    else if(fm.verpOpinion.value=="02")
      fm.prpLverifyLossExtTitle[i].value = "补充信息";
    else if(fm.verpOpinion.value=="03")
      fm.prpLverifyLossExtTitle[i].value = "价格异议发回";
    else if(fm.verpOpinion.value=="04")
      fm.prpLverifyLossExtTitle[i].value = "价格已修正";
    else if(fm.verpOpinion.value=="05")
      fm.prpLverifyLossExtTitle[i].value = "向外询价";
  }

  if(fm.nodeType.value=="verif" || fm.nodeType.value=="propv"){
    if(fm.verifyOpinion.value=="01")
      fm.prpLverifyLossExtTitle[i].value = "同意定损";
    else if(fm.verifyOpinion.value=="02")
      fm.prpLverifyLossExtTitle[i].value = "价格异议";
    else if(fm.verifyOpinion.value=="03")
      fm.prpLverifyLossExtTitle[i].value = "信息不充分";
    else if(fm.verifyOpinion.value=="04")
      fm.prpLverifyLossExtTitle[i].value = "出具检验报告";
    else if(fm.verifyOpinion.value=="05")
      fm.prpLverifyLossExtTitle[i].value = "其它";
    
  }
}


/**
 *@description 回勘初始化的只读项设置
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initReadonly()
{ 
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairFactoryName);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairStartDate);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairEndDate);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeHandlerCode);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeHandlerName);   
  setReadonlyOfElementOfLoss(fm.prpLverifyLossVerifyRemark); 
  setReadonlyOfElementOfLoss(fm.prpLverifyLossWarpDefLoss );
  
  var element1 = document.getElementsByName('prpLcomponentKindCode');
  if(element1.length>1)  {
    for(i=0;i<element1.length;i++)
    {
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriQuantity[i]); 
      //setReadonlyOfElementOfLoss(fm.prpLcomponentVeriManHourFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriMaterFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSumVeriLoss[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriRemark[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriRestFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuotedPrice[i]);
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuotedPriceShow[i]);
    }
  } else { 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriQuantity); 
//      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriManHourFee); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriMaterFee); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSumVeriLoss); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriRemark); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVeriRestFee); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuotedPrice);
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuotedPriceShow);
  }    
    
  var element2 = document.getElementsByName('prpLrepairFeeKindCode');
  if(element2.length>1)  {
    for(j=0;j<element2.length;j++)
    { 
      //setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManHour[j]);  
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManUnitPrice[j]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriMaterialFee[j]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriSumLoss[j]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriRemark[j]); 
    }   
  } else {
      //setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManHour);  
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManUnitPrice); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriMaterialFee); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriSumLoss); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriRemark); 
  }    
  
  return true; 
} 


/**
 @author      孙成刚
 @description 使一个输入域设置为只读
 @param       iElement: 域   
 @return      无
 */
function setReadonlyOfElementOfLoss(iElement)
{ 
  if(iElement.type!=null){
    if(iElement.type=="select-one")
    { 
      iElement.disabled = true;
    }
    else if (iElement.type=="text")
    {
      iElement.onfocus = null;                   
      iElement.onblur = null;                   
      iElement.readOnly = true;
      iElement.className = "readonly";
    }
    else if (iElement.type=="button")
    { 
    	 iElement.style.display = "none";                   
    }
  }
}


/**
 *@description 检查核损登记
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

function change(){
  var element = document.getElementsByName('prpLverifyLossExtTitle');
  var i = element.length - 1;
  if(fm.verifyOpinion.value=="01")
      fm.prpLverifyLossExtTitle[i].value = "同意定损";
    else if(fm.verifyOpinion.value=="02")
      fm.prpLverifyLossExtTitle[i].value = "价格异议";
    else if(fm.verifyOpinion.value=="03")
      fm.prpLverifyLossExtTitle[i].value = "信息不充分";
    else if(fm.verifyOpinion.value=="04")
      fm.prpLverifyLossExtTitle[i].value = "出具检验报告";
    else if(fm.verifyOpinion.value=="99")
      fm.prpLverifyLossExtTitle[i].value = "其它";
}

/**
 *@description 根据按钮状态保存报案数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */	  
function saveForm(field,saveType)
{ 
  fm.buttonSaveType.value = saveType;
    if(fm.prpLrepairFeeRepairFactoryCode != null && fm.prpLrepairFeeRepairFactoryCode.value == ""){
    alert("请选择修理厂类型！");
    return false;
  }
  if(fm.prpLrepairFeeRepairFactoryName != null && fm.prpLrepairFeeRepairFactoryName.value == ""){
    alert("请选择修理厂名称！");
    return false;
  }

	var element = document.getElementsByName('prpLverifyLossExtTitle');
   var i = element.length - 1;
  if(i>0 && fm.prpLverifyLossExtTitle[i].value == ""){
    alert("请输入核损意见！");
    return false;
  }

  fm.buttonSaveType.value = saveType; 
  
  //得到核损意见
  //取LossLossItemCode
  var prpLverifyLossLossItemCode = trim(fm.prpLverifyLossLossItemCode.value);
  var lossItemCode = 0;
  lossItemCode = parseInt(prpLverifyLossLossItemCode);
  
  if(isNaN(lossItemCode))
  {
    lossItemCode = 0;//定为0，不取页面值
  }
  else
  {
   if(lossItemCode>0 || lossItemCode=="-1"){
     var verifyOpinion = trim(fm.verifyOpinion.value);
        
    }     
  }
  if (saveType=="4") {
  	
  	if (trim(fm.nodeType.value)!="backc"){
  		
    if (trim(fm.nextNodeNo.value).length<1)
  	{
  		alert("请选择要提交的下一个节点！")
  		return false;
  	}
 
  	//判断是否可以提交
  	if(lossItemCode>0 || lossItemCode=="-1")
  	{
  	  if(verifyOpinion!="01")
      {
        errorMessage("核损意见为同意定损时才可以提交该案件!")
  		  return false;      
      }
  	}  	
  }
    //modify by lixiang modify 20050420 start
    //reason:可以不选择人
    /*
  	if (trim(fm.nextHandlerCode.value).length<1)
  	{
  		alert("请选择要提交的下一个人！")
  		return false;
  	} 
  	*/  	
  	//modify by lixiang modify 20050420 end
    
  	
  }
  
  
  if (saveType=="5") 
  {
    //判断是否可以提交
    if(lossItemCode>0 || lossItemCode == "-1"){
      if(verifyOpinion=="01")
      {
        errorMessage("核损意见为同意定损时不可以退回该案件!")
  		  return false;      
      }  
    }
        
  }
  

  
    var riskcode = fm.prpLverifyLossRiskCode.value;
      if(riskcode == "0310"||riskcode == "0312")
  {
     var count = getElementCount("prplCompensateHouseIDcard");
     var ids = document.getElementsByName("prplCompensateHouseIDcard");
     var inprocess = document.getElementsByName("prplCompensateHouseInprocess");
     if(count ==1)
     {
        alert("请查询输入农户身份证信息!");
        return false;
     
     }
     for(var index =0 ;index < count ; index++)
	 {
	 	 if (index ==0) continue;

	 		//if(trim(inprocess[index].value) == "Y")
		 	 //{
		 	 	//alert("包含正在进行处理的耳标号，不能提交！");
		 	 	//return false;
		 	 //}



	 	 var i =index;
	 	 i++;
	 	 while(i < count)
	 	 {
	 	  if(ids[index].value == ids[i].value)
	 	  {
	 	  alert("身份证号不可重复");
	 	  	return false;
	 	 	}
	 	 	 i++;
	 	 }
	 	}
  }
  
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
 
  
  fm.submit();
  //return true;   	
}

/**
 *@description 实现修理换件，人员，费用的显示变换
 *@param       spanID span编号
 *@param       spanName span的名称
 */
function changeSpan(spanID,spanName){ 

  var spanNameRepairComponentObject = eval("SpanRepairComponent");
  var spanNamePersonObject = eval("SpanPerson");
  var spanNamePropObject = eval("SpanProp");

  if(spanName.id == "SpanRepairComponent"){
    spanNameRepairComponentObject.style.display="";
    spanNamePersonObject.style.display="none";
    spanNamePropObject.style.display="none";
  } else if(spanName.id == "SpanPerson") {
    spanNameRepairComponentObject.style.display="none";
    spanNamePersonObject.style.display="";
    spanNamePropObject.style.display="none";     
  } else if(spanName.id == "SpanProp") {
    spanNameRepairComponentObject.style.display="none";
    spanNamePersonObject.style.display="none";
    spanNamePropObject.style.display="";     
  }

}
 
//Modify By wangli remark begin 20050328
//reason: 统一使用ClaimPub.js 里的方法，便于维护

/**
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
/*
function openWinSave(){
   
   var businessNo = fm.prpLverifyLossRegistNo.value;
   var policyNo = fm.prpLverifyLossPolicyNo.value;
   var riskCode = fm.prpLverifyLossRiskCode.value;
   var claimNo = fm.prpLverifyLossClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=verif&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
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
var messagedo="/claim/messageQueryList.do?registNo="+ fm.RegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
//Modify By wangli remark end 20050328

/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet()
{ 
  var sumloss    = "prpLpropSumLoss";
  var sumreject  = "prpLpropSumReject";
  var sumdefloss = "prpLpropSumDefLoss";
  var sumvalue;
  var sumallvalue;    
  checkObject = eval(fm.all(sumloss));
  if (checkObject != null) { 
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
    fm.prpLpropSumSumLoss.value=point(round(sumallvalue,2),2); 
  }
  sumallvalue=0;
  checkObject = eval(fm.all(sumreject));
  if(checkObject!=null){
    for(i=1;i<fm.all(sumreject).length;i++)
    {
      sumvalue = fm.all(sumreject)[i].value;  
  
      if(isNaN(sumvalue)||sumvalue.length<1)
      sumvalue = 0;
      if(isNaN(sumallvalue)||sumallvalue.length<1)
      sumallvalue = 0;
      
      sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
    } 
    fm.prpLpropSumSumReject.value=point(round(sumallvalue,2),2); 
  } 
  sumallvalue=0;
  checkObject = eval(fm.all(sumdefloss));
  if(checkObject!=null){
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
    fm.prpLpropSumSumDefLoss.value=point(round(sumallvalue,2),2); 
  } 
  //核损受损金额、核损剔除金额、核损金额合计初始化
  sumloss    = "prpLpropVeriSumLoss";
  sumreject  = "prpLpropVeriSumReject";
  sumdefloss = "prpLpropVeriSumDefLoss";
  checkObject = eval(fm.all(sumloss));
  sumallvalue = 0;
  if (checkObject != null) { 
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
    fm.prpLpropSumVeriSumLoss.value=point(round(sumallvalue,2),2); 
  }
  sumallvalue=0;
  checkObject = eval(fm.all(sumreject));
  if(checkObject!=null){
    for(i=1;i<fm.all(sumreject).length;i++)
    {
      sumvalue = fm.all(sumreject)[i].value;  
  
      if(isNaN(sumvalue)||sumvalue.length<1)
      sumvalue = 0;
      if(isNaN(sumallvalue)||sumallvalue.length<1)
      sumallvalue = 0;
      
      sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
    } 
    fm.prpLpropSumVeriSumReject.value=point(round(sumallvalue,2),2); 
  } 
  sumallvalue=0;
  checkObject = eval(fm.all(sumdefloss));
  if(checkObject!=null){
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
    fm.prpLpropSumVeriSumDefLoss.value=point(round(sumallvalue,2),2); 
  } 
  
  sumRepairFee();
  sumComponentFee();
  sumPersonLossFee();
  //sumPreDefLoss();
  return true;
} 

/**
 *@description 计算工时费合计、核价工时费合计
 *@param       无
 *@return      无
 */ 
  function sumRepairFee()
  {
   var sumRepairDefFee = 0 ;//总修理定损费
   var sumRepairVerifyFee = 0 ;//总修理核价费
   var prpLrepairFeeSumDefLoss = 0 ;
   var prpLrepairFeeVeriSumLoss = 0 ;

try{	  
   for(i=1;i<fm.all("prpLrepairFeeManHour").length;i++){
   	    prpLrepairFeeVeriSumLoss = parseFloat(fm.all("prpLrepairFeeVeriSumLoss")[i].value);
   	    prpLrepairFeeSumDefLoss = parseFloat(fm.all("prpLrepairFeeSumDefLoss")[i].value);

	   	if(isNaN(prpLrepairFeeVeriSumLoss)){
	      prpLrepairFeeVeriSumLoss = 0;
	    }
	    if(isNaN(prpLrepairFeeSumDefLoss)) {
	      prpLrepairFeeSumDefLoss = 0;
	    }
        
      sumRepairDefFee    = sumRepairDefFee + prpLrepairFeeSumDefLoss;
      sumRepairVerifyFee = sumRepairVerifyFee + prpLrepairFeeVeriSumLoss;
   }
   
   //定损工时费合计
   fm.SumDefLoss1.value     = point(round(sumRepairDefFee,2),2);;

   //核价工时费合计
   fm.SumVerifyLoss1.value  = point(round(sumRepairVerifyFee,2),2);
   //计算总的定损金额
   sumPreVerifyLoss();
}catch(ex){}

   return true;
  } 
  

/**
 *@description 计算换件费合计、核价换件费合计
 *@param       无
 *@return      无
 */ 
  function sumComponentFee() 
  { 
     var sumComponentMaterialFee = 0 ; //定损换件费合计
     var sumComponentVerpCompPrice = 0 ; //核价换件费合计
     var sumManageFee = 0; //管理费 
     var sumVerifyManageFee = 0; //总公司核定管理费
     var sumTax = 0;       //税金   
     var sumTransFee = 0;  //运费
     var sumRestFee = 0;   //残值合计
     var sumVeriRestFee = 0; //核定残值
     var sumVeriManageFee = 0;
     var quantity = 0 ;     
     var verpCompPrice = 0 ; 
     var materialFee = 0 ; 

//try{
     //……国元……，核损环节中更改了 零配件更换项目清单 的页面文件后，管理费，公司核定管理费出现了两次
     if(fm.all("prpLcarLossSumManager") != null){
	     if(fm.all("prpLcarLossSumManager").length > 1){
	        sumManageFee = parseFloat(fm.all("prpLcarLossSumManager")[1].value);
	     }else{
	        sumManageFee = parseFloat(fm.all("prpLcarLossSumManager").value); //管理费
	     }
     
     }
     if(fm.all("prpLcarLossSumVeriManager") != null){
	     if(fm.all("prpLcarLossSumVeriManager").length > 1){
	        sumVeriManageFee = parseFloat(fm.all("prpLcarLossSumVeriManager")[1].value);
	     }else{
	        sumVeriManageFee = parseFloat(fm.all("prpLcarLossSumVeriManager").value); //总公司核定管理费
	     } 
     
     }
     
     if(fm.all("prpLcarLossSumTax") != null){
             sumTax = parseFloat(fm.all("prpLcarLossSumTax").value);       //税金   
     }
     if(fm.all("prpLcarLossSumTransFee") != null){
            sumTransFee = parseFloat(fm.all("prpLcarLossSumTransFee").value);  //运费
     }
     if(fm.all("prpLcarLossSumRest") != null){
             sumRestFee = parseFloat(fm.all("prpLcarLossSumRest").value);   //残值合计
     }
     if(fm.all("prpLcarLossSumVeriRest") != null){
             sumVeriRestFee = parseFloat(fm.all("prpLcarLossSumVeriRest").value);   //残值合计
     }
     if(isNaN(sumManageFee)) sumManageFee = 0;
     if(isNaN(sumVeriManageFee)) sumVeriManageFee = 0;
     if(isNaN(sumTax)) sumTax = 0;
     if(isNaN(sumTransFee)) sumTransFee = 0;
     if(isNaN(sumVeriRestFee)) sumVeriRestFee = 0;
     if(fm.all("prpLcomponentQuantity") != null){
	     for(i=1;i<fm.all("prpLcomponentQuantity").length;i++)
	     { 
	        quantity = parseFloat(fm.all("prpLcomponentQuantity")[i].value);        
	        verpCompPrice = parseFloat(fm.all("prpLcomponentVerpCompPrice")[i].value);
	        materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);
	            
	        if(isNaN(quantity)) quantity = 0;        
	        if(isNaN(verpCompPrice)) verpCompPrice = 0; 
	        if(isNaN(materialFee)) materialFee = 0; 
	          
	        sumComponentMaterialFee   = sumComponentMaterialFee + parseFloat(point(round(quantity*materialFee,2),2));        
	        sumComponentVerpCompPrice   = sumComponentVerpCompPrice + parseFloat(point(round(quantity*verpCompPrice,2),2));        
	        
	        fm.all("prpLcomponentSumVeriLoss")[i].value = parseFloat(point(round(quantity*verpCompPrice,2),2));
	     } 
     
     }
      
     //定损换件费合计 = 上报价格合计 + 管理费 + 税金 + 运费 ?C 残值合计(上报价格合计 = 每一个配件的上报价格 × 数量之和)
     sumComponentMaterialFee = sumComponentMaterialFee + sumManageFee + sumTax + sumTransFee - sumRestFee;
    
     if(sumVeriManageFee!=0)
       sumManageFee = sumVeriManageFee;

     //核价换件费合计 = 核价合计 + 核定管理费 + 税金 + 运费 ?C 残值合计(核价合计 = 每一个配件的核价 × 数量之和)
     sumComponentVerpCompPrice = sumComponentVerpCompPrice + sumVeriManageFee + sumTax + sumTransFee - sumVeriRestFee;
     
     //定损换件费合计
     if(fm.SumDefLoss2 != null){
            fm.SumDefLoss2.value = point(round(sumComponentMaterialFee,2),2);
     }
 
     //核价换件费合计
     if(fm.SumVerifyLoss2 != null ){
             fm.SumVerifyLoss2.value = point(round(sumComponentVerpCompPrice,2),2);
     }

   
     //计算总的定损金额、总的核价金额
     sumPreVerifyLoss();
//}catch(ex){}     
 //    return true;
 }   
  

  /**
   *@description 汇总人员伤亡费用计算 
   *@param       无 
   *@return      无
   */ 
  function sumPersonLossFee()  
  {  
    /**********************/
    var prpLpersonSumLossSum = 0 ;        //受损金额
    var prpLpersonSumRejectSum  = 0 ;     //剔除金额
    var prpLpersonSumDefLossSum = 0 ;     //核损金额 
    var sumLoss = 0 ;
    var sumReject = 0 ;
    var sumDefLoss = 0 ; 
    var vlength = 0;
    //fm.all("SumDefLoss2").length>0
    if(isNaN(fm.all("prpLpersonSumLossSum"))){
      vlength = fm.all("prpLpersonSumLossSum").length; 
    }  
    //var vlength = fm.all("prpLpersonSumLossSum").length;  
    if(vlength>0){  
      for(j=1;j<fm.all("prpLpersonSumLossSum").length;j++){
        for(i=1;i<fm.all("prpLpersonSumLoss").length;i++){
          if(j == fm.all("personSerialNo")[i].value){
            sumLoss = parseFloat(fm.all("prpLpersonSumLoss")[i].value); 
            sumReject = parseFloat(fm.all("prpLpersonSumReject")[i].value); 
            sumDefLoss = parseFloat(fm.all("prpLpersonVeriSumDefLoss")[i].value); //取核损金额
           	if(isNaN(sumLoss)||sumLoss.length<1){
              quantity = 0;
            }
            if(isNaN(sumReject)||sumReject.length<1){
              manHourFee = 0;
            }
            if(isNaN(sumDefLoss)||sumDefLoss.length<1){ 
              materialFee = 0;
            }
            prpLpersonSumLossSum   = prpLpersonSumLossSum + parseFloat(point(round(sumLoss,2),2));
            prpLpersonSumRejectSum  = prpLpersonSumRejectSum + parseFloat(point(round(sumReject,2),2));
            prpLpersonSumDefLossSum = prpLpersonSumDefLossSum+parseFloat(point(round(sumDefLoss,2),2));
          } 
        }
        fm.all("prpLpersonSumLossSum")[j].value = point(round(prpLpersonSumLossSum,2),2);
        fm.all("prpLpersonSumRejectSum")[j].value = point(round(prpLpersonSumRejectSum,2),2);
        fm.all("prpLpersonSumDefLossSum")[j].value = point(round(prpLpersonSumDefLossSum,2),2); 
        prpLpersonSumLossSum = 0 ;        //受损金额
        prpLpersonSumRejectSum  = 0 ;     //剔除金额
        prpLpersonSumDefLossSum = 0 ;     //核损金额 
        sumPreDefLoss();   
      }
      
    } else if(vlength==0){
    } else {       
      for(i=1;i<fm.all("prpLpersonSumLoss").length;i++)
      {
          sumLoss = parseFloat(fm.all("prpLpersonSumLoss")[i].value); 
          sumReject = parseFloat(fm.all("prpLpersonSumReject")[i].value); 
          sumDefLoss = parseFloat(fm.all("prpLpersonVeriSumDefLoss")[i].value);  //取核损金额
       	if(isNaN(sumLoss)||sumLoss.length<1){
          quantity = 0;
        }
        if(isNaN(sumReject)||sumReject.length<1){
          manHourFee = 0;
        }
        if(isNaN(sumDefLoss)||sumDefLoss.length<1){ 
          materialFee = 0;
        }
        prpLpersonSumLossSum   = prpLpersonSumLossSum + parseFloat(point(round(sumLoss,2),2));
        prpLpersonSumRejectSum  = prpLpersonSumRejectSum + parseFloat(point(round(sumReject,2),2));
        prpLpersonSumDefLossSum = prpLpersonSumDefLossSum+parseFloat(point(round(sumDefLoss,2),2));
      } 
      fm.prpLpersonSumLossSum.value = point(round(prpLpersonSumLossSum,2),2);
      fm.prpLpersonSumRejectSum.value = point(round(prpLpersonSumRejectSum,2),2);
      fm.prpLpersonSumDefLossSum.value = point(round(prpLpersonSumDefLossSum,2),2);
      sumPreDefLoss(); 
    }
    
  }
/**
 *@description 计算总的定损金额
 *@param       无
 *@return      通过返回true,否则返回false
 */ 
 
 function sumPreDefLoss()
 {
 	var sumPropLoss       = 0 ;//财产
 	var sumRepairLoss     = 0 ;//修理
 	var sumComponentLoss  = 0 ;//换件
 	var sumPersonLoss=0 ;      //人员

 	var sumPreDefLoss     = 0 ;
 	if(fm.prpLpropSumSumDefLoss!=undefined){
 	sumPropLoss = fm.prpLpropSumSumDefLoss.value;
 	}
 	if(isNaN(sumPropLoss))
 	  sumPropLoss = 0 ;
 	if(fm.all("SumDefLoss1")!=null){  
    if(fm.all("SumDefLoss1").length>0){
      for(i=0;i<fm.all("SumDefLoss1").length;i++){
        sumRepairLoss = parseFloat(sumRepairLoss) +parseFloat(fm.all("SumDefLoss1")[i].value);
      }
    } else { 	     
      sumRepairLoss = fm.SumDefLoss1.value;
    }
  }
 	if(isNaN(sumRepairLoss)||sumRepairLoss.length<1)
 	   sumRepairLoss = 0 ;
 	   
   	if(fm.all("SumDefLoss1")!=null){ 
   	if(fm.all("SumDefLoss2").length>0){
      for(i=0;i<fm.all("SumDefLoss2").length;i++){
        sumComponentLoss = parseFloat(sumComponentLoss) +parseFloat(fm.all("SumDefLoss2")[i].value);
      }
    } else { 	    
      sumComponentLoss = fm.SumDefLoss2.value;
    }
  }   
 	if(isNaN(sumComponentLoss)||sumComponentLoss.length<1)
 	   sumComponentLoss = 0 ;
 	   
 	//sumPersonLoss = fm.sumPersonLoss.value;//人员定损总和未有
 	//if(isNaN(sumPersonLoss))
 	//  sumPersonLoss = 0 ;  
 	  	//alert(sumRepairLoss+"::00::"+sumPropLoss+"::00::"+sumComponentLoss+"::00::"+sumPersonLoss);  
 	sumPreDefLoss =   parseFloat(sumRepairLoss)+ parseFloat(sumPropLoss)+ parseFloat(sumComponentLoss)+parseFloat(sumPersonLoss);
 	//fm.prpLverifyLossSumPreDefLoss.value = sumPreDefLoss;
 	//alert(fm.prpLverifyLossSumPreDefLoss.value);
 
}      

/**
 *@description 计算总的核损金额
 *@param       无
 *@return      通过返回true,否则返回false
 */ 
 
 function sumPreVerifyLoss()
 {

 	var sumVeriRepairLoss     = 0 ;//修理
 	var sumVeriComponentLoss  = 0 ;//换件
 	var sumPreVeriLoss     = 0 ;
 	if(fm.all("SumVerifyLoss1")!=null){  
    if(fm.all("SumVerifyLoss1").length>0){
      for(i=0;i<fm.all("SumVerifyLoss1").length;i++){
        sumVeriRepairLoss = parseFloat(sumVeriRepairLoss) +parseFloat(fm.all("SumVerifyLoss1")[i].value);
      }
    } else { 	     
      sumVeriRepairLoss = fm.SumVerifyLoss1.value;
    }
  }
 	if(isNaN(sumVeriRepairLoss)||sumVeriRepairLoss.length<1)
 	   sumRepairLoss = 0 ;

   	if(fm.all("SumVerifyLoss2")!=null){ 
   	if(fm.all("SumVerifyLoss2").length>0){
      for(i=0;i<fm.all("SumVerifyLoss2").length;i++){
        sumVeriComponentLoss = parseFloat(sumVeriComponentLoss) +parseFloat(fm.all("SumVerifyLoss2")[i].value);
      }
    } else { 	    
      	sumVeriComponentLoss = fm.SumVerifyLoss2.value;
    }
  }   
 	if(isNaN(sumVeriComponentLoss)||sumVeriComponentLoss.length<1)
 	   sumComponentLoss = 0 ;
 	sumPreVeriLoss =   parseFloat(sumVeriComponentLoss)+ parseFloat(sumVeriRepairLoss);
 	try{
		fm.prpLcarLossSumVerifyLoss.value=point(round(sumPreVeriLoss,2),2); 
			
	 }catch(ex1)
	 {
	    return false;
	 }
}      

/**
 @author      liubvo 
 @description 校验核损金额
 @param       Field: 触发域  
 @return      boolean: 合法为true,否则为false   
 */ 
function checkPrpLpersonVeriSumLoss(Field)
{   
  var fieldname=Field.name; 
  var findex=0; 
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i; 
      break;  
    }
  } 
  if(parseFloat(Field.value)>parseFloat(fm.prpLpersonSumLoss[findex].value)){
	  errorMessage("核损金额不应大于定损金额,请重新输入！");
	  Field.focus();
	  Field.select(); 
	  return false;
  }  
  return true;   
}

/**
 @author      liubvo 
 @description 校验核损金额
 @param       Field: 触发域  
 @return      boolean: 合法为true,否则为false   
 */ 
function checkPrpLpersonVeriSumReject(Field)
{   
  var fieldname=Field.name; 
  var findex=0; 
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i; 
      break; 
    } 
  } 
  if(parseFloat(Field.value)>parseFloat(fm.prpLpersonSumReject[findex].value)){
	  errorMessage("核损金额不应大于定损金额,请重新输入！");
	  Field.focus();
	  Field.select(); 
	  return false;
  }  
  return true;   
}

/**
 @author      liubvo 
 @description 校验核损金额
 @param       Field: 触发域  
 @return      boolean: 合法为true,否则为false   
 */ 
function checkPrpLpersonVeriSumDefLoss(Field) 
{   
  var fieldname=Field.name; 
  var findex=0; 
  for(i=1;i<fm.all(fieldname).length;i++)
  { 
    if( fm.all(fieldname)[i] == Field )
    { 
      findex=i; 
      break; 
    }
  } 
  if(parseFloat(Field.value)>parseFloat(fm.prpLpersonSumDefLoss[findex].value)){
	  errorMessage("核损金额不应大于定损金额,请重新输入！");
	  Field.focus(); 
	  Field.select(); 
	  return false; 
  }  
  return true;   
} 


/**
 @description 计算人员伤亡费用清单核损金额
 @param       Field: 触发域 
 @return      无      
*/   
function calSumPersonVeriDefLoss(Field)
{                     
  var fieldname=Field.name;
  var i = 0; 
  var findex=0;  
  var sumLoss;      
  var sumReject;
  var sumDefLoss;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break;
    }
  }    
  
  sumLoss    = parseFloat(fm.all("prpLpersonVeriSumLoss")[findex].value);      
  sumReject  = parseFloat(fm.all("prpLpersonVeriSumReject")[findex].value); 
  
  if(isNaN(sumLoss))
    sumLoss = 0;
  if(isNaN(sumReject))
    sumReject = 0;                
  
  sumDefLoss = sumLoss - sumReject; 
  
  fm.all("prpLpersonVeriSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);       
   //汇总核损金额总计
   sumPersonLossFee();         
} 
 
/**
 *@description 根据报价，管理费率计算零部件的价格
 *@param       无
 *@return      通过返回true,否则返回false
 */
 
 function getMaterialFee(field,ext) 
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour;
  var Quantity;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }  
  } 
  if(fieldname=="prpLcomponentQuotedPrice"){ 
    QuotedPrice = parseFloat(field.value);   
    MaterialFee = QuotedPrice*(1+fm.prpLcarLossSumVeriManager.value/100);
    fm.all("prpLcomponentMaterialFee")[findex].value = point(round(MaterialFee,2),2);
  }else{
    for( i = 1; i < fm.all("prpLcomponentMaterialFee").length; i++ ) { 
      QuotedPrice = parseFloat(fm.all("prpLcomponentQuotedPrice")[i].value); 
      MaterialFee = QuotedPrice*(1+field.value/100); 
      fm.all("prpLcomponentMaterialFee")[i].value = point(round(MaterialFee,2),2);
    }
  }
  return true;          
 } 

/**
 *@description 设置伤情类别得隐含域
 *@param       无
 *@return      通过返回true,否则返回false
 */
function woundCodeChange(field)
{
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour;
  var Quantity;

  for(i=1;i<fm.all(fieldname).length;i++)
  {  
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }  
  }     
  
  //更改隐含项的值
  if(field.checked==true){
    fm.all(fieldname+"Txt")[findex].value = "1";
  } else {    
    fm.all(fieldname+"Txt")[findex].value = "0"; 
  }      
  //alert(fm.all(fieldname+"Txt")[findex].value);
  
  return true; 
} 


/**
 *@description 根据工时，工时单价和材料费用计算定损金额
 *@param       无
 *@return      通过返回true,否则返回false
 */
 
 function getSumDefLossVerify(field,ext)
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour;
  var Quantity;
  var veriRestFee=0;
  var fieldLength = fm.all(fieldname).length;
  for(i=1;i<fieldLength;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
 
  if(ext==1){
    ManHour = parseFloat(fm.all("prpLrepairFeeVeriManHour")[findex].value);
    manHourFee  = parseFloat(fm.all("prpLrepairFeeVeriManUnitPrice")[findex].value)      
    materialFee = parseFloat(fm.all("prpLrepairFeeVeriMaterialFee")[findex].value); 
    if(isNaN(manHourFee)||manHourFee.length<1){
      manHourFee = 0;
    }
    if(isNaN(materialFee)||materialFee.length<1) {
      materialFee = 0;
    }
    if(manHourFee==0 && materialFee==0){
      //return true;  
    }
    if(isNaN(ManHour)||ManHour.length<1){
      ManHour = 0; 
    }
    //sumDefLoss = manHourFee*ManHour * materialFee;
    sumDefLoss = manHourFee * ManHour;
    fm.all("prpLrepairFeeVeriSumLoss")[findex].value = point(round(sumDefLoss,2),2);
    sumRepairFee();
  } else {    
    
    quantity  = parseFloat(fm.all("prpLcomponentVeriQuantity")[findex].value)      
    manHourFee = parseFloat(fm.all("prpLcomponentVeriManHourFee")[findex].value); 
    materialFee = parseFloat(fm.all("prpLcomponentVeriMaterFee")[findex].value);
    veriRestFee= parseFloat(fm.all("prpLcomponentVeriRestFee")[findex].value);	
    

    if(isNaN(quantity)||quantity.length<1){
      quantity = 0;
    }
    if(isNaN(manHourFee)||manHourFee.length<1){
      manHourFee = 0;
    }
    if(quantity==0 && manHourFee==0 ){ 
      //return true;   
    }																		 
    if(isNaN(materialFee)||materialFee.length<1){
      materialFee = 0;
    }
    if(isNaN(veriRestFee)||veriRestFee.length<1){
      veriRestFee = 0;
    }
	
    sumDefLoss = parseFloat(point(round(quantity*materialFee,2),2)) + parseFloat(point(round(manHourFee,2),2));    
    sumDefLoss=sumDefLoss-veriRestFee;
    fm.all("prpLcomponentSumVeriLoss")[findex].value = point(round(sumDefLoss,2),2); 
    sumComponentFee();
    
  }  
  return true;  
       
 } 


/**
 *@description 弹出查勘的画面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relateCheck(){	  
		var registNo = fm.RegistNo.value;
	  var linkURL = "/claim/checkFinishQueryList.do?prpLcheckCheckNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskcode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

/**
 *@description 弹出报案的画面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relateRegist(){	
		var registNo = fm.RegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskcode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 


function relatePolicy(){	 
    var riskCode = fm.riskcode.value;
    var policyNo = fm.PolicyNo.value; 
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL = CoreWebUrl +'/' + riskCode + '/tbcbpg/UIPrPoEn' + riskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ policyNo+'&RiskCode='+ riskCode;
    window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
} 
 
/**
*@description 处理索赔资料清单 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}   


function initVerifyReadonly()
{ 
  var element1 = document.getElementsByName('prpLcomponentKindCode');
  
  if(element1.length>1)  {
    for(i=0;i<element1.length;i++)
    {
      setReadonlyOfElementOfLoss(fm.prpLcomponentSys4SPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSysMarketPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSysMatchPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNative4SPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNativeMarketPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVerpCompPrice[i]); 	  
      setReadonlyOfElementOfLoss(fm.prpLcomponentNativeMatchPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentOriginalId[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentFirstMaterialFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentMaterialFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuantity[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentCompName[i]); 	  
      setReadonlyOfElementOfLoss(fm.prpLcomponentKindName[i]); 	  
      setReadonlyOfElementOfLoss(fm.prpLcomponentRemark[i]); 	  	  	  
      setReadonlyOfElementOfLoss(fm.buttonComponentDelete[i]);

    }
  }
  else{

      setReadonlyOfElementOfLoss(fm.prpLcomponentSys4SPrice); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSysMarketPrice); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSysMatchPrice); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNative4SPrice); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNativeMarketPrice); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentVerpCompPrice); 	  
      setReadonlyOfElementOfLoss(fm.prpLcomponentNativeMatchPrice); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentOriginalId); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentFirstMaterialFee); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentMaterialFee); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuantity); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentCompName); 	  
      setReadonlyOfElementOfLoss(fm.prpLcomponentKindName); 	  
      setReadonlyOfElementOfLoss(fm.prpLcomponentRemark); 	 
      setReadonlyOfElementOfLoss(fm.buttonComponentDelete); 	  
      
  }   

  element1 = document.getElementsByName('prpLrepairFeeKindName');
  var partCode=  document.getElementsByName('prpLrepairFeePartCode');
  var repairType =document.getElementsByName('prpLrepairFeeRepairType');
  if (partCode.length > 1 ){
  	for (i=1;i<partCode.length;i++){
  	 setReadonlyOfElementOfLoss(fm.prpLrepairFeePartCode[i]); 
  	}
  }else {
  	 setReadonlyOfElementOfLoss(fm.prpLrepairFeePartCode); 
  }
  
  if (repairType.length > 1 ){
  	for (i=1;i<repairType.length;i++){
  	 setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairType[i]); 
  	}
  }else {
  	 setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairType); 
  }

  if(element1.length>1)  {
    for(i=0;i<element1.length;i++)
    { 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeKindName[i]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeManHour[i]); 
      // setReadonlyOfElementOfLoss(fm.prpLrepairFeePartCode[i]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeManHourUnitPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeSumDefLoss[i]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeRemark[i]); 	  
     //  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairType[i]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeCompName[i]);
      setReadonlyOfElementOfLoss(fm.buttonRepairFeeDelete[i]);
    }
  }
  else{

      setReadonlyOfElementOfLoss(fm.prpLrepairFeeKindName); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeManHour); 
       //setReadonlyOfElementOfLoss(fm.prpLrepairFeePartCode); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeManHourUnitPrice); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeSumDefLoss); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeRemark); 
      // setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairType); 	  
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeCompName);	  
      setReadonlyOfElementOfLoss(fm.buttonRepairFeeDelete);
  }   

  element1 = document.getElementsByName('prpLrepairFeeVeriManHour');
  if(element1.length>1)  {
    for(i=0;i<element1.length;i++)
    {
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManHour[i]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManUnitPrice[i]); 
    }
  }
  else{

      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManHour); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeVeriManUnitPrice); 
      
  }   

  setReadonlyOfElementOfLoss(fm.buttonRepairFee);
  
  tdNextHandleDept.innerHTML = "";
  fm.nextDeptName.style.display = "none";
  //tdnextHandlerCode.innerHTML = "";
  fm.nextHandlerName.style.display = "none";


            try{
		  setReadonlyOfElementOfLoss(fm.verpOpinion);     	
	             }catch(ex1)
	            {
	                
	            }

  setReadonlyOfElementOfLoss(fm.prpLcarLossSumTransFee);     
  setReadonlyOfElementOfLoss(fm.prpLcarLossSumTax);     
  setReadonlyOfElementOfLoss(fm.prpLcarLossSumManager);       
  setReadonlyOfElementOfLoss(fm.prpLcarLossSumVeriManager);
  setReadonlyOfElementOfLoss(fm.prpLcarLossSumRest);  
  setReadonlyOfElementOfLoss(fm.prpLcarLossLossItemName);  
  setReadonlyOfElementOfLoss(fm.prpLcarLossModelCode);  
  setReadonlyOfElementOfLoss(fm.prpLcarLossBrandName);  
  setReadonlyOfElementOfLoss(fm.prpLcarLossEngineNo);  
  setReadonlyOfElementOfLoss(fm.prpLcarLossFrameNo);  
  setReadonlyOfElementOfLoss(fm.prpLcarLossVINNo);  
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairFactoryCode);  
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairFactoryName);  
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairStartDate);  
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairEndDate);  
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeHandlerCode);  
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeHandlerName);      
  setReadonlyOfElementOfLoss(fm.prpLverifyLossVerpRemark);  


//setReadonlyOfElementOfLoss(fm.carKindCode);  
//setReadonlyOfElementOfLoss(fm.prpLverifyLossVerifyOpinion);  
//setReadonlyOfElementOfLoss(fm.prpLverifyLossVerifyRemark);  

  return true; 
} 

/**
 *@description 根据工时，工时单价和材料费用计算定损金额
 *@param       无
 *@return      通过返回true,否则返回false
 */
 
 function getSumDefLoss(field,ext)
 { 
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour;
  var Quantity;
  var materialRestFee;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 

  if(ext==1){
    ManHour = parseFloat(fm.all("prpLrepairFeeManHour")[findex].value);
    manHourFee  = parseFloat(fm.all("prpLrepairFeeManHourUnitPrice")[findex].value)      
    materialFee = parseFloat(fm.all("prpLrepairFeeMaterialFee")[findex].value); 
    if(isNaN(manHourFee)||manHourFee.length<1){
      manHourFee = 0;
    }
    if(isNaN(materialFee)||materialFee.length<1) {
      materialFee = 0;
    }
    if(manHourFee==0 && materialFee==0){
      //return true;  
    }
    if(isNaN(ManHour)||ManHour.length<1){
      ManHour = 0; 
    }
    sumDefLoss = manHourFee*ManHour * materialFee;    
    fm.all("prpLrepairFeeSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);
    sumRepairFee();
  } else {    
    
    quantity  = parseFloat(fm.all("prpLcomponentQuantity")[findex].value) 
   // manHourFee = parseFloat(fm.all("prpLcomponentManHourFee")[findex].value); 

    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[findex].value);
   // materialRestFee = parseFloat(fm.all("prpLcomponentRestFee")[findex].value);
                                   
    if(isNaN(quantity)||quantity.length<1){
      quantity = 0;
    }
    if(isNaN(manHourFee)||manHourFee.length<1){
      manHourFee = 0;
    }
    if(quantity==0 && manHourFee==0 ){
      //return true;   
    }                                                                        
    if(isNaN(materialFee)||materialFee.length<1){
      materialFee = 0;
    }
    if(isNaN(materialRestFee)||materialRestFee.length<1){
      materialRestFee = 0;
    }
 
    sumDefLoss = parseFloat(point(round(quantity*materialFee,2),2));// + parseFloat(point(round(manHourFee,2),2))- parseFloat(point(round(materialRestFee,2),2));    
    fm.all("prpLcomponentSumDefLoss")[findex].value = point(round(sumDefLoss,2),2); 
    sumComponentFee();
  } 
  //汇总偏差定损金额
  fm.prpLverifyLossWarpDefLoss.value=parseFloat(fm.SumDefLoss1.value)+parseFloat(fm.SumDefLoss2.value);
     
  //fm.all("prpLrepairFeeSumDefLoss")[findex].value = 1111;  
  //还应改汇总 
  
  return true;  

       
 } 
 
 function setFirstMaterialFee(field)
{

  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour;
  var quantity;
  if(fm.certainLossFirst == null){
        return;
  }
 if (fm.certainLossFirst.value=="First"){

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
 
    ManHour = parseFloat(fm.all("prpLcomponentMaterialFee")[findex].value);
    fm.all("prpLcomponentFirstMaterialFee")[findex].value = ManHour;
    }

}

function doswfFlowQuery (flowId){
	var url = "/claim/swfFlowBeforeQuery.do?swfLogFlowID="+flowId+"";
		if(hasSVG()){
			url += "&svgFlag=1";
		}else{ 
			url += "&svgFlag=0";
		}
		window.open(url);
} 
function hasSVG(){
	SVG_NS = 'http://www.w3.org/2000/svg';
return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
} 


