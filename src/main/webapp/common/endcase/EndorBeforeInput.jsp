<%--
****************************************************************************
* DESC       ���������ǰ����������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-26
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%
//add by miawenjun 2007-2-2 10:25 ȡedittype
String editType = (String)request.getParameter("editType");
%>

<html>
<head>
  <title>�������</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script language='javascript'>
    /**
     @author      liubvo
     @description У�鴰�巽��
     @param       ��
     @return      boolean,�Ϸ�����true,���Ϸ�����false
    */
    function checkForm()
		{
			if(isEmpty(fm.ClaimNo))
			{
				fm.ClaimNo.focus();
				errorMessage("�����Ų���Ϊ��!");
				return false;
			}
			else if(trim(fm.ClaimNo.value).length!=22)
			{
				fm.ClaimNo.focus();
				errorMessage("������ӦΪ22λ��!");
				return false;
			}

			if(!isEmpty(fm.CompensateNo))
			{
			  if(trim(fm.CompensateNo.value).length!=22)
			  {
  				fm.CompensateNo.focus();
  				errorMessage("���������ӦΪ22λ��!");
  				return false;
			  }
			}

			return true;
		}

    /**
     @author      liubvo
     @description �ύ���巽��
     @param       ��
     @return      ��
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
  <tr> <td colspan=4 class="formtitle">����������</td></tr>
    <tr>
      <td class="title" >�����ţ�</td>
      <td class="input" >
        <input type=text name="ClaimNo" class="common" maxlength='21'> <img src="/claim/images/bgMarkMustInput.jpg">
      </td>
      <td class=title >��������ţ�</td>
      <td class="input" >
        <input type=text class="common" type='text' name='CompensateNo' maxlength='30'>
      </td>
    </tr>
    <tr>
	  <td colspan=2 class=button>
	    <input type='button' value='��һ��' class="button" onclick="return submitForm();">
	  </td>
	  <td colspan=2 class=button>
	    <input type='button' value='��  ��' class="button" onclick="return resetForm();">
	  </td>
    </tr>
  </table>
  <input type="hidden" name="editType" value='<%=editType%>'>
</form>
</body>
</html>
