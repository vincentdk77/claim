<%--
****************************************************************************
* DESC       �������ղ鿱�����嵥��ӡ
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-22
* MODIFYLIST ��   id       Date            Reason/Contents
    �����ӡ���ã���
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.util.*"%>

<%-- ��ʼ�� --%>
<%@include file="FreightCheckReportNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>�����ղ鿱�����嵥��ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF">
    <!-- ���ⲿ�� -->

    <table width="80%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr>
        <td colspan="2" height="40" align="center">
          <Img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>�� �� �� �� �� �� ��<B>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="15" align=right>
          <font style=" font-family:����; font-size:10pt;"> &nbsp;&nbsp;������:<%=strRegistNo%></font>
        </td>
      </tr>
    </table>
    <table border="1" width="88%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111" >
<tr>
    <td width="87" height="25"> &nbsp;&nbsp;�������� </td>
    <td width="199">&nbsp;<%=strInsuredName%></td>
    <td width="80"> &nbsp;&nbsp;�������� </td>
    <td width="206">&nbsp;<%=strAppliName%></td>
  </tr>
  <tr>
    <td  height="25"> &nbsp;&nbsp;���յ��� </td>
    <td>&nbsp;<%=strPolicyNo%></td>
    <td> &nbsp;&nbsp;������ </td>
    <td>&nbsp;<%=strEndorseNo%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; ���յص� </td>
    <td>&nbsp;<%=strCheckSite%></td>
    <td>&nbsp;&nbsp; ����ԭ�� </td>
    <td>&nbsp;<%=strDamageName%></td>
  </tr>
  <tr>
    <td height="25"> &nbsp;&nbsp;�������� </td>
    <td>&nbsp;<%=strValue1%></td>
    <td> &nbsp;&nbsp;������ </td>
    <td>&nbsp;<%=strEstimateLoss%></td>
  </tr>
  <tr>
    <td height="25"> &nbsp;&nbsp;����ʱ�� </td>
    <td>&nbsp;<%=strReportDate%></td>
    <td> &nbsp;&nbsp;����ʱ�� </td>
    <td>&nbsp;<%=strDamageStartDate%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; ���䷽ʽ </td>
    <td>&nbsp;<%=strConveyance%></td>
    <td>&nbsp;&nbsp; ���乤�� </td>
    <td>&nbsp;<%=strBLName%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; ����·�� </td>
    <td>&nbsp;<%=strTPath%></td>
    <td>&nbsp;&nbsp; �������� </td>
    <td>&nbsp;<%=strCheckDate%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; �ᵥ/�˵� </td>
    <td>&nbsp;<%=strLadingNo%></td>
    <td>&nbsp;&nbsp; �б���˾ </td>
    <td>&nbsp;<%=strComCName%></td>
  </tr>
  <tr>
    <td height="25">&nbsp;&nbsp; ��ϵ�� </td>
    <td>&nbsp;<%=strLinkerName%></td>
    <td>&nbsp;&nbsp; ��ϵ��ʽ </td>
    <td>&nbsp;<%=strPhoneNumber%></td>
  </tr>
  <tr>
    <td colspan="4" height="400" valign="top"><p>����д��������ԭ�򡢾����Լ���ʧ�������������ȫ����ʧ����д�鿱������� </p>
	<%=strContext%>
	</td>
  </tr>
  <tr>
    <td colspan="4" height="60"><p>&nbsp;�鿱ʱ�䣺<%=CheckDate%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�鿱�ص㣺<%=CheckSite%> </p>
      <p>&nbsp; </p>
    &nbsp;�鿱�ˣ�<%=strChecker1%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ������ǩ���� &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp; ��&nbsp;&nbsp; ��<br> <br></td>
  </tr>
    </table>
   <!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />
  </body>
</html>
