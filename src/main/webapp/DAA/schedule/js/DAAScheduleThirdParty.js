/*****************************************************************************
 * DESC       �������������JS
 * AUTHOR     wangli 
 * CREATEDATE �� 2005-04-20
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


/**
 * ��Table��������������ֻ����ͬʱ��CSS�����Ա��ֻ��
 * @param tableId ������
 * @return saveThirdParty
 */
function readonlyAllTableInput(tableId)
{

  // alert("enter readonly function!"+tableId);
   var testStr = "" ;
   var tempElements = null;
   var tbodies = document.getElementById(tableId);
   //.tBodies; 
   
  // alert("tbodies is :"+tbodies);
  for(i=0; i<tbodies.all.length; i++) 
   {
    //alert(document.all(i).tagName);
    if(tbodies.all(i).tagName=="INPUT")
    {
        tempElements = tbodies.all(i);
        //���������Ϊֻ��
     
        if(tempElements.type=="text")
        {
	    	tempElements.style.fontSize="9pt";
	    	tempElements.style.borderTop = "none";
	    	tempElements.style.borderBottom = "none";
	    	tempElements.style.borderRight= "none";
	    	tempElements.style.borderLeft = "none" ;
	    	//tempElements.style.width="80%";
	    	tempElements.style.color = "#000000";
	    	tempElements.style.backgroundColor = "#F4F9FF";        	
        	tempElements.readOnly=true;
        }
       
        //���������Ϊֻ��
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=true;
        }    
        
    }
    //��ѡ�����Ϊֻ��
    if(tbodies.all(i).tagName=="SELECT")
    {
    	tempElements = tbodies.all(i);
    	tempElements.disabled = true;
    }
    //��ѡ�����Ϊֻ��
    if(tbodies.all(i).tagName=="TEXTAREA")
    {
    	tempElements = tbodies.all(i);
    	tempElements.disabled = true;
    }
     
    
  }
   //  alert("leave readonly function!");
}
/**
 * ����Ȼ��ť��ң������������ı���Ϣ
 * @param fileld ��ť��
 * @return  true
 */


 function saveThirdParty(fileld){
 	
 	 //reason: ValidateData.js�е�У�鲻������ʱ����Ϊû�е���У�鷽��
  if(!validateForm(fm,'ThirdParty_Data,ThirdProp_Data,PersonTrace_Data'))  
  {
    return false;
  }
  
  //�ж��永�������⳥����
  if (!isRightDutyPercent())
  {
    return false;
  }
    fileld.disabled = true; //��ֹ�����ύ
    ableAllInput();  //�����ύ
    fm.submit();
    
   return true;   
 }
