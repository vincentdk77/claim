<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ �᰸ ]
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-28
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
            <td class="formtitle">�᰸�Ǽ�</td>
            <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table>
     </td>
          <td><input type="button" name="prpLmessageSave" value="������ϵ��¼" class="bigbutton" onclick="openWinSave1();return false;"></td>
     <td><input type="button" name="prpLmessageView" class="bigbutton" value="�鿴������ϵ��¼" onClick="openWinQuery('registNo',fm.prpLclaimRegistNo.value);return false;"></td>
     <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
    Ϊ˫��ѡ���</font></td> 
  </tr> 
</table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr> 
    <td class="title" colspan="2" style="width:100%">�᰸�Ǽ� 
      <input type="hidden" name="prpLendcaseClaimNo1" value="<bean:write name='prpLclaimDto' property='claimNo'/>"> 
      <input type="hidden" name="prpLendcaseCertiNo" value=" "> 
      <input type="hidden" name="prpLendcaseCertiType" value="C"> 
      <input type="hidden" name="prpLendcaseFlag" value="1"> 
      <input type="hidden" name="prpLendcaseCaseNo" value="<bean:write name='prpLcaseNoDto' property='caseNo'/>"> 
    </td>
     <td class="title">��������:</td>
    <td class="title"><%= request.getAttribute("riskCName") %></td>
  </tr>
  <tr> 
    <td class="title"  style="width:15%">������:</td>
    <td class="input"  style="width:35%"><input type="text" name="prpLclaimClaimNo" title="������" class="readonly" style="width:160px" readonly="true" value="<bean:write name='prpLclaimDto' property='claimNo' filter='true'/>"> 
    </td>
    <td class="title"  style="width:15%">��������:</td>
    <td class="input"  style="width:35%">       
      <logic:equal name="prpLclaimDto" property="LFlag" value="D">
        <input type="text" name="prpLendcaseLFlag" title="��������" style="width:160px" class="readonly" readonly="true"  value="������"> 
      </logic:equal>
      <logic:equal name="prpLclaimDto" property="LFlag" value="L">
        <input type="text" name="prpLendcaseLFlag" title="��������" style="width:160px" class="readonly" readonly="true"  value="����"> 
      </logic:equal>
    </td>
  </tr>
  
   <!--modify by qinyongli 2005-07-21 start ���ӱ����Ƿ��Ѿ�ʵ����Ϣ-->
      <logic:notEmpty name="premiumFee"  >
      <input type="hidden" name="premiumFee" value="<bean:write name='premiumFee'/>">
      </logic:notEmpty>
      <logic:empty name="premiumFee"  >
      <input type="hidden" name="premiumFee" value="1">
      </logic:empty>
      <!--modify by qinyongli 2005-07-21 end-->
  <tr> 
    <td class="title"> ������:</td>
    <td class="input"> <input type="text" name="prpLclaimRegistNo"  class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />"> 
    </td> 
    <td class="title"> ������:</td>
    <td class="input"> 
      <input type="text" name="prpLclaimPolicyNo" class="readonly" readonly="true" style="width:150px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
      <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLclaimPolicyNo.value, fm.prpLclaimRegistNo.value);return false;">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> ҵ�����ʣ�</td>
    <td class="input"> <input type="text" name="prpLclaimBusinessNatureName"  class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='businessNature' filter='true' />"> 
    </td> 
    <td class="title"> ���֣�</td>
    <td class="input"> <input type="text" name="prpLclaimLanguageName" class="readonly" readonly="true" style="width:160px" value="<bean:write name='prpLclaimDto' property='language' filter='true' />">
    </td>
  </tr>
  <%--
  <tr>   
    <td class="title">�������˴���:</td>
    <td class="input" colspan="3">  
    <logic:match name='prpLclaimDto' property="insuredCode" value="0" location="start">
      <a href='/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpDcustomerIdvCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
    </logic:match>  
    <logic:notMatch name='prpLclaimDto' property="insuredCode" value="0" location="start">
      <a href='/claim/processPrpDcustomerUnit.do?actionType=prepareUpdate&prpDcustomerUnitCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
    </logic:notMatch>
    <input type=hidden name="prpLregistInsuredCode" title="�������˴���" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">  
    <bean:write name='prpLclaimDto' property='insuredCode' filter='true' />
      </a>
    </td>
    <!--
    <td class="title"> �������˴���:</td>
    <td class="input" colspan="3"> 
      <input type="text" name="prpLclaimInsuredCode" title="��������" style="width:120px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">
      
    </td>
    -->
  </tr>
  --%>
  <tr> 
    <td class="title"> ������������:</td>
    <td class="input" colspan="3"> 
      <input type="text" name="prpLclaimInsuredName" title="��������" style="width:330px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">
    </td>
  </tr>
  <tr> 
    <td class="title"> �����ڼ䣺</td>
    <td class="input" colspan="3"> <input type="text" name="prpLendcaseStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' /> �� 0 ʱ �� <bean:write name='prpLclaimDto' property='endDate' filter='true' /> �� 24 ʱֹ">
    </td>
  </tr>
  
  <tr> 
    <td class="title"> �ұ�</td>
    <td class="title">
      <input type="text" name="prpLclaimCurrency" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='currency' filter='true' />">
    </td>
    <td class="title"> ���ս�</td>
    <td class="input"> <input type="text" name="prpLclaimSumAmount" class="readonly" style="width:160px" readonly="true"  value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format="##0.00"/>">
    </td>
  </tr>
      
  <tr> 
    <td class="title"> ����ʱ�䣺</td>
    <td class="title" colspan="3">
      <input type=text name="prpLendcaseDamageStartDate" title="����ʱ��" readonly="true" class="readonly"  style="width:380px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLclaimDto' property='damageStartHour' filter='true' /> ʱ">
    </td>
  </tr>     
  <tr> 
    <td class="title"> ����ԭ��</td>
    <td class="title" colspan="3">
      <input type="text" name="prpLclaimDamageName"  style="width:380px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"> 
    </td>
  </tr>     
  <tr> 
    <td class="title"> ���յص�:</td>
    <td class="title" colspan="3">
      <input type="text" name="prpLclaimDamageAddress"  style="width:380px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>    
  <tr> 
    <td class="title"> �����ģ�</td>
    <td class="title" colspan="3">
      <input type="text" name="prpLclaimLossName"  style="width:380px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='lossName' filter='true' />"> 
    </td>
  </tr>    
  <tr> 
    <td class="title"> �������ڣ�</td>
    <td class="title" colspan="3">
      <input type="text" name="prpLclaimClaimDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimDate' filter='true' />"> 
    </td>
  </tr>  
    
  <tr> 
    <td class="title"> �����<input type="text" name="prpLclaimCurrency" style="width:30px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='currency' filter='true' />"></td>
    <td class="title">
      <input type="text" name="prpLclaimSumClaim"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format="##0.00" />"> 
    </td>
    <td class="title">�⸶��<input type="text" name="prpLclaimCurrency" style="width:30px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='currency' filter='true' />"></td>
    <td class="input"><input type="text" name="prpLclaimSumPaid"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPaid' filter='true' format="##0.00" />"> 
    </td>
  </tr>  
  <tr> 
    <td class="title"> ����ҵ��������ţ�</td>
    <td class="input"> <input type="text" name="prpLclaimComName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='comName' filter='true' />"> 
    </td>
    <td class="title"> ����ҵ��Ա�� </td>
    <td class="input"> <input type="text" name="prpLclaimHandler1Name"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>   
  <tr> 
    <td class="title"> �����ˣ� </td>
    <td class="input"> <input type="text" name="prpLclaimAgentCode"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='agentCode' filter='true' />"> 
    </td>
    <td class="title"> �����ˣ�</td>
    <td class="input"> <input type="text" name="prpLclaimHandlerName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handlerName' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ���ⲿ�ţ�</td>
    <td class="input"> <input type="text" name="prpLendcaseMakeCom"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='makeComName' filter='true' />"> 
    </td>
    <td class="title"> ����Ա�� </td>
    <td class="input"> <input type="text" name="prpLregistOperatorName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='operatorName' filter='true' />">
    </td>
  </tr>
  <tr> 
    <td class="title"> �䵥���ڣ�</td>
    <td class="input" colspan="3"> <input type="text" name="prpLclaimInputDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='inputDate' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �᰸���ڣ�</td>
    <td class="input"> <input type="text" name="prpLclaimEndCaseDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='endCaseDate' filter='true' />"> 
    </td>
    <td class="title"> �᰸Ա�� </td>
    <td class="input"> <input type="text" name="prpLclaimEndCaserCode"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='endCaserCode' filter='true' />"> 
    </td> 
  </tr>
  <tr> 
    <td class="title"> ע�����ڣ�</td>
    <td class="input"> <input type="text" name="prpLclaimCancelDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='cancelDate' filter='true' />"> 
    </td>
    <td class="title"> ע����:</td>
    <td class="input"> <input type="text" name="prpLclaimDealerCode"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='dealerCode' filter='true' />"> 
    </td>
  </tr> 
</table>
