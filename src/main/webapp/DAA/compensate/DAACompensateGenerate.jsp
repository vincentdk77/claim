<%--
****************************************************************************
* DESC       ���������㱨��ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-09-07
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
</head>

<body class=interface>
  <%
    String text = "";
    PrpLctextDto prpLctextDto = (PrpLctextDto)request.getAttribute("prpLctextDto");
    for (Iterator iter = prpLctextDto.getPrpLctextList().iterator(); iter.hasNext();) {
      text += ((PrpLctextDto)iter.next()).getContext() +"\\n";
    }
   %>

<script language="javascript">
  parent.fraInterface.fm.prpLctextContextInnerHTML.value = "<%= text %>";

</script>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
