<%--
****************************************************************************
* DESC       ：核价登记录入/修改页面
* AUTHOR     ：sunchenggang
* CREATEDATE ：2006-03-07
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
<%@ page import="java.text.DecimalFormat"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<%
   
    String comLevel = (String)request.getSession().getValue("ComLevel");
    String editType = request.getParameter("editType");
    String nodeType = request.getParameter("nodeType");
   if (nodeType.equals("verpo") ){
    String    valueUpper1  = (String)request.getAttribute("valueUpper");
    double    valueUpper  = 0.00;
    valueUpper = Double.parseDouble(valueUpper1);
    System.out.println("==========  [ valueUpper  ]  =========" + valueUpper);
    }
    UserDto   user  = (UserDto)session.getAttribute("user");
%>
    
<html:html locale="true">
<head>
    <!--对title处理-->
    <title>核价登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyPrice/js/DAAVerifyPriceEdit.js"></script>
  
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
	
</head>

<%
    if (editType.equals("SHOW")) {
%>
    <body class="interface" onload="initSet();readonlyAllInput();initReadonly();disabledAllButton('buttonArea');showButton();">
    <script language="JavaScript">
      function showButton(){
        fm.buttonCancel.disabled=false;
      }    
    </script>
<%
  } else {
    if (nodeType.equals("backc")) {
%>
  <body class="interface" onload="initSet();initReadonly();">
<%
    }else{
%>
  <body class="interface" onload="initVeriPrice();initSet();initReadonly();">
<%
    }
  }
%>

  <form name="fm" action="/claim/verifyPriceSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="nodeType" value="<%=nodeType%>">
    <input type="hidden" name="comLevel" value="<%=comLevel%>">

    <input type="hidden" name="prpLclaimGradeSglCusCompP" value="<bean:write name='prpLclaimGradeDto1' property='valueUpper'/>">
    <input type="hidden" name="prpLclaimGradeSglCarCusCompP" value="<bean:write name='prpLclaimGradeDto2' property='valueUpper'/>">
    <input type="hidden" name="prpLclaimGradeSglCarAllCompP" value="<bean:write name='prpLclaimGradeDto3' property='valueUpper'/>">
    <input type="hidden" name="prpLverifyLossVerifyPriceOuterMsg" value="<bean:write name='prpLverifyLossDto' property='verifPriceOuterMsg'/>">
    
  
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>
      <td class=button ><input type="bigbutton" name="message" class=button value="撰写留言" onclick="openWinSave(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'verip',fm.prpLverifyLossClaimNo.value);"></td>
      <td class=button ><input type="bigbutton" name="messageView" class=button value="查看留言" onclick="openWinQuery('registNo',fm.RegistNo.value);"></td>
      <td class=button ><input type="bigbutton" name="eCertify" class=bigbutton value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDtoTemp' property='registNo'/>','verip')"></td>

       <td><input type="button" name="buttonCertifyDirect" class=bigbutton value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLcheckDtoTemp' property='registNo'/>','verif')"></td>

    </tr>
  </table>

    <%!
      int indexCertainLoss = 0;
      int repairFeeNo = 0;
      int componentNo = 0;
      String flag = null;
    %>
    <%
      flag = request.getParameter("flag");
    %>
    
    <%-- 1. 核价主表的画面 --%>
      <%@include file="/DAA/verifyPrice/DAAVerifyPriceMainEdit.jsp"%>
  
    <%-- 2. 核价环节过程的修理/换件清单页面 --%>
      <%@include file="/DAA/certainLoss/DAARepairComponentMainEdit.jsp"%>
    
    <%-- 3. 显示核价意见 --%>            
      <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>

    <%-- 4. 定核损信息补充说明 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>

    <%-- 5. 报案信息补充说明 --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>

    <%-- 6. 保存通用按钮 --%>
      <%@include file="/DAA/verifyPrice/DAAVerifyPriceSave.jsp"%>

  </form>
</body>

</html:html>
