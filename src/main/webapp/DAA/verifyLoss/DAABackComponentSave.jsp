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
        <table cellpadding="0" cellspacing="0" width="100%" style="display:"  id="buttonArea">
        <tr>
            <%-- 隐藏所按的保存按钮是哪个的标志--%>
            <td colspan="5">
              <input  type="hidden" name=buttonSaveType value="1">
            </td>
          </tr>
          
        <tr>
          <logic:notEqual name="prpLverifyLossDto" property="status" value="4">
              <td class=button style="width:30%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="暂 存" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button style="width:40%" align="center">
               <!--提交的对象和内容-->
                 <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:30%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="返 回" onclick="javascript:history.go(-2);" >
              </td>
            </logic:notEqual>
                  
         <logic:equal name="prpLverifyLossDto" property="status" value="4">
           <td class=button style="width:90%" align="center">
            <!--取消按钮-->
            <input type=button name=buttonCancel class='button' value="返 回" onclick="javascript:history.go(-2);" >
          </td>
        </logic:equal>   
       
          <input type=hidden name=verifyOpinion  value=""  >
          <input type=hidden name=nextNodeNo  value="0"  >
        
              
      </tr>  
    </table>