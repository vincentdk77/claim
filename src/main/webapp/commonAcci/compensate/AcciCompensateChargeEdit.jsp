<%--
****************************************************************************
* DESC       �������������Ϣҳ��
* AUTHOR     ��liubvo
* CREATEDATE �� 2004-05-19
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%
	String strRecaseFlag = (String)request.getAttribute("recaseFlag");
%>
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
      
      function  checkChargeCode(field){
        var serialNo =0;
	    //��λ
       for ( var i=0 ;i< fm.all(field.name).length ;i++){
        if ( fm.all(field.name)[i] == field )
        {
        	serialNo=i ;
        	break ;
        }
       }
       var chargeCode = fm.prpLchargeChargeCode[serialNo].value; //�������
       if(chargeCode=='14'){
         fm.prpLchargeCheckDeptName[serialNo].style.display="";
       }else{
         fm.prpLchargeCheckDeptName[serialNo].style.display="none";
         fm.prpLchargeCheckDeptCode[serialNo].value="";
         fm.prpLchargeCheckDeptName[serialNo].value="";
       }
      }
    
        /**
         * ����setPrpLchargeSerialNo
         */
        function setPrpLchargeSerialNo(){
            var count=getElementCount("prpLchargeSerialNo");
            for(var i=0;i<count;i++)
            {
                if(count!=1){
                    fm.prpLchargeSerialNo[i].value=i;
                }
            }
        }
         //ʹ��xmlhttp����ҳ�棬����ȡxml����
		function getResponseXml(strURL)
		{
		  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		  objXmlHttp.Open("POST",strURL,false);
		  objXmlHttp.setRequestHeader("Content-type","text/xml");
		  objXmlHttp.Send("");
		  if(objXmlHttp.status==200)
		  {    
		    return objXmlHttp.responseXML;
		  }
		  else if(objXmlHttp.status==404)
		  {
		    alert("�Ҳ���ҳ�棺"+ strURL);
		    return "";
		  }
		  else
		  {
		    alert("����"+ strURL +"��������ţ�"+objXmlHttp.status);
		    return "";
		  }
		}
        function setPrpLpreChargeAmount(field){
        	var serialNo =0;
	        for ( var i=0 ;i< fm.all(field.name).length ;i++){
	          if ( fm.all(field.name)[i] == field )
	          {
	        	  serialNo=i ;
	        	  break ;
	          }
	        }
        	var kindCode = fm.prpLchargeKindCode[serialNo].value;
        	var chargeCode = fm.prpLchargeChargeCode[serialNo].value;
        	var preClaimNo = fm.preClaimNo.value;
        	var strRecaseFlag = fm.strRecaseFlag.value;
        	var vURL = "/claim/common/prepay/queryPreCharge.jsp?kindCode="+kindCode+"&chargeCode="+chargeCode+"&preClaimNo="+preClaimNo+"&strRecaseFlag="+strRecaseFlag;;
        	var strXml = getResponseXml(vURL);
        	var sumPreChargeAmount     = (strXml.documentElement).getElementsByTagName('sumPreChargeAmount')[0].text;
        	fm.prpLpreChargeAmount[serialNo].value=sumPreChargeAmount;
        	
        }
    </script>   
    
   <table class="common" align="center" width="100%" >
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td  colspan="5" align="left">
      <input type="hidden" name="preClaimNo" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">
        <input type="hidden" name="strRecaseFlag" value="<%=strRecaseFlag %>">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge)">������<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
              <td class="input" style="width:4%">
                <input type='text'  description="������" name='prpLlossDtoItemKindNoForCharge' readonly="readonly" class="readonly">  
              </td>
                <td class="input" style="width:10%"> 
                  <input type="hidden"  name="prpLchargeFlag">
                  <input type="hidden"  name="prpLchargeSerialNo" description="���">
                  <input name="prpLchargeKindCode" class="codecode" 
                    ondblclick="code_CodeSelect(this, 'PolicyKindCodeVirturlItem','1,-3','code','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCodeVirturlItem','1,-3','code','none','post');"
                    onchange="setFlagDanger();setPrpLpreChargeAmount(this);">
                </td> 
               	 
                <td class="input" style="width:10%">
                  <input name="prpLchargeKindName" class="codename" 
			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeVirturlItem','-1,-4','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeVirturlItem','-1,-4','always','none','post');"
			             onchange="setFlagDanger();setPrpLpreChargeAmount(this);">     
                </td> 
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeCode" class="codecode"
                    ondblclick="code_CodeSelect(this, 'ChargeCode');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode');"
                    onblur="checkChargeCode(this);"
                    onchange="setPrpLpreChargeAmount(this);">  
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeName" class="codename" 
			             ondblclick="code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
			             onblur="checkChargeCode(this);"
			             onchange="setPrpLpreChargeAmount(this);"> 
                </td>  
                <td class="input" style="width:10%">
			      <input type="hidden" class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="���嵥λ" value=""
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                   >
                 <input type=text class="codecode" name="prpLchargeCheckDeptName"  title="���嵥λ" style="display:none;width:100%" maxLength="50" description="�鿱����λ" value=""
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    >
                </td>
                <td class="input" style="width:10%">  
                  <input type="text" style="width:30%" name="prpLchargeCurrency" class="codecode" value="<bean:write name='prpLcompensateDto' property='currency' />"
                     ondblclick="code_CodeSelect(this, 'Currency');"
                     onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type="text"  style="width:60%" name="prpLchargeCurrencyName" class="codecode" value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
                     <input type="hidden" name="prpLchargePayObjectType" value="A">
                     <input type="hidden" name="prpLchargePayObjectCode" value="2">
                     <input type="hidden" name="prpLchargePayObjectName" value="�ͻ���������11">     
                </td>
                <td class="input" style="width:10%"> 
                  <input name="prpLchargeChargeAmount" class="input" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" style="width:10%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%" >
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeSumRealPay" class="input" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" align="center">
                <div>
                  <input type=button name="buttonChargeDelete"  onclick="deleteRow(this,'Charge'),calFund();setFlagDanger();" value="-" style="cursor: hand">
                  <input type="hidden" name="prpLchargeFlag">
                </div>
                </td>
              </tr>
            </tbody>
          </table> 
        </span>
        
        
        <span  id="spanCharge" style="display:none" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class="common" style="width:100%" id="Charge" >
          <thead>
            <tr>
                <td class="centertitle" style="width:4%">������</td>
                <td class="centertitle" style="width:10%">�ձ����</td>
                <td class="centertitle" style="width:10%">�ձ�����</td>
                <td class="centertitle" style="width:10%">���ô���</td>
                <td class="centertitle" style="width:10%">��������</td>
                <td class="centertitle" style="width:10%">���鿱����</td>
                <td class="centertitle" style="width:10%">�ұ�</td>
                <td class="centertitle" style="width:10%">���ý��</td>
                <td class="centertitle" style="width:10%">Ԥ������</td>
                <td class="centertitle" style="width:10%">���������</td>
              	<td class="title">&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=10 style="width:96%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+" onclick="insertRow('Charge');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand">
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
               <td class="input" style="width:4%">
                  <input type='text'  description="������" name='prpLlossDtoItemKindNoForCharge' readonly="readonly" class="readonly" value="<bean:write name='chargedtox' property='itemkindno'/>">  
               </td>
                <td class="input" style="width:10%">
                  <input type="hidden"  name="prpLchargeFlag" value="<bean:write name='chargedtox' property='flag'/>">
                  <input type="hidden"  name="prpLchargeSerialNo" description="���" value="<bean:write name='chargedtox' property='serialNo'/>">
                  <input name="prpLchargeKindCode" class="codecode" value="<bean:write name='chargedtox' property='kindCode'/>"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCodeVirturlItem','1,-3','code','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCodeVirturlItem','1,-3','code','none','post');"
                    onchange="setFlagDanger();setPrpLpreChargeAmount(this);">
                </td> 
                <td class="input" style="width:10%">
                  <input name="prpLchargeKindName" class="codename" value="<bean:write name='chargedtox' property='kindName'/>"
			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeVirturlItem','-1,-4','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeVirturlItem','-1,-4','always','none','post');"
			             onchange="setFlagDanger();setPrpLpreChargeAmount(this);">     
                </td> 
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeCode" class="codecode" value="<bean:write name='chargedtox' property='chargeCode'/>"
                    ondblclick="code_CodeSelect(this, 'ChargeCode');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode');"
                    onblur="checkChargeCode(this);"
                    onchange="setPrpLpreChargeAmount(this);">  
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeChargeName" class="codename" value="<bean:write name='chargedtox' property='chargeName'/>"
			             ondblclick="code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
			             onkeyup= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
			             onblur="checkChargeCode(this);"
			             onchange="setPrpLpreChargeAmount(this);"> 
                </td> 
                <td class="input" style="width:10%">
			      <input type=hidden class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="���嵥λ" value="<bean:write name='chargedtox' property='checkDeptCode' filter='true' />"
                    ondblclick="code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onkeyup= "code_CodeSelect(this, 'ComCodeByProvinceCode');"
                    onblur="code_CodeChange(this, 'ComCodeByProvinceCode','1','code','post','clear');"
                     onchange="setNewComCode(this);"
                   >
                <logic:equal name='chargedtox' property="chargeCode" value="14">
                 <input type=text class="codecode" name="prpLchargeCheckDeptName"  title="���嵥λ" style="width:100%" maxLength="50" description="�鿱����λ" value="<bean:write name='chargedtox' property='checkDeptName' filter='true' />"
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    >
                </logic:equal>
                <logic:notEqual name='chargedtox' property="chargeCode" value="14">
                 <input type=hidden class="codecode" name="prpLchargeCheckDeptName"  title="���嵥λ" style="width:100%" maxLength="50" description="�鿱����λ" value="<bean:write name='chargedtox' property='checkDeptName' filter='true' />"
                    ondblclick = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    onkeypress = "window.event.keyCode = 0;"
                    onblur="checkLength1(this);"
                    onkeyup    = "open_CodeSelect(this,'ComCode',fm.provinceCode.value,'�鿱����λ');"
                    >
                </logic:notEqual>
                </td> 
                <td class="input" style="width:10%">  
                  <input style="width:30%" type="text" name="prpLchargeCurrency" class="codecode" value="<bean:write name='chargedtox' property='currency'/>"
                     ondblclick="code_CodeSelect(this, 'Currency');"
                     onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input style="width:60%" type="text" name="prpLchargeCurrencyName" class="codecode" value="<bean:write name='chargedtox' property='currencyName'/>"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
                     <input type="hidden" name="prpLchargePayObjectType" value="A">
                     <input type="hidden" name="prpLchargePayObjectCode" value="2">
                     <input type="hidden" name="prpLchargePayObjectName" value="�ͻ���������11">        
                </td>
                <td class="input" style="width:10%"> 
                  <input name="prpLchargeChargeAmount" class="input" value="<bean:write name='chargedtox' property='chargeAmount'/>" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" style="width:10%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%" value="<bean:write name='chargedtox' property='preChargeAmount'/>">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeSumRealPay" class="input" value="<bean:write name='chargedtox' property='sumRealPay'/>" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" align="center">
                <div>
                  <input type=button name="buttonChargeDelete"  onclick="deleteRow(this,'Charge'),calFund();setFlagDanger();" value="-" style="cursor: hand">
                  <input type="hidden" name="prpLchargeFlag">
                </div>
                </td>
              </tr>
 <%indexCharge++;%>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td>
    </tr>
  </table>



  
  



