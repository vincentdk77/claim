<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��Tail[ ʵ�� ]
* AUTHOR     :liubvo
* CREATEDATE :2004-05-12
* MODIFYLIST :  Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr> 
    <td class="title"  style="width:15%">������:</td>
    <td class="input"  style="width:35%"> 
      <input class="readonly" readonly  name="MergeCurrency" value="<bean:write name='prpLcompensateDto' property='currency' />" style="width:60px">&nbsp;<input class="readonly" readonly  name="MergeCurrencyName" value="<bean:write name='prpLcompensateDto' property='currencyName' />" style="width:120px"> 
     
      </td> 
      <td class="title"  style="width:50%" colspan="2"><input type="hidden" class="bigbutton" name="btnCurrencyTotle" value="�ֱұ����" onclick="alert('�ֱұ����');"></td>
  </tr>
  <tr> 
    <td class="title"  style="width:15%"> �����:</td>
    <td class="input"  style="width:35%"> <input class="readonly" type=text name="prpLcompensateSumDutyPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumDutyPaid' filter='true' format='##0.00'/>">  
    </td>
    <td class="title"  style="width:15%"> ��������:</td>
    <td class="input"  style="width:35%"> <input type=text name="prpLcompensateSumNoDutyFee" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='sumNoDutyFee' filter='true'  format='##0.00'/>"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> ���ϼ�:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateSumPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true'  format='##0.00'/>">  
    </td>
    <td class="title"> ��Ԥ�����:</td>
    <td class="input"> <input type=text name="prpLcompensateSumPrePaid" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='sumPrePaid' filter='true'  format='##0.00'/>"> 
    </td>
  </tr> 
  <tr>
  	 <td class="title"> ��Ԥ������:</td>
    <td class="input" colspan="3"> 
    	<input class="readonly" type=text name="prpLcompensatePreSumChargePaid" readonly="true"  style="width:150px"value="<bean:write name='prpLcompensateDto' property='sumPreChargeAmount' filter='true'  format='##0.00'/>">  
    </td>
  </tr>
  <tr> 
    <td class="title"> �����⸶���:</td>
    <td class="input" colspan=3> <input class="readonly" type=text name="prpLcompensateSumThisPaid" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumThisPaid' filter='true'  format='##0.00'/>">  
    </td>
    <td class="title" style="display:none"> ��ֵ:</td>
    <td class="input" style="display:none"> <input class="readonly" type=text readonly="true"  style="width:150px" name="prpLcompensateSumRest" value="<bean:write name='prpLcompensateDto' property='sumRest' format='##0.00'/>"> 
    </td>
   
  </tr>
  
  <tr> 
    <td class="title"> ҵ�񾭰���:</td>
    <td class="input"  >  
      <input name="prpLcompensateHandlerCode" class="readonly" readonly=true style="width:40%" value="<bean:write name='prpLcompensateDto' property='handlerCode' filter='true' />"
          ondblclick="code_CodeSelect(this, 'HanderCode');"
          onkeyup= "code_CodeSelect(this, 'HanderCode');"> <input name="prpLcompensateHandlerName" class="readonly" readonly=true style="width:50%"  title="������" value="<bean:write name='prpLcompensateDto' property='handlerName' filter='true' />"
         ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
         onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');"> 
    </td>
   
    <td class="title"> ��������:</td>
    <td class="input"> <input type="text" class="readonly" readonly=true  style="width:110" name="prpLcompensateStatisticsYM" value="<bean:write name='prpLcompensateDto' property='statisticsYM' filter='true' />">
   </tr> 
   <logic:equal value="1" name="prpLcompensateDto" property="underWriteFlag">
	   <tr>
	    <td class="title"> ���պ�����:</td>
	    <td class="input"  >
	      <input name="prpLcompensateUnderWriteName" class="codename" style="width:50%"  title="���պ�����" readonly="true"
	         value="<bean:write name='prpLcompensateDto' property='underWriteName' filter='true' />">
	    </td>
	
	    <td class="title"> ����ͨ������:</td>
	    <td class="input"> <input type="text" class="common"  readonly="true" style="width:110" name="prpLcompensateUnderWriteEndDate" 
	    	value="<bean:write name='prpLcompensateDto' property='underWriteEndDate' filter='true' />">
	   </tr>
	</logic:equal>
 <tr> 
    <td class="title"> ��ע:</td>
    <td class="input" colspan="3"> <input class="input" type=text name="prpLcompensateRemark"  maxLength="255" onblur="checkLength1(this);" description="��ע" value="<bean:write name='prpLcompensateDto' property='remark' filter='true' />">  
    </td>
  </tr>
    <input type="hidden" name="prpLcompensateChecker1" value="<bean:write name='prpLcompensateDto' property='checker1' filter='true' />"> 
</table> 
