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
<%@ page import="java.util.*"%>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintHistoryIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="6"><hr align="center" width="100%" size="2"/></td></tr>
    </table>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="6">��ʷ�⸶��¼�����Ѿ���</td></tr>
      <tr>
        <td align="left" style="width:20%" >���յ���</td>
        <td align="left" style="width:20%" >������</td>
        <td align="left" style="width:12%" >����ʱ�� </td>
        <td align="left" style="width:10%" >����ԭ��</td>
        <td align="left" style="width:10%" >�⸶���</td>
        <td align="left" style="width:15%" >�᰸����</td>
     </tr>
<%
  int m = 0;
  double dbSumSumPaid = 0;        //���ϼ�
  for(int j=0;j<strClaimNo.length;j++)
  {
    if(strEndCaseDate[j]!=null && !strEndCaseDate[j].equals("")){
      dbSumSumPaid = dbSumSumPaid + strSumPaid[j];
      m = m + 1;
      System.out.println("......sadfsd.....strEndCaseDate[j]=="+strEndCaseDate[j]+"--");
%>
     <tr>
       <td align="left"><%= strPolicyNo %></td>
       <td align="left"><%= strClaimNo[j] %></td>
       <td align="left"><%= strDamangeDate[j] %></td>
       <td align="left"><%= strDamageName[j] %></td>
       <td align="left"><%= strSumPaid[j] %></td>
       <td align="left"><%= strEndCaseDate[j] %></td>
     </tr>
<%
    }
  }
%>
      <tr><td colspan="2"><td colspan="2">�ϼƳ��գ�<%=m%>��</td><td colspan="2">���ϼƣ�<%=dbSumSumPaid%></td> </tr>

      <tr><td colspan="6"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="6">��ʷ�⸶��¼����δ����</td></tr>
      <tr>
        <td align="left">���յ���</td>
        <td align="left">������</td>
        <td align="left">����ʱ�� </td>
        <td align="left">����ԭ��</td>
        <td align="left">������</td>
        <td align="left"></td>
     </tr>
<%
  dbSumSumPaid = 0;
  m = 0;
  for(int j=0;j<strClaimNo.length;j++){
  System.out.println("...........strEndCaseDate[j]=>>>="+strEndCaseDate[j]+"--");
    if(strEndCaseDate[j]==null || strEndCaseDate[j].equals("")){
      m = m + 1;
      dbSumSumPaid = dbSumSumPaid + strSumPaid[j];
%>
     <tr>
       <td align="left"><%= strPolicyNo %></td>
       <td align="left"><%= strClaimNo[j] %></td>
       <td align="left"><%= strDamangeDate[j] %></td>
       <td align="left"><%= strDamageName[j] %></td>
       <td align="left"><%= strSumPaid[j] %></td>
       <td align="left"></td>
     </tr>
<%
    }
  }
%>
      <tr><td colspan="2"><td colspan="2">�ϼƳ��գ�<%=m%>��</td><td colspan="2">���ϼƣ�<%=dbSumSumPaid%></td> </tr>
    </table>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr height="5px"><td colspan="6"><hr align="center" width="100%" height="1px" size="2"/></td></tr>
      <tr>
        <td style="width:45%" colspan="2">&nbsp;</td>
        <td style="width:25%" colspan="2" align="left">�����ˣ�<%=strUserName%></td>
        <td style="width:30%" align="left" colspan="2">�������ڣ�<%=mDateTime.toString()%></td>
      </tr>
    </table>
  </body>
</html>