<%--
****************************************************************************
* DESC       �����պ󳭵���ӡ���ѵ�����Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintEndorseIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="2"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="2">���������</td></tr>       
			<tr>
			  <td colspan="2">
				  <table width="100%" align="center" style="font-family:����; font-size:11pt;">
					  <tr>
						  <td align="left" width="30%">������   </td>
							<td align="left" width="30%"> ����ԭ��  </td>
							<td align="left" width="20%">����ʱ��</td>
							<td align="left" width="20%">�˱���</td>
						</tr>
						<tr><td colspan="4"><hr width="90%" align="left" style="direction:inherit "/></td></tr>
						<%for(i=0 ;i<strEndorseNo.length;i++){%>
						<tr>
							<td align="left"><%=strEndorseNo[i]%></td>
							<td align="left"><%=strEndorType[i]%></td>
						  <td align="left"><%=strEndorDate[i]%></td>
							<td align="left"><%=strUnderWriteName[i]%></td>
						</tr>
					  <%}%>
					</table>
				</td>
			</tr>
    </table>
  </body>
</html>