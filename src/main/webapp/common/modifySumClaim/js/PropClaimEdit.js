/**
 @description ���ܹ�����
 @param       ��
 @return      ��
 */
function collectCurrency1()
{
	var compAmout =0;
	var nowAmout =0;
	var exchCurrency = fm.prpLclaimCurrency.value;  //�õ���ǰ�ұ�����
	var exchRate = 1; //�һ���
	var reinsMoney=0
	var reinsClaimMoney=0;
	//ѭ������ �����
	for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
 	{
 		nowAmout =parseFloat(fm.prpLclaimLossSumClaim[n].value)
 		
 		 for ( j=1;j<fm.baseCurrency.length;j++)
         {
              if(fm.baseCurrency[j].value==fm.prpLclaimLossCurrency[n].value && fm.exchCurrency[j].value==exchCurrency)
              {
                 exchRate = fm.exchRate[j].value;
              }
         }
	    compAmout = compAmout + nowAmout*exchRate;
    }
 
	fm.prpLclaimSumClaim.value=pointTwo(compAmout);
	if(fm.prpLdangerRiskSumClaim!=undefined){
			   	//ѭ������ ����� ֻ��������
			for( var n=1;n<fm.prpLclaimLossSumClaim.length;n++)
		 	{
		 	  if(fm.ClaimLossFlag[n].value=="I"){
		 		reinsClaimMoney =parseFloat(fm.prpLclaimLossSumClaim[n].value);
			 		 for ( j=1;j<fm.baseCurrency.length;j++)
			         {
			              if(fm.baseCurrency[j].value==fm.prpLclaimLossCurrency[n].value && fm.exchCurrency[j].value==exchCurrency)
			              {
			                 exchRate = fm.exchRate[j].value;
			              }
			         }
				    reinsMoney = reinsMoney + reinsClaimMoney*exchRate;
			    }
		    }
      fm.prpLdangerRiskSumClaim.value=pointTwo(round(reinsMoney,2));//�ٱ���Σ�յ�λ�����ֵ
    }
  return true;
}

//�����ձ������Ϣ ,���ݱұ����
//add by qinyongli 2005-8-31 
function collectCurrency(){
         var collectCurr ="";
         var collectTemp = new Array();
         collectCurr = "�ֱұ���ܽ��:\n";
         var map = {};
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //ѭ���ֱұ�ͳ��
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                }
            }
            var policyno = fm.policyno.value;
            var kindcode = fm.prpLclaimLossKindCode[i].value;
            if(map.hasOwnProperty(kindcode)) {
                    map[kindcode] = map[kindcode] + parseFloat(fm.prpLclaimLossSumClaim[i].value);
            } else {
                    map[kindcode] = parseFloat(fm.prpLclaimLossSumClaim[i].value);
            }
  	  	    var strPage = "/claim/common/pub/UICheckItemAmount.jsp?policyno="+policyno+"&kindcode="+kindcode;
			var strXmlText = getResponseXmlText(strPage);
			if(strXmlText!="true"){
			    if(isNaN(strXmlText) && map[kindcode]>0) {
			        alert("�ձ� " + kindcode + " �Ĺ�������ܴ��ڴ��ձ�ı��");
			        return false;
			    }
			    else if(map[kindcode] > parseFloat(strXmlText)) {
				    alert("�ձ� " + kindcode + " �Ĺ�������ܴ��ڴ��ձ�ı��"+parseFloat(strXmlText) +"Ԫ" + currencyName + "��");
				    return false;
				}
			} 
            //alert(sumLossAmount);
            //���жϵ�ǰ�������Ƿ����д˱ұ�,���û���ٽ��б���
            for(var j=0;j<collectTemp.length;j++){             
                if(collectTemp[j]==currency){hasElement=true;}
            }
            //�����ǰ�������д�Ԫ�أ����ٽ���ͳ��

            if(hasElement){continue;}
            //����������
            collectTemp[i-1]= currency;
            collectCurr =collectCurr +  currency+"  "+ currencyName+"  "+ sumLossAmount+".00Ԫ\n";
         }
         if(collectCurr.length>0){
             alert(collectCurr);
             if(parseFloat(fm.prpLclaimSumAmount.value) < sumLossAmount) {
                 alert("���������ֵ�����ܴ��ڴ˱������ܱ������������");
                 return false;
             }
             else if(sumLossAmount>500000) {
                 alert("��ʾ�����������ֵ���� "+currencyName+" ��ʮ��Ԫ��");
             }
             return false;
         }
}
// add by qinyongli end 2005-8-31

function getResponseXmlText(strURL){
	  var objXmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	  objXmlHttp.Open("POST",strURL,false);
	  objXmlHttp.setRequestHeader("Content-type","text/xml");
	  objXmlHttp.Send("");
	  if(objXmlHttp.status==200)
	  {
	    return objXmlHttp.responseText;
	  }
	  else if(objXmlHttp.status==404)
	  {
	    alert("�Ҳ���ҳ�棺"+ strURL);
	    return "";
	  }
	  else
	  {
	    alert("����"+ strURL +"��������ţ�"+objXmlHttp.status);
	    return "";
	  }
	}
	
function sumLossAmountInform() {
         var returnString ="";
         var collectTemp = new Array();
         for(var i=1;i<fm.prpLclaimLossCurrency.length;i++){
            var hasElement = false;
            var currency = fm.prpLclaimLossCurrency[i].value;
            var currencyName = fm.prpLclaimLossCurrencyName[i].value;
            var sumLossAmount = 0;
            //ѭ���ֱұ�ͳ��
            for(var ii=1;ii<fm.prpLclaimLossCurrency.length;ii++){
                if(currency==fm.prpLclaimLossCurrency[ii].value){
                     sumLossAmount = sumLossAmount + parseFloat(fm.prpLclaimLossSumClaim[ii].value);
                }
            }
            //���жϵ�ǰ�������Ƿ����д˱ұ�,���û���ٽ��б���
            for(var j=0;j<collectTemp.length;j++){             
                if(collectTemp[j]==currency){hasElement=true;}
            }
            //�����ǰ�������д�Ԫ�أ����ٽ���ͳ��

            if(hasElement){continue;}
            //����������
            collectTemp[i-1]= currency;
         }
         if(sumLossAmount>500000) {
               returnString = "��ʾ�����������ֵ���� "+currencyName+" ��ʮ��Ԫ��";
         }
         return returnString;
}
