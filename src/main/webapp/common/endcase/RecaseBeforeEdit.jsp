<%--
****************************************************************************
* DESC       ���ؿ��ⰸ¼��������ҳ��
* AUTHOR     �� liuyanmei
* CREATEDATE �� 2005-11-02
* MODIFYLIST ��   Name       Date            Reason/Contents
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
  <title>¼��������</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
 <script language='javascript'>
 function checkForm()
		{
			if(fm.reCaseClaimNo.value=="")
			{
				
				alert("�����Ų���Ϊ��!");
				return false;
			}
			else if(trim(fm.reCaseClaimNo.value).length!=21)
			{
				
				alert("������ӦΪ21λ��!");
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
  <tr><td colspan=2 class="formtitle">����������</td></tr>
    <tr>
      <td class="title2"  align="center">�����ţ�</td>
      <td class="input2">
        <input type=text name="reCaseClaimNo" class="common">
      </td>
      </tr>
      <tr>
      <td class="button"   colspan=2 align="center">
        <input type=submit class="button" id="backButton" class="button" value="��һ��"  onclick="return checkForm();submitForm();">
      </td>
    </tr>
  </table>
  <input type="hidden" name="editType" value="ADD">
</form>
</body>
</html>



