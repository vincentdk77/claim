<%--
****************************************************************************
* DESC       ��������鱨���ӡ
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-13
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%-- ��ʼ�� --%>
<%@include file="AcciInvesReportNoneFormatPrintIni.jsp"%>

<html>
<head>
<title>������鱨���ӡ</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body onLoad="loadForm();">
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>      
        <tr>
          <td colspan="3" height="20" align=center style="font-family:����; font-size:14pt;">
            <B>������鱨��<B>
          </td>
        </tr>
        <tr>
          <td width="33%" height="20" align=center style="font-family:����; font-size:10pt;"><div align="left">�����ţ�<span id="spRegistNo">&nbsp;</span></div></td>
          <td width="35%" height="20" align=center style="font-family:����; font-size:10pt;"><div align="left">�����ţ�<span id="spClaimNo">&nbsp;</span></div></td>
          <td width="32%" height="20" align=center style="font-family:����; font-size:10pt;"><div align="right"> �ύ�������ڣ�<span id="spCheckYear">&nbsp;&nbsp;&nbsp;&nbsp;</span>��<span id="spCheckMonth">&nbsp;&nbsp;</span>��<span id="spCheckDate">&nbsp;&nbsp;</span>��</div></td>
        </tr>
        <tr>
          <td height="20" colspan="3" align=center style="font-family:����; font-size:10pt;"><table width="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse; font-family:���� font-size:10pt;">
            <tr height="185">
              <td width="2%"><p align="center">�ύ��������д�� </p></td>
              <td colspan="2" valign="top">
                <table width="100%" height="185"  border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr align="left">
                    <td height="25" colspan="2">&nbsp;�¹���������<!--<span id="spAcciName">&nbsp;</span>--></td>
                    <td colspan="2"> �¹ʽ����</td>
                  </tr>
                  <tr align="left">
                    <td height="25" colspan="4">&nbsp;������Ŀ�� </td>
                  </tr>
                  <tr>
                    <td height="110" colspan="4"> <br>
                        <br>
                        <br>
                        <br>
                        <br></td>
                  </tr>
                  <tr>
                    <td width="18%" height="25"><div align="right"></div></td>
                    <td width="18%">&nbsp;</td>
                    <td width="20%" height="25">&nbsp;</td>
                    <td width="44%">�ύ�����ˣ�</td>
                  </tr>
              </table></td>
            </tr>
            <tr>
              <td height="25" colspan="3" valign="top"><p>&nbsp;��֤;�������̣� </p>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br>
                  <br></td>
            </tr>
            <tr>
              <td height="25" colspan="3" valign="top"><p>&nbsp;������ۣ� </p>
                  <br>
                  <br>
                  <br>
                  <br></td>
            </tr>
            <tr>
              <td height="25" colspan="3" valign="top"><p>&nbsp;��֤�����ϣ�ע���������� </p>
                  <br>
                  <br>
                  <br></td>
            </tr>
            <tr valign="middle">
              <td height="25" colspan="3"><p>&nbsp;ʵ�ʵ������������������������� </p></td>
            </tr>
            <tr valign="top">
              <td height="81" colspan="2"><p align="left">&nbsp;����鳬ʱ������д��ʱԭ�� </p>
                  <div align="left"><br>
                      <br> 
                </div></td>
              <td width="53%"><div align="left">&nbsp;����������</div></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td height="20" align=center style="font-family:����; font-size:10pt;"> <div align="left">�����ˣ� </div></td>
          <td height="20" align=center style="font-family:����; font-size:10pt;"> �ύ�������ڣ� </td>
          <td height="20" align=center style="font-family:����; font-size:10pt;"> &nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;�� </td>
        </tr>
</table>
<!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />
</body>
</html>
