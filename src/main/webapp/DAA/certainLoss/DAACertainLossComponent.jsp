<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page import="java.util.*"%>
<%
  int intColspan = 0;
%>
   <table class="common" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4">  
        <span  id="spanComponent" cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="Component">
        　　<thead>
          <%
            if(flag == null) { // 定损
            	intColspan = 11;
          %>
            <tr>
              <td class="subformtitle" colspan=<%=intColspan%>>零部件更换项目费用清单</td>
            </tr>
            <tr>
              <td class="centertitle" style="width:5%">序号</td>
              <td class="centertitle" style="width:16%">险别名称</td>
              <td class="centertitle" style="width:8%">部件代码</td>
              <td class="centertitle" style="width:16%">部件名称</td>
              <td class="centertitle" style="width:5%">数量</td>
              <td class="centertitle" style="width:10%">上报价格</td>  
              <td class="centertitle" style="width:10%">系统价</td>                   
              <td class="centertitle" style="width:8%">残值</td>
              <td class="centertitle" style="width:12%">定损金额</td>                     
              <td class="centertitle" style="width:6%">定损备注</td>
              <td class="centertitle" style="width:4%" >&nbsp;</td>
            </tr>
          <%
            }else { // 核损退回
            	intColspan = 12;
          %>
            <tr>
              <td class="subformtitle" colspan=<%=intColspan%>>零部件更换项目费用清单</td>
            </tr>
            <tr>
              <td class="centertitle" style="width:5%">序号</td>
              <td class="centertitle" style="width:14%">险别名称</td>
              <td class="centertitle" style="width:8%">部件代码</td>
              <td class="centertitle" style="width:14%">部件名称</td>
              <td class="centertitle" style="width:5%">数量</td>
              <td class="centertitle" style="width:10%">上报价格</td>  
              <td class="centertitle" style="width:10%">系统价</td>                   
              <td class="centertitle" style="width:8%">残值</td>
              <td class="centertitle" style="width:10%">定损金额</td>                     
              <td class="centertitle" style="width:10%">定损备注</td>
              <td class="centertitle" style="width:10%">核损金额</td>
              <td class="centertitle" style="width:4%">&nbsp;</td>
            </tr>
          <%}%>
          </thead>
          <tfoot> 
              <tr>
                <td class="title" colspan="<%=intColspan%>" style="width:96%">(按"-"号键删除信息)
                  <%if(flag != null ){ // 核损退回%>
                    <logic:equal name="prpLverifyLossDto" property="verifyOpinion" value="02">
                      <input type="button" class=bigbutton value="同意核损金额" onclick="getVerifyComponent();" name="buttonAgreeVerifyComponentLoss" style="cursor: hand">   
                    </logic:equal>
                  <%}%>
                </td>
              </tr>
              <%
                  String  displayButton = "";
                  if (editType.equals("SHOW")) { 
            	       displayButton = "display:none;";
                  }
              %>
              <tr style="<%= displayButton%>">
                <td class="title" colspan="<%=intColspan%>" align="center"> 
                   <span style="width:33%;text-align: center;">
                   		<input  type="hidden"  name="selectCarFittings" >                  
                   		<input type="button" class=bigbutton value="新增标准配件" onclick="checkBeforeGetFittingsInfo();" name="buttonFittings" style="cursor: hand">                     
                   </span>
                   <span style="width:33%;text-align: center;">
                   		<input type="hidden" class=bigbutton value="刷新配件信息" onclick="showFittingsInfo();" name="buttonFittings" style="cursor: hand">
                   </span>
                   <span style="width:33%;text-align: center;">
                     	<input type="hidden" class=bigbutton value="新增自定义配件" onclick="insertThreeRowTableComponent('Component','Component_Data',this)" name="buttonComponentInsert" style="cursor: hand">
                   </span>  
                </td>               
              </tr>
              <tr>
                <td colspan="<%=intColspan%>">
                  <table border="0" align="center" cellpadding="4" cellspacing="1"  class="title" width="100%">
                    <tr>
                      <td class='input' width="30%">残值总计:  <input name="prpLcarLossSumRest" class='readonly' readonly="true"  style='width:140px' value="<%= prpLcarLossDto.getSumRest() %>"/> 
                       <input type=hidden name="prpLcarLossSumManageFeeRate" >                        
                      </td>           
                      <td class='input'   width="30%">配件的价格是否含: 
                        <input   type="checkbox" name="prpLcarLossCheckBox1" checked >管理费
                        <input  type="checkbox" name="prpLcarLossCheckBox2" checked >税金
                        <input   type="checkbox" name="prpLcarLossCheckBox3" checked >运费
                        <input name="prpLcarLossSumManageFeeRate" type="hidden" value="<%= prpLcarLossDto.getSumManageFeeRate() %>" onBlur="return getMaterialFee(this,2);">  
                      </td>        
                      <td class='title' width="40%">&nbsp;
                      </td>     
                    </tr>  
                    <tr>
                      <td class='title' style="display:none"  width="30%">
                           部件合计:<input class='readonly' readonly="true" style='width:80px' name='SumManHourFee2'>
                      </td>    
                      <td class='title'  style="display:none"  width="30%">
                           工时合计:<input class='readonly'  readonly="true" style='width:80px' name='SumMaterialFee2'>
                      </td>   
                      <td class='title' colspan=4  colwidth="100%">换件合计:<input class='readonly'  readonly="true" style='width:80px' name='SumDefLoss2'>
                      </td>     
                    </tr>
                  </table>  
                </td>
              </tr>
          </tfoot>
          <tbody>
<% indexCertainLoss=0;%>
<% String compensatebackReadOnly1=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackDiasable1=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackStyle1=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensateComNameEmpty=""; //如果是理算退回的，若部件名称为空不能设为只读%> 
<% String compensateComNameEmptyStyle=""; //如果是理算退回的，若部件名称为空不能设为只读%>

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
          compensateComNameEmpty = "";
          compensateComNameEmptyStyle = "";
          if ("1".equals(prpLcomponentDto1.getCompensateBackFlag())) {
              compensatebackStyle1=";background:#CECECE";
              compensatebackReadOnly1="readOnly";
              compensatebackDiasable1="disabled";
              String compName = prpLcomponentDto1.getCompName();
              if(!"".equals(compName) && compName != null){
            	  compensateComNameEmpty = "readOnly";
            	  compensateComNameEmptyStyle = ";background:#CECECE";
              }
          }
          if(flag==null||flag.length()<1){ 
%>
              <tr>
                <td class="input" style="width:5%" align="center">
                  <%=index1+1 %>         
                  <input type="hidden" name="carLossComponentLossItemCode" value="<%= componentNo-1 %>"/>              
                  <input type="hidden" name="prpLcomponentKindCode" value="<%= prpLcomponentDto1.getKindCode() %>">
                </td>
                <td class="input" style='width:16%'>   
                <%if (prpLcarLossDto1.getLossItemCode().trim().equals("1")){ // 标的车%>
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getKindName() %>"                     
  			            <% if (compensatebackReadOnly1.equals("")){%>
  			              ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectforcar','post');"
  			              onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','selectforcar','post');"
  			              onblur="checkKindCodeForRepair(this);"<%}%> >          
  			        <%}else { // 三者车%>
  			          <input type="text" name="prpLcomponentKindName" class="codecode" style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>  value="<%= prpLcomponentDto1.getKindName() %>"                     
                    <% if (compensatebackReadOnly1.equals("")){%>
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectb','post');"
                      onblur="checkKindCodeForRepair(this);"<%}%> >          
  			       
  			        <%}%>
                </td>   
                <td class="input" style='width:8%'>
                	<input name="prpLcomponentCompCode"  readonly class="common"  style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%> 
                		value="<%= prpLcomponentDto1.getCompCode() %>" />
                </td>             
                <td class="input" style='width:16%'>
                  <input name="prpLcomponentCompName" readonly class="common"  style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>		             
                      value="<%= prpLcomponentDto1.getCompName() %>" />  
                  <input type="hidden" name="prpLcomponentPartCode" value="01">
                  <input type="hidden" name="prpLcomponentPartName" value="前部">
                </td>
                <td class="input" style='width:5%'>                
                  <input name="prpLcomponentQuantity" class=common style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getQuantity() %>"  onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLcomponentManHourFee" class=common style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getManHourFee() %>"  onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input"  style='width:10%'>                
                  <input name="prpLcomponentMaterialFee" class=common style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getMaterialFee() %>"  onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input"  style='width:10%'>               
                  <input name="prpLcomponentSys4SPrice" type="text" readonly="readonly" class=common style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getSys4SPrice() %>" />  <!--onBlur="return getMaterialFee(this,2);">-->
                </td> 
                <td class="input"  style='width:8%'>                
                  <input name="prpLcomponentRestFee" class=common style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%> value="<%= prpLcomponentDto1.getRestFee() %>"  onBlur="getSumDefLoss(this,2);calculateSumRestFee(this);">
                </td> 
                <td class="input"  style='width:12%'>
                  <input name="prpLcomponentSumDefLoss" class="readonly" readonly style='width:100%'   value="<%= prpLcomponentDto1.getSumDefLoss() %>" />
                </td> 
                <td class="input">
                  <input name="prpLcomponentRemark" class="common" maxLength="60" onblur="checkLength1(this);" description="备注"
                  	style='width:100%'<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%> 
                    value="<%= prpLcomponentDto1.getRemark() %>" />
                </td>
                  <input type="hidden" name="prpLcomponentQuotedPrice" value="<%= prpLcomponentDto1.getQuotedPrice() %>" />  
                  <input type="hidden" name="prpLcomponentSerialNo" value="<%= prpLcomponentDto1.getSerialNo() %>" />                  
                  <input type="hidden" name="prpLcomponentItemKindNo" value="<%= prpLcomponentDto1.getItemKindNo() %>" />               
                  <input type="hidden" name="prpLcomponentLossItemCode" value="<%= prpLcomponentDto1.getLossItemCode() %>"/>            
                  <input type="hidden" name="prpLcomponentLicenseNo" value="<%= prpLcomponentDto1.getLicenseNo() %>"/>               
                  <input type="hidden" name="prpLcomponentLicenseColorCode"value="<%= prpLcomponentDto1.getLicenseColorCode() %>" />          
                  <input type="hidden" name="prpLcomponentCarKindCode" value="<%= prpLcomponentDto1.getCarKindCode() %>" />              
                  <input type="hidden" name="prpLcomponentMakeYear" value="<%= prpLcomponentDto1.getMakeYear() %>"/>                
                  <input type="hidden" name="prpLcomponentGearboxType" value="<%= prpLcomponentDto1.getGearboxType() %>"/>             
                  <input type="hidden" name="prpLcomponentQuoteCompanyGrade" value="<%= prpLcomponentDto1.getQuoteCompanyGrade() %>"/>   
                  <input type="hidden" name="prpLcomponentManageFeeRate" value="<%= prpLcomponentDto1.getManageFeeRate() %>"/>           
                  <input type="hidden" name="prpLcomponentRepairFactoryCode" value="<%= prpLcomponentDto1.getRepairFactoryCode() %>"/>         
                  <input type="hidden" name="prpLcomponentRepairFactoryName" value="<%= prpLcomponentDto1.getRepairFactoryName() %>" />        
                  <input type="hidden" name="prpLcomponentHandlerCode" value="<%= prpLcomponentDto1.getHandlerCode() %>"/>               
                  <input type="hidden" name="prpLcomponentRepairStartDate" value="<%= prpLcomponentDto1.getRepairStartDate() %>"/>           
                  <input type="hidden" name="prpLcomponentRepairEndDate" value="<%= prpLcomponentDto1.getRepairEndDate() %>"/>                   
                  <input type="hidden" name="prpLcomponentSanctioner" value="<%= prpLcomponentDto1.getSanctioner() %>" />               
                  <input type="hidden" name="prpLcomponentApproverCode" value="<%= prpLcomponentDto1.getApproverCode() %>" />             
                  <input type="hidden" name="prpLcomponentOperatorCode" value="<%= prpLcomponentDto1.getOperatorCode() %>"/>                 
                  <input type="hidden" name="prpLcomponentQueryPrice" value="<%= prpLcomponentDto1.getQueryPrice() %>"/>                
                  
                  <input type="hidden" name="prpLcomponentLossRate" value="<%= prpLcomponentDto1.getLossRate() %>"/>                
                  <input type="hidden" name="prpLcomponentCurrency" value="<%= prpLcomponentDto1.getCurrency() %>" />                 
                  <input type="hidden" name="prpLcomponentVeriRemark" value="<%= prpLcomponentDto1.getRemark() %>"/>                  
                  <input type="hidden" name="prpLcomponentVeriQuantity" value="<%= prpLcomponentDto1.getVeriQuantity() %>"/>            
                  <input type="hidden" name="prpLcomponentVeriManHourFee" value="<%= prpLcomponentDto1.getVeriManHourFee() %>"/>            
                  <input type="hidden" name="prpLcomponentVeriMaterFee" value="<%= prpLcomponentDto1.getVeriMaterFee() %>"/>              
                  <input type="hidden" name="prpLcomponentVeriLossRate" value="<%= prpLcomponentDto1.getVeriLossRate() %>"/>              
                  <input type="hidden" name="prpLcomponentSumVeriLoss" value="<%= prpLcomponentDto1.getSumVeriLoss() %>" />             
                  <input type="hidden" name="prpLcomponentVeriRestFee" value="<%= prpLcomponentDto1.getVeriRestFee() %>" />              
                  <input type="hidden" name="prpLcomponentFlag" value="<%= prpLcomponentDto1.getFlag() %>"/>
                  <input type="hidden" name="prpLcomponentCompensateBackFlag" value="<%= prpLcomponentDto1.getCompensateBackFlag() %>" />              
              
                  <input type="hidden" name="prpLcomponentOriginalId" value="<%= prpLcomponentDto1.getOriginalId() %>" />
                  <input type="hidden" name="prpLcomponentIndId" value="<%= prpLcomponentDto1.getIndId() %>" />
                  <input type="hidden" name="prpLcomponentSysMatchPrice" value="<%= prpLcomponentDto1.getSysMatchPrice() %>" />
                  <input type="hidden" name="prpLcomponentNative4SPrice" value="<%= prpLcomponentDto1.getNative4SPrice() %>" />
                  <input type="hidden" name="prpLcomponentNativeMarketPrice" value="<%= prpLcomponentDto1.getNativeMarketPrice() %>" />
                  <input type="hidden" name="prpLcomponentNativeMatchPrice" value="<%= prpLcomponentDto1.getNativeMatchPrice() %>" />
                  <input type="hidden" name="prpLcomponentVerpCompPrice" value="<%= prpLcomponentDto1.getVerpCompPrice() %>" />                  
                  <input type="hidden" name="prpLcomponentSysMarketPrice" value="<%= prpLcomponentDto1.getSysMarketPrice() %>" /> 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonComponentDelete"  class=smallbutton  <%=compensatebackDiasable1%> onclick="deleteRowTableComponent(this,'Component',1,1)" value="-" style="cursor: hand">
                </div>
                </td>
              </tr> 
<%
              } else { // 核损退回
%>     
              <tr>  
                <td class="input" style="width:5%" align="center">
                  <%=index1+1%>         
                  <input type="hidden" name="carLossComponentLossItemCode" value="<%= componentNo-1 %>"/>              
                  <input type="hidden" name="prpLcomponentKindCode" type="hidden" value="<%= prpLcomponentDto1.getKindCode() %>">
                </td>
                <td class="input" style='width:14%'>   
                  <input type="text" name="prpLcomponentKindName" class="codecode" style='width:100%<%=compensatebackStyle1%>' 
                    <%=compensatebackReadOnly1%> value="<%= prpLcomponentDto1.getKindName() %>"
  			            <% if (compensatebackReadOnly1.equals("")){%>
  			            ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
  			            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','none','post');"
  			            onblur="checkKindCodeForRepair(this);" <%}%>>
  			          <input type="hidden" name="prpLcomponentPartCode" value="01">
                  <input type="hidden" name="prpLcomponentPartName" value="前部">           
                </td>    
                <td class="input" style='width:8%'>
                	<input name="prpLcomponentCompCode" class="readonly" readonly style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>
                     value="<%= prpLcomponentDto1.getCompCode() %>"/>  
                </td>            
                <td class="input" style='width:14%'>
                  <input name="prpLcomponentCompName" class="common"  style='width:100%<%=compensateComNameEmptyStyle%>' <%=compensateComNameEmpty%>
                     value="<%= prpLcomponentDto1.getCompName() %>"/>  
                </td>
                <td class="input"  style='width:5%'>
                  <input name="prpLcomponentQuantity" class=common style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%> value="<%= prpLcomponentDto1.getQuantity() %>"  onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLcomponentManHourFee" class=common style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getManHourFee() %>"  onBlur="return getSumDefLoss(this,2);">
                </td> 
                <td class="input" style='width:10%'>
                  <input name="prpLcomponentMaterialFee" class=common style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getMaterialFee() %>"  onBlur="return getSumDefLoss(this,2);">
                </td>
                <td class="input"  style='width:10%'>
                  <input name="prpLcomponentSys4SPrice" type="text" class=readonly  readonly="readonly" style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getSys4SPrice() %>"  > 
                </td>
                <td class="input" style='width:8%'>
                  <input name="prpLcomponentRestFee" class=common style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%> value="<%= prpLcomponentDto1.getRestFee() %>" onBlur="calculateSumRestFee(this);getSumDefLoss(this,2);">
                </td> 
                <td class="input" style='width:10%'>
                  <input name="prpLcomponentSumDefLoss" class="readonly" style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%> readonly  value="<%= prpLcomponentDto1.getSumDefLoss() %>" />
                </td> 
                <td class="input" style='width:10%'>
                  <input name="prpLcomponentRemark" class="common" maxLength="60" onblur="checkLength1(this);" description="备注"
                   style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>   value="<%= prpLcomponentDto1.getRemark() %>" />
                </td>
                <td class="input" style='width:10%'>
                  <input name="prpLcomponentSumVeriLoss" class="readonly" readonly style='width:100%<%=compensatebackStyle1%>' <%=compensatebackReadOnly1%>
                    value="<%=prpLcomponentDto1.getSumVeriLoss()%>" /><!-- 核损金额 -->
                  <input name="prpLcomponentVeriQuantity" type="hidden" value="<%= prpLcomponentDto1.getVeriQuantity()%>"/>
                  <input name="prpLcomponentVeriManHourFee" type="hidden" value="<%=prpLcomponentDto1.getVeriManHourFee()%>"/>
                  <input name="prpLcomponentVeriMaterFee" type="hidden" value="<%=prpLcomponentDto1.getVerpCompPrice()%>"/>
                  <input name="prpLcomponentVeriRestFee" type="hidden" value="<%=prpLcomponentDto1.getVeriRestFee()%>"/>
                  <input name="prpLcomponentVeriRemark" type="hidden" value="<%= prpLcomponentDto1.getVeriRemark() %>" />
                </td>
                  <input type="hidden" name="prpLcomponentQuotedPrice" value="<%= prpLcomponentDto1.getQuotedPrice() %>" />  
                  <input type="hidden" name="prpLcomponentSerialNo"value="<%= prpLcomponentDto1.getSerialNo() %>" />                  
                  <input type="hidden" name="prpLcomponentItemKindNo" value="<%= prpLcomponentDto1.getItemKindNo() %>" />               
                  <input type="hidden" name="prpLcomponentLossItemCode" value="<%= prpLcomponentDto1.getLossItemCode() %>"/>            
                  <input type="hidden" name="prpLcomponentLicenseNo" value="<%= prpLcomponentDto1.getLicenseNo() %>"/>               
                  <input type="hidden" name="prpLcomponentLicenseColorCode"value="<%= prpLcomponentDto1.getLicenseColorCode() %>" />          
                  <input type="hidden" name="prpLcomponentCarKindCode" value="<%= prpLcomponentDto1.getCarKindCode() %>" />              
                  <input type="hidden" name="prpLcomponentMakeYear" value="<%= prpLcomponentDto1.getMakeYear() %>"/>                
                  <input type="hidden" name="prpLcomponentGearboxType" value="<%= prpLcomponentDto1.getGearboxType() %>"/>             
                  <input type="hidden" name="prpLcomponentQuoteCompanyGrade" value="<%= prpLcomponentDto1.getQuoteCompanyGrade() %>"/>   
                  <input type="hidden" name="prpLcomponentManageFeeRate" value="<%= prpLcomponentDto1.getManageFeeRate() %>"/>           
                  <input type="hidden" name="prpLcomponentRepairFactoryCode" value="<%= prpLcomponentDto1.getRepairFactoryCode() %>"/>         
                  <input type="hidden" name="prpLcomponentRepairFactoryName" value="<%= prpLcomponentDto1.getRepairFactoryName() %>" />        
                  <input type="hidden" name="prpLcomponentHandlerCode" value="<%= prpLcomponentDto1.getHandlerCode() %>"/>               
                  <input type="hidden" name="prpLcomponentRepairStartDate" value="<%= prpLcomponentDto1.getRepairStartDate() %>"/>           
                  <input type="hidden" name="prpLcomponentRepairEndDate" value="<%= prpLcomponentDto1.getRepairEndDate() %>"/>                   
                  <input type="hidden" name="prpLcomponentSanctioner" value="<%= prpLcomponentDto1.getSanctioner() %>" />               
                  <input type="hidden" name="prpLcomponentApproverCode" value="<%= prpLcomponentDto1.getApproverCode() %>" />             
                  <input type="hidden" name="prpLcomponentOperatorCode" value="<%= prpLcomponentDto1.getOperatorCode() %>"/>                 
                  <input type="hidden" name="prpLcomponentQueryPrice" value="<%= prpLcomponentDto1.getQueryPrice() %>"/>                
                  <input type="hidden" name="prpLcomponentLossRate" value="<%= prpLcomponentDto1.getLossRate() %>"/>                
                  <input type="hidden" name="prpLcomponentCurrency" value="<%= prpLcomponentDto1.getCurrency() %>" />                 
                  <input type="hidden" name="prpLcomponentVeriLossRate" value="<%= prpLcomponentDto1.getVeriLossRate() %>"/>              
                  <input type="hidden" name="prpLcomponentFlag" value="<%= prpLcomponentDto1.getFlag() %>"/>
                  <input type="hidden" name="prpLcomponentCompensateBackFlag" value="<%= prpLcomponentDto1.getCompensateBackFlag() %>" />   
                             
                  <input type="hidden" name="prpLcomponentOriginalId" value="<%= prpLcomponentDto1.getOriginalId() %>" />
                  <input type="hidden" name="prpLcomponentIndId" value="<%= prpLcomponentDto1.getIndId() %>" />
                  <input type="hidden" name="prpLcomponentSysMatchPrice" value="<%= prpLcomponentDto1.getSysMatchPrice() %>" />
                  <input type="hidden" name="prpLcomponentNative4SPrice" value="<%= prpLcomponentDto1.getNative4SPrice() %>" />
                  <input type="hidden" name="prpLcomponentNativeMarketPrice" value="<%= prpLcomponentDto1.getNativeMarketPrice() %>" />
                  <input type="hidden" name="prpLcomponentNativeMatchPrice" value="<%= prpLcomponentDto1.getNativeMatchPrice() %>" />
                  <input type="hidden" name="prpLcomponentVerpCompPrice" value="<%= prpLcomponentDto1.getVerpCompPrice() %>" />                  
                  <input type="hidden" name="prpLcomponentSysMarketPrice" value="<%= prpLcomponentDto1.getSysMarketPrice() %>" /> 
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type="hidden" name="txtComponentBackFlag">
                  <input type=button name="buttonComponentDelete"  class=smallbutton  <%=compensatebackDiasable1%> onclick="deleteRowTableComponent(this,'Component',1,1)" value="-" style="cursor: hand">
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
  
