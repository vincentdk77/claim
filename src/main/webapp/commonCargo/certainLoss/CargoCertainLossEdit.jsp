<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-10-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonCargo/certainLoss/js/CargoCertainLossEdit.js"></script>
  <script src="/claim/commonCargo/certainLoss/js/CargoCertainLossPersonEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>
<%

//start ��ֹ�ظ��ύ---------------------
session.setAttribute("oldCertainLossLastAccessedTime","");
//end---------------------------------------------
  int indexCertainLoss = 0;
  String flag = null;
  flag = request.getParameter("flag");
%>

<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
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
  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.����/����������Ϣ --%>
        <%@include file="/commonCargo/certainLoss/CargoCertainLossMainEdit.jsp" %>
      <%-- 2.��Ա�����嵥ҳ�� --%>
        <%//@include file="/commonCargo/certainLoss/CargoCertainLossPersonEdit.jsp"%>
      <%-- 3.�Ʋ���ʧ�嵥ҳ�� --%>
        <%@include file="/commonCargo/certainLoss/CargoCertainLossPropEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
        <%@include file="/commonCargo/certainLoss/CargoCertainLossSave.jsp"%>
      <!--modified by wangli add start 20050329-->
      <%--��ӡ--%>
      <!-- <%@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"%> -->
     
      <!--modified by wangli add end 20050329-->
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
