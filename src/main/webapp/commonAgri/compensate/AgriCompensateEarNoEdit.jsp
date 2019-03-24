<%--
****************************************************************************
* DESC       ：理算清单页面
* AUTHOR     ： =
* CREATEDATE ： 2011-08-25 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               
****************************************************************************
--%> 

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
      /*start判断耳标号 addby 张菊卿*/
      function earnoCheck()
      {
    	  var policyno = fm.earPolicyNo.value; 
    	  var nodeType = fm.nodeType.value;  
    	  if(policyno!=null&&policyno == "")
          {
              alert("无保单号");
              return false;
          }
           var riskcode = fm.riskcode.value;  
          var kindcode="";
          if(riskcode =="3220") kindcode ="3220001";
          else if(riskcode =="3202") kindcode ="001";
          else if(riskcode =="3223") kindcode ="3223001";
          else if(riskcode =="3225") kindcode ="3225001";
          else if(riskcode =="3236") kindcode ="001";
          else if(riskcode =="3227") kindcode ="3227001";
          else if(riskcode =="3233") kindcode ="001";
          else if(riskcode =="3234") kindcode ="001";
          else if(riskcode =="3239") kindcode ="001";
          else if(riskcode =="3240") kindcode ="001";
          else
          {
              alert("险种错误");
              return false;
          }
          var DamageStartDate = fm.DamageStartDate.value;
          if(DamageStartDate == null || trim(DamageStartDate).length != 10)
          {
              alert("请录入出险时间");
              return false;
          }
          var DamageStartHour = fm.DamageStartHour.value;
          if(DamageStartHour == null || trim(DamageStartHour).length == 0)
          {
              DamageStartHour = "00";
          }
		  var count;
		  count = getElementCount("prplCompensateEarEarNo");
		  if (count == 1)
		  {
			  alert("无耳标号输入");
			  return false;
		  }
	      var earnos = document.getElementsByName("prplCompensateEarEarNo");
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
		     	getEarResult(policyno,earnos[index].value,kindcode,DamageStartDate,DamageStartHour,index);   	
		      } 
	      }
		 var illegalFlag = document.getElementsByName("illegalFlag");
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
	    var bool  = true;
	    bool = checkEarNoAndModify();
	    if( bool != true)
	    return false;
	    
	    setPrpLltextContext();
	    alert( "耳标号检查通过");
      }
      
     function setPrpLltextContext()
     {
        var sumloss = 0.0;
        var text = "";
          for(i=1;i<fm.all("prplCompensateEarEarNo").length;i++)
          {
             var loss = parseFloat(fm.all("prplCompensateEarEstimateLoss")[i].value);
             if(isNaN(loss))
             {
               loss = 0.0;
             }
             sumloss = sumloss + loss;
             text = text + "耳标号：" + fm.all("prplCompensateEarEarNo")[i].value + " " + "赔付金额=" + fm.all("prplCompensateEarEstimateLoss")[i].value + "\r\n";
          }
          sumloss = sumloss.toFixed(2);//修改理算环节的理算报告的生成的赔款数值。
          text = text + "\r\n";
          text = text + "总赔付金额=" + sumloss;
          fm.prpLltextContextInnerHTML.value = text;
    }
  
        
     
     
   
      
     function getEarResult(policyno,earno,kindcode,DamageStartDate,DamageStartHour,index){
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
						fm.all("prplCompensateEarEarNo")[index].readOnly = "readonly";
					    fm.all("prplCompensateEarEarNo")[index].style.backgroundColor = "#CECECE";
						fm.all("illegalFlag")[index].value="false";
						alert( "无投保清单，请谨慎录入");
						return true;
					}
					var herdPolicyList = xmlDoc.getElementsByTagName("herdPolicyList");
			   
					if(herdPolicyList.length > 0){ 
						var herdPolicy = herdPolicyList[0].childNodes; 
				
						fm.all("prplCompensateEarInusreListCode")[index].value = herdPolicy[31].text; 
						fm.all("prplCompensateEarId_Card")[index].value = herdPolicy[3].text; 
						fm.all("prplCompensateEarName")[index].value = herdPolicy[2].text;
						fm.all("prplCompensateEarBank")[index].value = herdPolicy[17].text; 
						fm.all("prplCompensateEarAccount")[index].value = herdPolicy[18].text;
						fm.all("prplCompensateEarEstimateLoss")[index].value = herdPolicy[26].text;
						fm.all("prplCompensateEarUnitAmount")[index].value = herdPolicy[22].text;
						fm.all("prplCompensateEarFCode")[index].value = herdPolicy[1].text;
						fm.all("prplCompensateEarKindCode")[index].value = herdPolicy[19].text;
						fm.all("prplCompensateEarBreedingAreaCode")[index].value = herdPolicy[5].text;
						fm.all("prplCompensateEarBreedingAreaName")[index].value = herdPolicy[6].text;
						fm.all("prplCompensateEarEarNo")[index].readOnly = "readonly";
				     	fm.all("prplCompensateEarEarNo")[index].style.backgroundColor = "#CECECE";
				     	fm.all("illegalFlag")[index].value="false";
					}
					else
					{ 
						 fm.all("illegalFlag")[index].value="true";
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
    prplCompensateEarEstimateLoss= parseFloat(fm.all("prplCompensateEarEstimateLoss")[findex].value);

    if(isNaN(prplCompensateEarEstimateLoss)||prplCompensateEarEstimateLoss.length<1){
      prplCompensateEarEstimateLoss = 0;
    }
    fm.all("prplCompensateEarEstimateLoss")[findex].value = point(round(prplCompensateEarEstimateLoss ,2),2);
    return true;  
}

//页面校验：对数据进行修正
function checkEarNoAndModify()
{
	var countEar = getElementCount("prplCompensateEarEarNo");
 	 var killQuantity = document.getElementsByName("prpLcompensateKillQuantity")[0].value;
	 var deathQuantity = document.getElementsByName("prpLcompensateDeathQuantity")[0].value;
     var lossNumber = document.getElementsByName("prpLcompensateLossesNumber")[0].value;
     var EstimateLoss = document.getElementsByName("prplCompensateEarEstimateLoss")[1].value;
     //modify by xiatian	添加负数的赔偿数量.
     if(lossNumber < 0 && EstimateLoss < 0){
	 	document.getElementsByName("prpLcompensateLossesNumber")[0].value = (countEar -1)*-1;
	 }
	 else{
	 	document.getElementsByName("prpLcompensateLossesNumber")[0].value = countEar -1;
	 	}

     if(Number(lossNumber) > Number(killQuantity) + Number(deathQuantity) )
     {
	   alert( "赔付数量不应大于扑杀数量和死亡数量之和");
	    return false;
     }
	//start计算出现户次
	var array1 = document.getElementsByName("prplCompensateEarId_Card");
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
	var damageInsured = document.getElementsByName("prpLcompensateDamageInsured")[0].value;
	document.getElementsByName("prpLcompensateDamageInsured")[0].value = newArray.length;
	var countProp = getElementCount("LossItemName");
	if(countProp > 2){ 
	alert( "赔付信息不能有多条记录！！");
	return false;
	}	
	if(countEar >1){
		if(countProp < 2){ 
		alert( "耳标号清单非空时赔付标的的赔付信息不能为空");
		return false;}
		else
		{
			var sum = 0;
			for (var i = 1; i < countEar ;i++)
			{
			sum = sum + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss")[i].value);
			}
			sum = sum.toFixed(2);//用于消除计算的精度差，完成立案提交校验
			if(sum != parseFloat(document.getElementsByName("prpLlossDtoSumRealPay")[1].value)){
			alert( "赔付信息金额不等于耳标赔偿金额之和");
			return false;
			}
		}
	}
	return true;
}
//页面校验：提示用户
function checkEarNoAndPromote()
{
	var countEar = getElementCount("prplCompensateEarEarNo");
 	 var killQuantity = document.getElementsByName("prpLcompensateKillQuantity")[0].value;
	 var deathQuantity = document.getElementsByName("prpLcompensateDeathQuantity")[0].value;
     var lossNumber = document.getElementsByName("prpLcompensateLossesNumber")[0].value;
     if(isNaN(lossNumber))
	 {
	 		 alert( "赔付数量须为数字");
		     return false;
	 }
	 if(lossNumber > 0){
	     if(Number(lossNumber) != (countEar -1) )
	     {
		     alert( "赔付数量不等于耳标号清单数量");
		     return false;
	     }
     }
     else{
     	 if(Number(lossNumber) != (countEar -1)*-1 )
	     {
		     alert( "赔付数量不等于耳标号清单数量");
		     return false;
	     }
     }
     if(Number(lossNumber) > Number(killQuantity) + Number(deathQuantity) )
     {
	      alert( "赔付数量不应大于扑杀数量和死亡数量之和");
	     return false;
     }
	//start计算出现户次
	var array1 = document.getElementsByName("prplCompensateEarId_Card");
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
	 var damageInsured = document.getElementsByName("prpLcompensateDamageInsured")[0].value;
	 if(isNaN(damageInsured))
	 {
	  		 alert( "出险户次须为数字");
		     return false;
	 }
	 if( Number(damageInsured) != newArray.length )
	     {
		     alert( "出险户次错误");
		     return false;
	     }
	var countProp = getElementCount("LossItemName");
	if(countProp > 2){ 
	alert( "赔付信息不能有多条记录！！");
	return false;
	}
	
	if(countEar >1){
		if(countProp < 2){ 
		alert( "耳标号清单非空时赔付标的的赔付信息不能为空");
		return false;}
		else
		{
			var sum = 0;
			for (var i = 1; i < countEar ;i++)
			{
			sum = sum + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss")[i].value);
			}
			sum = sum.toFixed(2);//用于消除计算的精度差，完成立案提交校验
			if(sum != parseFloat(document.getElementsByName("prpLlossDtoSumRealPay")[1].value)){
			alert( "赔付信息金额不等于耳标赔偿金额之和");
			return false;
			}
		}
	}
	return true;
}
function checkEarBeforeSave(){
	var countEar = getElementCount("prplCompensateEarEarNo");
	if(countEar < 2){
	   alert( "请至少录入一条耳标号信息！");
       return false;
	}
	var illegalFlag = document.getElementsByName("illegalFlag");
	for(var index = 1 ;index < countEar ; index++)
	{
	   if(illegalFlag[index].value == "true")
	    {
    		alert( "请检查耳标号");
    		return false;
	    }
	} 
	var bool = checkEarNoAndPromote();
	if ( bool != true)  
	{
   		alert( "请检查耳标号");
   		return false;
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
%>    
  <input type="hidden" name= "nodeType"  value="<%= request.getParameter("nodeType")%>">
  <span  id="SpanEar" style="display:" cellspacing="1" cellpadding="0">
  <table class="common" cellpadding="8" cellspacing="1">

  </table> 
      <span style="display:none"> 
          <table class="common" style="display:none" id="Ear_Data" cellpadding="8" cellspacing="1">
            <tbody>
              <tr>
              <td class="input" style="width:17%">              
                  <input name="prplCompensateEarFCode" class=readonly readonly style='width:150px'  maxlength=20  >
                </td>      
                 <td class="input" style="width:18%">          
                  <input name="prplCompensateEarId_Card"  class="common" style='width:150px'  maxlength=20 >
                </td>
                  <td class="input" style="width:8%">        
                  <input name="prplCompensateEarName"  class="common" style='width:80px'  maxlength=50 >
                </td>
                  <td class="input" style="width:14%">
                  <input name="prplCompensateEarBank"  class="common" style='width:140px'  maxlength=50 >
                </td>
                  <td class="input" style="width:18%">
                  <input name="prplCompensateEarAccount"  class="common" style='width:180px'  maxlength=24 >
                </td>
                 <td class="input" style="width:12%">  
                  <input name="prplCompensateEarEarNo" class="common" style='width:120px'  maxlength=17 >
                </td>  
                  <td class="input" style="width:7%">         
                  <input name="prplCompensateEarEstimateLoss" value ="0.0" class="common" style='width:70px'  maxlength=17 onBlur="formateEarEstimateLoss(this);">
                </td>  
  
                <td class="input" style='width:4px'  align="center">
                <div>
                  <input type=button name="buttonEarDelete"  class="smallbutton" onclick="deleteRow(this,'Ear')" value="-" style="cursor: hand">
                </div>
					<input type="hidden" name="prplCompensateEarPolicyNo"  value="<%= request.getParameter("policyNo") %>">
					<input type="hidden" name="prplCompensateEarRegistNo"  value="<%= request.getParameter("RegistNo") %>">
					<input type="hidden" name="prplCompensateEarClaimNo">
					<input type="hidden" name="prplCompensateEarCompensateNo">
					<input type="hidden" name="prplCompensateEarCombineNo">
					<input type="hidden" name="prplCompensateEarCaseNo">
					<input type="hidden" name="prplCompensateEarDamageStartDate">
					<input type="hidden" name="prplCompensateEarDamageStartHour">
					<input type="hidden" name="prplCompensateEarDamageEndDate">
					<input type="hidden" name="prplCompensateEarDamageCode">
					<input type="hidden" name="prplCompensateEarDamageName">
					<input type="hidden" name="prplCompensateEarUnitAmount">
					<input type="hidden" name="prplCompensateEarSumRealpay">
					<input type="hidden" name="prplCompensateEarRestFee">
					<input type="hidden" name="prplCompensateEarClaimRate">
					<input type="hidden" name="prplCompensateEarDeductibleRate">
					<input type="hidden" name="prplCompensateEarDeductible">
					<input type="hidden" name="prplCompensateEarNodeNo" >
                    <input type="hidden" name="prplCompensateEarNodeType" value="<%= request.getParameter("nodeType")%>">
                    <input type="hidden" name="prplCompensateEarReportTime">
                    <input type="hidden" name="prplCompensateEarBreedingAreaCode">
                  	<input type="hidden" name="prplCompensateEarBreedingAreaName">
                 	<input type="hidden" name="prplCompensateEarCullNumber">
                  	<input type="hidden" name="prplCompensateEarDeadNumber">
                  	<input type="hidden" name="prplCompensateEarDeadReason">
                  	<input type="hidden" name="prplCompensateEarKindCode">
                 	<input type="hidden" name="prplCompensateEarInusreListCode">
					<input type="hidden" name="illegalFlag" value ="true" >
                </td>
              </tr>  
            </tbody>
          </table>
        </span>        
        
        <span  id="spanEar" cellspacing="1" cellspacing="0"  width="100%">
        <%-- 多行输入展现域 --%>
        <table class="common"  id="Ear" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  耳标号清单 
                <input type="button" align="right" name="checkEarno"  onclick="earnoCheck()"  value="耳标号验证" style="cursor: hand">
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:8%">农户代码</td>
              <td class="centertitle" style="width:18%">证件号码</td>
              <td class="centertitle" style="width:12%">姓名</td>
              <td class="centertitle" style="width:16%">开户行名称</td>
              <td class="centertitle" style="width:18%">银行账号</td>
              <td class="centertitle" style="width:18%">耳标号</td>
              <td class="centertitle" style="width:12%">赔偿金额</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr>
              <td class="title" colspan=7 style="width:96%">(按"+"号键增加财产核定损信息，按"-"号键删除信息)</td>
               <td class="title" align="right" style="width:4%">
                 <div align="center">
                   <input type="button" value="+" class="smallbutton" onclick="insertRow('Ear')" name="buttonDriverInsert" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          
          <tbody>
			<logic:notEmpty  name="prplCompensateEarDtoList"  > 
			<logic:iterate id="prplCompensateEarDto" name="prplCompensateEarDtoList">
              <tr>        
               <td class="input" style="width:17%">              
                  <input name="prplCompensateEarFCode" class=readonly readonly  style='width:150px'  maxlength=20  value="<bean:write name='prplCompensateEarDto' property='fcode'/>">
                </td>      
                <td class="input" style="width:18%">              
                  <input name="prplCompensateEarId_Card"  class="common" style='width:150px'  maxlength=20 value="<bean:write name='prplCompensateEarDto' property='id_card'/>">
                </td>
                  <td class="input" style="width:8%">           
                  <input name="prplCompensateEarName"  class="common" style='width:80px'  maxlength=50 value="<bean:write name='prplCompensateEarDto' property='name'/>">
                </td>
                 <td class="input" style="width:14%">         
                  <input name="prplCompensateEarBank"  class="common" style='width:140px'  maxlength=50 value="<bean:write name='prplCompensateEarDto' property='bank'/>">
                </td>
                 <td class="input" style="width:18%">        
                  <input name="prplCompensateEarAccount"  class="common" style='width:180px'  maxlength=24 value="<bean:write name='prplCompensateEarDto' property='account'/>">
                </td>
                <td class="input" style="width:12%">  
                 <input     name= "prplCompensateEarEarNo" class="common" style="width:120px<%=combineEarbackStyleO%>"  readonly="readonly" maxlength=17 value="<bean:write name='prplCompensateEarDto' property='earno'/>">
                </td>
                <td class="input" style="width:7%">  
					<input  name= "prplCompensateEarEstimateLoss" class="common" style="width:70px"  maxlength=17 value="<bean:write name='prplCompensateEarDto' property='estimateloss'/>" onBlur="formateEarEstimateLoss(this);">
                </td>
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type="button" name="buttonEarDelete"  class="smallbutton" onclick="deleteRow(this,'Ear')"    value="-" style="cursor: hand">
                </div>
   				  <input type="hidden" name="prplCompensateEarPolicyNo"           value="<bean:write name='prplCompensateEarDto' property='policyno'/>">  
                  <input type="hidden" name="prplCompensateEarRegistNo"           value="<bean:write name='prplCompensateEarDto' property='registno'/>">       
                  <input type="hidden" name="prplCompensateEarClaimNo"            value="<bean:write name='prplCompensateEarDto' property='claimno'/>">     
                  <input type="hidden" name="prplCompensateEarCompensateNo"       value="<bean:write name='prplCompensateEarDto' property='compensateno'/>">  
                  <input type="hidden" name="prplCompensateEarCombineNo"          value="<bean:write name='prplCompensateEarDto' property='combineno'/>">          
                  <input type="hidden" name="prplCompensateEarCaseNo"             value="<bean:write name='prplCompensateEarDto' property='caseno'/>">       
                  <input type="hidden" name="prplCompensateEarDamageStartDate"    value="<bean:write name='prplCompensateEarDto' property='damagestartdate'/>">     
                  <input type="hidden" name="prplCompensateEarDamageStartHour"    value="<bean:write name='prplCompensateEarDto' property='damagestarthour'/>"> 
                  <input type="hidden" name="prplCompensateEarDamageEndDate"      value="<bean:write name='prplCompensateEarDto' property='damageenddate'/>">  
                  <input type="hidden" name="prplCompensateEarDamageCode"         value="<bean:write name='prplCompensateEarDto' property='damagecode'/>">          
                  <input type="hidden" name="prplCompensateEarDamageName"         value="<bean:write name='prplCompensateEarDto' property='damagename'/>">       
                  <input type="hidden" name="prplCompensateEarUnitAmount"         value="<bean:write name='prplCompensateEarDto' property='unitamount'/>">     
                  <input type="hidden" name="prplCompensateEarSumRealpay"         value="<bean:write name='prplCompensateEarDto' property='sumrealpay'/>">   
                  <input type="hidden" name="prplCompensateEarRestFee"            value="<bean:write name='prplCompensateEarDto' property='restfee'/>">  
                  <input type="hidden" name="prplCompensateEarClaimRate"          value="<bean:write name='prplCompensateEarDto' property='claimrate'/>">          
                  <input type="hidden" name="prplCompensateEarDeductibleRate"     value="<bean:write name='prplCompensateEarDto' property='deductiblerate'/>">       
                  <input type="hidden" name="prplCompensateEarDeductible"         value="<bean:write name='prplCompensateEarDto' property='deductible'/>">     
                  <input type="hidden" name="prplCompensateEarNodeNo"             value="">
                  <input type="hidden" name="prplCompensateEarNodeType"           value="<%= request.getParameter("nodeType")%>">
                  <input type="hidden" name="prplCompensateEarBreedingAreaCode"   value="<bean:write name='prplCompensateEarDto' property='breedingareacode'/>">
                  <input type="hidden" name="prplCompensateEarBreedingAreaName"   value="<bean:write name='prplCompensateEarDto' property='breedingareaname'/>">
                  <input type="hidden" name="prplCompensateEarCullNumber" 		  value="<bean:write name='prplCompensateEarDto' property='cullnumber'/>">
                  <input type="hidden" name="prplCompensateEarDeadNumber"		  value="<bean:write name='prplCompensateEarDto' property='deadnumber'/>">
                  <input type="hidden" name="prplCompensateEarDeadReason" 	      value="<bean:write name='prplCompensateEarDto' property='deadreason'/>">
                  <input type="hidden" name="prplCompensateEarKindCode"           value="<bean:write name='prplCompensateEarDto' property='kindcode'/>">
                  <input type="hidden" name="prplCompensateEarInusreListCode"     value="<bean:write name='prplCompensateEarDto' property='inusrelistcode'/>">
                  <input type="hidden" name="prplCompensateEarReportTime"         value="<bean:write name='prplCompensateEarDto' property='reporttime'/>">
                  <input type="hidden" name="illegalFlag" value="false">
                </td>
              </tr>  
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 
        </table>    
        </span>    

</span> 