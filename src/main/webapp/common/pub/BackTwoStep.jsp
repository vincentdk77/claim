<%--
 *************************************************************************
 * 程序名称: BackOneStep.jsp
 * 程序功能: 回退界面
 * 最近更新人: weishixin
 * 最近更新日期: 2004-08-23
 ****************************************************************************
--%>


<html>
    <head>
        <title>
        </title>
        <STYLE>BODY {
        	BORDER-TOP-WIDTH: 0px; 
        	BORDER-LEFT-WIDTH: 0px; FONT-SIZE: 9pt; 	BORDER-BOTTOM-WIDTH: 0px; 
        	LINE-HEIGHT: 160%; 
        	FONT-FAMILY: "宋体"; 
        	BORDER-RIGHT-WIDTH: 0px;
            SCROLLBAR-FACE-COLOR:#EFFAFF;
            SCROLLBAR-HIGHLIGHT-COLOR:#4D9AC4;
            SCROLLBAR-SHADOW-COLOR:#4D9AC4;
            SCROLLBAR-3DLIGHT-COLOR:#EFFAFF;
            SCROLLBAR-ARROW-COLOR:#EFFAFF;
            SCROLLBAR-TRACK-COLOR:#EFFAFF;
            SCROLLBAR-DARKSHADOW-COLOR:#EFFAFF;
        }
        </STYLE>
        <link href="/claim/css/Standard.css" rel="stylesheet" type="text/css">
        <script language="javascript">
        function windowBackOne()
        {
           alert("回退两步");
           window.history.go(-2);
        }
        </script>
    </head>
    <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="return windowBackOne();">
        <table width="472" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td width="343" rowspan="2">&nbsp;</td>
            <td width="129" height="21"></td>
          </tr>
          <tr>
            <td height="13" bgcolor="#FFFFFF"></td>
          </tr>
          <tr align="center"> 
            <td colspan="2">
            
              <table border="0" width="70%" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="60%" height="30" valign="bottom"> 
                   
                    <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
                      <tr> 
                        <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
                        <td width="161" bgcolor="#2D8EE1">界面回退</td>
                        <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
                      </tr>
                    </table>
                    
                  </td>
                </tr>
              </table>
               

          </tr>
        </table>
        
    </body>
</html>
