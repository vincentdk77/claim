
<%--
****************************************************************************
* DESC       ：查勘登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-03
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
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.gyic.claim.dto.domain.PrplcombineDto"%> 
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      查勘登记
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/combineAgri/check/js/PropCheckEdit.js"></script>
  <script src="/claim/commAgri/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/combineAgri/check/js/DAACertainLossPropEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    int idxMain =0;
    int idxVerifyLoss =0;
    int idxProp =0;
    int idxEar =0;
    int idxTextEdit =0;
    String familySplittingFlag = "";
  String editType=request.getParameter("editType");
  String riskCode=request.getParameter("riskCode");
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
  //取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
  session.setAttribute("oldCheckLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initCombinePage();initSet();readonlyAllInput();disabledAllButton('buttonArea');initSpan();">
<%
}else
{
%>
<body  onload="initCombinePage();initSet();initSpan();">
<%
}

%>

    <form name=fm action="/claim/combineCheckSave.do" method="post" >
    
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
    
    <input type="hidden" name="txtCoreWebUrl" value="<%=strCoreWebUrl%>"> 
    <!-- 耳标号所有保单号 -->
	<input type="hidden" name= "riskCode"  value="<%= request.getParameter("riskCode")%>">
	<input type="hidden" name= "nodeType"  value="<%= request.getParameter("nodeType")%>">
	<input type="hidden" name="policyno" value="<%= request.getParameter("policyNo") %>">
	<input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo") %>">
    <input type="hidden" name="familySplittingFlag" value="<%= request.getAttribute("familySplittingFlag")%>">  
    <input type="hidden" name="versionType" value="<%= versionType %>">
   	<input type="hidden" name="versionNo" value="<%= versionNo %>">   
       
        <%-- 1.查勘/代查勘头信息 --%>
          <%@include file="/combineAgri/check/AgriCheckMainHeadEdit.jsp" %>
       
         <%-- 2.查勘中信息 --%>
          <%--@include file="/commonAgri/check/AgriCheckMainMiddleEdit.jsp" --%>
         <%-- 3.查勘尾信息 --%>
        
         <%-- 国元项目组定损信息 --%>
          <%@include file="/combineAgri/check/AgriCheckVerifyLossEdit.jsp" %>
             <%-- 3.财产损失清单页面 --%>
        <%@include file="/combineAgri/check/AgriCheckCertainLossPropEdit.jsp"%>

       
        <%@include file="/combineAgri/certainLoss/CombineAgriCertainLossPropEdit.jsp"%>
       
         <%-- 4.查勘备注信息 --%>
          <%@include file="/combineAgri/regist/AgriRegistTextEdit.jsp"%>
          <%--5.估损金额信息 --%>
         <%--@include file="/commonAgri/claim/AgriClaimFeeEdit.jsp"--%>
          <%--5.保存通用按钮 --%>
          <%@include file="/combineAgri/check/AgriCheckSave.jsp" %>

     </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/CombineStaticJavascript.jsp" />

</html:html>
