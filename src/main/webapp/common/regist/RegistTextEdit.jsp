<%--
****************************************************************************
* DESC       ：显示报案文字页面()，要传参数TextType
* AUTHOR     ：qinyongli
* CREATEDATE ：2005-08-15
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
   <table class="common" >
    <tr class=mline>
      <td class="subformtitle"  style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">出险摘要
        <br>
        <table class="common" align="center" id="RegistText" style="display:none" cellspacing="1" cellpadding="5">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" >
              <textarea style="width:700px" rows="15" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLregistTextDto" property="context"/></textarea>              
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
