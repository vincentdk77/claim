<%--
****************************************************************************
* DESC       ：事故者详细信息页面
* AUTHOR     ：shentao
* CREATEDATE ：2015-2-4
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<script language='javascript'>
</script>
<logic:equal name="riskCode" value="2801">
<table class="common" align="center" width="100%" cellpadding="5"
	cellspacing="1">
	<tr>
		<td class="subformtitle" colspan="3" style="text-align: left;"><img
			style="cursor: hand;" src="/claim/images/butCollapseBlue.gif"
			name="prpLinjuryPersonImg" onclick="showPage(this,spanInjuryPerson)">
		出险人详细信息<br>

		<span id="spanInjuryPerson" style="display:none ">

		<table class=common id="InjuryPerson0" cellpadding="5" cellspacing="1">
		<thead>
				<tr class=listtitle>
					<td style="width: 4%">序号</td>
					<td style="width: 35%">出险人名称</td>
					<td style="width: 25%">性别</td>
					<td style="width: 30%">身份证号码</td>
					<td>&nbsp;</td>
				</tr>
			</thead>
			<tbody>
			<% int prpLinjuryIndex = 0; %>
			<logic:notEmpty name="prpLinjuryPersonDto">
			<logic:iterate name="prpLinjuryPersonDto" id="prpLinjuryPerson">
			<% prpLinjuryIndex++; %>
			<tr>
				<td class="input" style="width: 4%"><%=prpLinjuryIndex %></td>
				<td class="input" align=left style="width: 35%">
					<bean:write name="prpLinjuryPerson" property="acciName" filter="true"/></td>
				<td class="input" align=left style="width: 25%">
					<bean:write name="prpLinjuryPerson" property="sex" filter="true"/></td>
				<td class="input" align=left style="width: 30%">
					<bean:write name="prpLinjuryPerson" property="identifyNumber" filter="true"/></td>
				<td>&nbsp;</td>
			</tr>
			</logic:iterate>
			</logic:notEmpty>
			<logic:empty name="prpLinjuryPersonDto">
			<tr>
				<td class="input" style="width: 4%"></td>
				<td class="input" align=left style="width: 35%"><input type="text" name="injuryPersonName" title="出险人名称" class="input"/></td>
				<td class="input" align=left style="width: 25%"><select name="injuryPersonGender" title="性别" class="input"/>
				<option value="9">未知</option>
				<option value="1">男</option>
				<option value="2">女</option>
				</select></td>
				<td class="input" align=left style="width: 30%"><input type="text" name="injuryPersonIdNum" title="身份证号码" class="input"/></td>
			</tr>
			</logic:empty>
			</tbody>
		</table>
		</span>
		</td>
	</tr>
</table>
</logic:equal>
