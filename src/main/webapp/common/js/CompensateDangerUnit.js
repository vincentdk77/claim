//生成危险单位前的校验通过调用生成危险单位函数
function CompensatechangFlagDanger(){
  if("27,26,ZH,28".indexOf(fm.prpLcompensateClassCode.value)>-1){
      fm.flagDangerUnit.value="1";
  }
  if("01,03,04,08,22".indexOf(fm.prpLcompensateClassCode.value)>-1){
   if("2204".indexOf(fm.prpLcompensateRiskCode.value)>-1 || "2207".indexOf(fm.prpLcompensateRiskCode.value)>-1 || "2208".indexOf(fm.prpLcompensateRiskCode.value)>-1){
       fm.flagDangerUnit.value="1";
   }else{
     if(checkProp()==true){
  	   fm.flagDangerUnit.value="1";
     }
   }
  }
  if("0506,0576,0586".indexOf(fm.prpLcompensateRiskCode.value)>-1){
  	if(check05DAA()==true){
     fm.flagDangerUnit.value="1";
    }
  }
   if("0507,0577,0587".indexOf(fm.prpLcompensateRiskCode.value)>-1){
  	if(check05BZ()==true){
     fm.flagDangerUnit.value="1";
    }
  }
  
  if("09,10,11,YA,15".indexOf(fm.prpLcompensateClassCode.value)>-1){
    if(checkYAA()==true){
       fm.flagDangerUnit.value="1";
    }
  }

//费用给到第一个标的
  if(fm.flagDangerUnit.value=="1"){
    if(fm.prpLchargeKindCode.length!=undefined
    &&fm.prpLcompensateClassCode.value!="27"&&fm.prpLcompensateClassCode.value!="28"&&fm.prpLcompensateClassCode.value!="05"
    &&fm.prpLcompensateClassCode.value!="26"&&fm.prpLcompensateClassCode.value!="15"){
       if(fm.prpLlossDtoSerialNo.length!=undefined||"0311".indexOf(fm.prpLcompensateRiskCode.value) > -1){
       	  for(var i=1;i<fm.prpLchargeKindCode.length;i++){
	        fm.prpLlossDtoItemKindNoForCharge[i].value=fm.prpLlossDtoItemKindNo[1].value;
          }
        }
    } 
    
  	flashDangerUnit();
  }
}
//生成危险单位前险别的校验  start
function check05DAA(){
   var sumDutyDeductibleFlag = fm.sumDutyDeductibleFlag;
   if(sumDutyDeductibleFlag != null && sumDutyDeductibleFlag.value != '1'){
        alert("请点击不计免赔计算按钮进行不计免赔特约险的赔款计算");
        return false;
   }
   //赔付标的信息或赔付人员信息二者其一必须填写，否则不能提交实赔
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLpersonLossSerialNo = fm.prpLpersonLossSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLpersonLossSerialNo == undefined)
    {
      alert("赔付标的信息或赔付人员信息二者其一必须填写，否则不能生成危险单位！");
      return false;
    }
    return true;
}
function check05BZ(){
    for(var j=1;j<fm.prpLchargeSerialNo.length;j++)
    {  
    	if(fm.prpLchargeKindCode[j].value=="")
      	{
	         alert ("第"+j+"条费用险别代码不能为空");
	         return false ;
      	}
        if(fm.prpLchargeKindName[j].value=="")
      	{
	         alert ("第"+j+"条费用险别名称不能为空");
	         return false ;
      	}
     }
     return true;
}
function checkADDAgri(){
   //赔付标的信息序号
  if(fm.prpLlossDtoKindCode.length!=undefined){
    for(i=1;i<fm.prpLlossDtoKindCode.length;i++){
      if(fm.prpLlossDtoKindCode[i].value=="" || fm.prpLlossDtoKindName[i].value == ""){
		  alert("请填写第"+i+"条赔付标的险别信息\n");
		  return false;
	  }
	  if(fm.prpLlossDtoItemCode[i].value=="" || fm.prpLlossDtoLossName[i].value == ""){
		  alert("请填写第"+i+"条赔付标的的标的信息\n");
		  return false;
	  }
	}
  }
  return true;
}

function checkYAA(){
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;
    if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    {
      alert("赔款计算书中的赔付标的，赔款费用至少有一条记录!");
      return false;
    }
    return true;
}

function checkProp(){
	//赔付标的信息序号
 	if(fm.prpLlossDtoSerialNo.length!=undefined){
 	
		for(i=1;i<fm.prpLlossDtoSerialNo.length;i++){
			if(fm.prpLlossDtoKindCode[i].value==""){
				alert("请填写第"+i+"条赔付标的险别信息\n");
				return false;
			}
			if(fm.prpLlossDtoItemCode[i].value==""){
				alert("请填写第"+i+"条赔付标的的标的信息\n");
				return false;
			}
			if(fm.prpLlossDtoSumLoss[i].value==""){
				alert("请填写第"+i+"条赔付标的核定损失信息\n");
				return false;
			}
		}
	 }
	 
	  //赔付标的信息或赔付人员信息二者其一必须填写，否则不能提交实赔
    var prpLlossDtoSerialNo = fm.prpLlossDtoSerialNo.length;
    var prpLchargeSerialNo = fm.prpLchargeSerialNo.length;
    if("0311".indexOf(fm.prpLcompensateRiskCode.value) > -1){
    }else 
    if(prpLlossDtoSerialNo == undefined &&prpLchargeSerialNo == undefined)
    { 
      alert("赔款计算书中的赔付标的，赔款费用至少有一条记录!"); 
      return false; 
    }
 
  return true;

}



//生成危险单位前险别的校验  end


//设置是否重新生成危险单位
function setFlagDanger(){
   fm.flagDangerUnit.value="0";
}

//生成危险单位跳转到后台处理
function flashDangerUnit(){
    var oldAction = fm.action;
    var oldTarget = fm.target;
    fm.action='/claim/CompensateDangerUnit.do';
    fm.target="fraSubmit";
    fm.submit();
    fm.action=oldAction;
    fm.target=oldTarget;  
}

//计算此险种或险类的总的险别赔付金额
function SumKindcode(itemkindno,kindcode){
  var tempSumloss=0;
  var tempA=0;
  var flagA=false;		      
		      
  if("15".indexOf(fm.prpLcompensateClassCode.value)>-1){
  		for(var i=1;i<fm.prpLlossDtoKindCode.length;i++){
         if(fm.prpLlossDtoItemKindNo[i].value==itemkindno){
           tempSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[i].value);
           }
         }
	    for(var i=1;i<fm.prpLpersonLossKindCode.length;i++){
	         if(fm.prpLpersonLossItemKindNo[i].value==itemkindno){
	           tempSumloss+=parseFloat(fm.prpLpersonLossSumRealPay[i].value);
	        }
	    }
        for(var i=1;i<fm.prpLchargeKindCode.length;i++){
         if(fm.prpLlossDtoItemKindNoForCharge[i].value==itemkindno){
           if((fm.prpLchargeSumRealPay[i].value=="")||parseFloat(fm.prpLchargeSumRealPay[i].value)==0){
              tempSumloss+=parseFloat(fm.prpLchargeChargeAmount[i].value);
           }else{
             tempSumloss+=parseFloat(fm.prpLchargeSumRealPay[i].value);
           }
        }
    }
  }
  
    if("0576,0586".indexOf(fm.prpLcompensateRiskCode.value)>-1){
	      var deductibleAall = parseFloat(fm.prpLDeductible.value);
		  if(isNaN(deductibleAall))
		      deductibleAall = 0;
    
  		for(var i=1;i<fm.prpLlossDtoKindCode.length;i++){
          if(fm.prpLlossDtoItemKindNo[i].value==itemkindno){
            tempSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[i].value);             
          }        
        }      
	    for(var i=1;i<fm.prpLpersonLossKindCode.length;i++){
	         if(fm.prpLpersonLossItemKindNo[i].value==itemkindno){
	           tempSumloss+=parseFloat(fm.prpLpersonLossSumRealPay1[i].value);
	        }
	    }
        for(var i=1;i<fm.prpLchargeKindCode.length;i++){
	         if(fm.prpLlossDtoItemKindNoForCharge[i].value==itemkindno){
	           if((fm.prpLchargeSumRealPay[i].value=="")||parseFloat(fm.prpLchargeSumRealPay[i].value)==0){
	              tempSumloss+=parseFloat(fm.prpLchargeChargeAmount[i].value);
	           }else{
	             tempSumloss+=parseFloat(fm.prpLchargeSumRealPay[i].value);
	           }
	          }
    
        }
        if(deductibleAall>0){
          var prpLcompensateSumPaid=parseFloat(fm.prpLcompensateSumPaid.value);
		  var tempAll=prpLcompensateSumPaid+deductibleAall;
          tempSumloss=tempSumloss-(deductibleAall*tempSumloss/tempAll);
        }
  }
  
  
     if("0506".indexOf(fm.prpLcompensateRiskCode.value)>-1){
	        var deductibleAall = parseFloat(fm.prpLDeductible.value);
		  if(isNaN(deductibleAall))
		      deductibleAall = 0;
    
  		for(var i=1;i<fm.prpLlossDtoKindCode.length;i++){
           if(fm.prpLlossDtoItemKindNo[i].value==itemkindno){
            tempSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[i].value);
         }
       }
       
	    for(var i=1;i<fm.prpLpersonLossKindCode.length;i++){
	         if(fm.prpLpersonLossItemKindNo[i].value==itemkindno){
	           tempSumloss+=parseFloat(fm.prpLpersonLossSumRealPay1[i].value);
	        }
	    }
        for(var i=1;i<fm.prpLchargeKindCode.length;i++){
	         if(fm.prpLlossDtoItemKindNoForCharge[i].value==itemkindno){
	           if((fm.prpLchargeSumRealPay[i].value=="")||parseFloat(fm.prpLchargeSumRealPay[i].value)==0){
	              tempSumloss+=parseFloat(fm.prpLchargeChargeAmount[i].value);
	           }else{
	             tempSumloss+=parseFloat(fm.prpLchargeSumRealPay[i].value);
	           }
	          }
        }
          if(deductibleAall>0&&kindcode=="A"){
            tempSumloss=tempSumloss-deductibleAall;
         }
  }

  if("27".indexOf(fm.prpLcompensateClassCode.value)>-1||fm.prpLcompensateRiskCode.value=="2606"||fm.prpLcompensateRiskCode.value=="2609"){
 
	    for(var i=1;i<fm.prpLpersonLossKindCode.length;i++){
	         if(fm.prpLpersonLossItemKindNo[i].value==itemkindno){
	           tempSumloss+=parseFloat(fm.prpLpersonLossSumRealPay[i].value);
	        }
	    }
        for(var i=1;i<fm.prpLchargeKindCode.length;i++){
         if(fm.prpLlossDtoItemKindNoForCharge[i].value==itemkindno){
         
             tempSumloss+=parseFloat(fm.prpLchargeChargeAmount[i].value);
           
        }
    }
  }
    if("03,01,22,08,09,ZH".indexOf(fm.prpLcompensateClassCode.value)>-1){
	    for(var i=1;i<fm.prpLlossDtoKindCode.length;i++){
	         if(fm.prpLlossDtoItemKindNo[i].value==itemkindno){
	           tempSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[i].value);
	        }
	    }
        for(var i=1;i<fm.prpLchargeKindCode.length;i++){
         if(fm.prpLlossDtoItemKindNoForCharge[i].value==itemkindno){
         
             tempSumloss+=parseFloat(fm.prpLchargeChargeAmount[i].value);
           
        }
    }
  }
  
  if(("0507,0577,0587".indexOf(fm.prpLcompensateRiskCode.value)>-1||"10,11,YA,26,28,04".indexOf(fm.prpLcompensateClassCode.value)>-1)&&fm.prpLcompensateRiskCode.value!="2606"&&fm.prpLcompensateRiskCode.value!="2609"){
    tempSumloss=parseFloat(fm.prpLcompensateSumPaid.value);
   
  }
   return tempSumloss;
}

//计算此险别的危险单位占总的险别的占比
 function collectDangerShare(field){
    var index = getElementOrder(field)-1;

    var tempSumloss=SumKindcode(fm.prpLdangerUnitItemKindNo[index].value,fm.prpLdangerKindcode[index].value);
	  fm.prpLdangerShare[index].value=pointTwo((pointTwo(fm.prpLdangerUnitSumLoss[index].value)/round(tempSumloss,2))*100);
}

//勾选是否危险单位
function RiskUnitIni(field){
 var index = getElementOrder(field)-1;

      if(field.checked){
           fm.prpLdangerUnitSumLoss[index].readOnly=false;
		   fm.prpLdangerUnitSumLoss[index].className="common";
      }else{
    	 fm.prpLdangerUnitSumLoss[index].readOnly=true;
		 fm.prpLdangerUnitSumLoss[index].className="readonly";
		 fm.prpLdangerUnitSumLoss[index].value=0;
		 fm.prpLdangerShare[index].value=0;
      }
}
   

//危险单位保存校验
function DangerUnitCheck(){

   var tempFlag=true;
   var kindSumloss=0;
   var prpLlossSumloss=0;
   var prpLpersonLossSumloss=0;
   var prpLchargeSumloss=0;
   var dangerSumloss=0;
   var dangerSumlossA=0;
   var tempSumLossA=0;
     
		      
	if(fm.flagDangerUnit.value=="0"){
	   alert("请点击危险单位信息页面下的生成危险单位按钮！");
  	   return false;
    }
    var isChoseDanger=false;

		for( var v=1;v<=getRowsCount("NewDangerUnit");v++){
            if(fm.isRiskUnit[v].checked){
		        isChoseDanger = true;
             }
		}
		if(isChoseDanger==false){
            alert("请选择至少一条危险单位信息！");
            return false;
         }
	
 if("0506".indexOf(fm.prpLcompensateRiskCode.value)>-1){
        var deductibleAall = parseFloat(fm.prpLDeductible.value);
		  if(isNaN(deductibleAall))
		      deductibleAall = 0;
		      
		     for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		            dangerSumloss=0;	
		            if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		             //物损赔款
		             prpLlossSumloss=0;
		             for(var j=1;j<fm.prpLlossDtoKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNo[j].value){
				              prpLlossSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[j].value);
				           }
				               
		               }
		               
		              //人员赔款
		              prpLpersonLossSumloss=0;
			          for(var j=1;j<fm.prpLpersonLossKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLpersonLossItemKindNo[j].value){
				              prpLpersonLossSumloss+=parseFloat(fm.prpLpersonLossSumRealPay1[j].value);
				           }
				        }
				       //费用赔款
				       prpLchargeSumloss=0; 
				       for(var j=1;j<fm.prpLchargeKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNoForCharge[j].value){
						       if((fm.prpLchargeSumRealPay[j].value=="")||parseFloat(fm.prpLchargeSumRealPay[j].value)==0){
					              prpLchargeSumloss+=parseFloat(fm.prpLchargeChargeAmount[j].value);
					           }else{
					             prpLchargeSumloss+=parseFloat(fm.prpLchargeSumRealPay[j].value);
					           }
				           }
				        }
				        
				      if(deductibleAall>0&&fm.prpLdangerKindcode[k].value=="A"){
				          if(round(dangerSumloss,2)!=round(prpLlossSumloss+prpLpersonLossSumloss+prpLchargeSumloss-deductibleAall,2)){
				            alert(fm.prpLdangerKindname[k].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
				            tempFlag=false;
				            break;
			         	 }
				      
				      } else{
		                if(round(dangerSumloss,2)!=round(prpLlossSumloss+prpLpersonLossSumloss+prpLchargeSumloss,2)){
				            alert(fm.prpLdangerKindname[k].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
				            tempFlag=false;
				            break;
			         	 }
			          }
		         }
		          dangerSumloss=0;	
		          for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		         }
		       fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
   }
   
   	
 if("0576,0586".indexOf(fm.prpLcompensateRiskCode.value)>-1){
       var deductibleAall = parseFloat(fm.prpLDeductible.value);
		  if(isNaN(deductibleAall))
		      deductibleAall = 0;
		      
		     for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		            dangerSumloss=0;	
		            if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		             //物损赔款
		             prpLlossSumloss=0;
		             for(var j=1;j<fm.prpLlossDtoKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNo[j].value){
				              prpLlossSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[j].value);
				           }
		               }
		              //人员赔款
		              prpLpersonLossSumloss=0;
			          for(var j=1;j<fm.prpLpersonLossKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLpersonLossItemKindNo[j].value){
				              prpLpersonLossSumloss+=parseFloat(fm.prpLpersonLossSumRealPay1[j].value);
				           }
				        }
				       //费用赔款
				       prpLchargeSumloss=0; 
				       for(var j=1;j<fm.prpLchargeKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNoForCharge[j].value){
						       if((fm.prpLchargeSumRealPay[j].value=="")||parseFloat(fm.prpLchargeSumRealPay[j].value)==0){
					              prpLchargeSumloss+=parseFloat(fm.prpLchargeChargeAmount[j].value);
					           }else{
					             prpLchargeSumloss+=parseFloat(fm.prpLchargeSumRealPay[j].value);
					           }
				           }
				        }
				        
				      if(deductibleAall>0){
				       //调差去掉校验
				          /*var prpLcompensateSumPaid=parseFloat(fm.prpLcompensateSumPaid.value);
						  var tempAll=prpLcompensateSumPaid+deductibleAall;
						  var temp=prpLlossSumloss+prpLpersonLossSumloss+prpLchargeSumloss;
				          if(round(dangerSumloss,2)!=round(temp-(deductibleAall*temp/tempAll),2)){
				             alert(fm.prpLdangerKindname[k].value+"危险单位的估损金额合计与该险别的估损金额合计不一致！");
				             tempFlag=false;
				             break;
			         	 }	*/			      
				      }else{
		                if(round(dangerSumloss,2)!=round(prpLlossSumloss+prpLpersonLossSumloss+prpLchargeSumloss,2)){
				            alert(fm.prpLdangerKindname[k].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
				            tempFlag=false;
				            break;
			         	 }
			          }
		         }
		          dangerSumloss=0;	
		          for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		         }
		       fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
   }   
   
 if("15".indexOf(fm.prpLcompensateClassCode.value)>-1){
		      for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		           dangerSumloss=0;	
		            for(var z=1;z<=getRowsCount('NewDangerUnit');z++){
		              if(fm.isRiskUnit[k].checked&&fm.prpLdangerUnitItemKindNo[k].value==fm.prpLdangerUnitItemKindNo[z].value){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[z].value);
		             }
		            }
		             //物损赔款
		             prpLlossSumloss=0;
		             for(var j=1;j<fm.prpLlossDtoKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNo[j].value){
				              prpLlossSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[j].value);
				           }
		              }
		              //人员赔款
		              prpLpersonLossSumloss=0;
			           for(var j=1;j<fm.prpLpersonLossKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLpersonLossItemKindNo[j].value){
				              prpLpersonLossSumloss+=parseFloat(fm.prpLpersonLossSumRealPay[j].value);
				           }
				        }
				      //费用赔款
				      prpLchargeSumloss=0; 
				      for(var j=1;j<fm.prpLchargeKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNoForCharge[j].value){
						       if((fm.prpLchargeSumRealPay[j].value=="")||parseFloat(fm.prpLchargeSumRealPay[j].value)==0){
					              prpLchargeSumloss+=parseFloat(fm.prpLchargeChargeAmount[j].value);
					           }else{
					             prpLchargeSumloss+=parseFloat(fm.prpLchargeSumRealPay[j].value);
					           }
				           }
				       }
		              if(round(dangerSumloss,2)!=round(prpLlossSumloss+prpLpersonLossSumloss+prpLchargeSumloss,2)){
				            alert(fm.prpLdangerKindname[k].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
				            tempFlag=false;
				            break;
			         }
		         }
		          dangerSumloss=0;	
		          for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		         }
		       fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
   }
   
   
  if("0507,0577,0587".indexOf(fm.prpLcompensateRiskCode.value)>-1){
       dangerSumloss=0;
       for(var z=1;z<=getRowsCount('NewDangerUnit');z++){
        for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
             if(fm.isRiskUnit[k].checked){
                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
             }
         } 
         if(round(dangerSumloss,2)!=round(parseFloat(fm.prpLcompensateSumPaid.value),2)){
             alert(fm.prpLdangerKindname[z].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
             tempFlag=false;
             break;
         }else{
           tempFlag=true;
           break;
         }
       }         
         dangerSumloss=0;	
             for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		         }
		       fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
		       
		       //有的险类在自己的js里有此判断，有的没有在此特别加上
		        if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
				   alert("赔款合计不等于危险单位信息里的实赔金额！");
				   return false;
				 }
   }
   
   if("10,26,28,04".indexOf(fm.prpLcompensateClassCode.value)>-1&&fm.prpLcompensateRiskCode.value!="2606"&&fm.prpLcompensateRiskCode.value!="2609"){
       for(var z=1;z<=getRowsCount('NewDangerUnit');z++){
           dangerSumloss=0;
	        for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
	             if(fm.isRiskUnit[k].checked&&fm.prpLdangerUnitItemKindNo[z].value==fm.prpLdangerUnitItemKindNo[k].value){
	                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
	             }
	         } 
         if(round(dangerSumloss,2)!=round(parseFloat(fm.prpLcompensateSumPaid.value),2)){
             alert(fm.prpLdangerKindname[z].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
             tempFlag=false;
             break;
         }else{
           tempFlag=true;
           break;
         }
       }         
         dangerSumloss=0;	
             for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		         }
		       fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
		       
		       //有的险类在自己的js里有此判断，有的没有在此特别加上
		        if(round(parseFloat(fm.prpLcompensateSumPaid.value),2)!=round(parseFloat(fm.prpLdangerRiskSumPaid.value),2)){
				   alert("赔款合计不等于危险单位信息里的实赔金额！");
				   return false;
				 }
   }
  if("27".indexOf(fm.prpLcompensateClassCode.value)>-1||fm.prpLcompensateRiskCode.value=="2606"||fm.prpLcompensateRiskCode.value=="2609"){
             for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
			          dangerSumloss=0;	
			          for(var i=1;i<=getRowsCount('NewDangerUnit');i++){
			             if(fm.isRiskUnit[k].checked&&fm.prpLdangerUnitItemKindNo[i].value==fm.prpLdangerUnitItemKindNo[k].value){
			                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[i].value);
			             }
			           }
		         
		               prpLpersonLossSumloss=0;
			           for(var j=1;j<fm.prpLpersonLossKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLpersonLossItemKindNo[j].value){
				              prpLpersonLossSumloss+=parseFloat(fm.prpLpersonLossSumRealPay[j].value);
				           }
				        }
				        prpLchargeSumloss=0; 
				        for(var j=1;j<fm.prpLchargeKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNoForCharge[j].value){
						      
					             prpLchargeSumloss+=parseFloat(fm.prpLchargeChargeAmount[j].value);
					           
				           }
				         }
		                if(round(dangerSumloss,2)!=round(prpLpersonLossSumloss+prpLchargeSumloss,2)){
				            alert(fm.prpLdangerKindname[k].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
				            tempFlag=false;
				            break;
			         	}
		       }
		       dangerSumloss=0;	
		       for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		        }
		       fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
   
   }
   if("08,01,03,22,09,ZH".indexOf(fm.prpLcompensateClassCode.value)>-1){
             for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
			          dangerSumloss=0;	
			          for(var i=1;i<=getRowsCount('NewDangerUnit');i++){
			             if(fm.isRiskUnit[k].checked&&fm.prpLdangerUnitItemKindNo[i].value==fm.prpLdangerUnitItemKindNo[k].value){
			                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[i].value);
			             }
			            }
		         
				        prpLlossSumloss=0;
		             	for(var j=1;j<fm.prpLlossDtoKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNo[j].value){
				              prpLlossSumloss+=parseFloat(fm.prpLlossDtoSumRealPay[j].value);
				           }
		                }
				        prpLchargeSumloss=0; 
				        for(var j=1;j<fm.prpLchargeKindCode.length;j++){
				           if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLlossDtoItemKindNoForCharge[j].value){
						      
					             prpLchargeSumloss+=parseFloat(fm.prpLchargeChargeAmount[j].value);
					           
				           }
				        }
		               if(round(dangerSumloss,2)!=round(prpLlossSumloss+prpLchargeSumloss,2)){
				            alert(fm.prpLdangerKindname[k].value+"危险单位的实赔金额合计与该险别的赔偿金额合计不一致！");
				            tempFlag=false;
				            break;
			         	}
		       }
		          dangerSumloss=0;	
		          for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
		             if(fm.isRiskUnit[k].checked){
		                dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
		             }
		          }
		          fm.prpLdangerRiskSumPaid.value=round(dangerSumloss,2);
   
   }

	 return tempFlag;
	
}




