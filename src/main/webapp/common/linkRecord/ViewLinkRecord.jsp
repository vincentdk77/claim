<%--
****************************************************************************
* DESC       ���������ⰸ�սᱨ���顡
* AUTHOR     ��dongchengliang
* CREATEDATE ��2005-6-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%-- ��ʼ�� --%>
<%--@include file="PropCompensateNoticeNoneFormatPrintIni.jsp"--%>

<html>
  <head>
    <title>������ϵ��¼��</title>
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body >
    <!-- ���ⲿ�� -->
    
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:90%">
      <tr>
        <td class="title" colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>������ϵ��¼<B>
        </td>
      </tr>
      <tr>
        <td class="title" height="40" align=top align=left style="text-align:left; font-family:����; font-size:10pt;">
          ��λ:<bean:write name='linkRecordDto' property='comName' filter='true'/>
        </td>
        <td class="title" height="40" align=top align=center style="text-align:right; font-family:����; font-size:10pt;">
          �ⰸ���:<bean:write name='linkRecordDto' property='claimNo' filter='true'/>
        </td>
      </tr>
    </table>                                                    
<table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr class=common> 
    <td  width="13%">�ӱ�������</td> 
    <td  width="20%"><bean:write name='linkRecordDto' property='reportDate' filter='true' /></td> 
    <td  width="13%">��ͻ���ϵ����</td>                         
    <td  width="20%"><bean:write name='linkRecordDto' property='linkCustomDate'/></td>  
    <td  width="13%">��������</td>                           
    <td  width="21%"><bean:write name='linkRecordDto' property='copyPolicyDate' filter='true' /></td>  
  </tr>                    
  <tr class=common> 
    <td  width="13%">�ֳ��鿱����</td> 
    <td  width="20%"><bean:write name='linkRecordDto' property='checkDate' filter='true' /></td> 
    <td  width="13%">��֤��������</td>                         
    <td  width="20%"><bean:write name='linkRecordDto' property='finishDocDate'/></td>  
    <td  width="13%">�᰸����</td>                           
    <td  width="21%"><bean:write name='linkRecordDto' property='endCaseDate' filter='true' /></td>  
  </tr>       
</table>                                                       
<table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr class=common>                                                                                                
    <td  width="10%">��</td>                         	
    <td  width="10%">��</td>                              	
    <td  width="80%">��Ҫ����ժҪ</td>                                    
  </tr>  
  <logic:notEmpty name='linkRecordDto' property='prpLregistExtList'>
    <logic:iterate id='prpLregistExtList' name='linkRecordDto' property='prpLregistExtList'>
      <tr class=common>                                                                                                
        <td  width="10%"><bean:write name='prpLregistExtList' property='inputDate'/></td>                         	
        <td  width="10%"><bean:write name='prpLregistExtList' property='inputDate'/></td>        
        <td  width="80%"><bean:write name='prpLregistExtList' property='context'/></td>                                     
      </tr>  
    </logic:iterate>
  </logic:notEmpty>      
</table>  
<form name ='fm' method='post' action='preparePrint'>
  <html:hidden name='linkRecordDto' property='claimNo'/>
<table id="buttonArea" cellpadding="0" cellspacing="10" width=100% style="display:">
  <tr>                                                                                   
    <td class="button" style="width:50%" align="left">
    <!--��ӡ��ť-->
      <input type="button" name=buttonPrint class='button' value="��ӡ"  onclick="preparePrintForm(this);" >
    </td>
    <!--���ذ�ť-->                                  
    <td class="button" style="width:50%" align="right">
      <input type="button" name=buttonCancel class='button' value="����" onclick="javascript:history.go(-2);" >
    </td>
</table>
</form>
  </body>
<script language='javascript'>
  function preparePrintForm(buttonPrint){
    var strUrl = '/claim/processLinkRecord.do?claimNo=' + fm.claimNo.value + '&editType=preparePrint';
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
           alert(strURL);
        var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      }       
</script>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                        