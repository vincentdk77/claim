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
 function afterInsertperson() 
 
 {
  
    setPrpLpersonSerialNo();
 }

   
 /*
   删除本条WarnRegion之后的处理（可选方法）
 */
 function afterDeleteperson(field)
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
        
function isRightDutyPercent(field)
{
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
 
          
   /**
    * 设置setPrpLpersonLossLiabSerialNo
    */
function setPrpLlossDetailSerialNo()
{
  var count=getElementCount("prpLlossDetailSerialNo");
  for(var i=0;i<count;i++)
  {
    if(count!=1){
        fm.prpLlossDetailSerialNo[i].value=i;
    }
  }
}    
     
function checkInteger(field)
{
  field.value = trim(field.value);
  var strValue=field.value;
  if(strValue=="")
    strValue = "0";
  var desc   = field.description;
  
  //如果description属性不存在，则用name属性
  if(desc==null)
    desc = field.name;
  
  if(isNaN(strValue)||!isInteger(strValue))
  {
    errorMessage("请输入合法的" + desc +"\n类型为数字");
    field.focus();
    field.select();
    return false;
  }
  return true;
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
  
  	if(elements[i].name=="prpLlossSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
  setPrpLlossDetailSerialNo();
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
  pageLossSerialNo = parseInt(fm.prpLlossSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //去掉隐含域中的控制按钮的个数
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLlossDetailSerialNo();
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
  var prpLlossDetailSerialNo = 0;
  pageLossSerialNo = parseInt(fm.prpLlossSerialNo(recentRowNo-1).value); //第几个被保险人
  prpLlossDetailSerialNo = parseInt(fm.prpLlossDetailSerialNo(recentRowNo-1).value)-1;//费用纪录数
  
  var countLoss=getElementCount("prpLlossSerialNo");
  
  //得到起始位置
  for(var m=0;m<countLoss;m++)
  {
    if(fm.prpLlossSerialNo[m].value==pageLossSerialNo)
    {
      firstIndexLoss = m;
      break;
    }
  }
  if(firstIndexLoss!=0){
    firstIndexLoss = firstIndexLoss -1;  
  }
  orderCurrent = prpLlossDetailSerialNo - firstIndexLoss;
  return orderCurrent;
}
