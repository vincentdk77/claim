<%-- ����ͨ�ð�ť --%>
 </br> 
<table cellpadding="0" cellspacing="0" width="80%" class="common">

  <tr>
    <%-- ֻ��ʾ���ذ�ť--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1"> 
    </td>
  </tr> 
 
  <tr>  
   
<%  
     if (!editType.equals("SHOW"))
  {
%>
   <td class=button  align="center">
      <input type=button name=buttonSave class='button' value="����" onclick="javascript:saveForm();" >
   </td>    
 <%
  }
%>    
    <td class=button  align="center">
     <!--ȡ����ť-->
       <input type=button name=buttonCancel class='button' value="����" onclick="javascript:history.go(-1);" >
     </td> 
 </tr>
</table>  
