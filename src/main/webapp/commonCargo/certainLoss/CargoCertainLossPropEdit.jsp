<%--
****************************************************************************
* DESC       ����Ӽ�ʻԱ��Ϣҳ��
* AUTHOR     ��weishixin
* CREATEDATE �� 2004-03-03
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
      function afterInsertProp()
      {
        setPrpLpropSerialNo();
      } 
     
      /* 
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeleteProp(field)
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
                //alert(i);
              }
          }
      }
      
         function calPropLoss(){
         var count = getElementCount("prpLpropSerialNo");
         var sumPropLoss      = 0.0;//������ϼ�
         var sumDefLoss       = 0.0;//������ϼ�
         var sumReject        = 0.0;//�޳����ϼ�
         var unitPropLoss     = 0.0;//�˶���ʧ
         var itemDefLoss     = 0.0//�˶������ʧ
         var unitReject       = 0.0;//�޳����
         var unitPrice        = 0.0;//����
         var DepreRate        = 0.0;//�۾���
         var unitLossQuantity = 0.0;//��������
         var LossRate         = 0.0;//��ʧ��
         for(var i=1;i<count;i++){
         unitPrice        = parseFloat(fm.prpLpropUnitPrice[i].value);
         unitLossQuantity = parseFloat(fm.prpLpropLossQuantity[i].value);
         DepreRate        = parseFloat(fm.prpLpropDepreRate[i].value);
         unitReject       = parseFloat(fm.prpLpropSumReject[i].value);
         LossRate         = parseFloat(fm.prpLpropLossRate[i].value);
            if(isNaN(unitPrice)){
               unitPrice = 0.0;
            }
            if(isNaN(unitLossQuantity)){
               unitLossQuantity = 0.0;
            }
            if(isNaN(DepreRate)){
               DepreRate = 0.0;
            }
            if(isNaN(unitReject)){
               unitReject = 0.0;
            }
            if(isNaN(LossRate)){
               LossRate = 0.0;
            }
            unitPropLoss                  = unitPrice*unitLossQuantity*(100-DepreRate)/100;//�˶���ʧ
            fm.prpLpropSumLoss[i].value   = mathRound(unitPropLoss);
            
            itemDefLoss                   = (unitPropLoss-unitReject)*LossRate/100; //�˶������ʧ
            fm.prpLpropSumDefLoss[i].value = itemDefLoss;
            sumPropLoss+=unitPropLoss;
            sumReject  +=unitReject;
            sumDefLoss +=itemDefLoss;
         }
         fm.prpLpropSumSumLoss.value    = mathRound(sumPropLoss);
         fm.prpLpropSumSumReject.value  = mathRound(sumReject);
         fm.prpLpropSumSumDefLoss.value = mathRound(sumDefLoss);
      }
    </script>    
		 
  <span  id="SpanProp">   
    <!--������ʾ��¼����������������ʾ��-->   
    <table class="common" align="center"  cellspacing="1" cellpadding="0"> 
    <!--��ʾ��ʾ���е�-->  
      <tr> 
        <td class="subformtitle" colspan="4">�Ʋ���ʧ�嵥��Ϣ<br>
          <span  style="display:none">
            <table cellspacing="1" cellpadding="0" class="common"  id="Prop_Data" style="display:none">
              <tbody>  
                <tr class=common>
                  <td class="input" style="width:3%">
                   <div align="center">
                     <input class="readonlyNo" readonly name="prpLpropSerialNo" description="���"> 
                   </div>
                  </td>
                  <td >
                    <table cellspacing="1" cellpadding="0" class="common">
                      <tr>
                        <td class="title" >�ձ�</td>
                        <td class="input"> 
                         <logic:notEqual name="prpLverifyLossDto" property="riskCode" value="1003">                         
                          <input type="input" name="prpLpropKindCode" class="codecode" style='width:30%' 
                              ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2,3,4');"
                              onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2,3,4');">   
                          <input type="input" name="prpLpropKindName" class="codename" style='width:58%'
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1,2,3','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1,2,3','always','none','post');">  
                          </logic:notEqual>
                          <logic:equal name="prpLverifyLossDto" property="riskCode" value="1003">
                          	<input type="input" name="prpLpropKindCode" class="codecode" style='width:30%' 
                              ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2,3');"
                              onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2,3,4');">   
                          <input type="input" name="prpLpropKindName" class="codename" style='width:58%'
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1,2','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1,2','always','none','post');">  
                          </logic:equal>    
                        </td>
                        <td class="title" >��Ŀ���ƣ�</td>
                        <td class="input" >
                          <input type="hidden" name="prpLpropItemKindNo">
                          <input type="hidden" name="prpLpropItemCode">
                          <input type="input" name="prpLpropLossItemName"  class="readonly" readonly  >
                          
                        </td>
                      </tr>
                      <tr>
                        <td class="title">��ʧ��Ŀ��</td>
                        <td class="input" colspan="3">
                          <!-- <input type="input" name="prpLpropItemDetailName" class=common> -->
                          <input class="input" style='width:190px' name="prpLpropRemark">
                        </td>
                      </tr>  
                      
                      <tr>
                         
                        <td class="title">�ұ�</td>   
                        <td class="input">
                          <input type="input" class="codecode" name="prpLpropCurrency" value="CNY" class="codecode" style='width:30%'
                            ondblclick= "code_CodeSelect(this,'Currency');"
                            onkeyup= "code_CodeSelect(this,'Currency');">  
                          <input type="input" class="codename" name="prpLpropCurrencyName" value="�����" class="codecode" style='width:58%'
        			             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');"> 
                          </td>
                          <td class="title">&nbsp;</td> 
                        <td class="input">
                          <%--<html:select name="prpLpropDto" property="feeTypeCode" >
                             <html:option value="01">�����</html:option> 
                             <html:option value="02">���Ϸ�</html:option>   
                          </html:select>--%>                      
                          <input type="hidden" name="feeTypeCode" class="codecode" style='width:30%'
                              ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                              onkeyup= "code_CodeSelect(this,'PropertyFeeType');">   
                          <input type="hidden" name="prpLpropFeeTypeName" class="codename" style='width:58%'
                                 ondblclick="code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');"
                                 onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');">  
                                
                        </td>
                      </tr> 
                      
                      <tr>
                        <td class="title">���ۣ�</td>
                        <td class="input">
                          <input class="input" name="prpLpropUnitPrice" onblur="calPropLoss();">
                        </td>
                        <td class="title">����������</td>   
                        <td class="input">
                          <input class="input"  name="prpLpropLossQuantity" onblur="calPropLoss();">
                        </td>
                      </tr>   
                      
                      <tr>
                        <td class="title">�۾��ʣ�</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropDepreRate" value="0" onblur="calPropLoss();">%
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">�˶���ʧ��</td>
                        <td class="input">
                          <input class="input"  name="prpLpropSumLoss">
                        </td>
                        <td class="title">�޳���</td>   
                        <td class="input"><input class="input"  name="prpLpropSumReject" onblur="calPropLoss();"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">��ʧ�ʣ�</td>
                        <td class="input">
                          <input class="input" name="prpLpropLossRate" value="100" onblur="calPropLoss();">%
                        </td>
                        <td class="title">�˶������ʧ��</td>   
                        <td class="input"><input class="input"  name="prpLpropSumDefLoss"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">�޳�ԭ��</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropRejectReason">
                        </td>
                      </tr>  
                      
                      <tr>
                        <!--<td class="title">��ע��</td>
                        <td class="input" colspan="3">  -->
                          <input type="hidden" name="prpLpropFamilyNo">
                          <input type="hidden" name="prpLpropFamilyName">
                          <input type="hidden" name="prpLpropLossItemCode" value="S">

                          <input type="hidden" name="prpLpropUnit">
                          <input type="hidden" name="prpLpropBuyDate">
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
                       <!-- </td>
                      </tr>       -->               
                    </table>
                  </td>
                  <td class="input" style='width:4%'>
                    <div align="center">
                      <input type=button name="buttonPropDelete"  class=smallbutton onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                    </div>
                  </td>   
                </tr>
              </tbody> 
            </table>
            </span> 
  
  
          <span  id="spanProp">
          <%-- ��������չ���� --%>
          <table  class="common" id="Prop" align="center" cellspacing="1" cellpadding="0">
            <thead>
              <tr>
                <td class="title" style="width:4%">���</td>
                <td class="title" style="width:96%" colspan=2 >����</td>
              </tr>                        
            </thead>
            <tfoot> 
              <tr>
                <td class="title" colspan=2 style="width:96%">(��"+"�ż����ӲƲ���ʧ�嵥��Ϣ����"-"�ż�ɾ����Ϣ)</td>
                <td class="title" align="right" style="width:4%">
                  <div align="center">
                    <input type="button" value="+" class=smallbutton onclick="insertRow('Prop')" name="buttonDriverInsert" style="cursor: hand">
                  </div>
                </td>                                  
              </tr>
            </tfoot>  
            <tbody>
          
<% indexCertainLoss=0;%>
<logic:notEmpty  name="prpLpropDto"  property="propList"> 
<logic:iterate id="prpLpropDto1" name="prpLpropDto" property="propList">
                <tr class=common>
                  <td class="input" style="width:3%">
                   <div align="center">
                     <input class="readonlyNo" readonly name="prpLpropSerialNo" description="���" value="<bean:write name='prpLpropDto1' property='serialNo'/>"> 
                   </div>
                  </td>
                  <td class="subformtitle"  >
                    <table  cellpadding="0" cellspacing="1" class="common">
                      <tr>
                        <td class="title" >�ձ�</td>
                        <td class="input">                           
                          <input type="input" name="prpLpropKindCode" class="codecode" style='width:30%'
                              value="<bean:write name='prpLpropDto1' property='kindCode'/>"
                              ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2,3,4');"
                              onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2,3,4');">   
                          <input type="input" name="prpLpropKindName" class="codename" style='width:58%'
                             value="<bean:write name='prpLpropDto1' property='kindName'/>"
          			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1,2,3','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1,2,3','always','none','post');">  
                               
                        </td>
                        <td class="title" >��Ŀ���ƣ�</td>
                        <td class="input" >
                          <input type="hidden" name="prpLpropItemKindNo" value="<bean:write name='prpLpropDto1' property='itemKindNo'/>">
                          <input type="hidden" name="prpLpropItemCode" value="<bean:write name='prpLpropDto1' property='itemCode'/>">
                          <input name="prpLpropLossItemName"  class="readonly" readonly  
                             value="<bean:write name='prpLpropDto1' property='lossItemName'/>">
                          
                        </td>
                      </tr>
                      <tr> 
                        <td class="title">��ʧ��Ŀ��</td>
                        <td class="input" colspan="3">
                           <input class="input" style='width:190px' name="prpLpropRemark" value="<bean:write name='prpLpropDto1' property='remark'/>">
                           <!-- <input type="input" name="prpLpropItemDetailName"  class=common > -->
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">�ұ�</td>   
                        <td class="input">
                          <input type="input" name="prpLpropCurrency" style='width:30%'  
                            value="<bean:write name='prpLpropDto1' property='currency'/>"  class="codecode"
                            ondblclick= "code_CodeSelect(this,'Currency');"
                            onkeyup= "code_CodeSelect(this,'Currency');">      
                          <input type="input" name="prpLpropCurrencyName" style='width:58%'
                             value="<bean:write name='prpLpropDto1' property='currencyName'/>" class="codename"
          			             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
          			             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                          </td> 
                        <td class="title">&nbsp;</td>   
                        <td class="input">                       
                          <input type="hidden" name="feeTypeCode" class="codecode" style='width:30%'
                              value="<bean:write name='prpLpropDto1' property='feeTypeCode'/>"
                              ondblclick= "code_CodeSelect(this,'PropertyFeeType');"
                              onkeyup= "code_CodeSelect(this,'PropertyFeeType');">   
                          <input type="hidden" name="prpLpropFeeTypeName" class="codename" style='width:58%' 
                             value="<bean:write name='prpLpropDto1' property='feeTypeName'/>"
                                 ondblclick="code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');"
                                 onkeyup= "code_CodeSelect(this, 'PropertyFeeType','-1','always','none','post');">  
                                
                        </td>

                      </tr>  
                      
                      <tr>
                        <td class="title">���ۣ�</td>
                        <td class="input">
                          <input class="input" name="prpLpropUnitPrice" value="<bean:write name='prpLpropDto1' property='unitPrice'/>" onblur="calPropLoss();">
                        </td>
                        <td class="title">����������</td>   
                        <td class="input">
                          <input class="input"  name="prpLpropLossQuantity" value="<bean:write name='prpLpropDto1' property='lossQuantity'/>" onblur="calPropLoss();">
                        </td>
                      </tr>   
                      <tr>
                        <td class="title">�۾��ʣ�</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropDepreRate" value="<bean:write name='prpLpropDto1' property='depreRate'/>" onblur="calPropLoss();">%
                        </td>
                      </tr>  
                      
                      <tr>
                        <td class="title">�˶���ʧ��</td>
                        <td class="input">
                          <input class="input"  name="prpLpropSumLoss" value="<bean:write name='prpLpropDto1' property='sumLoss'/>">
                        </td>
                        <td class="title">�޳���</td>   
                        <td class="input"><input class="input"  name="prpLpropSumReject" value="<bean:write name='prpLpropDto1' property='sumReject'/>" onblur="calPropLoss();"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">��ʧ�ʣ�</td>
                        <td class="input">
                          <input class="input"  name="prpLpropLossRate" value="<bean:write name='prpLpropDto1' property='lossRate'/>" onblur="calPropLoss();">%
                        </td>
                        <td class="title">�˶������ʧ��</td>   
                        <td class="input"><input class="input"  name="prpLpropSumDefLoss" value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>"></td>
                      </tr>  
                      
                      <tr>
                        <td class="title">�޳�ԭ��</td>
                        <td class="input" colspan="3">
                          <input class="input" style='width:190px' name="prpLpropRejectReason" value="<bean:write name='prpLpropDto1' property='rejectReason'/>">
                        </td>
                      </tr>  
                      <tr>
                       <!--  <td class="title">��ע��</td>
                        <td class="input" colspan="3">--> 
                          <input type="hidden" name="prpLpropItemKindNo" value="<bean:write name='prpLpropDto1' property='itemKindNo'/>"> 
                          <input type="hidden" name="prpLpropFamilyNo" value="<bean:write name='prpLpropDto1' property='familyNo'/>">
                          <input type="hidden" name="prpLpropFamilyName" value="<bean:write name='prpLpropDto1' property='familyName'/>">
                          <input type="hidden" name="prpLpropItemCode" value="<bean:write name='prpLpropDto1' property='itemCode'/>">
                          <input type="hidden" name="prpLpropLossItemCode" value="<bean:write name='prpLpropDto1' property='lossItemCode'/>">
                          <input type="hidden" name="prpLpropUnit" value="<bean:write name='prpLpropDto1' property='unit'/>">
                          <input type="hidden" name="prpLpropBuyDate" value="<bean:write name='prpLpropDto1' property='buyDate'/>">
                          <input type="hidden" name="prpLpropVeriRemark" value="<bean:write name='prpLpropDto1' property='veriRemark'/>">        
                          <input type="hidden" name="prpLpropVeriUnitPrice" value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                          <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                          <input type="hidden" name="prpLpropVeriUnit" value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                          <input type="hidden" name="prpLpropVeriDepreRate" value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                          <input type="hidden" name="prpLpropVeriSumLoss" value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">     
                          <input type="hidden" name="prpLpropVeriSumReject" value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">   
                          <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                          <input type="hidden" name="prpLpropVeriLossRate" value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
                          <input type="hidden" name="prpLpropVeriSumDefLoss" value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">  
                          <input type="hidden" name="prpLpropFlag" value="<bean:write name='prpLpropDto1' property='flag'/>">   
                       <!-- </td>
                      </tr>   --> 
                      
                                         
                    </table>
                  </td>
                  <td class="input" style='width:4%'>
                    <div align="center">
                      <input type=button name="buttonPropDelete" class=smallbutton  onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                    </div>
                  </td>   
                </tr>
                              
<%    indexCertainLoss++; %>
      </logic:iterate> 
      </logic:notEmpty> 
            
            </tbody>
          </table>
       </span>
      </td>
   </tr>
</table>

  <table border="0" align="center" cellpadding="4" cellspacing="1"  class="title" width="100%">
    <tr>
      <td class='title' width="33%">������ϼ�:<input class='readonly' readonly="true" style='width:80px' name='prpLpropSumSumLoss'>
      </td>    
      <td class='title' width="33%">�޳����ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumReject'>
      </td>  
      <td class='title' width="33%">������ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumDefLoss'>
      </td>        
    </tr>
  </table>  
</span>