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
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF">
    <!-- ���ⲿ�� -->
    
    <table width="90%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:18pt;">
          <B> �Ʋ����չɷ����޹�˾<B>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>������ϵ��¼ <B>
        </td>
      </tr>
      <tr>
        <td height="40" align=top align=left style="text-align:left; font-family:����; font-size:10pt;">
          ��λ:<bean:write name='linkRecordDto' property='comName' filter='true'/>
        </td>
        <td height="40" align=top align=center style="text-align:right; font-family:����; font-size:10pt;">
          �ⰸ���:<bean:write name='linkRecordDto' property='claimNo' filter='true'/>
        </td>
      </tr>
    </table>                                                                                             
<table border=1 class=common align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;"> 
  <tr class=common> 
    <td width="13%">�ӱ�������</td> 
    <td width="20%"><bean:write name='linkRecordDto' property='reportDate' filter='true' /></td> 
    <td width="13%">��ͻ���ϵ����</td>                         
    <td width="20%"><bean:write name='linkRecordDto' property='linkCustomDate'/></td>  
    <td width="13%">��������</td>                           
    <td width="21%"><bean:write name='linkRecordDto' property='copyPolicyDate' filter='true' /></td>  
  </tr>                    
  <tr class=common> 
    <td width="13%">�ֳ��鿱����</td> 
    <td width="20%"><bean:write name='linkRecordDto' property='checkDate' filter='true' /></td> 
    <td width="13%">��֤��������</td>                         
    <td width="20%"><bean:write name='linkRecordDto' property='finishDocDate'/></td>  
    <td width="13%">�᰸����</td>                           
    <td width="21%"><bean:write name='linkRecordDto' property='endCaseDate' filter='true' /></td>  
  </tr>       
</table>                                                                                             
<table border=1 class=common align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">  
  <tr class=common>                                                                                                
    <td width="10%">��</td>                         	
    <td width="10%">��</td>                              	
    <td width="80%">��Ҫ����ժҪ</td>                                    
  </tr>  
  <logic:notEmpty name='linkRecordDto' property='prpLregistExtList'>
    <logic:iterate id='prpLregistExtList' name='linkRecordDto' property='prpLregistExtList'>
      <tr class=common>                                                                                                
        <td width="10%"><bean:write name='prpLregistExtList' property='inputDate'/></td>                         	
        <td width="10%"><bean:write name='prpLregistExtList' property='inputDate'/></td>        
        <td width="80%"><bean:write name='prpLregistExtList' property='context'/></td>                                     
      </tr>  
    </logic:iterate>
  </logic:notEmpty> 
  <!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />   
  </body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                        