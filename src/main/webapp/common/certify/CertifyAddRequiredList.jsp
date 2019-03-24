<%--
****************************************************************************
* DESC       ：索赔清单显示及打印页面
* AUTHOR     ： zhaolu
* CREATEDATE ： 2006-08-07 
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.util.*"%>

    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>
  <SCRIPT>
  	function exit()
  	{
      window.opener.location.reload();
  	}
  </SCRIPT>

<%
  String nodeType=request.getParameter("nodeType");
  if(nodeType.equals("certi")){
%>
<body  onunload="exit();">
<%
  }else{
%>
<body >
<%
  }
%>
  <form name=fm action="/claim/certifySave.do" method="post">
  <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr height="40">
      <td align=top align=center style="font-family:宋体; font-size:14pt;">            
          <B><%=(String)request.getAttribute("riskName")%>索赔须知<B>
      </td>
    </tr>
  </table>
<%
      PrpLcertifyDirectDto prpLcertifyDirectDto = null;
      String strTypeCode[] = new String[100];
      String strTypeName[] = new String[100];
      int certifyDtoCount = 0;
      int index = 0;
      index = Integer.parseInt(request.getParameter("index"));
      CertifyDto certifyDto = (CertifyDto)request.getAttribute("certifyDto");
      if(certifyDto.getPrpLcertifyDirectDtoList()!=null){
        certifyDtoCount = certifyDto.getPrpLcertifyDirectDtoList().size();
      }
%>
<br>
<table width="92%" align="center" cellspacing="0" cellpadding="0" border="0"> 
	<tr> 
    <td colspan=4 height="20"><blockquote>
        <p><%=(String)request.getAttribute("riskName")%>索赔材料手续明细如下：（接上页）</p>
      </blockquote></td>
	   </tr><br>
<% 
  for(int i=25;i<certifyDtoCount;i++){
    prpLcertifyDirectDto = (PrpLcertifyDirectDto)certifyDto.getPrpLcertifyDirectDtoList().get(i); 
    strTypeCode[i] = prpLcertifyDirectDto.getTypeCode().substring(0,2);
    strTypeName[i] = prpLcertifyDirectDto.getTypeName();
    if(!strTypeName[i].equals("")){
      
%>	   
  <tr height="20"> 
    <td colspan=4><blockquote>
        <p><%=index++%>.<%=strTypeName[i]%></p>
      </blockquote></td>
	   </tr>
<%
    
  }
} 
%>	     
  <input type="hidden" name="nodeType" value="CertifDirect">
  </form>
     <jsp:include page="/common/print/PrintButton.jsp" />
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html>