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
<table cellpadding="0" cellspacing="0" class="common">

  <tr>
    <%-- 隐藏所按的保存按钮是哪个的标志--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1">
    </td>
  </tr>  
  <tr>  
     <td class=button style="width:33%" align="center">
     <!--取消按钮-->
       <input type=button name=buttonCancel class='button' value="返 回" onclick="javascript:history.go(-2);" >
     </td> 
 </tr>
</table>  
<table cellpadding="0" cellspacing="0" class=common id="buttonArea">

</table>  
<%
  }else{
%>
<%-- 保存通用按钮 --%>
<table id="buttonArea" cellpadding="5" cellspacing="1" class="common" id="tablebutton">
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
    <logic:notEqual name="prpLprepayDto" property="status" value="4">
    <td class=button style="width:20%" align="center">
      <!--保存按钮-->
       <input type="button" name=buttonSave class='button' value="暂 存" onclick="return saveForm(this,'2');">
    </td>
    
    <td class=button style="width:20%" align="center">
    
    <%/*
     <!--提交的对象和内容-->
     <select name="nextNodeNo" style="width:80px">
          <option value="1">报案</option>
          <option value="2">	调度</option>	
          <option value="3">	查勘</option>	
          <option value="4">	定损</option>	
          <option value="5">	核损</option>	
          <option value="10">	单证</option>	
          <option value="11">	预赔</option>	
          <option value="12">	实赔</option>	
          <option value="13">	结案</option>	
          <option value="14">立案	</option>
        </select>
      <input type="text" name=nextHandlerCode class='common' style="width:90px" maxlength="10" value="" >
      <input type="text" name=nextHandlerName class='common' style="width:50px" readonly value="" >
      
      */%>
      <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
    </td>
    <td class=button style="width:20%" align="center">
      <!--取消按钮-->
      <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
    </td>
  </logic:notEqual>
              
   <logic:equal name="prpLprepayDto" property="status" value="4">
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="关 闭" onclick="window.close();">
            </td>
<%
  }else{
%>   
     <td class=button style="width:33%" align="center">
     <!--取消按钮-->
       <input type=button name=buttonCancel class='button' value="返 回" onclick="return resetForm();" >
     </td>
<%
  }
%>     

            
   
   </logic:equal>      
  <logic:equal value="0" parameter="status">
  	 <td class=button  align="center">
        <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskGiveup();" >
        </td>
  </logic:equal> 
 </tr>
</table>  

<%
  }
%>