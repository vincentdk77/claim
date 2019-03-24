<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��(�ǳ���)
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-14
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@ page import="java.util.*"%>

<html:html locale="true">

<head>
  <!--��title����-->
  <title>��������</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/claim/js/ShipClaimEdit.js"></script>
</head>

<%
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  if (editType.equals("SHOW")){
	  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
%>
<!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ�-->
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');disabledAllButton('ClaimLoss_button');loadDangerUnit();">
<%
}else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();">
<%	
}else{
%>
<body class="interface" onload="initPage();initSet();">
<%
}
%>

   <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
       <%session.setAttribute("oldClaimLastAccessedTime","");%>
       <%-- 1.������ͷ��Ϣ --%>
       <%@include file="/commonShip/claim/ShipClaimMainHeadEdit.jsp" %>

       <%-- 2.�����м���Ϣ --%>
       <%@include file="/commonShip/claim/ShipClaimMainMiddleEdit.jsp" %>
       <%-- 3.����β��Ϣ --%>
       <%@include file="/commonShip/claim/ShipClaimMainTailEdit.jsp" %>

       <%--4.��������Ϣ --%>
       <%--@include file="/commonShip/claim/ShipClaimFeeEdit.jsp"--%>

       <%-- 5.��ӵ�֤ --%>
       <%//@include file="/DAA/claim/DAAClaimDocEdit.jsp"%>
      
       <%-- 7.�������� --%>
       <%@include file="/commonShip/claim/ShipClaimTextEdit.jsp"%>
       
       <%-- modify by liyanjie move 6.���ִ���  20051024--%>   
		<%-- 6.���ִ���--%>
       <%@include file="/common/claim/ClaimKelpInfo.jsp"%>
		
      <%-- 8.�ձ��������Ϣ --%>
      <%@include file="/commonShip/claim/ShipClaimLossEdit.jsp"%>
       <%-- 9.ָ��Σ�յ�λ��Ϣ --%>
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
        <%@include file="/common/claim/ClaimNewRiskUnit.jsp"%>
     <%} %>
       <%-- 10.����ͨ�ð�ť --%>
       <%@include file="/commonShip/claim/ShipClaimSave.jsp"%>
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

