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
<%
  String settleListCode=(String)request.getAttribute("settleListCode");
  if(!"".equals(settleListCode)&&null!=settleListCode){
	  
  }else{
	  settleListCode="";
  }
%>
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
              }
          }
      }
      /**
      * Ԥ�����嵥ҳ�浯��
      */
      function openSettleListPage(editType,nodeType){
      	var policyNo = fm.prpLclaimPolicyNo.value;
		var registNo = fm.registno.value;
      	var newWindow = window.open("/claim/settleList.do?policyNo=" +policyNo+ "&registNo=" +registNo+"&nodeType="+nodeType+"&editType="+editType+"&isFirst=isFirst","NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
      }
    </script>   
    <input type="hidden" name= "prpLclaimPolicyNo"  value="<bean:write name='prpLregistDto' property='policyNo'/>">
    <input type="hidden" name= "prpLverifyLossRiskCode"  value="<bean:write name='prpLregistDto' property='riskCode'/>">
    <input type="hidden" name= "prpLverifyLossLossItemCode"  value="-2">
  <span  id="SpanProp" style="display:" cellspacing="1" cellpadding="0">
  <table class=common cellpadding="5" cellspacing="1">

  </table> 
        <span style="display:none"> 
          <table class="common" style="display:none" id="Prop_Data" cellpadding="5" cellspacing="1">
            <tbody>
            <input type="hidden" name="prpLpropLossItemCode" value="-2">
              <tr>
                <td class="input" style="width:20%">
                  <input type = "hidden" name = "prpLpropFamilyCode">
                  <input type= "hidden" name= "prpLpropFamilyNo">
                  <input type=text name="prpLpropFamilyName" title="�¹�������" 
			                  class="codecode" 
			                  ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
			                  onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                  <input type= "hidden" name= "prpLpropPersonSex">
                  <input type= "hidden" name= "prpLpropPersonAge">
                  <input type= "hidden" name= "prpLpropPersonIdentifyNumber">
                  
                </td>
                <td class="input" style="width:20%">
                    <input type="hidden" name= "temp1" description="һ������ֵ�������治�õ���Ϣ">     
                    <input type="hidden"  name="prpLpropSerialNo" description="���">   
                    <input type="hidden"  name="prpLpropKindCode" class="codecode" >         
                    <input type="input" name="prpLpropKindName" class="codename" 
                     ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post');"
                     onchange="code_CodeChange(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post');">         
                <input type="hidden" name="prpLpropItemKindNo">
                </td>
                <td class="input" style="width:15%">
                  <input type="hidden" name="prpLpropItemCode">                
                  <input name="prpLpropLossItemName" class=common   maxlength=40>
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLpropSumLoss" class=common   maxlength=40 onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">               
                  <input name="prpLpropSumReject" class=common   maxlength=40 onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLpropSumDefLoss" class=readonly readonly  maxlength=40 onBlur="initSet();">
                </td>
                <td class="input" style="width:10%">              
                  <input name="prpLpropRemark" class=common   maxlength=40>
                </td>                
                <td class="input" style='width:5%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete"  class="smallbutton" onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                </div>
                 
                
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
        
        <span id=""  cellspacing="1" cellspacing="0"  width="100%">
        <table class="common" cellpadding="2" cellspacing="1" >
        <%
        String disableEditSettleList = "disabled";
        String disableViewSettleList = "disabled";
        if("ADD".equalsIgnoreCase(editType) || "EDIT".equalsIgnoreCase(editType))
        	disableEditSettleList = "";
        else disableViewSettleList = "";
        //if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3186,3149,3150,3151,3152,3153,3154,3155,3156".indexOf(riskCode) > -1)){%>
        <%-- <tr id="trSettleList">
        	<td align="center" class="title">
        		�����嵥��
        	</td>
        	<td class="input">
        		<input type="text" name="settleListCode" class="input" value="<%=settleListCode==null?"":settleListCode %>"  readonly/>
        	</td>
        	<td align="center" class="title" >
        		<input type="button" name="editSettleListButton" class='bigbutton' value="Ԥ���������嵥" <%=disableEditSettleList %> onclick="openSettleListPage('edit','check'); return false;"/>
        	</td>
        	<td align="center" class="title" >
        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList %>  onclick="openSettleListPage('view','check'); return false;"/>
        	</td>
        </tr> --%>
        <%//} 
        %>
        <tr>
        </span>
        <span  id="spanProp" cellspacing="1" cellspacing="0"  width="100%">
        <%-- ��������չ���� --%>
        <table class="common"  id="Prop" cellpadding="5" cellspacing="1">
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
                   <input type="button" value="+" class=smallbutton onclick="insertRow('Prop')" name="buttonDriverInsert" style="cursor: hand">
                 </div>
               </td>
            </tr>
          </tfoot>
          <tbody>
<% String compensatebackReadOnlyO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String compensatebackDiasableO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>
<% String compensatebackStyleO=""; //������������˻صģ���ô���м�¼��Ӧ����ʾ����ֻ����%>


<logic:notEmpty  name="prpLpropDtoList"> 
<logic:iterate id="prpLpropDto" name="prpLpropDtoList">
<%   //���������˻ص��ж�
          compensatebackReadOnlyO="";
          compensatebackDiasableO="";
          compensatebackStyleO="";
%>          
        <logic:equal name='prpLpropDto' property='compensateBackFlag' value="1">
      <%      compensatebackStyleO=";background:#CECECE";
              compensatebackReadOnlyO="readOnly";
              compensatebackDiasableO="disabled";
          %>
       </logic:equal>   

              <tr>
                <td class="input" style="width:50%">
                  <input type = "hidden" name = "prpLpropFamilyCode">
                       <input type= "hidden" name= "prpLpropFamilyNo" value="<bean:write name='prpLpropDto' property='familyNo'/>">
                  <input type="input" name="prpLpropFamilyName" 
                  class="codename"  title="�¹�������" 
                  style='width:110px<%=compensatebackStyleO%>'  <%=compensatebackReadOnlyO%>
                  value="<bean:write name='prpLpropDto' property='familyName'/>"
                  <%  if (compensatebackReadOnlyO.equals("")){%>
                  ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                  onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
                  <%}%>
                  >
                  <input type= "hidden" name= "prpLpropPersonSex">
                  <input type= "hidden" name= "prpLpropPersonAge">
                  <input type= "hidden" name= "prpLpropPersonIdentifyNumber">
             
                </td>
                <td class="input" style="width:50%">
                     <input type="hidden" name= "temp2" description="һ������ֵ�������治�õ���Ϣ">      
                     <input type="hidden"  name="prpLpropSerialNo" description="���" value="<bean:write name='prpLpropDto' property='serialNo'/>">   
                     <input type="hidden" name="prpLpropKindCode" class="codecode" style='width:30px<%=compensatebackStyleO%>'  <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto' property='kindCode'/>">          
                   
                    <input type="input" name="prpLpropKindName" class="codename" style='width:80px<%=compensatebackStyleO%>' <%=compensatebackReadOnlyO%> value="<bean:write name='prpLpropDto' property='kindName'/>"
                        <%  if (compensatebackReadOnlyO.equals("")){%>
                     ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post');"
                     onchange="code_CodeChange(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,1,-3,2,3','always','none','post');"
                     <%}%>
                     >    
                     <input type="hidden" name="prpLpropItemKindNo"       value="<bean:write name='prpLpropDto' property='itemKindNo'/>">                  
                </td>
                <td class="input" style="width:15%">
                 <input type="hidden" name="prpLpropItemCode"         value="<bean:write name='prpLpropDto' property='itemCode'/>">                    
                  <input name="prpLpropLossItemName" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto' property='lossItemName'/>">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLpropSumLoss" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto' format="0.00" property='sumLoss'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLpropSumReject" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto' format="0.00" property='sumReject'/>" onBlur="getSumPropDefLoss(this);initSet();">
                </td>
                <td class="input" style="width:10%">                
                  <input name="prpLpropSumDefLoss" class=readonly readonly style='width:80px<%=compensatebackStyleO%>'  maxlength=40 <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto' format="0.00" property='sumDefLoss'/>" onBlur="initSet();">
                </td>
                <td class="input" style="width:10%">                   
                  <input name="prpLpropRemark" class=common style='width:80px<%=compensatebackStyleO%>'  maxlength="40" onblur="checkLength1(this);" description="��ע" <%=compensatebackReadOnlyO%>  value="<bean:write name='prpLpropDto' property='remark'/>">
                </td>                
                <td class="input" style='width:5%'  align="center">
                <div>
                  <input type=button name="buttonPropDelete"  class=smallbutton  <%=compensatebackDiasableO%> onclick="deleteRow(this,'Prop')" value="-" style="cursor: hand">
                </div>
                    
                  <input type="hidden" name="prpLpropLossItemCode"     value="-2">  
                  <input type="hidden" name="prpLpropCurrency"         value="<bean:write name='prpLpropDto' property='currency'/>">       
                  <input type="hidden" name="prpLpropUnitPrice"        value="<bean:write name='prpLpropDto' property='unitPrice'/>">     
                  <input type="hidden" name="prpLpropLossQuantity"     value="<bean:write name='prpLpropDto' property='lossQuantity'/>">  
                  <input type="hidden" name="prpLpropUnit"             value="<bean:write name='prpLpropDto' property='unit'/>">          
                  <input type="hidden" name="prpLpropBuyDate"          value="<bean:write name='prpLpropDto' property='buyDate'/>">       
                  <input type="hidden" name="prpLpropDepreRate"        value="<bean:write name='prpLpropDto' property='depreRate'/>">     
                  <input type="hidden" name="prpLpropRejectReason"     value="<bean:write name='prpLpropDto' property='rejectReason'/>">  
                  <input type="hidden" name="prpLpropLossRate"         value="<bean:write name='prpLpropDto' property='lossRate'/>">      
                  <input type="hidden" name="prpLpropVeriRemark"       value="<bean:write name='prpLpropDto' property='veriRemark'/>">        
                  <input type="hidden" name="prpLpropVeriUnitPrice"    value="<bean:write name='prpLpropDto' property='veriUnitPrice'/>"> 
                  <input type="hidden" name="prpLpropVeriLossQuantity" value="<bean:write name='prpLpropDto' property='veriLossQuantity'/>">
                  <input type="hidden" name="prpLpropVeriUnit"         value="<bean:write name='prpLpropDto' property='veriUnit'/>">        
                  <input type="hidden" name="prpLpropVeriDepreRate"    value="<bean:write name='prpLpropDto' property='veriDepreRate'/>">   
                  <input type="hidden" name="prpLpropVeriSumLoss"      value="<bean:write name='prpLpropDto' property='veriSumLoss'/>">     
                  <input type="hidden" name="prpLpropVeriSumReject"    value="<bean:write name='prpLpropDto' property='veriSumReject'/>">   
                  <input type="hidden" name="prpLpropVeriRejectReason" value="<bean:write name='prpLpropDto' property='veriRejectReason'/>">
                  <input type="hidden" name="prpLpropVeriLossRate"     value="<bean:write name='prpLpropDto' property='veriLossRate'/>">    
                  <input type="hidden" name="prpLpropVeriSumDefLoss"   value="<bean:write name='prpLpropDto' property='veriSumDefLoss'/>">  
                  <input type="hidden" name="prpLpropFlag"             value="<bean:write name='prpLpropDto' property='flag'/>">   
                  <input type="hidden" name="prpLpropCompensateBackFlag" value="<bean:write name='prpLpropDto' property='compensateBackFlag'/>">   
                </td>
              </tr>  
                        
      </logic:iterate> 
      </logic:notEmpty>         
          </tbody>                 
        </table>    
        </span>    
  
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