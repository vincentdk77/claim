<%--
****************************************************************************
* DESC       ：添加人员赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
<script language='javascript'>
    //换件合计的值不方便存到表中，所以用脚本方法让换件合计的值显示出来
    //add by kangzhen
    function CalculateSumDefLoss2(field)
    {
    	var i = 0;
    	var SumDefLoss2=0;
    	for(i=1;i<fm.all("prpLcomponentSumDefLoss").length;i++)
      {
        SumDefLoss2 = SumDefLoss2 + parseFloat(fm.all("prpLcomponentSumDefLoss")[i].value);
      }
      fm.SumDefLoss2.value = parseFloat(SumDefLoss2);
    }




	  
</script>
<%
    //String nodeType=request.getParameter("nodeType");
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
<%
  if (nodeType.equals("backc")) {
%>
              <td class="centertitle" colspan="13">零部件更换项目费用清单</td>          
<%
  } else {
%>     
              <td class="centertitle" colspan="11">零部件更换项目费用清单</td> 
<%
  }
%>             
            </tr>
            <tr>
              <!-- <td class="centertitle" style="width:10%">险别代码</td> -->
              <td class="centertitle" style="width:10%">险别名称</td>
              <td class="centertitle" style="width:10%">部件部位</td>
              <!-- <td class="centertitle" style="width:10%">部件代码</td> -->
              <td class="centertitle" style="width:10%">部件名称</td>
              <td class="centertitle" style="width:8%">数量</td>
              <td class="centertitle" style="width:8%;display:none">工时费</td>  
              <td class="centertitle" style="width:8%">上报价格</td>   
              <td class="centertitle" style="width:10%">系统价</td>                   
              <td class="centertitle" style="width:8%" >残值</td>                     
              <td class="centertitle" style="width:8%">定核损金额</td>                     
              <td class="centertitle" style="width:5%">备注</td>
<%
  if (nodeType.equals("backc")) {
%>
              <td class="centertitle"style="width:5%">复勘意见</td> 
<%
  }
%>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td colspan="11">
                  <table class=common cellpadding="5" cellspacing="1">
                      <tr>
                      <td class='input' width="30%">残值总计:  <input name="prpLcarLossSumRest" class='readonly' readonly="true" style='width:140px' value="<%= prpLcarLossDto.getSumRest() %>"> 
                       <input type=hidden name="prpLcarLossSumManageFeeRate" >                                              
                      </td>    
<!--
                      <td class='input' width="30%">管理费率(%):  <input name="prpLcarLossSumManageFeeRate" class='readonly' readonly="true" style='width:140px' value="<%= prpLcarLossDto.getSumManageFeeRate() %>">  
                      </td>   
-->                      
                      <td class='title' width="40%">&nbsp;
                      </td>   
                    </tr>                             
                    
                    <tr>
                      <td class='title' style="width:8%;display:none"  width="30%">部件合计:<input class='readonly' readonly="true" style='width:80px' name='SumManHourFee2'>
                      </td>    
                      <td class='title' style="width:8%;display:none"  width="30%">工时合计:<input class='readonly'  readonly="true" style='width:80px' name='SumMaterialFee2'>
                      </td>    
                      <td class='title' width="40%">换件合计:<input class='readonly'  readonly="true" style='width:80px' name='SumDefLoss2'>
                      </td>     
                    </tr>
                  </table>  
                </td> 
              </tr>
           </tfoot>   
          </tfoot>
          <tbody>
<% indexVerifyLoss=0;%>
<%
      componentNo = 0;
      if(prpLcomponentDto.getComponentList() != null){
        for(int index1 = 0;index1<prpLcomponentDto.getComponentList().size();index1++){
          PrpLcomponentDto prpLcomponentDto1 = (PrpLcomponentDto)prpLcomponentDto.getComponentList().get(index1);
          if(prpLcomponentDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
          componentNo = Integer.parseInt(prpLcomponentDto1.getLossItemCode());
%>
              <tr>  
<!--                 <td class="input" style="display:none">         
                  <input type="hidden" name="carLossComponentLossItemCode" style="width:20px" value="<%= componentNo-1 %>">              
                  <input type="text" name="prpLcomponentKindCode" class="readonly" readonly" style='width:40px' value="<%= prpLcomponentDto1.getKindCode() %>"                     
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onchange="code_CodeChange(this, 'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">          
                </td>
 -->                <td class="input">  
 <input type="hidden" name="carLossComponentLossItemCode" style="width:20px" value="<%= componentNo-1 %>">               
                  <input type="text" name="prpLcomponentKindName" class="readonly" readonly style='width:70px' value="<%= prpLcomponentDto1.getKindName() %>">        
   <input type="hidden" name="prpLcomponentKindCode" class="readonly"  value="<%= prpLcomponentDto1.getKindCode() %>">                    			             
                </td>                
                
                <td class="input">                
                  <input name="prpLcomponentPartName" class="readonly" readonly style='width:70px' value="<%= prpLcomponentDto1.getPartName() %>" >
                  <input name="prpLcomponentPartCode" type="hidden"  value="<%= prpLcomponentDto1.getPartCode() %>" >
                </td>
                <td class="input">
                  <input type="text" name="prpLcomponentCompName" class="readonly" readonly style='width:70px'   value="<%= prpLcomponentDto1.getCompName() %>">                 
  			            
  	      <input type="hidden" name="prpLcomponentCompCode" type="hidden"    value="<%= prpLcomponentDto1.getCompCode() %>"  >                  		             
                </td>

                <td class="input">                
                  <input name="prpLcomponentQuantity" class="readonly" readonly style='width:60px' value="<%= prpLcomponentDto1.getQuantity() %>">
                </td>
                <td class="input" style="display:none;">                
                  <input name="prpLcomponentManHourFee" value="0" class="readonly" readonly style='width:60px' value="<%= prpLcomponentDto1.getManHourFee() %>">
                </td>
                <td class="input">                
                  <input name="prpLcomponentMaterialFee" class="readonly" readonly style='width:60px' value="<%= prpLcomponentDto1.getMaterialFee() %>">
                </td>
                <td class="input" style="display:">                
                  <input  name="prpLcomponentSys4SPrice" class="readonly" readonly style='width:60px' value="<%= prpLcomponentDto1.getSys4SPrice() %>">
                  <input  name="prpLcomponentQuotedPrice" type="hidden" class="readonly" readonly style='width:60px' value="<%= prpLcomponentDto1.getQuotedPrice() %>">
                </td>
                <td class="input">                
                  <input  name="prpLcomponentRestFee" class="readonly"  readonly  style='width:50px'  value="<%= prpLcomponentDto1.getRestFee() %>" >                              
                </td>
                <td class="input">                
                  <input name="prpLcomponentSumDefLoss" class="readonly" readonly style='width:60px' value="<%= prpLcomponentDto1.getSumDefLoss() %>" >
                </td>
                <td class="input">                 
                  <input name="prpLcomponentRemark" class="readonly" readonly style='width:70px' value="<%= prpLcomponentDto1.getRemark() %>" >
                </td>
<%
  if (nodeType.equals("backc")) {
%>
                <td class="input">                
                  <input name="prpLcomponentBackCheckRemark" class="input" style='width:100px' value="<%= prpLcomponentDto1.getBackCheckRemark() %>">
                </td>
<%
  } else {
%>       
                  <input type="hidden" name="prpLcomponentBackCheckRemark" value="<%= prpLcomponentDto1.getBackCheckRemark() %>">
<%
  }
%>                
                  <input type="hidden" name="prpLcomponentSerialNo"value="<%= prpLcomponentDto1.getSerialNo() %>" >                  
                  <input type="hidden" name="prpLcomponentItemKindNo" value="<%= prpLcomponentDto1.getItemKindNo() %>" >               
                  <input type="hidden" name="prpLcomponentLossItemCode" value="<%= prpLcomponentDto1.getLossItemCode() %>"  >            
                  <input type="hidden" name="prpLcomponentLicenseNo" value="<%= prpLcomponentDto1.getLicenseNo() %>"  >               
                  <input type="hidden" name="prpLcomponentLicenseColorCode"value="<%= prpLcomponentDto1.getLicenseColorCode() %>" >          
                  <input type="hidden" name="prpLcomponentCarKindCode" value="<%= prpLcomponentDto1.getCarKindCode() %>" >              
                  <input type="hidden" name="prpLcomponentMakeYear" value="<%= prpLcomponentDto1.getMakeYear() %>"  >                
                  <input type="hidden" name="prpLcomponentGearboxType" value="<%= prpLcomponentDto1.getGearboxType() %>"  >             
                  <input type="hidden" name="prpLcomponentQuoteCompanyGrade" value="<%= prpLcomponentDto1.getQuoteCompanyGrade() %>"      >   
                  <input type="hidden" name="prpLcomponentManageFeeRate" value="<%= prpLcomponentDto1.getManageFeeRate() %>"  >           
                  <input type="hidden" name="prpLcomponentRepairFactoryCode" value="<%= prpLcomponentDto1.getRepairFactoryCode() %>">         
                  <input type="hidden" name="prpLcomponentRepairFactoryName" value="<%= prpLcomponentDto1.getRepairFactoryName() %>" >        
                  <input type="hidden" name="prpLcomponentHandlerCode" value="<%= prpLcomponentDto1.getHandlerCode() %>">               
                  <input type="hidden" name="prpLcomponentRepairStartDate" value="<%= prpLcomponentDto1.getRepairStartDate() %>">           
                  <input type="hidden" name="prpLcomponentRepairEndDate" value="<%= prpLcomponentDto1.getRepairEndDate() %>">                   
                  <input type="hidden" name="prpLcomponentSanctioner" value="<%= prpLcomponentDto1.getSanctioner() %>" >               
                  <input type="hidden" name="prpLcomponentApproverCode" value="<%= prpLcomponentDto1.getApproverCode() %>" >             
                  <input type="hidden" name="prpLcomponentOperatorCode" value="<%= prpLcomponentDto1.getOperatorCode() %>">                 
                  <input type="hidden" name="prpLcomponentQueryPrice" value="<%= prpLcomponentDto1.getQueryPrice() %>">                
                  <input type="hidden" name="prpLcomponentRestFee" value="<%= prpLcomponentDto1.getRestFee() %>" >              
                  <input type="hidden" name="prpLcomponentLossRate" value="<%= prpLcomponentDto1.getLossRate() %>"  >                
                  <input type="hidden" name="prpLcomponentCurrency" value="<%= prpLcomponentDto1.getCurrency() %>" >                 
                  <input type="hidden" name="prpLcomponentVeriLossRate" value="<%= prpLcomponentDto1.getVeriLossRate() %>">              
                  <input type="hidden" name="prpLcomponentFlag" value="<%= prpLcomponentDto1.getFlag() %>"    >
                 <input name="prpLcomponentPartCode" type="hidden"  value="<%= prpLcomponentDto1.getPartCode() %>" >
                 <input name="prpLcomponentPartName" type="hidden"  value="<%= prpLcomponentDto1.getPartName() %>" >
                  <input type="hidden" name="prpLcomponentCompensateBackFlag" value="<%= prpLcomponentDto1.getCompensateBackFlag() %>">
 
                  </tr>  
              
              <tr>  
                <td class="input" colspan="3">&nbsp;</td>
                <td class="input">                
                  <input name="prpLcomponentVeriQuantity" class="input" style='width:60px' value="<%= prpLcomponentDto1.getVeriQuantity() %>"   onBlur="getSumDefLossVerify(this,2);CalculateSumDefLoss2();">
                </td>
                <td class="input" style="display:none">                
                  <input name="prpLcomponentVeriManHourFee" class="input"  style='width:60px' value="<%= prpLcomponentDto1.getVeriManHourFee() %>"   onBlur="getSumDefLossVerify(this,2);CalculateSumDefLoss2();">
                </td>
                <td class="input">                
                  <input name="prpLcomponentVeriMaterFee" class="input"  style='width:60px' value="<%= prpLcomponentDto1.getVeriMaterFee() %>"   onBlur="getSumDefLossVerify(this,2);CalculateSumDefLoss2();">
                </td>
                <td class="input" style="display:">                
                  <input  name="prpLcomponentQuotedPriceShow" class="input"  style='width:60px' value="<%= prpLcomponentDto1.getQuotedPrice() %>">
                </td>
                <td class="input" >                
                  <input  name="prpLcomponentVeriRestFee" class="input" style='width:50px' value="<%= prpLcomponentDto1.getVeriRestFee() %>"  onBlur="getSumDefLossVerify(this,2);CalculateSumDefLoss2();">
                </td>                
                <td class="input">                
                  <input name="prpLcomponentSumVeriLoss" class="readonly" readonly  style='width:60px' value="<%= prpLcomponentDto1.getSumVeriLoss() %>" >
                </td>
                <td class="input">                
                  <input name="prpLcomponentVeriRemark" class="input"  style='width:70px' value="<%= prpLcomponentDto1.getVeriRemark() %>" >
                </td> 
<%
  if (nodeType.equals("backc")) {
%>
                <td class="input">                
                  &nbsp;
                </td>
<%
  }
%>     
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
    <tr>
  </table> 
  
