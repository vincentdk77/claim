/**
 @description 汇总估损金额
 @param       无
 @return      无
 */
function collectCurrency1()
{
	var compAmout =0;
	var nowAmout =0;
	var exchCurrency = fm.prpLclaimCurrency.value;  //得到当前币别类型
	var exchRate = 1; //兑换率
	var reinsMoney=0
	var reinsClaimMoney=0;
	//循环计算 估金额
	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 	{
 		nowAmout =parseFloat(fm.prpLclaimLossSumClaim[n].value)
 		
 		 for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==fm.prpLclaimLossCurrency[n].value && fm.exchCurrency[j].value==exchCurrency)
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
	    compAmout = compAmout + nowAmout*exchRate;
    }
 
	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
	if(fm.prpLdangerRiskSumClaim!=undefined){
			   	//循环计算 估金额 只算新增的
			for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
		 	{
		 	  if(fm.ClaimLossFlag[n].value=="I"){
		 		reinsClaimMoney =parseFloat(fm.prpLclaimLossSumClaim[n].value);
			 		 for ( j=1;j<fm.baseCurrency.length;j++)
			         {
			              if(fm.baseCurrency[j].value==fm.prpLclaimLossCurrency[n].value && fm.exchCurrency[j].value==exchCurrency)
			              {
			                 exchRate = fm.exchRate[j].value;
			              }
			         }
				    reinsMoney = reinsMoney + reinsClaimMoney*exchRate;
			    }
		    }
      fm.prpLdangerRiskSumClaim.value=pointTwo(round(reinsMoney,2));//再保旧危险单位估损金额赋值
    }
  return true;
}

//汇总险别估损信息 ,根据币别汇总
//add by qinyongli 2005-8-31 
function collectCurrency(){
         var collectCurr ="";
         var collectTemp = new Array();
         collectCurr = "分币别汇总结果:\n";
         var map = {};
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //循环分币别统计
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                }
            }
            var policyno = fm.policyno.value;
            var kindcode = fm.prpLclaimLossKindCode[i].value;
            if(map.hasOwnProperty(kindcode)) {
                    map[kindcode] = map[kindcode] + parseFloat(fm.prpLclaimLossSumClaim[i].value);
            } else {
                    map[kindcode] = parseFloat(fm.prpLclaimLossSumClaim[i].value);
            }
  	  	    var strPage = "/claim/common/pub/UICheckItemAmount.jsp?policyno="+policyno+"&kindcode="+kindcode;
			var strXmlText = getResponseXmlText(strPage);
			if(strXmlText!="true"){
			    if(isNaN(strXmlText) && map[kindcode]>0) {
			        alert("险别 " + kindcode + " 的估损金额，不能大于此险别的保额。");
			        return false;
			    }
			    else if(map[kindcode] > parseFloat(strXmlText)) {
				    alert("险别 " + kindcode + " 的估损金额，不能大于此险别的保额："+parseFloat(strXmlText) +"元" + currencyName + "。");
				    return false;
				}
			} 
            //alert(sumLossAmount);
            //先判断当前数组中是否已有此币别,如果没有再进行保存
            for(var j=0;j<collectTemp.length;j++){             
                if(collectTemp[j]==currency){hasElement=true;}
            }
            //如果当前数组中有此元素，不再进行统计

            if(hasElement){continue;}
            //存入数组中
            collectTemp[i-1]= currency;
            collectCurr =collectCurr +  currency+"  "+ currencyName+"  "+ sumLossAmount+".00元\n";
         }
         if(collectCurr.length>0){
             alert(collectCurr);
             if(parseFloat(fm.prpLclaimSumAmount.value) < sumLossAmount) {
                 alert("估损金额汇总值，不能大于此保单的总保额，请做调整。");
                 return false;
             }
             else if(sumLossAmount>500000) {
                 alert("提示：估损金额汇总值大于 "+currencyName+" 五十万元。");
             }
             return false;
         }
}
// add by qinyongli end 2005-8-31

function getResponseXmlText(strURL){
	  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	  objXmlHttp.Open("POST",strURL,false);
	  objXmlHttp.setRequestHeader("Content-type","text/xml");
	  objXmlHttp.Send("");
	  if(objXmlHttp.status==200)
	  {
	    return objXmlHttp.responseText;
	  }
	  else if(objXmlHttp.status==404)
	  {
	    alert("找不到页面："+ strURL);
	    return "";
	  }
	  else
	  {
	    alert("访问"+ strURL +"出错，错误号："+objXmlHttp.status);
	    return "";
	  }
	}
	
function sumLossAmountInform() {
         var returnString ="";
         var collectTemp = new Array();
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //循环分币别统计
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                }
            }
            //先判断当前数组中是否已有此币别,如果没有再进行保存
            for(var j=0;j<collectTemp.length;j++){             
                if(collectTemp[j]==currency){hasElement=true;}
            }
            //如果当前数组中有此元素，不再进行统计

            if(hasElement){continue;}
            //存入数组中
            collectTemp[i-1]= currency;
         }
         if(sumLossAmount>500000) {
               returnString = "提示：估损金额汇总值大于 "+currencyName+" 五十万元。";
         }
         return returnString;
}
