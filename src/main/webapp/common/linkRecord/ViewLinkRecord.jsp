<%--
****************************************************************************
* DESC       ：货运险赔案终结报告书　
* AUTHOR     ：dongchengliang
* CREATEDATE ：2005-6-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%-- 初始化 --%>
<%--@include file="PropCompensateNoticeNoneFormatPrintIni.jsp"--%>

<html>
  <head>
    <title>理赔联系记录　</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body >
    <!-- 标题部分 -->
    
    <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:90%">
      <tr>
        <td class="title" colspan="2" height="40" align=top align=center style="text-align:center; font-family:宋体; font-size:14pt;">
          <B>理赔联系记录<B>
        </td>
      </tr>
      <tr>
        <td class="title" height="40" align=top align=left style="text-align:left; font-family:宋体; font-size:10pt;">
          单位:<bean:write name='linkRecordDto' property='comName' filter='true'/>
        </td>
        <td class="title" height="40" align=top align=center style="text-align:right; font-family:宋体; font-size:10pt;">
          赔案编号:<bean:write name='linkRecordDto' property='claimNo' filter='true'/>
        </td>
      </tr>
    </table>                                                    
<table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr class=common> 
    <td  width="13%">接报案日期</td> 
    <td  width="20%"><bean:write name='linkRecordDto' property='reportDate' filter='true' /></td> 
    <td  width="13%">与客户联系日期</td>                         
    <td  width="20%"><bean:write name='linkRecordDto' property='linkCustomDate'/></td>  
    <td  width="13%">抄单日期</td>                           
    <td  width="21%"><bean:write name='linkRecordDto' property='copyPolicyDate' filter='true' /></td>  
  </tr>                    
  <tr class=common> 
    <td  width="13%">现场查勘日期</td> 
    <td  width="20%"><bean:write name='linkRecordDto' property='checkDate' filter='true' /></td> 
    <td  width="13%">单证收齐日期</td>                         
    <td  width="20%"><bean:write name='linkRecordDto' property='finishDocDate'/></td>  
    <td  width="13%">结案日期</td>                           
    <td  width="21%"><bean:write name='linkRecordDto' property='endCaseDate' filter='true' /></td>  
  </tr>       
</table>                                                       
<table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common" >
  <tr class=common>                                                                                                
    <td  width="10%">月</td>                         	
    <td  width="10%">日</td>                              	
    <td  width="80%">主要内容摘要</td>                                    
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
    <!--打印按钮-->
      <input type="button" name=buttonPrint class='button' value="打印"  onclick="preparePrintForm(this);" >
    </td>
    <!--返回按钮-->                                  
    <td class="button" style="width:50%" align="right">
      <input type="button" name=buttonCancel class='button' value="返回" onclick="javascript:history.go(-2);" >
    </td>
</table>
</form>
  </body>
<script language='javascript'>
  function preparePrintForm(buttonPrint){
    var strUrl = '/claim/processLinkRecord.do?claimNo=' + fm.claimNo.value + '&editType=preparePrint';
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
           alert(strURL);
        var newWindow = window.open(strURL,strWindowName,'width='+pageWidth+',height='+pageHeight+',top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1.resizable=1,status=0');
        newWindow.focus();
        return newWindow;
      }       
</script>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                        