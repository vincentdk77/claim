<%--
****************************************************************************
* DESC       :�������Ϣ�ӿ����ҳ��
* AUTHOR     : liubvo
* CREATEDATE : 2004-06-03 
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%iterator = PrplcombineDtos.iterator();
while(iterator.hasNext()){iterator.next();%>
<span  id="spanVerifyLoss_<%=idxVerifyLoss%>" style = "display:none" cellspacing="1" cellspacing="0"  width="100%">
<%
String prpLcheckDtoVerifyLoss = "";
String prpLverifyLossDto = "";
String prpLregistDto = "";
String lossesUnitCodeCollection = "";
String prpLcheckDtoTemp = "";
prpLcheckDtoVerifyLoss = "prpLcheckDto_"+String.valueOf(idxVerifyLoss);
prpLverifyLossDto = "prpLverifyLossDto_"+String.valueOf(idxVerifyLoss);
prpLregistDto = "prpLregistDto_"+String.valueOf(idxVerifyLoss);
lossesUnitCodeCollection = "lossesUnitCodeCollection_"+String.valueOf(idxVerifyLoss);
prpLcheckDtoTemp = "prpLcheckDtoTemp_"+String.valueOf(idxVerifyLoss);
%>

<table border="0" align="center" cellpadding="4" cellspacing="1"
	bgcolor="#2D8EE1" class="title" width="100%">
	<tr class=listtitle>
		<td colspan="4">����Ǽ�ҳ��</td>
	</tr>
	<tr>
		<td class="title">����ʱ�䣺</td>
		<td class="input">
		    <input type="text" name="prpLcheckCheckDate_<%=idxVerifyLoss%>" class="input" onblur="checkFullDate(this)"
			         value="<bean:write name='<%=prpLcheckDtoVerifyLoss%>' property='checkDate'/>">
		</td>
		<td class="title"></td>
		<td class="input"></td>
  </tr>
  <tr>
      <td class="title" >�⸶����:</td>
      <td class="common" id="tdLossesNumber">
          <input type=text name="prpLverifyLossLossesNumber_<%=idxVerifyLoss%>" class="input" style="width: 140px"
                 value="<bean:write name='<%=prpLverifyLossDto%>' property='lossesNumber'/>" >
          <html:select name="<%=prpLverifyLossDto%>" property="lossesUnitCode" styleClass="three" style="width:50px">
                       <html:options collection="<%=lossesUnitCodeCollection%>" property="codeCode" labelProperty="codeCName" />
          </html:select> 
      </td>
      <td class="title" >���ջ���:</td>
      <td class="common">
          <input type=text name="prpLverifyLossDamageInsured_<%=idxVerifyLoss%>" class="input" style="width: 140px"
                 value="<bean:write name='<%=prpLverifyLossDto%>' property='damageInsured'/>">
      </td >
  </tr>
  <logic:equal name="<%=prpLregistDto%>" property="classCode" value="31">

        <td class="title">�������:</td>
        <td class="input">
          <input type=text name="prpLverifyLossDisasterArea_<%=idxVerifyLoss%>" title="�������" class="input" style="width:100px" value="<bean:write name='<%=prpLverifyLossDto%>' property='disasterArea' filter='true'  format="#0.00"/>">
           <html:select name="<%=prpLverifyLossDto%>" property="disasterUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection%>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
         <td class="title">�������:</td>
        <td class="input">
          <input type=text name="prpLverifyLossAffectedArea_<%=idxVerifyLoss%>" title="�������" class="input" style="width:100px" value="<bean:write name='<%=prpLverifyLossDto%>' property='affectedArea' filter='true' format="#0.00"  />">
           <html:select name="<%=prpLverifyLossDto%>" property="affectedUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection%>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
      </tr>
             <tr>
        <td class="title">�������:</td>
        <td class="input" colspan='3'>
          <input type=text name="prpLverifyLossNoProductionArea_<%=idxVerifyLoss%>" title="�������" class="input" style="width:100px" value="<bean:write name='<%=prpLverifyLossDto%>' property='noProductionArea' filter='true' format="#0.00"/>">
           <html:select name="<%=prpLverifyLossDto%>" property="noProductionUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection%>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
           <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        
      </tr>
</logic:equal>
  <logic:equal name="<%=prpLregistDto%>" property="classCode" value="32">
      <tr>
        <td class="title">��������:</td>
        <td class="input" id="tdLossDeathQuantity_<%=idxVerifyLoss%>">
          <input type=text name="prpLverifyLossDeathQuantity_<%=idxVerifyLoss%>" title="��������" class="input" style="width:100px" value="<bean:write name='<%=prpLverifyLossDto%>' property='deathQuantity' filter='true' format="#0.00"/>">
           <html:select name="<%=prpLverifyLossDto%>" property="deathUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection%>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
          
        </td>
        <td class="title">��ɱ����:</td>
        <td class="input" id="tdKillQuantity_<%=idxVerifyLoss%>">
          <input type=text name="prpLverifyLossKillQuantity_<%=idxVerifyLoss%>" title="��ɱ����" class="input" style="width:100px" value="<bean:write name='<%=prpLverifyLossDto%>' property='killQuantity' filter='true' format="#0.00"/>">
           <html:select name="<%=prpLverifyLossDto%>" property="killUnit" styleClass="three"  style="width:50px">
              <html:options collection="<%=lossesUnitCodeCollection%>" property="codeCode" labelProperty="codeCName"/>
           </html:select>
         
        </td>
     
      </tr>
</logic:equal>
<input type="hidden" name="PolicyNo_<%=idxVerifyLoss%>"
  value="<bean:write name='<%=prpLcheckDtoTemp%>' property='policyNo'/>">
<input type="hidden" name="RegistNo_<%=idxVerifyLoss%>"
  value="<bean:write name='<%=prpLcheckDtoTemp%>' property='registNo'/>">
<input type="hidden" name ="statQuantity_<%=idxVerifyLoss%>" value="<%=request.getAttribute("statQuantity_"+idxVerifyLoss)%>"/>
</table>
</span>
<%idxVerifyLoss++;
}%>