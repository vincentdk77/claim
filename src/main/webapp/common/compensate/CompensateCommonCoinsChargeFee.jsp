<%--
****************************************************************************
* DESC       ：指定共保费用界面
* AUTHOR     ：国元项目组
* CREATEDATE ：2018-01-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<table id="CoinsChargeLoss_Data"  border="0"
	align="center" cellpadding="4" cellspacing="1" bgcolor="" class="title"
	width="100%">
	<tr id="tab" name="tab" style="width: 100%">
		<td colspan="6">
			<table id=""  border="0" align="top" cellpadding="4"
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
						费用类型
					</td>
					<td class="centertitle" style="width: 10%">
						费用金额
					</td>
				</tr>
				<tbody id="chargeInfo">
				</tbody>
			</table>
		</td>
	</tr>
	<tr style="width: 100%">
		<td align="right">
			<input type="button" class="button" onclick="feeCoinsCalculate()" value="共保费用分摊计算"/>
			<input type="hidden" name="feeCoinsCalculateFlag" value="0"> 
		</td>
	</tr>
</table>
