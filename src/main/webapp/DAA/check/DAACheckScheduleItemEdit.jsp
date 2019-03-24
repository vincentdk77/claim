<%--
****************************************************************************
* DESC       :车辆调度标底信息页面
* AUTHOR     :lixiang
* CREATEDATE : 2004-07-22
* MODIFYLIST :   Name       Date            Reason/Contents
*          ------------------------------------------------------
************************ ****************************************************
--%>

            
 相关调度车辆状况：
    
             <table id="checkItem"  align="center" cellspacing="1" cellpadding="2" border="0" bgcolor="#2D8EE1" class="title" style="width:100%" >
                <thead>
       
                  <td class="title" style="width:10%;text-align:center" >序号</td>
                     <td class="title" style="width:90%;text-align:center" colspan="6">内容</td>
                  </tr>
                </thead>
                <tbody>
                <%int index=0;%>
                <%String checkValue=""; %>
                 
                <logic:notEmpty  name="prpLcheckItemDto"  property="checkItemList"> 
                <logic:iterate id="checkItem" name="prpLcheckItemDto" property="checkItemList">
             <!-- 插入涉案车辆内容-->        
               
                 <tr>
                   <td class="title" style="width:8%" rowspan="3">
                    <div align="center">
                      <input class="readonlyno" readonly name="prpLcheckItemItemNo" value="<bean:write name='checkItem' property='itemNo'/>">
                     <logic:equal name='checkItem' property='selectSend' value="1">
                         <input type="checkbox" class="readonly"  name="checkYesNo" style="1px" value="ON" checked disabled>&nbsp;
                     </logic:equal>  
                      
                     <logic:notEqual name='checkItem' property='selectSend' value="1">
                         <input type="checkbox" class="readonly"  name="checkYesNo" style="1px" value="ON" disabled>&nbsp;
                     </logic:notEqual>
                     
                    </div>
                    
                   </td>          
                <td class="title" style="width:11%">号牌号码:</td>
                <td class="input" style="width:20%" style="valign:bottom" >
                     <input name="prpLcheckItemLicenseNo" class="readonlyno" readonly style="width:98%" maxlength=20 description="号牌号码"  value="<bean:write name='checkItem' property='licenseNo'/>">
                     
                </td>
                 <td class="title" style="width:16%" >查勘地址类型:</td>
                <td class="input" style="width:16%">
                   <logic:equal name='checkItem' property='surveyType' value="1">
                      第一现场 
                     </logic:equal>  
                     <logic:notEqual name='checkItem' property='surveyType' value="1">
                     非第一现场
                     </logic:notEqual>
                </td>
                
                 <td class="title" style="width:19%">是否为本保单车辆:</td>
                 <td class="input" style="width:10%">
                     
                     <input type=hidden class="readonlyno" readonly name="prpLcheckItemInsureCarFlag" value="<bean:write name='checkItem' property='insureCarFlag'/>">
                     
                     <logic:equal name='checkItem' property='insureCarFlag' value="1">
                         是
                     </logic:equal>  
                     
                     <logic:notEqual name='checkItem' property='insureCarFlag' value="1">
                         否
                     </logic:notEqual>  
                     
                  </td>
                        
            </tr>
           
             <tr>   
                 <td class="title" >查勘地址:</td>
                 <td class="input" colspan=5>
                  <input  class="input" name="prpLcheckItemCheckSite" style="width:99%" value="<bean:write name='checkItem' property='checkSite'/>">
                 </td>
             </tr>
           
              <tr>
                <td class="title" >调度信息:</td>
          <td class="input" colspan=6>
              <input  class="readonlyno" readonly name="prpLcheckItemResultInfo" style="width:99%" value="<bean:write name='checkItem' property='resultInfo'/>">
              <input  type=hidden name="prpLcheckItemSelectSend" value="<bean:write name='checkItem' property='selectSend'/>">
              <input  type=hidden name="prpLcheckItemSurveyTimes" value="<bean:write name='checkItem' property='surveyTimes'/>">
              <input  type=hidden name="prpLcheckItemBookFlag" value="<bean:write name='checkItem' property='bookFlag'/>">
              
              <input  type=hidden name="prpLcheckItemScheduleType" value="<bean:write name='checkItem' property='scheduleType'/>">
              <input  type=hidden name="prpLcheckItemFlag" value="<bean:write name='checkItem' property='flag'/>">
          </td>
          
          
                </tr>
         
        <%    index++;%>
        </logic:iterate>
      </logic:notEmpty>  
       
                </tbody>
             <input type=hidden name=maxrow value=<%=index%>>
             </table>
            
