<%--
****************************************************************************
* DESC       �����պ󳭵���ӡ�ֱ���Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintReinsIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      
      <tr><td colspan="5">�ֱ���� </td></tr>
      <tr>
        <td>�ֱ���� </td>
<%
  if(dbShareRate0!=0){
%>
        <td>�����ֱ� </td>
<%
  }
  if(dbShareRate2!=0){
%>
        <td>��Լ�ֱ� </td>
<%
  }
  if(dbShareRate3!=0){
%>
        <td>��ʱ�ֱ� </td>
<%
  }
  if(dbShareRate1!=0){
%>
        <td>�������� </td>
<%
  }
%>

      </tr>
      <tr>
        <td >�ֱ�����(%) </td>
<%
  if(dbShareRate0!=0){
%>
        <td ><%=dbShareRate0%></td>
<%
  }
  if(dbShareRate2!=0){
%>
        <td ><%=dbShareRate2%></td>
<%
  }
  if(dbShareRate3!=0){
%>
        <td ><%=dbShareRate3%></td>
<%
  }
  if(dbShareRate1!=0){
%>
        <td ><%=dbShareRate1%></td>
<%
  }
%>
      </tr>
      
      
<!-- zhulei leave:��������Ϣ�������
<%
  if(strCoinsFlag.equals("����") || strCoinsFlag.equals("������")){
  //����Ҫ���������Ϣ��
%>
      <tr><td></td></tr>
      <tr><td></td></tr>
<%}%>
-->
    </table>
  </body>
</html>