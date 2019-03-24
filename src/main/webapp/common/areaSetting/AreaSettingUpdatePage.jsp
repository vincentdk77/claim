<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<table id="tab" name="tab"
	style="table-layout: fixed; margin-bottom: 0px;border-collapse:collapse;background-color: #F7F7F7;" class="common"
	cellpadding="0" cellspacing="0" border="1" bordercolor="#3A81C8">
	<tr class="textc">
		<td class="centertitle">
			序号
		</td>
		<td class="centertitle">
			工号
		</td>
		<td class="centertitle">
			查勘员
		</td>
		<td class="centertitle">
			作业区域
		</td>
		<td class="centertitle">
			手机号码
		</td>
		<td class="centertitle">
			操作
		</td>
	</tr>
	<logic:iterate id="prplareasettingDto" name="prplareasettingDtoList" indexId="count">
		<tr>
			<td align="center">
				<span id="spanId">${count+1}</span>
				<input type="hidden" id="indexId" name="indexId" value="${count+1}">
			</td>
			<td>
				${prplareasettingDto.handlercode}
				<input type="hidden" name="handlercode" class="codecode"
					style="width: 100%" maxlength="10" title="操作员" value="${prplareasettingDto.handlercode}"
					ondblclick="code_CodeSelect(this, 'CertaJobCode');"
					onkeyup="code_CodeSelect(this, 'CertaJobCode');"
					onblur="code_CodeChange(this, 'CertaJobCode','1','code','post','clear');">
	
			</td>
			<td>
				${prplareasettingDto.handlername}
				<input type="hidden" name="handlername" class="" style="width: 100%"
					title="操作员" maxlength="30" value="${prplareasettingDto.handlername}">
			</td>
			<td onclick="showMsg(this)" class="textc">
				<logic:equal value="" name="prplareasettingDto" property="area">
					<span id="spanText">作业区域</span>
				</logic:equal>
				<logic:notEqual value="" name="prplareasettingDto" property="area">
					<span id="spanText">${prplareasettingDto.areaName}</span>
				</logic:notEqual>
				<input type="hidden" id="id" name="id" value="${prplareasettingDto.id}">
				<input type="hidden" id="area" name="area" value="${prplareasettingDto.area}">
				<input type="hidden" id="flowintime" name="flowintime" value="${prplareasettingDto.flowintime}">
				
			</td>
			<td>
				<input type="text" id="tel" name="tel" value="${prplareasettingDto.tel}" style="width: 100%">
			</td>
			<td align="center">
				<input type="button" class="smallbutton" value="-" onclick="delTable(this);"/>
			</td>
		</tr>
	</logic:iterate>
</table>
<table style="table-layout: fixed; margin-bottom: 0px;" class="common"
	cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">&nbsp;</td>
		<td colspan="1" align="center">
			<input type="button" value="+" class="smallbutton" onclick="addTable();" <logic:equal value="single" name="state">disabled="true"</logic:equal> >
		</td>
	</tr>
</table>