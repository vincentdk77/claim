<%--
****************************************************************************
* DESC       ：修复验车查询输入界面
* AUTHOR     ： lixiang
* CREATEDATE ： 2005-09-24
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
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
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
    fm.submit();//提交
  }
//-->
</script>
</head>

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();">
<form name="fm" action="/claim/verifyLossQuery.do"  method="post" onsubmit="return validateForm(this);">
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr> 
      <td width="184" height="26" valign="bottom"> 
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
          <tr> 
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">查询修复验车信息</td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
    </tr>
  </table>
    <table width="90%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="common">
      <tr>
        <td class='title' style="width:15%">报案号:</td>
        <td class='input' style="width:25%">
        <select class=query name="RegistNoSign" style="width:40px">
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="RegistNo" class="input" style="width:140px">
        </td>
        <td class='title' style="width:15%">保单号：</td>
        <td class='input' style="width:25%">
        <select class=query name="PolicyNoSign" style="width:40px"> 
            <option value="*">*</option>
            <option value="=">=</option>
          </select><input type=text name="PolicyNo" class="input" style="width:140px">
        </td>

        <td class='button' style="width:20%" rowspan="3">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td> 
      </tr>
      <tr>
        <td class='title' style="width:15%"><bean:message key="db.prpLregist.licenseNo" />:</td>
        <td class='input' style="width:25%">
        <select class=query name="LicenseNoSign" style="width:40px">
            <%--<option value="*">*</option>--%>
            <option value="=">=</option>
          </select><input type=text name="LicenseNo" class="input" style="width:140px">
        </td>
        
        <td class='title' style="width:15%">操作时间</td>
        <td class='input' style="width:25%">
          <select class=query name="OperateDateSign" style="width:40px">
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value=">=">&gt;=</option>
	          <option value="<=">&lt;=</option>
          </select><input type=text name="OperateDate" class="Wdate" style="width:120px" onfocus="WdatePicker()"><!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')"> -->
        </td>
      </tr>
      <tr>
        <td class='title' style="width:15%">案件状态:</td>
        <td colspan="3" class='input' style="width:65%">
        <input type="hidden" name="caseFlag" value="">
        <input type="checkbox" name="status" value="1">未处理
        <input type="checkbox" name="status" value="2">正处理
        <input type="checkbox" name="status" value="4">已提交
        </td> 
      </tr>
    </table>
    <input type="hidden" name="editType" value="SHOW">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
  </form>
</body>

<jsp:include page="/common/pub/StaticJavascript.jsp"/>
</html:html>
