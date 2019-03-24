<%--
****************************************************************************
* DESC       ：添加主信息子块界面页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-10-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td width="30%">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
          <tr> 
            <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td class="formtitle">定损登记</td>
            <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table> 
      </td>
      <td><input type="button" name="message" value="理赔沟通" class="bigbutton" onclick="openWinSaveQueryCargo()"></td>
      <td width="70%" align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">”
      为双击选择项。</font>
      </td>
    </tr>
  </table>

  <table border="0" align="center" cellpadding="4" cellspacing="1"  class="title" >
    <tr>
      <td class="title" colspan="4" >定损登记
        <input type="hidden" name="prpLverifyLossClaimNo"              value="<bean:write name='prpLverifyLossDto' property='claimNo'/>">             
        <input type="hidden" name="prpLverifyLossRiskCode"             value="<bean:write name='prpLverifyLossDto' property='riskCode'/>">            
        <input type="hidden" name="prpLverifyLossLicenseColorcode"     value="<bean:write name='prpLverifyLossDto' property='licenseColorcode'/>">    
        <input type="hidden" name="prpLverifyLossCarKindCode"          value="<bean:write name='prpLverifyLossDto' property='carKindCode'/>">         
        <input type="hidden" name="prpLverifyLossSumPreDefLoss"        value="<bean:write name='prpLverifyLossDto' property='sumPreDefLoss'/>">       
        <input type="hidden" name="prpLverifyLossSumDefLoss"           value="<bean:write name='prpLverifyLossDto' property='sumDefLoss'/>">          
        <input type="hidden" name="prpLverifyLossMakeCom"              value="<bean:write name='prpLverifyLossDto' property='makeCom'/>">             
        <input type="hidden" name="prpLverifyLossComCode"              value="<bean:write name='prpLverifyLossDto' property='comCode'/>">             
        <input type="hidden" name="prpLverifyLossHandlerCode"          value="<bean:write name='prpLverifyLossDto' property='handlerCode'/>">         
        <input type="hidden" name="prpLverifyLossHandlerName"          value="<bean:write name='prpLverifyLossDto' property='handlerName'/>">         
        <input type="hidden" name="prpLverifyLossDefLossDate"          value="<bean:write name='prpLverifyLossDto' property='defLossDate'/>">         
        <input type="hidden" name="prpLverifyLossUnderWriteCode"       value="<bean:write name='prpLverifyLossDto' property='underWriteCode'/>">      
        <input type="hidden" name="prpLverifyLossUnderWriteName"       value="<bean:write name='prpLverifyLossDto' property='underWriteName'/>">      
        <input type="hidden" name="prpLverifyLossUnderWriteEndDate"    value="<bean:write name='prpLverifyLossDto' property='underWriteEndDate'/>">   
        <input type="hidden" name="prpLverifyLossUnderWriteFlag"       value="<bean:write name='prpLverifyLossDto' property='underWriteFlag'/>">      
        <input type="hidden" name="prpLverifyLossRemark"               value="<bean:write name='prpLverifyLossDto' property='remark'/>">              
        <input type="hidden" name="prpLverifyLossVerifyRemark"         value="<bean:write name='prpLverifyLossDto' property='verifyRemark'/>">        
        <input type="hidden" name="prpLverifyLossFlag"                 value="<bean:write name='prpLverifyLossDto' property='flag'/>"> 
        
        <input type="hidden" name="prpLverifyLossRegistNo" value="<bean:write name='prpLverifyLossDto' property='registNo'/>">
        <input type="hidden" name="prpLverifyLossPolicyNo" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='policyNo'/>">          
        <input type="hidden" name="prpLverifyLossInsuredName" value="<bean:write name='prpLverifyLossDto' property='insuredName'/>">
        <input type="hidden" name="prpLverifyLossLicenseNo" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='licenseNo'/>">          
        <input type="hidden" name="prpLverifyLossLicenseColor" value="<bean:write name='prpLverifyLossDto' property='licenseColor'/>">
        <input type="hidden" name="prpLverifyLossCarKind" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='carKind'/>">          
        <input type="hidden" name="prpLverifyLossClauseName" value="<bean:write name='prpLverifyLossDto' property='clauseName'/>">
        <input type="hidden" name="prpLverifyLossCurrencyName" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='currencyName'/>">          
        <input type="hidden" name="prpLverifyLossCurrency" value="<bean:write name='prpLverifyLossDto' property='currency'/>">          
        <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
        <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
        <input type="hidden" name="prpLverifyLossLossItemCode" value="-1">    
        <input type="hidden" name="damageStartDate" class="common"                value="<bean:write name='prpLregistDto' property='damageStartDate'/>">
      </td>  
    </tr>
    
    <tr>
      <td class="title" >报案号:</td> 
      <td class="input"  >
        <input type="text" name="RegistNo" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='registNo'/>">
      </td>
      <td class="title"  style="valign:bottom" >保单号:</td>
      <td class="input" >
        <input type="hidden" name="riskcode" value="<bean:write name='prpLverifyLossDto' property='riskCode'/>"> 
        <input type="hidden" name="policyno" value="<bean:write name='prpLverifyLossDto' property='policyNo'/>">    
        <input type=text name="PolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='policyNo'/>"> 
        <input type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.PolicyNo.value);return false;">         
      </td>
    </tr>        
  </table>  

 