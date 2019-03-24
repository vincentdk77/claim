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
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<% 
 PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto"); 
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLcompensateDto.getStartHour();
 intendHour    = prpLcompensateDto.getEndHour();
 String restrRiskCode = prpLcompensateDto.getRiskCode();
 String strAppliRiskLevel = "0";//投保人风险等级
 String strInsuredRiskLevel = "0";//被保险人风险等级
 DBPrpDcustomLevelTrace dbPrpDcustomLevelTrace = new DBPrpDcustomLevelTrace();
 DBPrpCcoins dbPrpCcoins=new DBPrpCcoins();
 dbPrpCcoins.getInfo(prpLcompensateDto.getPolicyNo(), "2");
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
 
 String strViewUrl = AppConfig.get("sysconst.GIS_RFFeildView_URL");
 String strReinsWebUrl = AppConfig.get("sysconst.Reins_URL");
%>
<!--modify by liuyanmei add 20051114 end-->    

<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcustomLevelTrace"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@page import="com.sinosoft.prpall.dbsvr.cb.DBPrpCcoins"%>
<script language="javascript">
  function changeZeroLossCaseType(field){
      var zeroLosscaseType = field.value;
      if(zeroLosscaseType == '1'){
          document.getElementById("caseTypeOne").style.display="";
          document.getElementById("caseTypeTwo").style.display="";
          document.getElementById("caseTypeThr").style.display="none";
          document.getElementById("detailReasonOne").style.display="";
          document.getElementById("detailReasonTwo").style.display="";
      }else if(zeroLosscaseType == '2'){
          document.getElementById("caseTypeOne").style.display="";
          document.getElementById("caseTypeTwo").style.display="none"
          document.getElementById("caseTypeThr").style.display="";
          document.getElementById("detailReasonOne").style.display="";
          document.getElementById("detailReasonTwo").style.display="";
      }else{
          document.getElementById("caseTypeOne").style.display="none";
          document.getElementById("caseTypeTwo").style.display="none";
          document.getElementById("caseTypeThr").style.display="none";
          document.getElementById("detailReasonOne").style.display="none";
          document.getElementById("detailReasonTwo").style.display="none";
      }
  
  }
  
  function onLoadZeroLossCaseType(){
      var zeroLosscaseType = fm.prpLcompensateZeroLossType.value;
      if(zeroLosscaseType == '1'){
          document.getElementById("caseTypeOne").style.display="";
          document.getElementById("caseTypeTwo").style.display="";
          document.getElementById("caseTypeThr").style.display="none";
          document.getElementById("detailReasonOne").style.display="";
          document.getElementById("detailReasonTwo").style.display="";
      }else if(zeroLosscaseType == '2'){
          document.getElementById("caseTypeOne").style.display="";
          document.getElementById("caseTypeTwo").style.display="none"
          document.getElementById("caseTypeThr").style.display="";
          document.getElementById("detailReasonOne").style.display="";
          document.getElementById("detailReasonTwo").style.display="";
      }else{
          document.getElementById("caseTypeOne").style.display="none";
          document.getElementById("caseTypeTwo").style.display="none";
          document.getElementById("caseTypeThr").style.display="none";
          document.getElementById("detailReasonOne").style.display="none";
          document.getElementById("detailReasonTwo").style.display="none";
      }

      var coinsFlag = fm.coinsFlag.value ; 
	  if(coinsFlag == "2"||coinsFlag == "1"){
        var coinsPaidLossType = fm.prpLcompensateCoinsPaidLossType.value;
      	if(coinsPaidLossType == "1"){
   		 	document.getElementById("CommonCoinsChargeFee").style.display="";
   		 	fm.CommonCoinsChargeFeeFlag.value = '1';
   	  	}else{
   		 	document.getElementById("CommonCoinsChargeFee").style.display="none";
   		 	fm.CommonCoinsChargeFeeFlag.value = '0';
   	  	}
	  }
  
  }


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



</script>
<script language="javascript">
function viewGis(){
	var url = "<%=strViewUrl %>?RFNO=<%=request.getAttribute("GisRichFlyCode") %>&RegistNO=<%=request.getAttribute("GisRegistNo") %>";
	//alert(url);
   	window.open(url,"地图信息","width=600,height=400,status=yes,menubar=yes,location=yes,resizable=yes,scrollbars=yes");
} 
</script>

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
				%> <td class="formtitle">规模经营主体系统赔款计算书</td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td class="formtitle">扶贫系统赔款计算书</td><% 
			} else {
				%> <td class="formtitle">赔款计算书</td><% 
			}
		} else {
			%> <td class="formtitle">赔款计算书</td><% 
		}
      %>
      
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
  <tr> 
    <td class="title" colspan="2" style="width:100%">赔款计算书 
      <input type="hidden" name="reinsWebUrl" value="<%=strReinsWebUrl%>">
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
   	  <!-- 耳标号所需信息准备 -->
   	  <input type="hidden" name="reportDate" value="<bean:write name="prpLregistDto" property="reportDate" />" >
   	  <input type="hidden" name="damageCode" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />" >
   	  <input type="hidden" name="damageName" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />" >
   	  <input type="hidden" name="provinceCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
   	  
    </td>
    <td class="title">险种名称:</td>
    <td class="title"><%= request.getAttribute("riskCName") %></td>
  </tr>
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
    <td class="input" colspan="3"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
     <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">
    <logic:equal value="1" name="IsDisplayGisViewInfo">
        <input type=button class="button" name="GisViewInfo" value="地图信息" onclick="viewGis();">
     </logic:equal>    
</td>
  </tr>
  <tr> 
    <td class="title"> 保单号: </td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value,fm.registno.value);return false;"> 
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
    <td class="title"> 被保险人: </td>
    <input class="readonly" type="hidden" name="prpLcompensateInsuredName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateInsuredNameShow" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredNameShow' filter='true' />">  
    </td>
    <td class="title"> 投保人单位: </td>    
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateAppliName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='appliName' filter='true' />">
    </td>
  </tr>
  <tr>
    <td class="title"> 被保险人开户银行: </td>    
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateBank"  value="<bean:write name='prpLcompensateDto' property='bank' filter='true' />" > 
    </td>
    <td class="title"> 收款人全称: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateReceiverName"   style="width:250px" value="<bean:write name='prpLcompensateDto' property='receiverName' filter='true' />">
    </td>
  </tr>
  <tr>
	<td class="title">投保人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strAppliRiskLevel  %></b></span></td>
	<td class="title">被保险人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strInsuredRiskLevel  %></b></span></td>
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
      <logic:notEmpty name="coinsSelfRate"  >
      <input type="hidden" name="coinsSelfRate" value="<bean:write name='coinsSelfRate'/>">
      </logic:notEmpty>
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
  <%if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(restrRiskCode) > -1)&&editType.equals("ADD")&&hasHeadInsureList){%>
  <tr>
         <td class="title" style="width:15%">赔付数量:
         </td>
         <td class="input" id="tdLossesNumber"><input type=text name="prpLcompensateLossesNumber"
    class="input" style="width: 80px" readonly>
  <html:select name="prpLcompensateDto" property="lossesUnitCode"
    styleClass="three" style="width:50px">
    <html:options collection="lossesUnitCodeCollection"
      property="codeCode" labelProperty="codeCName" />
  </html:select> <img src="/claim/images/bgMarkMustInput.jpg"></td>
  <td class="title"> 受益户次: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateDamageInsured" class="input" style="width:140px">        
          <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
  <%}else{%>
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
  <%}%>
<logic:equal name="prpLcompensateDto" property="classCode" value="31">
    <%
    if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3151,3197,3152,3153,3154,3155,3156,3224,3190,3191,3172,3194,3193,3187,3178,3158,3179,3176,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196,3163,3183,3180,3168,3169,3182".indexOf(restrRiskCode) > -1)&&editType.equals("ADD")&&hasHeadInsureList){%>
    <tr>
    <td class="title" style="width:15%">受灾面积:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" onchange="checkSettleAreaAndDisasterArea();">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> 成灾面积: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" readonly>        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
          <tr>
    <td class="title" style="width:15%">绝产面积:</td>
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" readonly >        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>  
         <td class="title" style="width:15%">是否涉诉:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" property="" style="width:197px">
              <!--    <option value="0">否</option>
                <option value="1">是</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">否</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">是</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
      <!--  <td  class="title"></td>-->
      <!--  <td  class="input"></td>-->
  </tr> 
  <%}else{%>
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
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='noProductionArea' format='0.00'/>">        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">是否涉诉:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" style="width:197px" >
               <!--  <option value="0">否</option>
                <option value="1">是</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">否</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">是</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
  </tr>
   <%} %>
</logic:equal>

<logic:equal name="prpLcompensateDto" property="classCode" value="32">
    <%
    if(("3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3222,3235,3237".indexOf(restrRiskCode) > -1)&&editType.equals("ADD")&&hasHeadInsureList){%>
    <tr>
    <td class="title" style="width:15%">受灾面积:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" onchange="checkSettleAreaAndDisasterArea();">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> 成灾面积: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" readonly>        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
          <tr>
    <td class="title" style="width:15%">绝产面积:</td>
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" readonly >        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>  
         <td class="title" style="width:15%">是否涉诉:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" property="" style="width:197px">
              <!--    <option value="0">否</option>
                <option value="1">是</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">否</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">是</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
      <!--  <td  class="title"></td>-->
      <!--  <td  class="input"></td>-->
  </tr> 
   <%}else if (!restrRiskCode.equals("3224") && !restrRiskCode.equals("3234") && !restrRiskCode.equals("3240")){%>
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
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='noProductionArea' format='0.00'/>">        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">是否涉诉:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" style="width:197px" >
               <!--  <option value="0">否</option>
                <option value="1">是</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">否</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">是</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
  </tr>
   <%} %>
</logic:equal>

<logic:equal name="prpLcompensateDto" property="riskCode" value="3224">
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
      <td  class="title"></td>
      <td  class="input"></td>
  </tr>

</logic:equal>


<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3228">
<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3224">
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
</logic:notEqual>
</logic:notEqual> 

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
    <td class="input" >  
      <input type="radio" onclick="return changeFinallyFlagAndLltextContent();"  name="prpLcompensateFinallyFlag" value="1" <%= !prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>是 
      <input type="radio" onclick="return changeFinallyFlagAndLltextContent();"  name="prpLcompensateFinallyFlag" value="0" <%= prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>否     
    </td>  
    <%}else{%>
    <td class="title" style="width:15%"> 重开赔案是否自动结案</td>
    <td class="input" >  
    <input type="radio" onclick="return changePrpLcompensateFinallyFlag();"  name="prpLcompensateFinallyFlag" value="1" checked>是 
    <input type="radio" onclick="return changePrpLcompensateFinallyFlag();"  name="prpLcompensateFinallyFlag" value="0" >否
    </td> 
    <%}%> 
    
        <td class="title"> 零赔付原因: </td>
        <td class="input" colspan="3">
            <select style="width:50%" name="prpLcompensateZeroLossType" id="prpLcompensateZeroLossType" onchange="changeZeroLossCaseType(this)">
                    <option  value="">---- 请选择 ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="1">selected</logic:equal> value="1">注销</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="2">selected</logic:equal> value="2">拒赔</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="3">selected</logic:equal> value="3">正常</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="4">selected</logic:equal> value="4">业务员操作错误</option>
            </select>
        </td>
    </tr>
    <!-- yx 增加理赔公示 -->
    <tr> 
    <td class="title" style="width:15%"> 是否理赔公示:   </td>
    <td class="input" colspan="3">  
      <input type="radio" onclick="return changeClaimNotification();"  name="prpLcompensateClaimNotification" value="1" <%= !prpLcompensateDto.getClaimNotification().equals("0")? "checked":"" %>>是 
      <input type="radio" onclick="return changeClaimNotification();"  name="prpLcompensateClaimNotification" value="0" <%= prpLcompensateDto.getClaimNotification().equals("0")? "checked":"" %>>否     
    </td>  
    </tr>
    <%
    if(("32".indexOf(restrRiskCode.substring(0,1)) > -1)){%>
    
    <tr> 
    <td class="title" style="width:15%"> 是否无公害化处理:   </td>
    <td class="input" colspan="3">  
      <input type="radio" onclick="return changeInncentTreatment();"  name="prpLcompensateInncentTreatment" value="1" <%= !prpLcompensateDto.getInncentTreatment().equals("0")? "checked":"" %>>是 
      <input type="radio" onclick="return changeInncentTreatment();"  name="prpLcompensateInncentTreatment" value="0" <%= prpLcompensateDto.getInncentTreatment().equals("0")? "checked":"" %>>否     
    </td>  
    </tr>
    <% } %>
    
    <tr> 
        <td class="title" id="caseTypeOne" style="display:none"> 注销拒赔类型: </td>
        <td class="input" id="caseTypeTwo" colspan="3" style="display:none">
            <select style="width:20%" name="prpLcompensateZeroLossCaseType" id="prpLcompensateZeroLossCaseType">
                    <option  value="">---- 请选择 ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="1">selected</logic:equal> value="1">客户报错案</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="2">selected</logic:equal> value="2">客户重复报案</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="3">selected</logic:equal> value="3">不属于投保险别出险</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="4">selected</logic:equal> value="4">不属于投保险种出险</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="5">selected</logic:equal> value="5">业务员操作错误</option>
            </select>
        </td>
        <td class="input" colspan="3" id="caseTypeThr" style="display:none">
            <select style="width:20%" name="prpLcompensateExclusionsType">
                    <option value="0">不属于保险责任</option>
            </select>
        </td> 
    </tr>
<logic:notEmpty name="coinsFlag"  >
  <logic:equal name='coinsFlag' value="2">
    <tr>
  <td class="title"> 共保赔付类型: </td>
    <td class="input" colspan="1"> 
       <select name="prpLcompensateCoinsPaidLossType" class="common3" style="width:51%"  description="共保赔付类型" 
          onChange="changeCoinsSumPaid();">
          <option value=""  <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="">selected</logic:equal>>请选择</option>
          <option value="1" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="1">selected</logic:equal>>按赔案100%赔付</option>
          <option value="2" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="2">selected</logic:equal>>按我方共保份额赔付</option>
        </select> 
    </td>
    <%if(dbPrpCcoins!=null){
    if(dbPrpCcoins.getCoinsTreatyNo()!=null&&!"".equals(dbPrpCcoins.getCoinsTreatyNo())){%>
  <td class="title"> 共保协议号: </td>
    <td class="input"> <input class="readonly" type=text name="CoinsTreatyNo" readonly="true"  style="width:80px" value="<%=dbPrpCcoins.getCoinsTreatyNo()%>">  
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relateCoinsTreatyNo(fm.CoinsTreatyNo.value);return false;"> 
    </td>
    <%}else{%>
    <td class="title"></td>
    <td class="input" > 
    </td>
    <%}}else{%>
    <td class="title"></td>
    <td class="input" > 
    </td>
    <%}%>
      </tr>  
  </logic:equal>
  <logic:equal name='coinsFlag' value="1">
    <tr>
  <td class="title"> 共保赔付类型: </td>
    <td class="input" colspan="1"> 
       <select name="prpLcompensateCoinsPaidLossType" class="common3" style="width:51%"  description="共保赔付类型" 
          onChange="changeCoinsSumPaid();">
          <option value=""  <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="">selected</logic:equal>>请选择</option>
          <option value="1" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="1">selected</logic:equal>>按赔案100%赔付</option>
          <option value="2" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="2">selected</logic:equal>>按我方共保份额赔付</option>
        </select> 
    </td>
    <%if(dbPrpCcoins!=null){
    if(dbPrpCcoins.getCoinsTreatyNo()!=null&&!"".equals(dbPrpCcoins.getCoinsTreatyNo())){%>
  <td class="title"> 共保协议号: </td>
    <td class="input"> <input class="readonly" type=text name="CoinsTreatyNo" readonly="true"  style="width:80px" value="<%=dbPrpCcoins.getCoinsTreatyNo()%>">  
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relateCoinsTreatyNo(fm.CoinsTreatyNo.value);return false;"> 
    </td>
    <%}else{%>
    <td class="title"></td>
    <td class="input" > 
    </td>
    <%}}else{%>
    <td class="title"></td>
    <td class="input" > 
    </td>
    <%}%>
      </tr>  
  </logic:equal>
</logic:notEmpty>  
    <tr>
        <td class="title" id="detailReasonOne" colspan="4" style="display:none">详细原因：</td>
    </tr>
    <tr>
        <td class="input" id="detailReasonTwo" colspan="4" align="center" style="display:none">
             <textarea name='prpLcompensateDetailReason' wrap="hard" rows=10 cols=80 class=common ><bean:write name='prpLcompensateDto' property='zeroLossDetailReason' filter='true' /></textarea>
         </td>
   </tr> 
      <input type="hidden" name="prpLcompensateIndemnityDuty"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">  
      <input type=hidden name="prpLcompensateIndemnityDutyName"  style="width:100px" class="readonly" readonly="true" value=" ">  
      <input type="hidden" name="prpLcompensateIndemnityDutyRate" style="width:100px" class="readonly" readonly="true" value="0">
    
</table>