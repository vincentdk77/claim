/*****************************************************************************
 * DESC       ：调度登记的脚本函数页面
 * AUTHOR     ：lixiang	 
 * CREATEDATE ： 2004-07-26
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


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
  
  fm.buttonSaveFinish.disabled = true;
  fm.buttonSaveFinishSubmit.disabled = true;
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


/**
 *@description 设值页面的一些初始化信息
 *@param       无
 *@return      通过返回true,否则返回false
 */
function initSet() 
{ 
	//initRegistText();
  return true;
}

/**
 *@description 根据按钮状态保存调度数据
 *@param       this
 *@param       保存状态
 *@return      通过返回true,否则返回false
 */
function saveForm(field)
{
  
  //copy the selectSend标志
  
  if(!validateForm(fm))
  {
  	return false;
  }
  
  //联系人手机号码判断
  /*
  if((fm.prpLregistLossName.value).length>0&&(fm.prpLregistLossName.value).length!=11)
  {
  	alert("请输入正确的手机号码");
  	fm.prpLregistLossName.focus();
    fm.prpLregistLossName.select();
  	return false;
  }   
  */
  
  //调用特殊检查
  if (fm.saveType.value=="GETBACKEDIT"){
  	if (!CheckGetBackSchedule()) return false;
  	
  }else{
  
     if (!checkscheduleForm(fm))
     {
  	    return false;
     }
   }
  //add by liyanjie 2005-12-12 start 双代案件,调度必须全部处理才能提交
  if(fm.prpLscheduleMainWFDtoCommiFlag.value== "1")
  {
  	if(!allDeal(fm))
    {
  	  alert("此案件为双代案件,请全部处理所有项目再提交!");
  	  return false;
    }
  }
  //add by liyanjie 2005-12-12 end
  
 // window.location.href =fm.nowURL.value;
  //modify by weishixin add end 20040616
  
  //reason:当按下某一按钮时请将这个按钮变灰，否则用户可能多按引发错误
  field.disabled = true;
  fm.submit();
  
  return true;   	
}
/**
 *@description 检查调度数据
 *@param       this
 *@param       检查状态
 *@return      通过返回true,否则返回false
 */
function checkscheduleForm(field)
{
//1.检查是否选择了一个checkBox

//2.检查选择了checkbox的查勘信息和出险地址都需要填内容。	
 	
   var i           = 0;
   var j           = 0;
   var selectCount = 0; //选择的行数
  
   var maxRow = fm.maxrow.value ;  //定损标的的数目
   var saveType=fm.saveType.value; //是取回还是直接调度
   var scheduleObjectID="";
  // alert(maxRow);
  //1。首先检查的是定损调度是不是有选择的内容
  //只有一行，判断是不是选择了查勘调度
  
  //没有查勘，只需要判断定损就可以了
  
  if (fm.nocheck.value=="1"){
  	
  	fm.scheduleType.value="schel"; //只有定损
  	if ((maxRow==1)||!(fm.checkYesNo.length>0))
    {
  	   //判断是否被选中，若没有选中，那么就可以直接进行下一条记录的判断。
  	   if (fm.checkYesNo.checked==false)
  	   {
         	errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
   	      return false;
       }
  	    return  CheckOnlySchel();
     }
     
     //多条的定损调度的判断
     return CheckMulitSchel();
  
  }
  //以下都是有查勘参与的页面
   if (fm.checkScheduleCheckYesNo.checked==true)
   {
   	  //表示被选中，需要进行查勘调度
  	  fm.checkSelectSend.value="1";  
      
      if (((fm.prpLscheduleMainWFScheduleObjectID.value).toString().length)<1)
       {
         errorMessage("查勘处理单位编码不能为空!");
         fm.prpLscheduleMainWFScheduleObjectID.focus();
         return false;
       }
       
       if (((fm.prpLscheduleMainWFScheduleObjectName.value).toString().length)<1)
       {
       	
         errorMessage("查勘处理单位名称不能为空!");
         fm.prpLscheduleMainWFScheduleObjectName.focus();
         return false;
       }
       
       if ((fm.checkYesNo.checked==false) &&(fm.checkScheduleCheckYesNo.checked==true))
  	   {
        	errorMessage("农险需要同时选择查勘调度和定损调度！")
   	      return false;
       }
        //判断如果选择的是保险公司，必须选择人员
        /*
        if (fm.prpLscheduleMainWFScheduleObjectID.value== fm.comcode.value){
        	
        	if (((fm.nextHandlerCode1.value).toString().length)<1) {
        	  	 errorMessage("请选择查勘处理人员!");
               fm.nextHandlerCode1.focus();
               return false;
        	  }
        }	    
       */
  
   }
 
  if ((maxRow==1)||!(fm.checkYesNo.length>0))
  {
  	//判断是否被选中，若没有选中，那么就可以直接进行下一条记录的判断。
  	if ((fm.checkYesNo.checked==false) &&(fm.checkScheduleCheckYesNo.checked==false))
  	{
     	errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
   	  return false;
    }
    //只选择了定损调度，判断，请先进行查勘调度！
    
    if ((fm.checkYesNo.checked==true) &&(fm.checkScheduleCheckYesNo.checked==false))
  	{
     	errorMessage("农险需要同时选择查勘调度和定损调度！")
   	  return false;
    }
      if (fm.checkYesNo.checked==true){
       //单条定损调度的判断
       return  CheckOnlySchel();
       
      }
      
      return true;
     }
     
     //多条的定损调度的判断
     return CheckMulitSchel();
 
}


//将变化了的现场类型保存到响应字段中
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
*检查单条的定损调度的内容是不是可以输入的内容为空
*
*/
function CheckOnlySchel()
{
 //设置selectSend的内容
  	    fm.prpLscheduleItemSelectSend.value="1";
  	    //默认设置节点类型为定损
  	    fm.nextNodeNo.value="certa";
  	   //判断调度对象和调度名称的
  	     if (((fm.prpLscheduleItemScheduleObjectID.value).toString().length)<1)
        {
          errorMessage("定损处理单位编码不能为空!");
          fm.prpLscheduleItemScheduleObjectID.focus();
          return false;
        }
        
        if (((fm.prpLscheduleItemScheduleObjectName.value).toString().length)<1)
        {
        	errorMessage("定损处理单位名称不能为空!");
          fm.prpLscheduleItemScheduleObjectName.focus();
          return false;
        }
        
        //判断定损地址
        if (((fm.prpLscheduleItemCheckSite.value).toString().length)<1)
        {
          errorMessage("定损地址不能为空!");
          fm.prpLscheduleItemCheckSite.focus();
          return false;
        }
        if(fm.checkYesNo.checked==true && fm.checkYesNo.disabled==true){
        	errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
   	 		return false;
        } 	    
         	    
        //判断如果选择的是保险公司，必须选择人员
        /*
        if (fm.prpLscheduleItemScheduleObjectID.value== fm.comcode.value){
        	
        	if (((fm.nextHandlerCode.value).toString().length)<1) {
        	  	 errorMessage("请选择定损处理人员!");
               fm.nextHandlerCode.focus();
               return false;
        	  }
        }	  */  
   	    return  true;
}

//选中复选框后，设置prpLCheckSelectSend值为1
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
*多条定损是否选择正确的判断
*/
function CheckMulitSchel()
{
	 var i           = 0;
   var j           = 0;
   var selectCount = 0; //选择的行数
  
   var maxRow = fm.maxrow.value ;  //定损标的的数目
   var saveType=fm.saveType.value; //是取回还是直接调度
   var scheduleObjectID="";
//多条的定损调度的判断
     
     for(i=0;i<maxRow;i++)
     {
        	//判断是否被选中，若没有选中，那么就可以直接进行下一条记录的判断。只要有没选中，就认为是没调度完的
  	
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
      	 //一定要写清楚呀。。。。
  	     if (fm.checkYesNo[i].disabled==true) continue; //说明已经调度过了
  	
  	     selectCount++;
  	
  	     //设置selectSend的内容
  	     fm.prpLscheduleItemSelectSend[i].value="1";
  	     //alert(fm.prpLscheduleItemItemNo[i].value);
  
  	     if (fm.prpLscheduleItemItemNo[i].value=="0"){
  	         fm.nextNodeNo[i].value="wound"; //人伤	
  	     }else if(fm.prpLscheduleItemItemNo[i].value=="-1")
  	     {
  		       fm.nextNodeNo[i].value="propc"; //财产损失
  	      }else{
  	     fm.nextNodeNo[i].value="certa"; //定损
       }
  		
  		if (fm.prpLscheduleItemItemNo[i].value=="1"&&fm.nocheck.value=="0")
  		 {
  		 	//如果选则了主车，判断是不是选择查看了。。
  		 	
  		    if (fm.checkScheduleCheckYesNo.checked==false)
  	        {
     	        errorMessage("选择定损调度时，需要选择查勘调度！")
   	          return false;
             }
  		}
  		
  		
  	   if (((fm.prpLscheduleItemScheduleObjectID[i].value).toString().length)<1)
       {
    	
          errorMessage("定损处理单位编码不能为空!");
          fm.prpLscheduleItemScheduleObjectID[i].focus();
           return false;
        }
    
        if (((fm.prpLscheduleItemScheduleObjectName[i].value).toString().length)<1)
        {
    	    
           errorMessage("定损处理单位名称不能为空!");
           
           fm.prpLscheduleItemScheduleObjectName[i].focus();
           return false;
         }
  	
  	
        //判断查勘地址
        if (((fm.prpLscheduleItemCheckSite[i].value).toString().length)<1)
        {
    	        if (fm.prpLscheduleItemItemNo[i].value=="0"){
    	     	errorMessage("第"+(i+1)+"条,就医医院不能为空!");
    	         }else{
    	    errorMessage("第"+(i+1)+"条,定损地址不能为空!");
    	  }
             
             fm.prpLscheduleItemCheckSite[i].focus();
             return false;
        }
        
         //判断如果选择的是保险公司，必须选择人员
         /*
        if (fm.prpLscheduleItemScheduleObjectID[i].value== fm.comcode.value){
        	
        	if (((fm.nextHandlerCode[i].value).toString().length)<1) {
        	  	 errorMessage("请选择定损处理人员!");
               fm.nextHandlerCode[i].focus();
               return false;
        	  }
        }	  */  
        
 	  
   }
   
   //判断是不是没有选择一个checkbox
   var finishSchedule=fm.prpLscheduleItemFinishSchedule.value;
   
    if (fm.nocheck.value=="1"){
       if (selectCount < 1 &&finishSchedule==""&&(saveType==""))
       {
         	errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
        	return false;
       }
    }else{
    
       //查勘没有调度的情况，进行判断
       if ((selectCount< 1)&&(finishSchedule=="")&&(fm.checkScheduleCheckYesNo.checked==false)&&(saveType==""))
       {
         	errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
        	return false;
       } 
       //查勘调度完毕的情况,没有选择定损调度
       if ((selectCount< 1)&&(finishSchedule=="")&&(fm.checkScheduleCheckYesNo.disabled==true)&&(saveType==""))
       {
         	errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
        	return false;
       }
       if(selectCount< 1 && fm.checkScheduleCheckYesNo.disabled==true){
       		errorMessage("必须选中一条调度的标的信息，才可以保存调度信息！")
        	return false;
       } 
    }

  
   return true;
}

/**
*检查调度改派
*/
function CheckGetBackSchedule()
{
   if (fm.getbackNodeType.value=="check"){
   	 if (((fm.prpLscheduleMainWFScheduleObjectID.value).toString().length)<1)
       {
       	
         errorMessage("查勘处理单位编码不能为空!");
         fm.prpLscheduleMainWFScheduleObjectID.focus();
         return false;
       }
       
       if (((fm.prpLscheduleMainWFScheduleObjectName.value).toString().length)<1)
       {
       	
         errorMessage("查勘处理单位名称不能为空!");
         fm.prpLscheduleMainWFScheduleObjectName.focus();
         return false;
       }
       
       return true;
  }else{
   return  CheckOnlySchel();
  }
}


    //用来改派调度用的
    function setNewHandlerCode(fieldObject){
       
            fm.newHandlerCode.value=fieldObject.value
          
    }
    
     //用来筛选调度的经办人用的
    function setNewComCode(fieldObject){
            fm.selectcomcode.value=fieldObject.value
            //fm.newcomcode.value=fieldObject.value
            //判断是选择了查勘的处理单位，还是定损调度的处理单位
            	var  intIndex = parseInt(fieldObject.num);
            //选择查勘处理单位
            if (intIndex<0){
            	fm.nextHandlerCode1.value="";
            	fm.nextHandlerName1.value="";
            	
            	return
           }
           
           var maxRow = fm.maxrow.value
           //选择定损处理单位，并且定损调度只一条记录
           if (maxRow=='1'){
           		fm.nextHandlerCode.value="";
            	fm.nextHandlerName.value="";
            return
           }
           
           
           fm.nextHandlerCode[intIndex].value="";
           fm.nextHandlerName[intIndex].value="";
          
    }
   
    //用来筛选调度的经办人用的
    function setNewHandlerComCode(fieldObject){
            
            //fm.newcomcode.value=fieldObject.value
            //判断是选择了查勘的处理单位，还是定损调度的处理单位
            	var  intIndex = parseInt(fieldObject.num);
            	
            	//alert (intIndex)
            //选择查勘处理单位
            if (intIndex<0){
            	fm.selectcomcode.value = fm.prpLscheduleMainWFScheduleObjectID.value;
             	return
           }
           
           var maxRow = fm.maxrow.value
           //选择定损处理单位，并且定损调度只一条记录
           if (maxRow=='1'){
           		fm.selectcomcode.value =fm.prpLscheduleItemScheduleObjectID.value;
            return
           }
           
           
           fm.selectcomcode.value = fm.prpLscheduleItemScheduleObjectID[intIndex].value;
           
          
    }
   
   /**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */

/**
 *@description 弹出报案的画面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function relateRegist(){	
		var registNo = fm.prpLscheduleMainWFRegistNo.value;
	  var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="
	                  +registNo+"&editType=SHOW&riskCode="+fm.prpLscheduleMainWFRiskCode.value;	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 

/**
 *@description 申请双代  add by liyanjie 2005-12-06
 *@param       无
 *@return      通过返回true,否则返回false
 */

function applyCommi(field)
{
	
	if(!confirm("您确认要将案件提交双代人员处理吗?Y/N 提交后,将清空您做的查勘定损调度的内容."))
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
	//将双代标识置为已选择,将查勘定损的调度清空
	field.disabled = true;

	fm.action="/claim/processCommiCase.do?actionType=apply";
  fm.submit(); 
}   


  //add by liyanjie start 2005-12-12
  //判断是否所有项目都做了调度,对于双代的案件,必须全部处理才能提交
function allDeal(fm)
{
  var allDealFlag = true;
  var maxRow = fm.maxrow.value ;  //定损标的的数目

  //没有查勘，只需要判断定损就可以了
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