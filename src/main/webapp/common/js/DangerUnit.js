//生成危险单位前的校验通过调用生成危险单位函数
function changFlagDanger(){
	var editType=fm.prpLdangerRiskeditType.value;
	if(editType=="modifyDetail"){
		for(var i=1;i<fm.prpLclaimLossItemKindNo.length;i++){
			if (fm.prpLclaimLossSumClaim[i].value == ''){//如果没录入则为0 
				fm.prpLclaimLossSumClaim[i].value=0;
			}
			if (fm.prpLclaimLossKindCode[i].value == ''||fm.prpLclaimLossKindName[i].value == ''){
				alert("请先录入险别估损金额信息页面下的险别信息！");
				return false;
			}
		}
		fm.flagDangerUnit.value=1;
	}else{
  		if("27,01,03,04,08,15,22,26,ZH,28".indexOf(fm.prpLclaimClassCode.value)>-1){
			if(checkExes()==true){
				fm.flagDangerUnit.value="1";
			}
		}
		if("05".indexOf(fm.prpLclaimClassCode.value)>-1){
			if(checkLoss()==true&&checkCar()==true){
				fm.flagDangerUnit.value="1";
			}
		}
		if("09,10,11,YA".indexOf(fm.prpLclaimClassCode.value)>-1){
			if(checkExes()==true&&checkLoss()==true){
				fm.flagDangerUnit.value="1";
			}
		}
	}

	if(fm.flagDangerUnit.value=="1"){
		flashDangerUnit();
	}
}


function checkCar(){

   /*
   *控制立案必须录入至少一条费用，且费用必须大于0
   */
   if(fm.all("prpLclaimLossLossFeeType") != null){
        var allFeeLoss = 0;
        var FeeLoss = 0;
        var isInputFee = false;
        for(var i = 0;i < fm.all("prpLclaimLossLossFeeType").length;i++){
            if(fm.all("prpLclaimLossLossFeeType")[i].value == "Z" && fm.all("prpLclaimLossSumClaim")[i] != null){
                isInputFee = true;
                FeeLoss = parseFloat(fm.all("prpLclaimLossSumClaim")[i].value);
                if(isNaN(FeeLoss))
                    FeeLoss = 0;
                allFeeLoss = allFeeLoss + FeeLoss;
            }
        }
        if(!isInputFee){
            alert("险别估损金额信息中必须录入至少一条费用信息");
            return false;
        }else if(allFeeLoss == 0 || allFeeLoss < 0){
            alert("险别估损金额信息中费用估损金额必须大于0");
            return false;
        }
        return true;
   }
}


//设置是否重新生成危险单位
function setFlagDanger(){
   fm.flagDangerUnit.value="0";
}

//生成危险单位跳转到后台处理
function flashDangerUnit(){
    var oldAction = fm.action;
    var oldTarget = fm.target;
    fm.action='/claim/DangerUnit.do';
    fm.target="fraSubmit";
    fm.submit();
    fm.action=oldAction;
    fm.target=oldTarget;  
}

//计算此险种或险类的总的险别赔付金额
function SumKindcode(itemkindno){
  var tempSumloss=0;
    for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
  
         if(fm.prpLclaimLossItemKindNo[i].value==itemkindno){
           tempSumloss+=parseFloat(fm.prpLclaimLossSumClaim[i].value);
        }
       
    }
   return tempSumloss;
}


//计算此险别的危险单位占总的险别的占比
function collectDangerShare(field){
    var index = getElementOrder(field)-1;
    var tempSumloss=0;
   
    tempSumloss=SumKindcode(fm.prpLdangerUnitItemKindNo[index].value);

	fm.prpLdangerShare[index].value=pointTwo((pointTwo(fm.prpLdangerUnitSumLoss[index].value)/pointTwo(tempSumloss))*100);
	    
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
   var dangerSumloss=0;
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
	
	var prpLdangerRiskeditType=fm.prpLdangerRiskeditType.value;
	if(prpLdangerRiskeditType=="modifyDetail"){//修改立案生成危险单位的校验
		for(var i=1;i<fm.prpLclaimLossItemKindNo.length;i++){
			kindSumloss=0;
				for(var j=1;j<fm.prpLclaimLossItemKindNo.length;j++){
					if(fm.prpLclaimLossItemKindNo[i].value==fm.prpLclaimLossItemKindNo[j].value&&(fm.ClaimLossFlag[j].value=="I"||fm.prpLclaimLossInputDate[j].value=="")){
						kindSumloss+=parseFloat(fm.prpLclaimLossSumClaim[j].value);
					}
				}
			dangerSumloss=0;	
			for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
				if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLclaimLossItemKindNo[i].value&&fm.isRiskUnit[k].checked){
					dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
				}
			}
			if(round(kindSumloss,2)!=round(dangerSumloss,2)){
				alert(fm.prpLclaimLossKindName[i].value+"危险单位的估损金额合计与该商业险险别的赔偿金额合计不一致！");
				tempFlag=false;
	            break;
			}
		}
	}else{
		for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
			kindSumloss=0;
			for(var j=1;j<fm.prpLclaimLossCurrency.length;j++){
				if(fm.prpLclaimLossItemKindNo[i].value==fm.prpLclaimLossItemKindNo[j].value){
					kindSumloss+=parseFloat(fm.prpLclaimLossSumClaim[j].value);
				}
			}
			dangerSumloss=0;	
			for(var k=1;k<=getRowsCount('NewDangerUnit');k++){
				if(fm.prpLdangerUnitItemKindNo[k].value==fm.prpLclaimLossItemKindNo[i].value&&fm.isRiskUnit[k].checked){
					dangerSumloss+=parseFloat(fm.prpLdangerUnitSumLoss[k].value);
				}
			}
			if(round(kindSumloss,2)!=round(dangerSumloss,2)){
				alert(fm.prpLclaimLossKindName[i].value+"危险单位的估损金额合计与该险别的估损金额合计不一致！");
				tempFlag=false;
				break;
			}
		}
	}
	return tempFlag;
}


