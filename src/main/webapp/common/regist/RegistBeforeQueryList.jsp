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
<%@ page import="com.gyic.claim.dto.domain.HerdpolicylistDto" %>
<%@ page import="com.gyic.claim.dto.domain.HousepolicylistDto" %>
<%@ page import="java.util.ArrayList" %>
<%

%>


<script language="javascript">

    function otherFlag(otherFlag,underwriteFlag) {
      
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
            return false;
        }

        if (otherFlag.length>4 && otherFlag.substring(4,5)== "1") {
            alert("�˱�������ʧ�������ش���");
        }

        if (otherFlag.length>5 && otherFlag.substring(5,6)== "1") {
            alert("�˱�������ֹ��ͬ�������ش���");
        }
        if(underwriteFlag != "1" && underwriteFlag != "3"){
            alert("�ñ���Ϊ��Ч���������ܱ���");
            return false;
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
 <%String earLabel = request.getParameter("EarLabel");
 String strFname = request.getParameter("Fname");
 String strAreasCode = request.getParameter("AreasCode");
 String strIdentifyNumber_0310 = request.getParameter("IdentifyNumber_0310");
		if((earLabel != null && earLabel.trim().length() > 0)||(strFname != null && strFname.trim().length() > 0)){ 
%> 
 <table  class="common" cellpadding="4" cellspacing="1" >
	<tr>
            <td colspan="9" class="formtitle">������Ϣ��ѯ���</td>
	</tr>
     <tr>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >�����</td>
        <td class="centertitle" >ũ������</td>
        <td class="centertitle" >ũ�����֤</td>
        <td class="centertitle" >��ֳ�ص�</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >����ֹ��</td>
        <td class="centertitle" >����</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLregistDto"  property="registList">
     <logic:iterate id="prpLregist1"  name="prpLregistDto"  property="registList">
     <bean:define id="prpCmainDto1" name="prpLregist1" property="prpCmainDto"/>
     <bean:define id="herdpolicylistDto1" name="prpLregist1" property="herdpolicylistDto"/>
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <logic:equal name="prpCmainDto1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpCmainDto1' property='policyNo'/>&editType=ADD&nodeType=regis&damageDate=<bean:write name='prpCmainDto1' property='damageDate'/>&damageHour=<bean:write name='prpCmainDto1' property='damageHour'/>&editRegistFlag=ADDFLAG" onclick="return otherFlag('<bean:write name='prpCmainDto1' property='othFlag'/>','<bean:write name='prpCmainDto1' property='underWriteFlag'/>')">
                 <font color="red"><bean:write name="prpCmainDto1" property="policyNo"/></font>
              </a>
          </td>
          <td align="center"><font color="red"><bean:write name="prpCmainDto1" property="insuredAddress"/></font></td>
			<td align="center"><font color="red"><bean:write name="herdpolicylistDto1" property="earlabel"/></font></td>
			<td align="center"><font color="red"><bean:write name="herdpolicylistDto1" property="fname"/></font></td>
			<td align="center"><font color="red"><bean:write name="herdpolicylistDto1" property="fidcard"/></font></td>
			<td align="center"><font color="red"><bean:write name="herdpolicylistDto1" property="breedingareaname"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpCmainDto1" property="startDate"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpCmainDto1" property="endDate"/></font></td>
        </logic:equal>
       <%-- �㲻�����;������<input type="hidden" name="validDate" value="<bean:write name='prppheadDto' property='validDate'/>">--%>
        <logic:notEqual name="prpCmainDto1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpCmainDto1' property='policyNo'/>&editType=ADD&nodeType=regis&damageDate=<bean:write name='prpCmainDto1' property='damageDate'/>&damageHour=<bean:write name='prpCmainDto1' property='damageHour'/>&editRegistFlag=ADDFLAG" onclick="return otherFlag('<bean:write name='prpCmainDto1' property='othFlag'/>','<bean:write name='prpCmainDto1' property='underWriteFlag'/>')">
                  <bean:write name="prpCmainDto1" property="policyNo"/>
             </a>
              
    <%--�㲻�����;������ <input type="hidden" name="endorType" value="<bean:write name='prppheadDto' property='endorType'/>">--%>
          </td>
          <td align="center"><bean:write name="prpCmainDto1" property="insuredAddress"/></td>
			<td align="center"><bean:write name="herdpolicylistDto1" property="earlabel"/></td>
			<td align="center"><bean:write name="herdpolicylistDto1" property="fname"/></td>
			<td align="center"><bean:write name="herdpolicylistDto1" property="fidcard"/></td>
			<td align="center"><bean:write name="herdpolicylistDto1" property="breedingareaname"/></td>
          <td align="center"><bean:write name="prpCmainDto1" property="startDate"/></td>
          <td align="center"><bean:write name="prpCmainDto1" property="endDate"/></td>
        </logic:notEqual>
        <td align="center"><bean:write name="prpCmainDto1" property="riskCode"/></td>
        
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
	<input type="hidden" name="DamageDate" value="<%=request.getParameter("DamageDate") %>">
	<input type="hidden" name="DamageHour" value="<%=request.getParameter("DamageHour") %>">
    <input type="hidden" name="editType" value="RegistBeforeQuery">
	<input type="hidden" name="EarLabel" value="<%=request.getParameter("EarLabel") %>">
	<input type="hidden" name="Fname" value="<%=request.getParameter("Fname") %>">
	<%
		}
	else if((strAreasCode != null && strAreasCode.trim().length() > 0)||(strIdentifyNumber_0310 != null && strIdentifyNumber_0310.trim().length() > 0)){
%> 
 <table  class="common" cellpadding="4" cellspacing="1" >
  <tr>
  <td colspan="7" class="formtitle">������Ϣ��ѯ���</td>
  </tr>
     <tr>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
        <td class="centertitle" >ũ������</td>
        <td class="centertitle" >���֤��</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >��������</td>
        <td class="centertitle" >����ֹ��</td>
        <td class="centertitle" >����</td>
     </tr>
     <%int index=0;%>
     
     <logic:notEmpty  name="prpLregistDto"  property="registList">
     <logic:iterate id="prpLregist1"  name="prpLregistDto"  property="registList">
     <bean:define id="prpCmainDto1" name="prpLregist1" property="prpCmainDto"/>
     <bean:define id="housepolicylistDto1" name="prpLregist1" property="housepolicylistDto"/>
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
        <logic:equal name="prpCmainDto1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpCmainDto1' property='policyNo'/>&editType=ADD&nodeType=regis&damageDate=<bean:write name='prpCmainDto1' property='damageDate'/>&damageHour=<bean:write name='prpCmainDto1' property='damageHour'/>&editRegistFlag=ADDFLAG" onclick="return otherFlag('<bean:write name='prpCmainDto1' property='othFlag'/>','<bean:write name='prpCmainDto1' property='underWriteFlag'/>')">
                 <font color="red"><bean:write name="prpCmainDto1" property="policyNo"/></font>
              </a>
          </td>
          <td align="center"><font color="red"><bean:write name="housepolicylistDto1" property="name"/></font></td>
          <td align="center"><font color="red"><bean:write name="housepolicylistDto1" property="idcard"/></font></td>
          <td align="center"><font color="red"><bean:write name="housepolicylistDto1" property="remark"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpCmainDto1" property="startDate"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpCmainDto1" property="endDate"/></font></td>
        </logic:equal>
        <input type="hidden" name="validDate" value="<bean:write name='prppheadDto' property='validDate'/>">
   
        <logic:notEqual name="prpCmainDto1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpCmainDto1' property='policyNo'/>&editType=ADD&nodeType=regis&damageDate=<bean:write name='prpCmainDto1' property='damageDate'/>&damageHour=<bean:write name='prpCmainDto1' property='damageHour'/>&editRegistFlag=ADDFLAG" onclick="return otherFlag('<bean:write name='prpCmainDto1' property='othFlag'/>','<bean:write name='prpCmainDto1' property='underWriteFlag'/>')">
                  <bean:write name="prpCmainDto1" property="policyNo"/>
             </a>
              
    <input type="hidden" name="endorType" value="<bean:write name='prppheadDto' property='endorType'/>">
          </td>
          <td align="center"><bean:write name="housepolicylistDto1" property="name"/></td>
          <td align="center"><bean:write name="housepolicylistDto1" property="idcard"/></td>
          <td align="center"><bean:write name="housepolicylistDto1" property="remark"/></td>
          <td align="center"><bean:write name="prpCmainDto1" property="startDate"/></td>
          <td align="center"><bean:write name="prpCmainDto1" property="endDate"/></td>
        </logic:notEqual>
        <td align="center"><bean:write name="prpCmainDto1" property="riskCode"/></td>
        
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
	<input type="hidden" name="DamageDate" value="<%=request.getParameter("DamageDate") %>">
	<input type="hidden" name="DamageHour" value="<%=request.getParameter("DamageHour") %>">
    <input type="hidden" name="editType" value="RegistBeforeQuery">
    <input type="hidden" name="FCardID" value="<%=request.getParameter("FCardID") %>">
	<input type="hidden" name="Fname1" value="<%=request.getParameter("Fname1") %>">
	<input type="hidden" name="FamilyNo" value="<%=request.getParameter("FamilyNo") %>">
	<input type="hidden" name="FamilyFIDCard" value="<%=request.getParameter("FamilyFIDCard") %>">
	<input type="hidden" name="IdentifyNumber_0310" value="<%=request.getParameter("IdentifyNumber_0310") %>">
	<input type="hidden" name="AreasCode" value="<%=request.getParameter("AreasCode") %>">
	<input type="hidden" name="IdentifyNumberSign_0310" value="<%=request.getParameter("IdentifyNumberSign_0310") %>">
	
 <%  	}
 else{
%> 
 <table  class="common" cellpadding="4" cellspacing="1" >
  <tr>
  <td colspan="7" class="formtitle">������Ϣ��ѯ���</td>
  </tr>
     <tr>
        <td class="centertitle" ><bean:message key="db.prpLregist.policyNo"/></td>
         <td class="centertitle" >��������</td>
        <td class="centertitle" >���ƺ�</td>
        <td class="centertitle" >�����ͺ�</td>
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
              <a href="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpLregist1' property='policyNo'/>&editType=ADD&nodeType=regis&damageDate=<bean:write name='prpLregist1' property='damageDate'/>&damageHour=<bean:write name='prpLregist1' property='damageHour'/>&editRegistFlag=ADDFLAG" onclick="return otherFlag('<bean:write name='prpLregist1' property='othFlag'/>','<bean:write name='prpLregist1' property='underWriteFlag'/>')">
                 <font color="red"><bean:write name="prpLregist1" property="policyNo"/></font>
              </a>
          </td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="insuredName"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="licenseNo"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="brandName"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="startDate"/></font></td>
          <td align="center"><font color="red"><bean:write name="prpLregist1" property="endDate"/></font></td>
        </logic:equal>
        <input type="hidden" name="validDate" value="<bean:write name='prppheadDto' property='validDate'/>">
      
        <logic:notEqual name="prpLregist1" property="colorFlag" value='1'>
          <td align="center">
              <a href="/claim/registBeforeEdit.do?prpCmainPolicyNo=<bean:write name='prpLregist1' property='policyNo'/>&editType=ADD&nodeType=regis&damageDate=<bean:write name='prpLregist1' property='damageDate'/>&damageHour=<bean:write name='prpLregist1' property='damageHour'/>&editRegistFlag=ADDFLAG" onclick="return otherFlag('<bean:write name='prpLregist1' property='othFlag'/>','<bean:write name='prpLregist1' property='underWriteFlag'/>')">
                  <bean:write name="prpLregist1" property="policyNo"/>
             </a>
              
    <input type="hidden" name="endorType" value="<bean:write name='prppheadDto' property='endorType'/>">
          </td>
          <td align="center"><bean:write name="prpLregist1" property="insuredName"/></td>
          <td align="center"><bean:write name="prpLregist1" property="licenseNo"/></td>
          <td align="center"><bean:write name="prpLregist1" property="brandName"/></td>
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
	<input type="hidden" name="DamageDate" value="<%=request.getParameter("DamageDate") %>">
	<input type="hidden" name="DamageHour" value="<%=request.getParameter("DamageHour") %>">
    <input type="hidden" name="editType" value="RegistBeforeQuery">
    <input type="hidden" name="FCardID" value="<%=request.getParameter("FCardID") %>">
	<input type="hidden" name="Fname1" value="<%=request.getParameter("Fname1") %>">
	<input type="hidden" name="FamilyNo" value="<%=request.getParameter("FamilyNo") %>">
	<input type="hidden" name="FamilyFIDCard" value="<%=request.getParameter("FamilyFIDCard") %>">

 <%  	}
%> 
</form>
</body>

</html:html>