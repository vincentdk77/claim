<%--
****************************************************************************
* DESC       ���Ʋ���ʧ�嵥ҳ��
* AUTHOR     �� �ž���
* CREATEDATE �� 2004-07-13 
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@page import="java.util.ArrayList" %>
<!--������ʾ��¼����������������ʾ��-->   
<script language='javascript'>  
 //��������뱾ҳ�Զ����JavaScript����
      /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertEar()
      {
       // setPrpLpropSerialNo();
      } 
    
      /* 
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteEar(field)
      {    
       // setPrpLpropSerialNo();
      }
    
      /**
       * ����setPrpLpropSerialNo
       */
      function setPrpLpropSerialNo(){
          var count=getElementCount("prpLpropSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("����ʲôʱ������?count="+count+"  i="+i); 
              if(count!=1){
                fm.prpLpropSerialNo[i].value=i;
              }
          }
      }
      //У������嵥������ݸ�ʽ
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
      /*start�ж϶���� addby �ž���*/
      function earnoCheck(combineIndex)
      {
    	  var policyno = fm.policyno.value; 
    	  var nodeType = fm.nodeType.value;
    	  if(policyno!=null&&policyno == "")
          {
              alert("�ޱ�����");
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
			  alert("����Ľڵ����ͣ�"+nodeType);
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
              alert("���ִ���");
              return false;
          }
          if(DamageStartDate == null || trim(DamageStartDate).length != 10)
          {
              alert("��¼�����ʱ��");
              return false;
          }
          
          if(DamageStartHour == null || trim(DamageStartHour).length == 0)
          {
              DamageStartHour = "00";
          }
		  var count = getElementCount("prplCompensateEarEarNo_"+combineIndex);
		  if (count == 1)
		  {
			  alert("�����ţ�"+fm.all("combineRegistNo")[combineIndex]+"�޶��������");
			  return false;
		  }
	      var earnos = document.getElementsByName("prplCompensateEarEarNo_"+combineIndex);
	      for(var index =0 ;index < count ; index++)
	      {
		      if (index ==0) continue;
		      if(trim(earnos[index].value).length == 0)
		      {
		      	alert("����Ų���Ϊ��");
		      	return false;
		      }
		      var i =index;
		      i++;
		      while(i < count)
		      {
			      if(earnos[index].value == earnos[i].value)
			      {
			      alert("����Ų����ظ�");
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
		      		alert( "����ż�鲻ͨ��");
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
		    	 alert("�����������֧�֣�");
				 return false;}
		    }
		 }
		 else
			{
				 alert("�����������֧�֣�");
				 return false;
			}
		 
		 if(req){
			     req.open("GET",url,false);
				 req.send(null); 
			    // req.onreadystatechange = function(){
				if (req.readyState == 4 && req.status == 200) {  
					var xmlDoc = req.responseXML;
					//start�쳣����
					var userException = xmlDoc.getElementsByTagName("userException");  
					if(userException.length > 0){ 
						var userExceptionChildNodes = userException[0].childNodes; 
						alert( "userException:"+userExceptionChildNodes[3].text + ":����ϵ����Ա");
						return false;
					}
					var exception = xmlDoc.getElementsByTagName("exception");  
					if(exception.length > 0){ 
						var exceptionChildNodes = exception[0].childNodes; 
						alert( "CLASSNAME��"+exceptionChildNodes[0].text + ":����ϵ����Ա");
						return false;
					}
					//end�쳣����
					var insureMainList = xmlDoc.getElementsByTagName("insureMainList");  
					if(insureMainList.length == 0){ 
						fm.all("prplCompensateEarEarNo_"+combineIndex)[index].readOnly = "readonly";
					    fm.all("prplCompensateEarEarNo_"+combineIndex)[index].style.backgroundColor = "#CECECE";
						fm.all("illegalFlag_"+combineIndex)[index].value="false";
						//alert( "��Ͷ���嵥�������¼��");
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
					 alert("��������ʧ�ܣ�");
					 return false;
				}
			//}
		}	
		return true;
	}


//ҳ��У�飺��ʾ�û�
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
			 //alert( "�⸶���������ڶ�����嵥����");
			 //alert( "�⸶������Ӧ������ɱ��������������֮��");
		}
	 }

	//start������ֻ���
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
	  		damageInsured.value = newArray.length ;//alert( "���ջ�����Ϊ����");
	 }
	 
	var countProp = getElementCount("prpLclaimAcciPersonFamilyNo_"+combineIndex);
	if(countProp > 2){ 
		alert( "�ձ��������Ϣ�����ж�����¼");
		return false;
	}
	
	if(countEar >1){
		if(countProp < 2){
			alert( "������嵥�ǿ�ʱ�ձ��������Ϣ����Ϊ��");//????????????????????????????????
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
					if("P"==prpLclaimLossLossFeeType){//P��ʾ�����Ϊ���
						var elePrpLclaimLossSumClaim = document.getElementsByName("prpLclaimLossSumClaim_"+combineIndex)[index];
						sumPrpLclaimLossSumClaim = parseFloat(sumPrpLclaimLossSumClaim) + parseFloat(elePrpLclaimLossSumClaim.value);
					}
				}
			}
			if(sum != parseFloat(sumPrpLclaimLossSumClaim)){
			document.getElementsByName("prpLclaimLossSumClaim_"+combineIndex)[1].value = sum;
			//alert( "Ԥ�Ƹ��������������ڶ��궨����֮��");
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
			   		alert( "�����У��ʧ�ܣ�");
			   		return false;
			    }
				//else break;
		    }
		}
		var bool = checkEarNoAndPromote(combineIndex);
		if ( bool != true)
		{
	   		alert( "�����У��ʧ�ܣ�");
	   		return false;
	    }
    }
	return true;
}
</script>
<% String combineEarbackReadOnlyO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String combineEarbackDiasableO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String combineEarbackStyleO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
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
        <%-- ��������չ���� --%>
        <table class="common"  id="Ear_<%=indexClaimEarNo %>" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  ������嵥 
                <!-- <input type="button" align="right" name="checkEarno"  onclick="checkEarBeforeSave()"  value="�������֤" style="cursor: hand">   -->
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:8%">ũ������</td>
              <td class="centertitle" style="width:18%">֤������</td>
              <td class="centertitle" style="width:8%">����</td>
              <td class="centertitle" style="width:16%">����������</td>
              <td class="centertitle" style="width:18%">�����˺�</td>
              <td class="centertitle" style="width:18%">�����</td>
              <td class="centertitle" style="width:12%">������</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr>
              <td class="title" colspan=7 style="width:96%">(��"+"�ż����ӲƲ��˶�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
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