<%--
****************************************************************************
* DESC       ��������ѯ�������ҳ��
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

<%
    //modify by wangwei add start 2005-06-04
    //ԭ����ҳ��������һ����ӡ��ť
%>
  <script language="javascript">
  <%--����״̬��־����--%>
    function submitForm()
    {
      fm.submit();//�ύ
    }
  </script>
<!--modify by wangwei add end 2005-06-04-->

<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.registBeforeEdit.queryRegist"/></title>
  <html:base/>
</head>

<body >
<form name="fm" action="/claim/processLinkRecord.do"  method="post" >
        <input type="hidden" name="pageFlag">
        <input type="hidden" name="editType" value="queryList">
        <input type="hidden" name="nodeType" value="claim">

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=4 class="formtitle">������ϵ��¼����б�</td></tr>
     <tr>
        <!--<td class="centertitle" >����״̬</td> -->
        <td class="centertitle" ><bean:message key="db.prpLclaim.claimNo"/></td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >����Ա</td>
        <td class="centertitle" >����ʱ��</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLclaimDto"  property="claimList">
     <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
        <td align="center"><a href="/claim/processLinkRecord.do?claimNo=<bean:write name='prpLclaim1' property='claimNo'/>&editType=view&riskCode=<bean:write name="prpLclaim1" property="riskCode"/>"><bean:write name="prpLclaim1" property="claimNo"/></a></td>
        <td align="center"><bean:write name="prpLclaim1" property="registNo"/></td>
        <td align="center"><bean:write name="prpLclaim1" property="operatorCode"/></td>
        <td align="center"><bean:write name="prpLclaim1" property="operateDate"/></td>
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
    </table>
    </tr>
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</form>
</body>
</html:html>