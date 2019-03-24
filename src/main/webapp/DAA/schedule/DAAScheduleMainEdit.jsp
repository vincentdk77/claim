<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%
	//add by liyanjie 2005-12-06 start
	String checkedCommiFlag = "";			//双代标识是否已选择
	String disabledCommiFlag = "disabled";			//双代标识是否为只读的
	//add by liyanjie 2005-12-06 end
	UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //用户没用登录理赔系统时，不显示相关按钮(主要是双核系统访问理赔流程图的情况)
    if(userDto == null){
           isShowButton = false;
    }
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
<%if(isShowButton){ %>		
	   <input type="button" class=bigbutton name="message" value="理赔沟通" onClick="openWinSaveQuery(fm.prpLscheduleMainWFRegistNo.value,fm.prpLscheduleMainWFPolicyNo.value,fm.prpLscheduleMainWFRiskCode.value,'sched','','registNo',fm.prpLscheduleMainWFRegistNo.value);">   
<%} %>	   
	   <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
       <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
       <input type="hidden" name="prpLscheduleMainWFScheduleType" class="common" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleType'/>">
       <input type="hidden" name="clauseType"  value="<bean:write name='prpLregistDto' property='clauseType' filter='true' />">
       <input type="hidden" name="provinceCode" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode' />">
	     <input type="hidden" name="selectcomcode" value="">
       <input type="hidden" name="havePersonKind" value="<%=(String)request.getAttribute("havePersonKind") %>">
       <input type="hidden" name="haveThirdCarKind" value="<%=(String)request.getAttribute("haveThirdCarKind") %>">
       <input type="hidden" name="havePropKind" value="<%=(String)request.getAttribute("havePropKind") %>">
       <input type="hidden" name="haveCarKind" value="<%=(String)request.getAttribute("haveCarKind") %>">
	</tr>
</table>
	
  <table class=common cellpadding="5" cellspacing="1">
  	  <tr>
	      <%String strtitleTemp="";%>
	      <% if ("GETBACKEDIT".equals(saveType1)) strtitleTemp="改派"; %>
	      <td colspan=4 class="formtitle">调度<%=strtitleTemp%>处理</td>
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
          <input class="readonly" readonly name="prpLregistEstimateLoss"  value="<bean:write name='prpLscheduleMainWFDto' property='estimateLoss' />" >
        </td>
      
        <td class="title" style="display:none">报损费用CNY:</td>
        <td class="input" style="display:none" >
          <input class="readonly" readonly name="prpLcheckloss" value="<bean:write name='prpLscheduleMainWFDto' property='estimateFee' />" >
        </td>  
        
        
                <% 
            //add by zhaolu start at 2006-6-10
            //reason:强三显示
             if(request.getAttribute("prpLregistRPolicyNo")!= null)
             {
            
            %>
           
            <td class="title" >强制保单号码:</td>
            <td class="input"  >
              <input type="text" name="prpLRegistRPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistRPolicyNo' property='policyNo'/>">
              <!--<input type=button class="bigbutton"  name="policyBackWard" value="强制保单信息" onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>',fm.prpLscheduleMainWFInputDate.value);">-->
           </td>  
         
            <%
            }
            //add by zhaolu end at 2006-6-10
            %>       
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

