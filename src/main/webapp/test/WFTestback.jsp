<%--
****************************************************************************
* DESC       �����������˹������ͻ���
* AUTHOR     ��
* CREATEDATE ��2004-06-29
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%@page import="java.util.*;"%>
<%@page import="com.sinosoft.claim.ui.control.action.UIWorkFlowAction;"%>
<%@page import="com.sinosoft.claim.dto.custom.WorkFlowDto;"%>
<%@page import="com.sinosoft.claim.dto.domain.WfLogDto;"%>
<%@page import="com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;"%>
<%
   
     String strflowId ="";
     String strLogId ="";
     
   strflowId=request.getParameter("flowID").trim();
   strLogId  =request.getParameter("logID").trim();
    
    
    
    

%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      ���������˹������ͻ���
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
</head> 
        
<body class="interface" onload="initPage();initSet();">  
    <form name=fm action="" method="post" onsubmit="">
         ���������˹������ͻ��� 
    </form>
</body>

</html:html>
  