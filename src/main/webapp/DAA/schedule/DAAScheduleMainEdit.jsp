<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>
<%
	//add by liyanjie 2005-12-06 start
	String checkedCommiFlag = "";			//˫����ʶ�Ƿ���ѡ��
	String disabledCommiFlag = "disabled";			//˫����ʶ�Ƿ�Ϊֻ����
	//add by liyanjie 2005-12-06 end
	UserDto   userDto = (UserDto)session.getAttribute("user");
    boolean isShowButton = true;
    //�û�û�õ�¼����ϵͳʱ������ʾ��ذ�ť(��Ҫ��˫��ϵͳ������������ͼ�����)
    if(userDto == null){
           isShowButton = false;
    }
%>

<script language="javascript">
  <%--����˫����־--%>
  function checkCommiFlag()
  {
    if(fm.CheckBoxCommiFlag.checked="true"){
    	if(!confirm('ѡ��˫��������,��ȫ���������鿱����ĵ�������,��ȷ��Ҫ�Դ˰�������˫��������')){ 
         return false;
      }
    		
    } 
    
  }
  
</script> 
<table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
	<tr>
<%if(isShowButton){ %>		
	   <input type="button" class=bigbutton name="message" value="���⹵ͨ" onClick="openWinSaveQuery(fm.prpLscheduleMainWFRegistNo.value,fm.prpLscheduleMainWFPolicyNo.value,fm.prpLscheduleMainWFRiskCode.value,'sched','','registNo',fm.prpLscheduleMainWFRegistNo.value);">   
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
	      <% if ("GETBACKEDIT".equals(saveType1)) strtitleTemp="����"; %>
	      <td colspan=4 class="formtitle">����<%=strtitleTemp%>����</td>
	    </tr>
	        <input type="hidden" class="red1" readonly name="prplRegistFlag" value="" >
        <tr>        
        <td class="title" style="width:20%"><bean:message key="db.prpLclaim.registNo" />:</td>
        <td class="input" style="width:30%" >
           <input type=text name="prpLscheduleMainWFRegistNo" title="������" maxlength="22" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='registNo' />" >           
           <input type="hidden" name="prpLscheduleMainWFScheduleID" title="���Ⱥ�" class="readonly" readonly="true" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID' />" > 
           <%--Modify By sunhao 2004-08-29--%> 
           <input type="hidden" name="prpLscheduleMainWFRiskCode"  value="<%=request.getParameter("riskCode")%>">
        </td>
        <td class="title" style="width:20%;valign:bottom" >������:</td>
        <td class="input" style="width:30%;valign:middle">
          <input type=text name="prpLscheduleMainWFPolicyNo" title="������" class="readonly" readonly="true"  style="width:140px" value="<bean:write name='prpLscheduleMainWFDto' property='policyNo' />" >           
            <!-- Modify By liujianbo add begin 20051024-->
            <!-- resson: 200508-036 ����ƽ̨�ɲ鿴��ǰ���±�����������Ϣ -->
          <input alt="����˰�ť�ɻ�ñ��������Ϣ" type="image" name="btRelate" src="/claim/images/butRelate.gif" align="middle" width="54" height="17" border="0" onclick="relate(fm.prpLscheduleMainWFPolicyNo.value);return false;">          
            <!-- Modify By liujianbo add end 20051024-->
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
            
        <%-- modify by wangli add 20050416 start --%> 
     	  <tr>
        <td class="title">�����˴���:</td>
        <td class="input">
          <input type=text name="prpLregistAgentCode" title="�����˴���" class="readonly" readonly="true"   maxlength="12" style="width:120px" value="<bean:write name='prpLscheduleMainWFDto' property='agentCode' />" >
        </td>
        <td class="title">����������:</td>
        <td class="input">
          <input type=text name="prpLregistAgentName" title="����������" class="readonly" readonly="true"  style="width:120px" value="<bean:write name='prpLscheduleMainWFDto' property='agentName' />" >
        </td>    
      </tr> 
       <%-- modify by wangli add 20050416 end --%> 
       
      <tr>  
      
        <td class="title" >���⴦�����:</td>
        <td class="input" >
       <input name="prpLscheduleMainWFClaimComCode" class="readonly" readonly style="width:60px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode' />" ><input name="prpLscheduleMainWFComName" class="readonly" readonly style="width:150px" value="<bean:write name='prpLscheduleMainWFDto' property='claimComName' />" >        	
        </td>
      
        <td class="title" >����Ա:</td>
        <td class="input" >
         <!-- <input class="readonly" readonly name="OperatorName" >-->                
          <input class="readonly" readonly name="prpLscheduleMainWFOperatorCode"  type=hidden value="<bean:write name='prpLscheduleMainWFDto' property='operatorCode' />"><input class="readonly" readonly name="prpLscheduleMainWFOperatorName"  value="<bean:write name='prpLscheduleMainWFDto' property='operatorName' />">
        </td>        
      </tr>
      <tr>  
        <td class="title" >������CNY:</td>
        <td class="input" >
          <input class="readonly" readonly name="prpLregistEstimateLoss"  value="<bean:write name='prpLscheduleMainWFDto' property='estimateLoss' />" >
        </td>
      
        <td class="title" style="display:none">�������CNY:</td>
        <td class="input" style="display:none" >
          <input class="readonly" readonly name="prpLcheckloss" value="<bean:write name='prpLscheduleMainWFDto' property='estimateFee' />" >
        </td>  
        
        
                <% 
            //add by zhaolu start at 2006-6-10
            //reason:ǿ����ʾ
             if(request.getAttribute("prpLregistRPolicyNo")!= null)
             {
            
            %>
           
            <td class="title" >ǿ�Ʊ�������:</td>
            <td class="input"  >
              <input type="text" name="prpLRegistRPolicyNo" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLregistRPolicyNo' property='policyNo'/>">
              <!--<input type=button class="bigbutton"  name="policyBackWard" value="ǿ�Ʊ�����Ϣ" onclick="relateBeforePolicyNo('<bean:write name='prpLregistRPolicyNo' property='policyNo'/>','<bean:write name='prpLregistRPolicyNo' property='riskCode'/>',fm.prpLscheduleMainWFInputDate.value);">-->
           </td>  
         
            <%
            }
            //add by zhaolu end at 2006-6-10
            %>       
      </tr>  
           
      <tr> 
      <td class="title">����ʱ��:</td> 
        <td class="input" >
                <input class="readonly" readonly name="prpLscheduleMainWFInputDate" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputDate' />" >��
          <input class="readonly" readonly name="prpLscheduleInputHour" style="width:25px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputHour' />">ʱ
          <input class="readonly" readonly name="prpLscheduleInputMinute" style="width:25px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputMinute' />">��                    
   </td>
      
        <td class="title">���ȴ���:</td>
             
        <td class="input" >
        <!--modify by wangwei add start 2005-06-06-->
        <!--ԭ�򣺴�������1ʱ��������ɫ���ɫ-->
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
       <td class="title" >�������:</td>
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

