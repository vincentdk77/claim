<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-10-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="java.text.*"%>
<%@page import="java.util.*"%>

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
   
   String strRiskCode = (String)request.getAttribute("riskCode");
   
%>      

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
     if(findFlag==0)
     {
         alert("您选择的险别或者标的不是出险日期时的险别或者标的,请重新进行选择");
         fm.prpLlossDtoKindCode[findex].value = "";
         fm.prpLlossDtoItemCode[findex].value = "";
         return false;
     } 
}

//add by kangzhen
      function isRightDutyPercent(field)
	    {
        var lPercent=0;
        var strmsg="";

         lPercent=parseFloat(field.value);
         if ((lPercent>100)||(lPercent<0))
         {
            strmsg="赔付比例不能大于100或者小于0!";
            alert(strmsg);
            field.select();
            field.focus();
            return false;
         }
            return true;
      }
      
 //add by kangzhen     
      function checkInteger(field)
      {
      	field.value = trim(field.value);
      	var strValue = field.value;
      	 if(!isInteger(strValue))
         {
           errorMessage("请输入合法的数字");
           field.focus();
           field.select();
           return false;
         }
      }
      
      
      function isInteger(strValue)
      {
        var result = regExpTest(strValue,/\d+/g);
        return result;
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
                //alert("看看什么时候运行?count="+count+"  i="+i); 
                if(count!=1){
                    fm.prpLlossDtoSerialNo[i].value=i;
                }
            }
        }
    </script>   
    
   <!--建立显示的录入条，可以收缩显示的-->
   <table class="common" align="center">
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
    <!--表示显示多行的-->
    <tr>
       <!--表示显示多行的-->
   
      <td class="subformtitle" colspan="4" style="text-align:left">
        <img style="cursor:hand;" src="/claim/images/butCollapseBlue.gif"
             name="lLossImg" onclick="showPage(this,spanlLoss)">财产损失赔付信息<br>
        <span style="display:none"> 
          <table class="common" style="display:none" id="lLoss_Data" cellspacing="1" cellpadding="0">
            <tbody>
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">   
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                  <tbody>  
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
                    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />"> 
                    <input type='hidden' name='prpLlossDtoFlag'> 
                    <input type='hidden' name='prpLlossDtoUnit'> 
                    <input type="hidden" name="prpLlossDtoLossQuantity">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate"> 
                    <input type="hidden" name="prpLlossDtoItemValue" class="common"  style="width:180px"> 
                    <input type="hidden" name="prpLlossDtoAmountDisplay" class='readonly' readonly >
                    
                    <% if("1528".equals(strRiskCode)){ %>
	                   <tr>
	                       <td class="title" style="width:15%">车辆信息：</td>
                           <td class="input"  colspan="3">     
			               <input type=text name="prpLlossDtoBrandCode" title="车辆厂牌型号" 
			               class="codecode"   style='width:130px'
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');">
			               
			               <input type=text name="prpLlossDtoCarNumber" title="车辆编号" 
			               class="codecode"  style='width:130px'
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');">
			                 
			               <input type = "hidden" name = "prpLlossFamilyNo" >
			              </td>
		               </tr>
                    <% }%>
                     <tr>
                         <td class="title" style="width:15%">标的序号：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="text" name="prpLlossDtoItemKindNo" value="" class="readonly" readonly="readonly">  
                        </td>    
                     </tr>
                      <tr>           
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40"  value=" "
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1,2,3,4','code');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1,2,3,4','code');"
                             onchange="setFlagDanger();">                 
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110"   value=" "
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
        			              onchange="setFlagDanger();"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                    
                        </td>                
                      </tr>                                    
                      <tr>                                            
                        <td class="title" style="width:15%">损失项目名称:</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                         <input type="hidden" name="prpLlossDtoItemCode" class="input" style="width:40"  value=""  >
                         <input type="text" name="prpLlossDtoLossName" class="input" style="width:200px"  value=""  onblur="checkRepeatItemCode(this);">
                         <input type="hidden" name="prpLlossDtoAmount" class='readonly' readonly >  
                        </td>                
                      </tr>   
                      <tr style="display:none">                             
                        <td class="title" style="width:15%" >币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                     <!-- <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                           <input type="text" name="prpLlossDtoAmountDisplay" class='readonly' readonly >
                           
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px">
                        </td>                
                      </tr>  -->   
                      <input type="hidden" name="prpLlossDtoItemValue">
                        
                      <tr>                             
                        <td class="title" style="width:15%">损失币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" onblur="calRealpay(this);calLoss();">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" onchange="calRealpay(this);calLoss();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  value="100" style="width:180px" onchange="calRealpay(this);calLoss();checkInteger(this);return isRightDutyPercent(this)">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common" value="0" style="width:180px" onchange="calRealpay(this);calLoss();checkInteger(this);">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">赔偿币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">免赔额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" value="0" onchange="calRealpay(this);calLoss();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input"  onchange="setFlagDanger();">
                        </td>
				      <logic:notEmpty name="coinsFlag"  >
						<logic:equal name='coinsFlag' value="2">
	                      <tr>                             
	                        <td class="title" style="width:15%">共保总赔偿金额</br>（含我方及其它共保方）：</td>
	                        <td class="input" style="width:35%">
	                          <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="setFlagDanger();">                                                                     
	                        </td>                   
	                      </tr>  
						</logic:equal>
						<logic:equal name='coinsFlag' value="1">
	                      <tr>                             
	                        <td class="title" style="width:15%">共保总赔偿金额</br>（含我方及其它共保方）：</td>
	                        <td class="input" style="width:35%">
	                          <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="setFlagDanger();">                                                                     
	                        </td>                   
	                      </tr>  
						</logic:equal>
					</logic:notEmpty>                 
                      </tr>  
                     </tbody>  
                   </table>     
               </td>
              <td class="input" style="width:4%">
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton"  onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
           <!--add by zhulei 20050905 赔款标的间加一条分隔线-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='6'></td>
           </tr>
            </tbody>
          </table>
        </span>
        
        <span  id="spanlLoss" style="display:none">
        <%-- 多行输入展现域 --%>
        <table id="lLoss" class="common" align="center" cellspacing="1" cellpadding="0">
          <thead>
             <tr>
                <td class="title" style="width:4%">序号</td>
                <td class="title" style="width:96%" colspan=2 >内容</td>
             </tr> 
          </thead>
          <tfoot>
              <tr>
                <td class="title" colspan=2 style="width:96%">(按"+"号键增加险别信息，按"-"号键删除信息)</td>
                 <td class="title" align="right" style="width:4%">
                 <div align="center">
                 <input type="button" value="+"  class="smallbutton" onclick="insertRow('lLoss');setFlagDanger();" name="buttonlLossInsert" style="cursor: hand">
                 </div>
                 </td>
              </tr> 
           </tfoot> 
            
          <tbody>
 <% int index24=0;%>
<logic:notEmpty  name="prpLlossDto"  property="prpLlossList"> 
<logic:iterate id="lloss" name="prpLlossDto" property="prpLlossList">
              <tr>
              <td class="input" style="width:4%">
                 <div align="center">
                   <input class="readonlyNo" readonly name="prpLlossDtoSerialNo" description="序号" value="<bean:write name='lloss' property='serialNo'/>">
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">                        
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
                  <tbody>  
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
                    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='lloss' property='currency4'/>"> 
                    <input type='hidden' name='prpLlossDtoFlag' value="<bean:write name='lloss' property='flag'/>"> 
                    <input type='hidden' name='prpLlossDtoUnit' value="<bean:write name='lloss' property='unit'/>"> 
                    <input type="hidden" name="prpLlossDtoLossQuantity"   value="<bean:write name='lloss' property='lossQuantity'/>">                  
                    <input type="hidden" name="prpLlossDtoUnitPrice" value="<bean:write name='lloss' property='unitPrice'/>">               
                    <input type="hidden" name="prpLlossDtoIndemnityDutyRate" value="<bean:write name='lloss' property='indemnityDutyRate'/>"> 
 					<input type="hidden" name="prpLlossDtoAmountDisplay" value=""> 
 					
 				 <% if("1528".equals(strRiskCode)){ %>
	                   <tr>
	                      <td class="title" style="width:15%">车辆信息：</td>
                           <td class="input"  colspan="3">     
			               <input type=text name="prpLlossDtoBrandCode" title="车辆厂牌型号" 
			               class="codecode"   style='width:130px'   value="<bean:write name='lloss' property='brandCode' filter='true' />" 
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','1,2','code','none','post');">
			               
			               <input type=text name="prpLlossDtoCarNumber" title="车辆编号" 
			               class="codecode"  style='width:130px'  value="<bean:write name='lloss' property='licenseNo' filter='true' />" 
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem2','-1,1','always','none','post');">
			                 
			               <input type = "hidden" name = "prpLlossFamilyNo" value="<bean:write name='lloss' property='familyNo' filter='true' />" >
			              </td>
		               </tr>
                    <% }%>
 					
 					
 					 <tr>
                         <td class="title" style="width:15%">标的序号：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="text" name="prpLlossDtoItemKindNo"  class="readonly" readonly="readonly" value="<bean:write name='lloss' property='itemKindNo'/>">  
                        </td>    
                     </tr>
                      <tr>  
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode', '1,-1,2,3,4','code');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode', '1,-1,2,3,4','code');"
                             onchange="setFlagDanger();">                  
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2,1,2,3','always','none','post');"
        			              onchange="setFlagDanger();"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">
                        </td>                   
                        <td class="title" style="width:15%"></td>
                        <td class="input" style="width:35%">
                          <input type='hidden' name='LossItemCode'>                                                                   
                          <input type='hidden' name="LossItemName" class='readonly' readonly>
                          <input type="hidden" name="prpLlossDtoAmount" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>">
                        </td>                
                      </tr>                         
                             
                     <tr>                 
                        <td class="title" style="width:15%">损失项目名称:</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                        <input type='hidden' name='prpLlossDtoItemCode' class="codecode" style="width:40"   value="<bean:write name='lloss' property='itemCode'/>" >
                        <input name="prpLlossDtoLossName" class="input"  style="width:200px"  value="<bean:write name='lloss' property='lossName'/>"   onblur="checkRepeatItemCode(this);">
                        <!--  <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2');"> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1','always','none','post');"
                    		    onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1','always','none','post');">
                    		     -->                                                   
        		           
                        </td>                                  
                      </tr> 
                      <tr style="display:none">                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currencyName'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                     <!-- <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                             <input type="hidden" name="prpLlossDtoAmountDisplay" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='##0.00'/>"> 
                             
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">
                        </td>                
                      </tr> -->   
                        
                        <input type="hidden" name="prpLlossDtoItemValue" class="common"  style="width:180px" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">                        
                      <tr>                             
                        <td class="title" style="width:15%">损失币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency2" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency2'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency2Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency2Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">                                                                         
                        </td>            
                      </tr>                                     
                      <tr>
                        <td class="title">核定损失：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumLoss' format='##0.00'/>" onchange="calRealpay(this);calLoss();">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumRest' format='##0.00'/>" onchange="calRealpay(this);calLoss();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='claimRate' format='##0.0000'/>" onchange="calRealpay(this);calLoss();">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='deductibleRate' format='##0.0000'/>" onchange="calRealpay(this);calLoss();">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">赔偿币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency3" class="codecode" style="width:30px" value="<bean:write name='lloss' property='currency3'/>"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrency3Name" class="codecode" style="width:90px" value="<bean:write name='lloss' property='currency3Name'/>"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">  
                        </td>            
                      </tr>      
                          
                      <tr>                             
                        <td class="title" style="width:15%">免赔额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" value="<bean:write name='lloss' property='deductible' format='##0.00'/>" onchange="calRealpay(this);calLoss();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='sumRealPay' format='##0.00'/>"
                           onchange="setFlagDanger();">
                        </td>                 
                      </tr>  
			      <logic:notEmpty name="coinsFlag"  >
					<logic:equal name='coinsFlag' value="2">
                     <tr>                             
                        <td class="title" style="width:15%">共保总赔偿金额</br>（含我方及其它共保方）：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoCoinsSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='coinsSumRealPaid' format='##0.00'/>" onchange="" onblur="calCoinsSumPaid(this);">                                                                            
                        </td>                   
                      </tr>
					</logic:equal>
					<logic:equal name='coinsFlag' value="1">
                     <tr>                             
                        <td class="title" style="width:15%">共保总赔偿金额</br>（含我方及其它共保方）：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoCoinsSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='coinsSumRealPaid' format='##0.00'/>" onchange="" onblur="calCoinsSumPaid(this);">                                                                            
                        </td>                   
                      </tr>
					</logic:equal>
			      </logic:notEmpty>
                     </tbody>  
                   </table>               
               </td>
              <td class="input" style='width:4%'>
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss'),calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
           </tr>
           <!--add by zhulei 20050905 赔款标的间加一条分隔线-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='6'></td>
           </tr>
           
        <%    index24++;%>
           
      </logic:iterate>
      </logic:notEmpty>         
          </tbody>
        </table>  
        </span>    
      </td>
    </tr>
  </table>



