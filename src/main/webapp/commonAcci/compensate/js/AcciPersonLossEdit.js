/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     : liubvo
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


/**
 * ����һ���µ�lLoss֮��Ĵ�����ѡ������
 */
 function afterInsertPerson() 
 {
   setPrpLpersonSerialNo();
 }

 /*
   ɾ������WarnRegion֮��Ĵ�����ѡ������
 */
 function afterDeletePerson(field)
 { 
   setPrpLpersonSerialNo();
 }

   /**
    * ����setPrpLpersonLossSerialNo
    */
   function setPrpLpersonSerialNo(){
       var count=getElementCount("prpLpersonLossSerialNo");
       for(var i=0;i<count;i++)
       {
           if(count!=1){
               fm.prpLpersonLossSerialNo[i].value=i;
           }
       }
   }
   
     
   /**
    * ����setPrpLpersonLossLiabSerialNo
    */
   function setPrpLpersonLossLiabSerialNo(){
       var count=getElementCount("prpLpersonLossLiabSerialNo");
       for(var i=0;i<count;i++)
       {
         if(count!=1){
           fm.prpLpersonLossLiabSerialNo[i].value=i;
         }
       }
   }    
          
 
/**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //��ǰtable����
  var elements = null;
  index = getElementOrder(field)-1;
  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  
  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="personLossSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
  setPrpLpersonLossLiabSerialNo();
  return true;
}



/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLpersonLossLiabSerialNo();
  return recentDeletedRowNo-1;
}

//�õ���ǰ�������ڵ�ǰҳλ��
function getRowCurrPage(field,DataPageCode)
{
  var countLoss = 0 ;  
  var firstIndexLoss = 0 ;  
  var recentRowNo =  0;
  var orderCurrent = 0  ;   
  recentRowNo = parseInt(getElementOrder(field));
  
  var pageLossSerialNo = 0 ;
  var prpLpersonLossLiabSerialNo = 0;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentRowNo-1).value); //�ֻ����
  prpLpersonLossLiabSerialNo = parseInt(fm.prpLpersonLossLiabSerialNo(recentRowNo-1).value)-1;//���ü�¼��
  
  var countLoss=getElementCount("personLossSerialNo");
  
  //�õ���ʼλ��
  for(var m=0;m<countLoss;m++)
  {
    if(fm.personLossSerialNo[m].value==pageLossSerialNo)
    {
      firstIndexLoss = m;
      break;
    }
  }
  if(firstIndexLoss!=0){
    firstIndexLoss = firstIndexLoss -1;  
  }
  orderCurrent = prpLpersonLossLiabSerialNo - firstIndexLoss;
  return orderCurrent;
}


/**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
  /*
function insertRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //��ǰtable����
  var elements = null;
  index = getElementOrder(field)-1;
  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  
  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="personLossSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
  setPrpLpersonLossLiabSerialNo();
  return true;
}
*/


/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
 /*
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLpersonLossLiabSerialNo();
  return recentDeletedRowNo-1;
}
*

//�õ���ǰ�������ڵ�ǰҳλ��
/*
function getRowCurrPage(field,DataPageCode)
{
  var i = 0;
  var countLoss = 0 ;       
  var firstIndexLoss = 0 ;  
  var recentRowNo =  0;
  var orderCurrent = 0  ;   
  recentRowNo = parseInt(getElementOrder(field));
  
  var pageLossSerialNo = 0 ;
  var prpLpersonLossLiabSerialNo = 0;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentRowNo-1).value);
  prpLpersonLossLiabSerialNo = parseInt(fm.prpLpersonLossLiabSerialNo(recentRowNo-1).value)-1;//�м����ձ�
  
  var countLoss=getElementCount("personLossSerialNo");
  
  //�õ���ʼλ��
  for(var m=0;m<countLoss;m++)
  {
    if(fm.personLossSerialNo[m].value==pageLossSerialNo)
    {
      firstIndexLoss = m;
      break;
    }
  }
  if(firstIndexLoss!=0){
    firstIndexLoss = firstIndexLoss -1;  
  }
  orderCurrent = prpLpersonLossLiabSerialNo - firstIndexLoss;
  return orderCurrent;
}

*/
/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deletePersonRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var prpLpersonLossSerialNo = 0 ;
  var prpLpersonLossPersonNo = 0;
  prpLpersonLossSerialNo = parseInt(fm.prpLpersonLossSerialNo(recentDeletedRowNo-1).value);
  prpLpersonLossPersonNo = parseInt(fm.prpLpersonLossPersonNo(recentDeletedRowNo-1).value);
  
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[prpLpersonLossPersonNo].tBodies.item(0);
  order = getPersonRowCurrPage(field,pageCode);
 
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLpersonSerialNo();
  return recentDeletedRowNo-1;
}


//�õ���ǰ�������ڵ�ǰҳλ��
function getPersonRowCurrPage(field,DataPageCode)
{
  var i = 0;
 
  var intIndex = 0;
  var firstIndexLoss = 0 ;  
  var recentRowNo =  0;
  var orderCurrent = 0  ;   
  recentRowNo = parseInt(getElementOrder(field));
  var prpLpersonLossPersonNo = 0 ;
  var prpLpersonLossSerialNo = 0;
  prpLpersonLossPersonNo = parseInt(fm.prpLpersonLossPersonNo(recentRowNo-1).value); //�м�����������
  prpLpersonLossSerialNo = parseInt(fm.prpLpersonLossSerialNo(recentRowNo-1).value)-1;//�м����ձ�
  
  
  var countLoss=getElementCount("prpLpersonLossPersonNo");
 
  //�õ���ʼλ��
  for(var m=0;m<countLoss;m++)
  {
    if(fm.prpLpersonLossPersonNo[m].value==prpLpersonLossPersonNo)
    {
      
      firstIndexLoss = m;
      break;
    }
  }
  if(firstIndexLoss!=0){
    firstIndexLoss = firstIndexLoss -1;  
  }

  orderCurrent = prpLpersonLossSerialNo - firstIndexLoss;
  return orderCurrent;
}



 /**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertPersonRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //��ǰtable����
  var elements = null;
  index = getElementOrder(field)-1;
  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }
  setPrpLpersonSerialNo();
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="prpLpersonLossPersonNo")
  	{
  		elements[i].value = index;
  	}
  }
 
  return true;
}





//����סԺ����
function calHospDays(Field)
{
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
     var strInHospDate = fm.prpLpersonLossInHospDate[findex].value;
     var strOutHospDate = fm.prpLpersonLossOutHospDate[findex].value;
     if(strInHospDate==""||strOutHospDate=="")
     {
         return;
     }
     var startDate = new Date(replace(strInHospDate,"-","/"));
     var endDate   = new Date(replace(strOutHospDate,"-","/"));
     var dayCount = dateDiff(startDate,endDate,"D");
     fm.prpLpersonLossHospitalDays[findex].value=dayCount;
 
}

//�����⳥���
function calRealPay(Field)
{
    //������ͨ�ù�ʽ �⳥��� =(������-�Էѽ��-�����)*�⳥����
    
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
     var sumLoss = fm.prpLpersonLossSumLoss[findex].value;
     var sumRest = fm.prpLpersonLossSumRest[findex].value;
     var claimRate = fm.prpLpersonLossClaimRate[findex].value;
     var deductible = fm.prpLpersonLossDeductible[findex].value;
     if(sumLoss==""||claimRate=="")
     {
        return;
     }
     if(isNaN(sumLoss)) 
        sumLoss = 0; 
     if(isNaN(sumRest)) 
        sumRest = 0;    
     if(isNaN(claimRate)) 
        claimRate = 0;     
     if(isNaN(deductible)) 
        deductible = 0;
     var realPayFee = (sumLoss - sumRest  - deductible) * claimRate/100;
     //if(hasDot(realPayFee)){//realPayFee��ΪС��
       // var ss = realPayFee+"";
      //  if(ss.split(".")[1].length>=3){//С�������ڵ���3λ
        //    var dd = ss.substring(0,ss.indexOf(".")+4);
         //   var ff = dd.substring(dd.length-1,dd.length);
            //if(ff>=5){
             // fm.prpLpersonLossSumRealPay[findex].value = point(round(realPayFee,3),2);//�޸��⽡�յĸ���������������
           // }else{
              //fm.prpLpersonLossSumRealPay[findex].value = point(round(realPayFee,2),2);//�޸��⽡�յĸ���������������
           // } 
       // }else{//С�����С��3λ
           fm.prpLpersonLossSumRealPay[findex].value = realPayFee.toFixed(2);//���������۶���λС�������������뱣��2λ!
       // }
    // }else{//realPayFee����С��
     //  fm.prpLpersonLossSumRealPay[findex].value = point(round(realPayFee,2),2);
    // }    
}

//js���жϱ����Ƿ�ΪС���ķ���
function hasDot(num){
  if(!isNaN(num)){
     return((num+'').indexOf('.')!=-1)? true:false;
  }
}

function dispHisInfo(Field)
{
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
     var strValue = fm.prpLpersonLossKindCode[findex].value;
     for(var j =0;j<fm.all("hisKind").length;j++)
     {
        if(fm.all("hisKind")[j].value==strValue)
        {
            fm.prpLpersonLossHisPaid[findex].value=fm.all("hisPaid")[j].value;
            fm.prpLpersonLossMaxPaid[findex].value=fm.all("currAmount")[j].value;
            break;
        }
     }
}
//****************add by qinyongli 2005-9-7 start 
//������ձ��⳥������С�ڱ�����ж�
function checkAmount(field){
  return;    
}
//****************add by qinyongli 2005-9-7 end 