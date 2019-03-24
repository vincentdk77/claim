<%--
****************************************************************************
* DESC       £º
* AUTHOR     £ºlijiyuan
* CREATEDATE £º2004-03-01
* MODIFYLIST £º   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@page import="com.sinosoft.claim.dto.custom.UserDto"%>
<%@page import="javax.servlet.http.*"%>

<%
	UserDto   user     = (UserDto)session.getAttribute("user");
	String claimPerson =user.getUserName();
	if(claimPerson==null){
		claimPerson="";
	}
%>



<html>
	<head>
	</head>
	<body>
		<form name="fm">
			<table>
				<tr>
					<td>
						<input type="hidden" name="claimPerson" value="<%=claimPerson %>" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

<script type="text/javascript">
function submitform(){
	var claimPerson = fm.claimPerson.value;
	window.location = "/selfquery/result/queryPolicyCondition.jsp?claimPerson="+claimPerson;
}

submitform();
</script>