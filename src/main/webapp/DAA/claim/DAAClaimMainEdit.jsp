
<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��[ ���� ]
* AUTHOR     �� lixiang
* CREATEDATE �� 2004-04-13
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>
<!--modify by liuyanmei add 20051114 start-->
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<script type="text/javascript">
<!--

//-->
function printWindow(bizNo,strWindowName,bizType)
      {
        if(bizType == null ){
            strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + bizNo; 
        }else if(bizType == "P"){
            var reportorName = fm.prpLregistReportorName.value;//������
            var damageStartDate = fm.prpLregistDamageStartDate.value;//����ʱ��
            var damageStartHour = fm.prpLregistDamageStartHour.value;//����Сʱ
            var licenseNo = fm.prpLthirdPartyLicenseNo[1].value;//���ƺ���
            strUrl = "/claim/DAA/print/DAARegistNoneFormatPrint.jsp?printType=Regist&PolicyNo=" + bizNo + "&bizType=" + bizType ;
            strUrl += "&damageStartDate=" + damageStartDate;
            strUrl += "&damageStartHour=" + damageStartHour;  
            strUrl += "&licenseNo=" + licenseNo; 
        }else{
            strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + bizNo;
        }       
        var pageWidth=screen.availWidth-10;
        var pageHeight=screen.availHeight-30;
        
        if (pageWidth<100 )
          pageWidth = 100;
      
        if (pageHeight<100 )
          pageHeight = 100;
      
        var newWindow = window.open(strUrl,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      }
  function changeClaimType(field){
    	if(fm.prpLclaimRiskCode.value != '0507'
    	&&fm.prpLclaimRiskCode.value != '0577'
    	&&fm.prpLclaimRiskCode.value != '0587'){
    		if(field.value == "K"){
    			alert("��ҵ�ղ���ѡ��������!");
    			field.focus();
	    		return false;
    		}
    	}
  }    
    
</script>

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
//String  configCode  =(String) request.getAttribute("configCode");
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
 
 
 
 
 
 
 
 
 
 
 
 
 PrpLclaimDto  prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
 int intstartHour =0 ;
 int intendHour =0 ;
 String  startHour ="";
 String  endHour ="";
 intstartHour  = prpLclaimDto.getStartHour();
 intendHour    = prpLclaimDto.getEndHour();
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
<!--modify by liuyanmei add 20051114 end-->
<!--modify by wangli add start 20050529 start reason:���ι����� ������������α���-->
  <script language="javascript">
  function dutySum()
  {
    	
    	var compAmout =0;
	var nowAmout =0;

	//if (!checkLoss()) return false ;
	//ѭ������ �����

	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 		{
 			nowAmout =parseFloat(fm.prpLclaimLossSumClaim[n].value)
			compAmout = compAmout + nowAmout;
    }

	fm.prpLclaimDutySumClaim.value=pointTwo(compAmout);
    	
    	//return sum;
  }
 </script>
<!--modify by wangli add start 20050529 end-->
<%
       String policyNo = (String)prpLclaimDto.getPolicyNo();
       String bizNO = policyNo;
       String bizType = "P";
       if(!"".equals(prpLclaimDto.getRegistNo())){
    	   bizNO   = prpLclaimDto.getRegistNo();
    	   bizType = "R";
       }
%>
<style>
    DIV.spanBar{
        position: absolute;
        left:10px;
        z-index: 300;
        top:expression(offsetParent.scrollTop+5);
    }
</style>

	<table  cellpadding="4" cellspacing="1" class="common">
	<tr>
	<td class=button >
	<div id="spanMessage" class="spanBar">
	   <%if(isShowButton){ %>
	   <input type="button" name="message" class=bigbutton style="width:80px;" height="21" value="���⹵ͨ" onclick="return openWinSaveQuery(fm.prpLclaimRegistNo.value,fm.prpLclaimPolicyNo.value,fm.prpLclaimRiskCode.value,'claim','<%=prpLclaimDto.getClaimNo() %>','registNo',fm.prpLclaimRegistNo.value);">
	   <%} %>
	   <input type="button" class="bigbutton"  value="��������" style="width:80px"  onclick="printWindow('<%=bizNO%>','��ӡ1','<%=bizType %>')">
       <input title="����˴��ɻ���ѳ��������Ϣ"  type=button value='�����ⰸ' style="width:80px"  class="bigbutton"  name='button_Peril_Open_Context' onclick="buttonOnClick('perilInfoShow','<%=prpLclaimDto.getPolicyNo()%>','<%=prpLclaimDto.getRegistNo()%>');">
	   <input type="hidden" name="PerilCount"  value="1">
       <!--lijiyuan modify begin 2005-11-9  need certify all-->
       <input type="button" name="eCertify" class=bigbutton style="width:80px"  value="���ӵ�֤"   onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<%=prpLclaimDto.getRegistNo() %>','certa');">
       <input type="button" name="claimCancleShow" class="bigbutton" value="ע��/������Ϣ" onClick="openClaimCancle('<bean:write name='prpLclaimDto' property='claimNo'/>','<bean:write name='prpLclaimDto' property='registNo'/>','<bean:write name='prpLclaimDto' property='riskCode'/>');">
     </div>  
       </td> 	   
	   <!-- Modify By wangli add end 20050328-->
	</tr>
	</table>

    <br>
    <table  class=common cellpadding="5" cellspacing="1">
      <tr class=listtitle>
        <td  colspan="4">�����Ǽ� 
        <%if("1".equals(prpLclaimDto.getCaseType())){ %>
        (�Ѿ���)
        <%} %>
       
        <%if("0".equals(prpLclaimDto.getCaseType())){ %>
        (��ע��)
        <%} %>
          <input type="hidden" name="damageStartDate" value="<%=prpLclaimDto.getDamageStartDate() %>">
          <input type="hidden" name="prpLclaimRiskCode" value="<%=prpLclaimDto.getRiskCode() %>">
          <input type="hidden" name="prpLclaimOperatorCode" value="<%=prpLclaimDto.getOperatorCode() %>">
          <input type="hidden" name="prpLclaimMakeCom" value="<%=prpLclaimDto.getMakeCom() %>">		 		
				  <input type="hidden" name="prpLclaimEngineNo" >
				  <input type="hidden" name="prpLclaimFrameNo">
				  <input type="hidden" name="prpLclaimRunDistance">
				  <input type="hidden" name="prpLclaimLossName" value="<%=prpLclaimDto.getLossName() %>">					
				  <input type="hidden" name="prpLclaimSumDefLoss" value="<%=prpLclaimDto.getSumDefLoss() %>">		
          <input type="hidden" name="prpLclaimTypeForDriver" value="claim">					
          <input type="hidden" name="prpLclaimBusinessNature" value="<%=prpLclaimDto.getBusinessNature() %>">
          <input type="hidden" name="prpLclaimPolicyType" value="<%=prpLclaimDto.getPolicyType() %>"> 
           <%--�������� add by qinyongli--%>
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
           <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
           <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
           <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>"> 
          
<%
   Map limitMap =new HashMap();
   limitMap =(Map) request.getAttribute("limitMap");
   String limitType= "";
   String limitFee= "";
   //lixiang����������ʲô�ģ�Ϊʲô�д��󡣡���
   if (limitMap!=null){
   Set limitMapKey = limitMap.keySet();
   if (limitMapKey !=null&& limitMapKey.size()>0){
       for (Iterator limit = limitMapKey.iterator();limit.hasNext();) {
      	    limitType = (String)limit.next(); 
      	    limitFee  = (String) limitMap.get(limitType);
  %>    	    
     <input type="hidden" name="limitType" value="<%= limitType %>">   	 
     <input type="hidden" name="limitFee" value="<%= limitFee %>">   	 
 <%
     }
   }  
 }
  %>
          
          <input type="hidden" name="prpLclaimEditType" value="<%=editType %>" />
          <input type="hidden" name="prpLclaimClassCode" value="<bean:write name='prpLclaimDto' property='classCode' />">
          <input type="hidden" name="prpLclaimInputDate" value="<bean:write name='prpLclaimDto' property='inputDate' />">
          <input type="hidden" name="prpLclaimDamageEndDate" value="<bean:write name='prpLclaimDto' property='damageEndDate' />">
          <input type="hidden" name="prpLclaimDamageEndHour" value="<bean:write name='prpLclaimDto' property='damageEndHour' />">
          <input type="hidden" name="prpLclaimDamageEndMinute" value="<bean:write name='prpLclaimDto' property='damageEndMinute' />">
          <%-- 
	        <input type="hidden" name="prpLclaimDamageEndHour" value="<bean:write name='prpLclaimDto' property='damageEndHour' />">
          <input type="hidden" name="prpLclaimCurClaimDate" value="<bean:write name='prpLclaimDto' property='curClaimDate' />">		
          --%>
          <input type="hidden" name="prpLclaimLanguage" value="<bean:write name='prpLclaimDto' property='language' />">
          <input type="hidden" name="riskcode" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />">
          <!-- ���Ͳ�ѯʱʹ��fm.prpLregistRiskCode.value -->
          <input type="hidden" name="prpLregistRiskCode" value="<bean:write name='prpLclaimDto' property='riskCode' filter='true' />"> 
          <input type="hidden" name="policyno" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">    
          <!-- �����ṹ�ʹ����� -->
          <input type=hidden   name="prpLclaimHandler1Code" value="<bean:write name='prpLclaimDto' property='handler1Code' filter='true' />">
          <input type=hidden   name="prpLclaimHandler1Name" title="����ҵ��Ա" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handler1Name' filter='true' />">
          <input type=hidden   name="prpLclaimAgentCode"   title="������" value="<bean:write name='prpLclaimDto' property='agentCode' filter='true' />">
          <input type=hidden   name="prpLclaimAgentName"   title="������" value="<bean:write name='prpLclaimDto' property='agentName' filter='true' />">
        </td>
      </tr> 
      <tr>        
        <td class="title" style="width:15%"><bean:message key="db.prpLclaim.claimNo" />:</td>
        <td class="input" style="width:35%" >
           <input type=text name="prpLclaimClaimNo" title="������" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLclaimDto' property='claimNo' filter='true' />">
        </td>
        <td class="title" style="width:15%;valign:bottom" ><!--<bean:message key="db.prpLclaim.caseNo" />-->�鵵��:</td>
        <td class="input" style="width:35%;valign:middle">
          <input type=text name="prpLclaimCaseNo" title="�鵵��" class="readonly" readonly="true"  maxlength="22" style="width:140px" value="<bean:write name='prpLclaimDto' property='caseNo' filter='true' />">
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
          <input type=text name="prpLclaimRegistNo" title="������" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLclaimDto' property='registNo' filter='true' />">
           <input type="hidden" name="damageDate" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">
       
        </td>        
      </tr>
      
      <tr>
       <td class="title" ><bean:message key="db.prpLclaim.policyNo" />:</td>
       <td class="input" >
          <input type=text name="prpLclaimPolicyNo" class="readonly" readonly="true"   style="width:140px" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
        </td>
        
        <td class="title" >�ѳ��մ���:</td>
        <td class="input" > 
        <%-- ������Ϣ���� --%>
           <%@include file="/DAA/regist/DAAExistRegist.jsp"%>  
        </td>
      </tr>
        
      <tr>
        <td class="title"><bean:message key="db.prpLclaim.insuredName" />:</td>
        <td class="input"  colspan=3>  
        <logic:equal name='prpLclaimDto' property="customerType" value="1">
          <a href='/claim/processPrpDcustomerIdv.do?actionType=prepareUpdate&prpDcustomerIdvCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
        </logic:equal>  
        <logic:equal name='prpLclaimDto' property="customerType" value="2">
          <a href='/claim/processPrpDcustomerUnit.do?actionType=prepareUpdate&prpDcustomerUnitCustomerCode=<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />' target='_blank'>
        </logic:equal>
        <input type=hidden name="prpLregistInsuredCode" title="�������˴���" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredCode' filter='true' />">  
        <input type=hidden name="prpLclaimInsuredName" title="��������" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='insuredName' filter='true' />">
        <bean:write name='prpLclaimDto' property='insuredName' filter='true' />
          </a>
        </td>
      </tr>      
      
     <tr>
        <td class="title">�����ڼ�</td>
        <td class="input" colspan='3'>       
          <input type=text name="prpLclaimStartDate" title="������" class="readonly" style="width:80px" readonly="true"  value="<bean:write name='prpLclaimDto' property='startDate' filter='true' />"><%=startHour %>
          <input type=text name="prpLclaimEndDate"   title="�ձ�����" class="readonly" style="width:80px" readonly="true"   value="<bean:write name='prpLclaimDto' property='endDate' filter='true' />"><%=endHour %>
        
        </td>
      </tr>
      
      <tr>
        <td class="title">�������:</td>
        <td class="input" colspan=3>
          <input class="readonly" type=text name="prpLclaimClauseType" readonly="true"  style="width:30px" value="<bean:write name='prpLclaimDto' property='clauseType' filter='true' />">
          <input class="readonly" type=text name="prpLclaimClauseName" readonly="true"  style="width:300px"value="<bean:write name='prpLclaimDto' property='clauseName' filter='true' />">			
        </td>
      </tr>        
      <tr>
        <td class="title">���ƺ���:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimLicenseNo" readonly="true" value="<bean:write name='prpLclaimDto' property='licenseNo' filter='true' />">
        </td>
        
        <td class="title">���Ƶ�ɫ:</td>
        <td class="input">
          <input class="readonly"  name="prpLclaimLicenseColor" readonly="true" value="<bean:write name='prpLclaimDto' property='licenseColor' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimLicenseColorCode" value="<bean:write name='prpLclaimDto' property='licenseColorCode' filter='true' />">
        </td>        
      </tr>
      
      <tr>
        <td class="title">�����ͺ�:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimBrandName" readonly="true" value="<bean:write name='prpLclaimDto' property='brandName' filter='true' />">
        </td>
        <td class='title'>��������:</td>
        <td class='input'>
          <input name="prpLclaimCarKind"  class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='carKind' filter='true' />">
          <input class="readonly" type=hidden name="prpLclaimCarKindCode" value="<bean:write name='prpLclaimDto' property='carKindCode' filter='true' />">
        </td>      
      </tr>        
	    
	    <tr>
        <td class="title">�ұ�:</td>
        <td class="input">
          <input class="readonly" readonly name="prpLclaimCurrencyName" value="�����">
          <input class="readonly" type=hidden name="prpLclaimCurrency" value="CNY">
          <input class="readonly" type=hidden name="prpLclaimPolicyCurrency">					
        </td>        
        <td class="title">���ս��:</td>
        <td class="input">
          <input class="readonly" name="prpLclaimSumAmount" readonly="true" value="<bean:write name='prpLclaimDto' property='sumAmount' filter='true' format='##0.00'/>">
          <input type="hidden" name="prpLclaimSumPremium" readonly="true" value="<bean:write name='prpLclaimDto' property='sumPremium' filter='true' format='##0.00'/>"> 
        </td>        
      </tr>      
      <tr>
        <td class="title">����ʱ��:</td>
        <td class="input">
          <input type=text name="prpLclaimDamageStartDate" title="����ʱ��" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='prpLclaimDto' property='damageStartDate' filter='true' />">��
          <input type=text name="prpLclaimDamageStartHour" title="����Сʱ" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartHour' filter='true' />">ʱ
          <input type=text name="prpLclaimDamageStartMinute" title="���շ���" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLclaimDto' property='damageStartMinute' filter='true' />">��
          
        </td>
        
        <td class="title"><bean:message key="db.prpLclaim.damageName" />:</td>
        <td class="input">
            <input type=text class="codecode" name="prpLclaimDamageCode"  style="width:15%" title="����ԭ��" value="<bean:write name='prpLclaimDto' property='damageCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onchange="code_CodeChange(this, 'DamageCode','1' ,'code','','clear','change');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','1' ,'code','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','1' ,'code','','clear','change');">
           <input type=text class="codecode" name="prpLclaimDamageName"  title="����ԭ��" style="width:63%" value="<bean:write name='prpLclaimDto' property='damageName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onchange="code_CodeChange(this, 'DamageCode','-1','name','','clear','change');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','name','','clear','select');"
             onblur= "code_CodeChange(this, 'DamageCode','-1','name','','clear','change');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
          <img src="/claim/images/bgMarkMustInput.jpg">
          
        </td>
      </tr>
      
      <tr>
        <td class="title"><bean:message key="db.prpLclaim.damageTypeName" />:</td>
        <td  class="input">
          <input type=text name="prpLclaimDamageTypeCode" class="codecode"  style="width:15%" title="�¹�����" value="<bean:write name='prpLclaimDto' property='damageTypeCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onchange="code_CodeChange(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');">
          <input type=text name="prpLclaimDamageTypeName" class="codecode" title="�¹�����" style="width:63%" value="<bean:write name='prpLclaimDto' property='damageTypeName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageTypeCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','name','none','post');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">   
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title"><bean:message key="db.prpLclaim.damageAreaName" />:</td>
        <td class="input">
          <input type=text name="prpLclaimDamageAreaCode" class="codecode" style="width:15%" title="��������" value="<bean:write name='prpLclaimDto' property='damageAreaCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode');"
             onchange="code_CodeChange(this, 'DamageAreaCode');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');">
          <input type=text name="prpLclaimDamageAreaName" class="codecode" style="width:63%" title="��������"  value="<bean:write name='prpLclaimDto' property='damageAreaName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageAreaCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <%--modify by liujianbo modify 20050311 start--%>  
      <%--resson:���յش���ȥ��--%>  
      <input type="hidden" name="prpLclaimAddressCode" value="<bean:write name='prpLclaimDto' property='addressCode' filter='true' />">
      <!--
        <tr>
          <td class="title">���յش���:</td>
          <td class="input" colspan='3'>
            <input type=text name="prpLclaimAddressCode"  title="���յش���" class="input"  style="width:80px" value="<bean:write name='prpLclaimDto' property='addressCode' filter='true' />">
          </td>  
        </tr>      
      -->
      <%--modify by liujianbo modify 20050311 end--%>
      
      <tr>
        <td class="title"><bean:message key="db.prpLclaim.damageAddress" />:</td>
        <td class="input" colspan='3'>
<!--    
          <input type=text name="prpLclaimDamageAddressType" title="���յ�" class="codecode" style="width:90px" value="<bean:write name='prpLclaimDto' property='damageAddressType' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageAddress');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode');">
-->          
          <%--modify by caopeng modify 20051215 start--%>  
          <%--resson:����ʱ���յص�ӦΪ���ǿ�ѡ��������--%> 
          <%--<input type=text name="prpLclaimDamageAddress" title="���յ�" class="codecode" style="width:340px" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageAddress','-1','name','none','post');"
             onchange="code_CodeChange(this, 'DamageAddress','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageAreaCode','-1','name','none','post');">--%>
             <input type="hidden" name="prpLclaimDamageAddressType" value="<bean:write name='prpLclaimDto' property='damageAddressType' filter='true' />">
             <input type=text name="prpLclaimDamageAddress" title="���յ�" class="input" style="width:340px" value="<bean:write name='prpLclaimDto' property='damageAddress' filter='true' />">
          <%--modify by capeng modify 20051215 end--%> 
        </td>
      </tr>
      <tr>    
        <td class="title"><bean:message key="db.prpLclaim.claimDate" />:</td>
        <td class="input" colspan="3">
          <input type=hidden name="prpLclaimReportDate" description="��������" >
          <input type=hidden name="prpLclaimToday" description="��ǰ����" >
          <input type=hidden name="prpLclaimClaimTime" description="��������(��ȷ)" value="<bean:write name='prpLclaimDto' property='claimTime' filter='true' />">
          <input class="input"  style="width:30%" name="prpLclaimClaimDate" description="��������"  readonly="readonly" value="<bean:write name='prpLclaimDto' property='claimDate' filter='true' />" >
                <img src="/claim/images/bgMarkMustInput.jpg">
        </td> 
      </tr>

      <tr>
        <td class='title'>�Ƿ������׷��:</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="replevyFlag" style="width:60">
            <html:option value="0">��</html:option>
            <html:option value="1">��</html:option>
           </html:select>        	
        </td>
        <td class='title'>�Ƿ������������н����:</td>
        <td class='input' style="width:35%">
          <html:select name="prpLclaimDto" property="thirdComFlag"  style="width:60">
            <html:option value="0">��</html:option>
            <html:option value="1">��</html:option>
           </html:select>        	
        </td>
      </tr>

      
      <tr>
        <td class='title'>�¹�����:</td>
        <td class='input' >
        
          <html:select name="prpLclaimDto" property="indemnityDuty" style="width:90%" onclick="changeIndemnityDuty();collectClaimLoss();dutySum();"  onblur="changeSumClaim();collectClaimLoss();dutySum();">
            <html:options collection="indemnityDutys" property="codeCode" labelProperty="codeCName"/>          
          </html:select>
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class='title' style="display:"  >���α���:</td>
        <td class='input' style="display:"  >
        	
          <input class="common" name='prpLclaimIndemnityDutyRate' description="���α���" value="<bean:write name='prpLclaimDto' property='indemnityDutyRate' filter='true' />" onchange="changeSumClaim();changeIndemnityDuty1();dutySum();"  onblur="changeSumClaim();changeIndemnityDuty1();collectClaimLoss();dutySum();"  > 
        </td>
        <td class='title' ></td>
        <td class='title' ></td>
      </tr>
      
      <tr>
        <td class='title'>������ʧ���:</td>
        <td class='input'>
          <input name="prpLclaimSumClaim" class="readonly" readonly  onchange="dutySum();">
        </td>
        
        <td class='title'>���ι�����:</td>
        <td class='input'>
          <input class="input" name="prpLclaimDutySumClaim"  class="readonly" readonly value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format='##0.00'/>">
        </td>
      </tr>   
      
      <tr>
        <td class='title'><bean:message key="db.prpLregist.claimType" />:</td>
        <td class='input'>        
         <html:select name="prpLclaimDto" property="claimType" style="width:30%" onblur="changeClaimType(this)">
           <html:options collection="claimTypes" property="codeCode" labelProperty="codeCName"/>          
         </html:select>          
        </td>  
        <td class='input' colspan="2">
        <%--modify by wangli update start 20050407 --%>
         <%--resson:ȫ�𼰷�ȫ�� ��ͥ���������Ϊ������������--%> 
          <%--modify by liujianbo modify 20050311 start--%>  
         
            <%-- //<input type="hidden" name="escapeFlag2" value="" >      --%>
            <html:radio name="prpLclaimDto" property="escapeFlag" value="N">��ȫ��</html:radio>
            <html:radio name="prpLclaimDto" property="escapeFlag" value="Y">ȫ�� </html:radio>
            <html:radio name="prpLclaimDto" property="escapeFlag" value="F">������������</html:radio>
            
          <%--modify by liujianbo modify 20050311 end--%>
          <%--modify by wangli update start 20050407 --%>
        </td>
      </tr> 
      <tr>
       <td class="title"><bean:message key="db.prpLclaim.comCode" />:</td>
        <td class="input">
          <input type=hidden name="prpLclaimComCode" value = "<bean:write name='prpLclaimDto' property='comCode' filter='true' />">
          <%--��Ҫת���������˵�����--%>
          <input type=hidden name="prpLclaimComCode" title="ҵ���������" class="readonly" readonly="true" value = "<bean:write name='prpLclaimDto' property='comCode' filter='true' />">
          
          <input type=text   name="prpLclaimComName" title="ҵ���������" class="readonly" readonly="true" value = "<bean:write name='prpLclaimDto' property='comName' filter='true' />">
        
        </td>
        <td class='title'><bean:message key="db.prpLclaim.handlerCode" />:</td>
        <td class='input' >
          <input name="prpLclaimHandlerCode" class="codecode" style="width:60%" value="<bean:write name='prpLclaimDto' property='handlerCode' filter='true' />"
              ondblclick="code_CodeSelect(this, 'HanderCode');"
              onchange="code_CodeChange(this, 'HanderCode');"
              onkeyup= "code_CodeSelect(this, 'HanderCode');">
    
          <input name="prpLclaimHandlerName" class="codename" style="width:35%"  title="������" value="<bean:write name='prpLclaimDto' property='handlerName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
             onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');">
        </td>
      </tr>
    </table>