<%--
****************************************************************************
* DESC       �������������Ϣҳ��
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
   <!--������ʾ��¼����������������ʾ��-->
   
    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����

        /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertCharge()
      {
        setPrpLchargeSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteCharge(field)
      {
        
        setPrpLchargeSerialNo();
      }
    
        /**
         * ����setPrpLchargeSerialNo
         */
        function setPrpLchargeSerialNo(){
            var count=getElementCount("prpLchargeSerialNo");
            for(var i=0;i<count;i++)
            {
                //alert("����ʲôʱ������?count="+count+"  i="+i); 
                if(count!=1){
                    fm.prpLchargeSerialNo[i].value=i;
                }
            }
        }
    </script>   
    
   <table class="common" align="center" width="100%" >
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge)">������<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
				
                  <input type="hidden" name="prpLchargeFlag">
                  <input type="hidden" name="prpLchargeSerialNo" description="���">
                  <input type="hidden" name="prpLchargeKindCode" class="codecode" style="width:60px"
                  	value="<bean:write name='defaultKindCode'/>"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode');"
                    onchange="setFlagDanger();">
                  
                  <input type="hidden" name="prpLchargeKindName" class="codename" style="width:120px"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			            onchange="setFlagDanger();">     
			   
                <td class="input" align="center" style="width:8%">
                  <input name="prpLchargeChargeCode" class="codecode" style="width:95%"
                    ondblclick="code_CodeSelect(this, 'ChargeCode');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode');">  
                </td>
                <td class="input" align="center" style="width:15%">
                  <input name="prpLchargeChargeName" class="codename" style="width:95%"
			             ondblclick="code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"> 
                </td>
                <td class="input" style="width:8%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" selected>�ⲿ</option>
                    <option value="A">�ڲ�</option>
                  </select>
                </td>
                <td class="input">
                  <input name="prpLchargePayObjectCode" type="hidden" class="readonly" readonly  style="width:100%" value="">
                  <input name="prpLchargePayObjectName" class="common" style="width:100%" value="" maxlength="50">
                </td>  
                <td class="input" style="width:15%">
                  <input type="text" name="prpLchargeCurrency" class="codecode" style="width:17%" value="<bean:write name='prpLcompensateDto' property='currency' />"
                     ondblclick="code_CodeSelect(this, 'Currency');"
                     onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type="text" name="prpLchargeCurrencyName" class="codecode" style="width:65%" value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">       
                </td>
                <td class="input" style="width:15%" align="center"> 
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" style="width:15%" align="center">
                  <input name="prpLchargeSumRealPay" class="input" style="width:100%" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" align="center"  style="width:4%">
                <div>
                  <input type=button name="buttonChargeDelete" class="smallbutton" onclick="deleteRow(this,'Charge'),calFund();setFlagDanger();" value="-" style="cursor: hand">
                  <input type="hidden" name="prpLchargeFlag">
                </div>
                </td>
              </tr>
            </tbody>
          </table> 
        </span>
        
        
        <span  id="spanCharge" style="display:none" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="Charge" border="0">
          <thead>
            <tr>
            	<!-- 
                <td class="centertitle" style="width:10%">�ձ����</td>
                <td class="centertitle" style="width:20%">�ձ�����</td>
                -->
                
                <td class="centertitle" style="width:8%">���ô���</td>
                <td class="centertitle" style="width:15%">��������</td>
                <td class="centertitle"  style="width:8%">֧�����</td>
                <!-- td class="centertitle"  style="width:14%">֧���������</td-->
                <td class="centertitle"  style="">��������</td>
                <td class="centertitle" style="width:15%">�ұ�</td>
                <td class="centertitle" style="width:15%">���ý��</td>
                <td class="centertitle" style="width:15%">���������</td>
              <td class="centertitle" style="width:4%">&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan="7" style="width:96%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
	                 <div align="center">
	                   <input type="button" value="+" onclick="insertRow('Charge');setFlagDanger();" class="smallbutton" name="buttonDriverInsert" style="cursor: hand">
	                 </div>
                 </td>
              </tr>
           </tfoot> 
          </tfoot>
          <tbody> 
 <% int indexCharge=0;%>
<logic:notEmpty  name="prpLchargeDto"  property="prpLchargeList"> 
<logic:iterate id="chargedtox" name="prpLchargeDto" property="prpLchargeList">
              <tr> 
                  <input type="hidden"  name="prpLchargeFlag" value="<bean:write name='chargedtox' property='flag'/>">
                  <input type="hidden"  name="prpLchargeSerialNo" description="���" value="<bean:write name='chargedtox' property='serialNo'/>">
                  <input type="hidden"  name="prpLchargeKindCode" class="codecode" style="width:60px" value="<bean:write name='chargedtox' property='kindCode'/>"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode');"
                    onchange="setFlagDanger();">
				            
                  <input type="hidden"  name="prpLchargeKindName" class="codename" style="width:120px" value="<bean:write name='chargedtox' property='kindName'/>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
			             onchange="setFlagDanger();">     
				                 
                <td class="input" align="center" style="width:8%">
                  <input name="prpLchargeChargeCode" class="codecode" style="width:95%" value="<bean:write name='chargedtox' property='chargeCode'/>"
                    ondblclick="code_CodeSelect(this, 'ChargeCode');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode');">  
                </td>
                <td class="input" align="center" style="width:15%">
                  <input name="prpLchargeChargeName" class="codename" style="width:95%" value="<bean:write name='chargedtox' property='chargeName'/>"
			             ondblclick="code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"> 
                </td>  
                
                 <td class="input" style="width:8%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" <logic:equal name='chargedtox' property='payObjectType' value="B">selected</logic:equal>>�ⲿ</option>
                    <option value="A" <logic:equal name='chargedtox' property='payObjectType' value="A">selected</logic:equal>>�ڲ�</option>
                  </select>
                </td>
                <td class="input">
                  <input name="prpLchargePayObjectCode" type="hidden" class="readonly" readonly style="width:100%"
                    value="<bean:write name='chargedtox' property='payObjectCode'/>">
                  <input name="prpLchargePayObjectName" class="common" style="width:100%" maxlength="50"
                    value="<bean:write name='chargedtox' property='payObjectName'/>">
                </td>
                <td class="input" align="left" style="width:15%">  
                  <input type="text" name="prpLchargeCurrency" class="codecode" style="width:17%" value="<bean:write name='chargedtox' property='currency'/>"
                     ondblclick="code_CodeSelect(this, 'Currency');"
                     onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type="text" name="prpLchargeCurrencyName" class="codecode" style="width:65%" value="<bean:write name='chargedtox' property='currencyName'/>"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">       
                </td>
                <td class="input" style="width:15%"> 
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" value="<bean:write name='chargedtox' property='chargeAmount'/>" onchange="calFund()";>
                </td>
                <td class="input" style="width:15%">
                  <input name="prpLchargeSumRealPay" class="input" style="width:100%" value="<bean:write name='chargedtox' property='sumRealPay'/>" onchange="calFund()";>
                </td>
                <td class="input" align="center" style="width:4%">
                <div>
                  <input type=button name="buttonChargeDelete"  class="smallbutton" onclick="deleteRow(this,'Charge'),calFund();setFlagDanger();" value="-" style="cursor: hand">
                  <input type="hidden" name="prpLchargeFlag">
                </div>
                </td>
              </tr>
 <%    indexCharge++;%>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td>
    </tr>
  </table>



  
  



