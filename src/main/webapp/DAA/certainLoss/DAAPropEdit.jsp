
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
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>     
<html:html locale="true">
<head>
    <!--��title����-->
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%

    //start ��ֹ�ظ��ύ---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
	if(userDto == null){
	    isShowButton = false;
	}
   //end---------------------------------------------
   
    String editType=request.getParameter("editType");
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else {
%>
    <body  onload="initPage();initSet();">
<%
    }
%>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="riskcode" value="<bean:write name='prpLregistDto' property='riskCode'/>">
  <input type="hidden" name="policyno" value="<bean:write name='prpLregistDto' property='policyNo'/>">

  <table width="100%" class=common cellpadding="5" cellspacing="1">
          <tr>

            <td class="formtitle">����Ǽ�</td>

          </tr>
        </table>
    <table cellpadding="5" cellspacing="1" class=common>
    <tr>
    <%if(isShowButton){ %>
       <td class=button >
	      <input type="button" name="message" class=bigbutton  value="���⹵ͨ" onclick="return openWinSaveQuery('<bean:write name='prpLregistDto' property='registNo' filter='true' />',fm.policyno.value,fm.riskcode.value,'propc',fm.prpLverifyLossClaimNo.value,'registNo','<bean:write name='prpLregistDto' property='registNo' filter='true' />');">
	   </td>
	<%} %>
	   <td class=button >
             <input type="button" name="eCertify" class="bigbutton" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','certa');">
       </td>
       </tr>
  </table>

    <%!
      int indexCertainLoss = 0;
      String flag = null;
    %>
    <%
      flag = request.getParameter("flag");
    %>

    <%-- ��������Ļ��� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp"%>
    <%-- 1.�Ʋ���ʧ�嵥ҳ�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossPropEdit.jsp"%>     
	 <%-- 4. ��������Ϣ����˵�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/certainLoss/DAACertainLossSave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>




