<%--
****************************************************************************
* DESC       �������������վ���/ע������֪ͨ���ӡҳ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="DAAPressnoticeNoneFormatPrintIni.jsp"%>

<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                    
   <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="98%" align="center" cellspacing="0" cellpadding="0" border="0"> 
      <tr height="40">
        <td align="center"colspan="2" height="40" style="font-family:����; font-size:14pt;">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>     
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <B>�����������վ���/ע������֪ͨ��<B>
        </td>
      </tr>
      <tr height="30">
        <td align=left id="tdRegistNo" width="50%" style="font-family:����; font-size:10pt;">
          �����ţ�
        </td>
        <td align=left id="tdClaimNo" width="50%" style="font-family:����; font-size:10pt;">
          �����ţ�
        </td>
      </tr>      
    </table>
      
    <!-- ���岿�� -->
    <table border=1 width="98%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr height="25">
        <td colspan=1 width="15%" align="center">��������</td>
        <td colspan=2 id="tdInsuredName" width="45%" align="center">&nbsp;</td>
        <td width="10%" align="center">���յ���</td>
        <td colspan=2 id="tdPolicyNo" width="22%" align="center">&nbsp;</td>
      </tr>
      <tr height="25">
        <td width="15%" align="center">��������</td>
        <td colspan=2 id="tdInsuredDate" width="45%" align="center"></td>  
        <td width="10%" align="center">����ʱ��</td>
        <td colspan=2 id="tdDamageStartDate" width="22%" align="center">&nbsp;</td>        
      </tr>
      <tr height="25">
        <td colspan=1 width="15%" align="center">�����ձ���ʧ���</td>
        <td colspan=2  id="tdRiskNameAndEstimateLoss" width="45%" align="center">&nbsp;</td>
        <td colspan=1 width="10%" align="center">���ƺ���</td>
        <td colspan=2 id="tdLicenseNo" width="22%" align="center">&nbsp;</td>   
      </tr>     
      <tr height="170">
      <td colspan="6" valign=top id="tdDamageCause">
      ����ԭ��
      </td>
      </tr>
      <tr height="170">
      <td colspan="6" valign=top id="tdCancelReason">
      ����/ע�����ɣ�
      </td>
      </tr>      
      <tr height="170">
      <td colspan="6" valign=top>
      ����Ŀ¼��<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1��<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2��<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3��<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4��
      </td>
      </tr>    
      <tr height="140">
      <td colspan="2" valign=top >
      <br>
      �ر���ʾ��<br>
      &nbsp;&nbsp;&nbsp;&nbsp;���������������飬�ڽӵ���֪ͨ���ʮ�����ڣ��򱾹�˾�򱾹�˾�ϼ����ܲ���������渴�顣�������Զ���������<br><br><br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;��������ǩ�գ�
      <br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
      </td>
      <td colspan="4" valign=top>
      <br>
      &nbsp;����˾��ַ��<%=strCompanyAdd%><br><br>
      &nbsp;�������룺<%=strPostCode%><br><br>
      &nbsp;��ϵ�ˣ�<br><br>
      &nbsp;��ϵ�绰��<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����˸��£�<br>
      <br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  ��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
      </td>      
      </tr>
      </table>
             
      <!--
      <tr height="360">
        <td width="5%">
          ���չ�˾�ⰸע��֪ͨ
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
                    �ǳ��ź���֪ͨ����������û�а��ҹ�˾�Ĵ���֪ͨԼ�������ޣ��ṩ�᰸��Ҫ�����
�ز��ϣ��������������ϱ����¹ʣ��ѳ����涨���������ޡ����ݡ����շ������йط��ɷ�
��Ĺ涨����������Ȩ�Ѿ���ʧ��������ĳ������������ѱ�ע����ϣ���ܹ��õ�������⡣ 
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
          �������˽ӵ��ⰸע��֪ͨ��ǩ������
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
      </tr>-->
    </table>
    <table border="0">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;ע�������ɱ�������ǩ�ջ������ԹҺ����ʼġ��Һ����ʾֻ�ִ�������</td>
      </tr>      
    </table>
     
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
