<%--
****************************************************************************
* DESC       :添加主信息子块界面页面Head[ 实赔 ]
* AUTHOR     : liubvo
* CREATEDATE : 2004-05-12
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%
 //取核心系统的地址
 String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");

PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto");
 String recaseFlag =(String) request.getAttribute("recaseFlag");
 
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
%>

<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcustomLevelTrace"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcompensateDto"%>
<script language="javascript">
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
</script>
<script language="javascript">
<!--
function changePrpLcompensateFinallyFlag(){
    //modify by lixiang start at 2006-8-1
    //reason:理算报告用来保存"后续理算内容"
    if(fm.prpLcompensateFinallyFlag[0].checked){
       Lltext.style.display="";
       fm.tdLltextTitle.value="理算报告";
        //Lltext.style.display="";
    }else{
    
        Lltext.style.display="";
        fm.tdLltextTitle.value="后续理算说明";
        //Lltext.style.display="none";
      }
    }
   function changeFinallyFlagAndLltextContent(){
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
<table  border="0" align="center" cellpadding="4" cellspacing="1"  class="title" width="100%">
  <tr> 
    <td class="title" colspan="2" >赔款计算书 
      <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
      <input type="hidden" name="prpLcompensateCaseNo" value="<bean:write name='prpLcompensateDto' property='caseNo' />"> 
      
      <input type="hidden" name="prpLcompensateClassCode" value="<bean:write name='prpLcompensateDto' property='classCode' />"> 
      <input type="hidden" name="prpLcompensateRiskCode" value="<bean:write name='prpLcompensateDto' property='riskCode' />"> 
      <input type="hidden" name="prpLcompensateDeductCond" value="<bean:write name='prpLcompensateDto' property='deductCond' />"> 
      <input type="hidden" name="prpLcompensatePreserveDate" value="<bean:write name='prpLcompensateDto' property='preserveDate' />"> 
      <input type="hidden" name="prpLcompensateCheckAgentCode" value="<bean:write name='prpLcompensateDto' property='checkAgentCode' />"> 
      <input type="hidden" name="prpLcompensateCheckAgentName" value="<bean:write name='prpLcompensateDto' property='checkAgentName' />"> 
      <input type="hidden" name="prpLcompensateSurveyorName" value="<bean:write name='prpLcompensateDto' property='surveyorName' />"> 
      <!--<input type="hidden" name="prpLcompensateCounterClaimerName" value="<bean:write name='prpLcompensateDto' property='counterClaimerName' />"> -->
      <input type="hidden" name="prpLcompensateDutyDescription" value="<bean:write name='prpLcompensateDto' property='dutyDescription' />"> 
      <input type="hidden" name="prpLcompensateCurrency" value="<bean:write name='prpLcompensateDto' property='currency' />"> 
      <input type="hidden" name="prpLcompensateSumLoss" value="<bean:write name='prpLcompensateDto' property='sumLoss' />"> 
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
      <input type="hidden" name="riskCode" value="<bean:write name='prpLcompensateDto' property='riskCode' />"> 
      <input type="hidden" name="policyno" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />"> 
      <input type="hidden" name="registno" value="<bean:write name='prpLcompensateDto' property='registNo' filter='true' />"> 
      <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
      <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
      <input type="hidden" name="status" value="<%= request.getParameter("status") %>">
      <input type="hidden" name="clauseType"  value=""> 
      <input type="hidden" name="GenerateCompensateFlag" value="0"> 
      <input type="hidden" name='payFee' value="<%=request.getAttribute("payFlag")%>">
      <input type="hidden" name='delinquentfeeCase' value="<bean:write name='delinquentfeeCase'/>">          
      
      <input type="hidden" name="prpLcompensateCaseType"  value="">
      <input type="hidden" name="prpLcompensateStartDate"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> 日 0 时 至 <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> 日 24 时止">

      <input type="hidden" name="prpLcompensateClauseType"  value="<bean:write name='prpLcompensateDto' property='clauseType' filter='true' />"> 
       
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
      <input type="hidden" name="damageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
     <input type="hidden" name="sumPaidAll" value="<bean:write name='prpLcompensateDto' property='sumPaidAll' filter='true' />">
     <input type="hidden" name="provinceCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
     <!--modify by qinyongli 2005-07-21 start 增加 股东业务信息-->
      <logic:notEmpty name="shareHolderFlag"  >
      <input type="hidden" name="shareHolderFlag" value="<bean:write name='shareHolderFlag'/>">
      </logic:notEmpty>
      <logic:empty name="shareHolderFlag"  >
      <input type="hidden" name="shareHolderFlag" value="0">
      </logic:empty>
      <!--modify by qinyongli 2005-07-21 end-->
    </td>
    <td class="title">险种名称:</td>
    <td class="title"><%= request.getAttribute("riskCName") %></td>
  </tr>
  <tr> 
    <td class="title"  > 计算书号:</td>
    <td class="input"  style="width:36%"> <input type=text name="prpLcompensateCompensateNo" title="计算书号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
    </td>
    <td class="title"  > </td>
    <td class="input"  style="width:36%"><input type=hidden name="LFlag" title="理赔类型" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='LFlag' />"> 
    </td> 
  </tr> 
  <tr> 
    <td class="title"> 立案号: </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"   value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
    <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">
  
    </td>
    <td class="title"> 保单号: </td>
    <td class="input"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value);return false;"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 被保险人: </td>
    <td class="input" > <input class="readonly" type=text name="prpLcompensateInsuredName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
    </td>
    <td class="title">赔付对象: </td>
    <td class="input" > <input class="common" type=text name="prpLcompensateCounterclaimername" style="width:70%"
        title="赔付对象" value="<bean:write name='prpLcompensateDto' property='counterClaimerName' filter='true' />">  
    </td>
  </tr>
  <tr>
   <!--added by zhangli 2007-04-19-->
    <td class="title"> 被保险人开户银行: </td>    
    <td class="input" colspan="1" width=50> <input class="input" type=text name="prpLcompensateBank"  value="<bean:write name='prpLcompensateDto' property='bank' filter='true' />" > 
    </td>
    <td class="title"></td>
    <td class="title"></td>
  </tr>
  <tr>
	<td class="title">投保人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strAppliRiskLevel  %></b></span></td>
	<td class="title">被保险人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strInsuredRiskLevel  %></b></span></td>
  </tr>
   <%
      String status = (String)request.getParameter("status");
  //   String editType = (String)request.getAttribute("editType");
  //    System.out.println("********************zhangli****************************"+editType);
  //  if(status.equals("4")){
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
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateAccountOK"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />" onblur="validateAccount()"> 
    </td>
  </tr> 
  <%}%>
  <tr>
    <td class="title"> 收款人全称: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateReceiverName"   style="width:250px" value="<bean:write name='prpLcompensateDto' property='receiverName' filter='true' />">
    </td>
 
   <!--added by zhangli 2007-04-19-->
    <td class="title"></td>    
    <td class="input" colspan="1"> </td>
  </tr>
  <!--
  <tr> 
    <td class="title"> 币别: </td>
    <td class="input"> 
      <input class="readonly" readonly name="prpLcompensateCurrencyName" value="人民币">
    </td>
    <td class="title"> 案件性质: </td>
    <td class="input"> 
      <input class="readonly" type=text name="prpLcompensateCaseTypeName" readonly="true"   value="<bean:write name='prpLcompensateDto' property='caseTypeName' filter='true' />"
    </td>
  </tr>
  -->
  <tr>
  <td class="title"> 赔付次数: </td>
    <td class="input"> 
      <input type="text" name="prpLcompensateTimes" class="readonly" readonly value="<bean:write name='prpLcompensateDto' property='times' />"> 
    </td>
    
    <td class="title" >已出险次数:</td>
        <td class="input" >
        <%-- 出险信息画面 --%>
           <%@include file="/common/regist/ExistRegist.jsp"%>     
        </td>

  </tr> 
  
  
      <tr> 
      <%if(recaseFlag.equals("0")||editType.equals("SHOW")){%>
    <td class="title" > 是否自动结案:   </td>
    <td class="input" colspan="3" >  
    <input type="radio"  name="prpLcompensateFinallyFlag" onclick="return changeFinallyFlagAndLltextContent();" value="1" <%= !prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>是 
    <input type="radio"  name="prpLcompensateFinallyFlag" onclick="return changeFinallyFlagAndLltextContent();" value="0" <%= prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>否
    </td>  
    <%}else{%>
    <td class="title" > 重开赔案是否自动结案</td>
    <td class="input" >  
    <input type="radio"  name="prpLcompensateFinallyFlag" value="1" >是 
    <input type="radio"  disabled name="prpLcompensateFinallyFlag" value="0" checked>否
    </td>  
    <%}%>
    </tr>
    
      <input type="hidden" name="prpLcompensateIndemnityDuty"   class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">  
      <input type=hidden name="prpLcompensateIndemnityDutyName"   class="readonly" readonly="true" value=" ">  
      <input type="hidden" name="prpLcompensateIndemnityDutyRate"  class="readonly" readonly="true" value="0">
    
</table>
