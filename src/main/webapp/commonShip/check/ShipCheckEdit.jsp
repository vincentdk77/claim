
<%--
****************************************************************************
* DESC       ���鿱�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-03
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpCmainCargoDto;"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �鿱�Ǽ�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/check/js/ShipCheckEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  System.out.println(editType);
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();">
<%
}

%>

    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <%-- 1.�鿱/���鿱ͷ��Ϣ --%>
          <%@include file="/commonShip/check/ShipCheckMainHeadEdit.jsp" %>

         <%-- 2.�鿱����Ϣ --%>
          <%--@include file="/commonShip/check/ShipCheckMainMiddleEdit.jsp" --%>
         <%-- 3.�鿱β��Ϣ --%>
          <%@include file="/commonShip/check/ShipCheckMainTailEdit.jsp" %>
         <%-- 4.�鿱��ϸ��Ϣ --%>
   <%--       <%@include file="/commonShip/check/ShipCheckOtherInfor.jsp"%>--%>
         <%-- 5.�鿱��ע��Ϣ --%>
          <%@include file="/commonShip/check/ShipCheckTextEdit.jsp"%>
         <%--6.��������Ϣ --%>
          <%--@include file="/commonShip/claim/ShipClaimFeeEdit.jsp"--%>
         <%--7.����ͨ�ð�ť --%>
          <%@include file="/commonShip/check/ShipCheckSave.jsp" %>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
