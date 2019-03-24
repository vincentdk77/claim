<%--
****************************************************************************
* DESC       ：立案登记录入/修改页面(非车险)
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-14
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@page import="com.gyic.claim.dto.domain.PrplcombineDto"%> 
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>


<html:html locale="true">
<head>
  <!--对title处理-->
  <title>立案处理</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script language="Javascript" src="/claim/common/js/Common.js" ></script>
  <script language="Javascript" src="/claim/common/js/MulLine.js" ></script>
  <%--<script language="Javascript" src="/claim/combineAgri/claim/js/ValidateData.js" ></script>--%>
  <%--<script language="Javascript" src="/claim/combineAgri/claim/js/Validate.js" ></script>--%>
  <script language="Javascript" src="/claim/common/js/ValidateData.js" ></script>
  <script language="Javascript" src="/claim/common/js/CombineValidate.js" ></script>
  <script language="Javascript" src="/claim/common/js/CombineValidateData.js" ></script>
  <script language="Javascript" src="/claim/combineAgri/claim/js/InputCodeClaim.js" ></script>
  <script language="Javascript" src="/claim/common/js/InputCode.js" ></script>
  <script language="Javascript" src="/claim/common/js/ClaimPub.js" ></script>
  <script language="Javascript" src="/claim/common/js/Application.js" ></script>
  <script src="/claim/combineAgri/claim/js/PropClaimEdit.js"></script>
<script language="Javascript" src="/claim/combineAgri/claim/js/DangerUnit.js" ></script>  
</head>
<script>
function spanShow(){
	var countShow = getElementCount("registNoShow");
	var showFlag = document.getElementsByName("registNoShow");
	for(var index = 0 ;index < countShow ; index++){
		var spanOneClaim = document.getElementById("spanOneClaim_"+index);
		if(showFlag[index].checked){
			spanOneClaim.style.display = "";
		}else{
			spanOneClaim.style.display = "none";
		}
	}
	return true;
}
</script>
<%
  String editType=request.getParameter("editType");
  
  //取核心系统的地址
  String strCoreWebUrl = AppConfig.get("sysconst.Core_URL");
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
  String type = "";
  String getEarNoFrom = "claim";
  if (editType.equals("ADD")){
  	getEarNoFrom = "certa";
  }
  if (editType.equals("SHOW")){
  	type = "none";
	  //编辑和查询状态下调用新危险单位赋值
%>
<!--modify by zhulei 20050903 查看页面，按钮要灰掉-->
<body class="interface" onload="initCombineClaimPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');
    disabledAllButton('ClaimLoss_button');disabledAllButton('ClaimLoss');initSpan();">
<%
}else{
%>
<body class="interface" onload="initCombineClaimPage();initSet();initSpan();">
<%
}
int indexMainHead = 0;
int indexMainMiddle = 0;
int indexMainTail = 0;
int indexClaimEarNo = 0;
int intdexRegistAgriPerson = 0;
int indexClaimText = 0;
int indexClaimLoss = 0;
int indexRiskUnit = 0;
int idxEar = 0;
%>

   <form name=fm action="/claim/claimCombineSave.do" method="post" onsubmit="return validateForm(this);">
   
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
			<input type="radio" name="registNoShow" defaultChecked="true" onclick="spanShow();"  >
		</td>
		<td align="left">
			<a title="报案号"><%= prplcombineDto.getRegistno() %></a>
			<input type="hidden" name="registNo" value="<%= prplcombineDto.getRegistno() %>">
		</td>
		<%for(int i=0;i<3;i++){%>
		   <%if(iterator.hasNext()){
			 prplcombineDto = (PrplcombineDto)iterator.next();%>
			<td align="center">
				<input type="radio" name="registNoShow" onclick="spanShow();"  >
			</td>
			<td align="left">
				<a title="报案号"><%= prplcombineDto.getRegistno() %></a>
				<input type="hidden" name="registNo" value="<%= prplcombineDto.getRegistno() %>">
			</td>
			<%}%>
			<%}%>
			</tr>   
       <%}%>
 </table>
          
	   <%session.setAttribute("oldClaimLastAccessedTime","");%> 
	   <%Iterator iterator1 = PrplcombineDtos.iterator();
	   if(null!=iterator1){
	   %>
	   
 <input type="hidden" name="riskcode" value="<%=request.getAttribute("riskCode_0") %>">
 <input type="hidden" name="policyno" value="<%=request.getAttribute("policyNo_0") %>">
 <input type="hidden" name="nodeType" value="<%= request.getAttribute("nodeType_0")%>">
 <input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo") %>">
 <input type="hidden" name="familySplittingFlag" value="<%=request.getAttribute("familySplittingFlag_0") %>">
	<input type="hidden" name="versionType" value="<%= versionType %>">
	<input type="hidden" name="versionNo" value="<%= versionNo %>">
 <!-- <input type="hidden" name="damageStartDate" value="123"> -->
 		<%}
	   	while(iterator1.hasNext()){
	   		iterator1.next();
	   		PrpLclaimDto  prpLclaimDto = (PrpLclaimDto)request.getAttribute("prpLclaimDto_"+indexMainHead);
 			request.setAttribute("prpLclaimDto",prpLclaimDto);
	   %>
	   <span id="spanOneClaim_<%=indexMainHead%>" style = "display:none">
       
       <%-- 1.立案主头信息 --%>
       <%@include file="/combineAgri/claim/AgriClaimMainHeadEdit.jsp" %>

       <%-- 2.立案中间信息 --%>
       <%@include file="/combineAgri/claim/AgriClaimMainMiddleEdit.jsp" %>
       
       <%-- 3.立案尾信息 --%>
       <%@include file="/combineAgri/claim/AgriClaimMainTailEdit.jsp" %>
       <%--  耳标号信息 --%>
      
        <%String  familySplittingFlag = "";
        familySplittingFlag = String.valueOf(request.getAttribute("familySplittingFlag_"+indexClaimEarNo));
        if(familySplittingFlag != null && "true".equals(familySplittingFlag)){%>
        <%@include file="/combineAgri/claim/AgriClaimEarNoEdit.jsp"%>
        <%//@include file="/combineAgri/certainLoss/CombineAgriCertainLossPropEdit.jsp"%>
        <%}%>
       <%-- 4.事故者信息 --%>
       <%-- 现在国元的 奶牛保险走公共的农险程序
       <logic:equal name='prpLclaimDto' property="riskCode" value="3202">
           <%@include file="/commonAgri/regist/AgriRegistAgri3202Person.jsp"%>
       </logic:equal>
        --%>
       <logic:notEqual name="prpLclaimDto" property="riskCode" value="9999">
           <table class="common">
           <%@include file="/combineAgri/claim/AgriRegistAgriPerson.jsp"%>
           </table>
       </logic:notEqual>
        
       
       <%-- 5.立案报告 --%>
       <%@include file="/combineAgri/claim/AgriClaimTextEdit.jsp"%>

	   <%-- 6.险别估损金额信息 --%>
	    <%-- 现在国元的 奶牛保险走公共的农险程序
	   <logic:equal name='prpLclaimDto' property="riskCode" value="3202">
           <%@include file="/commonAgri/claim/Agri3202ClaimLossEdit.jsp"%>
       </logic:equal>
       --%>
       <logic:notEqual name="prpLclaimDto" property="riskCode" value="9999">
           <%@include file="/combineAgri/claim/AgriClaimLossEdit.jsp"%>
       </logic:notEqual>
        <%-- 7.指定危险单位信息 --%>
    <%
	    PubTools pubTools=new PubTools();
	    String policyInputDate =(String)request.getAttribute("policyInputDate_"+indexRiskUnit); 
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	    //用旧的危险单位信息页面 	
    %>  
       <%@include file="/combineAgri/claim/ClaimRiskUnit.jsp"%>
     <%
	    }else{ 
	    //用新的危险单位信息页面 	 	
	  %>
        <%@include file="/combineAgri/claim/ClaimNewRiskUnit.jsp"%>
     <%} %>
     </span>
     <%} %>
       <%-- 8.保存通用按钮 --%>
       <%@include file="/commonAgri/claim/AgriClaimSave.jsp"%>
       
   </form>
</body>


</html:html>
