<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- ����ͨ�ð�ť --%>              
<table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:" id="tablebutton">
  <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
  <%-- (1)�����Ǽ� " ����" " ȡ��" "�����","����ɲ��ύ"
  (2)������   "����" "ȡ��","�����","����ɲ��ύ","����"
  (3)�����   "����" "ȡ��" "�ύ"
  (4)���ύ   "����"
  (5)����     "����"                  
  --%> 
  <tr>
  <%-- ���������ı��水ť���ĸ��ı�־--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1">
    </td>
  </tr> 
  <tr>
    <input type="hidden" name="prpLverifyLossDtoStatus" value="<bean:write name='prpLverifyLossDto' property='status'/>">    
        <logic:notEqual name="prpLverifyLossDto" property="status" value="4">
              <td class=button style="width:20%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button style="width:70%" align="center">
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:20%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
                
    <logic:equal name="prpLverifyLossDto" property="status" value="4">
      <td class=button style="width:33%" align="center">
        <!--ȡ����ť-->
        <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
      </td>
    </logic:equal>          
  </tr>
</table>  