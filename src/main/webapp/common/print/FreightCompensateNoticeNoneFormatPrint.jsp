<%--

****************************************************************************

* DESC       ���������ⰸ�սᱨ�����嵥��ӡ

* AUTHOR     ��wangwei

* CREATEDATE ��2005-5-22

* MODIFYLIST ��   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>

<%@ page contentType="text/html; charset=GBK" %>



<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>



<%-- ��ʼ�� --%>

<%@include file="FreightCompensateNoticeNoneFormatPrintIni.jsp"%>



<html>

  <head>

    <title>�������ⰸ�սᱨ�����嵥��ӡ</title>

    <link rel="stylesheet" type="text/css" href="Standard.css">

    <jsp:include page="/common/pub/StaticJavascript.jsp" />

  </head>



  <body bgcolor="#FFFFFF" onload="loadForm();">

    <!-- ���ⲿ�� -->

    <form name="fm">

    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">

          <B>�������ⰸ�սᱨ����<B>

        </td>

      </tr>

    </table>                                                                                             ��������������������������������������������������������������������

  <strong><font size="2">������:<%= prpLclaimDto.getCaseNo() %></font></strong>

<table border=1 width="70%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">

  <tr>

    <td width="107">��������</td>

    <td width="152" id="tdInsuredName"><%= prpLclaimDto.getInsuredName() %></td>

    <td width="72" >�ܹ�˾����</td>

    <td width="182" >&nbsp;</td>

  </tr>

  <tr>

    <td>��������</td>

    <td>&nbsp;</td>

    <td >��������</td>

    <td id="tdPolicyNo"><%= prpLclaimDto.getPolicyNo() %></td>

  </tr>

  <tr>

    <td >���ս��</td>

    <td id="tdSumAmount"><%= prpLclaimDto.getSumAmount() %></td>

    <td>ԤԼЭ���</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >�б��ձ�</td>

    <td>&nbsp;</td>

    <td>������</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >��������</td>

    <td><%= strStartDate %></td>

    <td>���յص�</td>

    <td id="tdDamageAddress"><%= prpLclaimDto.getDamageAddress() %></td>

  </tr>

  <tr>

    <td>����ԭ��</td>

    <td id="tdDamageName"><%= prpLclaimDto.getDamageName() %></td>

    <td>���˹���</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >������</td>

    <td>&nbsp;</td>

    <td>�⸶���</td>

    <td>&nbsp;</td>

  </tr>

  <tr>

    <td >׷�ؽ��</td>

    <td>&nbsp;</td>

    <td>�᰸����</td>

    <td><%= strEndCaseDate %></td>

  </tr>

  <tr>

    <td >�ֱ�����</td>

    <td colspan="3">&nbsp;</td>

  </tr>

  <tr>

    <td >����������</td>

    <td colspan="3">&nbsp;</td>

  </tr>

  <tr>

    <td > <p>��������ʦ</p></td>

    <td colspan="3"> <p>&nbsp;</p></td>

  </tr>

  <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

    <tr>

    <td colspan="4" >&nbsp;</td>

  </tr>

</table>

</form>

 <!--include��ӡ��ť-->

    <jsp:include page="/common/print/PrintButton.jsp" />

  </body>

</html>

