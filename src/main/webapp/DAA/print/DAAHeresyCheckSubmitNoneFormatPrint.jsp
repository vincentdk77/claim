<%--
****************************************************************************
* DESC       �������������մ��鿱ί�����ӡҳ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-15
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="DAAHeresyCheckSubmitNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>�����������մ��鿱ί�����ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr>
        <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;">
          <Img src="/claim/images/LOGO.jpg"/>        
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>�����������մ���鿱ί����<B>
        </td>
      </tr>
      <tr>
        <td></td>
        <td align="right"> ί�е��ţ�_______________________________________</td>
      <tr>
        <td align="left">__________________��˾:</td><td>&nbsp;</td>
      </tr>
      <tr>
        <td colspan="2">
  �������� ��˾���ճ�������˾��Χ�����������գ���ί���㹫˾��������ȨЭ�����������������й���������±� ��
        </td>
      </tr>
 </table>    
<table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" >
  <tr height="25">
    <td colspan="1" width="15%">�������룺</td>
    <td colspan="2" width="31%" id="tdPolicyNo">&nbsp;</td>
    <td colspan="1" width="15%"> ���ƺ��룺</td>
    <td colspan="2" width="31%" id="tdLicenseNo">&nbsp;</td>
  </tr>
  <tr height="25"> 
    <td colspan="1">��������</td>
    <td colspan="2" id="tdInsuredName">&nbsp;</td>
    <td colspan="1">�����ձ�</td>
    <td colspan="2"id="">&nbsp;</td>
  </tr>
  <tr height="25">
    <td colspan="1">�����ͺ�</td>
    <td colspan="1" width="15%" id="tdBrandName">&nbsp;</td>
    <td colspan="1">ʹ������</td>
    <td colspan="1" id="tdUseNatureCode"> ��Ӫҵ �ڷ�Ӫҵ</td>
    <td colspan="1">������</td>
    <td colspan="1"width="15%" id="tdKindName0">&nbsp;</td>
  </tr>
  <tr height="25">
    <td colspan="1">��������</td>
    <td colspan="1" id="tdEngineNo">&nbsp;</td>
    <td colspan="1">��/��λ</td>
    <td colspan="1" id="tdSeatTonCount">&nbsp;</td>
    <td colspan="1" width="10%">������</td>
    <td colspan="1" id="tdKindName1">&nbsp;</td>
  </tr>  
  <tr height="25">
    <td colspan="1">�����ձ���</td>
    <td colspan="1" id="tdSumAmount1"><%=new DecimalFormat("#,##0.00").format(dblSumAmount1)+"Ԫ"%></td>
    <td colspan="1">�����������޶�</td>
    <td colspan="1" id="tdSumAmount2"><%=new DecimalFormat("#,##0.00").format(dblSumAmount2)+"Ԫ"%></td>
    <td colspan="1">������</td>
    <td colspan="1"width="15%" id="tdKindName2">&nbsp;</td>
  </tr>
  <tr height="25" > 
    <td colspan="1">��������</td>
    <td colspan="5" id="tdInsuredDate"><p>�� �������꣠ �� ������  �� �������꣠ �£� ��ֹ</p></td>
  </tr>      
  <tr height="25"> 
    <td colspan="1">��������</td>
    <td colspan="2" id="tdRegistNo">&nbsp;</td>
    <td colspan="1">���յص�</td>
    <td colspan="2" id="tdDamageAddress">&nbsp;</td>
  </tr>  
  <tr height="25">
    <td colspan="1"> ����ʱ��</td>
    <td colspan="2" id="tdDamageStartDate">&nbsp;</td>
    <td colspan="1">����ʱ��</td>
    <td colspan="2" id="tdReportDate">&nbsp;</td>
  </tr>    
  <tr height="25">
    <td colspan="1">����ԭ��</td>
    <td colspan="5" id="tdDamageName">&nbsp;</td>
  </tr>  
  </table>
<table width="80%" align="center" cellspacing="0" cellpadding="0" border="0">
<tr>
 <td colspan="2">
<p> ��ί���㹫˾���������ˣ�<br>
 &nbsp;&nbsp;&nbsp;1�����鿱�������鿱���桢���𱨸桢���˵��鱨�桢�ֳ���Ƭ����������Ƭ �鿱�����վݵ����в鿱�����ʼ��ҹ�˾��
 �ҹ�˾��ƾ�ݻ����鿱���á�<br>
 &nbsp;&nbsp;&nbsp;2��������<br>
 &nbsp;&nbsp;&nbsp;3��<br>
 &nbsp;&nbsp;&nbsp;4��<br>
 &nbsp;&nbsp;&nbsp;��Ԥ�����𳬹���������Ԫ��������������ʧ����������Ԫ�������֮��˾����������<br><br>  
 ��л��</p>     
 </td>
 </tr>
 <tr height="25">
    <td width="46">&nbsp; </td>
    <td>ί�й�˾:____________________________��˾���£�</td>
 </tr>
 <tr height="25">
 ��<td width="46%">&nbsp;</td>
   <td>�ء���ַ:___________________________________</td>
 </tr>
 <tr height="25">
   <td>����������ϵ�绰:    ____________________</td>
   <td>��������:____________________________________</td>
 </tr>
 <tr height="25">��
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;____________________</td>
   <td>��������:____________________________________</td>
 </tr>
 <tr height="25">��
   <td>��ϵ�ˣ�______________________________</td>
   <td>��ϵ�绰:___________________________________</td>
 <tr height="25">  
   <td>&nbsp;</td>
   <td>��&nbsp;ϵ&nbsp;��:___________________________________</td>
 </tr>
 <tr height="25">
   <td>&nbsp;</td>
   <td>ί������___________________��_____��_____��</td>
 </tr>
</table>
<!--
  <br>
  ��������ϵ�ˣ� ���������������������������������绰�� ������������������ַ�� <br><p>
  ���������������� �����£��� �� �������������������棺 �����������������ʱࣺ <br>
</p>-->
   
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
