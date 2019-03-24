<%--
****************************************************************************
* DESC       �������¼
* AUTHOR     ��zhouxianli
* CREATEDATE ��2005-06-19
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

<html:html locale="true">
<head>
    <app:css />
    
  <title>�����¼</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >
<form name="fm" action="/claim/lacciCheckBeforeQuery.do?editType=LacciCheckBeforeQuery"  method="post">
 
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr> <td colspan=7 class="formtitle">�����¼</td></tr>
     <tr>
        <td class="centertitle">�������ݼ�Ҫ����</td>
        <td class="centertitle">����ڵ�</td>
        <td class="centertitle">�������</td>
        <td class="centertitle">���鷽ʽ</td>
        <td class="centertitle">������ʼ����</td>
        <td class="centertitle">�����������</td>
        <td class="centertitle">�����˴���</td>
     </tr>
     <%int index=0;   %>
     <logic:notEmpty  name="prpLregistDto"  property="registList">
     <logic:iterate id="prpLacciCheck"  name="prpLregistDto"  property="registList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
         <tr class=common> <td align="center"><!--a href="/claim/lacciCheckBeforeQuery.do?CheckNo=<bean:write name='prpLacciCheck' property='checkNo'/>&editType=SHOW"!-->
<bean:write name="prpLacciCheck" property="checkContext"/>

          <!--/a!-->
</td>
          <td align="center">
              <logic:equal name="prpLacciCheck" property="certiType" value='01'>����</logic:equal>
              <logic:equal name="prpLacciCheck" property="certiType" value='03'>����</logic:equal>
              <logic:equal name="prpLacciCheck" property="certiType" value='04'>Ԥ��</logic:equal>
              <logic:equal name="prpLacciCheck" property="certiType" value='05'>������</logic:equal>
          </td>
           <td align="center"><bean:write name="prpLacciCheck" property="checkObjectDesc"/></td>
          <td align="center"> <!--bean:write name="prpLacciCheck" property="checkNature"/>modify reason:���鷽ʽ��ʾ���֣�����ʾ����-->
          <logic:equal name="prpLacciCheck" property="checkNature" value='0'>ֱ�ӵ���</logic:equal>
          <logic:equal name="prpLacciCheck" property="checkNature" value='1'>��ӵ���</logic:equal>
          </td>
          
          <td align="center"><bean:write name="prpLacciCheck" property="checkDate"/></td>
          <td align="center"><bean:write name="prpLacciCheck" property="checkEndDate"/></td>
          <td align="center"><bean:write name="prpLacciCheck" property="checkerCode"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      <tr class="listtail">
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
    </tr>
  </table>
    <input type="hidden" name="editType" value="LacciCheckBeforeQuery">
</form>
</body>
</html:html>