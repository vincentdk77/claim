<%--
****************************************************************************
* DESC       ：特殊赔案查询条件输入页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-07
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>


<html:html locale="true">
<head>
  <title>查询预赔案信息</title>
  <%-- 公用函数 --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <%--案件状态标志处理--%>
  <!--
    function submitForm()
    {
      var ref="";
      for(i=0;i<fm.status.length;i++){
        if(fm.status[i].checked==true){
           ref = ref+fm.status[i].value+",";
        }
      }
      fm.caseFlag.value = ref;
      fm.backButton.disabled=true;
      fm.submit();//提交
      setTimeout('fm.backButton.disabled=false',5000);
    }
  //-->
  </script>

  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/wfLogQuery.do" method="post" onsubmit="return validateForm(this);">

    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>  <td colspan=4 class="formtitle">查询预赔案信息</td></tr>
      <tr>
        <td class='title'>业务号码:</td>
        <td class='input'>
          <select class=tag name="RegistNoSign">
           <!--  <option value="*">*</option> -->
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query">
        </td>
        <td class='title'><bean:message key="db.prpLregist.policyNo" />:</td>
        <td class='input'>
        <select class=tag name="PolicyNoSign">
          <!--  <option value="*">*</option> -->
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query">
        </td>

      </tr>


      <tr>
        <td class='title'>案件状态:</td>
        <td colspan="3" class='input' >
          <input type="hidden" name="caseFlag" value="">
          <input type="checkbox" name="status" value="1">未处理
          <input type="checkbox" name="status" value="2">正处理
          <%--没有此种案件状态 2005-07-28<input type="checkbox" name="status" value="3">已处理--%>
          <input type="checkbox" name="status" value="4">已提交
          <input type="checkbox" name="status" value="5">已撤消
        </td>
      </tr>
      <tr><td class='button'  colspan="3">
          <input type=button class='button' id="backButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>
    </table>
    <input type="hidden" name="editType" value="specialQuery">
    <input type="hidden" name="nodeType" value="speci">
  </form>
</body>
</html>
</html:html>
