<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
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
              
              <td class=button style="width:70%" align="center">
           
               <!--�ύ�Ķ��������-->
               
                <html:select name="swfPathDto" property="nextNodeNo" style="width:80px">
                    <html:options collection="pathList" property="endNodeNo" labelProperty="endNodeName"/>          
                </html:select> 
               
                <!--<input type="text" name=nextHandlerCode class='common' style="width:90px" maxlength="10" value="" >
                <input type="text" name=nextHandlerName class='common' style="width:50px" readonly value="" >
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >-->
           <!--     
                <input type=text name="nextHandlerCode" class="codecode"  style="width:100px" maxlength="10" title="����Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onchange="code_CodeChange(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
        <input type=text name="nextHandlerName" class="codecode" style="width:80px" title="����Ա" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
             onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');">
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
            <input type=button name=buttonCancel class='button' value="�� ��" onclick="javascript:history.go(-1);" >
          </td>
<%
  }
%>          
        </logic:equal>   
       <td class=button style="width:20%" align="center">
        <!--ȡ����ť-->
        <input type=button name=buttonReject  class='button' value="�� ��" onclick="return saveForm(this,'5');" >
      </td>    
      
      <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
             </td>
             <%
             }
           }   %>              
           <!--��������-->    
      </tr>  
    </table>