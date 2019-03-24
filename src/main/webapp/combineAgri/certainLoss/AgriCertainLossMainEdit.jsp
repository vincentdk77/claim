<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13   
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<script>
//检查日期输入域
function checkFullDate(field)
{
  field.value = trim(field.value);
  var strValue = field.value;
  var desc   = field.description;
  //如果description属性不存在，则用name属性
  if(desc==null)
    desc = field.name;
  if(strValue=="")
  {
    return false;
  }
  if(strValue.length != 8 && strValue.length != 10)
  {
    errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD，不足的位要补0");
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
     errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD");
       field.value="";
       field.focus();
       field.select();
       return false;
    }
  }
  if( !isDate(strValue,DATE_DELIMITER) && !isDate(strValue)||strValue.substring(0,1)=="0")
  {
    errorMessage("请输入合法的" + desc +"\n类型为日期，格式为YYYY-MM-DD 或者YYYYMMDD");
    field.value="";
    field.focus();
    field.select();
    return false;
  }
  return true;
}

//对输入域是否是数字的校验
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

//对输入域按键时的日期校验
function pressFullDate(e)
{
  var value = String.fromCharCode(e.keyCode);
  if((value>=0 && value<=9) || value=="/" || value=="-")
    return true;
  else
    return false;
}

//对输入域是否是日期的校验，splitChar参数缺省为"-"
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






<script language="javascript">
  /**
 *@description 弹出关联页面
 *@param       无
 *@return      通过返回true,否则返回false
 */   
function relatePolicy(){	 
		var policyNo = fm.prplCheckPolicyNoShow.value;  
	  var linkURL = "<%= coreWebUrl %>"+"/0501/tbcbpg/UIPrPoEn0501Show.jsp?"
	                     + "BIZTYPE=POLICY"
	                     + "&BizNo=" + policyNo 
	                     + "&SHOWTYPE=SHOW";
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
} 
</script>  
<%String prpLcheckDtoTemp = "";
String prpLregistDto = "";
String prpLregistDto1 = "";
String prpLverifyLossDto = "";
String prpLregistRPolicyNo = "";
String lossesUnitCodeCollection = "";
iterator = PrplcombineDtos.iterator();
while(iterator.hasNext()){iterator.next();%>
<span  id="spanMain_<%=idxMain%>" style = "display:none" cellspacing="1" cellspacing="0"  width="100%">
<%
prpLcheckDtoTemp = "prpLcheckDtoTemp_"+String.valueOf(idxMain);
prpLregistDto = "prpLregistDto_"+String.valueOf(idxMain);
prpLregistDto1 = "prpLregistDto1_"+String.valueOf(idxMain);
prpLverifyLossDto = "prpLverifyLossDto_"+String.valueOf(idxMain);
prpLregistRPolicyNo  = "prpLregistRPolicyNo_"+String.valueOf(idxMain);
lossesUnitCodeCollection = "lossesUnitCodeCollection_"+String.valueOf(idxMain);
%>

  <table class=common cellpadding="5" cellspacing="1" >
    <tr>
      <td class="title" colspan="4">
        <input type="hidden" name="prpLverifyLossClaimNo_<%=idxMain%>"              value="<bean:write name='<%=prpLverifyLossDto%>' property='claimNo'/>">             
        <input type="hidden" name="prpLverifyLossRiskCode_<%=idxMain%>"             value="<bean:write name='<%=prpLverifyLossDto%>' property='riskCode'/>">            
        <input type="hidden" name="prpLclaimRiskCode_<%=idxMain%>"                  value="<bean:write name='<%=prpLverifyLossDto%>' property='riskCode'/>">            
        <input type="hidden" name="prpLverifyLossLicenseColorcode_<%=idxMain%>"     value="<bean:write name='<%=prpLverifyLossDto%>' property='licenseColorcode'/>">    
        <input type="hidden" name="prpLverifyLossCarKindCode_<%=idxMain%>"          value="<bean:write name='<%=prpLverifyLossDto%>' property='carKindCode'/>">         
        <input type="hidden" name="prpLverifyLossSumPreDefLoss_<%=idxMain%>"        value="<bean:write name='<%=prpLverifyLossDto%>' property='sumPreDefLoss'/>">       
        <input type="hidden" name="prpLverifyLossSumDefLoss_<%=idxMain%>"           value="<bean:write name='<%=prpLverifyLossDto%>' property='sumDefLoss'/>">          
        <input type="hidden" name="prpLverifyLossMakeCom_<%=idxMain%>"              value="<bean:write name='<%=prpLverifyLossDto%>' property='makeCom'/>">             
        <input type="hidden" name="prpLverifyLossComCode_<%=idxMain%>"              value="<bean:write name='<%=prpLverifyLossDto%>' property='comCode'/>">            
        
        <input type="hidden" name="prpLverifyLossUnderWriteCode_<%=idxMain%>"       value="<bean:write name='<%=prpLverifyLossDto%>' property='underWriteCode'/>">      
        <input type="hidden" name="prpLverifyLossUnderWriteName_<%=idxMain%>"       value="<bean:write name='<%=prpLverifyLossDto%>' property='underWriteName'/>">      
        <input type="hidden" name="prpLverifyLossUnderWriteEndDate_<%=idxMain%>"    value="<bean:write name='<%=prpLverifyLossDto%>' property='underWriteEndDate'/>">   
        <input type="hidden" name="prpLverifyLossUnderWriteFlag_<%=idxMain%>"       value="<bean:write name='<%=prpLverifyLossDto%>' property='underWriteFlag'/>">      
        
        
        <input type="hidden" name="prpLverifyLossFlag_<%=idxMain%>"                 value="<bean:write name='<%=prpLverifyLossDto%>' property='flag'/>"> 
        <input type="hidden" name="prpLverifyLossLossItemCode_<%=idxMain%>"         value="-2">   
        <input type="hidden" name="prpLverifyLossLossItemName_<%=idxMain%>"         value="<bean:write name='<%=prpLverifyLossDto%>' property='lossItemName'/>">   
        <input type="hidden" name="prpLverifyLossInsureCarFlag_<%=idxMain%>"        value="<bean:write name='<%=prpLverifyLossDto%>' property='insureCarFlag'/>"> 
        <input type="hidden" name="prpLverifyLossRegistNo_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='registNo'/>">
        <input type="hidden" name="prpLverifyLossPolicyNo_<%=idxMain%>" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='policyNo'/>">          
        <input type="hidden" name="prpLverifyLossInsuredName_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='insuredName'/>">
        <input type="hidden" name="prpLverifyLossLicenseNo_<%=idxMain%>" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='licenseNo'/>">          
        <input type="hidden" name="prpLverifyLossLicenseColor_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='licenseColor'/>">
        <input type="hidden" name="prpLverifyLossCarKind_<%=idxMain%>" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='carKind'/>">          
        <input type="hidden" name="prpLverifyLossClauseName_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='clauseName'/>">
        <input type="hidden" name="prpLverifyLossCurrencyName_<%=idxMain%>" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='currencyName'/>">          
        <input type="hidden" name="prpLverifyLossCurrency_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='currency'/>">          
        <input type="hidden" name="swfLogFlowID_<%=idxMain%>" value="<%= request.getAttribute("swfLogFlowID_"+idxMain) %>">
        <input type="hidden" name="swfLogLogNo_<%=idxMain%>" value="<%= request.getAttribute("swfLogLogNo_"+idxMain) %>">
        <input type="hidden" name="damageStartDate_<%=idxMain%>" value="<bean:write name='<%=prpLregistDto%>' property='damageStartDate' filter='true' />">
        <input type="hidden" name="nextNodeNo_<%=idxMain%>" value="verif" />        
        <%//add by lixiang start at 2006-4-24
          //reason :增加理算退回定损的环节%>
        <input type="hidden" name="prpLverifyLossCompensateFlag_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='compensateFlag'/>">
        <input type="hidden" name="prpLverifyLossCompensateOpinion_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='compensateOpinion'/>">          
        <input type="hidden" name="prpLverifyLossCompensateBackDate_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='compensateBackDate'/>">          
        <input type="hidden" name="prpLverifyLossCompensateApproverCode_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='compensateApproverCode'/>">          
        <input type="hidden" name="prpLverifyLossDtoStatus_<%=idxMain%>" value="<bean:write name='<%=prpLverifyLossDto%>' property='status'/>">
        <%//reason :此标志为1，说明增加了新的一条记录，所以不能直接提交到理算了，照常走%>
        <input type="hidden" name="NextComeBackCompensate_<%=idxMain%>" >          
         <%//add by lixiang end at 2006-4-24%>
      </td>   
    </tr>   
     
    <tr>
      <td class="title" style="width:15%">保单号:</td>   
      <td class="input" style="width:35%">    
        <input type=text name="prplCheckPolicyNoShow_<%=idxMain%>" class="readonly" readonly="true" style="width:140px" value="<bean:write name='<%=prpLregistDto%>' property='policyNo'/>"><input type="button" name="btPolicyRelate" value="保单信息" class='bigbutton' onclick="relatePolicyNo('<bean:write name='<%=prpLregistDto%>' property='policyNo'/>','<bean:write name='<%=prpLregistDto%>' property='riskCode'/>','<bean:write name='<%=prpLregistDto%>' property='damageStartDate' filter='true' />');">    
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >立案号:</td>
      <td class="input" style="width:35%">   
        <input type=text name="prplCheckClaimNoShow_<%=idxMain%>" class="readonly" readonly="true" style="width:140px" value="<bean:write name='<%=prpLcheckDtoTemp%>' property='claimNo'/>">            
        <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prplCheckPolicyNoShow_<%=idxMain%>.value);return false;">
      </td> 

     
    </tr> 
    
  <%//add by zhaolu start at 2006-6-9
    //reason:强三显示
    if(request.getAttribute("prpLregistRPolicyNo_"+idxMain)!= null){
  %>
   <tr>
      <td class="title" style="width:15%" style="valign:bottom" >强制保单号:</td>
      <td class="input" style="width:35%">   
         <input type=text name="prplCheckPolicyBzNoShow_<%=idxMain%>" class="readonly" readonly="true" style="width:140px" value="<bean:write name='<%=prpLregistRPolicyNo %>' property='policyNo'/>"><input type="button" name="btPolicyRelate" value="强制保单信息" class='bigbutton' onclick="relateBeforePolicyNo('<bean:write name='<%=prpLregistRPolicyNo %>' property='policyNo'/>','<bean:write name='<%=prpLregistRPolicyNo %>' property='riskCode'/>','<bean:write name='<%=prpLregistDto%>' property='damageStartDate' filter='true' />');">       
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
      <td class="title" style="width:15%">报案号:</td>  
      <td class="input" style="width:35%" >  
        <input type=text name="prplCheckRegistNoShow_<%=idxMain%>" class="readonly" readonly="true" style="width:140px" value="<bean:write name='<%=prpLregistDto%>' property='registNo'/>"><input type="button" name="btRegistRelate" value="报案信息" class='bigbutton' onclick="relateRegist('<%=idxMain%>');return false;">    
      </td> 
      <td class="title" style="width:15%" style="valign:bottom" >已出险次数:</td> 
      <td class="input" style="width:35%">
        <%-- 出险信息画面 --%> 
       <%@include file="/combineAgri/regist/AgriExistRegist.jsp"%>
      </td>
    </tr>     
    
<logic:notEqual name="<%=prpLverifyLossDto%>" property="lossItemCode" value="0">
    <tr>
      <td class="title" style="width:15%">出险时间:</td>   
      <td class="common" style="width:35%">     
        <input type=text name="prpLregistDamageStartDate1_<%=idxMain%>" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='<%=prpLregistDto%>' property='damageStartDate' filter='true' />">日
        <input type=text name="prpLregistDamageStartHour1_<%=idxMain%>" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='<%=prpLregistDto%>' property='damageStartHour' filter='true' />">时
        <input type=text name="prpLregistDamageStartMinute1_<%=idxMain%>" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='<%=prpLregistDto%>' property='damageStartMinute' filter='true' />">分
      </td>   
      <td class="title" style="width:15%" style="valign:bottom" >出险地点:</td>
      <td class="common" style="width:35%">   
        <input type=text name="prpLregistDamageAddress_<%=idxMain%>" class="readonly" readonly style="width:350px" value="<bean:write name='<%=prpLregistDto%>' property='damageAddress' filter='true' />">
      </td> 
    </tr>   
      
    <tr>
      <td class="title" style="width:15%">查勘时间:</td>   
      <td class="common" style="width:35%">    
              <bean:write name='<%=prpLcheckDtoTemp%>' property='checkDate'/> 
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >查勘地点:</td>
      <td class="common" style="width:35%">   
             <bean:write name='<%=prpLcheckDtoTemp%>' property='checkSite'/> 
      </td>  
    </tr>  
    <tr>
      <td class="title" style="width:15%">是否第一现场查勘:</td>   
      <td class="common" style="width:35%">    
        <logic:equal name='<%=prpLcheckDtoTemp%>' property="firstSiteFlag" value="0">否</logic:equal>
        <logic:equal name='<%=prpLcheckDtoTemp%>' property="firstSiteFlag" value="1">是</logic:equal> 
      </td>   
      <td class="title" style="width:15%" style="valign:bottom" ></td>
      <td class="common" style="width:35%">    
        <%--modify by liujianbo modify 20050316 start--%>
        <%--resson:按钮太小--%> 
          <input type="button" class='bigbutton' value="查看查勘信息"  onclick="relateCheck('<%=idxMain%>');return false;">     
        <%--modify by liujianbo modify 20050316 end--%>
        <!--<input type="button" class='button' value="查看相关损失">   -->
      </td>  
    </tr> 
    <tr>
      <td class="title" style="width:15%">查勘人1:</td>   
      <td class="common" style="width:35%">    
             <bean:write name='<%=prpLcheckDtoTemp%>' property='checker1'/> 
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >查勘人2:</td>
      <td class="common" style="width:35%"> 
             <bean:write name='<%=prpLcheckDtoTemp%>' property='checker2'/>  
      </td> 
    </tr>  
    <tr>
      <td class="title" style="width:15%">定损时间:</td>   
      <td class="common" style="width:35%">    
          <input name="prpLverifyLossDefLossDate_<%=idxMain%>"  description ="定损日期" class="input" style="width:140px"  value="<bean:write name='<%=prpLverifyLossDto%>' property='defLossDate' />"  onKeyPress="pressFullDate(this)" onblur="checkFullDate(this)">         
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >定损人员:</td>
      <td class="common" style="width:35%">   
           
        <input name="prpLverifyLossHandlerCode_<%=idxMain%>"  class="codecode" style="width:40%"  value="<bean:write name='<%=prpLverifyLossDto%>' property='handlerCode'/>">         
        <input name="prpLverifyLossHandlerName_<%=idxMain%>"  class='codename' maxlength=60  style="width:45%" value="<bean:write name='<%=prpLverifyLossDto%>' property='handlerName'/>"> 
      </td>  
    </tr> 
    <tr>
      <td class="title" style="width:15%">赔付数量:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossLossesNumber_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='lossesNumber'/>" >        
           <html:select name="<%=prpLverifyLossDto%>" property="lossesUnitCode" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection %>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
      <td class="title" style="width:15%">出险户次:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDamageInsured_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='damageInsured'/>">        
          <img src="/claim/images/bgMarkMustInput.jpg">
      </td> 
    </tr>
    <logic:equal name="<%=prpLregistDto%>" property="classCode" value="31">
            <tr>
      <td class="title" style="width:15%">受灾面积:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDisasterArea_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='disasterArea'/>">        
          <html:select name="<%=prpLverifyLossDto%>" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection %>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>   
      <td class="title" style="width:15%">成灾面积:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossAffectedArea_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='affectedArea'/>">        
           <html:select name="<%=prpLverifyLossDto%>" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection %>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
    </tr> 
     <tr>
      <td class="title" style="width:15%">绝产面积:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossNoProductionArea_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='noProductionArea'/>">        
            <html:select name="<%=prpLverifyLossDto%>" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection %>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" ></td>
      <td class="common" style="width:35%"></td>  
    </tr>  
        </tr> 
   </logic:equal>
   <logic:equal name="<%=prpLregistDto%>" property="classCode" value="32">
    <tr>
      <td class="title" style="width:15%">扑杀数量:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossKillQuantity_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='killQuantity'/>">        
          <html:select name="<%=prpLverifyLossDto%>" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection %>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
      </td>  
      <td class="title" style="width:15%">死亡数量:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDeathQuantity_<%=idxMain%>" class="input" style="width:140px" value="<bean:write name='<%=prpLverifyLossDto%>' property='deathQuantity'/>">        
           <html:select name="<%=prpLverifyLossDto%>" property="deathUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection %>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
      </td> 
    </tr> 
  </logic:equal>  
    
</logic:notEqual>     
   
     
       <input type="hidden" name="prpLverifyLossFirstDefLoss_<%=idxMain%>"  value="<bean:write name='<%=prpLverifyLossDto%>' property='firstDefLoss'  format='##0.00'/>">         
       <input type="hidden" name="prpLverifyLossWarpDefLoss_<%=idxMain%>"  value="<bean:write name='<%=prpLverifyLossDto%>' property='warpDefLoss' format='##0.00'/>"> 
   
  </table>   
    

 <input type="hidden" name="PolicyNo_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDtoTemp%>' property='policyNo'/>"> 
  <input type="hidden" name="RegistNo_<%=idxMain%>" value="<bean:write name='<%=prpLcheckDtoTemp%>' property='registNo'/>"> 
  <input type="hidden" name ="statQuantity_<%=idxMain%>" value="<%=request.getAttribute("statQuantity_"+idxMain)%>"/>
  
   <input type="hidden" name="riskcode_<%=idxMain%>" value="<bean:write name='<%=prpLregistDto%>' property='riskCode'/>">
  <input type="hidden" name="policyno_<%=idxMain%>" value="<bean:write name='<%=prpLregistDto%>' property='policyNo'/>">
  <!-- 耳标号所有保单号 -->
  <input type="hidden" name="earPolicyNo_<%=idxMain%>" value="<bean:write name='<%=prpLregistDto%>' property='policyNo'/>">

</span> 
<%idxMain++;}%>
 
 
