  
     <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
       <tr><td class="formtitle" colspan="4">������ȱ�Ĺ���</td></tr>
       <tr>        
        <td class="title" style="width:16%"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" style="width:34%" >
           <input type=text name=prpLscheduleMainWFRegistNo title="������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLregistDto' property='registNo' />" >
           <input type=hidden name=prpLscheduleMainWFScheduleID value="1" >
           <input type=hidden name=scheduleType value="sched">
           <input type=hidden name=status value="2">
         </td>
        <td class="title" style="width:14%;valign:bottom" >������:</td>
        <td class="input" style="width:36%;valign:middle">
          <input type=text title="������" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLregistDto' property='policyNo' />" >
        </td>
      </tr>
     
      <tr>
      
        <td class="title">��ϵ������:</td>
        <td class="input" >
          <input class="readonly" readonly value="<bean:write name='prpLregistDto' property='linkerName' />" >
        </td>
        
        <td class="title">��ϵ�绰:</td>
        <td class="input" >
          <input class="readonly" readonly value="<bean:write name='prpLregistDto' property='phoneNumber' />" >
       </td>
      </tr>
      
    
      <tr>  
      
        <td class="title" >��������:</td>
        <td class="input" colspan=3 >
       <input  class="readonly" readonly style="width:60px" value="<bean:write name='prpLregistDto' property='insuredName' />" >        	
        </td>
      
       </tr> 
       
        <tr>  
      
        <td class="title" >���յص�:</td>
        <td class="input" colspan=3 >
       <input  name="prplregistDamageAddress" class="readonly" readonly style="width:60px" value="<bean:write name='prpLregistDto' property='damageAddress' />" >        	
        </td>
      
       </tr> 
    </table>      

</table>