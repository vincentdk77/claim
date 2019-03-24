<%--
****************************************************************************
* DESC       ：显示实赔文字页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<!--
  <table class="common" align="center" width="100%" id="Lltext" style="display:none">
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="LlTextImg" onclick="showPage(this,LlText2)">定损说明
        <br>
        <table class="common" align="center" id="LlText2" style="display:none">
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
  -->
  
   <table class="common" align="center" width="100%">
    <tr>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,CaluteText)">赔款计算过程
        <br>
        <table class="common" align="center" id="CaluteText" style="display:none">
          <tbody>
            <tr>
              <td class="input" style="text-align:center;" colspan="0">
<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextInnerHTML1"><bean:write name="prpLctextDto1" property="context"/></textarea>                               
				<br>
                <input type="hidden" name="buttonGenerateCalutetext" class="bigbutton" value="生成赔款计算书" onclick="GenerateCtextFlag('0');generateCompensateText();"><font color='red'>修改金额后注意重新生成赔款计算过程!!!</font>
              </td>
            </tr>  
          </tbody>
        </table>
      </td>
    </tr>
  </table>

