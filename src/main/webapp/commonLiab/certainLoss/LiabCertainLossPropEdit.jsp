<%--
****************************************************************************
* DESC       ：添加驾驶员信息页面
* AUTHOR     ：weishixin
* CREATEDATE ： 2004-03-03
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 

   <!--建立显示的录入条，可以收缩显示的-->   
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertProp()
      {
        setPrpLpropSerialNo();
      } 
     
      /* 
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteProp(field)
      {        
        setPrpLpropSerialNo();
      }
     
      /**
       * 设置setPrpLpropSerialNo
       */
      function setPrpLpropSerialNo(){
          var count=getElementCount("prpLpropSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("看看什么时候运行?count="+count+"  i="+i); 
              if(count!=1){
                fm.prpLpropSerialNo[i].value=i;
                //alert(i);
              }
          }
      }
      
     function calPropLoss(){
         var count = getElementCount("prpLpropSerialNo");
         var sumPropLoss      = 0.0;//受损金额合计
         var sumDefLoss       = 0.0;//定损金额合计
         var sumReject        = 0.0;//剔除金额合计
         var unitPropLoss     = 0.0;//核定损失
         var itemDefLoss     = 0.0//核定标的损失
         var unitReject       = 0.0;//剔除金额
         var unitPrice        = 0.0;//单价
         var DepreRate        = 0.0;//折旧率
         var unitLossQuantity = 0.0;//受损数量
         var LossRate         = 0.0;//损失率
         for(var i=1;i<count;i++){
         unitPrice        = parseFloat(fm.prpLpropUnitPrice[i].value);
         unitLossQuantity = parseFloat(fm.prpLpropLossQuantity[i].value);
         DepreRate        = parseFloat(fm.prpLpropDepreRate[i].value);
         unitReject       = parseFloat(fm.prpLpropSumReject[i].value);
         LossRate         = parseFloat(fm.prpLpropLossRate[i].value);
            if(isNaN(unitPrice)){
               unitPrice = 0.0;
            }
            if(isNaN(unitLossQuantity)){
               unitLossQuantity = 0.0;
            }
            if(isNaN(DepreRate)){
               DepreRate = 0.0;
            }
            if(isNaN(unitReject)){
               unitReject = 0.0;
            }
            if(isNaN(LossRate)){
               LossRate = 0.0;
            }
            unitPropLoss                  = unitPrice*unitLossQuantity*(100-DepreRate)/100;//核定损失
            fm.prpLpropSumLoss[i].value   = mathRound(unitPropLoss);
            
            itemDefLoss                   = (unitPropLoss-unitReject)*LossRate/100; //核定标的损失
            fm.prpLpropSumDefLoss[i].value = mathRound(itemDefLoss);
            sumPropLoss+=unitPropLoss;
            sumReject  +=unitReject;
            sumDefLoss +=itemDefLoss;
         }
         fm.prpLpropSumSumLoss.value    = mathRound(sumPropLoss);
         fm.prpLpropSumSumReject.value  = mathRound(sumReject);
         fm.prpLpropSumSumDefLoss.value = mathRound(sumDefLoss);
      }
    </script>    
		 <%@page import="com.sinosoft.sysframework.common.util.*" %>
  <span  id="SpanProp">   
    <!--建立显示的录入条，可以收缩显示的-->   
    <table class="common" align="center" style="width:100%"  bgcolor="#2D8EE1" cellspacing="1" cellpadding="0"> 
    <!--表示显示多行的-->  
      <tr> 
        <td class="subformtitle" colspan="4">财产损失清单信息<br>
          <span  style="display:none">
            <table width="100%" cellpadding="0" cellspacing="1" class="common"  id="Prop_Data" style="display:none">
              <tbody>  
                <tr>
                  <td class="input" style="width:3%">
                   <div align="center">
                     <input class="readonlyNo" readonly name="prpLpropSerialNo" description="序号"> 
                   </div>
                  </td>
                  <td class="subformtitle"  >
                    <table  cellpadding="0" cellspacing="1" class="common">
                    
                    
             <% 
                 String strRiskCode = (String)request.getAttribute("riskCode");
              if("1528".equals(strRiskCode)){ %>
	                   <tr>
	                       <td class="title" style="width:15%">车辆信息：</td>
                           <td class="input"  colspan="3">    
			               <input type=text name="prpLpropBrandCode" title="车辆厂牌型号" 
			               class="codecode"   style='width:130px' 
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');">
			               
			               <input type=text name="prpLpropCarNumber" title="车辆编号" 
			               class="codecode"   style='width:130px' 
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');">
			                 
			               <input type="hidden" name = "prpLprop1528FamilyNo" >
			              </td>
		               </tr>
                    <% }%>
                    
                    
                      <tr>
                        <td class="title" style="width:15%">险别：</td>
                        <td class="input" style='width:35%'>                          
                          <input type="input" name="prpLpropKindCode" class="codecode" style='width:60px'
                              ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2,3');"
                              onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2,3');">   
                          <input type="input" name="prpLpropKindName" class="codename" style='width:120px'
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1,2','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1,2','always','none','post');">  
                              
                        </td>
                        <td class="title" style="width:15%">项目名称：</td>
                        <td class="input" style="width:35%">
                          <input type="hidden" name="prpLpropItemKindNo">
                           <input name="prpLpropLossItemName" class="readonly">
                        </td>
                      </tr>
                      <tr>
                        <td class="title">损失项目：</td>
                        <td class="input" colspan="3">
                            <input class="input" style='width:190px' name="prpLpropRemark"><!-- 和辉泉确认暂时用remark字段存放损失项目 -->
                          <!--   <input type="input" name="prpLpropItemDetailName" class=common style='width:300px'  readonly>-->
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">币别：</td>   
                        <td class="input">
                          <input class="input" style='width:30px' name="prpLpropCurrency" value="CNY" class="codecode"
                            ondblclick= "code_CodeSelect(this,'Currency');"
                            onkeyup= "code_CodeSelect(this,'Currency');">  
                          <input class="input" style='width:90px' name="prpLpropCurrencyName" value="人民币" class="codecode"
        			             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
                          </td>
                        <td class="title">&nbsp;</td> 
                        <td class="input">
                          <%--<html:select name="prpLpropDto" property="feeTypeCode" >
                             <html:option value="01">修理费</html:option> 
                             <html:option value="02">材料费</html:option>   
                          </html:select>--%>                      
                          <input type="hidden" name="feeTypeCode" class="codecode" style='width:60px'
                              ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                              onkeyup= "code_CodeSelect(this,'PropertyFeeType');">   
                          <input type="hidden" name="prpLpropFeeTypeName" class="codename" style='width:120px'
                                 ondblclick="code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');"
                                 onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');">  
                                
                        </td> 

                      </tr> 
                      
                      <tr>
                        <td class="title">单价：</td>
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropUnitPrice" onblur="calPropLoss();">
                        </td>
                        <td class="title">受损数量：</td>   
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropLossQuantity" onblur="calPropLoss();">
                        </td>
                      </tr>   
                      
                      <tr>
                        <td class="title">折旧率：</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropDepreRate" onblur="calPropLoss();">%
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropSumLoss">
                        </td>
                        <td class="title">剔除金额：</td>   
                        <td class="input"><input class="input" style='width:90px' name="prpLpropSumReject" onblur="calPropLoss();"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">损失率：</td>
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropLossRate" onblur="calPropLoss();">%
                        </td>
                        <td class="title">核定标的损失：</td>   
                        <td class="input"><input class="input" style='width:90px' name="prpLpropSumDefLoss"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">剔除原因：</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropRejectReason">
                        </td>
                      </tr>  
                      
                     <!--  <tr>
                        <td class="title">备注：</td>
                        <td class="input" colspan="3">--> 
                          <input type="hidden" name="prpLpropItemCode">
                          <input type="hidden" name="prpLpropFamilyNo">
                          <input type="hidden" name="prpLpropFamilyName">
                          <input type="hidden" name="prpLpropLossItemCode" value="-1">
                          <input type="hidden" name="prpLpropUnit">
                          <input type="hidden" name="prpLpropBuyDate">
                          <input type="hidden" name="prpLpropVeriRemark">        
                          <input type="hidden" name="prpLpropVeriUnitPrice"> 
                          <input type="hidden" name="prpLpropVeriLossQuantity">
                          <input type="hidden" name="prpLpropVeriUnit">        
                          <input type="hidden" name="prpLpropVeriDepreRate">   
                          <input type="hidden" name="prpLpropVeriSumLoss">     
                          <input type="hidden" name="prpLpropVeriSumReject">   
                          <input type="hidden" name="prpLpropVeriRejectReason">
                          <input type="hidden" name="prpLpropVeriLossRate">    
                          <input type="hidden" name="prpLpropVeriSumDefLoss">  
                          <input type="hidden" name="prpLpropFlag">   
                    <!--</td>
                      </tr>       -->               
                    </table>
                  </td>
                  <td class="input" style='width:4%'>
                    <div align="center">
                      <input type=button name="buttonPropDelete"   class="smallbutton" onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                    </div>
                  </td>   
                </tr>
              </tbody> 
            </table>
            </span> 
  
  
          <span  id="spanProp">
          <%-- 多行输入展现域 --%>
          <table  class="common" id="Prop" align="center" cellspacing="1" cellpadding="0">
            <thead>
              <tr>
                <td class="title" style="width:4%">序号</td>
                <td class="title" style="width:96%" colspan=2 >内容</td>
              </tr>                        
            </thead>
            <tfoot> 
              <tr>
                <td class="title" colspan=2 style="width:96%">(按"+"号键增加财产损失清单信息，按"-"号键删除信息)</td>
                <td class="title" align="right" style="width:4%">
                  <div align="center">
                    <input type="button"  class="smallbutton"  value="+" onclick="insertRow('Prop')" name="buttonDriverInsert" style="cursor: hand">
                  </div>
                </td>                                  
              </tr>
            </tfoot>  
            <tbody>
          
<% indexCertainLoss=0;%>
<logic:notEmpty  name="prpLpropDto"  property="propList"> 
<logic:iterate id="prpLpropDto1" name="prpLpropDto" property="propList">
                <tr>
                  <td class="input" style="width:3%">
                   <div align="center">
                     <input class="readonlyNo" readonly name="prpLpropSerialNo" description="序号" value="<bean:write name='prpLpropDto1' property='serialNo'/>"> 
                   </div>
                  </td>
                  <td class="subformtitle"  >
                    <table  cellpadding="0" cellspacing="1" class="common">
                    
                    <%                  
                     if("1528".equals(strRiskCode)){
                   %>
	                   <tr>
	                      <td class="title" style="width:15%">车辆信息：</td>
                          <td class="input"  colspan="3">     
			               <input type=text name="prpLpropBrandCode" title="车辆厂牌型号" 
			               class="codecode"   style='width:130px'  value="<bean:write name='prpLpropDto1' property='modelNo'/>"
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');">
			               
			               <input type=text name="prpLpropCarNumber" title="车辆编号" 
			               class="codecode"  style='width:130px'  value="<bean:write name='prpLpropDto1' property='licenseNo'/>"
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');">
			                 
			               <input type = "hidden" name = "prpLprop1528FamilyNo"  value="<bean:write name='prpLpropDto1' property='familyNo'/>">
			              </td>
		               </tr>
                    <% }%>
                    
                    
                      <tr>
                        <td class="title" style="width:15%">险别：</td>
                        <td class="input" style='width:35%'>                           
                          <input type="input" name="prpLpropKindCode" class="codecode" style='width:60px'  value="<bean:write name='prpLpropDto1' property='kindCode'/>"
                              ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2,3');"
                              onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2,3');">   
                          <input type="input" name="prpLpropKindName" class="codename" style='width:120px'  value="<bean:write name='prpLpropDto1' property='kindName'/>"
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1,2','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1,2','always','none','post');">  
                               
                        </td>
                        <td class="title" style="width:15%">项目名称：</td>
                        <td class="input" style="width:35%">
                           <input type="hidden" name="prpLpropItemKindNo" value="<bean:write name='prpLpropDto1' property='itemKindNo'/>"> 
                          <input name="prpLpropLossItemName"   value="<bean:write name='prpLpropDto1' property='lossItemName'/>" class="readonly" readonly>
                        </td>
                      </tr>
                      <tr> 
                        <td class="title">损失项目：</td>
                        <td class="input" colspan="3">
                           <input class="input" style='width:190px' name="prpLpropRemark" value="<bean:write name='prpLpropDto1' property='remark'/>">
                           <!-- <input type="input" name="prpLpropItemDetailName"  class=common style='width:300px'> --> 
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">币别：</td>   
                        <td class="input">
                          <input type="input" style='width:30px' name="prpLpropCurrency"  value="<bean:write name='prpLpropDto1' property='currency'/>"  class="codecode"
                            ondblclick= "code_CodeSelect(this,'Currency');"
                            onkeyup= "code_CodeSelect(this,'Currency');">      
                          <input type="input" style='width:90px' name="prpLpropCurrencyName"  value="<bean:write name='prpLpropDto1' property='currencyName'/>" class="codename"
          			             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                          </td> 
                        <td class="title">&nbsp;</td>   
                        <td class="input">                       
                          <input type="hidden" name="feeTypeCode" class="codecode" style='width:60px'  value="<bean:write name='prpLpropDto1' property='feeTypeCode'/>"
                              ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                              onkeyup= "code_CodeSelect(this,'PropertyFeeType');">   
                          <input type="hidden" name="prpLpropFeeTypeName" class="codename" style='width:120px'  value="<bean:write name='prpLpropDto1' property='feeTypeName'/>"
                                 ondblclick="code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');"
                                 onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');">  
                                
                        </td>

                      </tr>  
                      
                      <tr>
                        <td class="title">单价：</td>
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropUnitPrice" value="<bean:write name='prpLpropDto1' property='unitPrice'/>" onblur="calPropLoss();">
                        </td>
                        <td class="title">受损数量：</td>   
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropLossQuantity" value="<bean:write name='prpLpropDto1' property='lossQuantity'/>" onblur="calPropLoss();">
                        </td>
                      </tr>   
                      <tr>
                        <td class="title">折旧率：</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropDepreRate" value="<bean:write name='prpLpropDto1' property='depreRate'/>" onblur="calPropLoss();">%
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropSumLoss" value="<bean:write name='prpLpropDto1' property='sumLoss'/>">
                        </td>
                        <td class="title">剔除金额：</td>   
                        <td class="input"><input class="input" style='width:90px' name="prpLpropSumReject" value="<bean:write name='prpLpropDto1' property='sumReject'/>" onblur="calPropLoss();"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">损失率：</td>
                        <td class="input">
                          <input class="input" style='width:90px' name="prpLpropLossRate" value="<bean:write name='prpLpropDto1' property='lossRate'/>" onblur="calPropLoss();">%
                        </td>
                        <td class="title">核定标的损失：</td>   
                        <td class="input"><input class="input" style='width:90px' name="prpLpropSumDefLoss" value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">剔除原因：</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropRejectReason" value="<bean:write name='prpLpropDto1' property='rejectReason'/>">
                        </td>
                      </tr>  
                      <tr>
                        <!--<td class="title">备注：</td>
                        <td class="input" colspan="3">  -->
                         <input type="hidden" name="prpLpropItemCode" value="<bean:write name='prpLpropDto1' property='itemCode'/>">
                          <input type="hidden" name="prpLpropFamilyNo" value="<bean:write name='prpLpropDto1' property='familyNo'/>">
                          <input type="hidden" name="prpLpropFamilyName" value="<bean:write name='prpLpropDto1' property='familyName'/>">
                          <input type="hidden" name="prpLpropLossItemCode" value="<bean:write name='prpLpropDto1' property='lossItemCode'/>">
                          <input type="hidden" name="prpLpropUnit" value="<bean:write name='prpLpropDto1' property='unit'/>">
                          <input type="hidden" name="prpLpropBuyDate" value="<bean:write name='prpLpropDto1' property='buyDate'/>">
                          <input type="hidden" name="prpLpropVeriRemark" value="<bean:write name='prpLpropDto1' property='veriRemark'/>">        
                          <input type="hidden" name="prpLpropVeriUnitPrice" value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                          <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                          <input type="hidden" name="prpLpropVeriUnit" value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                          <input type="hidden" name="prpLpropVeriDepreRate" value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                          <input type="hidden" name="prpLpropVeriSumLoss" value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">     
                          <input type="hidden" name="prpLpropVeriSumReject" value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">   
                          <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                          <input type="hidden" name="prpLpropVeriLossRate" value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
                          <input type="hidden" name="prpLpropVeriSumDefLoss" value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">  
                          <input type="hidden" name="prpLpropFlag" value="<bean:write name='prpLpropDto1' property='flag'/>">   
                       <!--  </td>
                      </tr>  --> 
                      
                                         
                    </table>
                  </td>
                  <td class="input" style='width:4%'>
                    <div align="center">
                      <input type=button name="buttonPropDelete"  class="smallbutton" onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                    </div>
                  </td>   
                </tr>
                              
<%    indexCertainLoss++; %>
      </logic:iterate> 
      </logic:notEmpty> 
            
            </tbody>
          </table>
       </span>
      </td>
   </tr>
</table>

  <table border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#2D8EE1" class="title" width="100%">
    <tr>
      <td class='title' width="33%">受损金额合计:<input class='readonly' readonly="true" style='width:80px' name='prpLpropSumSumLoss'>
      </td>    
      <td class='title' width="33%">剔除金额合计:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumReject'>
      </td>  
      <td class='title' width="33%">定损金额合计:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumDefLoss'>
      </td>        
    </tr>
  </table>  
</span>