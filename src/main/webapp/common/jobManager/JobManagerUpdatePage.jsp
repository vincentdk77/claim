<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<input type="hidden" id="updateType" name="updateType" value="${updateType}"/>
<%-- 班表信息 --%>
<table id="tab" name="tab"
	style="table-layout: fixed; margin-bottom: 0px" class="common" 
	cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8">
	<logic:iterate id="prpljobmanagerDto" name="prpljobmanagerDtoList" indexId="countNo">
	<tbody>
		<tr align="center">
			<td class="centertitle" style="width: 10%">
				班次名称
				<input type="hidden" id="countNo" name="countNo" value="${countNo+1}">
				<input type="hidden" id="flowinTimeDate" name="flowinTimeDate" value="${prpljobmanagerDto.flowintime}">
			</td>

			<td class='centertitle' style="width: 10%">
				查勘人员
			</td>
			<td class="centertitle" style="width: 10%">
				<input type="hidden" id="handlercode" name="handlercode" value="${prpljobmanagerDto.handlercode}" size="5">
				${prpljobmanagerDto.handlername}
				<select id="userCode" name="userCode" onchange="setUp(this);" style="display: none">
					<option value="" >
						请选择
					</option>
					<c:forEach items="${prpDuserDtoList}" var="prpDuserDto"
						varStatus="count">
						<option value="${prpDuserDto.userCode}" <c:if test="${prpDuserDto.userCode eq prpljobmanagerDto.handlercode}">selected="true"</c:if> >
							${prpDuserDto.userName}
						</option>
					</c:forEach>
				</select>
				<input type="hidden" id="handlername" name="handlername" value="${prpljobmanagerDto.handlername}"/>
				<input type="hidden" id="id" name="id" value="${prpljobmanagerDto.id}"/>
			</td>
			<td class='centertitle' style="width: 10%">
				工作角色
			</td>
			<td class='centertitle' style="width: 20%" colspan="2">
				<input type="hidden" name="jobRole" id="jobRole" value="${prpljobmanagerDto.jobrole}" />
				<logic:equal value="yes" name="prpljobmanagerDto" property="state">
					<logic:iterate id="prpDuserDto" name="prpDuserDtoList">
						<logic:equal value="${prpljobmanagerDto.handlercode}" name="prpDuserDto" property="userCode">
							<logic:notEqual value="05" name="prpljobmanagerDto" property="classcode">
								<input type="checkbox" name="gradecodeBox" id="" value="3" onclick="checkboxFilter(this)" <logic:match value="3" name="prpljobmanagerDto" property="jobrole">checked="checked"</logic:match><logic:notMatch value="3" name="prpDuserDto" property="gradecode"> disabled="disabled"</logic:notMatch> >非车查勘&nbsp;&nbsp;
							</logic:notEqual>
							<logic:equal value="05" name="prpljobmanagerDto" property="classcode">
								<input type="checkbox" name="gradecodeBox" id="" value="1" onclick="checkboxFilter(this)" <logic:notEqual value="2" name="prpljobmanagerDto" property="jobrole">checked="checked"</logic:notEqual><logic:equal value="2" name="prpDuserDto" property="gradecode">disabled="disabled"</logic:equal> >车物查勘&nbsp;&nbsp;
								<input type="checkbox" name="gradecodeBox" id="" value="2" onclick="checkboxFilter(this)" <logic:notEqual value="1" name="prpljobmanagerDto" property="jobrole">checked="checked"</logic:notEqual><logic:equal value="1" name="prpDuserDto" property="gradecode">disabled="disabled"</logic:equal> > 人伤查勘
							</logic:equal>
						</logic:equal>
					</logic:iterate>
				</logic:equal>
				<logic:equal value="no" name="prpljobmanagerDto" property="state">
					<logic:notEqual value="05" name="prpljobmanagerDto" property="classcode">
						<input type="checkbox" name="gradecodeBox" id="" value="3" onclick="checkboxFilter(this)" <logic:match value="3" name="prpljobmanagerDto" property="jobrole">checked="checked"</logic:match> disabled="disabled">非车查勘&nbsp;&nbsp;
					</logic:notEqual>
					<logic:equal value="05" name="prpljobmanagerDto" property="classcode">
						<input type="checkbox" name="gradecodeBox" id="" value="1" onclick="checkboxFilter(this)" <logic:notEqual value="2" name="prpljobmanagerDto" property="jobrole">checked="checked"</logic:notEqual> disabled="disabled">车物查勘&nbsp;&nbsp;
						<input type="checkbox" name="gradecodeBox" id="" value="2" onclick="checkboxFilter(this)" <logic:notEqual value="1" name="prpljobmanagerDto" property="jobrole">checked="checked"</logic:notEqual> disabled="disabled">人伤查勘
					</logic:equal>
				</logic:equal>
			</td>
			<td class="centertitle" style="width: 10%">
				所在机构
			</td>
			<td class="centertitle" style="width: 10%">
				<input type="text" id="comCName" name="comCName" value="${prpljobmanagerDto.deptname}">
			</td>
			<td class="centertitle" style="width: 5%">
				操作
			</td>
		</tr>
		<tr>
			<td rowspan="5" align="center">
				白班 8：00～18：00<br/>（含起点时间）
			</td>
			<logic:iterate id="prpljobmanagertimeDto" name="prpljobmanagerDto" property="prpljobmanagertimeDtoListAm" indexId="count">
				<logic:equal value="${prpljobmanagerDto.id }" name="prpljobmanagertimeDto" property="fid">
					<logic:equal value="AM" name="prpljobmanagertimeDto" property="datetype">
						<td>
							<input type="checkbox" id="checkboxDayAm${countNo+1}" name="checkboxDayAm${countNo+1}" value="${prpljobmanagertimeDto.time}" <logic:equal value="1" name="prpljobmanagertimeDto" property="states" >checked='checked' </logic:equal>/>
							${prpljobmanagertimeDto.time}
						</td>
					</logic:equal>
				</logic:equal>
				<bean:define id="tempIndex" value="${(count+1)/7 }" />
				<logic:equal value="1" name="tempIndex">
					<bean:define id="tmpBvalue" value="${updateType ne 'individual' and editType ne 'SHOW' }" />
					<td rowspan="10" align="center">
						<a  id='jian' name='jian' <logic:equal value="true" name="tmpBvalue">onclick="delTable(this);"</logic:equal> ><input type="button" value="-" class="smallbutton" <logic:equal value="individual" name="updateType">disabled="disabled"</logic:equal> ></a>
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
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','Cancel')"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','Cancel')"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','Cancel')"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayAm${countNo+1}','Cancel')"/>
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
		</tr>
		<tr>
			<td rowspan="5" align="center">
				夜班 18：00～8：00<br/>（含起点时间）
			</td>

			<logic:iterate id="prpljobmanagertimeDto" name="prpljobmanagerDto" property="prpljobmanagertimeDtoListPm" indexId="count">
				<logic:equal value="${prpljobmanagerDto.id}" name="prpljobmanagertimeDto" property="fid">
					<logic:equal value="PM" name="prpljobmanagertimeDto" property="datetype">
						<td>
							<input type="checkbox" id="checkboxDayPm${countNo+1}" name="checkboxDayPm${countNo+1}" value="${prpljobmanagertimeDto.time}" <logic:equal value="1" name="prpljobmanagertimeDto" property="states">checked='checked'</logic:equal>/>
							${prpljobmanagertimeDto.time}
						</td>
					</logic:equal>
				</logic:equal>
				<bean:define id="tmpValue" value="${(count+1)%7}"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','Cancel')"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','Cancel')"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','Cancel')"/>
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
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','pick')"/>
					<input type="button" class="button" value="全部选择">
				</td>
				<td align="center" onclick="allPick(this,'checkboxDayPm${countNo+1}','Cancel')"/>
					<input type="button" class="button" value="全部取消">
				</td>
			</logic:equal>
		</tr>
	</tbody>
	</logic:iterate>
</table>
<table style="margin-bottom: 0px" class="common" cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td width="80%">&nbsp;</td>
		<td width="5%" align="center">
			<input type="button" value="+" class="smallbutton" onclick="addTable();" <logic:equal value="individual" name="updateType">disabled="disabled"</logic:equal> >
		</td>
	</tr>
</table>
<logic:notEqual value="individual" name="updateType">
	<%@include file="/common/jobManager/staffPositionPage.jsp"%>
</logic:notEqual>