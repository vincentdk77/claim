<%--
****************************************************************************
* DESC       ��������ѯ�����ʾҳ��
* AUTHOR     ��lijiyuan
* CREATEDATE ��2004-03-01
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

  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
  <script language="javascript">
  <%--����״̬��־����--%>
  <!--
    function submitForm()
    {
      fm.submit();//�ύ
    }
  //-->
  </script>
</head>

<body  >

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=5 class="formtitle"><bean:message key="title.claimBeforeEdit.titleName" /></td></tr>
     <tr>
        <td class="centertitle" >����״̬</td>
        <td class="centertitle" ><bean:message key="db.prpLclaim.claimNo"/></td>
        <td class="centertitle" >����Ա</td>
        <td class="centertitle" >����ʱ��</td>
        <td class="centertitle" >����(Ԥ��/Ԥ��/ͨ��)</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogDto1"  name="swfLogDto"  property="swfLogList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
        <td align="center">
        <logic:equal name="swfLogDto1" property="nodeStatus" value='1' >
         ������
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='2' >
         ������
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='3' >
         �Ѵ���
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='4' >
         ���ύ
        </logic:equal>
        <logic:equal name="swfLogDto1" property="nodeStatus" value='5' >
         �ѳ���
        </logic:equal>
        </td>
        <td align="center"><a href="/claim/claimFinishQueryList.do?prpLclaimClaimNo=<bean:write name='swfLogDto1' property='businessNo'/>&editType=SHOW&riskCode=<bean:write name="swfLogDto1" property="riskCode"/>"><bean:write name="swfLogDto1" property="businessNo"/></a></td>
        <td align="center"><bean:write name="swfLogDto1" property="handlerCode"/></td>
        <td align="center"><bean:write name="swfLogDto1" property="handleTime"/></td>
        <td align="center">
          <A href="/claim/common/compensate/CompensateBeforeEdit.jsp?ClaimNo=<bean:write name='swfLogDto1' property='businessNo'/>&editType=ADD&caseType=4&swfLogFlowID=<bean:write name='swfLogDto1' property='flowID'/>&swfLogLogNo=<bean:write name='swfLogDto1' property='logNo'/>&riskCode=<bean:write name='swfLogDto1' property='riskCode'/>&status=<bean:write name='swfLogDto1' property='nodeStatus'/>&nodeType=<bean:write name='swfLogDto1' property='nodeType'/>&businessNo=<bean:write name='swfLogDto1' property='businessNo'/>">Ԥ��</A>
          <A href="/claim/prepayBeforeEdit.do?ClaimNo=<bean:write name='swfLogDto1' property='businessNo'/>&editType=ADD&caseType=5&swfLogFlowID=<bean:write name='swfLogDto1' property='flowID'/>&swfLogLogNo=<bean:write name='swfLogDto1' property='logNo'/>">Ԥ��</A>
          <A href="/claim/common/compensate/CompensateBeforeEdit.jsp?ClaimNo=<bean:write name='swfLogDto1' property='businessNo'/>&editType=ADD&caseType=3&swfLogFlowID=<bean:write name='swfLogDto1' property='flowID'/>&swfLogLogNo=<bean:write name='swfLogDto1' property='logNo'/>&riskCode=<bean:write name='swfLogDto1' property='riskCode'/>&status=<bean:write name='swfLogDto1' property='nodeStatus'/>&nodeType=<bean:write name='swfLogDto1' property='nodeType'/>&businessNo=<bean:write name='swfLogDto1' property='businessNo'/>">ͨ��</A>
        </td>
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