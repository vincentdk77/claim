<%--
****************************************************************************
* DESC       ：重开赔案录入立案号页面
* AUTHOR     ： liuyanmei
* CREATEDATE ： 2005-11-02
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html>
<head>
  <title>录入立案号</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
 <script language='javascript'>
 function checkForm()
		{
			if(fm.reCaseClaimNo.value=="")
			{
				
				alert("立案号不能为空!");
				return false;
			}
			else if(trim(fm.reCaseClaimNo.value).length!=21)
			{
				
				alert("立案号应为21位长!");
				return false;
			}
		return true;
		}



  function submitForm()
    {
    
		fm.backButton.disabled=true;
        fm.submit();
        setTimeout('fm.backButton.disabled=false',5000);
    }

    function resetForm()
    {
      fm.reset();
    }
 </script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/reCaseBefore.do"  method="post" onsubmit="return validateForm(this);">

  <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
  <tr><td colspan=2 class="formtitle">输入立案号</td></tr>
    <tr>
      <td class="title2"  align="center">立案号：</td>
      <td class="input2">
        <input type=text name="reCaseClaimNo" class="common">
      </td>
      </tr>
      <tr>
      <td class="button"   colspan=2 align="center">
        <input type=submit class="button" id="backButton" class="button" value="下一步"  onclick="return checkForm();submitForm();">
      </td>
    </tr>
  </table>
  <input type="hidden" name="editType" value="ADD">
</form>
</body>
</html>



