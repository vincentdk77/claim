<%--
****************************************************************************
* DESC       ：通用按钮画面
* AUTHOR     : liubvo
* CREATEDATE ：2004-10-11
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%>
<%-- 保存通用按钮 --%>              
<table id="buttonArea" cellpadding="5" cellspacing="1" class=common style="display:" >
  <!--  modify by liyanjie 20051022 一个table两个id del: id="tablebutton"  -->
  <!--在不同状态下，按钮的数量是不同的，-->
  <%-- (1)立案登记 " 暂存" " 取消" "已完成","已完成并提交"
  (2)正处理   "更新" "取消","已完成","已完成并提交","撤消"
  (3)已完成   "更新" "取消" "提交"
  (4)已提交   "返回"
  (5)撤消     "返回"                  
  --%> 
  <tr class=common>
  <%-- 隐藏所按的保存按钮是哪个的标志--%>
    <td>
      <input  type="hidden" name=buttonSaveType value="2">
    </td>
  </tr> 
  
  <tr>  
      <% //检查是不是从查勘直接进入的定损，如果是的话，那么只保存，没有工作流的事情。
        String dfFlag=request.getParameter("dfFlag");
        if("Y".equals(dfFlag) ){
        %>
        <td class=button align="center">
           <!--返回按钮-->
             <input type=button name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-1);" >
        </td>
        
        
        <%
       } else {
         String checkInput=request.getParameter("checkInput");
         if (checkInput!=null&&checkInput.equals("true"))
         {
         %>
         
          <td class=button align="center">
                <!--保存按钮-->
                <input  type="hidden" name=checkInput value="true">
                <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'CheckInput');">
                
          </td>
            <td class=button align="center">
           <!--返回按钮-->
             <input type=button name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-1);" >
            </td>   
         <%
         }else{
      %>
      
        <logic:notEqual name="prpLverifyLossDto" property="status" value="4">
              <td class=button  align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
              </td>
              
              <td class=button align="center">
              


                <!--<input type=text name="nextHandlerCode" class="codecode"  style="width:100px" title="操作员" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
            <input type=text name="nextHandlerName" class="codecode" style="width:80px" title="操作员" value=""
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');">-->
             
               <!--Modify by chenenda update end 20050420-->
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button  align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            </logic:notEqual>
     <%}%>           
    <logic:equal name="prpLverifyLossDto" property="status" value="4">
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
      <td class=button  align="center">
        <!--取消按钮-->
         <input type="button" class="button" value="返 回" src="/claim/images/bgClaimBackButtonSmall.gif" align="middle" width="68" height="21"  border-style="none"  LANGUAGE=JAVASCRIPT  onmousedown="history.back();return false;">         
      </td>
<%
  }
%>
    </logic:equal> 
     <logic:equal name="prpLverifyLossDto" property="status" value="2">
     	<td class=button  align="right">
        	 <input type="button" name=giveup class='button' value="放弃任务"  onclick="giveupTemporarySave('certa');">
        </td>	 
     </logic:equal>
    
    <!--放弃任务(只对待处理状态)-->
             <% String statusgiv= request.getParameter("status");
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--放弃按钮style="width:30%"-->
             <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskGiveup();" >
             </td>
             <%
             }
        }      %>              
           <!--放弃任务-->
           
  </tr>
</table>  