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
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>

<html:html locale="true">
  <!--��title����-->
  <title>��������</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/claim/js/PropClaimEdit.js"></script>
  <script src="/claim/common/js/Validate.js"></script>
</head>

<%
  String editType=request.getParameter("editType");
  String isShow = request.getParameter("isShow");//�ٱ�Σ�յ�λ�õ�
  String policyInputDate =(String)request.getAttribute("policyInputDate"); 
  String riskCode1=request.getParameter("riskCode");
//start��ô���汾��
  String  versionType = "";
  String  versionNo = "";
	BLPrpCmain blPrpCmain= new BLPrpCmain();
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
	blPrpCmain.getData(request.getParameter("policyNo"));
	if(blPrpCmain.getSize() == 1){
		prpCmainSchema = blPrpCmain.getArr(0);
		 if(!(prpCmainSchema.getVersionNo()==null ||prpCmainSchema.getVersionNo()==""))
		  {
			  versionType = prpCmainSchema.getVersionNo().substring(0,1);
			  versionNo = prpCmainSchema.getVersionNo();
		  }
	}
  //end��ô���汾��
  //ȡ����ϵͳ�ĵ�ַ
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  String type = "";
  String getEarNoFrom = "claim";
  if (editType.equals("ADD")){
  	getEarNoFrom = "certa";
  }
  if (editType.equals("SHOW")){
  	type = "none";
	  //�༭�Ͳ�ѯ״̬�µ�����Σ�յ�λ��ֵ
%>
<!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ�-->
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');
    disabledAllButton('ClaimLoss_button');disabledAllButton('ClaimLoss');loadDangerUnit();">
<%
}else{
%>
<body class="interface" onload="initPage();initSet();">
<%
}
%>

   <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
	   <%session.setAttribute("oldClaimLastAccessedTime","");%>
	   <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>">
	   <!-- ��������б����� -->
       <input type="hidden" name="earPolicyNo" value="<bean:write name='prpLclaimDto' property='policyNo' filter='true' />">
       <input type="hidden" name="familySplittingFlag" value="<%=request.getAttribute("familySplittingFlag") %>">
       <input type="hidden" name="versionType" value="<%= versionType %>">
		<input type="hidden" name="versionNo" value="<%= versionNo %>">
		<input type="hidden" name="riskCode1" value="<%= riskCode1 %>">
       <%-- 1.������ͷ��Ϣ --%>
       <%@include file="/commonAgri/claim/AgriClaimMainHeadEdit.jsp" %>

       <%-- 2.�����м���Ϣ --%>
       <%if("3224".equals(riskCode1)) {%> 
       <%@include file="/commonAgri/claim/AgriClaimMainMiddleEdit3224.jsp" %>
       <%} else
       if("3228".equals(riskCode1)){ %>
      <%@include file="/commonAgri/claim/AgriClaimMainMiddleEdit.jsp"%>
       <%}else{ %>
       <%@include file="/commonAgri/claim/AgriClaimMainMiddleEdit.jsp" %>
       <%} %>
       
       <%-- 3.����β��Ϣ --%>
       <%@include file="/commonAgri/claim/AgriClaimMainTailEdit.jsp" %>
       <%--  �������Ϣ --%>
       <%
        String  familySplittingFlag = "";
        familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
        if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
        <%@include file="/commonAgri/claim/AgriClaimEarNoEdit.jsp"%>
        <%}%>
       <%-- 4.�¹�����Ϣ --%>
       <%-- ���ڹ�Ԫ�� ��ţ�����߹�����ũ�ճ���
       <logic:equal name='prpLclaimDto' property="riskCode" value="3202">
           <%@include file="/commonAgri/regist/AgriRegistAgri3202Person.jsp"%>
       </logic:equal>
        --%>
       <logic:notEqual name="prpLclaimDto" property="riskCode" value="9999">
           <table class=common>
           <%@include file="/commonAgri/regist/AgriRegistAgriPerson.jsp"%>
           </table>
       </logic:notEqual>
        
       
       <%-- 5.�������� --%>
       <%@include file="/commonAgri/claim/AgriClaimTextEdit.jsp"%>

	   <%-- 6.�ձ��������Ϣ --%>
	    <%-- ���ڹ�Ԫ�� ��ţ�����߹�����ũ�ճ���
	   <logic:equal name='prpLclaimDto' property="riskCode" value="3202">
           <%@include file="/commonAgri/claim/Agri3202ClaimLossEdit.jsp"%>
       </logic:equal>
       --%>
       <logic:notEqual name="prpLclaimDto" property="riskCode" value="9999">
           <%@include file="/commonAgri/claim/AgriClaimLossEdit.jsp"%>
       </logic:notEqual>
        <%-- 7.ָ��Σ�յ�λ��Ϣ --%>
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
       <%-- 8.����ͨ�ð�ť --%>
       <%@include file="/commonAgri/claim/AgriClaimSave.jsp"%>
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
