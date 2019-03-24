<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��weishixin
* CREATEDATE ��2004-02-29
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/regist/js/DAARegistEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>


<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" /> 
</head>
 <%
  String editType=request.getParameter("editType");
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();initSet_qs();readonlyAllInput();eidtRegistExt('RegistExt');eidtRegistExt('RegistExt_Data');changeProperties();" onclick="hiddenSpan_message();">
<%
}else if(editType.equals("EDIT")){
%>
<body  onload="initPage();initSet();initSet_qs();changeProperties();" onclick="hiddenSpan_message();" >	
<%
}else
{
%>
<body  onload="initPage();initSet();initSet_qs();changeProperties();addOption();" onclick="hiddenSpan_message();" >	
<%
}
%>
    
    <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <%-- 1.��������Ϣ --%>
            <%@include file="/DAA/regist/DAARegistMainEdit.jsp" %>         
        <%-- 1.1.����������Ϣ --%>
            <%//reason:�����б��ձ�λ�����ƶ��������ź�ֻ��ʾ�б��ձ�%>
            <%//@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp"%> 
	  	<%-- 2.��ʻԱ��Ϣ 
            <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>--%>
        <%-- 3.�永���� --%>
            <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>      
        <%-- 4.1 �Ʋ���ʧ��λ��Ϣ --%>
            <%--@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"--%>
        <%-- 4.2 ���˸�����Ϣ --%>
            <%--@include file="/DAA/claim/DAAClaimPersonTraceEdit.jsp"--%>
            <%
               if (request.getParameter("paramPrpallRegist") != null && request.getParameter("paramPrpallRegist").equals("DAA")) {
           %>
             <p align="center"><input type="button" name=buttonSave class='button' value="�� ��" onclick="window.close();">
            <%
                } else {
            %>
        <%-- 5.���ձ�ע��Ϣ --%>
            <%@include file="/DAA/regist/DAARegistTextEdit.jsp"%>
        <%-- 6.������Ϣ����Ԫȡ����--%>
            <%--@include file="/DAA/regist/RegistKelpInfo.jsp"--%>         
        <%-- 7.������Ϣ����˵�� --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
        <%-- 8.����ͨ�ð�ť --%>
            <%@include file="/DAA/regist/DAARegistSave.jsp"%>
            <%
                }
            %>
            <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>
     </form>
</body>
</html:html>