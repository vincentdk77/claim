<%--
****************************************************************************
* DESC       : 分摊试算结果
* AUTHOR     : 
* CREATEDATE : 2005-08-22
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.reins.out.dto.domain.PrpLreinsTrialDto"%>
<%@page import="java.text.DecimalFormat"%>
<html:html locale="true">
<head>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<title>分摊试算结果</title>

<script src="/claim/common/js/showpage.js"></script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<%
List reinsTrialListEX = (ArrayList)request.getAttribute("reinsTrialListEX");
DecimalFormat idecimalFormatSix = new DecimalFormat("0.000000");
DecimalFormat idecimalFormat = new DecimalFormat("0.00");
%>
</head>

<body class="interface">
<table border="0" align="center" cellpadding="3" cellspacing="1"  class="common" >
<%for(int i=0;i<reinsTrialListEX.size();i++){
  ArrayList reinsTrialDtoList =(ArrayList)reinsTrialListEX.get(i);
  %>
      <tr class="title"><td colspan=3 class="subformtitle" align=center><br><font size="3" ><b>危险单位序号<%=i+1 %></b></font><br></td></tr>
      <tr class="title">
      <b>
      <td class="subformtitle">分保方式</td> <td class="subformtitle">比例％</td><td class="subformtitle"><bean:write name="reinsTrial"/>金额</td>
      </tr>
      <%for(int j=0;j<reinsTrialDtoList.size();j++)
      {
    	  PrpLreinsTrialDto reinsTrialDto = (PrpLreinsTrialDto)reinsTrialDtoList.get(j);
      
      %>
      <tr>
      <td class="input"><%=reinsTrialDto.getDangerDesc() %></td>
      <td class="input"><%=idecimalFormatSix.format(reinsTrialDto.getShareRate()) %></td>
      <td class="input"><%=idecimalFormat.format(reinsTrialDto.getSumClaim()) %></td>
      </tr>
      <%}
      } %>
   <tr class="title"><td colspan=3 align=center><br><br>
        <input type="button" class="button" value="关闭" onclick="window.close()">
   <br></td></tr>
</table>
</body>
</html:html>