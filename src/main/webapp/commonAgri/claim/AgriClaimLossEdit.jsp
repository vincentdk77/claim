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
<%@page import="com.sinosoft.utility.SysConfig"%>
<%@page import="com.gyic.claim.bl.facade.BLInsuremainlistFacade"%>
<%
     String settleListCode=(String)request.getAttribute("settleListCode");
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
      String planting31FarmerListFlag = "";
      try {
			planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
%>

<% String displayType="readonly"; %>
 <% String buttonType="disabled"; %>
 <% String strReadOnly="readonly"; %>
 <% String disableViewSettleList="disabled";
 	String disableEditSettleList="disabled"; 
    String restrRiskCode = prpLclaimDto.getRiskCode();
 %>
 <% 
  if (editType.equals("ADD")){
  displayType="";
  buttonType="";
  strReadOnly="common";
  disableEditSettleList="";
  }else if (editType.equals("EDIT")){
  displayType="";
  buttonType="";
  disableEditSettleList="";
  }else if("VIEW".equals(editType)||"SHOW".equals(editType)){
  	disableViewSettleList = "";
  }
 //yx 
 boolean hasHeadInsureList = false;
 String policyno=prpLclaimDto.getPolicyNo();
 if(("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(restrRiskCode) > -1)){
     String conditionsOfFatchInsureMainList = " policyNo = '"+policyno+"' and validity = '2' ";
     BLInsuremainlistFacade blInsureMainListFacade = new BLInsuremainlistFacade();
       Collection blInsureMainListCollection = blInsureMainListFacade.findByConditions(conditionsOfFatchInsureMainList);
       System.err.println(conditionsOfFatchInsureMainList);
       if(null!=blInsureMainListCollection && blInsureMainListCollection.size()>0){
         hasHeadInsureList = true;
       }
  }
%>  
<table class="common" align="center" width="100%" >
  <%if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3159,3139,3167,3177,3150,3148,3174,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3170,31A6,3181,3172,3194,3193,3187,3178,3179,3158,3176".indexOf(restrRiskCode) > -1)){%>
       <tr>
        	<td align="center" class="title">
        		�����嵥��
        	</td>
        	<td class="input">
        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
              <input type="hidden" name="editSettleListFlag" value="1"/>
        	</td>
        	<td align="center" class="title" >        		
              <input type="button" name="editSettleListButton" class='bigbutton' value="Ԥ���������嵥" <%=disableEditSettleList%> onclick="openCompensateSettleListPage('edit','claim'); return false;"/>
            </td>
        	<td align="center" class="title" >
        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensateSettleListPage('view','claim'); return false;"/>
        	</td>
        </tr>
 <%}else if(null!=planting31FarmerListFlag && planting31FarmerListFlag.indexOf(restrRiskCode) > -1 ){%>
 		<tr>
        	<td align="center" class="title">
        		�����嵥��
        	</td>
        	<td class="input">
        		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
              <input type="hidden" name="editSettleListFlag" value="1"/>
        	</td>
        	<td align="center" class="title" >        		
              <input type="button" name="editSettleListButton" class='bigbutton' value="Ԥ���������嵥" <%=disableEditSettleList%> onclick="openCompensate31SettleListPage('edit','claim'); return false;"/>
            </td>
        	<td align="center" class="title" >
        		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate31SettleListPage('view','claim'); return false;"/>
        	</td>
        </tr>
         <%}else if("3224".equals(restrRiskCode)){%>
	<tr>
	<td align="center" class="title">
		�����嵥��
	</td>
	<td class="input">
		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
      <input type="hidden" name="editSettleListFlag" value="1"/>
	</td>
	<td align="center" class="title" >        		
      <input type="button" name="editSettleListButton" class='bigbutton' value="Ԥ���������嵥" <%=disableEditSettleList%> onclick="openCompensate3224SettleListPage('edit','claim'); return false;"/>
    </td>
	<td align="center" class="title" >
		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate3224SettleListPage('view','claim'); return false;"/>
	</td>
</tr>
        <!-- yx ����û���嵥�����������嵥 3102,3105,3124,3125,3127,3128,3130,3131,3132,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3192,3196 -->
 <%}else if("3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(restrRiskCode) > -1&&hasHeadInsureList){%>
	<tr>
	<td align="center" class="title">
		�����嵥��
	</td>
	<td class="input">
		<input class="input" type="text" name="settleListCode" id="settleListCode" value="<%=settleListCode==null?"":settleListCode%>" readonly/>
      <input type="hidden" name="editSettleListFlag" value="1"/>
	</td>
	<td align="center" class="title" >        		
      <input type="button" name="editSettleListButton" class='bigbutton' value="Ԥ���������嵥" <%=disableEditSettleList%> onclick="openCompensate3224SettleListPage('edit','claim'); return false;"/>
    </td>
	<td align="center" class="title" >
		<input type="button" name="viewSettleListButton" class='bigbutton' value="�鿴�����嵥" <%=disableViewSettleList%> onclick="openCompensate3224SettleListPage('view','claim'); return false;"/>
	</td>
</tr>
<%} %> 
</table>
<!--������ʾ��¼����������������ʾ��-->
<table id="ClaimLoss_button" class="common" align="center" width="100%" >
 <!--��ʾ��ʾ���е�-->
 <tr >
   <td class="subformtitle" colspan="4" style="text-align:left;">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          �ձ��������Ϣ<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
           <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode">
               <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo">
               <input type=text name="prpLclaimLossAcciName" title="�¹�������" 
               class="codecode"  title="�¹�������"
               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex">
                <input type = "hidden" name = "prpLclaimAcciPersonAge">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber">
                
           </td>
           <td class="input" style="width:4%" style="align:center">
                <input name="prpLclaimLossItemKindNo" type="text" class="readonly" readonly="readonly" title="������" >
           </td>
             <td class="input" style="width:16%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:30%" title="�ձ�"
                      ondblclick= "code_CodeSelect(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post');"
                      onkeyup= "code_CodeSelect(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post');"
                      onchange="setFlagDanger();"
                      >
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:60%" title="�ձ�"
                      ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post');"
                      onchange="setFlagDanger();"
                      >
              
                <input name="prpLclaimLossItemAmount" type="hidden" value="">
             </td>
             <td class="input" style="display:" align="center">
                 <input type="text" name="prpLclaimLossItemCode" value="" class="readonly" readonly style="width:30%" title="��Ĵ���" 
                                    ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                    onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                  <input type=text name="prpLclaimLossItemDetailName" class="readonly" readonly style="width:60%" title="�������"  value=""
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
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur="collectClaimLoss();checkBeyondSumAmount()"
                 onchange="setFlagDanger();">
             </td>
             <td class="input"  style="width:10%">
               <select name="prpLclaimLossLossFeeType">
                   <option value="P">���</option>
                   <option value="Z">����</option>
                </select>
             </td>
             <!-- yx ���ӹ��������ֶ�-->
             <td class="input" style="width:12%">
                 <input name="prpLclaimLossclaimNumber" class=common style="text-align:right" value="0" onchange="checkclaimNumber();"  onblur="checkclaimNumber();">
             </td>
             <td class="input" style="display:none">                
                  <input name="prpLclaimLossKindRest" class=common style="width:50px">
             </td> 
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate"  onblur="checkFullDate(this)" style="width:85px" maxlength="10" class="readonly" readonly
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
                 <input name="prpLclaimLossFlag" type="hidden">
                 <input name="prpLclaimLossFeeCategory" type="hidden" value="">
             </td>
             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type="button" class="smallbutton" name="buttonClaimLossDelete"  onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();" value="-" style="cursor: hand"  >
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
              <td class="centertitle" style="width:4%">������</td>
              <td class="centertitle" style="width:16%">�ձ�</td>
              <td class="centertitle" style="width:10%">�������</td>
              <td class="centertitle" style="width:12%">�ұ�</td>
              <td class="centertitle" style="width:12%">Ԥ�Ƹ������</td>
              <td class="centertitle" style="width:10%">���</td>
              <td class="centertitle" style="width:5%">��������</td>
              <td class="centertitle" style="width:10%">��������</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency();" type="button" class="button" value="����">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 �鿴ҳ�棬��ťҪ�ҵ����������Ҫ�޸ģ���ע���Ӧ��ClaimEdit��Ҫȥ��disabledAllButton(ClaimLoss_button)������-->
         <tr>
              <td class="button"  colspan=7 >(��"+"�ż������ձ��������Ϣ����"-"�ż�ɾ����Ϣ)</td>
              <td class="title" align="right" style="width:10%">
                 <div align="center">
                    <input type="button" class="smallbutton"  value="+" onclick="insertRow('ClaimLoss');setFlagDanger();" name="buttonDriverInsert" style="cursor: hand"  >
                 </div>
              </td>
         </tr>
       </tfoot>

       <tbody>
       <logic:iterate id="prpLclaimLossDto"  name="claimDto"  property="prpLclaimLossDtoList">
         <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode">
                <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo"  value="<bean:write name='prpLclaimLossDto' property='familyNo' filter='true' />">
               <input type=text name="prpLclaimLossAcciName" title="�¹�������"  value="<bean:write name='prpLclaimLossDto' property='familyName' filter='true' />"
               class="codecode"  title="�¹�������"
               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex">
                <input type = "hidden" name = "prpLclaimAcciPersonAge">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber">
               
           </td>
           <td  class="input" style="width:4%" style="align:center">
              <input name="prpLclaimLossItemKindNo" type="text" class="readonly"  title="������" readonly="readonly" value="<bean:write name='prpLclaimLossDto' property='itemKindNo' filter='true' />">
           </td>
           <td class="input" style="width:16%" style="align:center">
               <input type=text name="prpLclaimLossKindCode" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />"
                    class="codecode" style="width:30%" title="�ձ�"
                     ondblclick= "code_CodeSelect(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post');"
                      onkeyup= "code_CodeSelect(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post');"
                    onchange="setFlagDanger();">
               <input type=text name="prpLclaimLossKindName" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                    class="codecode" style="width:60%" title="�ձ�"
                    ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post');"
                    onkeyup= "code_CodeSelect(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post');"
                    onchange="setFlagDanger();">
              
               <input name="prpLclaimLossItemAmount" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount' filter='true' />">
           </td>
           <td class="input" style="display:" align="center">
               <input type="text" name="prpLclaimLossItemCode" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true' />"
                                  class="readonly" readonly style="width:30%" title="��Ĵ���"
                                  ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                  onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                <input type=text name="prpLclaimLossItemDetailName"
                                    class="readonly" readonly style="width:60%" title="�������" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true' />"
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
               <input name="prpLclaimLossSumClaim" class="<%=strReadOnly%>" style="text-align:right" value="<bean:write name='prpLclaimLossDto' property='sumClaim' filter='true' format='##0.00'/>" onchange="setFlagDanger();collectClaimLoss();checkBeyondSumAmount()">
           </td>
           <td class="input"  style="width:10%">
             <select name="prpLclaimLossLossFeeType">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>���</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>����</option>
              </select>
           </td>
           <!-- yx ���ӹ��������ֶ� --> 
            <td class="input" style="width:12%">
               <input name="prpLclaimLossclaimNumber" class="<%=strReadOnly%>" style="text-align:right" value="0"/>
           </td>
           <td class="input" style="display:none">                
                  <input name="prpLclaimLossKindRest" class="<%=strReadOnly%>" style="width:50px"  value="<bean:write name='prpLclaimLossDto' property='kindRest' filter='true' format='##0.00'/>">
           </td>
           <td class="input" style="width:10%">
               <input name="prpLclaimLossInputDate" class="<%=strReadOnly%>" readonly onblur="checkFullDate(this)" style="width:85px" maxlength="10"
                  value="<bean:write name='prpLclaimLossDto' property='inputDate' filter='true' />">
                  <input name="prpLclaimLossFlag" type="hidden" value="<bean:write name='prpLclaimLossDto' property='flag' filter='true' />">
                  <input name="prpLclaimLossFeeCategory" type="hidden" value="<bean:write name='prpLclaimLossDto' property='feeCategory' filter='true' />">
           </td>
           <td class="input" style='width:4%' colspan="2" align="center">
               <div>
                 <input type="button" class="smallbutton" name="buttonClaimLossDelete"  onclick="deleteRow(this,'ClaimLoss');collectClaimLoss();setFlagDanger();"  <%=buttonType%>  value="-" style="cursor: hand" >
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