<%--
****************************************************************************
* DESC       ：单证结果
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-05
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <app:css />

  <title>
  待处理任务
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >

<table class="common" cellpadding="5" cellspacing="1" >
<tr><td colspan=4 class="formtitle">待处理任务</td></tr>
   <tr>
      <td class="centertitle" >报案号</td>
      <td class="centertitle" >保单号</td>
      <td class="centertitle" >操作员</td>
      <td class="centertitle" >输单日期</td>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLcertifyCollectDto"  property="certifyCollectList">
   <logic:iterate id="prpLcertify1"  name="prpLcertifyCollectDto"  property="certifyCollectList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%><tr class=common>
      <td align="center"><bean:write name="prpLcertify1" property="businessNo"/></td>
      <td align="center"><bean:write name="prpLcertify1" property="policyNo"/></td>
      <td align="center"><bean:write name="prpLcertify1" property="handlerCode"/></td>
      <td align="center"><bean:write name="prpLcertify1" property="inputDate"/></td>
    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
        <td colspan="4">
         共查询出<%= index %>条满足条件的记录
        </td>
      </tr>
  </table>
  </tr>
</table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>