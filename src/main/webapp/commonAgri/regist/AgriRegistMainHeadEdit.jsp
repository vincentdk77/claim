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
%>

<!--modify by liuyanmei add 20051114 end-->
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
       <td width="30%">
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr>
              <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
              <%
       // ��session��ȡ��ƶ/�󻧱�־
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td class="formtitle">��ģ��Ӫ����ϵͳ�����Ǽ�
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (��ע��)
        </logic:notEqual></td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td class="formtitle">��ƶϵͳ�����Ǽ�
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (��ע��)
        </logic:notEqual></td><% 
			} else {
				%> <td class="formtitle">�����Ǽ�
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (��ע��)
        </logic:notEqual></td><% 
			}
		} else {
			%> <td class="formtitle">�����Ǽ�
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (��ע��)
        </logic:notEqual></td><% 
		}
      %>
              
              
      
      
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
        <td><input type="button"  name="messageView" value="�鿴������ϵ��¼" class="bigbutton" onclick="openWinQuery('registNo','<bean:write name='prpLregistDto' property='registNo'/>')"></td><td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">��
     <%}%> 
    </tr>
    </table>
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title">
      <tr>
        <td class="title" colspan="2">�����Ǽ�
          <input type="hidden" name="prpLregistLFlag" value="L">
          <input type="hidden" name="prpLregistNodeType" value="regis">
          <input type="hidden" name="prpLregistRiskCode"  value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name="prpLregistClassCode" value="<bean:write name='prpLregistDto' property='classCode' />">
          <input type="hidden" name="prpLregistLanguage" value="<bean:write name='prpLregistDto' property='language' />">
          
          
          
          <input type="hidden" name="prpLregistModelCode" value="<bean:write name='prpLregistDto' property='modelCode' />">
          <input type="hidden" name="prpLregistEngineNo" value="<bean:write name='prpLregistDto' property='engineNo' />">
          <input type="hidden" name="prpLregistFrameNo" value="<bean:write name='prpLregistDto' property='frameNo' />">
          <input type="hidden" name="prpLregistRunDistance" value="<bean:write name='prpLregistDto' property='runDistance' />">
          <input type="hidden" name="prpLregistUseYears" value="<bean:write name='prpLregistDto' property='useYears' />">
          <input type="hidden" name="prpLregistBrandName" value="<bean:write name='prpLregistDto' property='brandName' />">
          <!--input type="hidden" name="prpLregistTypeForDriver" value="Regist"-->
          <input type="hidden" name='prpLregistEditType'value="<bean:write name='prpLregistDto' property='editType' />">
          <!--
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
          -->
          <!--add by miaowenjun 20060922 ũ�գ���ֳ���߲鿱���� start-->
          <input type="hidden" name='scheduleType' value="ALLS"> 
          <input type=hidden name="nextScheduleTypeCheck" vlaue="1">
					<input type=hidden name="nextScheduleTypeLoss" vlaue="0">
					<!--add by miaowenjun 20060922 ũ�գ���ֳ���߲鿱���� end-->
          <input type="hidden" name="prpLregistLossQuantity" value="<bean:write name='prpLregistDto' property='lossQuantity' />">
          <input type="hidden" name="prpLregistRunDistance" value="<bean:write name='prpLregistDto' property='runDistance' />">
          <input type="hidden" name='riskcode' value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name='policyno' value="<bean:write name='prpLregistDto' property='policyNo' />">
          <input type="hidden" name='registno' value="<bean:write name='prpLregistDto' property='registNo' />">
          <input type="hidden" name="prpLregistOthFlag" value="<bean:write name='prpLregistDto' property='othFlag' />">  
          <input type="hidden" name="underWriteEndDate" value="<bean:write name='prpLregistDto' property='underWriteEndDate' />">  
          <!--modify by liuyanmei add 20051109 start-->
          <%--���뱨�������������� add by qinyongli--%>
          <logic:notEmpty name="configValue"  >
          <input type="hidden" name='configValue' value="<bean:write name='configValue' />">
          </logic:notEmpty>
          <logic:empty name="configValue"  >
          <input type="hidden" name='configValue' value="99999">
          </logic:empty>  
          <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLregistDto' property='payFlag'/>">
          <input type="hidden" name='delinquentfeeCase' value="<bean:write name='delinquentfeeCase'/>">          
          <input type="hidden" name="RecentCount" value="<bean:write name='prpLregistDto1' property='recentCount' filter='true' />">
          <input type="hidden" name="RegistViewLimitDay" value="<%= AppConfig.get("sysconst.RegistViewLimitDay") %>">
          <input type="hidden" name="prpLregistFlowInTime" value="<bean:write name='prpLregistDto' property='flowInTime' filter='true' />">
          <input type="hidden" name="prpLregistSignDate" value="<bean:write name='prpLregistDto' property='signDate' />">
          <!--modify by liuyanmei add 20051109 end-->  
          
          <!-- ���ӳб����� -->
          <input type= "hidden" name="statQuantity" value="<%=request.getAttribute("statQuantity")%>"/>
        </td>
        <td class="title">��������:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr>
      <tr>
        <%--���뱨�������������� add by qinyongli--%>
          <logic:notEmpty name="configValue"  >
          <input type="hidden" name='configValue' value="<bean:write name='configValue' />">
          </logic:notEmpty>
          <logic:empty name="configValue"  >
          <input type="hidden" name='configValue' value="99999">
          </logic:empty>
        <td class="title" style="width:15%"><bean:message key="db.prpLregist.registNo" />:</td>
        <td class="input" style="width:35%" >
          <input type=text name="prpLregistRegistNo" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
        </td>
        <td class="title" style="width:15%" style="valign:bottom" ><bean:message key="db.prpLregist.policyNo" />:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input type=text name="prpLregistPolicyNo" class="readonly" readonly="true" style="width:130px" value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" style="width:50px" height="17" border="0" onclick="relate(fm.prpLregistPolicyNo.value);return false;">

        </td>
      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.insuredCode" />:</td>
        <td class="input" >
        <!--
        <logic:equal name='prpLregistDto' property="customerType" value="1">
          <a href='/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpDcustomerIdvCustomerCode=<bean:write name='prpLregistDto' property='insuredCode' filter='true' />' >
        </logic:equal>
        <logic:equal name='prpLregistDto' property="customerType" value="2">
          <a href='/claim/processPrpDcustomerUnit.do?actionType=prepareUpdate&prpDcustomerUnitCustomerCode=<bean:write name='prpLregistDto' property='insuredCode' filter='true' />' >
        </logic:equal> -->
        <input type=hidden name="prpLregistInsuredCode" title="�������˴���" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='insuredCode' filter='true' />">
        <bean:write name='prpLregistDto' property='insuredCode' filter='true' />
         <!-- </a>-->
        </td>

        <td class="title">�ѳ��մ���:</td>
        <td class="input">
         <%-- ������Ϣ���� --%>
           <%@include file="/commonAgri/regist/AgriExistRegist.jsp"%>
        </td>

      </tr>
      
      <%
       // ��session��ȡ��ƶ/�󻧱�־
		strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <tr>
      <td class="title">����Ͷ����ʽ:</td>
      <td class="input">����Ͷ��-----��ģ��Ӫ����</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <tr>
      <td class="title">����Ͷ����ʽ:</td>
      <td class="input">����Ͷ��-----����ũ��</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} 
		} 
      %>
      
      
      <tr>
        <td class="title" id="InsuredNameID"><bean:message key="db.prpLregist.insuredName" />:</td>
        <td class="input" colspan="3" >
        <input type=text name="prpLregistInsuredNameshow" title="������������" maxlength="60" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredNameShow' filter='true' />">
        <input type=hidden name="prpLregistInsuredName" title="������������" maxlength="60" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredName' filter='true' />">
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
        </td>
        <%--
         <td class="title">�̶��绰</td>
        <td class="input"><input maxlength='11' type="text" style="width:120px" Class="input"></input></td>
        --%>
      </tr>
      <tr>
        <td class="title">�����ڼ�</td>
        <td class="input" colspan=1>
          <input type=text name="prpLregistStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLregistDto' property='startDate' filter='true' />"><%= startHour %>
          <input type=text name="prpLregistEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLregistDto' property='endDate' filter='true' />"><%= endHour %>
        </td>
        <td class="title">
        </td>
        <td class="input" >
          <input type="hidden" name="damageDate" value="<%= request.getParameter("damageDate")%>">
          <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
         </td>
      </tr>
       <tr>
        <td class="title">����ʱ��:</td>
        <td class="input" colspan="3">
          <input type=text name="prpLregistDamageStartDate" title="����ʱ��" class="Wdate" onfocus="WdatePicker()"  maxlength="10" style="width:100px" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true'/>" onchange="flashPage();">
           <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.prpLregistDamageStartDate', '2007', '2017')"> -->��
          <input type=text name="prpLregistDamageStartHour" title="����Сʱ" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true'/>"
           			onchange="checkHour(this);flashPage();"
          			onKeyPress="pressInteger(event)" >ʱ
          <input type=text name="prpLregistDamageStartMinute" title="���շ���" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true'/>" 
          			onblur="checkMin(this);flashPage();"
          		onKeyPress="pressInteger(event)" >��
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      	 <%@include file="/commonAgri/regist/AgriRegistDamageEdit.jsp"%>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.reportorName" />:</td>
        <td class="input">
          <input type=text name="prpLregistReportorName" title="������" class="input"  maxlength="20" onblur="checkLength1(this);" style="width:120px"  value="<bean:write name='prpLregistDto' property='reportorName' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title">����ʱ��:</td>
        <td class="input">
          <input  name="prpLregistReportDate" class="input"  maxlength="10" style="width:80px"   onblur="checkFullDate(this)"  value="<bean:write name='prpLregistDto' property='reportDate' filter='true' />">��
          <input  name="prpLregistReportHour" class="input" maxlength="2" style="width:20px"    value="<bean:write name='prpLregistDto' property='reportHour' filter='true' />"
       			onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >ʱ
          <input  name="prpLregistReportMinute" class="input" maxlength="2" style="width:20px"   value="<bean:write name='prpLregistDto' property='reportMinute' filter='true' />"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >��
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr >
        <td class="title"><bean:message key="db.prpLregist.reportType" />:</td>
        <td class="input" id="tdReportType">
          <html:select name="prpLregistDto" property="reportType" styleClass="three"  style="width:120px">
              <html:options collection="reportTypes" property="codeCode" labelProperty="codeCName"/>
          </html:select>
        </td>
        <td class="title"><bean:message key="db.prpLregist.inputDate" />:</td>
        <td class="input">
           <input type=text name="prpLregistInputDate"  title="¼������"  style="width:80px" class="readonly"  readonly value="<bean:write name='prpLregistDto' property='inputDate' filter='true' />">
        </td>

      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerName" title="��ϵ��" maxlength="20" onblur="checkLength1(this);" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
          <input type=text name="prpLregistPhoneNumber" title="���绰" maxlength="20" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
      <%
         if(String.valueOf(request.getAttribute("familySplittingFlag")) != null && "true".equals(String.valueOf(request.getAttribute("familySplittingFlag"))))
         {%>
         <td class="title">�⸶����:</td>
        <td class="input" id="tdLossesNumber">
           <input type=text name="prpLregistLossesNumber" class="readonly" readonly="true" style="width:80px" value="<bean:write name='prpLregistDto' property='lossesNumber' filter='true' format='0.00'/>" onblur="checkStatQuantity(this)">
            <html:select name="prpLregistDto" property="lossesUnitCode" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
          </html:select>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <%}else{%>
        <td class="title">�⸶����:</td>
        <td class="input" id="tdLossesNumber">
           <input type=text name="prpLregistLossesNumber" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='lossesNumber' filter='true' format='0.00'/>" onblur="checkStatQuantity(this)">
            <html:select name="prpLregistDto" property="lossesUnitCode" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
          </html:select>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <%}%>
        <td class="title"><bean:message key="db.prpLregist.areaPostCode" />:</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLregistAddressCode"  title="���յ���������" class="input"  style="width:80px" value="<bean:write name='prpLregistDto' property='addressCode' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.damageAddress" />:</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLregistDamageAddress" title="���յ�" onblur="checkLength1(this);" description="���յ�" Class="input" style="width:350px" value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">
         <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
        <td class="title">�ұ�:</td>
        <td class="input" colspan=3>
        <input type="text" name="prpLregistEstiCurrency" value="<bean:write name='prpLregistDto' property='estiCurrency' />" class="codecode" style="width:10%" title="�ұ�"
         ondblclick="code_CodeSelect(this, 'Currency');"
         onkeyup= "code_CodeSelect(this, 'Currency');">
        <input type=text name="prpLregistEstiCurrencyName" class="codecode" style="width:20%" title="�ұ�"  value="<bean:write name='prpLregistDto' property='estiCurrencyName' />"
           ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
           onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">

        </td>
      </tr>
     <!--modify by liuyanmei add start 20051025-->
      <!-- reason: ���ء�������á�200509-lpba-011-->
      <tr>
       <td class="title"><%--<bean:message key="db.prpLregist.estimateLoss" />--%>������:</td>
      <td class="input" colspan=3>
        <input type=text name="prpLregistEstimateLoss" title="������ʧ" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateLoss' filter='true' format='0.00'/>">
      </td>

      <!--modify by wangwei add start 20050602-->
      <!-- <td class="title">�������</td> -->
      <!--<td class="input"> -->
        <input type=hidden name="prpLregistEstimateFee" title="�������" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateFee' filter='true' format='0.00'/>">
      <!--</td> -->
       <!--modify by liuyanmei add end 20051025-->
      <!--modify by wangwei add end 20050602-->
      </tr>
