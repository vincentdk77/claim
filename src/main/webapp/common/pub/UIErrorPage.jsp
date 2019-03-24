<%--
****************************************************************************
* DESC       ：错误处理页
* AUTHOR     ：中国大地项目组
* CREATEDATE ：2002-08-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*                qinyongli  2005-8-27         增加Attribute方式
****************************************************************************
--%>

<%
  String strContent = request.getParameter("Content"); 
  if(strContent==null||strContent.equals("")){
       strContent = (String)request.getAttribute("Content"); 
       if(strContent==null || strContent.equals("")){
           strContent = "出错了";
       }
  }
%>

<html>
<head>
  <title>信息反馈</title>
  <%--页面样式--%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">


</head>
<body class="interface" >
   <table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center">
     <tr>
       <td class=formtitle colspan="2">系统错误:</td>
     </tr>
    <tr>
      <td  class="common">
        <img src='/claim/images/bgClaimFailure.gif'>
      </td>
      <td class="common">
       	
         <span id="false"><%=strContent%></span><br>
         
       	
      </td>
    </tr>
  </table>
</body>
</html>