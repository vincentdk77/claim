/*****************************************************************************
 * DESC       �����ȵǼǵĽű�����ҳ��
 * AUTHOR     ��lixiang	 
 * CREATEDATE �� 2004-07-26
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


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
  
  fm.buttonSaveFinish.disabled = true;
  fm.buttonSaveFinishSubmit.disabled = true;
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
 *@description ��ֵҳ���һЩ��ʼ����Ϣ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function initSet() 
{ 
	//initRegistText();
  return true;
}

/**
 *@description ���ݰ�ť״̬�����������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field)
{
  
  //copy the selectSend��־
  
  if(!validateForm(fm))
  {
  	return false;
  }
  
  //��ϵ���ֻ������ж�
  /*
  if((fm.prpLregistLossName.value).length>0&&(fm.prpLregistLossName.value).length!=11)
  {
  	alert("��������ȷ���ֻ�����");
  	fm.prpLregistLossName.focus();
    fm.prpLregistLossName.select();
  	return false;
  }   
  */
  
  //����������
  if (fm.saveType.value=="GETBACKEDIT"){
  	if (!CheckGetBackSchedule()) return false;
  	
  }else{
  
     if (!checkscheduleForm(fm))
     {
  	    return false;
     }
   }
  //add by liyanjie 2005-12-12 start ˫������,���ȱ���ȫ����������ύ
  if(fm.prpLscheduleMainWFDtoCommiFlag.value== "1")
  {
  	if(!allDeal(fm))
    {
  	  alert("�˰���Ϊ˫������,��ȫ������������Ŀ���ύ!");
  	  return false;
    }
  }
  //add by liyanjie 2005-12-12 end
  
 // window.location.href =fm.nowURL.value;
  //modify by weishixin add end 20040616
  
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  fm.submit();
  
  return true;   	
}
/**
 *@description ����������
 *@param       this
 *@param       ���״̬
 *@return      ͨ������true,���򷵻�false
 */
function checkscheduleForm(field)
{
//1.����Ƿ�ѡ����һ��checkBox

//2.���ѡ����checkbox�Ĳ鿱��Ϣ�ͳ��յ�ַ����Ҫ�����ݡ�	
 	
   var i           = 0;
   var j           = 0;
   var selectCount = 0; //ѡ�������
  
   var maxRow = fm.maxrow.value ;  //�����ĵ���Ŀ
   var saveType=fm.saveType.value; //��ȡ�ػ���ֱ�ӵ���
   var scheduleObjectID="";
  // alert(maxRow);
  //1�����ȼ����Ƕ�������ǲ�����ѡ�������
  //ֻ��һ�У��ж��ǲ���ѡ���˲鿱����
  
  //û�в鿱��ֻ��Ҫ�ж϶���Ϳ�����
  
  if (fm.nocheck.value=="1"){
  	
  	fm.scheduleType.value="schel"; //ֻ�ж���
  	if ((maxRow==1)||!(fm.checkYesNo.length>0))
    {
  	   //�ж��Ƿ�ѡ�У���û��ѡ�У���ô�Ϳ���ֱ�ӽ�����һ����¼���жϡ�
  	   if (fm.checkYesNo.checked==false)
  	   {
         	errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
   	      return false;
       }
  	    return  CheckOnlySchel();
     }
     
     //�����Ķ�����ȵ��ж�
     return CheckMulitSchel();
  
  }
  //���¶����в鿱�����ҳ��
   if (fm.checkScheduleCheckYesNo.checked==true)
   {
   	  //��ʾ��ѡ�У���Ҫ���в鿱����
  	  fm.checkSelectSend.value="1";  
      
      if (((fm.prpLscheduleMainWFScheduleObjectID.value).toString().length)<1)
       {
         errorMessage("�鿱����λ���벻��Ϊ��!");
         fm.prpLscheduleMainWFScheduleObjectID.focus();
         return false;
       }
       
       if (((fm.prpLscheduleMainWFScheduleObjectName.value).toString().length)<1)
       {
       	
         errorMessage("�鿱����λ���Ʋ���Ϊ��!");
         fm.prpLscheduleMainWFScheduleObjectName.focus();
         return false;
       }
       
       if ((fm.checkYesNo.checked==false) &&(fm.checkScheduleCheckYesNo.checked==true))
  	   {
        	errorMessage("ũ����Ҫͬʱѡ��鿱���ȺͶ�����ȣ�")
   	      return false;
       }
        //�ж����ѡ����Ǳ��չ�˾������ѡ����Ա
        /*
        if (fm.prpLscheduleMainWFScheduleObjectID.value== fm.comcode.value){
        	
        	if (((fm.nextHandlerCode1.value).toString().length)<1) {
        	  	 errorMessage("��ѡ��鿱������Ա!");
               fm.nextHandlerCode1.focus();
               return false;
        	  }
        }	    
       */
  
   }
 
  if ((maxRow==1)||!(fm.checkYesNo.length>0))
  {
  	//�ж��Ƿ�ѡ�У���û��ѡ�У���ô�Ϳ���ֱ�ӽ�����һ����¼���жϡ�
  	if ((fm.checkYesNo.checked==false) &&(fm.checkScheduleCheckYesNo.checked==false))
  	{
     	errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
   	  return false;
    }
    //ֻѡ���˶�����ȣ��жϣ����Ƚ��в鿱���ȣ�
    
    if ((fm.checkYesNo.checked==true) &&(fm.checkScheduleCheckYesNo.checked==false))
  	{
     	errorMessage("ũ����Ҫͬʱѡ��鿱���ȺͶ�����ȣ�")
   	  return false;
    }
      if (fm.checkYesNo.checked==true){
       //����������ȵ��ж�
       return  CheckOnlySchel();
       
      }
      
      return true;
     }
     
     //�����Ķ�����ȵ��ж�
     return CheckMulitSchel();
 
}


//���仯�˵��ֳ����ͱ��浽��Ӧ�ֶ���
function setSurveyType(fieldObject){
	
	var  intIndex = parseInt(fieldObject.num);
	var recordCount = fm.maxrow.value;
	if(recordCount<=1){
	 fm.prpLscheduleItemSurveyType.value=  fieldObject.value;
  } else{	  
   fm.prpLscheduleItemSurveyType[intIndex].value=  fieldObject.value;

  }
 
}

/**
*��鵥���Ķ�����ȵ������ǲ��ǿ������������Ϊ��
*
*/
function CheckOnlySchel()
{
 //����selectSend������
  	    fm.prpLscheduleItemSelectSend.value="1";
  	    //Ĭ�����ýڵ�����Ϊ����
  	    fm.nextNodeNo.value="certa";
  	   //�жϵ��ȶ���͵������Ƶ�
  	     if (((fm.prpLscheduleItemScheduleObjectID.value).toString().length)<1)
        {
          errorMessage("������λ���벻��Ϊ��!");
          fm.prpLscheduleItemScheduleObjectID.focus();
          return false;
        }
        
        if (((fm.prpLscheduleItemScheduleObjectName.value).toString().length)<1)
        {
        	errorMessage("������λ���Ʋ���Ϊ��!");
          fm.prpLscheduleItemScheduleObjectName.focus();
          return false;
        }
        
        //�ж϶����ַ
        if (((fm.prpLscheduleItemCheckSite.value).toString().length)<1)
        {
          errorMessage("�����ַ����Ϊ��!");
          fm.prpLscheduleItemCheckSite.focus();
          return false;
        }
        if(fm.checkYesNo.checked==true && fm.checkYesNo.disabled==true){
        	errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
   	 		return false;
        } 	    
         	    
        //�ж����ѡ����Ǳ��չ�˾������ѡ����Ա
        /*
        if (fm.prpLscheduleItemScheduleObjectID.value== fm.comcode.value){
        	
        	if (((fm.nextHandlerCode.value).toString().length)<1) {
        	  	 errorMessage("��ѡ��������Ա!");
               fm.nextHandlerCode.focus();
               return false;
        	  }
        }	  */  
   	    return  true;
}

//ѡ�и�ѡ�������prpLCheckSelectSendֵΪ1
function setSmcSend()
{
   var intCount = fm.txtScheduleSmcSend.length;
   if(isNaN(fm.txtScheduleSmcSend.length))
   {
     fm.prpLCheckSelectSend.value="1";      	
   }else
   {
     for(i=0;i<intCount;i++)
     {
       if (fm.txtScheduleSmcSend[i].checked==true) 
  	   {
  	     fm.prpLCheckSelectSend[i].value="1";      	  
  	   }else
  	   {
  	     fm.prpLCheckSelectSend[i].value="0";      	    
  	   }
  	 }     
   }
}
 
/**
*���������Ƿ�ѡ����ȷ���ж�
*/
function CheckMulitSchel()
{
	 var i           = 0;
   var j           = 0;
   var selectCount = 0; //ѡ�������
  
   var maxRow = fm.maxrow.value ;  //�����ĵ���Ŀ
   var saveType=fm.saveType.value; //��ȡ�ػ���ֱ�ӵ���
   var scheduleObjectID="";
//�����Ķ�����ȵ��ж�
     
     for(i=0;i<maxRow;i++)
     {
        	//�ж��Ƿ�ѡ�У���û��ѡ�У���ô�Ϳ���ֱ�ӽ�����һ����¼���жϡ�ֻҪ��ûѡ�У�����Ϊ��û�������
  	
  	     if (fm.checkYesNo[i].checked==false) 
  	      {
  	      	  scheduleObjectID=fm.prpLscheduleItemScheduleObjectID[i].value;
  	      	  if (scheduleObjectID.toString().length<1) {
  	      	  	//fm.prpLscheduleItemScheduleObjectID[i].value="0";
  	      	  	//fm.prpLscheduleItemScheduleObjectName[i].value="_";
  	      	  	
  	      	  }
  	      	  fm.prpLscheduleItemSelectSend[i].value="0";
  	      	  
  	          continue;
          }
      	 //һ��Ҫд���ѽ��������
  	     if (fm.checkYesNo[i].disabled==true) continue; //˵���Ѿ����ȹ���
  	
  	     selectCount++;
  	
  	     //����selectSend������
  	     fm.prpLscheduleItemSelectSend[i].value="1";
  	     //alert(fm.prpLscheduleItemItemNo[i].value);
  
  	     if (fm.prpLscheduleItemItemNo[i].value=="0"){
  	         fm.nextNodeNo[i].value="wound"; //����	
  	     }else if(fm.prpLscheduleItemItemNo[i].value=="-1")
  	     {
  		       fm.nextNodeNo[i].value="propc"; //�Ʋ���ʧ
  	      }else{
  	     fm.nextNodeNo[i].value="certa"; //����
       }
  		
  		if (fm.prpLscheduleItemItemNo[i].value=="1"&&fm.nocheck.value=="0")
  		 {
  		 	//���ѡ�����������ж��ǲ���ѡ��鿴�ˡ���
  		 	
  		    if (fm.checkScheduleCheckYesNo.checked==false)
  	        {
     	        errorMessage("ѡ�������ʱ����Ҫѡ��鿱���ȣ�")
   	          return false;
             }
  		}
  		
  		
  	   if (((fm.prpLscheduleItemScheduleObjectID[i].value).toString().length)<1)
       {
    	
          errorMessage("������λ���벻��Ϊ��!");
          fm.prpLscheduleItemScheduleObjectID[i].focus();
           return false;
        }
    
        if (((fm.prpLscheduleItemScheduleObjectName[i].value).toString().length)<1)
        {
    	    
           errorMessage("������λ���Ʋ���Ϊ��!");
           
           fm.prpLscheduleItemScheduleObjectName[i].focus();
           return false;
         }
  	
  	
        //�жϲ鿱��ַ
        if (((fm.prpLscheduleItemCheckSite[i].value).toString().length)<1)
        {
    	        if (fm.prpLscheduleItemItemNo[i].value=="0"){
    	     	errorMessage("��"+(i+1)+"��,��ҽҽԺ����Ϊ��!");
    	         }else{
    	    errorMessage("��"+(i+1)+"��,�����ַ����Ϊ��!");
    	  }
             
             fm.prpLscheduleItemCheckSite[i].focus();
             return false;
        }
        
         //�ж����ѡ����Ǳ��չ�˾������ѡ����Ա
         /*
        if (fm.prpLscheduleItemScheduleObjectID[i].value== fm.comcode.value){
        	
        	if (((fm.nextHandlerCode[i].value).toString().length)<1) {
        	  	 errorMessage("��ѡ��������Ա!");
               fm.nextHandlerCode[i].focus();
               return false;
        	  }
        }	  */  
        
 	  
   }
   
   //�ж��ǲ���û��ѡ��һ��checkbox
   var finishSchedule=fm.prpLscheduleItemFinishSchedule.value;
   
    if (fm.nocheck.value=="1"){
       if (selectCount < 1 &&finishSchedule==""&&(saveType==""))
       {
         	errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
        	return false;
       }
    }else{
    
       //�鿱û�е��ȵ�����������ж�
       if ((selectCount< 1)&&(finishSchedule=="")&&(fm.checkScheduleCheckYesNo.checked==false)&&(saveType==""))
       {
         	errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
        	return false;
       } 
       //�鿱������ϵ����,û��ѡ�������
       if ((selectCount< 1)&&(finishSchedule=="")&&(fm.checkScheduleCheckYesNo.disabled==true)&&(saveType==""))
       {
         	errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
        	return false;
       }
       if(selectCount< 1 && fm.checkScheduleCheckYesNo.disabled==true){
       		errorMessage("����ѡ��һ�����ȵı����Ϣ���ſ��Ա��������Ϣ��")
        	return false;
       } 
    }

  
   return true;
}

/**
*�����ȸ���
*/
function CheckGetBackSchedule()
{
   if (fm.getbackNodeType.value=="check"){
   	 if (((fm.prpLscheduleMainWFScheduleObjectID.value).toString().length)<1)
       {
       	
         errorMessage("�鿱����λ���벻��Ϊ��!");
         fm.prpLscheduleMainWFScheduleObjectID.focus();
         return false;
       }
       
       if (((fm.prpLscheduleMainWFScheduleObjectName.value).toString().length)<1)
       {
       	
         errorMessage("�鿱����λ���Ʋ���Ϊ��!");
         fm.prpLscheduleMainWFScheduleObjectName.focus();
         return false;
       }
       
       return true;
  }else{
   return  CheckOnlySchel();
  }
}


    //�������ɵ����õ�
    function setNewHandlerCode(fieldObject){
       
            fm.newHandlerCode.value=fieldObject.value
          
    }
    
     //����ɸѡ���ȵľ������õ�
    function setNewComCode(fieldObject){
            fm.selectcomcode.value=fieldObject.value
            //fm.newcomcode.value=fieldObject.value
            //�ж���ѡ���˲鿱�Ĵ���λ�����Ƕ�����ȵĴ���λ
            	var  intIndex = parseInt(fieldObject.num);
            //ѡ��鿱����λ
            if (intIndex<0){
            	fm.nextHandlerCode1.value="";
            	fm.nextHandlerName1.value="";
            	
            	return
           }
           
           var maxRow = fm.maxrow.value
           //ѡ������λ�����Ҷ������ֻһ����¼
           if (maxRow=='1'){
           		fm.nextHandlerCode.value="";
            	fm.nextHandlerName.value="";
            return
           }
           
           
           fm.nextHandlerCode[intIndex].value="";
           fm.nextHandlerName[intIndex].value="";
          
    }
   
    //����ɸѡ���ȵľ������õ�
    function setNewHandlerComCode(fieldObject){
            
            //fm.newcomcode.value=fieldObject.value
            //�ж���ѡ���˲鿱�Ĵ���λ�����Ƕ�����ȵĴ���λ
            	var  intIndex = parseInt(fieldObject.num);
            	
            	//alert (intIndex)
            //ѡ��鿱����λ
            if (intIndex<0){
            	fm.selectcomcode.value = fm.prpLscheduleMainWFScheduleObjectID.value;
             	return
           }
           
           var maxRow = fm.maxrow.value
           //ѡ������λ�����Ҷ������ֻһ����¼
           if (maxRow=='1'){
           		fm.selectcomcode.value =fm.prpLscheduleItemScheduleObjectID.value;
            return
           }
           
           
           fm.selectcomcode.value = fm.prpLscheduleItemScheduleObjectID[intIndex].value;
           
          
    }
   
   /**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

/**
 *@description ���������Ļ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relateRegist(){	
		var registNo = fm.prpLscheduleMainWFRegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.prpLscheduleMainWFRiskCode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

/**
 *@description ����˫��  add by liyanjie 2005-12-06
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */

function applyCommi(field)
{
	
	if(!confirm("��ȷ��Ҫ�������ύ˫����Ա������?Y/N �ύ��,����������Ĳ鿱������ȵ�����."))
	{
		return false;
	}
	fm.CheckBoxCommiFlag.checked = true;
	fm.checkScheduleCheckYesNo.checked = false;
	var count = getElementCount('checkYesNo');
	if(count==0){
	}else if(count==1){
    fm.checkYesNo.checked = false;  	
  }else{
  	for(var i=0;i< fm.checkYesNo.length;i++){
      fm.checkYesNo[i].checked = false;
    }
	}
	//��˫����ʶ��Ϊ��ѡ��,���鿱����ĵ������
	field.disabled = true;

	fm.action="/claim/processCommiCase.do?actionType=apply";
  fm.submit(); 
}   


  //add by liyanjie start 2005-12-12
  //�ж��Ƿ�������Ŀ�����˵���,����˫���İ���,����ȫ����������ύ
function allDeal(fm)
{
  var allDealFlag = true;
  var maxRow = fm.maxrow.value ;  //�����ĵ���Ŀ

  //û�в鿱��ֻ��Ҫ�ж϶���Ϳ�����
  if (fm.nocheck.value=="1"){
  	
  }else{
  	if (fm.checkScheduleCheckYesNo.checked==false){
  		allDealFlag = false;
      return allDealFlag;
  	}
  }	
  if ((maxRow==1)||!(fm.checkYesNo.length>0))
  {
    if (fm.checkYesNo.checked==false)
    {
      allDealFlag = false;
      return allDealFlag;
    }
  }else{
    for(i=0;i<maxRow;i++)
    {
      if (fm.checkYesNo[i].checked==false) 
      {
        allDealFlag = false;
        return allDealFlag;
      }
    }
  }
  
  return allDealFlag;
  //add by liyanjie  end
}