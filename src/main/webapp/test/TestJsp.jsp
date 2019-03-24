<%--
****************************************************************************
* DESC       ：报案测试工作流客户端
* AUTHOR     ：
* CREATEDATE ：2004-06-29
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>  
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.function.workflow.ejb.client.SharkFactory"%>
<%@page import="com.sinosoft.function.workflow.ejb.shark.SharkClientInterface"%>

<%
System.out.println("----------" + "---details:begin-----------");
  SharkClientInterface shark = SharkFactory.getShark();
  System.out.println("----------" + "---details:begin-----------");
  System.out.println("开始初始化");
  
     Map formalPars = new HashMap();
     String riskcode = "DAB";
     String policyNo="PDAA200431010006000017";
     String registNo ="RDAA200451010005000013";
     formalPars.put("RiskCode",riskcode);
     formalPars.put("PolicyNo",policyNo);
     formalPars.put("RegistNo",registNo);
    
     shark.createProcess("claimWF","ClaimWF_Work",formalPars);

%>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      报案测试工作流客户端
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
</head> 
        
<body class="interface" onload="initPage();initSet();">  
    <form name=fm action="" method="post" onsubmit="">
         报案测试工作流客户端 
    </form>
</body>

</html:html>
  