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
 			return;
 			fm.submit();
 			
 	}
 	function checkTime(field)
 	{
 		if(field.value.length!=10)
 		{
 			alert("请输入正确的日期格式YYYYMMDDHHSS");
 	       return false;
   	}
   	dateTime=field.value.substr(0,4)+"-"+field.value.substr(2,2)+"-"+field.value.substr(4,2)
   	+" "+field.value.substr(6,2)+":"+field.value.substr(8,2)+":00";
   	field.value=dateTime;
 	 return true;
 	}
 
 	function submitValidate(){
 	var myRegistNoValue=fm.jiaReportCode.value;
 	var myPolicyNo=fm.jiaInsureCode.value;
 	var otherRegistNo=fm.yiReportCode.value;
 	var otherPolicyNO=fm.yiInsureCode.value;
 	var str="";
 	if(myPolicyNo==null || myPolicyNo.length < 1){
 			str="甲方报案号不允许为空;\n";
 		}
 		if(myPolicyNo==null || myPolicyNo.length < 1){
 			str=str+"甲方保单号不允许为空;\n";
 			}
 			if(otherRegistNo==null || otherRegistNo.length < 1){
 			str=str+"乙方报案号不允许为空;\n";
 			}
 			if(otherPolicyNO==null || otherPolicyNO.length < 1){
 			str=str+"乙方保单号不允许为空;\n";
 			}
 		if(str.length > 1){
 		 alert(str);
 		 return false;
 		}
 	}
 
 
 	
  