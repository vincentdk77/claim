<%-- 保存通用按钮 --%>        
          <table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
            <!--在不同状态下，按钮的数量是不同的，-->
            <%-- (1)立案登记 " 保存" " 取消" "已完成","已完成并提交"
                 (2)正处理   "更新" "取消","已完成","已完成并提交","撤消"
                 (3)已完成   "更新" "取消" "提交"
                 (4)已提交   "返回"
                 (5)撤消     "返回"
                  
            --%>
            <tr>
            <%-- 隐藏所按的保存按钮是哪个的标志--%>
            <td>
            <input  type="hidden" name=buttonSaveType value="1">
            </td>
            </tr>
            <tr>
                <logic:notEqual name="prpLcheckDto" property="status" value="4">
              <td class=button style="width:20%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
                 
              </td>
              
              <td class=button style="width:70%" align="center">
               <!--提交的对象和内容-->
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:20%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
            
             <!--放弃任务(只对待处理状态)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatus为0吗？"+statusgiv);
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--放弃按钮style="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskCheckGiveup();" >
             </td>
             <%
             }
              %>              
           <!--放弃任务-->
                
                     
           <logic:equal name="prpLcheckDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--取消按钮-->
              <input type=button name=buttonBack class='button' value="返回" onclick="return history.back();" >
            </td>
          </logic:equal>          
        </tr>
      </table>