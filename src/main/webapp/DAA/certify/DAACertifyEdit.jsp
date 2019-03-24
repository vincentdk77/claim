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
<%@ page import="com.sinosoft.claim.ui.control.action.UICodeAction" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.image.bl.facade.*"%>
<%@page import="com.sinosoft.image.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%> 

<html>
  <head>
    <!--对title处理-->
    <title>单证登记</title>
    <%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/DAA/certify/js/DAACertifyEdit.js"></script>

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
<!--<body class=interface  onload="initPage();initSet();">-->
<%  
 //  String ECM_URL =  AppConfig.get("sysconst.ECM_URL");
   session.setAttribute("oldCompensateLastAccessedTime","");	
   String editType = request.getParameter("editType");
   if(editType.equals("SHOW")||editType.equals("DELETE")){
%>
<body class=interface  onload="initPage();initSet();readonlyAllInput();">
<%}else{ %>
<body class=interface  onload="initPage();initSet();">
<%}%>
  <form name=fm action="/claim/certifySave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">

  <%-- 1.单证主信息 --%>
  <%@include file="/DAA/certify/NewDAACertifyMainEdit.jsp" %>
  <%-- 2.单证主信息 --%>
  <%@include file="/DAA/certify/DAAPrpLqualityCheckEdit.jsp" %>
        <%-- 4.报案信息补充说明 --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
<%
  String nodeType1=request.getParameter("nodeType");
  if(nodeType1.equals("check")||nodeType1.equals("claim") || nodeType1.equals("certa")||nodeType1.equals("verif")){
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
  <%@include file="/DAA/certify/DAACertifySave.jsp" %>

<%
  }
%>
  </form>
  <form name="fm2" method="post">
    <%-- <form name="fm2" method="post" target="_bank" action = "<%=ECM_URL%>"> --%>
<div>
 <input type="hidden" name="format" value="xml">
 <input type="hidden" name="code" value ="<%=code%>">
 <input type="hidden" name="xml" id="xml" value ="">
</div>
</form>
</body>
</html>
