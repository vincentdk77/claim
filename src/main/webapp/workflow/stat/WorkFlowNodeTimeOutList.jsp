<%--
****************************************************************************
* DESC       : ����ڵ�״̬��ʱ��ѯ���ҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-05-28
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
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="java.util.*" %>

<html xmlns:v="urn:schemas-microsoft-com:vml">
<head>
    <app:css />

  <title>
    �ڵ㳬ʱ��ѯ���
  </title>

  <STYLE>
  v\:* { BEHAVIOR: url(#default#VML) }
  </STYLE>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>


<body  >

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=6 class="formtitle">�ڵ㳬ʱ��ѯ���<td></tr>
     <tr>
         <td class="centertitle" >��ʱʱ��(��)</td>
         <td class="centertitle" >�������ҵ�����</td>
         <td class="centertitle" >�ڵ�����</td>
         <td class="centertitle" >״̬����</td>
         <td class="centertitle" >������ʱ��</td>
         <td class="centertitle" >����Ա����</td>
     </tr>
     <%int index=0;%>

     <logic:notEmpty  name="swfLogDto"  property="swfLogList">
     <logic:iterate id="swfLogNode"  name="swfLogDto"  property="swfLogList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
      <tr class=common>  <td align="center"><bean:write name="swfLogNode" property="timeLimit"/></td>
        <td align="center"><bean:write name="swfLogNode" property="keyIn"/></td>
        <td align="center"><bean:write name="swfLogNode" property="nodeTypeName"/></td>
        <td align="center"><bean:write name="swfLogNode" property="nodeStatusName"/></td>
        <td align="center"><bean:write name="swfLogNode" property="handleTime"/> </td>
        <td align="center"><bean:write name="swfLogNode" property="handlerName"/></td>
      </tr>
<%        index++;
 %>
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

<script language = "javascript">
<!--
 // drawBars();
//-->
</script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
<html>
