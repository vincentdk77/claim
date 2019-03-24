/**
 @author      yangbo 2009-05-04
 @description 大棚蔬菜理算公式
 @param       无
 @return      无
 @see         UICommon.js#point、round
*/
function calRealpay(field)
{
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
	var Amount		    //险别保额
	var itemCode;		//标的类别
	var realPay;		//赔偿金额		
	var fieldname=field.name;
	var findex=0;
	for(var i=1;i<fm.all(fieldname).length;i++){
		if( fm.all(fieldname)[i] == field ){
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
	lossRate      = parseFloat(fm.all("indemnityDutyRate")[findex].value);
	itemCode	  = fm.all("prpLlossDtoItemCode")[findex].value;
    
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
  	if(isNaN(lossRate))
  		lossRate = 0;
  	else
  		lossRate = lossRate/100;
  		
 	//不同标的走不同的计算公式
  	if(itemCode == "0032"){ //蔬菜作物
  	          //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
      //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      if(calaType == '1' && type == '2'){
        alert("全损赔付只能按照保险金额计算赔付金额");
        fm.cala[findex].options[0].selected = true;
        type= '1';
        //return false;
      }
	//	if(lossRate < 0.9){	  
			//损失程度少于90%,赔偿金额=核定损失×(损失率- 绝对免赔率) ×赔偿比例 – 残值	
	//		realPay	= SumLoss * (lossRate - DeductibleRate) *	ClaimRate - SumRest;			
	//	}
	//	else{						
			//损失程度大于等于90,赔偿金额=核定损失×(1- 绝对免赔率) ×赔偿比例 – 残值
	//		realPay = SumLoss * (1 - DeductibleRate) *	ClaimRate - SumRest;						
	//	}
	  //全损
	  if(calaType == '1'){
	    realPay	= (Amount-SumRest) * (1 - DeductibleRate) *	ClaimRate - Deductible ;
	  }
	  //部分
	  else{
	    //保险金额
	    if(type == '1'){
	    	    realPay	= (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;;
	    }
	    //核定金额
	    else{
	    	    realPay	= (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;;
	    }
	  }
  	}
  	else{					//大棚和棚膜
  		//赔偿金额=核定损失 × 赔偿比例
  		realPay = SumLoss * ClaimRate;
  	}
  	fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(realPay,2),2);
  	fm.all("prpLlossDtoSumRealPay")[findex].focus();
	//计算责任赔款合计、赔款合计、其它费用、实赔金额
	calFund();
}


/**
  这里不用通过赔偿金额反算赔偿比例,这里该为赔偿超额提示
*/
function calClaimRate(field){
	var fieldname=field.name;
	var findex=0;
	for(var i=1;i<fm.all(fieldname).length;i++){
		if( fm.all(fieldname)[i] == field ){
    		findex=i;
      		break;
    	}
  	}
  	var realPay = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value);
  	var Amount  = parseFloat(fm.all("prpLlossDtoAmount")[findex].value);
  	if(isNaN(realPay))
  		realPay = 0;
  	if(isNaN(Amount))
  		Amount = 0;	
  	if(realPay > Amount){ //赔偿金额大于保险金额时按保险金额赔偿  
    	fm.all("prpLlossDtoSumRealPay")[findex].select();
    	alert("险别赔偿金额不能大于险别保险金额！");
    	fm.all("prpLlossDtoSumRealPay")[findex].value = '0.0';
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
  var itemCode;       //险别
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
  itemCode	    = parseFloat(fm.all("prpLlossDtoItemCode")[findex].value);
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
    if(itemCode == "0032"){ //蔬菜作物
      //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
      //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      //如果全损
      if(calaType == '1'){
            //全赔 
            Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible;          
            //Realpay = Amount * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
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
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率    
             Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
             //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
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
            Realpay = (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        }
        }
        }else{
            Realpay = SumLoss * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
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
   fm.all("prpLlossDtoSumRealPay")[findex].focus;
   return;
  }
  
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);
 }
 
  /**
 *输入赔偿金额，反推出 赔付比例（种植险）
 *
*/
 function calClaimRate(field){
  var riskType        //险别
  riskType      = trim(fm.prpLcompensateRiskType.value);
  if(riskType != "H"){
       calRealpay(field);
       return false;
  }
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
  var SumRealPay      //赔偿金额
  var temp;
  var itemCode;		  //标的类别
 
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
  SumRealPay    = parseFloat(fm.all("prpLlossDtoSumRealPay")[findex].value);
  itemCode	    = parseFloat(fm.all("prpLlossDtoItemCode")[findex].value);
  
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
   
  if(isNaN(SumRealPay))
    SumRealPay = 0;
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
  //种植险由赔偿金额反推赔付比例
  if(itemCode == "0032"){ //蔬菜作物
      //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
       //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      if(calaType == '1'){
       //全赔 
         ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (1 - DeductibleRate)); 
       //  fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
      }else{
      //保险金额计算
      if(type=='1'){
        //if(lossRate < 0.3){        
            //理赔起点为30%   
         //   if(lossRate != 0){
         //       ClaimRate = SumRealPay/Amount ; 
        //        fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //    }
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       /// else if(lossRate >= 0.8 ){
            //损失率大于80%时，全赔           
        //    ClaimRate = SumRealPay/Amount ;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
        //    fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率 
            if(((Amount-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              alert("损失率不能等于免赔率或者保险金额不能等于残值");
              return false;
            }                      
            ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (lossRate - DeductibleRate));
            //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
            fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
         //}
          //核定损失计算
        }else{
           //  if(lossRate < 0.3){        
            //理赔起点为30%   
           // if(lossRate != 0){
           //     ClaimRate = SumRealPay/SumLoss; 
           //     fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
           // }
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8 ){
            //损失率大于80%时，全赔           
         //   ClaimRate = SumRealPay/SumLoss;    
         //   fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         //   fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率 
            if(((SumLoss-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              alert("损失率不能等于免赔率或者核定金额不能等于残值");
              return false;
            }                      
            ClaimRate = (SumRealPay+Deductible)/((SumLoss-SumRest) * (lossRate - DeductibleRate));
            //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
           fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
         //}
        }
        }
  }else{
         //赔偿金额=核定损失 × 赔偿比例
         //大棚和棚膜
  		ClaimRate =SumRealPay/SumLoss;
        fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
  }
  
  //免赔额和免赔率是互相独立的,不产生联系  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  
  //add by qinyongli 2005-9-15
  //reason:只有主险才进行控制
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
  if(isMain==1&&Realpay>Amount)
  {  
    //modify by kangzhen  reason 这个几个险种的保费就是保额，实际赔付可能超过保额
    var RiskCode  =fm.prpLcompensateRiskCode.value;
    if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
    {
       alert("赔偿金额不能大于保险金额");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
  
  //计算责任赔款合计、赔款合计、其它费用、实赔金额
  calFund();
  //分险别校验是否超过保单中的限额
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);
 
 }
 
 
 /**
	检查赔付数量是否大于承保数量 
*/
function checkStatQuantity(field){
	if(isNaN(field.value)){
		alert("赔付数量为数字!");
		field.focus();
		field.select();
		return;
	}
	if(isNaN(fm.statQuantity.value)){
		fm.statQuantity.value = 0;
	}
	var statQuantity = Number(fm.statQuantity.value);
	var lossQuantity = Number(field.value);
	if(lossQuantity > statQuantity){
		alert("赔付数量不能大于承保数量! 承保数: "+statQuantity);
		field.focus();
		field.select();
	}
	var riskType= trim(fm.prpLcompensateRiskType.value);
	if(riskType=="H"){
	  var length = fm.prpLlossDtoClaimRate.length;
	  if(length > 1){
	  for(var findex=1; findex<length; findex++){
	  var      SumLoss       = parseFloat(fm.all("prpLlossDtoSumLoss")[findex].value);
      var      SumRest       = parseFloat(fm.all("prpLlossDtoSumRest")[findex].value);
      var      ClaimRate     = parseFloat(fm.all("prpLlossDtoClaimRate")[findex].value);
      var      DeductibleRate= parseFloat(fm.all("prpLlossDtoDeductibleRate")[findex].value);
      var      Deductible    = parseFloat(fm.all("prpLlossDtoDeductible")[findex].value);
      var      itemCode	    = parseFloat(fm.all("prpLlossDtoItemCode")[findex].value);
      var test = fm.all("prpLlossDtoAmountDisplay")[findex].value;
      var n = test.split("-");
      var Amount        = parseFloat(n[0]*field.value);
      fm.all("prpLlossDtoAmount")[findex].value  =  Amount;
      var      riskType      = trim(fm.prpLcompensateRiskType.value);
      var       DutyRate ="";
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
     // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      
       //计算形式：全损赔付
      var calaType = fm.calaType[findex].value;
      //计算类型：保险金额计算，核定损失计算
      var type = fm.cala[findex].value;
      if(itemCode == '0032'){
      if(calaType == '1'){
              Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)- Deductible;
           // Realpay = Amount * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
      }
      
      else{
      
       //按照保险金额计算
      if(type=='1'){
        //if(lossRate < 0.3){        
            //理赔起点为30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
        //    Realpay = Amount * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率         
            Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)- Deductible;
             //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
       // }
        //按照核定损失计算
        }else{
           // if(lossRate < 0.3){        
            //理赔起点为30%   
           // Realpay = 0.0;
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8){
            //损失率大于80%时，全赔           
           // Realpay = SumLoss * ClaimRate;    
          //  fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //损失介于30%~80%时，享受15%的绝对免赔率         
            Realpay = (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
         //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
         // }
        }
        }
        }else{
           Realpay =SumLoss*ClaimRate;
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
  
  //免赔额和免赔率是互相独立的,不产生联系  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:只有主险才进行控制
  var isMain = 1; 
  var kindCode = fm.all("prpLlossDtoKindCode")[findex].value;  
  var kindCodeFlag = kindCode.substring(0,1);   
  if(kindCodeFlag==0){
      isMain = 1;
  }else{
      isMain = 0;
  }
  if(isMain==1&&Realpay>Amount)
  {  
  	//modify by kangzhen  reason 这个几个险种的保费就是保额，实际赔付可能超过保额
  	var RiskCode  =fm.prpLcompensateRiskCode.value;
  	if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
  	{
       alert("赔偿金额不能大于保险金额");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
	   }
	  }
	}
	return;
}
function relateCoinsTreatyNo(){

	var coinsTreatyNo = fm.CoinsTreatyNo.value;
    var reinsWebUrl= fm.reinsWebUrl.value;
    var newWindow = window.open(reinsWebUrl+"/fhcoinstreatyFacade.do?actionType=view&treatyNo="+coinsTreatyNo,"NewWindow","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");

}