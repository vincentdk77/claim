<%--
****************************************************************************
* DESC       ��������������(����)֤����ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
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
<%
System.out.println("--------1---");
%>
  <%@include file="DAAPilferNoneFormatPrintIni.jsp"%>

<%
System.out.println("--------2---");
%>
<html>
  <head>
    <title>�����������գ�������֤����ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
            <B>�����������գ�������֤��<B>
          </td>
        </tr>
        <tr>
          <td align=left id="tdRegistNo" style="font-family:����; font-size:10pt;">
            &nbsp;
          </td>
          <td align=right id="tdClaimNo" style="font-family:����; font-size:10pt;">
             &nbsp;
          </td>
        </tr>
      </table>

      <!-- ���岿�� -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
        <tr>
          <td height="25" rowspan="8" align="center" width="4%">����������Ϣ</td>
          <td id="tdInsuredName" height="25" width="34%" align="left">�������ˣ�</td>
          <td id="tdLinkerName" height="25" colspan="2" align="left">��ϵ�ˣ�</td>
          <td id="tdPhoneNumber" height="25" colspan="2" align="left">��ϵ�绰��</td>
        </tr>
        <tr>
          <td id="tdComName" height="25" width="34%" align="left">�б���˾��</td>
          <td id="tdLinkerName1" height="25" colspan="2" align="left">��ϵ�ˣ�</td>
          <td id="tdPhoneNumber1" height="25" colspan="2" align="left">��ϵ�绰��</td>
        </tr>
        <tr>
          <td id="tdBrandName" height="25" width="34%" align="left">�����ͺţ�</td>
          <td id="tdLicenseNo" height="25" colspan="2" align="left">���ƺ��룺</td>
          <td id="tdColorCode" height="25" colspan="2" align="left">������ɫ��</td>
        </tr>
        <tr>
          <td id="tdEngineNo" height="25" width="34%" align="left">�������ţ�</td>
          <td id="tdFrameNo" height="25" colspan="4" align="left">���ܺţ�VIN����</td>
        </tr>
        <tr>
          <td id="tdPurchasePrice" height="25" width="34%" align="left">�³����üۣ�</td>
          <td id="tdSeatCount" height="25" colspan="2" align="left">��λ/��λ��</td>
          <td id="tdEnrollDate" height="25" colspan="2" align="left">�������εǼ����ڣ�</td>
        </tr>
        <tr>
          <td id="tdDriverName" height="25" width="34%" align="left">��ʻԱ������</td>
          <td id="tdDrivingLicenseNo" height="25" colspan="4" align="left">��ʻ֤���룺</td>
        </tr>
        <tr>
          <td id="tdReceiveLicenseDate" height="25" colspan="2" align="left">������֤���ڣ�</td>
          <td id="tdDrivingCarType" height="25" colspan="3" align="left">׼�ݳ��ͣ�</td>
        </tr>
        <tr>
          <td id="tdDamageStartDate" height="25" colspan="2" align="left">����ʱ�䣺</td>
          <td id="tdDamageAddress" height="25" colspan="2" align="left">���յص㣺</td>
          <td id="tdLinkerPostCode" height="25" width="20%" align="left">�������룺</td>
        </tr>
        <tr>
          <td width="4%" align="center" height="156">�������ռ���������</td>
          <td colspan="5" align="left" height="156">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="70%">
                <td id="tdRegistText" colspan="12" height="200" valign="top">
                  <input type=text rows=18 cols=95 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">
                </td>
              </tr>
              <tr height="25">
                <td width="70%">&nbsp;</td>
                <td align="left" width="30%">
                  ��������ǩ�£�ǩ�֣���
                </td>
              </tr>
              <tr height="25">
                <td width="70%">&nbsp;</td>
                <td align="left" width="30%">
                  ǩ�������֤���룺
                </td>
              </tr>
              <tr height="25">
                <td width="70%">&nbsp;</td>
                <td align="left" width="30%">
                  ʱ�䣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
                </td>
              </tr>
            </table>

          </td>
        </tr>
        <tr>
          <td width="4%" align="center" height="154">��������������</td>
          <td colspan="5" align="left" height="154">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="70%">
                <td colspan="2">&nbsp;</td>
              </tr>
              <tr height="25">
                <td width="70%">&nbsp;</td>
                <td align="left" width="30%">
                  ֤������ǩ�£�
                </td>
              </tr>
              <tr height="25">
                <td width="70%">&nbsp;</td>
                <td align="left" width="30%">
                  �����ˣ�
                </td>
              </tr>
              <tr height="25">
                <td width="70%">&nbsp;</td>
                <td align="left" width="30%">
                  ʱ�䣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
                </td>
              </tr>
            </table>

          </td>
        </tr>
      </table>

      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />

    </form>
  </body>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html>
