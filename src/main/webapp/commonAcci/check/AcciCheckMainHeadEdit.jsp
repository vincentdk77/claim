<%--
****************************************************************************
* DESC       :添加主信息子块界面页面
* AUTHOR     : liubvo
* CREATEDATE : 2004-06-03 
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
  <%
    PrpLacciCheckDto prpLacciCheckDto = (PrpLacciCheckDto)request.getAttribute("prpLacciCheckDto");
  %>
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
       <td width="30%">  
         <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr> 
              <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
              <td class="formtitle">调查登记</td>
              <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            </tr>
          </table>
       </td>
       <td><input type="button" class="bigbutton" name="prpLmessageSave" value="理赔沟通" onclick="openWinSaveQuery(fm.prpLacciCheckRegistNo.value,fm.prpLacciCheckPolicyNo.value,fm.prpLacciCheckRiskCode.value,'check',fm.prpLcheckClaimNo.value,'registNo',fm.prpLacciCheckRegistNo.value);"></td>
       <td><input type="button" name="eCertify" class="bigbutton" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLacciCheckDto' property='registNo'/>','check');"></td> 
       <td><input type="button" name="buttonCertifyDirect" class="bigbutton" value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLacciCheckDto' property='registNo'/>','check')"></td>
       <td width="70%" align="right"><font color="#666666">　注:“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">” 
      为双击选择项。</font></td>
    </tr>
    </table>

    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
      <tr>
        <td class="title" colspan="2">调查登记
          <input type="hidden" name="referKind">
       
          <input type="hidden" name="prpLcheckRiskCode"  value="<bean:write name='prpLcheckDto' property='riskCode'/>">
          <input type="hidden" name="prpLcheckFlag"  value="<bean:write name='prpLcheckDto' property='flag'/>">
          <input type="hidden" name="prpLcheckReferSerialNo" value="<bean:write name='prpLcheckDto' property='referSerialNo' filter='true' />">    
          <input type="hidden" name="prpLcheckInsureCarFlag" value="<bean:write name='prpLcheckDto' property='insureCarFlag' filter='true' />">  
          <input type="hidden" name="prpLacciCheckTimes"  value="<bean:write name='prpLacciCheckDto' property='times'/>">
          <input type="hidden" name="prpLacciCheckCertiNo"  value="<bean:write name='prpLacciCheckDto' property='certiNo'/>">
          <input type="hidden" name="prpLacciCheckRiskCode"  value="<bean:write name='prpLacciCheckDto' property='riskCode'/>">
          <input type="hidden" name="riskCode"  value="<bean:write name='prpLacciCheckDto' property='riskCode'/>">
          
           <input type="hidden" name="prpLacciCheckCertiType"  value="<bean:write name='prpLacciCheckDto' property='certiType'/>">
           <input type="hidden" name="prpLacciCheckCheckNo"  value="<bean:write name='prpLacciCheckDto' property='checkNo'/>">
          
          <input type="hidden" name="prpLacciCheckTimes"  value="<bean:write name='prpLacciCheckDto' property='times'/>">
          <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
          <input type="hidden" name="type"  value="<%= request.getParameter("type") %>">
          <input type="hidden" name="policyno"  value="<bean:write name='prpLacciCheckDto' property='policyNo'/>">
          <input type="hidden" name="registno"  value="<bean:write name='prpLacciCheckDto' property='registNo'/>">
          <input type="hidden" name="prpLcheckRegistNo"  value="<bean:write name='prpLacciCheckDto' property='registNo'/>">
        </td> 
          <td class="title">险种代码:</td>
          <td class="title"><bean:write name='prpLacciCheckDto' property='riskCode'/></td>
      </tr>
       <tr>
        <td class="title" colspan="4">
         <logic:equal name='prpLacciCheckDto' property='certiType' value="01">
          <input type="text"  class="readonly" readonly="true"  name="" color="red" value="此调查由 报案 环节发起">
         </logic:equal>
          <logic:equal name='prpLacciCheckDto' property='certiType' value="03">
          <input type="text"  class="readonly" readonly="true"  name="" color="red"  value="此调查由 立案 环节发起">
         </logic:equal>
          <logic:equal name='prpLacciCheckDto' property='certiType' value="05">
          <input type="text"   class="readonly" readonly="true" name="" color="red" value="此调查由 审核 环节发起">
         </logic:equal>
          <logic:equal name='prpLacciCheckDto' property='certiType' value="07">
          <input type="text"   class="readonly" readonly="true" name=""  color="red" value="此调查由 计算书 环节发起">
         </logic:equal> 
        </td>
      </tr>
      <tr> 
        <td class="title" style="width:15%" style="valign:bottom" >报案号:</td>
        <td class="input" style="width:35%" style="valign:middle">
          <input type=text name="prpLacciCheckRegistNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLacciCheckDto' property='registNo'/>">          
        </td>
        <td class="title" style="width:15%">立案号:</td>
        <td class="input" style="width:35%" >
          <input type="text" name="prpLcheckClaimNo" class="readonly" readonly="true" value="<bean:write name='prpLcheckDto' property='claimNo'/>">
        </td>
      </tr>
        
      <tr>         
        <td class="title" style="width:15%">保单号:</td>
        <td class="input" style="width:55%" colspan="3">
          <input type="text" name="prpLacciCheckPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLacciCheckDto' property='policyNo'/>">
          <input type="hidden" name="policyNo" class="readonly" readonly="true" value="<bean:write name='prpLacciCheckDto' property='policyNo'/>">
          <input type="button" name="btRelate" class='button' value="关联" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLacciCheckPolicyNo.value);return false;">         
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" >事故时间：</td>
        <td class="input" >
        <input type="text" name="prpLcheckDamageStartDate" onblur="checkFullDate(this)"  maxlength="10" style="width:100%"
            value="<bean:write name='prpLacciCheckDto' property='damageStartDate' filter='true' /> 日
<bean:write name='prpLacciCheckDto' property='damageStartHour' filter='true' /> 时
<bean:write name='prpLacciCheckDto' property='damageStartMinute' filter='true' /> 分">
        </td>

        <td class="title" style="width:15%">事故地点：</td>
        <td class="input" >
          <input type="text" name="prpLacciCheckDamageAddress" class="readonly"  readonly="true"  style="width:140px" value="<bean:write name='prpLacciCheckDto' property='damageAddress'/>">
        </td>      
      </tr>
      
      <tr>         
        <%--<td class="title" style="width:15%">调查类型:</td>
        <td class="input" style="width:35%" >
          <html:select name='prpLcheckDto' property='checkType' >
            <html:option value="L">调查</html:option>
            <html:option value="D">代调查</html:option>
           </html:select>
        </td>--%>
        
        <td class="title" style="width:15%">调查起止日期:</td>
        <td class="input" style="width:35%"  colspan=3>
          <input type="text" name="prpLacciCheckCheckDate" class="input" style="width:140px" value="<bean:write name='prpLacciCheckDto' property='checkDate'/>">
          <input type=text name="prpLacciCheckCheckHour" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLacciCheckDto' property='checkHour'/>">时
          <input type=text name="prpLaccecheckCheckMinute" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLacciCheckDto' property='damageStartMinute2'/>">分
          <img src="/claim/images/bgMarkMustInput.jpg">至
          <input type="text" name="prpLacciCheckCheckEndDate" class="input" style="width:140px" value="<bean:write name='prpLacciCheckDto' property='checkEndDate'/>">
          <input type=text name="prpLacciCheckCheckEndHour" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLacciCheckDto' property='checkEndHour'/>">时
          <input type=text name="prpLacciCheckCheckEndMinute" class="input" maxlength="2" style="width:20px"  value="<bean:write name='prpLacciCheckDto' property='damageStartMinute3'/>">分
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
       
      </tr>
      
      <tr>         
        <td class="title" style="width:15%" style="valign:bottom" >调查方式:</td>
        <td class="input" style="width:35%" style="valign:middle">
           <html:select name="prpLacciCheckDto" property="checkNature" style="width:100px">
             <html:option value="0">直接调查</html:option>
             <html:option value="1">间接调查</html:option>
          </html:select> 
        </td>
        
        <td class="title" style="width:15%">已出事故次数:</td>
        <td class="input" style="width:35%">
        <%-- 出险信息画面 --%>
           <%@include file="/common/regist/ExistRegist.jsp"%>              
        </td>
      </tr>
       <tr>         
        <td class="title" style="width:15%">调查对象:</td>
        <td class="input" style="width:35%" colspan="3">
            <input type="text" name="prpLacciCheckCheckObject" class="input" style="width:440px" value="<bean:write name='prpLacciCheckDto' property='checkObjectDesc'/>">
        </td>
      </tr>
      <tr>         
        <td class="title" style="width:15%">调查地点:</td>
        <td class="input" style="width:35%" colspan="3">
          <input type="text" name="prpLacciCheckCheckSite" class="input" style="width:440px" value="<bean:write name='prpLacciCheckDto' property='checkSite'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      
      <tr>         
        <td class="title" style="width:15%">调查员 1:</td>
        <td class="input" style="width:35%"  colspan=3>
          <input name='prpLacciCheckCode' class='input' maxlength=20 style="width:140px" description="查勘人1" value="<bean:write name='prpLacciCheckDto' property='checkerCode'/>">
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
      <tr>         
        <td class="title" style="width:15%">事故原因：</td>
        <td class="input" style="width:35%" >
        <%--
        <logic:notEqual name='prpLacciCheckDto' property='damageCode' value="999">
          <input name="prpLacciCheckDamageCode" class="codecode" style="width:40px" maxlength=4 description="出险原因" value="<bean:write name='prpLacciCheckDto' property='damageCode'/>"
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
        </logic:notEqual>
        <logic:equal name='prpLacciCheckDto' property='damageCode' value="999">
          <input name="prpLacciCheckDamageCode" class="codecode" style="width:40px" maxlength=4 description="出险原因" 
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
        </logic:equal>
        --%>
          <input name="prpLacciCheckDamageCode" type="hidden" class="codecode" style="width:40px" maxlength=4 description="出险原因" value="<bean:write name='prpLacciCheckDto' property='damageCode'/>"/>
          <input name="prpLacciCheckDamageName" class="input "  style="width:250px" maxlength=20 description="出险原因" value="<bean:write name='prpLacciCheckDto' property='damageName'/>"
             <%--ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','none','post');"--%>
             >
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>         
          <td class="title">事故类型:</td>
        <!--  <td class="input">
         <html:select name ="prpLacciCheckDto" property="damageTypeCode" style="width:100px">
             <html:option value="101">伤残</html:option>
             <html:option value="102">死亡</html:option>
             <html:option value="100">疾病</html:option>
             <html:option value="999">其他</html:option>
          </html:select>
          </td>-->
           <td  class="input">
          <input type=text name="prpLacciCheckDamageTypeCode" class="codecode"  style="width:15%" title="事故原因" value="<bean:write name='prpLacciCheckDto' property='damageTypeCode' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode');">
          <input type=text name="prpLacciCheckDamageTypeName" class="codecode" title="事故原因" style="width:63%" value="<bean:write name='prpLacciCheckDto' property='damageTypeName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'DamageTypeCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageTypeCode','-1','always','none','post');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">   
          <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
       </tr>
		<tr>         
			<td class="title" style="width:15%">调查内容简要描述:</td>
			<td class="input" style="width:35%" colspan="3">
			  <input type="text" name="prpLacciCheckCheckContext" class="readonly" readonly="true" style="width:540px" value="<bean:write name='prpLacciCheckDto' property='checkContext'/>">
			</td>
		</tr>
       <tr> 
        <td class="title" style="width:15%">调查币别费用：</td>
        <td class="input" style="width:35%" colspan="3">
	         <input type="text"  name="prpLacciCheckCurrencyCode" value="<bean:write name='prpLacciCheckDto' property='currency' />" class="input" style="width:5%" title="币别"/>
	         <!-- ondblclick="code_CodeSelect(this, 'Currency');"
	         onkeyup= "code_CodeSelect(this, 'Currency');"
	         -->
	        <input type=text name="prpLacciCheckCurrencyName" class="input" style="width:10%" title="币别" value="<bean:write name='prpLacciCheckDto' property='currencyName' />" />
	        <!-- 
	           ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
	           onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');" 
	        -->
	        <input type="text"  name="prpLacciCheckCheckFee" class='input' maxlength=20 style="width:140px"  value="<bean:write name='prpLacciCheckDto' property='checkFee'  filter='true' format='0.00'/>">
        </td>
       </tr>