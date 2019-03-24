<%--
****************************************************************************
* DESC       ：立案登记录入/修改页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-04-14
* MODIFYLIST ：   Name       Date            Reason/Contents
                  liubvo     2004/07/02      去掉了估损金额信息画面，修改了格式
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.prpall.pubfun.*"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="java.util.Map" %>

<%  
 Map mapList =(Map)request.getAttribute("mapList");
 RegistDto registDto =(RegistDto)request.getAttribute("registDto"); 
 ArrayList  lossKindCode = (ArrayList)request.getAttribute("lossKindCode"); 
 ArrayList  lossModeCode = (ArrayList)request.getAttribute("lossModeCode"); 
 String policyInputDate =(String)request.getAttribute("policyInputDate"); 
 String isShow = request.getParameter("isShow");//再保危险单位用到

%>

<script language="JavaScript">
<!--
	javascript:window.history.forward(1);
//-->
</script>

<html:html locale="true">
<head>
  <!--对title处理-->
  <title>立案处理</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/claim/js/DAAClaimEdit.js"></script>
  <script src="/claim/DAA/regist/js/DAAThirdCarLossEdit.js"></script>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

  <script language="javascript">
  
  function oninitSum()
  {
    var sum = 0;
    var kindloss = 0;
    for(i=0;i<fm.all("prpLclaimLossSumClaim").length;i++){
     
      if(fm.all("prpLclaimLossSumClaim")[i].value>0){
        sum = sum+parseFloat(fm.all("prpLclaimLossSumClaim")[i].value);
      }
       if(fm.all("prpLclaimLossKindLoss")[i].value>0){
        kindloss = kindloss+parseFloat(fm.all("prpLclaimLossKindLoss")[i].value);
      }
    }

        fm.prpLclaimSumClaim.value=pointTwo(kindloss);
        fm.prpLdangerRiskSumClaim.value=pointTwo(sum);
     
  }
</script>

<%
  String editType=request.getParameter("editType");
  //编辑和查询状态下调用新危险单位赋值
  if (editType.equals("SHOW")){
%>
<body class="interface" onload="initPage();initSet();dutySum();oninitSum();readonlyAllInput();disabledAllButton('buttonArea');showButton();loadDangerUnit();">
<%
}else if(editType.equals("EDIT")){
%>
<body class="interface" onload="loadDangerUnit();">
<%
}
else{
%>
<body class="interface" onload="initPage();initSet();oninitSum();dutySum();">
<%
}
%>
    <form name=fm action="/claim/claimSave.do" method="post" onsubmit="return validateForm(this);">
    <%session.setAttribute("oldClaimLastAccessedTime","");%>

      <%-- 1.立案主信息 --%>
      <%@include file="/DAA/claim/DAAClaimMainEdit.jsp" %>

      <%-- 2.估损金额信息 --%>
      <%// @include file="/DAA/claim/DAAClaimFeeEdit.jsp" --%>


      <%-- 3.添加单证 --%>
      <%//@include file="/DAA/claim/DAAClaimDocEdit.jsp"%>

      

      <%-- 2.特别约定 --%>
      <%@include file="/DAA/compensate/DAACompensateCengage.jsp"%>

      <%-- 4.涉案车辆 --%>
      <%@include file="/DAA/claim/DAAClaimThirdPartyEdit.jsp"%>

      <%-- 财产损失部位信息 --%>
      <%@include file="/DAA/regist/DAARegistThirdPropEdit.jsp"%>

     <%--添加人伤跟踪信息 2005-07-26--%>      
      <%@include file="/DAA/claim/DAASelfClaimPersonTraceEdit.jsp"%>

      <%-- 5.驾驶员信息 --%>
      <%@include file="/DAA/claim/DAAClaimDriverEdit.jsp"%>

      <%-- 6.立案报告 --%>
      <%@include file="/DAA/claim/DAAClaimTextEdit.jsp"%>

	  <!--modify by liyanjie 从特别约定前移至此处
	  <!--modify by wangwei add start 2005-06-06-->
      <!--原因：添加巨灾代码信息-->
      <%@include file="/DAA/claim/PropClaimKelpInfo.jsp"%>
      <!--modify by wangwei add end 2005-06-06-->
      
      <%-- 2.险别估损金额信息 --%>
      <%@include file="/DAA/claim/DAAClaimLossEdit.jsp"%>

      <%-- 8.理赔联系记录 2005-07-18 --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
      <%-- 9.指定危险单位信息 --%>
      <%
	    PubTools pubTools=new PubTools();
	    int time= pubTools.compareDate(policyInputDate,"2011-02-27");
	    if(time<0){
	    //用旧的危险单位信息页面
    %>  
       <%@include file="/common/claim/ClaimRiskUnit.jsp"%>
     <%
	    }else{ 
	    //用新的危险单位信息页面
	  %>
        <%@include file="/common/claim/ClaimNewRiskUnit.jsp"%>
     <%} %>
      <%-- 保存通用按钮 --%>
       <%@include file="/DAA/claim/DAAClaimSave.jsp"%>
       <%-- 案件互查返回按鈕--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="关闭"/>
              </center>
        </c:if>

 </form>

</body>
</html:html>
<%--不需要了
<script language="JavaScript">
    <!--
	var compAmout =0;
	var nowAmout =0;


	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 		{
 			nowAmout =parseFloat(fm.prpLclaimLossSumClaim[n].value)
			compAmout = compAmout + nowAmout;
    }

	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
    fm.prpLdangerRiskSumClaim.value=pointTwo(compAmout);
-->
</script>
--%>