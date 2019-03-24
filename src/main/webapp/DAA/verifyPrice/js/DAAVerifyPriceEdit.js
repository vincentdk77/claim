/*****************************************************************************
 * DESC       ���˼۵ǼǵĽű�����ҳ��
 * AUTHOR     ��sunchenggang
 * CREATEDATE ��2006-03-07
 * MODIFYLIST ��   Name       Date            Reason/Contents
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
 
 function setIdEstimateLoss3()
{

}

function insertRowCertainLossExt(RowCode){
  insertRow(RowCode);

  var element1 = document.getElementsByName('prpLverifyLossExtTitle');
  var i = element1.length - 1;
    
  if(fm.nodeType.value=="verip" || fm.nodeType.value=="verpo" ){
    if(fm.verpOpinion.value=="01")
      fm.prpLverifyLossExtTitle[i].value = "ͬ�ⶨ��";
    else if(fm.verpOpinion.value=="02")
      fm.prpLverifyLossExtTitle[i].value = "������Ϣ";
    else if(fm.verpOpinion.value=="03")
      fm.prpLverifyLossExtTitle[i].value = "�۸����鷢��";
    else if(fm.verpOpinion.value=="04")
      fm.prpLverifyLossExtTitle[i].value = "�۸�������";
    else if(fm.verpOpinion.value=="05")
      fm.prpLverifyLossExtTitle[i].value = "����ѯ��";
  }

  if(fm.nodeType.value=="verif"){
    if(fm.verifyOpinion.value=="01")
      fm.prpLverifyLossExtTitle[i].value = "ͬ�ⶨ��";
    else if(fm.verifyOpinion.value=="02")
      fm.prpLverifyLossExtTitle[i].value = "�۸�����";
    else if(fm.verifyOpinion.value=="03")
      fm.prpLverifyLossExtTitle[i].value = "��Ϣ�����";
    else if(fm.verifyOpinion.value=="04")
      fm.prpLverifyLossExtTitle[i].value = "���߼��鱨��";
    else if(fm.verifyOpinion.value=="05")
      fm.prpLverifyLossExtTitle[i].value = "����";
    
  }
}

 
/**
 *@description �ؿ���ʼ����ֻ��������
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initReadonly()
{
  if(fm.comLevel.value!="1") //�ܹ�˾
    setReadonlyOfElementOfLoss(fm.prpLcarLossSumVeriManager);   
      
  //setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairFactoryCode);     
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairFactoryName);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairStartDate);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairEndDate);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeHandlerCode);   
  setReadonlyOfElementOfLoss(fm.prpLrepairFeeHandlerName);   
    
  //setReadonlyOfElementOfLoss(fm.verifyOpinion);      
  setReadonlyOfElementOfLoss(fm.prpLverifyLossVerifyRemark);  
      
  var element1 = document.getElementsByName('prpLcomponentKindCode');
  if(element1.length>1)  {
    for(i=1;i<element1.length;i++)
    {
      setReadonlyOfElementOfLoss(fm.prpLcomponentKindName[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentCompName[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentOriginalId[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentFirstMaterialFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentMaterialFee[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSys4SPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSysMarketPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentSysMatchPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNative4SPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNativeMarketPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentNativeMatchPrice[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentQuantity[i]); 
      setReadonlyOfElementOfLoss(fm.prpLcomponentRemark[i]); 
      setReadonlyOfElementOfLoss(fm.buttonComponentDelete[i]);
    }
  }   
    
  var element2 = document.getElementsByName('prpLrepairFeeKindCode');
  if(element2.length>1)  {
    for(j=1;j<element2.length;j++)
    { 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeKindName[j]);  
      //setReadonlyOfElementOfLoss(fm.prpLrepairFeePartCode[j]);  
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeCompName[j]); 
      //setReadonlyOfElementOfLoss(fm.prpLrepairFeeRepairType[j]); 
      
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeManHour[j]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeManHourUnitPrice[j]); 
      setReadonlyOfElementOfLoss(fm.prpLrepairFeeRemark[j]); 
      
      setReadonlyOfElementOfLoss(fm.buttonRepairFeeDelete[j]);
      
    }   
  } 
  
  setReadonlyOfElementOfLoss(fm.buttonRepairFee);
  setReadonlyOfElementOfLoss(fm.buttonGetFittings);
  setReadonlyOfElementOfLoss(fm.buttonComponentInsert);
  
 
  if(fm.nodeType.value=="verpo"){ //����ѯ��
    tdNextHandleDept.innerHTML = "";
    fm.nextDeptName.style.display = "none";
    //tdnextHandlerCode.innerHTML = "";
    fm.nextHandlerName.style.display = "none";
    
  }    

  return true; 
} 


/**
 @author      ��ɸ�
 @description ʹһ������������Ϊֻ��
 @param       iElement: ��   
 @return      ��
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
 *@description ����ǲ��ǿ��԰��ύ��ť
 *@return      ͨ������true,���򷵻�false
 */
 function checkSubmitButton()
 {
    var msg = fm.prpLverifyLossVerifyPriceOuterMsg.value;
    var sglCusCompP = parseFloat(fm.prpLclaimGradeSglCusCompP.value);   //�����Զ�������۸�
    var sglCarCusCompP = parseFloat(fm.prpLclaimGradeSglCarCusCompP.value);  //�����Զ�������۸�
    var sglCarAllCompP = parseFloat(fm.prpLclaimGradeSglCarAllCompP.value);  //����ȫ������۸�
    
    var cusCompPTmp = 0;        //ҳ����һ���Զ�������۸� ��Ӧ�ϱ��۸�
    var sglCusCompPTmp = 0;     //ҳ���ϵ����Զ�������۸� ��Ӧ�ϱ��۸�/����
    var SumSglCarCusCompP = 0;  //�����Զ�������۸�
    var SumSglCarAllCompP = 0;  //����ȫ������۸񣬰�������
    var componentQuantity = 1;  //ҳ����һ���Զ���������� ��Ӧ����
    
   
    if(isNaN(sglCusCompP)) sglCusCompP = 0;
    if(isNaN(sglCarCusCompP)) sglCarCusCompP = 0;
    if(isNaN(sglCarAllCompP)) sglCarAllCompP = 0;
                
     if (msg=="") {     
      var element1 = document.getElementsByName('prpLcomponentKindCode');
      if(element1.length>1)  {
        for(i=1;i<element1.length;i++)
        {
          cusCompPTmp = parseFloat(fm.prpLcomponentMaterialFee[i].value); 
          componentQuantity = fm.prpLcomponentQuantity[i].value ;
           if(isNaN(componentQuantity)) { componentQuantity=1;}
          
          if(isNaN(cusCompPTmp)) {
          	 cusCompPTmp = 0;
          	 sglCusCompPTmp=0;
          }else {
          	sglCusCompPTmp =cusCompPTmp /componentQuantity;
          }	

          //�����ܵĵ����Զ�������۸�
          if(fm.prpLcomponentFlag[i].value='0'){
            if(sglCusCompPTmp>sglCusCompP){
            	 alert("�����Զ�������۸񳬳��˼�Ȩ��,��������ѯ��!");
              return false;              
            }
             SumSglCarCusCompP = SumSglCarCusCompP + cusCompPTmp;  //�����Զ���=ÿ���Զ����ϱ��۸���ۼ�
          }
          
           SumSglCarAllCompP = SumSglCarAllCompP + cusCompPTmp;    //����ȫ�� = ÿ���ϱ��۸���ۼ�        
        }
      }  
          
      if(SumSglCarCusCompP>sglCarCusCompP ){
        alert("�����Զ�������۸�֮�ͳ����˼�Ȩ��,��������ѯ��!");
        return false;
      }
       
      if( SumSglCarAllCompP>sglCarAllCompP){
        alert("����ȫ������۸�֮�ͳ����˼�Ȩ��,��������ѯ��!");
        return false;
      }

   }
    
    return true;
}


/**
 *@description ���˼۵Ǽ�
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

function change(){
  var element = document.getElementsByName('prpLverifyLossExtTitle');
  var i = element.length - 1;
  if(fm.verpOpinion.value=="01")
      fm.prpLverifyLossExtTitle[i].value = "ͬ�ⱨ��";
    else if(fm.verpOpinion.value=="02")
      fm.prpLverifyLossExtTitle[i].value = "������Ϣ";
    else if(fm.verpOpinion.value=="03")
      fm.prpLverifyLossExtTitle[i].value = "�۸����鷢��";
    else if(fm.verpOpinion.value=="04")
      fm.prpLverifyLossExtTitle[i].value = "�۸�������";
    else if(fm.verpOpinion.value=="05")
      fm.prpLverifyLossExtTitle[i].value = "����ѯ��";
    else if(fm.verpOpinion.value=="99")
      fm.prpLverifyLossExtTitle[i].value = "����";
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
  //var element = document.getElementsByName('prpLverifyLossExtTitle');
   //var i = element.length - 1;
  //if(fm.prpLverifyLossExtTitle[i].value == ""){
    //alert("������˼������");
    //return false;
  //}
  
  //�õ��˼����  
  //var verpOpinion = trim(fm.verpOpinion.value);
          
  //�ύУ��
  //if (saveType=="4"){
    //����˼�
  	//if(fm.nodeType.value=="verpo"){
  	 // if(verpOpinion=="04" || verpOpinion=="05"){  //�۸�������������ѯ��  	
     //   errorMessage("�������˼�����ʱ�˼����������ѡ�񡰼۸���������������ѯ�ۡ�!")
  	//	  return false;     	    
  	//	}
  	//}else{
  	//  if(verpOpinion=="05"){  //����ѯ��  
    //	  if(isEmptyField(fm.nextHandleDept)){
     //     errorMessage("�˼����Ϊ������ѯ�ۡ�ʱ,����ѡ������ѯ�ۻ���!")
    //		  return false;  
    //		}   	    
  	//  }

    	//�ж��Ƿ�����ύ
  	 // if(verpOpinion!="01" && verpOpinion!="04" && verpOpinion!="05")
     // {
     //   errorMessage("�˼����Ϊ��ͬ�ⶨ�𡱡����۸�����������������ѯ�ۡ�ʱ�ſ����ύ�ð���!")
  	//	  return false;      
    //  }
      
      //�ύ����ʱ��У���Ƿ��г��˼�Ȩ�ޣ���Ȩ�޲������ύ���𣬱�������ѯ��
  //	  if(verpOpinion=="01" || verpOpinion=="04")
    //  {
    //    if(checkSubmitButton()==false){
    //      return false;  
    //    }  	
   //   }
  //  }  
 // }
   
  //�˻ذ���У��
 // if (saveType=="5") 
 // {
    //�ж��Ƿ�����ύ
	//  if(verpOpinion=="01" || verpOpinion=="04" || verpOpinion=="05")
   // {
   //   errorMessage("�˼����Ϊ��������Ϣ���򡰼۸����巢�ء�ʱ�ſ����˻ظð���!")
	//	  return false;      
    //}        
  //}
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();  
}

  //���ú˼�Ĭ��ֵ
function initVeriPrice(){
  setComponetVeriPriceDefault();
}

/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet()
{ 
  
  //���㹤ʱ�Ѻϼ�
  sumRepairFee();
  
  //���㻻���Ѻϼ�
  sumComponentFee();
  
  return true;
} 

/*
 function checkVerpCompPrice(field,serialNo){
    
     var standerPrice  = fm.prpLcomponentVerpCompPriceLast[serialNo].value;
     var compVerpPrice = fm.prpLcomponentVerpCompPrice[serialNo].value;
     var prpLcomponentFlag  =fm.prpLcomponentFlag[serialNo].value;
   if ( prpLcomponentFlag !=null && prpLcomponentFlag=="1") { //ֻ�б���Ĳ��ж�
      if ( parseFloat(standerPrice) < parseFloat(compVerpPrice) ){
     	 alert (" �˶��۸��ܸ��ڹ涨�۸�");
     	 field.focus();
     	 return false;
      }
    }
 }

*/

function checkVerpCompPrice(serialNo){
    
     var standerPriceHere = getStanderPrice(serialNo);
     var compVerpPrice = parseFloat(fm.prpLcomponentVerpCompPrice[serialNo].value);
     if (isNaN(compVerpPrice)) { compVerpPrice =0;}
     
     if ( standerPriceHere ==0){ //�Զ�������Ͳο���Ϊ0ʱ���Ƚ�
          return true;	
     }
     else {
     	if ( standerPriceHere < compVerpPrice ){
       	 alert (" �˶��۸��ܸ��ڹ涨�۸�");
     	   return false;
      }
    }
 }

function getStanderPrice(serialNo){
   
     var standerPrice = 0 ;
     var repairFactoryType = fm.prpLrepairFeeRepairFactoryCode.value;
     var prpLcomponentFlag  =fm.prpLcomponentFlag[serialNo].value;
  
   if ( prpLcomponentFlag !=null && prpLcomponentFlag=="1") { //ֻ�б���Ĳ��ж�
      
       var   sys4SPrice = parseFloat(fm.prpLcomponentSys4SPrice[serialNo].value);   	    
     	 var   sysMarketPrice = parseFloat(fm.prpLcomponentSysMarketPrice[serialNo].value);
     	 var   native4SPrice = parseFloat(fm.prpLcomponentNative4SPrice[serialNo].value);   	    
     	 var   nativeMarketPrice = parseFloat(fm.prpLcomponentNativeMarketPrice[serialNo].value);
     	
     	if(isNaN(sys4SPrice)) sys4SPrice = 0;
     	if(isNaN(sysMarketPrice)) sysMarketPrice = 0;
     	if(isNaN(native4SPrice)) native4SPrice = 0;
     	if(isNaN(nativeMarketPrice)) nativeMarketPrice = 0;
     
      if (repairFactoryType =="01" ) { //ר�޵꣨4S��
          if ( native4SPrice==0 ) {      //����ר�޼�Ϊ0��ȡϵͳר�޼�
       	     standerPrice = sys4SPrice ;
          }else {
       	     standerPrice = native4SPrice ;
          }	
      }
      else  { //һ�����೧
      	  if ( nativeMarketPrice==0 ) {
       	     standerPrice = sysMarketPrice ;
          }else {
       	     standerPrice = nativeMarketPrice ;
          }	
      }
     
   }else{  //���Ǳ��䲻�Ƚϣ���׼����Ϊ0
   	  standerPrice =0 ;
    }

    return  standerPrice ;
}





/**
 *@description ���ú˼�Ĭ��ֵ
 *@param       ��
 *@return      ��
 */ 
  function setComponetVeriPriceDefault() 
  { 
     var repairFactoryType = "";  //��������
     
     repairFactoryType = fm.prpLrepairFeeRepairFactoryCode.value;
         
     for(i=1;i<fm.all("prpLcomponentSys4SPrice").length;i++)
     {
   	    getComponetVeriPriceDefault(fm.prpLcomponentSerialNo[i].value);
     }      
  }   

//��ȡ�˼۳�ʼֵ
function getComponetVeriPriceDefault(serialNo) 
  { 
  	var standCompPrice =0;
  	var standCompPrice = getStanderPrice(serialNo) ;
    var materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[serialNo].value); 
    var verpCompPrice = parseFloat(fm.all("prpLcomponentVerpCompPrice")[serialNo].value);
   
    if (verpCompPrice !=0) { 
    	return ;
    }
    else{
    	  if ( standCompPrice == 0) { //�Զ���ĺ˼�Ĭ��ֵȡ�ϱ��۸�
    	  	  fm.all("prpLcomponentVerpCompPrice")[serialNo].value = point(round(materialFee,2),2);	
    	  }
    	  else { //����ʱ���ϱ��۸�ͱ�׼�Ƚϣ�˭Сȡ˭
            if ( materialFee > standCompPrice){
                fm.all("prpLcomponentVerpCompPrice")[serialNo].value = point(round(standCompPrice,2),2);	
            }
            else {
    	         fm.all("prpLcomponentVerpCompPrice")[serialNo].value = point(round(materialFee,2),2);
            }
        }  	
    } 
  }  
  

/**
 *@description ���㹤ʱ�Ѻϼơ��˼۹�ʱ�Ѻϼ�
 *@param       ��
 *@return      ��
 */ 
  function sumRepairFee()
  {
   var sumRepairDefFee = 0 ;//���������
   var sumRepairVerifyFee = 0 ;//������˼۷�
   var prpLrepairFeeSumDefLoss = 0 ;
   var prpLrepairFeeVeriSumLoss = 0 ;
      
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
   
   //����ʱ�Ѻϼ�
   fm.SumDefLoss1.value     = point(round(sumRepairDefFee,2),2);;

   //�˼۹�ʱ�Ѻϼ�
   fm.SumVerifyLoss1.value  = point(round(sumRepairVerifyFee,2),2);
   
   //�����ܵĶ�����
   sumPreDefLoss();

   return true;
  } 

/**
 *@description ���㻻���Ѻϼơ��˼ۻ����Ѻϼ�
 *@param       ��
 *@return      ��
 */ 
  function sumComponentFee() 
  { 
     var sumComponentMaterialFee = 0 ; //���𻻼��Ѻϼ�
     var sumComponentVerpCompPrice = 0 ; //�˼ۻ����Ѻϼ�
     var sumManageFee = 0; //����� 
     var sumVerifyManageFee = 0; //�ܹ�˾�˶������
     var sumTax = 0;       //˰��   
     var sumTransFee = 0;  //�˷�
     var sumRestFee = 0;   //��ֵ�ϼ�
     var quantity = 0 ;     
     var verpCompPrice = 0 ; 
     var materialFee = 0 ; 

     sumManageFee = parseFloat(fm.all("prpLcarLossSumManager").value); //����� 
     sumVeriManageFee = parseFloat(fm.all("prpLcarLossSumVeriManager").value); //�ܹ�˾�˶������
     sumTax = parseFloat(fm.all("prpLcarLossSumTax").value);       //˰��   
     sumTransFee = parseFloat(fm.all("prpLcarLossSumTransFee").value);  //�˷�
     sumRestFee = parseFloat(fm.all("prpLcarLossSumRest").value);   //��ֵ�ϼ�
     
     if(isNaN(sumManageFee)) sumManageFee = 0;
     if(isNaN(sumVeriManageFee)) sumVeriManageFee = 0;
     if(isNaN(sumTax)) sumTax = 0;
     if(isNaN(sumTransFee)) sumTransFee = 0;
     if(isNaN(sumRestFee)) sumRestFee = 0;
         
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
        
        fm.all("prpLcomponentSumDefLoss")[i].value = parseFloat(point(round(quantity*verpCompPrice,2),2));
     } 
     
     //���𻻼��Ѻϼ� = �ϱ��۸�ϼ� + ����� + ˰�� + �˷� �C ��ֵ�ϼ�(�ϱ��۸�ϼ� = ÿһ��������ϱ��۸� �� ����֮��)
     sumComponentMaterialFee = sumComponentMaterialFee + sumManageFee + sumTax + sumTransFee - sumRestFee;

     if(sumVeriManageFee!=0)
       sumManageFee = sumVeriManageFee;

     //�˼ۻ����Ѻϼ� = �˼ۺϼ� + ����� + ˰�� + �˷� �C ��ֵ�ϼ�(�˼ۺϼ� = ÿһ������ĺ˼� �� ����֮��)
     sumComponentVerpCompPrice = sumComponentVerpCompPrice + sumManageFee + sumTax + sumTransFee - sumRestFee;
     
     //���𻻼��Ѻϼ�
     fm.SumDefLoss2.value = point(round(sumComponentMaterialFee,2),2);
     //�˼ۻ����Ѻϼ�
     fm.SumVerifyLoss2.value = point(round(sumComponentVerpCompPrice,2),2);

     //�����ܵĶ�����ܵĺ˼۽��
     sumPreDefLoss();
     
     return true;
  }   
  
/**
 *@description �����ܵĶ�����ܵĺ˼۽�ƫ�����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 
 
 function sumPreDefLoss()
 {
 	 var sumRepairLoss     = 0 ;//����
 	 var sumComponentLoss  = 0 ;//����
 	 var sumRepairVerifyLoss     = 0 ;//����
 	 var sumComponentVerifyLoss  = 0 ;//����
 	 
 	 var sumPreDefLoss     = 0 ;
 	 var sumVerifyLoss     = 0 ;
 	 var firstDefLoss      = 0 ; //���ζ�����
 	 var warpDefLoss       = 0 ; //ƫ�����
 
   sumRepairLoss = parseFloat(fm.SumDefLoss1.value);
   sumComponentLoss = parseFloat(fm.SumDefLoss2.value);

   sumRepairVerifyLoss = parseFloat(fm.SumVerifyLoss1.value);
   sumComponentVerifyLoss = parseFloat(fm.SumVerifyLoss2.value);
  
 	 if(isNaN(sumRepairLoss))  sumRepairLoss = 0 ;
 	 if(isNaN(sumRepairVerifyLoss))  sumRepairVerifyLoss = 0 ;
   if(isNaN(sumComponentLoss)) sumComponentLoss = 0 ;
   if(isNaN(sumComponentVerifyLoss)) sumComponentVerifyLoss = 0 ;
 	   
   sumPreDefLoss = parseFloat(sumRepairLoss)+ parseFloat(sumComponentLoss); 
   sumVerifyLoss = parseFloat(sumRepairVerifyLoss)+ parseFloat(sumComponentVerifyLoss); 
  
   //�ܵĶ�����
   fm.prpLcarLossSumCertainLoss.value = point(round(sumPreDefLoss,2),2);
   
   //�ܵĺ˼۽��
   fm.prpLcarLossSumVerifyLoss.value = point(round(sumVerifyLoss,2),2);
   
   firstDefLoss = parseFloat(fm.prpLverifyLossFirstDefLoss.value);
  
 	 if(isNaN(firstDefLoss))  firstDefLoss = 0 ;
 	 
 	 warpDefLoss = firstDefLoss - sumVerifyLoss;
 	 
 	 //ƫ�����
   fm.prpLverifyLossWarpDefLoss.value = point(round(warpDefLoss,2),2);
 }      
 

/**
 *@description ���ݹ�ʱ����ʱ���ۼ��㶨������ݺ˼ۼ����ܺ˼۽��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 
 function getSumDefLossVerify(field,ext)
 {  
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manUnitPrice;
  var ManHour;
  var sumDefLoss;
    
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
 
  if(ext==1){
    ManHour = parseFloat(fm.all("prpLrepairFeeVeriManHour")[findex].value);
    manUnitPrice  = parseFloat(fm.all("prpLrepairFeeVeriManUnitPrice")[findex].value)      

    if(isNaN(ManHour)) ManHour = 0; 
    if(isNaN(manUnitPrice)) manUnitPrice = 0; 
    
    sumDefLoss = manUnitPrice*ManHour;
     
    fm.all("prpLrepairFeeVeriMaterialFee")[findex].value = point(round(sumDefLoss,2),2);
    fm.all("prpLrepairFeeVeriSumLoss")[findex].value = point(round(sumDefLoss,2),2);
    sumRepairFee();
  } else {        
    sumComponentFee();
  }  
  return true;  
       
 } 


/**
 *@description �����鿱�Ļ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relateCheck(){	  
		var registNo = fm.RegistNo.value;
	  var linkURL = "/claim/checkFinishQueryList.do?prpLcheckCheckNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskcode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

/**
 *@description ���������Ļ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relateRegist(){	
		var registNo = fm.RegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskcode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 


/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 
function relatePolicy(){	 
    var riskCode = fm.riskcode.value;
    var policyNo = fm.PolicyNo.value; 
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL =  CoreWebUrl +'/'+ riskCode + '/tbcbpg/UIPrPoEn' + riskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ policyNo+'&RiskCode='+ riskCode;
    window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
} 
 
/**
*@description �������������嵥 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}   

function initPage2(){
//	fm.all("prpLpropVeriSumLoss")[1].style.display="none";
//	fm.all("prpLpropVeriSumReject")[1].style.display="none";
//	fm.all("prpLpropVeriSumDefLoss")[].style.display="none";
//	fm.all("prpLpropVeriRemark")[1].style.display="none";
}

function initSet1()
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
  //��������������޳���������ϼƳ�ʼ��
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
  
  //sumRepairFee();
  //sumComponentFee();
  ////sumPersonLossFee();
  //sumPreDefLoss();
  return true;
} 