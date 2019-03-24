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
<%@ page import="com.gyic.claim.dto.domain.*" %>
<%@page import="java.util.*"%>
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
    </tr>
    </table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr> 
    <td class="title" colspan="2" style="width:100%">赔款计算书 
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
    </td>
    <td class="title">险种名称:</td>
    <td class="title"><%= request.getAttribute("riskCName") %></td>
  </tr>
  <%
    PrplcombineSwfLogDto swfLogDto3=null;
    PrplcombineSwfLogDto swfLogDto2 = (PrplcombineSwfLogDto)request.getAttribute("swfLogDto"); 
    swfLogDto3 = (PrplcombineSwfLogDto) ((ArrayList)swfLogDto2.getSwfLogList()).get(0);
  %>
  <tr> 
    <td class="title">事故号: </td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateCombineNo" readonly="true"  style="width:150px" value="<%=swfLogDto3.getCombineno()%>">   
    </td>
    <td class="title"> 保单号: </td>
    <td class="input"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value,fm.registno.value);return false;"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 被保险人: </td>
    <input class="readonly" type="hidden" name="prpLcompensateInsuredName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateInsuredNameShow" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredNameShow' filter='true' />">  
    </td>
    <td class="title"> 投保人单位: </td>    
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateAppliName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='appliName' filter='true' />">
    </td>
  </tr>
  <tr>
	<td class="title">投保人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strAppliRiskLevel%></b></span></td>
	<td class="title">被保险人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strInsuredRiskLevel%></b></span></td>
  </tr>
  <tr> 
    <td class="title"> 业务来源: </td>
    <td class="input">
    <logic:equal name="prpLcompensateDto" property="businessNature" value="0">
    直接业务
    </logic:equal>
    <logic:notEqual name="prpLcompensateDto" property="businessNature" value="0">
    代理业务
    </logic:notEqual>
    </td>
    <td class="title"> 保险期间: </td>
    <td class="input">
     <input type=text name="prpLcompensateStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> <%=startHour%> <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> <%=endHour%>">   
    </td>
  </tr> 
  <tr> 
    <td class="title"> 币别: </td>
    <td class="input">
    <bean:write name='prpLcompensateDto' property='currency' filter='true' />
    </td>
    <td class="title"> 保险金额: </td>
    <td class="input"><bean:write name='prpLcompensateDto' property='sumAmount' filter='true' format='#0.00'/>
    </td>
  </tr> 
  
      <input type="hidden" name="prpLcompensateIndemnityDuty"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">  
      <input type=hidden name="prpLcompensateIndemnityDutyName"  style="width:100px" class="readonly" readonly="true" value=" ">  
      <input type="hidden" name="prpLcompensateIndemnityDutyRate" style="width:100px" class="readonly" readonly="true" value="0">
    
</table>