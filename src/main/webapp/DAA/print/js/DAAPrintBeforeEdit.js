/*****************************************************************************
 * DESC       ：车险打印的脚本函数页面
 * AUTHOR     ：lixiang
 * CREATEDATE ： 2004-11-12
 * MODIFYLIST ：   Name       Date            Reason/Contents
 *          ------------------------------------------------------
 ****************************************************************************/

/**
 *@description 提交
 *@param       无
 *@return      通过返回true,否则返回false
 */
 
 function claimPrint()
 {
 	var strPrintType = fm.printType.value;
 	var strBusinessNo=fm.BusinessNo.value;
 	var win;
  var printDetailDo="";
  	
 	if (strPrintType =="Regist")
 	{
 	
 		if (trim(strBusinessNo).length<1)
 		{
 			alert("请输入业务号码!");
 			return false;
 		}
 	  printDetailDo="/claim/ClaimPrint.do?printType="+strPrintType+"&registNo="+strBusinessNo;
    //var newWindow = window.open(printDetailDo,"DAARegistNoneFormatPrint",'width=640,height=500,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
    //newWindow.focus();
    
    printWindow(printDetailDo,"打印");
 			
 		
 	}
 		
 	  return true;
 
}

//显示打印窗口
function printWindow(strURL,strWindowName)
{
  var pageWidth=screen.availWidth-10;
  var pageHeight=screen.availHeight-30;
  if (pageWidth<100 )
    pageWidth = 100;

  if (pageHeight<100 )
    pageHeight = 100;

  var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
  newWindow.focus();
  return newWindow;
}