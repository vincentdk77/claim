<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��
* AUTHOR     �� weishixin
* CREATEDATE �� 2004-02-29
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--modify by liuyanmei add 20051114 start-->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%  
 PrpLregistDto  prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto"); 
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLregistDto.getStartHour();
 intendHour    = prpLregistDto.getEndHour();
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
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (��ע��)
        </logic:notEqual>
              </td>
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
      <%
        if(!editType.equals("SHOW")){%>
        <td><logic:notEqual name="prpLregistDto" property="status" value="1">
         <%@include file="/common/pub/MessageButton.jsp" %>
       </logic:notEqual></td>
     <%}else{%>
        <td><input type="button"  name="messageView" value="�鿴����" class="bigbutton" onclick="openWinQuery('registNo','<bean:write name='prpLregistDto' property='registNo'/>')"></td><td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">��
     <%}%> 
    </tr>
    </table>
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title">
      <tr>
        <td class="title" colspan="2">�����Ǽ�
          <input type="hidden" name="prpLregistLFlag" value="L">
          <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
          <input type="hidden" name="prpLregistRiskCode"  value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name="prpLregistClassCode" value="<bean:write name='prpLregistDto' property='classCode' />">
          <input type="hidden" name="prpLregistLanguage" value="<bean:write name='prpLregistDto' property='language' />">
          <input type="hidden" name="prpLregistLicenseNo" value="<bean:write name='prpLregistDto' property='licenseNo' />">
          <input type="hidden" name="prpLregistLicenseColorCode" value="<bean:write name='prpLregistDto' property='licenseColorCode' />">
          <input type="hidden" name="prpLregistCarKindCode" value="<bean:write name='prpLregistDto' property='carKindCode' />">
          <input type="hidden" name="prpLregistModelCode" value="<bean:write name='prpLregistDto' property='modelCode' />">
          <input type="hidden" name="prpLregistEngineNo" value="<bean:write name='prpLregistDto' property='engineNo' />">
          <input type="hidden" name="prpLregistFrameNo" value="<bean:write name='prpLregistDto' property='frameNo' />">
          <input type="hidden" name="prpLregistRunDistance" value="<bean:write name='prpLregistDto' property='runDistance' />">
          <input type="hidden" name="prpLregistUseYears" value="<bean:write name='prpLregistDto' property='useYears' />">
          <input type="hidden" name="prpLregistBrandName" value="<bean:write name='prpLregistDto' property='brandName' />">
          <input type="hidden" name="prpLregistTypeForDriver" value="Regist">
          <input type="hidden" name='prpLregistEditType'value="<bean:write name='prpLregistDto' property='editType' />">
          <input type="hidden" name='prpLregistDrivingLicenseNo'>
          <input type="hidden" name='prpLregistDrivingName' >
          <input type="hidden" name='prpLregistDrivingSex'>
          <input type="hidden" name='prpLregistDrivingIdentifyNumber' >
          <input type="hidden" name='prpLregistDrivingAge'>
          <input type="hidden" name='prpLregistDrivingOccupation'>
          <input type="hidden" name='prpLregistDrivingOccupationName'>
          <input type="hidden" name='prpLregistDrivingEducation'>
          <input type="hidden" name='prpLregistDrivingEducationName'>
          <input type="hidden" name='prpLregistDrivingUnitAddress'>
          <input type="hidden" name='prpLregistDrivingReceiveLicenseDate'>
          <input type="hidden" name='prpLregistDrivingCarType'>
          <input type="hidden" name='prpLregistDrivingAwardLicenseOrgan'>
          <input type="hidden" name="prpLregistLossQuantity" value="<bean:write name='prpLregistDto' property='lossQuantity' />">
          <input type="hidden" name="prpLregistRunDistance" value="<bean:write name='prpLregistDto' property='runDistance' />">
          <input type="hidden" name='riskcode' value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name='policyno' value="<bean:write name='prpLregistDto' property='policyNo' />">
          <input type="hidden" name='registno' value="<bean:write name='prpLregistDto' property='registNo' />">
          <input type="hidden" name='prpCmainPolicyNo' value="<bean:write name='prpLregistDto' property='policyNo' />">
          
          <input type="hidden" name='underWriteEndDate' value="<bean:write name='prpLregistDto' property='underWriteEndDate' />">    
          <input type="hidden" name="prpLregistOthFlag" value="<bean:write name='prpLregistDto' property='othFlag' />"> 
          <!--modify by liuyanmei add 20051109 start-->  
          <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLregistDto' property='payFlag'/>">
          <!--modify by liuyanmei add 20051109 end-->  
           
          
          <!--��ӱ�־λ�������ύ��ʱ�ж�ʱ�����������δ�ύ�� 2005-08-04-->
          <input type="hidden" name="AcciClaimFlag" value="<%= request.getAttribute("com.sinosoft.acciFlag")%>">
          
      </td>
        <td class="title">��������:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr>
      <tr>
          <%--���뱨�������������� add by qinyongli start--%>
          <logic:notEmpty name="configValue"  >
          <input type="hidden" name='configValue' value="<bean:write name='configValue' />">
          </logic:notEmpty>
          <logic:empty name="configValue"  >
          <input type="hidden" name='configValue' value="99999">
          </logic:empty>
          <logic:notEmpty name="shareHolderFlag"  >
          <input type="hidden" name="shareHolderFlag" value="<bean:write name='shareHolderFlag'/>">
          </logic:notEmpty>
          <logic:empty name="shareHolderFlag"  >
          <input type="hidden" name="shareHolderFlag" value="0">
          </logic:empty>
          <%--���뱨�������������� add by qinyongli end--%>
        <td class="title" style="width:15%"><bean:message key="db.prpLregist.registNo" />:</td>
        <td class="input" style="width:35%" >
          <input type=text name="prpLregistRegistNo" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
        </td>
        <td class="title" style="width:15%" style="valign:bottom" ><bean:message key="db.prpLregist.policyNo" />:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input type=text name="prpLregistPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLregistPolicyNo.value);return false;">

        </td>
      </tr>
      <tr>
        <td class="title">Ͷ��������:</td>
        <td class="input" >
          <input type=text name="prpLregistAppliNameShow" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='appliNameShow' filter='true' />">
          <input type=hidden name="prpLregistInsuredCode" title="�������˴���" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='insuredCode' filter='true' />">
        </td>
        <td class="title">�ѳ��¹ʴ���:</td>
        <td class="input">
         <%-- ������Ϣ���� --%>
           <%@include file="/common/regist/ExistRegist.jsp"%>
        </td>

      </tr>

      <tr>
        <td class="title">�����ڼ�</td>
        <td class="input" colspan=1>
          <input type=text name="prpLregistStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLregistDto' property='startDate' filter='true' />"><%=startHour %>
          <input type=text name="prpLregistEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLregistDto' property='endDate' filter='true' />"><%=endHour %>
         </td>
         <td class="input" colspan=3>
          <input type="hidden" name="damageDate" value="<%= request.getParameter("damageDate")%>">
          <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
         </td>
      </tr>
      <tr>
        <td class="title" id="InsuredNameID"><bean:message key="db.prpLregist.insuredName" />:</td>
        <td class="input">
             <input type=text name="prpLregistInsuredNameShow" title="��������������ʾ" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredNameShow' filter='true' />">
             <input type=hidden name="prpLregistInsuredName" title="������������" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredName' filter='true' />">
        </td>
        <td class="title" id="sumAmount">���ս��CNY:</td>
        <td class="input">
          <input type=text name="prpLregistInsuredName" title="���ս��" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='sumAmount' filter='true' format="0.00"/>">
        </td>
      </tr>
      <tr>
        <td class="title">�¹�ʱ��:</td>
        <td class="input">
          <input type=text name="prpLregistDamageStartDate" title="�¹�ʱ��" class="Wdate" maxlength="10" onfocus="WdatePicker()" style="width:80px" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />" onchange="flashPage();">
           <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.prpLregistDamageStartDate', '2007', '2017')"> -->��
          <input type=text name="prpLregistDamageStartHour" title="�¹�Сʱ" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true' />" 
          		onchange="checkHour(this);flashPage();"
          		onKeyPress="pressInteger(event)" >ʱ
          <input type=text name="prpLregistDamageStartMinute" title="�¹ʷ���" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true' />" 
          		onchange="checkMin(this);flashPage();"
          		onKeyPress="pressInteger(event)" >��
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title"><%--<bean:message key="db.prpLregist.damageCode" />--%>�¹�ԭ��:</td>
       <td class="input">
            <input type="hidden" class="codecode" name="prpLregistDamageCode"  style="width:20%" title="�¹�ԭ��" value="<bean:write name='prpLregistDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');"
             onblur= "code_CodeChange(this, 'DamageCode');">
           <input type=text class="codecode" name="prpLregistDamageName"  title="�¹�ԭ��" style="width:60%" value="<bean:write name='prpLregistDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','post','clear');"
             onblur="code_CodeChange(this, 'DamageCode','-1','name','post','clear');">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.reportorName" />:</td>
        <td class="input">
          <input type=text name="prpLregistReportorName" title="������" class="input"  maxlength="20" style="width:120px"  value="<bean:write name='prpLregistDto' property='reportorName' filter='true' />">
        </td>
        <td class="title">����ʱ��:</td>
        <td class="input">
          <input type=text name="prpLregistReportDate" class="input" onblur="checkFullDate(this)"  maxlength="10" style="width:80px"  value="<bean:write name='prpLregistDto' property='reportDate' filter='true' />">��
          <input type=text name="prpLregistReportHour" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLregistDto' property='reportHour' filter='true' />"
          		onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >ʱ
          <input type=text name="prpLregistReportMinute" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLregistDto' property='reportMinute' filter='true' />"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >��
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr >
        <td class="title"><bean:message key="db.prpLregist.reportType" />:</td>
        <td class="input">
          <html:select name="prpLregistDto" property="reportType" styleClass="three"  style="width:120px">
              <html:options collection="reportTypes" property="codeCode" labelProperty="codeCName"/>
          </html:select>
        </td>
        <td class="title"><bean:message key="db.prpLregist.inputDate" />:</td>
        <td class="input">
           <input type=text name="prpLregistInputDate"  title="¼������"  onblur="checkFullDate(this)" style="width:80px"  value="<bean:write name='prpLregistDto' property='inputDate' filter='true' />">
        </td>

      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerName" title="��ϵ��" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
          <!--add by caopeng start at 2005-12-22-->
          <img src="/claim/images/bgMarkMustInput.jpg">
          <!--add by caopeng end at 2005-12-22-->
        </td>
        <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
         <!--<img src="/claim/images/bgMarkMustInput.jpg">-->
          <input type=text name="prpLregistPhoneNumber" title="��ϵ�绰" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr>
        <td class="title">��ϵ��ַ:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerAddress" title="��ϵ��ַ" class="input" style="width:240px" value="<bean:write name='prpLregistDto' property='linkerAddress' filter='true' />"/>
        </td>
        <td class="title">���¹��߹�ϵ:</td>

         <td class="input">
           <!-- �����ݿ���ȡֵ modify by qinyongli 2005-9-4-->
           <select name ="prpLregistClauseType" title="���¹��߹�ϵ" class="input" style="width:100px">
             <option value="1" <logic:equal name="prpLregistDto" property="clauseType" value="1">selected</logic:equal>>����</option>
             <option value="2" <logic:equal name="prpLregistDto" property="clauseType" value="2">selected</logic:equal>>������</option>
             <option value="3" <logic:equal name="prpLregistDto" property="clauseType" value="3">selected</logic:equal>>����</option>
          </select>
        </td>
      </tr>
    
      <tr>
        <td class="title"><%--<bean:message key="db.prpLregist.damageAddress" />--%>�¹ʵص�:</td>
        <td class="input">
          <input type=text name="prpLregistDamageAddress" title="�¹ʵص�" Class="input" style="width:250px" value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">        
        </td>
        <td class="title">�¹�����:</td>
          <td class="input">
            <input type="hidden" name="prpLregistDamageTypeCode" class="codecode" style="width:20%" title="�¹�����" value="<bean:write name='prpLregistDto' property='damageTypeCode' />" 
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');">
            <input type=text name="prpLregistDamageTypeName" class="codecode" style="width:60%" title="�¹�����"  value="<bean:write name='prpLregistDto' property='damageTypeName' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','always','none','post');"> 
          </select>
          <img src="/claim/images/bgMarkMustInput.jpg">
          </td>
      </tr>
			<tr>
				<td class="title">�⸶�˴�:</td>
				<td class="input"><input type=text name="prpLregistLossesNumber"
					Class="input" style="width: 80px"
					value="<bean:write name='prpLregistDto' property='lossesNumber' filter='true' format='0.00'/>">
				<td class="title">&nbsp;</td>
				<td class="title">&nbsp;</td>
			</tr>
			<tr>
        <td class="title">�ұ�:</td>
        <td class="input">
        <input type="text" name="prpLregistEstiCurrency" value="<bean:write name='prpLregistDto' property='estiCurrency' />" class="codecode" style="width:30%" title="�ұ�"
         ondblclick="code_CodeSelect(this, 'Currency');"
         onkeyup= "code_CodeSelect(this, 'Currency');">
        <input type=text name="prpLregistEstiCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='prpLregistDto' property='estiCurrencyName' />"
           ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
           onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
        </td>
        <td class="title">&nbsp;</td><td  class="title">&nbsp;</td>
      </tr>
     <input type="hidden" name="prpLregistEstimateLoss" title="Ԥ�Ƹ������" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateLoss' filter='true' format="0.00"/>">
     <input type="hidden" name="prpLregistEstimateFee" title="Ԥ�Ʒ��ý��" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateFee' filter='true' format="0.00"/>">
     

