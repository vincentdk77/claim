/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


     //��������뱾ҳ�Զ����JavaScript����

        /*
        ����һ���µ�lLoss֮��Ĵ�����ѡ������
      */
      function afterInsertpersonloss()
      {
        setPrpLpersonLossSerialNo();
      }
    
      /*
        ɾ������WarnRegion֮��Ĵ�����ѡ������
      */
      function afterDeletepersonloss(field)
      {
        
        setPrpLpersonLossSerialNo();
      }
    
        /**
         * ����setPrpLpersonlossSerialNo
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
 *@description װ�븸���������
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function loadForm()
{
	var pageCode = "" ;
	var pageCodeData = "" ;
	var recordCount = 0 ;  //��¼���
	//�õ�������ļ�¼���
	recordCount = dialogArguments.fm.recordCount.value ;
    fm.recordCount.value = dialogArguments.fm.recordCount.value ;
    
    //�õ�����Ĵ���
    pageCode = dialogArguments.fm.pageCode.value
    fm.pageCode.value = dialogArguments.fm.pageCode.value ;
    pageCodeData = pageCode + "_Data";
    getMainFieldValue(pageCode,recordCount);
    return true;
}
/**
 *@description ȡ��������������������ֵ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function getMainFieldValue(DataPageCode,index)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //��Ա���õļ�¼��
  var firstIndexLoss = 0 ;   //����Ա�ķ��õ���ʼindex
  
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getMainTableElements(DataPageCode);
  index = index -1;
  
  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
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
  //���õ�һ���������Ժ�ɾ������ʱ��
  fm.firstIndex.value = firstIndexLoss;
  fm.countLoss.value   = countLoss;
  getPersonLoss(countLoss,firstIndexLoss);
}

/**
 *@description ����������������������ֵ
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
function setMainFieldValue(dataPageCode,index)
{
  var i = 0;
  var name = "";
  var elements;

  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
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
  //���ö���ֵ
  var pageCount = index ;  //����ҳ��
  var rowCount  =  0    ;  //����
  rowCount = parseInt(fm.countLoss.value);
  setPersonLoss("PersonFeeLoss",pageCount,rowCount);
  
}
/**
 * �õ�Table������Ԫ��
 * @param tableId ������
 * @return table������Ԫ��
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
    tempElements=tbody.getElementsByTagName("INPUT");    //����INPUT��

    for(i=0;i<tempElements.length;i++)
    {
      if(tempElements[i].type =="button")
      {
         //ȥ��button alert("button");
      }
      else
      {
       elements[index++]=tempElements[i];
      }
    }

    tempElements=tbody.getElementsByTagName("SELECT");   //����SELECT��
    for(i=0;i<tempElements.length;i++)
    {
      elements[index++]=tempElements[i];
    }

    tempElements=tbody.getElementsByTagName("TEXTAREA"); //����TEXTAREA��
    for(i=0;i<tempElements.length;i++)
    {
      elements[index++]=tempElements[i];
    }

  }
  return elements;
}

/**
 * �õ��������ϵ���Ա��ʧ��ϸ
 * @param  count ������Ա��ʧ��ϸ����
 * @param  firstIndex �����ֵ�һ����������
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
 * ���ý����ϵ���Ա��ʧ��ϸ
 * @param  count ������Ա��ʧ��ϸ����
 * @param  firstIndex �����ֵ�һ����������
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
		  rowCount = rowCount - 1 ;//ɾ���д�rowcount-1��ʼ��0
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
  	  var addField = dialogArguments.document.getElementsByName('+')[pageCount];//�õ����Ӱ�ť
  	  var dataPageCode = pageCode + "_Data";
	  var oTBODYData = dialogArguments.document.getElementById(dataPageCode).tBodies.item(0);
	  var addRowCount = getElementCount("personSerialNo");
	  addRowCount = addRowCount-1;
	  //alert("addRowCount="+addRowCount);
      for(index=1;index<= addRowCount;index++)
      {
          //������
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
 * ����һ���µ�lLoss֮��Ĵ�����ѡ������
 */
 function afterInsertPersonFeeLoss()
 {
   setPersonFeeLossSerialNo();
 }

/**
 * ����setPersonFeeLossSerialNo
 */
function setPersonFeeLossSerialNo()
{
    var countPage = 0 ; //ҳ��
    var count=getElementCount("personSerialNo");
    countPage = fm.prpLpersonLossSerialNo.value;
    for(var i=0;i<count;i++)
    {
      fm.personSerialNo[i].value=countPage ;
    }
}

/**
 * ȷ�����룬���������д���������еĶ�Ӧ��
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
 * �õ�����element��Document�е�name��ͬ��elements�е�˳��(��1��ʼ)
 * @param field element
 * @return ����element��Document�е�name��ͬ��elements�е�˳��(��1��ʼ)
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


