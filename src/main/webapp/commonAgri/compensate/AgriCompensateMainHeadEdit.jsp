<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��Head[ ʵ�� ]
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
 String strAppliRiskLevel = "0";//Ͷ���˷��յȼ�
 String strInsuredRiskLevel = "0";//�������˷��յȼ�
 DBPrpDcustomLevelTrace dbPrpDcustomLevelTrace = new DBPrpDcustomLevelTrace();
 DBPrpCcoins dbPrpCcoins=new DBPrpCcoins();
 dbPrpCcoins.getInfo(prpLcompensateDto.getPolicyNo(), "2");
 //�ͻ����յȼ�
 //businessType��TΪͶ������CΪ����
	//insuredFlag��1Ϊ�������ˣ�2ΪͶ����
 strAppliRiskLevel = dbPrpDcustomLevelTrace.findRiskLevelByKey(prpLcompensateDto.getPolicyNo(),"2","C");//Ͷ���˷��յȼ�
 strInsuredRiskLevel = dbPrpDcustomLevelTrace.findRiskLevelByKey(prpLcompensateDto.getPolicyNo(),"1","C");//�������˷��յȼ�
 BLPrpDcode blPrpDcodetem = new BLPrpDcode();
	//ת����
 strAppliRiskLevel = blPrpDcodetem.translateCode("RiskLevel",strAppliRiskLevel,true);
 strInsuredRiskLevel = blPrpDcodetem.translateCode("RiskLevel",strInsuredRiskLevel,true);
 
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
	              alert("���������֧���ʺŲ�һ�£�����������!");
				  fm.prpLcompensateAccount.value="";
				  fm.prpLcompensateAccountOK.value="";
				  fm.prpLcompensateAccount.focus();
         }
    }
    
    
    function changePrpLcompensateFinallyFlag(){
    //���ڷ����һ�ż��������˵�������������˵���������Ƚ�������˵����
    //modify by lixiang start at 2006-8-1
    //reason:���㱨����������"������������"
    if(fm.prpLcompensateFinallyFlag[0].checked){
       Lltext.style.display="";
       fm.tdLltextTitle.value="���㱨��";
       
    }else{
        Lltext.style.display="";
        fm.tdLltextTitle.value="��������˵��";
      }
    }
    
   function changeFinallyFlagAndLltextContent(){
    
        //���ڷ����һ�ż��������˵�������������˵���������Ƚ�������˵����
        //modify by lixiang start at 2006-8-1
        //reason:���㱨����������"������������"
         var strtemp="";
        if(fm.prpLcompensateFinallyFlag[0].checked){
          Lltext.style.display="";
          fm.tdLltextTitle.value="���㱨��";
          strtemp=fm.backLltextContent.value;
          fm.backLltextContent.value=fm.prpLltextContextInnerHTML.value;//�������ڵ�����
          fm.prpLltextContextInnerHTML.value=strtemp;
        }else{
          Lltext.style.display="";
          fm.tdLltextTitle.value="��������˵��";
          strtemp=fm.backLltextContent.value;
          fm.backLltextContent.value=fm.prpLltextContextInnerHTML.value;//�������ڵ�����
          fm.prpLltextContextInnerHTML.value=strtemp;
        }
    }



</script>
<script language="javascript">
function viewGis(){
	var url = "<%=strViewUrl %>?RFNO=<%=request.getAttribute("GisRichFlyCode") %>&RegistNO=<%=request.getAttribute("GisRegistNo") %>";
	//alert(url);
   	window.open(url,"��ͼ��Ϣ","width=600,height=400,status=yes,menubar=yes,location=yes,resizable=yes,scrollbars=yes");
} 
</script>

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
				%> <td class="formtitle">��ģ��Ӫ����ϵͳ��������</td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td class="formtitle">��ƶϵͳ��������</td><% 
			} else {
				%> <td class="formtitle">��������</td><% 
			}
		} else {
			%> <td class="formtitle">��������</td><% 
		}
      %>
      
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
       <td><input type="button" name="prpLmessageSave" value="���⹵ͨ" class="bigbutton" onclick="openWinSaveQuery(fm.prpLcompensateClaimNo.value,fm.prpLcompensatePolicyNo.value,fm.prpLcompensateRiskCode.value,'compe',fm.prpLcompensateClaimNo.value,'claimNo',fm.prpLcompensateClaimNo.value)"></td>
       <td><input type="button" name="eCertify" class="bigbutton" value="��֤�ϴ�" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcompensateDto' property='registNo'/>','compe');"></td> 
       <td width="70%" align="right"><font color="#666666">��ע:��<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr> 
    <td class="title" colspan="2" style="width:100%">�������� 
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
      <input type="hidden" name="prpLcompensateStartDate"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> �� 0 ʱ �� <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> �� 24 ʱֹ">

      <input type="hidden" name="prpLcompensateClauseName"  value="<bean:write name='prpLcompensateDto' property='clauseName' filter='true' />">  
      <input type="hidden" name="prpLcompensateLicenseNo"  value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />"> 
      <input type="hidden" name="prpLcompensateCarKind" value="<bean:write name='prpLcompensateDto' property='carKind' filter='true' />">  
      <input type="hidden" name="prpLcompensateLicenseColor" value="<bean:write name='prpLcompensateDto' property='licenseColor' filter='true' />"> 
      <input type="hidden" name="prpLcompensateBrandName" value="<bean:write name='prpLcompensateDto' property='brandName' filter='true' />"> 
      <input type="hidden" name="prpLcompensateEngineNo" value="<bean:write name='prpLcompensateDto' property='engineNo'/>"> 
      <input type="hidden" name="prpLcompensateFrameNo" value="<bean:write name='prpLcompensateDto' property='frameNo'/>"> 
      <input type="hidden" name="prpLcompensateDamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> ��">
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
   	  <!-- �����������Ϣ׼�� -->
   	  <input type="hidden" name="reportDate" value="<bean:write name="prpLregistDto" property="reportDate" />" >
   	  <input type="hidden" name="damageCode" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />" >
   	  <input type="hidden" name="damageName" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />" >
   	  <input type="hidden" name="provinceCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
   	  
    </td>
    <td class="title">��������:</td>
    <td class="title"><%= request.getAttribute("riskCName") %></td>
  </tr>
  <tr> 
    <td class="title"  style="width:14%"> �������:</td>
    <td class="input"  style="width:36%"> <input type=text name="prpLcompensateCompensateNo" title="�������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
    </td>
    <td class="title"  style="width:14%"> </td>
    <td class="input"  style="width:36%"><input type=hidden name="LFlag" title="��������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='LFlag' />"> 
    </td> 
  </tr> 
  <tr> 
    <td class="title"> ������: </td>
    <td class="input" colspan="3"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
     <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
    <logic:equal value="1" name="IsDisplayGisViewInfo">
        <input type=button class="button" name="GisViewInfo" value="��ͼ��Ϣ" onclick="viewGis();">
     </logic:equal>    
</td>
  </tr>
  <tr> 
    <td class="title"> ������: </td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value,fm.registno.value);return false;"> 
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
    <td class="title"> ��������: </td>
    <input class="readonly" type="hidden" name="prpLcompensateInsuredName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateInsuredNameShow" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredNameShow' filter='true' />">  
    </td>
    <td class="title"> Ͷ���˵�λ: </td>    
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateAppliName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='appliName' filter='true' />">
    </td>
  </tr>
  <tr>
    <td class="title"> �������˿�������: </td>    
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateBank"  value="<bean:write name='prpLcompensateDto' property='bank' filter='true' />" > 
    </td>
    <td class="title"> �տ���ȫ��: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateReceiverName"   style="width:250px" value="<bean:write name='prpLcompensateDto' property='receiverName' filter='true' />">
    </td>
  </tr>
  <tr>
	<td class="title">Ͷ���˷��յȼ�</td>
	<td class="input"><span style="color: red;"><b><%=strAppliRiskLevel  %></b></span></td>
	<td class="title">�������˷��յȼ�</td>
	<td class="input"><span style="color: red;"><b><%=strInsuredRiskLevel  %></b></span></td>
  </tr>
  
  <%
    String status = (String)request.getParameter("status");
    if("4".equals(status)||editType.equals("SHOW")){
  %>
    <tr>     
    <td class="title"> �����ʺ�: </td>
    <td class="input" colspan="1"> <input class="readonly" type=text name="prpLcompensateAccount"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />"> 
    </td>
    <td class="title"> </td>
    <td class="input" colspan="1"></td>
  </tr>     
    <%}else {
    %>
  <tr>     
    <td class="title"> �����ʺ�: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateAccount"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />"> 
    </td>
    <td class="title"> ���ٴ�ȷ�Ͽ����ʺ�: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateAccountOK"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />" onblur="validateAcc()"> 
    </td>
  </tr>
    <%}%> 
  
      <!--modify by qinyongli 2005-07-22 start ���������ٷֺ͹ɶ���Ϣ-->
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
    <td class="title"> ҵ����Դ: </td>
    <td class="input">
    <logic:equal name="prpLcompensateDto" property="businessNature" value="0">
    ֱ��ҵ��
    </logic:equal>
    <logic:notEqual name="prpLcompensateDto" property="businessNature" value="0">
    ����ҵ��
    </logic:notEqual>
    </td>
    <td class="title"> �����ڼ�: </td>
    <td class="input">
     <input type=text name="prpLcompensateStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> <%=startHour%> <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> <%=endHour%>">
    
    </td>
  </tr> 
  <tr> 
    <td class="title"> �ұ�: </td>
    <td class="input">
    <bean:write name='prpLcompensateDto' property='currency' filter='true' />
    </td>
    <td class="title"> ���ս��: </td>
    <td class="input"><bean:write name='prpLcompensateDto' property='sumAmount' filter='true' format='#0.00'/>
    </td>
  </tr> 
  <tr> 
   <td class="title"> ����ʱ��:</td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensateDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> ��">
    <input type="hidden" name="DamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type="hidden" name="DamageStartHour" value="<bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' />">
    </td>
  </tr>     
  <tr> 
    <td class="title"> ���յص�: </td>
    <td class="input" colspan="3">
    <bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />
    </td>
  </tr>  
  <%@include file="/commonAgri/compensate/AgriCompensateDamageEdit.jsp"%>
  <%if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3228,3224,3190,3191,3172,3194,3193,3187,3178,3179,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(restrRiskCode) > -1)&&editType.equals("ADD")&&hasHeadInsureList){%>
  <tr>
         <td class="title" style="width:15%">�⸶����:
         </td>
         <td class="input" id="tdLossesNumber"><input type=text name="prpLcompensateLossesNumber"
    class="input" style="width: 80px" readonly>
  <html:select name="prpLcompensateDto" property="lossesUnitCode"
    styleClass="three" style="width:50px">
    <html:options collection="lossesUnitCodeCollection"
      property="codeCode" labelProperty="codeCName" />
  </html:select> <img src="/claim/images/bgMarkMustInput.jpg"></td>
  <td class="title"> ���滧��: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateDamageInsured" class="input" style="width:140px">        
          <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
  <%}else{%>
        <tr>
         <td class="title" style="width:15%">�⸶����:
         </td>
         <td class="input" id="tdLossesNumber"><input type=text name="prpLcompensateLossesNumber"
    class="input" style="width: 80px"
    value="<bean:write name='prpLcompensateDto' property='lossesNumber' filter='true' format="#0.00"/>" onblur="checkStatQuantity(this)">
  <html:select name="prpLcompensateDto" property="lossesUnitCode"
    styleClass="three" style="width:50px">
    <html:options collection="lossesUnitCodeCollection"
      property="codeCode" labelProperty="codeCName" />
  </html:select> <img src="/claim/images/bgMarkMustInput.jpg"></td>
  <td class="title"> ���滧��: </td>
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
    <td class="title" style="width:15%">�������:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" onchange="checkSettleAreaAndDisasterArea();">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> �������: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" readonly>        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
          <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" readonly >        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>  
         <td class="title" style="width:15%">�Ƿ�����:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" property="" style="width:197px">
              <!--    <option value="0">��</option>
                <option value="1">��</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">��</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">��</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
      <!--  <td  class="title"></td>-->
      <!--  <td  class="input"></td>-->
  </tr> 
  <%}else{%>
  <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='disasterArea' format='0.00'/>">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> �������: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='affectedArea' format='0.00'/>">        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
          <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='noProductionArea' format='0.00'/>">        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">�Ƿ�����:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" style="width:197px" >
               <!--  <option value="0">��</option>
                <option value="1">��</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">��</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">��</option>
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
    <td class="title" style="width:15%">�������:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" onchange="checkSettleAreaAndDisasterArea();">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> �������: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" readonly>        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
          <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" readonly >        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>  
         <td class="title" style="width:15%">�Ƿ�����:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" property="" style="width:197px">
              <!--    <option value="0">��</option>
                <option value="1">��</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">��</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">��</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
      <!--  <td  class="title"></td>-->
      <!--  <td  class="input"></td>-->
  </tr> 
   <%}else if (!restrRiskCode.equals("3224") && !restrRiskCode.equals("3234") && !restrRiskCode.equals("3240")){%>
  <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='disasterArea' format='0.00'/>">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> �������: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='affectedArea' format='0.00'/>">        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
          <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" colspan="0">
          <input type=text name="prpLcompensateNoProductionArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='noProductionArea' format='0.00'/>">        
            <html:select name="prpLcompensateDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">�Ƿ�����:</td>
            <td class="input">
              <select name="prpLcompensateDtoLawsuitFlag" style="width:197px" >
               <!--  <option value="0">��</option>
                <option value="1">��</option> -->
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="0">selected</logic:equal> value="0">��</option>
                <option <logic:equal name="prpLcompensateDto" property="lawsuitFlag"  value="1">selected</logic:equal> value="1">��</option>
              </select>
              <img src="/claim/images/bgMarkMustInput.jpg">
            </td>
  </tr>
   <%} %>
</logic:equal>

<logic:equal name="prpLcompensateDto" property="riskCode" value="3224">
  <tr>
    <td class="title" style="width:15%">�������:</td>
        <td class="input" style="width:35%">
          <input type=text name="prpLcompensateDisasterArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='disasterArea' format='0.00'/>">        
          <html:select name="prpLcompensateDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       <td class="title"> �������: </td>
    <td class="input"> 
          <input type=text name="prpLcompensateAffectedArea" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='affectedArea' format='0.00'/>">        
           <html:select name="prpLcompensateDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
  </tr> 
         <tr>
    <td class="title" style="width:15%">�������:</td>
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
  <td class="title">��ɱ����: </td>
    <td class="input" id="tdKillQuantity"> 
          <input type=text name="prpLcompensateKillQuantity" class="input" style="width:140px" value="<bean:write name='prpLcompensateDto' property='killQuantity' format='0.00'/>">        
          <html:select name="prpLcompensateDto" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select> 
      </td>
    <td class="title" style="width:15%">��������:</td>
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
  <td class="title"> �⸶����: </td>
    <td class="input"> 
      <input type="text" name="prpLcompensateTimes" class="readonly" readonly value="<bean:write name='prpLcompensateDto' property='times'/>"> 
    </td>
    <td class="title" style="width:15%">�ѳ��մ���:</td>
        <td class="input" style="width:35%">
        <%-- ������Ϣ���� --%>
           <%@include file="/commonAgri/regist/AgriExistRegist.jsp"%>     
        </td>

  </tr>
  <%   
   String recaseFlag =(String) request.getAttribute("recaseFlag");
  %> 
      <tr> 
      <%if(recaseFlag.equals("0")||editType.equals("SHOW")){%>
    <td class="title" style="width:15%"> �Ƿ��Զ��᰸:   </td>
    <td class="input" >  
      <input type="radio" onclick="return changeFinallyFlagAndLltextContent();"  name="prpLcompensateFinallyFlag" value="1" <%= !prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>�� 
      <input type="radio" onclick="return changeFinallyFlagAndLltextContent();"  name="prpLcompensateFinallyFlag" value="0" <%= prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>��     
    </td>  
    <%}else{%>
    <td class="title" style="width:15%"> �ؿ��ⰸ�Ƿ��Զ��᰸</td>
    <td class="input" >  
    <input type="radio" onclick="return changePrpLcompensateFinallyFlag();"  name="prpLcompensateFinallyFlag" value="1" checked>�� 
    <input type="radio" onclick="return changePrpLcompensateFinallyFlag();"  name="prpLcompensateFinallyFlag" value="0" >��
    </td> 
    <%}%> 
    
        <td class="title"> ���⸶ԭ��: </td>
        <td class="input" colspan="3">
            <select style="width:50%" name="prpLcompensateZeroLossType" id="prpLcompensateZeroLossType" onchange="changeZeroLossCaseType(this)">
                    <option  value="">---- ��ѡ�� ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="1">selected</logic:equal> value="1">ע��</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="2">selected</logic:equal> value="2">����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="3">selected</logic:equal> value="3">����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="4">selected</logic:equal> value="4">ҵ��Ա��������</option>
            </select>
        </td>
    </tr>
    <!-- yx �������⹫ʾ -->
    <tr> 
    <td class="title" style="width:15%"> �Ƿ����⹫ʾ:   </td>
    <td class="input" colspan="3">  
      <input type="radio" onclick="return changeClaimNotification();"  name="prpLcompensateClaimNotification" value="1" <%= !prpLcompensateDto.getClaimNotification().equals("0")? "checked":"" %>>�� 
      <input type="radio" onclick="return changeClaimNotification();"  name="prpLcompensateClaimNotification" value="0" <%= prpLcompensateDto.getClaimNotification().equals("0")? "checked":"" %>>��     
    </td>  
    </tr>
    <%
    if(("32".indexOf(restrRiskCode.substring(0,1)) > -1)){%>
    
    <tr> 
    <td class="title" style="width:15%"> �Ƿ��޹���������:   </td>
    <td class="input" colspan="3">  
      <input type="radio" onclick="return changeInncentTreatment();"  name="prpLcompensateInncentTreatment" value="1" <%= !prpLcompensateDto.getInncentTreatment().equals("0")? "checked":"" %>>�� 
      <input type="radio" onclick="return changeInncentTreatment();"  name="prpLcompensateInncentTreatment" value="0" <%= prpLcompensateDto.getInncentTreatment().equals("0")? "checked":"" %>>��     
    </td>  
    </tr>
    <% } %>
    
    <tr> 
        <td class="title" id="caseTypeOne" style="display:none"> ע����������: </td>
        <td class="input" id="caseTypeTwo" colspan="3" style="display:none">
            <select style="width:20%" name="prpLcompensateZeroLossCaseType" id="prpLcompensateZeroLossCaseType">
                    <option  value="">---- ��ѡ�� ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="1">selected</logic:equal> value="1">�ͻ�����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="2">selected</logic:equal> value="2">�ͻ��ظ�����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="3">selected</logic:equal> value="3">������Ͷ���ձ����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="4">selected</logic:equal> value="4">������Ͷ�����ֳ���</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="5">selected</logic:equal> value="5">ҵ��Ա��������</option>
            </select>
        </td>
        <td class="input" colspan="3" id="caseTypeThr" style="display:none">
            <select style="width:20%" name="prpLcompensateExclusionsType">
                    <option value="0">�����ڱ�������</option>
            </select>
        </td> 
    </tr>
<logic:notEmpty name="coinsFlag"  >
  <logic:equal name='coinsFlag' value="2">
    <tr>
  <td class="title"> �����⸶����: </td>
    <td class="input" colspan="1"> 
       <select name="prpLcompensateCoinsPaidLossType" class="common3" style="width:51%"  description="�����⸶����" 
          onChange="changeCoinsSumPaid();">
          <option value=""  <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="">selected</logic:equal>>��ѡ��</option>
          <option value="1" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="1">selected</logic:equal>>���ⰸ100%�⸶</option>
          <option value="2" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="2">selected</logic:equal>>���ҷ������ݶ��⸶</option>
        </select> 
    </td>
    <%if(dbPrpCcoins!=null){
    if(dbPrpCcoins.getCoinsTreatyNo()!=null&&!"".equals(dbPrpCcoins.getCoinsTreatyNo())){%>
  <td class="title"> ����Э���: </td>
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
  <td class="title"> �����⸶����: </td>
    <td class="input" colspan="1"> 
       <select name="prpLcompensateCoinsPaidLossType" class="common3" style="width:51%"  description="�����⸶����" 
          onChange="changeCoinsSumPaid();">
          <option value=""  <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="">selected</logic:equal>>��ѡ��</option>
          <option value="1" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="1">selected</logic:equal>>���ⰸ100%�⸶</option>
          <option value="2" <logic:equal name="prpLcompensateDto" property="coinsPaidLossType" value="2">selected</logic:equal>>���ҷ������ݶ��⸶</option>
        </select> 
    </td>
    <%if(dbPrpCcoins!=null){
    if(dbPrpCcoins.getCoinsTreatyNo()!=null&&!"".equals(dbPrpCcoins.getCoinsTreatyNo())){%>
  <td class="title"> ����Э���: </td>
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
        <td class="title" id="detailReasonOne" colspan="4" style="display:none">��ϸԭ��</td>
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