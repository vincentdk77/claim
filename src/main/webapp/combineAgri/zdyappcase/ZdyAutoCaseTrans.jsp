<%@ page import="com.sinosoft.claim.zdyApp.*"%>
<% 
   System.err.println("+++++++++++");
   ZdyAutoCaseTrans zact = new ZdyAutoCaseTrans();
   String  message= zact.autoCaseTransInfo();
   System.err.println("===========");
%>
<html>
 <body>
  <table class="common" align="center" width="100%" border="0" cellspacing="1" cellpadding="1">
   <tr class="common" height="50px">
    <td>·µ»ØÐÅÏ¢:</td>
   </tr>
   <tr class="common" height="50px">
    <td><%=message %></td>
   </tr>
  </table>
 </body>
</html>