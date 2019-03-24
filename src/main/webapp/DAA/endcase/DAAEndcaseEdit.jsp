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
  <script src="/claim/DAA/endcase/js/DAAEndcaseEdit.js"></script>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();">
<%
}
%>
    <form name=fm action="/claim/endcaseSave.do?step=step1" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.�᰸����Ϣ --%>
      <%@include file="/DAA/endcase/DAAEndcaseMainEdit.jsp" %>
      <%-- 4.�᰸�ı���Ϣ --%>
      <%@include file="/DAA/endcase/DAAEndcaseTextEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/endcase/DAAEndcaseSave.jsp"%>

      <%--modify by wangli add start 20050418 --%>
            <%-- �����Ŷ�Ӧ���������б� --%>
      <%@include file="/common/compensate/CompensateMainBeforeEdit.jsp" %>
          <%--modify by wangli add end 20050418 --%>

  <%--modify by wangli add end 20050417 --%>
       <%--modify by zhaozhuo add 20050331 start--%>
      <%--resson: ���Ӵ�ӡ��ť--%>
      <%-- ��ӡ��ť --%>
      <%@include file="/DAA/endcase/DAAEndcasePrint.jsp"%>
      <%--modify by zhaozhuo add 20050331 end--%>
      <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>
     </form>
</body>


</html:html>
