<%--
****************************************************************************
* DESC       ：查勘查询输入界面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-07
* MODIFYLIST ：   Name Sunhao      Date  2004-08-24          Reason/Contents
           1. 增加车牌号，案件状态，操作时间查询条件
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
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language="javascript">
  <!--
  <%--案件状态标志处理--%>
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
<form name="fm" action="/claim/checkQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">查勘图片上传查询</td></tr>
      <tr>
        <td class='title' >报案号:</td>
        <td class='input' >
        <select class=tag name="RegistNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query" >
        </td>
        <td class='title' >立案号：</td>
        <td class='input' >
        <select class=tag name="ClaimNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query" >
        </td>

      </tr>
      <tr>
        <td class='title' >保单号码：</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="PolicyNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />:</td>
        <td class='input' >
        <select class=tag name="LicenseNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select>　<input type=text name="LicenseNo" class="query" >
        </td>
      </tr>
      <tr>
        <td class='title' >操作时间：</td>
        <td class='input'  colspan="3">
          <select class=tag name="OperateDateSign" >
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value=">=">&gt;=</option>
	          <option value="<=">&lt;=</option>
          </select>　<input type=text name="OperateDate" class="Wdate" onfocus="WdatePicker()">
          <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" align="absmiddle" onclick="TogglePopupCalendarWindow('document.fm.OperateDate','2007', '2017')"> -->
        </td>
      </tr>
      <tr>
        <td class='title' >案件状态：</td>
        <td colspan="3" class='input' >
          <input type="hidden" name="caseFlag" value="">
          <input type="checkbox" name="status" value="1">未处理
          <input type="checkbox" name="status" value="2">正处理
          <input type="checkbox" name="status" value="3">已处理
          <input type="checkbox" name="status" value="4">已提交
          <input type="checkbox" name="status" value="5">已撤消
        </td>
      </tr>
      <tr>
       <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>
    </table>
    <input type="hidden" name="editType" value="Certify">
  </form>
</body>
</html:html>