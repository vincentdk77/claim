<%@ page contentType="text/html; charset=GBK"%>
<table id="tab" name="tab"
	style="table-layout: fixed; margin-bottom: 0px" class="common" 
	cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8">

	<tr class="textc">
		<td class="centertitle">
			���
		</td>
		<td class="centertitle">
			����
		</td>
		<td class="centertitle">
			�鿱Ա
		</td>
		<td class="centertitle">
			��ҵ����
		</td>
		<td class="centertitle">
			�ֻ�����
		</td>
		<td class="centertitle">
			����
		</td>
	</tr>
	<tr>
		<td align="center">
			<span id="spanId">1</span>
			<input type="hidden" id="indexId" name="indexId" value="1">
		</td>
		<td>

			<input type=text name="handlercode" class="codecode"
				style="width: 100%" maxlength="10" title="����Ա" value=""
				ondblclick="code_CodeSelect(this, 'CertaJobCode');"
				onkeyup="code_CodeSelect(this, 'CertaJobCode');"
				onblur="code_CodeChange(this, 'CertaJobCode','1','code','post','clear');" onchange="setUser(this)">

		</td>
		<td>
			<input type=text name="handlername" class="" style="width: 100%;TEXT-DECORATION: none;BORDER-TOP: medium none;"
				title="����Ա" maxlength="30" value="" readonly>
		</td>
		<td onclick="showMsg(this)" class="textc">
			<span id="spanText">��ҵ����</span>
			<input type="hidden" id="id" name="id" value="">
			<input type="hidden" id="area" name="area" value="">
			<input type="hidden" id="flowintime" name="flowintime" value="">
		</td>
		<td>
			<input type="text" id="tel" name="tel" style="width: 100%">
		</td>
		<td align="center">
			<input type="button" class="smallbutton" value="-" onclick="delTable(this);"/>
		</td>
	</tr>
</table>
<table style="table-layout: fixed; margin-bottom: 0px" class="common" 
	cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan="5">&nbsp;</td>
		<td colspan="1" align="center">
			<input type="button" value="+" class="smallbutton" onclick="addTable();">
		</td>
	</tr>
</table>