<%--
****************************************************************************
* DESC       ���Ʋ���ʧ�嵥ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-13 
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
****************************************************************************
--%> 

   <!--������ʾ��¼����������������ʾ��-->   
    <script language='javascript'>
      //��������뱾ҳ�Զ����JavaScript����
      /*
        ����һ���µ�֮��Ĵ�����ѡ������
      */
      function afterInsertprop()
      {
        setPrpLpropSerialNo();
      }
      
      /*
       *������޳����ı�󣬼���������ֵ
       */
       function calPropVeriSumDefLoss(field){
            var fieldName = field.name;
            for(var i = 0;i < fm.all(fieldName).length;i++){
                if(field == fm.all(fieldName)[i]){
                    var VeriSumLoss = fm.all("prpLpropVeriSumLoss")[i].value;
                    var VeriSumReject = fm.all("prpLpropVeriSumReject")[i].value;
                    
                    if(isNaN(VeriSumLoss))VeriSumLoss = 0;
                    if(isNaN(VeriSumReject))VeriSumReject = 0;
                    
                    fm.all("prpLpropVeriSumDefLoss")[i].value = VeriSumLoss - VeriSumReject;
                }
            }
            /**
	       	 *������޳����ı�󣬼����ܺ���������ܺ����޳����ܺ�����ϼ�
	         */
	        var veriSumDefLossCount = getElementCount("prpLpropVeriSumDefLoss");
	        var prpLpropSumVeriSumLoss = 0.00;              //�ܺ���������
	        var prpLpropSumVeriSumReject = 0.00;			//�ܺ����޳����
	        var prpLpropSumVeriSumDefLoss = 0.00;			//�ܺ�����ϼ�
	        for(var j = 1; j < veriSumDefLossCount ;j++){
	        	prpLpropSumVeriSumLoss += parseFloat(fm.prpLpropVeriSumLoss[j].value);
	        	prpLpropSumVeriSumReject += parseFloat(fm.prpLpropVeriSumReject[j].value);
	        	prpLpropSumVeriSumDefLoss += parseFloat(fm.prpLpropVeriSumDefLoss[j].value);
	        }
	        fm.prpLpropSumVeriSumLoss.value = point(round(prpLpropSumVeriSumLoss,2),2); 
	        fm.prpLpropSumVeriSumReject.value = point(round(prpLpropSumVeriSumReject,2),2);
	        fm.prpLpropSumVeriSumDefLoss.value = point(round(prpLpropSumVeriSumDefLoss,2),2);
       }
       
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteprop(field)
      {        
        setPrpLpropSerialNo();
      }
    
      /**
       * ����setPrpLpropSerialNo
       */
      function setPrpLpropSerialNo(){
          var count=getElementCount("prpLpropSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("����ʲôʱ������?count="+count+"  i="+i); 
              if(count!=1){
                fm.prpLpropSerialNo[i].value=i;
              }
          }
      }
    </script>   
    
  <span  id="SpanProp" style="display:" cellspacing="1" cellpadding="0">  
  <%if(!("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp))){ %>      
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class="centertitle" colspan="4">������Ϣ</td>
    </tr> 
    <tr>
      <td class="title" style="width:15%">������������:</td>
      <td class="input" style="width:35%" >
        <input type="text" name="prpLverifyLossInsuredNameShow" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='insuredName'/>">
      </td>
      <td class="title" style="width:15%">���ƺ���:</td>
      <td class="input" style="width:35%">
        <input type=text name="prpLverifyLossLicenseNoShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='licenseNo'/>">          
      </td>
    </tr> 
    <tr>
      <td class="title" style="width:15%">���Ƶ�ɫ:</td>
      <td class="input" style="width:35%" >
        <input type="text" name="prpLverifyLossLicenseColorShow" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='licenseColor'/>">
      </td>
      <td class="title" style="width:15%">��������:</td>
      <td class="input" style="width:35%">
        <input type=text name="prpLverifyLossCarKindShow" class="readonly" readonly="true" style="width:140px" value="<bean:write name='prpLverifyLossDto' property='carKind'/>">          
      </td>
    </tr> 
    <tr>
      <td class="title" style="width:15%">�������:</td>
      <td class="input" style="width:35%" >
        <input type="text" name="prpLverifyLossClauseNameShow" class="readonly" readonly="true" value="<bean:write name='prpLverifyLossDto' property='clauseName'/>">
      </td>
      <td class="title" style="width:15%">�ұ�:</td>
      <td class="input" style="width:35%">
        <input type="text" name="prpLverifyLossCurrencyNameShow" class="readonly" readonly="true" style="width:140px" value="�����">          
        <input type="hidden" name="prpLverifyLossCurrencyShow" value="<bean:write name='prpLverifyLossDto' property='currency'/>">          
      </td>
    </tr>  
  </table>   
<%} %>  
   
        <span style="display:none"> 
          <table class="common" style="display:none" id="Prop_Data" cellspacing="1" cellpadding="0">
            <tbody>

              <tr>
                <td class="input">  
                  <input type="hidden" name="prpLpropLossLossItemCode" value="-1">
                  <input type="hidden"  name="prpLpropSerialNo" description="���">   
                  <input type="input" name="prpLpropKindCode" class="codecode" style='width:30px'
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode');"
                      onchange="code_CodeChange(this, 'PolicyKindCode');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode');">         
                </td>
                <td class="input">   
                    <input type="input" name="prpLpropKindName" class="codename" style='width:80px'
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');"
  			             onchange="code_CodeChange(this, 'PolicyKindCode','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1','always','none','post');">         
                </td>
                <td class="input">                
                  <input name="prpLpropLossItemName" class=common style='width:80px'>
                </td>
                <td class="input">
                  <html:select name="prpLpropDto" property="feeTypeCode" >
                    <html:options collection="FeeTypeCodeList"  property="value" labelProperty="label"/>          
                  </html:select>
                </td>
                <td class="input">                
                  <input name="prpLpropSumLoss" class=common style='width:80px'>
                </td>
                <td class="input">                
                  <input name="prpLpropSumReject" class=common style='width:80px'>
                </td>
                <td class="input">                
                  <input name="prpLpropSumDefLoss" class=common style='width:80px'>
                </td>
                <td class="input">                
                  <input name="prpLpropRemark" class=common style='width:80px' maxLength="255" onblur="checkLength1(this);" description="��ע" >
                </td>                
                  <input type="hidden" name="prpLpropItemKindNo">
                  <input type="hidden" name="prpLpropFamilyNo">
                  <input type="hidden" name="prpLpropFamilyName">
                  <input type="hidden" name="prpLpropItemCode">
                  <input type="hidden" name="prpLpropLossItemCode">
                  <input type="hidden" name="prpLpropFeeTypeCode">
                  <input type="hidden" name="prpLpropFeeTypeName">
                  <input type="hidden" name="prpLpropCurrency" value="CNY">
                  <input type="hidden" name="prpLpropUnitPrice">
                  <input type="hidden" name="prpLpropLossQuantity">
                  <input type="hidden" name="prpLpropUnit">
                  <input type="hidden" name="prpLpropBuyDate">
                  <input type="hidden" name="prpLpropDepreRate">
                  <input type="hidden" name="prpLpropRejectReason">  
                  <input type="hidden" name="prpLpropLossRate">    
                  <input type="hidden" name="prpLpropVeriRemark">        
                  <input type="hidden" name="prpLpropVeriUnitPrice"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity">
                  <input type="hidden" name="prpLpropVeriUnit">        
                  <input type="hidden" name="prpLpropVeriDepreRate">   
                  <input type="hidden" name="prpLpropVeriSumLoss">     
                  <input type="hidden" name="prpLpropVeriSumReject">   
                  <input type="hidden" name="prpLpropVeriRejectReason">
                  <input type="hidden" name="prpLpropVeriLossRate">    
                  <input type="hidden" name="prpLpropVeriSumDefLoss">  
                  <input type="hidden" name="prpLpropFlag"> 
                  <input type="hidden" name="prpLpropCompensateBackFlag"> 
                    
              </tr>     
    
            </tbody>
          </table>
        </span>        
        
        <span  id="spanProp" cellspacing="1" cellpadding="0">
        <%-- ��������չ���� --%>
        <table class=common cellpadding="5" cellspacing="1">
          <thead>
            <tr>
              <td class="centertitle" colspan=10>
                �Ʋ��˶����嵥 
              </td>
            </tr>
            <tr>
              <td class="centertitle" style="width:10%">�ձ����</td>         
              <td class="centertitle" style="width:12%">�ձ�����</td>         
              <td class="centertitle" style="width:12%">��ʧ�Ʋ�����</td>                         
              <td class="centertitle" style="width:12%">��������</td>                  
              <td class="centertitle" style="width:12%">������</td>
              <td class="centertitle" style="width:12%">�޳����</td>   
              <td class="centertitle" style="width:12%">������</td> 
              <td class="centertitle" style="width:18%">��ע</td>
            </tr>
          </thead>
          <tfoot>

          </tfoot>
          <tbody>
<% indexVerifyLoss=0;%>
<logic:notEmpty  name="prpLpropDto"  property="propList"> 
<logic:iterate id="prpLpropDto1" name="prpLpropDto" property="propList">
				<input type="hidden" name="prpLpropLossLossItemCode" value="-1">
              <tr>
                <td class="input" style="width:10%">  
                  <input type="hidden"  name="prpLpropSerialNo" description="���" value="<bean:write name='prpLpropDto1' property='serialNo'/>">   
                  <input type="input" name="prpLpropKindCode" style='width:100%' value="<bean:write name='prpLpropDto1' property='kindCode'/>" class="readonly" readonly="true">         
                </td>
                <td class="input" style="width:12%">   
                    <input type="input" name="prpLpropKindName" style='width:100%' value="<bean:write name='prpLpropDto1' property='kindName'/>" class="readonly" readonly="true">         
                </td>
                <td class="input"  style="width:12%">                
                  <input name="prpLpropLossItemName" class="readonly" readonly="true" style='width:100%'   value="<bean:write name='prpLpropDto1' property='lossItemName'/>">
                </td>
                <td class="input" style="width:12%">
                  <input name="feeTypeCode" type="hidden" style='width:80px'   value="<bean:write name='prpLpropDto1' property='feeTypeCode'/>">
                   <input type="text" name="prpLpropFeeTypeName" style='width:100%' class="readonly" readonly="true" value="<bean:write name='prpLpropDto1' property='feeTypeName'/>">   
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumLoss" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='sumLoss'/>">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumReject" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='sumReject'/>">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumDefLoss" class="readonly" readonly="true" style='width:80px'   value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>">
                </td>
                <td class="input" style="width:18%">                
                  <input name="prpLpropRemark" class="readonly" readonly="true" style='width:100%' maxLength="255" onblur="checkLength1(this);" description="��ע"   value="<bean:write name='prpLpropDto1' property='remark'/>">
                </td>                             
                         
                  <input type="hidden" name="prpLpropItemKindNo"       value="<bean:write name='prpLpropDto1' property='itemKindNo'/>">    
                  <input type="hidden" name="prpLpropFamilyNo"         value="<bean:write name='prpLpropDto1' property='familyNo'/>">      
                  <input type="hidden" name="prpLpropFamilyName"       value="<bean:write name='prpLpropDto1' property='familyName'/>">    
                  <input type="hidden" name="prpLpropItemCode"        value="<bean:write name='prpLpropDto1' property='itemCode'/>">      
                  <input type="hidden" name="prpLpropLossItemCode"     value="<bean:write name='prpLpropDto1' property='lossItemCode'/>">  
                  <input type="hidden" name="prpLpropFeeTypeCode"      value="<bean:write name='prpLpropDto1' property='feeTypeCode'/>">   
                  <input type="hidden" name="prpLpropCurrency"         value="<bean:write name='prpLpropDto1' property='currency'/>">       
                  <input type="hidden" name="prpLpropUnitPrice"        value="<bean:write name='prpLpropDto1' property='unitPrice'/>">     
                  <input type="hidden" name="prpLpropLossQuantity"     value="<bean:write name='prpLpropDto1' property='lossQuantity'/>">  
                  <input type="hidden" name="prpLpropUnit"             value="<bean:write name='prpLpropDto1' property='unit'/>">          
                  <input type="hidden" name="prpLpropBuyDate"          value="<bean:write name='prpLpropDto1' property='buyDate'/>">       
                  <input type="hidden" name="prpLpropDepreRate"        value="<bean:write name='prpLpropDto1' property='depreRate'/>">     
                  <input type="hidden" name="prpLpropRejectReason"     value="<bean:write name='prpLpropDto1' property='rejectReason'/>">  
                  <input type="hidden" name="prpLpropLossRate"         value="<bean:write name='prpLpropDto1' property='lossRate'/>">      
                  <input type="hidden" name="prpLpropVeriUnitPrice"    value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                  <input type="hidden" name="prpLpropVeriUnit"         value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                  <input type="hidden" name="prpLpropVeriDepreRate"    value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                  
                  <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                  <input type="hidden" name="prpLpropVeriLossRate"     value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
               
                  <input type="hidden" name="prpLpropFlag"             value="<bean:write name='prpLpropDto1' property='flag'/>">   
                  <input type="hidden" name="prpLpropCompensateBackFlag" value="<bean:write name='prpLpropDto1' property='compensateBackFlag'/>">   
              </tr>  
              
              
              <tr>
                <td class="input" colspan="4" style='width:46%'>&nbsp;</td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropVeriSumLoss" class=common style='width:80px'   value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>" onblur="calPropVeriSumDefLoss(this);">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropVeriSumReject" class=common style='width:80px'  value="<bean:write name='prpLpropDto1' property='veriSumReject'/>" onblur="calPropVeriSumDefLoss(this);">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropVeriSumDefLoss" class=common style='width:80px'  readonly="true"  value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">
                </td>
                <td class="input" style="width:18%">                
                  <input name="prpLpropVeriRemark" class=common style='width:100%' maxLength="255" onblur="checkLength1(this);" description="��ע"  value="<bean:write name='prpLpropDto1' property='veriRemark'/>">
                </td>    
              </tr> 
                     
<%    indexVerifyLoss++;     %>
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>     
            
        </table>  
        </span>  
  
  <table class=common cellpadding="5" cellspacing="1">
    <tr>
      <td class='title' width="33%">������ϼ�:<input class='readonly' readonly="true" style='width:80px' name='prpLpropSumSumLoss'>
      </td>    
      <td class='title' width="33%">�޳����ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumReject'>
      </td>  
      <td class='title' width="33%">������ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumDefLoss'>
      </td>        
    </tr>
    <tr>
    	<td class="title" width="33">�˶�������ϼ�:<input class="readonly" readonly="true" style="width:80px" name="prpLpropSumVeriSumLoss"></td>
    	<td class="title" width="33">�����޳����ϼ�:<input class="readonly" readonly="true" style="width:80px" name="prpLpropSumVeriSumReject"</td>
    	<td class="title" width="33">������ϼ�:<input class="readonly" readonly="true" style="width:80px" name="prpLpropSumVeriSumDefLoss"</td>
    </tr>
  </table>  
  </span>    