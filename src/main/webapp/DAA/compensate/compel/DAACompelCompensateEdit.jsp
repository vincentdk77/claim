<%--
****************************************************************************
* DESC       ��ʵ��¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.prpall.pubfun.PubTools" %>

<%@page import="com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade"%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
    	<bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/compensate/compel/js/DAACompelCompensateEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAPersonLossEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAlLossEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAACommerceBGather.js"></script>
  


  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <SCRIPT LANGUAGE="JavaScript">
  </SCRIPT>
</head>

<%
   session.setAttribute("oldCompensateLastAccessedTime","");
   PrpLregistExtDto prpLregistExtDto =(PrpLregistExtDto)request.getAttribute("prpLregistExtDto");
   String  riskcode = prpLregistExtDto.getRiskCode();
   BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new  BLPrpLRegistRPolicyFacade();
   String sql  =  "registno='"+prpLregistExtDto.getRegistNo()+"'";
   //�Ƿ��ǹ�������
   int countOfConClaim =  blPrpLRegistRPolicyFacade.getCount(sql);
   int isConClaim = 0;
   //�������� 
   if(countOfConClaim>1)
   {
	   isConClaim = 1;
   }
   String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet() ;calSumDutyPaid();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();">
<%
  }else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();">
<%
  }else{
%>
<body class="interface" onload="loadCarCharge('<%=riskcode %>','<%=isConClaim %>');initPage();initSet();calSumDutyPaid();">
<%
  }
  if (editType.equals("DELETE")){
%>
    <form name=fm action="/claim/compensateDelete.do" method="post" onsubmit="return validateForm(this);">
<%
  }else{
%>
    <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
<%
  }
%>   
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="prpLCollectNoSubmitMsg" value="<%= request.getAttribute("msg") %>">

        <%@include file="/DAA/compensate/DAACompensateMainHeadEdit.jsp" %>
		 <%-- ���߳���Ϣ--%>
        <%@include file="/DAA/compensate/DAACompensateThridCarEdit.jsp"%>
        <%-- 2.�ر�Լ�� --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
        <%-- 3.����Ʊ��Ϣ --%>
        <%@include file="/DAA/compensate/compel/DAACompensateBillEdit.jsp" %>
	    <%@include file="/DAA/compensate/compel/DAACompelCompensatePropEdit.jsp"%>
	    <%@include file="/DAA/compensate/compel/DAACompelCompensatePersonLossEdit.jsp"%>	    
	    
	    <%@include file="/DAA/compensate/compel/DAACompelCompensateNoneDutyEdit.jsp"%>
		<%@include file="/DAA/compensate/compel/DAACompelCompensateNoneInsEdit.jsp"%>
	     
        <%@include file="/DAA/compensate/compel/DAACompensatePropPersonSum.jsp"%>  
        <%@include file="/DAA/compensate/compel/DAACompelCompensateChargeEdit.jsp"%>

        <%-- 6.��������Ϣ --%> 
        <%@include file="/DAA/compensate/DAACompensateMainTailEdit.jsp" %>
        <%-- 7.���㱨�� --%>
        <%@include file="/DAA/compensate/DAACompensateTextEdit.jsp"%> 
 
        <%--����ǰ����⸶�����ӽ᰸���� 2005-07-20--%>
        <%@include file="/DAA/compensate/DAAEndCaseCompensateTextEdit.jsp"%>
        
        <%-- 2.��֤����Ϣ --%>
        <%--�������������Ρ��������������Ϣ ��������������ȷ��--%>
        <%@include file="/DAA/compensate/DAAPrpLqualityCheckEdit.jsp"%>

        <%-- 4.������Ϣ����˵�� --%>
        <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
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
        <%-- 8.����ͨ�ð�ť --%>
        <%@include file="/DAA/compensate/DAACompensateSave.jsp"%>
        <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>

     </form>
</body>

</html:html>
