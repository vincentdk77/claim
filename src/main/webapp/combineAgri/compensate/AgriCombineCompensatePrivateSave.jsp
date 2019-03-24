<%--
****************************************************************************
* DESC       ：通用按钮画面
* AUTHOR     : liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>           
<%  
  String editTypeTemp=request.getParameter("editType");
  if (editTypeTemp.equals("SHOW")||editTypeTemp.equals("DELETE"))
  {
%>

<%-- 保存通用按钮 --%>
<table cellpadding="0" cellspacing="0" width="80%" class="common">

  <tr>
    <%-- 隐藏所按的保存按钮是哪个的标志--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1"> 
    </td>
  </tr>  
  <tr>  
     <td class=button style="width:33%" align="center">
     <!--取消按钮-->
       <input type=button name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-1);" >
     </td> 
 </tr>
</table>  
<table cellpadding="0" cellspacing="0" width="0"  height="0"id="buttonArea">

</table>  
<%
  }else{
%>
  <%-- 保存通用按钮 --%>
    
    <table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <!--在不同状态下，按钮的数量是不同的，-->
      <%-- (1)立案登记 " 暂存" " 取消" "已完成","已完成并提交"
           (2)正处理   "更新" "取消","已完成","已完成并提交","撤消"
           (4)已提交   "返回"
           (5)撤消     "返回"
           因为是自动的，所以先注释掉相应的人员提交 
      --%>
      <tr>
      <%-- 隐藏所按的保存按钮是哪个的标志--%>
      <td>
        <input  type="hidden" name=buttonSaveType value="1">
      </td>
      </tr>
      <tr>
                  <logic:notEqual name="prpLcompensateDto" property="status" value="4">
              <td class=button style="width:50%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="保 存" onclick="return saveForm(this,'2');">
              </td>
              <td class=button style="width:50%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="取消" onclick="return resetForm();" >
              </td>
            </logic:notEqual>           
  </tr> 
</table>
<%
  }
%>