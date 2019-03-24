<%-- 保存通用按钮 --%>        
         <table id="buttonArea" cellpadding="5" cellspacing="1" class=common style="display:" >
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
              <%--并案环节屏蔽  <logic:notEqual name="prpLcheckDto" property="status" value="4">--%>
              <td class=button align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
                 
              </td>
              
              <td class=button align="center">
               <!--提交的对象和内容-->
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
         <%--并案环节屏蔽   </logic:notEqual>--%>
            
			<td class=button align="center">
        	 <input type="button" name=giveup class='button' value="放弃任务"  onclick="giveupCombineTemporarySave('check');">
       		 </td>	             
           <!--放弃任务-->
                
                     
         <%--并案环节暂时屏蔽   <logic:equal name="prpLcheckDto" property="status" value="4">--%>
             <td class=button  align="center">
              <!--取消按钮-->
              <input type=button name=back class='button' value="返回" onclick="return history.back();" >
            </td>
         <%--并案环节暂时屏蔽  </logic:equal>     --%>
        </tr>
      </table>