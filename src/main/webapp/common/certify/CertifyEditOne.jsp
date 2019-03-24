<%--
****************************************************************************
* DESC       ����֤�Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-05
* MODIFYLIST ��   Name       Date            Reason/Contents
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
<%@page import="com.sinosoft.utiall.dbsvr.*"%>
<%@page import="com.sinosoft.image.bl.facade.*"%>
<%@page import="com.sinosoft.image.dto.domain.*"%>
<%@page import="com.sinosoft.sysframework.reference.AppConfig"%> 


<html>
  <head>
    <!--��title����-->
    <title>��֤�Ǽ�</title>
    <%-- ҳ����ʽ  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/common/certify/js/CertifyEdit.js"></script>

    <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
   <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <SCRIPT LANGUAGE="JavaScript">
  <!--
  /**
  *@description ��ʼ���ط���ѯ��Ϣ
  *@param       ��
  *@return      ͨ������true,���򷵻�false
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
	//String ECM_URL =  AppConfig.get("sysconst.ECM_URL");
   //reason: ��ֹ�ظ��ύ
   session.setAttribute("oldCompensateLastAccessedTime","");
   String editType = request.getParameter("editType");
   String combineNo = request.getParameter("combineNo");
   if(editType.equals("SHOW")||editType.equals("DELETE")){
%>
<body class=interface  onload="initPage();initSet();readonlyAllInput();">
<%}else{ %>
<body class=interface  onload="initPage();initSet();">
<%}%>
  <form name=fm action="/claim/certifyOneSave.do" method="post" onsubmit="return validateForm(this);">
  <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
  <input type="hidden" name="combineNo" value="<%= combineNo%>">
  <%-- 1.��֤����Ϣ --%>
  <%@include file="/common/certify/NewCertifyMainEditOne.jsp" %>
  <%-- 2.��֤����Ϣ --%>
  <%@include file="/common/certify/PrpLqualityCheckEdit.jsp" %>
        <%-- 4.������Ϣ����˵�� --%>
            <%@include file="/common/regist/RegistExtEdit.jsp"%>
<%
  String nodeType1=request.getParameter("nodeType");
  if(nodeType1.equals("check")||nodeType1.equals("certa")||nodeType1.equals("verif")){
%>
  <table cellpadding="0" cellspacing="0"  class="common">
    <tr>
      <td class=button style="width:20%" align="center">
        <!--���水ť-->
        <input type="button" name=buttonSave class='button' value="�ر�" onclick="javascript:window.close();">
      </td>
    </tr>
  </table>
<%
  }else{
%>
  <%-- ����ͨ�ð�ť --%>
  <%--<%@include file="/common/certify/CertifySaveOne.jsp" %>--%>

<%
  }
%>
  </form>
   <form name="fm2" method="post">
   <%--  <form name="fm2" method="post" target="_bank" action = "<%=ECM_URL%>"> --%>
<div>
 <input type="hidden" name="format" value="xml">
 <input type="hidden" name="code" value ="<%=code%>">
 <input type="hidden" name="xml" id="xml" value ="">
</div>
</form>
</body>
</html>