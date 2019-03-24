<%--
****************************************************************************
* DESC       ：通用按钮画面
* AUTHOR     : liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- 保存按钮 --%>              
<table id="buttonArea1" cellpadding="0" cellspacing="0" width="80%" style="display:" id="tablebutton">
  <!--在不同状态下，按钮的数量是不同的，-->
  <%-- (1)立案登记 " 暂存" " 取消" "已完成","已完成并提交"
  (2)暂存  
  (5) "返回"                  
  --%> 
  <tr>
  <%-- 隐藏所按的保存按钮是哪个的标志--%>
    <td>
     
    </td>
  </tr> 
  <tr>
       <logic:notEqual name="prpLcheckDto" property="status" value="4">
              <td class=button style="width:20%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonCertainLossSave class='button' value="暂存" onclick="return saveCertainLossForm(this);">
              </td>
                
      </logic:notEqual>
      <td class=button style="width:33%" align="center">
        <!--取消按钮-->
        <input type=button name=buttonCertainReturn class='bigbutton' value="返回查勘" onclick="backSubPage('span_certa');backSubPage('span_check1');backSubPage('span_check2');" >
      </td>
  </tr>
</table>  