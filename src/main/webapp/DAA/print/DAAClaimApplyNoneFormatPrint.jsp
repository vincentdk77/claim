<%--
****************************************************************************
* DESC       ������������������������ҳ��
* AUTHOR     ��caopeng
* CREATEDATE ��2005-12-06
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
<%@include file="DAAClaimApplyNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>�����������������������ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
   <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF">
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
    </tr>
    <tr>
      <td colspan="2" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;"> <strong><B>����������������������<B> </b></b></strong></td>
    </tr>
  </table>
  <table width="92%"  border="1" align="center" cellspacing="0" cellpadding="2" bordercolor="#111111" style="border-collapse:collapse; font-family:����; font-size:10pt">
    <tr>
      <td width="14%" height="25" align="center">��������</td>
      <td height="25" colspan="5"><div align="center"><%=strInsuredName%></div></td>
      <td width="14%" height="25" align="center">��������</td>
      <td width="34%" height="25"><div align="center"><%=strPolicyNo%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">�����ͺ�</td>
      <td height="25" colspan="5"><div align="center"><%=strBrandName%></div></td>
      <td height="25" align="center">���ƺ���</td>
      <td height="25"><div align="center"><%=strLicenseNo%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">����ʱ��</td>
      <td height="25" colspan="5"><div align="center"><%=strdamageStartDate%>&nbsp;&nbsp;<%=strdamageStartHour%></div></td>
      <td height="25" align="center">���յص�</td>
      <td height="25"><div align="center"><%=strDamageAddress%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">��ʻԱ����</td>
      <td width="15%" height="25"><div align="center"><%=strD1%></div></td>
      <td width="6%">�Ա�</td>
      <td width="6%"><div align="center"><%=strSexName%></div></td>
      <td width="6%">����</td>
      <td width="5%"><div align="center"><%=strD3%></div></td>
      <td height="25" align="center">��ʻԱ����</td>
      <td height="25"><div align="center"><%=strD2%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">��������</td>
      <td height="25" colspan="7"><!--�������¹�&nbsp;&nbsp;&nbsp;&nbsp;���෽�¹�&nbsp;&nbsp;&nbsp;&nbsp;���෽�¹�&nbsp;&nbsp;&nbsp;������-->
        <div align="left">&nbsp;&nbsp;<%=strDamageTypeName%></div></td>
    </tr>
    <tr>
      <td height="25" align="center">����ԭ��</td>
      <td height="25" colspan="7"><!--<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>����ײ</td>
            <td>���㸲</td>
            <td>������</td>
            <td>������</td>
            <td>����ը</td>
            <td>��̨��</td>
            <td>����ȼ</td>
            <td>������</td>
            <td>������</td>
          </tr>
      </table>-->
        <div align="left">&nbsp;&nbsp;<%=strDamageClause%></div></td>
    </tr>
    <tr>
      <td height="349" colspan="8">
        <table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0" style="font-family:����; font-size:10pt">
          <tr>
            <td height="13">&nbsp;���վ���</td>
          </tr>
          <tr>
            <td height="396" valign="top"><br>&nbsp;&nbsp;&nbsp;&nbsp;<%=tempContext%>
         <br><br><br></td>
          </tr>
      </table></td>
    </tr>
    <tr>
      <td height="132" colspan="8"><table width="100%" height="100%"  border="0" cellspacing="0" style="font-family:����; font-size:10pt ">
          <tr>
            <td height="43" colspan="5">&nbsp;&nbsp;&nbsp;&nbsp; ���������������������Ͼ�Ϊ��ʵ���������Ը�������յ�֮һ��Ȩ�����е���Ӧ�ķ������Ρ�</td>
          </tr>
          <tr>
            <td height="61" colspan="5">&nbsp;</td>
          </tr>
          <tr>
            <td width="28%" height="22">&nbsp;�������ˣ������ˣ�ǩ�£�</td>
            <td width="12%">&nbsp;</td>
            <td width="16%">��ϵ�绰��</td>
            <td width="18%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="26%"><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</div></td>
          </tr>
      </table></td>
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
