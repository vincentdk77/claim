<%--
****************************************************************************
* DESC       ：出险后抄单打印历史赔付信息页面
* AUTHOR     ： 项目组
* CREATEDATE ： 2005-09-14
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>

<%--初始化--%>
<%@include file="CopyNoneFormatPrintHistoryIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr><td colspan="6"><hr align="center" width="100%" size="2"/></td></tr>
    </table>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr><td colspan="6">历史赔付纪录：（已决）</td></tr>
      <tr>
        <td align="left" style="width:20%" >保险单号</td>
        <td align="left" style="width:20%" >立案号</td>
        <td align="left" style="width:12%" >出险时间 </td>
        <td align="left" style="width:10%" >出险原因</td>
        <td align="left" style="width:10%" >赔付金额</td>
        <td align="left" style="width:15%" >结案日期</td>
     </tr>
<%
  int m = 0;
  double dbSumSumPaid = 0;        //金额合计
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
      <tr><td colspan="2"><td colspan="2">合计出险：<%=m%>次</td><td colspan="2">金额合计：<%=dbSumSumPaid%></td> </tr>

      <tr><td colspan="6"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="6">历史赔付纪录：（未决）</td></tr>
      <tr>
        <td align="left">保险单号</td>
        <td align="left">立案号</td>
        <td align="left">出险时间 </td>
        <td align="left">出险原因</td>
        <td align="left">估损金额</td>
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
      <tr><td colspan="2"><td colspan="2">合计出险：<%=m%>次</td><td colspan="2">金额合计：<%=dbSumSumPaid%></td> </tr>
    </table>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr height="5px"><td colspan="6"><hr align="center" width="100%" height="1px" size="2"/></td></tr>
      <tr>
        <td style="width:45%" colspan="2">&nbsp;</td>
        <td style="width:25%" colspan="2" align="left">抄单人：<%=strUserName%></td>
        <td style="width:30%" align="left" colspan="2">抄单日期：<%=mDateTime.toString()%></td>
      </tr>
    </table>
  </body>
</html>