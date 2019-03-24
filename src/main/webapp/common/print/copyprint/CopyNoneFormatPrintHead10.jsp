<%--
****************************************************************************
* DESC       ：出险后抄单打印头信息页面
* AUTHOR     ： 项目组
* CREATEDATE ： 2005-09-14
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>

<%--初始化--%>
<%@include file="CopyNoneFormatPrintHead10Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table style="font-family:宋体; font-size:11pt;width:90%" align="center">
      <tr><td ></td></tr>
      <tr>
        <td align="center" width="100%" style="font-size:12pt;" colspan="2"><b> 理赔抄单（货运）</b></td>
      </tr>
      <tr>
        <td align="right" colspan="2"> 报案号：<%= strRegistNo %></td></tr>
      <tr><td colspan="2"><hr width="100%" align="center" style="direction:inherit "/></td></tr>
      <tr>
        <td style="width:50%">保险单号：<%= strPolicyNo %></td>
        <td style="width:50%">预约保险单号：<%= strMainPolicyNo %></td>
      </tr>
      <!--zhulei leave:险别显示险种名称：strRiskName，如果要改成险别的话请用：strKindNameTemp-->
      <tr><td colspan="2">险别：<%= strRiskName %></td></tr>
      <tr><td colspan="2">被保险人名称：<%= strPolicyName %></td></tr>
      <tr><td colspan="2">被保险人地址：<%= strPolicyAddress %></td></tr>
      <tr><td colspan="2">货物名称：<%= strItemDetailNameTemp %></td></tr>
      <tr>
        <td >保险金额：<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td>
        <td >免赔：<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbDeductible)%></td>
      </tr>
      <tr><td>运输路线：<%=strSiteName %></td><td>出单日期：<%=InputDate %></td></tr>
      <tr><td colspan="2" style="display:none">是否涉及再保临分、联保、共保：<%= strCoinsFlag %></td></tr>
    </table>
  </body>
</html>