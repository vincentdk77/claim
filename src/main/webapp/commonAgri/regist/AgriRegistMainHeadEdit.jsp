<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面
* AUTHOR     ： weishixin
* CREATEDATE ： 2004-02-29
* MODIFYLIST ：   Name       Date            Reason/Contents
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
    startHour = "零时起至";
 }else if (intstartHour==12){ 
    startHour = "十二时起至";
 }
 else if (intstartHour==24){
     startHour = "二十四时起";
 }
 
 if (intendHour==12){
     endHour = "十二时止";
 }
 else if (intendHour==24){
     endHour = "二十四时止";
 }
 else if (intendHour==0){
     endHour = "零时止";
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
       // 从session里取扶贫/大户标志
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td class="formtitle">规模经营主体系统报案登记
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (已注消)
        </logic:notEqual></td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td class="formtitle">扶贫系统报案登记
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (已注消)
        </logic:notEqual></td><% 
			} else {
				%> <td class="formtitle">报案登记
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (已注消)
        </logic:notEqual></td><% 
			}
		} else {
			%> <td class="formtitle">报案登记
              <logic:notEqual name="prpLregistDto" property="cancelDate" value="">
                 (已注消)
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
        <td><input type="button"  name="messageView" value="查看理赔联系记录" class="bigbutton" onclick="openWinQuery('registNo','<bean:write name='prpLregistDto' property='registNo'/>')"></td><td width="70%" align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">”
     <%}%> 
    </tr>
    </table>
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title">
      <tr>
        <td class="title" colspan="2">报案登记
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
          <!--add by miaowenjun 20060922 农险（养殖）走查勘调度 start-->
          <input type="hidden" name='scheduleType' value="ALLS"> 
          <input type=hidden name="nextScheduleTypeCheck" vlaue="1">
					<input type=hidden name="nextScheduleTypeLoss" vlaue="0">
					<!--add by miaowenjun 20060922 农险（养殖）走查勘调度 end-->
          <input type="hidden" name="prpLregistLossQuantity" value="<bean:write name='prpLregistDto' property='lossQuantity' />">
          <input type="hidden" name="prpLregistRunDistance" value="<bean:write name='prpLregistDto' property='runDistance' />">
          <input type="hidden" name='riskcode' value="<bean:write name='prpLregistDto' property='riskCode' />">
          <input type="hidden" name='policyno' value="<bean:write name='prpLregistDto' property='policyNo' />">
          <input type="hidden" name='registno' value="<bean:write name='prpLregistDto' property='registNo' />">
          <input type="hidden" name="prpLregistOthFlag" value="<bean:write name='prpLregistDto' property='othFlag' />">  
          <input type="hidden" name="underWriteEndDate" value="<bean:write name='prpLregistDto' property='underWriteEndDate' />">  
          <!--modify by liuyanmei add 20051109 start-->
          <%--加入报案出险延期天数 add by qinyongli--%>
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
          
          <!-- 增加承保数量 -->
          <input type= "hidden" name="statQuantity" value="<%=request.getAttribute("statQuantity")%>"/>
        </td>
        <td class="title">险种名称:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr>
      <tr>
        <%--加入报案出险延期天数 add by qinyongli--%>
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
        <input type=hidden name="prpLregistInsuredCode" title="被保险人代码" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='insuredCode' filter='true' />">
        <bean:write name='prpLregistDto' property='insuredCode' filter='true' />
         <!-- </a>-->
        </td>

        <td class="title">已出险次数:</td>
        <td class="input">
         <%-- 出险信息画面 --%>
           <%@include file="/commonAgri/regist/AgriExistRegist.jsp"%>
        </td>

      </tr>
      
      <%
       // 从session里取扶贫/大户标志
		strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <tr>
      <td class="title">保单投保方式:</td>
      <td class="input">个体投保-----规模经营主体</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <tr>
      <td class="title">保单投保方式:</td>
      <td class="input">团体投保-----特困农户</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} 
		} 
      %>
      
      
      <tr>
        <td class="title" id="InsuredNameID"><bean:message key="db.prpLregist.insuredName" />:</td>
        <td class="input" colspan="3" >
        <input type=text name="prpLregistInsuredNameshow" title="被保险人名称" maxlength="60" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredNameShow' filter='true' />">
        <input type=hidden name="prpLregistInsuredName" title="被保险人名称" maxlength="60" class="readonly" readonly="true"  value="<bean:write name='prpLregistDto' property='insuredName' filter='true' />">
      <!--modify by qinyongli 2005-07-22 start 联共保和股东信息-->
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
         <td class="title">固定电话</td>
        <td class="input"><input maxlength='11' type="text" style="width:120px" Class="input"></input></td>
        --%>
      </tr>
      <tr>
        <td class="title">保险期间</td>
        <td class="input" colspan=1>
          <input type=text name="prpLregistStartDate" title="起保日期" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLregistDto' property='startDate' filter='true' />"><%= startHour %>
          <input type=text name="prpLregistEndDate"   title="终保日期" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLregistDto' property='endDate' filter='true' />"><%= endHour %>
        </td>
        <td class="title">
        </td>
        <td class="input" >
          <input type="hidden" name="damageDate" value="<%= request.getParameter("damageDate")%>">
          <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">
         </td>
      </tr>
       <tr>
        <td class="title">出险时间:</td>
        <td class="input" colspan="3">
          <input type=text name="prpLregistDamageStartDate" title="出险时间" class="Wdate" onfocus="WdatePicker()"  maxlength="10" style="width:100px" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true'/>" onchange="flashPage();">
           <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.prpLregistDamageStartDate', '2007', '2017')"> -->日
          <input type=text name="prpLregistDamageStartHour" title="出险小时" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true'/>"
           			onchange="checkHour(this);flashPage();"
          			onKeyPress="pressInteger(event)" >时
          <input type=text name="prpLregistDamageStartMinute" title="出险分钟" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true'/>" 
          			onblur="checkMin(this);flashPage();"
          		onKeyPress="pressInteger(event)" >分
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      	 <%@include file="/commonAgri/regist/AgriRegistDamageEdit.jsp"%>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.reportorName" />:</td>
        <td class="input">
          <input type=text name="prpLregistReportorName" title="报案人" class="input"  maxlength="20" onblur="checkLength1(this);" style="width:120px"  value="<bean:write name='prpLregistDto' property='reportorName' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title">报案时间:</td>
        <td class="input">
          <input  name="prpLregistReportDate" class="input"  maxlength="10" style="width:80px"   onblur="checkFullDate(this)"  value="<bean:write name='prpLregistDto' property='reportDate' filter='true' />">日
          <input  name="prpLregistReportHour" class="input" maxlength="2" style="width:20px"    value="<bean:write name='prpLregistDto' property='reportHour' filter='true' />"
       			onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >时
          <input  name="prpLregistReportMinute" class="input" maxlength="2" style="width:20px"   value="<bean:write name='prpLregistDto' property='reportMinute' filter='true' />"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >分
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
           <input type=text name="prpLregistInputDate"  title="录入日期"  style="width:80px" class="readonly"  readonly value="<bean:write name='prpLregistDto' property='inputDate' filter='true' />">
        </td>

      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.linkerName" />:</td>
        <td class="input">
          <input type=text name="prpLregistLinkerName" title="联系人" maxlength="20" onblur="checkLength1(this);" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='linkerName' filter='true' />"/>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title"><bean:message key="db.prpLregist.phoneNumber" />:</td>
        <td class="input">
          <input type=text name="prpLregistPhoneNumber" title="联电话" maxlength="20" class="input" style="width:120px" value="<bean:write name='prpLregistDto' property='phoneNumber' filter='true' />">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
      <%
         if(String.valueOf(request.getAttribute("familySplittingFlag")) != null && "true".equals(String.valueOf(request.getAttribute("familySplittingFlag"))))
         {%>
         <td class="title">赔付数量:</td>
        <td class="input" id="tdLossesNumber">
           <input type=text name="prpLregistLossesNumber" class="readonly" readonly="true" style="width:80px" value="<bean:write name='prpLregistDto' property='lossesNumber' filter='true' format='0.00'/>" onblur="checkStatQuantity(this)">
            <html:select name="prpLregistDto" property="lossesUnitCode" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
          </html:select>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <%}else{%>
        <td class="title">赔付数量:</td>
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
          <input type=text name="prpLregistAddressCode"  title="出险地邮政编码" class="input"  style="width:80px" value="<bean:write name='prpLregistDto' property='addressCode' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title"><bean:message key="db.prpLregist.damageAddress" />:</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLregistDamageAddress" title="出险地" onblur="checkLength1(this);" description="出险地" Class="input" style="width:350px" value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">
         <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
        <td class="title">币别:</td>
        <td class="input" colspan=3>
        <input type="text" name="prpLregistEstiCurrency" value="<bean:write name='prpLregistDto' property='estiCurrency' />" class="codecode" style="width:10%" title="币别"
         ondblclick="code_CodeSelect(this, 'Currency');"
         onkeyup= "code_CodeSelect(this, 'Currency');">
        <input type=text name="prpLregistEstiCurrencyName" class="codecode" style="width:20%" title="币别"  value="<bean:write name='prpLregistDto' property='estiCurrencyName' />"
           ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
           onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">

        </td>
      </tr>
     <!--modify by liuyanmei add start 20051025-->
      <!-- reason: 隐藏“报损费用”200509-lpba-011-->
      <tr>
       <td class="title"><%--<bean:message key="db.prpLregist.estimateLoss" />--%>报损金额:</td>
      <td class="input" colspan=3>
        <input type=text name="prpLregistEstimateLoss" title="估计损失" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateLoss' filter='true' format='0.00'/>">
      </td>

      <!--modify by wangwei add start 20050602-->
      <!-- <td class="title">报损费用</td> -->
      <!--<td class="input"> -->
        <input type=hidden name="prpLregistEstimateFee" title="报损费用" Class="input" style="width:80px" value="<bean:write name='prpLregistDto' property='estimateFee' filter='true' format='0.00'/>">
      <!--</td> -->
       <!--modify by liuyanmei add end 20051025-->
      <!--modify by wangwei add end 20050602-->
      </tr>
