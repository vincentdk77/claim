<%--
****************************************************************************
* DESC       �������������վ��ⰸ���������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

  <%-- ��ʼ�� --%>
  <%@include file="DAACanceltransNoneFormatPrintIni.jsp"%>
  
<html>                                                                                 
  <head>                                                                               
    <title>�����������վ��ⰸ���������ӡ</title>      
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">       
  </head>                                                                              

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top align=center style="font-family:����; font-size:14pt;">            
          <center><B>�����������վ��ⰸ��������<B></center>
        </td>
      </tr>
      <tr>
        <td align=left id="tdCompany" width="50%" style="font-family:����; font-size:10pt;">
          ���λ��ǩ�£���
        </td>
        <td align=right id="tdClaimNo" width="50%" style="font-family:����; font-size:10pt;">
          ������ţ�
        </td>
      </tr>
    </table>
      <br>
    <!-- ���岿�� -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td align="center" height="28" width="10%">��������</td>
        <td height="28" width="35%" id="tdInsuredName">&nbsp;</td>
        <td align="center" height="28" width="10%">���յ���</td>
        <td height="28" width="45%" id="tdPolicyNo">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="25">���ƺ���</td>
        <td height="28" id="tdLicenseNo">&nbsp;</td>
        <td align="center" height="28">�����ͺ�</td>
        <td height="28" id="tdBrandName">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="28">���ս��</td>
        <td height="28" id="tdSumAmount1">&nbsp;</td>
        <td align="center" height="28" rowSpan=2>�����ڼ�</td>
        <td height="28" rowSpan=2 id="tdInsuredDate"></td>
      </tr>
      <tr>
        <td align="center" height="28">�����޶�</td>
        <td height="28" id="tdSumAmount2">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="28">��������</td>
        <td height="28" id="tdRiskName">&nbsp;</td>
        <td align="center" height="28">������</td>
        <td height="28" colSpan=2 id="tdEstimateLoss">&nbsp;</td>
      </tr>
      <tr>
        <td align="center" height="28">����ʱ��</td>
        <td height="28" id="tdDamageStartDate">&nbsp;</td>
        <td align="center" align="center" height="28">���յص�</td>
        <td height="28" id="tdDamageAddress">&nbsp;</td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=4 id="tdContext">&nbsp;</td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=4>&nbsp;���������������ӳ��</td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=4>
        
          <table width="100%" height="100%" border=0 style="font-family:����; font-size:10pt;">
            <tr height="80%">
              <td valign="top" colspan="4">&nbsp;ע����������⳥�����</td>
            </tr>          
            <tr height="10%">
              <td>����ǩ�֣�</td>
              <td>����ǩ�֣�</td>
              <td>����ʦǩ�֣�</td>
              <td>������ǩ�֣�</td>
            </tr>
            <tr height="10%">
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
            </tr>
          </table>
                  
        </td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=4>
        
          <table width="100%" height="100%" border=0 style="font-family:����; font-size:10pt;">
            <tr height="80%">
              <td valign="top" colspan="4">&nbsp;�ϼ���˾��������</td>
            </tr>         
            <tr height="10%">
              <td>�����ܣ���������ǩ�֣�</td>
              <td>���ɲ��Ÿ�����ǩ�֣�</td>
              <td>ҵ���Ÿ�����ǩ�֣�</td>
              <td>������ǩ�֣�</td>
            </tr>
            <tr height="10%">
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
              <td>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
            </tr>
          </table>
                  
        </td>
      </tr>
    </table>
     
    <!-- ��β���� --> 
         
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td width="50%" height="20" valign="bottom" colspan=2 id="tdUserName">��ˣ�</td>
        <td width="50%" height="20" valign="bottom" colspan=2 align="right" id="tdInputDate">�ʱ�䣺</td>
      </tr>
    </table>
    
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
