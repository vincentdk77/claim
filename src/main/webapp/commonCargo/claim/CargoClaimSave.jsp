      <%-- ����ͨ�ð�ť --%>
          <table  id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
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
      <logic:equal name="prpLclaimDto" property="status" value="1">
          <td class=button style="width:25%;display:none" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value' />" onclick="return saveForm(this,'2');">
          </td>          
          
          <td class=button style="display:none" align="center">
            <!--����ɰ�ť-->
            <input type="button" name=buttonSaveFinish class='button' value="�����"  onclick="return saveForm(this,'3');" >
          </td>
         
         <td class=button style="width:25%" align="center">
            <!--����ɲ��ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>
         
         <td class=button style="width:25%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
        </logic:equal>
            
        <logic:equal name="prpLclaimDto" property="status" value="2">
          <td class=button style="width:33%;display:none" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value' />" onclick="return saveForm(this,'2');">
          </td>
          
          <td class=button style="display:none" align="center">
            <!--����ɰ�ť-->
            <input type="button" name=buttonSaveFinish class='button' value="�����"  onclick="return saveForm(this,'3');" >
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
                
      <logic:equal name="prpLclaimDto" property="status" value="3">
         <td class=button style="width:33%;display:none" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value' />" onclick="return saveForm(this,'3');">
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
      
      <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatusΪ0��"+statusgiv);
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskClaimGiveup();" >
             </td>
             <%
             }
              %>              
           <!--��������-->

                        
      <logic:equal name="prpLclaimDto" property="status" value="4">
          <td class=button style="width:33%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
          </td>
      </logic:equal>
      </tr>
    </table>
 