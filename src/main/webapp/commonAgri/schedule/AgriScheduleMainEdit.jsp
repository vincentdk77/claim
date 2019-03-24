
<%
	//add by liyanjie 2005-12-06 start
	String checkedCommiFlag = "";			//双代标识是否已选择
	String disabledCommiFlag = "disabled";			//双代标识是否为只读的
	//add by liyanjie 2005-12-06 end
%>

<script language="javascript">
  <%--案件双代标志--%>
  function checkCommiFlag()
  {
    if(fm.CheckBoxCommiFlag.checked="true"){
    	if(!confirm('选择双代案件后,将全部清空下面查勘定损的调度内容,您确定要对此案件进行双代处理吗？')){ 
         return false;
      }
    		
    } 
    
  }
  
</script> 
<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
	<tr>
	     <input type="button" class=bigbutton name="message" value="理赔沟通" onClick="openWinSaveQuery(fm.prpLscheduleMainWFRegistNo.value,fm.prpLscheduleMainWFPolicyNo.value,fm.prpLscheduleMainWFRiskCode.value,'sched','','registNo',fm.prpLscheduleMainWFRegistNo.value);">
	     <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
       <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
       <input type="hidden" name="prpLscheduleMainWFScheduleType" class="common" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleType'/>">
       <input type="hidden" name="clauseType"  value="<bean:write name='prpLregistDto' property='clauseType' filter='true' />">
	     <input type="hidden" name="provinceCode" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode' />">
	     <input type="hidden" name="selectcomcode" value="">
  
	</tr>
</table>
	
  <table class=common cellpadding="5" cellspacing="1">
  	  <tr>
	      <%String strtitleTemp="";%>
	      <% if ("GETBACKEDIT".equals(saveType1)) strtitleTemp="改派"; %>
	      
	      
	      
	      <%
       // 从session里取扶贫/大户标志
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td colspan=4 class="formtitle">规模经营主体系统调度<%=strtitleTemp%>处理</td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td colspan=4 class="formtitle">扶贫系统调度<%=strtitleTemp%>处理</td><% 
			} else {
				%> <td colspan=4 class="formtitle">调度<%=strtitleTemp%>处理</td><% 
			}
		} else {
			%> <td colspan=4 class="formtitle">调度<%=strtitleTemp%>处理</td><% 
		}
      %>
      
      
      
	    </tr>
	        <input type="hidden" class="red1" readonly name="prplRegistFlag" value="" >
        <tr>        
        <td class="title" style="width:20%"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" style="width:30%" >
           <input type=text name="prpLscheduleMainWFRegistNo" title="报案号" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='registNo' />" >           
           <input type="hidden" name="prpLscheduleMainWFScheduleID" title="调度号" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID' />" > 
           <%--Modify By sunhao 2004-08-29--%> 
           <input type="hidden" name="prpLscheduleMainWFRiskCode"  value="<%=request.getParameter("riskCode")%>">
        </td>
        <td class="title" style="width:20%;valign:bottom" >保单号:</td>
        <td class="input" style="width:30%;valign:middle">
          <input type=text name="prpLscheduleMainWFPolicyNo" title="保单号" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLscheduleMainWFDto' property='policyNo' />" >           
            <!-- Modify By liujianbo add begin 20051024-->
            <!-- resson: 200508-036 调度平台可查看当前最新保单及报案信息 -->
          <input alt="点击此按钮可获得保单相关信息" type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLscheduleMainWFPolicyNo.value);return false;">          
            <!-- Modify By liujianbo add end 20051024-->
        </td>
      </tr> 
     
     <%
       // 从session里取扶贫/大户标志
		strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <tr>
      <td class="title">保单投保方式:</td>
      <td class="input">个体投保-----规模经营主体</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <tr>
      <td class="title">保单投保方式:</td>
      <td class="input">团体投保-----特困农户</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} 
		} 
      %>
      
      
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
      
        <td class="title" >调度员:</td>
        <td class="input" >
         <!-- <input class="readonly" readonly name="OperatorName" >-->                
          <input class="readonly" readonly name="prpLscheduleMainWFOperatorCode"  type=hidden value="<bean:write name='prpLscheduleMainWFDto' property='operatorCode' />"><input class="readonly" readonly name="prpLscheduleMainWFOperatorName"  value="<bean:write name='prpLscheduleMainWFDto' property='operatorName' />">
        </td>        
      </tr>
      <tr>  
        <td class="title" >报损金额CNY:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLregistEstimateLoss"  value="<bean:write name='prpLscheduleMainWFDto' format="0.00" property='estimateLoss' />" >
        </td>
      
        <td class="title" style="display:none">报损费用CNY:</td>
        <td class="input" style="display:none" >
          <input class="readonly" readonly name="prpLcheckloss" value="<bean:write name='prpLscheduleMainWFDto' property='estimateFee' />" >
        </td>  
     
      </tr>  
           
      <tr> 
      <td class="title">调度时间:</td> 
        <td class="input" >
                <input class="input"  name="prpLscheduleMainWFInputDate" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputDate' />" >日
          <input class="input"  name="prpLscheduleInputHour" style="width:25px" maxlength="2" value="<bean:write name='prpLscheduleMainWFDto' property='inputHour' />"
          		onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >时
          <input class="input"  name="prpLscheduleInputMinute" style="width:25px" maxlength="2" value="<bean:write name='prpLscheduleMainWFDto' property='inputMinute' />"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >分                    
   </td>
      
        <td class="title">调度次数:</td>
             
        <td class="input" >
        <!--modify by wangwei add start 2005-06-06-->
        <!--原因：次数大于1时将次数颜色变红色-->
        <logic:greaterThan  name='prpLscheduleMainWFDto' property='surveyNo' value="1">
        <font color=red>
        <bean:write name='prpLscheduleMainWFDto' property='surveyNo' />
        </font>
        </logic:greaterThan>
        
        <logic:lessEqual  name='prpLscheduleMainWFDto' property='surveyNo' value="1">
        <bean:write name='prpLscheduleMainWFDto' property='surveyNo' />
        </logic:lessEqual>
        
         <input type=hidden hclass="readonly" readonly name="prpLscheduleMainWFSurveyNo" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='surveyNo' />" >
         
         <!--modify by wangwei add end 2005-06-04-->
        </td>
        
      </tr>
      <tr>
       <td class="title" >出险情况:</td>
        <td class="input"  colspan=3>     
       <textarea style="wrap:hard" rows="10" cols="60" name="prpLscheduleMainWFRegistText"><bean:write name="prpLscheduleMainWFDto" property="registText"/></textarea>              
       </td>
      </tr>  
                
                 <logic:notEqual name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
               </logic:notEqual>
               
        <input type="hidden" name="prpLscheduleMainWFDtoCommiFlag" value="<bean:write name='prpLscheduleMainWFDto' property='commiFlag' filter='true' />">
        <input type="hidden" name="prpLregistDamageStartDate" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />">
          <input type="hidden" name="prpLregistDamageStartHour" value="<bean:write name='prpLregistDto' property='damageStartHour' filter='true' />">
          <input type="hidden" name="prpLregistDamageStartMinute"  value="<bean:write name='prpLregistDto' property='damageStartMinute' filter='true' />">
        
          <input type="hidden" name="prpLregistReportDate"  value="<bean:write name='prpLregistDto' property='reportDate' filter='true' />">
          <input type="hidden" name="prpLregistReportHour"  value="<bean:write name='prpLregistDto' property='reportHour' filter='true' />">
          <input type="hidden" name="prpLregistReportMinute" value="<bean:write name='prpLregistDto' property='reportMinute' filter='true' />">

      
    </table>      

