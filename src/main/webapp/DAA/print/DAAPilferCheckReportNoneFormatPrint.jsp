<%--
****************************************************************************
* DESC       ���������������ղ鿱�����ӡҳ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-07
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
   <%-- ��ʼ�� --%>
<%@include file="DAAPilferCheckReportNoneFormatPrintIni.jsp"%>

<html>
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <body bgcolor="#FFFFFF" >
    <!-- ���ⲿ�� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" align="center">
           <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height="40">
        <td colspan="2" align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>
          �����������յ����ղ鿱����<B>
          <table width="100%"  border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td>&nbsp;</td>
              <td height="25"><div align="right">�����ţ�<%=strRegistNo%></div></td>
            </tr>
          </table>          </td>
      </tr>
    </table>

    <!-- ���岿�� -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111">
      <tr>
        <td width="14%" height=24 colspan="1" align="center">��������</td>
        <td height=24 colspan="3" align="center"><%=strInsuredName%></td>
        <td width="10%" height=24 colspan="1" align="center">�����ͺ�</td>
        <td width="14%" height=24 colspan="1" align="center"><%=strBrandName%></td>
        <td width="10%" height=24 colspan="1" align="center">���ƺ���</td>
        <td height=24  colspan="2" align="center"><%=strLicenseNo%></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center">���յص�</td>
        <td height=25 colspan="3" align="center"><%=strDamageAddress%></td>
        <td height=25 colspan="1" align="center">����ʱ��</td>
        <td height=25 colspan="1" align="center"><%=strdamageStartDate%></td>
        <td height=25 colspan="1" align="center">ʹ������</td>
        <td height=25 colspan="2" align="center"><%=strUseNatureName%></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center">��ʻ֤��Ч��</td>
        <td height=25 colspan="3" align="center">&nbsp;</td>
        <td height=25 colspan="1" align="center">�鿱�ص�</td>
        <td height=25 colspan="4" align="center"><%=strCheckSite%></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center">��ʻ֤����</td>
        <td height=25 colspan="3" align="center"><%=strD2%></td>
        <td height=25 colspan="1" align="center">��ʻ֤��Ч��</td>
        <td height=25 colspan="4" align="center"><%=strD3%></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center">��ʻԱ����</td>
        <td width="16%" height=25 colspan="1" align="center"><%=strD1%></td>
        <td height=25 width="7%" colspan="1" align="center">�Ա�</td>
        <td width="10%" height=25 colspan="1" align="center">����&nbsp;��Ů</td>
        <td height=25 colspan="1" align="center">����״��</td>
        <td height=25 colspan="1" align="center">���ѻ� ������</td>
        <td height=25 colspan="1" align="center">ְҵ</td>
        <td height=25 colspan="2" align="center"><%=strBusinessName%></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center">����װ��</td>
        <td height=25 colspan="4" align="center">�����ӷ���װ�� ����е����װ�� ���޷���װ��</td>
        <td height=25 colspan="1" align="center">�̶�ͣ�ŵص�</td>
        <td height=25 colspan="1" align="center">���� ����</td>
        <td width="9%" height=25 colspan="1" align="center">������Ʊ�Ƿ�ʧ</td>
        <td width="10%" height=25 colspan="1" align="center">���� ����</td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center">��ʻ֤�Ƿ�ʧ</td>
        <td height=25 colspan="1" align="center">���� ����</td>
        <td height=25 colspan="2" align="center">���ӷ�֤�Ƿ�ʧ</td>
        <td height=25 colspan="1" align="center">���� ����</td>
        <td height=25 colspan="1" align="center">��Կ�׶�ʧ</td>
        <td height=25 colspan="3" align="center">���� ��һ�� ������ �����</td>
      </tr>
      <tr>
        <td height=25 colspan="9" align="left">�鿱����:</td>
      </tr>
      <tr>
       <td valign="top" rowspan=1 colspan=9 height=200>
         ���յز鿱���:<br><br>&nbsp;&nbsp;&nbsp;&nbsp;<%=tempContext%>
         <br><br><br><br><br><br><br>
         <table width="80%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111">
         <tr><td align="right">�鿱��: <%=strChecker%>&nbsp;&nbsp;�鿱ʱ�䣺<%=checkDate.getYear()%>��<%=checkDate.getMonth()%>��<%=checkDate.getDay()%>��</td></tr></table>
       </td>
      </tr>
      <tr>
       <td valign="top" rowspan=1 colspan=9 height=200>
         �����������˽�����:<br><br>&nbsp;&nbsp;&nbsp;&nbsp;<!--%=tempContext%-->
         <br><br><br><br><br><br><br>
<table width="80%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111">
         <tr><td align="right">�鿱��: <!--%=strChecker%-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�鿱ʱ�䣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp��&nbsp;&nbsp&nbsp&nbsp;��&nbsp;&nbsp&nbsp&nbsp;��</td></tr></table></td>
       </tr>
      <tr>
       <td valign="top" rowspan=1 colspan=9 height=200>
         �����ܲ��ŵ�������:<br>
         <br>&nbsp;&nbsp;&nbsp;&nbsp;<!--%=tempContext%-->
         <br><br><br><br><br><br><br>
<table width="80%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;" bordercolor="#111111">
         <tr><td align="right">�鿱��: <!--%=strChecker%-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�鿱ʱ�䣺&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp&nbsp��&nbsp;&nbsp&nbsp&nbsp;��&nbsp;&nbsp&nbsp&nbsp;��</td></tr></table></td>
       </tr>
      <tr style="display:none">
       <td valign="top" rowspan=1 colspan=3>
         ���ݲ鿱��������ж�,���������ڱ����¹��и���<br><br><br>
         ��ȫ������			������		��ͬ��			������			������		���޷��ж�
       </td>
      </tr>
      <tr style="display:none">
       <td valign="top" rowspan=1 colspan=6>
        �������ţ����ܺ���ӡճ������<br><br><br><br>
<br><br><br><br>
       </td>
      </tr>
     </table>
     <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse;font-family:����; font-size:10pt;display:none;" bordercolor="#111111">
      <tr>
        <td height=25 rowspan=12 colspan="1" width="2%">Ԥ����ʧ</td>
        <td height=25 colspan="1" align="center" width="8%">��ʧ��Ŀ</td>
        <td height=25 colspan="1"  align="center" width="18%">Ԥ����ʧ���</td>
        <td height=25 colspan="2" width="70%" bordercolor="#FFFFFF">&nbsp;&nbsp&nbsp�ֳ�ͼ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp����</td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center" width="8%">��������</td>
        <td height=25 colspan="1" align="center" width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center" width="8%">���߳���</td>
        <td height=25 colspan="1" align="center" width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1" align="center" width="8%">��������</td>
        <td height=25 colspan="1" align="center" width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1"  align="center"  width="8%">��������</td>
        <td height=25 colspan="1"  align="center" width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1"  align="center"  width="8%">ʩ�ȷ�</td>
        <td height=25 colspan="1" align="center"  width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1"  width="8%"></td>
        <td height=25 colspan="1" width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1"  width="8%"></td>
        <td height=25 colspan="1" width="18%"></td>
      </tr>
      <tr>
        <td height=25 colspan="1"  width="8%"></td>
        <td height=25 colspan="1" width="18%"></td>
        <td height=25 colspan="2"  width="70%" bordercolor="#FFFFFF">&nbsp;&nbsp&nbsp�鿱ʱ�䣺</td>
      </tr>
      <tr>
        <td height=25 colspan="1"  width="8%"></td>
        <td height=25 colspan="1" width="18%"></td>
        <td height=25 colspan="2"  width="70%" bordercolor="#FFFFFF">&nbsp;&nbsp&nbsp�鿱�ص㣺</td>
      </tr>
      <tr>
        <td height=25 colspan="1"  width="8%"></td>
        <td height=25 colspan="1" width="18%"></td>
        <td height=25 colspan="2"  width="70%" bordercolor="#FFFFFF">&nbsp;&nbsp&nbsp�鿱�ˣ�&nbsp;&nbsp&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp������ǩ�£�</td>
      </tr>
      <tr>
        <td height=25 colspan="1"  width="8%">�ϼƽ��</td>
        <td height=25 colspan="1" width="18%"></td>
        <td height=25 colspan="2"  width="70%" bordercolor="#FFFFFF">&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp��</td>
      </tr>
    </table>
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />

  </body>
</html>
