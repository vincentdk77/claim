<%--
****************************************************************************
* DESC       ����ʾ��������ҳ��(1: ����ժҪ��2: ����/ע��ԭ��3: �鿱����)��Ҫ������TextType
* AUTHOR     :qinyongli
* CREATEDATE ��2005-8-18
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
   <table class="common"  align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">�鿱����
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
