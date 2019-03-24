<%--
****************************************************************************
* DESC       ：结案信息查询结果
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-28
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<!---add by zhaolu 20060803 start--->
<%@ page import="com.sinosoft.claim.dto.domain.PrpLcaseNoDto" %>
<!---add by zhaolu 20060803 end--->
<html:html locale="true">
<head>
    <app:css />

  <title>
    <bean:message key="title.claimBeforeEdit.queryClaim"/>
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >
<!---add by zhaolu 20060803 start--->
<form name="fm" action="/claim/endcaseQuery.do"  method="post"> 
<!---add by zhaolu 20060803 end--->
<table  class="common" cellpadding="5" cellspacing="1" >
<tr>
 <td colspan=5 class="formtitle">查询结案信息</td></tr>
   <tr>
      <td class="centertitle" >立案号</td>
      <td class="centertitle" >归档号</td>
      <td class="centertitle" >保单号</td>
      <td class="centertitle" >结案员</td>
      <td class="centertitle" >结案时间</td>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLcaseNoDto"  property="caseList">
   <logic:iterate id="caseList1"  name="prpLcaseNoDto"  property="caseList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
      <td align="center"><a href="/claim/endcaseFinishQueryList.do?prpLendcaseEndcaseNo=<bean:write name='caseList1' property='claimNo'/>&editType=<bean:write name='prpLcaseNoDto' property='editType'/>&riskCode=<bean:write name="caseList1" property="riskCode"/>&ClaimNoSign=*"> <bean:write name="caseList1" property="claimNo"/></a></td>
      <td align="center"><bean:write name="caseList1" property="caseNo"/></td>
      <td align="center"><bean:write name="caseList1" property="policyNo"/></td>
      <td align="center"><bean:write name="caseList1" property="endCaserCode"/></td>
      <td align="center"><bean:write name="caseList1" property="endCaseDate"/></td>
   </tr>
<% index++;%>
    </logic:iterate>
    </logic:notEmpty>
   <tr class="listtail">
     <td colspan="5">
     <!--- add by zhaolu 20060803 start --->
       <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLcaseNoDto" property="turnPageDto"/>  
<% 
  PrpLcaseNoDto prpLcaseNoDto = (PrpLcaseNoDto)request.getAttribute("prpLcaseNoDto"); 
  int curPage = prpLcaseNoDto.getTurnPageDto().getPageNo(); 
%>                   
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
           <!--- add by zhaolu 20060803 start --->
     </td>
   </tr>
</table>
<!--- add by zhaolu 20060803 start --->
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
</form>
<!--- add by zhaolu 20060803 end  --->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>