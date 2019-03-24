<%--
****************************************************************************
* DESC       ：财产损失清单页面
* AUTHOR     ： 张菊卿
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@page import="java.util.ArrayList" %>
<!--建立显示的录入条，可以收缩显示的-->   
<script language='javascript'>  
 //在下面加入本页自定义的JavaScript方法
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertEar()
      {
       // setPrpLpropSerialNo();
      } 
    
      /* 
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteEar(field)
      {    
       // setPrpLpropSerialNo();
      }
    
      /**
       * 设置setPrpLpropSerialNo
       */
      function setPrpLpropSerialNo(){
          var count=getElementCount("prpLpropSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("看看什么时候运行?count="+count+"  i="+i); 
              if(count!=1){
                fm.prpLpropSerialNo[i].value=i;
              }
          }
      }
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
	      else if (nodeType == "claim"){
	      	  var eleDamageStartDate = document.getElementsByName("prpLclaimDamageStartDate_"+combineIndex);
	          DamageStartDate = eleDamageStartDate[0].value;
	          var eleDamageStartHour = document.getElementsByName("prpLclaimDamageStartHour_"+combineIndex);
	          DamageStartHour = eleDamageStartHour[0].value;
	          var eleRiskCode = document.getElementsByName("prpLclaimRiskCode_"+combineIndex);
	          riskcode = eleRiskCode[0].value;
	      }
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
 	 var killQuantity = document.getElementsByName("prpLclaimKillQuantity_"+combineIndex)[0];
	 var deathQuantity = document.getElementsByName("prpLclaimDeathQuantity_"+combineIndex)[0];
     var lossNumber = document.getElementsByName("prpLclaimLossesNumber_"+combineIndex)[0];
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
	 var damageInsured = document.getElementsByName("prpLclaimDamageInsured_"+combineIndex)[0];
	 if(isNaN(damageInsured.value) || Number(damageInsured.value) != newArray.length)
	 {
	  		damageInsured.value = newArray.length ;//alert( "出险户次须为数字");
	 }
	 
	var countProp = getElementCount("prpLclaimAcciPersonFamilyNo_"+combineIndex);
	if(countProp > 2){ 
		alert( "险别估损金额信息不能有多条记录");
		return false;
	}
	
	if(countEar >1){
		if(countProp < 2){
			alert( "耳标号清单非空时险别估损金额信息不能为空");//????????????????????????????????
			return false;}
		else
		{
			var sum = 0;
			for (var i = 1; i < countEar ;i++)
			{
			sum = sum + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss_"+combineIndex)[i].value);
			}
			var sumPrpLclaimLossSumClaim = 0;
			if(countProp > 1){
				for(var index =1;index<countProp;index++){
					var elePrpLclaimLossLossFeeType = document.getElementsByName("prpLclaimLossLossFeeType_"+combineIndex)[index];
					var prpLclaimLossLossFeeType = elePrpLclaimLossLossFeeType.value;
					if("P"==prpLclaimLossLossFeeType){//P表示该类别为赔款
						var elePrpLclaimLossSumClaim = document.getElementsByName("prpLclaimLossSumClaim_"+combineIndex)[index];
						sumPrpLclaimLossSumClaim = parseFloat(sumPrpLclaimLossSumClaim) + parseFloat(elePrpLclaimLossSumClaim.value);
					}
				}
			}
			if(sum != parseFloat(sumPrpLclaimLossSumClaim)){
			document.getElementsByName("prpLclaimLossSumClaim_"+combineIndex)[1].value = sum;
			//alert( "预计给付金额受损金额不等于耳标定损金额之和");
			//return false;
			}
		}
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
<% String combineEarbackReadOnlyO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String combineEarbackDiasableO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String combineEarbackStyleO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<%      combineEarbackStyleO=";background:#CECECE";
 combineEarbackReadOnlyO="readOnly";
 combineEarbackDiasableO="disabled";
 
 ArrayList prplCompensateEarDtoList = (ArrayList)request.getAttribute("prplCompensateEarDtoList_"+indexClaimEarNo);
 request.setAttribute("prplCompensateEarDtoList",prplCompensateEarDtoList);
%>    
  <span  id="SpanEar_<%=indexClaimEarNo %>" style="display:" cellspacing="1" cellpadding="0">
  <table class="common" cellpadding="8" cellspacing="1">

  </table> 
      <span style="display:none"> 
          <table class="common" style="display:none" id="Ear_<%=indexClaimEarNo %>_Data" cellpadding="8" cellspacing="1">
            <tbody>
              <tr>
              <td class="input" style="width:17%">              
                  <input name="prplCompensateEarFCode_<%=indexClaimEarNo %>" class=readonly readonly style='width:150px'  maxlength=20  >
                </td>      
                 <td class="input" style="width:18%">          
                  <input name="prplCompensateEarId_Card_<%=indexClaimEarNo %>" class=readonly readonly style='width:150px'  maxlength=20 >
                </td>
                  <td class="input" style="width:8%">        
                  <input name="prplCompensateEarName_<%=indexClaimEarNo %>" class=readonly readonly style='width:80px'  maxlength=50 >
                </td>
                  <td class="input" style="width:14%">
                  <input name="prplCompensateEarBank_<%=indexClaimEarNo %>" class=readonly readonly style='width:140px'  maxlength=50 >
                </td>
                  <td class="input" style="width:18%">
                  <input name="prplCompensateEarAccount_<%=indexClaimEarNo %>" class=readonly readonly style='width:180px'  maxlength=24 >
                </td>
                 <td class="input" style="width:12%">  
                  <input name="prplCompensateEarEarNo_<%=indexClaimEarNo %>" class="common" style='width:120px'  maxlength=17 >
                </td>  
                  <td class="input" style="width:7%">         
                  <input name="prplCompensateEarEstimateLoss_<%=indexClaimEarNo %>" value="0.0"  class="common" style='width:70px'  maxlength=17 onBlur="">
                </td>  
  
                <td class="input" style='width:4px'  align="center">
                <div>
                  <input type=button name="buttonEarDelete_<%=indexClaimEarNo %>"  class="smallbutton" onclick="deleteRow(this,'Ear_<%=indexClaimEarNo %>')" value="-" style="cursor: hand">
                </div>
					<input type="hidden" name="prplCompensateEarPolicyNo_<%=indexClaimEarNo %>"  value="<%= request.getParameter("policyNo_"+indexClaimEarNo) %>">
					<input type="hidden" name="prplCompensateEarRegistNo_<%=indexClaimEarNo %>"  value="<%= request.getParameter("RegistNo_"+indexClaimEarNo) %>">
					<input type="hidden" name="prplCompensateEarClaimNo_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarCompensateNo_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarCombineNo_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarCaseNo_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDamageStartDate_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDamageStartHour_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDamageEndDate_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDamageCode_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDamageName_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarUnitAmount_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarSumRealpay_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarRestFee_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarClaimRate_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDeductibleRate_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarDeductible_<%=indexClaimEarNo %>">
					<input type="hidden" name="prplCompensateEarNodeNo_<%=indexClaimEarNo %>" >
                    <input type="hidden" name="prplCompensateEarNodeType_<%=indexClaimEarNo %>" value="<%= request.getParameter("nodeType_"+indexClaimEarNo)%>">
                    <input type="hidden" name="prplCompensateEarReportTime_<%=indexClaimEarNo %>">
                    <input type="hidden" name="prplCompensateEarBreedingAreaCode_<%=indexClaimEarNo %>">
                  	<input type="hidden" name="prplCompensateEarBreedingAreaName_<%=indexClaimEarNo %>">
                 	<input type="hidden" name="prplCompensateEarCullNumber_<%=indexClaimEarNo %>">
                  	<input type="hidden" name="prplCompensateEarDeadNumber_<%=indexClaimEarNo %>">
                  	<input type="hidden" name="prplCompensateEarDeadReason_<%=indexClaimEarNo %>">
                  	<input type="hidden" name="prplCompensateEarKindCode_<%=indexClaimEarNo %>">
                 	<input type="hidden" name="prplCompensateEarInusreListCode_<%=indexClaimEarNo %>">
					<input type="hidden" name="illegalFlag_<%=indexClaimEarNo %>" value ="true" >
                </td>
              </tr>  
            </tbody>
          </table>
        </span>        
        
        <span  id="spanEar" cellspacing="1" cellspacing="0"  width="100%">
        <%-- 多行输入展现域 --%>
        <table class="common"  id="Ear_<%=indexClaimEarNo %>" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  耳标号清单 
                <!-- <input type="button" align="right" name="checkEarno"  onclick="checkEarBeforeSave()"  value="耳标号验证" style="cursor: hand">   -->
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:8%">农户代码</td>
              <td class="centertitle" style="width:18%">证件号码</td>
              <td class="centertitle" style="width:8%">姓名</td>
              <td class="centertitle" style="width:16%">开户行名称</td>
              <td class="centertitle" style="width:18%">银行账号</td>
              <td class="centertitle" style="width:18%">耳标号</td>
              <td class="centertitle" style="width:12%">估损金额</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr>
              <td class="title" colspan=7 style="width:96%">(按"+"号键增加财产核定损信息，按"-"号键删除信息)</td>
               <td class="title" align="right" style="width:4%">
                 <div align="center">
                   <input type="button" value="+" class="smallbutton" onclick="insertRow('Ear_<%=indexClaimEarNo %>')" name="buttonDriverInsert_<%=indexClaimEarNo %>" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          
          <tbody>
			<logic:notEmpty  name="prplCompensateEarDtoList"  > 
			<logic:iterate id="prplCompensateEarDto" name="prplCompensateEarDtoList">
              <tr>        
               <td class="input" style="width:17%">              
                  <input name="prplCompensateEarFCode_<%=indexClaimEarNo %>" class=readonly readonly style='width:150px'  maxlength=20  value="<bean:write name='prplCompensateEarDto' property='fcode'/>">
                </td>      
                <td class="input" style="width:18%">              
                  <input name="prplCompensateEarId_Card_<%=indexClaimEarNo %>" class=readonly readonly style='width:150px'  maxlength=20 value="<bean:write name='prplCompensateEarDto' property='id_card'/>">
                </td>
                  <td class="input" style="width:8%">           
                  <input name="prplCompensateEarName_<%=indexClaimEarNo %>" class=readonly readonly style='width:80px'  maxlength=50 value="<bean:write name='prplCompensateEarDto' property='name'/>">
                </td>
                 <td class="input" style="width:14%">         
                  <input name="prplCompensateEarBank_<%=indexClaimEarNo %>" class=readonly readonly style='width:140px'  maxlength=50 value="<bean:write name='prplCompensateEarDto' property='bank'/>">
                </td>
                 <td class="input" style="width:18%">        
                  <input name="prplCompensateEarAccount_<%=indexClaimEarNo %>" class=readonly readonly style='width:180px'  maxlength=24 value="<bean:write name='prplCompensateEarDto' property='account'/>">
                </td>
          
                <td class="input" style="width:12%">  
                 <input     name= "prplCompensateEarEarNo_<%=indexClaimEarNo %>" class="common" style="width:120px<%=combineEarbackStyleO%>"  readonly="readonly" maxlength=17 value="<bean:write name='prplCompensateEarDto' property='earno'/>">
                </td>
                <td class="input" style="width:7%">  
					<input  name= "prplCompensateEarEstimateLoss_<%=indexClaimEarNo %>" class="common" style="width:70px"  maxlength=17 value="<bean:write name='prplCompensateEarDto' property='estimateloss'/>" onBlur="">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type="button" name="buttonEarDelete_<%=indexClaimEarNo %>"  class="smallbutton" onclick="deleteRow(this,'Ear_<%=indexClaimEarNo %>')"    value="-" style="cursor: hand">
                </div>
   				  <input type="hidden" name="prplCompensateEarPolicyNo_<%=indexClaimEarNo %>"           value="<bean:write name='prplCompensateEarDto' property='policyno'/>">  
                  <input type="hidden" name="prplCompensateEarRegistNo_<%=indexClaimEarNo %>"           value="<bean:write name='prplCompensateEarDto' property='registno'/>">       
                  <input type="hidden" name="prplCompensateEarClaimNo_<%=indexClaimEarNo %>"            value="<bean:write name='prplCompensateEarDto' property='claimno'/>">     
                  <input type="hidden" name="prplCompensateEarCompensateNo_<%=indexClaimEarNo %>"       value="<bean:write name='prplCompensateEarDto' property='compensateno'/>">  
                  <input type="hidden" name="prplCompensateEarCombineNo_<%=indexClaimEarNo %>"          value="<bean:write name='prplCompensateEarDto' property='combineno'/>">          
                  <input type="hidden" name="prplCompensateEarCaseNo_<%=indexClaimEarNo %>"             value="<bean:write name='prplCompensateEarDto' property='caseno'/>">       
                  <input type="hidden" name="prplCompensateEarDamageStartDate_<%=indexClaimEarNo %>"    value="<bean:write name='prplCompensateEarDto' property='damagestartdate'/>">     
                  <input type="hidden" name="prplCompensateEarDamageStartHour_<%=indexClaimEarNo %>"    value="<bean:write name='prplCompensateEarDto' property='damagestarthour'/>"> 
                  <input type="hidden" name="prplCompensateEarDamageEndDate_<%=indexClaimEarNo %>"      value="<bean:write name='prplCompensateEarDto' property='damageenddate'/>">  
                  <input type="hidden" name="prplCompensateEarDamageCode_<%=indexClaimEarNo %>"         value="<bean:write name='prplCompensateEarDto' property='damagecode'/>">          
                  <input type="hidden" name="prplCompensateEarDamageName_<%=indexClaimEarNo %>"         value="<bean:write name='prplCompensateEarDto' property='damagename'/>">       
                  <input type="hidden" name="prplCompensateEarUnitAmount_<%=indexClaimEarNo %>"         value="<bean:write name='prplCompensateEarDto' property='unitamount'/>">     
                  <input type="hidden" name="prplCompensateEarSumRealpay_<%=indexClaimEarNo %>"         value="<bean:write name='prplCompensateEarDto' property='sumrealpay'/>">   
                  <input type="hidden" name="prplCompensateEarRestFee_<%=indexClaimEarNo %>"            value="<bean:write name='prplCompensateEarDto' property='restfee'/>">  
                  <input type="hidden" name="prplCompensateEarClaimRate_<%=indexClaimEarNo %>"          value="<bean:write name='prplCompensateEarDto' property='claimrate'/>">          
                  <input type="hidden" name="prplCompensateEarDeductibleRate_<%=indexClaimEarNo %>"     value="<bean:write name='prplCompensateEarDto' property='deductiblerate'/>">       
                  <input type="hidden" name="prplCompensateEarDeductible_<%=indexClaimEarNo %>"         value="<bean:write name='prplCompensateEarDto' property='deductible'/>">     
                  <input type="hidden" name="prplCompensateEarNodeNo_<%=indexClaimEarNo %>"             value="">
                  <input type="hidden" name="prplCompensateEarNodeType_<%=indexClaimEarNo %>"           value="<%= request.getParameter("nodeType_"+indexClaimEarNo)%>">
                  <input type="hidden" name="prplCompensateEarBreedingAreaCode_<%=indexClaimEarNo %>"   value="<bean:write name='prplCompensateEarDto' property='breedingareacode'/>">
                  <input type="hidden" name="prplCompensateEarBreedingAreaName_<%=indexClaimEarNo %>"   value="<bean:write name='prplCompensateEarDto' property='breedingareaname'/>">
                  <input type="hidden" name="prplCompensateEarCullNumber_<%=indexClaimEarNo %>" 		  value="<bean:write name='prplCompensateEarDto' property='cullnumber'/>">
                  <input type="hidden" name="prplCompensateEarDeadNumber_<%=indexClaimEarNo %>"		  value="<bean:write name='prplCompensateEarDto' property='deadnumber'/>">
                  <input type="hidden" name="prplCompensateEarDeadReason_<%=indexClaimEarNo %>" 	      value="<bean:write name='prplCompensateEarDto' property='deadreason'/>">
                  <input type="hidden" name="prplCompensateEarKindCode_<%=indexClaimEarNo %>"           value="<bean:write name='prplCompensateEarDto' property='kindcode'/>">
                  <input type="hidden" name="prplCompensateEarInusreListCode_<%=indexClaimEarNo %>"     value="<bean:write name='prplCompensateEarDto' property='inusrelistcode'/>">
                  <input type="hidden" name="prplCompensateEarReportTime_<%=indexClaimEarNo %>"         value="<bean:write name='prplCompensateEarDto' property='reporttime'/>">
                  <input type="hidden" name="illegalFlag_<%=indexClaimEarNo %>" value="false">
                </td>
              </tr>  
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 
        </table>    
        </span>    

</span> 
<%indexClaimEarNo++;%>