<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%--
****************************************************************************
* DESC       ���鿱�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-03
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
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

 <script language="JavaScript">
    <!--
javascript:window.history.forward(1);
    //-->
    </script>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �鿱�Ǽ�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script>
	<!--
    /**
     *@description ���û���ĳ�ʼֵ
     *@param       ��
     *@return      ͨ������true,���򷵻�false
     */
  	function loadCheckLoss(){
  		var referKind = "<bean:write name='prpLcheckDto' property='referKind'/>";
      var arrayReferKind = new Array();
      arrayReferKind = referKind.split(",");
      var i = 0;
      var j = 0;
      for(i=0;i<arrayReferKind.length;i++)
      {
      	for(j=0;j<fm.prpLcheckReferKind.length;j++)
      	{
      		if(fm.prpLcheckReferKind[j].value == arrayReferKind[i])
      		{
      			fm.prpLcheckReferKind[j].checked=true;
      			break;
      		}
      	}
      }
  	}
	//-->
  </script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/check/js/DAACheckEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>


<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />


	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();initSet();initSetForCheck();readonlyAllInput();">
<%}else if(editType.equals("EDIT")){
%>
	<body class="interface" onload="initPage();initSet();">
<%	
}else{
%>
   <body class="interface" onload="initPage();initSet();addOption();">
<%}%>
    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="riskcode" value="<bean:write name='prpLcheckDto' property='riskCode' filter='true' />">
    <!-- ���²�ѯʱʹ��fm.prpLregistRiskCode.value -->
    <input type="hidden" name="prpLregistRiskCode" value="<bean:write name='prpLcheckDto' property='riskCode' filter='true' />">
          <input type="hidden" name="policyno" value="<bean:write name='prpLcheckDto' property='policyNo' filter='true' />">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
       <% //�鿱����%>

        <%-- 1.�鿱/���鿱����Ϣ --%>
          <%@include file="/DAA/check/DAACheckMainEdit.jsp" %>

          <%--modify by wangli add start 20050407--%>
           <%-- �ر�Լ�� --%>
            <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
           <%--modify by wangli add end 20050407--%>

        <%-- 2.�鿱/���鿱��չ --%>
          <%@include file="/DAA/check/DAACheckExtEdit.jsp"%>
        <%-- 3.�永���� --%>
          <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>
        <%--  �Ʋ���ʧ��λ��Ϣ --%>
         <%@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"%>

        <%-- 4.1 ���˸�����Ϣ --%>
            <%@ include file="/DAA/claim/DAAClaimPersonTraceEdit.jsp" %>
        <%-- 5.��ʻԱ��Ϣ --%>
          <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>

        <%-- 6.�鿱��ע��Ϣ --%>
         <%@include file="/DAA/regist/DAARegistTextEdit.jsp"%>

        <%-- 6.������Ϣ --%>
         <%-- //@include file="/DAA/check/DAACertainLossEdit.jsp" --%>
        <%-- 4.������Ϣ����˵�� --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
          <%--5.��������Ϣ --%>
         <%--@include file="/DAA/claim/DAAClaimFeeEdit.jsp"--%>

        <%-- ����ͨ�ð�ť --%>
         <%@include file="/DAA/check/DAACheckSave.jsp"%>


      </form>
</body>
</html:html>
