<%--
****************************************************************************
* DESC       ����ʾ(�ǳ���)�����Ǽǵ��ձ������ҳ��
* AUTHOR     ��wangwei
* CREATEDATE ��2005-06-07
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto"%>
<%@ page import="java.util.*"%>
<script language="javascript">
//add by zhaolu 20060908 start
   	/**
     *�����������ӹ���������ڱ������
     */
     function checkBeyondSumAmount(field)
     {
     	  var sumAmount = 0;
     		var feeSumClaim = 0;
     		var errorMessage = "";
     		var findex = getElementOrder(field)-1;
     		sumAmount = parseFloat(fm.prpLclaimLossItemAmount[findex].value);
     		feeSumClaim = parseFloat(field.value);
     		 if(parseFloat(fm.prpLclaimSumClaim.value)>parseFloat(fm.prpLclaimSumAmount.value)){
            alert("������֮�Ͳ��ܴ����ܱ��");
            fm.prpLclaimSumClaim.value = 0;
            field.select();
            return false;
       }
     		if( feeSumClaim > sumAmount )
     		{
     			errorMessage = "�ձ������ܴ��ڱ��� ";
     			alert(errorMessage);
     			field.select();
     			return false;
     		}
     		return true;
     		
     }
      //add by zhaolu 20060908 end   	 
   </script>	

<%  
     //�һ�����Ϣд�������� 2005-09-05
      PrpDexchDto prpDexchDto;
      Collection prpdexchDtoList = (Collection)request.getAttribute("prpdexchDtoList");
      if(prpdexchDtoList!=null)
      {
          Iterator itprpdexch = prpdexchDtoList.iterator();
          while(itprpdexch.hasNext())
          {
              prpDexchDto =  (PrpDexchDto)itprpdexch.next();
              out.println("  <input type=\"hidden\" name=\"baseCurrency\""+
                " value=\""+prpDexchDto.getBaseCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchCurrency\""+
                " value=\""+prpDexchDto.getExchCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchRate\""+
                " value=\""+prpDexchDto.getExchRate()+"\""+"\">");                
          }
      } 
      
   PrpLclaimDto prpLclaimDto1 = (PrpLclaimDto)request.getAttribute("prpLclaimDto"); 
   String    riskCode =  prpLclaimDto1.getRiskCode();
%>

<!--������ʾ��¼����������������ʾ��-->
<table class="common" align="center" width="100%" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="common" colspan="4">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
         <tr>
      <%  if (riskCode.equals("1001")) {%>
             <td class="input" style="width:35%" style="align:center">
                 <input type="hidden" name="prpLclaimLossItemCode" class="codecode" style="width:30%" title="��Ĵ���" value="0000">
                 <input type="hidden" name="prpLclaimLossItemDetailName" class="codecode" style="width:30%" title="�������" >
                 
                  <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:20%" title="�ձ�"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2');" onchange="setFlagDanger();">
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:40%" title="�ձ�"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');" onchange="setFlagDanger();">
                 <input name="prpLclaimLossItemKindNo" type="hidden" value="">
                  <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
                  <input name="prpLclaimLossItemAmount" type="hidden" value="">
              </td>
      <% } else {%>
                 <td class="input" style="width:4%" style="align:center">
                    <input name="prpLclaimLossItemKindNo" type="text"  title="������" class="readonly" readonly="readonly"> 
                 </td>
                  <%  if ("ZH03".equals(riskCode)) {%>
                 <td class="input" style="width:13%" style="align:center">
                 <input type="hidden" name="prpLclaimLossKindCode" class="codecode" title="�ձ����" value="<bean:write name='defaultKindCode'/>"
                 onchange="setFlagDanger();">
                 <input type="input" name="prpLclaimLossKindName" class="codecode" title="�ձ�����" 
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,4','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,4','always','none','post');"
                      onchange="setFlagDanger();">
                 </td>
                 <td class="input" style="width:15%" style="align:center">
                 <input type='input' name='prpLclaimLossItemCode'  class="readonly" readonly="readonly" style="width:20%" title="��Ĵ���"> 
                 <input type='input' name="prpLclaimLossItemDetailName"  class="readonly" readonly="readonly"  style="width:70%" title="�������" >                                                                        
                 <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
                 <input name="prpLclaimLossItemAmount" type="hidden" value="">
                 
                 </td>
                 <% } else {%>
                 <td class="input" style="width:13%" style="align:center">
                 <input type="hidden" name="prpLclaimLossKindCode" class="codecode" title="�ձ����" value="<bean:write name='defaultKindCode'/>"
                 onchange="setFlagDanger();">
                 <input type="input" name="prpLclaimLossKindName" class="codecode" title="�ձ�����" 
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                      onchange="setFlagDanger();">
                 </td>
                <%  if (!riskCode.equals("2204") && !riskCode.equals("2207") && !riskCode.equals("2208") && !"0313".equals(riskCode)) {%>   
                 <td class="input" style="width:15%" style="align:center">
                 <input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');" 
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');" 
                           > 
                 <input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');"
        		    		onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');" >
                 <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
                 <input name="prpLclaimLossItemAmount" type="hidden" value="">
                 
                 </td>
                 <!-- 0313���������IMEI�� add by wangxinyang 2018/6/15 -->
                 <%}else if("0313".equals(riskCode)){%>
                 <td class="input" style="width:15%" style="align:center">
	                 <input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���"
	                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3,4');" 
	                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3,4');"> 
	                 <input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:30%" title="�������"
	                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2,3','always','none','post');"
	        		    		onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2,3','always','none','post');" >
	                 <input type="text" name="prpLclaimLossImei" class="readonly" readonly style="width:40%" title="IMEI��">
	                 <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
	                 <input name="prpLclaimLossItemAmount" type="hidden" value="">
                 </td>
                 <%} else{ %>
	                 <td class="input" style="width:15%" style="display:none">
	                 <input type="hidden" name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���"
	                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');" 
	                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');" 
	                           > 
	                 <input type="hidden" name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������"
	                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');"
	        		    		onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');" >                                                                        
	                 <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
	                 <input name="prpLclaimLossItemAmount" type="hidden" value="">
	                 </td>
                  <% }} %>
                 <%if("ZH01".equals(riskCode) || "ZH02".equals(riskCode) ){ %>
                 		<td class="input" align=left style="width:5%">
			               <input type = "hidden" name = "prpLclaimLossFamilyNo">
			               <input type=text name="prpLclaimLossFamilyName" title="�¹�������" 
			               class="codecode"  title="�¹�������"
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,-2','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,-2','always','none','post');">
          				 </td>
          				 
                 <%}else if("ZH03".equals(riskCode)){%>
                 		<td class="input" align=left style="width:5%">
			               <input type = "hidden" name = "prpLclaimLossFamilyNo" value="<bean:write name='prpLclaimDto' property='remark' filter='true' />">
			               <input type=text name="prpLclaimLossFamilyName" title="�¹�������" 
			               class="codecode"  title="�¹�������"
			               ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
			               onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
			               onblur= "code_CodeChange(this, 'ZH03prpLlossFamilyName','0','code','post','clear');" >
          				 </td>
          <% }}%>            
             
             <!-- 
             <input type="hidden" name="prpLclaimLossItemCode" value="">
             -->
             <input type="hidden" name="prpLclaimLossItemName" value="">
             
             <input name="prpLclaimLossFlag" type="hidden" value="">
             
             <input name="prpLclaimLossFeeCategory"  type="hidden" value="">
             <td class="input" style="width:8%">
                   <select name="prpLclaimLossLossFeeType">
                       <option value="P">���</option>
                       <option value="Z">����</option>
                   </select>        	
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossCurrency" class="codecode" style="width:30%" title="�ұ�" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName" class="codecode" style="width:60%" title="�ұ�" value="<bean:write name='strCurrencyName'  filter='true' />"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
              
             <td class="input" style="width:16%">
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur=" collectClaimLoss();return checkBeyondSumAmount(this);" onchange="setFlagDanger();">
             </td>
             
              <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
              </td> 
             
            <%
                //��õ�ǰʱ��
            %>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate" onblur="checkFullDate(this)"  style="width:85px" maxlength="10"  class=readonly readonly="readonly"
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
             </td>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
             </td>
             
             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type=button name="buttonClaimLossDelete"  class="smallbutton"  onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();" value="-" style="cursor: hand"  >
                 </div>
             </td>
         </tr>
         </tbody>
      </table>
    </span>
    
    <span  id="spanClaimLoss" style="display:" cellspacing="1" cellpadding="0">
     <%-- ��������չ���� --%>
     <table class="common" style="width:100%" id="ClaimLoss" >
       <thead>
         <tr>
         	 <%  if (riskCode.equals("1001")) {%>
         	     <td class="centertitle" style="width:15%">�ձ�</td>
         	 <%}else {%>
         	  <td class="centertitle" style="width:4%">������</td>
         	  <td class="centertitle" style="width:13%">�ձ�</td>
         	 <%  if (!riskCode.equals("2204") && !riskCode.equals("2207")  && !riskCode.equals("2208")) {%>   
              <td class="centertitle" style="width:24%">��Ŀ</td>
             <% }%> 
              <%if("ZH01".equals(riskCode) || "ZH02".equals(riskCode)|| "ZH03".equals(riskCode)){ %>
         	  <td class="centertitle" style="width:4%">�¹�������</td>
         	  <%} %>
            <%}%>  
              <td class="centertitle" style="width:8%">��������</td>
              <td class="centertitle" style="width:8%">�ұ�</td>
              <td class="centertitle" style="width:5%">�ձ������</td>
              <td class="centertitle" style="width:8%">��ֵ</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td class="centertitle" style="width:10%">����ԭ��</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency();"  type="button" class="button"  value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ����������Ҫ�޸ģ���ע���Ӧ��ClaimEdit��Ҫȥ��disabledAllButton(ClaimLoss_button)������-->
         <tr><td colspan="11"><table id="ClaimLoss_button" style="width:100%">
           <tr>
              <td class="title" colspan=11 style="width:91%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
              <td class="title" align="right" style="width:9%">
                 <div align="center">
                    <input type="button" value="+" onclick="insertRow('ClaimLoss');setFlagDanger();onload0310();"  class="smallbutton"  name="buttonDriverInsert" style="cursor: hand"  >
                 </div>
              </td>
           </tr>
         </table></td></tr>
      </tfoot>
   
      <tbody>
     <% int indexClaimLoss=0;%>
 <% String displayType="readonly"; %>
 <% String buttonType="disabled"; %>
 <% String strReadOnly = "readonly"; %>

 <%
  if (editType.equals("ADD")){
  displayType="";
  buttonType="";
  strReadOnly="common";}
%>
<% 
  if (editType.equals("EDIT")){
  displayType="";
  buttonType="disabled";}
%>    
      
       <logic:iterate id="prpLclaimLossDto"  name="claimDto"  property="prpLclaimLossDtoList">
         <tr>
              <%  if (riskCode.equals("1001")) {%>
               <td class="input" style="width:35%" style="align:center">
                <input type="hidden" name="prpLclaimLossItemCode" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true' />">
                <input type="hidden" name="prpLclaimLossItemDetailName" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true' />">
              
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:20%" title="�ձ�"  value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true'/>"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2');"
                      onchange="setFlagDanger();">
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:40%" title="�ձ�"  value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true'/>"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onchange="setFlagDanger();">
                 <input name="prpLclaimLossItemKindNo" type="hidden" value="">
                 <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
                  <input name="prpLclaimLossItemAmount" type="hidden" value="">
              </td>
           <%}else {%>
             <td class="input" style="width:4%" style="align:center">
              <input name="prpLclaimLossItemKindNo" type="text"  title="������" class="readonly" readonly="readonly" value="<bean:write name='prpLclaimLossDto' property='itemKindNo'/>">
              </td>
              <%  if (riskCode.equals("ZH03")) {%>
              <td class="input" style="width:13%" style="align:center">
               <input type="hidden" name="prpLclaimLossKindCode" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />">
               <input type="input" name="prpLclaimLossKindName" class="codecode" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,4','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,4','always','none','post');"
                       onchange="setFlagDanger();">
              </td>
              <td class="input" style="width:13%" style="align:center">
               <input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true'/>">
               <input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true'/>">
               <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
               <input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount'/>">
            </td>
            <%}else{%>
            <td class="input" style="width:13%" style="align:center">
               <input type="hidden" name="prpLclaimLossKindCode" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />">
               <input type="input" name="prpLclaimLossKindName" class="codecode" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                       onchange="setFlagDanger();">
              </td>
            <%  if (!riskCode.equals("2204") && !riskCode.equals("2207")  && !riskCode.equals("2208") && !"0313".equals(riskCode)) {%> 
              <td class="input" style="width:13%" style="align:center">
               <input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');"
                            onchange="setFlagDanger();">
               <input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');"
        		    onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');"
        		    onchange="setFlagDanger();">
               <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
               <input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount'/>">
            </td>
            <!-- 0313���������IMEI�� add by wangxinyang 2018/6/15 -->
            <%}else if("0313".equals(riskCode)){%>
            <td class="input" style="width:15%" style="align:center">
				<input type='input' name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���"
						value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true'/>"
						ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3,4');" 
						onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3,4');"> 
				<input type='input' name="prpLclaimLossItemDetailName" class="codename"  style="width:30%" title="�������"
						value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true'/>"
						ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2,3','always','none','post');"
						onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2,3','always','none','post');" >
				<input type="text" name="prpLclaimLossImei" class="readonly" readonly style="width:40%" title="IMEI��"
						value="<bean:write name='prpLclaimLossDto' property='imei'/>">
				<input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
				<input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount'/>">
            </td>
            <%}else{ %>
               <td class="input" style="width:13%" style="display:none">
               <input type="hidden" name='prpLclaimLossItemCode' class="codecode" style="width:20%" title="��Ĵ���" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','1,2,3');"
                            onchange="setFlagDanger();">
               <input type="hidden" name="prpLclaimLossItemDetailName" class="codename"  style="width:70%" title="�������" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');"
        		    onkeyup= "code_CodeSelect(this, 'PolicyItemKindCodeNoRisk','-1,1,2','always','none','post');"
        		    onchange="setFlagDanger();">
               <input name="prpLclaimLossItemAmountDisplay" type="hidden" value="">
               <input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount'/>">
               </td>
             <%}}%>
               <%if("ZH01".equals(riskCode) || "ZH02".equals(riskCode) ){ %>
                 		 <td class="input" align=left style="width:5%">
			               <input type = "hidden" name = "prpLclaimLossFamilyNo" value="<bean:write name='prpLclaimLossDto' property='familyNo' filter='true' />">
			               <input type=text name="prpLclaimLossFamilyName" title="�¹�������"  value="<bean:write name='prpLclaimLossDto' property='familyName' filter='true' />"
			               class="codecode"  title="�¹�������"
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,-2','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,-2','always','none','post');">
			           </td>
			            
                 <%}else if("ZH03".equals(riskCode)){%>
                          <td class="input" align=left style="width:5%">
			               <input type = "hidden" name = "prpLclaimLossFamilyNo" value="<bean:write name='prpLclaimDto' property='remark' filter='true' />">
			               <input type=text name="prpLclaimLossFamilyName" title="�¹�������"  value="<bean:write name='prpLclaimLossDto' property='familyName' filter='true' />"
			               class="codecode"  title="�¹�������"
			               ondblclick="code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
			               onkeyup= "code_CodeSelect(this, 'ZH03prpLlossFamilyName','','code','none','post');"
			               onblur= "code_CodeChange(this, 'ZH03prpLlossFamilyName','0','code','post','clear');" >
			           </td>
            <%}}%>  
          
           
           <!-- 
           <input type="hidden" name="prpLclaimLossItemCode" value="">
           -->
           <input type="hidden" name="prpLclaimLossItemName" value="">
           
               <td class="input"  style="width:10%">
             <select name="prpLclaimLossLossFeeType">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
              </select>
           </td>
           <td class="input" style="width:12%" align="center">
                <input type="text" name="prpLclaimLossCurrency"  value="<bean:write name='prpLclaimLossDto' property='currency' filter='true' />"
                                  class="codecode" style="width:30%" title="�ұ�"
                                  ondblclick="code_CodeSelect(this, 'Currency');"
                                  onkeyup= "code_CodeSelect(this, 'Currency');">
                <input type=text name="prpLclaimLossCurrencyName" value="<bean:write name='prpLclaimLossDto' property='currencyName' filter='true' />"
                                   class="codecode" style="width:60%" title="�ұ�"
                                   ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
           </td>
      
           <td class="input" style="width:12%">
               <input name="prpLclaimLossSumClaim" class="<%=strReadOnly%>" style="text-align:right" onblur=" collectClaimLoss();return checkBeyondSumAmount(this);" value="<bean:write name='prpLclaimLossDto' format="0.00" property='sumClaim' filter='true' />" 
               onchange="setFlagDanger();">
           </td>
           
           <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class="<%=strReadOnly%>" style="width:50px" value="<bean:write name='prpLclaimLossDto' property='kindRest' filter='true' />">
              </td> 
           
           <td class="input" style="width:10%">
               <input name="prpLclaimLossInputDate" readonly onblur="checkFullDate(this)" style="width:85px" maxlength="10" class="<%=strReadOnly%>"
                  value="<bean:write name='prpLclaimLossDto' property='inputDate' filter='true' />">
           </td>
           <td class="input" style="width:10%">
               <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100"  value="<bean:write name='prpLclaimLossDto' property='remarkFlag' filter='true' />">
               <input name="prpLclaimLossFlag" type="hidden" value="<bean:write name='prpLclaimLossDto' property='flag' filter='true' />">
               <input name="prpLclaimLossFeeCategory" type="hidden" value="<bean:write name='prpLclaimLossDto' property='feeCategory' filter='true' />">
           </td>
           <td class="input" style='width:4%' colspan="2" align="center">
               <div>
                 <input type=button name="buttonClaimLossDelete" class="smallbutton" onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();"  <%=buttonType%> value="-" style="cursor: hand">
               </div>
           </td>
         </tr>
       </logic:iterate>
       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>