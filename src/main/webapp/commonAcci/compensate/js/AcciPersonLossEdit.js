/*****************************************************************************
 * DESC       ：人员列表增加JS
 * AUTHOR     : liubvo
 * CREATEDATE ： 2004-08-01
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


/**
 * 插入一条新的lLoss之后的处理（可选方法）
 */
 function afterInsertPerson() 
 {
   setPrpLpersonSerialNo();
 }

 /*
   删除本条WarnRegion之后的处理（可选方法）
 */
 function afterDeletePerson(field)
 { 
   setPrpLpersonSerialNo();
 }

   /**
    * 设置setPrpLpersonLossSerialNo
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
    * 设置setPrpLpersonLossLiabSerialNo
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
  在表格下方添加一组数据，禁止非本模块调用
  参数为页代码名称和页原始数据代码名称
  例:insertRow("Engage","Engage_Data");
  返回插入行的序号（从1开始）
  */
function insertRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //当前table索引
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
  删除控制按钮控制的行，禁止非本模块调用
  字段，页名称，数据页中控制按钮的个数，数据页中每个控制按钮的控制的TR的个数
  返回删除行的序号（从1开始）
 */
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //去掉隐含域中的控制按钮的个数
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLpersonLossLiabSerialNo();
  return recentDeletedRowNo-1;
}

//得到当前的行所在当前页位置
function getRowCurrPage(field,DataPageCode)
{
  var countLoss = 0 ;  
  var firstIndexLoss = 0 ;  
  var recentRowNo =  0;
  var orderCurrent = 0  ;   
  recentRowNo = parseInt(getElementOrder(field));
  
  var pageLossSerialNo = 0 ;
  var prpLpersonLossLiabSerialNo = 0;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentRowNo-1).value); //分户序号
  prpLpersonLossLiabSerialNo = parseInt(fm.prpLpersonLossLiabSerialNo(recentRowNo-1).value)-1;//费用纪录数
  
  var countLoss=getElementCount("personLossSerialNo");
  
  //得到起始位置
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
  在表格下方添加一组数据，禁止非本模块调用
  参数为页代码名称和页原始数据代码名称
  例:insertRow("Engage","Engage_Data");
  返回插入行的序号（从1开始）
  */
  /*
function insertRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //当前table索引
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
  删除控制按钮控制的行，禁止非本模块调用
  字段，页名称，数据页中控制按钮的个数，数据页中每个控制按钮的控制的TR的个数
  返回删除行的序号（从1开始）
 */
 /*
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
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

//得到当前的行所在当前页位置
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
  prpLpersonLossLiabSerialNo = parseInt(fm.prpLpersonLossLiabSerialNo(recentRowNo-1).value)-1;//有几个险别
  
  var countLoss=getElementCount("personLossSerialNo");
  
  //得到起始位置
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
  删除控制按钮控制的行，禁止非本模块调用
  字段，页名称，数据页中控制按钮的个数，数据页中每个控制按钮的控制的TR的个数
  返回删除行的序号（从1开始）
 */
function deletePersonRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var prpLpersonLossSerialNo = 0 ;
  var prpLpersonLossPersonNo = 0;
  prpLpersonLossSerialNo = parseInt(fm.prpLpersonLossSerialNo(recentDeletedRowNo-1).value);
  prpLpersonLossPersonNo = parseInt(fm.prpLpersonLossPersonNo(recentDeletedRowNo-1).value);
  
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[prpLpersonLossPersonNo].tBodies.item(0);
  order = getPersonRowCurrPage(field,pageCode);
 
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLpersonSerialNo();
  return recentDeletedRowNo-1;
}


//得到当前的行所在当前页位置
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
  prpLpersonLossPersonNo = parseInt(fm.prpLpersonLossPersonNo(recentRowNo-1).value); //有几个被保险人
  prpLpersonLossSerialNo = parseInt(fm.prpLpersonLossSerialNo(recentRowNo-1).value)-1;//有几个险别
  
  
  var countLoss=getElementCount("prpLpersonLossPersonNo");
 
  //得到起始位置
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
  在表格下方添加一组数据，禁止非本模块调用
  参数为页代码名称和页原始数据代码名称
  例:insertRow("Engage","Engage_Data");
  返回插入行的序号（从1开始）
  */
function insertPersonRowTable(pageCode,dataPageCode,field)
{
  var index = 0;  //当前table索引
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





//计算住院天数
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

//计算赔偿金额
function calRealPay(Field)
{
    //意外险通用公式 赔偿金额 =(申请金额-自费金额-免赔额)*赔偿比例
    
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
     //if(hasDot(realPayFee)){//realPayFee是为小数
       // var ss = realPayFee+"";
      //  if(ss.split(".")[1].length>=3){//小数点后大于等于3位
        //    var dd = ss.substring(0,ss.indexOf(".")+4);
         //   var ff = dd.substring(dd.length-1,dd.length);
            //if(ff>=5){
             // fm.prpLpersonLossSumRealPay[findex].value = point(round(realPayFee,3),2);//修改意健险的给付金额的四舍五入
           // }else{
              //fm.prpLpersonLossSumRealPay[findex].value = point(round(realPayFee,2),2);//修改意健险的给付金额的四舍五入
           // } 
       // }else{//小数点后小于3位
           fm.prpLpersonLossSumRealPay[findex].value = realPayFee.toFixed(2);//计算结果不论多少位小数，都四舍五入保留2位!
       // }
    // }else{//realPayFee不是小数
     //  fm.prpLpersonLossSumRealPay[findex].value = point(round(realPayFee,2),2);
    // }    
}

//js中判断变量是否为小数的方法
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
//加入各险别赔偿金额必须小于保额的判断
function checkAmount(field){
  return;    
}
//****************add by qinyongli 2005-9-7 end 