<%--
****************************************************************************
* DESC       ：实赔录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>

<%@page errorPage="/UIErrorPage"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
    	汇总页面
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/compensate/js/DAACompensateEdit.js"></script>
    <script language=javascript>
    	function loadForm()
    	{
    		var arrayItem    = new Array();
    		arrayItem = window.opener.getLoss();

    	  var strContent = "";
    	  strContent = strContent + "<table class=common cellpadding='5' cellspacing='1'>";
    	  strContent = strContent + "  <tr class=listtitle>";
    	  strContent = strContent + "    <td >险别名称</td>";
    	  strContent = strContent + "    <td >项目名称</td>";
    	  strContent = strContent + "    <td >核损金额</td>";
    	  strContent = strContent + "    <td >赔偿金额</td>";
    	  strContent = strContent + "  </tr>";

    	  for(var i=0;i<arrayItem.length;i++)
    	  {
    	    var trClass="";
    	    if( i % 2 == 0 )
    	      trClass = "listodd";
    	    else
    	      trClass = "listeven";

    	    strContent = strContent + "  <tr class="+ trClass +">";
    	    strContent = strContent + "    <td>"+ arrayItem[i].LossKindName +"</td>";
    	    strContent = strContent + "    <td>"+ arrayItem[i].LossName +"</td>";
    	    strContent = strContent + "    <td align=right>"+ point(round(arrayItem[i].LossSumLoss,2),2) +"</td>";
    	    strContent = strContent + "    <td align=right>"+ point(round(arrayItem[i].LossRealPay,2),2) +"</td>";
    	    strContent = strContent + "  </tr>";
    	  }
    	  strContent = strContent + "</table>";
    	  divContent.innerHTML = strContent;
    	}
    </script>
</head>

<%-- 调用loadForm 初始化页面 --%>
<body class="interface" onload="loadForm();">
  <div id=divContent></div>
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td align=center>
       <input type="button" value="关闭" name = 'button_Peril_Close_Context' class="button" alt="关闭" onclick="window.close();">
      </td>
    </tr>
  </table>
</body>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>