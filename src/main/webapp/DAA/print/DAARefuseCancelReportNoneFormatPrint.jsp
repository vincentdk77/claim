<%--
****************************************************************************
* DESC       �������������վ��� /ע������ҳ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-08
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
  <%-- ��ʼ�� --%>
<%@include file="DAARefuseCancelReportNoneFormatPrintIni.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�����������վ��� /ע������</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<style type="text/css">
<!--
body {
	background-color: #FFFFFF;
}
-->
</style>
</head>

<body bgcolor="#FFFFFF">
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg" width="405" height="65"/></span> </td>
    </tr>
    <tr>
      <td colspan="2" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;"> <strong><B>�����������վ��� /ע������<B> </b></b></strong></td>
    </tr>
</table>
<table width="92%" height="522" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse; font-family:'����'; font-size:10pt ">
  <tr>
    <td height="25" colspan="2" align="center">�������� </td>
    <td height="25" width="228"><div align="center"><%=strInsuredName%></div></td>
    <td height="25"><div align="center">��������</div></td>
    <td height="25"><div align="center"><%=strClaimNo%></div></td>
  </tr>
  <tr>
    <td height="25" colspan="2" align="center">�������� </td>
    <td height="25"><div align="center"><%=strInsuredDate%></div></td>
    <td height="25"><div align="center">���Ƴ���</div></td>
    <td height="25"><div align="center"><%=strBrandName%></div></td>
  </tr>
  <tr>
    <td height="25" colspan="2" align="center" valign="middle">����ʱ��</td>
    <td height="25"><div align="center"><%=strDamageStartDate%></div></td>
    <td height="25"><div align="center">���ƺ���</div></td>
    <td height="25"><div align="center"><%=strLicenseNo%></div></td>
  </tr>
  <tr>
    <td height="25" colspan="2" align="center">���յص�</td>
    <td height="25" colspan="3">&nbsp;&nbsp;<%=strDamageAddress%></td>
  </tr>
  <tr>
    <td height="25" colspan="2" align="center">��������</td>
    <td height="25" colspan="3"><!--<p>��ȫ������ ����Ҫ���� ��ͬ������ ����Ҫ���� ������ </p>-->
      &nbsp;&nbsp;<%=strIndemnityDuty%></td>
  </tr>
  <tr>
    <td height="180" colspan="5" valign="top">&nbsp;������ܣ�<br><br>
	&nbsp;&nbsp;&nbsp;<%=strContext%></td>
  </tr>
  <tr>
    <td height="180" colspan="5" valign="top">&nbsp;���� /ע�����ɣ�<br><br>
      &nbsp;&nbsp;&nbsp;<%=strCancelReason%></td>
  </tr>
  <tr>
    <td height="25" colspan="2" valign="middle"><div align="center">���� /ע����� </div></td>
    <td height="25" valign="top">&nbsp;</td>
    <td width="96" height="25" valign="middle"><div align="center">������</div></td>
    <td width="239" height="25" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="25" colspan="2" valign="middle"><div align="center">����������</div></td>
    <td height="25" valign="top">&nbsp;</td>
    <td height="25" valign="middle"><div align="center">�м�������</div></td>
    <td height="25" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td width="49" height="41" align="center" valign="middle"><table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF">
      <tr>
        <td><div align="center">��</div></td>
      </tr>
      <tr>
        <td><div align="center">��</div></td>
      </tr>
      <tr>
        <td><div align="center">˾</div></td>
      </tr>
    </table></td>
    <td width="80" height="40" align="center" valign="middle">����������</td>
    <td height="80" align="center" valign="middle">��ͬ��&nbsp;&nbsp;&nbsp;&nbsp;<br>
      ������ͬ��<br>
      ����ͬ��&nbsp;&nbsp;</td>
    <td height="40" colspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="40" rowspan="2" align="center" valign="middle"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><div align="center">��</div></td>
      </tr>
      <tr>
        <td><div align="center">��</div></td>
      </tr>
      <tr>
        <td><div align="center">˾</div></td>
      </tr>
    </table></td>
    <td height="41" align="center" valign="middle">�м�������</td>
    <td height="80" align="center" valign="middle">��ͬ��&nbsp;&nbsp;&nbsp;&nbsp;<br>
������ͬ��<br>
����ͬ��&nbsp;&nbsp;</td>
    <td height="41" colspan="2" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td height="41" align="center" valign="middle">��ϯ������</td>
    <td height="80" align="center" valign="middle">��ͬ��&nbsp;&nbsp;&nbsp;&nbsp;<br>
������ͬ��<br>
����ͬ��&nbsp;&nbsp;</td>
    <td height="41" colspan="2" valign="top">&nbsp;</td>
  </tr>
</table>
<%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  <script language='javascript'>
    function printPage()
    {
      divButton.style.display = "none";
      window.print();
    }
  </script>
</body>
</html>
