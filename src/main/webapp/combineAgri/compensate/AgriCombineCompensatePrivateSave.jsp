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
              <td class=button style="width:50%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�� ��" onclick="return saveForm(this,'2');">
              </td>
              <td class=button style="width:50%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="ȡ��" onclick="return resetForm();" >
              </td>
            </logic:notEqual>           
  </tr> 
</table>
<%
  }
%>