<%--
****************************************************************************
* DESC       ：出险后抄单打印保费到账信息页面
* AUTHOR     ： 项目组
* CREATEDATE ： 2005-09-15
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--初始化--%>
<%@include file="CopyNoneFormatPrintAccount01Ini.jsp"%>

<html>
  <head>
  </head>
  <body>
    <tr><td colspan="4"><hr align="center" width="90%" size="2"/></td></tr>
    <table align="center" width="90%" style="font-family:宋体; font-size:11pt;">
		  <tr><td colspan="2">保费到账情况：</td></tr>                                                          
		  <tr>
		    <td colspan="2">
		  	  <table width="100%" align="center" style="font-family:宋体; font-size:11pt;">
		  		  <tr>
		  			  <td align="left">付款期数   </td>
		  				<td align="left">批单号  </td>
		  				<td align="left">应收</td>
		  				<td align="left">实收</td>
		  				<td align="left">到账日期</td>
		  			</tr>
		  			<%for(i=0 ;i<strPlanEndorNo.length;i++){%>
		  			<tr>
		  				<td align="left"><%=iPlanNo[i]%></td>
		  				<td align="left"><%=strPlanEndorNo[i]%></td>
		  				<td align="left"><%=new DecimalFormat("#,##0.00").format(dbPlanFee[i])%></td>
		  			  <td align="left"><%=new DecimalFormat("#,##0.00").format(dbRealFee[i])%></td>
		  			    <!-- 到账时间为空值展示处理 -->
		  				<%if(strPayDate[i]==null){%>
		  				<td align="left"></td>
		  				<%}else{%>
		  				<td align="left"><%=strPayDate[i] %></td>
		  				<%}%>
		  			</tr>
		  		  <%}%>
		  		</table>
		  	</td>
		  </tr>
		</table>
  </body>
</html>