/*****************************************************************************
 * DESC       ：新增定损调度JS
 * AUTHOR     wangli 
 * CREATEDATE ： 2005-04-20
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/


/**
 * 将Table的所有输入域变成只读，同时将CSS的属性变成只读
 * @param tableId 表名称
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
    if(tbodies.all(i).tagName=="SELECT")
    {
    	tempElements = tbodies.all(i);
    	tempElements.disabled = true;
    }
    //将选择域变为只读
    if(tbodies.all(i).tagName=="TEXTAREA")
    {
    	tempElements = tbodies.all(i);
    	tempElements.disabled = true;
    }
     
    
  }
   //  alert("leave readonly function!");
}
/**
 * 保存然后按钮变灰，并激活所有文本信息
 * @param fileld 按钮域
 * @return  true
 */


 function saveThirdParty(fileld){
 	
 	 //reason: ValidateData.js中的校验不起作用时，因为没有调用校验方法
  if(!validateForm(fm,'ThirdParty_Data,ThirdProp_Data,PersonTrace_Data'))  
  {
    return false;
  }
  
  //判断涉案车辆的赔偿比例
  if (!isRightDutyPercent())
  {
    return false;
  }
    fileld.disabled = true; //防止反复提交
    ableAllInput();  //可以提交
    fm.submit();
    
   return true;   
 }
