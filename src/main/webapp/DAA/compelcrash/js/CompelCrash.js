/*****************************************************************************
 * DESC       ：车车互碰js
 * AUTHOR     :lishengjun
 * CREATEDATE ： 20070125
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

 function importAccidentInfo() {
     //fm.action="/claim/DAA/compelcrash/DAAClaimInfoRegist.jsp";
     fm.nodeType.value="add";
     fm.submit();
    // fm.action="/claim/compelCrashImportInfo.do";
    }
    
 function  saveAccidentInfo(field,str){
 	fm.editType.value=str;

  for(var i=0;i<fm.elements.length;i++)
  {
   if(isEmpty(fm.elements[i]))
  {
   if(fm.elements[i].name!="faultAction"){
    errorMessage(fm.elements[i].description+"不能为空!");
    return false;
  }
  }
  }
 			fm.submit();
 	}
 	function checkTime(field)
 	{
 		if(field.value.length!=12)
 		{
 			alert("请输入正确的日期格式YYYYMMDDHHMM");
      return false;
   	}
   	dateTime=field.value.substr(1,4)+"-"+field.value.substr(4,2)+"-"+field.value.substr(6,2)
   	+" "+field.value.substr(8,2)+":"+field.value.substr(10,2)+":00";
   	field.value=dateTime;
 	 return true;
 	}
 
 	function submitValidate(){
   	var myRegistNoValue=fm.ownRegistNo.value;
  	var otherRegistNoValue=fm.otherRegistNo.value;
   if(myRegistNoValue.length<1&&otherRegistNoValue.length<1){
    	alert("双方报案号不能同时为空");
    	return false;	
   }
 	}

 function isEmpty(field)
{
  if(field.value==null || trim(field.value)=="")
  {
    return true;
  }

  return false;
}