<%-- ����ͨ�ð�ť --%>        
         <table id="buttonArea" cellpadding="5" cellspacing="1" class=common style="display:" >
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
              <%--������������  <logic:notEqual name="prpLcheckDto" property="status" value="4">--%>
              <td class=button align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
                 
              </td>
              
              <td class=button align="center">
               <!--�ύ�Ķ��������-->
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
         <%--������������   </logic:notEqual>--%>
            
			<td class=button align="center">
        	 <input type="button" name=giveup class='button' value="��������"  onclick="giveupCombineTemporarySave('check');">
       		 </td>	             
           <!--��������-->
                
                     
         <%--����������ʱ����   <logic:equal name="prpLcheckDto" property="status" value="4">--%>
             <td class=button  align="center">
              <!--ȡ����ť-->
              <input type=button name=back class='button' value="����" onclick="return history.back();" >
            </td>
         <%--����������ʱ����  </logic:equal>     --%>
        </tr>
      </table>