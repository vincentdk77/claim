<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>  

  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class="centertitle" colspan="4" >核损登记
        <input type="hidden" name="prpLverifyLossClaimNo"              value="<bean:write name='prpLverifyLossDto' property='claimNo'/>">             
        <input type="hidden" name="prpLverifyLossRiskCode"             value="<bean:write name='prpLverifyLossDto' property='riskCode'/>">            
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
        
        <input type="hidden" name="prpLverifyLossRemark"         value="<bean:write name='prpLverifyLossDto' property='remark'/>">        
        <input type="hidden" name="prpLverifyLossFlag"                 value="<bean:write name='prpLverifyLossDto' property='flag'/>"> 
        <input type="hidden" name="prpLverifyLossLossItemCode"         value="<bean:write name='prpLverifyLossDto' property='lossItemCode'/>">   
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
                  <%//add by lixiang start at 2006-4-24
          //reason :增加理算退回定损的环节%>
        <input type="hidden" name="prpLverifyLossCompensateFlag" value="<bean:write name='prpLverifyLossDto' property='compensateFlag'/>">
        <input type="hidden" name="prpLverifyLossCompensateOpinion" value="<bean:write name='prpLverifyLossDto' property='compensateOpinion'/>">          
        <input type="hidden" name="prpLverifyLossCompensateBackDate" value="<bean:write name='prpLverifyLossDto' property='compensateBackDate'/>">          
        <input type="hidden" name="prpLverifyLossCompensateApproverCode" value="<bean:write name='prpLverifyLossDto' property='compensateApproverCode'/>">          
      
      </td>  
    </tr>      
    <tr>
      <td class="title" style="width:15%">保单号:</td>    
      <td class="input" style="width:35%">    
        <input type=text name="prplCheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDtoTemp' property='policyNo'/>">     
        <input type="button" name="btPolicyRelate" value="保单信息" class='bigbutton' onclick="relatePolicy();return false;">    
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >立案号:</td>
      <td class="input" style="width:35%">   
        <input type=text name="prplCheckClaimNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDtoTemp' property='claimNo'/>">            
        <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prplCheckPolicyNo.value);return false;">
      </td> 
    </tr>          
    <tr>
      <td class="title" style="width:15%">报案号:</td>  
      <td class="input" style="width:35%" >  
        <input type=text name="prplCheckRegistNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLcheckDtoTemp' property='registNo'/>">     
        <input type="button" name="btRegistRelate" value="报案信息" class='bigbutton' onclick="relateRegist();return false;">    
      </td> 
      <td class="title" style="width:15%" style="valign:bottom" >已出险次数:</td> 
      <td class="input" style="width:35%">
        <%-- 出险信息画面 --%> 
        <%@include file="/DAA/regist/DAAExistRegist.jsp"%> 
      </td>
    </tr>     
        
    <tr>
      <td class="title" style="width:15%">出险时间:</td>   
      <td class="common" style="width:35%">     
        <input type=text name="prpLregistDamageStartDate1" class="readonly" readonly maxlength="10" style="width:80px" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />">日
        <input type=text name="prpLregistDamageStartHour1" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true' />">时
        <input type=text name="prpLregistDamageStartMinute1" class="readonly" readonly maxlength="2" style="width:20px" value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true' />">分
      </td>   
      <td class="title" style="width:15%" style="valign:bottom" >出险地点:</td>
      <td class="common" style="width:35%">   
        <input type=text name="prpLregistDamageAddress" class="readonly" readonly style="width:350px" value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">
      </td> 
    </tr>  
    
    <tr>
      <td class="title" style="width:15%">查勘时间:</td>   
      <td class="common" style="width:35%">    
              <bean:write name='prpLcheckDtoTemp' property='checkDate'/> 
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >查勘地点:</td>
      <td class="common" style="width:35%">   
             <bean:write name='prpLcheckDtoTemp' property='checkSite'/> 
      </td> 
    </tr> 
    <tr>
      <td class="title" style="width:15%">是否第一现场查勘:</td>   
      <td class="common" style="width:35%">    
        <logic:equal name="prpLcheckDtoTemp" property="firstSiteFlag" value="0">否</logic:equal>
        <logic:equal name="prpLcheckDtoTemp" property="firstSiteFlag" value="1">是</logic:equal>
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" ></td>
      <td class="common" style="width:35%">       
        <%--modify by liujianbo modify 20050316 start--%>
        <%--resson:按钮太小--%> 
             <input type="button" class='bigbutton' value="查看查勘信息" onclick="relateCheck();return false;">     
        <%--modify by liujianbo modify 20050316 end--%> 
             <!--<input type="button" class='button' value="查看相关损失">  -->
      </td> 
    </tr> 
    <tr>
      <td class="title" style="width:15%">查勘人1:</td>   
      <td class="common" style="width:35%">    
             <bean:write name='prpLcheckDtoTemp' property='checker1'/> 
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >查勘人2:</td>
      <td class="common" style="width:35%"> 
             <bean:write name='prpLcheckDtoTemp' property='checker2'/>  
      </td> 
    </tr>  
    <tr>
      <td class="title" style="width:15%">定损时间:</td>   
      <td class="common" style="width:35%">    
       <input name="prpLverifyLossDefLossDate" class="readonly" readonly style="width:140px"  value="<bean:write name='prpLverifyLossDto' property='defLossDate'/>">         
      </td>  
      <td class="title" style="width:15%" style="valign:bottom" >定损人员:</td>
      <td class="common" style="width:35%">   
           
        <input name="prpLverifyLossHandlerCode" class="readonly" readonly style="width:40%"  value="<bean:write name='prpLverifyLossDto' property='handlerCode'/>">         
        <input name="prpLverifyLossHandlerName" class="readonly" readonly style="width:45%" value="<bean:write name='prpLverifyLossDto' property='handlerName'/>"> 
      </td>  
    </tr> 
    <tr>
      <td class="title" style="width:15%">初次定损金额:</td>   
      <td class="common" style="width:35%">    
       <input name="prpLverifyLossFirstDefLoss" class="readonly" readonly style="width:140px"  value="<bean:write name='prpLverifyLossDto' property='firstDefLoss'  format='##0.00'/>">         
      </td>  
      <td class="title" style="width:15%">偏差定损金额:</td>
      <td class="common" style="width:35%">   
        <input name="prpLverifyLossWarpDefLoss"  class='input' style="width:140px" value="<bean:write name='prpLverifyLossDto' property='warpDefLoss' format='##0.00'/>"> 
      </td>  
    </tr> 
                    <tr>
      <td class="title" style="width:15%">赔付数量:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossLossesNumber" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='lossesNumber'/>">        
           <html:select name="prpLverifyLossDto" property="lossesUnitCode" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
      <td class="title" style="width:15%">出险户次:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDamageInsured" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='damageInsured'/>">        
          <img src="/claim/images/bgMarkMustInput.jpg">
      </td> 
    </tr>
    <logic:equal name="prpLregistDto" property="classCode" value="31">

            <tr>
      <td class="title" style="width:15%">受灾面积:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDisasterArea" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='disasterArea'/>">        
          <html:select name="prpLverifyLossDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>   
      <td class="title" style="width:15%">成灾面积:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossAffectedArea" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='affectedArea'/>">        
           <html:select name="prpLverifyLossDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
      </td>  
    </tr> 
     <tr>
      <td class="title" style="width:15%">绝产面积:</td>   
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
        <logic:equal name="prpLregistDto" property="classCode" value="32">
            <tr>
      <td class="title" style="width:15%">扑杀数量:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossKillQuantity" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='killQuantity'/>">        
          <html:select name="prpLverifyLossDto" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
      </td>  
      <td class="title" style="width:15%">死亡数量:</td>   
      <td class="common" style="width:35%">    
          <input type=text name="prpLverifyLossDeathQuantity" class="input" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='deathQuantity'/>">        
           <html:select name="prpLverifyLossDto" property="deathUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
      </td> 
    </tr>
  </logic:equal>  
    
  </table>   
    

  <input type="hidden" name="riskcode" value="<bean:write name='prpLcheckDtoTemp' property='riskCode'/>"> 
  <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDtoTemp' property='policyNo'/>"> 
  <input type="hidden" name="PolicyNo" value="<bean:write name='prpLcheckDtoTemp' property='policyNo'/>"> 
  <input type="hidden" name="RegistNo" value="<bean:write name='prpLcheckDtoTemp' property='registNo'/>"> 
 
