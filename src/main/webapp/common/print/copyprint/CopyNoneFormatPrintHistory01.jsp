<%--
****************************************************************************
* DESC       �����պ󳭵���ӡ��ʷ�⸶��Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintHistory01Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="3"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="3">��ʷ�⸶��¼��</td></tr>
			<tr>
			  <td colspan="3">
           <table width="100%" align="center" style="font-family:����; font-size:11pt;">
<!--             <tr>
               <td align="left">���յ���</td>
               <td align="left">������</td>
               <td align="left">����ʱ�� </td>
               <td align="left">����ԭ��</td>
               <td align="left">�⸶���</td>
               <td align="left">�᰸����</td>
            </tr>
-->
             <tr>
               <td align="left">������</td>
               <td align="left">����ʱ��</td>
               <td align="left">δ����� </td>
               <td align="left">�⸶���</td>
               <td align="left">�᰸����</td>
               <td align="left">������</td>
               <td align="left">������</td>
               <td align="left">�⸶����</td>
            </tr>

<%for(int j=0;j<strClaimNo.length;j++){ %>
  	        <tr>
  	          <td align="left"><%= strClaimNo[j] %></td>
  	          <td align="left"><%= strDamangeDate[j] %></td>
  	          <td align="left"><%= new DecimalFormat("0.00").format(result[j] ) %></td>
  	          <td align="left"><%= dbSumPaid[j] %></td>
  	          <td align="left"><%= arrEndCaseDate[j] %></td>
  	          <td align="left"><%= arrHandlerName[j]%> </td>
  	          <td align="left"><%= arrUnderWriteName[j] %></td>
  	          <td align="left"> </td>
  	        </tr>
<%}%>
				  </table>
				</td>
			</tr>
      <tr height="5px"><td colspan="3"><hr align="center" width="100%" height="1px" size="2"/></td></tr>
			<tr>
			  <td style="width:40%">&nbsp;</td>
			  <td style="width:30%" align="left">�����ˣ�<%=strUserName%></td>
			  <td style="width:30%" align="left">�������ڣ�<%=mDateTime%></td>
			</tr>
    </table>
  </body>
</html>