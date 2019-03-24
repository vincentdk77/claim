<%--
****************************************************************************
* DESC       ：冲减保额前输入立案号页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%
//add by miawenjun 2007-2-2 10:25 取edittype
String editType = (String)request.getParameter("editType");
%>

<html>
<head>
  <title>冲减保额</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language='javascript'>
    /**
     @author      liubvo
     @description 校验窗体方法
     @param       无
     @return      boolean,合法返回true,不合法返回false
    */
    function checkForm()
		{
			if(isEmpty(fm.ClaimNo))
			{
				fm.ClaimNo.focus();
				errorMessage("立案号不能为空!");
				return false;
			}
			else if(trim(fm.ClaimNo.value).length!=22)
			{
				fm.ClaimNo.focus();
				errorMessage("立案号应为22位长!");
				return false;
			}

			if(!isEmpty(fm.CompensateNo))
			{
			  if(trim(fm.CompensateNo.value).length!=22)
			  {
  				fm.CompensateNo.focus();
  				errorMessage("赔款计算书号应为22位长!");
  				return false;
			  }
			}

			return true;
		}

    /**
     @author      liubvo
     @description 提交窗体方法
     @param       无
     @return      无
     @see         checkForm
    */
    function submitForm()
    {
    /*
      if(checkForm()==true)
	  	{
        fm.submit();
      }
      */
       fm.submit();
    }

    function resetForm()
    {
      fm.reset();
    }
  </script>
</head>

<body class="interface">
<form name="fm" action="/claim/endor.do"  method="post" onsubmit="return validateForm(this);">


  <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
  <tr> <td colspan=4 class="formtitle">输入立案号</td></tr>
    <tr>
      <td class="title" >立案号：</td>
      <td class="input" >
        <input type=text name="ClaimNo" class="common" maxlength='21'> <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
      <td class=title >赔款计算书号：</td>
      <td class="input" >
        <input type=text class="common" type='text' name='CompensateNo' maxlength='30'>
      </td>
    </tr>
    <tr>
	  <td colspan=2 class=button>
	    <input type='button' value='下一步' class="button" onclick="return submitForm();">
	  </td>
	  <td colspan=2 class=button>
	    <input type='button' value='重  置' class="button" onclick="return resetForm();">
	  </td>
    </tr>
  </table>
  <input type="hidden" name="editType" value='<%=editType%>'>
</form>
</body>
</html>
