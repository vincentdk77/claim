<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ ���� ]
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-05-12
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
 
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
       <td width="30%"> 
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr> 
              <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
              <td class="formtitle">Ԥ�����Ǽ�</td>
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
       <td><input type="button" name="message" value="��������" class="bigbutton" onclick="openWinSave()"></td><td><input type="button" name="messageView" value="�鿴����" class="bigbutton" onclick="openWinQuery()"></td><td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr> 
    <td class="title" colspan="4" style="width:100%">Ԥ�����Ǽ� 
      <input type="hidden" name="prpLprepayRiskCode" value="<bean:write name='prpLprepayDto' property='riskCode' />"> 
      <input type="hidden" name="prpLprepayOperatorCode" value="<bean:write name='prpLprepayDto' property='operatorCode' />"> 
      <input type="hidden" name="prpLprepayMakeCom" value="<bean:write name='prpLprepayDto' property='makeCom' />">	
      <input type="hidden" name="prpLprepayTypeForDriver" value="claim"> 
      <input type="hidden" name="prpLprepayInputDate" value="<bean:write name='prpLprepayDto' property='inputDate' />"> 
      <input type="hidden" name="prpLprepayLicenseColorCode" value="<bean:write name='prpLprepayDto' property='licenseColorCode' filter='true' />"> 
      <input type="hidden" name="prpLprepayCarKindCode" value="<bean:write name='prpLprepayDto' property='carKindCode' filter='true' />">
      <input type="hidden" name="prpLprepaySumPremium" value="<bean:write name='prpLprepayDto' property='sumPremium' filter='true' />">  

      <input type="hidden" name="prpLprepayPolicyCurrency"> 
      <input type="hidden" name="prpLprepayArrearageTimes" value="0"> 
      <input type="hidden" name="prpLprepaySumArrearage" value="0"> 
      <input type="hidden" name="prpLprepaySumBeforePrePaid"  value="0"> 
      <input type="hidden" name="prpLprepayBlockUpTimes"  value="0">       
      <input type="hidden" name="prpLprepaySumTotalPrepaid"  value="0">         
      <input type="hidden" name="prpLprepayApproverCode"> 
      <input type="hidden" name="prpLprepayUnderWriteCode"> 
      <input type="hidden" name="prpLprepayUnderWriteName"> 
      <input type="hidden" name="prpLprepayUnderWriteEndDate">    
      <input type="hidden" name="sumClaim"  value="<%= request.getAttribute("sumClaim") %>"> 
      <input type="hidden" name="percent"  value="<%= AppConfig.get("sysconst.PrepayPercent") %>"> 
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="<bean:write name='prpLprepayDto' property='underWriteFlag' filter='true' />"> 
      <input type="hidden" name="prpLprepayFlag" value="<bean:write name='prpLprepayDto' property='flag' filter='true' />"> 
     	<input type="hidden" name="prpLprepayComCode"  value = "<bean:write name='prpLprepayDto' property='comCode' filter='true' />"> 
    	<input type="hidden" name="prpLprepayHandler1Code" value="<bean:write name='prpLprepayDto' property='handler1Code' filter='true' />"> 
    
     
      <input type="hidden" name="prpLprepayClauseName" value="<bean:write name='prpLprepayDto' property='clauseName' filter='true' />">	  
     	<input type="hidden" name="prpLprepayStartDate" value="<bean:write name='prpLprepayDto' property='startDate' filter='true' /> �� 0 ʱ �� <bean:write name='prpLprepayDto' property='endDate' filter='true' /> �� 24 ʱֹ">
      <input type="hidden" name="prpLprepayLicenseNo" value="<bean:write name='prpLprepayDto' property='licenseNo' filter='true' />"> 
      <input type="hidden" name="prpLprepayLicenseColor" value="<bean:write name='prpLprepayDto' property='licenseColor' filter='true' />"> 
      <input type="hidden" name="prpLprepayCarKind" value="<bean:write name='prpLprepayDto' property='carKind' filter='true' />">  
      <input type="hidden" name="prpLprepayBrandName" value="<bean:write name='prpLprepayDto' property='brandName' filter='true' />"> 
      <input type="hidden" name="prpLprepayEngineNo" value="<bean:write name='prpLprepayDto' property='engineNo'/>"> 
      <input type="hidden" name="prpLprepayFrameNo" value="<bean:write name='prpLprepayDto' property='frameNo'/>"> 
      <input type="hidden" name="prpLprepayDamageStartDate" value="<bean:write name='prpLprepayDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLprepayDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLprepayDto' property='damageStartMinute' filter='true' /> ��">
      <input type="hidden" name="prpLprepayDamageAddress" value="<bean:write name='prpLprepayDto' property='damageAddress' filter='true' />"> 
      <input type="hidden" name="prpLprepaySumClaim" value="<bean:write name='prpLprepayDto' property='sumClaim' filter='true' />"> 
      <input type="hidden" name="prpLprepaySumAmount" value="<bean:write name='prpLprepayDto' property='sumAmount' filter='true' />"> 
     
    </td>
  </tr>
  <tr> 
    <td class="title"  style="width:15%"> Ԥ�����ţ�</td>
    <td class="input"  style="width:35%"> <input type=text name="prpLprepayPreCompensateNo" title="Ԥ������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='preCompensateNo' filter='true' />"> 
    </td>
    <td class="title"  style="width:15%"> �����ţ� </td>
    <td class="input"  style="width:35%"> <input type=text name="prpLprepayClaimNo" title="������" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLprepayDto' property='claimNo' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �����ţ� </td>
    <td class="input" colspan="3"> <input type=text name="prpLprepayPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLprepayDto' property='policyNo' filter='true' />"><input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.PolicyNo.value);"> 
    </td>
  </tr>      
  <tr> 
    <td class="title">�ұ� </td>
    <td class="input"> 
      <input name="prpLprepayCurrency" class="readonly" readonly  style="width:40px" value="<bean:write name='prpLprepayDto' property='currency' filter='true' />"> 
      <input name="prpLprepayCurrencyName" class="readonly" readonly style="width:100px" value="<bean:write name='prpLprepayDto' property='currencyName' filter='true' />">       
    </td>
    <td class="title"> Ԥ���</td>
    <td class="input"> 
    	<input name="prpLprepaySumPrePaid" type="text" class="readonly" readonly  style="width:130" value="<bean:write name='prpLprepayDto' property='sumPrePaid' filter='true' />"><img src="/claim/images/bgMarkMustInput.jpg"> 
    </td>
  </tr> 
  <tr> 
    <td class="title"> ҵ����������� </td>
    <td class="input"> 
      <input type=text   name="prpLprepayComName" class="readonly" readonly="true" value = "<bean:write name='prpLprepayDto' property='comName' filter='true' />"> 
    </td>
    <td class="title">����ҵ��Ա��</td>
    <td class="input"> 
      <input type=text   name="prpLprepayHandler1Name" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �����ˣ� </td>
    <td class="input"> 
      <input name="prpLprepayHandlerCode" class="readonly" readonly  style="width:90px" value="<bean:write name='prpLprepayDto' property='handlerCode' filter='true' />">
      <input name="prpLprepayHandlerName" class="readonly" readonly  style="width:120px" value="<bean:write name='prpLprepayDto' property='handlerName' filter='true' />"> 
    </td>
    <td class="title"> ͳ�����£�</td>
    <td class="input"> <input type="text" class="readonly" readonly  style="width:130" name="prpLprepayStatisticsYM" value="<bean:write name='prpLprepayDto' property='statisticsYM' filter='true' />">
			<img src="/claim/images/bgMarkMustInput.jpg">
    </td> 
  </tr>  
</table> 