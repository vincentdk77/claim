<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ �᰸ ]
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-28
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<% String dfFlag =(String) request.getAttribute("dfFlag");
if (dfFlag!=null && !dfFlag.equals("")&& dfFlag.equals("Y")){  %>
<input type="hidden" name="dfFlag" value="<%=dfFlag%>"> 

<%}else {%>
<input type="hidden" name="dfFlag" value="N"> 
<%}%>  

<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
  <tr>
    
      <%--modify by wangli update start 20050409 --%>
          <td><input type="button" name="prpLmessageSave" class=bigbutton value="׫д����" onclick="openWinSave(fm.prpLclaimRegistNo.value,fm.prpLclaimPolicyNo.value,fm.prpLclaimRegistNo.value,'endca',fm.prpLendcaseClaimNo1.value);"></td>
          <td><input type="button" name="prpLmessageView" class=bigbutton value="�鿴����" onClick="openWinQuery('registNo',fm.prpLclaimRegistNo.value);"></td>
    
     <%--modify by wangli update end 20050409 --%>
  </tr>
</table>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
     <%if (dfFlag!=null && !dfFlag.equals("")&& dfFlag.equals("Y")){  %>
    
     <td  colspan="4" style="width:100%">�᰸�Ǽ� (�渶���ȷ�) 
    <%}else {%>
    <td  colspan="4" style="width:100%">�᰸�Ǽ� 
    <%}%>
      <input type="hidden" name="prpLendcaseClaimNo1" value="<bean:write name='prpLclaimDto' property='claimNo'/>"> 
      <input type="hidden" name="prpLendcaseCertiNo" value=" "> 
      <input type="hidden" name="prpLendcaseCertiType" value="C"> 
      <input type="hidden" name="prpLendcaseFlag" value="1"> 
      <input type="hidden" name="prpLendcaseCaseNo" value="<bean:write name='prpLcaseNoDto' property='caseNo'/>"> 
     
     
      <%--resson: ����Ԥ��ź����������--%> 
      <input type="hidden" name="prpLendcasepreCompensateNo" value="<bean:write name='prpLcaseNoDto' property='preCompensateNo'/>">
      <input type="hidden" name="prpLendcasecompensateNo" value="<bean:write name='prpLcaseNoDto' property='compensateNo'/>">
      <%--modify by zhaozhuo add 20050331 end--%>
      <!--modify by qinyongli 2005-07-21 start ���ӱ����Ƿ��Ѿ�ʵ����Ϣ-->
      <logic:notEmpty name="premiumFee"  >
      <input type="hidden" name="premiumFee" value="<bean:write name='premiumFee'/>">
      </logic:notEmpty>
      <logic:empty name="premiumFee"  >
      <input type="hidden" name="premiumFee" value="1">
      </logic:empty>
      <!--modify by qinyongli 2005-07-21 end-->
    </td>
  </tr>
  <tr> 
    <td class="title"  >������:</td>
    <td class="input"  ><input type="text" name="prpLclaimClaimNo" title="������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimNo' filter='true'/>"> 
    </td>
    <td class="title" >��������:</td>
    <td class="input"  >       
      <logic:equal name="prpLclaimDto" property="LFlag" value="D">
        <input type="text" name="prpLendcaseLFlag" title="��������" maxlength="22" class="readonly" readonly="true"  value="������"> 
      </logic:equal>
      <logic:equal name="prpLclaimDto" property="LFlag" value="L">
        <input type="text" name="prpLendcaseLFlag" title="��������" maxlength="22" class="readonly" readonly="true"  value="����"> 
      </logic:equal>
    </td>
  </tr>
  <tr> 
    <td class="title"> ������:</td>
    <td class="input"> <input type="text" name="prpLclaimRegistNo" title="������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />"> 
    </td>
    <td class="title"> ������:</td>
    <td class="input"> 
      <input type="text" name="prpLclaimPolicyNo" style="width:150px" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />"> 
      <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate2();return false;">
    </td> 
  </tr>  
 <%--�˴�������ʾ�������˴���,�ҵ�������޷���ʾ������������,�ʴ˴���������
  <tr> 
    <td class="title">�������˴���:</td>
    <td class="input" colspan="3">  
    <logic:match name='prpLclaimDto' property="insuredCode" value="1" location="start">
    
      <a href='/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpDcustomerIdvCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
    </logic:match>  
    <logic:notMatch name='prpLclaimDto' property="insuredCode" value="1" location="start">
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
    <td class="title"> �����ڼ䣺</td>
    <td class="input" colspan="3"> <input type="text" name="prpLendcaseStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' /> �� 0 ʱ �� <bean:write name='prpLclaimDto' property='endDate' filter='true' /> �� 24 ʱֹ">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> �������</td>
    <td class="input" colspan="3">     
      <input class="readonly" type=text name="prpLclaimClauseType" readonly="true"  style="width:30px" value="<bean:write name='prpLclaimDto' property='clauseType' filter='true' />">
  
      <input class="readonly" type=text name="prpLclaimClauseName" readonly="true"  style="width:300px"value="<bean:write name='prpLclaimDto' property='clauseName' filter='true' />">      
    </td>
  </tr>
 
  <tr> 
    <td class="title"> ���ƺ���:</td>
    <td class="input"> <input class="readonly" name="prpLclaimLicenseNo" style="width:90px" readonly="true" value="<bean:write name='prpLclaimDto' property='licenseNo' filter='true' />">
    </td>
    <td class="title"> ���Ƶ�ɫ: </td>
    <td class="input"> <input class="readonly"  name="prpLclaimLicenseColor" readonly="true" value="<bean:write name='prpLclaimDto' property='licenseColor' filter='true' />">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> �����ͺ�:</td>
    <td class="input"> <input class="readonly" name="prpLclaimBrandName" readonly="true" value="<bean:write name='prpLclaimDto' property='brandName' filter='true' />">
    </td>
    <td class="title"> ��������: </td>
    <td class="input"> <input name="prpLclaimCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='carKind' filter='true' />">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> �ұ�:</td>
    <td class="input"> <input class="readonly" readonly name="prpLclaimCurrencyName" value="�����">
    </td>
    <td class="title"> ���ս��: </td>
    <td class="input"> <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format='##0.00'/>">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> ����ʱ��:</td>
    <td class="input"> 
      <input type=text name="prpLendcaseDamageStartDate" readonly="true" class="readonly"  style="width:180px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLclaimDto' property='damageStartHour' filter='true' /> ʱ">
    </td>
    <td class="title"> �¹�ԭ��</td>
    <td class="input"> 
      <input type=text class="readonly" readonly="true" name="prpLclaimDamageTypeName"  title="�¹�ԭ��" value="<bean:write name='prpLclaimDto' property='damageTypeName' filter='true'/>">
    </td>
  </tr>
 
  <tr> 
    <td class="title"> ����ԭ��:</td>
    <td class="input"> <input type="text" name="prpLclaimDamageName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"> 
    </td>
    <td class="title"> �������� </td>
    <td class="input"> <input type="text" name="prpLclaimDamageAreaName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageAreaName' filter='true' />"> 
    </td>
  </tr>
 
  <tr> 
    <td class="title"> ���յص㣺</td>
    <td class="input"> <input type="text" name="prpLclaimDamageAddress"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"> 
    </td>
    <td class="title"> ��������: </td>
    <td class="input"> <input type="text" name="prpLclaimClaimDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimDate' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �¹����Σ�</td>
    <td class="input"> <input type="text" name="prpLclaimIndemnityDutyName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='indemnityDutyName' filter='true' />"> 
    </td>
    <td class="title"> ���α����� </td>
    <td class="input"> <input type="text" name="prpLclaimIndemnityDutyRate"  style="width:80px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='indemnityDutyRate' filter='true' format='##0.0000'/>">% 
    </td>
  </tr>
  <tr> 
    <td class="title"> ������ʧ��</td>
    <td class="input"> <input type="text" name="prpLclaimSumClaim"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format='##0.00'/>"> 
    </td>
    <td class="title"> �ⰸ��� </td>
    <td class="input"> <input type="text" name="prpLclaimClaimTypeName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='claimTypeName' filter='true' />"> 
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
    <td class="title"> �����ˣ�</td>
    <td class="input"> <input type="text" name="prpLclaimHandlerName"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handlerName' filter='true' />"> 
    </td>
    <td class="title"> �⸶�� </td>
    <td class="input"> <input type="text" name="prpLclaimSumPaid"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPaid' filter='true' format='##0.00'/>"> 
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
    <td class="input"> <input type="text" name="prpLclaimInputDate"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='inputDate' filter='true' />"> 
    </td>
    <td class="title"> ��������: </td>
    <td class="input"> <input type="text" name="prpLclaimCaseType"  style="width:180px" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='caseType' filter='true' />"> 
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
