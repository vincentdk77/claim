<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title>�ͻ���Ϣ��ѯ</title>
	<app:css />
	<%-- ҳ����ʽ  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>
  <body>
  <form name="fm" action="/claim/queryAcciPerson.do">
  	<table class=common id="AcciPerson" cellpadding="5" cellspacing="1">
  	  <thead>
    	<tr class=listtitle>
    	  <td colspan="11">�ͻ�������Ϣ</td>
    	</tr>
    	<tr class=listtitle>
    	  <td align="center" style="width:10%">����������</td>
    	  <td align="center" style="width:10%">֤������</td>
    	  <td align="center" style="width:10%">֤������</td>
    	  <td align="center" style="width:10%">���մ���</td>
    	  <td align="center" style="width:10%">�ۼ��⸶���</td>
    	  <td align="center" style="width:10%">�������</td>
    	  <td align="center" style="width:10%">�Ƿ���Ϸ�������</td>
    	</tr>
      </thead>
      <tfoot>
      	<tr>
      	  <td>
			<input type="hidden" name="InsuredName"      >
		    <input type="hidden" name="CredentialType"   >
		    <input type="hidden" name="CredentialNo"     >
		    <input type="hidden" name="LossTimes"        >
		    <input type="hidden" name="SumClaimAmount"   >
		    <input type="hidden" name="RefuseClaimTimes" >
		    <input type="hidden" name="IsRisk"           >
		  </td>
		</tr>
		        <tr>
		          <td align="center">
					<input name="InsuredName" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='insuredName'/>">
		          </td>
		          <td align="center">
		          	<input name="CredentialType" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='credentialType'/>">
				  </td>
		          <td align="center">
		          	<input name="CredentialNo" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='credentialNo'/>">
				  </td>
		          <td align="center">
		          	<input name="LossTimes" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='lossTimes'/>">
				  </td>
		          <td align="center">
		          	<input name="SumClaimAmount" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='sumClaimAmount'/>">
				  </td>
		          <td align="center">
		          	<input name="RefuseClaimTimes" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='refuseClaimTimes'/>">
				  </td>
		          <td align="center">
		          	<input name="IsRisk" class="readonly" readonly 
							value="<bean:write name='prplaccidangersdDto' property='isRisk'/>">
				  </td>
		        </tr>
		        <tr>
		    <td class="queryresult" colspan="11" align="center">
	          <input class="button" type="button" value="�ر�" onclick="window.close();">
		    </td>
	    </tr>
      </tfoot>
    </table>
  </form>
  </body>
</html>
