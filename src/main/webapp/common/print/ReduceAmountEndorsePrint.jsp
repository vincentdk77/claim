<%--
****************************************************************************
* DESC       ：冲减保额批文打印页面
* AUTHOR     ：
* CREATEDATE ：2007-01-29
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- 初始化 --%>
  <%@include file="ReduceAmountEndorsePrintIni.jsp"%>
  
<html>
  <head>
    <title><%=strRiskName%>冲减保额批文</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  </head>
  
  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="75%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align="center" style="font-family:宋体; font-size:14pt;">
            <B><%=strRiskName%>冲减保额批文<B>
          </td>
        </tr>
        <tr>
        	<td align="left" id="tdRiskName"></td>
        	<td align="right" id="tdPolicyNo"></td>
        </tr>
        <tr>
        	<td align="left" id="tdInsuredName"></td>
        	<td align="right" id="tdEndorseNo"></td>
        </tr>
      </table>
      <br><br>
      
      <table border=0 width="70%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr>
      		<td>批文：<br></td>
      	</tr>
      	<tr>
      		<td align="left"><%=strBuffer%></td>
      	</tr>
      </table>
      <br><br>
      <table border=0 width="70%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr>
      		<td align="left" id="tdHandlerName"></td>
      		<td align="right" id="tdInputDate"></td>
      	</tr>
      </table>
      
      <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
      	
  </body>
</html>