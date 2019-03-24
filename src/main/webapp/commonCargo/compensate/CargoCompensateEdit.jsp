<%--
****************************************************************************
* DESC       ��ʵ��¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonCargo/compensate/js/CargoCompensateEdit.js"></script>
  <script src="/claim/commonCargo/compensate/js/CargoPersonLossEdit.js"></script>
</head>

<%

//modify by ww add begin 2005-11-15
   //reason: ��ֹ�ظ��ύ
   session.setAttribute("oldCompensateLastAccessedTime","");
   //modify by ww add end 2005-11-15
    //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  UserDto   user     = (UserDto)session.getAttribute("user");
  String riskCode = "";
  if(user==null){
      riskCode = request.getParameter("riskCode");
  }else{
      riskCode = user.getRiskCode();
  }
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
  if (editType.equals("SHOW")){
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else if(editType.equals("EDIT")){
%>
<body  onload="loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else{
%>
<body  onload="initPage();initSet();calFund();onLoadZeroLossCaseType();">
<%
  }
%>
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
   <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
    <input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">   
    <%-- 1.��������Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateMainHeadEdit.jsp" %>
    <%-- 2.�ر�Լ�� --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 2.�⳥�޶�/����� --%>
        <%@include file="/commonCargo/compensate/CargoCompensatePrpDlimit.jsp"%>
    <%-- 3.�⸶�����Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateLlossEdit.jsp"%>
<%
  if(riskCode!=null&&riskCode.trim().equals("ZAA")){
%>
    <%-- 3.�⸶��Ա��Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensatePersonLossEdit.jsp"%>
<%
  }
%>
    <%-- 3.������ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateChargeEdit.jsp"%>
    <%-- 1.��������Ϣ --%>
        <%@include file="/commonCargo/compensate/CargoCompensateMainTailEdit.jsp" %>
 <% //���Ӷ���˵�� %>

        <%//@include file="/commonCargo/compensate/CargoCertaReportCompensateTextEdit.jsp"%>
          <%--��ӽ᰸���� 2005-07-26--%>
        <%@include file="/commonCargo/compensate/CargoEndCaseCompensateTextEdit.jsp"%>
        
   <%-- 4.���㱨�� --%>
        <%@include file="/commonCargo/compensate/CargoCompensateTextEdit.jsp"%>

 

    <%-- 4.����˵�� --%>
        <%@include file="/common/compensate/CompensatePayTextEdit.jsp" %>
    <%-- 5.ָ��Σ�յ�λ��Ϣ --%>
       <%
        PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	   	//�þɵ�Σ�յ�λ��Ϣҳ��	
	   %>
	      <%@include file="/common/claim/ClaimRiskUnit.jsp"%>
	   <%
	   }else{
		 //���µ�Σ�յ�λ��Ϣҳ��	   
	    %> 
	      <%@include file="/common/compensate/CompensateNewRiskUnit.jsp"%>
	    <%
	   }	    
	    %>
  <%-- ����ͨ�ð�ť --%>
        <%@include file="/DAA/compensate/DAACompensateSave.jsp"%>
		<%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>
     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
