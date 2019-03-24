<script language='javascript'>  
      //显示打印窗口
      function printWindow(registNo,strWindowName)
      {
        strUrl = "/claim/ClaimPrint.do?printType=Regist&RegistNo=" + registNo;       
        var pageWidth=screen.availWidth-10;
        var pageHeight=screen.availHeight-30;
        
        if (pageWidth<100 )
          pageWidth = 100;
      
        if (pageHeight<100 )
          pageHeight = 100;
      
        var newWindow = window.open(strUrl,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      }       
  </script>

<%-- 保存通用按钮 --%>        
          <table id="buttonArea" cellpadding="0" cellspacing="0" width="80%" style="display:">
<%    
  UserDto user = (UserDto) session.getAttribute("user");
  String strSchedule = AppConfig.get("sysconst.CHECK_AUTOCOMMIT");
  String comCodeTemp = "-1";
  if(user != null){
	  comCodeTemp = user.getComCode().substring(0,4);
  }

  
  PrpLcheckDto prpLcheckDto =(PrpLcheckDto)request.getAttribute("prpLcheckDto");
  String  flowStr="&swfLogFlowID="+request.getParameter("swfLogFlowID")
                 +"&swfLogLogNo="+request.getParameter("swfLogLogNo")
                 +"&riskCode="+prpLcheckDto.getRiskCode()
                 +"&editType=ADD";

  String alink="/claim/certainLossBeforeEdit.do?RegistNo="+prpLcheckDto.getRegistNo()
                        +"&insureCarFlag="+prpLcheckDto.getInsureCarFlag()
                        +"&lossItemCode="+prpLcheckDto.getLossItemCode()
                        +"&lossItemName="+prpLcheckDto.getLossItemName()
                        +"&checkInput=true"
                        +flowStr;

  if(strSchedule.indexOf(comCodeTemp)>=0){
    //需要自动跳转 
%>
            <tr> 
             <%--增加打印报案记录代抄单的按钮即可实现报案记录带抄单从调度到查勘人员--%>  
        <td class="button"  align="center" style="width:30%">
            <input type="button" name="print" class='bigbutton' value="打印报案记录代抄单" onclick="printWindow('<bean:write name='prpLcheckDto' property='registNo'/>', '打印1');">
        </td>
            <%-- 隐藏所按的保存按钮是哪个的标志--%>
            
            <logic:equal name="prpLcheckDto" property="status" value="4">
                <td class=button style="width:33%" align="center">
                  <!--返回按钮-->
                  <input type=button name=buttonCancel class='button' value="返回" onclick="history.go(-1);" >
                </td>
            </logic:equal>     
            
            <logic:notEqual name="prpLcheckDto" property="status" value="4">  
              <logic:equal name="prpLcheckDto" property="insureCarFlag"  value="1">
                    <td class=button style="width:10%" align="center">
                      <!--保存按钮-->
                       <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
                    </td>
              </logic:equal>
               <td class=button style="width:30%;display:none;" align="right" >
                <%//提示是否需要通知调度%>
                
                <input type="checkbox" name="scheduleCheck" style="width:20px" value="ON"  > 通知调度进行定损
                <input type="hidden" name="messageToScheduleCheck" style="width:20px" value="0" >
              </td>
              <td class=button style="width:20%" align="center">
                <!--保存按钮-->
                
                 <input type="button" name=buttonSave class='button' value="提交" onclick="return saveForm(this,'4');">
              </td>
           
             </logic:notEqual>
              
            </tr>
<%    
  }else{
    //不需要自动跳转
%>    
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
             <%--增加打印报案记录代抄单的按钮即可实现报案记录带抄单从调度到查勘人员--%>  
            <td class="button"  align="center" style="width:30%">
               <input type="button" name="print" class='bigbutton' value="打印报案记录代抄单" onclick="printWindow('<bean:write name='prpLcheckDto' property='registNo'/>', '打印1');">
            </td>
                <logic:notEqual name="prpLcheckDto" property="status" value="4">
              <td class=button style="width:10%" align="center">
                <!--保存按钮-->
                 <input type="button" name=buttonSave class='button' value="暂存" onclick="return saveForm(this,'2');">
                 
              </td>
              <td class=button style="width:30%;display:none;" align="right" >
                <%//提示是否需要通知调度%>
                
                <input type="checkbox" name="scheduleCheck" style="width:20px" value="ON"  > 通知调度进行定损
                <input type="hidden" name="messageToScheduleCheck" style="width:20px" value="0" >
              </td>
              <td class=button style="width:20%" align="center">
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:20%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            
              
            </logic:notEqual>
            
             <logic:equal name="prpLcheckDto" property="status" value="2">
             	<td class=button style="width:20%" align="right">
                <input type="button" name=giveup class='button' value="放弃任务"  onclick="giveupTemporarySave('check');">
              </td>
             </logic:equal> 	
            
            
             <!--放弃任务(只对待处理状态)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatus为0吗？"+statusgiv);
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--放弃按钮style="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="放弃任务" onclick="taskGiveup();" >
             </td>
             <%
             }
              %>              
           <!--放弃任务-->
            
                
                     
           <logic:equal name="prpLcheckDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--取消按钮-->
              <input type=button name=buttonCancel class='button' value="返回" onclick="history.go(-1);" >
            </td>
          </logic:equal>          
        </tr>
<%
  }
%>       
      </table>