
<%--
****************************************************************************
* DESC       ���鿱�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-03
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �鿱�Ǽ�
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/check/js/PropCheckEdit.js"></script>
  <script src="/claim/commAgri/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
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
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();initSet();">
<%
}

%>

    <form name=fm action="/claim/checkSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
    <!-- ��������б����� -->
    <input type="hidden" name="earPolicyNo" value="<bean:write name='prpLcheckDto' property='policyNo'/>"> 
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">  
    <input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">
      
       
        <%-- 1.�鿱/���鿱ͷ��Ϣ --%>
          <%@include file="/commonAgri/check/AgriCheckMainHeadEdit.jsp" %>
       
         <%-- 2.�鿱����Ϣ --%>
          <%--@include file="/commonAgri/check/AgriCheckMainMiddleEdit.jsp" --%>
         <%-- 3.�鿱β��Ϣ --%>
           <%@include file="/commonAgri/check/AgriCheckMainTailEdit.jsp" %>
   <%if("3224".equals(riskCode1)) {%>        
         <%-- ��Ԫ��Ŀ�鶨����Ϣ --%>
          <%@include file="/commonAgri/check/AgriCheckVerifyLossEdit3224.jsp" %>
                <%} else
   if("3228".equals(riskCode1)){ %>
      <%@include file="/commonAgri/check/AgriCheckVerifyLossEdit.jsp"%>
   <%}else{ %>    
         <%@include file="/commonAgri/check/AgriCheckVerifyLossEdit.jsp" %>
   
    <%} %>
             <%-- 3.�Ʋ���ʧ�嵥ҳ�� --%>
        <%@include file="/commonAgri/check/AgriCheckCertainLossPropEdit.jsp"%>
        <%
        String  familySplittingFlag = "";
        familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
        if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
        <%@include file="/combineAgri/certainLoss/AgricombineCertainLossPropEdit.jsp"%>
        <%}%>
         <%-- 4.�鿱��ע��Ϣ --%>
          <%@include file="/commonAgri/regist/AgriRegistTextEdit.jsp"%>
          <%--5.��������Ϣ --%>
         <%--@include file="/commonAgri/claim/AgriClaimFeeEdit.jsp"--%>
          <%--5.����ͨ�ð�ť --%>
          <%@include file="/commonAgri/check/AgriCheckSave.jsp" %>

     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
