<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ ���� ]���ǳ��գ�
* AUTHOR     �� lixiang
* CREATEDATE �� 2004-10-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--modify by liuyanmei add 20051114 start-->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%  
 PrpLclaimDto  prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLclaimDto.getStartHour();
 intendHour    = prpLclaimDto.getEndHour();
 
if (intstartHour==0){
    startHour = "��ʱ����";
 }else if (intstartHour==12){ 
    startHour = "ʮ��ʱ����";
 }
 else if (intstartHour==24){
     startHour = "��ʮ��ʱ��";
 }
 
 if (intendHour==12){
     endHour = "ʮ��ʱֹ";
 }
 else if (intendHour==24){
     endHour = "��ʮ��ʱֹ";
 }
 else if (intendHour==0){
     endHour = "��ʱֹ";
 }
  //ȡ����ϵͳ�ĵ�ַ
 String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
%>
<!--modify by liuyanmei add 20051114 end-->
	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">�����Ǽ�
	            <logic:equal name ="prpLclaimDto" property="caseType" value='0'>
        ���Ѿ��⣩
        </logic:equal>
       
        <logic:equal name ="prpLclaimDto" property="caseType" value='1'>
        ����ע����
        </logic:equal>
	          </td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td><input type="button" name="message" class="bigbutton" value="���⹵ͨ" onclick="openWinSaveQuery(fm.registno.value,fm.prpLclaimPolicyNo.value,'<bean:write name='prpLclaimDto' property='riskCode' />','claim','<bean:write name='prpLclaimDto' property='claimNo' filter='true' />','registNo',fm.registno.value);"></td>
	   <td><input type="button" name="eCertify" class="bigbutton" value="��֤�ϴ�" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo'/>','check');"></td> 
	   <td><input type="button" name="claimCancleShow" class="bigbutton" value="ע��/������Ϣ" onClick="openClaimCancle('<bean:write name='prpLclaimDto' property='claimNo'/>','<bean:write name='prpLclaimDto' property='registNo'/>','<bean:write name='prpLclaimDto' property='riskCode'/>');"></td>
      <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
	  Ϊ˫��ѡ���</font></td>
	</tr>
	</table>
    
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title" colspan="2">�����Ǽ�
        
          <input type="hidden" name="prpLclaimRiskCode" value="<bean:write name='prpLclaimDto' property='riskCode' />">
          <input type="hidden" name="prpLclaimOperatorCode" value="<bean:write name='prpLclaimDto' property='operatorCode' />">
          <input type="hidden" name="prpLclaimMakeCom" value="<bean:write name='prpLclaimDto' property='makeCom' />">		 		
		  <input type="hidden" name="prpLclaimEngineNo" >
		  <input type="hidden" name="prpLclaimFrameNo">
		  <input type="hidden" name="prpLclaimRunDistance">
          <input type="hidden" name="prpLclaimSumDefLoss" value="<bean:write name='prpLclaimDto' property='sumDefLoss' />">		
          <input type="hidden" name="prpLclaimTypeForDriver" value="claim">	
          <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">					
          <input type="hidden" name="prpLclaimPolicyType" value="<bean:write name='prpLclaimDto' property='policyType' />"> 
          <input type="hidden" name="prpLclaimEscapeFlag" value="<bean:write name='prpLclaimDto' property='escapeFlag'/>">         
          <input type="hidden" name="prpLclaimClassCode" value="<bean:write name='prpLclaimDto' property='classCode' />">
          <input type="hidden" name="prpLclaimInputDate" value="<bean:write name='prpLclaimDto' property='inputDate' />">
          <input type="hidden" name="prpLclaimDamageEndDate" value="<bean:write name='prpLclaimDto' property='damageEndDate' />">
          <input type="hidden" name="prpLclaimDamageEndHour" value="<bean:write name='prpLclaimDto' property='damageEndHour' />">
          <input type="hidden" name="prpLclaimDamageEndMinute" value="<bean:write name='prpLclaimDto' property='damageEndMinute' />">
          <input type="hidden" name="prpLclaimClauseType" readonly="true"  style="width:30px" value="<bean:write name='prpLclaimDto' property='clauseType' filter='true' />">
          <input type="hidden" name="prpLclaimClauseName" readonly="true"  style="width:300px"value="<bean:write name='prpLclaimDto' property='clauseName' filter='true' />">			
          <input type="hidden" name="prpLclaimAddressCode"  title="���յش���" class="input"  style="width:80px" value="<bean:write name='prpLclaimDto' property='addressCode' filter='true' />">
          <input type="hidden" name="prpLclaimDamageAddressType" title="���յ�" class="codecode" style="width:90px" value="<bean:write name='prpLclaimDto' property='damageAddressType' filter='true' />">
          <input type="hidden" name="prpLclaimDamageTypeCode" class="codecode"  style="width:15%" title="�¹�ԭ��" value="<bean:write name='prpLclaimDto' property='damageTypeCode' filter='true' />">
          <input type="hidden" name="prpLclaimDamageAreaCode" class="codecode" style="width:15%" title="��������" value="<bean:write name='prpLclaimDto' property='damageAreaCode' filter='true' />">
          <input type="hidden" name="riskcode" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />"> 
          <input type="hidden" name="policyno" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">    
          <input type="hidden" name="registno" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
          <input type="hidden" name='payFee' value="<%=request.getAttribute("payFlag")%>">
          <input type="hidden" name='delinquentfeeCase' value="<bean:write name='delinquentfeeCase'/>">          
          <input type="hidden" name="prpLclaimLanguage" title="����" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='language' filter='true' />">
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          <input type="hidden" name="prpLclaimOthFlag" value="<bean:write name='prpLclaimDto' property='othFlag' />">
          <input type="hidden" name="underWriteEndDate" value="<bean:write name='prpLclaimDto' property='underWriteEndDate' filter='true' />">
           <input type="hidden" name="damageStartDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
           <input type="hidden" name="nodeType" value="claim">
           <!--modify by qinyongli 2005-07-22 start �������͹ɶ���Ϣ-->
	      <logic:notEmpty name="coinsFlag"  >
	      <input type="hidden" name="coinsFlag" value="<bean:write name='coinsFlag'/>">
	      </logic:notEmpty>
	      <logic:empty name="coinsFlag"  >
	      <input type="hidden" name="coinsFlag" value="0">
	      </logic:empty>
	      <logic:notEmpty name="shareHolderFlag"  >
	      <input type="hidden" name="shareHolderFlag" value="<bean:write name='shareHolderFlag'/>">
	      </logic:notEmpty>
	      <logic:empty name="shareHolderFlag"  >
	      <input type="hidden" name="shareHolderFlag" value="0">
	      </logic:empty>
	      <logic:notEmpty name="tempReinsFlag"  >
	      <input type="hidden" name="tempReinsFlag" value="<bean:write name='tempReinsFlag'/>">
	      </logic:notEmpty>
	      <logic:empty name="tempReinsFlag"  >
	      <input type="hidden" name="tempReinsFlag" value="0">
	      </logic:empty>
              <logic:notEmpty name="registDate"  >
	      <input type="hidden" name="prpLclaimReportDate1" value="<bean:write name='registDate'/>">
	      </logic:notEmpty>
	      <logic:empty name="registDate"  >
	      <input type="hidden" name="prpLclaimReportDate1" value="0">
	      </logic:empty>
           <%--�������� add by qinyongli--%>
          <logic:notEmpty name="claim_days"  >
          <input type="hidden" name='claim_days' value="<bean:write name='claim_days' />">
          </logic:notEmpty>
          <logic:empty name="claim_days"  >
          <input type="hidden" name='claim_days' value="1">
          </logic:empty>
          <logic:notEmpty name="standardDays"  >
          <input type="hidden" name='standardDays' value="<bean:write name='standardDays' />">
          </logic:notEmpty>
          <logic:empty name="standardDays"  >
          <input type="hidden" name='standardDays' value="100">
          </logic:empty>
        </td>
        <td class="title">��������:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr> 
      <tr>        
        <td class="title" style="width:15%"><bean:message key="db.prpLclaim.claimNo" />:</td>
        <td class="input" style="width:36%" >
           <input type=text name="prpLclaimClaimNo" title="������" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
        </td>
        <td class="title" style="width:14%;valign:bottom" ><!--<bean:message key="db.prpLclaim.caseNo" />-->�᰸��:</td>
        <td class="input" style="width:35%;valign:middle">
          <input type=text name="prpLclaimCaseNo" title="�᰸��" class="readonly" readonly="true"  maxlength="22" style="width:140px" value="<bean:write name='prpLclaimDto' property='caseNo' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title"  style='display:none'><bean:message key="db.prpLclaim.lflag" />:</td>
        <td class="input"  style='display:none'>
          <html:select name="prpLclaimDto" property="LFlag" >
            <html:options collection="claimFlagList"  property="value" labelProperty="label"/>          
          </html:select>
        </td>
        
        <td class="title"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" colspan=3>
          <input type=text name="prpLclaimRegistNo" title="������" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
           <input type="hidden" name="damageDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
          <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
       
        </td>        
      </tr>
      
      <tr>
       <td class="title" ><bean:message key="db.prpLclaim.policyNo" />:</td>
       <td class="input" >
          <input type=text name="prpLclaimPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLclaimPolicyNo.value,fm.registno.value);return false;">
        
        </td>
        
        <td class="title" >�ѳ��մ���:</td>
        <td class="input" >
        <%-- ������Ϣ���� --%>
           <%@include file="/commonProp/regist/PropExistRegist.jsp"%>                
        </td>
      </tr>
      
      <tr>
       <td class="title">ҵ����Դ:</td>
        <td class="input">
          <input type="hidden" name="prpLclaimBusinessNature" value="<bean:write name='prpLclaimDto' property='businessNature' />">
          <input type=text name="prpLclaimRegistNo" title="ҵ����Դ" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='businessNatureName' />">
        </td>
        <td class="title"></td>
        <td class="input"></td>
      </tr>
        
      <tr>
        <td class="title"><bean:message key="db.prpLclaim.insuredName" />:</td>
        <td class="input" colspan='3' >   
          <input type=hidden name="prpLregistInsuredCode" title="�������˴���" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">  
          <input type=hidden name="prpLclaimInsuredName" title="��������" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">
          <input type=text name="prpLclaimInsuredNameShow" title="��������������ʾ" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='insuredNameShow' filter='true' />">
        </td>
      </tr>      
      
     <tr>
        <td class="title">�����ڼ�</td>
        <td class="input" colspan='3'>       
          <input type=text name="prpLclaimStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' />"><%=startHour %>
          <input type=text name="prpLclaimEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLclaimDto' property='endDate' filter='true' />"><%=endHour %>
        </td>
      </tr>
      
      <tr>
        <td class="title">�ұ�:</td>
        <td class="input">
          <input class="readonly" name="claimCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />-<bean:write name='strCurrencyName'  filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimPolicyCurrency">						
        </td>        
        <td class="title">���ս��:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format="##.00"/>">
          <input type="hidden" name="prpLclaimSumPremium" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPremium' filter='true'  />">
        </td>        
      </tr>      
      <tr>
        <td class="title">����ʱ��:</td>
        <td class="input">
          <input  name="prpLclaimDamageStartDate" title="����ʱ��" class="readonly"  readonly="true" maxlength="10" style="width:80px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">��
          <input  name="prpLclaimDamageStartHour" title="����Сʱ" class="readonly"  readonly="true" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartHour' filter='true' />">ʱ
          <input  name="prpLclaimDamageStartMinute" title="���շ���" class="readonly"  readonly="true" maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartMinute' filter='true' />">��
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
        <td class="title"><bean:message key="db.prpLclaim.damageName" />:</td>
        <td class="input">
            <input type=text class="codecode" name="prpLclaimDamageCode"  style="width:15%" title="����ԭ��" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','1' ,'code','','clear','change');">
           <input type=text class="codecode" name="prpLclaimDamageName"  title="����ԭ��" style="width:63%" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1' ,'name','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onblur="code_CodeChange(this, 'DamageCode', '-1','name','','clear','change');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      </table>
      
      <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title">���յص�:</td>
        <td class="input" colspan='3'>
          <input  name="prpLclaimDamageAddress" title="���յص�" class="readonly"   readonly="true" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"> <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
       <tr>
        <td class='title'>�Ƿ������׷��:</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="replevyFlag" style="width:60">
            <html:option value="0">��</html:option>
            <html:option value="1">��</html:option>
           </html:select>        	
        </td>
        <td class='title'>�Ƿ������������н����:</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="thirdComFlag"  style="width:60">
            <html:option value="0">��</html:option>
            <html:option value="1">��</html:option>
           </html:select>        	
        </td>
      </tr>
      <logic:equal name="prpLclaimDto" property="riskCode" value="ZH03">
         <tr>
         <td class="title" >����ţ�</td>
	       	<td class="input"  colspan='3' >
	       	 <bean:write name='prpLclaimDto' property='remark'/>
        	<input type="hidden" name="FamilyNo" value="<bean:write name='prpLclaimDto' property='remark'/>">
	      	</td>
      	</tr>
       </logic:equal>