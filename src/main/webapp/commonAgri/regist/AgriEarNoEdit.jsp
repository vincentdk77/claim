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

   <!--建立显示的录入条，可以收缩显示的-->   
<script language='javascript'>  
 //在下面加入本页自定义的JavaScript方法
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertEar()
      {
       var countEar = getElementCount("prplCompensateEarEarNo");
       document.getElementsByName("prpLregistLossesNumber")[0].value = countEar -1;
       generateRegistText();
        //setPrpLpropSerialNo();
      } 
    
      /* 
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteEar(field)
      {    
       var countEar = getElementCount("prplCompensateEarEarNo");
       document.getElementsByName("prpLregistLossesNumber")[0].value = countEar -1;
       generateRegistText();
        //setPrpLpropSerialNo();
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
function copyEarlabel(field){
	var listFlag = fm.all("listFlag").value ;
	if(listFlag == "false")
 	  {
	 	   var earnos = document.getElementsByName("prplCompensateEarEarNo");
	 	   var count=getElementCount("prplCompensateEarEarNo");
	 	   earnos[getElementOrder(field)-1].value = field.value;
	 	   if(count == 2){alert("该保单无关联清单，请谨慎录入");}
 	  }
}
function generateRegistText(){
	if(getElementCount("prplCompensateEarEarNo")>1){
		var innerText = fm.all("prpLregistDamageStartDate").value+
		"，被保险养殖户("+
		fm.all("prplCompensateEarName")[1].value+
		")的 "+
		fm.all("prpLregistLossesNumber").value+"头"+
		fm.all("prpLregistLossName").value+"因"+
		fm.all("prpLregistDamageName").value+
		"，导致死亡。";
		fm.all("prpLregistTextContextInnerHTML").innerHTML = innerText;
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
    prplCompensateEarEstimateLoss= parseFloat(fm.all("prplCompensateEarEstimateLoss")[findex].value);

    if(isNaN(prplCompensateEarEstimateLoss)||prplCompensateEarEstimateLoss.length<1){
      prplCompensateEarEstimateLoss = 0;
    }
    fm.all("prplCompensateEarEstimateLoss")[findex].value = point(round(prplCompensateEarEstimateLoss ,2),2);
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
  <input type="hidden" name="listFlag" value="<%= request.getAttribute("ListFlag")%>">
  <span  id="SpanEar" style="display:" cellspacing="1" cellpadding="0">
  <table class="common" cellpadding="8" cellspacing="1">

  </table> 
      <span style="display:none"> 
          <table class="common" style="display:none" id="Ear_Data" cellpadding="8" cellspacing="1">
            <tbody>
              <tr>
              <td class="input" style="width:10%">              
                  <input name="prplCompensateEarFCode" class=readonly readonly style='width:100px'  maxlength=20  >
                </td>      
                 <td class="input" style="width:18%">          
                  <input name="prplCompensateEarId_Card" class=readonly readonly style='width:150px'  maxlength=20 >
                </td>
                  <td class="input" style="width:8%">        
                  <input name="prplCompensateEarName" class=readonly readonly style='width:80px'  maxlength=50 >
                </td>
                  <td class="input" style="width:14%">
                  <input name="prplCompensateEarBank" class=readonly readonly style='width:140px'  maxlength=50 >
                </td>
                  <td class="input" style="width:16%">
                  <input name="prplCompensateEarAccount" class=readonly readonly style='width:160px'  maxlength=24 >
                </td>
                 <td class="input" style="width:19%">  
                 <input name="prplCompensateEarEarNo" class=readonly readonly style='width:70px'  maxlength=24 >
                  <input name="prplCompensateEarEarNo1" class="codecode" style='width:60px'  maxlength=17   
                  ondblclick="code_CodeSelect(this, 'prpLRegistEarNoCheck','30,-5,-4,-3,-2,1,15,-6,29,24,25,-1,31,2','name','select','post');"
      			  onkeyup= "code_CodeSelect(this, 'prpLRegistEarNoCheck','30,-5,-4,-3,-2,1,15,-6,29,24,25,-1,31,2','name','select','post');"
      			  onblur= "generateRegistText();copyEarlabel(this);" >
                </td>  
                  <td class="input" style="width:7%">         
                  <input name="prplCompensateEarEstimateLoss" value ="0.0" class="common" style='width:70px'  maxlength=17 onBlur="formateEarEstimateLoss(this);">
                </td>  
    			 </td>  
                  <td class="input" style="width:2%">         
                  <input name="prplCompensateEarInprocess" class=readonly readonly  style='width:20px'  maxlength=1 >
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
             	  耳标号清单				耳标号：
             	  <input name="prplEarEarNoSearch" class="codecode" style='width:60px'  maxlength=17   >
             	  农户姓名：
             	  <input name="prplEarNameSearch" class="codecode" style='width:60px'  maxlength=17   >
             	  <input type="button" value="查询" 
             	  onclick="code_CodeMultSelect(this, 'prpLRegistEarNoCheck1','30,-5,-4,-3,-2,1,15,-6,29,24,25,-1,31,2','name','multSelect','post','',8,38,'prplCompensateEarEarNo1');" 
             	 >
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:10%">农户代码</td>
              <td class="centertitle" style="width:18%">证件号码</td>
              <td class="centertitle" style="width:8%">姓名</td>
              <td class="centertitle" style="width:14%">开户行名称</td>
              <td class="centertitle" style="width:16%">银行账号</td>
              <td class="centertitle" style="width:19%">耳标号</td>
              <td class="centertitle" style="width:7%">定损金额</td>
              <td class="centertitle" style="width:2%">处理中</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr>
              <td class="title" colspan=8 style="width:96%">(按"+"号键增加财产核定损信息，按"-"号键删除信息)</td>
               <td class="title" align="right" style="width:4%">
                 <div align="center">
                   <input type="button" value="+" class="smallbutton" onclick="insertRow('Ear');" name="buttonDriverInsert" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          
          <tbody>
			<logic:notEmpty  name="prplCompensateEarDtoList"  > 
			<logic:iterate id="prplCompensateEarDto" name="prplCompensateEarDtoList">
              <tr>        
               <td class="input" style="width:10%">              
                  <input name="prplCompensateEarFCode" class=readonly readonly  style='width:100px'  maxlength=20  value="<bean:write name='prplCompensateEarDto' property='fcode'/>">
                </td>      
                <td class="input" style="width:18%">              
                  <input name="prplCompensateEarId_Card" class=readonly readonly style='width:150px'  maxlength=20 value="<bean:write name='prplCompensateEarDto' property='id_card'/>">
                </td>
                  <td class="input" style="width:8%">           
                  <input name="prplCompensateEarName" class=readonly readonly style='width:80px'  maxlength=50 value="<bean:write name='prplCompensateEarDto' property='name'/>">
                </td>
                 <td class="input" style="width:14%">         
                  <input name="prplCompensateEarBank" class=readonly readonly style='width:140px'  maxlength=50 value="<bean:write name='prplCompensateEarDto' property='bank'/>">
                </td>
                 <td class="input" style="width:16%">        
                  <input name="prplCompensateEarAccount"  class=readonly readonly style='width:180px'  maxlength=24 value="<bean:write name='prplCompensateEarDto' property='account'/>">
                </td>
          
                <td class="input" style="width:19%"> 
                 <input name="prplCompensateEarEarNo" class=readonly readonly style='width:70px'  maxlength=24 value="<bean:write name='prplCompensateEarDto' property='earno'/>"> 
                 <input name="prplCompensateEarEarNo1" class="codecode" style="width:60px<%=combineEarbackStyleO%>"  readonly="readonly" maxlength=17 value="<bean:write name='prplCompensateEarDto' property='earno'/>"
                   ondblclick="code_CodeSelect(this, 'prpLRegistEarNoCheck','30,-5,-4,-3,-2,1,15,-6,29,24,25,-1,31,2','name','select','post');"
			        onkeyup= "code_CodeSelect(this, 'prpLRegistEarNoCheck','30,-5,-4,-3,-2,1,15,-6,29,24,25,-1,31,2','name','select','post');"
			        onblur= "generateRegistText();copyEarlabel(this);" >
                </td>
                <td class="input" style="width:7%">  
					<input  name= "prplCompensateEarEstimateLoss" class="common" style="width:70px"  maxlength=17 value="<bean:write name='prplCompensateEarDto' property='estimateloss'/>" onBlur="formateEarEstimateLoss(this);">
                </td>
                <td class="input" style="width:2%">  
					<input  name= "prplCompensateEarInprocess" class=readonly readonly  style="width:20px"  maxlength=1 value="N">
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