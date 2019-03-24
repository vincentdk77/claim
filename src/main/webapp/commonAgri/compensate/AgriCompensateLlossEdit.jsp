<%--
****************************************************************************
* DESC       ：赔付标的信息页面
* AUTHOR     ：liubvo
* CREATEDATE ： 2004-10-18
* MODIFYLIST ：   Name       Date            Reason/Contents
*               qinyongli    2005-9-1        增加新增险别标的的判断
*               chenrd       20070718        农险团单改造，根据被保险人或牛号查找相应承保责任
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page import="com.sinosoft.function.insutil.dto.domain.PrpDexchDto"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindDto"%>
<%@page import="java.text.*"%>
<%@ page import="java.util.*"%>

<%--多行输入自定义JavaScript方法域--%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade"%>
<%@page import="com.sinosoft.claim.bl.facade.BLPrpCitemKindAgriFacade"%>
<%@page import="com.sinosoft.prpall.schema.PrpCvirturlItemSchema"%>
<%@page import="com.sinosoft.claim.dto.domain.PrpCitemKindAgriDto"%>
<%@page import="com.sinosoft.sysframework.common.util.StringUtils"%>
<%@page import="com.sinosoft.prpall.pubfun.GroupProposalService"%>
<script language="javascript">
      //在下面加入本页自定义的JavaScript方法
 
        /*
        插入一条新的lLoss之后的处理（可选方法）
      */
      function afterInsertlLoss()
      {
        setPrpLlossDtoSerialNo();
        setPrpLlossDetailSerialNo();
      }
      
      function setPrpLlossDtoAmount(field){
            var strClassCode = fm.classcodeM.value; 
            for(var i = 0;i < fm.all(field.name).length;i++){
                if(field == fm.all("prpLlossDtoAmountDisplay")[i]){
                  //国元需求：种植险特殊处理
                   if(strClassCode == '31' || fm.prpLcompensateRiskCode.value == '3219' || fm.prpLcompensateRiskCode.value == "3221"){
                     //赔付数量
                     var strMJ = fm.prpLcompensateLossesNumber.value;
                     var test = fm.all("prpLlossDtoAmountDisplay")[i].value;
                     var n = test.split("-");
                     fm.all("prpLlossDtoAmount")[i].value = strMJ * n[0];
                     fm.all("prpLlossDtoSumLoss")[i].value = map.get(fm.all("prpLlossDtoKindCode")[i].value);
                   }else{
                     fm.all("prpLlossDtoAmount")[i].value = fm.all("prpLlossDtoAmountDisplay")[i].value;
                   }
                    //checkKindAmount(fm.all("prpLlossDtoAmount")[i]);
                    break;
                }
            }
      }
      function calPrpLlossDtoAmount(field){
        for(var i = 0 ;i < fm.all("prpLlossDtoItemCode").length;i++){
            if(field == fm.all("prpLlossDtoLossName")[i]){
                checkKindAmount(fm.all("prpLlossDtoAmount")[i],"first");
                break;
            }
        }
      }
      /*
       *检查险别的多条保险金额之和是否超过了该险别的保额
       */
       function checkKindAmount(field,times){  
 
            //如果是由险别名称双击域事件而导致触发了这个函数，则times＝‘first’，如不加这个判断，则在双击险别是可能会弹出两次相同的提示          
            if(times == "first"){
                field.select();
                field.focus();
                return false;           
            }
            var kindCode ;          //险别
            var kindName ;          //险别名称
            var amount = 0;     
            var allAmount = 0;      //保险金额
            var allAmountTemp = 0;
            var lossSerialNo = 0;   //序号
            var lossItemCode ;      //损失标的代码
            var lossItemName ;      //损失标的名称
            var strClassCode = fm.classcodeM.value; 
            for(var i = 0;i < fm.all(field.name).length;i++){                
                if(field == fm.all("prpLlossDtoAmount")[i]){ 
                    if(strClassCode == '31' || fm.prpLcompensateRiskCode.value == "3219" || fm.prpLcompensateRiskCode.value == "3221"){
                     var test = fm.all("prpLlossDtoAmountDisplay")[i].value;
                     var n = test.split("-");
                     allAmount  = parseFloat(n[1]);
                    }else{                                       
                    allAmount  = parseFloat(fm.all("prpLlossDtoAmountDisplay")[i].value);
                    }
                    if(isNaN(allAmount))
                        allAmount = 0;
                    kindCode = fm.all("prpLlossDtoKindCode")[i].value;
                    kindName = fm.all("prpLlossDtoKindName")[i].value;
                    lossSerialNo = fm.all("prpLlossSerialNo")[i].value;
                    lossItemCode = fm.all("prpLlossDtoItemCode")[i].value;
                    lossItemName = fm.all("prpLlossDtoLossName")[i].value;
                }
            }
            //计算页面上输入的各条损失信息的保险金额的和
            for(var i = 0 ;i < fm.all(field.name).length;i++){                
                if(  fm.all("prpLlossSerialNo")[i].value    == lossSerialNo 
                  && fm.all("prpLlossDtoKindCode")[i].value == kindCode
                  && fm.all("prpLlossDtoItemCode")[i].value == lossItemCode){
                    amount = parseFloat(fm.all("prpLlossDtoAmount")[i].value);
                    if(isNaN(amount))
                        amount = 0;
                    allAmountTemp = allAmountTemp + amount;                    
                }
            }            
            if(allAmountTemp > allAmount){
            	field.select();
                field.focus();
                alert("被保险人 （" + fm.all("prpLlossDtoFamilyName")[lossSerialNo].value + "） " + kindName + "（" + lossItemName +"）" + "各条损失信息的保险金额之和，\n"
                        + "超过了该险别的保险金额（"+ allAmount + "）");
                
                return false;
            }
            
       }
      
      /*
        删除本条WarnRegion之后的处理（可选方法）
      */
      function afterDeletelLoss(field)
      {
        
        setPrpLlossDtoSerialNo();
        setPrpLlossDetailSerialNo();
      }
      //给隐藏域的"prpLcompensateIndemnityDutyRate"赋值
    function setIndemnityDutyRate(field){
        fm.prpLcompensateIndemnityDutyRate.value = field.value;
        var rate = fm.prpLcompensateIndemnityDutyRate.value;        
        if(rate < 0 || rate > 100){
            alert("损失率应在 0～100 之间");
            field.select();
            field.focus();
        }
    }
    
    //正算反算赔偿金额不能超过1元
function checkSumRealPay(field){
  var SumLoss;        //核损金额
  var SumRest;        //残值
  var ClaimRate;      //赔偿比例
  var DeductibleRate; //免赔率
  var Deductible;     //免赔额
  var Deductibletemp; //免赔
  var DutyRate;       //责任比例
  var Realpay;        //赔偿金额
  var lossRate        //损失率
  var currency2;      //损失币别
  var currency3;      //赔偿币别
  var exchRate;       //兑换率
  var riskType        //
  var temp;

  //取得当前的数据
  var fieldname=field.name;
  var findex=0;

  for(i=1;i<fm.all(fieldname).length;i++)
  {
    if( fm.all(fieldname)[i] == field )
    {
      findex=i;
      break;
    }
  }
  SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
  SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
  ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
  DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
  Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
  Amount        = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);

  riskType      = trim(fm.prpLcompensateRiskType.value);
  //取损失率
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //获取损失币别和赔偿币别
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3与currency4相等 见UIPrpLLoss.4gl After Field Currency3.
  
  if(currency2!=currency3)
  {
      for (var j=1;j<fm.baseCurrency.length;j++)
      {
          if(fm.baseCurrency[j].value==currency2 && fm.exchCurrency[j].value==currency3)
          {
             exchRate = fm.exchRate[j].value;
             
          }
      }
  }
  else
  {
      exchRate = 1;
  }
  
  //获取损失币别和赔偿币别
   
  
  if(isNaN(Amount))
    Amount = 0;
  if(isNaN(SumLoss))
    SumLoss = 0;
  if(isNaN(SumRest))
    SumRest = 0;
  if(isNaN(ClaimRate))
    ClaimRate = 0;
  else
    ClaimRate = ClaimRate/100;
  if(isNaN(DutyRate))
    DutyRate = 0;
  else
    DutyRate = DutyRate/100;
  if(isNaN(DeductibleRate))
    DeductibleRate = 0;
  else
    DeductibleRate = DeductibleRate/100;
  if(isNaN(Deductible))
    Deductible = 0;
  
  var deductibleFlag=0;
  var deductibleRateFlag=0;
    
   //免赔额、免赔率如果输入只能输入其中一项
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("免赔率与免赔额只能输入一项");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //种植险走不同的计算公式
  if(riskType == "H"){
      //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;

      //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      //如果全损
      if(calaType == '1'){
            //全赔           
            //Realpay = Amount * ClaimRate;
            if(  fm.riskcode.value == "3137"){
            	//赔款金额=单位保额*赔付比例*损失面积 
            	var unitAmount = parseFloat(fm.all("prpCItemKindUnitAmount")[findex].value);
            	var settleArea = parseFloat(fm.all("prpLlossDtoSettleArea")[findex].value);
                Realpay = unitAmount * ClaimRate * settleArea;   
                }
            else 
            	Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible; 
      }else{
       //按照保险金额计算
      if(type=='1'){
        //if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       // else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
       // }
        //else{5=m
        
            //损失介于30%~80%时，享受15%的绝对免赔率        
            
            if(fm.riskcode.value == "3137" ){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
	           	var unitAmount = parseFloat(fm.all("prpCItemKindUnitAmount")[findex].value);
	           	var settleArea = parseFloat(fm.all("prpLlossDtoSettleArea")[findex].value);
                Realpay = unitAmount * ClaimRate * settleArea * lossRate * (1 - DeductibleRate);      
            }else if( fm.prpLcompensateRiskCode.value == "3127")
                Realpay = (Amount) * ClaimRate * lossRate * (1 - DeductibleRate);          	
            else if(fm.riskcode.value == "3173" ){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
	           	Realpay = (Amount-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;     
            }else
            	Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
            
        //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        //按照核定损失计算
        }else{
          //  if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
        //else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
        //    Realpay = SumLoss * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率  
            
        	if(fm.riskcode.value == "3137"){
            //赔款金额=单位保额*赔付比例*损失面积*损失程度*（1-绝对免赔率）
	           	var unitAmount = fm.all("prpCItemKindUnitAmount")[findex].value;
	           	var settleArea = fm.all("prpLlossDtoSettleArea")[findex].value;
            	if(null == unitAmount || "" == unitAmount || null == settleArea || "" == settleArea){
            		alert("本险种不适用核定损失计算方式，请录入赔付面积");
            		return;
            	}
            	alert("本险种不适用核定损失计算方式，将使用单位保额和赔付面积进行计算！");
                Realpay = parseFloat(unitAmount) * ClaimRate * parseFloat(settleArea) * lossRate * (1 - DeductibleRate);      
            }else if( fm.prpLcompensateRiskCode.value == "3127" )
        	    Realpay = (SumLoss) * ClaimRate * lossRate * (1 - DeductibleRate);
        	else if ( fm.prpLcompensateRiskCode.value == "3173" ){
        	    Realpay = (SumLoss-SumRest) * ClaimRate * lossRate * (1 - DeductibleRate)-Deductible;
        	}else
            	Realpay = (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        }
        }
        
  }else{
        if(deductibleRateFlag==0 && deductibleFlag == 0)
        {
           //都没输入
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //输入免赔率后计算公式为 (标的-残值)*赔偿比例*(1-免赔率)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //输入免赔额后计算公式为 (标的-残值)*赔偿比例*-免赔额
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         }
  }
  
  //手工输入的赔付金额
  var pay = fm.all("prpLlossDtoSumRealPay")[findex].value;
  if(Math.abs(pay-Realpay) > 1){
   alert("手工计算赔付金额与系统自动计算赔付金额差额超过1元");
   fm.all("prpLlossDtoSumRealPay")[findex].focus();
   //fm.prpLlossDtoSumRealPay[findex].focus();
   return;
  }
  
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);

    
    }

          </script>

<table class="common" align="center">
	<!--表示显示多行的-->

	<%
		PrpDexchDto prpDexchDto;
		Collection prpdexchDtoList = (Collection) request
				.getAttribute("prpdexchDtoList");
		if (prpdexchDtoList != null) {
			Iterator itprpdexch = prpdexchDtoList.iterator();
			while (itprpdexch.hasNext()) {
				prpDexchDto = (PrpDexchDto) itprpdexch.next();
				out
				.println("  <input type=\"hidden\" name=\"baseCurrency\""
				+ " value=\""
				+ prpDexchDto.getBaseCurrency()
				+ "\""
				+ "\">");
				out
				.println("  <input type=\"hidden\" name=\"exchCurrency\""
				+ " value=\""
				+ prpDexchDto.getExchCurrency()
				+ "\""
				+ "\">");
				out.println("  <input type=\"hidden\" name=\"exchRate\""
				+ " value=\"" + prpDexchDto.getExchRate() + "\""
				+ "\">");
			}
		}
	%>
	<tr style="display:none">
	<td>
  <input type="hidden"
					name="classcodeM"  value="<bean:write name='prpLcompensateDto' property='classCode' />">
	<span style="display: none">
	<table class="common" style="display: none" id="LossDetail_Data"
		cellspacing="1" cellpadding="0">
    <logic:equal name="prpLcompensateDto" property="classCode" value="31">
		<tbody>
			<tr>
			    <td class="inputsubsub">
			   		<input type="text" name="prpLlossDtoItemKindNo" class="readonly" readonly="readonly" style="width: 30px"> 
			    </td>
				<td class="inputsubsub">
			    <input type='hidden'name="prpLlossDtoFeeTypeCode"> 
				<input type='hidden'name="prpLlossDtoFeeTypeName">
				<input type='hidden'name='prpLlossDtoItemAddress'> 
				<input type='hidden'name='prpLlossDtoBuyDate' value="2004/12/12"> 
				<input type='hidden' name='prpLlossDtoDepreRate'> 
				<input type='hidden' name='prpLlossDtoCurrency1' value="<bean:write name='prpLcompensateDto' property='currency' />">
			    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type='hidden' name='prpLlossDtoUnit'> 
				<input type="hidden" name="prpLlossDtoLossQuantity"> 
				<input type="hidden" name="prpLlossDtoUnitPrice">
			    <input type="hidden" name="prpLlossDtoIndemnityDutyRate"> 
			    <input type="hidden" name="prpLlossDtoCurrency2"
					value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type="hidden" name="prpLlossDtoCurrency2Name"
					value="<bean:write name='prpLcompensateDto' property='currencyName' />">
				<input type="hidden" name="prpLlossDtoCurrency3"
					value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type="hidden" name="prpLlossDtoCurrency3Name"
					value="<bean:write name='prpLcompensateDto' property='currencyName' />">
				<input type="hidden" name="prpLlossDtoCurrency"
					value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type="hidden" name="prpLlossDtoCurrencyName"
					value="<bean:write name='prpLcompensateDto' property='currencyName' />">
				<input type='hidden' name='LossItemCode'>
				<input type='hidden' name="LossItemName" class='readonly' readonly>
				<input type="hidden" name="prpLlossDtoKindCode" description="承保险别" onchange="updateUnitAmount(this);">
				<logic:equal name="prpLcompensateDto" property="classCode" value="31">
				<input type="input" name="prpLlossDtoKindName" class="codename"
					style="width: 150px"
					ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,10,5,6','always','none','post');"
					onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,10,5,6','always','none','post');">
				</logic:equal>
				<logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
				<input type="input" name="prpLlossDtoKindName" class="codename"
					style="width: 120px"
					ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,8,5,6','always','none','post');"
					onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,8,5,6','always','none','post');">
				</logic:notEqual>	
				<input type="hidden" name="prpLlossMaxPaid"> 
				<input type="hidden" name="prpLlossHisPaid"></td>
				<td class="inputsubsub">
				<input type="hidden" name="prpLlossDetailSerialNo"> 
				<input type="hidden" name="prpLlossSerialNo">
				<input type="hidden" name="prpLlossDtoItemCode" > 
				<input name="prpLlossDtoLossName" class="readonly" readonly " onchange="calPrpLlossDtoAmount(this);"
					style="width: 80px"></td>
	            <logic:equal name="prpLcompensateDto" property="classCode" value="31">
	            <td >
				<select name="calaType"
					class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
					<option value='1'>全损赔付</option>
					<option value='2'>部分损失赔付</option>
			    </select>		
				</td>
				<td >
				<select name="cala"
					class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
					<option value='1'>保险金额计算</option>
					<option value='2'>核定损失计算</option>
			    </select>		
				</td>	
				</logic:equal>
				<%if(isNewKindCompensate){%>
					<td class="inputsubsub">
						<input type="hidden" name="prpLlossDtoAmount"	class="common"  style="width: 60px" >
				   		<input type="hidden" name="prpLlossDtoAmountDisplay" >
					    <input name="prpCItemKindUnitAmount"	readonly class="common"  style="width: 60px"  onchange="calRealpay(this);calLoss();">
				  	</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoSettleArea"	class="common"  style="width: 60px"  onblur="calRealpay(this);calLoss();">
					</td>
				<%}else{%>
				<td class="inputsubsub">
				    <input name="prpLlossDtoAmount"	class="common"  style="width: 60px"  onblur="calRealpay(this);checkKindAmount(this);">
				   <input type="hidden" name="prpLlossDtoAmountDisplay" onchange="setPrpLlossDtoAmount(this)">
				</td>
				<%}%>
				
			    <td class="inputsubsub"><input name="prpLlossDtoSumLoss"
					class="common" style="width: 60px"
					onblur="calRealpay(this);calLoss();"></td>	
				<logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
				<td class="inputsubsub"><input name="prpLlossDtoItemValue"
					class="common" style="width: 60px"></td>
				</logic:notEqual>	
				<td class="inputsubsub"><input name="prpLlossDtoClaimRate"
					class="common" style="width: 40px" value="100"
					onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)">
				</td>
				<!-- 损失率 -->
				<logic:equal name="prpLcompensateDto" property="classCode" value="31">
				<td class="inputsubsub"><input name="indemnityDutyRate"
                    class="common" style="width: 60px" value="0.0"
                    onblur="calRealpay(this);calLoss();setIndemnityDutyRate(this)">%</td>
                </logic:equal>
				<td class="inputsubsub"><input name="prpLlossDtoDeductibleRate"
					class="common" style="width: 40px" value="0.0"
					onblur="calRealpay(this);calLoss();">%</td>
				<td class="inputsubsub"><input name="prpLlossDtoDeductible"
					type='text' class="input" style="width: 50px" value="0.0"
					onblur="calRealpay(this);calLoss();"></td>
				<td class="inputsubsub"><input name="prpLlossDtoSumRest"
					class="common" style="width: 60px"
					onblur="calRealpay(this);calLoss();"></td>
				<td class="inputsubsub"><input name="prpLlossDtoSumRealPay"
					style="width: 80px" class="input"
					onchange="calFund();calClaimRate(this);" onblur="checkSumRealPay(this);"></td>
        <logic:notEmpty name="coinsFlag"  >
			<logic:equal name='coinsFlag' value="2">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
			<logic:equal name='coinsFlag' value="1">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
		</logic:notEmpty>
				<td class="inputsubsub">
				<div align="center"><input type=button
					name="buttonLossDetailDelete" class="smallbutton"
					onclick="deleteRowTable(this,'LossDetail',1,1),calFund();setFlagDanger();"
					value="-" readonly style="cursor: hand"></div>
				</td>
			</tr>
		</tbody>
	</table>
	</span>

	<span style="display: none">
	<table class="common" style="display: none" id="lLoss_Data"
		cellspacing="1" cellpadding="0">
		<tbody>
			<tr>
				<td class="input" style="width: 4%">
				<div align="center"><input class="readonlyNo" readonly
					name="prpLlossDtoSerialNo" description="序号"></div>
				</td>
				<td class="subformtitle" style="width: 92%">
				<table cellpadding="0" cellspacing="1" class="common"
					style="width: 100%">
					<tr>
						<td class="title" style="width: 15%">被保险人：</td>
						<td class="input" style="width: 35%">
						  <input type="hidden" name="prpLclaimLossAcciCode">
						  <input type="hidden" name="prpLlossDtoFamilyNo">
						  <input type=text name="prpLlossDtoFamilyName" title="被保险人姓名" 
						    style="width: 180px" class="codecode" title="被保险人姓名"
							  ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
							  onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
						<input type="hidden" name="prpLclaimAcciPersonSex"> <input
							type="hidden" name="prpLclaimAcciPersonAge"> <input
							type="hidden" name="prpLclaimAcciPersonIdentifyNumber"></td>
						<td class="title" style="display:none">牛号</td>
						<td class="input" ><%--在农险用车牌号字段暂存牛号--%> <input type='hidden'
							name="prpLlossDtoLicenseNo" description="牛号" class="common"
							onblur="checkInteger(this)" style="width: 180px"></td>
					</tr>
					<tr>
						<td height="1" bgcolor="#6C90DA" colspan='5'><span
							id="spanLossDetail">
						<table id="LossDetail" name="LossDetail" class="common"
							align="center" cellspacing="1" cellpadding="0">
							<thead>
								<tr>
								 <logic:equal name="prpLcompensateDto" property="classCode" value="31">
								 	<%if(isNewKindCompensate){%>
										<td class="subformtitle" colspan="15">赔付信息</td>
									<%}else{%>
										<td class="subformtitle" colspan="14">赔付信息</td>
									<%}%>
								 </logic:equal>
								 <logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
									<td class="subformtitle" colspan="12">赔付信息</td>
								 </logic:notEqual>
								</tr>
								<tr>
									<td class="centertitle">标的序号</td>
									<td class="centertitle">承保险别</td>
									<td class="centertitle">损失标的</td>
									<logic:equal name="prpLcompensateDto" property="classCode" value="31">
									<td class="centertitle">计算形式</td>
									<td class="centertitle">计算方式</td>
									<%
									if(isNewKindCompensate){%>
										<td class="centertitle">单位保险金额</td>
										<td class="centertitle">赔付面积</td>
									<%}else{%>
									<td class="centertitle">出险面积保险金额</td>
									<%}%>
									</logic:equal>
									<logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
									<td class="centertitle">保险金额</td>
									</logic:notEqual>
									<logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
									<td class="centertitle">保险价值</td>
									</logic:notEqual>
									<td class="centertitle">核定损失</td>
									<td class="centertitle">赔付比例%</td>
									<logic:equal name="prpLcompensateDto" property="classCode" value="31">
									<td class="centertitle">损失率%</td>
									</logic:equal>
									<td class="centertitle">免赔率%</td>
									<td class="centertitle">免赔额</td>
									<td class="centertitle">残值</td>
									<td class="centertitle">赔偿金额</td>
									<td class="centertitle" style="width: 3%"></td>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td class="titlesubsub" colspan="14" style="width: 97%"></td>
									<td class="title" align="right" style="width: 4%">
									<div align="center"><input type="button" value="+" class="smallbutton"
										onclick="insertRowTable('LossDetail','LossDetail_Data',this);setFlagDanger();"
										name="buttonLossDetailInsert" readonly style="cursor: hand">
									</div>
									</td>
								</tr>
	                	   </tfoot>
	                        <tbody>
							</tbody>
						</table>
						</span></td>
					</tr>
				</table>
				</td>
				<td class="input" style="width: 4%">
				<div align="center"><input type=button
					name="buttonlLossDelete" class="smallbutton"
					onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-"
					style="cursor: hand"></div>
				</td>
			</tr>
		</tbody>
	</table>
	</span>
	</td>
	</tr>
	<tr>
		<td class="subformtitle" colspan="4" style="text-align: left"><img
			style="cursor: hand;" src="/claim/images/butCollapseBlue.gif"
			name="lLossImg" onclick="showPage(this,spanlLoss)">赔付标的信息<br>
		<span id="spanlLoss" style="display: none"> <%-- 多行输入展现域 --%>
		<table id="lLoss" class="common" align="center" cellspacing="1"
			cellpadding="0">
			<thead>
				<tr>
					<td class="title" style="width: 4%">序号</td>
					<td class="title" style="width: 96%" colspan=2>内容</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td class="title" colspan=2 style="width: 96%">
					<logic:equal name="prpLcompensateDto" property="classCode" value="31">
					
					 </logic:equal>
					(按"+"号键增加险别信息，按"-"号键删除信息)</td>
					<td class="title" align="right" style="width: 4%">
					<div align="center"><input type="button" value="+"
						onclick="insertRow('lLoss');setFlagDanger();" class="smallbutton"
						name="buttonlLossInsert" style="cursor: hand"></div>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<%
					int index = 1;
					int intLossCount = 0;
				%>

				<logic:notEmpty name="prpLacciPersonDto"
					property="prpLagriPersonList">
					<logic:iterate id="prpLagriPerson" name="prpLacciPersonDto"
						property="prpLagriPersonList">
						<tr>
							<td class="input" style="width: 4%">
							<div align="center"><input class="readonlyNo" readonly
								name="prpLlossDtoSerialNo" description="序号"
								value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
							</div>
							</td>
							<td class="subformtitle" style="width: 92%">
							<table cellpadding="0" cellspacing="1" class="common"
								style="width: 100%">
								<tr>
									<td class="title" style="width: 15%">被保险人：</td>
									<td class="input" style="width: 35%">
									  <input type="hidden" name="prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
									  <input type="hidden" name="prpLlossDtoFamilyNo"
										  value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
									<input type=text name="prpLlossDtoFamilyName" title="被保险人姓名"
										style="width: 180px" class="codecode" title="被保险人姓名"
										value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
										ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
										onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
									<input type="hidden" name="prpLclaimAcciPersonSex"
										value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
									<input type="hidden" name="prpLclaimAcciPersonAge"
										value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
									<input type="hidden" name="prpLclaimAcciPersonIdentifyNumber"
										value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">

									</td>
									<td class="title" style="width:15%;display:none">牛号：</td>
									<td class="input" style="width: 35%"><%--在农险用车牌号字段暂存牛号--%>
									<input type="hidden" name="prpLlossDtoLicenseNo" description="牛号"
										class="common" onblur="checkInteger(this)"
										style="width: 180px"
										value="<bean:write name='prpLagriPerson' property='address' filter='true' />">
									</td>
								</tr>
								<tr>
									<td height="1" bgcolor="#6C90DA" colspan='4'><span
										id="spanLossDetail">
									<table id="LossDetail" name="LossDetail" class="common"
										align="center" cellspacing="1" cellpadding="0">
										<thead>
											<tr>
											 	<%if(isNewKindCompensate){%>
													<td class="subformtitle" colspan="15">赔付信息</td>
												<%}else{%> 
													<td class="subformtitle" colspan="14">赔付信息</td>
												<%}%> 
											</tr>
											<tr>
									<td class="centertitle">标的序号</td>
								    <td class="centertitle">承保险别</td>
									<td class="centertitle">损失标的</td>
									<td class="centertitle">计算形式</td>
									<td class="centertitle">计算方式</td>
									<%if(isNewKindCompensate){%>
										<td class="centertitle">单位保险金额</td>
										<td class="centertitle">赔付面积</td>
									<%}else{%>
									<td class="centertitle">出险面积保险金额</td>
									<%}%>
									<td class="centertitle">核定损失</td>
									<td class="centertitle">赔付比例%</td>
									<td class="centertitle">损失率%</td>
									<td class="centertitle">免赔率%</td>
									<td class="centertitle">免赔额</td>
									<td class="centertitle">残值</td>
									<td class="centertitle">赔偿金额</td>
									<logic:notEmpty name="coinsFlag"  >
										<logic:equal name='coinsFlag' value="2">
					                       <td class="centertitle">共保总赔偿金额</br>（含我方及其它共保方）：</td>
										</logic:equal>
										<logic:equal name='coinsFlag' value="1">
					                       <td class="centertitle">共保总赔偿金额</br>（含我方及其它共保方）：</td>
										</logic:equal>
									</logic:notEmpty>
									<td class="centertitle" style="width: 3%"></td>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<td class="titlesubsub" colspan="14" style="width: 97%"></td>
												<td class="title" align="right" style="width: 4%">
												<div align="center"><input type="button" value="+"
												    class="smallbutton"
													onclick="insertRowTable('LossDetail','LossDetail_Data',this);setFlagDanger();"
													name="buttonLossDetailInsert" readonly style="cursor: hand">
												</div>
												</td>
											</tr>
										</tfoot>
										<tbody>
											<%
														PrpLlossDto prpLlossDto = (PrpLlossDto) request
														.getAttribute("prpLlossDto");
												int intPersonNo = 0;
												if (prpLlossDto.getPrpLlossList() != null) {
													Iterator iterator1 = prpLlossDto.getPrpLlossList().iterator();
													while (iterator1.hasNext()) {
														PrpLlossDto prpLlossDto1 = (PrpLlossDto) iterator1.next();
														if (prpLlossDto1.getFlag() != null
														&& !prpLlossDto1.getFlag().equals("")) {
													intPersonNo = Integer.parseInt(prpLlossDto1.getFlag());
														}
														if (intPersonNo == index) {
													intLossCount++;
											%>
			<tr>
			   <td class="inputsubsub">
			       <input type="text" name="prpLlossDtoItemKindNo"  style="width: 30px"
					         value="<%= prpLlossDto1.getItemKindNo() %>" readonly="readonly" class="readonly">
			   </td>
				<td class="inputsubsub">
						<input type='hidden' name="prpLlossDtoFeeTypeCode" 
						       value="<%= prpLlossDto1.getFeeTypeCode() %>"> 
						<input type='hidden' name="prpLlossDtoFeeTypeName" 
						       value="<%= prpLlossDto1.getFeeTypeName() %>">
						<input type='hidden' name='prpLlossDtoItemAddress' 
						       value="<%= prpLlossDto1.getItemAddress() %>">
						<input type='hidden' name='prpLlossDtoBuyDate'     
						       value="2004/12/12">
						<input type='hidden' name='prpLlossDtoDepreRate'   
						       value="<%= prpLlossDto1.getDepreRate() %>"> 
						<input type='hidden' name='prpLlossDtoCurrency1'   
						       value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type='hidden' name='prpLlossDtoCurrency4'   
						       value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type='hidden' name='prpLlossDtoUnit'
                   value="<%= prpLlossDto1.getUnit()%>">
						<input type="hidden" name="prpLlossDtoLossQuantity"
                   value="<%= prpLlossDto1.getLossQuantity() %>">
						<input type="hidden" name="prpLlossDtoUnitPrice"
                   value="<%= prpLlossDto1.getUnitPrice() %>">
						<input type="hidden" name="prpLlossDtoIndemnityDutyRate"
                   value="<%= prpLlossDto1.getIndemnityDutyRate() %>">
						<input type="hidden" name="prpLlossDtoCurrency2"
                   value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type="hidden" name="prpLlossDtoCurrency2Name"
                   value="<bean:write name='prpLcompensateDto' property='currencyName' />">
						<input type="hidden" name="prpLlossDtoCurrency3"
                   value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type="hidden" name="prpLlossDtoCurrency3Name"
                   value="<bean:write name='prpLcompensateDto' property='currencyName' />">
						<input type="hidden" name="prpLlossDtoCurrency"
                   value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type="hidden" name="prpLlossDtoCurrencyName"
                   value="<bean:write name='prpLcompensateDto' property='currencyName' />">
						<input type='hidden' name='LossItemCode'> 
						<input type='hidden' name="LossItemName" class='readonly' readonly>						
						<input type="hidden" name="prpLlossDtoKindCode" description="承保险别" value="<%= prpLlossDto1.getKindCode() %>" onchange="updateUnitAmount(this);"> 
						<input type="input"  name="prpLlossDtoKindName" class="codename" style="width: 150px"
							     ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,10,5,6','always','none','post');"
							     onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,10,5,6','always','none','post');"
							     value="<%= prpLlossDto1.getKindName() %>">
					
					  <input type="hidden" name="prpLlossMaxPaid">
					  <input type="hidden" name="prpLlossHisPaid">
				 </td>
				 <td class="inputsubsub">
				    <input type="hidden" name="prpLlossDetailSerialNo"
                   value="<%=intLossCount%>">
					  <input type="hidden" name="prpLlossSerialNo"
                   value="<%= prpLlossDto1.getFlag() %>">
					  <input type="hidden" name="prpLlossDtoItemCode"
                   value="<%= prpLlossDto1.getItemCode() %>">
					  <input name="prpLlossDtoLossName" class="readonly" readonly	style="width: 80px"
                   value="<%= prpLlossDto1.getLossName() %>">
					</td>
						            <%
	            String t1 = "1";
	            String t2 = "1";
	            if((prpLlossDto1.getRemark() != null) && !"".equals(prpLlossDto1.getRemark()) && prpLlossDto1.getRemark().contains("-")){
	            	String[] temp = prpLlossDto1.getRemark().split("-");
	            	t1 = temp[0];
	            	t2 = temp[1];
	            	
	            }
	            %>
			   <td >
				<select name="calaType" id ="calaTypeId"
					class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
					<option value='1' <%= "1".equals(t1)?"selected":"" %>>全损赔付</option>
					<option value='2' <%= "2".equals(t1)?"selected":"" %>>部分损失赔付</option>
			    </select>		
				</td>
				<td >
				<select name="cala" id ="calaId"
					class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
					<option value='1' <%= "1".equals(t2)?"selected":"" %>>保险金额计算</option>
					<option value='2' <%= "2".equals(t2)?"selected":"" %>>核定损失计算</option>
			    </select>
				</td>
				<%
		         GroupProposalService groupProposalService = new GroupProposalService();
		         //是否是团单的标志
		         String  strRiskCode =   prpLlossDto1.getRiskCode();
		         boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
				 String conditions ="PolicyNo ='"+prpLlossDto1.getPolicyNo()+"'  and  KindCode = '"+prpLlossDto1.getKindCode()+"' and familyno = '"+prpLlossDto1.getFamilyNo()+"'  and itemcode='"+prpLlossDto1.getItemCode()+"'";
				 String StrPrpLlossDtoAmountDisplay="";
			     BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
			     BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new  BLPrpCitemKindAgriFacade();    
			     if(isVirturlItemRisk){
			    	 Collection  collection = (ArrayList)blPrpCitemKindFacade.findVirturlItemByConditions(conditions);
			          int recordSize=collection.size();
				         for(Iterator iterator = collection.iterator();iterator.hasNext();)
				         {    
				           PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)iterator.next();
				           if("3102".equals(strRiskCode) && prpCvirturlItemSchema.getKindCode().equals("001")
				        		   						 && prpCvirturlItemSchema.getItemCode().equals("0032")){
			            	   String querySql = " policyNo="+prpCvirturlItemSchema.getPolicyNo() +
			            	   					 " and kindCode='001' and times > 0" ;
			            	   Collection agris = blPrpCitemKindAgriFacade.findByConditions(querySql);
			            	   if(agris.size() > 0){
			            		   PrpCitemKindAgriDto agriDto = (PrpCitemKindAgriDto)agris.iterator().next();
			            		   double amount = Double.parseDouble(prpCvirturlItemSchema.getAmount());
			            		   prpCvirturlItemSchema.setAmount(String.valueOf(agriDto.getDistributingRate()*amount/100));
			            	   }
			               }
				             //种植险由于计算公式修改：需要单位保额和险别总保额
				             if("31".equals(strRiskCode.substring(0,2))){
				            	 StrPrpLlossDtoAmountDisplay=prpCvirturlItemSchema.getUnitAmount()+"-"+prpCvirturlItemSchema.getAmount();
				             }else{
				            	 StrPrpLlossDtoAmountDisplay=""+prpCvirturlItemSchema.getAmount();
				             }
				           }
			     }else{
			     Collection collection = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
			     int    recordSize=collection.size();
				         for(Iterator iterator = collection.iterator();iterator.hasNext();)
				         {    
				               PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
				               if("3102".equals(strRiskCode) && prpCitemKindDto.getKindCode().equals("001") 
				            		   						 && prpCitemKindDto.getItemCode().equals("0032")){
				            	   String querySql = " policyNo="+prpCitemKindDto.getPolicyNo() +
				            	   					 " and kindCode='001' and times > 0"; 
				            	   Collection agris = blPrpCitemKindAgriFacade.findByConditions(querySql);
				            	   if(agris.size() > 0){
				            		   PrpCitemKindAgriDto agriDto = (PrpCitemKindAgriDto)agris.iterator().next();
				            		   prpCitemKindDto.setAmount(agriDto.getTimesAmount());
				            	   }
				               }
			             //种植险由于计算公式修改：需要单位保额和险别总保额		             
			             if("31".equals(strRiskCode.substring(0,2))){
			            	 StrPrpLlossDtoAmountDisplay=prpCitemKindDto.getUnitAmount()+"-"+prpCitemKindDto.getAmount();
			             }else{
			            	 StrPrpLlossDtoAmountDisplay=""+prpCitemKindDto.getAmount();
			             }
				         }
			     }
				%>
				  
				  <%if(isNewKindCompensate){%>
				  
					<td class="inputsubsub">
					    <input name="prpCItemKindUnitAmount" readonly class="common" style="width: 60px"  onchange="calRealpay(this);calLoss();">
					    <input name="prpLlossDtoAmount"	class="common"  style="width: 60px" type="hidden" value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getAmount()) %>">
				     	<input type="hidden" " name="prpLlossDtoAmountDisplay" value="<%=StrPrpLlossDtoAmountDisplay %>">
				  	</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoSettleArea"	class="common"  style="width: 60px"  onblur="calRealpay(this);calLoss();" value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getSettleArea()) %>">
					</td>
				<%}else{%>
				<td class="inputsubsub">
				    <input name="prpLlossDtoAmount"	class="common"  style="width: 60px"
                   value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getAmount()) %>"  onblur="calRealpay(this);checkKindAmount(this);">
				     <input type="hidden" " name="prpLlossDtoAmountDisplay" onchange="setPrpLlossDtoAmount(this)" value="<%=StrPrpLlossDtoAmountDisplay %>">
				  <!--
				   <input type="hidden" " name="prpLlossDtoAmountDisplay" onchange="setPrpLlossDtoAmount(this)" value="<%=prpLlossDto1.getAmount() %>">
				  -->
				  </td>
				<%}%>
				   <!-- 
					<td class="inputsubsub">
					   <input name="prpLlossDtoItemValue" class="common"	style="width: 60px"
                    value="<%= prpLlossDto1.getItemValue() %>">
					</td> -->
					<td class="inputsubsub">
					    <input name="prpLlossDtoSumLoss" class="common"  style="width: 60px" onblur="calRealpay(this);calLoss();"
                     value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getSumLoss()) %>">
					</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoClaimRate" class="common"  style="width: 40px" onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)"
                     value="<%= prpLlossDto1.getClaimRate() %>">% 
					</td>
                    <td class="inputsubsub"><input name="indemnityDutyRate"
                            class="common" style="width: 60px" value="<%= prpLlossDto1.getIndemnityDutyRate() %>"
                            onblur="calRealpay(this);calLoss();setIndemnityDutyRate(this)"></td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoDeductibleRate" class="common" style="width: 40px" onblur="calRealpay(this);calLoss();"
                     value="<%= prpLlossDto1.getDeductibleRate() %>">%
					</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoDeductible" type='text' class="input"	style="width: 50px" onblur="calRealpay(this);calLoss();"
						         value="<%= prpLlossDto1.getDeductible() %>">
				  </td>
				  <td class="inputsubsub">
					    <input name="prpLlossDtoSumRest" class="common"	style="width: 60px" onblur="calRealpay(this);calLoss();"
					           value="<%= prpLlossDto1.getSumRest() %>">
					</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoSumRealPay" style="width: 80px"	class="input" onchange="calFund();calClaimRate(this)"
					           value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getSumRealPay()) %>">
					</td>
        <logic:notEmpty name="coinsFlag"  >
			<logic:equal name='coinsFlag' value="2">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
			<logic:equal name='coinsFlag' value="1">
                <td class="inputsubsub">
                <input name="prpLlossDtoCoinsSumRealPay" type='text' class="input" style="width:180px" onblur="calCoinsSumPaid(this);" onchange="">                                                                     
                </td>                   
			</logic:equal>
		</logic:notEmpty>
					<td class="inputsubsub">
						<div align="center">
							<input type=button name="buttonLossDetailDelete" onclick="deleteRowTable(this,'LossDetail',1,1),calFund();"
								     class="smallbutton"
								     value="-" readonly style="cursor: hand">
						</div>
					</td>
				</tr>
					<%
							}
							}

						}
					%>
										</tbody>
									</table>
									</span></td>
								</tr>
							</table>
							</td>
							<td class="input" style="width: 4%">
							<div align="center"><input type=button
								name="buttonlLossDelete" class="smallbutton"
								onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-"
								style="cursor: hand"></div>
							</td>
						</tr>
						<%
						index++;
						%>
					</logic:iterate>
				</logic:notEmpty>
			</tbody>
		</table>
		</span></td>
	</tr>


</logic:equal>


							
<logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
<tbody>
			<tr>
			    <td class="inputsubsub">
			   		<input type="text" name="prpLlossDtoItemKindNo" class="readonly" readonly="readonly" style="width: 30px"> 
			    </td>
				<td class="inputsubsub">
				<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3219">
					<input  type='hidden' name="indemnityDutyRate"
                    class="common" style="width: 60px" value="0.0">
				</logic:notEqual>
			    <input type='hidden'name="prpLlossDtoFeeTypeCode">
				<input type='hidden'name="prpLlossDtoFeeTypeName"> 
				<input type='hidden'name='prpLlossDtoItemAddress'>
				<input type='hidden'name='prpLlossDtoBuyDate' value="2004/12/12"> 
				<input type='hidden' name='prpLlossDtoDepreRate'> 
				<input type='hidden' name='prpLlossDtoCurrency1'value="<bean:write name='prpLcompensateDto' property='currency' />">
			    <input type='hidden' name='prpLlossDtoCurrency4' value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type='hidden' name='prpLlossDtoUnit'>
				<input type="hidden" name="prpLlossDtoLossQuantity">
			    <input type="hidden" name="prpLlossDtoUnitPrice">
				<input type="hidden" name="prpLlossDtoIndemnityDutyRate"> 
				<input type="hidden" name="prpLlossDtoCurrency2"
					value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type="hidden" name="prpLlossDtoCurrency2Name"
					value="<bean:write name='prpLcompensateDto' property='currencyName' />">
				<input type="hidden" name="prpLlossDtoCurrency3"
					value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type="hidden" name="prpLlossDtoCurrency3Name"
					value="<bean:write name='prpLcompensateDto' property='currencyName' />">
				<input type="hidden" name="prpLlossDtoCurrency"
					value="<bean:write name='prpLcompensateDto' property='currency' />">
				<input type="hidden" name="prpLlossDtoCurrencyName"
					value="<bean:write name='prpLcompensateDto' property='currencyName' />">
				<input type='hidden' name='LossItemCode'> <input
					type='hidden' name="LossItemName" class='readonly' readonly>
				<input type="hidden" name="prpLlossDtoKindCode" description="承保险别">
				<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3219">
					<input type="input" name="prpLlossDtoKindName" class="codename"
						style="width: 150px"
						ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-22,8,5,6','always','none','post');"
						onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-22,8,5,6','always','none','post');">
				</logic:notEqual>
				<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
					<input type="input" name="prpLlossDtoKindName" class="codename"
					style="width: 150px"
					ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,9,5,6','always','none','post');"
					onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,9,5,6','always','none','post');">
				</logic:equal>
				
				<input type="hidden" name="prpLlossMaxPaid">
				<input type="hidden" name="prpLlossHisPaid">
				</td>
				<td class="inputsubsub">
				<input type="hidden" name="prpLlossDetailSerialNo">
				<input type="hidden" name="prpLlossSerialNo"> 
				<input type="hidden" name="prpLlossDtoItemCode" >
				<input name="prpLlossDtoLossName" class="readonly" readonly " onchange="calPrpLlossDtoAmount(this);" style="width: 80px">
				</td>
				<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
		            <td >
					<select name="calaType" class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
						<option value='2' selected>部分损失赔付</option>
						<option value='1'>全损赔付</option>
				    </select>		
					</td>
				</logic:equal>
				<td class="inputsubsub">
				    <input name="prpLlossDtoAmount"	class="common"  style="width: 60px"  onblur="calRealpay(this);checkKindAmount(this);">
				    <input type="hidden" name="prpLlossDtoAmountDisplay" onchange="setPrpLlossDtoAmount(this)">
				</td>
				<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3221">
					<td class="inputsubsub"><input name="prpLlossDtoItemValue"
						class="common" style="width: 60px"></td>
				</logic:notEqual>
				<logic:equal name="prpLcompensateDto" property="riskCode" value="3221">
					<td class="inputsubsub"><input name="prpLlossDtoItemValue"
						class="common" style="width: 60px" onblur="calRealpay(this);calLoss();"></td>
				</logic:equal>
				<td class="inputsubsub"><input name="prpLlossDtoSumLoss"
					class="common" style="width: 60px"
					onblur="calRealpay(this);calLoss();"></td>
				<td class="inputsubsub"><input name="prpLlossDtoSumRest"
					class="common" style="width: 60px"
					onblur="calRealpay(this);calLoss();"></td>
				<!-- 损失率 -->
				<logic:equal name="prpLcompensateDto" property="classCode" value="31">
				<td class="inputsubsub"><input name="indemnityDutyRate"
                    class="common" style="width: 60px" value="0.0"
                    onblur="calRealpay(this);calLoss();setIndemnityDutyRate(this)">%</td>
                </logic:equal>
                <logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
				<td class="inputsubsub"><input name="indemnityDutyRate"
                    class="common" style="width: 60px" value="0.0"
                    onblur="calRealpay(this);calLoss();setIndemnityDutyRate(this)">%</td>
                </logic:equal>
				<td class="inputsubsub"><input name="prpLlossDtoClaimRate"
					class="common" style="width: 40px" value="100"
					onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)">%
				</td>
				<td class="inputsubsub"><input name="prpLlossDtoDeductibleRate"
					class="common" style="width: 40px" value="0.0"
					onblur="calRealpay(this);calLoss();">%</td>
				<td class="inputsubsub"><input name="prpLlossDtoDeductible"
					type='text' class="input" style="width: 50px" value="0.0"
					onblur="calRealpay(this);calLoss();"></td>
				<td class="inputsubsub"><input name="prpLlossDtoSumRealPay"
					style="width: 80px" class="input"
					onchange="calFund();calClaimRate(this)"></td>
				<td class="inputsubsub">
				<div align="center"><input type=button
					name="buttonLossDetailDelete" class="smallbutton"
					onclick="deleteRowTable(this,'LossDetail',1,1),calFund();setFlagDanger();"
					value="-" readonly style="cursor: hand"></div>
				</td>
			</tr>
		</tbody>
	</table>
	</span>

	<span style="display: none">
	<table class="common" style="display: none" id="lLoss_Data"
		cellspacing="1" cellpadding="0">
		<tbody>
			<tr>
				<td class="input" style="width: 4%">
				<div align="center"><input class="readonlyNo" readonly
					name="prpLlossDtoSerialNo" description="序号"></div>
				</td>
				<td class="subformtitle" style="width: 92%">
				<table cellpadding="0" cellspacing="1" class="common"
					style="width: 100%">
					<tr>
						<td class="title" style="width: 15%">被保险人：</td>
						<td class="input" style="width: 35%">
						  <input type="hidden" name="prpLclaimLossAcciCode">
						  <input type="hidden" name="prpLlossDtoFamilyNo">
						  <input type=text name="prpLlossDtoFamilyName" title="被保险人姓名" 
						    style="width: 180px" class="codecode" title="被保险人姓名"
							  ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
							  onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
						<input type="hidden" name="prpLclaimAcciPersonSex"> <input
							type="hidden" name="prpLclaimAcciPersonAge"> <input
							type="hidden" name="prpLclaimAcciPersonIdentifyNumber"></td>
						<td class="title" style="display:none">牛号</td>
						<td class="input" ><%--在农险用车牌号字段暂存牛号--%> <input type='hidden'
							name="prpLlossDtoLicenseNo" description="牛号" class="common"
							onblur="checkInteger(this)" style="width: 180px"></td>
					</tr>
					<tr>
						<td height="1" bgcolor="#6C90DA" colspan='4'><span
							id="spanLossDetail">
						<table id="LossDetail" name="LossDetail" class="common"
							align="center" cellspacing="1" cellpadding="0">
							<thead>
								<tr>
									<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
										<td class="subformtitle" colspan="14">赔付信息</td>
									</logic:equal>
									<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3219">
										<td class="subformtitle" colspan="12">赔付信息</td>
									</logic:notEqual>
								</tr>
								<tr>
								    <td class="centertitle">标的序号</td>
									<td class="centertitle">承保险别</td>
									<td class="centertitle">损失标的</td>
									<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
										<td class="centertitle">计算形式</td>
									</logic:equal>
									<td class="centertitle">保险金额</td>
									<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3221">
									<td class="centertitle">保险价值</td>
									</logic:notEqual>
									<logic:equal name="prpLcompensateDto" property="riskCode" value="3221">
									<td class="centertitle">尸重</td>
									</logic:equal>
									<td class="centertitle">核定损失</td>
									<td class="centertitle">残值</td>
									<logic:equal name="prpLcompensateDto" property="classCode" value="31">
									<td class="centertitle">损失率%</td>
									</logic:equal>
									<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
                                      <td class="centertitle">损失率%</td>
                                    </logic:equal>	
                                    <td class="centertitle">赔付比例%</td>
									<td class="centertitle">免赔率%</td>
									<td class="centertitle">免赔额</td>
									<td class="centertitle">赔偿金额</td>
									<td class="centertitle" style="width: 3%"></td>
								</tr>
							</thead>							

							
							
		<tfoot>
								<tr>
                                    <td class="titlesubsub" colspan="11" style="width: 97%"></td>
									<td class="title" align="right" style="width: 4%">
									<div align="center"><input type="button" value="+"
										onclick="insertRowTable('LossDetail','LossDetail_Data',this);"
										class="smallbutton"
										name="buttonLossDetailInsert" readonly style="cursor: hand">
									</div>
									</td>
								</tr>
		</tfoot>
	                        <tbody>
							</tbody>
						</table>
						</span></td>
					</tr>
				</table>
				</td>
				<td class="input" style="width: 4%">
				<div align="center"><input type=button
					name="buttonlLossDelete" class="smallbutton"
					onclick="deleteRow(this,'lLoss'),calFund()" value="-"
					style="cursor: hand"></div>
				</td>
			</tr>
		</tbody>
	</table>
	</span>

	<tr>
		<td class="subformtitle" colspan="4" style="text-align: left"><img
			style="cursor: hand;" src="/claim/images/butCollapseBlue.gif"
			name="lLossImg" onclick="showPage(this,spanlLoss)">赔付标的信息<br>
		<span id="spanlLoss" style="display: none"> <%-- 多行输入展现域 --%>
		<table id="lLoss" class="common" align="center" cellspacing="1"
			cellpadding="0">
			<thead>
				<tr>
					<td class="title" style="width: 4%">序号</td>
					<td class="title" style="width: 96%" colspan=2>内容</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td class="title" colspan=2 style="width: 96%">
					<logic:equal name="prpLcompensateDto" property="classCode" value="31">
					<br><br><br>
					<font color="#ED1B24">
					 全损赔付：<br>
					         （保险金额-残值）× 赔付比例×（1-免赔率）-免赔额<br>
					 部分损失赔付：<br>
					         （保险金额-残值）× 赔付比例×（损失率-免赔率）-免赔额<br>
					         （损失金额-残值）× 赔付比例×（损失率-免赔率）-免赔额<br>  
					 </font>
					 </logic:equal>
					(按"+"号键增加险别信息，按"-"号键删除信息)</td>
					<td class="title" align="right" style="width: 4%">
					<div align="center"><input type="button" value="+"
						onclick="insertRow('lLoss')" class="smallbutton"
						name="buttonlLossInsert" style="cursor: hand"></div>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<%
					int index = 1;
					int intLossCount = 0;
				%>

				<logic:notEmpty name="prpLacciPersonDto"
					property="prpLagriPersonList">
					<logic:iterate id="prpLagriPerson" name="prpLacciPersonDto"
						property="prpLagriPersonList">
						<tr>
							<td class="input" style="width: 4%">
							<div align="center"><input class="readonlyNo" readonly
								name="prpLlossDtoSerialNo" description="序号"
								value="<bean:write name='prpLagriPerson' property='serialNo' filter='true' />">
							</div>
							</td>
							<td class="subformtitle" style="width: 92%">
							<table cellpadding="0" cellspacing="1" class="common"
								style="width: 100%">
								<tr>
									<td class="title" style="width: 15%">被保险人：</td>
									<td class="input" style="width: 35%">
									  <input type="hidden" name="prpLclaimLossAcciCode" value="<bean:write name='prpLagriPerson' property='acciCode' filter='true' />">
									  <input type="hidden" name="prpLlossDtoFamilyNo"
										  value="<bean:write name='prpLagriPerson' property='familyNo' filter='true' />">
									<input type=text name="prpLlossDtoFamilyName" title="被保险人姓名"
										style="width: 180px" class="codecode" title="被保险人姓名"
										value="<bean:write name='prpLagriPerson' property='acciName' filter='true' />"
										ondblclick="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');"
										onkeyup="code_CodeSelect(this, 'prpCinsuredVirturlItem','-1,1,2,3,-2','always','none','post');">
									<input type="hidden" name="prpLclaimAcciPersonSex"
										value="<bean:write name='prpLagriPerson' property='sex' filter='true' />">
									<input type="hidden" name="prpLclaimAcciPersonAge"
										value="<bean:write name='prpLagriPerson' property='age' filter='true' />">
									<input type="hidden" name="prpLclaimAcciPersonIdentifyNumber"
										value="<bean:write name='prpLagriPerson' property='identifyNumber' filter='true' />">

									</td>
									<td class="title" style="width:15%;display:none">牛号：</td>
									<td class="input" style="width: 35%"><%--在农险用车牌号字段暂存牛号--%>
									<input type="hidden" name="prpLlossDtoLicenseNo" description="牛号"
										class="common" onblur="checkInteger(this)"
										style="width: 180px"
										value="<bean:write name='prpLagriPerson' property='address' filter='true' />">
									</td>
								</tr>
								<tr>
									<td height="1" bgcolor="#6C90DA" colspan='4'><span
										id="spanLossDetail">
									<table id="LossDetail" name="LossDetail" class="common"
										align="center" cellspacing="1" cellpadding="0">
										<thead>
											<tr>
												<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
													<td class="subformtitle" colspan="14">赔付信息</td>
												</logic:equal>
												<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3219">
													<td class="subformtitle" colspan="12">赔付信息</td>
												</logic:notEqual>
											</tr>
											<tr>
												<td class="centertitle">标的序号</td>
												<td class="centertitle">承保险别</td>
												<td class="centertitle">损失标的</td>
												<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
													<td class="centertitle">计算形式</td>
												</logic:equal>
												<td class="centertitle">保险金额</td>
												<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3221">
												<td class="centertitle">保险价值</td>
												</logic:notEqual>
												<logic:equal name="prpLcompensateDto" property="riskCode" value="3221">
												<td class="centertitle">尸重</td>
												</logic:equal>
												<td class="centertitle">核定损失</td>
												<td class="centertitle">残值</td>	
												<logic:equal name="prpLcompensateDto" property="classCode" value="31">
                                                 <td class="centertitle">损失率</td>
                                                </logic:equal>											
                                                <logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
                                                 <td class="centertitle">损失率%</td>
                                                </logic:equal>	
                                                <td class="centertitle">赔付比例%</td>
												<td class="centertitle">免赔率%</td>
												<td class="centertitle">免赔额</td>
												<td class="centertitle">赔偿金额</td>
												<td class="centertitle" style="width: 3%"></td>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<logic:equal name="prpLcompensateDto" property="classCode" value="31">
                                                    <td class="titlesubsub" colspan="13" style="width: 97%"></td>
                                                </logic:equal>
                                                <logic:notEqual name="prpLcompensateDto" property="classCode" value="31">
                                                   <logic:notEqual name="prpLcompensateDto" property="riskCode" value="3219">
                                                   		<td class="titlesubsub" colspan="11" style="width: 97%"></td>
                                                   </logic:notEqual>
                                                   <logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
                                                   		<td class="titlesubsub" colspan="13" style="width: 97%"></td>
                                                   </logic:equal>
                                                </logic:notEqual>
												<td class="title" align="right" style="width: 4%">
												<div align="center"><input type="button" value="+"
												    class="smallbutton"
													onclick="insertRowTable('LossDetail','LossDetail_Data',this);"
													name="buttonLossDetailInsert" readonly style="cursor: hand">
												</div>
												</td>
											</tr>
										</tfoot>
										<tbody>
											<%
														PrpLlossDto prpLlossDto = (PrpLlossDto) request
														.getAttribute("prpLlossDto");
												int intPersonNo = 0;
												if (prpLlossDto.getPrpLlossList() != null) {
													Iterator iterator1 = prpLlossDto.getPrpLlossList().iterator();
													while (iterator1.hasNext()) {
														PrpLlossDto prpLlossDto1 = (PrpLlossDto) iterator1.next();
														if (prpLlossDto1.getFlag() != null
														&& !prpLlossDto1.getFlag().equals("") ) {
													intPersonNo = Integer.parseInt(prpLlossDto1.getFlag());
														}
														if (intPersonNo == index) {
													intLossCount++;
													if ((!"3219".equals(prpLlossDto1.getRiskCode()) && !"3221".equals(prpLlossDto1.getRiskCode())) 
															|| (("3219".equals(prpLlossDto1.getRiskCode()) && !editType.equals("ADD"))
																	|| ("3221".equals(prpLlossDto1.getRiskCode()) && !editType.equals("ADD")))){
											%>
			<tr>
			    <td class="inputsubsub">
			       <input type="text" name="prpLlossDtoItemKindNo" 
					         value="<%= prpLlossDto1.getItemKindNo() %>" class='readonly' readonly style="width: 30px">
			    </td>
				<td class="inputsubsub">
						<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3219">
					        <input  type='hidden' name="indemnityDutyRate"
	                        class="common" style="width: 60px" value="0.0">
                        </logic:notEqual>
						<input type='hidden' name="prpLlossDtoFeeTypeCode" 
						       value="<%= prpLlossDto1.getFeeTypeCode() %>"> 
						<input type='hidden' name="prpLlossDtoFeeTypeName" 
						       value="<%= prpLlossDto1.getFeeTypeName() %>">
						<input type='hidden' name='prpLlossDtoItemAddress' 
						       value="<%= prpLlossDto1.getItemAddress() %>">
						<input type='hidden' name='prpLlossDtoBuyDate'     
						       value="2004/12/12">
						<input type='hidden' name='prpLlossDtoDepreRate'   
						       value="<%= prpLlossDto1.getDepreRate() %>"> 
						<input type='hidden' name='prpLlossDtoCurrency1'   
						       value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type='hidden' name='prpLlossDtoCurrency4'   
						       value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type='hidden' name='prpLlossDtoUnit'
                   value="<%= prpLlossDto1.getUnit()%>">
						<input type="hidden" name="prpLlossDtoLossQuantity"
                   value="<%= prpLlossDto1.getLossQuantity() %>">
						<input type="hidden" name="prpLlossDtoUnitPrice"
                   value="<%= prpLlossDto1.getUnitPrice() %>">
						<input type="hidden" name="prpLlossDtoIndemnityDutyRate"
                   value="<%= prpLlossDto1.getIndemnityDutyRate() %>">
						<input type="hidden" name="prpLlossDtoCurrency2"
                   value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type="hidden" name="prpLlossDtoCurrency2Name"
                   value="<bean:write name='prpLcompensateDto' property='currencyName' />">
						<input type="hidden" name="prpLlossDtoCurrency3"
                   value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type="hidden" name="prpLlossDtoCurrency3Name"
                   value="<bean:write name='prpLcompensateDto' property='currencyName' />">
						<input type="hidden" name="prpLlossDtoCurrency"
                   value="<bean:write name='prpLcompensateDto' property='currency' />">
						<input type="hidden" name="prpLlossDtoCurrencyName"
                   value="<bean:write name='prpLcompensateDto' property='currencyName' />">
						<input type='hidden' name='LossItemCode'> 
						<input type='hidden' name="LossItemName" class='readonly' readonly>
						
						<input type="hidden" name="prpLlossDtoKindCode" description="承保险别" value="<%= prpLlossDto1.getKindCode() %>"> 
						<input type="input"  name="prpLlossDtoKindName" class="codename" style="width: 150px"
							     ondblclick="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,8,5,6','always','none','post');"
							     onkeyup="code_CodeSelect(this, 'KindCodeVirturlItem','-1,-21,8,5,6','always','none','post');"
							     value="<%= prpLlossDto1.getKindName() %>">
					
					  <input type="hidden" name="prpLlossMaxPaid">
					  <input type="hidden" name="prpLlossHisPaid">
				 </td>
				 <td class="inputsubsub">
				    <input type="hidden" name="prpLlossDetailSerialNo"
                   value="<%=intLossCount%>">
					  <input type="hidden" name="prpLlossSerialNo"
                   value="<%= prpLlossDto1.getFlag() %>">
					  <input type="hidden" name="prpLlossDtoItemCode"
                   value="<%= prpLlossDto1.getItemCode() %>">
					  <input name="prpLlossDtoLossName" class="readonly" readonly	style="width: 80px"
                   value="<%= prpLlossDto1.getLossName() %>">
					</td>
					 <%
	            String t1 = "1";
	            if((prpLlossDto1.getRemark() != null) && !"".equals(prpLlossDto1.getRemark())){
	            	String temp = prpLlossDto1.getRemark();
	            	t1 = temp;
	            	
	            }
	            %>
				<logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
		            <td >
					<select name="calaType" id ="calaTypeId"
					class="common" style="width: 110px" onchange="calRealpay(this);calLoss();">
					<option value='1' <%= "1".equals(t1)?"selected":"" %>>全损赔付</option>
					<option value='2' <%= "2".equals(t1)?"selected":"" %>>部分损失赔付</option>
			    </select>		
					</td>
				</logic:equal>			
									<%
		         GroupProposalService groupProposalService = new GroupProposalService();
		         //是否是团单的标志
		         String  strRiskCode =   prpLlossDto1.getRiskCode();
		         boolean isVirturlItemRisk = groupProposalService.isGroupProposal(strRiskCode);
				 String conditions ="PolicyNo ='"+prpLlossDto1.getPolicyNo()+"'  and  KindCode = '"+prpLlossDto1.getKindCode()+"' and familyno = '"+prpLlossDto1.getFamilyNo()+"'  and itemcode='"+prpLlossDto1.getItemCode()+"'";
				 String StrPrpLlossDtoAmountDisplay="";
			     BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
			     BLPrpCitemKindAgriFacade blPrpCitemKindAgriFacade = new  BLPrpCitemKindAgriFacade();    
			     if(isVirturlItemRisk){
			    	 Collection  collection = (ArrayList)blPrpCitemKindFacade.findVirturlItemByConditions(conditions);
			          int recordSize=collection.size();
				         for(Iterator iterator = collection.iterator();iterator.hasNext();)
				         {    
				           PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema)iterator.next();
				           if("3102".equals(strRiskCode) && prpCvirturlItemSchema.getKindCode().equals("001")
				        		   						 && prpCvirturlItemSchema.getItemCode().equals("0032")){
			            	   String querySql = " policyNo="+prpCvirturlItemSchema.getPolicyNo() +
			            	   					 " and kindCode='001' and times > 0" ;
			            	   Collection agris = blPrpCitemKindAgriFacade.findByConditions(querySql);
			            	   if(agris.size() > 0){
			            		   PrpCitemKindAgriDto agriDto = (PrpCitemKindAgriDto)agris.iterator().next();
			            		   double amount = Double.parseDouble(prpCvirturlItemSchema.getAmount());
			            		   prpCvirturlItemSchema.setAmount(String.valueOf(agriDto.getDistributingRate()*amount/100));
			            	   }
			               }
				             //种植险由于计算公式修改：需要单位保额和险别总保额
				             if("31".equals(strRiskCode.substring(0,2)) || "3219".equals(strRiskCode)|| "3221".equals(strRiskCode)){
				            	 StrPrpLlossDtoAmountDisplay=prpCvirturlItemSchema.getUnitAmount()+"-"+prpCvirturlItemSchema.getAmount();
				             }else{
				            	 StrPrpLlossDtoAmountDisplay=""+prpCvirturlItemSchema.getAmount();
				             }
				           }
			     }else{
			     
			     Collection collection = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
			     int    recordSize=collection.size();
				         for(Iterator iterator = collection.iterator();iterator.hasNext();)
				         {    
				               PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto)iterator.next();
				               if("3102".equals(strRiskCode) && prpCitemKindDto.getKindCode().equals("001") 
				            		   						 && prpCitemKindDto.getItemCode().equals("0032")){
				            	   String querySql = " policyNo="+prpCitemKindDto.getPolicyNo() +
				            	   					 " and kindCode='001' and times > 0"; 
				            	   Collection agris = blPrpCitemKindAgriFacade.findByConditions(querySql);
				            	   if(agris.size() > 0){
				            		   PrpCitemKindAgriDto agriDto = (PrpCitemKindAgriDto)agris.iterator().next();
				            		   prpCitemKindDto.setAmount(agriDto.getTimesAmount());
				            	   }
				               }
			             //种植险由于计算公式修改：需要单位保额和险别总保额
			             if("31".equals(strRiskCode.substring(0,2)) || "3219".equals(strRiskCode) || "3221".equals(strRiskCode)){
			            	 StrPrpLlossDtoAmountDisplay=prpCitemKindDto.getUnitAmount()+"-"+prpCitemKindDto.getAmount();
			             }else{
			            	 StrPrpLlossDtoAmountDisplay=""+prpCitemKindDto.getAmount();
			             }
				         }
			     }
				%>
				  <td class="inputsubsub">
				    <input name="prpLlossDtoAmount"	class="common"  style="width: 60px"
                   value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getAmount()) %>"  onblur="calRealpay(this);checkKindAmount(this);">
				    <input type="hidden" " name="prpLlossDtoAmountDisplay" onchange="setPrpLlossDtoAmount(this)" value="<%=StrPrpLlossDtoAmountDisplay %>">
				  </td>
					<logic:notEqual name="prpLcompensateDto" property="riskCode" value="3221">
					<td class="inputsubsub"><input name="prpLlossDtoItemValue"
						class="common" style="width: 60px" value="<%= prpLlossDto1.getItemValue() %>"></td>
					</logic:notEqual>
					<logic:equal name="prpLcompensateDto" property="riskCode" value="3221">
						<td class="inputsubsub"><input name="prpLlossDtoItemValue"
							class="common" style="width: 60px" value="<%= prpLlossDto1.getItemValue() %>" onblur="calRealpay(this);calLoss();"></td>
					</logic:equal>
					<td class="inputsubsub">
					    <input name="prpLlossDtoSumLoss" class="common"  style="width: 60px" onblur="calRealpay(this);calLoss();"
                     value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getSumLoss()) %>">
					</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoSumRest" class="common"	style="width: 60px" onblur="calRealpay(this);calLoss();"
					           value="<%= prpLlossDto1.getSumRest() %>">
					</td>
					<logic:equal name="prpLcompensateDto" property="classCode" value="31">
                       <td class="inputsubsub"><input name="indemnityDutyRate"
                            class="common" style="width: 60px" value="<%= prpLlossDto1.getIndemnityDutyRate() %>"
                            onblur="calRealpay(this);calLoss();setIndemnityDutyRate(this)"></td>
                    </logic:equal>
                    <logic:equal name="prpLcompensateDto" property="riskCode" value="3219">
                       <td class="inputsubsub"><input name="indemnityDutyRate"
                            class="common" style="width: 60px" value="<%= prpLlossDto1.getIndemnityDutyRate() %>"
                            onblur="calRealpay(this);calLoss();setIndemnityDutyRate(this);">%</td>
                    </logic:equal>
					<td class="inputsubsub">
					    <input name="prpLlossDtoClaimRate" class="common"  style="width: 40px" onblur="calRealpay(this);calLoss();return isRightDutyPercent(this)"
                     value="<%= prpLlossDto1.getClaimRate() %>">% 
						</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoDeductibleRate" class="common" style="width: 40px" onblur="calRealpay(this);calLoss();"
                     value="<%= prpLlossDto1.getDeductibleRate() %>">%
					</td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoDeductible" type='text' class="input"	style="width: 50px" onblur="calRealpay(this);calLoss();"
						         value="<%= prpLlossDto1.getDeductible() %>">
				  </td>
					<td class="inputsubsub">
					    <input name="prpLlossDtoSumRealPay" style="width: 80px"	class="input" onchange="calFund();calClaimRate(this)"
					           value="<%= new DecimalFormat("##0.00").format(prpLlossDto1.getSumRealPay()) %>">
					</td>
					<td class="inputsubsub">
						<div align="center">
							<input type=button name="buttonLossDetailDelete" onclick="deleteRowTable(this,'LossDetail',1,1),calFund();"
							         class="smallbutton"
								     value="-" readonly style="cursor: hand">
						</div>
					</td>
				</tr>
					<%
							}
														}
							}

						}
					%>
										</tbody>
									</table>
									</span></td>
								</tr>
							</table>
							</td>
							<td class="input" style="width: 4%">
							<div align="center"><input type=button
								name="buttonlLossDelete" class="smallbutton"
								onclick="deleteRow(this,'lLoss');calFund();setFlagDanger();" value="-"
								style="cursor: hand"></div>
							</td>
						</tr>
						<%
						index++;
						%>
					</logic:iterate>
				</logic:notEmpty>
			</tbody>
		</table>
		</span></td>
	</tr>
</logic:notEqual>