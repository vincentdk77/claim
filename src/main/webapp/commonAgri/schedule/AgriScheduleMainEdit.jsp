
<%
	//add by liyanjie 2005-12-06 start
	String checkedCommiFlag = "";			//˫����ʶ�Ƿ���ѡ��
	String disabledCommiFlag = "disabled";			//˫����ʶ�Ƿ�Ϊֻ����
	//add by liyanjie 2005-12-06 end
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
	     <input type="button" class=bigbutton name="message" value="���⹵ͨ" onClick="openWinSaveQuery(fm.prpLscheduleMainWFRegistNo.value,fm.prpLscheduleMainWFPolicyNo.value,fm.prpLscheduleMainWFRiskCode.value,'sched','','registNo',fm.prpLscheduleMainWFRegistNo.value);">
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
	      <% if ("GETBACKEDIT".equals(saveType1)) strtitleTemp="����"; %>
	      
	      
	      
	      <%
       // ��session��ȡ��ƶ/�󻧱�־
		String strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <td colspan=4 class="formtitle">��ģ��Ӫ����ϵͳ����<%=strtitleTemp%>����</td><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <td colspan=4 class="formtitle">��ƶϵͳ����<%=strtitleTemp%>����</td><% 
			} else {
				%> <td colspan=4 class="formtitle">����<%=strtitleTemp%>����</td><% 
			}
		} else {
			%> <td colspan=4 class="formtitle">����<%=strtitleTemp%>����</td><% 
		}
      %>
      
      
      
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
     
     <%
       // ��session��ȡ��ƶ/�󻧱�־
		strHPflag = (String)session.getAttribute("flag");
		if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
			if(strHPflag.equals("Large")) {
				%> <tr>
      <td class="title">����Ͷ����ʽ:</td>
      <td class="input">����Ͷ��-----��ģ��Ӫ����</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} else if(strHPflag.equals("Retaol")) {
				%> <tr>
      <td class="title">����Ͷ����ʽ:</td>
      <td class="input">����Ͷ��-----����ũ��</td>
      <td class="title"></td>
      <td class="input"></td>
      </tr><% 
			} 
		} 
      %>
      
      
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
          <input class="readonly" readonly name="prpLregistEstimateLoss"  value="<bean:write name='prpLscheduleMainWFDto' format="0.00" property='estimateLoss' />" >
        </td>
      
        <td class="title" style="display:none">�������CNY:</td>
        <td class="input" style="display:none" >
          <input class="readonly" readonly name="prpLcheckloss" value="<bean:write name='prpLscheduleMainWFDto' property='estimateFee' />" >
        </td>  
     
      </tr>  
           
      <tr> 
      <td class="title">����ʱ��:</td> 
        <td class="input" >
                <input class="input"  name="prpLscheduleMainWFInputDate" style="width:75px"  value="<bean:write name='prpLscheduleMainWFDto' property='inputDate' />" >��
          <input class="input"  name="prpLscheduleInputHour" style="width:25px" maxlength="2" value="<bean:write name='prpLscheduleMainWFDto' property='inputHour' />"
          		onblur="checkHour(this);"
          		onKeyPress="pressInteger(event)" >ʱ
          <input class="input"  name="prpLscheduleInputMinute" style="width:25px" maxlength="2" value="<bean:write name='prpLscheduleMainWFDto' property='inputMinute' />"
          		onblur="checkMin(this);"
          		onKeyPress="pressInteger(event)" >��                    
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

