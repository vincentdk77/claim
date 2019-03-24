<%@page pageEncoding="GBK"%>
<%--
****************************************************************************
* DESC       ：定损环节过程的修理/换件清单页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%>
<script language='javascript'>
   
    function setFlag0(pageCode,field){ 
      fm.prpLcomponentFlag[fm.all("prpLcomponentFlag").length-1].value=0;
     
    }

  </script>




<%
     Collection collection = (Collection)request.getAttribute("partCodeList"); 
     Collection repairColl = (Collection)request.getAttribute("repairTypes");      
%>
<table id="RepairComponent" class=common cellpadding="5" cellspacing="1">
  <tr>
    <td >
        <span style="display:none"> 
          <table class="common" style="display:none" id="RepairFee_Data" cellpadding="5" cellspacing="1">
            <tbody>
              <tr>          
                <td class="input" style="display:none">    
                  <input type="hidden" name="carLossRepairFeeLossItemCode" style="width:20px">                  
                  <input type="text" name="prpLrepairFeeKindCode" class="codecode" style='width:40px' 
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">        
                </td>
		<% 
        
    		CertainLossDto certainLossDto1 = (CertainLossDto)request.getAttribute("certainLossDto");
    		
    		VerifyLossDto verifyLossDto1 = (VerifyLossDto)request.getAttribute("verifyLossDto");
    		
    		PrpLcarLossDto prpLcarLossDto1 = null;
    		
    		if(certainLossDto1==null){    		
	         prpLcarLossDto1 =(PrpLcarLossDto)verifyLossDto1.getPrpLcarLossDtoList().get(0);   
	      }else{	      
	         prpLcarLossDto1 =(PrpLcarLossDto)certainLossDto1.getPrpLcarLossDtoList().get(0);   
	      }
	     
		   
		if (prpLcarLossDto1.getLossItemCode().trim().equals("1")){%>                

                <td class="input">   
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:70px'              
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');">     
                </td>
		<%}else{%>
                <td class="input">   
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:70px'              
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');">     
                </td>
                <%}%>
                <!--Modify by chenrenda update begin 20050413-->
                <td class="input">
                    
          		    <select name="prpLrepairFeePartCode" styleClass="three"  style="width:60px">
                   <%                   
                      Iterator prpLPartCodeNameList = collection.iterator();
                      while (prpLPartCodeNameList.hasNext()){
                      LabelValueBean labelValueBean = (LabelValueBean)prpLPartCodeNameList.next();
                   %>
                      <option value="<%= labelValueBean.getValue() %>"><%= labelValueBean.getLabel() %></option>
                   <%
                       }                       
                   %> 
                    </select>           
                    <input type="hidden" name="prpLrepairFeePartName" >
                 </td> 
                <td class="input">
                  <input name="prpLrepairFeeCompName" class="codename" style="width:70px"  			            maxlength="80"  
                     ondblclick="return openPrplRepairFeeCompWin(RepairFee_Data,this);">  
                     <input type="hidden" name="prpLrepairFeeCompCode" value="9999">
                </td>
                <td class="input">
                  
                   <select name="prpLrepairFeeRepairType"  styleClass="three" style="width:60px">
                   <%
                      Iterator prpLrepairTypeList = repairColl.iterator();
                      while (prpLrepairTypeList.hasNext()){
                        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)prpLrepairTypeList.next(); 
    
                   %>
                      <option value="<%= prpDcodeDto.getCodeCode() %>"><%= prpDcodeDto.getCodeCName() %></option>
                   <%
                       }                       
                   %> 
                    </select>           
                </td> 
               
                <td class="input">                
                  <input name="prpLrepairFeeManHour" value="1"  class=common style='width:60px' onBlur="getSumDefLoss(this,1);">
                </td>
                <td class="input">                
                  <input name="prpLrepairFeeManHourUnitPrice" class="common" style='width:70px' onBlur="getSumDefLoss(this,1);">
                </td>  
                <td class="input">                
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:70px'>
                </td>
                <td class="input">                
                  <input name="prpLrepairFeeFirstSumDefLoss" class="readonly" readonly style='width:70px'>
                </td>
                
                <td class="input">                
                  <input name="prpLrepairFeeRemark" class=common style='width:120px'>
                </td>
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
                  <input type="hidden" name="prpLrepairFeeMaterialFee">                  
                  <input type="hidden" name="prpLrepairFeeLossRate">                   
                  <input type="hidden" name="prpLrepairFeeCurrency">                   
                  <input type="hidden" name="prpLrepairFeeVeriRemark">                     
                  <input type="hidden" name="prpLrepairFeeVeriManHour">                
                  <input type="hidden" name="prpLrepairFeeVeriManUnitPrice">           
                  <input type="hidden" name="prpLrepairFeeVeriManHourFee">             
                  <input type="hidden" name="prpLrepairFeeVeriMaterQuantity">          
                  <input type="hidden" name="prpLrepairFeeVeriMaterUnitPrice">      
                  <input type="hidden" name="prpLrepairFeeBackCheckRemark">   
                  <input type="hidden" name="prpLrepairFeeVeriMaterialFee">            
                  <input type="hidden" name="prpLrepairFeeVeriLossRate">               
                  <input type="hidden" name="prpLrepairFeeVeriSumLoss">                 
                  <input type="hidden" name="prpLrepairFeeFlag">
                  <input type="hidden" name="prpLrepairFeeCompensateBackFlag">
                 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonRepairFeeDelete" class="smallbutton"  onclick="deleteRowTableRepairFee(this,'RepairFee',1,1)" value="-" style="cursor: hand">
                </div>
                </td> 
              </tr>         
            </tbody>
          </table>
        </span>   
        
        <span style="display:none"> 
          <table class="common" style="display:none" id="Component_Data" cellspacing="1" cellpadding="0">
            <tbody>



              <tr>  
                <td class="input" style="display:none">               
                  <input type="hidden" name="carLossComponentLossItemCode" style="width:20px">              



                  <input  type="hidden" name="prpLcomponentKindCode" class="codecode" style='width:40px'             
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">          
                </td>
<% if (prpLcarLossDto1.getLossItemCode().trim().equals("1")){%>              
                <td class="input">   
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:65px'       
   			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');">        
                   </td>   
<%}else{%>     
	               <td class="input">   
                    <input type="text" name="prpLcomponentKindName" class="codecode" style='width:65px'
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');">        
                     </td>             
	
<% } %>
                

                <td class="input">
                  <input name="prpLcomponentCompName"   class=common style='width:65px'  maxlength="80">                     
                  <input name="prpLcomponentCompCode" type='hidden' value=""> 
                </td>    
                <td class="input" >
	                 <input name="prpLcomponentOriginalId"   class=common style='width:50px' >
                </td> 
                <td class="input">                
                  <input name="prpLcomponentFirstMaterialFee"   class=readonly readonly style='width:55px' >
                </td>                    
                <td class="input">                
                  <input name="prpLcomponentMaterialFee"   class=common style='width:55px' onBlur="setFirstMaterialFee(this);getSumDefLoss(this,2);">
                </td>                    
                <td class="input">                
                  <input name="prpLcomponentQuantity"  value="1" class=common style='width:30px' onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input">                
                  <input name="prpLcomponentSys4SPrice" class="common" style='width:40px'>
                </td>
                <td class="input">                
                  <input name="prpLcomponentSysMarketPrice" class="common"  style='width:40px' >
                </td>
                <td class="input">                
                  <input name="prpLcomponentSysMatchPrice" class="common"  style='width:30px'>
                </td>
                <td class="input"> 系统价3
                  <input name="prpLcomponentNative4SPrice" class="common"  style='width:40px'>
                </td>
                <td class="input">                
                  <input name="prpLcomponentNativeMarketPrice" class="common"  style='width:40px'>
                </td>
                <td class="input">                
                  <input name="prpLcomponentNativeMatchPrice" class="common"  style='width:30px'>
                </td>
                <td class="input">                
                  <input name="prpLcomponentVerpCompPrice" class="common"  style='width:55px'>
                  <input name="prpLcomponentVerpCompPriceLast"   type="hidden"   >
                </td>                
                <td class="input">                
                  <input name="verpoFlag" type="hidden"   value="0" >
                  <input name="prpLcomponentRemark" class=common style='width:60px'>
                  <input name="prpLcomponentFlag" type=hidden  value=1>                                    
		  <input name="prpLcomponentIndId" type=hidden   >
                </td> 
                
                
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
                  <input type="hidden" name="prpLcomponentQuotedPrice" >                
                  <input type="hidden" name="prpLcomponentPartCode" >               
                  <input type="hidden" name="prpLcomponentPartName" >               
                  <input type="hidden" name="prpLcomponentManHourFee">               
                  <input type="hidden" name="prpLcomponentSumDefLoss">                                 
                  <input type="hidden" name="prpLcomponentRestFee">                 
                  
                  <input type="hidden" name="prpLcomponentLossRate">                 
                  <input type="hidden" name="prpLcomponentCurrency">                 
                  <input type="hidden" name="prpLcomponentVeriRemark">                   
                  <input type="hidden" name="prpLcomponentVeriQuantity">              
                  <input type="hidden" name="prpLcomponentVeriManHourFee">           
                  <input type="hidden" name="prpLcomponentVeriMaterFee">             
                  <input type="hidden" name="prpLcomponentVeriLossRate">              
                  <input type="hidden" name="prpLcomponentVeriRestFee">      
                  <input type="hidden" name="prpLcomponentBackCheckRemark">                         
                  <input type="hidden" name="prpLcomponentSumVeriLoss">               
                  <input type="hidden" name="prpLcomponentCompensateBackFlag">
              
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonComponentDelete"  class="smallbutton" onclick="deleteRowTableComponent(this,'Component',1,1)" value="-" style="cursor: hand">
                </div>
                </td>
              </tr>         
            </tbody>
          </table>
        </span>      
    <span  id="SpanRepairComponent"  cellspacing="1" cellpadding="0">
    <%    
      CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
      VerifyLossDto verifyLossDto   = (VerifyLossDto)request.getAttribute("verifyLossDto");
      PrpLcarLossDto prpLcarLossDto = null;
      
      PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto)request.getAttribute("prpLrepairFeeDto");
      PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto)request.getAttribute("prpLcomponentDto");
      
      int carLossSize = 0;

  		if(certainLossDto==null){      		
        carLossSize = verifyLossDto.getPrpLcarLossDtoList().size();
      }else{  	      
       carLossSize = certainLossDto.getPrpLcarLossDtoList().size();
  	  } 
  	        
      if(carLossSize > 0 ){      
        for(int i = 0 ;i < carLossSize; i++){
      		if(certainLossDto==null){      		
  	         prpLcarLossDto =(PrpLcarLossDto)verifyLossDto.getPrpLcarLossDtoList().get(i);   
  	      }else{  	      
  	         prpLcarLossDto =(PrpLcarLossDto)certainLossDto.getPrpLcarLossDtoList().get(i);   
  	      }                    

          String prpLrepairFeeRepairFactoryCode = "";
          String prpLrepairFeeRepairFactoryName = "";
          String prpLrepairFeeRepairStartDate = "";
          String prpLrepairFeeRepairEndDate = "";
          String prpLrepairFeeHandlerCode = "";
          String prpLrepairFeeHandlerName = ""; 
         
          if(prpLrepairFeeDto.getRepairFeeList() != null && prpLrepairFeeDto.getRepairFeeList().size()>0){                   
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
          }
          else{
            if(prpLcomponentDto.getComponentList() != null && prpLcomponentDto.getComponentList().size()>0){                       
              for(int index1 = 0;index1<prpLcomponentDto.getComponentList().size();index1++){
               
                PrpLcomponentDto prpLcomponentDto1 = (PrpLcomponentDto)prpLcomponentDto.getComponentList().get(index1);
                if(prpLcomponentDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
                  prpLrepairFeeRepairFactoryCode = prpLcomponentDto1.getRepairFactoryCode();
                  prpLrepairFeeRepairFactoryName = prpLcomponentDto1.getRepairFactoryName();
                  prpLrepairFeeRepairStartDate = prpLcomponentDto1.getRepairStartDate().toString();
                  prpLrepairFeeRepairEndDate = prpLcomponentDto1.getRepairEndDate().toString();
                  prpLrepairFeeHandlerCode = prpLcomponentDto1.getHandlerCode();
                  prpLrepairFeeHandlerName = prpLcomponentDto1.getHandlerName();
                  
                }
              }
            }else{
             prpLrepairFeeHandlerCode = user.getUserCode();
             prpLrepairFeeHandlerName = user.getUserName();
            }
          }
          
          String sysAreaCode = user.getSysAreaCode();
          String localAreaCode = user.getComCode();
          localAreaCode = localAreaCode.substring(0,3) + "0000000"; //取分公司机构代码
                    
    %>
    <input type="hidden" name="carLossSize" value="<%= carLossSize %>">
    <table  class=common cellpadding="5" cellspacing="1" >
      <tr>
        <td class="subformtitle"  colspan="4">理赔车辆</td>
      </tr>
      <tr>   
        <td class="title" style="width:15%">车辆序号:                               
          <input type="hidden" name="prpLcarLossSumVeriRest" value="<%= prpLcarLossDto.getSumVeriRest() %>">                         
          <input type="hidden" name="prpLcarLossSumVerifyLoss" value="<%= prpLcarLossDto.getSumVerifyLoss() %>">  
          <input type="hidden" name="prpLcarLossLossDesc" value="<%= prpLcarLossDto.getLossDesc() %>">          
          <input type="hidden" name="prpLcarLossIndemnityDuty" value="<%= prpLcarLossDto.getIndemnityDuty() %>">     
          <input type="hidden" name="prpLcarLossIndemnityDutyRate" value="<%= prpLcarLossDto.getIndemnityDutyRate() %>"> 
          <input type="hidden" name="prpLcarLossVeriIndeDutyRate" value="<%= prpLcarLossDto.getVeriIndeDutyRate() %>">  
          <input type="hidden" name="prpLcarLossSumManageFeeRate" value="<%= prpLcarLossDto.getSumManageFeeRate() %>">  
          <input type="hidden" name="prpLcarLossBackCheckRemark" value="<%= prpLcarLossDto.getBackCheckRemark() %>">
          <input type="hidden" name="prpLcarLossRemark" value="<%= prpLcarLossDto.getRemark() %>">            
          <input type="hidden" name="prpLcarLossOperatorCode" value="<%= prpLcarLossDto.getOperatorCode() %>">      
          <input type="hidden" name="prpLcarLossApproverCode" value="<%= prpLcarLossDto.getApproverCode() %>">      
          <input type="hidden" name="prpLcarLossFlag" value="<%= prpLcarLossDto.getFlag() %>">              
          <input type="hidden" name="verifyPriceFlag" value="0">                        
          <input type="hidden" name="SysAreaCode" value="<%=sysAreaCode%>">                        
          <input type="hidden" name="LocalAreaCode" value="<%=localAreaCode%>"">                        
          
    
        </td> 
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemCode" class="readonly" style='width:90px'  value="<%= prpLcarLossDto.getLossItemCode() %>">
        </td>
<% if (prpLcarLossDto.getLossItemCode().trim().equals("1")){%>
        <td class="title" style="width:15%">标的车</td>
        <!--modify -->
         <td class="input" style="width:35%">&nbsp;</td>
      </tr>   
          
      <tr>
        <td class="title" style="width:15%">号牌号码:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getLossItemName() %>">
        </td>
        <td class="title" style="width:15%">车型名称:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossBrandName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getBrandName() %>">
          <input name="prpLcarLossModelCode" type="hidden" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getModelCode() %>">          
        </td>
      </tr> 
      
      <tr>
      <td class="title" style="width:15%">车辆种类:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossCarKindName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getCarKindName() %>">
        </td> 
        <td class="title" style="width:15%">发动机号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossEngineNo" class="readonly" readonly="true"  style='width:90px' value="<%= prpLcarLossDto.getEngineNo() %>">
        </td>
      </tr> 
      
      <tr>
        <td class="title" style="width:15%">车架号(VIN码):</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossFrameNo" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getFrameNo() %>">
        </td>
        <td class="title" style="width:15%"></td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossVINNo" type=hidden class="readonly" readonly="true" style='width:160px' value="<%= prpLcarLossDto.getVINNo() %>">
        </td>
  
<%}else{%>        
        <td class="title" style="width:15%"><font color="red">三者车</font></td>
        <td class="input" style="width:35%">&nbsp;</td>
      </tr>   
     
      <tr>
        <td class="title" style="width:15%">号牌号码:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemName" class="input"  style='width:90px' value="<%= prpLcarLossDto.getLossItemName() %>">
        </td>
       
         <td class="title" style="width:10%">
											厂牌型号
										</td>
										<td id="prpLcarLossBrandName" class="input" colspan=5 style="width:25%">
											<input  type="hidden" name="prpLcarLossModelCode" class="codecode" description="厂牌型号"  style="width:10%"  value="<%= prpLcarLossDto.getModelCode() %>"
											   ondblclick="code_CodeSelect(this, 'ModelCode');" 
											   onchange="code_CodeChange(this, 'ModelCode');"
										  	   onkeyup="code_CodeSelect(this, 'ModelCode');">

											<input type="text" name="prpLcarLossBrandName" class="codename" maxlength=50 description="厂牌型号名称" style="width:60%"  value="<%= prpLcarLossDto.getBrandName() %>"
											   ondblclick="code_CodeSelect(this, 'ModelCode','-1','name','none','post');"
											   onchange="code_CodeChange(this, 'ModelCode','-1','name','none','post');" 
											   onkeyup="code_CodeSelect(this, 'ModelCode','-1','name','none','post');">
										</td>
										<td class="title" colspan=2></td>
            									</tr>
            									
            									<tr>
       
       
       
     <!--   <td class="title" style="width:15%">厂牌型号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossBrandName" class="input" style='width:90px' value="<%= prpLcarLossDto.getBrandName() %>">
          <input name="prpLcarLossModelCode" type="hidden" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getModelCode() %>">          
        </td>
      </tr> -->
      
      <tr>
        <td class="common" style="width:15%">车辆种类</td>
        <td class="common" style="width:10%">
         <html:select name="prpLthirdParty1Dto" property="carKindCode" >
              <html:options collection="carKindCodes" property="codeCode" labelProperty="codeCName" />
         </html:select>
        </td>
        <td class="title" style="width:15%">发动机号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossEngineNo" class="input"  style='width:90px' value="<%= prpLcarLossDto.getEngineNo() %>">
        </td>
      </tr> 
      
      <tr>
        <td class="title" style="width:15%">车架号:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossFrameNo" class="input" style='width:90px' value="<%= prpLcarLossDto.getFrameNo() %>">
        </td>
        <td class="title" style="width:15%"></td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossVINNo" type=hidden class="input" style='width:160px' value="<%= prpLcarLossDto.getVINNo() %>">
        </td>
  <%}%>       
      </tr> 
        
      <input type="hidden" name="prpLcarLossLicenseColorCode" value="<%= prpLcarLossDto.getLicenseColorCode() %>">
      <input type="hidden" name="prpLcarLossCarKindCode" value="<%= prpLcarLossDto.getCarKindCode() %>">
      <input type="hidden" name="prpLcarLossInsureCarFlagName" value="<%= prpLcarLossDto.getInsureCarFlagName() %>">
      <input type="hidden" name="prpLcarLossInsureCarFlag"  value="<%= prpLcarLossDto.getInsureCarFlag() %>">
      <input type="hidden" name="prpLcarLossInsureComName" value="<%= prpLcarLossDto.getInsureComName() %>">
     
      <tr>
        <td class="title" style="width:15%">修理厂类型:</td>
        <td class="input" style='width:35%'>
	      
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
          <input name="prpLrepairFeeRepairFactoryName" class="input" style='width:220px' value="<%= prpLrepairFeeRepairFactoryName %>">
        </td>
      </tr> 
      <tr>
        <td class="title" style="width:15%">进厂日期:</td>
        <td class="input" style='width:35%'>
          <input name="prpLrepairFeeRepairStartDate" class="input" style='width:220px' value="<%= prpLrepairFeeRepairStartDate  %>" onblur="return checkFullDate(this);">
        </td>
        <td class="title" style="width:15%">约定交车日期:</td>
        <td class="input" style="width:35%">
          <input name="prpLrepairFeeRepairEndDate" class="input" style='width:220px' value="<%= prpLrepairFeeRepairEndDate %>" onblur="return checkFullDate(this);">
        </td>
      </tr>
       
      <tr>
        <td class="title" style="width:15%">经办人代码:</td>
        <td class="input" style='width:35%'>
          <input name="prpLrepairFeeHandlerCode" class="codecode" style='width:90px' value="<%= prpLrepairFeeHandlerCode %>"
                  ondblclick="code_CodeSelect(this, 'HanderCode');" 
                  onchange="code_CodeChange(this,'HanderCode');"
                  onkeyup= "code_CodeSelect(this, 'HanderCode');"> 
        </td> 
        <td class="title" style="width:15%">经办人名称:</td>
        <td class="input" style="width:35%">
         <input name="prpLrepairFeeHandlerName" class="codename" style='width:220px' value="<%= prpLrepairFeeHandlerName %>"
                 ondblclick="code_CodeSelect(this, 'HanderCode','-1','name','none','post');"
                 onchange="code_CodeChange(this, 'HanderCode','-1','name','none','post');"
                 onkeyup= "code_CodeSelect(this, 'HanderCode','-1','name','none','post');"> 
      </tr> 
      <tr> 
        <td class="title" style="width:15%">币别:</td>
        <td class="input" style='width:35%' >
          <input name="prpLcarLossCurrencyName" class="readonly" readonly="true" style='width:220px' value="人民币">
          <input type="hidden" name="prpLcarLossCurrency" class="readonly" readonly="true" style='width:220px' value="CNY">
        </td>
        <td class="title" style="width:15%">总定损金额:</td>
        <td class="input" style='width:35%' >
          <input name="prpLcarLossSumCertainLoss" class="readonly" readonly="true" value="<%= prpLcarLossDto.getSumCertainLoss() %>" style='width:220px' >
        </td>

        
      </tr>    
        <td class="title" style="width:100%" colspan="4">
          <%@include file="/DAA/certainLoss/DAARepairFeeSubList.jsp"%> 
        </td>
      </tr>   
      <tr>
        <td class="title" style="width:100%" colspan="4">
          <%@include file="/DAA/certainLoss/DAAComponentSubList.jsp"%> 
        </td>
      </tr>                 
                    
      <tr> 

    <td class="title" style="width:15%"></td>
          <td class="input" style='width:85%' colspan="3">
          	<!--<input type="hidden" name="prpLrepairFeeVeriManHourFee" value="1">              -->
            <input type="hidden" name="prpLcarLossBackCheckFlagCheck" <%= prpLcarLossDto.getBackCheckFlag().equals("1")? "checked":"" %>> 
            <input type="hidden" name="prpLcarLossBackCheckFlag" value="<%= prpLcarLossDto.getBackCheckFlag() %>"> 
          </td>   
        </tr>  
      <tr>
  
    </table>
    <%
        }
      }
    %>
    
     </span>  
    </td> 
   </tr>  
  </table>
