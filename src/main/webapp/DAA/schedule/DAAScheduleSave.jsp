 <script language='javascript'>
 
   function backDeal(buttonType) {
     fm.buttonSaveType.value = buttonType;
     fm.submit();
   }

   
      //��ʾ��ӡ����
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
 <%-- �����ύͨ�ð�ť --%>
 <input  type="hidden" name=buttonSaveType value="1"> 
 <% if (editType.equals("SHOW")||editType.equals("DELETE"))
  {   //ֻ��ʾ���ذ�ť
 %>
  <table  id="buttonArea" cellpadding="0" cellspacing="10" width="80%" style="display:">
  </table>
  <table  cellpadding="0" cellspacing="10" width="80%" style="display:" align="center">
  
  <tr>
     <%--���Ӵ�ӡ������¼�������İ�ť����ʵ�ֱ�����¼�������ӵ��ȵ��鿱��Ա--%>  
        <td class="button"  align="center"  style="width:30%">
            <input type="button" name="print" class='bigbutton' value="��ӡ������¼������" onclick="printWindow('<bean:write name='prpLscheduleMainWFDto' property='registNo' />','');">
        </td>
 <%
  } else {
 %>
  
     <table id="buttonArea" cellpadding="0" cellspacing="10" width="80%" style="display:" align="center">
      <tr>
      <%--���Ӵ�ӡ������¼�������İ�ť����ʵ�ֱ�����¼�������ӵ��ȵ��鿱��Ա--%>  
        <td class="button"  align="center"  style="width:30%">
            <input type="button" name="print" class='bigbutton' value="��ӡ������¼������" onclick="printWindow('<bean:write name='prpLscheduleMainWFDto' property='registNo' />','');">
        </td>
     <% String nblnull="disabled";%>
       
         
         <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
           
             <% nblnull="";%>
           
          </logic:notEmpty>
         
              
               <td class="button" style="width:35%" align="center">
                  <!--���Ȱ�ť-->
                 
                 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
            <%//modify by lixiang add 20050309 start
							//reason:ȡ�ز��޸����Ƹĳ��ύ%>
                   <input type="button" name=buttonSave class='button' value="����" <%=nblnull%> onclick="saveForm(this);" >
						<%//modify by lixiang add 20050309 end%>                 
                 </logic:equal>  
           
                 <logic:notEqual name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
                 
                   <!--�ύ�Ķ��������-->
                   <logic:notEqual name="schedule.flag" value="false">
                     <input type="button" name=buttonSave class='button' value="����" <%=nblnull%> onclick="saveForm(this);" >
                   </logic:notEqual>
                   <logic:equal name="schedule.flag" value="false">
                     <input type="button" name=buttonSave class='bigbutton' value="�˻ص�������" <%=nblnull%> onclick="backDeal('20');" >
                   </logic:equal>
                 </logic:notEqual>  
                 
               
               </td>
               
 <!-- ��ʱ���ã��������Ρ���ʱ�ſ���         
<%
					//add by liyanjie 2005-12-06 ˫�� start
					if(editType.equals("ADD") && hasSchedFlag == false){    
						//��ʾ�ύ˫����ť
%>
							<td class="button" style="width:35%" align="center">
								<input  type="button" name=buttonCommission class='button' value="����˫��" <%=nblnull%> onclick="applyCommi(this);" <%=disabledCommiFlag%>>
							</td>
<%						
					}
				  //add by liyanjie 2005-12-06 ˫�� end
%>
-->
<%
	}
%> 
        
    
         <td class="button" style="width:20%" align="center">
            <!--ȡ����ť-->
            <input type="button" name=buttonCancel class='button' value="����" onclick="history.go(-1);" >
         
        </td>
        <td align="center">
        	 
        	 <%  String statusgiv= request.getParameter("status");
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
            	 <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >&nbsp;
             <%
             	}
             %>
        </td>
      </tr>
    </table>
