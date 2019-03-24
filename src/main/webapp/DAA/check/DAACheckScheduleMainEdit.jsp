<!--modify by wuxiaodong  20050907      reasion 增加代码选择的onchange事件，同时支持名称与代码的相互选择
-->
<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">查勘处理</td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td width="70%" align="right"><font color="#666666">　</font></td>
	</tr>
	</table>
    
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
     
      <tr>        
        <td class="title" style="width:16%"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" style="width:34%" >
           <input type=text name="prpLscheduleMainWFRegistNo" title="报案号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='registNo' />" >
        </td>
        <td class="title" style="width:14%;valign:bottom" >保单号:</td>
        <td class="input" style="width:36%;valign:middle">
          <input type=text name="prpLscheduleMainWFPolicyNo" title="保单号" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLscheduleMainWFDto' property='policyNo' />" >
        </td>
      </tr>
     
      <tr>
      
        <td class="title">联系人姓名:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLscheduleMainWFLinkerName" value="<bean:write name='prpLscheduleMainWFDto' property='linkerName' />" >
        </td>
        
        <td class="title">联系电话:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLscheduleMainWFPhoneNumber"   value="<bean:write name='prpLscheduleMainWFDto' property='phoneNumber' />" >
       </td>
      </tr>
      <tr>  
      
        <td class="title" >理赔处理机构:</td>
        <td class="input" >
       <input name="prpLscheduleMainWFClaimComCode" class="readonly" readonly style="width:60px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode' />" ><input name="prpLscheduleMainWFComName" class="readonly" readonly style="width:150px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComName' />" >        	
        </td>
      
        <td class="title" >调度操作员:</td>
        <td class="input" >
         <!-- <input class="readonly" readonly name="OperatorName" >-->                
          <input class="readonly" readonly name="prpLscheduleMainWFOperatorCode"  type=hidden value="<bean:write name='prpLscheduleMainWFDto' property='operatorCode' />"><input class="readonly" readonly name="prpLscheduleMainWFOperatorName"  value="<bean:write name='prpLscheduleMainWFDto' property='operatorName' />">
        </td>        
      </tr>  
       <tr> 
      <td class="title">查勘时间:</td>
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFInputDate" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputDate' />" >日
          <input class="readonly" readonly name="prpLscheduleInputHour" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputHour' />">时
        </td>
      
        <td class="title">调度号:</td>
        
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFScheduleID" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID' />" >
        </td>
        
      </tr>
      
     <tr> 
      <td class="title">调度对象:</td>
        <td class="input" >
          <input type=text readonly class="readonly" name="prpLcheckItemScheduleObjectID"  style="width:20%" title="具体单位" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ScheduleObject');"
                    onchange="code_CodeChange(this, 'ScheduleObject');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject');"
                    onblur= "code_CodeChange(this, 'ScheduleObject');">
                 <input type=text readonly class="readonly" name="prpLcheckItemScheduleObjectName"  title="具体单位" style="width:50%" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ScheduleObject','-1','naem','none','post');"
                    onchange="code_CodeChange(this, 'ScheduleObject','-1','naem','none','post');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject','-1','naem','none','post');"
                    onblur= "code_CodeChange(this, 'ScheduleObject','-1','naem','none','post');">
        </td>
      
        <td class="title">查勘操作员:</td>
        
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFCheckOperatorCode" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='checkOperatorCode' />" >
        </td>
        
      </tr>
      
      <tr>
       <td class="title" >出险情况:</td>
        <td class="input"  colspan=3>  
          <textarea style="wrap:hard" rows="15" cols="80" name="prpLscheduleMainWFRegistText"><bean:write name="prpLscheduleMainWFDto" property="registText"/></textarea>                              
       </td> 
      </tr> 
      <tr>
       <td class="title" >案件状态:</td>
       <td class="input" >
             <select name="prpLscheduleMainWFCheckFlag" class="common" style="width:98%" value="<bean:write name='prpLscheduleMainWFDto' property='checkFlag'/>">>
                      <option value=1>需等待            </option> 
                      <option value=2>正在处理              </option> 
                      <option value=3>案件已完成          </option> 
                      <option value=4>需要重新调度本案件 </option> 
                      <option value=5>需要另行调度        </option> 
                      <option value=6>查勘结束已提交定损  </option> 
               </select>
        </td>      
        <td class="title" >查勘信息:</td>      
        <td class="input"  ><textarea  rows="4" cols="80" style="wrap:hard" name="prpLscheduleMainWFCheckInfo"><bean:write name="prpLscheduleMainWFDto" property="checkInfo"/>
          </textarea>
       
       </td>
      </tr> 
      
    </table>      
</table>
       