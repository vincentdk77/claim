<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-10-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
    <%--多行输入自定义JavaScript方法域--%>
        <%--多行输入自定义JavaScript方法域--%>
 
    <script language="javascript">
      //在下面加入本页自定义的JavaScript方法
 
        /*
        插入一条新的lLoss之后的处理（可选方法）
      */
      function afterInsertlLoss()
      {
        setPrpLlossDtoSerialNo();
      }
    
      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeletelLoss(field)
      {
        
        setPrpLlossDtoSerialNo();
      }
    
        /**
         * 设置setPrpLlossDtoSerialNo
         */
        function setPrpLlossDtoSerialNo(){
            var count=getElementCount("prpLlossDtoSerialNo");
            for(var i=0;i<count;i++)
            {
                //alert("看看什么时候运行?count="+count+"  i="+i); 
                if(count!=1){
                    fm.prpLlossDtoSerialNo[i].value=i;
                }
            }
        }
    </script>   
    
   <!--建立显示的录入条，可以收缩显示的-->
   <table class="common" align="center">
    <!--表示显示多行的-->
    <tr>
      <td class="subformtitle" colspan="4">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="lLossImg" onclick="showPage(this,spanlLoss)">赔付标的信息<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">   
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                  <tbody>  
                    <!--是否超过保单中的限额标志域-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->  
                    <input type='hidden' name="prpLlossDtoLicenseNo">
                    <input type='hidden' name='prpLlossDtoItemKindNo'> 
                    <input type='hidden' name='prpLlossDtoFamilyNo'> 
                    <input type='hidden' name="prpLlossDtoFeeTypeCode">
                    <input type='hidden' name="prpLlossDtoFeeTypeName"> 
                    <input type='hidden' name='prpLlossDtoFamilyName'> 
                    <input type='hidden' name='prpLlossDtoItemCode'> 
                    <input type='hidden' name='prpLlossDtoItemAddress'> 
                    <input type='hidden' name='prpLlossDtoBuyDate' value="2004/12/12"> 
                    <input type='hidden' name='prpLlossDtoDepreRate'> 
                    <input type='hidden' name='prpLlossDtoCurrency1' value="CNY"> 
                    <input type='hidden' name='prpLlossDtoCurrency4' value="CNY"> 
                    <input type='hidden' name='prpLlossDtoFlag'> 
                    <input type='hidden' name='prpLlossDtoUnit'> 
                    <input type="hidden" name="prpLlossDtoLossQuantity">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate">   
                      <tr>                             
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" 
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode');">                 
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" 
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                    
                        </td>                   
                        <td class="title" style="width:15%">保险项目名称：</td>
                        <td class="input" style="width:35%">
                          <input type='hidden' name='LossItemCode'>                                                                   
                          <input name="LossItemName" class='readonly' readonly>
                        </td>                
                      </tr>                         
                             
                      <tr>                             
                        <td class="title" style="width:15%">损失标的名称：</td>
                        <td class="input" style="width:85%" colspan="3">
                          <input name="prpLlossDtoLossName" class="common"  style="width:330px">                                                                                  
                        </td>                
                      </tr> 
                      <tr>                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px"  value="CNY"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px"  value="人民币"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                      <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoAmount" class='readonly' readonly> 
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px">
                        </td>                
                      </tr>   
                        
                      <tr>                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px"  value="CNY"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px"  value="人民币"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px"  value="CNY"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px"  value="人民币"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">免赔额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input">
                        </td>                 
                      </tr>  
                     </tbody>  
                   </table>     
               </td>
              <td class="input" style="width:4%">
              <div align="center">
                <input type=button name="buttonlLossDelete"  onclick="deleteRow(this,'lLoss')" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
            </tbody>
          </table>
        </span>
        
        <span  id="spanlLoss" style="display:none">
        <%-- 多行输入展现域 --%>
        <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="title" style="width:4%">序号</td>
                <td class="title" style="width:96%" colspan=2 >内容</td>
             </tr> 
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=2 style="width:96%">(按"+"号键增加险别信息，按"-"号键删除信息)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('lLoss')" name="buttonlLossInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr> 
           </tfoot> 
            
          <tbody>
 <% int index24=0;%>
<logic:notEmpty  name="prpLlossDto"  property="prpLlossList"> 
<logic:iterate id="lloss" name="prpLlossDto" property="prpLlossList">
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号" value="<bean:write name='lloss' property='serialNo'/>">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">                        
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                  <tbody>  
                    <!--是否超过保单中的限额标志域-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->  
                    <input type='hidden' name="prpLlossDtoLicenseNo" value="<bean:write name='lloss' property='licenseNo'/>">
                    <input type='hidden' name='prpLlossDtoItemKindNo' value="<bean:write name='lloss' property='itemKindNo'/>"> 
                    <input type='hidden' name='prpLlossDtoFamilyNo' value="<bean:write name='lloss' property='familyNo'/>"> 
                  
                    <input type='hidden' name="prpLlossDtoFeeTypeCode" value="<bean:write name='lloss' property='feeTypeCode'/>">
                    <input type='hidden' name="prpLlossDtoFeeTypeName" value="<bean:write name='lloss' property='feeTypeName'/>">
                                   
                    <input type='hidden' name='prpLlossDtoFamilyName' value="<bean:write name='lloss' property='familyName'/>"> 
                    <input type='hidden' name='prpLlossDtoItemCode' value="<bean:write name='lloss' property='itemCode'/>"> 
                    <input type='hidden' name='prpLlossDtoItemAddress' value="<bean:write name='lloss' property='itemAddress'/>"> 
                    <input type='hidden' name='prpLlossDtoBuyDate' value="<bean:write name='lloss' property='buyDate'/>"> 
                    <input type='hidden' name='prpLlossDtoDepreRate' value="<bean:write name='lloss' property='depreRate'/>"> 
                    <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='lloss' property='currency1'/>"> 
                    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='lloss' property='currency4'/>"> 
                    <input type='hidden' name='prpLlossDtoFlag' value="<bean:write name='lloss' property='flag'/>"> 
                    <input type='hidden' name='prpLlossDtoUnit' value="<bean:write name='lloss' property='unit'/>"> 
                    <input type="hidden" name="prpLlossDtoLossQuantity"   value="<bean:write name='lloss' property='lossQuantity'/>">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice" value="<bean:write name='lloss' property='unitPrice'/>">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate" value="<bean:write name='lloss' property='indemnityDutyRate'/>">   
                      <tr>                             
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode');">                  
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                     
                        </td>                   
                        <td class="title" style="width:15%">保险项目名称：</td>
                        <td class="input" style="width:35%">
                          <input type='hidden' name='LossItemCode'>                                                                   
                          <input name="LossItemName" class='readonly' readonly>
                        </td>                
                      </tr>                         
                             
                      <tr>                             
                        <td class="title" style="width:15%">损失标的名称：</td>
                        <td class="input" style="width:85%" colspan="3">
                          <input name="prpLlossDtoLossName" class="common"  style="width:330px" value="<bean:write name='lloss' property='lossName'/>">                                                                                  
                        </td>                
                      </tr> 
                      <tr>                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currencyName'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                      <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoAmount" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>"> 
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">
                        </td>                
                      </tr>   
                        
                      <tr>                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency2'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency2Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumLoss' format='##0.00'/>">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumRest' format='##0.00'/>">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='claimRate' format='##0.0000'/>">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='deductibleRate' format='##0.0000'/>">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency3'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency3Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">免赔额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" value="<bean:write name='lloss' property='deductible' format='##0.00'/>">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='sumRealPay' format='##0.00'/>">
                        </td>                 
                      </tr>  
                     </tbody>  
                   </table>               
               </td>
              <td class="input" style='width:4%'>
              <div align="center">
                <input type=button name="buttonlLossDelete"  onclick="deleteRow(this,'lLoss')" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
           
        <%    index24++;%>
           
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td>
    </tr>
  </table>



