

<%--
****************************************************************************
* DESC       ：定损登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-13
* MODIFYLIST ：   Name       Date            Reason/Contents
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
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>    
<%@page import="com.gyic.claim.dto.domain.PrplcompensateearDto"%>   
<%@page import="com.gyic.claim.dto.domain.PrplcombineDto"%> 
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>定损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/combineAgri/certainLoss/js/PropCertainLossEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>
<%
 
//add by lixiang start 2005-7-28
//取核心系统的地址
String coreWebUrl = AppConfig.get("sysconst.Core_URL");
//add by lixiang end 2005-7-28
 
   //start 防止重复提交---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
   //end---------------------------------------------
//start获得代码版本号
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
//end获得代码版本号
    String editType=request.getParameter("editType");
    if (editType.equals("SHOW")) {
%>
    <body  onload="initCombinePage();initSet();readonlyAllInput();disabledAllButton('buttonArea');initSpan();">
<%
  } else {
%>
    <body  onload="initCombinePage();initSet();initSpan();">
<%
    }
    int idxMain =0;
    int idxProp =0;
    int idxEar =0;
     String  familySplittingFlag = "";
%>

  <form name="fm" action="/claim/combineCertainLossSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
 
<table  class="common" cellpadding="1" cellspacing="1" >
   <tr><td colspan=13 class="formtitle">并案列表</td></tr>
    <tr>
		<td class="centertitle" style="width:1%">显示</td>
		<td class="centertitle" style="width:4%">报案号</td>
		<td class="centertitle" style="width:1%">显示</td>
		<td class="centertitle" style="width:4%">报案号</td>
		<td class="centertitle" style="width:1%">显示</td>
		<td class="centertitle" style="width:4%">报案号</td>
		<td class="centertitle" style="width:1%">显示</td>
		<td class="centertitle" style="width:4%">报案号</td>
    </tr>
    <%
   		Collection PrplcombineDtos = (Collection)request.getAttribute("combineDtos");
		Iterator iterator = PrplcombineDtos.iterator();
		PrplcombineDto prplcombineDto;
		while(iterator.hasNext()){%>
		<%	prplcombineDto = (PrplcombineDto)iterator.next();%>
		<tr>
		<td align="center">
			<input type="radio" name="registNoShow" onclick="spanShow();"  >
		</td>
		<td align="left">
			<a title="报案号"><%= prplcombineDto.getRegistno() %></a>
			<input type="hidden" name="combineRegistNo" value="<%= prplcombineDto.getRegistno() %>">
		</td>
		<%for(int i=0;i<3;i++){%>
		   <%if(iterator.hasNext()){
			 prplcombineDto = (PrplcombineDto)iterator.next();%>
			<td align="center">
				<input type="radio" name="registNoShow" onclick="spanShow();"  >
			</td>
			<td align="left">
				<a title="报案号"><%= prplcombineDto.getRegistno() %></a>
				<input type="hidden" name="combineRegistNo" value="<%= prplcombineDto.getRegistno() %>">
			</td>
			<%}%>
			<%}%>
			</tr>   
       <%}%>
 </table>
   <table  class="common" cellpadding="1" cellspacing="1" >
   <tr><td colspan=13 class="formtitle">案件详细信息</td></tr>
    </table>

    <%!
      int indexCertainLoss = 0;
     
    %>
	<input type="hidden" name= "riskCode"  value="<%= request.getParameter("riskCode")%>">
	<input type="hidden" name= "nodeType"  value="<%= request.getParameter("nodeType")%>">
	<input type="hidden" name="policyno" value="<%= request.getParameter("policyNo") %>">
	<input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo") %>">
	<input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">
   	<input type="hidden" name="coreWebUrl"       value="<%=coreWebUrl %>">      
      
    <%-- 1定损主表的画面 --%>
    <%@include file="/combineAgri/certainLoss/AgriCertainLossMainEdit.jsp"%>

     <%-- 暂时注释掉     <logic:notEqual name="prpLverifyLossDto" property="riskCode" value="9999">--%>
            <%@include file="/combineAgri/certainLoss/AgriCertainLossPropEdit.jsp"%>
    <%-- start耳标号清单表 --%>
  
     <%@include file="/combineAgri/certainLoss/CombineAgriCertainLossPropEdit.jsp"%>

     <%-- end耳标号清单表 --%>
      <%-- 暂时注释掉  </logic:notEqual>--%>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
   
	<%@include file="/combineAgri/certainLoss/AgriCertainLossSave.jsp"%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/CombineStaticJavascript.jsp" />

</html:html>




