<SCRIPT LANGUAGE="JavaScript">
    function showButton() {  //此函数用于在加载时按钮可用
       if (fm.buttonCloseReturn.value == "close") {
            fm.buttonClose.disabled = false;
       } else {
            fm.buttonReturn.disabled = false;
        }
    }

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
        applySchedule('<bean:write name='prpLclaimDto' property='registNo'/>','claim','<%= request.getParameter("swfLogFlowID") %>','<%= request.getParameter("swfLogLogNo") %>','<%= request.getParameter("status") %>','03','<bean:write name='prpLclaimDto' property='claimNo'/>');
      } 
       
    }
    else {     //无核赔权限
       alert("只有有核赔权限的人才可以申请调查！");
       return false;
     }
    }
    
//modify by liuyanmei add end 20051028    
    
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
       <logic:notEqual  name="prpLclaimDto" property="status" value="4">
 
         <!--
          <logic:equal  name="prpLclaimDto" property="status" value="1">
             <td class=button style="width:25%" align="center">
              不予立案按钮 2005-09-06
               <input type="button" name=buttonSave class='button' value="不予立案" 
                 onclick="return notGrandClaim(fm.registno.value,fm.riskcode.value, fm.swfLogFlowID.value,fm.swfLogLogNo.value);">
             </td>
          </logic:equal>
          -->
          <td class=button style="width:25%;display:none" align="center">
            <!--保存按钮-->
           <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
          </td>

         <td class=button style="width:25%" align="center">
            <!--提交按钮-->
            <input type="button" name=buttonSaveFinishSubmit class='button' value="提交" onclick="return saveForm(this,'4');" >
         </td>

          <td class=button style="width:25%" align="center">
            <!--取消按钮-->
            <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
          
     <!--申请调查--modify by liuyanmei modify 20051214-->
        <!--   <td class=button style="width:25%" align="center">
            <input type=button name=buttonSchedule class='bigbutton' value="申请调查" onclick="appcheck();" >
          </td>
       -->   
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
      
      <!--放弃任务(只对待处理状态)-->
             <% String statusgiv= request.getParameter("status");
               if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--放弃按钮style="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskClaimGiveup();" >
             </td>
             <%
             }
              %>              
           <!--放弃任务-->


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
            <input  name=buttonCancel class='button' value="返回" onclick="history.back(0)" >
          </td> 
<%
  }
%>          
      </logic:equal>
      </tr>
    </table>
 