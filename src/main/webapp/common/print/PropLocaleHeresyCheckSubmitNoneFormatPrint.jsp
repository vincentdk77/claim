<%--
****************************************************************************
* DESC       ���Ʋ����մ��鿱ί�����ӡҳ��
* AUTHOR     ��zhuly
* CREATEDATE ��2005-11-15
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
<%@include file="PropLocaleHeresyCheckSubmitNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>�Ʋ��մ��鿱ί�����ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <p align="center"><b>��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;ί&nbsp;��&nbsp;��</b></p>
        </td>
      </tr>
      <tr>
        <td align="right" colspan="2" style="font-family:����; font-size:10pt;">NO��<ins>&nbsp;<%=strRegistNo%>&nbsp;</ins></td>
      </tr>
    </table>  
   <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse"  bordercolor="#111111" style="font-family:����; font-size:10pt;">
   
  <tr>
    <td colspan="7" height="35"> <ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins>�ֹ�˾/֧��˾�� </td>
  </tr>
  <tr>
    <td width="38"  height="25">&nbsp;</td>
    <td colspan="6"><p>��˾�б��ı���ѳ��գ���ί�й�˾��Ϊ�����й��������ˡ� </p></td>
  </tr>
  <tr>
    <td   height="25">&nbsp;</td>
    <td colspan="6"><p>A. �б������յ������ </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td width="9">&nbsp;</td>
    <td colspan="2"> �����������ƣ� </td>
    <td colspan="2" id="tdInsuredName">&nbsp;</td>
    <td width="218">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> ������ƣ� </td>
    <td width="190" id="tdLossName">&nbsp;</td>
    <td width="87" > ���յ�ַ�� </td>
    <td id="tdDamageAddress">&nbsp;</td>
  </tr>
  <tr  height="25">
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> �������룺 </td>
    <td id="tdPolicyNo">&nbsp;</td>
    <td> ����ʱ�䣺 </td>
    <td id="tdDamageStartDate">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> ���ս� </td>
    <td id="tdSumAmount">&nbsp;</td>
    <td> �� ϵ �ˣ� </td>
    <td id="tdLinkerName">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td colspan="2"> �������ޣ� </td>
    <td id="tdDate">&nbsp;</td>
    <td> �绰����ַ�� </td>
    <td id="tdPhoneNumber">&nbsp;</td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td colspan="6"><p>B. ί�������Ҫί�еģ���� �� ���� </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td width="25">&nbsp;��</td>
    <td colspan="4"><p>�ֳ��鿱�����������Ҫԭ�򲢳����ֳ��鿱���档 </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"><p>���ŶԱ��ձ����ʧ�����ȷ����ʧ�� </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"><p>�ṩ�����ʧ��Ƭ���¹��ֳ���Ƭ�� </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"> ���ű��ձ���ڵ��ؽ����޸������۲��ռ�����Э���鼰��Ʊ�� </td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"> Э���������˶��������ʽ�����㡢ʩ�ȣ�����ʱ������Ĵ��� </td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"><p>Ҫ�󱻱������ṩ�붨�������й� �� ����������ӡ���� ���񱨱�����¼���豸��ᡢ�޸���Ʊ�����ϡ� </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"><p> �ṩ��Ҫ�󱻱�������д��˾����ڲ�ӡ�Ƶ�֤������˱�¼����ʧ�嵥�ȣ��������ռ��� </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;��</td>
    <td colspan="4"> �뽫�������Ϻ���Ƭ�ʼĻ��ɱ�������ת�����ҹ�˾�� </td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td colspan="6"><p>C �� ����������<ins>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</ins>��Ԫ��������֪ͨ��˾���õ��𸴺��������� </p></td>
  </tr>
  <tr>
    <td  height="25">&nbsp;</td>
    <td colspan="6"><p><br>�Թ�˾�Ĵ���Э�������л�⣡ </p></td>
  </tr>
  <tr>
    <td colspan="7" height="25">&nbsp;</td>
  </tr>
  <tr  >
    <td height="35">&nbsp;</td>
    <td colspan="3">��˾�绰��</td>
    <td><%=phoneNumber%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font align="right">���棺<%=faxNumber%></font></td>
    <td align="right">��ϵ�ˣ�<%=manager%></td>
    <td></td>
  </tr>
  <tr>
    <td height="35">&nbsp;</td>
    <td colspan="3">��&nbsp;&nbsp;ַ��</td>
    <td><%=addressCName%></td>
    <td align="right">��&nbsp;&nbsp;�ࣺ<%=postCode%></td>
    <td></td>
  </tr>
  <tr>
    <td colspan="7" height="30">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7" height="25" align="right"><%=comCName%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7" height="25" align="right">��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
   </table>
  	<!-- ��ť���� -->
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
