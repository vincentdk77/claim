<%--
****************************************************************************
* DESC       �������Ա��������Ϣҳ��
* AUTHOR     ��lixiang
* CREATEDATE �� 2004-06-01
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
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
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="common" colspan="4">  
        <span  id="spanRepairFee"cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" cellpadding="5" cellspacing="1" id="RepairFee">
          <thead>
            <tr>
              <td class="centertitle" colspan=11>������Ŀ�����嵥</td>  
            </tr> 
            <tr>
              <td class="centertitle" style="width:5%">���</td>
              <td class="centertitle" style="width:10%">�ձ�����</td>
              <td class="centertitle" style="width:6%" style="display:none">����λ</td>
              <td class="centertitle" style="width:13%">���(��Ŀ)����</td>
              <td class="centertitle" style="width:6%">����ʽ</td>
              <td class="centertitle" style="width:5%">��ʱ</td>                  
              <td class="centertitle" style="width:8%">����ʱ��</td>
              <td class="centertitle" style="width:10%">������</td>   
              <td class="centertitle" style="width:12%">����ע</td>
              <td class="centertitle" style="width:8%">�˹�ʱ��</td>
              <td class="centertitle" style="width:10%">������</td>
              <td class="centertitle">����ע</td>
            </tr>
          </thead>
          <tfoot> 
              <tr>
                <td colspan="11">
                  <table class=common cellpadding="5" cellspacing="1">
                    <tr>
                      <td class='title' style="display:none"  width="30%">��ʱ�Ѻϼ�:<input class='readonly' readonly="true" style='width:80px' name='SumManHourFee1'>
                      </td>    
                      <td class='title'  style="display:none"  width="30%">���ϷѺϼ�:<input class='readonly'  readonly="true" style='width:80px' name='SumMaterialFee1'>
                      </td>   
                      <td class='title'  width="40%">
                      		����ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='SumDefLoss1'>&nbsp;&nbsp;&nbsp;&nbsp;
                      		�˶�����ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='SumVerifyLoss1'>
                      </td>     
                    </tr>
                  </table>  
                </td>
              </tr>
           </tfoot> 
          </tfoot>
          <tbody> 
<% indexVerifyLoss=0;%>
<% String compensatebackReadOnly=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String compensatebackDiasable=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String compensatebackStyle=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<%
      repairFeeNo = 0;
      if(prpLrepairFeeDto.getRepairFeeList() != null){
        for(int index1 = 0;index1<prpLrepairFeeDto.getRepairFeeList().size();index1++){
          PrpLrepairFeeDto prpLrepairFeeDto1 = (PrpLrepairFeeDto)prpLrepairFeeDto.getRepairFeeList().get(index1);
          if(prpLrepairFeeDto1.getLossItemCode().equals(prpLcarLossDto.getLossItemCode())){
            repairFeeNo = Integer.parseInt(prpLrepairFeeDto1.getLossItemCode());
            //���������˻ص��ж�
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
                <td class="input" style="width:12%"><!-- ����ע -->
                  <input name="prpLrepairFeeRemark" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' value="<%= prpLrepairFeeDto1.getVeriRemark() %>">
                </td>
                <td class="input" align="right" style="width:8%"><!-- �˶���ʱ�� -->
                  <input name="prpLrepairFeeVeriManHour" type="hidden" value="<%= prpLrepairFeeDto1.getVeriManHour() %>" onBlur="return getSumDefLossVerify(this,1);">         
                  <input name="prpLrepairFeeVeriManUnitPrice" class="input"  style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getVeriManUnitPrice() %>" onBlur="getSumDefLossVerify(this,1);calSumDefLoss1();">
                </td>
                <td class="input" align="right" style="width:10%"><!-- ������ -->
                  <input name="prpLrepairFeeVeriMaterialFee" type="hidden" value="<%= prpLrepairFeeDto1.getVeriMaterialFee() %>" onBlur="return getSumDefLossVerify(this,1);">                
                  <input name="prpLrepairFeeVeriSumLoss" class="readonly" readonly style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
                    value="<%= prpLrepairFeeDto1.getVeriSumLoss() %>" >
                </td>
                <td class="input" align="left"><!-- ����ע -->
                  <input name="prpLrepairFeeVeriRemark"  class="input" maxLength="60" onblur="checkLength1(this);" description="����ע" style='width:100%<%=compensatebackStyle%>' <%=compensatebackReadOnly%>
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