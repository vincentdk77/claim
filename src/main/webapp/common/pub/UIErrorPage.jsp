<%--
****************************************************************************
* DESC       ��������ҳ
* AUTHOR     ���й������Ŀ��
* CREATEDATE ��2002-08-26
* MODIFYLIST ��   Name       Date            Reason/Contents
*                qinyongli  2005-8-27         ����Attribute��ʽ
****************************************************************************
--%>

<%
  String strContent = request.getParameter("Content"); 
  if(strContent==null||strContent.equals("")){
       strContent = (String)request.getAttribute("Content"); 
       if(strContent==null || strContent.equals("")){
           strContent = "������";
       }
  }
%>

<html>
<head>
  <title>��Ϣ����</title>
  <%--ҳ����ʽ--%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">


</head>
<body class="interface" >
   <table cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" align="center">
     <tr>
       <td class=formtitle colspan="2">ϵͳ����:</td>
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