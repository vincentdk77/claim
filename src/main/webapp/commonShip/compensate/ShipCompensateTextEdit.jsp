<%--
****************************************************************************
* DESC       ：显示实赔文字页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-05-19
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" align="center" >
    <tr>
      <td class="subformtitle" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">赔款计算过程
        <br>
        <table class="common" align="center" id="RegistText" style="display:none">
          <tbody>
            <tr>
              <td class="input" style="text-align:center;" colspan="0">
<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextInnerHTML"><bean:write name="prpLctextDto" property="context"/></textarea>                               
                 <br>
               <!-- <input type="button" name="buttonGenerateCtext" value="生成理算报告" class="bigbutton" onclick="GenerateCtextFlag('0');generateCtext();"><font color='red'>修改金额后注意重新生成理算批文!!!</font> -->
              </td>
            </tr>  
          </tbody>
        </table>
      </td>
    </tr>
  </table>
