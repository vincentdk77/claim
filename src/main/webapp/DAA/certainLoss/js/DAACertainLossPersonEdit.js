/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     ��weishixin
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
    * ����setPrpLpersonSerialNo
    */
   function setPrpLpersonSerialNo(){
       var count=getElementCount("prpLpersonSerialNo");
       for(var i=0;i<count;i++)
       {
           if(count!=1){
               fm.prpLpersonSerialNo[i].value=i;
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
  	if(elements[i].name=="personSerialNo")
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
function deleteRowTable(field,pageCode,pageDataRowsCount,controlRowsCount)
{
  recentDeletedRowNo = parseInt(getElementOrder(field));
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  var person_tr = field.parentElement;
  while(person_tr.tagName != 'TR'){
      person_tr = person_tr.parentElement;
  }
  for(var i = 0; i < oTBODY.rows.length; i++){
      if(oTBODY.rows[i] == person_tr){
            for(var j = 0;j < controlRowsCount; j++)
            {
                oTBODY.removeChild(oTBODY.rows[i]);
            }
            break;
      }
  } 
  sumPersonLossFee();
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
  var pageSerialNo = 0 ;
  pageSerialNo = parseInt(fm.personSerialNo(recentRowNo-1).value);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("Person");
    
  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
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
 
 if(!validateForm(fm,'PersonFeeLoss_Data,Person_Data'))
  { 
    return false; 
  }
  
 if(!checkPersonFeeLoss())
  {
    return false;
  }

  //reason:������ĳһ��ťʱ�뽫�����ť��ң������û����ܶఴ��������
  field.disabled = true;
 
  fm.submit(); 
  //return true;   	
}

function checkPersonFeeLoss(){
var personCount = getElementCount("personSerialNo");
var i         = 0;  
var j  =0 ;  
var addNewRepairCompentRow=-1;//Ĭ��û������һ����¼����
var compensatebackFlag=fm.prpLverifyLossCompensateFlag.value; //�����˻صı��
   //modify begin zhanqiang 20040309
  if((personCount <= 1))
  {
    alert("��Ա���������嵥��Ϣ����¼��һ��!");   
    return false;	 
  } 
  
   for(i=1;i<fm.personSerialNo.length;i++)
     {
     if (((fm.prpLpersonFeeTypeCode[i].value).toString().length)<1)
        {
    	    
           errorMessage("���ô��벻��Ϊ��!");
           return false;	 
        }
      if (((fm.prpLpersonFeeTypeName[i].value).toString().length)<1)
        {
    	    
           errorMessage("�������Ʋ���Ϊ��!");
           return false;	 
        }  
        
          if (fm.prpLpersonCompensateBackFlag[i].value!="1") addNewRepairCompentRow=1;
       
  }
  
  //�����������˵ģ�����û���������еĻ�����ô����ֱ���ύ������ 
  if (compensatebackFlag=="1" &&addNewRepairCompentRow<0 ) fm.NextComeBackCompensate.value="1";
  
  
  return true ; 
}

/*function checkPersonFeeLoss()
{
  if(getRowsCount("PersonFeeLoss")==0)
  {
		errorMessage("��Ա���������嵥��Ϣ����Ҫ��һ����¼!");
		return false;
  }
	
} 
function getRowsCount(PageCode)
{
  var oTBODY   = document.all(PageCode).tBodies.item(0);
  var intCount = oTBODY.rows.length;
  return intCount;
}
*/