<%--
****************************************************************************
* DESC       ��ʵ��¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/compensate/js/ShipCompensateEdit.js"></script>
</head>

<body class=interface onload="initPage();InitDocument();initSet();readonlyAllInput();disabledAllButton('tablebutton');">
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <%-- 1.��������Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensateMainHeadEdit.jsp" %>
    <%-- 2.�ر�Լ�� --%>
        <%@include file="/commonShip/compensate/ShipCompensateCengage.jsp"%>
    <%-- 2.�⳥�޶�/����� --%>
        <%@include file="/commonShip/compensate/ShipCompensatePrpDlimit.jsp"%>
    <%-- 3.�⸶�����Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensateLlossEdit.jsp"%>
    <%-- 3.������ --%>
        <%@include file="/commonShip/compensate/ShipCompensateChargeEdit.jsp"%>
   <%-- 1.��������Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensateMainTailEdit.jsp" %>
    <%-- 4.���㱨�� --%>
        <%@include file="/DAA/compensate/DAACompensateTextEdit.jsp"%>
  <%-- ����ͨ�ð�ť --%>
        <%@include file="/DAA/compensate/DAACompensateSave.jsp"%>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>