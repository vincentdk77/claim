<%--
****************************************************************************
* DESC       ��¼��/��ʾ�¹ʾ��������¹�����״ 1�¹ʾ��������¹�����״ 2Ϊ��������
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-08
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  
   <table class="common" align="center" width="100%">
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"   
             name="RegistTextImg" onclick="showPage(this,RegistText)">
                ��������
        <br>
      <table class="common" align="center" id="RegistText" style="display:none">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" colspan="0">
                  <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML"><bean:write name="prpLacciCheckTextDto" property="context"/></textarea>              
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>
