<%--

****************************************************************************

* DESC       ���������ⰸ�սᱨ���顡

* AUTHOR     ��dongchengliang

* CREATEDATE ��2005-6-16

* MODIFYLIST ��   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>

<%@ page contentType="text/html; charset=GBK"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper"%>
<%
String strTempContext = request.getAttribute("tempContext").toString();
%>


<%-- ��ʼ�� --%>





<html>

<head>

<title>�᰸����</title>

<link rel="stylesheet" type="text/css" href="Standard.css">

</head>



<body bgcolor="#FFFFFF">

<!-- ���ⲿ�� -->



<table width="90%" align="center" cellspacing="0" cellpadding="0"
	border="0">


<tr>
          <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
                <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr> 
          <tr>
		<td colspan="2" height="40" align=top align=center
			style="text-align: center; font-family: ����; font-size: 16pt;"><B><bean:write
			name='prpLclaimDto' property='riskCodeName' filter='true' />�᰸���� <B></td>

	</tr>
</table>

<table border=1 width="90%" align="center" cellspacing="0"
	cellpadding="2" style="border-collapse: collapse" bordercolor="#111111"
	style="font-family:����; font-size:10pt;">

	<tr>

		<td width="20%">��������</td>

		<td width="30%"><bean:write name='prpLclaimDto'
			property='insuredName' filter='true' /></td>

		<td width="20%">��������</td>

		<td width="30%"><bean:write name='prpLclaimDto'
			property='policyNo' filter='true' /></td>

	</tr>



	<tr>

		<td width="20%">���ս��</td>

		<td width="30%"><bean:write name='prpLclaimDto'
			property='sumAmount' filter='true' format="##0.00" /></td>

		<td width="20%">����</td>
		<td width="30%"><bean:write name='prpLclaimDto' property='sumPremium' filter='true' format="##0.00" /></td>

	</tr>
	<tr>

		<td width="20%">��������</td>

		<td width="30%"><bean:write name='prpLclaimDto'
			property='damageStartDate' filter='true' /> </td>

		<td width="20%">���յص�</td>

		<td width="30%"><bean:write name='prpLclaimDto'
			property='damageAddress' filter='true' /></td>

	</tr>

</table>


<table border=1 width="90%" align="center" cellspacing="0"
	cellpadding="2" style="border-collapse: collapse" bordercolor="#111111"
	style="font-family:����; font-size:10pt;">

	<tr border="0">
		<td height="40" align=top align=center 
			style="text-align: center; font-family: ����; font-size: 14pt;"><B>�᰸����<B>
		</td>
	</tr>
	<tr>
		<td height="700" valign=top align=left>
		    <%=strTempContext%>
		</td>
	</tr>
</table>

<!--include��ӡ��ť-->

<jsp:include page="/common/print/PrintButton.jsp" />
</body>

</html>

