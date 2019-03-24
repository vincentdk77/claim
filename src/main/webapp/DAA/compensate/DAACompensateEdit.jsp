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
  <script src="/claim/DAA/compensate/js/DAACompensateEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAPersonLossEdit.js"></script>
  <script src="/claim/DAA/compensate/js/DAAlLossEdit.js"></script>


  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <SCRIPT LANGUAGE="JavaScript">
  <!--
  /**
  *@description ��ʼ���ط���ѯ��Ϣ
  *@param       ��
  *@return      ͨ������true,���򷵻�false
  */
  function initSet1(){
<%
    ArrayList prpLqualityCheckDtoList = (ArrayList)request.getAttribute("prpLqualityCheckList");
    if(prpLqualityCheckDtoList!=null&&prpLqualityCheckDtoList.size()>0){
      for (int i = 0; i < prpLqualityCheckDtoList.size(); i++) {
        PrpLqualityCheckDto prpLqualityCheckDto = (PrpLqualityCheckDto)prpLqualityCheckDtoList.get(i);
        if(prpLqualityCheckDto.getCheckResult().equals("0")){
%>
          fm.VisitBackQue<%= i+1 %>[1].checked=true;
<%
        } else if(prpLqualityCheckDto.getCheckResult().equals("1")){
%>
          fm.VisitBackQue<%= i+1 %>[0].checked=true;
<%
        } else if(prpLqualityCheckDto.getCheckResult().equals("2")){
%>
          fm.VisitBackQue<%= i+1 %>[2].checked=true;
<%
        }
%>
          fm.txtQuestionRemark<%= i+1 %>.value='<%= prpLqualityCheckDto.getCheckRemark() %>';
<%
      }
    }
%>
  return true;
  }
  //-->
  </SCRIPT>
</head>

<%
//modify by ww add begin 2005-11-15
   //reason: ��ֹ�ظ��ύ
   session.setAttribute("oldCompensateLastAccessedTime","");
   //modify by ww add end 2005-11-15
   PrpLregistExtDto prpLregistExtDto =(PrpLregistExtDto)request.getAttribute("prpLregistExtDto");
   String  riskcode = prpLregistExtDto.getRiskCode();
   BLPrpLRegistRPolicyFacade blPrpLRegistRPolicyFacade = new  BLPrpLRegistRPolicyFacade();
   String sql  =  "registno='"+prpLregistExtDto.getRegistNo()+"'";
   //�Ƿ��ǹ�������
   int countOfClaim =  blPrpLRegistRPolicyFacade.getCount(sql);
   int isConClaim = 0;
   //��������  isConClaim>1
   if(countOfClaim>1)
   {
	   isConClaim = 1;
   }
   String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();initSet1();readonlyAllInput();disabledAllButton('buttonArea');loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();onLoadZeroLossCaseType();">
<%
  }else{
%>
<body class="interface" onload="loadCarCharge('<%=riskcode %>','<%=isConClaim %>');initPage();initSet();initSet1();onLoadZeroLossCaseType();">
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
    


        <%-- 1.��������Ϣ  --%>
        <%@include file="/DAA/compensate/DAACompensateMainHeadEdit.jsp" %>

        <%-- 2.�ر�Լ�� --%>
            <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>
        <%-- 3.����Ʊ��Ϣ --%>
            <%@include file="/DAA/compensate/compel/DAACompensateBillEdit.jsp" %>
        <%-- 4.�⸶�����Ϣ --%>
            <%@include file="/DAA/compensate/sunny/DAACompensateLlossEdit.jsp"%>
        <%-- 5.�⸶��Ա��Ϣ --%>
            <%@include file="/DAA/compensate/sunny/DAACompensatePersonLossEdit.jsp"%>
        <%-- 6.������ --%>
            <%@include file="/DAA/compensate/DAACompensateChargeEdit.jsp"%>
        <%-- 7.��������Ϣ --%>
            <%@include file="/DAA/compensate/DAACompensateMainTailEdit.jsp" %>
        <%-- 8.���㱨�� --%>
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
