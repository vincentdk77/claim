<%--

****************************************************************************

* DESC       �����������������������ӡҳ��

* AUTHOR     ��luqin

* CREATEDATE ��2005-6-8

* MODIFYLIST ��   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>

<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

  <%-- ��ʼ�� --%>

  <%@include file="ClaimDisposeReportNoneFormatPrintIni.jsp"%>

<html>

    <head>

        <title>�ⰸ������</title>

    </head>

	<body bgcolor="#FFFFFF" onload="loadForm();">

	    <h1 align="center">��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��</h1>

		<table width="80%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" 

		    bordercolor="#111111" style="font-family:����; font-size:10pt;"> 

		  <tr>

		    <td valign="middle" height="23"><b>�ⰸ���:</b></td>

		    <td id="tdCaseNo" height="25" colspan="7">&nbsp;1</td>

		  </tr>

			<tr>

			  <td valign="middle" height="23"><b>��&nbsp;��&nbsp;��:</b></td>

			  <td id="tdPolicyNo" height="25" colspan="7">&nbsp;2</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>��&nbsp;&nbsp;��:</b></td>

			  <td id="tdRiskCode" height="25" colspan="7">&nbsp;3</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>��&nbsp;&nbsp;��:</b></td>

			  <td id="tdSumAmount" height="25" colspan="7">&nbsp;4</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>�����ڼ�</b></td>

			  <td id="tdInsuredDate" height="25" colspan="7">&nbsp;5</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>�������˵����ƺ͵�ַ:</b></td>

			  <td id="tdInsuredName" height="25" colspan="7">&nbsp;6</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>���յص�:</b></b></td>

			  <td id="tdDamageAddress" height="25" colspan="7">&nbsp;7</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>�������ں�ʱ��:</b></td>

			  <td id="tdDamageStartDate" height="25" colspan="7">&nbsp;8</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>�����/����</b></td>

			  <td id="tdIndemnityDuty" height="25" colspan="7">&nbsp;9</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>������:</b></td>

			  <td id="tdSumClaim" height="25" colspan="7">&nbsp;10</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>�⸶���:</b></td>

			  <td id="tdSumDefLoss" height="25" colspan="7">&nbsp;11</td>

			</tr>

			<tr>

			  <td valign="middle" height="23"><b>�᰸���</b>:</b></td>

			  <td id="tdSumPaid" height="25" colspan="7">&nbsp;12</td>

			</tr>

			

			<tr><td valign="middle" height="23"><b>һ.�Ᵽ���˸ſ�</b></td><td>&nbsp;</td></tr>

			<tr><td valign="middle" height="23"><b>��.�¹ʾ�����ԭ�����</b></td><td>&nbsp;</td></tr>

			<tr><td valign="middle" height="23"><b>��.��������</b></td><td>&nbsp;</td></tr>

			<tr><td valign="middle" height="23"><b>��.���Ͷ��</b></td><td>&nbsp;</td></tr>

			<tr><td valign="middle" height="23"><b>��.�Ƿ�����ظ�Ͷ�����������׷��ǰ��</b></td><td>&nbsp;</td></tr>

            <tr><td valign="middle" height="23"><b>��.���⼰����</b></td><td>&nbsp;</td></tr>

			<tr><td valign="middle" height="23"><b>��.�ܽ���⸶</b></td><td>&nbsp;</td></tr>

			<tr><td valign="middle" height="23">�����ˣ�</td><td>�����ˣ�</td></tr>

		</table>

	</body>

</html>