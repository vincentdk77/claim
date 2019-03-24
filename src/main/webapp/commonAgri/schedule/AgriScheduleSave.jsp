<%  
   String schedFlag=(String)request.getAttribute("schedFlag"); 
%>
 <script language='javascript'>
 
   function backDeal(buttonType) {
     fm.buttonSaveType.value = buttonType;
     fm.submit();
   }

   
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
      
        function returnBack(){
         fm.action = "wfLogQuery.do?nodeType=sched&status=0&searchLabel=registNo&searchField=keyIn";
         fm.submit();
      }   
 

 </script>
 <%-- 调度提交通用按钮 --%>
 <input  type="hidden" name=buttonSaveType value="1"> 
 <% if (editType.equals("SHOW")||editType.equals("DELETE"))
  {   //只显示返回按钮
 %>
  <table  id="buttonArea" cellpadding="0" cellspacing="10" width="80%" style="display:">
  </table>
  <table  cellpadding="0" cellspacing="10" width="80%" style="display:" align="center">
  
  <tr>

 <%
  } else {
 %>
  
     <table id="buttonArea" cellpadding="0" cellspacing="10" width="80%" style="display:" align="center">
      <tr>

     <% String nblnull="disabled";%>
       
         
         <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
           
             <% nblnull="";%>
           
          </logic:notEmpty>
         
              
               <td class="button" style="width:35%" align="center">
                  <!--调度按钮-->
                 
                 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
            <%//modify by lixiang add 20050309 start
							//reason:取回并修改名称改成提交%>
                   <input type="button" name=buttonSave class='button' value="改派" <%=nblnull%> onclick="saveForm(this);" >
						<%//modify by lixiang add 20050309 end%>                 
                 </logic:equal>  
           
                 <logic:notEqual name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
                 
                   <!--提交的对象和内容-->
                   <logic:notEqual name="schedule.flag" value="false">
                     <input type="button" name=buttonSave class='button' value="调度" <%=nblnull%> onclick="saveForm(this);" >
                   </logic:notEqual>
                   <logic:equal name="schedule.flag" value="false">
                     <input type="button" name=buttonSave class='bigbutton' value="退回到待处理" <%=nblnull%> onclick="backDeal('20');" >
                   </logic:equal>
                 </logic:notEqual>  
                 
               
               </td>
               
 <!-- 暂时不用，予以屏蔽。用时放开。         
<%
					//add by liyanjie 2005-12-06 双代 start
					if(editType.equals("ADD") && hasSchedFlag == false){    
						//显示提交双代按钮
%>
							<td class="button" style="width:35%" align="center">
								<input  type="button" name=buttonCommission class='button' value="申请双代" <%=nblnull%> onclick="applyCommi(this);" <%=disabledCommiFlag%>>
							</td>
<%						
					}
				  //add by liyanjie 2005-12-06 双代 end
%>
-->
<%
	}
%> 
        
    
         <td class="button" style="width:40%" align="center">
            <!--取消按钮-->
            <%if(!schedFlag.equals("Y")){%>
            <input type="button" name=buttonCancel class='button' value="返回" onclick="history.go(-1);" >
            <%}else{%>
            <input type="button" name=buttonCancel disabled=true class='button' value="返回" onclick="history.go(-1);" >
            <%}%>
          </td>
      </tr>
    </table>
