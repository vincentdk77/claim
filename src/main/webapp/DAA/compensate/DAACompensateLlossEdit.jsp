<%--
****************************************************************************
* DESC       ：添加标的赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>        
<%@page import="java.util.*"%>

   <!--建立显示的录入条，可以收缩显示的-->     
      <span style="display:none"> 
        <table class="common" style="display:none" id="CompensateLoss_Data" cellspacing="1" cellpadding="5">
<%
  ArrayList prpCitemKindDtoListInit = (ArrayList)request.getAttribute("prpCitemKindDtoListInit"); 
  PrpLlossDto prpLlossDtoTemp = null;
    ArrayList prpLlossList = (ArrayList)prpLlossDto.getPrpLlossList(); 
     for (int i = 0; i < prpCitemKindDtoListInit.size(); i++) { 
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindDtoListInit.get(i);  
        System.out.println("------kinecoce-----"+prpCitemKindDto.getKindCode());
%>        
          <tbody id="<%= prpCitemKindDto.getKindCode() %>"> 
            <tr>            
              <td class="inputsubsub" style="width:10%">      
                <input name="licenseNo" class="input" style="width:90%">                               
                <input type="hidden" name="lossDtoSerialNo" style="width:10px">             
                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpCitemKindDto.getKindCode() %>"  onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);">          
                <input type="hidden" name=prpLlossDtoKindName value="<%= prpCitemKindDto.getKindName() %>">                           
                                            
              </td>                                  
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoLossName" maxlength=40  class="common" style="width:90%" value="<%= prpCitemKindDto.getItemDetailName() %>">
              </td> 
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoFeeTypeCode" class='codecode' style="width:30%" value=" "
                  ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                  onchange="code_CodeChange(this, 'PropertyFeeType');"
                  onkeyup= "code_CodeSelect(this,'PropertyFeeType');" 
                  onblur= "code_CodeChange(this,'PropertyFeeType',1);getValue(this);">
                <input name="prpLlossDtoFeeTypeName" class='codename' style="width:60%" value=" "
                  ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                  onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
                  onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                  onblur= "getValue(this);">
                
              </td>    
     
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoSumLoss" class="common" style="width:90%"  onchange="calRealpay(this);calLoss();"> 
              </td>
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoSumRest" class="common" style="width:90%" onchange="calRealpay(this);calLoss();" onfocus="checkInputPower(this);">
              </td>                  
      
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoClaimRate"  class="common" style="width:90%" onchange="calRealpay(this);" value="100">
              </td>                
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoIndemnityDutyRate" class="common" style="width:90%" onchange="calRealpay(this);" value="100">
              </td>
  
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoDeductible" type="hidden"  value="<%= prpCitemKindDto.getDeductible() %>">
                <input name="prpLlossDtoDeductibleRate" class='readonly' readonly style="width:90%" onchange="calRealpay(this);" onblur="return checkLossDeductibleRate(this);"  value="<%= prpCitemKindDto.getDeductibleRate() %>">
              </td>                            
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:90%" readonly onchange="calFund();" value="">
                <input type="hidden" name="prpLlossDtoFamilyNo">  
                <input type="hidden" name="prpLlossDtoItemKindNo"> 
                <input type='hidden' name='prpLlossDtoFamilyName'> 
                <input type='hidden' name='prpLlossDtoItemCode'> 
                <input type='hidden' name='prpLlossDtoItemAddress'> 
                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="人民币">
                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12"> 
                <input type='hidden' name='prpLlossDtoDepreRate'> 
                <input type='hidden' name='prpLlossDtoCurrency' value="CNY"> 
                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY"> 
                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY"> 
                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY"> 
                <input type='hidden' name='prpLlossDtoFlag'> 
                <input type='hidden' name='prpLlossDtoUnit'>  
                <input type="hidden" name="prpLlossDtoAmount"  value="<%= prpCitemKindDto.getAmount() %>">   
                <input type="hidden" name="prpLlossDtoItemValue"  value="<%= prpCitemKindDto.getAmount() %>">                           
                <input type="hidden" name="prpLlossDtoUnitPrice"  value="<%= prpCitemKindDto.getUnitAmount() %>"> 
                <input type="hidden" name="prpLlossDtoLossQuantity"  value="<%= prpCitemKindDto.getQuantity() %>"> 
              </td>   
              <td style="width:5%">                             
                <input type="button" name="button_Loss_Refresh" class=bigbutton style="display:none" value="刷新不计免赔" onclick="refreshLoss(this);">      
              </td>
              <td class="inputsubsub" style='width:4%'>  
              <div align="center">
                <input type=button name="buttonCompensateLossDelete" class=smallbutton  onclick="deleteRowTableL(this,'CompensateLoss',1,1)" value="-" readonly style="cursor: hand">
              </div> 
              </td>  
            </tr>
          </tbody>    
<%
  }
%>    <input type='hidden' name='prpCitemKindCount' value="<%= prpCitemKindDtoListInit.size() %>">      
        </table> 
      </span>
       
      <table class="common" cellpadding="5" cellspacing="1">
      <!--表示显示多行的-->
        <tr>
          <td class="common" colspan="4" style="text-align:left">
            <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif" name="lLossImg" onclick="showPage(this,spanlLoss);changeCompensateFlag('1');">赔付标的信息<br>                       
             

            <span style="display:none"> 
              <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="5">
                <tbody>   
                  <tr> 
                    <td class="input" style="width:6%">               
                      <input type="input" name=prpLlossDtoKindCodeShow class="codecode" style="width:25px">          
                      <input type="input" name=prpLlossDtoKindNameShow class="codename" style="width:5px">  
                      <input type="hidden" style="width:90%" name="prpLlossDtoSerialNo">        
                   </td> 
                   <td class="common" style="width:90%"> 
                      <span  id="spanCompensateLoss"> 
                        <%-- 多行输入展现域 --%>
                        <table id="CompensateLoss" name="CompensateLoss" cellpadding="0" cellspacing="1" border="0" class="title" style="width:100%">
                          <thead>  
                
                          </thead> 
                          
                          <tfoot>
                            <tr>
                              <td class="titlesubsub" colspan="10" ></td>
                              <td class="titlesubsub" align="right" style="width:4%"> 
                                <div align="center">
                                  <input type="button" value="+" class=smallbutton onclick="insertRowTableL('CompensateLoss','CompensateLoss_Data',this);" name="buttonCompensateLossInsert" readonly style="cursor: hand">
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
           </span>
            
             <span  id="spanlLoss" style="display:none">
               <%-- 多行输入展现域 --%>
               <table id="lLoss" class="common" cellpadding="5" cellspacing="1">
                 <thead>
                   <tr>
                     <td class="title" style="width:4%">险别</td>
                     <td class="title" style="width:96%">
                      <table class=cellpadding="5" cellspacing="1" class="title">
                        <tr class=listtitle>
                              <td  style="width:10%">号牌号码</td> 
                              <td  style="width:10%">损失财物名称</td> 
                              <td  style="width:10%">损失明细</td>  
                              <td  style="width:10%">核定损失</td>  
                              <td  style="width:10%">剔除金额</td>  
                              <td  style="width:10%">赔偿比例%</td>   
                              <td  style="width:10%">责任比例%</td>  
                              <td  style="width:10%">免赔率%</td>  
                              <td  style="width:10%">赔偿金额</td>  
                              <td  style="width:5%"></td>    
                              <td  style="width:5%"><input type="button" class=button name="button_Loss_Collect" value="汇总" onclick="return showLossCollect();"></td>  
                        </tr> 
                      </table>
                     </td>
                   </tr>
                 </thead> 
                  
                 <tfoot>                    
                 
                 </tfoot> 
                 
                 <tbody> 
<%  PrpLlossDto prpLlossDto = (PrpLlossDto)request.getAttribute("prpLlossDto"); 
     
System.out.println("-------size-"+prpCitemKindDtoListInit.size()+"|"+prpLlossList.size());    
     for (int i = 0; i < prpCitemKindDtoListInit.size(); i++) {
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindDtoListInit.get(i);  
%>    
                  <tr> 
                    <td class="input" style="width:6%">                 
                      <input type="input" name=prpLlossDtoKindCodeShow class="readonly" readonly style="width:25px"  value="<%= prpCitemKindDto.getKindCode() %>">                                  
                      <input type="input" name=prpLlossDtoKindNameShow class="readonly" readonly style="width:55px"  value="<%= prpCitemKindDto.getKindName() %>">   
                      <input type="hidden" name="prpLlossDtoSerialNo"  style="width:10px"  value="<%= i+1 %>">         
                   </td>    
                   <td class="common" style="width:90%">  
                      <span  id="spanCompensateLoss"> 
                        <%-- 多行输入展现域 --%>
                        <table id="CompensateLoss" name="CompensateLoss" class=common cellpadding="5" cellspacing="1">
                          <thead> 
                          </thead>
                          
                          <tfoot>
                            <tr>
                              <td class="titlesubsub" colspan="10" ></td>
                              <td class="titlesubsub" align="right" style="width:4%"> 
                                <div align="center">
                                  <input type="button" value="+" class=smallbutton onclick="insertRowTableL('CompensateLoss','CompensateLoss_Data',this,'<%= prpCitemKindDto.getKindCode() %>');" name="buttonCompensateLossInsert" readonly style="cursor: hand">
                                </div>
                              </td>
                            </tr>
                          </tfoot> 
                          <tbody>                                  
<%

        if(prpLlossList!=null&&prpLlossList.size()>0){
System.out.println("-------size2-"+prpLlossList.size()+"|"+prpLlossList.size());  
        for (int j = 0; j < prpLlossList.size(); j++) { 
          prpLlossDtoTemp = (PrpLlossDto)prpLlossList.get(j);
          if(prpLlossDtoTemp.getKindCode().equals(prpCitemKindDto.getKindCode())){
%>                     
                            <tr>             
                              <td class="inputsubsub" style="width:10%">   
                                <input name="licenseNo" class="input" style="width:90%" value="<%= prpLlossDtoTemp.getLicenseNo() %>">                         
                                <input type="hidden" name="lossDtoSerialNo"  style="width:10px" value="<%= i+1 %>">
                                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpLlossDtoTemp.getKindCode() %>" onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);">          
                                <input type="hidden" name=prpLlossDtoKindName value="<%= prpLlossDtoTemp.getKindName() %>">
                              </td>                                  
                              <td class="inputsubsub" style="width:10%"> 
                                <input name="prpLlossDtoLossName" class="input" style="width:90%" value="<%= prpLlossDtoTemp.getLossName() %>">
                              </td>         
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoFeeTypeCode" class='codecode' style="width:30%" value="<%= prpLlossDtoTemp.getFeeTypeCode() %>" 
                                  ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                                  onchange="code_CodeChange(this, 'PropertyFeeType');"
                                  onkeyup= "code_CodeSelect(this,'PropertyFeeType');" 
                                  onblur= "code_CodeChange(this,'PropertyFeeType',1);getValue(this);">
                                <input name="prpLlossDtoFeeTypeName" class='codename' style="width:60%" value="<%= prpLlossDtoTemp.getFeeTypeName() %>"
                                  ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                                  onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
                                  onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                                  onblur= "getValue(this);">
                                 
                              </td>    
                     
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoSumLoss" class="common" style="width:90%"  onchange="calRealpay(this);calLoss();" value="<%= prpLlossDtoTemp.getSumLoss() %>"> 
                              </td>
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoSumRest" class="common" style="width:90%" onchange="calRealpay(this);calLoss();" onfocus="checkInputPower(this);" value="<%= prpLlossDtoTemp.getSumRest() %>">
                              </td>                  
                      
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoClaimRate"  class="common" style="width:90%" onchange="calRealpay(this);" value="<%= prpLlossDtoTemp.getClaimRate() %>">
                              </td>                
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoIndemnityDutyRate" class="common" style="width:90%" onchange="calRealpay(this);" value="<%= prpLlossDtoTemp.getIndemnityDutyRate() %>">
                              </td>
                  
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoDeductible" type="hidden" value="<%= prpLlossDtoTemp.getDeductible() %>">
                                <input name="prpLlossDtoDeductibleRate" class='readonly' readonly style="width:90%" onchange="calRealpay(this);" onblur="return checkLossDeductibleRate(this);" 
                                value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDeductibleRate()) %>">
                              
                              </td>                            
                              <td class="inputsubsub" style="width:10%">
                                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:90%" readonly onchange="calFund();" value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getSumRealPay()) %>">
                                <input type="hidden" name="prpLlossDtoFamilyNo" value="<%= prpLlossDtoTemp.getFamilyNo() %>">  
                                <input type="hidden" name="prpLlossDtoItemKindNo" value="<%= prpLlossDtoTemp.getItemKindNo() %>"> 
                                <input type='hidden' name='prpLlossDtoFamilyName' value="<%= prpLlossDtoTemp.getFamilyName() %>"> 
                                <input type='hidden' name='prpLlossDtoItemCode' value="<%= prpLlossDtoTemp.getItemCode() %>"> 
                                <input type='hidden' name='prpLlossDtoItemAddress' value="<%= prpLlossDtoTemp.getItemAddress() %>"> 
                                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="人民币">
                                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12"> 
                                <input type='hidden' name='prpLlossDtoDepreRate' value="<%= prpLlossDtoTemp.getDepreRate() %>"> 
                                <input type='hidden' name='prpLlossDtoCurrency' value="CNY"> 
                                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY"> 
                                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY"> 
                                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY"> 
                                <input type='hidden' name='prpLlossDtoFlag' value="<%= prpLlossDtoTemp.getFlag() %>"> 
                                <input type='hidden' name='prpLlossDtoUnit' value="<%= prpLlossDtoTemp.getUnit() %>"> 
                                <input type="hidden" name="prpLlossDtoAmount" value="<%= prpLlossDtoTemp.getAmount() %>">  
                                <input type="hidden" name="prpLlossDtoItemValue" value="<%= prpLlossDtoTemp.getItemValue() %>">                           
                                <input type="hidden" name="prpLlossDtoUnitPrice" value="<%= prpLlossDtoTemp.getUnitPrice() %>"> 
                                <input type="hidden" name="prpLlossDtoLossQuantity" value="<%= prpLlossDtoTemp.getLossQuantity() %>"> 
                              </td>                               
                              <td style="width:5%">                             
                                <input type="button" name="button_Loss_Refresh" class=bigbutton style="display:none" value="刷新不计免赔" onclick="refreshLoss(this);">      
                              </td>
                              <td class="inputsubsub" style='width:4%'> 
                              <div align="center">
                                <input type=button name="buttonCompensateLossDelete"  class=smallbutton onclick="deleteRowTableL(this,'CompensateLoss',1,1)" value="-" readonly style="cursor: hand">
                              </div> 
                              </td>  
                            </tr>    
<%
          }//if equals()
        }//for
      }//prpLlossList!=null
%>       
                                                 
                          </tbody>
                        </table>   
                      </span>  
                   </td>
              </tr>  
<%
  }//for prpCitemKindDtoListInit
%>        
         </tbody>
       </table>  
     </span>    
   </td> 
 </tr> 
</table>




