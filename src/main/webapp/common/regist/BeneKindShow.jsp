<%--
****************************************************************************
* DESC       ：受益人信息显示画面
* AUTHOR     ： Sinosoft
* CREATEDATE ： 2005-08-04
* MODIFYLIST ：   Name       Date            Reason/Contents
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
  <title>险种保益信息显示</title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0">
<form name="fm">
  <table class="common" cellpadding="5" cellspacing="1">
      <tr >
        <td class="prompttitle">序号</td>
        <td class="prompttitle">险别代码</td>
        <td class="prompttitle">险别名称</td>
        <td class="prompttitle">方案类别</td>
        <td class="prompttitle">标的名细名称</td>
        <td class="prompttitle">币别</td>
        <td class="prompttitle">保险金额</td>
        <td class="prompttitle">保费</td>  
      </tr> 
      <%
           ArrayList beneKindList   = (ArrayList)request.getAttribute("beneKindList");
           String strRiskCode = (String)request.getAttribute("virturlRiskCode");
        
           String strKindCode ="";
           String strKindName ="";
           String strRationType =""; 
           String strItemDetailName ="";
           String strCurrency ="";
           String strAmount ="";
           String strPremium ="";
           
           if (beneKindList != null)
           {
        	   GroupProposalService groupProposalService = new GroupProposalService();
               //是否是团单的标志
              boolean VIRTUALITEM_RISK = groupProposalService.isGroupProposal(strRiskCode); 
        	   
        	     for (int count = 0; count < beneKindList.size(); count++ )
              {
            	 if(VIRTUALITEM_RISK) {
		        		   PrpCvirturlItemSchema prpCvirturlItemSchema = (PrpCvirturlItemSchema) beneKindList.get(count);
		        		   strKindCode        = prpCvirturlItemSchema.getKindCode();
		               strKindName        = prpCvirturlItemSchema.getKindName();
		               strRationType      = prpCvirturlItemSchema.getRationType();
		               strItemDetailName  = prpCvirturlItemSchema.getItemDetailName();
		               strCurrency        = prpCvirturlItemSchema.getCurrency();
		               strAmount          = prpCvirturlItemSchema.getAmount() ;
		               strPremium         = prpCvirturlItemSchema.getPremium();
        		   
            	 }else{
            		 
            		  PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) beneKindList.get(count);
            		  strKindCode         = prpCitemKindDto.getKindCode();
            		  strKindName         = prpCitemKindDto.getKindName();    
            		  strRationType       = "";
            		  strItemDetailName   = prpCitemKindDto.getItemDetailName();
            		  strCurrency         = prpCitemKindDto.getCurrency();
            		  strAmount           = ""+prpCitemKindDto.getAmount();
            		  strPremium          = ""+prpCitemKindDto.getPremium();

            	 }
            	  int sequenceNo = count + 1;  
                
        %>
        <tr>        
          <td class="prompt"><%= sequenceNo %></td> 
          <td class="prompt"><%= strKindCode %></td>
          <td class="prompt"><%= strKindName %></td>
          <td class="prompt"><%= strRationType %></td>
          <td class="prompt"><%= strItemDetailName %></td>
          <td class="prompt"><%= strCurrency %></td>
          <td class="prompt"><%= strAmount %></td>
          <td class="prompt"><%= strPremium %></td>
        </tr>       
        <%
              }
            }
         %> 
      <tr>  
        <td colspan=14 class="common" align="center">
          <input type=button name = 'button_Peril_Close_Context' class=button value='(O)关闭'  ACCESSKEY="O" onclick="window.close()">  
        </td> 
      </tr>
  </table>        
</form>  
</body>
</html>
