<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��Head[ ʵ�� ] 
* AUTHOR     : liubvo
* CREATEDATE : 2004-05-12
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLcompensateDto"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcustomLevelTrace"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%
	//ȡ����ϵͳ�ĵ�ַ
	String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
    String strReinsWebUrl = AppConfig.get("sysconst.Reins_URL");
	PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto");
	String restrRiskCode = prpLcompensateDto.getRiskCode();//�����
	String strAppliRiskLevel = "0";//Ͷ���˷��յȼ�
	String strInsuredRiskLevel = "0";//�������˷��յȼ�
	DBPrpDcustomLevelTrace dbPrpDcustomLevelTrace = new DBPrpDcustomLevelTrace();
	String registNoSH = prpLcompensateDto.getRegistNo();
	String SHcomCode = registNoSH.substring(5,7);
	//�ͻ����յȼ�
	//businessType��TΪͶ������CΪ����
	//insuredFlag��1Ϊ�������ˣ�2ΪͶ����
	strAppliRiskLevel = dbPrpDcustomLevelTrace.findRiskLevelByKey(prpLcompensateDto.getPolicyNo(),"2","C");//Ͷ���˷��յȼ�
	strInsuredRiskLevel = dbPrpDcustomLevelTrace.findRiskLevelByKey(prpLcompensateDto.getPolicyNo(),"1","C");//�������˷��յȼ�
	BLPrpDcode blPrpDcodetem = new BLPrpDcode();
	DBPrpCcoins dbPrpCcoins=new DBPrpCcoins();
	dbPrpCcoins.getInfo(prpLcompensateDto.getPolicyNo(), "2");
//ת����
 strAppliRiskLevel = blPrpDcodetem.translateCode("RiskLevel",strAppliRiskLevel,true);
 strInsuredRiskLevel = blPrpDcodetem.translateCode("RiskLevel",strInsuredRiskLevel,true);
%>
 
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
      var zeroLosscaseType = document.getElementById("prpLcompensateZeroLossType").value;
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
	/**
	 *@description ���ղ�ѯ��ť����ҳ��
	 *@param       actionName ����ô��ڵ�action����
	 *@param       paraName  ������
	 *@param       registNo  ������
	 *@param       registNo  �ڵ����
	 */
	function openDanger(registNo,claimNo){
		var win;
		var messagedo="/claim/queryAcciPerson.do?editType=queryAcciPerson&registNo="+registNo+"&claimNo="+claimNo;
		win=window.open(messagedo,"NewWindow","status=no,resizable=yes,scrollbars=yes,width=700,Height=500");
	}
</script>

    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
       <td width="30%">
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr>
              <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
              <td class="formtitle">��������</td>
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
       <td><input type="button" name="prpLmessageSave" class='bigbutton' value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLcompensateClaimNo.value,fm.prpLcompensatePolicyNo.value,fm.prpLcompensateRiskCode.value,'compe',fm.prpLcompensateClaimNo.value,'claimNo',fm.prpLcompensateClaimNo.value)"></td>
       <%-- add by xiatian  --%>
       <td><input type="button" name="eCertify" class="bigbutton" value="��֤�ϴ�" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLclaimDto' property='registNo'/>','compe');"></td> 
	   <!-- add by wxy 20180724 ɽ��ʡ�����շ�����Ϣ��ѯ -->
<% //TODO  %>
<%	if("37".equals(SHcomCode)){ %>
       <td><input type="button" name="dangerCheck" class="bigbutton" value="���ղ�ѯ" 
       		onClick="openDanger('<bean:write name='prpLclaimDto' property='registNo'/>',
       				'<bean:write name='prpLclaimDto' property='claimNo'/>');">
       </td> 
<%	} %>
       <td width="70%" align="right"><font color="#666666">��ע:��<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">��
      Ϊ˫��ѡ���</font></td>
    </tr>
    </table>
<table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
  <tr>
    <td class="title" colspan="2" style="width:100%">��������
      <input type="hidden" name="prpLcompensateCaseNo" value="<bean:write name='prpLcompensateDto' property='caseNo' />">

      <input type="hidden" name="GenerateCompensateFlag" value="0">
      <input type="hidden" name="SHcomCode" value="<%=SHcomCode%>">
      <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
      <input type="hidden" name="reinsWebUrl" value="<%=strReinsWebUrl%>">
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
      <input type="hidden" name="prpLcompensateSumRest" value="<bean:write name='prpLcompensateDto' property='sumRest' />">
       <!-- <input type="hidden" name="prpLcompensateReceiverName" value="<bean:write name='prpLcompensateDto' property='receiverName' />">
      <input type="hidden" name="prpLcompensateBank" value="<bean:write name='prpLcompensateDto' property='bank' />">
      <input type="hidden" name="prpLcompensateAccount" value="<bean:write name='prpLcompensateDto' property='account' />">-->
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
      <input type="hidden" name="prpLcompensateStartDate"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> �� 0 ʱ �� <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> �� 24 ʱֹ">
      <input type="hidden" name="checkFlag" value="<%= request.getAttribute("checkFlag12") %>">
      <input type="hidden" name="prpLcompensateClauseName"  value="<bean:write name='prpLcompensateDto' property='clauseName' filter='true' />">
      <input type="hidden" name="prpLcompensateLicenseNo"  value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />">
      <input type="hidden" name="prpLcompensateCarKind" value="<bean:write name='prpLcompensateDto' property='carKind' filter='true' />">
      <input type="hidden" name="prpLcompensateLicenseColor" value="<bean:write name='prpLcompensateDto' property='licenseColor' filter='true' />">
      <input type="hidden" name="prpLcompensateBrandName" value="<bean:write name='prpLcompensateDto' property='brandName' filter='true' />">
      <input type="hidden" name="prpLcompensateEngineNo" value="<bean:write name='prpLcompensateDto' property='engineNo'/>">
      <input type="hidden" name="prpLcompensateFrameNo" value="<bean:write name='prpLcompensateDto' property='frameNo'/>">
      <input type="hidden" name="prpLcompensateDamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> ��">
      <input type="hidden" name="prpLcompensateDamageAddress" value="<bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />">
      <input type="hidden" name="prpLcompensateBusinessType1" value="<bean:write name='prpLcompensateDto' property='businessType1' filter='true' />"> 
      <input type="hidden" name="prpLcompensateSumAmount" value="<bean:write name='prpLcompensateDto' property='sumAmount' filter='true' />">
      <input type="hidden" name="prpLcompensateSumClaim" value="<bean:write name='prpLcompensateDto' property='sumClaim' filter='true' />">
      <input type="hidden" name="prpLcompensateDamageName" value="<bean:write name='prpLcompensateDto' property='damageName' filter='true' />">
      <input type="hidden" name='payFee' value="<%=request.getAttribute("payFlag")%>">
      <input type="hidden" name="damageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
      <input type="hidden" name="sumPaidAll" value="<bean:write name='prpLcompensateDto' property='sumPaidAll' filter='true' />">
      <input type="hidden" name="provinceCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
      <!--��ӱ�־λ�������ύ��ʱ�ж�ʱ�����������δ�ύ�� 2005-08-04-->
      <input type="hidden" name="AcciClaimFlag" value="<%= request.getAttribute("com.sinosoft.acciFlag")%>">
      <% //	add by lixiang start at 20051227
         //reason: ����Ͷ���˵���Ϣ %>
      <input type="hidden" name="prpLcompensateAppliName" value="<bean:write name='prpLcompensateDto' property='appliName' filter='true' />">
      <% //	add by lixiang end at 20051227%>
    <!--modify by qinyongli 2005-07-21 start ���� �ɶ�ҵ��-->
      <logic:notEmpty name="shareHolderFlag"  >
      <input type="hidden" name="shareHolderFlag" value="<bean:write name='shareHolderFlag'/>">
      </logic:notEmpty>
      <logic:empty name="shareHolderFlag"  >
      <input type="hidden" name="shareHolderFlag" value="0">
      </logic:empty>
      <logic:notEmpty name="coinsFlag"  >
      <input type="hidden" name="coinsFlag" value="<bean:write name='coinsFlag'/>">
      </logic:notEmpty>
      <logic:empty name="coinsFlag"  >
      <input type="hidden" name="coinsFlag" value="0">
      </logic:empty>
      <logic:notEmpty name="coinsSelfRate"  >
      <input type="hidden" name="coinsSelfRate" value="<bean:write name='coinsSelfRate'/>">
      </logic:notEmpty>
      <!--modify by qinyongli 2005-07-21 end-->
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
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">
    <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
    
    </td>
    <td class="title"> ������: </td>
    <td class="input"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value);return false;">
    </td>
  </tr>
  <tr>
    <td class="title"> ��������: </td>
    <td class="input" colspan="1"> 
    <input class="readonly" type=text name="prpLcompensateInsuredNameShow" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredNameShow' filter='true' />">
    <input class="readonly" type=hidden name="prpLcompensateInsuredName" readonly="true"  style="width:250px" value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">
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
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateAccountOK"  value="<bean:write name='prpLcompensateDto' property='account' filter='true' />" onblur="validateAccount()"> 
    </td>
  </tr> 
  <%}%>
    
  <!--
  <tr>
    <td class="title"> �ұ�: </td>
    <td class="input">
      <input class="readonly" readonly name="prpLcompensateCurrencyName" value="�����">
    </td>
    <td class="title"> ��������: </td>
    <td class="input">
      <input class="readonly" type=text name="prpLcompensateCaseTypeName" readonly="true"   value="<bean:write name='prpLcompensateDto' property='caseTypeName' filter='true' />"
    </td>
  </tr>
  -->
  <tr>
  <td class="title"> �⸶����: </td>
    <td class="input">
      <input type="text" name="prpLcompensateTimes" class="readonly" readonly value="<bean:write name='prpLcompensateDto' property='times' />">
    </td>

    <td class="title" style="width:15%">�ѳ��մ���:</td>
        <td class="input" style="width:35%">
        <%-- ������Ϣ���� --%>
           <%@include file="/common/regist/ExistRegist.jsp"%>
        </td>

  </tr>
    <%-- �⽡�ղ���Ҫ�����⸶����ʾ��û���Զ��᰸����Ϊ�ֹ��᰸�� 205-08-01 --%>
   <tr>
    <td class="title" style="width:15%"> �Ƿ��Զ��᰸:   </td>
    <td class="input" colspan="3">
    <input type="radio"  name="prpLcompensateFinallyFlag" value="1" <%= !prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>��
    <input type="radio"  name="prpLcompensateFinallyFlag" value="0" <%= prpLcompensateDto.getFinallyFlag().equals("0")? "checked":"" %>>��
    </td>
    </tr>
<%--
   <% //�ؿ��ⰸ:Ŀǰ�Ƿ��ؿ��ⰸ��Ϊ�ǰ��ռ����飬�ؿ��ⰸ����Ϊ���ռ�����   
     String recaseFlag =(String) request.getAttribute("recaseFlag");
   %> 
      
   <%if(recaseFlag.equals("0")||editType.equals("SHOW")){%>
        <input type="hidden" name="prpLcompensateFinallyFlag" value="0"> 
   <%}else{  //�ؿ��ⰸ��ʱ��Ϊ�ֹ��᰸%>
      <input type="hidden" name="prpLcompensateFinallyFlag" value="0" > 
        <!--input type="hidden" name="prpLcompensateFinallyFlag" value="1" >--> 
   <%}%>
--%>    
    
    
    </tr>
      <input type="hidden" name="prpLcompensateIndemnityDuty"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">
      <input type=hidden name="prpLcompensateIndemnityDutyName"  style="width:100px" class="readonly" readonly="true" value=" ">
      <input type="hidden" name="prpLcompensateIndemnityDutyRate" style="width:100px" class="readonly" readonly="true" value="0">
	<tr>
		<td class="title">��������:</td>
		<td class="input"><!--ԭ���޸İ�������--> <input
			name="prpLcompensateClaimType" type="hidden"
			value="<bean:write name='prpLcompensateDto' property='claimType' filter='true' />">
		<input name="prpLcompensateClaimTypeName" type="text" class="readonly"
			readonly="true"
			value="<bean:write name='prpLcompensateDto' property='claimTypeName' filter='true' />">
		<input name="prpLcompensateCaseType" type="hidden"
			value="<bean:write name='prpLcompensateDto' property='caseType' filter='true' />">
		<input name="prpLcompensateCaseTypeName" type="hidden"
			class="readonly" readonly="true"
			value="<bean:write name='prpLcompensateDto' property='caseTypeName' filter='true' />">
		</td>
		<td class="title" style="width: 15%">�⸶�˴�:</td>
		<td class="input"><input type=text name="prpLcompensateLossesNumber"
			class="input" style="width: 80px"
			value="<bean:write name='prpLcompensateDto' property='lossesNumber' filter='true' format="#0.00"/>">
		</td>
	</tr>
  <tr>
    <td class="title"  style="width:15%"> ������úϼ�:</td>
    <td class="input"  style="width:35%"> <input class="readonly" type=text name="sumCheckFee" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='sumCheckFee' filter='true' format='##0.00'/>">
    </td>
  
     <td class="title"> ���⸶ԭ��: </td>
        <td class="input" colspan="3">
            <select style="width:50%" name="prpLcompensateZeroLossType" id="prpLcompensateZeroLossType" onchange="changeZeroLossCaseType(this)">
                    <option  value="">---- ��ѡ�� ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="1">selected</logic:equal> value="1">ע��</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="2">selected</logic:equal> value="2">����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="3">selected</logic:equal> value="3">����</option>
            </select>
        </td>
    </tr>
    <%if(SHcomCode.equals("31")){ %>
    <tr>
      <td class="title"  style="width:15%"> ����ҽԺ:</td>
      <td class="input" style="width:12%">
      <input type=hidden name="prpLcompensateHospitalCode"  class="input" />
      <input type=text name="prpLcompensateHospitalName" class="codecode" style="width:438px" title="����ҽԺ����"  value="<bean:write name='prpLcompensateDto' property='hospitalCode'/>"
       		 ondblclick="code_CodeSelect(this, 'HospitalCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'HospitalCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'HospitalCode','-1','name','post','clear');">
      </td>
      <td class="title"> ��������: </td>
      <td class="input" style="width:12%">
      <input type=hidden name="prpLcompensateDiseaseCode"  class="input" />
      <input type=text name="prpLcompensateDiseaseName" class="codecode" style="width:287px" title="��������"  value="<bean:write name='prpLcompensateDto' property='diseaseCode'/>"
       		 ondblclick="code_CodeSelect(this, 'DiseaseCode','-1','name','post','clear');"
             onchange="code_CodeChange(this, 'DiseaseCode','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'DiseaseCode','-1','name','post','clear');"> 
      </td>
    </tr>
    <%} %>
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
        <td class="title" id="caseTypeOne" style="display:none"> ע����������: </td>
        <td class="input" id="caseTypeTwo" colspan="3" style="display:none">
            <select style="width:20%" name="prpLcompensateZeroLossCaseType" id="prpLcompensateZeroLossCaseType">
                    <option  value="">---- ��ѡ�� ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="1">selected</logic:equal> value="1">�ͻ�����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="2">selected</logic:equal> value="2">�ͻ��ظ�����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="3">selected</logic:equal> value="3">������Ͷ���ձ����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossCaseType" value="4">selected</logic:equal> value="4">������Ͷ�����ֳ���</option>
            </select>
        </td>
        <td class="input" colspan="3" id="caseTypeThr" style="display:none">
            <select style="width:20%" name="prpLcompensateExclusionsType">
                    <option value="0">�����ڱ�������</option>
            </select>
        </td> 
    </tr>
    <tr>
        <td class="title" id="detailReasonOne" colspan="4" style="display:none">��ϸԭ��</td>
    </tr>
    <tr>
        <td class="input" id="detailReasonTwo" colspan="4" align="center" style="display:none">
             <textarea name='prpLcompensateDetailReason' wrap="hard" rows=10 cols=80 class=common ><bean:write name='prpLcompensateDto' property='zeroLossDetailReason' filter='true' /></textarea>
         </td>
   </tr> 

  <!--add by wuzheng ������ͳ���ƶ�����ר��ҵ����Ϣ��ҽ������ 20080602 begin-->
   <tr id = "trMedicalType" style="display:none">
    <td class='title'>ҽ������</td>
    <td class='input' style="width:35%">
      <html:select name="prpLcompensateDto" property="medicalType" style="width:60">
        <html:option value=""></html:option>
        <html:option value="01">����</html:option>
        <html:option value="02">סԺ</html:option>
        <html:option value="99">����</html:option>
       </html:select>
    </td>
    <td class='title'></td>
    <td class='input'></td>
  </tr>      
  <!--add by wuzheng ������ͳ���ƶ�����ר��ҵ����Ϣ��ҽ������ 20080602 end-->  
  
</table>
