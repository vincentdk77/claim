<%--
****************************************************************************
* DESC       ��������ѯ�������ҳ��
* AUTHOR     ��lijiyuan
* CREATEDATE ��2004-03-01
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%
    //modify by wangwei add start 2005-06-04
    //ԭ����ҳ��������һ����ӡ��ť
%>
  <script language="javascript">
  <%--����״̬��־����--%>
    function submitForm()
    {
      fm.submit();//�ύ
    }
  </script>
<!--modify by wangwei add end 2005-06-04-->

<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
  <html:base/>
</head>

<body >
<form name="fm" action="/claim/processLinkRecord.do"  method="post" >
        <input type="hidden" name="pageFlag">
        <input type="hidden" name="editType" value="queryList">
        <input type="hidden" name="nodeType" value="claim">
	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
	  <tr>
	    <td width="184" height="26" valign="bottom">
	      <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
	        <tr>
	          <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td colspan=4 class="formtitle">������ϵ��¼��ѯ</td>
	          <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	    </td>
	    <td valign="bottom"><font color="#666666">&nbsp;</td>
	  </tr>
	</table>
    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">

    <tr>
        <td class='title' ><bean:message key="db.prpLclaim.claimNo" />��</td>
        <td class='input' >
        <select class=tag name="ClaimNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="input" >
        </td>
        <td class='title' ><bean:message key="db.prpLclaim.policyNo" />��</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>

      </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLclaim.registNo" />��</td>
        <td class='input' >
        <select class=tag name="RegistNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />��</td>
        <td class='input' >
          <select class=tag name="LicenseNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="LicenseNo" class="query" >
        </td>
      </tr>
      <tr>
       <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</form>
</body>
</html:html>