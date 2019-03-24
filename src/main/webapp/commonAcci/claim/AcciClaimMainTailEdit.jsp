      <tr>  
        <td class="title"><bean:message key="db.prpLclaim.claimDate" />:</td>
        <td class="input">
          <input type=hidden name="prpLclaimReportDate" description="报案日期" >
          <input type=hidden name="prpLclaimToday" description="当前日期" >
          <input type=hidden name="prpLclaimClaimTime" description="立案日期(精确)" value="<bean:write name='prpLclaimDto' property='claimTime' filter='true' />">
          <input class="common"  style="width:30%" name="prpLclaimClaimDate" description="立案日期" readonly="readonly" onblur="checkFullDate(this)" value="<bean:write name='prpLclaimDto' property='claimDate' filter='true' />">
                <img src="/claim/images/bgMarkMustInput.jpg">
        </td> 
         <td class="title">赔付金额:<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' /></td>
        <td class="input">
           <input type=text name="prpLclaimSumPaid" title="赔付金额" Class="readonly" readonly value="<bean:write name='prpLclaimDto' property='sumPaid' filter='true' format='#0.00'/>">
        </td>      
      </tr>
      <tr>        
        <td class="title">预计赔偿金额:<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' format='0.00'/></td>
        <td class="input">
             <input type=text name="prpLclaimSumClaim"  title="预计赔偿金额" Class="readonly" readonly  style="width:90;" value="<bean:write name='prpLclaimDto' property='sumClaim' filter='true' format='#0.00'/>">
             <%//<input class="readonly" readonly name="EstiCurrency" style="width:30;">%>
        </td>
       <td class="title">案件类型：</td>
       <td class="input">
            <!--原因：添加案件性质 2005-08-01-->
         <input name="claimType" class="codecode" style="width:30%" maxlength=1
              value="<bean:write name='prpLclaimDto' property='claimType' filter='true' />"
              ondblclick="code_CodeSelect(this, 'CaseCode');"
              onchange="code_CodeChange(this, 'CaseCode');"
              onkeyup= "code_CodeSelect(this, 'CaseCode');">
         <input name="claimTypeName" class="codename" style="width:50%"  title="案件类型"
             value="<bean:write name='prpLclaimDto' property='claimTypeName' filter='true' />"
             ondblclick="code_CodeSelect(this, 'CaseCode','-1','name','always','none','post');"
             onchange="code_CodeChange(this, 'CaseCode','-1','name','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'CaseCode','-1','name','always','none','post');">
              <img src="/claim/images/bgMarkMustInput.jpg">
       </td>
      </tr> 
      
      <tr>
       <td class="title"><bean:message key="db.prpLclaim.comCode" />:</td>
        <td class="input">
          <input type=hidden name="prpLclaimComCode" value = "<bean:write name='prpLclaimDto' property='comCode' filter='true' />">
          <%--需要转换机构和人的姓名--%>
          <input type=hidden name="prpLclaimComCode" title="业务归属机构" class="readonly" readonly="true" value = "<bean:write name='prpLclaimDto' property='comCode' filter='true' />">
          <input type=text   name="prpLclaimComName" title="业务归属机构" class="readonly" readonly="true" value = "<bean:write name='prpLclaimDto' property='comName' filter='true' />">
        </td>
                
        <td class="title"><bean:message key="db.prpLclaim.handler1Code" />:</td>
        <td class="input">
          <input type=hidden name="prpLclaimHandler1Code" value="<bean:write name='prpLclaimDto' property='handler1Code' filter='true' />">
          <input type=text   name="prpLclaimHandler1Name" title="归属业务员" class="readonly" readonly="true" value="<bean:write name='prpLclaimDto' property='handler1Name' filter='true' />">
        </td>        
      </tr>
      
      <tr>
      	<td class='title'><bean:message key="db.prpLclaim.agentCode" />:</td>
      	<td class='input'>
      		<input class="readonly" readonly name="prpLclaimAgentCode"   title="代理人" value="<bean:write name='prpLclaimDto' property='agentCode' filter='true' />">
          <input class="readonly" readonly name="prpLclaimAgentName"   title="代理人" value="<bean:write name='prpLclaimDto' property='agentName' filter='true' />">
      	</td>
        <td class='title'><bean:message key="db.prpLclaim.handlerCode" />:</td>
        <td class='input' >
          <input name="prpLclaimHandlerCode"  class="readonly" readonly style="width:60%" value="<bean:write name='prpLclaimDto' property='handlerCode' filter='true' />">
    <!-- 经办人暂不可输入-->
          <input name="prpLclaimHandlerName" class="readonly" readonly style="width:35%"  title="立案人" value="<bean:write name='prpLclaimDto' property='handlerName' filter='true' />">
        </td>
      </tr>
      
       <tr>
        <td class="title"><bean:message key="db.prpLregist.operatorCode" />:</td>
        <td class="input">
          <input type=text name="prpLregistOperatorCode" title="操作员" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLclaimDto' property='operatorCode' filter='true' />">
          <input type=text name="prpLregistOperatorName" title="操作员名称" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLclaimDto' property='operatorName' filter='true' />">
        </td>
        <td class="title">理赔登记部门:</td> 
        <td class="input">
          <input type=text name="prpLregistMakeCom" title="理赔登记部门" class="readonly" style="width:80px" readonly="true" value="<bean:write name='prpLclaimDto' property='makeCom' filter='true' />">
          <input type=text name="prpLregistMakeComName" title="理赔登记部门" class="readonly" style="width:200px" readonly="true" value="<bean:write name='prpLclaimDto' property='makeComName' filter='true' />">
        </td>
    </tr>
      
    </table>