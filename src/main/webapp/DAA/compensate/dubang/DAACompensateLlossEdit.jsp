<%--
****************************************************************************
* DESC       ：添加标的赔款费用信息页面
* AUTHOR     ：lixiang
* CREATEDATE ： 2004-06-01
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
****************************************************************************
--%>
<%@page import="java.util.*"%>

   <!--建立显示的录入条，可以收缩显示的-->
      <span style="display:none">
        <table class="common" style="display:none" id="CompensateLoss_Data" cellspacing="1" cellpadding="0">
<% 
  ArrayList prpCitemKindDtoListInit = (ArrayList)request.getAttribute("prpCitemKindDtoListInit");
  for (int i = 0; i < prpCitemKindDtoListInit.size(); i++) {
      PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindDtoListInit.get(i);

      if (prpCitemKindDto.getKindCode().trim().substring(0,1).equals("B")) continue;
%>
          <tbody id="A">
            <tr>
              <!-- 号牌号码 -->
              <td class="inputsubsub" style="width:9%">
                <input name="licenseNo" class="input" style="width:98%" value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />">
                <input type="hidden" name="lossDtoSerialNo" style="width:10px">
                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpCitemKindDto.getKindCode() %>"  onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);">
                <input type="hidden" name=prpLlossDtoKindName value="<%= prpCitemKindDto.getKindName() %>">
              </td>
			  <!-- 财物名称 -->
              <td class="inputsubsub" style="width:9%">
                <input name="prpLlossDtoLossName" maxlength=40  class="common" style="width:98%" value="<%= prpCitemKindDto.getItemDetailName() %>">
              </td>
              <!-- 损失明细 -->
              <td class="inputsubsub" style="width:10%">
                <input type="hidden" name="prpLlossDtoFeeTypeCode" class='codecode' style="width:30%"
                  ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                  onchange="code_CodeChange(this, 'PropertyFeeType');"
                  onkeyup= "code_CodeSelect(this,'PropertyFeeType');"
                  onblur= "code_CodeChange(this,'PropertyFeeType',1);getValue(this);">
                <input name="prpLlossDtoFeeTypeName" class='codename' style="width:98%" value=""
                  ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                  onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
                  onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                  onblur= "getValue(this);">
              </td>
              <!-- 核定损失 -->
              <td class="inputsubsub" style="width:9%">
                <input name="prpLlossDtoSumLoss" class="common" style="width:98%"  onchange="calRealpayForDuBang(this);calLoss();">
              </td>
              <!-- 剔除金额 -->
              <td class="inputsubsub" style="width:9%">
                <input name="prpLlossDtoSumRest" class="common" style="width:98%" onchange="calRealpayForDuBang(this);calLoss();" onfocus="checkInputPower(this);" value="0.0">
              </td>
              <!-- 承保比例 -->
              <td class="inputsubsub" style="width:8%">
                <input name="prpLlossDtoClaimRate"  style="width:98%" class='readonly' readonly onchange="calRealpayForDuBang(this); changeChargeAmount();" value="100.0">
              </td>
              <!-- 责任比例 -->
              <td class="inputsubsub" style="width:8%">
                <input name="prpLlossDtoIndemnityDutyRate"  class='readonly' readonly style="width:98%" onchange="<%//getIndemnityDutyRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll(); changeChargeAmount(); setRealPay();%>" value="<bean:write name='prpLcompensateDto' property='indemnityDutyRate' filter='true' />">
              </td>
              <!-- 协商比例 -->
              <td class="inputsubsub" style="width:8%">
                <input name="prpLlossDtoArrangeRate" class="common" style="width:98%" onchange="getArrangeRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll();calLoss();" value="100.0">
              </td>
              <!-- 责任免赔率 -->
              <td class="inputsubsub" style="width:10%">
				<input name="prpLlossDtoDeductible" type="hidden"  value="<%= prpCitemKindDto.getDeductible() %>">
                <input name="prpLlossDtoDutyDeductibleRate" class='readonly' readonly style="width:98%" onchange="changeChargeAmount();calRealpayForDuBang(this); " onblur="return checkLossDeductibleRate(this);"  value="<%= prpCitemKindDto.getDutyDeductibleRate() %>">
              </td>
              <!-- 绝对免赔率 -->
              <td class="inputsubsub" style="width:10%">
                <input name="prpLlossDtoDeductibleRate" class='readonly' readonly style="width:98%" onchange="changeChargeAmount();calRealpayForDuBang(this);" onblur="return checkLossDeductibleRate(this);"  value="<%= prpCitemKindDto.getDeductibleRate() %>">
                <input type="hidden" name= "PrpLlossDtoMainKindDuctibleRate">
                <input type="hidden" name="prpLlossDtoDriverDeductibleRate" value="<%= prpCitemKindDto.getDriverDeductibleRate() %>">
              </td>
              
              <!-- 
              <td class="inputsubsub" style="width:8%" style="display:none">
                <input name="prpLlossDtoDriverDeductibleRate" class='readonly' readonly style="width:45%" value="<%= prpCitemKindDto.getDriverDeductibleRate() %>">
              </td>
              -->
              <td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:98%" readonly onchange="calFund();" value="0">
                <input type="hidden" name="prpLlossDtoFamilyNo">
                <input type="hidden" name="prpLlossDtoItemKindNo" value="<%= prpCitemKindDto.getItemKindNo() %>">
                <input type='hidden' name='prpLlossDtoFamilyName'>
                <input type='hidden' name='prpLlossDtoItemCode'>
                <input type='hidden' name='prpLlossDtoItemAddress'>
                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="人民币">
                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12">
                <input type='hidden' name='prpLlossDtoDepreRate'>
                <input type='hidden' name='prpLlossDtoCurrency' value="CNY">
                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY">
                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY">
                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY">
                <input type='hidden' name='prpLlossDtoFlag'>
                <input type='hidden' name='prpLlossDtoUnit'>
                <input type="hidden" name="prpLlossDtoAmount"  value="<%= prpCitemKindDto.getAmount() %>">
                <input type="hidden" name="prpLlossDtoItemValue"  value="<%= prpCitemKindDto.getAmount() %>">
                <input type="hidden" name="prpLlossDtoUnitPrice"  value="<%= prpCitemKindDto.getUnitAmount() %>">
                <input type="hidden" name="prpLlossDtoLossQuantity"  value="<%= prpCitemKindDto.getQuantity() %>">
                <input type="hidden" name="button_Loss_Refresh" >
              </td>
              <td class="inputsubsub" style='width:3%'>
              <div align="center">
                <input type=button name="buttonCompensateLossDelete"  class="smallbutton" onclick="deleteRowTableL(this,'CompensateLoss',1,1)" value="-" readonly style="cursor: hand">
              </div>
              </td>
            </tr>
          </tbody>
<%
	break;
  }
%>    <input type='hidden' name='prpCitemKindCount' value="<%= prpCitemKindDtoListInit.size() %>">
        </table>
      </span>

      <table class="common" align="center">
      <!--表示显示多行的-->
        <tr>
          <td class="common" colspan="4" style="text-align:left">
            <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="lLossImg" onclick="showPage(this,spanlLoss);changeCompensateFlag('1');">赔付标的信息
            <input type="button" class="button" name="button_Loss_Collect" value="汇总" onclick="return showLossCollect();">
        <!-- 免赔率选择-20060418--start--------------------->
         <% if (editType.equals("EDIT")) { %>  
            <input type="button" class="button" name="button_DeductibleRate" value="选择免赔条件" onclick="choseDeductibleRate();">
         <%}else { }%>
         <!-- 免赔率选择-20060418--end--------------------->
            <br>
            <span style="display:none">
              <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
                <tbody>
                  <tr>
                    <td class="input" style="width:6%">
                      <input type="input" name="prpLlossDtoKindCodeShow" class="codecode" style="width:25px">
                      <input type="input" name="prpLlossDtoKindNameShow" class="codename" style="width:5px">
                     <!-- 免赔率选择-20060418--start--------------------->
                      <input type="hidden"  name="DutyDeductibleRate"   style="width:55px"  >
                      <input type="hidden"  name="DeductibleRate"       style="width:55px"  >
                      <!-- 免赔率选择-20060418--end--------------------->
                      <input type="hidden" style="width:90%" name="prpLlossDtoSerialNo">
                   </td>
                   <td class="subformtitle" style="width:94%">
                      <span  id="spanCompensateLoss">
                        <%-- 多行输入展现域 --%>
                        <table id="CompensateLoss" name="CompensateLoss" cellpadding="0" cellspacing="1" border="0" class="title" style="width:100%">
                          <thead>
                          </thead>
                          <tfoot>
                            <tr>
                              <td class="titlesubsub" colspan="11" style="width:97%"></td>
                              <td class="titlesubsub" align="right" style="width:3%">
                                <div align="center">
                                  <input type="button" value="+" class="smallbutton" onclick="insertRowTableL('CompensateLoss','CompensateLoss_Data',this); <%//setRealPay();%>" name="buttonCompensateLossInsert" readonly style="cursor: hand">
                                </div>
                              </td>
                            </tr>
                          </tfoot>

                          <tbody>
                          </tbody>
                        </table>
                      </span>
                   </td>
                 </tr>
               </tbody>
             </table>
           </span>

             <span  id="spanlLoss" style="display:">
               <%-- 多行输入展现域 --%>
               <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                 <thead>
                   <tr>
                     <td class="centertitle" style="width:4%">险别</td>
                     <td class="centertitle" style="width:96%">
                      <table cellpadding="0" cellspacing="1" border="0" class="centertitle">
                        <tr>
                          <td class="centertitle" style="width:9%" align="center">号牌</td>
                          <td class="centertitle" style="width:9%" align="center">财物名称</td>
                          <td class="centertitle" style="width:10%" align="center">损失明细</td>
                          <td class="centertitle" style="width:9%" align="center">核定损失</td>
                          <td class="centertitle" style="width:9%" align="center">剔除金额</td>
                          <td class="centertitle" style="width:8%" align="center">承保比例%</td>
                          <td class="centertitle" style="width:8%" align="center">责任比例%</td>
                          <td class="centertitle" style="width:8%" align="center">协商比例%</td>
                          <td class="centertitle" style="width:10%" align="center">责任免赔率%</td>
                          <td class="centertitle" style="width:10%" align="center">绝对免赔率%</td>
                          <!-- 
                          <td class="centertitle" style="display:none" style="width:8%">驾驶员免赔率%</td>
                          -->
                          
                          <td class="centertitle" style="width:7%" align="center">赔偿金额</td>
                          <td class="centertitle" style="width:3%" align="center">操作</td>
                        </tr>
                      </table>
                     </td>
                   </tr>
                 </thead>

                 <tfoot>

                 </tfoot>
                 <tbody>
<% 
	PrpLlossDto prpLlossDto = (PrpLlossDto)request.getAttribute("prpLlossDto");
	PrpLlossDto prpLlossDtoTemp = null;
    ArrayList prpLlossList = (ArrayList)prpLlossDto.getPrpLlossList();
    for (int i = 0; i < prpCitemKindDtoListInit.size(); i++) {
        PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)prpCitemKindDtoListInit.get(i);
      if (prpCitemKindDto.getKindCode().trim().equals("B")) continue;		
%>
                  <tr>
                    <td class="input" style="width:6%">
                      <input type="input" name="prpLlossDtoKindCodeShow" class="readonly" readonly style="width:25px"  value="<%= prpCitemKindDto.getKindCode() %>">
                      <input type="input" name="prpLlossDtoKindNameShow" class="readonly" readonly style="width:55px"  value="<%= prpCitemKindDto.getKindName() %>">
                      <input name="claimRate"   type="hidden"  value="">
                       <input name="indemnityDutyRate"  type="hidden"  value="">
                      <!-- 免赔率选择-20060418--start--------------------->
                      <input type="hidden" name="DutyDeductibleRate"  value="<%= prpCitemKindDto.getDutyDeductibleRate() %>">
                      <input type="hidden" name="DeductibleRate"      value="<%= prpCitemKindDto.getDeductibleRate() %>">
                       <!-- 免赔率选择-20060418--start--------------------->
                      <input type="hidden" name="prpLlossDtoSerialNo"  style="width:10px"  value="<%= i+1 %>">
                   </td>
                   <td class="subformtitle" style="width:94%">
                      <span  id="spanCompensateLoss">
                        <%-- 多行输入展现域 --%>
                        <table id="CompensateLoss" name="CompensateLoss" cellpadding="0" cellspacing="1" border="0" class="title" style="width:100%">
                          <thead>
                          </thead>
                          <tfoot>
                            <tr>
                              <td class="titlesubsub" colspan="11" style="width:97%"></td>
                              <td class="titlesubsub" align="right" style="width:3%">
                                <div align="center">
                           <!-- 免赔率选择-20060418--start--------------------->
                           		<!-- mdd -->
                                <input type="button" value="+" class="smallbutton" onclick="insertRowTableL('CompensateLoss','CompensateLoss_Data',this,'A',fm.prpLlossDtoKindCodeShow[<%=i+1%>].value,'<%= prpCitemKindDto.getKindName() %>','<%= prpCitemKindDto.getItemKindNo() %>',fm.DutyDeductibleRate[<%=i+1%>].value,fm.DeductibleRate[<%=i+1%>].value,'<%= prpCitemKindDto.getDriverDeductibleRate() %>','<%= prpCitemKindDto.getUnitAmount() %>','<%= prpCitemKindDto.getAmount() %>');  setRealPay();" name="buttonCompensateLossInsert" readonly style="cursor: hand">
                          <!-- 免赔率选择-20060418--end--------------------->      
                                </div>
                              </td>
                            </tr>
                          </tfoot>
                          <tbody>
<%

        if(prpLlossList!=null&&prpLlossList.size()>0){
        for (int j = 0; j < prpLlossList.size(); j++) {
          prpLlossDtoTemp = (PrpLlossDto)prpLlossList.get(j);
          if(prpLlossDtoTemp.getKindCode().equals(prpCitemKindDto.getKindCode())){
%>
                            <tr>
                              <!-- 号牌号码  -->
                              <td class="inputsubsub" style="width:9%">
                                <input name="licenseNo" class="input" style="width:98%" value="<%= prpLlossDtoTemp.getLicenseNo() %>">
                                <input type="hidden" name="lossDtoSerialNo"  style="width:10px" value="<%= i+1 %>">
                                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpLlossDtoTemp.getKindCode() %>" onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);">
                                <input type="hidden" name=prpLlossDtoKindName value="<%= prpLlossDtoTemp.getKindName() %>">
                            <input name="claimRate"   type="hidden"  value="<%= prpLlossDtoTemp.getClaimRate() %>">
                            <input name="indemnityDutyRate"  type="hidden"  value="<%= prpLlossDtoTemp.getIndemnityDutyRate() %>">
                    
                             
                              </td>
                              <!-- 财物名称  -->
                              <td class="inputsubsub" style="width:9%">
                                <input name="prpLlossDtoLossName" class="input" style="width:98%" value="<%= prpLlossDtoTemp.getLossName() %>">
                              </td>
                              <!-- 损失明细  -->
                              <td class="inputsubsub" style="width:10%">
                                <input type="hidden" name="prpLlossDtoFeeTypeCode" class='codecode' style="width:30%" value="<%= prpLlossDtoTemp.getFeeTypeCode() %>"
                                  ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                                  onchange="code_CodeChange(this, 'PropertyFeeType');"
                                  onkeyup= "code_CodeSelect(this,'PropertyFeeType');"
                                  onblur= "code_CodeChange(this,'PropertyFeeType',1);getValue(this);">
                                <input name="prpLlossDtoFeeTypeName" class='codename' style="width:98%" value="<%= prpLlossDtoTemp.getFeeTypeName() %>"
                                  ondblclick= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                                  onchange="code_CodeChange(this, 'PropertyFeeType','-1','name','none','post');"
                                  onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','name','none','post');"
                                  onblur= "getValue(this);">
                              </td>
                              <!-- 核定损失  -->
                              <td class="inputsubsub" style="width:9%">
                                <input name="prpLlossDtoSumLoss" class="common" style="width:98%"  onchange="changeChargeAmount();calRealpayForDuBang(this);calLoss();" value="<%= prpLlossDtoTemp.getSumLoss() %>">
                              </td>
                              <!-- 剔除金额  -->
                              <td class="inputsubsub" style="width:9%">
                                <input name="prpLlossDtoSumRest" class="common" style="width:98%" onchange="calRealpayForDuBang(this);calLoss();" onfocus="checkInputPower(this);" value="<%= prpLlossDtoTemp.getSumRest() %>">
                              </td>
							  <!-- 赔偿比例  -->
                              <td class="inputsubsub" style="width:8%"  align="center">
                                <input name="prpLlossDtoClaimRate" style="width:90%" class='readonly' readonly onchange="calRealpayForDuBang(this);calLoss();changeChargeAmount();" value="<%= prpLlossDtoTemp.getClaimRate() %>">
                              </td>                              
                              
                              <!-- 责任比例  -->                                                
                              <td class="inputsubsub" style="width:8%" align="center">
                                <input name="prpLlossDtoIndemnityDutyRate" class='readonly' readonly style="width:98%" onchange="getIndemnityDutyRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll(); changeChargeAmount(); setRealPay();" value="<%= prpLlossDtoTemp.getIndemnityDutyRate() %>">
                              </td>
								
							  <!-- 协商比例  -->
                              <td class="inputsubsub" style="width:8%" align="center">
                                <input name="prpLlossDtoArrangeRate" class="common" style="width:98%" onchange="getArrangeRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll();calLoss();" value="<%= prpLlossDtoTemp.getArrangeRate() %>">
                              </td> 
                              
                              <!-- 责任免赔率  -->
                              <td class="inputsubsub" style="width:10%" align="center">
                                <input name="prpLlossDtoDeductible" type="hidden" value="<%= prpLlossDtoTemp.getDeductible() %>">
                                <input name="prpLlossDtoDutyDeductibleRate" class='readonly' readonly style="width:98%" onchange=" changeChargeAmount();calRealpayForDuBang(this);" onblur="return checkLossDeductibleRate(this);"
                                value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDutyDeductibleRate()) %>">
                              </td>
                              
                              <!-- 绝对免赔率  -->
                              <td class="inputsubsub" style="width:10%" align="center">
                                <input name="prpLlossDtoDeductibleRate" class='readonly' readonly style="width:98%" onchange=" changeChargeAmount();calRealpayForDuBang(this);" onblur="return checkLossDeductibleRate(this);"
                                value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDeductibleRate()) %>">
                                <input type="hidden" name= "PrpLlossDtoMainKindDuctibleRate">
                                <input type="hidden" name="prpLlossDtoDriverDeductibleRate" value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDriverDeductibleRate()) %>">
                              </td>
                                                
                              <!-- 赔偿金额  -->            
                              <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:98%" readonly onchange="calFund();" value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getSumRealPay()) %>">
                                <input type="hidden" name="prpLlossDtoFamilyNo" value="<%= prpLlossDtoTemp.getFamilyNo() %>">
                                <input type="hidden" name="prpLlossDtoItemKindNo" value="<%= prpCitemKindDto.getItemKindNo() %>">
                                <input type='hidden' name='prpLlossDtoFamilyName' value="<%= prpLlossDtoTemp.getFamilyName() %>">
                                <input type='hidden' name='prpLlossDtoItemCode' value="<%= prpLlossDtoTemp.getItemCode() %>">
                                <input type='hidden' name='prpLlossDtoItemAddress' value="<%= prpLlossDtoTemp.getItemAddress() %>">
                                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="人民币">
                                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12">
                                <input type='hidden' name='prpLlossDtoDepreRate' value="<%= prpLlossDtoTemp.getDepreRate() %>">
                                <input type='hidden' name='prpLlossDtoCurrency' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY">
                                <input type='hidden' name='prpLlossDtoFlag' value="<%= prpLlossDtoTemp.getFlag() %>">
                                <input type='hidden' name='prpLlossDtoUnit' value="<%= prpLlossDtoTemp.getUnit() %>">
                                <input type="hidden" name="prpLlossDtoAmount" value="<%= prpLlossDtoTemp.getAmount() %>">
                                <input type="hidden" name="prpLlossDtoItemValue" value="<%= prpLlossDtoTemp.getItemValue() %>">
                                <input type="hidden" name="prpLlossDtoUnitPrice" value="<%= prpLlossDtoTemp.getUnitPrice() %>">
                                <input type="hidden" name="prpLlossDtoLossQuantity" value="<%= prpLlossDtoTemp.getLossQuantity() %>">
                                <input type="hidden" name="button_Loss_Refresh">
                              </td>
                              
                              <td class="inputsubsub" style='width:3%'>
                              <div align="center">
                                <input type=button name="buttonCompensateLossDelete"  	class="smallbutton" onclick="deleteRowTableL(this,'CompensateLoss',1,1)" value="-" readonly style="cursor: hand">
                              </div>
                              </td>
                            </tr>
<%
          }//if equals()
        }//for
      }//prpLlossList!=null
%>

                          </tbody>
                        </table>
                      </span>
                   </td>
              </tr>
<%
  }//for prpCitemKindDtoListInit
%>
         </tbody>
       </table>
     </span>
   </td>
 </tr>
 <logic:present name="prpLdeductibleDto">
  <tr>
    <td class="title"  style="width:12%"><b>免赔额信息：</b></td>
    <td class="title"  style="width:25%">车辆损失险(A)免赔额:
      <input type="text" style="width:20%" class="common" name="prpLDeductible" value="<bean:write name='prpLdeductibleDto' property='deductible' />" onchange="calFund();"></td>
     
    <td class="title"  style="width:63%"><!-- 车损险最终赔款:--> <input type="hidden" style="width:60%" class="readonly" name="lastRealPay" value=""></td>
    
  </tr>
 </logic:present>
  <logic:notPresent name="prpLdeductibleDto">
    <input type="hidden" style="width:20%" class="common" name="prpLDeductible" value="0" >
    <input type='hidden' style="width:60%" class="readonly" name="lastRealPay" value="">
  </logic:notPresent> 
</table>




