<SCRIPT LANGUAGE="JavaScript">
    function showButton() {  //�˺��������ڼ���ʱ��ť����
       if (fm.buttonCloseReturn.value == "close") {
            fm.buttonClose.disabled = false;
       } else {
            fm.buttonReturn.disabled = false;
        }
    }

//modify by liuyanmei add start 20051028
  //reason��1.����Ա���Ƿ���Ȩ���������;
  //reason: 2.�����Ƿ��ϴε��黹û�н�����û�������������ٴ����
  //reason��3.���������¼��ҳ��      
 
  function appcheck() {  
   if(fm.cancheck.value=="1"){             //"0"��Ȩ���������,"1"��Ȩ�����루�к���Ȩ�ޣ�
     if (fm.checkNotOver.value == "1") {   //"1"�ϴε��黹û�н���;"0"û����������飬���ϴε��������
        alert("�ϴ�������黹û�д��������ٴ��������");
        return false;
      }
      else {
        applySchedule('<bean:write name='prpLclaimDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','03','<bean:write name='prpLclaimDto' property='claimNo'/>');
      } 
       
    }
    else {     //�޺���Ȩ��
       alert("ֻ���к���Ȩ�޵��˲ſ���������飡");
       return false;
     }
    }
    
//modify by liuyanmei add end 20051028    
    
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
       <logic:notEqual  name="prpLclaimDto" property="status" value="4">
 
         <!--
          <logic:equal  name="prpLclaimDto" property="status" value="1">
             <td class=button style="width:25%" align="center">
              ����������ť 2005-09-06
               <input type="button" name=buttonSave class='button' value="��������" 
                 onclick="return notGrandClaim(fm.registno.value,fm.riskcode.value, fm.swfLogFlowID.value,fm.swfLogLogNo.value);">
             </td>
          </logic:equal>
          -->
          <td class=button style="width:25%;display:none" align="center">
            <!--���水ť-->
           <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
          </td>

         <td class=button style="width:25%" align="center">
            <!--�ύ��ť-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="�ύ" onclick="return saveForm(this,'4');" >
         </td>

          <td class=button style="width:25%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
          
     <!--�������--modify by liuyanmei modify 20051214-->
        <!--   <td class=button style="width:25%" align="center">
            <input type=button name=buttonSchedule class='bigbutton' value="�������" onclick="appcheck();" >
          </td>
       -->   
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
      
      <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
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
            <input  name=buttonCancel class='button' value="����" onclick="history.back(0)" >
          </td> 
<%
  }
%>          
      </logic:equal>
      </tr>
    </table>
 