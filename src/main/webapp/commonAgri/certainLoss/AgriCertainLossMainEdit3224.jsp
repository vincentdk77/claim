<%--
****************************************************************************
* DESC       ���������Ϣ�ӿ����ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-13   
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 

<script>
//�������������
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }
  if(strValue.length != 8 && strValue.length != 10)
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD�������λҪ��0");
    field.focus();
    field.select();
    return false;
  }
  if(isNumeric(strValue ))
  {
     if(strValue.length == 8)
    {
      strValue = strValue.substring(0,4) + DATE_DELIMITER + strValue.substring(4,6) + DATE_DELIMITER + strValue.substring(6);
      field.value = strValue;
    }
    else
    {
     errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
       field.value="";
       field.focus();
       field.select();
       return false;
    }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ���ڣ���ʽΪYYYY-MM-DD ����YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//���������Ƿ������ֵ�У��
function isNumeric(strValue)
{
  var result = regExpTest(strValue,/\d*[.]?\d*/g);
  return result;
}

//RegExt Test
function regExpTest(source,re)
{
  var result = false;

  if(source==null || source=="")
    return false;

  if(source==re.exec(source))
    result = true;

  return result;
}

//�������򰴼�ʱ������У��
function pressFullDate(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="/" || value=="-")
    return true;
  else
    return false;
}

//���������Ƿ������ڵ�У�飬splitChar����ȱʡΪ"-"
function isDate(date,splitChar)
{
  var charSplit = (splitChar==null?"-":splitChar);
  var strValue = date.split(charSplit);

  if(strValue.length!=3) return false;

  var intYear  = parseInt(strValue[0],10);
  var intMonth = parseInt(strValue[1],10)-1;
  var intDay   = parseInt(strValue[2],10);

  var dt = new Date(intYear,intMonth,intDay);
  if( dt.getFullYear() != intYear ||
      dt.getMonth() != intMonth ||
      dt.getDate() != intDay
     )
  {
    return false;
  }
  return true;
}

function changeLxr()
{
	var prpLregistReportorName  = fm.prpLregistReportorName.value;
	
	if(trim(fm.prpLregistLinkerName.value).length==0){
  	fm.prpLregistLinkerName.value=prpLregistReportorName;
  }
}
</script>





<%
String strViewUrl = AppConfig.get("sysconst.GIS_RFFeildView_URL");
//add by lixiang start 2005-7-28
//ȡ����ϵͳ�ĵ�ַ
String coreWebUrl = AppConfig.get("sysconst.Core_URL");
//add by lixiang end 2005-7-28
 %>
<script language="javascript">
  /**
 *@description ��������ҳ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */   
function relatePolicy(){	   
		var policyNo = fm.prplCheckPolicyNoShow.value;  
	  var linkURL = "<%= coreWebUrl %>"+"/0501/tbcbpg/UIPrPoEn0501Show.jsp?"
	                     + "BIZTYPE=POLICY"
	                     + "&BizNo=" + policyNo 
	                     + "&SHOWTYPE=SHOW";
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
}
function viewGis(){
	url = "<%=strViewUrl %>?RFNO=<%=request.getAttribute("GisRichFlyCode") %>&RegistNO=<%=request.getAttribute("GisRegistNo") %>";
	//alert(url);
   	window.open(url,"��ͼ��Ϣ","width=600,height=400,status=yes,menubar=yes,location=yes,resizable=yes,scrollbars=yes");
} 
</script>  
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class="title" colspan="4">����Ǽ�
        <input type="hidden" name="prpLverifyLossClaimNo"              value="<bean:write name='prpLverifyLossDto' property='claimNo'/>">             
        <input type="hidden" name="prpLverifyLossRiskCode"             value="<bean:write name='prpLverifyLossDto' property='riskCode'/>">            
        <input type="hidden" name="prpLclaimRiskCode"                  value="<bean:write name='prpLverifyLossDto' property='riskCode'/>">            
        <input type="hidden" name="prpLverifyLossLicenseColorcode"     value="<bean:write name='prpLverifyLossDto' property='licenseColorcode'/>">    
        <input type="hidden" name="prpLverifyLossCarKindCode"          value="<bean:write name='prpLverifyLossDto' property='carKindCode'/>">         
        <input type="hidden" name="prpLverifyLossSumPreDefLoss"        value="<bean:write name='prpLverifyLossDto' property='sumPreDefLoss'/>">       
        <input type="hidden" name="prpLverifyLossSumDefLoss"           value="<bean:write name='prpLverifyLossDto' property='sumDefLoss'/>">          
        <input type="hidden" name="prpLverifyLossMakeCom"              value="<bean:write name='prpLverifyLossDto' property='makeCom'/>">             
        <input type="hidden" name="prpLverifyLossComCode"              value="<bean:write name='prpLverifyLossDto' property='comCode'/>">            
        
        <input type="hidden" name="prpLverifyLossUnderWriteCode"       value="<bean:write name='prpLverifyLossDto' property='underWriteCode'/>">      
        <input type="hidden" name="prpLverifyLossUnderWriteName"       value="<bean:write name='prpLverifyLossDto' property='underWriteName'/>">      
        <input type="hidden" name="prpLverifyLossUnderWriteEndDate"    value="<bean:write name='prpLverifyLossDto' property='underWriteEndDate'/>">   
        <input type="hidden" name="prpLverifyLossUnderWriteFlag"       value="<bean:write name='prpLverifyLossDto' property='underWriteFlag'/>">      
        <input type="hidden" name="coreWebUrl"       value="<%=coreWebUrl %>">      
        
        
        <input type="hidden" name="prpLverifyLossFlag"                 value="<bean:write name='prpLverifyLossDto' property='flag'/>"> 
        <input type="hidden" name="prpLverifyLossLossItemCode"         value="-2">   
        <input type="hidden" name="prpLverifyLossLossItemName"         value="<bean:write name='prpLverifyLossDto' property='lossItemName'/>">   
        <input type="hidden" name="prpLverifyLossInsureCarFlag"        value="<bean:write name='prpLverifyLossDto' property='insureCarFlag'/>"> 
        <input type="hidden" name="prpLverifyLossRegistNo" value="<bean:write name='prpLverifyLossDto' property='registNo'/>">
        <input type="hidden" name="prpLverifyLossPolicyNo" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='policyNo'/>">          
        <input type="hidden" name="prpLverifyLossInsuredName" value="<bean:write name='prpLverifyLossDto' property='insuredName'/>">
        <input type="hidden" name="prpLverifyLossLicenseNo" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='licenseNo'/>">          
        <input type="hidden" name="prpLverifyLossLicenseColor" value="<bean:write name='prpLverifyLossDto' property='licenseColor'/>">
        <input type="hidden" name="prpLverifyLossCarKind" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='carKind'/>">          
        <input type="hidden" name="prpLverifyLossClauseName" value="<bean:write name='prpLverifyLossDto' property='clauseName'/>">
        <input type="hidden" name="prpLverifyLossCurrencyName" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='currencyName'/>">          
        <input type="hidden" name="prpLverifyLossCurrency" value="<bean:write name='prpLverifyLossDto' property='currency'/>">          
        <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
        <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
        <input type="hidden" name="damageStartDate" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />">
        <input type="hidden" name="nextNodeNo" value="verif" />        
        <%//add by lixiang start at 2006-4-24
          //reason :���������˻ض���Ļ���%>
        <input type="hidden" name="prpLverifyLossCompensateFlag" value="<bean:write name='prpLverifyLossDto' property='compensateFlag'/>">
        <input type="hidden" name="prpLverifyLossCompensateOpinion" value="<bean:write name='prpLverifyLossDto' property='compensateOpinion'/>">          
        <input type="hidden" name="prpLverifyLossCompensateBackDate" value="<bean:write name='prpLverifyLossDto' property='compensateBackDate'/>">          
        <input type="hidden" name="prpLverifyLossCompensateApproverCode" value="<bean:write name='prpLverifyLossDto' property='compensateApproverCode'/>">          
        <input type="hidden" name="prpLverifyLossDtoStatus" value="<bean:write name='prpLverifyLossDto' property='status'/>">
        <%//reason :�˱�־Ϊ1��˵���������µ�һ����¼�����Բ���ֱ���ύ�������ˣ��ճ���%>
        <input type="hidden" name="NextComeBackCompensate" >          
         <%//add by lixiang end at 2006-4-24%>
      </td>   
    </tr>   
     
    <tr>
      <td class="title" style="width:15%">������:</td>   
      <td class="input" style="width:35%">    
        <input type=text name="prplCheckPolicyNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistDto' property='policyNo'/>"><input type="button" name="btPolicyRelate" value="������Ϣ" class='bigbutton' onclick="backWardPolicy('<bean:write name='prpLregistDto' property='policyNo'/>','<bean:write name='prpLregistDto' property='riskCode'/>','<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />');">    
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >������:</td>
      <td class="input" style="width:35%">   
        <input type=text name="prplCheckClaimNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDtoTemp' property='claimNo'/>">            
        <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prplCheckPolicyNoShow.value);return false;">
      </td> 

     
    </tr> 
    
  <%//add by zhaolu start at 2006-6-9
    //reason:ǿ����ʾ
    if(request.getAttribute("prpLregistRPolicyNo")!= null){
  %>
   <tr>
      <td class="title" style="width:15%" style="valign:bottom" >ǿ�Ʊ�����:</td>
      <td class="input" style="width:35%">   
         <input type=text name="prplCheckPolicyBzNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistRPolicyNo' property='policyNo'/>"><input type="button" name="btPolicyRelate" value="ǿ�Ʊ�����Ϣ" class='bigbutton' onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>','<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />');">       
      </td> 
      <td class="title" style="width:15%"></td>   
      <td class="input" style="width:35%">    
      </td>  
    </tr> 
<%
 }
//add by zhaolu end at 2006-6-10
%>         
    <tr>
      <td class="title" style="width:15%">������:</td>  
      <td class="input" style="width:35%" >  
        <input type=text name="prplCheckRegistNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistDto' property='registNo'/>">
        <input type="button" name="btRegistRelate" value="������Ϣ" class='button' onclick="relateRegist();return false;">
        <logic:equal value="1" name="IsDisplayGisViewInfo">
        	<input type=button class="button" name="GisViewInfo" value="��ͼ��Ϣ" onclick="viewGis();">
        </logic:equal>
        
        
      </td> 
      <td class="title" style="width:15%" style="valign:bottom" >�ѳ��մ���:</td> 
      <td class="input" style="width:35%">
        <%-- ������Ϣ���� --%> 
        <%@include file="/commonAgri/certainLoss/AgriExistRegist.jsp"%> 
      </td>
    </tr>     
    
<logic:notEqual name="prpLverifyLossDto" property="lossItemCode" value="0">
    <tr>
      <td class="title" style="width:15%">����ʱ��:</td>   
      <td class="common" style="width:35%">     
        <input type=text name="prpLregistDamageStartDate1" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />">��
        <input type=text name="prpLregistDamageStartHour1" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true' />">ʱ
        <input type=text name="prpLregistDamageStartMinute1" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true' />">��
      </td>   
      <td class="title" style="width:15%" style="valign:bottom" >���յص�:</td>
      <td class="common" style="width:35%">   
        <input type=text name="prpLregistDamageAddress" class="readonly" readonly style="width:350px" value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">
      </td> 
    </tr>   
      
    <tr>
      <td class="title" style="width:15%">�鿱ʱ��:</td>   
      <td class="common" style="width:35%">    
              <bean:write name='prpLcheckDtoTemp' property='checkDate'/> 
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >�鿱�ص�:</td>
      <td class="common" style="width:35%">   
             <bean:write name='prpLcheckDtoTemp' property='checkSite'/> 
      </td>  
    </tr>  
    <tr>
      <td class="title" style="width:15%">�Ƿ��һ�ֳ��鿱:</td>   
      <td class="common" style="width:35%">    
        <logic:equal name="prpLcheckDtoTemp" property="firstSiteFlag" value="0">��</logic:equal>
        <logic:equal name="prpLcheckDtoTemp" property="firstSiteFlag" value="1">��</logic:equal> 
      </td>   
      <td class="title" style="width:15%" style="valign:bottom" ></td>
      <td class="common" style="width:35%">    
        <%--modify by liujianbo modify 20050316 start--%>
        <%--resson:��ť̫С--%> 
          <input type="button" class='bigbutton' value="�鿴�鿱��Ϣ"  onclick="relateCheck();return false;">     
        <%--modify by liujianbo modify 20050316 end--%>
        <!--<input type="button" class='button' value="�鿴�����ʧ">   -->
      </td>  
    </tr> 
    <tr>
      <td class="title" style="width:15%">�鿱��1:</td>   
      <td class="common" style="width:35%">    
             <bean:write name='prpLcheckDtoTemp' property='checker1'/> 
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >�鿱��2:</td>
      <td class="common" style="width:35%"> 
             <bean:write name='prpLcheckDtoTemp' property='checker2'/>  
      </td> 
    </tr>  
    <tr>
      <td class="title" style="width:15%">����ʱ��:</td>   
      <td class="common" style="width:35%">    
          <input name="prpLverifyLossDefLossDate"  description ="��������" class="input" style="width:140px"  value="<bean:write name='prpLverifyLossDto' property='defLossDate' />"  onKeyPress="pressFullDate(this)" onblur="checkFullDate(this)">         
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >������Ա:</td>
      <td class="common" style="width:35%">   
           
        <input name="prpLverifyLossHandlerCode"  class="codecode" style="width:40%"  value="<bean:write name='prpLverifyLossDto' property='handlerCode'/>">         
        <input name="prpLverifyLossHandlerName"  class='codename' maxlength=60  style="width:45%" value="<bean:write name='prpLverifyLossDto' property='handlerName'/>"> 
      </td>  
    </tr> 
    <tr>
      <td class="title" style="width:15%">�⸶����:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossLossesNumber" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='lossesNumber'/>" onblur="checkStatQuantity(this)">        
           <html:select name="prpLverifyLossDto" property="lossesUnitCode" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
      <td class="title" style="width:15%">���ջ���:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDamageInsured" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='damageInsured'/>">        
          <img src="/claim/images/bgMarkMustInput.jpg">
      </td> 
    </tr>
    <logic:equal name="prpLregistDto" property="riskCode" value="3224">
            <tr>
      <td class="title" style="width:15%">�������:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDisasterArea" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='disasterArea'/>">        
          <html:select name="prpLverifyLossDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>   
      <td class="title" style="width:15%">�������:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossAffectedArea" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='affectedArea'/>">        
           <html:select name="prpLverifyLossDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
    </tr> 
     <tr>
      <td class="title" style="width:15%">�������:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossNoProductionArea" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='noProductionArea'/>">        
            <html:select name="prpLverifyLossDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" ></td>
      <td class="common" style="width:35%"></td>  
    </tr>  
        </tr> 
   </logic:equal>
</logic:notEqual>     
   
     
       <input type="hidden" name="prpLverifyLossFirstDefLoss"  value="<bean:write name='prpLverifyLossDto' property='firstDefLoss'  format='##0.00'/>">         
       <input type="hidden" name="prpLverifyLossWarpDefLoss"  value="<bean:write name='prpLverifyLossDto' property='warpDefLoss' format='##0.00'/>"> 
   
  </table>   
    

  <input type="hidden" name="PolicyNo" value="<bean:write name='prpLcheckDtoTemp' property='policyNo'/>"> 
  <input type="hidden" name="RegistNo" value="<bean:write name='prpLcheckDtoTemp' property='registNo'/>"> 
  <input type="hidden" name ="statQuantity" value="<%=request.getAttribute("statQuantity")%>"/>
 
