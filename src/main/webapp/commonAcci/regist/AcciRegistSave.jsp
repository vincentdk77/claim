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
            </td>
            </tr>

            <tr>
              <logic:notEqual name="prpLregistDto" property="status" value="4">
              <td class=button style="width:40%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
              </td>

              <td class=button style="width:20%" align="center">
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:40%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>

<%
    if(!editType.equals("ADD")){
%>
          <!--modify by liuyanmei 20051214 reason: 去掉申请调查按钮，所有的申请调查归于一个节点 
            <td class=button style="width:33%" align="center">
               <!--申请调查-->
          <!--     <input type=button name=buttonSchedule class='button' value="申请调查" onclick="applySchedule('<bean:write name='prpLregistDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','01','<bean:write name='prpLregistDto' property='registNo'/>');" >
             </td> 
             -->
<%
    }
%>


           <logic:equal name="prpLregistDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--返回按钮-->
            <a href="javascript:history.go(-1);" style="font-size:12pt">返回</a>

            </td>
          </logic:equal>
        </tr>
      </table>