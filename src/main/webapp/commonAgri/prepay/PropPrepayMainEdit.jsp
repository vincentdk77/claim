<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��[ ���� ]
* AUTHOR     :liubvo
* CREATEDATE :2004-10-11
* MODIFYLIST :  Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<script language="javascript">  
    function OpenWinSave()
    {
      var policyNo = fm.prpLprepayPolicyNo.value;
      var riskCode = fm.prpLprepayRiskCode.value;
      var businessNo = fm.prpLprepayClaimNo.value;
      var claimNo = fm.prpLprepayClaimNo.value;
      msg=window.open("/claim/messageQueryInfo.do?businessNo=" +businessNo+ "&nodeType=prepa&policyNo=" +policyNo+ "&riskCode=" +riskCode+ "&claimNo=" +claimNo,"NewWindow","toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no,width=500,Height=300");
    }
    
</script>    
    
    
    
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
       <td><input type="button" name="message" value="��������" class="bigbutton" onclick="OpenWinSave(fm.prpLprepayClaimNo.value,fm.prpLprepayPolicyNo.value,fm.prpLprepayRiskCode.value,'prepa',fm.prpLprepayClaimNo.value)"></td><td><input type="button" name="messageView" value="�鿴����" class="bigbutton" onclick="openWinQuery('claimNo',fm.prpLprepayClaimNo.value)"></td><td width="70%" align="right"><font color="#666666">��ע:��<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>
<table id="Area" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr> 
    <td class="title" colspan="4" style="width:100%">Ԥ�����Ǽ� 
      <input type="hidden" name="prpLprepayRiskCode" value="<bean:write name='prpLprepayDto' property='riskCode' />"> 
      <input type="hidden" name="prpLprepayOperatorCode" value="<bean:write name='prpLprepayDto' property='operatorCode' />"> 
      <input type="hidden" name="prpLprepayMakeCom" value="<bean:write name='prpLprepayDto' property='makeCom' />">	
      <input type="hidden" name="prpLprepayInputDate" value="<bean:write name='prpLprepayDto' property='inputDate' />"> 
      <input type="hidden" name="prpLprepayLicenseColorCode" value="<bean:write name='prpLprepayDto' property='licenseColorCode' filter='true' />"> 
      <input type="hidden" name="prpLprepayCarKindCode" value="<bean:write name='prpLprepayDto' property='carKindCode' filter='true' />">
      <input type="hidden" name="prpLprepaySumPremium" value="<bean:write name='prpLprepayDto' property='sumPremium' filter='true' />">  
      <input type="hidden" name="prpLprepayArrearageTimes" value="<bean:write name='prpLprepayDto' property='arrearageTimes' filter='true' />"> 
      <input type="hidden" name="prpLprepaySumArrearage" value="<bean:write name='prpLprepayDto' property='sumArrearage' filter='true' />"> 
      <input type="hidden" name="prpLprepaySumBeforePrePaid" value="<bean:write name='prpLprepayDto' property='sumBeforePrePaid' filter='true' />"> 
      <input type="hidden" name="prpLprepayBlockUpTimes" value="<bean:write name='prpLprepayDto' property='blockUpTimes' filter='true' />">       
      <input type="hidden" name="prpLprepaySumTotalPrepaid" value="<bean:write name='prpLprepayDto' property='sumTotalPrepaid' filter='true' />">         
      <input type="hidden" name="prpLprepayApproverCode" value="<bean:write name='prpLprepayDto' property='approverCode' filter='true' />"> 
      <input type="hidden" name="prpLprepayUnderWriteCode" value="<bean:write name='prpLprepayDto' property='underWriteCode' filter='true' />">  
      <input type="hidden" name="prpLprepayUnderWriteName" value="<bean:write name='prpLprepayDto' property='underWriteName' filter='true' />"> 
      <input type="hidden" name="prpLprepayUnderWriteEndDate" value="<bean:write name='prpLprepayDto' property='underWriteEndDate' filter='true' />">    
      <input type="hidden" name="sumClaim"  value="<%= request.getAttribute("sumClaim") %>">  
      <input type="hidden" name="percent"  value="<%= AppConfig.get("sysconst.PrepayPercent") %>"> 
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="<bean:write name='prpLprepayDto' property='underWriteFlag' filter='true' />"> 
      <input type="hidden" name="prpLprepayFlag" value="<bean:write name='prpLprepayDto' property='flag' filter='true' />"> 
     	<input type="hidden" name="prpLprepayComCode"  value = "<bean:write name='prpLprepayDto' property='comCode' filter='true' />"> 
    	<input type="hidden" name="prpLprepayHandler1Code" value="<bean:write name='prpLprepayDto' property='handler1Code' filter='true' />"> 
       <input type="hidden" name="prpLprepayCaseType" value="<%= request.getParameter("caseType") %>">
     
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
      <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
      <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
       <!--modify by qinyongli 2005-07-21 start ���ӱ����Ƿ��Ѿ�ʵ����Ϣ-->
      <logic:notEmpty name="prePayFlag"  >
      <input type="hidden" name="prePayFlag" value="<bean:write name='prePayFlag'/>">
      </logic:notEmpty>
      <logic:empty name="prePayFlag"  >
      <input type="hidden" name="prePayFlag" value="1">
      </logic:empty>
      <!--modify by qinyongli 2005-07-21 end-->	
    </td>
  </tr>
  <tr> 
    <td class="title"  style="width:15%"> Ԥ������:</td>
    <td class="input"  style="width:36%"> <input type=text name="prpLprepayPreCompensateNo" title="Ԥ������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='preCompensateNo' filter='true' />"> 
    </td>
    <td class="title"  style="width:15%"> ������:</td>
    <td class="input"  style="width:34%"> <input type=text name="prpLprepayClaimNo" title="������" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLprepayDto' property='claimNo' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ������:</td>
    <td class="input"> <input type=text name="prpLprepayPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLprepayDto' property='policyNo' filter='true' />">
       <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLprepayPolicyNo.value);return false;"> 
    </td>
    
    <td class="title" style="width:15%">�ѳ��մ���:</td>
    <td class="input" style="width:35%">
      <%-- ������Ϣ���� --%>
           <%@include file="/commonProp/prepay/PropExistRegist.jsp"%>     
    </td>
  </tr>      
  <tr> 
    <td class="title">�ұ�:</td>
    <td class="input"> 
      <input name="prpLprepayCurrency" class="codecode" style="width:40%" value="<bean:write name='prpLprepayDto' property='currency' filter='true' />"
          ondblclick="code_CodeSelect(this, 'Currency');"
          onkeyup= "code_CodeSelect(this, 'Currency');"> 
      <input name="prpLprepayCurrencyName" class="codename" style="width:40%" value="<bean:write name='prpLprepayDto' property='currencyName' filter='true' />"
         ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
         onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">       
    </td>
    <td class="title"> Ԥ����:</td>
    <td class="input"> 
    	<input name="prpLprepaySumPrePaid" type="text" class="input" style="width:130" value="<bean:write name='prpLprepayDto' property='sumPrePaid' filter='true' format='##0.00'/>"><img src="/claim/images/bgMarkMustInput.jpg"> 
    </td>
  </tr> 
  <tr> 
    <td class="title"> ҵ���������:</td>
    <td class="input"> 
      <input type=text   name="prpLprepayComName" title="ҵ���������" class="readonly" readonly="true" value = "<bean:write name='prpLprepayDto' property='comName' filter='true' />"> 
    </td>
    <td class="title">����ҵ��Ա:</td>
    <td class="input"> 
      <input type=text   name="prpLprepayHandler1Name" title="����ҵ��Ա" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ������:</td>
    <td class="input"> 
     <input type=text name="prpLprepayHandlerCode" class="codecode" style="width:40%" value="<bean:write name='prpLprepayDto' property='handlerCode' filter='true' />"
          ondblclick="code_CodeSelect(this, 'HanderCode');"
          onkeyup= "code_CodeSelect(this, 'HanderCode');"> <input type=text name="prpLprepayHandlerName" class="codename" style="width:50%"  title="������" value="<bean:write name='prpLprepayDto' property='handlerName' filter='true' />"
         ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
         onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');"> 
    </td>
    <td class="title"> ͳ������:</td>
    <td class="input"> <input type="text" class="input" style="width:130" name="prpLprepayStatisticsYM" value="<bean:write name='prpLprepayDto' property='statisticsYM' filter='true' />">
			<img src="/claim/images/bgMarkMustInput.jpg">
    </td> 
  </tr>  
</table> 
 