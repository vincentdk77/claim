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
<%@ page import="java.util.*"%>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintAccountIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="2"><hr align="center" width="100%" size="2"/></td></tr>
			<tr><td colspan="2">���ѵ��������</td></tr>
			<tr>
			  <td colspan="2">
				  <table width="90%" align="center" style="font-family:����; font-size:11pt;">
					  <tr>
						  <td align="left">�������� </td>
							<td align="left">������</td>
							<td align="left">��������</td>
						</tr>
						<%for(i=0 ;i<strPlanEndorNo.length;i++){%>
						<tr>
							<td align="left"><%=iPlanNo[i]%></td>
						  <td align="left"><%=new DecimalFormat("#,##0.00").format(dbRealFee[i])%></td>
						  <!-- ��������Ϊ��ֵչʾ���� -->
						  <%if(strPayDate[i]==null){ %>
						     <td align="left"></td>
						  <%}else{ %>
							<td align="left"><%=strPayDate[i]%></td>
						  <%} %>
						</tr>
					  <%}%>
					</table>
				</td>
			</tr>
    </table>
  </body>
</html>