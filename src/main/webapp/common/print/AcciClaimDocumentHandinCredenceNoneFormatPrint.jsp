<%--
****************************************************************************
* DESC       �������������ļ�����ƾ֤��ӡ
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
<%@include file="AcciClaimDocumentHandinCredenceNoneFormatPrintIni.jsp"%>

<html>
<head>
<title>�����������ļ�����ƾ֤��ӡ</title>
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
          <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
            <B>�����������ļ�����ƾ֤<B>
          </td>
        </tr>
      </table>

<table border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#111111" style="border-collapse:collapse;font-family:����;font-size:10pt;">
  <tr valign="middle">
    <td height="25" colspan="8">
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr height="25">
          <td width="50%">&nbsp;������������ <span id="spAcciName"></span></td>
          <td width="50%">�����ţ� <span id="spPolicyNo">&nbsp;</span></td>
        </tr>
      </table></td>
  </tr>
  <tr valign="middle">
    <td height="25" colspan="8"><p> &nbsp;����˾�յ����������������ļ�������Ƕ��ļ���ʽ�ر�ע��������ʽ��Ϊԭ���� </p></td>
  </tr>
  <tr valign="middle">
    <td width="28%" height="25"><p align="center">�ļ�����</td>
    <td width="59" height="25"><p align="center">����</td>
    <td height="25" colspan="3"><p align="center">��ʽ��ע</td>
    <td width="172" height="25"><p align="center">�ļ�����</td>
    <td width="54" height="25"><p align="center">����</td>
    <td width="83" height="25"><p align="center">��ʽ��ע</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName1">&nbsp;1 ���յ�</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName16">&nbsp;16 ���������о��� </td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName2">&nbsp;2 ĩ�κͳ��յ��ڱ����վ� </td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName17">&nbsp;17 ����ע��֤�� </td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName3">&nbsp;3 �¹������֤�� </td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName18">&nbsp;18 ɥ��֤�� </td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName4">&nbsp;4 ���������֤��</td>
    <td width="59" height="20">&nbsp;&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName19">&nbsp;19 �м�����֤��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName5">&nbsp;5 ���������¹��߹�ϵ֤�� </td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName20">&nbsp;20 Ӱ���鱨����</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName6">&nbsp;6 �̳������֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName21">&nbsp;21 ҽ�����֤����</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName7">&nbsp;7 �̳������¹��߹�ϵ֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName22">&nbsp;22 ����</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName8">&nbsp;8 �Ų��̳��ļ�</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName23">&nbsp;23 ����</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName9">&nbsp;9 ����ί����</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName24">&nbsp;24 ������鱨��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName10">&nbsp;10 ���������֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName25">&nbsp;25 ѪҺ���鱨��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName11">&nbsp;11 �໤�����֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName26">&nbsp;26 ����֤��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName12">&nbsp;12 �����¹�֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName27">&nbsp;27 סԺҽ��֤��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName13">&nbsp;13 ����ҽѧ����֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName28">&nbsp;28 ҽ�Ʒ�ƾ֤���վݣ�<br>
    &nbsp;Ʊ���</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName14">&nbsp;14 ʬ�����֤��</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td width="172" height="20" id="tdTypeName29">&nbsp;29 ҽ�Ʒѽ������ϸ��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td width="186" height="20" id="tdTypeName15">&nbsp;15 ��������֤����</td>
    <td width="59" height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;&nbsp;</td>
    <td width="172" height="20" id="tdTypeName30">&nbsp;30 סԺ����֤��</td>
    <td width="54" height="20">&nbsp;</td>
    <td width="83" height="20">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td height="20" id="tdTypeName31">&nbsp;</td>
    <td height="20">&nbsp;</td>
    <td height="20" colspan="3">&nbsp;</td>
    <td height="20" id="tdTypeName32">&nbsp;����</td>
    <td height="20">&nbsp;</td>
    <td height="20">&nbsp;</td>
  </tr>
  
  <tr valign="middle">
    <td height="20" colspan="8">
      <table width="100%"  border="0" cellspacing="0" cellpadding="0">
        <tr valign="middle">
          <td width="37%"><div align="left">&nbsp;����<span id="spIntSize">&nbsp;</span>��� ��ҳ</div></td>
          <td width="18%"><div align="right">ǩ���ˣ�</div></td>
          <td width="45%">
          <div align="right">ǩ�����ڣ�&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;</div></td>
        </tr>
      </table>
      
  </tr>
  <tr valign="middle">
    <td height="20" colspan="8"><p>&nbsp;���貹���ṩ��֤�����ϣ� </p></td>
  </tr>
  <tr valign="middle">
    <td height="20" colspan="3">&nbsp;</td>
    <td height="20" colspan="5">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td height="20" colspan="3">&nbsp;</td>
    <td height="20" colspan="5">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td height="20" colspan="3">&nbsp;</td>
    <td height="20" colspan="5">&nbsp;</td>
  </tr>
  <tr valign="middle">
    <td height="20" colspan="8"><p align="right">ǩ���ˣ�&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ǩ�����ڣ�&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;</p></td>
  </tr>
  <tr>
    <td colspan="4" valign="top">        <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="25" colspan="2">&nbsp;�������֪ͨ��ǩ������ </td>
          </tr>
          <tr>
            <td height="120" colspan="2">&nbsp;</td>
          </tr>
          <tr>
            <td height="25"><div align="left">&nbsp;ǩ���ˣ�</div></td>
            <td><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;</div></td>
          </tr>
        </table>        
    </td>
    <td colspan="4" valign="top">
        <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="25" colspan="2">&nbsp;�����ļ��˼�ǩ������</td>
          </tr>
          <tr>
            <td height="40" colspan="2" valign="top">&nbsp;1��</td>
          </tr>
          <tr>
            <td height="40" colspan="2" valign="top">&nbsp;2��</td>
          </tr>
          <tr>
            <td height="40" colspan="2" valign="top">&nbsp;3��</td>
          </tr>
          <tr>
            <td height="25"><div align="left">&nbsp;ǩ���ˣ�</div></td>
            <td><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;</div></td>
          </tr>
        </table></td>
  </tr>
</table>
<table width="645" border="0" align="center" cellpadding="0" cellspacing="0" style="font-family:����;font-size:10pt; ">
  <tr>
    <td colspan="3"><p>˵���� </p>    </td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;1��������ƾ֤ϵ����˾�յ������ļ���ƾ֤��������ƾ֤һʽ���ݣ����չ�˾�Ϳͻ���ִһ�ݡ� </td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;2��������Ӧ��&nbsp;5���ڽ�Ҫ�󲹽���֤���ļ��ύ����˾������Ա������������ṩ���ļ����ϲ�ȫ�����²����������˼��� </td>
  </tr>
  <tr>
    <td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;3�������������Ʊ��汾����ƾ֤���᰸ʱ�����ڡ��������֪ͨ�顱���������ļ��˼���ǩ������ǩ�պ��Դ�ƾ֤���ؿ��˻����������ļ�֮ԭʼ���ݡ� </td>
  </tr>
  <tr>
    <td width="430">&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td width="190"><div align="right"> �Ʋ����չɷ����޹�˾</div></td>
    <td width="25">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td><div align="center">������ҵ���£�</div></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
    <td><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;�� </div></td>
    <td>&nbsp;</td>
  </tr>
</table>
<!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />
</body>
</html>
