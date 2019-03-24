<%--
****************************************************************************
* DESC       ��Ԥ��Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-10
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
  <script src="/claim/DAA/prepay/js/DAAPrepayEdit.js"></script>
</head>

<body class=interface onload="initPage();initShow();" class="interface">
    <form name=fm action="/claim/prepayApprove.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.Ԥ������Ϣ --%>
      <%@include file="/DAA/prepay/DAAPrepayMainShow.jsp" %>
      <%-- 4.Ԥ�ⱸע��Ϣ --%>
      <%@include file="/DAA/prepay/DAAPrepayTextShow.jsp"%>

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
