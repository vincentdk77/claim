<%--
****************************************************************************
* DESC       ：用户登录页面
* AUTHOR     ：lixiang
* CREATEDATE ：2004-03-23
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
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<title>理赔工作流系统</title>
        <app:css />
	<html:base/>
	
	
	<script language="Javascript" src="/claim/common/js/CodeSelect.js" ></script>
	<script language="Javascript" src="/claim/common/js/Common.js" ></script>
	<script language="Javascript" src="/claim/common/js/Application.js" ></script>
	<%-- 页面样式  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

<script language="JavaScript">
<!--
// modify by wangli add start 20050421
   function verifyLogin(){

   if(document.fm.prpDuserUserCode.value==""){
      alert("用户名不能为空，请重新输入");
        return false;
        }

    if(document.fm.prpDuserPassword.value==""){
        alert("密码不能为空，请重新输入");
        return false;
        }          
    if(document.fm.prpDuserComCode.value==""){
        alert("登录机构不能为空，请重新输入");
        return false;
        }

        return true;
    }

   function isUser(){
      var loginMessage = fm.loginMessage.value;
      if(loginMessage!=""){
       alert(loginMessage);
       fm.loginMessage.value = "";//清空loginMessage 隐藏域
       }
     }
// modify by wangli add end 20050421
 //-->
</script>
</head>

<%--//modify by wangli add start 20050422 --%>
<body class=logon leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="isUser();//window.open('/claim/broadcast.html','_blank','width=630,height=440,toolbar=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0')">
     <%
        UserDto userDto1 = (UserDto)session.getAttribute("userDto");
        String loginMessage = "";
        if(userDto1!=null){
        loginMessage = userDto1.getLoginMessage();
        }
        if(loginMessage==null){
        loginMessage = "";
        }
        session.removeAttribute("userDto");  //清空uerDto
        %>
<%--//modify by wangli add end 20050422 --%>
	<html:errors />
	<%-- // modify by wangli remark  20050421
	<html:form action="/logonin" focus="prpDuserUserCode">
	--%>
	    <%--// modify by wangli add start 20050421  --%>
	<form name=fm action="/claim/logonin.do" focus="prpDuserUserCode" method="post" onsubmit="return verifyLogin();">
	  <input type="hidden" name="loginMessage" class="common" value=<%=loginMessage%>>
             <%--// modify by wangli add end 20050421  --%>

       <table width="100%" height="100%"border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="center"> 
                    <table width="780" border="0" cellspacing="0" cellpadding="0">
                        <tr> 
                        <td><img src="images/ImgClaimflowLogo.gif" ></td>
                        </tr>
                    </table>
                    
                    <table width="780" border="0" cellspacing="0" cellpadding="0">
                        <tr> 
                        <td width="1" rowspan="2" bgcolor="#3D72D7"></td>
                        
                        <td width=325 height="140" align="center" background="images/BgLogon.gif">
                            <table width="285px" border="0" cellspacing="0" cellpadding="0">
                <tr> 
                  <td colspan="3"><img src="images/ImgClaimflowLogo2.gif" width="285" height="45"  align="absmiddle"></td>
                </tr>
                <tr> 
                  <td width="1" bgcolor="#999999"></td>
                  <td width="283" bgcolor="#FFFFFF" align=right><table width="100%" border="0" cellspacing="0" cellpadding="5">
                      <tr align="center"> 
                        <td colspan="2"><img src="images/ImgLogon_1.gif" width="267" height="55"></td>
                      </tr>
                      <tr> 
                        <td width="30%" align=right><img src="images/ImgUser.gif" ></td>
                        <td width="70%"><input type="text" class=logon name="prpDuserUserCode" maxlength="10"/></td>
                      </tr>
                      <tr> 
                        <td align=right><img src="images/ImgPassword.gif" ></td>
                        <td><input type="password" class=logon name="prpDuserPassword"  maxlength="40"/> </td>
                      </tr>
                      <tr> 
                        <td align=right><img src="images/logon-comcode.gif" ></td>
                        <td>
                          <input type="text" class="codecode" name="prpDuserComCode" maxlength="10" style="width:170px"
                              ondblclick="code_CodeSelect(this,'comCodeByUserCode','0','Y',addCondition('userCode',fm.prpDuserUserCode.value),'');" 
                              onkeyup="code_CodeSelect(this,'comCodeByUserCode','0','Y',addCondition('userCode',fm.prpDuserPassword.value),'');">
                          <iframe name=CodeFrame src="/claim/common/pub/QueryCodeInputOverview.jsp" style='DISPLAY:none;Z-INDEX:100;POSITION:absolute' marginwidth='0' marginheight='0' hspace='0' vspace='0' frameborder='0' scrolling='no'></iframe>
                        </td>
                      </tr>
                      <tr align="right"> 
                        <td colspan="2" height=47><input name="imageField" type="image" src="images/BtnClaimflowEnter.jpg"  border="0"></td>
                      </tr>
                    </table></td>
                  <td width="1" bgcolor="#999999"></td>
                </tr>
                <tr> 
                  <td colspan="3" valign="top"><img src="images/ImgLogon_2.gif" width="285" height="6" ></td>
                </tr>
              </table>
                        </td>
                        <td width="453" align="center" bgcolor="#FFFFFF">
                        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0" width="453" height="366">
                        <param name="movie" value="images/1.swf">
                        <param name="quality" value="high">
                        <embed src="images/1.swf" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="454" height="366"></embed>
						            </object>
                        </td>
                        <td width="1" rowspan="2" bgcolor="#3D72D7"></td>
                        </tr>
                    </table>
                    
                    <table width="780" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                    <td height="25" align="center" background="images/BgCopyright.gif"><img src="images/ImgCopyright.gif" ></td>
                    </tr>
                    </table> 
                </td>
                </tr>
                </table>
</form>
</body>
</html:html>
