<%--
****************************************************************************
* DESC       ������������������������ҳ��
* AUTHOR     ��hanliang
* CREATEDATE ��2005-12-14
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
<%@include file="FreightClaimApplyNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>�����������ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
   
  </head>

  <body bgcolor="#FFFFFF">
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
    </tr>
    <tr>
      <td colspan="2" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;"> <strong><B>����������<B> </b></b></strong></td>
    </tr>
  </table>
  <table width="92%"  border="1" align="center" cellspacing="0" cellpadding="2" bordercolor="#111111" style="border-collapse:collapse; font-family:����; font-size:10pt">
 <tr align="center">
    <td width="10%" height="30">��������</td>
    <td colspan="5">&nbsp;</td>
    <td width="15%">Ͷ����</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">���յ�����</td>
    <td colspan="5">&nbsp;</td>
    <td>��������</td>
    <td colspan="3">&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">�ձ�</td>
    <td colspan="3">&nbsp;</td>
    <td colspan="2">��������</td>
    <td colspan="2">&nbsp;</td>
    <td width="10%">����</td>
    <td width="20%">&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">�ͺ�</td>
    <td colspan="3">&nbsp;</td>
    <td colspan="2">�˵�����</td>
    <td colspan="2">&nbsp;</td>
    <td>���ս��</td>
    <td>&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">����·��</td>
    <td colspan="9">&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">���乤��</td>
    <td width="10%">&nbsp;</td>
    <td width="6%">�ƺ�</td>
    <td colspan="2">&nbsp;</td>
    <td width="5%">����</td>
    <td>&nbsp;</td>
    <td width="10%">���յص�</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">��������</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="2">��������</td>
    <td colspan="2">&nbsp;</td>
    <td>��ʧԭ��</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr align="center">
    <td height="30">��ʧ���</td>
    <td colspan="2">&nbsp;</td>
    <td colspan="2">���������</td>
    <td colspan="2">&nbsp;</td>
    <td>�¹�����</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr align="left" valign="top">
    <td height="400" colspan="10">������Ҫԭ��ʩ�ȴ��������</td>
  </tr>
  <tr align="left" valign="top">
    <td height="100" colspan="10"><p>����������������������Ϊ��ʵ���Σ�����Ը�������յ�֮һ��Ȩ�����е���Ӧ�ķ������Ρ�</p>
    <p>&nbsp;</p>
    <p>�������ˣ������ˣ�ǩ�£� ��ϵ�绰�� �� ���� </p></td>
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
