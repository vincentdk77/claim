<%--
****************************************************************************
* DESC       ��¼��/��ʾ�ʱ���Ϣ 4Ϊ�ʱ���Ϣ
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-08
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

   <table class="common" align="center" width="100%" id="ReportFlag" style="display:none">
    <tr class=mline>
      <td class="subformtitle" style="text-align:left;">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="RegistTextImg" onclick="showPage(this,RegistText2)">
           �ʱ���Ϣ
        <br>
      <table class="common" align="center" id="RegistText2" style="display:none">
          <tbody>
            <tr>
              <td class="title" style="text-align:center;" colspan="0">
                  <textarea style="wrap:hard" rows="15" cols="80" name="prpLregistTextContextInnerHTML2"><bean:write name="prpLregistText4Dto" property="context"/></textarea>
              </td>
            </tr>
          </tbody>
        </table>
      </td>
    </tr>
  </table>

<script language="javascript">
  //�����Ƿ�ʱ���radio��ť����ʾ�����سʱ���Ϣ��
  if (fm.prplregistReportFlag[0].checked) {
      ReportFlag.style.display = "";
  } else {
      ReportFlag.style.display = "none";
  }
</script>