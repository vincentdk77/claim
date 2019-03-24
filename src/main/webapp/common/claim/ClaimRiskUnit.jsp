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
<%
	double sumloss=0;
	if(editType.equals("modifyDetail")&&null!=isShow){
	   sumloss=(Double)request.getAttribute("sumloss");
}
%>

<logic:empty name = "display">
<input type="hidden" name="prpLdangerRiskSumPaid" value=""/>
<input type="hidden" name="prpLdangerRiskSumClaim" value=""/>
</logic:empty>
<logic:notEmpty name="display">
<input type="hidden"  name="editType" value="<%=editType%>"/>
	<%
		//农险立案和理算时不显示事故者信息
		PrpLclaimDto  prpLclaimDto2 = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
		PrpLcompensateDto  prpLcompensateDto2 = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto"); 
		String strDisplay="";
		if(prpLclaimDto2 != null && (prpLclaimDto2.getClassCode().equals("31") || prpLclaimDto2.getClassCode().equals("32"))){
			strDisplay = "none";
		}
		if(prpLcompensateDto2 != null && (prpLcompensateDto2.getClassCode().equals("31") || prpLcompensateDto2.getClassCode().equals("32"))){
			strDisplay = "none";
		}
		if(editType.equals("modifyDetail")){
			strDisplay="";
		}
	%>
   <table class="common" width="100%" cellpadding="5" cellspacing="1">
    <tr class=mline  style="display:<%=strDisplay %>">
      <td class="subformtitle"  style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,CompensateText)"> 危险单位信息
             <input type="hidden" name="DangerUnitCheckSaveFlag" value="1"> 
        <br>
        <table class="common" align="left" id="CompensateText" style="display:none" cellspacing="1"  >
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
              <input class="input" type=hidden name="prpLdangerClaimNo"   value="<bean:write name='prpLdangerUnitDto' property='claimNo'/>" />
              <logic:notPresent name="prpLcompensateDto" property="insuredName">
              <input class="input" type=hidden name="prpLdangerRiskCode" value="<bean:write name='prpLclaimDto' property='riskCode'/>"/> 
              <input class="input" type=hidden name="prpLdangerPolicyNo" value="<bean:write name='prpLclaimDto' property='policyNo'/>"/>
              </logic:notPresent>
              <logic:present name="prpLcompensateDto" property="insuredName">
              <input class="input" type=hidden name="prpLclaimRiskCode"   value="<bean:write name='prpLcompensateDto' property='riskCode'/>" />
              <input class="input" type=hidden name="prpLdangerRiskCode" value="<bean:write name='prpLcompensateDto' property='riskCode'/>"/>
              <input class="input" type=hidden name="prpLdangerPolicyNo" value="<bean:write name='prpLcompensateDto' property='policyNo'/>"/>
              </logic:present>    
              <td width="20%"><input class="input" type=hidden name="prpLdangerUnitDesc" value="<bean:write name='prpLdangerUnitDto' property='dangerDesc'/>"/><bean:write name='prpLdangerUnitDto' property='dangerDesc'/></td>
              <td width="30%"><input class="input" type=hidden name="prpLdangerAddressName" value="<bean:write name='prpLdangerUnitDto' property='addressName'/>"/><bean:write name='prpLdangerUnitDto' property='addressName'/></td>
              <td width="15%"><input type="text" name="prpLdangerCurrency" class="codecode" style="width:30%" title="币别"  readonly="true" 
                                     value="<bean:write name='prpLdangerUnitDto' property='currency'/>">
                              <input type=text name="prpLdangerCurrencyName" class="codecode" style="width:60%" title="币别" readonly="true" 
                                     value="<bean:write name='prpLdangerUnitDto' property='riskLevelDesc'/>">
              </td>
              <logic:notPresent name="prpLcompensateDto" property="insuredName">
              <td width="10%">
              <%if("SHOW".equals(editType)||(editType.equals("modifyDetail")&&null!=isShow)){ %>
              	  	<input class="readonly" readonly="readonly" type="text" name="prpLdangerRiskSumClaim" value="<%=sumloss %>"/>
              <%}else if(editType.equals("modifyDetail")&&null==isShow){ %>
                   	<input class="input" type="text"  name="prpLdangerRiskSumClaim" value="0.00"/>
                 <%}else{ %>
                 	<input class="input" type="text" name="prpLdangerRiskSumClaim" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />"/></td>
                  <%} %>
                  <input  type="hidden" name="prpLdangerRiskSumClaimOld" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' />"/>
              </logic:notPresent>
              <logic:present name="prpLcompensateDto" property="insuredName">
                 <td width="10%"><input class="input" type="text" name="prpLdangerRiskSumPaid" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true'  format='##0.00'/>"/></td>
                 <input type="hidden" name="prpLdangerRiskSumPaidOld" value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true'  format='##0.00'/>"/>
                 <input class="input" type=hidden name="prpLdangerRiskSumClaim"   value="<bean:write name='prpLclaimDto' property='sumClaim'/>" />
              </logic:present>    
              <td width="10%"> <input class="input" type="text" name="prpLdangerProportion" style="width:60%" value="100"/>%</td>     
              <td width="15%"  align=center><input type="checkbox" checked name="isRiskUnit" value=""/></td>
            </tr>  
            <tr>
              <%if(editType.equals("ADD")){%>
                  <td><input class="button" type="button" value="分摊试算" onclick="alert('暂存后才可以进行分摊试算');" ></td>
              <%}else if(editType.equals("modifyDetail")){} else {%>
               <logic:notPresent name="prpLcompensateDto" property="insuredName">
                 <td><input class="button" type="button" value="分摊试算" onclick="startTrailClaim()"></td>
               </logic:notPresent>
               <logic:present name="prpLcompensateDto" property="insuredName">
                 <td><input class="button" type="button" value="分摊试算" onclick="startTrailCompensate()"></td>
                  <logic:present name="nodeStatus">
                     <input type="hidden" name="prpLcompensateNodeStatus" value="<bean:write name='nodeStatus'/>">
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

<script>
  function setFlagDanger(){}
  function loadDangerUnit(){}
</script>