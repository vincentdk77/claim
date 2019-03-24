 /*****************************************************************************
 * DESC       �����ӹ�����ģ��·��JS
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/
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
	setNodeOption();
	//�õ�������ļ�¼���
	recordCount = dialogArguments.fm.WorkFlowPathRecordOrder.value ;
    fm.WorkFlowPathRecordOrder.value = dialogArguments.fm.WorkFlowPathRecordOrder.value ;
    
    //�õ�����Ĵ���
    pageCode = dialogArguments.fm.WorkFlowPathPageID.value
    fm.WorkFlowPathPageID.value = dialogArguments.fm.WorkFlowPathPageID.value ;
    pageCodeData = pageCode + "_Data";
    getMainFieldValue(pageCode,recordCount);
    return true;
}
/**
 *@description ���ÿ�ʼ�ڵ��optionѡ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */
 function setNodeOption()
 {
 	var optionString = "" ; //option��
 	var nodeCount    = 0  ; //�ڵ����
 	nodeCount = dialogArguments.document.getElementsByName("swfNodeNodeNo").length;
 	for(var i=1;i<nodeCount;i++)
 	{
 	   
 	   if(i==nodeCount-1)
 	   {
 	      optionString = optionString + dialogArguments.fm.swfNodeNodeNo[i].value + FIELD_SEPARATOR + dialogArguments.fm.swfNodeNodeNo[i].value+"-"+dialogArguments.fm.swfNodeNodeName[i].value ;
 	   }
 	   else
 	   {
 	   	  optionString = optionString + dialogArguments.fm.swfNodeNodeNo[i].value + FIELD_SEPARATOR + dialogArguments.fm.swfNodeNodeNo[i].value+"-"+dialogArguments.fm.swfNodeNodeName[i].value + GROUP_SEPARATOR;
 	   }
    }
    setOption("swfPathStartNodeNo",optionString);
    setOption("swfPathEndNodeNo",optionString);
 }
/**
 *@description ���ÿ�ʼ�ڵ�����ѡ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 
 function resetStartNodeName()
 {
   	var startNodeStr = fm.swfPathStartNodeNo.value;
   	var nodeName = "" ;
    //���µõ�����
 	var nodeCount = dialogArguments.document.getElementsByName("swfNodeNodeNo").length;
 	for(var i=1;i<nodeCount;i++)
 	{
 	   if(dialogArguments.fm.swfNodeNodeNo[i].value==startNodeStr)
 	   {
 	   	 nodeName = dialogArguments.fm.swfNodeNodeName[i].value;
 	   }
    }
   	fm.swfPathStartNodeName.value = nodeName;
   	fm.swfPathPathName.value = "��" + nodeName + "��" + fm.swfPathEndNodeName.value;
   	
 }
 
 /**
 *@description ���ÿ�ʼ�ڵ�����ѡ��
 *@param       ��
 *@return      ͨ������true,���򷵻�false
 */ 
 function resetEndNodeName()
 {
   	var endNodeStr = fm.swfPathEndNodeNo.value;
   	var nodeName = "" ;
 	var nodeCount = dialogArguments.document.getElementsByName("swfNodeNodeNo").length;
 	for(var i=1;i<nodeCount;i++)
 	{
 	   if(dialogArguments.fm.swfNodeNodeNo[i].value==endNodeStr)
 	   {
 	   	 nodeName = dialogArguments.fm.swfNodeNodeName[i].value;
 	   }
    }
   	fm.swfPathEndNodeName.value = nodeName;
   	fm.swfPathPathName.value = "��" + fm.swfPathStartNodeName.value + "��" + nodeName;
   	
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
  }
 
}

/**
 * ��ģʽ�����е����ݱ��浽������
 */
 function saveModelForm()
 {
 	if(fm.swfPathDefaultFlag.value=="")
 	{
 	   alert("��ѡ��ȱʡ·��");
 	   return false;	
 	}
 	if(fm.swfPathPriority.value=="")
 	{
 	   alert("����д���ȼ�");
 	   return false;	
 	}
 	if(fm.swfPathStartNodeNo.value=="")
 	{
 	   alert("��ѡ����ʼ�ڵ�");
 	   return false;	
 	}
 	if(fm.swfPathEndNodeNo.value=="")
 	{
 	   alert("��ѡ����ֹ�ڵ�");
 	   return false;	
 	}
    var pageCode = fm.WorkFlowPathPageID.value	;
    var dataPageCode = pageCode + "_Data";
    var index = fm.WorkFlowPathRecordOrder.value;
    setMainFieldValue(dataPageCode,index-1);
    window.close();
 }
 