<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<SCRIPT LANGUAGE="JavaScript">

//modify by liuyanmei delete start 20051214 reason:ȥ��������鰴ť�����е������뼯����һ���˵�����
/*
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
       applySchedule('<bean:write name='prpLcompensateDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','05','<bean:write name='prpLcompensateDto' property='compensateNo'/>');
      } 
       
    }
    else {     //�޺���Ȩ��
       alert("ֻ���к���Ȩ�޵��˲ſ���������飡");
       return false;
     }
    }
    
//modify by liuyanmei add end 20051028    
*/
//modify by liuyanmei delete start 20051214 reason:ȥ��������鰴ť�����е������뼯����һ���˵�����    
</script>

<%
  

  String editTypeTemp=request.getParameter("editType");
  if (editTypeTemp.equals("SHOW")||editTypeTemp.equals("DELETE"))
  {
%>

<%-- ����ͨ�ð�ť --%>
<table cellpadding="0" cellspacing="0" width="80%" class="common">

  <tr>
    <%-- ���������ı��水ť���ĸ��ı�־--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1">
    </td>
  </tr>
  <tr>
     <td class=button style="width:33%" align="center">
     <!--ȡ����ť-->
       <input type=button name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >
     </td>
     <td class="button" type="button" align="center" >
       <Input name="buttonTrace" class="button" type="button"  alt="������" value="������" tabindex="-1" onclick="viewHePeiTrace('<bean:write name='prpLcompensateDto' property='compensateNo' />');">
     </td>
 </tr>
</table>
<table cellpadding="0" cellspacing="0" width="0"  height="0"id="buttonArea">

</table>
<%
  }else{
%>
  <%-- ����ͨ�ð�ť --%>

    <table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
      <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
           (2)������   "����" "ȡ��","�����","����ɲ��ύ","����"
           (4)���ύ   "����"
           (5)����     "����"
           ��Ϊ���Զ��ģ�������ע�͵���Ӧ����Ա�ύ
      --%>
      <tr>
      <%-- ���������ı��水ť���ĸ��ı�־--%>
      <td>
        <input  type="hidden" name=buttonSaveType value="1">
      </td>
      </tr>
      <tr>
                  <logic:notEqual name="prpLcompensateDto" property="status" value="4">
              <td class=button style="width:25%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
              </td>
              <td class=button style="width:25%" align="center">
               <!--�ύ�Ķ��������-->
             <%/*

               <select name="nextNodeNo" style="width:80px">
                    <option value="1">����</option>
                    <option value="2">	����</option>
                    <option value="3">	�鿱</option>
                    <option value="4">	����</option>
                    <option value="5">	����</option>
                    <option value="10">	��֤</option>
                    <option value="11">	Ԥ��</option>
                    <option value="12">	ʵ��</option>
                    <option value="13">	�᰸</option>
                    <option value="14">����	</option>
                  </select>
                <input type="text" name=nextHandlerCode class='common' style="width:90px" maxlength="10" value="" >
                <input type="text" name=nextHandlerName class='common' style="width:50px" readonly value="" >
             */%>
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:25%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
              <td class="button" type="button" align="center" >
                <Input name="buttonTrace" class="button" type="button"  alt="������" value="������" tabindex="-1" onclick="viewHePeiTrace('<bean:write name='prpLcompensateDto' property='compensateNo' />');">
              </td>
            </logic:notEqual>
             <%String statusgiv= request.getParameter("status");
             if(statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
             </td>
             <%
             }
              %>       
  <!--�������--modify by liuyanmei modify 20051214 start-->
  <!--  <td class=button style="width:25%" align="center">
       <input type=button name=buttonSchedule class='button' value="�������" onclick="appcheck();" >
     </td>  -->
<!--�������--modify by liuyanmei modify 20051214 end-->
     <logic:equal name="prpLcompensateDto" property="status" value="4">
       <td class=button style="width:33%" align="center">
        <!--ȡ����ť-->
        <input type=button name=buttonBack class='button' value="����" onclick="return history.back(-1);" >
      </td>
    </logic:equal>
  </tr>
</table>
<%
  }
%>