<%--
****************************************************************************
* DESC       �����õ������ĵ�����
* AUTHOR     �� lixiang
* CREATEDATE �� 2005-08-30
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<script language="javascript">
function changeComCode(){
   fm.action="/claim/scheduleCompanyQuery.do";
   fm.submit();
  }
</script>  

	<table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">������������
	          </td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td width="70%" align="right"><font color="#666666">��ע����<font color="#FF0000">*</font>��Ϊ��ѡ���<img src="/claim/images/bgDoubleClick2.gif" width="13" height="13" align="absbottom">�� 
	  Ϊ˫��ѡ���</font></td>
	</tr>
</table>
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
      <tr>
        <td class="title" colspan="4">������������
        
          <input type="hidden" name="prpLscheduleCompanyMobileNo" value="<bean:write name='prpLscheduleCompanyDto' property='mobileNo' />">		 		
				  <input type="hidden" name="prpLscheduleCompanyLinkerName" value="<bean:write name='prpLscheduleCompanyDto' property='linkerName' />">					
				  <input type="hidden" name="prpLscheduleCompanyValidStatus" value="<bean:write name='prpLscheduleCompanyDto' property='validStatus' />">		
          <input type="hidden" name="prpLscheduleCompanyRemark" value="Remark">					
          <input type="hidden" name="prpLscheduleCompanyFlag" value="<bean:write name='prpLscheduleCompanyDto' property='flag' />">
          <input type="hidden" name="upperCompCode" value="";>
          <input type="hidden" name="editType" value="<%=editType%>";>
          
        </td>
      </tr> 
      <tr>    
      
      <%   
         //������ܹ�˾�ģ������������еĵ��Ȼ���
      
       UserDto user = (UserDto) session.getAttribute("user");
       String comCodeTemp = user.getComCode();
       comCodeTemp = comCodeTemp.substring(0,4);
       if (comCodeTemp.equals("3100")||comCodeTemp.equals("3199")){
      %>
       <td class="title" style="width:15%">��������:</td>
        <td class="input"  colspan=3>
      <html:select name="prpLscheduleCompanyDto" property="comCode" styleClass="three" onchange="changeComCode();">
              <html:options collection="scheduleCenterList" property="comCode" labelProperty="comCName"/>          
          </html:select> 
              <input type=hidden name="prpLscheduleCompanyComName" title="������������"  class="readonly" readonly="true"  value="<bean:write name='prpLscheduleCompanyDto' property='comName' filter='true' />">
       
          </td>
      <%}else{%>    
        <td class="title" style="width:15%">�������Ĵ���:</td>
        <td class="input" style="width:37%" >
     
           <input type=text name="comCode" title="�������Ĵ���" maxlength="22" class="readonly" readonly="true"  value="<bean:write name='prpLscheduleCompanyDto' property='comCode' filter='true' />">
    
        </td>
       <td class="title" style="width:15%">������������:</td>
        <td class="input" style="width:37%" >
           <input type=text name="prpLscheduleCompanyComName" title="������������"  class="readonly" readonly="true"  value="<bean:write name='prpLscheduleCompanyDto' property='comName' filter='true' />">
         </td>
         
            <%}%> 
      </tr>
      <tr>
        <td class="title">��˾�ϰ�ʱ��:</td>
        <td class="input">
          <input type="text" class=input name="prpLscheduleCompanyOnDutyTime" maxlength="8"  onkeypress='return pressIntegerCopy2(event)' onblur="return formatTime(event, this);" value="<bean:write name='prpLscheduleCompanyDto' property='onDutyTime' />">    
        </td>
        
        <td class="title">��˾�°�ʱ��:</td>
        <td class="input">
            <input type="text" class=input  name="prpLscheduleCompanyOffDutyTime"  maxlength="8" onkeypress='return pressIntegerCopy2(event)' onblur="return formatTime(event, this);" value="<bean:write name='prpLscheduleCompanyDto' property='offDutyTime' />">		 		
				
        </td>        
      </tr>
      
      <tr>
        <td class="title">������Ա24Сʱֵ��:</td>
        <td class="input" >
          <html:radio name="prpLscheduleCompanyDto" property="validStatus" value="1">��</html:radio>
          <html:radio name="prpLscheduleCompanyDto" property="validStatus" value="0">��</html:radio>
       	
   </td>        
      
      <td class="title" style="width:15%" style="valign:bottom" >�̶��绰:</td> 
      <td class="input" style="width:20%">
          <input type="text" class=input name="prpLscheduleCompanyPhoneNo"  maxlength="100" value="<bean:write name='prpLscheduleCompanyDto' property='phoneNo' />">		 		
			</td>
      </tr>
      
      <!--
         modify by ww add start 2005-11-07
         reason:�ͻ��������AM�ʺš�
      -->
      <tr>
          <td class="title">AM�ʺ�:</td>
          <td class="input" colspan="3">
              <input type="text" class="input" name="prpLscheduleCompanyAmNo"  maxlength="254" value="<bean:write name='prpLscheduleCompanyDto' property='amNo' />"  onkeypress='return pressIntegerCopy2(event)'>
          </td>
      </tr>
      <!--modify by ww add end 2005-11-07-->
      
      <tr>
       <td class="title" >��ʾ��Ϣ:</td>
       <td class="input" colspan="3">
       <input type="text" class=input name="prpLscheduleCompanyPromptContent" maxlength="254" value="<bean:write name='prpLscheduleCompanyDto' property='promptContent' />">		 		
				  
        </td>
        
     
      </tr>
    </table>