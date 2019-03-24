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

<%--初始化--%>
<%@include file="CopyNoneFormatPrintHistory01Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
      <tr><td colspan="3"><hr align="center" width="100%" size="2"/></td></tr>
      <tr><td colspan="3">历史赔付纪录：</td></tr>
			<tr>
			  <td colspan="3">
           <table width="100%" align="center" style="font-family:宋体; font-size:11pt;">
<!--             <tr>
               <td align="left">保险单号</td>
               <td align="left">立案号</td>
               <td align="left">出险时间 </td>
               <td align="left">出险原因</td>
               <td align="left">赔付金额</td>
               <td align="left">结案日期</td>
            </tr>
-->
             <tr>
               <td align="left">立案号</td>
               <td align="left">出险时间</td>
               <td align="left">未决金额 </td>
               <td align="left">赔付金额</td>
               <td align="left">结案日期</td>
               <td align="left">理算人</td>
               <td align="left">核赔人</td>
               <td align="left">赔付次数</td>
            </tr>

<%for(int j=0;j<strClaimNo.length;j++){ %>
  	        <tr>
  	          <td align="left"><%= strClaimNo[j] %></td>
  	          <td align="left"><%= strDamangeDate[j] %></td>
  	          <td align="left"><%= new DecimalFormat("0.00").format(result[j] ) %></td>
  	          <td align="left"><%= dbSumPaid[j] %></td>
  	          <td align="left"><%= arrEndCaseDate[j] %></td>
  	          <td align="left"><%= arrHandlerName[j]%> </td>
  	          <td align="left"><%= arrUnderWriteName[j] %></td>
  	          <td align="left"> </td>
  	        </tr>
<%}%>
				  </table>
				</td>
			</tr>
      <tr height="5px"><td colspan="3"><hr align="center" width="100%" height="1px" size="2"/></td></tr>
			<tr>
			  <td style="width:40%">&nbsp;</td>
			  <td style="width:30%" align="left">抄单人：<%=strUserName%></td>
			  <td style="width:30%" align="left">抄单日期：<%=mDateTime%></td>
			</tr>
    </table>
  </body>
</html>