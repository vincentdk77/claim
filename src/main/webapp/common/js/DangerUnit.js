//����Σ�յ�λǰ��У��ͨ����������Σ�յ�λ����
function changFlagDanger(){
	var editType=fm.prpLdangerRiskeditType.value;
	if(editType=="modifyDetail"){
		for(var i=1;i<fm.prpLclaimLossItemKindNo.length;i++){
			if (fm.prpLclaimLossSumClaim[i].value == ''){//���û¼����Ϊ0 
				fm.prpLclaimLossSumClaim[i].value=0;
			}
			if (fm.prpLclaimLossKindCode[i].value == ''||fm.prpLclaimLossKindName[i].value == ''){
				alert("����¼���ձ��������Ϣҳ���µ��ձ���Ϣ��");
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
   *������������¼������һ�����ã��ҷ��ñ������0
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
            alert("�ձ��������Ϣ�б���¼������һ��������Ϣ");
            return false;
        }else if(allFeeLoss == 0 || allFeeLoss < 0){
            alert("�ձ��������Ϣ�з��ù�����������0");
            return false;
        }
        return true;
   }
}


//�����Ƿ���������Σ�յ�λ
function setFlagDanger(){
   fm.flagDangerUnit.value="0";
}

//����Σ�յ�λ��ת����̨����
function flashDangerUnit(){
    var oldAction = fm.action;
    var oldTarget = fm.target;
    fm.action='/claim/DangerUnit.do';
    fm.target="fraSubmit";
    fm.submit();
    fm.action=oldAction;
    fm.target=oldTarget;  
}

//��������ֻ�������ܵ��ձ��⸶���
function SumKindcode(itemkindno){
  var tempSumloss=0;
    for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
  
         if(fm.prpLclaimLossItemKindNo[i].value==itemkindno){
           tempSumloss+=parseFloat(fm.prpLclaimLossSumClaim[i].value);
        }
       
    }
   return tempSumloss;
}


//������ձ��Σ�յ�λռ�ܵ��ձ��ռ��
function collectDangerShare(field){
    var index = getElementOrder(field)-1;
    var tempSumloss=0;
   
    tempSumloss=SumKindcode(fm.prpLdangerUnitItemKindNo[index].value);

	fm.prpLdangerShare[index].value=pointTwo((pointTwo(fm.prpLdangerUnitSumLoss[index].value)/pointTwo(tempSumloss))*100);
	    
}

//��ѡ�Ƿ�Σ�յ�λ
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

//Σ�յ�λ����У��
function DangerUnitCheck(){
   var tempFlag=true;
   var kindSumloss=0;
   var dangerSumloss=0;
	if(fm.flagDangerUnit.value=="0"){
	   alert("����Σ�յ�λ��Ϣҳ���µ�����Σ�յ�λ��ť��");
  	   return false;
    }
	var isChoseDanger=false;

		for( var v=1;v<=getRowsCount("NewDangerUnit");v++){
            if(fm.isRiskUnit[v].checked){
		        isChoseDanger = true;
             }
		}
		if(isChoseDanger==false){
            alert("��ѡ������һ��Σ�յ�λ��Ϣ��");
            return false;
         }
	
	var prpLdangerRiskeditType=fm.prpLdangerRiskeditType.value;
	if(prpLdangerRiskeditType=="modifyDetail"){//�޸���������Σ�յ�λ��У��
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
				alert(fm.prpLclaimLossKindName[i].value+"Σ�յ�λ�Ĺ�����ϼ������ҵ���ձ���⳥���ϼƲ�һ�£�");
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
				alert(fm.prpLclaimLossKindName[i].value+"Σ�յ�λ�Ĺ�����ϼ�����ձ�Ĺ�����ϼƲ�һ�£�");
				tempFlag=false;
				break;
			}
		}
	}
	return tempFlag;
}


