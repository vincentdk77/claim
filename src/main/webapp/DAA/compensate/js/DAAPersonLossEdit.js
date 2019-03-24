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
 * 插入一条新的lLoss之后的处理（可选方法）
 */
 function afterInsertPersonCommerce()
 {
   setPrpLpersonCommerceSerialNo();
 }

 /*
   删除本条WarnRegion之后的处理（可选方法）
 */
 function afterDeletePersonCommerce(field)
 {

   setPrpLpersonCommerceSerialNo();
 }

   /**
    * 设置setPrpLpersonLossSerialNo
    */
   function setPrpLpersonCommerceSerialNo(){
       var count=getElementCount("prpLpersonCommerceSerialNo");

       for(var i=0;i<count;i++)
       {
           if(count!=1){
               fm.prpLpersonCommerceSerialNo[i].value=i;
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
  	if(elements[i].name=="prpLpersonLossAmount")
  	{
  		elements[i].value = fm.all("prpLpersonLossAmountTmp")[index].value;
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
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentRowNo-1).value);

  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getTableElements("Person");

  for(i=0;i<elements.length;i++)
  {
  	//得到人员费用索引起始位置及人员费用的记录数
  	if(elements[i].name  == "personLossSerialNo")
  	{

  		if(parseInt(elements[i].value)==pageLossSerialNo)
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

/**
 @author      liubvo
 @description 计算赔偿金额（费用代码的时候触发）
 @param       field:触发域
*/
function calculateFee(field)
{
//  var oldAction = fm.action;
//  var oldTarget = fm.target;
//  if(field.value==12||field.value==14||field.value==15||field.value==17||field.value==19||field.value==18||field.value==21||field.value==34){
//    var fieldname=field.name;
//    var findex=0;
//    findex = getElementOrder(field)-1;
//    //fm.action="/claim/DAA/compensate/DAACalculateFee.jsp?findex=" + findex;
//
//    var win ;
//    win=window.showModalDialog("/claim/DAA/compensate/DAACalculateFee.jsp?findex=" + findex,window,'status:no;resizable:yes');
//    //win=window.open("/claim/DAA/compensate/DAACalculateFee.jsp?findex=" + findex,"window","width=640,height=300,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");
//  }
//  fm.action=oldAction;
//  fm.target=oldTarget;
}





 /**
  在表格下方添加一组数据，禁止非本模块调用
  参数为页代码名称和页原始数据代码名称
  例:insertRow("Engage","Engage_Data");
  返回插入行的序号（从1开始）
  */
function insertRowMDTable(pageCode,dataPageCode,field)
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
  	if(elements[i].name=="personMedicalSerialNo")
  	{
  		elements[i].value = index;
//--ljydelete		alert(elements[i].value );
  	}
  	if(elements[i].name=="prpLpersonLossAmount")
  	{
  		elements[i].value = fm.all("prpLpersonLossAmountTmp")[index].value;
  	}

  }
  return true;
}




/**
  删除控制按钮控制的行，禁止非本模块调用
  字段，页名称，数据页中控制按钮的个数，数据页中每个控制按钮的控制的TR的个数
  返回删除行的序号（从1开始）
 */
function deleteRowMDTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personMedicalSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowMDCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //去掉隐含域中的控制按钮的个数
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}




//得到当前的行所在当前页位置
function getRowMDCurrPage(field,DataPageCode)
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
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personMedicalSerialNo(recentRowNo-1).value);
//--ljydelete   alert(pageLossSerialNo);
  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getTableElements("PersonCommerce");

  for(i=0;i<elements.length;i++)
  {
  	//得到人员费用索引起始位置及人员费用的记录数
  	if(elements[i].name  == "personMedicalSerialNo")
  	{

  		if(parseInt(elements[i].value)==pageLossSerialNo)
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
//--ljydelete    alert(orderCurrent);
  return orderCurrent;
}


 /**
  在表格下方添加一组数据，禁止非本模块调用
  参数为页代码名称和页原始数据代码名称
  例:insertRow("Engage","Engage_Data");
  返回插入行的序号（从1开始）
  */
function insertRowDTable(pageCode,dataPageCode,field)
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
  	if(elements[i].name=="personDeformitySerialNo")
  	{
  		elements[i].value = index;
//--ljydelete		alert(elements[i].value );		
  	}
  	if(elements[i].name=="prpLpersonLossAmount")
  	{
  		elements[i].value = fm.all("prpLpersonLossAmountTmp")[index].value;
  	}

  }
  return true;
}




/**
  删除控制按钮控制的行，禁止非本模块调用
  字段，页名称，数据页中控制按钮的个数，数据页中每个控制按钮的控制的TR的个数
  返回删除行的序号（从1开始）
 */
function deleteRowDTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personDeformitySerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //顺序改为以0开始
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowDCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //去掉隐含域中的控制按钮的个数
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}




//得到当前的行所在当前页位置
function getRowDCurrPage(field,DataPageCode)
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
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personDeformitySerialNo(recentRowNo-1).value);
//--ljydelete  alert(pageLossSerialNo);
  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getTableElements("PersonCommerce");

  for(i=0;i<elements.length;i++)
  {
  	//得到人员费用索引起始位置及人员费用的记录数
  	if(elements[i].name  == "personDeformitySerialNo")
  	{

  		if(parseInt(elements[i].value)==pageLossSerialNo)
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
//--ljydelete    alert("当前"+orderCurrent);
  return orderCurrent;
}


function setpersonLossSumDefPay(field){
	
  var serialNo=0; //定位
  var fieldName = field.name;
  for ( var i=1; i<fm.all(fieldName).length;i++ ){
    if (field==fm.all(fieldName)[i]){
       serialNo=i;
       break;
    }
  }
  
  
  var sumLoss =parseFloat(fm.prpLpersonLossSumLoss[serialNo].value);
    
    if(isNaN(sumLoss)){ 
     	 sumLoss = 0;
    }

  
  fm.prpLpersonLossSumDefPay[serialNo].value= point(round(sumLoss,2),1);

}
/**
 *@description added by zhangli 2007-04-20验证被保险人的帐号是否一致
 *@param       无
 *@return      
*/
function validateAccount(){
	     
	     var pwd1=fm.prpLcompensateAccount.value;      
	     var pwd2=fm.prpLcompensateAccountOK.value;  	  
	     if(pwd2!=pwd1){
	              alert("两次输入的支付帐号不一致，请重新输入!");
				  fm.prpLcompensateAccount.value="";
				  fm.prpLcompensateAccountOK.value="";
				  fm.prpLcompensateAccount.focus();
	     }
	}
