<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��Head[ ʵ�� ]
* AUTHOR     :liubvo
* CREATEDATE :2004-05-12
* MODIFYLIST :  Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>


<!--modify by liuyanmei add 20051114 start-->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UIDeductCondAction" %>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcode"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcustomerIdv"%>
<%@page import="com.sinosoft.utiall.blsvr.BLPrpDcustomerUnit"%>
<%@page import="com.sinosoft.utiall.dbsvr.DBPrpDcustomLevelTrace"%>
<script language="javascript">
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
    function changeClaimType(field){
    	if(fm.oldClaimType.value == ""){
    		fm.oldClaimType.value ="0";
    	}
    	if(fm.prpLcompensateRiskCode.value != '0507'
    	&&fm.prpLcompensateRiskCode.value != '0577'
    	&&fm.prpLcompensateRiskCode.value != '0587'){
    		if(field.value == "K"){
    			alert("��ҵ�ղ���ѡ��������!");
	    		fm.claimType.value = fm.oldClaimType.value;
	    		return false;
    		}
    	}
    	else{
    		if(field.value == "K"){
    		document.all.tabThridCar.style.display = "";
    		document.all.tabPerson.style.display = "none";
    		var btns = document.getElementsByName("buttonPersonCommerceDelete");
    		for(var i =1;i < btns.length;){
    			btns[i].onclick();
    		}
    		calCompelSumPropAndPerson();
    		calFundCommerce();
    		calSumDutyPaid();
	    	}
	    	else{
	    		document.getElementById("tabThridCar").style.display = "none";
	    		document.getElementById("tabPerson").style.display = "";
	    	}
    	}

    	
    	fm.oldClaimType.value = fm.claimType.value;
    }
</script>
<input type="hidden" name="deductCondition" value="">
<input type="hidden" name="deductCondition" value="">
<input type="hidden" name="Times" value="0">
<input type="hidden" name="Times" value="0">
<input type="hidden" name="deductName" value="">
<input type="hidden" name="deductName" value="">
<input type="hidden" name="kindCode" >
<input type="hidden" name="kindAmount" >
<input  name="kindCodedutyName" type="hidden" >
<input name="deductRate" type="hidden" >
<input  name="kindCode2" type="hidden" >
<input name="absolutDeductRate" type="hidden">
<%  
    //ȡ����ϵͳ�ĵ�ַ
    String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");

	UserDto   userDto = (UserDto)session.getAttribute("user");
	boolean isShowButton = true;
	//�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
	if(userDto == null){
	    isShowButton = false;
	}
    //ȡ�޶�---start-----------------------------------------------------
   String  configCode  =(String) request.getAttribute("configCode");
   Map  amountMap = (HashMap)request.getAttribute("amountMap"); 
   String  kind="";
   String kindAmount="";
   Set  kindCodeList =amountMap.keySet();
   if ( kindCodeList!=null && kindCodeList.size()>0){
   	 for (Iterator kindit = kindCodeList.iterator(); kindit.hasNext();) {
   	 	  kind =(String)kindit.next();
   	 	  kindAmount=(String)amountMap.get(kind);
   	 	  %>
   	<input type="hidden" name="kindCode" value="<%=kind%>">
        <input type="hidden" name="kindAmount" value="<%=kindAmount%>">
 <%
   	 }
   }
 
//ȡ�޶�---end-----------------------------------------------------------

 PrpLcompensateDto  prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto"); 
 List prpLdeductCondDtoList = new ArrayList();
 prpLdeductCondDtoList = prpLcompensateDto.getPrpLdeductCondDtoList();
 if(prpLdeductCondDtoList != null && prpLdeductCondDtoList.size() != 0){
  for(int i=0;i<prpLdeductCondDtoList.size();i++){%>
    <input type="hidden" name="deductName" value="<%=((PrpLdeductCondDto)prpLdeductCondDtoList.get(i)).getDeductCondName()%>">
      <input type="hidden" name="deductCondition" value="<%=((PrpLdeductCondDto)prpLdeductCondDtoList.get(i)).getDeductCondCode()%>">
      <input type="hidden" name="Times" value="<%=String.valueOf(((PrpLdeductCondDto)prpLdeductCondDtoList.get(i)).getTimes())%>">
 
    
   
  <% 
   }
   }
   
 
//ȡ�޶�---end-----------------------------------------------------------

    //ȡ�¹�����������
     Map mapList =(Map)request.getAttribute("mapList");
           Map mapp =new HashMap();
           Double strDeductRate ;
        	 String strDeductRateName ="";
        	 Set setmapListKey = mapList.keySet();
        	 int kindNum =0;
        	 String kindCode1 ="";
        	 if (setmapListKey !=null&& setmapListKey.size()>0){
        		 kindNum = setmapListKey.size(); 
        		 
        	 for (Iterator mapListIt = setmapListKey.iterator(); mapListIt.hasNext();) {
        		 kindCode1 = (String) mapListIt.next();
        	         mapp =(Map)mapList.get(kindCode1);
        		
        		 Set setmapKey = mapp.keySet();
        		  
        		 for (Iterator mapIt = setmapKey.iterator(); mapIt.hasNext();) {
            		 String zeren = (String) mapIt.next();
            		 strDeductRate =(Double)mapp.get(zeren);
       		         strDeductRateName = kindCode1 + zeren;
        %>
         <input  name="kindCodedutyName" type="hidden" value ="<%=strDeductRateName%>">
          <input name="deductRate" type="hidden" value ="<%=strDeductRate%>">
        <%	  
        	   }   
        	 }   
        }   //ȡ�¹�����������end    
	%>
	
	<% //����������
	   Map deductRateList =(Map)request.getAttribute("deductRateList");
	     String absolutDeductRate ="";
	     String kindCode2="";
	     
	    Set deductRateListKey = deductRateList.keySet();
	    if (deductRateListKey !=null&& deductRateListKey.size()>0){
	       for (Iterator deductRatIt = deductRateListKey.iterator(); deductRatIt.hasNext();) {
	           kindCode2 = (String) deductRatIt.next();
	           absolutDeductRate =(String) deductRateList.get(kindCode2);
	  %>
	  
	   <input  name="kindCode2" type="hidden" value ="<%=kindCode2%>">
           <input name="absolutDeductRate" type="hidden" value ="<%=absolutDeductRate%>"  onChange="checkKindCode(this);calRealpay2ForSunny(this);" >
	  
	       
	  <%     }
	     }
	//ȡ������
	 String registNo =(String)request.getAttribute("registNo");
	
	%>
	

<%
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLcompensateDto.getStartHour();
 intendHour    = prpLcompensateDto.getEndHour();
 String strAppliRiskLevel = "0";//Ͷ���˷��յȼ�
 String strInsuredRiskLevel = "0";//�������˷��յȼ�
 DBPrpDcustomLevelTrace dbPrpDcustomLevelTrace = new DBPrpDcustomLevelTrace();
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
%>
<script type="text/javascript">
function changeBZIndemnityDuty()
{
  var indemnityDuty =""; //���õ�ֵ
  var i= 0;              //ѭ��ʹ��
  var qindex=0;

  switch (fm.indemnityDuty.value)
  {
    case "0":   //ȫ��
      indemnityDuty = "100";
      break;
    case "1":   //����
      indemnityDuty = "70";
      break;
    case "2":   //ͬ��
      indemnityDuty = "50";
      break;
    case "3":   //����
      indemnityDuty = "30";
      break;
    case "4":   //����
      indemnityDuty = "0.0";
      break;
    case "9":   //����
      indemnityDuty = "0.0";
      break;
  }
  fm.prpLcompensateIndemnityDutyRate.value =indemnityDuty;
  calCompelSumPropAndPerson();
  /*
   *���¼���Ʋ�������
   */
  if(fm.all("propSumLoss") != null){
        for(var i = 1;i < fm.all("propSumLoss").length;i++){
            fm.all("propSumLoss")[i].select();            
            calPropSumDefPay(fm.all("propSumLoss")[i],'0');
        }
  }
  if(fm.all("prpLpersonMedicalSumLoss") != null){
        for(var i = 1;i < fm.all("prpLpersonMedicalSumLoss").length;i++){
            fm.all("prpLpersonMedicalSumLoss")[i].select();
            calPersonSumDefLoss(fm.all("prpLpersonMedicalSumLoss")[i]);
        }
  }
  calCompelSumPropAndPerson(); 
  calSumDutyPaid();
}

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
  
  }
</script>
<!--modify by liuyanmei add 20051114 end-->    
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
    <%if(isShowButton){ %>   
       <td><input type="button" class=bigbutton name="prpLmessageSave" value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLcompensateClaimNo.value,fm.prpLcompensatePolicyNo.value,fm.prpLcompensateRiskCode.value,'compe',fm.prpLcompensateClaimNo.value,'claimNo',fm.prpLcompensateClaimNo.value)"></td>
    <%} %>
	   <td>
             <input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo',fm.prpLregistExtRegistNo.value,'claim');">
           </td> 	   

       
      <%--modify by wangli update end 20050409 --%>
    </tr> 
    </table>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
    <td  colspan="4">�������� 
      <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
      <input type="hidden" name="prpLcompensateRegistNo" value="<%=registNo%>">
      <input type="hidden" name="prpLcompensateCaseNo" value="<bean:write name='prpLcompensateDto' property='caseNo' />"> 
      <input type="hidden" name="prpLcompensateTimes" value="<bean:write name='prpLcompensateDto' property='times' />"> 
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
      <!--<input type="hidden" name="prpLcompensateReceiverName" value="<bean:write name='prpLcompensateDto' property='receiverName' />"> 
      <input type="hidden" name="prpLcompensateBank" value="<bean:write name='prpLcompensateDto' property='bank'/>"> 
      <input type="hidden" name="prpLcompensateAccount" value="<bean:write name='prpLcompensateDto' property='account' />"> -->
      <input type="hidden" name="prpLcompensateMakeCom" value="<bean:write name='prpLcompensateDto' property='makeCom' />"> 
      <input type="hidden" name="prpLcompensateComCode" value="<bean:write name='prpLcompensateDto' property='comCode' />"> 
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
      
      
      <input type="hidden" name="prpLcompensateClauseTypeCode" value="<bean:write name='prpLcompensateDto' property='clauseTypeCode' filter='true' />"> 
      <input type="hidden" name="prpLcompensateEscapeFlag" value="<bean:write name='prpLcompensateDto' property='escapeFlag' filter='true' />"> 
      <input type="hidden" name="prpLcompensatePrintFlag" value="0"> 
      <input type="hidden" name="damageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />"> 
      <input type="hidden" name="prpLcompensatedamageStartHour" <bean:write name='prpLcompensateDto' property='damageStartHour'/>"> 
      
      <input type="hidden" name="sumPaidAll" value="<bean:write name='prpLcompensateDto' property='sumPaidAll' filter='true' />">
     <%--<input type="hidden" name="prpLcompensateSumAmount"  value="<bean:write name='prpLcompensateDto' property='replevyFlag' filter='true' />"> --%>
          
      <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
      <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
      
      <!--modify by luqin 2005-04-08 start-->    
      <input type="hidden" name="prpLcompensatePayFee" value="<bean:write name='prpLcompensateDto' property='payFee' />">
      <!--modify by luqin 2005-04-08 end-->
      <input type="hidden" name="GenerateCompensateFlag" value="0">    
      <input type="hidden" name="provinceCode" value="<bean:write name='prpLcompensateDto' property='comCode' />">   
   
    </td>
  </tr>
  <tr> 
    <td class="title"  > �������:</td>
    <td class="input"  > <input type=text name="prpLcompensateCompensateNo" title="�������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
    </td>
    <td class="title"  > </td>
    <td class="input"  ><input type=hidden name="LFlag" title="��������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='LFlag' />"> 
    </td> 
  </tr>
  <tr> 
    <td class="title"> ������:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
    <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="����ʱ������Ϣ" onclick="backWardPolicy();">
  
    </td>
    <td class="title"> ������:</td>
    <td class="input"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value); return false;"> 
    </td>
  </tr>
  <tr> 
    <td class="title" >�ѳ��մ���:</td>
    <td class="input">
           <%-- ������Ϣ���� --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>  
        </td>
    <td class="title"> ��������:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateInsuredName" readonly="true"  value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
   <input type=hidden name="prpLcompensateCaseType" value="<bean:write name='prpLcompensateDto' property='caseType' filter='true' />">  
   <input type=hidden name="prpLcompensateCaseTypeName" readonly="true"   value="<bean:write name='prpLcompensateDto' property='caseTypeName' filter='true' />"

    </td>
  </tr> 
   <tr>    
    <!--added by zhangli 2007-04-19-->
    <td class="title"> �������˿�������: </td>    
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateBank"  value="<bean:write name='prpLcompensateDto' property='bank' filter='true' />" > 
    </td>
    <td></td>
    <td></td>
  </tr>
  <tr>
	<td class="title">Ͷ���˷��յȼ�</td>
	<td class="input"><span style="color: red;"><b><%=strAppliRiskLevel  %></b></span></td>
	<td class="title">�������˷��յȼ�</td>
	<td class="input"><span style="color: red;"><b><%=strInsuredRiskLevel  %></b></span></td>
  </tr>
  <%
    String status = (String)request.getParameter("status");
  //  String editType = (String)request.getAttribute("editType");
  //   System.out.println("********************zhangli****************************"+editType);
  //  if(status.equals("4")){
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
  <tr>
    <td class="title"> �տ���ȫ��: </td>
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateReceiverName"   style="width:250px" value="<bean:write name='prpLcompensateDto' property='receiverName' filter='true' />">
    </td>
 
   <!--added by zhangli 2007-04-19-->
    <td class="title"></td>    
    <td class="input" colspan="1"> </td>
  </tr>
  <!--
  <tr>  
    <td class="title">�ұ�: </td>
    <td class="input"> 
      <input class="readonly" readonly name="prpLcompensateCurrencyName" value="�����"> 
    </td>
    
    <td class="title"> ��������:</td>
    <td class="input"> 
    </td>
   
  </tr>
  -->
      
  <tr> 
    <td class="title"> �����ڼ�:</td>
    <td colspan="3" class="input"> 
      <input type=text name="prpLcompensateStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> <%=startHour%> <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> <%=endHour%>">
    </td>
  </tr>
  
  <tr> 
    <td class="title"> �������:</td>
    <td class="input" colspan=3> <input class="readonly" type=text name="prpLcompensateClauseName" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='clauseName' filter='true' />">  
    </td> 
  </tr>
  
  <tr> 
    <td class="title"> ��������:</td>
    <td class="input"> <input name="prpLcompensateCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='carKind' filter='true' />">  
    </td>
     <td class="title"> ���ƺ���:</td>
    <td class="input"> <input class="readonly" name="prpLcompensateLicenseNo" readonly="true" value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />"> 
    </td>
  </tr>
  <tr>
    <td class="title"> �б�ʱ�³����ü�:</td>
    <td colspan="1" class="input"> 
        <input type=text name="prpLcompensatePurchasePrice" title="�³����ü�:" style="width:250px" class="common"  value="<bean:write name='prpLcompensateDto' property='purchasePrice' filter='true' />"> 
    </td>
    <td class="title"> ��ǰ�³����ü�:</td>
    <td colspan="1" class="input"> 
        <input type=text name="currentPurchasePrice" title="�³����ü�:" style="width:250px" class="common"  value="<%=request.getAttribute("currentPurchasePrice") %>"> 
    </td>  
  </tr>
  <% 
   //��ʼ��ʱȡ ֧������Ϊ����������Ϣ
   BLPrpDcustomerIdv blPrpDcustomerIdv = new BLPrpDcustomerIdv();
   BLPrpDcustomerUnit blPrpDcustomerUnit = new BLPrpDcustomerUnit();
   //prpLcompensateDto
   String strSql = " Customercode in (select distinct d.insuredcode from prpcinsured d where d.policyno = '"+prpLcompensateDto.getPolicyNo()+"'  and d.insuredflag='1') ";
   blPrpDcustomerIdv.query(strSql);
   String customerCName  ="";
   String identifyType   ="";
   String identifyNumber ="";
   if(blPrpDcustomerIdv.getSize() > 0){
    customerCName  =blPrpDcustomerIdv.getArr(0).getCustomerCName();
    identifyType   =blPrpDcustomerIdv.getArr(0).getIdentifyType();
    identifyNumber =blPrpDcustomerIdv.getArr(0).getIdentifyNumber();
   }else{
	   blPrpDcustomerUnit.query(strSql);
	   if(blPrpDcustomerUnit.getSize() > 0){
		    customerCName  =blPrpDcustomerUnit.getArr(0).getCustomerCName();
		    identifyType   ="99";
		    identifyNumber =blPrpDcustomerUnit.getArr(0).getOrganizeCode();
	   }
   }
   //blPrpDcustomerIdv.getArr()
   //blPrpDcustomerIdv
  if(editType.equals("SHOW")){ %>
    <tr> 
    <td class="title"> ֧������:</td>
       <td class="input">  
           <input type=text name="prpLcompensateOjectName" title="֧����������:" maxlength=120 style="width:250px" class="common"  value="<bean:write name='prpLcompensateDto' property='ojectName' filter='true' />"> 
           <img src="/claim/images/bgMarkMustInput.jpg">
       </td>
    </td>
  </tr>
  <tr> 
    <td class="title"> ֧����������:</td>
       <td class="input"> 
       <select class="common" name="prpLcompensateOjectType">
       <%
        BLPrpDcode  blPrpDcode = new BLPrpDcode();
        blPrpDcode.query( "codetype='IdentifyType' and validstatus='1' and flag='1'",10000);
        int intSize = blPrpDcode.getSize();
        for(int i=0;i<intSize;i++)
        {
       %>
          <option value="<%= blPrpDcode.getArr(i).getCodeCode()%>" <%=(prpLcompensateDto.getOjectType()).equals(blPrpDcode.getArr(i).getCodeCode())? "selected":"" %> ><%= blPrpDcode.getArr(i).getCodeCode()%>-<%= blPrpDcode.getArr(i).getCodeCName()%></option>
       <%
        }
       %>
       </select>
       </td>
    </td>    
    <td class="title"> ֧������֤������:</td>
        <td class="input"><input type=text name="prpLcompensateOjectCode" maxlength=30  title="֧������֤������:" style="width:250px" class="common"  value="<bean:write name='prpLcompensateDto' property='ojectCode' filter='true' />"> 
        <img src="/claim/images/bgMarkMustInput.jpg">
        </td>   
  </td>
  </tr>
  <% }else{%>
  <tr> 
    <td class="title"> ֧������:</td>
       <td class="input">  
           <input type=text name="prpLcompensateOjectName" title="֧����������:" style="width:250px" class="common"  value="<%=customerCName%>"  maxlength=120 > 
            <img src="/claim/images/bgMarkMustInput.jpg">
       </td>
    </td>
  </tr>
  <tr> 
    <td class="title"> ֧����������:</td>
       <td class="input"> 
       <select class="common" name="prpLcompensateOjectType">
       <%
        BLPrpDcode  blPrpDcode = new BLPrpDcode();
        blPrpDcode.query( "codetype='IdentifyType' and validstatus='1' and flag='1'",10000);
        int intSize = blPrpDcode.getSize();
        for(int i=0;i<intSize;i++)
        {
       %>
          <option value="<%= blPrpDcode.getArr(i).getCodeCode()%>"  <%=identifyType.equals(blPrpDcode.getArr(i).getCodeCode())? "selected":"" %>><%= blPrpDcode.getArr(i).getCodeCode()%>-<%= blPrpDcode.getArr(i).getCodeCName()%></option>
       <%
        }
       %>
       </select>
       </td>
    </td>    
    <td class="title"> ֧������֤������:</td>
        <td class="input"><input type=text name="prpLcompensateOjectCode" title="֧������֤������:" style="width:250px" class="common"  maxlength=30  value="<%=identifyNumber%>"> 
        <img src="/claim/images/bgMarkMustInput.jpg">
      </td>   
  </td>
  </tr>
  <%} %>    
  
  
  <tr> 
    <td class="title"> �����ͺ�:</td>
    <td class="input"> <input class="readonly" name="prpLcompensateBrandName" readonly="true" value="<bean:write name='prpLcompensateDto' property='brandName' filter='true' />"> 
    </td>    
    <td class="title"> ���Ƶ�ɫ:</td>
    <td class="input"> <input class="readonly"  name="prpLcompensateLicenseColor" readonly="true" value="<bean:write name='prpLcompensateDto' property='licenseColor' filter='true' />"> 
  </td>    
  </tr>
  
  
  <tr>
    <input type="hidden" name="prpLcompensateSeatCount" class="readonly" readonly="true" maxlength=20 description="��λ��" value="<bean:write name='prpLcompensateDto' property='seatCount'/>">  
    <td class="title"> ���ܺ�:</td>
    <td class="input" > <input type="text" name="prpLcompensateFrameNo" class="readonly" readonly="true" maxlength=20 description="���ܺ�" value="<bean:write name='prpLcompensateDto' property='frameNo'/>"> 
    </td>    
    <td class="title"> ��������:</td>
    <td class="input"> <input type="text" name="prpLcompensateEngineNo" class="readonly" readonly="true" maxlength=20 description="��������" value="<bean:write name='prpLcompensateDto' property='engineNo'/>"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> ����ʱ��:</td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensateDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> �� <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> ʱ <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> ��">
    <input type="hidden" name="DamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    </td>
  </tr>
  <tr> 
    <td class="title"> ���յص�:</td>
    <td colspan="3" class="input"> <input type=text name="prpLcompensateDamageAddress" title="���յ�" style="width:300px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> ���ս��:</td>
    <td class="input"> <input name="prpLcompensateSumAmount" type="text" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='sumAmount' filter='true' format='##0.00'/>"> 
    </td>
    <td class="title"> ������:</td>
    <td class="input"> <input class="readonly" readonly name="prpLcompensateSumClaim" description="������ʧ���" value="<bean:write name='prpLcompensateDto' property='sumClaim' filter='true' format='##0.00'/>"> 
    </td>
  </tr>  
<% 
    if ("RISKCODE_DAZ".equals(configCode )||"RISKCODE_DAY".equals(configCode )||"RISKCODE_DAU".equals(configCode ))
    {
%>
      <tr>    
    <td class='title'>�¹�����:</td>
    <td class='input' style="display: ">
          <html:select name="prpLcompensateDto" property="indemnityDuty" style="width:60%"  onchange="changeBZIndemnityDuty();">
              <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select>
      <!--<input type="hidden" name="prpLcompensateIndemnityDuty"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">  
      <input type=text name="prpLcompensateIndemnityDutyName"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDutyName' filter='true' />">  -->
    </td> 
    <td class='title' style="display: "><bean:message key="db.prpLclaim.indemnityDutyRate"/>:</td>
    <td class='input'>
    <input type=text name="prpLcompensateIndemnityDutyRate" style="width:50px"  value="<bean:write name='prpLcompensateDto' property='indemnityDutyRate' filter='true' />">
<%
    }
    else 
    {
%>
        <tr>    
    <td class='title'>�¹�����:</td>
    <td class='input'>
          <html:select name="prpLcompensateDto" property="indemnityDuty" style="width:60%"  onchange="changeIndemnityDuty(); changeAccidentDeductRate(); setAllIndemnityDutyRate();calChargeAmountAll();setSumDutyDeductibleFlag('0');">
              <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select>
      <!--<input type="hidden" name="prpLcompensateIndemnityDuty"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDuty' filter='true' />">  
      <input type=text name="prpLcompensateIndemnityDutyName"  style="width:100px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='indemnityDutyName' filter='true' />">  -->
    </td> 
    <td class='title'><bean:message key="db.prpLclaim.indemnityDutyRate"/>:</td>
    <td class='input'>
        <input type="text" name="prpLcompensateIndemnityDutyRate" style="width:50px" onblur="setAllIndemnityDutyRate()" value="<bean:write name='prpLcompensateDto' property='indemnityDutyRate' filter='true' />">
<%
    }
%> 
    </td>
  </tr>
  <tr>
    <td class="title" style="width:15%">�Ƿ��漰����������</td>
    <td class="input" style="width:35%">
      <select name="prpLpersonWoundGrade" class='common' style="width:110">
         <option selected="selected" ></option>
       	 <option value="0" <%=prpLcompensateDto.getWoundGrade().trim().equals("0") ? "selected" : "" %>>��</option>
         <option value="1" <%=prpLcompensateDto.getWoundGrade().trim().equals("1") ? "selected" : "" %>>��</option>
      </select><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
	 <td class="title" style="width:15%">�ⰸ���</td>
    <td class="input" style="width:35%">
      <html:select name="prpLcompensateDto" property="claimType" onchange="changeClaimType(this)" >
              <html:options collection="claimTypes" property="codeCode" labelProperty="codeCName"/>          
      </html:select>
      <input type="hidden" name ="oldClaimType" value="<bean:write name='prpLcompensateDto' property='claimType' filter='true' />">
    </td>
  </tr>

    <tr>
    <td class="title" > �Ƿ��Զ��᰸:   </td>
    <td class="input">  
      <input type="radio" onclick="changePrpLcompensateFinallyFlag()"  name="prpLcompensateFinallyFlag" value="1" <%=!"0".equals(prpLcompensateDto.getFinallyFlag()) ? "checked" : "" %>>��
      <input type="radio" onclick="changePrpLcompensateFinallyFlag()"  name="prpLcompensateFinallyFlag" value="0" <%="0".equals(prpLcompensateDto.getFinallyFlag()) ? "checked" : "" %>>��
    </td> 
    
    <td class="title"> �Ƿ���׷��:</td>
    <td class="input"> 
        <input type="text" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='replevyFlag' filter='true' />"> 
    </td>
    </tr>
    
    <tr> 
        <td class="title"> ���⸶ԭ��: </td>
        <td class="input" colspan="3">
            <select style="width:30%" name="prpLcompensateZeroLossType" id="prpLcompensateZeroLossType" onchange="changeZeroLossCaseType(this)">
                    <option  value="">---- ��ѡ�� ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="1">selected</logic:equal> value="1">ע��</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="2">selected</logic:equal> value="2">����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="3">selected</logic:equal> value="3">����</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="4">selected</logic:equal> value="4">ҵ��Ա��������</option>
            </select>
        </td>
    </tr>
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
    <tr>
        <td class="title" id="detailReasonOne" colspan="4" style="display:none">��ϸԭ��</td>
    </tr>
    <tr>
        <td class="input" id="detailReasonTwo" colspan="4" align="center" style="display:none">
             <textarea name='prpLcompensateDetailReason' wrap="hard" rows=10 cols=80 class=common ><bean:write name='prpLcompensateDto' property='zeroLossDetailReason' filter='true' /></textarea>
         </td>
   </tr> 
    
</table>
