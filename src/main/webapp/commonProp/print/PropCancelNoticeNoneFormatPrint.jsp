<%--
****************************************************************************
* DESC       ���Ʋ��վ��ⰸ��֪ͨ���ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��22004-11-16
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
  <%@include file="PropCancelNoticeNoneFormatPrintIni.jsp"%>
<html>
<head>
    <title>�Ʋ��վ��ⰸ��֪ͨ���ӡ</title>                                
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    </head>
<body bgcolor="#FFFFFF" onload="loadForm();">
<p align="center"><strong><font size="5"> �Ʋ��������޹�˾</font></strong></p>
<p align="center"><font size="6" face="����">�� �� �� �� ͨ ֪ ��</font></p>
<table width="92%" border="0" align="center" cellspacing="0">
  <tr>
    <td width="20%" height="36">��������:</td>
    <td width="30%" id="tdInsuredName">&nbsp;</td>
    <td width="20%">�ⰸ��ţ�</td>
    <td width="30%" id="tdCompensateNo">&nbsp;</td>
  </tr>
</table>
<table width="96%" border="1" align="center" cellspacing="0">
  <tr> 
    <td width="20%" height="36">�б��ձ�</td>
    <td width="30%" id="tdRiskCode">&nbsp;</td>
    <td width="20%">��������</td>
    <td width="30%" id="tdPolicyNo">&nbsp;</td>
  </tr>
  <tr> 
    <td height="36">���յص�</td>
    <td id="tdDamageAddress">&nbsp;</td>
    <td>���ձ��</td>
    <td id="tdLossName">&nbsp;</td>
  </tr>
  <tr> 
    <td height="36">����ʱ��</td>
    <td id="tdDamageStartDate">&nbsp;</td>
    <td>���ս��</td>
    <td id="tdSumAmount">&nbsp;</td>
  </tr>
</table>
<table width="92%" border="0" align="center" cellspacing="0">
<tr>
  <td height="36"><b>����ԭ����ʧ���</b></td>
</tr>
<tr>
   <td colspan="8" height="175" valign="top" id="tdRegistText"></td>
</tr>
<tr>
  <td height="36"><b>��������</b></td>
</tr>
<tr>
   <td colspan="8" height="175" valign="top" id="tdCancelReason"></td>
</tr>
<tr>
   <td width="60%" height="36" align="center">&nbsp;</td>
   <td width="20%" height="36" align="center">���죺</td>
   <td width="20%" height="36" align="center">ǩ����</td>
</tr>
<br><br><br>
<tr>
   <td width="60%" height="36" align="center">&nbsp;</td>
   <td width="20%" height="36" align="center">ǩ�ţ�</td>
   <td width="20%" height="36" align="center">&nbsp;��&nbsp;��&nbsp;�գ�</td>
</tr>
</table>
<p>&nbsp; </p>
<p>&nbsp; </p>
<%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />  
</body>
</html>
