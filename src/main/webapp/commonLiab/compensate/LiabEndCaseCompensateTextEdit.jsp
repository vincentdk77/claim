<%--
****************************************************************************
* DESC       ：显示实赔文字页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

  <table  class="common" cellpadding="5" cellspacing="1" id="Lltext" style="display:none">
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="LlTextImg" onclick="showPage(this,LlText2)"><input class=readonly readonly name="tdLltextTitle" value="理算报告">
             <textarea  name='backLltextContent' style="display:none" ></textarea>
        <br>
        <table  class="common" align="center" id="LlText2" style="display:none">
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

<script language="javascript">
changePrpLcompensateFinallyFlag();
</script>