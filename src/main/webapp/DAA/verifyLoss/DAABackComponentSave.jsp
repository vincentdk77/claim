<%--
****************************************************************************
* DESC       ��ͨ�ð�ť����
* AUTHOR     : liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>      
      <%-- ����ͨ�ð�ť --%>        
        <table cellpadding="0" cellspacing="0" width="100%" style="display:"  id="buttonArea">
        <tr>
            <%-- ���������ı��水ť���ĸ��ı�־--%>
            <td colspan="5">
              <input  type="hidden" name=buttonSaveType value="1">
            </td>
          </tr>
          
        <tr>
          <logic:notEqual name="prpLverifyLossDto" property="status" value="4">
              <td class=button style="width:30%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�� ��" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button style="width:40%" align="center">
               <!--�ύ�Ķ��������-->
                 <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:30%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="�� ��" onclick="javascript:history.go(-2);" >
              </td>
            </logic:notEqual>
                  
         <logic:equal name="prpLverifyLossDto" property="status" value="4">
           <td class=button style="width:90%" align="center">
            <!--ȡ����ť-->
            <input type=button name=buttonCancel class='button' value="�� ��" onclick="javascript:history.go(-2);" >
          </td>
        </logic:equal>   
       
          <input type=hidden name=verifyOpinion  value=""  >
          <input type=hidden name=nextNodeNo  value="0"  >
        
              
      </tr>  
    </table>