<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-13
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
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAAVerifyLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  String nodeType=request.getParameter("nodeType");
	//ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();">

<%
}

%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <input type="hidden" name="nodeType"              value="<%=nodeType%>">    
        <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">         
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>

      <td class=button ><input type="button" class=bigbutton name="message" value="׫д����" onclick="openWinSave('<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.policyno.value,fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value)"></td>
      <td class=button ><input type="button" class=bigbutton name="messageView" value="�鿴����" onclick="openWinQuery('registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />')"></td>

    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
    %>
    <%-- 1.��������Ļ��� --%>
        <%@include file="/commonAgri/verifyLoss/AgriVerifyLossMainEdit.jsp"%>
    <%-- 2.�Ʋ���ʧ�嵥ҳ�� --%>
        <logic:equal name="prpLverifyLossDto" property="riskCode" value="3202">
            <%@include file="/commonAgri/verifyLoss/Agri3202VerifyLossPropEdit.jsp"%>
        </logic:equal>
        <logic:notEqual name="prpLverifyLossDto" property="riskCode" value="3202">
            <%@include file="/commonAgri/verifyLoss/AgriVerifyLossPropEdit.jsp"%>
        </logic:notEqual>
    

      <%-- ����ͨ�ð�ť --%>
      <%@include file="/commonAgri/verifyLoss/AgriVerifyLossSave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
