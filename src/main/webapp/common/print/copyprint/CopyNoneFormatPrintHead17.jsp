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
<%@include file="CopyNoneFormatPrintHead17Ini.jsp"%>

<html>
  <head></head>
  <body>   

    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
    <tr><td colspan="5" align="center" style="font-size:14pt;"><b> ��Ԫũҵ���չ�˾&nbsp;&nbsp;<%=strRiskName%>��������</b></td></tr>
    <tr><td colspan="5"><hr align="center" width="100%" size="4"/></td></tr>
		  <tr><td colspan="5">�����ţ�<%= strRegistNo %></td></tr>
      <tr><td colspan="5">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr><td colspan="5">�����������ƣ�<%= strPolicyName %></td></tr>
			<tr></tr><td>���յ�ַ��</td><td>1��</td><td colspan="3"><%=arrKindAddress[0]%></td>
<%
  for(i=1;i<arrKindAddress.length;i++){
%>
			<tr><td></td><td ><%=i+1%>��</td><td colspan="3"><%=arrKindAddress[i]%></td></tr>
<%}%>			  

			<tr><td colspan="5"> �⳥�޶</td></tr>
			<tr>
			  <td></td>
			  <td>��Ա����</td>
			  <td>����</td>
			  <td>����/�˲��⳥�޶�</td>
			  <td>ÿ��ҽҩ�����⳥�޶�</td>
			</tr>
<%
  for(i=0;i<arrKindName.length;i++){
    if(arrItemFlag[i].substring(1,2).equals("1")){
%>
      <tr>
        <td><%=i+1%></td>
        <td><%=arrModeName[i]%></td>
        <td><%=arrQuantity[i]%></td>
<%
      if(arrItemCode[i].equals("0001")){
%>
        <td><%=dbAmount[i]%></td>
        <td></td>
<%
      }else if(arrItemCode[i].equals("0002")){
%>
        <td></td>
        <td><%=dbAmount[i]%></td>
<%
      }//if
%>
      </tr>
<%
    }
  }//for
%>
		
			<tr><td colspan="5">ÿ���¹ʾ������⣺<%=strCurrency05%> <%=strLimit05%> </td></tr>
			<tr><td colspan="2">Ͷ�����ڣ�<%=OperateDate %></td><td colspan="3">¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
			<tr><td colspan="2">ǩ�����ڣ�<%=SignDate %></td><td colspan="3">�������ڣ�<%=InputDate %></td></tr>
			<tr><td colspan="5">�������ޣ���<%=StartDate %> �� <%=EndDate %></td></tr>
			
			<tr><td colspan="5">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
			<tr>
			  <td valign="top">�ر�Լ����</td>
			  <td colspan="4"><pre><%=strEngage%></pre></td>
			</tr>
			
	  </table>
  </body>
</html>