<%--
****************************************************************************
* DESC       ���᰸�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-28
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>�᰸�Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/endcase/js/ShipEndcaseEdit.js"></script>
</head>

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
    <form name=fm action="/claim/endcaseSave.do?step=step1" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

      <%-- 1.�᰸����Ϣ --%>
      <%@include file="/commonShip/endcase/ShipEndcaseMainEdit.jsp" %>
      <%-- 4.�᰸�ı���Ϣ --%>
      <%@include file="/DAA/endcase/DAAEndcaseTextEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/endcase/DAAEndcaseSave.jsp"%>
      <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>
     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
