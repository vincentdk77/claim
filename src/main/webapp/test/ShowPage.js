/*****************************************************************************
 * DESC       ：人员列表增加JS
 * AUTHOR     ：weishixin
 * CREATEDATE ： 2004-08-01
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


//以下为测试显示界面

/**
 * 功能：将输入域变成只读，同时将CSS的属性变成只读
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
        //将输入域变为只读
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
        //将输入域变为只读
        if(tempElements.type=="radio")
        {
        	tempElements.disabled=true;
        }
        
    }
    //将选择域变为只读
    if(document.all(i).tagName=="SELECT")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = true;
    }
    //将选择域变为只读
    if(document.all(i).tagName=="TEXTAREA")
    {
    	tempElements = document.all(i);
    	tempElements.disabled = true;
    }
    
  }

}


/**
 * 功能： 按钮域的按钮域变成可读
 * @param tableID 含有按钮的表ID
 */
 
 function disabledAllButton(tableId)
 {
   var elements = getTableElements(tableId);

   for(var i=0;i<elements.length;i++)
   {


       //将button设成不可用
       if(elements[i].type == "button")
       {
          elements[i].disabled = true;
       }
       //将submit设成不可用
       if(elements[i].type == "submit")
       {
          elements[i].disabled = true;
       }
       //将reset设成不可用
       if(elements[i].type == "reset")
       {
          elements[i].disabled = true;
       }

    }
 }