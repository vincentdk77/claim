<%--
****************************************************************************
* DESC       ：指定危险单位界面
* AUTHOR     ：国元项目组
* CREATEDATE ：2010-12-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<table class="common" width="100%">
	<tr class=mline style="display: ">
		<td class="subformtitle" style="text-align: left;">
			<img style="cursor: hand;" src="/claim/images/butCollapseBlue.gif"
				name="RegistTextImg" onclick="showPage(this,CoinsPaidLoss_Data);showPage(this,CoinsChargeLoss_Data)">
			共保信息
		</td>
	</tr>
	<tr>
</table>

<table id="CoinsPaidLoss_Data" style="display: " border="0"
	align="center" cellpadding="4" cellspacing="1" bgcolor="" class="title"
	width="100%">
	<tr style="width: 100%">
		<td colspan="6">
			<table id="" style="display: " border="0" align="top" cellpadding="4"
				cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
				<tr bgcolor="#2D8EE1">
					<td class="title" style="width: 10%">
						我方赔款金额：
					</td>
					<td class="input" style="width: 20%">
						<input type=text name="prpLcompensateCoinsSelfSumPaid"
							class="readonly" readonly="true" style="width: 140px"
							value="<bean:write name='prpLcompensateDto' property='sumPaid' filter='true'  format='##0.00'/>">
					</td>
					<td class="title" style="width: 10%">
						共保总赔付金额：
					</td>
					<td class="input" style="width: 20%">
						<input class="readonly" type=text
							name="prpLcompensateCoinsSumPaid" readonly="true"
							style="width: 150px"
							value="<bean:write name='prpLcompensateDto' property='coinsSumPaid' filter='true'  format='##0.00'/>">
					</td>
					<td class="title" style="width: 10%">
						共保垫付金额：
					</td>
					<td class="input" style="width: 20%">
						<input type=text name="prpLcompensateCoinsOtherSumPaid"
							class="readonly" readonly="true" style="width: 140px"
							value="<bean:write name='prpLcompensateDto' property='coinsOtherPaid' filter='true'  format='##0.00'/>">
					</td>

				</tr>
			</table>
		</td>
	</tr>
	<tr style="width: 100%">
		<td colspan="6">
			<table id="" style="display: " border="0" align="top" cellpadding="4"
				cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
				<tr>
					<td class="centertitle" style="width: 4%">
						序号
					</td>
					<td class="centertitle" style="width: 6%">
						共保人代码
					</td>
					<td class="centertitle" style="width: 6%">
						共保人名称
					</td>
					<td class="centertitle" style="width: 16%">
						共保比例
					</td>
					<td class="centertitle" style="width: 10%">
						共保赔付金额
					</td>

				</tr>
			<input type="hidden" name="CoinsSerialNo"  >
			<input type="hidden" name="CoinsCode"  >
			<input type="hidden" name="CoinsName" >
			<input type="hidden" name="CoinsRate" >
			<input type="hidden" name="CoinsSumpaid">
			<input type="hidden" name="CoinsType" >
			<input type="hidden" name="CoinsChiefFlag" >
			<input type="hidden" name="CommonCoinsChargeFeeFlag">
				<logic:notEmpty name="prpLcfeecoinsDtoList">
					<logic:iterate id="prpLcfeecoinsDto" name="prpLcfeecoinsDtoList">
						<tr>
							<td class="title" style="width: 4%">
								<input type="text" name="CoinsSerialNo" class="readonly"
									style="width: 40%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='serialNo' filter='true' />">

								<input type="hidden" name="CoinsType" class="readonly" readonly
									style="width: 40%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='coinsType' filter='true' />">
								<input type="hidden" name="CoinsChiefFlag" class="readonly"
									readonly style="width: 40%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='chiefFlag' filter='true' />">
							</td>
							<td class="title" style="width: 16%">
								<input type="text" name="CoinsCode" class="readonly" readonly
									style="width: 100%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='coinsCode' filter='true' />">
							</td>
							<td class="title" style="width: 16%">
								<input type="text" name="CoinsName" class="readonly" readonly
									style="width: 80%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='coinsName' filter='true' />">
							</td>
							<td class="title" style="width: 10%">
								<input type="text" name="CoinsRate" class="readonly"
									style="width: 100%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='coinsRate' format="#0.0000" filter='true'  />">
							</td>
							<td class="title" style="width: 15%">
								<input type="text" name="CoinsSumpaid" class="readonly"
									style="width: 100%" readonly="true"
									value="<bean:write name='prpLcfeecoinsDto' property='coinsSumpaid' format="#0.00" filter='true'  />">
							</td>
						</tr>
					</logic:iterate>
				</logic:notEmpty>
			</table>
		</td>
	</tr>
</table>
<span id='CommonCoinsChargeFee' style="display:none;">
	<%@include file="/common/compensate/CompensateCommonCoinsChargeFee.jsp"%>
</span>
