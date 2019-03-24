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
  <script src="/claim/commonCargo/claim/js/CargoClaimEdit.js"></script>
</head>

<%
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
   //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
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
   	<input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">    
       <%session.setAttribute("oldClaimLastAccessedTime","");%>
       <%-- 1.������ͷ��Ϣ --%>
       <%@include file="/commonCargo/claim/CargoClaimMainHeadEdit.jsp" %>

       <%-- 2.�����м���Ϣ --%>
       <%@include file="/commonCargo/claim/CargoClaimMainMiddleEdit.jsp" %>
       <%-- 3.����β��Ϣ --%>
       <%@include file="/commonCargo/claim/CargoClaimMainTailEdit.jsp" %>

       <%--4.��������Ϣ --%>
       <%--@include file="/commonCargo/claim/CargoClaimFeeEdit.jsp"--%>

       <%-- 5.��ӵ�֤ --%>
       <%//@include file="/DAA/claim/DAAClaimDocEdit.jsp"%>
      
       <%-- 7.�������� --%>
       <%@include file="/commonCargo/claim/CargoClaimTextEdit.jsp"%>
       
       <%-- modify by liyanjie move 6.���ִ���  20051024--%>   
		<%-- 6.���ִ���--%>
       <%@include file="/common/claim/ClaimKelpInfo.jsp"%>
		
      <%-- 8.�ձ��������Ϣ --%>
      <%@include file="/commonCargo/claim/CargoClaimLossEdit.jsp"%>
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
       <%@include file="/commonCargo/claim/CargoClaimSave.jsp"%>
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
