<%--
****************************************************************************
* DESC       ：单证登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-05
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="java.util.*" %>
<%@page import="com.sinosoft.prpall.blsvr.cb.BLPrpCmain"%>
<%@page import="com.sinosoft.prpall.schema.PrpCmainSchema"%>

<html>
  <head>
    <!--对title处理-->
    <title>单证登记</title>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/common/certify/js/CertifyEdit.js"></script>

    <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
   <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <SCRIPT LANGUAGE="JavaScript">
  <!--
  /**
  *@description 初始化回访问询信息
  *@param       无
  *@return      通过返回true,否则返回false
  */
  function initSet(){
<%
    ArrayList prpLqualityCheckDtoList = (ArrayList)request.getAttribute("prpLqualityCheckList");
    if(prpLqualityCheckDtoList!=null&&prpLqualityCheckDtoList.size()>0){
      for (int i = 0; i < prpLqualityCheckDtoList.size(); i++) {
        PrpLqualityCheckDto prpLqualityCheckDto = (PrpLqualityCheckDto)prpLqualityCheckDtoList.get(i);
        if(prpLqualityCheckDto.getCheckResult().equals("0")){
%>
          fm.VisitBackQue<%= i+1 %>[1].checked=true;
<%
        } else if(prpLqualityCheckDto.getCheckResult().equals("1")){
%>
          fm.VisitBackQue<%= i+1 %>[0].checked=true;
<%
        } else if(prpLqualityCheckDto.getCheckResult().equals("2")){
%>
          fm.VisitBackQue<%= i+1 %>[2].checked=true;
<%
        }
%>
          fm.txtQuestionRemark<%= i+1 %>.value='<%= prpLqualityCheckDto.getCheckRemark() %>';
<%
      }
    }
%>
  return true;
  }
  //-->
  </SCRIPT>
  </head>
<%  
   //reason: 防止重复提交
   session.setAttribute("oldCompensateLastAccessedTime","");
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
   String editType = request.getParameter("editType");
   
   if(editType.equals("SHOW")||editType.equals("DELETE")){
%>
<body class=interface  onload="initPage();initSet();readonlyAllInput();">
<%}else{ %>
<body class=interface  onload="initPage();initSet();">
<%}%>
  <form name=fm action="/claim/certifyCombineSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="combineNo" value="<%= request.getParameter("combineNo") %>">
	<input type="hidden" name="versionType" value="<%= versionType %>">
	<input type="hidden" name="versionNo" value="<%= versionNo %>">
  <%-- 1.单证主信息 --%>
  <%@include file="/common/certify/CertifyMainEditCombine.jsp" %>
  <%-- 2.单证主信息 --%>
  <%@include file="/common/certify/PrpLqualityCheckEdit.jsp" %>
        <%-- 4.报案信息补充说明 --%>
    <%--    <%@include file="/common/regist/RegistExtEdit.jsp"%> --%>
<%
  String nodeType1=request.getParameter("nodeType");
  if(nodeType1.equals("check")||nodeType1.equals("certa")||nodeType1.equals("verif")){
%>
  <table cellpadding="0" cellspacing="0"  class="common">
    <tr>
      <td class=button style="width:20%" align="center">
        <!--保存按钮-->
        <input type="button" name=buttonSave class='button' value="关闭" onclick="javascript:window.close();">
      </td>
    </tr>
  </table>
<%
  }else{
%>
  <%-- 保存通用按钮 --%>
  <%@include file="/common/certify/CertifySaveCombine.jsp" %>

<%
  }
%>
  </form>
</body>
</html>
