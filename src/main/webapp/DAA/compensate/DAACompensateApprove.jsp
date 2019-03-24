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
  <script src="/claim/DAA/compensate/js/DAACompensateEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAPersonLossEdit.js"></script>
</head>

<body class=interface onload="initPage();initSet();readonlyAllInput();">
    <form name=fm action="/claim/compensateApprove.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

        <%-- 1.��������Ϣ ??Ϊʲô�ͱ����������һ�£�lixiang --%>
      <%@include file="/DAA/compensate/DAACompensateMainHeadEdit.jsp" %>

        <%-- 2.�ر�Լ�� --%>
            <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
        <%-- 3.�⸶�����Ϣ --%>
            <%@include file="/DAA/compensate/DAACompensateLlossEdit.jsp"%>
        <%-- 3.�⸶��Ա��Ϣ --%>
            <%@include file="/DAA/compensate/DAACompensatePersonLossEdit.jsp"%>
        <%-- 3.������ --%>
            <%@include file="/DAA/compensate/DAACompensateChargeEdit.jsp"%>
       <%-- 1.��������Ϣ --%>
      <%@include file="/DAA/compensate/DAACompensateMainTailEdit.jsp" %>
        <%-- 4.���㱨�� --%>
            <%@include file="/DAA/compensate/DAACompensateTextEdit.jsp"%>

    <%-- ����ͨ�ð�ť --%>
        <table cellpadding="0" cellspacing="0" width="100%" style="display:">
          <tr>
            <td align="center"><input type="button" class=button name="buttonApprove" value="�� ��" onClick="approveSubmit();"></td>
          </tr>
        </table>
     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
