<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
	<tr>
	   <td width="30%"> 
	     <table width="100%" border="0" cellpadding="0" cellspacing="0">
	       <tr> 
	          <td width ="12"><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
	          <td class="formtitle">查勘调度处理</td>
	          <td width ="11"><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
	        </tr>
	      </table>
	   </td>
	   <td width="70%" align="right"><font color="#666666">
            <!-- Modify By wangli add begin 20050328-->
	     <input type="button" name="message" value="讨论留言" onClick="openWinSave(fm.prpLscheduleMainWFRegistNo.value,fm.prpLscheduleMainWFPolicyNo.value,fm.prpLscheduleMainWFRiskCode.value,'sched','');">
	     <input type="button" name="messageView" value="查看留言" onClick="openWinQuery('registNo',fm.prpLscheduleMainWFRegistNo.value);">　
	   <%--
	     <input type="button" name="message" value="讨论留言" onClick="openWinSave()">
	     <input type="button" name="messageView" value="查看留言" onClick="openWinQuery()">　
	    --%> 
	      <!-- Modify By wangli add end 20050328--> 
	            <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
          <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
  　      <input type="hidden" name="prpLscheduleMainWFScheduleFlag" value="1">
       </font></td>
	</tr>
	</table>
    
    <table  border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" style="width:100%">
     
      <tr>        
        <td class="title" style="width:16%"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" style="width:34%" >
           <input type=text name="prpLscheduleMainWFRegistNo" title="报案号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='registNo' />" >
           <input type="hidden" name="prpLscheduleMainWFScheduleID" title="调度号" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID' />" >
           <%--Modify By sunhao 2004-08-29--%> 
           <input type="hidden" name="prpLscheduleMainWFRiskCode"  value="<bean:write name='prpLscheduleMainWFDto' property='riskCode'/>">
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
            
        <%-- modify by wangli add 20050416 start --%> 
     	  <tr>
        <td class="title">代理人代码:</td>
        <td class="input">
          <input type=text name="prpLregistAgentCode" title="代理人代码" class="readonly" readonly="true"   maxlength="12" style="width:120px" value="<bean:write name='prpLscheduleMainWFDto' property='agentCode' />" >
        </td>
        <td class="title">代理人名称:</td>
        <td class="input">
          <input type=text name="prpLregistAgentName" title="代理人名称" class="readonly" readonly="true"  style="width:120px" value="<bean:write name='prpLscheduleMainWFDto' property='agentName' />" >
        </td>    
      </tr> 
       <%-- modify by wangli add 20050416 end --%> 
       
      <tr>  
      
        <td class="title" >理赔处理机构:</td>
        <td class="input" >
       <input name="prpLscheduleMainWFClaimComCode" class="readonly" readonly style="width:60px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode' />" ><input name="prpLscheduleMainWFComName" class="readonly" readonly style="width:150px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComName' />" >        	
        </td>
      
        <td class="title" >操作员:</td>
        <td class="input" >
         <!-- <input class="readonly" readonly name="OperatorName" >-->                
          <input class="readonly" readonly name="prpLscheduleMainWFOperatorCode"  type=hidden value="<bean:write name='prpLscheduleMainWFDto' property='operatorCode' />"><input class="readonly" readonly name="prpLscheduleMainWFOperatorName"  value="<bean:write name='prpLscheduleMainWFDto' property='operatorName' />">
        </td>        
      </tr>
      <tr>  
        <td class="title" >估计赔偿金额:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLregistEstimateLoss"  value="<bean:write name='prpLscheduleMainWFDto' property='estimateLoss' />" >
        </td>
      
        <td class="title" >查勘估计赔偿金额:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLcheckloss" value="" >
        </td>        
      </tr>  
       <tr> 
      <td class="title">调度时间:</td>
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFInputDate" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputDate' />" >日
          <input class="readonly" readonly name="prpLscheduleInputHour" style="width:25px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputHour' />">时
          <input class="readonly" readonly name="prpLscheduleInputMinute" style="width:25px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputMinute' />">分          
        </td>
      
        <td class="title">调度次数:</td>
        
        <td class="input" >
         <input class="readonly" readonly name="prpLscheduleMainWFSurveyNo" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='surveyNo' />" >
        </td>
        
      </tr>
      <tr>
       <td class="title" >出险情况:</td>
        <td class="input"  colspan=3>     
       <textarea style="wrap:hard" rows="15" cols="80" name="prpLscheduleMainWFRegistText"><bean:write name="prpLscheduleMainWFDto" property="registText"/></textarea>              
       </td>
      </tr> 
     <tr>
      <td class="title" style="width:11%">号牌号码:</td>
                <td class="input" style="width:20%" style="valign:bottom" >
                     <input name="prpLscheduleMainWFLicenseNo" class="input" style="width:98%" maxlength=20 description="号牌号码"  value="<bean:write name='prpLscheduleMainWFDto' property='licenseNo'/>">
                </td>
                
                      <td class="title" style="width:11%">查勘处理单位:</td>
                 <td class="input" >
                 <input type=text class="codecode" name="prpLscheduleMainWFScheduleObjectID"  style="width:20%" title="具体单位" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ScheduleObject');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject');"
                    onblur= "code_CodeChange(this, 'ScheduleObject');">
                 <input type=text class="codecode" name="prpLscheduleMainWFScheduleObjectName"  title="具体单位" style="width:50%" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ScheduleObject','-1','always','none','post');"
                    onkeyup= "code_CodeSelect(this, 'ScheduleObject','-1','always','none','post');"
                    onblur= "code_CodeChange(this, 'ScheduleObject','-1','always','none','post');">
                 <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
                 <img src="/claim/images/bgMarkMustInput.jpg">
                 </tr>
              
             <tr>   
                 <td class="title" >查勘地址:</td>
                 <td class="input" colspan=3>
                    <input  class="input" name="prpLscheduleMainWFCheckSite" style="width:90%" value="<bean:write name='prpLscheduleMainWFDto' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">
                 </td>
                                
             </tr>
           
              <tr>
                <td class="title" >调度信息:</td>
          <td class="input" colspan=3>
              <input  class="input" name="prpLscheduleMainWFCheckInfo" style="width:90%"   value="<bean:write name='prpLscheduleMainWFDto' property='checkInfo'/>">  
              <input  type=hidden name="prpLscheduleMainWFScheduleType" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleType'/>">
              <input  type=hidden name="prpLscheduleMainWFFlag" value="<bean:write name='prpLscheduleMainWFDto' property='flag'/>">
              <input  type=hidden name="scheduleType" value="sched">
          </td>
          
                </tr>
                
                <%//选择下一个节点用的%>
<logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
<input type="hidden" name="nextHandlerName" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerName'/>">
<input type="hidden" name="nextHandlerCode" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerCode'/>">
<input type="hidden" name="nextNodeNo" value="<bean:write name='prpLscheduleMainWFDto' property='nextNodeNo'/>">
</logic:equal>
                
                 <logic:notEqual name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
                 <tr>
                 <td class="title" style="width:11%">经办人:</td>
                 <td class="input" colspan=3>
                 <!--提交的对象和内容
                 <select name="nextNodeNo" style="width:80px">
                    <option value="check">	查勘</option>	
                   <select>     
-->
                   <input type=text name="nextHandlerCode" class="codecode"  style="width:100px" maxlength="10" title="操作员" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerCode'/>"
             ondblclick="code_CodeSelect(this, 'HanderCode');"
             onkeyup= "code_CodeSelect(this, 'HanderCode');">
        <input type=text name="nextHandlerName" class="codecode" style="width:80px" title="操作员" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerName'/>"
             ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');">
                  </td>

                  </tr>
               </logic:notEqual>
      
    </table>      

</table>

