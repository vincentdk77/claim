<%--
****************************************************************************
* DESC       �����պ󳭵���ӡ���Ӽ���Լ��Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintSubIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="2"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="2" valign="top">�����գ�</td></tr>
      <tr>
        <td colspan="2">
         <table width="90%" align="center" style="font-family:����; font-size:11pt;">
       	  <tr>
       	    <td width="5%"></td>
            <td align="center" width="65%" > �ձ�����</td>
            <td align="center" width="15%" > ���� </td>
            <td align="center" width="15%" > �����</td>
          </tr>
<%
  for(i=0 ;i<strKindName.length;i++){
  	if(strItemKindFlag[i].substring(1,2).equals("2")){
%>
            <tr>
              <td> </td>
              <td align="left"><%=strKindName[i]%></td>
              <td align="center"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
              <td align="center"><%=dbDeductible[i]%></td>
            </tr>
<%
    }
  }
%>
						
          </table>
      	</td>
      </tr>
      <tr>
        <td width="15%" valign="top">�ر�Լ����</td>
        <td> </td>
      </tr>
      <tr>
        <td></td>
        <td ><pre><%=strEngage%> </pre></td>
      </tr>
    </table>
  </body>
</html>