<%--
****************************************************************************
* DESC       ��ũ�������Ǽ�����Ϣ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-12
* MODIFYLIST ��   Name       Date            Reason/Contents
			     wuzheng    20071207        ��Ԫ��ӡ����վݵ�ʱ����Ҫ���ձ����Ϣ�����Գ��ձ�ĸ�Ϊ������ҿ��Ƴ���
                 
****************************************************************************
--%>
  <tr>
      <td class="title">������:</td>
      <td class="input" colspan='3'>
        <input type=text name="prpLclaimLossName" title="������" class="input"  style="width:300px" value="<bean:write name='prpLclaimDto' property='lossName' filter='true' format="#0.00" />">
      </td>
      </tr>
<tr>
	<td class="title">�⸶����:</td>
	<input type="hidden" name ="statQuantity" value="<%=request.getAttribute("statQuantity")%>"/>
	<td class="input" id="tdLossesNumber"><input type=text name="prpLclaimLossesNumber"
		class="input" style="width: 80px"
		value="<bean:write name='prpLclaimDto' property='lossesNumber' filter='true' format="#0.00"/>" onblur="checkStatQuantity(this)">
	<html:select name="prpLclaimDto" property="lossesUnitCode"
		styleClass="three" style="width:50px">
		<html:options collection="lossesUnitCodeCollection"
			property="codeCode" labelProperty="codeCName" />
	</html:select> <img src="/claim/images/bgMarkMustInput.jpg"></td>
	<td class="title">���ջ���:</td>
	<td class="input"><input type=text name="prpLclaimDamageInsured"
		title="���ջ���" class="input" style="width: 100px"
		value="<bean:write name='prpLclaimDto' property='damageInsured' filter='true'  format="#0.00"/>">
	<img src="/claim/images/bgMarkMustInput.jpg"></td>
	<input type="hidden" name="prpLclaimSumInsured" value="<bean:write name="prpLclaimDto" property="sumInsured" />">
</tr>
<logic:equal name="prpLclaimDto" property="classCode" value="31">

        <td class="title">�������:</td>
        <td class="input">
          <input type=text name="prpLclaimDisasterArea" title="�������" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='disasterArea' filter='true'  format="#0.00"/>">
           <html:select name="prpLclaimDto" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <td class="title">�������:</td>
        <td class="input">
          <input type=text name="prpLclaimAffectedArea" title="�������" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='affectedArea' filter='true' format="#0.00"  />">
           <html:select name="prpLclaimDto" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
             <tr>
        <td class="title">�������:</td>
        <td class="input">
          <input type=text name="prpLclaimNoProductionArea" title="�������" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='noProductionArea' filter='true' format="#0.00"/>">
           <html:select name="prpLclaimDto" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <!-- colspan='3' -->
        <td class="title">��������:</td>
        <td class="input">
          <input type=text name="prpLclaimLossQuantity" title="��������" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='lossQuantity' filter='true'/>">
           <html:select name="prpLclaimDto" property="lossQuantity" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
      </tr>
</logic:equal>
  <logic:equal name="prpLclaimDto" property="classCode" value="32">
      <tr>
        <td class="title">��������:</td>
        <td class="input" id="tdDeathQuantity">
          <input type=text name="prpLclaimDeathQuantity" title="��������" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='deathQuantity' filter='true' format="#0.00"/>">
           <html:select name="prpLclaimDto" property="deathUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
          
        </td>
        <td class="title">��ɱ����:</td>
        <td class="input" id="tdKillQuantity">
          <input type=text name="prpLclaimKillQuantity" title="��ɱ����" class="input" style="width:100px" value="<bean:write name='prpLclaimDto' property='killQuantity' filter='true' format="#0.00"/>">
           <html:select name="prpLclaimDto" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="lossesUnitCodeCollection" property="codeCode" labelProperty="codeCName"/>
           </html:select>
         
        </td>
     
      </tr>
</logic:equal>
