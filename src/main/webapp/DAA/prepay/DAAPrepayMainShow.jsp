<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ ���� ]
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-05-12
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
    <table cellpadding="5" cellspacing="1" class="common">
    <tr>
       
       <%--modify by wangli update start 20050409--%>
       <td><input type="button" class=bigbutton name="message" value="��������" onclick="openWinSave(fm.prpLprepayClaimNo.value,fm.prpLprepayPolicyNo.value,fm.prpLprepayRiskCode.value,'prepa',fm.prpLprepayClaimNo.value)"></td>
       <td><input type="button" class=bigbutton name="messageView" value="�鿴����" onclick="openWinQuery('claimNo',fm.prpLprepayClaimNo.value)"></td>
      
      <%--modify by wangli update end 20050409--%>
    </tr>
    </table>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
    <td colspan="4" >Ԥ�����Ǽ� 
      <input type="hidden" name="prpLprepayUnderWriteFlag"  value="0"> 
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
    <td class="input"> <input type=text name="prpLprepayPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLprepayDto' property='policyNo' filter='true' />"><input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.PolicyNo.value);"> 
    </td>
    <td class="title"> ������� </td>
    <td class="input"> <input class="readonly" type=text name="prpLprepayClauseName" readonly="true"  style="width:150px" value="<bean:write name='prpLprepayDto' property='clauseName' filter='true' />">	
    </td>
  </tr>
  
  <tr> 
    <td class="title"> �����ڼ䣺</td>
    <td colspan="3" class="input"> 
    	<input type=text name="prpLprepayStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLprepayDto' property='startDate' filter='true' /> �� 0 ʱ �� <bean:write name='prpLprepayDto' property='endDate' filter='true' /> �� 24 ʱֹ">     
    </td>
  </tr>
  <tr> 
    <td class="title"> ���ƺ���:</td>
    <td class="input"> <input class="readonly" name="prpLprepayLicenseNo" readonly="true" value="<bean:write name='prpLprepayDto' property='licenseNo' filter='true' />"> 
    </td>
    <td class="title"> ���Ƶ�ɫ�� </td>
    <td class="input"> 
    	<input class="readonly"  name="prpLprepayLicenseColor" readonly="true" value="<bean:write name='prpLprepayDto' property='licenseColor' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �������ࣺ</td>
    <td class="input"> 
    	<input name="prpLprepayCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='carKind' filter='true' />">  
    </td>
    <td class="title"> �����ͺţ�</td>
    <td class="input"> <input class="readonly" name="prpLprepayBrandName" readonly="true" value="<bean:write name='prpLprepayDto' property='brandName' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �������ţ� </td>
    <td class="input"> <input type="text" name="prpLprepayEngineNo" class="readonly" readonly="true" maxlength=20 description="��������" value="<bean:write name='prpLprepayDto' property='engineNo'/>"> 
    </td>
    <td class="title"> ���ܺţ� </td>
    <td class="input"> <input type="text" name="prpLprepayFrameNo" class="readonly" readonly="true" maxlength=20 description="���ܺ�" value="<bean:write name='prpLprepayDto' property='frameNo'/>"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ����ʱ�䣺</td>
    <td colspan="3" class="input"> 
    	<input type=text name="prpLprepayDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLprepayDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLprepayDto' property='damageStartHour' filter='true' /> ʱ">
    </td>
  </tr>
  <tr> 
    <td class="title"> ���յص㣺</td>
    <td colspan="3" class="input"> <input type=text name="prpLprepayDamageAddress" title="���յ�" style="width:400px" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ������(CNY)��</td>
    <td class="input"> <input class="readonly" readonly name="prpLprepaySumClaim" description="������ʧ���" value="<bean:write name='prpLprepayDto' property='sumClaim' filter='true' />"> 
    </td>
    <td class="title"> ���ս��(CNY)��</td>
    <td class="input"> 
    	<input name="prpLprepaySumAmount" type="text" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='sumAmount' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title">�ұ� </td>
    <td class="input"> 
    	<input class="readonly" style="width:100" name="prpLprepayCurrencyName" value="�����"><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
    <td class="title"> Ԥ���</td>
    <td class="input"> 
    	<input name="prpLprepaySumPrePaid" type="text" class="readonly" readonly="true" style="width:130" value="<bean:write name='prpLprepayDto' property='sumPrePaid' filter='true' />"><img src="/claim/images/bgMarkMustInput.jpg"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ҵ����������� </td>
    <td class="input"> 
      <input type=text   name="prpLprepayComName" title="ҵ���������" class="readonly" readonly="true" value = "<bean:write name='prpLprepayDto' property='comName' filter='true' />"> 
    </td>
    <td class="title">����ҵ��Ա��</td>
    <td class="input"> 
      <input type=text   name="prpLprepayHandler1Name" title="����ҵ��Ա" class="readonly" readonly="true" value="<bean:write name='prpLprepayDto' property='handler1Name' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> �����ˣ� </td>
    <td class="input"> 
      <input name="prpLprepayHandlerCode" class="readonly" readonly="true" style="width:80" value="<bean:write name='prpLprepayDto' property='handlerCode' filter='true' />"> 
      <input name="prpLprepayHandlerName" class="readonly" readonly="true"  style="width:80"  title="������" value="<bean:write name='prpLprepayDto' property='handlerName' filter='true' />"><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
    <td class="title"> ͳ�����£�</td>
    <td class="input"> <input type="text" class="readonly" readonly="true" style="width:130" name="prpLprepayStatisticsYM" value="<bean:write name='prpLprepayDto' property='statisticsYM' filter='true' />">
			<img src="/claim/images/bgMarkMustInput.jpg">
    </td>
  </tr>
</table>
