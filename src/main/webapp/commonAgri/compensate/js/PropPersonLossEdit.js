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
 * ����setPrpLlossDtoSerialNo
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
      strmsg="�⸶�������ܴ���100����С��0!";
      alert(strmsg);
      field.select();
      field.focus();
      return false;
   }
      return true;
}
 
          
   /**
    * ����setPrpLpersonLossLiabSerialNo
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
  
  //���description���Բ����ڣ�����name����
  if(desc==null)
    desc = field.name;
  
  if(isNaN(strValue)||!isInteger(strValue))
  {
    errorMessage("������Ϸ���" + desc +"\n����Ϊ����");
    field.focus();
    field.select();
    return false;
  }
  return true;
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
  
  	if(elements[i].name=="prpLlossSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
  setPrpLlossDetailSerialNo();
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
  pageLossSerialNo = parseInt(fm.prpLlossSerialNo(recentDeletedRowNo-1).value);
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageLossSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  setPrpLlossDetailSerialNo();
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
  var prpLlossDetailSerialNo = 0;
  pageLossSerialNo = parseInt(fm.prpLlossSerialNo(recentRowNo-1).value); //�ڼ�����������
  prpLlossDetailSerialNo = parseInt(fm.prpLlossDetailSerialNo(recentRowNo-1).value)-1;//���ü�¼��
  
  var countLoss=getElementCount("prpLlossSerialNo");
  
  //�õ���ʼλ��
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
