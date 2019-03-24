<%--
****************************************************************************
* DESC       ���޸��鳵�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2005-04-21
* MODIFYLIST ��   Name       Date            Reason/Contents
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
    <!--��title����-->
    <title>�����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
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

      <td class=button ><input type="button" class=bigbutton name="message" value="׫д����" onclick="openWinSave(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'verif',fm.prpLverifyLossClaimNo.value);"></td>
      <td class=button ><input type="button" class=bigbutton name="messageView" value="�鿴����" onclick="openWinQuery('registNo',fm.RegistNo.value);"></td>
      <td class=button ><input type="button" class=bigbutton name="eCertify" value="���ӵ�֤" onClick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo','<bean:write name='prpLcheckDtoTemp' property='registNo'/>','verif')"></td>
      <td class=button ><input type="button" class=bigbutton name="buttonCertifyDirect" value="�����嵥" onClick="doCertifyDirect('<bean:write name='prpLcheckDtoTemp' property='registNo'/>','verif')"></td>

    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
      int repairFeeNo = 0;
      int componentNo = 0;
    %>
      <%-- ��������Ļ��� --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
    <%-- 1.���𻷽ڹ��̵�����/�����嵥ҳ�� --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossRepairComponentEdit.jsp"%>
      <%--modify by liujianbo modify 20050315 start--%>
      <%--resson:����������--%>
      <%--modify by liujianbo modify 20050315 end--%>
 <%-- 3. �˼ۡ������������ע --%>
        <%@include file="/DAA/certainLoss/DAACertainLossOpinion.jsp"%>
      
      <%-- 4. ��������Ϣ����˵�� --%>
      <%@include file="/DAA/certainLoss/DAACertainLossExtEdit.jsp"%>
      <%-- ���Ǻ����ʱ����ʾ��ע,������� --%>
<%/*      
  <table  cellpadding="1" cellspacing="1" class="common">
  <tr>      <td colspan=2 class="formtitle">�޸������Ǽ�</td></tr>
        <tr>
          <td class="input" style="width:15%">��ע:</td>
          <td class="input" style="width:85%">
            <input type="text" name="prpLverifyLossVerifyRemark" class="input" style="width:540px" value="<bean:write name='prpLverifyLossDto' property='verifyRemark'/>">
         </td>
        </tr>
        <tr>
          <td class="input" style="width:15%">�����������:</td>
          <td class="input" style="width:85%">
            <input type="text" name="prpLverifyLossBackCheckRemark" class="input" style="width:540px" value="<bean:write name='prpLverifyLossDto' property='backCheckRemark'/>">
         </td>
        </tr>

       
  </table>
  */%>
   <%-- 4.������Ϣ����˵�� --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%>
      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/verifyLoss/DAABackComponentSave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
