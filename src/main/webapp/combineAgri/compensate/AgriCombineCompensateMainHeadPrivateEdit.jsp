<%--
****************************************************************************
* DESC       :添加主信息子块界面页面Head[ 实赔 ]
* AUTHOR     : liubvo
* CREATEDATE : 2004-05-12
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--modify by liuyanmei add 20051114 start-->

<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@page import="java.text.*"%>
<%  
 PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto"); 
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLcompensateDto.getStartHour();
 intendHour    = prpLcompensateDto.getEndHour();
 
 String strAppliRiskLevel = "0";//投保人风险等级
 String strInsuredRiskLevel = "0";//被保险人风险等级
 DBPrpDcustomLevelTrace dbPrpDcustomLevelTrace = new DBPrpDcustomLevelTrace();
 //客户风险等级
 //businessType：T为投保单，C为保单
	//insuredFlag：1为被保险人，2为投保人
 strAppliRiskLevel = dbPrpDcustomLevelTrace.findRiskLevelByKey(prpLcompensateDto.getPolicyNo(),"2","C");//投保人风险等级
 strInsuredRiskLevel = dbPrpDcustomLevelTrace.findRiskLevelByKey(prpLcompensateDto.getPolicyNo(),"1","C");//被保险人风险等级
 BLPrpDcode blPrpDcodetem = new BLPrpDcode();
	//转中文
 strAppliRiskLevel = blPrpDcodetem.translateCode("RiskLevel",strAppliRiskLevel,true);
 strInsuredRiskLevel = blPrpDcodetem.translateCode("RiskLevel",strInsuredRiskLevel,true);
 
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

<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcustomLevelTrace"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<script language="javascript">
<!--
    function validateAccount(){
	     
	     var pwd1=fm.prpLcompensateAccount.value;      
	     var pwd2=fm.prpLcompensateAccountOK.value;  	  
	     if(pwd2!=pwd1){
	              alert("两次输入的支付帐号不一致，请重新输入!");
				  fm.prpLcompensateAccount.value="";
				  fm.prpLcompensateAccountOK.value="";
				  fm.prpLcompensateAccount.focus();
         }
    }
    
    
    function changePrpLcompensateFinallyFlag(){
    //由于非最后一张计算书必须说明后续计算书的说明，所以先借用理算说明吧
    //modify by lixiang start at 2006-8-1
    //reason:理算报告用来保存"后续理算内容"
    if(fm.prpLcompensateFinallyFlag[0].checked){
       Lltext.style.display="";
       fm.tdLltextTitle.value="理算报告";
       
    }else{
        Lltext.style.display="";
        fm.tdLltextTitle.value="后续理算说明";
      }
    }
    
   function changeFinallyFlagAndLltextContent(){
    
        //由于非最后一张计算书必须说明后续计算书的说明，所以先借用理算说明吧
        //modify by lixiang start at 2006-8-1
        //reason:理算报告用来保存"后续理算内容"
         var strtemp="";
        if(fm.prpLcompensateFinallyFlag[0].checked){
          Lltext.style.display="";
          fm.tdLltextTitle.value="理算报告";
          strtemp=fm.backLltextContent.value;
          fm.backLltextContent.value=fm.prpLltextContextInnerHTML.value;//备份现在的数据
          fm.prpLltextContextInnerHTML.value=strtemp;
        }else{
          Lltext.style.display="";
          fm.tdLltextTitle.value="后续理算说明";
          strtemp=fm.backLltextContent.value;
          fm.backLltextContent.value=fm.prpLltextContextInnerHTML.value;//备份现在的数据
          fm.prpLltextContextInnerHTML.value=strtemp;
        }
    }

-->
  
</script>

    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
       <td width="30%"> 
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr> 
              <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
              <td class="formtitle">赔款计算书</td>
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
       <td><input type="button" name="prpLmessageSave" value="理赔沟通" class="bigbutton" onclick="openWinSaveQuery(fm.prpLcompensateClaimNo.value,fm.prpLcompensatePolicyNo.value,fm.prpLcompensateRiskCode.value,'compe',fm.prpLcompensateClaimNo.value,'claimNo',fm.prpLcompensateClaimNo.value)"></td>
       <td><input type="button" name="eCertify" class="bigbutton" value="单证上传" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcompensateDto' property='registNo'/>','compe');"></td> 
       <td width="70%" align="right"><font color="#666666">　注:“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">” 
      为双击选择项。</font></td>
    </tr>
    </table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
      <input type="hidden" name="prpLcompensateCaseNo" value="<bean:write name='prpLcompensateDto' property='caseNo' />"> 
      <input type="hidden" name="prpLcompensateRiskType" value="<%= request.getAttribute("riskType") %>">
      <input type="hidden" name="prpLcompensateClassCode" value="<bean:write name='prpLcompensateDto' property='classCode' />"> 
      <input type="hidden" name="prpLcompensateRiskCode" value="<bean:write name='prpLcompensateDto' property='riskCode' />"> 
      <input type="hidden" name="prpLcompensateDeductCond" value="<bean:write name='prpLcompensateDto' property='deductCond' />"> 
      <input type="hidden" name="prpLcompensatePreserveDate" value="<bean:write name='prpLcompensateDto' property='preserveDate' />"> 
      <input type="hidden" name="prpLcompensateCheckAgentCode" value="<bean:write name='prpLcompensateDto' property='checkAgentCode' />"> 
      <input type="hidden" name="prpLcompensateCheckAgentName" value="<bean:write name='prpLcompensateDto' property='checkAgentName' />"> 
      <input type="hidden" name="prpLcompensateSurveyorName" value="<bean:write name='prpLcompensateDto' property='surveyorName' />"> 
      <input type="hidden" name="prpLcompensateCounterClaimerName" value="<bean:write name='prpLcompensateDto' property='counterClaimerName' />"> 
      <input type="hidden" name="prpLcompensateDutyDescription" value="<bean:write name='prpLcompensateDto' property='dutyDescription' />"> 
      <input type="hidden" name="prpLcompensateCurrency" value="<bean:write name='prpLcompensateDto' property='currency' />"> 
      <input type="hidden" name="prpLcompensateSumLoss" value="<bean:write name='prpLcompensateDto' property='sumLoss' />"> 
      <input type="hidden" name='payFee' value="<%=request.getAttribute("payFlag")%>">
      <input type="hidden" name='delinquentfeeCase' value="<bean:write name='delinquentfeeCase'/>">          
       <!--<input type="hidden" name="prpLcompensateReceiverName" value="<bean:write name='prpLcompensateDto' property='receiverName' />"> 
      <input type="hidden" name="prpLcompensateBank" value="<bean:write name='prpLcompensateDto' property='bank' />"> 
      <input type="hidden" name="prpLcompensateAccount" value="<bean:write name='prpLcompensateDto' property='account' />"> -->
      <input type="hidden" name="prpLcompensateMakeCom" value="<bean:write name='prpLcompensateDto' property='makeCom' />"> 
      <input type="hidden" name="prpLcompensateComCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
      <input type="hidden" name="prpLcompensateHandlerCode" value="<bean:write name='prpLcompensateDto' property='handlerCode' />"> 
      <input type="hidden" name="prpLcompensateHandler1Code" value="<bean:write name='prpLcompensateDto' property='handler1Code' />"> 
      <input type="hidden" name="prpLcompensateApproverCode" value="<bean:write name='prpLcompensateDto' property='approverCode' />"> 
      <input type="hidden" name="prpLcompensateUnderWriteCode" value="<bean:write name='prpLcompensateDto' property='underWriteCode' />"> 
      <input type="hidden" name="prpLcompensateUnderWriteName" value="<bean:write name='prpLcompensateDto' property='underWriteName' />"> 
      <input type="hidden" name="prpLcompensateOperatorCode" value="<bean:write name='prpLcompensateDto' property='operatorCode' />"> 
      <input type="hidden" name="prpLcompensateInputDate" value="<bean:write name='prpLcompensateDto' property='inputDate' />"> 
      <input type="hidden" name="prpLcompensateUnderWriteEndDate" value="<bean:write name='prpLcompensateDto' property='underWriteEndDate' />"> 
      <input type="hidden" name="prpLcompensateUnderWriteFlag" value="<bean:write name='prpLcompensateDto' property='underWriteFlag' />"> 
      <input type="hidden" name="prpLcompensateFlag" value="<bean:write name='prpLcompensateDto' property='flag' />"> 
      <input type="hidden" name="riskcode" value="<bean:write name='prpLcompensateDto' property='riskCode' />"> 
      <input type="hidden" name="policyno" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />"> 
      <input type="hidden" name="registno" value="<bean:write name='prpLcompensateDto' property='registNo' filter='true' />"> 
      <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
      <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
      <input type="hidden" name="prpLcompensateCaseType"  value="<bean:write name='prpLcompensateDto' property='caseType' filter='true' />">
      <input type="hidden" name="prpLcompensateStartDate"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> 日 0 时 至 <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> 日 24 时止">

      <input type="hidden" name="prpLcompensateClauseName"  value="<bean:write name='prpLcompensateDto' property='clauseName' filter='true' />">  
      <input type="hidden" name="prpLcompensateLicenseNo"  value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />"> 
      <input type="hidden" name="prpLcompensateCarKind" value="<bean:write name='prpLcompensateDto' property='carKind' filter='true' />">  
      <input type="hidden" name="prpLcompensateLicenseColor" value="<bean:write name='prpLcompensateDto' property='licenseColor' filter='true' />"> 
      <input type="hidden" name="prpLcompensateBrandName" value="<bean:write name='prpLcompensateDto' property='brandName' filter='true' />"> 
      <input type="hidden" name="prpLcompensateEngineNo" value="<bean:write name='prpLcompensateDto' property='engineNo'/>"> 
      <input type="hidden" name="prpLcompensateFrameNo" value="<bean:write name='prpLcompensateDto' property='frameNo'/>"> 
      <input type="hidden" name="prpLcompensateDamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> 时 <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> 分">
      <input type="hidden" name="prpLcompensateDamageAddress" value="<bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />"> 
      <input type="hidden" name="prpLcompensateSumAmount" value="<bean:write name='prpLcompensateDto' property='sumAmount' filter='true' />"> 
      <input type="hidden" name="prpLcompensateSumClaim" value="<bean:write name='prpLcompensateDto' property='sumClaim' filter='true' />"> 
      <input type="hidden" name="prpLcompensateBusinessType1" value="<bean:write name='prpLcompensateDto' property='businessType1' filter='true' />"> 
      <input type="hidden" name="GenerateCompensateFlag" value="0"> 
      <input type="hidden" name="damageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
      <input type="hidden" name="sumPaidAll" value="<bean:write name='prpLcompensateDto' property='sumPaidAll' filter='true' />"> 
   	  <input type="hidden" name ="statQuantity" value="<%=request.getAttribute("statQuantity")%>"/>
   	  <input type="hidden" name="prpLcompensateSumInsured" value="<bean:write name="prpLcompensateDto" property="sumInsured" />" >
   	  <input type="hidden" name="recaseFlag" value="<%=request.getAttribute("recaseFlag") %>">
   	  <input type="hidden" name="sumDamageInsured" value="<%=request.getAttribute("sumDamageInsured") %>">
   	  <input type="hidden" name="dbSumPaid" value="<%=request.getAttribute("dbSumPaid") %>" >
   	  <input type="hidden" name="dbLossNumber" value="<%=request.getAttribute("dbLossNumber") %>" >
   	  <input type="hidden" name="dbSumDutyPaid" value="<%=request.getAttribute("dbSumDutyPaid") %>">
   	  <input type="hidden" name="editTypeAgri" value="<%=request.getParameter("editType") %>">
   	  <!--公共要素隐藏域-->
   	  <input type="hidden" name="prpLcompensatePolicyNo" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
      <input type="hidden" name="prpLcompensateInsuredNameShow" value="<bean:write name='prpLcompensateDto' property='insuredNameShow' filter='true' />">
      <input type="hidden" name="prpLcompensateAppliName" value="<bean:write name='prpLcompensateDto' property='appliName' filter='true' />">
      <input type="hidden" name="prpLcompensateStartDate" value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> <%=startHour%> <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> <%=endHour%>">
  
  <tr> 
    <td class="title"  style="width:14%"> 计算书号:</td>
    <td class="input"  style="width:36%"> <input type=text name="prpLcompensateCompensateNo" title="计算书号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
    </td>
    <td class="title"  style="width:14%"> </td>
    <td class="input"  style="width:36%"><input type=hidden name="LFlag" title="理赔类型" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='LFlag' />"> 
    </td> 
  </tr> 
  <tr> 
    <td class="title"> 立案号: </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
     <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">
  
    </td>
    <td class="title"></td>
    <td class="input"></td>
  </tr>
  <tr>
    <td class="title"> 被保险人开户银行: </td>    
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateBank"  value="<bean:write name='prpLcompensateDto' property='bank' filter='true' />" > 
    </td>
    <td class="title"> 收款人全称: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateReceiverName"   style="width:250px" value="<bean:write name='prpLcompensateDto' property='receiverName' filter='true' />">
    </td>
  </tr>  
  <%
    String status = (String)request.getParameter("status");
    if("4".equals(status)||editType.equals("SHOW")){
  %>
    <tr>     
    <td class="title"> 开户帐号: </td>
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateAccount"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />"> 
    </td>
    <td class="title"> </td>
    <td class="input" colspan="1"></td>
  </tr>     
    <%}else {
    %>
  <tr>     
    <td class="title"> 开户帐号: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateAccount"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />"> 
    </td>
    <td class="title"> 请再次确认开户帐号: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateAccountOK"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />" onblur="validateAcc()"> 
    </td>
  </tr>
    <%}%> 
  
      <!--modify by qinyongli 2005-07-22 start 联共保、临分和股东信息-->
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
  <tr> 
   <td class="title"> 出险时间:</td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensateDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> 时 <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> 分">
    <input type="hidden" name="DamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type="hidden" name="DamageStartHour" value="<bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' />">
    </td>
  </tr>     
  <tr> 
    <td class="title"> 出险地点: </td>
    <td class="input" colspan="3">
    <bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />
    </td>
  </tr>  
  <%@include file="/commonAgri/compensate/AgriCompensateDamageEdit.jsp"%>
  
        <tr>
         <td class="title" style="width:15%">赔付数量:
         </td>
         <td class="input" id="tdLossesNumber"><input type=text name="prpLcompensateLossesNumber"
    class="input" style="width: 80px"
    value="<bean:write name='prpLcompensateDto' property='lossesNumber' filter='true' format="#0.00"/>" onblur="checkStatQuantity(this)">
  <html:select name="prpLcompensateDto" property="lossesUnitCode"
    styleClass="three" style="width:50px">
    <html:options collection="lossesUnitCodeCollection"
      property="codeCode" labelProperty="codeCName" />
  </html:select> <img src="/claim/images/bgMarkMustInput.jpg"></td>
  <td class="title"> 受益户次: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateDamageInsured" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='damageInsured' format='0.00'/>">        
          <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
<logic:equal name="prpLcompensateDto" property="classCode" value="31">
          <tr>
    <td class="title" style="width:15%">受灾面积:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='disasterArea' format='0.00'/>">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> 成灾面积: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='affectedArea' format='0.00'/>">        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
  
          <tr>
 
    <td class="title" style="width:15%">绝产面积:</td>
        <td class="input" colspan="1">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='noProductionArea' format='0.00'/>">        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>  
    <% String restrRiskCode = prpLcompensateDto.getRiskCode();//riskcode
      if("3101".equals(restrRiskCode)||"3107".equals(restrRiskCode)||"3108".equals(restrRiskCode)||"3114".equals(restrRiskCode)||"3122".equals(restrRiskCode)||"3126".equals(restrRiskCode)){%>    
       <td id="tdClaimRelationNoTitle" class="title">理赔清单号：</td>
       <td id="tdClaimRelationNo" class="input">
          <input type="text" name="claimRelationNo"  description="理赔清单号"
          value="<bean:write name='prpLcompensateDto' property='claimRelationNo' />" 
		   onblur="changeRelateListSum(this,fm.riskcode);"> 
		  <input type="button" name="btClaimRelationNo" class="button" style="display:" alt="查询" value="查 询"
          		 onclick="relateListNo(fm.claimRelationNo.value,fm.riskcode.value)" >

       </td>
     <%}else{ %>
     	<td  class="title"></td>
     	<td  class="input"></td>
     <%} %>
  </tr> 
</logic:equal>
<logic:equal name="prpLcompensateDto" property="classCode" value="32">
  <tr>
  <td class="title">扑杀数量: </td>
    <td class="input" id="tdKillQuantity"> 
          <input type=text name="prpLcompensateKillQuantity" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='killQuantity' format='0.00'/>">        
          <html:select name="prpLcompensateDto" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select> 
      </td>
    <td class="title" style="width:15%">死亡数量:</td>
        <td class="input" style="width:35%" id="tdDeathQuantity">
          <input type=text name="prpLcompensateDeathQuantity" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='deathQuantity' format='0.00'/>">        
           <html:select name="prpLcompensateDto" property="deathUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
        </td>
  </tr>
</logic:equal>
    
  <tr>
  <td class="title"> 赔付次数: </td>
    <td class="input"> 
      <input type="text" name="prpLcompensateTimes" class="readonly" readonly value="<bean:write name='prpLcompensateDto' property='times'/>"> 
    </td>
    <td class="title" style="width:15%">已出险次数:</td>
        <td class="input" style="width:35%">
        <%-- 出险信息画面 --%>
           <%@include file="/commonAgri/regist/AgriExistRegist.jsp"%>     
        </td>

  </tr>
  <%   
   String recaseFlag =(String) request.getAttribute("recaseFlag");
  %> 
      <tr> 
      <%if(recaseFlag.equals("0")||editType.equals("SHOW")){%>
    <td class="title" style="width:15%"> 是否自动结案:   </td>
    <td class="input" colspan="3">  
      <input type="radio" onclick="return changeFinallyFlagAndLltextContent();"  name="prpLcompensateFinallyFlag" value="1" <%= !prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>是 
      <input type="radio" onclick="return changeFinallyFlagAndLltextContent();"  name="prpLcompensateFinallyFlag" value="0" <%= prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>否     
    </td>  
    <%}else{%>
    <td class="title" style="width:15%"> 重开赔案是否自动结案</td>
    <td class="input" colspan="3">  
    <input type="hidden" onclick="return changePrpLcompensateFinallyFlag();"  name="prpLcompensateFinallyFlag" value="1" >是 
    <input type="hidden" disabled onclick="return changePrpLcompensateFinallyFlag();"  name="prpLcompensateFinallyFlag" value="0" checked>否
    </td> 
    <%}%> 
    </tr>
  
      <input type="hidden" name="prpLcompensateIndemnityDuty"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">  
      <input type=hidden name="prpLcompensateIndemnityDutyName"  style="width:100px" class="readonly" readonly="true" value=" ">  
      <input type="hidden" name="prpLcompensateIndemnityDutyRate" style="width:100px" class="readonly" readonly="true" value="0">
    
</table>