      <%-- �����ύͨ�ð�ť --%>
     
     <table id="buttonArea" cellpadding="0" cellspacing="10" width="80%" style="display:">
     <tr>
            <td class="button" style="width:80%" align="center">
            
           
                 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
           
            <%//modify by lixiang add 20050309 start
//reason:ȡ�ز��޸����Ƹĳ��ύ%>
                       <input type="button" name=buttonSave class='button' value="����"  onclick="saveForm(this);" >
<%//modify by lixiang add 20050309 end%>                 
                 </logic:equal>  
                 
                 <logic:notEqual name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
                     <!--�ύ�Ķ��������-->
                      <input type="button" name=buttonSave class='button' value="����"  onclick="saveForm(this);" >
                 </logic:notEqual>  
                  <input type="hidden" name=saveType value="<bean:write name='prpLscheduleMainWFDto' property='saveType' />" >
                </td>    
              
         <td class="button" style="width:50%" align="center">
            <!--ȡ����ť-->
            <input type="button" name=buttonCancel class='button' value="����" onclick="javascript:history.go(-2);" >
          </td>
      </tr>
    </table>
