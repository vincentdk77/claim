<%--
****************************************************************************
* DESC       ：添加调查费用信息页面
* AUTHOR     ：孟冬冬
* CREATEDATE ： 2006-01-23
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--建立显示的录入条，可以收缩显示的-->
<table class="common" align="center" width="100%" style="display:none">
	<!--表示显示多行的-->
	<tr>
		<td class="subformtitle" colspan="4" style="text-align:left">
			<img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="ChargeImg" onclick="showPage(this,spanCharge)">
			调查费用
			<br>
			<span style="display:none">
				<table class="common" style="display:none" id="AcciCheckCharge_Data" cellspacing="1" cellpadding="0">
					<tbody>
						<tr>
							<td class="input" align="center" style="width:10%">
								<input name="prpLAcciCheckChargeCode" class="codecode" style="width:95%" ondblclick="code_CodeSelect(this, 'AcciCheckChargeType');" onkeyup="code_CodeSelect(this, 'AcciCheckChargeType');">
							</td>
							<td class="input" align="center" style="width:30%">
								<input name="prpLAcciCheckChargeName" class="codename" style="width:95%" ondblclick="code_CodeSelect(this, 'AcciCheckChargeType','-1','always','none','post');" onkeyup="code_CodeSelect(this, 'AcciCheckChargeType','-1','always','none','post');">
							</td>
							<td class="input" align="center" style="width:30%">
								<input type="text" name="prpLAcciCheckChargeCurrency" class="codecode" style="width:30%" ondblclick="code_CodeSelect(this, 'Currency');" onkeyup="code_CodeSelect(this, 'Currency');" />
								<input type="text" name="prpLAcciCheckChargeCurrencyName" class="codecode" style="width:65%" ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');" onkeyup="code_CodeSelect(this, 'Currency','-1','always','none','post');" />
							</td>
							<td class="input" align="center" style="width:26%">
								<input name="prpLAcciCheckChargeAmount" class="input" style="width:95%" onchange="calFund();" />
							</td>
							<td class="input" style='width:4%' align="center">
								<div>
									<input type=button name="buttonChargeDelete" class="smallbutton" onclick="deleteRow(this,'AcciCheckCharge'),calFund()" value="-" style="cursor: hand">
									<input type="hidden" name="prpLchargeFlag">
								</div>
							</td>
						</tr>
					</tbody>
				</table> </span> <span id="spanCharge" style="display:none" cellspacing="1" cellpadding="0"> <%-- 多行输入展现域 --%>
				<table class="common" style="width:100%" id="AcciCheckCharge">
					<thead>
						<tr>
							<td class="centertitle" style="width:10%">费用代码</td>
							<td class="centertitle" style="width:30%">费用名称</td>
							<td class="centertitle" style="width:30%">币别</td>
							<td class="centertitle" style="width:26%">费用金额</td>
							<td class="title" style="width:4%">&nbsp;</td>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td class="title" colspan=7 style="width:96%">
								(按"+"号键增加单证信息，按"-"号键删除信息)
							</td>
							<td class="title" align="right" style="width:4%">
								<div align="center">
									<input type="button" value="+" onclick="insertRow('AcciCheckCharge')" class="smallbutton" name="buttonDriverInsert" style="cursor: hand">
								</div>
							</td>
						</tr>
					</tfoot>
					<tbody>
						<logic:notEmpty name="acciCheckDto" property="prpLAcciCheckChargeDtoList">
							<logic:iterate id="acciCheckCharge" name="acciCheckDto" property="prpLAcciCheckChargeDtoList">
								<tr>
									<td class="input" align="center" style="width:10%">
										<input name="prpLAcciCheckChargeCode" class="codecode" style="width:95%" value="<bean:write name='acciCheckCharge' property='chargeCode'/>" ondblclick="code_CodeSelect(this, 'AcciCheckChargeType');"
											onkeyup="code_CodeSelect(this, 'AcciCheckChargeType');">
									</td>
									<td class="input" align="center" style="width:30%">
										<input name="prpLAcciCheckChargeName" class="codename" style="width:95%" value="<bean:write name='acciCheckCharge' property='chargeName'/>" ondblclick="code_CodeSelect(this, 'AcciCheckChargeType','-1','always','none','post');"
											onkeyup="code_CodeSelect(this, 'AcciCheckChargeType','-1','always','none','post');">
									</td>
									<td class="input" align="center" style="width:30%">
										<input type="text" name="prpLAcciCheckChargeCurrency" class="codecode" style="width:30%" value="<bean:write name='acciCheckCharge' property='currency'/>" ondblclick="code_CodeSelect(this, 'Currency');" onkeyup="code_CodeSelect(this, 'Currency');" />
										<input type="text" name="prpLAcciCheckChargeCurrencyName" class="codecode" style="width:65%" value="<bean:write name='acciCheckCharge' property='currency'/>" ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
											onkeyup="code_CodeSelect(this, 'Currency','-1','always','none','post');" />
									</td>
									<td class="input" align="center" style="width:26%">
										<input name="prpLAcciCheckChargeAmount" class="input" style="width:95%" onchange="calFund();" value="<bean:write name='acciCheckCharge' property='chargeAmount'/>">
									</td>
									<td class="input" style='width:4%' align="center">
										<div>
											<input type=button name="buttonChargeDelete" class="smallbutton" onclick="deleteRow(this,'AcciCheckCharge'),calFund()" value="-" style="cursor: hand">
											<input type="hidden" name="prpLchargeFlag">
										</div>
									</td>
								</tr>
							</logic:iterate>
						</logic:notEmpty>
					</tbody>
				</table> 
			</span>
		</td>
	</tr>
</table>
