      <%-- 调度提交通用按钮 --%>
     
     <table id="buttonArea" cellpadding="0" cellspacing="10" width="80%" style="display:">
     <tr>
            <td class="button" style="width:80%" align="center">
            
           
                 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
           
            <%//modify by lixiang add 20050309 start
//reason:取回并修改名称改成提交%>
                       <input type="button" name=buttonSave class='button' value="改派"  onclick="saveForm(this);" >
<%//modify by lixiang add 20050309 end%>                 
                 </logic:equal>  
                 
                 <logic:notEqual name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
                     <!--提交的对象和内容-->
                      <input type="button" name=buttonSave class='button' value="调度"  onclick="saveForm(this);" >
                 </logic:notEqual>  
                  <input type="hidden" name=saveType value="<bean:write name='prpLscheduleMainWFDto' property='saveType' />" >
                </td>    
              
         <td class="button" style="width:50%" align="center">
            <!--取消按钮-->
            <input type="button" name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-2);" >
          </td>
      </tr>
    </table>
