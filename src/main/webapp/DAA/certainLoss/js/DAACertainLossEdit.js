/*****************************************************************************
 * DESC       ������ǼǵĽű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-07-13
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
    var riskcode = fm.prpLverifyLossRiskCode.value;
    if(riskcode == "0310"||riskcode == "0312")
    {
         var number = getElementCount("prplCompensateHouseEstimateLoss");
       var sumLoss = 0;
       for(var k=1;k<number;k++){
        sumLoss = sumLoss + parseFloat(fm.prplCompensateHouseEstimateLoss[k].value);
       }
     
     
      var count1 = getElementCount("prpLpropSumLoss");
      var count2 = getElementCount("prpLpropSumDefLoss");
      
      
      if(count1 > 1)
    {
       var temp = document.getElementsByName('prpLpropSumLoss');
       temp[1].value = sumLoss;

    }
      if(count2 > 1)
    {
    
       var temp2 = document.getElementsByName('prpLpropSumDefLoss');
       temp2[1].value = sumLoss;

    }

    }
  
}
 
 
 
 function onload0310()
 {   
     var riskcode = fm.prpLverifyLossRiskCode.value;
     if(riskcode == "0310"||riskcode == "0312")
     {
        var count = getElementCount("buttonDriverInsert");
        
        if(count > 0)
        {
           var temp = document.getElementsByName('buttonDriverInsert');
           temp[0].onclick();
           temp[0].style.display = "none";
           var count2 = getElementCount("buttonPropDelete");
           if(count2 > 0)
           {
             for(var index =0 ;index < count2 ; index++)
          {
             if (index ==0) continue;
             fm.buttonPropDelete[index].style.display = "none";

          }  
           }
        }
     
     }
 }
 
 function onload0310edit()
 {   
     var riskcode = fm.prpLverifyLossRiskCode.value;
     if(riskcode == "0310"||riskcode == "0312")
     {
        var count = getElementCount("buttonDriverInsert");
        
        if(count > 0)
        {
           var temp = document.getElementsByName('buttonDriverInsert');
           temp[0].style.display = "none";
           var count2 = getElementCount("buttonPropDelete");
           if(count2 > 0)
           {
             for(var index =0 ;index < count2 ; index++)
          {
             if (index ==0) continue;
             fm.buttonPropDelete[index].style.display = "none";

          }  
           }
        }
     
     }
 }
 
 
 function onload0310cal()
 {
    var riskcode = fm.prpLverifyLossRiskCode.value;
    if(riskcode == "0310"||riskcode == "0312")
    {
        
        var number = getElementCount("prplCompensateHouseEstimateLoss");
       var sumLoss = 0;
       for(var k=1;k<number;k++){
        sumLoss = sumLoss + parseFloat(fm.prplCompensateHouseEstimateLoss[k].value);
       }
       
      var count1 = getElementCount("prpLpropSumLoss");
      var count2 = getElementCount("prpLpropSumDefLoss");
      
      
      if(count1 > 0)
    {
       var temp = document.getElementsByName('prpLpropSumLoss');
       temp[1].value = sumLoss;

    }
      if(count2 > 0)
    {
    
       var temp2 = document.getElementsByName('prpLpropSumDefLoss');
       temp2[1].value = sumLoss;

    }
       
     
    
    }
     
 
 
 
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
  var element1 = document.getElementsByName('prpLcomponentKindCode');
  if(element1.length>1)  {
    for(i=0;i<element1.length;i++)
    {
      fm.prpLcomponentSys4SPrice[i].style.display = "none";
      fm.prpLcomponentSysMarketPrice[i].style.display = "none";
      fm.prpLcomponentSysMatchPrice[i].style.display = "none";
      fm.prpLcomponentNative4SPrice[i].style.display = "none";
      fm.prpLcomponentNativeMarketPrice[i].style.display = "none";
      fm.prpLcomponentNativeMatchPrice[i].style.display = "none";

      setReadonlyOfElementOfLoss(fm.prpLcomponentVerpCompPrice[i]); 
    }
  }
  else{
      fm.prpLcomponentSys4SPrice.style.display = "none";
      fm.prpLcomponentSysMarketPrice.style.display = "none";
      fm.prpLcomponentSysMatchPrice.style.display = "none";
      fm.prpLcomponentNative4SPrice.style.display = "none";
      fm.prpLcomponentNativeMarketPrice.style.display = "none";
      fm.prpLcomponentNativeMatchPrice.style.display = "none";
      
      setReadonlyOfElementOfLoss(fm.prpLcomponentVerpCompPrice); 
  }   
 
  tdNextHandleDept.innerHTML = "";
  fm.nextDeptName.style.display = "none";
  //tdnextHandlerCode.innerHTML = "";
  fm.nextHandlerName.style.display = "none";

  setReadonlyOfElementOfLoss(fm.prpLcarLossSumVeriManager);   
    
  //setReadonlyOfElementOfLoss(fm.prpLverifyLossVerifyOpinion);  
  setReadonlyOfElementOfLoss(fm.prpLverifyLossVerifyRemark);  
  setReadonlyOfElementOfLoss(fm.prpLverifyLossVerpRemark);  



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
      iElement.readOnly = true;
      iElement.className = "readonly";
    }
  }
}


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
   var element = document.getElementsByName('prpLverifyLossExtTitle');
   var i = element.length - 1;
   var addNewRepairCompentRow=-1;//Ĭ��û������һ�������������������
   var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //�����˻صı��
   

  if(fm.prpLrepairFeeRepairFactoryCode != null && fm.prpLrepairFeeRepairFactoryCode.value == ""){
    alert("��ѡ���������ͣ�");
    return false;
  }
  if(fm.prpLrepairFeeRepairFactoryName != null && fm.prpLrepairFeeRepairFactoryName.value == ""){
    alert("�������������ƣ�");
    return false;
  }

  var repairFeeCount = getElementCount("prpLrepairFeeCompName");
  for(var k=1;k < repairFeeCount;k++){
  	if(isEmptyField(fm.prpLrepairFeeCompName[k])){
  		alert("������Ŀ�����嵥��"+k+"�У��������Ŀ�����Ʋ���Ϊ��!");
  		return false;
  	}
  }
  
  var componentCount = getElementCount("prpLcomponentCompName");
  for(var j=1;j < componentCount;j++){
  	if(isEmptyField(fm.prpLcomponentCompName[j])){
  		alert("�㲿��������Ŀ�嵥��"+j+"�У��������Ʋ���Ϊ��!");
  		return false;
  	}
  }

  if(i>0&&fm.prpLverifyLossExtTitle[i].value == ""){
    alert("�����붨�������");
    return false;
  }

  
  if (saveType=='CheckInput'){ 
    fm.buttonSaveType.value = '2';
  } else {
    fm.buttonSaveType.value = saveType;
  }
  
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
    if(fm.prpLverifyLossLossItemCode.value=="-1"){     
     if(!validateForm(fm,'Prop_Data')) 
      {
        return false;
      }
    }  else {
    	
    //���ڳ���ҳ���ϵĶ��󳬹�2ǧ�Ժ��ٶȺ��������ҷ�ӳ��ie�������Խ����У��ɾ���˰ɡ�����	
     //if(!validateForm(fm,'RepairFee_Data,Component_Data'))    //modify by liyanjie 20051022 del��Ϊҳ����û�в鿱��ض�����(,ThirdParty_Data,Driver_Data)
     // {
     //   return false;
     // } 
    }
    
    //Modify by chenernda add begin 20050415
    //Reason:��ҳ���жԶ���������ж�
    //var prpLclaimGradeClaimLevel = trim(fm.prpLclaimGradeClaimLevel.value);
    var prpLclaimGradeValueUpper = trim(fm.prpLclaimGradeValueUpper.value);//�������
    var prpLclaimGradeValueLower = trim(fm.prpLclaimGradeValueLower.value);//�������
    
    var SumDefLoss2 = fm.SumDefLoss2.value;//�����ϼ�
    var SumDefLoss1 = fm.SumDefLoss1.value;//����ϼ�
    var SumDefComponentFee = 0;
    var SumDefRepairFee = 0;
    var prpLClaimGradeSumDefLoss = 0;
    var prpLclaimGradeValueUpperFee = 0;
    var prpLclaimGradeValueLowerFee = 0;
    
    SumDefComponentFee = parseFloat(SumDefLoss2);
    SumDefRepairFee = parseFloat(SumDefLoss1);
    prpLclaimGradeValueUpperFee = parseFloat(prpLclaimGradeValueUpper);
    prpLclaimGradeValueLowerFee = parseFloat(prpLclaimGradeValueLower);
    
    if(isNaN(SumDefComponentFee)||SumDefComponentFee.length<1){
      SumDefComponentFee = 0;
    }
    if(isNaN(SumDefRepairFee)||SumDefRepairFee.length<1) {
      SumDefRepairFee = 0;
    }
    prpLClaimGradeSumDefLoss = SumDefRepairFee+SumDefComponentFee;
    
    //�ж��Ƿ񳬹����Ȩ��
    var prpLclaimGradeFlag = trim(fm.prpLclaimGradeFlag.value);
    if(!prpLclaimGradeFlag=="1")
    {
      if((prpLClaimGradeSumDefLoss>prpLclaimGradeValueUpperFee))
      {
        errorMessage("����¼��Ķ�����"+prpLClaimGradeSumDefLoss+"��������Ȩ��֮��!");
        return false;
      }    
    }
    
     
    //Reason:��¼���ձ�����ж�
    var prpLcarLossInsureCarFlagName = trim(fm.prpLcarLossInsureCarFlagName.value);
    var KindCode = "";
    
        //ȡ�����js�жϺ�ϵͳ�ǿ�Ԫ����Ҫ�����ж� begin
    var prpLverifyLossRegistNo = trim(fm.prpLverifyLossRegistNo.value);
    var prpLverifyLossPolicyNo = trim(fm.prpLverifyLossPolicyNo.value);
    var prpLverifyLossLossItemCode = trim(fm.prpLverifyLossLossItemCode.value);
    var prpLverifyLossDefLossDate = trim(fm.prpLverifyLossDefLossDate.value);
    var prpLverifyLossMakeCom = trim(fm.prpLverifyLossMakeCom.value);
    var prpLverifyLossComCode = trim(fm.prpLverifyLossComCode.value);
    if(prpLverifyLossRegistNo==null||prpLverifyLossRegistNo.length<1){
          errorMessage("�����Ų���Ϊ��!");
          field.disabled = false; 
          return false;    
    }
    if(prpLverifyLossPolicyNo==null||prpLverifyLossPolicyNo.length<1){
          errorMessage("�����Ų���Ϊ��!");
          field.disabled = false; 
          return false;    
    }
    if(prpLverifyLossLossItemCode==null||prpLverifyLossLossItemCode.length<1){
          errorMessage("�����Ų���Ϊ��!");
          field.disabled = false; 
          return false;    
    }
   /* if(prpLverifyLossDefLossDate==null||prpLverifyLossDefLossDate.length<1){
          errorMessage("�������ڲ���Ϊ��!");
          field.disabled = false; 
          return false;    
    }*/
    if(prpLverifyLossMakeCom==null||prpLverifyLossMakeCom.length<1){
          errorMessage("������������Ϊ��!");
          field.disabled = false; 
          return false;    
    }
    if(prpLverifyLossComCode==null||prpLverifyLossComCode.length<1){
          errorMessage("������������Ϊ��!");
          field.disabled = false; 
          return false;    
    }
    //ȡ�����js�жϺ�ϵͳ�ǿ�Ԫ����Ҫ�����ж� end
    
    if(prpLcarLossInsureCarFlagName=="��")
    {
      //����¼����ձ��У� 
      //������ʧ��--A��    
      //���֡���ը����ȼ��ʧ��--E��
      //��������������--F��
      //�����豸��ʧ����--X��
      //��ȼ��ʧ��--Z��
      //���ء�װж���ھ�����ʧ��--K1��
      //���ֳ����̶��豸����������--K2��
      //��������ʧ��--L
    
      var repairFeeCount=getElementCount("carLossRepairFeeLossItemCode");
      var lossComponentLossCount=getElementCount("carLossComponentLossItemCode");
      var riskcode = fm.riskcode.value;
      var claimType = fm.prpLclaimTypeCode.value;
      //alert("repairFeeCount:"+repairFeeCount)
      for(var j=1;j<repairFeeCount;j++)
      {
         KindCode = trim(fm.prpLrepairFeeKindCode[j].value);
         if (fm.prpLrepairFeeCompensateBackFlag[j].value!="1") addNewRepairCompentRow=addNewRepairCompentRow+1;
         
         /*
         if isNaN(KindCode) {
         	errorMessage("������Ŀ�����嵥�еĵ�"+j+"��û��¼���ձ�!");
         	fm.prpLrepairFeeKindName[j].focus();         
          fm.prpLrepairFeeKindName[j].select(); 
          return false; 	
         }
         */
         if(KindCode!="A" && KindCode!="E"  && KindCode!="F"
                     && KindCode!="X"  && KindCode!="Z"
                     && KindCode!="K1" && KindCode!="K2"
                     && KindCode!="G" && KindCode!="L")
        {
          if(KindCode=="C"||riskcode == "3119")
          {
          }
          else
          {
          	if( claimType != "K")
            {
               errorMessage("������Ŀ��,���ڱ�������������¼����ձ����ʧ��");
               fm.prpLrepairFeeKindName[j].focus();         
               fm.prpLrepairFeeKindName[j].select();         
               return false;
            }
          }    
        }
      }
      
//      alert("lossComponentLossCount:"+lossComponentLossCount)
      
      for(var j=1;j<lossComponentLossCount;j++)
      {
         KindCode = trim(fm.prpLcomponentKindCode[j].value);
            //������˵��ж��Ƿ����������ˡ���
         if (fm.prpLcomponentCompensateBackFlag[j].value!="1") addNewRepairCompentRow=addNewRepairCompentRow+1;
      
        /* if isNaN(KindCode) {
         	errorMessage("�㲿��������Ŀ�����嵥�еĵ�"+j+"��û��¼���ձ�!");
         	fm.prpLcomponentKindName[j].focus();         
          fm.prpLcomponentKindName[j].select();  
          return false; 	
         }*/
         if(KindCode!="A" && KindCode!="E"  && KindCode!="F"
                     && KindCode!="X"  && KindCode!="Z"
                     && KindCode!="K1" && KindCode!="K2"
                     && KindCode!="G" && KindCode!="L")
        {
          if(KindCode=="C"||riskcode == "3119")
          {
          }
          else
          {    
            if( claimType != "K")
            {
               errorMessage("������Ŀ��,���ڱ�������������¼����ձ����ʧ��");
               fm.prpLcomponentKindName[j].focus();         
               fm.prpLcomponentKindName[j].select();         
               return false;
            }
          }    
        }
      }    
         
    }
    else{
      
      var repairFeeCount=getElementCount("carLossRepairFeeLossItemCode");
      var lossComponentLossCount=getElementCount("carLossComponentLossItemCode");
//        alert("repairFeeCount:"+repairFeeCount)
    
    
      for(var j=1;j<repairFeeCount;j++)
      {
         KindCode = trim(fm.prpLrepairFeeKindCode[j].value);
        	//���ò�λ�����ƣ�
        	//fm.prpLrepairFeePartName[j].value=fm.prpLrepairFeePartCode[j].options[fm.prpLrepairFeePartCode[j].selectedIndex].text
          //������˵��ж��Ƿ����������ˡ���
//          alert(fm.prpLrepairFeeCompensateBackFlag[j].value);
         if (fm.prpLrepairFeeCompensateBackFlag[j].value!="1") addNewRepairCompentRow=addNewRepairCompentRow+1;
         if(KindCode == "" ||KindCode == null){
            errorMessage("�ձ������ձ����Ʋ���Ϊ��");
             return false;
         }
         if(KindCode!="B" && KindCode!="BZ"&& KindCode!="H"&& KindCode!="003" && KindCode != "")
         {
           errorMessage("���ڵ����߳���ֻ��ѡ�����������գ�");
           fm.prpLrepairFeeKindName[j].focus();         
           fm.prpLrepairFeeKindName[j].select();    
           return false;
         }        
        
      }
//       alert("lossComponentLossCount:"+lossComponentLossCount)
      for(var j=1;j<lossComponentLossCount;j++)
      {
         KindCode = trim(fm.prpLcomponentKindCode[j].value);
                  	//���ò�λ�����ƣ�
          //������˵��ж��Ƿ����������ˡ���
         if (fm.prpLcomponentCompensateBackFlag[j].value!="1") addNewRepairCompentRow=addNewRepairCompentRow+1;
         
        	//fm.prpLcomponentPartName[j].value=fm.prpLcomponentPartCode[j].options[fm.prpLcomponentPartCode[j].selectedIndex].text
        	
         if(KindCode == "" ||KindCode == null){
            errorMessage("�ձ������ձ����Ʋ���Ϊ��");
            return false;
         }
  
         if(KindCode!="B" && KindCode!="BZ"&&KindCode!="H"&& KindCode!="003" && KindCode != "")
         {
           errorMessage("���ڵ����߳���ֻ��ѡ�����������գ�");
           fm.prpLcomponentKindName[j].focus();         
           fm.prpLcomponentKindName[j].select();       
           return false;
         }      
      }    
    }
    
    //Modify by chenernda add end 20050415
    
    //������ύ���ж��Ƿ���nextNodeNo������ԱΪ�գ�������
  if(fm.prpLverifyLossLossItemCode.value=="1"){     
      //�����������Ʋ���ʧ��¼һ����ܽ���
      var carLossRepairFeeLossItemCode = fm.carLossRepairFeeLossItemCode.length;
      var carLossComponentLossItemCode = fm.carLossComponentLossItemCode.length;
      //var personSerialNo = fm.personSerialNo.length; 
      if(carLossRepairFeeLossItemCode == undefined &&carLossComponentLossItemCode == undefined)
      { 
        //Modify by liujianbo modify start 20051102
        //reason:itest:434 �������������߳����������û�б������գ���������ת����ȥ
        //alert("������Ŀ�����嵥���㲿��������Ŀ�����嵥������¼��һ����ܱ���");    
        //return false;  
        //Modify by liujianbo modify end 20051102
      }
  }         
  if (saveType=="4") 
  { 
    if(fm.prpLverifyLossLossItemCode.value=="-1"){ 
    	if(checkPropKindCode()==false){   return false;   }
      var prpLpropSerialNo = fm.prpLpropSerialNo.length
       if(prpLpropSerialNo == undefined)       
      { 
        alert("�Ʋ������嵥����¼��һ������ύ");
        return false; 
      } 
    } else if(fm.prpLverifyLossLossItemCode.value=="1"){     
      //�����������Ʋ���ʧ��¼һ����ܽ���
      var carLossRepairFeeLossItemCode = fm.carLossRepairFeeLossItemCode.length;
      var carLossComponentLossItemCode = fm.carLossComponentLossItemCode.length;
      //var personSerialNo = fm.personSerialNo.length; 
      if(carLossRepairFeeLossItemCode == undefined &&carLossComponentLossItemCode == undefined)
      { 
        //Modify by liujianbo modify start 20051102
        //reason:itest:434 �������������߳����������û�б������գ���������ת����ȥ
        //        alert("������Ŀ�����嵥���㲿��������Ŀ�����嵥����������¼��һ��");
        //        return false; 
        //Modify by liujianbo modify end 20051102 
      }
    } else {
      //�����������Ʋ���ʧ��¼һ����ܽ���
      var carLossRepairFeeLossItemCode = fm.carLossRepairFeeLossItemCode.length;
      var carLossComponentLossItemCode = fm.carLossComponentLossItemCode.length;
      if(carLossRepairFeeLossItemCode == undefined &&carLossComponentLossItemCode == undefined)
      {  
        //Modify by liujianbo modify start 20051102
        //reason:itest:434 �������������߳����������û�б������գ���������ת����ȥ
        //        alert("������Ŀ�����嵥���㲿��������Ŀ�����嵥,��������¼��һ��");
        //        return false; 
        //Modify by liujianbo modify end 20051102
      } 
    }
/*  
  	if (trim(fm.nextNodeNo.value).length<1)
  	{
  		alert("��ѡ��Ҫ�ύ����һ���ڵ㣡")
  		return false;
  	}
*/
  	
  	/*
  	if (trim(fm.nextHandlerCode.value).length<1)
  	{
  		alert("��ѡ��Ҫ�ύ����һ���ˣ�") 
  		return false;
  	}
  	*/
	//setNextNode();
  	
  }
  
  
  
  
  //�����������˵ģ�����û���������еĻ�����ô����ֱ���ύ������ 
  if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";
  
  var riskcode = fm.prpLverifyLossRiskCode.value;
    if(riskcode == "0310"||riskcode == "0312")
  {
     var count = getElementCount("prplCompensateHouseIDcard");
     var ids = document.getElementsByName("prplCompensateHouseIDcard");
     var inprocess = document.getElementsByName("prplCompensateHouseInprocess");
     if(count ==1)
     {
        alert("���ѯ����ũ�����֤��Ϣ!");
        return false;
     
     }
     for(var index =0 ;index < count ; index++)
	 	{
	 	 if (index ==0) continue;

	 		//if(trim(inprocess[index].value) == "Y")
		 	 //{
		 	 	//alert("�������ڽ��д���Ķ���ţ������ύ��");
		 	 	//return false;
		 	 //}



	 	 var i =index;
	 	 i++;
	 	 while(i < count)
	 	 {
	 	  if(ids[index].value == ids[i].value)
	 	  {
	 	  alert("���֤�Ų����ظ�");
	 	  	return false;
	 	 	}
	 	 	 i++;
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
        alert("�Ʋ���ʧ��Ŀ��,ֻ��¼��B��D2��H �����ձ����ʧ��");         
        //fm.prpLpropKindCode[i].focus();       
      	//fm.prpLpropKindCode[i].select();
        return false; 
      }    
    }  
  }
  return true;
} 
 
//Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά�� 
 
/**
 *@description �������Ա���ҳ��
 *@param       ��
 */
/*
function openWinSave(){
   
   var businessNo = fm.RegistNo.value;
   var policyNo = fm.prpLverifyLossPolicyNo.value; 
   var riskCode = fm.prpLverifyLossRiskCode.value;
   var claimNo = fm.prpLverifyLossClaimNo.value;
   msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=certa&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");

}
*/
/**
 *@description �����鿴����ҳ��
 *@param       ��
 */
 /*
function openWinQuery(){
var win;
var messagedo="/claim/messageQueryList.do?registNo="+ fm.RegistNo.value;
win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
/**
 *@description ������֤ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openCertify(){ 
  var win; 
  var messagedo="/claim/certainLossCertify.do?registNo="+fm.prpLverifyLossRegistNo.value+"&editType=Certify&riskCode="+fm.prpLverifyLossRiskCode.value+"&openFlag=pop";
  
  //win=window.showModalDialog(messagedo,"dialogTop=0;dialogLeft=0;dialogWidth=800;dialogHeight=600");
  //win=window.open(messagedo,"NewWindow","dialogWidth:750px;dialogHeight:550px; dialogLeft:15px;dialogTop:15px;center:yes;help:yes;resizable:yes;status:yes");
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
}  
  */
  
  //Modify By wangli remark end 20050328

 
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
    sumDefLoss = manHourFee*ManHour;    
    fm.all("prpLrepairFeeManHourFee")[findex].value = point(round(sumDefLoss,2),2);
    fm.all("prpLrepairFeeSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);
    sumRepairFee();
  } else {    
    
    quantity  = parseFloat(fm.all("prpLcomponentQuantity")[findex].value)      
    manHourFee = parseFloat(fm.all("prpLcomponentManHourFee")[findex].value); 
    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[findex].value);
    materialRestFee = parseFloat(fm.all("prpLcomponentRestFee")[findex].value);
                                   
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

    sumDefLoss = parseFloat(point(round(quantity*materialFee,2),2)) + parseFloat(point(round(manHourFee,2),2))- parseFloat(point(round(materialRestFee,2),2));    
    fm.all("prpLcomponentSumDefLoss")[findex].value = point(round(sumDefLoss,2),2); 
    sumComponentFee();
  } 
  //����ƫ�����
  fm.prpLverifyLossWarpDefLoss.value=parseFloat(fm.SumDefLoss1.value)+parseFloat(fm.SumDefLoss2.value);
  
  //fm.all("prpLrepairFeeSumDefLoss")[findex].value = 1111;  
  //��Ӧ�Ļ��� 
  
  return true;  

       
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
      
try{
   var len = fm.all("prpLrepairFeeManHour").length;
   var prpLrepairFeeVeriSumLosses = fm.all("prpLrepairFeeVeriSumLoss");
   var prpLrepairFeeSumDefLosses  = fm.all("prpLrepairFeeSumDefLoss") 
   for(i=1;i<len;i++){
   	    prpLrepairFeeVeriSumLoss = parseFloat(prpLrepairFeeVeriSumLosses[i].value);
   	    prpLrepairFeeSumDefLoss = parseFloat(prpLrepairFeeSumDefLosses[i].value);

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
}catch(ex){}
   return true;
  } 

/**
 *@description ���㻻���Ѻϼơ��˼ۻ����Ѻϼ�
 *@param       ��
 *@return      ��
 */ 
  function sumComponentFee() 
  { 
   var sumComponentDefFee = 0 ;//�ܻ��������
   var sumComponentManHourFee  = 0 ; //�ܹ�ʱ��
   var sumComponentMaterialFee = 0 ; //�ܲ��Ϸ�
   var sumComponentMaterialRestFee=0;
   var quantity = 0 ;
   var manHourFee = 0 ;
   var materialFee = 0 ;
   if(fm.all("SumDefLoss2")!=null){
     if(fm.all("SumDefLoss2").length>0){ 
       for(j=0;j<fm.all("SumDefLoss2").length;j++){
         for(i=1;i<fm.all("prpLcomponentQuantity").length;i++){
            if(j == fm.all("carLossComponentLossItemCode")[i].value){
         	    quantity = parseFloat(fm.all("prpLcomponentQuantity")[i].value);
         	    manHourFee = parseFloat(fm.all("prpLcomponentManHourFee")[i].value);
         	    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);
                materialRestFee = parseFloat(fm.all("prpLcomponentRestFee")[i].value);
        	   	if(isNaN(quantity)||quantity.length<1){ 
        	      quantity = 0;
        	    }
        	    if(isNaN(manHourFee)||manHourFee.length<1) {
        	      manHourFee = 0;
        	    }
        	    if(isNaN(materialFee)||materialFee.length<1){ 
        	      materialFee = 0;
        	    }
			    if(isNaN(materialRestFee)||materialRestFee.length<1){
			      materialRestFee = 0;
			    }

              sumComponentManHourFee   = sumComponentManHourFee + parseFloat(point(round(quantity*materialFee,2),2));
              sumComponentMaterialFee  = sumComponentMaterialFee + parseFloat(point(round(manHourFee,2),2));
              sumComponentMaterialRestFee =sumComponentMaterialRestFee +parseFloat(point(round(materialRestFee,2),2));
              //alert(sumComponentManHourFee+"::00::"+sumComponentManHourFee);
              sumComponentDefFee = sumComponentManHourFee+sumComponentMaterialFee-sumComponentMaterialRestFee;
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
	   /*
	   		�������ϼ�̫�����Ż�����
	   */
       var len = fm.all("prpLcomponentQuantity").length;
       var prpLcomponentQuantitys = fm.all("prpLcomponentQuantity");
       var prpLcomponentManHourFees = fm.all("prpLcomponentManHourFee");
       var prpLcomponentMaterialFees = fm.all("prpLcomponentMaterialFee");
       var prpLcomponentRestFee = fm.all("prpLcomponentRestFee");
       for(i=1;i<len;i++)
       {
       	    quantity = parseFloat(prpLcomponentQuantitys[i].value);
       	    manHourFee = parseFloat(prpLcomponentManHourFees[i].value);
       	    materialFee = parseFloat(prpLcomponentMaterialFees[i].value);
            materialRestFee = parseFloat(prpLcomponentRestFee[i].value);
    	   	if(isNaN(quantity)){
    	      quantity = 0;
    	    }
    	    if(isNaN(manHourFee)) {
    	      manHourFee = 0;
    	    }
    	    if(isNaN(materialFee)){
    	      materialFee = 0;
    	    }
			    if(isNaN(materialRestFee)||materialRestFee.length<1){
			      materialRestFee = 0;
			    }
            
            sumComponentManHourFee   = sumComponentManHourFee + parseFloat(point(round(quantity*materialFee,2),2));
            sumComponentMaterialFee  = sumComponentMaterialFee + parseFloat(point(round(manHourFee,2),2));
              sumComponentMaterialRestFee =sumComponentMaterialRestFee +parseFloat(point(round(materialRestFee,2),2));
              sumComponentDefFee = sumComponentManHourFee+sumComponentMaterialFee-sumComponentMaterialRestFee;

//            sumComponentDefFee = sumComponentManHourFee+sumComponentMaterialFee;
       }

       fm.SumDefLoss2.value = point(round(sumComponentDefFee,2),2);
       fm.SumManHourFee2.value = point(round(sumComponentManHourFee,2),2);
       fm.SumMaterialFee2.value = point(round(sumComponentMaterialFee,2),2);
       sumPreDefLoss();
     }  
   }   
   return true;
  }

/**
 *@description �����ܵĶ�����ܵĺ˼۽�ƫ�����
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 
 
 function sumCarPreDefLoss()
 {
 	 var sumRepairLoss     = 0 ;//����
 	 var sumComponentLoss  = 0 ;//����
 	 var sumRepairVerifyLoss     = 0 ;//����
 	 var sumComponentVerifyLoss  = 0 ;//����
 	 
 	 var sumPreDefLoss     = 0 ;
 	 var sumVerifyLoss     = 0 ;
 	 var firstDefLoss      = 0 ; //���ζ�����
 	 var warpDefLoss       = 0 ; //ƫ�����
   var logStatus = ""; //����״̬ 
     
try{
     logStatus = fm.prpLverifyLossDtoStatus.value;
}catch(ex){logStatus="";}	   

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

   if(logStatus!="1" && logStatus!="2"){
     //�ܵĺ˼۽��
     fm.prpLcarLossSumVerifyLoss.value = point(round(sumVerifyLoss,2),2);
   }else{
     //�ܵĺ˼۽��
     fm.prpLcarLossSumVerifyLoss.value = point(round(sumPreDefLoss,2),2);   
   }     
   
   firstDefLoss = parseFloat(fm.prpLverifyLossFirstDefLoss.value);
  
 	 if(isNaN(firstDefLoss))  firstDefLoss = 0 ;
 	 
 	 warpDefLoss = firstDefLoss - sumVerifyLoss;
 	 
 	 //ƫ�����
   fm.prpLverifyLossWarpDefLoss.value = point(round(warpDefLoss,2),2);
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
  if(fm.all(sumloss)!=null){
    for(i=1;i<fm.all(sumloss).length;i++)
    {
      sumvalue = fm.all(sumloss)[i].value; 
  
      if(isNaN(sumvalue)||sumvalue.length<1){
        sumvalue = 0;
      }
      if(isNaN(sumallvalue)||sumallvalue.length<1){
      sumallvalue = 0;
      	}
      sumallvalue = parseFloat(sumallvalue) + parseFloat(sumvalue);
    } 
    fm.prpLpropSumSumLoss.value=point(round(sumallvalue,2),2); 
  }

  sumallvalue=0;
  
  if(fm.all(sumreject)!=null){
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
  
  if(fm.all(sumdefloss)!=null){
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
  var riskCode = fm.prpLverifyLossRiskCode.value;
if(riskCode.substr(0,2) == "05"){
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
}
  sumRepairFee(); 
  sumComponentFee();
  sumPersonLossFee();
  sumPreDefLoss();  
  return true;
} 
 
/**
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSetForCheck()
{  
  var sumloss    = "prpLpropSumLoss";
  var sumreject  = "prpLpropSumReject";
  var sumdefloss = "prpLpropSumDefLoss";
  var sumvalue;
  var sumallvalue;    
  if(fm.all(sumloss)!=null){
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
  
  if(fm.all(sumloss)!=null){
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
  
  if(fm.all(sumloss)!=null){
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
  sumRepairFee(); 
  sumComponentFee();
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
 	var sumRepairLoss     = 0 ;//����
 	var sumComponentLoss  = 0 ;//����
 	var sumPersonLoss=0 ;      //��Ա
 
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
 	   
 	if(fm.all("SumDefLoss2")!=null){  
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
 	   
 	//sumPersonLoss = fm.sumPersonLoss.value;//��Ա�����ܺ�δ��
 	//if(isNaN(sumPersonLoss))
 	//  sumPersonLoss = 0 ;  
 	  	//alert(sumRepairLoss+"::00::"+sumPropLoss+"::00::"+sumComponentLoss+"::00::"+sumPersonLoss);  
 	sumPreDefLoss =   parseFloat(sumRepairLoss)+ parseFloat(sumPropLoss)+ parseFloat(sumComponentLoss)+parseFloat(sumPersonLoss);

            try{
			fm.prpLcarLossSumCertainLoss.value=point(round(sumPreDefLoss,2),2); 
			
	             }catch(ex1)

	            {
	                return false;
	            }


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
                     
  sumDefLoss = sumLoss - sumReject;  
  
  fm.all("prpLpersonSumDefLoss")[findex].value = point(round(sumDefLoss,2),2);        
  sumPersonLossFee();              
} 
 
  /**
   *@description ������Ա�������ü��� 
   *             �����˵�������޳�����������л��� 
   *@param       ��
   *@return      ��
   */  
  function sumPersonLossFee()  
  { 
    //alert("------sumPersonLossFee-------");  
    /**********************/
    var prpLpersonSumLossSum = 0 ;        //������
    var prpLpersonSumRejectSum  = 0 ;     //�޳����
    var prpLpersonSumDefLossSum = 0 ;     //������ 
    var sumLoss = 0 ;
    var sumReject = 0 ;
    var sumDefLoss = 0 ; 
    var vlength = 0; 
    //fm.all("SumDefLoss2").length>0
    if(isNaN(fm.all("prpLpersonSumLossSum")) || fm.all("prpLpersonSumLossSum") != null || fm.all("prpLpersonSumLossSum") != undefined){
      vlength = fm.all("prpLpersonSumLossSum").length; 
    }  
    //alert(vlength);
    //var vlength = fm.all("prpLpersonSumLossSum").length;  
    if(vlength>0){   
      for(j=1;j<fm.all("prpLpersonSumLossSum").length;j++){
        for(i=1;i<fm.all("prpLpersonSumLoss").length;i++){  
          if(j == fm.all("personSerialNo")[i].value){  
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
   *@description �鿴�ƶ����ļ�
   *@param       fileName��businessNo��uploadFileName
   */
  function viewFile(fileName,businessNo){
    //document.fm.action="/claim/DAA/certify/download.jsp?fileName="+fileName+"&businessNo="+businessNo+"&uploadFileName="+uploadFileName;
    //document.fm.submit();
    window.open("/claim/DAA/certify/CertifyViewFile.jsp?fileName="+fileName+"&businessNo="+businessNo,businessNo,"resizable=0,scrollbars=1,width=800,height=600");
  }



/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function fileSave(field,saveType)
{   
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'Certify_Data'))
  {
    return false;
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	 
}

/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function fileSavePop(field,saveType)
{   
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'Certify_Data'))
  {
    return false;
  }
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  fm.target="_self";
  fm.submit(); 
  //return true;   	
}

//Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��
/*
//Modify By sunhao add end 2004-09-06
//��ť�����¼���������ͬ��������౨������ʾ
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
//��ʾ�����
//leftMove Ĭ��ֵ0����������leftMove
function showSubPage1(spanID,leftMove) 
{
  var intLeftMove = (leftMove==null?0:leftMove);
  var span = eval(spanID );
  var strTemp = span.id;
  
  var ex=window.event.clientX+document.body.scrollLeft;  //�õ��¼�������x
  var ey=window.event.clientY+document.body.scrollTop;   //�õ��¼�������y
  
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
  //Modify By wangli remark end 20050328

/**
 @author      ��ɸ�
 @description ʹһ������������Ϊֻ��
 @param       iElement: ��   
 @return      ��
 */
function setReadonlyOfElement(iElement)
{
  if (iElement.type=="text")
  {
    if(iElement.onblur!=null)
    {
      //iElement.oldOnblur = getFunctionName(iElement.onblur.toString());
    }
    //iElement.onblur = functionDoNothing;

    if(iElement.ondblclick!=null)
    {
      //iElement.oldOndblclick = getFunctionName(iElement.ondblclick.toString());
    }
    //iElement.ondblclick = functionDoNothing;

    if(iElement.onfocus!=null)
    {
      //iElement.oldOnfocus = getFunctionName(iElement.onfocus.toString());
    } 
    //iElement.onfocus = functionDoNothing;
    
    iElement.readOnly  = true;
    iElement.value     = "";
    iElement.className = "readonly";
  }
}


/**
 @author      ��ɸ�
 @description ʹһ������������Ϊ������
 @param       iElement: ��   
 @return      ��
 */
function undoSetReadonlyOfElement(iElement)
{
  iElement.readOnly = false;  
  iElement.className = 'common';
}   
                           
/**
 @author      ��ɸ�
 @description ���ø�ҳ���ԣ�ֻ�����д��
 @param       ��
 @return      ��
 */
function setPropertyOfPage(Field)
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
  
  var prpLpersonPayPersonType = parseInt(Field.value);
     
  //����ֻ�����˲����ģ�ֻ���˲в���¼���˲б���
  if(prpLpersonPayPersonType ==1 || prpLpersonPayPersonType==4 || prpLpersonPayPersonType==5)
  {
    setReadonlyOfElement(fm.prpLpersonRelatePersonNo[findex]);   
    if(prpLpersonPayPersonType==5)  //��Ա����Ϊ����
    {
      setReadonlyOfElement(fm.prpLpersonLossRate[findex]);   
    } 
    else
    {
      undoSetReadonlyOfElement(fm.prpLpersonLossRate[findex]);           
    } 
  }
  else
  {
    undoSetReadonlyOfElement(fm.prpLpersonRelatePersonNo[findex]);   
    setReadonlyOfElement(fm.prpLpersonLossRate[findex]);  
  }
}

/**
 @author      ��ɸ�
 @description У�������Ա
 @param       Field: ������  
 @return      boolean: �Ϸ�Ϊtrue,����Ϊfalse  
 @see         UICommon.js#isEmpty��checkInteger 
 */ 
function checkRelatePersonNo(Field)
{   
  /*             
  if(isEmpty(Field))
    return true;
    
  if (checkInteger(Field,1,100)==false)
  {
    return false;
  }    
  */
  /* 
  var fieldname=Field.name; 
  var findex=0;  
  var i = 0; 
  var j = 0; 
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == Field )
    {
      findex=i;
      break; 
    }
  }    
  var bFind = false;
  for(j=1;j<fm.all("prpLpersonSerialNo").length;j++)
  {
    if(fm.all("prpLpersonSerialNo")[j].value == Field.value )
    {    
      if(fm.prpLpersonPayPersonType[j].value!="1"
        &&fm.prpLpersonPayPersonType[j].value!="4"
        &&fm.prpLpersonPayPersonType[j].value!="5") {
      	  alert("���ܹ����˲����������Ա����,���������룡");
      	  Field.focus();   
      	  Field.select();  
      	  return false;  
      }     
      bFind=true; 
  		break;
    } 
  }
	if(bFind==false)
	{
	  alert("�ù�����Ա������,���������룡");
	  Field.focus();
	  Field.select(); 
	  return false;
  }    
  */    
  return true;   
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
//Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 /*
function relate(){	
		var policyNo = fm.PolicyNo.value;
		var registNo = fm.RegistNo.value;
    var newWindow = window.open("/claim/RelateBusinessNo.do?policyNo=" +policyNo+ "&registNo=" +registNo,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 
*/
//Modify By wangli remark end 20050328

/**
 *@description ���ݱ��ۣ�������ʼ����㲿���ļ۸�
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
    MaterialFee = QuotedPrice*(1+fm.prpLcarLossSumManageFeeRate.value/100);
    fm.all("prpLcomponentMaterialFee")[findex].value = point(round(MaterialFee,2),2);
    fm.all("prpLcomponentMaterialFee")[findex].onblur();
  }else{
    for( i = 1; i < fm.all("prpLcomponentMaterialFee").length; i++ ) { 
      QuotedPrice = parseFloat(fm.all("prpLcomponentQuotedPrice")[i].value); 
      MaterialFee = QuotedPrice*(1+field.value/100); 
      fm.all("prpLcomponentMaterialFee")[i].value = point(round(MaterialFee,2),2);
      fm.all("prpLcomponentMaterialFee")[i].onblur(); 
    }
  }
  return true;         
 } 

/**
 *@description ������������������
 *@param       ��
 *@return      ͨ������true,���򷵻�false
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
  
  //�����������ֵ
  if(field.checked==true){
    fm.all(fieldname+"Txt")[findex].value = "1";
  } else {    
    fm.all(fieldname+"Txt")[findex].value = "0"; 
  }      
  //alert(fm.all(fieldname+"Txt")[findex].value);  
  return true; 
  
  
} 
  
/**
 @author      liubvo
 @description ����/���������嵥����
 @param       �� 
 @return      boolean: �Ϸ�Ϊtrue,����Ϊfalse  
 @see         UICommon.js#point��round
 @see         UIMulLine.js#private_getRowsCount
*/   
function calculateAll() 
{   
  var i = 0;  
  var materialFeeL   = 0; //���㳵��������ʧ���úϼ�
  var manHourFee     = 0;
  var materialFee    = 0;
  var sumManHourFee  = 0;
  var sumMaterialFee = 0; 
  var SumDefLoss     = 0;
  var TotalSumDefLoss     = 0;
  var ManHour; 
  var Quantity;

      var sumComponentVerpCompPrice = 0 ; //�����Ѻϼ�
     var sumManageFee = 0; //����� 
     var sumVerifyManageFee = 0; //�ܹ�˾�˶������
     var sumTax = 0;       //˰��   
     var sumTransFee = 0;  //�˷�
     var sumRestFee = 0;   //��ֵ�ϼ�
     var quantity = 0 ;     
     var verpCompPrice = 0 ; 
  //��������嵥����  

  if(fm.prpLrepairFeeCompCode.length>0){
    for(i=1;i<fm.prpLrepairFeeCompCode.length;i++) 
    {        
      ManHour     = parseFloat(fm.all("prpLrepairFeeManHour")[i].value); 
      manHourFee  = parseFloat(fm.all("prpLrepairFeeManHourUnitPrice")[i].value);
      SumDefLoss  = parseFloat(fm.all("prpLrepairFeeSumDefLoss")[i].value); 
      
      if(isNaN(ManHour))
        ManHour = 0;      
      if(isNaN(manHourFee)) 
        manHourFee = 0;
      if(isNaN(SumDefLoss))
        SumDefLoss = 0;
          


      sumManHourFee  = sumManHourFee+manHourFee*ManHour;
      //sumMaterialFee = sumMaterialFee + materialFee;
      TotalSumDefLoss = TotalSumDefLoss + SumDefLoss;

      //���㳵��������ʧ���úϼ�
      if(fm.prpLrepairFeeKindCode[i].value=="L")
        materialFeeL = materialFeeL + materialFee; 
    }

    if(materialFeeL>5000) 
    {
      alert("��������ʧ������������Ϊ5000Ԫ!");
      return false;
    }       
    fm.SumManHourFee1.value  = point(round(sumManHourFee,2),2);        
    fm.SumDefLoss1.value = point(round(sumManHourFee,2),2);          


  } else{
    fm.SumManHourFee1.value  = 0.00;        
    fm.SumMaterialFee1.value = 0.00;
    fm.SumDefLoss1.value = 0.00; 

  }
        
  sumManHourFee  = 0;
  sumMaterialFee = 0; 
          
  //���������嵥����      
  if(fm.prpLcomponentCompName.length>0)
  {
    for(i=1;i<fm.prpLcomponentCompName.length;i++) 
    {               
      manHourFee  = parseFloat(fm.all("prpLcomponentManHourFee")[i].value);
      materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);
      Quantity    = parseInt(fm.all("prpLcomponentQuantity")[i].value); 
      SumDefLoss  = parseFloat(fm.all("prpLcomponentSumDefLoss")[i].value);

      if(isNaN(Quantity))
        Quantity = 0;
      if(isNaN(manHourFee))
        manHourFee = 0;
      if(isNaN(materialFee))
        materialFee = 0;
      if(isNaN(SumDefLoss))
        SumDefLoss = 0;
                       
      sumManHourFee   = sumManHourFee + manHourFee;
      sumMaterialFee  = sumMaterialFee + materialFee*Quantity;
      TotalSumDefLoss = TotalSumDefLoss + SumDefLoss;          
    
    }  
    
    //if(TotalSumDefLoss>3000 && fm.EscapeFlag.value=='2')
    if(TotalSumDefLoss>3000)
    {       
      //alert("���ⰸΪ�������ⰸ,�ۼ���ʧ���ܳ���3000Ԫ��");
      return false;      
    }   
        
    fm.SumManHourFee2.value  = point(round(sumManHourFee,2),2);        
    fm.SumMaterialFee2.value = point(round(sumMaterialFee,2),2);       
//===============================
     sumManageFee = parseFloat(fm.all("prpLcarLossSumManager").value); //����� 
     sumVeriManageFee = parseFloat(fm.all("prpLcarLossSumVeriManager").value); //�ܹ�˾�˶������
     sumTax = 0;//parseFloat(fm.all("prpLcarLossSumTax").value);       //˰��   
     sumTransFee = 0;//parseFloat(fm.all("prpLcarLossSumTransFee").value);  //�˷�
     sumRestFee = parseFloat(fm.all("prpLcarLossSumRest").value);   //��ֵ�ϼ�
     
     if(isNaN(sumManageFee)) sumManageFee = 0;
     if(isNaN(sumVeriManageFee)) sumVeriManageFee = 0;
     if(isNaN(sumTax)) sumTax = 0;
     if(isNaN(sumTransFee)) sumTransFee = 0;
     if(isNaN(sumRestFee)) sumRestFee = 0;

 
     if(sumVeriManageFee!=0)
       sumManageFee = sumVeriManageFee;
         
     for(i=1;i<fm.all("prpLcomponentQuantity").length;i++)
     {
   	    quantity = parseFloat(fm.all("prpLcomponentQuantity")[i].value);   	    
   	    verpCompPrice = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);
   	
      	 if(isNaN(quantity)) quantity = 0;
        
        if(isNaN(verpCompPrice)) verpCompPrice = 0; 
          
        sumComponentVerpCompPrice   = sumComponentVerpCompPrice + parseFloat(point(round(quantity*verpCompPrice,2),2));        
     } 
     
     //�����Ѻϼ� = �˼ۺϼ� + ����� + ˰�� + �˷� ?C ��ֵ�ϼ�(�˼ۺϼ� = ÿһ������ĺ˼� �� ����֮��)
     sumComponentVerpCompPrice = sumComponentVerpCompPrice + sumManageFee + sumTax + sumTransFee - sumRestFee;
     
     //�����Ѻϼ�
     //alert("����fm.SumDefLoss2.value 2")
//     fm.SumDefLoss2.value = point(round(sumComponentVerpCompPrice,2),2);
//============================================
    fm.SumDefLoss2.value = point(round(sumManHourFee+sumMaterialFee,2),2);        
  } else {
    fm.SumManHourFee2.value  = 0.00;        
    fm.SumMaterialFee2.value = 0.00; 
//    alert("����fm.SumDefLoss2.value 3")
    fm.SumDefLoss2.value = 0.00;  
  }   
   
  return true; 

}
  
/**
*@description �������������嵥 
*@param       businessNo 
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"winName","resizable=0,scrollbars=1,width=800,height=600");
}    

//Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��
/**
 *@description ������֤ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openCertify(registNo){   
  var win;
  var messagedo="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo="+registNo+"&editType=EDIT&nodeType=certa";  
  //win=window.showModalDialog(messagedo,"dialogTop=0;dialogLeft=0;dialogWidth=800;dialogHeight=600");
  //win=window.open(messagedo,"NewWindow","dialogWidth:750px;dialogHeight:550px; dialogLeft:15px;dialogTop:15px;center:yes;help:yes;resizable:yes;status:yes");
  win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
} 
*/
//Modify By wangli remark end 20050328

//Modify by chenrenda add begin 20050414
//�����ֵ�ܶ�
function calculateSumRestFee(field){   
  
  var count=getElementCount("prpLcomponentRestFee");
  var restFee = 0;
  var temp = 0;
  
  for(var j=1;j<count;j++)
  {
    
    temp = parseFloat(fm.prpLcomponentRestFee[j].value);
    if(isNaN(temp))
    {
      temp = 0;      
    }
    restFee = restFee + temp;
  }
  fm.prpLcarLossSumRest.value=restFee;
} 

//Modify by chenrenda add end 20050414




/**
 *@description
 *@param       ��
 *@return      ��
 */ 
  function setNextNode() 
  { 
     var repairFactoryType = "";  //��������
     var materialFee = 0;         //�ϱ��۸�
     var sysPrice = 0 ;   //�˼�Ĭ��ֵ
     var sys4SPrice = 0;          //ϵͳר�޼� 
     var sysMarketPrice = 0;      //ϵͳ�г���
     var sumTax = 0;              //����ר�޼�
     var sumTransFee = 0;         //�����г���
     var condition = 0;
          
     repairFactoryType = fm.prpLrepairFeeRepairFactoryCode.value;
     
     if (( parseFloat(fm.SumDefLoss1.value) > parseFloat(fm.prpLclaimGradeSumWorkHourFee.value))||
          (parseFloat (fm.SumDefLoss2.value) >  parseFloat(fm.prpLclaimGradeSumChangCompFee.value)))
     {  
     	  condition = 1;
     	}

     for(i=1;i<fm.all("prpLcomponentSys4SPrice").length;i++)
     {
   	    materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[i].value);   	    


   	    if(fm.all("prpLcomponentFlag")[i].value=="1"){  //��׼���
     	    sys4SPrice = parseFloat(fm.all("prpLcomponentSys4SPrice")[i].value);   	    
     	    sysMarketPrice = parseFloat(fm.all("prpLcomponentSysMarketPrice")[i].value);
     	    native4SPrice = parseFloat(fm.all("prpLcomponentNative4SPrice")[i].value);   	    
     	    nativeMarketPrice = parseFloat(fm.all("prpLcomponentNativeMarketPrice")[i].value);
     	
         	if(isNaN(materialFee)) materialFee = 0;
         	if(isNaN(sys4SPrice)) sys4SPrice = 0;
         	if(isNaN(sysMarketPrice)) sysMarketPrice = 0;
         	if(isNaN(native4SPrice)) native4SPrice = 0;
         	if(isNaN(nativeMarketPrice)) nativeMarketPrice = 0;
         	
         	if(repairFactoryType=="01"){ //����Ϊר�޵�
         	  if(native4SPrice==0){         	    
         	    sysPrice = sys4SPrice;         	           	    
         	  }else{
         	    sysPrice = native4SPrice;         	           	           	  
         	  }
         	}else{      //����Ϊһ�೧�����೧����
         	  if(nativeMarketPrice==0){
         	      sysPrice = sysMarketPrice;
         	  }else{
        	      sysPrice = nativeMarketPrice;
         	  }       	
          }

        	if (materialFee>sysPrice){
         		condition = 1;
        		break;		
        	}
        }else{    //�Զ������
	        condition = 1;	  
	        break;
        }        
     }  

     if(condition==1){
     	 fm.verifyPriceFlag.value = "1";
     }     
  }   

function initCarLossSum(type)
{ 
	if (type==1){
		//      setReadonlyOfElementOfLoss(fm.prpLcarLossSumTransFee); 
		//      setReadonlyOfElementOfLoss(fm.prpLcarLossSumTax); 
		      setReadonlyOfElementOfLoss(fm.prpLcarLossSumManager); 
		      setReadonlyOfElementOfLoss(fm.prpLcarLossSumRest); 
			//fm.prpLcarLossSumTransFee.value=0;
			//fm.prpLcarLossSumTax.value=0;
			fm.prpLcarLossSumManager.value=0;
			fm.prpLcarLossSumRest.value=0;
			  
		}else{
		//      setNoReadonlyOfElementOfLoss(fm.prpLcarLossSumTransFee); 
		//      setNoReadonlyOfElementOfLoss(fm.prpLcarLossSumTax); 
		      setNoReadonlyOfElementOfLoss(fm.prpLcarLossSumManager); 
		      setNoReadonlyOfElementOfLoss(fm.prpLcarLossSumRest); 
		}
}		
     

function setNoReadonlyOfElementOfLoss(iElement)
{
  if(iElement.type!=null){
    if(iElement.type=="select-one")
    {
      iElement.disabled = true;
    } 
   
    else if (iElement.type=="text")
    {
      iElement.onfocus = null;                   
      iElement.readOnly = false;
      iElement.className = "input";
    }
  }
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

