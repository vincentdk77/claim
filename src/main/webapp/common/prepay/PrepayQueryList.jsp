<%--
****************************************************************************
* DESC       ��Ԥ����������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-07
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

  <title>Ԥ������</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body >


  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr>     <td colspan=6 class="formtitle">Ԥ���ѯ�����Ϣ</td></tr>
     <tr>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" >Ԥ��ǼǺ�</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >����Ա</td>
        <td class="centertitle" >����ʱ��</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLprepayDto"  property="claimList">
     <logic:iterate id="prpLprepay1"  name="prpLprepayDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common><td align="center">
        <logic:equal name="prpLprepay1" property="status" value='1' >
         δ����
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='2' >
         ������
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='3' >
         �Ѵ���
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='4' >
         ���ύ
        </logic:equal>
        <logic:equal name="prpLprepay1" property="status" value='5' >
         �ѳ���
        </logic:equal>
      </td>
        <td align="center"> <a href="/claim/prepayFinishQueryList.do?prpLprepayPrepayNo=<bean:write name='prpLprepay1' property='preCompensateNo'/>&editType=<bean:write name='prpLprepayDto' property='editType'/>&riskCode=<bean:write name='prpLprepay1' property='riskCode'/>"><bean:write name="prpLprepay1" property="preCompensateNo"/></a></td>
        <td align="center"><bean:write name="prpLprepay1" property="claimNo"/></td>
        <td align="center"><bean:write name="prpLprepay1" property="policyNo"/></td>
        <td align="center"><bean:write name="prpLprepay1" property="handlerCode"/></td>
        <td align="center"><bean:write name="prpLprepay1" property="operateDate"/></td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
   <tr class="listtail">
     <td colspan="6">
       ����ѯ��<%= index %>�����������ļ�¼
     </td>
   </tr>
    </table>
    </tr>
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>