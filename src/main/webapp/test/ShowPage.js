/*****************************************************************************
 * DESC       ����Ա�б�����JS
 * AUTHOR     ��weishixin
 * CREATEDATE �� 2004-08-01
 * MODIFYLIST ��   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


//����Ϊ������ʾ����

/**
 * ���ܣ�����������ֻ����ͬʱ��CSS�����Ա��ֻ��
 * return true/false
 */
function readonlyAllInput()
{
  var testStr = "" ;
  var tempElements = null;
  
  for(i=0; i<document.all.length; i++) 
  {
    //alert(document.all(i).tagName);
    if(document.all(i).tagName=="INPUT")
    {
        tempElements = document.all(i);
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
    if(document.all(i).tagName=="SELECT")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = true;
    }
    //��ѡ�����Ϊֻ��
    if(document.all(i).tagName=="TEXTAREA")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = true;
    }
    
  }

}


/**
 * ���ܣ� ��ť��İ�ť���ɿɶ�
 * @param tableID ���а�ť�ı�ID
 */
 
 function disabledAllButton(tableId)
 {
   var elements = getTableElements(tableId);

   for(var i=0;i<elements.length;i++)
   {


       //��button��ɲ�����
       if(elements[i].type == "button")
       {
          elements[i].disabled = true;
       }
       //��submit��ɲ�����
       if(elements[i].type == "submit")
       {
          elements[i].disabled = true;
       }
       //��reset��ɲ�����
       if(elements[i].type == "reset")
       {
          elements[i].disabled = true;
       }

    }
 }