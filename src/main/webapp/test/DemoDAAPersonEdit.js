/*****************************************************************************
 * DESC       ：人员列表增加JS
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-08-01
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


/**
 * 插入一条新的lLoss之后的处理（可选方法）
 */
 function afterInsertpersonloss()
 {
   setPrpLpersonLossSerialNo();
 }

 /*
   删除本条WarnRegion之后的处理（可选方法）
 */
 function afterDeletepersonloss(field)
 {
   
   setPrpLpersonLossSerialNo();
 }

   /**
    * 设置setPrpLpersonlossSerialNo
    */
   function setPrpLpersonLossSerialNo(){
       var count=getElementCount("prpLpersonLossSerialNo");
       for(var i=0;i<count;i++)
       {
           if(count!=1){
               fm.prpLpersonLossSerialNo[i].value=i;
           }
       }
   }
   
/**
 * 设置序号
 */
 function setCurrentRecord(field)
 {
   var i = 0;
   i = getElementOrder(field);
   fm.recordCount.value = i;
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
  	if(elements[i].name=="personSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
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
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //去掉隐含域中的控制按钮的个数
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}

//得到当前的行所在当前页位置
function getRowCurrPage(field,DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //人员费用的记录数
  var firstIndexLoss = 0 ;   //本人员的费用的起始index
  var recentRowNo =  0;
  var orderCurrent = 0  ;    //当前行所在当前面的位置
  recentRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentRowNo-1).value);
  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getTableElements("PersonLoss");
    
  for(i=0;i<elements.length;i++)
  {
  	//得到人员费用索引起始位置及人员费用的记录数
  	if(elements[i].name  == "personSerialNo")
  	{
       
  		if(parseInt(elements[i].value)==pageSerialNo)
  		{
  			countLoss = countLoss + 1;
  			if(firstIndexLoss==0)
  			{
  				firstIndexLoss = getElementOrder(elements[i]);
  			} 
  		}
  	}
  }

  orderCurrent = recentRowNo - firstIndexLoss;
  return orderCurrent;
}
