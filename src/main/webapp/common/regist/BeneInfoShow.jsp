<%--
****************************************************************************
* DESC       ����������Ϣ��ʾ����
* AUTHOR     �� Sinosoft
* CREATEDATE �� 2005-08-04
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%> 
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<%@ page import="java.util.*" %>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>

<%@page import="com.sinosoft.prpall.schema.PrpCvirturlItemSchema"%>
<%@page import="com.sinosoft.prpall.pubfun.GroupProposalService"%>
<html>
<head>
  <title>��������Ϣ��ʾ</title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0">
<form name="fm">
  <table class="common" cellpadding="5" cellspacing="1">
     
<%
           ArrayList beneInsuredList   = (ArrayList)request.getAttribute("beneInsuredList");
           String strRiskCode = (String)request.getAttribute("virturlRiskCode");
           if (beneInsuredList != null && beneInsuredList.size() > 0)
           {
        	   GroupProposalService groupProposalService = new GroupProposalService();
               //�Ƿ����ŵ��ı�־
              boolean VIRTUALITEM_RISK = groupProposalService.isGroupProposal(strRiskCode);   
        	   
        	   if(VIRTUALITEM_RISK){
        	       PrpCvirturlItemSchema prpCvirturlItemSchema  = (PrpCvirturlItemSchema) beneInsuredList.get(0);
                 int sequenceNo = 1;  
                 if(prpCvirturlItemSchema.getBenName()==null||prpCvirturlItemSchema.getBenName()=="")
                 {
                      
                    out.println("<tr><td colspan=14 class=common align=center>");
                    out.println("<font size=5>����������</font>");
                    out.println("</tr></td>");
                 } else {
%>

       <tr >
        <td class="prompttitle">���</td>
        <td class="prompttitle">����������</td>
        <td class="prompttitle">���֤��</td>
        <td class="prompttitle" style="display:none">�������</td>
      </tr> 
         <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <td class="prompt"><%= prpCvirturlItemSchema.getBenName() %></td>
          <td class="prompt"><%= prpCvirturlItemSchema.getBenIdentifyNumber() %></td>
          <td class="prompt" style="display:none">100%</td>
        </tr>
        <tr >
         <td colspan=4 class="prompttitle">�����˱�ע</td>
        </tr>
         <tr>        
          <td class="prompt" colspan=4><%= prpCvirturlItemSchema.getRemark() %></td>
        </tr>      
<%
                }
        	   }
        	   else{     		   
%>
     <tr >
        <td class="prompttitle">���</td>
        <td class="prompttitle">����������</td>
        <td class="prompttitle">���֤��</td>
        <td class="prompttitle">�������</td>
      </tr> 
 <%
		              for (int count = 0; count < beneInsuredList.size(); count++ )
		              {
		                 PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) beneInsuredList.get(count);
		                 int sequenceNo = count + 1;  
                
%>
        <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <td class="prompt"><%= prpCinsuredDto.getInsuredName() %></td>
          <td class="prompt"><%= prpCinsuredDto.getIdentifyNumber() %></td>
          <td class="prompt"><%= prpCinsuredDto.getBenefitRate() %></td>
        </tr>       
<%       	   
                   }
        	   }
           }
           else {
                out.println("<tr><td colspan=14 class=common align=center>");
                out.println("<font size=5>����������</font>");
                out.println("</tr></td>");
            }
 %> 
      <tr>  
        <td colspan=14 class="common" align="center">
          <input type=button name = 'button_Peril_Close_Context' class=button value='(O)�ر�'  ACCESSKEY="O" onclick="window.close()">  
        </td> 
      </tr>
  </table>        
</form>  
</body>
</html>
