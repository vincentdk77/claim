<%--
****************************************************************************
* DESC       �������������ս᰸�߸桢ע��֪ͨ���ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="DAAPressnoticeNoneFormatPrintIni.jsp"%>

<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                   

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height="40">
        <td colspan="2" height="40" align=top align=center style="font-family:����; font-size:14pt;">            
          <center><B>�����������ս᰸�߸�֪ͨ��<B></center>
        </td>
      </tr>
      <tr height="30">
        <td align=left id="tdCompany" width="50%" style="font-family:����; font-size:10pt;">
          ���λ��ǩ�£���
        </td>
        <td align=right id="tdClaimNo" width="50%" style="font-family:����; font-size:10pt;">
          ������ţ�
        </td>
      </tr>
    </table>
      
    <!-- ���岿�� -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td colspan=2 align="center" height="30" width="10%">��������</td>
        <td height="30" width="35%" id="tdInsuredName">&nbsp;</td>
        <td align="center" height="30" width="10%">���յ���</td>
        <td height="30" width="45%" id="tdPolicyNo">&nbsp;</td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="25">���ƺ���</td>
        <td height="30" id="tdLicenseNo">&nbsp;</td>
        <td align="center" height="30">�����ͺ�</td>
        <td height="30" id="tdBrandName">&nbsp;</td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="30">���ս��</td>
        <td height="30" id="tdSumAmount1">&nbsp;</td>
        <td align="center" height="30" rowSpan=2>�����ڼ�</td>
        <td height="30" rowSpan=2 id="tdInsuredDate"></td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="30">�����޶�</td>
        <td height="30" id="tdSumAmount2">&nbsp;</td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="30">��������</td>
        <td height="30" id="tdRiskName">&nbsp;</td>
        <td align="center" height="30">������</td>
        <td height="30" id="tdEstimateLoss"></td>
      </tr>
      <tr>
        <td colspan=2 align="center" height="30">����ʱ��</td>
        <td height="30" id="tdDamageStartDate">&nbsp;</td>
        <td align="center" height="30">���յص�</td>
        <td height="30" id="tdDamageAddress">&nbsp;</td>
      </tr>
      <tr height="360">
        <td width="5%">
          ���չ�˾�᰸���ϴ߸�֪ͨ
        </td>
        <td colspan=4>
          <table border=0 width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">  
            <tr>  
              <td colspan=2 id="tdInsuredName1">
                �������������ƣ���
              </td>
            </tr>
            <tr>
              <td colspan=2>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;
                            ���ݡ����շ������йط��ɷ���Ĺ涨���������������ı����¹ʼ��������������ޡ�
                        �����ڽӵ���֪ͨ��10���ڣ����콫�ҹ�˾��������������������֪����Ҫ����йز���
                        �ͽ��ҹ�˾�������ҹ�˾�����޷������⳥���ζ�ע���ð�������Ҳ����˶�ɥʧ����
                        ��Ȩ��������ϣ�����ڹ涨�������ڣ����쵽�ҹ�˾�������������� 
              </td>
            </tr>
            <tr>
              <td colspan=2>
                &nbsp;&nbsp;&nbsp;&nbsp;лл��������������<br>
                &nbsp;&nbsp;&nbsp;&nbsp;����
              </td>
            </tr>
            <tr>
              <td width="70%">&nbsp;</td>
              <td width="30%">
                �����ˣ�
              </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
            </tr>
          </table>          
        </td>
      </tr>
      <tr height="350">
        <td width="5%">
          �������˽ӵ��᰸�߸�֪ͨ��ǩ������
        </td>
        <td colspan=4>
          <table border=0 width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">  
            <tr height="80%">
              <td colspan=2>&nbsp;</td>
            </tr>
            <tr height="28%">
              <td width="70%">&nbsp;</td>
              <td width="30%">
                ��������ǩ�£�
              </td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
              </td>
            </tr>
          </table>          
        </td>
      </tr>
    </table>
     
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
