<%--
****************************************************************************
* DESC       �������嵥ҳ��
* AUTHOR     �� =
* CREATEDATE �� 2011-08-25 
* MODIFYLIST ��   Name       Date            Reason/Contents
*               
****************************************************************************
--%> 

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
      /*start�ж϶���� addby �ž���*/
      function earnoCheck()
      {
    	  var policyno = fm.earPolicyNo.value; 
    	  var nodeType = fm.nodeType.value;  
    	  if(policyno!=null&&policyno == "")
          {
              alert("�ޱ�����");
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
              alert("���ִ���");
              return false;
          }
          var DamageStartDate = fm.DamageStartDate.value;
          if(DamageStartDate == null || trim(DamageStartDate).length != 10)
          {
              alert("��¼�����ʱ��");
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
			  alert("�޶��������");
			  return false;
		  }
	      var earnos = document.getElementsByName("prplCompensateEarEarNo");
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
		      		alert( "����ż�鲻ͨ��");
		      		return false;
		      }
	      }
	    var bool  = true;
	    bool = checkEarNoAndModify();
	    if( bool != true)
	    return false;
	    
	    setPrpLltextContext();
	    alert( "����ż��ͨ��");
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
             text = text + "����ţ�" + fm.all("prplCompensateEarEarNo")[i].value + " " + "�⸶���=" + fm.all("prplCompensateEarEstimateLoss")[i].value + "\r\n";
          }
          sumloss = sumloss.toFixed(2);//�޸����㻷�ڵ����㱨������ɵ������ֵ��
          text = text + "\r\n";
          text = text + "���⸶���=" + sumloss;
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
						fm.all("prplCompensateEarEarNo")[index].readOnly = "readonly";
					    fm.all("prplCompensateEarEarNo")[index].style.backgroundColor = "#CECECE";
						fm.all("illegalFlag")[index].value="false";
						alert( "��Ͷ���嵥�������¼��");
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
					 alert("��������ʧ�ܣ�");
					 return false;
				}
			//}
		}	
		return true;
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
    prplCompensateEarEstimateLoss= parseFloat(fm.all("prplCompensateEarEstimateLoss")[findex].value);

    if(isNaN(prplCompensateEarEstimateLoss)||prplCompensateEarEstimateLoss.length<1){
      prplCompensateEarEstimateLoss = 0;
    }
    fm.all("prplCompensateEarEstimateLoss")[findex].value = point(round(prplCompensateEarEstimateLoss ,2),2);
    return true;  
}

//ҳ��У�飺�����ݽ�������
function checkEarNoAndModify()
{
	var countEar = getElementCount("prplCompensateEarEarNo");
 	 var killQuantity = document.getElementsByName("prpLcompensateKillQuantity")[0].value;
	 var deathQuantity = document.getElementsByName("prpLcompensateDeathQuantity")[0].value;
     var lossNumber = document.getElementsByName("prpLcompensateLossesNumber")[0].value;
     var EstimateLoss = document.getElementsByName("prplCompensateEarEstimateLoss")[1].value;
     //modify by xiatian	��Ӹ������⳥����.
     if(lossNumber < 0 && EstimateLoss < 0){
	 	document.getElementsByName("prpLcompensateLossesNumber")[0].value = (countEar -1)*-1;
	 }
	 else{
	 	document.getElementsByName("prpLcompensateLossesNumber")[0].value = countEar -1;
	 	}

     if(Number(lossNumber) > Number(killQuantity) + Number(deathQuantity) )
     {
	   alert( "�⸶������Ӧ������ɱ��������������֮��");
	    return false;
     }
	//start������ֻ���
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
	alert( "�⸶��Ϣ�����ж�����¼����");
	return false;
	}	
	if(countEar >1){
		if(countProp < 2){ 
		alert( "������嵥�ǿ�ʱ�⸶��ĵ��⸶��Ϣ����Ϊ��");
		return false;}
		else
		{
			var sum = 0;
			for (var i = 1; i < countEar ;i++)
			{
			sum = sum + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss")[i].value);
			}
			sum = sum.toFixed(2);//������������ľ��Ȳ��������ύУ��
			if(sum != parseFloat(document.getElementsByName("prpLlossDtoSumRealPay")[1].value)){
			alert( "�⸶��Ϣ�����ڶ����⳥���֮��");
			return false;
			}
		}
	}
	return true;
}
//ҳ��У�飺��ʾ�û�
function checkEarNoAndPromote()
{
	var countEar = getElementCount("prplCompensateEarEarNo");
 	 var killQuantity = document.getElementsByName("prpLcompensateKillQuantity")[0].value;
	 var deathQuantity = document.getElementsByName("prpLcompensateDeathQuantity")[0].value;
     var lossNumber = document.getElementsByName("prpLcompensateLossesNumber")[0].value;
     if(isNaN(lossNumber))
	 {
	 		 alert( "�⸶������Ϊ����");
		     return false;
	 }
	 if(lossNumber > 0){
	     if(Number(lossNumber) != (countEar -1) )
	     {
		     alert( "�⸶���������ڶ�����嵥����");
		     return false;
	     }
     }
     else{
     	 if(Number(lossNumber) != (countEar -1)*-1 )
	     {
		     alert( "�⸶���������ڶ�����嵥����");
		     return false;
	     }
     }
     if(Number(lossNumber) > Number(killQuantity) + Number(deathQuantity) )
     {
	      alert( "�⸶������Ӧ������ɱ��������������֮��");
	     return false;
     }
	//start������ֻ���
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
	  		 alert( "���ջ�����Ϊ����");
		     return false;
	 }
	 if( Number(damageInsured) != newArray.length )
	     {
		     alert( "���ջ��δ���");
		     return false;
	     }
	var countProp = getElementCount("LossItemName");
	if(countProp > 2){ 
	alert( "�⸶��Ϣ�����ж�����¼����");
	return false;
	}
	
	if(countEar >1){
		if(countProp < 2){ 
		alert( "������嵥�ǿ�ʱ�⸶��ĵ��⸶��Ϣ����Ϊ��");
		return false;}
		else
		{
			var sum = 0;
			for (var i = 1; i < countEar ;i++)
			{
			sum = sum + parseFloat(document.getElementsByName("prplCompensateEarEstimateLoss")[i].value);
			}
			sum = sum.toFixed(2);//������������ľ��Ȳ��������ύУ��
			if(sum != parseFloat(document.getElementsByName("prpLlossDtoSumRealPay")[1].value)){
			alert( "�⸶��Ϣ�����ڶ����⳥���֮��");
			return false;
			}
		}
	}
	return true;
}
function checkEarBeforeSave(){
	var countEar = getElementCount("prplCompensateEarEarNo");
	if(countEar < 2){
	   alert( "������¼��һ���������Ϣ��");
       return false;
	}
	var illegalFlag = document.getElementsByName("illegalFlag");
	for(var index = 1 ;index < countEar ; index++)
	{
	   if(illegalFlag[index].value == "true")
	    {
    		alert( "��������");
    		return false;
	    }
	} 
	var bool = checkEarNoAndPromote();
	if ( bool != true)  
	{
   		alert( "��������");
   		return false;
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
        <%-- ��������չ���� --%>
        <table class="common"  id="Ear" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  ������嵥 
                <input type="button" align="right" name="checkEarno"  onclick="earnoCheck()"  value="�������֤" style="cursor: hand">
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:8%">ũ������</td>
              <td class="centertitle" style="width:18%">֤������</td>
              <td class="centertitle" style="width:12%">����</td>
              <td class="centertitle" style="width:16%">����������</td>
              <td class="centertitle" style="width:18%">�����˺�</td>
              <td class="centertitle" style="width:18%">�����</td>
              <td class="centertitle" style="width:12%">�⳥���</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr>
              <td class="title" colspan=7 style="width:96%">(��"+"�ż����ӲƲ��˶�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
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