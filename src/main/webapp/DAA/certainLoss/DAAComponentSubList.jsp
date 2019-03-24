<%--
****************************************************************************
* DESC       ：换件信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 


<script language='javascript'>
   function checkVerpCompPrice(field){
    var serialNo = getElementOrder(field) - 1;
    var compVerpPrice = parseFloat(fm.prpLcomponentVerpCompPrice[serialNo].value);
    var sys4sPrice = parseFloat(fm.all("prpLcomponentSys4SPrice")[serialNo].value); 
    var marketPrice = parseFloat(fm.all("prpLcomponentSysMarketPrice")[serialNo].value); 
    var matchPrice = parseFloat(fm.all("prpLcomponentSysMatchPrice")[serialNo].value); 
    var materialFee = parseFloat(fm.all("prpLcomponentMaterialFee")[serialNo].value); 
    
    var componentFlag = fm.all("prpLcomponentFlag")[serialNo].value;
    
    //控制：核损价格<=上报价格；核损价格<=系统价格
    if(componentFlag == "1"){
       var highestPrice;
       var priceName;
       if(isNaN(sys4sPrice)){
           sys4sPrice = 0;
       }
       if(isNaN(marketPrice)){
           marketPrice = 0;
       }
       if(isNaN(matchPrice)){
           matchPrice = 0;
       }
       if(isNaN(compVerpPrice)){
           compVerpPrice = 0;
       }
       if(isNaN(materialFee)){
           materialFee = 0;
       }
       //取最高价格
       if(sys4sPrice >= marketPrice){
           highestPrice =  sys4sPrice;
           priceName = "系统专修价";
       }else{
           highestPrice =  marketPrice;
           priceName = "系统市场价";
       }
       if(highestPrice < matchPrice){
           highestPrice =  matchPrice;
           priceName = "系统配件价";
       }
       if(compVerpPrice > highestPrice){
            field.focus();
            field.select();
            alert("核损价格不能大于" + priceName + "!");
            return false;
       }
       if(compVerpPrice > materialFee){
            field.focus();
            field.select();
            alert("核损价格不能大于上报价格！" );
            return false;
       }
    }else{       
       if(isNaN(compVerpPrice)){
           compVerpPrice = 0;
       }
       if(isNaN(materialFee)){
           materialFee = 0;
       }
       if(compVerpPrice > materialFee){
            field.focus();
            field.select();
            alert("核损价格不能大于上报价格！" );
            return false;
       }
    }
   	
   }
 
  
   
    function setVerpoFlag(field,serialNo){ 
      if (field.checked){
       
       fm.verpoFlag[serialNo].value="1";
      }
      else {
      	fm.verpoFlag[serialNo].value="0";
      }
    }
  </script>
<%
 String color ="";
 double    valueUpper  = 0.00;
 if ( nodeType !=null && !nodeType.equals("") && nodeType.equals("verpo") ){
    String    valueUpper1  = (String)request.getAttribute("valueUpper");
    valueUpper = Double.parseDouble(valueUpper1);
    }
%>
   <table class="common" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4">  
        <span  id="spanComponent" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Component" >
          <thead>
            <tr>
  	          <td class="subformtitle" colspan=16>零部件更换项目费用清单</td>
            </tr>
            <tr>
              <td class="centertitle" style="width:4%">序号</td>
              <td class="centertitle" style="width:7%">险别</td>
              <td class="centertitle" style="width:6%">部件代码</td>
              <td class="centertitle" style="width:10%">部件名称</td>
              <td class="centertitle" style="width:7%">原厂编码</td>
              <td class="centertitle" style="width:8%">上报价格</td>
              <td class="centertitle" style="width:4%">数量</td>
              <td class="centertitle" style="width:6%">系统专修价</td>  
              <td class="centertitle" style="width:6%">系统市场价</td>  
              <td class="centertitle" style="width:6%">系统配套价</td>  
              <td class="centertitle" style="width:6%">本地专修价</td>  
              <td class="centertitle" style="width:6%">本地市场价</td>                
              <td class="centertitle" style="width:8%">本地配套价</td>                              
              <td class="centertitle" style="width:8%">核价</td>
              <td class="centertitle">备注</td>
            </tr>
          </thead>
          <tfoot> 
            <tr>
              <td colspan="15">
                <table align="center" cellpadding="4" cellspacing="1" width="100%">
                  <tr>
                     <td class='title' style="width:12%" align="right">运费:  </td>
                     <td class='input' style="width:12%" >
                       <input name="prpLcarLossSumTransFee"   class="input" style='width:80px' value="<%= prpLcarLossDto.getSumTransFee() %>" onBlur="sumComponentFee();"> 
                     </td>           
                     <td class='title' style="width:12%" align="right">税金: </td>
                     <td class='input' style="width:12%" >
                       <input name="prpLcarLossSumTax"  class="input" style='width:80px' value="<%= prpLcarLossDto.getSumTax() %>"  onBlur="sumComponentFee();">
                     </td>        
                     <td class='title' style="width:12%" align="right">管理费:</td>
                     <td class='input' style="width:12%" >
                       <input name="prpLcarLossSumManager" readonly="readonly" class="readonly" style='width:80px' value="<%= prpLcarLossDto.getSumManager() %>"> 
                     </td>     
                     <td class='title'  style="width:14%" align="right">核定管理费:</td>
                     <td class='input' style="width:14%" colspan=8>
                       <input name="prpLcarLossSumVeriManager"   class="input" style='width:80px' value="<%= prpLcarLossDto.getSumVeriManager() %>" onBlur="sumComponentFee();"> 
                     </td>                           
                  </tr>  
                  <tr>
                    <td class='title' style="width:12%" align="right">换件合计:</td>
                    <td class='input' style="width:12%" >
                      <input name="SumDefLoss2"  class="readonly"  readonly style='width:80px'>
                    </td>     
                    <td class='title'  style="width:12%" align="right">核定换件合计:</td>
                    <td class='input' style="width:12%">
                      <input name="SumVerifyLoss2"  class="readonly"  readonly style='width:80px'>
                      <input type=hidden class='readonly' class="input" readonly="true" style='width:80px' name='SumManHourFee2'>
                      <input type=hidden class='readonly'  readonly="true" class="input" style='width:80px' name='SumMaterialFee2'>
                    </td>
                    <td class='title' style="width:12%" align="right">残值合计: </td>
                    <td class='input' style="width:12%" >
                      <input name="prpLcarLossSumRest"  readonly="readonly" class="readonly" style='width:80px' value="<%= prpLcarLossDto.getSumRest() %>">
                    </td>  
                    <td class='title' style="width:14%" align="right">核定残值合计:</td>
                    <td class='title' style="width:14%">
                      <input name="prpLcarLossSumVeriRest"  class="input" style='width:80px' value="<%= prpLcarLossDto.getSumVeriRest() %>" onBlur="sumComponentFee();">
                      <input  type="hidden"  name="selectCarFittings" >
                    </td>
                  </tr>
                </table>  
              </td>
            </tr>
          </tfoot> 
          <tbody>
<% String compensatebackReadOnly1=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackDiasable1=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackStyle1=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>

<%
      componentNo = 0;
      if(prpLcomponentDto.getComponentList() != null){
        for(int index1 = 0;index1<prpLcomponentDto.getComponentList().size();index1++){
          PrpLcomponentDto prpLcomponentDto1 = (PrpLcomponentDto)prpLcomponentDto.getComponentList().get(index1);
          if(prpLcomponentDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
          componentNo = Integer.parseInt(prpLcomponentDto1.getLossItemCode());
          //增加理算退回的判断
          compensatebackReadOnly1="";
          compensatebackDiasable1="";
          compensatebackStyle1="";
          if ("1".equals(prpLcomponentDto1.getCompensateBackFlag())) {
              compensatebackStyle1=";background:#CECECE";
              compensatebackReadOnly1="readOnly";
              compensatebackDiasable1="disabled";
          }
%> 
              <tr>  
                <td class="input" style="width:4%" align="center"><%=index1+1 %>
                  <input type="hidden" name="carLossComponentLossItemCode" value="<%= componentNo-1 %>">              
                  <input type="hidden" name="prpLcomponentKindCode" value="<%=prpLcomponentDto1.getKindCode() %>">     
                </td>
                <td class="input" style="width:7%">
                  <input type="text" name="prpLcomponentKindName" class="readonly" style='width:100%<%=compensatebackStyle1%>' readonly  
                    value="<%= prpLcomponentDto1.getKindName() %>">                     
  			        </td>
                <td class="input" style="width:6%">
                  <input name="prpLcomponentCompCode" class="readonly" value="<%= prpLcomponentDto1.getCompCode() %>"> 
				</td>
				<td class="input" style="width:10%">
									<% 
									  //自定义配件红色字体表示
									  if(prpLcomponentDto1.getFlag().trim().length()>0 
											  && prpLcomponentDto1.getFlag().trim().charAt(0)=='0'){
									%>
                   <input name="prpLcomponentCompName" class=readonly maxlength="80" readonly 
                     style="width:100%;color:'#FF0000'<%=compensatebackStyle1%>"  
                     value="<%= prpLcomponentDto1.getCompName() %>">
                  <%}else{%>
                   <input name="prpLcomponentCompName" class=readonly maxlength="80" readonly
                     style='width:100%<%=compensatebackStyle1%>'
                     value="<%= prpLcomponentDto1.getCompName() %>">
                  <%}%>
                  <% //大于核价人的  权限的标记特殊颜色
                    if(nodeType !=null && !nodeType.equals("") && nodeType.equals("verpo") ) {
                      if((prpLcomponentDto1.getVerpCompPrice() / prpLcomponentDto1.getQuantity() )> valueUpper )  { 
                        color =  " ;color:'#008000' " ;
                      }else {
                        color =" ;" ; 
                      }
                    }else {
                      color =" ;" ;
                    }
                  %>
                </td>    
                <td class="input" style="width:7%">
                  <input type="text" name="prpLcomponentOriginalId" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>" <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getOriginalId() %>">        
                </td>                
                <td class="input" style="width:8%">
                  <input name="prpLcomponentMaterialFee" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>"  <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getMaterialFee() %>" onBlur="getSumDefLoss(this,2);setFirstMaterialFee(this);">
                </td>
                <td class="input" style="width:4%">
                  <input name="prpLcomponentQuantity" class=readonly readonly style="width:100%<%=color%><%=compensatebackStyle1%>"   <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getQuantity() %>"  onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input" style="width:6%">
                  <input name="prpLcomponentSys4SPrice" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>"  <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getSys4SPrice() %>">
                </td>
                <td class="input" style="width:6%">
                  <input name="prpLcomponentSysMarketPrice" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>" <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getSysMarketPrice() %>">
                </td>
                <td class="input" style="width:6%">
                  <input name="prpLcomponentSysMatchPrice" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>"  <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getSysMatchPrice() %>">
                </td>
                <td class="input" style="width:6%">
                  <input name="prpLcomponentNative4SPrice" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>"  <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getNative4SPrice() %>">
                </td>
                <td class="input" style="width:6%">
                  <input name="prpLcomponentNativeMarketPrice" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>"  <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getNativeMarketPrice() %>">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLcomponentNativeMatchPrice" class="readonly" readonly style="width:100%<%=color%><%=compensatebackStyle1%>" <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getNativeMatchPrice() %>">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLcomponentVerpCompPrice"    class="common"  style="width:100%<%=color%><%=compensatebackStyle1%>" <%=compensatebackReadOnly1%>
                    onBlur="return getSumDefLossVerify(this,2);sumComponentFee();"  onchange=" return checkVerpCompPrice(this);"  
                    value="<%= prpLcomponentDto1.getVerpCompPrice()  %>">
                  <input name="prpLcomponentVerpCompPriceLast" type="hidden" value="<%= prpLcomponentDto1.getVerpCompPrice() %>">
                </td> 
                <td class="input">
                  <input name="prpLcomponentRemark" class="common" style="width:100%<%=color%><%=compensatebackStyle1%>" <%=compensatebackReadOnly1%> 
                    value="<%= prpLcomponentDto1.getRemark() %>" >
                	<input name="verpoFlag" type="hidden"   value="<%= prpLcomponentDto1.getVerpoFlag() %>" >
                  <input name="prpLcomponentFlag" type=hidden value="<%= prpLcomponentDto1.getFlag() %>" >                  
                  <input name="prpLcomponentIndId" type=hidden   value="<%= prpLcomponentDto1.getIndId() %>" >
                </td>
                  <input type="hidden" name="prpLcomponentManHourFee"value="<%= prpLcomponentDto1.getManHourFee() %>" >       
                  <input type="hidden" name="prpLcomponentSerialNo"value="<%= prpLcomponentDto1.getSerialNo() %>" >                  
                  <input type="hidden" name="prpLcomponentItemKindNo" value="<%= prpLcomponentDto1.getItemKindNo() %>" >               
                  <input type="hidden" name="prpLcomponentLossItemCode" value="<%= prpLcomponentDto1.getLossItemCode() %>">            
                  <input type="hidden" name="prpLcomponentLicenseNo" value="<%= prpLcomponentDto1.getLicenseNo() %>">               
                  <input type="hidden" name="prpLcomponentLicenseColorCode"value="<%= prpLcomponentDto1.getLicenseColorCode() %>" >          
                  <input type="hidden" name="prpLcomponentCarKindCode" value="<%= prpLcomponentDto1.getCarKindCode() %>" >              
                  <input type="hidden" name="prpLcomponentMakeYear" value="<%= prpLcomponentDto1.getMakeYear() %>">                
                  <input type="hidden" name="prpLcomponentGearboxType" value="<%= prpLcomponentDto1.getGearboxType() %>">             
                  <input type="hidden" name="prpLcomponentQuoteCompanyGrade" value="<%= prpLcomponentDto1.getQuoteCompanyGrade() %>">   
                  <input type="hidden" name="prpLcomponentManageFeeRate" value="<%= prpLcomponentDto1.getManageFeeRate() %>">           
                  <input type="hidden" name="prpLcomponentRepairFactoryCode" value="<%= prpLcomponentDto1.getRepairFactoryCode() %>">         
                  <input type="hidden" name="prpLcomponentRepairFactoryName" value="<%= prpLcomponentDto1.getRepairFactoryName() %>" >        
                  <input type="hidden" name="prpLcomponentHandlerCode" value="<%= prpLcomponentDto1.getHandlerCode() %>">               
                  <input type="hidden" name="prpLcomponentRepairStartDate" value="<%= prpLcomponentDto1.getRepairStartDate() %>">           
                  <input type="hidden" name="prpLcomponentRepairEndDate" value="<%= prpLcomponentDto1.getRepairEndDate() %>">                   
                  <input type="hidden" name="prpLcomponentSanctioner" value="<%= prpLcomponentDto1.getSanctioner() %>" >               
                  <input type="hidden" name="prpLcomponentApproverCode" value="<%= prpLcomponentDto1.getApproverCode() %>" >             
                  <input type="hidden" name="prpLcomponentOperatorCode" value="<%= prpLcomponentDto1.getOperatorCode() %>">                 
                  <input type="hidden" name="prpLcomponentQueryPrice" value="<%= prpLcomponentDto1.getQueryPrice() %>">                
                  <input type="hidden" name="prpLcomponentQuotedPrice" value="<%= prpLcomponentDto1.getQuotedPrice() %>">                
                  <input type="hidden" name="prpLcomponentPartCode" value="<%= prpLcomponentDto1.getPartCode() %>">               
                  <input type="hidden" name="prpLcomponentPartName" value="<%= prpLcomponentDto1.getPartName() %>">               
                  <input type="hidden" name="prpLcomponentSumDefLoss" value="<%= prpLcomponentDto1.getSumDefLoss() %>">                                 
                  <input type="hidden" name="prpLcomponentBackCheckRemark" value="<%= prpLcomponentDto1.getBackCheckRemark() %>">                                 
                  
                  <input type="hidden" name="prpLcomponentRestFee" value="<%= prpLcomponentDto1.getRestFee() %>">                
                  <input type="hidden" name="prpLcomponentLossRate" value="<%= prpLcomponentDto1.getLossRate() %>">                
                  <input type="hidden" name="prpLcomponentCurrency" value="<%= prpLcomponentDto1.getCurrency() %>" >                 
                  <input type="hidden" name="prpLcomponentVeriRemark" value="<%= prpLcomponentDto1.getRemark() %>">                  
                  <input type="hidden" name="prpLcomponentVeriQuantity" value="<%= prpLcomponentDto1.getVeriQuantity() %>">            
                  <input type="hidden" name="prpLcomponentVeriManHourFee" value="<%= prpLcomponentDto1.getVeriManHourFee() %>">            
                  <input type="hidden" name="prpLcomponentVeriMaterFee" value="<%= prpLcomponentDto1.getVeriMaterFee() %>">              
                  <input type="hidden" name="prpLcomponentVeriLossRate" value="<%= prpLcomponentDto1.getVeriLossRate() %>">              
                  <input type="hidden" name="prpLcomponentSumVeriLoss" value="<%= prpLcomponentDto1.getSumVeriLoss() %>" >             
                  <input type="hidden" name="prpLcomponentVeriRestFee" value="<%= prpLcomponentDto1.getVeriRestFee() %>" >              
                  <input type="hidden" name="prpLcomponentCompensateBackFlag" value="<%= prpLcomponentDto1.getCompensateBackFlag() %>" >              
                  <input type="hidden" name="prpLcarLossSumManageFeeRate" value="0.00">
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
  </table>
  
