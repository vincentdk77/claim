<%--
****************************************************************************
* DESC       ：报案登记录入/修改页面/农险
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-12
* MODIFYLIST ：   Name       Date            Reason/Contents
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
    <!--对title处理-->
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
//start获得代码版本号
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
  //end获得代码版本号
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
    <%-- start耳标号清单表 --%>
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">
    <!-- 耳标号所有保单号 -->
    <input type="hidden" name='earPolicyNo' value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
        <%-- 1.报案主信息头 --%>
            <%@include file="/commonAgri/regist/AgriRegistMainHeadEdit.jsp" %>
        <%-- 2.报案主信息中 --%>
            <%@include file="/commonAgri/regist/AgriRegistMainMiddleEdit.jsp"%>
        <%-- 3.耳标号增加 --%>
        
        <%-- 4.事故者信息 --%>
        <%-- 现在国元的 奶牛保险走公共的农险程序
        <logic:equal name='prpLregistDto' property="riskCode" value="3202">
            <%@include file="/commonAgri/regist/AgriRegistAgri3202Person.jsp"%>
        </logic:equal>
        --%>
        <logic:notEqual name="prpLregistDto" property="riskCode" value="9999">
            <%@include file="/commonAgri/regist/AgriRegistAgriPerson.jsp"%>
        </logic:notEqual>
        <%-- 5.报案主信息结尾 --%>
            <%@include file="/commonAgri/regist/AgriRegistMainTailEdit.jsp"%>
            <%
         String  familySplittingFlag = "";
         familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag"));
         if(familySplittingFlag != null && "true".equals(familySplittingFlag))
         {%>
         <%@include file="/commonAgri/regist/AgriEarNoEdit.jsp"%>
         <%}%>
        <%-- 6.出险摘要--%>          
             <%@include file="/common/regist/RegistTextEdit.jsp"%>
        <%-- 7.巨灾代码--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%> 
        <%-- 8.保存通用按钮 --%>
            <%@include file="/commonAgri/regist/AgriRegistSave.jsp"%>
        <%-- 9.关联抄单打印按钮 --%>
            <%@include file="/common/print/RegistPrintButton.jsp"%>            
        
        <%-- 案件互查返回按鈕--%>
        <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>
     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>