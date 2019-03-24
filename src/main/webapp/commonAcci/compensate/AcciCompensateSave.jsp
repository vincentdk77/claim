<%--
****************************************************************************
* DESC       ：通用按钮画面
* AUTHOR     : liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<SCRIPT LANGUAGE="JavaScript">

//modify by liuyanmei delete start 20051214 reason:去掉申请调查按钮，所有调查申请集中于一个菜单来做
/*
//modify by liuyanmei add start 20051028
  //reason：1.交验员工是否有权限申请调查;
  //reason: 2.交验是否上次调查还没有结束，没结束，不允许再次提调
  //reason：3.打开申请调查录入页面      
 
  function appcheck() {  
   if(fm.cancheck.value=="1"){             //"0"无权限申请调查,"1"有权限申请（有核赔权限）
     if (fm.checkNotOver.value == "1") {   //"1"上次调查还没有结束;"0"没有提起过调查，或上次调查结束；
        alert("上次申请调查还没有处理，不能再次申请调查");
        return false;
      }
      else {
       applySchedule('<bean:write name='prpLcompensateDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','05','<bean:write name='prpLcompensateDto' property='compensateNo'/>');
      } 
       
    }
    else {     //无核赔权限
       alert("只有有核赔权限的人才可以申请调查！");
       return false;
     }
    }
    
//modify by liuyanmei add end 20051028    
*/
//modify by liuyanmei delete start 20051214 reason:去掉申请调查按钮，所有调查申请集中于一个菜单来做    
</script>

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
     <td class="button" type="button" align="center" >
       <Input name="buttonTrace" class="button" type="button"  alt="审核意见" value="审核意见" tabindex="-1" onclick="viewHePeiTrace('<bean:write name='prpLcompensateDto' property='compensateNo' />');">
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
              <td class=button style="width:25%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
              </td>
              <td class=button style="width:25%" align="center">
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
              <td class=button style="width:25%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
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
  <!--申请调查--modify by liuyanmei modify 20051214 start-->
  <!--  <td class=button style="width:25%" align="center">
       <input type=button name=buttonSchedule class='button' value="申请调查" onclick="appcheck();" >
     </td>  -->
<!--申请调查--modify by liuyanmei modify 20051214 end-->
     <logic:equal name="prpLcompensateDto" property="status" value="4">
       <td class=button style="width:33%" align="center">
        <!--取消按钮-->
        <input type=button name=buttonBack class='button' value="返回" onclick="return history.back(-1);" >
      </td>
    </logic:equal>
  </tr>
</table>
<%
  }
%>