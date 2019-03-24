<%--
****************************************************************************
* DESC       ：财产损失清单页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%> 

   <!--建立显示的录入条，可以收缩显示的-->   
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertprop()
      {
        setPrpLpropSerialNo();
      }
    
      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteprop(field)
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
              }
          }
      }
    </script>   
    
  <span  id="SpanProp" style="display:" cellspacing="1" cellpadding="0">        
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class="centertitle" colspan="4">保险信息</td>
    </tr> 
    <tr>
      <td class="title" style="width:15%">被保险人姓名:</td>
      <td class="input" style="width:35%" >
        <input type="text" name="prpLverifyLossInsuredNameShow" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='insuredName'/>">
      </td>
      <td class="title" style="width:15%">币别:</td>
      <td class="input" style="width:35%">
        <input type="text" name="prpLverifyLossCurrencyNameShow" class="readonly" readonly="true" style="width:140px" value="人民币">          
        <input type="hidden" name="prpLverifyLossCurrencyShow" value="<bean:write name='prpLverifyLossDto' property='currency'/>">          
      </td>
    </tr>

      <td class="input" style="width:35%">
        <input type="hidden" name="prpLverifyLossLicenseNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='licenseNo'/>">          
      </td>
    </tr> 
    <tr>

      <td class="input" style="width:35%" >
        <input type="hidden" name="prpLverifyLossLicenseColorShow" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='licenseColor'/>">
      </td>

      <td class="input" style="width:35%">
        <input type="hidden" name="prpLverifyLossCarKindShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='carKind'/>">          
      </td>
    </tr> 
    <tr>
      <td class="input" style="width:35%" >
        <input type=""hidden"" name="prpLverifyLossClauseNameShow" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='clauseName'/>">
      </td>
    </tr>  
  </table>   
   
        <span style="display:none"> 
          <table class="common" style="display:none" id="Prop_Data" cellspacing="1" cellpadding="0">
            <tbody>

              <tr>
                <td class="input">  
                    <input type="input" name="prpLpropFamilyName" style='width:80px' >         
                </td>
                <td class="input">  
                  <input type="hidden"  name="prpLpropSerialNo" description="序号">   
                  <input type="input" name="prpLpropKindCode" class="codecode" style='width:30px'
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onchange="code_CodeChange(this, 'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                </td>
                <td class="input">   
                    <input type="input" name="prpLpropKindName" class="codename" style='width:80px'
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
  			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
                </td>
                <td class="input">                
                  <input name="prpLpropLossItemName" class=common style='width:80px'>
                </td>
                <td class="input">
                  <html:select name="prpLpropDto" property="feeTypeCode" >
                    <html:options collection="FeeTypeCodeList"  property="value" labelProperty="label"/>          
                  </html:select>
                </td>
                <td class="input">                
                  <input name="prpLpropSumLoss" class=common style='width:80px'>
                </td>
                <td class="input">                
                  <input name="prpLpropSumReject" class=common style='width:80px'>
                </td>
                <td class="input">                
                  <input name="prpLpropSumDefLoss" class=common style='width:80px'>
                </td>
                <td class="input">                
                  <input name="prpLpropRemark" class=common style='width:80px'>
                </td>                
                  <input type="hidden" name="prpLpropItemKindNo">
                  <input type="hidden" name="prpLpropFamilyNo">
                  <input type="hidden" name="prpLpropItemCode">
                  <input type="hidden" name="prpLpropLossItemCode">
                  <input type="hidden" name="prpLpropFeeTypeCode">
                  <input type="hidden" name="prpLpropFeeTypeName">
                  <input type="hidden" name="prpLpropCurrency" value="CNY">
                  <input type="hidden" name="prpLpropUnitPrice">
                  <input type="hidden" name="prpLpropLossQuantity">
                  <input type="hidden" name="prpLpropUnit">
                  <input type="hidden" name="prpLpropBuyDate">
                  <input type="hidden" name="prpLpropDepreRate">
                  <input type="hidden" name="prpLpropRejectReason">  
                  <input type="hidden" name="prpLpropLossRate">    
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
                  <input type="hidden" name="prpLpropCompensateBackFlag"> 
                    
              </tr>     
    
            </tbody>
          </table>
        </span>        
        
        <span  id="spanProp" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class=common cellpadding="5" cellspacing="1">
          <thead>
            <tr>
              <td class="centertitle" colspan=7>
                核定损清单 
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:12%">牛号</td>         
              <td class="centertitle" style="width:12%">险别名称</td>         
              <td class="centertitle" style="width:12%">损失标的名称</td>                         
              <td class="centertitle" style="width:12%">受损金额</td>
              <td class="centertitle" style="width:12%">剔除金额</td>   
              <td class="centertitle" style="width:12%">核损金额</td> 
              <td class="centertitle" style="width:12%">备注</td>
            </tr>
          </thead>
          <tfoot>

          </tfoot>
          <tbody>
<% indexVerifyLoss=0;%>
<logic:notEmpty  name="prpLpropDto"  property="propList"> 
<logic:iterate id="prpLpropDto1" name="prpLpropDto" property="propList">

              <tr>
                <td class="input">  
                    <input type="input" name="prpLpropFamilyName" style='width:80px' value="<bean:write name='prpLpropDto1' property='familyName'/>" class="readonly" readonly="true">         
                </td>
                <td class="input">  
                    <input type="hidden"  name="prpLpropSerialNo" description="序号" value="<bean:write name='prpLpropDto1' property='serialNo'/>">   
                    <input type="hidden" name="prpLpropKindCode" style='width:30px' value="<bean:write name='prpLpropDto1' property='kindCode'/>" class="readonly" readonly="true">          
                    <input type="input" name="prpLpropKindName" style='width:80px' value="<bean:write name='prpLpropDto1' property='kindName'/>" class="readonly" readonly="true">         
                </td>
                <td class="input">                
                  <input name="prpLpropLossItemName" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='lossItemName'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropSumLoss" class="readonly" readonly="true"style='width:80px'   value="<bean:write name='prpLpropDto1' property='sumLoss'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropSumReject" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='sumReject'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropSumDefLoss" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropRemark" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='remark'/>">
                </td>                             
                         
                  <input type="hidden" name="prpLpropItemKindNo"       value="<bean:write name='prpLpropDto1' property='itemKindNo'/>">    
                  <input type="hidden" name="prpLpropFamilyNo"         value="<bean:write name='prpLpropDto1' property='familyNo'/>">      
                  <input type="hidden" name="prpLpropItemCode"        value="<bean:write name='prpLpropDto1' property='itemCode'/>">      
                  <input type="hidden" name="prpLpropLossItemCode"     value="<bean:write name='prpLpropDto1' property='lossItemCode'/>">  
                  <input type="hidden" name="prpLpropFeeTypeCode"      value="<bean:write name='prpLpropDto1' property='feeTypeCode'/>">   
                  <input type="hidden" name="prpLpropCurrency"         value="<bean:write name='prpLpropDto1' property='currency'/>">       
                  <input type="hidden" name="prpLpropUnitPrice"        value="<bean:write name='prpLpropDto1' property='unitPrice'/>">     
                  <input type="hidden" name="prpLpropLossQuantity"     value="<bean:write name='prpLpropDto1' property='lossQuantity'/>">  
                  <input type="hidden" name="prpLpropUnit"             value="<bean:write name='prpLpropDto1' property='unit'/>">          
                  <input type="hidden" name="prpLpropBuyDate"          value="<bean:write name='prpLpropDto1' property='buyDate'/>">       
                  <input type="hidden" name="prpLpropDepreRate"        value="<bean:write name='prpLpropDto1' property='depreRate'/>">     
                  <input type="hidden" name="prpLpropRejectReason"     value="<bean:write name='prpLpropDto1' property='rejectReason'/>">  
                  <input type="hidden" name="prpLpropLossRate"         value="<bean:write name='prpLpropDto1' property='lossRate'/>">      
                  <input type="hidden" name="prpLpropVeriUnitPrice"    value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                  <input type="hidden" name="prpLpropVeriUnit"         value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                  <input type="hidden" name="prpLpropVeriDepreRate"    value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                  
                  <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                  <input type="hidden" name="prpLpropVeriLossRate"     value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
               
                  <input type="hidden" name="prpLpropFlag"             value="<bean:write name='prpLpropDto1' property='flag'/>">   
                  <input type="hidden" name="prpLpropCompensateBackFlag" value="<bean:write name='prpLpropDto1' property='compensateBackFlag'/>">   
              </tr>  
               <tr>
                <td class="input" colspan="3">&nbsp;</td>
                <td class="input">                
                  <input name="prpLpropVeriSumLoss" class=common style='width:80px'   value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropVeriSumReject" class=common style='width:80px'   value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropVeriSumDefLoss" class=common style='width:80px'   value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropVeriRemark" class=common style='width:80px'   value="<bean:write name='prpLpropDto1' property='veriRemark'/>">
                </td>    
              </tr> 
                     
<%    indexVerifyLoss++;     %>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>     
            
        </table>  
        </span>  
  
  <table class=common cellpadding="5" cellspacing="1">
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