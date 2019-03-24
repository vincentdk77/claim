<%--
****************************************************************************
* DESC       ：通用按钮画面
* AUTHOR     : liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- 保存通用按钮 --%>
<table cellpadding="0" cellspacing="0" width="80%" class="common">
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
    <logic:equal name="prpLprepayDto" property="status" value="1">
    <td class=button style="width:25%" align="center">
      <!--保存按钮-->
      <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
    </td>
    <td class=button style="width:25%" align="center">
      <!--已完成按钮-->
      <input type="button" name=buttonSaveFinish class='button' value="已完成"  onclick="return saveForm(this,'3');" >
    </td>     
    <td class=button style="width:25%" align="center">
      <!--已完成并提交按钮-->
      <input type="button" name=buttonSaveFinishSubmit class='button' value="完成并提交" onclick="return saveForm(this,'4');" >
    </td>
   <td class=button style="width:25%" align="center">
      <!--取消按钮-->
      <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
   </td>
   </logic:equal>
  
   <logic:equal name="prpLprepayDto" property="status" value="2">
   <td class=button style="width:25%" align="center">
     <!--保存按钮-->
      <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'2');">
   </td>

   <td class=button style="width:25%" align="center">
     <!--已完成按钮-->
     <input type="button" name=buttonSaveFinish class='button' value="已完成"  onclick="return saveForm(this,'3');" >
   </td>

   <td class=button style="width:25%" align="center">
     <!--提交按钮-->
     <input type="button" name=buttonSaveFinishSubmit class='button' value="提交" onclick="return saveForm(this,'4');" >
   </td>

   <td class=button style="width:25%" align="center">
     <!--取消按钮-->
     <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
   </td>
   </logic:equal>
      
   <logic:equal name="prpLprepayDto" property="status" value="3">
   <td class=button style="width:33%" align="center">
     <!--保存按钮-->
     <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return saveForm(this,'3');">
   </td>

   <td class=button style="width:33%" align="center">
     <!--提交按钮-->
     <input type="button" name=buttonSaveFinishSubmit class='button' value="提交" onclick="return saveForm(this,'4');" >
   </td>

   <td class=button style="width:33%" align="center">
     <!--取消按钮-->
     <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
   </td>
   </logic:equal> 
              
   <logic:equal name="prpLprepayDto" property="status" value="4">
     <td class=button style="width:33%" align="center">
     <!--取消按钮-->
       <input type=button name=buttonBack class='button' value="返回" onclick="return history.back();" >
     </td>
   </logic:equal>          
 </tr>
</table>  