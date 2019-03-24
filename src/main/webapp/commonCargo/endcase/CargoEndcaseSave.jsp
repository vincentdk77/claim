<%--
****************************************************************************
* DESC       ：通用按钮画面
* AUTHOR     : liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
      <table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" class="common" id='tablebutton'>
      
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
              <td class=button style="width:50%" align="center">
                <!--保存按钮-->
                <input type="button" name=buttonSave class='button' value="保 存" onclick="return saveForm(this,'4');">
              </td>            
         
              <td class=button style="width:50%" align="center">
                <!--取消-->
                <input type=button name=buttonBack class='button' value="<bean:message key='button.cancel.value'/>" onclick="history.back()" >
              </td>
        </tr>
      </table>