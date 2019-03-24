<%@	page contentType="text/html; charset=GB2312"	language="java"	%>
<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-13
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>     

<html:html locale="true">
<head>
    <!--��title����-->
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/certainLoss/js/DAACertainLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAACertainLossRepairComponentEdit.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
	<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<%
//start ��ֹ�ظ��ύ---------------------
    session.setAttribute("oldCertainLossLastAccessedTime","");
    //Reason:ȡ����Ա������ҵ��Ȩ��
    PrpLclaimGradeDto prpLclaimGradeDto = (PrpLclaimGradeDto)request.getAttribute("prpLclaimGradeDto");
    UserDto   user      = (UserDto)session.getAttribute("user");  
    boolean isShowButton = true;
    //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
    if(user == null){
        isShowButton = false;
    }
    String strPrpLclaimGradeFlag = "";
    double prpLclaimGradeValueLower = 0;
    double prpLclaimGradeValueUpper = 0;
    if(prpLclaimGradeDto==null)
    {
      strPrpLclaimGradeFlag = "1";
    }
    else 
    {
      prpLclaimGradeValueLower = prpLclaimGradeDto.getValueLower();
      prpLclaimGradeValueUpper = prpLclaimGradeDto.getValueUpper();
    }

    //Modify by chenrenda add end 20050418
    String editType=request.getParameter("editType");
%>
<%
    if (editType.equals("SHOW")) {
%>
    <body  onload="initPage();initSet();readonlyAllInput();">
<%
  //Modify by chenrenda update begin 20050317
  //Reason:������Ŀ��������ʱĬ����3��
  } else if(editType.equals("ADD")){
	
%>
    <body  onload="initPage();initSet();">
<%
    
    }
  //Modify by chenrenda update end 20050317
    else
    {
%>
    <body  onload="initPage();initSet();">
<%
    }
%>

  <form name="fm" action="/claim/certainLossSave.do" method="post" onsubmit="return validateForm(this);">

      <%--Modify by chenrenda add begin 20050418--%>
      <input type="hidden" name="prpLclaimGradeValueLower" value="<%=prpLclaimGradeValueLower%>">
      <input type="hidden" name="prpLclaimGradeValueUpper" value="<%=prpLclaimGradeValueUpper%>">
      <input type="hidden" name="prpLclaimGradeFlag" value="<%=strPrpLclaimGradeFlag%>">
      <%--Modify by chenrenda add end 20050418--%>
      <%
     String certainLossFirst = (String)request.getAttribute("prplCertianLossFirst");
%>
    <input type="hidden" name="certainLossFirst" value="<%=certainLossFirst%>">

  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="riskcode" value="<bean:write name='prpLregistDto' property='riskCode'/>">
  <input type="hidden" name="policyno" value="<bean:write name='prpLregistDto' property='policyNo'/>">
  <table  class="common">
    <tr>
    <%if(isShowButton){ %>
      <td><input type="button" class=bigbutton name="message" value="���⹵ͨ" onclick="openWinSaveQuery(fm.RegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'certa',fm.prpLverifyLossClaimNo.value,'registNo',fm.RegistNo.value);"></td>
    <%} %>  
      <td><input type="button" class=bigbutton name="eCertify" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLregistDto' property='registNo'/>','certa');"></td>
      <td><input type="button" class="bigbutton" name="buttonCertifyDirect" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLregistDto' property='registNo'/>','certa')"></td>
    </tr>
  </table>
  <table class=common cellpadding="5" cellspacing="1">
  <tr> <td class="formtitle">����Ǽ�</td></tr>
  </table>
    <%!
      int indexCertainLoss = 0;
      int repairFeeNo = 0;
      int componentNo = 0;
      String flag = null; // �ж��Ƿ�����˻�ҵ���˻�Flag  = 1
    %>
    <%
      flag = request.getParameter("flag");
    %>

      <%-- ��������Ļ��� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossMainEdit.jsp"%>
      <%-- 1.���𻷽ڹ��̵�����/�����嵥ҳ�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossRepairComponentEdit.jsp"%>
      <%-- 3. �˼ۡ������������ע --%>
      <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
      <%-- 4. ��������Ϣ����˵�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <%-- 5.������Ϣ����˵�� --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
      <%if (editType.equals("SHOW")){%>
  		<table cellpadding="0" cellspacing="0" width="80%" class="common">
	 		<tr><%-- ֻ��ʾ���ذ�ť--%>
				<td>
	        <input  type="hidden" name=buttonSaveType value="1"> 
		    </td>
			</tr>  
  		<tr>  
     	 	<td class=button style="width:33%" align="center">
			  <!--ȡ����ť-->
			    <input type=button name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >
			  </td> 
			</tr>
		</table>  
	<%
	  }else{
	%> 
      <%@include file="/DAA/certainLoss/DAACertainLossSave.jsp"%>
  <%
  	}
  %>
      <input type="hidden" name="lossTypeFlag" value="<%= request.getParameter("lossTypeFlag")%>">
      <%-- ��ӡ�����嵥����ʧȷ���� �����鶨�𱨸� --%>
      <%//@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"%>
  </form>
</body>
</html:html>




