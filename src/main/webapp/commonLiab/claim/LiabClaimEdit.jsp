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
  <script src="/claim/commonLiab/claim/js/LiabClaimEdit.js"></script>
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
     <%session.setAttribute("oldClaimLastAccessedTime","");%>
       <%-- 1.������ͷ��Ϣ --%>
       <%@include file="/commonLiab/claim/LiabClaimMainHeadEdit.jsp" %>

       <%-- 2.�����м���Ϣ --%>
       <%@include file="/commonLiab/claim/LiabClaimMainMiddleEdit.jsp" %>
       <%-- 3.����β��Ϣ --%>
       <%@include file="/commonLiab/claim/LiabClaimMainTailEdit.jsp" %>
       
       <%-- 5.�ձ��������Ϣ --%>
       <%@include file="/commonLiab/claim/LiabClaimLossEdit.jsp"%>
       <%-- 6.��ӵ�֤ --%>
       <%//@include file="/commonLiab/claim/LiabClaimDocEdit.jsp"%>
       <%-- 7.�������� --%>
       <%@include file="/commonLiab/claim/LiabClaimTextEdit.jsp"%>
       
       <%-- modify by liyanjie move 4.���ִ���  20051024--%>   
       <%-- 4.���ִ���--%>
       <%@include file="/common/claim/ClaimKelpInfo.jsp"%>
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
       <%@include file="/commonLiab/claim/LiabClaimSave.jsp"%>
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
