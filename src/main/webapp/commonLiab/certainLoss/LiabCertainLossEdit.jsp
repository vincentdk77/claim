<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-10-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
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
  <script src="/claim/commonLiab/certainLoss/js/LiabCertainLossEdit.js"></script>
  <script src="/claim/commonLiab/certainLoss/js/LiabCertainLossPersonEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>
<%
  int indexCertainLoss = 0;
  String flag = null;
  flag = request.getParameter("flag");
  session.setAttribute("oldCertainLossLastAccessedTime","");
%>

<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
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
  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.����/����������Ϣ --%>
        <%@include file="/commonLiab/certainLoss/LiabCertainLossMainEdit.jsp" %>
      <%-- 2.��Ա�����嵥ҳ�� --%>
        <%//@include file="/commonLiab/certainLoss/LiabCertainLossPersonEdit.jsp"%>
      <%-- 3.�Ʋ���ʧ�嵥ҳ�� --%>
        <%@include file="/commonLiab/certainLoss/LiabCertainLossPropEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
        <%@include file="/commonLiab/certainLoss/LiabCertainLossSave.jsp"%>
      <!--modified by wangli add start 20050329-->
      <%--��ӡ--%>
     <!-- <%@include file="/commonLiab/certainLoss/LiabCertainLossPrint.jsp"%> --> 
      <!--modified by wangli add end 20050329-->
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
