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

    function otherFlag(otherFlag) {
      
        if (otherFlag.length>2 && otherFlag.substring(2,3)== "1") {
          if(fm.validDate.value!=""){
            alert("�˱�����ȫ���˱�,�����ش���");
          } 
          else {
            alert("�˱�����ȫ���˱�,�����ش���");
          }
        }

        if (otherFlag.length>2 && otherFlag.substring(2,3)== "2") {
            alert("�˱����������˱��������ش���");
        }

        if (otherFlag.length>3 && otherFlag.substring(3,4)== "1") {
            alert("�˱����ѱ�ע�������ܱ���");
        }

        if (otherFlag.length>4 && otherFlag.substring(4,5)== "1") {
            alert("�˱�������ʧ�������ش���");
        }

        if (otherFlag.length>5 && otherFlag.substring(5,6)== "1") {
            alert("�˱�������ֹ��ͬ�������ش���");
        }

        return true;
    }

</script>

<html:html locale="true">
<head>
    <app:css />

  <title>������Ϣ��ѯ���</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >
<form name="fm" action="/claim/registBeforeQuery.do"  method="post">

  <table  class="common" cellpadding="4" cellspacing="1" >
  <tr>

            <td colspan="7" class="formtitle">������Ϣ��ѯ���</td>

          </tr>
     <tr>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >����ֹ��</td>
        <td class="centertitle" >����</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLregistDto"  property="registList">
     <logic:iterate id="prpLregist1"  name="prpLregistDto"  property="registList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <logic:equal name="prpLregist1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/0807registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpLregist1' property='policyNo'/>&editType=queryBeforeAdd&damageDate=<bean:write name='prpLregist1' property='damageDate'/>&damageHour=<bean:write name='prpLregist1' property='damageHour'/>" onclick="return otherFlag('<bean:write name='prpLregist1' property='othFlag'/>')">
                 <font color="red"><bean:write name="prpLregist1" property="policyNo"/></font>
              </a>
          </td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="insuredName"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="startDate"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="endDate"/></font></td>
        </logic:equal>
        <input type="hidden" name="validDate" value="<bean:write name='prppheadDto' property='validDate'/>">
        <logic:notEqual name="prpLregist1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/0807registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpLregist1' property='policyNo'/>&editType=queryBeforeAdd&damageDate=<bean:write name='prpLregist1' property='damageDate'/>&damageHour=<bean:write name='prpLregist1' property='damageHour'/>" onclick="return otherFlag('<bean:write name='prpLregist1' property='othFlag'/>')">
                  <bean:write name="prpLregist1" property="policyNo"/>
             </a>
              
    <input type="hidden" name="endorType" value="<bean:write name='prppheadDto' property='endorType'/>">
          </td>
          <td align="center"><bean:write name="prpLregist1" property="insuredName"/></td>
          <td align="center"><bean:write name="prpLregist1" property="startDate"/></td>
          <td align="center"><bean:write name="prpLregist1" property="endDate"/></td>
        </logic:notEqual>
        <td align="center"><bean:write name="prpLregist1" property="riskCode"/></td>
        
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr>
        <td colspan="7">
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>
                  <bean:define id="pageview" name="prpLregistDto" property="turnPageDto"/>
<%
  PrpLregistDto prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto");
  int curPage = prpLregistDto.getTurnPageDto().getPageNo();
%>
                  <%@include file="/common/pub/TurnOverPage.jsp" %>
              </tr>
          </table>
        </td>
      </tr>
  </table>

    <input type="hidden" name="editType" value="RegistBeforeQuery">
   
</form>
</body>
</html:html>