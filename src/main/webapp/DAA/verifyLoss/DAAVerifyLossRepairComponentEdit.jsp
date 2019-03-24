<%@page pageEncoding="GBK"%>
<%--
****************************************************************************
* DESC       ：核损环节过程的修理/换件清单页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13  
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%> 
<table id="RepairComponent" class=common cellpadding="5" cellspacing="1">
  <tr>
    <td style="width:100%">
        <span style="display:none"> 
          <table class="common" style="display:none" id="RepairFee_Data" cellspacing="1" cellpadding="5">
            <tbody>
              <tr>          
                <td class="input">    
                  <input type="hidden" name="carLossRepairFeeLossItemCode" style="width:20px">                  
                  <input type="text" name="prpLrepairFeeKindCode" class="codecode" style='width:40px' 
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onchange="code_CodeChange(this, 'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">        
                </td>
                <td class="input">   
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:70px'              
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');" 
  			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');" 
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">     
                </td>
                <td class="input">   
                  <input type="text" name="prpLrepairFeeCompCode" class="codecode" style='width:40px'              
                      ondblclick= "code_CodeSelect(this,'CompCode');" 
                      onchange="code_CodeChange(this, 'CompCode');"
                      onkeyup= "code_CodeSelect(this,'CompCode');">          
                </td> 
                <td class="input">   
                  <input type="text" name="prpLrepairFeeCompName" class="codename" style='width:70px'                    
  			             ondblclick="code_CodeSelect(this, 'CompCode','-1','always','none','post');"
  			             onchange="code_CodeChange(this, 'CompCode','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'CompCode','-1','always','none','post');">      
                  <input type="hidden" name="prpLrepairFeeRepairType" class="readonly" readonly >     
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLrepairFeeManHour" value="1" class="readonly" readonly style='width:70px'>
                </td>
                <td class="input">                
                  <input name="prpLrepairFeeManHourUnitPrice" class="readonly" readonly style='width:70px'>
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLrepairFeeMaterialFee"  class="readonly" readonly style='width:70px'>
                </td>
                <td class="input">                
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:70px'>
                </td>
                <td class="input">                
                  <input name="prpLrepairFeeRemark" class="readonly" readonly style='width:100px'>
                </td>
<%
  if (nodeType.equals("backc")) {
%>
                <td class="input">                
                  <input name="prpLrepairFeeBackCheckRemark" class="readonly" readonly style='width:100px'>
                </td>
<% 
  } else {
%>
                  <input type="hidden" name="prpLrepairFeeBackCheckRemark">
<%
  }
%>
                  <input type="hidden" name="prpLrepairFeeSerialNo">                  
                  <input type="hidden" name="prpLrepairFeeItemKindNo">                 
                  <input type="hidden" name="prpLrepairFeeLossItemCode">                 
                  <input type="hidden" name="prpLrepairFeeLicenseNo">                  
                  <input type="hidden" name="prpLrepairFeeLicenseColorCode">           
                  <input type="hidden" name="prpLrepairFeeCarKindCode">               
                  <input type="hidden" name="prpLrepairFeeSanctioner">                 
                  <input type="hidden" name="prpLrepairFeeApproverCode">               
                  <input type="hidden" name="prpLrepairFeeOperatorCode">               
                  <input type="hidden" name="prpLrepairFeeManHourFee">                  
                  <input type="hidden" name="prpLrepairFeeLossRate">                   
                  <input type="hidden" name="prpLrepairFeeCurrency">                   
                  <input type="hidden" name="prpLrepairFeeVeriRemark">                     
                  <input type="hidden" name="prpLrepairFeeVeriManHour">                
                  <input type="hidden" name="prpLrepairFeeVeriManUnitPrice">           
                  <input type="hidden" name="prpLrepairFeeVeriManHourFee">             
                  <input type="hidden" name="prpLrepairFeeVeriMaterQuantity">          
                  <input type="hidden" name="prpLrepairFeeVeriMaterUnitPrice">         
                  <input type="hidden" name="prpLrepairFeeVeriMaterialFee">            
                  <input type="hidden" name="prpLrepairFeeVeriLossRate">               
                  <input type="hidden" name="prpLrepairFeeVeriSumLoss">                 
                  <input type="hidden" name="prpLrepairFeeFlag">
                  <input type="hidden" name="prpLrepairFeePartName" >     
                  <input type="hidden" name="prpLrepairFeePartCode">
                  <input type="hidden" name="prpLrepairFeeCompensateBackFlag">        
            </tbody>
          </table>
        </span>   
        
        <span style="display:none"> 
          <table class="common" style="display:none" id="Component_Data" cellspacing="1" cellpadding="5">
            <tbody>
              <tr>  
                <td class="input">               
     
                  <input type="hidden" name="carLossComponentLossItemCode" style="width:20px">              
                  <input type="text" name="prpLcomponentKindCode" class="codecode" style='width:40px'             
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onchange="code_CodeChange(this, 'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">          
                </td>
                <td class="input">   
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:70px'       
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
  			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">        
                </td>                
                
                <td class="input">                
                  <input name="prpLcomponentPartDesc" class="readonly" readonly style='width:70px'>
                </td>
                
                <td class="input">   
                  <input type="text" name="prpLcomponentCompCode" class="codecode" style='width:40px'             
                      ondblclick= "code_CodeSelect(this,'CompCode');"
                      onchange="code_CodeChange(this, 'CompCode');"
                      onkeyup= "code_CodeSelect(this,'CompCode');">         
                </td>
                <td class="input">   
                  <input type="text" name="prpLcomponentCompName" class="codecode" style='width:70px'
  			             ondblclick="code_CodeSelect(this, 'CompCode','-1','always','none','post');"
  			             onchange="code_CodeChange(this, 'CompCode','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'CompCode','-1','always','none','post');">      
                </td>

                <td class="input">   
                  <input type="text" name="prpLcomponentOriginalId"   class="common" style="width:50px"   >        
                </td>                
                <td class="input">                
                  <input name="prpLcomponentFirstMaterialFee"    class=readonly readonly style="width:55px"  >
                </td>
                <td class="input">                
                  <input name="prpLcomponentMaterialFee" class=common style="width:55px" onBlur="getSumDefLoss(this,2);setFirstMaterialFee(this);">
                </td>
                <td class="input">                
                  <input name="prpLcomponentQuantity" class=common style="width:30px"     onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input">
                  <input name="prpLcomponentSys4SPrice" class="common" style="width:40px"  >
                </td>
                <td class="input">                
                  <input name="prpLcomponentSysMarketPrice" class="common"  style="width:40px" >
                </td>
                <td class="input">                
                  <input name="prpLcomponentSysMatchPrice" class="common"  style="width:30px"  >
                </td>
                <td class="input">                
                  <input name="prpLcomponentNative4SPrice" class="common"  style="width:40px"  >
                </td>
                <td class="input">                
                  <input name="prpLcomponentNativeMarketPrice" class="common"  style="width:40px">
                </td>
                <td class="input">                
                  <input name="prpLcomponentNativeMatchPrice" class="common"  style="width:30px">
                </td>
                <td class="input">           
                             
                  <input name="prpLcomponentVerpCompPrice"    class="common"  style="width:55px"  onBlur="return getSumDefLossVerify(this,2);sumComponentFee();"     >
                  <input name="prpLcomponentVerpCompPriceLast"   type="hidden"    >
                  <input type="hidden" name="prpLcomponentSumDefLoss" > 
                </td> 
<%
  if (nodeType.equals("backc")) {
%>
                <td class="input">                
                  <input name="prpLcomponentBackCheckRemark" class="readonly" readonly style='width:100px'>
                </td>
<%
  } else { 
%>         
                  <input type="hidden" name="prpLcomponentBackCheckRemark">
<%
  }
%>        

                  <input type="hidden" name="prpLcomponentRemark"> 
                  <input type="hidden" name="prpLcomponentRestFee"> 
                  <input type="hidden" name="prpLcomponentManHourFee">  
                  <input type="hidden" name="prpLcomponentSerialNo">                 
                  <input type="hidden" name="prpLcomponentItemKindNo">               
                  <input type="hidden" name="prpLcomponentLossItemCode">             
                  <input type="hidden" name="prpLcomponentLicenseNo">                
                  <input type="hidden" name="prpLcomponentLicenseColorCode">         
                  <input type="hidden" name="prpLcomponentCarKindCode">              
                  <input type="hidden" name="prpLcomponentMakeYear">                 
                  <input type="hidden" name="prpLcomponentGearboxType">              
                  <input type="hidden" name="prpLcomponentQuoteCompanyGrade">        
                  <input type="hidden" name="prpLcomponentManageFeeRate">            
                  <input type="hidden" name="prpLcomponentRepairFactoryCode">        
                  <input type="hidden" name="prpLcomponentRepairFactoryName">        
                  <input type="hidden" name="prpLcomponentHandlerCode">              
                  <input type="hidden" name="prpLcomponentRepairStartDate">          
                  <input type="hidden" name="prpLcomponentRepairEndDate">                  
                  <input type="hidden" name="prpLcomponentSanctioner">               
                  <input type="hidden" name="prpLcomponentApproverCode">             
                  <input type="hidden" name="prpLcomponentOperatorCode">                
                  <input type="hidden" name="prpLcomponentQueryPrice">               
                  <input type="hidden" name="prpLcomponentQuotedPrice">   
                  <input type="hidden" name="prpLcomponentQuotedPriceShow">           
                  <input type="hidden" name="prpLcomponentLossRate">                 
                  <input type="hidden" name="prpLcomponentCurrency">                 
                  <input type="hidden" name="prpLcomponentVeriRemark">                   
                  <input type="hidden" name="prpLcomponentVeriQuantity">              
                  <input type="hidden" name="prpLcomponentVeriManHourFee">            
                  <input type="hidden" name="prpLcomponentVeriRestFee">           
                  <input type="hidden" name="prpLcomponentVeriMaterFee">             
                  <input type="hidden" name="prpLcomponentVeriLossRate">             
                  <input type="hidden" name="prpLcomponentSumVeriLoss">               
                  <input type="hidden" name="prpLcomponentFlag">   
                  <input type="hidden" name="prpLcomponentPartName" >     
                  <input type="hidden" name="prpLcomponentPartCode">
                  <input type="hidden" name="prpLcomponentCompensateBackFlag"> 
              	  <input type="hidden" name="prpLcomponentIndId"> 
              </tr>         
            </tbody>
          </table>
        </span>      
  <span  id="SpanRepairComponent"  cellspacing="1" cellpadding="0">
  <%
    System.err.println("**********123******===>");
    VerifyLossDto verifyLossDto = (VerifyLossDto)request.getAttribute("verifyLossDto");
    PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto)request.getAttribute("prpLrepairFeeDto");
    PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto)request.getAttribute("prpLcomponentDto");
    int carLossSize = verifyLossDto.getPrpLcarLossDtoList().size();
    if(carLossSize > 0 ){
      for(int i = 0 ;i < carLossSize; i++){
        PrpLcarLossDto prpLcarLossDto =(PrpLcarLossDto)verifyLossDto.getPrpLcarLossDtoList().get(i);   
         String prpLrepairFeeRepairFactoryCode = "";
        String prpLrepairFeeRepairFactoryName = "";
        String prpLrepairFeeRepairStartDate = "";
        String prpLrepairFeeRepairEndDate = "";
        String prpLrepairFeeHandlerCode = "";
        String prpLrepairFeeHandlerName = "";
        if(prpLrepairFeeDto.getRepairFeeList() != null){
          for(int index1 = 0;index1<prpLrepairFeeDto.getRepairFeeList().size();index1++){
            PrpLrepairFeeDto prpLrepairFeeDto1 = (PrpLrepairFeeDto)prpLrepairFeeDto.getRepairFeeList().get(index1);
            if(prpLrepairFeeDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
              prpLrepairFeeRepairFactoryCode = prpLrepairFeeDto1.getRepairFactoryCode();
              prpLrepairFeeRepairFactoryName = prpLrepairFeeDto1.getRepairFactoryName();
              prpLrepairFeeRepairStartDate = prpLrepairFeeDto1.getRepairStartDate().toString();
              prpLrepairFeeRepairEndDate = prpLrepairFeeDto1.getRepairEndDate().toString();
              prpLrepairFeeHandlerCode = prpLrepairFeeDto1.getHandlerCode();
              prpLrepairFeeHandlerName = prpLrepairFeeDto1.getHandlerName();
            }
          }
          if(prpLcomponentDto.getComponentList() != null){
              for(int index1 = 0;index1<prpLcomponentDto.getComponentList().size();index1++){
                PrpLcomponentDto prpLcomponentDto2 = (PrpLcomponentDto)prpLcomponentDto.getComponentList().get(index1);
                if(prpLcomponentDto2.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
                
                    prpLrepairFeeRepairFactoryCode = prpLcomponentDto2.getRepairFactoryCode();
                    prpLrepairFeeRepairFactoryName = prpLcomponentDto2.getRepairFactoryName();
                }
              }
          }
        }
  %>
    <input type="hidden" name="carLossSize" value="<%= carLossSize %>">
    <table class=common cellpadding="5" cellspacing="1">    
      <tr>
        <td class="centertitle" colspan="4">理赔车辆</td>
      </tr>
      <tr>  
        <td class="title" style="width:15%">车辆序号:                         
          <!-- <input type="hidden" name="prpLcarLossSumManager" value="<%= prpLcarLossDto.getSumManager() %>">     -->   
          <input type="hidden" name="prpLcarLossSumCertainLoss" value="<%= prpLcarLossDto.getSumCertainLoss() %>">    
          <input type="hidden" name="prpLcarLossSumVerifyLoss" value="<%= prpLcarLossDto.getSumVerifyLoss() %>">     
          <input type="hidden" name="prpLcarLossLossDesc" value="<%= prpLcarLossDto.getLossDesc() %>"> 
          <!-- <input type="hidden" name="prpLcarLossSumVeriManager" value="<%= prpLcarLossDto.getSumVeriManager() %>"> -->         
          <input type="hidden" name="prpLcarLossSumManageFeeRate" value="<%= prpLcarLossDto.getSumManageFeeRate() %>">
          <input type="hidden" name="prpLcarLossIndemnityDuty" value="<%= prpLcarLossDto.getIndemnityDuty() %>">     
          <input type="hidden" name="prpLcarLossIndemnityDutyRate" value="<%= prpLcarLossDto.getIndemnityDutyRate() %>"> 
          <input type="hidden" name="prpLcarLossVeriIndeDutyRate" value="<%= prpLcarLossDto.getVeriIndeDutyRate() %>">  
          <input type="hidden" name="prpLcarLossRemark" value="<%= prpLcarLossDto.getRemark() %>">            
          <input type="hidden" name="prpLcarLossOperatorCode" value="<%= prpLcarLossDto.getOperatorCode() %>">      
          <input type="hidden" name="prpLcarLossApproverCode" value="<%= prpLcarLossDto.getApproverCode() %>">      
          <input type="hidden" name="prpLcarLossFlag" value="<%= prpLcarLossDto.getFlag() %>">      
          <input type="hidden" name="prpLcarLossBackCheckFlag" value="<%= prpLcarLossDto.getBackCheckFlag() %>">              
     
        </td> 
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemCode" class="readonly" readonly="true" style='width:90px'  value="<%= prpLcarLossDto.getLossItemCode() %>">
        </td>
        <% if (prpLcarLossDto.getLossItemCode().trim().equals("1")){%>        
        <td class="title" style="width:15%">标的车</td>
        <%}else{%>
        <td class="title" style="width:15%"><font color="red">三者车</font></td>
        <%}%>
        <td class="input" style="width:35%">&nbsp;</td>
      </tr>   
          
      <tr>
        <td class="title" style="width:15%">号牌号码:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getLossItemName() %>">
        </td>
        <td class="title" style="width:15%">厂牌型号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossBrandName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getBrandName() %>">
        </td>
      </tr> 
      
      <tr>
        <td class="title" style="width:15%">车辆种类:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossCarKindName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getCarKindName() %>">
        </td>
        <td class="title" style="width:15%">发动机号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossEngineNo" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getEngineNo() %>">
        </td>
      </tr> 
      
      <tr>
        <td class="title" style="width:15%">车架号:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossFrameNo" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getFrameNo() %>">
        </td>
        <td class="title" style="width:15%">VIN码:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossVINNo" class="readonly" readonly="true" style='width:160px' value="<%= prpLcarLossDto.getVINNo() %>">
        </td>
      </tr>   
      
      <input type="hidden" name="prpLcarLossLicenseColorCode" value="<%= prpLcarLossDto.getLicenseColorCode() %>">
      <input type="hidden" name="prpLcarLossCarKindCode" value="<%= prpLcarLossDto.getCarKindCode() %>">
      <input type="hidden" name="prpLcarLossInsureCarFlagName" value="<%= prpLcarLossDto.getInsureCarFlagName() %>">
      <input type="hidden" name="prpLcarLossInsureCarFlag"  value="<%= prpLcarLossDto.getInsureCarFlag() %>">
      <input type="hidden" name="prpLcarLossInsureComName" value="<%= prpLcarLossDto.getInsureComName() %>">
<%if(!prpLrepairFeeRepairFactoryCode.trim().equals("")){ %>     
      <tr>
       <td class="title">修理厂类型:</td>
        <td class="input">
         <select name="prpLrepairFeeRepairFactoryCode" class="three" style="width:110px" >   
             <option value="" <%= prpLrepairFeeRepairFactoryCode.trim().equals("")? "selected":"" %>></option>
             <option value="03" <%= prpLrepairFeeRepairFactoryCode.trim().equals("03")? "selected":"" %>>二类厂</option>                                
             <option value="02" <%= prpLrepairFeeRepairFactoryCode.trim().equals("02")? "selected":"" %>>一类厂</option>                   
             <option value="01" <%= prpLrepairFeeRepairFactoryCode.trim().equals("01")? "selected":"" %>>4S店</option>
          </select>   
        <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">修理厂名称:</td>
        <td class="input" style="width:35%">
          <input name="prpLrepairFeeRepairFactoryName" class="input" style='width:220px' maxLength="50" onblur="checkLength1(this);" description="修理厂名称" value="<%= prpLrepairFeeRepairFactoryName %>">
        </td>
      </tr>
<%
}else{
%>
	<tr>
       <td class="title">修理厂类型:</td>
        <td class="input">
         <select name="prpLrepairFeeRepairFactoryCode" class="three" style="width:110px" >   
             <option value="" <%= prpLcarLossDto.getRepairFactoryCode().trim().equals("")? "selected":"" %>></option>
             <option value="03" <%= prpLcarLossDto.getRepairFactoryCode().trim().equals("03")? "selected":"" %>>二类厂</option>                                
             <option value="02" <%= prpLcarLossDto.getRepairFactoryCode().trim().equals("02")? "selected":"" %>>一类厂</option>                   
             <option value="01" <%= prpLcarLossDto.getRepairFactoryCode().trim().equals("01")? "selected":"" %>>4S店</option>
          </select>   
        <img src="/claim/images/bgMarkMustInput.jpg">
        </td>
        <td class="title" style="width:15%">修理厂名称:</td>
        <td class="input" style="width:35%">
          <input name="prpLrepairFeeRepairFactoryName" class="input" style='width:220px' maxLength="50" onblur="checkLength1(this);" description="修理厂名称" value="<%= prpLcarLossDto.getRepairFactoryName() %>">
        </td>
      </tr>
<%
}
%>
      <tr>
        <td class="title" style="width:15%">进厂日期:</td>
        <td class="input" style='width:35%'>
          <input name="prpLrepairFeeRepairStartDate" class="input" style='width:220px' value="<%= prpLrepairFeeRepairStartDate  %>">
        </td>
        <td class="title" style="width:15%">约定交车日期:</td>
        <td class="input" style="width:35%">
          <input name="prpLrepairFeeRepairEndDate" class="input" style='width:220px' value="<%= prpLrepairFeeRepairEndDate %>">
        </td>
      </tr> 
       
      <tr>
        <td class="title" style="width:15%">经办人代码:</td>
        <td class="input" style='width:35%'>
          <input name="prpLrepairFeeHandlerCode" class="codecode" style='width:90px' value="<%= prpLrepairFeeHandlerCode %>"
                  ondblclick="code_CodeSelect(this, 'HanderCode');"
                  onchange="code_CodeChange(this, 'HanderCode');"
                  onkeyup= "code_CodeSelect(this, 'HanderCode');">
        </td>
        <td class="title" style="width:15%">经办人名称:</td>
        <td class="input" style="width:35%">
          <input name="prpLrepairFeeHandlerName" class="codename" style='width:220px' value="<%= prpLrepairFeeHandlerName %>"
                 ondblclick="code_CodeSelect(this, 'HanderCode','-1','always','none','post');"
                 onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
                 onkeyup= "code_CodeSelect(this, 'HanderCode','-1','always','none','post');">
        </td> 
      </tr> 
      <tr> 
        <td class="title" style="width:15%">币别:</td>
        <td class="input" style='width:85%' colspan="3">
          <input name="prpLcarLossCurrencyName" class="readonly" readonly="true" style='width:220px' value="人民币">
          <input type="hidden" name="prpLcarLossCurrency" class="readonly" readonly="true" style='width:220px' value="CNY">
        </td>
      </tr>               
<%
  if (nodeType.equals("backc")) {
%> 
      <tr> 
        <td class="title" style="width:15%">复勘意见:</td>
        <td class="input" style='width:85%' colspan="3">
         <%//验车标记。。。%>
          <input type="hidden" name="prpLverifyLossBackCheckFlag"  value="1">        
          <input name="prpLcarLossBackCheckRemark" class="input" style='width:440px'  maxLength="255" onblur="checkLength1(this);" description="复勘意见" value="<%= prpLcarLossDto.getBackCheckRemark() %>">
        </td>
      </tr>   
<%
  } else {
%>   
          <input type="hidden" name="prpLcarLossBackCheckRemark" value="<%= prpLcarLossDto.getBackCheckRemark() %>">
<%
  }
%>       
      <tr> 
        <td class="title" style="width:100%" colspan="4">
          <%@include file="/DAA/verifyLoss/DAAVerifyLossRepairFee.jsp"%> 
        </td>
      </tr>   
      <tr>
        <td class="title" style="width:100%" colspan="4">
          <!-- 垃圾：核损的代码放在certainLoss文件夹下 -->
          <%@include file="/DAA/certainLoss/DAAComponentSubList.jsp"%>
        </td>
      </tr>                 
    </table>
  <%
      }
    }
  %>

  </span>
  </td> 
 </tr>  
</table>