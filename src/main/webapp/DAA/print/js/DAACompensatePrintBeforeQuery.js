function CheckboxAll_onclick()
{
  var i = 0;
  for(i=1; i<fm.CheckedCompensateNo.length; i++)
  {
    fm.CheckedCompensateNo[i].checked = fm.CheckboxAll.checked;
    fm.PrintNo[i].checked = fm.CheckboxAll.checked;
  }
}

function CheckedCompensateNo_onclick(field)
{
  var i = getElementOrder(field)-1;
  if(!field.checked) fm.CheckboxAll.checked = false;
  fm.PrintNo[i].checked = field.checked;
}

 //??????
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
      
       function submitForm()
      {
        
         // var strUrl = "";

         /* if( fm.PrintType.value=="Compensate" )      //12.?????
          {
           strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&CompensateNo=" + fm.BizNo.value;
          }
          if( fm.PrintType.value=="CompensateAdd" )   //13.???????
          {
            strUrl = "/claim/ClaimPrint.do?printType="+fm.PrintType.value+"&RegistNo=" + fm.registNo.value +"&CompensateNo=" + fm.BizNo.value;
          }
          */
 
          
		  //add by caopeng end at 2005-12-12	  
       // if( fm.PrintType.value=="Compensate" || fm.PrintType.value=="CompensateAdd"  ) {
             //  var newWindow = window.open("claim/ClaimPrint.do?PrintType=Compensate&CompensateNo=" + fm.CheckedCompensateNo.value,"NewWindow","width=600,height=500,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0"); 
               //var newWindow = window.open("/claim/compensateQuery.do?PrintType=Compensate&CompensateNo=" + fm.BizNo.value+"&RegistNo=" + fm.registNo.value+"&ClaimNo=" + fm.claimNo.value +"&editType=PRINT","NewWindow","width=600,height=500,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0");
             //fm.action="/claim/compensateQuery.do?PrintType="+fm.PrintType.value+"&ClaimNo=" + fm.claimNo.value +"&editType=PRINT";
             //fm.submit();
           
      }

     