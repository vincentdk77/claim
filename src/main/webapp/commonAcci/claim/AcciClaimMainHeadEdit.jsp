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
 PrpLclaimDto  prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
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
 
 //取核心系统的地址
 String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
%>
<!--modify by liuyanmei add 20051114 end-->
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
       <td>
           <input type="button" name="messageSave" class='button' value="理赔沟通" onclick="return openWinSaveQuery('<bean:write name='prpLclaimDto' property='registNo' filter='true' />',fm.prpLclaimPolicyNo.value,fm.prpLclaimRiskCode.value,'claim',fm.prpLclaimClaimNo.value,'registNo','<bean:write name='prpLclaimDto' property='registNo' filter='true' />');">
       </td>
       <td>
            <td><input type="button" name="eCertify" class="bigbutton" value="单证上传" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo'/>','claim');"></td> 
           <td><input type="button" name="claimCancleShow" class="bigbutton" value="注销/拒赔信息" onClick="openClaimCancle('<bean:write name='prpLclaimDto' property='claimNo'/>','<bean:write name='prpLclaimDto' property='registNo'/>','<bean:write name='prpLclaimDto' property='riskCode'/>');"></td>
           <td width="70%" align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">”
          为双击选择项。</font>
          
      </td>
	</tr>
	</table>

    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title" colspan="2">立案登记
          <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
          <input type="hidden" name="prpLclaimRiskCode" value="<bean:write name='prpLclaimDto' property='riskCode' />">
          <input type="hidden" name="prpLclaimOperatorCode" value="<bean:write name='prpLclaimDto' property='operatorCode' />">
          <input type="hidden" name="prpLclaimMakeCom" value="<bean:write name='prpLclaimDto' property='makeCom' />">
				  <input type="hidden" name="prpLclaimEngineNo" >
				  <input type="hidden" name="prpLclaimFrameNo">
				  <input type="hidden" name="prpLclaimRunDistance">
				 <%-- <input type="hidden" name="prpLclaimLossName" value="<bean:write name='prpLclaimDto' property='lossName' />">--%>
				  <input type="hidden" name="prpLclaimSumDefLoss" value="<bean:write name='prpLclaimDto' property='sumDefLoss' />">
          <input type="hidden" name="prpLclaimTypeForDriver" value="claim">

          <input type="hidden" name="prpLclaimPolicyType" value="<bean:write name='prpLclaimDto' property='policyType' />">
          <input type="hidden" name="prpLclaimEscapeFlag" value="<bean:write name='prpLclaimDto' property='escapeFlag'/>">
          <input type="hidden" name="prpLclaimClassCode" value="<bean:write name='prpLclaimDto' property='classCode' />">
          <input type="hidden" name="prpLclaimInputDate" value="<bean:write name='prpLclaimDto' property='inputDate' />">
          <input type="hidden" name="prpLclaimDamageEndDate" value="<bean:write name='prpLclaimDto' property='damageEndDate' />">
          <input type="hidden" name="prpLclaimDamageEndHour" value="<bean:write name='prpLclaimDto' property='damageEndHour' />">
          <input type="hidden" name="prpLclaimDamageEndMinute" value="<bean:write name='prpLclaimDto' property='damageEndMinute' />">
          <input type="hidden" name="prpLclaimClauseType" readonly="true"  style="width:30px" value="<bean:write name='prpLclaimDto' property='clauseType' filter='true' />">
          <input type="hidden" name="prpLclaimClauseName" readonly="true"  style="width:300px"value="<bean:write name='prpLclaimDto' property='clauseName' filter='true' />">
          <input type="hidden" name="prpLclaimAddressCode"  title="事故地代码" class="input"  style="width:80px" value="<bean:write name='prpLclaimDto' property='addressCode' filter='true' />">
          <input type="hidden" name="prpLclaimDamageAddressType" title="事故地" class="codecode" style="width:90px" value="<bean:write name='prpLclaimDto' property='damageAddressType' filter='true' />">
         <!-- <input type="hidden" name="prpLclaimDamageTypeCode" class="codecode"  style="width:15%" title="事故原因" value="<bean:write name='prpLclaimDto' property='damageTypeCode' filter='true' />">-->
          <input type="hidden" name="prpLclaimDamageAreaCode" class="codecode" style="width:15%" title="事故区域" value="<bean:write name='prpLclaimDto' property='damageAreaCode' filter='true' />">
          <input type="hidden" name="riskcode" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />">
          <input type="hidden" name="policyno" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
          <input type="hidden" name="registno" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
          <input type="hidden" name="prpLclaimLanguage" title="语种" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='language' filter='true' />">
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          <input type="hidden" name="prpLclaimOthFlag" value="<bean:write name='prpLclaimDto' property='othFlag' />">
          <input type="hidden" name="underWriteEndDate" value="<bean:write name='prpLclaimDto' property='underWriteEndDate' filter='true' />">
          <input type="hidden" name="damageStartDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
          <!--添加标志位，用于提交表单时判断时否还有申请调查未提交。 2005-08-04-->
          <input type="hidden" name="AcciClaimFlag" value="<%= request.getAttribute("com.sinosoft.acciFlag")%>">
          <input type="hidden" name='payFee' value="<%=request.getAttribute("payFlag")%>">
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
              <logic:notEmpty name="registDate"  >
	      <input type="hidden" name="prpLclaimReportDate1" value="<bean:write name='registDate'/>">
	      </logic:notEmpty>
	      <logic:empty name="registDate"  >
	      <input type="hidden" name="prpLclaimReportDate1" value="0">
	      </logic:empty>

          <%--
	        <input type="hidden" name="prpLclaimDamageEndHour" value="<bean:write name='prpLclaimDto' property='damageEndHour' />">
          <input type="hidden" name="prpLclaimCurClaimDate" value="<bean:write name='prpLclaimDto' property='curClaimDate' />">
          --%>
           <%--立案天数 add by qinyongli--%>
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
        <td class="title">险种名称:</td>
        <td class="title"><%= request.getAttribute("riskCName") %></td>
      </tr>
      <tr>
        <td class="title" style="width:15%"><bean:message key="db.prpLclaim.claimNo" />:</td>
        <td class="input" style="width:36%" >
           <input type=text name="prpLclaimClaimNo" title="立案号" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
        </td>
        <td class="title" style="width:14%;valign:bottom" ><!--<bean:message key="db.prpLclaim.caseNo" />-->结案号:</td>
        <td class="input" style="width:35%;valign:middle">
          <input type=text name="prpLclaimCaseNo" title="结案号" class="readonly" readonly="true"  maxlength="22" style="width:140px" value="<bean:write name='prpLclaimDto' property='caseNo' filter='true' />">
        </td>
      </tr>
      <tr>
        <td class="title" style='display:none'><bean:message key="db.prpLclaim.lflag" />:</td>
        <td class="input" style='display:none'>
          <html:select name="prpLclaimDto" property="LFlag" >
            <html:options collection="claimFlagList"  property="value" labelProperty="label"/>
          </html:select>
        </td>

        <td class="title"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" colspan=3>
          <input type=text name="prpLclaimRegistNo" title="报案号" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
          <input type="hidden" name="damageDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
          <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">
        </td>
      </tr>

      <tr>
       <td class="title" ><bean:message key="db.prpLclaim.policyNo" />:</td>
       <td class="input" >
          <input type=text name="prpLclaimPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
          <%--
          	Modify by 孟冬冬 start(2006-1-6)
          	Reson:在意健险类别时和另一个JSP页面（common/claim/ClaimProposer.jsp）中定义的name 为“prpLclaimPolicyNo”的变量发生了冲突，导致在点关联按钮时无法获取"prpLclaimPolicyNo"变量;
          	但又不能简单的删掉其中任何一个，故在下面重新定义一个新的变量，用以在进行关联操作时使用
          --%>
          <input type=hidden name="prpLclaimPolicyNoForRelate" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
          <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLclaimPolicyNoForRelate.value);return false;">
          <%--
          	Modify by 孟冬冬 end
          --%>
        </td>

        <td class="title" >已发生事故次数:</td>
        <td class="input" >
        <%-- 事故信息画面 --%>
           <%@include file="/common/regist/ExistRegist.jsp"%>
        </td>
      </tr>

      <tr>
       <td class="title">业务来源:</td>
        <td class="input">
          <input type="hidden" name="prpLclaimBusinessNature" value="<bean:write name='prpLclaimDto' property='businessNature' />">
          <input type=text name="prpLclaimRegistNo" title="业务来源" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='businessNatureName' />">
        </td>

        <td class="title">语种:</td>
        <td class="input">
           <logic:equal name='prpLclaimDto' property='language' value="C">
          中文
          </logic:equal>
        </td>
      </tr>

      <tr>
        <td class="title"><bean:message key="db.prpLclaim.insuredName" />:</td>
        <td class="input"  > 
          <input type=hidden name="prpLregistInsuredCode" title="被保险人代码" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">
          <input type=hidden name="prpLclaimInsuredName" title="被保险人" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">
          <input type=hidden name="policyNo"  class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
          <input type=text name="prpLclaimInsuredNameShow" title="被保险人名称显示" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='insuredNameShow' filter='true' />">
        </td>
        <td class="title">投保人名称:</td>
        <td class="input"> 
          <input type=text name="prpLclaimAppliNameShow" title="投保人名称显示" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='appliNameShow' filter='true' />">
        </td>
     </tr>
     <tr>
        <td class="title">保险期间</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLclaimStartDate" title="起保日期" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' />"><%=startHour %>
          <input type=text name="prpLclaimEndDate"   title="终保日期" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLclaimDto' property='endDate' filter='true' />"><%=endHour %>
        </td>
      </tr>

      <tr>
        <td class="title">币别:</td>
        <td class="input">
          <%--input class="readonly" readonly name="prpLclaimCurrencyName" value="人民币"--%>
          <input class="readonly" name="claimCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />-<bean:write name='strCurrencyName'  filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimPolicyCurrency">	
        </td>
        <td class="title">保险金额:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format="##.00"/>">
          <input type="hidden" name="prpLclaimSumPremium" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPremium' filter='true'  />">
        </td>
      </tr>
      <tr>
        <td class="title">事故时间:</td>
        <td class="input">
          <input type=text name="prpLclaimDamageStartDate" title="事故时间" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">日
          <input type=text name="prpLclaimDamageStartHour" title="事故小时" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartHour' filter='true' />">时
          <input type=text name="prpLclaimDamageStartMinute" title="事故分钟" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartMinute' filter='true' />">分

        </td>

        <td class="title"><bean:message key="db.prpLclaim.damageName" />:</td>
        <td class="input">
        	<input type="hidden" name="prpLclaimDamageCodeOld" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />">
        
            <input type=text class="codecode" name="prpLclaimDamageCode"  style="width:15%" title="事故原因" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','1' ,'code','','clear','change');">
           <input type=text class="codecode" name="prpLclaimDamageName"  title="事故原因" style="width:63%" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','-1','name','','clear','change');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>

      <tr>
        <td class="title">事故地点:</td>
        <td class="input">
          <input type=text name="prpLclaimDamageAddress" title="事故地点" class="input" style="width:98%" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"
        </td>
         <td class="title"><bean:message key="db.prpLclaim.damageTypeName" />:</td>
        <td  class="input">
          <input type=text name="prpLclaimDamageTypeCode" class="codecode"  style="width:15%" title="事故原因" value="<bean:write name='prpLclaimDto' property='damageTypeCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');">
          <input type=text name="prpLclaimDamageTypeName" class="codecode" title="事故原因" style="width:63%" value="<bean:write name='prpLclaimDto' property='damageTypeName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','always','none','post');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">   
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
       <tr>
        <td class='title'>是否可能有追偿:</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="replevyFlag" style="width:60">
            <html:option value="0">否</html:option>
            <html:option value="1">是</html:option>
           </html:select>
        </td>
        <td class='title'>是否有其他理赔中介机构:</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="thirdComFlag"  style="width:60">
            <html:option value="0">否</html:option>
            <html:option value="1">是</html:option>
           </html:select>
        </td>
      </tr>
      <tr>
  <td class="title">赔付人次:</td>
  <td class="input"><input type=text name="prpLclaimLossesNumber"
    class="input" style="width: 80px"
    value="<bean:write name='prpLclaimDto' property='lossesNumber' filter='true' format="#0.00"/>">
  <td class="title"></td>
  <td class="input"></td>
</tr>
      
      <!--add by wuzheng 健康险统计制度增机专项业务信息和医疗类型 20080602 begin-->
       <tr id = "trMedicalType" style="display:none">
        <td class='title'>医疗类型</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="medicalType" style="width:60">
            <html:option value=""></html:option>
            <html:option value="01">门诊</html:option>
            <html:option value="02">住院</html:option>
            <html:option value="99">其他</html:option>
           </html:select>
        </td>
        <td class='title'></td>
        <td class='input'></td>
      </tr>      
      <!--add by wuzheng 健康险统计制度增机专项业务信息和医疗类型 20080602 end-->