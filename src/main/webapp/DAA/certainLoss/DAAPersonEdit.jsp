
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
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>定损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossPersonEdit.js"></script>
  <%--   modify by wangli add start 20050401 --%>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <%--   modify by wangli add end 20050401 --%>

  <script>
	<!--
    /**
     *@description 设置伤情信息表的初始值
     *@param       无
     *@return      通过返回true,否则返回false
     */
  	function loadPrpLpersonWound(){
<%

   //start 防止重复提交---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
   //end---------------------------------------------
   
      PrpLpersonWoundDto prpLpersonWoundDto = (PrpLpersonWoundDto)request.getAttribute("prpLpersonWoundDto");
      List woundListTemp = (ArrayList)prpLpersonWoundDto.getWoundList();
      if(woundListTemp!=null){
        for(int i=0;i<woundListTemp.size();i++){
          PrpLpersonWoundDto prpLpersonWoundDtoTemp = (PrpLpersonWoundDto)woundListTemp.get(i);
%>
          //
          fm.all("woundCodeCheck<%= prpLpersonWoundDtoTemp.getWoundCode()%>")[<%= prpLpersonWoundDtoTemp.getPersonNo()%>].checked=true;
          fm.all("woundCodeCheck<%= prpLpersonWoundDtoTemp.getWoundCode()%>Txt")[<%= prpLpersonWoundDtoTemp.getPersonNo()%>].value="1";

<%
        }
      }
%>
      return true;
  	}
  	-->
  </script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    String editType=request.getParameter("editType");
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
    if(userDto == null){
        isShowButton = false;
    }
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadPrpLpersonWound();">
<%
  } else {
%>
    <body  onload="initPage();initSet();loadPrpLpersonWound();">
<%
    }
%>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="riskcode" value="<bean:write name='prpLregistDto' property='riskCode'/>">
  <input type="hidden" name="policyno" value="<bean:write name='prpLregistDto' property='policyNo'/>">
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>
    <%if(isShowButton){ %>
      <td class=button ><input type="button"  class=bigbutton name="message" value="理赔沟通" onclick="openWinSaveQuery(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'certa',fm.prpLverifyLossClaimNo.value,'registNo',fm.RegistNo.value);"></td>
    <%} %>  
      <td class=button><input type="button" class=bigbutton name="eCertify" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo',fm.prplCheckRegistNoShow.value,'certa');"></td>

      
      </tr>
      <table>
        <table class=common cellpadding="5" cellspacing="1">
          <tr>

            <td class="formtitle">定损登记</td>

          </tr>
        </table>

       <!-- Modify By wangli add begin 20050328-->

    <%--
      <td><input type="button" name="message" value="讨论留言" onclick="openWinSave()"></td><td><input type="button" name="messageView" value="查看留言" onclick="openWinQuery()"></td><td><input type="button" name="eCertify" value="电子单证" onClick="openCertify()"></td><td width="70%" align="right"><font color="#666666">　注：“<font color="#FF0000">*</font>”为必选项，“<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">”
      为双击选择项。</font>
      </td>
    --%>
     <!-- Modify By wangli add end 20050328-->

    <%!
      int indexCertainLoss = 0;
      String flag = null;
    %>
    <%
      flag = request.getParameter("flag");
    %>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">

      <%-- 定损主表的画面 --%>
        <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp"%>
      <%-- 1.人员伤亡清单页面 --%>
        <%@include file="/DAA/certainLoss/DAACertainLossPersonEdit.jsp"%>
       <logic:equal name="prpLverifyLossDto" property="lossItemCode" value="0">
<%
  String reStatus = request.getParameter("status");
  if(reStatus!=null&&reStatus.trim().equals("3")){
%>
      <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
        <tr>
          <td class="title2" >回退的原因:</td>
          <td class="input2" >
            <input name="prpLverifyLossVeriwReturnReason" class="readonly" readonly  value="<bean:write name='prpLverifyLossDto' property='veriwReturnReason'/>">
          </td>
        </tr>
      </table>
<%
  }
%>
      </logic:equal>

      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossSave.jsp"%>

  
     <!--modified by wangli add start 20050329-->
      <%-- 打印定损清单、损失确认书 及检验定损报告 --%>
    <!-- <%@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"%>-->
      <!--modified by wangli add end 20050329-->
 
  </form>
</body>
<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>




