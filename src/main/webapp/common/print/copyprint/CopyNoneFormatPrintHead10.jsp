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
<%@ page import="java.util.*"%>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintHead10Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table style="font-family:����; font-size:11pt;width:90%" align="center">
      <tr><td ></td></tr>
      <tr>
        <td align="center" width="100%" style="font-size:12pt;" colspan="2"><b> ���Ⳮ�������ˣ�</b></td>
      </tr>
      <tr>
        <td align="right" colspan="2"> �����ţ�<%= strRegistNo %></td></tr>
      <tr><td colspan="2"><hr width="100%" align="center" style="direction:inherit "/></td></tr>
      <tr>
        <td style="width:50%">���յ��ţ�<%= strPolicyNo %></td>
        <td style="width:50%">ԤԼ���յ��ţ�<%= strMainPolicyNo %></td>
      </tr>
      <!--zhulei leave:�ձ���ʾ�������ƣ�strRiskName�����Ҫ�ĳ��ձ�Ļ����ã�strKindNameTemp-->
      <tr><td colspan="2">�ձ�<%= strRiskName %></td></tr>
      <tr><td colspan="2">�����������ƣ�<%= strPolicyName %></td></tr>
      <tr><td colspan="2">�������˵�ַ��<%= strPolicyAddress %></td></tr>
      <tr><td colspan="2">�������ƣ�<%= strItemDetailNameTemp %></td></tr>
      <tr>
        <td >���ս�<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td>
        <td >���⣺<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbDeductible)%></td>
      </tr>
      <tr><td>����·�ߣ�<%=strSiteName %></td><td>�������ڣ�<%=InputDate %></td></tr>
      <tr><td colspan="2" style="display:none">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
    </table>
  </body>
</html>