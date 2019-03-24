<%--
****************************************************************************
* DESC       ：修复验车登记录入/修改页面
* AUTHOR     ：lixiang
* CREATEDATE ：2005-04-21
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
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>复勘登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossEdit.js"></script>
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossRepairComponentEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    String editType=request.getParameter("editType");
    String nodeType=request.getParameter("nodeType");


    if (editType.equals("SHOW")) {
%>
    <body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else {

%>
  <body class="interface" onload="initPage();initSet();initReadonly();">
<%
  }
%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="nodeType" value="<%=nodeType%>">
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>

      <td class=button ><input type="button" class=bigbutton name="message" value="撰写留言" onclick="openWinSave(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'verif',fm.prpLverifyLossClaimNo.value);"></td>
      <td class=button ><input type="button" class=bigbutton name="messageView" value="查看留言" onclick="openWinQuery('registNo',fm.RegistNo.value);"></td>
      <td class=button ><input type="button" class=bigbutton name="eCertify" value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDtoTemp' property='registNo'/>','verif')"></td>
      <td class=button ><input type="button" class=bigbutton name="buttonCertifyDirect" value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLcheckDtoTemp' property='registNo'/>','verif')"></td>

    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
      int repairFeeNo = 0;
      int componentNo = 0;
    %>
      <%-- 核损主表的画面 --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
    <%-- 1.核损环节过程的修理/换件清单页面 --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossRepairComponentEdit.jsp"%>
      <%--modify by liujianbo modify 20050315 start--%>
      <%--resson:增加物损定损--%>
      <%--modify by liujianbo modify 20050315 end--%>
 <%-- 3. 核价、核损意见、备注 --%>
        <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
      
      <%-- 4. 定核损信息补充说明 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <%-- 当是核损的时候显示备注,核损意见 --%>
<%/*      
  <table  cellpadding="1" cellspacing="1" class="common">
  <tr>      <td colspan=2 class="formtitle">修复复勘登记</td></tr>
        <tr>
          <td class="input" style="width:15%">备注:</td>
          <td class="input" style="width:85%">
            <input type="text" name="prpLverifyLossVerifyRemark" class="input" style="width:540px" value="<bean:write name='prpLverifyLossDto' property='verifyRemark'/>">
         </td>
        </tr>
        <tr>
          <td class="input" style="width:15%">案件复勘意见:</td>
          <td class="input" style="width:85%">
            <input type="text" name="prpLverifyLossBackCheckRemark" class="input" style="width:540px" value="<bean:write name='prpLverifyLossDto' property='backCheckRemark'/>">
         </td>
        </tr>

       
  </table>
  */%>
   <%-- 4.报案信息补充说明 --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
      <%-- 保存通用按钮 --%>
      <%@include file="/DAA/verifyLoss/DAABackComponentSave.jsp"%>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
