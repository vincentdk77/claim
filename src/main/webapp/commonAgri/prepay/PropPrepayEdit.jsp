<%--
* DESC       ：预赔登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<% 

PrpLprepayDto prpLprepayDto=(PrpLprepayDto)request.getAttribute("prpLprepayDto");
DBPrpCcoins dbPrpCcoins=new DBPrpCcoins();
dbPrpCcoins.getInfo(prpLprepayDto.getPolicyNo(), "2");
%>
<script language=javascript>
 //add by kangzhen start 061117  reason 查看的时候让界面元素只读
 function disabledAll(tableId)
 {
   var elements = getTableElements(tableId);

   for(var i=0;i<elements.length;i++)
   {
   		if(elements[i].name=="buttonBack"){ //如果名字为buttonBack则继续
       	continue;
      } 
       //将button设成不可用
       if(elements[i].type == "button")
       {  
       	 elements[i].disabled = true;
       }
       //将submit设成不可用
       if(elements[i].type == "submit")
       {
          elements[i].disabled = true;
       }
       //将reset设成不可用
       if(elements[i].type == "reset")
       {
          elements[i].disabled = true;
       }
       if(elements[i].type == "text")
       {
        	elements[i].disabled = true;
       }

    }
 }
//add by kangzhen end
</script>

<%@page import="com.sinosoft.claim.dto.domain.PrpLprepayDto"%>
<%@page import="com.sinosoft.prpall.dbsvr.cb.DBPrpCcoins"%>
<html:html locale="true">
<head>
  <!--对title处理-->
  <title>预赔登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/prepay/js/PropPrepayEdit.js"></script>
</head>
<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAll('Area');">
<%
}else
{
%>
<%if(dbPrpCcoins!=null){
    if(dbPrpCcoins.getCoinsTreatyNo()!=null&&!"".equals(dbPrpCcoins.getCoinsTreatyNo())){
%>
<body class=interface onload="initPage();initSet();initCoinsTreatyNo();" >
<%}else{%>
 <body class=interface onload="initPage();initSet();" >   
<%}}else{%>
<body class=interface onload="initPage();initSet();" >
<%}%>
<%
}
%>
  <form name=fm action="/claim/prepaySave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <%-- 1.预赔主信息 --%>
    <%@include file="/commonProp/prepay/PropPrepayMainEdit.jsp" %>
    <%-- 4.预赔备注信息 --%>
    <%@include file="/commonProp/prepay/PropPrepayTextEdit.jsp"%>
    <%-- 保存通用按钮 --%>
    <%@include file="/commonProp/prepay/PropPrepaySave.jsp"%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
