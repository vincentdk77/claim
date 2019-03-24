<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%-- 班表信息 --%>
<table id="tab" name="tab"
	style="margin-bottom: 0px" class="common" 
	cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8">
	<tbody>
		<tr align="center">
			<td class="centertitle" style="width: 10%">
				班次名称<input type="hidden" id="countNo" name="countNo" value="1">
			</td>

			<td class='centertitle' style="width: 10%">
				查勘人员
			</td>
			<td class="centertitle" style="width: 10%">
				<select id="userCode" name="userCode" onchange="setUp(this);">
					<option value="">请选择</option>
					<logic:iterate id="prpDuserDto" name="prpDuserDtoList" indexId="count">
						<option value="${prpDuserDto.userCode}">
							${prpDuserDto.userName}
						</option>
					</logic:iterate>
				</select>
				<input type="hidden" id="handlercode" name="handlercode" value="">
				<input type="hidden" id="handlername" name="handlername" value=""/>
				<input type="hidden" id="id" name="id" value=""/>
			</td>
			<td class='centertitle' style="width: 10%">
				工作角色
			</td>
			<td class='centertitle' style="width: 20%" colspan="2">
				<input type="hidden" name="jobRole" id="jobRole" value="" />
				<input type="checkbox" name="gradecodeBox" id="" value="3"
					onclick="checkboxFilter(this)">
				非车查勘&nbsp;&nbsp;
			</td>
			<td class="centertitle" style="width: 10%">
				所在机构
			</td>
			<td class="centertitle" style="width: 10%">
				<input type="text" id="comCName" name="comCName" value="">
			</td>
			<td class="centertitle" style="width: 5%">
				操作
			</td>
		</tr>
		<tr>
			<td rowspan="5" align="center">
				白班 8：00～18：00<br/>（含起点时间）
			</td>
			<logic:iterate id="prpljobmanagertimeDto" name="prpljobmanagertimeDtoList" indexId="count">
				<td>
					<input type="checkbox" id="checkboxDayAm1" name="checkboxDayAm1"
						value="${prpljobmanagertimeDto.time}">
					${prpljobmanagertimeDto.time}
				</td>
				<bean:define id="tmpValue" value="${(count+1)/7 }" />
				<logic:equal value="1" name="tmpValue">
					<td rowspan="10" align="center">
						<a onclick="delTable(this);" id='jian' name='jian'>
							<input type="button" value="-" class="smallbutton">
						</a>
					</td>
				</logic:equal>
				<bean:define id="tmpValue1" value="${(count+1)%7 }" />
				<logic:equal value="0" name="tmpValue1">
		</tr>
		<tr>
			</logic:equal>
			</logic:iterate>
			<logic:equal value="31" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
			<logic:equal value="30" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
			<logic:equal value="29" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
			<logic:equal value="28" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
		</tr>
		<tr>
			<td rowspan="5" align="center">
				夜班 18：00～8：00<br/>（含起点时间）
			</td>
			<logic:iterate id="prpljobmanagertimeDto" name="prpljobmanagertimeDtoList" indexId="count">
				<td>
					<input type="checkbox" id="checkboxDayPm1" name="checkboxDayPm1"
						value="${prpljobmanagertimeDto.time}">
					${prpljobmanagertimeDto.time}
				</td>
				<bean:define id="tmpValue" value="${(count+1)%7 }" />
				<logic:equal value="0" name="tmpValue">
		</tr>
		<tr>
			</logic:equal>
			</logic:iterate>
			<logic:equal value="31" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
			<logic:equal value="30" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
			<logic:equal value="29" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
			<logic:equal value="28" name="day">
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td>
					&nbsp;
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','pick')">
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm1','Cancel')">
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
		</tr>
	</tbody>
</table>
<table style="margin-bottom: 0px" class="common" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td width="80%">&nbsp;</td>
		<td width="5%" align="center">
			<input type="button" value="+" class="smallbutton" onclick="addTable();">
		</td>
	</tr>
</table>
<%@include file="/common/jobManager/staffPositionPage.jsp"%>