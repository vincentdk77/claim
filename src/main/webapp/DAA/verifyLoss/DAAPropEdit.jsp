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
  PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)request.getAttribute("prpLverifyLossDto");
  String riskcodefortemp = prpLverifyLossDto.getRiskCode();
  String nodestatusForTemp = request.getParameter("status");
  //System.err.println("riskcodefortemp:" + riskcodefortemp);
  
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();setreadonlyforhouse();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();initForAdd();">

<%
}

%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <input type="hidden" name="nodeType"              value="<%=nodeType%>">             
        <input type="hidden" name="nodeStatus"              value="<%=nodestatusForTemp%>">             
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>
      <td class=button ><input type="button" class=bigbutton name="message" value="���⹵ͨ" onclick="openWinSaveQuery('<bean:write name='prpLregistDto' property='registNo' filter='true' />','<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value,'registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />')"></td>
      <td class=button ><input type="button" class=bigbutton name="message" value="���ӵ�֤" onclick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />','certa');"></td>
      
    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
    %>
      <%-- ��������Ļ��� --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
    <%-- 1.�Ʋ���ʧ�嵥ҳ�� --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossPropEdit.jsp"%>
          <%if(riskcodefortemp != null && ("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp))){ %>
          
           <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
          
          <%} %>
    
    <%-- 3. �˼ۡ������������ע --%>
        <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
    <%-- 4. ��������Ϣ����˵�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/verifyLoss/DAAVerifyLossSave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
