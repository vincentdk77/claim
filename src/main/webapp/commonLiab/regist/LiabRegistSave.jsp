<table id="buttonArea" cellpadding="0" cellspacing="0" width="90%" style="display:">
            <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
            <%-- (1)�����Ǽ� " ����" "ȡ��" "�����","����ɲ��ύ"
                 (2)���ڴ���
                 (3)���˵�
                 (4)���ύ   "����"
                 (5)����     "����"
            --%>
            <tr> 
            <%-- ���������ı��水ť���ĸ��ı�־--%>
            <td>
              <input type="hidden" name=buttonSaveType value="1">
            </td>
            </tr>
            
            <tr>
              <logic:notEqual name="prpLregistDto" property="status" value="4">
              <td class=button style="width:40%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button style="width:20%" align="center"> 
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
			<!-- �ж��Ƿ���ֱ�ӵ��ȵ�Ȩ�� -->
		    	<% String  checkPower =(String)request.getAttribute("checkPower");
				  if ("true".equals(checkPower)){%>
             <td id="scheduleRefTd" class=button style="width:20%" align="center">
          <input type="hidden" name="scheduleRef" id="scheduleRef" value="">
          <input type="button"  class='button' value="����" onclick="return saveFormNew(this,'4','scheduleRef');">
        </td>
		 		<%} %>
              <td class=button style="width:40%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
                
                         
           <logic:equal name="prpLregistDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--���ذ�ť-->
              <!--modify by luqin 2005-04-03 start
                reason �ӷ���ͼ��-->
            
              <input type=button name=buttonBack class='button' value="����" onclick="return history.back(-1);" >
              <!--modify by luqin 2005-04-03 finish-->
            </td>
          </logic:equal>          
        </tr>
      </table>