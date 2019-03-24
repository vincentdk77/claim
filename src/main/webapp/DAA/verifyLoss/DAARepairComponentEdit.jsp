<%--
****************************************************************************
* DESC       ：核损登记录入/修改页面
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
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>核损登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAAVerifyLossRepairComponentEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
    String editType=request.getParameter("editType");
    String nodeType=request.getParameter("nodeType");
    String swflogflowId = request.getParameter("swfLogFlowID");
    if(null==swflogflowId){
  	  swflogflowId = (String)request.getAttribute("swfLogFlowID");
    }
    UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
    if(userDto == null){
        isShowButton = false;
    }
    if (editType.equals("SHOW")) {
%>
    <body class="interface" onload="initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  } else {
    if (nodeType.equals("backc")) {
%>
  <body class="interface" onload="initSet();initReadonly();">
<%
    }else{
%>
  <body class="interface" onload="initSet();">
<%
    }
  }
%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
 <input type="hidden" name="nodeType" value="<%=nodeType%>">
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>
    <%if(isShowButton){ %>
      <td class=button ><input type="button" class =bigbutton name="message" class=button value="理赔沟通" onclick="openWinSaveQuery(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'verif',fm.prpLverifyLossClaimNo.value,'registNo',fm.RegistNo.value);"></td>
    <%} %> 
      <td class=button ><input type="button" class =bigbutton name="eCertify" class=bigbutton value="电子单证" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','verif')"></td>
     <%--
      <td><input type="button" name="message" value="讨论留言" onclick="openWinSave()"></td>
      <td><input type="button" name="messageView" value="查看留言" onclick="openWinQuery()"></td>
      <td><input type="button" name="eCertify" value="电子单证" onClick="openCertify('<bean:write name='prpLcheckDtoTemp' property='registNo'/>')"></td>
      --%>
       <!-- Modify By wangli add end 20050328-->
       <td><input type="button" class =bigbutton name="buttonCertifyDirect" class=bigbutton value="索赔清单" onClick="doCertifyDirect('<bean:write name='prpLregistDto' property='registNo'/>','verif')"></td>
	   <td><input type="button" class="bigbutton" name="buttonswfFlow" value="流程查询" onClick="doswfFlowQuery('<%=swflogflowId%>')"></td>
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
    <%-- 当是核损的时候显示备注,核损意见 --%>
   <%-- 3. 核价、核损意见、备注 --%>
        <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
      
      <%-- 4. 定核损信息补充说明 --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>

      <%-- 当是核损的时候显示备注,核损意见 --%>
  <table cellpadding="5" cellspacing="1" class="common" >
        <%-- 4.报案信息补充说明 --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
  </table>
  
      <%-- 保存通用按钮 --%>
            <%if (editType.equals("SHOW")){%>
        <table cellpadding="5" cellspacing="1" class=common  id="buttonArea">
	 		<tr><%-- 只显示返回按钮--%>
				<td>
	        <input  type="hidden" name=buttonSaveType value="1"> 
		    </td>
			</tr>  
  		<tr>  
     	 	<td class=button style="width:33%" align="center">
			  <!--取消按钮-->
			    <input type=button name=buttonBack class='button' value="返回" onclick="javascript:history.go(-1);" >
			  </td> 
			</tr>
		</table>  
	<%
	  }else{
	%> 
      <%@include file="/DAA/verifyLoss/DAAVerifyLossSave.jsp"%>
   <%
  	}
   %>
      <!--modified by wangli add start 20050329-->
      <%-- 打印定损清单、损失确认书 及检验定损报告 --%>
     <%//@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"%>
      <!--modified by wangli add end 20050329-->
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
