<%--
****************************************************************************
* DESC       ：显示报案文字页面(1: 出险摘要；2: 拒赔/注销原因；3: 查勘报告)，要传参数TextType
* AUTHOR     :qinyongli
* CREATEDATE ：2005-8-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
   <table class="common"  align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">查勘报告
        <br>
      <table class="common" align="center" id="RegistText" style="display:none" cellspacing="1" cellpadding="5">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" >
              <%--
              <%if(editType.equals("ADD")){%>
              <textarea style="wrap:hard" rows="18" cols="80" name="prpLregistTextContextInnerHTML">

              </textarea> 
              <%}else{%>
              <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLregistTextDto" property="context"/></textarea> 
              <%}%>
              --%>
              <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLregistTextDto" property="context"/></textarea>              
              
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
