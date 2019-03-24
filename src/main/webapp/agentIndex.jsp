<%--
****************************************************************************
* DESC       ：大地座席业务系统主页面
* AUTHOR     ：sinosoft
* CREATEDATE ：2005-06-22 
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>   


<html:html locale="true">
<head>
	<title>客户服务管理系统</title>
        <app:css />
	<html:base/>
	<%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<STYLE>BODY {
	      SCROLLBAR-FACE-COLOR:#D9D9D9;
        SCROLLBAR-HIGHLIGHT-COLOR:#FFFFFF;
        SCROLLBAR-SHADOW-COLOR:#FFFFFF;
        SCROLLBAR-3DLIGHT-COLOR:#D9D9D9;
        SCROLLBAR-ARROW-COLOR:#D9D9D9;
        SCROLLBAR-TRACK-COLOR:#D9D9D9;
        SCROLLBAR-DARKSHADOW-COLOR:#D9D9D9;
}
</STYLE>
<script language="JavaScript">
<!--
  function submitForm(){
    if(verifyLogin()==false) return false;
     //fm.target="fraSet";
    fm.imageField.disabled=true;
    fm.submit();
  }
   function verifyLogin(){

   if(document.fm.prpDuserUserCode.value==""){
      alert("工号不能为空，请重新输入");
        return false;
        }

    if(document.fm.prpDuserPassword.value==""){
        alert("密码不能为空，请重新输入");
        return false;
        }
        fm.actionType.value="LogOn";
        return true;	
    }

   function isUser(){
      var loginMessage = fm.loginMessage.value;
      if(loginMessage!=""){
       alert(loginMessage);
       fm.loginMessage.value = "";
       }
     }
   function submitForm(){
      fm.action = "/claim/logonin.do";
      fm.submit();
   }
 //-->
</script>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="isUser();submitForm()" style="display:none">
  <%    
     //UserDto userDto1 = (UserDto)session.getAttribute("userDto");
     //String loginMessage = "";
     //if(userDto1!=null){
     //  loginMessage = userDto1.getLoginMessage();
     //}
     //if(loginMessage==null){
     //  loginMessage = "";
     //}
     //session.removeAttribute("userDto");  //清空uerDto
  %>

	<html:errors />

  <form name=fm action="/claim/agentLogonin.do" focus="prpDuserUserCode" method="post">
    <input type="hidden" name="loginMessage" class="common" value="">  
           <input type=hidden name=actionType> 
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="bottom">
                 <table width="100%" border="0" cellspacing="0" cellpadding="0">
                   <tr> 
                      <td><img src="images/ImgAgentflowLogo.jpg" width="366" height="27"></td>
                    </tr>
                  </table> 
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td width="465" rowspan="3"><img src="images/ImgAgentflow.jpg" width="465" height="225"></td>
                      <td height="3" bgcolor="#2E8EE2"></td> 
                    </tr>
                    <tr> 
                      <td height="219" align="center" bgcolor="#1F6FB4"> 
                        <table width="299" border="0" cellspacing="0" cellpadding="5">
                          <tr> 
                            <td align="center" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="images/ImgAgentflowLogo5.jpg" width="299" height="32"></td>
                          </tr>
                          <tr> 
                            <td class="logon"  style="width:30%" align="right">工　号：</td>
                            <td><input type="text" styleClass="index" name="prpDuserUserCode" style="width:200px" maxlength="10" value="<%=request.getParameter("userCode") %>"/> 
                            </td>
                          </tr>
                          <tr> 
                            <td class="logon" style="width:30%" align="right">密　码：</td>
                            <td>
                                <input type="password" styleClass="index" name="prpDuserPassword" style="width:200px" maxlength="40" value="<%=request.getParameter("userPassword") %>"/>
                                <input type="text" class="codecode" name="prpDuserComCode" maxlength="10" value="<%=request.getParameter("userComCode") %>"/>
                                <input type="text" class="codecode" name="system" maxlength="10" value="<%=request.getParameter("system") %>"/>
                            </td>
                          </tr>
                          <tr> 
                            <td height="50" align="right" colspan='2'> <input name="imageField" type="button" value=" 登 录 " onClick="submitForm();">
                              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr> 
                      <td height="3" bgcolor="#2E8EE2"></td>
                    </tr>
                  </table>
                  <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td align="right">
                        <table width="50%" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td height="120" align="center" valign="bottom"><img src="images/ImgAgentflowLogo3.jpg" width="203" height="111"></td>
                          </tr>
                          <tr>
                            <td height="45" align="center" class="grey">技术支持: 中科软科技股份有限公司</td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
        </td>
      </tr>
    </table> 
<p>               
</form>
</body>
</html:html>