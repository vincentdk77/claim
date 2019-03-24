/**
 @author      yangbo 2009-05-04
 @description �����߲����㹫ʽ
 @param       ��
 @return      ��
 @see         UICommon.js#point��round
*/
function calRealpay(field)
{
	var SumLoss;        //������
	var SumRest;        //��ֵ
	var ClaimRate;      //�⳥����
	var DeductibleRate; //������
	var Deductible;     //�����
	var Deductibletemp; //����
	var DutyRate;       //���α���
	var Realpay;        //�⳥���
	var lossRate        //��ʧ��
	var currency2;      //��ʧ�ұ�
	var currency3;      //�⳥�ұ�
	var exchRate;       //�һ���
	var Amount		    //�ձ𱣶�
	var itemCode;		//������
	var realPay;		//�⳥���		
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
  		
 	//��ͬ����߲�ͬ�ļ��㹫ʽ
  	if(itemCode == "0032"){ //�߲�����
  	          //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
      //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      if(calaType == '1' && type == '2'){
        alert("ȫ���⸶ֻ�ܰ��ձ��ս������⸶���");
        fm.cala[findex].options[0].selected = true;
        type= '1';
        //return false;
      }
	//	if(lossRate < 0.9){	  
			//��ʧ�̶�����90%,�⳥���=�˶���ʧ��(��ʧ��- ����������) ���⳥���� �C ��ֵ	
	//		realPay	= SumLoss * (lossRate - DeductibleRate) *	ClaimRate - SumRest;			
	//	}
	//	else{						
			//��ʧ�̶ȴ��ڵ���90,�⳥���=�˶���ʧ��(1- ����������) ���⳥���� �C ��ֵ
	//		realPay = SumLoss * (1 - DeductibleRate) *	ClaimRate - SumRest;						
	//	}
	  //ȫ��
	  if(calaType == '1'){
	    realPay	= (Amount-SumRest) * (1 - DeductibleRate) *	ClaimRate - Deductible ;
	  }
	  //����
	  else{
	    //���ս��
	    if(type == '1'){
	    	    realPay	= (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;;
	    }
	    //�˶����
	    else{
	    	    realPay	= (SumLoss-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;;
	    }
	  }
  	}
  	else{					//�������Ĥ
  		//�⳥���=�˶���ʧ �� �⳥����
  		realPay = SumLoss * ClaimRate;
  	}
  	fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(realPay,2),2);
  	fm.all("prpLlossDtoSumRealPay")[findex].focus();
	//�����������ϼơ����ϼơ��������á�ʵ����
	calFund();
}


/**
  ���ﲻ��ͨ���⳥�����⳥����,�����Ϊ�⳥������ʾ
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
  	if(realPay > Amount){ //�⳥�����ڱ��ս��ʱ�����ս���⳥  
    	fm.all("prpLlossDtoSumRealPay")[findex].select();
    	alert("�ձ��⳥���ܴ����ձ��ս�");
    	fm.all("prpLlossDtoSumRealPay")[findex].value = '0.0';
  	}
}

   //���㷴���⳥���ܳ���1Ԫ
function checkSumRealPay(field){
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⳥���
  var lossRate        //��ʧ��
  var currency2;      //��ʧ�ұ�
  var currency3;      //�⳥�ұ�
  var exchRate;       //�һ���
  var riskType        //
  var temp;
  var itemCode;       //�ձ�
  //ȡ�õ�ǰ������
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
  //ȡ��ʧ��
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //��ȡ��ʧ�ұ���⳥�ұ�
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3��currency4��� ��UIPrpLLoss.4gl After Field Currency3.
  
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
  
  //��ȡ��ʧ�ұ���⳥�ұ�
   
  
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
    
   //�����������������ֻ����������һ��
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //��ֲ���߲�ͬ�ļ��㹫ʽ
  if(riskType == "H"){
    if(itemCode == "0032"){ //�߲�����
      //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
      //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      //���ȫ��
      if(calaType == '1'){
            //ȫ�� 
            Realpay = (Amount-SumRest) * ClaimRate * (1 - DeductibleRate)-Deductible;          
            //Realpay = Amount * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      }else{
       //���ձ��ս�����
      if(type=='1'){
        //if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       // else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
       //     Realpay = Amount * ClaimRate;    
       //     fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
       // }
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������    
             Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)-Deductible;
             //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
        //}
        //���պ˶���ʧ����
        }else{
          //  if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
        //else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
        //    Realpay = SumLoss * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������         
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
           //��û����
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //���������ʺ���㹫ʽΪ (���-��ֵ)*�⳥����*(1-������)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //������������㹫ʽΪ (���-��ֵ)*�⳥����*-�����
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         }
  }
  
  //�ֹ�������⸶���
  var pay = fm.all("prpLlossDtoSumRealPay")[findex].value;
  if(Math.abs(pay-Realpay) > 1){
   alert("�ֹ������⸶�����ϵͳ�Զ������⸶������1Ԫ");
   fm.all("prpLlossDtoSumRealPay")[findex].focus;
   return;
  }
  
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);
 }
 
  /**
 *�����⳥�����Ƴ� �⸶��������ֲ�գ�
 *
*/
 function calClaimRate(field){
  var riskType        //�ձ�
  riskType      = trim(fm.prpLcompensateRiskType.value);
  if(riskType != "H"){
       calRealpay(field);
       return false;
  }
  var SumLoss;        //������
  var SumRest;        //��ֵ
  var ClaimRate;      //�⳥����
  var DeductibleRate; //������
  var Deductible;     //�����
  var Deductibletemp; //����
  var DutyRate;       //���α���
  var Realpay;        //�⳥���
  var lossRate        //��ʧ��
  var currency2;      //��ʧ�ұ�
  var currency3;      //�⳥�ұ�
  var exchRate;       //�һ���
  var SumRealPay      //�⳥���
  var temp;
  var itemCode;		  //������
 
  //ȡ�õ�ǰ������
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
  
  //ȡ��ʧ��
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //��ȡ��ʧ�ұ���⳥�ұ�
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3��currency4��� ��UIPrpLLoss.4gl After Field Currency3.
  
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
  
  //��ȡ��ʧ�ұ���⳥�ұ�
   
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
    
   //�����������������ֻ����������һ��
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //��ֲ�����⳥�����⸶����
  if(itemCode == "0032"){ //�߲�����
      //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
       //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      if(calaType == '1'){
       //ȫ�� 
         ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (1 - DeductibleRate)); 
       //  fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
      }else{
      //���ս�����
      if(type=='1'){
        //if(lossRate < 0.3){        
            //�������Ϊ30%   
         //   if(lossRate != 0){
         //       ClaimRate = SumRealPay/Amount ; 
        //        fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //    }
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
       // }
       /// else if(lossRate >= 0.8 ){
            //��ʧ�ʴ���80%ʱ��ȫ��           
        //    ClaimRate = SumRealPay/Amount ;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
        //    fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ��������� 
            if(((Amount-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              alert("��ʧ�ʲ��ܵ��������ʻ��߱��ս��ܵ��ڲ�ֵ");
              return false;
            }                      
            ClaimRate = (SumRealPay+Deductible)/((Amount-SumRest) * (lossRate - DeductibleRate));
            //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
            fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
         //}
          //�˶���ʧ����
        }else{
           //  if(lossRate < 0.3){        
            //�������Ϊ30%   
           // if(lossRate != 0){
           //     ClaimRate = SumRealPay/SumLoss; 
           //     fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
           // }
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8 ){
            //��ʧ�ʴ���80%ʱ��ȫ��           
         //   ClaimRate = SumRealPay/SumLoss;    
         //   fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
         //   fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ��������� 
            if(((SumLoss-SumRest)== 0) || ((lossRate - DeductibleRate)== 0)){
              alert("��ʧ�ʲ��ܵ��������ʻ��ߺ˶����ܵ��ڲ�ֵ");
              return false;
            }                      
            ClaimRate = (SumRealPay+Deductible)/((SumLoss-SumRest) * (lossRate - DeductibleRate));
            //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
           fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
         //}
        }
        }
  }else{
         //�⳥���=�˶���ʧ �� �⳥����
         //�������Ĥ
  		ClaimRate =SumRealPay/SumLoss;
        fm.all("prpLlossDtoClaimRate")[findex].value = point(round(ClaimRate * 100,2),2);
  }
  
  //�������������ǻ��������,��������ϵ  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  
  //add by qinyongli 2005-9-15
  //reason:ֻ�����ղŽ��п���
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
    //modify by kangzhen  reason ����������ֵı��Ѿ��Ǳ��ʵ���⸶���ܳ�������
    var RiskCode  =fm.prpLcompensateRiskCode.value;
    if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
    {
       alert("�⳥���ܴ��ڱ��ս��");
       fm.all("prpLlossDtoSumLoss")[findex].focus;
       return false;
    }   
  }
  
  //�����������ϼơ����ϼơ��������á�ʵ����
  calFund();
  //���ձ�У���Ƿ񳬹������е��޶�
  //CheckLimitAmountByKindCode(fm.all("prpLlossDtoKindCode")[findex].value,0);
 
 }
 
 
 /**
	����⸶�����Ƿ���ڳб����� 
*/
function checkStatQuantity(field){
	if(isNaN(field.value)){
		alert("�⸶����Ϊ����!");
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
		alert("�⸶�������ܴ��ڳб�����! �б���: "+statQuantity);
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
  //ȡ��ʧ��
  var objectLossRate = fm.all("indemnityDutyRate");
  if(objectLossRate != null){
        lossRate   = parseFloat(objectLossRate[findex].value) / 100;
  }  
  classCode     = fm.prpLcompensateClassCode.value;
  //��ȡ��ʧ�ұ���⳥�ұ�
  currency2     = fm.all("prpLlossDtoCurrency2")[findex].value;
  currency3     = fm.all("prpLlossDtoCurrency3")[findex].value;
  //currency3��currency4��� ��UIPrpLLoss.4gl After Field Currency3.
  
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
  
  //��ȡ��ʧ�ұ���⳥�ұ�
   
  
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
    
   //�����������������ֻ����������һ��
  if(DeductibleRate>0)
  {
      deductibleRateFlag = 1;
      if(Deductible>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductible")[findex].value="0";
           return false;
      }
  } 
  if(Deductible>0)
  {
      deductibleFlag = 1;
      if(DeductibleRate>0)
      {
           alert("�������������ֻ������һ��");
           fm.all("prpLlossDtoDeductibleRate")[findex].value="0";
           return false;
      }
  }
  //��ֲ���߲�ͬ�ļ��㹫ʽ
  if(riskType == "H"){
     // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
      
       //������ʽ��ȫ���⸶
      var calaType = fm.calaType[findex].value;
      //�������ͣ����ս����㣬�˶���ʧ����
      var type = fm.cala[findex].value;
      if(itemCode == '0032'){
      if(calaType == '1'){
              Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)- Deductible;
           // Realpay = Amount * ClaimRate;    
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00; 
      }
      
      else{
      
       //���ձ��ս�����
      if(type=='1'){
        //if(lossRate < 0.3){        
            //�������Ϊ30%   
        //    Realpay = 0.0;
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
        //    Realpay = Amount * ClaimRate;    
        //    fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������         
            Realpay = (Amount-SumRest) * ClaimRate * (lossRate - DeductibleRate)- Deductible;
             //fm.all("prpLlossDtoDeductibleRate")[findex].value = 15.00;
       // }
        //���պ˶���ʧ����
        }else{
           // if(lossRate < 0.3){        
            //�������Ϊ30%   
           // Realpay = 0.0;
           // fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;
        //}
        //else if(lossRate >= 0.8){
            //��ʧ�ʴ���80%ʱ��ȫ��           
           // Realpay = SumLoss * ClaimRate;    
          //  fm.all("prpLlossDtoDeductibleRate")[findex].value = 0.00;       
        //}
        //else{
            //��ʧ����30%~80%ʱ������15%�ľ���������         
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
           //��û����
              Realpay = (SumLoss - SumRest)* exchRate * ClaimRate;
        }
        if(deductibleRateFlag>0)
         {
              //���������ʺ���㹫ʽΪ (���-��ֵ)*�⳥����*(1-������)
               Realpay = (SumLoss - SumRest) * exchRate * ClaimRate *(1-DeductibleRate);
    
         }  
        if(deductibleFlag>0)
         {
              //������������㹫ʽΪ (���-��ֵ)*�⳥����*-�����
              Realpay = (SumLoss - SumRest) * exchRate * ClaimRate - Deductible;
         
         }
  }
  
  //�������������ǻ��������,��������ϵ  
  //Deductible = SumLoss*DeductibleRate;
  fm.all("prpLlossDtoDeductible")[findex].value = point(round(Deductible,2),2);
  fm.all("prpLlossDtoSumRealPay")[findex].value = point(round(Realpay,2),2);
  //add by qinyongli 2005-9-15
  //reason:ֻ�����ղŽ��п���
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
  	//modify by kangzhen  reason ����������ֵı��Ѿ��Ǳ��ʵ���⸶���ܳ�������
  	var RiskCode  =fm.prpLcompensateRiskCode.value;
  	if(RiskCode!='3201'&&RiskCode!='3203'&&RiskCode!='3208')
  	{
       alert("�⳥���ܴ��ڱ��ս��");
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