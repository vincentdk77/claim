      <%-- ����ͨ�ð�ť --%>
          <table  id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
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
       <logic:notEqual  name="prpLclaimDto" property="status" value="4">
          <td class=button style="width:25%" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
          </td>
          
         <td class=button style="width:33%" align="center">
            <!--�ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>
          
          <td class=button style="width:33%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:notEqual>
                
      <logic:equal name="prpLclaimDto" property="status" value="3">
         <td class=button style="width:33%" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'3');">
         </td>
         
         <td class=button style="width:33%" align="center">
                <!--���˰�ť-->
                <input type="button" name=buttonSave class='button' value="����" onclick="return saveForm(this,'2');">
              </td>    
              
         <td class=button style="width:33%" align="center">
            <!--�ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>
          <td class=button style="width:33%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:equal>
                        
      <logic:equal name="prpLclaimDto" property="status" value="4">
          <td class=button style="width:33%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
          </td>
      </logic:equal>
      </tr>
    </table>
 