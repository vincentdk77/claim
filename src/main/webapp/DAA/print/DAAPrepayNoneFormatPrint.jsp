<%--
****************************************************************************
* DESC       ��������������Ԥ������������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16 
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="DAAPrepayNoneFormatPrintIni.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>                                                                                  
  <head>                                                                               
    <title>������������Ԥ������������ӡ</title>      
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">        
  </head>                                                                              

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top  style=" font-family:����; font-size:14pt;">            
          <B>������������Ԥ�����������<B>
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
      
    <!-- ���岿�� -->
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td align="center" colspan="1" height="28" width="10%">��������</td>
        <td height="28" colspan="4" width="40%" id="tdInsuredName">&nbsp;</td>
        <td align="center" colspan="1" height="28" width="10%">���յ���</td>
        <td height="28" colspan="3" width="30%" id="tdPolicyNo">&nbsp;</td>
      </tr>
      <tr>
	    <td align="center" colspan="1" height="28" width="10%">�����ͺ�</td>
        <td height="28" colspan="2" width="20%" id="tdBrandName">&nbsp;</td>
        <td align="center" colspan="1" height="25" width="10%">���ƺ���</td>
        <td height="28" colspan="2" width="20%" id="tdLicenseNo">&nbsp;</td>
        <td align="center" colspan="1" height="28" width="10%">���ս��</td>
        <td height="28" colspan="2" width="30%" id="tdSumAmount">&nbsp;</td>
      </tr>
      <tr>
	    <td align="center" colspan="1" height="28">����ʱ��</td>
        <td height="28" colspan="2" id="tdDamageStartDate">&nbsp;</td>
		<td align="center" colspan="1" height="28">��������</td>
        <td height="28" colspan="2" id="tdRiskName">&nbsp;</td>
		<td align="center" colspan="1" height="28">���յص�</td>
        <td height="28" colspan="2" id="tdDamageAddress">&nbsp;</td>  
      </tr>
      <tr>
        <td align="center" height="28" >�����ڼ�</td>
        <td height="28" colspan="4" id="tdInsuredDate"></td>
        <td align="center" height="28">������</td>
        <td height="28"colspan="3" id="tdEstimateLoss">&nbsp;</td>
      </tr>
      <tr>
        <td align="left" height="28" colSpan=9 id="tdSumPrePaid">&nbsp;Ԥ��������д����ң���</td>
      </tr>
      <tr>
        <td height="160" valign=top colSpan=9>&nbsp;�¹ʸſ���</td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=9>
        
          <table width="100%" height="100%" border=0 style="font-family:����; font-size:10pt;">
            <tr height="70%">
              <td valign="top" colspan="5">&nbsp;Ԥ��ԭ��</td>
            </tr>          
           
          </table>
                  
        </td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=9>
        
          <table width="100%" height="100%" border=0 style="font-family:����; font-size:10pt;">
            <tr height="70%">
              <td valign="top" colspan="5">&nbsp;�������������</td>
            </tr>          
            <tr height="20%">
              <td width="60%">&nbsp;</td>
              <td align="left" width="40%">����������</td>
            </tr>
            <tr height="10%">
              <td>&nbsp</td>
              <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��</td>
            </tr>
          </table>
                  
        </td>
      </tr>
      <tr>
        <td height="160" valign="top" colSpan=9>
        
          <table width="100%" height="100%" border=0 style="font-family:����; font-size:10pt;">
            <tr height="70%">
              <td valign="top" colspan="5">&nbsp;�������������</td>
            </tr>          
            <tr height="20%">
              <td width="60%">&nbsp;</td>
              <td align="left" width="40%">�������������Ȩ�ˣ�</td>
            </tr>
            <tr height="10%">
              <td>&nbsp</td>
              <td align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��</td>
            </tr>
          </table>
                  
        </td>
      </tr>
    </table>
     
    <!-- ��β���� -->      
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td width="50%" height="20" valign="bottom" colspan=5 id="tdUserName">��ˣ�</td>
        <td width="50%" height="20" valign="bottom" colspan=4 align="right" id="tdInputDate">�ʱ�䣺</td>
      </tr>
    </table>
    
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>

