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
<%
	 
     //�һ�����Ϣд�������� 2005-09-05
      PrpDexchDto prpDexchDto;
      Collection prpdexchDtoList = (Collection)request.getAttribute("prpdexchDtoList_"+indexClaimLoss);
      if(prpdexchDtoList!=null)
      {
          Iterator itprpdexch = prpdexchDtoList.iterator();
          while(itprpdexch.hasNext())
          {
              prpDexchDto =  (PrpDexchDto)itprpdexch.next();
              out.println("  <input type=\"hidden\" name=\"baseCurrency_"+indexClaimLoss+"\""+
                " value=\""+prpDexchDto.getBaseCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchCurrency_"+indexClaimLoss+"\""+
                " value=\""+prpDexchDto.getExchCurrency()+"\""+"\">");
              out.println("  <input type=\"hidden\" name=\"exchRate_"+indexClaimLoss+"\""+
                " value=\""+prpDexchDto.getExchRate()+"\""+"\">");                
          }
      }   
%>

<% String displayType="readonly"; %>
 <% String buttonType="disabled"; %>
 <% String strReadOnly="readonly"; %>
 <% 
  if (editType.equals("ADD")){
  displayType="";
  buttonType="";
  strReadOnly="common";
  }
%>  
<% 
  if (editType.equals("EDIT")){
  displayType="";
  buttonType="";
  }
%>  

 
<!--������ʾ��¼����������������ʾ��-->
<table id="ClaimLoss_button_<%=indexClaimLoss %>" class="common" align="center" width="100%" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="subformtitle" colspan="4" style="text-align:left;">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg_<%=indexClaimLoss %>" onclick="showPage(this,document.getElementById('spanClaimLoss_<%=indexClaimLoss%>'),'<%=indexClaimLoss%>')">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_<%=indexClaimLoss %>_Data" cellspacing="1" cellpadding="0">
         <tbody>
           <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode_<%=indexClaimLoss %>">
               <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo_<%=indexClaimLoss %>">
               <input type=text name="prpLclaimLossAcciName_<%=indexClaimLoss %>" title="�¹�������" 
               class="codecode"  title="�¹�������"
               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonAge_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber_<%=indexClaimLoss %>">
                
           </td>
           <td class="input" style="width:4%" style="align:center">
                <input name="prpLclaimLossItemKindNo_<%=indexClaimLoss %>" type="text" class="readonly" readonly="readonly" title="������" >
           </td>
             <td class="input" style="width:16%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode_<%=indexClaimLoss %>" class="codecode" style="width:30%" title="�ձ�"
                      ondblclick= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                      onkeyup= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                      onchange="setFlagDanger('<%=indexClaimLoss %>');"
                      >
                 <input type=text name="prpLclaimLossKindName_<%=indexClaimLoss %>" class="codecode" style="width:60%" title="�ձ�"
                      ondblclick="code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                      onkeyup= "code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                      onchange="setFlagDanger('<%=indexClaimLoss %>');"
                      >
              
                <input name="prpLclaimLossItemAmount_<%=indexClaimLoss %>" type="hidden" value="">
             </td>
             <td class="input" style="display:" align="center">
                 <input type="text" name="prpLclaimLossItemCode_<%=indexClaimLoss %>" value="" class="readonly" readonly style="width:30%" title="��Ĵ���" 
                                    ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                    onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                  <input type=text name="prpLclaimLossItemDetailName_<%=indexClaimLoss %>" class="readonly" readonly style="width:60%" title="�������"  value=""
                                     ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossCurrency_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />" class="codecode" style="width:30%" title="�ұ�"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName_<%=indexClaimLoss %>" class="codecode" style="width:60%" title="�ұ�"  value="<bean:write name='strCurrencyName'  filter='true' />"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%">
                 <input name="prpLclaimLossSumClaim_<%=indexClaimLoss %>" class=common style="text-align:right" onblur="collectClaimLoss();checkBeyondSumAmount()"
                 onchange="setFlagDanger('<%=indexClaimLoss %>');">
             </td>
             <td class="input"  style="width:10%">
               <select name="prpLclaimLossLossFeeType_<%=indexClaimLoss %>">
                   <option value="P">���</option>
                   <option value="Z">����</option>
                </select>
             </td>
             <td class="input" style="display:none">                
                  <input name="prpLclaimLossKindRest_<%=indexClaimLoss %>" class=common style="width:50px">
             </td> 
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate_<%=indexClaimLoss %>"  onblur="checkFullDate(this)" style="width:85px" maxlength="10" class="readonly" readonly
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
                 <input name="prpLclaimLossFlag_<%=indexClaimLoss %>" type="hidden">
                 <input name="prpLclaimLossFeeCategory_<%=indexClaimLoss %>" type="hidden" value="">
             </td>
             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type="button" class="smallbutton" name="buttonClaimLossDelete_<%=indexClaimLoss %>"  onclick="deleteRow(this,'ClaimLoss_<%=indexClaimLoss %>');collectClaimLoss();setFlagDanger('<%=indexClaimLoss %>');" value="-" style="cursor: hand"  >
                 </div>
             </td>
           </tr>
         </tbody>
      </table>
    </span>

    <span  id="spanClaimLoss_<%=indexClaimLoss %>" style="display:" cellspacing="1" cellpadding="0">
     <%-- ��������չ���� --%>
     <table class="common" style="width:100%" id="ClaimLoss_<%=indexClaimLoss %>" >
       <thead>
         <tr>
              <td class="centertitle" style="width:10%">�¹�������</td>
              <td class="centertitle" style="width:4%">������</td>
              <td class="centertitle" style="width:16%">�ձ�</td>
              <td class="centertitle" style="display:">�������</td>
              <td class="centertitle" style="width:12%">�ұ�</td>
              <td class="centertitle" style="width:12%">Ԥ�Ƹ������</td>
              <td class="centertitle" style="width:10%">���</td>
              <td class="centertitle" style="display:none">��ֵ</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency('<%=indexClaimLoss %>');" type="button" class="button" value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ����������Ҫ�޸ģ���ע���Ӧ��ClaimEdit��Ҫȥ��disabledAllButton(ClaimLoss_button)������-->
         <tr>
              <td class="button"  colspan=7 >(��"+"�ż������ձ��������Ϣ����"-"�ż�ɾ����Ϣ)</td>
              <td class="title" align="right" style="width:10%">
                 <div align="center">
                    <input type="button" class="smallbutton"  value="+" onclick="insertRow('ClaimLoss_<%=indexClaimLoss %>');setFlagDanger('<%=indexClaimLoss %>');" name="buttonDriverInsert_<%=indexClaimLoss %>" style="cursor: hand"  >
                 </div>
              </td>
         </tr>
       </tfoot>

       <tbody>
       <logic:iterate id="prpLclaimLossDto"  name="claimDto"  property="prpLclaimLossDtoList">
         <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo_<%=indexClaimLoss %>"  value="<bean:write name='prpLclaimLossDto' property='familyNo' filter='true' />">
               <input type=text name="prpLclaimLossAcciName_<%=indexClaimLoss %>" title="�¹�������"  value="<bean:write name='prpLclaimLossDto' property='familyName' filter='true' />"
               class="codecode"  title="�¹�������"
               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonAge_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber_<%=indexClaimLoss %>">
               
           </td>
           <td  class="input" style="width:4%" style="align:center">
              <input name="prpLclaimLossItemKindNo_<%=indexClaimLoss %>" type="text" class="readonly"  title="������" readonly="readonly" value="<bean:write name='prpLclaimLossDto' property='itemKindNo' filter='true' />">
           </td>
           <td class="input" style="width:16%" style="align:center">
               <input type=text name="prpLclaimLossKindCode_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />"
                    class="codecode" style="width:30%" title="�ձ�"
                     ondblclick= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                      onkeyup= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                    onchange="setFlagDanger('<%=indexClaimLoss %>');">
               <input type=text name="prpLclaimLossKindName_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                    class="codecode" style="width:60%" title="�ձ�"
                    ondblclick="code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                    onkeyup= "code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                    onchange="setFlagDanger('<%=indexClaimLoss %>');">
              
               <input name="prpLclaimLossItemAmount_<%=indexClaimLoss %>" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount' filter='true' />">
           </td>
           <td class="input" style="display:" align="center">
               <input type="text" name="prpLclaimLossItemCode_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true' />"
                                  class="readonly" readonly style="width:30%" title="��Ĵ���"
                                  ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                  onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                <input type=text name="prpLclaimLossItemDetailName_<%=indexClaimLoss %>"
                                    class="readonly" readonly style="width:60%" title="�������" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true' />"
                                   ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
           </td>
           <td class="input" style="width:12%" align="center">
                <input type="text" name="prpLclaimLossCurrency_<%=indexClaimLoss %>"  value="<bean:write name='prpLclaimLossDto' property='currency' filter='true' />"
                                  class="codecode" style="width:30%" title="�ұ�"
                                  ondblclick="code_CodeSelect(this, 'Currency');"
                                  onkeyup= "code_CodeSelect(this, 'Currency');">
                <input type=text name="prpLclaimLossCurrencyName_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='currencyName' filter='true' />"
                                   class="codecode" style="width:60%" title="�ұ�"
                                   ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
           </td>
           <td class="input" style="width:12%">
               <input name="prpLclaimLossSumClaim_<%=indexClaimLoss %>" class="<%=strReadOnly%>" style="text-align:right" value="<bean:write name='prpLclaimLossDto' property='sumClaim' filter='true' format='##0.00'/>" onchange="setFlagDanger('<%=indexClaimLoss %>');collectClaimLoss();checkBeyondSumAmount()">
           </td>
           <td class="input"  style="width:10%">
             <select name="prpLclaimLossLossFeeType_<%=indexClaimLoss %>">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
              </select>
           </td>
           <td class="input" style="display:none">                
                  <input name="prpLclaimLossKindRest_<%=indexClaimLoss %>" class="<%=strReadOnly%>" style="width:50px"  value="<bean:write name='prpLclaimLossDto' property='kindRest' filter='true' format='##0.00'/>">
           </td> 
           <td class="input" style="width:10%">
               <input name="prpLclaimLossInputDate_<%=indexClaimLoss %>" class="<%=strReadOnly%>" onblur="checkFullDate(this)" style="width:85px" maxlength="10"
                  value="<bean:write name='prpLclaimLossDto' property='inputDate' filter='true' />">
                  <input name="prpLclaimLossFlag_<%=indexClaimLoss %>" type="hidden" value="<bean:write name='prpLclaimLossDto' property='flag' filter='true' />">
                  <input name="prpLclaimLossFeeCategory_<%=indexClaimLoss %>" type="hidden" value="<bean:write name='prpLclaimLossDto' property='feeCategory' filter='true' />">
           </td>
           <td class="input" style='width:4%' colspan="2" align="center">
               <div>
                 <input type="button" class="smallbutton" name="buttonClaimLossDelete_<%=indexClaimLoss %>"  onclick="deleteRow(this,'ClaimLoss_<%=indexClaimLoss %>');collectClaimLoss();setFlagDanger('<%=indexClaimLoss %>');"  <%=buttonType%>  value="-" style="cursor: hand" >
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
<%indexClaimLoss++; %>