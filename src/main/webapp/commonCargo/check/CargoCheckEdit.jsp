
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
<%@ page import="com.sinosoft.claim.dto.domain.PrpCmainCargoDto"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �鿱�Ǽ�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonCargo/check/js/CargoCheckEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  String riskCode=request.getParameter("riskCode");
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
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
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">    
        <%-- 1.�鿱/���鿱ͷ��Ϣ --%>
          <%@include file="/commonCargo/check/CargoCheckMainHeadEdit.jsp" %>
         <%-- 2.�鿱����Ϣ --%>
          <%--@include file="/commonCargo/check/CargoCheckMainMiddleEdit.jsp" --%>
         <%-- 3.�鿱β��Ϣ --%>
          <%@include file="/commonCargo/check/CargoCheckMainTailEdit.jsp" %>
         <%-- 4.�鿱��ϸ��Ϣ --%>
            <%@include file="/commonCargo/check/CargoCheckOtherInfor.jsp"%>
         <%-- 5.�鿱��ע��Ϣ --%>
          <%@include file="/commonCargo/check/CargoCheckTextEdit.jsp"%>
         <%--6.��������Ϣ --%>
          <%--@include file="/commonCargo/claim/CargoClaimFeeEdit.jsp"--%>
         <%--7.����ͨ�ð�ť --%>
          <%@include file="/commonCargo/check/CargoCheckSave.jsp" %>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
