<%--
****************************************************************************
* DESC       ������ʱ������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-18
* MODIFYLIST ��Name       Date            Reason/Contents
*            ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%>
<%@page import="com.sinosoft.claim.util.*"%>

<%
  //������������
  String strPolicyNo        = request.getParameter("PolicyNo");   //������  
  String strEndDate = request.getParameter("EndDate");
  String strRiskCode        = "";   //����
  String strWhere           = "";   //sql���
  String strRiskPage        = ""; 
  int i = 0;
  
  //�õ������������Ϣ
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");  
    
  //���ݱ������ݷַ�����ӡҳ��
/*
  if(strRiskCode.equals(BusinessRuleUtil.getOuterCode(request,"RISKCODE_DAA")))
  {
    strRiskPage = "/" + strRiskCode + "/cb/UIPolicy" + strRiskCode + "SingleCarNoneFormatPrint.jsp"  ;  //���ñ༭ҳ��
  }
  else 
  {
    strRiskPage = "/" + strRiskCode + "/cb/UIPolicy" + strRiskCode + "NoneFormatPrint.jsp"  ;
  }  
*/ 
%>  

<html>
  <head>
    <title>�����ӡǰ���뵥֤��</title>
    <%-- ���ú��� --%>
    <script src="/ddccallweb/commonship/print/Common.js"></script>
    <%-- ҳ����ʽ  --%>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script language="javascript">
      function printOrigalPolicy()
      {       
        //ԭʼ����
         var strUrl = "";  
         strUrl = "/claim/ClaimPrint.do?printType=HistoryPolicy&PolicyNo=<%= strPolicyNo %>&EDITTYPE=COPY&PrintType=O";
         printWindow(strUrl,"��ӡ1"); 
      }
      function printEndorse() 
      {   
         //ԭʼ����
         var strUrl = "";   
         strUrl = "/claim/ClaimPrint.do?printType=HistoryEndorse&PolicyNo=<%= strPolicyNo %>&EDITTYPE=COPY";
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
  </head>  
  <form name="fm">
  <table width="80%" height="164" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr> 
      <td valign="bottom"" height="92" colspan="4" class=common align="center" style="font-family:����; font-size:10pt;">ԭʼ����������</td>
    </tr>
    <input type='hidden' name='EndDate' value="<%= request.getParameter("EndDate") %>">
    <input type='hidden' name='EndDateHour' value="<%= request.getParameter("EndDateHour") %>">
     
    <tr> 
      <td height="70" colspan="2" align="center" class=common > 
        <input type=button name=buttonPrintOrigalPolicy value="ԭʼ����" class="bigbutton" onClick="printOrigalPolicy()"> 
      </td>
      <td colspan="2" align="center" class=common > <input type=button name=buttonPrintEndorse value="��������"	  class="bigbutton" onClick="printEndorse()"> 
      </td>
    </tr>
  </table>
</form>
</html>
