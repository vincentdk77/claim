<%--
****************************************************************************
* DESC       ��Ԥ��Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>


<html:html locale="true">
<head>
  <!--��title����-->
  <title>Ԥ��Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAcci/prepay/js/AcciPrepayEdit.js"></script>
</head>
<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();InitDocument();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class=interface onload="initPage();InitDocument();initSet();" >
<%
}
%>
  <form name=fm action="/claim/prepaySave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <%-- 1.Ԥ������Ϣ --%>
    <%@include file="/commonAcci/prepay/PropPrepayMainEdit.jsp" %>
    <%-- 4.Ԥ�ⱸע��Ϣ --%>
    <%@include file="/DAA/prepay/DAAPrepayTextEdit.jsp"%>
    <%-- ����ͨ�ð�ť --%>
    <%@include file="/DAA/prepay/DAAPrepaySave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<script src="/claim/common/js/Edit.js"> </script>
</html:html>
