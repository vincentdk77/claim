<%@ page import="com.sinosoft.claimzy.ui.control.*"%>
<% 
   System.err.println("+++++++++++");
   UIAGRIZYClaimUploadFacade ucuf = new UIAGRIZYClaimUploadFacade();
   String message = ucuf.orderTimeTask();
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

