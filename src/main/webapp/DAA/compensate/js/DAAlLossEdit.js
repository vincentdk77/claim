/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     : liubvo
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


/**
 * ����һ���µ�lLoss֮��Ĵ�����ѡ������
 */
 function afterInsertlLoss()
 {
   setPrpLlossSerialNo();
 }

 /*
   ɾ������WarnRegion֮��Ĵ�����ѡ������
 */
 function afterDeletelLoss(field)
 {

   setPrpLlossSerialNo();
 }

   /**
    * ����setPrpLlLossLossSerialNo
    */
   function setPrpLlossSerialNo(){
       var count=getElementCount("prpLlossDtoSerialNo");
       for(var i=0;i<count;i++)
       {
           if(count!=1){
               fm.prpLlossDtoSerialNo[i].value=i;
           }
       }
   }

 /**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowTableL(pageCode,dataPageCode,field,kindCode,trueKindCode,trueKindName,itemKindNo,dutyDeductibleRate,deductibleRate,driverDeductibleRate,unitAmount,amount)
{
  var index = 0;  //��ǰtable����
  var elements = null;
  var numIndex = 0;
  index = getElementOrder(field)-1;
  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(kindCode);
  elements = oTBODY.getElementsByTagName("INPUT");

  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="lossDtoSerialNo")
  	{
  		elements[i].value = index;
  	}
  } 
  
  var newField;
  var tempElements=oTBODY.getElementsByTagName("INPUT"); 
  for(var j=0;j<tempElements.length;j++)
  {
    if(tempElements[j].name=="prpLlossDtoKindCode"){
      newField=tempElements[j];
    }
  }
  index = getElementOrder(newField) -1;
  
  fm.prpLlossDtoKindCode[index].value=trueKindCode;
  fm.prpLlossDtoKindName[index].value=trueKindName;

  //�����¹����α���Ϊ�ð����¹����α���
  fm.prpLlossDtoIndemnityDutyRate[index].value=fm.prpLcompensateIndemnityDutyRate.value;  
  
  if (fm.prpLlossDtoKindCode[index-1].value != fm.prpLlossDtoKindCode[index].value ){
  	  fm.prpLicenseNo[index].value= "";
  }
  else {
      fm.prpLicenseNo[index].value= fm.prpLicenseNo[index-1].value;	
  }
  //add by Pao reason:û�гб����������ձ�Ӧ���㲻������
  for(var k = 0 ;k < fm.all("noDutyFlagForPersonLoss").length;k++){
        if(trueKindCode == fm.all("prpLlossDtoKindCodeShow")[k].value){
            fm.prpLlossFlag[index].value = fm.noDutyFlagForPersonLoss[k].value;
        }
  }
  for(var i = 0 ;i < fm.all("DutyDeductibleRate").length;i++){
        if(trueKindCode == fm.all("prpLlossDtoKindCodeShow")[i].value){
            fm.prpLlossDtoDutyDeductibleRate[index].value = fm.all("DutyDeductibleRate")[i].value;
            fm.prpLlossDtoDeductibleRate[index].value = fm.all("DeductibleRate")[i].value;
            break;
        }
  }
  fm.prpLlossDtoItemKindNo[index].value = itemKindNo;
  //fm.prpLlossDtoDutyDeductibleRate[index].value = dutyDeductibleRate;
 // fm.prpLlossDtoDeductibleRate[index].value = deductibleRate;
  fm.prpLlossDtoDriverDeductibleRate[index].value = driverDeductibleRate;
  fm.prpLlossDtoUnitPrice[index].value = unitAmount;
  fm.prpLlossDtoAmount[index].value = amount;
}

/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowTableL(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.lossDtoSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowCurrPageL(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }

  calRealpayForDuBang(field);
  calLoss();
  return recentDeletedRowNo-1;
}

//�õ���ǰ�������ڵ�ǰҳλ��
function getRowCurrPageL(field,DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //��Ա���õļ�¼��
  var firstIndexLoss = 0 ;   //����Ա�ķ��õ���ʼindex
  var recentRowNo =  0;
  var orderCurrent = 0  ;    //��ǰ�����ڵ�ǰ���λ��
  recentRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.lossDtoSerialNo(recentRowNo-1).value);

  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("lLoss");

  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
  	if(elements[i].name  == "lossDtoSerialNo")
  	{

  		if(parseInt(elements[i].value)==pageLossSerialNo)
  		{
  			countLoss = countLoss + 1;
  			if(firstIndexLoss==0)
  			{
  				firstIndexLoss = getElementOrder(elements[i]);
  			}
  		}
  	}
  }

  orderCurrent = recentRowNo - firstIndexLoss;
  return orderCurrent;
}



function setlossSumDefPay(field){
	
  var serialNo=0; //��λ
  var fieldName = field.name;
  for ( var i=1; i<fm.all(fieldName).length;i++ ){
    if (field==fm.all(fieldName)[i]){
       serialNo=i;
       break;
    }
  }
  
  
  var sumLoss =parseFloat(fm.prpLlossDtoSumLoss[serialNo].value);
  var sumRest = parseFloat(fm.prpLlossDtoSumRest[serialNo].value);
  
    if(isNaN(sumRest)){
       sumRest = 0;
    }
    
    if(isNaN(sumLoss)){ 
     	 sumLoss = 0;
    }
    
  var sumDefPay =sumLoss- sumRest ;
  
  fm.prpLlossDtoSumDefPay[serialNo].value= point(round(sumDefPay,2),1);
  

}

 function loadCarCharge(riskcode,isCoinsClaim)
 {
      /*1��������ҵ�� 100�� 
        2��������ǿ�� 100�� 
        3����ҵ�ս�ǿ�չ������⽻ǿ���Զ����� 100����ҵ���Զ�����50*/
     //�����δ���������� �鿱�� ������Ϣ����������ڴ��������� 
     if(fm.prpLcompensateCompensateNo.value=='')
     {
     	insertRow('Charge');
     	//fm.prpLchargeChargeCode[1].value='04';
     	//fm.prpLchargeChargeName[1].value='�鿱��';
     	//fm.prpLchargeChargeName[1].disabled = true;
     
     	//��ǿ�ղ鿱�� 100
     	if(riskcode=='0507'||riskcode=='0577'||riskcode=='0587')
     	{
        	fm.prpLchargeChargeReport[1].value='0.00';
        	fm.prpLchargeChargeAmount[1].value='0.00';
        	fm.prpLcompensateSumNoDutyFee.value='0.00';
     	}
     
     	//��ҵ�շ� �Ƿ�������� 
     	if((riskcode=='0506'||riskcode=='0576'||riskcode=='0586')&&isCoinsClaim=='0')
     	{
        	fm.prpLchargeChargeReport[1].value='0.00';
        	fm.prpLchargeChargeAmount[1].value='0.00';  
        	fm.prpLcompensateSumNoDutyFee.value='0.00'
     	}
     	//����
     	else if((riskcode=='0506'||riskcode=='0576'||riskcode=='0586')&&isCoinsClaim=='1')
     	{
     		fm.prpLchargeChargeReport[1].value='0.00';
     		fm.prpLchargeChargeAmount[1].value='0.00';
     		fm.prpLcompensateSumNoDutyFee.value='0.00';
     	}
     
     	//���"-"��ť
     	fm.buttonChargeDelete[1].disabled = true;
        return true;
      }
 }
