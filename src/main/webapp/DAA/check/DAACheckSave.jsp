<script language='javascript'>  
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
  </script>

<%-- ����ͨ�ð�ť --%>        
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
    //��Ҫ�Զ���ת 
%>
            <tr> 
             <%--���Ӵ�ӡ������¼�������İ�ť����ʵ�ֱ�����¼�������ӵ��ȵ��鿱��Ա--%>  
        <td class="button"  align="center" style="width:30%">
            <input type="button" name="print" class='bigbutton' value="��ӡ������¼������" onclick="printWindow('<bean:write name='prpLcheckDto' property='registNo'/>', '��ӡ1');">
        </td>
            <%-- ���������ı��水ť���ĸ��ı�־--%>
            
            <logic:equal name="prpLcheckDto" property="status" value="4">
                <td class=button style="width:33%" align="center">
                  <!--���ذ�ť-->
                  <input type=button name=buttonCancel class='button' value="����" onclick="history.go(-1);" >
                </td>
            </logic:equal>     
            
            <logic:notEqual name="prpLcheckDto" property="status" value="4">  
              <logic:equal name="prpLcheckDto" property="insureCarFlag"  value="1">
                    <td class=button style="width:10%" align="center">
                      <!--���水ť-->
                       <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
                    </td>
              </logic:equal>
               <td class=button style="width:30%;display:none;" align="right" >
                <%//��ʾ�Ƿ���Ҫ֪ͨ����%>
                
                <input type="checkbox" name="scheduleCheck" style="width:20px" value="ON"  > ֪ͨ���Ƚ��ж���
                <input type="hidden" name="messageToScheduleCheck" style="width:20px" value="0" >
              </td>
              <td class=button style="width:20%" align="center">
                <!--���水ť-->
                
                 <input type="button" name=buttonSave class='button' value="�ύ" onclick="return saveForm(this,'4');">
              </td>
           
             </logic:notEqual>
              
            </tr>
<%    
  }else{
    //����Ҫ�Զ���ת
%>    
            <!--�ڲ�ͬ״̬�£���ť�������ǲ�ͬ�ģ�-->
            <%-- (1)�����Ǽ� " �ݴ�" " ȡ��" "�����","����ɲ��ύ"
                 (2)������   "����" "ȡ��","�����","����ɲ��ύ","����"
                 (3)�����   "����" "ȡ��" "�ύ"
                 (4)���ύ   "����"
                 (5)����     "����"
                  
            --%>
            <tr>
            <%-- ���������ı��水ť���ĸ��ı�־--%>
            <td>
            <input  type="hidden" name=buttonSaveType value="1">
            </td>
            </tr>
            <tr>
             <%--���Ӵ�ӡ������¼�������İ�ť����ʵ�ֱ�����¼�������ӵ��ȵ��鿱��Ա--%>  
            <td class="button"  align="center" style="width:30%">
               <input type="button" name="print" class='bigbutton' value="��ӡ������¼������" onclick="printWindow('<bean:write name='prpLcheckDto' property='registNo'/>', '��ӡ1');">
            </td>
                <logic:notEqual name="prpLcheckDto" property="status" value="4">
              <td class=button style="width:10%" align="center">
                <!--���水ť-->
                 <input type="button" name=buttonSave class='button' value="�ݴ�" onclick="return saveForm(this,'2');">
                 
              </td>
              <td class=button style="width:30%;display:none;" align="right" >
                <%//��ʾ�Ƿ���Ҫ֪ͨ����%>
                
                <input type="checkbox" name="scheduleCheck" style="width:20px" value="ON"  > ֪ͨ���Ƚ��ж���
                <input type="hidden" name="messageToScheduleCheck" style="width:20px" value="0" >
              </td>
              <td class=button style="width:20%" align="center">
                <input type="button" name=buttonSaveFinishSubmit class='button' value="<bean:message key='button.submit.value'/>" onclick="return saveForm(this,'4');" >
              </td>
              <td class=button style="width:20%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
              </td>
            
              
            </logic:notEqual>
            
             <logic:equal name="prpLcheckDto" property="status" value="2">
             	<td class=button style="width:20%" align="right">
                <input type="button" name=giveup class='button' value="��������"  onclick="giveupTemporarySave('check');">
              </td>
             </logic:equal> 	
            
            
             <!--��������(ֻ�Դ�����״̬)-->
             <% String statusgiv= request.getParameter("status");
              System.out.println("satatusΪ0��"+statusgiv);
                 if(statusgiv!=null&&statusgiv.equals("0")){
             %>
             <td class=button  align="center">
              <!--������ťstyle="width:33%"-->
             <input type=button name=buttonGiveup class='button' value="��������" onclick="taskGiveup();" >
             </td>
             <%
             }
              %>              
           <!--��������-->
            
                
                     
           <logic:equal name="prpLcheckDto" property="status" value="4">
             <td class=button style="width:33%" align="center">
              <!--ȡ����ť-->
              <input type=button name=buttonCancel class='button' value="����" onclick="history.go(-1);" >
            </td>
          </logic:equal>          
        </tr>
<%
  }
%>       
      </table>