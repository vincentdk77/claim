<%--
****************************************************************************
* DESC       ���������䱣�մ��鿱ί�����ӡҳ��
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
<%@include file="FreightHeresyCheckSubmitNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>�������䱣�մ��鿱ί�����ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
   <table width="95%" align="center" cellspacing="0" cellpadding="0" border="0">
   <tr><td width="2%"></td><td width="82%" align="left">
   
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:13pt;">
          <B>�������䱣�մ��鿱ί����<B>
        </td>
      </tr>
      <tr>
        <td width="50%"></td>
        <td align="left" style="text-align:center; font-family:����; font-size:10pt;"> ί�е��ţ�</td>
      <tr>
        <td height="30" style="text-align:left; font-family:����; font-size:10pt;"><ins>&nbsp;<%=strMakeCom%>&nbsp;</ins>��˾���̼죩:</td><td>&nbsp;</td>
      </tr> 
      <tr>
        <td colspan="2" height="50" style="text-align:left; font-family:����; font-size:10pt;">&nbsp;&nbsp;&nbsp;&nbsp;��˾��<ins>&nbsp;<%=ReportDate%>&nbsp;</ins>�ӵ���������<ins>&nbsp;<%=strReportorName%>&nbsp;</ins>��������Ϥ�ҹ�˾�б���<ins>&nbsp;<%=strLossName%>&nbsp;</ins>�������<ins>&nbsp;<%=strDamageStartDate%>&nbsp;</ins>��<ins>&nbsp;<%=strDamageAddress%>&nbsp;</ins>�����¹ʡ�<br><br><br>
        </td> 
      </tr>
      <tr>
        <td align="left" style="text-align:left; font-family:����; font-size:10pt;">
           ��ı������ݣ�
        </td>
      </tr>
 </table>    
<table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;"  >
  <tr height="25">
    <td colspan="1" width="10%" align="center">��������</td>
    <td colspan="1" width="15%" id="tdInsuredName" align="center">&nbsp;</td>
    <td colspan="1" width="15%" align="center"> ���յ�����</td>
    <td colspan="1" width="15%" id="tdPolicyNo" align="center">&nbsp;</td>
    <td colspan="1" width="10%" align="center">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>    
    <td colspan="1" width="15%" id="" align="center">&nbsp;</td>      
  </tr>
  <tr height="25"> 
    <td colspan="1" align="center">���乤��</td>
    <td colspan="1" id="tdBLName" align="center">&nbsp;</td>
    <td colspan="1" align="center">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
    <td colspan="3" id="tdBLNo" align="center">&nbsp;</td>
  </tr>
  <tr height="25">
    <td colspan="1" align="center">��������</td>
    <td colspan="1" id="tdLossName" align="center">&nbsp;</td>
    <td colspan="1" align="center">��������</td>
    <td colspan="1" id="tdLossQuantity" align="center">&nbsp;</td>
    <td colspan="1" align="center">�˵�����</td>
    <td colspan="1" id="tdCarryBillNo" align="center">&nbsp;</td>
  </tr>
  <tr height="25">
    <td colspan="1" align="center">���ս��</td>
    <td colspan="1" id="tdSumAmount" align="center">&nbsp;</td>
    <td colspan="1" align="center">Ŀ  ��  ��</td>
    <td colspan="1" id="tdEndSiteName" align="center">&nbsp;</td>
    <td colspan="1" align="center">��������</td>
    <td colspan="1" align="right" id="tdSailStartDate" align="center">��  ��  ��</td>
  </tr>   
</table>
<table width="100%" align="left" cellspacing="0" cellpadding="2" border="0" style="font-family:����; font-size:10pt;" >
<tr>
 <td colspan="2" align="left"><br>
��ί���㹫˾���������ˣ�<br>
 &nbsp;&nbsp;&nbsp;���ֳ��鿱���������ԭ�򲢳��߲鿱����<br>
 &nbsp;&nbsp;&nbsp;�������¹��ֳ��������ʧ��Ƭ<br>
 &nbsp;&nbsp;&nbsp;��������𶨼�<br>
 &nbsp;&nbsp;&nbsp;����������&nbsp;&nbsp;&nbsp;&nbsp;��Ԫ��������֪ͨ�ҹ�˾���õ��𸴺���������
 <br>
 &nbsp;&nbsp;&nbsp;�뽫�������ϼ����鿱�վ��ʼĻ��ɱ�������ת����˾�������ڴ�"��"Ϊί�����<br><br>  
 ��л��<br><br><br><br><br><br><br><br><br>  <br><br>   
 </td>
 </tr>
 <tr height="30">
    <td > &nbsp;</td>
    <td nowrap>ί�й�˾:<%=comCName%>   &nbsp;&nbsp;&nbsp;&nbsp;       ��˾���£�</td>
 </tr>
 <tr height="30">
 ��<td width="50%">&nbsp;</td>
   <td>�ء���ַ:<%=addressCName%></td>
 </tr>
 <tr height="30">
   <td  align="left">����������ϵ�绰:<%=strPhoneNumber%></td>
   <td>��������:<%=postCode%></td>
 </tr>
 <tr height="30">��
   <td  align="left"></td>
   <td>��������:<%=faxNumber%></td>
 </tr>
 <tr height="30">��
   <td>��ϵ�ˣ�<%=strLinkerName%></td>
   <td>��ϵ�绰:<%=phoneNumber%></td>
 <tr height="30">  
   <td>&nbsp;</td>
   <td>��&nbsp;ϵ&nbsp;��:<%=manager%></td>
 </tr>
 <tr height="30">
   <td>&nbsp;</td>  
   <td>ί������<ins>&nbsp;<%=new SimpleDateFormat("yyyy��MM��dd��").format(new Date())%>&nbsp;</ins></td>
 </tr>
</table>
</td>
<td width="3%" style="font-family:����; font-size:10pt;" valign="top" align="center"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>��<br>һ<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>λ</td>
<td width="3%"style="font-family:����; font-size:10pt;" valign="top"><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>��<br>��<br>��<br>��<br>ί<br>��<br>��<br>˾<br>��<br>��</td>

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
