<%--
****************************************************************************
* DESC       �������ձ��վ���/ע������֪ͨ���ӡҳ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-14
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%> 
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="ClaimRefuseNoticeNoneFormatPrintIni.jsp"%>
 
<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                    

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ��һ������ --> 
    <!-- ���ⲿ�� --> 
    </br></br>
    <table width="85%" align="center"><tr><td width="99%">
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height="42">
        <td colspan="2" height="42" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      </br></br>
      <tr height="40">
        <td colspan="2" id="tdTitleName" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <B>���վ���(ע��)����֪ͨ��<B>
        </td>
      </tr>
     
    </table>
      
    <!-- ���岿�� -->

	<table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr height="42">
        <td colspan=1 width="12%" align="center">��������</td>
        <td colspan=2 id="tdInsuredName" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">��������</td>
        <td colspan=2 id="tdRegistNo" width="34%"align="center">&nbsp;</td>
      </tr>
      <tr height="42">
        <td colspan=1 width="12%"align="center">��ĵ�ַ</td>
        <td colspan=2 id="tdDamageAddress" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">������</td>
        <td colspan=2 id="tdSumAmount" width="34%"align="center">&nbsp;</td>
      </tr> 
      <tr height="42">
        <td colspan=1 width="12%"align="center">��������</td>
        <td colspan=2 id="tdPolicyNo" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">�����ڼ�</td>
        <td colspan=2 id="tdInsuredDate" width="34%"align="center">&nbsp;</td>
      </tr>              
      <tr height="42">
        <td width="12%"align="center">����ʱ��</td>
        <td colspan=2 id="tdDamageStartDate" width="34%"align="center"></td>  
        <td width="12%"align="center">����ԭ��</td>
        <td colspan=2 id="tdDamageCause" width="34%"align="center">&nbsp;</td>        
      </tr>

      <tr height="200">
      <td colspan="7" valign=top id="tdDamageProcess">
      ���վ�����
      </td>
      </tr>
      <tr height="200">
      <td colspan="7" valign=top id="tdCancelReason">
      ����(ע��)���ɣ�
      </td>
      </tr>      
      <tr height="140">
      <td colspan="3" valign=top width="46%">
          <br><br>&nbsp;&nbsp;&nbsp;&nbsp;���������������飬�ڽӵ���֪ͨ��ʮ�����ڣ��򱾹�˾�򱾹�˾�ϼ�����������顣����ʮ���첻�������ģ����Զ�������<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������ǩ�֣�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;ũ���ܾ����ܵ���ǩ�ֵģ������������ɲ�ǩ�֡�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ǩ���ˣ�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
      

	  </td>
      <td colspan="4" valign=top><br><br><br>
      
      ����˾��ַ��</br>&nbsp;&nbsp;&nbsp;&nbsp;<%=addressCName%><br><br>
      �������룺<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=postCode%><br><br>
      ��ϵ�绰��<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=phoneNumber%><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����˸��£�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=new SimpleDateFormat("yyyy �� MM �� dd ��").format(new Date())%>
      </td>      
      </tr>
            
    </table>
    <table border="0"style="font-family:����; font-size:10pt;">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;ע����ִ���뵵����</td>
      </tr>      
    </table>
        </td>
		<td width="1%" style="font-family:����; font-size:10pt;"><br><br><br><br><br>��<br>˾<br>ͳ<br>һ<br>��<br>��<br>��<br>��<br>��<br>��<br>:<br>9<br>6<br>9<br>9<br>9<br><br><br><br><br><br><br>��<br>һ<br>��<br>:<br>��<br>��<br>��<br>˾<br>��<br>��<br>��</td>
      </tr>      
    </table>
    
    <p style="page-break-after:always"></p>
    
     <!-- �����ڶ��� -->
     </br></br>
     <table width="85%" align="center"><tr><td width="99%">
     <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height="42">
        <td colspan="2" height="42" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      </br></br>
      <tr height="40">
        <td colspan="2" id="tdTitleName2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <B>���վ���(ע��)����֪ͨ��<B>
        </td>
      </tr>
     
    </table>
      
    <!-- ���岿�� -->

	<table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr height="42">
        <td colspan=1 width="12%" align="center">��������</td>
        <td colspan=2 id="tdInsuredName2" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">��������</td>
        <td colspan=2 id="tdRegistNo2" width="34%"align="center">&nbsp;</td>
      </tr>
      <tr height="42">
        <td colspan=1 width="12%"align="center">��ĵ�ַ</td>
        <td colspan=2 id="tdDamageAddress2" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">������</td>
        <td colspan=2 id="tdSumAmount2" width="34%"align="center">&nbsp;</td>
      </tr> 
      <tr height="42">
        <td colspan=1 width="12%"align="center">��������</td>
        <td colspan=2 id="tdPolicyNo2" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">�����ڼ�</td>
        <td colspan=2 id="tdInsuredDate2" width="34%"align="center">&nbsp;</td>
      </tr>              
      <tr height="42">
        <td width="12%"align="center">����ʱ��</td>
        <td colspan=2 id="tdDamageStartDate2" width="34%"align="center"></td>  
        <td width="12%"align="center">����ԭ��</td>
        <td colspan=2 id="tdDamageCause2" width="34%"align="center">&nbsp;</td>        
      </tr>

      <tr height="200">
      <td colspan="7" valign=top id="tdDamageProcess2">
      ���վ�����
      </td>
      </tr>
      <tr height="200">
      <td colspan="7" valign=top id="tdCancelReason2">
      ����(ע��)���ɣ�
      </td>
      </tr>      
      <tr height="140">
      <td colspan="3" valign=top width="46%">
          <br><br>&nbsp;&nbsp;&nbsp;&nbsp;���������������飬�ڽӵ���֪ͨ��ʮ�����ڣ��򱾹�˾�򱾹�˾�ϼ�����������顣����ʮ���첻�������ģ����Զ�������<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������ǩ�֣�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;ũ���ܾ����ܵ���ǩ�ֵģ������������ɲ�ǩ�֡�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ǩ���ˣ�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
      

	  </td>
      <td colspan="4" valign=top><br><br><br>
      
      ����˾��ַ��</br>&nbsp;&nbsp;&nbsp;&nbsp;<%=addressCName2%><br><br>
      �������룺<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=postCode2%><br><br>
      ��ϵ�绰��<br>&nbsp;&nbsp;&nbsp;&nbsp;<%=phoneNumber2%><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�����˸��£�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=new SimpleDateFormat("yyyy �� MM �� dd ��").format(new Date())%>
      </td>      
      </tr>
            
    </table>
    <table border="0"style="font-family:����; font-size:10pt;">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;ע����ִ���뵵����</td>
      </tr>      
    </table>
        </td>
		<td width="1%" style="font-family:����; font-size:10pt;"><br><br><br><br><br>��<br>˾<br>ͳ<br>һ<br>��<br>��<br>��<br>��<br>��<br>��<br>:<br>9<br>6<br>9<br>9<br>9<br><br><br><br><br><br><br>��<br>��<br>��<br>:<br>��<br>��<br>��<br>��<br>��</td>
      </tr>      
    </table>
     
     
     
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
