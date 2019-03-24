<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date             Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page import="java.util.*"%>
  <script type="text/javascript">
    function checkKindCodeForRepair(field){
        var repairKindName = field.name;     
        var repareKindCode = repairKindName.substring(0,repairKindName.indexOf('KindName')) + "KindCode";        
        for(var i = 0; i < fm.all(repairKindName).length;i++){
            if(fm.all(repairKindName)[i] == field){
                if(fm.all(repareKindCode)[i].value == "D3" ||fm.all(repareKindCode)[i].value == "D4"){
                    alert("修理/换件项目中不能录入此险别："+ fm.all(repairKindName)[i].value + "-" + fm.all(repareKindCode)[i].value);
                    fm.all(repareKindCode)[i].value = "";
                    fm.all(repairKindName)[i].value = "";
                    break;
                }            
            }
        }
    }
</script>
   <table class="common" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4">  
        <span  id="spanRepairFee"cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common"  id="RepairFee" cellpadding="5" cellspacing="1" border='0'>
          <%if(flag == null) {// 普通定损，非核损打回 %>
          <thead>
            <tr>
              <td class="subformtitle" colspan=9>修理项目费用清单</td>
            </tr>
            <tr>
              <td class="centertitle" style="width:5%">序号</td>
              <td class="centertitle" style="width:16%">险别名称</td>
              <td class="centertitle" style="width:9%" style="display:none">修理部位</td>
              <td class="centertitle" style="width:16%">零件(项目)名称</td>
              <td class="centertitle" style="width:10%">修理方式</td>
              <td class="centertitle" style="width:5%">工时</td>                  
              <td class="centertitle" style="width:10%">工时单价</td>
              <td class="centertitle" style="width:12%">定损金额</td>   
              <td class="centertitle">备注</td>
              <td class="centertitle" style="width:4%">&nbsp;</td>
            </tr>
          </thead>
          <%}else{ // 定损退回 %>
          <thead>
            <tr>
              <td class="subformtitle" colspan=12>修理项目费用清单</td>
            </tr>
            <tr>
              <td class="centertitle" style="width:5%">序号</td>
              <td class="centertitle" style="width:10%">险别名称</td>
              <td class="centertitle" style="width:7%" style="display:none">修理部位</td>
              <td class="centertitle" style="width:13%">零件(项目)名称</td>
              <td class="centertitle" style="width:9%">修理方式</td>
              <td class="centertitle" style="width:5%">工时</td>                  
              <td class="centertitle" style="width:8%">定工时费</td>
              <td class="centertitle" style="width:10%">定损金额</td>   
              <td class="centertitle" style="width:10%">定损备注</td>
              <td class="centertitle" style="width:8%">核工时费</td>
              <td class="centertitle" style="width:10%">核损金额</td>
              <td class="centertitle">核损备注</td>
              <td class="centertitle" style="width:4%">&nbsp;</td>
            </tr>
          </thead>
          <%}%>
          <tfoot> 
              <tr>
                <%if(flag !=null && flag.equals("1")){ // 核损退回%>
                  <td class="title" colspan=11 style="width:96%">(按"+"号键增加修理项目费用信息，按"-"号键删除信息)
                    <logic:equal name="prpLverifyLossDto" property="verifyOpinion" value="02">
                      <input type="button" class=bigbutton value="同意核损金额" onclick="getVerifyRepairFee();" name="buttonAgreeVerifyRepairFeeLoss" style="cursor: hand">   
                    </logic:equal>
                  </td>
                <%}else {%>
                  <td class="title" colspan=8 style="width:96%">(按"+"号键增加修理项目费用信息，按"-"号键删除信息)</td>
                <%}%>
                <td class="title" align="right" style="width:4%">
                   <div align="center">
                     <input type="button" class=smallbutton value="+" onclick="insertThreeRowTableRepairFee('RepairFee','RepairFee_Data',this)" name="buttonRepairFee" style="cursor: hand">
                   </div>
                 </td>
              </tr>
              <tr>
                <td colspan="10" style="width:100%">
                  <table cellpadding="6" cellspacing="1"  class="common" >
                    <tr>
                      <td class='title' style="display:none"  colspan="1" width="30%">工时费合计:<input class='readonly' readonly="true" style='width:80px' name='SumManHourFee1'>
                      </td>    
                      <td class='title' style="display:none"  colspan="1" width="30%">材料费合计:<input class='readonly'  readonly="true" style='width:80px' name='SumMaterialFee1'>
                      </td>   
                      <td class='title' width="100%">修理合计:<input class='readonly'  readonly="true" style='width:80px' name='SumDefLoss1'>
                      </td>     
                    </tr>
                  </table>  
                </td>
              </tr>
           </tfoot> 
          <tbody> 
<% indexCertainLoss=0;%>
<% String compensatebackReadOnly=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackDiasable=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackStyle=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String repairComNameEmpty=""; //如果是理算退回的，若零件项目名称为空不能设为只读%> 
<% String repairComNameEmptyStyle=""; //如果是理算退回的，若零件项目名称为空不能设为只读%> 
<%
      repairFeeNo = 0;
      if(prpLrepairFeeDto.getRepairFeeList() != null){
        for(int index1 = 0;index1<prpLrepairFeeDto.getRepairFeeList().size();index1++){
          PrpLrepairFeeDto prpLrepairFeeDto1 = (PrpLrepairFeeDto)prpLrepairFeeDto.getRepairFeeList().get(index1);
          if(prpLrepairFeeDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
          repairFeeNo = Integer.parseInt(prpLrepairFeeDto1.getLossItemCode());
          //增加理算退回的判断
          compensatebackReadOnly="";
          compensatebackDiasable="";
          compensatebackStyle="";
          repairComNameEmpty= "";
          repairComNameEmptyStyle = "";
          if ("1".equals(prpLrepairFeeDto1.getCompensateBackFlag())) {
              compensatebackStyle=";background:#CECECE";
             compensatebackReadOnly="readOnly";
             compensatebackDiasable="disabled";
             String comPName = prpLrepairFeeDto1.getCompName();
             if(!"".equals(comPName) && comPName != null){
            	 repairComNameEmpty = "readOnly";
            	 repairComNameEmptyStyle = ";background:#CECECE";
             }
          }
%>
<%
          if(flag==null||flag.length()<1){ // 定损
%>
              <tr>        
                <td class="input" style="width:5%" align="center">
                  <%=index1+1 %>
                  <input type="hidden" name="carLossRepairFeeLossItemCode" value="<%= repairFeeNo-1 %>">                
                  <input type="hidden" name="prpLrepairFeeKindCode" value="<%= prpLrepairFeeDto1.getKindCode() %>">
                </td>
                <td class="input" style="width:16%">   
                <%if (prpLcarLossDto1.getLossItemCode().trim().equals("1")){ %>
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getKindName() %>"                     
			             <% if (compensatebackReadOnly.equals("")){%>
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');" 
  			             onblur="checkKindCodeForRepair(this);checkKindCodeForRepair(this);"<%}%> > 
  			        <%}else{ %>        
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getKindName() %>"                     
                   <% if (compensatebackReadOnly.equals("")){%>
                     ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
                     onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');" 
                     onblur="checkKindCodeForRepair(this);checkKindCodeForRepair(this);"<%}%> > 
  			     <%} %>
                </td> 
                <td class="input" style="width:9%" style="display:none">
          		    <select name="prpLrepairFeePartCode" styleClass="three">
                   <%
                      Iterator prpLrepairFeeList = collection.iterator();
                      while (prpLrepairFeeList.hasNext()){
                        LabelValueBean labelValueBean = (LabelValueBean)prpLrepairFeeList.next();
                        //如果是理算退回的，那么只有当等于数据的那条记录才被增加到界面上,如果不是这样的，照常 lixiang
                        if ("1".equals(prpLrepairFeeDto1.getCompensateBackFlag())
                        		&& (!labelValueBean.getValue().trim().equals(prpLrepairFeeDto1.getPartCode().trim())))  
                        	continue;
                   %>
                      <option value="<%= labelValueBean.getValue() %>" <%= ((labelValueBean.getValue().trim().equals(prpLrepairFeeDto1.getPartCode().trim())) ? "selected" : "") %>><%= labelValueBean.getLabel() %></option>
                    <%
                       }
                   %> 
                    </select>  
                    <input type="hidden" name="prpLrepairFeePartName" value="<%= prpLrepairFeeDto1.getPartName() %>">
                </td>    
                <td class="input" style="width:16%">
                  <input name="prpLrepairFeeCompName" class="common" style="width:100%"  	
                    value="<%= prpLrepairFeeDto1.getCompName() %>">  
                  <input type="hidden" name="prpLrepairFeeCompCode" value="<%= prpLrepairFeeDto1.getCompCode() %>">
                </td>
                <td class="input" style="width:10%">
                   <select name="prpLrepairFeeRepairType" styleClass="three" style="width:90%">
                   <%
                      Iterator prpLrepairTypeList2 = repairColl.iterator();
                      while (prpLrepairTypeList2.hasNext()){
                        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)prpLrepairTypeList2.next();
                        //如果是理算退回的，那么只有当等于数据的那条记录才被增加到界面上,如果不是这样的，照常 lixiang
                        if ("1".equals(prpLrepairFeeDto1.getCompensateBackFlag())
                        		&& !(prpDcodeDto.getCodeCode().trim().equals(prpLrepairFeeDto1.getRepairType().trim()))) 
                        	continue;
                   %>
                        <option value="<%= prpDcodeDto.getCodeCode() %>" <%= ((prpDcodeDto.getCodeCode().trim().equals(prpLrepairFeeDto1.getRepairType().trim())) ? "selected" : "") %>><%= prpDcodeDto.getCodeCName() %></option>
                   <%
                       }
                   %> 
                   </select>           
                </td> 
                <td class="input" style="width:5%">
                  <input name="prpLrepairFeeManHour" class=common style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>  value="<%= prpLrepairFeeDto1.getManHour() %>" onBlur="return getSumDefLoss(this,1);">
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLrepairFeeManHourUnitPrice" class="common"   style='width:100%' value="<%= prpLrepairFeeDto1.getManHourUnitPrice() %>" onBlur="return getSumDefLoss(this,1);">
                </td>  
                <td class="input"style="display:none">                
                  <input name="prpLrepairFeeMaterialFee"  class=common style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getMaterialFee() %>" >
                </td> 
                <td class="input" style="width:12%">                
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:100%' value="<%= prpLrepairFeeDto1.getSumDefLoss() %>">
                </td>
                <td class="input">                  
                  <input name="prpLrepairFeeRemark" class="common" maxLength="60" onblur="checkLength1(this);" description="备注" 
                  		style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getRemark() %>">
                </td>
                  <input type="hidden" name="prpLrepairFeeSerialNo" value="<%= prpLrepairFeeDto1.getSerialNo() %>">                  
                  <input type="hidden" name="prpLrepairFeeItemKindNo" value="<%= prpLrepairFeeDto1.getItemKindNo() %>">                 
                  <input type="hidden" name="prpLrepairFeeLossItemCode" value="<%= prpLrepairFeeDto1.getLossItemCode() %>">                 
                  <input type="hidden" name="prpLrepairFeeLicenseNo" value="<%= prpLrepairFeeDto1.getLicenseNo() %>">                  
                  <input type="hidden" name="prpLrepairFeeLicenseColorCode" value="<%= prpLrepairFeeDto1.getLicenseColorCode() %>">           
                  <input type="hidden" name="prpLrepairFeeCarKindCode" value="<%= prpLrepairFeeDto1.getCarKindCode() %>">               
                  <input type="hidden" name="prpLrepairFeeSanctioner" value="<%= prpLrepairFeeDto1.getSanctioner() %>">                 
                  <input type="hidden" name="prpLrepairFeeApproverCode" value="<%= prpLrepairFeeDto1.getApproverCode() %>">               
                  <input type="hidden" name="prpLrepairFeeOperatorCode" value="<%= prpLrepairFeeDto1.getOperatorCode() %>">               
                  <input type="hidden" name="prpLrepairFeeManHourFee" value="<%= prpLrepairFeeDto1.getManHourFee() %>">                  
                  <input type="hidden" name="prpLrepairFeeLossRate" value="<%= prpLrepairFeeDto1.getLossRate() %>">                   
                  <input type="hidden" name="prpLrepairFeeCurrency" value="<%= prpLrepairFeeDto1.getCurrency() %>">                   
                  <input type="hidden" name="prpLrepairFeeVeriRemark" value="<%= prpLrepairFeeDto1.getRemark() %>">                     
                  <input type="hidden" name="prpLrepairFeeVeriManHour" value="<%= prpLrepairFeeDto1.getVeriManHour() %>">                
                  <input type="hidden" name="prpLrepairFeeVeriManUnitPrice" value="<%= prpLrepairFeeDto1.getVeriManUnitPrice() %>">           
                  <input type="hidden" name="prpLrepairFeeVeriManHourFee" value="<%= prpLrepairFeeDto1.getVeriManHourFee() %>">             
                  <input type="hidden" name="prpLrepairFeeVeriMaterQuantity" value="<%= prpLrepairFeeDto1.getVeriMaterQuantity() %>">          
                  <input type="hidden" name="prpLrepairFeeVeriMaterUnitPrice" value="<%= prpLrepairFeeDto1.getVeriMaterUnitPrice() %>">         
                  <input type="hidden" name="prpLrepairFeeVeriMaterialFee" value="<%= prpLrepairFeeDto1.getVeriMaterialFee() %>">            
                  <input type="hidden" name="prpLrepairFeeVeriLossRate" value="<%= prpLrepairFeeDto1.getVeriLossRate() %>">               
                  <input type="hidden" name="prpLrepairFeeVeriSumLoss" value="<%= prpLrepairFeeDto1.getVeriSumLoss() %>">                 
                  <input type="hidden" name="prpLrepairFeeFlag" value="<%= prpLrepairFeeDto1.getFlag() %>">
                  <input type="hidden" name="prpLrepairFeeCompensateBackFlag" value="<%= prpLrepairFeeDto1.getCompensateBackFlag() %>">
                  <input type="hidden" name="prpLrepairFeeFirstSumDefLoss" value="<%= prpLrepairFeeDto1.getFirstSumDefLoss() %>">
                <td class="input" style='width:4%'  align="center">
	                <div>
	                  <input type=button name="buttonRepairFeeDelete" class=smallbutton <%=compensatebackDiasable%> onclick="deleteRowTableRepairFee(this,'RepairFee',1,1)" value="-" style="cursor: hand">
	                </div>
                </td>
              </tr>   
<%
              } else { // 核损退回
%>    
              <tr>
                <td class="input" style="width:5%" align="center"><%= index1+1 %></td>
                <td class="input" style="width:10%">
                  <input type="hidden" name="carLossRepairFeeLossItemCode" <%=compensatebackReadOnly%> value="<%= repairFeeNo-1 %>">                
                  <input type="hidden" name="prpLrepairFeeKindCode" value="<%= prpLrepairFeeDto1.getKindCode() %>">   
                  <input type="text" name="prpLrepairFeeKindName" class="codename" style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getKindName() %>"                     
  			            <% if (compensatebackReadOnly.equals("")){%>  
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
  			             onblur="checkKindCodeForRepair(this);checkKindCodeForRepair(this);" <%}%> >       
                </td>
                <td class="input" style="width:7%;display:none">
                   <select name="prpLrepairFeePartCode" styleClass="three">
                   <%
                      Iterator prpLrepairFeeList = collection.iterator();
                      while (prpLrepairFeeList.hasNext()){
                        LabelValueBean labelValueBean = (LabelValueBean)prpLrepairFeeList.next();
                        //如果是理算退回的，那么只有当等于数据的那条记录才被增加到界面上,如果不是这样的，照常 lixiang
                        if ("1".equals(prpLrepairFeeDto1.getCompensateBackFlag())
                        		&& (!labelValueBean.getValue().trim().equals(prpLrepairFeeDto1.getPartCode().trim()))) 
                        	continue;
                   %>
                      <option value="<%= labelValueBean.getValue() %>" <%= ((labelValueBean.getValue().trim().equals(prpLrepairFeeDto1.getPartCode().trim())) ? "selected" : "") %>><%= labelValueBean.getLabel() %></option>
                    <%
                       }
                   %> 
                   </select>
                  <input type="hidden" name="prpLrepairFeePartName"  value="<%= prpLrepairFeeDto1.getPartName() %>" >
                </td>    
                <td class="input" style="width:13%">
                  <input name="prpLrepairFeeCompName" class="common" style="width:100%<%=repairComNameEmptyStyle%>" <%=repairComNameEmpty%>  			             
                    value="<%= prpLrepairFeeDto1.getCompName() %>">  
                  <input type="hidden" name="prpLrepairFeeCompCode" value="<%= prpLrepairFeeDto1.getCompCode() %>" >
                </td>
                <td class="input" style="width:7%">
                   <select name="prpLrepairFeeRepairType" styleClass="three" style="width:90%">
                   <%
                      Iterator prpLrepairTypeList3 = repairColl.iterator();
                      while (prpLrepairTypeList3.hasNext()){
                        PrpDcodeDto prpDcodeDto = (PrpDcodeDto)prpLrepairTypeList3.next();
                        //如果是理算退回的，那么只有当等于数据的那条记录才被增加到界面上,如果不是这样的，照常 lixiang
                       if ("1".equals(prpLrepairFeeDto1.getCompensateBackFlag())
                    		   && !(prpDcodeDto.getCodeCode().trim().equals(prpLrepairFeeDto1.getRepairType().trim()))) 
                    	   continue;
                   %>
                        <option value="<%= prpDcodeDto.getCodeCode() %>" <%= ((prpDcodeDto.getCodeCode().trim().equals(prpLrepairFeeDto1.getRepairType().trim())) ? "selected" : "") %>><%= prpDcodeDto.getCodeCName() %></option>
                   <%
                       }
                   %> 
                   </select>           
                </td> 
                <td class="input" style="width:4%">                
                  <input name="prpLrepairFeeManHour" class=common style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>  value="<%= prpLrepairFeeDto1.getManHour() %>" onBlur="return getSumDefLoss(this,1);">
                </td>
                <td class="input" style="width:8%">                
                  <input name="prpLrepairFeeManHourUnitPrice" class="common"  style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getManHourUnitPrice() %>" onBlur="return getSumDefLoss(this,1);">
                </td>                                                   
                <td class="input" style="width:10%">
                  <input name="prpLrepairFeeMaterialFee" type="hidden" <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getMaterialFee() %>" >                
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getSumDefLoss() %>">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLrepairFeeRemark" class="common"  maxLength="60" onblur="checkLength1(this);" description="备注" 
                  		 style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getRemark() %>">
                </td>
                <td class="input" style="width:8%">
                  <input name="prpLrepairFeeVeriManHour" type="hidden" value="<%= prpLrepairFeeDto1.getVeriManHour() %>">
                  <input name="prpLrepairFeeVeriManUnitPrice" class="readonly" only style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getVeriManUnitPrice() %>">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLrepairFeeVeriMaterialFee" type="hidden" value="<%= prpLrepairFeeDto1.getVeriMaterialFee() %>">
                  <input name="prpLrepairFeeVeriSumLoss" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getVeriSumLoss() %>">
                </td>
                <td class="input">
                  <input name="prpLrepairFeeVeriRemark" class="readonly" only style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%> value="<%= prpLrepairFeeDto1.getVeriRemark() %>">
                </td>
                  <input type="hidden" name="prpLrepairFeeSerialNo" value="<%= prpLrepairFeeDto1.getSerialNo() %>">                  
                  <input type="hidden" name="prpLrepairFeeItemKindNo" value="<%= prpLrepairFeeDto1.getItemKindNo() %>">                 
                  <input type="hidden" name="prpLrepairFeeLossItemCode" value="<%= prpLrepairFeeDto1.getLossItemCode() %>">                 
                  <input type="hidden" name="prpLrepairFeeLicenseNo" value="<%= prpLrepairFeeDto1.getLicenseNo() %>">                  
                  <input type="hidden" name="prpLrepairFeeLicenseColorCode" value="<%= prpLrepairFeeDto1.getLicenseColorCode() %>">           
                  <input type="hidden" name="prpLrepairFeeCarKindCode" value="<%= prpLrepairFeeDto1.getCarKindCode() %>">               
                  <input type="hidden" name="prpLrepairFeeSanctioner" value="<%= prpLrepairFeeDto1.getSanctioner() %>">                 
                  <input type="hidden" name="prpLrepairFeeApproverCode" value="<%= prpLrepairFeeDto1.getApproverCode() %>">               
                  <input type="hidden" name="prpLrepairFeeOperatorCode" value="<%= prpLrepairFeeDto1.getOperatorCode() %>">               
                  <input type="hidden" name="prpLrepairFeeManHourFee" value="<%= prpLrepairFeeDto1.getManHourFee() %>">                  
                  <input type="hidden" name="prpLrepairFeeLossRate" value="<%= prpLrepairFeeDto1.getLossRate() %>">                   
                  <input type="hidden" name="prpLrepairFeeCurrency" value="<%= prpLrepairFeeDto1.getCurrency() %>">                   
                  <input type="hidden" name="prpLrepairFeeVeriManHourFee" value="<%= prpLrepairFeeDto1.getVeriManHourFee() %>">             
                  <input type="hidden" name="prpLrepairFeeVeriMaterQuantity" value="<%= prpLrepairFeeDto1.getVeriMaterQuantity() %>">          
                  <input type="hidden" name="prpLrepairFeeVeriMaterUnitPrice" value="<%= prpLrepairFeeDto1.getVeriMaterUnitPrice() %>">         
                  <input type="hidden" name="prpLrepairFeeVeriLossRate" value="<%= prpLrepairFeeDto1.getVeriLossRate() %>">               
                  <input type="hidden" name="prpLrepairFeeFlag" value="<%= prpLrepairFeeDto1.getFlag() %>">
                  <input type="hidden" name="prpLrepairFeeCompensateBackFlag" value="<%= prpLrepairFeeDto1.getCompensateBackFlag() %>">
                  <input type="hidden" name="prpLrepairFeeFirstSumDefLoss" value="<%= prpLrepairFeeDto1.getFirstSumDefLoss() %>">
                <td class="input" style='width:4%'  align="center">
	                <div>
	                  <input type="hidden" name="txtRepairFeeBackFlag">
	                  <input type=button name="buttonRepairFeeDelete"  class="smallbutton"  <%=compensatebackDiasable%> onclick="deleteRowTableRepairFee(this,'RepairFee',1,1)" value="-" style="cursor: hand">
	                </div>
                </td>
              </tr>  
<%          
            }
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