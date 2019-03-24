<%--
****************************************************************************
* DESC       ：出险后抄单打印附加及特约信息页面
* AUTHOR     ： 项目组
* CREATEDATE ： 2005-09-14
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--初始化--%>
<%@include file="CopyNoneFormatPrintSubIni.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr><td colspan="2"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="2" valign="top">附加险：</td></tr>
      <tr>
        <td colspan="2">
         <table width="90%" align="center" style="font-family:宋体; font-size:11pt;">
       	  <tr>
       	    <td width="5%"></td>
            <td align="center" width="65%" > 险别名称</td>
            <td align="center" width="15%" > 保额 </td>
            <td align="center" width="15%" > 免赔额</td>
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
        <td width="15%" valign="top">特别约定：</td>
        <td> </td>
      </tr>
      <tr>
        <td></td>
        <td ><pre><%=strEngage%> </pre></td>
      </tr>
    </table>
  </body>
</html>