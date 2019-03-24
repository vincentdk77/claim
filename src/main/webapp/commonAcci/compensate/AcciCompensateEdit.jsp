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
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.claim.util.*"%>
<%@page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>
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
  <script src="/claim/commonAcci/compensate/js/AcciCompensateEdit.js"></script>
  <script src="/claim/commonAcci/compensate/js/AcciPersonLossEdit.js"></script>
</head>

<%
  //modify by liuyanmei add start 20051027
  //-ֻ�����к���Ȩ�޵��˿���������鰴ť---------
  String cancheck = "0"; 
  String userCode="";
  cancheck="1";
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  
   //--ֻ�����ϴ��������������ٴ��������-------- 
   String registNo = request.getParameter("RegistNo"); 
   String fowid    = request.getParameter("swfLogFlowID");
   String logNo    = request.getParameter("swfLogLogNo");
   String checkNotOver="0";
   String  conditions2 = "  flowid='"+fowid+"' and nodetype='check'";
   SwfLogDto  swfLogDto = null;
  
   UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
   
   Collection  swfLogDtoList = uiWorkFlowAction.findNodesByConditions(conditions2);
   
    if(swfLogDtoList.isEmpty()){
      checkNotOver="0";
       
     }
    else if(swfLogDtoList.size()!=0) { 
      
     int i=0;
     if(swfLogDtoList.iterator().hasNext()){
        swfLogDto=(SwfLogDto)swfLogDtoList.iterator().next();
        String nodeStatus=swfLogDto.getNodeStatus();
        if (!nodeStatus.equals("4")){
          checkNotOver="1";
          
        }
        
     }
  } 
  
   //modify by ww add begin 2005-11-15
   //reason: ��ֹ�ظ��ύ
   try {
      session.setAttribute("oldCompensateLastAccessedTime","");
      //modify by ww add end 2005-11-15
      //modify by liuyanmei end start 20051027
 
         UserDto   user     = (UserDto)session.getAttribute("user");
         String riskCode = "";
         if(user==null||user.equals("")){
           riskCode = request.getParameter("riskCode");
         }else{
           riskCode = user.getRiskCode();
         }
  }
   catch(Exception usee)
    { }
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else {
%>
<body class="interface" onload="initPage();initSet();calFund();onLoadZeroLossCaseType();">
<%
  }
%>
  <form name=fm action="/claim/compensateSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name='prpLregistPayFee' value="<bean:write name='prpLcompensateDto' property='palyFlag'/>">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <!--modify by liuyanmei add start 20051029--->
    <input type="hidden" name ="cancheck"  value="<%=cancheck%>">
    <input type="hidden" name ="checkNotOver"  value="<%=checkNotOver%>">
    <input type="hidden" name="times" value="<bean:write name='prpLcompensateDto' property='times'/>">
    <!--modify by liuyanmei add end 20051029--->
    
    <%-- 1.��������Ϣ --%>
        <%@include file="/commonAcci/compensate/AcciCompensateMainHeadEdit.jsp" %>
    <%-- 2.�ر�Լ�� --%>
        <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
    <%-- 3.�¹�����Ϣģ�� --%>
       <%@include file="/commonAcci/regist/AcciRegistAcciPerson.jsp"%>
    <%-- 3.5�¹�����ϸ��Ϣģ�� --%>

<%@include file="/commonAcci/compensate/AcciCompensateInjuryPersonInfo.jsp"%>
    <%-- 4.������������Ϣ --%>
       <%@include file="/commonAcci/claim/AcciClaimProposer.jsp"%>
    <%-- 5.�⸶��Ա��Ϣ --%>
       <%@include file="/commonAcci/compensate/AcciCompensatePersonLossEdit.jsp"%>
    <%-- 6.������ --%>
        <%@include file="/commonAcci/compensate/AcciCompensateChargeEdit.jsp"%>
    <%-- 7.����β��Ϣ --%>
        <%@include file="/commonAcci/compensate/AcciCompensateMainTailEdit.jsp" %>
     <%--8.��������� --%>
        <%@include file="/commonAcci/compensate/AcciCompensateTextEdit.jsp"%>
      <logic:notEmpty name="coinsFlag"  >
		<logic:equal name='coinsFlag' value="2">
			<%@include file="/common/compensate/CompensateCommonCoins.jsp"%>
		</logic:equal>
		<logic:equal name='coinsFlag' value="1">
			<%@include file="/common/compensate/CompensateCommonCoins.jsp"%>
		</logic:equal>
      </logic:notEmpty>
    <%-- 9.�������  ��Ԫ��Ŀ�� �����������--%>
        <%@include file="/commonAcci/compensate/AcciCompensateTextEdit2.jsp"%>
    <%-- 10.ָ��Σ�յ�λ��Ϣ --%>
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
        <%@include file="/commonAcci/compensate/AcciCompensateSave.jsp"%>
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
