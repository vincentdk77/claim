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

<script language="javascript">
//add by zhaolu 20060908 start
   	/**
     *立案估损增加估损不允许大于保额控制
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
     			errorMessage = "估损金额不能大于保额 ";
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
     //兑换率信息写到画面上 2005-09-05
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

 
<!--建立显示的录入条，可以收缩显示的-->
<table class="common" align="center" width="100%" >
 <!--表示显示多行的-->
 <tr >
   <td class="common" colspan="4" style="text-align:left;">
     <img style="cursor:hand;" src="/claim/images/butExpandBlue.gif"
          name="ClaimLossImg" onclick="showPage(this,spanClaimLoss)">
          险别估损金额信息<font color="#FF0000">*</font><br>
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
           <tr>
            <td class="input" align=left style="width:10%">
               <input type = "hidden" name = "prpLclaimLossAcciCode">
               <input type=text name="prpLclaimLossAcciName" title="事故者姓名" 
               class="codecode"  title="事故者姓名"
               ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex">
                <input type = "hidden" name = "prpLclaimAcciPersonAge">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber">
                <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo">
           </td>
             <td class="input" style="width:20%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" class="codecode" style="width:30%" title="险别"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                      >
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:60%" title="险别"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                      >
                <input name="prpLclaimLossItemKindNo" type="hidden">
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossItemCode" value="" class="codecode" style="width:30%" title="项目"
                                    ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                    onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                  <input type=text name="prpLclaimLossItemName" class="codecode" style="width:60%" title="项目"  value=""
                                     ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossCurrency" value="<bean:write name='prpLclaimDto' property='estiCurrency' filter='true' />" class="codecode" style="width:30%" title="币别"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName" class="codecode" style="width:60%" title="币别"  value="<bean:write name='strCurrencyName'  filter='true' />"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
             <td class="input" style="width:12%">
                 <input name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur="collectClaimLoss();" onchange="return checkBeyondSumAmount(this)">
             </td>
             <td class="input"  style="width:10%">
               <select name="prpLclaimLossLossFeeType">
                   <option value="P">赔款</option>
                   <option value="Z">费用</option>
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
     <%-- 多行输入展现域 --%>
     <table class="common" style="width:100%" id="ClaimLoss" >
       <thead>
         <tr>
              <td class="centertitle" style="width:10%">事故者名称</td>
              <td class="centertitle" style="width:28%">险别</td>
              <td class="centertitle" style="width:12%">项目</td>
              <td class="centertitle" style="width:12%">币别</td>
              <td class="centertitle" style="width:12%">预计给付金额</td>
              <td class="centertitle" style="width:10%">类别</td>
              <td class="centertitle" style="width:8%">残值</td>
              <td class="centertitle" style="width:10%">输入日期</td>
              <td  class="centertitle"  style="width:4%">
                 <input onclick="collectCurrency();" type="button" class="button" value="汇总">
              </td>
         </tr>
       </thead>
       <tfoot>
         <!--modify by zhulei 20050903 查看页面，按钮要灰掉（如果这里要修改，请注意对应的ClaimEdit需要去掉disabledAllButton(ClaimLoss_button)方法）-->
         <tr><td colspan="8"><table id="ClaimLoss_button" style="width:100%">
           <tr>
              <td  type="button" class="button"  colspan=7 style="width:90%">(按"+"号键增加险别估损金额信息，按"-"号键删除信息)</td>
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
               <input type=text name="prpLclaimLossAcciName" title="事故者姓名"  value="<bean:write name='prpLclaimLossDto' property='remarkFlag' filter='true' />"
               class="codecode"  title="事故者姓名"
               ondblclick="code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');"
               onkeyup= "code_CodeSelect(this, 'prpCinsured','-1,1,2,3,4','always','none','post');">
                <input type = "hidden" name = "prpLclaimAcciPersonSex">
                <input type = "hidden" name = "prpLclaimAcciPersonAge">
                <input type = "hidden" name = "prpLclaimAcciPersonIdentifyNumber">
                <input type = "hidden" name = "prpLclaimAcciPersonFamilyNo">
           </td>
           <td class="input" style="width:20%" style="align:center">
               <input type=text name="prpLclaimLossKindCode" value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />"
                    class="codecode" style="width:30%" title="险别"
                    ondblclick= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                    onkeyup= "code_CodeSelect(this,'PolicyKindCode2','1,2');"
                    onchange="setFlagDanger();">
               <input type=text name="prpLclaimLossKindName" value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />"
                    class="codecode" style="width:60%" title="险别"
                    ondblclick="code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode2','-1,1','always','none','post');"
                    onchange="setFlagDanger();">
               <input name="prpLclaimLossItemKindNo" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemKindNo' filter='true' />">
           </td>
           <td class="input" style="width:12%" align="center">
               <input type="text" name="prpLclaimLossItemCode" value="<bean:write name='prpLclaimLossDto' property='itemCode' filter='true' />"
                                  class="codecode" style="width:30%" title="项目"
                                  ondblclick="code_CodeSelect(this, 'PolicyItemCode2');"
                                  onkeyup= "code_CodeSelect(this, 'PolicyItemCode2');">
                <input type=text name="prpLclaimLossItemName"
                                    class="codecode" style="width:60%" title="项目" value="<bean:write name='prpLclaimLossDto' property='itemKindName' filter='true' />"
                                   ondblclick="code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'PolicyItemCode2','-1','always','none','post');">
           </td>
           <td class="input" style="width:12%" align="center">
                <input type="text" name="prpLclaimLossCurrency"  value="<bean:write name='prpLclaimLossDto' property='currency' filter='true' />"
                                  class="codecode" style="width:30%" title="币别"
                                  ondblclick="code_CodeSelect(this, 'Currency');"
                                  onkeyup= "code_CodeSelect(this, 'Currency');">
                <input type=text name="prpLclaimLossCurrencyName" value="<bean:write name='prpLclaimLossDto' property='currencyName' filter='true' />"
                                   class="codecode" style="width:60%" title="币别"
                                   ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                   onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
           </td>
           <td class="input" style="width:12%">
               <input name="prpLclaimLossSumClaim" class=common style="text-align:right" value="<bean:write name='prpLclaimLossDto' property='sumClaim' filter='true' format='##0.00'/>" onchange="setFlagDanger();return checkBeyondSumAmount(this)">
           </td>
           <td class="input"  style="width:10%">
             <select name="prpLclaimLossLossFeeType">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>赔款</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>费用</option>
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