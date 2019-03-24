<%--
****************************************************************************
* DESC       ：查勘调度标的处理页面
* AUTHOR     ：lixiang
* CREATEDATE ：2006-06-29
* MODIFYLIST ：   Name       Date            Reason/Contents
                
****************************************************************************
--%>
    <% 
    //判断是不是已经被调度过了  
    String haveCheck1disable=""; //判断是否已经调度过了。
    String haveCheck1=""; //判断是否选过了。
    String  ifreadonly1=""; //默认不是只读的
    String getBackDisp1="";
    %>

    <logic:equal name="prpLscheduleMainWFDto"  property="scheduleFlag" value="1">
    <% 
       haveCheck1disable="disabled"; //判断是否已经调度过了
       haveCheck1="checked"; 
       hasSchedFlag = true;    //add by liyanjie 2005-12-14
   
      if (!"GETBACKEDIT".equals(saveType1)) { 
          //判断不是改派，才不可以修改的
          ifreadonly1="readonly"; //默认不是只读的
        } else { 
          getBackDisp1="(可改派)";
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
  			alert("请选择查勘机构。");
  			return false();
  		}
  		var myDate = new Date();
  		var newDate = myDate.getMilliseconds();    //获取当前毫秒数(0-999)
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
	      <td colspan=5 class="formtitle">查勘调度<%=strtitleTemp%>处理</td>
	    </tr>
                <td class="title" style="width:14%" rowspan="5"> 
                 <div align="center">
                <input type="checkbox"  name="checkScheduleCheckYesNo" class="readonly" style="width:20px" value="ON" <%=haveCheck1%> <%=haveCheck1disable%>>&nbsp;标的:<bean:write name='prpLscheduleMainWFDto' property='licenseNo'/><%=getBackDisp1%>
                  </div>
                 <input  type=hidden name="checkSelectSend" value="0">
                 <input type="hidden" name="prpLscheduleMainWFLicenseNo" class="readonly" readonly style="width:98%" maxlength=20 description="号牌号码"  value="<bean:write name='prpLscheduleMainWFDto' property='licenseNo'/>">
                 
                <!--	 <input type="checkbox"  name="txtCheckSmcSend" class="readonly" style="width:20px"  >&nbsp;发送短信-->
                 </td>
                 
                 <td class="title" style="width:15%">查勘处理单位:</td>
                 <td class="input" >
                 <input type=hidden class="codecode" name="prpLscheduleMainWFScheduleObjectID"  num=-1 style="width:20%" title="具体单位" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectID' filter='true' />"
                   <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")) {%>
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                    
                    <%}%>
                   >
                 <input type=text class="codecode" name="prpLscheduleMainWFScheduleObjectName"  title="具体单位" style="width:50%" maxLength="50" description="查勘处理单位" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleObjectName' filter='true' />"
                   <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")){%>
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    <%}%>
                    >
                 <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
                 <img src="/claim/images/bgMarkMustInput.jpg">
                 </tr>
              
             <tr>   
                 <td class="title" style="width:15%">查勘地址:</td>
                 <td class="input" colspan=3>
                    <input  class="input" name="prpLscheduleMainWFCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="查勘地址" value="<bean:write name='prpLscheduleMainWFDto' property='checkSite'/>" <%=ifreadonly1%>><img src="/claim/images/bgMarkMustInput.jpg">
                 </td>
                                
             </tr>
           
              <tr>
              <td class="title" style="width:15%">查勘要点提示:</td>
          <td class="input" colspan=3>
              <input  class="input" name="prpLscheduleMainWFCheckInfo" style="width:90%"  maxLength="255" onblur="checkLength1(this);" description="查勘要点提示"  value="<bean:write name='prpLscheduleMainWFDto' property='checkInfo'/>" <%=ifreadonly1%>>  
              <input  type=hidden name="prpLscheduleMainWFFlag" value="<bean:write name='prpLscheduleMainWFDto' property='flag'/>">
              <input  type=hidden name="prpLscheduleMainWFScheduleFlag" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleFlag'/>">
              <!-- add by liyanjie 2005-12-12 start-->
        	   <input  type=hidden name="checkCommiItemFlag" value="<bean:write name='prpLscheduleMainWFDto' property='commiItemFlag' filter='true' />">     
        	   <input  type=hidden name="prpLscheduleMainWFCheckClaimComCode" value="<bean:write name='prpLscheduleMainWFDto' property='claimComCode'/>">
        			<!-- add by liyanjie 2005-12-12 end-->
          </td>
          
                </tr>
                
                <%//选择下一个节点用的%>

                 <tr>
                 <td class="title" style="width:15%">查勘人员:</td>
                 <td class="input" colspan=3>
               <input type=text name="nextHandlerCode1" class="codecode"  style="width:100px" maxlength="10" title="操作员" description="操作员" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerCode'/>"
                  <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")){%>
                 onchange="setNewHandlerCode(this);"
                 ondblclick="code_CodeSelect(this, 'CheckPerson');"
                 onkeyup= "code_CodeSelect(this, 'CheckPerson');"
                 onblur="code_CodeChange(this, 'CheckPerson','1','code','post','clear');"
                 <%}%>
                 >
              <input type=text name="nextHandlerName1" class="codecode" style="width:80px"  title="操作员" maxLength="30" description="操作员" value="<bean:write name='prpLscheduleMainWFDto' property='nextHandlerName'/>"
              <%=ifreadonly1%>
                    <% if (!ifreadonly1.equals("readonly")){%>
             ondblclick="code_CodeSelect(this, 'CheckPerson','-1','name','always','none','post');"
             onblur="code_CodeChange(this, 'CheckPerson','-1','name','post','clear');"
             onkeyup= "code_CodeSelect(this, 'CheckPerson','-1','name','always','none','post');"
             <%}%>
             >
             <input type="button" class="middlebutton" name="jobManagerButton" value="班表" onclick="linkJobManager();" <% if (ifreadonly1.equals("readonly")){%>disabled<%} %> >
  			 <input type="button" class="middlebutton" name="jobManagerButton" value="班表查询" onclick="queryJobManager();" <% if (ifreadonly1.equals("readonly")){%>disabled<%} %> >
               </td>

                  </tr>
                  <tr>
                  <td class="title">是否调公估行:</td>
        <td class="input">
         <%
           if(!ifreadonly1.equals("readonly"))
           {
         %> 
          <html:radio   name="prpLscheduleMainWFDto" property="flag" value="1"/>是
          <html:radio   name="prpLscheduleMainWFDto" property="flag" value="0"/>否
         <%
           }
           else
           {
         %>
         <logic:equal name="prpLscheduleMainWFDto"  property="flag" value="1">
         	是
         </logic:equal>
         <logic:equal name="prpLscheduleMainWFDto"  property="flag" value="0">
         	否
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
              

