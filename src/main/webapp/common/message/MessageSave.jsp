<%--
****************************************************************************
* DESC       ： 理赔流转讨论留言保存页面
* AUTHOR     ： Sunhao
* CREATEDATE ： 2004-07-28
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
    <app:css/>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">  
<title>留言区</title>

<script language="javascript">

//提交表单，保存留言内容
function saveMessage()
{

  if(!validateForm(fm))
  {
  	return false;
  }
   fm.target = "_self";
   fm.submit();
}
</script>
<%
	String businessNo = request.getParameter("businessNo");
	String nodeType = request.getParameter("nodeType");
	String policyNo = request.getParameter("policyNo");
	String riskCode = request.getParameter("riskCode");
    String typeSystem = request.getParameter("typeSystem");
    String userCodeVeric = request.getParameter("userCodeVeric"); 

	String strRegistNo = request.getParameter("registNo");
	String strClaimNo = request.getParameter("claimNo");
	
	
%>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
<html:base/>
</head>

<body  onload="initPage();" scroll ="auto">
<form name="fm" method="post" action="/claim/messageSave.do">
<input type="hidden" name="businessNo" value="<%=businessNo %>">
<input type="hidden" name="nodeType" value="<%=nodeType %>">
<input type="hidden" name="policyNo" value="<%=policyNo %>">
<input type="hidden" name="riskCode" value="<%=riskCode %>">
<input type="hidden" name="typeSystem" value="<%=typeSystem %>">
<input type="hidden" name="userCodeVeric" value="<%=userCodeVeric %>">

<input type="hidden" name="registNo" value="<%=strRegistNo %>">
<input type="hidden" name="claimNo" value="<%=strClaimNo %>">
<table width="100%" border="0"   class="common" cellpadding="5" cellspacing="1" >
	<tr >
	  <td class="title" >报案号：</td>
      <td class="input" ><input name="prpLmessageRegistNo" style="width:100%" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='registNo' />"></td>
      <td class="title">保单号：</td>
	  <td class="input"><input name="prpLmessagePolicyNo" style="width:100%" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='policyNo' />"></td>
	</tr>
	<tr >
	  <td class="title">立案号：</td>
      <td class="input"><input name="prpLmessageClaimNo" style="width:100%" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='claimNo' />"></td>
      <td class="title">险种代码：</td>
	  <td class="input"><input name="prpLmessageRiskCode" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='riskCode' />"></td>
	</tr>
	<tr >
	  <td class="title">输单日期：</td>
      <td class="input"><input name="prpLmessageInputDate" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='inputDate' />"></td>
      <td class="title">节点类型：</td>
      <td class="input">
        <input name="prpLmessageNodeTypeName" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='nodeTypeName' />">
        <input type="hidden" name="prpLmessageNodeType" value="<bean:write name='prpLmessageDto1' property='nodeType'/>">
      </td>
	</tr>
	<tr>
	  <td class="title" >操作员代码：</td>
      <td class="input"><input name="prpLmessageOperatorCode" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='operatorCode' />"></td>
      <td class="title" >操作员姓名：</td>
      <td class="input"><input name="prpLmessageOperatorName" class="readonly" readonly="true" value="<bean:write name='prpLmessageDto1' property='operatorName' />"></td>
	</tr>
	<tr >
	    <td class="title" colspan="4"><div align="center" class="style1">记录信息</div></td>
	</tr>
    </table>

<table width="100%">
  <tr>
    <td colspan="2" align="center"><textarea name="prpLmessageContext" cols="70" rows="5"></textarea></td>
    </tr>
  <tr>
    <td align=center>
    <input type="hidden" name="prpLmessageSave" value="editMessage">
    <input type="button" name="Submit" value="保存" class="button" onclick="return saveMessage();"></td>
    <td align="center"><input type="reset" class="button" name="reset" value="重置"></td>
  </tr>
</table>
<br>
<br>
<br>
<table border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr class=listtitle>
    <td width="5%" align="center" nowrap >序号</td>
    <td width="10%" align="center" nowrap ><div align="center">时间</div></td>
    <td width="10%" align="center" nowrap >节点类型</td>
    <td width="10%" align="center" nowrap >留言人</td>
    <td width="65%" ><div align="center">记录信息</div></td>
  </tr>
  <%
  int index = 1;
  %>
  <logic:notEmpty  name="prpLmessageDto"  property="messageList">
  <logic:iterate id="prpLmessage1"  name="prpLmessageDto"  property="messageList">
<%
			if (index % 2 == 0) {
			out.print("<tr class=listodd>");
		} else {
			out.print("<tr class=listeven>");
		}
%>
     <tr class=common> <td><%=index%></td>
      <td><bean:write name="prpLmessage1" property="inputDate"/></td>
      <td><bean:write name="prpLmessage1" property="nodeType"/></td>
      <td><bean:write name="prpLmessage1" property="operatorName"/></td>
      <td><textarea readonly="true" cols="70" rows="3"><bean:write name="prpLmessage1" property="context"/></textarea></td>
  </tr>
<%
index++;
%>
  </logic:iterate>
  </logic:notEmpty>
</table>

</form>
</BODY>
</html:html>
