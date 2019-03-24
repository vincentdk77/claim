<%--
****************************************************************************
* DESC       ��ѯ������Ϣ
* AUTHOR     �� qinyongli
* CREATEDATE �� 2005-09-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.common.datatype.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>


<script  type="text/javascript">
    	function submitForm(){
              fm.queryButton.disabled=true;
	          fm.submit();//�ύ
	          setTimeout('fm.queryButton.disabled=false',5000);
    		  //return true ;
    		
    	}
    </script>
<html:html locale="true">
<head>
  <title>��ѯ������Ϣ</title>
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/modifySumClaim.do"  method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="editType" value="modifyBeforeQuery">
    <input type="hidden" name="isFirst" value="N" />
    <input type="hidden" name="riskType" value="<%=request.getParameter("riskType") %>" >
    <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1"  class="common">
      <tr>

	          <td colspan="4" class="formtitle">��ѯ������Ϣ</td>

	        </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLclaim.claimNo" />��</td>
        <td class='input' >
        <select class=tag name="ClaimNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query" >
        </td>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />��</td>
        <td class='input' >
        <select class=tag name="PolicyNoSign" >
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
      </tr>
      <tr>  
        <td class='title' >�����������ƣ�</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>
        <td class='title' >����:</td>
        <td class='input' >  
             <select class=tag name="RiskCodeSign" >
                <option value="=">=&nbsp;</option>
             </select> <input type=text name="RiskCode" class="query" > </td>
      </tr>
      </table>
      <table width=100%>
      <tr>
       <td class='button' colspan="4">
          <!--  <input type=submit class='button' value="<bean:message key='button.query.value' />">-->
           <input type=button class='button' name="queryButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>

    </table>
<%if(request.getAttribute("isFirst").equals("N")){ %>
  <table  width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
        <td colspan="5" class="formtitle">����������(��������ŵ���������)</td>
     </tr>
     <tr>
        <td class="formtitle">������</td><td class="formtitle">������</td>
        <td class="formtitle">����</td><td class="formtitle">��������</td><td class="formtitle">����ʱ��</td>
     </tr>

     <logic:iterate id="prpLclaimDto"  name="claimList">
      <tr class=listodd>
           <td align="center">
               <a href = "/claim/modifySumClaim.do?editType=modifyDetail&claimNo=<bean:write name='prpLclaimDto' property='claimNo' filter='true' /> ">
               <bean:write name='prpLclaimDto' property='claimNo' filter='true' />  </a>
           </td>
           <td align="center">
               <bean:write name='prpLclaimDto' property='policyNo' filter='true' />
           </td>
           <td align="center">
               <bean:write name='prpLclaimDto' property='riskCode' filter='true' />
           </td>
           <td align="center">
               <bean:write name='prpLclaimDto' property='insuredName' filter='true' />
           </td>
           <td align="center">
               <bean:write name='prpLclaimDto' property='claimDate' filter='true' />
           </td>
      </tr>
     </logic:iterate>
      <%
          int curPage = ((TurnPageDto)request.getAttribute("pageview")).getPageNo();
      %>
 </table>

 <%@include file="/common/pub/TurnOverPage.jsp" %>
<%} %>
   </form>
</body>
</html:html>
