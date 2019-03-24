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
<script type="text/javascript">
    function calSumDefLoss1(){
        var repairFeeVeriSumLoss ;
        var feeSumLoss1 = 0;
        for(var i = 0;i < fm.all("prpLrepairFeeVeriSumLoss").length;i++){
            prpLrepairFeeVeriSumLoss = parseFloat(fm.all("prpLrepairFeeVeriSumLoss")[i].value);
            if(isNaN(prpLrepairFeeVeriSumLoss))prpLrepairFeeVeriSumLoss = 0;
            feeSumLoss1 = feeSumLoss1 + prpLrepairFeeVeriSumLoss;
        }
        fm.SumVerifyLoss1.value = feeSumLoss1;
    }


</script>
<%
    //String nodeType=request.getParameter("nodeType");
%>  
   <table class="common" align="center" cellpadding="5" cellspacing="1">
    <!--表示显示多行的-->
    <tr>
      <td class="common" colspan="4">  
        <span  id="spanRepairFee"cellspacing="1" cellpadding="0">
        <%-- 多行输入展现域 --%>
        <table class="common" cellpadding="5" cellspacing="1" id="RepairFee">
          <thead>
            <tr>
              <td class="centertitle" colspan=11>修理项目费用清单</td>  
            </tr> 
            <tr>
              <td class="centertitle" style="width:5%">序号</td>
              <td class="centertitle" style="width:10%">险别名称</td>
              <td class="centertitle" style="width:6%" style="display:none">修理部位</td>
              <td class="centertitle" style="width:13%">零件(项目)名称</td>
              <td class="centertitle" style="width:6%">修理方式</td>
              <td class="centertitle" style="width:5%">工时</td>                  
              <td class="centertitle" style="width:8%">定工时费</td>
              <td class="centertitle" style="width:10%">定损金额</td>   
              <td class="centertitle" style="width:12%">定损备注</td>
              <td class="centertitle" style="width:8%">核工时费</td>
              <td class="centertitle" style="width:10%">核损金额</td>
              <td class="centertitle">核损备注</td>
            </tr>
          </thead>
          <tfoot> 
              <tr>
                <td colspan="11">
                  <table class=common cellpadding="5" cellspacing="1">
                    <tr>
                      <td class='title' style="display:none"  width="30%">工时费合计:<input class='readonly' readonly="true" style='width:80px' name='SumManHourFee1'>
                      </td>    
                      <td class='title'  style="display:none"  width="30%">材料费合计:<input class='readonly'  readonly="true" style='width:80px' name='SumMaterialFee1'>
                      </td>   
                      <td class='title'  width="40%">
                      		修理合计:<input class='readonly'  readonly="true" style='width:80px' name='SumDefLoss1'>&nbsp;&nbsp;&nbsp;&nbsp;
                      		核定修理合计:<input class='readonly'  readonly="true" style='width:80px' name='SumVerifyLoss1'>
                      </td>     
                    </tr>
                  </table>  
                </td>
              </tr>
           </tfoot> 
          </tfoot>
          <tbody> 
<% indexVerifyLoss=0;%>
<% String compensatebackReadOnly=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackDiasable=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackStyle=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<%
      repairFeeNo = 0;
      if(prpLrepairFeeDto.getRepairFeeList() != null){
        for(int index1 = 0;index1<prpLrepairFeeDto.getRepairFeeList().size();index1++){
          PrpLrepairFeeDto prpLrepairFeeDto1 = (PrpLrepairFeeDto)prpLrepairFeeDto.getRepairFeeList().get(index1);
          if(prpLrepairFeeDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
            repairFeeNo = Integer.parseInt(prpLrepairFeeDto1.getLossItemCode());
            //增加理算退回的判断
            compensatebackReadOnly = "";
            compensatebackDiasable = "";
            compensatebackStyle = "";
            if ("1".equals(prpLrepairFeeDto1.getCompensateBackFlag())) {
                compensatebackStyle=";background:#CECECE";
                compensatebackReadOnly="readOnly";
                compensatebackDiasable="disabled";
            }
%>
              <tr>
                <td class="input" align="center" style="width:5%"><%= index1+1%></td>
                <td class="input" align="left" style="width:10%">
                  <input type="hidden" name="carLossRepairFeeLossItemCode" style="width:20px" value="<%= repairFeeNo-1 %>">                
                  <input type="hidden" name="prpLrepairFeeKindCode" class="readonly" readonly value="<%= prpLrepairFeeDto1.getKindCode() %>"  >   
                  <input type="text" name="prpLrepairFeeKindName" class="readonly" readonly style='width:100%<%=compensatebackStyle%>'
                    value="<%= prpLrepairFeeDto1.getKindName() %>"  >     
                </td>
                <td class="input" align="left" style="width:6%" style="display:none">   
                  <input type="text" name="prpLrepairFeePartName" class="readonly" readonly style='width:100%<%=compensatebackStyle%>'
                    value="<%= prpLrepairFeeDto1.getPartName() %>"   >     
                  <input type="hidden" name="prpLrepairFeePartCode" value="<%= prpLrepairFeeDto1.getPartCode() %>">
                </td>
                <td class="input" align="left" style="width:13%">
                  <input type="hidden" name="prpLrepairFeeCompCode" value="<%= prpLrepairFeeDto1.getCompCode() %>"   >   
                  <input type="text" name="prpLrepairFeeCompName" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getCompName() %>">      
                </td>
                <td class="input" align="left" style="width:6%">
                  <input type="hidden" name="prpLrepairFeeRepairType" value="<%= prpLrepairFeeDto1.getRepairType() %>"     >     
                  <input type="text" name="prpLrepairFeeRepairTypeName" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getRepairTypeName() %>"     >     
                </td>
           		  <td class="input" style="width:5%">
                  <input name="prpLrepairFeeManHour" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getManHour() %>">
                </td>
                <td class="input" align="right" style="width:8%">
                  <input name="prpLrepairFeeManHourUnitPrice" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getManHourUnitPrice() %>">
                  <input name="prpLrepairFeeMaterialFee" type="hidden" value="<%= prpLrepairFeeDto1.getMaterialFee() %>">
                </td> 
                <td class="input" align="right" style="width:10%">
                  <input name="prpLrepairFeeSumDefLoss" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getSumDefLoss() %>">
                </td>
                <td class="input" style="width:12%"><!-- 定损备注 -->
                  <input name="prpLrepairFeeRemark" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getVeriRemark() %>">
                </td>
                <td class="input" align="right" style="width:8%"><!-- 核定工时费 -->
                  <input name="prpLrepairFeeVeriManHour" type="hidden" value="<%= prpLrepairFeeDto1.getVeriManHour() %>" onBlur="return getSumDefLossVerify(this,1);">         
                  <input name="prpLrepairFeeVeriManUnitPrice" class="input"  style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getVeriManUnitPrice() %>" onBlur="getSumDefLossVerify(this,1);calSumDefLoss1();">
                </td>
                <td class="input" align="right" style="width:10%"><!-- 核损金额 -->
                  <input name="prpLrepairFeeVeriMaterialFee" type="hidden" value="<%= prpLrepairFeeDto1.getVeriMaterialFee() %>" onBlur="return getSumDefLossVerify(this,1);">                
                  <input name="prpLrepairFeeVeriSumLoss" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getVeriSumLoss() %>" >
                </td>
                <td class="input" align="left"><!-- 核损备注 -->
                  <input name="prpLrepairFeeVeriRemark"  class="input" maxLength="60" onblur="checkLength1(this);" description="核损备注" style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getVeriRemark() %>">
                </td>
                  <input type="hidden" name="prpLrepairFeeBackCheckRemark" value="<%= prpLrepairFeeDto1.getBackCheckRemark() %>">
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