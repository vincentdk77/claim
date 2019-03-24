/*****************************************************************************
 * DESC       ����ʧ��λ�ű�����
 * AUTHOR     ��������Ŀ��
 * CREATEDATE ��2005-04-08
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


//Modify by chenrenda add begin 20050408
//Reason:��ʧ��λģ��ϵ��永������Ϣ�У���Ӧģ��������
//��ʧ��λ�仯��,��ʧ��λ����Ҳ���Ÿı�
function getPartName(field)
{
  var index = parseInt(getElementOrder(field))-1; 
  var list=field;
  fm.partName[index].value = list.options[list.selectedIndex].text; 
  fm.compName[index].value = "";
}


//���´��������ҳ��
function openCompCodeWin(PageCode,Field)
{
   var index = parseInt(getElementOrder(Field))-1;    
   var partCode = fm.partCode(index).value;
   var pageUrl="/claim/DAA/regist/DAARegistGetCompCode.jsp?strIndex="+index+"&partCode="+partCode;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
   window.open(pageUrl,"openCompCodeWin","resizable=0,scrollbars,dependent,alwaysRaised,width=230,height=450");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
}  

//ȡ���������������
function getCompCode(field)
{
  var compCodeName = field;
  var index = compCodeName.indexOf("-");
  var compCode = compCodeName.substring(0,index);
  var compName = compCodeName.substring(index+1);
  
  var index1=fm.txtIndex.value; 
  var PreviousFlag=fm.txtPreviousFlag.value; 
  
  //������Ŀ�嵥ģ��
  if(PreviousFlag=="repairFee")
  {
    window.opener.fm.prpLrepairFeeCompName[index1].value= compName;
    window.opener.fm.prpLrepairFeeCompCode[index1].value= compCode;
    window.close();  
  }
  else if(PreviousFlag=="component")
  {
    window.opener.fm.prpLcomponentCompName[index1].value= compName;
    window.opener.fm.prpLcomponentCompCode[index1].value= compCode;
    window.close();  
  }
  else
  {
    window.opener.fm.compName[index1].value= compName;
    window.opener.fm.compCode[index1].value= compCode;
    window.close();      
  }
}

//ȡ��������ʧ����
function getLossItemCode(field)
{
  var LossItemCodeName = field;
  var index = LossItemCodeName.indexOf("-");
  var lossItemCode = LossItemCodeName.substring(0,index);
  var LossItemName = LossItemCodeName.substring(index+1);
  
  var index1=fm.txtIndex.value; 
  window.opener.fm.prpLthirdLossItemCode[index1].value= lossItemCode;
  window.opener.fm.prpLthirdLossItemName[index1].value= LossItemName;
  window.close();
}


/**
 * ����setPrpLthirdCarLossItemNo
 */
function setPrpLthirdCarLossItemNo(){
  var count=getElementCount("prpLthirdCarLossItemNo");
  for(var i=0;i<count;i++)
  {
    if(count!=1){
      fm.prpLthirdCarLossItemNo[i].value=i;
    }
  }
}


/**
 * ���ƺ���仯ʱ���������¼�
 */
function getCarLossLicenseNo(field){
  var index = 0;  //��ǰtable����
  index = getElementOrder(field)-1;
  
  //�����ƺ��븳ֵ
  var count=getElementCount("prpLthirdCarLossLicenseNo");
  for(var j=1;j<count;j++)
  {
    if(fm.RelateSerialNo[j].value==index)
    {
      fm.prpLthirdCarLossLicenseNo[j].value = fm.prpLthirdPartyLicenseNo[index].value; 
      fm.prpLthirdCarLossLicenseNo[j].readOnly = true;   
    }
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
  
  if(fm.prpLthirdPartyLicenseNo[index].value==null||(fm.prpLthirdPartyLicenseNo[index].value).length==0)
  {
    errorMessage("���ƺ��벻��Ϊ��!");
    return false;
  }
  if(fm.prpLthirdPartyDutyPercent[index].value==null||(fm.prpLthirdPartyDutyPercent[index].value).length==0)
  {
    errorMessage("�Ա��永�����α�������Ϊ��!");
    return false;
  }
  
  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  
  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }
  
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="RelateSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
  //����ʧ��Ŀ��Ÿ�ֵ,�������ƺ��븳ֵ
  var count=getElementCount("prpLthirdCarLossItemNo");
  var k =0;
  for(var j=1;j<count;j++)
  {
    if(fm.RelateSerialNo[j].value==index)
    {
      k++;
      fm.prpLthirdCarLossItemNo[j].value = k;
      fm.prpLthirdCarLossLicenseNo[j].value = fm.prpLthirdPartyLicenseNo[index].value; 
      fm.prpLthirdCarLossLicenseNo[j].readOnly = true;   
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
  
  var RelateSerialNo = 0 ;
  RelateSerialNo = parseInt(fm.RelateSerialNo(recentDeletedRowNo-1).value);
  
  var order = recentDeletedRowNo - 1;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[RelateSerialNo].tBodies.item(0);
  order = getRowCurrPage(field,pageCode);
  //order = order - pageDataRowsCount;  //ȥ���������еĿ��ư�ť�ĸ���
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  
  
  //����ʧ��Ŀ��Ÿ�ֵ
  var count=getElementCount("prpLthirdCarLossItemNo");
  var k =0;
  for(var j=1;j<count;j++)
  {
    if(fm.RelateSerialNo[j].value==RelateSerialNo)
    {
      k++;
      fm.prpLthirdCarLossItemNo[j].value = k;
    }
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
  var RelateSerialNo = 0 ;
  RelateSerialNo = parseInt(fm.RelateSerialNo(recentRowNo-1).value);
  //index--; //˳���Ϊ��0��ʼ
  //�õ�Input�������
  elements = getTableElements("ThirdParty");
    
  for(i=0;i<elements.length;i++)
  {
  	//�õ���Ա����������ʼλ�ü���Ա���õļ�¼��
  	if(elements[i].name  == "RelateSerialNo")
  	{
       
  		if(parseInt(elements[i].value)==RelateSerialNo)
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
//Modify by chenrenda add begin 20050408



/**
  �ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
  ����Ϊҳ�������ƺ�ҳԭʼ���ݴ�������
  ��:insertRow("Engage","Engage_Data");
  ���ز����е���ţ���1��ʼ��
  */
function insertRowOfThirdProp(pageCode,dataPageCode,field)
{
  
  var index = 0;  //��ǰtable����
  var elements = null;
  var oTBODY     = document.getElementById(pageCode).tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  for(var i=0;i<oTBODYData.rows.length;i++)
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true));
  }
  
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="RelateSerialNo")
  	{
  		elements[i].value = index;
  	}
  }
  //����ʧ��Ŀ��Ÿ�ֵ,�������ƺ��븳ֵ
  var count=getElementCount("prpLthirdPropItemNo");
  var k =0;
  for(var j=1;j<count;j++)
  {
      
      fm.prpLthirdPropItemNo[j].value = j;

     /*
     if(j>1)
      {
         fm.prpLthirdPropKindCode[j].value = fm.prpLthirdPropKindCode[j-1].value; 
      }
     */
  }
  return true;
}