<%--

****************************************************************************

* DESC       ���⽡�վ���֪ͨ��

* AUTHOR     ��luqin

* CREATEDATE ��2005-06-19

* MODIFYLIST ��   Name       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************

--%>

<%@ page contentType="text/html; charset=GBK" %>

<%-- ��ʼ�� --%>

<%@include file = "AcciCancelNoticeNoneFormatPrintIni.jsp" %>

<html>

<body onload="loadForm();">



<p>��</p>

<div align="center">

  <center>

  <table border="0" cellpadding="0" cellspacing="0" width="92%">

    <tr>

      <td width="100%">

        <p align="center"><b><font size="6">����֪ͨ��</font></b></p>

        <p>��</p>

        <div align="center">

          <center>

          <table border="0" cellpadding="0" cellspacing="0" width="92%" height="46">

            <tr>

              <td width="33%" height="46"></td>

              <td width="33%" height="46"></td>

              <td width="34%" height="46" id="tdClaimNo"></td>

            </tr>

          </table>

          </center>

        </div>

        <p>&nbsp;&nbsp;&nbsp; 

        ���пͻ���������<ins><%=strInsuredName%></ins>&nbsp;&nbsp;���֤�ţ�<ins><%=strIdentifyNumber%></ins>����<ins><%=strDamageName%></ins>������������룬������˾��ˣ������ڱ����պ�ͬ���Ρ�</p>

        <p>��</p>

        <p>��</p>

        <p>�˸�</p>

        <p>��</p>

        <p>&nbsp;&nbsp; </p>

        <div align="center">

          <center>

          <table border="0" cellpadding="0" cellspacing="0" width="92%" height="46">

            <tr>

              <td width="33%" height="46" id="tdHandlerName"></td>

              <td width="33%" height="46">ǩ���ˣ�</td>

              <td width="34%" height="46"></td>

            </tr>

          </table>

          </center>

        </div>

        <p></p>

        <p></p>

        <p>&nbsp;&nbsp;&nbsp;&nbsp; </p>

        <div align="center">

          <center>

          <table border="0" cellpadding="0" cellspacing="0" width="92%" height="86">

            <tr>

              <td width="50%" height="44"></td>

              <td width="50%" height="44">��λǩ��</td>

            </tr>

            <tr>

              <td width="50%" height="42"></td>

              <td width="50%" height="42"><%=strDate%></td>

            </tr>

          </table>

          </center>

        </div>

      </td>

    </tr>

  </table>

  </center>

</div>

</body>



</html>