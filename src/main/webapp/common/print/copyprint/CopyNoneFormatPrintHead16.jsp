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
<%@include file="CopyNoneFormatPrintHead16Ini.jsp"%>

<html>
  <head></head>
  <body>   
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="5" style="font-size:14pt;" align="center"><b> ��Ԫũҵ���չ�˾&nbsp;&nbsp;<%=strRiskName%>��������</b></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="4"/></td></tr>
      <tr><td colspan="5">�����ţ�<%= strRegistNo %></td></tr>
      <tr></tr><td colspan="5">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr></tr><td colspan="5">�����������ƣ�<%= strPolicyName %></td></tr>
			<tr></tr><td colspan="5">�������˵�ַ��<%= strPolicyAddress %></td></tr>
			
			<tr>
			  <td width="10%"> </td>
			  <td width="20%" align="center">��Ʒ����</td>
			  <td width="20%" align="center">��Ʒ�������</td>
			  <td width="20%" align="center">Ԥ�����۶�</td>
			  <td width="20%" align="center">����</td>
			</tr>
<%
  for(i=0;i<arrItemDetailName.length;i++){
  	if(arrItemFlag[i].substring(1,2).equals("1")){
%>
      <tr>
        <td align="center"><%=i+1%>��</td>
        <td align="center"><%=arrItemDetailName[i]%></td>
        <td align="center"><%=arrModel[i]%></td>
        <td align="center"><%=dbAmount[i]%></td>
        <td align="center"><%=arrCurrency[i]%></td>
      </tr>
<%
    }
  }
%>
			<tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
			<tr><td colspan="5">Ԥ�����۶�ϼƣ�<%=strCurrency%><%=dbAmountSum%></td></tr>
			<tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency05%><%=strLimit05%></td></tr>
			<tr><td colspan="5">��������<%=strSaleArea%></td></tr>
			<tr><td colspan="5">�б�����<%=strInsureArea%></td></tr>
			<tr><td colspan="2">Ͷ�����ڣ�<%=OperateDate %></td><td colspan="3">¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
			<tr><td colspan="2">ǩ�����ڣ�<%=SignDate %></td><td colspan="3">�������ڣ�<%=InputDate %></td></tr>
			<tr><td colspan="5">�������ޣ���<%=StartDate %> �� <%=EndDate %></td></tr>
			
			<tr><td colspan="5">׷���ڣ�<%=bkWardStartDate%></td></tr>
			
			<tr><td colspan="5">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
			
			<tr><td valign="top">�ر�Լ����</td><td colspan="4"><%=strEngage%></td></tr>
			
			<tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
			<tr><td align="left" style="width:25%">�⳥�޶</td><td colspan="4">ÿ���¹��⳥�޶<%=strCurrency01%><%=dbLimit01%></td></tr>
			<tr><td align="right">���У�</td><td  colspan="4">�Ʋ���ʧ�⳥�޶<%=strCurrency03%><%=strLimit03%></td></tr>
			<tr><td align="right"></td><td colspan="4">���������⳥�޶<%=strCurrency07%><%=strLimit07%></td></tr>
			<tr><td align="right"></td><td colspan="4">ÿ���¹�����<%=strCurrency02%><%=strLimit02%></td></tr>
			<tr><td align="right">���������ۼ��⳥�޶</td><td colspan="4"><%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td><td></td></tr>
			
			
			
	  </table>
  </body>
</html>