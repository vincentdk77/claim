<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-10-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*               qinyongli    2005-9-1        增加新增险别标的的判断
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>
<script language="javascript">    
var damageKind = new Array();
var damageItemKind = new Array();
var damageItemAmount = new Array();
var damageItemAmountDisplay = new Array();
<%
   String kindCode = "";
   String itemKind = "";
   double itemAmount= 0.00;
   String itemAmountDisplay= "";
   PrpCitemKindDto prpCitemKindDto;
   ArrayList damageKindList = (ArrayList)request.getAttribute("prpCitemKindList");  
   for(int k=0;k<damageKindList.size();k++)
   {
       prpCitemKindDto = (PrpCitemKindDto)damageKindList.get(k);
       kindCode = prpCitemKindDto.getKindCode();
       itemKind = prpCitemKindDto.getItemCode();
       itemAmount = prpCitemKindDto.getAmount();
       itemAmountDisplay = NumberFormat.getInstance().format(prpCitemKindDto.getAmount());
       
%>  
       damageKind[<%=k%>]  ='<%=kindCode%>';
       damageItemKind[<%=k%>] ='<%=itemKind%>';
       damageItemAmount[<%=k%>] ='<%=itemAmount%>';
       damageItemAmountDisplay[<%=k%>] ='<%=itemAmountDisplay%>';
<%
    }
%>      

  function changeCurrency(field){
    var currency = field.value;
    var currencyName = fm.prpLlossDtoCurrency4Name[1].value;
    fm.MergeCurrency.value = currency;
    fm.MergeCurrencyName.value = currencyName;
    fm.prpLdangerCurrency.value = currency;
    fm.prpLdangerCurrencyName.value = currencyName;
    if(currency == ""){
      fm.prpLdangerCurrencyName.value = "";
      fm.MergeCurrencyName.value = "";
    }
  }
  
  function judgeKindCode(Field)
{
     var findFlag = 0;
     var fieldname=Field.name;
     var i = 0;
     var findex=0;
     for(i=1;i<fm.all(fieldname).length;i++)
     {
        if( fm.all(fieldname)[i] == Field )
        {
           findex=i;
           break;
        }
     } 
  if(fm.riskCode.value=="1003"||fm.riskCode.value=="1004"||fm.riskCode.value=="0908"){
    var strValue = fm.prpLlossDtoKindCode[findex].value;
     //判断选择的险别是否为出险日期当时生效的险别或者标的
     for (var j=0;j<damageKind.length;j++)
     {
        if(damageKind[j]==strValue)
        {
            fm.prpLlossDtoAmount[findex].value = damageItemAmount[j];     //生成保额，出险时的保额
            fm.prpLlossDtoAmountDisplay[findex].value = damageItemAmountDisplay[j];     //显示用
            findFlag = 1;
            break;
        }
     }
   }else{
   	var strValue = fm.prpLlossDtoKindCode[findex].value;
     var strValueitem = fm.prpLlossDtoItemCode[findex].value;
     //判断选择的险别是否为出险日期当时生效的险别或者标的
     for (var j=0;j<damageKind.length;j++)
     { 
        if(strValueitem==""||damageKind[j]==strValue&&damageItemKind[j]==strValueitem)
        { 
            fm.prpLlossDtoAmount[findex].value = damageItemAmount[j];     //生成保额，出险时的保额
            fm.prpLlossDtoAmountDisplay[findex].value = damageItemAmountDisplay[j];     //显示用
            findFlag = 1;
            break;
        }
     }
   }
     if(findFlag==0)
     {
         alert("您选择的险别或者标的不是出险日期时的险别或者标的,请重新进行选择");
         fm.prpLlossDtoKindCode[findex].value = "";
         fm.prpLlossDtoItemCode[findex].value = "";
         return false;
     } 
}
</script>  

    <%--多行输入自定义JavaScript方法域--%>
        <%--多行输入自定义JavaScript方法域--%>

    <script language="javascript">
      //在下面加入本页自定义的JavaScript方法

        /*
        插入一条新的lLoss之后的处理（可选方法）
      */
      function afterInsertlLoss()
      {
        setPrpLlossDtoSerialNo();
      }

      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeletelLoss(field)
      {

        setPrpLlossDtoSerialNo();
      }

        /**
         * 设置setPrpLlossDtoSerialNo
         */
        function setPrpLlossDtoSerialNo(){
            var count=getElementCount("prpLlossDtoSerialNo");
            for(var i=0;i<count;i++)
            {
                if(count!=1){
                    fm.prpLlossDtoSerialNo[i].value=i;
                }
            }
        }
    </script>

<!--建立显示的录入条，可以收缩显示的-->
   <table class="common" align="center">
    <!--表示显示多行的-->
     <%
     //兑换率信心写到画面上
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
    <tr>
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="lLossImg" onclick="showPage(this,spanlLoss)">赔付标的信息<br>
        <span style="display:none">
          <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号">
                    <!--是否超过保单中的限额标志域-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->
                    <input type='hidden' name="prpLlossDtoLicenseNo">
                    <input type='hidden' name='prpLlossDtoFamilyNo'>
                    <input type='hidden' name="prpLlossDtoFeeTypeCode">
                    <input type='hidden' name="prpLlossDtoFeeTypeName">
                    <input type='hidden' name='prpLlossDtoFamilyName'>
                    <input type='hidden' name='prpLlossDtoItemAddress'>
                    <input type='hidden' name='prpLlossDtoBuyDate' value="2004/12/12">
                    <input type='hidden' name='prpLlossDtoDepreRate'>
                    <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />">
                    <input type='hidden' name='prpLlossDtoCurrency2' value="<bean:write name='prpLcompensateDto' property='currency' />">
                    <input type='hidden' name='prpLlossDtoCurrency3' value="<bean:write name='prpLcompensateDto' property='currency' />">
                    <input type='hidden' name='prpLlossDtoFlag'>
                    <input type='hidden' name='prpLlossDtoUnit'>
                    <input type="hidden" name="prpLlossDtoLossQuantity">
                    <input type="hidden" name="prpLlossDtoUnitPrice">
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate">
                 </div>
             </td>             
                 <td class="input" style="width:4%">
                    <input type='text' name='prpLlossDtoItemKindNo' class="readonly" readonly="readonly" style="width:100%">        
                 </td>       
<%
					if(riskCode.equals("1003")||riskCode.equals("1004")||riskCode.equals("0908")){				
%>
						<td class="input" style="width:10%">
                          <input type="hidden" name="prpLlossDtoKindCode" class="codecode" style="width:20%"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode');"
                             onchange="setFlagDanger();">
                          <input type="text" name="prpLlossDtoKindName" class="codename" style="width:85%"
        			                ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                                    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                                    onchange="judgeKindCode(this);setFlagDanger()">
        			       <img src="/claim/images/bgMarkMustInput.jpg">
        			       <input type="hidden" name="prpLlossDtoItemCode" class="codecode" style="width:30%"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"
                            onblur="checkRepeatItemCode(this);"
                            onchange="judgeKindCode(this)";> 
                          <input type="hidden" name="prpLlossDtoLossName" class="codename"  style="width:98%" 
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');"
        		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');">
                        </td>
<%
					}else{
%>
						<td class="input" style="width:10%">
                          <input type="hidden" name="prpLlossDtoKindCode" class="codecode" style="width:20%"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode');"
                             onchange="setFlagDanger();">
                          <input type="text" name="prpLlossDtoKindName" class="codename" style="width:85%"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                                             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
                                              onchange="setFlagDanger();">
        			       <img src="/claim/images/bgMarkMustInput.jpg">
                        </td>

                        <td class="input" style="width:12%">
                          <input type="hidden" name="prpLlossDtoItemCode" class="codecode" style="width:30%"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"
                            onblur="checkRepeatItemCode(this);"
                          onchange="judgeKindCode(this)";> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:98%" 
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');"
        		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');">
                		                                                                  
                        </td>  
<%
					}
%>
                        <td class="input" style="width:8%">
                           <input type="text" name="prpLlossDtoAmountDisplay" class='readonly' readonly >
                           <input type="hidden" name="prpLlossDtoAmount" class='readonly' readonly >
                        </td>
                        <td class="input" style="width:4%">
                          <input name="prpLlossDtoCurrency4" class="codecode" 
                            ondblclick="code_CodeSelect(this, 'Currency');" value="<bean:write name='prpLcompensateDto' property='currency' />"
                            onkeyup= "code_CodeSelect(this, 'Currency');"
                            onblur="changeCurrency(this);">
                          <input name="prpLlossDtoCurrency4Name" type="hidden" value="<bean:write name='prpLcompensateDto' property='currencyName' />">
                        </td>
                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoItemValue" class="common">
                        </td>

                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoSumLoss" class="common"  onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>

                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoSumRest" class="common" value="0.00" onblur="calRealpay(this);calLoss();"  onchange="setFlagDanger();">
                        </td>

                        <td class="input" style="width:7%">
                          <input name="prpLlossDtoClaimRate"  class="common" value="100" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>

                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoDeductible" class="common" value="0.00" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>

                        <td class="input" style="width:7%">
                          <input name="prpLlossDtoDeductibleRate" class="common" value="0" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>

                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoSumRealPay" class="common"  onchange="setFlagDanger();">
                        </td>


                         <td class="input" style="width:4%">
                           <div align="center">
                               <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand">
                           </div>
                        </td>
                   </tr>
            </tbody>
          </table>
        </span>

        <span  id="spanlLoss" style="display:none">
        <%-- 多行输入展现域 --%>
        <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="3">
          <thead>
             <tr>
                <td class="title" style="width:4%" align="center">序号</td>
                <td class="title" style="width:4%" align="center">标的序号</td>
                <td class="title" style="width:10%" align="center">险别</td>
<%
			if(!riskCode.equals("1003")&&!riskCode.equals("1004")&&!riskCode.equals("0908")){
%>
                <td class="title" style="width:12%" align="center">损失标的</td>
<%
			}
%>
                <td class="title" style="width:8%" align="center">保险金额</td>
                <td class="title" style="width:4%" align="center">币别</td>
                <td class="title" style="width:8%" align="center">货物价值</td>
                <td class="title" style="width:8%" align="center">核定损失</td>
                <td class="title" style="width:8%" align="center">残值</td>
                <td class="title" style="width:7%" align="center">赔偿比例%</td>
                <td class="title" style="width:8%" align="center">免赔额</td>
                <td class="title" style="width:7%" align="center">免赔率%</td>                
                <td class="title" style="width:8%" align="center">赔偿金额</td>
                <td class="title" style="width:4%" align="center">操作</td>
             </tr>
          </thead>
          <tfoot>
            <tr>
<%
			if(riskCode.equals("1003")||riskCode.equals("1004")||riskCode.equals("0908")){
%>
              <td class="title" colspan=13 style="width:96%">(按"+"号键增加险别信息，按"-"号键删除信息)</td>
<%
			}else{
%>
			  <td class="title" colspan=13 style="width:96%">(按"+"号键增加险别信息，按"-"号键删除信息)</td>
<%
			}
%>
              <td class="title" align="right" style="width:4%">
                <div align="center">
                  <input type="button" value="+" class="smallbutton" onclick="insertRow('lLoss');setFlagDanger();" name="buttonlLossInsert" style="cursor: hand">
                </div>
              </td>
            </tr>
          </tfoot>
          <tbody>
            <logic:notEmpty  name="prpLlossDto"  property="prpLlossList">
            <logic:iterate id="lloss" name="prpLlossDto" property="prpLlossList">
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo"  readonly name="prpLlossDtoSerialNo" description="序号" value="<bean:write name='lloss' property='serialNo'/>">
                   <!--是否超过保单中的限额标志域-->
                    <!-- input type="hidden" name="prpLlossDtoOverAmount" -->
                    <input type='hidden' name="prpLlossDtoLicenseNo" value="<bean:write name='lloss' property='licenseNo'/>">
                    <input type='hidden' name='prpLlossDtoFamilyNo' value="<bean:write name='lloss' property='familyNo'/>">
                    <input type='hidden' name="prpLlossDtoFeeTypeCode" value="<bean:write name='lloss' property='feeTypeCode'/>">
                    <input type='hidden' name="prpLlossDtoFeeTypeName" value="<bean:write name='lloss' property='feeTypeName'/>">
                    <input type='hidden' name='prpLlossDtoFamilyName' value="<bean:write name='lloss' property='familyName'/>">
                    <input type='hidden' name='prpLlossDtoItemAddress' value="<bean:write name='lloss' property='itemAddress'/>">
                    <input type='hidden' name='prpLlossDtoBuyDate' value="<bean:write name='lloss' property='buyDate'/>">
                    <input type='hidden' name='prpLlossDtoDepreRate' value="<bean:write name='lloss' property='depreRate'/>">
                    <input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='lloss' property='currency1'/>">
                    <input type='hidden' name='prpLlossDtoCurrency2' value="<bean:write name='lloss' property='currency2'/>">
                    <input type='hidden' name='prpLlossDtoCurrency3' value="<bean:write name='lloss' property='currency3'/>">
                    <input type='hidden' name='prpLlossDtoFlag' value="<bean:write name='lloss' property='flag'/>">
                    <input type='hidden' name='prpLlossDtoUnit' value="<bean:write name='lloss' property='unit'/>">
                    <input type="hidden" name="prpLlossDtoLossQuantity"   value="<bean:write name='lloss' property='lossQuantity'/>">
                    <input type="hidden" name="prpLlossDtoUnitPrice" value="<bean:write name='lloss' property='unitPrice'/>">
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate" value="<bean:write name='lloss' property='indemnityDutyRate'/>"> 
                 </div>
             </td>
   			    <td class="input" style="width:4%">
                     <input type='text' name='prpLlossDtoItemKindNo' readonly="readonly" class="readonly" value="<bean:write name='lloss' property='itemKindNo'/>">     
                 </td>      
                        
<%
					if(riskCode.equals("1003")||riskCode.equals("1004")||riskCode.equals("0908")){
%>
                        <td class="input" style="width:10%">
                         <input type="hidden" name="prpLlossDtoKindCode" class="codecode"  value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode');"  style="width:20%"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode');"
                             onchange="setFlagDanger();">
                        <input type="text" name="prpLlossDtoKindName" class="codename"   value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"  style="width:85%"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        			              onchange="setFlagDanger();">
        			             <img src="/claim/images/bgMarkMustInput.jpg">
                           <input type="hidden" name="prpLlossDtoItemCode" class="codecode" style="width:30%"   
                                  value="<bean:write name='lloss' property='itemCode'/>"
                             ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"
                             onblur="checkRepeatItemCode(this);"
                             onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"> 
                          <input type="hidden" name="prpLlossDtoLossName" class="codename"  style="width:98%"  
                                 value="<bean:write name='lloss' property='lossName'/>"
                             ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');"
        		                 onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');">    
                        </td>
<%
					}else{						
%>
						<td class="input" style="width:10%">
                         <input type="hidden" name="prpLlossDtoKindCode" class="codecode"  value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode');"  style="width:20%"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode');"
                             onchange="setFlagDanger();">
                         <input type="text" name="prpLlossDtoKindName" class="codename"   value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"  style="width:85%"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        			              onchange="setFlagDanger();">
        			             <img src="/claim/images/bgMarkMustInput.jpg">
                        </td>
                        <td class="input" style="width:12%">
                           <input type="hidden" name="prpLlossDtoItemCode" class="codecode" style="width:30%"   
                                  value="<bean:write name='lloss' property='itemCode'/>"
                             ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"
                             onblur="checkRepeatItemCode(this);"
                             onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');"> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:98%"  
                                 value="<bean:write name='lloss' property='lossName'/>"
                             ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');"
        		                 onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');">    
  		            		   
                        </td>
<%
					}
%>
                        <td class=input style="width:8%">
                             <input type="hidden" name="prpLlossDtoAmountDisplay" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>"> 
                             <input type="text" name="prpLlossDtoAmount" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>"> 
                        </td>
                        <td class="input" style="width:4%">
                          <input name="prpLlossDtoCurrency4" class="codecode"  value="<bean:write name='lloss' property='currency4'/>"
                            ondblclick="code_CodeSelect(this, 'Currency');"
                            onkeyup= "code_CodeSelect(this, 'Currency');"
                            onblur="changeCurrency(this);">
                          <input name="prpLlossDtoCurrency4Name" type="hidden" value="<bean:write name='prpLcompensateDto' property='currency' />">
                        </td>
                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoItemValue" class="common" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">
                        </td>

                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoSumLoss" class="common"  onblur="calcuateSumRealPay(this)" value="<bean:write name='lloss' property='sumLoss' format='##0.00'/>"
                          onchange="setFlagDanger();">
                        </td>

                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoSumRest" class="common"  onblur="calcuateSumRealPay(this)" value="<bean:write name='lloss' property='sumRest' format='##0.00'/>"
                          onchange="setFlagDanger();">
                        </td>
                        <td class="input" style="width:7%">
                          <input name="prpLlossDtoClaimRate"  class="common"  onblur="calcuateSumRealPay(this)" value="<bean:write name='lloss' property='claimRate' format='##0.0000'/>" style="width:90%"
                          onchange="setFlagDanger();">
                        </td>
                        <td class="input" style="width:8%">
                           <input name="prpLlossDtoDeductible" class="common" value="<bean:write name='lloss' property='deductible' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                           onchange="setFlagDanger();">
                        </td>
                        <td class="input" style="width:7%">
                           <input name="prpLlossDtoDeductibleRate" class="common" value="<bean:write name='lloss' property='deductibleRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();"
                           onchange="setFlagDanger();">
                        </td>
                        <td class="input" style="width:8%">
                          <input name="prpLlossDtoSumRealPay" class="common" value="<bean:write name='lloss' property='sumRealPay' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">
                        </td>
                        <td class="input" style='width:4%'>
                          <div align="center">
                            <input type=button name="buttonlLossDelete"  class="smallbutton"  onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand"  onblur="calRealpay(this);calLoss();">
                          </div>
                        </td>
                      </tr>
      </logic:iterate>
      </logic:notEmpty>
                     </tbody>
               </table>
        </span>
      </td>
    </tr>
  </table>