<%--
****************************************************************************
* DESC       ��������������������Ŀ��ҳ
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@include file="DAALossNoneFormatPrintIni.jsp"%>
 <% 

  
 if( intComponentCount<24 )
  {
    strMessage = "��Ǹ!������Ŀδ����48��,�����ӡ�嵥��ҳ,������ӡ�嵥��";
System.out.println(strMessage );      
%>
    <jsp:include page="/common/pub/UIErrorPage.jsp">
      <jsp:param name="Picture" value="F" />
      <jsp:param name="Content" value="<%=strMessage%>" />
    </jsp:include>
<%  
    return;
  }
   %>

<html>
  <head>
    <title>�����������ճ���������Ŀ�嵥�����ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
    </tr>
    <tr>
      <td colspan="2" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;"> <strong><B>�����������ն��𱨸���ϸ������-��ҳ��<B> </b></b></strong></td>
    </tr>
  </table>

   <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
     <tr height=30>
        <td width="30%" align=left id="insuredName" style="font-family:����; font-size:10pt;">
          �������ˣ�<%=strInsuredName%>
        </td>
        <td width="40%" align=left id="registNo" style="font-family:����; font-size:10pt;">
          �����ţ�<%=strRegistNo%>
        </td>
        <td width="30%" align=right id="pageCount" style="font-family:����; font-size:10pt;">
          ��&nbsp;&nbsp;&nbsp;&nbsp;ҳ&nbsp;��&nbsp&nbsp;&nbsp;&nbspҳ
        </td>
      </tr>   
    </table>

   <table  border=1 width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">  
      
      <tr>
        <td height=20 colspan="1" width="12%" align="center">���ƺ���</td>
        <td height=20 colspan="1" width="22%" align="center"><%=licenseNo%></td>
        <td height=20 colspan="2" align="center">��������</td>
        <td height=20 colspan="2" align="center"><%=strPolicyNo%></td>
      </tr>
      <tr>
        <td height=20 colspan="1" align="center">��������</td>
        <td height=20 colspan="1" align="center" ><%=engineNo%></td>
        <td height=20 colspan="2" align="center" >�� �� ��</td>
        <td height=20 colspan="2" align="center"><%=frameNo%></td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table  border=1 width="92%" align="center" cellspacing="0" cellpadding="0" style="font-family:����; font-size:11pt; border-collapse:collapse"  bordercolor="#111111" >
      <tr bgcolor="#CCCCCC">
        <td height="25"><div align="center">���</div></td>
        <td height="25"><div align="center">�����������</div></td>
        <td height="25"><div align="center">����</div></td>
        <td height="25"><div align="center">����۸�</div></td>
        <td height="25"><div align="center">���</div></td>
        <td height="25"><div align="center">�����������</div></td>
        <td height="25"><div align="center">����</div></td>
        <td height="25"><div align="center">����۸�</div></td>
      </tr>
      
  
  <% 
   
   if(intComponentCount<72 && intComponentCount>48) {
    for(index=48;index<intComponentCount;index++) {
         String tdIndex="tdIndex"+index;
          String tdComName="tdComName"+index;
           String tdQuantity="tdQuantity"+index;
            String tdPrice="tdPrice"+index;
            
             String tdIndexl="tdIndex"+(index+24);
              String tdComNamel="tdComName"+(index+24);
              String tdQuantityl="tdQuantity"+(index+24);
              String tdPricel="tdPrice"+(index+24);
     
   
         %>
      
      <tr>
        <td height="25" id=<%=tdIndex%> align="center"></td>
        <td height="25" id=<%=tdComName%> align="center"></td>
        <td height="25" id=<%=tdQuantity%> align="center"></td>
        <td height="25" id=<%=tdPrice%> align="center"></td>
        <td height="25" id=<%=tdIndexl%> align="center"></td>
        <td height="25" id=<%=tdComNamel%> align="center"></td>
        <td height="25" id=<%=tdQuantityl%> align="center"></td>
        <td height="25" id=<%=tdPricel%> align="center"></td>
      </tr>
    
   <% }
   }   %> 
   
 <%  
    if(intComponentCount > 72) {
    for(index=48;index<=72;index++) {
         String tdIndex="tdIndex"+index;
          String tdComName="tdComName"+index;
           String tdQuantity="tdQuantity"+index;
            String tdPrice="tdPrice"+index;
            
             String tdIndexl="tdIndex"+(index+24);
              String tdComNamel="tdComName"+(index+24);
              String tdQuantityl="tdQuantity"+(index+24);
              String tdPricel="tdPrice"+(index+24);
     
   
         %>
      
      <tr>
        <td height="25" id=<%=tdIndex%> align="center"></td>
        <td height="25" id=<%=tdComName%> align="center"></td>
        <td height="25" id=<%=tdQuantity%> align="center"></td>
        <td height="25" id=<%=tdPrice%> align="center"></td>
        <td height="25" id=<%=tdIndexl%> align="center"></td>
        <td height="25" id=<%=tdComNamel%> align="center"></td>
        <td height="25" id=<%=tdQuantityl%> align="center"></td>
        <td height="25" id=<%=tdPricel%> align="center"></td>
      </tr>
    
   <% }
   }   %> 
    
   
   
    <%
  
        double tdSumMaterialFee1=0.00;
        double tdSumMaterialFee2=0.00;
       if(intComponentCount>48 && intComponentCount <72) {
          for (index=48;index<intComponentCount;index++){ 
             tdSumMaterialFee1 += dblMaterialUnitPrice[index];
          }
       }
       else if(intComponentCount>72) {
          for (index=48;index<72;index++){ 
             tdSumMaterialFee1 += dblMaterialUnitPrice[index];
          }
        }
        
//===========          
      
        if(intComponentCount>72 &&intComponentCount <96) {  
          for (index=72;index<intComponentCount;index++){ 
             tdSumMaterialFee2 += dblMaterialUnitPrice[index];
          }
        }
       else if(intComponentCount>96) {
          for (index=72;index<96;index++){ 
             tdSumMaterialFee2 += dblMaterialUnitPrice[index];
          }
        }
        
  %>
   
   
   
    
      <tr>
        <td height="25" colspan="3"><div align="center">���Ϸ�С��</div></td>
        <td height="25" align="center"><%=new DecimalFormat("#,##0.00").format(tdSumMaterialFee1)%></td>
        <td height="25" colspan="3"><div align="center">���Ϸ�С��</div></td>
        <td height="25" align="center"><%=new DecimalFormat("#,##0.00").format(tdSumMaterialFee1)%></td>
      </tr>
      <tr>
        <td height="25" colspan="8"><table width="100%"  border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="40%" height="25">&nbsp;&nbsp;�鿱�����ˣ�&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="30%" height="25">&nbsp;&nbsp;�˼��ˣ�&nbsp;&nbsp;&nbsp;&nbsp;</td>
            <td width="30%" height="25"><div align="right">&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;��&nbsp;&nbsp;��</div></td> 
          </tr>
        </table></td>
      </tr>
    </table>
  
    
    <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>
    
      <!-- ��ť���� -->
    <table id="tbButton" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <tr>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonPrint value=" �� ӡ " class="button" onclick="return printPage()">
        </td>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonClose value=" �� �� " class="button" onclick="javascript:window.close()">
        </td>
      </tr>
    </table>
    
  </body> 
</html>
