<%--
****************************************************************************
* DESC       :添加主信息子块界面页面Head[ 实赔 ]
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
	              alert("两次输入的支付帐号不一致，请重新输入!");
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
    			alert("商业险不能选择互碰自赔!");
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
    //取核心系统的地址
    String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");

	UserDto   userDto = (UserDto)session.getAttribute("user");
	boolean isShowButton = true;
	//用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
	if(userDto == null){
	    isShowButton = false;
	}
    //取限额---start-----------------------------------------------------
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
 
//取限额---end-----------------------------------------------------------

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
   
 
//取限额---end-----------------------------------------------------------

    //取事故责任免赔率
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
        }   //取事故责任免赔率end    
	%>
	
	<% //绝对免赔率
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
	//取立案号
	 String registNo =(String)request.getAttribute("registNo");
	
	%>
	

<%
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
<script type="text/javascript">
function changeBZIndemnityDuty()
{
  var indemnityDuty =""; //设置的值
  var i= 0;              //循环使用
  var qindex=0;

  switch (fm.indemnityDuty.value)
  {
    case "0":   //全责
      indemnityDuty = "100";
      break;
    case "1":   //主责
      indemnityDuty = "70";
      break;
    case "2":   //同责
      indemnityDuty = "50";
      break;
    case "3":   //次责
      indemnityDuty = "30";
      break;
    case "4":   //无责
      indemnityDuty = "0.0";
      break;
    case "9":   //其它
      indemnityDuty = "0.0";
      break;
  }
  fm.prpLcompensateIndemnityDutyRate.value =indemnityDuty;
  calCompelSumPropAndPerson();
  /*
   *重新计算财产、人伤
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
       <td><input type="button" class=bigbutton name="prpLmessageSave" value="理赔沟通" onclick="openWinSaveQuery(fm.prpLcompensateClaimNo.value,fm.prpLcompensatePolicyNo.value,fm.prpLcompensateRiskCode.value,'compe',fm.prpLcompensateClaimNo.value,'claimNo',fm.prpLcompensateClaimNo.value)"></td>
    <%} %>
	   <td>
             <input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo',fm.prpLregistExtRegistNo.value,'claim');">
           </td> 	   

       
      <%--modify by wangli update end 20050409 --%>
    </tr> 
    </table>
<table  class=common cellpadding="5" cellspacing="1">
  <tr class=listtitle> 
    <td  colspan="4">赔款计算书 
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
    <td class="title"  > 计算书号:</td>
    <td class="input"  > <input type=text name="prpLcompensateCompensateNo" title="计算书号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='compensateNo' />"> 
    </td>
    <td class="title"  > </td>
    <td class="input"  ><input type=hidden name="LFlag" title="理赔类型" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='LFlag' />"> 
    </td> 
  </tr>
  <tr> 
    <td class="title"> 立案号:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateClaimNo" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">  
    <input type="hidden" name="damageDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    <input type=button class="bigbutton"  name="policyBackWard" value="出险时保单信息" onclick="backWardPolicy();">
  
    </td>
    <td class="title"> 保单号:</td>
    <td class="input"> <input type=text name="prpLcompensatePolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLcompensateDto' property='policyNo' filter='true' />">
    <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLcompensatePolicyNo.value); return false;"> 
    </td>
  </tr>
  <tr> 
    <td class="title" >已出险次数:</td>
    <td class="input">
           <%-- 出险信息画面 --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>  
        </td>
    <td class="title"> 被保险人:</td>
    <td class="input"> <input class="readonly" type=text name="prpLcompensateInsuredName" readonly="true"  value="<bean:write name='prpLcompensateDto' property='insuredName' filter='true' />">  
   <input type=hidden name="prpLcompensateCaseType" value="<bean:write name='prpLcompensateDto' property='caseType' filter='true' />">  
   <input type=hidden name="prpLcompensateCaseTypeName" readonly="true"   value="<bean:write name='prpLcompensateDto' property='caseTypeName' filter='true' />"

    </td>
  </tr> 
   <tr>    
    <!--added by zhangli 2007-04-19-->
    <td class="title"> 被保险人开户银行: </td>    
    <td class="input" colspan="1"> <input class="input" type=text name="prpLcompensateBank"  value="<bean:write name='prpLcompensateDto' property='bank' filter='true' />" > 
    </td>
    <td></td>
    <td></td>
  </tr>
  <tr>
	<td class="title">投保人风险等级</td>
	<td class="input"><span style="color: red;"><b><%=strAppliRiskLevel  %></b></span></td>
	<td class="title">被保险人风险等级</td>
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
    <td class="title">币别: </td>
    <td class="input"> 
      <input class="readonly" readonly name="prpLcompensateCurrencyName" value="人民币"> 
    </td>
    
    <td class="title"> 案件性质:</td>
    <td class="input"> 
    </td>
   
  </tr>
  -->
      
  <tr> 
    <td class="title"> 保险期间:</td>
    <td colspan="3" class="input"> 
      <input type=text name="prpLcompensateStartDate" class="readonly" style="width:340px" readonly="true"  value="<bean:write name='prpLcompensateDto' property='startDate' filter='true' /> <%=startHour%> <bean:write name='prpLcompensateDto' property='endDate' filter='true' /> <%=endHour%>">
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 条款类别:</td>
    <td class="input" colspan=3> <input class="readonly" type=text name="prpLcompensateClauseName" readonly="true"  style="width:150px" value="<bean:write name='prpLcompensateDto' property='clauseName' filter='true' />">  
    </td> 
  </tr>
  
  <tr> 
    <td class="title"> 车辆种类:</td>
    <td class="input"> <input name="prpLcompensateCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='carKind' filter='true' />">  
    </td>
     <td class="title"> 号牌号码:</td>
    <td class="input"> <input class="readonly" name="prpLcompensateLicenseNo" readonly="true" value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />"> 
    </td>
  </tr>
  <tr>
    <td class="title"> 承保时新车购置价:</td>
    <td colspan="1" class="input"> 
        <input type=text name="prpLcompensatePurchasePrice" title="新车购置价:" style="width:250px" class="common"  value="<bean:write name='prpLcompensateDto' property='purchasePrice' filter='true' />"> 
    </td>
    <td class="title"> 当前新车购置价:</td>
    <td colspan="1" class="input"> 
        <input type=text name="currentPurchasePrice" title="新车购置价:" style="width:250px" class="common"  value="<%=request.getAttribute("currentPurchasePrice") %>"> 
    </td>  
  </tr>
  <% 
   //初始化时取 支付对象为被保险人信息
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
    <td class="title"> 支付对象:</td>
       <td class="input">  
           <input type=text name="prpLcompensateOjectName" title="支付对象类型:" maxlength=120 style="width:250px" class="common"  value="<bean:write name='prpLcompensateDto' property='ojectName' filter='true' />"> 
           <img src="/claim/images/bgMarkMustInput.jpg">
       </td>
    </td>
  </tr>
  <tr> 
    <td class="title"> 支付对象类型:</td>
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
    <td class="title"> 支付对象证件号码:</td>
        <td class="input"><input type=text name="prpLcompensateOjectCode" maxlength=30  title="支付对象证件号码:" style="width:250px" class="common"  value="<bean:write name='prpLcompensateDto' property='ojectCode' filter='true' />"> 
        <img src="/claim/images/bgMarkMustInput.jpg">
        </td>   
  </td>
  </tr>
  <% }else{%>
  <tr> 
    <td class="title"> 支付对象:</td>
       <td class="input">  
           <input type=text name="prpLcompensateOjectName" title="支付对象类型:" style="width:250px" class="common"  value="<%=customerCName%>"  maxlength=120 > 
            <img src="/claim/images/bgMarkMustInput.jpg">
       </td>
    </td>
  </tr>
  <tr> 
    <td class="title"> 支付对象类型:</td>
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
    <td class="title"> 支付对象证件号码:</td>
        <td class="input"><input type=text name="prpLcompensateOjectCode" title="支付对象证件号码:" style="width:250px" class="common"  maxlength=30  value="<%=identifyNumber%>"> 
        <img src="/claim/images/bgMarkMustInput.jpg">
      </td>   
  </td>
  </tr>
  <%} %>    
  
  
  <tr> 
    <td class="title"> 厂牌型号:</td>
    <td class="input"> <input class="readonly" name="prpLcompensateBrandName" readonly="true" value="<bean:write name='prpLcompensateDto' property='brandName' filter='true' />"> 
    </td>    
    <td class="title"> 号牌底色:</td>
    <td class="input"> <input class="readonly"  name="prpLcompensateLicenseColor" readonly="true" value="<bean:write name='prpLcompensateDto' property='licenseColor' filter='true' />"> 
  </td>    
  </tr>
  
  
  <tr>
    <input type="hidden" name="prpLcompensateSeatCount" class="readonly" readonly="true" maxlength=20 description="座位数" value="<bean:write name='prpLcompensateDto' property='seatCount'/>">  
    <td class="title"> 车架号:</td>
    <td class="input" > <input type="text" name="prpLcompensateFrameNo" class="readonly" readonly="true" maxlength=20 description="车架号" value="<bean:write name='prpLcompensateDto' property='frameNo'/>"> 
    </td>    
    <td class="title"> 发动机号:</td>
    <td class="input"> <input type="text" name="prpLcompensateEngineNo" class="readonly" readonly="true" maxlength=20 description="发动机号" value="<bean:write name='prpLcompensateDto' property='engineNo'/>"> 
    </td>
  </tr>
  
  <tr> 
    <td class="title"> 出险时间:</td>
    <td class="input" colspan="3"> <input type=text name="prpLcompensateDamageStartDate" class="readonly" readonly="true" maxlength="10" style="width:250px" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' /> 日 <bean:write name='prpLcompensateDto' property='damageStartHour' filter='true' /> 时 <bean:write name='prpLcompensateDto' property='damageStartMinute' filter='true' /> 分">
    <input type="hidden" name="DamageStartDate" value="<bean:write name='prpLcompensateDto' property='damageStartDate' filter='true' />">
    </td>
  </tr>
  <tr> 
    <td class="title"> 出险地点:</td>
    <td colspan="3" class="input"> <input type=text name="prpLcompensateDamageAddress" title="出险地" style="width:300px" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='damageAddress' filter='true' />"> 
    </td>
  </tr>
  <tr> 
    <td class="title"> 保险金额:</td>
    <td class="input"> <input name="prpLcompensateSumAmount" type="text" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='sumAmount' filter='true' format='##0.00'/>"> 
    </td>
    <td class="title"> 估损金额:</td>
    <td class="input"> <input class="readonly" readonly name="prpLcompensateSumClaim" description="保险损失金额" value="<bean:write name='prpLcompensateDto' property='sumClaim' filter='true' format='##0.00'/>"> 
    </td>
  </tr>  
<% 
    if ("RISKCODE_DAZ".equals(configCode )||"RISKCODE_DAY".equals(configCode )||"RISKCODE_DAU".equals(configCode ))
    {
%>
      <tr>    
    <td class='title'>事故责任:</td>
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
    <td class='title'>事故责任:</td>
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
    <td class="title" style="width:15%">是否涉及三者死亡：</td>
    <td class="input" style="width:35%">
      <select name="prpLpersonWoundGrade" class='common' style="width:110">
         <option selected="selected" ></option>
       	 <option value="0" <%=prpLcompensateDto.getWoundGrade().trim().equals("0") ? "selected" : "" %>>无</option>
         <option value="1" <%=prpLcompensateDto.getWoundGrade().trim().equals("1") ? "selected" : "" %>>有</option>
      </select><img src="/claim/images/bgMarkMustInput.jpg">
    </td>
	 <td class="title" style="width:15%">赔案类别：</td>
    <td class="input" style="width:35%">
      <html:select name="prpLcompensateDto" property="claimType" onchange="changeClaimType(this)" >
              <html:options collection="claimTypes" property="codeCode" labelProperty="codeCName"/>          
      </html:select>
      <input type="hidden" name ="oldClaimType" value="<bean:write name='prpLcompensateDto' property='claimType' filter='true' />">
    </td>
  </tr>

    <tr>
    <td class="title" > 是否自动结案:   </td>
    <td class="input">  
      <input type="radio" onclick="changePrpLcompensateFinallyFlag()"  name="prpLcompensateFinallyFlag" value="1" <%=!"0".equals(prpLcompensateDto.getFinallyFlag()) ? "checked" : "" %>>是
      <input type="radio" onclick="changePrpLcompensateFinallyFlag()"  name="prpLcompensateFinallyFlag" value="0" <%="0".equals(prpLcompensateDto.getFinallyFlag()) ? "checked" : "" %>>否
    </td> 
    
    <td class="title"> 是否有追偿:</td>
    <td class="input"> 
        <input type="text" class="readonly" readonly="true" value="<bean:write name='prpLcompensateDto' property='replevyFlag' filter='true' />"> 
    </td>
    </tr>
    
    <tr> 
        <td class="title"> 零赔付原因: </td>
        <td class="input" colspan="3">
            <select style="width:30%" name="prpLcompensateZeroLossType" id="prpLcompensateZeroLossType" onchange="changeZeroLossCaseType(this)">
                    <option  value="">---- 请选择 ----</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="1">selected</logic:equal> value="1">注销</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="2">selected</logic:equal> value="2">拒赔</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="3">selected</logic:equal> value="3">正常</option>
                    <option <logic:equal name="prpLcompensateDto" property="zeroLossType" value="4">selected</logic:equal> value="4">业务员操作错误</option>
            </select>
        </td>
    </tr>
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
    <tr>
        <td class="title" id="detailReasonOne" colspan="4" style="display:none">详细原因：</td>
    </tr>
    <tr>
        <td class="input" id="detailReasonTwo" colspan="4" align="center" style="display:none">
             <textarea name='prpLcompensateDetailReason' wrap="hard" rows=10 cols=80 class=common ><bean:write name='prpLcompensateDto' property='zeroLossDetailReason' filter='true' /></textarea>
         </td>
   </tr> 
    
</table>
