<%--
*****************************************************
*DESC          : 修改用户密码
*AUTHOR        : wangwei
*CREATEDATE    : 2005-08-28
*MODIFYLIST     :     NAME     DATE    REASON
*                  ---------------------------------
*****************************************************
--%>

<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>

<%
  UserDto userDto   = (UserDto)session.getAttribute("user");
  String UserCode = (String) userDto.getUserCode();
  String UserName = (String) userDto.getUserName();
%>

<html>
<head>
  <title>update password</title>
  <!-- 页面样式  -->
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script language=Javascript>
    function mySubmit()
    {
      if(fm.newPassword.value == fm.retypeNewPassword.value)
      {
        fm.submit(); //提交
      }else
      {
        alert("新密码校验错误，请重新输入新密码");
        fm.newPassword.value       = "";
        fm.retypeNewPassword.value = "";
      }
    }
    function myReset()
    {
        fm.reset();
    }
  </script>
</head>
<body class="interface">
<form action="/claim/UIUpdatePwd.do" method=post name=fm>
  <table class=three align="center" style = "width:400">
  	<tr>
      	<td class=formtitle colspan="2">
      		用户密码修改
      	</td>
    </tr>
    <tr>
        <td class="title" style = "width:50%">用户名：</td>
        <td class="input" style = "width:50%">
          <input name='userName' class=readonly readonly value='<%=UserName%>'>
          <input type=hidden name='userCode' value='<%=UserCode%>'>
        </td>
    </tr>
    <tr>
        <td class="title">原密码:</td>
        <td class="input"><input class=common type="password" name='oldPassword'></td>
    </tr>
    <tr>
        <td class="title">新密码:</td>
        <td class="input"><input class=common type="password" name='newPassword'></td>
    </tr>
    <tr>
        <td class="title">重复新密码:</td>
        <td class="input"><input class=common type="password" name='retypeNewPassword'></td>
    </tr>
    <tr align=center>
      <td>
        <input class="button" type="button" alt=" 确 定 " value="确 定" onclick="mySubmit()">
      </td>
      <td>
        <input class="button" type="button" alt=" 重 写 " value="重 写" onclick="myReset()">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
