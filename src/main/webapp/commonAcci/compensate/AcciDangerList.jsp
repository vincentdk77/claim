<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
    <title>客户信息查询</title>
	<app:css />
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>
  <body>
  <form name="fm" action="/claim/queryAcciPerson.do">
  	<table class=common id="AcciPerson" cellpadding="5" cellspacing="1">
  	  <thead>
    	<tr class=listtitle>
    	  <td colspan="11">客户风险信息</td>
    	</tr>
    	<tr class=listtitle>
    	  <td align="center" style="width:10%">出险人姓名</td>
    	  <td align="center" style="width:10%">证件类型</td>
    	  <td align="center" style="width:10%">证件号码</td>
    	  <td align="center" style="width:10%">出险次数</td>
    	  <td align="center" style="width:10%">累计赔付金额</td>
    	  <td align="center" style="width:10%">拒赔次数</td>
    	  <td align="center" style="width:10%">是否符合风险特征</td>
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
	          <input class="button" type="button" value="关闭" onclick="window.close();">
		    </td>
	    </tr>
      </tfoot>
    </table>
  </form>
  </body>
</html>
