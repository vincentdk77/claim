/*****************************************************************************
 * DESC       ������������JS
 * AUTHOR     ��liubvo
 * CREATEDATE �� 2004-08-10
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


//���һҳ�����ж��м�¼
//ҳ����
function deleteAllRows(pageCode)
{
  var oTBODY   = document.all(pageCode).tBodies.item(0);
  
  var intCount = getElementCount("prpLcomponentPartCode"); 
  
  for(var i=intCount-1;i>=1;i--)
  {
    deleteRowTableComponent(fm.prpLcomponentPartCode[i],pageCode,1,1);
  }
}



function deleteSystemRows(pageCode)
{
  var oTBODY   = document.all(pageCode).tBodies.item(0);
  
  var intCount = getElementCount("prpLcomponentPartCode"); 
  
  for(var i=intCount-1;i>=1;i--)
  {
    if (fm.prpLcomponentFlag[i].value=='1'){
    deleteRowTableComponent(fm.prpLcomponentPartCode[i],pageCode,1,1);
    }
  }
}


function showFittingsInfo()
{ 

//	  deleteAllRows('Component');
deleteSystemRows('Component');
	  
	  
    var oldTarget = fm.target;
    var oldAction = fm.action;
  	
    fm.target="fraSubmit"
    fm.action="/claim/DAA/certainLoss/DAAShowFittingsInfo.jsp?registNo=" + fm.RegistNo.value
               +"&lossItemCode=" + fm.prpLcarLossLossItemCode.value;
    
    fm.submit();
  
    fm.target=oldTarget;
    fm.action=oldAction;    

}


/**
 * �����ϵͳ��ȡ�����Ϣ
 */     
 function getFittingsInfo(queryType)
 {
   var selectedCarFittings = "";
/*
   if (fm.prpLcarLossModelCode.value==""){

	alert("����¼�복��");
	return false;
   	}
*/
   var k=1;
   var count = getElementCount("prpLcomponentPartCode");  

   for(var i=1;i<count;i++)
   {
     if(k==1&&fm.prpLcomponentFlag[i].value=='1'){
       selectedCarFittings = fm.prpLcomponentKindCode[i].value + "^"
                           + fm.prpLcomponentKindName[i].value + "^"
                           + fm.prpLcomponentCompCode[i].value + "^"
                           + fm.prpLcomponentIndId[i].value + "^"                           
                           + fm.prpLcomponentOriginalId[i].value + "^"
                           + fm.prpLcomponentMaterialFee[i].value + "^"                           
			   + fm.prpLcomponentQuantity[i].value + "^"                                                      
			   + fm.prpLcomponentVerpCompPrice[i].value + "^"                                                      			   
                           + fm.prpLcomponentRemark[i].value;
       				k++;  
       			   continue;	                  
                           }
      if(k>1&&fm.prpLcomponentFlag[i].value=='1'){     
       selectedCarFittings += "_" + fm.prpLcomponentKindCode[i].value + "^"
                           + fm.prpLcomponentKindName[i].value + "^"
                           + fm.prpLcomponentCompCode[i].value + "^"
                           + fm.prpLcomponentIndId[i].value + "^"                           
                           + fm.prpLcomponentOriginalId[i].value + "^"
                           + fm.prpLcomponentMaterialFee[i].value + "^"                           
			   + fm.prpLcomponentQuantity[i].value + "^"                                                      
			   + fm.prpLcomponentVerpCompPrice[i].value + "^"                                                      			   
                           + fm.prpLcomponentRemark[i].value;
				k++;                                                
    	}                            
   }
   fm.selectCarFittings.value=selectedCarFittings;
   strURL = "/claim/DAA/certainLoss/openFittingsSystemBefore.jsp?queryType="+queryType
          +"&registNo="+fm.RegistNo.value
          +"&policyNo="+fm.PolicyNo.value
          +"&insurant="+fm.prpLverifyLossInsuredName.value
          +"&lossItemCode="+fm.prpLcarLossLossItemCode.value
          +"&licenseNo="+fm.prpLcarLossLossItemName.value
          +"&repairfactorytype="+fm.prpLrepairFeeRepairFactoryName.value
          +"&showpriceflag=0"
          +"&systemAreaCode="+fm.SysAreaCode.value       //ϵͳ�۵��� 
          +"&localAreaCode="+fm.LocalAreaCode.value         //���ؼ۵�������д��ǰ�û����ڵķֹ�˾���룩
          +"&vehCode=" +fm.prpLcarLossModelCode.value          //���ͱ���          
          +"&vehName=" +fm.prpLcarLossBrandName.value;          //��������
          //--+"&selectedCarFittings="+selectedCarFittings;  //��ѡ������
 
   var newWindow = window.open(strURL,"�����ϵͳ",'width=1010,height=670,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
   newWindow.focus();
 }
 
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
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="carLossRepairFeeLossItemCode")
  	{
  		elements[i].value = index;
  	} 
  } 
  
  //Add by chenrenda begin 20050316
  //Reason:������Ŀ�����嵥����һ��ʱ������һ����ձ�������ձ����ƴ���������Ŀ��
  var newSerialNo = fm.prpLrepairFeeSerialNo.length-1;
  if(newSerialNo>1)
  {
    fm.prpLrepairFeeKindCode[newSerialNo].value=fm.prpLrepairFeeKindCode[newSerialNo-1].value;
    fm.prpLrepairFeeKindName[newSerialNo].value=fm.prpLrepairFeeKindName[newSerialNo-1].value;
  }
  //Add by chenrenda end 20050316
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
  try{
  pageSerialNo = parseInt(fm.carLossRepairFeeLossItemCode(recentDeletedRowNo-1).value);
  }catch(e){
    pageSerialNo = 0;
  }
  var order = recentDeletedRowNo - 2;  //˳���Ϊ��0��ʼ
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
  //order = getRowCurrPageRepairFee(field,pageCode); lixiang ��֣�������ر�������Ҫ�Ȱ���ӡ�
  //alert(order);
   //������������Ѿ͹���
  
//  var ManHour     = parseFloat(oTBODY.rows[order].getAttrible("prpLrepairFeeManHour")); 
//  var manHourFee  = parseFloat(oTBODY.rows[order].getAttrible("prpLrepairFeeMaterialFee"));

   var computLine=0;
     computLine=order +1 ; //��Ҫ�������
     //�������˻ص�ʱ��������˫�еļ�¼
     var backRows = getElementCount("txtRepairFeeBackFlag");
     if(controlRowsCount==1)
  {
  	 
     if (backRows>0){
     	//computLine=order+1;
     	order =backRows+order; //��Ϊ�����backrws�Ļ�����Ҫ����
     	
    }
      
  }
  
   if (controlRowsCount==2){
   	    order = order*2;
    }
   // alert (computLine)
    var ManHour     = parseFloat(fm.all("prpLrepairFeeManHour")[computLine].value); 
//   alert("ok")
    var manHourFee  = parseFloat(fm.all("prpLrepairFeeMaterialFee")[computLine].value);
   
    var sumManHourFee  = parseFloat(fm.SumDefLoss1.value);
 
     //�ж��������ǲ��ǿ� 
    if(isNaN(ManHour ))  ManHour  = 1;
    if(isNaN(manHourFee)) manHourFee = 0; 
    if(isNaN(sumManHourFee)) sumManHourFee = 0; 
         
     sumManHourFee  = sumManHourFee - manHourFee;
     fm.SumDefLoss1.value = point(round(sumManHourFee,2),2);  
 
     if (controlRowsCount==2){
  	oTBODY.removeChild(oTBODY.rows[order]);
  	oTBODY.removeChild(oTBODY.rows[order]);
     }else{   
     for(var i=0;i<controlRowsCount;i++)
     {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
  }
  //alert("ok2") 
  //calculateAll(),����������60��ʱ����ɾ��һ��ʱ�����¼���Ҫ����ӡ�̫���ˡ�����
  
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
  
  for(var i=0;i<oTBODYData.rows.length;i++) 
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true)); 
  }
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="carLossComponentLossItemCode")
  	{
  		elements[i].value = index;
  	} 
  } 
  
  //Add by chenrenda begin 20050316
  //Reason:�㲿��������Ŀ�����嵥����һ��ʱ������һ����ձ�������ձ����ƴ���������Ŀ��
  var newSerialNo = fm.prpLcomponentSerialNo.length-1;
  if(newSerialNo>1)
  {
    fm.prpLcomponentKindCode[newSerialNo].value=fm.prpLcomponentKindCode[newSerialNo-1].value;
    fm.prpLcomponentKindName[newSerialNo].value=fm.prpLcomponentKindName[newSerialNo-1].value;
  }
  //Add by chenrenda end 20050316  

  if (fm.carLossComponentLossItemCode.length>=0){
	  initCarLossSum(0);
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

  try{  
    pageSerialNo = parseInt(fm.carLossComponentLossItemCode(recentDeletedRowNo-1).value);
  }catch(e){
    pageSerialNo = 0;
  }

  var order = recentDeletedRowNo - 2;  //˳���Ϊ��0��ʼ
  //alert(order);
  var oTBODY   = document.getElementsByName(pageCode)[pageSerialNo].tBodies.item(0);
 
  var computLine=0;
     computLine=order +1 ; //��Ҫ�������
    var backRows = getElementCount("txtComponentBackFlag");
     if(controlRowsCount==1)
  {
  	 
     if (backRows>0){
     	order =backRows+order; //���ܴ��ڶ��е�
     	
    }
      
  }
  
   if (controlRowsCount==2){
   	    	order=order*2
    }
    //alert(computLine+"controrow:"+controlRowsCount)
    var DefLoss    = parseFloat(fm.all("prpLcomponentSumDefLoss")[computLine].value); //����������
    var RestFee  = parseFloat(fm.all("prpLcomponentRestFee")[computLine].value); //��ֵ
    var sumRestFee  = parseFloat(fm.prpLcarLossSumRest.value); //��ֵ�ܼ�
    var sumDefLoss  = parseFloat(fm.SumDefLoss2.value);  //�����ϼ�

     //�ж��������ǲ��ǿ� 
    if(isNaN(DefLoss ))  DefLoss  = 0;
    if(isNaN(RestFee)) RestFee = 0; 
    if(isNaN(sumRestFee)) sumRestFee = 0; 
    if(isNaN(sumDefLoss)) sumDefLoss = 0; 

     
     sumRestFee = sumRestFee - RestFee;
     sumDefLoss = sumDefLoss - DefLoss;

     fm.prpLcarLossSumRest.value = point(round(sumRestFee,2),2);  
     fm.SumDefLoss2.value = point(round(sumDefLoss,2),2); 
  if (controlRowsCount==2){
  	oTBODY.removeChild(oTBODY.rows[order]);
  	oTBODY.removeChild(oTBODY.rows[order]);
  }else{   
  for(var i=0;i<controlRowsCount;i++)
  {
    oTBODY.removeChild(oTBODY.rows[order*controlRowsCount]);
  }
}
  //calculateAll();
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

//Add by chenrenda begin 20050321
//Reason:������Ŀ���ü�������Ŀ����ʱĬ����3��Ŀ������ʱ��һ������3��Ŀ
//���༭����ΪAddʱ��ҳ��������Ŀ���á�������Ŀģ���a��������
function loadRepairFeeRow()
{
  for(var i=0;i<3;i++)
  {
    certainLossInsertRow('RepairFee','RepairFee_Data');  
    certainLossInsertRow('Component','Component_Data');  
  }   
}

//�ڱ���·����һ�����ݣ���ֹ�Ǳ�ģ�����
function certainLossInsertRow(pageCode,dataPageCode)
{
  var index = 0;  //��ǰtable����
  var elements = null; 

  var oTBODY = document.getElementsByName(pageCode)[index].tBodies.item(0);
  var oTBODYData = document.getElementById(dataPageCode).tBodies.item(0);
  elements = oTBODY.getElementsByTagName("INPUT");
  
  for(var i=0;i<oTBODYData.rows.length;i++) 
  {
    oTBODY.appendChild(oTBODYData.rows[i].cloneNode(true)); 
  }
  for(var i=0;i<elements.length;i++)
  {
  	if(elements[i].name=="carLossRepairFeeLossItemCode")
  	{
  		elements[i].value = index;
  	} 
    if(elements[i].name=="carLossComponentLossItemCode")
  	{
  		elements[i].value = index;
  	} 
  } 
  return true;
}

//������Ŀ����ʱ��һ����������Ŀ
function insertThreeRowTableComponent(pageCode,dataPageCode,field)
{
  for(var i=0;i<3;i++)
  {
    insertRowTableComponent(pageCode,dataPageCode,field);  
  }   
}

//������Ŀ��������ʱ��һ����������Ŀ
function insertThreeRowTableRepairFee(pageCode,dataPageCode,field)
{
  for(var i=0;i<3;i++)
  {
    insertRowTableRepairFee(pageCode,dataPageCode,field);  
  }   
}


//���´��������ҳ��
function openPrplRepairFeeCompWin(PageCode,Field)
{
   var index = parseInt(getElementOrder(Field))-1;    
   var partCode = fm.prpLrepairFeePartCode(index).value;
   var previousFlag = "repairFee";//�˱�־λ��ʾ��ҳ��������������嵥ģ��
   var pageUrl="/claim/DAA/regist/DAARegistGetCompCode.jsp?strIndex="+index+"&partCode="+partCode+"&previousFlag="+previousFlag;
   window.open(pageUrl,"openPrplRepairFeeCompWin","resizable=0,scrollbars,dependent,alwaysRaised,width=230,height=450");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
}  



//���´��������ҳ��
function openPrplComponentCompWin(PageCode,Field)
{
   var index = parseInt(getElementOrder(Field))-1;    
   var partCode = fm.prpLcomponentPartCode(index).value;
   var previousFlag = "component";  //�˱�־λ��ʾ��ҳ�����Ի����嵥ģ��
   var pageUrl="/claim/DAA/regist/DAARegistGetCompCode.jsp?strIndex="+index+"&partCode="+partCode+"&previousFlag="+previousFlag;
   window.open(pageUrl,"openPrplComponentCompWin","resizable=0,scrollbars,dependent,alwaysRaised,width=230,height=450");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
}  

//����۸�����ʱ���Զ����������Զ���ֵ������
function getVerifyRepairFee()
{
 var count=getElementCount("prpLrepairFeeVeriSumLoss");  
 for(var i=1;i<count;i++)
 {
//   fm.prpLrepairFeeManHourUnitPrice[i].value = fm.prpLrepairFeeVeriManHour[i].value; 
//   fm.prpLrepairFeeSumDefLoss[i].value = fm.prpLrepairFeeVeriSumLoss[i].value;
   fm.prpLrepairFeeManHour[i].value = fm.prpLrepairFeeVeriManHour[i].value; 
   fm.prpLrepairFeeManHourUnitPrice[i].value = fm.prpLrepairFeeVeriManUnitPrice[i].value;
   
 }
  setVerifyRepairFeeNew();
  calculateAll();
}

//����۸�����ʱ���Զ����������Զ���ֵ������
function getVerifyComponent()
{
 var count=getElementCount("prpLcomponentVeriQuantity");  
 
 for(var i=1;i<count;i++)
 {
   fm.prpLcomponentQuantity[i].value = fm.prpLcomponentVeriQuantity[i].value; 
   fm.prpLcomponentMaterialFee[i].value = fm.prpLcomponentVeriMaterFee[i].value;
   fm.prpLcomponentSumDefLoss[i].value = fm.prpLcomponentSumVeriLoss[i].value;
 }
 if(count>1)
 {
  fm.prpLcomponentQuantity[count-1].focus();
 }
}
//Add by chenrenda end 20050321
function setFactoryName(){
      if (fm.prpLrepairFeeRepairFactoryCode.value==1){
      		fm.prpLrepairFeeRepairFactoryName.value="4S��";}
      if (fm.prpLrepairFeeRepairFactoryCode.value==2){
      		fm.prpLrepairFeeRepairFactoryName.value="һ�೧";}
      if (fm.prpLrepairFeeRepairFactoryCode.value==3){
      		fm.prpLrepairFeeRepairFactoryName.value="���೧һ��";}
      		
}


 function setVerifyRepairFeeNew()
 {  

  var i = 0;
  var findex=0;       
  var manHourFee;
  var materialFee; 
  var sumDefLoss;
  var ManHour;
  var quantity;

  for(i=1;i<fm.all("prpLrepairFeeManHour").length;i++)
  {
	    ManHour = parseFloat(fm.all("prpLrepairFeeManHour")[i].value);
	    manHourFee  = parseFloat(fm.all("prpLrepairFeeManHourUnitPrice")[i].value)      
	    if(isNaN(manHourFee)||manHourFee.length<1){
	      manHourFee = 0;
	    }
	    if(manHourFee==0 && materialFee==0){
	      //return true;  
	    }
	    if(isNaN(ManHour)||ManHour.length<1){
	      ManHour = 0; 
	    }
	    sumDefLoss = manHourFee*ManHour ;    
	    fm.all("prpLrepairFeeSumDefLoss")[i].value = point(round(sumDefLoss,2),2);
	    sumRepairFee();
  }
  	return true;  
       
 } 

