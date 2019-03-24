<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��/�ǳ���ͨ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-12
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
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
        <%-- 1.��������Ϣͷ --%>
            <%@include file="/commonAcci/regist/AcciRegistMainHeadEdit.jsp" %>
        <%-- 3.��������Ϣ��β --%>
            <%@include file="/commonAcci/regist/AcciRegistMainTailEdit.jsp"%>
       <%-- �¹�����Ϣģ�� --%>
            <%@include file="/commonAcci/regist/AcciRegistAcciPerson.jsp"%>
        <%-- 4.���¹�����״�ͳʱ���Ϣ--%>
             <%@include file="/commonAcci/regist/AcciRegistTextEdit.jsp"%>
             <%@include file="/commonAcci/regist/AcciRegistTextEdit2.jsp"%>
        <%-- 4.���ִ���--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%>
		
        <%-- ����ͨ�ð�ť --%>
            <%@include file="/commonAcci/regist/AcciRegistSave.jsp"%>
      
        <%-- ����������ӡ��ť --%>
            <%@include file="/common/print/RegistPrintButton.jsp"%>
            <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                 <input type="button" class="button" onclick="window.close()" value="��12��"/>
              </center>
        </c:if>
     </form>

            

</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>