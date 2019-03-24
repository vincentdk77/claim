<%--
****************************************************************************
* DESC       ���������㱨��ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-09-07
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
    String str1 = "";
    PrpLctextDto prpLctextDto = (PrpLctextDto)request.getAttribute("prpLctextDto");
    Collection list = prpLctextDto.getPrpLctextList();
    Iterator iterator = list.iterator();
    while(iterator.hasNext()){
      PrpLctextDto prpLctextDto1 = (PrpLctextDto)iterator.next();
      //str1 = str1 + prpLctextDto1.getContext() + "<br>";
      str1 = str1 + prpLctextDto1.getContext() + "\\n";
    }

   %>

<script language="javascript">
  parent.fraInterface.fm.prpLctextContextInnerHTML.value = "<%= str1 %>";

</script>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
