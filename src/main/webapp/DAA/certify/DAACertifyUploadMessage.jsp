<%@ page contentType="text/html; charset=GBK" %>
<%@page import="java.util.List"%>
<html>
<head>
<title>��֤�ϴ�</title>
<style type="text/css">
	INPUT.button
	{
	   color: #000000;
		 background-image: url(/claim/images/BgButton.gif);
		 text-align: center;
		 height: 22px;
		 width: 72px;
		 border: none;
	}
	body{
		font-size: 12px;
	}
</style>
<script type="text/javascript">
	function closeWindow(){
		window.opener.location.reload();
		window.close();
	}
</script>
</head>
<%
	String result = (String)request.getAttribute("result");
	String message = "";
	
	if("1".equals(result)){
		message = "��֤�ϴ��ɹ�!";
	}
	else if("-2".equals(result)){
		message = "�ϴ��ļ���С��������,�������ϴ����ļ���С���ܳ���1.5M����";
	}
	else if("-1".equals(result)){
		message = "��¼��ʱ�������µ�¼!";
	}
	else{
		message = "��֤�ϴ�ʧ��!";
	}

%>
<body>
	<br/><br/><br/>
	<table align="center" width="90%">
		<tr><td align="center">��Ϣ��ʾ: <%=message %></td></tr>
		<tr>
			<td>
				<% 
				if("-2".equals(result)){
					List uppers = (List)request.getAttribute("uppers");
					for(int i = 0;i < uppers.size();i++){
						out.println(uppers.get(i) + "<br/>");
					}
				}
				%>	
			</td>
		</tr>
		<tr><td align="center">
			<br/>
			<input type="button" class="button" value="�����ϴ�" onclick="window.history.back()"/>
			<input type="button" class="button" value=" �� �� " onclick="closeWindow()"/>
		</td></tr>
	</table>
</body>
</html>