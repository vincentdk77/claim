<%--
****************************************************************************
* DESC       :车辆调度标底信息页面
* AUTHOR     :lixiang
* CREATEDATE : 2004-07-22
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
************************ ****************************************************
--%>
    <%-- 多行输入展现域的模板 --%>
    <%--多行输入自定义JavaScript方法域--%>
   <!--建立显示的录入条，不可以收缩显示的-->   
 <%@page import="java.util.*"%>
  
<input  type=text readonly class="readonly"  name="prpLscheduleItemFinishSchedule" value="<%=request.getAttribute("finishSubmit")%>">
 
            <%-- 多行输入展现域 --%>
            <table class=common cellpadding="5" cellspacing="1">
                <tr>
	               <td colspan=7 class="formtitle">定损调度任务<%=strtitleTemp%>处理</td>
	              </tr>
    
                
                <tbody>
            <%
                int index=0;
                int rowspan=7; //作为序号合并使用的
                int personrowspan=7 ;
                String checkValue=""; 
                String saveType="getBackers"; 
                String haveCheck=""; //判断是否已经选择调度
                String haveCheckdisable=""; //判断是否已经调度过了。
                String itemDis="";   //显示标的名
                String  ifreadonly=""; //默认不是只读的
                String  checkTypeDisplay="style='dipslay:none'"; //默认没有查勘现场等的显示
                String lossItemCode=request.getParameter("lossItemCode");// 只有在editType=GETBACK的时候，决定哪一个才可以修改的
                //判断人员选择的
                String selectPersonFunction ="CertaHanderCode";           
                String getBackDisp=""; //设置改派显示的
                String strLossItemCode = "";   //车辆标的序号
                String riskCode = request.getParameter("riskCode"); 
                String carDisplay0507 = "";
            %>
                 <%// 思路：如果是改派，只显示选择的那一行，不显示其他的调度信息%>
                 <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
                 
             <%  //System.out.println("定损调度不为空");       
                 PrpLscheduleItemDto  prpLscheduleItemDto1=(PrpLscheduleItemDto)request.getAttribute("prpLscheduleItemDto");
             %>
   
                <logic:iterate id="scheduleItem" name="prpLscheduleItemDto" property="scheduleItemList">
             <!-- 插入涉案车辆内容-->        
             <% 
                 carDisplay0507 = "";
                 haveCheckdisable=""; //默认没有被调度过
                 haveCheck=""; //默认没有选择调度
                 itemDis="";//默认什么都不显示
                 ifreadonly=""; //默认不是只读的
                 getBackDisp=""; //改派的显示
                 strLossItemCode = "";
             %>
				<logic:equal name='scheduleItem' property='itemNo' value="1">
					<%
				    if("0507".equals(riskCode.trim())||"0577".equals(riskCode.trim())||"0587".equals(riskCode.trim())){
				    	carDisplay0507 = "";
				      }       
                %>
				</logic:equal>

				<tr <%=carDisplay0507 %>>   
 <%   
     PrpLscheduleItemDto  prpLscheduleItemDto = (PrpLscheduleItemDto) ((ArrayList)prpLscheduleItemDto1.getScheduleItemList()).get(index);                
    if (!"GETBACKEDIT".equals(saveType1)|| ("GETBACKEDIT".equals(saveType1)
           &&  (prpLscheduleItemDto.getItemNo()+"").equals(lossItemCode))) {   
     
      //判断人员选择用哪一个
      selectPersonFunction ="CertaHanderCode";
      if (prpLscheduleItemDto.getItemNo()==0)  selectPersonFunction ="WoundHanderCode";
      if (prpLscheduleItemDto.getItemNo()==-1) selectPersonFunction ="PropHanderCode";                      
 %>       
 
  <input name="prpLscheduleItemOperatorCode" type="hidden" description="操作员"  value="<bean:write name='scheduleItem' property='operatorCode'/>">
  <input name="prpLscheduleItemInputDate" type="hidden" description="操作时间"  value="<bean:write name='scheduleItem' property='inputDate'/>">
  
        
          <logic:equal name='scheduleItem' property='itemNo' value="-1">
                  <td class="title" style="width:20%" rowspan=8>       
          </logic:equal>
            
          <logic:notEqual name='scheduleItem' property='itemNo' value="-1">
                  <td class="title" style="width:20%" rowspan="<%=rowspan%>">       
          </logic:notEqual>                

                    <div align="center">
                       
                     <logic:equal name='scheduleItem' property='selectSend' value="1">
<% 
    haveCheck="checked";
	hasSchedFlag = true;    //add by liyanjie 2005-12-14
%>
                     </logic:equal> 
                     <logic:equal name='scheduleItem' property='surveyTimes' value="1">
<% 
   haveCheckdisable="disabled"; 
   ifreadonly="readonly";
%>
                     </logic:equal>  
                     <logic:equal name='scheduleItem' property='scheduleType' value="sched">
<% 
   //如果主车没有提交，则不可以进行调度
   //haveCheckdisable="disabled"; 
   //ifreadonly="readonly"; 
%>
                     </logic:equal>  
<%
	/*
    if("0507".equals(riskCode.trim())){
       haveCheckdisable=" "; 
       ifreadonly=" ";
       haveCheck=" ";       
    }
	*/
%>
 <% //如果是改派，则可以进行修改操作，但是只能指定的那行做修改的 %>
 
 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
     <logic:equal name='scheduleItem' property='itemNo' value="<%=lossItemCode%>">
     <%
       ifreadonly="";
       getBackDisp="(可改派)";
    %>
     </logic:equal>
 </logic:equal>                   
                     <logic:equal name='scheduleItem' property='itemNo' value="1">
<%
    /*
	if("0507".equals(riskCode.trim())){
    	 haveCheckdisable="disabled"; 
         ifreadonly="readonly";
         haveCheck=" ";       
    }       
	*/
    itemDis="标的车(";
    strLossItemCode = prpLscheduleItemDto.getItemNo() + "):";
%>   
                     </logic:equal>              
                  
                     <input type="checkbox" class="readonly"  name="checkYesNo" style="width:20px" value="ON" <%=haveCheck%> <%=haveCheckdisable%>>&nbsp;
                     
                     

                     
                    
                     
                     <logic:greaterThan name='scheduleItem' property='itemNo' value="1">
<%
    itemDis="三者车(";
    strLossItemCode = prpLscheduleItemDto.getItemNo() + "):";
%>    
                     </logic:greaterThan>
                   
                     <%=itemDis + strLossItemCode %>
                     <bean:write name='scheduleItem' property='licenseNo'/><%=getBackDisp%>
                     <br>    
                     <!--<input type="checkbox"  name="txtScheduleSmcSend" onclick="setSmcSend();" class="readonly" style="width:20px"  >&nbsp;发送短信-->
                </td>
   <input type="hidden" class="readonlyno" readonly name="prpLscheduleItemItemNo" value="<bean:write name='scheduleItem' property='itemNo'/>">
   <input name="prpLscheduleItemLicenseNo" type="hidden" description="号牌号码"  value="<bean:write name='scheduleItem' property='licenseNo'/>">
               
                 
                 
                    </div>
                  
                   </td>          
                 <td class="title" style="width:11%">定损处理单位: </td>
                 <td class="input" colspan=6>
                 <input type=hidden class="codecode" name="prpLscheduleItemScheduleObjectID"  num=<%=index%>
                    style="width:20%" title="具体单位" value="<bean:write name='scheduleItem' property='scheduleObjectID' filter='true' />"
                    <% if (!ifreadonly.equals("readonly")){%>
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                    onchange="setNewComCode(this);"
                    <%}%>
                   <%=ifreadonly%>
                 >
                 
                 <input type=text class="codecode" name="prpLscheduleItemScheduleObjectName"  title="具体单位" style="width:50%" maxLength="50" description="查勘处理单位" value="<bean:write name='scheduleItem' property='scheduleObjectName' filter='true' />"
                   <% if (!ifreadonly.equals("readonly")){%>
                     ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                    onkeypress = "window.event.keyCode = 0;"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'查勘处理单位');"
                   <%}%>
                   <%=ifreadonly%>
                 >
                 
                 <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle"> 
                 <img src="/claim/images/bgMarkMustInput.jpg">
                </tr>
            <%checkTypeDisplay="";%> 
           <logic:greaterThan name='scheduleItem' property='itemNo' value="0">
            <%checkTypeDisplay="style='display:none'"; //默认没有查勘现场等的显示 %>
           </logic:greaterThan>  
             <logic:equal name='scheduleItem' property='itemNo' value="1">
                    <%
                    if("0507".equals(riskCode.trim())||"0577".equals(riskCode.trim())||"0587".equals(riskCode.trim())){
                    	carDisplay0507 = "";
                      }       
                %>
                </logic:equal>
              <tr <%=checkTypeDisplay%> >
          <input type=hidden class="readonlyno" readonly name="prpLscheduleItemInsureCarFlag" value="<bean:write name='scheduleItem' property='insureCarFlag'/>">
            <logic:greaterThan name='scheduleItem' property='itemNo' value="0">
                <input  type=hidden name="prpLscheduleItemCommendRepairFactoryName"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
   
                    <td class="title" style="width:11%" >查勘地:</td>
                    <td class="input" style="width:15%">
                  
                 <logic:equal name='scheduleItem' property='surveyTimes' value="0">
                                      <html:select name="scheduleItem" property="surveyType" style="display:none" >
                              <html:option value="1" >第一现场</html:option>
		                          <html:option value="0">非第一现场</html:option>
		                 </html:select>
                 </logic:equal> 
                 
                 <logic:notEqual name='scheduleItem' property='surveyTimes' value="0" >
                     <html:select name="scheduleItem" property="surveyType" style="display:none">
                            <logic:equal name='scheduleItem' property='surveyType' value="1">
                              <html:option value="1" >第一现场</html:option>
                            </logic:equal>  
                            <logic:equal name='scheduleItem' property='surveyType' value="0" >
		                          <html:option value="0" >非第一现场</html:option>
		                          </logic:equal>
		                 </html:select>

                 </logic:notEqual>
                                
                </td>
                
                  <td class="title" style="width:19%">是否为标的车辆:</td>
                 <td class="input" style="width:10%">
                     
                    <logic:equal name='scheduleItem' property='insureCarFlag' value="1">
                         是
                     </logic:equal>  
                     
                     <logic:notEqual name='scheduleItem' property='insureCarFlag' value="1">
                         否
                     </logic:notEqual>  
                     
                  </td>
                 
	
          </logic:greaterThan>
           
           <logic:equal name='scheduleItem' property='itemNo' value="0">
                 <td class="title" >出险地点:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>

            </logic:equal>
            
           <logic:lessThan name='scheduleItem' property='itemNo' value="1">
            <input type="hidden" name="surveyType" value="<bean:write name='scheduleItem' property='surveyType'/>">
           </logic:lessThan>
            
            </tr>

             <!--Modify by chenrenda  add begin 20050415 -->
             <!--Reason:在定损调度页面中增加修理厂报损金额、修理厂联系电话、是否紧急标志位 -->
           <logic:equal name='scheduleItem' property='itemNo' value="0">
             <tr >   
                <td class="title" style="width:11%" >联系人名称:</td>
                <td class="input" style="width:15%">
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName" maxLength="80" onblur="checkLength1(this);" description="联系人名称" value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
                </td>    
               
               <td class="input" style="width:11%">联系人电话:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="联系人电话" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >报损金额:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            </logic:equal>

            <logic:equal name='scheduleItem' property='itemNo' value="-1">
             <tr>   
                 <td class="title" >定损地址:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="定损地址" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr>   
                <td class="title" style="width:11%" >联系人名称:</td>
                <td class="input" style="width:15%">
                   <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName" maxLength="80" onblur="checkLength1(this);" description="联系人名称"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
               </td>    
               
               <td class="input" style="width:11%">联系人电话:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="联系人电话" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >报损金额:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            </logic:equal>

            <logic:equal name='scheduleItem' property='itemNo' value="-2">
             <tr>   
                 <td class="title" >定损地址:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="定损地址" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr>   
                <td class="title" style="width:11%" >联系人名称:</td>
                <td class="input" style="width:15%">
                   <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName" maxLength="80" onblur="checkLength1(this);" description="联系人名称"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
               </td>    
               
               <td class="input" style="width:11%">联系人电话:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="联系人电话" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >报损金额:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            </logic:equal>
            
           <logic:greaterThan name='scheduleItem' property='itemNo' value="0">
             <tr <%=carDisplay0507%>>   
                 <td class="title" >定损地址:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" maxLength="100" onblur="checkLength1(this);" description="定损地址" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr <%=carDisplay0507%>>   
                <td class="title" style="width:11%" >报损金额:</td>
                <td class="input" style="width:15%">
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
               
               <td class="input" style="width:11%">修理厂联系电话:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" maxLength="30" onblur="checkLength1(this);" description="修理厂联系电话" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
           </logic:greaterThan>
            
             <tr <%=carDisplay0507%>>   
                <td class="title" >案件状态:</td>
                <td class="input" colspan="5">
                   <html:select name="scheduleItem" style="width:30%" property="exigenceGree" >
                     <logic:notEqual name='scheduleItem' property='surveyTimes' value="0">
                       <logic:equal name='scheduleItem' property='exigenceGree' value="1">
                           <html:option value="1"   >一般</html:option>
                        </logic:equal>  
                          <logic:equal name='scheduleItem' property='exigenceGree' value="0">
                          <html:option value="0" >紧急</html:option>
                        </logic:equal>  
                     </logic:notEqual>
                     <logic:equal name='scheduleItem' property='surveyTimes' value="0">
                     
                     <html:option value="1"   >一般</html:option>
                     <html:option value="0" >紧急</html:option>
                     
                     </logic:equal>
		          </html:select>  
                </td>    
                           
             </tr>
             
             <!--Modify by chenrenda  add end 20050415 -->
           
              <tr <%=carDisplay0507%>>
                <td class="title" >定损要点提示:</td>
          <td class="input" colspan=6>
              <input  class="input" <%=ifreadonly%> name="prpLscheduleItemResultInfo" style="width:90%" maxLength="255" onblur="checkLength1(this);" description="定损要点提示" value="<bean:write name='scheduleItem' property='resultInfo'/>">
              <input  type=hidden name="prpLCheckSelectSend" value="0">
              <input  type=hidden name="prpLscheduleItemSelectSend" value="<bean:write name='scheduleItem' property='selectSend'/>">
              <!-- add by liyanjie 2005-12-12 start 每个定损项目有单独的双代标志,单独的调度中心代码-->
              <input  type=hidden name="prpLscheduleItemCommiItemFlag" value="<bean:write name='scheduleItem' property='commiItemFlag'/>">   
              <input  type=hidden name="prpLscheduleItemClaimComCode" value="<bean:write name='scheduleItem' property='claimComCode'/>">   
              <!-- add by liyanjie 2005-12-12 end-->
              <input  type=hidden name="prpLscheduleItemSurveyTimes" value="<bean:write name='scheduleItem' property='surveyTimes'/>">
              <input  type=hidden name="prpLscheduleItemBookFlag" value="<bean:write name='scheduleItem' property='bookFlag'/>">
              <input  type=hidden name="prpLscheduleItemScheduleType" value="<bean:write name='scheduleItem' property='scheduleType'/>">
              <input  type=hidden name="prpLscheduleItemFlag" value="<bean:write name='scheduleItem' property='flag'/>">
          </td>
       </tr>
                 
                 <tr <%=carDisplay0507%>>
                 <td class="title" style="width:11%">定损人员:</td>
                 <td class="input" colspan=6 Style=""><%//边框的设置%>
                   
                   <input type="hidden" name="nextNodeNo" value="<bean:write name='scheduleItem' property='nextNodeNo'/>">
                   <input type=text name="nextHandlerCode" num=<%=index%> class="codecode"   style="width:100px" maxlength="10" title="操作员" value="<bean:write name='scheduleItem' property='nextHandlerCode'/>"
             <% if (!ifreadonly.equals("readonly")){%>
             ondblclick="setNewHandlerComCode(this);code_CodeSelect(this, '<%=selectPersonFunction%>');"
             onkeyup= "code_CodeSelect(this, '<%=selectPersonFunction%>');" 
             onblur="code_CodeChange(this, '<%=selectPersonFunction%>','1','code','post','clear');"
             onchange="setNewHandlerCode(this);"
             <%}%>
             <%=ifreadonly%>
             >
        <input type=text name="nextHandlerName" num=<%=index%> class="codecode" style="width:80px" title="操作员" maxlength="30"   value="<bean:write name='scheduleItem' property='nextHandlerName'/>"
             <% if (!ifreadonly.equals("readonly")){%>
              ondblclick="setNewHandlerComCode(this);code_CodeSelect(this, '<%=selectPersonFunction%>','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, '<%=selectPersonFunction%>','-1','name','none','post');" 
             onblur="code_CodeChange(this, '<%=selectPersonFunction%>','-1','name','post','clear');"
             <%}%>
             <%=ifreadonly%>

                  </td>
                  
               </tr>
               
               <tr <%=carDisplay0507%>><td colspan="7"><hr size="2"  color="#065498" ></td>
               </tr>
               
               
               
<input type="hidden" name="scheduleLossItemCode" value=<%=lossItemCode%>>
<%}%>       
         <%    index++;%>
        </logic:iterate>
      </logic:notEmpty>  
                </tbody>
                <% if ("GETBACKEDIT".equals(saveType1)) index=1; %>
             <input type=hidden name=maxrow value=<%=index%>>
             <input  type=hidden name="scheduleType" value="">
             <input type=hidden name="selectLossItemCodeMain" value="0">
             <input  type=hidden name="prpLscheduleItemScheduleID" value="<bean:write name='prpLscheduleMainWFDto' property='scheduleID'/>">
             </table>
            
            

     

