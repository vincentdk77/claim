<%--
 *************************************************************************
 * 程序名称: MessagePage.jsp
 * 程序功能: 信息反馈页面
 * 最近更新人: weishixin
 * 最近更新日期: 2004-03-29
 ****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<html>
<head>
  <title><bean:message key="error.regist.required"/></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>
<body class="interface">

   <table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center">
     <tr>
       <td class=formtitle colspan="2"><bean:message key="error.title"/></td>
     </tr>

    <tr>
      <td  class="common">
        <img src='/claim/images/bgClaimFailure.gif'>
      </td>
      <td class="common">
       	<html:messages id="error">
         <span id="false"><c:out value="${error}"/></span><br>
         <c:out value="${errorMessage}"/>
       	</html:messages>
      </td>
    </tr>
  </table>
</body>
</html>