<%@ page contentType="text/html; charset=GBK" %>
<%@page import="java.util.List"%>
<html>
<head>
<title>单证上传</title>
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
		message = "单证上传成功!";
	}
	else if("-2".equals(result)){
		message = "上传文件大小超过限制,不允许上传（文件大小不能超过1.5M）！";
	}
	else if("-1".equals(result)){
		message = "登录超时，请重新登录!";
	}
	else{
		message = "单证上传失败!";
	}

%>
<body>
	<br/><br/><br/>
	<table align="center" width="90%">
		<tr><td align="center">信息提示: <%=message %></td></tr>
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
			<input type="button" class="button" value="继续上传" onclick="window.history.back()"/>
			<input type="button" class="button" value=" 关 闭 " onclick="closeWindow()"/>
		</td></tr>
	</table>
</body>
</html>