<%--
****************************************************************************
* DESC       ： 人员伤亡清单页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-10-13  
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>      
<%@ page import="java.util.*"%>

    <span style="display:" id="SpanPerson" cellspacing="1" cellpadding="0">  
      <span style="display:none">  
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0"> 
          <tbody>       
            <tr>   
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:40px"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:100px"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
              </td>
              
              <td class="input">  
                <input type="input" name="prpLpersonItemCode" class="codecode" style="width:40px"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                  <input type="input" name="prpLpersonItemName" class="codename" style="width:80px"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
              </td> 
                            
              <td class="input">  
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:40px"
                      ondblclick= "code_CodeSelect(this,'FeeTypeCode');"
                      onkeyup= "code_CodeSelect(this,'FeeTypeCode');">         
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:60px"
			             ondblclick="code_CodeSelect(this, 'FeeTypeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'FeeTypeCode','-1','always','none','post');">         
              </td> 
                           
              <td class="input">  
                <input type="input" name="prpLpersonCurrency" class="codecode" style="width:30px"
                      ondblclick= "code_CodeSelect(this,'Currency');"
                      onkeyup= "code_CodeSelect(this,'Currency');">         
                  <input type="input" name="prpLpersonCurrencyName" class="codename" style="width:60px"
			             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">         
              </td>      
              <td class="input">
                <input name="prpLpersonSumLoss" class="common" style="width:60px" onBlur="return calSumPersonDefLoss(this);">
              </td>
              <td class="input">
                <input name="prpLpersonSumDefLoss" class="common" style="width:60px">
                <input type="hidden" name="prpLpersonItemKindNo"> 
                <input type="hidden" name="prpLpersonFamilyNo"> 
                <input type="hidden" name="prpLpersonUnit"> 
                <input type="hidden" name="prpLpersonTimes"> 
                <input type="hidden" name="prpLpersonRejectReason"> 
                <input type="hidden" name="prpLpersonVeriQuantity"> 
                <input type="hidden" name="prpLpersonVeriUnit"> 
                <input type="hidden" name="prpLpersonVeriTimes"> 
                <input type="hidden" name="prpLpersonVeriSumLoss"> 
                <input type="hidden" name="prpLpersonVeriSumReject"> 
                <input type="hidden" name="prpLpersonVeriRejectReason"> 
                <input type="hidden" name="prpLpersonVeriLossRate"> 
                <input type="hidden" name="prpLpersonVeriSumDefLoss"> 
                <input type="hidden" name="prpLpersonVeriRemark"> 
                <input type="hidden" name="prpLpersonFlag"> 
                <input type="hidden" name="prpLpersonUnitLoss">
                <input type="hidden" name="prpLpersonQuantity">
                <input type="hidden" name="prpLpersonSumReject">
              </td>                                                                            
              <td class="input"> 
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"    class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
          </tbody>
        </table>
      </span>
       
      <table align="center" border="0" cellpadding="1" cellspacing="1" bgcolor="#2D8EE1" class="common" width="100%">
      <!--表示显示多行的-->    
        <tr>
          <td class="subformtitle" colspan="4" align="center">
            人员核定损清单             
          </td>
        </tr>
        <tr>
          <td class="subformtitle" colspan="4">
            <span style="display:none"> 
              <table class="common" style="display:none" id="Person_Data" cellspacing="1" cellpadding="0"  bgcolor="#2D8EE1">
                <tbody>                      
                   <tr>
                     <td class="input" style="width:3%">
                       <div align="center">
                         <input class="readonlyNo" readonly name="prpLpersonSerialNo" description="序号">
                       </div> 
                     </td>
                     <td class="subformtitle">
                       <table  cellpadding="0" cellspacing="1" class="common">
                         <tr> 
                           <td class="title" style="width:15%">人员姓名:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonPersonName" class="input" style="width:150px"><img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr>      
                         
                         <tr>
                           <td class="title" style="width:15%">性别:</td>
                           <td class="input" style="width:35%">                                     
                            <select name="prpLpersonPersonSex" class='input' style="width:110">   
                               <option value="1">男</option>
                               <option value="2">女</option>                   
                            </select>   
                           </td>                          
                           <td class="title" style="width:15%">年龄:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonPersonAge" class="input" style="width:150px">
                           </td>
                         </tr>  
                          
                          <input type="hidden" name="familyName">                      
                          <input type="hidden" name="prpLpersonIdentifyNumber">
                          <input type="hidden" name="prpLpersonAreaCode" > 
                          <input type="hidden" name="prpLpersonAreaName">
                          <input type="hidden" name="prpLpersonFixedIncomeFlag"">
                          <input type="hidden" name="prpLpersonJobCode"> 
                          <input type="hidden" name="prpLpersonJobName">
                          <input type="hidden" name="prpLpersonPayPersonType">
                          <input type="hidden" name="prpLpersonRelatePersonNo">
                          <input type="hidden" name="prpLpersonLossRate"">
                             
                         <tr>   
                           <td class="title" style="width:15%">折合币别:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCurrency2" type="text" class="readonly" readonly style="width:50px" value="CNY">
                             <input name="prpLpersonCurrency2Name" class="readonly" readonly style="width:150px" value="人民币">
                           </td>
                           <td class="title" style="width:15%">损失合计:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonSumDefLossSum" class="readonly" readonly style="width:150px"> 
                            </td>
                         </tr>  
                         <tr>
                           <td class="title" style="width:15%">备注:</td>
                           <td class="input" style="width:50%" colspan="2">
                             <input name="prpLpersonRemark" class="input" style="width:350px">
                             <input type="hidden" name="prpLpersonPersonNo"> 
                           </td>
                           <td class="input" align="center" style="width:35%"><input type="button"  class="bigbutton"  name="button_Person_Collect" value="损失合计" onclick="alert('损失合计');"></td>
                         </tr>  
                        <tr> 
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan=11>
                                  人员伤亡费用清单信息 <font color="#FF0000">*</font>
                                </td> 
                              </tr>
                              <tr> 
                                <td class="centertitle" style="width:7%">险别代码</td> 
                                <td class="centertitle" style="width:17%">险别名称</td>
                                <td class="centertitle" style="width:20%">责任分类</td>                                 
                                <td class="centertitle" style="width:18%">责任明细</td> 
                                <td class="centertitle" style="width:15%">币别</td>
                                <td class="centertitle" style="width:10%">报损金额</td>
                                <td class="centertitle" style="width:10%">核损金额</td>  
                                <td class="centertitle" style="width:3%">&nbsp;</td>                                        
                              </tr>  
                            </thead>                            
                            <tfoot>
                              <tr>
                                <td class="title" colspan="7" style="width:97%">(按"+"号键增加人员伤亡费用信息，按"-"号键删除信息)</td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+"  class="smallbutton"  onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                             
                            <tbody>
                   
                            </tbody>
                          </table>  
                        </span>  
                      </td>
                    </tr>  
        
                </table>
              </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 
         </tbody>
       </table>
     </span>
          
     <span  id="spanPerson">
       <%-- 多行输入展现域 --%>
       <table id="person" class="common" align="center" cellspacing="1" cellpadding="0">
         <thead>
           <tr>
             <td class="title" style="width:4%">序号</td>
             <td class="title" style="width:96%" colspan=2 >内容</td>
           </tr> 
         </thead>
         <tfoot>
           <tr>
             <td class="title" colspan=2 style="width:96%">(按"+"号键增加赔付人员信息，按"-"号键删除赔付人员信息)</td>
             <td class="title" align="right" style="width:4%">
               <div align="center">
                 <input type="button" value="+" onclick="insertRow('person')"  class="smallbutton" name="buttonPersonInsert" style="cursor: hand">
               </div>
             </td>
           </tr>
         </tfoot> 
         <tbody>

<% indexCertainLoss=0;%>
<%
    int personNo = 0;
    PrpLpersonDto prpLpersonDto = (PrpLpersonDto)request.getAttribute("prpLpersonDto");
    if(prpLpersonDto.getPersonList()!=null){
      Iterator iterator = prpLpersonDto.getPersonList().iterator();
      while(iterator.hasNext()){
        PrpLpersonDto PrpLpersonDto1 =  (PrpLpersonDto)iterator.next();
        if(!(PrpLpersonDto1.getPersonNo() == personNo)){
%>               
                   <tr>
                     <td class="input" style="width:3%">
                       <div align="center">
                         <input class="readonlyNo" readonly name="prpLpersonSerialNo" description="序号" value="<%= personNo+1 %>">
                       </div>
                     </td>
                     <td class="subformtitle">
                       <table  cellpadding="0" cellspacing="1" class="common">
                         <tr>
                           <td class="title" style="width:15%">人员姓名:</td>
                           <td class="input" style="width:85%" colspan="3">
                             <input name="prpLpersonPersonName" class="input" style="width:150px"  value="<%= PrpLpersonDto1.getPersonName() %>"><img src="/claim/images/bgMarkMustInput.jpg">
                           </td>
                         </tr>                               
                         <tr>
                           <td class="title" style="width:15%">性别:</td>
                           <td class="input" style="width:35%">                 
                           <select name="prpLpersonPersonSex" class="three" style="width:110px"  value="<%= PrpLpersonDto1.getPersonSex() %>">   
                               <option value="1" <%= PrpLpersonDto1.getPersonSex().trim().equals("1")? "selected":"" %>>男</option>
                               <option value="2" <%= PrpLpersonDto1.getPersonSex().trim().equals("2")? "selected":"" %>>女</option>                   
                            </select>   
                           </td>
                           <td class="title" style="width:15%">年龄:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonPersonAge" class="input" style="width:150px" value="<%= PrpLpersonDto1.getPersonAge() %>">
                           </td>
                         </tr> 
                          <input type="hidden" name="familyName" style="width:150px" value="<%= PrpLpersonDto1.getFamilyName() %>">                      
                          <input type="hidden" name="prpLpersonIdentifyNumber"  value="<%= PrpLpersonDto1.getIdentifyNumber() %>">
                          <input type="hidden" name="prpLpersonAreaCode"  value="<%= PrpLpersonDto1.getAreaCode() %>"> 
                          <input type="hidden" name="prpLpersonAreaName"  value="<%= PrpLpersonDto1.getAreaName() %>">
                          <input type="hidden" name="prpLpersonFixedIncomeFlag" value="<%= PrpLpersonDto1.getFixedIncomeFlag() %>">
                          <input type="hidden" name="prpLpersonJobCode"  value="<%= PrpLpersonDto1.getJobCode() %>"> 
                          <input type="hidden" name="prpLpersonJobName"  value="<%= PrpLpersonDto1.getJobName() %>">
                          <input type="hidden" name="prpLpersonPayPersonType"  value="<%= PrpLpersonDto1.getPayPersonType() %>">
                          <input type="hidden" name="prpLpersonRelatePersonNo"  value="<%= PrpLpersonDto1.getRelatePersonNo() %>">
                          <input type="hidden" name="prpLpersonLossRate"  value="<%= PrpLpersonDto1.getLossRate() %>">
                         <tr>  
                           <td class="title" style="width:15%">折合币别：</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonCurrency2" type="text" class="readonly" readonly style="width:50px" value="CNY">
                             <input name="prpLpersonCurrency2Name" class="readonly" readonly style="width:150px" value="人民币">
                           </td>
                           <td class="title" style="width:15%">损失合计:</td>
                           <td class="input" style="width:35%">
                             <input name="prpLpersonSumDefLossSum" class="readonly" readonly style="width:150px"> 
                            </td>
                         </tr> 
                         <tr>
                           <td class="title" style="width:15%">备注:</td>
                           <td class="input" style="width:50%" colspan="2">
                             <input name="prpLpersonRemark" class="input" style="width:350px" value="<%= PrpLpersonDto1.getRemark() %>">
                             <input type="hidden" name="prpLpersonPersonNo" value="<%= PrpLpersonDto1.getPersonNo() %>"> 
                           </td>
                           <td class="input" align="center" style="width:35%"><input type="button" name="button_Person_Collect" value="损失合计"  class="bigbutton" onclick="alert('损失合计');"></td>
                        </tr>  
                        <tr>  
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss"  class="common" style="width:100%" >
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan=11>
                                  人员伤亡费用清单信息 <font color="#FF0000">*</font>
                                </td>
                              </tr>
                              <tr>
                                <td class="centertitle" style="width:7%">险别代码</td> 
                                <td class="centertitle" style="width:17%">险别名称</td>
                                <td class="centertitle" style="width:20%">责任分类</td>                                
                                <td class="centertitle" style="width:18%">责任明细</td> 
                                <td class="centertitle" style="width:15%">币别</td>
                                <td class="centertitle" style="width:10%">报损金额</td>
                                <td class="centertitle" style="width:10%">核损金额</td>  
                                <td class="centertitle" style="width:3%">&nbsp;</td>                                           
                              </tr>  
                            </thead> 
                            <tfoot> 
                              <tr>
                                <td class="title" colspan="7" style="width:97%">(按"+"号键增加人员伤亡费用信息，按"-"号键删除信息)</td>
                                <td class="title" align="right" style="width:4%"> 
                                  <div align="center">
                                    <input type="button" value="+"  class="smallbutton"  onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                               
                            <tbody>
<%
   Iterator iterator1 = prpLpersonDto.getPersonList().iterator();
      while(iterator1.hasNext()){ 
        PrpLpersonDto PrpLpersonDto2 =  (PrpLpersonDto)iterator1.next();
        if(PrpLpersonDto2.getPersonNo() == (personNo+1)){
%> 
<%
          if(flag==null){
%>                   
            <tr>   
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px" value="<%= personNo+1 %>"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:40px" value="<%= PrpLpersonDto2.getKindCode() %>"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:100px" value="<%= PrpLpersonDto2.getKindName() %>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
              </td>
              
              <td class="input">  
                <input type="input" name="prpLpersonItemCode" class="codecode" style="width:40px" value="<%= PrpLpersonDto2.getItemCode() %>"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                  <input type="input" name="prpLpersonItemName" class="codename" style="width:80px" value="<%= PrpLpersonDto2.getItemName() %>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
              </td> 
                            
              <td class="input">  
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:40px" value="<%= PrpLpersonDto2.getFeeTypeCode() %>"
                      ondblclick= "code_CodeSelect(this,'FeeTypeCode');"
                      onkeyup= "code_CodeSelect(this,'FeeTypeCode');">         
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:60px" value="<%= PrpLpersonDto2.getFeeTypeName() %>"
			             ondblclick="code_CodeSelect(this, 'FeeTypeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'FeeTypeCode','-1','always','none','post');">         
              </td> 
                           
              <td class="input">  
                <input type="input" name="prpLpersonCurrency" class="codecode" style="width:30px" value="<%= PrpLpersonDto2.getCurrency() %>"
                      ondblclick= "code_CodeSelect(this,'Currency');"
                      onkeyup= "code_CodeSelect(this,'Currency');">         
                  <input type="input" name="prpLpersonCurrencyName" class="codename" style="width:60px" value="<%= PrpLpersonDto2.getCurrencyName() %>"
			             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">         
              </td>      
              <td class="input">
                <input name="prpLpersonSumLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumLoss() %>" onBlur="return calSumPersonDefLoss(this);">
              </td>
              <td class="input">
                <input name="prpLpersonSumDefLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumDefLoss() %>">
                <input type="hidden" name="prpLpersonItemKindNo" value="<%= PrpLpersonDto2.getItemKindNo() %>"> 
                <input type="hidden" name="prpLpersonFamilyNo" value="<%= PrpLpersonDto2.getFamilyNo() %>"> 
                <input type="hidden" name="prpLpersonUnit" value="<%= PrpLpersonDto2.getUnit() %>"> 
                <input type="hidden" name="prpLpersonTimes" value="<%= PrpLpersonDto2.getTimes() %>"> 
                <input type="hidden" name="prpLpersonRejectReason" value="<%= PrpLpersonDto2.getRejectReason() %>"> 
                <input type="hidden" name="prpLpersonVeriQuantity" value="<%= PrpLpersonDto2.getVeriQuantity() %>"> 
                <input type="hidden" name="prpLpersonVeriUnit" value="<%= PrpLpersonDto2.getVeriUnit() %>"> 
                <input type="hidden" name="prpLpersonVeriTimes" value="<%= PrpLpersonDto2.getVeriTimes() %>"> 
                <input type="hidden" name="prpLpersonVeriSumLoss" value="<%= PrpLpersonDto2.getVeriSumLoss() %>"> 
                <input type="hidden" name="prpLpersonVeriSumReject" value="<%= PrpLpersonDto2.getVeriSumReject() %>"> 
                <input type="hidden" name="prpLpersonVeriRejectReason" value="<%= PrpLpersonDto2.getVeriRejectReason() %>"> 
                <input type="hidden" name="prpLpersonVeriLossRate" value="<%= PrpLpersonDto2.getVeriLossRate() %>"> 
                <input type="hidden" name="prpLpersonVeriSumDefLoss" value="<%= PrpLpersonDto2.getVeriSumDefLoss() %>"> 
                <input type="hidden" name="prpLpersonVeriRemark" value="<%= PrpLpersonDto2.getVeriRemark() %>"> 
                <input type="hidden" name="prpLpersonFlag" value="<%= PrpLpersonDto2.getFlag() %>"> 
                <input type="hidden" name="prpLpersonUnitLoss" value="<%= PrpLpersonDto2.getUnitLoss() %>">
                <input type="hidden" name="prpLpersonQuantity" value="<%= PrpLpersonDto2.getQuantity() %>">
                <input type="hidden" name="prpLpersonSumReject" value="<%= PrpLpersonDto2.getSumReject() %>">
              </td>                                                                            
              <td class="input">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"   class="smallbutton"  onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
<%
              } else {
%>                    
            <tr>   
              <td class="input">  
                <input type="hidden" name="personSerialNo" style="width:20px" value="<%= personNo+1 %>"> 
                <input type="input" name="prpLpersonKindCode" class="codecode" style="width:60px" value="<%= PrpLpersonDto2.getKindCode() %>"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonKindName" class="codename" style="width:80px" value="<%= PrpLpersonDto2.getKindName() %>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
              </td>

              <td class="input">  
                <input type="input" name="prpLpersonFeeTypeCode" class="codecode" style="width:60px" value="<%= PrpLpersonDto2.getFeeTypeCode() %>"
                      ondblclick= "code_CodeSelect(this,'FeeTypeCode');"
                      onkeyup= "code_CodeSelect(this,'FeeTypeCode');">         
              </td>
              <td class="input">   
                  <input type="input" name="prpLpersonFeeTypeName" class="codename" style="width:80px" value="<%= PrpLpersonDto2.getFeeTypeName() %>"
			             ondblclick="code_CodeSelect(this, 'FeeTypeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'FeeTypeCode','-1','always','none','post');">         
              </td>
      
              <td class="input">
                <input name="prpLpersonUnitLoss" title="单价" class="common" style="width:60px" value="<%= PrpLpersonDto2.getUnitLoss() %>">
              </td>
              <td class="input">
                <input name="prpLpersonQuantity" class="common" style="width:60px" value="<%= PrpLpersonDto2.getQuantity() %>">
              </td>                     
              <td class="input">
                <input name="prpLpersonSumLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumLoss() %>" onBlur="return calSumPersonDefLoss(this);">
              </td>
              <td class="input">
                <input name="prpLpersonSumReject" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumReject() %>" onBlur="return calSumPersonDefLoss(this);">
              </td>
              <td class="input">
                <input name="prpLpersonSumDefLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getSumDefLoss() %>">
                <input type="hidden" name="prpLpersonItemKindNo" value="<%= PrpLpersonDto2.getItemKindNo() %>"> 
                <input type="hidden" name="prpLpersonFamilyNo" value="<%= PrpLpersonDto2.getFamilyNo() %>"> 
                <input type="hidden" name="prpLpersonItemCode" value="<%= PrpLpersonDto2.getItemCode() %>"> 
                <input type="hidden" name="prpLpersonUnit" value="<%= PrpLpersonDto2.getUnit() %>"> 
                <input type="hidden" name="prpLpersonTimes" value="<%= PrpLpersonDto2.getTimes() %>"> 
                <input type="hidden" name="prpLpersonRejectReason" value="<%= PrpLpersonDto2.getRejectReason() %>"> 
                <input type="hidden" name="prpLpersonVeriQuantity" value="<%= PrpLpersonDto2.getVeriQuantity() %>"> 
                <input type="hidden" name="prpLpersonVeriUnit" value="<%= PrpLpersonDto2.getVeriUnit() %>"> 
                <input type="hidden" name="prpLpersonVeriTimes" value="<%= PrpLpersonDto2.getVeriTimes() %>"> 
                <input type="hidden" name="prpLpersonVeriRejectReason" value="<%= PrpLpersonDto2.getVeriRejectReason() %>"> 
                <input type="hidden" name="prpLpersonVeriLossRate" value="<%= PrpLpersonDto2.getVeriLossRate() %>"> 
                <input type="hidden" name="prpLpersonVeriRemark" value="<%= PrpLpersonDto2.getVeriRemark() %>"> 
                <input type="hidden" name="prpLpersonFlag" value="<%= PrpLpersonDto2.getFlag() %>"> 
              </td>                                                                            
              <td class="input"> 
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"   class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
              
            <tr>   
              <td class="input" colspan="6">&nbsp;</td>
              <td class="input">
                <input name="prpLpersonVeriSumLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getVeriSumLoss() %>">
              </td>
              <td class="input">
                <input name="prpLpersonVeriSumReject" class="common" style="width:60px" value="<%= PrpLpersonDto2.getVeriSumReject() %>">
              </td>
              <td class="input">
                <input name="prpLpersonVeriSumDefLoss" class="common" style="width:60px" value="<%= PrpLpersonDto2.getVeriSumDefLoss() %>">
              </td>                                                                            
              <td class="input">&nbsp;</td>             
            </tr>
            
<%
      }
    }
  }
%>            
                            </tbody>
                          </table>  
                        </span>  
                      </td>
                    </tr> 
<input type="hidden" class='readonly' readonly="true" name='prpLpersonSumLossSum'>
<input type="hidden" class='readonly' readonly="true" name='prpLpersonSumRejectSum'>
<input type="hidden" class='readonly' readonly="true" name='SumSumDefLoss'> 
                      
                </table>
              </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"   class="smallbutton" onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 


<%
        personNo =   PrpLpersonDto1.getPersonNo();
        }
      }
    }
%>
         </tbody>
       </table>  
       
     </span>    
   </td>
 </tr>  
</table>
</span>  
 







  














