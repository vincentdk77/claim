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
                //alert("����ʲôʱ������?count="+count+"  i="+i); 
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
        	var vURL = "/claim/common/prepay/queryPreCharge.jsp?kindCode="+kindCode+"&chargeCode="+chargeCode+"&preClaimNo="+preClaimNo+"&strRecaseFlag="+strRecaseFlag;
        	var strXml = getResponseXml(vURL);
        	var sumPreChargeAmount     = (strXml.documentElement).getElementsByTagName('sumPreChargeAmount')[0].text;
        	fm.prpLpreChargeAmount[serialNo].value=sumPreChargeAmount;
        	
        }
    </script>   
    
   <table class="common" align="center" width="100%" >
    <!--��ʾ��ʾ���е�-->
    <tr>
      <td class="subformtitle" colspan="5" style="text-align:left">
        <input type="hidden" name="preClaimNo" value="<bean:write name='prpLcompensateDto' property='claimNo' filter='true' />">
        <input type="hidden" name="strRecaseFlag" value="<%=strRecaseFlag %>">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="ChargeImg" onclick="showPage(this,spanCharge)">������<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="Charge_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
        
                  <input type="hidden" name="prpLchargeFlag">
                  <input type="hidden" name="prpLchargeSerialNo" description="���">
                  
                  <input type="hidden" name="prpLchargeKindName" class="codename" style="width:120px"
                   ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
                    onchange="setFlagDanger();">     
                     </tr>
                      <tr>
                         <td class="input" style="width:4%" align="center" >
                            <input type="text" name="prpLlossDtoItemKindNoForCharge"  class="readonly" readonly="readonly">  
                        </td>               
                        <td class="input" style="width:8%" >
                          <input type="input" name=prpLchargeKindCode class="codecode" 
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1','code');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1','code');"
                             onchange="setFlagDanger();setPrpLpreChargeAmount(this);"
                             >    
                       </td >
                       <td class="input" style="width:8%">             
                          <input type="input" name=prpLchargeKindName class="codename"  
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        			              onchange="setFlagDanger();setPrpLpreChargeAmount(this);"
        			              > 
                       </td>                
                <td class="input" align="center" style="width:8%">
                  <input name="prpLchargeChargeCode" class="codecode" style="width:95%"
                    ondblclick="code_CodeSelect(this, 'ChargeCode');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode');"
                    onblur="checkChargeCode(this)"
                    onchange="setPrpLpreChargeAmount(this);">  
                </td>
                <td class="input" align="center" style="width:8%">
                  <input name="prpLchargeChargeName" class="codename" style="width:95%"
                   ondblclick="code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
                   onblur="checkChargeCode(this)"
                   onchange="setPrpLpreChargeAmount(this);"> 
                </td>
                
                 <td class="input" style="width:9%" >
                   <input type=hidden class="codecode" name="prpLchargeCheckDeptCode"  num=-1 style="width:20%" title="���嵥λ" value=""
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
                
                <td class="input" style="width:8%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" selected>�ⲿ</option>
                    <option value="A">�ڲ�</option>
                  </select>
                </td>
                <td class="input" style="width:10%"> 
                  <input name="prpLchargePayObjectCode" type="hidden" class="readonly" readonly  style="width:100%" value="">
                  <input name="prpLchargePayObjectName" class="common" style="width:100%" value="" maxlength="50">
                </td>  
                <td class="input" style="width:10%">
                  <input type="text" name="prpLchargeCurrency" class="codecode" style="width:17%" value="<bean:write name='prpLcompensateDto' property='currency' />"
                     ondblclick="code_CodeSelect(this, 'Currency');"
                     onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type="text" name="prpLchargeCurrencyName" class="codecode" style="width:65%" value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">       
                </td>
                <td class="input" style="width:10%" align="center"> 
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" onchange="calFund();setFlagDanger();">
                </td>
                <td class="input" style="width:10%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%" >
                </td>
                <td class="input" style="width:10%" align="center">
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
                <td class="centertitle" style="width:4%">������</td>
                <td class="centertitle" style="width:8%">�ձ����</td>
                <td class="centertitle" style="width:8%">�ձ�����</td>
                <td class="centertitle" style="width:8%">���ô���</td>
                <td class="centertitle" style="width:8%">��������</td>
                <td class="centertitle"  style="width:10%">���鿱����</td>
                <td class="centertitle"  style="width:8%">֧�����</td>
                <!-- td class="centertitle"  style="width:14%">֧���������</td-->
                <td class="centertitle"  style="width:10%">��������</td>
                <td class="centertitle" style="width:10%">�ұ�</td>
                <td class="centertitle" style="width:10%">���ý��</td>
                <td class="centertitle" style="width:10%">Ԥ������</td>
                <td class="centertitle" style="width:10%">���������</td>
              <td class="title" style="width:4%">&nbsp;</td>
            </tr>
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan="12" style="width:96%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
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
              
                  <td  class="input" align="center" style="width:4%">
                      <input type='text'  description="������" name='prpLlossDtoItemKindNoForCharge' class="readonly" readonly="readonly" value="<bean:write name='chargedtox' property='itemkindno'/>">
                  </td>
                   <td class="input" align="center" style="width:8%">
                         <input type="text" name="prpLchargeKindCode" class="codecode"   value="<bean:write name='chargedtox' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1','code');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1','code');"
                             onchange="setFlagDanger();setPrpLpreChargeAmount(this);">                 
                   </td>
                 <td  class="input" align="center" style="width:8%">
	                  <input type="text"  name="prpLchargeKindName" class="codename" value="<bean:write name='chargedtox' property='kindName'/>"
	                   ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
	                   onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
	                    onchange="setFlagDanger();setPrpLpreChargeAmount(this);">
                 </td>
                <td class="input" align="center" style="width:8%">
                  <input name="prpLchargeChargeCode" class="codecode" style="width:95%" value="<bean:write name='chargedtox' property='chargeCode'/>"
                    ondblclick="code_CodeSelect(this, 'ChargeCode');"
                    onkeyup= "code_CodeSelect(this, 'ChargeCode');"
                    onblur="checkChargeCode(this)"
                    onchange="setPrpLpreChargeAmount(this);">  
                </td>
                <td class="input" align="center" style="width:8%">
                  <input name="prpLchargeChargeName" class="codename" style="width:95%" value="<bean:write name='chargedtox' property='chargeName'/>"
                   ondblclick="code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
                   onkeyup= "code_CodeSelect(this, 'ChargeCode','-1','always','none','post');"
                   onblur="checkChargeCode(this)"
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
                
                 <td class="input" style="width:8%">
                  <select name="prpLchargePayObjectType" class='common' style="width:50px">
                    <option value="B" <logic:equal name='chargedtox' property='payObjectType' value="B">selected</logic:equal>>�ⲿ</option>
                    <option value="A" <logic:equal name='chargedtox' property='payObjectType' value="A">selected</logic:equal>>�ڲ�</option>
                  </select>
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargePayObjectCode" type="hidden" class="readonly" readonly style="width:100%"
                    value="<bean:write name='chargedtox' property='payObjectCode'/>">
                  <input name="prpLchargePayObjectName" class="common" style="width:100%" maxlength="50"
                    value="<bean:write name='chargedtox' property='payObjectName'/>">
                </td>
                <td class="input" align="left" style="width:10%">  
                  <input type="text" name="prpLchargeCurrency" class="codecode" style="width:17%" value="<bean:write name='chargedtox' property='currency'/>"
                     ondblclick="code_CodeSelect(this, 'Currency');"
                     onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type="text" name="prpLchargeCurrencyName" class="codecode" style="width:65%" value="<bean:write name='chargedtox' property='currencyName'/>"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">       
                </td>
                <td class="input" style="width:10%"> 
                  <input name="prpLchargeChargeAmount" class="input" style="width:100%" value="<bean:write name='chargedtox' property='chargeAmount'/>" onchange="calFund();setFlagDanger();">
                </td>
                 <td class="input" style="width:10%">
                	<input name="prpLpreChargeAmount" class='readonly' readonly style="width:100%" value="<bean:write name='chargedtox' property='preChargeAmount'/>">
                </td>
                <td class="input" style="width:10%">
                  <input name="prpLchargeSumRealPay" class="input" style="width:100%" value="<bean:write name='chargedtox' property='sumRealPay'/>" onchange="calFund();setFlagDanger();">
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