<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     ��sunchenggang
* CREATEDATE ��2006-03-07
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*            
****************************************************************************
--%>      
      <%-- ����ͨ�ð�ť --%>        
        <table cellpadding="5" cellspacing="1" class=common style="display:"  id="buttonArea">
          <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
          <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
               (2)������   "����" "ȡ��","�����","����ɲ��ύ","����"
               (3)�����   "����" "ȡ��" "�ύ"
               (4)���ύ   "����"
               (5)����     "����"                  
          --%>
          <tr>
            <%-- ���������ı��水ť���ĸ��ı�־--%>
            <td colspan="5">
              <input  type="hidden" name=buttonSaveType value="1">
            </td>
          </tr>
          
        <tr>
          <%String dfFlag=request.getParameter("dfFlag");
      
        if("Y".equals(dfFlag) ){
        %>  
         <td class=button style="width:33%" align="center">
              <!--ȡ����ť-->
              <input type=button name=buttonBack class='button' value="����" onclick="return history.back();" >
            </td>
           <% }else {%>  
          <logic:notEqual name="prpLverifyLossDto" property="status" value="4">
              <td class=button style="width:20%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button style="width:20%" align="center">
           
               <!--�ύ�Ķ��������
               
                <html:select name="swfPathDto" property="nextNodeNo" style="width:80px">
                    <html:options collection="pathList" property="endNodeNo" labelProperty="endNodeName"/>          
                </html:select> 
                -->            
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>             
              <td class=button style="width:20%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
                  
         <logic:equal name="prpLverifyLossDto" property="status" value="4">
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
           <td class=button style="width:20%" align="center">
            <!--ȡ����ť-->
            <input id="buttonreturn" type=button name="buttonCancel" class='button' value="�� ��" onclick="javascript:history.go(-1);" >
          </td>
<%
  }
%>          
        </logic:equal>

<%
  //����˼�ʱ����ʾ�˻ذ�ť
  //if(!nodeType.equals("verpo")){
%>        
       <td class=button style="width:20%" align="center">
        <!--�˻ذ�ť-->
        <input type=button name=buttonReject  class='button' value="�� ��" onclick="return saveForm(this,'5');" >
      </td>  
<%
  //}
%>                

<!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatusΪ0��"+statusgiv);
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:30%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
             </td>
             <%
             }
           }   %>              
           <!--��������-->
      </tr>  
    </table>