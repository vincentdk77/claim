<%--
****************************************************************************
* DESC       ：显示付款说明页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

  <table class="common" align="center">
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="PayTextImg" onclick="showPage(this,PayText)">付款说明
        <br>
        <table class="common" align="center" id="PayText" style="display:none">
          <tbody>
            <tr>
              <td class="input" style="text-align:center;" colspan="0">
								<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextPayTextInnerHTML"><bean:write name="prpLctextPayTextDto" property="context"/></textarea>
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>