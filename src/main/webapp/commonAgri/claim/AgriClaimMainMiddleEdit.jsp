<%--
****************************************************************************
* DESC       ：农险立案登记主信息中
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-12
* MODIFYLIST ：   Name       Date            Reason/Contents
			     wuzheng    20071207        国元打印赔款收据的时候需要出险标的信息。所以出险标的改为必须项，且控制长度
                 
****************************************************************************
--%>
  <tr>
      <td class="title">受损标的:</td>
      <td class="input" colspan='3'>
        <input type=text name="prpLclaimLossName" title="受损标的" class="input"  style="width:300px" value="<bean:write name='prpLclaimDto' property='lossName' filter='true' format="#0.00" />">
      </td>
      </tr>
<tr>
	<td class="title">赔付数量:</td>
	<input type="hidden" name ="statQuantity" value="<%=request.getAttribute("statQuantity")%>"/>
	<td class="input" id="tdLossesNumber"><input type=text name="prpLclaimLossesNumber"
		class="input" style="width: 80px"
		value="<bean:write name='prpLclaimDto' property='lossesNumber' filter='true' format="#0.00"/>" onblur="checkStatQuantity(this)">
	<html:select name="prpLclaimDto" property="lossesUnitCode"
		styleClass="three" style="width:50px">
		<html:options collection="lossesUnitCodeCollection"
			property="codeCode" labelProperty="codeCName" />
	</html:select> <img src="/claim/images/bgMarkMustInput.jpg"></td>
	<td class="title">出险户次:</td>
	<td class="input"><input type=text name="prpLclaimDamageInsured"
		title="出险户次" class="input" style="width: 100px"
		value="<bean:write name='prpLclaimDto' property='damageInsured' filter='true'  format="#0.00"/>">
	<img src="/claim/images/bgMarkMustInput.jpg"></td>
	<input type="hidden" name="prpLclaimSumInsured" value="<bean:write name="prpLclaimDto" property="sumInsured" />">
</tr>
<logic:equal name="prpLclaimDto" property="classCode" value="31">

        <td class="title">受灾面积:</td>
        <td class="input">
          <input type=text name="prpLclaimDisasterArea" title="受灾面积" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='disasterArea' filter='true'  format="#0.00"/>">
           <html:select name="prpLclaimDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <td class="title">成灾面积:</td>
        <td class="input">
          <input type=text name="prpLclaimAffectedArea" title="成灾面积" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='affectedArea' filter='true' format="#0.00"  />">
           <html:select name="prpLclaimDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
             <tr>
        <td class="title">绝产面积:</td>
        <td class="input">
          <input type=text name="prpLclaimNoProductionArea" title="绝产面积" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='noProductionArea' filter='true' format="#0.00"/>">
           <html:select name="prpLclaimDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <!-- colspan='3' -->
        <td class="title">估损数量:</td>
        <td class="input">
          <input type=text name="prpLclaimLossQuantity" title="估损数量" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='lossQuantity' filter='true'/>">
           <html:select name="prpLclaimDto" property="lossQuantity" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
      </tr>
</logic:equal>
  <logic:equal name="prpLclaimDto" property="classCode" value="32">
      <tr>
        <td class="title">死亡数量:</td>
        <td class="input" id="tdDeathQuantity">
          <input type=text name="prpLclaimDeathQuantity" title="死亡数量" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='deathQuantity' filter='true' format="#0.00"/>">
           <html:select name="prpLclaimDto" property="deathUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
          
        </td>
        <td class="title">扑杀数量:</td>
        <td class="input" id="tdKillQuantity">
          <input type=text name="prpLclaimKillQuantity" title="扑杀数量" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='killQuantity' filter='true' format="#0.00"/>">
           <html:select name="prpLclaimDto" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
         
        </td>
     
      </tr>
</logic:equal>
