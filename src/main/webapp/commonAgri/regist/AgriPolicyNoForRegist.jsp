<%--
****************************************************************************
* DESC       ：录入报案前查询保单号码结果面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-12-06 
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%

%>


<script language="javascript">


</script>
 
<html:html locale="true">

<head>
    <app:css />
 
  <title>保单信息查询结果</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >
<form name="fm" action="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='policyNo'/>&editType=ADD&editRegistFlag=ADD&damageDate="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %>"" method="post">

  <table  class="common" cellpadding="4" cellspacing="1" >
          <tr>
            <td colspan="7" class="formtitle">报案信息查询结果</td>
          </tr>
     <tr>
        <td class="centertitle" >保单号码</td>
        <td class="centertitle" >报案号码</td>
        <td class="centertitle" >险种名称</td>
        <td class="centertitle" >被保险人名称</td>
        <td class="centertitle" >归属业务员代码</td>
        <td class="centertitle" >出险日期</td>
     </tr>
     <%int index=0;%>
     <logic:iterate id="prpLregistDto"  name="registNoList" >
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
          <td align="center"><bean:write name="prpLregistDto" property="policyNo"/></td>
          <td align="center">
              <a href="/claim/registFinishQueryList.do?prpLregistRegistNo=<bean:write name='prpLregistDto' property='registNo'/>&editType=EDIT&editRegistFlag=editH&damageDate="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %>"">
                 <bean:write name="prpLregistDto" property="registNo"/></font>
              </a>
          </td>          
          
          <td align="center"><bean:write name="prpLregistDto" property="riskCode"/></td>
          <td align="center"><bean:write name="prpLregistDto" property="insuredName"/></td>
          <td align="center"><bean:write name="prpLregistDto" property="handler1Code"/></td>
          <td align="center"><bean:write name="prpLregistDto" property="damageStartDate"/></td>
         </tr>
<%        index++;%>
      </logic:iterate>
      
      
      <tr>
        <td colspan="7">
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
             
          </table>
        </td>
      </tr>
  </table>

    <input type="hidden" name="editType" value="RegistBeforeQuery">
    <td class=button style="width:40%" align="center">
       <input type="button" name="buttonSave" class="button" value="新 增" onclick="submit(this);">
    </td>
</form>
</body>

</html:html>