 <table cellpadding="0" cellspacing="0" class="common">
      
            <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
            <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
                 (2)������   "����" "ȡ��","�����","����ɲ��ύ","����"
                 (4)���ύ   "����"
                 (5)����     "����"
            --%> 
            <tr>
            <%-- ���������ı��水ť���ĸ��ı�־--%>
              <td>  
                <input  type="hidden" name=buttonSaveType value="1">
                <input type="hidden" name="nodeType" value="certi"> 
              </td> 
            </tr>  
            <tr>
            
           <logic:notEqual name="prpLcertifyCollectDto" property="status" value="4">
         <%--  <td class=button style="width:40%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
              </td>--%>
         <td class=button style="width:40%" align="center">
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" > 
              </td>
              <td class=button style="width:20%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
           </logic:notEqual>
           
           <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatusΪ0��"+statusgiv);
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskCertifyGiveupCombine();" >
             </td>
             <%
             }
              %>              
           <!--��������-->
                
           <logic:equal name="prpLcertifyCollectDto" property="status" value="4">
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="�� ��" onclick="window.close();">
            </td>
<%
  }else{
%>           
             <td class=button style="width:33%" align="center">
              <!--ȡ����ť-->
      <%--        <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >--%>
            <input type=button name=buttonBack class='button' value="�� ��" onclick="history.back(-1);" >
            </td>
<%
  }
%>            
          </logic:equal>          
        </tr>
      </table>
     