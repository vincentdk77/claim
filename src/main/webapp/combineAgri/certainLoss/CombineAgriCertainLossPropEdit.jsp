<%--
****************************************************************************
* DESC       ：财产损失清单页面
* AUTHOR     ： 张菊卿 信息技术部
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 
<!--建立显示的录入条，可以收缩显示的-->   
<script language='javascript'>  
//校验耳标清单金额数据格式
function formateEarEstimateLoss(field)
 {  
  var fieldname = field.name; 
  var i = 0;
  var findex=0;       
  var prplCompensateEarEstimateLoss;
  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  } 
    prplCompensateEarEstimateLoss= parseFloat(fm.all("prplCompensateEarEstimateLoss_"+combineIndex)[findex].value);

    if(isNaN(prplCompensateEarEstimateLoss)||prplCompensateEarEstimateLoss.length<1){
      prplCompensateEarEstimateLoss = 0;
    }
    fm.all("prplCompensateEarEstimateLoss_"+combineIndex)[findex].value = point(round(prplCompensateEarEstimateLoss ,2),2);
    return true;  
}
     /*start判断耳标号 addby 张菊卿*/
     function earnoCheck(combineIndex)
     {
   	  var policyno = fm.policyno.value; 
   	  var nodeType = fm.nodeType.value;
   	  if(policyno!=null&&policyno == "")
         {
             alert("无保单号");
             return false;
         }

         var DamageStartDate = "";
         var DamageStartHour = "";
         var riskcode = "";
         if(nodeType == "regis"){
          DamageStartDate = fm.all("prpLregistDamageStartDate_"+combineIndex).value;
          DamageStartHour = fm.all("prpLregistDamageStartHour_"+combineIndex).value;
          riskcode = fm.riskCode.value;}
         else if (nodeType == "check"){
          DamageStartDate = fm.all("damageStartDate_"+combineIndex).value;
          DamageStartHour = fm.all("damageStartHour_"+combineIndex).value;
          riskcode = fm.riskCode.value;}
         else if (nodeType == "certa"){
          DamageStartDate = fm.all("prpLregistDamageStartDate1_"+combineIndex).value;
          DamageStartHour = fm.all("prpLregistDamageStartHour1_"+combineIndex).value;
          riskcode = fm.all("prpLclaimRiskCode_"+combineIndex).value;}
         else{
		  alert("错误的节点类型："+nodeType);
             return false;}
          var kindcode="";
         if(riskcode =="3220") kindcode ="3220001";
         else if(riskcode =="3202") kindcode ="001";
         else if(riskcode =="3223") kindcode ="3223001";
         else if(riskcode =="3225") kindcode ="3225001";
         else if(riskcode =="3236") kindcode ="001";
         else if(riskcode =="3227") kindcode ="3227001";
         else if(riskcode =="3223") kindcode ="3223001";
         else if(riskcode =="3233") kindcode ="001";
         else if(riskcode =="3234") kindcode ="001";
         else if(riskcode =="3239") kindcode ="001";
         else if(riskcode =="3240") kindcode ="001";
         else
         {
             alert("险种错误");
             return false;
         }
         if(DamageStartDate == null || trim(DamageStartDate).length != 10)
         {
             alert("请录入出险时间");
             return false;
         }
         
         if(DamageStartHour == null || trim(DamageStartHour).length == 0)
         {
             DamageStartHour = "00";
         }
	  var count = getElementCount("prplCompensateEarEarNo_"+combineIndex);
	  if (count == 1)
	  {
		  alert("报案号："+fm.all("combineRegistNo")[combineIndex]+"无耳标号输入");
		  return false;
	  }
      var earnos = document.getElementsByName("prplCompensateEarEarNo_"+combineIndex);
      for(var index =0 ;index < count ; index++)
      {
	      if (index ==0) continue;
	      if(trim(earnos[index].value).length == 0)
	      {
	      	alert("耳标号不可为空");
	      	return false;
	      }
	      var i =index;
	      i++;
	      while(i < count)
	      {
		      if(earnos[index].value == earnos[i].value)
		      {
		      alert("耳标号不可重复");
		      	return false;
	      	}
	      	 i++;
	      }
	      if(earnos[index].readOnly == false)
	      {      
	     	var bool = getEarResult(policyno,earnos[index].value,kindcode,DamageStartDate,DamageStartHour,index,combineIndex);  
	     	if(bool == false) 	return false;
	      } 
      }
	 var illegalFlag = document.getElementsByName("illegalFlag_"+combineIndex);
	 for(var index =0 ;index < count ; index++)
      {//alert("index="+index+" "+earnos[index].value);
      	if (index ==0) continue;
      //alert (illegalFlag[index].value );
	    if(illegalFlag[index].value == "true")
	      {
	      		alert( "耳标号检查不通过");
	      		return false;
	      }
      }
    if(nodeType=="regis"){
      fm.all("prpLregistLossesNumber_"+combineIndex).value = count-1;
    }
    return true;
     }
     
    function getEarResult(policyno,earno,kindcode,DamageStartDate,DamageStartHour,index,combineIndex){
    var url =  "EarnoCheckServlet?policyno="+policyno+"&earno="+earno+
    "&kindCode="+kindcode+"&DamageStartDate="+DamageStartDate+"&DamageStartHour="+DamageStartHour;
    var req;
    var illegalFlag = false;
	 if(window.XMLHttpRequest){
		     req = new XMLHttpRequest();
	 }
	 else if (window.ActiveXObject){
	    try{
	    req = new ActiveXObject("Microsoft.XMLHTTP");
	    }catch(e){
	      try{
	    req = new ActiveXObject("Microsoft.XMLHTTP");
	    }catch(e){
	    	 alert("错误：浏览器不支持！");
			 return false;}
	    }
	 }
	 else
		{
			 alert("错误：浏览器不支持！");
			 return false;
		}
	 
	 if(req){
	     req.open("GET",url,false);
		 req.send(null); 
	    // req.onreadystatechange = function(){
		if (req.readyState == 4 && req.status == 200) {  
			var xmlDoc = req.responseXML;
			//start异常处理
			var userException = xmlDoc.getElementsByTagName("userException");  
			if(userException.length > 0){ 
				var userExceptionChildNodes = userException[0].childNodes; 
				alert( "userException:"+userExceptionChildNodes[3].text + ":请联系管理员");
				return false;
			}
			var exception = xmlDoc.getElementsByTagName("exception");  
			if(exception.length > 0){ 
				var exceptionChildNodes = exception[0].childNodes; 
				alert( "CLASSNAME："+exceptionChildNodes[0].text + ":请联系管理员");
				return false;
			}
			//end异常处理
			var insureMainList = xmlDoc.getElementsByTagName("insureMainList");  
			if(insureMainList.length == 0){ 
				fm.all("prplCompensateEarEarNo_"+combineIndex)[index].readOnly = "readonly";
			    fm.all("prplCompensateEarEarNo_"+combineIndex)[index].style.backgroundColor = "#CECECE";
				fm.all("illegalFlag_"+combineIndex)[index].value="false";
				//alert( "无投保清单，请谨慎录入");
				return true;
			}
			var herdPolicyList = xmlDoc.getElementsByTagName("herdPolicyList");
	   
			if(herdPolicyList.length > 0){ 
				var herdPolicy = herdPolicyList[0].childNodes; 
		
				fm.all("prplCompensateEarInusreListCode_"+combineIndex)[index].value = herdPolicy[31].text; 
				fm.all("prplCompensateEarId_Card_"+combineIndex)[index].value = herdPolicy[3].text; 
				fm.all("prplCompensateEarName_"+combineIndex)[index].value = herdPolicy[2].text;
				fm.all("prplCompensateEarBank_"+combineIndex)[index].value = herdPolicy[17].text; 
				fm.all("prplCompensateEarAccount_"+combineIndex)[index].value = herdPolicy[18].text;
				fm.all("prplCompensateEarEstimateLoss_"+combineIndex)[index].value = herdPolicy[26].text;
				fm.all("prplCompensateEarUnitAmount_"+combineIndex)[index].value = herdPolicy[22].text;
				fm.all("prplCompensateEarFCode_"+combineIndex)[index].value = herdPolicy[1].text;
				fm.all("prplCompensateEarKindCode_"+combineIndex)[index].value = herdPolicy[19].text;
				fm.all("prplCompensateEarBreedingAreaCode_"+combineIndex)[index].value = herdPolicy[5].text;
				fm.all("prplCompensateEarBreedingAreaName_"+combineIndex)[index].value = herdPolicy[6].text;
				fm.all("prplCompensateEarEarNo_"+combineIndex)[index].readOnly = "readonly";
		     	fm.all("prplCompensateEarEarNo_"+combineIndex)[index].style.backgroundColor = "#CECECE";
		     	fm.all("illegalFlag_"+combineIndex)[index].value="false";
			}
			else
			{ 
				 fm.all("illegalFlag_"+combineIndex)[index].value="true";
			}
		}else
		{
			 alert("错误：请求失败！");
			 return false;
		}
		//}
	}	
	return true;
}


//页面校验：提示用户
function checkEarNoAndPromote(combineIndex)
{
	var countEar = getElementCount("prplCompensateEarEarNo_"+combineIndex);
 	 var killQuantity = document.getElementsByName("prpLverifyLossKillQuantity_"+combineIndex)[0];
	 var deathQuantity = document.getElementsByName("prpLverifyLossDeathQuantity_"+combineIndex)[0];
     var lossNumber = document.getElementsByName("prpLverifyLossLossesNumber_"+combineIndex)[0];
     if(isNaN(lossNumber.value) ||isNaN(killQuantity.value) ||isNaN(deathQuantity.value))
	 {
		 lossNumber.value = countEar -1;
		 killQuantity.value = 0;
		 deathQuantity.value = lossNumber.value;				
	 }
	 else
	 {
		 if(Number(lossNumber.value) > Number(killQuantity.value) + Number(deathQuantity.value) || Number(lossNumber.value) != (countEar -1))
		 {	 
		 	lossNumber.value = countEar -1;
			 killQuantity.value = 0;
			 deathQuantity.value = lossNumber.value;
			 //alert( "赔付数量不等于耳标号清单数量");
			 //alert( "赔付数量不应大于扑杀数量和死亡数量之和");
		}
	 }

	//start计算出现户次
	var array1 = document.getElementsByName("prplCompensateEarId_Card_"+combineIndex);
	var s = new Array(); 
	for(var i=1;i<array1.length;i++){
	   s.push(trim(array1[i].value));
	}
	var newArray=new Array();  
	    var len=s.length;  
	    for (var i=0;i<len ;i++){  
	        for(var j=i+1;j<len;j++){  
	            if(s[i]== s[j]){  
	                j=++i;  
	            }  
	        }  
	        newArray.push(s[i]);  
	    } 
	 //end
	 var damageInsured = document.getElementsByName("prpLverifyLossDamageInsured_"+combineIndex)[0];
	 if(isNaN(damageInsured.value) || Number(damageInsured.value) != newArray.length)
	 {
	  		damageInsured.value = newArray.length ;//alert( "出险户次须为数字");
	 }
	 
	var countProp = getElementCount("prpLpropFamilyCode_"+combineIndex);
	if(countProp > 2){ 
		alert( "核定损清单不能有多条记录");
		return false;
	}
	if(countEar >1){
		//if(countProp < 2){ 
		//	combineInsertRow('Prop_'+combineIndex);
			//alert( "耳标号清单非空时核定损清单不能为空");//????????????????????????????????
			//return false;
		//	}
		//else
		//{
			if(countProp < 2){ 
				combineInsertRow('Prop_'+combineIndex);
				//alert( "耳标号清单非空时核定损清单不能为空");//????????????????????????????????
				//return false;
			}
			var sum = 0;
			for (var i = 1; i < countEar ;i++)
			{
				sum = sum + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss_"+combineIndex)[i].value);
			}
			var propSumLoss = document.getElementsByName("prpLpropSumLoss_"+combineIndex)[1];
			var propSumReject = document.getElementsByName("prpLpropSumReject_"+combineIndex)[1];
			var propSumDefLoss = document.getElementsByName("prpLpropSumDefLoss_"+combineIndex)[1];
			if(sum != parseFloat(propSumLoss.value)){
				propSumLoss.value = sum;
				if(isNaN(propSumReject.value)||propSumReject.value.length<1)
     				propSumReject.value = 0;
     			
			//alert( "核定损清单受损金额不等于耳标定损金额之和");
			//return false;
			}
			propSumDefLoss.value = propSumLoss.value - propSumReject.value;
     		propSumDefLoss.value = point(round(propSumDefLoss.value ,2),2);
		//}
	}
	return true;
}
function checkEarBeforeSave(){
	var countShow = getElementCount("registNoShow");
	for(var combineIndex = 0 ;combineIndex < countShow ; combineIndex++){
		var countEar = getElementCount("prplCompensateEarEarNo_"+combineIndex);
		var illegalFlag = document.getElementsByName("illegalFlag_"+combineIndex);
		for(var index = 1 ;index < countEar ; index++)
		{
		   if(illegalFlag[index].value == "true")
		    {
	    		var bool = earnoCheck(combineIndex);
	    		if ( bool != true)  	
				{
			   		alert( "耳标号校验失败！");
			   		return false;
			    }
				//else break;
		    }
		} 
		var bool = checkEarNoAndPromote(combineIndex);
		if ( bool != true)  
		{
	   		alert( "耳标号校验失败！");
	   		return false;
	    }
    }
	return true;
}
</script>
<%iterator = PrplcombineDtos.iterator();
while(iterator.hasNext()){iterator.next();
String prplCompensateEarDtoList = "";
prplCompensateEarDtoList = "prplCompensateEarDtoList_"+String.valueOf(idxEar);
%>
<span  id="spanEarEdit_<%=idxEar%>" style = "display:none" cellspacing="1" cellspacing="0"  width="100%">
   <!--建立显示的录入条，可以收缩显示的-->   
<%familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag_"+String.valueOf(idxEar)));%>
<%if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
<% String combineEarbackReadOnlyO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String combineEarbackDiasableO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String combineEarbackStyleO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String display = "display:display"; 
	if(null!=editType && ("SHOW".equalsIgnoreCase(editType)||"VIEW".equalsIgnoreCase(editType)))
		display = "display:none";

%>
<%      combineEarbackStyleO=";background:#CECECE";
 combineEarbackReadOnlyO="readOnly";
 combineEarbackDiasableO="disabled";
%>    
  <input type="hidden" name= "nodeType_<%=idxEar%>"  value="<%= request.getAttribute("nodeType_"+ idxEar )%>">
  <span  id="SpanEar_<%=idxEar%>" style="display:" cellspacing="1" cellpadding="0">
  <table class="common" cellpadding="8" cellspacing="1">

  </table> 
      <span style="display:none"> 
          <table class="common" style="display:none" id="Ear_<%=idxEar%>_Data" cellpadding="8" cellspacing="1">
            <tbody>
              <tr>
              <td class="input" style="width:17%">              
                  <input name="prplCompensateEarFCode_<%=idxEar%>" class=readonly readonly style='width:150px'  maxlength=170  >
                </td>      
                 <td class="input" style="width:18%">          
                  <input name="prplCompensateEarId_Card_<%=idxEar%>" class=readonly readonly style='width:150px'  maxlength=180 >
                </td>
                  <td class="input" style="width:8%">        
                  <input name="prplCompensateEarName_<%=idxEar%>" class=readonly readonly style='width:80px'  maxlength=100 >
                </td>
                  <td class="input" style="width:14%">
                  <input name="prplCompensateEarBank_<%=idxEar%>" class=readonly readonly style='width:140px'  maxlength=140 >
                </td>
                  <td class="input" style="width:18%">
                  <input name="prplCompensateEarAccount_<%=idxEar%>" class=readonly readonly style='width:180px'  maxlength=180 >
                </td>
                 <td class="input" style="width:12%">  
                  <input name="prplCompensateEarEarNo_<%=idxEar%>" class="common" style='width:120px'  maxlength=120 >
                </td>  
                  <td class="input" style="width:7%">         
                  <input name="prplCompensateEarEstimateLoss_<%=idxEar%>" value="0.0"  class="common" style='width:70px'  maxlength=15 onBlur="">
                </td>  
  
                <td class="input" style='width:4px'  align="center">
                <div>
                  <input type=button name="buttonEarDelete_<%=idxEar%>"  class="smallbutton" onclick="deleteRow(this,'Ear_<%=idxEar%>')" value="-" style="cursor: hand">
                </div>
					<input type="hidden" name="prplCompensateEarPolicyNo_<%=idxEar%>"  value="<%= request.getAttribute("policyNo_"+idxEar) %>">
					<input type="hidden" name="prplCompensateEarRegistNo_<%=idxEar%>"  value="<%= request.getAttribute("RegistNo_"+idxEar) %>">
					<input type="hidden" name="prplCompensateEarClaimNo_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarCompensateNo_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarCombineNo_<%=idxEar%>" >
					<input type="hidden" name="prplCompensateEarCaseNo_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDamageStartDate_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDamageStartHour_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDamageEndDate_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDamageCode_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDamageName_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarUnitAmount_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarSumRealpay_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarRestFee_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarClaimRate_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDeductibleRate_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarDeductible_<%=idxEar%>">
					<input type="hidden" name="prplCompensateEarNodeNo_<%=idxEar%>" >
                    <input type="hidden" name="prplCompensateEarNodeType_<%=idxEar%>" value="<%= request.getParameter("nodeType")%>">
                    <input type="hidden" name="prplCompensateEarReportTime_<%=idxEar%>">
                    <input type="hidden" name="prplCompensateEarBreedingAreaCode_<%=idxEar%>">
                  	<input type="hidden" name="prplCompensateEarBreedingAreaName_<%=idxEar%>">
                 	<input type="hidden" name="prplCompensateEarCullNumber_<%=idxEar%>">
                  	<input type="hidden" name="prplCompensateEarDeadNumber_<%=idxEar%>">
                  	<input type="hidden" name="prplCompensateEarDeadReason_<%=idxEar%>">
                  	<input type="hidden" name="prplCompensateEarKindCode_<%=idxEar%>">
                 	<input type="hidden" name="prplCompensateEarInusreListCode_<%=idxEar%>">
					<input type="hidden" name="illegalFlag_<%=idxEar%>" value ="true" >
                </td>
              </tr>  
            </tbody>
          </table>
        </span>        
        
        <span  id="spanEar_<%=idxEar%>" cellspacing="1" cellspacing="0"  width="100%">
        <%-- 多行输入展现域 --%>
        <table class="common"  id="Ear_<%=idxEar%>" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  耳标号清单 

              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:8%">农户代码</td>
              <td class="centertitle" style="width:18%">证件号码</td>
              <td class="centertitle" style="width:8%">姓名</td>
              <td class="centertitle" style="width:16%">开户行名称</td>
              <td class="centertitle" style="width:18%">银行账号</td>
              <td class="centertitle" style="width:18%">耳标号</td>
              <td class="centertitle" style="width:12%">定损金额</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr  style ="<%=display %>">
              <td class="title" colspan=7 style="width:96%">(按"+"号键增加财产核定损信息，按"-"号键删除信息)</td>
               <td class="title" align="right" style="width:4%">
                 <div align="center">
                   <input type="button" value="+" class="smallbutton" onclick="insertRow('Ear_<%=idxEar%>')" name="buttonDriverInsert_<%=idxEar%>" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          
          <tbody>
			<logic:notEmpty  name="<%=prplCompensateEarDtoList%>"  > 
			<logic:iterate id="prplCompensateEarDto" name="<%=prplCompensateEarDtoList%>">
              <tr>        
               <td class="input" style="width:17%">              
                  <input name="prplCompensateEarFCode_<%=idxEar%>" class=readonly readonly style='width:150px'  maxlength=170  value="<bean:write name='prplCompensateEarDto' property='fcode'/>">
                </td>      
                <td class="input" style="width:18%">              
                  <input name="prplCompensateEarId_Card_<%=idxEar%>" class=readonly readonly style='width:150px'  maxlength=180 value="<bean:write name='prplCompensateEarDto' property='id_card'/>">
                </td>
                  <td class="input" style="width:8%">           
                  <input name="prplCompensateEarName_<%=idxEar%>" class=readonly readonly style='width:80px'  maxlength=100 value="<bean:write name='prplCompensateEarDto' property='name'/>">
                </td>
                 <td class="input" style="width:14%">         
                  <input name="prplCompensateEarBank_<%=idxEar%>" class=readonly readonly style='width:140px'  maxlength=140 value="<bean:write name='prplCompensateEarDto' property='bank'/>">
                </td>
                 <td class="input" style="width:18%">        
                  <input name="prplCompensateEarAccount_<%=idxEar%>" class=readonly readonly style='width:180px'  maxlength=180 value="<bean:write name='prplCompensateEarDto' property='account'/>">
                </td>
          
                <td class="input" style="width:12%">  
                 <input     name= "prplCompensateEarEarNo_<%=idxEar%>" class="common" style="width:120px<%=combineEarbackStyleO%>"  readonly="readonly" maxlength=120 value="<bean:write name='prplCompensateEarDto' property='earno'/>">
                </td>
                <td class="input" style="width:7%">  
					<input  name= "prplCompensateEarEstimateLoss_<%=idxEar%>" class="common" style="width:70px"  maxlength=15 value="<bean:write name='prplCompensateEarDto' property='estimateloss'/>" onBlur="">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div style ="<%=display %>">
                  <input type="button" name="buttonEarDelete_<%=idxEar%>"  class="smallbutton" onclick="deleteRow(this,'Ear_<%=idxEar%>')"    value="-" style="cursor: hand">
                </div>
   				  <input type="hidden" name="prplCompensateEarPolicyNo_<%=idxEar%>"           value="<bean:write name='prplCompensateEarDto' property='policyno'/>">  
                  <input type="hidden" name="prplCompensateEarRegistNo_<%=idxEar%>"           value="<bean:write name='prplCompensateEarDto' property='registno'/>">       
                  <input type="hidden" name="prplCompensateEarClaimNo_<%=idxEar%>"            value="<bean:write name='prplCompensateEarDto' property='claimno'/>">     
                  <input type="hidden" name="prplCompensateEarCompensateNo_<%=idxEar%>"       value="<bean:write name='prplCompensateEarDto' property='compensateno'/>">  
                  <input type="hidden" name="prplCompensateEarCombineNo_<%=idxEar%>"          value="<bean:write name='prplCompensateEarDto' property='combineno'/>">          
                  <input type="hidden" name="prplCompensateEarCaseNo_<%=idxEar%>"             value="<bean:write name='prplCompensateEarDto' property='caseno'/>">       
                  <input type="hidden" name="prplCompensateEarDamageStartDate_<%=idxEar%>"    value="<bean:write name='prplCompensateEarDto' property='damagestartdate'/>">     
                  <input type="hidden" name="prplCompensateEarDamageStartHour_<%=idxEar%>"    value="<bean:write name='prplCompensateEarDto' property='damagestarthour'/>"> 
                  <input type="hidden" name="prplCompensateEarDamageEndDate_<%=idxEar%>"      value="<bean:write name='prplCompensateEarDto' property='damageenddate'/>">  
                  <input type="hidden" name="prplCompensateEarDamageCode_<%=idxEar%>"         value="<bean:write name='prplCompensateEarDto' property='damagecode'/>">          
                  <input type="hidden" name="prplCompensateEarDamageName_<%=idxEar%>"         value="<bean:write name='prplCompensateEarDto' property='damagename'/>">       
                  <input type="hidden" name="prplCompensateEarUnitAmount_<%=idxEar%>"         value="<bean:write name='prplCompensateEarDto' property='unitamount'/>">     
                  <input type="hidden" name="prplCompensateEarSumRealpay_<%=idxEar%>"         value="<bean:write name='prplCompensateEarDto' property='sumrealpay'/>">   
                  <input type="hidden" name="prplCompensateEarRestFee_<%=idxEar%>"            value="<bean:write name='prplCompensateEarDto' property='restfee'/>">  
                  <input type="hidden" name="prplCompensateEarClaimRate_<%=idxEar%>"          value="<bean:write name='prplCompensateEarDto' property='claimrate'/>">          
                  <input type="hidden" name="prplCompensateEarDeductibleRate_<%=idxEar%>"     value="<bean:write name='prplCompensateEarDto' property='deductiblerate'/>">       
                  <input type="hidden" name="prplCompensateEarDeductible_<%=idxEar%>"         value="<bean:write name='prplCompensateEarDto' property='deductible'/>">     
                  <input type="hidden" name="prplCompensateEarNodeNo_<%=idxEar%>"             value="">
                  <input type="hidden" name="prplCompensateEarNodeType_<%=idxEar%>"           value="<%= request.getParameter("nodeType")%>">
                  <input type="hidden" name="prplCompensateEarBreedingAreaCode_<%=idxEar%>"   value="<bean:write name='prplCompensateEarDto' property='breedingareacode'/>">
                  <input type="hidden" name="prplCompensateEarBreedingAreaName_<%=idxEar%>"   value="<bean:write name='prplCompensateEarDto' property='breedingareaname'/>">
                  <input type="hidden" name="prplCompensateEarCullNumber_<%=idxEar%>" 		  value="<bean:write name='prplCompensateEarDto' property='cullnumber'/>">
                  <input type="hidden" name="prplCompensateEarDeadNumber_<%=idxEar%>"		  value="<bean:write name='prplCompensateEarDto' property='deadnumber'/>">
                  <input type="hidden" name="prplCompensateEarDeadReason_<%=idxEar%>" 	      value="<bean:write name='prplCompensateEarDto' property='deadreason'/>">
                  <input type="hidden" name="prplCompensateEarKindCode_<%=idxEar%>"           value="<bean:write name='prplCompensateEarDto' property='kindcode'/>">
                  <input type="hidden" name="prplCompensateEarInusreListCode_<%=idxEar%>"     value="<bean:write name='prplCompensateEarDto' property='inusrelistcode'/>">
                  <input type="hidden" name="prplCompensateEarReportTime_<%=idxEar%>"         value="<bean:write name='prplCompensateEarDto' property='reporttime'/>">
                  <input type="hidden" name="illegalFlag_<%=idxEar%>" value="false">
                </td>
              </tr>  
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 
        </table>    
        </span>    

</span> 


<%}%>
</span> 
<%idxEar++;}%>