
<%--
****************************************************************************
* DESC       ���鿱�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-03
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
<%@page import="com.sinosoft.sysframework.reference.*"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �鿱�Ǽ�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/check/js/PropCheckEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  PrpLcheckDto prpLcheckDto = (PrpLcheckDto)request.getAttribute("prpLcheckDto");
  String riskcode = prpLcheckDto.getRiskCode();
  System.out.println(editType);
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();setreadonlyforhouse();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();initSet();initForAdd();">
<%
}

%>

    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <%-- 1.�鿱/���鿱ͷ��Ϣ --%>
          <%@include file="/commonProp/check/PropCheckMainHeadEdit.jsp" %>
          <%if(riskcode != null && ("0310".equals(riskcode)||"0312".equals(riskcode))){ %>
          
           <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
          
          <%} %>

         <%-- 2.�鿱����Ϣ --%>
          <%--@include file="/commonProp/check/PropCheckMainMiddleEdit.jsp" --%>
         <%-- 3.�鿱β��Ϣ --%>
           <%@include file="/commonProp/check/PropCheckMainTailEdit.jsp" %>

         <%-- 4.�鿱��ע��Ϣ --%>
          <%@include file="/commonProp/regist/PropRegistTextEdit.jsp"%>
          <%--5.��������Ϣ --%>
         <%--@include file="/commonProp/claim/PropClaimFeeEdit.jsp"--%>
          <%--5.����ͨ�ð�ť --%>
          <%@include file="/commonProp/check/PropCheckSave.jsp" %>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
