<%--
****************************************************************************
* DESC       ：添加定损打印页面
* AUTHOR     ： wangli
* CREATEDATE ： 2005-03-29   
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>


<script language="javascript">

/**
 * printType 调用打印表类型
 */
 
  //打印提交按钮
 function submitForm1(printType){
  var claimNo = fm.prpLverifyLossClaimNo.value;
  //alert(printType);
  if(claimNo==''){
   alert("无立案号，无法打印");
   return false;
   }
  var  strUrl = "/claim/ClaimPrint.do?printType="+printType+"&ClaimNo=" + claimNo;
  //alert("立案号为："+claimNo);
  printWindow(strUrl,"打印1");

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
</script>

<table cellpadding="4" cellspacing="1"  class="common" >
      <tr>
         <td class="common" align="left" style="width:20%"  >
            <input type=button value="零部件更换项目清单" class='bigbutton' onclick="submitForm1('ComponentList');">
        </td>
         <td class="common" align="center" style="width:20%"  >
            <input type=button value="修理项目清单打印" class='bigbutton' onclick="submitForm1('RepairList');">
        </td>
        <td class="common" align="center" style="width:20%"  >
            <input type=button value="修理项目清单附表" class='bigbutton' onclick="submitForm1('RepairAdd');">
        </td>
        <td class="common" align="center" style="width:20%"  >
            <input type=button value="损失情况确认书打印" class='bigbutton' onclick="submitForm1('Loss');">
        </td>
       <td class="common" align="right" style="width:20%"  >
            <input type=button value="检验定损报告打印" class='bigbutton' onclick="submitForm1('CheckCertainLoss');">
        </td>
      </tr>
 </table>

