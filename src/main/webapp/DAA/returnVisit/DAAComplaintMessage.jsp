<%@ page contentType="text/html; charset=GBK"%>
<table cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8"
	class="common">
	<tr ondblclick="showPage(RegistExtImg1,top1)">

		<td colspan="4" class="tabletitle">
			<div style="padding-left: 3px">
				<img style="cursor: hand;" src="/claim/images/butExpandBlue.gif"
					name="RegistExtImg1" id="RegistExtImg1"
					onclick="showPage(this,top1)">
				<span>Ͷ����Ϣ</span>
			</div>
		</td>
	</tr>

	<tbody id="top1">
		<tr>
			<td class='title w15 textr' style="width: 20%">
				Ͷ�߱�ţ�
			</td>
			<td class='input' style="width: 30%">
				${prplcomplaintDto.complaintno}
				<input type="hidden" name="complaintno" id="complaintno" value="${prplcomplaintDto.complaintno}" class="query">
			</td>
			<td class='title w15 textr' style="width: 20%">
				Ͷ��ʱ�䣺
			</td>
			<td class='input' style="width: 30%">
				${prplcomplaintDto.complaintdate}
				<input type="hidden" name="complaintdate" id="complaintdate" value="${prplcomplaintDto.complaintdate}" class="query">
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				Ͷ�ߴ��ࣺ
			</td>
			<td class='input'>
				<select id="" class=common name="complainttypeSelect" onchange="selectBut(this,'complainttype');"  <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if> >
					<option value="">
						��ѡ��
					</option>
					<c:forEach items="${prpDcodeComplaintType}" var="complaintType">
						<option value="${complaintType.codeCode}" <c:if test="${prplcomplaintDto.complainttype eq complaintType.codeCode}">selected="selected"</c:if> >
							${complaintType.codeCName}
						</option>
					</c:forEach>
				</select><font color="red">*</font>
				<input type="hidden" cname="Ͷ�ߴ���" name="complainttype" id="complainttype" value="${prplcomplaintDto.complainttype}">
			</td>
			<td class='title w15 textr'>
				��Ͷ�߻�����
			</td>
			<td class='input'>
			<!-- 
				<select id="" class=common name="bycomplaintcomcodeSelect" onchange="selectBut(this,'bycomplaintcomcode');">
					<option value="0">
						��ѡ��
					</option>
					<c:forEach items="${prpDcompanyDtoList}" var="prpDcompanyDto">
						<option value="${prpDcompanyDto.comCode}" <c:if test="${prplcomplaintDto.bycomplaintcomcode eq prpDcompanyDto.comCode}">selected="selected"</c:if> >
							${prpDcompanyDto.comCName}
						</option>
					</c:forEach>
				</select>
					<input type="hidden" name="bycomplaintcomcode" id="bycomplaintcomcode" value="${prplcomplaintDto.bycomplaintcomcode}">
			 -->
				<input type="hidden" class="codecode" name="handleCode" style="width:20%" title="���嵥λ" value="${prplcomplaintDto.bycomplaintcomcode}" ondblclick="open_CodeSelectWorkRove(this, 'ComCodeByProvinceCode');" onkeyup= "open_CodeSelectWorkRove(this, 'ComCodeByProvinceCode');" onblur="open_CodeSelectWorkRove(this, 'ComCodeByProvinceCode','1','code','post','clear');"/>
				<input type="text" cname="��Ͷ�߻���" class="codecode" name="handleName" readonly="readonly"  title="���嵥λ" style="width:90%" maxLength="50"  value="${prplcomplaintDto.bycomplaintcomcodeName}" ondblclick = "open_CodeSelectWorkRove(this,'ComCode','��Ͷ�߻���');"  <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>/><font color="red">*</font>
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				��Ͷ���ˣ�
			</td>
			<td>
				<input type="text" style="width:90%" name="bycomplaintcode" id="bycomplaintcode" class="input" value="${prplcomplaintDto.bycomplaintcode}" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>>
				<input type="hidden" name="bycomplaintcode" id="bycomplaintcode" class="input" value="${prplcomplaintDto.bycomplaintcode}">
			</td>
			<td class='title w15 textr'>
				Ͷ����������
			</td>
			<td>
				<input type="text" style="width:90%" cmax="20" cname="Ͷ��������" name="complaintname" id="complaintname" class="input" value="${prplcomplaintDto.complaintname}" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>><font color="red">*</font>
				<input type="hidden" name="complaintname" id="complaintname" class="input" value="${prplcomplaintDto.complaintname}">
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				������룺
			</td>
			<td>
				<input type="text" style="width:90%" cmax="20" cname="�������" name="callno" id="callno" class="input" value="${prplcomplaintDto.callno}" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>><font color="red">*</font>
				<input type="hidden" name="callno" id="callno" class="input" value="${prplcomplaintDto.callno}">
			</td>

			<td class='title w15 textr'>
				������ϵ�绰��
			</td>
			<td>
				<input type="text" style="width:90%" name="telephone" id="telephone" class="input" value="${prplcomplaintDto.telephone}" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>>
				<input type="hidden" name="telephone" id="telephone" class="input" value="${prplcomplaintDto.telephone}">
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				Ͷ��ԭ��
			</td>

			<td colspan="3">
				<c:forEach items="${prpDcodeVisitIssue}" var="visitIssue">
					<input type="checkbox" name="existissueBox" id="existissueBox" onclick="checkboxBut(this);" value="${visitIssue.codeCode}" <c:if test="${fn:contains(prplcomplaintDto.complaintcause,visitIssue.codeCode)}">checked="" </c:if> <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>/>${visitIssue.codeCName}
				</c:forEach><font color="red">*</font>
				<input type="hidden" cname="Ͷ��ԭ��" size="10" name="complaintcause" id="complaintcause" value="${prplcomplaintDto.complaintcause}">



			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				Ͷ����ϸԭ��
			</td>
			<td colspan="3">
				<textarea rows="4" style="width: 95%" onchange="textareaValue(this)" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>>${prplcomplaintDto.detailedcause}</textarea><font color="red">*</font>
				<input type=hidden name="detailedcause" id="detailedcause" cname="Ͷ����ϸԭ��"  cmax="1000" class="" style="width: 95%" value="${prplcomplaintDto.detailedcause}">
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				�Ƿ���ЧͶ�ߣ�
			</td>
			<td>
				<input type="hidden" cname="�Ƿ���ЧͶ��" name="whethercomplaint" size="5" id="whethercomplaint" value="${prplcomplaintDto.whethercomplaint}">
				<input id="radiobutton1" type=radio name="" value="1" onclick="selectBut(this,'whethercomplaint');" <c:if test="${prplcomplaintDto.whethercomplaint eq '1'}">checked="checked"</c:if> <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if> >
				��

				<input id="radiobutton2" type=radio name="" value="2" onclick="selectBut(this,'whethercomplaint');" <c:if test="${prplcomplaintDto.whethercomplaint eq '2'}">checked="checked"</c:if> <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if> >
				��<font color="red">*</font>
			</td>
			<td class='title w15 textr' id="trackingTd">
				�Ƿ���Ҫ���٣�
			</td>
			<td id="trackingValue">
				<input type="hidden" cname="�Ƿ���Ҫ����" name="whethertrack" size="5" id="whethertrack" value="${prplcomplaintDto.whethertrack}">
				<input id="radioTracking1" type=radio name="radioTracking" value="1" onclick="selectBut(this,'whethertrack');" <c:if test="${prplcomplaintDto.whethertrack eq '1'}">checked="checked"</c:if> <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if> >
				��
				<input id="radioTracking2" type=radio name="radioTracking" value="2" onclick="selectBut(this,'whethertrack');" <c:if test="${prplcomplaintDto.whethertrack eq '2'}">checked="checked"</c:if> <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if> >
				��<font color="red">*</font>
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				�������룺
			</td>
			<td>
				<input type="text" style="width:90%" name="registno" id="registno" class="" value="${prplcomplaintDto.registno}" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if> maxLength="22">
				<input type="hidden" name="registno" id="registno" class="" value="${prplcomplaintDto.registno}">
			</td>

			<td class='title w15 textr'>
				¼����ˮ�ţ�
			</td>
			<td>
				<input type="text" style="width:90%" cmax="20" cname="¼����ˮ��" name="recordingno" id="recordingno" class="" value="${prplcomplaintDto.recordingno}" <c:if test="${nodeTypes eq 'dealWith' or nodeTypes eq 'compl'}">disabled="disabled"</c:if>><font color="red">*</font>
				<input type="hidden" name="recordingno" id="recordingno" class="" value="${prplcomplaintDto.recordingno}">
			</td>
		</tr>
		<tr>
			<td class='title w15 textr'>
				������Ա��
			</td>
			<td class='input'>
				${prplcomplaintDto.handlername}
				<input type="hidden" name="handlercode" id="handlercode" value="${prplcomplaintDto.handlercode}" class="query">
				<input type="hidden" name="handlername" id="handlername" value="${prplcomplaintDto.handlername}" class="query">
				<input type="hidden" name="handlercomcode" id="handlercomcode" value="${prplcomplaintDto.handlercomcode}" class="query">
			</td>
			<td class='title w15 textr'>
				���ʱ�䣺
			</td>
			<td class='input'>
				${prplcomplaintDto.handlerdate}
				<input type="hidden" name="handlerdate" id="handlerdate" value="${prplcomplaintDto.handlerdate}" class="query">
			</td>
		</tr>
	</tbody>
</table>




