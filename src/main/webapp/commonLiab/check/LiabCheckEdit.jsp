
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
  <script src="/claim/commonLiab/check/js/LiabCheckEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  System.out.println(editType);
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage(); ">
<%
}

%>

    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">    
        <%-- 1.�鿱/���鿱ͷ��Ϣ --%>
          <%@include file="/commonLiab/check/LiabCheckMainHeadEdit.jsp" %>

         <%-- 2.�鿱����Ϣ --%>
          <%--@include file="/commonLiab/check/LiabCheckMainMiddleEdit.jsp" --%>
         <%-- 3.�鿱β��Ϣ --%>
           <%@include file="/commonLiab/check/LiabCheckMainTailEdit.jsp" %>

         <%-- 4.�鿱��ע��Ϣ --%>
          <%@include file="/commonLiab/regist/LiabRegistTextEdit.jsp"%>
          <%--5.��������Ϣ --%>
         <%--@include file="/commonLiab/claim/LiabClaimFeeEdit.jsp"--%>
          <%--5.����ͨ�ð�ť --%>
          <%@include file="/commonLiab/check/LiabCheckSave.jsp" %>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
