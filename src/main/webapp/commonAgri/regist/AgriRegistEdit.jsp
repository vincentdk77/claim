<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��/ũ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-12
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPolicy"%>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonAgri/regist/js/AgriRegistEdit.js"></script>
  <script src="/claim/common/certainLoss/car/js/UICommon.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>
<%
  String editType=request.getParameter("editType");
  String flay = "";
  String flag = "Prop";
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  String type = "";
  session.putValue("oldRegistLastAccessedTime","");
//start��ô���汾��
	String  versionType = "";
	String  versionNo = "";
	PrpLregistDto prpLregistDtoTemp = (PrpLregistDto)request.getAttribute("prpLregistDto");
	BLPrpCmain blPrpCmain= new BLPrpCmain();
	PrpCmainSchema prpCmainSchema = new PrpCmainSchema();
	blPrpCmain.getData(prpLregistDtoTemp.getPolicyNo());
	if(blPrpCmain.getSize() == 1){
		prpCmainSchema = blPrpCmain.getArr(0);
		 if(!(prpCmainSchema.getVersionNo()==null ||prpCmainSchema.getVersionNo()==""))
		  {
			  versionType = prpCmainSchema.getVersionNo().substring(0,1);
			  versionNo = prpCmainSchema.getVersionNo();
		  }
	}
  //end��ô���汾��
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
	  type = "none";
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();">
<%
}

%>

    <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
    <input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">
    <%-- start������嵥�� --%>
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">
    <!-- ��������б����� -->
    <input type="hidden" name='earPolicyNo' value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
        <%-- 1.��������Ϣͷ --%>
            <%@include file="/commonAgri/regist/AgriRegistMainHeadEdit.jsp" %>
        <%-- 2.��������Ϣ�� --%>
            <%@include file="/commonAgri/regist/AgriRegistMainMiddleEdit.jsp"%>
        <%-- 3.��������� --%>
        
        <%-- 4.�¹�����Ϣ --%>
        <%-- ���ڹ�Ԫ�� ��ţ�����߹�����ũ�ճ���
        <logic:equal name='prpLregistDto' property="riskCode" value="3202">
            <%@include file="/commonAgri/regist/AgriRegistAgri3202Person.jsp"%>
        </logic:equal>
        --%>
        <logic:notEqual name="prpLregistDto" property="riskCode" value="9999">
            <%@include file="/commonAgri/regist/AgriRegistAgriPerson.jsp"%>
        </logic:notEqual>
        <%-- 5.��������Ϣ��β --%>
            <%@include file="/commonAgri/regist/AgriRegistMainTailEdit.jsp"%>
            <%
         String  familySplittingFlag = "";
         familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
         if(familySplittingFlag != null && "true".equals(familySplittingFlag))
         {%>
         <%@include file="/commonAgri/regist/AgriEarNoEdit.jsp"%>
         <%}%>
        <%-- 6.����ժҪ--%>          
             <%@include file="/common/regist/RegistTextEdit.jsp"%>
        <%-- 7.���ִ���--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%> 
        <%-- 8.����ͨ�ð�ť --%>
            <%@include file="/commonAgri/regist/AgriRegistSave.jsp"%>
        <%-- 9.����������ӡ��ť --%>
            <%@include file="/common/print/RegistPrintButton.jsp"%>            
        
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