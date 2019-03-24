<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面[ 立案 ]（非车险）
* AUTHOR     ： lixiang
* CREATEDATE ： 2004-10-14
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--modify by liuyanmei add 20051114 start-->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%


 PrpCmainDto prpCmainDto = (PrpCmainDto)request.getAttribute("prpCmainDto_"+indexMainHead);
 request.setAttribute("prpCmainDto",prpCmainDto);
 String strCurrencyName = (String)request.getAttribute("strCurrencyName_"+indexMainHead);
 request.setAttribute("strCurrencyName",strCurrencyName);
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLclaimDto.getStartHour();
 intendHour    = prpLclaimDto.getEndHour();
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
	<input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
	   <!-- 耳标号所有保单号 -->
       <input type="hidden" name="earPolicyNo" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">立案登记
	            <logic:equal name ="prpLclaimDto" property="caseType" value='0'>
        （已拒赔）
        </logic:equal>
       
        <logic:equal name ="prpLclaimDto" property="caseType" value='1'>
        （已注销）
        </logic:equal>
	          </td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td><input type="button" name="message_<%=indexMainHead%>" class="bigbutton" value="理赔沟通" onclick="openWinSaveQuery(fm.registno_<%=indexMainHead%>.value,fm.prpLclaimPolicyNo_<%=indexMainHead%>.value,'<bean:write name='prpLclaimDto' property='riskCode' />','claim','<bean:write name='prpLclaimDto' property='claimNo' filter='true' />','registNo',fm.registno_<%=indexMainHead%>.value);"></td>
	   <td><input type="button" name="eCertify_<%=indexMainHead%>" class="bigbutton" value="单证上传" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo'/>','check');"></td> 
      <td width="70%" align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">” 
	  为双击选择项。</font></td>
	</tr>
	</table>
    
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title" colspan="2">立案登记
           <input type="hidden" name="riskType_<%=indexMainHead%>" value="<%=request.getAttribute("riskType_"+indexMainHead) %>">
          <input type="hidden" name="prpLclaimRiskCode_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='riskCode' />">
          <input type="hidden" name="prpLclaimOperatorCode_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='operatorCode' />">
          <input type="hidden" name="prpLclaimMakeCom_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='makeCom' />">		 		
				  <input type="hidden" name="prpLclaimEngineNo_<%=indexMainHead%>" >
				  <input type="hidden" name="prpLclaimFrameNo_<%=indexMainHead%>">
				  <input type="hidden" name="prpLclaimRunDistance_<%=indexMainHead%>">
<%--<input type="hidden" name="prpLclaimLossName" value="<bean:write name='prpLclaimDto' property='lossName' />">--%>
				  <input type="hidden" name="prpLclaimSumDefLoss_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='sumDefLoss' />">		
          <input type="hidden" name="prpLclaimTypeForDriver_<%=indexMainHead%>" value="claim">						
          <input type="hidden" name="prpLclaimPolicyType_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='policyType' />"> 
          <input type="hidden" name="prpLclaimEscapeFlag_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='escapeFlag'/>">         
          <input type="hidden" name="prpLclaimClassCode_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='classCode' />">
          <input type="hidden" name="prpLclaimInputDate_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='inputDate' />">
          <input type="hidden" name="prpLclaimDamageEndDate_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='damageEndDate' />">
          <input type="hidden" name="prpLclaimDamageEndHour_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='damageEndHour' />">
          <input type="hidden" name="prpLclaimDamageEndMinute_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='damageEndMinute' />">
          <input type="hidden" name="prpLclaimClauseType_<%=indexMainHead%>" readonly="true"  style="width:30px" value="<bean:write name='prpLclaimDto' property='clauseType' filter='true' />">
          <input type="hidden" name="prpLclaimClauseName_<%=indexMainHead%>" readonly="true"  style="width:300px"value="<bean:write name='prpLclaimDto' property='clauseName' filter='true' />">			
          <input type="hidden" name="prpLclaimAddressCode_<%=indexMainHead%>"  title="出险地代码" class="input"  style="width:80px" value="<bean:write name='prpLclaimDto' property='addressCode' filter='true' />">
          <input type="hidden" name="prpLclaimDamageAddressType_<%=indexMainHead%>" title="出险地" class="codecode" style="width:90px" value="<bean:write name='prpLclaimDto' property='damageAddressType' filter='true' />">
          <input type="hidden" name="prpLclaimDamageTypeCode_<%=indexMainHead%>" class="codecode"  style="width:15%" title="事故原因" value="<bean:write name='prpLclaimDto' property='damageTypeCode' filter='true' />">
          <input type="hidden" name="prpLclaimDamageAreaCode_<%=indexMainHead%>" class="codecode" style="width:15%" title="出险区域" value="<bean:write name='prpLclaimDto' property='damageAreaCode' filter='true' />">
          <input type="hidden" name="riskcode_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />"> 
          <input type="hidden" name="policyno_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">    
          <input type="hidden" name="registno_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
          <input type="hidden" name='payFee_<%=indexMainHead%>' value="<%=request.getAttribute("payFlag_"+indexMainHead)%>">
          <input type="hidden" name='delinquentfeeCase_<%=indexMainHead%>' value="<%=request.getAttribute("delinquentfeeCase_"+indexMainHead)%>">          
          <input type="hidden" name="prpLclaimLanguage_<%=indexMainHead%>" title="语种" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='language' filter='true' />">
          <input type="hidden" name="swfLogFlowID_<%=indexMainHead%>" class="common" value="<%=request.getAttribute("swfLogFlowID_"+indexMainHead)%>">
          <input type="hidden" name="swfLogLogNo_<%=indexMainHead%>" class="common" value="<%=request.getAttribute("swfLogLogNo_"+indexMainHead)%>">
          <input type="hidden" name="prpLclaimOthFlag_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='othFlag' />">
          <input type="hidden" name="underWriteEndDate_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='underWriteEndDate' filter='true' />">
           <input type="hidden" name="damageStartDate_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
           <input type="hidden" name="prpLcompensateBusinessType1_<%=indexMainHead%>" value="<bean:write name='prpCmainDto' property='businessType1' filter='true' />">
           <!--modify by qinyongli 2005-07-22 start 联共保和股东信息-->
	      <logic:notEmpty name="coinsFlag_<%=indexMainHead%>"  >
	      <input type="hidden" name="coinsFlag_<%=indexMainHead%>" value="<bean:write name='coinsFlag'/>">
	      </logic:notEmpty>
	      <logic:empty name="coinsFlag_<%=indexMainHead%>"  >
	      <input type="hidden" name="coinsFlag_<%=indexMainHead%>" value="0">
	      </logic:empty>
	      <logic:notEmpty name="shareHolderFlag_<%=indexMainHead%>"  >
	      <input type="hidden" name="shareHolderFlag_<%=indexMainHead%>" value="<bean:write name='shareHolderFlag'/>">
	      </logic:notEmpty>
	      <logic:empty name="shareHolderFlag_<%=indexMainHead%>"  >
	      <input type="hidden" name="shareHolderFlag_<%=indexMainHead%>" value="0">
	      </logic:empty>
	      <logic:notEmpty name="tempReinsFlag_<%=indexMainHead%>"  >
	      <input type="hidden" name="tempReinsFlag_<%=indexMainHead%>" value="<bean:write name='tempReinsFlag'/>">
	      </logic:notEmpty>
	      <logic:empty name="tempReinsFlag_<%=indexMainHead%>"  >
	      <input type="hidden" name="tempReinsFlag_<%=indexMainHead%>" value="0">
	      </logic:empty>
              <logic:notEmpty name="registDate_<%=indexMainHead%>"  >
	      <input type="hidden" name="prpLclaimReportDate1_<%=indexMainHead%>" value="<bean:write name='registDate'/>">
	      </logic:notEmpty>
	      <logic:empty name="registDate_<%=indexMainHead%>"  >
	      <input type="hidden" name="prpLclaimReportDate1_<%=indexMainHead%>" value="0">
	      </logic:empty>
           <%--立案天数 add by qinyongli--%>
          <logic:notEmpty name="claim_days_<%=indexMainHead%>"  >
          <input type="hidden" name='claim_days_<%=indexMainHead%>' value="<bean:write name='claim_days' />">
          </logic:notEmpty>
          <logic:empty name="claim_days_<%=indexMainHead%>"  >
          <input type="hidden" name='claim_days_<%=indexMainHead%>' value="1">
          </logic:empty>
          <logic:notEmpty name="standardDays_<%=indexMainHead%>"  >
          <input type="hidden" name='standardDays_<%=indexMainHead%>' value="<bean:write name='standardDays' />">
          </logic:notEmpty>
          <logic:empty name="standardDays_<%=indexMainHead%>"  >
          <input type="hidden" name='standardDays_<%=indexMainHead%>' value="100">
          </logic:empty>
        </td>
        <td class="title">险种名称:</td>
        <td class="title"><%= request.getAttribute("riskCName_"+indexMainHead) %></td>
      </tr> 
      <tr>        
        <td class="title" style="width:15%"><bean:message key="db.prpLclaim.claimNo" />:</td>
        <td class="input" style="width:36%" >
           <input type=text name="prpLclaimClaimNo_<%=indexMainHead%>" title="立案号" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
        </td>
        <td class="title" style="width:14%;valign:bottom" ><!--<bean:message key="db.prpLclaim.caseNo" />-->结案号:</td>
        <td class="input" style="width:35%;valign:middle">
          <input type=text name="prpLclaimCaseNo_<%=indexMainHead%>" title="结案号" class="readonly" readonly="true"  maxlength="22" style="width:140px" value="<bean:write name='prpLclaimDto' property='caseNo' filter='true' />">
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
          <input type=text name="prpLclaimRegistNo_<%=indexMainHead%>" title="报案号" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
           <input type="hidden" name="damageDate_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
          <input type=button class="bigbutton"  name="policyBackWard_<%=indexMainHead%>" value="出险时保单信息" onclick="backWardPolicy('<%=indexMainHead%>');">
          
       
        </td>        
      </tr>
      
      <tr>
       <td class="title" ><bean:message key="db.prpLclaim.policyNo" />:</td>
       <td class="input" >
          <input type=text name="prpLclaimPolicyNo_<%=indexMainHead%>" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
          <input type="image" name="btRelate_<%=indexMainHead%>" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLclaimPolicyNo_<%=indexMainHead%>.value,fm.registno_<%=indexMainHead%>.value);return false;">
        
        </td>
        
        <td class="title" >已出险次数:</td>
        <td class="input" >
        <%-- 出险信息画面 --%>
           <%@include file="/combineAgri/claim/AgriExistRegist.jsp"%>                
        </td>
      </tr>
      
      <tr>
       <td class="title">业务来源:</td>
        <td class="input">
          <input type="hidden" name="prpLclaimBusinessNature_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='businessNature' />">
          <input type=text name="prpLclaimRegistNo_<%=indexMainHead%>" title="业务来源" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='businessNatureName' />">
        </td>
      <!--modify by liuyanmei 20051206  start reason:非车需求：语种”中文” 去掉（需求）-->  
        <td class="title"></td>
        <td class="input"></td>
      <!--  <td class="title">语种:</td>
        <td class="input">
           <logic:equal name='prpLclaimDto' property='language' value="C">
          中文
          </logic:equal>
        </td> --> 
       <!--modify by liuyanmei 20051206  end-->   
      </tr>
        
      <tr>
        <td class="title"><bean:message key="db.prpLclaim.insuredName" />:</td>
          <td class="input" colspan='3' >   
          <input type=hidden name="prpLregistInsuredCode_<%=indexMainHead%>" title="被保险人代码" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">  
          <input type=hidden name="prpLclaimInsuredName_<%=indexMainHead%>" title="被保险人" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">
          <input type=text name="prpLclaimInsuredNameShow_<%=indexMainHead%>" title="被保险人名称显示" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='insuredNameShow' filter='true' />">
        </td>
      </tr>      
      
     <tr>
        <td class="title">保险期间</td>
        <td class="input" colspan='3'>       
          <input type=text name="prpLclaimStartDate_<%=indexMainHead%>" title="起保日期" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' />"><%=startHour %>
          <input type=text name="prpLclaimEndDate_<%=indexMainHead%>"   title="终保日期" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLclaimDto' property='endDate' filter='true' />"><%=endHour %>
        </td>
      </tr>
      
      <tr>
        <td class="title">币别:</td>
        <td class="input">
         <%--input class="readonly" readonly name="prpLclaimCurrencyName" value="人民币"--%>
          <input class="readonly" readonly="readonly" name="claimCurrency_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />-<bean:write name='strCurrencyName'  filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimCurrency_<%=indexMainHead%>" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimPolicyCurrency_<%=indexMainHead%>">						
        </td>        
        <td class="title">保险金额:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimSumAmount_<%=indexMainHead%>" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format="##.00"/>">
          <input type="hidden" name="prpLclaimSumPremium_<%=indexMainHead%>" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPremium' filter='true'  />">
        </td>        
      </tr>      
      <tr>
        <td class="title">出险时间:</td>
        <td class="input" colspan="3">
          <input  name="prpLclaimDamageStartDate_<%=indexMainHead%>" title="出险时间" class="readonly"  readonly="true" maxlength="10" style="width:80px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">日
          <input  name="prpLclaimDamageStartHour_<%=indexMainHead%>" title="出险小时" class="readonly"  readonly="true" class="input" maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartHour' filter='true' />">时
          <input  name="prpLclaimDamageStartMinute_<%=indexMainHead%>" title="出险分钟" class="readonly"  readonly="true" maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartMinute' filter='true' />">分
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <%@include file="/combineAgri/claim/AgriClaimDamageEdit.jsp"%>
      </table>
      
      <!--modify by wangwei add start 2005-06-04-->
      <!--原因：添加巨灾代码信息-->
      <!--modify by liyanjie 注释,移至出险摘要后边-->
      <%--  @include file="/common/claim/ClaimKelpInfo.jsp" --%>
      <!--modify by wangwei add end 2005-06-04-->
      
      <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title">出险地点:</td>
        <td class="input" colspan='3'>
          <input  name="prpLclaimDamageAddress_<%=indexMainHead%>" title="出险地点" class="readonly"   readonly="true" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"> <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
       <tr>
        <td class='title'>是否可能有追偿:</td>
        <td class='input' style="width:35%" id="tdReplevyFlag_<%=indexMainHead%>">
          <html:select name="prpLclaimDto" property="replevyFlag" style="width:60">
            <html:option value="0">否</html:option>
            <html:option value="1">是</html:option>
           </html:select>        	
        </td>
        <td class='title'>是否有其他理赔中介机构:</td>
        <td class='input' style="width:35%" id="tdThirdComFlag_<%=indexMainHead%>">
          <html:select name="prpLclaimDto" property="thirdComFlag"  style="width:60">
            <html:option value="0">否</html:option>
            <html:option value="1">是</html:option>
           </html:select>        	
        </td>
      </tr>
      
 <%indexMainHead++;%>