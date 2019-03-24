<%--
****************************************************************************
* DESC       ��������
* AUTHOR     ��liubvo
* CREATEDATE ��2004-07-13
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
  <bean:message key="title.claimBeforeEdit.queryClaim"/>
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >

<table  class="common" cellpadding="5" cellspacing="1" >

<tr>  <td colspan=5 class="formtitle">��ѯ������Ϣ</td></tr>
   <tr>
      <td class="centertitle" >����״̬</td>
      <td class="centertitle" >������</td>
      <td class="centertitle" ><bean:message key="db.prpLclaim.policyNo"/></td>
      <td class="centertitle" >�����˴���</td>
      <td class="centertitle" >����/����������</td>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLverifyLossDto"  property="verifyLossList">
   <logic:iterate id="prpLverifyLoss1"  name="prpLverifyLossDto"  property="verifyLossList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>    <tr class=common><td align="center">
        <logic:equal name="prpLverifyLoss1" property="status" value='1' >
         δ����
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='2' >
         ������
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='3' >
         �Ѵ���
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='4' >
         ���ύ
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='5' >
         �ѳ���
        </logic:equal>
      </td>
      <td align="center"> <a href="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo=<bean:write name='prpLverifyLoss1' property='registNo'/>&editType=EDIT&nodeType=certa"> <bean:write name="prpLverifyLoss1" property="registNo"/></a></td>
      <td align="center"><bean:write name="prpLverifyLoss1" property="policyNo"/></td>
      <td align="center"><bean:write name="prpLverifyLoss1" property="handlerCode"/></td>
      <td align="center"><bean:write name="prpLverifyLoss1" property="defLossDate"/></td>
    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="5">
	       ����ѯ��<%= index %>�����������ļ�¼
	      </td>
      </tr>
  </table>
  </tr>
</table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>