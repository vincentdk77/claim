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
  <script src="/claim/commonCargo/compensate/js/CargoCompensateEdit.js"></script>
</head>

<body class=interface onload="initPage();InitDocument();initSet();readonlyAllInput();disabledAllButton('tablebutton');">
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

    <%-- 1.��������Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateMainHeadEdit.jsp" %>
    <%-- 2.�ر�Լ�� --%>
        <%@include file="/commonCargo/compensate/CargoCompensateCengage.jsp"%>
    <%-- 2.�⳥�޶�/����� --%>
        <%@include file="/commonCargo/compensate/CargoCompensatePrpDlimit.jsp"%>
    <%-- 3.�⸶�����Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateLlossEdit.jsp"%>
    <%-- 3.������ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateChargeEdit.jsp"%>
   <%-- 1.��������Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateMainTailEdit.jsp" %>
    <%-- 4.���㱨�� --%>
        <%@include file="/DAA/compensate/DAACompensateTextEdit.jsp"%>
  <%-- ����ͨ�ð�ť --%>
        <%@include file="/DAA/compensate/DAACompensateSave.jsp"%>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
