<%--
****************************************************************************
* DESC       ����ʾʵ������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" cellpadding="5" cellspacing="1">
    <tr>
      <td class="common" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="RegistTextImg" onclick="showPage(this,RegistText)">���㱨��
        <br>
        <table class="common" align="center" id="RegistText" style="display:none">
          <tbody>
            <tr>
              <td class="input" style="text-align:center;" >
<textarea style="wrap:hard" rows="15" cols="80" name="prpLctextContextInnerHTML"><bean:write name="prpLctextDto" property="context"/></textarea>
                 <br>
                 <%
                     //����Ǵ�˫��ϵͳ������,������ʾ�������㱨�水ť. 2005-08-11
                     if (!"noDisplay".equals(request.getParameter("claimFlag"))) {
                 %>
                     <input type="button" class=bigbutton name="buttonGenerateCtext" value="�������㱨��" onclick="GenerateCtextFlag('0');generateCtext();">
                <%
                     }
                %>
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>