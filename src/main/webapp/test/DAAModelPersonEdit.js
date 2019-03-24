/*****************************************************************************
 * DESC       ：人员列表增加JS
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-08-01
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


     //在下面加入本页自定义的JavaScript方法

        /*
        插入一条新的lLoss之后的处理（可选方法）
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
 *@description 装入父界面的数据
 *@param       无
 *@return      通过返回true,否则返回false
 */
function loadForm()
{
	var pageCode = "" ;
	var pageCodeData = "" ;
	var recordCount = 0 ;  //记录序号
	//得到主界面的记录序号
	recordCount = dialogArguments.fm.recordCount.value ;
    fm.recordCount.value = dialogArguments.fm.recordCount.value ;
    
    //得到界面的代码
    pageCode = dialogArguments.fm.pageCode.value
    fm.pageCode.value = dialogArguments.fm.pageCode.value ;
    pageCodeData = pageCode + "_Data";
    getMainFieldValue(pageCode,recordCount);
    return true;
}
/**
 *@description 取得主窗体界面上输入域的值
 *@param       无
 *@return      通过返回true,否则返回false
 */
function getMainFieldValue(DataPageCode,index)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //人员费用的记录数
  var firstIndexLoss = 0 ;   //本人员的费用的起始index
  
  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getMainTableElements(DataPageCode);
  index = index -1;
  
  for(i=0;i<elements.length;i++)
  {
  	//得到人员费用索引起始位置及人员费用的记录数
  	if(elements[i].name  == "personSerialNo")
  	{
  		if(elements[i].value==index)
  		{

  			countLoss = countLoss + 1;
  			if(firstIndexLoss==0)
  			{
  				firstIndexLoss = getMainElementOrder(elements[i]);
  			} 
  		}
  	}
  	command = "document.getElementsByName('" + elements[i].name + "')[0].value = dialogArguments.document.getElementsByName('" + elements[i].name + "')["+index+"].value;";
  	eval(command);
  }
  //设置第一个索引，以后删除增中时用
  fm.firstIndex.value = firstIndexLoss;
  fm.countLoss.value   = countLoss;
  getPersonLoss(countLoss,firstIndexLoss);
}

/**
 *@description 设置主窗体界面上输入域的值
 *@param       无
 *@return      通过返回true,否则返回false
 */
function setMainFieldValue(dataPageCode,index)
{
  var i = 0;
  var name = "";
  var elements;

  //index--; //顺序改为以0开始
  //得到Input域的名字
  elements = getMainTableElements(dataPageCode);
  var textContext = "" ;
  //index = index ;
  for(i=0;i<elements.length;i++)
  {
  	command = "dialogArguments.document.getElementsByName('" + elements[i].name + "')["+index+"].value = document.getElementsByName('" + elements[i].name + "')[0].value ;";
  	
  	eval(command);
  	textContext = textContext + "|" + elements[i].name;
  }
  //alert(textContext);
  //设置多行值
  var pageCount = index ;  //设置页数
  var rowCount  =  0    ;  //行数
  rowCount = parseInt(fm.countLoss.value);
  setPersonLoss("PersonFeeLoss",pageCount,rowCount);
  
}
/**
 * 得到Table的所有元素
 * @param tableId 表名称
 * @return table的所有元素
 */
function getMainTableElements(tableId)
{
  var i = 0;
  var elements=new Array();
  var tempElements = null;
  var tbody;
  var index=0;
  var tbodies = dialogArguments.document.getElementById(tableId).tBodies;
  for(i=0;i<tbodies.length;i++)
  {
    tbody=tbodies.item(i);
    tempElements=tbody.getElementsByTagName("INPUT");    //加入INPUT域

    for(i=0;i<tempElements.length;i++)
    {
      if(tempElements[i].type =="button")
      {
         //去掉button alert("button");
      }
      else
      {
       elements[index++]=tempElements[i];
      }
    }

    tempElements=tbody.getElementsByTagName("SELECT");   //加入SELECT域
    for(i=0;i<tempElements.length;i++)
    {
      elements[index++]=tempElements[i];
    }

    tempElements=tbody.getElementsByTagName("TEXTAREA"); //加入TEXTAREA域
    for(i=0;i<tempElements.length;i++)
    {
      elements[index++]=tempElements[i];
    }

  }
  return elements;
}

/**
 * 得到主界面上的人员损失明细
 * @param  count 已有人员损失明细个数
 * @param  firstIndex 本部分第一个的索引数
 * @return null
 */
  function getPersonLoss(count,firstIndex)
  {
  	  var index = 0;  
  	  var indexReal = 0 ;  
  	  var command ;
  	  firstIndex = firstIndex -1;
      for(index=1;index<=count;index++)
      {
        insertRow("PersonFeeLoss","PersonFeeLoss_Data");
        command = "document.getElementsByName('prpLpersonLossFeeTypeCode')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossFeeTypeCode')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('prpLpersonLossFeeTypeName')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossFeeTypeName')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('prpLpersonLossUnitPrice')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossUnitPrice')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('prpLpersonLossQuantity')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossQuantity')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('prpLpersonLossSumLoss')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossSumLoss')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('prpLpersonLossClaimRate')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossClaimRate')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('prpLpersonLossRealpay')[" + index + "].value = dialogArguments.document.getElementsByName('prpLpersonLossRealpay')["+firstIndex+"].value;";
        eval(command);
        command = "document.getElementsByName('personSerialNo')[" + index + "].value = dialogArguments.document.getElementsByName('personSerialNo')["+firstIndex+"].value;";
        eval(command);
        
        firstIndex++;
        
      }//end for

  }
  
/**
 * 设置界面上的人员损失明细
 * @param  count 已有人员损失明细个数
 * @param  firstIndex 本部分第一个的索引数
 * @return null
 */
  function setPersonLoss(pageCode,pageCount,rowCount)
  {
  	  
  	  var index = 0;  
  	  var indexReal = 0 ;  
  	  var command ;
      //pageCount = pageCount - 1;
	  var oTBODY   = dialogArguments.document.getElementsByName(pageCode)[pageCount].tBodies.item(0);
	  //alert("rowCount="+rowCount);
	  if(rowCount!=0)
	  {
		  rowCount = rowCount - 1 ;//删除行从rowcount-1开始到0
	      for(index=rowCount;index>=0;index--)
	      {
			  for(var i=0;i<1;i++)
			  {
			    oTBODY.removeChild(oTBODY.rows[index*1]);
			  }
		  }
	  }
	  firstIndex = fm.firstIndex.value;
	  if(firstIndex!=0)
	  {
  	  firstIndex = firstIndex -1;
  	  }
  	  else
  	  {
  	     firstIndex = dialogArguments.document.getElementsByName("personSerialNo").length;
  	  }
  	  var addField = dialogArguments.document.getElementsByName('+')[pageCount];//得到增加按钮
  	  var dataPageCode = pageCode + "_Data";
	  var oTBODYData = dialogArguments.document.getElementById(dataPageCode).tBodies.item(0);
	  var addRowCount = getElementCount("personSerialNo");
	  addRowCount = addRowCount-1;
	  //alert("addRowCount="+addRowCount);
      for(index=1;index<= addRowCount;index++)
      {
          //增加行
		  for(var i=0;i<oTBODYData.rows.length;i++)
		  {
		    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
		  }
        command = "dialogArguments.document.getElementsByName('prpLpersonLossFeeTypeCode')["+firstIndex+"].value = document.getElementsByName('prpLpersonLossFeeTypeCode')[" + index + "].value;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('prpLpersonLossFeeTypeName')["+firstIndex+"].value = document.getElementsByName('prpLpersonLossFeeTypeName')[" + index + "].value;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('prpLpersonLossUnitPrice')["+firstIndex+"].value = document.getElementsByName('prpLpersonLossUnitPrice')[" + index + "].value;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('prpLpersonLossQuantity')["+firstIndex+"].value= document.getElementsByName('prpLpersonLossQuantity')[" + index + "].value;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('prpLpersonLossSumLoss')["+firstIndex+"].value=document.getElementsByName('prpLpersonLossSumLoss')[" + index + "].value ;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('prpLpersonLossClaimRate')["+firstIndex+"].value = document.getElementsByName('prpLpersonLossClaimRate')[" + index + "].value;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('prpLpersonLossRealpay')["+firstIndex+"].value = document.getElementsByName('prpLpersonLossRealpay')[" + index + "].value;";
        eval(command);
        command = "dialogArguments.document.getElementsByName('personSerialNo')["+firstIndex+"].value=document.getElementsByName('personSerialNo')[" + index + "].value;";
        eval(command);
        firstIndex++;
      }//end for
      
  }  

/**
 * 插入一条新的lLoss之后的处理（可选方法）
 */
 function afterInsertPersonFeeLoss()
 {
   setPersonFeeLossSerialNo();
 }

/**
 * 设置setPersonFeeLossSerialNo
 */
function setPersonFeeLossSerialNo()
{
    var countPage = 0 ; //页数
    var count=getElementCount("personSerialNo");
    countPage = fm.prpLpersonLossSerialNo.value;
    for(var i=0;i<count;i++)
    {
      fm.personSerialNo[i].value=countPage ;
    }
}

/**
 * 确认输入，将输入域回写到主画面中的对应项
 */
function confirmInput()
{
    var index = 0 ;
    var DataPageCode = "" ;
    DataPageCode = fm.pageCode.value + "_Data";
    index = parseInt(fm.prpLpersonLossSerialNo.value);
	setMainFieldValue(DataPageCode,index);
	
}

/**
 * 得到传入element在Document中的name相同的elements中的顺序(从1开始)
 * @param field element
 * @return 传入element在Document中的name相同的elements中的顺序(从1开始)
 */
function getMainElementOrder(field)
{
    var i = 0;
    var order = 0;
    var elements = dialogArguments.document.getElementsByName(field.name);
    for(i=0;i<elements.length;i++)
    {
        order++;
        if(elements[i]==field)
        {
            break;
        }
    }

    return order;
}


