<%--
****************************************************************************
* DESC       ：结案登记录入/修改页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-28
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>结案登记</title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<script language="javascript">
	function submitForm()
  {
    	fm.buttonSave.disabled = true;
    	fm.submit(); //提交
  }
</script>
</head>
<body  onload="initPage();">
  <form name="fm" method="post" action="/claim/endcaseSave.do?step=step3">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="prplCaseNoCaseNo1" value="<bean:write name='prpLcaseNoDto' property='caseNo'/>">
    <input type="hidden" name="prpLendcaseClaimNo1" value="<bean:write name='prpLcaseNoDto' property='claimNo'/>">
    <input  type="hidden" name=buttonSaveType value="2">
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td width="184" height="26" valign="bottom">
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">生成归档号</td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
    </tr>
  </table>
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td class="centertitle">立案号：</td>
      <td class="centertitle"><bean:write name="prpLcaseNoDto" property="claimNo"/></td>
      <td class="centertitle">保单号：</td>
      <td class="centertitle"><bean:write name="prpLcaseNoDto" property="policyNo"/></td>
    </tr>
  </table>

  <table  class="common" cellpadding="4" cellspacing="1">
     <tr>
        <td class="centertitle" colspan="3" align="left">赔案信息</td>
     </tr>
     <tr>
        <td class="centertitle">赔款计算书号</td>
        <td class="centertitle">归档号</td>
        <td class="centertitle">赔款金额</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLcaseNoDto"  property="caseList">
     <logic:iterate id="caseList1"  name="prpLcaseNoDto"  property="caseList">
<%
          if(index % 2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <td><bean:write name="caseList1" property="certiNo"/></td>
        <td><bean:write name="caseList1" property="caseNo"/></td>
        <td><bean:write name="caseList1" property="sumPaid"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
    </table>
    </tr>
  </table>

  <table class="common" align="center">
    <tr>
      <td class="button" colspan="2">
        <input type="button" name="buttonSave" value=" 保 存 " class="button" onclick="submitForm();">
      </td>
      <td class="button" colspan="2">
        <input type="button" name="buttonCancel" class="button" value=" 取 消 ">
      </td>
    </tr>
  </table>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>