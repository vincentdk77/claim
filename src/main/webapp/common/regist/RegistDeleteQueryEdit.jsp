<%--
****************************************************************************
* DESC       ：删除案件查询输入界面
* AUTHOR     ： lixiang
* CREATEDATE ： 2004-06-15
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
  <title><bean:message key="title.registBeforeEdit.titleName" /></title>
  <%-- 公用函数 --%>
  <script src="/claim/common/js/Common.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
   <script language='javascript'>
    function submitForm()
    {
      if (fm.RegistNo.value=="")
      {
        errorMessage("报案号不能为空");
        fm.RegistNo.focus();
        return false;
      }
      //x_load.show("系统正在查询,请勿点击页面...");
	  fm.queryButton.disabled=true;
      fm.submit();//提交
      setTimeout('fm.queryButton.disabled=false',5000);
    }
  </script>


</head>

<body  onload="initPage();">
<form name="fm" action="/claim/RegistQuery.do"  method="post" onsubmit="return validateForm(this);">

<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:80%">
	  <tr> 
	    <td width="184" height="26" valign="bottom"> 
	      <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
	        <tr> 
	          <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td width="161" class="formtitle"><bean:message key="title.registBeforeEdit.titleName" /></td>
	          <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr> 
	      </table>
	    </td>
	    <td valign="bottom"><font color="#666666">&nbsp;</td>
	  </tr>
	</table>
    <table class="common" style="width:80%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1">
      <tr>
        <td class='title' style="width:8.8%"><bean:message key="db.prpLregist.registNo" />:</td>
        <td class='input' style="width:10%">
          <input type=text name="RegistNo" maxlength='22' class="input" onblur="checkLength(this)">
        </td>
        <!--<td class='title' style="width:10%"><bean:message key="db.prpLregist.policyNo" />:</td>
        <td class='input' style="width:20%">
          <input type=text name="PolicyNo" class="input">
        </td>
        -->
        <td class='button' style="width:10%">
         
           <input type=button value="下一步" class='button' name="queryButton"
             onclick="submitForm();">
            
        </td>
      </tr>
    </table>

    <input type="hidden" name="editType" value="DELETE">
</form>
</body>
</html:html>

