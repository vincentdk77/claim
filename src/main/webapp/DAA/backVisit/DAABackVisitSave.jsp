    <%-- ����ͨ�ð�ť --%>
    <table  id="buttonArea" cellpadding="0" cellspacing="0" class=common style="display:">
     
      <tr>
      <%-- �����򱣴��ֵΪ�ͻ������ť�ı�־λ--%>
        <td>
          <input  type="hidden" name=buttonSaveType value="1">
        </td>
      </tr>
      <tr>
       <logic:notEqual  name="prpLbackVisitDto" property="status" value="4">
          <td class=button style="width:33%" >
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
          </td>
          
         <td class=button style="width:34%" >
            <!--�ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>
          
          <td class=button style="width:33%" >
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:notEqual>
                
      <logic:equal name="prpLbackVisitDto" property="status" value="3">
         <td class=button style="width:25%" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'3');">
         </td>
         
         <td class=button style="width:25%" align="center">
                <!--���˰�ť-->
                <input type="button" name=buttonSave class='button' value="����" onclick="return saveForm(this,'2');">
              </td>    
              
         <td class=button style="width:25%" align="center">
            <!--�ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>
          <td class=button style="width:25%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:equal>
                        
      <logic:equal name="prpLbackVisitDto" property="status" value="4">
          <td class=button  align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
          </td>
      </logic:equal>
      </tr>
    </table>
 