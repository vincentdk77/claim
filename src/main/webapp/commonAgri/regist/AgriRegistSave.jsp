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
              <html:select name="swfPathDto" property="nextNodeNoList" style="width:0px;height:0px" multiple="true" >
            <html:options collection="userSelectList" property="endNodeNo"  labelProperty="endNodeName" />          
       </html:select>
            </td>
            </tr>
            
            <tr>
              <logic:notEqual name="prpLregistDto" property="status" value="4">
              <logic:present name="prpLclaimStatusDto">
                <logic:notEqual name="prpLclaimStatusDto" property="status" value="4">
		              <td class=button style="width:40%" align="center">
		                <!--���水ť-->
		                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
		              </td>
		            </logic:notEqual>
		          </logic:present>
		          <logic:notPresent name="prpLclaimStatusDto">
		            <td class=button style="width:40%" align="center">
                  <!--���水ť-->
                   <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
                </td>
		          </logic:notPresent>
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
            <a href="javascript:history.go(-1);" style="font-size:12pt">����</a>
            
            </td>
          </logic:equal>          
        </tr>
      </table>

   