<%--
****************************************************************************
* DESC       ��Ԥ��ͨ�������������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��22004-11-16
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
  <%@include file="DAAPrepareIndemnityExamineCardNoneFormatPrintIni.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Ԥ��ͨ�����������</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body>
<table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
  <tr height=30>
    <td colspan="2" align="center" class="style2"> <img src="/claim/images/LOGO.jpg"/> </td>
  </tr>
  <tr height=30>
    <td height="35" colspan="2" align=center valign="middle" style="font-family:����; font-size:14pt;">
      <center>
        <p><span class="style6"><strong>Ԥ �� /ͨ�� �� �� �� �� �� </strong> </span></p>
    </center></td>
  </tr>
  <tr height=30>
    <td width="52%" height="22" align=left valign="bottom" style="font-family:����; font-size:10pt;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�б��ձ�<%=strRiskName%></td>
    <td width="48%" align=left valign="bottom" style="font-family:����; font-size:10pt;">�ⰸ��ţ� <%=strClaimNo%></td>
  </tr>
  <tr height=30>
    <td colspan="2" align=center valign="top" style="font-family:����; font-size:10pt;">      <table width="88%" border="1" cellpadding="0" cellspacing="0" bordercolor="111111" style="border-collapse:collapse ">
        <tr>
          <td height="25" colspan="2"><div align="center"> �������� </div></td>
          <td width="32%"><div align="center"><%=strPolicyNo%></div></td>
          <td width="14%" height="25"><div align="center"> �������� </div></td>
          <td width="34%"><div align="center"><%=strInsuredName%></div></td>
        </tr>
        <tr>
          <td height="25" colspan="2"><div align="center"> �������� </div></td>
          <td><div align="center"><%=strInsuredDate%></div></td>
          <td height="25"><div align="center"> ���ս�� </div></td>
          <td><div align="center"><%=strSumAmount%></div></td>
        </tr>
        <tr>
          <td height="25" colspan="2"><div align="center"> �������� </div></td>
          <td><div align="center"><%=strDamageStartDate%></div></td>
          <td height="25"><div align="center"> ������ </div></td>
          <td><div align="center"><%=strSumClaim%></div></td>
        </tr>
        <tr>
          <td height="25" colspan="2"><div align="center"> ����ԭ�� </div></td>
          <td><div align="center"><%=strDamageName%></div></td>
          <td height="25"><div align="center"> Ԥ����� </div></td>
          <td><div align="center"><%=strSumThisPaid%></div></td>
        </tr>
        <tr>
          <td width="12%" height="250" valign="middle"><p align="center">�� </p>
            <p align="center">�� </p>
            <p align="center">�� </p>
          <p align="center">�� </p>            <p></p></td>
		  <td colspan="4" valign="top"><table width="99%" height="132"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="225" colspan="4">&nbsp;</td>
            </tr>
            <tr>
              <td width="50%" height="25"><div align="right">ǩ�£�</div></td>
              <td width="23%" height="25">&nbsp;</td>
              <td width="10%" height="25">���ڣ�</td>
              <td width="17%" height="25">&nbsp;</td>
            </tr>
          </table>		        </td></tr>
		  <tr>
          <td width="12%" height="131"><p align="center">�ֹ�˾��</p>
            <p align="center">�������</p>
            <p></p></td>
		  <td colspan="4" valign="top"><table width="99%" height="132"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="106" colspan="4"><p>&nbsp;</p>
                <p>&nbsp;</p></td>
            </tr>
            <tr>
              <td width="50%" height="25"><div align="right">ǩ�£�</div></td>
              <td width="23%" height="25">&nbsp;</td>
              <td width="10%" height="25">���ڣ�</td>
              <td width="17%" height="25">&nbsp;</td>
            </tr>
          </table>		        </td></tr>
		  <tr>
          <td width="12%" height="131"><p align="center">�ܹ�˾��</p>
            <p align="center">��������</p>
            <p align="center">��� </p>
            <p></p></td>
		  <td colspan="4" valign="top"><table width="99%" height="132"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="106" colspan="4"><p>&nbsp;</p>
                <p>&nbsp;</p></td>
            </tr>
            <tr>
              <td width="50%" height="25"><div align="right">ǩ�£�</div></td>
              <td width="23%" height="25">&nbsp;</td>
              <td width="10%" height="25">���ڣ�</td>
              <td width="17%" height="25">&nbsp;</td>
            </tr>
          </table>		        </td></tr>
		  <tr>
          <td width="12%" height="131"><p align="center">�ܹ�˾��</p>
            <p align="center">ϯ������</p>
            <p align="center">��� </p>
            <p></p></td>
		  <td colspan="4" valign="top"><table width="99%" height="132"  border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td height="106" colspan="4"><p>&nbsp;</p>
                <p>&nbsp;</p></td>
            </tr>
            <tr>
              <td width="50%" height="25"><div align="right">ǩ�£�</div></td>
              <td width="23%" height="25">&nbsp;</td>
              <td width="10%" height="25">���ڣ�</td>
              <td width="17%" height="25">&nbsp;</td>
            </tr>
          </table>		        </td></tr>
        
    </table></td>
  </tr>
</table>
<jsp:include page="/common/print/PrintButton.jsp" />      
      <%--<jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
</body>
</html>
