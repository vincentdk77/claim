<%--
****************************************************************************
* DESC       �����պ󳭵���ӡ���Ӽ���Լ��Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-17
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintSub08Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="2"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="2">�����գ�</td></tr>
      <tr>
			  <td colspan="2">
				  <table width="90%" align="center" style="font-family:����; font-size:11pt;">
					  <tr>
						  <td align="left" width="50%" > ����</td>
							<td align="left" width="30%" > ����/�޶�  </td>
							<td align="left" width="20%" >ÿ���⳥�޶�</td>
						</tr>
<%
    for(i=0 ;i<strKindName.length;i++){
  	  if(strItemKindFlag[i].substring(1,2).equals("2")){
%>
						<tr>
							<td align="left"><%=strKindName[i]%></td>
							<td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
						  <td align="left"><%=dbDeductible[i]%></td>
						</tr>
<%
      }
    }
%>

          </table>
        </td>
      </tr>
<!--      <tr>
        <td style="width:80px">�ر�Լ����</td>
        <td ><%=strEngage%> </td>
      </tr>
-->
    </table>
  </body>
</html>