<%--
****************************************************************************
* DESC       ����Ӷ����ӡҳ��
* AUTHOR     �� wangli
* CREATEDATE �� 2005-03-29   
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>


<script language="javascript">

/**
 * printType ���ô�ӡ������
 */
 
  //��ӡ�ύ��ť
 function submitForm1(printType){
  var claimNo = fm.prpLverifyLossClaimNo.value;
  //alert(printType);
  if(claimNo==''){
   alert("�������ţ��޷���ӡ");
   return false;
   }
  var  strUrl = "/claim/ClaimPrint.do?printType="+printType+"&ClaimNo=" + claimNo;
  //alert("������Ϊ��"+claimNo);
  printWindow(strUrl,"��ӡ1");

  } 
  //��ʾ��ӡ����
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
            <input type=button value="�㲿��������Ŀ�嵥" class='bigbutton' onclick="submitForm1('ComponentList');">
        </td>
         <td class="common" align="center" style="width:20%"  >
            <input type=button value="������Ŀ�嵥��ӡ" class='bigbutton' onclick="submitForm1('RepairList');">
        </td>
        <td class="common" align="center" style="width:20%"  >
            <input type=button value="������Ŀ�嵥����" class='bigbutton' onclick="submitForm1('RepairAdd');">
        </td>
        <td class="common" align="center" style="width:20%"  >
            <input type=button value="��ʧ���ȷ�����ӡ" class='bigbutton' onclick="submitForm1('Loss');">
        </td>
       <td class="common" align="right" style="width:20%"  >
            <input type=button value="���鶨�𱨸��ӡ" class='bigbutton' onclick="submitForm1('CheckCertainLoss');">
        </td>
      </tr>
 </table>

