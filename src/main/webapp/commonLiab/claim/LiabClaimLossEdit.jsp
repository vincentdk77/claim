<%--
****************************************************************************
* DESC       ����ʾ�����Ǽǵ��ձ������ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-06-24
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@ page import="java.util.*"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpLclaimDto"%>
<script language="javascript">
//add by zhaolu 20060908 start
   	/**
     *�����������ӹ���������ڱ������
     */
     function checkBeyondSumAmount(field)
     {
     	  var sumAmount = 0;
     		var feeSumClaim = 0;
     		var ItemAmount = 0;
     		var ItemClaimLoss = 0; 
     		var findex = 0;
     		var errorMessage = "";
     		sumAmount = parseFloat(fm.prpLclaimSumAmount.value);
     		feeSumClaim = parseFloat(fm.prpLclaimSumClaim.value);
     		
     		findex = getElementOrder(field)-1;
     		ItemAmount = parseFloat(fm.prpLclaimLossItemAmount[findex].value);
     		if(isNaN(ItemAmount))
        {
           ItemAmount = 0;
        }
     		ItemClaimLoss = parseFloat(field.value);
     		if( feeSumClaim > sumAmount )
     		{
     			errorMessage = "�ܹ�����ܴ����ܱ��� ";
     			alert(errorMessage);
     			field.select();
     			return false;
     		}
     		if(ItemClaimLoss > ItemAmount){
     		  errorMessage = "�ձ������ܴ����ձ𱣶� ";
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
<%
       if(riskCode.equals("1528")){
%>
                      <td class="input" align=left style="width:20%;align:center">
                     
		               <input type=text name="prpLclaimLossBrandCode" title="���������ͺ�" 
		               class="codecode"   style="width:40%"
		               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');"
		               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');">
		               
		               <input type=text name="prpLclaimLossCarNumber" title="�������" 
		               class="codecode"  style="width:50%"
		               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');"
		               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');">
		                 
		               <input type = "hidden" name = "prpLclaimLossFamilyNo" >
		           </td>
<%
       }
%>

		     <td class="input" style="width:4%" style="align:center">
                 <input name="prpLclaimLossItemKindNo" type="text" class="readonly" readonly="readonly">
              </td>
             <td class="input" style="width:26%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:30%" title="�ձ�"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,-1,2,3,4','code','none','post');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,-1,2,3,4','code','none','post');"
                       onchange="setFlagDanger();">
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:30%" title="�ձ�"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
                       onchange="setFlagDanger();">
                 <input type='hidden' name='prpLclaimLossItemCode' class="codecode">
                 <input type='text' name="prpLclaimLossItemDetailName" class="codename" readonly="true" style="width:30%" title="���">
                 <input name="prpLclaimLossItemAmount" type="hidden" value="">
              </td>
            <td class="input" style="width:10%" >
            <%/*
             <html:select name='claimLoss'  property='flag' style="width:60px" >
                  <html:option value="0" selected >����</html:option>
                  <html:option value="1">����</html:option>
             </html:select>
            */%>
                   <select name="prpLclaimLossLossFeeType">
                       <option value="P">���</option>
                       <option value="Z">����</option>
                   </select>  
            <input type="hidden" name="prpLclaimLossFlag" class="input" readonly="true" style="width:60%" value="1">
            <input name="prpLclaimLossFeeCategory" type="hidden" value="">
            
            </td>
             <td class="input" style="width:20%" align="center">
                 <input type="text" name="prpLclaimLossCurrency"  class="codecode"  style="width:30%" title="�ұ�" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />"
                        ondblclick="code_CodeSelect(this, 'Currency');"
                        onkeyup= "code_CodeSelect(this, 'Currency');">
                 <input type="text" name="prpLclaimLossCurrencyName" class="codecode"  style="width:60%" value="<bean:write name='strCurrencyName'  filter='true' />"
                        ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                        onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
             <td class="input" style="width:16%">
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur="collectClaimLoss();return checkBeyondSumAmount(this);"
                  onchange="setFlagDanger();">
             </td>

              
                <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
              </td> 
            

             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate" onblur="checkFullDate(this)"  style="width:85px" maxlength="10" class="readonly" readonly
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
                   <!--
                 <input name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10" >
                   -->
             </td>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
             </td>

             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type=button name="buttonClaimLossDelete"  class="smallbutton" onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();" value="-" style="cursor: hand">
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
              <%if("1528".equals(riskCode) ){ %>
         	  <td class="centertitle" style="width:20%">�¹��߳���</td>
         	  <%} %>
        	  <td class="centertitle" style="width:4%">������</td>
              <td class="centertitle" style="width:26%">�ձ�</td>
              <td class="centertitle" style="width:10%">�������</td>
              <td class="centertitle" style="width:20%">�ұ�</td>
              <td class="centertitle" style="width:16%">�ձ������</td>
              <td class="centertitle" style="width:8%">��ֵ</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td class="centertitle" style="width:10%">����ԭ��</td>
              <td  class="centertitle"  style="width:4%">
                 <input  onclick="collectCurrency();"  class="button" type="button" value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ����������Ҫ�޸ģ���ע���Ӧ��ClaimEdit��Ҫȥ��disabledAllButton(ClaimLoss_button)������-->
         <tr><td colspan="10"><table id="ClaimLoss_button" style="width:100%">
           <tr>
              <td class="title" colspan=6 style="width:91%">(��"+"�ż����ӵ�֤��Ϣ����"-"�ż�ɾ����Ϣ)</td>
              <td class="title" align="right" style="width:9%">
                 <div align="center">
                    <input type="button" value="+" class="smallbutton" onclick="insertRow('ClaimLoss');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand"  >
                 </div>
              </td>
           </tr>
         </table></td></tr>
      </tfoot>

    <tbody>
 <% int indexClaimLoss=0;%>
 <% String displayType="readonly"; %>
 <% String buttonType="disabled"; %>

 <%
  if (editType.equals("ADD")){
  displayType="";
  buttonType="";}
%>
<% 
  if (editType.equals("EDIT")){
  displayType="";
  buttonType="disabled";}
%>  
    <logic:iterate id="claimLoss"  name="claimDto"  property="prpLclaimLossDtoList">
<%
    if(indexClaimLoss %2== 0)
        out.print("<tr class=oddrow>");
    else
        out.print("<tr class=oddrow>");


//modify by lixiang add 20050316 start
//reason:���������

%>
		<%
		       if(riskCode.equals("1528")){
		%>
		            <td class="input" align=left style="width:20%;align:center">
                    
		               <input type=text name="prpLclaimLossBrandCode" title="���������ͺ�" 
		               class="codecode"  style="width:40%"   value="<bean:write name='claimLoss' property='itemDetailName' filter='true' />"
		               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');"
		               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');">
		               
		               <input type=text name="prpLclaimLossCarNumber" title="�������" 
		               class="codecode"   style="width:50%" value="<bean:write name='claimLoss' property='licenseNo' filter='true' />"
		               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');"
		               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');">
		                
		               <input type = "hidden" name = "prpLclaimLossFamilyNo" value="<bean:write name='claimLoss' property='familyNo' filter='true' />" >
		           </td>
		<%
		       }
		%>

          <td class="input" style="width:4%" style="align:center">
                 <input type="text" name="prpLclaimLossItemKindNo"   value="<bean:write name='claimLoss' property='itemKindNo'/>" class="readonly" readonly="readonly">
          </td>
             <td class="input" style="width:26%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" <%=displayType%> style="width:30%" title="�ձ�"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,-1,2,3,4','code','none','post');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,-1,2,3,4','code','none','post');"
                       onchange="setFlagDanger();"
                      value="<bean:write name='claimLoss' property='kindCode'/>">
                 <input type=text name="prpLclaimLossKindName" class="codecode" <%=displayType%> style="width:30%" title="�ձ�"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
                       onchange="setFlagDanger();"
                      value="<bean:write name='claimLoss' property='kindName'/>">
                 <input type='hidden' name='prpLclaimLossItemCode' class="codecode" value="<bean:write name='claimLoss' property='itemCode'/>">
                 <input type='text' name="prpLclaimLossItemDetailName" class="codename" readonly="true" style="width:30%" title="���"> 
                 <input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='claimLoss' property='itemAmount'/>">
          </td>
          <td class="input" style="width:10%" >
          <%/*
         <html:select name='claimLoss' disabled property='flag' style="width:60px" >
             <html:option value="0" >����</html:option>
             <html:option value="1">����</html:option>
         </html:select>
         */%>
          <select name="prpLclaimLossLossFeeType">
                 <option value="P" <logic:equal name="claimLoss" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="claimLoss" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
          </select>
         <input type="hidden" name="prpLclaimLossFlag" class="input" readonly="true" style="width:60%" value="1">
         <input name="prpLclaimLossFeeCategory" type="hidden" value="<bean:write name='claimLoss' property='feeCategory' filter='true' />">
         
         </td>
         <td class="input" style="width:20%" align="center">
              <input type=text name="prpLclaimLossCurrency" class="codecode"  style="width:30%" title="�ұ�" value="<bean:write name='claimLoss' property='currency'/>"
                      ondblclick="code_CodeSelect(this, 'Currency');"
                      onkeyup= "code_CodeSelect(this, 'Currency');">
              <input type=text name="prpLclaimLossCurrencyName" class="codecode"  style="width:60%" title="�ұ�"  value="<bean:write name='claimLoss' property='currencyName'/>"
                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
         </td>

         <td class="input" style="width:16%">
             <input name="prpLclaimLossSumClaim" class=common <%=displayType%> style="text-align:right" value="<bean:write name='claimLoss' property='sumClaim' format="0.00" />"  onblur=" collectClaimLoss();return checkBeyondSumAmount(this);"
              onchange="setFlagDanger();">
         </td>
         
           <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px" value="<bean:write name='claimLoss' property='kindRest' format="0.00" />">
           </td> 

         <td class="input" style="width:10%">
             <input name="prpLclaimLossInputDate" onblur="checkFullDate(this)" readonly style="width:85px" maxlength="10" value="<bean:write name='claimLoss' property='inputDate' />">
         </td>
         <td class="input" style="width:10%">
             <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100" value="<bean:write name='claimLoss' property='remarkFlag' />">
         </td>
 <%//modify by lixiang add 20050316 end%>
          <td class="input" style='width:4%' align="center">
              <div>
                <input type=button name="buttonClaimLossDelete"  class="smallbutton" onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();" <%=buttonType%> value="-" style="cursor: hand"  >
              </div>
          </td>
       </tr>
 <%    indexClaimLoss++;%>
       </logic:iterate>
       </tbody>
     </table>
    </span>
   </td>
  </tr>
</table>