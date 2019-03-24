<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
  <%@ page import="java.util.*"%>
  
   <!--建立显示的录入条，可以收缩显示的-->
    
      <span style="display:none"> 
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0">
          <tbody>  
            <tr>                
              <td class="inputsubsub">
                <input type="hidden" name="personLossSerialNo" style="width:20px"> 
                <input type="input" name="prpLpersonLossKindCode" class="codecode" 
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                <input type="input" name="prpLpersonLossKindName" class="codename" 
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">             
              </td> 
                     
              <td class="inputsubsub">                        
                <input name="prpLpersonLossLiabDetailCode" type="hidden"
                   ondblclick= " code_CodeSelect(this,'ChargeCode');"
                   onkeyup= " code_CodeSelect(this,'ChargeCode');">                                                   
                <input name="prpLpersonLossLiabDetailName" class="codename" style="width:70px"
                  ondblclick= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
                  onkeyup= " code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"> 
              </td>                 
              <td class="inputsubsub">
                <input type="hidden" name="prpLpersonLossCurrency" class="codecode"
                  ondblclick= "code_CodeSelect(this,'Currency');"
                  onkeyup= "code_CodeSelect(this,'Currency');">  
                <input class="input"  name="prpLpersonLossCurrencyName" class="codename"
		             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
		             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
              </td>
              
              <td class="inputsubsub">
                <input name="prpLpersonLossSumLoss" class="common" style="width:70px">
              </td>
              <td class="inputsubsub">      
                <input name="prpLpersonLossAmount" class="common" style="width:70px">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossClaimRate" class="common" style="width:70px">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossDeductible" class="common" style="width:70px">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRealPay" class="common" style="width:70px"> 
                <input type="hidden" name="prpLpersonLossUnitAmount">
                <input type="hidden" name="prpLpersonLossLossQuantity">
                <input type="hidden" name="prpLpersonLossFamilyName">
                <input type="hidden" name="prpLpersonLossIndemnityDutyRate">                  
                <input type="hidden" name="prpLpersonLossDeductibleRate">
                <input type="hidden" name="prpLpersonLossItemKindNo">       
                <input type="hidden" name="prpLpersonLossFamilyNo">         
                <input type="hidden" name="prpLpersonLossIdentifyNumber">   
                <input type="hidden" name="prpLpersonLossLiabCode">         
                <input type="hidden" name="prpLpersonLossLiabName">         
                <input type="hidden" name="prpLpersonLossJobCode">          
                <input type="hidden" name="prpLpersonLossJobName">          
                <input type="hidden" name="prpLpersonLossItemAddress">      
                <input type="hidden" name="prpLpersonLossUnit">             
                <input type="hidden" name="prpLpersonLossCurrency2" value="CNY">           
                <input type="hidden" name="prpLpersonLossCurrency1" value="CNY">        
                <input type="hidden" name="prpLpersonLossItemValue">         
                <input type="hidden" name="prpLpersonLossSumRest">          
                <input type="hidden" name="prpLpersonLossCurrency4" value="CNY">        
                <input type="hidden" name="prpLpersonLossFlag">    
                <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">                
              </td>  
                                                                 
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
          </tbody>
        </table>
      </span>
       
      <table class="common" align="center">
      <!--表示显示多行的-->
        <tr >
          <td class="common" colspan="4">
            <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                 name="PersonImg" onclick="showPage(this,spanPerson)">赔付人员信息<br>
            <span style="display:none"> 
              <table class="common" style="display:none" id="Person_Data" cellspacing="1" cellpadding="0">
                <tbody>              
        
           <tr>
          <td class="input" style="width:4%">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLpersonLossSerialNo" description="序号">
             </div>
         </td>
         <td class="subformtitle" style="width:92%">
         <table  cellpadding="0" cellspacing="1" class="common" >
            <tbody> 
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo"> 
                  <td class="title"  >人员姓名：</td>
                  <td class="input" >
                    <input class='common' style="width:160px" name="prpLpersonLossPersonName"
                    maxlength=20 description="人员姓名">                  
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title" >性别：</td>
                  <td class="input" >                                              
                    <select name="prpLpersonLossSex" class='common' style="width:160px">   
                       <option value="1">男</option>
                       <option value="2">女</option>                   
                    </select>      
                  </td>
                </tr>
                <tr>
                  <td class="title">年龄：</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:160px" 
                      maxlength="3" description="年龄">           
                  </td>
                  <td class="title">赔付合计(CNY)：</td>
                  <td class="input">
                    <input type="text" class='readonly' readonly style="width:160px" name="prpLpersonLossSumRealPay1">
                  </td>
                </tr> 
                 
                <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan="9">费用信息</td>
                              </tr>
                              <tr>
                      	  		  <td class="centertitle">险别</td>
                      	  		  <td class="centertitle">责任明细</td>
                      	  		  <td class="centertitle">币别</td>
                      	  		  <td class="centertitle">核损金额</td>      			        			  
                      	  		  <td class="centertitle">赔偿限额</td>
                      	  		  <td class="centertitle">赔偿比例%</td>
                      	  		  <td class="centertitle">免赔额</td>   
                      	  		  <td class="centertitle">赔付金额</td>    
                                <td class="centertitle" style="width:3%">  </td>                                           
                              </tr>  
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="titlesubsub" colspan="8" style="width:97%"></td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+" class="smallbutton" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);setFlagDanger();" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
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
        
                  </tbody> 
                </table>
              </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person');setFlagDanger();" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 
         </tbody>
       </table>
     </span>
          
     <span  id="spanPerson" style="display:none">
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
                 <input type="button" value="+" onclick="insertRow('person');setFlagDanger();" class="smallbutton" name="buttonPersonInsert" style="cursor: hand">
               </div>
             </td>
           </tr>
         </tfoot> 
         <tbody>         
         
<%
    int personNo = 0;
    PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)request.getAttribute("prpLpersonLossDto");
    if(prpLpersonLossDto.getPrpLpersonLossList()!=null){
      Iterator iterator = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator.hasNext()){
        PrpLpersonLossDto PrpLpersonLossDto1 =  (PrpLpersonLossDto)iterator.next();
        if(!(PrpLpersonLossDto1.getPersonNo() == personNo)){
%>       
           <tr>
          <td class="input" style="width:4%">
             <div align="center">
               <input class="readonlyNo" readonly name="prpLpersonLossSerialNo" description="序号" value="<%= personNo+1 %>">
             </div>
         </td>
         <td class="subformtitle" style="width:92%">
         <table  cellpadding="0" cellspacing="1" class="common" >
            <tbody> 
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo" value="<%= PrpLpersonLossDto1.getPersonNo() %>"> 
                  <td class="title"  >人员姓名：</td>
                  <td class="input" >
                    <input class='common' style="width:160px" name="prpLpersonLossPersonName" value="<%= PrpLpersonLossDto1.getPersonName() %>"
                    maxlength=20 description="人员姓名">                  
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title" >性别：</td>
                  <td class="input" >                                              
                   <select name="prpLpersonLossSex" class='common' style="width:160px">   
                       <option value="1" <%//加入性别判断 by qinyongli 
                                            if(PrpLpersonLossDto1.getSex().equals("1")){out.print("selected");} %>>男</option>
                       <option value="2" <%if(PrpLpersonLossDto1.getSex().equals("2")){out.print("selected");} %>>女</option>                   
                    </select>     
                  </td>
                </tr>
                <tr>
                  <td class="title">年龄：</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:160px"  value="<%= PrpLpersonLossDto1.getAge() %>"
                      maxlength="3" description="年龄">            
                  </td> 
                  <td class="title">赔付合计(CNY)：</td>
                  <td class="input">
                    <input type="text" class='readonly' readonly style="width:160px" name="prpLpersonLossSumRealPay1">
                  </td>
                </tr> 
                <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- 多行输入展现域 --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan="9">费用信息</td>
                              </tr>
                              <tr>
                      	  		  <td class="centertitle">险别</td>
                      	  		  <td class="centertitle">责任明细</td>
                      	  		  <td class="centertitle">币别</td>
                      	  		  <td class="centertitle">核损金额</td>      			        			  
                      	  		  <td class="centertitle">赔偿限额</td>
                      	  		  <td class="centertitle">赔偿比例%</td>
                      	  		  <td class="centertitle">免赔额</td>   
                      	  		  <td class="centertitle">赔付金额</td>   
                                <td class="centertitle" style="width:4%">  </td>                                           
                              </tr>  
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="titlesubsub" colspan="8" style="width:97%"></td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+" class="smallbutton" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot> 
                             
                            <tbody>
 <%
   Iterator iterator1 = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator1.hasNext()){ 
        PrpLpersonLossDto PrpLpersonLossDto2 =  (PrpLpersonLossDto)iterator1.next();
        if(PrpLpersonLossDto2.getPersonNo() == (personNo+1)){

%>                    
          <tr>   
                               
              <td class="inputsubsub">
                  <input type="hidden" name="personLossSerialNo" style="width:20px" value="<%= personNo+1 %>"> 
                  <input type="input" name="prpLpersonLossKindCode" class="codecode"   value="<%= PrpLpersonLossDto1.getKindCode() %>"
                        ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                        onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                  <input type="input" name="prpLpersonLossKindName" class="codename"  value="<%= PrpLpersonLossDto1.getKindName() %>"
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">             
              </td>
                     
              <td class="inputsubsub">                        
                <input name="prpLpersonLossLiabDetailCode" type="hidden"  value="<%= PrpLpersonLossDto2.getLiabDetailCode() %>"
                   ondblclick= " code_CodeSelect(this,'ChargeCode');"
                   onkeyup= " code_CodeSelect(this,'ChargeCode');">                                                   
                <input name="prpLpersonLossLiabDetailName" class="codename" style="width:70px"  value="<%= PrpLpersonLossDto2.getLiabDetailName() %>"
                  ondblclick= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
                  onkeyup= " code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"> 
              </td>                 
              <td class="inputsubsub">
                <input type="hidden" name="prpLpersonLossCurrency" value="<%= PrpLpersonLossDto2.getCurrency() %>" class="codecode"
                  ondblclick= "code_CodeSelect(this,'Currency');"
                  onkeyup= "code_CodeSelect(this,'Currency');">  
                <input class="input"  name="prpLpersonLossCurrencyName" value="<%= PrpLpersonLossDto2.getCurrencyName() %>" class="codename"
		             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
		             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
              </td>
              
              <td class="inputsubsub">
                <input name="prpLpersonLossSumLoss" class="common" style="width:70px" value="<%= PrpLpersonLossDto2.getSumLoss() %>">
              </td>
              <td class="inputsubsub">      
                <input name="prpLpersonLossAmount" class="common" style="width:70px" value="<%= PrpLpersonLossDto2.getAmount() %>">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossClaimRate" class="common" style="width:70px" value="<%= PrpLpersonLossDto2.getClaimRate() %>">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossDeductible" class="common" style="width:70px" value="<%= PrpLpersonLossDto2.getDeductible() %>">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossSumRealPay" class="common" style="width:70px" value="<%= PrpLpersonLossDto2.getSumRealPay() %>">
 
                <input type="hidden" name="prpLpersonLossUnitAmount"  value="<%= PrpLpersonLossDto2.getUnitAmount() %>">
                <input type="hidden" name="prpLpersonLossLossQuantity"  value="<%= PrpLpersonLossDto2.getLossQuantity() %>">
                <input type="hidden" name="prpLpersonLossFamilyName"  value="<%= PrpLpersonLossDto1.getFamilyName() %>">
                <input type="hidden" name="prpLpersonLossIndemnityDutyRate"  value="<%= PrpLpersonLossDto1.getIndemnityDutyRate() %>">                  
                <input type="hidden" name="prpLpersonLossDeductibleRate" value="<%= PrpLpersonLossDto1.getDeductibleRate() %>">
                <input type="hidden" name="prpLpersonLossItemKindNo" value="<%= PrpLpersonLossDto2.getItemKindNo() %>">       
                <input type="hidden" name="prpLpersonLossFamilyNo" value="<%= PrpLpersonLossDto2.getFamilyNo() %>">         
                <input type="hidden" name="prpLpersonLossIdentifyNumber" value="<%= PrpLpersonLossDto2.getIdentifyNumber() %>">   
                <input type="hidden" name="prpLpersonLossLiabCode" value="<%= PrpLpersonLossDto2.getLiabCode() %>">         
                <input type="hidden" name="prpLpersonLossLiabName" value="<%= PrpLpersonLossDto2.getLiabName() %>">         
                <input type="hidden" name="prpLpersonLossJobCode" value="<%= PrpLpersonLossDto2.getJobCode() %>">          
                <input type="hidden" name="prpLpersonLossJobName" value="<%= PrpLpersonLossDto2.getJobName() %>">          
                <input type="hidden" name="prpLpersonLossItemAddress" value="<%= PrpLpersonLossDto2.getItemAddress() %>">      
                <input type="hidden" name="prpLpersonLossUnit" value="<%= PrpLpersonLossDto2.getUnit() %>">             
                <input type="hidden" name="prpLpersonLossCurrency2" value="<%= PrpLpersonLossDto2.getCurrency2() %>">           
                <input type="hidden" name="prpLpersonLossCurrency1" value="<%= PrpLpersonLossDto2.getCurrency1() %>">        
                <input type="hidden" name="prpLpersonLossItemValue" value="<%= PrpLpersonLossDto2.getItemValue() %>">         
                <input type="hidden" name="prpLpersonLossSumRest" value="<%= PrpLpersonLossDto2.getSumRest() %>">          
                <input type="hidden" name="prpLpersonLossCurrency4" value="<%= PrpLpersonLossDto2.getCurrency4() %>">        
                <input type="hidden" name="prpLpersonLossFlag" value="<%= PrpLpersonLossDto2.getFlag() %>">    
                <input type="hidden" name="prpLpersonLossCurrency3"  value="<%= PrpLpersonLossDto2.getCurrency3() %>">
                
              </td>                                                       
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete" class="smallbutton"  onclick="deleteRowTable(this,'PersonFeeLoss',1,1)" value="-" readonly style="cursor: hand">
                </div>              
              </td>             
            </tr>
<%
    }
  }
%>                     
                            </tbody>
                          </table>  
                        </span>  
                      </td>
                    </tr>  
        
                  </tbody> 
                </table>
              </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person');setFlagDanger();" value="-" style="cursor: hand">
                </div>
              </td>                       
           </tr> 


<%
        personNo =   PrpLpersonLossDto1.getPersonNo();
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




