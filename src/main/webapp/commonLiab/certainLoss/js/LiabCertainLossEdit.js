/*****************************************************************************
 * DESC       ������ǼǵĽű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-10-13
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ��鶨��Ǽ�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function checkForm()
{
    return true;
}

/**
 *@description �ύ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
 *@description ����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function resetForm()
{
  if(window.confirm("ȷ��Ҫ������"))
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
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function saveForm(field,saveType)
{
  fm.buttonSaveType.value = saveType;
  
  /*
	if(checkPropKindCode()==false)
  return false;     
  */
  
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 /*
 if(!validateForm(fm,'PersonFeeLoss_Data,Person_Data,Prop_Data'))
  {
    return false;
  }
*/
  if(!validateForm(fm,'Prop_Data'))
  {
    return false;
  }
  
  if(fm.prpLverifyLossRiskCode.value=="1528"){
    var claimLossLen = fm.prpLpropKindCode.length;
     for(var i = 1; i < claimLossLen; i++) {
       if(fm.prpLpropBrandCode[i].value==""||fm.prpLpropCarNumber[i].value==""){
         alert("�����ֵ��¹ʳ�����Ϣ����Ϊ�գ�");
         return false;
       }
    }
  }
  
  
  
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	 
}

/**
 @author      liubvo
 @description У���ձ�
 @return      boolean: �Ϸ�Ϊtrue,����Ϊfalse  
 */

function checkPropKindCode()
{     
  //У��¼���ձ�
  //ֻ��¼�������ձ�  
  //������������--B��
  //���ϻ���������--D2��
  //���ػ������������--H��
  if(fm.prpLpropKindCode.length>0){
    for(i=1;i<fm.prpLpropKindCode.length;i++){
      var kindCode = fm.prpLpropKindCode[i].value;
      if(kindCode!="B" && kindCode!="D2" && kindCode!="H")
      {
        errorMessage("�Ʋ���ʧ��Ŀ��,ֻ��¼��B��D2��H �����ձ����ʧ��");         
        //fm.prpLpropKindCode[i].focus();       
      	//fm.prpLpropKindCode[i].select();
        return false; 
      }    
    }  
  }
  return true;
} 

/**
 *@description �������Ա���ҳ��
 *@param       ��
 */

function openWinSave(){
   
   var businessNo = fm.RegistNo.value;
   var policyNo = fm.prpLverifyLossPolicyNo.value; 
   var riskCode = fm.prpLverifyLossRiskCode.value;
   var claimNo = fm.prpLverifyLossClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=certa&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");

}

/**
 *@description �����鿴����ҳ��
 *@param       ��
 */

function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.RegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}

/**
 *@description ʵ������������Ա�����õ���ʾ�任
 *@param       spanID span���
 *@param       spanName span������
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
  
/**
 *@description ���ݹ�ʱ����ʱ���ۺͲ��Ϸ��ü��㶨����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
    sumDefLoss = manHourFee*ManHour + materialFee;    
    fm.all("prpLrepairFeeSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);
    sumRepairFee();
  } else {    
    
    quantity  = parseFloat(fm.all("prpLcomponentQuantity")[findex].value)      
    manHourFee = parseFloat(fm.all("prpLcomponentManHourFee")[findex].value); 
    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[findex].value);
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
    sumDefLoss = parseFloat(point(round(quantity*manHourFee,2),2)) + parseFloat(point(round(materialFee,2),2));    
    fm.all("prpLcomponentSumDefLoss")[findex].value = point(round(sumDefLoss,2),2); 
    sumComponentFee();
  }
 
  //fm.all("prpLrepairFeeSumDefLoss")[findex].value = 1111;  
  //��Ӧ�Ļ��� 
  
  return true;  
       
 } 

/**
 *@description ��������Ѽ���
 *@param       ��
 *@return      ��
 */ 
  function sumRepairFee()
  {
   var sumRepairDefFee = 0 ;//���������
   var sumManHourFee  = 0 ; //�ܹ�ʱ��
   var sumMaterialFee = 0 ; //�ܲ��Ϸ�
   var repairFeeManHour = 0 ;
   var repairFeeManHourUnitPrice = 0 ;
   var repairFeeMaterialFee = 0 ;
   if(fm.all("SumDefLoss1").length>0){ 
     for(j=0;j<fm.all("SumDefLoss1").length;j++){
       for(i=1;i<fm.all("prpLrepairFeeManHour").length;i++){ 
        //alert(fm.all("SumDefLoss1")[j].length +":1111:"+fm.all("carLossRepairFeeLossItemCode")[i].value)
          if(j == fm.all("carLossRepairFeeLossItemCode")[i].value){
       	    repairFeeManHour = parseFloat(fm.all("prpLrepairFeeManHour")[i].value);
       	    repairFeeManHourUnitPrice = parseFloat(fm.all("prpLrepairFeeManHourUnitPrice")[i].value);
       	    repairFeeMaterialFee = parseFloat(fm.all("prpLrepairFeeMaterialFee")[i].value);
      	   	if(isNaN(repairFeeManHour)){
      	      repairFeeManHour = 0;
      	    } 
      	    if(isNaN(repairFeeManHourUnitPrice)) {
      	      repairFeeManHourUnitPrice = 0;
      	    }
      	    if(isNaN(repairFeeMaterialFee)){
      	      repairFeeMaterialFee = 0;
      	    }
            sumManHourFee   = sumManHourFee + parseFloat(point(round(repairFeeManHour*repairFeeManHourUnitPrice,2),2));
            sumMaterialFee  = sumMaterialFee + parseFloat(point(round(repairFeeMaterialFee,2),2));
            sumRepairDefFee = sumManHourFee+sumMaterialFee;
         }
       }     
       fm.all("SumDefLoss1")[j].value     = sumRepairDefFee;
       fm.all("SumManHourFee1")[j].value  = sumManHourFee;
       fm.all("SumMaterialFee1")[j].value = sumMaterialFee;
       sumRepairDefFee = 0 ;
       sumManHourFee  = 0 ; 
       sumMaterialFee = 0 ;
       sumPreDefLoss();    
     }
   } else {
     for(i=1;i<fm.all("prpLrepairFeeManHour").length;i++){
     	    repairFeeManHour = parseFloat(fm.all("prpLrepairFeeManHour")[i].value);
     	    repairFeeManHourUnitPrice = parseFloat(fm.all("prpLrepairFeeManHourUnitPrice")[i].value);
     	    repairFeeMaterialFee = parseFloat(fm.all("prpLrepairFeeMaterialFee")[i].value);
  	   	if(isNaN(repairFeeManHour)){
  	      repairFeeManHour = 0;
  	    }
  	    if(isNaN(repairFeeManHourUnitPrice)) {
  	      repairFeeManHourUnitPrice = 0;
  	    }
  	    if(isNaN(repairFeeMaterialFee)){
  	      repairFeeMaterialFee = 0;
  	    }
          
          sumManHourFee   = sumManHourFee + parseFloat(point(round(repairFeeManHour*repairFeeManHourUnitPrice,2),2));
          sumMaterialFee  = sumMaterialFee + parseFloat(point(round(repairFeeMaterialFee,2),2));
          sumRepairDefFee = sumManHourFee+sumMaterialFee;
  
     }
     fm.SumDefLoss1.value     = sumRepairDefFee;
     fm.SumManHourFee1.value  = sumManHourFee;
     fm.SumMaterialFee1.value = sumMaterialFee;
     sumPreDefLoss();
     }
   return true;
  } 

/**
 *@description ���ܻ����Ѽ��� 
 *@param       ��
 *@return      ��
 */ 
  function sumComponentFee() 
  {
   var sumComponentDefFee = 0 ;//�ܻ��������
   var sumComponentManHourFee  = 0 ; //�ܹ�ʱ��
   var sumComponentMaterialFee = 0 ; //�ܲ��Ϸ�
   var quantity = 0 ;
   var manHourFee = 0 ;
   var materialFee = 0 ;

   if(fm.all("SumDefLoss2").length>0){ 
     for(j=0;j<fm.all("SumDefLoss2").length;j++){
       for(i=1;i<fm.all("prpLcomponentQuantity").length;i++){
          if(j == fm.all("carLossComponentLossItemCode")[i].value){
       	    quantity = parseFloat(fm.all("prpLcomponentQuantity")[i].value);
       	    manHourFee = parseFloat(fm.all("prpLcomponentManHourFee")[i].value);
       	    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);
      	   	if(isNaN(quantity)||quantity.length<1){ 
      	      quantity = 0;
      	    }
      	    if(isNaN(manHourFee)||manHourFee.length<1) {
      	      manHourFee = 0;
      	    }
      	    if(isNaN(materialFee)||materialFee.length<1){ 
      	      materialFee = 0;
      	    }
            sumComponentManHourFee   = sumComponentManHourFee + parseFloat(point(round(quantity*manHourFee,2),2));
            sumComponentMaterialFee  = sumComponentMaterialFee + parseFloat(point(round(materialFee,2),2));
            //alert(sumComponentManHourFee+"::00::"+sumComponentManHourFee);
            sumComponentDefFee = sumComponentManHourFee+sumComponentMaterialFee;
         }
       }
       fm.all("SumDefLoss2")[j].value = point(round(sumComponentDefFee,2),2);
       fm.all("SumManHourFee2")[j].value = point(round(sumComponentManHourFee,2),2);
       fm.all("SumMaterialFee2")[j].value = point(round(sumComponentMaterialFee,2),2);
       sumComponentDefFee = 0 ;
       sumComponentManHourFee  = 0 ;
       sumComponentMaterialFee = 0 ;       
       sumPreDefLoss();
     }
   } else {   
     for(i=1;i<fm.all("prpLcomponentQuantity").length;i++)
     {
     	    quantity = parseFloat(fm.all("prpLcomponentQuantity")[i].value);
     	    manHourFee = parseFloat(fm.all("prpLcomponentManHourFee")[i].value);
     	    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);
  	   	if(isNaN(quantity)){
  	      quantity = 0;
  	    }
  	    if(isNaN(manHourFee)) {
  	      manHourFee = 0;
  	    }
  	    if(isNaN(materialFee)){
  	      materialFee = 0;
  	    }
          
          sumComponentManHourFee   = sumComponentManHourFee + parseFloat(point(round(quantity*manHourFee,2),2));
          sumComponentMaterialFee  = sumComponentMaterialFee + parseFloat(point(round(materialFee,2),2));
          sumComponentDefFee = sumComponentManHourFee+sumComponentMaterialFee;
     }
     fm.SumDefLoss2.value = point(round(sumComponentDefFee,2),2);
     fm.SumManHourFee2.value = point(round(sumComponentManHourFee,2),2);
     fm.SumMaterialFee2.value = point(round(sumComponentMaterialFee,2),2);
     sumPreDefLoss();
   }   
   return true;
  }  
/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
 
  var sumloss    = "prpLpropSumLoss";
  var sumreject  = "prpLpropSumReject";
  var sumdefloss = "prpLpropSumDefLoss";
  var sumvalue;
  var sumallvalue;    
 
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
  fm.prpLpropSumSumReject.value=point(round(sumallvalue,2),2); 
  
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
  fm.prpLpropSumSumDefLoss.value=point(round(sumallvalue,2),2); 
  //sumRepairFee();
  //sumComponentFee();
  sumPersonLossFee();
  sumPreDefLoss();
  return true;
} 

/**
 *@description �����ܵĶ�����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 
 
 function sumPreDefLoss()
 {
 	var sumPropLoss       = 0 ;//�Ʋ�
 	//var sumRepairLoss     = 0 ;//����
 	//var sumComponentLoss  = 0 ;//����
 	var sumPersonLoss=0 ;      //��Ա
 
 	var sumPreDefLoss     = 0 ;
 	sumPropLoss = fm.prpLpropSumSumDefLoss.value;
 	if(isNaN(sumPropLoss))
 	  sumPropLoss = 0 ;  
     
 	//sumPersonLoss = fm.sumPersonLoss.value;//��Ա�����ܺ�δ��
 	//if(isNaN(sumPersonLoss))  
 	//  sumPersonLoss = 0 ;  
 	  	//alert(sumRepairLoss+"::00::"+sumPropLoss+"::00::"+sumComponentLoss+"::00::"+sumPersonLoss);  
 	sumPreDefLoss = parseFloat(sumPropLoss)+parseFloat(sumPersonLoss);
 	//fm.prpLverifyLossSumPreDefLoss.value = sumPreDefLoss;
 	//alert(fm.prpLverifyLossSumPreDefLoss.value);
 }   
  

/**
 @description ������Ա���������嵥������
 @param       Field: ������ 
 @return      ��     
 @see         calculateAll
*/   
function calSumPersonDefLoss(Field)
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
  
  sumLoss    = parseFloat(fm.all("prpLpersonSumLoss")[findex].value);      
  sumReject  = parseFloat(fm.all("prpLpersonSumReject")[findex].value); 
  
  if(isNaN(sumLoss))
    sumLoss = 0;
  if(isNaN(sumReject))
    sumReject = 0;
  
  if(sumLoss==0 && sumReject==0 )
    return;                    
  
  sumDefLoss = sumLoss - sumReject; 
  
  fm.all("prpLpersonSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);        
  sumPersonLossFee();              
} 

  /**
   *@description ������Ա�������ü��� 
   *@param       ��
   *@return      ��
   */ 
  function sumPersonLossFee()   
  { 
    /**********************/
    var prpLpersonSumLossSum = 0 ;        //������
    var prpLpersonSumRejectSum  = 0 ;     //�޳����
    var prpLpersonSumDefLossSum = 0 ;     //������ 
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
      for(j=0;j<fm.all("prpLpersonSumLossSum").length;j++){
        for(i=1;i<fm.all("prpLpersonSumLoss").length;i++){
          if(j == (fm.all("personSerialNo")[i].value-1)){
            sumLoss = parseFloat(fm.all("prpLpersonSumLoss")[i].value); 
            sumReject = parseFloat(fm.all("prpLpersonSumReject")[i].value); 
            sumDefLoss = parseFloat(fm.all("prpLpersonSumDefLoss")[i].value); 
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
        prpLpersonSumLossSum = 0 ;        //������
        prpLpersonSumRejectSum  = 0 ;     //�޳����
        prpLpersonSumDefLossSum = 0 ;     //������ 
        sumPreDefLoss();   
      } 
      
    } else if(vlength==0){
      //alert("222222222222222222222");       
    } else {
      for(i=1;i<fm.all("prpLpersonSumLoss").length;i++)
      {
          sumLoss = parseFloat(fm.all("prpLpersonSumLoss")[i].value); 
          sumReject = parseFloat(fm.all("prpLpersonSumReject")[i].value); 
          sumDefLoss = parseFloat(fm.all("prpLpersonSumDefLoss")[i].value); 
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
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relate(){	
		var policyNo = fm.PolicyNo.value;
		var registNo = fm.RegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
    //newWindow.focus = true; 

}    