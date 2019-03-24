<%--
****************************************************************************
* DESC       ：指定危险单位界面()，
* AUTHOR     ：qinyongli
* CREATEDATE ：2005-08-16
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto" %>
<logic:empty name = "display">
<input type="hidden" name="prpLdangerRiskSumPaid_<%=indexRiskUnit%>" value=""/>
<input type="hidden" name="prpLdangerRiskSumClaim_<%=indexRiskUnit%>" value=""/>
</logic:empty>
<logic:notEmpty name="display">
<input type="hidden"  name="editType_<%=indexRiskUnit%>" value="<%=editType%>"/>
	<%
		//农险立案和理算时不显示事故者信息
		PrpLclaimDto  prpLclaimDto2 = (PrpLclaimDto)request.getAttribute("prpLclaimDto_"+indexRiskUnit); 
		PrpLcompensateDto  prpLcompensateDto2 = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto_"+indexRiskUnit); 
		String strDisplay="";
		if(prpLclaimDto2 != null && (prpLclaimDto2.getClassCode().equals("31") || prpLclaimDto2.getClassCode().equals("32"))){
			strDisplay = "none";
		}
		if(prpLcompensateDto2 != null && (prpLcompensateDto2.getClassCode().equals("31") || prpLcompensateDto2.getClassCode().equals("32"))){
			strDisplay = "none";
		}
		PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto)request.getAttribute("prpLdangerUnitDto_"+indexRiskUnit);
		request.setAttribute("prpLdangerUnitDto",prpLdangerUnitDto);
	%>
   <table class="common" width="100%" cellpadding="5" cellspacing="1">
    <tr class=mline  style="display:<%=strDisplay %>">
      <td class="subformtitle"  style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg_<%=indexRiskUnit%>" onclick="showPage(this,CompensateText)"> 危险单位信息
             <input type="hidden" name="DangerUnitCheckSaveFlag_<%=indexRiskUnit%>" value="1"> 
        <br>
        <table class="common" align="left" id="CompensateText_<%=indexRiskUnit%>" style="display:none" cellspacing="1"  >
          <tbody>
            <tr>
              <td class="subformtitle" width="20%">危险单位描述</td>
              <td class="subformtitle" width="30%">地址描述</td>
              <td class="subformtitle" width="15%">币别</td>
               <logic:notPresent name="prpLcompensateDto" property="insuredName">
	         <td class="subformtitle" width="10%">估损金额</td>
	       </logic:notPresent>
	       <logic:present name="prpLcompensateDto" property="insuredName">
	         <td class="subformtitle" width="10%">实赔金额</td>
	       </logic:present>
              <td class="subformtitle" width="10%">占比</td>     
              <td class="subformtitle" width="15%">是否危险单位</td>
            </tr>
            <tr>
              <input class="input" type=hidden name="prpLdangerClaimNo_<%=indexRiskUnit%>"   value="<bean:write name='prpLdangerUnitDto' property='claimNo'/>" />
              <logic:notPresent name="prpLcompensateDto" property="insuredName">
              <input class="input" type=hidden name="prpLdangerRiskCode_<%=indexRiskUnit%>" value="<bean:write name='prpLclaimDto' property='riskCode'/>"/> 
              <input class="input" type=hidden name="prpLdangerPolicyNo_<%=indexRiskUnit%>" value="<bean:write name='prpLclaimDto' property='policyNo'/>"/>
              </logic:notPresent>
              <logic:present name="prpLcompensateDto" property="insuredName">
              <input class="input" type=hidden name="prpLclaimRiskCode_<%=indexRiskUnit%>"   value="<bean:write name='prpLcompensateDto' property='riskCode'/>" />
              <input class="input" type=hidden name="prpLdangerRiskCode_<%=indexRiskUnit%>" value="<bean:write name='prpLcompensateDto' property='riskCode'/>"/>
              <input class="input" type=hidden name="prpLdangerPolicyNo_<%=indexRiskUnit%>" value="<bean:write name='prpLcompensateDto' property='policyNo'/>"/>
              </logic:present>    
              <td width="20%"><input class="input" type=hidden name="prpLdangerUnitDesc_<%=indexRiskUnit%>" value="<bean:write name='prpLdangerUnitDto' property='dangerDesc'/>"/><bean:write name='prpLdangerUnitDto' property='dangerDesc'/></td>
              <td width="30%"><input class="input" type=hidden name="prpLdangerAddressName_<%=indexRiskUnit%>" value="<bean:write name='prpLdangerUnitDto' property='addressName'/>"/><bean:write name='prpLdangerUnitDto' property='addressName'/></td>
              <td width="15%"><input type="text" name="prpLdangerCurrency_<%=indexRiskUnit%>" class="codecode" style="width:30%" title="币别"  readonly="true" 
                                     value="<bean:write name='prpLdangerUnitDto' property='currency'/>">
                              <input type=text name="prpLdangerCurrencyName_<%=indexRiskUnit%>" class="codecode" style="width:60%" title="币别" readonly="true" 
                                     value="<bean:write name='prpLdangerUnitDto' property='riskLevelDesc'/>">
              </td>
              <logic:notPresent name="prpLcompensateDto" property="insuredName">
                 <td width="10%"><input class="input" type="text" name="prpLdangerRiskSumClaim_<%=indexRiskUnit%>" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />"/></td>
                  <input  type="hidden" name="prpLdangerRiskSumClaimOld_<%=indexRiskUnit%>" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />"/>
              </logic:notPresent>
              <logic:present name="prpLcompensateDto" property="insuredName">
                 <td width="10%"><input class="input" type="text" name="prpLdangerRiskSumPaid_<%=indexRiskUnit%>" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true'  format='##0.00'/>"/></td>
                 <input type="hidden" name="prpLdangerRiskSumPaidOld_<%=indexRiskUnit%>" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true'  format='##0.00'/>"/>
                 <input class="input" type=hidden name="prpLdangerRiskSumClaim_<%=indexRiskUnit%>"   value="<bean:write name='prpLclaimDto' property='sumClaim'/>" />
              </logic:present>    
              <td width="10%"> <input class="input" type="text" name="prpLdangerProportion_<%=indexRiskUnit%>" style="width:60%" value="100"/>%</td>     
              <td width="15%"  align=center><input type="checkbox" checked name="isRiskUnit_<%=indexRiskUnit%>" value=""/></td>
            </tr>  
            <tr>
              <%if(editType.equals("ADD")){%>
                  <td><input class="button" type="button" value="分摊试算" onclick="alert('暂存后才可以进行分摊试算');" ></td>
              <%}else{%>
               <logic:notPresent name="prpLcompensateDto" property="insuredName">
                 <td><input class="button" type="button" value="分摊试算" onclick="startTrailClaim()"></td>
               </logic:notPresent>
               <logic:present name="prpLcompensateDto" property="insuredName">
                 <td><input class="button" type="button" value="分摊试算" onclick="startTrailCompensate()"></td>
                  <logic:present name="nodeStatus">
                     <input type="hidden" name="prpLcompensateNodeStatus_<%=indexRiskUnit%>" value="<bean:write name='nodeStatus'/>">
                  </logic:present>
               </logic:present>    
              <%}%>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
</logic:notEmpty>
<%indexRiskUnit++; %>

<script>
  function setFlagDanger(index){}
  function loadDangerUnit(){}
</script>