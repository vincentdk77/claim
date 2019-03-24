<%--
****************************************************************************
* DESC       ：单证查询输入界面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-05
* MODIFYLIST ：   Name       Date            Reason/Contents
           1. 增加车牌号，案件状态，操作时间查询条件
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/js/WdatePicker.js"></script>
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

    fm.queryButton.disabled=true;
	fm.submit();//提交
    setTimeout('fm.queryButton.disabled=false',5000);
  }
  //-->
  </script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/certifyQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr><td colspan=4 class="formtitle">查询单证信息</td></tr>
      <tr>
        <td class='title' >报案号:</td>
        <td class='input' >
        <select class=tag name="RegistNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="RegistNo" class="query" >
        </td>
         <%--报案查询增加被保险人查询条件--%>
       <td class='title' >被保险人名称:</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>


      </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />:</td>
        <td class='input' >
        <select class=tag name="LicenseNoSign" >
            <option value="=">=</option>
            <option value="*">*</option>     
          </select> <input type=text name="LicenseNo" class="query" >
        </td>
               <%
                  String OperateDate = "";
                  String endDate ="";       		
                  DateTime dateTime1 = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
                  OperateDate = dateTime1.addDay(-7).toString();
                  endDate = dateTime1.toString();
                %>
        <td class='title' >操作时间:</td>
        <td class='input' >
          <select class=tag name="OperateDateSign" >
              <option value=">=">&gt;=</option>
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value="<=">&lt;=</option>
          </select> <input type=text name="OperateDate" class="Wdate" style="width:60%" value="<%=OperateDate %>" onfocus="WdatePicker()"> 
        </td>
      </tr>
      <tr>
        <td class='title' >案件状态:</td>
        <td colspan="3" class='input' >
          <input type="hidden" name="caseFlag" >
          <!--delete by caopeng start at 2005-12-20
          <input type="checkbox" name="status" value="1">未处理
          delete by caopeng start at 2005-12-20-->
          <input type="checkbox" name="status" value="2">正处理
          <%--没有此种案件状态 2005-07-28<input type="checkbox" name="status" value="3">已处理--%>
          <input type="checkbox" name="status" value="4">已提交
        </td>
      </tr>
      <tr>  <td class='button'  colspan="4">
          <input type=button class='button' name="queryButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td> </tr>
    </table>
    <input type="hidden" name="editType" value="SHOW">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
  </form>
</body>

</html:html>