      <tr>  
        <td class="title"><bean:message key="db.prpLclaim.claimDate" />:</td>
        <td class="input" colspan="3">
          <input type=hidden name="prpLclaimReportDate" description="��������" >
          <input type=hidden name="prpLclaimToday" description="��ǰ����" >
          <input type=hidden name="prpLclaimClaimTime" description="��������(��ȷ)" value="<bean:write name='prpLclaimDto' property='claimTime' filter='true' />">
          <input Class="readonly" readonly="readonly"  style="width:16%" onblur="checkFullDate(this)" name="prpLclaimClaimDate" description="��������" value="<bean:write name='prpLclaimDto' property='claimDate' filter='true' />">
                <%--<img src="/claim/images/bgMarkMustInput.jpg">--%>
        </td> 
      </tr>
      <tr>        
        <%
		if (editType.equals("SHOW"))
		{
		%>		
		<td class="title">������:<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' /></td>
        <td class="input">
             <input type=text name="prpLclaimSumClaim" title="������" Class="readonly" readonly  value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format='#0.00'/>">
             <%//<input class="readonly" readonly name="EstiCurrency" style="width:30;">%>
        </td>
        <td class="title">�⸶���:<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' /></td>
        <td class="input">
           <input type=text name="prpLclaimSumPaid" title="�⸶���" Class="readonly" readonly value="<bean:write name='prpLclaimDto' property='sumPaid' filter='true' format='#0.00'/>">
        </td>      
<%
		}else{
%>      <td class="title">������:<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' /></td>
        <td class="input" colspan="3">
             <input type=text name="prpLclaimSumClaim" title="������" Class="readonly" readonly  value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format='#0.00'/>">
             <%//<input class="readonly" readonly name="EstiCurrency" style="width:30;">%>
        </td>
		<%-- <td class="title" style="display:none">�⸶���:<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' /></td> --%>

           <input type="hidden" name="prpLclaimSumPaid" title="�⸶���" Class="readonly" readonly value="<bean:write name='prpLclaimDto' property='sumPaid' filter='true' format='#0.00'/>">
<%
		}
%>  
      </tr> 
      
      <tr>
       <td class="title"><bean:message key="db.prpLclaim.comCode" />:</td>
        <td class="input">
          <input type=hidden name="prpLclaimComCode" value = "<bean:write name='prpLclaimDto' property='comCode' filter='true' />">
          <%--��Ҫת���������˵�����--%>
          <input type=hidden name="prpLclaimComCode" title="ҵ���������" class="readonly" readonly="true" value = "<bean:write name='prpLclaimDto' property='comCode' filter='true' />">
          <input type=text   name="prpLclaimComName" title="ҵ���������" class="readonly" readonly="true" value = "<bean:write name='prpLclaimDto' property='comName' filter='true' />">
        </td>
                
        <td class="title"><bean:message key="db.prpLclaim.handler1Code" />:</td>
        <td class="input">
          <input type=hidden name="prpLclaimHandler1Code" value="<bean:write name='prpLclaimDto' property='handler1Code' filter='true' />">
          <input type=text   name="prpLclaimHandler1Name" title="����ҵ��Ա" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handler1Name' filter='true' />">
        </td>        
      </tr>
      
      <tr>
      	<td class='title'><bean:message key="db.prpLclaim.agentCode" />:</td>
      	<td class='input'>
      		<input class="readonly" readonly name="prpLclaimAgentCode"   title="������" value="<bean:write name='prpLclaimDto' property='agentCode' filter='true' />">
          <input class="readonly" readonly name="prpLclaimAgentName"   title="������" value="<bean:write name='prpLclaimDto' property='agentName' filter='true' />">
      	</td>
        <td class='title'><bean:message key="db.prpLclaim.handlerCode" />:</td>
        <td class='input' >
          <input name="prpLclaimHandlerCode" class="readonly"  readonly style="width:60%" value="<bean:write name='prpLclaimDto' property='handlerCode' filter='true' />">
    
          <input name="prpLclaimHandlerName" class="readonly" readonly style="width:35%"  title="������" value="<bean:write name='prpLclaimDto' property='handlerName' filter='true' />">
        </td>
      </tr>
      
       <tr>
        <td class="title"><bean:message key="db.prpLregist.operatorCode" />:</td>
        <td class="input">
          <input type=text name="prpLregistOperatorCode" title="����Ա" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLclaimDto' property='operatorCode' filter='true' />">
          <input type=text name="prpLregistOperatorName" title="����Ա����" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLclaimDto' property='operatorName' filter='true' />">
        </td>
        <td class="title">����Ǽǲ���:</td> 
        <td class="input">
          <input type=text name="prpLregistMakeCom" title="����Ǽǲ���" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLclaimDto' property='makeCom' filter='true' />">
          <input type=text name="prpLregistMakeComName" title="����Ǽǲ���" class="readonly" style="width:200px" readonly="true" value="<bean:write name='prpLclaimDto' property='makeComName' filter='true' />">
        </td>
    </tr>
      
    </table>