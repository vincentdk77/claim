<%--
****************************************************************************
* DESC       ����ӱ����������Ϣҳ��
* AUTHOR     ��lixiang
* CREATEDATE �� 2004-06-01
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>

   <!--������ʾ��¼����������������ʾ��-->
      <span style="display:none">
        <table class="common" style="display:none" id="CompensateLoss_Data" cellspacing="1" cellpadding="0">
<%
			ArrayList prpCitemKindDtoListInit = (ArrayList) request
			.getAttribute("prpCitemKindDtoListInit");
	for (int k = 0; k < prpCitemKindDtoListInit.size(); k++) {
		PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) prpCitemKindDtoListInit
		.get(k);
%>
          <tbody id="A">
            <tr>
              
<!--���ƺ���--><td class="inputsubsub" style="width:9%">
                <input name="prpLicenseNo" class="input" style="width:98%" value="<bean:write name='prpLcompensateDto' property='licenseNo' filter='true' />">
                <input type="hidden" name="lossDtoSerialNo" style="width:10px">
                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpCitemKindDto.getKindCode() %>"  
                       onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);"
                        onchange="setFlagDanger();">
                <input type="hidden" name=prpLlossDtoKindName value="<%= prpCitemKindDto.getKindName() %>"
                 onchange="setFlagDanger();">
              </td>
              
<!--��������--><td class="inputsubsub" style="width:9%">
                <input name="prpLlossDtoLossName" maxlength=40  class="common" style="width:98%" value="<%= prpCitemKindDto.getItemDetailName() %>">
              </td>
              
<!--��ʧ��ϸ--><td class="inputsubsub" style="width:9%">
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
              
<!--�˶���ʧ--><td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoSumLoss" class="common" style="width:98%"  
                       onchange="changeChargeAmount();calRealpayForDuBang(this);calLoss();setFlagDanger();"  
                       onblur="calRealpayForDuBang(this);calLoss();">
              </td>
              
<!--�޳����--><td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoSumRest" class="common" style="width:98%" 
                       onchange="calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');"   
                       onblur="calRealpayForDuBang(this);setFlagDanger();" 
                       onfocus="checkInputPower(this);">
              </td>
<!--��ǿ�������--><td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoCISumRealPay" class="common" style="width:98%" 
                       onchange="calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();"   
                       onblur="calRealpayForDuBang(this);" 
                       onfocus=""
                       value="<%= prpCitemKindDto.getCISumRealPay() %>">
              </td>
<!--�˶��⳥--><td class="inputsubsub" style="width:8%">
                <input name="prpLlossDtoSumDefPay" class="common" style="width:98%"  readonly="readonly"
                       onblur="changeChargeAmount();calRealpayForDuBang(this);checkQuotaByKindCode();calLoss();setSumDutyDeductibleFlag('0');" >
              </td>
              
<!--�⳥����--><td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoClaimRate"  class="common"  
                       onchange="calRealpayForDuBang(this); changeChargeAmount();setSumDutyDeductibleFlag('0');setFlagDanger();" value=100>
              </td>
              
<!--���α���--><td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoIndemnityDutyRate" class="common" style="width:98%" 
                       onchange="getIndemnityDutyRate(this);calRealpayForDuBang(this); changeChargeAmount(); setRealPay();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                       value="<bean:write name='prpLcompensateDto' property='indemnityDutyRate' filter='true' />">
              </td>
              
<!--Э�̱���--><td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoArrangeRate" class="common" style="width:98%" 
                       onchange="getArrangeRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll();calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                       value="100">
              </td>
              
<!--����������--><td class="inputsubsub" style="width:6%">
                <input name="prpLlossDtoDeductible" type="hidden"  value="">
<!--������ѡ��--> <input name="prpLlossDtoDutyDeductibleRate" style="width:98%" 
                       onchange="changeChargeAmount();calRealpayForDuBang(this); setSumDutyDeductibleFlag('0');setFlagDanger();" 
                       onblur="return checkLossDeductibleRate(this);"  value="<%= prpCitemKindDto.getDutyDeductibleRate() %>">
              </td>
              
<!--����������--><td class="inputsubsub" style="width:6%">
                 <input name="prpLlossDtoDeductibleRate"  style="width:98%" 
                        onchange="changeChargeAmount();calRealpayForDuBang(this);setSumDutyDeductibleFlag('0');setFlagDanger();" 
                        onblur="return checkLossDeductibleRate(this);"  value="<%= prpCitemKindDto.getDeductibleRate() %>">
                 <input type="hidden" name= "PrpLlossDtoMainKindDuctibleRate">
                 <input type="hidden" name="prpLlossDtoDriverDeductibleRate" value="<%= prpCitemKindDto.getDriverDeductibleRate() %>">
              </td>
             
              <td class="inputsubsub" style="width:7%">
                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:98%" readonly onchange="calFund();setSumDutyDeductibleFlag('0');" value="0">
                <input type="hidden" name="prpLlossDtoFamilyNo">
                <input type="hidden" name="prpLlossDtoItemKindNo" value="<%= prpCitemKindDto.getItemKindNo() %>">
                <input type='hidden' name='prpLlossDtoFamilyName'>
                <input type='hidden' name='prpLlossDtoItemCode'>
                <input type='hidden' name='prpLlossDtoItemAddress'>
                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="�����">
                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12">
                <input type='hidden' name='prpLlossDtoDepreRate'>
                <input type='hidden' name='prpLlossDtoCurrency' value="CNY">
                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY">
                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY">
                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY">
                <input type='hidden' name='prpLlossDtoFlag' value="">
<!-- �ձ��Ƿ�б��˲�������ı�ʶ --><input type='hidden' name='prpLlossFlag' value="<%= prpCitemKindDto.getFlag() %>">
                <input type='hidden' name='prpLlossDtoUnit'>
                <input type="hidden" name="prpLlossDtoAmount"  value="<%= prpCitemKindDto.getAmount() %>">
                <input type="hidden" name="prpLlossDtoItemValue"  value="<%= prpCitemKindDto.getAmount() %>">
                <input type="hidden" name="prpLlossDtoUnitPrice"  value="<%= prpCitemKindDto.getUnitAmount() %>">
                <input type="hidden" name="prpLlossDtoLossQuantity"  value="<%= prpCitemKindDto.getQuantity() %>">
                <input type="hidden" name="button_Loss_Refresh" >
              </td>
              <td class="inputsubsub" style='width:3%'>
              <div align="center">
                <input type=button name="buttonCompensateLossDelete"  class="smallbutton" onclick="deleteRowTableL(this,'CompensateLoss',1,1);setFlagDanger();" value="-" readonly style="cursor: hand">
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
 <!--��ʾ��ʾ���е�-->
        <tr>
          <td class="common" colspan="4" style="text-align:left">
            <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif" name="lLossImg" onclick="showPage(this,spanlLoss);changeCompensateFlag('1');">�⸶�����Ϣ
            <input type="button" class="button" name="button_Loss_Collect" value="����" onclick="return showLossCollect();">
<!-- ����������� -->
         <%
         			PrpLlossDto prpLlossDto1 = (PrpLlossDto) request
         			.getAttribute("prpLlossDto");
         	for (int k = 0; k < prpCitemKindDtoListInit.size(); k++) {
         		PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) prpCitemKindDtoListInit
         		.get(k);
         		if (prpCitemKindDto.getKindCode().equals("M")) {
         %>                
                <input type="button" class="bigbutton" name="button_Loss_Collect" value="�����������" onclick="SumDutyDeductible();setSumDutyDeductibleFlag('1')">
                  <!-- �Ƿ����ˡ�����������㰴ť���ı�ʶ-->
                  <input type="hidden" style="width:60%"  name='sumDutyDeductibleFlag' value="0">
         <%
         		break;
         		}
         	}
         %>
<!--������ѡ��-->
         <%
         if (editType.equals("EDIT")) {
         %>  
            <input type="button" class="button" name="button_DeductibleRate" value="ѡ����������" onclick="choseDeductibleRate();">
         <%
         	} else {
         	}
         %>
            <br>
            <span style="display:none">
              <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
                <tbody>
                  <tr>
                    <td class="input" style="width:6%">
                      <input type="input" name=prpLlossDtoKindCodeShow class="codecode" style="width:25px">
                      <input type="input" name=prpLlossDtoKindNameShow class="codename" style="width:5px">
<!--������ѡ��-->       <input type="hidden"  name=DutyDeductibleRate   style="width:55px"  >
                      <input type="hidden"  name=DeductibleRate       style="width:55px"  >
                      <input type="hidden" style="width:90%" name="prpLlossDtoSerialNo">
                      <input type="hidden" name=noDutyFlagForPersonLoss      value="">
                   </td>
                   <td class="subformtitle" style="width:94%">
                      <span  id="spanCompensateLoss">
                        <%-- ��������չ���� --%>
                        <table id="CompensateLoss" name="CompensateLoss" cellpadding="0" cellspacing="1" border="0" class="title" style="width:100%">
                          <tfoot>
                            <tr>
                              <td class="titlesubsub" colspan="13" style="width:97%"></td>
                              <td class="titlesubsub" align="right" style="width:3%">
                                <div align="center">
                                  <input type="button" value="+" class="smallbutton" name="buttonCompensateLossInsert" style="cursor: hand"
                                         onclick="insertRowTableL('CompensateLoss','CompensateLoss_Data',this); setRealPay();setFlagDanger();" 
                                         readonly >
                                </div>
                              </td>
                            </tr>
                          </tfoot>
                        </table>
                      </span>
                   </td>
                 </tr>
               </tbody>
             </table>
           </span>

             <span  id="spanlLoss" style="display:">
<%-- ��������չ���� --%>
               <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="0" border="0">
                 <thead>
                   <tr>
                     <td class="centertitle" style="width:4%">������</td>
                     <td class="centertitle" style="width:4%">�ձ�</td>
                     <td class="centertitle" style="width:92%">
                      <table cellpadding="0" cellspacing="1" border="1" class="centertitle" width="100%">
                        <tr>
                          <td class="centertitle" style="width:9%" align="center">����</td>
                          <td class="centertitle" style="width:9%" align="center">��������</td>
                          <td class="centertitle" style="width:9%" align="center">��ʧ��ϸ</td>
                          <td class="centertitle" style="width:7%" align="center">�˶���ʧ</td>
                          <td class="centertitle" style="width:7%" align="center">�޳����</td>
                          <td class="centertitle" style="width:7%" align="center">��ǿ�������</td>
                          <td class="centertitle" style="width:8%" align="center">�˶��⳥</td>
                          <td class="centertitle" style="width:7%" align="center" >�⳥����%</td>
                          <td class="centertitle" style="width:7%" align="center">���α���%</td>
                          <td class="centertitle" style="width:7%" align="center">Э�̱���%</td>
                          <td class="centertitle" style="width:6%" align="center">����������%</td>
                          <td class="centertitle" style="width:6%" align="center">����������%</td>
                          <td class="centertitle" style="width:7%" align="center">�⳥���</td>
                          <td class="centertitle" style="width:3%" align="center">����</td>
                        </tr>
                      </table>
                     </td>
                   </tr>
                 </thead>

                 <tfoot>

                 </tfoot>
                 <tbody>
<%
			PrpLlossDto prpLlossDto = (PrpLlossDto) request
			.getAttribute("prpLlossDto");
	PrpLlossDto prpLlossDtoTemp = null;
	ArrayList prpLlossList = (ArrayList) prpLlossDto.getPrpLlossList();
	for (int k = 0; k < prpCitemKindDtoListInit.size(); k++) {
		PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) prpCitemKindDtoListInit
		.get(k);
%>
                  <tr>
                   <td class="centertitle" style="width:4%" >
                      <input type="input" name=prpLlossDtoItemKindShow class="readonly" readonly style="width:25px;color: white;"  value="<%= prpCitemKindDto.getItemKindNo() %>">
                   </td>
                    <td class="centertitle" style="width:4%" >
                      <input type="input" name=prpLlossDtoKindCodeShow class="readonly" readonly style="width:25px;color: white;"  value="<%= prpCitemKindDto.getKindCode() %>">
                      <input type="input" name=prpLlossDtoKindNameShow class="readonly" readonly style="width:55px;color: white;"  value="<%= prpCitemKindDto.getKindName() %>">
                      <input name="claimRate"   type="hidden"  value="">
                       <input name="indemnityDutyRate"  type="hidden"  value="">
                      <!-- ������ѡ��-20060418--start--------------------->
                      <input type="hidden" name=DutyDeductibleRate  value="<%= prpCitemKindDto.getDutyDeductibleRate() %>">
                      <input type="hidden" name=DeductibleRate      value="<%= prpCitemKindDto.getDeductibleRate() %>">
                      
<!--�Ƿ�б��˲�������ı�ʶ�����˼��㲻��������ʹ�� -->                     
                      <input type="hidden" name=noDutyFlagForPersonLoss      value="<%= prpCitemKindDto.getFlag() %>">
                       <!-- ������ѡ��-20060418--start--------------------->
                      <input type="hidden" name="prpLlossDtoSerialNo"  style="width:10px"  value="<%= i+1 %>">
                   </td>
                   <td class="subformtitle" style="width:92%">
                      <span  id="spanCompensateLoss">
                        <%-- ��������չ���� --%>
                        <table id="CompensateLoss" name="CompensateLoss" cellpadding="0" cellspacing="1" border="0" class="title" style="width:100%">
                          <thead>
                          </thead>
                          <tfoot>
                            <tr>
                              <td class="titlesubsub" colspan="13" style="width:97%"></td>
                              <td class="titlesubsub" align="right" style="width:3%">
                                <div align="center">
<!--������ѡ��-->                 <input type="button" value="+" class="smallbutton" 
                                       onclick="insertRowTableL('CompensateLoss','CompensateLoss_Data',this,'A','<%= prpCitemKindDto.getKindCode() %>','<%= prpCitemKindDto.getKindName() %>','<%= prpCitemKindDto.getItemKindNo() %>','<%= prpCitemKindDto.getDutyDeductibleRate() %>','<%= prpCitemKindDto.getDeductibleRate() %>','<%= prpCitemKindDto.getDriverDeductibleRate() %>','<%= prpCitemKindDto.getUnitAmount() %>','<%= prpCitemKindDto.getAmount() %>');setFlagDanger();" 
                                       name="buttonCompensateLossInsert" readonly style="cursor: hand">
                                </div>
                              </td>
                            </tr>
                          </tfoot>
                         <tbody>
<%
		boolean M_kindCodeFlag = false; //��ʶ�Ƿ��в���������Լ�յ�����
		if (prpLlossList != null && prpLlossList.size() > 0) {
			for (int j = 0; j < prpLlossList.size(); j++) {
		prpLlossDtoTemp = (PrpLlossDto) prpLlossList.get(j);
		if ((prpLlossDtoTemp.getKindCode().equals(
				prpCitemKindDto.getKindCode()) && !"3119"
				.equals(prpLlossDtoTemp.getRiskCode()))
				|| (prpLlossDtoTemp.getKindCode().equals(
				prpCitemKindDto.getKindCode())
				&& "3119".equals(prpLlossDtoTemp
				.getRiskCode()) && prpLlossDtoTemp
				.getItemKindNo() == prpCitemKindDto
				.getItemKindNo())) {
			M_kindCodeFlag = true;
%>
                            <tr>
 <!--���ƺ���-->               <td class="inputsubsub" style="width:9%">
                                <input name="prpLicenseNo" class="input" style="width:98%" value="<%= prpLlossDtoTemp.getLicenseNo() %>">
                                <input type="hidden" name="lossDtoSerialNo"  style="width:10px" value="<%= k+1 %>">
                                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpLlossDtoTemp.getKindCode() %>" 
                                       onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);"
                                        onchange="setFlagDanger();">
                                <input type="hidden" name=prpLlossDtoKindName value="<%= prpLlossDtoTemp.getKindName() %>"
                                 onchange="setFlagDanger();">
                                <input name="claimRate"   type="hidden"  value="<%= prpLlossDtoTemp.getClaimRate() %>">
                                <input name="indemnityDutyRate"  type="hidden"  value="<%= prpLlossDtoTemp.getIndemnityDutyRate() %>">
                              </td>
<!--��������-->                <td class="inputsubsub" style="width:9%">
                                <input name="prpLlossDtoLossName" class="input" style="width:98%" value="<%= prpLlossDtoTemp.getLossName() %>">
                              </td>
                              
<!--��ʧ��ϸ-->                <td class="inputsubsub" style="width:9%">
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
                              
<!--�˶���ʧ-->                 <td class="inputsubsub" style="width:7%">
                                <input name="prpLlossDtoSumLoss" class="common" style="width:98%"  
                                       onchange="changeChargeAmount();calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       onblur="calRealpayForDuBang(this);calLoss();" value="<%= prpLlossDtoTemp.getSumLoss() %>">
                              </td>
                              
<!--�޳����-->                <td class="inputsubsub" style="width:7%">
                                <input name="prpLlossDtoSumRest" class="common" style="width:98%" 
                                       onchange="calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       onfocus="checkInputPower(this);"  
                                       onblur="calRealpayForDuBang(this);calLoss();" 
                                       value="<%= prpLlossDtoTemp.getSumRest() %>">
                              </td>
<!--��ǿ�������-->
								<td class="inputsubsub" style="width: 7%"><input
									name="prpLlossDtoCISumRealPay" class="common"
									style="width: 98%"
									onchange="calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();"
									onblur="calRealpayForDuBang(this);"
									onfocus=""
									value="<%= prpLlossDtoTemp.getCISumRealPay() %>"></td>

<!--�˶��⳥-->                 <td class="inputsubsub" style="width:8%">
                                 <input name="prpLlossDtoSumDefPay" readonly="readonly" class="common" style="width:98%"  value="<%= prpLlossDtoTemp.getSumDefPay() %>" 
                                        onblur="changeChargeAmount();calRealpayForDuBang(this);checkQuotaByKindCode();calLoss();setSumDutyDeductibleFlag('0');" >
                              </td>
                              
<!--�⳥����-->				  <td class="inputsubsub"  style="width:7%" align="center">
                                <input name="prpLlossDtoClaimRate" style="width:90%" class="common"  
                                       onchange="calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       value="<%= prpLlossDtoTemp.getClaimRate() %>">
                              </td>
                              
<!--���α���-->                <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoIndemnityDutyRate" class="common" style="width:98%" 
                                       onchange="getIndemnityDutyRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll(); changeChargeAmount(); setRealPay();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       value="<%= prpLlossDtoTemp.getIndemnityDutyRate() %>">
                              </td>
                              
<!--Э�̱���-->                <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoArrangeRate" class="common" style="width:98%" 
                                       onchange="getArrangeRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll();calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       value="<%= prpLlossDtoTemp.getArrangeRate() %>">
                              </td>
                              
<!--����������-->               <td class="inputsubsub" style="width:6%" align="center">
                                <input name="prpLlossDtoDeductible" type="hidden" value="">
                                <input name="prpLlossDtoDutyDeductibleRate"  class='common' style="width:98%" 
                                       onchange=" changeChargeAmount();calRealpayForDuBang(this);setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       onblur="return checkLossDeductibleRate(this);"
                                       value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDutyDeductibleRate()) %>">
                              </td>
                              
<!--����������-->               <td class="inputsubsub" style="width:6%" align="center">
                                <input name="prpLlossDtoDeductibleRate" class='common'  style="width:98%" 
                                       onchange=" changeChargeAmount();calRealpayForDuBang(this);setSumDutyDeductibleFlag('0');setFlagDanger();" 
                                       onblur="return checkLossDeductibleRate(this);"
                                       value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDeductibleRate()) %>">
                                <input type="hidden" name= "PrpLlossDtoMainKindDuctibleRate">
                                <input type="hidden" name="prpLlossDtoDriverDeductibleRate" 
                                       value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getDriverDeductibleRate()) %>">
                              </td>
                                                
                              <!-- �⳥���  -->            
                              <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:98%" readonly 
                                       onchange="calFund();setSumDutyDeductibleFlag('0');setFlagDanger();" value="<%= new DecimalFormat("##0.00").format(prpLlossDtoTemp.getSumRealPay()) %>">
                                <input type="hidden" name="prpLlossDtoFamilyNo" value="<%= prpLlossDtoTemp.getFamilyNo() %>">
                                <input type="hidden" name="prpLlossDtoItemKindNo" value="<%= prpCitemKindDto.getItemKindNo() %>">
                                <input type='hidden' name='prpLlossDtoFamilyName' value="<%= prpLlossDtoTemp.getFamilyName() %>">
                                <input type='hidden' name='prpLlossDtoItemCode' value="<%= prpLlossDtoTemp.getItemCode() %>">
                                <input type='hidden' name='prpLlossDtoItemAddress' value="<%= prpLlossDtoTemp.getItemAddress() %>">
                                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="�����">
                                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12">
                                <input type='hidden' name='prpLlossDtoDepreRate' value="<%= prpLlossDtoTemp.getDepreRate() %>">
                                <input type='hidden' name='prpLlossDtoCurrency' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY">
                                <input type='hidden' name='prpLlossDtoFlag' value="">
<!-- �ձ��Ƿ�б��˲�������ı�ʶ --><input type='hidden' name='prpLlossFlag' value="<%= prpCitemKindDto.getFlag() %>">
                                <input type='hidden' name='prpLlossDtoUnit' value="<%= prpLlossDtoTemp.getUnit() %>">
                                <input type="hidden" name="prpLlossDtoAmount" value="<%= prpLlossDtoTemp.getAmount() %>">
                                <input type="hidden" name="prpLlossDtoItemValue" value="<%= prpLlossDtoTemp.getItemValue() %>">
                                <input type="hidden" name="prpLlossDtoUnitPrice" value="<%= prpLlossDtoTemp.getUnitPrice() %>">
                                <input type="hidden" name="prpLlossDtoLossQuantity" value="<%= prpLlossDtoTemp.getLossQuantity() %>">
                                <input type="hidden" name="button_Loss_Refresh">
                              </td>
                              
                              <td class="inputsubsub" style='width:3%'>
                              <div align="center">
                                <input type=button name="buttonCompensateLossDelete"  	class="smallbutton" 
                                       onclick="deleteRowTableL(this,'CompensateLoss',1,1);setFlagDanger();" value="-" readonly style="cursor: hand">
                              </div>
                              </td>
                            </tr>
<%
			}//if equals()
			}//for
		}//prpLlossList!=null
%>
<%
		//����������Լ����
		if (prpCitemKindDto.getKindCode().equals("M")
		&& !M_kindCodeFlag) {
%>
                            <tr>
 <!--���ƺ���-->               <td class="inputsubsub" style="width:9%">
                                <input name="prpLicenseNo" class="input" style="width:98%" value="">
                                <input type="hidden" name="lossDtoSerialNo"  style="width:10px" value="<%= k+1 %>">
                                <input type="hidden" name=prpLlossDtoKindCode value="<%= prpCitemKindDto.getKindCode() %>" 
                                       onblur="changeLossSumRestShowStyle(this);changeLossClaimRate(this);getValue(this);"
                                        onchange="setFlagDanger();">
                                <input type="hidden" name=prpLlossDtoKindName value="<%= prpCitemKindDto.getKindName() %>"
                                 onchange="setFlagDanger();">
                                <input name="claimRate"   type="hidden"  value="<%= prpCitemKindDto.getClaimRate() %>">
                                <input name="indemnityDutyRate"  type="hidden"  value="<%= prpCitemKindDto.getIndemnityDutyRate() %>">
                              </td>
<!--��������-->                <td class="inputsubsub" style="width:9%">
                                <input name="prpLlossDtoLossName" class="input" style="width:98%" value=" ">
                              </td>
                              
<!--��ʧ��ϸ-->                <td class="inputsubsub" style="width:9%">
                                <input type="hidden" name="prpLlossDtoFeeTypeCode" class='codecode' style="width:30%" value=""
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
                              
<!--�˶���ʧ-->                 <td class="inputsubsub" style="width:7%">
                                <input name="prpLlossDtoSumLoss" class="common" style="width:98%"  
                                       onchange="changeChargeAmount();calRealpayForDuBang(this);calLoss();setFlagDanger();" 
                                       onblur="calRealpayForDuBang(this);calLoss();" value="0.0">
                              </td>
                              
<!--�޳����-->                <td class="inputsubsub" style="width:7%">
                                <input name="prpLlossDtoSumRest" class="common" style="width:98%" 
                                       onchange="calRealpayForDuBang(this);calLoss();" 
                                       onfocus="checkInputPower(this);"  
                                       onblur="calRealpayForDuBang(this);calLoss();" 
                                       value="0.0">
                              </td>
<!--��ǿ�������-->          <td class="inputsubsub" style="width:7%">
                                <input name="prpLlossDtoCISumRealPay" class="common" style="width:98%" 
                                onchange="calRealpayForDuBang(this);calLoss();setSumDutyDeductibleFlag('0');setFlagDanger();"   
                                onblur="calRealpayForDuBang(this);" 
                                onfocus="" readonly="true"
                                value="">
                            </td>

                              
<!--�˶��⳥-->                 <td class="inputsubsub" style="width:8%">
                                 <input name="prpLlossDtoSumDefPay" class="common" style="width:98%"  value="0.0" readonly="readonly"
                                        onblur="changeChargeAmount();calRealpayForDuBang(this);checkQuotaByKindCode();calLoss();" >
                              </td>
                              
<!--�⳥����-->                 <td class="inputsubsub" style="width:7%"  align="center">
                                <input name="prpLlossDtoClaimRate" style="width:90%" class="common"  
                                       onchange="calRealpayForDuBang(this);calLoss();changeChargeAmount();setFlagDanger();" 
                                       value="100">
                              </td>
                              
<!--���α���-->                <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoIndemnityDutyRate" class="common" style="width:98%" 
                                       onchange="getIndemnityDutyRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll(); changeChargeAmount(); setRealPay();setFlagDanger();" 
                                       value="100">
                              </td>
                              
<!--Э�̱���-->                <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoArrangeRate" class="common" style="width:98%" 
                                       onchange="getArrangeRate(this);calRealpayForDuBang(this);calRealpayForDuBangAll();calLoss();setFlagDanger();" 
                                       value="0">
                              </td>
                              
<!--����������-->               <td class="inputsubsub" style="width:6%" align="center">
                                <input name="prpLlossDtoDeductible" type="hidden" value=" ">
                                <input name="prpLlossDtoDutyDeductibleRate"  class='common' style="width:98%" 
                                       onchange=" changeChargeAmount();calRealpayForDuBang(this);setFlagDanger();" 
                                       onblur="return checkLossDeductibleRate(this);"
                                       value="<%= new DecimalFormat("##0.00").format(0) %>">
                              </td>
                              
<!--����������-->               <td class="inputsubsub" style="width:6%" align="center">
                                <input name="prpLlossDtoDeductibleRate" class='common'  style="width:98%" 
                                       onchange=" changeChargeAmount();calRealpayForDuBang(this);setFlagDanger();" 
                                       onblur="return checkLossDeductibleRate(this);"
                                       value="<%= new DecimalFormat("##0.00").format(0) %>">
                                <input type="hidden" name= "PrpLlossDtoMainKindDuctibleRate">
                                <input type="hidden" name="prpLlossDtoDriverDeductibleRate" 
                                       value="<%= new DecimalFormat("##0.00").format(0) %>">
                              </td>
                                                
                              <!-- �⳥���  -->            
                              <td class="inputsubsub" style="width:7%" align="center">
                                <input name="prpLlossDtoSumRealPay" class='readonly' style="width:98%" readonly 
                                       onchange="calFund();setFlagDanger();" value="<%= new DecimalFormat("##0.00").format(0) %>">
                                <input type="hidden" name="prpLlossDtoFamilyNo" value=" ">
                                <input type="hidden" name="prpLlossDtoItemKindNo" value="<%= prpCitemKindDto.getItemKindNo() %>">
                                <input type='hidden' name='prpLlossDtoFamilyName' value="">
                                <input type='hidden' name='prpLlossDtoItemCode' value="">
                                <input type='hidden' name='prpLlossDtoItemAddress' value="">
                                <input type="hidden" name="prpLlossDtoCurrency2" value="CNY">
                                <input type="hidden" name="prpLlossDtoCurrency2Name2" value="�����">
                                <input type='hidden' name='prpLlossDtoBuyDate'  value="2004/12/12">
                                <input type='hidden' name='prpLlossDtoDepreRate' value="">
                                <input type='hidden' name='prpLlossDtoCurrency' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency1' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency3' value="CNY">
                                <input type='hidden' name='prpLlossDtoCurrency4' value="CNY">
                                <input type='hidden' name='prpLlossDtoFlag' value="">
                                <input type='hidden' name='prpLlossFlag' value="">
                                <input type='hidden' name='prpLlossDtoUnit' value="">
                                <input type="hidden" name="prpLlossDtoAmount" value="">
                                <input type="hidden" name="prpLlossDtoItemValue" value="">
                                <input type="hidden" name="prpLlossDtoUnitPrice" value="">
                                <input type="hidden" name="prpLlossDtoLossQuantity" value="">
                                <input type="hidden" name="button_Loss_Refresh">
                              </td>
                              
                              <td class="inputsubsub" style='width:3%'>
                              <div align="center">
                                <input type=button name="buttonCompensateLossDelete"    class="smallbutton" 
                                       onclick="deleteRowTableL(this,'CompensateLoss',1,1);setFlagDanger();" value="-" readonly style="cursor: hand">
                              </div>
                              </td>
                            </tr>
<%
} //if equals()
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
    <td class="title"  style="width:12%"><b>�������Ϣ��</b></td>
    <logic:equal name="prpLcompensateDto" property="riskCode" value="0506">
        <td class="title"  style="width:25%">������ʧ��(A)�����:
    </logic:equal>
    <logic:notEqual name="prpLcompensateDto" property="riskCode" value="0506">
        <td class="title"  style="width:25%">�����:
    </logic:notEqual>
      <input type="text" style="width:20%" class="common" name="prpLDeductible" 
             value="<bean:write name='prpLdeductibleDto' property='deductible' />"  
             onchange="calFund();setFlagDanger();">
    </td>
    <td class="title"  style="width:63%"><!-- �������������:--> 
      <input type="hidden" style="width:60%" class="readonly" name='lastRealPay' value="">
    </td>
  </tr>
 </logic:present>
  <logic:notPresent name="prpLdeductibleDto">
    <tr>
    <td class="title"  style="width:12%"><b>�������Ϣ��</b></td>
    <logic:equal name="prpLcompensateDto" property="riskCode" value="0506">
        <td class="title"  style="width:25%">������ʧ��(A)�����:
    </logic:equal>
    <logic:notEqual name="prpLcompensateDto" property="riskCode" value="0506">
        <td class="title"  style="width:25%">�����:
    </logic:notEqual>
      <input type="text" style="width:20%" class="common" name="prpLDeductible" 
             value="0"  
             onchange="calFund();setFlagDanger();">
    </td>
    <td class="title"  style="width:63%"><!-- �������������:--> 
      <input type="hidden" style="width:60%" class="readonly" name='lastRealPay' value="">
    </td>
  </tr>
  </logic:notPresent> 

</table>




