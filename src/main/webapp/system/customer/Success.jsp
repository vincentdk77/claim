<%--
 *************************************************************************
 * ��������: MessagePage.jsp
 * ������: ��Ϣ����ҳ��
 * ���������: weishixin
 * �����������: 2004-03-29
 ****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>

<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>
<body class="interface">

   <table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center">
     <tr>
       <td class=formtitle colspan="2"></td>
     </tr>

    <tr>
      <td  class="common">
        <img src='/claim/images/bgClaimSuccess.gif'>
      </td>
      <td class="common">
           ����ͻ����ϳɹ���
      </td>
    </tr>
  </table>
<%
  UserDto user = (UserDto) session.getAttribute("user");
  //user.setUserMessage(""); 
%>  
</body>
</html>
