<%--
****************************************************************************
* DESC       �����պ󳭵���ӡͷ��Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<!--<%@include file="CopyNoneFormatPrintHeadIni.jsp"%>-->

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="2">�����ţ�<%= strRegistNo %></td></tr>
      <tr></tr><td colspan="2">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr></tr><td colspan="2">�����������ƣ�<%= strPolicyName %></td></tr>
			<tr></tr><td colspan="2">�������˵�ַ��<%= strPolicyAddress %></td></tr>
			<tr></tr><td colspan="2">���ս�<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td></tr>
			<tr></tr><td colspan="2">���ձ�ģ�</td></tr>
			<tr></tr><td colspan="2">���ձ�ĵ�ַ��</td></tr>
			<tr></tr><td colspan="2">����˵����</td></tr>
			<tr></tr><td>Ͷ�����ڣ�<%=OperateDate %></td><td>¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
			<tr></tr><td>ǩ�����ڣ�<%=SignDate %></td><td>�������ڣ�<%=InputDate %></td></tr>
			<tr></tr><td colspan="2">�����ڼ䣺<%=StartDate %> �� <%=EndDate %></td></tr>
			<tr></tr><td colspan="2">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
    </table>
  </body>
</html>