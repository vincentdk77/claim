<%--
****************************************************************************
* DESC       �������ձ��վ���/ע������֪ͨ���ӡҳ��
* AUTHOR     ��zhulianyu
* CREATEDATE ��2005-11-14
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%> 
<%@ page contentType="text/html; charset=GBK" %>
  <%-- ��ʼ�� --%>
  <%@include file="FreightRefuseCancelNoticeNoneFormatPrintIni.jsp"%>
 
<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                    

  <body bgcolor="#FFFFFF" onload="loadForm();">                                        
    <!-- ���ⲿ�� -->                                                                  <table width="95%"><tr><td width="99%">
   
    <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height="40">
        <td colspan="2" id="tdTitleName" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <B>�����ձ��վ���/ע������֪ͨ��<B>
        </td>
      </tr>
      <tr height="30">
        <td align=left id="tdRegistNo" width="50%" style="font-family:����; font-size:10pt;">
          �����ţ�
        </td>
        <td align=left id="tdCaseNo" width="50%" style="font-family:����; font-size:10pt;">
          �鵵�ţ�
        </td>
      </tr>      
    </table>
      
    <!-- ���岿�� -->
	
	<table border=1 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr height="25">
        <td colspan=1 width="12%" align="center">��������</td>
        <td colspan=4 id="tdInsuredName" width="46%"align="center">&nbsp;</td>
        <td width="12%"align="center">���ս��</td>
        <td id="tdSumAmount1" width="22%"align="center">&nbsp;</td>
      </tr>
      <tr height="25">
        <td colspan=1 width="12%"align="center">�����ձ�</td>
        <td colspan=2 id="tdRiskName" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">���ձ��</td>
        <td colspan=3 id="tdLossName" width="34%"align="center">&nbsp;</td>
      </tr> 
      <tr height="25">
        <td colspan=1 width="12%"align="center">��������</td>
        <td colspan=2 id="tdPolicyNo" width="34%"align="center">&nbsp;</td>
        <td width="12%"align="center">�����ڼ�</td>
        <td colspan=3 id="tdInsuredDate" width="34%"align="center">&nbsp;</td>
      </tr>              
      <tr height="25">
        <td width="12%"align="center">����ʱ��</td>
        <td colspan=2 id="tdDamageStartDate" width="34%"align="center"></td>  
        <td width="12%"align="center">���յص�</td>
        <td colspan=3 id="tdDamageAddress" width="34%"align="center">&nbsp;</td>        
      </tr>
      <tr height="25">
        <td colspan=2 width="32%"align="center">���ղƲ���ַ�����乤��</td>
        <td colspan=5  id="tdBLName" width="60%"align="center">&nbsp;</td>
      </tr>         
      <tr height="25">
        <td colspan=2 width="32%"align="center">�������������ص�</td>
        <td colspan=5  id="tdSiteName" width="60%"align="center">&nbsp;</td>
      </tr>     

      <tr height="140">
      <td colspan="7" valign=top id="tdDamageCause">
      ����ԭ��
      </td>
      </tr>
      <tr height="140">
      <td colspan="7" valign=top id="tdCancelReason">
      ����/ע�����ɣ�
      </td>
      </tr>      
      <tr height="140">
      <td colspan="7" valign=top>
      ����Ŀ¼��<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1��<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2��<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3��<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4��
      </td>
      </tr>
      <tr height="140">
      <td colspan="3" valign=top width="46%">
      �ر���ʾ��<br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������������飬�ڽӵ���֪ͨ���ʮ�����ڣ��򱾹�˾�򱾹�˾�ϼ����ܲ���������渴�顣�������Զ���������<br><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��������ǩ�£�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��

	  </td>
      <td colspan="4" valign=top>
      ����˾��ַ��<%=addressCName%><br><br>
      �������룺<%=postCode%><br><br>
      ��ϵ�绰��<%=phoneNumber%><br><br><br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;������ǩ�£�<br><br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=new SimpleDateFormat("yyyy��MM��dd��").format(new Date())%>
      </td>      
      </tr>
            
    </table>
    <table border="0"style="font-family:����_GB2312; font-size:10pt;">
      <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;ע�������ɱ�������ǩ�ջ������ԹҺ����ʼġ��Һ����ʾֻ�ִ������ڡ�</td>
      </tr>      
    </table>
        </td>
		<td width="1%" style="font-family:����_GB2312; font-size:10pt;"><br><br><br><br><br><br><br><br>��<br>һ<br>��<br>��<br>��<br>˾<br>��<br>��<br>��<br><br><br><br><br><br><br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>��<br>��</td>
      </tr>      
    </table>
     
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
    
  </body>
</html>
