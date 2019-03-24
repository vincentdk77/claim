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
 function afterInsertperson()
 {
   setPrpLpersonSerialNo();
 }

 /*
   ɾ������WarnRegion֮��Ĵ�����ѡ������
 */
 function afterDeleteperson(field)
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
 * ����һ���µ�lLoss֮��Ĵ�����ѡ������
 */
 function afterInsertPersonCommerce()
 {
   setPrpLpersonCommerceSerialNo();
 }

 /*
   ɾ������WarnRegion֮��Ĵ�����ѡ������
 */
 function afterDeletePersonCommerce(field)
 {

   setPrpLpersonCommerceSerialNo();
 }

   /**
    * ����setPrpLpersonLossSerialNo
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
  	if(elements[i].name=="prpLpersonLossAmount")
  	{
  		elements[i].value = fm.all("prpLpersonLossAmountTmp")[index].value;
  	}

  }
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
  return recentDeletedRowNo-1;
}

//�õ���ǰ�������ڵ�ǰҳλ��
function getRowCurrPage(field,DataPageCode)
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
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personLossSerialNo(recentRowNo-1).value);

  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("Person");

  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
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
 @description �����⳥�����ô����ʱ�򴥷���
 @param       field:������
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
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowMDTable(pageCode,dataPageCode,field)
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
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowMDTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personMedicalSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowMDCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}




//�õ���ǰ�������ڵ�ǰҳλ��
function getRowMDCurrPage(field,DataPageCode)
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
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personMedicalSerialNo(recentRowNo-1).value);
//--ljydelete   alert(pageLossSerialNo);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("PersonCommerce");

  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
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
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowDTable(pageCode,dataPageCode,field)
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
  ɾ�����ư�ť���Ƶ��У���ֹ�Ǳ�ģ�����
  �ֶΣ�ҳ���ƣ�����ҳ�п��ư�ť�ĸ���������ҳ��ÿ�����ư�ť�Ŀ��Ƶ�TR�ĸ���
  ����ɾ���е���ţ���1��ʼ��
 */
function deleteRowDTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personDeformitySerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowDCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  return recentDeletedRowNo-1;
}




//�õ���ǰ�������ڵ�ǰҳλ��
function getRowDCurrPage(field,DataPageCode)
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
  var pageLossSerialNo = 0 ;
  pageLossSerialNo = parseInt(fm.personDeformitySerialNo(recentRowNo-1).value);
//--ljydelete  alert(pageLossSerialNo);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("PersonCommerce");

  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
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
//--ljydelete    alert("��ǰ"+orderCurrent);
  return orderCurrent;
}


function setpersonLossSumDefPay(field){
	
  var serialNo=0; //��λ
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
 *@description added by zhangli 2007-04-20��֤�������˵��ʺ��Ƿ�һ��
 *@param       ��
 *@return      
*/
function validateAccount(){
	     
	     var pwd1=fm.prpLcompensateAccount.value;      
	     var pwd2=fm.prpLcompensateAccountOK.value;  	  
	     if(pwd2!=pwd1){
	              alert("���������֧���ʺŲ�һ�£�����������!");
				  fm.prpLcompensateAccount.value="";
				  fm.prpLcompensateAccountOK.value="";
				  fm.prpLcompensateAccount.focus();
	     }
	}
