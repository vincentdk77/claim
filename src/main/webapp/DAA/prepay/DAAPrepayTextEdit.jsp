<%--
****************************************************************************
* DESC       ����ʾԤ������ҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-05-12
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" cellpadding="5" cellspacing="1">
     <tr>
       <td class="common" style="text-align:left;">
         <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="RegistTextImg" onclick="showPage(this,RegistText)">
          <% if("7".equals(caseType)){ %>Ԥ֧�����ȷѱ��棺 
      <% }else if ("8".equals(caseType)){ %>�渶���ȷѱ��棺
      <% }else {%>
       Ԥ�ⱨ�棺 
      <% }%>
        <br>
      <table class="common" cellpadding="5" cellspacing="1" id="RegistText" style="display:none">
        <tbody>
          <tr>
            <td class="input" style="text-align:center;" colspan="0">
                 <textarea style="wrap:hard" rows="15" cols="80" name="prpLptextContextInnerHTML"><bean:write name="prpLptextDto" property="context"/></textarea>              
            </td>
          </tr>
        </tbody>
      </table>
      </td>
    </tr>
  </table>
