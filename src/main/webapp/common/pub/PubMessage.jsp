<%--
****************************************************************************
* DESC       ：操作成功提示页面
* AUTHOR     ：lirui
* CREATEDATE ：2004-7-22
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>

<head>
</head>
<body >
  <form name="fm" action="" method="post">
    <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center">
          <table class="common" cellpadding="5" cellspacing="1" align="center">
            <tr class=common> 
              <td height=100px align="center" class=common>
                <img src='/claim/images/success.gif' align="absmiddle">
                  <label id="labtxt"></label>
                  <% String content = (String)request.getAttribute("content");
                  if (content == null || content.equals(""))
                  {
                      out.print("操作成功！");
                  }
                  else
                  { 
                      out.print(content);
                  }%>
              </td>
            </tr>
           </table>
         </td>
       </tr>
     </table>
   </form>

</body>
