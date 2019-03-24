<%@ page contentType="text/html; charset=GBK" %>
<%
	String message = (String)request.getAttribute("message");
%>

<html>
	<head>
	  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	</head>
	
	<body >
		<table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center" id="messageTable">
			<tr>
		       <td class=formtitle colspan="2"><bean:message key="prompt.system.title"/></td>
		     </tr>
		    <tr>
		      <td  class="common">
		        <img src='/claim/images/bgClaimSuccess.gif'>
		      </td>
		      <td  class="common">
		     	<%=message %>
		      </td>
			</tr>  
		  </table>
	</body>
</html>