<%--
****************************************************************************
* DESC       ：报案登记录入/修改页面/非车险通用
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-12
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/regist/js/PropRegistEdit.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>
<%
//add by 夏天 for 0310改造
 PrpLregistDto  prpLregistDto4 = (PrpLregistDto)request.getAttribute("prpLregistDto");
 String riskcodefortemp = prpLregistDto4.getRiskCode();
 System.err.println("riskcode"+riskcodefortemp);
 
  String editType=request.getParameter("editType");
  String riskType=(String)request.getAttribute("riskType");
  String flay = "";
  String comcode = (String)request.getAttribute("comCode");
  String shortRiskCode = riskcodefortemp.substring(0,2);
  System.err.println(comcode + shortRiskCode);
  
  String flag = "Prop";
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  }else
  {
%>
<body class="interface" onload="initPage();initSet();initForAdd();">
<%
  }

%>
  <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="businessFlag" value="<%=(String)request.getAttribute("businessFlag") %>">
    <input type="hidden" name="comCodeClassCode" value="<%=comcode + shortRiskCode %>">
        <%-- 1.报案主信息头 --%>
            <%@include file="/commonProp/regist/PropRegistMainHeadEdit.jsp" %>
        <%-- 2.报案主信息中 --%>
            <%@include file="/commonProp/regist/PropRegistMainMiddleEdit.jsp"%>
        <%-- 3.报案主信息结尾 --%>
            <%@include file="/commonProp/regist/PropRegistMainTailEdit.jsp"%>
        <%if("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp)){ %>
         <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
        <%} %>
        <%
        if("J".equals(riskType)){
        %>
          <%-- 4.出险者信息 --%>
          <%@include file="/commonProp/regist/PropRegistPropPerson.jsp"%>
        <%
        }else{
        %>
           <%-- 4.承保信息 --%>
           <%@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp"%>
           <%
           if((comcode + shortRiskCode).equals("31ZH")){
           %>
           		<%@include file="/commonProp/regist/PropRegistPropPerson.jsp"%>
           <%	   
           }
           %>
        <%
        }
        %>
        <%-- 5.出险摘要--%>          
             <%@include file="/common/regist/RegistTextEdit.jsp"%>
        <%-- 6.巨灾代码--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%>             
        <%-- 7.保存通用按钮 --%>
            <%@include file="/commonProp/regist/PropRegistSave.jsp"%>
        <%-- 8.关联抄单打印按钮 --%>
            <%@include file="/common/print/RegistPrintButton.jsp"%>
         <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>
     </form>
         
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>