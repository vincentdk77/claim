<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%  
  String editTypeTemp=request.getParameter("editType");
  if (editTypeTemp.equals("SHOW")||editTypeTemp.equals("DELETE"))
  {
%>

<%-- ����ͨ�ð�ť --%>
<table cellpadding="0" cellspacing="0" class="common">

  <tr>
    <%-- ���������ı��水ť���ĸ��ı�־--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1">
    </td>
  </tr>  
  <tr>  
     <td class=button style="width:33%" align="center">
     <!--ȡ����ť-->
       <input type=button name=buttonCancel class='button' value="�� ��" onclick="javascript:history.go(-2);" >
     </td> 
 </tr>
</table>  
<table cellpadding="0" cellspacing="0" class=common id="buttonArea">

</table>  
<%
  }else{
%>
<%-- ����ͨ�ð�ť --%>
<table id="buttonArea" cellpadding="5" cellspacing="1" class="common" id="tablebutton">
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
    <logic:notEqual name="prpLprepayDto" property="status" value="4">
    <td class=button style="width:20%" align="center">
      <!--���水ť-->
       <input type="button" name=buttonSave class='button' value="�� ��" onclick="return saveForm(this,'2');">
    </td>
    
    <td class=button style="width:20%" align="center">
    
    <%/*
     <!--�ύ�Ķ��������-->
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
    <td class=button style="width:20%" align="center">
      <!--ȡ����ť-->
      <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
    </td>
  </logic:notEqual>
              
   <logic:equal name="prpLprepayDto" property="status" value="4">
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
       <input type=button name=buttonCancel class='button' value="�� ��" onclick="return resetForm();" >
     </td>
<%
  }
%>     

            
   
   </logic:equal>      
  <logic:equal value="0" parameter="status">
  	 <td class=button  align="center">
        <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
        </td>
  </logic:equal> 
 </tr>
</table>  

<%
  }
%>