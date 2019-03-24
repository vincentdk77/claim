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
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.sysframework.reference.AppConfig" %>     
   
<%
   Collection collection = (Collection)request.getAttribute("partCodeList"); 
   Collection repairColl = (Collection)request.getAttribute("repairTypes"); 
   CertainLossDto certainLossDto1 = (CertainLossDto)request.getAttribute("certainLossDto");
   // 给损失险别赋默认值
   PrpLcarLossDto prpLcarLossDto1 =(PrpLcarLossDto)certainLossDto1.getPrpLcarLossDtoList().get(0);
   String kindCode = "";
   String kindName = "";
   if(prpLcarLossDto1.getRiskCode().equals("0506")
		   ||prpLcarLossDto1.getRiskCode().equals("0576")
		   ||prpLcarLossDto1.getRiskCode().equals("0586")){
     if(prpLcarLossDto1.getLossItemCode().trim().equals("1")){
       kindCode = "A";
       kindName = "车辆损失险";
     }
     else{
       kindCode = "B";
       kindName = "第三者责任险";
     }
   }
   else{
     kindCode = "BZ";
     kindName = "机动车交通事故责任强制险";
   } 
%>
<table id="RepairComponent" class=common cellpadding="5" cellspacing="1">
  <tr>
    <td>
      <span style="display:none"> 
        <table class="common" style="display:none" id="RepairFee_Data" cellpadding="5" cellspacing="1">
          <tbody>
            <%if(flag == null) {// 普通定损，非核损打回（定损、核损退回分开显示） %>
            <tr>
                <td class="input" style="width:5%" id="repairSerialNo">自动</td>
                <td class="input" style="width:16%">
                  <input type="hidden" name="carLossRepairFeeLossItemCode" style="width:20px">                  
                  <input type="hidden" name="prpLrepairFeeKindCode" value="<%=kindCode%>">
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:100%' value="<%=kindName %>"             
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
  			             onblur="checkKindCodeForRepair(this);">     
                </td>
                <td class="input" style="width:9%" style="display:none">
          		    <select name="prpLrepairFeePartCode" styleClass="three">
                   <%
                      Iterator prpLPartCodeNameList = collection.iterator();
                      while (prpLPartCodeNameList.hasNext()){
                      LabelValueBean labelValueBean = (LabelValueBean)prpLPartCodeNameList.next();
                   %>
                      <option value="<%= labelValueBean.getValue() %>"><%= labelValueBean.getLabel() %></option>
                   <%}%> 
                  </select>           
                  <input type="hidden" name="prpLrepairFeePartName" value="前部">
                </td> 
                <td class="input" style="width:16%">
                	<input name="prpLrepairFeeCompName" class="common" style="width:100%">  
                  <input type="hidden" name="prpLrepairFeeCompCode" value="9999">
                </td>
                <td class="input" style="width:10%">
                   <select name="prpLrepairFeeRepairType" styleClass="three">
                   <%
                      Iterator prpLrepairTypeList = repairColl.iterator();
                      while (prpLrepairTypeList.hasNext()){
                        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)prpLrepairTypeList.next();
                   %>
                      <option value="<%= prpDcodeDto.getCodeCode() %>"><%= prpDcodeDto.getCodeCName() %></option>
                   <%}%> 
                    </select>           
                </td>
                <td class="input" style="width:5%">                
                  <input name="prpLrepairFeeManHour" value="1"  class=common style='width:100%' onBlur="getSumDefLoss(this,1);">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLrepairFeeManHourUnitPrice" class="common"  style='width:100%' value="" onBlur="getSumDefLoss(this,1);" >
                </td>  
                <td class="input" style="width:12%">
                  <input name="prpLrepairFeeMaterialFee" type=hidden class=common>                
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:100%'>
                </td>
                <td class="input">                
                  <input name="prpLrepairFeeRemark" class=common style='width:100%' maxLength="60" onblur="checkLength1(this);" description="备注" >
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
                  <input type="hidden" name="prpLrepairFeeCompensateBackFlag">
                  <input type="hidden" name="prpLrepairFeeFirstSumDefLoss">
                <td class="input" style='width:4%'  align="center">
	                <div>
	                  <input type=button name="buttonRepairFeeDelete" class="smallbutton"  onclick="deleteRowTableRepairFee(this,'RepairFee',1,1)" value="-" style="cursor: hand">
	                </div>
                </td> 
              </tr>
              <%}else { // 核损异议打回修改 %>
              <tr>
                <td class="input" style="width:5%" align="center">自动</td>          
                <td class="input" style="width:10%">
                  <input type="hidden" name="carLossRepairFeeLossItemCode" style="width:20px">                  
                  <input type="hidden" name="prpLrepairFeeKindCode" value="<%=kindCode%>">
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:100%' value="<%=kindName %>"             
                     ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
                     onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
                     onblur="checkKindCodeForRepair(this);">     
                </td>
                <td class="input" style="width:6%" style="display:none">
                  <select name="prpLrepairFeePartCode" styleClass="three">
                   <%
                      Iterator prpLPartCodeNameList = collection.iterator();
                      while (prpLPartCodeNameList.hasNext()){
                      LabelValueBean labelValueBean = (LabelValueBean)prpLPartCodeNameList.next();
                   %>
                      <option value="<%= labelValueBean.getValue() %>"><%= labelValueBean.getLabel() %></option>
                   <%}%> 
                  </select>           
                  <input type="hidden" name="prpLrepairFeePartName" value="前部">
                </td> 
                <td class="input" style="width:13%">
                  <input name="prpLrepairFeeCompName" class="common" style="width:100%">  
                  <input type="hidden" name="prpLrepairFeeCompCode" value="9999">
                </td>
                <td class="input" style="width:6%">
                   <select name="prpLrepairFeeRepairType" styleClass="three">
                   <%
                      Iterator prpLrepairTypeList = repairColl.iterator();
                      while (prpLrepairTypeList.hasNext()){
                        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)prpLrepairTypeList.next();
                   %>
                      <option value="<%= prpDcodeDto.getCodeCode() %>"><%= prpDcodeDto.getCodeCName() %></option>
                   <%}%> 
                    </select>           
                </td>
                <td class="input" style="width:5%">
                  <input name="prpLrepairFeeManHour" value="1"  class=common style='width:100%' onBlur="getSumDefLoss(this,1);">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLrepairFeeManHourUnitPrice" class="common"  style='width:100%' value="" onBlur="getSumDefLoss(this,1);" >
                </td>  
                <td class="input" style="width:10%">
                  <input name="prpLrepairFeeMaterialFee" type="hidden">                
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:100%'>
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLrepairFeeRemark" class=common style='width:100%' maxLength="60" onblur="checkLength1(this);" description="备注" >
                </td>
                <!-- 以下三行为核损信息，定损时为空，只是用来占位置，保证显示格式美观 Leaved YEHUIQUAN -->
                <td class="input" style="width:8%"></td>
                <td class="input" style="width:10%"></td>
                <td class="input"></td>
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
                  <input type="hidden" name="prpLrepairFeeCompensateBackFlag">
                  <input type="hidden" name="prpLrepairFeeFirstSumDefLoss">
                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonRepairFeeDelete" class="smallbutton"  onclick="deleteRowTableRepairFee(this,'RepairFee',1,1)" value="-" style="cursor: hand">
                  </div>
                </td> 
              </tr>
              <%}%>
            </tbody>
          </table>
        </span>
        
        <!-- 换件信息隐藏域 -->
        <span style="display:none"> 
          <table class="common" style="display:none" id="Component_Data" cellspacing="1" cellpadding="0">
            <tbody>
            <%if(flag == null) {// 普通定损，非核损打回（定损、核损退回分开显示，国元将核损信息放到了一行，页面的cosplan不同，所以分开显示） %>
              <tr>  
                <td class="input" style="width:5%" align="center">自动
                  <input type="hidden" name="carLossComponentLossItemCode" style="width:20px">              
                  <input  type="hidden" name="prpLcomponentKindCode" value="<%=kindCode%>">
                </td>            
                <td class="input" style="width:16%">
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:100%' value="<%=kindName%>"      
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
  			             onblur="checkKindCodeForRepair(this);">        
                </td>                
                <td class="input" style="width:8%">
                	<input name="prpLcomponentCompCode" value="9999" class="readonly" readonly style='width:100%'>
                </td>     
                <td class="input"  style="width:16%">
                  <input name="prpLcomponentCompName" class="common"  style='width:100%'>
                  <input type="hidden" name="prpLcomponentPartCode" value="01">
                  <input type="hidden" name="prpLcomponentPartName" value="前部">
                </td>
                <td class="input"  style="width:5%">               
                  <input name="prpLcomponentQuantity"  value="1" class=common style='width:100%' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLcomponentManHourFee" value="0" class=common style='width:100%' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input"  style="width:10%">
                  <input name="prpLcomponentMaterialFee" class=common style='width:100%' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input"  style="width:10%">
                  <input name="prpLcomponentSys4SPrice" type="text" readonly="readonly" class=common style='width:100%' >
                  <input name="prpLcomponentQuotedPrice" type="hidden" >
                </td>
                <td class="input"  style="width:8%">
                  <input name="prpLcomponentRestFee" class=common style='width:100%'  onBlur="getSumDefLoss(this,2);calculateSumRestFee(this);">
                </td> 
                <td class="input"  style="width:12%">                
                  <input name="prpLcomponentSumDefLoss" class="readonly" readonly style='width:100%' >
                </td>
                <td class="input">                
                  <input name="prpLcomponentRemark" class=common style='width:100%' maxLength="60" onblur="checkLength1(this);" description="备注">
                </td> 
                  <input type="hidden" name="prpLcomponentOriginalId">
                  <input type="hidden" name="prpLcomponentIndId">
                  <input type="hidden" name="prpLcomponentSysMatchPrice">
                  <input type="hidden" name="prpLcomponentNative4SPrice">
                  <input type="hidden" name="prpLcomponentNativeMarketPrice">
                  <input type="hidden" name="prpLcomponentNativeMatchPrice">
                  <input type="hidden" name="prpLcomponentVerpCompPrice">                  
                  <input type="hidden" name="prpLcomponentSysMarketPrice"> 
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
                  <input type="hidden" name="prpLcomponentLossRate">                 
                  <input type="hidden" name="prpLcomponentCurrency">                 
                  <input type="hidden" name="prpLcomponentVeriRemark">                   
                  <input type="hidden" name="prpLcomponentVeriQuantity">              
                  <input type="hidden" name="prpLcomponentVeriManHourFee">           
                  <input type="hidden" name="prpLcomponentVeriMaterFee">             
                  <input type="hidden" name="prpLcomponentVeriLossRate">              
                  <input type="hidden" name="prpLcomponentVeriRestFee">       
                  <input type="hidden" name="prpLcomponentSumVeriLoss">               
                  <input type="hidden" name="prpLcomponentFlag">   
                  <input type="hidden" name="prpLcomponentCompensateBackFlag"> 
                <td class="input" style='width:4%'  align="center">
	                <div>
	                  <input type=button name="buttonComponentDelete"  class="smallbutton" onclick="deleteRowTableComponent(this,'Component',1,1)" value="-" style="cursor: hand">
	                </div>
                </td>
              </tr>
              <%}else{ // 核损退回 %>
              <tr>  
                <td class="input" style="width:5%" align="center">自动
                  <input type="hidden" name="carLossComponentLossItemCode" style="width:20px">              
                  <input  type="hidden" name="prpLcomponentKindCode" value="<%=kindCode%>">
                </td>            
                <td class="input" style="width:14%">
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:100%' value="<%=kindName%>"      
                     ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
                     onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
                     onblur="checkKindCodeForRepair(this);">        
                </td>
                <td class="input" style="width:8%">
                	<input name="prpLcomponentCompCode" value="9999" class="readonly" readonly style='width:100%'>
                </td>                
                <td class="input"  style="width:14%">
                  <input name="prpLcomponentCompName" class="common"  style='width:100%'>
                  <input type="hidden" name="prpLcomponentPartCode" value="01">
                  <input type="hidden" name="prpLcomponentPartName" value="前部">
                </td>
                <td class="input"  style="width:5%">               
                  <input name="prpLcomponentQuantity"  value="1" class=common style='width:100%' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLcomponentManHourFee" value="0" class=common style='width:100%' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input"  style="width:10%">
                  <input name="prpLcomponentMaterialFee" class=common style='width:100%' onBlur="getSumDefLoss(this,2);">
                </td>
                <td class="input"  style="width:10%">
                  <input name="prpLcomponentSys4SPrice" type="text" readonly="readonly" class=common style='width:100%' >
                  <input name="prpLcomponentQuotedPrice" type="hidden" >
                </td>
                <td class="input"  style="width:8%">
                  <input name="prpLcomponentRestFee" class=common style='width:100%'  onBlur="getSumDefLoss(this,2);calculateSumRestFee(this);">
                </td> 
                <td class="input" style="width:10%">                
                  <input name="prpLcomponentSumDefLoss" class="readonly" readonly style='width:100%' >
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLcomponentRemark" class=common style='width:100%' maxLength="60" onblur="checkLength1(this);" description="备注">
                </td>
                <td class="input" style="width:10%"></td><!-- 核损金额占位置 -->
                  <input type="hidden" name="prpLcomponentOriginalId">
                  <input type="hidden" name="prpLcomponentIndId">
                  <input type="hidden" name="prpLcomponentSysMatchPrice">
                  <input type="hidden" name="prpLcomponentNative4SPrice">
                  <input type="hidden" name="prpLcomponentNativeMarketPrice">
                  <input type="hidden" name="prpLcomponentNativeMatchPrice">
                  <input type="hidden" name="prpLcomponentVerpCompPrice">                  
                  <input type="hidden" name="prpLcomponentSysMarketPrice"> 
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
                  <input type="hidden" name="prpLcomponentLossRate">                 
                  <input type="hidden" name="prpLcomponentCurrency">                 
                  <input type="hidden" name="prpLcomponentVeriRemark">                   
                  <input type="hidden" name="prpLcomponentVeriQuantity">              
                  <input type="hidden" name="prpLcomponentVeriManHourFee">           
                  <input type="hidden" name="prpLcomponentVeriMaterFee">             
                  <input type="hidden" name="prpLcomponentVeriLossRate">              
                  <input type="hidden" name="prpLcomponentVeriRestFee">       
                  <input type="hidden" name="prpLcomponentSumVeriLoss">               
                  <input type="hidden" name="prpLcomponentFlag">   
                  <input type="hidden" name="prpLcomponentCompensateBackFlag"> 
                <td class="input" style='width:4%'  align="center">
                  <div>
                    <input type=button name="buttonComponentDelete"  class="smallbutton" onclick="deleteRowTableComponent(this,'Component',1,1)" value="-" style="cursor: hand">
                  </div>
                </td>
              </tr>
              <%} %>
            </tbody>
          </table>
        </span>      
    <span  id="SpanRepairComponent"  cellspacing="1" cellpadding="0">
    <%
      CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
      PrpLrepairFeeDto prpLrepairFeeDto = (PrpLrepairFeeDto)request.getAttribute("prpLrepairFeeDto");
      PrpLcomponentDto prpLcomponentDto = (PrpLcomponentDto)request.getAttribute("prpLcomponentDto");
      //List prpLthirdPartyList = (List)request.getAttribute("prpLthirdParty1Dto");
        
      int carLossSize = certainLossDto.getPrpLcarLossDtoList().size();
      if(carLossSize > 0 ){
        for(int i = 0 ;i < carLossSize; i++){
          PrpLcarLossDto prpLcarLossDto =(PrpLcarLossDto)certainLossDto.getPrpLcarLossDtoList().get(i);   
          String prpLrepairFeeRepairFactoryCode = "";
          String prpLrepairFeeRepairFactoryName = "";
          String prpLrepairFeeRepairStartDate = "";
          String prpLrepairFeeRepairEndDate = "";
          String prpLrepairFeeHandlerCode = "";
          String prpLrepairFeeHandlerName = ""; 
          String prpLName ="";
          
          
 //         if(prpLcarLossDto.getLossItemCode().trim().equals("0")){
 //       	  for(int i=0; i < prpLthirdPartyList.size(); i++){
 //       		  PrpLthirdPartyDto  prpLthirdPartyDto = (PrpLthirdPartyDto)prpLthirdPartyList.get(i);
 //       		  String strSerNo = ""+prpLthirdPartyDto.getSerialNo();
 //       		  if(prpLcarLossDto.getLossItemCode().equals(strSerNo)){
 //       			  
 //       		  }
 ///       	  }
        	  //prpLcarLossDto.getLossItemCode();
 //         }
         
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
          }
          else if (prpLrepairFeeDto.getRepairFeeList() == null && !"SHOW".equals(editType)){
           prpLrepairFeeHandlerCode = user.getUserCode();
           prpLrepairFeeHandlerName = user.getUserName();
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
          String sysAreaCode = "";
          String localAreaCode = "";
          if(!"SHOW".equals(editType)){
	          sysAreaCode = user.getSysAreaCode();
	          localAreaCode = user.getComCode();
	          localAreaCode = localAreaCode.substring(0,3) + "0000000"; //取分公司机构代码
          }

    %>
    <input type="hidden" name="carLossSize" value="<%= carLossSize %>">
    <table  class=common cellpadding="5" cellspacing="1" >
      <tr>
        <td class="subformtitle"  colspan="4">理赔车辆</td>
      </tr>
      <tr>   
        <td class="title" style="width:15%">车辆序号:                               
          <input type="hidden" name="prpLcarLossSumManager" value="<%= prpLcarLossDto.getSumManager() %>">     
          <input type="hidden" name="prpLcarLossSumVeriRest" value="<%= prpLcarLossDto.getSumVeriRest() %>">     
          <input type="hidden" name="prpLcarLossSumVeriManager" value="<%= prpLcarLossDto.getSumVeriManager() %>">         
          <input type="hidden" name="prpLcarLossSumCertainLoss" value="<%= prpLcarLossDto.getSumCertainLoss() %>">    
          <input type="hidden" name="prpLcarLossSumVerifyLoss" value="<%= prpLcarLossDto.getSumVerifyLoss() %>">  
          <input type="hidden" name="prpLcarLossSumTransFee" value="<%=prpLcarLossDto.getSumTransFee()%>">
          <input type="hidden" name="prpLcarLossSumTax" value="<%=prpLcarLossDto.getSumTax() %>">
          <input type="hidden" name="prpLcarLossLossDesc" value="<%= prpLcarLossDto.getLossDesc() %>">          
          <input type="hidden" name="prpLcarLossIndemnityDuty" value="<%= prpLcarLossDto.getIndemnityDuty() %>">     
          <input type="hidden" name="prpLcarLossIndemnityDutyRate" value="<%= prpLcarLossDto.getIndemnityDutyRate() %>"> 
          <input type="hidden" name="prpLcarLossVeriIndeDutyRate" value="<%= prpLcarLossDto.getVeriIndeDutyRate() %>">  
          <input type="hidden" name="prpLcarLossRemark" value="<%= prpLcarLossDto.getRemark() %>">            
          <input type="hidden" name="prpLcarLossOperatorCode" value="<%= prpLcarLossDto.getOperatorCode() %>">      
          <input type="hidden" name="prpLcarLossApproverCode" value="<%= prpLcarLossDto.getApproverCode() %>">      
          <input type="hidden" name="prpLcarLossFlag" value="<%= prpLcarLossDto.getFlag() %>">              
          <input type="hidden" name="verifyPriceFlag" value="0">                        
          <input type="hidden" name="SysAreaCode" value="<%=sysAreaCode%>">                        
          <input type="hidden" name="LocalAreaCode" value="<%=localAreaCode%>"">      
        </td> 
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemCode" class="readonly" readonly="true" style='width:90px'  value="<%= prpLcarLossDto.getLossItemCode() %>">
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
        <td class="title" style="width:15%">厂牌型号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossBrandName" class="input" style='width:90px' value="<%= prpLcarLossDto.getBrandName() %>">
          <img src="/prpall/common/images/markMustInput.jpg">
                <a href="#" onClick="queryModelCode(fm.riskcode.value);"><nobr>查询</nobr></a>
        </td>
      </tr> 
      
      <tr>
      <td class="title" style="width:15%">车辆种类:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossModelCode" type="hidden" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getModelCode() %>">          
       
          <input name="prpLcarLossCarKindName" class="readonly" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getCarKindName() %>">
        </td> 
        <td class="title" style="width:15%">发动机号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossEngineNo" class="readonly" readonly="true"  style='width:90px' value="<%= prpLcarLossDto.getEngineNo() %>">
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
  
<%}else{%>        
        <td class="title" style="width:15%"><font color="red">三者车</font></td>
        <td class="input" style="width:35%">&nbsp;</td>
      </tr>   
     
      <tr>
        <td class="title" style="width:15%">号牌号码:</td>
        <td class="input" style='width:35%'>
          <input name="prpLcarLossLossItemName" class="input"  style='width:90px' value="<%= prpLcarLossDto.getLossItemName() %>">
        </td>
        <td class="title" style="width:15%">厂牌型号:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossBrandName" class="input" style='width:90px' value="<%= prpLcarLossDto.getBrandName() %>">
          <img src="/claim/images/bgMarkMustInput.jpg">
                <a href="#" onClick="queryModelCode(fm.riskcode.value);"><nobr>查询</nobr></a>
        </td>
      </tr> 
      
      <tr>
        <td class="common" style="width:15%">车辆种类</td>
        <td class="common" style="width:10%">
          <input name="prpLcarLossModelCode" type="hidden" readonly="true" style='width:90px' value="<%= prpLcarLossDto.getModelCode() %>">
          <html:select name="prpLthirdParty1Dto" property="carKindCode" style='width:200px'>
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
        <td class="title" style="width:15%">VIN码:</td> 
        <td class="input" style="width:35%">
          <input name="prpLcarLossVINNo" class="input" style='width:160px' value="<%= prpLcarLossDto.getVINNo() %>">
        </td>
      </tr>  
  <%}%>       
      <input type="hidden" name="prpLcarLossLicenseColorCode" value="<%= prpLcarLossDto.getLicenseColorCode() %>">
      <input type="hidden" name="prpLcarLossCarKindCode" value="<%= prpLcarLossDto.getCarKindCode() %>">
      <input type="hidden" name="prpLcarLossInsureCarFlagName" value="<%= prpLcarLossDto.getInsureCarFlagName() %>">
      <input type="hidden" name="prpLcarLossInsureCarFlag"  value="<%= prpLcarLossDto.getInsureCarFlag() %>">
      <input type="hidden" name="prpLcarLossInsureComCode" value="<%= prpLcarLossDto.getInsureComCode() %>">
      <input type="hidden" name="prpLcarLossInsureComName" value="<%= prpLcarLossDto.getInsureComName() %>">
<%
	if(!prpLrepairFeeRepairFactoryCode.trim().equals("")){
		
%>    
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
          <input name="prpLrepairFeeRepairFactoryName" class="input" style='width:220px' value="<%= prpLrepairFeeRepairFactoryName %>">
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
             <option value="03" <%= prpLcarLossDto.getRepairFactoryCode().equals("03")? "selected":"" %>>二类厂</option>                                
             <option value="02" <%= prpLcarLossDto.getRepairFactoryCode().equals("02")? "selected":"" %>>一类厂</option>                   
             <option value="01" <%= prpLcarLossDto.getRepairFactoryCode().equals("01")? "selected":"" %>>4S店</option>
          </select>   
        <img src="/claim/images/bgMarkMustInput.jpg">

        </td>
        <td class="title" style="width:15%">修理厂名称:</td>
        <td class="input" style="width:35%">
          <input name="prpLrepairFeeRepairFactoryName" class="input" style='width:220px' value="<%= prpLcarLossDto.getRepairFactoryName() %>">
        </td>
      </tr> 
<%
		
	}
%>
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
        <td class="input" style='width:85%' colspan="3">
          <input name="prpLcarLossCurrencyName" class="readonly" readonly="true" style='width:220px' value="人民币">
          <input type="hidden" name="prpLcarLossCurrency" class="readonly" readonly="true" style='width:220px' value="CNY">
        </td>
      </tr>    
        <td class="title" style="width:100%" colspan="4">
          <%@include file="/DAA/certainLoss/DAACertainLossRepairFee.jsp"%> 
        </td>
      </tr>   
      <tr>
        <td class="title" style="width:100%" colspan="4">
          <%@include file="/DAA/certainLoss/DAACertainLossComponent.jsp"%> 
        </td>
      </tr>                 
                    
    <%
  String lossItemCodeN = request.getParameter("lossItemCode");
  String nodeTypeN = request.getParameter("nodeType");
  String display = "none";
   if("certa".equals(nodeTypeN)){
     display = "none"; //目前客户没有类似的需求,该复勘功能是安信的功能国元暂时不需要,因此将其不显示
     }
%>                    
      <tr STYLE="Display:'<%=display%>'" > 
          <td class="title" style="width:15%">是否需要复勘:</td>
          <td class="input" style='width:85%' colspan="3"> 
          <% String backCheckYes="";  
             String backCheckNo="checked";
             
             
             if (prpLcarLossDto.getBackCheckFlag().equals("0")) {
             backCheckNo="checked";
             backCheckYes="";
             }
             if (prpLcarLossDto.getBackCheckFlag().equals("1")) {
             backCheckYes="checked";
              backCheckNo="";
             }
             
          %>
              <input type="radio" name="prpLcarLossBackCheckFlag" value="1" <%= backCheckYes %>>是
              <input type="radio" name="prpLcarLossBackCheckFlag" value="0" <%= backCheckNo %>>否            
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
