<%--
****************************************************************************
* DESC       ����ʾԤ������ҳ��
* AUTHOR     : liubvo
* CREATEDATE ��2004-05-12
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" align="center" width="100%" >
     <tr>
       <td class="subformtitle" style="text-align:left;">
         <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="RegistTextImg" onclick="showPage(this,RegistText)">Ԥ�ⱨ�棺
        <br>
      <table class="common" align="center" id="RegistText" style="display:none">
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
