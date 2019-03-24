<%--
****************************************************************************
* DESC       ：显示结案文字页面
* AUTHOR     : liubvo
* CREATEDATE ：2004-06-28
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------ 
****************************************************************************
--%>  
<table class="common" cellpadding="5" cellspacing="1">
  <tr> 
    <td class="common" style="text-align:left;">
      <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="EndcaseTextImg" onclick="showPage(this,EndcaseText)">结案报告：
      <br>
      <table class="common" cellpadding="5" cellspacing="1" id="EndcaseText" style="display:none">
        <tbody>
          <tr>
            <td class="input" style="text-align:center;" colspan="0">
<textarea style="wrap:hard" rows="15" cols="80" name="prpLltextContextInnerHTML"><bean:write name="prpLltextDto" property="context"/></textarea>                               
            </td>
          </tr>
        </tbody>  
      </table>
    </td>
  </tr>
</table>
