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

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAcci/regist/js/AcciRegistEdit.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>
<%
  String editType=request.getParameter("editType"); 
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();">
<%
}

%>

    <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <%-- 1.报案主信息头 --%>
            <%@include file="/commonAcci/regist/AcciRegistMainHeadEdit.jsp" %>
        <%-- 3.报案主信息结尾 --%>
            <%@include file="/commonAcci/regist/AcciRegistMainTailEdit.jsp"%>
       <%-- 事故者信息模块 --%>
            <%@include file="/commonAcci/regist/AcciRegistAcciPerson.jsp"%>
        <%-- 4.其事故者现状和呈报信息--%>
             <%@include file="/commonAcci/regist/AcciRegistTextEdit.jsp"%>
             <%@include file="/commonAcci/regist/AcciRegistTextEdit2.jsp"%>
        <%-- 4.巨灾代码--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%>
		
        <%-- 保存通用按钮 --%>
            <%@include file="/commonAcci/regist/AcciRegistSave.jsp"%>
      
        <%-- 关联抄单打印按钮 --%>
            <%@include file="/common/print/RegistPrintButton.jsp"%>
            <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                 <input type="button" class="button" onclick="window.close()" value="关12闭"/>
              </center>
        </c:if>
     </form>

            

</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>