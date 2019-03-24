<SCRIPT LANGUAGE="JavaScript">
    function showButton() {  //此函数用于在加载时按钮可用
       if (fm.buttonCloseReturn.value == "close") {
            fm.buttonClose.disabled = false;
       } else {
            fm.buttonReturn.disabled = false;
        }
    }
</script>

<%-- 保存通用按钮 --%>
          <table  id="buttonArea" class=common style="display:">
      <!--在不同状态下，按钮的数量是不同的，-->
      <%-- (1)立案登记 " 暂存" " 取消" "已完成","已完成并提交"
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
  <%    String dfFlag=request.getParameter("dfFlag");
        if("Y".equals(dfFlag) ){
        %>  
         <td class=button style="width:33%" align="center">
              <!--取消按钮-->
              <input type=button name=buttonBack class='button' value="返回" onclick="return history.back();" >
            </td>
           <% }else { %>
       <logic:notEqual  name="prpLclaimDto" property="status" value="4">
          <td class=button style="width:25%;display:none" align="center">
            <!--保存按钮-->
           <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
          </td>

         <td class=button style="width:33%" align="center">
            <!--提交按钮-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="提交" onclick="return saveForm(this,'4');" >
         </td>
         
         <td class=button style="width:33%" align="center">
            <!--注销按钮-->
            <input type="button" name=buttonOffSubmit class='button' value="注销" onclick="return offForm(this);" >
         </td>

          <td style="display:none" class=button style="width:33%" align="center">
            <!--取消按钮-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:notEqual>

      <logic:equal name="prpLclaimDto" property="status" value="3">
       
         <td class=button style="width:33%;display:none" align="center">
            <!--保存按钮-->
           <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'3');">
         </td>

         <td class=button style="width:33%" align="center">
                <!--回退按钮-->
                <input type="button" name=buttonSave class='button' value="回退" onclick="return saveForm(this,'2');">
              </td>

         <td class=button style="width:33%" align="center">
            <!--提交按钮-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="提交" onclick="return saveForm(this,'4');" >
         </td>
          <td class=button style="width:33%" align="center">
            <!--取消按钮-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </logic:equal>

      <logic:equal name="prpLclaimDto" property="status" value="4">
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonClose class='button' value="关 闭" onclick="window.close();">
            <input  type="hidden" name=buttonCloseReturn value="close">
            </td>
<%
  }else{
%>      
          <td class=button style="width:33%" align="center">
            <!--取消按钮-->
            <input type=button name=buttonReturn class='button' value="返回" onclick="history.go(-1);" >
            <input  type="hidden" name=buttonCloseReturn value="return">
          </td>
<%
  }
%>          
      </logic:equal>
           <!--放弃任务(只对待处理状态)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatus为0吗？"+statusgiv);
                  if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--放弃按钮style="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskGiveup();" >
             </td>
             <%
             }
             %>              
           <!--放弃任务-->

      <logic:equal name="prpLclaimDto" property="classCode" value="27">
          <td class=button style="width:33%" align="center">
            <!--申请调查-->
            <input type=button name=buttonSchedule class='bigbutton' value="申请调查" onclick="applySchedule('<bean:write name='prpLclaimDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','03','<bean:write name='prpLclaimDto' property='claimNo'/>');" >
          </td>
      </logic:equal>
    <%}%>  
      </tr>
    </table>
