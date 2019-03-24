<%--
****************************************************************************
* DESC       ：立案撤消查询条件输入页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-07
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">


  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <!--
  <%--案件撤消处理--%>
  function submitForm()
  {
    var ref="";
    for(i=0;i<fm.status.length;i++){

      if(fm.status[i].checked==true){
        ref = ref+fm.status[i].value+",";
      }
    }
    fm.caseFlag.value = ref;

    fm.submit();//提交
  }
  //-->
  </script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/ClaimDeleteQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr> <td colspan=4 class="formtitle"><bean:message key="title.claimBeforeEdit.titleName" /></td></tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLclaim.claimNo" />：</td>
        <td class='input' >
        <select class=tag >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="prpLclaimClaimNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLclaim.policyNo" />：</td>
        <td class='input' >
        <select class=tag >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="prpLclaimPolicyNo" class="query" >
        </td>

      </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />：</td>
        <td class='input' >
          <select class=tag >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="prpLthirdPartyLicenseNo" class="query" >
        </td>
        <td class='title' >操作时间:</td>
        <td class='input' >
          <select class=tag name="prpLClaimStatusOperateDateSign" >
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value=">=">&gt;=</option>
	          <option value="<=">&lt;=</option>
          </select> <input type=text name="prpLClaimStatusOperateDate" class="query" >
        </td>
      </tr>
      <tr>
        <td class='title' >案件状态:</td>
        <td colspan="3" class='input' >
          <input type="hidden"   name="caseFlag">
          <input type="checkbox" name="status" value="2">正处理
          <input type="checkbox" name="status" value="3">已完成

        </td>
      </tr>
      <tr>
       <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>
    </table>
    <input type="hidden" name="editType" value="SHOW">
  </form>
</body>
</html:html>
