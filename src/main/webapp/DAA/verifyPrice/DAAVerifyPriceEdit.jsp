<%--
****************************************************************************
* DESC       ���˼۵Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��sunchenggang
* CREATEDATE ��2006-03-07
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
    <title>�˼۵Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyPrice/js/DAAVerifyPriceEdit.js"></script>  
  <script src="/claim/DAA/verifyPrice/js/DAAVerifPriceRepairComponentEdit.js"></script>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</head>

<%
  String editType=request.getParameter("editType");
  System.out.println(editType);
  PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)request.getAttribute("prpLverifyLossDto");
  String riskcodefortemp = prpLverifyLossDto.getRiskCode();
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet1();readonlyAllInput();setreadonlyforhouse();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet1();setreadonlyforhouse();readonlyAllInput();">

<%
}

%>
    <%!
      int indexVerifyLoss = 0;
    %>
  <form name="fm" action="/claim/verifyPriceSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
      <%-- 1.�˼�����Ϣ 
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp" %>--%>
      
        <%-- ��������Ļ��� --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
            <%-- 1.�Ʋ���ʧ�嵥ҳ�� --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossPropEdit.jsp"%>
       <%if(riskcodefortemp != null && ("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp))){ %>
          
           <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
          
          <%} %>
      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/verifyPrice/DAAVerifyPriceSave.jsp"%>
  </form>
</body>

</html:html>
