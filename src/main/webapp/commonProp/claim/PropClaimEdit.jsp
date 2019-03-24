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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>

<html:html locale="true">
  <!--��title����-->
  <title>��������</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/claim/js/PropClaimEdit.js"></script>
</head>

<%
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  String riskType=(String)request.getAttribute("riskType");
  String policyInputDate =(String)request.getAttribute("policyInputDate");
  PrpLclaimDto prpLclaimDto4 = (PrpLclaimDto)request.getAttribute("prpLclaimDto");
  String riskcodefortemp = prpLclaimDto4.getRiskCode();
  String classCode = (String)request.getAttribute("classCode");
  String comCode = (String)request.getAttribute("comCode");
  if (editType.equals("SHOW")){
	  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
%>
<!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ�-->
<body class="interface" onload="initPage();initSet();setreadonlyforhouse();readonlyAllInput();disabledAllButton('buttonArea');
    disabledAllButton('ClaimLoss_button');disabledAllButton('ClaimLoss');loadDangerUnit();">
<%
}else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();initForAdd();">
<%
}else{
%>
<body class="interface" onload="initPage();initSet();onload0310();initForAdd();">
<%
}
%>  
     
    

   <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
	   <%session.setAttribute("oldClaimLastAccessedTime","");%>
	   <input type="hidden" name="businessFlag" value="<%=(String)request.getAttribute("businessFlag") %>">
       <input type="hidden" name="comCodeClassCode" value="<%=comCode+classCode %>">
       <%-- 1.������ͷ��Ϣ --%>
       <%@include file="/commonProp/claim/PropClaimMainHeadEdit.jsp" %>

       <%-- 2.�����м���Ϣ --%>
       <%@include file="/commonProp/claim/PropClaimMainMiddleEdit.jsp" %>
       <%-- 3.����β��Ϣ --%>
       <%@include file="/commonProp/claim/PropClaimMainTailEdit.jsp" %>
         <%
        if("J".equals(riskType)){
        %>
          <%-- 4.��������Ϣ --%>
          <%@include file="/commonProp/regist/PropRegistPropPerson.jsp"%>
        <%
        }
         if("31ZH".equals(comCode+classCode)){
        %>
        	<%@include file="/commonProp/regist/PropRegistPropPerson.jsp"%>
        <%
         }
        %>
       
       <%-- 5.�������� --%>
       <%@include file="/commonProp/claim/PropClaimTextEdit.jsp"%>
       
       <%-- 6.���ִ�����Ϣ --%>
	   <%--  @include file="/common/claim/ClaimKelpInfo.jsp" --%>
		
        <%
        if("J".equals(riskType)){
        %>
           <%-- 7.�ձ��������Ϣ --%>
            <%@include file="/commonProp/claim/PropJClaimLossEdit.jsp"%>
        <%
        }else{
        %>
           <%-- 7.�ձ��������Ϣ --%>
          <%@include file="/commonProp/claim/PropClaimLossEdit.jsp"%>
        <%
        }
        %>
        
        <%if("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp)){ %>
         <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
        <%} %>
        
       <%-- 8.ָ��Σ�յ�λ��Ϣ --%>
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
       
       <%-- 9.����ͨ�ð�ť --%>
       <%@include file="/commonProp/claim/PropClaimSave.jsp"%>
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
