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
<%@page import="java.util.*"%>
<script language='javascript'>
    /*
      ɾ������Person֮��Ĵ�����ѡ������
    */
    function afterDeletePerson(field)
    {
      if(getElementCount("calRealpay1ForDuBang")>1){
        calRealpay1ForDuBang(fm.prpLpersonLossSumLoss[0]);
        calRealpay1ForDuBang(fm.prpLpersonLossSumLoss);
      }
      calFund();
      calLoss();
    }
    
</script>
   <!--������ʾ��¼����������������ʾ��-->
      <span style="display:none">
        <table class="common" style="display:none" id="PersonFeeLoss_Data" cellspacing="1" cellpadding="0">
  <%      
         String  personCount  = (String)request.getAttribute("personCount");
  %> 
          <tbody>
            <tr>
              <td class="inputsubsub">
                <input type="hidden" name="personLossSerialNo" style="width:20px">
                <input name="prpLpersonLossLiabDetailCode" class="codecode" style="width:25px" title="���ô���"
                   ondblclick= " code_CodeSelect(this,'PersonFeeType');"
                   onchange="code_CodeChange(this, 'PersonFeeType');"
                   onkeyup= " code_CodeSelect(this,'PersonFeeType');"
                   onblur="calculateFee(this);">
                <input name="prpLpersonLossLiabDetailName" class="codename" style="width:65px" title="��������"
                  ondblclick= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                  onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
                  onkeyup= " code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                   onblur="calculateFee(this);">
              </td>

<!--              <td class="inputsubsub"> -->
                <input type="hidden" name="prpLpersonLossUnitAmount" class="common" style="width:65px" onchange="calSumLoss(this);">
<!--              </td> -->
<!--              <td class="inputsubsub"> -->
                <input type="hidden" name="prpLpersonLossLossQuantity" class="common" style="width:65px" onchange="calSumLoss(this);">
<!--              </td> -->
                <input type="hidden" name="prpLpersonLossHospitalDays" onchange="calSumLoss(this);">

              <td class="inputsubsub">
                <input name="prpLpersonLossSumLoss" class="common" style="width:65px" onchange="calRealpay1ForDuBang(this);calLoss();">
              </td>
              <td class="inputsubsub">
                <input name="prpLpersonLossClaimRate" class="common" style="width:65px" onchange="calRealpay1ForDuBang(this);">
              </td>
              <td class="inputsubsub">
                <input type="hidden" name="personCount" value="<%=personCount%>">
                <input name="prpLpersonLossSumRealPay" class="readonly" readonly style="width:65px"  onchange="return changePersonLossRealpay(this);">
                <input type="hidden" name="prpLpersonLossFamilyNo">
                <input type="hidden" name="prpLpersonLossIdentifyNumber">
                <input type="hidden" name="prpLpersonLossLiabCode">
                <input type="hidden" name="prpLpersonLossLiabName">
                <input type="hidden" name="prpLpersonLossJobCode">
                <input type="hidden" name="prpLpersonLossJobName">
                <input type="hidden" name="prpLpersonLossItemAddress">
                <input type="hidden" name="prpLpersonLossUnit">
                <input type="hidden" name="prpLpersonLossCurrency" value="CNY">
                <input type="hidden" name="prpLpersonLossAmount">
                <input type="hidden" name="prpLpersonLossCurrency1" value="CNY">
                <input type="hidden" name="prpLpersonLossItemValue">
                <input type="hidden" name="prpLpersonLossCurrency2" value="CNY">
                <input type="hidden" name="prpLpersonLossSumRest">
                <input type="hidden" name="prpLpersonLossDeductible">
                <input type="hidden" name="prpLpersonLossCurrency4" value="CNY">
                <input type="hidden" name="prpLpersonLossFlag">
              </td>
              <td class="inputsubsub">
                <div align="center">
                  <input type=button name="buttonPersonFeeLossDelete"  class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1);calFund();" value="-" readonly style="cursor: hand">
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </span>

      <table class="common" align="center">
      <!--��ʾ��ʾ���е�-->
        <tr >
          <td class="common" colspan="4">
            <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
                 name="PersonImg" onclick="showPage(this,spanPerson);changeCompensateFlag('1');">�⸶��Ա��Ϣ<br>
            <span style="display:none">
              <table class="common" style="display:none" id="Person_Data" cellspacing="1" cellpadding="0">
                <tbody>
                  <tr>
                    <td class="input" style="width:8%">
                       <div align="center">
                    <input type="input" name="prpLpersonLossKindCode" class="codecode" style="width:60px"
                          ondblclick= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
                          onchange="code_CodeChange(this,'PolicyKindCode','1,2');"
                          onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
                          onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);"
                       >
                    <input type="input" name="prpLpersonLossKindName" class="codename" style="width:60px"
    			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
    			             onchange="code_CodeChange(this, 'PolicyKindCode','-1,2','name','none','post');"
    			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
                      onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);"
                      >
                    <input type="hidden" name="prpLpersonLossItemKindNo">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                        <input type="hidden" name="prpLpersonLossSerialNo">
                       </div>
                   </td>
                   <td class="subformtitle" style="width:88%">
                   <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                      <tbody>
                          <tr>
                            <input type="hidden" name="prpLpersonLossPersonNo">
                            <td class="title"  style="width:15%">��Ա������</td>
                            <td class="input" style="width:35%">
                              <input class='common' style="width:110" name="prpLpersonLossPersonName"
                              maxlength=20 description="��Ա����">
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>
                            <input type="hidden" name="prpLpersonLossAmountTmp">
                            <td class="title" style="width:15%">�Ա�</td>
                            <td class="input" style="width:35%">
                              <select name="prpLpersonLossSex" class='common' style="width:110">
                                 <option value="1">��</option>
                                 <option value="2">Ů</option>
                              </select>
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>

                          </tr>
                          <tr>
                            <td class="title">���䣺</td>
                            <td class="input">
                              <input class='common' name="prpLpersonLossAge"  style="width:110"
                                maxlength="3" description="����" onchange="checkInteger(this,1,120)">
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>
                            <td class="title">�ұ�</td>
                            <td class="input">
                              <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                              <input class='readonly' readonly name="prpLpersonLossCurrencyName3" value="�����">
                            </td>
                          </tr>

                          <tr>
                            <td class='title'>���α�����</td>
                            <td class='input'>
                              <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:110px"  onChange="checkKindCode(this);calRealpay2ForSunny(this);">%
                            </td>
			                <td class='title'>Э���⳥������</td>
			                <td class='input'>
			                    <input class='common' name="prpLpersonLossArrangeRate" style="width:110px"  onChange="checkKindCode(this);calRealpay2ForSunny(this);" value="100">%
			                </td>                                
                          </tr>

                          <tr>
                            <td class='title'>�¹����������ʣ�</td>
                            <td class='input'>
                              <input class='common' style='width:110px' name="prpLpersonLossDutyDeductibleRate"  onChange="checkKindCode(this);calRealpay2ForSunny(this);">%
                            </td>

                            <td class='title'>���������ʣ�</td>
                            <td class='input'>
                              <input class='common' style='width:110px' name="prpLpersonLossDeductibleRate"  onChange="checkKindCode(this);calRealpay2ForSunny(this);">%
                              <input type="hidden" name="prpLpersonLossDriverDeductibleRate">
                              <input type="hidden" name="prpLpersonLossMainKindDeductibleRate">
                            </td>

                          </tr>
                          <tr>
                          	<%--
                            <td class='title' style="display:none">��ʻԱ�����ʣ�</td>
                            <td class='input' style="display:none">
                              <input class='readonly'  type="hidden" style="display:none" readonly name="prpLpersonLossDriverDeductibleRate">
                            </td>
                            --%>
                            <td class='title'>���ƺ��룺</td>
                            <td class="input">
                               <%
              		                Collection collection = (Collection)request.getAttribute("licenseNoList");
              		                Iterator iteratorLicenseNo1 = collection.iterator();
              		              %>
                                <select name="prpLpersonLossFamilyName" style="width:110px" onchange="calRealpay2ForSunny(this);">
                                <%
                                  while (iteratorLicenseNo1.hasNext()){
                                  PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)iteratorLicenseNo1.next();
                                %>
                                  <option value="<%= prpLthirdPartyDto.getLicenseNo() %>"><%= prpLthirdPartyDto.getLicenseNo() %></option>
                                 <%
                                   }
                                 %>
                                </select>
                              <img src="/claim/images/bgMarkMustInput.jpg">
                            </td>                            
                            <td class='title'>�⸶�ϼƣ�</td>
                            <td class='input'>
                              <input class='readonly' style='width:110px' readonly name="prpLpersonLossSumRealPay1">
                            </td>
                          </tr>

                          <tr>
                            <td colspan="4">
                              <span  id="spanPersonFeeLoss" >
                              <%-- ��������չ���� --%>
                              <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                                <thead>
                                  <tr>
                                    <td class="subformtitle" colspan="9">
                                      ������Ϣ <font color="#FF0000">*</font>
                                    </td>
                                  </tr>
                                  <tr>
                          	  		  <td class="centertitle">����</td>
                          	  		  <td style="display:none"   class="centertitle">����</td>
                      	  		      <td style="display:none"   class="centertitle">����</td>
                          	  		  <td class="centertitle">������</td>
                          	  		  <td class="centertitle">�⳥����%</td>
                          	  		  <td class="centertitle">�⸶���</td>
                                    <td class="centertitle" style="width:3%">  </td>
                                  </tr>
                                </thead>
                                <tfoot>
                                  <tr>
                                    <td class="titlesubsub" colspan="6" style="width:97%"></td>
                                    <td class="title" align="right" style="width:4%">
                                      <div align="center">
                                        <input type="button" value="+"	 class="smallbutton"   onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
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

                 </td>
              <td class="input" style="width:4%">
                <div align="center">
                  <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                </div>
              </td>
           </tr>
         </tbody>
       </table>
     </span>

     <span  id="spanPerson" style="display:none">
       <%-- ��������չ���� --%>
       <table id="person" class="common" align="center" cellspacing="1" cellpadding="0">
         <thead>
           <tr>
             <td class="centertitle" style="width:4%">�ձ�</td>
             <td class="centertitle" style="width:96%" colspan=2 >����</td>
           </tr>
         </thead>
         <tfoot>
           <tr>
             <td class="title" colspan=2 style="width:96%">(��"+"�ż������⸶��Ա��Ϣ����"-"�ż�ɾ���⸶��Ա��Ϣ)</td>
             <td class="title" align="right" style="width:4%">
               <div align="center">
                 <input type="button" value="+" class="smallbutton" onclick="insertRow('person')" name="buttonPersonInsert" style="cursor: hand">
               </div>
             </td>
           </tr>
         </tfoot>
         <tbody>

<script language="javascript">    
var damageKind = new Array();
<%
   String damagekindCode = "";
   PrpCitemKindDto prpCitemKindDto;
   ArrayList damageKindList = (ArrayList)request.getAttribute("damageKindList");  
   for(int m=0;m<damageKindList.size();m++)
   {
       prpCitemKindDto = (PrpCitemKindDto)damageKindList.get(m);
       damagekindCode = prpCitemKindDto.getKindCode();
%>  
       damageKind[<%=m%>]   ='<%=damagekindCode%>';
<%
   }
%>       
</script>      




<%

    int personNo = 0;
    String kindCode = "";
    int personSerialNo = 1;
    PrpLpersonLossDto prpLpersonLossDto = (PrpLpersonLossDto)request.getAttribute("prpLpersonLossDto");
    if(prpLpersonLossDto.getPrpLpersonLossList()!=null){
      Iterator iterator = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator.hasNext()){
        PrpLpersonLossDto prpLpersonLossDto1 =  (PrpLpersonLossDto)iterator.next();
          if(!(prpLpersonLossDto1.getPersonNo() == personNo)||!prpLpersonLossDto1.getKindCode().equals(kindCode)){
	      if (prpLpersonLossDto1.getKindCode().trim().equals("B")) continue;
%>

           <tr>
          <td class="input" style="width:8%">
             <div align="center">
              <input type="input" name="prpLpersonLossKindCode" class="codecode" style="width:60px" value="<%= prpLpersonLossDto1.getKindCode() %>"
                    ondblclick= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
                    onchange="code_CodeChange(this,'PolicyKindCode','1,2');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
                    onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);"
                 >
              <input type="input" name="prpLpersonLossKindName" class="codename" style="width:60px" value="<%= prpLpersonLossDto1.getKindName() %>"
		             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
		             onchange="code_CodeChange(this, 'PolicyKindCode','-1,1','name','none','post');"
		             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','name','selectnotb','post');"
                onblur="getDeductibleRate(this,'PersonLoss');checkKindCode(this);"
                >
                <input type="hidden" name="prpLpersonLossItemKindNo" value="<%= prpLpersonLossDto1.getItemKindNo() %>">
              <img src="/claim/images/bgMarkMustInput.jpg">
               <input type="hidden" name="prpLpersonLossSerialNo" value="<%= personSerialNo %>">
             </div>
         </td>
         <td class="subformtitle" style="width:88%">
         <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
            <tbody>
                <tr>
                  <input type="hidden" name="prpLpersonLossPersonNo" value="<%= prpLpersonLossDto1.getPersonNo() %>">
                  <td class="title"  style="width:15%">��Ա������</td>
                  <td class="input" style="width:35%">
                    <input class='common' style="width:110" name="prpLpersonLossPersonName" value="<%= prpLpersonLossDto1.getPersonName() %>">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <input type="hidden" name="prpLpersonLossAmountTmp">
                  <td class="title" style="width:15%">�Ա�</td>
                  <td class="input" style="width:35%">
                    <select name="prpLpersonLossSex" class='common' style="width:110">
                       <option value="1" <%= prpLpersonLossDto1.getSex().trim().equals("1") ? "selected":"" %>>��</option>
                       <option value="2" <%= prpLpersonLossDto1.getSex().trim().equals("2") ? "selected":"" %>>Ů</option>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                </tr>
                <tr>
                  <td class="title">���䣺</td>
                  <td class="input">
                    <input class='common' name="prpLpersonLossAge"  style="width:110"  value="<%= prpLpersonLossDto1.getAge() %>"
                      maxlength="3" description="����" onchange="checkInteger(this,1,120)">
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class="title">�ұ�</td>
                  <td class="input">
                    <input type="hidden" name="prpLpersonLossCurrency3"  value="CNY">
                    <input class='readonly' readonly name="prpLpersonLossCurrencyName3" value="�����">
                  </td>
                </tr>

                <tr>
                  <td class='title'>���α�����</td>
                  <td class='input'>
                    <input class='common' name="prpLpersonLossIndemnityDutyRate" style="width:110px"  onChange="checkKindCode(this);calRealpay2ForSunny(this);" value="<%= prpLpersonLossDto1.getIndemnityDutyRate() %>">%
                  </td>
                  <td class='title'>Э���⳥������</td>
                  <td class='input'>
                    <input class='common' name="prpLpersonLossArrangeRate" style="width:110px"  onChange="checkKindCode(this);calRealpay2ForSunny(this);" value="<%= prpLpersonLossDto1.getArrangeRate() %>">%
                  </td>                  
                </tr>

                <tr>
                  <td class='title'>�¹����������ʣ�</td>
                      <td class='input'>
                         <input class='common' style='width:110px' name="prpLpersonLossDutyDeductibleRate"  onChange="checkKindCode(this);calRealpay2ForSunny(this);" value="<%= prpLpersonLossDto1.getDutyDeductibleRate() %>">
                  </td>
                  <td class='title'>���������ʣ�</td>
                  <td class='input'>
                    <input class='common' style='width:110px' name="prpLpersonLossDeductibleRate"  onChange="checkKindCode(this);calRealpay2ForSunny(this);" value="<%= prpLpersonLossDto1.getDeductibleRate() %>">%
                    <input type="hidden" name="prpLpersonLossDriverDeductibleRate">
                    <input type="hidden" name="prpLpersonLossMainKindDeductibleRate">
                  </td>
                 
                </tr>
                <tr>
                <%--
                 <td class='title' style="display:none">��ʻԱ�����ʣ�</td>
                 <td class='input' style="display:none">
                        <input class='readonly'  style="display:none" style='width:110px' readonly name="prpLpersonLossDriverDeductibleRate">%
                  </td>
                --%>
                 <td class='title'>���ƺ��룺</td>
                  <td class="input">
                   <%
  		                Iterator iteratorLicenseNo2 = collection.iterator();
  		              %>
                    <select name="prpLpersonLossFamilyName" style="width:110px"  onchange="calRealpay2ForSunny(this);">
                    <%
                      while (iteratorLicenseNo2.hasNext()){
                      PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)iteratorLicenseNo2.next();
                    %>
                      <option value="<%= prpLthirdPartyDto.getLicenseNo() %>" <%= ((prpLpersonLossDto1.getFamilyName().trim().equals(prpLthirdPartyDto.getLicenseNo().trim())) ? "selected" : "") %>><%= prpLthirdPartyDto.getLicenseNo() %></option>
                     <%
                       }
                     %>
                    </select>
                    <img src="/claim/images/bgMarkMustInput.jpg">
                  </td>
                  <td class='title'>�⸶�ϼƣ�</td>
                  <td class='input'>
                    <input class='readonly' style='width:110' readonly name="prpLpersonLossSumRealPay1" value="<%= prpLpersonLossDto1.getSumRealPay1() %>">
                  </td>
                </tr>

                <tr>
                        <td colspan="4">
                          <span  id="spanPersonFeeLoss" >
                          <%-- ��������չ���� --%>
                          <table id="PersonFeeLoss" name="PersonFeeLoss" class="common" align="center" cellspacing="1" cellpadding="0">
                            <thead>
                              <tr>
                                <td class="subformtitle" colspan="9">
                                  ������Ϣ <font color="#FF0000">*</font>
                                </td>
                              </tr>
                              <tr>
                      	  		  <td class="centertitle">����</td>
                      	  		  <td style="display:none"  class="centertitle">����</td>
                      	  		  <td style="display:none"  class="centertitle">����</td>
                      	  		  <td class="centertitle">������</td>
                      	  		  <td class="centertitle">�⳥����%</td>
                      	  		  <td class="centertitle">�⸶���</td>
                                <td class="centertitle" style="width:3%">  </td>
                              </tr>
                            </thead>
                            <tfoot>
                              <tr>
                                <td class="titlesubsub" colspan="6" style="width:97%"></td>
                                <td class="title" align="right" style="width:4%">
                                  <div align="center">
                                    <input type="button" value="+" class="smallbutton" onclick="insertRowTable('PersonFeeLoss','PersonFeeLoss_Data',this);" name="buttonPersonFeeLossInsert" readonly style="cursor: hand">
                                  </div>
                                </td>
                              </tr>
                            </tfoot>

                            <tbody>
 <%
System.out.println("------personNo-----"+personNo+"|"+kindCode);
System.out.println("------prpLpersonLossDto1.getPersonNo()-----"+prpLpersonLossDto1.getPersonNo()+"|"+prpLpersonLossDto1.getKindCode());
   Iterator iterator1 = prpLpersonLossDto.getPrpLpersonLossList().iterator();
      while(iterator1.hasNext()){
        PrpLpersonLossDto PrpLpersonLossDto2 =  (PrpLpersonLossDto)iterator1.next();
        if(PrpLpersonLossDto2.getPersonNo() == prpLpersonLossDto1.getPersonNo()&&PrpLpersonLossDto2.getKindCode().equals(prpLpersonLossDto1.getKindCode())){
	      if (PrpLpersonLossDto2.getKindCode().trim().equals("B")) continue;
%>
                              <tr>
                                  <td class="inputsubsub">
                                    <input type="hidden" name="personLossSerialNo" style="width:20px" value="<%= personSerialNo %>">
                                    <input name="prpLpersonLossLiabDetailCode" class="codecode" style="width:25px" title="���ô���"  value="<%= PrpLpersonLossDto2.getLiabDetailCode() %>"
                                       ondblclick= " code_CodeSelect(this,'PersonFeeType');"
                                       onchange="code_CodeChange(this,'PersonFeeType');"
                                       onkeyup= " code_CodeSelect(this,'PersonFeeType');"
                                       onblur="calculateFee(this);">
                                    <input name="prpLpersonLossLiabDetailName" class="codename" style="width:65px" title="��������"  value="<%= PrpLpersonLossDto2.getLiabDetailName() %>"
                                      ondblclick= "code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                                      onchange="code_CodeChange(this, 'PersonFeeType','-1','name','none','post');"
                                      onkeyup= " code_CodeSelect(this, 'PersonFeeType','-1','name','none','post');"
                                      onblur="calculateFee(this);">
                                  </td>

<!--                            <td class="inputsubsub"> -->
                                    <input type="hidden" name="prpLpersonLossUnitAmount" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getUnitAmount() %>" onchange="calSumLoss(this);">
<!--                                  </td>-->

<!--                                  <td class="inputsubsub"> -->
                                    <input type="hidden" name="prpLpersonLossLossQuantity" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getLossQuantity() %>" onchange="calSumLoss(this);">
<!--                                  </td> -->
                                    <input type="hidden" name="prpLpersonLossHospitalDays" value="<%= PrpLpersonLossDto2.getHospitalDays() %>" onchange="calSumLoss(this);">

                                  <td class="inputsubsub">
                                    <input name="prpLpersonLossSumLoss" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getSumLoss() %>"  onchange="calRealpay1ForDuBang(this);calLoss();">
                                  </td>
                                  <td class="inputsubsub">
                                    <input name="prpLpersonLossClaimRate" class="common" style="width:65px" value="<%= PrpLpersonLossDto2.getClaimRate() %>"  onchange="calRealpay1ForDuBang(this);">
                                  </td>
                                  <td class="inputsubsub">
                                    <input name="prpLpersonLossSumRealPay" class="readonly" readonly style="width:65px" value="<%= PrpLpersonLossDto2.getSumRealPay() %>" onchange="return changePersonLossRealpay(this);">
                                    <input type="hidden" name="prpLpersonLossFamilyNo" value="<%= PrpLpersonLossDto2.getFamilyNo() %>">
                                    <input type="hidden" name="prpLpersonLossIdentifyNumber" value="<%= PrpLpersonLossDto2.getIdentifyNumber() %>">
                                    <input type="hidden" name="prpLpersonLossLiabCode" value="<%= PrpLpersonLossDto2.getLiabCode() %>">
                                    <input type="hidden" name="prpLpersonLossLiabName" value="<%= PrpLpersonLossDto2.getLiabName() %>">
                                    <input type="hidden" name="prpLpersonLossJobCode" value="<%= PrpLpersonLossDto2.getJobCode() %>">
                                    <input type="hidden" name="prpLpersonLossJobName" value="<%= PrpLpersonLossDto2.getJobName() %>">
                                    <input type="hidden" name="prpLpersonLossItemAddress" value="<%= PrpLpersonLossDto2.getItemAddress() %>">
                                    <input type="hidden" name="prpLpersonLossUnit" value="<%= PrpLpersonLossDto2.getUnit() %>">
                                    <input type="hidden" name="prpLpersonLossCurrency" value="CNY">
                                    <input type="hidden" name="prpLpersonLossAmount" value="<%= PrpLpersonLossDto2.getAmount() %>">
                                    <input type="hidden" name="prpLpersonLossCurrency1" value="CNY">
                                    <input type="hidden" name="prpLpersonLossItemValue" value="<%= PrpLpersonLossDto2.getItemValue() %>">
                                    <input type="hidden" name="prpLpersonLossCurrency2" value="CNY">
                                    <input type="hidden" name="prpLpersonLossSumRest" value="<%= PrpLpersonLossDto2.getSumRest() %>">
                                    <input type="hidden" name="prpLpersonLossDeductible" value="<%= PrpLpersonLossDto2.getDeductible() %>">
                                    <input type="hidden" name="prpLpersonLossCurrency4" value="CNY">
                                    <input type="hidden" name="prpLpersonLossFlag" value="<%= PrpLpersonLossDto2.getFlag() %>">

                                  </td>
                                  <td class="inputsubsub">
                                    <div align="center">
                                      <input type=button name="buttonPersonFeeLossDelete" 	 class="smallbutton" onclick="deleteRowTable(this,'PersonFeeLoss',1,1);calFund();" value="-" readonly style="cursor: hand">
                                    </div>
                                  </td>
                                </tr>
<%
    }
  }
%>
                              </tbody>
                            </table>
                          </span>
                        </td>
                      </tr>

                    </tbody>
                  </table>
                </td>
                <td class="title" style="width:4%">
                  <div align="center">
                    <input type=button name="buttonPersonDelete"  class="smallbutton" onclick="deleteRow(this,'Person')" value="-" style="cursor: hand">
                  </div>
                </td>
             </tr>
<%
        kindCode = prpLpersonLossDto1.getKindCode();
        personNo =   prpLpersonLossDto1.getPersonNo();
        personSerialNo++;
        }
      }//while has next
    }
%>









           </tbody>
         </table>
       </span>
     </td>
   </tr>
  </table>



