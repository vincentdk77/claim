<%--
****************************************************************************
* DESC       ���Ʋ���ʧ�嵥ҳ��
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-07-13
* MODIFYLIST ��   Name       Date            Reason/Contents
*               wuxiaodong  20050907       ���Ӵ���ѡ���onchange�¼���ͬʱ֧�������������໥ѡ��
*          ------------------------------------------------------
****************************************************************************
--%> 

   <!--������ʾ��¼����������������ʾ��-->   
    <script language='javascript'>
      function afterInsertProp(pageCode)
      {
       var charSplit = "_";
		var strValue = pageCode.split(charSplit);
		var index  = strValue[1];
          var count=getElementCount("prpLpropSerialNo_"+index);
           for(var i=0;i<count;i++)
           {
              //alert("����ʲôʱ������?count="+count+"  i="+i); 
               if(count!=1){ 
                 fm.all("prpLpropSerialNo_"+index)[i].value=i;
               }
           }
      } 
      function afterDeleteProp(field,pageCode)
      {
     	  var charSplit = "_";
		var strValue = pageCode.split(charSplit);
		var index  = strValue[1];
          var count=getElementCount("prpLpropSerialNo_"+index);
           for(var i=0;i<count;i++)
           {
              //alert("����ʲôʱ������?count="+count+"  i="+i); 
               if(count!=1){ 
                 fm.all("prpLpropSerialNo_"+index)[i].value=i;
               }
           }
      }
      
	function combineInsertRow(pageCode)
	{
	  var obj;
	  var index;
	
	  //Call beforeInsertRow of pageCode
	  obj = eval("window.beforeInsert" + "Prop");
	  if(obj != null)
	  {
	    obj.apply();
	  }
	
	  //call realy insertRow of pageCode
	  obj = eval("window.insert" + "Prop");
	  if(obj != null)
	  {
	    index=obj.apply();
	  }
	  else  //���û���Զ�����ӷ��������Ĭ�ϵ���ӷ���
	  {
	    index=directInsertRow(pageCode,pageCode+"_Data");
	  }
	
	  //Call afterInsertRow of pageCode
	  obj = eval("window.afterInsert" + "Prop");
	  if(obj != null)
	  {
	    obj.apply(obj,arguments);
	  }
	//  directSetRowColor(pageCode,pageCode+"_Data",index,"#EEECFA")
	}
	function combineDeleteRow(field,pageCode)
	{
	  var obj;
	  var index;
	
	  //Call beforeDeleteRow of pageCode
	  obj = eval("window.beforeDelete" + "Prop");
	  if(obj != null)
	  {
	    obj.apply(obj,arguments);
	  }
	
	  //call realy insertRow of pageCode
	  obj = eval("window.delete" + "Prop");
	  if(obj != null)
	  {
	    index = obj.apply(obj,arguments);
	  }
	  else  //���û���Զ���ɾ�����������Ĭ�ϵ�ɾ������
	  {
	    index = directDeleteRow(field,pageCode,1,1);
	  }
	
	  //Call afterDeleteRow of pageCode
	  obj = eval("window.afterDelete" + "Prop");
	  if(obj != null)
	  {
	    obj.apply(obj,arguments);
	  }
	}
    </script>  
<% String compensatebackReadOnlyO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String compensatebackDiasableO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String compensatebackStyleO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%> 
<%iterator = PrplcombineDtos.iterator();
while(iterator.hasNext()){iterator.next();%>
<%
String prpLpropDto = "";
String prpLregistDtoTemp = "";
String prpLpropDtoList = "";
prpLpropDto = "prpLpropDto_"+String.valueOf(idxProp);
prpLregistDtoTemp = "prpLregistDto_"+String.valueOf(idxProp);
prpLpropDtoList = "prpLpropDtoList_"+String.valueOf(idxProp);
%>
    <span  id="spanPropEdit_<%=idxProp%>" style = "display:none" cellspacing="1" cellspacing="0"  width="100%">
    <input type="hidden" name= "prpLclaimPolicyNo_<%=idxProp%>"  value="<bean:write name='<%=prpLregistDtoTemp%>' property='policyNo'/>">
    <input type="hidden" name= "prpLverifyLossRiskCode_<%=idxProp%>"  value="<bean:write name='<%=prpLregistDtoTemp%>' property='riskCode'/>">
    <input type="hidden" name= "prpLverifyLossLossItemCode_<%=idxProp%>"  value="-2">
  <span  id="SpanProp_<%=idxProp%>" style="display:" cellspacing="1" cellpadding="0">
  <table class=common cellpadding="5" cellspacing="1">

  </table> 
        <span style="display:none"> 
          <table class="common" style="display:none" id="Prop_<%=idxProp%>_Data" cellpadding="5" cellspacing="1">
            <tbody>
            <input type="hidden" name="prpLpropLossItemCode_<%=idxProp%>" value="-2">
              <tr>
                <td class="input" style="width:20%">
                  <input type = "hidden" name = "prpLpropFamilyCode_<%=idxProp%>">
                  <input type= "hidden" name= "prpLpropFamilyNo_<%=idxProp%>">
                  <input type=text name="prpLpropFamilyName_<%=idxProp%>" title="�¹�������" 
			                  class="codecode" 
			                  ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post','<%=idxProp%>');"
			                  onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post','<%=idxProp%>');">
                  <input type= "hidden" name= "prpLpropPersonSex_<%=idxProp%>">
                  <input type= "hidden" name= "prpLpropPersonAge_<%=idxProp%>">
                  <input type= "hidden" name= "prpLpropPersonIdentifyNumber_<%=idxProp%>">
                  
                </td>
                <td class="input" style="width:20%">
                    <input type="hidden" name= "temp1_<%=idxProp%>" description="һ������ֵ�������治�õ���Ϣ">     
                    <input type="hidden"  name="prpLpropSerialNo_<%=idxProp%>" description="���">   
                    <input type="hidden"  name="prpLpropKindCode_<%=idxProp%>" class="codecode" >         
                    <input type="input" name="prpLpropKindName_<%=idxProp%>" class="codename" 
                     ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post','<%=idxProp%>');"
                     onchange="code_CodeChange(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post','<%=idxProp%>');"
                     onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post','<%=idxProp%>');">         
                <input type="hidden" name="prpLpropItemKindNo_<%=idxProp%>">
                </td>
                <td class="input" style="width:15%">
                  <input type="hidden" name="prpLpropItemCode_<%=idxProp%>">                
                  <input name="prpLpropLossItemName_<%=idxProp%>" class=common   maxlength=40>
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLpropSumLoss_<%=idxProp%>" class=common   maxlength=40 onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">               
                  <input name="prpLpropSumReject_<%=idxProp%>" class=common   maxlength=40 onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLpropSumDefLoss_<%=idxProp%>" class=readonly readonly  maxlength=40 onBlur="initSet();">
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLpropRemark_<%=idxProp%>" class=common   maxlength=40>
                </td>                
                <td class="input" style='width:5%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete_<%=idxProp%>"  class="smallbutton" onclick="combineDeleteRow(this,'Prop_<%=idxProp%>')" value="-" style="cursor: hand">
                </div>
                 
                
                  <input type="hidden" name="prpLpropCurrency_<%=idxProp%>" value="CNY">
                  <input type="hidden" name="prpLpropUnitPrice_<%=idxProp%>">
                  <input type="hidden" name="prpLpropLossQuantity_<%=idxProp%>">
                  <input type="hidden" name="prpLpropUnit_<%=idxProp%>">
                  <input type="hidden" name="prpLpropBuyDate_<%=idxProp%>">
                  <input type="hidden" name="prpLpropDepreRate_<%=idxProp%>">
                  <input type="hidden" name="prpLpropRejectReason_<%=idxProp%>">  
                  <input type="hidden" name="prpLpropLossRate_<%=idxProp%>">    
                  <input type="hidden" name="prpLpropVeriRemark_<%=idxProp%>">        
                  <input type="hidden" name="prpLpropVeriUnitPrice_<%=idxProp%>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity_<%=idxProp%>">
                  <input type="hidden" name="prpLpropVeriUnit_<%=idxProp%>">        
                  <input type="hidden" name="prpLpropVeriDepreRate_<%=idxProp%>">   
                  <input type="hidden" name="prpLpropVeriSumLoss_<%=idxProp%>">     
                  <input type="hidden" name="prpLpropVeriSumReject_<%=idxProp%>">   
                  <input type="hidden" name="prpLpropVeriRejectReason_<%=idxProp%>">
                  <input type="hidden" name="prpLpropVeriLossRate_<%=idxProp%>">    
                  <input type="hidden" name="prpLpropVeriSumDefLoss_<%=idxProp%>">  
                  <input type="hidden" name="prpLpropFlag_<%=idxProp%>">  
                  <input type="hidden" name="prpLpropCompensateBackFlag_<%=idxProp%>" >
          
                </td>
              </tr>  
            </tbody>
          </table>
        </span>        
        
        <span  id="spanProp_<%=idxProp%>" cellspacing="1" cellspacing="0"  width="100%">
        <%-- ��������չ���� --%>
        <table class="common"  id="Prop_<%=idxProp%>" cellpadding="5" cellspacing="1">
          <thead>
            <tr>
              <td class="subformtitle" colspan=8 width="100%"> 
                �˶����嵥
              </td>
            </tr>  
            <tr>
              <td class="centertitle" style="width:12%">����������</td>
              <td class="centertitle" style="width:12%">�ձ�����</td>
              <td class="centertitle" style="width:12%">��ʧ�������</td>
              <td class="centertitle" style="width:12%">������</td>
              <td class="centertitle" style="width:12%">�޳����</td>
              <td class="centertitle" style="width:12%">������</td>
              <td class="centertitle" style="width:12%">��ע</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          <tfoot>  
            <tr>
              <td class="title" colspan=7 style="width:96%">(��"+"�ż����ӲƲ��˶�����Ϣ����"-"�ż�ɾ����Ϣ)</td>
               <td class="title" align="right" style="width:4%">
                 <div align="center">
                   <input type="button" value="+" class=smallbutton onclick="combineInsertRow('Prop_<%=idxProp%>')" name="buttonDriverInsert_<%=idxProp%>" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          <tbody>


<logic:notEmpty  name="<%= prpLpropDtoList%>">
<logic:iterate id="prpLpropDto1" name="<%= prpLpropDtoList%>">
<%   //���������˻ص��ж�
          compensatebackReadOnlyO="";
          compensatebackDiasableO="";
          compensatebackStyleO="";
%>          
        <logic:equal name='prpLpropDto1' property='compensateBackFlag' value="1">
      <%      compensatebackStyleO=";background:#CECECE";
              compensatebackReadOnlyO="readOnly";
              compensatebackDiasableO="disabled";
          %>
       </logic:equal>   

              <tr>
                <td class="input" style="width:50%">
                  <input type = "hidden" name = "prpLpropFamilyCode_<%=idxProp%>">
                       <input type= "hidden" name= "prpLpropFamilyNo_<%=idxProp%>" value="<bean:write name='prpLpropDto1' property='familyNo'/>">
                  <input type="input" name="prpLpropFamilyName_<%=idxProp%>" 
                  class="codename"  title="�¹�������" 
                  style='width:110px<%=compensatebackStyleO%>'  <%=compensatebackReadOnlyO%>
                  value="<bean:write name='prpLpropDto1' property='familyName'/>"
                  <%  if (compensatebackReadOnlyO.equals("")){%>
                  ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post','<%=idxProp%>');"
                  onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post','<%=idxProp%>');"
                  <%}%>
                  >
                  <input type= "hidden" name= "prpLpropPersonSex_<%=idxProp%>">
                  <input type= "hidden" name= "prpLpropPersonAge_<%=idxProp%>">
                  <input type= "hidden" name= "prpLpropPersonIdentifyNumber_<%=idxProp%>">
             
                </td>
                <td class="input" style="width:50%">
                     <input type="hidden" name= "temp2_<%=idxProp%>" description="һ������ֵ�������治�õ���Ϣ">      
                     <input type="hidden"  name="prpLpropSerialNo_<%=idxProp%>" description="���" value="<bean:write name='prpLpropDto1' property='serialNo'/>">   
                     <input type="hidden" name="prpLpropKindCode_<%=idxProp%>" class="codecode" style='width:30px<%=compensatebackStyleO%>'  <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='kindCode'/>">          
                   
                    <input type="input" name="prpLpropKindName_<%=idxProp%>" class="codename" style='width:80px<%=compensatebackStyleO%>' <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='kindName'/>"
                        <%  if (compensatebackReadOnlyO.equals("")){%>
                     ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post','<%=idxProp%>');"
                     onchange="code_CodeChange(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post','<%=idxProp%>');"
                     onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post','<%=idxProp%>');"
                     <%}%>
                     >    
                     <input type="hidden" name="prpLpropItemKindNo_<%=idxProp%>"       value="<bean:write name='prpLpropDto1' property='itemKindNo'/>">                  
                </td>
                <td class="input" style="width:15%">
                 <input type="hidden" name="prpLpropItemCode_<%=idxProp%>"         value="<bean:write name='prpLpropDto1' property='itemCode'/>">                    
                  <input name="prpLpropLossItemName_<%=idxProp%>" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='lossItemName'/>">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLpropSumLoss_<%=idxProp%>" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumLoss'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLpropSumReject_<%=idxProp%>" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumReject'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLpropSumDefLoss_<%=idxProp%>" class=readonly readonly style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>" onBlur="initSet();">
                </td>
                <td class="input" style="width:10%">                   
                  <input name="prpLpropRemark_<%=idxProp%>" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength="40" onblur="checkLength1(this);" description="��ע" <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='remark'/>">
                </td>                
                <td class="input" style='width:5%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete_<%=idxProp%>"  class=smallbutton  <%=compensatebackDiasableO%> onclick="combineDeleteRow(this,'Prop_<%=idxProp%>')" value="-" style="cursor: hand">
                </div>
                    
                  <input type="hidden" name="prpLpropLossItemCode_<%=idxProp%>"     value="-2">  
                  <input type="hidden" name="prpLpropCurrency_<%=idxProp%>"         value="<bean:write name='prpLpropDto1' property='currency'/>">       
                  <input type="hidden" name="prpLpropUnitPrice_<%=idxProp%>"        value="<bean:write name='prpLpropDto1' property='unitPrice'/>">     
                  <input type="hidden" name="prpLpropLossQuantity_<%=idxProp%>"     value="<bean:write name='prpLpropDto1' property='lossQuantity'/>">  
                  <input type="hidden" name="prpLpropUnit_<%=idxProp%>"             value="<bean:write name='prpLpropDto1' property='unit'/>">          
                  <input type="hidden" name="prpLpropBuyDate_<%=idxProp%>"          value="<bean:write name='prpLpropDto1' property='buyDate'/>">       
                  <input type="hidden" name="prpLpropDepreRate_<%=idxProp%>"        value="<bean:write name='prpLpropDto1' property='depreRate'/>">     
                  <input type="hidden" name="prpLpropRejectReason_<%=idxProp%>"     value="<bean:write name='prpLpropDto1' property='rejectReason'/>">  
                  <input type="hidden" name="prpLpropLossRate_<%=idxProp%>"         value="<bean:write name='prpLpropDto1' property='lossRate'/>">      
                  <input type="hidden" name="prpLpropVeriRemark_<%=idxProp%>"       value="<bean:write name='prpLpropDto1' property='veriRemark'/>">        
                  <input type="hidden" name="prpLpropVeriUnitPrice_<%=idxProp%>"    value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity_<%=idxProp%>" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                  <input type="hidden" name="prpLpropVeriUnit_<%=idxProp%>"         value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                  <input type="hidden" name="prpLpropVeriDepreRate_<%=idxProp%>"    value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                  <input type="hidden" name="prpLpropVeriSumLoss_<%=idxProp%>"      value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">     
                  <input type="hidden" name="prpLpropVeriSumReject_<%=idxProp%>"    value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">   
                  <input type="hidden" name="prpLpropVeriRejectReason_<%=idxProp%>" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                  <input type="hidden" name="prpLpropVeriLossRate_<%=idxProp%>"     value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
                  <input type="hidden" name="prpLpropVeriSumDefLoss_<%=idxProp%>"   value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">  
                  <input type="hidden" name="prpLpropFlag_<%=idxProp%>"             value="<bean:write name='prpLpropDto1' property='flag'/>">   
                  <input type="hidden" name="prpLpropCompensateBackFlag_<%=idxProp%>" value="<bean:write name='prpLpropDto1' property='compensateBackFlag'/>">   
                </td>
              </tr>  
                        
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 
        </table>    
        </span>    
  
  <table border="0" align="center" cellpadding="4" cellspacing="1"  class="title" width="100%">
    <tr>
      <td class='title' width="33%">������ϼ�:<input class='readonly' readonly="true" style='width:80px' name='prpLpropSumSumLoss_<%=idxProp%>'>
      </td>    
      <td class='title' width="33%">�޳����ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumReject_<%=idxProp%>'>
      </td>  
      <td class='title' width="33%">������ϼ�:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumDefLoss_<%=idxProp%>'>
      </td>        
    </tr>
  </table>  
</span> 
</span>

<%idxProp++;
}%>