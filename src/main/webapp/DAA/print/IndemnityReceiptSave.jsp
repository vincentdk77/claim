<%--
****************************************************************************
* DESC       �� �տ���Ϣ����ҳ��
* AUTHOR     �� mengdongdong
* CREATEDATE �� 2006-02-08
* MODIFYLIST ��   Name       Date            Reason/Contents
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
    <app:css/>

<title>�տ���Ϣ</title>

<script language="javascript">

	//�ύ���������տ���Ϣ
	function saveIndemnityReceipt()
	{
	    if(!validateForm(fm))
	  {
	  	return false;
	  }
	
	   fm.target = "_self";
	   fm.submit();
	}
	
  	function exit()
  	{
      window.opener.location.reload();
  	}   

</script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
<html:base/>
</head>

<body  onload="initPage();">
<body  onunload="exit();">
<%
String compensateNo = request.getParameter("compensateNo");
String policyNo = request.getParameter("policyNo");
String insuredCode = request.getParameter("insuredCode");
String insuredName = request.getParameter("insuredName");

String unitBank = request.getParameter("unitBank");
String unitAccount = request.getParameter("unitAccount");
String account = request.getParameter("account");
String identifyNumber = request.getParameter("identifyNumber");

%>


<form name="fm" method="post" action="/claim/indemnityReceiptSave.do" onsubmit="return validateForm(this);">
<table width="100%" border="0"   class="common" cellpadding="5" cellspacing="1" >
	<tr >
	  <td class="title">�����ţ�</td>
      <td class="input"><input name="prpLIndemnityReceiptPolicyNo" style="width:100%" class="readonly" readonly="readonly" value="<%=policyNo%>"></td>
      <td class="title">�����ţ�</td>
	  <td class="input"><input name="prpLIndemnityReceiptBusinessNo" style="width:100%" class="readonly" readonly="readonly" value="<%=compensateNo%>"></td>
	</tr>
	<tr >
	    <td class="title" colspan="4"><div align="center" class="style1">�տ���Ϣ</div></td>
	</tr>
    </table>
<table width="100%">
  <tr>
	  <td class="title">�տλ���У�</td>
      <td class="input"><input name="prpLIndemnityReceiptUnitBank" style="width:100%" class="input" value="<%=unitBank%>"></td>
      <td class="title">�տ��������ʺţ�</td>
	  <td class="input"><input name="prpLIndemnityReceiptAccount" style="width:100%" class="input" value="<%=account%>"></td>
  </tr>
  <tr>
	  <td class="title">�տλ�ʺţ�</td>
      <td class="input"><input name="prpLIndemnityReceiptUnitAccount" style="width:100%" class="input" value="<%=unitAccount%>"></td>
      <td class="title">�տ������֤�ţ�</td>
	  <td class="input"><input name="prpLIndemnityReceiptIdentifyNumber" style="width:100%" class="input" value="<%=identifyNumber%>"></td>
  </tr>  
  <tr/>
  <tr>
   
    <td align=center colspan="2">
    	<input type="hidden" name="prpLIndemnityReceiptInsuredCode" value="<%=insuredCode%>"/>
    	<input type="hidden" name="prpLIndemnityReceiptInsuredName" value="<%=insuredName%>"/>
    	<input type="hidden" name="prpLIndemnityReceiptCertiType" value="C"/>
    	<input type="button" name="Submit" value="����" class="button" onclick="return saveIndemnityReceipt();">
    </td>
    <td align=center colspan="2">
    	<input type="button" name=buttonClose class='button' value="�ر�" onclick="javascript:window.close();">
    </td>
  </tr>
</table>
</form>
</BODY>
</html:html>
