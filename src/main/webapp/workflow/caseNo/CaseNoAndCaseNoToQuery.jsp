<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>

<html:html locale="true">
<head>
  <title>�����Ż�������</title>
  <%-- ���ú��� --%>
  <script src="/claim/common/Common.js"></script>
  <script src="/claim/workflow/caseNo/js/CaseNoAndCaseNoToQuery.js"></script>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
</head>
<body>
<form id="fm" name="fm" action="/claim/caseNoQueryDxfl.do?editType=query"  method="post" onsubmit="return validateForm(this);" target="resultList">
  <table width="98%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
  <tr> <td colspan=4 class="formtitle">�����Ż���</td></tr>
  <tr class='title'>
     <td class='title' valign=middle>������</td>
     <td class='input' valign=middle>
          <select name="policyNoSign" class=tag >
            <option value="=">=</option>
            <!-- <option value="*">*</option> -->
          </select>
      	<input type="text" id="policyNo" name="policyNo" class="query" >
      </td>
       <td rowspan="5" style="width:80%">
           <select name="queryType" class=tag  style="width:20%">
            <option value="policyNo">������</option>
            <option value="registNo">������</option>
            <option value="claimNo">������</option>
            <option value="compensateNo">�������</option>
            <option value="caseNoSign">�᰸��</option>
          </select>
          <textarea class=common1 id="noList" name="noList" style="width:98%" rows="10"></textarea>
       	 
       </td>
  </tr>
  <tr class='title'>
  	<td class='title'>������</td>
     <td class='input' >
          <select name="registNoSign" class=tag >
            <option value="=">=</option>
           <!-- <option value="*">*</option> -->
          </select>
      	<input type="text" id="registNo" name="registNo" class="query">
      </td>
  </tr>
  <tr class='title'>
     <td class='title'>������</td>
     <td class='input' >
          <select name="claimNoSign" class=tag >
            <option value="=">=</option>
           <!-- <option value="*">*</option> -->
          </select>
      	<input type="text"  id="claimNo" name="claimNo" class="query">
      </td>
  </tr>
  <tr class='title'>
     <td class='title'>�������</td>
     <td class='input' >
          <select name="compensateNoSign" class=tag >
            <option value="=">=</option>
          <!--  <option value="*">*</option> -->
          </select>
      	<input type="text" id="compensateNo" name="compensateNo" class="query">
      </td>
  </tr>
  <tr class='title'>
     <td class='title'>�᰸��</td>
     <td class='input' >
          <select name="caseNoSign" class=tag >
            <option value="=">=</option>
           <!-- <option value="*">*</option> -->
          </select>
      	<input type="text" id="caseNo" name="caseNo" class="query">
      </td>
  </tr>
  <tr align="center">
    <td colspan="4">
    <input type="button" class="button" id="backButton" value="��ѯ" onclick="submit1()"/>
    </td>
  </tr>
  
   </table>
   </form>
   <iframe name="resultList" style="width:100%;height:100%"  marginwidth="0" frameborder="0" scrolling="no"></iframe>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>

