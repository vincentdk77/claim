<%--
****************************************************************************
* DESC       ��¼�뱨��ǰ��ѯ������������
* AUTHOR     ��liubvo
* CREATEDATE ��2004-12-06 
* MODIFYLIST ��   id       Date            Reason/Contents
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
 
  <title>������Ϣ��ѯ���</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >
<form name="fm" action="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='policyNo'/>&editType=ADD&editRegistFlag=ADD&damageDate="<%= new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY) %>"" method="post">

  <table  class="common" cellpadding="4" cellspacing="1" >
          <tr>
            <td colspan="7" class="formtitle">������Ϣ��ѯ���</td>
          </tr>
     <tr>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >������������</td>
        <td class="centertitle" >����ҵ��Ա����</td>
        <td class="centertitle" >��������</td>
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
       <input type="button" name="buttonSave" class="button" value="�� ��" onclick="submit(this);">
    </td>
</form>
</body>

</html:html>