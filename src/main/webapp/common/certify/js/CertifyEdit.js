/*****************************************************************************
 * DESC       ����֤�ǼǵĽű�����ҳ��
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-07-05
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description ��鵥֤�Ǽ�
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

//reason:�������ԣ��ʹ�����


//Modify By wangli remark begin 20050328
//reason: ͳһʹ��ClaimPub.js ��ķ���������ά��

/**
 *@description �����鿴����ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
/*
function openWinQuery(){
  var businessNo = fm.RegistNo.value;
  var policyNo = fm.policyNo.value;
  var riskCode = fm.riskCode.value;  
  var messagedo="/claim/messageQueryList.do?registNo="+businessNo;
  win=window.showModalDialog(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=500,Height=400");
}
*/
/** 
 *@description �������Ա���ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 /*
function openWinSave(){   
  var businessNo = fm.RegistNo.value;
  var policyNo = fm.policyNo.value;
  var riskCode = fm.riskCode.value;
  msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=certi&policyNo=" +policyNo+ "&riskCode=" +riskCode,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
}  
*/
   //Modify By wangli remark end 20050328 
  /**
  *@description �鿴�ƶ����ļ�(���ع���)
  *@param       fileName��businessNo��uploadFileName
  */
  function viewFile(fileName,businessNo){
  	
  	var editType = fm.editType.value;
  	
    //document.fm.action="/claim/common/certify/download.jsp?fileName="+fileName+"&businessNo="+businessNo+"&uploadFileName="+uploadFileName;
    //document.fm.submit();
    window.open("/claim/common/certify/CertifyViewFile.jsp?fileName="+fileName+"&businessNo="+businessNo+"&editType="+editType,businessNo,"resizable=0,scrollbars=1,width=800,height=600");
  } 
      
  /**
  *@description �鿴ȫ���ļ�
  *@param       businessNo
  */
  function viewFileAll(businessNo){
  	var editType = fm.editType.value;
  	
    //document.fm.action="/claim/common/certify/viewFile.jsp?businessNo="+businessNo;   
    //document.fm.submit();
    window.open( "/claim/common/certify/CertifyViewFile.jsp?businessNo="+businessNo+"&editType="+editType,"winName","resizable=0,scrollbars=1,width=800,height=600");
    //window.showModalDialog( "/claim/common/certify/viewFile.jsp?businessNo="+businessNo,window,'status:no;resizable:yes');
  }
      
  /**
  *@description �鿴ȫ���ļ� 
  *@param       businessNo
  */
  function doViewFile(directType){
    //document.fm.action="/claim/common/certify/viewFile.jsp?businessNo="+businessNo;   
    //document.fm.submit(); 
    var editType = fm.editType.value;
    var businessNo=fm.prpLcertifyCollectBusinessNo.value;
    window.open( "/claim/common/certify/CertifyViewFile.jsp?directType="+directType+"&businessNo="+businessNo+"&editType="+editType,"winName","resizable=yes,scrollbars=1,width=800,height=600");
    //window.showModalDialog( "/claim/common/certify/viewFile.jsp?businessNo="+businessNo,window,'status:no;resizable:yes');
  } 
      
  /**
  *@description �ϴ��ļ� 
  *@param       businessNo 
  */
  function doUploadFile(directType,lossItemCode,lossItemName,titleName,imageTypeList){  
    if(imageTypeList == "") {
        alert("����ѡ����Ҫ�ϴ�������.");
        return false;
    } 
    var businessNo=fm.prpLcertifyCollectBusinessNo.value;
    var uploadYear=fm.prpLcertifyCollectUploadYear.value;
    var riskCode=fm.prpLcertifyCollectRiskCode.value; 
    var nodeType= fm.nodeTypeUpload.value;
    var policyNo = fm.prpLcertifyCollectPolicyNo.value;
    var oldAction = fm.action;  
    var oldTarget = fm.target;  
    var userCode=fm.prpLcertifyCollectOperatorCode.value;

 	var url = "/claim/DAA/certify/DAACertifyUpload.jsp?directType="+directType+"&businessNo="+businessNo+"&lossItemCode="+lossItemCode+
  			  "&nodeType="+nodeType+"&lossItemName="+lossItemName+"&uploadYear="+uploadYear+"&riskCode="+riskCode+"&titleName="+titleName+
  			  "&imageTypeList="+imageTypeList+"&operatorCode="+userCode+"&policyNo="+policyNo;
  window.open(url,"winUpload","width=600,height=400,status=yes,menubar=no,location=no,resizable=yes,scrollbars=yes");
  //fm.action="/claim/applet/ViewApplet.jsp?directType="+directType+"&businessNo="+businessNo+"&lossItemCode="+lossItemCode+"&nodeType="+nodeType+"&lossItemName="+lossItemName+"&uploadYear="+uploadYear+"&riskCode="+riskCode+"&titleName="+titleName+"&imageTypeList="+imageTypeList+"&operatorCode="+userCode;
  //fm.target="fraSubmit";    
  //fm.submit(); 
  
  fm.action=oldAction;
  fm.target=oldTarget;   

  }   
  
      
/**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relatePolicy(policyNo){	 
    var riskCode = fm.prpLcertifyCollectRiskCode.value;
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL = CoreWebUrl +'/'+ riskCode + '/tbcbpg/UIPrPoEn' + riskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ policyNo+'&RiskCode='+ riskCode;
   
    window.open(vURL,'��ϸ��Ϣ','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
} 
/**
 *@description ���������Ļ���
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function relateRegist(){
		var registNo = fm.RegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskCode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

function ValidateHerdCertify()
{

   var element1 = document.getElementsByName("prpLcertifyDirectUploadFlagA008");
   if(element1.length > 0)
   {
     //alert("weikong");
     var temp = fm.prpLcertifyDirectUploadFlagA008.checked;
     if(temp != true)
     {
       return false;
     }
    
     return true;
     
   }
   return true;
}
/**
 *@description ���ݰ�ť״̬���浥֤����
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveForm(field,saveType)
{   

  fm.buttonSaveType.value = saveType; 
  var  riskCode = fm.prpLcertifyCollectRiskCode.value;
  var classCode = riskCode.substring(0,2);
  
  if(classCode == 32)
  {
   var validateherd = ValidateHerdCertify();
   if(validateherd == false)
   {
     alert('���ϴ�������Ƭ');
     return false;
   }
  }
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  /*
   if(!validateForm(fm,'Certify_Data'))
    {
      return false;
    }
    */
  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  //field.disabled = true;
  var checkReturn = true;
  //����ղ��������Ϳ��Ե�֤�ռ� modify by qinyongli 2005-8-9
  if (!(classCode==27)&&saveType=="4")
  {
    checkReturn = checkSubmitButton();       
  }
   if(!validateForm(fm))
  {
  	return false;
  }
  // modify by qinyongli   end 
  if(checkReturn==false){
    return false;  
  }    
  fm.submit();
  return true;   	
} 

/**
 *@description �����ռ���ȫ�ı�־
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function setCollectFlag(field)
{
  var fieldName = field.name;
  var tempElements = null;
  //�������ռ���־
  if(fieldName=="collectFlag"){
    //���������ռ���־Ϊ��ȫ��ʱ�����е����ռ���־�Զ���ȫ    
    if(field.value==1){
      for(i=0; i<document.all.length; i++){ 
        tempElements = document.all(i);
        if(tempElements.type=="radio"&&tempElements.value=="1"){
          tempElements.checked=true;
        }
      }   
    }  
  //�ӵ��ռ���־  
  }else{
    //�κ�һ���ӵ��ռ���־Ϊ����ȫ���������ռ���־Ϊ����ȫ
    if(field.value==0){
      fm.collectFlag[0].checked=true;      
    }      
  }  
  return true;   	
}   


/**
 *@description ����ǲ��ǿ��԰��ύ��ť
 *@return      ͨ������true,���򷵻�false
 */
 function checkSubmitButton()
 {
    var msg = fm.prpLcertifyCollectNoSubmitMsg.value;
    if (msg=="") {
      return true;
    }
    alert(msg);
    return false;
}


/**
 *@description ���������嵥��������
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function directCodeChange(field)
{
  var fieldname=field.name; 
  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour; 
  var Quantity; 
  
  var fieldCount = getElementCount(field.name);
  if(fieldCount==1){     
    //�����������ֵ 
    if(field.checked==true){
      fm.all("prpLcertifyDirectCode").value = fm.all("code").value;
    } else {    
      fm.all("prpLcertifyDirectCode").value = "0"; 
    }     
  } else {   
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
      fm.all("prpLcertifyDirectCode")[findex].value = fm.all("code")[findex].value;
    } else {    
      fm.all("prpLcertifyDirectCode")[findex].value = "0"; 
    }     
  } 
  //alert(fm.all(fieldname+"Txt")[findex].value);  
  return true;   
} 
  

/**
 *@description ���������嵥����
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */
function saveCertifyDirect(field,saveType)
{    
  fm.submit();    
  fm.target="_self";
  alert("�����嵥����ɹ�!");
  window.close();
  opener.location.reload();
  return true;   	
}
     
/**
*@description �������������嵥 
*@param       businessNo  
*/
function doCertifyDirect(businessNo,nodeType){      
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   
 
     
/**
*@description ��ӡ���������嵥 
*@param       businessNo   
*/
function certifyDirectPrint(businessNo,nodeType){
        
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirectPrint&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   


//add by zhaolu 20060807 start
//reason:��ӡ������֪�嵥
function certifyDirectList(businessNo,nodeType){    

  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirectPrint&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   
/**
*@description ��ӡ������֪�嵥 
*@param       businessNo   
*/
function certifyDirectAdd(registNo,nodeType,count){    
  alert(registNo);  
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+registNo+"&editType=CertifyDirectPrintAdd&index="+count+"&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
} 
//add by zhaolu 20060807 end