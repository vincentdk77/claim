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

   <!--������ʾ��¼����������������ʾ��-->   
<script language='javascript'>  
 //��������뱾ҳ�Զ����JavaScript����
      /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertEar()
      {
       var countEar = getElementCount("prplCompensateEarEarNo");
       document.getElementsByName("prpLregistLossesNumber")[0].value = countEar -1;
       generateRegistText();
        //setPrpLpropSerialNo();
      } 
    
      /* 
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteEar(field)
      {    
       var countEar = getElementCount("prplCompensateEarEarNo");
       document.getElementsByName("prpLregistLossesNumber")[0].value = countEar -1;
       generateRegistText();
        //setPrpLpropSerialNo();
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
function copyEarlabel(field){
	var listFlag = fm.all("listFlag").value ;
	if(listFlag == "false")
 	  {
	 	   var earnos = document.getElementsByName("prplCompensateEarEarNo");
	 	   var count=getElementCount("prplCompensateEarEarNo");
	 	   earnos[getElementOrder(field)-1].value = field.value;
	 	   if(count == 2){alert("�ñ����޹����嵥�������¼��");}
 	  }
}
function generateRegistText(){
	if(getElementCount("prplCompensateEarEarNo")>1){
		var innerText = fm.all("prpLregistDamageStartDate").value+
		"����������ֳ��("+
		fm.all("prplCompensateEarName")[1].value+
		")�� "+
		fm.all("prpLregistLossesNumber").value+"ͷ"+
		fm.all("prpLregistLossName").value+"��"+
		fm.all("prpLregistDamageName").value+
		"������������";
		fm.all("prpLregistTextContextInnerHTML").innerHTML = innerText;
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
    prplCompensateEarEstimateLoss= parseFloat(fm.all("prplCompensateEarEstimateLoss")[findex].value);

    if(isNaN(prplCompensateEarEstimateLoss)||prplCompensateEarEstimateLoss.length<1){
      prplCompensateEarEstimateLoss = 0;
    }
    fm.all("prplCompensateEarEstimateLoss")[findex].value = point(round(prplCompensateEarEstimateLoss ,2),2);
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
        <%-- ��������չ���� --%>
        <table class="common"  id="Ear" cellpadding="8" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
             	  ������嵥				����ţ�
             	  <input name="prplEarEarNoSearch" class="codecode" style='width:60px'  maxlength=17   >
             	  ũ��������
             	  <input name="prplEarNameSearch" class="codecode" style='width:60px'  maxlength=17   >
             	  <input type="button" value="��ѯ" 
             	  onclick="code_CodeMultSelect(this, 'prpLRegistEarNoCheck1','30,-5,-4,-3,-2,1,15,-6,29,24,25,-1,31,2','name','multSelect','post','',8,38,'prplCompensateEarEarNo1');" 
             	 >
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:10%">ũ������</td>
              <td class="centertitle" style="width:18%">֤������</td>
              <td class="centertitle" style="width:8%">����</td>
              <td class="centertitle" style="width:14%">����������</td>
              <td class="centertitle" style="width:16%">�����˺�</td>
              <td class="centertitle" style="width:19%">�����</td>
              <td class="centertitle" style="width:7%">������</td>
              <td class="centertitle" style="width:2%">������</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          
          <tfoot>  
            <tr>
              <td class="title" colspan=8 style="width:96%">(��"+"�ż����ӲƲ��˶�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
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