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
<%@ page import="com.sinosoft.claim.ui.control.action.UIEndorseAction" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/regist/js/ShipRegistEdit.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>
<%
  //modify by liuyanmei add 20051111 start
  
   String policyNo = (String)request.getAttribute("policyNo");
   String curRegistNo = (String)request.getAttribute("curRegistNo");
   UIEndorseAction uiEndorseAction = new UIEndorseAction();
   int checkFlag =0;
   checkFlag = uiEndorseAction.checkStatus(policyNo);
   System.out.println("----批改交验-----"+checkFlag);
 
  //modify by liuyanmei add 20051111 end

 
  String editType=request.getParameter("editType");
  System.out.println(editType);
  String flag = "Ship";
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();initSet();">
<%
}

%>

    <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="checkFlag" value="<%=checkFlag %>"> 
        <%-- 1.报案主信息头 --%>
            <%@include file="/commonShip/regist/ShipRegistMainHeadEdit.jsp" %>
        <%-- 2.报案主信息中 --%>
            <%@include file="/commonShip/regist/ShipRegistMainMiddleEdit.jsp"%>
        <%-- 3.报案主信息结尾 --%>
            <%@include file="/commonShip/regist/ShipRegistMainTailEdit.jsp"%>
        <!--modify by qinyongli add start 20050901 加入出险时，标的信息-->
      <%@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp"%>
        <!--modify by qinyongli add end 20050901-->
        
        <%--5.出险摘要 //add by qinyongli 2005-8-15--%>          
             <%@include file="/common/regist/RegistTextEdit.jsp"%>
        <%-- modify by liyanjie move 4.巨灾代码  20051024--%>
         <%-- 4.巨灾代码--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%>
        <%-- 保存通用按钮 --%>
            <%@include file="/commonShip/regist/ShipRegistSave.jsp"%>

  <%-- 关联抄单打印按钮 --%>
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