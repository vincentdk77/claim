<%--
****************************************************************************
* DESC       �����պ󳭵���ӡͷ��Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-16
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintHead15Ini.jsp"%>

<html>
  <head></head>
  <body>
      
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="5" align="center" style="font-size:14pt;"><b> ��Ԫũҵ���չ�˾&nbsp;&nbsp;<%=strRiskName%>��������</b></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="4"/></td></tr>
      <tr><td colspan="5">�����ţ�<%= strRegistNo %></td></tr>
      <tr><td colspan="5">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr><td colspan="5">�����������ƣ�<%= strPolicyName %></td></tr>
      <tr><td width="20%">���յ�ַ��</td><td align="center" width="10%">1��</td><td colspan="3"><%=arrKindAddress[0]%></td></tr>
<%
  for(i=1;i<arrKindAddress.length;i++){
%>
	<tr><td></td><td align="right"><%=i+1%>��</td><td colspan="3"><%=arrKindAddress[i]%></td></tr>
<%}%>	  
	<tr><td colspan="5"> �⳥�޶ÿ���¹��⳥�޶<%=strCurrency01%> <%=strLimit01%></td></tr>
	<tr><td align="right">���У�</td><td colspan="4">�Ʋ���ʧ�⳥�޶<%=strCurrency03%> <%=strLimit03%> </td></tr>
	<tr><td > </td><td colspan="4">���������⳥�޶ <%=strCurrency07%> <%=strLimit07%></td></tr>
	<tr><td > </td><td colspan="4">ÿ���⳥�޶<%=strCurrency02%> <%=strLimit02%> </td></tr>
	
	<tr><td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������ۼ��⳥�޶<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td></tr>

	<tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency05%> <%=strLimit05%> </td></tr>
	<tr><td colspan="3">Ͷ�����ڣ�<%=OperateDate %></td><td colspan="2">¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
	<tr><td colspan="3">ǩ�����ڣ�<%=SignDate %></td><td colspan="2">�������ڣ�<%=InputDate %></td></tr>
	<tr><td colspan="5">�������ޣ���<%=StartDate %> �� <%=EndDate %></td></tr>
	<tr><td colspan="5">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
	<tr><td valign="top">�ر�Լ����<td colspan="4"><%=strEngage%></td></tr>		
    </table>
  </body>
</html>