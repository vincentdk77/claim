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
   String strRiskCode = (String)request.getAttribute("riskCode");
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
    /*
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
     */
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
        
        
       function isRightDutyPercent(field){
        var lPercent=0;
        var strmsg="";
        var i=0;

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
                 </div>
             </td>
             <td class="subformtitle"  style="width:92%">   
                 <table  cellpadding="0" cellspacing="1" class="common" style="width:100%">
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
                   <tr>                             
                        <td class="title" style="width:15%">标的序号：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoItemKindNo class="readonly" readonly="readonly" style="width:40"                            
                            onchange="setFlagDanger();">                 
                        </td> 
                    </tr>
                    <tr>                             
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" 
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1','code','none','post');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1','code','none','post');"
                            onchange="setFlagDanger();">                 
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" 
        		    ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        		    onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        		    onchange="setFlagDanger();" > 
                          <input type='hidden' name='prpLlossItemKindNo'> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                    
                        </td> 
 					</tr>
 					 <%if("ZH01".equals(strRiskCode) || "ZH02".equals(strRiskCode)){ %>
 					 <tr>
 					 	<td class="title" style="width:15%">事故者名称：</td> 
                 		<td class="input" style="width:35%" colspan="3">
			               <input type = "hidden" name = "prpLlossFamilyNo" style="width:40%" >
			               <input type=text name="prpLlossFamilyName" title="事故者姓名" style="width:40%" 
			               class="codecode"  title="事故者姓名"
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,3,4','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,3,4','always','none','post');">
          				 </td>
          				</tr>
          				<tr>                 
	                        <td class="title" style="width:15%">损失标的：</td>                                                                   
	                        <td class="input" style="width:85%" colspan="3">
	                          <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40"  
	                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1');"
	                            onblur="checkRepeatItemCode(this);"
	                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1');"> 
	                          <input name="prpLlossDtoLossName" class="codename"  style="width:330px"  
	                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1','always','none','post');"
	                            onblur="checkRepeatItemCode(this);"
	        		 	        onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1','always','none','post');">  
		            		
	                        </td>                                  
                      </tr>  
                 	<%}else if("2204".equals(strRiskCode)){%>
                      <tr>                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40" 
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');" 
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');" 
                            onblur="checkRepeatItemCode(this);"
                            onchange="judgeKindCode(this)";> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:330px"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');"
        		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');" >                                                                        
                        </td>                
                      </tr> 
					<%}else if("0310".equals(strRiskCode)||"0312".equals(strRiskCode)){%>
					<tr>
                      <td class="title" style="width:15%">损失标的：</td>                                                                   
                      <td class="input" style="width:85%" colspan="3">
                        <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40" 
                          ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');" 
                          onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3');" 
                          onblur="checkRepeatItemCode(this);"
                          onchange="judgeKindCode(this)";> 
                        <input type='hidden' name="prpLlossDtoLossName" class="codename"  style="width:330px"
                          ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');"
      		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2','always','none','post');" >                                                                        
                      </td>
                    </tr> 
                    <!-- 0313碎屏险添加imei字段 add by wangxinyang 2018/6/19 -->
                    <%}else if("0313".equals(strRiskCode)){%>
                    <tr style="display:">                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:35%">
                          <input type='text' name='prpLlossDtoItemCode' class="codecode" style="width:40" 
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4,5');" 
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4,5');" 
                            onblur="checkRepeatItemCode(this);"
                            onchange="judgeKindCode(this)";> 
                          <input type='text' name="prpLlossDtoLossName" class="codename"  style="width:330px"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3,4','always','none','post');"
        		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3,4','always','none','post');" >                                                                        
                        </td>
                        <td class="title" style="width:15%">IMEI码：</td>                                                                   
                        <td class="input" style="width:35%">
                          <input type='text' name='prpLlossDtoImei' class="readonly" readonly>
                        </td>
                      </tr>
                 	<%} else {%>
                        <tr style="display:">                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40" 
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4');" 
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4');" 
                            onblur="checkRepeatItemCode(this);"
                            onchange="judgeKindCode(this)";> 
                          <input type='input' name="prpLlossDtoLossName" class="codename"  style="width:330px"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');"
        		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');" >                                                                        
                        </td>                
                      </tr> 
                      
                      <%} %>
                      <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                           <input type="text" name="prpLlossDtoAmountDisplay"  value="" class='readonly' readonly>
                           <input type="hidden" name="prpLlossDtoAmount" value="" class='readonly' readonly >
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px">
                        </td>                
                      </tr>   
                      <tr style="display:none">                             
                        <td class="title" style="width:15%">币别：</td>
                        <td class="input" style="width:35%" colspan="3"> 
                          <input type="text" name="prpLlossDtoCurrency" class="codecode" style="width:30px"  value="<bean:write name='prpLcompensateDto' property='currency' />"
                             ondblclick="code_CodeSelect(this, 'Currency');"
                             onkeyup= "code_CodeSelect(this, 'Currency');">
                          <input type="text" name="prpLlossDtoCurrencyName" class="codecode" style="width:90px"  value="<bean:write name='prpLcompensateDto' property='currencyName' />"
                             ondblclick="code_CodeSelect(this, 'Currency','-1','always','none','post');"
                             onkeyup= "code_CodeSelect(this, 'Currency','-1','always','none','post');">             
                        </td>            
                      </tr>                        
                      <tr>                             
                        <td class="title" style="width:15%">核定币别：</td>
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
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px"  value="100" onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)" onchange="setFlagDanger();">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="0" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">赔付币别：</td>
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
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" onblur="calRealpay(this);calLoss();" onchange="setFlagDanger();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" onchange="calFund();calRealpay(this);setFlagDanger();">
                        </td>                 
                      </tr>  
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
                       <!--add by zhulei 20050905 赔款标的间加一条分隔线-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='4'></td>
           </tr>
                   </table>     
               </td>
               
              <td class="input" style="width:4%">
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
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
                 <input type="button" value="+" onclick="insertRow('lLoss');setFlagDanger();" class="smallbutton" name="buttonlLossInsert" style="cursor: hand">
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
                     <tr>                             
                        <td class="title" style="width:15%">标的序号：</td> 
                        <td class="input" style="width:35%" colspan="3">
                           <input type='text' class="readonly" readonly="readonly" name='prpLlossDtoItemKindNo' value="<bean:write name='lloss' property='itemKindNo'/>"> 
                        </td>                
                      </tr>    
                      <tr>                             
                        <td class="title" style="width:15%">险别：</td> 
                        <td class="input" style="width:35%" colspan="3">
                          <input type="input" name=prpLlossDtoKindCode class="codecode" style="width:40" value="<bean:write name='lloss' property='kindCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyKindCode','1,-1','code','none','post');"
                            onkeyup= "code_CodeSelect(this, 'PolicyKindCode','1,-1','code','none','post');"
                             onchange="setFlagDanger();">                  
                          <input type="input" name=prpLlossDtoKindName class="codename" style="width:110" value="<bean:write name='lloss' property='kindName'/>"
        			             ondblclick="code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        			             onkeyup= "code_CodeSelect(this, 'PolicyKindCode','-1,-2','always','none','post');"
        			              onchange="setFlagDanger();"> 
                          <img src="/claim/images/bgMarkMustInput.jpg">                                                     
                          <input type='hidden' name='LossItemCode'>                                                                   
                          <input type='hidden' name="LossItemName" class='readonly' readonly>
                        </td>                
                      </tr>                         
                  <%if("ZH01".equals(strRiskCode) || "ZH02".equals(strRiskCode)){ %>
 					 <tr>
 					 	 <td class="title" style="width:15%">事故者名称：</td> 
                 		 <td class="input" style="width:35%" colspan="3">
			               <input type = "hidden" name = "prpLlossFamilyNo" style="width:40%"  value="<bean:write name='lloss' property='familyNo' filter='true' />">
			               <input type=text name="prpLlossFamilyName" title="事故者姓名" style="width:40%"   value="<bean:write name='lloss' property='familyName' filter='true' />"
			               class="codecode"  title="事故者姓名"
			               ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,3,4','always','none','post');"
			               onkeyup= "code_CodeSelect(this, 'prpCinsuredVirturlItem1','-1,3,4','always','none','post');">
			           </td>
			          <tr>
			          <tr>                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1');"> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1','always','none','post');"
                            onblur="checkRepeatItemCode(this);"
        		 	        onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1','always','none','post');">  
	            		
                        </td>                                  
                      </tr> 
                 <%}else if("2204".equals(strRiskCode)){%>                     
                      <tr style="display:none">>                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='hidden' name='prpLlossDtoItemCode' class="codecode" style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4');"> 
                          <input type='hidden' name="prpLlossDtoLossName" class="codename"  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');"
                            onblur="checkRepeatItemCode(this);"
        		 	        onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');">  
	            		
                        </td>                                  
                      </tr> 
                    <%}else if("0313".equals(strRiskCode)){%>
                    <tr>                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:35%">
                          <input type='text' name='prpLlossDtoItemCode' class="codecode" style="width:40" 
                            value="<bean:write name='lloss' property='itemCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4,5');" 
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4,5');" 
                            onblur="checkRepeatItemCode(this);"
                            onchange="judgeKindCode(this)";> 
                          <input type='text' name="prpLlossDtoLossName" class="codename"  style="width:330px"
                            value="<bean:write name='lloss' property='lossName'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3,4','always','none','post');"
        		            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3,4','always','none','post');" >                                                                        
                        </td>
                        <td class="title" style="width:15%">IMEI码：</td>                                                                   
                        <td class="input" style="width:35%">
                          <input type='text' name='prpLlossDtoImei' class="readonly" readonly value="<bean:write name='lloss' property='imei'/>">
                        </td>
                      </tr> 
                      <%}else{ %>
                      <tr>                 
                        <td class="title" style="width:15%">损失标的：</td>                                                                   
                        <td class="input" style="width:85%" colspan="3">
                          <input type='input' name='prpLlossDtoItemCode' class="codecode" style="width:40"   value="<bean:write name='lloss' property='itemCode'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4');"
                            onblur="checkRepeatItemCode(this);"
                            onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','1,2,3,4');"> 
                          <input name="prpLlossDtoLossName" class="codename"  style="width:330px"  value="<bean:write name='lloss' property='lossName'/>"
                            ondblclick="code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');"
                            onblur="checkRepeatItemCode(this);"
        		 	        onkeyup= "code_CodeSelect(this, 'PolicyItemKindCode','-1,1,2,3','always','none','post');">  
	            		
                        </td>                                  
                      </tr> 
                      <%} %>
                      <tr>                             
                        <td class="title" style="width:15%">保险金额：</td>
                        <td class="input" style="width:35%">
                            <input type="hidden" name="prpLlossDtoAmount" class='readonly' readonly value="<bean:write name='lloss' property='amount'/>">
                            <input type="text" name="prpLlossDtoAmountDisplay" class='readonly' readonly value="<bean:write name='lloss' property='amount' format='#,##0.00'/>"> 
                        </td>                   
                        <td class="title" style="width:15%">保险价值：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoItemValue" class="common"  style="width:180px" value="<bean:write name='lloss' property='itemValue' format='##0.00'/>">
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
                     
                        
                      <tr>                             
                        <td class="title" style="width:15%">核定币别：</td>
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
                          <input name="prpLlossDtoSumLoss" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumLoss' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">
                        </td>
                        <td class="title">残值：</td>
                        <td class="input">
                          <input name="prpLlossDtoSumRest" class="common"  style="width:180px" value="<bean:write name='lloss' property='sumRest' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">
                        </td>                  
                      </tr>                              
                      <tr>
                        <td class="title">赔付比例：</td> 
                        <td class="input">                          
                          <input name="prpLlossDtoClaimRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='claimRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">%
                        </td>
                        <td class="title">免赔率：</td>
                        <td class="input">
                          <input name="prpLlossDtoDeductibleRate"  class="common"  style="width:180px" value="<bean:write name='lloss' property='deductibleRate' format='##0.0000'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">%
                        </td>                  
                      </tr>
                      <tr>                             
                        <td class="title" style="width:15%">赔付币别：</td>
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
                          <input name="prpLlossDtoDeductible" type='text' class="input" style="width:180px" value="<bean:write name='lloss' property='deductible' format='##0.00'/>"  onblur="calRealpay(this);calLoss();"
                          onchange="setFlagDanger();">                                                                            
                        </td>                   
                        <td class="title" style="width:15%">赔偿金额：</td>
                        <td class="input" style="width:35%">
                          <input name="prpLlossDtoSumRealPay" style="width:180px" class="input" value="<bean:write name='lloss' property='sumRealPay' format='##0.00'/>" onchange="calFund();calRealpay(this);setFlagDanger();">
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

                      <!--add by zhulei 20050905 赔款标的间加一条分隔线-->
           <tr>
             <td height="1" bgcolor="#6C90DA" colspan='4'></td>
           </tr>
                   </table>               
               </td>
              <td class="input" style='width:4%'>
              <div align="center">
                <input type=button name="buttonlLossDelete"  class="smallbutton" onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-" style="cursor: hand">
              </div>
              </td> 
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



