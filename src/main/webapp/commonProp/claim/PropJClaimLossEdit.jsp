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
<%@page import="java.util.*"%>

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
     		sumAmount = parseFloat(fm.prpLclaimSumAmount.value);
     		feeSumClaim = parseFloat(field.value);
     		if( feeSumClaim > sumAmount )
     		{
     			errorMessage = "������ܴ��ڱ��� ";
     			alert(errorMessage);
     			field.select();
     			field.focus();
     			return false;
     		}
     		if(isNaN(feeSumClaim))
     		{
     			fm.prpLclaimLossSumClaim.value = 0;
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
%>

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

 
<!--������ʾ��¼����������������ʾ��-->
<table class="common" align="center" width="100%" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="common" colspan="4" style="text-align:left;">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
           <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode">
               <input type=text name="prpLclaimLossAcciName" title="�¹�������" 
               class="codecode"  title="�¹�������"
               ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex">
                <input type = "hidden" name = "prpLclaimAcciPersonAge">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber">
                <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo">
           </td>
             <td class="input" style="width:20%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:30%" title="�ձ�"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                      >
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:60%" title="�ձ�"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                      >
                <input name="prpLclaimLossItemKindNo" type="hidden">
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossItemCode" value="" class="codecode" style="width:30%" title="��Ŀ"
                                    ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                    onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                  <input type=text name="prpLclaimLossItemName" class="codecode" style="width:60%" title="��Ŀ"  value=""
                                     ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />" class="codecode" style="width:30%" title="�ұ�"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='strCurrencyName'  filter='true' />"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%">
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur="collectClaimLoss();" onchange="return checkBeyondSumAmount(this)">
             </td>
             <td class="input"  style="width:10%">
               <select name="prpLclaimLossLossFeeType">
                   <option value="P">���</option>
                   <option value="Z">����</option>
                </select>
             </td>
             <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
             </td> 
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate"  onblur="checkFullDate(this)" style="width:85px" maxlength="10" class=readonly readonly="readonly"
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
                 <input name="prpLclaimLossFlag" type="hidden">
                 <input name="prpLclaimLossFeeCategory" type="hidden" value="">
             </td>
             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type="button" class="smallbutton" name="buttonClaimLossDelete"  onclick="deleteRow(this,'ClaimLoss');setFlagDanger();" value="-" style="cursor: hand">
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
              <td class="centertitle" style="width:10%">�¹�������</td>
              <td class="centertitle" style="width:28%">�ձ�</td>
              <td class="centertitle" style="width:12%">��Ŀ</td>
              <td class="centertitle" style="width:12%">�ұ�</td>
              <td class="centertitle" style="width:12%">Ԥ�Ƹ������</td>
              <td class="centertitle" style="width:10%">���</td>
              <td class="centertitle" style="width:8%">��ֵ</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency();" type="button" class="button" value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ����������Ҫ�޸ģ���ע���Ӧ��ClaimEdit��Ҫȥ��disabledAllButton(ClaimLoss_button)������-->
         <tr><td colspan="8"><table id="ClaimLoss_button" style="width:100%">
           <tr>
              <td  type="button" class="button"  colspan=7 style="width:90%">(��"+"�ż������ձ��������Ϣ����"-"�ż�ɾ����Ϣ)</td>
              <td class="title" align="right" style="width:10%">
                 <div align="center">
                    <input type="button" class="smallbutton"  value="+" onclick="insertRow('ClaimLoss');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand">
                 </div>
              </td>
           </tr>
         </table></td></tr>
       </tfoot>

       <tbody>
       <logic:iterate id="prpLclaimLossDto"  name="claimDto"  property="prpLclaimLossDtoList">
         <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode">
               <input type=text name="prpLclaimLossAcciName" title="�¹�������"  value="<bean:write name='prpLclaimLossDto' property='remarkFlag' filter='true' />"
               class="codecode"  title="�¹�������"
               ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex">
                <input type = "hidden" name = "prpLclaimAcciPersonAge">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber">
                <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo">
           </td>
           <td class="input" style="width:20%" style="align:center">
               <input type=text name="prpLclaimLossKindCode" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />"
                    class="codecode" style="width:30%" title="�ձ�"
                    ondblclick= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                    onkeyup= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                    onchange="setFlagDanger();">
               <input type=text name="prpLclaimLossKindName" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                    class="codecode" style="width:60%" title="�ձ�"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                    onchange="setFlagDanger();">
               <input name="prpLclaimLossItemKindNo" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemKindNo' filter='true' />">
           </td>
           <td class="input" style="width:12%" align="center">
               <input type="text" name="prpLclaimLossItemCode" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true' />"
                                  class="codecode" style="width:30%" title="��Ŀ"
                                  ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                  onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                <input type=text name="prpLclaimLossItemName"
                                    class="codecode" style="width:60%" title="��Ŀ" value="<bean:write name='prpLclaimLossDto' property='itemKindName' filter='true' />"
                                   ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
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
               <input name="prpLclaimLossSumClaim" class=common style="text-align:right" value="<bean:write name='prpLclaimLossDto' property='sumClaim' filter='true' format='##0.00'/>" onchange="setFlagDanger();return checkBeyondSumAmount(this)">
           </td>
           <td class="input"  style="width:10%">
             <select name="prpLclaimLossLossFeeType">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
              </select>
           </td>
           <td class="input" style="width:8%">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
           </td> 
           <td class="input" style="width:10%">
               <input name="prpLclaimLossInputDate" readonly onblur="checkFullDate(this)" style="width:85px" maxlength="10"
                  value="<bean:write name='prpLclaimLossDto' property='inputDate' filter='true' />">
                  <input name="prpLclaimLossFlag" type="hidden" value="<bean:write name='prpLclaimLossDto' property='flag' filter='true' />">
                  <input name="prpLclaimLossFeeCategory" type="hidden" value="<bean:write name='prpLclaimLossDto' property='feeCategory' filter='true' />">
           </td>
           <td class="input" style='width:4%' colspan="2" align="center">
               <div>
                 <input type="button" class="smallbutton" name="buttonClaimLossDelete"  onclick="deleteRow(this,'ClaimLoss');setFlagDanger();"  <%=buttonType%>  value="-" style="cursor: hand">
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