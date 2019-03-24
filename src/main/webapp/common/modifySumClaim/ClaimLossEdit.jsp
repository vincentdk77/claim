<%--
****************************************************************************
* DESC       ：显示(非车险)立案登记的险别估损金额页面
* AUTHOR     ：wangwei
* CREATEDATE ：2005-06-07
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@ page import="java.util.*"%>

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
      }else{
          out.println("  <input type=\"hidden\" name=\"baseCurrency\""+
                " value=1 "+"\">");
      }
%>

<!--建立显示的录入条，可以收缩显示的-->
<table class="common" align="center" width="100%" >
 <!--表示显示多行的-->
 <tr >
   <td class="common" colspan="4">
     <span style="display:none">
       <table class="common" style="display:none" id="ClaimLoss_Data" cellspacing="1" cellpadding="0">
         <tbody>
         <tr>

             <td class="input" style="width:30%" style="align:center">
                 <input type=text name="prpLclaimLossKindCode" value=" "  class="codecode" style="width:30%" title="险别"
                      ondblclick= "code_CodeSelect(this,'PolicyKindCode','1,2');"
                      onkeyup= "code_CodeSelect(this,'PolicyKindCode','1,2');">
                 <input type=text name="prpLclaimLossKindName" class="codecode" style="width:60%" title="险别"
                      ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');"
                      onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,1','always','none','post');">
                 <input name="prpLclaimLossItemKindNo" type="hidden" value="">
             </td>
             <input type="hidden" name="prpLclaimLossItemCode" value="">
             <input type="hidden" name="prpLclaimLossItemName" value="">
             <input type="hidden" name="ClaimLossFlag" value="I" />
            
              <td class="input" style="width:12%" align="center">
                 <input type="text" name="prpLclaimLossCurrency" class="codecode" style="width:30%" title="币别" value="CNY"
                                    ondblclick="code_CodeSelect(this, 'Currency');"
                                    onkeyup= "code_CodeSelect(this, 'Currency');">
                  <input type=text name="prpLclaimLossCurrencyName" class="codecode" style="width:60%" title="币别" value="人民币"
                                     ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                                     onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">
             </td>
              
             <td class="input" style="width:16%">
                 <input name="prpLclaimLossSumClaim"  value="" class=common style="text-align:right" onblur=" collectCurrency1();">
             </td>
               <td class="input" style="width:10%" >
            
             <logic:notEqual name='prpLclaimDto' property='classCode' value='05'> 
                 <input name="prpLclaimLossFlag" type="hidden" value="">
            </logic:notEqual>
            
            <logic:equal name='prpLclaimDto' property='classCode' value='05'> 
                <select name='prpLclaimLossFlag' style="width:50px" >
                      <option value="2" selected >车损</option>
                      <option value="0" >物损</option>
                      <option value="1">人伤</option>
                 </select>  
            </logic:equal>
          
                 </td>
            
            
             <td class="input" style="width:10%">
                   <select name="prpLclaimLossLossFeeType">
                       <option value="P">赔款</option>
                       <option value="Z">费用</option>
                   </select>        	
             </td>
            
             
            <%
                //获得当前时间
            %>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10"  
                   value="<%= new com.sinosoft.sysframework.common.datatype.DateTime(com.sinosoft.sysframework.common.datatype.DateTime.current().toString(), com.sinosoft.sysframework.common.datatype.DateTime.YEAR_TO_DAY) %>">
             </td>
             <td class="input" style="width:10%">
                 <input name="prpLclaimLossRemarkFlag" class="input" maxlength="100">
             </td>
             
             <td class="input" style='width:4%' colspan="2" align="center">
                 <div>
                   <input type=button name="buttonClaimLossDelete"  class="smallbutton"  onclick="deleteRow(this,'ClaimLoss')" value="-" style="cursor: hand">
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
         <tr><td  class="formtitle" colspan="8">险别估损金额信息 </td>
         </tr>
         <tr>
         
         <td class="centertitle" style="width:30%">险别</td>
              <td class="centertitle" style="width:15%">币别</td>
              <td class="centertitle" style="width:16%">险别估损金额</td>
              <td class="centertitle" style="width:10%">损伤类别</td>
              <td class="centertitle" style="width:10%">费用类别</td>
              <td class="centertitle" style="width:8%">输入日期</td>
              <td class="centertitle" style="width:10%">调整原因</td>
              
              <td class="formtitle"  style="width:4%">
                 <input onclick="collectCurrency1();collectCurrency();"  type="button" class="button"  value="汇总">
              </td>
         </tr>
       </thead>
       <tfoot>
       <tr>
            <td class="title" colspan="7"> (按"+"号键增加估损金额信息，按"-"号键删除信息)</td>
            <td class="title" align="right" style="width:4%">
               <div align="center">
                  <input type="button" value="+" onclick="insertRow('ClaimLoss')"  class="smallbutton"  name="buttonDriverInsert" style="cursor: hand">
                 </div>
            </td>
        </tr>
      </tfoot>
   
      <tbody>
       <logic:iterate id="prpLclaimLossDto"  name="claimDto"  property="prpLclaimLossDtoList">
         <tr >
           <td  style="width:30%" style="align:center">
               <input readonly type=text name="prpLclaimLossKindCode"  class="codecode" style="width:30%" title="险别" 
               value="<bean:write name='prpLclaimLossDto' property='kindCode' filter='true' />">
               <input readonly type=text name="prpLclaimLossKindName"  class="codecode" style="width:60%" title="险别" 
               value="<bean:write name='prpLclaimLossDto' property='kindName' filter='true' />">
               <input name="prpLclaimLossItemKindNo" type="hidden" value="<bean:write name='prpLclaimLossDto' property='itemKindNo' filter='true' />">
           </td>
           <input type="hidden" class="readonly" name="prpLclaimLossItemCode" value="">
           <input type="hidden" class="readonly" name="prpLclaimLossItemName" value="">
           <input type="hidden" name="ClaimLossFlag" value="" />
           <td  class="readonly" style="width:12%" align="center">
                <input readonly  type="text" name="prpLclaimLossCurrency"  value="<bean:write name='prpLclaimLossDto' property='currency' filter='true' />"
                                  class="codecode" style="width:30%" title="币别">
                <input readonly  type=text name="prpLclaimLossCurrencyName" value="<bean:write name='prpLclaimLossDto' property='currencyName' filter='true' />"
                                   class="codecode" style="width:60%" title="币别">
           </td>
        
            <td class="readonly"style="width:12%">
                 <input readonly  name="prpLclaimLossSumClaim" class=common style="text-align:right" onblur=" collectCurrency1();" value="<bean:write name='prpLclaimLossDto' property='sumClaim' filter='true' />">
           </td>
       
        <td class="input" style="width:10%" >
        
        <logic:equal name='prpLclaimDto' property='classCode' value='05'> 
              
         <select disabled name='prpLclaimLossFlag' style="width:50px" >
           <option value="2" <logic:equal name="prpLclaimLossDto" property="flag" value='2'>selected</logic:equal> >车损</option>
           <option value="0" <logic:equal name="prpLclaimLossDto" property="flag" value='0'>selected</logic:equal> >物损</option>
           <option value="1" <logic:equal name="prpLclaimLossDto" property="flag" value='1'>selected</logic:equal> >人伤</option>
         </select>  
          </logic:equal>
           <logic:notEqual name='prpLclaimDto' property='classCode' value='05'> 
                       <input readonly  name="prpLclaimLossFlag" type="hidden" value="<bean:write name='prpLclaimLossDto' property='flag' filter='true' />">
           </logic:notEqual>
            </td>
        
           <td class="input"  style="width:10%">
             <select disabled name="prpLclaimLossLossFeeTypeDisplay">
                 <option value="P" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='P'>selected</logic:equal>>赔款</option>
                 <option value="Z" <logic:equal name="prpLclaimLossDto" property="lossFeeType" value='Z'>selected</logic:equal>>费用</option>
              </select>
            <input name="prpLclaimLossLossFeeType" type="hidden" value="<bean:write name='prpLclaimLossDto' property='lossFeeType' filter='true' />">
           </td>
      
            <td  class="readonly" style="width:10%">
               <input readonly  name="prpLclaimLossInputDate" class="readonly" readonly style="width:85px" maxlength="10"
                  value="<bean:write name='prpLclaimLossDto' property='inputDate' filter='true' />">
           </td>
           <td  class="readonly" style="width:10%">
               <input readonly  name="prpLclaimLossRemarkFlag" class="input" maxlength="100"  value="<bean:write name='prpLclaimLossDto' property='remarkFlag' filter='true' />">
           </td>
           <td  class="readonly" style='width:4%' colspan="2" align="center">
               <div>
                 <input  disabled  type=button class="smallbutton" name="buttonClaimLossDelete"  onclick="deleteRow(this,'ClaimLoss')" value="-" style="cursor: hand">
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