/*****************************************************************************
 * DESC       ：单证登记的脚本函数页面
 * AUTHOR     ：liubvo
 * CREATEDATE ： 2004-07-05
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 检查单证登记
 *@param       无
 *@return      通过返回true,否则返回false
 */
function checkForm()
{   
    return true;
}


/**
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
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
 *@description 重置
 *@param       无
 *@return      通过返回true,否则返回false
 */
function resetForm()
{
  if(window.confirm("确定要重置吗？"))
  {
    location.href = location.href;
    return true;
  }
  else
  {
    return false;
  }
}

//reason:保存留言，和打开留言


//Modify By wangli remark begin 20050328
//reason: 统一使用ClaimPub.js 里的方法，便于维护

/**
 *@description 弹出查看留言页面
 *@param       无
 *@return      通过返回true,否则返回false
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
 *@description 弹出留言保存页面
 *@param       无
 *@return      通过返回true,否则返回false
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
  *@description 查看制定的文件(下载功能)
  *@param       fileName，businessNo，uploadFileName
  */
  function viewFile(fileName,businessNo){
    //document.fm.action="/claim/DAA/certify/download.jsp?fileName="+fileName+"&businessNo="+businessNo+"&uploadFileName="+uploadFileName;
    //document.fm.submit();
    window.open("/claim/DAA/certify/CertifyViewFile.jsp?fileName="+fileName+"&businessNo="+businessNo,businessNo,"resizable=0,scrollbars=1,width=800,height=600");
  } 
      
  /**
  *@description 查看全部文件 
  *@param       businessNo
  */
  function viewFileAll(businessNo){
    //document.fm.action="/claim/DAA/certify/viewFile.jsp?businessNo="+businessNo;   
    //document.fm.submit();
    window.open( "/claim/DAA/certify/DAACertifyViewFile.jsp?businessNo="+businessNo,"winName","resizable=0,scrollbars=1,width=800,height=600");
    //window.showModalDialog( "/claim/DAA/certify/viewFile.jsp?businessNo="+businessNo,window,'status:no;resizable:yes');
  }
      
  /**
  *@description 查看全部文件 
  *@param       businessNo
  */
  function doViewFile(editType, directType,k){
    //document.fm.action="/claim/DAA/certify/viewFile.jsp?businessNo="+businessNo;   
    //document.fm.submit(); 
    var businessNo=fm.prpLcertifyCollectBusinessNo.value;
    var itemcode=fm.prpLcertifyCollectLossItemCode.value;	
    var viewFile = "NoDeleteFile";
    window.open( "/claim/DAA/certify/DAACertifyViewFile.jsp?editType="+editType + "&directType="+directType+ "&itemcode="+k+"&businessNo="+businessNo+"&viewFile="+viewFile,"winName","scrollbars=1,resizable=yes");
    //window.showModalDialog( "/claim/DAA/certify/viewFile.jsp?businessNo="+businessNo,window,'status:no;resizable:yes');
  } 
  
  /**
  *@description 查看删除图片
  *param        businessNo
  */
  function doDeleteViewFile(editType, directType,k){
  	var businessNo=fm.prpLcertifyCollectBusinessNo.value;
    var itemcode=fm.prpLcertifyCollectLossItemCode.value;	
    var viewFile = "deleteFile";
    window.open( "/claim/DAA/certify/DAACertifyViewFile.jsp?editType="+editType + "&directType="+directType+ "&itemcode="+k+"&businessNo="+businessNo+"&viewFile="+viewFile,"winName","scrollbars=1,resizable=yes");
  }  
  /**
  *@description 上传文件 
  *@param       businessNo 
  */
  function doUploadFile(directType,lossItemCode,lossItemName,titleName,imageTypeList){ 
    //document.fm.action="/claim/DAA/certify/viewFile.jsp?businessNo="+businessNo;   
    //document.fm.submit();  
    if (imageTypeList == "") {
        alert("请先选择您要上传的资料.");
        return false;
    } 
   
    var businessNo=fm.prpLcertifyCollectBusinessNo.value;
    var uploadYear=fm.prpLcertifyCollectUploadYear.value;
    var riskCode=fm.prpLcertifyCollectRiskCode.value; 
    var nodeType= fm.nodeTypeUpload.value;
    var policyNo = fm.prpLcertifyCollectPolicyNo.value;
    //window.open( "/claim/DAA/certify/DAACertifyUploadMultiEdit.jsp?directType="+directType+"&businessNo="+businessNo+"&lossItemCode="+lossItemCode,"winName","resizable=0,scrollbars=1,width=800,height=600");
 
  var oldAction = fm.action;  
  var oldTarget = fm.target;  
  
  var operatorCode =fm.prpLcertifyCollectOperatorCode.value;
  
  fm.action="/claim/applet/ViewApplet.jsp?directType="+directType+"&businessNo="+businessNo+"&lossItemCode="+lossItemCode+"&nodeType="+nodeType+"&lossItemName="+lossItemName+"&uploadYear="+uploadYear+"&riskCode="+riskCode+"&titleName="+titleName+"&imageTypeList="+imageTypeList+"&operatorCode="+operatorCode;
  fm.target="fraSubmit";   
  //fm.target="_blank";     
  //fm.submit();
  var url = "/claim/DAA/certify/DAACertifyUpload.jsp?directType="+directType+"&businessNo="+businessNo+"&lossItemCode="+lossItemCode+
  			"&nodeType="+nodeType+"&lossItemName="+lossItemName+"&uploadYear="+uploadYear+"&riskCode="+riskCode+"&titleName="+titleName+
  			"&imageTypeList="+imageTypeList+"&operatorCode="+operatorCode+"&policyNo="+policyNo;
  window.open(url,"winUpload","width=600,height=400,status=yes,menubar=no,location=no,resizable=yes,scrollbars=yes");
  fm.action=oldAction;
  fm.target=oldTarget;   

  }   
  
      
/**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relatePolicy(policyNo){	 
    var riskCode = fm.prpLcertifyCollectRiskCode.value;
    var CoreWebUrl=fm.txtCoreWebUrl.value;
    var vURL = CoreWebUrl +'/' + riskCode + '/tbcbpg/UIPrPoEn' + riskCode + 'Show.jsp?BIZTYPE=POLICY&SHOWTYPE=SHOW&BizNo='+ policyNo+'&RiskCode='+ riskCode;
   
    window.open(vURL,'详细信息','width=750,height=500,top=15,left=10,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
} 

/**
 *@description 弹出报案的画面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relateRegist(){	
		var registNo = fm.RegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.riskCode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 
/**
 *@description 根据按钮状态保存单证数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveForm(field,saveType)
{   

  fm.buttonSaveType.value = saveType; 
   
  //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  /*
   if(!validateForm(fm,'Certify_Data'))
    {
      return false;
    }
    */
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  //field.disabled = true;
  var checkReturn = true;
  if (saveType=="4")
  {
    checkReturn = checkSubmitButton(); 
    if(checkReturn==false){
       return false;  
      }  	
    if(fm.collectFlag[1].checked==true){ 
    } else {

			  if(window.confirm("单证尚未收集齐全是否需要提交"))
			  {
			    fm.submit();
			    return true;
			  }
			  else
			  {
			    return false;
			  }	
    }          
  }
  if(checkReturn==false){
    return false;  
  }    
  fm.submit();
  return true;   	
} 

/**
 *@description 设置收集齐全的标志
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function setCollectFlag(field)
{
  var fieldName = field.name;
  var tempElements = null;
  var allcollect=1;
  //案件的收集标志
  if(fieldName=="collectFlag"){
    //当案件的收集标志为齐全的时候，所有的子收集标志自动齐全    
    if(field.value==1){
      for(i=0; i<document.all.length; i++){ 
        tempElements = document.all(i);
        if(tempElements.type=="radio"&&tempElements.value=="1"){
          tempElements.checked=true;
        }
      }
    }
    //当所有的都为收集齐全的时候，显示就只能是收集齐全。
     if(field.value==0){
      for(i=0; i<document.all.length; i++){ 
        tempElements = document.all(i);
        if(tempElements.type=="radio"&&field.name!="collectFlag"&&tempElements.value=="0"){
          allcollect="0";
          break;
        }
      }  
      //如果所有的都收集全了。。则不能选择不齐全   
      //alert(allcollect);
      if (allcollect=="1"){
      	//field.checked=false;
      	alert("每项收集标志都已经齐全，请确认是否是收集不齐全！");
      }    
    }  
  //子的收集标志  
  }else{
    //任何一个子的收集标志为不齐全，案件的收集标志为不齐全
    if(field.value==0){
      fm.collectFlag[0].checked=true;      
    }      
  }  
  return true;   	
}   


/**
 *@description 检查是不是可以按提交按钮
 *@return      通过返回true,否则返回false
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
 *@description 设置索赔清单的隐含域
 *@param       无
 *@return      通过返回true,否则返回false
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
    //更改隐含项的值 
    if(field.checked==true){
      fm.all("prpLcertifyDirectCode").value = fm.all("code").value;
      fm.all("certifyDirectFlag").value = "1";
    } else {    
      fm.all("prpLcertifyDirectCode").value = "0"; 
      fm.all("certifyDirectFlag").value = "0";
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
    //更改隐含项的值 
    if(field.checked==true){
      fm.all("prpLcertifyDirectCode")[findex].value = fm.all("code")[findex].value;
      fm.all("certifyDirectFlag")[findex].value = "1";
    } else {    
      fm.all("prpLcertifyDirectCode")[findex].value = "0"; 
      fm.all("certifyDirectFlag")[findex].value = "0";
    }     
  } 
  //alert(fm.all(fieldname+"Txt")[findex].value);  
  return true;   
} 

/**非车*/
function fcDirectCodeChange(field)
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
    //更改隐含项的值 
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
    //更改隐含项的值 
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
 *@description 设置索赔清单强三的隐含域
 *@param       无
 *@return      通过返回true,否则返回false
 */
function compelDirectFlag(field){
  var i = 0;
  var findex = 0;  
  var fieldname=field.name; 
  var fieldCount = getElementCount(field.name);
  if(fieldCount==1){     
    //更改隐含项的值 
    if(field.checked==true){
      fm.all("prpLcertifyDirectCode").value = fm.all("code").value;
      fm.all("compleChoiceFlag").value = "1";
    } else {    
      fm.all("prpLcertifyDirectCode").value = "0"; 
      fm.all("compleChoiceFlag").value = "0";
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
     if(field.checked==true){
        fm.all("compleChoiceFlag")[findex].value = "1";
        fm.all("prpLcertifyDirectCode")[findex].value = fm.all("code")[findex].value;
      }else{
        fm.all("compleChoiceFlag")[findex].value = "0";
        fm.all("prpLcertifyDirectCode")[findex].value = "0";
      }
   }
   return true;
}
  

/**
 *@description 索赔资料清单保存
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveCertifyDirect(field,saveType)
{    
  fm.submit();    
  fm.target="_self";
  alert("索赔清单保存成功!");
  window.close();
  opener.location.reload();
  return true;   	
}
     
/**
*@description 处理索赔资料清单 
*@param       businessNo  
*/
function doCertifyDirect(businessNo,nodeType,riskCode){ 
	
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirect&nodeType="+nodeType+"&riskCode=" + riskCode,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   
  
     
/**
*@description 打印索赔须知清单 
*@param       businessNo   
*/
function certifyDirectList(businessNo,nodeType){    

  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+businessNo+"&editType=CertifyDirectPrint&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
}   
/**
*@description 打印索赔须知清单 
*@param       businessNo   
*/
function certifyDirectAdd(registNo,nodeType,count){    
  alert(registNo);  
  window.open( "/claim/certifyBeforeEdit.do?RegistNo="+registNo+"&editType=CertifyDirectPrintAdd&index="+count+"&nodeType="+nodeType,"Print","resizable=0,scrollbars=1,width=800,height=600");
} 