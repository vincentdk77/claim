<!--modify by wuxiaodong  20050907      reasion ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
-->
<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">�鿱����</td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td width="70%" align="right"><font color="#666666">��</font></td>
	</tr>
	</table>
    
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
     
      <tr>        
        <td class="title" style="width:16%"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" style="width:34%" >
           <input type=text name="prpLscheduleMainWFRegistNo" title="������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='registNo' />" >
        </td>
        <td class="title" style="width:14%;valign:bottom" >������:</td>
        <td class="input" style="width:36%;valign:middle">
          <input type=text name="prpLscheduleMainWFPolicyNo" title="������" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLscheduleMainWFDto' property='policyNo' />" >
        </td>
      </tr>
     
      <tr>
      
        <td class="title">��ϵ������:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLscheduleMainWFLinkerName" value="<bean:write name='prpLscheduleMainWFDto' property='linkerName' />" >
        </td>
        
        <td class="title">��ϵ�绰:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLscheduleMainWFPhoneNumber"   value="<bean:write name='prpLscheduleMainWFDto' property='phoneNumber' />" >
       </td>
      </tr>
      <tr>  
      
        <td class="title" >���⴦�����:</td>
        <td class="input" >
       <input name="prpLscheduleMainWFClaimComCode" class="readonly" readonly style="width:60px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode' />" ><input name="prpLscheduleMainWFComName" class="readonly" readonly style="width:150px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComName' />" >        	
        </td>
      
        <td class="title" >���Ȳ���Ա:</td>
        <td class="input" >
         <!-- <input class="readonly" readonly name="OperatorName" >-->                
          <input class="readonly" readonly name="prpLscheduleMainWFOperatorCode"  type=hidden value="<bean:write name='prpLscheduleMainWFDto' property='operatorCode' />"><input class="readonly" readonly name="prpLscheduleMainWFOperatorName"  value="<bean:write name='prpLscheduleMainWFDto' property='operatorName' />">
        </td>        
      </tr>  
       <tr> 
      <td class="title">�鿱ʱ��:</td>
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFInputDate" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputDate' />" >��
          <input class="readonly" readonly name="prpLscheduleInputHour" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputHour' />">ʱ
        </td>
      
        <td class="title">���Ⱥ�:</td>
        
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFScheduleID" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID' />" >
        </td>
        
      </tr>
      
     <tr> 
      <td class="title">���ȶ���:</td>
        <td class="input" >
          <input type=text readonly class="readonly" name="prpLcheckItemScheduleObjectID"  style="width:20%" title="���嵥λ" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ScheduleObject');"
                    onchange="code_CodeChange(this, 'ScheduleObject');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject');"
                    onblur= "code_CodeChange(this, 'ScheduleObject');">
                 <input type=text readonly class="readonly" name="prpLcheckItemScheduleObjectName"  title="���嵥λ" style="width:50%" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ScheduleObject','-1','naem','none','post');"
                    onchange="code_CodeChange(this, 'ScheduleObject','-1','naem','none','post');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject','-1','naem','none','post');"
                    onblur= "code_CodeChange(this, 'ScheduleObject','-1','naem','none','post');">
        </td>
      
        <td class="title">�鿱����Ա:</td>
        
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFCheckOperatorCode" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='checkOperatorCode' />" >
        </td>
        
      </tr>
      
      <tr>
       <td class="title" >�������:</td>
        <td class="input"  colspan=3>  
          <textarea style="wrap:hard" rows="15" cols="80" name="prpLscheduleMainWFRegistText"><bean:write name="prpLscheduleMainWFDto" property="registText"/></textarea>                              
       </td> 
      </tr> 
      <tr>
       <td class="title" >����״̬:</td>
       <td class="input" >
             <select name="prpLscheduleMainWFCheckFlag" class="common" style="width:98%" value="<bean:write name='prpLscheduleMainWFDto' property='checkFlag'/>">>
                      <option value=1>��ȴ�            </option> 
                      <option value=2>���ڴ���              </option> 
                      <option value=3>���������          </option> 
                      <option value=4>��Ҫ���µ��ȱ����� </option> 
                      <option value=5>��Ҫ���е���        </option> 
                      <option value=6>�鿱�������ύ����  </option> 
               </select>
        </td>      
        <td class="title" >�鿱��Ϣ:</td>      
        <td class="input"  ><textarea  rows="4" cols="80" style="wrap:hard" name="prpLscheduleMainWFCheckInfo"><bean:write name="prpLscheduleMainWFDto" property="checkInfo"/>
          </textarea>
       
       </td>
      </tr> 
      
    </table>      
</table>
       