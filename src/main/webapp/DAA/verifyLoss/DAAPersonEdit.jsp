<%--
****************************************************************************
* DESC       ������Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-13
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

<html:html locale="true">
<head>
    <!--��title����-->
    <title>����Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/verifyLoss/js/DAAVerifyLossEdit.js"></script>
  <script src="/claim/DAA/certainLoss/js/DAAVerifyLossPersonEdit.js"></script>
  <script>
	<!--
    /**
     *@description ����������Ϣ��ĳ�ʼֵ
     *@param       ��
     *@return      ͨ������true,���򷵻�false
     */
  	function loadPrpLpersonWound(){
<%
      PrpLpersonWoundDto prpLpersonWoundDto = (PrpLpersonWoundDto)request.getAttribute("prpLpersonWoundDto");
      List woundListTemp = (ArrayList)prpLpersonWoundDto.getWoundList();
      if(woundListTemp!=null){
        for(int i=0;i<woundListTemp.size();i++){
          PrpLpersonWoundDto prpLpersonWoundDtoTemp = (PrpLpersonWoundDto)woundListTemp.get(i);
%>
          //
          fm.all("woundCodeCheck<%= prpLpersonWoundDtoTemp.getWoundCode()%>")[<%= prpLpersonWoundDtoTemp.getPersonNo()%>].checked=true;
          fm.all("woundCodeCheck<%= prpLpersonWoundDtoTemp.getWoundCode()%>")[<%= prpLpersonWoundDtoTemp.getPersonNo()%>].disabled=true;
          fm.all("woundCodeCheck<%= prpLpersonWoundDtoTemp.getWoundCode()%>Txt")[<%= prpLpersonWoundDtoTemp.getPersonNo()%>].value="1";

<%
        }
      }
%>

      //return true;
  	}
  	-->
  </script>
    <script src="/claim/common/js/SimpleCalendar.js"></script>
	<META	http-equiv="Content-Type"	content="text/html;	charset=GB2312">
</head>

<%
  String editType=request.getParameter("editType");
  String nodeType=request.getParameter("nodeType");	
  String swflogflowId = request.getParameter("swfLogFlowID");
  if(null==swflogflowId){
	  swflogflowId = (String)request.getAttribute("swfLogFlowID");
  }
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');loadPrpLpersonWound();">
<%
}else
{
%>
<body class="interface" onload="initPage();initSet();loadPrpLpersonWound();">

<%
}

%>

  <form name="fm" action="/claim/verifyLossSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <input type="hidden" name="nodeType"              value="<%=nodeType%>">             
  <table cellpadding="5" cellspacing="1" class="common">
    <tr>

     <!-- Modify By wangli add begin 20050328-->
      <td class=button ><input type="button" class="bigbutton" name="message" value="���⹵ͨ" onclick="openWinSaveQuery(fm.prpLverifyLossRegistNo.value,fm.prpLverifyLossPolicyNo.value,fm.prpLverifyLossRiskCode.value,'verif',fm.prpLverifyLossClaimNo.value,'registNo',fm.RegistNo.value);"></td>
      <td class=button ><input type="button" class="bigbutton" name="message" value="���ӵ�֤" onclick="openCertify('certifyFinishQueryList','prpLcertifyCertifyNo',fm.RegistNo.value,'certa');"></td>
      <td class=button ><input type="button" class="bigbutton" name="buttonswfFlow" value="���̲�ѯ" onClick="doswfFlowQuery('<%=swflogflowId%>')"></td>
      <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">��
      Ϊ˫��ѡ���</font>
      </td>
      <%--
      <td><input type="button" name="message" value="��������" onclick="openWinSave()"></td><td><input type="button" name="messageView" value="�鿴����" onclick="openWinQuery()"></td><td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">��
      Ϊ˫��ѡ���</font>
      </td>
      --%>
       <!-- Modify By wangli add end 20050328-->
    </tr>
  </table>

    <%!
      int indexVerifyLoss = 0;
    %>
      <%-- ��������Ļ��� --%>
        <%@include file="/DAA/verifyLoss/DAAVerifyLossMainEdit.jsp"%>
    <%-- 1.��Ա�����嵥ҳ�� --%>
    <%@include file="/DAA/verifyLoss/DAAVerifyLossPersonEdit.jsp"%>

      <%-- �������˺����ʱ����ʾ���˵�ԭ�� --%>
      <logic:equal name="prpLverifyLossDto" property="lossItemCode" value="0">
      <table border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
        <tr><td colspan=2 class="formtitle">����Ǽ�</td></tr>
        <tr>
          <td class="input" style="width:20%">���˵�ԭ��:</td>
          <td class="input" style="width:80%">
            <input name="prpLverifyLossVeriwReturnReason" class="input" style="width:640px" maxLength="255" onblur="checkLength1(this);" description="���˵�ԭ��" value="<bean:write name='prpLverifyLossDto' property='veriwReturnReason'/>">
          </td>
        </tr>
      </table>
      </logic:equal>

      <%-- ����ͨ�ð�ť --%>
      <%@include file="/DAA/verifyLoss/DAAVerifyLossSave.jsp"%>
      <!--modified by wangli add start 20050329-->
      <%-- ��ӡ�����嵥����ʧȷ���� �����鶨�𱨸� --%>
     <%--@include file="/DAA/certainLoss/DAACertainLossPrint.jsp"--%>
      <!--modified by wangli add end 20050329-->
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
