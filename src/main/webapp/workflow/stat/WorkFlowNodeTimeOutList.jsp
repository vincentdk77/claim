<%--
****************************************************************************
* DESC       : 理赔节点状态超时查询结果页面
* AUTHOR     : liubvo
* CREATEDATE ：2004-05-28
* MODIFYLIST ：   id       Date            Reason/Contents
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
    节点超时查询结果
  </title>

  <STYLE>
  v\:* { BEHAVIOR: url(#default#VML) }
  </STYLE>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>


<body  >

  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=6 class="formtitle">节点超时查询结果<td></tr>
     <tr>
         <td class="centertitle" >超时时间(天)</td>
         <td class="centertitle" >待处理的业务号码</td>
         <td class="centertitle" >节点名称</td>
         <td class="centertitle" >状态名称</td>
         <td class="centertitle" >最后操作时间</td>
         <td class="centertitle" >操作员名称</td>
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
	       共查询出<%= index %>条满足条件的记录
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
