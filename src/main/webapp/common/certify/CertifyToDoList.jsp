<%--
****************************************************************************
* DESC       ����֤���
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-05
* MODIFYLIST ��   id       Date            Reason/Contents
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
  ����������
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >

<table class="common" cellpadding="5" cellspacing="1" >
<tr><td colspan=4 class="formtitle">����������</td></tr>
   <tr>
      <td class="centertitle" >������</td>
      <td class="centertitle" >������</td>
      <td class="centertitle" >����Ա</td>
      <td class="centertitle" >�䵥����</td>
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
         ����ѯ��<%= index %>�����������ļ�¼
        </td>
      </tr>
  </table>
  </tr>
</table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>