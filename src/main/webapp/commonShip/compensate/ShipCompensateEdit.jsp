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
  <script src="/claim/commonShip/compensate/js/ShipCompensateEdit.js"></script>
  <script src="/claim/commonShip/compensate/js/ShipPersonLossEdit.js"></script>
</head>

<%

//modify by ww add begin 2005-11-15
   //reason: ��ֹ�ظ��ύ
   session.setAttribute("oldCompensateLastAccessedTime","");
   //modify by ww add end 2005-11-15
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
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();">
<%
  }else if(editType.equals("EDIT")){
%>
<body  onload="loadDangerUnit();">
<%
  }else{
%>
<body  onload="initPage();initSet();calFund();">
<%
  }
%>
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
   <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
   <input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">

    <%-- 1.��������Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensateMainHeadEdit.jsp" %>
    <%-- 2.�ر�Լ�� --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 2.�⳥�޶�/����� --%>
        <%@include file="/commonShip/compensate/ShipCompensatePrpDlimit.jsp"%>
    <%-- 3.�⸶�����Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensateLlossEdit.jsp"%>
<%
  if(riskCode!=null&&riskCode.trim().equals("ZAA")){
%>
    <%-- 3.�⸶��Ա��Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensatePersonLossEdit.jsp"%>
<%
  }
%>
    <%-- 3.������ --%>
        <%@include file="/commonShip/compensate/ShipCompensateChargeEdit.jsp"%>
    <%-- 1.��������Ϣ --%>
        <%@include file="/commonShip/compensate/ShipCompensateMainTailEdit.jsp" %>
 <% //���Ӷ���˵�� %>

        <%//@include file="/commonShip/compensate/ShipCertaReportCompensateTextEdit.jsp"%>
          <%--���ӽ᰸���� 2005-07-26--%>
        <%@include file="/commonShip/compensate/ShipEndCaseCompensateTextEdit.jsp"%>
        
   <%-- 4.���㱨�� --%>
        <%@include file="/commonShip/compensate/ShipCompensateTextEdit.jsp"%>

 

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