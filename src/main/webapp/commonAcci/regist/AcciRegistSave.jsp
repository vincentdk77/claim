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
                 <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
              </td>

              <td class=button style="width:20%" align="center">
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:40%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>

<%
    if(!editType.equals("ADD")){
%>
          <!--modify by liuyanmei 20051214 reason: ȥ��������鰴ť�����е�����������һ���ڵ� 
            <td class=button style="width:33%" align="center">
               <!--�������-->
          <!--     <input type=button name=buttonSchedule class='button' value="�������" onclick="applySchedule('<bean:write name='prpLregistDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','01','<bean:write name='prpLregistDto' property='registNo'/>');" >
             </td> 
             -->
<%
    }
%>


           <logic:equal name="prpLregistDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--���ذ�ť-->
            <a href="javascript:history.go(-1);" style="font-size:12pt">����</a>

            </td>
          </logic:equal>
        </tr>
      </table>