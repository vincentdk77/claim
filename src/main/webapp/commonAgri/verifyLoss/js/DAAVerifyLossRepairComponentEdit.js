/*****************************************************************************
 * DESC       ������������JS
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-08-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
     
 /**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowTableRepairFee(pageCode,dataPageCode,field)
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
/*
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="carLossRepairFeeLossItemCode")
  	{
  		elements[i].value = index;
  	} 
  }
  */
  return true;
}

/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowTableRepairFee(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.carLossRepairFeeLossItemCode(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  order = getRowCurrPageRepairFee(field,pageCode);
  //alert("order="+order);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1; 
}

//�õ���ǰ�������ڵ�ǰҳλ��
function getRowCurrPageRepairFee(field,DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //��Ա���õļ�¼��
  var firstIndexLoss = 0 ;   //����Ա�ķ��õ���ʼindex
  var recentRowNo =  0;
  var orderCurrent = 0  ;    //��ǰ�����ڵ�ǰ���λ��
  recentRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.carLossRepairFeeLossItemCode(recentRowNo-1).value);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("RepairComponent");
    
  for(i=0;i<elements.length;i++) 
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
  	if(elements[i].name  == "carLossRepairFeeLossItemCode")
  	{
      //alert("pageSerialNo="+pageSerialNo+"|" + elements[i].value);
       
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

  //alert("recentRowNo="+recentRowNo);
  //alert("firstIndexLoss="+firstIndexLoss);
  orderCurrent = recentRowNo - firstIndexLoss;
  return orderCurrent;
}








    
 /**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowTableComponent(pageCode,dataPageCode,field)
{
  var index = 0;  //��ǰtable����
  var elements = null;
  index = getElementOrder(field)-1;
  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  //modify liuyanmei 20060223 start ���𳬳�60��̫��---------------
     var oldelementNumber= elements.length;
   //modify liuyanmei 20060223 end ���𳬳�60��̫��---------------
  for(var i=0;i<oTBODYData.rows.length;i++) 
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true)); 
  }
  
  //modify liuyanmei 20060223 start ���𳬳�60��̫��---------------
  //for(var i=0;i<elements.length;i++)  
   for(var i=oldelementNumber;i<elements.length;i++)
   //modify liuyanmei 20060223 end ���𳬳�60��̫��---------------
  {
  	if(elements[i].name=="carLossComponentLossItemCode")
  	{
  		elements[i].value = index;
  	} 
  } 
  return true;
}

/**
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowTableComponent(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.carLossComponentLossItemCode(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  order = getRowCurrPageComponent(field,pageCode);
  //alert("order="+order);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1; 
}

//�õ���ǰ�������ڵ�ǰҳλ��
function getRowCurrPageComponent(field,DataPageCode)
{
  var i = 0;
  var name = "";
  var elements;
  var fieldName = "";
  var countLoss = 0 ;        //��Ա���õļ�¼��
  var firstIndexLoss = 0 ;   //����Ա�ķ��õ���ʼindex
  var recentRowNo =  0;
  var orderCurrent = 0  ;    //��ǰ�����ڵ�ǰ���λ��
  recentRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.carLossComponentLossItemCode(recentRowNo-1).value);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("RepairComponent");
    
  for(i=0;i<elements.length;i++) 
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
  	if(elements[i].name  == "carLossComponentLossItemCode")
  	{
      //alert("pageSerialNo="+pageSerialNo+"|" + elements[i].value);
       
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

  //alert("recentRowNo="+recentRowNo);
  //alert("firstIndexLoss="+firstIndexLoss);
  orderCurrent = recentRowNo - firstIndexLoss;
  return orderCurrent;
}



/**
 *@description ���ݰ�ť״̬���汨������
 *@param       this
 *@param       ����״̬
 *@return      ͨ������true,���򷵻�false
 */	  
function saveForm(field,saveType)
{
  fm.buttonSaveType.value = saveType;
  
  //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
 
 if(!validateForm(fm,'RepairFee_Data,Component_Data')) 
  {
    return false;
  }

  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
  
  fm.submit();
  //return true;   	
}
