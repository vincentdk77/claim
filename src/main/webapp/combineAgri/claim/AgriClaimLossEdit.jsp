<%--
****************************************************************************
* DESC       ：显示立案登记的险别估损金额页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-24
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="java.util.*"%>
<%
	 
     //兑换率信息写到画面上 2005-09-05
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

 
<!--建立显示的录入条，可以收缩显示的-->
<table id="ClaimLoss_button_<%=indexClaimLoss %>" class="common" align="center" width="100%" >
 <!--表示显示多行的-->
 <tr >
   <td class="subformtitle" colspan="4" style="text-align:left;">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg_<%=indexClaimLoss %>" onclick="showPage(this,document.getElementById('spanClaimLoss_<%=indexClaimLoss%>'),'<%=indexClaimLoss%>')">
          险别估损金额信息<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_<%=indexClaimLoss %>_Data" cellspacing="1" cellpadding="0">
         <tbody>
           <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode_<%=indexClaimLoss %>">
               <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo_<%=indexClaimLoss %>">
               <input type=text name="prpLclaimLossAcciName_<%=indexClaimLoss %>" title="事故者姓名" 
               class="codecode"  title="事故者姓名"
               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonAge_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber_<%=indexClaimLoss %>">
                
           </td>
           <td class="input" style="width:4%" style="align:center">
                <input name="prpLclaimLossItemKindNo_<%=indexClaimLoss %>" type="text" class="readonly" readonly="readonly" title="标的序号" >
           </td>
             <td class="input" style="width:16%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode_<%=indexClaimLoss %>" class="codecode" style="width:30%" title="险别"
                      ondblclick= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                      onkeyup= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                      onchange="setFlagDanger('<%=indexClaimLoss %>');"
                      >
                 <input type=text name="prpLclaimLossKindName_<%=indexClaimLoss %>" class="codecode" style="width:60%" title="险别"
                      ondblclick="code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                      onkeyup= "code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                      onchange="setFlagDanger('<%=indexClaimLoss %>');"
                      >
              
                <input name="prpLclaimLossItemAmount_<%=indexClaimLoss %>" type="hidden" value="">
             </td>
             <td class="input" style="display:" align="center">
                 <input type="text" name="prpLclaimLossItemCode_<%=indexClaimLoss %>" value="" class="readonly" readonly style="width:30%" title="标的代码" 
                                    ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                    onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                  <input type=text name="prpLclaimLossItemDetailName_<%=indexClaimLoss %>" class="readonly" readonly style="width:60%" title="标的名称"  value=""
                                     ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossCurrency_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />" class="codecode" style="width:30%" title="币别"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName_<%=indexClaimLoss %>" class="codecode" style="width:60%" title="币别"  value="<bean:write name='strCurrencyName'  filter='true' />"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%">
                 <input name="prpLclaimLossSumClaim_<%=indexClaimLoss %>" class=common style="text-align:right" onblur="collectClaimLoss();checkBeyondSumAmount()"
                 onchange="setFlagDanger('<%=indexClaimLoss %>');">
             </td>
             <td class="input"  style="width:10%">
               <select name="prpLclaimLossLossFeeType_<%=indexClaimLoss %>">
                   <option value="P">赔款</option>
                   <option value="Z">费用</option>
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
     <%-- 多行输入展现域 --%>
     <table class="common" style="width:100%" id="ClaimLoss_<%=indexClaimLoss %>" >
       <thead>
         <tr>
              <td class="centertitle" style="width:10%">事故者名称</td>
              <td class="centertitle" style="width:4%">标的序号</td>
              <td class="centertitle" style="width:16%">险别</td>
              <td class="centertitle" style="display:">标的名称</td>
              <td class="centertitle" style="width:12%">币别</td>
              <td class="centertitle" style="width:12%">预计给付金额</td>
              <td class="centertitle" style="width:10%">类别</td>
              <td class="centertitle" style="display:none">残值</td>
              <td class="centertitle" style="width:10%">输入日期</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency('<%=indexClaimLoss %>');" type="button" class="button" value="汇总">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 查看页面，按钮要灰掉（如果这里要修改，请注意对应的ClaimEdit需要去掉disabledAllButton(ClaimLoss_button)方法）-->
         <tr>
              <td class="button"  colspan=7 >(按"+"号键增加险别估损金额信息，按"-"号键删除信息)</td>
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
               <input type=text name="prpLclaimLossAcciName_<%=indexClaimLoss %>" title="事故者姓名"  value="<bean:write name='prpLclaimLossDto' property='familyName' filter='true' />"
               class="codecode"  title="事故者姓名"
               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonAge_<%=indexClaimLoss %>">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber_<%=indexClaimLoss %>">
               
           </td>
           <td  class="input" style="width:4%" style="align:center">
              <input name="prpLclaimLossItemKindNo_<%=indexClaimLoss %>" type="text" class="readonly"  title="标的序号" readonly="readonly" value="<bean:write name='prpLclaimLossDto' property='itemKindNo' filter='true' />">
           </td>
           <td class="input" style="width:16%" style="align:center">
               <input type=text name="prpLclaimLossKindCode_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />"
                    class="codecode" style="width:30%" title="险别"
                     ondblclick= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                      onkeyup= "code_CodeSelectClaim(this,'KindCodeVirturlItem','1,-1,2,3,4','code','none','post','<%=indexClaimLoss %>');"
                    onchange="setFlagDanger('<%=indexClaimLoss %>');">
               <input type=text name="prpLclaimLossKindName_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                    class="codecode" style="width:60%" title="险别"
                    ondblclick="code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                    onkeyup= "code_CodeSelectClaim(this, 'KindCodeVirturlItem','-1,-2,1,2,3','always','none','post','<%=indexClaimLoss %>');"
                    onchange="setFlagDanger('<%=indexClaimLoss %>');">
              
               <input name="prpLclaimLossItemAmount_<%=indexClaimLoss %>" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemAmount' filter='true' />">
           </td>
           <td class="input" style="display:" align="center">
               <input type="text" name="prpLclaimLossItemCode_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true' />"
                                  class="readonly" readonly style="width:30%" title="标的代码"
                                  ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                  onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                <input type=text name="prpLclaimLossItemDetailName_<%=indexClaimLoss %>"
                                    class="readonly" readonly style="width:60%" title="标的名称" value="<bean:write name='prpLclaimLossDto' property='itemDetailName' filter='true' />"
                                   ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
           </td>
           <td class="input" style="width:12%" align="center">
                <input type="text" name="prpLclaimLossCurrency_<%=indexClaimLoss %>"  value="<bean:write name='prpLclaimLossDto' property='currency' filter='true' />"
                                  class="codecode" style="width:30%" title="币别"
                                  ondblclick="code_CodeSelect(this, 'Currency');"
                                  onkeyup= "code_CodeSelect(this, 'Currency');">
                <input type=text name="prpLclaimLossCurrencyName_<%=indexClaimLoss %>" value="<bean:write name='prpLclaimLossDto' property='currencyName' filter='true' />"
                                   class="codecode" style="width:60%" title="币别"
                                   ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
           </td>
           <td class="input" style="width:12%">
               <input name="prpLclaimLossSumClaim_<%=indexClaimLoss %>" class="<%=strReadOnly%>" style="text-align:right" value="<bean:write name='prpLclaimLossDto' property='sumClaim' filter='true' format='##0.00'/>" onchange="setFlagDanger('<%=indexClaimLoss %>');collectClaimLoss();checkBeyondSumAmount()">
           </td>
           <td class="input"  style="width:10%">
             <select name="prpLclaimLossLossFeeType_<%=indexClaimLoss %>">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>赔款</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>费用</option>
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