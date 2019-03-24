<%--
****************************************************************************
* DESC       :车辆调度标底信息页面
* AUTHOR     :lixiang
* CREATEDATE : 2004-07-22
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
************************ ****************************************************
--%>
<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpLscheduleItemDto"%>
    <%-- 多行输入展现域的模板 --%>
    <%--多行输入自定义JavaScript方法域--%>
   <!--建立显示的录入条，不可以收缩显示的-->   
<input  type=text readonly class="readonly"  name="prpLscheduleItemFinishSchedule" value="<%=request.getAttribute("finishSubmit")%>">
 
            <%-- 多行输入展现域 --%>
            <table class=common cellpadding="5" cellspacing="1">
                <tr>
	               <td colspan=7 class="formtitle">定损调度任务<%=strtitleTemp%>处理</td>
	              </tr>
    
                
                <tbody>
            <%
                int index=0;
                int rowspan=8; //作为序号合并使用的
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
            %>
                 <%// 思路：如果是改派，只显示选择的那一行，不显示其他的调度信息%>
                 <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList"> 
                 
             <%  //System.out.println("定损调度不为空");       
                 PrpLscheduleItemDto  prpLscheduleItemDto1=(PrpLscheduleItemDto)request.getAttribute("prpLscheduleItemDto");
             %>
   
                <logic:iterate id="scheduleItem" name="prpLscheduleItemDto" property="scheduleItemList">
             <!-- 插入涉案车辆内容-->        
             <% 
                 haveCheckdisable=""; //默认没有被调度过
                 haveCheck=""; //默认没有选择调度
                 itemDis="";//默认什么都不显示
                 ifreadonly=""; //默认不是只读的
                 getBackDisp=""; //改派的显示
             %>  
                  
              <tr>   
 <%   
     PrpLscheduleItemDto  prpLscheduleItemDto = (PrpLscheduleItemDto) ((ArrayList)prpLscheduleItemDto1.getScheduleItemList()).get(index);                
    if (!"GETBACKEDIT".equals(saveType1)|| ("GETBACKEDIT".equals(saveType1)
           &&  (prpLscheduleItemDto.getItemNo()+"").equals(lossItemCode))) {
     
      //判断人员选择用哪一个
      selectPersonFunction ="CertaHanderCode";
      //暂时注释掉 miaowenjun 20060928
      //因为农险的还没有
      //if (prpLscheduleItemDto.getItemNo()==0)  selectPersonFunction ="WoundHanderCode";
      //if (prpLscheduleItemDto.getItemNo()==-1) selectPersonFunction ="PropHanderCode";                      
 %>       
 
  <input name="prpLscheduleItemOperatorCode" type="hidden" description="操作员"  value="<bean:write name='scheduleItem' property='operatorCode'/>">
  <input name="prpLscheduleItemInputDate" type="hidden" description="操作时间"  value="<bean:write name='scheduleItem' property='inputDate'/>">
  <td class="title" style="width:20%" rowspan="<%=rowspan%>">        
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

                     </logic:equal>  
                                          
 <% //如果是改派，则可以进行修改操作，但是只能指定的那行做修改的 %>
 
 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
     <logic:equal name='scheduleItem' property='itemNo' value="<%=lossItemCode%>">
     <%
       ifreadonly="";
       getBackDisp="(可改派)";
    %>
     </logic:equal>
 </logic:equal>                   
                     <input type="checkbox" class="readonly"  name="checkYesNo" style="width:20px" value="ON" <%=haveCheck%> <%=haveCheckdisable%>>&nbsp;标的:
   <input type="hidden" class="readonlyno" readonly name="prpLscheduleItemItemNo" value="<bean:write name='scheduleItem' property='itemNo'/>">
              
                    </div>
                  
                   </td>          
                 <td class="title" style="width:11%">定损处理单位:</td>
                 <td class="input" colspan=6>
                 <input type=hidden class="codecode" name="prpLscheduleItemScheduleObjectID"  num=<%=index%>
                    style="width:20%" title="具体单位" value="<bean:write name='scheduleItem' property='scheduleObjectID' filter='true' />"
                    <% if (!ifreadonly.equals("readonly")){%>
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur= "code_CodeChange(this, 'ComCodeByProvinceCode');" 
                    onchange="setNewComCode(this);"
                    <%}%>
                   <%=ifreadonly%>
                 >
                 
                 <input type=text class="codecode" name="prpLscheduleItemScheduleObjectName"  title="具体单位" style="width:50%" value="<bean:write name='scheduleItem' property='scheduleObjectName' filter='true' />"
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

              <tr <%=checkTypeDisplay%> >
           
           <logic:lessThan name='scheduleItem' property='itemNo' value="1">
            <input type="hidden" name="surveyType" value="<bean:write name='scheduleItem' property='surveyType'/>">
           </logic:lessThan>
            
                     <input type="hidden" name="surveyType" value="<bean:write name='scheduleItem' property='surveyType'/>">
            
                 <td class="title" >定损地址:</td>
                 <td class="input" colspan=5>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCheckSite" style="width:90%" value="<bean:write name='scheduleItem' property='checkSite'/>"><img src="/claim/images/bgMarkMustInput.jpg">  
                 </td>
                                
             </tr>           
             <tr>   
                <td class="title" style="width:11%" >联系人名称:</td>
                <td class="input" style="width:15%">
                   <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemCommendRepairFactoryName"  value="<bean:write name='scheduleItem' property='commendRepairFactoryName'/>">
               </td>    
               
               <td class="input" style="width:11%">联系人电话:</td>
               <td class="input" style="width:15%">
                 <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryPhone" value="<bean:write name='scheduleItem' property='factoryPhone'/>">
               </td>                
             </tr>
             <tr>   
                <td class="title" style="width:11%" >报损金额:</td>
                <td class="input" colspan=4>
                  <input  class="input"  <%=ifreadonly%> name="prpLscheduleItemFactoryEstimateLoss"  value="<bean:write name='scheduleItem' property='factoryEstimateLoss'/>">
                </td>    
             </tr>
            
             <tr>   
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
           
              <tr>
                <td class="title" >定损要点提示:</td>
          <td class="input" colspan=6>
              <input  class="input" <%=ifreadonly%> name="prpLscheduleItemResultInfo" style="width:90%" value="<bean:write name='scheduleItem' property='resultInfo'/>">
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
                 
                 <tr>
                 <td class="title" style="width:11%">定损人员:</td>
                 <td class="input" colspan=6 Style=""><%//边框的设置%>
                   
                   <input type="hidden" name="nextNodeNo" value="<bean:write name='scheduleItem' property='nextNodeNo'/>">
                   <input type=text name="nextHandlerCode" num=<%=index%> class="codecode"   style="width:100px" maxlength="10" title="操作员" value="<bean:write name='scheduleItem' property='nextHandlerCode'/>"
             <% if (!ifreadonly.equals("readonly")){%>
             ondblclick="setNewHandlerComCode(this);code_CodeSelect(this, '<%=selectPersonFunction%>');"
             onkeyup= "code_CodeSelect(this, '<%=selectPersonFunction%>');" 
             onchange="setNewHandlerCode(this);"
             <%}%>
             <%=ifreadonly%>
             >
        <input type=text name="nextHandlerName" num=<%=index%> class="codecode" style="width:80px" title="操作员"    value="<bean:write name='scheduleItem' property='nextHandlerName'/>" 
             <% if (!ifreadonly.equals("readonly")){%>
              ondblclick="setNewHandlerComCode(this);code_CodeSelect(this, '<%=selectPersonFunction%>','-1','name','none','post');"
             onkeyup= "code_CodeSelect(this, '<%=selectPersonFunction%>','-1','name','none','post');" 
             onchange="code_CodeChange(this, '<%=selectPersonFunction%>','-1','name','always','none','post');"
             <%}%>
             <%=ifreadonly%>

                  </td>
                  
               </tr>
               
               <tr ><td colspan="7"><hr size="2"  color="#065498" ></td>
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
            
            

     

