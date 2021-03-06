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
<table cellpadding="0" cellspacing="0" width="100%" class="common">

  <tr>
    <%-- 隐藏所按的保存按钮是哪个的标志--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="1"> 
    </td>
  </tr> 
  <tr>
<%
  if(editTypeTemp.equals("DELETE")){
%>
    
     <td class=button align="center">
            <input type="button" name=buttonDelete class='button' value="删 除" onclick="submitDelete();">
     </td>  
<%
  }
%>              
<%
  if ("noDisplay".equals(request.getParameter("claimFlag"))) {  
%>       
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="关 闭" onclick="window.close();">
          </td>
<%
  } else {
%>
     <td class=button align="center">
     <!--取消按钮-->
       <input type=button name=buttonCancel class='button' value="返 回" onclick="history.go(-1);" >
     </td>
     <td class="button" type="button" align="center" >
       <Input name="buttonTrace" class="button" type="button"  alt="审核意见" value="审核意见" tabindex="-1" onclick="viewHePeiTrace('<bean:write name='prpLcompensateDto' property='compensateNo' />');">
     </td>
<%
  }
%>  
  </tr>
</table>  
<table  class=common id="buttonArea">

</table>  
<%
  }else{
%>
  <%-- 保存通用按钮 --%>
    
    <table id="buttonArea" cellpadding="0" cellspacing="0" width="100%" style="display:">
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
              <td class=button   align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
              </td>
              <td class=button   align="center">
               <!--提交的对象和内容-->
             <%/* 
             
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
              <td class=button   align="center">
                <!--取消按钮-->
                <%--<input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >--%>
                <input type="reset" class="button" value="<bean:message key='button.cancel.value'/>"> </input>
                
              </td>
              <td class="button" type="button" align="center" >
                <Input name="buttonTrace" class="button" type="button"  alt="审核意见" value="审核意见" tabindex="-1" onclick="viewHePeiTrace('<bean:write name='prpLcompensateDto' property='compensateNo' />');">
              </td>
            </logic:notEqual>
           <%String statusgiv= request.getParameter("status");
             if(statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--放弃按钮style="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskGiveup();" >
             </td>
             <%
             }
              %>               
     <logic:equal name="prpLcompensateDto" property="status" value="4">
<%
  String ifclose = request.getParameter("ifclose");
  if("true".equals(ifclose)){
%>              
          <td class=button style="width:33%" align="center">
            <input type="button" name=buttonSave class='button' value="关 闭" onclick="window.close();">
          </td>
<%
  } else {
%>
       <td class=button  align="center">
        <!--取消按钮-->
        <input type=button name=buttonBack class='button' value="返回" onclick="history.back(-1);" >
      </td>
<%
  }
%>      
    </logic:equal>          
  </tr> 
</table>
<%
  }
%>