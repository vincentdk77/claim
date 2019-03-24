<table id="buttonArea" cellpadding="0" cellspacing="0" width="90%" style="display:">
            <!--在不同状态下，按钮的数量是不同的，-->
            <%-- (1)立案登记 " 保存" "取消" "已完成","已完成并提交"
                 (2)正在处理
                 (3)回退的
                 (4)已提交   "返回"
                 (5)撤消     "返回"
            --%>
            
       
         
      
            <tr> 
            <%-- 隐藏所按的保存按钮是哪个的标志--%>
            <td>
              <input type="hidden" name=buttonSaveType value="1">
              <html:select name="swfPathDto" property="nextNodeNoList" style="width:0px;height:0px" multiple="true" >
            <html:options collection="userSelectList" property="endNodeNo"  labelProperty="endNodeName" />          
       </html:select>
            </td>
            </tr>
            
            <tr>
              <logic:notEqual name="prpLregistDto" property="status" value="4">
              <logic:present name="prpLclaimStatusDto">
                <logic:notEqual name="prpLclaimStatusDto" property="status" value="4">
		              <td class=button style="width:40%" align="center">
		                <!--保存按钮-->
		                 <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
		              </td>
		            </logic:notEqual>
		          </logic:present>
		          <logic:notPresent name="prpLclaimStatusDto">
		            <td class=button style="width:40%" align="center">
                  <!--保存按钮-->
                   <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
                </td>
		          </logic:notPresent>
              <td class=button style="width:20%" align="center"> 
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
			<!-- 判断是否有直接调度的权限 -->
		    	<% String  checkPower =(String)request.getAttribute("checkPower");
				  if ("true".equals(checkPower)){%>
		         <td id="scheduleRefTd" class=button style="width:20%" align="center">
					<input type="hidden" name="scheduleRef" id="scheduleRef" value="">
		 			<input type="button"  class='button' value="调度" onclick="return saveFormNew(this,'4','scheduleRef');">
		 		</td>
		 		<%} %>
              <td class=button style="width:40%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
                
                         
           <logic:equal name="prpLregistDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--返回按钮-->
            <a href="javascript:history.go(-1);" style="font-size:12pt">返回</a>
            
            </td>
          </logic:equal>          
        </tr>
      </table>

   