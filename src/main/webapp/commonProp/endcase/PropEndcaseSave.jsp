<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
      <table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" class="common" id='tablebutton'>
      
            <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
            <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
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
              <td class=button style="width:50%" align="center">
                <!--���水ť-->
                <input type="button" name=buttonSave class='button' value="�� ��" onclick="return saveForm(this,'4');">
              </td>            
         
              <td class=button style="width:50%" align="center">
                <!--ȡ��-->
                <input type=button name=buttonBack class='button' value="<bean:message key='button.cancel.value'/>" onclick="history.back()" >
              </td>
        </tr>
      </table>