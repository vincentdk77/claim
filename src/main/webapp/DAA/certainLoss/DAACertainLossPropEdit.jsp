<%--
****************************************************************************
* DESC       ：财产损失清单页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-13 
* MODIFYLIST ：   Name       Date            Reason/Contents
*               wuxiaodong  20050907       增加代码选择的onchange事件，同时支持名称与代码的相互选择
*          ------------------------------------------------------
****************************************************************************
--%> 

   <!--建立显示的录入条，可以收缩显示的-->   
    <script language='javascript'>
      //在下面加入本页自定义的JavaScript方法
      /*
        插入一条新的之后的处理（可选方法）
      */
      function afterInsertProp()
      {
        setPrpLpropSerialNo();
      } 
    
      /* 
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeleteProp(field)
      {        
        setPrpLpropSerialNo();
      }
    
      /**
       * 设置setPrpLpropSerialNo
       */
      function setPrpLpropSerialNo(){
          var count=getElementCount("prpLpropSerialNo");
          for(var i=0;i<count;i++)
          {
              //alert("看看什么时候运行?count="+count+"  i="+i); 
              if(count!=1){
                fm.prpLpropSerialNo[i].value=i;
              }
          }
      }
      function deleteProp(field,pageCode){
      	if(fm.prpLverifyLossCompensateFlag.value =="1" || fm.prpLverifyLossUnderWriteFlag.value=="0"){ //财产定损回退过来的
      		var prop_tr = field.parentElement;
      		while(prop_tr.tagName != 'TR'){
      			prop_tr = prop_tr.parentElement;
      		}
      		var rows = prop_tr.parentElement.childNodes;
      		for(var i =0;i<rows.length;i++){
      			if(rows[i]==prop_tr){
      				if(field.backFlag == "1"){	//财产定损回退过来的原始数据
      					prop_tr.parentElement.removeChild(rows[i+1]);
      				}
      				prop_tr.parentElement.removeChild(rows[i]);
      				break;
      			}
      		} 
      	}
      	else{											 //正常调度过来的			
      		directDeleteRow(field,pageCode,1,1);
      	}
      	getSumPropDefLoss(this);
      	initSet();
      }
    </script>   
    
  <span  id="SpanProp" style="display:" cellspacing="1" cellpadding="0">
  <table class=common cellpadding="5" cellspacing="1">
  <input type="hidden" name="prpLpropLossLossItemCode" value="-1">
  </table> 
    
        <span style="display:none"> 
          <table class="common" style="display:none" id="Prop_Data" cellpadding="5" cellspacing="1">
            <tbody>
              <tr>
                <td class="input" style="width:8%">  
                  <input type="hidden"  name="prpLpropSerialNo" description="序号">   
                  <input type="input" name="prpLpropKindCode" class="codecode" style='width:100%'
                      ondblclick= "code_CodeSelect(this,'PolicyKindCodeForProp');"
                      onchange="code_CodeChange(this,'PolicyKindCodeForProp');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCodeForProp');">         
                </td>
                <td class="input" style="width:12%">    
                    <input type="input" name="prpLpropKindName" class="codename" style='width:100%'
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             onchange="code_CodeChange(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForProp','-1','name','none','post');">         
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropLossItemName" class=common style='width:100%'  maxlength=40>
                </td>
                <td class="input" style="width:16%">
                  <html:select name="prpLpropDto" property="feeTypeCode" style="width:100%">
                    <html:options collection="FeeTypeCodeList"  property="value" labelProperty="label"/>          
                  </html:select> 
                </td> 
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumLoss" class=common style='width:100%'  maxlength=40 onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumReject" class=common style='width:100%'  maxlength=40 onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:12%">
                  <input name="prpLpropSumDefLoss" class=readonly readonly style='width:100%'  maxlength=40 onBlur="initSet();">
                </td>
                <td class="input" style="width:12%">
                  <input name="prpLpropRemark" class=common style='width:100%'  maxlength=40>
                </td>                
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete"  class="smallbutton" onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                </div>
                  <input type="hidden" name="prpLpropItemKindNo">
                  <input type="hidden" name="prpLpropFamilyNo">
                  <input type="hidden" name="prpLpropFamilyName">
                  <input type="hidden" name="prpLpropItemCode">
                  <input type="hidden" name="prpLpropLossItemCode">
   
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
                  <input type="hidden" name="prpLpropCompensateBackFlag" >
          
                </td>
              </tr>  
            </tbody>
          </table>
        </span>        
        
        <span  id="spanProp" cellspacing="1" cellspacing="0"  width="100%">
        <%-- 多行输入展现域 --%>
        <table class="common"  id="Prop" cellpadding="5" cellspacing="1" border="0">
          <thead>
            <tr>
              <td class="subformtitle" colspan=9 width="100%"> 
                财产核定损清单
              </td>
            </tr>  
            <tr>
              <td class="centertitle" style="width:8%">险别代码</td>
              <td class="centertitle" style="width:12%">险别名称</td>
              <td class="centertitle" style="width:12%">损失财产名称</td>
              <td class="centertitle" style="width:16%">费用名称</td>
              <td class="centertitle" style="width:12%">受损金额</td>
              <td class="centertitle" style="width:12%">剔除金额</td>
              <td class="centertitle" style="width:12%">定损金额</td>
              <td class="centertitle" style="width:12%">备注</td>
              <td class="title" style="width:4%"></td>
            </tr>  
          </thead>
          <tfoot>  
            <tr>
              <td class="title" colspan=8 style="width:96%">(按"+"号键增加财产核定损信息，按"-"号键删除信息)</td>
               <td class="title" align="right" style="width:4%">
                 <div align="center">
                   <input type="button" value="+" class=smallbutton onclick="insertRow('Prop')" name="buttonDriverInsert" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          <tbody>
<% indexCertainLoss=0;%>
<% String compensatebackReadOnlyO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackDiasableO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>
<% String compensatebackStyleO=""; //如果是由理算退回的，那么这行记录就应该显示得是只读的%>


<logic:notEmpty  name="prpLpropDto"  property="propList"> 
<logic:iterate id="prpLpropDto1" name="prpLpropDto" property="propList">
<%   //增加理算退回的判断
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

<%
          if(flag==null||flag.length()<1){      
%>
              <tr>
                <td class="input" style="width:8%">  
                  <input type="hidden"  name="prpLpropSerialNo" description="序号"  value="<bean:write name='prpLpropDto1' property='serialNo'/>">   
                  <input type="input" name="prpLpropKindCode" class="codecode" style='width:100%<%=compensatebackStyleO%>' <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='kindCode'/>"
                              <%  if (compensatebackReadOnlyO.equals("")){%>
 
                      ondblclick= "code_CodeSelect(this,'PolicyKindCodeForProp');"
                      onchange="code_CodeChange(this,'PolicyKindCodeForProp');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCodeForProp');"
                   <%}%>   
                      >     
                </td>
                <td class="input" style="width:12%">   
                    <input type="input" name="prpLpropKindName" class="codename" style='width:100%<%=compensatebackStyleO%>' <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='kindName'/>"
  			                     <%  if (compensatebackReadOnlyO.equals("")){%>
 
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             onchange="code_CodeChange(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             <%}%>
  			             >          
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropLossItemName" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40  <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='lossItemName'/>">
                </td>
                <td class="input" style="width:16%">
                  <html:select name="prpLpropDto1" property="feeTypeCode" style="width:100%">
                    <html:options collection="FeeTypeCodeList"  property="value" labelProperty="label"/>          
                  </html:select>
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumLoss" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumLoss'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumReject" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumReject'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumDefLoss" class=readonly readonly style='width:100%<%=compensatebackStyleO%>' <%=compensatebackReadOnlyO%> maxlength=40   value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>" onBlur="initSet();">
                </td>
                <td class="input" style="width:12%">                   
                  <input name="prpLpropRemark" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40  <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='remark'/>">
                </td>                
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete"  class=smallbutton onclick="deleteRow(this,'Prop')"  <%=compensatebackDiasableO%> value="-" style="cursor: hand">
                </div>
                  <input type="hidden" name="prpLpropItemKindNo"       value="<bean:write name='prpLpropDto1' property='itemKindNo'/>">    
                  <input type="hidden" name="prpLpropFamilyNo"         value="<bean:write name='prpLpropDto1' property='familyNo'/>">      
                  <input type="hidden" name="prpLpropFamilyName"       value="<bean:write name='prpLpropDto1' property='familyName'/>">    
                  <input type="hidden" name="prpLpropItemCode"        value="<bean:write name='prpLpropDto1' property='itemCode'/>">      
                  <input type="hidden" name="prpLpropLossItemCode"     value="<bean:write name='prpLpropDto1' property='lossItemCode'/>">  
 
                  <logic:notEmpty name='prpLpropDto1' property='currency' >
                  <input type="hidden" name="prpLpropCurrency"         value="<bean:write name='prpLpropDto1' property='currency'/>"> 
                  </logic:notEmpty>
                  <logic:empty name='prpLpropDto1' property='currency'>
                  <input type="hidden" name="prpLpropCurrency"         value="CNY">
                  </logic:empty>
                  <input type="hidden" name="prpLpropUnitPrice"        value="<bean:write name='prpLpropDto1' property='unitPrice'/>">     
                  <input type="hidden" name="prpLpropLossQuantity"     value="<bean:write name='prpLpropDto1' property='lossQuantity'/>">  
                  <input type="hidden" name="prpLpropUnit"             value="<bean:write name='prpLpropDto1' property='unit'/>">          
                  <input type="hidden" name="prpLpropBuyDate"          value="<bean:write name='prpLpropDto1' property='buyDate'/>">       
                  <input type="hidden" name="prpLpropDepreRate"        value="<bean:write name='prpLpropDto1' property='depreRate'/>">     
                  <input type="hidden" name="prpLpropRejectReason"     value="<bean:write name='prpLpropDto1' property='rejectReason'/>">  
                  <input type="hidden" name="prpLpropLossRate"         value="<bean:write name='prpLpropDto1' property='lossRate'/>">      
                  <input type="hidden" name="prpLpropVeriRemark"           value="<bean:write name='prpLpropDto1' property='veriRemark'/>">        
                  <input type="hidden" name="prpLpropVeriUnitPrice"    value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                  <input type="hidden" name="prpLpropVeriUnit"         value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                  <input type="hidden" name="prpLpropVeriDepreRate"    value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                  <input type="hidden" name="prpLpropVeriSumLoss"      value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">     
                  <input type="hidden" name="prpLpropVeriSumReject"    value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">   
                  <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                  <input type="hidden" name="prpLpropVeriLossRate"     value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
                  <input type="hidden" name="prpLpropVeriSumDefLoss"   value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">  
                  <input type="hidden" name="prpLpropFlag"             value="<bean:write name='prpLpropDto1' property='flag'/>">   
                  <input type="hidden" name="prpLpropCompensateBackFlag" value="<bean:write name='prpLpropDto1' property='compensateBackFlag'/>">   
                </td>
              </tr>  
<%
              } else {          
%>  
              <tr>
                <td class="input" style="width:8%">  
                  <input type="hidden"  name="prpLpropSerialNo" description="序号" value="<bean:write name='prpLpropDto1' property='serialNo'/>">   
                  <input type="input" name="prpLpropKindCode" class="codecode" style='width:100%<%=compensatebackStyleO%>'  <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='kindCode'/>"
                 <%  if (compensatebackReadOnlyO.equals("")){%>
 
                      ondblclick= "code_CodeSelect(this,'PolicyKindCodeForProp');"
                      onchange="code_CodeChange(this,'PolicyKindCodeForProp');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCodeForProp');"
                       <%}%>
			             
			             >          
                </td>
                <td class="input" style="width:12%">   
                    <input type="input" name="prpLpropKindName" class="codename" style='width:100%<%=compensatebackStyleO%>' <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto1' property='kindName'/>"
  			                <%  if (compensatebackReadOnlyO.equals("")){%>
 
  			             ondblclick="code_CodeSelect(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             onchange="code_CodeChange(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             onkeyup= "code_CodeSelect(this, 'PolicyKindCodeForProp','-1','name','none','post');"
  			             <%}%>
			             
			             >                  
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropLossItemName" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='lossItemName'/>">
                </td>
                <td class="input" style="width:16%">
                  <html:select name="prpLpropDto1" property="feeTypeCode" style="width:100%">
                    <html:options collection="FeeTypeCodeList"  property="value" labelProperty="label"/>          
                  </html:select>
                </td> 
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumLoss" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumLoss'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumReject" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumReject'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:12%">                
                  <input name="prpLpropSumDefLoss" class=readonly readonly style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='sumDefLoss'/>" onBlur="initSet();">
                </td>
                <td class="input" style="width:12%">                   
                  <input name="prpLpropRemark" class=common style='width:100%<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto1' property='remark'/>">
                </td>                
                <td class="input" style='width:4%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete"  backFlag="1" class=smallbutton  <%=compensatebackDiasableO%> onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                </div>
                  <input type="hidden" name="prpLpropItemKindNo"       value="<bean:write name='prpLpropDto1' property='itemKindNo'/>">    
                  <input type="hidden" name="prpLpropFamilyNo"         value="<bean:write name='prpLpropDto1' property='familyNo'/>">      
                  <input type="hidden" name="prpLpropFamilyName"       value="<bean:write name='prpLpropDto1' property='familyName'/>">    
                  <input type="hidden" name="prpLpropItemCode"        value="<bean:write name='prpLpropDto1' property='itemCode'/>">      
                  <input type="hidden" name="prpLpropLossItemCode"     value="<bean:write name='prpLpropDto1' property='lossItemCode'/>">  
                 
                
                  <logic:notEmpty name='prpLpropDto1' property='currency' >
                  <input type="hidden" name="prpLpropCurrency"         value="<bean:write name='prpLpropDto1' property='currency'/>"> 
                  </logic:notEmpty>
                  <logic:empty name='prpLpropDto1' property='currency'>
                  <input type="hidden" name="prpLpropCurrency"         value="CNY">
                  </logic:empty>    
                  <input type="hidden" name="prpLpropUnitPrice"        value="<bean:write name='prpLpropDto1' property='unitPrice'/>">     
                  <input type="hidden" name="prpLpropLossQuantity"     value="<bean:write name='prpLpropDto1' property='lossQuantity'/>">  
                  <input type="hidden" name="prpLpropUnit"             value="<bean:write name='prpLpropDto1' property='unit'/>">          
                  <input type="hidden" name="prpLpropBuyDate"          value="<bean:write name='prpLpropDto1' property='buyDate'/>">       
                  <input type="hidden" name="prpLpropDepreRate"        value="<bean:write name='prpLpropDto1' property='depreRate'/>">     
                  <input type="hidden" name="prpLpropRejectReason"     value="<bean:write name='prpLpropDto1' property='rejectReason'/>">  
                  <input type="hidden" name="prpLpropLossRate"         value="<bean:write name='prpLpropDto1' property='lossRate'/>">      
                  <!--  <input type="hidden" name="prpLpropVeriRemark"       value="<bean:write name='prpLpropDto1' property='veriRemark'/>">       -->
                  <input type="hidden" name="prpLpropVeriUnitPrice"    value="<bean:write name='prpLpropDto1' property='veriUnitPrice'/>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto1' property='veriLossQuantity'/>">
                  <input type="hidden" name="prpLpropVeriUnit"         value="<bean:write name='prpLpropDto1' property='veriUnit'/>">        
                  <input type="hidden" name="prpLpropVeriDepreRate"    value="<bean:write name='prpLpropDto1' property='veriDepreRate'/>">   
                  <!--  <input type="hidden" name="prpLpropVeriSumLoss"      value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">    -->
                  <!--  <input type="hidden" name="prpLpropVeriSumReject"    value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">    -->
                  <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto1' property='veriRejectReason'/>">
                  <input type="hidden" name="prpLpropVeriLossRate"     value="<bean:write name='prpLpropDto1' property='veriLossRate'/>">    
                  <!--  <input type="hidden" name="prpLpropVeriSumDefLoss"   value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">   -->
                  <input type="hidden" name="prpLpropFlag"             value="<bean:write name='prpLpropDto1' property='flag'/>">   
                  <input type="hidden" name="prpLpropCompensateBackFlag" value="<bean:write name='prpLpropDto1' property='compensateBackFlag'/>">   
                
                </td>
              </tr>  
              
              
              <tr>
                <td class="input" colspan="4"> &nbsp;</td>
                <td class="input">                
                  <input name="prpLpropVeriSumLoss" class="readonly" readonly style='width:100%'  maxlength=40 value="<bean:write name='prpLpropDto1' property='veriSumLoss'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropVeriSumReject" class="readonly" readonly style='width:100%'  maxlength=40 value="<bean:write name='prpLpropDto1' property='veriSumReject'/>">
                </td>
                <td class="input">                
                  <input name="prpLpropVeriSumDefLoss" class="readonly" readonly style='width:100%'  maxlength=40 value="<bean:write name='prpLpropDto1' property='veriSumDefLoss'/>">
                </td>
                <td class="input">                   
                  <input name="prpLpropVeriRemark" class="readonly" readonly style='width:100%'  maxlength=40 value="<bean:write name='prpLpropDto1' property='veriRemark'/>">
                </td>                
                <td class="input" style='width:4%'  align="center">&nbsp;</td>
              </tr>  

<%
              }      
%>                     
<%    indexCertainLoss++; %>
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 
        </table>    
        </span>    
  
  <table border="0" align="center" cellpadding="4" cellspacing="1"  class="title" width="100%">
    <tr>
      <td class='title' width="33%">受损金额合计:<input class='readonly' readonly="true" style='width:80px' name='prpLpropSumSumLoss'>
      </td>    
      <td class='title' width="33%">剔除金额合计:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumReject'>
      </td>  
      <td class='title' width="33%">定损金额合计:<input class='readonly'  readonly="true" style='width:80px' name='prpLpropSumSumDefLoss'>
      </td>        
    </tr>
<%
	if(flag==null||flag.length()<1){
%>
	
    	<input type="hidden" style="width:80px" name="prpLpropSumVeriSumLoss">
    	<input type="hidden" style="width:80px" name="prpLpropSumVeriSumReject">
    	<input type="hidden" style="width:80px" name="prpLpropSumVeriSumDefLoss">
   
<%		
	}else{
%>
	<tr>
    	<td class="title" width="33">核定受损金额合计:<input class="readonly" readonly="true" style="width:80px" name="prpLpropSumVeriSumLoss"></td>
    	<td class="title" width="33">核损剔除金额合计:<input class="readonly" readonly="true" style="width:80px" name="prpLpropSumVeriSumReject"></td>
    	<td class="title" width="33">核损金额合计:<input class="readonly" readonly="true" style="width:80px" name="prpLpropSumVeriSumDefLoss"></td>
    </tr>
<%
	}
%>
  </table>  
</span> 