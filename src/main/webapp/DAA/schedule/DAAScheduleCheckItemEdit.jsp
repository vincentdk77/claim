<%--
****************************************************************************
* DESC       ���鿱���ȱ�Ĵ���ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2006-06-29
* MODIFYLIST ��   Name       Date            Reason/Contents
                
****************************************************************************
--%>
    <% 
    //�ж��ǲ����Ѿ������ȹ���  
    String haveCheck1disable=""; //�ж��Ƿ��Ѿ����ȹ��ˡ�
    String haveCheck1=""; //�ж��Ƿ�ѡ���ˡ�
    String  ifreadonly1=""; //Ĭ�ϲ���ֻ����
    String getBackDisp1="";
    %>

    <logic:equal name="prpLscheduleMainWFDto"  property="scheduleFlag" value="1">
    <% 
       haveCheck1disable="disabled"; //�ж��Ƿ��Ѿ����ȹ���
       haveCheck1="checked"; 
       hasSchedFlag = true;    //add by liyanjie 2005-12-14
   
      if (!"GETBACKEDIT".equals(saveType1)) { 
          //�жϲ��Ǹ��ɣ��Ų������޸ĵ�
          ifreadonly1="readonly"; //Ĭ�ϲ���ֻ����
        } else { 
          getBackDisp1="(�ɸ���)";
        }
    %>
    </logic:equal>
    <script type="text/javascript">
	function linkJobManager(){
		fm.nextHandlerCode1.value="";
		fm.nextHandlerName1.value="";
		var classCode = '${prpLscheduleMainWFDto.policyNo}'.substring(1,3);
  		var comCode = fm.prpLscheduleMainWFScheduleObjectID.value;
  		if(comCode == "" || comCode == null){
  			alert("��ѡ��鿱������");
  			return false();
  		}
  		var myDate = new Date();
  		var newDate = myDate.getMilliseconds();    //��ȡ��ǰ������(0-999)
  		var url="jobManagerQuery.do?editType=LINK&systemCode=claim&comCode="+comCode+"&scheduleType=Main&classCode="+classCode+"&newDate="+newDate;
		window.showModalDialog(url,window,'dialogHeight:600px;dialogWidth:800px');
    }
    
    	function queryJobManager(){
    		var handledept = fm.prpLscheduleMainWFScheduleObjectID.value;
    		var deptname = fm.prpLscheduleMainWFScheduleObjectName.value;
    		var riskCode = '${prpLscheduleMainWFDto.riskCode}';
    		var url="/claim/common/schedule/ScheduleJobManagerEdit.jsp?editType=SchedSHOW&handledept="+handledept+"&deptname="+deptname+"&riskCode="+riskCode;
			window.showModalDialog(url,window,'dialogHeight:600px;dialogWidth:800px');
			
    	}
	</script>
    
    <table class=common cellpadding="5" cellspacing="1">
    
      <tr>
	      <td colspan=5 class="formtitle">�鿱����<%=strtitleTemp%>����</td>
	    </tr>
                <td class="title" style="width:14%" rowspan="5"> 
                 <div align="center">
                <input type="checkbox"  name="checkScheduleCheckYesNo" class="readonly" style="width:20px" value="ON" <%=haveCheck1%> <%=haveCheck1disable%>>&nbsp;���:<bean:write name='prpLscheduleMainWFDto' property='licenseNo'/><%=getBackDisp1%>
                  </div>
                 <input  type=hidden name="checkSelectSend" value="0">
                 <input type="hidden" name="prpLscheduleMainWFLicenseNo" class="readonly" readonly style="width:98%" maxlength=20 description="���ƺ���"  value="<bean:write name='prpLscheduleMainWFDto' property='licenseNo'/>">
                 
                <!--	 <input type="checkbox"  name="txtCheckSmcSend" class="readonly" style="width:20px"  >&nbsp;���Ͷ���-->
                 </td>
                 
                 <td class="title" style="width:15%">�鿱����λ:</td>
                 <td class="input" >
                 <input type=hidden class="codecode" name="prpLscheduleMainWFScheduleObjectID"  num=-1 style="width:20%" title="���嵥λ" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />"
                   <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")) {%>
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                    
                    <%}%>
                   >
                 <input type=text class="codecode" name="prpLscheduleMainWFScheduleObjectName"  title="���嵥λ" style="width:50%" maxLength="50" description="�鿱����λ" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />"
                   <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")){%>
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    <%}%>
                    >
                 <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
                 <img src="/claim/images/bgMarkMustInput.jpg">
                 </tr>
              
             <tr>   
                 <td class="title" style="width:15%">�鿱��ַ:</td>
                 <td class="input" colspan=3>
                    <input  class="input" name="prpLscheduleMainWFCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="�鿱��ַ" value="<bean:write name='prpLscheduleMainWFDto' property='checkSite'/>" <%=ifreadonly1%>><img src="/claim/images/bgMarkMustInput.jpg">
                 </td>
                                
             </tr>
           
              <tr>
              <td class="title" style="width:15%">�鿱Ҫ����ʾ:</td>
          <td class="input" colspan=3>
              <input  class="input" name="prpLscheduleMainWFCheckInfo" style="width:90%"  maxLength="255" onblur="checkLength1(this);" description="�鿱Ҫ����ʾ"  value="<bean:write name='prpLscheduleMainWFDto' property='checkInfo'/>" <%=ifreadonly1%>>  
              <input  type=hidden name="prpLscheduleMainWFFlag" value="<bean:write name='prpLscheduleMainWFDto' property='flag'/>">
              <input  type=hidden name="prpLscheduleMainWFScheduleFlag" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleFlag'/>">
              <!-- add by liyanjie 2005-12-12 start-->
        	   <input  type=hidden name="checkCommiItemFlag" value="<bean:write name='prpLscheduleMainWFDto' property='commiItemFlag' filter='true' />">     
        	   <input  type=hidden name="prpLscheduleMainWFCheckClaimComCode" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode'/>">
        			<!-- add by liyanjie 2005-12-12 end-->
          </td>
          
                </tr>
                
                <%//ѡ����һ���ڵ��õ�%>

                 <tr>
                 <td class="title" style="width:15%">�鿱��Ա:</td>
                 <td class="input" colspan=3>
               <input type=text name="nextHandlerCode1" class="codecode"  style="width:100px" maxlength="10" title="����Ա" description="����Ա" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerCode'/>"
                  <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")){%>
                 onchange="setNewHandlerCode(this);"
                 ondblclick="code_CodeSelect(this, 'CheckPerson');"
                 onkeyup= "code_CodeSelect(this, 'CheckPerson');"
                 onblur="code_CodeChange(this, 'CheckPerson','1','code','post','clear');"
                 <%}%>
                 >
              <input type=text name="nextHandlerName1" class="codecode" style="width:80px"  title="����Ա" maxLength="30" description="����Ա" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerName'/>"
              <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")){%>
             ondblclick="code_CodeSelect(this, 'CheckPerson','-1','name','always','none','post');"
             onblur="code_CodeChange(this, 'CheckPerson','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'CheckPerson','-1','name','always','none','post');"
             <%}%>
             >
             <input type="button" class="middlebutton" name="jobManagerButton" value="���" onclick="linkJobManager();" <% if (ifreadonly1.equals("readonly")){%>disabled<%} %> >
  			 <input type="button" class="middlebutton" name="jobManagerButton" value="����ѯ" onclick="queryJobManager();" <% if (ifreadonly1.equals("readonly")){%>disabled<%} %> >
               </td>

                  </tr>
                  <tr>
                  <td class="title">�Ƿ��������:</td>
        <td class="input">
         <%
           if(!ifreadonly1.equals("readonly"))
           {
         %> 
          <html:radio   name="prpLscheduleMainWFDto" property="flag" value="1"/>��
          <html:radio   name="prpLscheduleMainWFDto" property="flag" value="0"/>��
         <%
           }
           else
           {
         %>
         <logic:equal name="prpLscheduleMainWFDto"  property="flag" value="1">
         	��
         </logic:equal>
         <logic:equal name="prpLscheduleMainWFDto"  property="flag" value="0">
         	��
         </logic:equal>
         <%
           }
         %>
        </td>
    </tr>
            
    </table>      
    
     <% if ("GETBACKEDIT".equals(saveType1)) { %>
              <input type=hidden name=maxrow value="0">
     <%}%>         
              

