<SCRIPT LANGUAGE="JavaScript">
    function showButton() {  //�˺��������ڼ���ʱ��ť����
       if (fm.buttonCloseReturn.value == "close") {
            fm.buttonClose.disabled = false;
       } else {
            fm.buttonReturn.disabled = false;
        }
    }
</script>

<%-- ����ͨ�ð�ť --%>
          <table  id="buttonArea" class=common style="display:">
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
  <%    String dfFlag=request.getParameter("dfFlag");
        if("Y".equals(dfFlag) ){
        %>  
         <td class=button style="width:33%" align="center">
              <!--ȡ����ť-->
              <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
            </td>
           <% }else { %>
       <logic:notEqual  name="prpLclaimDto" property="status" value="4">
          <td class=button style="width:25%;display:none" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
          </td>

         <td class=button style="width:33%" align="center">
            <!--�ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>
         
         <td class=button style="width:33%" align="center">
            <!--ע����ť-->
            <input type="button" name=buttonOffSubmit class='button' value="ע��" onclick="return offForm(this);" >
         </td>

          <td style="display:none" class=button style="width:33%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:notEqual>

      <logic:equal name="prpLclaimDto" property="status" value="3">
       
         <td class=button style="width:33%;display:none" align="center">
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
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonClose class='button' value="�� ��" onclick="window.close();">
            <input  type="hidden" name=buttonCloseReturn value="close">
            </td>
<%
  }else{
%>      
          <td class=button style="width:33%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonReturn class='button' value="����" onclick="history.go(-1);" >
            <input  type="hidden" name=buttonCloseReturn value="return">
          </td>
<%
  }
%>          
      </logic:equal>
           <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatusΪ0��"+statusgiv);
                  if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
             </td>
             <%
             }
             %>              
           <!--��������-->

      <logic:equal name="prpLclaimDto" property="classCode" value="27">
          <td class=button style="width:33%" align="center">
            <!--�������-->
            <input type=button name=buttonSchedule class='bigbutton' value="�������" onclick="applySchedule('<bean:write name='prpLclaimDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','03','<bean:write name='prpLclaimDto' property='claimNo'/>');" >
          </td>
      </logic:equal>
    <%}%>  
      </tr>
    </table>
